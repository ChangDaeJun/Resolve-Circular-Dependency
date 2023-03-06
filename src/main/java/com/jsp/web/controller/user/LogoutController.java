package com.jsp.web.controller.user;

import com.jsp.web.controller.Controller;
import com.jsp.web.controller.ServiceController;
import com.jsp.web.service.ServiceMapping;
import com.jsp.web.service.user.LogoutService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LogoutController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        LogoutService.getInstance().run();

        HttpSession session = request.getSession();
        session.invalidate();
        return "index";
    }
}
