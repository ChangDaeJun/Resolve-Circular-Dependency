package com.jsp.web.controller;

import com.jsp.web.controller.board.*;
import com.jsp.web.controller.comment.InsertCommentController;
import com.jsp.web.controller.like.MinusLikeController;
import com.jsp.web.controller.like.PlusLikeController;
import com.jsp.web.controller.myPage.MyPageController;
import com.jsp.web.controller.user.*;
import com.jsp.web.service.ServiceMapping;

import java.util.HashMap;
import java.util.Map;

public class HandlerMapping {
    private Map<String, Controller> mappings;
    private final ServiceMapping serviceMapping;

    public HandlerMapping() {
        this.mappings = new HashMap<>();
        this.serviceMapping = new ServiceMapping();

        //view controller
        mappings.put("/insertUserView.do" , new InsertUserViewController());
        mappings.put("/loginUserView.do", new LoginUserViewController());
        mappings.put("/insertBoardView.do", new InsertBoardViewController());

        //service controller
        mappings.put("/insertUser.do", new InsertUserController(serviceMapping));
        mappings.put("/loginUser.do", new LoginUserController(serviceMapping));
        mappings.put("/getBoardList.do", new GetBoardListController(serviceMapping));
        mappings.put("/getBoard.do", new GetBoardController(serviceMapping));
        mappings.put("/insertBoard.do", new InsertBoardController(serviceMapping));
        mappings.put("/updateBoard.do", new UpdateBoardController(serviceMapping));
        mappings.put("/deleteBoard.do", new DeleteBoardController(serviceMapping));
        mappings.put("/logout.do", new LogoutController(serviceMapping));
        mappings.put("/plusLike.do", new PlusLikeController(serviceMapping));
        mappings.put("/minusLike.do", new MinusLikeController(serviceMapping));
        mappings.put("/insertComment.do", new InsertCommentController(serviceMapping));
        mappings.put("/myPage.do", new MyPageController(serviceMapping));
    }

    public Controller getController(String path){
        return mappings.get(path);
    }
}
