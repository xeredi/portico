<%@ page language="java" trimDirectiveWhitespaces="true"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<title><fmt:message key="item.detalle">
        <fmt:param value="${enti.nombre} (${item.srvc.etiqueta} - ${item.numero})" />
    </fmt:message></title>
</head>
<body>
    <fmt:message key="format.date" var="datePattern" scope="page" />
    <fmt:message key="format.datetime" var="datetimePattern" scope="page" />
    <fmt:message key="format.integer" var="integerPattern" scope="page" />
    <fmt:message key="format.double" var="doublePattern" scope="page" />

    <div class="tabbable">
        <ul class="nav nav-tabs">
            <li class="active"><a href="#tabSsrv" data-toggle="tab">${enti.nombre}</a></li>

            <c:forEach items="${entiHijasList}" var="enti">
                <li><a href="#tabEnti_${enti.id}" data-toggle="tab">${enti.nombre}</a></li>
            </c:forEach>
        </ul>
        <div class="tab-content">
            <div class="tab-pane active" id="tabSsrv">
                <div class="btn-toolbar" role="toolbar">
                    <div class="btn-group">
                        <a class="btn btn-default" href="ssrv-modificar.action?item.id=${item.id}"><i
                            class="glyphicon glyphicon-edit"></i> <fmt:message key="boton.modificar" /></a>
                        <a class="btn btn-default" href="ssrv-duplicar.action?item.id=${item.id}"><i
                            class="glyphicon glyphicon-tags"></i> <fmt:message key="boton.duplicar" /></a>
                    </div>
                    <div class="btn-group">
                        <c:forEach items="${enti.enacList}" var="enac">
                            <a class="btn btn-default"
                                href="${enac.path}-popup.action?item.id=${item.id}&item.srvc.id=${item.srvc.id}"
                                role="button" data-toggle="modal" data-target="#${enac.path}-div">${enac.etiqueta}</a>
                        </c:forEach>
                    </div>
                </div>

                <c:forEach items="${enti.enacList}" var="enac">
                    <div class="modal" id="${enac.path}-div" tabindex="-1" role="dialog"
                        aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content"></div>
                        </div>
                    </div>
                </c:forEach>

                <fieldset>
                    <div class="row">
                        <div class="col-md-2 form-group">
                            <label><fmt:message key="ssrv.srvc" /></label> <input type="text"
                                value="${item.srvc.etiqueta}" class="form-control input-sm"
                                disabled="disabled" />
                        </div>

                        <div class="col-md-1 form-group">
                            <label><fmt:message key="ssrv.numero" /></label> <input type="text"
                                value="${item.numero}" class="form-control input-sm"
                                disabled="disabled" />
                        </div>

                        <c:if test="${not empty enti.tpdtEstado}">
                            <div class="col-md-2 form-group">
                                <label><fmt:message key="ssrv.estado" /></label> <input type="text"
                                    value="${item.estado}" class="form-control input-sm"
                                    disabled="disabled" />
                            </div>
                        </c:if>

                        <c:if test="${enti.temporal}">
                            <div class="col-md-2 form-group">
                                <fmt:formatDate value="${item.finicio}" pattern="${datetimePattern}"
                                    var="fechaString" />
                                <label><fmt:message key="ssrv.finicio" /></label> <input
                                    type="text" value="${fechaString}" class="form-control input-sm"
                                    disabled="disabled" />
                            </div>
                            <div class="col-md-2 form-group">
                                <fmt:formatDate value="${item.ffin}" pattern="${datetimePattern}"
                                    var="fechaString" />
                                <label><fmt:message key="ssrv.ffin" /></label> <input type="text"
                                    value="${fechaString}" class="form-control input-sm"
                                    disabled="disabled" />
                            </div>
                        </c:if>
                    </div>

                    <jsp:include page="/WEB-INF/content/include/item/item-detalle.jsp" flush="true">
                        <jsp:param value="true" name="btnOn" />
                    </jsp:include>
                </fieldset>
            </div>

            <c:forEach items="${entiHijasList}" var="enti">
                <c:set var="ssrvList" value="${itemHijosMap[enti.id]}" />

                <div class="tab-pane" id="tabEnti_${enti.id}">
                    <div class="btn-toolbar" role="toolbar">
                        <div class="btn-group">
                            <a class="btn btn-default"
                                href="ssrv-alta.action?ssrv.entiId=${enti.id}"><i
                                class="glyphicon glyphicon-file"></i> <fmt:message key="boton.alta" /></a>
                        </div>
                    </div>

                    <c:url value="ssrv-listado.action" var="urlListado">
                        <c:forEach items="${ssrvList.criterio.searchLinks}" var="mapEntry">
                            <c:param name="ssrvCriterio.${mapEntry.key}" value="${mapEntry.value}" />
                        </c:forEach>
                    </c:url>

                    <c:url value="${urlListado}" var="urlListadoPrev">
                        <c:param name="page" value="${ssrvList.page - 1}" />
                    </c:url>
                    <c:url value="${urlListado}" var="urlListadoNext">
                        <c:param name="page" value="${ssrvList.page + 1}" />
                    </c:url>

                    <ul class="pagination">
                        <c:if test="${ssrvList.hasPrevious}">
                            <li><a class="btn" href="${urlListadoPrev}"><i
                                    class="glyphicon glyphicon-chevron-left"></i></a></li>
                        </c:if>
                        <c:if test="${!ssrvList.hasPrevious}">
                            <li><span class="btn"><i
                                    class="glyphicon glyphicon-chevron-left"></i></span></li>
                        </c:if>
                        <c:if test="${ssrvList.hasNext}">
                            <li><a class="btn" href="${urlListadoNext}"><i
                                    class="glyphicon glyphicon-chevron-right"></i></a></li>
                        </c:if>
                        <c:if test="${!ssrvList.hasNext}">
                            <li><span class="btn"> <i
                                    class="glyphicon glyphicon-chevron-right"></i></span></li>
                        </c:if>
                        <c:if test="${ssrvList.pageCount > 0}">
                            <li><span class="btn"> <fmt:message key="paginacion.leyenda">
                                        <fmt:param value="${ssrvList.page}" />
                                        <fmt:param value="${ssrvList.pageCount}" />
                                        <fmt:param value="${ssrvList.count}" />
                                    </fmt:message></span></li>
                        </c:if>
                    </ul>

                    <table class="table table-condensed table-hover table-nonfluid">
                        <thead>
                            <tr>
                                <th class="buttonLinks" />
                                <th><fmt:message key="ssrv.numero" /></th>

                                <c:if test="${not empty enti.tpdtEstado}">
                                    <th class="date"><fmt:message key="ssrv.estado" /></th>
                                </c:if>

                                <c:if test="${enti.temporal}">
                                    <th class="date"><fmt:message key="ssrv.finicio" /></th>
                                    <th class="date"><fmt:message key="ssrv.ffin" /></th>
                                </c:if>

                                <c:forEach items="${enti.entdList}" var="tpdtId">
                                    <c:set var="entd" value="${enti.entdMap[tpdtId]}" />

                                    <c:if test="${entd.gridable}">
                                        <th><c:choose>
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
                            <c:forEach items="${ssrvList.list}" var="item">
                                <tr>
                                    <td nowrap="nowrap"><a
                                        href="ssrv-modificar.action?item.id=${item.id}"><i
                                            class="glyphicon glyphicon-edit"></i></a><a
                                        href="ssrv-borrar.action?item.id=${item.id}"><i
                                            class="glyphicon glyphicon-remove"></i></a></td>
                                    <td><a href="ssrv-detalle.action?item.id=${item.id}"><b>${item.numero}</b></a></td>

                                    <c:if test="${not empty enti.tpdtEstado}">
                                        <td>${item.estado}</td>
                                    </c:if>

                                    <c:if test="${enti.temporal}">
                                        <td><fmt:formatDate pattern="${datetimePattern}"
                                                value="${item.finicio}" /></td>
                                        <td><fmt:formatDate pattern="${datetimePattern}"
                                                value="${item.ffin}" /></td>
                                    </c:if>

                                    <c:forEach items="${enti.entdList}" var="tpdtId">
                                        <c:set var="entd" value="${enti.entdMap[tpdtId]}" />

                                        <c:if test="${entd.gridable}">
                                            <c:set var="itdt" value="${item.itdtMap[entd.tpdt.id]}" />

                                            <%--
 --%>
                                            <c:if test="${empty itdt or not itdt.filled}">
                                                <td />
                                            </c:if>

                                            <c:if test="${!empty itdt and itdt.filled}">
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
                                                        test="${entd.tpdt.tipoElemento eq 'CR' or entd.tpdt.tipoElemento eq 'TX'}">
                                                        <td>${itdt.cadena}</td>
                                                    </c:when>
                                                    <c:when test="${entd.tpdt.tipoElemento eq 'PR'}">
                                                        <td title="${itdt.prmt.etiqueta}">${itdt.prmt.parametro}</td>
                                                    </c:when>
                                                    <c:when test="${entd.tpdt.tipoElemento == 'FE'}">
                                                        <td><fmt:formatDate
                                                                pattern="${datePattern}"
                                                                value="${itdt.fecha}" /></td>
                                                    </c:when>
                                                    <c:when test="${entd.tpdt.tipoElemento == 'FH'}">
                                                        <td><fmt:formatDate
                                                                pattern="${datetimePattern}"
                                                                value="${itdt.fecha}" /></td>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <td>Tipo Desconocido
                                                            ${entd.tpdt.tipoElemento}</td>
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
            </c:forEach>
        </div>
    </div>
    <%--
 --%>
</body>
</html>
