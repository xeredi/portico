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
.controller("TpesGridController", TpesGridController)

.controller("TpesDetailController", TpesDetailController)

.controller("TpesEditController", TpesEditController)

.controller("CmagDetailController", CmagDetailController)

.controller("CmagEditController", CmagEditController)

// ------------------- GRUPO DE DATO DE ENTIDAD --------------------
.controller("EngdDetailController", EngdDetailController)

.controller("EngdEditController", EngdEditController)

// ------------------- DATO DE ENTIDAD --------------------
.controller("EntdDetailController", EntdDetailController)

.controller("EntdEditController", EntdEditController)

// ------------------- TRAMITE --------------------
.controller("TrmtDetailController", TrmtDetailController)

.controller("TrmtEditController", TrmtEditController)

.controller("TrtdDetailController", TrtdDetailController)

.controller("TrtdEditController", TrtdEditController)

// ------------------- ACCION DE ENTIDAD --------------------
.controller("EnacDetailController", EnacDetailController)

.controller("EnacEditController", EnacEditController)

// ------------------- ACCION DE GRID DE ENTIDAD --------------------
.controller("EnagDetailController", EnagDetailController)

.controller("EnagEditController", EnagEditController)

// ------------------- DEPENDENCIA ENTRE ENTIDADES --------------------
.controller("EnenEditController", EnenEditController);

