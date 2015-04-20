angular.module("seguridad", [])

.config(config)

.controller("AccnGridController", AccnGridController)

.controller("AccnDetailController", AccnDetailController)

.controller("AccnEditController", AccnEditController)

.controller("GrpoGridController", GrpoGridController)

.controller("GrpoDetailController", GrpoDetailController)

.controller("GrpoEditController", GrpoEditController)

.controller("UsroGridController", UsroGridController)

.controller("UsroDetailController", UsroDetailController)

.controller("UsroEditController", UsroEditController)

;

function config($routeProvider) {
    $routeProvider

    .when("/seguridad/accn/grid", {
        templateUrl : "modules/seguridad/accn-grid.html",
        controller : "AccnGridController",
        controllerAs : 'vm',
        reloadOnSearch : false
    })

    .when("/seguridad/accn/detail/:accnId", {
        templateUrl : "modules/seguridad/accn-detail.html",
        controller : "AccnDetailController",
        controllerAs : 'vm',
        reloadOnSearch : false
    })

    .when("/seguridad/accn/edit/:accion/:accnId?", {
        templateUrl : "modules/seguridad/accn-edit.html",
        controller : "AccnEditController",
        controllerAs : 'vm',
        reloadOnSearch : false
    })

    .when("/seguridad/grpo/grid", {
        templateUrl : "modules/seguridad/grpo-grid.html",
        controller : "GrpoGridController",
        controllerAs : 'vm',
        reloadOnSearch : false
    })

    .when("/seguridad/grpo/detail/:grpoId", {
        templateUrl : "modules/seguridad/grpo-detail.html",
        controller : "GrpoDetailController",
        controllerAs : 'vm',
        reloadOnSearch : false
    })

    .when("/seguridad/grpo/edit/:accion/:grpoId?", {
        templateUrl : "modules/seguridad/grpo-edit.html",
        controller : "GrpoEditController",
        controllerAs : 'vm',
        reloadOnSearch : false
    })

    .when("/seguridad/usro/grid", {
        templateUrl : "modules/seguridad/usro-grid.html",
        controller : "UsroGridController",
        controllerAs : 'vm',
        reloadOnSearch : false
    })

    .when("/seguridad/usro/detail/:usroId", {
        templateUrl : "modules/seguridad/usro-detail.html",
        controller : "UsroDetailController",
        controllerAs : 'vm',
        reloadOnSearch : false
    })

    .when("/seguridad/usro/edit/:accion/:usroId?", {
        templateUrl : "modules/seguridad/usro-edit.html",
        controller : "UsroEditController",
        controllerAs : 'vm',
        reloadOnSearch : false
    })

    ;
}

function AccnGridController($http, $location, $routeParams, $modal, pageTitleService) {
    var vm = this;

    vm.search = search;
    vm.pageChanged = pageChanged;
    vm.filter = filter;

    vm.accnCriterio = $routeParams.accnCriterio ? angular.fromJson($routeParams.accnCriterio) : {};
    vm.page = $routeParams.page ? $routeParams.page : 1;

    function search() {
        $http.post("seguridad/accion-list.action", {
            model : vm.accnCriterio,
            page : vm.page,
            limit : vm.limit
        }).success(function(data) {
            vm.accnList = data.resultList;

            $location.search({
                page : vm.page,
                accnCriterio : JSON.stringify(vm.accnCriterio)
            }).replace();
        });
    }

    function pageChanged() {
        search();
    }

    function filter(size) {
        $http.post("seguridad/accn-filter.action").success(function(data) {
        });
    }

    search();
    pageTitleService.setTitle("accn", "page_grid");
}

function AccnDetailController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    $http.post("seguridad/accion-detail.action", {
        model : {
            id : $routeParams.accnId
        }
    }).success(function(data) {
        vm.accn = data.model;
    });

    pageTitleService.setTitle("accn", "page_detail");
}

function AccnEditController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.accion = $routeParams.accion;
    vm.save = save;
    vm.cancel = cancel;

    function save() {
        $http.post("seguridad/accion-save.action", {
            model : vm.accn,
            accion : vm.accion
        }).success(function(data) {
            vm.accion == 'edit' ? setTimeout(function() {
                window.history.back();
            }, 0) : $location.path("/seguridad/accn/detail/" + data.model.id).replace();
        });
    }

    function cancel() {
        window.history.back();
    }

    $http.post("seguridad/accion-edit.action", {
        model : {
            id : $routeParams.accnId
        },
        accion : vm.accion
    }).success(function(data) {
        vm.accn = data.model;
    });

    pageTitleService.setTitleEnti("accn", "page_" + vm.accion);
}

