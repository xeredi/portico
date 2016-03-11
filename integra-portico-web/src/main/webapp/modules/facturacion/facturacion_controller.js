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

.controller("ValoracionEditController", ValoracionEditController)

.controller("ValoracionLineaDetailController", ValoracionLineaDetailController)

.controller("ValoracionLineaEditController", ValoracionLineaEditController)

.controller("ValoracionDetalleDetailController", ValoracionDetalleDetailController)

.controller("ValoracionDetalleEditController", ValoracionDetalleEditController)

.controller("FacturadorEditController", FacturadorEditController)

;

function config($routeProvider) {
    $routeProvider

    // -------------------- Inicio Facturacion ------------------
    .when("/facturacion", {
        templateUrl : "modules/facturacion/facturacion-index.html",
        controller : "FacturacionIndexController as vm",
        reloadOnSearch : false
    })

    // -------------------- Parametrizacion ------------------
    .when("/facturacion/cargo/grid", {
        templateUrl : "modules/facturacion/cargo-grid.html",
        controller : "CargoGridController as vm",
        reloadOnSearch : false
    })

    .when("/facturacion/cargo/detail/:id/:fref", {
        templateUrl : "modules/facturacion/cargo-detail.html",
        controller : "CargoDetailController as vm",
    })

    .when("/facturacion/cargo/edit/:accion/:id?/:fref?", {
        templateUrl : "modules/facturacion/cargo-edit.html",
        controller : "CargoEditController as vm",
    })

    .when("/facturacion/regla/detail/:id/:fref", {
        templateUrl : "modules/facturacion/regla-detail.html",
        controller : "ReglaDetailController as vm",
    })

    .when("/facturacion/regla/edit/:accion/:crgoId/:fref/:id?", {
        templateUrl : "modules/facturacion/regla-edit.html",
        controller : "ReglaEditController as vm",
    })

    .when("/facturacion/regla-incompatible/detail/:id/:fref", {
        templateUrl : "modules/facturacion/regla-incompatible-detail.html",
        controller : "ReglaIncompatibleDetailController as vm",
    })

    .when("/facturacion/regla-incompatible/edit/:accion/:rgla1Id/:fref/:id?", {
        templateUrl : "modules/facturacion/regla-incompatible-edit.html",
        controller : "ReglaIncompatibleEditController as vm",
    })

    .when("/facturacion/aspecto/grid", {
        templateUrl : "modules/facturacion/aspecto-grid.html",
        controller : "AspectoGridController as vm",
        reloadOnSearch : false
    })

    .when("/facturacion/aspecto/detail/:id/:fref", {
        templateUrl : "modules/facturacion/aspecto-detail.html",
        controller : "AspectoDetailController as vm",
    })

    .when("/facturacion/aspecto/edit/:accion/:id?/:fref?", {
        templateUrl : "modules/facturacion/aspecto-edit.html",
        controller : "AspectoEditController as vm",
    })

    .when("/facturacion/aspecto-cargo/detail/:id/:fref", {
        templateUrl : "modules/facturacion/aspecto-cargo-detail.html",
        controller : "AspectoCargoDetailController as vm",
    })

    .when("/facturacion/aspecto-cargo/edit/:accion/:aspcId/:fref/:id?", {
        templateUrl : "modules/facturacion/aspecto-cargo-edit.html",
        controller : "AspectoCargoEditController as vm",
    })

    .when("/facturacion/factura-serie/grid", {
        templateUrl : "modules/facturacion/factura-serie-grid.html",
        controller : "FacturaSerieGridController as vm",
        reloadOnSearch : false
    })

    .when("/facturacion/factura-serie/detail/:id", {
        templateUrl : "modules/facturacion/factura-serie-detail.html",
        controller : "FacturaSerieDetailController as vm",
    })

    .when("/facturacion/factura-serie/edit/:accion/:id?", {
        templateUrl : "modules/facturacion/factura-serie-edit.html",
        controller : "FacturaSerieEditController as vm",
    })

    // -------------------- Gestion ------------------
    .when("/facturacion/valoracion/grid", {
        templateUrl : "modules/facturacion/valoracion-grid.html",
        controller : "ValoracionGridController as vm",
        reloadOnSearch : false
    })

    .when("/facturacion/valoracion/detail/:id", {
        templateUrl : "modules/facturacion/valoracion-detail.html",
        controller : "ValoracionDetailController as vm",
        reloadOnSearch : false
    })

    .when("/facturacion/valoracion/edit/:accion/:id?", {
        templateUrl : "modules/facturacion/valoracion-edit.html",
        controller : "ValoracionEditController as vm"
    })

    .when("/facturacion/valoracion-linea/detail/:vlrcId/:id", {
        templateUrl : "modules/facturacion/valoracion-linea-detail.html",
        controller : "ValoracionLineaDetailController as vm",
        reloadOnSearch : false
    })

    .when("/facturacion/valoracion-linea/edit/:accion/:vlrcId/:id?", {
        templateUrl : "modules/facturacion/valoracion-linea-edit.html",
        controller : "ValoracionLineaEditController as vm"
    })

    .when("/facturacion/valoracion-detalle/detail/:vlrcId/:vlrlId/:id", {
        templateUrl : "modules/facturacion/valoracion-detalle-detail.html",
        controller : "ValoracionDetalleDetailController as vm"
    })

    .when("/facturacion/valoracion-detalle/edit/:accion/:vlrcId/:vlrlId/:id?", {
        templateUrl : "modules/facturacion/valoracion-detalle-edit.html",
        controller : "ValoracionDetalleEditController as vm"
    })

    .when("/facturacion/facturador/edit/:accion/:vlrcId?", {
        templateUrl : "modules/facturacion/facturador-edit.html",
        controller : "FacturadorEditController as vm",
    })

    ;
}

