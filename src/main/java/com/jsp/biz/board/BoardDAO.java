package com.jsp.biz.board;

import com.jsp.biz.DomainDAO;
import com.jsp.database.DBController;
import com.jsp.database.DBExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO implements DomainDAO<BoardVO> {
    private static final String BOARD_LIST = "select * from boards";
    private static final String BOARD_INSERT = "insert into boards(userId, title, text, role, viewCnt) values(?, ?, ?, ?, ?)";
    private static final String BOARD_UPDATE = "update boards set title = ?, text = ? where id = ?";
    private static final String BOARD_INCREASE_VIEW = "update boards set viewcnt = ? where id = ?";
    private static final String BOARD_DELETE = "delete boards where id = ?";
    private static final String BOARD_GET = "select * from boards where id = ?";
    @Override
    public List<BoardVO> getList() {
        List<BoardVO> boards = DBController.select(BOARD_LIST, getAllExtractor());
        return boards;
    }

    @Override
    public void insert(BoardVO vo) {
        DBController.insert(BOARD_INSERT, vo.getInsertValue());
    }

    @Override
    public void update(BoardVO vo) {
        DBController.update(BOARD_UPDATE, vo.getUpdateValue());
    }

    public void increaseView(BoardVO vo){
        DBController.update(BOARD_INCREASE_VIEW, vo.getIncreaseViewValue());
    }
    @Override
    public void delete(BoardVO vo) {
        DBController.delete(BOARD_DELETE, vo.getDeleteValue());
    }

    @Override
    public BoardVO findById(BoardVO vo) {
        List<BoardVO> boards = DBController.select(BOARD_GET, getAllExtractor(), vo.getFindByIdValue());
        return boards.get(0);
    }

    @Override
    public DBExtractor<BoardVO> getAllExtractor() {
        return new DBExtractor<BoardVO>() {
            @Override
            public List<BoardVO> getList(ResultSet rs) throws SQLException {
                List<BoardVO> BoardVOList = new ArrayList<>();

                while (rs.next()) {
                    BoardVO BoardVO = new BoardVO();
                    BoardVO.setId(rs.getLong("id"));
                    BoardVO.setUserId(rs.getLong("userid"));
                    BoardVO.setTitle(rs.getString("title"));
                    BoardVO.setText(rs.getString("text"));
                    BoardVO.setRole(rs.getString("role"));
                    BoardVO.setViewCnt(rs.getLong("viewcnt"));
                    BoardVO.setCreatedDate(rs.getDate("createddate"));
                    BoardVOList.add(BoardVO);
                }

                return BoardVOList;
            }
        };
    }
}
