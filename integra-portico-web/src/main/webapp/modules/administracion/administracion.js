angular.module("administracion", [ "ngRoute", "util" ])

.config(config)

// ----------------- MENU PRINCIPAL --------------------------
.controller("administracionController", administracionController)

// ----------------- METAMODELO --------------------------
.controller("metamodeloReloadController", metamodeloReloadController)

// ----------------- CONFIGURACION --------------------------
.controller("confGridController", confGridController)

.controller("confDetailController", confDetailController)

.controller("confEditController", confEditController)

// ----------------- MESSAGEI18N --------------------------
.controller("m18nGridController", m18nGridController)

.controller("m18nDetailController", m18nDetailController)

.controller("m18nEditController", m18nEditController)

;

function config($routeProvider) {
    $routeProvider

    .when("/administracion", {
        title : 'sec_administracion',
        templateUrl : "modules/administracion/administracion.html",
        controller : "administracionController",
        controllerAs : "vm"
    })

    .when("/administracion/metamodelo/reload", {
        title : 'metamodelo_reload',
        templateUrl : "modules/administracion/metamodelo-reload.html",
        controller : "metamodeloReloadController",
        controllerAs : "vm"
    })

    .when("/administracion/conf/grid", {
        title : 'conf_grid',
        templateUrl : "modules/administracion/conf-grid.html",
        controller : "confGridController",
        controllerAs : "vm"
    }).when("/administracion/conf/detail/:key", {
        title : 'conf_detail',
        templateUrl : "modules/administracion/conf-detail.html",
        controller : "confDetailController",
        controllerAs : "vm"
    }).when("/administracion/conf/edit/:key", {
        title : 'conf_edit',
        templateUrl : "modules/administracion/conf-edit.html",
        controller : "confEditController",
        controllerAs : "vm"
    })

    .when("/administracion/m18n/grid", {
        title : 'm18nList',
        templateUrl : "modules/administracion/m18n-grid.html",
        controller : "m18nGridController",
        controllerAs : "vm"
    }).when("/administracion/m18n/detail/:key", {
        title : 'm18n',
        templateUrl : "modules/administracion/m18n-detail.html",
        controller : "m18nDetailController",
        controllerAs : "vm"
    }).when("/administracion/m18n/edit/:key", {
        title : 'm18n',
        templateUrl : "modules/administracion/m18n-edit.html",
        controller : "m18nEditController",
        controllerAs : "vm"
    });
}

function administracionController(pageTitleService) {
    pageTitleService.setTitle("administracion", "page_home");
}

function metamodeloReloadController($http, pageTitleService) {
    var vm = this;

    vm.reload = reload;

    function reload() {
        $http.get("administracion/metamodelo/reload.action").success(function(data) {
        });
    }

    pageTitleService.setTitle("metamodelo", "page_reload");
}

function confGridController($http, pageTitleService, usSpinnerService) {
    var vm = this;

    usSpinnerService.spin("spinner");

    $http.get("administracion/configuracion/conf-grid.action").success(function(data) {
        vm.confList = data.confList;

        usSpinnerService.stop("spinner");
    });

    pageTitleService.setTitle("conf", "page_grid");
}

function confDetailController($http, $routeParams, pageTitleService) {
    var vm = this;

    $http.get("administracion/configuracion/conf-detail.action?conf.key=" + $routeParams.key).success(function(data) {
        vm.conf = data.conf;
    });

    pageTitleService.setTitle("conf", "page_detail");
}

function confEditController($http, $routeParams, pageTitleService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        $http.post("administracion/configuracion/conf-save.action", {
            conf : vm.conf,
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

    $http.get("administracion/configuracion/conf-edit.action?conf.key=" + $routeParams.key).success(function(data) {
        vm.accion = data.accion;
        vm.conf = data.conf;
    });

    pageTitleService.setTitle("conf", "page_edit");
}

function m18nGridController($http, pageTitleService, usSpinnerService) {
    var vm = this;

    usSpinnerService.spin("spinner");

    $http.get("administracion/messagei18n/m18n-grid.action").success(function(data) {
        vm.report = data.report;

        usSpinnerService.stop("spinner");
    });

    pageTitleService.setTitle("m18n", "page_grid");
}

function m18nDetailController($http, $routeParams, pageTitleService) {
    var vm = this;

    $http.get("administracion/messagei18n/m18n-detail.action?m18n.key=" + $routeParams.key).success(function(data) {
        vm.m18n = data.m18n;
    });

    pageTitleService.setTitle("m18n", "page_detail");
}

function m18nEditController($http, $routeParams, pageTitleService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        $http.post("administracion/messagei18n/m18n-save.action", {
            conf : vm.m18n,
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

    $http.get("administracion/messagei18n/m18n-edit.action?m18n.key=" + $routeParams.key).success(function(data) {
        vm.accion = data.accion;
        vm.m18n = data.m18n;
    });

    pageTitleService.setTitle("m18n", "page_edit");
}