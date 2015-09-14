angular.module("administracion_controller", [])

.config(config)

.controller("AdministracionIndexController", AdministracionIndexController)

.controller("SuperpuertoGridController", SuperpuertoGridController)

.controller("SuperpuertoDetailController", SuperpuertoDetailController)

.controller("SuperpuertoEditController", SuperpuertoEditController)

.controller("PuertoGridController", PuertoGridController)

.controller("PuertoDetailController", PuertoDetailController)

.controller("PuertoEditController", PuertoEditController)

;

function config($stateProvider) {
    $stateProvider

    .state("administracion-index", {
        url : "/administracion",
        templateUrl : "modules/administracion/administracion.html",
        controller : "AdministracionIndexController as vm"
    })

    .state("superpuerto-grid", {
        url : "/administracion/puerto/superpuerto/grid?page&searchCriteria&limit",
        templateUrl : "modules/administracion/superpuerto-grid.html",
        controller : "SuperpuertoGridController as vm",
        reloadOnSearch : false
    })

    .state("superpuerto-detail", {
        url : "/administracion/puerto/superpuerto/detail/:id",
        templateUrl : "modules/administracion/superpuerto-detail.html",
        controller : "SuperpuertoDetailController as vm",
    })

    .state("superpuerto-edit", {
        url : "/administracion/puerto/superpuerto/edit/:accion?id",
        templateUrl : "modules/administracion/superpuerto-edit.html",
        controller : "SuperpuertoEditController as vm",
    })

    .state("puerto-grid", {
        url : "/administracion/puerto/puerto/grid?page&searchCriteria&limit",
        templateUrl : "modules/administracion/puerto-grid.html",
        controller : "PuertoGridController as vm",
        reloadOnSearch : false
    })

    .state("puerto-detail", {
        url : "/administracion/puerto/puerto/detail/:id",
        templateUrl : "modules/administracion/puerto-detail.html",
        controller : "PuertoDetailController as vm",
    })

    .state("puerto-edit", {
        url : "/administracion/puerto/puerto/edit/:accion?id",
        templateUrl : "modules/administracion/puerto-edit.html",
        controller : "PuertoEditController as vm",
    })

    ;
}

function AdministracionIndexController($stateParams, pageTitleService, AdministracionService) {
    var vm = this;

    AdministracionService.index().then(function(data) {
    });

    pageTitleService.setTitle("sec_administracion", "page_home");
}

function SuperpuertoGridController($state, $stateParams, $modal, pageTitleService, SuperpuertoService) {
    var vm = this;

    vm.filter = filter;
    vm.resetFilter = resetFilter;
    vm.search = search;
    vm.pageChanged = pageChanged;

    function filter() {
        SuperpuertoService.filter(vm.searchCriteria).then(function(data) {
        });
    }

    function resetFilter() {
        vm.searchCriteria = {};
    }

    function search(page) {
        SuperpuertoService.list(vm.searchCriteria, page, vm.limit).then(function(data) {
            vm.page = data.resultList.page;
            vm.limit = data.resultList.limit;
            vm.sprtList = data.resultList;
        });
    }

    function pageChanged() {
        search(vm.page);
    }

    vm.searchCriteria = $stateParams.searchCriteria ? angular.fromJson($stateParams.searchCriteria) : {};
    vm.limit = $stateParams.limit;

    search($stateParams.page ? $stateParams.page : 1);

    pageTitleService.setTitle("sprt", "page_grid");
}

function SuperpuertoDetailController($stateParams, pageTitleService, SuperpuertoService) {
    var vm = this;

    vm.remove = remove;

    function remove() {
        SuperpuertoService.remove(vm.sprt).then(function(data) {
            window.history.back();
        });
    }

    SuperpuertoService.detail({
        id : $stateParams.id
    }).then(function(data) {
        vm.sprt = data.model;
        vm.i18nMap = data.i18nMap;
    });

    pageTitleService.setTitle("sprt", "page_detail");
}

function SuperpuertoEditController($state, $stateParams, pageTitleService, SuperpuertoService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        SuperpuertoService.saveI18n(vm.accion, vm.sprt, vm.i18nMap).then(function(data) {
            vm.accion == 'edit' ? setTimeout(function() {
                window.history.back();
            }, 0) : $state.go("superpuerto-detail", data.model, {
                location : 'replace'
            });
        });
    }

    function cancel() {
        window.history.back();
    }

    vm.accion = $stateParams.accion;

    SuperpuertoService.edit($stateParams.accion, {
        id : $stateParams.id
    }).then(function(data) {
        vm.sprt = data.model;
        vm.i18nMap = data.i18nMap;
    });

    pageTitleService.setTitle("sprt", "page_" + vm.accion);
}

function PuertoGridController($state, $stateParams, $modal, pageTitleService, PuertoService) {
    var vm = this;

    vm.filter = filter;
    vm.resetFilter = resetFilter;
    vm.search = search;
    vm.pageChanged = pageChanged;

    function filter() {
        PuertoService.filter(vm.searchCriteria).then(function(data) {
            vm.sprtList = data.sprtList;
        });
    }

    function resetFilter() {
        vm.searchCriteria = {};
    }

    function search(page) {
        PuertoService.list(vm.searchCriteria, page, vm.limit).then(function(data) {
            vm.page = data.resultList.page;
            vm.limit = data.resultList.limit;
            vm.prtoList = data.resultList;
        });
    }

    function pageChanged() {
        search(vm.page);
    }

    vm.searchCriteria = $stateParams.searchCriteria ? angular.fromJson($stateParams.searchCriteria) : {};
    vm.limit = $stateParams.limit;

    search($stateParams.page ? $stateParams.page : 1);

    pageTitleService.setTitle("prto", "page_grid");
}

function PuertoDetailController($stateParams, pageTitleService, PuertoService) {
    var vm = this;

    vm.remove = remove;

    function remove() {
        PuertoService.remove(vm.prto).then(function(data) {
            window.history.back();
        });
    }

    PuertoService.detail({
        id : $stateParams.id
    }).then(function(data) {
        vm.prto = data.model;
        vm.i18nMap = data.i18nMap;
    });

    pageTitleService.setTitle("prto", "page_detail");
}

function PuertoEditController($state, $stateParams, pageTitleService, PuertoService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        PuertoService.saveI18n(vm.accion, vm.prto, vm.i18nMap).then(function(data) {
            vm.accion == 'edit' ? setTimeout(function() {
                window.history.back();
            }, 0) : $state.go("puerto-detail", data.model, {
                location : 'replace'
            });
        });
    }

    function cancel() {
        window.history.back();
    }

    vm.accion = $stateParams.accion;

    PuertoService.edit($stateParams.accion, {
        id : $stateParams.id
    }).then(function(data) {
        vm.prto = data.model;
        vm.i18nMap = data.i18nMap;

        vm.sprtList = data.sprtList;
    });

    pageTitleService.setTitle("prto", "page_" + vm.accion);
}
