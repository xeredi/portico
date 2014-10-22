angular.module("servicio", [ "ngRoute" ])

// ----------------- MENU PRINCIPAL --------------------------
// ----------------- MENU PRINCIPAL --------------------------
// ----------------- MENU PRINCIPAL --------------------------

.config([ "$routeProvider", function($routeProvider) {
    $routeProvider

    .when("/servicio", {
        title : 'servicio_main',
        templateUrl : "modules/entidad/servicio/servicio.html",
        controller : "servicioController"
    })
} ])

.controller("servicioController", function($scope, $http, $location) {
    var url = "servicio/tpsr-list.action";

    $http.get(url).success(function(data) {
        $scope.tpsrList = data.tpsrList;
        $scope.tpssMap = data.tpssMap;
    });
})

// ----------- SERVICIOS ------------------
// ----------- SERVICIOS ------------------
// ----------- SERVICIOS ------------------

.config([ "$routeProvider", function($routeProvider) {
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
} ])

.controller(
        "srvcGridController",
        function($scope, $http, $location, $routeParams, $modal) {
            $scope.itemCriterio = $routeParams.itemCriterio ? angular.fromJson($routeParams.itemCriterio) : {};
            $scope.itemCriterio.entiId = $routeParams.entiId;

            function search(itemCriterio, page) {
                $scope.loading = true;

                $http.post("servicio/srvc-list.action", {
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
                    templateUrl : 'srvc-filter-content.html',
                    controller : 'srvcFilterController',
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
                    console.log("srvcGridController: " + JSON.stringify(itemCriterio));

                    $scope.itemCriterio = itemCriterio;

                    search($scope.itemCriterio, 1);
                });
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
        })

.controller("srvcFilterController", function($scope, $http, $modalInstance, enti, itemCriterio) {
    console.log("srvcFilterController: " + JSON.stringify(itemCriterio));

    $scope.itemCriterio = itemCriterio;
    $scope.enti = enti;

    $scope.ok = function() {
        $modalInstance.close($scope.itemCriterio);
    };

    $scope.cancel = function() {
        $modalInstance.dismiss('cancel');
    };

    $http.get("servicio/srvc-filter.action?itemCriterio.entiId=" + itemCriterio.entiId).success(function(data) {
        $scope.actionErrors = data.actionErrors;

        if (data.actionErrors.length == 0) {
            $scope.labelValuesMap = data.labelValuesMap;
            $scope.subpList = data.subpList;
            $scope.limits = data.limits;
            $scope.fechaVigencia = data.fechaVigencia;
        }
    });
})

.controller(
        "srvcDetailController",
        function($scope, $http, $location, $routeParams) {
            var path = $location.path();
            var tabSelected = $routeParams.tabSelected;
            var srvcId = $routeParams.srvcId;
            var entiId = $routeParams.entiId;
            var pageMap = $routeParams.pageMap ? angular.fromJson($routeParams.pageMap) : {};

            $scope.pageMap = {};

            function findItem() {
                $http.get("metamodelo/tpsr-proxy-detail.action?includeDependencies=true&enti.id=" + entiId).success(
                        function(data) {
                            $scope.enti = data.enti;
                            $scope.subentiList = data.subentiList;

                            if (tabSelected) {
                                $scope.subentiList[tabSelected].active = true;
                            }

                            $http.get("servicio/srvc-detail.action?item.id=" + srvcId).success(function(data) {
                                $scope.item = data.item;
                                $scope.fechaVigencia = data.fechaVigencia;
                            });

                            $scope.itemHijosMap = {};

                            for (i = 0; i < $scope.subentiList.length; i++) {
                                var subenti = $scope.subentiList[i];

                                console.log("getList: " + subenti.id + ", " + pageMap[subenti.id] ? pageMap[subenti.id]
                                        : 1);

                                findSublist(subenti.id, pageMap[subenti.id] ? pageMap[subenti.id] : 1);
                            }
                        });
            }

            function findSublist(subentiId, page) {
                $scope.loading = true;

                var url = "servicio/ssrv-list.action?itemCriterio.entiId=" + subentiId + "&page=" + page
                        + "&itemCriterio.srvc.id=" + srvcId;

                $http.get(url).success(function(data) {
                    $scope.actionErrors = data.actionErrors;

                    if (data.actionErrors.length == 0) {
                        $scope.itemHijosMap[data.itemCriterio.entiId] = data.itemList;
                        $scope.pageMap[data.itemCriterio.entiId] = data.itemList.page;
                        $location.search("pageMap", JSON.stringify($scope.pageMap)).replace();
                    }

                    $scope.loading = false;
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
                    var url = "servicio/srvc-remove.action?item.id=" + $scope.item.id;

                    $http.get(url).success(function(data) {
                        $scope.actionErrors = data.actionErrors;

                        if (data.actionErrors.length == 0) {
                            window.history.back();
                        }
                    });
                }
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

            findItem();
        })

.controller("srvcCreateController", function($scope, $http, $location, $routeParams) {
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
})

.controller("srvcEditController", function($scope, $http, $location, $routeParams) {
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
})

.controller("srvcDuplicateController", function($scope, $http, $location, $routeParams) {
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
})

.controller(
        'srvcLupaCtrl',
        function($http, $scope) {
            $scope.getLabelValues = function(entiId, textoBusqueda) {
                return $http.get(
                        'servicio/srvc-lupa.action?itemLupaCriterio.entiId=' + entiId
                                + "&itemLupaCriterio.textoBusqueda=" + textoBusqueda
                                + "&itemLupaCriterio.fechaVigencia=11/12/2014").then(function(res) {
                    return res.data.itemList;
                });
            };
        })

.controller("maniTotalesController", function($scope, $http, $location, $routeParams) {
    var url = "servicio/manifiesto/mani-totales.action?item.id=" + $routeParams.srvcId;

    $http.get(url).success(function(data) {
        $scope.item = data.item;
        $scope.resumen = data.resumen;
    });
})

// ----------- SUBSERVICIOS ------------------
// ----------- SUBSERVICIOS ------------------
// ----------- SUBSERVICIOS ------------------

.config([ "$routeProvider", function($routeProvider) {
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
} ])

.controller("ssrvGridController", function($scope, $http, $location, $routeParams, $modal) {
    $scope.itemCriterio = $routeParams.itemCriterio ? angular.fromJson($routeParams.itemCriterio) : {};
    $scope.itemCriterio.entiId = $routeParams.entiId;

    function search(itemCriterio, page) {
        $scope.loading = true;

        $http.post("servicio/ssrv-list.action", {
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
})

.controller("ssrvFilterController", function($scope, $http, $modalInstance, enti, itemCriterio) {
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
        $scope.actionErrors = data.actionErrors;

        if (data.actionErrors.length == 0) {
            $scope.labelValuesMap = data.labelValuesMap;
            $scope.limits = data.limits;
            $scope.fechaVigencia = data.fechaVigencia;
        }
    });
})

.controller(
        "ssrvDetailController",
        function($scope, $http, $location, $routeParams) {
            var path = $location.path();
            var tabSelected = $routeParams.tabSelected;
            var ssrvId = $routeParams.ssrvId;
            var entiId = $routeParams.entiId;
            var pageMap = $routeParams.pageMap ? angular.fromJson($routeParams.pageMap) : {};

            $scope.pageMap = {};

            function findItem() {
                $http
                        .get(
                                "metamodelo/tpss-proxy-detail.action?includeDependencies=true&enti.id="
                                        + $routeParams.entiId).success(
                                function(data) {
                                    $scope.enti = data.enti;
                                    $scope.subentiList = data.subentiList;

                                    if (tabSelected) {
                                        $scope.subentiList[tabSelected].active = true;
                                    }

                                    $http.get("servicio/ssrv-detail.action?item.id=" + $routeParams.ssrvId).success(
                                            function(data) {
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

            findItem();
        })

.controller("ssrvCreateController", function($scope, $http, $location, $routeParams) {
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
})

.controller("ssrvEditController", function($scope, $http, $location, $routeParams) {
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
})

.controller("ssrvDuplicateController", function($scope, $http, $location, $routeParams) {
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
})

.controller(
        'ssrvLupaCtrl',
        function($http, $scope) {
            $scope.getLabelValues = function(entiId, srvcId, numero) {
                return $http.get(
                        'servicio/ssrv-lupa.action?itemLupaCriterio.entiId=' + entiId + "&itemLupaCriterio.srvcId="
                                + srvcId + "&itemLupaCriterio.numero=" + numero
                                + "&itemLupaCriterio.fechaVigencia=11/12/2014").then(function(res) {
                    return res.data.itemList;
                });
            };
        })

.controller(
        "mablTotalesController",
        function($scope, $http, $location, $routeParams) {
            var url = "servicio/manifiesto/mabl-totales.action?item.id=" + $routeParams.ssrvId + "&item.srvc.id="
                    + $routeParams.srvcId;

            $http.get(url).success(function(data) {
                $scope.item = data.item;
                $scope.resumen = data.resumen;
            });
        });
