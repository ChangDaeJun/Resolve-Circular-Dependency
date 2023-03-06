package com.jsp.service.board;

import com.jsp.domain.board.BoardDAO;
import com.jsp.domain.board.BoardVO;

public class WriteBoardService {
    private WriteBoardService(){}
    private static class WriteBoardServiceHelper{
        private static final WriteBoardService INSTANCE = new WriteBoardService();
    }
    public static WriteBoardService getInstance(){
        return WriteBoardService.WriteBoardServiceHelper.INSTANCE;
    }

    public void run(BoardVO boardVO) {
        BoardDAO boardDAO = new BoardDAO();
        boardDAO.insert(boardVO);
    }
}
