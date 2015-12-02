angular.module("proceso_service", [ "crud_service" ])

.factory("ProcesoService", ProcesoService)

.factory("ProcesoMensajeService", ProcesoMensajeService)

;

function ProcesoService($http, $q, CrudService) {
	return CrudService.create("proceso/proceso");
}

function ProcesoMensajeService($http, $q, CrudService) {
	return CrudService.create("proceso/proceso-mensaje");
}

