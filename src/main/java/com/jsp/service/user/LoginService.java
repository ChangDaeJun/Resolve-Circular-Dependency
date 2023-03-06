package com.jsp.service.user;

import com.jsp.domain.user.UserVO;

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
