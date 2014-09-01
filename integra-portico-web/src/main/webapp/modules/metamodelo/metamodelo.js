var metamodelo = angular.module("metamodelo", [ "ngRoute" ]);

metamodelo.config([ "$routeProvider", function($routeProvider) {
    console.log("metamodelo config");

    $routeProvider.when("/metamodelo/tpprs", {
        templateUrl : "modules/metamodelo/tppr-filter.html",
        controller : "tpprsFilterController"
    })

    .when("/metamodelo/tpprs/grid", {
        templateUrl : "modules/metamodelo/tppr-grid.html",
        controller : "tpprsGridController"
    })
    /*
     * .when("/metamodelo/tpprs/detail/:tpprId", { templateUrl :
     * "modules/metamodelo/tppr-detail.html", controller :
     * "tpprsDetailController" }) .otherwise({ redirectTo : "/phones" })
     */;
} ])

.controller("tpprsFilterController", function($scope, $http) {
    console.log("tpprsFilterController");

    $scope.submit = function(form) {
        console.log("tpprsFilterController Submit");
        console.log($scope.entiCriterio);
        console.log($scope.page);

        var url = "metamodelo/tppr-listado.action";

        $http.post(url, {
            entiCriterio : $scope.entiCriterio,
            limit : $scope.limit,
            page : $scope.page
        }).success(function(data) {
            $scope.entiList = data.entiList;
        });

    }

    $scope.page = 1;
    $scope.limit = 20;
})

.controller("tpprsGridController", function($scope, $http, $route, $routeParams) {
    console.log("tpprsGridController");
});

/*
 * metamodelo.controller("tpprsDetailController", function($scope, $http,
 * $route, $routeParams) { console.log("tpprsDetailController"); });
 */