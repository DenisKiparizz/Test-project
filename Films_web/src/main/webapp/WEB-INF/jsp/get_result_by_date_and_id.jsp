<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result by Date</title>
    <style>
        <%@include file="css/table.css"%>
    </style>
</head>
<body>
<%@include file="include/meny.jsp" %>
<table class="my_table" style="margin-bottom: auto">
    <thead>
    <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Birth Date</th>
        <th>Film Name</th>
        <th>Genre</th>
        <th>Release Date</th>
    </tr>
    </thead>
    <tbody>
<%--    <jsp:useBean id="listFilm" scope="request" type="java.util.List"/>--%>
    <c:forEach items="${listFilm}" var="list">
        <tr>
            <td><c:out value="${list.director.firstName}"/></td>
            <td><c:out value="${list.director.lastName}"/></td>
            <td><c:out value="${list.director.birthDay}"/></td>
            <td><c:out value="${list.name}"/></td>
            <td><c:out value="${list.genre}"/></td>
            <td><c:out value="${list.releaseDate}"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
