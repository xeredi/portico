var module = angular.module("estadistica", [ "ngRoute" ]);

module.config([ "$routeProvider", function($routeProvider) {
    $routeProvider

    .when("/estadistica/pepr/grid", {
        title : 'pepr_grid',
        templateUrl : "modules/entidad/estadistica/pepr-grid.html",
        controller : "peprGridController"
    })

    .when("/estadistica/pepr/detail/:peprId", {
        title : 'pepr_detail',
        templateUrl : "modules/entidad/estadistica/pepr-detail.html",
        controller : "peprDetailController"
    })

    .when("/estadistica/cdms/detail/:peprId", {
        title : 'cdms_detail',
        templateUrl : "modules/entidad/estadistica/cdms-detail.html",
        controller : "cdmsDetailController"
    })

    .when("/estadistica/estd/grid/:entiId/:peprId", {
        title : 'estd_grid',
        templateUrl : "modules/entidad/estadistica/estd-grid.html",
        controller : "estdGridController"
    })

    .when("/estadistica/estd/detail/:itemId", {
        title : 'estd_detail',
        templateUrl : "modules/entidad/estadistica/estd-detail.html",
        controller : "estdDetailController"
    })
} ]);

module.controller("peprGridController", function($scope, $http, $location, $route, $routeParams) {
    loaded = false;

    $scope.showFilter = false;
    $scope.page = $routeParams.page ? $routeParams.page : 1;
    $scope.limit = 20;

    var url = "estadistica/pepr-list.action";

    $http.post(url, {
        peprCriterio : $scope.peprCriterio,
        limit : $scope.limit,
        page : $scope.page
    }).success(function(data) {
        $scope.peprList = data.peprList;
        $scope.page = data.page;
        $scope.currentPage = data.page;
        $scope.limit = data.itemList.limit;
        loaded = true;
    });

    $scope.pageChanged = function() {
        if (loaded) {
            $location.search({
                page : $scope.currentPage
            }).replace();
        }
    }

    $scope.filter = function() {
        $scope.showFilter = true;
    }

    $scope.search = function() {
        $location.path("/estadistica/pepr/grid").replace();
    }

    $scope.cancelSearch = function() {
        $scope.showFilter = false;
    }
});

module.controller("peprDetailController", function($scope, $http, $location, $route, $routeParams) {
    var url = "estadistica/pepr-detail.action";

    url += "?pepr.id=" + $routeParams.peprId;

    $http.get(url).success(function(data) {
        $scope.pepr = data.pepr;
        $scope.tpesList = data.tpesList;
    });

    $scope.remove = function() {
        if (confirm("Are you sure?")) {
            var url = "estadistica/pepr-remove.action?pepr.id=" + $scope.pepr.id;

            $http.get(url).success(function(data) {
                if (data.actionErrors.length == 0) {
                    window.history.back();
                } else {
                    $scope.actionErrors = data.actionErrors;
                }
            });
        }
    }
});

module.controller("cdmsDetailController", function($scope, $http, $location, $route, $routeParams) {
    var url = "estadistica/cdms-detail.action";

    url += "?pepr.id=" + $routeParams.peprId;

    $http.get(url).success(function(data) {
        $scope.pepr = data.pepr;
        $scope.cdmsMap = data.cdmsMap;
    });
});

module.controller("estdGridController", function($scope, $http, $location, $route, $routeParams) {
    loaded = false;

    $scope.showFilter = false;
    $scope.page = $routeParams.page ? $routeParams.page : 1;
    $scope.limit = 20;

    var url = "estadistica/estd-list.action?itemCriterio.entiId=" + $routeParams.entiId + "&itemCriterio.pepr.id="
            + $routeParams.peprId + "&page=" + $scope.page;

    $http.get(url).success(function(data) {
        $scope.itemList = data.itemList;
        $scope.enti = data.enti;
        $scope.page = data.page;
        $scope.currentPage = data.page;
        $scope.limit = data.itemList.limit;
        loaded = true;
    });

    $scope.pageChanged = function() {
        if (loaded) {
            $location.search({
                page : $scope.currentPage
            }).replace();
        }
    }

    $scope.filter = function() {
        $scope.showFilter = true;
    }

    $scope.search = function() {
        $location.path("/estadistica/estd/grid").replace();
    }

    $scope.cancelSearch = function() {
        $scope.showFilter = false;
    }
});

module.controller("estdDetailController", function($scope, $http, $location, $route, $routeParams) {
    var url = "estadistica/estd-detail.action?item.id=" + $routeParams.itemId;

    $http.get(url).success(function(data) {
        $scope.enti = data.enti;
        $scope.item = data.item;
        $scope.fechaVigencia = data.fechaVigencia;
    });
});
