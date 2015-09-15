angular.module("facturacion_controller", [])

.config(config)

// -------------------- Inicio Facturacion ------------------
.controller("FacturacionIndexController", FacturacionIndexController)

// -------------------- Parametrizacion ------------------
.controller("CargoGridController", CargoGridController)

.controller("CargoDetailController", CargoDetailController)

.controller("CargoEditController", CargoEditController)

.controller("ReglaDetailController", ReglaDetailController)

.controller("ReglaIncompatibleDetailController", ReglaIncompatibleDetailController)

.controller("AspectoGridController", AspectoGridController)

.controller("AspectoDetailController", AspectoDetailController)

.controller("AspectoCargoDetailController", AspectoCargoDetailController)

// -------------------- Gestion ------------------

;

function config($stateProvider) {
    $stateProvider

    // -------------------- Inicio Facturacion ------------------
    .state("facturacion-index", {
        url : "/facturacion/facturacion/index",
        templateUrl : "modules/facturacion/facturacion.html",
        controller : "FacturacionIndexController as vm",
        reloadOnSearch : false
    })

    // -------------------- Parametrizacion ------------------
    .state("cargo-grid", {
        url : "/facturacion/cargo/grid?page&searchCriteria&limit",
        templateUrl : "modules/facturacion/cargo-grid.html",
        controller : "CargoGridController as vm",
        reloadOnSearch : false
    })

    .state("cargo-detail", {
        url : "/facturacion/cargo/detail/:id?fref",
        templateUrl : "modules/facturacion/cargo-detail.html",
        controller : "CargoDetailController as vm",
    })

    .state("cargo-edit", {
        url : "/facturacion/cargo/edit/:accion?id&fref",
        templateUrl : "modules/facturacion/cargo-edit.html",
        controller : "CargoEditController as vm",
    })

    .state("regla-detail", {
        url : "/facturacion/regla/detail/:id?fref",
        templateUrl : "modules/facturacion/regla-detail.html",
        controller : "ReglaDetailController as vm",
    })

    .state("regla-incompatible-detail", {
        url : "/facturacion/regla-incompatible/detail/:id?fref",
        templateUrl : "modules/facturacion/regla-incompatible-detail.html",
        controller : "ReglaIncompatibleDetailController as vm",
    })

    .state("aspecto-grid", {
        url : "/facturacion/aspecto/grid?page&searchCriteria&limit",
        templateUrl : "modules/facturacion/aspecto-grid.html",
        controller : "AspectoGridController as vm",
        reloadOnSearch : false
    })

    .state("aspecto-detail", {
        url : "/facturacion/aspecto/detail/:id?fref",
        templateUrl : "modules/facturacion/aspecto-detail.html",
        controller : "AspectoDetailController as vm",
    })

    .state("aspecto-cargo-detail", {
        url : "/facturacion/aspecto-cargo/detail/:id?fref",
        templateUrl : "modules/facturacion/aspecto-cargo-detail.html",
        controller : "AspectoCargoDetailController as vm",
    })

    // -------------------- Gestion ------------------

    ;
}

// -------------------- Inicio Facturacion ------------------
function FacturacionIndexController($state, $stateParams, $modal, pageTitleService, FacturacionService) {
    var vm = this;

    FacturacionService.index().then(function(data) {
    });

    pageTitleService.setTitle("sec_facturacion", "page_home");
}

// -------------------- Parametrizacion ------------------
function CargoGridController($state, $stateParams, $modal, pageTitleService, CargoService) {
    var vm = this;

    vm.filter = filter;
    vm.resetFilter = resetFilter;
    vm.search = search;
    vm.pageChanged = pageChanged;

    function filter() {
        CargoService.filter(vm.searchCriteria).then(function(data) {
            vm.tpsrList = data.tpsrList;
        });
    }

    function resetFilter() {
        vm.searchCriteria = {};
    }

    function search(page) {
        CargoService.listPage(vm.searchCriteria, page, vm.limit).then(function(data) {
            vm.page = data.resultList.page;
            vm.limit = data.resultList.limit;
            vm.crgoList = data.resultList;
        });
    }

    function pageChanged() {
        search(vm.page);
    }

    vm.searchCriteria = $stateParams.searchCriteria ? angular.fromJson($stateParams.searchCriteria) : {};
    vm.limit = $stateParams.limit;

    search($stateParams.page ? $stateParams.page : 1);

    pageTitleService.setTitle("crgo", "page_grid");
}

