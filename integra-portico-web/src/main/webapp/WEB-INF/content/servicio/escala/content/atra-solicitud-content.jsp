<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<fmt:message key="format.integer" var="integerPattern" scope="page" />
<fmt:message key="format.double" var="doublePattern" scope="page" />
<fmt:message key="format.datetime" var="datetimePattern" scope="page" />
<fmt:message key="format.datetime.js" var="datetimePatternJS" scope="page" />

<div class="form-horizontal">
    <fieldset>
        <legend> ${enti.engdMap[2].etiqueta} </legend>
        <div class="form-group">
            <c:set var="entd" value="${enti.entdMap[41040]}" />
            <label class="col-md-3 control-label">${entd.etiqueta}</label>
            <div class="col-md-9">
                <input type="text" name="item.itdtMap[41040].cantidadDecimal"
                    id="item.itdtMap[41040].cantidadDecimal"
                    value="${item.itdtMap[41040].cantidadDecimal}"
                    class="form-control input-sm number" maxlength="15"
                    ${param.disabled eq 'true' ? "disabled='disabled'" : "required='required'"} />
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-3 control-label">${enti.entdMap[41041].etiqueta}</label>
            <div class="col-md-9">
                <input type="text" name="item.itdtMap[41041].cantidadDecimal"
                    id="item.itdtMap[41041].cantidadDecimal"
                    value="${item.itdtMap[41041].cantidadDecimal}"
                    class="form-control input-sm number" maxlength="15"
                    ${param.disabled eq 'true' ? "disabled='disabled'" : "required='required'"} />
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-3 control-label">${enti.entdMap[45180].etiqueta}</label>
            <div class="col-md-9">
                <c:if test="${param.disabled eq 'true'}">
                    <input type='text' id="item.itdtMap[45180].prmt.etiqueta"
                        name="item.itdtMap[45180].prmt.etiqueta" class="form-control input-sm"
                        value="${item.itdtMap[45180].prmt.etiqueta}" disabled="disabled" />
                </c:if>
                <c:if test="${param.disabled eq 'false'}">
                    <div class="input-group-sm">
                        <input type="text" autocomplete="off"
                            name="item.itdtMap[45180].prmt.etiqueta"
                            id="item_itdtMap_45180__etiqueta"
                            value="${item.itdtMap[45180].prmt.etiqueta}"
                            class="form-control input-sm" required="required" />
                    </div>
                    <input type="hidden" name="item.itdtMap[45180].prmt.id" id="item_itdtMap_45180_"
                        value="${item.itdtMap[45180].prmt.id}" />
                    <script type="text/javascript">
																					$(
																							'#item_itdtMap_45180__etiqueta')
																							.typeahead(
																									[ {
																										name : 'item_itdtMap_45180__lupa',
																										remote : {
																											url : '${pageContext.request.contextPath}/maestro/prmt-lupa.action?itemLupaCriterio.entiId=${enti.entdMap[45180].tpdt.enti.id}&itemLupaCriterio.fechaVigencia=31/01/2014&itemLupaCriterio.textoBusqueda=%QUERY',
																											filter : function(
																													parsedResponse) {
																												return parsedResponse.itemList;
																											}
																										},
																										valueKey : 'label',
																									} ]);
																					$(
																							'#item_itdtMap_45180__etiqueta')
																							.on(
																									'typeahead:selected typeahead:autocompleted',
																									function(
																											event,
																											datum) {
																										$(
																												'#item_itdtMap_45180_')
																												.val(
																														datum.value);
																									});
																					;
																				</script>
                </c:if>
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-3 control-label">${enti.entdMap[45410].etiqueta}</label>
            <div class="col-md-9">
                <c:if test="${param.disabled eq 'true'}">
                    <input type='text' id="item.itdtMap[45410].prmt.etiqueta"
                        name="item.itdtMap[45410].prmt.etiqueta" class="form-control input-sm"
                        value="${item.itdtMap[45410].prmt.etiqueta}" disabled="disabled" />
                </c:if>
                <c:if test="${param.disabled eq 'false'}">
                    <select name="item.itdtMap[45410].prmt.id" id="item.itdtMap[45410].prmt.id"
                        class="form-control input-sm" required="required">
                        <option value="" />
                        <c:forEach items="${labelValuesMap[enti.entdMap[45410].tpdt.enti.id]}"
                            var="labelValue">
                            <option value="${labelValue.value}"
                                ${labelValue.value eq item.itdtMap[45410].prmt.id ? 'selected' : ''}>${labelValue.label}</option>
                        </c:forEach>
                    </select>
                </c:if>
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-3 control-label">${enti.entdMap[43120].etiqueta}</label>
            <div class="col-md-9">
                <c:if test="${param.disabled eq 'true'}">
                    <input type='text' id="item.itdtMap[43120].cadena"
                        name="item.itdtMap[43120].cadena" class="form-control input-sm"
                        value="${item.itdtMap[43120].cadena}" disabled="disabled" />
                </c:if>
                <c:if test="${param.disabled eq 'false'}">
                    <select name="item.itdtMap[43120].cadena" id="item.itdtMap[43120].cadena"
                        class="form-control input-sm" required="required">
                        <option value="" />
                        <c:forEach items="${enti.entdMap[43120].tpdt.cdrfList}" var="value">
                            <option value="${value.valor}"
                                ${value.valor eq item.itdtMap[43120].cadena ? 'selected' : ''}>${value.valor}</option>
                        </c:forEach>
                    </select>
                </c:if>
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-3 control-label">${enti.entdMap[41042].etiqueta}</label>
            <div class="col-md-9">
                <input type="text" name="item.itdtMap[41042].cantidadDecimal"
                    id="item.itdtMap[41042].cantidadDecimal"
                    value="${item.itdtMap[41042].cantidadDecimal}"
                    class="form-control input-sm number" maxlength="15"
                    ${param.disabled eq 'true' ? "disabled='disabled'" : "required='required'"} />
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-3 control-label">${enti.entdMap[41043].etiqueta}</label>
            <div class="col-md-9">
                <input type="text" name="item.itdtMap[41043].cantidadDecimal"
                    id="item.itdtMap[41043].cantidadDecimal"
                    value="${item.itdtMap[41043].cantidadDecimal}"
                    class="form-control input-sm number" maxlength="15"
                    ${param.disabled eq 'true' ? "disabled='disabled'" : "required='required'"} />
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-3 control-label">${enti.entdMap[45000].etiqueta}</label>
            <div class="col-md-9">
                <c:if test="${param.disabled eq 'true'}">
                    <input type='text' id="item.itdtMap[45000].prmt.etiqueta"
                        name="item.itdtMap[45000].prmt.etiqueta" class="form-control input-sm"
                        value="${item.itdtMap[45000].prmt.etiqueta}" disabled="disabled" />
                </c:if>
                <c:if test="${param.disabled eq 'false'}">
                    <select name="item.itdtMap[45000].prmt.id" id="item.itdtMap[45000].prmt.id"
                        class="form-control input-sm" required="required">
                        <option value="" />
                        <c:forEach items="${labelValuesMap[enti.entdMap[45000].tpdt.enti.id]}"
                            var="labelValue">
                            <option value="${labelValue.value}"
                                ${labelValue.value eq item.itdtMap[45000].prmt.id ? 'selected' : ''}>${labelValue.label}</option>
                        </c:forEach>
                    </select>
                </c:if>
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-3 control-label">${enti.entdMap[41101].etiqueta}</label>
            <div class="col-md-9">
                <fmt:formatDate value="${item.itdtMap[41101].fecha}" pattern="${datetimePattern}"
                    var="fechaString" />
                <c:if test="${param.disabled eq 'true'}">
                    <input type='text' id="item.itdtMap[41101].fecha"
                        name="item.itdtMap[41101].fecha" class="form-control input-sm"
                        data-format="${datetimePatternJS}" value="${fechaString}"
                        disabled="disabled" />
                </c:if>
                <c:if test="${param.disabled eq 'false'}">
                    <div class='input-group date' id='datetimepicker_41101'>
                        <input type='text' id="item.itdtMap[41101].fecha"
                            name="item.itdtMap[41101].fecha" class="form-control input-sm"
                            data-format="${datetimePatternJS}" value="${fechaString}"
                            required="required" /> <span class="input-group-addon"><span
                            class="glyphicon glyphicon-calendar"></span> </span>
                    </div>
                    <script type="text/javascript">
																					$(function() {
																						$(
																								'#datetimepicker_41101')
																								.datetimepicker(
																										{});
																					});
																				</script>
                </c:if>
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-3 control-label">${enti.entdMap[41080].etiqueta}</label>
            <div class="col-md-9">
                <textarea name="item.itdtMap[41080].cadena" id="item.itdtMap[41080].cadena" rows="4"
                    class="form-control input-sm"
                    <c:if test="${param.disabled eq 'true'}">disabled="disabled"</c:if>>${item.itdtMap[41080].cadena}</textarea>
            </div>
        </div>
    </fieldset>
</div>
