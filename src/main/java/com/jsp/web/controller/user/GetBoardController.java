package com.jsp.web.controller.user;

import com.jsp.biz.board.BoardDAO;
import com.jsp.biz.board.BoardVO;
import com.jsp.biz.user.UserDAO;
import com.jsp.biz.user.UserVO;
import com.jsp.web.controller.Controller;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GetBoardController implements Controller {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");

        BoardVO boardVO = new BoardVO();
        boardVO.setId(Long.parseLong(id));

        BoardDAO boardDAO = new BoardDAO();
        BoardVO board = boardDAO.findById(boardVO);

        UserVO userVO = new UserVO();
        userVO.setId(board.getUserId());

        UserDAO userDAO = new UserDAO();
        UserVO createUser = userDAO.findById(userVO);

        board.setUserName(createUser.getName());

        request.setAttribute("board", board);
        return "GetBoard";
    }
}
