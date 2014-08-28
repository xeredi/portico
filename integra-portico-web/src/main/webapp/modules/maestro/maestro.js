angular.module('maestro', [ 'ui.router' ])

.config(
        function($stateProvider, $urlRouterProvider) {
            $stateProvider

            .state('prmts', {
                abstract : true,
                url : '/maestro/prmts',
                templateUrl : 'modules/maestro/prmts.html'
            })

            .state('prmts.filtro', {
                templateUrl : 'modules/maestro/prmt-filtro.html',

                controller : function($http, $scope, $stateParams) {
                }
            })

            .state(
                    'prmts.list',
                    {
                        url : '/listado/:entiId/:page',
                        templateUrl : 'modules/maestro/prmt-listado.html',

                        controller : function($http, $scope, $stateParams) {
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
                url : '/detalle/:itemId',
                views : {
                    '' : {
                        templateUrl : 'modules/maestro/prmt-detalle.html',
                        controller : function($http, $scope, $state, $stateParams) {
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

            .state('prmts.alta', {
                url : '/alta/:entiId',
                views : {
                    '' : {
                        templateUrl : 'modules/maestro/prmt-edicion.html',
                        controller : function($http, $scope, $state, $stateParams) {
                            var url = "maestro/prmt-crear-json.action?item.entiId=" + $stateParams.entiId;

                            $http.get(url).success(function(data) {
                                $scope.accion = data.accion;
                                $scope.availableLanguages = data.availableLanguages;
                                $scope.enti = data.enti;
                                $scope.item = data.item;
                                $scope.p18nMap = data.p18nMap;
                                $scope.labelValuesMap = data.labelValuesMap;
                            });

                            $scope.guardar = function() {
                                console.log($scope.item);
                                console.log($scope.p18nMap);
                                console.log($scope.accion);
                                // $state.go('prmts.detalle', $stateParams);
                            };
                        }
                    }
                }
            })

            .state('prmts.editar', {
                url : '/editar/:itemId',
                views : {
                    '' : {
                        templateUrl : 'modules/maestro/prmt-edicion.html',
                        controller : function($http, $scope, $stateParams) {
                            var url = "maestro/prmt-editar-json.action?item.id=" + $stateParams.itemId;

                            $http.get(url).success(function(data) {
                                $scope.accion = data.accion;
                                $scope.availableLanguages = data.availableLanguages;
                                $scope.enti = data.enti;
                                $scope.item = data.item;
                                $scope.p18nMap = data.p18nMap;
                                $scope.entiHijasList = data.entiHijasList;
                                $scope.itemHijosMap = data.itemHijosMap;
                                $scope.labelValuesMap = data.labelValuesMap;
                            });
                        }
                    }
                }
            })

            .state('prmts.duplicar', {
                url : '/duplicar/:itemId',
                views : {
                    '' : {
                        templateUrl : 'modules/maestro/prmt-edicion.html',
                        controller : function($http, $scope, $stateParams) {
                            var url = "maestro/prmt-duplicar-json.action?item.id=" + $stateParams.itemId;

                            $http.get(url).success(function(data) {
                                $scope.accion = data.accion;
                                $scope.availableLanguages = data.availableLanguages;
                                $scope.enti = data.enti;
                                $scope.item = data.item;
                                $scope.p18nMap = data.p18nMap;
                                $scope.entiHijasList = data.entiHijasList;
                                $scope.itemHijosMap = data.itemHijosMap;
                                $scope.labelValuesMap = data.labelValuesMap;
                            });
                        }
                    }
                }
            })
        })

.controller(
        'prmtsCtrl',
        function($http, $scope, $routeParams, $modal) {
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
        })

.controller('prmtsFiltroCtrl', function($http, $scope, $modalInstance, entiId, itemCriterio) {
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
})

.controller(
        'prmtsLupaCtrl',
        function($http, $scope) {
            $scope.getLabelValues = function(entiId, textoBusqueda) {
                return $http.get(
                        'maestro/prmt-lupa.action?itemLupaCriterio.entiId=' + entiId
                                + "&itemLupaCriterio.textoBusqueda=" + textoBusqueda
                                + "&itemLupaCriterio.fechaVigencia=11/12/2014").then(function(res) {
                    // console.log(res.data);

                    var labelValues = [];

                    angular.forEach(res.data.itemList, function(item) {
                        labelValues.push(item.label);
                    });

                    return labelValues;
                });
            };
        })

.controller('ParametroDetailController', function($scope, $http, $route, $routeParams, $location) {
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
})

.controller('ParametroEditController', function($scope, $http, $route, $routeParams) {
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
})

.controller('prmtCtrl', function($http, $scope, $routeParams, $location) {
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
})

.controller('prmtTabsCtrl', function($scope) {
    $scope.navType = 'pills';
})

.controller('prmtCrearCtrl', function($http, $scope, $routeParams) {
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
})

.controller('prmtEditarCtrl', function($http, $scope, $routeParams) {
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
})

.controller('prmtDuplicarCtrl', function($http, $scope, $routeParams) {
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
})

.controller('prmtGuardarCtrl', function($scope, $location) {
    $scope.submit = function() {
        console.log($scope.accion);
        console.log($scope.item);
        console.log($scope.p18nMap);

        $location.path("/maestro/prmt/" + $scope.item.id);
    };
})

.controller('prmtBorrarCtrl', function($http, $scope, $routeParams, $location) {
    alert('Borrar');
});
