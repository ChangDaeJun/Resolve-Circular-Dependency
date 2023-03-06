package com.jsp.service.user;

import com.jsp.domain.user.UserDAO;
import com.jsp.domain.user.UserVO;

public class CheckEmailAndPasswordService {
    private CheckEmailAndPasswordService(){}
    private static class checkEmailAndPasswordServiceHelper{
        private static final CheckEmailAndPasswordService INSTANCE = new CheckEmailAndPasswordService();
    }
    public static CheckEmailAndPasswordService getInstance(){
        return CheckEmailAndPasswordService.checkEmailAndPasswordServiceHelper.INSTANCE;
    }

    public UserVO run(String email, String password){
        UserVO userVO = new UserVO();
        userVO.setEmail(email);

        UserDAO userDAO = new UserDAO();
        UserVO user = userDAO.findByEmail(userVO);

        if(user != null && user.getPassword().equals(password)){
            return user;
        }
        else{
            return null;
        }
    }
}
