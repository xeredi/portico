var maestro = angular.module('maestro', [ 'ui.router' ]);

app.config(function($stateProvider, $urlRouterProvider) {
    $stateProvider

    .state(
            'prmts',
            {
                url : '/maestro/prmts/:entiId/:page',
                templateUrl : 'modules/maestro/prmt-listado.html',
                controller : function($http, $scope, $stateParams) {
                    alert('Listado');

                    $scope.loadData = function() {
                        var url = "maestro/prmt-listado-json.action?itemCriterio.entiId=" + $stateParams.entiId
                                + "&page=" + $stateParams.page;

                        $http.get(url).success(function(data) {
                            // console.log(data);
                            $scope.enti = data.enti;
                            $scope.itemList = data.itemList;
                            $scope.itemCriterio = data.itemCriterio;
                        });
                    };

                    $scope.pageChanged = function() {
                        $stateParams.page = $scope.currentPage;

                        $scope.loadData();
                    };

                    $scope.loadData();
                }
            })

    .state('prmts.detalle', {
        url : '/:itemId',
        views : {
            '' : {
                templateUrl : 'modules/maestro/prmt-detalle.html',
                controller : function($http, $scope, $state, $stateParams) {
                    alert('Detalle');

                    var url = "maestro/prmt-detalle-json.action?item.id=" + $stateParams.itemId;

                    $http.get(url).success(function(data) {
                        $scope.enti = data.enti;
                        $scope.item = data.item;
                        $scope.p18nMap = data.p18nMap;
                        $scope.entiHijasList = data.entiHijasList;
                        $scope.itemHijosMap = data.itemHijosMap;
                        $scope.availableLanguages = data.availableLanguages;
                    });

                    $scope.editar = function() {
                        alert("Editar: " + $stateParams.itemId);

                        $state.go('prmts.editar', $stateParams);
                    };
                }
            }
        }
    })

    .state('prmts.editar', {
        views : {
            '' : {
                templateUrl : 'modules/maestro/prmt-edicion.html',
                controller : function($http, $scope, $stateParams) {
                    alert("Controller de edicion: " + $stateParams.itemId);

                    var url = "maestro/prmt-detalle-json.action?item.id=" + $stateParams.itemId;

                    $http.get(url).success(function(data) {
                        $scope.enti = data.enti;
                        $scope.item = data.item;
                        $scope.p18nMap = data.p18nMap;
                        $scope.entiHijasList = data.entiHijasList;
                        $scope.itemHijosMap = data.itemHijosMap;
                        $scope.availableLanguages = data.availableLanguages;
                    });
                }
            }
        }
    })
});
/*
 * maestro.config([ '$routeProvider', function($routeProvider) {
 * $routeProvider.when('/maestro/prmts/:entiId/:page', { templateUrl :
 * 'modules/maestro/prmt-listado.html', controller : 'prmtsCtrl'
 * }).when('/maestro/prmts/exportar/:entiId', { controller : 'prmtsExportCtrl'
 * }).when('/maestro/prmt/crear/:entiId', { templateUrl :
 * 'modules/maestro/prmt-edicion.html', controller : 'prmtCrearCtrl'
 * }).when('/maestro/prmt/editar/:itemId', { templateUrl :
 * 'modules/maestro/prmt-edicion.html', controller : 'prmtEditarCtrl'
 * }).when('/maestro/prmt/duplicar/:itemId', { templateUrl :
 * 'modules/maestro/prmt-edicion.html', controller : 'prmtDuplicarCtrl'
 * }).when('/maestro/prmt/borrar/:itemId', { controller : 'prmtBorrarCtrl'
 * }).when('/maestro/prmt/imprimir/:itemId', { controller : 'prmtCtrl'
 * }).when('/maestro/prmt/:itemId', { templateUrl :
 * 'modules/maestro/prmt-detalle.html', controller : 'ParametroDetailController'
 * }).when('/maestro/prmt/edit/:itemId', { templateUrl :
 * 'modules/maestro/prmt-edicion.html', controller : 'ParametroEditController'
 * }); } ]);
 */

