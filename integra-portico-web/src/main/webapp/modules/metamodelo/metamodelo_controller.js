angular.module("metamodelo_controller", [])

.config(config)

// -------------------- TIPO DE DATO ------------------
.controller("TipoDatoGridController", TipoDatoGridController)

.controller("TipoDatoDetailController", TipoDatoDetailController)

.controller("TipoDatoEditController", TipoDatoEditController)

.controller("CodigoReferenciaDetailController", CodigoReferenciaDetailController)

.controller("CodigoReferenciaEditController", CodigoReferenciaEditController)

// -------------------- MAESTRO ------------------
.controller("TipoParametroGridController", TipoParametroGridController)

.controller("TipoParametroDetailController", TipoParametroDetailController)

.controller("TipoParametroEditController", TipoParametroEditController)

.controller("TipoSubparametroDetailController", TipoSubparametroDetailController)

.controller("TipoSubparametroEditController", TipoSubparametroEditController)

// -------------------- TIPO DE SERVICIO ------------------
.controller("TipoServicioGridController", TipoServicioGridController)

.controller("TipoServicioDetailController", TipoServicioDetailController)

.controller("TipoServicioEditController", TipoServicioEditController)

.controller("TipoSubservicioDetailController", TipoSubservicioDetailController)

.controller("TipoSubservicioEditController", TipoSubservicioEditController)

// -------------------- ESTADISTICA ------------------
.controller("TipoEstadisticaGridController", TipoEstadisticaGridController)

.controller("TipoEstadisticaDetailController", TipoEstadisticaDetailController)

.controller("TipoEstadisticaEditController", TipoEstadisticaEditController)

.controller("CampoAgregacionDetailController", CampoAgregacionDetailController)

.controller("CampoAgregacionEditController", CampoAgregacionEditController)

// ------------------- GRUPO DE DATO DE ENTIDAD --------------------
.controller("EntidadGrupoDatoDetailController", EntidadGrupoDatoDetailController)

.controller("EntidadGrupoDatoEditController", EntidadGrupoDatoEditController)

// ------------------- DATO DE ENTIDAD --------------------
.controller("EntidadTipoDatoDetailController", EntidadTipoDatoDetailController)

.controller("EntidadTipoDatoEditController", EntidadTipoDatoEditController)

// ------------------- TRAMITE --------------------
.controller("TramiteDetailController", TramiteDetailController)

.controller("TramiteEditController", TramiteEditController)

.controller("TramiteTipoDatoDetailController", TramiteTipoDatoDetailController)

.controller("TramiteTipoDatoEditController", TramiteTipoDatoEditController)

// ------------------- ACCION DE ENTIDAD --------------------
.controller("EntidadAccionDetailController", EntidadAccionDetailController)

.controller("EntidadAccionEditController", EntidadAccionEditController)

// ------------------- ACCION DE GRID DE ENTIDAD --------------------
.controller("EntidadAccionGridDetailController", EntidadAccionGridDetailController)

.controller("EntidadAccionGridEditController", EntidadAccionGridEditController)

// ------------------- DEPENDENCIA ENTRE ENTIDADES --------------------
.controller("EntidadEntidadEditController", EntidadEntidadEditController);

