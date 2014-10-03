var module = angular.module("estadistica", [ "ngRoute" ]);

module.config([ "$routeProvider", function($routeProvider) {
    $routeProvider

    .when("/estadistica/pepr/grid", {
        title : 'pepr_grid',
        templateUrl : "modules/entidad/estadistica/pepr-grid.html",
        controller : "peprGridController",
        reloadOnSearch : false
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
        controller : "estdGridController",
        reloadOnSearch : false
    })

    .when("/estadistica/estd/detail/:entiId/:itemId", {
        title : 'estd_detail',
        templateUrl : "modules/entidad/estadistica/estd-detail.html",
        controller : "estdDetailController"
    })
} ]);

module.controller("peprGridController", function($scope, $http, $location, $route, $routeParams) {
    $scope.showFilter = false;
    $scope.peprCriterio = {};

    function search(peprCriterio, page, limit) {
        var url = "estadistica/pepr-list.action";

        $http.post(url, {
            peprCriterio : peprCriterio,
            page : page,
            limit : limit
        }).success(function(data) {
            if (data.actionErrors.length == 0) {
                $scope.page = data.peprList.page;
                $scope.peprList = data.peprList;

                var map = {};

                map["page"] = data.peprList.page;

                $location.search(map).replace();
            } else {
                $scope.actionErrors = data.actionErrors;
            }
        });
    }

    $scope.pageChanged = function() {
        search($scope.peprCriterio, $scope.page, $scope.limit);
    }

    $scope.filter = function() {
        $scope.showFilter = true;
    }

    $scope.search = function() {
        search($scope.peprCriterio, 1, $scope.limit);
    }

    $scope.cancelSearch = function() {
        $scope.showFilter = false;
    }

    search($scope.peprCriterio, $routeParams.page ? $routeParams.page : 1, $scope.limit);
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
    $scope.showFilter = false;
    $scope.itemCriterio = {};
    $scope.itemCriterio.entiId = $routeParams.entiId;
    $scope.itemCriterio.pepr = {};
    $scope.itemCriterio.pepr.id = $routeParams.peprId;

    function search(itemCriterio, page, limit) {
        var url = "estadistica/estd-list.action";

        $http.post(url, {
            itemCriterio : itemCriterio,
            page : page,
            limit : limit
        }).success(function(data) {
            if (data.actionErrors.length == 0) {
                $scope.page = data.itemList.page;
                $scope.itemList = data.itemList;

                var map = {};

                map["page"] = data.itemList.page;

                $location.search(map).replace();
            } else {
                $scope.actionErrors = data.actionErrors;
            }
        });
    }

    $scope.pageChanged = function() {
        search($scope.itemCriterio, $scope.page, $scope.limit);
    }

    $scope.filter = function() {
        $scope.showFilter = true;
    }

    $scope.search = function() {
        search($scope.itemCriterio, 1, $scope.limit);
    }

    $scope.cancelSearch = function() {
        $scope.showFilter = false;
    }

    function findEnti() {
        var url = "metamodelo/tpes-proxy-detail.action?enti.id=" + $routeParams.entiId;

        $http.get(url).success(function(data) {
            $scope.enti = data.enti;
        });
    }

    findEnti();
    search($scope.itemCriterio, $routeParams.page ? $routeParams.page : 1, $scope.limit);
});

module.controller("estdDetailController", function($scope, $http, $location, $route, $routeParams) {
    function findEnti() {
        var url = "metamodelo/tpes-proxy-detail.action?enti.id=" + $routeParams.entiId;

        $http.get(url).success(function(data) {
            $scope.enti = data.enti;
        });
    }

    function findItem() {
        var url = "estadistica/estd-detail.action?item.id=" + $routeParams.itemId;

        $http.get(url).success(function(data) {
            $scope.item = data.item;
            $scope.fechaVigencia = data.fechaVigencia;
        });
    }

    findEnti();
    findItem();
});
