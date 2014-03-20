<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<title><fmt:message key="tppr-listado.title" /></title>
</head>
<body>
    <fmt:message key="format.datetime" var="pattern" scope="page" />

    <div class="btn-toolbar" role="toolbar">
        <div class="btn-group">
            <a class="btn btn-default" href="tppr-alta.action"><i
                class="glyphicon glyphicon-file"></i> <fmt:message key="boton.alta" /></a>
            <c:url value="tppr-filtro-popup.action" var="urlFiltro">
                <c:forEach items="${tpprCriterio.searchLinks}" var="mapEntry">
                    <c:param name="tpprCriterio.${mapEntry.key}" value="${mapEntry.value}" />
                </c:forEach>
            </c:url>
            <a class="btn btn-default" href="${urlFiltro}" role="button" data-toggle="modal"
                data-target="#tppr-filtro-div"><i class="glyphicon glyphicon-filter"></i> <fmt:message
                    key="boton.filtro" /></a>
        </div>
    </div>

    <div class="modal" id="tppr-filtro-div" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content"></div>
        </div>
    </div>

    <c:url value="tppr-listado.action" var="urlListado">
        <c:forEach items="${tpprCriterio.searchLinks}" var="mapEntry">
            <c:param name="tpprCriterio.${mapEntry.key}" value="${mapEntry.value}" />
        </c:forEach>
    </c:url>

    <c:url value="${urlListado}" var="urlListadoPrev">
        <c:param name="page" value="${tpprs.page - 1}" />
    </c:url>
    <c:url value="${urlListado}" var="urlListadoNext">
        <c:param name="page" value="${tpprs.page + 1}" />
    </c:url>

    <ul class="pagination">
        <c:if test="${tpprs.hasPrevious}">
            <li><a class="btn" href="${urlListadoPrev}"><i
                    class="glyphicon glyphicon-chevron-left"></i></a></li>
        </c:if>
        <c:if test="${!tpprs.hasPrevious}">
            <li><span class="btn"><i class="glyphicon glyphicon-chevron-left"></i></span></li>
        </c:if>
        <c:if test="${tpprs.hasNext}">
            <li><a class="btn" href="${urlListadoNext}"><i
                    class="glyphicon glyphicon-chevron-right"></i></a></li>
        </c:if>
        <c:if test="${!tpprs.hasNext}">
            <li><span class="btn"> <i class="glyphicon glyphicon-chevron-right"></i></span></li>
        </c:if>
        <c:if test="${tpprs.pageCount > 0}">
            <li><span class="btn"> <fmt:message key="paginacion.leyenda">
                        <fmt:param value="${tpprs.page}" />
                        <fmt:param value="${tpprs.pageCount}" />
                        <fmt:param value="${tpprs.count}" />
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
                <th><fmt:message key="tppr.i18n" /></th>
                <th><fmt:message key="tppr.tempExp" /></th>
            </tr>
        </thead>

        <tbody>
            <c:forEach items="${tpprs.list}" var="enti">
                <tr>
                    <td><a href="tppr-modificar.action?tppr.id=${enti.id}"><i
                            class="glyphicon glyphicon-edit"></i></a></td>
                    <td><a href="tppr-detalle.action?tppr.id=${enti.id}"><b>${enti.id}</b></a></td>
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
                    <td><c:if test="${enti.i18n}">
                            <i class="glyphicon glyphicon-ok"></i>
                        </c:if></td>
                    <td><c:if test="${enti.tempExp}">
                            <i class="glyphicon glyphicon-ok"></i>
                        </c:if></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
