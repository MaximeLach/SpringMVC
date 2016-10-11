<%-- 
    Document   : genre_modifier
    Created on : 10 oct. 2016, 14:42:42
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Ajouter film</h1>
        <div>
            <c:set var="route">
                <spring:url value="/ajouter_film"/>
            </c:set>
            <form:form action="${route}" modelAttribute="film">
                <label>Nom : </label>
                <br>
                <form:input path="titre"/>
                <br>
                
                <label>Genre</label>
                <form:select path="genre.id" items="${genres}" itemLabel="nom" itemValue="id"/>
                <br>
                
                <label>Synopsis : </label>
                <br>
                <form:textarea path="synopsis"/>
                <br>
                <label>Année de production : </label>
                <br>
                <form:input path="anneeProd"/>
                <br>
                <input type="submit" value ="Ajouter"/>
            </form:form>
            <br>
        </div>
    </body>
</html>
