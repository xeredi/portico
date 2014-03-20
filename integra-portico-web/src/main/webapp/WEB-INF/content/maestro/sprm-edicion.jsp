<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>

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

    <form action="sprm-guardar.action" method="post">
        <fieldset>
            <input type="hidden" name="item.entiId" value="${item.entiId}" /> <input type="hidden"
                name="item.spvr.id" value="${item.spvr.id}" /> <input type="hidden" name="item.id"
                value="${item.id}" /> <input type="hidden" name="item.prmtId"
                value="${item.prmtId}" /> <input type="hidden" name="accion" value="${accion}" />
            <div class="row">
                <div class="col-md-3 form-group">
                    <label>${enti.tpprAsociado.nombre}</label> <select id="item.prmtAsociado.id"
                        name="item.prmtAsociado.id" class="form-control input-sm"
                        required="required">
                        <option />
                        <c:forEach items="${prmtAsociadoList}" var="labelValue">
                            <option value="${labelValue.value}"
                                <c:if test="${labelValue.value eq item.prmtAsociado.id}">selected="selected"</c:if>>${labelValue.label}</option>
                        </c:forEach>
                    </select>
                </div>

                <c:if test="${enti.tempExp}">
                    <div class="col-md-2 form-group">
                        <fmt:formatDate value="${item.spvr.finicio}" pattern="${datePattern}"
                            var="fechaString" />
                        <label><fmt:message key="sprm.spvr.finicio" /></label>
                        <div class='input-group date' id='datepickerFinicio'>
                            <input type='text' class="form-control input-sm" id="item.spvr.finicio"
                                name="item.spvr.finicio" value="${fechaString}"
                                data-format="${datePatternJS}" required="required" /> <span
                                class="input-group-addon"><span
                                class="glyphicon glyphicon-calendar"></span> </span>
                        </div>
                    </div>

                    <div class="col-md-2 form-group">
                        <fmt:formatDate value="${item.spvr.ffin}" pattern="${datePattern}"
                            var="fechaString" />
                        <label><fmt:message key="sprm.spvr.ffin" /></label>
                        <div class='input-group date' id='datepickerFfin'>
                            <input type='text' class="form-control input-sm" id="item.spvr.ffin"
                                name="item.spvr.ffin" value="${fechaString}"
                                data-format="${datePatternJS}" /> <span class="input-group-addon"><span
                                class="glyphicon glyphicon-calendar"></span> </span>
                        </div>
                    </div>

                    <script type="text/javascript">
																					$(function() {
																						$(
																								'#datepickerFinicio')
																								.datetimepicker(
																										{
																											pickTime : false
																										});
																					});
																					$(function() {
																						$(
																								'#datepickerFfin')
																								.datetimepicker(
																										{
																											pickTime : false
																										});
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
