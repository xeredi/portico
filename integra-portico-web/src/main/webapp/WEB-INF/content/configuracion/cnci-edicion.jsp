<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<title><fmt:message key="cnci-${accion}.title" /></title>
</head>
<body>
	<fmt:message key="format.datetime" var="datetimePattern" scope="page" />

	<form action="cnci-guardar.action" method="post">
		<fieldset>
			<input type="hidden" name="cnci.id" value="${cnci.id}" /> <input type="hidden" name="accion"
				value="${accion}" />

			<div class="row">
				<div class="col-md-6 form-group">
					<label><fmt:message key="cnci.clave" /></label> <input type="text" name="cnci.clave"
						id="cnci.clave" value="${cnci.clave}" class="form-control input-sm" required="required"
						<c:if test="${accion == 'modificar'}">disabled="disabled"</c:if> />
				</div>
			</div>
			<div class="row">
				<div class="col-md-6 form-group">
					<label><fmt:message key="cnci.valorDefecto" /></label> <input type="text"
						name="cnci.valorDefecto" id="cnci.valorDefecto" value="${cnci.valorDefecto}"
						class="form-control input-sm" required="required" />
				</div>
			</div>

			<c:forEach items="${cnids}" var="cnid">
				<div class="row">
					<div class="col-md-6 form-group">
						<label title="${cnen.nombre}">${cnid.codigo}</label> <input type="text"
							name="cnci.cnviMap[${cnid.id}]" id="cnci.cnviMap[${cnid.id}]"
							value="${cnci.cnviMap[cnid.id]}" class="form-control input-sm" />
					</div>
				</div>
			</c:forEach>
		</fieldset>

		<button type="submit" class="btn btn-primary">
			<fmt:message key="boton.guardar" />
		</button>
	</form>
</body>
</html>
