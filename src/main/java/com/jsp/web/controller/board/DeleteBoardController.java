package com.jsp.web.controller.board;

import com.jsp.biz.board.BoardDAO;
import com.jsp.biz.board.BoardVO;
import com.jsp.web.controller.Controller;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteBoardController implements Controller {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");

        BoardVO boardVO = new BoardVO();
        boardVO.setId(Long.parseLong(id));

        BoardDAO boardDAO = new BoardDAO();
        boardDAO.delete(boardVO);

        return "getBoardList.do";
    }
}
