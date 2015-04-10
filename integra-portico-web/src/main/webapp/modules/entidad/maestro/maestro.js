angular.module("maestro", [])

.config(config)

// ----------------- MENU PRINCIPAL --------------------------
.controller("MaestroController", MaestroController)

// ----------- PARAMETROS ------------------
.controller("PrmtGridController", PrmtGridController)

.controller("PrmtDetailController", PrmtDetailController)

.controller("PrmtEditController", PrmtEditController)

.controller('PrmtsLupaController', PrmtsLupaController)

// ----------- SUBPARAMETROS ------------------
.controller("SprmDetailController", SprmDetailController)

.controller("SprmEditController", SprmEditController)

function config($routeProvider) {
    $routeProvider

    .when("/maestro", {
        templateUrl : "modules/entidad/maestro/maestro.html",
        controller : "MaestroController",
        controllerAs : 'vm'
    })

    .when("/maestro/prmt/grid/:entiId/:page?", {
        templateUrl : "modules/entidad/maestro/prmt-grid.html",
        controller : "PrmtGridController",
        controllerAs : 'vm',
        reloadOnSearch : false
    })

    .when("/maestro/prmt/detail/:entiId/:itemId/:fechaVigencia?", {
        templateUrl : "modules/entidad/maestro/prmt-detail.html",
        controller : "PrmtDetailController",
        controllerAs : 'vm',
        reloadOnSearch : false
    })

    .when("/maestro/prmt/edit/:accion/:entiId/:fechaVigencia?/:itemId?", {
        templateUrl : "modules/entidad/maestro/prmt-edit.html",
        controller : "PrmtEditController",
        controllerAs : 'vm'
    })

    .when("/maestro/sprm/detail/:entiId/:itemId/:fechaVigencia?", {
        templateUrl : "modules/entidad/maestro/sprm-detail.html",
        controller : "SprmDetailController",
        controllerAs : 'vm'
    })

    .when("/maestro/sprm/edit/:accion/:entiId/:prmtId/:fechaVigencia?/:itemId?", {
        templateUrl : "modules/entidad/maestro/sprm-edit.html",
        controller : "SprmEditController",
        controllerAs : 'vm'
    })

    ;
}

function MaestroController($http, $translate, pageTitleService) {
    var vm = this;

    $http.post('maestro/tppr-list.action').success(function(data) {
        vm.tpprList = data.tpprList.map(function(tppr) {
            $translate('enti_' + tppr.value).then(function(translation) {
                tppr.label = translation.toUpperCase();
            });

            return tppr;
        });
    });

    pageTitleService.setTitle("prmtList", "page_home");
}

function PrmtGridController($location, $routeParams, $http, $modal, pageTitleService) {
    var vm = this;

    vm.search = search;
    vm.pageChanged = pageChanged;
    vm.filter = filter;
    vm.xlsExport = xlsExport;
    vm.prmtAction = prmtAction;

    vm.itemCriterio = $routeParams.itemCriterio ? angular.fromJson($routeParams.itemCriterio) : {};
    vm.itemCriterio.entiId = $routeParams.entiId;

    function search(page) {
        $http.post("maestro/prmt-list.action", {
            model : vm.itemCriterio,
            page : page,
            limit : vm.itemCriterio.limit
        }).success(function(data) {
            vm.itemCriterio = data.model;
            vm.enti = data.enti;
            vm.page = data.itemList.page;
            vm.itemList = data.itemList;

            $location.search({
                page : vm.page,
                itemCriterio : JSON.stringify(vm.itemCriterio)
            }).replace();
        });
    }

    function pageChanged() {
        search(vm.page);
    }

    function xlsExport() {
        $http.post('maestro/prmt-xls-export.action', {
            itemCriterio : vm.itemCriterio
        }, {
            responseType : 'arraybuffer'
        }).success(function(data) {
            var file = new Blob([ data ], {
                type : 'application/xls'
            });

            setTimeout(function() {
                saveAs(file, vm.enti.id + '.xls');
            }, 0);
        });
    }

    function filter(size) {
        $http.post("maestro/prmt-filter.action", {
            model : vm.itemCriterio
        }).success(function(data) {
            vm.labelValuesMap = data.labelValuesMap;
            vm.limits = data.limits;
            vm.prtoList = data.prtoList;
        });
    }

    function prmtAction(accName) {
        switch (accName) {
        // ----------- EMB. DEP. AUT. ------------------
        // ----------- EMB. DEP. AUT. ------------------
        // ----------- EMB. DEP. AUT. ------------------

        case "amad-recalc-estado":
            $http.post("maestro/embdeportivas/amad-recalc-estado.action").success(function(data) {
                search($routeParams.page ? $routeParams.page : 1);
            });

            break;
        default:
            alert(accName);

            break;
        }
    }

    search($routeParams.page ? $routeParams.page : 1);
    pageTitleService.setTitleEnti($routeParams.entiId, "page_grid");
}

