angular.module("maestro", [ "ngRoute", "util" ])

.config(config)

.factory('prmtService', prmtService)

.factory('sprmService', sprmService)

// ----------------- MENU PRINCIPAL --------------------------
.controller("maestroController", maestroController)

// ----------- PARAMETROS ------------------
.controller("prmtGridController", prmtGridController)

.controller("prmtFilterController", prmtFilterController)

.controller("prmtDetailController", prmtDetailController)

.controller("prmtCreateController", prmtCreateController)

.controller("prmtEditController", prmtEditController)

.controller("prmtDuplicateController", prmtDuplicateController)

.controller('prmtsLupaCtrl', prmtsLupaCtrl)

// ----------- SUBPARAMETROS ------------------
.controller("sprmDetailController", sprmDetailController)

.controller("sprmCreateController", sprmCreateController)

.controller("sprmEditController", sprmEditController)

.controller("sprmDuplicateController", sprmDuplicateController);

function config($routeProvider) {
    $routeProvider

    .when("/maestro", {
        templateUrl : "modules/entidad/maestro/maestro.html",
        controller : "maestroController",
        controllerAs : 'vm'
    })

    .when("/maestro/prmt/grid/:entiId", {
        templateUrl : "modules/entidad/maestro/prmt-grid.html",
        controller : "prmtGridController",
        controllerAs : 'vm',
        reloadOnSearch : false
    })

    .when("/maestro/prmt/grid/:entiId/:page", {
        templateUrl : "modules/entidad/maestro/prmt-grid.html",
        controller : "prmtGridController",
        controllerAs : 'vm',
        reloadOnSearch : false
    })

    .when("/maestro/prmt/create/:entiId", {
        templateUrl : "modules/entidad/maestro/prmt-edit.html",
        controller : "prmtCreateController",
        controllerAs : 'vm'
    })

    .when("/maestro/prmt/detail/:entiId/:itemId", {
        templateUrl : "modules/entidad/maestro/prmt-detail.html",
        controller : "prmtDetailController",
        controllerAs : 'vm',
        reloadOnSearch : false
    })

    .when("/maestro/prmt/detail/:entiId/:itemId/:fechaVigencia", {
        templateUrl : "modules/entidad/maestro/prmt-detail.html",
        controller : "prmtDetailController",
        controllerAs : 'vm',
        reloadOnSearch : false
    })

    .when("/maestro/prmt/edit/:entiId/:itemId", {
        templateUrl : "modules/entidad/maestro/prmt-edit.html",
        controller : "prmtEditController",
        controllerAs : 'vm'
    })

    .when("/maestro/prmt/edit/:entiId/:itemId/:fechaVigencia", {
        templateUrl : "modules/entidad/maestro/prmt-edit.html",
        controller : "prmtEditController",
        controllerAs : 'vm'
    })

    .when("/maestro/prmt/duplicate/:entiId/:itemId", {
        templateUrl : "modules/entidad/maestro/prmt-edit.html",
        controller : "prmtDuplicateController",
        controllerAs : 'vm',
        reloadOnSearch : false
    })

    .when("/maestro/prmt/duplicate/:entiId/:itemId/:fechaVigencia", {
        templateUrl : "modules/entidad/maestro/prmt-edit.html",
        controller : "prmtDuplicateController",
        controllerAs : 'vm',
        reloadOnSearch : false
    })

    .when("/maestro/sprm/detail/:entiId/:itemId", {
        templateUrl : "modules/entidad/maestro/sprm-detail.html",
        controller : "sprmDetailController",
        controllerAs : 'vm'
    })

    .when("/maestro/sprm/detail/:entiId/:itemId/:fechaVigencia", {
        templateUrl : "modules/entidad/maestro/sprm-detail.html",
        controller : "sprmDetailController",
        controllerAs : 'vm'
    })

    .when("/maestro/sprm/create/:entiId/:prmtId", {
        templateUrl : "modules/entidad/maestro/sprm-edit.html",
        controller : "sprmCreateController",
        controllerAs : 'vm'
    })

    .when("/maestro/sprm/create/:entiId/:prmtId/:fechaVigencia", {
        templateUrl : "modules/entidad/maestro/sprm-edit.html",
        controller : "sprmCreateController",
        controllerAs : 'vm'
    })

    .when("/maestro/sprm/edit/:entiId/:itemId", {
        templateUrl : "modules/entidad/maestro/sprm-edit.html",
        controller : "sprmEditController",
        controllerAs : 'vm'
    })

    .when("/maestro/sprm/edit/:entiId/:itemId/:fechaVigencia", {
        templateUrl : "modules/entidad/maestro/sprm-edit.html",
        controller : "sprmEditController",
        controllerAs : 'vm'
    })

    .when("/maestro/sprm/duplicate/:entiId/:itemId", {
        templateUrl : "modules/entidad/maestro/sprm-edit.html",
        controller : "sprmDuplicateController",
        controllerAs : 'vm'
    })

    .when("/maestro/sprm/duplicate/:entiId/:itemId/:fechaVigencia", {
        templateUrl : "modules/entidad/maestro/sprm-edit.html",
        controller : "sprmDuplicateController",
        controllerAs : 'vm'
    })

    ;
}

