package com.jsp.web.controller.user;

import com.jsp.biz.user.UserVO;
import com.jsp.web.controller.Controller;
import com.jsp.web.service.user.LoginService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginUserController  extends ServiceController {
    public LoginUserController(ServiceMapping serviceMapping) {
        super(serviceMapping);
    }

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
