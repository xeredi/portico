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

.controller("mablTotalesController", mablTotalesController)

.controller("atraAutorizarController", atraAutorizarController)

.controller("atraAnularController", atraAnularController)

.controller("atraIniciarController", atraIniciarController)

.controller("atraFinalizarController", atraFinalizarController)

.controller("atraDenegarController", atraDenegarController)

;

function config($routeProvider) {
    $routeProvider

    .when("/servicio", {
        title : 'servicio_main',
        templateUrl : "modules/entidad/servicio/servicio.html",
        controller : "servicioController",
        controllerAs : "vm"
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
        templateUrl : "modules/entidad/servicio/manifiesto/mani-totales.html",
        controller : "maniTotalesController",
        controllerAs : "vm"
    })

    .when("/servicio/ssrv/grid/:entiId", {
        templateUrl : "modules/entidad/servicio/ssrv-grid.html",
        controller : "ssrvGridController",
        controllerAs : "vm",
        reloadOnSearch : false
    })

    .when("/servicio/ssrv/create/:entiId/:srvcId", {
        templateUrl : "modules/entidad/servicio/ssrv-edit.html",
        controller : "ssrvCreateController",
        controllerAs : "vm"
    })

    .when("/servicio/ssrv/create/:entiId", {
        templateUrl : "modules/entidad/servicio/ssrv-edit.html",
        controller : "ssrvCreateController",
        controllerAs : "vm"
    })

    .when("/servicio/ssrv/detail/:entiId/:ssrvId", {
        templateUrl : "modules/entidad/servicio/ssrv-detail.html",
        controller : "ssrvDetailController",
        controllerAs : "vm",
        reloadOnSearch : false
    })

    .when("/servicio/ssrv/edit/:entiId/:ssrvId", {
        templateUrl : "modules/entidad/servicio/ssrv-edit.html",
        controller : "ssrvEditController",
        controllerAs : "vm"
    })

    .when("/servicio/ssrv/duplicate/:entiId/:ssrvId", {
        templateUrl : "modules/entidad/servicio/ssrv-edit.html",
        controller : "ssrvDuplicateController",
        controllerAs : "vm"
    })

    .when("/servicio/ssrv/mablTotales/:srvcId/:ssrvId", {
        templateUrl : "modules/entidad/servicio/manifiesto/mabl-totales.html",
        controller : "mablTotalesController",
        controllerAs : "vm"
    })

    .when("/servicio/ssrv/atraDenegar/:srvcId/:ssrvId", {
        templateUrl : "modules/entidad/servicio/escala/atra-denegar.html",
        controller : "atraDenegarController",
        controllerAs : "vm"
    })

    .when("/servicio/ssrv/atraAutorizar/:srvcId/:ssrvId", {
        templateUrl : "modules/entidad/servicio/escala/atra-autorizar.html",
        controller : "atraAutorizarController",
        controllerAs : "vm"
    })

    .when("/servicio/ssrv/atraAnular/:srvcId/:ssrvId", {
        templateUrl : "modules/entidad/servicio/escala/atra-anular.html",
        controller : "atraAnularController",
        controllerAs : "vm"
    })

    .when("/servicio/ssrv/atraIniciar/:srvcId/:ssrvId", {
        templateUrl : "modules/entidad/servicio/escala/atra-iniciar.html",
        controller : "atraIniciarController",
        controllerAs : "vm"
    })

    .when("/servicio/ssrv/atraFinalizar/:srvcId/:ssrvId", {
        templateUrl : "modules/entidad/servicio/escala/atra-finalizar.html",
        controller : "atraFinalizarController",
        controllerAs : "vm"
    })

    .when("/servicio/ssrv/atraCambiarMuelle/:srvcId/:ssrvId", {
        templateUrl : "modules/entidad/servicio/escala/atra-cambiarMuelle.html",
        controller : "atraCambiarMuelleController",
        controllerAs : "vm"
    })

    .when("/servicio/ssrv/atraAutorizarFPrevio/:srvcId/:ssrvId", {
        templateUrl : "modules/entidad/servicio/escala/atra-autorizarFPrevio.html",
        controller : "atraAutorizarFPrevioController",
        controllerAs : "vm"
    })

    ;
}

function servicioController($http, pageTitleService) {
    var vm = this;

    $http.get("servicio/tpsr-list.action").success(function(data) {
        vm.tpsrList = data.tpsrList;
        vm.tpssMap = data.tpssMap;
    });

    pageTitleService.setTitle("srvcList", "page_home");
}

