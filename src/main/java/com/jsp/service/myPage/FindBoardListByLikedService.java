package com.jsp.service.myPage;

import com.jsp.domain.board.BoardVO;
import com.jsp.domain.like.LikeVO;
import com.jsp.service.board.FindBoardByIdService;
import com.jsp.service.like.FindLikeListByUserIdService;

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
