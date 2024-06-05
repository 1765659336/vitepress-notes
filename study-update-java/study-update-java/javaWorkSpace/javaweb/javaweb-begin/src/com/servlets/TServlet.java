/*
    @说明:
*/
package com.servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TServlet extends MyHttpServlet{
    @Override
    public void myDoget(HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        System.out.println(111);
    }
}
