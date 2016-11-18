(function() {
    'use strict';

    angular.module("argo.proceso.service", [ "argo.common.crud.service" ])

    .factory("ProcesoService", ProcesoService)

    .factory("ProcesoMensajeService", ProcesoMensajeService)

    ;

    /* @ngInject */
    function ProcesoService($http, $q, CrudService) {
        return CrudService.create("proceso/proceso", "prbt");
    }

    /* @ngInject */
    function ProcesoMensajeService($http, $q, CrudService) {
        return CrudService.create("proceso/proceso-mensaje", "prmn");
    }
})();
