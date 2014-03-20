<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<title><fmt:message key="tpsr-${accion}.title" /></title>
</head>
<body>
    <fmt:message key="format.datetime" var="datetimePattern" scope="page" />

    <form action="tpsr-guardar.action" method="post">
        <fieldset>
            <input type="hidden" name="tpsr.id" value="${tpsr.id}" /> <input type="hidden"
                name="accion" value="${accion}" />

            <div class="row">
                <div class="col-md-4 form-group">
                    <label><fmt:message key="enti.codigo" /></label> <input type="text"
                        name="tpsr.codigo" id="tpsr.codigo" value="${tpsr.codigo}"
                        class="form-control input-sm" required="required" maxlength="4"
                        <c:if test="${accion == 'modificar'}">disabled="disabled"</c:if> />
                </div>
                <div class="col-md-7 form-group">
                    <label><fmt:message key="enti.nombre" /></label> <input type="text"
                        name="tpsr.nombre" id="tpsr.nombre" value="${tpsr.nombre}"
                        class="form-control input-sm" required="required" maxlength="50"
                        <c:if test="${accion == 'modificar'}">disabled="disabled"</c:if> />
                </div>
            </div>

            <div class="row">
                <div class="col-md-2 form-group">
                    <label class="checkbox"> <input type="checkbox" name="tpsr.cmdAlta"
                        id="tpsr.cmdAlta" <c:if test="${tpsr.cmdAlta}">checked="checked"</c:if>
                        value="true" /> <fmt:message key="enti.cmdAlta" />
                    </label>
                </div>
                <div class="col-md-2 form-group">
                    <label class="checkbox"> <input type="checkbox" name="tpsr.cmdBaja"
                        id="tpsr.cmdBaja" <c:if test="${tpsr.cmdBaja}">checked="checked"</c:if>
                        value="true" /> <fmt:message key="enti.cmdBaja" />
                    </label>
                </div>
                <div class="col-md-2 form-group">
                    <label class="checkbox"> <input type="checkbox" name="tpsr.cmdEdicion"
                        id="tpsr.cmdEdicion"
                        <c:if test="${tpsr.cmdEdicion}">checked="checked"</c:if> value="true" /> <fmt:message
                            key="enti.cmdEdicion" />
                    </label>
                </div>
                <div class="col-md-2 form-group">
                    <label class="checkbox"> <input type="checkbox" name="tpsr.cmdDuplicado"
                        id="tpsr.cmdDuplicado"
                        <c:if test="${tpsr.cmdDuplicado}">checked="checked"</c:if> value="true" />
                        <fmt:message key="enti.cmdDuplicado" />
                    </label>
                </div>
                <div class="col-md-2 form-group">
                    <label class="checkbox"> <input type="checkbox" name="tpsr.temporal"
                        id="tpsr.temporal" <c:if test="${tpsr.temporal}">checked="checked"</c:if>
                        value="true" /> <fmt:message key="tpsr.temporal" />
                    </label>
                </div>
                <div class="col-md-2 form-group">
                    <label class="checkbox"> <input type="checkbox" name="tpsr.facturable"
                        id="tpsr.facturable"
                        <c:if test="${tpsr.facturable}">checked="checked"</c:if> value="true" /> <fmt:message
                            key="tpsr.facturable" />
                    </label>
                </div>
            </div>

            <div class="row">
                <div class="col-md-3 form-group">
                    <label><fmt:message key="tpsr.tpdtEstado" /></label> <select
                        name="tpsr.tpdtEstado.id" id="tpsr.tpdtEstado.id"
                        class="form-control input-sm"
                        <c:if test="${entd.obligatorio}">required="required"</c:if>>
                        <option value="" />
                        <c:if test="${empty tpsr.tpdtEstado.id}">
                            <c:forEach items="${tpdtList}" var="value">
                                <option value="${value.value}">${value.label}</option>
                            </c:forEach>
                        </c:if>
                        <c:if test="${not empty tpsr.tpdtEstado.id}">
                            <c:forEach items="${tpdtList}" var="value">
                                <option value="${value.value}"
                                    ${value.value eq tpsr.tpdtEstado.id ? 'selected' : ''}>${value.label}</option>
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
