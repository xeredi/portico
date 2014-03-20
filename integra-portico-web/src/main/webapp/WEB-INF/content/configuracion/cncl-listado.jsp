<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<title><fmt:message key="cncl-listado.title" /></title>
</head>
<body>
    <fmt:message key="format.datetime" var="pattern" scope="page" />

    <div class="btn-toolbar" role="toolbar">
        <div class="btn-group">
            <a class="btn btn-default" href="cncl-alta.action"><i
                class="glyphicon glyphicon-file"></i> <fmt:message key="boton.alta" /></a>
            <c:url value="cncl-filtro-popup.action" var="urlFiltro">
                <c:forEach items="${cnclCriterio.searchLinks}" var="mapEntry">
                    <c:param name="cnclCriterio.${mapEntry.key}" value="${mapEntry.value}" />
                </c:forEach>
            </c:url>
            <a class="btn btn-default" href="${urlFiltro}" role="button" data-toggle="modal"
                data-target="#cncl-filtro-div"><i class="glyphicon glyphicon-filter"></i> <fmt:message
                    key="boton.filtro" /></a>
        </div>
    </div>

    <div class="modal" id="cncl-filtro-div" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content"></div>
        </div>
    </div>

    <c:url value="cncl-listado.action" var="urlListado">
        <c:forEach items="${cnclCriterio.searchLinks}" var="mapEntry">
            <c:param name="cnclCriterio.${mapEntry.key}" value="${mapEntry.value}" />
        </c:forEach>
    </c:url>

    <c:url value="${urlListado}" var="urlListadoPrev">
        <c:param name="page" value="${cncls.page - 1}" />
    </c:url>
    <c:url value="${urlListado}" var="urlListadoNext">
        <c:param name="page" value="${cncls.page + 1}" />
    </c:url>

    <ul class="pagination">
        <c:if test="${cncls.hasPrevious}">
            <li><a class="btn" href="${urlListadoPrev}"><i
                    class="glyphicon glyphicon-chevron-left"></i></a></li>
        </c:if>
        <c:if test="${!cncls.hasPrevious}">
            <li><span class="btn"><i class="glyphicon glyphicon-chevron-left"></i></span></li>
        </c:if>
        <c:if test="${cncls.hasNext}">
            <li><a class="btn" href="${urlListadoNext}"><i
                    class="glyphicon glyphicon-chevron-right"></i></a></li>
        </c:if>
        <c:if test="${!cncls.hasNext}">
            <li><span class="btn"> <i class="glyphicon glyphicon-chevron-right"></i></span></li>
        </c:if>
        <c:if test="${cncls.pageCount > 0}">
            <li><span class="btn"> <fmt:message key="paginacion.leyenda">
                        <fmt:param value="${cncls.page}" />
                        <fmt:param value="${cncls.pageCount}" />
                        <fmt:param value="${cncls.count}" />
                    </fmt:message></span></li>
        </c:if>
    </ul>

    <table class="table table-condensed table-hover table-nonfluid">
        <thead>
            <tr>
                <th />
                <th><fmt:message key="cncl.clave" /></th>
                <th><fmt:message key="cncl.tipoValor" /></th>
                <th><fmt:message key="cncl.valorDefecto" /></th>

                <c:forEach items="${cnens}" var="cnen">
                    <th title="${cnen.nombre}">${cnen.codigo}</th>
                </c:forEach>
            </tr>
        </thead>

        <tbody>
            <c:forEach items="${cncls.list}" var="cncl">
                <tr>
                    <td><a href="cncl-modificar.action?cncl.id=${cncl.id}"><i
                            class="glyphicon glyphicon-edit"></i></a></td>
                    <td><a href="cncl-detalle.action?cncl.id=${cncl.id}"><b>${cncl.clave}</b></a></td>
                    <td title='<fmt:message key="TipoValor.${cncl.tipoValor}" />'>${cncl.tipoValor}</td>
                    <td>${cncl.valorDefecto}</td>

                    <c:forEach items="${cnens}" var="cnen">
                        <td>${cncl.cnvlMap[cnen.id]}</td>
                    </c:forEach>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
