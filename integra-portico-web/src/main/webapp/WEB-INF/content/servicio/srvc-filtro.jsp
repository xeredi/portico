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
    <form action="srvc-listado.action" method="get">
        <fmt:message key="format.datetime" var="datetimePattern" scope="page" />
        <fieldset>
            <input type="hidden" name="itemCriterio.entiId" value="${enti.id}" />

            <div class="row">
                <div class="col-md-3 form-group">
                    <label><fmt:message key="srvcCriterio.subpId" /></label> <select
                        id="itemCriterio.subpId" name="itemCriterio.subpId"
                        class="form-control input-sm">
                        <option value="" />

                        <c:if test="${empty itemCriterio.subpId}">
                            <c:forEach items="${subpList}" var="labelValue">
                                <option value="${labelValue.value}">${labelValue.label}</option>
                            </c:forEach>
                        </c:if>
                        <c:if test="${not empty itemCriterio.subpId}">
                            <c:forEach items="${subpList}" var="labelValue">
                                <option value="${labelValue.value}"
                                    <c:if test="${labelValue.value eq itemCriterio.subpId}">selected</c:if>>${labelValue.label}</option>
                            </c:forEach>
                        </c:if>
                    </select>
                </div>
                <div class="col-md-1 form-group">
                    <label><fmt:message key="srvcCriterio.anno" /></label> <input type="text"
                        name="itemCriterio.anno" id="itemCriterio.anno" value="${itemCriterio.anno}"
                        class="form-control input-sm" />
                </div>
                <div class="col-md-1 form-group">
                    <label><fmt:message key="srvcCriterio.numero" /></label> <input type="text"
                        name="itemCriterio.numero" id="itemCriterio.numero"
                        value="${itemCriterio.numero}" class="form-control input-sm" />
                </div>

                <c:if test="${not empty enti.tpdtEstado}">
                    <div class="col-md-2 form-group">
                        <label><fmt:message key="srvcCriterio.estado" /></label> <select
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
