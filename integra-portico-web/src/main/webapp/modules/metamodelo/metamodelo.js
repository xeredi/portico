angular.module("metamodelo", [])

.config(config)

// -------------------- TIPO DE DATO ------------------
.controller("tpdtGridController", tpdtGridController)

.controller("tpdtFilterController", tpdtFilterController)

.controller("tpdtCreateController", tpdtCreateController)

.controller("tpdtDetailController", tpdtDetailController)

.controller("tpdtEditController", tpdtEditController)

.controller("cdrfCreateController", cdrfCreateController)

.controller("cdrfDetailController", cdrfDetailController)

.controller("cdrfEditController", cdrfEditController)

// -------------------- MAESTRO ------------------
.controller("tpprGridController", tpprGridController)

.controller("tpprFilterController", tpprFilterController)

.controller("tpprDetailController", tpprDetailController)

.controller("tpprEditController", tpprEditController)

.controller("tpprCreateController", tpprCreateController)

.controller("tpspDetailController", tpspDetailController)

.controller("tpspEditController", tpspEditController)

.controller("tpspCreateController", tpspCreateController)

// -------------------- TIPO DE SERVICIO ------------------
.controller("tpsrGridController", tpsrGridController)

.controller("tpsrFilterController", tpsrFilterController)

.controller("tpsrDetailController", tpsrDetailController)

.controller("tpsrEditController", tpsrEditController)

.controller("tpsrCreateController", tpsrCreateController)

.controller("tpssDetailController", tpssDetailController)

.controller("tpssEditController", tpssEditController)

.controller("tpssCreateController", tpssCreateController)

// -------------------- ESTADISTICA ------------------
.controller("tpesGridController", tpesGridController)

.controller("tpesFilterController", tpesFilterController)

.controller("tpesDetailController", tpesDetailController)

.controller("tpesEditController", tpesEditController)

.controller("tpesCreateController", tpesCreateController)

// ------------------- GRUPO DE DATO DE ENTIDAD --------------------
.controller("engdDetailController", engdDetailController)

.controller("engdEditController", engdEditController)

.controller("engdCreateController", engdCreateController)

// ------------------- DATO DE ENTIDAD --------------------
.controller("entdDetailController", entdDetailController)

.controller("entdEditController", entdEditController)

.controller("entdCreateController", entdCreateController)

// ------------------- ACCION DE ENTIDAD --------------------
.controller("enacDetailController", enacDetailController)

.controller("enacEditController", enacEditController)

.controller("enacCreateController", enacCreateController)

// ------------------- DEPENDENCIA ENTRE ENTIDADES --------------------
.controller("enenCreateController", enenCreateController);

