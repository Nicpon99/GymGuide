<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Description</title>
    <link rel="stylesheet" href="<c:url value='/css/style.css'/>">
</head>
<body>
<%@include file="header.jsp"%>

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
            <a href="${exercise.link}" target="_blank">ZOBACZ FILM NA YOUTUBE</a>
        </td>
    </tr>
    <tr>
        <td>
            <a href="">DODAJ DO ULUBIONYCH</a>
        </td>
    </tr>
</table>



</body>
</html>
