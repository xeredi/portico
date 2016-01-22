angular.module("administracion_controller", [])

.config(config)

.controller("AdministracionIndexController", AdministracionIndexController)

.controller("SuperpuertoGridController", SuperpuertoGridController)

.controller("SuperpuertoDetailController", SuperpuertoDetailController)

.controller("SuperpuertoEditController", SuperpuertoEditController)

.controller("PuertoGridController", PuertoGridController)

.controller("PuertoDetailController", PuertoDetailController)

.controller("PuertoEditController", PuertoEditController)

.controller("ConfigurationGridController", ConfigurationGridController)

.controller("ConfigurationDetailController", ConfigurationDetailController)

.controller("ConfigurationEditController", ConfigurationEditController)

.controller("MessageI18nGridController", MessageI18nGridController)

.controller("MessageI18nDetailController", MessageI18nDetailController)

.controller("MessageI18nEditController", MessageI18nEditController)

;

function config($routeProvider) {
    $routeProvider

    .when("/administracion", {
        templateUrl : "modules/administracion/administracion-index.html",
        controller : "AdministracionIndexController as vm"
    })

    .when("/administracion/puerto/superpuerto/grid", {
        templateUrl : "modules/administracion/superpuerto-grid.html",
        controller : "SuperpuertoGridController as vm",
        reloadOnSearch : false
    })

    .when("/administracion/puerto/superpuerto/detail/:id", {
        templateUrl : "modules/administracion/superpuerto-detail.html",
        controller : "SuperpuertoDetailController as vm",
    })

    .when("/administracion/puerto/superpuerto/edit/:accion/:id?", {
        templateUrl : "modules/administracion/superpuerto-edit.html",
        controller : "SuperpuertoEditController as vm",
    })

    .when("/administracion/puerto/puerto/grid", {
        templateUrl : "modules/administracion/puerto-grid.html",
        controller : "PuertoGridController as vm",
        reloadOnSearch : false
    })

    .when("/administracion/puerto/puerto/detail/:id", {
        templateUrl : "modules/administracion/puerto-detail.html",
        controller : "PuertoDetailController as vm",
    })

    .when("/administracion/puerto/puerto/edit/:accion/:id?", {
        templateUrl : "modules/administracion/puerto-edit.html",
        controller : "PuertoEditController as vm",
    })

    .when("/administracion/configuration/configuration/grid", {
        templateUrl : "modules/administracion/configuration-grid.html",
        controller : "ConfigurationGridController as vm",
        reloadOnSearch : false
    })

    .when("/administracion/configuration/configuration/detail/:key", {
        templateUrl : "modules/administracion/configuration-detail.html",
        controller : "ConfigurationDetailController as vm",
    })

    .when("/administracion/configuration/configuration/edit/:accion/:key?", {
        templateUrl : "modules/administracion/configuration-edit.html",
        controller : "ConfigurationEditController as vm",
    })

    .when("/administracion/messagei18n/messagei18n/grid", {
        templateUrl : "modules/administracion/messagei18n-grid.html",
        controller : "MessageI18nGridController as vm",
        reloadOnSearch : false
    })

    .when("/administracion/messagei18n/messagei18n/detail/:key", {
        templateUrl : "modules/administracion/messagei18n-detail.html",
        controller : "MessageI18nDetailController as vm",
    })

    .when("/administracion/messagei18n/messagei18n/edit/:accion/:key", {
        templateUrl : "modules/administracion/messagei18n-edit.html",
        controller : "MessageI18nEditController as vm",
    })

    ;
}

function AdministracionIndexController($routeParams, pageTitleService,
        AdministracionService) {
    var vm = this;

    AdministracionService.index().then(function(data) {
    });

    pageTitleService.setTitle("sec_administracion", "page_home");
}

function SuperpuertoGridController($route, $routeParams, pageTitleService,
        SuperpuertoService) {
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
        SuperpuertoService.listPage(vm.searchCriteria, page, vm.limit).then(
                function(data) {
                    vm.page = data.resultList.page;
                    vm.limit = data.resultList.limit;
                    vm.sprtList = data.resultList;
                });
    }

    function pageChanged() {
        search(vm.page);
    }

    vm.searchCriteria = $routeParams.searchCriteria ? angular
            .fromJson($routeParams.searchCriteria) : {};
    vm.limit = $routeParams.limit;

    search($routeParams.page ? $routeParams.page : 1);

    pageTitleService.setTitle("sprt", "page_grid");
}

function SuperpuertoDetailController($routeParams, pageTitleService,
        SuperpuertoService) {
    var vm = this;

    vm.remove = remove;

    function remove() {
        SuperpuertoService.remove(vm.sprt).then(function(data) {
            window.history.back();
        });
    }

    vm.search = {
        id : $routeParams.id
    };

    SuperpuertoService.detail(vm.search).then(function(data) {
        vm.model = data.model;
        vm.i18nMap = data.i18nMap;
    });

    pageTitleService.setTitle("sprt", "page_detail");
}

