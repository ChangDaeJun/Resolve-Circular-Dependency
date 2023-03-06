package com.jsp.web.controller.board;

import com.jsp.biz.board.BoardDAO;
import com.jsp.biz.board.BoardVO;
import com.jsp.web.controller.Controller;
import com.jsp.web.controller.ServiceController;
import com.jsp.web.service.ServiceMapping;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UpdateBoardController  extends ServiceController {
    public UpdateBoardController(ServiceMapping serviceMapping) {
        super(serviceMapping);
    }

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
