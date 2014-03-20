<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<title><fmt:message key="cncl-detalle.title" /></title>
</head>
<body>
    <fmt:message key="format.datetime" var="datetimePattern" scope="page" />

    <fieldset>
        <div class="row">
            <div class="col-md-6 form-group">
                <label for="cncl.clave"><fmt:message key="cncl.clave" /></label>
                <p class="form-control-static">${cncl.clave}</p>
            </div>
            <div class="col-md-3 form-group">
                <label for="cncl.tipoValor"><fmt:message key="cncl.tipoValor" /></label>
                <p class="form-control-static">${cncl.tipoValor}
                    -
                    <fmt:message key="TipoValor.${cncl.tipoValor}" />
                </p>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 form-group">
                <label for="cncl.valorDefecto"><fmt:message key="cncl.valorDefecto" /></label>
                <p class="form-control-static">${cncl.valorDefecto}</p>
            </div>
        </div>
    </fieldset>

    <table class="table table-condensed table-hover table-nonfluid">
        <thead>
            <tr>
                <th><fmt:message key="cnvl.cnen" /></th>
                <th><fmt:message key="cnvl.valor" /></th>
            </tr>
        </thead>

        <tbody>
            <c:forEach items="${cnens}" var="cnen">
                <tr>
                    <td>${cnen.codigo}- ${cnen.nombre}</td>
                    <td>${cncl.cnvlMap[cnen.id]}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</body>
</html>
