angular.module("administracion", [])

.config(config)

// ----------------- MENU PRINCIPAL --------------------------
.controller("AdministracionController", AdministracionController)

// ----------------- METAMODELO --------------------------
.controller("MetamodeloReloadController", MetamodeloReloadController)

// ----------------- CONFIGURACION --------------------------
.controller("ConfGridController", ConfGridController)

.controller("ConfDetailController", ConfDetailController)

.controller("ConfEditController", ConfEditController)

// ----------------- MESSAGEI18N --------------------------
.controller("M18nGridController", M18nGridController)

.controller("M18nDetailController", M18nDetailController)

.controller("M18nEditController", M18nEditController)

// ----------------- SCHEDULER --------------------------
.controller("SchrDetailController", SchrDetailController)

;

function config($routeProvider) {
    $routeProvider

    .when("/administracion", {
        title : 'sec_administracion',
        templateUrl : "modules/administracion/administracion.html",
        controller : "AdministracionController",
        controllerAs : "vm"
    })

    .when("/administracion/metamodelo/reload", {
        title : 'metamodelo_reload',
        templateUrl : "modules/administracion/metamodelo-reload.html",
        controller : "MetamodeloReloadController",
        controllerAs : "vm"
    })

    .when("/administracion/conf/grid", {
        title : 'conf_grid',
        templateUrl : "modules/administracion/conf-grid.html",
        controller : "ConfGridController",
        controllerAs : "vm"
    }).when("/administracion/conf/detail/:key", {
        title : 'conf_detail',
        templateUrl : "modules/administracion/conf-detail.html",
        controller : "ConfDetailController",
        controllerAs : "vm"
    }).when("/administracion/conf/edit/:accion/:key?", {
        title : 'conf_edit',
        templateUrl : "modules/administracion/conf-edit.html",
        controller : "ConfEditController",
        controllerAs : "vm"
    })

    .when("/administracion/m18n/grid", {
        title : 'm18nList',
        templateUrl : "modules/administracion/m18n-grid.html",
        controller : "M18nGridController",
        controllerAs : "vm"
    }).when("/administracion/m18n/detail/:key", {
        title : 'm18n',
        templateUrl : "modules/administracion/m18n-detail.html",
        controller : "M18nDetailController",
        controllerAs : "vm"
    }).when("/administracion/m18n/edit/:key", {
        title : 'm18n',
        templateUrl : "modules/administracion/m18n-edit.html",
        controller : "M18nEditController",
        controllerAs : "vm"
    })

    .when("/administracion/schr/detail", {
        title : 'm18n',
        templateUrl : "modules/administracion/schr-detail.html",
        controller : "SchrDetailController",
        controllerAs : "vm"
    })

    ;

}

function AdministracionController($http, pageTitleService) {
    $http.post("administracion/index.action").success(function(data) {
    });

    pageTitleService.setTitle("sec_administracion", "page_home");
}

function MetamodeloReloadController($http, pageTitleService) {
    var vm = this;

    vm.reload = reload;

    function reload() {
        $http.post("administracion/metamodelo/reload.action").success(function(data) {
        });
    }

    pageTitleService.setTitle("metamodelo", "page_reload");
}

function ConfGridController($http, pageTitleService) {
    var vm = this;

    vm.reload = reload;

    function reload() {
        $http.post("administracion/configuracion/conf-reload.action").success(function(data) {
        });
    }

    $http.post("administracion/configuracion/configuration-list.action").success(function(data) {
        vm.confList = data.resultList;
    });

    pageTitleService.setTitle("conf", "page_grid");
}

function ConfDetailController($http, $routeParams, pageTitleService) {
    var vm = this;

    $http.post("administracion/configuracion/configuration-detail.action", {
        model : {
            key : $routeParams.key
        }
    }).success(function(data) {
        vm.conf = data.model;
    });

    pageTitleService.setTitle("conf", "page_detail");
}

function ConfEditController($http, $routeParams, pageTitleService) {
    var vm = this;

    vm.accion = $routeParams.accion;
    vm.save = save;
    vm.cancel = cancel;

    function save() {
        $http.post("administracion/configuracion/configuration-save.action", {
            model : vm.conf,
            accion : vm.accion
        }).success(function(data) {
            setTimeout(function() {
                window.history.back();
            }, 0);
        });
    }

    function cancel() {
        window.history.back();
    }

    $http.post("administracion/configuracion/configuration-edit.action", {
        model : {
            key : $routeParams.key
        },
        accion : vm.accion
    }).success(function(data) {
        vm.conf = data.model;
    });

    pageTitleService.setTitle("conf", "page_edit");
}

function M18nGridController($http, pageTitleService) {
    var vm = this;

    vm.reload = reload;

    function reload() {
        $http.post("administracion/messagei18n/m18n-reload.action").success(function(data) {
        });
    }

    $http.post("administracion/messagei18n/m18n-grid.action").success(function(data) {
        vm.keyList = data.keyList;
        vm.keyMap = data.keyMap;
        vm.availableLanguages = data.availableLanguages;
    });

    pageTitleService.setTitle("m18n", "page_grid");
}

function M18nDetailController($http, $routeParams, pageTitleService) {
    var vm = this;

    $http.post("administracion/messagei18n/m18n-detail.action", {
        key : $routeParams.key
    }).success(function(data) {
        vm.key = data.key;
        vm.m18nMap = data.m18nMap;
        vm.availableLanguages = data.availableLanguages;
    });

    pageTitleService.setTitle("m18n", "page_detail");
}

function M18nEditController($http, $routeParams, pageTitleService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        $http.post("administracion/messagei18n/m18n-save.action", {
            accion : vm.accion,
            key : vm.key,
            m18nMap : vm.m18nMap
        }).success(function(data) {
            setTimeout(function() {
                window.history.back();
            }, 0);
        });
    }

    function cancel() {
        window.history.back();
    }

    $http.post("administracion/messagei18n/m18n-edit.action", {
        key : $routeParams.key
    }).success(function(data) {
        vm.accion = data.accion;
        vm.key = data.key;
        vm.m18nMap = data.m18nMap;
        vm.availableLanguages = data.availableLanguages;
    });

    pageTitleService.setTitle("m18n", "page_edit");
}

function SchrDetailController($http, $routeParams, pageTitleService) {
    var vm = this;

    vm.start = start;
    vm.pause = pause;
    vm.shutdown = shutdown;
    vm.shutdownClean = shutdownClean;

    function start() {
        $http.post("administracion/job/schr-start.action").success(function(data) {
            vm.schr = data.schr;
        });
    }

    function pause() {
        $http.post("administracion/job/schr-pause.action").success(function(data) {
            vm.schr = data.schr;
        });
    }

    function shutdown() {
        $http.post("administracion/job/schr-shutdown.action").success(function(data) {
            vm.schr = data.schr;
        });
    }

    function shutdownClean() {
        $http.post("administracion/job/schr-shutdown-clean.action").success(function(data) {
            vm.schr = data.schr;
        });
    }

    $http.post("administracion/job/schr-detail.action").success(function(data) {
        vm.schr = data.schr;
    });

    pageTitleService.setTitle("schr", "page_detail");
}
