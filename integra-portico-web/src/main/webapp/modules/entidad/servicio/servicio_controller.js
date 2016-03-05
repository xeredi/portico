angular.module("servicio_controller", [])

.config(config)

.controller("ValoradorEditController", ValoradorEditController)

.controller("ServicioSecuenciaGridController", ServicioSecuenciaGridController)

.controller("ServicioSecuenciaDetailController",
        ServicioSecuenciaDetailController)

.controller("ServicioSecuenciaEditController", ServicioSecuenciaEditController)

.controller("ServicioIndexController", ServicioIndexController)

.controller("ServicioGridController", ServicioGridController)

.controller("ServicioDetailController", ServicioDetailController)

.controller("ServicioEditController", ServicioEditController)

.controller("ServicioLoadController", ServicioLoadController)

.controller("SubservicioGridController", SubservicioGridController)

.controller("SubservicioDetailController", SubservicioDetailController)

.controller("SubservicioEditController", SubservicioEditController)

;

function config($routeProvider) {
    $routeProvider

            .when("/servicio/valorador/edit/:accion/:entiId/:id", {
                templateUrl : "modules/entidad/servicio/valorador-edit.html",
                controller : "ValoradorEditController as vm",
            })

            .when(
                    "/servicio/servicio-secuencia/grid",
                    {
                        templateUrl : "modules/entidad/servicio/servicio-secuencia-grid.html",
                        controller : "ServicioSecuenciaGridController as vm",
                        reloadOnSearch : false
                    })

            .when(
                    "/servicio/servicio-secuencia/detail/:tpsrId/:prtoId/:anno",
                    {
                        templateUrl : "modules/entidad/servicio/servicio-secuencia-detail.html",
                        controller : "ServicioSecuenciaDetailController as vm",
                    })

            .when(
                    "/servicio/servicio-secuencia/edit/:accion/:tpsrId?/:prtoId?/:anno?",
                    {
                        templateUrl : "modules/entidad/servicio/servicio-secuencia-edit.html",
                        controller : "ServicioSecuenciaEditController as vm",
                    })

            .when("/servicio", {
                templateUrl : "modules/entidad/servicio/servicio-index.html",
                controller : "ServicioIndexController as vm"
            })

            .when("/servicio/servicio/grid/:entiId", {
                templateUrl : "modules/entidad/servicio/servicio-grid.html",
                controller : "ServicioGridController as vm",
                reloadOnSearch : false
            })

            .when("/servicio/servicio/detail/:entiId/:id", {
                templateUrl : "modules/entidad/servicio/servicio-detail.html",
                controller : "ServicioDetailController as vm",
                reloadOnSearch : false,
            })

            .when("/servicio/servicio/edit/:accion/:entiId/:id?", {
                templateUrl : "modules/entidad/servicio/servicio-edit.html",
                controller : "ServicioEditController as vm"
            })

            .when("/servicio/servicio/load/:entiId", {
                templateUrl : "modules/entidad/servicio/servicio-load.html",
                controller : "ServicioLoadController as vm",
            })

            .when("/servicio/subservicio/grid/:entiId", {
                templateUrl : "modules/entidad/servicio/subservicio-grid.html",
                controller : "SubservicioGridController as vm",
                reloadOnSearch : false
            })

            .when(
                    "/servicio/subservicio/detail/:entiId/:id",
                    {
                        templateUrl : "modules/entidad/servicio/subservicio-detail.html",
                        controller : "SubservicioDetailController as vm",
                        reloadOnSearch : false,
                    })

            .when("/servicio/subservicio/edit/:accion/:entiId/:srvcId?/:id?", {
                templateUrl : "modules/entidad/servicio/subservicio-edit.html",
                controller : "SubservicioEditController as vm",
            })

    ;
}

function ValoradorEditController($routeParams, pageTitleService,
        ValoradorService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        ValoradorService.save(vm.accion, vm.model).then(
                function(data) {
                    ValoradorService.redirectAfterSave(vm.accion,
                            '/proceso/proceso/grid');
                });
    }

    function cancel() {
        window.history.back();
    }

    vm.accion = $routeParams.accion;
    vm.model = {
        srvc : {
            entiId : $routeParams.entiId,
            id : $routeParams.id
        }
    }

    ValoradorService.edit(vm.accion, vm.model).then(function(data) {
        vm.model = data.model;
        vm.srvc = data.srvc;
        vm.fliq = data.fliq;
        vm.crgoList = data.crgoList;

        vm.crgoList = data.crgoList;
    });

    pageTitleService.setTitle("vldr", "page_" + vm.accion);
}

