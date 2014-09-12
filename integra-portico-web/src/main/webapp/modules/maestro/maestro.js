var module = angular.module("maestro", [ "ngRoute" ]);

// ----------------- MENU PRINCIPAL --------------------------
// ----------------- MENU PRINCIPAL --------------------------
// ----------------- MENU PRINCIPAL --------------------------

module.config([ "$routeProvider", function($routeProvider) {
    $routeProvider

    .when("/maestro", {
        title : 'maestro_main',
        templateUrl : "modules/maestro/maestro.html",
        controller : "maestroController"
    })
} ]);

module.controller("maestroController", function($scope, $http, $location) {
    var url = "maestro/tppr-list.action";

    $http.get(url).success(function(data) {
        $scope.tpprList = data.tpprList;
    });
});

// ----------- PARAMETROS ------------------
// ----------- PARAMETROS ------------------
// ----------- PARAMETROS ------------------

module.config([ "$routeProvider", function($routeProvider) {
    $routeProvider

    .when("/maestro/prmt/grid/:entiId", {
        title : 'prmt_grid',
        templateUrl : "modules/maestro/prmt-grid.html",
        controller : "prmtGridController"
    })

    .when("/maestro/prmt/grid/:entiId/:page", {
        title : 'prmt_grid',
        templateUrl : "modules/maestro/prmt-grid.html",
        controller : "prmtGridController"
    })

    .when("/maestro/prmt/create/:entiId", {
        title : 'prmt_create',
        templateUrl : "modules/maestro/prmt-edit.html",
        controller : "prmtCreateController"
    })

    .when("/maestro/prmt/detail/:prvrId", {
        title : 'prmt_detail',
        templateUrl : "modules/maestro/prmt-detail.html",
        controller : "prmtDetailController"
    })

    .when("/maestro/prmt/edit/:prvrId", {
        title : 'prmt_edit',
        templateUrl : "modules/maestro/prmt-edit.html",
        controller : "prmtEditController"
    })

    .when("/maestro/prmt/duplicate/:prvrId", {
        title : 'prmt_duplicate',
        templateUrl : "modules/maestro/prmt-edit.html",
        controller : "prmtDuplicateController"
    })

    .when("/maestro/prmt/detail/:itemId/:fechaVigencia", {
        title : 'prmt_detail',
        templateUrl : "modules/maestro/prmt-detail.html",
        controller : "prmtDetailController"
    })
} ]);

module.controller("prmtGridController", function($scope, $http, $location, $route, $routeParams) {
    loaded = false;

    $scope.showFilter = false;
    $scope.page = $routeParams.page ? $routeParams.page : 1;
    $scope.limit = 20;
    $scope.itemCriterio = {};
    $scope.itemCriterio.entiId = $routeParams.entiId;

    var url = "maestro/prmt-list.action";

    $http.post(url, {
        itemCriterio : $scope.itemCriterio,
        limit : $scope.limit,
        page : $scope.page
    }).success(function(data) {
        $scope.itemList = data.itemList;
        $scope.enti = data.enti;
        $scope.page = data.page;
        $scope.currentPage = data.page;
        $scope.limit = data.itemList.limit;
        loaded = true;
    });

    $scope.pageChanged = function() {
        if (loaded) {
            $location.path("/maestro/prmt/grid/" + $scope.itemCriterio.entiId + "/" + $scope.currentPage).replace();
        }
    }

    $scope.filter = function() {
        $scope.showFilter = true;
    }

    $scope.search = function() {
        $location.path("/maestro/prmt/grid/" + $scope.itemCriterio.entiId).replace();
    }

    $scope.cancelSearch = function() {
        $scope.showFilter = false;
    }
});

module.controller("prmtDetailController", function($scope, $http, $location, $route, $routeParams) {
    var url = "maestro/prmt-detail.action";

    if ($routeParams.fechaVigencia) {
        $scope.fechaVigencia = $routeParams.fechaVigencia;
        url += "?item.id=" + $routeParams.itemId + "&fechaVigencia=" + $routeParams.fechaVigencia;
    } else {
        url += "?item.prvr.id=" + $routeParams.prvrId;
    }

    $http.get(url).success(function(data) {
        $scope.enti = data.enti;
        $scope.item = data.item;
        $scope.availableLanguages = data.availableLanguages;
        $scope.p18nMap = data.p18nMap;
        $scope.fechaVigencia = data.fechaVigencia;
        $scope.entiHijasList = data.entiHijasList;
        $scope.itemHijosMap = data.itemHijosMap;
    });

    $scope.edit = function() {
        $location.path("/maestro/prmt/edit/" + $scope.item.prvr.id).replace();
    }

    $scope.remove = function() {
        bootbox.confirm("Are you sure?", function(result) {
            if (result) {
                var url = "maestro/prmt-remove.action?item.prvr.id=" + $scope.item.prvr.id;

                $http.get(url).success(function(data) {
                    if (data.actionErrors.length == 0) {
                        window.history.back();
                    } else {
                        $scope.actionErrors = data.actionErrors;
                    }
                });
            }
        });
    }
});

