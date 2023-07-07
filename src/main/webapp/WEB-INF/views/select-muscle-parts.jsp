<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        <form method="GET" action="http://localhost:8080/training/create/${trainingId}/muscleParts/added">
            <table>
                <tr>
                    <td>
                        <div>Zaznacz partie mięśniowe, których ma dotyczyć Twój trening</div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <c:forEach items="${muscleParts}" var="musclePart">
                            <input type="checkbox" name="muscles" value="${musclePart.id}"/>${musclePart.name}<br>
                        </c:forEach>
                    </td>
                </tr>
                <tr>
                    <td>
                        <button type="submit">Dalej</button>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>
</html>