function config($routeProvider) {
    $routeProvider

    .when("/metamodelo/tpdt/grid", {
        templateUrl : "modules/metamodelo/tpdt-grid.html",
        controller : "tpdtGridController",
        controllerAs : 'vm',
        reloadOnSearch : false
    })

    .when("/metamodelo/tpdt/create", {
        templateUrl : "modules/metamodelo/tpdt-edit.html",
        controller : "tpdtCreateController",
        controllerAs : 'vm'
    })

    .when("/metamodelo/tpdt/detail/:tpdtId", {
        templateUrl : "modules/metamodelo/tpdt-detail.html",
        controller : "tpdtDetailController",
        controllerAs : 'vm'
    })

    .when("/metamodelo/tpdt/edit/:tpdtId", {
        templateUrl : "modules/metamodelo/tpdt-edit.html",
        controller : "tpdtEditController",
        controllerAs : 'vm'
    })

    .when("/metamodelo/cdrf/detail/:cdrfId", {
        templateUrl : "modules/metamodelo/cdrf-detail.html",
        controller : "cdrfDetailController",
        controllerAs : 'vm'
    })

    .when("/metamodelo/cdrf/edit/:cdrfId", {
        templateUrl : "modules/metamodelo/cdrf-edit.html",
        controller : "cdrfEditController",
        controllerAs : 'vm'
    })

    .when("/metamodelo/cdrf/create/:tpdtId", {
        templateUrl : "modules/metamodelo/cdrf-edit.html",
        controller : "cdrfCreateController",
        controllerAs : 'vm'
    })

    .when("/metamodelo/tppr/grid", {
        templateUrl : "modules/metamodelo/tppr-grid.html",
        controller : "tpprGridController",
        controllerAs : 'vm',
        reloadOnSearch : false
    })

    .when("/metamodelo/tppr/detail/:entiId", {
        templateUrl : "modules/metamodelo/tppr-detail.html",
        controller : "tpprDetailController",
        controllerAs : 'vm'
    })

    .when("/metamodelo/tppr/edit/:entiId", {
        templateUrl : "modules/metamodelo/tppr-edit.html",
        controller : "tpprEditController",
        controllerAs : 'vm'
    })

    .when("/metamodelo/tppr/create", {
        templateUrl : "modules/metamodelo/tppr-edit.html",
        controller : "tpprCreateController",
        controllerAs : 'vm'
    })

    .when("/metamodelo/tpsp/detail/:entiId", {
        templateUrl : "modules/metamodelo/tpsp-detail.html",
        controller : "tpspDetailController",
        controllerAs : 'vm'
    })

    .when("/metamodelo/tpsp/edit/:entiId", {
        templateUrl : "modules/metamodelo/tpsp-edit.html",
        controller : "tpspEditController",
        controllerAs : 'vm'
    })

    .when("/metamodelo/tpsp/create/:tpprId", {
        templateUrl : "modules/metamodelo/tpsp-edit.html",
        controller : "tpspCreateController",
        controllerAs : 'vm'
    })

    .when("/metamodelo/tpsr/grid", {
        templateUrl : "modules/metamodelo/tpsr-grid.html",
        controller : "tpsrGridController",
        controllerAs : 'vm',
        reloadOnSearch : false
    })

    .when("/metamodelo/tpsr/detail/:entiId", {
        templateUrl : "modules/metamodelo/tpsr-detail.html",
        controller : "tpsrDetailController",
        controllerAs : 'vm'
    })

    .when("/metamodelo/tpsr/edit/:entiId", {
        templateUrl : "modules/metamodelo/tpsr-edit.html",
        controller : "tpsrEditController",
        controllerAs : 'vm'
    })

    .when("/metamodelo/tpsr/create", {
        templateUrl : "modules/metamodelo/tpsr-edit.html",
        controller : "tpsrCreateController",
        controllerAs : 'vm'
    })

    .when("/metamodelo/tpss/detail/:entiId", {
        templateUrl : "modules/metamodelo/tpss-detail.html",
        controller : "tpssDetailController",
        controllerAs : 'vm'
    })

    .when("/metamodelo/tpss/edit/:entiId", {
        templateUrl : "modules/metamodelo/tpss-edit.html",
        controller : "tpssEditController",
        controllerAs : 'vm'
    })

    .when("/metamodelo/tpss/create/:tpsrId", {
        templateUrl : "modules/metamodelo/tpss-edit.html",
        controller : "tpssCreateController",
        controllerAs : 'vm'
    })

    .when("/metamodelo/tpes/grid", {
        templateUrl : "modules/metamodelo/tpes-grid.html",
        controller : "tpesGridController",
        controllerAs : 'vm',
        reloadOnSearch : false
    })

    .when("/metamodelo/tpes/detail/:entiId", {
        templateUrl : "modules/metamodelo/tpes-detail.html",
        controller : "tpesDetailController",
        controllerAs : 'vm'
    })

    .when("/metamodelo/tpes/edit/:entiId", {
        templateUrl : "modules/metamodelo/tpes-edit.html",
        controller : "tpesEditController",
        controllerAs : 'vm'
    })

    .when("/metamodelo/tpes/create", {
        templateUrl : "modules/metamodelo/tpes-edit.html",
        controller : "tpesCreateController",
        controllerAs : 'vm'
    })

    .when("/metamodelo/entd/detail/:entiId/:tpdtId", {
        templateUrl : "modules/metamodelo/entd-detail.html",
        controller : "entdDetailController",
        controllerAs : 'vm'
    })

    .when("/metamodelo/entd/edit/:entiId/:tpdtId", {
        templateUrl : "modules/metamodelo/entd-edit.html",
        controller : "entdEditController",
        controllerAs : 'vm'
    })

    .when("/metamodelo/entd/create/:entiId", {
        templateUrl : "modules/metamodelo/entd-edit.html",
        controller : "entdCreateController",
        controllerAs : 'vm'
    })

    .when("/metamodelo/engd/detail/:engdId", {
        templateUrl : "modules/metamodelo/engd-detail.html",
        controller : "engdDetailController",
        controllerAs : 'vm'
    })

    .when("/metamodelo/engd/edit/:engdId", {
        templateUrl : "modules/metamodelo/engd-edit.html",
        controller : "engdEditController",
        controllerAs : 'vm'
    })

    .when("/metamodelo/engd/create/:entiId", {
        templateUrl : "modules/metamodelo/engd-edit.html",
        controller : "engdCreateController",
        controllerAs : 'vm'
    })

    .when("/metamodelo/enac/detail/:entiId/:path", {
        templateUrl : "modules/metamodelo/enac-detail.html",
        controller : "enacDetailController",
        controllerAs : 'vm'
    })

    .when("/metamodelo/enac/edit/:entiId/:path", {
        templateUrl : "modules/metamodelo/enac-edit.html",
        controller : "enacEditController",
        controllerAs : 'vm'
    })

    .when("/metamodelo/enac/create/:entiId", {
        templateUrl : "modules/metamodelo/enac-edit.html",
        controller : "enacCreateController",
        controllerAs : 'vm'
    })

    .when("/metamodelo/enen/create/:entipId", {
        templateUrl : "modules/metamodelo/enen-edit.html",
        controller : "enenCreateController",
        controllerAs : 'vm'
    });
}

