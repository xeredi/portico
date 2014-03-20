<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<title><fmt:message key="tpss-detalle.title" /> - ${tpss.nombre} (${tpss.codigo} -
    ${tpss.id})</title>
</head>
<body>
    <fmt:message key="format.datetime" var="datetimePattern" scope="page" />

    <fieldset>
        <div class="row">
            <div class="col-md-2 form-group">
                <label> <fmt:message key="enti.cmdAlta" />
                </label>
                <p class="form-control-static">
                    <c:if test="${tpss.cmdAlta}">
                        <i class="glyphicon glyphicon-ok"></i>
                    </c:if>
                </p>
            </div>
            <div class="col-md-2 form-group">
                <label> <fmt:message key="enti.cmdBaja" />
                </label>
                <p class="form-control-static">
                    <c:if test="${tpss.cmdBaja}">
                        <i class="glyphicon glyphicon-ok"></i>
                    </c:if>
                </p>
            </div>
            <div class="col-md-2 form-group">
                <label> <fmt:message key="enti.cmdEdicion" />
                </label>
                <p class="form-control-static">
                    <c:if test="${tpss.cmdEdicion}">
                        <i class="glyphicon glyphicon-ok"></i>
                    </c:if>
                </p>
            </div>
            <div class="col-md-2 form-group">
                <label> <fmt:message key="enti.cmdDuplicado" />
                </label>
                <p class="form-control-static">
                    <c:if test="${tpss.cmdDuplicado}">
                        <i class="glyphicon glyphicon-ok"></i>
                    </c:if>
                </p>
            </div>
            <div class="col-md-2 form-group">
                <label> <fmt:message key="tpss.temporal" />
                </label>
                <p class="form-control-static">
                    <c:if test="${tpss.temporal}">
                        <i class="glyphicon glyphicon-ok"></i>
                    </c:if>
                </p>
            </div>
            <div class="col-md-2 form-group">
                <label> <fmt:message key="tpss.facturable" />
                </label>
                <p class="form-control-static">
                    <c:if test="${tpss.facturable}">
                        <i class="glyphicon glyphicon-ok"></i>
                    </c:if>
                </p>
            </div>
            <div class="col-md-3 form-group">
                <label> <fmt:message key="tpss.tpdtEstado" />
                </label>
                <p class="form-control-static">
                    <c:if test="${tpss.tpdtEstado != null}">
                        <a href="tpdt-detalle.action?tpdt.id=${tpss.tpdtEstado.id}">${tpss.tpdtEstado.nombre}</a>
                    </c:if>
                </p>
            </div>
        </div>
    </fieldset>

    <div class="tabbable">
        <ul class="nav nav-tabs">
            <li class="active"><a href="#entdList" data-toggle="tab"><fmt:message
                        key="enti.entdList" /></a></li>
            <li><a href="#engdList" data-toggle="tab"><fmt:message key="enti.engdList" /></a></li>
            <li><a href="#entiHijasList" data-toggle="tab">Entidades Hijas</a></li>
            <li><a href="#entiPadresList" data-toggle="tab">Entidades Padres</a></li>
            <li><a href="#enacList" data-toggle="tab"><fmt:message key="enti.enacList" /></a></li>
        </ul>
        <div class="tab-content">
            <div class="tab-pane active" id="entdList">
                <c:set var="enti" value="${tpss}" scope="request" />

                <jsp:include page="content/entd-listado-content.jsp" flush="true" />
            </div>

            <div class="tab-pane" id="engdList">
                <c:set var="enti" value="${tpss}" scope="request" />

                <jsp:include page="content/engd-listado-content.jsp" flush="true" />
            </div>

            <div class="tab-pane" id="entiHijasList">
                <jsp:include page="content/enti-hija-listado-content.jsp" flush="true" />
            </div>

            <div class="tab-pane" id="entiPadresList">
                <jsp:include page="content/enti-padre-listado-content.jsp" flush="true" />
            </div>

            <div class="tab-pane" id="enacList">
                <jsp:include page="content/enac-listado-content.jsp" flush="true" />
            </div>
        </div>
    </div>

</body>
</html>
