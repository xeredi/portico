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

    .state("tipo-dato-grid", {
        url : "/metamodelo/tipo-dato/grid?page&searchCriteria&limit",
        templateUrl : "modules/metamodelo/tipo-dato-grid.html",
        controller : "TipoDatoGridController as vm",
        reloadOnSearch : false
    })

    .state("tipo-dato-detail", {
        url : "/metamodelo/tipo-dato/detail/:id",
        templateUrl : "modules/metamodelo/tipo-dato-detail.html",
        controller : "TipoDatoDetailController as vm",
    })

    .state("tipo-dato-create", {
        url : "/metamodelo/tipo-dato/create",
        templateUrl : "modules/metamodelo/tipo-dato-edit.html",
        controller : "TipoDatoEditController as vm",
        data : {
            accion : 'create'
        }
    })

    .state("tipo-dato-edit", {
        url : "/metamodelo/tipo-dato/edit/:id",
        templateUrl : "modules/metamodelo/tipo-dato-edit.html",
        controller : "TipoDatoEditController as vm",
        data : {
            accion : 'edit'
        }
    })

    .state("codigo-referencia-detail", {
        url : "/metamodelo/codigo-referencia/detail/:id",
        templateUrl : "modules/metamodelo/codigo-referencia-detail.html",
        controller : "CodigoReferenciaDetailController as vm",
    })

    .state("codigo-referencia-create", {
        url : "/metamodelo/codigo-referencia/create/:tpdtId",
        templateUrl : "modules/metamodelo/codigo-referencia-edit.html",
        controller : "CodigoReferenciaEditController as vm",
        data : {
            accion : 'create'
        }
    })

    .state("codigo-referencia-edit", {
        url : "/metamodelo/codigo-referencia/edit/:id",
        templateUrl : "modules/metamodelo/codigo-referencia-edit.html",
        controller : "CodigoReferenciaEditController as vm",
        data : {
            accion : 'edit'
        }
    })

    .state("tipo-parametro-grid", {
        url : "/metamodelo/tipo-parametro/grid?page&searchCriteria&limit",
        templateUrl : "modules/metamodelo/tipo-parametro-grid.html",
        controller : "TipoParametroGridController as vm",
        reloadOnSearch : false
    })

    .state("tipo-parametro-detail", {
        url : "/metamodelo/tipo-parametro/detail/:id?tab",
        templateUrl : "modules/metamodelo/tipo-parametro-detail.html",
        controller : "TipoParametroDetailController as vm",
        reloadOnSearch : false
    })

    .state("tipo-parametro-create", {
        url : "/metamodelo/tipo-parametro/create",
        templateUrl : "modules/metamodelo/tipo-parametro-edit.html",
        controller : "TipoParametroEditController as vm",
        data : {
            accion : 'create'
        }
    })

    .state("tipo-parametro-edit", {
        url : "/metamodelo/tipo-parametro/edit/:id",
        templateUrl : "modules/metamodelo/tipo-parametro-edit.html",
        controller : "TipoParametroEditController as vm",
        data : {
            accion : 'edit'
        }
    })

    .state("tipo-subparametro-detail", {
        url : "/metamodelo/tipo-subparametro/detail/:id?tab",
        templateUrl : "modules/metamodelo/tipo-subparametro-detail.html",
        controller : "TipoSubparametroDetailController as vm",
        reloadOnSearch : false
    })

    .state("tipo-subparametro-create", {
        url : "/metamodelo/tipo-subparametro/create/:tpprId",
        templateUrl : "modules/metamodelo/tipo-subparametro-edit.html",
        controller : "TipoSubparametroEditController as vm",
        data : {
            accion : 'create'
        }
    })

    .state("tipo-subparametro-edit", {
        url : "/metamodelo/tipo-subparametro/edit/:id",
        templateUrl : "modules/metamodelo/tipo-subparametro-edit.html",
        controller : "TipoSubparametroEditController as vm",
        data : {
            accion : 'edit'
        }
    })

    .state("tipo-servicio-grid", {
        url : "/metamodelo/tipo-servicio/grid?page&searchCriteria&limit",
        templateUrl : "modules/metamodelo/tipo-servicio-grid.html",
        controller : "TipoServicioGridController as vm",
        reloadOnSearch : false
    })

    .state("tipo-servicio-detail", {
        url : "/metamodelo/tipo-servicio/detail/:id?tab",
        templateUrl : "modules/metamodelo/tipo-servicio-detail.html",
        controller : "TipoServicioDetailController as vm",
        reloadOnSearch : false
    })

    .state("tipo-servicio-create", {
        url : "/metamodelo/tipo-servicio/create",
        templateUrl : "modules/metamodelo/tipo-servicio-edit.html",
        controller : "TipoServicioEditController as vm",
        data : {
            accion : 'create'
        }
    })

    .state("tipo-servicio-edit", {
        url : "/metamodelo/tipo-servicio/edit/:id",
        templateUrl : "modules/metamodelo/tipo-servicio-edit.html",
        controller : "TipoServicioEditController as vm",
        data : {
            accion : 'edit'
        }
    })

    .state("tipo-subservicio-detail", {
        url : "/metamodelo/tipo-subservicio/detail/:id?tab",
        templateUrl : "modules/metamodelo/tipo-subservicio-detail.html",
        controller : "TipoSubservicioDetailController as vm",
        reloadOnSearch : false
    })

    .state("tipo-subservicio-create", {
        url : "/metamodelo/tipo-subservicio/create/:tpsrId",
        templateUrl : "modules/metamodelo/tipo-subservicio-edit.html",
        controller : "TipoSubservicioEditController as vm",
        data : {
            accion : 'create'
        }
    })

    .state("tipo-subservicio-edit", {
        url : "/metamodelo/tipo-subservicio/edit/:id",
        templateUrl : "modules/metamodelo/tipo-subservicio-edit.html",
        controller : "TipoSubservicioEditController as vm",
        data : {
            accion : 'edit'
        }
    })

    .state("tipo-estadistica-grid", {
        url : "/metamodelo/tipo-estadistica/grid?page&searchCriteria&limit",
        templateUrl : "modules/metamodelo/tipo-estadistica-grid.html",
        controller : "TipoEstadisticaGridController as vm",
        reloadOnSearch : false
    })

    .state("tipo-estadistica-detail", {
        url : "/metamodelo/tipo-estadistica/detail/:id?tab",
        templateUrl : "modules/metamodelo/tipo-estadistica-detail.html",
        controller : "TipoEstadisticaDetailController as vm",
        reloadOnSearch : false
    })

    .state("tipo-estadistica-create", {
        url : "/metamodelo/tipo-estadistica/create",
        templateUrl : "modules/metamodelo/tipo-estadistica-edit.html",
        controller : "TipoEstadisticaEditController as vm",
        data : {
            accion : 'create'
        }
    })

    .state("tipo-estadistica-edit", {
        url : "/metamodelo/tipo-estadistica/edit/:id",
        templateUrl : "modules/metamodelo/tipo-estadistica-edit.html",
        controller : "TipoEstadisticaEditController as vm",
        data : {
            accion : 'edit'
        }
    })

    .state("campo-agregacion-detail", {
        url : "/metamodelo/campo-agregacion/detail/:tpesId/:entdId",
        templateUrl : "modules/metamodelo/campo-agregacion-detail.html",
        controller : "CampoAgregacionDetailController as vm",
    })

    .state("campo-agregacion-create", {
        url : "/metamodelo/campo-agregacion/create/:tpesId",
        templateUrl : "modules/metamodelo/campo-agregacion-edit.html",
        controller : "CampoAgregacionEditController as vm",
        data : {
            accion : 'create'
        }
    })

    .state("campo-agregacion-edit", {
        url : "/metamodelo/campo-agregacion/edit/:tpesId/:entdId",
        templateUrl : "modules/metamodelo/campo-agregacion-edit.html",
        controller : "CampoAgregacionEditController as vm",
        data : {
            accion : 'edit'
        }
    })

    .state("entidad-grupo-dato-detail", {
        url : "/metamodelo/entidad-grupo-dato/detail/:id",
        templateUrl : "modules/metamodelo/entidad-grupo-dato-detail.html",
        controller : "EntidadGrupoDatoDetailController as vm",
    })

    .state("entidad-grupo-dato-create", {
        url : "/metamodelo/entidad-grupo-dato/create/:entiId",
        templateUrl : "modules/metamodelo/entidad-grupo-dato-edit.html",
        controller : "EntidadGrupoDatoEditController as vm",
        data : {
            accion : 'create'
        }
    })

    .state("entidad-grupo-dato-edit", {
        url : "/metamodelo/entidad-grupo-dato/edit/:entiId/:id",
        templateUrl : "modules/metamodelo/entidad-grupo-dato-edit.html",
        controller : "EntidadGrupoDatoEditController as vm",
        data : {
            accion : 'edit'
        }
    })

    .state("entidad-tipo-dato-detail", {
        url : "/metamodelo/entidad-tipo-dato/detail/:id",
        templateUrl : "modules/metamodelo/entidad-tipo-dato-detail.html",
        controller : "EntidadTipoDatoDetailController as vm",
    })

    .state("entidad-tipo-dato-create", {
        url : "/metamodelo/entidad-tipo-dato/create/:entiId",
        templateUrl : "modules/metamodelo/entidad-tipo-dato-edit.html",
        controller : "EntidadTipoDatoEditController as vm",
        data : {
            accion : 'create'
        }
    })

    .state("entidad-tipo-dato-edit", {
        url : "/metamodelo/entidad-tipo-dato/edit/:entiId/:id",
        templateUrl : "modules/metamodelo/entidad-tipo-dato-edit.html",
        controller : "EntidadTipoDatoEditController as vm",
        data : {
            accion : 'edit'
        }
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

    .state("entidad-accion-detail", {
        url : "/metamodelo/entidad-accion/detail/:id",
        templateUrl : "modules/metamodelo/entidad-accion-detail.html",
        controller : "EntidadAccionDetailController as vm",
    })

    .state("entidad-accion-create", {
        url : "/metamodelo/entidad-accion/create/:entiId",
        templateUrl : "modules/metamodelo/entidad-accion-edit.html",
        controller : "EntidadAccionEditController as vm",
        data : {
            accion : 'create'
        }
    })

    .state("entidad-accion-edit", {
        url : "/metamodelo/entidad-accion/edit/:id",
        templateUrl : "modules/metamodelo/entidad-accion-edit.html",
        controller : "EntidadAccionEditController as vm",
        data : {
            accion : 'edit'
        }
    })

    .state("entidad-accion-grid-detail", {
        url : "/metamodelo/entidad-accion-grid/detail/:id",
        templateUrl : "modules/metamodelo/entidad-accion-grid-detail.html",
        controller : "EntidadAccionGridDetailController as vm",
    })

    .state("entidad-accion-grid-create", {
        url : "/metamodelo/entidad-accion-grid/create/:entiId",
        templateUrl : "modules/metamodelo/entidad-accion-grid-edit.html",
        controller : "EntidadAccionGridEditController as vm",
        data : {
            accion : 'create'
        }
    })

    .state("entidad-accion-grid-edit", {
        url : "/metamodelo/entidad-accion-grid/edit/:id",
        templateUrl : "modules/metamodelo/entidad-accion-grid-edit.html",
        controller : "EntidadAccionGridEditController as vm",
        data : {
            accion : 'edit'
        }
    })

    .state("entidad-entidad-create", {
        url : "/metamodelo/entidad-entidad/create/:entiPadreId",
        templateUrl : "modules/metamodelo/entidad-entidad-edit.html",
        controller : "EntidadEntidadEditController as vm",
        data : {
            accion : 'create'
        }
    })

    .state("entidad-entidad-edit", {
        url : "/metamodelo/entidad-entidad/edit/:entiPadreId/:entiHijaId",
        templateUrl : "modules/metamodelo/entidad-entidad-edit.html",
        controller : "EntidadEntidadEditController as vm",
        data : {
            accion : 'edit'
        }
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
        TipoDatoService.listPage(vm.searchCriteria, page, vm.limit).then(function(data) {
            vm.page = data.resultList.page;
            vm.limit = data.resultList.limit;
            vm.resultList = data.resultList;
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
        TipoDatoService.remove(vm.model).then(function(data) {
            window.history.back();
        });
    }

    vm.model = {
        id : $stateParams.id
    };

    TipoDatoService.detail(vm.model).then(function(data) {
        vm.model = data.model;
        vm.i18nMap = data.i18nMap;
    });

    pageTitleService.setTitle("tpdt", "page_detail");
}

function TipoDatoEditController($state, $stateParams, pageTitleService, TipoDatoService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        TipoDatoService.saveI18n(vm.accion, vm.model, vm.i18nMap).then(function(data) {
            TipoDatoService.redirectAfterSave(vm.accion, data.model, "tipo-dato-detail");
        });
    }

    function cancel() {
        window.history.back();
    }

    vm.accion = $state.current.data.accion;
    vm.model = {
        id : $stateParams.id
    }

    TipoDatoService.edit(vm.accion, vm.model).then(function(data) {
        vm.model = data.model;
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
        CodigoReferenciaService.remove(vm.model).then(function(data) {
            window.history.back();
        });
    }

    vm.model = {
        id : $stateParams.id
    }

    CodigoReferenciaService.detail(vm.model).then(function(data) {
        vm.model = data.model;
        vm.i18nMap = data.i18nMap;
    });

    pageTitleService.setTitle("cdrf", "page_detail");
}

function CodigoReferenciaEditController($state, $stateParams, pageTitleService, CodigoReferenciaService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        CodigoReferenciaService.saveI18n(vm.accion, vm.model, vm.i18nMap).then(function(data) {
            CodigoReferenciaService.redirectAfterSave(vm.accion, data.model, "codigo-referencia-detail");
        });
    }

    function cancel() {
        window.history.back();
    }

    vm.accion = $state.current.data.accion;
    vm.model = {
        tpdtId : $stateParams.tpdtId,
        id : $stateParams.id
    }

    CodigoReferenciaService.edit(vm.accion, vm.model).then(function(data) {
        vm.model = data.model;
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
        TipoParametroService.listPage(vm.searchCriteria, page, vm.limit).then(function(data) {
            vm.page = data.resultList.page;
            vm.limit = data.resultList.limit;
            vm.resultList = data.resultList;
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
        TipoParametroService.remove(vm.model).then(function(data) {
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

    vm.model = {
        id : $stateParams.id
    };

    TipoParametroService.detail(vm.model).then(function(data) {
        vm.model = data.model;
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
        TipoParametroService.saveI18n(vm.accion, vm.model, vm.i18nMap).then(function(data) {
            TipoParametroService.redirectAfterSave(vm.accion, data.model, "tipo-parametro-detail");
        });
    }

    function cancel() {
        window.history.back();
    }

    vm.accion = $state.current.data.accion;
    vm.model = {
        id : $stateParams.id
    }

    TipoParametroService.edit(vm.accion, vm.model).then(function(data) {
        vm.model = data.model;
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
        TipoSubparametroService.remove(vm.model).then(function(data) {
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

    vm.model = {
        id : $stateParams.id
    };

    TipoSubparametroService.detail(vm.model).then(function(data) {
        vm.model = data.model;
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
        TipoSubparametroService.saveI18n(vm.accion, vm.model, vm.i18nMap).then(function(data) {
            TipoSubparametroService.redirectAfterSave(vm.accion, data.model, "tipo-subparametro-detail");
        });
    }

    function cancel() {
        window.history.back();
    }

    vm.accion = $state.current.data.accion;
    vm.model = {
        tpprId : $stateParams.tpprId,
        id : $stateParams.id
    }

    TipoSubparametroService.edit(vm.accion, vm.model).then(function(data) {
        vm.model = data.model;
        vm.i18nMap = data.i18nMap;

        vm.tpprList = data.tpprList;
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
        TipoServicioService.listPage(vm.searchCriteria, page, vm.limit).then(function(data) {
            vm.page = data.resultList.page;
            vm.limit = data.resultList.limit;
            vm.resultList = data.resultList;
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
        TipoServicioService.remove(vm.model).then(function(data) {
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

    vm.model = {
        id : $stateParams.id
    };

    TipoServicioService.detail(vm.model).then(function(data) {
        vm.model = data.model;
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
        TipoServicioService.saveI18n(vm.accion, vm.model, vm.i18nMap).then(function(data) {
            TipoServicioService.redirectAfterSave(vm.accion, data.model, "tipo-servicio-detail");
        });
    }

    function cancel() {
        window.history.back();
    }

    vm.accion = $state.current.data.accion;
    vm.model = {
        id : $stateParams.id
    }

    TipoServicioService.edit(vm.accion, vm.model).then(function(data) {
        vm.model = data.model;
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
        TipoSubservicioService.remove(vm.model).then(function(data) {
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

    vm.model = {
        id : $stateParams.id
    };

    TipoSubservicioService.detail(vm.model).then(function(data) {
        vm.model = data.model;
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
        TipoSubservicioService.saveI18n(vm.accion, vm.model, vm.i18nMap).then(function(data) {
            TipoSubservicioService.redirectAfterSave(vm.accion, data.model, "tipo-subservicio-detail");
        });
    }

    function cancel() {
        window.history.back();
    }

    vm.accion = $state.current.data.accion;
    vm.model = {
        tpsrId : $stateParams.tpsrId,
        id : $stateParams.id
    }

    TipoSubservicioService.edit(vm.accion, vm.model).then(function(data) {
        vm.model = data.model;
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
        TipoEstadisticaService.listPage(vm.searchCriteria, page, vm.limit).then(function(data) {
            vm.page = data.resultList.page;
            vm.limit = data.resultList.limit;
            vm.resultList = data.resultList;
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
        TipoEstadisticaService.remove(vm.model).then(function(data) {
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

    vm.model = {
        id : $stateParams.id
    };

    TipoEstadisticaService.detail(vm.model).then(function(data) {
        vm.model = data.model;
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
        TipoEstadisticaService.saveI18n(vm.accion, vm.model, vm.i18nMap).then(function(data) {
            TipoEstadisticaService.redirectAfterSave(vm.accion, data.model, "tipo-estadistica-detail");
        });
    }

    function cancel() {
        window.history.back();
    }

    vm.accion = $state.current.data.accion;
    vm.model = {
        id : $stateParams.id
    }

    TipoEstadisticaService.edit(vm.accion, vm.model).then(function(data) {
        vm.model = data.model;
        vm.i18nMap = data.i18nMap;
    });

    pageTitleService.setTitle("tpes", "page_" + vm.accion);
}

function CampoAgregacionDetailController($stateParams, pageTitleService, CampoAgregacionService) {
    var vm = this;

    vm.remove = remove;

    function remove() {
        CampoAgregacionService.remove(vm.model).then(function(data) {
            window.history.back();
        });
    }

    vm.model = {
        tpesId : $stateParams.tpesId,
        entd : {
            id : $stateParams.entdId
        }
    }

    CampoAgregacionService.detail(vm.model).then(function(data) {
        vm.model = data.model;
    });

    pageTitleService.setTitle("cmag", "page_detail");
}

function CampoAgregacionEditController($state, $stateParams, pageTitleService, CampoAgregacionService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        CampoAgregacionService.save(vm.accion, vm.model).then(function(data) {
            CampoAgregacionService.redirectAfterSave(vm.accion, data.model, "campo-agregacion-detail");
        });
    }

    function cancel() {
        window.history.back();
    }

    vm.accion = $state.current.data.accion;
    vm.model = {
        tpesId : $stateParams.tpesId,
        entd : {
            id : $stateParams.entdId
        }
    }

    CampoAgregacionService.edit(vm.accion, vm.model).then(function(data) {
        vm.model = data.model;
    });

    pageTitleService.setTitle("cmag", "page_" + vm.accion);
}

function EntidadTipoDatoDetailController($stateParams, pageTitleService, EntidadTipoDatoService) {
    var vm = this;

    vm.remove = remove;

    function remove() {
        EntidadTipoDatoService.remove(vm.model).then(function(data) {
            window.history.back();
        });
    }

    vm.model = {
        id : $stateParams.id
    };

    EntidadTipoDatoService.detail(vm.model).then(function(data) {
        vm.model = data.model;
        vm.i18nMap = data.i18nMap;
    });

    pageTitleService.setTitle("entd", "page_detail");
}

function EntidadTipoDatoEditController($state, $stateParams, pageTitleService, EntidadTipoDatoService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        EntidadTipoDatoService.saveI18n(vm.accion, vm.model, vm.i18nMap).then(function(data) {
            EntidadTipoDatoService.redirectAfterSave(vm.accion, data.model, "entidad-tipo-dato-detail");
        });
    }

    function cancel() {
        window.history.back();
    }

    vm.accion = $state.current.data.accion;
    vm.model = {
        entiId : $stateParams.entiId,
        id : $stateParams.id
    }

    EntidadTipoDatoService.edit(vm.accion, vm.model).then(function(data) {
        vm.model = data.model;
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
        EntidadGrupoDatoService.remove(vm.model).then(function(data) {
            window.history.back();
        });
    }

    vm.model = {
        id : $stateParams.id
    };

    EntidadGrupoDatoService.detail(vm.model).then(function(data) {
        vm.model = data.model;
        vm.i18nMap = data.i18nMap;
    });

    pageTitleService.setTitle("engd", "page_detail");
}

function EntidadGrupoDatoEditController($state, $stateParams, pageTitleService, EntidadGrupoDatoService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        EntidadGrupoDatoService.saveI18n(vm.accion, vm.model, vm.i18nMap).then(function(data) {
            EntidadGrupoDatoService.redirectAfterSave(vm.accion, data.model, "entidad-grupo-dato-detail");
        });
    }

    function cancel() {
        window.history.back();
    }

    vm.accion = $state.current.data.accion;
    vm.model = {
        entiId : $stateParams.entiId,
        id : $stateParams.id
    }

    EntidadGrupoDatoService.edit(vm.accion, vm.model).then(function(data) {
        vm.model = data.model;
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
        EntidadAccionService.remove(vm.model).then(function(data) {
            window.history.back();
        });
    }

    vm.model = {
        id : $stateParams.id
    }

    EntidadAccionService.detail(vm.model).then(function(data) {
        vm.model = data.model;
        vm.i18nMap = data.i18nMap;
    });

    pageTitleService.setTitle("enac", "page_detail");
}

function EntidadAccionEditController($state, $stateParams, pageTitleService, EntidadAccionService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        EntidadAccionService.saveI18n(vm.accion, vm.model, vm.i18nMap).then(function(data) {
            EntidadAccionService.redirectAfterSave(vm.accion, data.model, "entidad-accion-detail");
        });
    }

    function cancel() {
        window.history.back();
    }

    vm.accion = $state.current.data.accion;
    vm.model = {
        entiId : $stateParams.entiId,
        id : $stateParams.id
    }

    EntidadAccionService.edit(vm.accion, vm.model).then(function(data) {
        vm.model = data.model;
        vm.i18nMap = data.i18nMap;
    });

    pageTitleService.setTitle("enag", "page_" + vm.accion);
}

function EntidadAccionGridDetailController($stateParams, pageTitleService, EntidadAccionGridService) {
    var vm = this;

    vm.remove = remove;

    function remove() {
        EntidadAccionGridService.remove(vm.model).then(function(data) {
            window.history.back();
        });
    }

    vm.model = {
        id : $stateParams.id
    }

    EntidadAccionGridService.detail(vm.model).then(function(data) {
        vm.model = data.model;
        vm.i18nMap = data.i18nMap;
    });

    pageTitleService.setTitle("enag", "page_detail");
}

function EntidadAccionGridEditController($state, $stateParams, pageTitleService, EntidadAccionGridService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        EntidadAccionGridService.saveI18n(vm.accion, vm.model, vm.i18nMap).then(function(data) {
            EntidadAccionGridService.redirectAfterSave(vm.accion, data.model, "entidad-accion-grid-detail");
        });
    }

    function cancel() {
        window.history.back();
    }

    vm.accion = $state.current.data.accion;
    vm.model = {
        entiId : $stateParams.entiId,
        id : $stateParams.id
    }

    EntidadAccionGridService.edit(vm.accion, vm.model).then(function(data) {
        vm.model = data.model;
        vm.i18nMap = data.i18nMap;
    });

    pageTitleService.setTitle("enag", "page_" + vm.accion);
}

function EntidadEntidadEditController($state, $stateParams, pageTitleService, EntidadEntidadService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        EntidadEntidadService.saveI18n(vm.accion, vm.model, vm.i18nMap).then(function(data) {
            EntidadEntidadService.redirectAfterSave(vm.accion, data.model, "entidad-entidad-detail");
        });
    }

    function cancel() {
        window.history.back();
    }

    vm.accion = $state.current.data.accion;
    vm.model = {
        entiPadreId : $stateParams.entiPadreId,
        entiHija : {
            id : $stateParams.entiHijaId
        }
    }

    EntidadEntidadService.edit(vm.accion, vm.model).then(function(data) {
        vm.model = data.model;
        vm.i18nMap = data.i18nMap;

        vm.entiList = data.tpssList;
    });

    pageTitleService.setTitle("enen", "page_" + vm.accion);
}
