angular.module("metamodelo", [])

.config(config)

// -------------------- TIPO DE DATO ------------------
.controller("TpdtGridController", TpdtGridController)

.controller("TpdtDetailController", TpdtDetailController)

.controller("TpdtEditController", TpdtEditController)

.controller("CdrfDetailController", CdrfDetailController)

.controller("CdrfEditController", CdrfEditController)

// -------------------- MAESTRO ------------------
.controller("TpprGridController", TpprGridController)

.controller("TpprDetailController", TpprDetailController)

.controller("TpprEditController", TpprEditController)

.controller("TpspDetailController", TpspDetailController)

.controller("TpspEditController", TpspEditController)

// -------------------- TIPO DE SERVICIO ------------------
.controller("TpsrGridController", TpsrGridController)

.controller("TpsrDetailController", TpsrDetailController)

.controller("TpsrEditController", TpsrEditController)

.controller("TpssDetailController", TpssDetailController)

.controller("TpssEditController", TpssEditController)

// -------------------- ESTADISTICA ------------------
.controller("TpesGridController", TpesGridController)

.controller("TpesDetailController", TpesDetailController)

.controller("TpesEditController", TpesEditController)

.controller("CmagDetailController", CmagDetailController)

.controller("CmagEditController", CmagEditController)

// ------------------- GRUPO DE DATO DE ENTIDAD --------------------
.controller("EngdDetailController", EngdDetailController)

.controller("EngdEditController", EngdEditController)

// ------------------- DATO DE ENTIDAD --------------------
.controller("EntdDetailController", EntdDetailController)

.controller("EntdEditController", EntdEditController)

// ------------------- ACCION DE ENTIDAD --------------------
.controller("EnacDetailController", EnacDetailController)

.controller("EnacEditController", EnacEditController)

// ------------------- ACCION DE GRID DE ENTIDAD --------------------
.controller("EnagDetailController", EnagDetailController)

.controller("EnagEditController", EnagEditController)

// ------------------- DEPENDENCIA ENTRE ENTIDADES --------------------
.controller("EnenEditController", EnenEditController);

