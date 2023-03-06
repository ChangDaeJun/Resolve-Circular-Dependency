package com.jsp.service.comment;

import com.jsp.domain.comment.CommentDAO;
import com.jsp.domain.comment.CommentVO;

import java.util.List;

public class FindCommentListByUserIdService {
    private FindCommentListByUserIdService(){}
    private static class FindCommentListByUserIdServiceHelper{
        private static final FindCommentListByUserIdService INSTANCE = new FindCommentListByUserIdService();
    }
    public static FindCommentListByUserIdService getInstance(){
        return FindCommentListByUserIdService.FindCommentListByUserIdServiceHelper.INSTANCE;
    }

    public List<CommentVO> run(Long id) {
        CommentVO commentVO = new CommentVO();
        commentVO.setUserId(id);
        CommentDAO commentDAO = new CommentDAO();
        List<CommentVO> comments = commentDAO.findByUserId(commentVO);
        return comments;
    }
}
