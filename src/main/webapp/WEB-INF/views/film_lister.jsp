<%-- 
    Document   : genre_lister
    Created on : 10 oct. 2016, 11:01:50
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <div>
    <a href="ajouter_film">Ajouter Film</a>
    </div>
    <br>
    <body>
        <h1>Liste des films</h1>
        <div>
        <c:forEach items="${films}" var="mesfilms">
            ${mesfilms.titre}
            <a href="supprimer_film/${mesfilms.id}">Supprimer</a>
            <a href="editer_film/${mesfilms.id}">Editer</a>
            <br>
        </c:forEach>
        </div>
    </body>
</html>
