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

.controller("UsroAccesoController", UsroAccesoController)

.controller("UsroSalirController", UsroSalirController)

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

    .when("/seguridad/usro/acceso", {
        templateUrl : "modules/seguridad/usro-acceso.html",
        controller : "UsroAccesoController",
        controllerAs : 'vm'
    })

    .when("/seguridad/usro/salir", {
        controller : "UsroSalirController",
        controllerAs : 'vm'
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

    vm.remove = remove;

    function remove() {
        if (confirm("Are you sure?")) {
            $http.post("seguridad/accion-remove.action", {
                model : vm.accn
            }).success(function(data) {
                window.history.back();
            });
        }
    }

    $http.post("seguridad/accion-detail.action", {
        model : {
            id : $routeParams.accnId
        }
    }).success(function(data) {
        vm.accn = data.model;
        vm.grpoList = data.grpoList;
    });

    pageTitleService.setTitle("accn", "page_detail");
}

function AccnEditController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.accion = $routeParams.accion;
    vm.save = save;
    vm.cancel = cancel;
    vm.updateGrupos = updateGrupos;

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

    function updateGrupos($event, grpoId) {
        var checkbox = $event.target;

        if (!vm.accn) {
            vm.accn = {};
        }

        if (!vm.accn.grpoIds) {
            vm.accn.grpoIds = [];
        }

        if (checkbox.checked) {
            vm.accn.grpoIds.push(grpoId);
        } else {
            vm.accn.grpoIds.splice(vm.accn.grpoIds.indexOf(grpoId), 1);
        }
    }

    $http.post("seguridad/accion-edit.action", {
        model : {
            id : $routeParams.accnId
        },
        accion : vm.accion
    }).success(function(data) {
        vm.accn = data.model;
        vm.grpoList = data.grpoList;
    });

    pageTitleService.setTitle("accn", "page_" + vm.accion);
}

function GrpoGridController($http, $location, $routeParams, $modal, pageTitleService) {
    var vm = this;

    vm.search = search;
    vm.pageChanged = pageChanged;
    vm.filter = filter;

    vm.grpoCriterio = $routeParams.grpoCriterio ? angular.fromJson($routeParams.grpoCriterio) : {};
    vm.page = $routeParams.page ? $routeParams.page : 1;

    function search() {
        $http.post("seguridad/grupo-list.action", {
            model : vm.grpoCriterio,
            page : vm.page,
            limit : vm.limit
        }).success(function(data) {
            vm.grpoList = data.resultList;

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

    vm.remove = remove;

    function remove() {
        if (confirm("Are you sure?")) {
            $http.post("seguridad/grupo-remove.action", {
                model : vm.grpo
            }).success(function(data) {
                window.history.back();
            });
        }
    }

    $http.post("seguridad/grupo-detail.action", {
        model : {
            id : $routeParams.grpoId
        }
    }).success(function(data) {
        vm.grpo = data.model;
        vm.accnList = data.accnList;
    });

    pageTitleService.setTitle("grpo", "page_detail");
}

function GrpoEditController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.accion = $routeParams.accion;
    vm.save = save;
    vm.cancel = cancel;
    vm.updateAcciones = updateAcciones;

    function save() {
        $http.post("seguridad/grupo-save.action", {
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

    function updateAcciones($event, accnId) {
        var checkbox = $event.target;

        if (!vm.grpo) {
            vm.grpo = {};
        }

        if (!vm.grpo.accnIds) {
            vm.grpo.accnIds = [];
        }

        if (checkbox.checked) {
            vm.grpo.accnIds.push(accnId);
        } else {
            vm.grpo.accnIds.splice(vm.grpo.accnIds.indexOf(accnId), 1);
        }
    }

    $http.post("seguridad/grupo-edit.action", {
        model : {
            id : $routeParams.grpoId
        },
        accion : vm.accion
    }).success(function(data) {
        vm.grpo = data.model;
        vm.accnList = data.accnList;
    });

    pageTitleService.setTitle("grpo", "page_" + vm.accion);
}

function UsroGridController($http, $location, $routeParams, $modal, pageTitleService) {
    var vm = this;

    vm.search = search;
    vm.pageChanged = pageChanged;
    vm.filter = filter;

    vm.usroCriterio = $routeParams.usroCriterio ? angular.fromJson($routeParams.usroCriterio) : {};
    vm.page = $routeParams.page ? $routeParams.page : 1;

    function search() {
        $http.post("seguridad/usuario-list.action", {
            model : vm.usroCriterio,
            page : vm.page,
            limit : vm.limit
        }).success(function(data) {
            vm.usroList = data.resultList;

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
        $http.post("seguridad/usuario-filter.action", {
            model : vm.usroCriterio
        }).success(function(data) {
            vm.sprtList = data.sprtList;
            vm.prtoList = data.prtoList;
        });
    }

    search();
    pageTitleService.setTitle("usro", "page_grid");
}

function UsroDetailController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    $http.post("seguridad/usuario-detail.action", {
        model : {
            id : $routeParams.usroId
        }
    }).success(function(data) {
        vm.usro = data.model;
        vm.grpoList = data.grpoList;
    });

    pageTitleService.setTitle("usro", "page_detail");
}

function UsroEditController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.accion = $routeParams.accion;
    vm.save = save;
    vm.cancel = cancel;
    vm.updateGrupos = updateGrupos;

    function save() {
        $http.post("seguridad/usuario-save.action", {
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

    function updateGrupos($event, grpoId) {
        var checkbox = $event.target;

        if (!vm.usro) {
            vm.usro = {};
        }

        if (!vm.usro.grpoIds) {
            vm.usro.grpoIds = [];
        }

        if (checkbox.checked) {
            vm.usro.grpoIds.push(grpoId);
        } else {
            vm.usro.grpoIds.splice(vm.usro.grpoIds.indexOf(grpoId), 1);
        }
    }

    $http.post("seguridad/usuario-edit.action", {
        model : {
            id : $routeParams.usroId
        },
        accion : vm.accion
    }).success(function(data) {
        vm.usro = data.model;
        vm.grpoList = data.grpoList;
        vm.sprtList = data.sprtList;
        vm.prtoList = data.prtoList;
    });

    pageTitleService.setTitle("usro", "page_" + vm.accion);
}

function UsroAccesoController($http, $location, pageTitleService) {
    var vm = this;

    vm.acceso = acceso;

    function acceso() {
        $http.post("seguridad/usuario-acceso.action", {
            model : vm.usro
        }).success(function(data) {
            $location.path("/").replace();
        });
    }

    pageTitleService.setTitle("usro", "page_acceso");
}

function UsroSalirController($http, $location) {
    $http.post("seguridad/usuario-salir.action").success(function(data) {
        $location.path("/").replace();
    });
}
