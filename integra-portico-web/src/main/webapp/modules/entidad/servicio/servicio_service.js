(function() {
    'use strict';

    angular.module("servicio_service", [ "crud_service" ])

    .factory("ValoradorService", ValoradorService)

    .factory("ServicioSecuenciaService", ServicioSecuenciaService)

    .factory("ServicioService", ServicioService)

    .factory("SubservicioService", SubservicioService)

    ;

    ValoradorService.$inject = [ '$http', '$q', 'CrudService' ];

    function ValoradorService($http, $q, CrudService) {
        return CrudService.create("servicio/valorador");
    }

    ServicioSecuenciaService.$inject = [ '$http', '$q', 'CrudService' ];

    function ServicioSecuenciaService($http, $q, CrudService) {
        return CrudService.create("servicio/servicio-secuencia");
    }

    ServicioService.$inject = [ '$http', '$q', 'CrudService' ];

    function ServicioService($http, $q, CrudService) {
        return CrudService.create("servicio/servicio");
    }

    SubservicioService.$inject = [ '$http', '$q', 'CrudService' ];

    function SubservicioService($http, $q, CrudService) {
        return CrudService.create("servicio/subservicio");
    }
})();