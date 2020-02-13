<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <style>
        <%@include file="css/find.css"%>
        <%@include file="include/meny.jsp"%>
    </style>
    <title>Find By ID</title>
</head>
<body>
<p style="color: red">${ERROR}</p>

<div class="form-style-5">
    <h1>Find Films by Release Date and Director</h1>
    <h3>If you not sure about particular date you can select Director only</h3>
    <form method="post">
        <select id="list" name="id">
            <jsp:useBean id="list" scope="request" type="java.util.List"/>
            <option value="">=Select Director=</option>
            <c:forEach items="${list}" var="list">
                <option value="${list.id}">${list.lastName} </option>
            </c:forEach>
        </select>
        <!-- Material input -->
        <label>
            <input type="number" name="date1" placeholder="Input release date"/>
        </label>
        <input type="submit" value="Search">
    </form>
</div>
</body>
</html>
