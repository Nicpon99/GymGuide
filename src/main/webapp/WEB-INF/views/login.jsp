<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="<c:url value='/css/style.css'/>">
</head>
<body>
<%@include file="header.jsp" %>
<form method="post">
    <table>
        <tr>
            <td>
                Nazwa użytkownika
            </td>
        </tr>
        <tr>
            <td>
                <input type="text" name="username">
            </td>
        </tr>
        <tr>
            <td>
                Hasło
            </td>
        </tr>
        <tr>
            <td>
                <input type="password" name="password">
            </td>
        </tr>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <sec:csrfInput/>
        <tr>
            <td>
                <button type="submit">Zaloguj</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
