package com.jsp.service.board;

import com.jsp.domain.board.BoardDAO;
import com.jsp.domain.board.BoardVO;

public class DeleteBoardService{
    private DeleteBoardService(){}
    private static class DeleteBoardServiceHelper{
        private static final DeleteBoardService INSTANCE = new DeleteBoardService();
    }
    public static DeleteBoardService getInstance(){
        return DeleteBoardService.DeleteBoardServiceHelper.INSTANCE;
    }

    public void run(BoardVO vo) {
        BoardDAO boardDAO = new BoardDAO();
        boardDAO.delete(vo);
    }
}
