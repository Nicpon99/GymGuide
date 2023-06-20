<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Exercises</title>
  <link rel="stylesheet" href="<c:url value='/css/style.css'/>">
</head>
<body>
<%@include file="header.jsp"%>

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
                    ${exercise.key}
                </td>
                <td>
                    <ul>
                        <c:forEach items="${exercise.value}" var="muscle">
                            <li>${muscle}</li>
                        </c:forEach>
                    </ul>
                </td>
                <td>
                    <a href="">Zobacz opis</a>
                </td>
                <td>
                    <a href="">Dodaj do ulubionych</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