function prmtService($http) {
    return {
        search : search
    };

    function search(entiId, itemCriterio, page, limit) {
        return $http.post("maestro/prmt-list.action?enti.id=" + entiId, {
            itemCriterio : itemCriterio,
            page : page,
            limit : itemCriterio.limit
        }).then(searchComplete);

        function searchComplete(response) {
            return response.data;
        }
    }
}

function sprmService($http) {
    return {
        search : search
    };

    function search(subentiId, prmtId, page, fechaVigencia) {
        return $http.get(
                "maestro/sprm-list.action?itemCriterio.entiId=" + subentiId + "&page=" + page
                        + "&itemCriterio.prmt.id=" + prmtId + "&itemCriterio.fechaVigencia=" + fechaVigencia).then(
                searchComplete);

        function searchComplete(response) {
            return response.data;
        }
    }
}

function maestroController($http, pageTitleService) {
    var vm = this;

    $http.get('maestro/tppr-list.action').success(function(data) {
        vm.tpprList = data.tpprList;
    });

    pageTitleService.setTitle("maestro", "page_home");
}

function prmtGridController($location, $routeParams, $modal, prmtService, pageTitleService) {
    var vm = this;

    vm.pageChanged = pageChanged;
    vm.filter = filter;

    vm.itemCriterio = $routeParams.itemCriterio ? angular.fromJson($routeParams.itemCriterio) : {};
    vm.page = $routeParams.page ? $routeParams.page : 1;

    function search() {
        prmtService.search($routeParams.entiId, vm.itemCriterio, vm.page, 20).then(function(data) {
            vm.itemList = data.itemList;
            vm.enti = data.enti;

            $location.search({
                page : vm.page,
                itemCriterio : JSON.stringify(data.itemCriterio)
            }).replace();
        });
    }

    function pageChanged() {
        search();
    }

    function filter(size) {
        var modalInstance = $modal.open({
            templateUrl : 'prmt-filter-content.html',
            controller : 'prmtFilterController',
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
            console.log("prmtGridController: " + JSON.stringify(itemCriterio));

            vm.itemCriterio = itemCriterio;
            vm.page = 1;

            search();
        });
    }

    search();
    pageTitleService.setTitleEnti($routeParams.entiId, "page_grid");
}

function prmtFilterController($http, $modalInstance, enti, itemCriterio) {
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

    $http.get("maestro/prmt-filter.action?enti.id=" + enti.id).success(function(data) {
        vm.labelValuesMap = data.labelValuesMap;
        vm.limits = data.limits;
    });
}