// -------------------- Inicio Facturacion ------------------
function FacturacionIndexController($routeParams, pageTitleService, FacturacionService) {
    var vm = this;

    FacturacionService.index().then(function(data) {
    });

    pageTitleService.setTitle("sec_facturacion", "page_home");
}

// -------------------- Parametrizacion ------------------
function CargoGridController($routeParams, pageTitleService, CargoService) {
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
            vm.resultList = data.resultList;
        });
    }

    function pageChanged() {
        search(vm.page);
    }

    vm.searchCriteria = $routeParams.searchCriteria ? angular.fromJson($routeParams.searchCriteria) : {};
    vm.limit = $routeParams.limit;

    search($routeParams.page ? $routeParams.page : 1);

    pageTitleService.setTitle("crgo", "page_grid");
}

function CargoDetailController($routeParams, pageTitleService, CargoService) {
    var vm = this;

    vm.remove = remove;

    function remove() {
        CargoService.remove(vm.model).then(function(data) {
            window.history.back();
        });
    }

    vm.search = {
        id : $routeParams.id,
        fref : $routeParams.fref
    };

    CargoService.detail(vm.search).then(function(data) {
        vm.model = data.model;
        vm.i18nMap = data.i18nMap;

        vm.rglaList = data.rglaList;
    });

    pageTitleService.setTitle("crgo", "page_detail");
}

