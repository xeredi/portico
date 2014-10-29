angular.module("servicio", [])

.config(config)

// ----------------- MENU PRINCIPAL --------------------------
.controller("servicioController", servicioController)

// ----------- SERVICIOS ------------------
.controller("srvcGridController", srvcGridController)

.controller("srvcFilterController", srvcFilterController)

.controller("srvcDetailController", srvcDetailController)

.controller("srvcCreateController", srvcCreateController)

.controller("srvcEditController", srvcEditController)

.controller("srvcDuplicateController", srvcDuplicateController)

.controller('srvcLupaCtrl', srvcLupaCtrl)

.controller("maniTotalesController", maniTotalesController)

// ----------- SUBSERVICIOS ------------------
.controller("ssrvGridController", ssrvGridController)

.controller("ssrvFilterController", ssrvFilterController)

.controller("ssrvDetailController", ssrvDetailController)

.controller("ssrvCreateController", ssrvCreateController)

.controller("ssrvEditController", ssrvEditController)

.controller("ssrvDuplicateController", ssrvDuplicateController)

.controller('ssrvLupaCtrl', ssrvLupaCtrl)

.controller("mablTotalesController", mablTotalesController);

function config($routeProvider) {
    $routeProvider

    .when("/servicio", {
        title : 'servicio_main',
        templateUrl : "modules/entidad/servicio/servicio.html",
        controller : "servicioController"
    })

    .when("/servicio/srvc/grid/:entiId", {
        templateUrl : "modules/entidad/servicio/srvc-grid.html",
        controller : "srvcGridController",
        controllerAs : "vm",
        reloadOnSearch : false
    })

    .when("/servicio/srvc/create/:entiId", {
        templateUrl : "modules/entidad/servicio/srvc-edit.html",
        controller : "srvcCreateController",
        controllerAs : "vm"
    })

    .when("/servicio/srvc/detail/:entiId/:srvcId", {
        templateUrl : "modules/entidad/servicio/srvc-detail.html",
        controller : "srvcDetailController",
        controllerAs : "vm",
        reloadOnSearch : false
    })

    .when("/servicio/srvc/edit/:entiId/:srvcId", {
        templateUrl : "modules/entidad/servicio/srvc-edit.html",
        controller : "srvcEditController",
        controllerAs : "vm"
    })

    .when("/servicio/srvc/duplicate/:entiId/:srvcId", {
        templateUrl : "modules/entidad/servicio/srvc-edit.html",
        controller : "srvcDuplicateController",
        controllerAs : "vm"
    })

    .when("/servicio/srvc/maniTotales/:srvcId", {
        title : 'mani_totales',
        templateUrl : "modules/entidad/servicio/manifiesto/mani-totales.html",
        controller : "maniTotalesController"
    })

    .when("/servicio/ssrv/grid/:entiId", {
        title : 'ssrv_grid',
        templateUrl : "modules/entidad/servicio/ssrv-grid.html",
        controller : "ssrvGridController",
        reloadOnSearch : false
    })

    .when("/servicio/ssrv/create/:entiId/:srvcId", {
        title : 'ssrv_create',
        templateUrl : "modules/entidad/servicio/ssrv-edit.html",
        controller : "ssrvCreateController"
    })

    .when("/servicio/ssrv/create/:entiId", {
        title : 'ssrv_create',
        templateUrl : "modules/entidad/servicio/ssrv-edit.html",
        controller : "ssrvCreateController"
    })

    .when("/servicio/ssrv/detail/:entiId/:ssrvId", {
        title : 'ssrv_detail',
        templateUrl : "modules/entidad/servicio/ssrv-detail.html",
        controller : "ssrvDetailController",
        reloadOnSearch : false
    })

    .when("/servicio/ssrv/edit/:entiId/:ssrvId", {
        title : 'ssrv_edit',
        templateUrl : "modules/entidad/servicio/ssrv-edit.html",
        controller : "ssrvEditController"
    })

    .when("/servicio/ssrv/duplicate/:entiId/:ssrvId", {
        title : 'ssrv_duplicate',
        templateUrl : "modules/entidad/servicio/ssrv-edit.html",
        controller : "ssrvDuplicateController"
    })

    .when("/servicio/ssrv/mablTotales/:srvcId/:ssrvId", {
        title : 'mabl_totales',
        templateUrl : "modules/entidad/servicio/manifiesto/mabl-totales.html",
        controller : "mablTotalesController"
    })
}