function ServicioSecuenciaGridController($routeParams, pageTitleService,
        ServicioSecuenciaService) {
    var vm = this;

    vm.filter = filter;
    vm.resetFilter = resetFilter;
    vm.search = search;
    vm.pageChanged = pageChanged;

    function filter() {
        ServicioSecuenciaService.filter(vm.searchCriteria).then(function(data) {
            vm.tpsrList = data.tpsrList;
            vm.prtoList = data.prtoList;
        });
    }

    function resetFilter() {
        vm.searchCriteria = {};
    }

    function search(page) {
        ServicioSecuenciaService.listPage(vm.searchCriteria, page, vm.limit)
                .then(function(data) {
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

    pageTitleService.setTitle("srsc", "page_grid");
}

function ServicioSecuenciaDetailController($routeParams, pageTitleService,
        ServicioSecuenciaService) {
    var vm = this;

    vm.remove = remove;

    function remove() {
        ServicioSecuenciaService.remove(vm.model).then(function(data) {
            window.history.back();
        });
    }

    vm.search = {
        prto : {
            id : $routeParams.prtoId
        },
        tpsr : {
            id : $routeParams.tpsrId
        },
        anno : $routeParams.anno
    }

    ServicioSecuenciaService.detail(vm.search).then(function(data) {
        vm.model = data.model;
    });

    pageTitleService.setTitle("srsc", "page_detail");
}

function ServicioSecuenciaEditController($routeParams, pageTitleService,
        ServicioSecuenciaService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        ServicioSecuenciaService.save(vm.accion, vm.model).then(function(data) {
            ServicioSecuenciaService.redirectAfterSave(vm.accion, {
                tpsrId : data.model.tpsr.id,
                prtoId : data.model.prto.id,
                anno : data.model.anno
            }, "servicio-secuencia-detail");
        });
    }

    function cancel() {
        window.history.back();
    }

    vm.accion = $routeParams.accion;
    vm.search = {
        prto : {
            id : $routeParams.prtoId
        },
        tpsr : {
            id : $routeParams.tpsrId
        },
        anno : $routeParams.anno
    }

    ServicioSecuenciaService.edit(vm.accion, vm.search).then(function(data) {
        vm.model = data.model;

        vm.prtoList = data.prtoList;
        vm.tpsrList = data.tpsrList;
    });

    pageTitleService.setTitle("srsc", "page_" + vm.accion);
}

// SERVICIO
function ServicioIndexController($translate, pageTitleService, ServicioService) {
    var vm = this;

    ServicioService.index().then(function(data) {
        vm.tpsrList = data.resultList;
        vm.tpssMap = data.tpssMap;
    });

    pageTitleService.setTitle("srvcList", "page_home");
}

function ServicioGridController($routeParams, pageTitleService, ServicioService) {
    var vm = this;

    vm.filter = filter;
    vm.resetFilter = resetFilter;
    vm.search = search;
    vm.pageChanged = pageChanged;
    vm.xlsExport = xlsExport;

    function filter() {
        ServicioService.filter(vm.searchCriteria).then(function(data) {
            vm.labelValuesMap = data.labelValuesMap;
            vm.prtoList = data.prtoList;
            vm.limits = data.limits;
            vm.fechaVigencia = data.fechaVigencia;
        });
    }

    function resetFilter() {
        vm.searchCriteria = {};
    }

    function search(page) {
        vm.searchCriteria.entiId = $routeParams.entiId;

        ServicioService.listPage(vm.searchCriteria, page, vm.limit).then(
                function(data) {
                    vm.page = data.resultList.page;
                    vm.limit = data.resultList.limit;
                    vm.itemList = data.resultList;

                    vm.enti = data.enti;
                    vm.searchCriteria = data.model;
                });
    }

    function pageChanged() {
        search(vm.page);
    }

    function xlsExport() {
        ServicioService.xlsExport(vm.searchCriteria, 'srvc_'
                + vm.searchCriteria.entiId);
    }

    vm.searchCriteria = $routeParams.searchCriteria ? angular
            .fromJson($routeParams.searchCriteria) : {};

    vm.limit = $routeParams.limit;

    search($routeParams.page ? $routeParams.page : 1);

    pageTitleService.setTitleEnti($routeParams.entiId, "page_grid");
}

function ServicioDetailController($routeParams, pageTitleService,
        credentialService, ServicioService, SubservicioService) {
    var vm = this;

    vm.remove = remove;
    vm.pdfExport = pdfExport;
    vm.tabSelected = tabSelected;
    vm.pageChanged = pageChanged;

    function remove() {
        ServicioService.remove(vm.item).then(function(data) {
            window.history.back();
        });
    }

    function pdfExport() {
        ServicioService.pdfExport(vm.item, 'srvc_' + vm.item.entiId + '_'
                + vm.item.id);
    }

    function tabSelected(tabNo) {
        ServicioService.tabSelected(tabNo);
    }

    function pageChanged(subentiId) {
        findSublist(subentiId, vm.pageMap[subentiId]);
    }

    function findSublist(subentiId, page) {
        if (credentialService.hasAcenPath(subentiId, "item-list")) {
            var ssrvSearchCriteria = {
                srvc : {
                    id : vm.item.id
                },
                entiId : subentiId
            };

            SubservicioService.listPage(ssrvSearchCriteria, page, vm.limit)
                    .then(function(data) {
                        vm.entiHijasMap[data.enti.enti.id] = data.enti;
                        vm.itemHijosMap[data.enti.enti.id] = data.resultList;
                        vm.pageMap[data.enti.enti.id] = data.resultList.page;

                        ServicioService.pageMapChanged(vm.pageMap);
                    });
        }
    }

    vm.tabActive = {};

    if ($routeParams.tab) {
        vm.tabActive[$routeParams.tab] = true;
    }

    vm.pageMap = $routeParams.pageMap ? angular.fromJson($routeParams.pageMap)
            : {};

    vm.search = {
        id : $routeParams.id,
        entiId : $routeParams.entiId
    };

    ServicioService.detail(vm.search).then(
            function(data) {
                vm.item = data.model;
                vm.enti = data.enti;
                vm.ittrList = data.ittrList;

                vm.itemHijosMap = {};
                vm.entiHijasMap = {};

                if (data.enti && vm.enti.entiHijasList) {
                    for (i = 0; i < vm.enti.entiHijasList.length; i++) {
                        findSublist(vm.enti.entiHijasList[i],
                                vm.pageMap[vm.enti.entiHijasList[i]]);
                    }
                }
            });

    pageTitleService.setTitleEnti($routeParams.entiId, "page_detail");
}

function ServicioEditController($routeParams, pageTitleService, ServicioService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        ServicioService.save(vm.accion, vm.item).then(
                function(data) {
                    ServicioService.redirectAfterSave(vm.accion,
                            '/servicio/servicio/detail', [ data.model.entiId,
                                    data.model.id ]);
                });
    }

    function cancel() {
        window.history.back();
    }

    vm.accion = $routeParams.accion;
    vm.search = {
        id : $routeParams.id,
        entiId : $routeParams.entiId
    };

    ServicioService.edit(vm.accion, vm.search).then(function(data) {
        vm.item = data.model;
        vm.enti = data.enti;

        vm.fechaVigencia = data.fechaVigencia;

        if (data.model.prto) {
            vm.prtoId = data.model.prto.id;
        }

        vm.labelValuesMap = data.labelValuesMap;
        vm.prtoList = data.prtoList;
    });

    pageTitleService.setTitleEnti($routeParams.entiId, "page_" + vm.accion);
}

function ServicioLoadController($routeParams, pageTitleService, ServicioService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        ServicioService.fileUpload(vm.fileLoad).then(
                function(data) {
                    vm.model.archId = data.archId;

                    ServicioService.load(vm.model).then(
                            function(data) {
                                ServicioService.redirectAfterSave(vm.accion,
                                        '/proceso/proceso/grid');
                            });
                });
    }

    function cancel() {
        window.history.back();
    }

    vm.model = {
        entiId : $routeParams.entiId
    };

    ServicioService.loadPrepare(vm.model).then(function(data) {
        vm.model = data.model;
    });

    pageTitleService.setTitleEnti($routeParams.entiId, "page_loadfile");
}

