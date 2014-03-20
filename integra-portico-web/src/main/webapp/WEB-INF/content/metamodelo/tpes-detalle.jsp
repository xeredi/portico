<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<title><fmt:message key="tpes-detalle.title" /> - ${tpes.nombre} (${tpes.codigo} -
    ${tpes.id})</title>
</head>
<body>
    <fmt:message key="format.datetime" var="datetimePattern" scope="page" />

    <fieldset></fieldset>

    <div class="tabbable">
        <ul class="nav nav-tabs">
            <li class="active"><a href="#entdList" data-toggle="tab"><fmt:message
                        key="enti.entdList" /></a></li>
        </ul>
        <div class="tab-content">
            <div class="tab-pane active" id="entdList">
                <c:set var="enti" value="${tpes}" scope="request" />

                <jsp:include page="content/entd-listado-content.jsp" flush="true" />
            </div>
        </div>
    </div>
</body>
</html>
