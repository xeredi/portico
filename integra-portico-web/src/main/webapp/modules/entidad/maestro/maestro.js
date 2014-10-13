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

module.controller("prmtGridController",
        function($scope, $http, $location, $routeParams) {
            $scope.showFilter = false;
            $scope.itemCriterio = $routeParams.itemCriterio ? angular.fromJson($routeParams.itemCriterio) : {};
            $scope.itemCriterio.entiId = $routeParams.entiId;
            $scope.pageInfo = {};

            function search(itemCriterio, page, limit) {
                var url = "maestro/prmt-list.action";

                $scope.limit = limit;

                $http.post(url, {
                    itemCriterio : itemCriterio,
                    page : page,
                    limit : limit
                }).success(function(data) {
                    $scope.actionErrors = data.actionErrors;

                    if (data.actionErrors.length == 0) {
                        $scope.page = data.itemList.page;
                        $scope.itemList = data.itemList;
                        $scope.itemCriterio = data.itemCriterio;
                        $scope.pageInfo.limit = data.limit;

                        var map = {};

                        map["page"] = data.itemList.page;
                        map["limit"] = data.limit;
                        map["itemCriterio"] = JSON.stringify(data.itemCriterio);

                        $location.search(map).replace();

                        $scope.showFilter = false;
                    }
                });
            }

            $scope.pageChanged = function() {
                search($scope.itemCriterio, $scope.page, $scope.pageInfo.limit);
            }

            $scope.filter = function() {
                var url = "maestro/prmt-filter.action?itemCriterio.entiId=" + $routeParams.entiId;

                $http.get(url).success(function(data) {
                    $scope.actionErrors = data.actionErrors;

                    if (data.actionErrors.length == 0) {
                        $scope.labelValuesMap = data.labelValuesMap;
                        $scope.itemCriterio = data.itemCriterio;
                        $scope.limits = data.limits;
                    }
                });

                $scope.showFilter = true;
            }

            $scope.search = function() {
                search($scope.itemCriterio, 1, $scope.pageInfo.limit);
            }

            $scope.cancelSearch = function() {
                $scope.showFilter = false;
            }

            function findEnti() {
                var url = "metamodelo/tppr-proxy-detail.action?enti.id=" + $routeParams.entiId;

                $http.get(url).success(function(data) {
                    $scope.enti = data.enti;
                });
            }

            findEnti();
            search($scope.itemCriterio, $routeParams.page ? $routeParams.page : 1,
                    $routeParams.limit ? $routeParams.limit : 20);
        });

module.controller("prmtDetailController", function($scope, $http, $location, $routeParams) {
    var tabSelected = $routeParams.tabSelected;

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

    $scope.tabSelected = function(tabNo) {
        $location.search("tabSelected", tabNo).replace();
    }

    function findEnti() {
        var url = "metamodelo/tppr-proxy-detail.action?includeDependencies=true&enti.id=" + $routeParams.entiId;

        $http.get(url).success(function(data) {
            $scope.enti = data.enti;
            $scope.subentiList = data.subentiList;
            $scope.availableLanguages = data.availableLanguages;

            if (tabSelected) {
                $scope.subentiList[tabSelected].active = true;
            }
        });
    }

    function findItem() {
        var url = "maestro/prmt-detail.action?item.id=" + $routeParams.itemId + "&item.fref="
                + $routeParams.fechaVigencia;

        $http.get(url).success(function(data) {
            $scope.item = data.item;
            $scope.p18nMap = data.p18nMap;
            $scope.fechaVigencia = data.fechaVigencia;
            $scope.itemHijosMap = data.itemHijosMap;
        });
    }

    findEnti();
    findItem();
});

module.controller("prmtCreateController", function($scope, $http, $location, $routeParams) {
    $scope.save = function() {
        var url = "maestro/prmt-save.action";

        $http.post(url, {
            item : $scope.item,
            p18nMap : $scope.p18nMap,
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
            $scope.p18nMap = data.p18nMap;
            $scope.labelValuesMap = data.labelValuesMap;
            $scope.accion = data.accion;
        });
    }

    findEnti();
    findItem();
});

module.controller("prmtEditController", function($scope, $http, $location, $routeParams) {
    $location.search("tabSelected", null).replace();

    $scope.save = function() {
        var url = "maestro/prmt-save.action";

        $http.post(url, {
            item : $scope.item,
            p18nMap : $scope.p18nMap,
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
            $scope.p18nMap = data.p18nMap;
            $scope.labelValuesMap = data.labelValuesMap;
            $scope.accion = data.accion;
        });
    }

    findEnti();
    findItem();
});

module.controller("prmtDuplicateController", function($scope, $http, $location, $route, $routeParams) {
    $location.search("tabSelected", null).replace();

    $scope.save = function() {
        var url = "maestro/prmt-save.action";

        $http.post(url, {
            item : $scope.item,
            p18nMap : $scope.p18nMap,
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
            $scope.p18nMap = data.p18nMap;
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

module.controller("sprmDetailController", function($scope, $http, $location, $route, $routeParams) {
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

    function findEnti() {
        var url = "metamodelo/tpsp-proxy-detail.action?enti.id=" + $routeParams.entiId;

        $http.get(url).success(function(data) {
            $scope.enti = data.enti;
        });
    }

    function findItem() {
        var url = "maestro/sprm-detail.action?item.id=" + $routeParams.itemId + "&item.fref="
                + $routeParams.fechaVigencia;

        $http.get(url).success(function(data) {
            $scope.item = data.item;
        });
    }

    findEnti();
    findItem();
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
