package com.jsp.service.board;


import com.jsp.domain.board.BoardDAO;
import com.jsp.domain.board.BoardVO;

import java.util.List;

public class FindBoardByUserIdService {
    private FindBoardByUserIdService(){}
    private static class FindBoardByUserIdServiceHelper{
        private static final FindBoardByUserIdService INSTANCE = new FindBoardByUserIdService();
    }
    public static FindBoardByUserIdService getInstance(){
        return FindBoardByUserIdService.FindBoardByUserIdServiceHelper.INSTANCE;
    }

    public List<BoardVO> run(Long id){
        BoardVO boardVO = new BoardVO();
        boardVO.setUserId(id);
        BoardDAO boardDAO = new BoardDAO();
        List<BoardVO> boards = (List<BoardVO>) boardDAO.findByUserId(boardVO);
        return boards;
    }
}
