<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<title><fmt:message key="prbt.filtro" /></title>
</head>
<body>
    <form action="prbt-listado.action" method="get">
        <fmt:message key="format.datetime" var="datetimePattern" scope="page" />

        <fieldset>
            <div class="row">
                <div class="col-md-4 form-group">
                    <label for="prbtCriterio.modulo"><fmt:message key="prbtCriterio.modulo" /></label>
                    <select name="prbtCriterio.modulo" id="prbtCriterio.modulo"
                        class="form-control input-sm">
                        <option value="" />

                        <c:if test="${prbtCriterio.modulo == null}">
                            <c:forEach items="${procesoModulos}" var="item">
                                <option value="${item}">${item}</option>
                            </c:forEach>
                        </c:if>
                        <c:if test="${prbtCriterio.modulo != null}">
                            <c:forEach items="${procesoModulos}" var="item">
                                <option value="${item}"
                                    <c:if test="${item == prbtCriterio.modulo}">selected='selected'</c:if>>${item}</option>
                            </c:forEach>
                        </c:if>
                    </select>
                </div>
                <div class="col-md-4 form-group">
                    <label for="prbtCriterio.tipo"><fmt:message key="prbtCriterio.tipo" /></label>
                    <select name="prbtCriterio.tipo" id="prbtCriterio.tipo"
                        class="form-control input-sm">
                        <option value="" />

                        <c:if test="${prbtCriterio.tipo == null}">
                            <c:forEach items="${procesoTipos}" var="item">
                                <option value="${item}">${item}</option>
                            </c:forEach>
                        </c:if>
                        <c:if test="${prbtCriterio.tipo != null}">
                            <c:forEach items="${procesoTipos}" var="item">
                                <option value="${item}"
                                    <c:if test="${item == prbtCriterio.tipo}">selected='selected'</c:if>>${item}</option>
                            </c:forEach>
                        </c:if>
                    </select>
                </div>
                <div class="col-md-4 form-group">
                    <label for="prbtCriterio.estado"><fmt:message key="prbtCriterio.estado" /></label>
                    <select name="prbtCriterio.estado" id="prbtCriterio.estado"
                        class="form-control input-sm">
                        <option value="" />

                        <c:if test="${prbtCriterio.estado == null}">
                            <c:forEach items="${procesoEstados}" var="item">
                                <option value="${item}">${item}</option>
                            </c:forEach>
                        </c:if>
                        <c:if test="${prbtCriterio.estado != null}">
                            <c:forEach items="${procesoEstados}" var="item">
                                <option value="${item}"
                                    <c:if test="${item == prbtCriterio.estado}">selected='selected'</c:if>>${item}</option>
                            </c:forEach>
                        </c:if>
                    </select>
                </div>
            </div>
        </fieldset>
        <button type="submit" class="btn btn-primary">
            <fmt:message key="boton.buscar" />
        </button>
    </form>
</body>
</html>