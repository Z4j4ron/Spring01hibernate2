<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>All authors</title>
</head>
<body>

<table>
    <tr>
        <th>Lp.</th>
        <th>First name</th>
        <th>Last name</th>
        <th>PESEL</th>
        <th>E-mail</th>
    </tr>
    <c:forEach items="${authors}" var="author">
        <tr>
            <td>${author.id}</td>
            <td>${author.firstName}</td>
            <td>${author.lastName}</td>
            <td>${author.pesel}</td>
            <td>${author.email}</td>
            <td><a href="edit?id=${author.id}">Edit</a></td>
            <td><a href="remove?id=${author.id}" onclick="return confirm('Are you sure?')">Remove</a></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
