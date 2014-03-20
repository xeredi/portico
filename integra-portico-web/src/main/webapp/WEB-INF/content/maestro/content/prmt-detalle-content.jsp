<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<fmt:message key="format.datetime" var="datetimePattern" scope="page" />
<fmt:message key="format.date" var="datePattern" scope="page" />
<fmt:message key="format.integer" var="integerPattern" scope="page" />
<fmt:message key="format.double" var="doublePattern" scope="page" />

<c:if test="${not empty entiHijasList}">
    <div class="tabbable">
        <ul class="nav nav-tabs">
            <li class="active"><a href="#tabEnti_${enti.id}" data-toggle="tab">${enti.nombre}</a></li>
            <c:if test="${not empty entiHijasList}">
                <c:forEach items="${entiHijasList}" var="enti">
                    <li><a href="#tabEnti_${enti.id}" data-toggle="tab">${enti.nombre}</a></li>
                </c:forEach>
            </c:if>
        </ul>
        <div class="tab-content">
            <div class="tab-pane active" id="tabEnti_${enti.id}">
</c:if>

<c:if test="${param.btnOn eq 'true'}">
    <div class="btn-toolbar" role="toolbar">
        <div class="btn-group">
            <c:if test="${enti.cmdEdicion}">
                <a class="btn btn-default"
                    href="${pageContext.request.contextPath}/maestro/prmt-modificar-popup.action?item.id=${item.id}"
                    role="button" data-toggle="modal" data-target="#prmt-modificar-div"><i
                    class="glyphicon glyphicon-edit"></i> <fmt:message key="boton.modificar" /></a>
                <div class="modal" id="prmt-modificar-div" tabindex="-1" role="dialog"
                    aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content"></div>
                    </div>
                </div>
            </c:if>
            <c:if test="${enti.cmdDuplicado}">
                <a class="btn btn-default"
                    href="${pageContext.request.contextPath}/maestro/prmt-duplicar-popup.action?item.id=${item.id}"
                    role="button" data-toggle="modal" data-target="#prmt-duplicar-div"><i
                    class="glyphicon glyphicon-tags"></i> <fmt:message key="boton.duplicar" /></a>
                <div class="modal" id="prmt-duplicar-div" tabindex="-1" role="dialog"
                    aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content"></div>
                    </div>
                </div>
            </c:if>

            <a class="btn btn-default"
                href="${pageContext.request.contextPath}/maestro/prmt-imprimir.action?item.id=${item.id}"><i
                class="glyphicon glyphicon-print"></i> <fmt:message key="boton.imprimir" /></a>
        </div>
    </div>
</c:if>

<fieldset>
    <div class="row">
        <div class="col-md-2 form-group">
            <label><fmt:message key="prmt.parametro" /></label> <input type="text"
                value="${item.parametro}" class="form-control input-sm" disabled="disabled" />
        </div>

        <c:if test="${enti.tempExp}">
            <div class="col-md-2 form-group">
                <label><fmt:message key="prmt.finicio" /></label>
                <fmt:formatDate value="${item.prvr.finicio}" pattern="${datetimePattern}"
                    var="fechaString" />
                <input type="text" value="${fechaString}" class="form-control input-sm"
                    disabled="disabled" />
            </div>

            <div class="col-md-2 form-group">
                <label><fmt:message key="prmt.ffin" /></label>
                <fmt:formatDate value="${item.prvr.ffin}" pattern="${datetimePattern}"
                    var="fechaString" />
                <input type="text" value="${fechaString}" class="form-control input-sm"
                    disabled="disabled" />
            </div>
        </c:if>
    </div>

    <c:if test="${enti.i18n}">
        <c:forEach items="${availableLanguages}" var="availableLanguage">
            <div class="row">
                <div class="col-md-10 form-group">
                    <label>Texto ${availableLanguage}</label> <input type="text"
                        value="${p18nMap[availableLanguage].texto}" class="form-control input-sm"
                        disabled="disabled" />
                </div>
            </div>
        </c:forEach>
    </c:if>

    <jsp:include page="/WEB-INF/content/include/item/item-detalle.jsp" flush="true">
        <jsp:param value="${param.btnOn}" name="btnOn" />
    </jsp:include>
