package com.jsp.web.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "*.do")
public class DispatcherServlet extends HttpServlet {
    private HandlerMapping handlerMapping;
    private ViewResolver viewResolver;

    public void init() throws ServletException {
        handlerMapping = new HandlerMapping();
        viewResolver = new ViewResolver();
        viewResolver.setPrefix("./WEB-INF/board/");
        viewResolver.setSuffix(".jsp");
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        String path = uri.substring(uri.lastIndexOf("/"));

        Controller controller = handlerMapping.getController(path);
        String viewName = controller.handleRequest(request, response);

        String view = null;
        if(!viewName.contains(".do")){
            if(viewName.equals("index")){
                view = viewName + ".jsp";
            }
            else {
                view = viewResolver.getView(viewName);
            }
        }
        else{
            view = viewName;
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(view);
        dispatcher.forward(request, response);
    }
}
