angular.module("maestro", [ "ngRoute" ])

.config(config)

.factory('tpprService', tpprService)

.factory('prmtService', prmtService)

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
        title : 'maestro_main',
        templateUrl : "modules/entidad/maestro/maestro.html",
        controller : "maestroController",
        controllerAs : 'vm'
    })

    .when("/maestro/prmt/grid/:entiId", {
        title : 'prmtList',
        templateUrl : "modules/entidad/maestro/prmt-grid.html",
        controller : "prmtGridController",
        controllerAs : 'vm',
        reloadOnSearch : false
    })

    .when("/maestro/prmt/create/:entiId", {
        title : 'prmt_create',
        templateUrl : "modules/entidad/maestro/prmt-edit.html",
        controller : "prmtCreateController"
    })

    .when("/maestro/prmt/detail/:entiId/:itemId/:fechaVigencia", {
        title : 'prmt',
        templateUrl : "modules/entidad/maestro/prmt-detail.html",
        controller : "prmtDetailController",
        reloadOnSearch : false
    })

    .when("/maestro/prmt/edit/:entiId/:itemId/:fechaVigencia", {
        title : 'prmt_edit',
        templateUrl : "modules/entidad/maestro/prmt-edit.html",
        controller : "prmtEditController"
    })

    .when("/maestro/prmt/duplicate/:entiId/:itemId/:fechaVigencia", {
        title : 'prmt_duplicate',
        templateUrl : "modules/entidad/maestro/prmt-edit.html",
        controller : "prmtDuplicateController",
        reloadOnSearch : false
    })

    .when("/maestro/sprm/create/:entiId/:prmtId/:fechaVigencia", {
        title : 'sprm_create',
        templateUrl : "modules/entidad/maestro/sprm-edit.html",
        controller : "sprmCreateController"
    })

    .when("/maestro/sprm/edit/:entiId/:itemId/:fechaVigencia", {
        title : 'sprm_edit',
        templateUrl : "modules/entidad/maestro/sprm-edit.html",
        controller : "sprmEditController"
    })

    .when("/maestro/sprm/duplicate/:entiId/:itemId/:fechaVigencia", {
        title : 'sprm_duplicate',
        templateUrl : "modules/entidad/maestro/sprm-edit.html",
        controller : "sprmDuplicateController"
    })

    .when("/maestro/sprm/detail/:entiId/:itemId/:fechaVigencia", {
        title : 'sprm_detail',
        templateUrl : "modules/entidad/maestro/sprm-detail.html",
        controller : "sprmDetailController"
    })
}

function tpprService($http) {
    return {
        getTpprList : getTpprList,
        getTppr : getTppr
    };

    function getTpprList() {
        return $http.get('maestro/tppr-list.action').then(getTpprListComplete);

        function getTpprListComplete(response) {
            return response.data.tpprList;
        }
    }

    function getTppr(entiId) {
        return $http.get('metamodelo/tppr-proxy-detail.action?enti.id=' + entiId).then(getTpprComplete);

        function getTpprComplete(response) {
            return response.data.enti;
        }
    }
}

function prmtService($http) {
    return {
        search : search
    };

    function search(entiId, itemCriterio, page, limit) {
        return $http.post("maestro/prmt-list.action", {
            entiId : entiId,
            itemCriterio : itemCriterio,
            page : page,
            limit : itemCriterio.limit
        }).then(searchComplete);

        function searchComplete(response) {
            return response.data;
        }
    }
}

function maestroController(tpprService) {
    var vm = this;

    vm.tpprList = [];

    getTpprList();

    function getTpprList() {
        return tpprService.getTpprList().then(function(data) {
            vm.tpprList = data;
            return vm.tpprList;
        });
    }
}

