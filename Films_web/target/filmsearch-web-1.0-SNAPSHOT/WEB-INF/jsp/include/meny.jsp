<html>
<head>
    <style>
        <%@include file="/WEB-INF/jsp/css/meny.css"%>
    </style>
</head>
<header class="header">
    <h1 class="logo"><a href="#">Movie Search</a></h1>
    <ul class="main-nav">
        <li><a href="${pageContext.request.contextPath}/allOptional">Full Found</a></li>
        <li><a href="${pageContext.request.contextPath}/allOptionalWithOneDate">Simple Found</a></li>
    </ul>

</header>
</html>