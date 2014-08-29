angular.module('maestro', [ 'ui.router' ])

.service('sharedProperties', function() {
    var errors;

    return {
        getErrors : function() {
            return errors;
        },
        setErrors : function(value) {
            errors = value;
        }
    }
})

.config(
        function($stateProvider, $urlRouterProvider) {
            $stateProvider

            .state('prmts', {
                abstract : true,
                url : '/maestro/prmts',
                templateUrl : 'modules/maestro/prmts.html'
            })

            .state(
                    'prmts.list',
                    {
                        url : '/listado/:entiId/:page',
                        templateUrl : 'modules/maestro/prmt-listado.html',

                        controller : function($http, $scope, $state, $stateParams) {
                            $scope.loadData = function() {
                                var url = "maestro/prmt-listado.action?itemCriterio.entiId=" + $stateParams.entiId
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

                            $scope.filtro = function() {
                                console.log("Antes de llamar al filtro");
                                // console.log("state: " +
                                // JSON.stringify($state));
                                console.log("stateParams: " + JSON.stringify($stateParams));
                                // console.log("scope: " +
                                // JSON.stringify($scope));

                                alert('page antes de llamar al filtro: ' + $stateParams.page);

                                $state.go('prmts.filtro', $stateParams);
                            }

                            $scope.loadData();
                        }
                    })

            .state(
                    'prmts.filtro',
                    {
                        url : '/filtro/:entiId',
                        templateUrl : 'modules/maestro/prmt-filtro.html',

                        controller : function($http, $scope, $state, $stateParams) {
                            console.log('page en filtro');
                            console.log("stateParams: " + JSON.stringify($stateParams));

                            var url = "maestro/prmt-filtro.action?itemCriterio.entiId=" + $stateParams.entiId
                                    + "&page=" + $stateParams.page;

                            $http.get(url).success(function(data) {
                                $scope.enti = data.enti;
                                $scope.itemCriterio = data.itemCriterio;
                                $scope.labelValuesMap = data.labelValuesMap;
                            });

                            $scope.buscar = function() {
                                alert('Buscar');
                            }
                        }
                    })

            .state('prmts.detalle', {
                url : '/detalle/:itemId',
                templateUrl : 'modules/maestro/prmt-detalle.html',
                controller : function($http, $scope, $state, $stateParams) {
                    var url = "maestro/prmt-detalle.action?item.id=" + $stateParams.itemId;

                    $http.get(url).success(function(data) {
                        if (data.actionErrors.length == 0) {
                            $scope.enti = data.enti;
                            $scope.item = data.item;
                            $scope.p18nMap = data.p18nMap;
                            $scope.entiHijasList = data.entiHijasList;
                            $scope.itemHijosMap = data.itemHijosMap;
                            $scope.availableLanguages = data.availableLanguages;
                        } else {
                            $scope.actionErrors = data.actionErrors;
                        }
                    });
                }
            })

            .state('prmts.alta', {
                url : '/alta/:entiId',
                templateUrl : 'modules/maestro/prmt-edicion.html',
                controller : function($http, $scope, $state, $stateParams) {
                    var url = "maestro/prmt-crear.action?item.entiId=" + $stateParams.entiId;

                    $http.get(url).success(function(data) {
                        if (data.actionErrors.length == 0) {
                            $scope.accion = data.accion;
                            $scope.availableLanguages = data.availableLanguages;
                            $scope.enti = data.enti;
                            $scope.item = data.item;
                            $scope.p18nMap = data.p18nMap;
                            $scope.labelValuesMap = data.labelValuesMap;
                        } else {
                            $scope.actionErrors = data.actionErrors;
                        }
                    });

                    $scope.guardar = function() {
                        $http.post("maestro/prmt-guardar.action", {
                            item : $scope.item,
                            p18nMap : $scope.p18nMap,
                            accion : $scope.accion
                        }).success(function(data) {
                            if (data.actionErrors.length == 0) {
                                // $state.go('prmts.detalle', $stateParams);
                            } else {
                                $scope.actionErrors = data.actionErrors;
                            }
                        });
                    };
                }
            })

            .state('prmts.editar', {
                url : '/editar/:itemId',
                templateUrl : 'modules/maestro/prmt-edicion.html',
                controller : function($http, $scope, $stateParams) {
                    var url = "maestro/prmt-editar.action?item.id=" + $stateParams.itemId;

                    $http.get(url).success(function(data) {
                        if (data.actionErrors.length == 0) {
                            $scope.accion = data.accion;
                            $scope.availableLanguages = data.availableLanguages;
                            $scope.enti = data.enti;
                            $scope.item = data.item;
                            $scope.p18nMap = data.p18nMap;
                            $scope.entiHijasList = data.entiHijasList;
                            $scope.itemHijosMap = data.itemHijosMap;
                            $scope.labelValuesMap = data.labelValuesMap;
                        } else {
                            $scope.actionErrors = data.actionErrors;
                        }
                    });

                    $scope.guardar = function() {
                        $http.post("maestro/prmt-guardar.action", {
                            item : $scope.item,
                            p18nMap : $scope.p18nMap,
                            accion : $scope.accion
                        }).success(function(data) {
                            if (data.actionErrors.length == 0) {
                                // $state.go('prmts.detalle', $stateParams);
                            } else {
                                $scope.actionErrors = data.actionErrors;
                            }
                        });
                    };
                }
            })

            .state('prmts.duplicar', {
                url : '/duplicar/:itemId',
                templateUrl : 'modules/maestro/prmt-edicion.html',
                controller : function($http, $scope, $stateParams) {
                    var url = "maestro/prmt-duplicar.action?item.id=" + $stateParams.itemId;

                    $http.get(url).success(function(data) {
                        if (data.actionErrors.length == 0) {
                            $scope.accion = data.accion;
                            $scope.availableLanguages = data.availableLanguages;
                            $scope.enti = data.enti;
                            $scope.item = data.item;
                            $scope.p18nMap = data.p18nMap;
                            $scope.entiHijasList = data.entiHijasList;
                            $scope.itemHijosMap = data.itemHijosMap;
                            $scope.labelValuesMap = data.labelValuesMap;
                        } else {
                            $scope.actionErrors = data.actionErrors;
                        }
                    });

                    $scope.guardar = function() {
                        $http.post("maestro/prmt-guardar.action", {
                            item : $scope.item,
                            p18nMap : $scope.p18nMap,
                            accion : $scope.accion
                        }).success(function(data) {
                            if (data.actionErrors.length == 0) {
                                // $state.go('prmts.detalle', $stateParams);
                            } else {
                                $scope.actionErrors = data.actionErrors;
                            }
                        });
                    };
                }
            })
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
        });
// .controller(
// 'prmtsCtrl',
// function($http, $scope, $routeParams, $modal) {
// $scope.loadData = function() {
// var url = "maestro/prmt-listado-json.action?itemCriterio.entiId=" +
// $routeParams.entiId + "&page="
// + $routeParams.page;
//
// // alert($routeParams.page);
//
// $http.get(url).success(function(data) {
// // console.log(data);
// $scope.enti = data.enti;
// $scope.itemList = data.itemList;
// $scope.itemCriterio = data.itemCriterio;
// });
// };
//
// $scope.pageChanged = function() {
// $routeParams.page = $scope.currentPage;
//
// $scope.loadData();
// };
//
// $scope.openFiltro = function(size) {
// var modalInstance = $modal.open({
// templateUrl : 'modules/maestro/prmt-filtro.html',
// controller : 'prmtsFiltroCtrl',
// size : size,
// resolve : {
// entiId : function() {
// return $routeParams.entiId;
// },
// itemCriterio : function() {
// return $scope.itemCriterio;
// }
// }
// });
//
// modalInstance.result.then(function() {
// }, function() {
// });
// };
//
// if ($routeParams.page == null) {
// // alert('inicializar numero de pagina');
//
// $routeParams.page = 1;
// }
//
// $scope.page = $routeParams.page;
// $scope.currentPage = $routeParams.page;
//
// $scope.loadData();
// })
//
// .controller('prmtsFiltroCtrl', function($http, $scope, $modalInstance,
// entiId, itemCriterio) {
// // $scope.itemCriterio = itemCriterio;
//
// var url = "maestro/prmt-filtro-json.action?itemCriterio.entiId=" + entiId;
//
// $http.get(url).success(function(data) {
// // console.log(data);
// $scope.enti = data.enti;
// $scope.limits = data.limits;
// $scope.labelValuesMap = data.labelValuesMap;
// $scope.itemCriterio = data.itemCriterio;
// $scope.limit = data.limit;
// });
//
// $scope.ok = function() {
// console.log("itemCriterio.parametro: " + $scope.itemCriterio.parametro);
// console.log("itemCriterio: " + $scope.itemCriterio);
// console.log("itemCriterio.itdtMap: " + $scope.itemCriterio.itdtMap);
// console.log("limit:" + $scope.limit);
//
// $http.post("maestro/prmt-listado-json.action", {
// "data" : $scope.itemCriterio
// }).success(function(data, status) {
// alert("success");
// }).error(function(data, status) {
// alert("error");
// });
//
// $modalInstance.close();
// };
//
// $scope.cancel = function() {
// $modalInstance.dismiss('cancel');
// };
// })
//
