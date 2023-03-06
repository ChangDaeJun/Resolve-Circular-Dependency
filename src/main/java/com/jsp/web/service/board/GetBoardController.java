package com.jsp.web.service.board;

import com.jsp.biz.board.BoardDAO;
import com.jsp.biz.board.BoardVO;
import com.jsp.biz.comment.CommentDAO;
import com.jsp.biz.comment.CommentVO;
import com.jsp.biz.like.LikeDAO;
import com.jsp.biz.like.LikeVO;
import com.jsp.biz.user.UserDAO;
import com.jsp.biz.user.UserVO;
import com.jsp.web.controller.Controller;
import com.jsp.web.service.user.FindUserByIdService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

public class GetBoardController implements Controller {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        Long boardId = Long.parseLong(request.getParameter("id"));
        UserVO viewUser = (UserVO) request.getSession().getAttribute("user");

        //글 찾기
        BoardVO board = FindBoardByIdService.getInstance().run(boardId);

        //조회수 늘리기
        BoardVO increaseVO = getIncreaseViewBoardVO(board);
        IncreaseBoardViewService.getInstance().run(increaseVO);

        //작성자 이름 추가
        UserVO createUser = FindUserByIdService.getInstance().run(board.getUserId());
        board.setUserName(createUser.getName());

        //글 보는 사람 좋아요 여부 찾기
        LikeVO likeVO = new LikeVO();
        likeVO.setUserId(viewUser.getId());
        likeVO.setBoardId(board.getId());
        LikeDAO likeDAO = new LikeDAO();
        LikeVO like = likeDAO.findByUserIdAndBoardId(likeVO);

        //해당 글의 댓글 찾기
        CommentVO commentVO = new CommentVO();
        commentVO.setBoardId(board.getId());
        CommentDAO commentDAO = new CommentDAO();
        List<CommentVO> comments = commentDAO.findByBoardId(commentVO);

        for(CommentVO comment : comments){
            UserVO userVO = new UserVO();
            userVO.setId(comment.getUserId());
            UserDAO userDAO1 = new UserDAO();
            UserVO createCommentUser = userDAO1.findById(userVO);
            comment.setUserName(createCommentUser.getName());
        }

        request.setAttribute("board", board);
        request.setAttribute("like", like);
        request.setAttribute("comments", comments);

        return "GetBoard";
    }

    private static BoardVO getIncreaseViewBoardVO(BoardVO board) {
        BoardVO increaseViewBoardVO = new BoardVO();
        increaseViewBoardVO.setId(board.getId());
        increaseViewBoardVO.setViewCnt(board.getViewCnt());
        return increaseViewBoardVO;
    }
}
