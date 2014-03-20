<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<fmt:message key="format.integer" var="integerPattern" scope="page" />
<div class="row">
	<div class="col-md-6">
		<div class="form-horizontal">
			<fieldset>
				<legend>
					<fmt:message key="mani.resumen.mercancias" />
				</legend>
				<div class="form-group">
					<label class="col-md-8 control-label"><fmt:message key="mani.resumen.numBlsMercancia" /></label>
					<p align="right" class="col-md-2 form-control-static">
						<fmt:formatNumber pattern="${integerPattern}" value="${resumen.numBlsMercancia}" />
					</p>
				</div>
				<div class="form-group">
					<label class="col-md-8 control-label"><fmt:message
							key="mani.resumen.numPartidasMercancia" /></label>
					<p align="right" class="col-md-2 form-control-static">
						<fmt:formatNumber pattern="${integerPattern}" value="${resumen.numPartidasMercancia}" />
					</p>
				</div>
				<div class="form-group">
					<label class="col-md-8 control-label"><fmt:message
							key="mani.resumen.pesoPartidasMercancia" /></label>
					<p align="right" class="col-md-2 form-control-static">
						<fmt:formatNumber pattern="${integerPattern}" value="${resumen.pesoPartidasMercancia}" />
					</p>
				</div>
				<div class="form-group">
					<label class="col-md-8 control-label"><fmt:message key="mani.resumen.numContenedores20" /></label>
					<p align="right" class="col-md-2 form-control-static">
						<fmt:formatNumber pattern="${integerPattern}"
							value="${resumen.numContenedores20Llenos + resumen.numContenedores20Vacios}" />
					</p>
				</div>
				<div class="form-group">
					<label class="col-md-8 control-label"><fmt:message
							key="mani.resumen.numContenedores20Llenos" /></label>
					<p align="right" class="col-md-2 form-control-static">
						<fmt:formatNumber pattern="${integerPattern}" value="${resumen.numContenedores20Llenos}" />
					</p>
				</div>
				<div class="form-group">
					<label class="col-md-8 control-label"><fmt:message
							key="mani.resumen.numContenedores20Vacios" /></label>
					<p align="right" class="col-md-2 form-control-static">
						<fmt:formatNumber pattern="${integerPattern}" value="${resumen.numContenedores20Vacios}" />
					</p>
				</div>
				<div class="form-group">
					<label class="col-md-8 control-label"><fmt:message key="mani.resumen.numContenedores40" /></label>
					<p align="right" class="col-md-2 form-control-static">
						<fmt:formatNumber pattern="${integerPattern}"
							value="${resumen.numContenedores40Llenos + resumen.numContenedores40Vacios}" />
					</p>
				</div>
				<div class="form-group">
					<label class="col-md-8 control-label"><fmt:message
							key="mani.resumen.numContenedores40Llenos" /></label>
					<p align="right" class="col-md-2 form-control-static">
						<fmt:formatNumber pattern="${integerPattern}" value="${resumen.numContenedores40Llenos}" />
					</p>
				</div>
				<div class="form-group">
					<label class="col-md-8 control-label"><fmt:message
							key="mani.resumen.numContenedores40Vacios" /></label>
					<p align="right" class="col-md-2 form-control-static">
						<fmt:formatNumber pattern="${integerPattern}" value="${resumen.numContenedores40Vacios}" />
					</p>
				</div>
				<div class="form-group">
					<label class="col-md-8 control-label"><fmt:message key="mani.resumen.numEquipamientos" /></label>
					<p align="right" class="col-md-2 form-control-static">
						<fmt:formatNumber pattern="${integerPattern}"
							value="${resumen.numEquipamientosLlenos + resumen.numEquipamientosVacios}" />
					</p>
				</div>
				<div class="form-group">
					<label class="col-md-8 control-label"><fmt:message
							key="mani.resumen.numEquipamientosLlenos" /></label>
					<p align="right" class="col-md-2 form-control-static">
						<fmt:formatNumber pattern="${integerPattern}" value="${resumen.numEquipamientosLlenos}" />
					</p>
				</div>
				<div class="form-group">
					<label class="col-md-8 control-label"><fmt:message
							key="mani.resumen.numEquipamientosVacios" /></label>
					<p align="right" class="col-md-2 form-control-static">
						<fmt:formatNumber pattern="${integerPattern}" value="${resumen.numEquipamientosVacios}" />
					</p>
				</div>
			</fieldset>
		</div>
	</div>
	<div class="col-md-6">
		<div class="form-horizontal">
			<fieldset>
				<legend>
					<fmt:message key="mani.resumen.pasajeros" />
				</legend>
				<div class="form-group">
					<label class="col-md-8 control-label"><fmt:message key="mani.resumen.numBlsPasajeros" /></label>
					<p align="right" class="col-md-2 form-control-static">
						<fmt:formatNumber pattern="${integerPattern}" value="${resumen.numBlsPasajeros}" />
					</p>
				</div>
				<div class="form-group">
					<label class="col-md-8 control-label"><fmt:message
							key="mani.resumen.numPartidasPasajeros" /></label>
					<p align="right" class="col-md-2 form-control-static">
						<fmt:formatNumber pattern="${integerPattern}" value="${resumen.numPartidasPasajeros}" />
					</p>
				</div>
				<div class="form-group">
					<label class="col-md-8 control-label"><fmt:message key="mani.resumen.numPasajeros" /></label>
					<p align="right" class="col-md-2 form-control-static">
						<fmt:formatNumber pattern="${integerPattern}" value="${resumen.numPasajeros}" />
					</p>
				</div>
				<div class="form-group">
					<label class="col-md-8 control-label"><fmt:message key="mani.resumen.numCruceristas" /></label>
					<p align="right" class="col-md-2 form-control-static">
						<fmt:formatNumber pattern="${integerPattern}" value="${resumen.numCruceristas}" />
					</p>
				</div>
				<div class="form-group">
					<label class="col-md-8 control-label"><fmt:message key="mani.resumen.numVehiculos" /></label>
					<p align="right" class="col-md-2 form-control-static">
						<fmt:formatNumber pattern="${integerPattern}" value="${resumen.numVehiculos}" />
					</p>
				</div>
			</fieldset>
		</div>
	</div>
</div>
