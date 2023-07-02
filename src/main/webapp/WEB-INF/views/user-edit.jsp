<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Edit user</title>
    <link rel="stylesheet" href="<c:url value='/css/style.css'/>">
</head>
<body>
<%@include file="header.jsp" %>
<div class="container">
    <%@include file="left-menu.jsp" %>
    <div class="content">

        <form:form method="POST" modelAttribute="user">
            <form:input path="id" value="${user.id}" type="hidden"/>
            <table>
                <tr>
                    <td>
                        <div>EMAIL</div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <div><form:input path="email" value="${user.email}"/></div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <div>USERNAME</div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <div><form:input path="username" value="${user.username}"/></div>
                    </td>
                <tr>
                    <td>

                        <div><button type="submit">SAVE</button> </div>
                    </td>
                </tr>
            </table>
            <form:errors path="email" class="error" element="div"/>
            <form:errors path="username" class="error" element="div"/>
        </form:form>
    </div>
</div>
</body>
</html>
