<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<fmt:message key="format.integer" var="integerPattern" scope="page" />
<fmt:message key="format.double" var="doublePattern" scope="page" />
<fmt:message key="format.datetime" var="datetimePattern" scope="page" />
<fmt:message key="format.datetime.js" var="datetimePatternJS" scope="page" />

<div class="form-horizontal">
    <fieldset>
        <legend>
            ${enti.engdMap[3].etiqueta}
        </legend>
        <div class="form-group">
            <c:set var="entd" value="${enti.entdMap[41046]}" />
            <label class="col-md-3 control-label">${entd.etiqueta}</label>
            <div class="col-md-9">
                <input type="text" name="item.itdtMap[41046].cantidadDecimal"
                    id="item.itdtMap[41046].cantidadDecimal"
                    value="${item.itdtMap[41046].cantidadDecimal}"
                    class="form-control input-sm number" maxlength="15"
                    ${param.disabled eq 'true' ? "disabled='disabled'" : "required='required'"} />
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-3 control-label">${enti.entdMap[41047].etiqueta}</label>
            <div class="col-md-9">
                <input type="text" name="item.itdtMap[41047].cantidadDecimal"
                    id="item.itdtMap[41047].cantidadDecimal"
                    value="${item.itdtMap[41047].cantidadDecimal}"
                    class="form-control input-sm number" maxlength="15"
                    ${param.disabled eq 'true' ? "disabled='disabled'" : "required='required'"} />
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-3 control-label">${enti.entdMap[45181].etiqueta}</label>
            <div class="col-md-9">
                <c:if test="${param.disabled eq 'true'}">
                    <input type='text' id="item.itdtMap[45181].prmt.etiqueta"
                        name="item.itdtMap[45181].prmt.etiqueta" class="form-control input-sm"
                        value="${item.itdtMap[45181].prmt.etiqueta}" disabled="disabled" />
                </c:if>
                <c:if test="${param.disabled eq 'false'}">
                    <div class="input-group-sm">
                        <input type="text" autocomplete="off"
                            name="item.itdtMap[45181].prmt.etiqueta"
                            id="item_itdtMap_45181__etiqueta"
                            value="${item.itdtMap[45181].prmt.etiqueta}"
                            class="form-control input-sm" required="required" />
                    </div>
                    <input type="hidden" name="item.itdtMap[45181].prmt.id" id="item_itdtMap_45181_"
                        value="${item.itdtMap[45181].prmt.id}" />
                    <script type="text/javascript">
																					$(
																							'#item_itdtMap_45181__etiqueta')
																							.typeahead(
																									[ {
																										name : 'item_itdtMap_45181__lupa',
																										remote : {
																											url : '${pageContext.request.contextPath}/maestro/prmt-lupa.action?itemLupaCriterio.entiId=${enti.entdMap[45181].tpdt.enti.id}&itemLupaCriterio.fechaVigencia=31/01/2014&itemLupaCriterio.textoBusqueda=%QUERY',
																											filter : function(
																													parsedResponse) {
																												return parsedResponse.itemList;
																											}
																										},
																										valueKey : 'label',
																									} ]);
																					$(
																							'#item_itdtMap_45181__etiqueta')
																							.on(
																									'typeahead:selected typeahead:autocompleted',
																									function(
																											event,
																											datum) {
																										$(
																												'#item_itdtMap_45181_')
																												.val(
																														datum.value);
																									});
																					;
																				</script>
                </c:if>
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-3 control-label">${enti.entdMap[45411].etiqueta}</label>
            <div class="col-md-9">
                <c:if test="${param.disabled eq 'true'}">
                    <input type='text' id="item.itdtMap[45411].prmt.etiqueta"
                        name="item.itdtMap[45411].prmt.etiqueta" class="form-control input-sm"
                        value="${item.itdtMap[45411].prmt.etiqueta}" disabled="disabled" />
                </c:if>
                <c:if test="${param.disabled eq 'false'}">
                    <select name="item.itdtMap[45411].prmt.id" id="item.itdtMap[45411].prmt.id"
                        class="form-control input-sm" required="required">
                        <option value="" />
                        <c:forEach items="${labelValuesMap[enti.entdMap[45411].tpdt.enti.id]}"
                            var="labelValue">
                            <option value="${labelValue.value}"
                                ${labelValue.value eq item.itdtMap[45411].prmt.id ? 'selected' : ''}>${labelValue.label}</option>
                        </c:forEach>
                    </select>
                </c:if>
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-3 control-label">${enti.entdMap[43121].etiqueta}</label>
            <div class="col-md-9">
                <c:if test="${param.disabled eq 'true'}">
                    <input type='text' id="item.itdtMap[43121].cadena"
                        name="item.itdtMap[43121].cadena" class="form-control input-sm"
                        value="${item.itdtMap[43121].cadena}" disabled="disabled" />
                </c:if>
                <c:if test="${param.disabled eq 'false'}">
                    <select name="item.itdtMap[43121].cadena" id="item.itdtMap[43121].cadena"
                        class="form-control input-sm" required="required">
                        <option value="" />
                        <c:forEach items="${enti.entdMap[43121].tpdt.cdrfList}" var="value">
                            <option value="${value.valor}"
                                ${value.valor eq item.itdtMap[43121].cadena ? 'selected' : ''}>${value.valor}</option>
                        </c:forEach>
                    </select>
                </c:if>
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-3 control-label">${enti.entdMap[41048].etiqueta}</label>
            <div class="col-md-9">
                <input type="text" name="item.itdtMap[41048].cantidadDecimal"
                    id="item.itdtMap[41048].cantidadDecimal"
                    value="${item.itdtMap[41048].cantidadDecimal}"
                    class="form-control input-sm number" maxlength="15"
                    ${param.disabled eq 'true' ? "disabled='disabled'" : "required='required'"} />
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-3 control-label">${enti.entdMap[41049].etiqueta}</label>
            <div class="col-md-9">
                <input type="text" name="item.itdtMap[41049].cantidadDecimal"
                    id="item.itdtMap[41049].cantidadDecimal"
                    value="${item.itdtMap[41049].cantidadDecimal}"
                    class="form-control input-sm number" maxlength="15"
                    ${param.disabled eq 'true' ? "disabled='disabled'" : "required='required'"} />
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-3 control-label">${enti.entdMap[45001].etiqueta}</label>
            <div class="col-md-9">
                <c:if test="${param.disabled eq 'true'}">
                    <input type='text' id="item.itdtMap[45001].prmt.etiqueta"
                        name="item.itdtMap[45001].prmt.etiqueta" class="form-control input-sm"
                        value="${item.itdtMap[45001].prmt.etiqueta}" disabled="disabled" />
                </c:if>
                <c:if test="${param.disabled eq 'false'}">
                    <select name="item.itdtMap[45001].prmt.id" id="item.itdtMap[45001].prmt.id"
                        class="form-control input-sm" required="required">
                        <option value="" />
                        <c:forEach items="${labelValuesMap[enti.entdMap[45001].tpdt.enti.id]}"
                            var="labelValue">
                            <option value="${labelValue.value}"
                                ${labelValue.value eq item.itdtMap[45001].prmt.id ? 'selected' : ''}>${labelValue.label}</option>
                        </c:forEach>
                    </select>
                </c:if>
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-3 control-label">${enti.entdMap[41100].etiqueta}</label>
            <div class="col-md-9">
                <fmt:formatDate value="${item.itdtMap[41100].fecha}" pattern="${datetimePattern}"
                    var="fechaString" />
                <c:if test="${param.disabled eq 'true'}">
                    <input type='text' id="item.itdtMap[41100].fecha"
                        name="item.itdtMap[41100].fecha" class="form-control input-sm"
                        data-format="${datetimePatternJS}" value="${fechaString}"
                        disabled="disabled" />
                </c:if>
                <c:if test="${param.disabled eq 'false'}">
                    <div class='input-group date' id='datetimepicker_41100'>
                        <input type='text' id="item.itdtMap[41100].fecha"
                            name="item.itdtMap[41100].fecha" class="form-control input-sm"
                            data-format="${datetimePatternJS}" value="${fechaString}"
                            required="required" /> <span
                            class="input-group-addon"><span
                            class="glyphicon glyphicon-calendar"></span> </span>
                    </div>
                    <script type="text/javascript">
																					$(function() {
																						$(
																								'#datetimepicker_41100')
																								.datetimepicker(
																										{});
																					});
																				</script>
                </c:if>
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-3 control-label">${enti.entdMap[41081].etiqueta}</label>
            <div class="col-md-9">
                <textarea name="item.itdtMap[41081].cadena" id="item.itdtMap[41081].cadena" rows="4"
                    class="form-control input-sm"
                    <c:if test="${param.disabled eq 'true'}">disabled="disabled"</c:if>>${item.itdtMap[41081].cadena}</textarea>
            </div>
        </div>
    </fieldset>
</div>
