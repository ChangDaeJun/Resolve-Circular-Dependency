package com.jsp.biz.comment;

import com.jsp.biz.DomainDAO;
import com.jsp.database.DBController;
import com.jsp.database.DBExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommentDAO implements DomainDAO<CommentVO> {
    private static final String COMMENT_LIST = "select * from comments";
    private static final String COMMENT_INSERT = "insert into comments(userId, boardId, text) values(?, ?, ?)";
    private static final String COMMENT_UPDATE = "update comments set text = ? where id = ?";
    private static final String COMMENT_DELETE = "delete comments where id = ?";
    private static final String COMMENT_GET = "select * from comments where id = ?";
    private static final String COMMENT_LIST_BOARDID = "select * from comments where boardid = ?";

    @Override
    public List<CommentVO> getList() {
        List<CommentVO> comments = DBController.select(COMMENT_LIST, getAllExtractor());
        return comments;
    }

    @Override
    public void insert(CommentVO vo) {
        DBController.insert(COMMENT_INSERT, vo.getInsertValue());
    }

    @Override
    public void update(CommentVO vo) {
        DBController.update(COMMENT_UPDATE, vo.getUpdateValue());
    }

    @Override
    public void delete(CommentVO vo) {
        DBController.delete(COMMENT_DELETE, vo.getDeleteValue());
    }

    @Override
    public CommentVO findById(CommentVO vo) {
        List<CommentVO> comments = DBController.select(COMMENT_GET, getAllExtractor(), vo.getFindByIdValue());
        return comments.get(0);
    }

    public List<CommentVO> findByBoardId(CommentVO vo){
        List<CommentVO> comments = DBController.select(COMMENT_LIST_BOARDID, getAllExtractor(), vo.getFindByBoardIdValue());
        return comments;
    }

    @Override
    public DBExtractor<CommentVO> getAllExtractor() {
        return new DBExtractor<CommentVO>() {
            @Override
            public List<CommentVO> getList(ResultSet rs) throws SQLException {
                List<CommentVO> commentVOList = new ArrayList<>();

                while (rs.next()) {
                    CommentVO CommentVO = new CommentVO();
                    CommentVO.setId(rs.getLong("id"));
                    CommentVO.setUserId(rs.getLong("userid"));
                    CommentVO.setBoardId(rs.getLong("boardid"));
                    CommentVO.setText(rs.getString("text"));
                    CommentVO.setCreatedDate(rs.getDate("createddate"));
                    commentVOList.add(CommentVO);
                }

                return commentVOList;
            }
        };
    }
}
