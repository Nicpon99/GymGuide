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
        <h1>Określ liczbę serii poszczególnych ćwiczeń oraz kolejność wykonywania</h1>
        <form method="GET" action="http://localhost:8080/training/save">
            <table>
                <thead>
                <tr>
                    <th>
                        Ćwiczenie
                    </th>
                    <th>
                        Ilość serii
                    </th>
                    <th>
                        Kolejność wykonywania
                    </th>
                </tr>
                </thead>
                <c:forEach items="${trainingWithExercises}" var="item" varStatus="loop">
                    <tr>
                        <td>
                                ${item.value}
                        </td>
                        <td>
                            <input type="number" name="series" value="4"/>
                        </td>
                        <td>
                            <select name="sequence">

                                <c:forEach begin="1" end="${mapLength}" var="sample">
                                    <option value="${sample}">${sample}</option>

                                </c:forEach>
                            </select>
                        </td>
                        <td style="display: none">
                            <input name="trainingExerciseIds" value="${item.key.id}"/>
                        </td>
                    </tr>
                </c:forEach>
                <tr>
                    <td colspan="3">
                        <button type="submit">Zapisz trening</button>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>
</html>
