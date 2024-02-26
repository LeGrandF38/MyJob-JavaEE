<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 26/02/2024
  Time: 21:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Offre</title>
</head>
<body>
    <h1>Add Offre</h1>



    <form action="OffreController-servlet" method="post">
        <label for="idRecruteur">ID Recruteur:</label>
        <input type="text" id="idRecruteur" name="idRecruteur" required><br><br>

        <label for="datePublication">Date de publication:</label>
        <input type="text" id="datePublication" name="datePublication" required><br><br>

        <label for="dateExpiration">Date d'expiration:</label>
        <input type="text" id="dateExpiration" name="dateExpiration" required><br><br>

        <label for="contenu">Contenu:</label>
        <textarea id="contenu" name="contenu" rows="4" cols="50" required></textarea><br><br>

        <label for="type">Type:</label>
        <input type="text" id="type" name="type" required><br><br>

        <input type="hidden" name="do_this" value="create">
        <input type="submit" value="Ajouter Offre">
    </form>


</body>
</html>
