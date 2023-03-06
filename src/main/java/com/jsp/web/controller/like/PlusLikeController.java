package com.jsp.web.controller.like;

import com.jsp.biz.like.LikeDAO;
import com.jsp.biz.like.LikeVO;
import com.jsp.biz.user.UserVO;
import com.jsp.web.controller.Controller;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class PlusLikeController  implements Controller {


    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String boardId = request.getParameter("id");
        UserVO user = (UserVO) request.getSession().getAttribute("user");

        LikeVO likeVO = new LikeVO();
        likeVO.setUserId(user.getId());
        likeVO.setBoardId(Long.parseLong(boardId));
        LikeDAO likeDAO = new LikeDAO();
        likeDAO.insert(likeVO);

        return "getBoard.do?id=" + boardId;
    }
}