function prmtDetailController($http, $location, $routeParams, prmtService, sprmService, pageTitleService) {
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
            var url = "maestro/prmt-remove.action?item.prvr.id=" + vm.item.prvr.id;

            $http.get(url).success(function(data) {
                window.history.back();
            });
        }
    }

    function print() {
        $http.get('maestro/prmt-print.action?item.id=' + vm.item.id, null, {
            responseType : 'arraybuffer'
        }).success(function(data) {
            var file = new Blob([ data ], {
                type : 'application/pdf'
            });
            var fileURL = URL.createObjectURL(file);
            window.open(fileURL);
        });
    }

    vm.path = $location.path();
    vm.pageMap = {};

    vm.tabActive = {};

    if ($routeParams.tab) {
        vm.tabActive[$routeParams.tab] = true;
    }

    $http.get(
            "maestro/prmt-detail.action?item.id=" + $routeParams.itemId + "&fechaVigencia="
                    + $routeParams.fechaVigencia).success(
            function(data) {
                vm.enti = data.enti;
                vm.fechaVigencia = data.fechaVigencia;
                vm.item = data.item;
                vm.i18nMap = data.i18nMap;
                vm.itemHijosMap = {};
                vm.entiHijasMap = {};

                if (vm.enti.entiHijasList) {
                    for (i = 0; i < vm.enti.entiHijasList.length; i++) {
                        sprmService.search(vm.enti.entiHijasList[i], vm.item.id, 1, $routeParams.fechaVigencia).then(
                                function(data) {
                                    vm.entiHijasMap[data.enti.id] = data.enti;
                                    vm.itemHijosMap[data.enti.id] = data.itemList;
                                });
                    }
                }
            });

    pageTitleService.setTitleEnti($routeParams.entiId, "page_detail");
}

function prmtCreateController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        var url = "maestro/prmt-save.action";

        $http.post(url, {
            item : vm.item,
            i18nMap : vm.i18nMap,
            accion : vm.accion
        }).success(
                function(data) {
                    $location
                            .path(
                                    "/maestro/prmt/detail/" + data.item.entiId + "/" + data.item.id + "/"
                                            + data.item.prvr.fini).replace();
                });
    }

    function cancel() {
        window.history.back();
    }

    $http.get("maestro/prmt-create.action?item.entiId=" + $routeParams.entiId).success(function(data) {
        vm.enti = data.enti;
        vm.fechaVigencia = data.fechaVigencia;
        vm.item = data.item;
        vm.i18nMap = data.i18nMap;
        vm.labelValuesMap = data.labelValuesMap;
        vm.accion = data.accion;
    });

    pageTitleService.setTitleEnti($routeParams.entiId, "page_create");
}

function prmtEditController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        var url = "maestro/prmt-save.action";

        $http.post(url, {
            item : vm.item,
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

    $http.get(
            "maestro/prmt-edit.action?item.id=" + $routeParams.itemId + "&fechaVigencia=" + $routeParams.fechaVigencia)
            .success(function(data) {
                vm.enti = data.enti;
                vm.fechaVigencia = data.fechaVigencia;
                vm.item = data.item;
                vm.i18nMap = data.i18nMap;
                vm.labelValuesMap = data.labelValuesMap;
                vm.accion = data.accion;
            });

    pageTitleService.setTitleEnti($routeParams.entiId, "page_edit");
}

function prmtDuplicateController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        var url = "maestro/prmt-save.action";

        $http.post(url, {
            item : vm.item,
            i18nMap : vm.i18nMap,
            accion : vm.accion
        }).success(
                function(data) {
                    $location
                            .path(
                                    "/maestro/prmt/detail/" + data.item.entiId + "/" + data.item.id + "/"
                                            + data.item.prvr.fini).replace();
                });
    }

    function cancel() {
        window.history.back();
    }

    $http.get(
            "maestro/prmt-duplicate.action?item.id=" + $routeParams.itemId + "&fechaVigencia="
                    + $routeParams.fechaVigencia).success(function(data) {
        vm.enti = data.enti;
        vm.fechaVigencia = data.fechaVigencia;
        vm.item = data.item;
        vm.i18nMap = data.i18nMap;
        vm.labelValuesMap = data.labelValuesMap;
        vm.accion = data.accion;
    });

    pageTitleService.setTitleEnti($routeParams.entiId, "page_duplicate");
}

