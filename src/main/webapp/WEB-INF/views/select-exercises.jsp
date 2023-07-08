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
        <h2>Wybierz ćwiczenia spośród swoich ulubionych, które chcesz zamieścić w treningu</h2>
        <form method="GET" action="/training/create/${trainingId}/muscleParts/added/exercises">
            <c:forEach items="${exercises}" var="exercise">
                <table>
                    <tr>
                        <td colspan="3">
                            <strong>${exercise.key.name}</strong>
                        </td>
                    </tr>
                    <c:forEach items="${exercise.value}" var="e">
                        <tr>
                            <td>
                                    ${e.name}
                            </td>
                            <td>
                                    ${e.muscles}
                            </td>
                            <td>
                                <input type="checkbox" name="exercisesIdsForTraining" value="${e.id}">
                            </td>
                        </tr>
                    </c:forEach>
                </table>
                <br>
            </c:forEach>
            <table>
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
