package com.jsp.web.controller.comment;

import com.jsp.domain.comment.CommentVO;
import com.jsp.domain.user.UserVO;
import com.jsp.web.controller.Controller;
import com.jsp.service.comment.InsertCommentService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class InsertCommentController implements Controller {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String boardId = request.getParameter("id");

        CommentVO insertCommentVO = getInsertCommentVO(request);
        InsertCommentService.getInstance().run(insertCommentVO);

        return "getBoard.do?id" + boardId;
    }

    private static CommentVO getInsertCommentVO(HttpServletRequest request) {
        UserVO createUSer = (UserVO) request.getSession().getAttribute("user");
        String text = request.getParameter("text");
        String boardId = request.getParameter("id");
        CommentVO commentVO = new CommentVO();
        commentVO.setUserId(createUSer.getId());
        commentVO.setBoardId(Long.parseLong(boardId));
        commentVO.setText(text);
        return commentVO;
    }
}