function prmtsLupaCtrl($http, $scope) {
    $scope.getLabelValues = function(entiId, textoBusqueda, fechaVigencia) {
        return $http.get(
                'maestro/prmt-lupa.action?itemLupaCriterio.entiId=' + entiId + "&itemLupaCriterio.textoBusqueda="
                        + textoBusqueda + "&itemLupaCriterio.fechaVigencia=" + fechaVigencia).then(function(res) {
            return res.data.itemList;
        });
    };
}

function sprmDetailController($http, $routeParams, pageTitleService) {
    var vm = this;

    vm.remove = remove;

    function remove() {
        if (confirm("Are you sure?")) {
            var url = "maestro/sprm-remove.action?item.spvr.id=" + vm.item.spvr.id;

            $http.get(url).success(function(data) {
                window.history.back();
            });
        }
    }

    $http.get(
            "maestro/sprm-detail.action?item.id=" + $routeParams.itemId + "&fechaVigencia="
                    + $routeParams.fechaVigencia).success(function(data) {
        vm.enti = data.enti;
        vm.fechaVigencia = data.fechaVigencia;
        vm.item = data.item;
    });

    pageTitleService.setTitleEnti($routeParams.entiId, "page_detail");
}

function sprmCreateController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        var url = "maestro/sprm-save.action";

        $http.post(url, {
            item : vm.item,
            accion : vm.accion
        }).success(
                function(data) {
                    $location
                            .path(
                                    "/maestro/sprm/detail/" + data.item.entiId + "/" + data.item.id + "/"
                                            + data.item.spvr.fini).replace();
                });
    }

    function cancel() {
        window.history.back();
    }

    $http.get(
            "maestro/sprm-create.action?item.entiId=" + $routeParams.entiId + "&item.prmtId=" + $routeParams.prmtId
                    + "&fechaVigencia=" + $routeParams.fechaVigencia).success(function(data) {
        vm.enti = data.enti;
        vm.fechaVigencia = data.fechaVigencia;
        vm.item = data.item;
        vm.labelValuesMap = data.labelValuesMap;
        vm.accion = data.accion;
    });

    pageTitleService.setTitleEnti($routeParams.entiId, "page_create");
}

function sprmEditController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        var url = "maestro/sprm-save.action";

        $http.post(url, {
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

    $http.get(
            "maestro/sprm-edit.action?item.id=" + $routeParams.itemId + "&fechaVigencia=" + $routeParams.fechaVigencia)
            .success(function(data) {
                vm.enti = data.enti;
                vm.fechaVigencia = data.fechaVigencia;
                vm.item = data.item;
                vm.labelValuesMap = data.labelValuesMap;
                vm.accion = data.accion;
            });

    pageTitleService.setTitleEnti($routeParams.entiId, "page_edit");
}

function sprmDuplicateController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        var url = "maestro/sprm-save.action";

        $http.post(url, {
            item : vm.item,
            accion : vm.accion
        }).success(
                function(data) {
                    $location
                            .path(
                                    "/maestro/sprm/detail/" + data.item.entiId + "/" + data.item.id + "/"
                                            + data.item.spvr.fini).replace();
                });
    }

    function cancel() {
        window.history.back();
    }

    $http.get(
            "maestro/sprm-duplicate.action?item.id=" + $routeParams.itemId + "&fechaVigencia="
                    + $routeParams.fechaVigencia).success(function(data) {
        vm.enti = data.enti;
        vm.fechaVigencia = data.fechaVigencia;
        vm.item = data.item;
        vm.labelValuesMap = data.labelValuesMap;
        vm.accion = data.accion;
    });

    pageTitleService.setTitleEnti($routeParams.entiId, "page_duplicate");
}
