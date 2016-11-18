(function() {
    'use strict';

    angular.module("argo.estadistica.service", [ "argo.common.crud.service" ])

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