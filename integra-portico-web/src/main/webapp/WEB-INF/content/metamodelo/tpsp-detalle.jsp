<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<title><fmt:message key="tpsp-detalle.title" /> - ${tpsp.nombre} (${tpsp.codigo} -
    ${tpsp.id})</title>
</head>
<body>
    <fmt:message key="format.datetime" var="datetimePattern" scope="page" />

    <fieldset>
        <div class="row">
            <div class="col-md-2 form-group">
                <label> <fmt:message key="enti.cmdAlta" />
                </label>
                <p class="form-control-static">
                    <c:if test="${tpsp.cmdAlta}">
                        <i class="glyphicon glyphicon-ok"></i>
                    </c:if>
                </p>
            </div>
            <div class="col-md-2 form-group">
                <label> <fmt:message key="enti.cmdBaja" />
                </label>
                <p class="form-control-static">
                    <c:if test="${tpsp.cmdBaja}">
                        <i class="glyphicon glyphicon-ok"></i>
                    </c:if>
                </p>
            </div>
            <div class="col-md-2 form-group">
                <label> <fmt:message key="enti.cmdEdicion" />
                </label>
                <p class="form-control-static">
                    <c:if test="${tpsp.cmdEdicion}">
                        <i class="glyphicon glyphicon-ok"></i>
                    </c:if>
                </p>
            </div>
            <div class="col-md-2 form-group">
                <label> <fmt:message key="enti.cmdDuplicado" />
                </label>
                <p class="form-control-static">
                    <c:if test="${tpsp.cmdDuplicado}">
                        <i class="glyphicon glyphicon-ok"></i>
                    </c:if>
                </p>
            </div>
            <div class="col-md-2 form-group">
                <label> <fmt:message key="tpsp.i18n" />
                </label>
                <p class="form-control-static">
                    <c:if test="${tpsp.i18n}">
                        <i class="glyphicon glyphicon-ok"></i>
                    </c:if>
                </p>
            </div>
            <div class="col-md-2 form-group">
                <label> <fmt:message key="tpsp.tempExp" />
                </label>
                <p class="form-control-static">
                    <c:if test="${tpsp.tempExp}">
                        <i class="glyphicon glyphicon-ok"></i>
                    </c:if>
                </p>
            </div>
        </div>

        <div class="row">
            <div class="col-md-4 form-group">
                <label> <fmt:message key="tpsp.tpprAsociado" />
                </label>
                <p class="form-control-static">
                    <a href="tppr-detalle.action?tppr.id=${tpsp.tpprAsociado.id}">${tpsp.tpprAsociado.nombre}
                        (${tpsp.tpprAsociado.codigo} - ${tpsp.tpprAsociado.id})</a>
                </p>
            </div>
        </div>
    </fieldset>

    <div class="tabbable">
        <ul class="nav nav-tabs">
            <li class="active"><a href="#entdList" data-toggle="tab"><fmt:message
                        key="enti.entdList" /></a></li>
        </ul>
        <div class="tab-content">
            <div class="tab-pane active" id="entdList">
                <c:set var="enti" value="${tpsp}" scope="request" />

                <jsp:include page="content/entd-listado-content.jsp" flush="true" />
            </div>
        </div>
    </div>
</body>
</html>