function config($routeProvider, $stateProvider) {
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

    ;

    $routeProvider

    .when("/metamodelo/tpes/grid", {
        templateUrl : "modules/metamodelo/tpes-grid.html",
        controller : "TpesGridController as vm",
        reloadOnSearch : false
    })

    .when("/metamodelo/tpes/detail/:entiId", {
        templateUrl : "modules/metamodelo/tpes-detail.html",
        controller : "TpesDetailController as vm",
        reloadOnSearch : false
    })

    .when("/metamodelo/tpes/edit/:accion/:entiId?", {
        templateUrl : "modules/metamodelo/tpes-edit.html",
        controller : "TpesEditController as vm"
    })

    .when("/metamodelo/cmag/detail/:tpesId/:entdId", {
        templateUrl : "modules/metamodelo/cmag-detail.html",
        controller : "CmagDetailController as vm"
    })

    .when("/metamodelo/cmag/edit/:accion/:tpesId/:entdId?", {
        templateUrl : "modules/metamodelo/cmag-edit.html",
        controller : "CmagEditController as vm"
    })

    .when("/metamodelo/entd/detail/:entiId/:tpdtId", {
        templateUrl : "modules/metamodelo/entd-detail.html",
        controller : "EntdDetailController as vm"
    })

    .when("/metamodelo/entd/edit/:accion/:entiId/:tpdtId?", {
        templateUrl : "modules/metamodelo/entd-edit.html",
        controller : "EntdEditController as vm"
    })

    .when("/metamodelo/engd/detail/:engdId", {
        templateUrl : "modules/metamodelo/engd-detail.html",
        controller : "EngdDetailController as vm"
    })

    .when("/metamodelo/engd/edit/:accion/:entiId/:engdId?", {
        templateUrl : "modules/metamodelo/engd-edit.html",
        controller : "EngdEditController as vm"
    })

    .when("/metamodelo/trmt/detail/:entiId/:id", {
        templateUrl : "modules/metamodelo/trmt-detail.html",
        controller : "TrmtDetailController as vm"
    })

    .when("/metamodelo/trmt/edit/:accion/:entiId/:id?", {
        templateUrl : "modules/metamodelo/trmt-edit.html",
        controller : "TrmtEditController as vm"
    })

    .when("/metamodelo/trtd/detail/:entiId/:trmtId/:tpdtId", {
        templateUrl : "modules/metamodelo/trtd-detail.html",
        controller : "TrtdDetailController as vm"
    })

    .when("/metamodelo/trtd/edit/:accion/:entiId/:trmtId/:tpdtId?", {
        templateUrl : "modules/metamodelo/trtd-edit.html",
        controller : "TrtdEditController as vm"
    })

    .when("/metamodelo/enac/detail/:id", {
        templateUrl : "modules/metamodelo/enac-detail.html",
        controller : "EnacDetailController as vm"
    })

    .when("/metamodelo/enac/edit/:accion/:entiId/:id?", {
        templateUrl : "modules/metamodelo/enac-edit.html",
        controller : "EnacEditController as vm"
    })

    .when("/metamodelo/enag/detail/:id", {
        templateUrl : "modules/metamodelo/enag-detail.html",
        controller : "EnagDetailController as vm"
    })

    .when("/metamodelo/enag/edit/:accion/:entiId/:id?", {
        templateUrl : "modules/metamodelo/enag-edit.html",
        controller : "EnagEditController as vm"
    })

    .when("/metamodelo/enen/edit/:accion/:entipId", {
        templateUrl : "modules/metamodelo/enen-edit.html",
        controller : "EnenEditController as vm"
    });
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
            }, 0) : $state.go("tipodato-detail", {
                id : data.model.id
            }, {
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
            }, 0) : $state.go("codigoreferencia-detail", {
                id : data.model.id
            }, {
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
            }, 0) : $state.go("tipoparametro-detail", {
                id : data.model.id
            }, {
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
            }, 0) : $state.go("tiposubparametro-detail", {
                id : data.model.id
            }, {
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
            }, 0) : $state.go("tiposervicio-detail", {
                id : data.model.id
            }, {
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
            }, 0) : $state.go("tiposubservicio-detail", {
                id : data.model.id
            }, {
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

function TpesGridController($http, $location, $routeParams, $modal, pageTitleService) {
    var vm = this;

    vm.search = search;
    vm.pageChanged = pageChanged;
    vm.filter = filter;

    initialize();

    function initialize() {
        vm.entiCriterio = $routeParams.entiCriterio ? angular.fromJson($routeParams.entiCriterio) : {};

        search($routeParams.page ? $routeParams.page : 1);
        pageTitleService.setTitle("tpes", "page_grid");
    }

    function search(page) {
        $http.post("metamodelo/tipo-estadistica-list.action", {
            model : vm.entiCriterio,
            page : page,
            limit : vm.limit
        }).success(function(data) {
            vm.entiList = data.resultList;
            vm.page = data.resultList.page;

            $location.search({
                page : vm.page,
                entiCriterio : JSON.stringify(vm.entiCriterio)
            }).replace();
        });
    }

    function pageChanged() {
        search(vm.page);
    }

    function filter(size) {
    }
}

function TpesDetailController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.remove = remove;
    vm.tabSelected = tabSelected;

    initialize();

    function initialize() {
        vm.tabActive = {};

        if ($routeParams.tab) {
            vm.tabActive[$routeParams.tab] = true;
        }

        $http.post("metamodelo/tipo-estadistica-detail.action", {
            model : {
                id : $routeParams.entiId
            }
        }).success(function(data) {
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

    function remove() {
        if (confirm("Are you sure?")) {
            $http.post("metamodelo/tipo-estadistica-remove.action", {
                model : vm.enti
            }).success(function(data) {
                window.history.back();
            });
        }
    }

    function tabSelected(tabNo) {
        $location.search("tab", tabNo).replace();
    }
}

function TpesEditController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    initialize();

    function initialize() {
        vm.accion = $routeParams.accion;

        $http.post("metamodelo/tipo-estadistica-edit.action", {
            model : {
                id : $routeParams.entiId
            },
            accion : vm.accion
        }).success(function(data) {
            vm.enti = data.model;
            vm.i18nMap = data.i18nMap;
        });

        pageTitleService.setTitle("tpes", "page_" + vm.accion);
    }

    function save() {
        $http.post("metamodelo/tipo-estadistica-save.action", {
            model : vm.enti,
            i18nMap : vm.i18nMap,
            accion : vm.accion
        }).success(function(data) {
            vm.accion == 'edit' ? setTimeout(function() {
                window.history.back();
            }, 0) : $location.path("/metamodelo/tpes/detail/" + data.model.id).replace();
        });
    }

    function cancel() {
        window.history.back();
    }
}

function CmagDetailController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.remove = remove;

    initialize();

    function initialize() {
        $http.post("metamodelo/campo-agregacion-detail.action", {
            model : {
                tpesId : $routeParams.tpesId,
                entd : {
                    id : $routeParams.entdId
                }
            }
        }).success(function(data) {
            vm.cmag = data.model;
        });

        pageTitleService.setTitle("cmag", "page_detail");
    }

    function remove() {
        if (confirm("Are you sure?")) {
            $http.post("metamodelo/campo-agregacion-remove.action", {
                model : vm.cmag
            }).success(function(data) {
                window.history.back();
            });
        }
    }
}

function CmagEditController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    initialize();

    function initialize() {
        vm.accion = $routeParams.accion;

        $http.post("metamodelo/campo-agregacion-edit.action", {
            model : {
                tpesId : $routeParams.tpesId,
                entd : {
                    id : $routeParams.entdId
                }
            },
            accion : vm.accion
        }).success(function(data) {
            vm.cmag = data.model;
        });

        pageTitleService.setTitle("cmag", "page_" + vm.accion);
    }

    function save() {
        $http.post("metamodelo/campo-agregacion-save.action", {
            model : vm.cmag,
            accion : vm.accion
        }).success(
                function(data) {
                    vm.accion == 'edit' ? setTimeout(function() {
                        window.history.back();
                    }, 0) : $location.path(
                            "/metamodelo/cmag/detail/" + data.model.tpesId + "/" + data.model.entd.id)
                            .replace();
                });
    }

    function cancel() {
        window.history.back();
    }
}

function EntdDetailController($http, $routeParams, pageTitleService) {
    var vm = this;

    vm.remove = remove;

    initialize();

    function initialize() {
        $http.post("metamodelo/entidad-tipo-dato-detail.action", {
            model : {
                entiId : $routeParams.entiId,
                tpdt : {
                    id : $routeParams.tpdtId
                }
            }
        }).success(function(data) {
            vm.entd = data.model;
            vm.i18nMap = data.i18nMap;
        });

        pageTitleService.setTitle("entd", "page_detail");
    }

    function remove() {
        if (confirm("Are you sure?")) {
            $http.post("metamodelo/entidad-tipo-dato-remove.action", {
                model : vm.entd
            }).success(function(data) {
                window.history.back();
            });
        }
    }
}

function EntdEditController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    initialize();

    function initialize() {
        vm.accion = $routeParams.accion;

        $http.post("metamodelo/entidad-tipo-dato-edit.action", {
            model : {
                entiId : $routeParams.entiId,
                tpdt : {
                    id : $routeParams.tpdtId
                }
            },
            accion : vm.accion
        }).success(function(data) {
            vm.entd = data.model;
            vm.i18nMap = data.i18nMap;
            vm.tpdtList = data.tpdtList;
            vm.engdList = data.engdList;
        });

        pageTitleService.setTitle("entd", "page_" + vm.accion);
    }

    function save() {
        $http.post("metamodelo/entidad-tipo-dato-save.action", {
            model : vm.entd,
            i18nMap : vm.i18nMap,
            accion : vm.accion
        }).success(
                function(data) {
                    vm.accion == 'edit' ? setTimeout(function() {
                        window.history.back();
                    }, 0) : $location.path(
                            "/metamodelo/entd/detail/" + data.model.entiId + "/" + data.model.tpdt.id)
                            .replace();
                });
    }

    function cancel() {
        window.history.back();
    }
}

