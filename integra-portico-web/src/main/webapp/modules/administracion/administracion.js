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

// ----------------- PUERTOS --------------------------
.controller("SuperpuertoGridController", SuperpuertoGridController)

.controller("SuperpuertoDetailController", SuperpuertoDetailController)

.controller("SuperpuertoEditController", SuperpuertoEditController)

.controller("PuertoGridController", PuertoGridController)

.controller("PuertoDetailController", PuertoDetailController)

.controller("PuertoEditController", PuertoEditController)

;

function config($routeProvider) {
    $routeProvider

    .when("/administracion", {
        templateUrl : "modules/administracion/administracion.html",
        controller : "AdministracionController as vm"
    })

    .when("/administracion/metamodelo/reload", {
        templateUrl : "modules/administracion/metamodelo-reload.html",
        controller : "MetamodeloReloadController as vm"
    })

    .when("/administracion/conf/grid", {
        templateUrl : "modules/administracion/conf-grid.html",
        controller : "ConfGridController as vm"
    })

    .when("/administracion/conf/detail/:key", {
        templateUrl : "modules/administracion/conf-detail.html",
        controller : "ConfDetailController as vm"
    })

    .when("/administracion/conf/edit/:accion/:key?", {
        templateUrl : "modules/administracion/conf-edit.html",
        controller : "ConfEditController as vm"
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

    .when("/administracion/superpuerto-grid", {
        templateUrl : "modules/administracion/superpuerto-grid.html",
        controller : "SuperpuertoGridController as vm",
        reloadOnSearch : false
    })

    .when("/administracion/superpuerto-detail/:sprtId", {
        templateUrl : "modules/administracion/superpuerto-detail.html",
        controller : "SuperpuertoDetailController as vm"
    })

    .when("/administracion/superpuerto-edit/:accion/:sprtId?", {
        templateUrl : "modules/administracion/superpuerto-edit.html",
        controller : "SuperpuertoEditController as vm"
    })

    .when("/administracion/puerto-grid", {
        templateUrl : "modules/administracion/puerto-grid.html",
        controller : "PuertoGridController as vm",
        reloadOnSearch : false
    })

    .when("/administracion/puerto-detail/:prtoId", {
        templateUrl : "modules/administracion/puerto-detail.html",
        controller : "PuertoDetailController as vm"
    })

    .when("/administracion/puerto-edit/:accion/:prtoId?", {
        templateUrl : "modules/administracion/puerto-edit.html",
        controller : "PuertoEditController as vm"
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

function SuperpuertoGridController($http, $routeParams, $location, pageTitleService) {
    var vm = this;

    vm.search = search;
    vm.pageChanged = pageChanged;
    vm.filter = filter;

    function search(page) {
        $http.post("administracion/puerto/superpuerto-list.action", {
            model : vm.sprtCriterio,
            page : page
        }).success(function(data) {
            vm.sprtList = data.resultList;
            vm.page = data.resultList.page;

            $location.search({
                page : vm.page,
                sprtCriterio : JSON.stringify(vm.sprtCriterio)
            }).replace();
        });
    }

    function pageChanged() {
        search(vm.page);
    }

    function filter(size) {
        $http.post("administracion/puerto/superpuerto-filter.action", {
            model : vm.sprtCriterio
        }).success(function(data) {
        });
    }

    vm.sprtCriterio = $routeParams.sprtCriterio ? angular.fromJson($routeParams.sprtCriterio) : {};

    search(1);

    pageTitleService.setTitle("sprt", "page_grid");
}

function SuperpuertoDetailController($http, $routeParams, pageTitleService) {
    var vm = this;

    vm.remove = remove;

    function remove() {
        if (confirm("Are you sure?")) {
            $http.post("administracion/puerto/superpuerto-remove.action", {
                model : vm.sprt
            }).success(function(data) {
                window.history.back();
            });
        }
    }

    $http.post("administracion/puerto/superpuerto-detail.action", {
        model : {
            id : $routeParams.sprtId
        }
    }).success(function(data) {
        vm.sprt = data.model;
        vm.i18nMap = data.i18nMap;
    });

    pageTitleService.setTitle("sprt", "page_detail");
}

function SuperpuertoEditController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        $http.post("administracion/puerto/superpuerto-save.action", {
            accion : vm.accion,
            model : vm.sprt,
            i18nMap : vm.i18nMap
        }).success(function(data) {
            vm.accion == 'edit' ? setTimeout(function() {
                window.history.back();
            }, 0) : $location.path("/administracion/superpuerto-detail/" + data.model.id).replace();
        });
    }

    function cancel() {
        window.history.back();
    }

    vm.accion = $routeParams.accion;

    $http.post("administracion/puerto/superpuerto-edit.action", {
        accion : $routeParams.accion,
        model : {
            id : $routeParams.sprtId
        }
    }).success(function(data) {
        vm.sprt = data.model;
        vm.i18nMap = data.i18nMap;
    });

    pageTitleService.setTitle("sprt", "page_edit");
}

function PuertoGridController($http, $routeParams, $location, pageTitleService) {
    var vm = this;

    vm.search = search;
    vm.pageChanged = pageChanged;
    vm.filter = filter;

    function search(page) {
        $http.post("administracion/puerto/puerto-list.action", {
            model : vm.prtoCriterio,
            page : page
        }).success(function(data) {
            vm.prtoList = data.resultList;
            vm.page = data.resultList.page;

            $location.search({
                page : vm.page,
                prtoCriterio : JSON.stringify(vm.prtoCriterio)
            }).replace();
        });
    }

    function pageChanged() {
        search(vm.page);
    }

    function filter(size) {
        $http.post("administracion/puerto/puerto-filter.action", {
            model : vm.prtoCriterio
        }).success(function(data) {
            vm.sprtList = data.sprtList;
        });
    }

    vm.prtoCriterio = $routeParams.prtoCriterio ? angular.fromJson($routeParams.prtoCriterio) : {};

    search(1);

    pageTitleService.setTitle("prto", "page_grid");
}

function PuertoDetailController($http, $routeParams, pageTitleService) {
    var vm = this;

    vm.remove = remove;

    function remove() {
        if (confirm("Are you sure?")) {
            $http.post("administracion/puerto/puerto-remove.action", {
                model : vm.prto
            }).success(function(data) {
                window.history.back();
            });
        }
    }

    $http.post("administracion/puerto/puerto-detail.action", {
        model : {
            id : $routeParams.prtoId
        }
    }).success(function(data) {
        vm.prto = data.model;
        vm.i18nMap = data.i18nMap;
    });

    pageTitleService.setTitle("prto", "page_detail");
}

function PuertoEditController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        $http.post("administracion/puerto/puerto-save.action", {
            accion : $routeParams.accion,
            model : vm.prto,
            i18nMap : vm.i18nMap
        }).success(function(data) {
            vm.accion == 'edit' ? setTimeout(function() {
                window.history.back();
            }, 0) : $location.path("/administracion/puerto-detail/" + data.model.id).replace();
        });
    }

    function cancel() {
        window.history.back();
    }

    vm.accion = $routeParams.accion;

    $http.post("administracion/puerto/puerto-edit.action", {
        accion : $routeParams.accion,
        model : {
            id : $routeParams.prtoId
        }
    }).success(function(data) {
        vm.prto = data.model;
        vm.i18nMap = data.i18nMap;

        vm.sprtList = data.sprtList;
    });

    pageTitleService.setTitle("prto", "page_edit");
}
