angular.module("item_controller", [])

.config(config)

.controller("ItemTramiteDetailController", ItemTramiteDetailController)

.controller("ItemTramiteEditController", ItemTramiteEditController)

;

function config($routeProvider) {
    $routeProvider

    .when("/item/item-tramite/detail/:entiId/:id", {
        templateUrl : "modules/entidad/item/item-tramite-detail.html",
        controller : "ItemTramiteDetailController as vm",
    })

    .when("/item/item-tramite/edit/:accion/:entiId/:itemId/:trmtId/:id?", {
        templateUrl : "modules/entidad/item/item-tramite-edit.html",
        controller : "ItemTramiteEditController as vm",
    })

    ;
}

function ItemTramiteDetailController($routeParams, pageTitleService,
        ItemTramiteService) {
    var vm = this;

    vm.remove = remove;

    function remove() {
        ItemTramiteService.remove(vm.model).then(function(data) {
            window.history.back();
        });
    }

    vm.search = {
        id : $routeParams.id,
        trmt : {
            entiId : $routeParams.entiId
        }
    };

    ItemTramiteService.detail(vm.search).then(function(data) {
        vm.model = data.model;
        vm.item = data.item;
        vm.enti = data.enti;
        vm.trmt = data.trmt;
        vm.temporal = data.temporal;
        vm.tpdtEstadoId = data.tpdtEstadoId;
    });

    pageTitleService.setTitle("trmt", "page_detail");
}

function ItemTramiteEditController($route, $routeParams, pageTitleService,
        ItemTramiteService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        ItemTramiteService.save(vm.accion, vm.model).then(
                function(data) {
                    ItemTramiteService.redirectAfterSave(vm.accion, data.model,
                            "item-tramite-detail");
                });
    }

    function cancel() {
        window.history.back();
    }

    vm.accion = $routeParams.accion;
    vm.model = {
        itemId : $routeParams.itemId,
        trmt : {
            id : $routeParams.trmtId,
            entiId : $routeParams.entiId
        }
    }

    ItemTramiteService.edit(vm.accion, vm.model).then(function(data) {
        vm.model = data.model;
        vm.item = data.item;
        vm.enti = data.enti;
        vm.trmt = data.trmt;
        vm.prtoId = data.prtoId;
        vm.fechaVigencia = data.fechaVigencia;

        vm.labelValuesMap = data.labelValuesMap;
    });

    pageTitleService.setTitle("trmt", "page_" + vm.accion);
}
