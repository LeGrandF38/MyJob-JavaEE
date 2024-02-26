package controllers;

import model.Offre;

import java.io.*;
import java.util.List;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "OffreControllerServlet", value = "/OffreController-servlet")
public class OffreController extends HttpServlet {
    private String message;

    public void init() {
        message = "OffreControllerServlet";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Offre offreObject = new Offre();
        String do_this = request.getParameter("do_this");

        if (do_this == null){
            // définir le contexte pour une redirection sur LA PAGE listOfrre.JSP
            ServletContext sc = getServletContext();
            RequestDispatcher rd = sc.getRequestDispatcher("/views/offre/listOffre.jsp");
            // CHARGER LA liste des offres DANS LA requête pour les TRANSMETTRE À LA JSP listOfrre.JSP (qui VA les AFFICHER)
            List<Offre> offres = offreObject.findAll();
            request.setAttribute("LISTOFFRES", offres);
            rd.forward(request, response);

        }else {
            switch (do_this){
                case "create":
                    //
                    break;
                case "update":
                    //
                    break;
                case "delete":
                    //
                    break;
            }
        }

    }

    public void destroy() {
    }
}