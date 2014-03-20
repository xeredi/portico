<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<title><fmt:message key="tpes-listado.title" /></title>
</head>
<body>
    <fmt:message key="format.datetime" var="pattern" scope="page" />

    <div class="btn-toolbar" role="toolbar">
        <div class="btn-group">
            <a class="btn btn-default" href="tpes-alta.action"><i
                class="glyphicon glyphicon-file"></i> <fmt:message key="boton.alta" /></a>
            <c:url value="tpes-filtro-popup.action" var="urlEditarFiltro">
                <c:forEach items="${tpesCriterio.searchLinks}" var="mapEntry">
                    <c:param name="tpesCriterio.${mapEntry.key}" value="${mapEntry.value}" />
                </c:forEach>
            </c:url>
            <a class="btn btn-default" href="${urlEditarFiltro}" role="button" data-toggle="modal"
                data-target="#tpes-filtro-div"><i class="glyphicon glyphicon-filter"></i> <fmt:message
                    key="boton.filtro" /></a>
        </div>
    </div>

    <div class="modal" id="tpes-filtro-div" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content"></div>
        </div>
    </div>

    <c:url value="tpes-listado.action" var="urlListado">
        <c:forEach items="${tpesCriterio.searchLinks}" var="mapEntry">
            <c:param name="tpesCriterio.${mapEntry.key}" value="${mapEntry.value}" />
        </c:forEach>
    </c:url>

    <c:url value="${urlListado}" var="urlListadoPrev">
        <c:param name="page" value="${tpsrs.page - 1}" />
    </c:url>
    <c:url value="${urlListado}" var="urlListadoNext">
        <c:param name="page" value="${tpsrs.page + 1}" />
    </c:url>

    <ul class="pagination">
        <c:if test="${tpess.hasPrevious}">
            <li><a class="btn" href="${urlListadoPrev}"><i
                    class="glyphicon glyphicon-chevron-left"></i></a></li>
        </c:if>
        <c:if test="${!tpess.hasPrevious}">
            <li><span class="btn"><i class="glyphicon glyphicon-chevron-left"></i></span></li>
        </c:if>
        <c:if test="${tpess.hasNext}">
            <li><a class="btn" href="${urlListadoNext}"><i
                    class="glyphicon glyphicon-chevron-right"></i></a></li>
        </c:if>
        <c:if test="${!tpess.hasNext}">
            <li><span class="btn"> <i class="glyphicon glyphicon-chevron-right"></i></span></li>
        </c:if>
        <c:if test="${tpess.pageCount > 0}">
            <li><span class="btn"> <fmt:message key="paginacion.leyenda">
                        <fmt:param value="${tpess.page}" />
                        <fmt:param value="${tpess.pageCount}" />
                        <fmt:param value="${tpess.count}" />
                    </fmt:message></span></li>
        </c:if>
    </ul>
    <table class="table table-condensed table-hover table-nonfluid">
        <thead>
            <tr>
                <th />
                <th><fmt:message key="tpes.id" /></th>
                <th><fmt:message key="tpes.codigo" /></th>
                <th><fmt:message key="tpes.nombre" /></th>
            </tr>
        </thead>

        <tbody>
            <c:forEach items="${tpess.list}" var="tpes">
                <tr>
                    <td><a href="tpes-modificar.action?tpes.id=${tpes.id}"><i
                            class="glyphicon glyphicon-edit"></i></a></td>
                    <td><a href="tpes-detalle.action?tpes.id=${tpes.id}"><b>${tpes.id}</b></a></td>
                    <td>${tpes.codigo}</td>
                    <td>${tpes.nombre}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
