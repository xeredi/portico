<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<title><fmt:message key="prbt-listado.title" /></title>
</head>
<body>
    <fmt:message key="format.datetime" var="datetimePattern" scope="page" />
    <fmt:message key="format.integer" var="integerPattern" scope="page" />

    <div class="btn-toolbar" role="toolbar">
        <div class="btn-group">
            <c:url value="prbt-xls-export.action" var="urlExportarFiltro">
                <c:forEach items="${prbtCriterio.searchLinks}" var="mapEntry">
                    <c:param name="itemCriterio.${mapEntry.key}" value="${mapEntry.value}" />
                </c:forEach>
            </c:url>
            <a class="btn btn-default" href="${urlExportarFiltro}"><i
                class="glyphicon glyphicon-book"></i> <fmt:message key="boton.exportar" /></a>
            <c:url value="prbt-filtro-popup.action" var="urlFiltro">
                <c:forEach items="${prbtCriterio.searchLinks}" var="mapEntry">
                    <c:param name="prbtCriterio.${mapEntry.key}" value="${mapEntry.value}" />
                </c:forEach>
            </c:url>
            <a data-toggle="modal" href="${urlFiltro}" data-target="#prbt-filtro-div"
                class="btn btn-default"><i class="glyphicon glyphicon-filter"></i> <fmt:message
                    key="boton.filtro" /></a>
        </div>
    </div>

    <div class="modal" id="prbt-filtro-div" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content"></div>
        </div>
    </div>

    <c:url value="prbt-listado.action" var="urlListado">
        <c:forEach items="${prbtCriterio.searchLinks}" var="mapEntry">
            <c:param name="prbtCriterio.${mapEntry.key}" value="${mapEntry.value}" />
        </c:forEach>
    </c:url>

    <c:url value="${urlListado}" var="urlListadoPrev">
        <c:param name="page" value="${prbts.page - 1}" />
    </c:url>
    <c:url value="${urlListado}" var="urlListadoNext">
        <c:param name="page" value="${prbts.page + 1}" />
    </c:url>

    <ul class="pagination">
        <c:if test="${prbts.hasPrevious}">
            <li><a class="btn" href="${urlListadoPrev}"><i
                    class="glyphicon glyphicon-chevron-left"></i></a></li>
        </c:if>
        <c:if test="${!prbts.hasPrevious}">
            <li><span class="btn"><i class="glyphicon glyphicon-chevron-left"></i></span></li>
        </c:if>
        <c:if test="${prbts.hasNext}">
            <li><a class="btn" href="${urlListadoNext}"><i
                    class="glyphicon glyphicon-chevron-right"></i></a></li>
        </c:if>
        <c:if test="${!prbts.hasNext}">
            <li><span class="btn"> <i class="glyphicon glyphicon-chevron-right"></i></span></li>
        </c:if>
        <c:if test="${prbts.pageCount > 0}">
            <li><span class="btn"> <fmt:message key="paginacion.leyenda">
                        <fmt:param value="${prbts.page}" />
                        <fmt:param value="${prbts.pageCount}" />
                        <fmt:param value="${prbts.count}" />
                    </fmt:message></span></li>
        </c:if>
    </ul>

    <table class="table table-condensed table-hover table-nonfluid">
        <thead>
            <tr>
                <th class="buttonLinks" />
                <th><fmt:message key="prbt.id" /></th>
                <th><fmt:message key="prbt.modulo" /></th>
                <th><fmt:message key="prbt.tipo" /></th>
                <th><fmt:message key="prbt.estado" /></th>
                <th><fmt:message key="prbt.falta" /></th>
                <th><fmt:message key="prbt.finicio" /></th>
                <th><fmt:message key="prbt.ffin" /></th>
                <th><fmt:message key="prbt.duracion" /></th>
                <th><fmt:message key="prbt.erroresCnt" /></th>
                <th><fmt:message key="prbt.alertasCnt" /></th>
                <th><fmt:message key="prbt.mensajesCnt" /></th>
            </tr>
        </thead>

        <tbody>
            <c:forEach items="${prbts.list}" var="prbt">
                <tr>
                    <td><a href="prbt-cancelar.action?prbt.id=${prbt.id}"><i
                            class="glyphicon glyphicon-remove"></i></a></td>
                    <td><a href="prbt-detalle.action?prbt.id=${prbt.id}"><b>${prbt.id}</b></a></td>
                    <td>${prbt.modulo}</td>
                    <td>${prbt.tipo}</td>
                    <td>${prbt.estado}</td>
                    <td><fmt:formatDate pattern="${datetimePattern}" value="${prbt.falta}" /></td>
                    <td><fmt:formatDate pattern="${datetimePattern}" value="${prbt.finicio}" /></td>
                    <td><fmt:formatDate pattern="${datetimePattern}" value="${prbt.ffin}" /></td>
                    <td><span class="pull-right"><fmt:formatNumber
                                pattern="${integerPattern}" value="${prbt.duracion}" /></span></td>
                    <td><span class="pull-right"><fmt:formatNumber
                                pattern="${integerPattern}" value="${prbt.erroresCnt}" /></span></td>
                    <td><span class="pull-right"><fmt:formatNumber
                                pattern="${integerPattern}" value="${prbt.alertasCnt}" /></span></td>
                    <td><span class="pull-right"><fmt:formatNumber
                                pattern="${integerPattern}" value="${prbt.mensajesCnt}" /></span></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</body>
</html>
