angular.module("facturacion_controller", [])

.config(config)

// -------------------- Inicio Facturacion ------------------
.controller("FacturacionIndexController", FacturacionIndexController)

// -------------------- Parametrizacion ------------------
.controller("CargoGridController", CargoGridController)

.controller("CargoDetailController", CargoDetailController)

.controller("CargoEditController", CargoEditController)

.controller("CargoTypeaheadController", CargoTypeaheadController)

.controller("ReglaDetailController", ReglaDetailController)

.controller("ReglaEditController", ReglaEditController)

.controller("ReglaTypeaheadController", ReglaTypeaheadController)

.controller("ReglaIncompatibleDetailController", ReglaIncompatibleDetailController)

.controller("ReglaIncompatibleEditController", ReglaIncompatibleEditController)

.controller("AspectoGridController", AspectoGridController)

.controller("AspectoDetailController", AspectoDetailController)

.controller("AspectoEditController", AspectoEditController)

.controller("AspectoTypeaheadController", AspectoTypeaheadController)

.controller("AspectoCargoDetailController", AspectoCargoDetailController)

.controller("AspectoCargoEditController", AspectoCargoEditController)

.controller("FacturaSerieGridController", FacturaSerieGridController)

.controller("FacturaSerieDetailController", FacturaSerieDetailController)

.controller("FacturaSerieEditController", FacturaSerieEditController)

// -------------------- Gestion ------------------
.controller("ValoracionGridController", ValoracionGridController)

