package com.jsp.web.controller.user;

import com.jsp.web.controller.Controller;
<<<<<<< HEAD
import com.jsp.web.controller.ServiceController;
import com.jsp.web.service.ServiceMapping;
import com.jsp.web.service.user.LogoutService;
=======
>>>>>>> parent of 81d5ee6 (refactor : 유저 기능 컨트롤러에서 서비스로 이전)
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LogoutController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        session.invalidate();

        return "index";
    }
}