function SuperpuertoEditController($route, $routeParams, pageTitleService,
        SuperpuertoService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        SuperpuertoService.saveI18n(vm.accion, vm.sprt, vm.i18nMap).then(
                function(data) {
                    SuperpuertoService.redirectAfterSave(vm.accion, data.model,
                            "superpuerto-detail");
                });
    }

    function cancel() {
        window.history.back();
    }

    vm.accion = $routeParams.accion;

    vm.search = {
        id : $routeParams.id
    };

    SuperpuertoService.edit($routeParams.accion, vm.search).then(
            function(data) {
                vm.model = data.model;
                vm.i18nMap = data.i18nMap;
            });

    pageTitleService.setTitle("sprt", "page_" + vm.accion);
}

function PuertoGridController($route, $routeParams, pageTitleService,
        PuertoService) {
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
        PuertoService.listPage(vm.searchCriteria, page, vm.limit).then(
                function(data) {
                    vm.page = data.resultList.page;
                    vm.limit = data.resultList.limit;
                    vm.prtoList = data.resultList;
                });
    }

    function pageChanged() {
        search(vm.page);
    }

    vm.searchCriteria = $routeParams.searchCriteria ? angular
            .fromJson($routeParams.searchCriteria) : {};
    vm.limit = $routeParams.limit;

    search($routeParams.page ? $routeParams.page : 1);

    pageTitleService.setTitle("prto", "page_grid");
}

function PuertoDetailController($routeParams, pageTitleService, PuertoService) {
    var vm = this;

    vm.remove = remove;

    function remove() {
        PuertoService.remove(vm.prto).then(function(data) {
            window.history.back();
        });
    }

    vm.search = {
        id : $routeParams.id
    };

    PuertoService.detail(vm.search).then(function(data) {
        vm.model = data.model;
        vm.i18nMap = data.i18nMap;
    });

    pageTitleService.setTitle("prto", "page_detail");
}

function PuertoEditController($route, $routeParams, pageTitleService,
        PuertoService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        PuertoService.saveI18n(vm.accion, vm.prto, vm.i18nMap).then(
                function(data) {
                    PuertoService.redirectAfterSave(vm.accion, data.model,
                            "puerto-detail");
                });
    }

    function cancel() {
        window.history.back();
    }

    vm.accion = $routeParams.accion;

    vm.search = {
        id : $routeParams.id
    };

    PuertoService.edit($routeParams.accion, vm.search).then(function(data) {
        vm.model = data.model;
        vm.i18nMap = data.i18nMap;

        vm.sprtList = data.sprtList;
    });

    pageTitleService.setTitle("prto", "page_" + vm.accion);
}

function ConfigurationGridController($route, $routeParams, pageTitleService,
        ConfigurationService) {
    var vm = this;

    vm.search = search;
    vm.reload = reload;

    function search() {
        ConfigurationService.list().then(function(data) {
            vm.confList = data.resultList;
        });
    }

    function reload() {
        alert('Implementar');
    }

    search();

    pageTitleService.setTitle("conf", "page_grid");
}

function ConfigurationDetailController($routeParams, pageTitleService,
        ConfigurationService) {
    var vm = this;

    vm.search = {
        key : $routeParams.key
    };

    ConfigurationService.detail(vm.search).then(function(data) {
        vm.model = data.model;
    });

    pageTitleService.setTitle("conf", "page_detail");
}

function ConfigurationEditController($route, $routeParams, pageTitleService,
        ConfigurationService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        ConfigurationService.save(vm.accion, vm.conf).then(
                function(data) {
                    ConfigurationService.redirectAfterSave(vm.accion,
                            data.model, "configuration-detail");
                });
    }

    function cancel() {
        window.history.back();
    }

    vm.accion = $routeParams.accion;

    vm.search = {
        key : $routeParams.key
    };

    ConfigurationService.edit($routeParams.accion, vm.search).then(
            function(data) {
                vm.model = data.model;
            });

    pageTitleService.setTitle("conf", "page_" + vm.accion);
}

function MessageI18nGridController($route, $routeParams, pageTitleService,
        MessageI18nService) {
    var vm = this;

    vm.search = search;
    vm.reload = reload;

    function search() {
        MessageI18nService.list().then(function(data) {
            vm.keyList = data.resultList;
            vm.keyMap = data.keyMap;
            vm.availableLanguages = data.availableLanguages;
        });
    }

    function reload() {
        alert('Implementar');
    }

    search();

    pageTitleService.setTitle("m18n", "page_grid");
}

function MessageI18nDetailController($routeParams, pageTitleService,
        MessageI18nService) {
    var vm = this;

    MessageI18nService.detail($routeParams.key).then(function(data) {
        vm.key = data.model;
        vm.i18nMap = data.i18nMap;

        vm.availableLanguages = data.availableLanguages;
    });

    pageTitleService.setTitle("m18n", "page_detail");
}

function MessageI18nEditController($route, $routeParams, pageTitleService,
        MessageI18nService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        MessageI18nService.saveI18n(vm.accion, vm.key, vm.i18nMap).then(
                function(data) {
                    MessageI18nService.redirectAfterSave(vm.accion, data.model,
                            "messagei18n-detail");
                });
    }

    function cancel() {
        window.history.back();
    }

    vm.accion = $routeParams.accion;

    vm.search = {
        key : $routeParams.key
    };

    MessageI18nService.edit($routeParams.accion, vm.search).then(
            function(data) {
                vm.key = data.model;
                vm.i18nMap = data.i18nMap;

                vm.availableLanguages = data.availableLanguages;
            });

    pageTitleService.setTitle("m18n", "page_" + vm.accion);
}
