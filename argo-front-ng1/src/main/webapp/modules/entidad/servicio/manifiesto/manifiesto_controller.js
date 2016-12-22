(function() {
    'use strict';

    angular.module("argo.servicio.manifiesto.controller", [ "argo.servicio.manifiesto.service" ])

    .config(manifiesto_config)

    .controller("ManifiestoResumenController", ManifiestoResumenController)

    .controller("BlResumenController", BlResumenController)

    ;

    /* @ngInject */
    function manifiesto_config($routeProvider) {
        $routeProvider

        .when("/servicio/manifiesto/manifiesto-resumen/:id", {
            templateUrl : "modules/entidad/servicio/manifiesto/manifiesto-resumen.html",
            controller : "ManifiestoResumenController as vm"
        })

        .when("/servicio/manifiesto/bl-resumen/:id", {
            templateUrl : "modules/entidad/servicio/manifiesto/bl-resumen.html",
            controller : "BlResumenController as vm"
        })

        ;
    }

    /* @ngInject */
    function ManifiestoResumenController($routeParams, pageTitleService, ManifiestoService) {
        var vm = this;

        vm.search = {
            id : $routeParams.id
        };

        ManifiestoService.resumen(vm.search).then(function(data) {
            vm.model = data.model;
            vm.resumen = data.resumen;

            pageTitleService.setTitleEnti(vm.model.entiId, "mani_resumen_totales");
        });
    }

    /* @ngInject */
    function BlResumenController($routeParams, pageTitleService, BlService) {
        var vm = this;

        vm.search = {
            id : $routeParams.id
        };

        BlService.resumen(vm.search).then(function(data) {
            vm.model = data.model;
            vm.resumen = data.resumen;

            pageTitleService.setTitleEnti(vm.model.entiId, "bl_resumen_totales");
        });
    }
})();