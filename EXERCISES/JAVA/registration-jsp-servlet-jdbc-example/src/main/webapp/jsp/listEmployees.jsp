<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista Employees</title>
</head>
<body>
    <h1>Lista Employees</h1>
    <table border="1">
        <tr>
            <th>id</th>
            <th>firstName</th>
            <th>lastName</th>
            <th>userName</th>
            <th>password</th>
            <th>email</th>
        </tr>
        <c:forEach var="employee" items="${employeesList}">
            <tr>
                <td>${employee.id}</td>
                <td>${employee.firstName}</td>
                <td>${employee.lastName}</td>
                <td>${employee.userName}</td>
                <td>${employee.password}</td>
                <td>${employee.email}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
