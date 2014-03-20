<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<title><fmt:message key="tpdt-listado.title" /></title>
</head>
<body>
    <fmt:message key="format.datetime" var="pattern" scope="page" />

    <div class="btn-toolbar" role="toolbar">
        <div class="btn-group">

            <a class="btn btn-default" href="tpdt-alta.action"><i
                class="glyphicon glyphicon-file"></i> <fmt:message key="boton.alta" /></a>
            <c:url value="tpdt-filtro-popup.action" var="urlFiltro">
                <c:forEach items="${tpdtCriterio.searchLinks}" var="mapEntry">
                    <c:param name="tpdtCriterio.${mapEntry.key}" value="${mapEntry.value}" />
                </c:forEach>
            </c:url>
            <a class="btn btn-default" href="${urlFiltro}" role="button" data-toggle="modal"
                data-target="#tpdt-filtro-div"><i class="glyphicon glyphicon-filter"></i> <fmt:message
                    key="boton.filtro" /></a>
        </div>
    </div>
    
    <div class="modal" id="tpdt-filtro-div" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content"></div>
        </div>
    </div>

    <c:url value="tpdt-listado.action" var="urlListado">
        <c:forEach items="${tpdtCriterio.searchLinks}" var="mapEntry">
            <c:param name="tpdtCriterio.${mapEntry.key}" value="${mapEntry.value}" />
        </c:forEach>
    </c:url>

    <c:url value="${urlListado}" var="urlListadoPrev">
        <c:param name="page" value="${tpdts.page - 1}" />
    </c:url>
    <c:url value="${urlListado}" var="urlListadoNext">
        <c:param name="page" value="${tpdts.page + 1}" />
    </c:url>

    <ul class="pagination">
        <c:if test="${tpdts.hasPrevious}">
            <li><a class="btn" href="${urlListadoPrev}"><i
                    class="glyphicon glyphicon-chevron-left"></i></a></li>
        </c:if>
        <c:if test="${!tpdts.hasPrevious}">
            <li><span class="btn"><i class="glyphicon glyphicon-chevron-left"></i></span></li>
        </c:if>
        <c:if test="${tpdts.hasNext}">
            <li><a class="btn" href="${urlListadoNext}"><i
                    class="glyphicon glyphicon-chevron-right"></i></a></li>
        </c:if>
        <c:if test="${!tpdts.hasNext}">
            <li><span class="btn"> <i class="glyphicon glyphicon-chevron-right"></i></span></li>
        </c:if>
        <c:if test="${tpdts.pageCount > 0}">
            <li><span class="btn"> <fmt:message key="paginacion.leyenda">
                        <fmt:param value="${tpdts.page}" />
                        <fmt:param value="${tpdts.pageCount}" />
                        <fmt:param value="${tpdts.count}" />
                    </fmt:message></span></li>
        </c:if>
    </ul>

    <table class="table table-condensed table-hover table-nonfluid">
        <thead>
            <tr>
                <th />
                <th><fmt:message key="tpdt.id" /></th>
                <th><fmt:message key="tpdt.codigo" /></th>
                <th><fmt:message key="tpdt.nombre" /></th>
                <th><fmt:message key="tpdt.tipoElemento" /></th>
                <th><fmt:message key="tpdt.tpht" /></th>
                <th><fmt:message key="tpdt.enti.nombre" /></th>
            </tr>
        </thead>

        <tbody>
            <c:forEach items="${tpdts.list}" var="tpdt">
                <tr>
                    <td><a href="tpdt-modificar.action?tpdt.id=${tpdt.id}"><i
                            class="glyphicon glyphicon-edit"></i></a></td>
                    <td><a href="tpdt-detalle.action?tpdt.id=${tpdt.id}"><b>${tpdt.id}</b></a></td>
                    <td>${tpdt.codigo}</td>
                    <td>${tpdt.nombre}</td>
                    <td title="<fmt:message key="TipoElemento.${tpdt.tipoElemento}" />">${tpdt.tipoElemento}-<fmt:message
                            key="TipoElemento.${tpdt.tipoElemento}" />
                    </td>
                    <td title="<fmt:message key="TipoHtml.${tpdt.tpht}" />">${tpdt.tpht}-<fmt:message
                            key="TipoHtml.${tpdt.tpht}" />
                    </td>
                    <td>${tpdt.enti.nombre}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
