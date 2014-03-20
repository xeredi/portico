<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<title><fmt:message key="cncl-${accion}.title" /></title>
</head>
<body>
	<fmt:message key="format.datetime" var="datetimePattern" scope="page" />

	<form action="cncl-guardar.action" method="post">
		<fieldset>
			<input type="hidden" name="cncl.id" value="${cncl.id}" /> <input type="hidden" name="accion"
				value="${accion}" />

			<div class="row">
				<div class="col-md-6 form-group">
					<label><fmt:message key="cncl.clave" /></label> <input type="text" name="cncl.clave"
						id="cncl.clave" value="${cncl.clave}" class="form-control input-sm" required="required"
						<c:if test="${accion == 'modificar'}">disabled="disabled"</c:if> />
				</div>
				<div class="col-md-3 form-group">
					<label><fmt:message key="cncl.tipoValor" /></label> <select id="cncl.tipoValor"
						name="cncl.tipoValor" class="form-control input-sm" required="required">
						<option />
						<c:forEach items="${tiposValor}" var="item">
							<option value="${item}" <c:if test="${item eq cncl.tipoValor}">selected="selected"</c:if>>${item}-
								<fmt:message key="TipoValor.${item}" /></option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6 form-group">
					<label><fmt:message key="cncl.valorDefecto" /></label> <input type="text"
						name="cncl.valorDefecto" id="cncl.valorDefecto" value="${cncl.valorDefecto}"
						class="form-control input-sm" required="required" />
				</div>
			</div>

			<c:forEach items="${cnens}" var="cnen">
				<div class="row">
					<div class="col-md-6 form-group">
						<label title="${cnen.nombre}">${cnen.codigo}</label> <input type="text"
							name="cncl.cnvlMap[${cnen.id}]" id="cncl.cnvlMap[${cnen.id}]"
							value="${cncl.cnvlMap[cnen.id]}" class="form-control input-sm" />
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