function SubservicioGridController($routeParams, pageTitleService,
        SubservicioService) {
    var vm = this;

    vm.filter = filter;
    vm.resetFilter = resetFilter;
    vm.search = search;
    vm.pageChanged = pageChanged;
    vm.xlsExport = xlsExport;

    function filter() {
        SubservicioService.filter(vm.searchCriteria).then(function(data) {
            vm.labelValuesMap = data.labelValuesMap;
            vm.prtoList = data.prtoList;
            vm.limits = data.limits;
            vm.fechaVigencia = data.fechaVigencia;
        });
    }

    function resetFilter() {
        vm.searchCriteria = {};
    }

    function search(page) {
        vm.searchCriteria.entiId = $routeParams.entiId;

        SubservicioService.listPage(vm.searchCriteria, page, vm.limit).then(
                function(data) {
                    vm.page = data.resultList.page;
                    vm.limit = data.resultList.limit;
                    vm.itemList = data.resultList;

                    vm.enti = data.enti;
                    vm.searchCriteria = data.model;
                });
    }

    function pageChanged() {
        search(vm.page);
    }

    function xlsExport() {
        SubservicioService.xlsExport(vm.searchCriteria, 'ssrv_'
                + vm.searchCriteria.entiId);
    }

    vm.searchCriteria = $routeParams.searchCriteria ? angular
            .fromJson($routeParams.searchCriteria) : {};
    vm.limit = $routeParams.limit;

    search($routeParams.page ? $routeParams.page : 1);

    pageTitleService.setTitleEnti($routeParams.entiId, "page_grid");
}