function CargoEditController($routeParams, pageTitleService, CargoService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        CargoService.saveI18n(vm.accion, vm.model, vm.i18nMap).then(
                function(data) {
                    CargoService.redirectAfterSave(vm.accion, '/facturacion/cargo/detail', [ data.model.id,
                            data.model.version.fini ]);
                });
    }

    function cancel() {
        window.history.back();
    }

    vm.accion = $routeParams.accion;
    vm.search = {
        id : $routeParams.id,
        fref : $routeParams.fref
    }

    CargoService.edit(vm.accion, vm.search).then(function(data) {
        vm.model = data.model;
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

function ReglaDetailController($routeParams, pageTitleService, ReglaService) {
    var vm = this;

    vm.remove = remove;

    function remove() {
        ReglaService.remove(vm.model).then(function(data) {
            window.history.back();
        });
    }

    vm.search = {
        id : $routeParams.id,
        fref : $routeParams.fref
    };

    ReglaService.detail(vm.search).then(function(data) {
        vm.model = data.model;
        vm.i18nMap = data.i18nMap;

        vm.rginList = data.rginList;
    });

    pageTitleService.setTitle("rgla", "page_detail");
}

function ReglaEditController($routeParams, pageTitleService, ReglaService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        ReglaService.saveI18n(vm.accion, vm.model, vm.i18nMap).then(
                function(data) {
                    ReglaService.redirectAfterSave(vm.accion, '/facturacion/regla/detail', [ data.model.id,
                            data.model.version.fini ]);
                });
    }

    function cancel() {
        window.history.back();
    }

    vm.accion = $routeParams.accion;
    vm.search = {
        crgo : {
            id : $routeParams.crgoId
        },
        id : $routeParams.id,
        fref : $routeParams.fref
    }

    ReglaService.edit(vm.accion, vm.search).then(function(data) {
        vm.model = data.model;
        vm.i18nMap = data.i18nMap;

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

function ReglaIncompatibleDetailController($routeParams, pageTitleService, ReglaIncompatibleService) {
    var vm = this;

    vm.remove = remove;

    function remove() {
        ReglaIncompatibleService.remove(vm.model).then(function(data) {
            window.history.back();
        });
    }

    vm.search = {
        id : $routeParams.id,
        fref : $routeParams.fref
    };

    ReglaIncompatibleService.detail(vm.search).then(function(data) {
        vm.model = data.model;
    });

    pageTitleService.setTitle("rgin", "page_detail");
}

function ReglaIncompatibleEditController($routeParams, pageTitleService, ReglaIncompatibleService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        ReglaIncompatibleService.save(vm.accion, vm.model).then(
                function(data) {
                    ReglaIncompatibleService.redirectAfterSave(vm.accion,
                            '/facturacion/regla-incompatible/detail', [ data.model.id,
                                    data.model.version.fini ]);
                });
    }

    function cancel() {
        window.history.back();
    }

    vm.accion = $routeParams.accion;
    vm.search = {
        rgla1Id : $routeParams.rgla1Id,
        id : $routeParams.id,
        fref : $routeParams.fref
    }

    ReglaIncompatibleService.edit(vm.accion, vm.search).then(function(data) {
        vm.model = data.model;

        vm.rgla2List = data.rgla2List;
    });

    pageTitleService.setTitle("rgin", "page_" + vm.accion);
}

function AspectoGridController($routeParams, pageTitleService, AspectoService) {
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
            vm.resultList = data.resultList;
        });
    }

    function pageChanged() {
        search(vm.page);
    }

    vm.searchCriteria = $routeParams.searchCriteria ? angular.fromJson($routeParams.searchCriteria) : {};
    vm.limit = $routeParams.limit;

    search($routeParams.page ? $routeParams.page : 1);

    pageTitleService.setTitle("aspc", "page_grid");
}

function AspectoDetailController($routeParams, pageTitleService, AspectoService) {
    var vm = this;

    vm.remove = remove;

    function remove() {
        AspectoService.remove(vm.model).then(function(data) {
            window.history.back();
        });
    }

    vm.search = {
        id : $routeParams.id,
        fref : $routeParams.fref
    };

    AspectoService.detail(vm.search).then(function(data) {
        vm.model = data.model;
        vm.i18nMap = data.i18nMap;

        vm.ascrList = data.ascrList;
    });

    pageTitleService.setTitle("aspc", "page_detail");
}