function CargoDetailController($stateParams, pageTitleService, CargoService) {
    var vm = this;

    vm.remove = remove;

    function remove() {
        CargoService.remove(vm.crgo).then(function(data) {
            window.history.back();
        });
    }

    vm.crgo = {
        id : $stateParams.id,
        fref : $stateParams.fref
    };

    CargoService.detail(vm.crgo).then(function(data) {
        vm.crgo = data.model;
        vm.i18nMap = data.i18nMap;

        vm.rglaList = data.rglaList;
    });

    pageTitleService.setTitle("crgo", "page_detail");
}

function CargoEditController($state, $stateParams, pageTitleService, CargoService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        CargoService.saveI18n(vm.accion, vm.crgo, vm.i18nMap).then(function(data) {
            vm.accion == 'edit' ? setTimeout(function() {
                window.history.back();
            }, 0) : $state.go("cargo-detail", data.model, {
                location : 'replace'
            });
        });
    }

    function cancel() {
        window.history.back();
    }

    vm.accion = $stateParams.accion;
    vm.crgo = {
        id : $stateParams.id,
        fref : $stateParams.fref
    }

    CargoService.edit($stateParams.accion, vm.crgo).then(function(data) {
        vm.crgo = data.model;
        vm.i18nMap = data.i18nMap;

        vm.tipos = data.tipos;
        vm.tpsrList = data.tpsrList;
    });

    pageTitleService.setTitle("crgo", "page_" + vm.accion);
}

function ReglaDetailController($stateParams, pageTitleService, ReglaService) {
    var vm = this;

    vm.remove = remove;

    function remove() {
        ReglaService.remove(vm.rgla).then(function(data) {
            window.history.back();
        });
    }

    vm.rgla = {
        id : $stateParams.id,
        fref : $stateParams.fref
    };

    ReglaService.detail(vm.rgla).then(function(data) {
        vm.rgla = data.model;

        vm.rginList = data.rginList;
    });

    pageTitleService.setTitle("rgla", "page_detail");
}

function ReglaIncompatibleDetailController($stateParams, pageTitleService, ReglaIncompatibleService) {
    var vm = this;

    vm.remove = remove;

    function remove() {
        ReglaIncompatibleService.remove(vm.rgin).then(function(data) {
            window.history.back();
        });
    }

    vm.rgin = {
        id : $stateParams.id,
        fref : $stateParams.fref
    };

    ReglaIncompatibleService.detail(vm.rgin).then(function(data) {
        vm.rgin = data.model;
    });

    pageTitleService.setTitle("rgin", "page_detail");
}

function AspectoGridController($state, $stateParams, $modal, pageTitleService, AspectoService) {
    var vm = this;

    vm.filter = filter;
    vm.resetFilter = resetFilter;
    vm.search = search;
    vm.pageChanged = pageChanged;

    function filter() {
        AspectoService.filter(vm.searchCriteria).then(function(data) {
            vm.tpsrList = data.tpsrList;
        });
    }

    function resetFilter() {
        vm.searchCriteria = {};
    }

    function search(page) {
        AspectoService.listPage(vm.searchCriteria, page, vm.limit).then(function(data) {
            vm.page = data.resultList.page;
            vm.limit = data.resultList.limit;
            vm.aspcList = data.resultList;
        });
    }

    function pageChanged() {
        search(vm.page);
    }

    vm.searchCriteria = $stateParams.searchCriteria ? angular.fromJson($stateParams.searchCriteria) : {};
    vm.limit = $stateParams.limit;

    search($stateParams.page ? $stateParams.page : 1);

    pageTitleService.setTitle("aspc", "page_grid");
}

function AspectoDetailController($stateParams, pageTitleService, AspectoService) {
    var vm = this;

    vm.remove = remove;

    function remove() {
        AspectoService.remove(vm.aspc).then(function(data) {
            window.history.back();
        });
    }

    vm.aspc = {
        id : $stateParams.id,
        fref : $stateParams.fref
    };

    AspectoService.detail(vm.aspc).then(function(data) {
        vm.aspc = data.model;
        vm.i18nMap = data.i18nMap;

        vm.ascrList = data.ascrList;
    });

    pageTitleService.setTitle("aspc", "page_detail");
}

function AspectoCargoDetailController($stateParams, pageTitleService, AspectoCargoService) {
    var vm = this;

    vm.remove = remove;

    function remove() {
        AspectoCargoService.remove(vm.ascr).then(function(data) {
            window.history.back();
        });
    }

    vm.ascr = {
        id : $stateParams.id,
        fref : $stateParams.fref
    };

    AspectoCargoService.detail(vm.ascr).then(function(data) {
        vm.ascr = data.model;
    });

    pageTitleService.setTitle("ascr", "page_detail");
}

// -------------------- Gestion ------------------
