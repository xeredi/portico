<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<title><fmt:message key="cnci-detalle.title" /></title>
</head>
<body>
    <fmt:message key="format.datetime" var="datetimePattern" scope="page" />

    <fieldset>
        <div class="row">
            <div class="col-md-6 form-group">
                <label for="cnci.clave"><fmt:message key="cnci.clave" /></label>
                <p class="form-control-static">${cnci.clave}</p>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 form-group">
                <label for="cnci.valorDefecto"><fmt:message key="cnci.valorDefecto" /></label>
                <p class="form-control-static">${cnci.valorDefecto}</p>
            </div>
        </div>
    </fieldset>

    <table class="table table-condensed table-hover table-nonfluid">
        <thead>
            <tr>
                <th><fmt:message key="cnvi.cnid" /></th>
                <th><fmt:message key="cnvi.valor" /></th>
            </tr>
        </thead>

        <tbody>
            <c:forEach items="${cnids}" var="cnid">
                <tr>
                    <td>${cnid.codigo}- ${cnid.descripcion}</td>
                    <td>${cnci.cnviMap[cnid.id]}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</body>
</html>
