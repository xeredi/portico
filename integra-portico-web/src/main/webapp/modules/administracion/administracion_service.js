(function() {
    'use strict';

    angular.module("administracion_service", [ "crud_service" ])

    .factory("AdministracionService", AdministracionService)

    .factory("SuperpuertoService", SuperpuertoService)

    .factory("PuertoService", PuertoService)

    .factory("ConfigurationService", ConfigurationService)

    .factory("MessageI18nService", MessageI18nService)

    ;

    /* @ngInject */
    function AdministracionService($http, $q, CrudService) {
        return CrudService.create("administracion");
    }

    /* @ngInject */
    function SuperpuertoService($http, $q, CrudService) {
        return CrudService.create("administracion/puerto/superpuerto");
    }

    /* @ngInject */
    function PuertoService($http, $q, CrudService) {
        return CrudService.create("administracion/puerto/puerto");
    }

    /* @ngInject */
    function ConfigurationService($http, $q, CrudService) {
        return CrudService.create("administracion/configuration/configuration");
    }

    /* @ngInject */
    function MessageI18nService($http, $q, CrudService) {
        return CrudService.create("administracion/messagei18n/message-i18n");
    }
})();