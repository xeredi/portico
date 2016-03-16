angular.module("facturacion", [])

.config(config)

.controller("VlrlDepEditController", VlrlDepEditController)

;

function config($routeProvider) {
    $routeProvider

    .when("/facturacion/vlrldep/edit/create/:vlrcId/:vlrlId", {
        templateUrl : "modules/facturacion/vlrl-edit.html",
        controller : "VlrlDepEditController as vm"
    })

    ;
}

function VlrlDepEditController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    initialize();

    function initialize() {
        vm.accion = $routeParams.accion;

        $http.post("facturacion/valoracion-linea-edit.action", {
            model : {
                vlrcId : $routeParams.vlrcId,
                id : $routeParams.vlrlId
            },
            accion : vm.accion
        }).success(function(data) {
            vm.vlrl = data.model;
            vm.vlrlPadre = data.vlrlPadre;
            vm.aspc = data.aspc;
            vm.impuestoList = data.impuestoList;
        });

        pageTitleService.setTitle("vlrl", "page_" + vm.accion);
    }

    function save() {
        $http.post("facturacion/valoracion-linea-save.action", {
            model : vm.vlrl,
            accion : vm.accion
        }).success(
                function(data) {
                    vm.accion == 'edit' ? setTimeout(function() {
                        window.history.back();
                    }, 0) : $location.path(
                            "/facturacion/vlrl/detail/" + data.model.vlrcId + "/" + data.model.id).replace();
                });
    }

    function cancel() {
        window.history.back();
    }
}
