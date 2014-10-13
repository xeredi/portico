var module = angular.module("servicio", [ "ngRoute" ]);

// ----------------- MENU PRINCIPAL --------------------------
// ----------------- MENU PRINCIPAL --------------------------
// ----------------- MENU PRINCIPAL --------------------------

module.config([ "$routeProvider", function($routeProvider) {
    $routeProvider

    .when("/servicio", {
        title : 'servicio_main',
        templateUrl : "modules/entidad/servicio/servicio.html",
        controller : "servicioController"
    })
} ]);

module.controller("servicioController", function($scope, $http, $location) {
    var url = "servicio/tpsr-list.action";

    $http.get(url).success(function(data) {
        $scope.tpsrList = data.tpsrList;
        $scope.tpssMap = data.tpssMap;
    });
});

// ----------- SERVICIOS ------------------
// ----------- SERVICIOS ------------------
// ----------- SERVICIOS ------------------

module.config([ "$routeProvider", function($routeProvider) {
    $routeProvider

    .when("/servicio/srvc/grid/:entiId", {
        title : 'srvc_grid',
        templateUrl : "modules/entidad/servicio/srvc-grid.html",
        controller : "srvcGridController",
        reloadOnSearch : false
    })

    .when("/servicio/srvc/create/:entiId", {
        title : 'srvc_create',
        templateUrl : "modules/entidad/servicio/srvc-edit.html",
        controller : "srvcCreateController"
    })

    .when("/servicio/srvc/detail/:entiId/:srvcId", {
        title : 'srvc_detail',
        templateUrl : "modules/entidad/servicio/srvc-detail.html",
        controller : "srvcDetailController",
        reloadOnSearch : false
    })

    .when("/servicio/srvc/edit/:entiId/:srvcId", {
        title : 'srvc_edit',
        templateUrl : "modules/entidad/servicio/srvc-edit.html",
        controller : "srvcEditController"
    })

    .when("/servicio/srvc/duplicate/:entiId/:srvcId", {
        title : 'srvc_duplicate',
        templateUrl : "modules/entidad/servicio/srvc-edit.html",
        controller : "srvcDuplicateController"
    })

    .when("/servicio/srvc/maniTotales/:srvcId", {
        title : 'mani_totales',
        templateUrl : "modules/entidad/servicio/manifiesto/mani-totales.html",
        controller : "maniTotalesController"
    })
} ]);

