<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<title><fmt:message key="tpss-${accion}.title" /></title>
</head>
<body>
    <fmt:message key="format.datetime" var="datetimePattern" scope="page" />

    <form action="tpss-guardar.action" method="post">
        <fieldset>
            <input type="hidden" name="tpss.id" value="${tpss.id}" /> <input type="hidden"
                name="tpss.tpsr.id" value="${tpss.tpsr.id}" /> <input type="hidden" name="accion"
                value="${accion}" />

            <div class="row">
                <div class="col-md-4 form-group">
                    <label><fmt:message key="enti.codigo" /></label> <input type="text"
                        name="tpss.codigo" id="tpss.codigo" value="${tpss.codigo}"
                        class="form-control input-sm" required="required" maxlength="4"
                        <c:if test="${accion == 'modificar'}">disabled="disabled"</c:if> />
                </div>
                <div class="col-md-7 form-group">
                    <label><fmt:message key="enti.nombre" /></label> <input type="text"
                        name="tpss.nombre" id="tpss.nombre" value="${tpss.nombre}"
                        class="form-control input-sm" required="required" maxlength="50"
                        <c:if test="${accion == 'modificar'}">disabled="disabled"</c:if> />
                </div>
            </div>

            <div class="row">
                <div class="col-md-2 form-group">
                    <label class="checkbox"> <input type="checkbox" name="tpss.cmdAlta"
                        id="tpsr.cmdAlta"
                        <c:if test="${tpss.cmdAlta}">checked="checked"</c:if> value="true" /> <fmt:message
                            key="enti.cmdAlta" />
                    </label>
                </div>
                <div class="col-md-2 form-group">
                    <label class="checkbox"> <input type="checkbox" name="tpss.cmdBaja"
                        id="tpsr.cmdBaja"
                        <c:if test="${tpss.cmdBaja}">checked="checked"</c:if> value="true" /> <fmt:message
                            key="enti.cmdBaja" />
                    </label>
                </div>
                <div class="col-md-2 form-group">
                    <label class="checkbox"> <input type="checkbox" name="tpss.cmdEdicion"
                        id="tpsr.cmdEdicion"
                        <c:if test="${tpss.cmdEdicion}">checked="checked"</c:if> value="true" /> <fmt:message
                            key="enti.cmdEdicion" />
                    </label>
                </div>
                <div class="col-md-2 form-group">
                    <label class="checkbox"> <input type="checkbox" name="tpss.cmdDuplicado"
                        id="tpsr.cmdDuplicado"
                        <c:if test="${tpss.cmdDuplicado}">checked="checked"</c:if> value="true" /> <fmt:message
                            key="enti.cmdDuplicado" />
                    </label>
                </div>
                <div class="col-md-2 form-group">
                    <label class="checkbox"> <input type="checkbox" name="tpss.temporal"
                        id="tpss.temporal" <c:if test="${tpss.temporal}">checked="checked"</c:if>
                        value="true" /> <fmt:message key="tpss.temporal" />
                    </label>
                </div>
                <div class="col-md-2 form-group">
                    <label class="checkbox"> <input type="checkbox" name="tpss.facturable"
                        id="tpss.facturable"
                        <c:if test="${tpss.facturable}">checked="checked"</c:if> value="true" /> <fmt:message
                            key="tpss.facturable" />
                    </label>
                </div>
            </div>

            <div class="row">
                <div class="col-md-3 form-group">
                    <label><fmt:message key="tpss.tpdtEstado" /></label> <select
                        name="tpss.tpdtEstado.id" id="tpss.tpdtEstado.id"
                        class="form-control input-sm"
                        <c:if test="${entd.obligatorio}">required="required"</c:if>>
                        <option value="" />
                        <c:if test="${empty tpss.tpdtEstado.id}">
                            <c:forEach items="${tpdtList}" var="value">
                                <option value="${value.value}">${value.label}</option>
                            </c:forEach>
                        </c:if>
                        <c:if test="${not empty tpss.tpdtEstado.id}">
                            <c:forEach items="${tpdtList}" var="value">
                                <option value="${value.value}"
                                    ${value.value eq tpss.tpdtEstado.id ? 'selected' : ''}>${value.label}</option>
                            </c:forEach>
                        </c:if>
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
