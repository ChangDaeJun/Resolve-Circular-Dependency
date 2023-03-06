package com.jsp.web.controller.board;

import com.jsp.domain.user.UserVO;
import com.jsp.web.controller.Controller;
import com.jsp.service.board.GetBoardService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Map;

public class GetBoardController implements Controller {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        Long boardId = Long.parseLong(request.getParameter("id"));
        UserVO viewUser = (UserVO) request.getSession().getAttribute("user");

        Map<String, Object> map = GetBoardService.getInstance().run(boardId, viewUser);

        request.setAttribute("board", map.get("board"));
        request.setAttribute("like", map.get("like"));
        request.setAttribute("comments", map.get("comments"));

        return "GetBoard";
    }
}
