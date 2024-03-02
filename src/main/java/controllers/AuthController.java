package controllers;

import java.io.*;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
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

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupérer le chemin absolu du répertoire actuel
        String servletPath = request.getServletContext().getRealPath("/");

        // Construire le chemin complet vers le fichier index.html dans le répertoire de votre servlet
        String indexPath = servletPath + "/template/job-board-2-master/job-board-2-master/index.html";

        // Rediriger vers le fichier index.html
        response.sendRedirect(indexPath);
    }

    public void destroy() {
    }
}