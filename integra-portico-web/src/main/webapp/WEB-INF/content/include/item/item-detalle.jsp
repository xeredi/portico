<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<fmt:message key="format.date" var="datePattern" scope="page" />
<fmt:message key="format.datetime" var="datetimePattern" scope="page" />
<fmt:message key="format.integer" var="integerPattern" scope="page" />
<fmt:message key="format.double" var="doublePattern" scope="page" />

<c:set var="filaActual" value="1" />
<div class="row">
    <c:forEach items="${enti.entdList}" var="tpdtId">
        <c:set var="entd" value="${enti.entdMap[tpdtId]}" />
        <c:set var="valor" value="${item.itdtMap[entd.tpdt.id]}" />
        <c:if test="${entd.grupo == 1}">

            <%--
        <c:if test="${filaActual ne entd.fila}">
            <c:set var="filaActual" value="${entd.fila}" />
</div>
<div class="row">
    </c:if>
 --%>

            <div class="col-md-${entd.span} col-lg-${entd.spanLg} form-group">
                <label>${entd.etiqueta}</label>
                <c:if test="${not valor.filled}">
                    <input type="text" value="" class="form-control input-sm" disabled='disabled' />
                </c:if>
                <c:if test="${valor.filled}">
                    <c:choose>
                        <c:when test="${entd.tpdt.tipoElemento eq 'BO'}">
                            <fmt:message key="boolean.${valor.booleano}" var="booleanString" />
                            <input type="text" value="${booleanString}"
                                class="form-control input-sm" disabled='disabled' />
                        </c:when>
                        <c:when test="${entd.tpdt.tipoElemento eq 'ND'}">
                            <fmt:formatNumber pattern="${doublePattern}"
                                value="${valor.cantidadDecimal}" var="doubleString" />
                            <input type="text" value="${doubleString}"
                                class="form-control input-sm number" disabled='disabled' />
                        </c:when>
                        <c:when test="${entd.tpdt.tipoElemento eq 'NE'}">
                            <fmt:formatNumber pattern="${integerPattern}"
                                value="${valor.cantidadEntera}" var="integerString" />
                            <input type="text" value="${integerString}"
                                class="form-control input-sm number" disabled='disabled' />
                        </c:when>
                        <c:when test="${entd.tpdt.tipoElemento eq 'FE'}">
                            <fmt:formatDate value="${valor.fecha}" pattern="${datePattern}"
                                var="dateString" />
                            <input type="text" value="${dateString}" class="form-control input-sm"
                                disabled='disabled' />
                        </c:when>
                        <c:when test="${entd.tpdt.tipoElemento eq 'FH'}">
                            <fmt:formatDate value="${valor.fecha}" pattern="${datetimePattern}"
                                var="datetimeString" />
                            <input type="text" value="${datetimeString}"
                                class="form-control input-sm" disabled='disabled' />
                        </c:when>
                        <c:when test="${entd.tpdt.tipoElemento eq 'TX' and entd.tpdt.tpht eq 'T'}">
                            <input type="text" value="${valor.cadena}" class="form-control input-sm"
                                disabled='disabled' />
                        </c:when>
                        <c:when test="${entd.tpdt.tipoElemento eq 'TX' and entd.tpdt.tpht eq 'TA'}">
                            <textarea rows="4" class="form-control input-sm" disabled='disabled'>${valor.cadena}</textarea>
                        </c:when>
                        <c:when test="${entd.tpdt.tipoElemento eq 'CR'}">
                            <input type="text" value="${valor.cadena}" class="form-control input-sm"
                                disabled='disabled' />
                        </c:when>
                        <c:when test="${entd.tpdt.tipoElemento eq 'PR'}">
                            <c:if test="${param.btnOn eq 'true'}">
                                <div class='input-group'>
                                    <input type='text' class="form-control input-sm"
                                        value="${valor.prmt.etiqueta}" disabled='disabled' /> <span
                                        class="input-group-addon"><a
                                        href="${pageContext.request.contextPath}/maestro/prmt-detalle-popup.action?item.id=${valor.prmt.id}"
                                        data-target="#prmt-detalle-div_${entd.tpdt.id}"
                                        role="button" data-toggle="modal"><span
                                            class="glyphicon glyphicon-share-alt"></span></a></span>

                                    <div class="modal" id="prmt-detalle-div_${entd.tpdt.id}"
                                        tabindex="-1" role="dialog" aria-hidden="true">
                                        <div class="modal-dialog">
                                            <div class="modal-content"></div>
                                        </div>
                                    </div>
                                </div>
                            </c:if>
                            <c:if test="${param.btnOn eq 'false'}">
                                <input type='text' class="form-control input-sm"
                                    value="${valor.prmt.etiqueta}" disabled='disabled' />
                            </c:if>
                        </c:when>
                        <c:when test="${entd.tpdt.tipoElemento eq 'SR'}">
                            <c:if test="${param.btnOn eq 'true'}">
                                <div class='input-group'>
                                    <input type='text' class="form-control input-sm"
                                        value="${valor.srvc.etiqueta}" disabled='disabled' /> <span
                                        class="input-group-addon"><a
                                        href="${pageContext.request.contextPath}/servicio/srvc-detalle-popup.action?item.id=${valor.srvc.id}"
                                        data-target="#srvc-detalle-div_${entd.tpdt.id}"
                                        role="button" data-toggle="modal"><span
                                            class="glyphicon glyphicon-share-alt"></span></a></span>

                                    <div class="modal" id="srvc-detalle-div_${entd.tpdt.id}"
                                        tabindex="-1" role="dialog" aria-hidden="true">
                                        <div class="modal-dialog">
                                            <div class="modal-content"></div>
                                        </div>
                                    </div>
                                </div>
                            </c:if>
                            <c:if test="${param.btnOn eq 'false'}">
                                <input type='text' class="form-control input-sm"
                                    value="${valor.srvc.etiqueta}" disabled='disabled' />
                            </c:if>
                        </c:when>
                        <c:otherwise>
                            <span>ERROR!!!. Dato de tipo desconocido: ${entd.tpdt}</span>
                        </c:otherwise>
                    </c:choose>
                </c:if>
            </div>
        </c:if>
    </c:forEach>