function config($stateProvider) {
    $stateProvider

    .state("tipodato-grid", {
        url : "/metamodelo/tipodato/grid?page&searchCriteria&limit",
        templateUrl : "modules/metamodelo/tipodato-grid.html",
        controller : "TipoDatoGridController as vm",
        reloadOnSearch : false
    })

    .state("tipodato-detail", {
        url : "/metamodelo/tipodato/detail/:id",
        templateUrl : "modules/metamodelo/tipodato-detail.html",
        controller : "TipoDatoDetailController as vm",
    })

    .state("tipodato-edit", {
        url : "/metamodelo/tipodato/edit/:accion?id",
        templateUrl : "modules/metamodelo/tipodato-edit.html",
        controller : "TipoDatoEditController as vm",
    })

    .state("codigoreferencia-detail", {
        url : "/metamodelo/codigoreferencia/detail/:id",
        templateUrl : "modules/metamodelo/codigoreferencia-detail.html",
        controller : "CodigoReferenciaDetailController as vm",
    })

    .state("codigoreferencia-edit", {
        url : "/metamodelo/codigoreferencia/edit/:accion/:tpdtId?id",
        templateUrl : "modules/metamodelo/codigoreferencia-edit.html",
        controller : "CodigoReferenciaEditController as vm",
    })

    .state("tipoparametro-grid", {
        url : "/metamodelo/tipoparametro/grid?page&searchCriteria&limit",
        templateUrl : "modules/metamodelo/tipoparametro-grid.html",
        controller : "TipoParametroGridController as vm",
        reloadOnSearch : false
    })

    .state("tipoparametro-detail", {
        url : "/metamodelo/tipoparametro/detail/:id?tab",
        templateUrl : "modules/metamodelo/tipoparametro-detail.html",
        controller : "TipoParametroDetailController as vm",
        reloadOnSearch : false
    })

    .state("tipoparametro-edit", {
        url : "/metamodelo/tipoparametro/edit/:accion?id",
        templateUrl : "modules/metamodelo/tipoparametro-edit.html",
        controller : "TipoParametroEditController as vm",
    })

    .state("tiposubparametro-detail", {
        url : "/metamodelo/tiposubparametro/detail/:id?tab",
        templateUrl : "modules/metamodelo/tiposubparametro-detail.html",
        controller : "TipoSubparametroDetailController as vm",
        reloadOnSearch : false
    })

    .state("tiposubparametro-edit", {
        url : "/metamodelo/tiposubparametro/edit/:accion/:tpprId?id",
        templateUrl : "modules/metamodelo/tiposubparametro-edit.html",
        controller : "TipoSubparametroEditController as vm",
    })

    .state("tiposervicio-grid", {
        url : "/metamodelo/tiposervicio/grid?page&searchCriteria&limit",
        templateUrl : "modules/metamodelo/tiposervicio-grid.html",
        controller : "TipoServicioGridController as vm",
        reloadOnSearch : false
    })

    .state("tiposervicio-detail", {
        url : "/metamodelo/tiposervicio/detail/:id?tab",
        templateUrl : "modules/metamodelo/tiposervicio-detail.html",
        controller : "TipoServicioDetailController as vm",
        reloadOnSearch : false
    })

    .state("tiposervicio-edit", {
        url : "/metamodelo/tiposervicio/edit/:accion?id",
        templateUrl : "modules/metamodelo/tiposervicio-edit.html",
        controller : "TipoServicioEditController as vm",
    })

    .state("tiposubservicio-detail", {
        url : "/metamodelo/tiposubservicio/detail/:id?tab",
        templateUrl : "modules/metamodelo/tiposubservicio-detail.html",
        controller : "TipoSubservicioDetailController as vm",
        reloadOnSearch : false
    })

    .state("tiposubservicio-edit", {
        url : "/metamodelo/tiposubservicio/edit/:accion/:tpsrId?id",
        templateUrl : "modules/metamodelo/tiposubservicio-edit.html",
        controller : "TipoSubservicioEditController as vm",
    })

    .state("tipoestadistica-grid", {
        url : "/metamodelo/tipoestadistica/grid?page&searchCriteria&limit",
        templateUrl : "modules/metamodelo/tipoestadistica-grid.html",
        controller : "TipoEstadisticaGridController as vm",
        reloadOnSearch : false
    })

    .state("tipoestadistica-detail", {
        url : "/metamodelo/tipoestadistica/detail/:id?tab",
        templateUrl : "modules/metamodelo/tipoestadistica-detail.html",
        controller : "TipoEstadisticaDetailController as vm",
        reloadOnSearch : false
    })

    .state("tipoestadistica-edit", {
        url : "/metamodelo/tipoestadistica/edit/:accion?id",
        templateUrl : "modules/metamodelo/tipoestadistica-edit.html",
        controller : "TipoEstadisticaEditController as vm",
    })

    .state("campoagregacion-detail", {
        url : "/metamodelo/campoagregacion/detail/:tpesId/:entdId",
        templateUrl : "modules/metamodelo/campoagregacion-detail.html",
        controller : "CampoAgregacionDetailController as vm",
    })

    .state("campoagregacion-edit", {
        url : "/metamodelo/campoagregacion/edit/:accion/:tpesId?entdId",
        templateUrl : "modules/metamodelo/campoagregacion-edit.html",
        controller : "CampoAgregacionEditController as vm",
    })

    .state("entidadgrupodato-detail", {
        url : "/metamodelo/entidadgrupodato/detail/:id",
        templateUrl : "modules/metamodelo/entidadgrupodato-detail.html",
        controller : "EntidadGrupoDatoDetailController as vm",
    })

    .state("entidadgrupodato-edit", {
        url : "/metamodelo/entidadgrupodato/edit/:accion/:entiId?id",
        templateUrl : "modules/metamodelo/entidadgrupodato-edit.html",
        controller : "EntidadGrupoDatoEditController as vm",
    })

    .state("entidadtipodato-detail", {
        url : "/metamodelo/entidadtipodato/detail/:id",
        templateUrl : "modules/metamodelo/entidadtipodato-detail.html",
        controller : "EntidadTipoDatoDetailController as vm",
    })

    .state("entidadtipodato-edit", {
        url : "/metamodelo/entidadtipodato/edit/:accion/:entiId?id",
        templateUrl : "modules/metamodelo/entidadtipodato-edit.html",
        controller : "EntidadTipoDatoEditController as vm",
    })

    .state("tramite-detail", {
        url : "/metamodelo/tramite/detail/:id",
        templateUrl : "modules/metamodelo/tramite-detail.html",
        controller : "TramiteDetailController as vm",
    })

    .state("tramite-edit", {
        url : "/metamodelo/tramite/edit/:accion/:entiId?id",
        templateUrl : "modules/metamodelo/tramite-edit.html",
        controller : "TramiteEditController as vm",
    })

    .state("tramitetipodato-detail", {
        url : "/metamodelo/tramitetipodato/detail/:trmtId/:tpdtId",
        templateUrl : "modules/metamodelo/tramitetipodato-detail.html",
        controller : "TramiteTipoDatoDetailController as vm",
    })

    .state("tramitetipodato-edit", {
        url : "/metamodelo/tramitetipodato/edit/:accion/:trmtId?tpdtId",
        templateUrl : "modules/metamodelo/tramitetipodato-edit.html",
        controller : "TramiteTipoDatoEditController as vm",
    })

    .state("entidadaccion-detail", {
        url : "/metamodelo/entidadaccion/detail/:id",
        templateUrl : "modules/metamodelo/entidadaccion-detail.html",
        controller : "EntidadAccionDetailController as vm",
    })

    .state("entidadaccion-edit", {
        url : "/metamodelo/entidadaccion/edit/:accion/:entiId?id",
        templateUrl : "modules/metamodelo/entidadaccion-edit.html",
        controller : "EntidadAccionEditController as vm",
    })

    .state("entidadacciongrid-detail", {
        url : "/metamodelo/entidadacciongrid/detail/:id",
        templateUrl : "modules/metamodelo/entidadacciongrid-detail.html",
        controller : "EntidadAccionGridDetailController as vm",
    })

    .state("entidadacciongrid-edit", {
        url : "/metamodelo/entidadacciongrid/edit/:accion/:entiId?id",
        templateUrl : "modules/metamodelo/entidadacciongrid-edit.html",
        controller : "EntidadAccionGridEditController as vm",
    })

    .state("entidadentidad-edit", {
        url : "/metamodelo/entidadentidad/edit/:accion/:entiPadreId?entiHijaId",
        templateUrl : "modules/metamodelo/entidadentidad-edit.html",
        controller : "EntidadEntidadEditController as vm",
    })

    ;
}

