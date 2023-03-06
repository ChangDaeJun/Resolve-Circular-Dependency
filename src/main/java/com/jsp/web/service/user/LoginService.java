package com.jsp.web.service.user;

import com.jsp.biz.user.UserDAO;
import com.jsp.biz.user.UserVO;
import com.jsp.web.controller.Controller;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginService{
    private LoginService(){}
    private static class LoginServiceHelper{
        private static final LoginService INSTANCE = new LoginService();
    }
    public static LoginService getInstance(){
        return LoginService.LoginServiceHelper.INSTANCE;
    }

    public UserVO run(UserVO vo) {
        UserVO user = CheckEmailAndPasswordService.getInstance().run(vo.getEmail(), vo.getPassword());

        return user;
    }
}