function prmtGridController($http, $location, $routeParams, $modal, tpprService, prmtService) {
    var vm = this;

    vm.pageChanged = pageChanged;
    vm.filter = filter;

    vm.itemCriterio = $routeParams.itemCriterio ? angular.fromJson($routeParams.itemCriterio) : {};
    vm.itemCriterio.entiId = $routeParams.entiId;

    function search(itemCriterio, page) {
        vm.loading = true;

        $http.post("maestro/prmt-list.action", {
            entiId : itemCriterio.entiId,
            itemCriterio : itemCriterio,
            page : page,
            limit : itemCriterio.limit
        }).success(function(data) {
            vm.actionErrors = data.actionErrors;

            if (data.actionErrors.length == 0) {
                vm.page = data.itemList.page;
                vm.itemList = data.itemList;
                vm.itemCriterio = data.itemCriterio;

                var map = {};

                map["page"] = data.itemList.page;
                map["itemCriterio"] = JSON.stringify(data.itemCriterio);

                $location.search(map).replace();
            }

            vm.loading = false;
        });
    }

    function pageChanged() {
        search(vm.itemCriterio, vm.page);
    }

    function filter(size) {
        var modalInstance = $modal.open({
            templateUrl : 'prmt-filter-content.html',
            controller : 'prmtFilterController',
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

            search(vm.itemCriterio, 1);
        });
    }

    function findEnti() {
        return tpprService.getTppr($routeParams.entiId).then(function(data) {
            vm.enti = data;
            return vm.enti;
        });
    }

    findEnti();
    search(vm.itemCriterio, $routeParams.page ? $routeParams.page : 1);
}

function prmtFilterController($scope, $http, $modalInstance, enti, itemCriterio) {
    console.log("prmtFilterController: " + JSON.stringify(itemCriterio));

    $scope.itemCriterio = itemCriterio;
    $scope.enti = enti;

    $scope.ok = function() {
        $modalInstance.close($scope.itemCriterio);
    };

    $scope.cancel = function() {
        $modalInstance.dismiss('cancel');
    };

    $http.get("maestro/prmt-filter.action?itemCriterio.entiId=" + itemCriterio.entiId).success(function(data) {
        $scope.actionErrors = data.actionErrors;

        if (data.actionErrors.length == 0) {
            $scope.labelValuesMap = data.labelValuesMap;
            $scope.limits = data.limits;
            $scope.fechaVigencia = data.fechaVigencia;
        }
    });
}

