package com.jsp.web.controller.comment;

import com.jsp.biz.comment.CommentDAO;
import com.jsp.biz.comment.CommentVO;
import com.jsp.biz.user.UserVO;
import com.jsp.web.controller.Controller;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.h2.engine.User;

public class InsertCommentController implements Controller {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        UserVO createUSer = (UserVO) request.getSession().getAttribute("user");
        String text = request.getParameter("text");
        String boardId = request.getParameter("id");

        CommentVO commentVO = new CommentVO();
        commentVO.setUserId(createUSer.getId());
        commentVO.setBoardId(Long.parseLong(boardId));
        commentVO.setText(text);
        CommentDAO commentDAO = new CommentDAO();
        commentDAO.insert(commentVO);

        return "getBoard.do?id" + boardId;
    }
}