function servicioController($scope, $http, pageTitleService) {
    var url = "servicio/tpsr-list.action";

    $http.get(url).success(function(data) {
        $scope.tpsrList = data.tpsrList;
        $scope.tpssMap = data.tpssMap;
    });

    pageTitleService.setTitle("servicio", "page_home")
}

function srvcGridController($http, $location, $routeParams, $modal, pageTitleService, usSpinnerService) {
    var vm = this;

    vm.pageChanged = pageChanged;
    vm.filter = filter;

    vm.itemCriterio = $routeParams.itemCriterio ? angular.fromJson($routeParams.itemCriterio) : {};
    vm.itemCriterio.entiId = $routeParams.entiId;

    function search(page) {
        usSpinnerService.spin("spinner");

        $http.post("servicio/srvc-list.action", {
            itemCriterio : vm.itemCriterio,
            page : page,
            limit : vm.itemCriterio.limit
        }).success(function(data) {
            vm.enti = data.enti;
            vm.page = data.itemList.page;
            vm.itemList = data.itemList;
            vm.itemCriterio = data.itemCriterio;

            var map = {};

            map.page = data.itemList.page;
            map.itemCriterio = JSON.stringify(data.itemCriterio);

            $location.search(map).replace();

            usSpinnerService.stop("spinner");
        });
    }

    function pageChanged() {
        search(vm.page);
    }

    function filter(size) {
        var modalInstance = $modal.open({
            templateUrl : 'srvc-filter-content.html',
            controller : 'srvcFilterController',
            controllerAs : "vm",
            size : size,
            resolve : {
                itemCriterio : function() {
                    return vm.itemCriterio;
                },
                enti : function() {
                    return vm.enti;
                }
            }
        });

        modalInstance.result.then(function(itemCriterio) {
            console.log("srvcGridController: " + JSON.stringify(itemCriterio));

            vm.itemCriterio = itemCriterio;

            search(1);
        });
    }

    search($routeParams.page ? $routeParams.page : 1/*
                                                     * , $routeParams.limit ?
                                                     * $routeParams.limit : 20
                                                     */);
    pageTitleService.setTitleEnti($routeParams.entiId, "page_grid")
}

function srvcFilterController($http, $modalInstance, enti, itemCriterio) {
    var vm = this;

    vm.ok = ok;
    vm.cancel = cancel;

    vm.itemCriterio = itemCriterio;
    vm.enti = enti;

    function ok() {
        $modalInstance.close(vm.itemCriterio);
    }

    function cancel() {
        $modalInstance.dismiss('cancel');
    }

    $http.get("servicio/srvc-filter.action?itemCriterio.entiId=" + itemCriterio.entiId).success(function(data) {
        vm.labelValuesMap = data.labelValuesMap;
        vm.subpList = data.subpList;
        vm.limits = data.limits;
        vm.fechaVigencia = data.fechaVigencia;
    });
}

