<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<title><fmt:message key="tppr-filtro.title" /></title>
</head>
<body>
	<form action="tppr-listado.action" method="post">
		<fmt:message key="format.datetime" var="datetimePattern" scope="page" />

		<fieldset>
			<div class="row">
				<div class="col-md-1 form-group">
					<label><fmt:message key="tpprCriterio.codigo" /></label> <input type="text"
						name="tpprCriterio.codigo" id="tpprCriterio.codigo" value="${tpprCriterio.codigo}"
						class="form-control input-sm" maxlength="4" />
				</div>
				<div class="col-md-5 form-group">
					<label><fmt:message key="tpprCriterio.nombre" /></label> <input type="text"
						name="tpprCriterio.nombre" id="tpprCriterio.nombre" value="${tpprCriterio.nombre}"
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
