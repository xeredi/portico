<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<title><fmt:message key="tppr-${accion}.title" /></title>
</head>
<body>
    <fmt:message key="format.datetime" var="datetimePattern" scope="page" />

    <form action="tppr-guardar.action" method="post">
        <fieldset>
            <input type="hidden" name="tppr.id" value="${tppr.id}" /> <input type="hidden"
                name="accion" value="${accion}" />

            <div class="row">
                <div class="col-md-4 form-group">
                    <label class="control-label" for="tppr.codigo"><fmt:message
                            key="enti.codigo" /></label> <input type="text" name="tppr.codigo"
                        id="tppr.codigo" value="${tppr.codigo}" class="form-control input-sm"
                        required="required" maxlength="4"
                        <c:if test="${accion == 'modificar'}">disabled="disabled"</c:if> />
                </div>
                <div class="col-md-7 form-group">
                    <label class="control-label" for="tppr.nombre"><fmt:message
                            key="enti.nombre" /></label> <input type="text" name="tppr.nombre"
                        id="tppr.nombre" value="${tppr.nombre}" class="form-control input-sm"
                        required="required" maxlength="50"
                        <c:if test="${accion == 'modificar'}">disabled="disabled"</c:if> />
                </div>
            </div>

            <div class="row">
                <div class="col-md-2 form-group">
                    <label class="checkbox"> <input type="checkbox" name="tppr.cmdAlta"
                        id="tppr.cmdAlta" value="true"
                        <c:if test="${tppr.cmdAlta}">checked="checked"</c:if> /> <fmt:message
                            key="enti.cmdAlta" />
                    </label>
                </div>
                <div class="col-md-2 form-group">
                    <label class="checkbox"> <input type="checkbox" name="tppr.cmdBaja"
                        id="tppr.cmdBaja" value="true"
                        <c:if test="${tppr.cmdBaja}">checked="checked"</c:if> /> <fmt:message
                            key="enti.cmdBaja" />
                    </label>
                </div>
                <div class="col-md-2 form-group">
                    <label class="checkbox"> <input type="checkbox" name="tppr.cmdEdicion"
                        id="tppr.cmdAlta" value="true"
                        <c:if test="${tppr.cmdEdicion}">checked="checked"</c:if> /> <fmt:message
                            key="enti.cmdEdicion" />
                    </label>
                </div>
                <div class="col-md-2 form-group">
                    <label class="checkbox"> <input type="checkbox" name="tppr.cmdDuplicado"
                        id="tppr.cmdDuplicado" value="true"
                        <c:if test="${tppr.cmdDuplicado}">checked="checked"</c:if> /> <fmt:message
                            key="enti.cmdDuplicado" />
                    </label>
                </div>
                <div class="col-md-2 form-group">
                    <label class="checkbox"> <input type="checkbox" name="tppr.i18n"
                        id="tppr.i18n" value="true"
                        <c:if test="${tppr.i18n}">checked="checked"</c:if> /> <fmt:message
                            key="tppr.i18n" />
                    </label>
                </div>
                <div class="col-md-2 form-group">
                    <label class="checkbox"> <input type="checkbox" name="tppr.tempExp"
                        id="tppr.tempExp" value="true"
                        <c:if test="${tppr.tempExp}">checked="checked"</c:if> /> <fmt:message
                            key="tppr.tempExp" />
                    </label>
                </div>
            </div>
        </fieldset>

        <button type="submit" class="btn btn-primary">
            <fmt:message key="boton.guardar" />
        </button>
    </form>
</body>
</html>