</fieldset>

<c:if test="${not empty entiHijasList}">
    </div>
    <c:forEach items="${entiHijasList}" var="enti">
        <c:set var="itemList" value="${itemHijosMap[enti.id]}" />
        <div class="tab-pane" id="tabEnti_${enti.id}">
            <c:if test="${param.btnOn eq 'true'}">
                <div class="btn-toolbar" role="toolbar">
                    <div class="btn-group">
                        <a class="btn btn-default"
                            href="sprm-alta-popup.action?item.entiId=${enti.id}&item.prmtId=${item.id}"
                            role="button" data-toggle="modal"
                            data-target="#sprm-alta-${enti.id}-div"><i
                            class="glyphicon glyphicon-file"></i> <fmt:message key="boton.alta" /></a>
                    </div>
                </div>

                <div class="modal" id="sprm-alta-${enti.id}-div" tabindex="-1" role="dialog"
                    aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content"></div>
                    </div>
                </div>
            </c:if>

            <div id="enti-grid-div_${enti.id}">
                <c:if test="${not empty itemList}">
                    <c:url
                        value="sprm-listado-grid.action?itemCriterio.prmt.id=${item.id}&itemCriterio.entiId=${enti.id}"
                        var="urlListado">
                        <c:forEach items="${itemList.criterio.searchLinks}" var="mapEntry">
                            <c:param name="itemCriterio.${mapEntry.key}" value="${mapEntry.value}" />
                        </c:forEach>
                    </c:url>

                    <c:url value="${urlListado}" var="urlListadoPrev">
                        <c:param name="page" value="${itemList.page - 1}" />
                    </c:url>
                    <c:url value="${urlListado}" var="urlListadoNext">
                        <c:param name="page" value="${itemList.page + 1}" />
                    </c:url>

                    <ul class="pagination">
                        <c:if test="${itemList.hasPrevious}">
                            <li><a class="btn" href="${urlListadoPrev}"
                                data-target="#enti-grid-div_${enti.id}"><i
                                    class="glyphicon glyphicon-chevron-left"></i></a></li>
                        </c:if>
                        <c:if test="${!itemList.hasPrevious}">
                            <li><span class="btn"><i
                                    class="glyphicon glyphicon-chevron-left"></i></span></li>
                        </c:if>
                        <c:if test="${itemList.hasNext}">
                            <li><a class="btn" href="${urlListadoNext}"
                                data-target="#enti-grid-div_${enti.id}"><i
                                    class="glyphicon glyphicon-chevron-right"></i></a></li>
                        </c:if>
                        <c:if test="${!itemList.hasNext}">
                            <li><span class="btn"> <i
                                    class="glyphicon glyphicon-chevron-right"></i></span></li>
                        </c:if>
                        <c:if test="${itemList.pageCount > 0}">
                            <li><span class="btn"> <fmt:message key="paginacion.leyenda">
                                        <fmt:param value="${itemList.page}" />
                                        <fmt:param value="${itemList.pageCount}" />
                                        <fmt:param value="${itemList.count}" />
                                    </fmt:message></span></li>
                        </c:if>
                    </ul>
                </c:if>
                <table class="table table-condensed table-hover table-nonfluid">
                    <thead>
                        <tr>
                            <th class="buttonLinks" />
                            <th>${enti.tpprAsociado.nombre}</th>

                            <c:if test="${enti.tempExp}">
                                <th class="date"><fmt:message key="sprm.finicio" /></th>
                                <th class="date"><fmt:message key="sprm.ffin" /></th>
                            </c:if>

                            <c:if test="${not empty enti.entdList}">
                                <c:forEach items="${enti.entdList}" var="tpdtId">
                                    <c:set var="entd" value="${enti.entdMap[tpdtId]}" />

                                    <c:if test="${entd.gridable}">
                                        <th><c:choose>
                                                <c:when
                                                    test="${entd.tpdt.tipoElemento eq 'ND' || entd.tpdt.tipoElemento eq 'NE'}">
                                                    <span class="pull-right">${entd.etiqueta}</span>
                                                </c:when>
                                                <c:otherwise>${entd.etiqueta}</c:otherwise>
                                            </c:choose></th>
                                    </c:if>
                                </c:forEach>
                            </c:if>
                        </tr>
                    </thead>

                    <tbody>
                        <c:if test="${not empty itemList}">
                            <c:forEach items="${itemList.list}" var="item">
                                <tr>
                                    <td><c:if test="${param.btnOn eq 'true'}">
                                            <a href="sprm-modificar.action?item.id=${item.id}"><i
                                                class="glyphicon glyphicon-edit"></i></a>
                                            <a href="sprm-borrar.action?item.id=${item.id}"><i
                                                class="glyphicon glyphicon-remove"></i></a>
                                        </c:if></td>
                                    <td title="${item.prmtAsociado.etiqueta}"><a
                                        href="sprm-detalle.action?item.id=${item.id}"><b>${item.prmtAsociado.parametro}</b></a></td>

                                    <c:if test="${enti.tempExp}">
                                        <td><fmt:formatDate pattern="${datetimePattern}"
                                                value="${item.spvr.finicio}" /></td>
                                        <td><fmt:formatDate pattern="${datetimePattern}"
                                                value="${item.spvr.ffin}" /></td>
                                    </c:if>

                                    <c:if
                                        test="${not empty enti.entdList and not empty item.itdtMap}">
                                        <c:forEach items="${enti.entdList}" var="tpdtId">
                                            <c:set var="entd" value="${enti.entdMap[tpdtId]}" />
                                            <c:if test="${not empty entd and entd.gridable}">
                                                <c:set var="itdt" value="${item.itdtMap[tpdtId]}" />
                                                <c:choose>
                                                    <c:when test="${itdt != null && itdt.filled}">
                                                        <c:choose>
                                                            <c:when
                                                                test="${entd.tpdt.tipoElemento eq 'BO'}">
                                                                <td><c:if
                                                                        test="${itdt.booleano}">
                                                                        <i
                                                                            class="glyphicon glyphicon-ok"></i>
                                                                    </c:if></td>
                                                            </c:when>
                                                            <c:when
                                                                test="${entd.tpdt.tipoElemento eq 'ND'}">
                                                                <td><span class="pull-right"><fmt:formatNumber
                                                                            pattern="${doublePattern}"
                                                                            value="${itdt.cantidadDecimal}" /></span></td>
                                                            </c:when>
                                                            <c:when
                                                                test="${entd.tpdt.tipoElemento eq 'NE'}">
                                                                <td><span class="pull-right"><fmt:formatNumber
                                                                            pattern="${integerPattern}"
                                                                            value="${itdt.cantidadEntera}" /></span></td>
                                                            </c:when>
                                                            <c:when
                                                                test="${entd.tpdt.tipoElemento eq 'CR' || entd.tpdt.tipoElemento eq 'TX'}">
                                                                <td>${itdt.cadena}</td>
                                                            </c:when>
                                                            <c:when
                                                                test="${entd.tpdt.tipoElemento eq 'PR'}">
                                                                <td title="${itdt.prmt.etiqueta}">${itdt.prmt.parametro}</td>
                                                            </c:when>
                                                            <c:when
                                                                test="${entd.tpdt.tipoElemento eq 'FE'}">
                                                                <td><fmt:formatDate
                                                                        pattern="${datePattern}"
                                                                        value="${itdt.fecha}" /></td>
                                                            </c:when>
                                                            <c:when
                                                                test="${entd.tpdt.tipoElemento eq 'FH'}">
                                                                <td><fmt:formatDate
                                                                        pattern="${datetimePattern}"
                                                                        value="${itdt.fecha}" /></td>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <td>Tipo Desconocido
                                                                    ${entd.tpdt.tipoElemento}</td>
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <td />
                                                    </c:otherwise>
                                                </c:choose>
                                            </c:if>
                                        </c:forEach>
                                    </c:if>
                                </tr>
                            </c:forEach>
                        </c:if>
                    </tbody>
                </table>
            </div>
        </div>
    </c:forEach>
    </div>
    </div>
</c:if>
