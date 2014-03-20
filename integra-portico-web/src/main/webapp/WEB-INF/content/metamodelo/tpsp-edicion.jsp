<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<title><fmt:message key="tpsp-${accion}.title" /></title>
</head>
<body>
    <fmt:message key="format.datetime" var="datetimePattern" scope="page" />

    <form action="tpsp-guardar.action" method="post">
        <fieldset>
            <input type="hidden" name="tpsp.id" value="${tpsp.id}" /> <input type="hidden"
                name="accion" value="${accion}" /><input type="hidden" name="tpsp.tppr.id"
                value="${tpsp.tppr.id}" />

            <div class="row">
                <div class="col-md-4 form-group">
                    <label><fmt:message key="enti.codigo" /></label> <input type="text"
                        name="tpsp.codigo" id="tpsp.codigo" value="${tpsp.codigo}"
                        class="form-control input-sm" required="required" maxlength="4"
                        <c:if test="${accion == 'modificar'}">disabled="disabled"</c:if> />
                </div>
                <div class="col-md-7 form-group">
                    <label><fmt:message key="enti.nombre" /></label> <input type="text"
                        name="tpsp.nombre" id="tpsp.nombre" value="${tpsp.nombre}"
                        class="form-control input-sm" required="required" maxlength="50"
                        <c:if test="${accion == 'modificar'}">disabled="disabled"</c:if> />
                </div>
            </div>

            <div class="row">
                <div class="col-md-2 form-group">
                    <label class="checkbox"> <input type="checkbox" name="tpsp.cmdAlta"
                        id="tpsp.cmdAlta" value="true"
                        <c:if test="${tpsp.cmdAlta}">checked="checked"</c:if> /> <fmt:message
                            key="enti.cmdAlta" />
                    </label>
                </div>
                <div class="col-md-2 form-group">
                    <label class="checkbox"> <input type="checkbox" name="tpsp.cmdBaja"
                        id="tpsp.cmdBaja" value="true"
                        <c:if test="${tpsp.cmdBaja}">checked="checked"</c:if> /> <fmt:message
                            key="enti.cmdBaja" />
                    </label>
                </div>
                <div class="col-md-2 form-group">
                    <label class="checkbox"> <input type="checkbox" name="tpsp.cmdEdicion"
                        id="tpsp.cmdEdicion" value="true"
                        <c:if test="${tpsp.cmdEdicion}">checked="checked"</c:if> /> <fmt:message
                            key="enti.cmdEdicion" />
                    </label>
                </div>
                <div class="col-md-2 form-group">
                    <label class="checkbox"> <input type="checkbox" name="tpsp.cmdDuplicado"
                        id="tpsp.cmdDuplicado" value="true"
                        <c:if test="${tpsp.cmdDuplicado}">checked="checked"</c:if> /> <fmt:message
                            key="enti.cmdDuplicado" />
                    </label>
                </div>
                <div class="col-md-2 form-group">
                    <label class="checkbox"> <input type="checkbox" name="tpsp.i18n"
                        id="tpsp.i18n" value="true"
                        <c:if test="${tpsp.i18n}">checked="checked"</c:if> /> <fmt:message
                            key="tpsp.i18n" />
                    </label>
                </div>
                <div class="col-md-2 form-group">
                    <label class="checkbox"> <input type="checkbox" name="tpsp.tempExp"
                        id="tpsp.tempExp" value="true"
                        <c:if test="${tpsp.tempExp}">checked="checked"</c:if> /> <fmt:message
                            key="tpsp.tempExp" />
                    </label>
                </div>
            </div>

            <div class="row">
                <div class="col-md-4 form-group">
                    <label><fmt:message key="tpsp.tpprAsociado.id" /></label> <select
                        name="tpsp.tpprAsociado.id" id="tpsp.tpprAsociado.id"
                        class="form-control input-sm">
                        <option value="" />

                        <c:forEach items="${tpprs}" var="item">
                            <option value="${item.value}"
                                <c:if test="${item.value == tpsp.tpprAsociado.id}">selected="selected"</c:if>>${item.label}</option>
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
