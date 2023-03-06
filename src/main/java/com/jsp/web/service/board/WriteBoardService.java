package com.jsp.web.service.board;

import com.jsp.biz.board.BoardDAO;
import com.jsp.biz.board.BoardVO;
import com.jsp.biz.user.UserVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

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
