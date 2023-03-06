package com.jsp.web.controller;

import com.jsp.web.controller.board.*;
import com.jsp.web.controller.comment.InsertCommentController;
import com.jsp.web.controller.like.MinusLikeController;
import com.jsp.web.controller.like.PlusLikeController;
import com.jsp.web.controller.user.*;
import com.jsp.web.service.ServiceMapping;

import java.util.HashMap;
import java.util.Map;

public class HandlerMapping {
    private Map<String, Controller> mappings;

    public HandlerMapping() {
        this.mappings = new HashMap<>();

        //view controller
        mappings.put("/insertUserView.do" , new InsertUserViewController());
        mappings.put("/loginUserView.do", new LoginUserViewController());
        mappings.put("/insertBoardView.do", new InsertBoardViewController());
        mappings.put("/insertBoard.do", new InsertBoardController());
        mappings.put("/updateBoard.do", new UpdateBoardController());
        mappings.put("/deleteBoard.do", new DeleteBoardController());
        mappings.put("/logout.do", new LogoutController());
        mappings.put("/plusLike.do", new PlusLikeController());
        mappings.put("/minusLike.do", new MinusLikeController());
        mappings.put("/insertComment.do", new InsertCommentController());
    }

    public Controller getController(String path){
        return mappings.get(path);
    }
}
