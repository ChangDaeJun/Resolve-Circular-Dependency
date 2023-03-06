package com.jsp.web.controller.board;

import com.jsp.biz.board.BoardVO;
import com.jsp.biz.user.UserVO;
import com.jsp.web.controller.Controller;
import com.jsp.web.service.board.GetBoardService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.h2.engine.User;

import java.util.List;
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
