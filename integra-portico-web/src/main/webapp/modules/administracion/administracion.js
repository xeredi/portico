var module = angular.module("administracion", [ "ngRoute" ]);

// ----------------- MENU PRINCIPAL --------------------------
// ----------------- MENU PRINCIPAL --------------------------
// ----------------- MENU PRINCIPAL --------------------------

module.config([ "$routeProvider", function($routeProvider) {
    $routeProvider

    .when("/administracion", {
        title : 'menu_administracion',
        templateUrl : "modules/administracion/administracion.html",
        controller : "administracionController"
    })
} ]);

module.controller("administracionController", function($scope, $http, $location) {
});

// ----------------- METAMODELO --------------------------
// ----------------- METAMODELO --------------------------
// ----------------- METAMODELO --------------------------
module.config([ "$routeProvider", function($routeProvider) {
    $routeProvider

    .when("/administracion/metamodelo/reload", {
        title : 'metamodelo_reload',
        templateUrl : "modules/administracion/metamodelo-reload.html",
        controller : "metamodeloReloadController"
    })
} ]);

module.controller("metamodeloReloadController", function($scope, $http, $location, $routeParams) {
    $scope.reload = function() {
        $http.get("administracion/metamodelo/reload.action").success(function(data) {
            $scope.actionErrors = data.actionErrors;

            if (data.actionErrors.length == 0) {
            }
        });
    }
});
