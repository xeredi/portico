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
    <fmt:message key="format.datetime" var="datetimePattern" scope="page" />

    <form action="estd-listado.action" method="get">
        <fieldset>
            <input type="hidden" name="itemCriterio.entiId" value="${enti.id}" />

            <div class="row">
                <div class="col-md-3 form-group">
                    <label><fmt:message key="estdCriterio.pepr.autpId" /></label> <select
                        name="itemCriterio.pepr.autpId" id="itemCriterio.pepr.autpId"
                        class="form-control input-sm">
                        <option value="" />
                        <c:if test="${itemCriterio.pepr.autpId == null}">
                            <c:forEach items="${autpList}" var="labelValue">
                                <option value="${labelValue.value}">${labelValue.label}</option>
                            </c:forEach>
                        </c:if>
                        <c:if test="${itemCriterio.pepr.autpId != null}">
                            <c:forEach items="${autps}" var="labelValue">
                                <option value="${labelValue.value}"
                                    ${labelValue.value == itemCriterio.pepr.autpId ? 'selected' : ''}>${labelValue.label}</option>
                            </c:forEach>
                        </c:if>
                    </select>
                </div>
                <div class="col-md-1 form-group">
                    <label><fmt:message key="estdCriterio.pepr.anio" /></label> <input type="text"
                        name="itemCriterio.pepr.anio" id="itemCriterio.pepr.anio"
                        value="${itemCriterio.pepr.anio}" class="form-control input-sm"
                        maxlength="4" />
                </div>
                <div class="col-md-1 form-group">
                    <label><fmt:message key="estdCriterio.pepr.mes" /></label> <input type="text"
                        name="itemCriterio.pepr.mes" id="itemCriterio.pepr.mes"
                        value="${itemCriterio.pepr.mes}" class="form-control input-sm" maxlength="2" />
                </div>

                <div class="col-md-2 form-group pull-right">
                    <label><fmt:message key="limit" /></label> <select name="limit" id="limit"
                        class="form-control input-sm">
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
