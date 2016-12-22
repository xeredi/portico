(function() {
    'use strict';

    angular.module("argo.servicio.manifiesto.service", [ "argo.common.crud.service" ])

    .factory("ManifiestoService", ManifiestoService)

    .factory("BlService", BlService)

    ;

    /* @ngInject */
    function ManifiestoService($http, $q, CrudService) {
        var service = CrudService.create("servicio/manifiesto/manifiesto", "aces");

        service.resumen = function(id) {
            return $http.post(service.getUri() + "-resumen.action", {
                model : id,
                prefix : service.getPrefix()
            }).then(success, fail);

            function success(response) {
                return response.data;
            }

            function fail(error) {
                var msg = 'Resumen failed. ' + error.data;
                console.log(msg);

                return $q.reject(msg);
            }
        };

        return service;
    }

    /* @ngInject */
    function BlService($http, $q, CrudService) {
        var service = CrudService.create("servicio/manifiesto/bl", "aces");

        service.resumen = function(id) {
            return $http.post(service.getUri() + "-resumen.action", {
                model : id,
                prefix : service.getPrefix()
            }).then(success, fail);

            function success(response) {
                return response.data;
            }

            function fail(error) {
                var msg = 'Resumen failed. ' + error.data;
                console.log(msg);

                return $q.reject(msg);
            }
        };

        return service;
    }
})();
