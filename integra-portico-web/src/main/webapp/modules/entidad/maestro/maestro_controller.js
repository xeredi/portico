angular.module("maestro_controller", [])

.config(config)

.controller("MaestroIndexController", MaestroIndexController)

.controller("ParametroGridController", ParametroGridController)

.controller("ParametroDetailController", ParametroDetailController)

.controller("ParametroEditController", ParametroEditController)

.controller("ParametroTypeaheadController", ParametroTypeaheadController)

.controller("SubparametroDetailController", SubparametroDetailController)

.controller("SubparametroEditController", SubparametroEditController)

;

function config($routeProvider) {
    $routeProvider

    .when("/maestro", {
        templateUrl : "modules/entidad/maestro/maestro-index.html",
        controller : "MaestroIndexController as vm"
    })

    .when("/maestro/parametro/grid/:entiId", {
        templateUrl : "modules/entidad/maestro/parametro-grid.html",
        controller : "ParametroGridController as vm",
        reloadOnSearch : false
    })

    .when("/maestro/parametro/detail/:entiId/:id/:fref?", {
        templateUrl : "modules/entidad/maestro/parametro-detail.html",
        controller : "ParametroDetailController as vm",
        reloadOnSearch : false
    })

    .when("/maestro/parametro/edit/:accion/:entiId/:id?/:fref?", {
        templateUrl : "modules/entidad/maestro/parametro-edit.html",
        controller : "ParametroEditController as vm",
    })

    .when("/maestro/subparametro/detail/:entiId/:id/:fref?", {
        templateUrl : "modules/entidad/maestro/subparametro-detail.html",
        controller : "SubparametroDetailController as vm",
        reloadOnSearch : false,
    })

    .when("/maestro/subparametro/edit/:accion/:entiId/:prmtId/:id?/:fref?", {
        templateUrl : "modules/entidad/maestro/subparametro-edit.html",
        controller : "SubparametroEditController as vm",
    })

    ;
}

function MaestroIndexController($translate, pageTitleService, MaestroService) {
    var vm = this;

    MaestroService.index().then(function(data) {
        vm.tpprList = data.resultList.map(function(tppr) {
            $translate('enti_' + tppr.value).then(function(translation) {
                tppr.label = translation.toUpperCase();
            });

            return tppr;
        });
    });

    pageTitleService.setTitle("prmtList", "page_home");
}