function TipoDatoGridController($state, $stateParams, $modal, pageTitleService, TipoDatoService) {
    var vm = this;

    vm.filter = filter;
    vm.resetFilter = resetFilter;
    vm.search = search;
    vm.pageChanged = pageChanged;

    function filter() {
        TipoDatoService.filter(vm.searchCriteria).then(function(data) {
            vm.tphtList = data.tphtList;
            vm.tpelList = data.tpelList;
        });
    }

    function resetFilter() {
        vm.searchCriteria = {};
    }

    function search(page) {
        TipoDatoService.list(vm.searchCriteria, page, vm.limit).then(function(data) {
            vm.page = data.resultList.page;
            vm.limit = data.resultList.limit;
            vm.tpdtList = data.resultList;
        });
    }

    function pageChanged() {
        search(vm.page);
    }

    vm.searchCriteria = $stateParams.searchCriteria ? angular.fromJson($stateParams.searchCriteria) : {};
    vm.limit = $stateParams.limit;

    search($stateParams.page ? $stateParams.page : 1);

    pageTitleService.setTitle("tpdt", "page_grid");
}

function TipoDatoDetailController($stateParams, pageTitleService, TipoDatoService) {
    var vm = this;

    vm.remove = remove;

    function remove() {
        TipoDatoService.remove(vm.tpdt).then(function(data) {
            window.history.back();
        });
    }

    TipoDatoService.detail({
        id : $stateParams.id
    }).then(function(data) {
        vm.tpdt = data.model;
        vm.i18nMap = data.i18nMap;
    });

    pageTitleService.setTitle("tpdt", "page_detail");
}

function TipoDatoEditController($state, $stateParams, pageTitleService, TipoDatoService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        TipoDatoService.saveI18n(vm.accion, vm.tpdt, vm.i18nMap).then(function(data) {
            vm.accion == 'edit' ? setTimeout(function() {
                window.history.back();
            }, 0) : $state.go("tipodato-detail", data.model, {
                location : 'replace'
            });
        });
    }

    function cancel() {
        window.history.back();
    }

    vm.accion = $stateParams.accion;

    TipoDatoService.edit($stateParams.accion, {
        id : $stateParams.id
    }).then(function(data) {
        vm.tpdt = data.model;
        vm.i18nMap = data.i18nMap;

        vm.tphtList = data.tphtList;
        vm.tpelList = data.tpelList;
        vm.entiTpprList = data.tpprList;
        vm.entiTpsrList = data.tpsrList;
    });

    pageTitleService.setTitle("tpdt", "page_" + vm.accion);
}

