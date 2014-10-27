angular.module("metamodelo", [ "ngRoute", "util" ])

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

.controller("tpprDetailController", tpprDetailController)

.controller("tpprEditController", tpprEditController)

.controller("tpprCreateController", tpprCreateController)

.controller("tpspDetailController", tpspDetailController)

.controller("tpspEditController", tpspEditController)

.controller("tpspCreateController", tpspCreateController)

// -------------------- TIPO DE SERVICIO ------------------
.controller("tpsrGridController", tpsrGridController)

.controller("tpsrDetailController", tpsrDetailController)

.controller("tpsrEditController", tpsrEditController)

.controller("tpsrCreateController", tpsrCreateController)

.controller("tpssDetailController", tpssDetailController)

.controller("tpssEditController", tpssEditController)

.controller("tpssCreateController", tpssCreateController)

// -------------------- ESTADISTICA ------------------
.controller("tpesGridController", tpesGridController)

.controller("tpesDetailController", tpesDetailController)

.controller("tpesEditController", tpesEditController)

.controller("tpesCreateController", tpesCreateController)

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
        title : 'tpdtList',
        templateUrl : "modules/metamodelo/tpdt-grid.html",
        controller : "tpdtGridController",
        controllerAs : 'vm',
        reloadOnSearch : false
    })

    .when("/metamodelo/tpdt/create", {
        title : 'tpdt_create',
        templateUrl : "modules/metamodelo/tpdt-edit.html",
        controller : "tpdtCreateController",
        controllerAs : 'vm'
    })

    .when("/metamodelo/tpdt/detail/:tpdtId", {
        title : 'tpdt',
        templateUrl : "modules/metamodelo/tpdt-detail.html",
        controller : "tpdtDetailController",
        controllerAs : 'vm'
    })

    .when("/metamodelo/tpdt/edit/:tpdtId", {
        title : 'tpdt_edit',
        templateUrl : "modules/metamodelo/tpdt-edit.html",
        controller : "tpdtEditController",
        controllerAs : 'vm'
    })

    .when("/metamodelo/cdrf/detail/:cdrfId", {
        title : 'cdrf',
        templateUrl : "modules/metamodelo/cdrf-detail.html",
        controller : "cdrfDetailController",
        controllerAs : 'vm'
    })

    .when("/metamodelo/cdrf/edit/:cdrfId", {
        title : 'cdrf_edit',
        templateUrl : "modules/metamodelo/cdrf-edit.html",
        controller : "cdrfEditController",
        controllerAs : 'vm'
    })

    .when("/metamodelo/cdrf/create/:tpdtId", {
        title : 'cdrf_create',
        templateUrl : "modules/metamodelo/cdrf-edit.html",
        controller : "cdrfCreateController",
        controllerAs : 'vm'
    })

    .when("/metamodelo/tppr/grid", {
        title : 'tpprList',
        templateUrl : "modules/metamodelo/tppr-grid.html",
        controller : "tpprGridController",
        reloadOnSearch : false
    })

    .when("/metamodelo/tppr/detail/:entiId", {
        title : 'tppr',
        templateUrl : "modules/metamodelo/tppr-detail.html",
        controller : "tpprDetailController"
    })

    .when("/metamodelo/tppr/edit/:entiId", {
        title : 'tppr_edit',
        templateUrl : "modules/metamodelo/tppr-edit.html",
        controller : "tpprEditController"
    })

    .when("/metamodelo/tppr/create", {
        title : 'tppr_create',
        templateUrl : "modules/metamodelo/tppr-edit.html",
        controller : "tpprCreateController"
    })

    .when("/metamodelo/tpsp/detail/:entiId", {
        title : 'tpsp',
        templateUrl : "modules/metamodelo/tpsp-detail.html",
        controller : "tpspDetailController"
    })

    .when("/metamodelo/tpsp/edit/:entiId", {
        title : 'tpsp_edit',
        templateUrl : "modules/metamodelo/tpsp-edit.html",
        controller : "tpspEditController"
    })

    .when("/metamodelo/tpsp/create/:tpprId", {
        title : 'tpsp_create',
        templateUrl : "modules/metamodelo/tpsp-edit.html",
        controller : "tpspCreateController"
    })

    .when("/metamodelo/tpsr/grid", {
        title : 'tpsrList',
        templateUrl : "modules/metamodelo/tpsr-grid.html",
        controller : "tpsrGridController",
        reloadOnSearch : false
    })

    .when("/metamodelo/tpsr/detail/:entiId", {
        title : 'tpsr',
        templateUrl : "modules/metamodelo/tpsr-detail.html",
        controller : "tpsrDetailController"
    })

    .when("/metamodelo/tpsr/edit/:entiId", {
        title : 'tpsr_edit',
        templateUrl : "modules/metamodelo/tpsr-edit.html",
        controller : "tpsrEditController"
    })

    .when("/metamodelo/tpsr/create", {
        title : 'tpsr_create',
        templateUrl : "modules/metamodelo/tpsr-edit.html",
        controller : "tpsrCreateController"
    })

    .when("/metamodelo/tpss/detail/:entiId", {
        title : 'tpss',
        templateUrl : "modules/metamodelo/tpss-detail.html",
        controller : "tpssDetailController"
    })

    .when("/metamodelo/tpss/edit/:entiId", {
        title : 'tpss_edit',
        templateUrl : "modules/metamodelo/tpss-edit.html",
        controller : "tpssEditController"
    })

    .when("/metamodelo/tpss/create/:tpsrId", {
        title : 'tpss_create',
        templateUrl : "modules/metamodelo/tpss-edit.html",
        controller : "tpssCreateController"
    })

    .when("/metamodelo/tpes/grid", {
        title : 'tpesList',
        templateUrl : "modules/metamodelo/tpes-grid.html",
        controller : "tpesGridController",
        reloadOnSearch : false
    })

    .when("/metamodelo/tpes/detail/:entiId", {
        title : 'tpes',
        templateUrl : "modules/metamodelo/tpes-detail.html",
        controller : "tpesDetailController"
    })

    .when("/metamodelo/tpes/edit/:entiId", {
        title : 'tpes_edit',
        templateUrl : "modules/metamodelo/tpes-edit.html",
        controller : "tpesEditController"
    })

    .when("/metamodelo/tpes/create", {
        title : 'tpes_create',
        templateUrl : "modules/metamodelo/tpes-edit.html",
        controller : "tpesCreateController"
    })

    .when("/metamodelo/entd/detail/:entiId/:tpdtId", {
        title : 'entd',
        templateUrl : "modules/metamodelo/entd-detail.html",
        controller : "entdDetailController"
    })

    .when("/metamodelo/entd/edit/:entiId/:tpdtId", {
        title : 'entd_edit',
        templateUrl : "modules/metamodelo/entd-edit.html",
        controller : "entdEditController"
    })

    .when("/metamodelo/entd/create/:entiId", {
        title : 'entd_create',
        templateUrl : "modules/metamodelo/entd-edit.html",
        controller : "entdCreateController"
    })

    .when("/metamodelo/enac/detail/:entiId/:path", {
        title : 'enac',
        templateUrl : "modules/metamodelo/enac-detail.html",
        controller : "enacDetailController"
    })

    .when("/metamodelo/enac/edit/:entiId/:path", {
        title : 'enac_edit',
        templateUrl : "modules/metamodelo/enac-edit.html",
        controller : "enacEditController"
    })

    .when("/metamodelo/enac/create/:entiId", {
        title : 'enac_create',
        templateUrl : "modules/metamodelo/enac-edit.html",
        controller : "enacCreateController"
    })

    .when("/metamodelo/enen/create/:entipId", {
        title : 'enen_create',
        templateUrl : "modules/metamodelo/enen-edit.html",
        controller : "enenCreateController"
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
            vm.actionErrors = data.actionErrors;

            if (data.actionErrors.length == 0) {
                vm.page = data.tpdtList.page;
                vm.tpdtList = data.tpdtList;

                var map = {};

                map["page"] = data.tpdtList.page;

                $location.search(map).replace();
            }
        });
    }

    function pageChanged() {
        search(vm.tpdtCriterio, vm.page, vm.limit);
    }

    function filter(size) {
        var modalInstance = $modal.open({
            templateUrl : 'modules/metamodelo/tpdt-filter-content.html',
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
            accion : vm.accion
        }).success(function(data) {
            vm.actionErrors = data.actionErrors;

            if (data.actionErrors.length == 0) {
                $location.path("/metamodelo/tpdt/detail/" + data.tpdt.id).replace();
            }
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

function tpdtDetailController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.remove = remove;

    function remove() {
        if (confirm("Are you sure?")) {
            $http.get("metamodelo/tpdt-remove.action?tpdt.id=" + vm.tpdt.id).success(function(data) {
                vm.actionErrors = data.actionErrors;

                if (data.actionErrors.length == 0) {
                    window.history.back();
                }
            });
        }
    }

    $http.get("metamodelo/tpdt-detail.action?tpdt.id=" + $routeParams.tpdtId).success(function(data) {
        vm.tpdt = data.tpdt;
        vm.i18nMap = data.i18nMap;
    });

    pageTitleService.setTitle("tpdt", "page_detail");
}

function tpdtEditController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        $http.post("metamodelo/tpdt-save.action", {
            tpdt : vm.tpdt,
            accion : vm.accion
        }).success(function(data) {
            vm.actionErrors = data.actionErrors;

            if (data.actionErrors.length == 0) {
                setTimeout(function() {
                    window.history.back();
                }, 0);
            }
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

function cdrfCreateController($scope, $http, $location, $routeParams) {
    var url = "metamodelo/cdrf-create.action?cdrf.tpdtId=" + $routeParams.tpdtId;

    $http.get(url).success(function(data) {
        $scope.cdrf = data.cdrf;
        $scope.i18nMap = data.i18nMap;
        $scope.accion = data.accion;
    });

    $scope.save = function() {
        var url = "metamodelo/cdrf-save.action";

        $http.post(url, {
            cdrf : $scope.cdrf,
            i18nMap : $scope.i18nMap,
            accion : $scope.accion
        }).success(function(data) {
            $scope.actionErrors = data.actionErrors;

            if (data.actionErrors.length == 0) {
                $location.path("/metamodelo/cdrf/detail/" + data.cdrf.id).replace();
            }
        });
    }

    $scope.cancel = function() {
        window.history.back();
    }
}

function cdrfDetailController($scope, $http, $location, $routeParams) {
    var url = "metamodelo/cdrf-detail.action?cdrf.id=" + $routeParams.cdrfId;

    $http.get(url).success(function(data) {
        $scope.cdrf = data.cdrf;
        $scope.i18nMap = data.i18nMap;
    });

    $scope.remove = function() {
        if (confirm("Are you sure?")) {
            var url = "metamodelo/cdrf-remove.action?cdrf.id=" + $scope.cdrf.id;

            $http.get(url).success(function(data) {
                $scope.actionErrors = data.actionErrors;

                if (data.actionErrors.length == 0) {
                    window.history.back();
                }
            });
        }
    }
}

function cdrfEditController($scope, $http, $location, $routeParams) {
    var url = "metamodelo/cdrf-edit.action?cdrf.id=" + $routeParams.cdrfId;

    $http.get(url).success(function(data) {
        $scope.cdrf = data.cdrf;
        $scope.i18nMap = data.i18nMap;
        $scope.accion = data.accion;
    });

    $scope.save = function(form) {
        var url = "metamodelo/cdrf-save.action";

        $http.post(url, {
            cdrf : $scope.cdrf,
            i18nMap : $scope.i18nMap,
            accion : $scope.accion
        }).success(function(data) {
            $scope.actionErrors = data.actionErrors;

            if (data.actionErrors.length == 0) {
                setTimeout(function() {
                    window.history.back();
                }, 0);
            }
        });
    }

    $scope.cancel = function() {
        window.history.back();
    }
}

function tpprGridController($scope, $http, $location, $routeParams) {
    $scope.showFilter = false;
    $scope.entiCriterio = {};

    function search(entiCriterio, page, limit) {
        var url = "metamodelo/tppr-list.action";

        $http.post(url, {
            entiCriterio : entiCriterio,
            page : page,
            limit : limit
        }).success(function(data) {
            $scope.actionErrors = data.actionErrors;

            if (data.actionErrors.length == 0) {
                $scope.page = data.entiList.page;
                $scope.entiList = data.entiList;

                var map = {};

                map["page"] = data.entiList.page;

                $location.search(map).replace();

                $scope.showFilter = false;
            }
        });
    }

    $scope.pageChanged = function() {
        search($scope.entiCriterio, $scope.page, $scope.limit);
    }

    $scope.filter = function() {
        $scope.showFilter = true;
    }

    $scope.search = function() {
        search($scope.entiCriterio, 1, $scope.limit);
    }

    $scope.cancelSearch = function() {
        $scope.showFilter = false;
    }

    search($scope.entiCriterio, $routeParams.page ? $routeParams.page : 1, $scope.limit);
}

function tpprDetailController($scope, $http, $location, $routeParams) {
    var url = "metamodelo/tppr-detail.action?enti.id=" + $routeParams.entiId;

    $http.get(url).success(function(data) {
        $scope.enti = data.enti;
        $scope.subentiList = data.subentiList;
        $scope.i18nMap = data.i18nMap;
    });

    $scope.remove = function() {
        bootbox.confirm("Are you sure?", function(result) {
            if (result) {
                var url = "metamodelo/tppr-remove.action?enti.id=" + $scope.enti.id;

                $http.get(url).success(function(data) {
                    $scope.actionErrors = data.actionErrors;

                    if (data.actionErrors.length == 0) {
                        window.history.back();
                    }
                });
            }
        });
    }
}

function tpprEditController($scope, $http, $location, $routeParams) {
    var url = "metamodelo/tppr-edit.action?enti.id=" + $routeParams.entiId;

    $http.get(url).success(function(data) {
        $scope.enti = data.enti;
        $scope.accion = data.accion;
        $scope.i18nMap = data.i18nMap;
    });

    var urlTpdtNombreList = "metamodelo/tpdt-lv-list.action?tpdtCriterio.tipoElemento=TX&tpdtCriterio.entiRefId="
            + $routeParams.entiId;

    $http.get(urlTpdtNombreList).success(function(data) {
        $scope.tpdtNombreList = data.lvList;
    });

    $scope.save = function() {
        var url = "metamodelo/tppr-save.action";

        $http.post(url, {
            enti : $scope.enti,
            accion : $scope.accion
        }).success(function(data) {
            $scope.actionErrors = data.actionErrors;

            if (data.actionErrors.length == 0) {
                setTimeout(function() {
                    window.history.back();
                }, 0);
            }
        });
    }

    $scope.cancel = function() {
        window.history.back();
    }
}

function tpprCreateController($scope, $http, $location, $routeParams) {
    var url = "metamodelo/tppr-create.action";

    $http.get(url).success(function(data) {
        $scope.enti = data.enti;
        $scope.accion = data.accion;
    });

    var urlTpdtNombreList = "metamodelo/tpdt-lv-list.action?tpdtCriterio.tipoElemento=TX&tpdtCriterio.entiRefId="
            + $routeParams.entiId;

    $http.get(urlTpdtNombreList).success(function(data) {
        $scope.tpdtNombreList = data.lvList;
    });

    $scope.save = function() {
        var url = "metamodelo/tppr-save.action";

        $http.post(url, {
            enti : $scope.enti,
            accion : $scope.accion
        }).success(function(data) {
            $scope.actionErrors = data.actionErrors;

            if (data.actionErrors.length == 0) {
                $location.path("/metamodelo/tppr/detail/" + data.enti.id).replace();
            }
        });
    }

    $scope.cancel = function() {
        setTimeout(function() {
            window.history.back();
        }, 0);
    }
}

function tpspDetailController($scope, $http, $location, $routeParams) {
    var url = "metamodelo/tpsp-detail.action?enti.id=" + $routeParams.entiId;

    $http.get(url).success(function(data) {
        $scope.enti = data.enti;
    });

    $scope.remove = function() {
        bootbox.confirm("Are you sure?", function(result) {
            if (result) {
                var url = "metamodelo/tpsp-remove.action?enti.id=" + $scope.enti.id;

                $http.get(url).success(function(data) {
                    $scope.actionErrors = data.actionErrors;

                    if (data.actionErrors.length == 0) {
                        window.history.back();
                    }
                });
            }
        });
    }
}

function tpspEditController($scope, $http, $location, $routeParams) {
    var url = "metamodelo/tpsp-edit.action?enti.id=" + $routeParams.entiId;

    $http.get(url).success(function(data) {
        $scope.enti = data.enti;
        $scope.accion = data.accion;
    });

    var urlEntiList = "metamodelo/enti-lv-list.action?entiCriterio.tipo=P";

    $http.get(urlEntiList).success(function(data) {
        $scope.entiList = data.lvList;
    });

    $scope.save = function() {
        var url = "metamodelo/tpsp-save.action";

        $http.post(url, {
            enti : $scope.enti,
            accion : $scope.accion
        }).success(function(data) {
            $scope.actionErrors = data.actionErrors;

            if (data.actionErrors.length == 0) {
                setTimeout(function() {
                    window.history.back();
                }, 0);
            }
        });
    }

    $scope.cancel = function() {
        window.history.back();
    }
}

function tpspCreateController($scope, $http, $location, $routeParams) {
    var url = "metamodelo/tpsp-create.action?enti.tpprId=" + $routeParams.tpprId;

    $http.get(url).success(function(data) {
        $scope.enti = data.enti;
        $scope.accion = data.accion;
    });

    var urlEntiList = "metamodelo/enti-lv-list.action?entiCriterio.tipo=P";

    $http.get(urlEntiList).success(function(data) {
        $scope.entiList = data.lvList;
    });

    $scope.save = function() {
        var url = "metamodelo/tpsp-save.action";

        $http.post(url, {
            enti : $scope.enti,
            accion : $scope.accion
        }).success(function(data) {
            $scope.actionErrors = data.actionErrors;

            if (data.actionErrors.length == 0) {
                $location.path("/metamodelo/tpsp/detail/" + data.enti.id).replace();
            }
        });
    }

    $scope.cancel = function() {
        window.history.back();
    }
}

function tpsrGridController($scope, $http, $location, $routeParams) {
    $scope.showFilter = false;
    $scope.entiCriterio = {};

    function search(entiCriterio, page, limit) {
        var url = "metamodelo/tpsr-list.action";

        $http.post(url, {
            entiCriterio : entiCriterio,
            page : page,
            limit : limit
        }).success(function(data) {
            $scope.actionErrors = data.actionErrors;

            if (data.actionErrors.length == 0) {
                $scope.page = data.entiList.page;
                $scope.entiList = data.entiList;

                var map = {};

                map["page"] = data.entiList.page;

                $location.search(map).replace();

                $scope.showFilter = false;
            }
        });
    }

    $scope.pageChanged = function() {
        search($scope.entiCriterio, $scope.page, $scope.limit);
    }

    $scope.filter = function() {
        $scope.showFilter = true;
    }

    $scope.search = function() {
        search($scope.entiCriterio, 1, $scope.limit);
    }

    $scope.cancelSearch = function() {
        $scope.showFilter = false;
    }

    search($scope.entiCriterio, $routeParams.page ? $routeParams.page : 1, $scope.limit);
}

function tpsrDetailController($scope, $http, $location, $routeParams) {
    var url = "metamodelo/tpsr-detail.action?enti.id=" + $routeParams.entiId;

    $http.get(url).success(function(data) {
        $scope.enti = data.enti;
        $scope.subentiList = data.subentiList;
        $scope.entiHijasList = data.entiHijasList;
    });

    $scope.remove = function() {
        bootbox.confirm("Are you sure?", function(result) {
            if (result) {
                var url = "metamodelo/tpsr-remove.action?enti.id=" + $scope.enti.id;

                $http.get(url).success(function(data) {
                    $scope.actionErrors = data.actionErrors;

                    if (data.actionErrors.length == 0) {
                        window.history.back();
                    }
                });
            }
        });
    }
}

function tpsrEditController($scope, $http, $location, $routeParams) {
    var url = "metamodelo/tpsr-edit.action?enti.id=" + $routeParams.entiId;

    $http.get(url).success(function(data) {
        $scope.enti = data.enti;
        $scope.accion = data.accion;
    });

    var urlTpdtEstado = "metamodelo/tpdt-lv-list.action?tpdtCriterio.tipoElemento=CR";

    $http.get(urlTpdtEstado).success(function(data) {
        $scope.tpdtEstadoList = data.lvList;
    });

    $scope.save = function() {
        var url = "metamodelo/tpsr-save.action";

        $http.post(url, {
            enti : $scope.enti,
            accion : $scope.accion
        }).success(function(data) {
            $scope.actionErrors = data.actionErrors;

            if (data.actionErrors.length == 0) {
                setTimeout(function() {
                    window.history.back();
                }, 0);
            }
        });
    }

    $scope.cancel = function() {
        window.history.back();
    }
}

function tpsrCreateController($scope, $http, $location, $routeParams) {
    var url = "metamodelo/tpsr-create.action";

    $http.get(url).success(function(data) {
        $scope.enti = data.enti;
        $scope.accion = data.accion;
    });

    var urlTpdtEstado = "metamodelo/tpdt-lv-list.action?tpdtCriterio.tipoElemento=CR";

    $http.get(urlTpdtEstado).success(function(data) {
        $scope.tpdtEstadoList = data.lvList;
    });

    $scope.save = function() {
        var url = "metamodelo/tpsr-save.action";

        $http.post(url, {
            enti : $scope.enti,
            accion : $scope.accion
        }).success(function(data) {
            $scope.actionErrors = data.actionErrors;

            if (data.actionErrors.length == 0) {
                $location.path("/metamodelo/tpsr/detail/" + data.enti.id).replace();
            }
        });
    }

    $scope.cancel = function() {
        window.history.back();
    }
}

function tpssDetailController($scope, $http, $location, $routeParams) {
    var url = "metamodelo/tpss-detail.action?enti.id=" + $routeParams.entiId;

    $http.get(url).success(function(data) {
        $scope.enti = data.enti;
        $scope.entiHijasList = data.entiHijasList;
        $scope.entiPadresList = data.entiPadresList;
    });

    $scope.remove = function() {
        bootbox.confirm("Are you sure?", function(result) {
            if (result) {
                var url = "metamodelo/tpss-remove.action?enti.id=" + $scope.enti.id;

                $http.get(url).success(function(data) {
                    $scope.actionErrors = data.actionErrors;

                    if (data.actionErrors.length == 0) {
                        window.history.back();
                    }
                });
            }
        });
    }
}

function tpssEditController($scope, $http, $location, $routeParams) {
    var url = "metamodelo/tpss-edit.action?enti.id=" + $routeParams.entiId;

    $http.get(url).success(function(data) {
        $scope.enti = data.enti;
        $scope.accion = data.accion;
    });

    var urlTpdtEstado = "metamodelo/tpdt-lv-list.action?tpdtCriterio.tipoElemento=CR";

    $http.get(urlTpdtEstado).success(function(data) {
        $scope.tpdtEstadoList = data.lvList;
    });

    $scope.save = function() {
        var url = "metamodelo/tpss-save.action";

        $http.post(url, {
            enti : $scope.enti,
            accion : $scope.accion
        }).success(function(data) {
            $scope.actionErrors = data.actionErrors;

            if (data.actionErrors.length == 0) {
                setTimeout(function() {
                    window.history.back();
                }, 0);
            }
        });
    }

    $scope.cancel = function() {
        window.history.back();
    }
}

function tpssCreateController($scope, $http, $location, $routeParams) {
    var url = "metamodelo/tpss-create.action?enti.tpsrId=" + $routeParams.tpsrId;

    $http.get(url).success(function(data) {
        $scope.enti = data.enti;
        $scope.accion = data.accion;
    });

    var urlTpdtEstado = "metamodelo/tpdt-lv-list.action?tpdtCriterio.tipoElemento=CR";

    $http.get(urlTpdtEstado).success(function(data) {
        $scope.tpdtEstadoList = data.lvList;
    });

    $scope.save = function() {
        var url = "metamodelo/tpss-save.action";

        $http.post(url, {
            enti : $scope.enti,
            accion : $scope.accion
        }).success(function(data) {
            $scope.actionErrors = data.actionErrors;

            if (data.actionErrors.length == 0) {
                $location.path("/metamodelo/tpss/detail/" + data.enti.id).replace();
            }
        });
    }

    $scope.cancel = function() {
        window.history.back();
    }
}

function tpesGridController($scope, $http, $location, $routeParams) {
    $scope.showFilter = false;
    $scope.entiCriterio = {};

    function search(entiCriterio, page, limit) {
        var url = "metamodelo/tpes-list.action";

        $http.post(url, {
            entiCriterio : entiCriterio,
            page : page,
            limit : limit
        }).success(function(data) {
            $scope.actionErrors = data.actionErrors;

            if (data.actionErrors.length == 0) {
                $scope.page = data.entiList.page;
                $scope.entiList = data.entiList;

                var map = {};

                map["page"] = data.entiList.page;

                $location.search(map).replace();

                $scope.showFilter = false;
            }
        });
    }

    $scope.pageChanged = function() {
        search($scope.entiCriterio, $scope.page, $scope.limit);
    }

    $scope.filter = function() {
        $scope.showFilter = true;
    }

    $scope.search = function() {
        search($scope.entiCriterio, 1, $scope.limit);
    }

    $scope.cancelSearch = function() {
        $scope.showFilter = false;
    }

    search($scope.entiCriterio, $routeParams.page ? $routeParams.page : 1, $scope.limit);
}

function tpesDetailController($scope, $http, $location, $routeParams) {
    var url = "metamodelo/tpes-detail.action?enti.id=" + $routeParams.entiId;

    $http.get(url).success(function(data) {
        $scope.enti = data.enti;
        $scope.subentiList = data.subentiList;
    });

    $scope.remove = function() {
        bootbox.confirm("Are you sure?", function(result) {
            if (result) {
                var url = "metamodelo/tpes-remove.action?enti.id=" + $scope.enti.id;

                $http.get(url).success(function(data) {
                    $scope.actionErrors = data.actionErrors;

                    if (data.actionErrors.length == 0) {
                        window.history.back();
                    }
                });
            }
        });
    }
}

function tpesEditController($scope, $http, $location, $routeParams) {
    var url = "metamodelo/tpes-edit.action?enti.id=" + $routeParams.entiId;

    $http.get(url).success(function(data) {
        $scope.enti = data.enti;
        $scope.accion = data.accion;
    });

    $scope.save = function() {
        var url = "metamodelo/tpes-save.action";

        $http.post(url, {
            enti : $scope.enti,
            accion : $scope.accion
        }).success(function(data) {
            $scope.actionErrors = data.actionErrors;

            if (data.actionErrors.length == 0) {
                setTimeout(function() {
                    window.history.back();
                }, 0);
            }
        });
    }

    $scope.cancel = function() {
        window.history.back();
    }
}

function tpesCreateController($scope, $http, $location, $routeParams) {
    var url = "metamodelo/tpes-create.action";

    $http.get(url).success(function(data) {
        $scope.enti = data.enti;
        $scope.accion = data.accion;
    });

    $scope.save = function() {
        var url = "metamodelo/tpes-save.action";

        $http.post(url, {
            enti : $scope.enti,
            accion : $scope.accion
        }).success(function(data) {
            $scope.actionErrors = data.actionErrors;

            if (data.actionErrors.length == 0) {
                $location.path("/metamodelo/tpes/detail/" + data.enti.id).replace();
            }
        });
    }

    $scope.cancel = function() {
        window.history.back();
    }
}

function entdDetailController($scope, $http, $location, $routeParams) {
    var url = "metamodelo/entd-detail.action?entd.entiId=" + $routeParams.entiId + "&entd.tpdt.id="
            + $routeParams.tpdtId;

    $http.get(url).success(function(data) {
        $scope.entd = data.entd;
    });

    $scope.remove = function() {
        bootbox.confirm("Are you sure?", function(result) {
            if (result) {
                var url = "metamodelo/entd-remove.action?entd.entiId=" + $scope.entd.entiId + "&entd.tpdt.id="
                        + $scope.entd.tpdt.id;

                $http.get(url).success(function(data) {
                    $scope.actionErrors = data.actionErrors;

                    if (data.actionErrors.length == 0) {
                        window.history.back();
                    }
                });
            }
        });
    }
}

function entdEditController($scope, $http, $routeParams) {
    var url = "metamodelo/entd-edit.action?entd.entiId=" + $routeParams.entiId + "&entd.tpdt.id=" + $routeParams.tpdtId;

    $http.get(url).success(function(data) {
        $scope.entd = data.entd;
        $scope.accion = data.accion;
        $scope.tpdtList = data.tpdtList;
        $scope.engdList = data.engdList;
    });

    $scope.save = function() {
        var url = "metamodelo/entd-save.action";

        $http.post(url, {
            entd : $scope.entd,
            accion : $scope.accion
        }).success(function(data) {
            $scope.actionErrors = data.actionErrors;

            if (data.actionErrors.length == 0) {
                setTimeout(function() {
                    window.history.back();
                }, 0);
            }
        });
    }

    $scope.cancel = function() {
        window.history.back();
    }
}

function entdCreateController($scope, $http, $location, $routeParams) {
    var url = "metamodelo/entd-create.action?entd.entiId=" + $routeParams.entiId;

    $http.get(url).success(function(data) {
        $scope.entd = data.entd;
        $scope.tpdtList = data.tpdtList;
        $scope.engdList = data.engdList;
        $scope.accion = data.accion;
    });

    $scope.save = function() {
        var url = "metamodelo/entd-save.action";

        $http.post(url, {
            entd : $scope.entd,
            accion : $scope.accion
        }).success(function(data) {
            $scope.actionErrors = data.actionErrors;

            if (data.actionErrors.length == 0) {
                $location.path("/metamodelo/entd/detail/" + data.entd.entiId + "/" + data.entd.tpdt.id).replace();
            }
        });
    }

    $scope.cancel = function() {
        window.history.back();
    }
}

function enacDetailController($scope, $http, $location, $routeParams) {
    var url = "metamodelo/enac-detail.action?enac.entiId=" + $routeParams.entiId + "&enac.path=" + $routeParams.path;

    $http.get(url).success(function(data) {
        $scope.enac = data.enac;
    });

    $scope.remove = function() {
        bootbox.confirm("Are you sure?", function(result) {
            if (result) {
                var url = "metamodelo/enac-remove.action?enac.entiId=" + $scope.enac.entiId + "&enac.path="
                        + $scope.enac.path;

                $http.get(url).success(function(data) {
                    $scope.actionErrors = data.actionErrors;

                    if (data.actionErrors.length == 0) {
                        window.history.back();
                    }
                });
            }
        });
    }
}

function enacEditController($scope, $http, $location, $routeParams) {
    var url = "metamodelo/enac-edit.action?enac.entiId=" + $routeParams.entiId + "&enac.path=" + $routeParams.path;

    $http.get(url).success(function(data) {
        $scope.enac = data.enac;
        $scope.accion = data.accion;
    });

    $scope.save = function() {
        var url = "metamodelo/enac-save.action";

        $http.post(url, {
            enac : $scope.enac,
            accion : $scope.accion
        }).success(function(data) {
            $scope.actionErrors = data.actionErrors;

            if (data.actionErrors.length == 0) {
                setTimeout(function() {
                    window.history.back();
                }, 0);
            }
        });
    }

    $scope.cancel = function() {
        window.history.back();
    }
}

function enacCreateController($scope, $http, $location, $routeParams) {
    var url = "metamodelo/enac-create.action?enac.entiId=" + $routeParams.entiId;

    $http.get(url).success(function(data) {
        $scope.enac = data.enac;
        $scope.accion = data.accion;
    });

    $scope.save = function() {
        var url = "metamodelo/enac-save.action";

        $http.post(url, {
            enac : $scope.enac,
            accion : $scope.accion
        }).success(function(data) {
            $scope.actionErrors = data.actionErrors;

            if (data.actionErrors.length == 0) {
                $location.path("/metamodelo/enac/detail/" + data.enac.entiId + "/" + data.enac.path).replace();
            }
        });
    }

    $scope.cancel = function() {
        window.history.back();
    }
}

function enenCreateController($scope, $http, $location, $routeParams) {
    var url = "metamodelo/enen-create.action?enen.entiPadreId=" + $routeParams.entipId;

    $http.get(url).success(function(data) {
        $scope.enen = data.enen;
    });

    var urlEnti = "metamodelo/enti-lv-list.action?entiCriterio.tipo=S";

    $http.get(urlEnti).success(function(data) {
        $scope.entiList = data.lvList;
    });
}