(function() {
    'use strict';

    angular.module("estadistica_controller", [ "estadistica_service" ])

    .config(estadistica_config)

    // -------------------- PERIODO DE PROCESO ------------------
    .controller("PeriodoProcesoGridController", PeriodoProcesoGridController)

    .controller("PeriodoProcesoDetailController", PeriodoProcesoDetailController)

    .controller("PeriodoProcesoEditController", PeriodoProcesoEditController)

    .controller("PeriodoProcesoLoadController", PeriodoProcesoLoadController)

    .controller("CuadroMesDetailController", CuadroMesDetailController)

    .controller("EstadisticaGridController", EstadisticaGridController)

    .controller("EstadisticaDetailController", EstadisticaDetailController)

    ;

    /* @ngInject */
    function estadistica_config($routeProvider) {
        $routeProvider

        .when("/estadistica/periodo-proceso/grid", {
            templateUrl : "modules/entidad/estadistica/periodo-proceso-grid.html",
            controller : "PeriodoProcesoGridController as vm",
            reloadOnSearch : false
        })

        .when("/estadistica/periodo-proceso/detail/:id", {
            templateUrl : "modules/entidad/estadistica/periodo-proceso-detail.html",
            controller : "PeriodoProcesoDetailController as vm",
        })

        .when("/estadistica/periodo-proceso/edit/:accion/:id?", {
            templateUrl : "modules/entidad/estadistica/periodo-proceso-edit.html",
            controller : "PeriodoProcesoEditController as vm",
        })

        .when("/estadistica/periodo-proceso/load", {
            templateUrl : "modules/entidad/estadistica/periodo-proceso-load.html",
            controller : "PeriodoProcesoLoadController as vm",
        })

        .when("/estadistica/cuadro-mes/detail/:peprId", {
            templateUrl : "modules/entidad/estadistica/cuadro-mes-detail.html",
            controller : "CuadroMesDetailController as vm",
        })

        .when("/estadistica/estadistica/grid/:entiId/:peprId/:autpId", {
            templateUrl : "modules/entidad/estadistica/estadistica-grid.html",
            controller : "EstadisticaGridController as vm",
            reloadOnSearch : false
        })

        .when("/estadistica/estadistica/detail/:entiId/:id", {
            templateUrl : "modules/entidad/estadistica/estadistica-detail.html",
            controller : "EstadisticaDetailController as vm"
        })

        ;
    }

    /* @ngInject */
    function PeriodoProcesoGridController($routeParams, pageTitleService, PeriodoProcesoService) {
        var vm = this;

        vm.filter = filter;
        vm.resetFilter = resetFilter;
        vm.search = search;
        vm.pageChanged = pageChanged;

        function filter() {
            PeriodoProcesoService.filter(vm.searchCriteria).then(function(data) {
                vm.sprtList = data.sprtList;
                vm.limits = data.limits;
            });
        }

        function resetFilter() {
            vm.searchCriteria = {};
        }

        function search(page) {
            PeriodoProcesoService.listPage(vm.searchCriteria, page, vm.limit).then(function(data) {
                vm.page = data.resultList.page;
                vm.limit = data.resultList.limit;
                vm.resultList = data.resultList;
            });
        }

        function pageChanged() {
            search(vm.page);
        }

        vm.searchCriteria = $routeParams.searchCriteria ? angular.fromJson($routeParams.searchCriteria) : {};
        vm.limit = $routeParams.limit;

        search($routeParams.page ? $routeParams.page : 1);

        pageTitleService.setTitle("pepr", "page_grid");
    }

    /* @ngInject */
    function PeriodoProcesoDetailController($routeParams, pageTitleService, PeriodoProcesoService) {
        var vm = this;

        vm.remove = remove;
        vm.fileExport = fileExport;

        function remove() {
            PeriodoProcesoService.remove(vm.model).then(function(data) {
                window.history.back();
            });
        }

        function fileExport() {
            PeriodoProcesoService.fileExport(vm.model, vm.model.arin.nombre);
        }

        vm.search = {
            id : $routeParams.id
        };

        PeriodoProcesoService.detail(vm.search).then(function(data) {
            vm.model = data.model;

            vm.tpesList = data.tpesList;
        });

        pageTitleService.setTitle("pepr", "page_detail");
    }

    /* @ngInject */
    function PeriodoProcesoEditController($routeParams, pageTitleService, PeriodoProcesoService) {
        var vm = this;

        vm.save = save;
        vm.cancel = cancel;

        function save() {
            PeriodoProcesoService.save(vm.accion, vm.model).then(function(data) {
                PeriodoProcesoService.redirectAfterSave(vm.accion, '/proceso/proceso/grid');
            });
        }

        function cancel() {
            window.history.back();
        }

        vm.accion = $routeParams.accion;
        vm.search = {
            id : $routeParams.id
        }

        PeriodoProcesoService.edit(vm.accion, vm.search).then(function(data) {
            vm.model = data.model;

            vm.sprtList = data.sprtList;
        });

        pageTitleService.setTitle("pepr", "page_" + vm.accion);
    }

    /* @ngInject */
    function PeriodoProcesoLoadController($routeParams, pageTitleService, PeriodoProcesoService) {
        var vm = this;

        vm.save = save;
        vm.cancel = cancel;

        function save() {
            PeriodoProcesoService.fileUpload(vm.fileLoad).then(function(data) {
                vm.model.archId = data.archId;

                PeriodoProcesoService.load(vm.model).then(function(data) {
                    PeriodoProcesoService.redirectAfterSave(vm.accion, '/proceso/proceso/grid');
                });
            });
        }

        function cancel() {
            window.history.back();
        }

        PeriodoProcesoService.loadPrepare().then(function(data) {
            vm.model = data.model;
        });

        pageTitleService.setTitle("pepr", "page_loadfile");
    }

    /* @ngInject */
    function CuadroMesDetailController($routeParams, pageTitleService, CuadroMesService) {
        var vm = this;

        vm.search = {
            id : $routeParams.peprId
        };

        CuadroMesService.detail(vm.search).then(function(data) {
            vm.pepr = data.model;
            vm.cdmsMap = data.cdmsMap;
        });

        pageTitleService.setTitle("cdms", "page_detail");
    }

    /* @ngInject */
    function EstadisticaGridController($routeParams, pageTitleService, EstadisticaService) {
        var vm = this;

        vm.filter = filter;
        vm.resetFilter = resetFilter;
        vm.search = search;
        vm.pageChanged = pageChanged;
        vm.xlsExport = xlsExport;

        function filter() {
            EstadisticaService.filter(vm.searchCriteria).then(function(data) {
                vm.labelValuesMap = data.labelValuesMap;
                vm.prtoList = data.prtoList;
                vm.limits = data.limits;
                vm.fechaVigencia = data.fechaVigencia;
            });
        }

        function resetFilter() {
            vm.searchCriteria = {
                entiId : $routeParams.entiId,
                pepr : {
                    id : $routeParams.peprId,
                    sprtId : $routeParams.autpId
                }
            };
        }

        function search(page) {
            EstadisticaService.listPage(vm.searchCriteria, page, vm.limit).then(function(data) {
                vm.page = data.resultList.page;
                vm.limit = data.resultList.limit;
                vm.itemList = data.resultList;
                vm.searchCriteria = data.model;
                vm.enti = data.enti;
            });
        }

        function pageChanged() {
            search(vm.page);
        }

        function xlsExport() {
            EstadisticaService.xlsExport(vm.searchCriteria, 'estd_' + vm.searchCriteria.entiId);
        }

        vm.searchCriteria = $routeParams.searchCriteria ? angular.fromJson($routeParams.searchCriteria) : {
            entiId : $routeParams.entiId,
            pepr : {
                id : $routeParams.peprId,
                sprtId : $routeParams.autpId
            }
        };

        vm.limit = $routeParams.limit;

        search($routeParams.page ? $routeParams.page : 1);

        pageTitleService.setTitleEnti($routeParams.entiId, "page_grid");
    }

    /* @ngInject */
    function EstadisticaDetailController($routeParams, pageTitleService, EstadisticaService) {
        var vm = this;

        vm.search = {
            id : $routeParams.id,
            entiId : $routeParams.entiId
        };

        EstadisticaService.detail(vm.search).then(function(data) {
            vm.item = data.model;
            vm.enti = data.enti;
        });

        pageTitleService.setTitleEnti($routeParams.entiId, "page_detail");
    }
})();