function AspectoEditController($routeParams, pageTitleService, AspectoService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        AspectoService.saveI18n(vm.accion, vm.model, vm.i18nMap).then(
                function(data) {
                    AspectoService.redirectAfterSave(vm.accion, '/facturacion/aspecto/detail', [
                            data.model.id, data.model.version.fini ]);
                });
    }

    function cancel() {
        window.history.back();
    }

    vm.accion = $routeParams.accion;
    vm.search = {
        id : $routeParams.id,
        fref : $routeParams.fref
    }

    AspectoService.edit(vm.accion, vm.search).then(function(data) {
        vm.model = data.model;
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

function AspectoCargoDetailController($routeParams, pageTitleService, AspectoCargoService) {
    var vm = this;

    vm.remove = remove;

    function remove() {
        AspectoCargoService.remove(vm.model).then(function(data) {
            window.history.back();
        });
    }

    vm.search = {
        id : $routeParams.id,
        fref : $routeParams.fref
    };

    AspectoCargoService.detail(vm.search).then(function(data) {
        vm.model = data.model;
    });

    pageTitleService.setTitle("ascr", "page_detail");
}

function AspectoCargoEditController($routeParams, pageTitleService, AspectoCargoService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        AspectoCargoService.saveI18n(vm.accion, vm.model, vm.i18nMap).then(
                function(data) {
                    AspectoCargoService.redirectAfterSave(vm.accion, '/facturacion/aspecto-cargo/detail', [
                            data.model.id, data.model.version.fini ]);
                });
    }

    function cancel() {
        window.history.back();
    }

    vm.accion = $routeParams.accion;
    vm.search = {
        aspcId : $routeParams.aspcId,
        id : $routeParams.id,
        fref : $routeParams.fref
    }

    AspectoCargoService.edit(vm.accion, vm.search).then(function(data) {
        vm.model = data.model;

        vm.crgoList = data.crgoList;
    });

    pageTitleService.setTitle("ascr", "page_" + vm.accion);
}

function FacturaSerieGridController($routeParams, pageTitleService, FacturaSerieService) {
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
            vm.resultList = data.resultList;
        });
    }

    function pageChanged() {
        search(vm.page);
    }

    vm.searchCriteria = $routeParams.searchCriteria ? angular.fromJson($routeParams.searchCriteria) : {};
    vm.limit = $routeParams.limit;

    search($routeParams.page ? $routeParams.page : 1);

    pageTitleService.setTitle("fcsr", "page_grid");
}

function FacturaSerieDetailController($routeParams, pageTitleService, FacturaSerieService) {
    var vm = this;

    vm.remove = remove;

    function remove() {
        FacturaSerieService.remove(vm.model).then(function(data) {
            window.history.back();
        });
    }

    vm.search = {
        id : $routeParams.id,
        fref : $routeParams.fref
    };

    FacturaSerieService.detail(vm.search).then(function(data) {
        vm.model = data.model;
    });

    pageTitleService.setTitle("fcsr", "page_detail");
}

function FacturaSerieEditController($routeParams, pageTitleService, FacturaSerieService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        FacturaSerieService.save(vm.accion, vm.model).then(
                function(data) {
                    FacturaSerieService.redirectAfterSave(vm.accion, '/facturacion/factura-serie/detail',
                            [ data.model.id ]);
                });
    }

    function cancel() {
        window.history.back();
    }

    vm.accion = $routeParams.accion;
    vm.search = {
        id : $routeParams.id,
        fref : $routeParams.fref
    }

    FacturaSerieService.edit(vm.accion, vm.search).then(function(data) {
        vm.model = data.model;
    });

    pageTitleService.setTitle("fcsr", "page_" + vm.accion);
}

// -------------------- Gestion ------------------
function ValoracionGridController($routeParams, pageTitleService, ValoracionService) {
    var vm = this;

    vm.filter = filter;
    vm.resetFilter = resetFilter;
    vm.search = search;
    vm.pageChanged = pageChanged;

    function filter() {
        ValoracionService.filter(vm.searchCriteria).then(function(data) {
            vm.tpsrList = data.tpsrList;
            vm.prtoList = data.prtoList;
        });
    }

    function resetFilter() {
        vm.searchCriteria = {};
    }

    function search(page) {
        ValoracionService.listPage(vm.searchCriteria, page, vm.limit).then(function(data) {
            vm.page = data.resultList.page;
            vm.limit = data.resultList.limit;
            vm.resultList = data.resultList;

            vm.tpdtCodExencion = data.tpdtCodExencion;
        });
    }

    function pageChanged() {
        search(vm.page);
    }

    vm.searchCriteria = $routeParams.searchCriteria ? angular.fromJson($routeParams.searchCriteria) : {};
    vm.limit = $routeParams.limit;

    search($routeParams.page ? $routeParams.page : 1);

    pageTitleService.setTitle("vlrc", "page_grid");
}

