<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<fmt:message key="format.datetime" var="datetimePattern" scope="page" />
<fmt:message key="format.date" var="datePattern" scope="page" />
<fmt:message key="format.datetime.js" var="datetimePatternJS" scope="page" />
<fmt:message key="format.date.js" var="datePatternJS" scope="page" />
<fmt:message key="format.integer" var="integerPattern" scope="page" />
<fmt:message key="format.double" var="doublePattern" scope="page" />

<div class="row">
    <c:forEach items="${enti.entdList}" var="tpdtId">
        <c:set var="entd" value="${enti.entdMap[tpdtId]}" />

        <c:if test="${entd.filtrable}">
            <c:set var="fieldId" value="itemCriterio_itdtMap_${entd.tpdt.id}_" />
            <c:set var="fieldName" value="itemCriterio.itdtMap['${entd.tpdt.id}']" />
            <c:set var="valor" value="${itemCriterio.itdtMap[entd.tpdt.id]}" />

            <input type="hidden" id="${fieldName}.tpdtId" name="${fieldName}.tpdtId"
                value="${entd.tpdt.id}" />
            <div class="col-md-${entd.span} col-lg-${entd.spanLg} form-group">
                <label>${entd.etiqueta}</label>
                <c:choose>
                    <c:when test="${entd.tpdt.tipoElemento == 'BO'}">
                        <select name="${fieldName}.booleano" id="${fieldName}.booleano"
                            class="form-control input-sm">
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
                    <c:when test="${entd.tpdt.tipoElemento == 'ND'}">
                        <input type="text" name="${fieldName}.cantidadDecimal"
                            id="${fieldName}.cantidadDecimal" value="${valor.cantidadDecimal}"
                            class="form-control input-sm" />
                    </c:when>
                    <c:when test="${entd.tpdt.tipoElemento == 'NE'}">
                        <input type="text" name="${fieldName}.cantidadEntera"
                            id="${fieldName}.cantidadEntera" value="${valor.cantidadEntera}"
                            class="form-control input-sm" />
                    </c:when>
                    <c:when test="${entd.tpdt.tipoElemento == 'TX'}">
                        <c:if test="${entd.tpdt.tpht == 'T'}">
                            <input type="text" name="${fieldName}.cadena" id="${fieldName}.cadena"
                                value="${valor.cadena}" class="form-control input-sm" />
                        </c:if>
                        <c:if test="${entd.tpdt.tpht == 'TA'}">
                            <textarea name="${fieldName}.cadena" id="${fieldName}.cadena"
                                class="form-control input-sm" rows="4">${valor.cadena}</textarea>
                        </c:if>
                    </c:when>
                    <c:when test="${entd.tpdt.tipoElemento == 'FH'}">
                        <fmt:formatDate value="${valor.fecha}" pattern="${datetimePattern}"
                            var="fecha" scope="page" />

                        <div class='input-group date' id='datetimepicker_${entd.tpdt.id}'>
                            <input type='text' id="${fieldName}.fecha" name="${fieldName}.fecha"
                                class="form-control input-sm" data-format="${datetimePatternJS}"
                                value="${fecha}" /> <span class="input-group-addon"><span
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
                    <c:when test="${entd.tpdt.tipoElemento == 'FE'}">
                        <fmt:formatDate value="${valor.fecha}" pattern="${datePattern}" var="fecha"
                            scope="page" />

                        <div class='input-group date' id='datepicker_${entd.tpdt.id}'>
                            <input type='text' id="${fieldName}.fecha" name="${fieldName}.fecha"
                                class="form-control input-sm" data-format="${datePatternJS}"
                                value="${fecha}" /> <span class="input-group-addon"><span
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
                    <c:when test="${entd.tpdt.tipoElemento == 'PR'}">
                        <c:choose>
                            <c:when test="${entd.tpdt.tpht eq 'F'}">
                                <div class="input-group-sm">
                                    <input type="text" autocomplete="off"
                                        name="${fieldName}.prmtEtiqueta"
                                        id="${fieldId}_prmt_etiqueta" value="${valor.prmtEtiqueta}"
                                        class="form-control input-sm" />
                                </div>
                                <input type="hidden" name="${fieldName}.prmtId"
                                    id="${fieldId}_prmt_id" value="${valor.prmtId}" />
                                <script type="text/javascript">
                                                                                                                                    $(
                                                                                                                                            '#${fieldId}_prmt_etiqueta')
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
                                                                                                                                            '#${fieldId}_prmt_etiqueta')
                                                                                                                                            .on(
                                                                                                                                                    'typeahead:selected typeahead:autocompleted',
                                                                                                                                                    function(
                                                                                                                                                            event,
                                                                                                                                                            datum) {
                                                                                                                                                        $(
                                                                                                                                                                '#${fieldId}_prmt_id')
                                                                                                                                                                .val(
                                                                                                                                                                        datum.value);
                                                                                                                                                    });
                                                                                                                                    ;
                                                                                                                                </script>
                            </c:when>
                            <c:when test="${entd.tpdt.tpht eq 'S'}">
                                <select name="${fieldName}.prmtId" id="${fieldName}.prmtId"
                                    class="form-control input-sm">
                                    <option value="" />

                                    <c:if test="${valor.prmtId == null}">
                                        <c:forEach items="${labelValuesMap[entd.tpdt.enti.id]}"
                                            var="labelValue">
                                            <option value="${labelValue.value}">${labelValue.label}</option>
                                        </c:forEach>
                                    </c:if>
                                    <c:if test="${valor.prmtId != null}">
                                        <c:forEach items="${labelValuesMap[entd.tpdt.enti.id]}"
                                            var="labelValue">
                                            <option value="${labelValue.value}"
                                                <c:if test="${labelValue.value == valor.prmtId}">selected='selected'</c:if>>${labelValue.label}</option>
                                        </c:forEach>
                                    </c:if>
                                </select>
                            </c:when>
                            <c:otherwise>
                                <span>Dato de tipo desconocido: ${entd.tpdt.tipoElemento}</span>
                            </c:otherwise>
                        </c:choose>
                    </c:when>
                    <c:when test="${entd.tpdt.tipoElemento == 'SR'}">
                        <div class="input-group-sm">
                            <input type="text" autocomplete="off" name="${fieldName}.srvcEtiqueta"
                                id="${fieldId}_srvc_etiqueta" value="${valor.srvcEtiqueta}"
                                class="form-control input-sm" />
                        </div>
                        <input type="hidden" name="${fieldName}.srvcId" id="${fieldId}_srvc_id"
                            value="${valor.srvcId}" />
                        <script type="text/javascript">
                                                                                                    $(
                                                                                                            '#${fieldId}_srvc_etiqueta')
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
                                                                                                            '#${fieldId}_srvc_etiqueta')
                                                                                                            .on(
                                                                                                                    'typeahead:selected typeahead:autocompleted',
                                                                                                                    function(
                                                                                                                            event,
                                                                                                                            datum) {
                                                                                                                        $(
                                                                                                                                '#${fieldId}_srvc_id')
                                                                                                                                .val(
                                                                                                                                        datum.value);
                                                                                                                    });
                                                                                                    ;
                                                                                                </script>
                    </c:when>
                    <c:when test="${entd.tpdt.tipoElemento == 'CR'}">
                        <select name="${fieldName}.cadena" id="${fieldName}.cadena"
                            class="form-control input-sm">
                            <option value="" />

                            <c:if test="${valor.cadena == null}">
                                <c:forEach items="${entd.tpdt.cdrfList}" var="value">
                                    <option value="${value.valor}">${value.valor}</option>
                                </c:forEach>
                            </c:if>
                            <c:if test="${valor.cadena != null}">
                                <c:forEach items="${entd.tpdt.cdrfList}" var="value">
                                    <option value="${value.valor}"
                                        <c:if test="${value.valor == valor.cadena}">selected='selected'</c:if>>${value.valor}</option>
                                </c:forEach>
                            </c:if>
                        </select>
                    </c:when>
                    <c:otherwise>
                        <span>Dato de tipo desconocido: ${entd.tpdt.tipoElemento}</span>
                    </c:otherwise>
                </c:choose>
            </div>
        </c:if>
    </c:forEach>
</div>