function config($routeProvider) {
    $routeProvider

    .when("/metamodelo/tpdt/grid", {
        templateUrl : "modules/metamodelo/tpdt-grid.html",
        controller : "TpdtGridController",
        controllerAs : 'vm',
        reloadOnSearch : false
    })

    .when("/metamodelo/tpdt/detail/:tpdtId", {
        templateUrl : "modules/metamodelo/tpdt-detail.html",
        controller : "TpdtDetailController",
        controllerAs : 'vm'
    })

    .when("/metamodelo/tpdt/edit/:accion/:tpdtId?", {
        templateUrl : "modules/metamodelo/tpdt-edit.html",
        controller : "TpdtEditController",
        controllerAs : 'vm'
    })

    .when("/metamodelo/cdrf/detail/:cdrfId", {
        templateUrl : "modules/metamodelo/cdrf-detail.html",
        controller : "CdrfDetailController",
        controllerAs : 'vm'
    })

    .when("/metamodelo/cdrf/edit/:accion/:tpdtId/:cdrfId?", {
        templateUrl : "modules/metamodelo/cdrf-edit.html",
        controller : "CdrfEditController",
        controllerAs : 'vm'
    })

    .when("/metamodelo/tppr/grid", {
        templateUrl : "modules/metamodelo/tppr-grid.html",
        controller : "TpprGridController",
        controllerAs : 'vm',
        reloadOnSearch : false
    })

    .when("/metamodelo/tppr/detail/:entiId", {
        templateUrl : "modules/metamodelo/tppr-detail.html",
        controller : "TpprDetailController",
        controllerAs : 'vm'
    })

    .when("/metamodelo/tppr/edit/:accion/:entiId?", {
        templateUrl : "modules/metamodelo/tppr-edit.html",
        controller : "TpprEditController",
        controllerAs : 'vm'
    })

    .when("/metamodelo/tpsp/detail/:entiId", {
        templateUrl : "modules/metamodelo/tpsp-detail.html",
        controller : "TpspDetailController",
        controllerAs : 'vm'
    })

    .when("/metamodelo/tpsp/edit/:accion/:tpprId/:entiId?", {
        templateUrl : "modules/metamodelo/tpsp-edit.html",
        controller : "TpspEditController",
        controllerAs : 'vm'
    })

    .when("/metamodelo/tpsr/grid", {
        templateUrl : "modules/metamodelo/tpsr-grid.html",
        controller : "TpsrGridController",
        controllerAs : 'vm',
        reloadOnSearch : false
    })

    .when("/metamodelo/tpsr/detail/:entiId", {
        templateUrl : "modules/metamodelo/tpsr-detail.html",
        controller : "TpsrDetailController",
        controllerAs : 'vm'
    })

    .when("/metamodelo/tpsr/edit/:accion/:entiId?", {
        templateUrl : "modules/metamodelo/tpsr-edit.html",
        controller : "TpsrEditController",
        controllerAs : 'vm'
    })

    .when("/metamodelo/tpss/detail/:entiId", {
        templateUrl : "modules/metamodelo/tpss-detail.html",
        controller : "TpssDetailController",
        controllerAs : 'vm'
    })

    .when("/metamodelo/tpss/edit/:accion/:tpsrId/:entiId?", {
        templateUrl : "modules/metamodelo/tpss-edit.html",
        controller : "TpssEditController",
        controllerAs : 'vm'
    })

    .when("/metamodelo/tpes/grid", {
        templateUrl : "modules/metamodelo/tpes-grid.html",
        controller : "TpesGridController",
        controllerAs : 'vm',
        reloadOnSearch : false
    })

    .when("/metamodelo/tpes/detail/:entiId", {
        templateUrl : "modules/metamodelo/tpes-detail.html",
        controller : "TpesDetailController",
        controllerAs : 'vm'
    })

    .when("/metamodelo/tpes/edit/:accion/:entiId?", {
        templateUrl : "modules/metamodelo/tpes-edit.html",
        controller : "TpesEditController",
        controllerAs : 'vm'
    })

    .when("/metamodelo/cmag/detail/:tpesId/:entdId", {
        templateUrl : "modules/metamodelo/cmag-detail.html",
        controller : "CmagDetailController",
        controllerAs : 'vm'
    })

    .when("/metamodelo/cmag/edit/:accion/:tpesId/:entdId?", {
        templateUrl : "modules/metamodelo/cmag-edit.html",
        controller : "CmagEditController",
        controllerAs : 'vm'
    })

    .when("/metamodelo/entd/detail/:entiId/:tpdtId", {
        templateUrl : "modules/metamodelo/entd-detail.html",
        controller : "EntdDetailController",
        controllerAs : 'vm'
    })

    .when("/metamodelo/entd/edit/:accion/:entiId/:tpdtId?", {
        templateUrl : "modules/metamodelo/entd-edit.html",
        controller : "EntdEditController",
        controllerAs : 'vm'
    })

    .when("/metamodelo/engd/detail/:engdId", {
        templateUrl : "modules/metamodelo/engd-detail.html",
        controller : "EngdDetailController",
        controllerAs : 'vm'
    })

    .when("/metamodelo/engd/edit/:accion/:entiId/:engdId?", {
        templateUrl : "modules/metamodelo/engd-edit.html",
        controller : "EngdEditController",
        controllerAs : 'vm'
    })

    .when("/metamodelo/enac/detail/:id", {
        templateUrl : "modules/metamodelo/enac-detail.html",
        controller : "EnacDetailController",
        controllerAs : 'vm'
    })

    .when("/metamodelo/enac/edit/:accion/:entiId/:id?", {
        templateUrl : "modules/metamodelo/enac-edit.html",
        controller : "EnacEditController",
        controllerAs : 'vm'
    })

    .when("/metamodelo/enag/detail/:id", {
        templateUrl : "modules/metamodelo/enag-detail.html",
        controller : "EnagDetailController",
        controllerAs : 'vm'
    })

    .when("/metamodelo/enag/edit/:accion/:entiId/:id?", {
        templateUrl : "modules/metamodelo/enag-edit.html",
        controller : "EnagEditController",
        controllerAs : 'vm'
    })

    .when("/metamodelo/enen/edit/:accion/:entipId", {
        templateUrl : "modules/metamodelo/enen-edit.html",
        controller : "EnenEditController",
        controllerAs : 'vm'
    });
}

