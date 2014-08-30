angular.module('maestro', [ 'ui.router' ])

.config(function($stateProvider, $urlRouterProvider) {
    $stateProvider

    .state('prmts', {
        abstract : true,
        url : '/maestro/prmts/:entiId',
        templateUrl : 'modules/maestro/prmts.html',
        controller : 'prmtsController'
    })

    .state('prmts.filter', {
        url : '/filter',
        templateUrl : 'modules/maestro/prmts-filter.html',
        controller : 'prmtsFilterController'
    })

    .state('prmts.filter.grid', {
        url : '/grid',
        templateUrl : 'modules/maestro/prmts-grid.html',
        controller : 'prmtsGridController'
    })

    .state('prmts.filter.grid.create', {
        url : '/grid',
        templateUrl : 'modules/maestro/prmts-edit.html'
    })

    .state('prmts.filter.grid.detail', {
        url : '/detail',
        templateUrl : 'modules/maestro/prmts-detail.html'
    })

    .state('prmts.filter.grid.detail.edit', {
        url : '/edit',
        templateUrl : 'modules/maestro/prmts-edit.html'
    })

    .state('prmts.filter.grid.detail.duplicate', {
        url : '/duplicate',
        templateUrl : 'modules/maestro/prmts-edit.html'
    })

    .state('prmts.filter.grid.detail.delete', {
        url : '/delete'
    })

    .state('prmts.filter.grid.delete', {
        url : '/delete'
    })
})

.controller('prmtsController', function($scope, $http, $state, $stateParams) {
    // console.log('En el controlador: ' + $stateParams.entiId);

    if ($stateParams.entiId != null && ($scope.enti == null || $stateParams.entiId != $scope.enti.id)) {
        // console.log('Busqueda de la estructura de la entidad');
        $scope.itemCriterio = {
                entiId : $stateParams.entiId
            };

        var url = "metamodelo/tppr-proxy-detalle.action?tppr.id=" + $stateParams.entiId;

        $http.get(url).success(function(data) {
            // console.log('data: ' + JSON.stringify(data));

            $scope.enti = data.tppr;
            $scope.entiHijasList = data.tpspList;
        });
    }
})

.controller('prmtsFilterController', function($scope, $http, $state, $stateParams) {
    console.log('En el controlador de prmtsFilter: ' + JSON.stringify($stateParams));
    console.log('En el controlador de prmtsFilter: ' + JSON.stringify($scope.itemCriterio));
    console.log('En el controlador de prmtsFilter: ' + JSON.stringify($scope.limit));
    console.log('En el controlador de prmtsFilter: ' + JSON.stringify($scope.page));

    var url = "maestro/prmt-filtro.action?itemCriterio.entiId=" + $stateParams.entiId;

    $http.get(url).success(function(data) {
        console.log('data: ' + JSON.stringify(data));
        $scope.itemCriterio = data.itemCriterio;
        $scope.limits = data.limits;
        $scope.limit = data.limit;
        $scope.page = data.page;
        $scope.labelValuesMap = data.labelValuesMap;
    });
})

.controller('prmtsGridController', function($scope, $http, $state, $stateParams) {
    console.log('En el controlador de prmtsGrid: ' + JSON.stringify($stateParams));
    console.log('En el controlador de prmtsGrid: ' + JSON.stringify($scope.itemCriterio));
    console.log('En el controlador de prmtsGrid: ' + JSON.stringify($scope.limit));
    console.log('En el controlador de prmtsGrid: ' + JSON.stringify($scope.page));

    $scope.loadPage = function() {
        var url = "maestro/prmt-listado.action";

        $http.post(url, {
            itemCriterio : $scope.itemCriterio,
            limit : $scope.limit,
            page : $scope.page
        }).success(function(data) {
            $scope.itemList = data.itemList;
        });
    };

    $scope.pageChanged = function() {
//        $scope.page = $scope.currentPage;

        console.log('New page: ' + $scope.page);

        $scope.loadPage();
    };

    $scope.loadPage();
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
