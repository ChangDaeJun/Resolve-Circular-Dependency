package com.jsp.web.controller.board;

import com.jsp.biz.board.BoardDAO;
import com.jsp.biz.board.BoardVO;
import com.jsp.biz.user.UserVO;
import com.jsp.web.controller.Controller;
import com.jsp.web.controller.ServiceController;
import com.jsp.web.service.ServiceMapping;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class InsertBoardController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        //세션 통해서 유저 정보 획득
        HttpSession session = request.getSession();
        UserVO user = (UserVO) session.getAttribute("user");

        String title = request.getParameter("title");
        String text = request.getParameter("text");

        BoardVO boardVO = new BoardVO();
        boardVO.setTitle(title);
        boardVO.setUserId(user.getId());
        boardVO.setText(text);
        boardVO.setRole(user.getRole());
        boardVO.setViewCnt(0L);

        BoardDAO boardDAO = new BoardDAO();
        boardDAO.insert(boardVO);

        return "getBoardList.do";
    }
}
