<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>

<table class="table table-condensed table-hover table-nonfluid">
    <thead>
        <tr>
            <th><fmt:message key="enti.codigo" /></th>
            <th><fmt:message key="enti.tipo" /></th>
            <th><fmt:message key="enti.nombre" /></th>
        </tr>
    </thead>

    <tbody>
        <c:forEach items="${request.entiPadresList}" var="enti">
            <tr>
                <td><a href="enti-detalle.action?enti.id=${enti.id}">${enti.codigo}</a></td>
                <td>${enti.tipo}</td>
                <td>${enti.nombre}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
