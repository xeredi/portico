angular.module("administracion_service", [ "crud_service" ])

.factory("AdministracionService", AdministracionService)

.factory("ConfiguracionService", ConfiguracionService)

.factory("MessageI18nService", MessageI18nService)

.factory("PuertoService", PuertoService)

.factory("SuperpuertoService", SuperpuertoService)

;

function AdministracionService($http, $q, CrudService) {
    return CrudService.create("administracion");
}

function ConfiguracionService($http, $q, CrudService) {
    return CrudService.create("administracion/configuracion/configuracion");
}

function MessageI18nService($http, $q, CrudService) {
    return CrudService.create("administracion/messagei18n/messagei18n");
}

function PuertoService($http, $q, CrudService) {
    return CrudService.create("administracion/puerto/puerto");
}

function SuperpuertoService($http, $q, CrudService) {
    return CrudService.create("administracion/puerto/superpuerto");
}
