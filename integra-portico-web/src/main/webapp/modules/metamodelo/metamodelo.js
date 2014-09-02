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

    .when("/metamodelo/tpprs/edit/:entiId", {
        templateUrl : "modules/metamodelo/tppr-edit.html",
        controller : "tpprsEditController"
    })

    .when("/metamodelo/tpprs/create", {
        templateUrl : "modules/metamodelo/tppr-edit.html",
        controller : "tpprsCreateController"
    })

    .when("/metamodelo/entd/detail/:entiId/:tpdtId", {
        templateUrl : "modules/metamodelo/entd-detail.html",
        controller : "entdDetailController"
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

.controller("tpprsGridController", function($scope, $http, $location, $route, $routeParams) {
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

metamodelo.controller("tpprsDetailController", function($scope, $http, $location, $route, $routeParams) {
    console.log("tpprsDetailController");
    console.log($routeParams.entiId);

    var url = "metamodelo/tppr-detalle.action?enti.id=" + $routeParams.entiId;

    $http.get(url).success(function(data) {
        $scope.enti = data.enti;
        $scope.subentiList = data.subentiList;
    });
});

metamodelo.controller("tpprsEditController", function($scope, $http, $location, $route, $routeParams) {
    console.log("tpprsEditController");
    console.log($routeParams.entiId);

    var url = "metamodelo/tppr-modificar.action?enti.id=" + $routeParams.entiId;

    $http.get(url).success(function(data) {
        $scope.enti = data.enti;
        $scope.accion = data.accion;
    });

    $scope.submit = function(form) {
        var url = "metamodelo/tppr-guardar.action";

        $http.post(url, {
            enti : $scope.enti,
            accion : $scope.accion
        }).success(function(data) {
            if (data.actionErrors.length == 0) {
                $location.path("/metamodelo/tpprs/detail/" + data.enti.id);
            } else {
                $scope.actionErrors = data.actionErrors;
            }
        });
    }
});

metamodelo.controller("tpprsCreateController", function($scope, $http, $location, $route, $routeParams) {
    console.log("tpprsCreateController");

    var url = "metamodelo/tppr-alta.action";

    $http.get(url).success(function(data) {
        $scope.enti = data.enti;
        $scope.accion = data.accion;
    });

    $scope.submit = function(form) {
        var url = "metamodelo/tppr-guardar.action";

        $http.post(url, {
            enti : $scope.enti,
            accion : $scope.accion
        }).success(function(data) {
            if (data.actionErrors.length == 0) {
                $location.path("/metamodelo/tpprs/detail/" + data.enti.id);
            } else {
                $scope.actionErrors = data.actionErrors;
            }
        });
    }
});

metamodelo.controller("entdDetailController", function($scope, $http, $location, $route, $routeParams) {
    console.log("entdDetailController");
    console.log($routeParams.entiId);
    console.log($routeParams.tpdtId);

    var url = "metamodelo/entd-detalle.action?entd.entiId=" + $routeParams.entiId + "&entd.tpdt.id="
            + $routeParams.tpdtId;

    $http.get(url).success(function(data) {
        $scope.entd = data.entd;
    });
});
