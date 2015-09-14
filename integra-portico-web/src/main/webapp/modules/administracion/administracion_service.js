angular.module("administracion_service", [ "crud_service" ])

.factory("AdministracionService", AdministracionService)

.factory("SuperpuertoService", SuperpuertoService)

.factory("PuertoService", PuertoService)

.factory("ConfigurationService", ConfigurationService)

.factory("MessageI18nService", MessageI18nService)

;

function AdministracionService($http, $q, CrudService) {
    return CrudService.create("administracion");
}

function SuperpuertoService($http, $q, CrudService) {
    return CrudService.create("administracion/puerto/superpuerto");
}

function PuertoService($http, $q, CrudService) {
    return CrudService.create("administracion/puerto/puerto");
}

function ConfigurationService($http, $q, CrudService) {
    return CrudService.create("administracion/configuration/configuration");
}

function MessageI18nService($http, $q, CrudService) {
    return CrudService.create("administracion/messagei18n/message-i18n");
}
