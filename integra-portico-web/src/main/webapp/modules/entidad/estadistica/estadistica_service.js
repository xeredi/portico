angular.module("estadistica_service", [ "crud_service" ])

.factory("PeriodoProcesoService", PeriodoProcesoService)

.factory("CuadroMesService", CuadroMesService)

.factory("EstadisticaService", EstadisticaService)

;

function PeriodoProcesoService($http, $q, CrudService) {
    return CrudService.create("estadistica/periodo-proceso");
}

function CuadroMesService($http, $q, CrudService) {
    return CrudService.create("estadistica/cuadro-mes");
}

function EstadisticaService($http, $q, CrudService) {
    return CrudService.create("estadistica/estadistica");
}
