<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Exercises</title>
    <link rel="stylesheet" href="<c:url value='/css/style.css'/>">
</head>
<body>
<%@include file="header.jsp" %>

<H1>${musclePart.name}</H1>
<table>
    <thead>
    <tr>
        <th>ĆWICZENIE</th>
        <th>ZAANGAŻOWANE MIĘŚNIE</th>
        <th></th>
        <th></th>
    </tr>
    </thead>
    <c:forEach items="${exercises}" var="exercise">
        <tr>
            <td>
                    ${exercise.key.name}
            </td>
            <c:forEach items="${exercise.value}" var="inner">
                <td>
                    <ul>

                        <c:forEach items="${inner.key}" var="muscle">
                            <li>${muscle}</li>
                        </c:forEach>

                    </ul>
                </td>
                <td style="display: none">
                    <div id="like">${inner.value}</div>
                </td>
            </c:forEach>
            <td>
                <a href="http://localhost:8080/exercises/description/${musclePart.id}/${exercise.key.id}"
                   style="color: rebeccapurple">Zobacz opis</a>
            </td>
            <td>
                <a href="http://localhost:8080/exercises/like/${muscleId}/${exercise.key.id}" id="likeButton"></a>
            </td>
        </tr>
    </c:forEach>
</table>
<script src="/js/check-like.js"></script>
</body>
</html>
