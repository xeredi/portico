angular.module("item", [])

.config(config)

// ----------- Tramites ------------------
.controller("IttrDetailController", IttrDetailController)

.controller("IttrEditController", IttrEditController)

;

function config($routeProvider) {
    $routeProvider

    .when("/item/ittr/detail/:id", {
        templateUrl : "modules/entidad/item/ittr-detail.html",
        controller : "IttrDetailController as vm"
    })

    .when("/item/ittr/edit/:accion/:entiId/:itemId/:trmtId", {
        templateUrl : "modules/entidad/item/ittr-edit.html",
        controller : "IttrEditController as vm"
    })

    ;
}

function IttrDetailController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    initialize();

    function initialize() {
        $http.post("item/item-tramite-detail.action", {
            model : {
                id : $routeParams.id
            }
        }).success(function(data) {
            vm.ittr = data.model;
            vm.item = data.item;
            vm.enti = data.enti;
            vm.trmt = data.trmt;
            vm.temporal = data.temporal;
            vm.tpdtEstadoId = data.tpdtEstadoId;
            vm.fechaVigencia = data.fechaVigencia;
        });

        pageTitleService.setTitle("trmt", "page_detail");
    }
}

function IttrEditController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    initialize();

    function initialize() {
        vm.accion = $routeParams.accion;

        $http.post("item/item-tramite-edit.action", {
            model : {
                itemId : $routeParams.itemId,
                trmt : {
                    id : $routeParams.trmtId,
                    entiId : $routeParams.entiId
                }
            },
            accion : vm.accion
        }).success(function(data) {
            vm.ittr = data.model;
            vm.item = data.item;
            vm.enti = data.enti;
            vm.trmt = data.trmt;
            vm.prtoId = data.prtoId;
            vm.fechaVigencia = data.fechaVigencia;
            vm.labelValuesMap = data.labelValuesMap;
        });

        pageTitleService.setTitle("trmt", "page_" + vm.accion);
    }

    function save() {
        $http.post("item/item-tramite-save.action", {
            model : vm.ittr,
            accion : vm.accion
        }).success(function(data) {
            setTimeout(function() {
                window.history.back();
            }, 0);
        });
    }

    function cancel() {
        window.history.back();
    }
}
