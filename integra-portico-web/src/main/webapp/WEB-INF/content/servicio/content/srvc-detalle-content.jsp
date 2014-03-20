<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<fmt:message key="format.date" var="datePattern" scope="page" />
<fmt:message key="format.datetime" var="datetimePattern" scope="page" />
<fmt:message key="format.integer" var="integerPattern" scope="page" />
<fmt:message key="format.double" var="doublePattern" scope="page" />

<c:if test="${not empty entiHijasList}">
    <div class="tabbable">
        <ul class="nav nav-tabs">
            <li class="active"><a href="#tabEnti_${enti.id}" data-toggle="tab">${enti.nombre}</a></li>

            <c:forEach items="${entiHijasList}" var="enti">
                <li><a href="#tabEnti_${enti.id}" data-toggle="tab">${enti.nombre}</a></li>
            </c:forEach>
        </ul>
        <div class="tab-content">
            <div class="tab-pane active" id="tabEnti_${enti.id}">
</c:if>

<c:if test="${param.btnOn eq 'true'}">
    <div class="btn-toolbar" role="toolbar">
        <div class="btn-group">
            <a class="btn btn-default" href="srvc-modificar-popup.action?item.id=${item.id}"
                role="button" data-toggle="modal" data-target="#srvc-modificar-div"><i
                class="glyphicon glyphicon-edit"></i> <fmt:message key="boton.modificar" /></a> <a
                class="btn btn-default" href="srvc-duplicar-popup.action?item.id=${item.id}"
                role="button" data-toggle="modal" data-target="#srvc-duplicar-div"><i
                class="glyphicon glyphicon-tags"></i> <fmt:message key="boton.duplicar" /></a>
        </div>
        <div class="btn-group">
            <c:forEach items="${enti.enacList}" var="enac">
                <a class="btn btn-default" href="${enac.path}-popup.action?item.id=${item.id}"
                    role="button" data-toggle="modal" data-target="#${enac.path}-div">${enac.etiqueta}</a>
            </c:forEach>
        </div>
    </div>

    <div class="modal" id="srvc-modificar-div" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content"></div>
        </div>
    </div>
    <div class="modal" id="srvc-duplicar-div" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content"></div>
        </div>
    </div>

    <c:forEach items="${enti.enacList}" var="enac">
        <div class="modal" id="${enac.path}-div" tabindex="-1" role="dialog" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content"></div>
            </div>
        </div>
    </c:forEach>
</c:if>

<fieldset>
    <div class="row">
        <div class="col-md-3 form-group">
            <label><fmt:message key="srvc.subp.id" /></label> <input type="text"
                value="${item.subp.etiqueta}" class="form-control input-sm" disabled="disabled" />
        </div>

        <div class="col-md-1 form-group">
            <label><fmt:message key="srvc.anno" /></label> <input type="text" value="${item.anno}"
                class="form-control input-sm" disabled="disabled" />
        </div>
        <div class="col-md-1 form-group">
            <label><fmt:message key="srvc.numero" /></label> <input type="text"
                value="${item.numero}" class="form-control input-sm" disabled="disabled" />
        </div>

        <c:if test="${not empty enti.tpdtEstado}">
            <div class="col-md-2 form-group">
                <label><fmt:message key="srvc.estado" /></label> <input type="text"
                    value="${item.estado}" class="form-control input-sm" disabled="disabled" />
            </div>
        </c:if>

        <c:if test="${enti.temporal}">
            <div class="col-md-2 form-group">
                <fmt:formatDate value="${item.finicio}" pattern="${datetimePattern}"
                    var="fechaString" />
                <label><fmt:message key="srvc.finicio" /></label> <input type="text"
                    value="${fechaString}" class="form-control input-sm" disabled="disabled" />
            </div>
            <div class="col-md-2 form-group">
                <fmt:formatDate value="${item.ffin}" pattern="${datetimePattern}" var="fechaString" />
                <label><fmt:message key="srvc.ffin" /></label> <input type="text"
                    value="${fechaString}" class="form-control input-sm" disabled="disabled" />
            </div>
        </c:if>

        <c:if test="${not enti.temporal}">
            <div class="col-md-2 form-group">
                <fmt:formatDate value="${item.freferencia}" pattern="${datetimePattern}"
                    var="fechaString" />
                <label><fmt:message key="srvc.freferencia" /></label> <input type="text"
                    value="${fechaString}" class="form-control input-sm" disabled="disabled" />
            </div>
        </c:if>
    </div>

    <jsp:include page="/WEB-INF/content/include/item/item-detalle.jsp" flush="true">
        <jsp:param value="${param.btnOn}" name="btnOn" />
    </jsp:include>
</fieldset>

<c:if test="${not empty entiHijasList}">
    </div>

    <c:forEach items="${entiHijasList}" var="enti">
        <c:set var="ssrvList" value="${itemHijosMap[enti.id]}" />


        <div class="tab-pane" id="tabEnti_${enti.id}">
            <c:if test="${param.btnOn eq 'true'}">
                <div class="btn-toolbar" role="toolbar">
                    <div class="btn-group">
                        <a class="btn btn-default"
                            href="ssrv-alta.action?item.entiId=${enti.id}&item.srvc.id=${item.id}"><i
                            class="glyphicon glyphicon-file"></i> <fmt:message key="boton.alta" /></a>
                    </div>
                </div>
            </c:if>

            <c:url
                value="ssrv-listado-grid.action?itemCriterio.srvc.id=${item.id}&itemCriterio.entiId=${enti.id}"
                var="urlListado">
                <c:forEach items="${ssrvList.criterio.searchLinks}" var="mapEntry">
                    <c:param name="itemCriterio.${mapEntry.key}" value="${mapEntry.value}" />
                </c:forEach>
            </c:url>

            <div id="enti-grid-div_${enti.id}">
                <c:url value="${urlListado}" var="urlListadoPrev">
                    <c:param name="page" value="${ssrvList.page - 1}" />
                </c:url>
                <c:url value="${urlListado}" var="urlListadoNext">
                    <c:param name="page" value="${ssrvList.page + 1}" />
                </c:url>

                <ul class="pagination">
                    <c:if test="${ssrvList.hasPrevious}">
                        <li><a class="btn" href="${urlListadoPrev}"
                            data-target="#enti-grid-div_${enti.id}"><i
                                class="glyphicon glyphicon-chevron-left"></i></a></li>
                    </c:if>
                    <c:if test="${!ssrvList.hasPrevious}">
                        <li><span class="btn"><i
                                class="glyphicon glyphicon-chevron-left"></i></span></li>
                    </c:if>
                    <c:if test="${ssrvList.hasNext}">
                        <li><a class="btn" href="${urlListadoNext}"
                            data-target="#enti-grid-div_${enti.id}"><i
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
                        <c:forEach items="${ssrvList.list}" var="item">
                            <tr>
                                <td nowrap="nowrap"><c:if test="${param.btnOn eq 'true'}">
                                        <a href="ssrv-modificar.action?item.id=${item.id}"><i
                                            class="glyphicon glyphicon-edit"></i></a>
                                        <a href="ssrv-borrar.action?item.id=${item.id}"><i
                                            class="glyphicon glyphicon-remove"></i></a>
                                    </c:if></td>
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
                                        <c:if test="${itdt == null or not itdt.filled}">
                                            <td />
                                        </c:if>

                                        <c:if test="${itdt != null and itdt.filled}">
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
        </div>
    </c:forEach>

    </div>
    </div>
</c:if>