function TpdtGridController($http, $location, $routeParams, $modal, pageTitleService) {
    var vm = this;

    vm.search = search;
    vm.pageChanged = pageChanged;
    vm.filter = filter;

    function search(page) {
        $http.post("metamodelo/tipo-dato-list.action", {
            model : vm.tpdtCriterio,
            page : page,
            limit : vm.limit
        }).success(function(data) {
            vm.tpdtList = data.resultList;
            vm.page = data.resultList.page;

            $location.search({
                page : vm.page,
                tpdtCriterio : JSON.stringify(vm.tpdtCriterio)
            }).replace();
        });
    }

    function pageChanged() {
        search(vm.page);
    }

    function filter(size) {
        $http.post("metamodelo/tipo-dato-filter.action", {
            model : vm.tpdtCriterio
        }).success(function(data) {
            vm.tphtList = data.tphtList;
            vm.tpelList = data.tpelList;
        });
    }

    vm.tpdtCriterio = $routeParams.tpdtCriterio ? angular.fromJson($routeParams.tpdtCriterio) : {};

    search($routeParams.page);
    pageTitleService.setTitle("tpdt", "page_grid");
}

function TpdtDetailController($http, $routeParams, pageTitleService) {
    var vm = this;

    vm.remove = remove;

    function remove() {
        if (confirm("Are you sure?")) {
            $http.post("metamodelo/tipo-dato-remove.action", {
                model : vm.tpdt
            }).success(function(data) {
                window.history.back();
            });
        }
    }

    $http.post("metamodelo/tipo-dato-detail.action", {
        model : {
            id : $routeParams.tpdtId
        }
    }).success(function(data) {
        vm.tpdt = data.model;
        vm.i18nMap = data.i18nMap;
    });

    pageTitleService.setTitle("tpdt", "page_detail");
}

function TpdtEditController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.accion = $routeParams.accion;
    vm.save = save;
    vm.cancel = cancel;

    function save() {
        $http.post("metamodelo/tipo-dato-save.action", {
            model : vm.tpdt,
            i18nMap : vm.i18nMap,
            accion : vm.accion
        }).success(function(data) {
            vm.accion == 'edit' ? setTimeout(function() {
                window.history.back();
            }, 0) : $location.path("/metamodelo/tpdt/detail/" + data.model.id).replace();
        });
    }

    function cancel() {
        window.history.back();
    }

    $http.post("metamodelo/tipo-dato-edit.action", {
        model : {
            id : $routeParams.tpdtId
        },
        accion : vm.accion
    }).success(function(data) {
        vm.tpdt = data.model;
        vm.i18nMap = data.i18nMap;
        vm.tphtList = data.tphtList;
        vm.tpelList = data.tpelList;

        vm.entiTpprList = data.tpprList;
        vm.entiTpsrList = data.tpsrList;
    });

    pageTitleService.setTitle("tpdt", "page_" + vm.accion);
}

function CdrfDetailController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.remove = remove;

    function remove() {
        if (confirm("Are you sure?")) {
            $http.post("metamodelo/codigo-referencia-remove.action", {
                model : vm.cdrf
            }).success(function(data) {
                window.history.back();
            });
        }
    }

    $http.post("metamodelo/codigo-referencia-detail.action", {
        model : {
            id : $routeParams.cdrfId
        }
    }).success(function(data) {
        vm.cdrf = data.model;
        vm.i18nMap = data.i18nMap;
    });

    pageTitleService.setTitle("cdrf", "page_detail");
}

function CdrfEditController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.accion = $routeParams.accion;
    vm.save = save;
    vm.cancel = cancel;

    function save() {
        $http.post("metamodelo/codigo-referencia-save.action", {
            model : vm.cdrf,
            i18nMap : vm.i18nMap,
            accion : vm.accion
        }).success(function(data) {
            vm.accion == 'edit' ? setTimeout(function() {
                window.history.back();
            }, 0) : $location.path("/metamodelo/cdrf/detail/" + data.model.id).replace();
        });
    }

    function cancel() {
        window.history.back();
    }

    $http.post("metamodelo/codigo-referencia-edit.action", {
        model : {
            tpdtId : $routeParams.tpdtId,
            id : $routeParams.cdrfId
        },
        accion : $routeParams.accion
    }).success(function(data) {
        vm.cdrf = data.model;
        vm.i18nMap = data.i18nMap;
    });

    pageTitleService.setTitle("cdrf", "page_" + vm.accion);
}

