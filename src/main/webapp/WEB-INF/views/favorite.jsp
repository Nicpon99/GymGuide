<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>favorite exercises</title>
    <link rel="stylesheet" href="<c:url value='/css/style.css'/>">
</head>
<body>
<%@include file="header.jsp" %>
<div class="container">
    <%@include file="left-menu.jsp" %>
    <div class="content">
        <h1>Ulubione ćwiczenia</h1>
        <table>
            <c:forEach items="${exercises}" var="exercise">
                <tr>
                    <td>
                        ${exercise.name}
                    </td>
                    <td>
                        <a href="http://localhost:8080/exercises/description/${exercise.id}">Zobacz opis</a>
                    </td>
                    <td>
                        <a href="http://localhost:8080/user/favorite/delete/${exercise.id}">Usuń z ulubionych</a>
                    </td>
                </tr>
            </c:forEach>
        </table>

    </div>
</div>
</body>
</html>