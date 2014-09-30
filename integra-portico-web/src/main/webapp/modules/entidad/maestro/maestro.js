var module = angular.module("maestro", [ "ngRoute" ]);

// ----------------- MENU PRINCIPAL --------------------------
// ----------------- MENU PRINCIPAL --------------------------
// ----------------- MENU PRINCIPAL --------------------------

module.config([ "$routeProvider", function($routeProvider) {
    $routeProvider

    .when("/maestro", {
        title : 'maestro_main',
        templateUrl : "modules/entidad/maestro/maestro.html",
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
        templateUrl : "modules/entidad/maestro/prmt-grid.html",
        controller : "prmtGridController",
        reloadOnSearch : false
    })

    .when("/maestro/prmt/create/:entiId", {
        title : 'prmt_create',
        templateUrl : "modules/entidad/maestro/prmt-edit.html",
        controller : "prmtCreateController"
    })

    .when("/maestro/prmt/detail/:prvrId", {
        title : 'prmt_detail',
        templateUrl : "modules/entidad/maestro/prmt-detail.html",
        controller : "prmtDetailController"
    })

    .when("/maestro/prmt/edit/:prvrId", {
        title : 'prmt_edit',
        templateUrl : "modules/entidad/maestro/prmt-edit.html",
        controller : "prmtEditController"
    })

    .when("/maestro/prmt/duplicate/:prvrId", {
        title : 'prmt_duplicate',
        templateUrl : "modules/entidad/maestro/prmt-edit.html",
        controller : "prmtDuplicateController"
    })

    .when("/maestro/prmt/detail/:itemId/:fechaVigencia", {
        title : 'prmt_detail',
        templateUrl : "modules/entidad/maestro/prmt-detail.html",
        controller : "prmtDetailController"
    })
} ]);

module.controller("prmtGridController", function($scope, $http, $location, $route, $routeParams) {
    $scope.showFilter = false;
    $scope.itemCriterio = {};
    $scope.itemCriterio.entiId = $routeParams.entiId;

    function search(itemCriterio, page, limit) {
        var url = "maestro/prmt-list.action";

        $http.post(url, {
            itemCriterio : itemCriterio,
            page : page,
            limit : limit
        }).success(function(data) {
            if (data.actionErrors.length == 0) {
                $scope.page = data.itemList.page;
                $scope.itemList = data.itemList;
                $scope.enti = data.enti;

                var map = {};

                map["page"] = data.itemList.page;

                $location.search(map).replace();
            } else {
                $scope.actionErrors = data.actionErrors;
            }
        });
    }

    $scope.pageChanged = function() {
        search($scope.itemCriterio, $scope.page, $scope.limit);
    }

    $scope.filter = function() {
        $scope.showFilter = true;
    }

    $scope.search = function() {
        search($scope.itemCriterio, 1, $scope.limit);
    }

    $scope.cancelSearch = function() {
        $scope.showFilter = false;
    }

    search($scope.itemCriterio, $routeParams.page ? $routeParams.page : 1, $scope.limit);
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
        if (confirm("Are you sure?")) {
            var url = "maestro/prmt-remove.action?item.prvr.id=" + $scope.item.prvr.id;

            $http.get(url).success(function(data) {
                if (data.actionErrors.length == 0) {
                    window.history.back();
                } else {
                    $scope.actionErrors = data.actionErrors;
                }
            });
        }
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

module.controller("prmtDuplicateController", function($scope, $http, $location, $route, $routeParams) {
    var url = "maestro/prmt-duplicate.action?item.prvr.id=" + $routeParams.prvrId;

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

    .when("/maestro/sprm/create/:entiId/:prmtId", {
        title : 'sprm_create',
        templateUrl : "modules/entidad/maestro/sprm-edit.html",
        controller : "sprmCreateController"
    })

    .when("/maestro/sprm/detail/:spvrId", {
        title : 'sprm_detail',
        templateUrl : "modules/entidad/maestro/sprm-detail.html",
        controller : "sprmDetailController"
    })

    .when("/maestro/sprm/edit/:spvrId", {
        title : 'sprm_edit',
        templateUrl : "modules/entidad/maestro/sprm-edit.html",
        controller : "sprmEditController"
    })

    .when("/maestro/sprm/duplicate/:spvrId", {
        title : 'sprm_duplicate',
        templateUrl : "modules/entidad/maestro/sprm-edit.html",
        controller : "sprmDuplicateController"
    })

    .when("/maestro/sprm/detail/:itemId/:fechaVigencia", {
        title : 'sprm_detail',
        templateUrl : "modules/entidad/maestro/sprm-detail.html",
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
        if (confirm("Are you sure?")) {
            var url = "maestro/sprm-remove.action?item.spvr.id=" + $scope.item.spvr.id;

            $http.get(url).success(function(data) {
                if (data.actionErrors.length == 0) {
                    window.history.back();
                } else {
                    $scope.actionErrors = data.actionErrors;
                }
            });
        }
    }
});

module.controller("sprmCreateController", function($scope, $http, $location, $route, $routeParams) {
    var url = "maestro/sprm-create.action?item.entiId=" + $routeParams.entiId + "&item.prmtId=" + $routeParams.prmtId;

    $http.get(url).success(function(data) {
        $scope.item = data.item;
        $scope.enti = data.enti;
        $scope.labelValuesMap = data.labelValuesMap;
        $scope.accion = data.accion;
    });

    $scope.save = function() {
        var url = "maestro/sprm-save.action";

        $http.post(url, {
            item : $scope.item,
            accion : $scope.accion
        }).success(function(data) {
            if (data.actionErrors.length == 0) {
                $location.path("/maestro/sprm/detail/" + data.item.spvr.id).replace();
            } else {
                $scope.actionErrors = data.actionErrors;
            }
        });
    }

    $scope.cancel = function() {
        window.history.back();
    }
});

module.controller("sprmEditController", function($scope, $http, $location, $route, $routeParams) {
    var url = "maestro/sprm-edit.action?item.spvr.id=" + $routeParams.spvrId;

    $http.get(url).success(function(data) {
        $scope.item = data.item;
        $scope.enti = data.enti;
        $scope.labelValuesMap = data.labelValuesMap;
        $scope.accion = data.accion;
    });

    $scope.save = function() {
        var url = "maestro/sprm-save.action";

        $http.post(url, {
            item : $scope.item,
            accion : $scope.accion
        }).success(function(data) {
            if (data.actionErrors.length == 0) {
                $location.path("/maestro/sprm/detail/" + data.item.spvr.id).replace();
            } else {
                $scope.actionErrors = data.actionErrors;
            }
        });
    }

    $scope.cancel = function() {
        $location.path("/maestro/sprm/detail/" + $scope.item.spvr.id).replace();
    }
});

module.controller("sprmDuplicateController", function($scope, $http, $location, $route, $routeParams) {
    var url = "maestro/sprm-duplicate.action?item.spvr.id=" + $routeParams.spvrId;

    $http.get(url).success(function(data) {
        $scope.item = data.item;
        $scope.enti = data.enti;
        $scope.labelValuesMap = data.labelValuesMap;
        $scope.accion = data.accion;
    });

    $scope.save = function() {
        var url = "maestro/sprm-save.action";

        $http.post(url, {
            item : $scope.item,
            accion : $scope.accion
        }).success(function(data) {
            if (data.actionErrors.length == 0) {
                $location.path("/maestro/sprm/detail/" + data.item.spvr.id).replace();
            } else {
                $scope.actionErrors = data.actionErrors;
            }
        });
    }

    $scope.cancel = function() {
        window.history.back();
    }
});
