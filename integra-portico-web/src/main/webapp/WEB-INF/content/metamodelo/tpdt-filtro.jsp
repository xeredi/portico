<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<title><fmt:message key="tpdt-filtro.title" /></title>
</head>
<body>
	<form action="tpdt-listado.action" method="post">
		<fmt:message key="format.datetime" var="datetimePattern" scope="page" />

		<fieldset>
			<div class="row">
				<div class="col-md-3 form-group">
					<label><fmt:message key="tpdtCriterio.nombre" /></label> <input type="text"
						name="tpdtCriterio.nombre" id="tpdtCriterio.nombre" value="${tpdtCriterio.nombre}"
						class="form-control input-sm" maxlength="50" />
				</div>
				<div class="col-md-3 form-group">
					<label><fmt:message key="tpdtCriterio.tipoElemento" /></label> <select
						name="tpdtCriterio.tipoElemento" id="tpdtCriterio.tipoElemento" class="form-control input-sm">
						<option value="" />

						<c:forEach items="${tiposElemento}" var="value">
							<option value="${value}"
								<c:if test="${value == tpdtCriterio.tipoElemento}">selected="selected"</c:if>>${value} -
								<fmt:message key="TipoElemento.${value}" /></option>
						</c:forEach>
					</select>
				</div>
				<div class="col-md-3 form-group">
					<label><fmt:message key="tpdtCriterio.tpht" /></label> <select name="tpdtCriterio.tpht"
						id="tpdtCriterio.tpht" class="form-control input-sm">
						<option value="" />

						<c:forEach items="${tphts}" var="value">
							<option value="${value}"
								<c:if test="${value == tpdtCriterio.tpht}">selected="selected"</c:if>>${value} -
								<fmt:message key="TipoHtml.${value}" /></option>
						</c:forEach>
					</select>
				</div>
				<div class="col-md-3 form-group">
					<label><fmt:message key="tpdtCriterio.entiId" /></label> <select name="tpdtCriterio.entiId"
						id="tpdtCriterio.entiId" class="form-control input-sm">
						<option value="" />

						<c:forEach items="${entis}" var="value">
							<option value="${value.value}"
								<c:if test="${value.value == tpdtCriterio.entiId}">selected="selected"</c:if>>${value.label}</option>
						</c:forEach>
					</select>
				</div>
			</div>
		</fieldset>
		<button type="submit" class="btn btn-primary">
			<fmt:message key="boton.buscar" />
		</button>
	</form>
</body>
</html>