function tpdtGridController($http, $location, $routeParams, $modal, pageTitleService) {
    var vm = this;

    vm.pageChanged = pageChanged;
    vm.filter = filter;

    vm.tpdtCriterio = {};

    function search(tpdtCriterio, page, limit) {
        $http.post("metamodelo/tpdt-list.action", {
            tpdtCriterio : tpdtCriterio,
            page : page,
            limit : limit
        }).success(function(data) {
            vm.page = data.tpdtList.page;
            vm.tpdtList = data.tpdtList;

            var map = {};

            map.page = data.tpdtList.page;

            $location.search(map).replace();
        });
    }

    function pageChanged() {
        search(vm.tpdtCriterio, vm.page, vm.limit);
    }

    function filter(size) {
        var modalInstance = $modal.open({
            templateUrl : 'modules/metamodelo/tpdt-filter-modal.html',
            controller : 'tpdtFilterController',
            controllerAs : 'vm',
            size : size,
            resolve : {
                tpdtCriterio : function() {
                    return vm.tpdtCriterio;
                }
            }
        });

        modalInstance.result.then(function(tpdtCriterio) {
            vm.tpdtCriterio = tpdtCriterio;
            vm.page = 1;

            search(vm.tpdtCriterio, 1, vm.limit);
        });
    }

    search(vm.tpdtCriterio, $routeParams.page ? $routeParams.page : 1, vm.limit);

    pageTitleService.setTitle("tpdt", "page_grid");
}

function tpdtFilterController($modalInstance, tpdtCriterio) {
    var vm = this;

    vm.ok = ok;
    vm.cancel = cancel;

    vm.tpdtCriterio = tpdtCriterio;

    function ok() {
        $modalInstance.close(vm.tpdtCriterio);
    }

    function cancel() {
        $modalInstance.dismiss('cancel');
    }
}

function tpdtCreateController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        var url = "metamodelo/tpdt-save.action";

        $http.post(url, {
            tpdt : vm.tpdt,
            i18nMap : vm.i18nMap,
            accion : vm.accion
        }).success(function(data) {
            $location.path("/metamodelo/tpdt/detail/" + data.tpdt.id).replace();
        });
    }

    function cancel() {
        window.history.back();
    }

    $http.get("metamodelo/tpdt-create.action").success(function(data) {
        vm.tpdt = data.tpdt;
        vm.accion = data.accion;
        vm.tphts = data.tphts;
        vm.tiposElemento = data.tiposElemento;
    });

    $http.get("metamodelo/enti-lv-list.action?entiCriterio.tipo=P").success(function(data) {
        vm.entiTpprList = data.lvList;
    });

    $http.get("metamodelo/enti-lv-list.action?entiCriterio.tipo=T").success(function(data) {
        vm.entiTpsrList = data.lvList;
    });

    pageTitleService.setTitle("tpdt", "page_create");
}

function tpdtDetailController($http, $routeParams, pageTitleService, usSpinnerService) {
    var vm = this;

    vm.remove = remove;

    function remove() {
        if (confirm("Are you sure?")) {
            usSpinnerService.spin("spinner");

            $http.get("metamodelo/tpdt-remove.action?tpdt.id=" + vm.tpdt.id).success(function(data) {
                usSpinnerService.stop("spinner");
                window.history.back();
            });
        }
    }

    $http.get("metamodelo/tpdt-detail.action?tpdt.id=" + $routeParams.tpdtId).success(function(data) {
        vm.tpdt = data.tpdt;
        vm.i18nMap = data.i18nMap;
        vm.cdrfList = data.cdrfList;
    });

    pageTitleService.setTitle("tpdt", "page_detail");
}

function tpdtEditController($http, $routeParams, pageTitleService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        $http.post("metamodelo/tpdt-save.action", {
            tpdt : vm.tpdt,
            i18nMap : vm.i18nMap,
            accion : vm.accion
        }).success(function(data) {
            setTimeout(function() {
                window.history.back();
            }, 0);
        });
    }

    function cancel() {
        window.history.back();
    }

    $http.get("metamodelo/tpdt-edit.action?tpdt.id=" + $routeParams.tpdtId).success(function(data) {
        vm.tpdt = data.tpdt;
        vm.i18nMap = data.i18nMap;
        vm.accion = data.accion;
        vm.tphts = data.tphts;
        vm.tiposElemento = data.tiposElemento;
    });

    $http.get("metamodelo/enti-lv-list.action?entiCriterio.tipo=P").success(function(data) {
        vm.entiTpprList = data.lvList;
    });

    $http.get("metamodelo/enti-lv-list.action?entiCriterio.tipo=T").success(function(data) {
        vm.entiTpsrList = data.lvList;
    });

    pageTitleService.setTitle("tpdt", "page_edit");
}

