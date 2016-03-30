(function() {
    'use strict';

    angular.module("item_controller", [ "item_service" ])

    .config(item_config)

    .controller("ItemTramiteDetailController", ItemTramiteDetailController)

    .controller("ItemTramiteEditController", ItemTramiteEditController)

    ;

    item_config.$inject = [ '$routeProvider' ];

    function item_config($routeProvider) {
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

    ItemTramiteDetailController.$inject = [ '$routeParams', 'pageTitleService', 'ItemTramiteService' ];

    function ItemTramiteDetailController($routeParams, pageTitleService, ItemTramiteService) {
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

    ItemTramiteEditController.$inject = [ '$routeParams', 'pageTitleService', 'ItemTramiteService' ];

    function ItemTramiteEditController($routeParams, pageTitleService, ItemTramiteService) {
        var vm = this;

        vm.save = save;
        vm.cancel = cancel;

        function save() {
            ItemTramiteService.save(vm.accion, vm.model).then(
                    function(data) {
                        ItemTramiteService.redirectAfterSave(vm.accion, '/item/item-tramite/detail', [
                                data.model.trmt.entiId, data.model.id ]);
                    });
        }

        function cancel() {
            window.history.back();
        }

        vm.accion = $routeParams.accion;
        vm.search = {
            itemId : $routeParams.itemId,
            trmt : {
                id : $routeParams.trmtId,
                entiId : $routeParams.entiId
            }
        };

        ItemTramiteService.edit(vm.accion, vm.search).then(function(data) {
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
})();