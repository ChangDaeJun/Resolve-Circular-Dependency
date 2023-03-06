package com.jsp.web.service.board;

import com.jsp.biz.board.BoardVO;
import com.jsp.biz.comment.CommentDAO;
import com.jsp.biz.comment.CommentVO;
import com.jsp.biz.like.LikeVO;
import com.jsp.biz.user.UserVO;
import com.jsp.web.service.comment.FindCommentListByBoardIdService;
import com.jsp.web.service.like.CheckLikedService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetBoardService{
    private GetBoardService(){}
    private static class GetBoardServiceHelper{
        private static final GetBoardService INSTANCE = new GetBoardService();
    }
    public static GetBoardService getInstance(){
        return GetBoardService.GetBoardServiceHelper.INSTANCE;
    }

    public Map<String, Object> run(Long boardId, UserVO viewUser) {
        //글 찾기
        BoardVO board = FindBoardByIdService.getInstance().run(boardId);

        //조회수 늘리기
        BoardVO increaseVO = getIncreaseViewBoardVO(board);
        IncreaseBoardViewService.getInstance().run(increaseVO);

        //글 보는 사람 좋아요 여부 찾기
        LikeVO likeVO = getLikedVO(viewUser, board);
        LikeVO like = CheckLikedService.getInstance().run(likeVO);

        //해당 글의 댓글 찾기
        CommentVO commentVO = getCommentVO(board);
        List<CommentVO> comments = FindCommentListByBoardIdService.getInstance().run(commentVO);

        return getMap(board, like, comments);
    }

    private static CommentVO getCommentVO(BoardVO board) {
        CommentVO commentVO = new CommentVO();
        commentVO.setBoardId(board.getId());
        CommentDAO commentDAO = new CommentDAO();
        return commentVO;
    }

    private static LikeVO getLikedVO(UserVO viewUser, BoardVO board) {
        LikeVO likeVO = new LikeVO();
        likeVO.setUserId(viewUser.getId());
        likeVO.setBoardId(board.getId());
        return likeVO;
    }

    private static Map<String, Object> getMap(BoardVO board, LikeVO like, List<CommentVO> comments) {
        Map<String, Object> map = new HashMap<>();
        map.put("board", board);
        map.put("like", like);
        map.put("comments", comments);
        return map;
    }

    private static BoardVO getIncreaseViewBoardVO(BoardVO board) {
        BoardVO increaseViewBoardVO = new BoardVO();
        increaseViewBoardVO.setId(board.getId());
        increaseViewBoardVO.setViewCnt(board.getViewCnt());
        return increaseViewBoardVO;
    }
}
