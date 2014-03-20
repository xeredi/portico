<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<fmt:message key="format.datetime" var="datetimePattern" scope="page" />
<fmt:message key="format.date" var="datePattern" scope="page" />
<fmt:message key="format.datetime.js" var="datetimePatternJS" scope="page" />
<fmt:message key="format.date.js" var="datePatternJS" scope="page" />
<fmt:message key="format.integer" var="integerPattern" scope="page" />
<fmt:message key="format.double" var="doublePattern" scope="page" />

<c:set var="filaActual" value="1" />

<fieldset>
    <div class="row">
        <c:forEach items="${enti.entdList}" var="tpdtId">
            <c:set var="entd" value="${enti.entdMap[tpdtId]}" />
            <c:set var="valor" value="${item.itdtMap[entd.tpdt.id]}" />
            <c:set var="fieldId" value="item_itdtMap_${entd.tpdt.id}_" />
            <c:set var="fieldName" value="item.itdtMap[${entd.tpdt.id}]" />

            <c:if test="${entd.grupo == 1}">

                <%--
        <c:if test="${filaActual != entd.fila}">
            <c:set var="filaActual" value="${entd.fila}" />
</div>
<div class="row">
    </c:if>
 --%>
                <div class="col-md-${entd.span} col-lg-${entd.spanLg} form-group">
                    <label>${entd.etiqueta}</label>
                    <c:choose>
                        <c:when test="${entd.tpdt.tipoElemento eq 'BO'}">
                            <select name="${fieldName}.booleano" id="${fieldId}"
                                class="form-control input-sm"
                                <c:if test="${entd.obligatorio}">required="required"</c:if>>
                                <option value="" />
                                <c:if test="${valor.booleano == null}">
                                    <option value="true"><fmt:message key="boolean.true" /></option>
                                    <option value="false"><fmt:message key="boolean.false" /></option>
                                </c:if>
                                <c:if test="${valor.booleano != null}">
                                    <option value="true"
                                        <c:if test="${true == valor.booleano}">selected='selected'</c:if>><fmt:message
                                            key="boolean.true" /></option>
                                    <option value="false"
                                        <c:if test="${false == valor.booleano}">selected='selected'</c:if>><fmt:message
                                            key="boolean.false" /></option>
                                </c:if>
                            </select>
                        </c:when>
                        <c:when test="${entd.tpdt.tipoElemento eq 'ND'}">
                            <input type="text" name="${fieldName}.cantidadDecimal" id="${fieldId}"
                                value="${valor.cantidadDecimal}"
                                class="form-control input-sm number" maxlength="15"
                                <c:if test="${entd.obligatorio}">required="required"</c:if> />
                        </c:when>
                        <c:when test="${entd.tpdt.tipoElemento eq 'NE'}">
                            <input type="text" name="${fieldName}.cantidadEntera" id="${fieldId}"
                                value="${valor.cantidadEntera}" class="form-control input-sm number"
                                maxlength="15"
                                <c:if test="${entd.obligatorio}">required="required"</c:if> />
                        </c:when>
                        <c:when test="${entd.tpdt.tipoElemento eq 'FH'}">
                            <fmt:formatDate value="${valor.fecha}" pattern="${datetimePattern}"
                                var="fechaString" />
                            <div class='input-group date' id='datetimepicker_${entd.tpdt.id}'>
                                <input type='text' id="${fieldId}" name="${fieldName}.fecha"
                                    class="form-control input-sm" data-format="${datetimePatternJS}"
                                    value="${fechaString}" /> <span class="input-group-addon"><span
                                    class="glyphicon glyphicon-calendar"></span> </span>
                            </div>
                            <script type="text/javascript">
																													$(function() {
																														$(
																																'#datetimepicker_${entd.tpdt.id}')
																																.datetimepicker(
																																		{});
																													});
																												</script>
                        </c:when>
                        <c:when test="${entd.tpdt.tipoElemento eq 'FE'}">
                            <fmt:formatDate value="${valor.fecha}" pattern="${datePattern}"
                                var="fechaString" />
                            <div class='input-group date' id='datepicker_${entd.tpdt.id}'>
                                <input type='text' id="${fieldId}" name="${fieldName}.fecha"
                                    class="form-control input-sm" data-format="${datePatternJS}"
                                    value="${fechaString}" /> <span class="input-group-addon"><span
                                    class="glyphicon glyphicon-calendar"></span> </span>
                            </div>
                            <script type="text/javascript">
																													$(function() {
																														$(
																																'#datepicker_${entd.tpdt.id}')
																																.datetimepicker(
																																		{
																																			pickTime : false
																																		});
																													});
																												</script>
                        </c:when>
                        <c:when test="${entd.tpdt.tipoElemento eq 'TX'}">
                            <c:choose>
                                <c:when test="${entd.tpdt.tpht eq 'T'}">
                                    <input type="text" name="${fieldName}.cadena" id="${fieldId}"
                                        value="${valor.cadena}" class="form-control input-sm"
                                        <c:if test="${entd.obligatorio}">required="required"</c:if> />
                                </c:when>
                                <c:when test="${entd.tpdt.tpht eq 'TA'}">
                                    <textarea name="${fieldName}.cadena" id="${fieldId}" rows="4"
                                        class="form-control input-sm"
                                        <c:if test="${entd.obligatorio}">required="required"</c:if>>${valor.cadena}</textarea>
                                </c:when>
                                <c:otherwise>
                                    <span>Dato de tipo HTML desconocido: ${entd.tpdt.tpht}</span>
                                </c:otherwise>
                            </c:choose>
                        </c:when>
                        <c:when test="${entd.tpdt.tipoElemento eq 'CR'}">
                            <select name="${fieldName}.cadena" id="${fieldId}"
                                class="form-control input-sm"
                                <c:if test="${entd.obligatorio}">required="required"</c:if>>
                                <option value="" />
                                <c:if test="${empty valor.cadena}">
                                    <c:forEach items="${entd.tpdt.cdrfList}" var="value">
                                        <option value="${value.valor}">${value.valor}</option>
                                    </c:forEach>
                                </c:if>
                                <c:if test="${not empty valor.cadena}">
                                    <c:forEach items="${entd.tpdt.cdrfList}" var="value">
                                        <option value="${value.valor}"
                                            ${value.valor eq valor.cadena ? 'selected' : ''}>${value.valor}</option>
                                    </c:forEach>
                                </c:if>
                            </select>
                        </c:when>
                        <c:when test="${entd.tpdt.tipoElemento eq 'PR'}">
                            <c:choose>
                                <c:when test="${entd.tpdt.tpht eq 'F'}">
                                    <div class="input-group-sm">
                                        <input type="text" autocomplete="off"
                                            name="${fieldName}.prmt.etiqueta"
                                            id="${fieldId}_etiqueta" value="${valor.prmt.etiqueta}"
                                            class="form-control input-sm"
                                            <c:if test="${entd.obligatorio}">required="required"</c:if> />
                                    </div>
                                    <input type="hidden" name="${fieldName}.prmt.id" id="${fieldId}"
                                        value="${valor.prmt.id}" />
                                    <script type="text/javascript">
																																					$(
																																							'#${fieldId}_etiqueta')
																																							.typeahead(
																																									[ {
																																										name : '${fieldId}_lupa',
																																										remote : {
																																											url : '${pageContext.request.contextPath}/maestro/prmt-lupa.action?itemLupaCriterio.entiId=${entd.tpdt.enti.id}&itemLupaCriterio.fechaVigencia=31/01/2014&itemLupaCriterio.textoBusqueda=%QUERY',
																																											filter : function(
																																													parsedResponse) {
																																												return parsedResponse.itemList;
																																											}
																																										},
																																										valueKey : 'label',
																																									} ]);
																																					$(
																																							'#${fieldId}_etiqueta')
																																							.on(
																																									'typeahead:selected typeahead:autocompleted',
																																									function(
																																											event,
																																											datum) {
																																										$(
																																												'#${fieldId}')
																																												.val(
																																														datum.value);
																																									});
																																					;
																																				</script>
                                </c:when>
                                <c:when test="${entd.tpdt.tpht eq 'S'}">
                                    <select name="${fieldName}.prmt.id" id="${fieldId}"
                                        class="form-control input-sm"
                                        <c:if test="${entd.obligatorio}">required="required"</c:if>>
                                        <option value="" />
                                        <c:if test="${empty valor.prmt.id}">
                                            <c:forEach items="${labelValuesMap[entd.tpdt.enti.id]}"
                                                var="labelValue">
                                                <option value="${labelValue.value}">${labelValue.label}</option>
                                            </c:forEach>
                                        </c:if>
                                        <c:if test="${not empty valor.prmt.id}">
                                            <c:forEach items="${labelValuesMap[entd.tpdt.enti.id]}"
                                                var="labelValue">
                                                <option value="${labelValue.value}"
                                                    <c:if test="${labelValue.value eq valor.prmt.id}">selected</c:if>>${labelValue.label}</option>
                                            </c:forEach>
                                        </c:if>
                                    </select>
                                </c:when>
                                <c:otherwise>
                                    <span>ERROR!!!. Dato de tipo desconocido:
                                        ${entd.tpdt.tipoElemento}</span>
                                </c:otherwise>
                            </c:choose>
                        </c:when>
                        <c:when test="${entd.tpdt.tipoElemento eq 'SR'}">
                            <div class="input-group-sm">
                                <input type="text" autocomplete="off"
                                    name="${fieldName}.srvc.etiqueta" id="${fieldId}_etiqueta"
                                    value="${valor.srvc.etiqueta}" class="form-control input-sm"
                                    <c:if test="${entd.obligatorio}">required="required"</c:if> />
                            </div>
                            <input type="hidden" name="${fieldName}.srvc.id" id="${fieldId}"
                                value="${valor.srvc.id}" />
                            <script type="text/javascript">
																													$(
																															'#${fieldId}_etiqueta')
																															.typeahead(
																																	[ {
																																		name : '${fieldId}_lupa',
																																		remote : {
																																			url : '${pageContext.request.contextPath}/servicio/srvc-lupa.action?itemLupaCriterio.entiId=${entd.tpdt.enti.id}&itemLupaCriterio.textoBusqueda=%QUERY',
																																			filter : function(
																																					parsedResponse) {
																																				return parsedResponse.itemList;
																																			}
																																		},
																																		valueKey : 'label',
																																	} ]);
																													$(
																															'#${fieldId}_etiqueta')
																															.on(
																																	'typeahead:selected typeahead:autocompleted',
																																	function(
																																			event,
																																			datum) {
																																		$(
																																				'#${fieldId}')
																																				.val(
																																						datum.value);
																																	});
																													;
																												</script>
                        </c:when>
                        <c:otherwise>
                            <span>ERROR!!!. Dato de tipo desconocido: ${entd.tpdt}</span>
                        </c:otherwise>
                    </c:choose>
                </div>
            </c:if>
        </c:forEach>
    </div>
