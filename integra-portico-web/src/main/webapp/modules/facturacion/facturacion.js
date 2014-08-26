angular.module('facturacion', [ 'ui.router' ])

.config(
        function($stateProvider, $urlRouterProvider) {
            $stateProvider

            .state('vlrcs', {
                abstract : true,
                url : '/facturacion/vlrcs',
                templateUrl : 'modules/facturacion/vlrcs.html',
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

            .state(
                    'vlrcs.detalle',
                    {
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

                                    var urlVlrl = "facturacion/vlrl-listado.action?vlrlCriterio.vlrc.id="
                                            + $stateParams.vlrcId + "&page=1";

                                    $http.get(urlVlrl).success(function(data) {
                                        $scope.vlrlList = data.vlrlList;
                                    });

                                    $scope.editar = function() {
                                        alert("Editar: " + $stateParams.vlrcId);

                                        $state.go('vlrcs.editar', $stateParams);
                                    };
                                }
                            }
                        }
                    })

            .state('vlrls', {
                abstract : true,
                url : '/facturacion/vlrls',
                templateUrl : 'modules/facturacion/vlrls.html',
            })

            .state(
                    'vlrls.detalle',
                    {
                        url : '/detalle/:vlrlId',
                        views : {
                            '' : {
                                templateUrl : 'modules/facturacion/vlrl-detalle.html',
                                controller : function($http, $scope, $state, $stateParams) {
                                    var url = "facturacion/vlrl-detalle.action?vlrl.id=" + $stateParams.vlrlId;

                                    $http.get(url).success(
                                            function(data) {
                                                $scope.vlrl = data.vlrl;

                                                var urlVlrd = "facturacion/vlrd-listado.action?vlrdCriterio.vlrl.id="
                                                        + $scope.vlrl.id + "&page=1";

                                                $http.get(urlVlrd).success(function(data) {
                                                    $scope.vlrdList = data.vlrdList;
                                                });
                                            });

                                    $scope.editar = function() {
                                        alert("Editar: " + $stateParams.vlrlId);

                                        $state.go('vlrls.editar', $stateParams);
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

            .state('rglas', {
                abstract : true,
                url : '/facturacion/rglas',
                templateUrl : 'modules/facturacion/rglas.html'
            })

            .state(
                    'rglas.detalle',
                    {
                        url : '/detalle/:rglvId',
                        views : {
                            '' : {
                                templateUrl : 'modules/facturacion/rgla-detalle.html',
                                controller : function($http, $scope, $state, $stateParams) {
                                    var url = "facturacion/rgla-detalle.action?rgla.rglv.id=" + $stateParams.rglvId;

                                    $http.get(url).success(
                                            function(data) {
                                                $scope.rgla = data.rgla;

                                                var urlRgin = "facturacion/rgin-listado.action?rginCriterio.rgla1Id="
                                                        + $scope.rgla.id + "&rginCriterio.fechaVigencia="
                                                        + $scope.rgla.rglv.fini;

                                                $http.get(urlRgin).success(function(data) {
                                                    $scope.rginList = data.rginList;
                                                });

                                            });

                                    $scope.editar = function() {
                                        alert("Editar: " + $stateParams.rglvId);

                                        $state.go('crgos.editar', $stateParams);
                                    };
                                }
                            }
                        }
                    })
        });
