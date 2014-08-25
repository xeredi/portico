angular.module('facturacion', [ 'ui.router' ])

.config(
        function($stateProvider, $urlRouterProvider) {
            $stateProvider

            .state('vlrcs', {
                abstract : true,
                url : '/facturacion/vlrcs',
                templateUrl : 'modules/facturacion/vlrcs.html'
            })

            .state('vlrcs.list', {
                url : '/:page',
                templateUrl : 'modules/facturacion/vlrc-listado.html',

                controller : function($http, $scope, $stateParams) {
                    if ($stateParams.page == null) {
                        $stateParams.page = 1;
                    }

                    $scope.loadData = function() {
                        var url = "facturacion/vlrc-listado.action?page=" + $stateParams.page;

                        $http.get(url).success(function(data) {
                            // console.log(data);
                            $scope.vlrcList = data.vlrcList;
                        });
                    };

                    $scope.pageChanged = function() {
                        $stateParams.page = $scope.currentPage;

                        $scope.loadData();
                    };

                    $scope.loadData();
                }
            })

            .state('vlrcs.detalle', {
                url : '/detalle/:vlrcId',
                views : {
                    '' : {
                        templateUrl : 'modules/facturacion/vlrc-detalle.html',
                        controller : function($http, $scope, $state, $stateParams) {
                            var url = "facturacion/vlrc-detalle.action?vlrc.id=" + $stateParams.vlrcId;

                            $http.get(url).success(function(data) {
                                $scope.vlrc = data.vlrc;
                                $scope.vlrgList = data.vlrgList;
                                $scope.vlriList = data.vlriList;
                            });

                            $scope.editar = function() {
                                alert("Editar: " + $stateParams.vlrcId);

                                $state.go('vlrcs.editar', $stateParams);
                            };
                        }
                    }
                }
            })

            .state('aspcs', {
                abstract : true,
                url : '/facturacion/aspcs',
                templateUrl : 'modules/facturacion/aspcs.html'
            })

            .state('aspcs.list', {
                url : '/:page',
                templateUrl : 'modules/facturacion/aspc-listado.html',

                controller : function($http, $scope, $stateParams) {
                    if ($stateParams.page == null) {
                        $stateParams.page = 1;
                    }

                    $scope.loadData = function() {
                        var url = "facturacion/aspc-listado.action?page=" + $stateParams.page;

                        $http.get(url).success(function(data) {
                            // console.log(data);
                            $scope.aspcList = data.aspcList;
                        });
                    };

                    $scope.pageChanged = function() {
                        $stateParams.page = $scope.currentPage;

                        $scope.loadData();
                    };

                    $scope.loadData();
                }
            })

            .state('aspcs.detalle', {
                url : '/detalle/:aspvId',
                views : {
                    '' : {
                        templateUrl : 'modules/facturacion/aspc-detalle.html',
                        controller : function($http, $scope, $state, $stateParams) {
                            var url = "facturacion/aspc-detalle.action?aspc.aspv.id=" + $stateParams.aspvId;

                            $http.get(url).success(function(data) {
                                $scope.aspc = data.aspc;
                            });

                            $scope.editar = function() {
                                alert("Editar: " + $stateParams.aspvId);

                                $state.go('aspcs.editar', $stateParams);
                            };
                        }
                    }
                }
            })

            .state('crgos', {
                abstract : true,
                url : '/facturacion/crgos',
                templateUrl : 'modules/facturacion/crgos.html'
            })

            .state('crgos.list', {
                url : '/:page',
                templateUrl : 'modules/facturacion/crgo-listado.html',

                controller : function($http, $scope, $stateParams) {
                    if ($stateParams.page == null) {
                        $stateParams.page = 1;
                    }

                    $scope.loadData = function() {
                        var url = "facturacion/crgo-listado.action?page=" + $stateParams.page;

                        $http.get(url).success(function(data) {
                            // console.log(data);
                            $scope.crgoList = data.crgoList;
                        });
                    };

                    $scope.pageChanged = function() {
                        $stateParams.page = $scope.currentPage;

                        $scope.loadData();
                    };

                    $scope.loadData();
                }
            })

            .state(
                    'crgos.detalle',
                    {
                        url : '/detalle/:crgvId',
                        views : {
                            '' : {
                                templateUrl : 'modules/facturacion/crgo-detalle.html',
                                controller : function($http, $scope, $state, $stateParams) {
                                    var url = "facturacion/crgo-detalle.action?crgo.crgv.id=" + $stateParams.crgvId;

                                    $http.get(url).success(
                                            function(data) {
                                                $scope.crgo = data.crgo;

                                                var urlRgla = "facturacion/rgla-listado.action?rglaCriterio.crgoId="
                                                        + $scope.crgo.id + "&rglaCriterio.fechaVigencia="
                                                        + $scope.crgo.crgv.fini + "&page=1";

                                                $http.get(urlRgla).success(function(data) {
                                                    $scope.rglaList = data.rglaList;
                                                });
                                            });

                                    $scope.editar = function() {
                                        alert("Editar: " + $stateParams.crgvId);

                                        $state.go('crgos.editar', $stateParams);
                                    };
                                }
                            }
                        }
                    })
        });