</fieldset>

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

                    <fieldset>
                        <c:forEach items="${entdIds}" var="tpdtId">
                            <c:set var="entd" value="${enti.entdMap[tpdtId]}" />
                            <c:set var="valor" value="${item.itdtMap[entd.tpdt.id]}" />
                            <c:set var="fieldId" value="${itemName}_itdtMap_${entd.tpdt.id}_" />
                            <c:set var="fieldName" value="${itemName}.itdtMap[${entd.tpdt.id}]" />

                            <div class="col-md-${entd.span} col-lg-${entd.spanLg} form-group">
                                <label>${entd.etiqueta}</label>
                                <c:choose>
                                    <c:when test="${entd.tpdt.tipoElemento eq 'BO'}">
                                        <select name="${fieldName}.booleano" id="${fieldId}"
                                            class="form-control input-sm"
                                            <c:if test="${entd.obligatorio}">required="required"</c:if>>
                                            <option value="" />
                                            <c:if test="${valor.booleano == null}">
                                                <option value="true"><fmt:message
                                                        key="boolean.true" /></option>
                                                <option value="false"><fmt:message
                                                        key="boolean.false" /></option>
                                            </c:if>
                                            <c:if test="${valor.booleano != null}">
                                                <option value="true"
                                                    <c:if test="${true == valor.booleano}">selected='selected'</c:if>><fmt:message
                                                        key="boolean.true" /></option>
                                                <option value="false"
                                                    <c:if test="${false == valor.booleano}">selected='selected'</c:if>><fmt:message
                                                        key="boolean.false" /></option>
                                            </c:if>
                                        </select>
                                    </c:when>
                                    <c:when test="${entd.tpdt.tipoElemento eq 'ND'}">
                                        <input type="text" name="${fieldName}.cantidadDecimal"
                                            id="${fieldId}" value="${valor.cantidadDecimal}"
                                            class="form-control input-sm number" maxlength="15"
                                            <c:if test="${entd.obligatorio}">required="required"</c:if> />
                                    </c:when>
                                    <c:when test="${entd.tpdt.tipoElemento eq 'NE'}">
                                        <input type="text" name="${fieldName}.cantidadEntera"
                                            id="${fieldId}" value="${valor.cantidadEntera}"
                                            class="form-control input-sm number" maxlength="15"
                                            <c:if test="${entd.obligatorio}">required="required"</c:if> />
                                    </c:when>
                                    <c:when test="${entd.tpdt.tipoElemento eq 'FH'}">
                                        <fmt:formatDate value="${valor.fecha}"
                                            pattern="${datetimePattern}" var="fechaString" />
                                        <div class='input-group date'
                                            id='datetimepicker_${entd.tpdt.id}'>
                                            <input type='text' id="${fieldId}"
                                                name="${fieldName}.fecha"
                                                class="form-control input-sm"
                                                data-format="${datetimePatternJS}"
                                                value="${fechaString}" /> <span
                                                class="input-group-addon"><span
                                                class="glyphicon glyphicon-calendar"></span> </span>
                                        </div>
                                        <script type="text/javascript">
																																									$(function() {
																																										$(
																																												'#datetimepicker_${entd.tpdt.id}')
																																												.datetimepicker(
																																														{});
																																									});
																																								</script>
                                    </c:when>
                                    <c:when test="${entd.tpdt.tipoElemento eq 'FE'}">
                                        <fmt:formatDate value="${valor.fecha}"
                                            pattern="${datePattern}" var="fechaString" />
                                        <div class='input-group date'
                                            id='datepicker_${entd.tpdt.id}'>
                                            <input type='text' id="${fieldId}"
                                                name="${fieldName}.fecha"
                                                class="form-control input-sm"
                                                data-format="${datePatternJS}"
                                                value="${fechaString}" /> <span
                                                class="input-group-addon"><span
                                                class="glyphicon glyphicon-calendar"></span> </span>
                                        </div>
                                        <script type="text/javascript">
																																									$(function() {
																																										$(
																																												'#datepicker_${entd.tpdt.id}')
																																												.datetimepicker(
																																														{
																																															pickTime : false
																																														});
																																									});
																																								</script>
                                    </c:when>
                                    <c:when test="${entd.tpdt.tipoElemento eq 'TX'}">
                                        <c:choose>
                                            <c:when test="${entd.tpdt.tpht eq 'T'}">
                                                <input type="text" name="${fieldName}.cadena"
                                                    id="${fieldId}" value="${valor.cadena}"
                                                    class="form-control input-sm"
                                                    <c:if test="${entd.obligatorio}">required="required"</c:if> />
                                            </c:when>
                                            <c:when test="${entd.tpdt.tpht eq 'TA'}">
                                                <textarea name="${fieldName}.cadena" id="${fieldId}"
                                                    rows="4" class="form-control input-sm"
                                                    <c:if test="${entd.obligatorio}">required="required"</c:if>>${valor.cadena}</textarea>
                                            </c:when>
                                            <c:otherwise>
                                                <span>Dato de tipo HTML desconocido:
                                                    ${entd.tpdt.tpht}</span>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:when>
                                    <c:when test="${entd.tpdt.tipoElemento eq 'CR'}">
                                        <select name="${fieldName}.cadena" id="${fieldId}"
                                            class="form-control input-sm"
                                            <c:if test="${entd.obligatorio}">required="required"</c:if>>
                                            <option value="" />
                                            <c:if test="${empty valor.cadena}">
                                                <c:forEach items="${entd.tpdt.cdrfList}" var="value">
                                                    <option value="${value.valor}">${value.valor}</option>
                                                </c:forEach>
                                            </c:if>
                                            <c:if test="${not empty valor.cadena}">
                                                <c:forEach items="${entd.tpdt.cdrfList}" var="value">
                                                    <option value="${value.valor}"
                                                        ${value.valor eq valor.cadena ? 'selected' : ''}>${value.valor}</option>
                                                </c:forEach>
                                            </c:if>
                                        </select>
                                    </c:when>
                                    <c:when test="${entd.tpdt.tipoElemento eq 'PR'}">
                                        <c:choose>
                                            <c:when test="${entd.tpdt.tpht eq 'F'}">
                                                <div class="input-group-sm">
                                                    <input type="text" autocomplete="off"
                                                        name="${fieldName}.prmt.etiqueta"
                                                        id="${fieldId}_etiqueta"
                                                        value="${valor.prmt.etiqueta}"
                                                        class="form-control input-sm"
                                                        <c:if test="${entd.obligatorio}">required="required"</c:if> />
                                                </div>
                                                <input type="hidden" name="${fieldName}.prmt.id"
                                                    id="${fieldId}" value="${valor.prmt.id}" />
                                                <script type="text/javascript">
																																																	$(
																																																			'#${fieldId}_etiqueta')
																																																			.typeahead(
																																																					[ {
																																																						name : '${fieldId}_lupa',
																																																						remote : {
																																																							url : '${pageContext.request.contextPath}/maestro/prmt-lupa.action?prmtLupaCriterio.entiId=${entd.tpdt.enti.id}&prmtLupaCriterio.fechaVigencia=31/01/2014&prmtLupaCriterio.textoBusqueda=%QUERY',
																																																							filter : function(
																																																									parsedResponse) {
																																																								return parsedResponse.prmts;
																																																							}
																																																						},
																																																						valueKey : 'label',
																																																					} ]);
																																																	$(
																																																			'#${fieldId}_etiqueta')
																																																			.on(
																																																					'typeahead:selected typeahead:autocompleted',
																																																					function(
																																																							event,
																																																							datum) {
																																																						$(
																																																								'#${fieldId}')
																																																								.val(
																																																										datum.value);
																																																					});
																																																	;
																																																</script>
                                            </c:when>
                                            <c:when test="${entd.tpdt.tpht eq 'S'}">
                                                <select name="${fieldName}.prmt.id" id="${fieldId}"
                                                    class="form-control input-sm"
                                                    <c:if test="${entd.obligatorio}">required="required"</c:if>>
                                                    <option value="" />
                                                    <c:if test="${empty valor.prmt.id}">
                                                        <c:forEach
                                                            items="${labelValuesMap[entd.tpdt.enti.id]}"
                                                            var="labelValue">
                                                            <option value="${labelValue.value}">${labelValue.label}</option>
                                                        </c:forEach>
                                                    </c:if>
                                                    <c:if test="${not empty valor.prmt.id}">
                                                        <c:forEach
                                                            items="${labelValuesMap[entd.tpdt.enti.id]}"
                                                            var="labelValue">
                                                            <option value="${labelValue.value}"
                                                                <c:if test="${labelValue.value eq valor.prmt.id}">selected</c:if>>${labelValue.label}</option>
                                                        </c:forEach>
                                                    </c:if>
                                                </select>
                                            </c:when>
                                            <c:otherwise>
                                                <span>ERROR!!!. Dato de tipo desconocido:
                                                    ${entd.tpdt.tipoElemento}</span>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:when>
                                    <c:when test="${entd.tpdt.tipoElemento eq 'SR'}">
                                        <div class="input-group-sm">
                                            <input type="text" autocomplete="off"
                                                name="${fieldName}.srvc.etiqueta"
                                                id="${fieldId}_etiqueta"
                                                value="${valor.srvc.etiqueta}"
                                                class="form-control input-sm"
                                                <c:if test="${entd.obligatorio}">required="required"</c:if> />
                                        </div>
                                        <input type="hidden" name="${fieldName}.srvc.id"
                                            id="${fieldId}" value="${valor.srvc.id}" />
                                        <script type="text/javascript">
																																									$(
																																											'#${fieldId}_etiqueta')
																																											.typeahead(
																																													[ {
																																														name : '${fieldId}_lupa',
																																														remote : {
																																															url : '${pageContext.request.contextPath}/servicio/srvc-lupa.action?srvcLupaCriterio.entiId=${entd.tpdt.enti.id}&srvcLupaCriterio.textoBusqueda=%QUERY',
																																															filter : function(
																																																	parsedResponse) {
																																																return parsedResponse.srvcs;
																																															}
																																														},
																																														valueKey : 'label',
																																													} ]);
																																									$(
																																											'#${fieldId}_etiqueta')
																																											.on(
																																													'typeahead:selected typeahead:autocompleted',
																																													function(
																																															event,
																																															datum) {
																																														$(
																																																'#${fieldId}')
																																																.val(
																																																		datum.value);
																																													});
																																									;
																																								</script>
                                    </c:when>
                                    <c:otherwise>
                                        <span>ERROR!!!. Dato de tipo desconocido:
                                            ${entd.tpdt}</span>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </c:forEach>
                    </fieldset>
                </div>
            </c:forEach>
        </div>
    </div>
</c:if>