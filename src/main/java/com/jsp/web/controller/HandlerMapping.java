package com.jsp.web.controller;

import com.jsp.web.controller.user.*;

import java.util.HashMap;
import java.util.Map;

public class HandlerMapping {
    private Map<String, Controller> mappings;

    public HandlerMapping() {
        this.mappings = new HashMap<>();
        mappings.put("/insertUserView.do" , new InsertUserViewController());
        mappings.put("/insertUser.do", new InsertUserController());
        mappings.put("/loginUser.do", new LoginUserController());
        mappings.put("/loginUserView.do", new LoginUserViewController());
        mappings.put("/getBoardList.do", new GetBoardListController());
        mappings.put("/getBoard.do", new GetBoardController());
        mappings.put("/insertBoardView.do", new InsertBoardViewController());
        mappings.put("/insertBoard.do", new InsertBoardController());
//        mappings.put("/updateBoard.do", new UpdateBoardController());
//        mappings.put("/deleteBoard.do", new DeleteBoardController());
//        mappings.put("/logout.do", new LogoutController());
    }

    public Controller getController(String path){
        return mappings.get(path);
    }
}
