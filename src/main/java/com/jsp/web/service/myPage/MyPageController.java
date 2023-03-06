package com.jsp.web.service.myPage;

import com.jsp.biz.board.BoardDAO;
import com.jsp.biz.board.BoardVO;
import com.jsp.biz.comment.CommentDAO;
import com.jsp.biz.comment.CommentVO;
import com.jsp.biz.like.LikeDAO;
import com.jsp.biz.like.LikeVO;
import com.jsp.biz.user.UserVO;
import com.jsp.web.controller.Controller;
import com.jsp.web.service.board.FindBoardByUserIdService;
import com.jsp.web.service.comment.FindCommentListByUserIdService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.List;

public class MyPageController implements Controller {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        UserVO user = (UserVO) request.getSession().getAttribute("user");

        List<BoardVO> createBoards = FindBoardByUserIdService.getInstance().run(user.getId());
        List<BoardVO> likeBoards = FindBoardListByLikedService.getInstance().run(user.getId());
        List<CommentVO> createComments = FindCommentListByUserIdService.getInstance().run(user.getId());

        request.setAttribute("createBoards", createBoards);
        request.setAttribute("likeBoards", likeBoards);
        request.setAttribute("createComments", createComments);

        return "MyPage";
    }
}
