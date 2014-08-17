angular.module('metamodelo', [ 'ui.router' ])

.config(function($stateProvider, $urlRouterProvider) {
    /*
     * $stateProvider
     *
     * .state('tpdts', { abstract : true, url : '/metamodelo/tpdts', templateUrl :
     * 'modules/metamodelo/tpdts.html' })
     *
     * .state( 'tpdts.list', { url : '/:page', templateUrl :
     * 'modules/metamodelo/tpdt-listado.html',
     *
     * controller : function($http, $scope, $stateParams) { $scope.loadData =
     * function() { var url = "metamodelo/tpdt-listado-json.action?page=" +
     * $stateParams.page;
     *
     * $http.get(url).success(function(data) { // console.log(data); $scope.enti =
     * data.enti; $scope.itemList = data.itemList; $scope.itemCriterio =
     * data.itemCriterio; }); };
     *
     * $scope.pageChanged = function() { $stateParams.page = $scope.currentPage;
     *
     * $scope.loadData(); };
     *
     * $scope.loadData(); } })
     *
     */});
