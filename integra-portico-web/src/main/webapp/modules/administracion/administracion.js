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

// ----------------- CONFIGURACION --------------------------
// ----------------- CONFIGURACION --------------------------
// ----------------- CONFIGURACION --------------------------
module.config([ "$routeProvider", function($routeProvider) {
    $routeProvider

    .when("/administracion/conf/grid", {
        title : 'conf_grid',
        templateUrl : "modules/administracion/conf-grid.html",
        controller : "confGridController"
    }).when("/administracion/conf/detail/:key", {
        title : 'conf_detail',
        templateUrl : "modules/administracion/conf-detail.html",
        controller : "confDetailController"
    }).when("/administracion/conf/edit/:key", {
        title : 'conf_edit',
        templateUrl : "modules/administracion/conf-edit.html",
        controller : "confEditController"
    })
} ]);

module.controller("confGridController", function($scope, $http, $location, $routeParams) {
    $http.get("administracion/configuracion/conf-grid.action").success(function(data) {
        $scope.actionErrors = data.actionErrors;

        if (data.actionErrors.length == 0) {
            $scope.confList = data.confList;
        }
    });
});

module.controller("confDetailController", function($scope, $http, $location, $routeParams) {
    $http.get("administracion/configuracion/conf-detail.action?conf.key=" + $routeParams.key).success(function(data) {
        $scope.actionErrors = data.actionErrors;

        if (data.actionErrors.length == 0) {
            $scope.conf = data.conf;
        }
    });
});

module.controller("confEditController", function($scope, $http, $location, $routeParams) {
    $http.get("administracion/configuracion/conf-edit.action?conf.key=" + $routeParams.key).success(function(data) {
        $scope.actionErrors = data.actionErrors;

        if (data.actionErrors.length == 0) {
            $scope.accion = data.accion;
            $scope.conf = data.conf;
        }
    });

    $scope.save = function() {
        $http.post("administracion/configuracion/conf-save.action", {
            conf : $scope.conf,
            accion : $scope.accion
        }).success(function(data) {
            $scope.actionErrors = data.actionErrors;

            if (data.actionErrors.length == 0) {
                setTimeout(function() {
                    window.history.back();
                }, 0);
            }
        });
    }

    $scope.cancel = function() {
        window.history.back();
    }
});
