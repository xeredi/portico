<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<title><fmt:message key="item.detalle">
        <fmt:param value="${enti.nombre}" />
    </fmt:message></title>
</head>
<body>
    <fmt:message key="format.datetime" var="datetimePattern" scope="page" />
    <fmt:message key="format.date" var="datePattern" scope="page" />

    <fieldset>
        <div class="row">
            <div class="col-md-3 form-group">
                <label><fmt:message key="estd.pepr" /></label> <input type="text"
                    value="${item.pepr.etiqueta}" class="form-control input-sm" disabled="disabled" />
            </div>

            <div class="col-md-2 form-group">
                <label><fmt:message key="estd.autp" /></label> <input type="text"
                    value="${item.autp.etiqueta}" class="form-control input-sm" disabled="disabled" />
            </div>
        </div>

        <jsp:include page="/WEB-INF/content/include/item/item-detalle.jsp" flush="true">
            <jsp:param value="true" name="btnOn" />
        </jsp:include>
    </fieldset>
</body>
</html>