function SubservicioDetailController($routeParams, pageTitleService,
        credentialService, SubservicioService) {
    var vm = this;

    vm.remove = remove;
    vm.tabSelected = tabSelected;
    vm.pageChanged = pageChanged;

    function remove() {
        SubservicioService.remove(vm.item).then(function(data) {
            window.history.back();
        });
    }

    function tabSelected(tabNo) {
        SubservicioService.tabSelected(tabNo);
    }

    function pageChanged(subentiId) {
        findSublist(subentiId, vm.pageMap[subentiId]);
    }

    function findSublist(subentiId, page) {
        if (credentialService.hasAcenPath(subentiId, "item-list")) {
            var ssrvSearchCriteria = {
                entiId : subentiId,
                padreId : vm.item.id
            };

            SubservicioService.listPage(ssrvSearchCriteria, page, vm.limit)
                    .then(function(data) {
                        vm.entiHijasMap[data.enti.enti.id] = data.enti;
                        vm.itemHijosMap[data.enti.enti.id] = data.resultList;
                        vm.pageMap[data.enti.enti.id] = data.resultList.page;

                        SubservicioService.pageMapChanged(vm.pageMap);
                    });
        }
    }

    vm.tabActive = {};

    if ($routeParams.tab) {
        vm.tabActive[$routeParams.tab] = true;
    }

    vm.pageMap = $routeParams.pageMap ? angular.fromJson($routeParams.pageMap)
            : {};

    vm.search = {
        id : $routeParams.id,
        entiId : $routeParams.entiId
    };

    SubservicioService.detail(vm.search).then(
            function(data) {
                vm.enti = data.enti;
                vm.item = data.model;
                vm.itemPadresMap = data.itemPadresMap;
                vm.ittrList = data.ittrList;

                vm.itemHijosMap = {};
                vm.entiHijasMap = {};

                if (data.enti && vm.enti.entiHijasList) {
                    for (i = 0; i < vm.enti.entiHijasList.length; i++) {
                        findSublist(vm.enti.entiHijasList[i],
                                vm.pageMap[vm.enti.entiHijasList[i]]);
                    }
                }
            });

    pageTitleService.setTitleEnti($routeParams.entiId, "page_detail");
}

function SubservicioEditController($routeParams, pageTitleService,
        SubservicioService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        SubservicioService.save(vm.accion, vm.item).then(
                function(data) {
                    SubservicioService.redirectAfterSave(vm.accion,
                            '/servicio/subservicio/detail', [
                                    data.model.entiId, data.model.id ]);
                });
    }

    function cancel() {
        window.history.back();
    }

    vm.accion = $routeParams.accion;
    vm.search = {
        id : $routeParams.id,
        entiId : $routeParams.entiId,
        srvc : {
            id : $routeParams.srvcId
        }
    };

    SubservicioService.edit(vm.accion, vm.search).then(function(data) {
        vm.fechaVigencia = data.fechaVigencia;
        vm.item = data.model;
        vm.itemPadresMap = data.itemPadresMap;
        vm.labelValuesMap = data.labelValuesMap;

        vm.enti = data.enti;
        vm.superentiList = data.superentiList;
    });

    pageTitleService.setTitleEnti($routeParams.entiId, "page_" + vm.accion);
}