function srvcDetailController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.pageChanged = pageChanged;
    vm.tabSelected = tabSelected;
    vm.remove = remove;
    vm.srvcAction = srvcAction;

    var path = $location.path();
    var tabSelected = $routeParams.tabSelected;
    var srvcId = $routeParams.srvcId;
    var entiId = $routeParams.entiId;
    var pageMap = $routeParams.pageMap ? angular.fromJson($routeParams.pageMap) : {};

    vm.pageMap = {};

    function findSublist(subentiId, page) {
        vm.loading = true;

        $http.get(
                "servicio/ssrv-list.action?itemCriterio.entiId=" + subentiId + "&page=" + page
                        + "&itemCriterio.srvc.id=" + srvcId).success(function(data) {
            vm.entiHijasMap[data.itemCriterio.entiId] = data.enti;
            vm.itemHijosMap[data.itemCriterio.entiId] = data.itemList;
            vm.pageMap[data.itemCriterio.entiId] = data.itemList.page;

            $location.search("pageMap", JSON.stringify(vm.pageMap)).replace();

            vm.loading = false;
        });
    }

    function pageChanged(subentiId) {
        findSublist(subentiId, vm.pageMap[subentiId]);
    }

    function tabSelected(tabNo) {
        if (path == $location.path()) {
            $location.search("tabSelected", tabNo).replace();
        }
    }

    function remove() {
        if (confirm("Are you sure?")) {
            var url = "servicio/srvc-remove.action?item.id=" + vm.item.id;

            $http.get(url).success(function(data) {
                window.history.back();
            });
        }
    }

    function srvcAction(accName) {
        switch (accName) {
        // ----------- MANIFIESTO ------------------
        // ----------- MANIFIESTO ------------------
        // ----------- MANIFIESTO ------------------

        case "mani-bloquear":
            $http.get("servicio/manifiesto/mani-bloquear.action?item.id=" + vm.item.id).success(function(data) {
                findItem();
            });

            break;
        case "mani-completar":
            $http.get("servicio/manifiesto/mani-completar.action?item.id=" + vm.item.id).success(function(data) {
                findItem();
            });

            break;
        case "mani-iniciar":
            $http.get("servicio/manifiesto/mani-iniciar.action?item.id=" + vm.item.id).success(function(data) {
                findItem();
            });

            break;
        case "mani-anular":
            $http.get("servicio/manifiesto/mani-anular.action?item.id=" + vm.item.id).success(function(data) {
                findItem();
            });

            break;
        case "mani-totales":
            $location.path("/servicio/srvc/maniTotales/" + vm.item.id);

            break;
        default:
            alert(accName);

            break;
        }
    }

    $http.get("servicio/srvc-detail.action?item.id=" + srvcId).success(function(data) {
        vm.enti = data.enti;
        // vm.subentiList = data.subentiList;
        vm.item = data.item;
        vm.fechaVigencia = data.fechaVigencia;

        vm.entiHijasMap = {};
        vm.itemHijosMap = {};

        if (tabSelected) {
            // vm.entiHijasMap[tabSelected].active = true;
        }

        for (i = 0; i < vm.enti.entiHijasList.length; i++) {
            var subentiId = vm.enti.entiHijasList[i];

            console.log("getList: " + subentiId + ", " + pageMap[subentiId] ? pageMap[subentiId] : 1);

            findSublist(subentiId, pageMap[subentiId] ? pageMap[subentiId] : 1);
        }
    });

    pageTitleService.setTitleEnti($routeParams.entiId, "page_detail")
}

function srvcCreateController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        var url = "servicio/srvc-save.action";

        $http.post(url, {
            item : vm.item,
            accion : vm.accion
        }).success(function(data) {
            $location.path("/servicio/srvc/detail/" + data.item.entiId + "/" + data.item.id).replace();
        });
    }

    function cancel() {
        window.history.back();
    }

    $http.get("servicio/srvc-create.action?item.entiId=" + $routeParams.entiId).success(function(data) {
        vm.enti = data.enti;
        vm.accion = data.accion;
        vm.item = data.item;
        vm.labelValuesMap = data.labelValuesMap;
        vm.subpList = data.subpList;
    });

    pageTitleService.setTitleEnti($routeParams.entiId, "page_create")
}

function srvcEditController($http, $routeParams, pageTitleService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        $http.post("servicio/srvc-save.action", {
            item : vm.item,
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

    $http.get("servicio/srvc-edit.action?item.id=" + $routeParams.srvcId).success(function(data) {
        vm.enti = data.enti;
        vm.accion = data.accion;
        vm.item = data.item;
        vm.labelValuesMap = data.labelValuesMap;
    });

    pageTitleService.setTitleEnti($routeParams.entiId, "page_edit")
}

function srvcDuplicateController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        $http.post("servicio/srvc-save.action", {
            item : vm.item,
            accion : vm.accion
        }).success(function(data) {
            $location.path("/servicio/srvc/detail/" + data.item.entiId + "/" + data.item.id).replace();
        });
    }

    function cancel() {
        window.history.back();
    }

    $http.get("servicio/srvc-duplicate.action?item.id=" + $routeParams.srvcId).success(function(data) {
        vm.enti = data.enti;
        vm.accion = data.accion;
        vm.item = data.item;
        vm.labelValuesMap = data.labelValuesMap;
        vm.subpList = data.subpList;
    });

    pageTitleService.setTitleEnti($routeParams.entiId, "page_duplicate")
}