function srvcGridController($http, $location, $routeParams, $modal, pageTitleService) {
    var vm = this;

    vm.pageChanged = pageChanged;
    vm.filter = filter;
    vm.xlsExport = xlsExport;

    vm.itemCriterio = $routeParams.itemCriterio ? angular.fromJson($routeParams.itemCriterio) : {};
    vm.itemCriterio.entiId = $routeParams.entiId;

    function search(page) {
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
        });
    }

    function pageChanged() {
        search(vm.page);
    }

    function xlsExport() {
        $http.post('servicio/srvc-xls-export.action', {
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

    search($routeParams.page ? $routeParams.page : 1);
    pageTitleService.setTitleEnti($routeParams.entiId, "page_grid");
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

    $http.post("servicio/srvc-filter.action", {
        itemCriterio : vm.itemCriterio
    }).success(function(data) {
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

    vm.path = $location.path();
    var pageMap = $routeParams.pageMap ? angular.fromJson($routeParams.pageMap) : {};

    vm.pageMap = {};

    function findSublist(subentiId, page) {
        $http.get(
                "servicio/ssrv-list.action?itemCriterio.entiId=" + subentiId + "&page=" + page
                        + "&itemCriterio.srvc.id=" + $routeParams.srvcId).success(function(data) {
            vm.entiHijasMap[data.itemCriterio.entiId] = data.enti;
            vm.itemHijosMap[data.itemCriterio.entiId] = data.itemList;
            vm.pageMap[data.itemCriterio.entiId] = data.itemList.page;

            $location.search("pageMap", JSON.stringify(vm.pageMap)).replace();
        });
    }

    function pageChanged(subentiId) {
        findSublist(subentiId, vm.pageMap[subentiId]);
    }

    function tabSelected(tabNo) {
        if (vm.path == $location.path()) {
            $location.search("tab", tabNo).replace();
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
                vm.item = data.item;
            });

            break;
        case "mani-completar":
            $http.get("servicio/manifiesto/mani-completar.action?item.id=" + vm.item.id).success(function(data) {
                vm.item = data.item;
            });

            break;
        case "mani-iniciar":
            $http.get("servicio/manifiesto/mani-iniciar.action?item.id=" + vm.item.id).success(function(data) {
                vm.item = data.item;
            });

            break;
        case "mani-anular":
            $http.get("servicio/manifiesto/mani-anular.action?item.id=" + vm.item.id).success(function(data) {
                vm.item = data.item;
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

    vm.tabActive = {};

    if ($routeParams.tab) {
        vm.tabActive[$routeParams.tab] = true;
    }

    $http.get("servicio/srvc-detail.action?item.id=" + $routeParams.srvcId).success(function(data) {
        vm.enti = data.enti;
        // vm.subentiList = data.subentiList;
        vm.item = data.item;
        vm.fechaVigencia = data.fechaVigencia;

        vm.entiHijasMap = {};
        vm.itemHijosMap = {};

        for (i = 0; i < vm.enti.entiHijasList.length; i++) {
            var subentiId = vm.enti.entiHijasList[i];

            findSublist(subentiId, pageMap[subentiId] ? pageMap[subentiId] : 1);
        }
    });

    pageTitleService.setTitleEnti($routeParams.entiId, "page_detail");
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
        vm.fechaVigencia = data.fechaVigencia;
        vm.item = data.item;
        vm.labelValuesMap = data.labelValuesMap;
        vm.subpList = data.subpList;
    });

    pageTitleService.setTitleEnti($routeParams.entiId, "page_create");
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
        vm.fechaVigencia = data.fechaVigencia;
        vm.item = data.item;
        vm.labelValuesMap = data.labelValuesMap;
    });

    pageTitleService.setTitleEnti($routeParams.entiId, "page_edit");
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
        vm.fechaVigencia = data.fechaVigencia;
        vm.item = data.item;
        vm.labelValuesMap = data.labelValuesMap;
        vm.subpList = data.subpList;
    });

    pageTitleService.setTitleEnti($routeParams.entiId, "page_duplicate");
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

function ssrvGridController($http, $location, $routeParams, $modal, pageTitleService) {
    var vm = this;

    vm.pageChanged = pageChanged;
    vm.filter = filter;
    vm.xlsExport = xlsExport;

    vm.itemCriterio = $routeParams.itemCriterio ? angular.fromJson($routeParams.itemCriterio) : {};
    vm.itemCriterio.entiId = $routeParams.entiId;

    function search(itemCriterio, page) {
        $http.post("servicio/ssrv-list.action", {
            itemCriterio : itemCriterio,
            page : page,
            limit : itemCriterio.limit
        }).success(function(data) {
            vm.page = data.itemList.page;
            vm.enti = data.enti;
            vm.itemList = data.itemList;
            vm.itemCriterio = data.itemCriterio;

            var map = {};

            map.page = data.itemList.page;
            map.itemCriterio = JSON.stringify(data.itemCriterio);

            $location.search(map).replace();
        });
    }

    function pageChanged() {
        search(vm.itemCriterio, vm.page);
    }

    function xlsExport() {
        $http.post('servicio/ssrv-xls-export.action', {
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
        var modalInstance = $modal.open({
            templateUrl : 'modules/entidad/servicio/ssrv-filter-content.html',
            controller : 'ssrvFilterController',
            controllerAs : 'vm',
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
            vm.itemCriterio = itemCriterio;

            search(vm.itemCriterio, 1);
        });
    }

    search(vm.itemCriterio, $routeParams.page ? $routeParams.page : 1);

    pageTitleService.setTitleEnti($routeParams.entiId, "page_grid");
}

function ssrvFilterController($http, $modalInstance, enti, itemCriterio) {
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

    $http.post("servicio/ssrv-filter.action", {
        itemCriterio : vm.itemCriterio
    }).success(function(data) {
        vm.labelValuesMap = data.labelValuesMap;
        vm.limits = data.limits;
        vm.fechaVigencia = data.fechaVigencia;
    });
}

function ssrvDetailController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.pageChanged = pageChanged;
    vm.tabSelected = tabSelected;
    vm.remove = remove;
    vm.ssrvAction = ssrvAction;

    vm.path = $location.path();
    vm.pageMap = $routeParams.pageMap ? angular.fromJson($routeParams.pageMap) : {};

    vm.pageMap = {};

    function findSublist(subentiId, page) {
        $http.get(
                "servicio/ssrv-list.action?itemCriterio.entiId=" + subentiId + "&page=" + page
                        + "&itemCriterio.padreId=" + $routeParams.ssrvId).success(function(data) {

            vm.entiHijasMap[data.itemCriterio.entiId] = data.enti;
            vm.itemHijosMap[data.itemCriterio.entiId] = data.itemList;
            vm.pageMap[data.itemCriterio.entiId] = data.itemList.page;

            if (data.enti.id == vm.tabSelected) {
                vm.entiHijasMap[data.itemCriterio.entiId].active = true;
            }

            $location.search("pageMap", JSON.stringify(vm.pageMap)).replace();
        });
    }

    function pageChanged(subentiId) {
        findSublist(subentiId, vm.pageMap[subentiId]);
    }

    function tabSelected(tabNo) {
        if (vm.path == $location.path()) {
            $location.search("tab", tabNo).replace();
        }
    }

    function remove() {
        if (confirm("Are you sure?")) {
            $http.get("servicio/ssrv-remove.action?item.id=" + $scope.item.id).success(function(data) {
                window.history.back();
            });
        }
    }

    function ssrvAction(accName) {
        switch (accName) {
        // ----------- BL ------------------
        // ----------- BL ------------------
        // ----------- BL ------------------

        case "mabl-bloquear":
            $http.get("servicio/manifiesto/mabl-bloquear.action?item.id=" + vm.item.id).success(function(data) {
                vm.item = data.item;
            });

            break;
        case "mabl-completar":
            $http.get("servicio/manifiesto/mabl-completar.action?item.id=" + vm.item.id).success(function(data) {
                vm.item = data.item;
            });

            break;
        case "mabl-iniciar":
            $http.get("servicio/manifiesto/mabl-iniciar.action?item.id=" + vm.item.id).success(function(data) {
                vm.item = data.item;
            });

            break;
        case "mabl-anular":
            $http.get("servicio/manifiesto/mabl-anular.action?item.id=" + vm.item.id).success(function(data) {
                vm.item = data.item;
            });

            break;
        case "mabl-totales":
            $location.path("/servicio/ssrv/mablTotales/" + vm.item.srvc.id + "/" + vm.item.id);

            break;

        // ----------- EQUIPAMIENTO ------------------
        // ----------- EQUIPAMIENTO ------------------
        // ----------- EQUIPAMIENTO ------------------

        case "equi-bloquear":
            $http.get("servicio/manifiesto/equi-bloquear.action?item.id=" + vm.item.id).success(function(data) {
                vm.item = data.item;
            });

            break;
        case "equi-iniciar":
            $http.get("servicio/manifiesto/equi-iniciar.action?item.id=" + vm.item.id).success(function(data) {
                vm.item = data.item;
            });

            break;
        case "equi-anular":
            $http.get("servicio/manifiesto/equi-anular.action?item.id=" + vm.item.id).success(function(data) {
                vm.item = data.item;
            });

            break;

        // ----------- PARTIDA ------------------
        // ----------- PARTIDA ------------------
        // ----------- PARTIDA ------------------
        case "part-bloquear":
            $http.get("servicio/manifiesto/part-bloquear.action?item.id=" + vm.item.id).success(function(data) {
                vm.item = data.item;
            });

            break;
        case "part-iniciar":
            $http.get("servicio/manifiesto/part-iniciar.action?item.id=" + vm.item.id).success(function(data) {
                vm.item = data.item;
            });

            break;
        case "part-anular":
            $http.get("servicio/manifiesto/part-anular.action?item.id=" + vm.item.id).success(function(data) {
                vm.item = data.item;
            });

            break;

        case "atra-denegar":
            $location.path("/servicio/ssrv/atraDenegar/" + vm.item.srvc.id + "/" + vm.item.id);

            break;
        case "atra-autorizar":
            $location.path("/servicio/ssrv/atraAutorizar/" + vm.item.srvc.id + "/" + vm.item.id);

            break;
        case "atra-anular":
            $location.path("/servicio/ssrv/atraAnular/" + vm.item.srvc.id + "/" + vm.item.id);

            break;
        case "atra-iniciar":
            $location.path("/servicio/ssrv/atraIniciar/" + vm.item.srvc.id + "/" + vm.item.id);

            break;
        case "atra-finalizar":
            $location.path("/servicio/ssrv/atraFinalizar/" + vm.item.srvc.id + "/" + vm.item.id);

            break;
        case "atra-cambiar-muelle":
            $location.path("/servicio/ssrv/atraCambiarMuelle/" + vm.item.srvc.id + "/" + vm.item.id);

            break;
        case "atra-autorizar-fprevio":
            $location.path("/servicio/ssrv/atraAutorizarFPrevio/" + vm.item.srvc.id + "/" + vm.item.id);

            break;

        default:
            alert(accName);

            break;
        }
    }

    vm.tabActive = {};

    if ($routeParams.tab) {
        vm.tabActive[$routeParams.tab] = true;
    }

    $http.get("servicio/ssrv-detail.action?item.id=" + $routeParams.ssrvId).success(function(data) {
        vm.enti = data.enti;
        vm.fechaVigencia = data.fechaVigencia;
        vm.item = data.item;

        vm.itemHijosMap = {};
        vm.entiHijasMap = {};

        if (data.enti.entiHijasList) {
            for (i = 0; i < data.enti.entiHijasList.length; i++) {
                findSublist(data.enti.entiHijasList[i], 1);
            }
        }
    });
    /*
     * vm.subentiList = data.subentiList;
     *
     * if (tabSelected) { vm.subentiList[tabSelected].active = true; }
     *
     * for (i = 0; i < vm.subentiList.length; i++) { var subenti = vm.subentiList[i];
     *
     * findSublist(subenti.id, pageMap[subenti.id] ? pageMap[subenti.id] : 1); }
     */
    pageTitleService.setTitleEnti($routeParams.entiId, "page_detail");
}

function ssrvCreateController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        $http.post("servicio/ssrv-save.action", {
            item : vm.item,
            accion : vm.accion
        }).success(function(data) {
            $location.path("/servicio/ssrv/detail/" + data.item.id).replace();
        });
    }

    function cancel() {
        window.history.back();
    }

    $http
            .get(
                    "servicio/ssrv-create.action?item.entiId=" + $routeParams.entiId + "&item.srvc.id="
                            + $routeParams.srvcId).success(function(data) {
                vm.enti = data.enti;
                vm.superentiList = data.superentiList;
                vm.fechaVigencia = data.fechaVigencia;
                vm.item = data.item;
                vm.labelValuesMap = data.labelValuesMap;
                vm.accion = data.accion;
            });

    pageTitleService.setTitleEnti($routeParams.entiId, "page_create");
}

