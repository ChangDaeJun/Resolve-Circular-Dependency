package com.jsp.web.service.comment;

import com.jsp.biz.comment.CommentDAO;
import com.jsp.biz.comment.CommentVO;
import com.jsp.biz.user.UserVO;
import com.jsp.web.service.user.FindUserByIdService;

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
