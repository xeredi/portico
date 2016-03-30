(function() {
    'use strict';

    angular.module("estadistica_service", [ "crud_service" ])

    .factory("PeriodoProcesoService", PeriodoProcesoService)

    .factory("CuadroMesService", CuadroMesService)

    .factory("EstadisticaService", EstadisticaService)

    ;

    PeriodoProcesoService.$inject = [ '$http', '$q', 'CrudService' ];

    function PeriodoProcesoService($http, $q, CrudService) {
        return CrudService.create("estadistica/periodo-proceso");
    }

    CuadroMesService.$inject = [ '$http', '$q', 'CrudService' ];

    function CuadroMesService($http, $q, CrudService) {
        return CrudService.create("estadistica/cuadro-mes");
    }

    EstadisticaService.$inject = [ '$http', '$q', 'CrudService' ];

    function EstadisticaService($http, $q, CrudService) {
        return CrudService.create("estadistica/estadistica");
    }
})();