function PrmtDetailController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.pageChanged = pageChanged;
    vm.tabSelected = tabSelected;
    vm.remove = remove;
    vm.print = print;

    function pageChanged(subentiId) {
    }

    function tabSelected(tabNo) {
        if (vm.path == $location.path()) {
            $location.search("tab", tabNo).replace();
        }
    }

    function remove() {
        if (confirm("Are you sure?")) {
            $http.post("maestro/prmt-remove.action", {
                model : vm.item
            }).success(function(data) {
                window.history.back();
            });
        }
    }

    function print() {
        $http.post('maestro/prmt-print.action', {
            item : vm.item
        }, {
            responseType : 'arraybuffer'
        }).success(function(data) {
            var file = new Blob([ data ], {
                type : 'application/pdf'
            });

            setTimeout(function() {
                saveAs(file, vm.enti.id + '.pdf');
            }, 0);
        });
    }

    vm.path = $location.path();
    vm.pageMap = {};

    vm.tabActive = {};

    if ($routeParams.tab) {
        vm.tabActive[$routeParams.tab] = true;
    }

    vm.fechaVigencia = $routeParams.fechaVigencia ? $routeParams.fechaVigencia : new Date();

    $http.post("maestro/prmt-detail.action", {
        model : {
            id : $routeParams.itemId,
            entiId : $routeParams.entiId
        },
        fechaVigencia : vm.fechaVigencia
    }).success(function(data) {
        vm.item = data.model;
        vm.enti = data.enti;
        vm.i18nMap = data.i18nMap;

        if (data.model.prto) {
            vm.prtoId = data.item.prto.id;
        }

        vm.itemHijosMap = {};
        vm.entiHijasMap = {};

        if (data.enti && vm.enti.entiHijasList) {
            for (i = 0; i < vm.enti.entiHijasList.length; i++) {
                $http.post("maestro/sprm-list.action", {
                    model : {
                        prmt : {
                            id : vm.item.id
                        },
                        entiId : vm.enti.entiHijasList[i],
                        fechaVigencia : vm.fechaVigencia
                    }
                }).success(function(data) {
                    vm.entiHijasMap[data.enti.id] = data.enti;
                    vm.itemHijosMap[data.enti.id] = data.itemList;
                });
            }
        }
    });

    pageTitleService.setTitleEnti($routeParams.entiId, "page_detail");
}

function PrmtEditController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.accion = $routeParams.accion;
    vm.save = save;
    vm.cancel = cancel;

    function save() {
        $http.post("maestro/prmt-save.action", {
            model : vm.item,
            i18nMap : vm.i18nMap,
            accion : vm.accion
        }).success(
                function(data) {
                    vm.accion == 'edit' ? setTimeout(function() {
                        window.history.back();
                    }, 0) : $location.path(
                            "/maestro/prmt/detail/" + data.model.entiId + "/" + data.model.id + "/"
                                    + data.model.prvr.fini).replace();
                });
    }

    function cancel() {
        window.history.back();
    }

    vm.fechaVigencia = $routeParams.fechaVigencia ? $routeParams.fechaVigencia : new Date();

    $http.post("maestro/prmt-edit.action", {
        model : {
            id : $routeParams.itemId,
            entiId : $routeParams.entiId
        },
        accion : vm.accion,
        fechaVigencia : vm.fechaVigencia
    }).success(function(data) {
        vm.item = data.model;
        vm.enti = data.enti;
        vm.i18nMap = data.i18nMap;
        vm.labelValuesMap = data.labelValuesMap;
        vm.prtoList = data.prtoList;

        if (data.model.prto) {
            vm.prtoId = data.model.prto.id;
        }
    });

    pageTitleService.setTitleEnti($routeParams.entiId, "page_" + vm.accion);
}

function PrmtsLupaController($http, $scope) {
    $scope.getLabelValues = function(entiId, textoBusqueda, prtoId, fechaVigencia) {
        if (textoBusqueda.length <= 0) {
            return null;
        }

        return $http.post("maestro/prmt-lupa.action", {
            model : {
                entiId : entiId,
                textoBusqueda : textoBusqueda,
                fechaVigencia : fechaVigencia,
                prtoId : prtoId
            }
        }).then(function(res) {
            return res.data.itemList;
        });
    };
}

function SprmDetailController($http, $routeParams, pageTitleService) {
    var vm = this;

    vm.remove = remove;

    function remove() {
        if (confirm("Are you sure?")) {
            $http.post("maestro/sprm-remove.action", {
                model : vm.item
            }).success(function(data) {
                window.history.back();
            });
        }
    }

    $http.post("maestro/sprm-detail.action", {
        model : {
            id : $routeParams.itemId
        },
        fechaVigencia : $routeParams.fechaVigencia
    }).success(function(data) {
        vm.enti = data.enti;
        vm.fechaVigencia = data.fechaVigencia;
        vm.prtoId = data.prtoId;
        vm.item = data.model;
    });

    pageTitleService.setTitleEnti($routeParams.entiId, "page_detail");
}

function SprmEditController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.accion = $routeParams.accion;
    vm.save = save;
    vm.cancel = cancel;

    function save() {
        $http.post("maestro/sprm-save.action", {
            model : vm.item,
            accion : vm.accion
        }).success(
                function(data) {
                    vm.accion == 'edit' ? setTimeout(function() {
                        window.history.back();
                    }, 0) : $location.path(
                            "/maestro/sprm/detail/" + data.model.entiId + "/" + data.model.id + "/"
                                    + data.model.spvr.fini).replace();
                });
    }

    function cancel() {
        window.history.back();
    }

    $http.post("maestro/sprm-edit.action", {
        model : {
            entiId : $routeParams.entiId,
            prmtId : $routeParams.prmtId,
            id : $routeParams.itemId
        },
        accion : vm.accion,
        fechaVigencia : $routeParams.fechaVigencia
    }).success(function(data) {
        vm.enti = data.enti;
        vm.fechaVigencia = data.fechaVigencia;
        vm.prtoId = data.prtoId;
        vm.item = data.model;
        vm.labelValuesMap = data.labelValuesMap;
    });

    pageTitleService.setTitleEnti($routeParams.entiId, "page_" + vm.accion);
}