function srvcLupaCtrl($http, $scope) {
    $scope.getLabelValues = function(entiId, textoBusqueda) {
        return $http.get(
                'servicio/srvc-lupa.action?itemLupaCriterio.entiId=' + entiId + "&itemLupaCriterio.textoBusqueda="
                        + textoBusqueda + "&itemLupaCriterio.fechaVigencia=11/12/2014").then(function(res) {
            return res.data.itemList;
        });
    };
}

function maniTotalesController($scope, $http, $location, $routeParams) {
    var url = "servicio/manifiesto/mani-totales.action?item.id=" + $routeParams.srvcId;

    $http.get(url).success(function(data) {
        $scope.item = data.item;
        $scope.resumen = data.resumen;
    });
}

function ssrvGridController($scope, $http, $location, $routeParams, $modal) {
    $scope.itemCriterio = $routeParams.itemCriterio ? angular.fromJson($routeParams.itemCriterio) : {};
    $scope.itemCriterio.entiId = $routeParams.entiId;

    function search(itemCriterio, page) {
        $scope.loading = true;

        $http.post("servicio/ssrv-list.action", {
            itemCriterio : itemCriterio,
            page : page,
            limit : itemCriterio.limit
        }).success(function(data) {
            $scope.page = data.itemList.page;
            $scope.itemList = data.itemList;
            $scope.itemCriterio = data.itemCriterio;

            var map = {};

            map.page = data.itemList.page;
            map.itemCriterio = JSON.stringify(data.itemCriterio);

            $location.search(map).replace();

            $scope.loading = false;
        });
    }

    $scope.pageChanged = function() {
        search($scope.itemCriterio, $scope.page);
    }

    $scope.filter = function(size) {
        var modalInstance = $modal.open({
            templateUrl : 'ssrv-filter-content.html',
            controller : 'ssrvFilterController',
            size : size,
            resolve : {
                itemCriterio : function() {
                    return $scope.itemCriterio;
                },
                enti : function() {
                    return $scope.enti;
                }
            }
        });

        modalInstance.result.then(function(itemCriterio) {
            console.log("ssrvGridController: " + JSON.stringify(itemCriterio));

            $scope.itemCriterio = itemCriterio;

            search($scope.itemCriterio, 1);
        });
    }

    function findEnti() {
        var url = "metamodelo/tpss-proxy-detail.action?enti.id=" + $routeParams.entiId;

        $http.get(url).success(function(data) {
            $scope.enti = data.enti;
        });
    }

    findEnti();
    search($scope.itemCriterio, $routeParams.page ? $routeParams.page : 1);
}

function ssrvFilterController($scope, $http, $modalInstance, enti, itemCriterio) {
    console.log("ssrvFilterController: " + JSON.stringify(itemCriterio));

    $scope.itemCriterio = itemCriterio;
    $scope.enti = enti;

    $scope.ok = function() {
        $modalInstance.close($scope.itemCriterio);
    };

    $scope.cancel = function() {
        $modalInstance.dismiss('cancel');
    };

    $http.get("servicio/ssrv-filter.action?itemCriterio.entiId=" + itemCriterio.entiId).success(function(data) {
        $scope.labelValuesMap = data.labelValuesMap;
        $scope.limits = data.limits;
        $scope.fechaVigencia = data.fechaVigencia;
    });
}