maestro.controller('prmtsCtrl', function($http, $scope, $routeParams, $modal) {
    $scope.loadData = function() {
        var url = "maestro/prmt-listado-json.action?itemCriterio.entiId=" + $routeParams.entiId + "&page="
                + $routeParams.page;

        // alert($routeParams.page);

        $http.get(url).success(function(data) {
            // console.log(data);
            $scope.enti = data.enti;
            $scope.itemList = data.itemList;
            $scope.itemCriterio = data.itemCriterio;
        });
    };

    $scope.pageChanged = function() {
        $routeParams.page = $scope.currentPage;

        $scope.loadData();
    };

    $scope.openFiltro = function(size) {
        var modalInstance = $modal.open({
            templateUrl : 'modules/maestro/prmt-filtro.html',
            controller : 'prmtsFiltroCtrl',
            size : size,
            resolve : {
                entiId : function() {
                    return $routeParams.entiId;
                },
                itemCriterio : function() {
                    return $scope.itemCriterio;
                }
            }
        });

        modalInstance.result.then(function() {
        }, function() {
        });
    };

    if ($routeParams.page == null) {
        // alert('inicializar numero de pagina');

        $routeParams.page = 1;
    }

    $scope.page = $routeParams.page;
    $scope.currentPage = $routeParams.page;

    $scope.loadData();
});

maestro.controller('prmtsFiltroCtrl', function($http, $scope, $modalInstance, entiId, itemCriterio) {
    // $scope.itemCriterio = itemCriterio;

    var url = "maestro/prmt-filtro-json.action?itemCriterio.entiId=" + entiId;

    $http.get(url).success(function(data) {
        // console.log(data);
        $scope.enti = data.enti;
        $scope.limits = data.limits;
        $scope.labelValuesMap = data.labelValuesMap;
        $scope.itemCriterio = data.itemCriterio;
        $scope.limit = data.limit;
    });

    $scope.ok = function() {
        console.log("itemCriterio.parametro: " + $scope.itemCriterio.parametro);
        console.log("itemCriterio: " + $scope.itemCriterio);
        console.log("itemCriterio.itdtMap: " + $scope.itemCriterio.itdtMap);
        console.log("limit:" + $scope.limit);

        $http.post("maestro/prmt-listado-json.action", {
            "data" : $scope.itemCriterio
        }).success(function(data, status) {
            alert("success");
        }).error(function(data, status) {
            alert("error");
        });

        $modalInstance.close();
    };

    $scope.cancel = function() {
        $modalInstance.dismiss('cancel');
    };
});

maestro.controller('prmtsLupaCtrl', function($http, $scope) {
    $scope.getLabelValues = function(entiId, textoBusqueda) {
        return $http.get(
                'maestro/prmt-lupa.action?itemLupaCriterio.entiId=' + entiId + "&itemLupaCriterio.textoBusqueda="
                        + textoBusqueda + "&itemLupaCriterio.fechaVigencia=11/12/2014").then(function(res) {
            // console.log(res.data);

            var labelValues = [];

            angular.forEach(res.data.itemList, function(item) {
                labelValues.push(item.label);
            });

            return labelValues;
        });
    };
});

app.controller('ParametroDetailController', function($scope, $http, $route, $routeParams, $location) {
    var url = "maestro/prmt-detalle-json.action?item.id=" + $routeParams.itemId;

    $http.get(url).success(function(data) { // console.log(data);
        $scope.enti = data.enti;
        $scope.item = data.item;
        $scope.p18nMap = data.p18nMap;
        $scope.entiHijasList = data.entiHijasList;
        $scope.itemHijosMap = data.itemHijosMap;
        $scope.availableLanguages = data.availableLanguages;
    });

    $scope.editar = function() {
        // alert('Editar: ' + $scope.item.id);

        var url = "maestro/prmt/edit/" + $scope.item.id;

        alert(url);

        $location.path(url);
    }

    $scope.duplicar = function() {
        alert('Duplicar: ' + $scope.item.id);
    }

    $scope.borrar = function() {
        alert('Borrar: ' + $scope.item.id);
    }
});

