<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<title><fmt:message key="cnen-listado.title" /></title>
</head>
<body>
    <div class="btn-toolbar" role="toolbar">
        <div class="btn-group">
            <a class="btn btn-default" href="cnen-alta.action"><i
                class="glyphicon glyphicon-file"></i> <fmt:message key="boton.alta" /></a>
        </div>
    </div>

    <table class="table table-condensed table-hover table-nonfluid">
        <thead>
            <tr>
                <th class="buttonLinks" />
                <th class="codigo"><fmt:message key="cnen.codigo" /></th>
                <th><fmt:message key="cnen.nombre" /></th>
            </tr>
        </thead>

        <tbody>
            <c:forEach items="${cnens}" var="cnen">
                <tr>
                    <td><a href="cnen-modificar.action?cnen.id=${cnen.id}"><i
                            class="glyphicon glyphicon-edit"></i></a></td>
                    <td><a href="cnen-detalle.action?cnen.id=${cnen.id}"><b>${cnen.codigo}</b></a></td>
                    <td>${cnen.nombre}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
