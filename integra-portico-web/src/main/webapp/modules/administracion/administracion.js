angular.module("administracion", [ "ngRoute" ])

// ----------------- MENU PRINCIPAL --------------------------

.config([ "$routeProvider", function($routeProvider) {
    $routeProvider

    .when("/administracion", {
        title : 'sec_administracion',
        templateUrl : "modules/administracion/administracion.html",
        controller : "administracionController"
    })
} ])

.controller("administracionController", administracionController)

// ----------------- METAMODELO --------------------------

.config([ "$routeProvider", function($routeProvider) {
    $routeProvider

    .when("/administracion/metamodelo/reload", {
        title : 'metamodelo_reload',
        templateUrl : "modules/administracion/metamodelo-reload.html",
        controller : "metamodeloReloadController"
    })
} ])

.controller("metamodeloReloadController", metamodeloReloadController)

// ----------------- CONFIGURACION --------------------------

.config([ "$routeProvider", function($routeProvider) {
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
} ])

.controller("confGridController", confGridController)

.controller("confDetailController", confDetailController)

.controller("confEditController", confEditController)

// ----------------- MESSAGEI18N --------------------------

.config([ "$routeProvider", function($routeProvider) {
    $routeProvider

    .when("/administracion/m18n/:bundle/grid", {
        title : 'm18n_bundle_grid',
        templateUrl : "modules/administracion/m18n-grid.html",
        controller : "m18nGridController"
    })

    .when("/administracion/m18n/:bundle/detail/:key", {
        title : 'm18n_bundle_detail',
        templateUrl : "modules/administracion/m18n-detail.html",
        controller : "m18nDetailController"
    })
} ])

.controller("m18nGridController", m18nGridController);

function administracionController($scope, $http, $location) {
    $http.get("administracion/main.action").success(function(data) {
        $scope.actionErrors = data.actionErrors;

        if (data.actionErrors.length == 0) {
            $scope.bundleList = data.bundleList;
        }
    });
}

function metamodeloReloadController($scope, $http, $location, $routeParams) {
    $scope.reload = function() {
        $http.get("administracion/metamodelo/reload.action").success(function(data) {
            $scope.actionErrors = data.actionErrors;

            if (data.actionErrors.length == 0) {
            }
        });
    }
}

function confGridController($scope, $http, $location, $routeParams) {
    $http.get("administracion/configuracion/conf-grid.action").success(function(data) {
        $scope.actionErrors = data.actionErrors;

        if (data.actionErrors.length == 0) {
            $scope.confList = data.confList;
        }
    });
}

function confDetailController($scope, $http, $location, $routeParams) {
    $http.get("administracion/configuracion/conf-detail.action?conf.key=" + $routeParams.key).success(function(data) {
        $scope.actionErrors = data.actionErrors;

        if (data.actionErrors.length == 0) {
            $scope.conf = data.conf;
        }
    });
}

function confEditController($scope, $http, $location, $routeParams) {
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
}

function m18nGridController($scope, $http, $location, $routeParams) {
    $http.get("administracion/messagei18n/m18n-grid.action?bundle=" + $routeParams.bundle).success(function(data) {
        $scope.actionErrors = data.actionErrors;

        if (data.actionErrors.length == 0) {
            $scope.bundle = data.bundle;
            $scope.report = data.report;
        }
    });
}