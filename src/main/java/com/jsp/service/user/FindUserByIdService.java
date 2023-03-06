package com.jsp.service.user;

import com.jsp.domain.user.UserDAO;
import com.jsp.domain.user.UserVO;

public class FindUserByIdService {
    private FindUserByIdService(){}
    private static class FindUserByIdServiceHelper{
        private static final FindUserByIdService INSTANCE = new FindUserByIdService();
    }
    public static FindUserByIdService getInstance(){
        return FindUserByIdService.FindUserByIdServiceHelper.INSTANCE;
    }

    public UserVO run(Long id){
        UserVO userVO = new UserVO();
        userVO.setId(id);

        UserDAO userDAO = new UserDAO();
        return userDAO.findById(userVO);
    }
}
