<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<title><fmt:message key="tpdt-${accion}.title" /></title>
</head>
<body>
    <fmt:message key="format.datetime" var="datetimePattern" scope="page" />

    <form action="tpdt-guardar.action" method="post">
        <fieldset>
            <input type="hidden" name="tpdt.id" value="${tpdt.id}" /> <input type="hidden"
                name="accion" value="${accion}" />

            <div class="row">
                <div class="col-md-4 form-group">
                    <label><fmt:message key="tpdt.codigo" /></label> <input
                        type="text" name="tpdt.codigo" id="tpdt.codigo" value="${tpdt.codigo}"
                        class="form-control input-sm" required="required"
                        <c:if test="${accion == 'modificar'}">disabled="disabled"</c:if> />
                </div>
                <div class="col-md-6 form-group">
                    <label><fmt:message key="tpdt.nombre" /></label> <input
                        type="text" name="tpdt.nombre" id="tpdt.nombre" value="${tpdt.nombre}"
                        class="form-control input-sm" required="required"
                        <c:if test="${accion == 'modificar'}">disabled="disabled"</c:if> />
                </div>
            </div>
            <div class="row">
                <div class="col-md-3 form-group">
                    <label><fmt:message key="tpdt.tipoElemento" /></label>
                    <select name="tpdt.tipoElemento" id="tpdt.tipoElemento"
                        class="form-control input-sm">
                        <option value="" />

                        <c:forEach items="${tiposElemento}" var="item">
                            <option value="${item}"
                                <c:if test="${item == tpdt.tipoElemento}">selected="selected"</c:if>>${item}
                                -
                                <fmt:message key="TipoElemento.${item}" /></option>
                        </c:forEach>
                    </select>
                </div>
                <div class="col-md-3 form-group">
                    <label><fmt:message key="tpdt.tpht" /></label> <select
                        name="tpdt.tpht" id="tpdt.tpht" class="form-control input-sm">
                        <option value="" />

                        <c:forEach items="${tphts}" var="item">
                            <option value="${item}"
                                <c:if test="${item == tpdt.tpht}">selected="selected"</c:if>>${item}
                                -
                                <fmt:message key="TipoHtml.${item}" /></option>
                        </c:forEach>
                    </select>
                </div>
                <div class="col-md-4 form-group">
                    <label><fmt:message key="tpdt.enti.id" /></label> <select
                        name="tpdt.enti.id" id="tpdt.enti.id" class="form-control input-sm">
                        <option value="" />

                        <c:forEach items="${entis}" var="item">
                            <option value="${item.value}"
                                <c:if test="${item.value == tpdt.enti.id}">selected="selected"</c:if>>${item.label}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
        </fieldset>

        <button type="submit" class="btn btn-primary">
            <fmt:message key="boton.guardar" />
        </button>
    </form>
</body>
</html>