.controller("ValoracionDetailController", ValoracionDetailController)

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

    .state("regla-edit", {
        url : "/facturacion/regla/edit/:accion/:crgoId?id&fref",
        templateUrl : "modules/facturacion/regla-edit.html",
        controller : "ReglaEditController as vm",
    })

    .state("regla-incompatible-detail", {
        url : "/facturacion/regla-incompatible/detail/:id?fref",
        templateUrl : "modules/facturacion/regla-incompatible-detail.html",
        controller : "ReglaIncompatibleDetailController as vm",
    })

    .state("regla-incompatible-edit", {
        url : "/facturacion/regla-incompatible/edit/:accion/:rgla1Id?id&fref",
        templateUrl : "modules/facturacion/regla-incompatible-edit.html",
        controller : "ReglaIncompatibleEditController as vm",
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

    .state("aspecto-edit", {
        url : "/facturacion/aspecto/edit/:accion?id&fref",
        templateUrl : "modules/facturacion/aspecto-edit.html",
        controller : "AspectoEditController as vm",
    })

    .state("aspecto-cargo-detail", {
        url : "/facturacion/aspecto-cargo/detail/:id?fref",
        templateUrl : "modules/facturacion/aspecto-cargo-detail.html",
        controller : "AspectoCargoDetailController as vm",
    })

    .state("aspecto-cargo-edit", {
        url : "/facturacion/aspecto-cargo/edit/:accion/:aspcId?id&fref",
        templateUrl : "modules/facturacion/aspecto-cargo-edit.html",
        controller : "AspectoCargoEditController as vm",
    })

    .state("factura-serie-grid", {
        url : "/facturacion/factura-serie/grid?page&searchCriteria&limit",
        templateUrl : "modules/facturacion/factura-serie-grid.html",
        controller : "FacturaSerieGridController as vm",
        reloadOnSearch : false
    })

    .state("factura-serie-detail", {
        url : "/facturacion/factura-serie/detail/:id?fref",
        templateUrl : "modules/facturacion/factura-serie-detail.html",
        controller : "FacturaSerieDetailController as vm",
    })

    .state("factura-serie-edit", {
        url : "/facturacion/factura-serie/edit/:accion?id&fref",
        templateUrl : "modules/facturacion/factura-serie-edit.html",
        controller : "FacturaSerieEditController as vm",
    })

    // -------------------- Gestion ------------------
    .state("valoracion-grid", {
        url : "/facturacion/valoracion/grid?page&searchCriteria&limit",
        templateUrl : "modules/facturacion/valoracion-grid.html",
        controller : "ValoracionGridController as vm",
        reloadOnSearch : false
    })

    .state("valoracion-detail", {
        url : "/facturacion/valoracion/detail/:id?fref&tab",
        templateUrl : "modules/facturacion/valoracion-detail.html",
        controller : "ValoracionDetailController as vm",
        reloadOnSearch : false
    })

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
            CargoService.redirectAfterSave(vm.accion, data.model, "cargo-detail");
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

function CargoTypeaheadController($scope, CargoService) {
    var ta = this;

    ta.searchTpsr = searchTpsr;
    ta.searchAspc = searchAspc;
    ta.searchVlrc = searchVlrc;

    function searchTpsr(entiId, textoBusqueda, fechaVigencia) {
        if (textoBusqueda.length <= 0) {
            return null;
        }

        return CargoService.typeahead({
            tpsrId : entiId,
            textoBusqueda : textoBusqueda,
            fechaVigencia : fechaVigencia
        }).then(function(data) {
            return data.resultList;
        });
    }
    ;

    function searchAspc(aspcId, textoBusqueda, fechaVigencia) {
        if (textoBusqueda.length <= 0) {
            return null;
        }

        return CargoService.typeahead({
            aspcId : aspcId,
            textoBusqueda : textoBusqueda,
            fechaVigencia : fechaVigencia
        }).then(function(data) {
            return data.resultList;
        });
    }
    ;

    function searchVlrc(vlrcId, textoBusqueda) {
        if (textoBusqueda.length <= 0) {
            return null;
        }

        return CargoService.typeahead({
            vlrcId : vlrcId,
            textoBusqueda : textoBusqueda
        }).then(function(data) {
            return data.resultList;
        });
    }
    ;
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

function ReglaEditController($state, $stateParams, pageTitleService, ReglaService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        ReglaService.save(vm.accion, vm.rgla).then(function(data) {
            ReglaService.redirectAfterSave(vm.accion, data.model, "regla-detail");
        });
    }

    function cancel() {
        window.history.back();
    }

    vm.accion = $stateParams.accion;
    vm.rgla = {
        crgo : {
            id : $stateParams.crgoId

        },
        id : $stateParams.id,
        fref : $stateParams.fref
    }

    ReglaService.edit($stateParams.accion, vm.rgla).then(function(data) {
        vm.rgla = data.model;

        vm.tipos = data.tipos;
        vm.entiFacturableList = data.entiFacturableList;
    });

    pageTitleService.setTitle("rgla", "page_" + vm.accion);
}

function ReglaTypeaheadController($scope, ReglaService) {
    var ta = this;

    ta.searchCrgo = searchCrgo;
    ta.searchVlrc = searchVlrc;

    function searchCrgo(crgoId, textoBusqueda, fechaVigencia) {
        if (textoBusqueda.length <= 0) {
            return null;
        }

        return CargoService.typeahead({
            crgoId : crgoId,
            textoBusqueda : textoBusqueda,
            fechaVigencia : fechaVigencia
        }).then(function(data) {
            return data.resultList;
        });
    }

    function searchVlrc(vlrcId, crgoId, textoBusqueda) {
        if (textoBusqueda.length <= 0) {
            return null;
        }

        return ReglaService.typeahead({
            vlrcId : vlrcId,
            crgoId : crgoId,
            textoBusqueda : textoBusqueda
        }).then(function(data) {
            return data.resultList;
        });
    }
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

function ReglaIncompatibleEditController($state, $stateParams, pageTitleService, ReglaIncompatibleService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        ReglaIncompatibleService.save(vm.accion, vm.rgin).then(function(data) {
            ReglaIncompatibleService.redirectAfterSave(vm.accion, data.model, "regla-incompatible-detail");
        });
    }

    function cancel() {
        window.history.back();
    }

    vm.accion = $stateParams.accion;
    vm.rgin = {
        rgla1Id : $stateParams.rgla1Id,
        id : $stateParams.id,
        fref : $stateParams.fref
    }

    ReglaIncompatibleService.edit($stateParams.accion, vm.rgin).then(function(data) {
        vm.rgin = data.model;

        vm.rgla2List = data.rgla2List;
    });

    pageTitleService.setTitle("rgin", "page_" + vm.accion);
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

function AspectoEditController($state, $stateParams, pageTitleService, AspectoService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        AspectoService.saveI18n(vm.accion, vm.aspc, vm.i18nMap).then(function(data) {
            AspectoService.redirectAfterSave(vm.accion, data.model, "aspecto-detail");
        });
    }

    function cancel() {
        window.history.back();
    }

    vm.accion = $stateParams.accion;
    vm.aspc = {
        id : $stateParams.id,
        fref : $stateParams.fref
    }

    AspectoService.edit($stateParams.accion, vm.aspc).then(function(data) {
        vm.aspc = data.model;
        vm.i18nMap = data.i18nMap;

        vm.tpsrList = data.tpsrList;
    });

    pageTitleService.setTitle("aspc", "page_" + vm.accion);
}

function AspectoTypeaheadController($scope, AspectoService) {
    var ta = this;

    ta.search = search;

    function search(entiId, textoBusqueda, fechaVigencia) {
        if (textoBusqueda.length <= 0) {
            return null;
        }

        return AspectoService.typeahead({
            tpsrId : entiId,
            textoBusqueda : textoBusqueda,
            fechaVigencia : fechaVigencia
        }).then(function(data) {
            return data.resultList;
        });
    }
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

function AspectoCargoEditController($state, $stateParams, pageTitleService, AspectoCargoService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        AspectoCargoService.saveI18n(vm.accion, vm.ascr, vm.i18nMap).then(function(data) {
            AspectoCargoService.redirectAfterSave(vm.accion, data.model, "aspecto-cargo-detail");
        });
    }

    function cancel() {
        window.history.back();
    }

    vm.accion = $stateParams.accion;
    vm.ascr = {
        aspcId : $stateParams.aspcId,
        id : $stateParams.id,
        fref : $stateParams.fref
    }

    AspectoCargoService.edit($stateParams.accion, vm.ascr).then(function(data) {
        vm.ascr = data.model;

        vm.crgoList = data.crgoList;
    });

    pageTitleService.setTitle("ascr", "page_" + vm.accion);
}

function FacturaSerieGridController($state, $stateParams, $modal, pageTitleService, FacturaSerieService) {
    var vm = this;

    vm.filter = filter;
    vm.resetFilter = resetFilter;
    vm.search = search;
    vm.pageChanged = pageChanged;

    function filter() {
        FacturaSerieService.filter(vm.searchCriteria).then(function(data) {
            vm.fcsrList = data.tpsrList;
        });
    }

    function resetFilter() {
        vm.searchCriteria = {};
    }

    function search(page) {
        FacturaSerieService.listPage(vm.searchCriteria, page, vm.limit).then(function(data) {
            vm.page = data.resultList.page;
            vm.limit = data.resultList.limit;
            vm.fcsrList = data.resultList;
        });
    }

    function pageChanged() {
        search(vm.page);
    }

    vm.searchCriteria = $stateParams.searchCriteria ? angular.fromJson($stateParams.searchCriteria) : {};
    vm.limit = $stateParams.limit;

    search($stateParams.page ? $stateParams.page : 1);

    pageTitleService.setTitle("fcsr", "page_grid");
}

function FacturaSerieDetailController($stateParams, pageTitleService, FacturaSerieService) {
    var vm = this;

    vm.remove = remove;

    function remove() {
        FacturaSerieService.remove(vm.fcsr).then(function(data) {
            window.history.back();
        });
    }

    vm.fcsr = {
        id : $stateParams.id,
        fref : $stateParams.fref
    };

    FacturaSerieService.detail(vm.fcsr).then(function(data) {
        vm.fcsr = data.model;
    });

    pageTitleService.setTitle("fcsr", "page_detail");
}

function FacturaSerieEditController($state, $stateParams, pageTitleService, FacturaSerieService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        FacturaSerieService.save(vm.accion, vm.fcsr).then(function(data) {
            FacturaSerieService.redirectAfterSave(vm.accion, data.model, "factura-serie-detail");
        });
    }

    function cancel() {
        window.history.back();
    }

    vm.accion = $stateParams.accion;
    vm.fcsr = {
        id : $stateParams.id,
        fref : $stateParams.fref
    }

    FacturaSerieService.edit($stateParams.accion, vm.fcsr).then(function(data) {
        vm.fcsr = data.model;
    });

    pageTitleService.setTitle("fcsr", "page_" + vm.accion);
}

// -------------------- Gestion ------------------
function ValoracionGridController($state, $stateParams, $modal, pageTitleService, ValoracionService) {
    var vm = this;

    vm.filter = filter;
    vm.resetFilter = resetFilter;
    vm.search = search;
    vm.pageChanged = pageChanged;

    function filter() {
        ValoracionService.filter(vm.searchCriteria).then(function(data) {
            vm.tpsrList = data.tpsrList;
        });
    }

    function resetFilter() {
        vm.searchCriteria = {};
    }

    function search(page) {
        ValoracionService.listPage(vm.searchCriteria, page, vm.limit).then(function(data) {
            vm.page = data.resultList.page;
            vm.limit = data.resultList.limit;
            vm.vlrcList = data.resultList;

            vm.tpdtCodExencion = data.tpdtCodExencion;
        });
    }

    function pageChanged() {
        search(vm.page);
    }

    vm.searchCriteria = $stateParams.searchCriteria ? angular.fromJson($stateParams.searchCriteria) : {};
    vm.limit = $stateParams.limit;

    search($stateParams.page ? $stateParams.page : 1);

    pageTitleService.setTitle("vlrc", "page_grid");
}

function ValoracionDetailController($stateParams, pageTitleService, ValoracionService, ValoracionLineaService) {
    var vm = this;

    vm.pageChanged = pageChanged;
    vm.tabSelected = tabSelected;
    vm.remove = remove;
    vm.print = print;

    function remove() {
        ValoracionService.remove(vm.vlrc).then(function(data) {
            window.history.back();
        });
    }

    function pageChanged() {
        alert('Page Changed!!!');
        // findVlrlList(vm.page);
    }

    function tabSelected(tabNo) {
        ValoracionService.tabSelected(tabNo);
    }

    function print() {
        ValoracionService.pdfExport(vm.vlrc).then(function(data) {
            var file = new Blob([ data ], {
                type : 'application/pdf'
            });

            setTimeout(function() {
                saveAs(file, 'vlrc_' + vm.vlrc.id + '.pdf');
            }, 0);
        });
    }

    vm.tabActive = {};

    if ($stateParams.tab) {
        vm.tabActive[$stateParams.tab] = true;
    }

    vm.vlrc = {
        id : $stateParams.id
    };

    ValoracionService.detail(vm.vlrc).then(function(data) {
        vm.vlrc = data.model;

        vm.aspc = data.aspc;
        vm.tpdtCodExencion = data.tpdtCodExencion;

        vm.vlrgList = data.vlrgList;
        vm.vlriList = data.vlriList;
    });

    pageTitleService.setTitle("vlrc", "page_detail");
}
