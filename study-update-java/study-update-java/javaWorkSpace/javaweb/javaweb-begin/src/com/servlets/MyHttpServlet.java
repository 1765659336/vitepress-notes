/*
    @说明:
*/
package com.servlets;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyHttpServlet extends GenericServlet {

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        HttpServletRequest request;
        HttpServletResponse response;
        try {
            request = (HttpServletRequest)servletRequest;
            response = (HttpServletResponse)servletResponse;
        } catch (ClassCastException var6) {
            throw new ServletException("http.non_http");
        }
        String method = request.getMethod();
        long lastModified;
        if (method.equals("GET")) {
            System.out.println("get");
            this.myDoget(request,response);
        }
        if (method.equals("POST")){
            System.out.println("post");
            this.myDoget(request,response);
        }
    }
    public void myDoget(HttpServletRequest servletRequest, HttpServletResponse servletResponse){
        System.out.println("执行了....");
    }
}
