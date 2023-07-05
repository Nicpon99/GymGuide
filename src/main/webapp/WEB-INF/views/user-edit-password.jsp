<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Edit password</title>
    <link rel="stylesheet" href="<c:url value='/css/style.css'/>">
</head>
<body>
<%@include file="header.jsp"%>
<div class="container">
    <%@include file="left-menu.jsp" %>
    <div class="content">
        <form:form method="POST" modelAttribute="user">
            <form:input path="id" value="${user.id}" type="hidden"/>
            <form:input path="username" value="${user.username}" type="hidden"/>
            <form:input path="email" value="${user.email}" type="hidden"/>
            <table>
                <tr>
                    <td>
                        <div>Podaj nowe hasło</div>
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
                        <input type="password" id="pass2"/>
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
            <form:errors path="password" class="error" element="div"/>
        </form:form>
    </div>
</div>
<script src="/js/check-password.js" ></script>
</body>
</html>
