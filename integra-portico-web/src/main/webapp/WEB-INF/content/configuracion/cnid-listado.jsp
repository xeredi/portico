<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<title><fmt:message key="cnid-listado.title" /></title>
</head>
<body>
    <div class="btn-toolbar" role="toolbar">
        <div class="btn-group">
            <a class="btn btn-default" href="cnid-alta.action"><i
                class="glyphicon glyphicon-file"></i> <fmt:message key="boton.alta" /></a>
        </div>
    </div>

    <table class="table table-condensed table-hover table-nonfluid">
        <thead>
            <tr>
                <th class="buttonLinks" />
                <th class="codigo"><fmt:message key="cnid.codigo" /></th>
                <th class="descripcion"><fmt:message key="cnid.descripcion" /></th>
            </tr>
        </thead>

        <tbody>
            <c:forEach items="${cnids}" var="cnid">
                <tr>
                    <td><a href="cnid-modificar.action?cnid.id=${cnid.id}"><i
                            class="glyphicon glyphicon-edit"></i></a></td>
                    <td><a href="cnid-detalle.action?cnid.id=${cnid.id}"><b>${cnid.codigo}</b></a></td>
                    <td>${cnid.descripcion}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