function ParametroGridController($routeParams, pageTitleService,
        ParametroService) {
    var vm = this;

    vm.filter = filter;
    vm.resetFilter = resetFilter;
    vm.search = search;
    vm.pageChanged = pageChanged;
    vm.xlsExport = xlsExport;

    function filter() {
        ParametroService.filter(vm.searchCriteria).then(function(data) {
            vm.labelValuesMap = data.labelValuesMap;
            vm.limits = data.limits;
            vm.prtoList = data.prtoList;
        });
    }

    function resetFilter() {
        vm.searchCriteria = {};
    }

    function search(page) {
        vm.searchCriteria.entiId = $routeParams.entiId;

        ParametroService.listPage(vm.searchCriteria, page, vm.limit).then(
                function(data) {
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
        ParametroService.xlsExport(vm.searchCriteria, 'prmt_'
                + vm.searchCriteria.entiId);
    }

    vm.searchCriteria = $routeParams.searchCriteria ? angular
            .fromJson($routeParams.searchCriteria) : {};

    vm.limit = $routeParams.limit;

    search($routeParams.page ? $routeParams.page : 1);

    pageTitleService.setTitleEnti($routeParams.entiId, "page_grid");
}

function ParametroDetailController($routeParams, pageTitleService,
        ParametroService, SubparametroService) {
    var vm = this;

    vm.remove = remove;
    vm.pdfExport = pdfExport;
    vm.tabSelected = tabSelected;

    function remove() {
        ParametroService.remove(vm.item).then(function(data) {
            window.history.back();
        });
    }

    function pdfExport() {
        ParametroService.pdfExport(vm.item, 'prmt_' + vm.item.entiId + '_'
                + vm.item.id);
    }

    function tabSelected(tabNo) {
        ParametroService.tabSelected(tabNo);
    }

    vm.tabActive = {};

    if ($routeParams.tab) {
        vm.tabActive[$routeParams.tab] = true;
    }

    vm.search = {
        id : $routeParams.id,
        entiId : $routeParams.entiId,
        fref : $routeParams.fref ? $routeParams.fref : new Date()
    };

    ParametroService
            .detail(vm.search)
            .then(
                    function(data) {
                        vm.item = data.model;
                        vm.i18nMap = data.i18nMap;

                        if (data.model.prto) {
                            vm.prtoId = data.model.prto.id;
                        }

                        vm.enti = data.enti;

                        vm.itemHijosMap = {};
                        vm.entiHijasMap = {};

                        if (data.enti && vm.enti.entiHijasList) {
                            for (i = 0; i < vm.enti.entiHijasList.length; i++) {
                                var sprmSearchCriteria = {
                                    prmt : {
                                        id : vm.item.id
                                    },
                                    entiId : vm.enti.entiHijasList[i],
                                    fechaVigencia : vm.item.fref
                                };

                                SubparametroService
                                        .listPage(sprmSearchCriteria)
                                        .then(
                                                function(data) {
                                                    vm.entiHijasMap[data.enti.enti.id] = data.enti;
                                                    vm.itemHijosMap[data.enti.enti.id] = data.resultList;
                                                });
                            }
                        }
                    });

    pageTitleService.setTitleEnti($routeParams.entiId, "page_detail");
}

function ParametroEditController($routeParams, pageTitleService,
        ParametroService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        ParametroService.saveI18n(vm.accion, vm.item, vm.i18nMap).then(
                function(data) {
                    ParametroService.redirectAfterSave(vm.accion,
                            '/maestro/parametro/detail', [ data.model.entiId,
                                    data.model.id, data.model.version.fini ]);
                });
    }

    function cancel() {
        window.history.back();
    }

    vm.accion = $routeParams.accion;
    vm.search = {
        id : $routeParams.id,
        entiId : $routeParams.entiId,
        fref : $routeParams.fref ? $routeParams.fref : new Date()
    };

    ParametroService.edit(vm.accion, vm.search).then(function(data) {
        vm.item = data.model;
        vm.i18nMap = data.i18nMap;
        vm.enti = data.enti;

        if (data.model.prto) {
            vm.prtoId = data.model.prto.id;
        }

        vm.labelValuesMap = data.labelValuesMap;
        vm.prtoList = data.prtoList;
    });

    pageTitleService.setTitleEnti($routeParams.entiId, "page_" + vm.accion);
}

function ParametroTypeaheadController(ParametroService) {
    var vm = this;

    vm.getLabelValues = getLabelValues;

    function getLabelValues(entiId, textoBusqueda, prtoId, fechaVigencia) {
        if (textoBusqueda.length <= 0) {
            return null;
        }

        vm.search = {
            entiId : entiId,
            textoBusqueda : textoBusqueda,
            fechaVigencia : fechaVigencia,
            prto : {
                id : prtoId
            }
        };

        return ParametroService.typeahead(vm.search).then(function(data) {
            return data.resultList;
        });
    }
}

function SubparametroDetailController($routeParams, pageTitleService,
        SubparametroService) {
    var vm = this;

    vm.remove = remove;

    function remove() {
        SubparametroService.remove(vm.item).then(function(data) {
            window.history.back();
        });
    }

    vm.search = {
        id : $routeParams.id,
        entiId : $routeParams.entiId,
        fref : $routeParams.fref ? $routeParams.fref : new Date()
    };

    SubparametroService.detail(vm.search).then(function(data) {
        vm.item = data.model;
        vm.enti = data.enti;

        vm.prtoId = data.prtoId;
    });

    pageTitleService.setTitleEnti($routeParams.entiId, "page_detail");
}

function SubparametroEditController($routeParams, pageTitleService,
        SubparametroService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        SubparametroService.save(vm.accion, vm.item).then(
                function(data) {
                    SubparametroService.redirectAfterSave(vm.accion,
                            '/maestro/subparametro/detail', [
                                    data.model.entiId, data.model.id,
                                    data.model.version.fini ]);
                });
    }

    function cancel() {
        window.history.back();
    }

    vm.accion = $routeParams.accion;
    vm.search = {
        id : $routeParams.id,
        prmtId : $routeParams.prmtId,
        entiId : $routeParams.entiId,
        fref : $routeParams.fref
    };

    SubparametroService.edit(vm.accion, vm.search).then(function(data) {
        vm.item = data.model;
        vm.enti = data.enti;

        vm.prtoId = data.model.prtoId;

        vm.labelValuesMap = data.labelValuesMap;
        vm.prtoList = data.prtoList;
    });

    pageTitleService.setTitleEnti($routeParams.entiId, "page_" + vm.accion);
}
