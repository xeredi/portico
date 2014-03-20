<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%
    request.setAttribute("dateParam", Calendar.getInstance().getTime());
			request.setAttribute("calendarParam", Calendar.getInstance());
%>

<c:url value="test-formparam-validar.action" var="url">
    <c:param name="formCriterio.dateParam" value="23/12/2013 23:59:05.666" />
    <%--
    <c:param name="formCriterio.calendarParam" value="${calendarParam}" />
--%>

    <c:param name="formCriterio.longParam" value="25" />

    <%--
    <c:param name="formCriterio.longArrParam" value="0" />
    <c:param name="formCriterio.longArrParam" value="1" />
    <c:param name="formCriterio.longArrParam" value="2" />

    <c:param name="formCriterio.longSetParam" value="0" />
    <c:param name="formCriterio.longSetParam" value="1" />
    <c:param name="formCriterio.longSetParam" value="2" />
 --%>

    <c:param name="formCriterio.doubleParam" value="25,5" />

    <c:param name="formCriterio.stringParam" value="Hola, Caracola" />
</c:url>

<a href="${url}">Test</a>
<!-- form-control input-sm -->
<input type="hidden" name="test.InputHidden" id="prmt_itdtMap_45055__prmt_id" />
<input type="text" name="test.Input" id="prmt_itdtMap_45055__prmt_etiqueta"
    class="form-control input-sm" />
<script type="text/javascript">
	$('#prmt_itdtMap_45055__prmt_etiqueta')
			.typeahead(
					[ {
						name : 'test',
						remote : {
							url : '${pageContext.request.contextPath}/maestro/prmt-lupa.action?prmtLupaCriterio.entiId=20014&prmtLupaCriterio.fechaVigencia=31/01/2014&prmtLupaCriterio.textoBusqueda=%QUERY',
							filter : function(parsedResponse) {
								return parsedResponse.prmts;
							}
						},
						valueKey : 'label',
					// template : '<p>{{label}}</p>',
					// template : '{{label}}',
					// engine : Hogan
					} ]);
	$('#prmt_itdtMap_45055__prmt_etiqueta').on(
			'typeahead:selected typeahead:autocompleted',
			function(event, datum) {
				$('#prmt_itdtMap_45055__prmt_id').val(datum.value);
			});
	;
</script>
