<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Description</title>
    <link rel="stylesheet" href="<c:url value='/css/style.css'/>">
</head>
<body>
<%@include file="header.jsp" %>
<br>
<table>
    <tr>
        <td>
            <a href="http://localhost:8080/exercises/${musclePart.id}">${musclePart.name} - Lista ćwiczeń</a>
        </td>
    </tr>
</table>
<br>

<H1>${exercise.name}</H1>

<table>
    <thead>
    <tr>
        <th>
            ZAANGAŻOWANE MIĘŚNIE
        </th>
    </tr>
    </thead>
    <tr>
        <td>
            <ul>
                <c:forEach items="${muscles}" var="muscle">
                    <li>
                            ${muscle}
                    </li>
                </c:forEach>
            </ul>
        </td>
    </tr>
    <thead>
    <tr>
        <th>
            OPIS ĆWICZENIA
        </th>
    </tr>
    </thead>
    <tr>
        <td>
            <ul>
                <c:forEach items="${description}" var="d">
                    <li>
                            ${d}
                    </li>
                </c:forEach>
            </ul>
        </td>
    </tr>
    <tr>
        <td>
            <a href="${exercise.link}" target="_blank" style="color: blue">ZOBACZ FILM NA YOUTUBE</a>
        </td>
    </tr>
    <tr>
        <td style="display: none">
            <div id="like">${like}</div>
        </td>
    </tr>
    <tr>
        <td>
            <a href="http://localhost:8080/exercises/description/like/${musclePart.id}/${exercise.id}"
               id="likeButton"></a>
        </td>
    </tr>
</table>
<script src="/js/check-like-description.js"></script>
</body>
</html>
