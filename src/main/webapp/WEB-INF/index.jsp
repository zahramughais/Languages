<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>     

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Languages</title>
</head>
<body>
<table>
    <thead>
        <tr>
            <th>Name</th>
            <th>Creator</th>
            <th>Version</th>
            <th>Action</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="lang" items="${languages}">         
            <tr>
                <td><a href="/languages/${lang.id}"><c:out value="${lang.name}"/></a></td>
                <td><c:out value="${lang.creator}"/></td>
                <td><c:out value="${lang.currentVersion}"/></td>
                <td>
                    <form action="/languages/${lang.id}" method="post">
                    <input type="hidden" name="_method" value="delete">
                    <input type="submit" value="Delete">
                    </form>
                </td>
                <td><a href="/languages/${lang.id}/edit">edit</a></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<form:form action="/languages" method="post" modelAttribute="language">
    <p>
        <form:label path="name">Name</form:label>
        <form:errors path="name"/>
        <form:input path="name"/>
    </p>
    <p>
        <form:label path="creator">Creator</form:label>
        <form:errors path="creator"/>
        <form:textarea path="creator"/>
    </p>
    <p>
        <form:label path="currentVersion">Version</form:label>
        <form:errors path="currentVersion"/>     
        <form:input type="number" step="0.1" path="currentVersion"/>
    </p>    
    <input type="submit" value="Submit"/>
</form:form>   
</body>
</html>