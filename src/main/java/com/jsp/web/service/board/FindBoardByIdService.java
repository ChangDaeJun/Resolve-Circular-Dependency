package com.jsp.web.service.board;


import com.jsp.biz.board.BoardDAO;
import com.jsp.biz.board.BoardVO;

public class FindBoardByIdService {
    private FindBoardByIdService(){}
    private static class FindBoardByIdServiceHelper{
        private static final FindBoardByIdService INSTANCE = new FindBoardByIdService();
    }
    public static FindBoardByIdService getInstance(){
        return FindBoardByIdService.FindBoardByIdServiceHelper.INSTANCE;
    }

    public BoardVO run(Long id){
        BoardVO boardVO = new BoardVO();
        boardVO.setId(id);
        BoardDAO boardDAO = new BoardDAO();
        return boardDAO.findById(boardVO);
    }
}
