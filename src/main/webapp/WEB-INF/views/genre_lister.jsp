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
    <body>
        <h1>Liste des genres</h1>
        <div>
        <c:forEach items="${genres}" var="mesgenres">
            ${mesgenres.nom}
            <a href="supprimer_genre/${mesgenres.id}">Supprimer</a>
            <a href="modifier_genre/${mesgenres.id}">Editer</a>
            <br>
        </c:forEach>
        </div>
    </body>
</html>
