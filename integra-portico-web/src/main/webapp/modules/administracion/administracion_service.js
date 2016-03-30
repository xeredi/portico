(function() {
    'use strict';

    angular.module("administracion_service", [ "crud_service" ])

    .factory("AdministracionService", AdministracionService)

    .factory("SuperpuertoService", SuperpuertoService)

    .factory("PuertoService", PuertoService)

    .factory("ConfigurationService", ConfigurationService)

    .factory("MessageI18nService", MessageI18nService)

    ;

    AdministracionService.$inject = [ '$http', '$q', 'CrudService' ];

    function AdministracionService($http, $q, CrudService) {
        return CrudService.create("administracion");
    }

    SuperpuertoService.$inject = [ '$http', '$q', 'CrudService' ];

    function SuperpuertoService($http, $q, CrudService) {
        return CrudService.create("administracion/puerto/superpuerto");
    }

    PuertoService.$inject = [ '$http', '$q', 'CrudService' ];

    function PuertoService($http, $q, CrudService) {
        return CrudService.create("administracion/puerto/puerto");
    }

    ConfigurationService.$inject = [ '$http', '$q', 'CrudService' ];

    function ConfigurationService($http, $q, CrudService) {
        return CrudService.create("administracion/configuration/configuration");
    }

    MessageI18nService.$inject = [ '$http', '$q', 'CrudService' ];

    function MessageI18nService($http, $q, CrudService) {
        return CrudService.create("administracion/messagei18n/message-i18n");
    }
})();