package com.jsp.web.service.board;

import com.jsp.biz.board.BoardDAO;
import com.jsp.biz.board.BoardVO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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
