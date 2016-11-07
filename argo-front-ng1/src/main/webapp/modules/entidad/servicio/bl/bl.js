angular.module("bl", [])

.config(config)

.controller("BlResumenTotalesController", BlResumenTotalesController)

.service("BlService", BlService)

;

function config($routeProvider) {
    $routeProvider

    .when("/servicio/bl/resumen-totales/:id", {
        templateUrl : "modules/entidad/servicio/bl/resumen-totales.html",
        controller : "BlResumenTotalesController as vm"
    })

    ;
}

function BlResumenTotalesController($routeParams, pageTitleService, BlService) {
    var vm = this;

    vm.search = {
        id : $routeParams.id
    };

    BlService.resumenTotales(vm.search).then(function(data) {
        vm.model = data.model;
        vm.resumen = data.resumen;

        pageTitleService.setTitleEnti(vm.model.entiId, "bl_resumen_totales");
    });
}

function BlService($http, $q) {
    var vm = this;

    vm.resumenTotales = resumenTotales;

    function resumenTotales(id) {
        return $http.post("servicio/bl/resumen-totales.action", {model: id})
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