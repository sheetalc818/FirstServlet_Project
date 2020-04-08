package com.firstservlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/firstServlet")
public class FirstServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //super.doGet(request, response);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("Hello Pawan! it's Servlet");
        out.close();
    }
}
