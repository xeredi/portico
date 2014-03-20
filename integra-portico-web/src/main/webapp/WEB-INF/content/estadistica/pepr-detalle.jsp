<%@ page language="java" trimDirectiveWhitespaces="true"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<title><fmt:message key="pepr-detalle.title" /></title>
</head>
<body>
    <fmt:message key="format.datetime" var="datetimePattern" scope="page" />

    <fieldset>
        <legend></legend>

        <div class="row">
            <div class="col-md-2 form-group">
                <label for="pepr.autp.parametro"><fmt:message key="pepr.autp.parametro" /></label>
                <input type="text" value="${pepr.autp.parametro}" class="form-control input-sm"
                    disabled="disabled" />
            </div>
            <div class="col-md-1 form-group">
                <label for="pepr.anio"><fmt:message key="pepr.anio" /></label> <input type="text"
                    value="${pepr.anio}" class="form-control input-sm" disabled="disabled" />
            </div>
            <div class="col-md-1 form-group">
                <label for="pepr.mes"><fmt:message key="pepr.mes" /></label> <input type="text"
                    value="${pepr.mes}" class="form-control input-sm" disabled="disabled" />
            </div>
            <div class="col-md-1 form-group">
                <label><fmt:message key="pepr.cdmsGenerado" /></label>
                <fmt:message key="boolean.${pepr.cdmsGenerado}" var="booleanString" />
                <input type="text" value="${booleanString}" class="form-control input-sm"
                    disabled="disabled" />
            </div>
        </div>
    </fieldset>

    <ul class="list-group">
        <li class="list-group-item"><a href="cdms-detalle.action?pepr.id=${pepr.id}">Cuadro
                Mensual</a></li>
        <c:forEach items="${tpess}" var="enti">
            <li class="list-group-item"><a
                href="estd-listado.action?itemCriterio.pepr.id=${pepr.id}&itemCriterio.entiId=${enti.value}">${enti.label}</a>
            </li>
        </c:forEach>
    </ul>
</body>
</html>
