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

    .state('prmts.grid', {
        url : '/grid',
        templateUrl : 'modules/maestro/prmts-grid.html',
        controller : 'prmtsGridController'
    })

    .state('prmts.grid.create', {
        url : '/grid',
        templateUrl : 'modules/maestro/prmts-edit.html'
    })

    .state('prmts.grid.detail', {
        url : '/detail',
        templateUrl : 'modules/maestro/prmts-detail.html'
    })

    .state('prmts.grid.detail.edit', {
        url : '/edit',
        templateUrl : 'modules/maestro/prmts-edit.html'
    })

    .state('prmts.grid.detail.duplicate', {
        url : '/duplicate',
        templateUrl : 'modules/maestro/prmts-edit.html'
    })

    .state('prmts.grid.detail.delete', {
        url : '/delete'
    })

    .state('prmts.grid.delete', {
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
        $scope.page = 1;
        $scope.limit = 20;

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
    var url = "maestro/prmt-filtro.action?itemCriterio.entiId=" + $stateParams.entiId;

    $http.get(url).success(function(data) {
        // console.log('data: ' + JSON.stringify(data));
        $scope.limits = data.limits;
        $scope.labelValuesMap = data.labelValuesMap;
    });

    $scope.buscar = function() {
        console.log('itemCriterio: ' + JSON.stringify($scope.itemCriterio));

        $state.go('prmts.grid');
    };
})

.controller('prmtsGridController', function($scope, $http, $state, $stateParams) {
    console.log('En el controlador de prmtsGrid: ' + JSON.stringify($stateParams));
    console.log('En el controlador de prmtsGrid: ' + JSON.stringify($scope.itemCriterio));

    var url = "maestro/prmt-listado.action";

    $http.post(url, {
        itemCriterio : $scope.itemCriterio
    }).success(function(data) {
        console.log('data: ' + JSON.stringify(data));

        $scope.itemList = data.itemList;
    });
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
