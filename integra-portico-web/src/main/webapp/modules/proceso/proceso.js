var module = angular.module("proceso", [ "ngRoute" ]);

module.config([ "$routeProvider", function($routeProvider) {
    $routeProvider

    .when("/proceso/prbt/grid", {
        title : 'prbt_grid',
        templateUrl : "modules/proceso/prbt-grid.html",
        controller : "prbtGridController",
        reloadOnSearch : false
    })

    .when("/proceso/prbt/detail/:prbtId", {
        title : 'prbt_detail',
        templateUrl : "modules/proceso/prbt-detail.html",
        controller : "prbtDetailController"
    })
} ]);

module.controller("prbtGridController", function($scope, $http, $location, $route, $routeParams) {
    $scope.showFilter = false;
    $scope.prbtCriterio = {};

    function search(prbtCriterio, page, limit) {
        var url = "proceso/prbt-list.action";

        $scope.limit = limit;

        $http.post(url, {
            prbtCriterio : prbtCriterio,
            page : page,
            limit : limit
        }).success(function(data) {
            $scope.actionErrors = data.actionErrors;

            if (data.actionErrors.length == 0) {
                $scope.page = data.prbtList.page;
                $scope.prbtList = data.prbtList;
                $scope.prbtCriterio = data.prbtCriterio;

                var map = {};

                map["page"] = data.prbtList.page;

                $location.search(map).replace();

                $scope.showFilter = false;
            }
        });
    }

    $scope.pageChanged = function() {
        console.log("pageChanged: " + $scope.page);
        console.log("limit: " + $scope.limit);

        search($scope.prbtCriterio, $scope.page, $scope.limit);
    }

    $scope.filter = function() {
        var url = "proceso/prbt-filter.action";

        $http.get(url).success(function(data) {
            $scope.actionErrors = data.actionErrors;

            if (data.actionErrors.length == 0) {
                $scope.labelValuesMap = data.labelValuesMap;
                $scope.limits = data.limits;
            }
        });

        $scope.showFilter = true;
    }

    $scope.search = function() {
        search($scope.prbtCriterio, 1, $scope.limit);
    }

    $scope.cancelSearch = function() {
        $scope.showFilter = false;
    }

    search($scope.prbtCriterio, $routeParams.page ? $routeParams.page : 1, $scope.limit ? $scope.limit : 20);
});

module.controller("prbtDetailController", function($scope, $http, $location, $route, $routeParams) {
    function findItem() {
        {
            var url = "proceso/prbt-detail.action?prbt.id=" + $routeParams.prbtId;

            $http.get(url).success(function(data) {
                $scope.prbt = data.prbt;
            });
        }
        {
            var url = "proceso/prmn-list.action?prbtId=" + $routeParams.prbtId;

            $http.get(url).success(function(data) {
                $scope.prmnList = data.prmnList;
            });
        }
    }

    findItem();
});
