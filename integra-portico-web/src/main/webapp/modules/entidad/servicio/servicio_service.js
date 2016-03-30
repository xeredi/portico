(function() {
    'use strict';

    angular.module("servicio_service", [ "crud_service" ])

    .factory("ValoradorService", ValoradorService)

    .factory("ServicioSecuenciaService", ServicioSecuenciaService)

    .factory("ServicioService", ServicioService)

    .factory("SubservicioService", SubservicioService)

    ;

    /* @ngInject */
    function ValoradorService($http, $q, CrudService) {
        return CrudService.create("servicio/valorador");
    }

    /* @ngInject */
    function ServicioSecuenciaService($http, $q, CrudService) {
        return CrudService.create("servicio/servicio-secuencia");
    }

    /* @ngInject */
    function ServicioService($http, $q, CrudService) {
        return CrudService.create("servicio/servicio");
    }

    /* @ngInject */
    function SubservicioService($http, $q, CrudService) {
        return CrudService.create("servicio/subservicio");
    }
})();