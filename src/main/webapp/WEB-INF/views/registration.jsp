<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" href="<c:url value='/css/style.css'/>">
</head>
<body>
<%@include file="header.jsp"%>
    <form:form method="post" modelAttribute="user">
        <table>
            <tr>
                <td>
                    <div>EMAIL</div>
                </td>
            </tr>
            <tr>
                <td>
        <div><form:input path="email"/></div>
                </td>
            </tr>
            <tr>
                <td>
        <div>USERNAME</div>
                </td>
            </tr>
            <tr>
                <td>
        <div><form:input path="username"/></div>
                </td>
            </tr>
            <tr>
                <td>
        <div>PASSWORD</div>
                </td>
            </tr>
            <tr>
                <td>
        <div><form:input path="password" type="password"/></div>
                </td>
            </tr>
            <tr>
                <td>

        <div><button type="submit">REGISTER</button> </div>
                </td>
            </tr>
        </table>
        <form:errors path="email" class="error" element="div"/>
        <form:errors path="username" class="error" element="div"/>
        <form:errors path="password" class="error" element="div"/>
    </form:form>
</body>
</html>
