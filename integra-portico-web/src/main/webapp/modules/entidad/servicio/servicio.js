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
        controller : "srvcGridController"
    })

    .when("/servicio/srvc/create/:entiId", {
        title : 'srvc_create',
        templateUrl : "modules/entidad/servicio/srvc-edit.html",
        controller : "srvcCreateController"
    })

    .when("/servicio/srvc/detail/:srvcId", {
        title : 'srvc_detail',
        templateUrl : "modules/entidad/servicio/srvc-detail.html",
        controller : "srvcDetailController"
    })

    .when("/servicio/srvc/edit/:srvcId", {
        title : 'srvc_edit',
        templateUrl : "modules/entidad/servicio/srvc-edit.html",
        controller : "srvcEditController"
    })

    .when("/servicio/srvc/duplicate/:srvcId", {
        title : 'srvc_duplicate',
        templateUrl : "modules/entidad/servicio/srvc-edit.html",
        controller : "srvcDuplicateController"
    })
} ]);

module.controller("srvcGridController", function($scope, $http, $location, $route, $routeParams) {
    loaded = false;

    $scope.showFilter = false;
    $scope.page = $routeParams.page ? $routeParams.page : 1;
    $scope.limit = 20;
    $scope.itemCriterio = {};
    $scope.itemCriterio.entiId = $routeParams.entiId;

    var url = "servicio/srvc-list.action";

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
            $location.search({
                page : $scope.currentPage
            }).replace();
        }
    }

    $scope.filter = function() {
        $scope.showFilter = true;
    }

    $scope.search = function() {
        $location.path("/servicio/srvc/grid/" + $scope.itemCriterio.entiId).replace();
    }

    $scope.cancelSearch = function() {
        $scope.showFilter = false;
    }
});

