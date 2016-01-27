angular.module("estadistica_service", [ "crud_service" ])

.factory("PeriodoProcesoService", PeriodoProcesoService)

.factory("EstadisticaService", EstadisticaService)

;

function PeriodoProcesoService($http, $q, CrudService) {
    return CrudService.create("estadistica/periodo-proceso");
}

function EstadisticaService($http, $q, CrudService) {
    return CrudService.create("estadistica/estadistica");
}
