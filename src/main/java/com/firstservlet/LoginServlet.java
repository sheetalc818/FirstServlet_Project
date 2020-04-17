package com.firstservlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(
        description = "Login to Servlet",
        urlPatterns = {"/LoginServlet"},
        initParams = {
                @WebInitParam(name = "user", value = "Sheetal"),
                @WebInitParam(name = "password", value = "Bridgelabz1")
        }
)
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        RequestDispatcher rd = null;

        Pattern userPattern = Pattern.compile("^[A-Z]{1}[a-z]{2,}");
        Pattern passwordPattern = Pattern.compile("^[A-Z][a-z0-9]{7,}$");

        //get Request Parameter for userID and Password
        String user = request.getParameter("user");
        String pwd = request.getParameter("pwd");

        Matcher userRegEx = userPattern.matcher(user);
        Matcher passwordRegEx = passwordPattern.matcher(pwd);

        //get Servlet Config init params
        String userID = getServletConfig().getInitParameter("user");
        String password = getServletConfig().getInitParameter("password");

        if (userRegEx.matches() && passwordRegEx.matches()) {
            if (userID.equals(user) && password.equals(pwd)) {
                request.setAttribute("user", user);
                //request.getRequestDispatcher("LoginSuccess.jsp").forward(request, response);
                response.sendRedirect("LoginSuccess.jsp");
            } else {
                rd = getServletContext().getRequestDispatcher("/login.html");
                out.println("<font color=red>Either user name or password is wrong.</font>");
                rd.include(request, response);
            }
        } else {
            if (!userRegEx.matches()) {
                rd = getServletContext().getRequestDispatcher("/login.html");
                out.println("<font color=red>Enter Username having min length 3 and Starts with Capital letter</font>");
            } else if (!passwordRegEx.matches()) {
                rd = getServletContext().getRequestDispatcher("/login.html");
                out.println("<font color=red>Enter Password having min length 8 with at least one Upper letter and Number</font>");
            }
            rd.include(request, response);
        }
    }
}
