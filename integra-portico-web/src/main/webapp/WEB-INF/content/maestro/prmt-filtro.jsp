<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<title><fmt:message key="prmt.filtro">
        <fmt:param value="${enti.nombre}" />
    </fmt:message></title>
</head>
<body>
    <form action="prmt-listado.action" method="get">
        <fmt:message key="format.date" var="datePattern" scope="page" />
        <fmt:message key="format.datetime" var="datetimePattern" scope="page" />
        <fmt:message key="format.datetime.js" var="datetimePatternJS" scope="page" />
        <fmt:message key="format.date.js" var="datePatternJS" scope="page" />

        <fieldset>
            <input type="hidden" name="itemCriterio.entiId" value="${enti.id}" />

            <div class="row">
                <div class="col-md-2 form-group">
                    <label><fmt:message
                            key="prmtCriterio.parametro" /></label> <input type="text"
                        name="itemCriterio.parametro" id="itemCriterio.parametro"
                        value="${itemCriterio.parametro}" class="form-control input-sm" />
                </div>

                <fmt:formatDate value="${itemCriterio.fechaVigencia}" pattern="${datePattern}"
                    var="fechaVigencia" scope="page" />

                <div class="col-md-2 form-group">
                    <label><fmt:message
                            key="prmtCriterio.fechaVigencia" /></label>
                    <div class='input-group date' id='datepickerFVigencia'>
                        <input type='text' id="itemCriterio.fechaVigencia"
                            name="itemCriterio.fechaVigencia" class="form-control input-sm"
                            data-format="${datePatternJS}" value="${fechaVigencia}" /> <span
                            class="input-group-addon"><span
                            class="glyphicon glyphicon-calendar"></span> </span>
                    </div>
                </div>
                <script type="text/javascript">
                                                                    $(function() {
                                                                        $(
                                                                                '#datepickerFVigencia')
                                                                                .datetimepicker(
                                                                                        {
                                                                                            pickTime : false
                                                                                        });
                                                                    });
                                                                </script>

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