function CodigoReferenciaDetailController($stateParams, pageTitleService, CodigoReferenciaService) {
    var vm = this;

    vm.remove = remove;

    function remove() {
        CodigoReferenciaService.remove(vm.cdrf).then(function(data) {
            window.history.back();
        });
    }

    CodigoReferenciaService.detail({
        id : $stateParams.id
    }).then(function(data) {
        vm.cdrf = data.model;
        vm.i18nMap = data.i18nMap;
    });

    pageTitleService.setTitle("cdrf", "page_detail");
}

function CodigoReferenciaEditController($state, $stateParams, pageTitleService, CodigoReferenciaService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        CodigoReferenciaService.saveI18n(vm.accion, vm.cdrf, vm.i18nMap).then(function(data) {
            vm.accion == 'edit' ? setTimeout(function() {
                window.history.back();
            }, 0) : $state.go("codigoreferencia-detail", data.model, {
                location : 'replace'
            });
        });
    }

    function cancel() {
        window.history.back();
    }

    vm.accion = $stateParams.accion;

    CodigoReferenciaService.edit($stateParams.accion, {
        tpdtId : $stateParams.tpdtId,
        id : $stateParams.id
    }).then(function(data) {
        vm.cdrf = data.model;
        vm.i18nMap = data.i18nMap;
    });

    pageTitleService.setTitle("cdrf", "page_" + vm.accion);
}

function TipoParametroGridController($state, $stateParams, $modal, pageTitleService, TipoParametroService) {
    var vm = this;

    vm.filter = filter;
    vm.resetFilter = resetFilter;
    vm.search = search;
    vm.pageChanged = pageChanged;

    function filter() {
        TipoParametroService.filter(vm.searchCriteria).then(function(data) {
        });
    }

    function resetFilter() {
        vm.searchCriteria = {};
    }

    function search(page) {
        TipoParametroService.list(vm.searchCriteria, page, vm.limit).then(function(data) {
            vm.page = data.resultList.page;
            vm.limit = data.resultList.limit;
            vm.entiList = data.resultList;
        });
    }

    function pageChanged() {
        search(vm.page);
    }

    vm.searchCriteria = $stateParams.searchCriteria ? angular.fromJson($stateParams.searchCriteria) : {};
    vm.limit = $stateParams.limit;

    search($stateParams.page ? $stateParams.page : 1);

    pageTitleService.setTitle("tppr", "page_grid");
}

function TipoParametroDetailController($stateParams, pageTitleService, TipoParametroService) {
    var vm = this;

    vm.remove = remove;
    vm.tabSelected = tabSelected;

    function remove() {
        TipoParametroService.remove(vm.enti).then(function(data) {
            window.history.back();
        });
    }

    function tabSelected(tabNo) {
        TipoParametroService.tabSelected(tabNo);
    }

    vm.tabActive = {};

    if ($stateParams.tab) {
        vm.tabActive[$stateParams.tab] = true;
    }

    TipoParametroService.detail({
        id : $stateParams.id
    }).then(function(data) {
        vm.enti = data.model;
        vm.i18nMap = data.i18nMap;
        vm.subentiList = data.subentiList;
        vm.entdList = data.entdList;
        vm.engdList = data.engdList;
        vm.enacList = data.enacList;
        vm.enagList = data.enagList;
    });

    pageTitleService.setTitle("tppr", "page_detail");
}

function TipoParametroEditController($state, $stateParams, pageTitleService, TipoParametroService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        TipoParametroService.saveI18n(vm.accion, vm.enti, vm.i18nMap).then(function(data) {
            vm.accion == 'edit' ? setTimeout(function() {
                window.history.back();
            }, 0) : $state.go("tipoparametro-detail", data.model, {
                location : 'replace'
            });
        });
    }

    function cancel() {
        window.history.back();
    }

    vm.accion = $stateParams.accion;

    TipoParametroService.edit($stateParams.accion, {
        id : $stateParams.id
    }).then(function(data) {
        vm.enti = data.model;
        vm.i18nMap = data.i18nMap;

        vm.tpdtNombreList = data.tpdtNombreList;
    });

    pageTitleService.setTitle("tppr", "page_" + vm.accion);
}

function TipoSubparametroDetailController($stateParams, pageTitleService, TipoSubparametroService) {
    var vm = this;

    vm.remove = remove;
    vm.tabSelected = tabSelected;

    function remove() {
        TipoSubparametroService.remove(vm.enti).then(function(data) {
            window.history.back();
        });
    }

    function tabSelected(tabNo) {
        TipoSubparametroService.tabSelected(tabNo);
    }

    vm.tabActive = {};

    if ($stateParams.tab) {
        vm.tabActive[$stateParams.tab] = true;
    }

    TipoSubparametroService.detail({
        id : $stateParams.id
    }).then(function(data) {
        vm.enti = data.model;
        vm.i18nMap = data.i18nMap;
        vm.entdList = data.entdList;
        vm.engdList = data.engdList;
        vm.enacList = data.enacList;
        vm.enagList = data.enagList;
    });

    pageTitleService.setTitle("tpsp", "page_detail");
}

