angular.module("seguridad_controller", [ "seguridad_service" ])

.config(config)

.controller("AccionGridController", AccionGridController)

.controller("AccionDetailController", AccionDetailController)

.controller("AccionEditController", AccionEditController)

.controller("GrupoGridController", GrupoGridController)

.controller("GrupoDetailController", GrupoDetailController)

.controller("GrupoEditController", GrupoEditController)

.controller("UsuarioGridController", UsuarioGridController)

.controller("UsuarioDetailController", UsuarioDetailController)

.controller("UsuarioEditController", UsuarioEditController)

.controller("UsuarioAccesoController", UsuarioAccesoController)

.controller("UsuarioSalirController", UsuarioSalirController)

;

function config($stateProvider) {
    $stateProvider

    .state("accion-grid", {
        url : "/seguridad/accion/grid?page&searchCriteria&limit",
        templateUrl : "modules/seguridad/accion-grid.html",
        controller : "AccionGridController as vm",
        reloadOnSearch : false
    })

    .state("accion-detail", {
        url : "/seguridad/accion/detail/:id",
        templateUrl : "modules/seguridad/accion-detail.html",
        controller : "AccionDetailController as vm",
    })

    .state("accion-edit", {
        url : "/seguridad/accion/edit/:accion?id",
        templateUrl : "modules/seguridad/accion-edit.html",
        controller : "AccionEditController as vm",
    })

    .state("grupo-grid", {
        url : "/seguridad/grupo/grid?page&searchCriteria&limit",
        templateUrl : "modules/seguridad/grupo-grid.html",
        controller : "GrupoGridController as vm",
        reloadOnSearch : false
    })

    .state("grupo-detail", {
        url : "/seguridad/grupo/detail/:id",
        templateUrl : "modules/seguridad/grupo-detail.html",
        controller : "GrupoDetailController as vm",
    })

    .state("grupo-edit", {
        url : "/seguridad/grupo/edit/:accion?id",
        templateUrl : "modules/seguridad/grupo-edit.html",
        controller : "GrupoEditController as vm",
    })

    .state("usuario-grid", {
        url : "/seguridad/usuario/grid?page&searchCriteria&limit",
        templateUrl : "modules/seguridad/usuario-grid.html",
        controller : "UsuarioGridController as vm",
        reloadOnSearch : false
    })

    .state("usuario-detail", {
        url : "/seguridad/usuario/detail/:id",
        templateUrl : "modules/seguridad/usuario-detail.html",
        controller : "UsuarioDetailController as vm",
    })

    .state("usuario-edit", {
        url : "/seguridad/usuario/edit/:accion?id",
        templateUrl : "modules/seguridad/usuario-edit.html",
        controller : "UsuarioEditController as vm",
    })

    .state("usuario-acceso", {
        url : "/seguridad/usuario/acceso",
        templateUrl : "modules/seguridad/usuario-acceso.html",
        controller : "UsuarioAccesoController as vm",
    })

    .state("usuario-salir", {
        url : "/seguridad/usuario/salir",
        controller : "UsuarioSalirController as vm",
    })

    ;
}

function AccionGridController($state, $stateParams, $modal, pageTitleService, AccionService) {
    var vm = this;

    vm.filter = filter;
    vm.resetFilter = resetFilter;
    vm.search = search;
    vm.pageChanged = pageChanged;

    function filter() {
        AccionService.filter(vm.searchCriteria).then(function(data) {
        });
    }

    function resetFilter() {
        vm.searchCriteria = {};
    }

    function search(page) {
        AccionService.list(vm.searchCriteria, page, vm.limit).then(function(data) {
            vm.page = data.resultList.page;
            vm.limit = data.resultList.limit;
            vm.accnList = data.resultList;
        });
    }

    function pageChanged() {
        search(vm.page);
    }

    vm.searchCriteria = $stateParams.searchCriteria ? angular.fromJson($stateParams.searchCriteria) : {};
    vm.limit = $stateParams.limit;

    search($stateParams.page ? $stateParams.page : 1);

    pageTitleService.setTitle("accn", "page_grid");
}

function AccionDetailController($stateParams, pageTitleService, AccionService) {
    var vm = this;

    vm.remove = remove;

    function remove() {
        AccionService.remove(vm.accn).then(function(data) {
            window.history.back();
        });
    }

    AccionService.detail({
        id : $stateParams.id
    }).then(function(data) {
        vm.accn = data.model;
        vm.grpoList = data.grpoList;
    });

    pageTitleService.setTitle("accn", "page_detail");
}

