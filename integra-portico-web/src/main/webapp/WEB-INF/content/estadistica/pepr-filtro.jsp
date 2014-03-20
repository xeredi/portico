<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<title><fmt:message key="pepr.filtro" /></title>
</head>
<body>
    <fmt:message key="format.datetime" var="datetimePattern" scope="page" />

    <form action="pepr-listado.action" method="get">
        <fieldset>
            <div class="row">
                <div class="col-md-3 form-group">
                    <label for="peprCriterio.autpId"><fmt:message key="peprCriterio.autpId" /></label>
                    <select name="peprCriterio.autpId" id="peprCriterio.autpId"
                        class="form-control input-sm">
                        <option value="" />
                        <c:if test="${peprCriterio.autpId == null}">
                            <c:forEach items="${autps}" var="labelValue">
                                <option value="${labelValue.value}">${labelValue.label}</option>
                            </c:forEach>
                        </c:if>
                        <c:if test="${peprCriterio.autpId != null}">
                            <c:forEach items="${autps}" var="labelValue">
                                <option value="${labelValue.value}"
                                    ${labelValue.value == peprCriterio.autpId ? 'selected' : ''}>${labelValue.label}</option>
                            </c:forEach>
                        </c:if>
                    </select>
                </div>
                <div class="col-md-1 form-group">
                    <label for="peprCriterio.anio"><fmt:message key="peprCriterio.anio" /></label>
                    <input type="text" name="peprCriterio.anio" id="peprCriterio.anio"
                        value="${peprCriterio.anio}" class="form-control input-sm" maxlength="4" />
                </div>
                <div class="col-md-1 form-group">
                    <label for="peprCriterio.mes"><fmt:message key="peprCriterio.mes" /></label> <input
                        type="text" name="peprCriterio.mes" id="peprCriterio.mes"
                        value="${peprCriterio.mes}" class="form-control input-sm" maxlength="2" />
                </div>
            </div>
        </fieldset>
        <button type="submit" class="btn btn-primary">
            <fmt:message key="boton.buscar" />
        </button>
    </form>
</body>
</html>
