package com.jsp.web.controller.myPage;

import com.jsp.domain.board.BoardDAO;
import com.jsp.domain.board.BoardVO;
import com.jsp.domain.comment.CommentDAO;
import com.jsp.domain.comment.CommentVO;
import com.jsp.domain.like.LikeDAO;
import com.jsp.domain.like.LikeVO;
import com.jsp.domain.user.UserVO;
import com.jsp.web.controller.Controller;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.List;

public class MyPageController implements Controller {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        UserVO user = (UserVO) request.getSession().getAttribute("user");

        BoardVO boardVO = new BoardVO();
        boardVO.setUserId(user.getId());
        BoardDAO boardDAO = new BoardDAO();
        List<BoardVO> createBoards = (List<BoardVO>) boardDAO.findByUserId(boardVO);

        LikeVO likeVO = new LikeVO();
        likeVO.setUserId(user.getId());
        LikeDAO likeDAO = new LikeDAO();
        List<LikeVO> likes = likeDAO.findByUserId(likeVO);
        List<BoardVO> likeBoards = new ArrayList<>();
        for(LikeVO like : likes){
            BoardVO boardVO1 = new BoardVO();
            boardVO1.setId(like.getBoardId());
            likeBoards.add(boardDAO.findById(boardVO1));
        }

        CommentVO commentVO = new CommentVO();
        commentVO.setUserId(user.getId());
        CommentDAO commentDAO = new CommentDAO();
        List<CommentVO> createComments = commentDAO.findByUserId(commentVO);

        request.setAttribute("createBoards", createBoards);
        request.setAttribute("likeBoards", likeBoards);
        request.setAttribute("createComments", createComments);

        return "MyPage";
    }
}