function ValoracionDetailController($routeParams, pageTitleService, ValoracionService, ValoracionLineaService) {
    var vm = this;

    vm.pageChanged = pageChanged;
    vm.tabSelected = tabSelected;
    vm.remove = remove;
    vm.pdfExport = pdfExport;

    function remove() {
        ValoracionService.remove(vm.model).then(function(data) {
            window.history.back();
        });
    }

    function pageChanged() {
        findVlrlList(vm.page);
    }

    function tabSelected(tabNo) {
        ValoracionService.tabSelected(tabNo);
    }

    function pdfExport() {
        ValoracionService.pdfExport(vm.model, 'vlrc_' + vm.model.id);
    }

    function findVlrlList(page) {
        var searchCriteria = {
            vlrcId : vm.model.id
        };

        ValoracionLineaService.listPage(searchCriteria, page, vm.limit).then(function(data) {
            vm.vlrlList = data.resultList;
            vm.pageMap['vlrlList'] = data.resultList.page;

            ValoracionService.pageMapChanged(vm.pageMap);
        });
    }

    vm.tabActive = {};

    if ($routeParams.tab) {
        vm.tabActive[$routeParams.tab] = true;
    }

    vm.pageMap = $routeParams.pageMap ? angular.fromJson($routeParams.pageMap) : {};

    vm.search = {
        id : $routeParams.id
    };

    ValoracionService.detail(vm.search).then(function(data) {
        vm.model = data.model;

        vm.aspc = data.aspc;
        vm.tpdtCodExencion = data.tpdtCodExencion;

        vm.vlrgList = data.vlrgList;
        vm.vlriList = data.vlriList;

        findVlrlList(vm.pageMap['vlrlList']);
    });

    pageTitleService.setTitle("vlrc", "page_detail");
}

function ValoracionEditController($routeParams, pageTitleService, ValoracionService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        ValoracionService.save(vm.accion, vm.model).then(
                function(data) {
                    ValoracionService.redirectAfterSave(vm.accion, '/facturacion/valoracion/detail',
                            [ data.model.id ]);
                });
    }

    function cancel() {
        window.history.back();
    }

    vm.accion = $routeParams.accion;
    vm.search = {
        id : $routeParams.id
    }

    ValoracionService.edit(vm.accion, vm.search).then(function(data) {
        vm.model = data.model;

        vm.tpsrList = data.tpsrList;
        vm.pagadorEntiId = data.pagadorEntiId;
        vm.tpdtCodExencion = data.tpdtCodExencion;
    });

    pageTitleService.setTitle("vlrc", "page_" + vm.accion);
}

function ValoracionLineaDetailController($routeParams, pageTitleService, ValoracionLineaService,
        ValoracionDetalleService) {
    var vm = this;

    vm.pageChanged = pageChanged;
    vm.tabSelected = tabSelected;
    vm.remove = remove;

    function remove() {
        ValoracionLineaService.remove(vm.model).then(function(data) {
            window.history.back();
        });
    }

    function pageChanged() {
        findVlrdList(vm.page);
    }

    function tabSelected(tabNo) {
        ValoracionLineaService.tabSelected(tabNo);
    }

    function findVlrdList(page) {
        var searchCriteria = {
            vlrlId : vm.model.id
        };

        ValoracionDetalleService.listPage(searchCriteria, page, vm.limit).then(function(data) {
            vm.vlrdList = data.resultList;
            vm.pageMap['vlrdList'] = data.resultList.page;

            ValoracionLineaService.pageMapChanged(vm.pageMap);
        });
    }

    vm.tabActive = {};

    if ($routeParams.tab) {
        vm.tabActive[$routeParams.tab] = true;
    }

    vm.pageMap = $routeParams.pageMap ? angular.fromJson($routeParams.pageMap) : {};

    vm.search = {
        id : $routeParams.id,
        vlrcId : $routeParams.vlrcId
    };

    ValoracionLineaService.detail(vm.search).then(function(data) {
        vm.model = data.model;

        vm.aspc = data.aspc;
        vm.vlrlPadre = data.vlrlPadre;
        vm.vlrlHijosList = data.vlrlHijosList;

        findVlrdList(vm.pageMap['vlrlList']);
    });

    pageTitleService.setTitle("vlrl", "page_detail");
}

