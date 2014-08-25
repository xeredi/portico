angular.module('facturacion', [ 'ui.router' ])


.config(function($stateProvider, $urlRouterProvider) {
    $stateProvider

    .state('vlrcs', {
        abstract : true,
        url : '/facturacion/vlrcs',
        templateUrl : 'modules/facturacion/vlrcs.html'
    })

    .state(
            'vlrcs.list',
            {
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
})
;
