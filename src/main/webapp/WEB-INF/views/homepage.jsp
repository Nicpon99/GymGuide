<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>NAZWA APLIKACJI</title>
  <link rel="stylesheet" href="<c:url value='/css/style.css'/>">
</head>
<body>

<%@include file="header.jsp"%>

<p>
  Opis aplikacji
</p>

<table>
  <c:forEach items="${muscleParts}" var="muscle">
  <tr>
    <td><a href="http://localhost:8080/exercises/${muscle.id}">${muscle.name}</a></td>
  </tr>
  </c:forEach>
</table>

</body>
</html>