function cdrfCreateController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        $http.post("metamodelo/cdrf-save.action", {
            cdrf : vm.cdrf,
            i18nMap : vm.i18nMap,
            accion : vm.accion
        }).success(function(data) {
            $location.path("/metamodelo/cdrf/detail/" + data.cdrf.id).replace();
        });
    }

    function cancel() {
        window.history.back();
    }

    $http.get("metamodelo/cdrf-create.action?cdrf.tpdtId=" + $routeParams.tpdtId).success(function(data) {
        vm.cdrf = data.cdrf;
        vm.i18nMap = data.i18nMap;
        vm.accion = data.accion;
    });

    pageTitleService.setTitle("cdrf", "page_create");
}

function cdrfDetailController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.remove = remove;

    function remove() {
        if (confirm("Are you sure?")) {
            $http.get("metamodelo/cdrf-remove.action?cdrf.id=" + vm.cdrf.id).success(function(data) {
                window.history.back();
            });
        }
    }

    $http.get("metamodelo/cdrf-detail.action?cdrf.id=" + $routeParams.cdrfId).success(function(data) {
        vm.cdrf = data.cdrf;
        vm.i18nMap = data.i18nMap;
    });

    pageTitleService.setTitle("cdrf", "page_detail");
}

function cdrfEditController($http, $routeParams, pageTitleService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        $http.post("metamodelo/cdrf-save.action", {
            cdrf : vm.cdrf,
            i18nMap : vm.i18nMap,
            accion : vm.accion
        }).success(function(data) {
            setTimeout(function() {
                window.history.back();
            }, 0);
        });
    }

    function cancel() {
        window.history.back();
    }

    $http.get("metamodelo/cdrf-edit.action?cdrf.id=" + $routeParams.cdrfId).success(function(data) {
        vm.cdrf = data.cdrf;
        vm.i18nMap = data.i18nMap;
        vm.accion = data.accion;
    });

    pageTitleService.setTitle("cdrf", "page_edit");
}

function tpprGridController($http, $location, $routeParams, $modal, pageTitleService) {
    var vm = this;

    vm.pageChanged = pageChanged;
    vm.filter = filter;

    vm.entiCriterio = {};

    function search(entiCriterio, page, limit) {
        var url = "metamodelo/tppr-list.action";

        $http.post(url, {
            entiCriterio : entiCriterio,
            page : page,
            limit : limit
        }).success(function(data) {
            vm.page = data.entiList.page;
            vm.entiList = data.entiList;

            var map = {};

            map.page = data.entiList.page;

            $location.search(map).replace();
        });
    }

    function pageChanged() {
        search(vm.entiCriterio, vm.page, vm.limit);
    }

    function filter(size) {
        var modalInstance = $modal.open({
            templateUrl : 'modules/metamodelo/tppr-filter-modal.html',
            controller : 'tpprFilterController',
            controllerAs : 'vm',
            size : size,
            resolve : {
                entiCriterio : function() {
                    return vm.entiCriterio;
                }
            }
        });

        modalInstance.result.then(function(entiCriterio) {
            vm.entiCriterio = entiCriterio;
            vm.page = 1;

            search(vm.entiCriterio, 1, vm.limit);
        });
    }

    search(vm.entiCriterio, $routeParams.page ? $routeParams.page : 1, vm.limit);

    pageTitleService.setTitle("tppr", "page_grid");
}

function tpprFilterController($modalInstance, entiCriterio) {
    var vm = this;

    vm.ok = ok;
    vm.cancel = cancel;

    vm.entiCriterio = entiCriterio;

    function ok() {
        $modalInstance.close(vm.entiCriterio);
    }

    function cancel() {
        $modalInstance.dismiss('cancel');
    }
}

function tpprDetailController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.remove = remove;

    function remove() {
        if (confirm("Are you sure?")) {
            $http.get("metamodelo/tppr-remove.action?enti.id=" + $scope.enti.id).success(function(data) {
                window.history.back();
            });
        }
    }

    $http.get("metamodelo/tppr-detail.action?enti.id=" + $routeParams.entiId).success(function(data) {
        vm.enti = data.enti;
        vm.subentiList = data.subentiList;
        vm.i18nMap = data.i18nMap;
    });

    pageTitleService.setTitle("tppr", "page_detail");
}

function tpprEditController($http, $routeParams, pageTitleService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        $http.post("metamodelo/tppr-save.action", {
            enti : vm.enti,
            i18nMap : vm.i18nMap,
            accion : vm.accion
        }).success(function(data) {
            setTimeout(function() {
                window.history.back();
            }, 0);
        });
    }

    function cancel() {
        window.history.back();
    }

    $http.get("metamodelo/tppr-edit.action?enti.id=" + $routeParams.entiId).success(function(data) {
        vm.enti = data.enti;
        vm.accion = data.accion;
        vm.i18nMap = data.i18nMap;
    });

    $http
            .get(
                    "metamodelo/tpdt-lv-list.action?tpdtCriterio.tipoElemento=TX&tpdtCriterio.entiRefId="
                            + $routeParams.entiId).success(function(data) {
                vm.tpdtNombreList = data.lvList;
            });

    pageTitleService.setTitle("tppr", "page_edit");
}

