<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Create your training</title>
    <link rel="stylesheet" href="<c:url value='/css/style.css'/>">
</head>
<body>
<%@include file="header.jsp" %>
<div class="container">
    <%@include file="left-menu.jsp" %>
    <div class="content">
        <form:form method="POST" modelAttribute="training">
            <table>
                <tr>
                    <td>
                        <div>Nazwa treningu</div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <div><form:input path="name"/></div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <div>Opis treningu</div>
                    </td>
                </tr>
                <tr>

                    <td>
                        <div><form:textarea path="description" rows="3" cols="20"/></div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <div><button type="submit">Dalej</button></div>
                    </td>
                </tr>
            </table>
            <form:errors path="name" class="error" element="div"/>
            <form:errors path="description" class="error" element="div"/>
        </form:form>
    </div>
</div>
</body>
</html>
