package com.jsp.web.filter;

import com.jsp.domain.user.UserVO;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(filterName = "AuthenticationFilter", urlPatterns = {"/deleteBoard.do", "/getBoard.do", "/getBoardList.do"})
public class AuthenticationFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        HttpSession session = req.getSession();
        UserVO userVO = (UserVO) session.getAttribute("user");

        if(userVO != null){
        chain.doFilter(request, response);
        }
        else{
            res.sendRedirect("loginUser.do");
        }
    }
}
