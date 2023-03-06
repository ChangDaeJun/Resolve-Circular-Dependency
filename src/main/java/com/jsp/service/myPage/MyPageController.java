package com.jsp.service.myPage;

import com.jsp.domain.board.BoardVO;
import com.jsp.domain.comment.CommentVO;
import com.jsp.domain.user.UserVO;
import com.jsp.service.comment.FindCommentListByUserIdService;
import com.jsp.web.controller.Controller;
import com.jsp.service.board.FindBoardByUserIdService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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
