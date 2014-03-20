<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>

<div class="btn-toolbar" role="toolbar">
    <div class="btn-group">
        <a class="btn btn-default" href="engd-alta.action?engd.entiId=${enti.id}"><i
            class="glyphicon glyphicon-file"></i> <fmt:message key="boton.alta" /></a>
    </div>
</div>

<table class="table table-condensed table-hover table-nonfluid">
    <thead>
        <tr>
            <th />
            <th><fmt:message key="engd.numero" /></th>
            <th><fmt:message key="engd.etiqueta" /></th>
        </tr>
    </thead>

    <tbody>
        <c:forEach items="${enti.engdList}" var="engdId">
            <c:set var="engd" value="${enti.engdMap[engdId]}" />
            <tr>
                <td><a
                    href="engd-modificar.action?engd.entiId=${engd.entiId}&engd.numero=${engd.numero}"><i
                        class="glyphicon glyphicon-edit"></i></a></td>
                <td>${engd.numero}</td>
                <td>${engd.etiqueta}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
