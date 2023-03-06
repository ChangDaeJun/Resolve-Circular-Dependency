package com.jsp.domain.like;

import com.jsp.domain.DomainDAO;
import com.jsp.database.DBController;
import com.jsp.database.DBExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LikeDAO implements DomainDAO<LikeVO> {
    private static final String LIKE_LIST = "select * from likes";
    private static final String LIKE_INSERT = "insert into likes(userId, boardId) values(?, ?)";
    private static final String LIKE_UPDATE = "";
    private static final String LIKE_DELETE = "delete likes where id = ?";
    private static final String LIKE_GET = "select * from likes where id = ?";
    private static final String LIKE_GET_USERID_AND_BOARDID = "select * from likes where userid = ? AND boardId = ?";
    private static final String LIKE_LIST_USERID = "select * from likes where userid = ?";

    @Override
    public List<LikeVO> getList() {
        List<LikeVO> likeVOList = (List<LikeVO>) DBController.select(LIKE_LIST, getAllExtractor());
        return likeVOList;
    }

    @Override
    public void insert(LikeVO vo) {
        DBController.insert(LIKE_INSERT, vo.getInsertValue());
    }

    @Override
    public void update(LikeVO vo) {
        //DBController.update(LIKE_UPDATE, vo.getInsertValue());
    }

    @Override
    public void delete(LikeVO vo) {
        DBController.delete(LIKE_DELETE, vo.getDeleteValue());
    }

    @Override
    public LikeVO findById(LikeVO vo) {
        List<LikeVO> list = (List<LikeVO>) DBController.select(LIKE_GET, getAllExtractor() ,vo.getFindByIdValue());
        return list.get(0);
    }

    public List<LikeVO> findByUserId(LikeVO vo) {
        List<LikeVO> likeVOList = (List<LikeVO>) DBController.select(LIKE_LIST_USERID, getAllExtractor(), vo.getFindByUserIdValue());
        return likeVOList;
    }

    public LikeVO findByUserIdAndBoardId(LikeVO vo) {
        List<LikeVO> list = (List<LikeVO>) DBController.select(LIKE_GET_USERID_AND_BOARDID, getAllExtractor() ,vo.getFindByUserIdAndBoardIdValue());
        if(list.size() == 0) return null;
        else return list.get(0);
    }

    @Override
    public DBExtractor<LikeVO> getAllExtractor() {
        return new DBExtractor<LikeVO>() {
            @Override
            public List<LikeVO> getList(ResultSet rs) throws SQLException {
                List<LikeVO> likeVOList = new ArrayList<>();

                while (rs.next()) {
                    LikeVO likeVO = new LikeVO();
                    likeVO.setId(rs.getLong("id"));
                    likeVO.setUserId(rs.getLong("userid"));
                    likeVO.setBoardId(rs.getLong("boardid"));
                    likeVO.setLikedDate(rs.getDate("likeddate"));
                    likeVOList.add(likeVO);
                }

                return likeVOList;
            }
        };
    }
}
