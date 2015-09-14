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

    .state("configuration-grid", {
        url : "/administracion/configuration/configuration/grid",
        templateUrl : "modules/administracion/configuration-grid.html",
        controller : "ConfigurationGridController as vm",
        reloadOnSearch : false
    })

    .state("configuration-detail", {
        url : "/administracion/configuration/configuration/detail/:key",
        templateUrl : "modules/administracion/configuration-detail.html",
        controller : "ConfigurationDetailController as vm",
    })

    .state("configuration-edit", {
        url : "/administracion/configuration/configuration/edit/:accion?key",
        templateUrl : "modules/administracion/configuration-edit.html",
        controller : "ConfigurationEditController as vm",
    })

    .state("messagei18n-grid", {
        url : "/administracion/messagei18n/messagei18n/grid",
        templateUrl : "modules/administracion/messagei18n-grid.html",
        controller : "MessageI18nGridController as vm",
        reloadOnSearch : false
    })

    .state("messagei18n-detail", {
        url : "/administracion/messagei18n/messagei18n/detail/:key",
        templateUrl : "modules/administracion/messagei18n-detail.html",
        controller : "MessageI18nDetailController as vm",
    })

    .state("messagei18n-edit", {
        url : "/administracion/messagei18n/messagei18n/edit/:accion?key",
        templateUrl : "modules/administracion/messagei18n-edit.html",
        controller : "MessageI18nEditController as vm",
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
        SuperpuertoService.listPage(vm.searchCriteria, page, vm.limit).then(function(data) {
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
        PuertoService.listPage(vm.searchCriteria, page, vm.limit).then(function(data) {
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

function ConfigurationGridController($state, $stateParams, $modal, pageTitleService, ConfigurationService) {
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

function ConfigurationDetailController($stateParams, pageTitleService, ConfigurationService) {
    var vm = this;

    ConfigurationService.detail({
        key : $stateParams.key
    }).then(function(data) {
        vm.conf = data.model;
    });

    pageTitleService.setTitle("conf", "page_detail");
}

function ConfigurationEditController($state, $stateParams, pageTitleService, ConfigurationService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        ConfigurationService.save(vm.accion, vm.conf).then(function(data) {
            vm.accion == 'edit' ? setTimeout(function() {
                window.history.back();
            }, 0) : $state.go("configuration-detail", data.model, {
                location : 'replace'
            });
        });
    }

    function cancel() {
        window.history.back();
    }

    vm.accion = $stateParams.accion;

    ConfigurationService.edit($stateParams.accion, {
        key : $stateParams.key
    }).then(function(data) {
        vm.conf = data.model;
    });

    pageTitleService.setTitle("conf", "page_" + vm.accion);
}

function MessageI18nGridController($state, $stateParams, $modal, pageTitleService, MessageI18nService) {
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

function MessageI18nDetailController($stateParams, pageTitleService, MessageI18nService) {
    var vm = this;

    MessageI18nService.detail({
        key : $stateParams.key
    }).then(function(data) {
        vm.key = data.model;
        vm.i18nMap = data.i18nMap;

        vm.availableLanguages = data.availableLanguages;
    });

    pageTitleService.setTitle("m18n", "page_detail");
}

function MessageI18nEditController($state, $stateParams, pageTitleService, MessageI18nService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        MessageI18nService.saveI18n(vm.accion, vm.key, vm.i18nMap).then(function(data) {
            vm.accion == 'edit' ? setTimeout(function() {
                window.history.back();
            }, 0) : $state.go("messagei18n-detail", data.model, {
                location : 'replace'
            });
        });
    }

    function cancel() {
        window.history.back();
    }

    vm.accion = $stateParams.accion;

    MessageI18nService.edit($stateParams.accion, {
        key : $stateParams.key
    }).then(function(data) {
        vm.key = data.model;
        vm.i18nMap = data.i18nMap;

        vm.availableLanguages = data.availableLanguages;
    });

    pageTitleService.setTitle("m18n", "page_" + vm.accion);
}