</div>

<c:if test="${not empty enti.engdList}">
    <div class="tabbable">
        <ul class="nav nav-tabs">
            <c:forEach items="${enti.engdList}" var="engdId" varStatus="status">
                <c:set var="engd" value="${enti.engdMap[engdId]}" />
                <li <c:if test="${status.count == 1}">class="active"</c:if>><a
                    href="#engd_${engdId}" data-toggle="tab">${engd.etiqueta}</a></li>
            </c:forEach>
        </ul>

        <div class="tab-content">
            <c:forEach items="${enti.engdList}" var="engdId" varStatus="status">
                <c:set var="engd" value="${enti.engdMap[engdId]}" />
                <c:set var="entdIds" value="${enti.engdEntdMap[engdId]}" />
                <div id="engd_${engdId}"
                    class="${status.count == 1 ? 'tab-pane active' : 'tab-pane'}">
                    <c:forEach items="${entdIds}" var="tpdtId">
                        <c:set var="entd" value="${enti.entdMap[tpdtId]}" />
                        <c:set var="valor" value="${item.itdtMap[entd.tpdt.id]}" />

                        <div class="col-md-${entd.span} col-lg-${entd.spanLg} form-group">
                            <label>${entd.etiqueta}</label>
                            <c:if test="${not valor.filled}">
                                <input type="text" value="" class="form-control input-sm"
                                    disabled='disabled' />
                            </c:if>
                            <c:if test="${valor.filled}">
                                <c:choose>
                                    <c:when test="${entd.tpdt.tipoElemento eq 'BO'}">
                                        <fmt:message key="boolean.${valor.booleano}"
                                            var="booleanString" />
                                        <input type="text" value="${booleanString}"
                                            class="form-control input-sm" disabled='disabled' />
                                    </c:when>
                                    <c:when test="${entd.tpdt.tipoElemento eq 'ND'}">
                                        <fmt:formatNumber pattern="${doublePattern}"
                                            value="${valor.cantidadDecimal}" var="doubleString" />
                                        <input type="text" value="${doubleString}"
                                            class="form-control input-sm number" disabled='disabled' />
                                    </c:when>
                                    <c:when test="${entd.tpdt.tipoElemento eq 'NE'}">
                                        <fmt:formatNumber pattern="${integerPattern}"
                                            value="${valor.cantidadEntera}" var="integerString" />
                                        <input type="text" value="${integerString}"
                                            class="form-control input-sm number" disabled='disabled' />
                                    </c:when>
                                    <c:when test="${entd.tpdt.tipoElemento eq 'FE'}">
                                        <fmt:formatDate value="${valor.fecha}"
                                            pattern="${datePattern}" var="dateString" />
                                        <input type="text" value="${dateString}"
                                            class="form-control input-sm" disabled='disabled' />
                                    </c:when>
                                    <c:when test="${entd.tpdt.tipoElemento eq 'FH'}">
                                        <fmt:formatDate value="${valor.fecha}"
                                            pattern="${datetimePattern}" var="datetimeString" />
                                        <input type="text" value="${datetimeString}"
                                            class="form-control input-sm" disabled='disabled' />
                                    </c:when>
                                    <c:when
                                        test="${entd.tpdt.tipoElemento eq 'TX' and entd.tpdt.tpht eq 'T'}">
                                        <input type="text" value="${valor.cadena}"
                                            class="form-control input-sm" disabled='disabled' />
                                    </c:when>
                                    <c:when
                                        test="${entd.tpdt.tipoElemento eq 'TX' and entd.tpdt.tpht eq 'TA'}">
                                        <textarea rows="4" class="form-control input-sm"
                                            disabled='disabled'>${valor.cadena}</textarea>
                                    </c:when>
                                    <c:when test="${entd.tpdt.tipoElemento eq 'CR'}">
                                        <input type="text" value="${valor.cadena}"
                                            class="form-control input-sm" disabled='disabled' />
                                    </c:when>
                                    <c:when test="${entd.tpdt.tipoElemento eq 'PR'}">
                                        <c:if test="${param.btnOn eq 'true'}">
                                            <div class='input-group'>
                                                <input type='text' class="form-control input-sm"
                                                    value="${valor.prmt.etiqueta}"
                                                    disabled='disabled' /> <span
                                                    class="input-group-addon"><a
                                                    href="${pageContext.request.contextPath}/maestro/prmt-detalle-popup.action?item.id=${valor.prmt.id}"
                                                    data-target="#prmt-detalle-div_${entd.tpdt.id}"
                                                    role="button" data-toggle="modal"><span
                                                        class="glyphicon glyphicon-share-alt"></span></a></span>

                                                <div class="modal"
                                                    id="prmt-detalle-div_${entd.tpdt.id}"
                                                    tabindex="-1" role="dialog" aria-hidden="true">
                                                    <div class="modal-dialog">
                                                        <div class="modal-content"></div>
                                                    </div>
                                                </div>
                                            </div>
                                        </c:if>
                                        <c:if test="${param.btnOn eq 'false'}">
                                            <input type='text' class="form-control input-sm"
                                                value="${valor.prmt.etiqueta}" disabled='disabled' />
                                        </c:if>
                                    </c:when>
                                    <c:when test="${entd.tpdt.tipoElemento eq 'SR'}">
                                        <c:if test="${param.btnOn eq 'true'}">
                                            <div class='input-group'>
                                                <input type='text' class="form-control input-sm"
                                                    value="${valor.srvc.etiqueta}"
                                                    disabled='disabled' /> <span
                                                    class="input-group-addon"><a
                                                    href="${pageContext.request.contextPath}/servicio/srvc-detalle-popup.action?item.id=${valor.srvc.id}"
                                                    data-target="#srvc-detalle-div_${entd.tpdt.id}"
                                                    role="button" data-toggle="modal"><span
                                                        class="glyphicon glyphicon-share-alt"></span></a></span>

                                                <div class="modal"
                                                    id="srvc-detalle-div_${entd.tpdt.id}"
                                                    tabindex="-1" role="dialog" aria-hidden="true">
                                                    <div class="modal-dialog">
                                                        <div class="modal-content"></div>
                                                    </div>
                                                </div>
                                            </div>
                                        </c:if>
                                        <c:if test="${param.btnOn eq 'false'}">
                                            <input type='text' class="form-control input-sm"
                                                value="${valor.srvc.etiqueta}" disabled='disabled' />
                                        </c:if>
                                    </c:when>
                                    <c:otherwise>
                                        <span>ERROR!!!. Dato de tipo desconocido:
                                            ${entd.tpdt}</span>
                                    </c:otherwise>
                                </c:choose>
                            </c:if>
                        </div>
                    </c:forEach>
                </div>
            </c:forEach>
        </div>
    </div>
</c:if>
