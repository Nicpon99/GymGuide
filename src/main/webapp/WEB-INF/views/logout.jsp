<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Logout</title>
    <link rel="stylesheet" href="<c:url value='/css/style.css'/>">
</head>
<body>
<%@include file="header.jsp"%>
<form action="<c:url value="/logout"/>" method="post">
    <table>
        <tr>
            <td>
                 <input class="fa fa-id-badge" type="submit" value="Wyloguj">
            </td>
        </tr>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </table>
</form>
</body>
</html>