function ssrvEditController($http, $routeParams, pageTitleService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        $http.post("servicio/ssrv-save.action", {
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

    $http.get("servicio/ssrv-edit.action?item.id=" + $routeParams.ssrvId).success(function(data) {
        vm.enti = data.enti;
        vm.fechaVigencia = data.fechaVigencia;
        vm.item = data.item;
        vm.labelValuesMap = data.labelValuesMap;
        vm.accion = data.accion;
    });

    pageTitleService.setTitleEnti($routeParams.entiId, "page_edit");
}

function ssrvDuplicateController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        $http.post("servicio/ssrv-save.action", {
            item : vm.item,
            accion : vm.accion
        }).success(function(data) {
            $location.path("/servicio/ssrv/detail/" + data.item.entiId + "/" + data.item.id).replace();
        });
    }

    function cancel() {
        window.history.back();
    }

    $http.get("servicio/ssrv-duplicate.action?item.id=" + $routeParams.ssrvId).success(function(data) {
        vm.enti = data.enti;
        vm.fechaVigencia = data.fechaVigencia;
        vm.item = data.item;
        vm.labelValuesMap = data.labelValuesMap;
        vm.accion = data.accion;
    });

    pageTitleService.setTitleEnti($routeParams.entiId, "page_duplicate");
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

function mablTotalesController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    $http.get(
            "servicio/manifiesto/mabl-totales.action?item.id=" + $routeParams.ssrvId + "&item.srvc.id="
                    + $routeParams.srvcId).success(function(data) {
        vm.item = data.item;
        vm.resumen = data.resumen;
    });

    pageTitleService.setTitleEnti($routeParams.entiId, "page_verificarTotales");
}

