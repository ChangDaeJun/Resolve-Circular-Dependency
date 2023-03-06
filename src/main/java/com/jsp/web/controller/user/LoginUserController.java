package com.jsp.web.controller.user;

import com.jsp.domain.user.UserVO;
import com.jsp.web.controller.Controller;

import com.jsp.service.user.LoginService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginUserController implements Controller {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        UserVO vo = getLoginUserVO(request);
        UserVO user = LoginService.getInstance().run(vo);

        if(user != null){
            request.getSession().setAttribute("user", user);
            return "getBoardList.do";
        }else {
            return "loginUserView.do";
        }
    }

    private UserVO getLoginUserVO(HttpServletRequest request){
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UserVO vo = new UserVO();
        vo.setEmail(email);
        vo.setPassword(password);
        return vo;
    }
}