function tpprCreateController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        $http.post("metamodelo/tppr-save.action", {
            enti : vm.enti,
            i18nMap : vm.i18nMap,
            accion : vm.accion
        }).success(function(data) {
            $location.path("/metamodelo/tppr/detail/" + data.enti.id).replace();
        });
    }

    function cancel() {
        setTimeout(function() {
            window.history.back();
        }, 0);
    }

    $http.get("metamodelo/tppr-create.action").success(function(data) {
        vm.enti = data.enti;
        vm.accion = data.accion;
    });

    $http
            .get(
                    "metamodelo/tpdt-lv-list.action?tpdtCriterio.tipoElemento=TX&tpdtCriterio.entiRefId="
                            + $routeParams.entiId).success(function(data) {
                vm.tpdtNombreList = data.lvList;
            });

    pageTitleService.setTitle("tppr", "page_create");
}

function tpspDetailController($http, $routeParams, pageTitleService) {
    var vm = this;

    vm.remove = remove;

    function remove() {
        if (confirm("Are you sure?")) {
            $http.get("metamodelo/tpsp-remove.action?enti.id=" + vm.enti.id).success(function(data) {
                window.history.back();
            });
        }
    }

    $http.get("metamodelo/tpsp-detail.action?enti.id=" + $routeParams.entiId).success(function(data) {
        vm.enti = data.enti;
        vm.i18nMap = data.i18nMap;
    });

    pageTitleService.setTitle("tpsp", "page_detail");
}

function tpspEditController($http, $routeParams, pageTitleService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        var url = "metamodelo/tpsp-save.action";

        $http.post(url, {
            enti : vm.enti,
            i18nMap : vm.i18nMap,
            accion : vm.accion
        }).success(function(data) {
            setTimeout(function() {
                window.history.back();
            }, 0);
        });
    }

    function cancel() {
        window.history.back();
    }

    $http.get("metamodelo/tpsp-edit.action?enti.id=" + $routeParams.entiId).success(function(data) {
        vm.enti = data.enti;
        vm.i18nMap = data.i18nMap;
        vm.accion = data.accion;
    });

    $http.get("metamodelo/enti-lv-list.action?entiCriterio.tipo=P").success(function(data) {
        vm.entiList = data.lvList;
    });

    pageTitleService.setTitle("tpsp", "page_edit");
}

function tpspCreateController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        $http.post("metamodelo/tpsp-save.action", {
            enti : vm.enti,
            i18nMap : vm.i18nMap,
            accion : vm.accion
        }).success(function(data) {
            $location.path("/metamodelo/tpsp/detail/" + data.enti.id).replace();
        });
    }

    function cancel() {
        window.history.back();
    }

    $http.get("metamodelo/tpsp-create.action?enti.tpprId=" + $routeParams.tpprId).success(function(data) {
        vm.enti = data.enti;
        vm.accion = data.accion;
    });

    $http.get("metamodelo/enti-lv-list.action?entiCriterio.tipo=P").success(function(data) {
        vm.entiList = data.lvList;
    });

    pageTitleService.setTitle("tpsp", "page_create");
}

function tpsrGridController($http, $location, $routeParams, $modal, pageTitleService) {
    var vm = this;

    vm.pageChanged = pageChanged;
    vm.filter = filter;

    vm.entiCriterio = {};

    function search(entiCriterio, page, limit) {
        $http.post("metamodelo/tpsr-list.action", {
            entiCriterio : entiCriterio,
            page : page,
            limit : limit
        }).success(function(data) {
            vm.page = data.entiList.page;
            vm.entiList = data.entiList;

            var map = {};

            map.page = data.entiList.page;

            $location.search(map).replace();
        });
    }

    function pageChanged() {
        search(vm.entiCriterio, vm.page, vm.limit);
    }

    function filter(size) {
        var modalInstance = $modal.open({
            templateUrl : 'modules/metamodelo/tpsr-filter-modal.html',
            controller : 'tpsrFilterController',
            controllerAs : 'vm',
            size : size,
            resolve : {
                entiCriterio : function() {
                    return vm.entiCriterio;
                }
            }
        });

        modalInstance.result.then(function(entiCriterio) {
            vm.entiCriterio = entiCriterio;
            vm.page = 1;

            search(vm.entiCriterio, 1, vm.limit);
        });
    }

    search(vm.entiCriterio, $routeParams.page ? $routeParams.page : 1, vm.limit);

    pageTitleService.setTitle("tpsr", "page_grid");
}

