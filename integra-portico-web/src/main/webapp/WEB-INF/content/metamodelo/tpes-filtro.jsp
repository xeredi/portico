<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<title><fmt:message key="tpes-filtro.title" /></title>
</head>
<body>
	<form action="tpes-listado.action" method="post">
		<fmt:message key="format.datetime" var="datetimePattern" scope="page" />

		<fieldset>
			<div class="row">
				<div class="col-md-1 form-group">
					<label><fmt:message key="tpesCriterio.codigo" /></label> <input type="text"
						name="tpesCriterio.codigo" id="tpesCriterio.codigo" value="${tpesCriterio.codigo}"
						class="form-control input-sm" maxlength="4" />
				</div>
				<div class="col-md-5 form-group">
					<label><fmt:message key="tpesCriterio.nombre" /></label> <input type="text"
						name="tpesCriterio.nombre" id="tpesCriterio.nombre" value="${tpesCriterio.nombre}"
						class="form-control input-sm" maxlength="50" />
				</div>
			</div>
		</fieldset>
		<button type="submit" class="btn btn-primary">
			<fmt:message key="boton.buscar" />
		</button>
	</form>
</body>
</html>
