<%@ page language="java" isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<title>Error Interno</title>
</head>
<body>
    <div class="alert alert-danger">Error Interno - Consulte con su Administrador</div>

    <div class="alert alert-danger">${exception.message}</div>

    <pre>
        <jsp:scriptlet>exception.printStackTrace(new java.io.PrintWriter(out));</jsp:scriptlet>
    </pre>
</body>
</html>