function TpprGridController($http, $location, $routeParams, $modal, pageTitleService) {
    var vm = this;

    vm.search = search;
    vm.pageChanged = pageChanged;
    vm.filter = filter;

    vm.entiCriterio = $routeParams.entiCriterio ? angular.fromJson($routeParams.entiCriterio) : {};

    function search(page) {
        $http.post("metamodelo/tipo-parametro-list.action", {
            model : vm.entiCriterio,
            page : page,
            limit : vm.limit
        }).success(function(data) {
            vm.entiList = data.resultList;
            vm.page = data.resultList.page;

            $location.search({
                page : vm.page,
                entiCriterio : JSON.stringify(vm.entiCriterio)
            }).replace();
        });
    }

    function pageChanged() {
        search(vm.page);
    }

    function filter(size) {
    }

    search($routeParams.page ? $routeParams.page : 1);
    pageTitleService.setTitle("tppr", "page_grid");
}

function TpprDetailController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.remove = remove;

    function remove() {
        if (confirm("Are you sure?")) {
            $http.post("metamodelo/tipo-parametro-remove.action", {
                model : {
                    id : vm.enti.id
                }
            }).success(function(data) {
                window.history.back();
            });
        }
    }

    $http.post("metamodelo/tipo-parametro-detail.action", {
        model : {
            id : $routeParams.entiId
        }
    }).success(function(data) {
        vm.enti = data.model;
        vm.subentiList = data.subentiList;
        vm.entdList = data.entdList;
        vm.engdList = data.engdList;
        vm.enacList = data.enacList;
        vm.enagList = data.enagList;
        vm.i18nMap = data.i18nMap;
    });

    pageTitleService.setTitle("tppr", "page_detail");
}

function TpprEditController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.accion = $routeParams.accion;
    vm.save = save;
    vm.cancel = cancel;

    function save() {
        $http.post("metamodelo/tipo-parametro-save.action", {
            model : vm.enti,
            i18nMap : vm.i18nMap,
            accion : vm.accion
        }).success(function(data) {
            vm.accion == 'edit' ? setTimeout(function() {
                window.history.back();
            }, 0) : $location.path("/metamodelo/tppr/detail/" + data.model.id).replace();
        });
    }

    function cancel() {
        window.history.back();
    }

    $http.post("metamodelo/tipo-parametro-edit.action", {
        model : {
            id : $routeParams.entiId
        },
        accion : vm.accion
    }).success(function(data) {
        vm.enti = data.model;
        vm.i18nMap = data.i18nMap;
        vm.tpdtNombreList = data.tpdtNombreList;
    });

    pageTitleService.setTitle("tppr", "page_" + vm.accion);
}

function TpspDetailController($http, $routeParams, pageTitleService) {
    var vm = this;

    vm.remove = remove;

    function remove() {
        if (confirm("Are you sure?")) {
            $http.post("metamodelo/tipo-subparametro-remove.action", {
                model : {
                    id : vm.enti.id
                }
            }).success(function(data) {
                window.history.back();
            });
        }
    }

    $http.post("metamodelo/tipo-subparametro-detail.action", {
        model : {
            id : $routeParams.entiId
        }
    }).success(function(data) {
        vm.enti = data.model;
        vm.i18nMap = data.i18nMap;
        vm.entdList = data.entdList;
        vm.engdList = data.engdList;
        vm.enacList = data.enacList;
        vm.enagList = data.enagList;
    });

    pageTitleService.setTitle("tpsp", "page_detail");
}

