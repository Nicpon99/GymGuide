<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My profile</title>
  <link rel="stylesheet" href="<c:url value='/css/style.css'/>">
</head>
<body>
<%@include file="header.jsp" %>
<div class="container">
    <%@include file="left-menu.jsp" %>
    <div class="content">
        <h1>Moje treningi</h1>
        <c:forEach items="${trainings}" var="training">
            <table>
                <tr>
                    <td>
                       <a href="http://localhost:8080/training/description/${training.id}">${training.name}</a>
                    </td>
                </tr>
            </table>
            <br>
        </c:forEach>
    </div>
</div>
</body>
</html>
