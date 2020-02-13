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
    <h1>Find Films by Date and Id</h1>
    <form method="post">
        <label>
            <input type="number" name="id" placeholder="Input Director ID"/>
        </label>
        <label>
            <input type="number" name="date1" placeholder="Input start date"/>
        </label>
        <label>
            <input type="number" name="date2" placeholder="Input last date"/>
        </label>
        <input type="submit" value="Search">
    </form>
</div>
</body>
</html>
