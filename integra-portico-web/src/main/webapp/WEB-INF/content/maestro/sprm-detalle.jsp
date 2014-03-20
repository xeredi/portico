<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<title><fmt:message key="item.detalle">
        <fmt:param value="${enti.nombre} (${item.etiqueta})" />
    </fmt:message></title>
</head>
<body>
    <fmt:message key="format.datetime" var="datetimePattern" scope="page" />
    <fmt:message key="format.date" var="datePattern" scope="page" />
    <fmt:message key="format.integer" var="integerPattern" scope="page" />
    <fmt:message key="format.double" var="doublePattern" scope="page" />

    <div class="btn-toolbar" role="toolbar">
        <div class="btn-group">
            <a class="btn btn-default"
                href="${pageContext.request.contextPath}/maestro/sprm-modificar-popup.action?item.id=${item.id}"
                role="button" data-toggle="modal" data-target="#sprm-modificar-div"><i
                class="glyphicon glyphicon-edit"></i> <fmt:message key="boton.modificar" /></a>

            <c:if test="${enti.cmdDuplicado}">
                <a class="btn btn-default"
                    href="${pageContext.request.contextPath}/maestro/sprm-duplicar-popup.action?item.id=${item.id}"
                    role="button" data-toggle="modal" data-target="#sprm-duplicar-div"><i
                    class="glyphicon glyphicon-tags"></i> <fmt:message key="boton.duplicar" /></a>
            </c:if>
        </div>
    </div>

    <div class="modal" id="sprm-modificar-div" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content"></div>
        </div>
    </div>
    <div class="modal" id="sprm-duplicar-div" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content"></div>
        </div>
    </div>

    <fieldset>
        <div class="row">
            <div class="col-md-3 form-group">
                <label>${enti.tpprAsociado.nombre}</label> <input type="text"
                    value="${item.prmtAsociado.etiqueta}" class="form-control input-sm"
                    disabled="disabled" />
            </div>

            <c:if test="${enti.tempExp}">
                <div class="col-md-2 form-group">
                    <label><fmt:message key="sprm.finicio" /></label>
                    <fmt:formatDate value="${item.spvr.finicio}" pattern="${datetimePattern}"
                        var="fechaString" />
                    <input type="text" value="${fechaString}" class="form-control input-sm"
                        disabled="disabled" />
                </div>

                <div class="col-md-2 form-group">
                    <label><fmt:message key="sprm.ffin" /></label>
                    <fmt:formatDate value="${item.spvr.ffin}" pattern="${datetimePattern}"
                        var="fechaString" />
                    <input type="text" value="${fechaString}" class="form-control input-sm"
                        disabled="disabled" />
                </div>
            </c:if>
        </div>

        <jsp:include page="/WEB-INF/content/include/item/item-detalle.jsp" flush="true">
            <jsp:param value="true" name="btnOn" />
        </jsp:include>
    </fieldset>
</body>
</html>
