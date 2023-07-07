<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete warning</title>
    <link rel="stylesheet" href="<c:url value='/css/style.css'/>">
</head>
<body>
<%@include file="header.jsp" %>
<div class="container">
    <%@include file="left-menu.jsp" %>
    <div class="content">
        <h2>Czy na pewno chcesz usunąć ten trening?</h2>
        <table>
            <tr>
                <td>
                    <a href="http://localhost:8080/training/delete/${trainingId}">Usuń</a>
                </td>
                <td>
                    <a href="http://localhost:8080/training/description/${trainingId}">Anuluj</a>
                </td>
            </tr>
        </table>
    </div>
</div>
</body>
</html>
