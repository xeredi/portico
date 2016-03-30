(function() {
    'use strict';

    angular.module("maestro_service", [ "crud_service" ])

    .factory("MaestroService", MaestroService)

    .factory("ParametroService", ParametroService)

    .factory("SubparametroService", SubparametroService)

    ;

    MaestroService.$inject = [ '$http', '$q', 'CrudService' ];

    function MaestroService($http, $q, CrudService) {
        return CrudService.create("maestro/maestro");
    }

    ParametroService.$inject = [ '$http', '$q', 'CrudService' ];

    function ParametroService($http, $q, CrudService) {
        return CrudService.create("maestro/parametro");
    }

    SubparametroService.$inject = [ '$http', '$q', 'CrudService' ];

    function SubparametroService($http, $q, CrudService) {
        return CrudService.create("maestro/subparametro");
    }
})();