function EngdDetailController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.remove = remove;

    initialize();

    function initialize() {
        $http.post("metamodelo/entidad-grupo-dato-detail.action", {
            model : {
                id : $routeParams.engdId
            }
        }).success(function(data) {
            vm.engd = data.model;
            vm.i18nMap = data.i18nMap;
        });

        pageTitleService.setTitle("engd", "page_detail");
    }

    function remove() {
        if (confirm("Are you sure?")) {
            $http.post("metamodelo/entidad-grupo-dato-remove.action", {
                model : vm.engd
            }).success(function(data) {
                window.history.back();
            });
        }
    }
}

function EngdEditController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    initialize();

    function initialize() {
        vm.accion = $routeParams.accion;

        $http.post("metamodelo/entidad-grupo-dato-edit.action", {
            model : {
                entiId : $routeParams.entiId,
                id : $routeParams.engdId
            },
            accion : vm.accion
        }).success(function(data) {
            vm.engd = data.model;
            vm.i18nMap = data.i18nMap;
        });

        pageTitleService.setTitle("engd", "page_" + vm.accion);
    }

    function save() {
        $http.post("metamodelo/entidad-grupo-dato-save.action", {
            model : vm.engd,
            i18nMap : vm.i18nMap,
            accion : vm.accion
        }).success(function(data) {
            vm.accion == 'edit' ? setTimeout(function() {
                window.history.back();
            }, 0) : $location.path("/metamodelo/engd/detail/" + data.model.id).replace();
        });
    }

    function cancel() {
        window.history.back();
    }
}