function ValoracionLineaEditController($routeParams, pageTitleService, ValoracionLineaService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        ValoracionLineaService.save(vm.accion, vm.model).then(
                function(data) {
                    ValoracionLineaService.redirectAfterSave(vm.accion,
                            '/facturacion/valoracion-linea/detail', [ data.model.id ]);
                });
    }

    function cancel() {
        window.history.back();
    }

    vm.accion = $routeParams.accion;
    vm.search = {
        vlrcId : $routeParams.vlrcId,
        id : $routeParams.id
    }

    ValoracionLineaService.edit(vm.accion, vm.search).then(function(data) {
        vm.model = data.model;

        vm.aspc = data.aspc;
        vm.vlrlPadre = data.vlrlPadre;

        vm.impuestoList = data.impuestoList;
    });

    pageTitleService.setTitle("vlrl", "page_" + vm.accion);
}

function ValoracionDetalleDetailController($routeParams, pageTitleService, ValoracionDetalleService) {
    var vm = this;

    vm.remove = remove;

    function remove() {
        ValoracionDetalleService.remove(vm.model).then(function(data) {
            window.history.back();
        });
    }

    vm.search = {
        id : $routeParams.id,
        vlrlId : $routeParams.vlrlId,
        vlrcId : $routeParams.vlrcId
    };

    ValoracionDetalleService.detail(vm.search).then(function(data) {
        vm.model = data.model;

        vm.aspc = data.aspc;
        vm.vlrl = data.vlrl;
        vm.vlrlPadre = data.vlrlPadre;
        vm.vlrdHijosList = data.vlrdHijosList;
    });

    pageTitleService.setTitle("vlrd", "page_detail");
}

function ValoracionDetalleEditController($routeParams, pageTitleService, ValoracionDetalleService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        ValoracionDetalleService.save(vm.accion, vm.model).then(
                function(data) {
                    ValoracionDetalleService.redirectAfterSave(vm.accion,
                            '/facturacion/valoracion-detalle/detail', [ data.model.id ]);
                });
    }

    function cancel() {
        window.history.back();
    }

    vm.accion = $routeParams.accion;
    vm.search = {
        vlrcId : $routeParams.vlrcId,
        vlrlId : $routeParams.vlrlId,
        id : $routeParams.id
    }

    ValoracionDetalleService.edit(vm.accion, vm.search).then(function(data) {
        vm.model = data.model;

        vm.aspc = data.aspc;
        vm.vlrl = data.vlrl;
        vm.vlrlPadre = data.vlrlPadre;
    });

    pageTitleService.setTitle("vlrd", "page_" + vm.accion);
}

function FacturadorEditController($routeParams, pageTitleService, FacturadorService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        FacturadorService.save(vm.accion, vm.model).then(function(data) {
            FacturadorService.redirectAfterSave(vm.accion, '/proceso/proceso/grid');
        });
    }

    function cancel() {
        window.history.back();
    }

    vm.accion = $routeParams.accion;
    vm.search = {
        vlrcId : $routeParams.vlrcId
    }

    FacturadorService.edit(vm.accion, vm.search).then(function(data) {
        vm.model = data.model;

        vm.fcsrList = data.fcsrList;
        vm.grupoTipoList = data.grupoTipoList;
        vm.tpsrList = data.tpsrList;
        vm.prtoList = data.prtoList;
    });

    pageTitleService.setTitle("fcdr", "page_" + vm.accion);
}