function TipoSubparametroEditController($state, $stateParams, pageTitleService, TipoSubparametroService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        TipoSubparametroService.saveI18n(vm.accion, vm.enti, vm.i18nMap).then(function(data) {
            vm.accion == 'edit' ? setTimeout(function() {
                window.history.back();
            }, 0) : $state.go("tiposubparametro-detail", data.model, {
                location : 'replace'
            });
        });
    }

    function cancel() {
        window.history.back();
    }

    vm.accion = $stateParams.accion;

    TipoSubparametroService.edit($stateParams.accion, {
        tpprId : $stateParams.tpprId,
        id : $stateParams.id
    }).then(function(data) {
        vm.enti = data.model;
        vm.i18nMap = data.i18nMap;

        vm.entiList = data.tpprList;
    });

    pageTitleService.setTitle("tpsp", "page_" + vm.accion);
}

function TipoServicioGridController($state, $stateParams, $modal, pageTitleService, TipoServicioService) {
    var vm = this;

    vm.filter = filter;
    vm.resetFilter = resetFilter;
    vm.search = search;
    vm.pageChanged = pageChanged;

    function filter() {
        TipoServicioService.filter(vm.searchCriteria).then(function(data) {
        });
    }

    function resetFilter() {
        vm.searchCriteria = {};
    }

    function search(page) {
        TipoServicioService.list(vm.searchCriteria, page, vm.limit).then(function(data) {
            vm.page = data.resultList.page;
            vm.limit = data.resultList.limit;
            vm.entiList = data.resultList;
        });
    }

    function pageChanged() {
        search(vm.page);
    }

    vm.searchCriteria = $stateParams.searchCriteria ? angular.fromJson($stateParams.searchCriteria) : {};
    vm.limit = $stateParams.limit;

    search($stateParams.page ? $stateParams.page : 1);

    pageTitleService.setTitle("tpsr", "page_grid");
}

function TipoServicioDetailController($stateParams, pageTitleService, TipoServicioService) {
    var vm = this;

    vm.remove = remove;
    vm.tabSelected = tabSelected;

    function remove() {
        TipoServicioService.remove(vm.enti).then(function(data) {
            window.history.back();
        });
    }

    function tabSelected(tabNo) {
        TipoServicioService.tabSelected(tabNo);
    }

    vm.tabActive = {};

    if ($stateParams.tab) {
        vm.tabActive[$stateParams.tab] = true;
    }

    TipoServicioService.detail({
        id : $stateParams.id
    }).then(function(data) {
        vm.enti = data.model;
        vm.i18nMap = data.i18nMap;
        vm.subentiList = data.subentiList;
        vm.entiHijasList = data.entiHijasList;
        vm.entdList = data.entdList;
        vm.engdList = data.engdList;
        vm.trmtList = data.trmtList;
        vm.enacList = data.enacList;
        vm.enagList = data.enagList;
    });

    pageTitleService.setTitle("tpsr", "page_detail");
}

function TipoServicioEditController($state, $stateParams, pageTitleService, TipoServicioService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        TipoServicioService.saveI18n(vm.accion, vm.enti, vm.i18nMap).then(function(data) {
            vm.accion == 'edit' ? setTimeout(function() {
                window.history.back();
            }, 0) : $state.go("tiposervicio-detail", data.model, {
                location : 'replace'
            });
        });
    }

    function cancel() {
        window.history.back();
    }

    vm.accion = $stateParams.accion;

    TipoServicioService.edit($stateParams.accion, {
        id : $stateParams.id
    }).then(function(data) {
        vm.enti = data.model;
        vm.i18nMap = data.i18nMap;

        vm.tpdtEstadoList = data.tpdtEstadoList;
    });

    pageTitleService.setTitle("tpsr", "page_" + vm.accion);
}

function TipoSubservicioDetailController($stateParams, pageTitleService, TipoSubservicioService) {
    var vm = this;

    vm.remove = remove;
    vm.tabSelected = tabSelected;

    function remove() {
        TipoSubservicioService.remove(vm.enti).then(function(data) {
            window.history.back();
        });
    }

    function tabSelected(tabNo) {
        TipoSubservicioService.tabSelected(tabNo);
    }

    vm.tabActive = {};

    if ($stateParams.tab) {
        vm.tabActive[$stateParams.tab] = true;
    }

    TipoSubservicioService.detail({
        id : $stateParams.id
    }).then(function(data) {
        vm.enti = data.model;
        vm.i18nMap = data.i18nMap;
        vm.entiHijasList = data.entiHijasList;
        vm.entiPadresList = data.entiPadresList;
        vm.entdList = data.entdList;
        vm.engdList = data.engdList;
        vm.trmtList = data.trmtList;
        vm.enacList = data.enacList;
        vm.enagList = data.enagList;
    });

    pageTitleService.setTitle("tpss", "page_detail");
}

