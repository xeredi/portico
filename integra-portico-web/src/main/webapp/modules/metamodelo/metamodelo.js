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

    .when("/metamodelo/tpprs/detail/:entiId", {
        templateUrl : "modules/metamodelo/tppr-detail.html",
        controller : "tpprsDetailController"
    })

    .otherwise({
        redirectTo : "/phones"
    });
} ])

.controller("tpprsFilterController", function($scope, $http, $location) {
    console.log("tpprsFilterController");

    $scope.submit = function(form) {
        console.log("tpprsFilterController Submit");
        console.log($scope.entiCriterio);
        console.log(JSON.stringify($scope.entiCriterio));
        console.log($scope.page);

        $location.path("/metamodelo/tpprs/grid").search({
            entiCriterio : {
                codigo : $scope.entiCriterio.codigo,
                nombre : $scope.entiCriterio.nombre
            },
            page : $scope.page
        });
    }

    $scope.page = 1;
    $scope.limit = 20;
})

.controller("tpprsGridController", function($scope, $http, $route, $routeParams) {
    console.log("tpprsGridController");
    console.log($routeParams.entiCriterio);

    $scope.entiCriterio = $routeParams.entiCriterio;
    $scope.page = $routeParams.page;

    console.log($scope.entiCriterio);

    var url = "metamodelo/tppr-listado.action";

    $http.post(url, {
        entiCriterio : $scope.entiCriterio,
        limit : $scope.limit,
        page : $scope.page
    }).success(function(data) {
        $scope.entiList = data.entiList;
    });
});

metamodelo.controller("tpprsDetailController", function($scope, $http, $route, $routeParams) {
    console.log("tpprsDetailController");
    console.log($routeParams.entiId);

    var url = "metamodelo/tppr-detalle.action?enti.id=" + $routeParams.entiId;

    $http.get(url).success(function(data) {
        $scope.enti = data.enti;
        $scope.subentiList = data.subentiList;
    });
});
