<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" href="<c:url value='/css/style.css'/>">
</head>
<body>
<%@include file="header.jsp" %>
<form:form method="post" modelAttribute="user">
    <table>
        <tr>
            <td>
                <div>Adres e-mail</div>
            </td>
        </tr>
        <tr>
            <td>
                <div><form:input path="email"/></div>
            </td>
        </tr>
        <tr>
            <td>
                <div>Nazwa użytkownika</div>
            </td>
        </tr>
        <tr>
            <td>
                <div><form:input path="username"/></div>
            </td>
        </tr>
        <tr>
            <td>
                <div>Hasło</div>
            </td>
        </tr>
        <tr>
            <td>
                <div><form:input path="password" type="password" id="pass1"/></div>
            </td>
        </tr>
        <tr>
            <td>
                <div>
                    Powtórz hasło
                </div>
            </td>
        </tr>
        <tr>
            <td>
                <div>
                    <input type="password" id="pass2"/>
                </div>
            </td>
        </tr>
        <tr>
            <td>
                <div style="display: block" id="button">
                    <button type="submit">Zapisz</button>
                </div>
                <div id="error-message" style="display: none" class="error">
                    Wpisane hasła nie są takie same
                </div>
            </td>
        </tr>
    </table>
    <form:errors path="email" class="error" element="div"/>
    <form:errors path="username" class="error" element="div"/>
    <form:errors path="password" class="error" element="div"/>
</form:form>
<script src="/js/check-password.js" ></script>
</body>
</html>