function TipoSubservicioEditController($state, $stateParams, pageTitleService, TipoSubservicioService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        TipoSubservicioService.saveI18n(vm.accion, vm.enti, vm.i18nMap).then(function(data) {
            vm.accion == 'edit' ? setTimeout(function() {
                window.history.back();
            }, 0) : $state.go("tiposubservicio-detail", data.model, {
                location : 'replace'
            });
        });
    }

    function cancel() {
        window.history.back();
    }

    vm.accion = $stateParams.accion;

    TipoSubservicioService.edit($stateParams.accion, {
        tpsrId : $stateParams.tpsrId,
        id : $stateParams.id
    }).then(function(data) {
        vm.enti = data.model;
        vm.i18nMap = data.i18nMap;

        vm.tpdtEstadoList = data.tpdtEstadoList;
    });

    pageTitleService.setTitle("tpss", "page_" + vm.accion);
}

function TipoEstadisticaGridController($state, $stateParams, $modal, pageTitleService, TipoEstadisticaService) {
    var vm = this;

    vm.filter = filter;
    vm.resetFilter = resetFilter;
    vm.search = search;
    vm.pageChanged = pageChanged;

    function filter() {
        TipoEstadisticaService.filter(vm.searchCriteria).then(function(data) {
        });
    }

    function resetFilter() {
        vm.searchCriteria = {};
    }

    function search(page) {
        TipoEstadisticaService.list(vm.searchCriteria, page, vm.limit).then(function(data) {
            vm.page = data.resultList.page;
            vm.limit = data.resultList.limit;
            vm.entiList = data.resultList;
        });
    }

    function pageChanged() {
        search(vm.page);
    }

    vm.searchCriteria = $stateParams.searchCriteria ? angular.fromJson($stateParams.searchCriteria) : {};
    vm.limit = $stateParams.limit;

    search($stateParams.page ? $stateParams.page : 1);

    pageTitleService.setTitle("tpes", "page_grid");
}

function TipoEstadisticaDetailController($stateParams, pageTitleService, TipoEstadisticaService) {
    var vm = this;

    vm.remove = remove;
    vm.tabSelected = tabSelected;

    function remove() {
        TipoEstadisticaService.remove(vm.enti).then(function(data) {
            window.history.back();
        });
    }

    function tabSelected(tabNo) {
        TipoEstadisticaService.tabSelected(tabNo);
    }

    vm.tabActive = {};

    if ($stateParams.tab) {
        vm.tabActive[$stateParams.tab] = true;
    }

    TipoEstadisticaService.detail({
        id : $stateParams.id
    }).then(function(data) {
        vm.enti = data.model;
        vm.i18nMap = data.i18nMap;
        vm.cmagList = data.cmagList;
        vm.subentiList = data.subentiList;
        vm.entdList = data.entdList;
        vm.engdList = data.engdList;
        vm.enacList = data.enacList;
        vm.enagList = data.enagList;
    });

    pageTitleService.setTitle("tpes", "page_detail");
}

function TipoEstadisticaEditController($state, $stateParams, pageTitleService, TipoEstadisticaService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        TipoEstadisticaService.saveI18n(vm.accion, vm.enti, vm.i18nMap).then(function(data) {
            vm.accion == 'edit' ? setTimeout(function() {
                window.history.back();
            }, 0) : $state.go("tipoestadistica-detail", data.model, {
                location : 'replace'
            });
        });
    }

    function cancel() {
        window.history.back();
    }

    vm.accion = $stateParams.accion;

    TipoEstadisticaService.edit($stateParams.accion, {
        id : $stateParams.id
    }).then(function(data) {
        vm.enti = data.model;
        vm.i18nMap = data.i18nMap;
    });

    pageTitleService.setTitle("tpes", "page_" + vm.accion);
}

function CampoAgregacionDetailController($stateParams, pageTitleService, CampoAgregacionService) {
    var vm = this;

    vm.remove = remove;

    function remove() {
        CampoAgregacionService.remove(vm.cmag).then(function(data) {
            window.history.back();
        });
    }

    CampoAgregacionService.detail({
        tpesId : $stateParams.tpesId,
        entd : {
            id : $stateParams.entdId
        }
    }).then(function(data) {
        vm.cmag = data.model;
    });

    pageTitleService.setTitle("cmag", "page_detail");
}

