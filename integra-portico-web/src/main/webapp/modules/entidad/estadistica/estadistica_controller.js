angular.module("estadistica_controller", [])

.config(config)

// -------------------- PERIODO DE PROCESO ------------------
.controller("PeriodoProcesoGridController", PeriodoProcesoGridController)

.controller("PeriodoProcesoDetailController", PeriodoProcesoDetailController)

.controller("PeriodoProcesoEditController", PeriodoProcesoEditController)

function config($routeProvider) {
    $routeProvider

            .when(
                    "/estadistica/periodo-proceso/grid",
                    {
                        templateUrl : "modules/entidad/estadistica/periodo-proceso-grid.html",
                        controller : "PeriodoProcesoGridController as vm",
                        reloadOnSearch : false
                    })

            .when(
                    "/estadistica/periodo-proceso/detail/:id",
                    {
                        templateUrl : "modules/entidad/estadistica/periodo-proceso-detail.html",
                        controller : "PeriodoProcesoDetailController as vm",
                    })

            .when(
                    "/estadistica/periodo-proceso/edit/:accion",
                    {
                        templateUrl : "modules/entidad/estadistica/periodo-proceso-edit.html",
                        controller : "PeriodoProcesoEditController as vm",
                    })

    ;
}

function PeriodoProcesoGridController($route, $routeParams, pageTitleService,
        PeriodoProcesoService) {
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
        PeriodoProcesoService.listPage(vm.searchCriteria, page, vm.limit).then(
                function(data) {
                    vm.page = data.resultList.page;
                    vm.limit = data.resultList.limit;
                    vm.resultList = data.resultList;
                });
    }

    function pageChanged() {
        search(vm.page);
    }

    vm.searchCriteria = $routeParams.searchCriteria ? angular
            .fromJson($routeParams.searchCriteria) : {};
    vm.limit = $routeParams.limit;

    search($routeParams.page ? $routeParams.page : 1);

    pageTitleService.setTitle("pepr", "page_grid");
}

function PeriodoProcesoDetailController($routeParams, pageTitleService,
        PeriodoProcesoService) {
    var vm = this;

    vm.remove = remove;

    function remove() {
        PeriodoProcesoService.remove(vm.model).then(function(data) {
            window.history.back();
        });
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

function PeriodoProcesoEditController($route, $routeParams, pageTitleService,
        PeriodoProcesoService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        PeriodoProcesoService.save(vm.accion, vm.model).then(
                function(data) {
                    PeriodoProcesoService.redirectAfterSave(vm.accion,
                            data.model, "periodo-proceso-detail");
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
