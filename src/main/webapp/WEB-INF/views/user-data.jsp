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
    <h1>Moje dane</h1>
        <table>
            <tr>
                <td><strong>Adres email</strong></td>
                <td>${user.email}</td>
            </tr>
            <tr>
                <td><strong>Nazwa użytkownika</strong></td>
                <td>${user.username}</td>
            </tr>
            <tr>
                <td colspan="2">
                    <div style="text-align: center;">
                        <a href="http://localhost:8080/user/edit" style="color: rebeccapurple">Edytuj</a>
                    </div>
                </td>
            </tr>
        </table>
    </div>
</div>


</body>
</html>