function CampoAgregacionEditController($state, $stateParams, pageTitleService, CampoAgregacionService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        CampoAgregacionService.save(vm.accion, vm.cmag).then(function(data) {
            vm.accion == 'edit' ? setTimeout(function() {
                window.history.back();
            }, 0) : $state.go("campoagregacion-detail", data.model, {
                location : 'replace'
            });
        });
    }

    function cancel() {
        window.history.back();
    }

    vm.accion = $stateParams.accion;

    CampoAgregacionService.edit($stateParams.accion, {
        tpesId : $stateParams.tpesId,
        entd : {
            id : $stateParams.entdId
        }
    }).then(function(data) {
        vm.cmag = data.model;
    });

    pageTitleService.setTitle("cmag", "page_" + vm.accion);
}

function EntidadTipoDatoDetailController($stateParams, pageTitleService, EntidadTipoDatoService) {
    var vm = this;

    vm.remove = remove;

    function remove() {
        EntidadTipoDatoService.remove(vm.entd).then(function(data) {
            window.history.back();
        });
    }

    EntidadTipoDatoService.detail({
        id : $stateParams.id
    }).then(function(data) {
        vm.entd = data.model;
        vm.i18nMap = data.i18nMap;
    });

    pageTitleService.setTitle("entd", "page_detail");
}

function EntidadTipoDatoEditController($state, $stateParams, pageTitleService, EntidadTipoDatoService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        EntidadTipoDatoService.saveI18n(vm.accion, vm.entd, vm.i18nMap).then(function(data) {
            vm.accion == 'edit' ? setTimeout(function() {
                window.history.back();
            }, 0) : $state.go("entidadtipodato-detail", data.model, {
                location : 'replace'
            });
        });
    }

    function cancel() {
        window.history.back();
    }

    vm.accion = $stateParams.accion;

    EntidadTipoDatoService.edit($stateParams.accion, {
        entiId : $stateParams.entiId,
        id : $stateParams.id
    }).then(function(data) {
        vm.entd = data.model;
        vm.i18nMap = data.i18nMap;

        vm.tpdtList = data.tpdtList;
        vm.engdList = data.engdList;
    });

    pageTitleService.setTitle("entd", "page_" + vm.accion);
}

function EntidadGrupoDatoDetailController($stateParams, pageTitleService, EntidadGrupoDatoService) {
    var vm = this;

    vm.remove = remove;

    function remove() {
        EntidadGrupoDatoService.remove(vm.engd).then(function(data) {
            window.history.back();
        });
    }

    EntidadGrupoDatoService.detail({
        id : $stateParams.id
    }).then(function(data) {
        vm.engd = data.model;
        vm.i18nMap = data.i18nMap;
    });

    pageTitleService.setTitle("engd", "page_detail");
}

function EntidadGrupoDatoEditController($state, $stateParams, pageTitleService, EntidadGrupoDatoService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        EntidadGrupoDatoService.saveI18n(vm.accion, vm.engd, vm.i18nMap).then(function(data) {
            vm.accion == 'edit' ? setTimeout(function() {
                window.history.back();
            }, 0) : $state.go("entidadgrupodato-detail", data.model, {
                location : 'replace'
            });
        });
    }

    function cancel() {
        window.history.back();
    }

    vm.accion = $stateParams.accion;

    EntidadGrupoDatoService.edit($stateParams.accion, {
        entiId : $stateParams.entiId,
        id : $stateParams.id
    }).then(function(data) {
        vm.engd = data.model;
        vm.i18nMap = data.i18nMap;
    });

    pageTitleService.setTitle("engd", "page_" + vm.accion);
}

function TramiteDetailController($stateParams, pageTitleService, TramiteService) {
    var vm = this;

    vm.remove = remove;

    function remove() {
        TramiteService.remove(vm.trmt).then(function(data) {
            window.history.back();
        });
    }

    TramiteService.detail({
        id : $stateParams.id
    }).then(function(data) {
        vm.trmt = data.model;
        vm.i18nMap = data.i18nMap;

        vm.trtdList = data.trtdList;
        vm.enti = data.enti;
    });

    pageTitleService.setTitle("trmt", "page_detail");
}

function TramiteEditController($state, $stateParams, pageTitleService, TramiteService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        TramiteService.saveI18n(vm.accion, vm.trmt, vm.i18nMap).then(function(data) {
            vm.accion == 'edit' ? setTimeout(function() {
                window.history.back();
            }, 0) : $state.go("tramite-detail", data.model, {
                location : 'replace'
            });
        });
    }

    function cancel() {
        window.history.back();
    }

    vm.accion = $stateParams.accion;

    TramiteService.edit($stateParams.accion, {
        entiId : $stateParams.entiId,
        id : $stateParams.id
    }).then(function(data) {
        vm.trmt = data.model;
        vm.i18nMap = data.i18nMap;

        vm.tpdtEstado = data.tpdtEstado;
    });

    pageTitleService.setTitle("trmt", "page_" + vm.accion);
}

