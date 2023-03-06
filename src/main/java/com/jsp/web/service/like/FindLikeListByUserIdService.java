package com.jsp.web.service.like;

import com.jsp.biz.like.LikeDAO;
import com.jsp.biz.like.LikeVO;

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
