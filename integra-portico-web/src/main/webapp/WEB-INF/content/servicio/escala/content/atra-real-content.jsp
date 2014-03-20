<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<fmt:message key="format.integer" var="integerPattern" scope="page" />
<fmt:message key="format.double" var="doublePattern" scope="page" />
<fmt:message key="format.datetime" var="datetimePattern" scope="page" />
<fmt:message key="format.datetime.js" var="datetimePatternJS" scope="page" />

<div class="form-horizontal">
    <fieldset>
        <legend> ${enti.engdMap[4].etiqueta} </legend>
        <div class="form-group">
            <c:set var="entd" value="${enti.entdMap[41052]}" />
            <label class="col-md-3 control-label">${entd.etiqueta}</label>
            <div class="col-md-9">
                <input type="text" name="item.itdtMap[41052].cantidadDecimal"
                    id="item.itdtMap[41052].cantidadDecimal"
                    value="${item.itdtMap[41052].cantidadDecimal}"
                    class="form-control input-sm number" maxlength="15"
                    ${param.disabled eq 'true' ? "disabled='disabled'" : "required='required'"} />
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-3 control-label">${enti.entdMap[41053].etiqueta}</label>
            <div class="col-md-9">
                <input type="text" name="item.itdtMap[41053].cantidadDecimal"
                    id="item.itdtMap[41053].cantidadDecimal"
                    value="${item.itdtMap[41053].cantidadDecimal}"
                    class="form-control input-sm number" maxlength="15"
                    ${param.disabled eq 'true' ? "disabled='disabled'" : "required='required'"} />
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-3 control-label">${enti.entdMap[45182].etiqueta}</label>
            <div class="col-md-9">
                <c:if test="${param.disabled eq 'true'}">
                    <input type='text' id="item.itdtMap[45182].prmt.etiqueta"
                        name="item.itdtMap[45182].prmt.etiqueta" class="form-control input-sm"
                        value="${item.itdtMap[45182].prmt.etiqueta}" disabled="disabled" />
                </c:if>
                <c:if test="${param.disabled eq 'false'}">
                    <div class="input-group-sm">
                        <input type="text" autocomplete="off"
                            name="item.itdtMap[45182].prmt.etiqueta"
                            id="item_itdtMap_45182__etiqueta"
                            value="${item.itdtMap[45182].prmt.etiqueta}"
                            class="form-control input-sm" required="required" />
                    </div>
                    <input type="hidden" name="item.itdtMap[45182].prmt.id" id="item_itdtMap_45182_"
                        value="${item.itdtMap[45182].prmt.id}" />
                    <script type="text/javascript">
																					$(
																							'#item_itdtMap_45182__etiqueta')
																							.typeahead(
																									[ {
																										name : 'item_itdtMap_45182__lupa',
																										remote : {
																											url : '${pageContext.request.contextPath}/maestro/prmt-lupa.action?itemLupaCriterio.entiId=${enti.entdMap[45182].tpdt.enti.id}&itemLupaCriterio.fechaVigencia=31/01/2014&itemLupaCriterio.textoBusqueda=%QUERY',
																											filter : function(
																													parsedResponse) {
																												return parsedResponse.itemList;
																											}
																										},
																										valueKey : 'label',
																									} ]);
																					$(
																							'#item_itdtMap_45182__etiqueta')
																							.on(
																									'typeahead:selected typeahead:autocompleted',
																									function(
																											event,
																											datum) {
																										$(
																												'#item_itdtMap_45182_')
																												.val(
																														datum.value);
																									});
																					;
																				</script>
                </c:if>
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-3 control-label">${enti.entdMap[45412].etiqueta}</label>
            <div class="col-md-9">
                <c:if test="${param.disabled eq 'true'}">
                    <input type='text' id="item.itdtMap[45412].prmt.etiqueta"
                        name="item.itdtMap[45412].prmt.etiqueta" class="form-control input-sm"
                        value="${item.itdtMap[45412].prmt.etiqueta}" disabled="disabled" />
                </c:if>
                <c:if test="${param.disabled eq 'false'}">
                    <select name="item.itdtMap[45412].prmt.id" id="item.itdtMap[45412].prmt.id"
                        class="form-control input-sm" required="required">
                        <option value="" />
                        <c:forEach items="${labelValuesMap[enti.entdMap[45412].tpdt.enti.id]}"
                            var="labelValue">
                            <option value="${labelValue.value}"
                                ${labelValue.value eq item.itdtMap[45412].prmt.id ? 'selected' : ''}>${labelValue.label}</option>
                        </c:forEach>
                    </select>
                </c:if>
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-3 control-label">${enti.entdMap[43122].etiqueta}</label>
            <div class="col-md-9">
                <c:if test="${param.disabled eq 'true'}">
                    <input type='text' id="item.itdtMap[43122].cadena"
                        name="item.itdtMap[43122].cadena" class="form-control input-sm"
                        value="${item.itdtMap[43122].cadena}" disabled="disabled" />
                </c:if>
                <c:if test="${param.disabled eq 'false'}">
                    <select name="item.itdtMap[43122].cadena" id="item.itdtMap[43122].cadena"
                        class="form-control input-sm" required="required">
                        <option value="" />
                        <c:forEach items="${enti.entdMap[43122].tpdt.cdrfList}" var="value">
                            <option value="${value.valor}"
                                ${value.valor eq item.itdtMap[43122].cadena ? 'selected' : ''}>${value.valor}</option>
                        </c:forEach>
                    </select>
                </c:if>
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-3 control-label">${enti.entdMap[41054].etiqueta}</label>
            <div class="col-md-9">
                <input type="text" name="item.itdtMap[41054].cantidadDecimal"
                    id="item.itdtMap[41054].cantidadDecimal"
                    value="${item.itdtMap[41054].cantidadDecimal}"
                    class="form-control input-sm number" maxlength="15"
                    ${param.disabled eq 'true' ? "disabled='disabled'" : "required='required'"} />
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-3 control-label">${enti.entdMap[45002].etiqueta}</label>
            <div class="col-md-9">
                <c:if test="${param.disabled eq 'true'}">
                    <input type='text' id="item.itdtMap[45002].prmt.etiqueta"
                        name="item.itdtMap[45002].prmt.etiqueta" class="form-control input-sm"
                        value="${item.itdtMap[45002].prmt.etiqueta}" disabled="disabled" />
                </c:if>
                <c:if test="${param.disabled eq 'false'}">
                    <select name="item.itdtMap[45002].prmt.id" id="item.itdtMap[45002].prmt.id"
                        class="form-control input-sm" required="required">
                        <option value="" />
                        <c:forEach items="${labelValuesMap[enti.entdMap[45002].tpdt.enti.id]}"
                            var="labelValue">
                            <option value="${labelValue.value}"
                                ${labelValue.value eq item.itdtMap[45002].prmt.id ? 'selected' : ''}>${labelValue.label}</option>
                        </c:forEach>
                    </select>
                </c:if>
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-3 control-label">${enti.entdMap[41082].etiqueta}</label>
            <div class="col-md-9">
                <textarea name="item.itdtMap[41082].cadena" id="item.itdtMap[41082].cadena" rows="4"
                    class="form-control input-sm"
                    <c:if test="${param.disabled eq 'true'}">disabled="disabled"</c:if>>${item.itdtMap[41082].cadena}</textarea>
            </div>
        </div>
    </fieldset>
</div>
