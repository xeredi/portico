<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<title><fmt:message key="cnci-listado.title" /></title>
</head>
<body>
    <fmt:message key="format.datetime" var="pattern" scope="page" />

    <div class="btn-toolbar" role="toolbar">
        <div class="btn-group">
            <a class="btn btn-default" href="cnci-alta.action"><i
                class="glyphicon glyphicon-file"></i> <fmt:message key="boton.alta" /></a>
            <c:url value="cnci-filtro-popup.action" var="urlFiltro">
                <c:forEach items="${cnciCriterio.searchLinks}" var="mapEntry">
                    <c:param name="cnciCriterio.${mapEntry.key}" value="${mapEntry.value}" />
                </c:forEach>
            </c:url>
            <a class="btn btn-default" href="${urlFiltro}" role="button" data-toggle="modal"
                data-target="#cnci-filtro-div"><i class="glyphicon glyphicon-filter"></i> <fmt:message
                    key="boton.filtro" /></a>
        </div>
    </div>

    <div class="modal" id="cnci-filtro-div" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content"></div>
        </div>
    </div>

    <c:url value="cnci-listado.action" var="urlListado">
        <c:forEach items="${cnciCriterio.searchLinks}" var="mapEntry">
            <c:param name="cnciCriterio.${mapEntry.key}" value="${mapEntry.value}" />
        </c:forEach>
    </c:url>

    <c:url value="${urlListado}" var="urlListadoPrev">
        <c:param name="page" value="${cncis.page - 1}" />
    </c:url>
    <c:url value="${urlListado}" var="urlListadoNext">
        <c:param name="page" value="${cncis.page + 1}" />
    </c:url>

    <ul class="pagination">
        <c:if test="${cncis.hasPrevious}">
            <li><a class="btn" href="${urlListadoPrev}"><i
                    class="glyphicon glyphicon-chevron-left"></i></a></li>
        </c:if>
        <c:if test="${!cncis.hasPrevious}">
            <li><span class="btn"><i class="glyphicon glyphicon-chevron-left"></i></span></li>
        </c:if>
        <c:if test="${cncis.hasNext}">
            <li><a class="btn" href="${urlListadoNext}"><i
                    class="glyphicon glyphicon-chevron-right"></i></a></li>
        </c:if>
        <c:if test="${!cncis.hasNext}">
            <li><span class="btn"> <i class="glyphicon glyphicon-chevron-right"></i></span></li>
        </c:if>
        <c:if test="${cncis.pageCount > 0}">
            <li><span class="btn"> <fmt:message key="paginacion.leyenda">
                        <fmt:param value="${cncis.page}" />
                        <fmt:param value="${cncis.pageCount}" />
                        <fmt:param value="${cncis.count}" />
                    </fmt:message></span></li>
        </c:if>
    </ul>

    <table class="table table-condensed table-hover table-nonfluid">
        <thead>
            <tr>
                <th />
                <th><fmt:message key="cnci.clave" /></th>
                <th><fmt:message key="cnci.valorDefecto" /></th>

                <c:forEach items="${cnids}" var="cnid">
                    <th title="${cnid.descripcion}">${cnid.codigo}</th>
                </c:forEach>
            </tr>
        </thead>

        <tbody>
            <c:forEach items="${cncis.list}" var="cnci">
                <tr>
                    <td><a href="cnci-modificar.action?cnci.id=${cnci.id}"><i
                            class="glyphicon glyphicon-edit"></i></a></td>
                    <td><a href="cnci-detalle.action?cnci.id=${cnci.id}"><b>${cnci.clave}</b></a></td>
                    <td>${cnci.valorDefecto}</td>

                    <c:forEach items="${cnids}" var="cnid">
                        <td>${cnci.cnviMap[cnid.id]}</td>
                    </c:forEach>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
