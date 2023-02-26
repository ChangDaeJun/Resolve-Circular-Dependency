package com.jsp.web.controller.board;

import com.jsp.biz.board.BoardDAO;
import com.jsp.biz.board.BoardVO;
import com.jsp.web.controller.Controller;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UpdateBoardController implements Controller {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        BoardVO boardVO = new BoardVO();
        boardVO.setId(Long.parseLong(request.getParameter("id")));
        boardVO.setText(request.getParameter("text"));
        boardVO.setTitle(request.getParameter("title"));

        BoardDAO boardDAO = new BoardDAO();
        boardDAO.update(boardVO);

        return "getBoardList.do";
    }
}
