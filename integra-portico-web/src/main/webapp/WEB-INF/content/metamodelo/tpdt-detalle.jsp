<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<title><fmt:message key="tpdt-detalle.title" /> - ${tpdt.nombre} (${tpdt.codigo} -
    ${tpdt.id})</title>
</head>
<body>
    <fmt:message key="format.datetime" var="datetimePattern" scope="page" />

    <fieldset>
        <div class="row">
            <div class="col-md-3 form-group">
                <label for="tpdt.tpht"><fmt:message key="tpdt.tpht" /></label>
                <p class="form-control-static">
                    ${tpdt.tpht} -
                    <fmt:message key="TipoHtml.${tpdt.tpht}" />
                </p>
            </div>
            <div class="col-md-3 form-group">
                <label for="tpdt.tipoElemento"><fmt:message key="tpdt.tipoElemento" /></label>
                <p class="form-control-static">
                    ${tpdt.tipoElemento} -
                    <fmt:message key="TipoElemento.${tpdt.tipoElemento}" />
                </p>
            </div>
            <div class="col-md-5 form-group">
                <label for="tpdt.enti"><fmt:message key="tpdt.enti" /></label>
                <p class="form-control-static">
                    <c:if test="${tpdt.enti.id != null}">
                        <a href="enti-detalle.action?enti.id=${tpdt.enti.id}">${tpdt.enti.etiqueta}</a>
                    </c:if>
                </p>

            </div>
        </div>
    </fieldset>

    <c:if test="${tpdt.tipoElemento == 'CR'}">
        <fieldset>
            <legend>
                <fmt:message key="tpdt.cdrfList" />
            </legend>

            <ul class="pagination">
                <li><a class="btn" href="cdrf-alta.action?cdrf.tpdtId=${tpdt.id}"><i
                        class="glyphicon glyphicon-file"></i> <fmt:message key="boton.alta" /></a></li>
            </ul>

            <table class="table table-condensed table-hover table-nonfluid">
                <thead>
                    <tr>
                        <th />
                        <th><fmt:message key="cdrf.orden" /></th>
                        <th><fmt:message key="cdrf.valor" /></th>
                    </tr>
                </thead>

                <tbody>
                    <c:forEach items="${tpdt.cdrfList}" var="cdrf">
                        <tr>
                            <td><a
                                href="cdrf-eliminar.action?cdrf.tpdtId=${cdrf.tpdtId}&cdrf.valor=${cdrf.valor}"><i
                                    class="glyphicon glyphicon-remove"></i></a></td>
                            <td>${cdrf.orden}</td>
                            <td>${cdrf.valor}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </fieldset>
    </c:if>
</body>
</html>