module.controller("srvcDetailController", function($scope, $http, $location, $route, $routeParams) {
    var url = "servicio/srvc-detail.action";

    url += "?item.id=" + $routeParams.srvcId;

    $http.get(url).success(function(data) {
        $scope.enti = data.enti;
        $scope.item = data.item;
        $scope.fechaVigencia = data.fechaVigencia;
        $scope.entiHijasList = data.entiHijasList;
        $scope.itemHijosMap = data.itemHijosMap;

        $scope.currentSubpage = {};

        for (var key in $scope.itemHijosMap) {
            $scope.currentSubpage[key] = $scope.itemHijosMap[key].page;
        }
    });

    $scope.edit = function() {
        $location.path("/servicio/srvc/edit/" + $scope.item.id).replace();
    }

    $scope.remove = function() {
        if (confirm("Are you sure?")) {
            var url = "servicio/srvc-remove.action?item.id=" + $scope.item.id;

            $http.get(url).success(function(data) {
                if (data.actionErrors.length == 0) {
                    window.history.back();
                } else {
                    $scope.actionErrors = data.actionErrors;
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
                if (data.actionErrors.length == 0) {
                    $route.reload();
                } else {
                    $scope.actionErrors = data.actionErrors;
                }
            });

            break;
        case "mani-completar":
            var url = "servicio/manifiesto/mani-completar.action?item.id=" + $scope.item.id;

            $http.get(url).success(function(data) {
                if (data.actionErrors.length == 0) {
                    $route.reload();
                } else {
                    $scope.actionErrors = data.actionErrors;
                }
            });

            break;
        case "mani-iniciar":
            var url = "servicio/manifiesto/mani-iniciar.action?item.id=" + $scope.item.id;

            $http.get(url).success(function(data) {
                if (data.actionErrors.length == 0) {
                    $route.reload();
                } else {
                    $scope.actionErrors = data.actionErrors;
                }
            });

            break;
        case "mani-anular":
            var url = "servicio/manifiesto/mani-anular.action?item.id=" + $scope.item.id;

            $http.get(url).success(function(data) {
                if (data.actionErrors.length == 0) {
                    $route.reload();
                } else {
                    $scope.actionErrors = data.actionErrors;
                }
            });

            break;
        default:
            alert(accName);

            break;
        }
    }
});

module.controller("srvcCreateController", function($scope, $http, $location, $route, $routeParams) {
    var url = "servicio/srvc-create.action?item.entiId=" + $routeParams.entiId;

    $http.get(url).success(function(data) {
        $scope.accion = data.accion;
        $scope.item = data.item;
        $scope.enti = data.enti;
        $scope.labelValuesMap = data.labelValuesMap;
        $scope.subpList = data.subpList;
    });

    $scope.save = function() {
        var url = "servicio/srvc-save.action";

        $http.post(url, {
            item : $scope.item,
            accion : $scope.accion
        }).success(function(data) {
            if (data.actionErrors.length == 0) {
                $location.path("/servicio/srvc/detail/" + data.item.id).replace();
            } else {
                $scope.actionErrors = data.actionErrors;
            }
        });
    }

    $scope.cancel = function() {
        window.history.back();
    }
});

module.controller("srvcEditController", function($scope, $http, $location, $route, $routeParams) {
    var url = "servicio/srvc-edit.action?item.id=" + $routeParams.srvcId;

    $http.get(url).success(function(data) {
        $scope.accion = data.accion;
        $scope.item = data.item;
        $scope.enti = data.enti;
        $scope.labelValuesMap = data.labelValuesMap;
    });

    $scope.save = function() {
        var url = "servicio/srvc-save.action";

        $http.post(url, {
            item : $scope.item,
            accion : $scope.accion
        }).success(function(data) {
            if (data.actionErrors.length == 0) {
                $location.path("/servicio/srvc/detail/" + data.item.id).replace();
            } else {
                $scope.actionErrors = data.actionErrors;
            }
        });
    }

    $scope.cancel = function() {
        $location.path("/servicio/srvc/detail/" + $scope.item.id).replace();
    }
});

module.controller("srvcDuplicateController", function($scope, $http, $location, $route, $routeParams) {
    var url = "servicio/srvc-duplicate.action?item.id=" + $routeParams.srvcId;

    $http.get(url).success(function(data) {
        $scope.accion = data.accion;
        $scope.item = data.item;
        $scope.enti = data.enti;
        $scope.labelValuesMap = data.labelValuesMap;
        $scope.subpList = data.subpList;
    });

    $scope.save = function() {
        var url = "servicio/srvc-save.action";

        $http.post(url, {
            item : $scope.item,
            accion : $scope.accion
        }).success(function(data) {
            if (data.actionErrors.length == 0) {
                $location.path("/servicio/srvc/detail/" + data.item.id).replace();
            } else {
                $scope.actionErrors = data.actionErrors;
            }
        });
    }

    $scope.cancel = function() {
        window.history.back();
    }
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

// ----------- SUBSERVICIOS ------------------
// ----------- SUBSERVICIOS ------------------
// ----------- SUBSERVICIOS ------------------

module.config([ "$routeProvider", function($routeProvider) {
    $routeProvider

    .when("/servicio/ssrv/grid/:entiId", {
        title : 'ssrv_grid',
        templateUrl : "modules/entidad/servicio/ssrv-grid.html",
        controller : "ssrvGridController"
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

    .when("/servicio/ssrv/detail/:ssrvId", {
        title : 'ssrv_detail',
        templateUrl : "modules/entidad/servicio/ssrv-detail.html",
        controller : "ssrvDetailController"
    })

    .when("/servicio/ssrv/edit/:ssrvId", {
        title : 'ssrv_edit',
        templateUrl : "modules/entidad/servicio/ssrv-edit.html",
        controller : "ssrvEditController"
    })

    .when("/servicio/ssrv/duplicate/:ssrvId", {
        title : 'ssrv_duplicate',
        templateUrl : "modules/entidad/servicio/ssrv-edit.html",
        controller : "ssrvDuplicateController"
    })
} ]);

module.controller("ssrvGridController", function($scope, $http, $location, $route, $routeParams) {
    loaded = false;

    $scope.showFilter = false;
    $scope.page = $routeParams.page ? $routeParams.page : 1;
    $scope.limit = 20;
    $scope.itemCriterio = {};
    $scope.itemCriterio.entiId = $routeParams.entiId;

    var url = "servicio/ssrv-list.action";

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
            $location.search({
                page : $scope.currentPage
            }).replace();
        }
    }

    $scope.filter = function() {
        $scope.showFilter = true;
    }

    $scope.search = function() {
        $location.path("/servicio/ssrv/grid/" + $scope.itemCriterio.entiId).replace();
    }

    $scope.cancelSearch = function() {
        $scope.showFilter = false;
    }
});

module.controller("ssrvDetailController", function($scope, $http, $location, $route, $routeParams) {
    var url = "servicio/ssrv-detail.action";

    url += "?item.id=" + $routeParams.ssrvId;

    $http.get(url).success(function(data) {
        $scope.enti = data.enti;
        $scope.item = data.item;
        $scope.entiHijasList = data.entiHijasList;
        $scope.itemHijosMap = data.itemHijosMap;
    });

    $scope.edit = function() {
        $location.path("/servicio/ssrv/edit/" + $scope.item.id).replace();
    }

    $scope.remove = function() {
        if (confirm("Are you sure?")) {
            var url = "servicio/ssrv-remove.action?item.id=" + $scope.item.id;

            $http.get(url).success(function(data) {
                if (data.actionErrors.length == 0) {
                    window.history.back();
                } else {
                    $scope.actionErrors = data.actionErrors;
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
                if (data.actionErrors.length == 0) {
                    $route.reload();
                } else {
                    $scope.actionErrors = data.actionErrors;
                }
            });

            break;
        case "mabl-completar":
            var url = "servicio/manifiesto/mabl-completar.action?item.id=" + $scope.item.id;

            $http.get(url).success(function(data) {
                if (data.actionErrors.length == 0) {
                    $route.reload();
                } else {
                    $scope.actionErrors = data.actionErrors;
                }
            });

            break;
        case "mabl-iniciar":
            var url = "servicio/manifiesto/mabl-iniciar.action?item.id=" + $scope.item.id;

            $http.get(url).success(function(data) {
                if (data.actionErrors.length == 0) {
                    $route.reload();
                } else {
                    $scope.actionErrors = data.actionErrors;
                }
            });

            break;
        case "mabl-anular":
            var url = "servicio/manifiesto/mabl-anular.action?item.id=" + $scope.item.id;

            $http.get(url).success(function(data) {
                if (data.actionErrors.length == 0) {
                    $route.reload();
                } else {
                    $scope.actionErrors = data.actionErrors;
                }
            });

            break;
        default:
            alert(accName);

            break;
        }
    }
});

module.controller("ssrvCreateController", function($scope, $http, $location, $route, $routeParams) {
    var url = "servicio/ssrv-create.action?item.entiId=" + $routeParams.entiId;

    if ($routeParams.srvcId) {
        url += "&item.srvc.id=" + $routeParams.srvcId;
    }

    $http.get(url).success(function(data) {
        $scope.item = data.item;
        $scope.enti = data.enti;
        $scope.entiPadresList = data.entiPadresList;
        $scope.labelValuesMap = data.labelValuesMap;
        $scope.accion = data.accion;
    });

    $scope.save = function() {
        var url = "servicio/ssrv-save.action";

        $http.post(url, {
            item : $scope.item,
            accion : $scope.accion
        }).success(function(data) {
            if (data.actionErrors.length == 0) {
                $location.path("/servicio/ssrv/detail/" + data.item.id).replace();
            } else {
                $scope.actionErrors = data.actionErrors;
            }
        });
    }

    $scope.cancel = function() {
        window.history.back();
    }
});

module.controller("ssrvEditController", function($scope, $http, $location, $route, $routeParams) {
    var url = "servicio/ssrv-edit.action?item.id=" + $routeParams.ssrvId;

    $http.get(url).success(function(data) {
        $scope.item = data.item;
        $scope.enti = data.enti;
        $scope.labelValuesMap = data.labelValuesMap;
        $scope.accion = data.accion;
    });

    $scope.save = function() {
        var url = "servicio/ssrv-save.action";

        $http.post(url, {
            item : $scope.item,
            accion : $scope.accion
        }).success(function(data) {
            if (data.actionErrors.length == 0) {
                $location.path("/servicio/ssrv/detail/" + data.item.id).replace();
            } else {
                $scope.actionErrors = data.actionErrors;
            }
        });
    }

    $scope.cancel = function() {
        $location.path("/servicio/ssrv/detail/" + $scope.item.id).replace();
    }
});

module.controller("ssrvDuplicateController", function($scope, $http, $location, $route, $routeParams) {
    var url = "servicio/ssrv-duplicate.action?item.id=" + $routeParams.ssrvId;

    $http.get(url).success(function(data) {
        $scope.item = data.item;
        $scope.enti = data.enti;
        $scope.labelValuesMap = data.labelValuesMap;
        $scope.accion = data.accion;
    });

    $scope.save = function() {
        var url = "servicio/ssrv-save.action";

        $http.post(url, {
            item : $scope.item,
            accion : $scope.accion
        }).success(function(data) {
            if (data.actionErrors.length == 0) {
                $location.path("/servicio/ssrv/detail/" + data.item.id).replace();
            } else {
                $scope.actionErrors = data.actionErrors;
            }
        });
    }

    $scope.cancel = function() {
        window.history.back();
    }
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