function TrmtDetailController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.remove = remove;

    initialize();

    function initialize() {
        $http.post("metamodelo/tramite-detail.action", {
            model : {
                id : $routeParams.id,
                entiId : $routeParams.entiId
            }
        }).success(function(data) {
            vm.trmt = data.model;
            vm.i18nMap = data.i18nMap;
            vm.trtdList = data.trtdList;
            vm.enti = data.enti;
        });

        pageTitleService.setTitle("trmt", "page_detail");
    }

    function remove() {
        if (confirm("Are you sure?")) {
            $http.post("metamodelo/tramite-remove.action", {
                model : vm.trmt
            }).success(function(data) {
                window.history.back();
            });
        }
    }
}

function TrmtEditController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    initialize();

    function initialize() {
        vm.accion = $routeParams.accion;

        $http.post("metamodelo/tramite-edit.action", {
            model : {
                entiId : $routeParams.entiId,
                id : $routeParams.id
            },
            accion : vm.accion
        }).success(function(data) {
            vm.trmt = data.model;
            vm.i18nMap = data.i18nMap;
            vm.tpdtEstado = data.tpdtEstado;
        });

        pageTitleService.setTitle("trmt", "page_edit");
    }

    function save() {
        $http.post("metamodelo/tramite-save.action", {
            model : vm.trmt,
            i18nMap : vm.i18nMap,
            accion : vm.accion
        }).success(
                function(data) {
                    vm.accion == 'edit' ? setTimeout(function() {
                        window.history.back();
                    }, 0) : $location.path(
                            "/metamodelo/trmt/detail/" + data.model.entiId + "/" + data.model.id).replace();
                });
    }

    function cancel() {
        window.history.back();
    }
}

function TrtdDetailController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.remove = remove;

    initialize();

    function initialize() {
        $http.post("metamodelo/tramite-tipo-dato-detail.action", {
            model : {
                trmtId : $routeParams.trmtId,
                entd : {
                    tpdt : {
                        id : $routeParams.tpdtId
                    }
                }
            }
        }).success(function(data) {
            vm.trtd = data.model;
        });

        pageTitleService.setTitle("trtd", "page_detail");
    }

    function remove() {
        if (confirm("Are you sure?")) {
            $http.post("metamodelo/tramite-tipo-dato-remove.action", {
                model : vm.trtd
            }).success(function(data) {
                window.history.back();
            });
        }
    }
}

function TrtdEditController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    initialize();

    function initialize() {
        vm.accion = $routeParams.accion;

        $http.post("metamodelo/tramite-tipo-dato-edit.action", {
            model : {
                trmtId : $routeParams.trmtId,
                entd : {
                    entiId : $routeParams.entiId,
                    tpdt : {
                        id : $routeParams.tpdtId
                    }
                }
            },
            accion : vm.accion
        }).success(function(data) {
            vm.trtd = data.model;
            vm.entdList = data.entdList;
        });

        pageTitleService.setTitle("trtd", "page_edit");
    }

    function save() {
        $http.post("metamodelo/tramite-tipo-dato-save.action", {
            model : vm.trtd,
            accion : vm.accion
        }).success(
                function(data) {
                    vm.accion == 'edit' ? setTimeout(function() {
                        window.history.back();
                    }, 0) : $location.path(
                            "/metamodelo/trtd/detail/" + data.model.entiId + "/" + data.model.entd.trmtId
                                    + "/" + data.model.entd.tpdt.id).replace();
                });
    }

    function cancel() {
        window.history.back();
    }
}

