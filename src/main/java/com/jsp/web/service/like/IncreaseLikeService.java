package com.jsp.web.service.like;

import com.jsp.biz.like.LikeDAO;
import com.jsp.biz.like.LikeVO;
import com.jsp.biz.user.UserVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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
