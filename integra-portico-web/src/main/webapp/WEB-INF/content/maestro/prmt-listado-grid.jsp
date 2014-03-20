<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<fmt:message key="format.datetime" var="datetimePattern" scope="page" />
<fmt:message key="format.date" var="datePattern" scope="page" />
<fmt:message key="format.integer" var="integerPattern" scope="page" />
<fmt:message key="format.double" var="doublePattern" scope="page" />

<c:url value="prmt-listado.action" var="urlListado">
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

<div class="table-responsive">
    <table class="table table-condensed table-hover table-nonfluid">
        <thead>
            <tr>
                <th class="buttonLinks" nowrap="nowrap" />
                <th class="codigo" nowrap="nowrap"><fmt:message key="prmt.parametro" /></th>
                <c:if test="${enti.i18n}">
                    <th nowrap="nowrap"><fmt:message key="prmt.i18n.texto" /></th>
                </c:if>
                <c:if test="${enti.tempExp}">
                    <th class="date" nowrap="nowrap"><fmt:message key="prmt.prvr.finicio" /></th>
                    <th class="date" nowrap="nowrap"><fmt:message key="prmt.prvr.ffin" /></th>
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
                    <td><a href="prmt-detalle.action?item.id=${item.id}"><i
                            class="glyphicon glyphicon-search"></i></a></td>
                    <td>${item.parametro}</td>
                    <c:if test="${enti.i18n}">
                        <td>${item.i18n.texto}</td>
                    </c:if>
                    <c:if test="${enti.tempExp}">
                        <td><fmt:formatDate pattern="${datePattern}"
                                value="${item.prvr.finicio}" /></td>
                        <td><fmt:formatDate pattern="${datePattern}" value="${item.prvr.ffin}" /></td>
                    </c:if>
                    <c:forEach items="${enti.entdList}" var="tpdtId">
                        <c:set var="entd" value="${enti.entdMap[tpdtId]}" />

                        <c:if test="${entd.gridable}">
                            <c:set var="itdt" value="${item.itdtMap[entd.tpdt.id]}" />
                            <c:if test="${itdt == null || !itdt.filled}">
                                <td></td>
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
                                    <c:when test="${entd.tpdt.tipoElemento eq 'FE'}">
                                        <td><span class="pull-right"><fmt:formatDate
                                                    pattern="${datePattern}" value="${itdt.fecha}" /></span></td>
                                    </c:when>
                                    <c:when test="${entd.tpdt.tipoElemento eq 'FH'}">
                                        <td><span class="pull-right"><fmt:formatDate
                                                    pattern="${datetimePattern}"
                                                    value="${itdt.fecha}" /></span></td>
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
</div>
