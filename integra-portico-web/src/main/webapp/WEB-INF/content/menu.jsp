<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<title><fmt:message key="menu.title" /></title>
</head>
<body>
    <fmt:message key="format.datetime" var="datetimePattern" scope="page" />

    <h5>Gestion</h5>
    <ul>
        <li><a href="${pageContext.request.contextPath}/servicio/tpsr-listado.action"><fmt:message
                    key="tpsr-listado.title" /></a></li>
        <li><a href="${pageContext.request.contextPath}/estadistica/pepr-listado.action"><fmt:message
                    key="tpes-listado.title" /></a></li>
        <li><a href="${pageContext.request.contextPath}/maestro/tppr-listado.action"><fmt:message
                    key="tppr-listado.title" /></a></li>
    </ul>

    <h5>Administracion</h5>
    <ul>
        <li><a href="${pageContext.request.contextPath}/proceso/prbt-listado.action">Procesos Batch</a></li>
    </ul>

    <h5>Parametrizacion</h5>
    <ul>
        <li><a href="${pageContext.request.contextPath}/metamodelo/tpsr-listado.action">Tipos de Servicio</a></li>
        <li><a href="${pageContext.request.contextPath}/metamodelo/tpes-listado.action">Estadisticas</a></li>
        <li><a href="${pageContext.request.contextPath}/metamodelo/tppr-listado.action">Maestros</a></li>
        <li><a href="${pageContext.request.contextPath}/metamodelo/tpdt-listado.action">Tipos de Dato</a></li>
    </ul>
</body>
</html>
