<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<title><fmt:message key="item.listado">
        <fmt:param value="${enti.nombre}" />
    </fmt:message></title>
</head>
<body>
    <fmt:message key="format.datetime" var="datetimePattern" scope="page" />
    <fmt:message key="format.integer" var="integerPattern" scope="page" />
    <fmt:message key="format.double" var="doublePattern" scope="page" />

    <div class="btn-toolbar" role="toolbar">
        <div class="btn-group">
            <a class="btn btn-default" href="pepr-detalle.action?pepr.id=${itemCriterio.pepr.id}"><i
                class="glyphicon glyphicon-home"></i> <fmt:message key="boton.volver" /></a>
            <c:url value="estd-xls-export.action" var="urlExportarFiltro">
                <c:forEach items="${itemCriterio.searchLinks}" var="mapEntry">
                    <c:param name="itemCriterio.${mapEntry.key}" value="${mapEntry.value}" />
                </c:forEach>
            </c:url>
            <a class="btn btn-default" href="${urlExportarFiltro}"><i
                class="glyphicon glyphicon-book"></i> <fmt:message key="boton.exportar" /></a>
            <c:url value="estd-filtro-popup.action" var="urlFiltro">
                <c:forEach items="${itemCriterio.searchLinks}" var="mapEntry">
                    <c:param name="itemCriterio.${mapEntry.key}" value="${mapEntry.value}" />
                </c:forEach>
                <c:param name="limit" value="${limit}" />
            </c:url>
            <a class="btn btn-default" href="${urlFiltro}" role="button" data-toggle="modal"
                data-target="#estd-filtro-div"><i class="glyphicon glyphicon-filter"></i> <fmt:message
                    key="boton.filtro" /></a>
        </div>
    </div>

    <div class="modal" id="estd-filtro-div" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content"></div>
        </div>
    </div>

    <c:url value="estd-listado.action" var="urlListado">
        <c:forEach items="${itemCriterio.searchLinks}" var="mapEntry">
            <c:param name="itemCriterio.${mapEntry.key}" value="${mapEntry.value}" />
        </c:forEach>
        <c:param name="limit" value="${limit}" />
    </c:url>

    <c:url value="${urlListado}" var="urlListadoPrev">
        <c:param name="page" value="${itemList.page - 1}" />
    </c:url>
    <c:url value="${urlListado}" var="urlListadoNext">
        <c:param name="page" value="${itemList.page + 1}" />
    </c:url>

    <ul class="pagination">
        <c:if test="${itemList.hasPrevious}">
            <li><a class="btn" href="${urlListadoPrev}"><i
                    class="glyphicon glyphicon-chevron-left"></i></a></li>
        </c:if>
        <c:if test="${!itemList.hasPrevious}">
            <li><span class="btn"><i class="glyphicon glyphicon-chevron-left"></i></span></li>
        </c:if>
        <c:if test="${itemList.hasNext}">
            <li><a class="btn" href="${urlListadoNext}"><i
                    class="glyphicon glyphicon-chevron-right"></i></a></li>
        </c:if>
        <c:if test="${!itemList.hasNext}">
            <li><span class="btn"> <i class="glyphicon glyphicon-chevron-right"></i></span></li>
        </c:if>
        <c:if test="${itemList.pageCount > 0}">
            <li><span class="btn"> <fmt:message key="paginacion.leyenda">
                        <fmt:param value="${itemList.page}" />
                        <fmt:param value="${itemList.pageCount}" />
                        <fmt:param value="${itemList.count}" />
                    </fmt:message></span></li>
        </c:if>
    </ul>

    <table class="table table-condensed table-hover table-nonfluid">
        <thead>
            <tr>
                <th class="buttonLinks" nowrap="nowrap"/>
                <th class="codigo" nowrap="nowrap"><fmt:message key="estd.pepr" /></th>
                <th class="codigo" nowrap="nowrap"><fmt:message key="estd.autp" /></th>

                <c:forEach items="${enti.entdList}" var="tpdtId">
                    <c:set var="entd" value="${enti.entdMap[tpdtId]}" />

                    <c:if test="${entd.gridable}">
                        <th nowrap="nowrap"><c:choose>
                                <c:when
                                    test="${entd.tpdt.tipoElemento eq 'ND' || entd.tpdt.tipoElemento eq 'NE'}">
                                    <span class="pull-right">${entd.etiqueta}</span>
                                </c:when>
                                <c:otherwise>${entd.etiqueta}
                                </c:otherwise>
                            </c:choose></th>
                    </c:if>
                </c:forEach>
            </tr>
        </thead>

        <tbody>
            <c:forEach items="${itemList.list}" var="item">
                <tr>
                    <td><a href="estd-detalle.action?item.id=${item.id}"><i
                            class="glyphicon glyphicon-search"></i></a></td>
                    <td>${item.pepr.etiqueta}</td>
                    <td>${item.autp.parametro}</td>
                    <c:forEach items="${enti.entdList}" var="tpdtId">
                        <c:set var="entd" value="${enti.entdMap[tpdtId]}" />

                        <c:if test="${entd.gridable}">
                            <c:set var="itdt" value="${item.itdtMap[entd.tpdt.id]}" />
                            <c:if test="${itdt == null || !itdt.filled}">
                                <td>&nbsp;</td>
                            </c:if>

                            <c:if test="${itdt != null && itdt.filled}">
                                <c:choose>
                                    <c:when test="${entd.tpdt.tipoElemento eq 'BO'}">
                                        <td><c:if test="${itdt.booleano}">
                                                <i class="glyphicon glyphicon-ok"></i>
                                            </c:if></td>
                                    </c:when>
                                    <c:when test="${entd.tpdt.tipoElemento eq 'ND'}">
                                        <td><span class="pull-right"><fmt:formatNumber
                                                    pattern="${doublePattern}"
                                                    value="${itdt.cantidadDecimal}" /></span></td>
                                    </c:when>
                                    <c:when test="${entd.tpdt.tipoElemento eq 'NE'}">
                                        <td><span class="pull-right"><fmt:formatNumber
                                                    pattern="${integerPattern}"
                                                    value="${itdt.cantidadEntera}" /></span></td>
                                    </c:when>
                                    <c:when
                                        test="${entd.tpdt.tipoElemento eq 'CR' || entd.tpdt.tipoElemento eq 'TX'}">
                                        <td>${itdt.cadena}</td>
                                    </c:when>
                                    <c:when test="${entd.tpdt.tipoElemento eq 'PR'}">
                                        <td title="${itdt.prmt.etiqueta}">${itdt.prmt.parametro}</td>
                                    </c:when>
                                    <c:otherwise>
                                        <td>Tipo Desconocido ${entd.tpdt.tipoElemento}</td>
                                    </c:otherwise>
                                </c:choose>
                            </c:if>
                        </c:if>
                    </c:forEach>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
