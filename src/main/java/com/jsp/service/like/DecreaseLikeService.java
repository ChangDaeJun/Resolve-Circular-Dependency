package com.jsp.service.like;

import com.jsp.domain.like.LikeDAO;
import com.jsp.domain.like.LikeVO;

public class DecreaseLikeService {
    private DecreaseLikeService(){}
    private static class DecreaseLikeServiceHelper{
        private static final DecreaseLikeService INSTANCE = new DecreaseLikeService();
    }
    public static DecreaseLikeService getInstance(){
        return DecreaseLikeService.DecreaseLikeServiceHelper.INSTANCE;
    }

    public void run(LikeVO vo) {
        LikeDAO likeDAO = new LikeDAO();
        LikeVO deleteVO = likeDAO.findByUserIdAndBoardId(vo);
        likeDAO.delete(deleteVO);
    }
}