function TpspEditController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.accion = $routeParams.accion;
    vm.save = save;
    vm.cancel = cancel;

    function save() {
        $http.post("metamodelo/tipo-subparametro-save.action", {
            model : vm.enti,
            i18nMap : vm.i18nMap,
            accion : vm.accion
        }).success(function(data) {
            vm.accion == 'edit' ? setTimeout(function() {
                window.history.back();
            }, 0) : $location.path("/metamodelo/tpsp/detail/" + data.model.id).replace();
        });
    }

    function cancel() {
        window.history.back();
    }

    $http.post("metamodelo/tipo-subparametro-edit.action", {
        model : {
            tpprId : $routeParams.tpprId,
            id : $routeParams.entiId
        },
        accion : vm.accion
    }).success(function(data) {
        vm.enti = data.model;
        vm.i18nMap = data.i18nMap;
        vm.accion = data.accion;
        vm.entiList = data.tpprList;
    });

    pageTitleService.setTitle("tpsp", "page_" + vm.accion);
}

function TpsrGridController($http, $location, $routeParams, $modal, pageTitleService) {
    var vm = this;

    vm.search = search;
    vm.pageChanged = pageChanged;
    vm.filter = filter;

    vm.entiCriterio = $routeParams.entiCriterio ? angular.fromJson($routeParams.entiCriterio) : {};

    function search(page) {
        $http.post("metamodelo/tipo-servicio-list.action", {
            model : vm.entiCriterio,
            page : page,
            limit : vm.limit
        }).success(function(data) {
            vm.entiList = data.resultList;
            vm.page = data.resultList.page;

            $location.search({
                page : vm.page,
                entiCriterio : JSON.stringify(vm.entiCriterio)
            }).replace();
        });
    }

    function pageChanged() {
        search(vm.page);
    }

    function filter(size) {
    }

    search($routeParams.page ? $routeParams.page : 1);
    pageTitleService.setTitle("tpsr", "page_grid");
}

function TpsrDetailController($http, $routeParams, pageTitleService) {
    var vm = this;

    vm.remove = remove;

    function remove() {
        if (confirm("Are you sure?")) {
            $http.post("metamodelo/tipo-servicio-remove.action", {
                model : vm.enti
            }).success(function(data) {
                window.history.back();
            });
        }
    }

    $http.post("metamodelo/tipo-servicio-detail.action", {
        model : {
            id : $routeParams.entiId
        }
    }).success(function(data) {
        vm.enti = data.model;
        vm.i18nMap = data.i18nMap;
        vm.subentiList = data.subentiList;
        vm.entiHijasList = data.entiHijasList;
        vm.entdList = data.entdList;
        vm.engdList = data.engdList;
        vm.enacList = data.enacList;
        vm.enagList = data.enagList;
    });

    pageTitleService.setTitle("tpsr", "page_detail");
}

function TpsrEditController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.accion = $routeParams.accion;
    vm.save = save;
    vm.cancel = cancel;

    function save() {
        $http.post("metamodelo/tipo-servicio-save.action", {
            model : vm.enti,
            i18nMap : vm.i18nMap,
            accion : vm.accion
        }).success(function(data) {
            vm.accion == 'edit' ? setTimeout(function() {
                window.history.back();
            }, 0) : $location.path("/metamodelo/tpsr/detail/" + data.model.id).replace();
        });
    }

    function cancel() {
        window.history.back();
    }

    $http.post("metamodelo/tipo-servicio-edit.action", {
        model : {
            id : $routeParams.entiId
        },
        accion : vm.accion
    }).success(function(data) {
        vm.enti = data.model;
        vm.i18nMap = data.i18nMap;
        vm.tpdtEstadoList = data.tpdtEstadoList;
    });

    pageTitleService.setTitle("tpsr", "page_" + vm.accion);
}

function TpssDetailController($http, $routeParams, pageTitleService) {
    var vm = this;

    vm.remove = remove;

    function remove() {
        if (confirm("Are you sure?")) {
            $http.post("metamodelo/tipo-subservicio-remove.action", {
                model : vm.enti
            }).success(function(data) {
                window.history.back();
            });
        }
    }

    $http.post("metamodelo/tipo-subservicio-detail.action", {
        model : {
            id : $routeParams.entiId
        }
    }).success(function(data) {
        vm.enti = data.model;
        vm.i18nMap = data.i18nMap;
        vm.entiHijasList = data.entiHijasList;
        vm.entiPadresList = data.entiPadresList;
        vm.entdList = data.entdList;
        vm.engdList = data.engdList;
        vm.enacList = data.enacList;
        vm.enagList = data.enagList;
    });

    pageTitleService.setTitle("tpss", "page_detail");
}

