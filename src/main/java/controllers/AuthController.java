package controllers;

import java.io.*;



import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//
//@WebServlet(name = "AuthControllerServlet", value = "/AuthController-servlet")
@WebServlet(name = "AuthControllerServlet", value = "/AuthController-servlet")
public class AuthController extends HttpServlet {
    private String message;

    public void init() {
        message = "AuhtControllerServlet!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}