function prmtDetailController($scope, $http, $location, $routeParams) {
    var path = $location.path();
    var tabSelected = $routeParams.tabSelected;
    var itemId = $routeParams.itemId;
    var entiId = $routeParams.entiId;
    var fechaVigencia = $routeParams.fechaVigencia;
    var pageMap = $routeParams.pageMap ? angular.fromJson($routeParams.pageMap) : {};

    $scope.pageMap = {};

    function findItem() {
        $http.get("metamodelo/tppr-proxy-detail.action?includeDependencies=true&enti.id=" + entiId).success(
                function(data) {
                    $scope.enti = data.enti;
                    $scope.subentiList = data.subentiList;
                    $scope.availableLanguages = data.availableLanguages;

                    if (tabSelected) {
                        $scope.subentiList[tabSelected].active = true;
                    }

                    $http.get("maestro/prmt-detail.action?item.id=" + itemId + "&item.fref=" + fechaVigencia).success(
                            function(data) {
                                $scope.item = data.item;
                                $scope.i18nMap = data.i18nMap;
                                $scope.fechaVigencia = data.fechaVigencia;
                            });

                    $scope.itemHijosMap = {};

                    for (i = 0; i < $scope.subentiList.length; i++) {
                        var subenti = $scope.subentiList[i];

                        findSublist(subenti.id, pageMap[subenti.id] ? pageMap[subenti.id] : 1);
                    }
                });
    }

    function findSublist(subentiId, page) {
        var url = "maestro/sprm-list.action?itemCriterio.entiId=" + subentiId + "&page=" + page
                + "&itemCriterio.prmt.id=" + itemId + "&itemCriterio.fechaVigencia=" + fechaVigencia;

        $http.get(url).success(function(data) {
            $scope.actionErrors = data.actionErrors;

            if (data.actionErrors.length == 0) {
                $scope.itemHijosMap[data.itemCriterio.entiId] = data.itemList;
                $scope.pageMap[data.itemCriterio.entiId] = data.itemList.page;
                $location.search("pageMap", JSON.stringify($scope.pageMap)).replace();
            }
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
            var url = "maestro/prmt-remove.action?item.prvr.id=" + $scope.item.prvr.id;

            $http.get(url).success(function(data) {
                $scope.actionErrors = data.actionErrors;

                if (data.actionErrors.length == 0) {
                    window.history.back();
                }
            });
        }
    }

    $scope.print = function() {
        $http.get('maestro/prmt-print.action?item.id=' + $scope.item.id, null, {
            responseType : 'arraybuffer'
        }).success(function(data) {
            var file = new Blob([ data ], {
                type : 'application/pdf'
            });
            var fileURL = URL.createObjectURL(file);
            window.open(fileURL);
        });
    }

    findItem();
}

function prmtCreateController($scope, $http, $location, $routeParams) {
    $scope.save = function() {
        var url = "maestro/prmt-save.action";

        $http.post(url, {
            item : $scope.item,
            i18nMap : $scope.i18nMap,
            accion : $scope.accion
        }).success(
                function(data) {
                    $scope.actionErrors = data.actionErrors;

                    if (data.actionErrors.length == 0) {
                        $location.path(
                                "/maestro/prmt/detail/" + data.item.entiId + "/" + data.item.id + "/"
                                        + data.item.prvr.fini).replace();
                    }
                });
    }

    $scope.cancel = function() {
        window.history.back();
    }

    function findEnti() {
        var url = "metamodelo/tppr-proxy-detail.action?enti.id=" + $routeParams.entiId;

        $http.get(url).success(function(data) {
            $scope.enti = data.enti;
            $scope.availableLanguages = data.availableLanguages;
        });
    }

    function findItem() {
        var url = "maestro/prmt-create.action?item.entiId=" + $routeParams.entiId;

        $http.get(url).success(function(data) {
            $scope.item = data.item;
            $scope.i18nMap = data.i18nMap;
            $scope.labelValuesMap = data.labelValuesMap;
            $scope.accion = data.accion;
        });
    }

    findEnti();
    findItem();
}

function prmtEditController($scope, $http, $location, $routeParams) {
    $scope.save = function() {
        var url = "maestro/prmt-save.action";

        $http.post(url, {
            item : $scope.item,
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

    function findEnti() {
        var url = "metamodelo/tppr-proxy-detail.action?enti.id=" + $routeParams.entiId;

        $http.get(url).success(function(data) {
            $scope.enti = data.enti;
            $scope.availableLanguages = data.availableLanguages;
        });
    }

    function findItem() {
        var url = "maestro/prmt-edit.action?item.id=" + $routeParams.itemId + "&item.fref="
                + $routeParams.fechaVigencia;

        $http.get(url).success(function(data) {
            $scope.item = data.item;
            $scope.i18nMap = data.i18nMap;
            $scope.labelValuesMap = data.labelValuesMap;
            $scope.accion = data.accion;
        });
    }

    findEnti();
    findItem();
}

function prmtDuplicateController($scope, $http, $location, $routeParams) {
    $scope.save = function() {
        var url = "maestro/prmt-save.action";

        $http.post(url, {
            item : $scope.item,
            i18nMap : $scope.i18nMap,
            accion : $scope.accion
        }).success(
                function(data) {
                    $scope.actionErrors = data.actionErrors;

                    if (data.actionErrors.length == 0) {
                        $location.path(
                                "/maestro/prmt/detail/" + data.item.entiId + "/" + data.item.id + "/"
                                        + data.item.prvr.fini).replace();
                    }
                });
    }

    $scope.cancel = function() {
        window.history.back();
    }

    function findEnti() {
        var url = "metamodelo/tppr-proxy-detail.action?enti.id=" + $routeParams.entiId;

        $http.get(url).success(function(data) {
            $scope.enti = data.enti;
            $scope.availableLanguages = data.availableLanguages;
        });
    }

    function findItem() {
        var url = "maestro/prmt-duplicate.action?item.id=" + $routeParams.itemId + "&item.fref="
                + $routeParams.fechaVigencia;

        $http.get(url).success(function(data) {
            $scope.item = data.item;
            $scope.i18nMap = data.i18nMap;
            $scope.labelValuesMap = data.labelValuesMap;
            $scope.accion = data.accion;
        });
    }

    findEnti();
    findItem();
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

function sprmDetailController($scope, $http, $routeParams) {
    console.log("sprmDetailController: " + JSON.stringify($routeParams));

    $scope.remove = function() {
        if (confirm("Are you sure?")) {
            var url = "maestro/sprm-remove.action?item.spvr.id=" + $scope.item.spvr.id;

            $http.get(url).success(function(data) {
                $scope.actionErrors = data.actionErrors;

                if (data.actionErrors.length == 0) {
                    window.history.back();
                }
            });
        }
    }

    $http.get("metamodelo/tpsp-proxy-detail.action?enti.id=" + $routeParams.entiId).success(function(data) {
        $scope.enti = data.enti;
    });

    $http.get("maestro/sprm-detail.action?item.id=" + $routeParams.itemId + "&item.fref=" + $routeParams.fechaVigencia)
            .success(function(data) {
                $scope.item = data.item;
            });
}

function sprmCreateController($scope, $http, $location, $routeParams) {
    $scope.save = function() {
        var url = "maestro/sprm-save.action";

        $http.post(url, {
            item : $scope.item,
            accion : $scope.accion
        }).success(
                function(data) {
                    $scope.actionErrors = data.actionErrors;

                    if (data.actionErrors.length == 0) {
                        $location.path(
                                "/maestro/sprm/detail/" + data.item.entiId + "/" + data.item.id + "/"
                                        + data.item.spvr.fini).replace();
                    }
                });
    }

    $scope.cancel = function() {
        window.history.back();
    }

    function findEnti() {
        var url = "metamodelo/tpsp-proxy-detail.action?enti.id=" + $routeParams.entiId;

        $http.get(url).success(function(data) {
            $scope.enti = data.enti;
        });
    }

    function findItem() {
        var url = "maestro/sprm-create.action?item.entiId=" + $routeParams.entiId + "&item.prmtId="
                + $routeParams.prmtId + "&item.fref=" + $routeParams.fechaVigencia;

        $http.get(url).success(function(data) {
            $scope.item = data.item;
            $scope.labelValuesMap = data.labelValuesMap;
            $scope.accion = data.accion;
        });
    }

    findEnti();
    findItem();
}

function sprmEditController($scope, $http, $location, $routeParams) {
    $scope.save = function() {
        var url = "maestro/sprm-save.action";

        $http.post(url, {
            item : $scope.item,
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

    function findEnti() {
        var url = "metamodelo/tpsp-proxy-detail.action?enti.id=" + $routeParams.entiId;

        $http.get(url).success(function(data) {
            $scope.enti = data.enti;
        });
    }

    function findItem() {
        var url = "maestro/sprm-edit.action?item.id=" + $routeParams.itemId + "&item.fref="
                + $routeParams.fechaVigencia;

        $http.get(url).success(function(data) {
            $scope.item = data.item;
            $scope.labelValuesMap = data.labelValuesMap;
            $scope.accion = data.accion;
        });
    }

    findEnti();
    findItem();
}

function sprmDuplicateController($scope, $http, $location, $routeParams) {
    $scope.save = function() {
        var url = "maestro/sprm-save.action";

        $http.post(url, {
            item : $scope.item,
            accion : $scope.accion
        }).success(
                function(data) {
                    $scope.actionErrors = data.actionErrors;

                    if (data.actionErrors.length == 0) {
                        $location.path(
                                "/maestro/sprm/detail/" + data.item.entiId + "/" + data.item.id + "/"
                                        + data.item.spvr.fini).replace();
                    }
                });
    }

    $scope.cancel = function() {
        window.history.back();
    }

    function findEnti() {
        var url = "metamodelo/tpsp-proxy-detail.action?enti.id=" + $routeParams.entiId;

        $http.get(url).success(function(data) {
            $scope.enti = data.enti;
        });
    }

    function findItem() {
        var url = "maestro/sprm-duplicate.action?item.id=" + $routeParams.itemId + "&item.fref="
                + $routeParams.fechaVigencia;

        $http.get(url).success(function(data) {
            $scope.item = data.item;
            $scope.labelValuesMap = data.labelValuesMap;
            $scope.accion = data.accion;
        });
    }

    findEnti();
    findItem();
}
