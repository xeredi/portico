<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<title><fmt:message key="item.filtro">
        <fmt:param value="${enti.nombre}" />
    </fmt:message></title>
</head>
<body>
    <form action="ssrv-listado.action" method="get">
        <fmt:message key="format.datetime" var="datetimePattern" scope="page" />
        <fieldset>
            <input type="hidden" name="itemCriterio.entiId" value="${enti.id}" />

            <div class="row">
                <div class="col-md-2 form-group">
                    <label><fmt:message key="ssrvCriterio.srvc" /></label>
                    <div class="input-group-sm">
                        <input type="text" autocomplete="off" name="itemCriterio.srvc.etiqueta"
                            id="itemCriterio_srvc_etiqueta" value="${itemCriterio.srvc.etiqueta}"
                            class="form-control input-sm" />
                    </div>
                    <input type="hidden" name="itemCriterio.srvc.id" id="itemCriterio_srvc_id"
                        value="${itemCriterio.srvc.id}" />
                    <script type="text/javascript">
																					$(
																							'#itemCriterio_srvc_etiqueta')
																							.typeahead(
																									[ {
																										name : 'itemCriterio_lupa',
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
																							'#itemCriterio_srvc_etiqueta')
																							.on(
																									'typeahead:selected typeahead:autocompleted',
																									function(
																											event,
																											datum) {
																										$(
																												'#itemCriterio_srvc_id')
																												.val(
																														datum.value);
																									});
																					;
																				</script>
                </div>
                <div class="col-md-1 form-group">
                    <label><fmt:message key="ssrvCriterio.numero" /></label> <input type="text"
                        name="itemCriterio.numero" id="itemCriterio.numero"
                        value="${itemCriterio.numero}" class="form-control input-sm" />
                </div>

                <c:if test="${not empty enti.tpdtEstado}">
                    <div class="col-md-2 form-group">
                        <label><fmt:message key="ssrvCriterio.estado" /></label> <select
                            name="itemCriterio.estado" id="itemCriterio.estado"
                            class="form-control input-sm">
                            <option value="" />

                            <c:forEach items="${enti.tpdtEstado.cdrfList}" var="item">
                                <option value="${item.valor}"
                                    <c:if test="${item.valor eq itemCriterio.estado}">selected="selected"</c:if>>${item.valor}</option>
                            </c:forEach>
                        </select>
                    </div>
                </c:if>

                <div class="col-md-2 form-group pull-right">
                    <label for="limit"><fmt:message key="limit" /></label> <select name="limit"
                        id="limit" class="form-control input-sm">
                        <c:forEach items="${limits}" var="value">
                            <option class="pull-right" value="${value}"
                                <c:if test="${value == limit}">selected="selected"</c:if>>${value}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>

            <jsp:include page="/WEB-INF/content/include/item/item-filtro.jsp" flush="true" />
        </fieldset>
        <button type="submit" class="btn btn-primary">
            <fmt:message key="boton.buscar" />
        </button>
    </form>
</body>
</html>
