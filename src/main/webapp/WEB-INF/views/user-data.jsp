<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User data</title>
    <link rel="stylesheet" href="<c:url value='/css/style.css'/>">
</head>
<body>
<%@include file="header.jsp" %>
<div class="container">
    <%@include file="left-menu.jsp" %>

    <div class="content">

        <table>
            <tr>
                <td>Adres email</td>
                <td>${user.email}</td>
            </tr>
            <tr>
                <td>Nazwa użytkownika</td>
                <td>${user.username}</td>
            </tr>
        </table>
        <div style="text-align: center;">
            <a href="http://localhost:8080/user/edit">Edytuj</a>
        </div>
    </div>
</div>


</body>
</html>
