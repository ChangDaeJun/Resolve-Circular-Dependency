package com.jsp.web.service.user;

import com.jsp.biz.user.UserDAO;
import com.jsp.biz.user.UserVO;
import com.jsp.web.controller.Controller;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JoinService {
    private JoinService(){}
    private static class JoinServiceHelper{
        private static final JoinService INSTANCE = new JoinService();
    }
    public static JoinService getInstance(){
        return JoinService.JoinServiceHelper.INSTANCE;
    }
    
    public void run(UserVO vo) {
        UserDAO userDAO = new UserDAO();
        userDAO.insert(vo);
    }
}
