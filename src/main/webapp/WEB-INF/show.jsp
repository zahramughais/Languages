<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${language.name}</title>
</head>
<body>
    <a href="/languages">Dashboard</a>
    <p>${language.name}</p>
    <p>${language.creator}</p>
    <p>${language.currentVersion}</p>
    <a href="/languages/${language.id}/edit">edit</a>
    <form action="/languages/${language.id}" method="post">
        <input type="hidden" name="_method" value="delete">
        <input type="submit" value="Delete">
    </form>
</body>
</html>