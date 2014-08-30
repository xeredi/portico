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
        parent : 'prmts',
        url : '/filter',
        templateUrl : 'modules/maestro/prmts-filter.html',
        controller : 'prmtsFilterController'
    })

    .state('prmts.grid', {
        parent : 'prmts.filter',
        url : '/grid',
        templateUrl : 'modules/maestro/prmts-grid.html',
        controller : 'prmtsGridController'
    })

    .state('prmts.create', {
        parent : 'prmts.grid',
        url : '/grid',
        templateUrl : 'modules/maestro/prmts-edit.html'
    })

    .state('prmts.detail', {
        parent : 'prmts.grid',
        url : '/detail/:itemId',
        templateUrl : 'modules/maestro/prmts-detail.html',
        controller : 'prmtsDetailController'
    })

    .state('prmts.edit', {
        parent : 'prmts.detail',
        url : '/edit',
        templateUrl : 'modules/maestro/prmts-edit.html'
    })

    .state('prmts.duplicate', {
        parent : 'prmts.detail',
        url : '/duplicate',
        templateUrl : 'modules/maestro/prmts-edit.html'
    })

    .state('prmts.delete', {
        parent : 'prmts.detail',
        url : '/delete'
    })

    .state('prmts.deleteList', {
        parent : 'prmts.grid',
        url : '/delete'
    })
})

.controller('prmtsController', function($scope, $http, $state, $stateParams) {
    console.log('En el controlador Principal: ' + JSON.stringify($stateParams));

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
        // $scope.page = data.page;
        // $scope.currentPage = data.page;
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
        $scope.page = $scope.currentPage;

        console.log('New page: ' + $scope.page);

        $scope.loadPage();
    };

    $scope.loadPage();
})

.controller('prmtsDetailController', function($scope, $http, $state, $stateParams) {
    console.log('En el controlador de prmtsDetail: ' + JSON.stringify($stateParams));
    console.log('En el controlador de prmtsDetail: ' + JSON.stringify($scope.itemCriterio));
    console.log('En el controlador de prmtsDetail: ' + JSON.stringify($scope.limit));
    console.log('En el controlador de prmtsDetail: ' + JSON.stringify($scope.page));

    var url = "maestro/prmt-detalle.action?item.id=" + $stateParams.itemId;

    $http.get(url).success(function(data) {
        $scope.item = data.item;
        $scope.p18nMap = data.p18nMap;
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
