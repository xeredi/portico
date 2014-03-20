<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<title><fmt:message key="tpsr-detalle.title" /> - ${tpsr.nombre} (${tpsr.codigo} -
    ${tpsr.id})</title>
</head>
<body>
    <fmt:message key="format.datetime" var="datetimePattern" scope="page" />

    <fieldset>
        <div class="row">
            <div class="col-md-2 form-group">
                <label> <fmt:message key="enti.cmdAlta" />
                </label>
                <p class="form-control-static">
                    <c:if test="${tpsr.cmdAlta}">
                        <i class="glyphicon glyphicon-ok"></i>
                    </c:if>
                </p>
            </div>
            <div class="col-md-2 form-group">
                <label> <fmt:message key="enti.cmdBaja" />
                </label>
                <p class="form-control-static">
                    <c:if test="${tpsr.cmdBaja}">
                        <i class="glyphicon glyphicon-ok"></i>
                    </c:if>
                </p>
            </div>
            <div class="col-md-2 form-group">
                <label> <fmt:message key="enti.cmdEdicion" />
                </label>
                <p class="form-control-static">
                    <c:if test="${tpsr.cmdEdicion}">
                        <i class="glyphicon glyphicon-ok"></i>
                    </c:if>
                </p>
            </div>
            <div class="col-md-2 form-group">
                <label> <fmt:message key="enti.cmdDuplicado" />
                </label>
                <p class="form-control-static">
                    <c:if test="${tpsr.cmdDuplicado}">
                        <i class="glyphicon glyphicon-ok"></i>
                    </c:if>
                </p>
            </div>
            <div class="col-md-2 form-group">
                <label> <fmt:message key="tpsr.temporal" />
                </label>
                <p class="form-control-static">
                    <c:if test="${tpsr.temporal}">
                        <i class="glyphicon glyphicon-ok"></i>
                    </c:if>
                </p>
            </div>
            <div class="col-md-2 form-group">
                <label> <fmt:message key="tpsr.facturable" />
                </label>
                <p class="form-control-static">
                    <c:if test="${tpsr.facturable}">
                        <i class="glyphicon glyphicon-ok"></i>
                    </c:if>
                </p>
            </div>
        </div>

        <div class="row">
            <div class="col-md-3 form-group">
                <label> <fmt:message key="tpsr.tpdtEstado" />
                </label>
                <p class="form-control-static">
                    <c:if test="${tpsr.tpdtEstado != null}">
                        <a href="tpdt-detalle.action?tpdt.id=${tpsr.tpdtEstado.id}">${tpsr.tpdtEstado.nombre}</a>
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
            <li><a href="#tpssList" data-toggle="tab">Tipos de Subservicio</a></li>
            <li><a href="#entiHijasList" data-toggle="tab">Entidades Hijas</a></li>
            <li><a href="#enacList" data-toggle="tab"><fmt:message key="enti.enacList" /></a></li>
        </ul>
        <div class="tab-content">
            <div class="tab-pane active" id="entdList">
                <c:set var="enti" value="${tpsr}" scope="request" />

                <jsp:include page="content/entd-listado-content.jsp" flush="true" />
            </div>

            <div class="tab-pane" id="engdList">
                <c:set var="enti" value="${tpsr}" scope="request" />

                <jsp:include page="content/engd-listado-content.jsp" flush="true" />
            </div>

            <div class="tab-pane" id="tpssList">
                <div class="btn-toolbar" role="toolbar">
                    <div class="btn-group">
                        <a class="btn btn-default" href="tpss-alta.action?tpss.tpsr.id=${tpsr.id}"><i
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
                            <th><fmt:message key="tpss.tpdtEstado" /></th>
                        </tr>
                    </thead>

                    <tbody>
                        <c:forEach items="${tpssList}" var="enti">
                            <tr>
                                <td><a href="tpss-borrar.action"><i
                                        class="glyphicon glyphicon-remove"></i></a></td>
                                <td><a href="enti-detalle.action?enti.id=${enti.id}">${enti.codigo}</a></td>
                                <td>${enti.tipo}</td>
                                <td>${enti.nombre}</td>
                                <td><c:if test="${enti.tpdtEstado != null}">
                                        <a href="tpdt-detalle.action?tpdt.id=${enti.tpdtEstado.id}">${enti.tpdtEstado.nombre}</a>
                                    </c:if></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>

            <div class="tab-pane" id="entiHijasList">
                <jsp:include page="content/enti-hija-listado-content.jsp" flush="true" />
            </div>

            <div class="tab-pane" id="enacList">
                <jsp:include page="content/enac-listado-content.jsp" flush="true" />
            </div>
        </div>
    </div>

</body>
</html>
