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
    <fmt:message key="format.date" var="datePattern" scope="page" />
    <fmt:message key="format.datetime" var="datetimePattern" scope="page" />
    <fmt:message key="format.integer" var="integerPattern" scope="page" />
    <fmt:message key="format.double" var="doublePattern" scope="page" />

    <div class="btn-toolbar" role="toolbar">
        <div class="btn-group">
            <a class="btn btn-default" href="tpsr-listado.action"><i
                class="glyphicon glyphicon-home"></i> <fmt:message key="boton.volver" /></a>
            <c:url value="srvc-filtro-popup.action" var="urlFiltro">
                <c:forEach items="${itemCriterio.searchLinks}" var="mapEntry">
                    <c:param name="itemCriterio.${mapEntry.key}" value="${mapEntry.value}" />
                </c:forEach>
                <c:param name="limit" value="${limit}" />
            </c:url>
            <a class="btn btn-default" href="${urlFiltro}" role="button" data-toggle="modal"
                data-target="#srvc-filtro-div"><i class="glyphicon glyphicon-filter"></i> <fmt:message
                    key="boton.filtro" /></a>
            <c:url value="srvc-xls-export.action" var="urlExportarFiltro">
                <c:forEach items="${itemCriterio.searchLinks}" var="mapEntry">
                    <c:param name="itemCriterio.${mapEntry.key}" value="${mapEntry.value}" />
                </c:forEach>
            </c:url>
            <a class="btn btn-default" href="${urlExportarFiltro}"><i
                class="glyphicon glyphicon-book"></i> <fmt:message key="boton.exportar" /></a>

            <div class="modal" id="srvc-filtro-div" tabindex="-1" role="dialog" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content"></div>
                </div>
            </div>
        </div>

        <div class="btn-group">
            <c:if test="${enti.cmdAlta}">
                <a class="btn btn-default" href="srvc-alta-popup.action?item.entiId=${enti.id}"
                    role="button" data-toggle="modal" data-target="#srvc-alta-div"><i
                    class="glyphicon glyphicon-file"></i> <fmt:message key="boton.alta" /></a>
                <div class="modal" id="srvc-alta-div" tabindex="-1" role="dialog" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content"></div>
                    </div>
                </div>
            </c:if>
            <c:if test="${enti.cmdEdicion}">
                <a class="btn btn-default" href="srvc-modificar-popup.action" role="button"
                    data-toggle="modal" data-target="#srvc-modificar-div"><i
                    class="glyphicon glyphicon-edit"></i> <fmt:message key="boton.modificar" /></a>
                <div class="modal" id="srvc-modificar-div" tabindex="-1" role="dialog"
                    aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content"></div>
                    </div>
                </div>
            </c:if>
            <c:if test="${enti.cmdDuplicado}">
                <a class="btn btn-default" href="srvc-duplicar-popup.action" role="button"
                    data-toggle="modal" data-target="#srvc-duplicar-div"><i
                    class="glyphicon glyphicon-tags"></i> <fmt:message key="boton.duplicar" /></a>
                <div class="modal" id="srvc-duplicar-div" tabindex="-1" role="dialog"
                    aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content"></div>
                    </div>
                </div>
            </c:if>
            <c:if test="${enti.cmdBaja}">
                <a class="btn btn-default" href="srvc-borrar-popup.action" role="button"
                    data-toggle="modal" data-target="#srvc-borrar-div"><i
                    class="glyphicon glyphicon-remove"></i> <fmt:message key="boton.borrar" /></a>
                <div class="modal" id="srvc-borrar-div" tabindex="-1" role="dialog"
                    aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content"></div>
                    </div>
                </div>
            </c:if>
        </div>
    </div>


    <c:url value="srvc-listado.action" var="urlListado">
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
                <th class="buttonLinks" />
                <th nowrap="nowrap"><fmt:message key="srvc.servicio" /></th>

                <c:if test="${not empty enti.tpdtEstado}">
                    <th nowrap="nowrap"><fmt:message key="srvc.estado" /></th>
                </c:if>

                <c:if test="${enti.temporal}">
                    <th class="date" nowrap="nowrap"><fmt:message key="srvc.finicio" /></th>
                    <th class="date" nowrap="nowrap"><fmt:message key="srvc.ffin" /></th>
                </c:if>

                <c:if test="${not enti.temporal}">
                    <th class="date" nowrap="nowrap"><fmt:message key="srvc.freferencia" /></th>
                </c:if>

                <c:forEach items="${enti.entdList}" var="tpdtId">
                    <c:set var="entd" value="${enti.entdMap[tpdtId]}" />

                    <c:if test="${entd.gridable}">
                        <th nowrap="nowrap"><c:choose>
                                <c:when
                                    test="${entd.tpdt.tipoElemento == 'ND' || entd.tpdt.tipoElemento == 'NE'}">
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
                    <td nowrap="nowrap"><a href="srvc-modificar.action?item.id=${item.id}"><i
                            class="glyphicon glyphicon-edit"></i></a><a
                        href="srvc-borrar.action?item.id=${item.id}"><i
                            class="glyphicon glyphicon-remove"></i></a></td>
                    <td nowrap="nowrap"><a href="srvc-detalle.action?item.id=${item.id}"><b>${item.etiqueta}</b></a></td>

                    <c:if test="${not empty enti.tpdtEstado}">
                        <td>${item.estado}</td>
                    </c:if>

                    <c:if test="${enti.temporal}">
                        <td nowrap="nowrap"><fmt:formatDate pattern="${datetimePattern}"
                                value="${item.finicio}" /></td>
                        <td nowrap="nowrap"><fmt:formatDate pattern="${datetimePattern}"
                                value="${item.ffin}" /></td>
                    </c:if>

                    <c:if test="${not enti.temporal}">
                        <td nowrap="nowrap"><fmt:formatDate pattern="${datetimePattern}"
                                value="${item.freferencia}" /></td>
                    </c:if>

                    <c:forEach items="${enti.entdList}" var="tpdtId">
                        <c:set var="entd" value="${enti.entdMap[tpdtId]}" />

                        <c:if test="${entd.gridable}">
                            <c:set var="itdt" value="${item.itdtMap[entd.tpdt.id]}" />

                            <c:if test="${itdt == null || !itdt.filled}">
                                <td>&nbsp;</td>
                            </c:if>

                            <c:if test="${itdt != null && itdt.filled}">
                                <c:choose>
                                    <c:when test="${entd.tpdt.tipoElemento == 'BO'}">
                                        <td><c:if test="${itdt.booleano}">
                                                <i class="glyphicon glyphicon-ok"></i>
                                            </c:if></td>
                                    </c:when>
                                    <c:when test="${entd.tpdt.tipoElemento == 'ND'}">
                                        <td><span class="pull-right"><fmt:formatNumber
                                                    pattern="${doublePattern}"
                                                    value="${itdt.cantidadDecimal}" /></span></td>
                                    </c:when>
                                    <c:when test="${entd.tpdt.tipoElemento == 'NE'}">
                                        <td><span class="pull-right"><fmt:formatNumber
                                                    pattern="${integerPattern}"
                                                    value="${itdt.cantidadEntera}" /></span></td>
                                    </c:when>
                                    <c:when
                                        test="${entd.tpdt.tipoElemento == 'CR' || entd.tpdt.tipoElemento == 'TX'}">
                                        <td>${itdt.cadena}</td>
                                    </c:when>
                                    <c:when test="${entd.tpdt.tipoElemento == 'PR'}">
                                        <td nowrap="nowrap" title="${itdt.prmt.etiqueta}">${itdt.prmt.parametro}</td>
                                    </c:when>
                                    <c:when test="${entd.tpdt.tipoElemento == 'SR'}">
                                        <td nowrap="nowrap">${itdt.srvc.etiqueta}</td>
                                    </c:when>
                                    <c:when test="${entd.tpdt.tipoElemento == 'FE'}">
                                        <td><fmt:formatDate pattern="${datePattern}"
                                                value="${itdt.fecha}" /></td>
                                    </c:when>
                                    <c:when test="${entd.tpdt.tipoElemento == 'FH'}">
                                        <td><fmt:formatDate pattern="${datetimePattern}"
                                                value="${itdt.fecha}" /></td>
                                    </c:when>
                                    <c:otherwise>
                                        <td>Tipo Desconocido ${entd.tpdt.tipoElemento}</td>
                                    </c:otherwise>
                                </c:choose>
                            </c:if>
                            <%--
                            <jsp:include page="/WEB-INF/content/include/item/item-td.jsp"
                                flush="true" /> --%>
                        </c:if>
                    </c:forEach>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</body>
</html>
