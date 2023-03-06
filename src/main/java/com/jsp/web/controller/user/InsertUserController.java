package com.jsp.web.controller.user;

import com.jsp.biz.user.UserDAO;
import com.jsp.biz.user.UserVO;
import com.jsp.web.controller.Controller;
import com.jsp.web.controller.ServiceController;
import com.jsp.web.service.ServiceMapping;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class InsertUserController  extends ServiceController {
    public InsertUserController(ServiceMapping serviceMapping) {
        super(serviceMapping);
    }

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        UserVO userVO = new UserVO();
        userVO.setName(request.getParameter("name"));
        userVO.setEmail(request.getParameter("email"));
        userVO.setPassword(request.getParameter("password"));
        userVO.setRole(request.getParameter("role"));

        UserDAO userDAO = new UserDAO();
        userDAO.insert(userVO);

        return "index";
    }
}
