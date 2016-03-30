(function() {
    'use strict';

    angular.module("proceso_service", [ "crud_service" ])

    .factory("ProcesoService", ProcesoService)

    .factory("ProcesoMensajeService", ProcesoMensajeService)

    ;

    ProcesoService.$inject = [ '$http', '$q', 'CrudService' ];

    function ProcesoService($http, $q, CrudService) {
        return CrudService.create("proceso/proceso");
    }

    ProcesoMensajeService.$inject = [ '$http', '$q', 'CrudService' ];

    function ProcesoMensajeService($http, $q, CrudService) {
        return CrudService.create("proceso/proceso-mensaje");
    }
})();
