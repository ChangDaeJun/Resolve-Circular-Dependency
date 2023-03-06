package com.jsp.web.controller.user;

import com.jsp.web.controller.Controller;
import com.jsp.web.controller.ServiceController;
import com.jsp.web.service.ServiceMapping;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LogoutController extends ServiceController {
    public LogoutController(ServiceMapping serviceMapping) {
        super(serviceMapping);
    }

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        session.invalidate();

        return "index";
    }
}
