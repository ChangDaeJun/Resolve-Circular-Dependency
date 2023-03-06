package com.jsp.web.service.board;

import com.jsp.biz.board.BoardDAO;
import com.jsp.biz.board.BoardVO;

public class DeleteBoardService{
    private DeleteBoardService(){}
    private static class DeleteBoardServiceHelper{
        private static final DeleteBoardService INSTANCE = new DeleteBoardService();
    }
    public static DeleteBoardService getInstance(){
        return DeleteBoardService.DeleteBoardServiceHelper.INSTANCE;
    }

    public boolean run(BoardVO vo) {
        BoardDAO boardDAO = new BoardDAO();
        boardDAO.delete(vo);
    }
}