function AccionEditController($state, $stateParams, pageTitleService, AccionService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;
    vm.updateGrupos = updateGrupos;

    function save() {
        AccionService.save(vm.accion, vm.accn).then(function(data) {
            vm.accion == 'edit' ? setTimeout(function() {
                window.history.back();
            }, 0) : $state.go("accion-detail", data.model, {
                location : 'replace'
            });
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

    vm.accion = $stateParams.accion;

    AccionService.edit($stateParams.accion, {
        id : $stateParams.id
    }).then(function(data) {
        vm.accn = data.model;
        vm.grpoList = data.grpoList;
    });

    pageTitleService.setTitle("accn", "page_" + vm.accion);
}

function GrupoGridController($state, $stateParams, $modal, pageTitleService, GrupoService) {
    var vm = this;

    vm.filter = filter;
    vm.resetFilter = resetFilter;
    vm.search = search;
    vm.pageChanged = pageChanged;

    function filter() {
        GrupoService.filter(vm.searchCriteria).then(function(data) {
        });
    }

    function resetFilter() {
        vm.searchCriteria = {};
    }

    function search(page) {
        GrupoService.list(vm.searchCriteria, page, vm.limit).then(function(data) {
            vm.page = data.resultList.page;
            vm.limit = data.resultList.limit;
            vm.grpoList = data.resultList;
        });
    }

    function pageChanged() {
        search(vm.page);
    }

    vm.searchCriteria = $stateParams.searchCriteria ? angular.fromJson($stateParams.searchCriteria) : {};
    vm.limit = $stateParams.limit;

    search($stateParams.page ? $stateParams.page : 1);

    pageTitleService.setTitle("grpo", "page_grid");
}

function GrupoDetailController($stateParams, pageTitleService, GrupoService) {
    var vm = this;

    vm.remove = remove;

    function remove() {
        GrupoService.remove(vm.grpo).then(function(data) {
            window.history.back();
        });
    }

    GrupoService.detail({
        id : $stateParams.id
    }).then(function(data) {
        vm.grpo = data.model;
        vm.accnList = data.accnList;
    });

    pageTitleService.setTitle("grpo", "page_detail");
}

function GrupoEditController($state, $stateParams, pageTitleService, GrupoService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;
    vm.updateAcciones = updateAcciones;

    function save() {
        GrupoService.save(vm.accion, vm.grpo).then(function(data) {
            vm.accion == 'edit' ? setTimeout(function() {
                window.history.back();
            }, 0) : $state.go("grupo-detail", data.model, {
                location : 'replace'
            });
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

    vm.accion = $stateParams.accion;

    GrupoService.edit(vm.accion, {
        id : $stateParams.id
    }).then(function(data) {
        vm.grpo = data.model;
        vm.accnList = data.accnList;
    });

    pageTitleService.setTitle("grpo", "page_" + vm.accion);
}

function UsuarioGridController($state, $stateParams, $modal, pageTitleService, UsuarioService) {
    var vm = this;

    vm.filter = filter;
    vm.resetFilter = resetFilter;
    vm.search = search;
    vm.pageChanged = pageChanged;

    function filter() {
        UsuarioService.filter(vm.searchCriteria).then(function(data) {
            vm.sprtList = data.sprtList;
            vm.prtoList = data.prtoList;
        });
    }

    function resetFilter() {
        vm.searchCriteria = {};
    }

    function search(page) {
        UsuarioService.list(vm.searchCriteria, page, vm.limit).then(function(data) {
            vm.page = data.resultList.page;
            vm.limit = data.resultList.limit;
            vm.usroList = data.resultList;
        });
    }

    function pageChanged() {
        search(vm.page);
    }

    vm.searchCriteria = $stateParams.searchCriteria ? angular.fromJson($stateParams.searchCriteria) : {};
    vm.limit = $stateParams.limit;

    search($stateParams.page ? $stateParams.page : 1);

    pageTitleService.setTitle("usro", "page_grid");
}

function UsuarioDetailController($stateParams, pageTitleService, UsuarioService) {
    var vm = this;

    vm.remove = remove;

    function remove() {
        UsuarioService.remove(vm.usro).then(function(data) {
            window.history.back();
        });
    }

    UsuarioService.detail({
        id : $stateParams.id
    }).then(function(data) {
        vm.usro = data.model;
        vm.grpoList = data.grpoList;
    });

    pageTitleService.setTitle("usro", "page_detail");
}

function UsuarioEditController($state, $stateParams, pageTitleService, UsuarioService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;
    vm.updateGrupos = updateGrupos;

    function save() {
        UsuarioService.save(vm.accion, vm.usro).then(function(data) {
            vm.accion == 'edit' ? setTimeout(function() {
                window.history.back();
            }, 0) : $state.go("usuario-detail", data.model, {
                location : 'replace'
            });
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

    vm.accion = $stateParams.accion;

    UsuarioService.edit($stateParams.accion, {
        id : $stateParams.id
    }).then(function(data) {
        vm.usro = data.model;
        vm.grpoList = data.grpoList;
    });

    pageTitleService.setTitle("usro", "page_" + vm.accion);
}

function UsuarioAccesoController($state, pageTitleService, UsuarioService) {
    var vm = this;

    vm.acceso = acceso;

    function acceso() {
        UsuarioService.acceso(vm.usro).then(function(data) {
            $state.go("home");
        });
    }

    pageTitleService.setTitle("usro", "page_acceso");
}

function UsuarioSalirController($state, UsuarioService) {
    UsuarioService.salir().then(function(data) {
        $state.go("home");
    });
}
