package com.jsp.web.service;

import com.jsp.web.controller.Controller;
import com.jsp.web.controller.board.*;
import com.jsp.web.controller.comment.InsertCommentController;
import com.jsp.web.controller.like.MinusLikeController;
import com.jsp.web.controller.like.PlusLikeController;
import com.jsp.web.controller.myPage.MyPageController;
import com.jsp.web.controller.user.*;

import java.util.HashMap;
import java.util.Map;

public class ServiceMapping {
    private Map<String, Controller> mappings;

    public ServiceMapping() {
        this.mappings = new HashMap<>();
    }

    public Controller getController(String name){
        return mappings.get(name);
    }
}
