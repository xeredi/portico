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

    <form action="srvc-guardar.action" method="post">
        <fieldset>
            <input type="hidden" name="item.entiId" value="${item.entiId}" /> <input type="hidden"
                name="item.id" value="${item.id}" /> <input type="hidden" name="accion"
                value="${accion}" />

            <div class="row">
                <div class="col-md-3 form-group">
                    <label for="item.subp.id"><fmt:message key="srvc.subp.id" /></label>
                    <c:if test="${accion eq 'modificar'}">
                        <input type="hidden" name="item.subp.id" id="item.subp.id"
                            value="${item.subp.id}" />
                        <input type="text" name="item.subp.parametro" id="item.subp.parametro"
                            value="${item.subp.etiqueta}" class="form-control input-sm"
                            disabled="disabled" />
                    </c:if>
                    <c:if test="${accion ne 'modificar'}">
                        <select name="item.subp.id" id="item.subp.id" class="form-control input-sm" required="required">
                            <option value="" />

                            <c:forEach items="${subpList}" var="labelValue">
                                <option value="${labelValue.value}"
                                    <c:if test="${labelValue.value eq item.subp.id}">selected="selected"</c:if>>${labelValue.label}</option>
                            </c:forEach>
                        </select>
                    </c:if>
                </div>

                <div class="col-md-1 form-group">
                    <label><fmt:message key="srvc.anno" /></label> <input type="text"
                        name="item.anno" id="item.anno" value="${item.anno}"
                        class="form-control input-sm" required="required" maxlength="4"
                        <c:if test="${accion eq 'modificar'}">disabled="disabled"</c:if> />
                </div>
                <div class="col-md-1 form-group">
                    <label><fmt:message key="srvc.numero" /></label> <input type="text"
                        name="item.numero" id="item.numero" value="${item.numero}"
                        class="form-control input-sm" required="required" maxlength="5"
                        <c:if test="${accion eq 'modificar'}">disabled="disabled"</c:if> />
                </div>

                <c:if test="${not empty enti.tpdtEstado}">
                    <div class="col-md-2 form-group">
                        <label><fmt:message key="srvc.estado" /></label> <select name="item.estado"
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
                        <label><fmt:message key="srvc.finicio" /></label>
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
                        <label><fmt:message key="srvc.ffin" /></label>
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
                                                                                    });
                                                                                    $(function() {
                                                                                        $(
                                                                                                '#datetimepickerFfin')
                                                                                                .datetimepicker();
                                                                                    });
                                                                                </script>
                </c:if>

                <c:if test="${not enti.temporal}">
                    <div class="col-md-2 form-group">
                        <fmt:formatDate value="${item.freferencia}" pattern="${datetimePattern}"
                            var="fechaString" />
                        <label><fmt:message key="srvc.freferencia" /></label>
                        <div class='input-group date' id='datetimepickerFreferencia'>
                            <input type='text' id="item.freferencia" name="item.freferencia"
                                class="form-control input-sm" data-format="${datetimePatternJS}"
                                value="${fechaString}" /> <span class="input-group-addon"><span
                                class="glyphicon glyphicon-calendar"></span> </span>
                        </div>
                    </div>

                    <script type="text/javascript">
                                                                                    $(function() {
                                                                                        $(
                                                                                                '#datetimepickerFreferencia')
                                                                                                .datetimepicker();
                                                                                    });
                                                                                </script>
                </c:if>
            </div>

            <jsp:include page="/WEB-INF/content/include/item/item-edicion.jsp" flush="true" />
        </fieldset>

        <div class="controls">
            <button type="submit" class="btn btn-primary">
                <i class="glyphicon glyphicon-ok"></i>
                <fmt:message key="boton.guardar" />
            </button>
        </div>
    </form>
</body>
</html>
