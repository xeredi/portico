var facturacion = angular.module("facturacion", [ "ngRoute" ]);

facturacion.config([ "$routeProvider", function($routeProvider) {
    $routeProvider

    .when("/facturacion", {
        templateUrl : "modules/facturacion/facturacion.html",
        controller : "facturacionController"
    })

    // ----------- VALORACION ------------------

    .when("/facturacion/vlrc", {
        templateUrl : "modules/facturacion/vlrc-filter.html",
        controller : "vlrcFilterController"
    })

    .when("/facturacion/vlrc/grid", {
        templateUrl : "modules/facturacion/vlrc-grid.html",
        controller : "vlrcGridController"
    })

    .when("/facturacion/vlrc/detail/:vlrcId", {
        templateUrl : "modules/facturacion/vlrc-detail.html",
        controller : "vlrcDetailController"
    })

    .when("/facturacion/vlrc/edit/:vlrcId", {
        templateUrl : "modules/facturacion/vlrc-edit.html",
        controller : "vlrcEditController"
    })

    .when("/facturacion/vlrl/detail/:vlrlId", {
        templateUrl : "modules/facturacion/vlrl-detail.html",
        controller : "vlrlDetailController"
    })

    .when("/facturacion/vlrl/edit/:vlrlId", {
        templateUrl : "modules/facturacion/vlrl-edit.html",
        controller : "vlrlEditController"
    })

    .when("/facturacion/vlrd/detail/:vlrdId", {
        templateUrl : "modules/facturacion/vlrd-detail.html",
        controller : "vlrdDetailController"
    })

    .when("/facturacion/vlrd/edit/:vlrdId", {
        templateUrl : "modules/facturacion/vlrd-edit.html",
        controller : "vlrdEditController"
    })

} ]);

// ----------------- CONTROLLERS --------------------------
// ----------------- CONTROLLERS --------------------------
// ----------------- CONTROLLERS --------------------------

facturacion.controller("facturacionController", function($scope, $http, $location) {
});

// ----------- VALORACION ------------------

facturacion.controller("vlrcFilterController", function($scope, $http, $location) {
    $scope.submit = function() {
        $location.path("/facturacion/vlrc/grid").search({
            vlrcCriterio : {},
            page : $scope.page
        });
    }

    $scope.page = 1;
    $scope.limit = 20;
});

facturacion.controller("vlrcGridController", function($scope, $http, $location, $route, $routeParams) {
    $scope.vlrcCriterio = $routeParams.vlrcCriterio;
    $scope.page = $routeParams.page;

    var url = "facturacion/vlrc-list.action";

    $http.get(url, {
        vlrcCriterio : $scope.vlrcCriterio,
        limit : $scope.limit,
        page : $scope.page
    }).success(function(data) {
        $scope.vlrcList = data.vlrcList;
    });
});

facturacion.controller("vlrcDetailController", function($scope, $http, $location, $route, $routeParams) {
    var url = "facturacion/vlrc-detail.action?vlrc.id=" + $routeParams.vlrcId;

    $http.get(url).success(function(data) {
        $scope.vlrc = data.vlrc;
        $scope.vlrgList = data.vlrgList;
        $scope.vlriList = data.vlriList;
    });

    var urlVlrlList = "facturacion/vlrl-list.action?vlrlCriterio.vlrc.id=" + $routeParams.vlrcId;

    $http.get(urlVlrlList).success(function(data) {
        $scope.vlrlList = data.vlrlList;
    });
});

facturacion.controller("vlrlDetailController", function($scope, $http, $location, $route, $routeParams) {
    var url = "facturacion/vlrl-detail.action?vlrl.id=" + $routeParams.vlrlId;

    $http.get(url).success(function(data) {
        $scope.vlrl = data.vlrl;
    });

    var urlVlrdList = "facturacion/vlrd-list.action?vlrdCriterio.vlrl.id=" + $routeParams.vlrlId;

    $http.get(urlVlrdList).success(function(data) {
        $scope.vlrdList = data.vlrdList;
    });
});

facturacion.controller("vlrdDetailController", function($scope, $http, $location, $route, $routeParams) {
    var url = "facturacion/vlrd-detail.action?vlrd.id=" + $routeParams.vlrdId;

    $http.get(url).success(function(data) {
        $scope.vlrd = data.vlrd;
    });
});
