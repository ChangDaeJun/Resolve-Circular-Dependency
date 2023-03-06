package com.jsp.service.comment;

import com.jsp.domain.comment.CommentDAO;
import com.jsp.domain.comment.CommentVO;

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
