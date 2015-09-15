angular.module("maestro_service", [ "crud_service" ])

.factory("MaestroService", MaestroService)

.factory("ParametroService", ParametroService)

.factory("SubparametroService", SubparametroService)

;

function MaestroService($http, $q, CrudService) {
    return CrudService.create("maestro/maestro");
}

function ParametroService($http, $q, CrudService) {
    return CrudService.create("maestro/parametro");
}

function SubparametroService($http, $q, CrudService) {
    return CrudService.create("maestro/subparametro");
}
