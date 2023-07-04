<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Training description</title>
  <link rel="stylesheet" href="<c:url value='/css/style.css'/>">
</head>
<body>
<%@include file="header.jsp" %>
<div class="container">
  <%@include file="left-menu.jsp" %>
  <div class="content">
    <h1>${training.name}</h1>
    <table>
      <tr>
        <td>
          <strong>Opis</strong>
        </td>
      </tr>
      <tr>
        <td>
          ${training.description}
        </td>
      </tr>
    </table>
    <br>
    <table>
      <thead>
        <tr>
          <th>ĆWICZENIE</th>
          <th>MIĘŚNIE</th>
          <th>TUTORIAL</th>
          <th>ILOŚĆ SERII</th>
          <th>KOLEJNOŚĆ WYKONYWANIA</th>
        </tr>
      </thead>
      <c:forEach items="${trainingWithExercises}" var="item">
        <tr>
          <c:forEach items="${item.value}" var="inner">
          <td>
            ${inner.key.name}
          </td>
          <td>
            <ul>
              <c:forEach items="${inner.value}" var="muscle">
                <li>
                  ${muscle}
                </li>
              </c:forEach>
            </ul>
          </td>
          <td>
            <a href="${inner.key.link}" target="_blank">ZOBACZ FILM NA YOUTUBE</a>
          </td>
          </c:forEach>
          <td>
            ${item.key.series}
          </td>
          <td>
            ${item.key.sequence}
          </td>
        </tr>
      </c:forEach>
    </table>

  </div>
</div>
</body>
</html>