function atraDenegarController($http, $routeParams, pageTitleService) {
    var vm = this;

    $http.get(
            "servicio/escala/atra-denegar.action?item.id=" + $routeParams.ssrvId + "&item.srvc.id="
                    + $routeParams.srvcId).success(function(data) {
        vm.item = data.item;
        vm.enti = data.enti;

        pageTitleService.setTitleEnti(vm.enti.id, "page_atraDenegar");
    });
}

function atraAutorizarController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    $http.get(
            "servicio/escala/atra-autorizar.action?item.id=" + $routeParams.ssrvId + "&item.srvc.id="
                    + $routeParams.srvcId).success(function(data) {
        vm.item = data.item;
        vm.enti = data.enti;

        pageTitleService.setTitleEnti(vm.enti.id, "page_atraAutorizar");
    });
}

function atraAnularController($http, $routeParams, pageTitleService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        alert('save');
    }

    function cancel() {
        window.history.back();
    }

    $http.get(
            "servicio/escala/atra-anular.action?item.id=" + $routeParams.ssrvId + "&item.srvc.id="
                    + $routeParams.srvcId).success(function(data) {
        vm.item = data.item;
        vm.enti = data.enti;

        pageTitleService.setTitleEnti(vm.enti.id, "page_atraAnular");
    });
}

