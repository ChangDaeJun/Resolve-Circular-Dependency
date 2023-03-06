package com.jsp.service.like;

import com.jsp.domain.like.LikeDAO;
import com.jsp.domain.like.LikeVO;

import java.util.List;


public class FindLikeListByUserIdService {
    private FindLikeListByUserIdService(){}
    private static class FindLikeListByUserIdServiceHelper{
        private static final FindLikeListByUserIdService INSTANCE = new FindLikeListByUserIdService();
    }
    public static FindLikeListByUserIdService getInstance(){
        return FindLikeListByUserIdService.FindLikeListByUserIdServiceHelper.INSTANCE;
    }

    public List<LikeVO> run(Long id){
        LikeVO likeVO = new LikeVO();
        likeVO.setUserId(id);
        LikeDAO likeDAO = new LikeDAO();
        return  likeDAO.findByUserId(likeVO);
    }
}
