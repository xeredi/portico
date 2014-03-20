<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<title><fmt:message key="entd-${accion}.title" /></title>
</head>
<body>
    <fmt:message key="format.datetime" var="datetimePattern" scope="page" />

    <form action="entd-guardar.action" method="post">
        <fieldset>
            <input type="hidden" name="entd.entiId" value="${entd.entiId}" /> <input type="hidden" name="accion"
                value="${accion}" />

            <div class="row">
                <div class="col-md-4 form-group">
                    <label for="entd.tpdt.id"><fmt:message key="entd.tpdt.id" /></label>
                    <c:if test="${accion == 'alta'}">
                        <select name="entd.tpdt.id" id="entd.tpdt.id" class="form-control input-sm">
                            <option value="" />

                            <c:forEach items="${tpdts}" var="item">
                                <option value="${item.value}"
                                    <c:if test="${item.value == entd.tpdt.id}">selected="selected"</c:if>>${item.label}</option>
                            </c:forEach>
                        </select>
                    </c:if>
                    <c:if test="${accion == 'modificar'}">
                        <div class="controls input-append">
                            <input type="hidden" name="entd.tpdt.id" id="entd.tpdt.id" value="${entd.tpdt.id}" /> <input
                                type="text" name="entd.tpdt.nombre" id="entd.tpdt.nombre" value="${entd.tpdt.nombre}"
                                class="form-control input-sm" disabled="disabled" />
                            <c:if test="${entd.tpdt.id != null}">
                                <span class="add-on"> <a href="tpdt-detalle-popup.action?tpdt.id=${entd.tpdt.id}"
                                    data-target="#popup-div" role="button" data-toggle="modal"><i
                                        class="icon-share-alt"></i></a>
                                </span>
                            </c:if>
                        </div>
                    </c:if>
                </div>
                <div class="col-md-6 form-group">
                    <label for="entd.etiqueta"><fmt:message key="entd.etiqueta" /></label> <input type="text"
                        name="entd.etiqueta" id="entd.etiqueta" value="${entd.etiqueta}" class="form-control input-sm"
                        required="required" maxlength="100" />
                </div>
            </div>

            <div class="row">
                <div class="col-md-2 form-group">
                    <label for="entd.grupo"><fmt:message key="entd.grupo" /></label> <select name="entd.grupo"
                        id="entd.grupo" class="form-control input-sm">
                        <option value="" />

                        <c:forEach items="${engds}" var="item">
                            <option value="${item.value}"
                                <c:if test="${item.value == entd.grupo}">selected="selected"</c:if>>${item.label}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="col-md-1 form-group">
                    <label for="entd.fila"><fmt:message key="entd.fila" /></label> <input type="text" name="entd.fila"
                        id="entd.fila" value="${entd.fila}" class="form-control input-sm number" required="required"
                        maxlength="2" />
                </div>
                <div class="col-md-1 form-group">
                    <label for="entd.orden"><fmt:message key="entd.orden" /></label> <input type="text"
                        name="entd.orden" id="entd.orden" value="${entd.orden}" class="form-control input-sm number"
                        required="required" maxlength="2" />
                </div>
                <div class="col-md-1 form-group">
                    <label for="entd.span"><fmt:message key="entd.span" /></label> <input type="text" name="entd.span"
                        id="entd.span" value="${entd.span}" class="form-control input-sm number" required="required"
                        maxlength="2" />
                </div>
                <div class="col-md-2 form-group">
                    <label class="checkbox"> <input type="checkbox" name="entd.obligatorio"
                        id="entd.obligatorio" <c:if test="${entd.obligatorio}">checked="checked"</c:if> value="true" />
                        <fmt:message key="entd.obligatorio" />
                    </label>
                </div>
                <div class="col-md-2 form-group">
                    <label class="checkbox"> <input type="checkbox" name="entd.gridable" id="entd.gridable"
                        <c:if test="${entd.gridable}">checked="checked"</c:if> value="true" /> <fmt:message
                            key="entd.gridable" />
                    </label>
                </div>
                <div class="col-md-2 form-group">
                    <label class="checkbox"> <input type="checkbox" name="entd.filtrable" id="entd.filtrable"
                        <c:if test="${entd.filtrable}">checked="checked"</c:if> value="true" /> <fmt:message
                            key="entd.filtrable" />
                    </label>
                </div>
            </div>

            <div class="row">
                <div class="col-md-4 form-group">
                    <label for="entd.valorDefecto"><fmt:message key="entd.valorDefecto" /></label> <input type="text"
                        name="entd.valorDefecto" id="entd.valorDefecto" value="${entd.valorDefecto}"
                        class="form-control input-sm" maxlength="30" />
                </div>
            </div>
        </fieldset>

        <button type="submit" class="btn btn-primary">
            <fmt:message key="boton.guardar" />
        </button>
    </form>
</body>
</html>
