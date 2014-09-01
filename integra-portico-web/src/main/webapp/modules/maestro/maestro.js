angular.module('maestro', [ 'ui.router' ])

// http://es.slideshare.net/kennystoltz/angular-js-routing

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

    .state('prmts.deleteList', {
        parent : 'prmts.grid',
        url : '/delete'
    })

    .state('prmts.grid.detail', {
        parent : 'prmts.grid',
        url : '/detail/:itemId',
        templateUrl : 'modules/maestro/prmts-grid-detail.html',
        controller : 'prmtsDetailController'
    })

    .state('prmts.edit', {
        parent : 'prmts.grid.detail',
        url : '/edit',
        templateUrl : 'modules/maestro/prmts-edit.html',
        controller : 'prmtsEditController'
    })

    .state('prmts.duplicate', {
        parent : 'prmts.grid.detail',
        url : '/duplicate',
        templateUrl : 'modules/maestro/prmts-edit.html',
        controller : 'prmtsDuplicateController'
    })

    .state('prmts.delete', {
        parent : 'prmts.grid.detail',
        url : '/delete'
    })

    .state('prmts.create', {
        parent : 'prmts',
        url : '/create',
        templateUrl : 'modules/maestro/prmts-edit.html',
        controller : 'prmtsCreateController'
    })
})

.controller('prmtsController', function($scope, $http, $state, $stateParams) {
    if ($stateParams.entiId != null && ($scope.enti == null || $stateParams.entiId != $scope.enti.id)) {
        var url = "metamodelo/tppr-proxy-detalle.action?tppr.id=" + $stateParams.entiId;

        $http.get(url).success(function(data) {
            // console.log('data: ' + JSON.stringify(data));
            $scope.enti = data.tppr;
            $scope.entiHijasList = data.tpspList;
        });
    }
})

.controller('prmtsFilterController', function($scope, $http, $state, $stateParams) {
    var url = "maestro/prmt-filtro.action?itemCriterio.entiId=" + $stateParams.entiId;

    $http.get(url).success(function(data) {
        // console.log('data: ' + JSON.stringify(data));
        $scope.itemCriterio = data.itemCriterio;
        $scope.limits = data.limits;
        $scope.labelValuesMap = data.labelValuesMap;
    });
})

.controller('prmtsGridController', function($scope, $http, $state, $stateParams) {
    $scope.loadPage = function() {
        console.log('loadPage - page: ' + $scope.page);
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
        $scope.loadPage();
    };

    $scope.loadPage();
})

.controller('prmtsCreateController', function($scope, $http, $state, $stateParams) {
    var url = "maestro/prmt-crear.action?item.entiId=" + $stateParams.entiId;

    $http.get(url).success(function(data) {
        $scope.item = data.item;
        $scope.p18nMap = data.p18nMap;
        $scope.availableLanguages = data.availableLanguages;
        $scope.accion = data.accion;
    });
})

.controller('prmtsDetailController', function($scope, $http, $state, $stateParams) {
    var url = "maestro/prmt-detalle.action?item.id=" + $stateParams.itemId;

    $http.get(url).success(function(data) {
        $scope.item = data.item;
        $scope.p18nMap = data.p18nMap;
        $scope.availableLanguages = data.availableLanguages;
    });
})

.controller('prmtsEditController', function($scope, $http, $state, $stateParams) {
    var url = "maestro/prmt-editar.action?item.id=" + $stateParams.itemId;

    $http.get(url).success(function(data) {
        $scope.item = data.item;
        $scope.p18nMap = data.p18nMap;
        $scope.availableLanguages = data.availableLanguages;
        $scope.accion = data.accion;
    });
})

.controller('prmtsDuplicateController', function($scope, $http, $state, $stateParams) {
    var url = "maestro/prmt-duplicar.action?item.id=" + $stateParams.itemId;

    $http.get(url).success(function(data) {
        $scope.item = data.item;
        $scope.p18nMap = data.p18nMap;
        $scope.availableLanguages = data.availableLanguages;
        $scope.accion = data.accion;
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
