package com.jsp.web.controller.user;

import com.jsp.biz.board.BoardDAO;
import com.jsp.biz.board.BoardVO;
import com.jsp.web.controller.Controller;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.util.List;

public class GetBoardListController implements Controller {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
            BoardDAO boardDAO = new BoardDAO();
            List<BoardVO> boardVOList = boardDAO.getList();
            request.setAttribute("boardList", boardVOList);

            return "GetBoardList";
    }
}
