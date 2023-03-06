package com.jsp.service.board;

import com.jsp.domain.board.BoardDAO;
import com.jsp.domain.board.BoardVO;

public class UpdateBoardService{
    private UpdateBoardService(){}
    private static class UpdateBoardServiceHelper{
        private static final UpdateBoardService INSTANCE = new UpdateBoardService();
    }
    public static UpdateBoardService getInstance(){
        return UpdateBoardService.UpdateBoardServiceHelper.INSTANCE;
    }

    public void run(BoardVO vo) {
        BoardDAO boardDAO = new BoardDAO();
        boardDAO.update(vo);
    }
}
