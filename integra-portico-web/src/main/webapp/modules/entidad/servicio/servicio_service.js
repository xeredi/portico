angular.module("servicio_service", [ "crud_service" ])

.factory("ServicioSecuenciaService", ServicioSecuenciaService)

.factory("ServicioService", ServicioService)

.factory("SubservicioService", SubservicioService)

;

function ServicioSecuenciaService($http, $q, CrudService) {
    return CrudService.create("servicio/servicio-secuencia");
}

function ServicioService($http, $q, CrudService) {
    return CrudService.create("servicio/servicio");
}

function SubservicioService($http, $q, CrudService) {
    return CrudService.create("servicio/subservicio");
}
