package com.jsp.web.controller.like;

import com.jsp.domain.like.LikeVO;
import com.jsp.domain.user.UserVO;
import com.jsp.web.controller.Controller;
import com.jsp.service.like.DecreaseLikeService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MinusLikeController implements Controller {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        Long boardId = Long.parseLong(request.getParameter("id"));
        LikeVO decreaseLikeVO = getDecreaseLikeVO(request);
        DecreaseLikeService.getInstance().run(decreaseLikeVO);

        return "getBoard.do?id=" + boardId;
    }

    private static LikeVO getDecreaseLikeVO(HttpServletRequest request) {
        Long boardId = Long.parseLong(request.getParameter("id"));
        Long userId = ((UserVO) request.getSession().getAttribute("user")).getId();
        LikeVO likeVO = new LikeVO();
        likeVO.setUserId(userId);
        likeVO.setBoardId(boardId);
        return likeVO;
    }
}
