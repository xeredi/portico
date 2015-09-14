angular.module("administracion", [])

.config(config)

// ----------------- METAMODELO --------------------------
.controller("MetamodeloReloadController", MetamodeloReloadController)

// ----------------- MESSAGEI18N --------------------------
.controller("M18nGridController", M18nGridController)

.controller("M18nDetailController", M18nDetailController)

.controller("M18nEditController", M18nEditController)

// ----------------- SCHEDULER --------------------------
.controller("SchrDetailController", SchrDetailController)

;

function config($routeProvider) {
    $routeProvider

    .when("/administracion/metamodelo/reload", {
        templateUrl : "modules/administracion/metamodelo-reload.html",
        controller : "MetamodeloReloadController as vm"
    })

    .when("/administracion/m18n/grid", {
        templateUrl : "modules/administracion/m18n-grid.html",
        controller : "M18nGridController as vm"
    })

    .when("/administracion/m18n/detail/:key", {
        templateUrl : "modules/administracion/m18n-detail.html",
        controller : "M18nDetailController as vm"
    })

    .when("/administracion/m18n/edit/:accion/:key", {
        templateUrl : "modules/administracion/m18n-edit.html",
        controller : "M18nEditController as vm"
    })

    .when("/administracion/schr/detail", {
        templateUrl : "modules/administracion/schr-detail.html",
        controller : "SchrDetailController as vm"
    })

    ;
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

function M18nGridController($http, pageTitleService) {
    var vm = this;

    vm.reload = reload;

    function reload() {
        $http.post("administracion/messagei18n/m18n-reload.action").success(function(data) {
        });
    }

    $http.post("administracion/messagei18n/message-i18n-list.action").success(function(data) {
        vm.keyList = data.resultList;
        vm.keyMap = data.keyMap;
        vm.availableLanguages = data.availableLanguages;
    });

    pageTitleService.setTitle("m18n", "page_grid");
}

function M18nDetailController($http, $routeParams, pageTitleService) {
    var vm = this;

    $http.post("administracion/messagei18n/message-i18n-detail.action", {
        model : $routeParams.key
    }).success(function(data) {
        vm.key = data.model;
        vm.i18nMap = data.i18nMap;
        vm.availableLanguages = data.availableLanguages;
    });

    pageTitleService.setTitle("m18n", "page_detail");
}

function M18nEditController($http, $routeParams, pageTitleService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        $http.post("administracion/messagei18n/message-i18n-save.action", {
            accion : vm.accion,
            model : vm.key,
            i18nMap : vm.i18nMap
        }).success(function(data) {
            setTimeout(function() {
                window.history.back();
            }, 0);
        });
    }

    function cancel() {
        window.history.back();
    }

    vm.accion = $routeParams.accion;

    $http.post("administracion/messagei18n/message-i18n-edit.action", {
        model : $routeParams.key,
        accion : vm.accion
    }).success(function(data) {
        vm.key = data.model;
        vm.i18nMap = data.i18nMap;
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
