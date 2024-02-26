<%@ page import="model.Offre" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 26/02/2024
  Time: 19:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% List<Offre> offres = (List<Offre>) request.getAttribute("LISTOFFRES"); %>
<html>
<head>
    <title>Liste des offres</title>
</head>
<body>
<h1>Liste des offres</h1>



<%-- Vérifier si la liste des offres n'est pas vide --%>
<% if (offres != null && !offres.isEmpty()) { %>
<ul>
    <%-- Boucler à travers la liste des offres et les afficher --%>
    <% for (Offre offre : offres) { %>
    <li>
        ID: <%= offre.getOffreId() %>,
        Date de publication: <%= offre.getDatePublication() %>,
        Date d'expiration: <%= offre.getDateExpiration() %>,
        Contenu: <%= offre.getContenu() %>,
        Type: <%= offre.getType() %>
    </li>
    <% } %>
</ul>
<% } else { %>
<p>Aucune offre disponible</p>
<% } %>
</body>
</html>