function EnacDetailController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.remove = remove;

    initialize();

    function initialize() {
        $http.post("metamodelo/entidad-accion-detail.action", {
            model : {
                id : $routeParams.id
            }
        }).success(function(data) {
            vm.enac = data.model;
            vm.i18nMap = data.i18nMap;
        });

        pageTitleService.setTitle("enac", "page_detail");
    }

    function remove() {
        if (confirm("Are you sure?")) {
            $http.post("metamodelo/entidad-accion-remove.action", {
                model : vm.enac
            }).success(function(data) {
                window.history.back();
            });
        }
    }
}

function EnacEditController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    initialize();

    function initialize() {
        vm.accion = $routeParams.accion;

        $http.post("metamodelo/entidad-accion-edit.action", {
            model : {
                entiId : $routeParams.entiId,
                id : $routeParams.id
            },
            accion : vm.accion
        }).success(function(data) {
            vm.enac = data.model;
            vm.i18nMap = data.i18nMap;
        });

        pageTitleService.setTitle("enac", "page_" + vm.accion);
    }

    function save() {
        $http.post("metamodelo/entidad-accion-save.action", {
            model : vm.enac,
            i18nMap : vm.i18nMap,
            accion : vm.accion
        }).success(function(data) {
            vm.accion == 'edit' ? setTimeout(function() {
                window.history.back();
            }, 0) : $location.path("/metamodelo/enac/detail/" + data.model.id).replace();
        });
    }

    function cancel() {
        window.history.back();
    }
}

function EnagDetailController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.remove = remove;

    initialize();

    function initialize() {
        $http.post("metamodelo/entidad-accion-grid-detail.action", {
            model : {
                id : $routeParams.id
            }
        }).success(function(data) {
            vm.enag = data.model;
            vm.i18nMap = data.i18nMap;
        });

        pageTitleService.setTitle("enag", "page_detail");
    }

    function remove() {
        if (confirm("Are you sure?")) {
            $http.post("metamodelo/entidad-accion-grid-remove.action", {
                model : vm.enag
            }).success(function(data) {
                window.history.back();
            });
        }
    }
}

function EnagEditController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    initialize();

    function initialize() {
        vm.accion = $routeParams.accion;

        $http.post("metamodelo/entidad-accion-grid-edit.action", {
            model : {
                entiId : $routeParams.entiId,
                id : $routeParams.id
            },
            accion : vm.accion
        }).success(function(data) {
            vm.enag = data.model;
            vm.i18nMap = data.i18nMap;
        });

        pageTitleService.setTitle("enag", "page_" + vm.accion);
    }

    function save() {
        $http.post("metamodelo/entidad-accion-grid-save.action", {
            model : vm.enag,
            i18nMap : vm.i18nMap,
            accion : vm.accion
        }).success(function(data) {
            vm.accion == 'edit' ? setTimeout(function() {
                window.history.back();
            }, 0) : $location.path("/metamodelo/enag/detail/" + data.model.id).replace();
        });
    }

    function cancel() {
        window.history.back();
    }
}

function EnenEditController($http, $routeParams, pageTitleService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    initialize();

    function initialize() {
        vm.accion = $routeParams.accion;

        $http.post("metamodelo/entidad-entidad-edit.action", {
            model : {
                entiPadreId : $routeParams.entipId
            },
            accion : vm.accion
        }).success(function(data) {
            vm.enen = data.model;
            vm.entiList = data.tpssList;
        });

        pageTitleService.setTitle("enen", "page_" + vm.accion);
    }

    function save() {
        $http.post("metamodelo/entidad-entidad-save.action", {
            model : vm.enen,
            accion : vm.accion
        }).success(function(data) {
            $location.path("/metamodelo/enen/detail/" + data.model.id).replace();
        });
    }

    function cancel() {
        window.history.back();
    }
}