app.controller('ParametroEditController', function($scope, $http, $route, $routeParams) {
    var url = "maestro/prmt-detalle-json.action?item.id=" + $routeParams.itemId;

    $http.get(url).success(function(data) { // console.log(data);
        $scope.enti = data.enti;
        $scope.item = data.item;
        $scope.p18nMap = data.p18nMap;
        $scope.entiHijasList = data.entiHijasList;
        $scope.itemHijosMap = data.itemHijosMap;
        $scope.availableLanguages = data.availableLanguages;
    });

    $scope.guardar = function($location) {
        alert('Guardar: ' + $scope.item.id);
    }
});

maestro.controller('prmtCtrl', function($http, $scope, $routeParams, $location) {
    $scope.crear = function(entiId) {
        if (entiId) {
            $location.path('/maestro/prmt/crear/' + entiId);

            alert('alta');

            var url = "maestro/prmt-crear-json.action?item.entiId=" + entiId;

            $http.get(url).success(function(data) {
                // console.log(data);
                $scope.enti = data.enti;
                $scope.item = data.item;
                $scope.p18nMap = data.p18nMap;
                $scope.availableLanguages = data.availableLanguages;
                $scope.labelValuesMap = data.labelValuesMap;
            });
        }
    };

    $scope.borrar = function(itemId) {
        alert('borrar: ' + itemId);
    };

    $scope.imprimir = function(itemId) {
        if (itemId) {
            var url = "maestro/prmt-imprimir.action?item.id=" + itemId;

            $http({
                method : 'GET',
                url : "maestro/prmt-imprimir.action?item.id=" + itemId
            });
        }
    };

    if ($routeParams.itemId && $scope.enti == null) {
        var url = "maestro/prmt-detalle-json.action?item.id=" + $routeParams.itemId;

        $http.get(url).success(function(data) { // console.log(data);
            $scope.enti = data.enti;
            $scope.item = data.item;
            $scope.p18nMap = data.p18nMap;
            $scope.entiHijasList = data.entiHijasList;
            $scope.itemHijosMap = data.itemHijosMap;
            $scope.availableLanguages = data.availableLanguages;
        });
    }
});

maestro.controller('prmtTabsCtrl', function($scope) {
    $scope.navType = 'pills';
});

maestro.controller('prmtCrearCtrl', function($http, $scope, $routeParams) {
    if ($routeParams.entiId) {
        var url = "maestro/prmt-crear-json.action?item.entiId=" + $routeParams.entiId;

        $http.get(url).success(function(data) {
            // console.log(data);
            $scope.accion = data.accion;
            $scope.enti = data.enti;
            $scope.item = data.item;
            $scope.p18nMap = data.p18nMap;
            $scope.availableLanguages = data.availableLanguages;
            $scope.labelValuesMap = data.labelValuesMap;
        });
    }
});

maestro.controller('prmtEditarCtrl', function($http, $scope, $routeParams) {
    if ($routeParams.itemId) {
        var url = "maestro/prmt-editar-json.action?item.id=" + $routeParams.itemId;

        $http.get(url).success(function(data) {
            // console.log(data);
            $scope.accion = data.accion;
            $scope.enti = data.enti;
            $scope.item = data.item;
            $scope.p18nMap = data.p18nMap;
            $scope.availableLanguages = data.availableLanguages;
            $scope.labelValuesMap = data.labelValuesMap;
        });
    }
});

maestro.controller('prmtDuplicarCtrl', function($http, $scope, $routeParams) {
    alert('Duplicar');

    if ($routeParams.itemId) {
        var url = "maestro/prmt-duplicar-json.action?item.id=" + $routeParams.itemId;

        $http.get(url).success(function(data) {
            // console.log(data);
            $scope.accion = data.accion;
            $scope.enti = data.enti;
            $scope.item = data.item;
            $scope.p18nMap = data.p18nMap;
            $scope.availableLanguages = data.availableLanguages;
            $scope.labelValuesMap = data.labelValuesMap;
        });
    }
});

maestro.controller('prmtGuardarCtrl', function($scope, $location) {
    $scope.submit = function() {
        console.log($scope.accion);
        console.log($scope.item);
        console.log($scope.p18nMap);

        $location.path("/maestro/prmt/" + $scope.item.id);
    };
});

maestro.controller('prmtBorrarCtrl', function($http, $scope, $routeParams, $location) {
    alert('Borrar');
});
