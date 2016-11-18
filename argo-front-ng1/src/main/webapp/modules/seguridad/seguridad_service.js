(function() {
    'use strict';

    angular.module("argo.seguridad.service", [ "argo.common.crud.service" ])

    .factory("UsuarioService", UsuarioService)

    .factory("GrupoService", GrupoService)

    ;

    /* @ngInject */
    function UsuarioService($http, $q, CrudService) {
        var service = CrudService.create("seguridad/usuario", "usro");

        service.acceso = function(usuario) {
            console.log('acceso');

            return $http.post(service.getUri() + "-acceso.action", {
                model : usuario
            }).then(success, fail);

            function success(response) {
                return response.data;
            }

            function fail(error) {
                var msg = 'Acceso failed. ' + error.data;
                console.log(msg);

                return $q.reject(msg);
            }
        };

        service.salir = function(usuario) {
            console.log('salir');

            return $http.post(service.getUri() + "-salir.action").then(success, fail);

            function success(response) {
                return response.data;
            }

            function fail(error) {
                var msg = 'Salir failed. ' + error.data;
                console.log(msg);

                return $q.reject(msg);
            }
        };

        return service;
    }

    /* @ngInject */
    function GrupoService($http, $q, CrudService) {
        return CrudService.create("seguridad/grupo", "grpo");
    }
})();
