<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<title><fmt:message key="prbt-detalle.title" /></title>
</head>
<body>
	<fmt:message key="format.datetime" var="datetimePattern" scope="page" />
	<fmt:message key="format.integer" var="integerPattern" scope="page" />

	<fieldset>
		<div class="row">
			<div class="col-md-2 form-group">
				<label for="prbt.modulo"><fmt:message key="prbt.modulo" /></label>
				<p class="form-control-static">${prbt.modulo}</p>
			</div>
			<div class="col-md-2 form-group">
				<label for="prbt.tipo"><fmt:message key="prbt.tipo" /></label>
				<p class="form-control-static">${prbt.tipo}</p>
			</div>
			<div class="col-md-2 form-group">
				<label for="prbt.estado"><fmt:message key="prbt.estado" /></label>
				<p class="form-control-static">${prbt.estado}</p>
			</div>
			<div class="col-md-2 form-group">
				<label for="prbt.falta"><fmt:message key="prbt.falta" /></label>
				<p class="form-control-static">
					<fmt:formatDate pattern="${datetimePattern}" value="${prbt.falta}" />
				</p>
			</div>
		</div>
		<div class="row">
			<div class="col-md-2 form-group">
				<label for="prbt.finicio"><fmt:message key="prbt.finicio" /></label>
				<p class="form-control-static">
					<fmt:formatDate pattern="${datetimePattern}"
						value="${prbt.finicio}" />
				</p>
			</div>
			<div class="col-md-2 form-group">
				<label for="prbt.ffin"><fmt:message key="prbt.ffin" /></label>
				<p class="form-control-static">
					<fmt:formatDate pattern="${datetimePattern}" value="${prbt.ffin}" />
				</p>
			</div>
			<div class="col-md-2 form-group">
				<label for="prbt.duracion"><fmt:message key="prbt.duracion" /></label>
				<p class="form-control-static">
					<fmt:formatNumber pattern="${integerPattern}"
						value="${prbt.duracion}" />
				</p>
			</div>
			<div class="col-md-1 form-group">
				<label for="prbt.erroresCnt"><fmt:message
						key="prbt.erroresCnt" /></label>
				<p class="form-control-static">
					<fmt:formatNumber pattern="${integerPattern}"
						value="${prbt.erroresCnt}" />
				</p>
			</div>
			<div class="col-md-1 form-group">
				<label for="prbt.alertasCnt"><fmt:message
						key="prbt.alertasCnt" /></label>
				<p class="form-control-static">
					<fmt:formatNumber pattern="${integerPattern}"
						value="${prbt.alertasCnt}" />
				</p>
			</div>
			<div class="col-md-1 form-group">
				<label for="prbt.mensajesCnt"><fmt:message
						key="prbt.mensajesCnt" /></label>
				<p class="form-control-static">
					<fmt:formatNumber pattern="${integerPattern}"
						value="${prbt.mensajesCnt}" />
				</p>
			</div>
		</div>
	</fieldset>

	<div class="tabbable">
		<ul class="nav nav-tabs">
			<li class="active"><a href="#prpmMap" data-toggle="tab"><fmt:message
						key="prpmMap" /></a></li>
			<c:if test="${not empty prbt.prmnList}">
				<li><a href="#prmnList" data-toggle="tab"><fmt:message
							key="prmnList" /></a></li>
			</c:if>
			<c:if test="${not empty prbt.prarEntradaList}">
				<li><a href="#prarEntradaList" data-toggle="tab"><fmt:message
							key="prarEntradaList" /></a></li>
			</c:if>
			<c:if test="${not empty prbt.prarSalidaList}">
				<li><a href="#prarSalidaList" data-toggle="tab"><fmt:message
							key="prarSalidaList" /></a></li>
			</c:if>
			<c:if test="${not empty prbt.pritEntradaList}">
				<li><a href="#pritEntradaList" data-toggle="tab"><fmt:message
							key="pritEntradaList" /></a></li>
			</c:if>
			<c:if test="${not empty prbt.pritSalidaList}">
				<li><a href="#pritSalidaList" data-toggle="tab"><fmt:message
							key="pritSalidaList" /></a></li>
			</c:if>
		</ul>

		<div class="tab-content">
			<div class="tab-pane active" id="prpmMap">
				<table class="table table-condensed table-hover table-nonfluid">
					<thead>
						<tr>
							<th />
							<th><fmt:message key="prpm.nombre" /></th>
							<th><fmt:message key="prpm.valor" /></th>
						</tr>
					</thead>

					<tbody>
						<c:forEach items="${prbt.prpmMap}" var="prpm">
							<tr>
								<td>${prpm.key}</td>
								<td>${prpm.value}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>

			<c:if test="${not empty prbt.prmnList}">
				<div class="tab-pane" id="prmnList">
					<table class="table table-condensed table-hover table-nonfluid">
						<thead>
							<tr>
								<th><fmt:message key="prmn.nivel" /></th>
								<th><fmt:message key="prmn.codigo" /></th>
								<th><fmt:message key="prmn.mensaje" /></th>
							</tr>
						</thead>

						<tbody>
							<c:forEach items="${prbt.prmnList}" var="prmn">
								<tr>
									<td>${prmn.nivel}</td>
									<td title="<fmt:message key='MensajeCodigo.${prmn.codigo}' />">${prmn.codigo}</td>
									<td>${prmn.mensaje}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</c:if>

			<c:if test="${not empty prbt.prarEntradaList}">
				<div class="tab-pane" id="prarEntradaList">
					<table class="table table-condensed table-hover table-nonfluid">
						<thead>
							<tr>
								<th><fmt:message key="prar.nombre" /></th>
							</tr>
						</thead>

						<tbody>
							<c:forEach items="${prbt.prarEntradaList}" var="prar">
								<tr>
									<td>${prar.nombre}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</c:if>

			<c:if test="${not empty prbt.prarSalidaList}">
				<div class="tab-pane" id="prarSalidaList">
					<table class="table table-condensed table-hover table-nonfluid">
						<thead>
							<tr>
								<th><fmt:message key="prar.nombre" /></th>
							</tr>
						</thead>

						<tbody>
							<c:forEach items="${prbt.prarSalidaList}" var="prar">
								<tr>
									<td>${prar.nombre}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</c:if>

			<c:if test="${not empty prbt.pritEntradaList}">
				<div class="tab-pane" id="pritEntradaList">
					<table class="table table-condensed table-hover table-nonfluid">
						<thead>
							<tr>
								<th><fmt:message key="prit.itemId" /></th>
							</tr>
						</thead>

						<tbody>
							<c:forEach items="${prbt.pritEntradaList}" var="prit">
								<tr>
									<td><a
										href="${pageContext.request.contextPath}/servicio/srvc-detalle.action?srvc.id=${prit.itemId}">${prit.itemId}</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</c:if>

			<c:if test="${not empty prbt.pritSalidaList}">
				<div class="tab-pane" id="pritSalidaList">
					<table class="table table-condensed table-hover table-nonfluid">
						<thead>
							<tr>
								<th><fmt:message key="prit.itemId" /></th>
							</tr>
						</thead>

						<tbody>
							<c:forEach items="${prbt.pritSalidaList}" var="prit">
								<tr>
									<td><a
										href="${pageContext.request.contextPath}/servicio/srvc-detalle.action?srvc.id=${prit.itemId}">${prit.itemId}</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</c:if>
		</div>
	</div>
</body>
</html>
