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

        <h1>Podaj nowe hasło</h1>

        <form:form method="POST" modelAttribute="user">
            <form:input path="id" value="${user.id}" type="hidden"/>
            <form:input path="username" value="${user.username}" type="hidden"/>
            <form:input path="email" value="${user.email}" type="hidden"/>
            <table>
                <tr>
                    <td>
                        <div><form:input path="password" type="password"/></div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <div><button type="submit">SAVE</button> </div>
                    </td>
                </tr>
            </table>
            <form:errors path="password" class="error" element="div"/>
        </form:form>
    </div>
</div>
</body>
</html>