function atraIniciarController($http, $routeParams, pageTitleService) {
    var vm = this;

    $http.get(
            "servicio/escala/atra-iniciar.action?item.id=" + $routeParams.ssrvId + "&item.srvc.id="
                    + $routeParams.srvcId).success(function(data) {
        vm.item = data.item;
        vm.enti = data.enti;

        pageTitleService.setTitleEnti(vm.enti.id, "page_atraIniciar");
    });
}

function atraFinalizarController($http, $routeParams, pageTitleService) {
    var vm = this;

    $http.get(
            "servicio/escala/atra-finalizar.action?item.id=" + $routeParams.ssrvId + "&item.srvc.id="
                    + $routeParams.srvcId).success(function(data) {
        vm.item = data.item;
        vm.enti = data.enti;

        pageTitleService.setTitleEnti(vm.enti.id, "page_atraFinalizar");
    });
}

function atraCambiarMuelleController($scope, $http, $location, $routeParams, pageTitleService) {
    var vm = this;

    $http.get(
            "servicio/escala/atra-cambiarMuelle.action?item.id=" + $routeParams.ssrvId + "&item.srvc.id="
                    + $routeParams.srvcId).success(function(data) {
        vm.item = data.item;
        vm.enti = data.enti;

        pageTitleService.setTitleEnti(vm.enti.id, "page_atraCambiarMuelle");
    });
}

function atraAutorizarFPrevioController($scope, $http, $location, $routeParams, pageTitleService) {
    var vm = this;

    $http.get(
            "servicio/escala/atra-autorizarFPrevio.action?item.id=" + $routeParams.ssrvId + "&item.srvc.id="
                    + $routeParams.srvcId).success(function(data) {
        vm.item = data.item;
        vm.enti = data.enti;

        pageTitleService.setTitleEnti(vm.enti.id, "page_atraAutorizarFPrevio");
    });
}
