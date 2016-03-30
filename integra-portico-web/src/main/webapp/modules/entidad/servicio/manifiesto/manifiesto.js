angular.module("manifiesto", [])

.config(config)

.controller("ManifiestoResumenTotalesController", ManifiestoResumenTotalesController)

.service("ManifiestoService", ManifiestoService)

;

function config($routeProvider) {
    $routeProvider

    .when("/servicio/manifiesto/resumen-totales/:id", {
        templateUrl : "modules/entidad/servicio/manifiesto/resumen-totales.html",
        controller : "ManifiestoResumenTotalesController as vm",
    })

    ;
}

function ManifiestoResumenTotalesController($routeParams, pageTitleService, ManifiestoService) {
    var vm = this;

    vm.search = {
        id : $routeParams.id
    };

    ManifiestoService.resumenTotales(vm.search).then(function(data) {
        vm.model = data.model;
        vm.resumen = data.resumen;

        pageTitleService.setTitleEnti(vm.model.entiId, "mani_resumen_totales");
    });
}

function ManifiestoService($http, $q) {
    var vm = this;

    vm.resumenTotales = resumenTotales;

    function resumenTotales(id) {
        return $http.post("servicio/manifiesto/resumen-totales.action", {model: id})
            .then(success)
            .catch(fail);

        function success(response) {
            return response.data;
        }

        function fail(error) {
            var msg = 'resumenTotales failed. ' + error.data;
            console.log(msg);

            return $q.reject(msg);
        }
    }
}