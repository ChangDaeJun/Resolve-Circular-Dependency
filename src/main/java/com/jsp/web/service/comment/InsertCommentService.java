package com.jsp.web.service.comment;

import com.jsp.biz.comment.CommentDAO;
import com.jsp.biz.comment.CommentVO;
import com.jsp.biz.user.UserVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class InsertCommentService {
    private InsertCommentService(){}
    private static class InsertCommentServiceHelper{
        private static final InsertCommentService INSTANCE = new InsertCommentService();
    }
    public static InsertCommentService getInstance(){
        return InsertCommentService.InsertCommentServiceHelper.INSTANCE;
    }
    

    public void run(CommentVO vo) {
        CommentDAO commentDAO = new CommentDAO();
        commentDAO.insert(vo);
    }
}
