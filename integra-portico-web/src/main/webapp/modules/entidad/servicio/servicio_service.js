angular.module("servicio_service", [ "crud_service" ])

.factory("ServicioSecuenciaService", ServicioSecuenciaService)

;

function ServicioSecuenciaService($http, $q, CrudService) {
    return CrudService.create("servicio/servicio-secuencia");
}
