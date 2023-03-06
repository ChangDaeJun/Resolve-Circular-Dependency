package com.jsp.web.controller.myPage;

import com.jsp.biz.board.BoardDAO;
import com.jsp.biz.board.BoardVO;
import com.jsp.biz.comment.CommentDAO;
import com.jsp.biz.comment.CommentVO;
import com.jsp.biz.like.LikeDAO;
import com.jsp.biz.like.LikeVO;
import com.jsp.biz.user.UserVO;
import com.jsp.web.controller.Controller;
import com.jsp.web.controller.ServiceController;
import com.jsp.web.service.ServiceMapping;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.List;

public class MyPageController implements Controller{

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