function TpssEditController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.accion = $routeParams.accion;
    vm.save = save;
    vm.cancel = cancel;

    function save() {
        $http.post("metamodelo/tipo-subservicio-save.action", {
            model : vm.enti,
            i18nMap : vm.i18nMap,
            accion : vm.accion
        }).success(function(data) {
            vm.accion == 'edit' ? setTimeout(function() {
                window.history.back();
            }, 0) : $location.path("/metamodelo/tpss/detail/" + data.model.id).replace();
        });
    }

    function cancel() {
        window.history.back();
    }

    $http.post("metamodelo/tipo-subservicio-edit.action", {
        model : {
            id : $routeParams.entiId,
            tpsrId : $routeParams.tpsrId
        },
        accion : vm.accion
    }).success(function(data) {
        vm.enti = data.model;
        vm.i18nMap = data.i18nMap;
        vm.tpdtEstadoList = data.tpdtEstadoList;
    });

    pageTitleService.setTitle("tpss", "page_" + vm.accion);
}

function TpesGridController($http, $location, $routeParams, $modal, pageTitleService) {
    var vm = this;

    vm.search = search;
    vm.pageChanged = pageChanged;
    vm.filter = filter;

    vm.entiCriterio = $routeParams.entiCriterio ? angular.fromJson($routeParams.entiCriterio) : {};

    function search(page) {
        $http.post("metamodelo/tipo-estadistica-list.action", {
            model : vm.entiCriterio,
            page : page,
            limit : vm.limit
        }).success(function(data) {
            vm.entiList = data.resultList;
            vm.page = data.resultList.page;

            $location.search({
                page : vm.page,
                entiCriterio : JSON.stringify(vm.entiCriterio)
            }).replace();
        });
    }

    function pageChanged() {
        search(vm.page);
    }

    function filter(size) {
    }

    search($routeParams.page ? $routeParams.page : 1);
    pageTitleService.setTitle("tpes", "page_grid");
}

function TpesDetailController($http, $routeParams, pageTitleService) {
    var vm = this;

    vm.remove = remove;

    function remove() {
        if (confirm("Are you sure?")) {
            $http.post("metamodelo/tipo-estadistica-remove.action", {
                model : vm.enti
            }).success(function(data) {
                window.history.back();
            });
        }
    }

    $http.post("metamodelo/tipo-estadistica-detail.action", {
        model : {
            id : $routeParams.entiId
        }
    }).success(function(data) {
        vm.enti = data.model;
        vm.i18nMap = data.i18nMap;
        vm.cmagList = data.cmagList;
        vm.subentiList = data.subentiList;
        vm.entdList = data.entdList;
        vm.engdList = data.engdList;
        vm.enacList = data.enacList;
        vm.enagList = data.enagList;
    });

    pageTitleService.setTitle("tpes", "page_detail");
}

function TpesEditController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.accion = $routeParams.accion;
    vm.save = save;
    vm.cancel = cancel;

    function save() {
        $http.post("metamodelo/tipo-estadistica-save.action", {
            model : vm.enti,
            i18nMap : vm.i18nMap,
            accion : vm.accion
        }).success(function(data) {
            vm.accion == 'edit' ? setTimeout(function() {
                window.history.back();
            }, 0) : $location.path("/metamodelo/tpes/detail/" + data.model.id).replace();
        });
    }

    function cancel() {
        window.history.back();
    }

    $http.post("metamodelo/tipo-estadistica-edit.action", {
        model : {
            id : $routeParams.entiId
        },
        accion : vm.accion
    }).success(function(data) {
        vm.enti = data.model;
        vm.i18nMap = data.i18nMap;
    });

    pageTitleService.setTitle("tpes", "page_" + vm.accion);
}

function CmagDetailController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.remove = remove;

    function remove() {
        if (confirm("Are you sure?")) {
            $http.post("metamodelo/campo-agregacion-remove.action", {
                model : vm.cmag
            }).success(function(data) {
                window.history.back();
            });
        }
    }

    $http.post("metamodelo/campo-agregacion-detail.action", {
        model : {
            tpesId : $routeParams.tpesId,
            entd : {
                id : $routeParams.entdId
            }
        }
    }).success(function(data) {
        vm.cmag = data.model;
    });

    pageTitleService.setTitle("cmag", "page_detail");
}