function GrpoGridController($http, $location, $routeParams, $modal, pageTitleService) {
    var vm = this;

    vm.search = search;
    vm.pageChanged = pageChanged;
    vm.filter = filter;

    vm.grpoCriterio = $routeParams.grpoCriterio ? angular.fromJson($routeParams.grpoCriterio) : {};
    vm.page = $routeParams.page ? $routeParams.page : 1;

    function search() {
        $http.post("seguridad/grpo-list.action", {
            model : vm.grpoCriterio,
            page : vm.page,
            limit : vm.limit
        }).success(function(data) {
            vm.grpoList = data.grpoList;

            $location.search({
                page : vm.page,
                grpoCriterio : JSON.stringify(vm.grpoCriterio)
            }).replace();
        });
    }

    function pageChanged() {
        search();
    }

    function filter(size) {
        $http.post("seguridad/grpo-filter.action").success(function(data) {
        });
    }

    search();
    pageTitleService.setTitle("grpo", "page_grid");
}

function GrpoDetailController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    $http.post("seguridad/grpo-detail.action", {
        model : {
            id : $routeParams.grpoId
        }
    }).success(function(data) {
        vm.grpo = data.model;
    });

    pageTitleService.setTitle("grpo", "page_detail");
}

function GrpoEditController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.accion = $routeParams.accion;
    vm.save = save;
    vm.cancel = cancel;

    function save() {
        $http.post("seguridad/grpo-save.action", {
            model : vm.grpo,
            accion : vm.accion
        }).success(function(data) {
            vm.accion == 'edit' ? setTimeout(function() {
                window.history.back();
            }, 0) : $location.path("/seguridad/grpo/detail/" + data.model.id).replace();
        });
    }

    function cancel() {
        window.history.back();
    }

    $http.post("seguridad/grpo-edit.action", {
        model : {
            id : $routeParams.grpoId
        },
        accion : vm.accion
    }).success(function(data) {
        vm.grpo = data.model;
    });

    pageTitleService.setTitleEnti("grpo", "page_" + vm.accion);
}

function UsroGridController($http, $location, $routeParams, $modal, pageTitleService) {
    var vm = this;

    vm.search = search;
    vm.pageChanged = pageChanged;
    vm.filter = filter;

    vm.usroCriterio = $routeParams.usroCriterio ? angular.fromJson($routeParams.usroCriterio) : {};
    vm.page = $routeParams.page ? $routeParams.page : 1;

    function search() {
        $http.post("seguridad/usro-list.action", {
            model : vm.usroCriterio,
            page : vm.page,
            limit : vm.limit
        }).success(function(data) {
            vm.usroList = data.usroList;

            $location.search({
                page : vm.page,
                usroCriterio : JSON.stringify(vm.usroCriterio)
            }).replace();
        });
    }

    function pageChanged() {
        search();
    }

    function filter(size) {
        $http.post("seguridad/usro-filter.action").success(function(data) {
        });
    }

    search();
    pageTitleService.setTitle("usro", "page_grid");
}

function UsroDetailController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    $http.post("seguridad/usro-detail.action", {
        model : {
            id : $routeParams.usroId
        }
    }).success(function(data) {
        vm.usro = data.model;
    });

    pageTitleService.setTitle("usro", "page_detail");
}

function UsroEditController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.accion = $routeParams.accion;
    vm.save = save;
    vm.cancel = cancel;

    function save() {
        $http.post("seguridad/usro-save.action", {
            model : vm.usro,
            accion : vm.accion
        }).success(function(data) {
            vm.accion == 'edit' ? setTimeout(function() {
                window.history.back();
            }, 0) : $location.path("/seguridad/usro/detail/" + data.model.id).replace();
        });
    }

    function cancel() {
        window.history.back();
    }

    $http.post("seguridad/usro-edit.action", {
        model : {
            id : $routeParams.usroId
        },
        accion : vm.accion
    }).success(function(data) {
        vm.usro = data.model;
    });

    pageTitleService.setTitleEnti("usro", "page_" + vm.accion);
}
