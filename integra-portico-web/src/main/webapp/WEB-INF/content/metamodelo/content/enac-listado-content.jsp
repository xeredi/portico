<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>

<div class="btn-toolbar" role="toolbar">
    <div class="btn-group">
        <a class="btn btn-default" href="enac-alta.action?enac.entiId=${enti.id}"><i
            class="glyphicon glyphicon-file"></i> <fmt:message key="boton.alta" /></a>
    </div>
</div>

<table class="table table-condensed table-hover table-nonfluid">
    <thead>
        <tr>
            <th />
            <th><fmt:message key="enac.orden" /></th>
            <th><fmt:message key="enac.etiqueta" /></th>
            <th><fmt:message key="enac.path" /></th>
        </tr>
    </thead>

    <tbody>
        <c:forEach items="${enti.enacList}" var="enac">
            <tr>
                <td><a
                    href="enac-modificar.action?enac.entiId=${enac.entiId}&enac.path=${enac.path}"><i
                        class="glyphicon glyphicon-edit"></i></a></td>
                <td>${enac.orden}</td>
                <td>${enac.etiqueta}</td>
                <td>${enac.path}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
