<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<fmt:message key="format.date" var="datePattern" scope="page" />
<fmt:message key="format.datetime" var="datetimePattern" scope="page" />
<fmt:message key="format.integer" var="integerPattern" scope="page" />
<fmt:message key="format.double" var="doublePattern" scope="page" />

<c:if test="${itdt == null || !itdt.filled}">
    <td>&nbsp;</td>
</c:if>

<c:if test="${itdt != null && itdt.filled}">
    <c:choose>
        <c:when test="${entd.tpdt.tipoElemento == 'BO'}">
            <td><c:if test="${itdt.booleano}">
                    <i class="glyphicon glyphicon-ok"></i>
                </c:if></td>
        </c:when>
        <c:when test="${entd.tpdt.tipoElemento == 'ND'}">
            <td><span class="pull-right"><fmt:formatNumber pattern="${doublePattern}"
                        value="${itdt.cantidadDecimal}" /></span></td>
        </c:when>
        <c:when test="${entd.tpdt.tipoElemento == 'NE'}">
            <td><span class="pull-right"><fmt:formatNumber pattern="${integerPattern}"
                        value="${itdt.cantidadEntera}" /></span></td>
        </c:when>
        <c:when test="${entd.tpdt.tipoElemento == 'CR' || entd.tpdt.tipoElemento == 'TX'}">
            <td>${itdt.cadena}</td>
        </c:when>
        <c:when test="${entd.tpdt.tipoElemento == 'PR'}">
            <td title="${itdt.prmt.etiqueta}">${itdt.prmt.parametro}</td>
        </c:when>
        <c:when test="${entd.tpdt.tipoElemento == 'SR'}">
            <td>${itdt.srvc.etiqueta}</td>
        </c:when>
        <c:when test="${entd.tpdt.tipoElemento == 'FE'}">
            <td><fmt:formatDate pattern="${datePattern}" value="${itdt.fecha}" /></td>
        </c:when>
        <c:when test="${entd.tpdt.tipoElemento == 'FH'}">
            <td><fmt:formatDate pattern="${datetimePattern}" value="${itdt.fecha}" /></td>
        </c:when>
        <c:otherwise>
            <td>Tipo Desconocido ${entd.tpdt.tipoElemento}</td>
        </c:otherwise>
    </c:choose>
</c:if>