function CmagEditController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.accion = $routeParams.accion;
    vm.save = save;
    vm.cancel = cancel;

    function save() {
        $http.post("metamodelo/campo-agregacion-save.action", {
            model : vm.cmag,
            accion : vm.accion
        }).success(
                function(data) {
                    vm.accion == 'edit' ? setTimeout(function() {
                        window.history.back();
                    }, 0) : $location.path(
                            "/metamodelo/cmag/detail/" + data.model.tpesId + "/" + data.model.entd.id)
                            .replace();
                });
    }

    function cancel() {
        window.history.back();
    }

    $http.post("metamodelo/campo-agregacion-edit.action", {
        model : {
            tpesId : $routeParams.tpesId,
            entd : {
                id : $routeParams.entdId
            }
        },
        accion : vm.accion
    }).success(function(data) {
        vm.cmag = data.model;
    });

    pageTitleService.setTitle("cmag", "page_" + vm.accion);
}

function EntdDetailController($http, $routeParams, pageTitleService) {
    var vm = this;

    vm.remove = remove;

    function remove() {
        if (confirm("Are you sure?")) {
            $http.post("metamodelo/entidad-tipo-dato-remove.action", {
                model : vm.entd
            }).success(function(data) {
                window.history.back();
            });
        }
    }

    $http.post("metamodelo/entidad-tipo-dato-detail.action", {
        model : {
            entiId : $routeParams.entiId,
            tpdt : {
                id : $routeParams.tpdtId
            }
        }
    }).success(function(data) {
        vm.entd = data.model;
        vm.i18nMap = data.i18nMap;
    });

    pageTitleService.setTitle("entd", "page_detail");
}

function EntdEditController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.accion = $routeParams.accion;
    vm.save = save;
    vm.cancel = cancel;

    function save() {
        $http.post("metamodelo/entidad-tipo-dato-save.action", {
            model : vm.entd,
            i18nMap : vm.i18nMap,
            accion : vm.accion
        }).success(
                function(data) {
                    vm.accion == 'edit' ? setTimeout(function() {
                        window.history.back();
                    }, 0) : $location.path(
                            "/metamodelo/entd/detail/" + data.model.entiId + "/" + data.model.tpdt.id)
                            .replace();
                });
    }

    function cancel() {
        window.history.back();
    }

    $http.post("metamodelo/entidad-tipo-dato-edit.action", {
        model : {
            entiId : $routeParams.entiId,
            tpdt : {
                id : $routeParams.tpdtId
            }
        },
        accion : vm.accion
    }).success(function(data) {
        vm.entd = data.model;
        vm.i18nMap = data.i18nMap;
        vm.tpdtList = data.tpdtList;
        vm.engdList = data.engdList;
    });

    pageTitleService.setTitle("entd", "page_" + vm.accion);
}

function EngdDetailController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.remove = remove;

    function remove() {
        if (confirm("Are you sure?")) {
            $http.post("metamodelo/entidad-grupo-dato-remove.action", {
                model : vm.engd
            }).success(function(data) {
                window.history.back();
            });
        }
    }

    $http.post("metamodelo/entidad-grupo-dato-detail.action", {
        model : {
            id : $routeParams.engdId
        }
    }).success(function(data) {
        vm.engd = data.model;
        vm.i18nMap = data.i18nMap;
    });

    pageTitleService.setTitle("engd", "page_detail");
}

function EngdEditController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.accion = $routeParams.accion;
    vm.save = save;
    vm.cancel = cancel;

    function save() {
        $http.post("metamodelo/entidad-grupo-dato-save.action", {
            model : vm.engd,
            i18nMap : vm.i18nMap,
            accion : vm.accion
        }).success(function(data) {
            vm.accion == 'edit' ? setTimeout(function() {
                window.history.back();
            }, 0) : $location.path("/metamodelo/engd/detail/" + data.model.id).replace();
        });
    }

    function cancel() {
        window.history.back();
    }

    $http.post("metamodelo/entidad-grupo-dato-edit.action", {
        model : {
            entiId : $routeParams.entiId,
            id : $routeParams.engdId
        },
        accion : vm.accion
    }).success(function(data) {
        vm.engd = data.model;
        vm.i18nMap = data.i18nMap;
    });

    pageTitleService.setTitle("engd", "page_" + vm.accion);
}

