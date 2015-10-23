angular.module("estadistica_service", [ "crud_service" ])

.factory("PeriodoProcesoService", PeriodoProcesoService)

;

function PeriodoProcesoService($http, $q, CrudService) {
	return CrudService.create("estadistica/periodo-proceso");
}