function TramiteTipoDatoDetailController($stateParams, pageTitleService, TramiteTipoDatoService) {
    var vm = this;

    vm.remove = remove;

    function remove() {
        TramiteTipoDatoService.remove(vm.trtd).then(function(data) {
            window.history.back();
        });
    }

    TramiteTipoDatoService.detail({
        trmtId : $stateParams.trmtId,
        entd : {
            tpdt : {
                id : $stateParams.tpdtId
            }
        }
    }).then(function(data) {
        vm.trtd = data.model;
    });

    pageTitleService.setTitle("trtd", "page_detail");
}

function TramiteTipoDatoEditController($state, $stateParams, pageTitleService, TramiteTipoDatoService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        TramiteTipoDatoService.save(vm.accion, vm.trtd).then(function(data) {
            vm.accion == 'edit' ? setTimeout(function() {
                window.history.back();
            }, 0) : $state.go("tramitetipodato-detail", data.model, {
                location : 'replace'
            });
        });
    }

    function cancel() {
        window.history.back();
    }

    vm.accion = $stateParams.accion;

    TramiteTipoDatoService.edit($stateParams.accion, {
        trmtId : $stateParams.trmtId,
        entd : {
            tpdt : {
                id : $stateParams.tpdtId
            }
        }
    }).then(function(data) {
        vm.trtd = data.model;

        vm.entdList = data.entdList;
    });

    pageTitleService.setTitle("trtd", "page_" + vm.accion);
}

function EntidadAccionDetailController($stateParams, pageTitleService, EntidadAccionService) {
    var vm = this;

    vm.remove = remove;

    function remove() {
        EntidadAccionService.remove(vm.enac).then(function(data) {
            window.history.back();
        });
    }

    EntidadAccionService.detail({
        id : $stateParams.id
    }).then(function(data) {
        vm.enac = data.model;
        vm.i18nMap = data.i18nMap;
    });

    pageTitleService.setTitle("enac", "page_detail");
}

function EntidadAccionEditController($state, $stateParams, pageTitleService, EntidadAccionService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        EntidadAccionService.saveI18n(vm.accion, vm.enac, vm.i18nMap).then(function(data) {
            vm.accion == 'edit' ? setTimeout(function() {
                window.history.back();
            }, 0) : $state.go("entidadaccion-detail", data.model, {
                location : 'replace'
            });
        });
    }

    function cancel() {
        window.history.back();
    }

    vm.accion = $stateParams.accion;

    EntidadAccionService.edit($stateParams.accion, {
        entiId : $stateParams.entiId,
        id : $stateParams.id
    }).then(function(data) {
        vm.enac = data.model;
        vm.i18nMap = data.i18nMap;
    });

    pageTitleService.setTitle("enac", "page_" + vm.accion);
}

function EntidadAccionGridDetailController($stateParams, pageTitleService, EntidadAccionGridService) {
    var vm = this;

    vm.remove = remove;

    function remove() {
        EntidadAccionGridService.remove(vm.enag).then(function(data) {
            window.history.back();
        });
    }

    EntidadAccionGridService.detail({
        id : $stateParams.id
    }).then(function(data) {
        vm.enag = data.model;
        vm.i18nMap = data.i18nMap;
    });

    pageTitleService.setTitle("enag", "page_detail");
}

function EntidadAccionGridEditController($state, $stateParams, pageTitleService, EntidadAccionGridService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        EntidadAccionGridService.saveI18n(vm.accion, vm.enag, vm.i18nMap).then(function(data) {
            vm.accion == 'edit' ? setTimeout(function() {
                window.history.back();
            }, 0) : $state.go("entidadacciongrid-detail", data.model, {
                location : 'replace'
            });
        });
    }

    function cancel() {
        window.history.back();
    }

    vm.accion = $stateParams.accion;

    EntidadAccionGridService.edit($stateParams.accion, {
        entiId : $stateParams.entiId,
        id : $stateParams.id
    }).then(function(data) {
        vm.enag = data.model;
        vm.i18nMap = data.i18nMap;
    });

    pageTitleService.setTitle("enag", "page_" + vm.accion);
}

function EntidadEntidadEditController($state, $stateParams, pageTitleService, EntidadEntidadService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        EntidadEntidadService.saveI18n(vm.accion, vm.enen, vm.i18nMap).then(function(data) {
            vm.accion == 'edit' ? setTimeout(function() {
                window.history.back();
            }, 0) : $state.go("entidadentidad-detail", data.model, {
                location : 'replace'
            });
        });
    }

    function cancel() {
        window.history.back();
    }

    vm.accion = $stateParams.accion;

    EntidadEntidadService.edit($stateParams.accion, {
        entiPadreId : $stateParams.entiPadreId,
        entiHija : {
            id : $stateParams.entiHijaId
        }
    }).then(function(data) {
        vm.enen = data.model;

        vm.entiList = data.tpssList;
    });

    pageTitleService.setTitle("enen", "page_" + vm.accion);
}
