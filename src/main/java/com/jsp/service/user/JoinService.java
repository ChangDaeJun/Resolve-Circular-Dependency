package com.jsp.service.user;

import com.jsp.domain.user.UserDAO;
import com.jsp.domain.user.UserVO;

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
