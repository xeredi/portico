angular.module("seguridad_service", [ "crud_service" ])

.factory("UsuarioService", UsuarioService)

.factory("AccionService", AccionService)

.factory("GrupoService", GrupoService)

;

function UsuarioService($http, $q, CrudService) {
    var service = CrudService.create("seguridad/usuario");

    service.acceso = function(usuario) {
        console.log('acceso');

        return $http.post(service.getUri() + "-acceso.action", {model: usuario})
            .then(success)
            .catch(fail);

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

        return $http.post(service.getUri() + "-salir.action")
            .then(success)
            .catch(fail);

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

function AccionService($http, $q, CrudService) {
    var service = CrudService.create("seguridad/accion");

    return service;
}

function GrupoService($http, $q, CrudService) {
    var service = CrudService.create("seguridad/grupo");

    return service;
}
