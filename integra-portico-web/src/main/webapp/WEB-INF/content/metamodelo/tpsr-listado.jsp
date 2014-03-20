<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<title><fmt:message key="tpsr-listado.title" /></title>
</head>
<body>
    <fmt:message key="format.datetime" var="pattern" scope="page" />

    <div class="btn-toolbar" role="toolbar">
        <div class="btn-group">
            <a class="btn btn-default" href="tpsr-alta.action"><i
                class="glyphicon glyphicon-file"></i> <fmt:message key="boton.alta" /></a>
            <c:url value="tpsr-filtro-popup.action" var="urlFiltro">
                <c:forEach items="${tpsrCriterio.searchLinks}" var="mapEntry">
                    <c:param name="tpsrCriterio.${mapEntry.key}" value="${mapEntry.value}" />
                </c:forEach>
            </c:url>
            <a class="btn btn-default" href="${urlFiltro}" role="button" data-toggle="modal"
                data-target="#tpsr-filtro-div"><i class="glyphicon glyphicon-filter"></i> <fmt:message
                    key="boton.filtro" /></a>
        </div>
    </div>

    <div class="modal" id="tpsr-filtro-div" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content"></div>
        </div>
    </div>

    <c:url value="tpsr-listado.action" var="urlListado">
        <c:forEach items="${tpsrCriterio.searchLinks}" var="mapEntry">
            <c:param name="tpsrCriterio.${mapEntry.key}" value="${mapEntry.value}" />
        </c:forEach>
    </c:url>

    <c:url value="${urlListado}" var="urlListadoPrev">
        <c:param name="page" value="${tpsrs.page - 1}" />
    </c:url>
    <c:url value="${urlListado}" var="urlListadoNext">
        <c:param name="page" value="${tpsrs.page + 1}" />
    </c:url>

    <ul class="pagination">
        <c:if test="${tpsrs.hasPrevious}">
            <li><a class="btn" href="${urlListadoPrev}"><i
                    class="glyphicon glyphicon-chevron-left"></i></a></li>
        </c:if>
        <c:if test="${!tpsrs.hasPrevious}">
            <li><span class="btn"><i class="glyphicon glyphicon-chevron-left"></i></span></li>
        </c:if>
        <c:if test="${tpsrs.hasNext}">
            <li><a class="btn" href="${urlListadoNext}"><i
                    class="glyphicon glyphicon-chevron-right"></i></a></li>
        </c:if>
        <c:if test="${!tpsrs.hasNext}">
            <li><span class="btn"> <i class="glyphicon glyphicon-chevron-right"></i></span></li>
        </c:if>
        <c:if test="${tpsrs.pageCount > 0}">
            <li><span class="btn"> <fmt:message key="paginacion.leyenda">
                        <fmt:param value="${tpsrs.page}" />
                        <fmt:param value="${tpsrs.pageCount}" />
                        <fmt:param value="${tpsrs.count}" />
                    </fmt:message></span></li>
        </c:if>
    </ul>
    <table class="table table-condensed table-hover table-nonfluid">
        <thead>
            <tr>
                <th />
                <th><fmt:message key="enti.id" /></th>
                <th><fmt:message key="enti.codigo" /></th>
                <th><fmt:message key="enti.nombre" /></th>
                <th><fmt:message key="enti.cmdAlta" /></th>
                <th><fmt:message key="enti.cmdBaja" /></th>
                <th><fmt:message key="enti.cmdEdicion" /></th>
                <th><fmt:message key="enti.cmdDuplicado" /></th>
                <th><fmt:message key="tpsr.temporal" /></th>
                <th><fmt:message key="tpsr.facturable" /></th>
                <th><fmt:message key="tpsr.tpdtEstado" /></th>
            </tr>
        </thead>

        <tbody>
            <c:forEach items="${tpsrs.list}" var="enti">
                <tr>
                    <td><a href="tpsr-modificar.action?tpsr.id=${enti.id}"><i
                            class="glyphicon glyphicon-edit"></i></a></td>
                    <td><a href="tpsr-detalle.action?tpsr.id=${enti.id}"><b>${enti.id}</b></a></td>
                    <td>${enti.codigo}</td>
                    <td>${enti.nombre}</td>
                    <td><c:if test="${enti.cmdAlta}">
                            <i class="glyphicon glyphicon-ok"></i>
                        </c:if></td>
                    <td><c:if test="${enti.cmdBaja}">
                            <i class="glyphicon glyphicon-ok"></i>
                        </c:if></td>
                    <td><c:if test="${enti.cmdEdicion}">
                            <i class="glyphicon glyphicon-ok"></i>
                        </c:if></td>
                    <td><c:if test="${enti.cmdDuplicado}">
                            <i class="glyphicon glyphicon-ok"></i>
                        </c:if></td>
                    <td><c:if test="${enti.temporal}">
                            <i class="glyphicon glyphicon-ok"></i>
                        </c:if></td>
                    <td><c:if test="${enti.facturable}">
                            <i class="glyphicon glyphicon-ok"></i>
                        </c:if></td>
                    <td><c:if test="${enti.tpdtEstado != null}">
                            <a href="tpdt-detalle.action?tpdt.id=${enti.tpdtEstado.id}">${enti.tpdtEstado.nombre}</a>
                        </c:if></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