function ssrvDetailController($scope, $http, $location, $routeParams) {
    var path = $location.path();
    var tabSelected = $routeParams.tabSelected;
    var ssrvId = $routeParams.ssrvId;
    var entiId = $routeParams.entiId;
    var pageMap = $routeParams.pageMap ? angular.fromJson($routeParams.pageMap) : {};

    $scope.pageMap = {};

    function findItem() {
        $http.get("metamodelo/tpss-proxy-detail.action?includeDependencies=true&enti.id=" + $routeParams.entiId)
                .success(function(data) {
                    $scope.enti = data.enti;
                    $scope.subentiList = data.subentiList;

                    if (tabSelected) {
                        $scope.subentiList[tabSelected].active = true;
                    }

                    $http.get("servicio/ssrv-detail.action?item.id=" + $routeParams.ssrvId).success(function(data) {
                        $scope.item = data.item;
                    });

                    $scope.itemHijosMap = {};

                    for (i = 0; i < $scope.subentiList.length; i++) {
                        var subenti = $scope.subentiList[i];

                        findSublist(subenti.id, pageMap[subenti.id] ? pageMap[subenti.id] : 1);
                    }
                });
    }

    function findSublist(subentiId, page) {
        var url = "servicio/ssrv-list.action?itemCriterio.entiId=" + subentiId + "&page=" + page
                + "&itemCriterio.padreId=" + ssrvId;

        $http.get(url).success(function(data) {
            $scope.itemHijosMap[data.itemCriterio.entiId] = data.itemList;
            $scope.pageMap[data.itemCriterio.entiId] = data.itemList.page;
            $location.search("pageMap", JSON.stringify($scope.pageMap)).replace();
        });
    }

    $scope.pageChanged = function(subentiId) {
        findSublist(subentiId, $scope.pageMap[subentiId]);
    }

    $scope.tabSelected = function(tabNo) {
        if (path == $location.path()) {
            $location.search("tabSelected", tabNo).replace();
        }
    }

    $scope.remove = function() {
        if (confirm("Are you sure?")) {
            var url = "servicio/ssrv-remove.action?item.id=" + $scope.item.id;

            $http.get(url).success(function(data) {
                window.history.back();
            });
        }
    }

    $scope.ssrvAction = function(accName) {
        switch (accName) {
        // ----------- BL ------------------
        // ----------- BL ------------------
        // ----------- BL ------------------

        case "mabl-bloquear":
            $http.get("servicio/manifiesto/mabl-bloquear.action?item.id=" + $scope.item.id).success(function(data) {
                $scope.item = data.item;
            });

            break;
        case "mabl-completar":
            $http.get("servicio/manifiesto/mabl-completar.action?item.id=" + $scope.item.id).success(function(data) {
                findItem();
            });

            break;
        case "mabl-iniciar":
            $http.get("servicio/manifiesto/mabl-iniciar.action?item.id=" + $scope.item.id).success(function(data) {
                findItem();
            });

            break;
        case "mabl-anular":
            $http.get("servicio/manifiesto/mabl-anular.action?item.id=" + $scope.item.id).success(function(data) {
                findItem();
            });

            break;
        case "mabl-totales":
            $location.path("/servicio/ssrv/mablTotales/" + $scope.item.srvc.id + "/" + $scope.item.id);

            break;

        // ----------- EQUIPAMIENTO ------------------
        // ----------- EQUIPAMIENTO ------------------
        // ----------- EQUIPAMIENTO ------------------

        case "equi-bloquear":
            $http.get("servicio/manifiesto/mabl-bloquear.action?item.id=" + $scope.item.id).success(function(data) {
                findItem();
            });

            break;
        case "equi-iniciar":
            $http.get("servicio/manifiesto/mabl-iniciar.action?item.id=" + $scope.item.id).success(function(data) {
                findItem();
            });

            break;
        case "equi-anular":
            $http.get("servicio/manifiesto/mabl-anular.action?item.id=" + $scope.item.id).success(function(data) {
                findItem();
            });

            break;

        // ----------- PARTIDA ------------------
        // ----------- PARTIDA ------------------
        // ----------- PARTIDA ------------------

        case "part-bloquear":
            $http.get("servicio/manifiesto/mabl-bloquear.action?item.id=" + $scope.item.id).success(function(data) {
                findItem();
            });

            break;
        case "part-iniciar":
            $http.get("servicio/manifiesto/mabl-iniciar.action?item.id=" + $scope.item.id).success(function(data) {
                findItem();
            });

            break;
        case "part-anular":
            $http.get("servicio/manifiesto/mabl-anular.action?item.id=" + $scope.item.id).success(function(data) {
                findItem();
            });

            break;
        default:
            alert(accName);

            break;
        }
    }

    findItem();
}

