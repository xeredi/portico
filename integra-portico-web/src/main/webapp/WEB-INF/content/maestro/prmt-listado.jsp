<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<title><fmt:message key="item.listado">
        <fmt:param value="${enti.nombre}" />
    </fmt:message></title>
</head>
<body>
    <fmt:message key="format.datetime" var="datetimePattern" scope="page" />
    <fmt:message key="format.date" var="datePattern" scope="page" />
    <fmt:message key="format.integer" var="integerPattern" scope="page" />
    <fmt:message key="format.double" var="doublePattern" scope="page" />

    <div class="btn-toolbar" role="toolbar">
        <div class="btn-group">
            <a class="btn btn-default" href="tppr-listado.action"><i
                class="glyphicon glyphicon-home"></i> <fmt:message key="boton.volver" /></a>
            <c:url value="prmt-filtro-popup.action" var="urlFiltro">
                <c:forEach items="${itemCriterio.searchLinks}" var="mapEntry">
                    <c:param name="itemCriterio.${mapEntry.key}" value="${mapEntry.value}" />
                </c:forEach>
                <c:param name="limit" value="${limit}" />
            </c:url>
            <a class="btn btn-default" href="${urlFiltro}" role="button" data-toggle="modal"
                data-target="#prmt-filtro-div"><i class="glyphicon glyphicon-filter"></i> <fmt:message
                    key="boton.filtro" /></a>
            <c:url value="prmt-xls-export.action" var="urlExportarFiltro">
                <c:forEach items="${itemCriterio.searchLinks}" var="mapEntry">
                    <c:param name="itemCriterio.${mapEntry.key}" value="${mapEntry.value}" />
                </c:forEach>
            </c:url>
            <a class="btn btn-default" href="${urlExportarFiltro}"><i
                class="glyphicon glyphicon-book"></i> <fmt:message key="boton.exportar" /></a>

            <div class="modal" id="prmt-filtro-div" tabindex="-1" role="dialog" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content"></div>
                </div>
            </div>
        </div>

        <div class="btn-group">
            <c:if test="${enti.cmdAlta}">
                <a class="btn btn-default" href="prmt-alta-popup.action?item.entiId=${enti.id}"
                    role="button" data-toggle="modal" data-target="#prmt-alta-div"><i
                    class="glyphicon glyphicon-file"></i> <fmt:message key="boton.alta" /></a>
                <div class="modal" id="prmt-alta-div" tabindex="-1" role="dialog" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content"></div>
                    </div>
                </div>
            </c:if>
            <c:if test="${enti.cmdEdicion}">
                <a class="btn btn-default" href="prmt-modificar-popup.action" role="button"
                    data-toggle="modal" data-target="#prmt-modificar-div"><i
                    class="glyphicon glyphicon-edit"></i> <fmt:message key="boton.modificar" /></a>
                <div class="modal" id="prmt-modificar-div" tabindex="-1" role="dialog"
                    aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content"></div>
                    </div>
                </div>
            </c:if>
            <c:if test="${enti.cmdDuplicado}">
                <a class="btn btn-default" href="prmt-duplicar-popup.action" role="button"
                    data-toggle="modal" data-target="#prmt-duplicar-div"><i
                    class="glyphicon glyphicon-tags"></i> <fmt:message key="boton.duplicar" /></a>
                <div class="modal" id="prmt-duplicar-div" tabindex="-1" role="dialog"
                    aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content"></div>
                    </div>
                </div>
            </c:if>
            <c:if test="${enti.cmdBaja}">
                <a class="btn btn-default" href="prmt-borrar-popup.action" role="button"
                    data-toggle="modal" data-target="#prmt-borrar-div"><i
                    class="glyphicon glyphicon-remove"></i> <fmt:message key="boton.borrar" /></a>
                <div class="modal" id="prmt-borrar-div" tabindex="-1" role="dialog"
                    aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content"></div>
                    </div>
                </div>
            </c:if>
        </div>
    </div>

    <div id="prmt-listado-grid">
        <jsp:include page="prmt-listado-grid.jsp" flush="true" />
    </div>
</body>
</html>
