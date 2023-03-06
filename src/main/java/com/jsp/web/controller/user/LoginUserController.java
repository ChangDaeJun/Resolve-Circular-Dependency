package com.jsp.web.controller.user;

import com.jsp.biz.user.UserDAO;
import com.jsp.biz.user.UserVO;
import com.jsp.web.controller.Controller;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginUserController  implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UserVO userVO = new UserVO();
        userVO.setEmail(email);

        UserDAO userDAO = new UserDAO();
        UserVO user = userDAO.findByEmail(userVO);

        HttpSession session = request.getSession();

        if(user != null && user.getPassword().equals(password)){
            session.setAttribute("user", user);
            return "getBoardList.do";
        }else {
            return "loginUserView.do";
        }
    }
}