function ssrvCreateController($scope, $http, $location, $routeParams) {
    $scope.save = function() {
        var url = "servicio/ssrv-save.action";

        $http.post(url, {
            item : $scope.item,
            accion : $scope.accion
        }).success(function(data) {
            $location.path("/servicio/ssrv/detail/" + data.item.id).replace();
        });
    }

    $scope.cancel = function() {
        window.history.back();
    }

    function findItem() {
        var url = "servicio/ssrv-create.action?item.entiId=" + $routeParams.entiId;

        if ($routeParams.srvcId) {
            url += "&item.srvc.id=" + $routeParams.srvcId;
        }

        $http.get(url).success(function(data) {
            $scope.item = data.item;
            $scope.labelValuesMap = data.labelValuesMap;
            $scope.accion = data.accion;
        });
    }

    function findEnti() {
        var url = "metamodelo/tpss-proxy-detail.action?includeDependencies=true&enti.id=" + $routeParams.entiId;

        $http.get(url).success(function(data) {
            $scope.enti = data.enti;
            $scope.superentiList = data.superentiList;
        });
    }

    findEnti();
    findItem();
}

function ssrvEditController($scope, $http, $location, $routeParams) {
    $scope.save = function() {
        var url = "servicio/ssrv-save.action";

        $http.post(url, {
            item : $scope.item,
            accion : $scope.accion
        }).success(function(data) {
            setTimeout(function() {
                window.history.back();
            }, 0);
        });
    }

    $scope.cancel = function() {
        window.history.back();
    }

    function findItem() {
        var url = "servicio/ssrv-edit.action?item.id=" + $routeParams.ssrvId;

        $http.get(url).success(function(data) {
            $scope.item = data.item;
            $scope.labelValuesMap = data.labelValuesMap;
            $scope.accion = data.accion;
        });
    }

    function findEnti() {
        var url = "metamodelo/tpss-proxy-detail.action?enti.id=" + $routeParams.entiId;

        $http.get(url).success(function(data) {
            $scope.enti = data.enti;
        });
    }

    findEnti();
    findItem();
}

function ssrvDuplicateController($scope, $http, $location, $routeParams) {
    $scope.save = function() {
        var url = "servicio/ssrv-save.action";

        $http.post(url, {
            item : $scope.item,
            accion : $scope.accion
        }).success(function(data) {
            $location.path("/servicio/ssrv/detail/" + data.item.entiId + "/" + data.item.id).replace();
        });
    }

    $scope.cancel = function() {
        window.history.back();
    }

    function findItem() {
        var url = "servicio/ssrv-duplicate.action?item.id=" + $routeParams.ssrvId;

        $http.get(url).success(function(data) {
            $scope.item = data.item;
            $scope.labelValuesMap = data.labelValuesMap;
            $scope.accion = data.accion;
        });
    }

    function findEnti() {
        var url = "metamodelo/tpss-proxy-detail.action?enti.id=" + $routeParams.entiId;

        $http.get(url).success(function(data) {
            $scope.enti = data.enti;
        });
    }

    findEnti();
    findItem();
}

function ssrvLupaCtrl($http, $scope) {
    $scope.getLabelValues = function(entiId, srvcId, numero) {
        return $http.get(
                'servicio/ssrv-lupa.action?itemLupaCriterio.entiId=' + entiId + "&itemLupaCriterio.srvcId=" + srvcId
                        + "&itemLupaCriterio.numero=" + numero + "&itemLupaCriterio.fechaVigencia=11/12/2014").then(
                function(res) {
                    return res.data.itemList;
                });
    };
}

function mablTotalesController($scope, $http, $location, $routeParams) {
    var url = "servicio/manifiesto/mabl-totales.action?item.id=" + $routeParams.ssrvId + "&item.srvc.id="
            + $routeParams.srvcId;

    $http.get(url).success(function(data) {
        $scope.item = data.item;
        $scope.resumen = data.resumen;
    });
}
