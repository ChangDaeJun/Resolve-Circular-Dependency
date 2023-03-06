package com.jsp.service.like;

import com.jsp.domain.like.LikeDAO;
import com.jsp.domain.like.LikeVO;

public class IncreaseLikeService {
    private IncreaseLikeService(){}
    private static class IncreaseLikeServiceHelper{
        private static final IncreaseLikeService INSTANCE = new IncreaseLikeService();
    }
    public static IncreaseLikeService getInstance(){
        return IncreaseLikeService.IncreaseLikeServiceHelper.INSTANCE;
    }

    public void run(LikeVO vo) {
        LikeDAO likeDAO = new LikeDAO();
        likeDAO.insert(vo);
    }
}