module.controller("prmtCreateController", function($scope, $http, $location, $route, $routeParams) {
    var url = "maestro/prmt-create.action?item.entiId=" + $routeParams.entiId;

    $http.get(url).success(function(data) {
        $scope.item = data.item;
        $scope.p18nMap = data.p18nMap;
        $scope.enti = data.enti;
        $scope.availableLanguages = data.availableLanguages;
        $scope.labelValuesMap = data.labelValuesMap;
        $scope.accion = data.accion;
    });

    $scope.save = function() {
        var url = "maestro/prmt-save.action";

        $http.post(url, {
            item : $scope.item,
            p18nMap : $scope.p18nMap,
            accion : $scope.accion
        }).success(function(data) {
            if (data.actionErrors.length == 0) {
                $location.path("/maestro/prmt/detail/" + data.item.prvr.id).replace();
            } else {
                $scope.actionErrors = data.actionErrors;
            }
        });
    }

    $scope.cancel = function() {
        window.history.back();
    }
});

module.controller("prmtEditController", function($scope, $http, $location, $route, $routeParams) {
    var url = "maestro/prmt-edit.action?item.prvr.id=" + $routeParams.prvrId;

    $http.get(url).success(function(data) {
        $scope.item = data.item;
        $scope.p18nMap = data.p18nMap;
        $scope.enti = data.enti;
        $scope.availableLanguages = data.availableLanguages;
        $scope.labelValuesMap = data.labelValuesMap;
        $scope.accion = data.accion;
    });

    $scope.save = function() {
        var url = "maestro/prmt-save.action";

        $http.post(url, {
            item : $scope.item,
            p18nMap : $scope.p18nMap,
            accion : $scope.accion
        }).success(function(data) {
            if (data.actionErrors.length == 0) {
                $location.path("/maestro/prmt/detail/" + data.item.prvr.id).replace();
            } else {
                $scope.actionErrors = data.actionErrors;
            }
        });
    }

    $scope.cancel = function() {
        $location.path("/maestro/prmt/detail/" + $scope.item.prvr.id).replace();
    }
});

module.controller('prmtsLupaCtrl', function($http, $scope) {
    $scope.getLabelValues = function(entiId, textoBusqueda) {
        return $http.get(
                'maestro/prmt-lupa.action?itemLupaCriterio.entiId=' + entiId + "&itemLupaCriterio.textoBusqueda="
                        + textoBusqueda + "&itemLupaCriterio.fechaVigencia=11/12/2014").then(function(res) {
            return res.data.itemList;
        });
    };
});

// ----------- SUBPARAMETROS ------------------
// ----------- SUBPARAMETROS ------------------
// ----------- SUBPARAMETROS ------------------

module.config([ "$routeProvider", function($routeProvider) {
    $routeProvider

    .when("/maestro/sprm/create/:entiId/:prmtPadreId", {
        title : 'sprm_create',
        templateUrl : "modules/maestro/sprm-edit.html",
        controller : "sprmCreateController"
    })

    .when("/maestro/sprm/detail/:spvrId", {
        title : 'sprm_detail',
        templateUrl : "modules/maestro/sprm-detail.html",
        controller : "sprmDetailController"
    })

    .when("/maestro/sprm/edit/:spvrId", {
        title : 'sprm_edit',
        templateUrl : "modules/maestro/sprm-edit.html",
        controller : "sprmEditController"
    })

    .when("/maestro/sprm/duplicate/:spvrId", {
        title : 'sprm_duplicate',
        templateUrl : "modules/maestro/sprm-edit.html",
        controller : "sprmDuplicateController"
    })

    .when("/maestro/sprm/detail/:itemId/:fechaVigencia", {
        title : 'sprm_detail',
        templateUrl : "modules/maestro/sprm-detail.html",
        controller : "sprmDetailController"
    })
} ]);

module.controller("sprmDetailController", function($scope, $http, $location, $route, $routeParams) {
    var url = "maestro/sprm-detail.action";

    if ($routeParams.fechaVigencia) {
        $scope.fechaVigencia = $routeParams.fechaVigencia;
        url += "?item.id=" + $routeParams.itemId + "&fechaVigencia=" + $routeParams.fechaVigencia;
    } else {
        url += "?item.spvr.id=" + $routeParams.spvrId;
    }

    $http.get(url).success(function(data) {
        $scope.enti = data.enti;
        $scope.item = data.item;
    });

    $scope.edit = function() {
        $location.path("/maestro/sprm/edit/" + $scope.item.spvr.id).replace();
    }

    $scope.remove = function() {
        bootbox.confirm("Are you sure?", function(result) {
            if (result) {
                var url = "maestro/sprm-remove.action?item.spvr.id=" + $scope.item.spvr.id;

                $http.get(url).success(function(data) {
                    if (data.actionErrors.length == 0) {
                        window.history.back();
                    } else {
                        $scope.actionErrors = data.actionErrors;
                    }
                });
            }
        });
    }
});
