<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<%@ taglib prefix="s" uri="/struts-tags"%>
<%--
 --%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel='stylesheet'
    href='${pageContext.request.contextPath}/webjars/bootstrap/3.1.1/css/bootstrap.min.css'>
<link rel='stylesheet'
    href='${pageContext.request.contextPath}/webjars/bootstrap/3.1.1/css/bootstrap-theme.min.css'>
<link rel="stylesheet" type="text/css" media="screen"
    href="${pageContext.request.contextPath}/static/bootstrap-datetimepicker/2.1.32/css/bootstrap-datetimepicker.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css" />

<script type="text/javascript" src="${pageContext.request.contextPath}/webjars/angularjs/1.2.13/angular.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/webjars/angular-translate/2.0.1/angular-translate.min.js"></script>

<title><fmt:message key="app.title" /> - <decorator:title /></title>
</head>
<body>
    <header class="navbar navbar-inverse navbar-fixed-top">
        <nav class="collapse navbar-collapse" role="navigation">
            <ul class="nav navbar-nav">
                <li><a href="${pageContext.request.contextPath}/menu.action" class="brand">
                        <fmt:message key="app.title" /> - <decorator:title />
                </a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <%--
                    <li>
                        <div class="btn-group">
                            <button type="button" class="btn btn-default dropdown-toggle"
                                data-toggle="dropdown">
                                <fmt:message key="menu.title" />
                                </span>
                            </button>
                            <ul class="dropdown-menu" role="menu">
                                <li role="presentation" class="dropdown-header">Gestion</li>
                                <li><a
                                    href="${pageContext.request.contextPath}/servicio/tpsr-listado.action"><fmt:message
                                            key="tpsr-listado.title" /></a></li>
                                <li><a
                                    href="${pageContext.request.contextPath}/estadistica/pepr-listado.action"><fmt:message
                                            key="tpes-listado.title" /></a></li>
                                <li><a
                                    href="${pageContext.request.contextPath}/maestro/tppr-listado.action"><fmt:message
                                            key="tppr-listado.title" /></a></li>
                                <li role="presentation" class="divider"></li>
                                <li role="presentation" class="dropdown-header">Administracion</li>
                                <li><a
                                    href="${pageContext.request.contextPath}/proceso/prbt-listado.action">Procesos
                                        Batch</a></li>
                                <li role="presentation" class="divider"></li>
                                <li role="presentation" class="dropdown-header">Parametrizacion</li>
                                <li><a
                                    href="${pageContext.request.contextPath}/metamodelo/tpsr-listado.action">Tipos
                                        de Servicio</a></li>
                                <li><a
                                    href="${pageContext.request.contextPath}/metamodelo/tpes-listado.action">Estadisticas</a></li>
                                <li><a
                                    href="${pageContext.request.contextPath}/metamodelo/tppr-listado.action">Maestros</a></li>
                                <li><a
                                    href="${pageContext.request.contextPath}/metamodelo/tpdt-listado.action">Tipos
                                        de Dato</a></li>
                                <li><a
                                    href="${pageContext.request.contextPath}/configuracion/conf-listado.action">Configuracion</a></li>
                            </ul>
                        </div>
                    </li>
--%>
                <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown"><fmt:message
                            key="menu.title" /></a>
                    <ul class="dropdown-menu" role="menu">
                        <li role="presentation" class="dropdown-header">Gestion</li>
                        <li><a
                            href="${pageContext.request.contextPath}/servicio/tpsr-listado.action"><fmt:message
                                    key="tpsr-listado.title" /></a></li>
                        <li><a
                            href="${pageContext.request.contextPath}/estadistica/pepr-listado.action"><fmt:message
                                    key="tpes-listado.title" /></a></li>
                        <li><a
                            href="${pageContext.request.contextPath}/maestro/tppr-listado.action"><fmt:message
                                    key="tppr-listado.title" /></a></li>
                        <li role="presentation" class="divider"></li>
                        <li role="presentation" class="dropdown-header">Administracion</li>
                        <li><a
                            href="${pageContext.request.contextPath}/proceso/prbt-listado.action">Procesos
                                Batch</a></li>
                        <li role="presentation" class="divider"></li>
                        <li role="presentation" class="dropdown-header">Parametrizacion</li>
                        <li><a
                            href="${pageContext.request.contextPath}/metamodelo/tpsr-listado.action">Tipos
                                de Servicio</a></li>
                        <li><a
                            href="${pageContext.request.contextPath}/metamodelo/tpes-listado.action">Estadisticas</a></li>
                        <li><a
                            href="${pageContext.request.contextPath}/metamodelo/tppr-listado.action">Maestros</a></li>
                        <li><a
                            href="${pageContext.request.contextPath}/metamodelo/tpdt-listado.action">Tipos
                                de Dato</a></li>
                        <li><a
                            href="${pageContext.request.contextPath}/configuracion/conf-listado.action">Configuracion</a></li>
                    </ul></li>
            </ul>
        </nav>
    </header>

    <div id="body-content">
        <c:if test="${not empty actionErrors || not empty fieldErrors}">
            <div class="alert alert-danger">
                <s:actionerror />
                <s:fielderror />
            </div>
        </c:if>
        <c:if test="${not empty session.actionMessages}">
            <div class="alert alert-info">
                <ul>
                    <c:forEach items="${session.actionMessages}" var="actionMessage">
                        <c:if test="${actionMessage != null}">
                            <li>${actionMessage}</li>
                        </c:if>
                    </c:forEach>
                </ul>
                <s:actionmessage />
            </div>

            <c:set var="actionMessages" value="${null}" scope="session" />
        </c:if>

        <decorator:body />
    </div>

    <script type="text/javascript"
        src="${pageContext.request.contextPath}/webjars/jquery/2.1.0/jquery.min.js"></script>
    <script type="text/javascript"
        src="${pageContext.request.contextPath}/webjars/bootstrap/3.1.1/js/bootstrap.min.js"></script>
    <script type="text/javascript"
        src="${pageContext.request.contextPath}/webjars/momentjs/2.5.0/min/moment.min.js"></script>
    <script type="text/javascript"
        src="${pageContext.request.contextPath}/webjars/typeaheadjs/0.9.3/typeahead.min.js"></script>
    <script type="text/javascript"
        src="${pageContext.request.contextPath}/webjars/hoganjs/2.0.0/hogan.min.js"></script>
    <script type="text/javascript"
        src="${pageContext.request.contextPath}/static/bootstrap-datetimepicker/2.1.32/js/bootstrap-datetimepicker.min.js"></script>

    <script type="text/javascript"
        src="${pageContext.request.contextPath}/webjars/angular-ui-bootstrap/0.10.0/ui-bootstrap.min.js"></script>
    <%--
 --%>
</body>
</html>
