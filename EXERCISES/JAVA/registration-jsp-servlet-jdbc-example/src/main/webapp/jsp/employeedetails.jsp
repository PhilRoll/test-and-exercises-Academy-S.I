<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registered</title>
<script>
    function showEmployees() {
        // Reindirizza direttamente alla pagina per visualizzare gli employees
        window.location.href = '<%= request.getContextPath() %>/showEmployees';
    }
</script>
</head>
<body>
    <h1>User successfully registered!</h1>
    <button onclick="showEmployees()">Visualizza tutti gli employees</button>
</body>
</html>
