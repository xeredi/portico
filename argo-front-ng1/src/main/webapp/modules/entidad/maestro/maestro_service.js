(function() {
    'use strict';

    angular.module("maestro_service", [ "crud_service" ])

    .factory("MaestroService", MaestroService)

    .factory("ParametroService", ParametroService)

    .factory("SubparametroService", SubparametroService)

    ;

    /* @ngInject */
    function MaestroService($http, $q, CrudService) {
        return CrudService.create("maestro/maestro");
    }

    /* @ngInject */
    function ParametroService($http, $q, CrudService) {
        return CrudService.create("maestro/parametro", "prmt");
    }

    /* @ngInject */
    function SubparametroService($http, $q, CrudService) {
        return CrudService.create("maestro/subparametro", "sprm");
    }
})();