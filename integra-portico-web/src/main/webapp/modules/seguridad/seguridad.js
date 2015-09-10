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
        controller : "AccnGridController as vm",
        reloadOnSearch : false
    })

    .when("/seguridad/accn/detail/:id", {
        templateUrl : "modules/seguridad/accn-detail.html",
        controller : "AccnDetailController as vm",
        reloadOnSearch : false
    })

    .when("/seguridad/accn/edit/:accion/:id?", {
        templateUrl : "modules/seguridad/accn-edit.html",
        controller : "AccnEditController as vm",
        reloadOnSearch : false
    })

    .when("/seguridad/grpo/grid", {
        templateUrl : "modules/seguridad/grpo-grid.html",
        controller : "GrpoGridController as vm",
        reloadOnSearch : false
    })

    .when("/seguridad/grpo/detail/:grpoId", {
        templateUrl : "modules/seguridad/grpo-detail.html",
        controller : "GrpoDetailController as vm",
        reloadOnSearch : false
    })

    .when("/seguridad/grpo/edit/:accion/:grpoId?", {
        templateUrl : "modules/seguridad/grpo-edit.html",
        controller : "GrpoEditController as vm",
        reloadOnSearch : false
    })

    .when("/seguridad/usro/grid", {
        templateUrl : "modules/seguridad/usro-grid.html",
        controller : "UsroGridController as vm",
        reloadOnSearch : false
    })

    .when("/seguridad/usro/detail/:usroId", {
        templateUrl : "modules/seguridad/usro-detail.html",
        controller : "UsroDetailController as vm",
        reloadOnSearch : false
    })

    .when("/seguridad/usro/edit/:accion/:usroId?", {
        templateUrl : "modules/seguridad/usro-edit.html",
        controller : "UsroEditController as vm",
        reloadOnSearch : false
    })

    .when("/seguridad/usro/acceso", {
        templateUrl : "modules/seguridad/usro-acceso.html",
        controller : "UsroAccesoController as vm"
    })

    .when("/seguridad/usro/salir", {
        controller : "UsroSalirController as vm"
    })

    ;
}

function AccnGridController($http, $location, $routeParams, $modal, pageTitleService) {
    CrudGridController.call(this, $http, $location, $routeParams, $modal, "seguridad/accion-list.action",
            "seguridad/accn-filter.action");

    pageTitleService.setTitle("accn", "page_grid");
}

AccnGridController.prototype.retrieveResult = function(data) {
    this.accnList = data.resultList;
};

AccnGridController.prototype.retrieveFilterDependencies = function(data) {
};

function AccnDetailController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.remove = remove;

    initialize();

    function initialize() {
        $http.post("seguridad/accion-detail.action", {
            model : {
                id : $routeParams.id
            }
        }).success(function(data) {
            vm.accn = data.model;
            vm.grpoList = data.grpoList;
        });

        pageTitleService.setTitle("accn", "page_detail");
    }

    function remove() {
        if (confirm("Are you sure?")) {
            $http.post("seguridad/accion-remove.action", {
                model : vm.accn
            }).success(function(data) {
                window.history.back();
            });
        }
    }
}

function AccnEditController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;
    vm.updateGrupos = updateGrupos;

    initialize();

    function initialize() {
        vm.accion = $routeParams.accion;

        $http.post("seguridad/accion-edit.action", {
            model : {
                id : $routeParams.id
            },
            accion : vm.accion
        }).success(function(data) {
            vm.accn = data.model;
            vm.grpoList = data.grpoList;
        });

        pageTitleService.setTitle("accn", "page_" + vm.accion);
    }

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
}

function GrpoGridController($http, $location, $routeParams, $modal, pageTitleService) {
    CrudGridController.call(this, $http, $location, $routeParams, $modal, "seguridad/grupo-list.action",
            "seguridad/grupo-filter.action");

    pageTitleService.setTitle("grpo", "page_grid");
}

GrpoGridController.prototype.retrieveResult = function(data) {
    this.grpoList = data.resultList;
};

GrpoGridController.prototype.retrieveFilterDependencies = function(data) {
};

function GrpoDetailController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.remove = remove;

    initialize();

    function initialize() {
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

    function remove() {
        if (confirm("Are you sure?")) {
            $http.post("seguridad/grupo-remove.action", {
                model : vm.grpo
            }).success(function(data) {
                window.history.back();
            });
        }
    }
}

function GrpoEditController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;
    vm.updateAcciones = updateAcciones;

    initialize();

    function initialize() {
        vm.accion = $routeParams.accion;

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
}

function UsroGridController($http, $location, $routeParams, $modal, pageTitleService) {
    CrudGridController.call(this, $http, $location, $routeParams, $modal, "seguridad/usuario-list.action",
            "seguridad/usuario-filter.action");

    pageTitleService.setTitle("usro", "page_grid");
}

UsroGridController.prototype.retrieveResult = function(data) {
    this.usroList = data.resultList;
};

UsroGridController.prototype.retrieveFilterDependencies = function(data) {
    this.sprtList = data.sprtList;
    this.prtoList = data.prtoList;
};

function UsroDetailController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.remove = remove;

    initialize();

    function initialize() {
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

    function remove() {
        if (confirm("Are you sure?")) {
            $http.post("seguridad/usuario-remove.action", {
                model : vm.usro
            }).success(function(data) {
                window.history.back();
            });
        }
    }
}

function UsroEditController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;
    vm.updateGrupos = updateGrupos;

    initialize();

    function initialize() {
        vm.accion = $routeParams.accion;

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