function tpsrFilterController($modalInstance, entiCriterio) {
    var vm = this;

    vm.ok = ok;
    vm.cancel = cancel;

    vm.entiCriterio = entiCriterio;

    function ok() {
        $modalInstance.close(vm.entiCriterio);
    }

    function cancel() {
        $modalInstance.dismiss('cancel');
    }
}

function tpsrDetailController($http, $routeParams, pageTitleService) {
    var vm = this;

    vm.remove = remove;

    function remove() {
        if (confirm("Are you sure?")) {
            $http.get("metamodelo/tpsr-remove.action?enti.id=" + vm.enti.id).success(function(data) {
                window.history.back();
            });
        }
    }

    $http.get("metamodelo/tpsr-detail.action?enti.id=" + $routeParams.entiId).success(function(data) {
        vm.enti = data.enti;
        vm.i18nMap = data.i18nMap;
        vm.subentiList = data.subentiList;
        vm.entiHijasList = data.entiHijasList;
    });

    pageTitleService.setTitle("tpsr", "page_detail");
}

function tpsrEditController($http, $routeParams, pageTitleService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        $http.post("metamodelo/tpsr-save.action", {
            enti : vm.enti,
            i18nMap : vm.i18nMap,
            accion : vm.accion
        }).success(function(data) {
            setTimeout(function() {
                window.history.back();
            }, 0);
        });
    }

    function cancel() {
        window.history.back();
    }

    $http.get("metamodelo/tpsr-edit.action?enti.id=" + $routeParams.entiId).success(function(data) {
        vm.enti = data.enti;
        vm.i18nMap = data.i18nMap;
        vm.accion = data.accion;
    });

    $http.get("metamodelo/tpdt-lv-list.action?tpdtCriterio.tipoElemento=CR").success(function(data) {
        vm.tpdtEstadoList = data.lvList;
    });

    pageTitleService.setTitle("tpsr", "page_edit");
}

function tpsrCreateController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        $http.post("metamodelo/tpsr-save.action", {
            enti : vm.enti,
            i18nMap : vm.i18nMap,
            accion : vm.accion
        }).success(function(data) {
            $location.path("/metamodelo/tpsr/detail/" + data.enti.id).replace();
        });
    }

    function cancel() {
        window.history.back();
    }

    $http.get("metamodelo/tpsr-create.action").success(function(data) {
        vm.enti = data.enti;
        vm.accion = data.accion;
    });

    $http.get("metamodelo/tpdt-lv-list.action?tpdtCriterio.tipoElemento=CR").success(function(data) {
        vm.tpdtEstadoList = data.lvList;
    });

    pageTitleService.setTitle("tpsr", "page_create");
}

function tpssDetailController($http, $routeParams, pageTitleService) {
    var vm = this;

    vm.remove = remove;

    function remove() {
        if (confirm("Are you sure?")) {
            $http.get("metamodelo/tpss-remove.action?enti.id=" + vm.enti.id).success(function(data) {
                window.history.back();
            });
        }
    }

    $http.get("metamodelo/tpss-detail.action?enti.id=" + $routeParams.entiId).success(function(data) {
        vm.enti = data.enti;
        vm.i18nMap = data.i18nMap;
        vm.entiHijasList = data.entiHijasList;
        vm.entiPadresList = data.entiPadresList;
    });

    pageTitleService.setTitle("tpss", "page_detail");
}

function tpssEditController($http, $routeParams, pageTitleService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        $http.post("metamodelo/tpss-save.action", {
            enti : vm.enti,
            i18nMap : vm.i18nMap,
            accion : vm.accion
        }).success(function(data) {
            setTimeout(function() {
                window.history.back();
            }, 0);
        });
    }

    function cancel() {
        window.history.back();
    }

    $http.get("metamodelo/tpss-edit.action?enti.id=" + $routeParams.entiId).success(function(data) {
        vm.enti = data.enti;
        vm.i18nMap = data.i18nMap;
        vm.accion = data.accion;
    });

    $http.get("metamodelo/tpdt-lv-list.action?tpdtCriterio.tipoElemento=CR").success(function(data) {
        vm.tpdtEstadoList = data.lvList;
    });

    pageTitleService.setTitle("tpss", "page_edit");
}

function tpssCreateController($scope, $http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        $http.post("metamodelo/tpss-save.action", {
            enti : vm.enti,
            i18nMap : vm.i18nMap,
            accion : vm.accion
        }).success(function(data) {
            $location.path("/metamodelo/tpss/detail/" + data.enti.id).replace();
        });
    }

    function cancel() {
        window.history.back();
    }

    $http.get("metamodelo/tpss-create.action?enti.tpsrId=" + $routeParams.tpsrId).success(function(data) {
        vm.enti = data.enti;
        vm.accion = data.accion;
    });

    $http.get("metamodelo/tpdt-lv-list.action?tpdtCriterio.tipoElemento=CR").success(function(data) {
        vm.tpdtEstadoList = data.lvList;
    });

    pageTitleService.setTitle("tpss", "page_create");
}

