angular.module('facturacion', [ 'ui.router' ])

.config(function($stateProvider, $urlRouterProvider) {
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
});