module.controller("srvcGridController",
        function($scope, $http, $location, $routeParams) {
            $scope.showFilter = false;
            $scope.itemCriterio = $routeParams.itemCriterio ? angular.fromJson($routeParams.itemCriterio) : {};
            $scope.itemCriterio.entiId = $routeParams.entiId;
            $scope.pageInfo = {};

            function search(itemCriterio, page, limit) {
                var url = "servicio/srvc-list.action?page=" + page + "&limit=" + limit;

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
                var url = "servicio/srvc-filter.action?itemCriterio.entiId=" + $routeParams.entiId;

                $http.get(url).success(function(data) {
                    $scope.actionErrors = data.actionErrors;

                    if (data.actionErrors.length == 0) {
                        $scope.labelValuesMap = data.labelValuesMap;
                        $scope.subpList = data.subpList;
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
                var url = "metamodelo/tpsr-proxy-detail.action?enti.id=" + $routeParams.entiId;

                $http.get(url).success(function(data) {
                    $scope.enti = data.enti;
                });
            }

            findEnti();
            search($scope.itemCriterio, $routeParams.page ? $routeParams.page : 1,
                    $routeParams.limit ? $routeParams.limit : 20);
        });

module.controller("srvcDetailController", function($scope, $http, $location, $route, $routeParams) {
    var tabSelected = $routeParams.tabSelected;

    $scope.remove = function() {
        if (confirm("Are you sure?")) {
            var url = "servicio/srvc-remove.action?item.id=" + $scope.item.id;

            $http.get(url).success(function(data) {
                $scope.actionErrors = data.actionErrors;

                if (data.actionErrors.length == 0) {
                    window.history.back();
                }
            });
        }
    }

    $scope.pageChanged = function(entiId) {
        var url = "servicio/ssrv-list.action?itemCriterio.entiId=" + entiId + "&page=" + $scope.currentSubpage[entiId]
                + "&itemCriterio.srvc.id=" + $scope.item.id;

        $http.get(url).success(function(data) {
            $scope.itemHijosMap[entiId] = data.itemList;
        });
    }

    $scope.srvcAction = function(accName) {
        switch (accName) {
        // ----------- MANIFIESTO ------------------
        // ----------- MANIFIESTO ------------------
        // ----------- MANIFIESTO ------------------

        case "mani-bloquear":
            var url = "servicio/manifiesto/mani-bloquear.action?item.id=" + $scope.item.id;

            $http.get(url).success(function(data) {
                $scope.actionErrors = data.actionErrors;

                if (data.actionErrors.length == 0) {
                    findItem();
                }
            });

            break;
        case "mani-completar":
            var url = "servicio/manifiesto/mani-completar.action?item.id=" + $scope.item.id;

            $http.get(url).success(function(data) {
                $scope.actionErrors = data.actionErrors;

                if (data.actionErrors.length == 0) {
                    findItem();
                }
            });

            break;
        case "mani-iniciar":
            var url = "servicio/manifiesto/mani-iniciar.action?item.id=" + $scope.item.id;

            $http.get(url).success(function(data) {
                $scope.actionErrors = data.actionErrors;

                if (data.actionErrors.length == 0) {
                    findItem();
                }
            });

            break;
        case "mani-anular":
            var url = "servicio/manifiesto/mani-anular.action?item.id=" + $scope.item.id;

            $http.get(url).success(function(data) {
                $scope.actionErrors = data.actionErrors;

                if (data.actionErrors.length == 0) {
                    findItem();
                }
            });

            break;
        case "mani-totales":
            $location.path("/servicio/srvc/maniTotales/" + $scope.item.id);

            break;
        default:
            alert(accName);

            break;
        }
    }

    $scope.tabSelected = function(tabNo) {
        $location.search("tabSelected", tabNo).replace();
    }

    function findItem() {
        var url = "servicio/srvc-detail.action";

        url += "?item.id=" + $routeParams.srvcId;

        $http.get(url).success(function(data) {
            $scope.item = data.item;
            $scope.fechaVigencia = data.fechaVigencia;
            $scope.itemHijosMap = data.itemHijosMap;

            $scope.currentSubpage = {};

            for ( var key in $scope.itemHijosMap) {
                $scope.currentSubpage[key] = $scope.itemHijosMap[key].page;
            }
        });
    }

    function findEnti() {
        var url = "metamodelo/tpsr-proxy-detail.action?includeDependencies=true&enti.id=" + $routeParams.entiId;

        $http.get(url).success(function(data) {
            $scope.enti = data.enti;
            $scope.subentiList = data.subentiList;

            if (tabSelected) {
                $scope.subentiList[tabSelected].active = true;
            }
        });
    }

    findEnti();
    findItem();
});

module.controller("srvcCreateController", function($scope, $http, $location, $route, $routeParams) {
    $scope.save = function() {
        var url = "servicio/srvc-save.action";

        $http.post(url, {
            item : $scope.item,
            accion : $scope.accion
        }).success(function(data) {
            $scope.actionErrors = data.actionErrors;

            if (data.actionErrors.length == 0) {
                $location.path("/servicio/srvc/detail/" + data.item.entiId + "/" + data.item.id).replace();
            }
        });
    }

    $scope.cancel = function() {
        window.history.back();
    }

    function findItem() {
        var url = "servicio/srvc-create.action?item.entiId=" + $routeParams.entiId;

        $http.get(url).success(function(data) {
            $scope.accion = data.accion;
            $scope.item = data.item;
            $scope.labelValuesMap = data.labelValuesMap;
            $scope.subpList = data.subpList;
        });
    }

    function findEnti() {
        var url = "metamodelo/tpsr-proxy-detail.action?includeDependencies=true&enti.id=" + $routeParams.entiId;

        $http.get(url).success(function(data) {
            $scope.enti = data.enti;
            $scope.subentiList = data.subentiList;
        });
    }

    findEnti();
    findItem();
});

module.controller("srvcEditController", function($scope, $http, $location, $route, $routeParams) {
    $scope.save = function() {
        var url = "servicio/srvc-save.action";

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

    function findItem() {
        var url = "servicio/srvc-edit.action?item.id=" + $routeParams.srvcId;

        $http.get(url).success(function(data) {
            $scope.accion = data.accion;
            $scope.item = data.item;
            $scope.labelValuesMap = data.labelValuesMap;
        });
    }

    function findEnti() {
        var url = "metamodelo/tpsr-proxy-detail.action?includeDependencies=true&enti.id=" + $routeParams.entiId;

        $http.get(url).success(function(data) {
            $scope.enti = data.enti;
            $scope.subentiList = data.subentiList;
        });
    }

    findEnti();
    findItem();
});

module.controller("srvcDuplicateController", function($scope, $http, $location, $route, $routeParams) {
    $scope.save = function() {
        var url = "servicio/srvc-save.action";

        $http.post(url, {
            item : $scope.item,
            accion : $scope.accion
        }).success(function(data) {
            $scope.actionErrors = data.actionErrors;

            if (data.actionErrors.length == 0) {
                $location.path("/servicio/srvc/detail/" + data.item.entiId + "/" + data.item.id).replace();
            }
        });
    }

    $scope.cancel = function() {
        window.history.back();
    }

    function findItem() {
        var url = "servicio/srvc-duplicate.action?item.id=" + $routeParams.srvcId;

        $http.get(url).success(function(data) {
            $scope.accion = data.accion;
            $scope.item = data.item;
            $scope.labelValuesMap = data.labelValuesMap;
            $scope.subpList = data.subpList;
        });
    }

    function findEnti() {
        var url = "metamodelo/tpsr-proxy-detail.action?includeDependencies=true&enti.id=" + $routeParams.entiId;

        $http.get(url).success(function(data) {
            $scope.enti = data.enti;
            $scope.subentiList = data.subentiList;
        });
    }

    findEnti();
    findItem();
});

module.controller('srvcLupaCtrl', function($http, $scope) {
    $scope.getLabelValues = function(entiId, textoBusqueda) {
        return $http.get(
                'servicio/srvc-lupa.action?itemLupaCriterio.entiId=' + entiId + "&itemLupaCriterio.textoBusqueda="
                        + textoBusqueda + "&itemLupaCriterio.fechaVigencia=11/12/2014").then(function(res) {
            return res.data.itemList;
        });
    };
});

module.controller("maniTotalesController", function($scope, $http, $location, $route, $routeParams) {
    var url = "servicio/manifiesto/mani-totales.action?item.id=" + $routeParams.srvcId;

    $http.get(url).success(function(data) {
        $scope.item = data.item;
        $scope.resumen = data.resumen;
    });
});

// ----------- SUBSERVICIOS ------------------
// ----------- SUBSERVICIOS ------------------
// ----------- SUBSERVICIOS ------------------

module.config([ "$routeProvider", function($routeProvider) {
    $routeProvider

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
} ]);

module.controller("ssrvGridController",
        function($scope, $http, $location, $routeParams) {
            $scope.showFilter = false;
            $scope.itemCriterio = $routeParams.itemCriterio ? angular.fromJson($routeParams.itemCriterio) : {};
            $scope.itemCriterio.entiId = $routeParams.entiId;
            $scope.pageInfo = {};

            function search(itemCriterio, page, limit) {
                var url = "servicio/ssrv-list.action?page=" + page + "&limit=" + limit;

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
                var url = "servicio/ssrv-filter.action?itemCriterio.entiId=" + $routeParams.entiId;

                $http.get(url).success(function(data) {
                    $scope.actionErrors = data.actionErrors;

                    if (data.actionErrors.length == 0) {
                        $scope.labelValuesMap = data.labelValuesMap;
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
                var url = "metamodelo/tpss-proxy-detail.action?enti.id=" + $routeParams.entiId;

                $http.get(url).success(function(data) {
                    $scope.enti = data.enti;
                });
            }

            findEnti();
            search($scope.itemCriterio, $routeParams.page ? $routeParams.page : 1,
                    $routeParams.limit ? $routeParams.limit : 20);
        });

module.controller("ssrvDetailController", function($scope, $http, $location, $route, $routeParams) {
    var tabSelected = $routeParams.tabSelected;

    $scope.remove = function() {
        if (confirm("Are you sure?")) {
            var url = "servicio/ssrv-remove.action?item.id=" + $scope.item.id;

            $http.get(url).success(function(data) {
                $scope.actionErrors = data.actionErrors;

                if (data.actionErrors.length == 0) {
                    window.history.back();
                }
            });
        }
    }

    $scope.ssrvAction = function(accName) {
        switch (accName) {
        // ----------- BL ------------------
        // ----------- BL ------------------
        // ----------- BL ------------------

        case "mabl-bloquear":
            var url = "servicio/manifiesto/mabl-bloquear.action?item.id=" + $scope.item.id;

            $http.get(url).success(function(data) {
                $scope.actionErrors = data.actionErrors;

                if (data.actionErrors.length == 0) {
                    findItem();
                }
            });

            break;
        case "mabl-completar":
            var url = "servicio/manifiesto/mabl-completar.action?item.id=" + $scope.item.id;

            $http.get(url).success(function(data) {
                $scope.actionErrors = data.actionErrors;

                if (data.actionErrors.length == 0) {
                    findItem();
                }
            });

            break;
        case "mabl-iniciar":
            var url = "servicio/manifiesto/mabl-iniciar.action?item.id=" + $scope.item.id;

            $http.get(url).success(function(data) {
                $scope.actionErrors = data.actionErrors;

                if (data.actionErrors.length == 0) {
                    findItem();
                }
            });

            break;
        case "mabl-anular":
            var url = "servicio/manifiesto/mabl-anular.action?item.id=" + $scope.item.id;

            $http.get(url).success(function(data) {
                $scope.actionErrors = data.actionErrors;

                if (data.actionErrors.length == 0) {
                    findItem();
                }
            });

            break;
        case "mabl-totales":
            $location.path("/servicio/ssrv/mablTotales/" + $scope.item.srvc.id + "/" + $scope.item.id);

            break;

        // ----------- EQUIPAMIENTO ------------------
        // ----------- EQUIPAMIENTO ------------------
        // ----------- EQUIPAMIENTO ------------------

        case "equi-bloquear":
            var url = "servicio/manifiesto/mabl-bloquear.action?item.id=" + $scope.item.id;

            $http.get(url).success(function(data) {
                $scope.actionErrors = data.actionErrors;

                if (data.actionErrors.length == 0) {
                    findItem();
                }
            });

            break;
        case "equi-iniciar":
            var url = "servicio/manifiesto/mabl-iniciar.action?item.id=" + $scope.item.id;

            $http.get(url).success(function(data) {
                $scope.actionErrors = data.actionErrors;

                if (data.actionErrors.length == 0) {
                    findItem();
                }
            });

            break;
        case "equi-anular":
            var url = "servicio/manifiesto/mabl-anular.action?item.id=" + $scope.item.id;

            $http.get(url).success(function(data) {
                $scope.actionErrors = data.actionErrors;

                if (data.actionErrors.length == 0) {
                    findItem();
                }
            });

            break;

        // ----------- PARTIDA ------------------
        // ----------- PARTIDA ------------------
        // ----------- PARTIDA ------------------

        case "part-bloquear":
            var url = "servicio/manifiesto/mabl-bloquear.action?item.id=" + $scope.item.id;

            $http.get(url).success(function(data) {
                $scope.actionErrors = data.actionErrors;

                if (data.actionErrors.length == 0) {
                    findItem();
                }
            });

            break;
        case "part-iniciar":
            var url = "servicio/manifiesto/mabl-iniciar.action?item.id=" + $scope.item.id;

            $http.get(url).success(function(data) {
                $scope.actionErrors = data.actionErrors;

                if (data.actionErrors.length == 0) {
                    findItem();
                }
            });

            break;
        case "part-anular":
            var url = "servicio/manifiesto/mabl-anular.action?item.id=" + $scope.item.id;

            $http.get(url).success(function(data) {
                $scope.actionErrors = data.actionErrors;

                if (data.actionErrors.length == 0) {
                    findItem();
                }
            });

            break;
        default:
            alert(accName);

            break;
        }
    }

    $scope.tabSelected = function(tabNo) {
        $location.search("tabSelected", tabNo).replace();
    }

    function findItem() {
        var url = "servicio/ssrv-detail.action";

        url += "?item.id=" + $routeParams.ssrvId;

        $http.get(url).success(function(data) {
            $scope.item = data.item;
            $scope.itemHijosMap = data.itemHijosMap;
        });
    }

    function findEnti() {
        var url = "metamodelo/tpss-proxy-detail.action?includeDependencies=true&enti.id=" + $routeParams.entiId;

        $http.get(url).success(function(data) {
            $scope.enti = data.enti;
            $scope.subentiList = data.subentiList;

            if (tabSelected) {
                $scope.subentiList[tabSelected].active = true;
            }
        });
    }

    findEnti();
    findItem();
});

module.controller("ssrvCreateController", function($scope, $http, $location, $route, $routeParams) {
    $scope.save = function() {
        var url = "servicio/ssrv-save.action";

        $http.post(url, {
            item : $scope.item,
            accion : $scope.accion
        }).success(function(data) {
            $scope.actionErrors = data.actionErrors;

            if (data.actionErrors.length == 0) {
                $location.path("/servicio/ssrv/detail/" + data.item.id).replace();
            }
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
});

module.controller("ssrvEditController", function($scope, $http, $location, $route, $routeParams) {
    $scope.save = function() {
        var url = "servicio/ssrv-save.action";

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
});

module.controller("ssrvDuplicateController", function($scope, $http, $location, $route, $routeParams) {
    $scope.save = function() {
        var url = "servicio/ssrv-save.action";

        $http.post(url, {
            item : $scope.item,
            accion : $scope.accion
        }).success(function(data) {
            $scope.actionErrors = data.actionErrors;

            if (data.actionErrors.length == 0) {
                $location.path("/servicio/ssrv/detail/" + data.item.entiId + "/" + data.item.id).replace();
            }
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
});

module.controller('ssrvLupaCtrl', function($http, $scope) {
    $scope.getLabelValues = function(entiId, srvcId, numero) {
        return $http.get(
                'servicio/ssrv-lupa.action?itemLupaCriterio.entiId=' + entiId + "&itemLupaCriterio.srvcId=" + srvcId
                        + "&itemLupaCriterio.numero=" + numero + "&itemLupaCriterio.fechaVigencia=11/12/2014").then(
                function(res) {
                    return res.data.itemList;
                });
    };
});

module.controller("mablTotalesController", function($scope, $http, $location, $route, $routeParams) {
    var url = "servicio/manifiesto/mabl-totales.action?item.id=" + $routeParams.ssrvId + "&item.srvc.id="
            + $routeParams.srvcId;

    $http.get(url).success(function(data) {
        $scope.item = data.item;
        $scope.resumen = data.resumen;
    });
});
