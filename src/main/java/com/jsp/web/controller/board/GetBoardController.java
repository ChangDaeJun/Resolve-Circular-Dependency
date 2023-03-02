package com.jsp.web.controller.board;

import com.jsp.biz.board.BoardDAO;
import com.jsp.biz.board.BoardVO;
import com.jsp.biz.like.LikeDAO;
import com.jsp.biz.like.LikeVO;
import com.jsp.biz.user.UserDAO;
import com.jsp.biz.user.UserVO;
import com.jsp.web.controller.Controller;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.h2.engine.User;

public class GetBoardController implements Controller {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String boardId = request.getParameter("id");
        UserVO viewUser = (UserVO) request.getSession().getAttribute("user");

        //해당 글 찾기
        BoardVO boardVO = new BoardVO();
        boardVO.setId(Long.parseLong(boardId));
        BoardDAO boardDAO = new BoardDAO();
        BoardVO board = boardDAO.findById(boardVO);

        //조회수 늘리기
        BoardVO updateViewCnt = new BoardVO();
        updateViewCnt.setId(board.getId());
        updateViewCnt.setViewCnt(board.getViewCnt());
        BoardDAO boardDAO1 = new BoardDAO();
        boardDAO1.increaseView(updateViewCnt);

        //작성자 찾기
        UserVO userVO = new UserVO();
        userVO.setId(board.getUserId());
        UserDAO userDAO = new UserDAO();
        UserVO createUser = userDAO.findById(userVO);
        board.setUserName(createUser.getName());

        //글 보는 사람 좋아요 여부 찾기
        LikeVO likeVO = new LikeVO();
        likeVO.setUserId(viewUser.getId());
        likeVO.setBoardId(board.getId());
        LikeDAO likeDAO = new LikeDAO();
        LikeVO like = likeDAO.findByUserIdAndBoardId(likeVO);

        //글 넘기기
        request.setAttribute("board", board);

        //좋아요 여부 넘기기
        request.setAttribute("like", like);
        return "GetBoard";
    }
}
