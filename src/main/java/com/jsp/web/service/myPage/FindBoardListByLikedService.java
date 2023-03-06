package com.jsp.web.service.myPage;

import com.jsp.biz.board.BoardVO;
import com.jsp.biz.like.LikeDAO;
import com.jsp.biz.like.LikeVO;
import com.jsp.web.service.board.FindBoardByIdService;
import com.jsp.web.service.like.FindLikeListByUserIdService;

import java.util.ArrayList;
import java.util.List;

public class FindBoardListByLikedService {
    private FindBoardListByLikedService(){}
    private static class FindBoardListByLikedHelper{
        private static final FindBoardListByLikedService INSTANCE = new FindBoardListByLikedService();
    }
    public static FindBoardListByLikedService getInstance(){
        return FindBoardListByLikedService.FindBoardListByLikedHelper.INSTANCE;
    }

    public List<BoardVO> run(Long id){
        List<LikeVO> likes = FindLikeListByUserIdService.getInstance().run(id);
        List<BoardVO> likeBoards = new ArrayList<>();
        for(LikeVO like : likes){
            BoardVO board = FindBoardByIdService.getInstance().run(like.getBoardId());
            likeBoards.add(board);
        }
        return likeBoards;
    }
}