function EnacDetailController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.remove = remove;

    function remove() {
        if (confirm("Are you sure?")) {
            $http.post("metamodelo/entidad-accion-remove.action", {
                model : vm.enac
            }).success(function(data) {
                window.history.back();
            });
        }
    }

    $http.post("metamodelo/entidad-accion-detail.action", {
        model : {
            id : $routeParams.id
        }
    }).success(function(data) {
        vm.enac = data.model;
        vm.i18nMap = data.i18nMap;
    });

    pageTitleService.setTitle("enac", "page_detail");
}

function EnacEditController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.accion = $routeParams.accion;
    vm.save = save;
    vm.cancel = cancel;

    function save() {
        $http.post("metamodelo/entidad-accion-save.action", {
            model : vm.enac,
            i18nMap : vm.i18nMap,
            accion : vm.accion
        }).success(function(data) {
            vm.accion == 'edit' ? setTimeout(function() {
                window.history.back();
            }, 0) : $location.path("/metamodelo/enac/detail/" + data.model.id).replace();
        });
    }

    function cancel() {
        window.history.back();
    }

    $http.post("metamodelo/entidad-accion-edit.action", {
        model : {
            entiId : $routeParams.entiId,
            id : $routeParams.id
        },
        accion : vm.accion
    }).success(function(data) {
        vm.enac = data.model;
        vm.i18nMap = data.i18nMap;
    });

    pageTitleService.setTitle("enac", "page_" + vm.accion);
}

function EnagDetailController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.remove = remove;

    function remove() {
        if (confirm("Are you sure?")) {
            $http.post("metamodelo/entidad-accion-grid-remove.action", {
                model : vm.enag
            }).success(function(data) {
                window.history.back();
            });
        }
    }

    $http.post("metamodelo/entidad-accion-grid-detail.action", {
        model : {
            id : $routeParams.id
        }
    }).success(function(data) {
        vm.enag = data.model;
        vm.i18nMap = data.i18nMap;
    });

    pageTitleService.setTitle("enag", "page_detail");
}

function EnagEditController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.accion = $routeParams.accion;
    vm.save = save;
    vm.cancel = cancel;

    function save() {
        $http.post("metamodelo/entidad-accion-grid-save.action", {
            model : vm.enag,
            i18nMap : vm.i18nMap,
            accion : vm.accion
        }).success(function(data) {
            vm.accion == 'edit' ? setTimeout(function() {
                window.history.back();
            }, 0) : $location.path("/metamodelo/enag/detail/" + data.model.id).replace();
        });
    }

    function cancel() {
        window.history.back();
    }

    $http.post("metamodelo/entidad-accion-grid-edit.action", {
        model : {
            entiId : $routeParams.entiId,
            id : $routeParams.id
        },
        accion : vm.accion
    }).success(function(data) {
        vm.enag = data.model;
        vm.i18nMap = data.i18nMap;
    });

    pageTitleService.setTitle("enag", "page_" + vm.accion);
}

function EnenEditController($http, $routeParams, pageTitleService) {
    var vm = this;

    vm.accion = $routeParams.accion;
    vm.save = save;
    vm.cancel = cancel;

    function save() {
        $http.post("metamodelo/entidad-entidad-save.action", {
            model : vm.enen,
            accion : vm.accion
        }).success(function(data) {
            $location.path("/metamodelo/enen/detail/" + data.model.id).replace();
        });
    }

    function cancel() {
        window.history.back();
    }

    $http.post("metamodelo/entidad-entidad-edit.action", {
        model : {
            entiPadreId : $routeParams.entipId
        },
        accion : vm.accion
    }).success(function(data) {
        vm.enen = data.model;
        vm.entiList = data.tpssList;
    });

    pageTitleService.setTitle("enen", "page_" + vm.accion);
}