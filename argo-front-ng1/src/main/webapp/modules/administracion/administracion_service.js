(function() {
    'use strict';

    angular.module("argo.administracion.service", [ "argo.common.crud.service" ])

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
        return CrudService.create("administracion/puerto/superpuerto", "sprt");
    }

    /* @ngInject */
    function PuertoService($http, $q, CrudService) {
        return CrudService.create("administracion/puerto/puerto", "prto");
    }

    /* @ngInject */
    function ConfigurationService($http, $q, CrudService) {
        return CrudService.create("administracion/configuration/configuration", "conf");
    }

    /* @ngInject */
    function MessageI18nService($http, $q, CrudService) {
        return CrudService.create("administracion/messagei18n/message-i18n", "m18n");
    }
})();