function tpesGridController($http, $location, $routeParams, $modal, pageTitleService) {
    var vm = this;

    vm.pageChanged = pageChanged;
    vm.filter = filter;

    vm.entiCriterio = {};

    function search(entiCriterio, page, limit) {
        var url = "metamodelo/tpes-list.action";

        $http.post(url, {
            entiCriterio : entiCriterio,
            page : page,
            limit : limit
        }).success(function(data) {
            vm.page = data.entiList.page;
            vm.entiList = data.entiList;

            var map = {};

            map.page = data.entiList.page;

            $location.search(map).replace();
        });
    }

    function pageChanged() {
        search(vm.entiCriterio, vm.page, vm.limit);
    }

    function filter(size) {
        var modalInstance = $modal.open({
            templateUrl : 'modules/metamodelo/tpes-filter-modal.html',
            controller : 'tpesFilterController',
            controllerAs : 'vm',
            size : size,
            resolve : {
                entiCriterio : function() {
                    return vm.entiCriterio;
                }
            }
        });

        modalInstance.result.then(function(entiCriterio) {
            vm.entiCriterio = entiCriterio;
            vm.page = 1;

            search(vm.entiCriterio, 1, vm.limit);
        });
    }

    search(vm.entiCriterio, $routeParams.page ? $routeParams.page : 1, vm.limit);

    pageTitleService.setTitle("tpes", "page_grid");
}

function tpesFilterController($modalInstance, entiCriterio) {
    var vm = this;

    vm.ok = ok;
    vm.cancel = cancel;

    vm.entiCriterio = entiCriterio;

    function ok() {
        $modalInstance.close(vm.entiCriterio);
    }

    function cancel() {
        $modalInstance.dismiss('cancel');
    }
}

function tpesDetailController($http, $routeParams, pageTitleService) {
    var vm = this;

    vm.remove = remove;

    function remove() {
        if (confirm("Are you sure?")) {
            $http.get("metamodelo/tpes-remove.action?enti.id=" + vm.enti.id).success(function(data) {
                window.history.back();
            });
        }
    }

    $http.get("metamodelo/tpes-detail.action?enti.id=" + $routeParams.entiId).success(function(data) {
        vm.enti = data.enti;
        vm.i18nMap = data.i18nMap;
        vm.subentiList = data.subentiList;
    });

    pageTitleService.setTitle("tpes", "page_detail");
}

function tpesEditController($http, $routeParams, pageTitleService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        $http.post("metamodelo/tpes-save.action", {
            enti : vm.enti,
            i18nMap : vm.i18nMap,
            accion : vm.accion
        }).success(function(data) {
            setTimeout(function() {
                window.history.back();
            }, 0);
        });
    }

    function cancel() {
        window.history.back();
    }

    $http.get("metamodelo/tpes-edit.action?enti.id=" + $routeParams.entiId).success(function(data) {
        vm.enti = data.enti;
        vm.i18nMap = data.i18nMap;
        vm.accion = data.accion;
    });

    pageTitleService.setTitle("tpes", "page_edit");
}

function tpesCreateController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        $http.post("metamodelo/tpes-save.action", {
            enti : vm.enti,
            i18nMap : vm.i18nMap,
            accion : vm.accion
        }).success(function(data) {
            $location.path("/metamodelo/tpes/detail/" + data.enti.id).replace();
        });
    }

    function cancel() {
        window.history.back();
    }

    $http.get("metamodelo/tpes-create.action").success(function(data) {
        vm.enti = data.enti;
        vm.accion = data.accion;
    });

    pageTitleService.setTitle("tpes", "page_create");
}

function entdDetailController($http, $routeParams, pageTitleService) {
    var vm = this;

    vm.remove = remove;

    function remove() {
        if (confirm("Are you sure?")) {
            $http.get(
                    "metamodelo/entd-remove.action?entd.entiId=" + vm.entd.entiId + "&entd.tpdt.id=" + vm.entd.tpdt.id)
                    .success(function(data) {
                        window.history.back();
                    });
        }
    }

    $http
            .get(
                    "metamodelo/entd-detail.action?entd.entiId=" + $routeParams.entiId + "&entd.tpdt.id="
                            + $routeParams.tpdtId).success(function(data) {
                vm.entd = data.entd;
            });

    pageTitleService.setTitle("entd", "page_detail");
}

function entdEditController($http, $routeParams, pageTitleService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        $http.post("metamodelo/entd-save.action", {
            entd : vm.entd,
            accion : vm.accion
        }).success(function(data) {
            setTimeout(function() {
                window.history.back();
            }, 0);
        });
    }

    function cancel() {
        window.history.back();
    }

    $http
            .get(
                    "metamodelo/entd-edit.action?entd.entiId=" + $routeParams.entiId + "&entd.tpdt.id="
                            + $routeParams.tpdtId).success(function(data) {
                vm.entd = data.entd;
                vm.accion = data.accion;
                vm.tpdtList = data.tpdtList;
                vm.engdList = data.engdList;
            });

    pageTitleService.setTitle("entd", "page_edit");
}

