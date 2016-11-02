(function() {
    'use strict';

    angular.module("estadistica_service", [ "crud_service" ])

    .factory("PeriodoProcesoService", PeriodoProcesoService)

    .factory("CuadroMesService", CuadroMesService)

    .factory("EstadisticaService", EstadisticaService)

    ;

    /* @ngInject */
    function PeriodoProcesoService($http, $q, CrudService) {
        return CrudService.create("estadistica/periodo-proceso", "pepr");
    }

    /* @ngInject */
    function CuadroMesService($http, $q, CrudService) {
        return CrudService.create("estadistica/cuadro-mes", "cdms");
    }

    /* @ngInject */
    function EstadisticaService($http, $q, CrudService) {
        return CrudService.create("estadistica/estadistica", "estd");
    }
})();