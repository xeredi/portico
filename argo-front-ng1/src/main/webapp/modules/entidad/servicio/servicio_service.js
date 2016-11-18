(function() {
    'use strict';

    angular.module("argo.servicio.service", [ "argo.common.crud.service" ])

    .factory("ValoradorService", ValoradorService)

    .factory("ServicioSecuenciaService", ServicioSecuenciaService)

    .factory("ServicioService", ServicioService)

    .factory("SubservicioService", SubservicioService)

    ;

    /* @ngInject */
    function ValoradorService($http, $q, CrudService) {
        return CrudService.create("servicio/valorador", "vldr");
    }

    /* @ngInject */
    function ServicioSecuenciaService($http, $q, CrudService) {
        return CrudService.create("servicio/servicio-secuencia", "srsc");
    }

    /* @ngInject */
    function ServicioService($http, $q, CrudService) {
        return CrudService.create("servicio/servicio", "srvc");
    }

    /* @ngInject */
    function SubservicioService($http, $q, CrudService) {
        return CrudService.create("servicio/subservicio", "ssrv");
    }
})();