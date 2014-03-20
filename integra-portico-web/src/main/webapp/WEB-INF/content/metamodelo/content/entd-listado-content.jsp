<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>

<div class="btn-toolbar" role="toolbar">
    <div class="btn-group">
        <a class="btn btn-default" href="entd-alta.action?entd.entiId=${enti.id}"><i
            class="glyphicon glyphicon-file"></i> <fmt:message key="boton.alta" /></a>
    </div>
</div>

<table class="table table-condensed table-hover table-nonfluid">
    <thead>
        <tr>
            <th />
            <th><fmt:message key="entd.etiqueta" /></th>
            <th><fmt:message key="entd.tpdt.nombre" /></th>
            <th><fmt:message key="entd.tpdt.tipoElemento" /></th>
            <th><fmt:message key="entd.tpdt.tpht" /></th>
            <th><fmt:message key="entd.tpdt.enti.nombre" /></th>
            <th><fmt:message key="entd.grupo" /></th>
            <th><fmt:message key="entd.fila" /></th>
            <th><fmt:message key="entd.orden" /></th>
            <th><fmt:message key="entd.span" /></th>
            <th><fmt:message key="entd.obligatorio" /></th>
            <th><fmt:message key="entd.gridable" /></th>
            <th><fmt:message key="entd.filtrable" /></th>
            <th><fmt:message key="entd.valorDefecto" /></th>
        </tr>
    </thead>

    <tbody>
        <c:forEach items="${enti.entdList}" var="tpdtId">
            <c:set var="entd" value="${enti.entdMap[tpdtId]}" />

            <tr>
                <td><a
                    href="entd-modificar.action?entd.entiId=${entd.entiId}&entd.tpdt.id=${entd.tpdt.id}"><i
                        class="glyphicon glyphicon-edit"></i></a></td>
                <td>${entd.etiqueta}</td>
                <td><a href="tpdt-detalle.action?tpdt.id=${entd.tpdt.id}">
                        ${entd.tpdt.nombre}</a></td>
                <td title="<fmt:message key="TipoElemento.${entd.tpdt.tipoElemento}" />">${entd.tpdt.tipoElemento}</td>
                <td title="<fmt:message key="TipoHtml.${entd.tpdt.tpht}" />">${entd.tpdt.tpht}</td>
                <td><c:if test="${entd.tpdt.enti.id != null}">
                        <a href="enti-detalle.action?enti.id=${entd.tpdt.enti.id}">
                            ${entd.tpdt.enti.nombre}</a>
                    </c:if></td>
                <td><span class="pull-right">${entd.grupo}</span></td>
                <td><span class="pull-right">${entd.fila}</span></td>
                <td><span class="pull-right">${entd.orden}</span></td>
                <td><span class="pull-right">${entd.span}</span></td>
                <td><c:if test="${entd.obligatorio}">
                        <span><i class="glyphicon glyphicon-ok"></i></span>
                    </c:if></td>
                <td><c:if test="${entd.gridable}">
                        <span><i class="glyphicon glyphicon-ok"></i></span>
                    </c:if></td>
                <td><c:if test="${entd.filtrable}">
                        <span><i class="glyphicon glyphicon-ok"></i></span>
                    </c:if></td>
                <td>${entd.valorDefecto}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
