package com.jsp.service.user;

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
