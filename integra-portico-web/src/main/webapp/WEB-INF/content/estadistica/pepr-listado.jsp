<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<title><fmt:message key="pepr-listado.title" /></title>
</head>
<body>
    <fmt:message key="format.datetime" var="datetimePattern" scope="page" />

    <div class="btn-toolbar" role="toolbar">
        <div class="btn-group">
            <a class="btn btn-default" href="pepr-alta.action"><i
                class="glyphicon glyphicon-file"></i> <fmt:message key="boton.alta" /></a>
            <c:url value="pepr-filtro-popup.action" var="urlFiltro">
                <c:forEach items="${peprCriterio.searchLinks}" var="mapEntry">
                    <c:param name="peprCriterio.${mapEntry.key}" value="${mapEntry.value}" />
                </c:forEach>
            </c:url>
            <a class="btn btn-default" data-remote="${urlFiltro}" role="button" data-toggle="modal"
                data-target="#pepr-filtro-div"><i class="glyphicon glyphicon-filter"></i> <fmt:message
                    key="boton.filtro" /></a>
        </div>
    </div>

    <div class="modal" id="pepr-filtro-div" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content"></div>
        </div>
    </div>

    <c:url value="pepr-listado.action" var="urlListado">
        <c:forEach items="${peprCriterio.searchLinks}" var="mapEntry">
            <c:param name="peprCriterio.${mapEntry.key}" value="${mapEntry.value}" />
        </c:forEach>
    </c:url>

    <c:url value="${urlListado}" var="urlListadoPrev">
        <c:param name="page" value="${peprs.page - 1}" />
    </c:url>
    <c:url value="${urlListado}" var="urlListadoNext">
        <c:param name="page" value="${peprs.page + 1}" />
    </c:url>

    <ul class="pagination">
        <c:if test="${peprs.hasPrevious}">
            <li><a class="btn" href="${urlListadoPrev}"><i
                    class="glyphicon glyphicon-chevron-left"></i></a></li>
        </c:if>
        <c:if test="${!peprs.hasPrevious}">
            <li><span class="btn"><i class="glyphicon glyphicon-chevron-left"></i></span></li>
        </c:if>
        <c:if test="${peprs.hasNext}">
            <li><a class="btn" href="${urlListadoNext}"><i
                    class="glyphicon glyphicon-chevron-right"></i></a></li>
        </c:if>
        <c:if test="${!peprs.hasNext}">
            <li><span class="btn"> <i class="glyphicon glyphicon-chevron-right"></i></span></li>
        </c:if>
        <c:if test="${peprs.pageCount > 0}">
            <li><span class="btn"> <fmt:message key="paginacion.leyenda">
                        <fmt:param value="${peprs.page}" />
                        <fmt:param value="${peprs.pageCount}" />
                        <fmt:param value="${peprs.count}" />
                    </fmt:message></span></li>
        </c:if>
    </ul>

    <table class="table table-condensed table-hover table-nonfluid">
        <thead>
            <tr>
                <th class="buttonLinks" />
                <th class="codigo"><fmt:message key="pepr.autp" /></th>
                <th><fmt:message key="pepr.anio" /></th>
                <th><fmt:message key="pepr.mes" /></th>
                <th><fmt:message key="pepr.cdmsGenerado" /></th>
            </tr>
        </thead>

        <tbody>
            <c:forEach items="${peprs.list}" var="pepr">
                <tr>
                    <td />
                    <td><a href="pepr-detalle.action?pepr.id=${pepr.id}"><b>${pepr.autp.parametro}</b></a></td>
                    <td><span class="pull-right">${pepr.anio}</span></td>
                    <td><span class="pull-right">${pepr.mes}</span></td>
                    <td><c:if test="${pepr.cdmsGenerado}">
                            <span class="pull-right"><i class="glyphicon glyphicon-ok"></i></span>
                        </c:if></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
