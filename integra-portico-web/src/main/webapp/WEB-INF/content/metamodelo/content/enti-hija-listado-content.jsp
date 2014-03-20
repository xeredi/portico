<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>

<div class="btn-toolbar" role="toolbar">
    <div class="btn-group">
        <a class="btn btn-default" href="enen-alta.action"><i class="glyphicon glyphicon-file"></i>
            <fmt:message key="boton.alta" /></a>
    </div>
</div>

<table class="table table-condensed table-hover table-nonfluid">
    <thead>
        <tr>
            <th />
            <th><fmt:message key="enti.codigo" /></th>
            <th><fmt:message key="enti.tipo" /></th>
            <th><fmt:message key="enti.nombre" /></th>
        </tr>
    </thead>

    <tbody>
        <c:forEach items="${request.entiHijasList}" var="enti">
            <tr>
                <td><a href="enen-borrar.action"><i class="glyphicon glyphicon-remove"></i></a></td>
                <td><a href="enti-detalle.action?enti.id=${enti.id}">${enti.codigo}</a></td>
                <td>${enti.tipo}</td>
                <td>${enti.nombre}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
