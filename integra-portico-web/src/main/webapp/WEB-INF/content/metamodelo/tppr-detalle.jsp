<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<title><fmt:message key="tppr-detalle.title" /> - ${tppr.nombre} (${tppr.codigo} -
    ${tppr.id})</title>
</head>
<body>
    <fmt:message key="format.datetime" var="datetimePattern" scope="page" />

    <fieldset>
        <div class="row">
            <div class="col-md-2 form-group">
                <label> <fmt:message key="enti.cmdAlta" />
                </label>
                <p class="form-control-static">
                    <c:if test="${tppr.cmdAlta}">
                        <i class="glyphicon glyphicon-ok"></i>
                    </c:if>
                </p>
            </div>
            <div class="col-md-2 form-group">
                <label> <fmt:message key="enti.cmdBaja" />
                </label>
                <p class="form-control-static">
                    <c:if test="${tppr.cmdBaja}">
                        <i class="glyphicon glyphicon-ok"></i>
                    </c:if>
                </p>
            </div>
            <div class="col-md-2 form-group">
                <label> <fmt:message key="enti.cmdEdicion" />
                </label>
                <p class="form-control-static">
                    <c:if test="${tppr.cmdEdicion}">
                        <i class="glyphicon glyphicon-ok"></i>
                    </c:if>
                </p>
            </div>
            <div class="col-md-2 form-group">
                <label> <fmt:message key="enti.cmdDuplicado" />
                </label>
                <p class="form-control-static">
                    <c:if test="${tppr.cmdDuplicado}">
                        <i class="glyphicon glyphicon-ok"></i>
                    </c:if>
                </p>
            </div>
            <div class="col-md-2 form-group">
                <label> <fmt:message key="tppr.i18n" />
                </label>
                <p class="form-control-static">
                    <c:if test="${tppr.i18n}">
                        <i class="glyphicon glyphicon-ok"></i>
                    </c:if>
                </p>
            </div>
            <div class="col-md-2 form-group">
                <label> <fmt:message key="tppr.tempExp" />
                </label>
                <p class="form-control-static">
                    <c:if test="${tppr.tempExp}">
                        <i class="glyphicon glyphicon-ok"></i>
                    </c:if>
                </p>
            </div>
        </div>
    </fieldset>

    <div class="tabbable">
        <ul class="nav nav-tabs">
            <li class="active"><a href="#entdList" data-toggle="tab"><fmt:message
                        key="enti.entdList" /></a></li>
            <li><a href="#tpspList" data-toggle="tab">Subentidades</a></li>
        </ul>
        <div class="tab-content">
            <div class="tab-pane active" id="entdList">
                <c:set var="enti" value="${tppr}" scope="request" />

                <jsp:include page="content/entd-listado-content.jsp" flush="true" />
            </div>

            <div class="tab-pane" id="tpspList">
                <div class="btn-toolbar" role="toolbar">
                    <div class="btn-group">
                        <a class="btn btn-default" href="tpsp-alta.action?tpsp.tppr.id=${tppr.id}"><i
                            class="glyphicon glyphicon-file"></i> <fmt:message key="boton.alta" /></a>
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
                        <c:forEach items="${tpspList}" var="enti">
                            <tr>
                                <td><a href="tpsp-borrar.action"><i
                                        class="glyphicon glyphicon-remove"></i></a></td>
                                <td><a href="enti-detalle.action?enti.id=${enti.id}">${enti.codigo}</a></td>
                                <td>${enti.tipo}</td>
                                <td>${enti.nombre}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</body>
</html>
