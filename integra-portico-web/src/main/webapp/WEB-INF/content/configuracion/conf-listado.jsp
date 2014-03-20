<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<title><fmt:message key="conf-listado.title" /></title>
</head>
<body>
    <ul class="list-group">
        <li class="list-group-item"><a href="cnen-listado.action">Entornos</a></li>
        <li class="list-group-item"><a href="cnid-listado.action">Idiomas</a></li>
        <li class="list-group-item"><a href="cncl-listado.action">Claves</a></li>
        <li class="list-group-item"><a href="cnci-listado.action">Claves Idioma</a></li>
    </ul>
</body>
</html>
