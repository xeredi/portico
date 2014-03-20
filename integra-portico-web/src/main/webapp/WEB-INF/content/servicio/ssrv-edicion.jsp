<%@ page language="java" trimDirectiveWhitespaces="true"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<title><fmt:message key="item.${accion}">
        <fmt:param value="${enti.nombre}" />
    </fmt:message></title>
</head>
<body>
    <fmt:message key="format.datetime" var="datetimePattern" scope="page" />
    <fmt:message key="format.date" var="datePattern" scope="page" />
    <fmt:message key="format.datetime.js" var="datetimePatternJS" scope="page" />
    <fmt:message key="format.date.js" var="datePatternJS" scope="page" />

    <form action="ssrv-guardar.action" method="post">
        <fieldset>
            <input type="hidden" name="item.entiId" value="${item.entiId}" /> <input type="hidden"
                name="item.id" value="${item.id}" /> <input type="hidden" name="accion"
                value="${accion}" />

            <div class="row">
                <div class="col-md-2 form-group">
                    <input type="hidden" name="item.srvc.id" id="item_srvc_id"
                        value="${item.srvc.id}" /> <label><fmt:message key="ssrv.srvc" /></label>
                    <c:if test="${not empty item.srvc.id}">
                        <input type="text" value="${item.srvc.etiqueta}"
                            class="form-control input-sm" disabled="disabled" />
                    </c:if>

                    <c:if test="${empty item.srvc.id}">
                        <div class="input-group-sm">
                            <input type="text" autocomplete="off" name="item.srvc.etiqueta"
                                id="item_srvc_etiqueta" value="${item.srvc.etiqueta}"
                                class="form-control input-sm" required="required" />
                        </div>
                        <script type="text/javascript">
                                                                                                    $(
                                                                                                            '#item_srvc_etiqueta')
                                                                                                            .typeahead(
                                                                                                                    [ {
                                                                                                                        name : 'item_srvc_lupa',
                                                                                                                        remote : {
                                                                                                                            url : '${pageContext.request.contextPath}/servicio/srvc-lupa.action?itemLupaCriterio.entiId=${enti.tpsr.id}&itemLupaCriterio.textoBusqueda=%QUERY',
                                                                                                                            filter : function(
                                                                                                                                    parsedResponse) {
                                                                                                                                return parsedResponse.itemList;
                                                                                                                            }
                                                                                                                        },
                                                                                                                        valueKey : 'label',
                                                                                                                    } ]);
                                                                                                    $(
                                                                                                            '#item_srvc_etiqueta')
                                                                                                            .on(
                                                                                                                    'typeahead:selected typeahead:autocompleted',
                                                                                                                    function(
                                                                                                                            event,
                                                                                                                            datum) {
                                                                                                                        $(
                                                                                                                                '#item_srvc_id')
                                                                                                                                .val(
                                                                                                                                        datum.value);
                                                                                                                    });
                                                                                                    ;
                                                                                                </script>
                    </c:if>
                </div>

                <div class="col-md-1 form-group">
                    <label><fmt:message key="ssrv.numero" /></label> <input type="text"
                        name="item.numero" id="item.numero" value="${item.numero}"
                        class="form-control input-sm" required="required" maxlength="4"
                        <c:if test="${accion == 'modificar'}">disabled="disabled"</c:if> />
                </div>

                <c:if test="${not empty enti.tpdtEstado}">
                    <div class="col-md-2 form-group">
                        <label><fmt:message key="ssrv.estado" /></label> <select name="item.estado"
                            id="item.estado" class="form-control input-sm">
                            <option value="" />

                            <c:forEach items="${enti.tpdtEstado.cdrfList}" var="cdrf">
                                <option value="${cdrf.valor}"
                                    <c:if test="${cdrf.valor eq item.estado}">selected="selected"</c:if>>${cdrf.valor}</option>
                            </c:forEach>
                        </select>
                    </div>
                </c:if>

                <c:if test="${enti.temporal}">
                    <div class="col-md-2 form-group">
                        <fmt:formatDate value="${item.finicio}" pattern="${datetimePattern}"
                            var="fechaString" />
                        <label><fmt:message key="ssrv.finicio" /></label>
                        <div class='input-group date' id='datetimepickerFinicio'>
                            <input type='text' id="item.finicio" name="item.finicio"
                                class="form-control input-sm" data-format="${datetimePatternJS}"
                                value="${fechaString}" /> <span class="input-group-addon"><span
                                class="glyphicon glyphicon-calendar"></span> </span>
                        </div>
                    </div>
                    <div class="col-md-2 form-group">
                        <fmt:formatDate value="${item.ffin}" pattern="${datetimePattern}"
                            var="fechaString" />
                        <label><fmt:message key="ssrv.ffin" /></label>
                        <div class='input-group date' id='datetimepickerFfin'>
                            <input type='text' id="item.ffin" name="item.ffin"
                                class="form-control input-sm" data-format="${datetimePatternJS}"
                                value="${fechaString}" /> <span class="input-group-addon"><span
                                class="glyphicon glyphicon-calendar"></span> </span>
                        </div>
                    </div>
                    <script type="text/javascript">
                                                                                    $(function() {
                                                                                        $(
                                                                                                '#datetimepickerFinicio')
                                                                                                .datetimepicker();
                                                                                        $(
                                                                                                '#datetimepickerFfin')
                                                                                                .datetimepicker();
                                                                                    });
                                                                                </script>
                </c:if>
            </div>

            <jsp:include page="/WEB-INF/content/include/item/item-edicion.jsp" flush="true" />
        </fieldset>

        <button type="submit" class="btn btn-primary">
            <i class="glyphicon glyphicon-ok"></i>
            <fmt:message key="boton.guardar" />
        </button>
    </form>
</body>
</html>