function entdCreateController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        $http.post("metamodelo/entd-save.action", {
            entd : vm.entd,
            accion : vm.accion
        }).success(function(data) {
            $location.path("/metamodelo/entd/detail/" + data.entd.entiId + "/" + data.entd.tpdt.id).replace();
        });
    }

    function cancel() {
        window.history.back();
    }

    $http.get("metamodelo/entd-create.action?entd.entiId=" + $routeParams.entiId).success(function(data) {
        vm.entd = data.entd;
        vm.tpdtList = data.tpdtList;
        vm.engdList = data.engdList;
        vm.accion = data.accion;
    });

    pageTitleService.setTitle("entd", "page_create");
}

function engdDetailController($scope, $http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.remove = remove;

    function remove() {
        if (confirm("Are you sure?")) {
            $http.get("metamodelo/engd-remove.action?engd.id=" + vm.engd.id).success(function(data) {
                window.history.back();
            });
        }
    }

    $http.get("metamodelo/engd-detail.action?engd.id=" + $routeParams.engdId).success(function(data) {
        vm.engd = data.engd;
        vm.i18nMap = data.i18nMap;
    });

    pageTitleService.setTitle("engd", "page_detail");
}

function engdEditController($http, $routeParams, pageTitleService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        $http.post("metamodelo/engd-save.action", {
            engd : vm.engd,
            i18nMap : vm.i18nMap,
            accion : vm.accion
        }).success(function(data) {
            setTimeout(function() {
                window.history.back();
            }, 0);
        });
    }

    function cancel() {
        window.history.back();
    }

    $http.get("metamodelo/engd-edit.action?engd.id=" + $routeParams.engdId).success(function(data) {
        vm.engd = data.engd;
        vm.i18nMap = data.i18nMap;
        vm.accion = data.accion;
    });

    pageTitleService.setTitle("engd", "page_edit");
}

function engdCreateController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        $http.post("metamodelo/engd-save.action", {
            engd : vm.engd,
            i18nMap : vm.i18nMap,
            accion : vm.accion
        }).success(function(data) {
            $location.path("/metamodelo/engd/detail/" + data.engd.id).replace();
        });
    }

    function cancel() {
        window.history.back();
    }

    $http.get("metamodelo/engd-create.action?engd.entiId=" + $routeParams.entiId).success(function(data) {
        vm.engd = data.engd;
        vm.accion = data.accion;
    });

    pageTitleService.setTitle("engd", "page_create");
}

function enacDetailController($scope, $http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.remove = remove;

    function remove() {
        if (confirm("Are you sure?")) {
            $http.get("metamodelo/enac-remove.action?enac.entiId=" + vm.enac.entiId + "&enac.path=" + vm.enac.path)
                    .success(function(data) {
                        window.history.back();
                    });
        }
    }

    $http.get("metamodelo/enac-detail.action?enac.entiId=" + $routeParams.entiId + "&enac.path=" + $routeParams.path)
            .success(function(data) {
                vm.enac = data.enac;
            });

    pageTitleService.setTitle("enac", "page_detail");
}

function enacEditController($http, $routeParams, pageTitleService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        $http.post("metamodelo/enac-save.action", {
            enac : vm.enac,
            accion : vm.accion
        }).success(function(data) {
            setTimeout(function() {
                window.history.back();
            }, 0);
        });
    }

    function cancel() {
        window.history.back();
    }

    $http.get("metamodelo/enac-edit.action?enac.entiId=" + $routeParams.entiId + "&enac.path=" + $routeParams.path)
            .success(function(data) {
                vm.enac = data.enac;
                vm.accion = data.accion;
            });

    pageTitleService.setTitle("enac", "page_edit");
}

function enacCreateController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        $http.post("metamodelo/enac-save.action", {
            enac : vm.enac,
            accion : vm.accion
        }).success(function(data) {
            $location.path("/metamodelo/enac/detail/" + data.enac.entiId + "/" + data.enac.path).replace();
        });
    }

    function cancel() {
        window.history.back();
    }

    $http.get("metamodelo/enac-create.action?enac.entiId=" + $routeParams.entiId).success(function(data) {
        vm.enac = data.enac;
        vm.accion = data.accion;
    });

    pageTitleService.setTitle("enac", "page_create");
}

function enenCreateController($http, $routeParams, pageTitleService) {
    var vm = this;

    $http.get("metamodelo/enen-create.action?enen.entiPadreId=" + $routeParams.entipId).success(function(data) {
        vm.enen = data.enen;
    });

    $http.get("metamodelo/enti-lv-list.action?entiCriterio.tipo=S").success(function(data) {
        vm.entiList = data.lvList;
    });

    pageTitleService.setTitle("enen", "page_create");
}