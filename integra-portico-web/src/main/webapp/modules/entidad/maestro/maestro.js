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

module.controller("maestroController", function($scope, $http) {
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

    .when("/maestro/prmt/detail/:entiId/:itemId/:fechaVigencia", {
        title : 'prmt_detail',
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
} ]);

module.controller("prmtGridController", function($scope, $http, $location, $routeParams, $modal) {
    $scope.itemCriterio = $routeParams.itemCriterio ? angular.fromJson($routeParams.itemCriterio) : {};
    $scope.itemCriterio.entiId = $routeParams.entiId;

    function search(itemCriterio, page) {
        $scope.loading = true;

        $http.post("maestro/prmt-list.action", {
            itemCriterio : itemCriterio,
            page : page,
            limit : itemCriterio.limit
        }).success(function(data) {
            $scope.actionErrors = data.actionErrors;

            if (data.actionErrors.length == 0) {
                $scope.page = data.itemList.page;
                $scope.itemList = data.itemList;
                $scope.itemCriterio = data.itemCriterio;

                var map = {};

                map["page"] = data.itemList.page;
                map["itemCriterio"] = JSON.stringify(data.itemCriterio);

                $location.search(map).replace();
            }

            $scope.loading = false;
        });
    }

    $scope.pageChanged = function() {
        search($scope.itemCriterio, $scope.page);
    }

    $scope.filter = function(size) {
        var modalInstance = $modal.open({
            templateUrl : 'prmt-filter-content.html',
            controller : 'prmtFilterController',
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
            console.log("prmtGridController: " + JSON.stringify(itemCriterio));

            $scope.itemCriterio = itemCriterio;

            search($scope.itemCriterio, 1);
        });
    }

    function findEnti() {
        var url = "metamodelo/tppr-proxy-detail.action?enti.id=" + $routeParams.entiId;

        $http.get(url).success(function(data) {
            $scope.enti = data.enti;
        });
    }

    findEnti();
    search($scope.itemCriterio, $routeParams.page ? $routeParams.page : 1);
});

module.controller("prmtFilterController", function($scope, $http, $modalInstance, enti, itemCriterio) {
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
});

module.controller("prmtDetailController", function($scope, $http, $location, $routeParams) {
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
});

module.controller("prmtCreateController", function($scope, $http, $location, $routeParams) {
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
});

module.controller("prmtEditController", function($scope, $http, $location, $routeParams) {
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
});

module.controller("prmtDuplicateController", function($scope, $http, $location, $route, $routeParams) {
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
});

module.controller('prmtsLupaCtrl', function($http, $scope) {
    $scope.getLabelValues = function(entiId, textoBusqueda, fechaVigencia) {
        return $http.get(
                'maestro/prmt-lupa.action?itemLupaCriterio.entiId=' + entiId + "&itemLupaCriterio.textoBusqueda="
                        + textoBusqueda + "&itemLupaCriterio.fechaVigencia=" + fechaVigencia).then(function(res) {
            return res.data.itemList;
        });
    };
});

// ----------- SUBPARAMETROS ------------------
// ----------- SUBPARAMETROS ------------------
// ----------- SUBPARAMETROS ------------------

module.config([ "$routeProvider", function($routeProvider) {
    $routeProvider

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
} ]);

module.controller("sprmDetailController", function($scope, $http, $routeParams) {
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
});

module.controller("sprmCreateController", function($scope, $http, $location, $route, $routeParams) {
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
});

module.controller("sprmEditController", function($scope, $http, $location, $route, $routeParams) {
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
});

module.controller("sprmDuplicateController", function($scope, $http, $location, $route, $routeParams) {
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
});
