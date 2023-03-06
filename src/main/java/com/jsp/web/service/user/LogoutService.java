package com.jsp.web.service.user;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class LogoutService {
    private LogoutService(){}
    private static class LogoutServiceHelper{
        private static final LogoutService INSTANCE = new LogoutService();
    }
    public static LogoutService getInstance(){
        return LogoutServiceHelper.INSTANCE;
    }

    public void run() {

    }

}
