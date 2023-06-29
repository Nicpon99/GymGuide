<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<header>
    <table>
        <tr>
            <td>
                <a href="http://localhost:8080/">Nazwa aplikacji</a>
            </td>
            <sec:authorize access="isAnonymous()">
            <td>
                <a href="http://localhost:8080/login">Zaloguj się</a>
            </td>
            </sec:authorize>
            <sec:authorize access="isAnonymous()">
            <td>
                <a href="http://localhost:8080/register">Zarejestruj się</a>
            </td>
            </sec:authorize>
            <sec:authorize access="isAuthenticated()">
            <td>
                <a href="http://localhost:8080/logout">Wyloguj się</a>
            </td>
            </sec:authorize>
        </tr>
    </table>
</header>