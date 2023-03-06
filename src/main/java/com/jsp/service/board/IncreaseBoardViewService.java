package com.jsp.service.board;

import com.jsp.domain.board.BoardDAO;
import com.jsp.domain.board.BoardVO;

public class IncreaseBoardViewService {
    private IncreaseBoardViewService(){}
    private static class IncreaseBoardViewServiceHelper{
        private static final IncreaseBoardViewService INSTANCE = new IncreaseBoardViewService();
    }
    public static IncreaseBoardViewService getInstance(){
        return IncreaseBoardViewService.IncreaseBoardViewServiceHelper.INSTANCE;
    }

    public void run(BoardVO vo){
        BoardDAO boardDAO = new BoardDAO();
        boardDAO.increaseView(vo);
    }
}
