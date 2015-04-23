angular.module("facturacion", [])

.config(config)

// ----------------- MENU PRINCIPAL --------------------------
.controller("FacturacionController", FacturacionController)

// ----------- VALORADOR ------------------
.controller("VldrPrepareController", VldrPrepareController)

// ----------- FACTURADOR ------------------
.controller("FctrPrepareController", FctrPrepareController)

// ----------- FACTURA ------------------
.controller("FctrGridController", FctrGridController)

.controller("FctrDetailController", FctrDetailController)

.controller("FctlDetailController", FctlDetailController)

// ----------- VALORACION ------------------
.controller("VlrcGridController", VlrcGridController)

.controller("VlrcDetailController", VlrcDetailController)

.controller("VlrcEditController", VlrcEditController)

.controller("VlrlDetailController", VlrlDetailController)

.controller("VlrlEditController", VlrlEditController)

.controller("VlrdDetailController", VlrdDetailController)

.controller("VlrdEditController", VlrdEditController)

// ----------- SERIE DE FACTURA ------------------
.controller("FcsrGridController", FcsrGridController)

.controller("FcsrDetailController", FcsrDetailController)

.controller("FcsrEditController", FcsrEditController)

// ----------- CARGO y REGLA ------------------
.controller("CrgoGridController", CrgoGridController)

.controller("CrgoDetailController", CrgoDetailController)

.controller("CrgoEditController", CrgoEditController)

.controller("CrgoLupaController", CrgoLupaController)

.controller("RglaDetailController", RglaDetailController)

.controller("RglaEditController", RglaEditController)

.controller("RglaLupaController", RglaLupaController)

.controller("RginDetailController", RginDetailController)

.controller("RginEditController", RginEditController)

// ----------- ASPECTO y ASPECTO CARGO ------------------
.controller("AspcGridController", AspcGridController)

.controller("AspcDetailController", AspcDetailController)

.controller("AspcEditController", AspcEditController)

.controller("AspcLupaController", AspcLupaController)

.controller("AscrDetailController", AscrDetailController)

.controller("AscrEditController", AscrEditController);

function config($routeProvider) {
    $routeProvider

    .when("/facturacion", {
        templateUrl : "modules/facturacion/facturacion.html",
        controller : "FacturacionController",
        controllerAs : "vm"
    })

    .when("/facturacion/vldr/prepare/:entiId/:srvcId", {
        templateUrl : "modules/facturacion/vldr-prepare.html",
        controller : "VldrPrepareController",
        controllerAs : "vm",
        reloadOnSearch : false
    })

    .when("/facturacion/fctr/prepare/:vlrcId", {
        templateUrl : "modules/facturacion/fctr-prepare.html",
        controller : "FctrPrepareController",
        controllerAs : "vm",
        reloadOnSearch : false
    })

    .when("/facturacion/fctr/grid", {
        templateUrl : "modules/facturacion/fctr-grid.html",
        controller : "FctrGridController",
        controllerAs : "vm",
        reloadOnSearch : false
    })

    .when("/facturacion/fctr/detail/:fctrId", {
        templateUrl : "modules/facturacion/fctr-detail.html",
        controller : "FctrDetailController",
        controllerAs : "vm",
        reloadOnSearch : false
    })

    .when("/facturacion/fctl/detail/:fctlId", {
        templateUrl : "modules/facturacion/fctl-detail.html",
        controller : "FctlDetailController",
        controllerAs : "vm",
        reloadOnSearch : false
    })

    .when("/facturacion/vlrc/grid", {
        templateUrl : "modules/facturacion/vlrc-grid.html",
        controller : "VlrcGridController",
        controllerAs : "vm",
        reloadOnSearch : false
    })

    .when("/facturacion/vlrc/detail/:vlrcId", {
        templateUrl : "modules/facturacion/vlrc-detail.html",
        controller : "VlrcDetailController",
        controllerAs : "vm",
        reloadOnSearch : false
    })

    .when("/facturacion/vlrc/edit/:accion/:vlrcId?", {
        templateUrl : "modules/facturacion/vlrc-edit.html",
        controller : "VlrcEditController",
        controllerAs : "vm"
    })

    .when("/facturacion/vlrl/detail/:vlrcId/:vlrlId", {
        templateUrl : "modules/facturacion/vlrl-detail.html",
        controller : "VlrlDetailController",
        controllerAs : "vm",
        reloadOnSearch : false
    })

    .when("/facturacion/vlrl/edit/:accion/:vlrcId/:vlrlId?", {
        templateUrl : "modules/facturacion/vlrl-edit.html",
        controller : "VlrlEditController",
        controllerAs : "vm"
    })

    .when("/facturacion/vlrd/detail/:vlrcId/:vlrlId/:vlrdId", {
        templateUrl : "modules/facturacion/vlrd-detail.html",
        controller : "VlrdDetailController",
        controllerAs : "vm"
    })

    .when("/facturacion/vlrd/edit/:accion/:vlrcId/:vlrlId/:vlrdId?", {
        templateUrl : "modules/facturacion/vlrd-edit.html",
        controller : "VlrdEditController",
        controllerAs : "vm"
    })

    .when("/facturacion/fcsr/grid", {
        templateUrl : "modules/facturacion/fcsr-grid.html",
        controller : "FcsrGridController",
        controllerAs : "vm",
        reloadOnSearch : false
    })

    .when("/facturacion/fcsr/detail/:fcsrId", {
        templateUrl : "modules/facturacion/fcsr-detail.html",
        controller : "FcsrDetailController",
        controllerAs : "vm"
    })

    .when("/facturacion/fcsr/edit/:accion/:fcsrId?", {
        templateUrl : "modules/facturacion/fcsr-edit.html",
        controller : "FcsrEditController",
        controllerAs : "vm"
    })

    .when("/facturacion/crgo/grid", {
        templateUrl : "modules/facturacion/crgo-grid.html",
        controller : "CrgoGridController",
        controllerAs : "vm",
        reloadOnSearch : false
    })

    .when("/facturacion/crgo/detail/:crgoId/:fechaVigencia?", {
        templateUrl : "modules/facturacion/crgo-detail.html",
        controller : "CrgoDetailController",
        controllerAs : "vm"
    })

    .when("/facturacion/crgo/edit/:accion/:crgoId?/:fechaVigencia?", {
        templateUrl : "modules/facturacion/crgo-edit.html",
        controller : "CrgoEditController",
        controllerAs : "vm"
    })

    .when("/facturacion/rgla/detail/:rglaId/:fechaVigencia?", {
        templateUrl : "modules/facturacion/rgla-detail.html",
        controller : "RglaDetailController",
        controllerAs : "vm"
    })

    .when("/facturacion/rgla/edit/:accion/:crgoId/:fechaVigencia?/:rglaId?", {
        templateUrl : "modules/facturacion/rgla-edit.html",
        controller : "RglaEditController",
        controllerAs : "vm"
    })

    .when("/facturacion/rgin/detail/:rginId/:fechaVigencia?", {
        templateUrl : "modules/facturacion/rgin-detail.html",
        controller : "RginDetailController",
        controllerAs : "vm"
    })

    .when("/facturacion/rgin/edit/:accion/:rgla1Id/:fechaVigencia?/:rginId?", {
        templateUrl : "modules/facturacion/rgin-edit.html",
        controller : "RginEditController",
        controllerAs : "vm"
    })

    .when("/facturacion/aspc/grid", {
        templateUrl : "modules/facturacion/aspc-grid.html",
        controller : "AspcGridController",
        controllerAs : "vm",
        reloadOnSearch : false
    })

    .when("/facturacion/aspc/detail/:aspcId/:fechaVigencia?", {
        templateUrl : "modules/facturacion/aspc-detail.html",
        controller : "AspcDetailController",
        controllerAs : "vm"
    })

    .when("/facturacion/aspc/edit/:accion/:aspcId?/:fechaVigencia?", {
        templateUrl : "modules/facturacion/aspc-edit.html",
        controller : "AspcEditController",
        controllerAs : "vm"
    })

    .when("/facturacion/ascr/detail/:ascrId/:fechaVigencia?", {
        templateUrl : "modules/facturacion/ascr-detail.html",
        controller : "AscrDetailController",
        controllerAs : "vm"
    })

    .when("/facturacion/ascr/edit/:accion/:aspcId/:fechaVigencia?/:ascrId?", {
        templateUrl : "modules/facturacion/ascr-edit.html",
        controller : "AscrEditController",
        controllerAs : "vm"
    });
}

function FacturacionController(pageTitleService) {
    pageTitleService.setTitle("sec_facturacion", "page_home");
}

function VldrPrepareController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.valorar = valorar;
    vm.cancel = cancel;

    function valorar() {
        $http.post("facturacion/vldr-valorar.action", {
            fliq : vm.fliq,
            srvc : vm.srvc
        }).success(function(data) {
            $location.path("/proceso/prbt/grid").replace();
        });
    }

    function cancel() {
        window.history.back();
    }

    $http.post("facturacion/vldr-prepare.action", {
        srvc : {
            id : $routeParams.srvcId,
            entiId : $routeParams.entiId
        }
    }).success(function(data) {
        vm.srvc = data.srvc;
        vm.fliq = data.fliq;
    });

    pageTitleService.setTitle("vldr", "page_prepare");
}

function FctrPrepareController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.facturar = facturar;
    vm.cancel = cancel;

    function facturar() {
        $http.post("facturacion/fctr-facturar.action", {
            ffac : vm.ffac,
            vlrc : vm.vlrc,
            aspcId : vm.aspcId,
            fcsrId : vm.fcsrId
        }).success(function(data) {
            $location.path("/proceso/prbt/grid").replace();
        });
    }

    function cancel() {
        window.history.back();
    }

    $http.post("facturacion/fctr-prepare.action", {
        vlrc : {
            id : $routeParams.vlrcId
        }
    }).success(function(data) {
        vm.vlrc = data.vlrc;
        vm.ffac = data.ffac;
        vm.aspcId = data.aspcId;
        vm.aspcList = data.aspcList;
        vm.fcsrList = data.fcsrList;
    });

    pageTitleService.setTitle("fctr", "page_prepare");
}

function FctrGridController($http, $location, $routeParams, $modal, pageTitleService) {
    var vm = this;

    vm.search = search;
    vm.pageChanged = pageChanged;
    vm.filter = filter;

    vm.fctrCriterio = $routeParams.fctrCriterio ? angular.fromJson($routeParams.fctrCriterio) : {};

    function search(page) {
        $http.post("facturacion/fctr-list.action", {
            fctrCriterio : vm.fctrCriterio,
            page : page,
            limit : vm.limit
        }).success(function(data) {
            vm.page = data.fctrList.page;
            vm.fctrList = data.fctrList;
            vm.fctrCriterio = data.fctrCriterio;

            $location.search({
                page : vm.page,
                fctrCriterio : JSON.stringify(vm.fctrCriterio)
            }).replace();
        });
    }

    function pageChanged() {
        search(vm.page);
    }

    function filter(size) {
        $http.post("facturacion/fctr-filter.action").success(function(data) {
            // vm.tpsrList = data.tpsrList;
        });
    }

    search($routeParams.page ? $routeParams.page : 1);
    pageTitleService.setTitle("fctr", "page_grid");
}

function FctrDetailController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.pageChanged = pageChanged;
    vm.tabSelected = tabSelected;
    vm.print = print;

    vm.tab = $routeParams.tab ? $routeParams.tab : null;
    vm.path = $location.path();

    function findFctlList(page) {
        $http.post("facturacion/fctl-list.action", {
            fctrId : $routeParams.fctrId,
            page : page
        }).success(function(data) {
            vm.fctlList = data.fctlList;
            vm.page = data.fctlList.page;

            $location.search("page", vm.page).replace();
        });
    }

    function pageChanged() {
        findFctlList(vm.page);
    }

    function tabSelected(tabNo) {
        if (vm.path == $location.path()) {
            $location.search("tab", tabNo).replace();
        }
    }

    function print() {
        $http.post('facturacion/fctr-print.action', {
            fctrId : vm.fctr.id
        }, {
            responseType : 'arraybuffer'
        }).success(function(data) {
            var file = new Blob([ data ], {
                type : 'application/pdf'
            });

            setTimeout(function() {
                saveAs(file, vm.fctr.etiqueta + '.pdf');
            }, 0);
        });
    }

    $http.post("facturacion/fctr-detail.action", {
        fctr : {
            id : $routeParams.fctrId
        }
    }).success(function(data) {
        vm.fctr = data.fctr;
        vm.fctsList = data.fctsList;
        vm.fctgList = data.fctgList;
        vm.fctiList = data.fctiList;

        findFctlList($routeParams.page ? $routeParams.page : 1);
    });

    pageTitleService.setTitle("fctr", "page_detail");
}

function FctlDetailController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.pageChanged = pageChanged;
    vm.tabSelected = tabSelected;

    vm.tab = $routeParams.tab ? $routeParams.tab : null;
    vm.path = $location.path();

    function findFctdList(page) {
        $http.post("facturacion/fctd-list.action", {
            fctlId : $routeParams.fctlId,
            page : page
        }).success(function(data) {
            vm.fctdList = data.fctdList;
            vm.page = data.fctdList.page;

            $location.search("page", vm.page).replace();
        });
    }

    function pageChanged() {
        findFctdList(vm.page);
    }

    function tabSelected(tabNo) {
        if (vm.path == $location.path()) {
            $location.search("tab", tabNo).replace();
        }
    }

    $http.post("facturacion/fctl-detail.action", {
        fctl : {
            id : $routeParams.fctlId
        }
    }).success(function(data) {
        vm.fctl = data.fctl;

        findFctdList($routeParams.page ? $routeParams.page : 1);
    });

    pageTitleService.setTitle("fctl", "page_detail");
}

function VlrcGridController($http, $location, $routeParams, $modal, pageTitleService) {
    var vm = this;

    vm.search = search;
    vm.pageChanged = pageChanged;
    vm.filter = filter;
    vm.tpsrChanged = tpsrChanged;

    vm.vlrcCriterio = $routeParams.vlrcCriterio ? angular.fromJson($routeParams.vlrcCriterio) : {};

    if ($routeParams.srvcId) {
        vm.vlrcCriterio.srvc = {
            id : $routeParams.srvcId
        };
    }

    function search(page) {
        $http.post("facturacion/vlrc-list.action", {
            model : vm.vlrcCriterio,
            page : page,
            limit : vm.limit
        }).success(function(data) {
            vm.page = data.vlrcList.page;
            vm.vlrcList = data.vlrcList;
            vm.vlrcCriterio = data.model;
            vm.tpdtCodExencion = data.tpdtCodExencion;

            $location.search({
                page : vm.page,
                vlrcCriterio : JSON.stringify(vm.vlrcCriterio)
            }).replace();
        });
    }

    function pageChanged() {
        search(vm.page);
    }

    function filter(size) {
        $http.post("facturacion/vlrc-filter.action").success(function(data) {
            vm.tpsrList = data.tpsrList;
        });
    }

    function tpsrChanged(tpsrId) {
        vm.vlrc.srvc = null;
        vm.vlrc.aspc = null;
    }

    search($routeParams.page ? $routeParams.page : 1);
    pageTitleService.setTitle("vlrc", "page_grid");
}

function VlrcDetailController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.pageChanged = pageChanged;
    vm.tabSelected = tabSelected;
    vm.remove = remove;
    vm.print = print;

    vm.tab = $routeParams.tab ? $routeParams.tab : null;
    vm.path = $location.path();

    function findVlrlList(page) {
        $http.post("facturacion/vlrl-list.action", {
            vlrcId : $routeParams.vlrcId,
            page : page
        }).success(function(data) {
            vm.vlrlList = data.vlrlList;
            vm.page = data.vlrlList.page;

            $location.search("page", vm.page).replace();
        });
    }

    function pageChanged() {
        findVlrlList(vm.page);
    }

    function tabSelected(tabNo) {
        if (vm.path == $location.path()) {
            $location.search("tab", tabNo).replace();
        }
    }

    function remove() {
        if (confirm("Are you sure?")) {
            $http.post("facturacion/vlrc-remove.action", {
                model : vm.vlrc
            }).success(function(data) {
                window.history.back();
            });
        }
    }

    function print() {
        $http.post('facturacion/vlrc-print.action', {
            vlrcId : vm.vlrc.id
        }, {
            responseType : 'arraybuffer'
        }).success(function(data) {
            var file = new Blob([ data ], {
                type : 'application/pdf'
            });

            setTimeout(function() {
                saveAs(file, 'vlrc_' + vm.vlrc.id + '.pdf');
            }, 0);
        });
    }

    $http.post("facturacion/vlrc-detail.action", {
        model : {
            id : $routeParams.vlrcId
        }
    }).success(function(data) {
        vm.vlrc = data.model;
        vm.vlrgList = data.vlrgList;
        vm.vlriList = data.vlriList;
        vm.aspc = data.aspc;
        vm.tpdtCodExencion = data.tpdtCodExencion;

        findVlrlList($routeParams.page ? $routeParams.page : 1);
    });

    pageTitleService.setTitle("vlrc", "page_detail");
}

function VlrcEditController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.accion = $routeParams.accion;
    vm.save = save;
    vm.cancel = cancel;

    function save() {
        $http.post("facturacion/vlrc-save.action", {
            model : vm.vlrc,
            accion : vm.accion
        }).success(function(data) {
            vm.accion == 'edit' ? setTimeout(function() {
                window.history.back();
            }, 0) : $location.path("/facturacion/vlrc/detail/" + data.model.id).replace();
        });
    }

    function cancel() {
        window.history.back();
    }

    $http.post("facturacion/vlrc-edit.action", {
        model : {
            id : $routeParams.vlrcId
        },
        accion : vm.accion
    }).success(function(data) {
        vm.vlrc = data.model;
        vm.pagadorEntiId = data.pagadorEntiId;
        vm.tpdtCodExencion = data.tpdtCodExencion;
        vm.tpsrList = data.tpsrList;

        if (data.model) {
            vm.tpsrId = data.model.srvc.entiId;
        }
    });

    pageTitleService.setTitle("vlrc", "page_" + vm.accion);
}

function VlrlDetailController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.pageChanged = pageChanged;
    vm.tabSelected = tabSelected;
    vm.remove = remove;

    vm.tab = $routeParams.tab ? $routeParams.tab : null;
    vm.path = $location.path();

    function findVlrdList(page) {
        $http.post("facturacion/vlrd-list.action", {
            vlrlId : $routeParams.vlrlId,
            page : page
        }).success(function(data) {
            vm.vlrdList = data.vlrdList;
            vm.page = data.vlrdList.page;

            $location.search("page", vm.page).replace();
        });
    }

    function pageChanged() {
        findVlrdList(vm.page);
    }

    function tabSelected(tabNo) {
        if (vm.path == $location.path()) {
            $location.search("tab", tabNo).replace();
        }
    }

    function remove() {
        if (confirm("Are you sure?")) {
            $http.post("facturacion/vlrl-remove.action", {
                model : vm.vlrl
            }).success(function(data) {
                window.history.back();
            });
        }
    }

    $http.post("facturacion/vlrl-detail.action", {
        model : {
            id : $routeParams.vlrlId,
            vlrcId : $routeParams.vlrcId
        }
    }).success(function(data) {
        vm.vlrl = data.model;
        vm.vlrlPadre = data.vlrlPadre;
        vm.vlrlHijosList = data.vlrlHijosList;
        vm.aspc = data.aspc;

        findVlrdList($routeParams.page ? $routeParams.page : 1);
    });

    pageTitleService.setTitle("vlrl", "page_detail");
}

function VlrlEditController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.accion = $routeParams.accion;
    vm.save = save;
    vm.cancel = cancel;

    function save() {
        $http.post("facturacion/vlrl-save.action", {
            model : vm.vlrl,
            accion : vm.accion
        }).success(
                function(data) {
                    vm.accion == 'edit' ? setTimeout(function() {
                        window.history.back();
                    }, 0) : $location.path(
                            "/facturacion/vlrl/detail/" + data.model.vlrcId + "/" + data.model.id).replace();
                });
    }

    function cancel() {
        window.history.back();
    }

    $http.post("facturacion/vlrl-edit.action", {
        model : {
            vlrcId : $routeParams.vlrcId,
            id : $routeParams.vlrlId
        },
        accion : vm.accion
    }).success(function(data) {
        vm.vlrl = data.model;
        vm.vlrlPadre = data.vlrlPadre;
        vm.aspc = data.aspc;
        vm.impuestoList = data.impuestoList;
    });

    pageTitleService.setTitle("vlrl", "page_" + vm.accion);
}

function VlrdDetailController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    $http.post("facturacion/vlrd-detail.action", {
        model : {
            id : $routeParams.vlrdId,
            vlrlId : $routeParams.vlrlId,
            vlrcId : $routeParams.vlrcId
        }
    }).success(function(data) {
        vm.vlrd = data.model;
        vm.vlrl = data.vlrl;
        vm.vlrlPadre = data.vlrlPadre;
        vm.vlrdHijosList = data.vlrdHijosList;
        vm.aspc = data.aspc;
    });

    pageTitleService.setTitle("vlrd", "page_detail");
}

function VlrdEditController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.accion = $routeParams.accion;
    vm.save = save;
    vm.cancel = cancel;

    function save() {
        $http.post("facturacion/Vlrd-save.action", {
            model : vm.vlrd,
            accion : vm.accion
        }).success(
                function(data) {
                    vm.accion == 'edit' ? setTimeout(function() {
                        window.history.back();
                    }, 0) : $location.path(
                            "/facturacion/vlrd/detail/" + data.model.vlrcId + "/" + data.model.vlrlId + "/"
                                    + data.model.id).replace();
                });
    }

    function cancel() {
        window.history.back();
    }

    $http.post("facturacion/vlrd-edit.action", {
        model : {
            vlrcId : $routeParams.vlrcId,
            vlrlId : $routeParams.vlrlId,
            id : $routeParams.vlrdId
        },
        accion : vm.accion
    }).success(function(data) {
        vm.vlrd = data.model;
        vm.vlrl = data.vlrl;
        vm.vlrlPadre = data.vlrlPadre;
        vm.aspc = data.aspc;
    });

    pageTitleService.setTitle("vlrd", "page_" + vm.accion);
}

function FcsrGridController($http, $location, $routeParams, $modal, pageTitleService) {
    var vm = this;

    vm.search = search;
    vm.pageChanged = pageChanged;
    vm.filter = filter;

    vm.fcsrCriterio = $routeParams.fcsrCriterio ? angular.fromJson($routeParams.fcsrCriterio) : {};
    vm.page = $routeParams.page ? $routeParams.page : 1;

    function search(page) {
        $http.post("facturacion/fcsr-list.action", {
            model : vm.fcsrCriterio,
            page : page,
            limit : vm.limit
        }).success(function(data) {
            vm.fcsrList = data.fcsrList;
            vm.page = data.fcsrList.page;

            $location.search({
                page : vm.page,
                fcsrCriterio : JSON.stringify(vm.fcsrCriterio)
            }).replace();
        });
    }

    function pageChanged() {
        search(vm.page);
    }

    function filter(size) {
    }

    search($routeParams.page ? $routeParams.page : 1);
    pageTitleService.setTitle("fcsr", "page_grid");
}

function FcsrDetailController($http, $routeParams, pageTitleService) {
    var vm = this;

    vm.remove = remove;

    function remove() {
        if (confirm("Are you sure?")) {
            $http.post("facturacion/fcsr-remove.action", {
                model : vm.fcsr
            }).success(function(data) {
                window.history.back();
            });
        }
    }

    $http.post("facturacion/fcsr-detail.action", {
        model : {
            id : $routeParams.fcsrId
        }
    }).success(function(data) {
        vm.fcsr = data.model;
    });

    pageTitleService.setTitle("fcsr", "page_detail");
}

function FcsrEditController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.accion = $routeParams.accion;
    vm.save = save;
    vm.cancel = cancel;

    function save() {
        $http.post("facturacion/fcsr-save.action", {
            model : vm.fcsr,
            accion : vm.accion
        }).success(function(data) {
            vm.accion == 'edit' ? setTimeout(function() {
                window.history.back();
            }, 0) : $location.path("/facturacion/fcsr/detail/" + data.model.id).replace();
        });
    }

    function cancel() {
        window.history.back();
    }

    $http.post("facturacion/fcsr-edit.action", {
        model : {
            id : $routeParams.fcsrId
        },
        accion : vm.accion
    }).success(function(data) {
        vm.fcsr = data.model;
    });

    pageTitleService.setTitle("fcsr", "page_" + vm.accion);
}

function CrgoGridController($http, $location, $routeParams, $modal, pageTitleService) {
    var vm = this;

    vm.search = search;
    vm.pageChanged = pageChanged;
    vm.filter = filter;

    vm.crgoCriterio = $routeParams.crgoCriterio ? angular.fromJson($routeParams.crgoCriterio) : {};
    vm.page = $routeParams.page ? $routeParams.page : 1;

    function search(page) {
        $http.post("facturacion/crgo-list.action", {
            model : vm.crgoCriterio,
            page : page,
            limit : vm.limit
        }).success(function(data) {
            vm.crgoList = data.crgoList;
            vm.page = data.crgoList.page;

            $location.search({
                page : vm.page,
                crgoCriterio : JSON.stringify(vm.crgoCriterio)
            }).replace();
        });
    }

    function pageChanged() {
        search(vm.page);
    }

    function filter(size) {
        $http.post("facturacion/crgo-filter.action").success(function(data) {
            vm.tpsrList = data.tpsrList;
        });
    }

    search($routeParams.page ? $routeParams.page : 1);
    pageTitleService.setTitle("crgo", "page_grid");
}

function CrgoDetailController($http, $routeParams, pageTitleService) {
    var vm = this;

    vm.remove = remove;

    function remove() {
        if (confirm("Are you sure?")) {
            $http.post("facturacion/crgo-remove.action", {
                model : vm.crgo
            }).success(function(data) {
                window.history.back();
            });
        }
    }

    $http.post("facturacion/crgo-detail.action", {
        model : {
            id : $routeParams.crgoId
        },
        fechaVigencia : $routeParams.fechaVigencia
    }).success(function(data) {
        vm.crgo = data.model;
        vm.i18nMap = data.i18nMap;
        vm.rglaList = data.rglaList;
        vm.fechaVigencia = data.fechaVigencia;
    });

    pageTitleService.setTitle("crgo", "page_detail");
}

function CrgoEditController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.accion = $routeParams.accion;
    vm.save = save;
    vm.cancel = cancel;

    function save() {
        $http.post("facturacion/crgo-save.action", {
            model : vm.crgo,
            i18nMap : vm.i18nMap,
            accion : vm.accion
        }).success(
                function(data) {
                    vm.accion == 'edit' ? setTimeout(function() {
                        window.history.back();
                    }, 0) : $location.path(
                            "/facturacion/crgo/detail/" + data.model.id + "/" + data.model.crgv.fini)
                            .replace();
                });
    }

    function cancel() {
        window.history.back();
    }

    $http.post("facturacion/crgo-edit.action", {
        model : {
            id : $routeParams.crgoId
        },
        fechaVigencia : $routeParams.fechaVigencia,
        accion : vm.accion
    }).success(function(data) {
        vm.crgo = data.model;
        vm.i18nMap = data.i18nMap;
        vm.tipos = data.tipos;
        vm.tpsrList = data.tpsrList;
    });

    pageTitleService.setTitle("crgo", "page_" + vm.accion);
}

function CrgoLupaController($http, $scope) {
    $scope.searchTpsr = function(entiId, textoBusqueda, fechaVigencia) {
        if (textoBusqueda.length <= 0) {
            return null;
        }

        return $http.post("facturacion/crgo-lupa.action", {
            model : {
                tpsrId : entiId,
                textoBusqueda : textoBusqueda,
                fechaVigencia : fechaVigencia
            }
        }).then(function(res) {
            return res.data.crgoList;
        });
    };

    $scope.searchAspc = function(aspcId, textoBusqueda, fechaVigencia) {
        if (textoBusqueda.length <= 0) {
            return null;
        }

        return $http.post("facturacion/crgo-lupa.action", {
            model : {
                aspcId : aspcId,
                textoBusqueda : textoBusqueda,
                fechaVigencia : fechaVigencia
            }
        }).then(function(res) {
            return res.data.crgoList;
        });
    };

    $scope.searchVlrc = function(vlrcId, textoBusqueda) {
        if (textoBusqueda.length <= 0) {
            return null;
        }

        return $http.post("facturacion/crgo-lupa.action", {
            model : {
                vlrcId : vlrcId,
                textoBusqueda : textoBusqueda
            }
        }).then(function(res) {
            return res.data.crgoList;
        });
    };
}

function RglaDetailController($http, $routeParams, pageTitleService) {
    var vm = this;

    vm.remove = remove;

    function remove() {
        if (confirm("Are you sure?")) {
            $http.post("facturacion/rgla-remove.action", {
                model : vm.rgla
            }).success(function(data) {
                window.history.back();
            });
        }
    }

    $http.post("facturacion/rgla-detail.action", {
        model : {
            id : $routeParams.rglaId
        },
        fechaVigencia : $routeParams.fechaVigencia
    }).success(function(data) {
        vm.rgla = data.model;
        vm.rginList = data.rginList;
        vm.fechaVigencia = data.fechaVigencia;
    });

    pageTitleService.setTitle("rgla", "page_detail");
}

function RglaEditController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.accion = $routeParams.accion;
    vm.save = save;
    vm.cancel = cancel;

    function save() {
        $http.post("facturacion/rgla-save.action", {
            model : vm.rgla,
            accion : vm.accion
        }).success(
                function(data) {
                    vm.accion == 'edit' ? setTimeout(function() {
                        window.history.back();
                    }, 0) : $location.path(
                            "/facturacion/rgla/detail/" + data.model.id + "/" + data.model.rglv.fini)
                            .replace();
                });
    }

    function cancel() {
        window.history.back();
    }

    $http.post("facturacion/rgla-edit.action", {
        model : {
            crgo : {
                id : $routeParams.crgoId
            },
            id : $routeParams.rglaId
        },
        fechaVigencia : $routeParams.fechaVigencia,
        accion : vm.accion
    }).success(function(data) {
        vm.rgla = data.model;
        vm.tipos = data.tipos;
        vm.entiFacturableList = data.entiFacturableList;
    });

    pageTitleService.setTitle("rgla", "page_" + vm.accion);
}

function RglaLupaController($http, $scope) {
    $scope.searchCrgo = function(crgoId, textoBusqueda, fechaVigencia) {
        if (textoBusqueda.length <= 0) {
            return null;
        }

        return $http.post("facturacion/rgla-lupa.action", {
            model : {
                crgoId : crgoId,
                textoBusqueda : textoBusqueda,
                fechaVigencia : fechaVigencia
            }
        }).then(function(res) {
            return res.data.rglaList;
        });
    };

    $scope.searchVlrc = function(vlrcId, crgoId, textoBusqueda) {
        if (textoBusqueda.length <= 0) {
            return null;
        }

        return $http.post("facturacion/rgla-lupa.action", {
            model : {
                vlrcId : vlrcId,
                crgoId : crgoId,
                textoBusqueda : textoBusqueda
            }
        }).then(function(res) {
            return res.data.rglaList;
        });
    };
}

function RginDetailController($http, $routeParams, pageTitleService) {
    var vm = this;

    vm.remove = remove;

    function remove() {
        if (confirm("Are you sure?")) {
            $http.post("facturacion/rgin-remove.action", {
                model : vm.rgin
            }).success(function(data) {
                window.history.back();
            });
        }
    }

    $http.post("facturacion/rgin-detail.action", {
        model : {
            id : $routeParams.rginId
        },
        fechaVigencia : $routeParams.fechaVigencia
    }).success(function(data) {
        vm.rgin = data.model;
        vm.fechaVigencia = data.fechaVigencia;
    });

    pageTitleService.setTitle("rgin", "page_detail");
}

function RginEditController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.accion = $routeParams.accion;
    vm.save = save;
    vm.cancel = cancel;

    function save() {
        $http.post("facturacion/rgin-save.action", {
            model : vm.rgin,
            accion : vm.accion
        }).success(
                function(data) {
                    vm.accion == 'edit' ? setTimeout(function() {
                        window.history.back();
                    }, 0) : $location.path(
                            "/facturacion/rgin/detail/" + data.model.id + "/" + data.model.rgiv.fini)
                            .replace();
                });
    }

    function cancel() {
        window.history.back();
    }

    $http.post("facturacion/rgin-edit.action", {
        model : {
            rgla1Id : $routeParams.rgla1Id,
            id : $routeParams.rginId
        },
        accion : vm.accion,
        fechaVigencia : $routeParams.fechaVigencia
    }).success(function(data) {
        vm.rgin = data.model;
        vm.rgla2List = data.rgla2List;
    });

    pageTitleService.setTitle("rgin", "page_" + vm.accion);
}

function AspcGridController($http, $location, $routeParams, $modal, pageTitleService) {
    var vm = this;

    vm.search = search;
    vm.pageChanged = pageChanged;
    vm.filter = filter;

    vm.aspcCriterio = $routeParams.aspcCriterio ? angular.fromJson($routeParams.aspcCriterio) : {};
    vm.page = $routeParams.page ? $routeParams.page : 1;

    function search(page) {
        $http.post("facturacion/aspecto-list.action", {
            model : vm.aspcCriterio,
            page : page,
            limit : vm.limit
        }).success(function(data) {
            vm.aspcCriterio = data.model;
            vm.aspcList = data.resultList;
            vm.page = data.resultList.page;

            $location.search({
                page : vm.page,
                aspcCriterio : JSON.stringify(vm.aspcCriterio)
            }).replace();
        });
    }

    function pageChanged() {
        search(vm.page);
    }

    function filter(size) {
        $http.post("facturacion/aspecto-filter.action", {
            model : vm.aspcCriterio
        }).success(function(data) {
            vm.tpsrList = data.tpsrList;
        });
    }

    search($routeParams.page ? $routeParams.page : 1);
    pageTitleService.setTitle("aspc", "page_grid");
}

function AspcDetailController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.remove = remove;

    function remove() {
        if (confirm("Are you sure?")) {
            $http.post("facturacion/aspecto-remove.action", {
                model : vm.aspc
            }).success(function(data) {
                window.history.back();
            });
        }
    }

    vm.fechaVigencia = $routeParams.fechaVigencia;

    $http.post("facturacion/aspecto-detail.action", {
        model : {
            id : $routeParams.aspcId
        },
        fechaVigencia : vm.fechaVigencia
    }).success(function(data) {
        vm.aspc = data.model;
        vm.i18nMap = data.i18nMap;
        vm.ascrList = data.ascrList;
    });

    pageTitleService.setTitle("aspc", "page_detail");
}

function AspcEditController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.accion = $routeParams.accion;
    vm.save = save;
    vm.cancel = cancel;

    function save() {
        $http.post("facturacion/aspecto-save.action", {
            model : vm.aspc,
            i18nMap : vm.i18nMap,
            accion : vm.accion
        }).success(
                function(data) {
                    vm.accion == 'edit' ? setTimeout(function() {
                        window.history.back();
                    }, 0) : $location.path(
                            "/facturacion/aspc/detail/" + data.model.id + "/" + data.model.version.fini)
                            .replace();
                });
    }

    function cancel() {
        window.history.back();
    }

    $http.post("facturacion/aspecto-edit.action", {
        model : {
            id : $routeParams.aspcId
        },
        fechaVigencia : $routeParams.fechaVigencia,
        accion : vm.accion
    }).success(function(data) {
        vm.aspc = data.model;
        vm.i18nMap = data.i18nMap;
        vm.tpsrList = data.tpsrList;
    });

    pageTitleService.setTitle("aspc", "page_" + vm.accion);
}

function AspcLupaController($http, $scope) {
    $scope.search = function(entiId, textoBusqueda, fechaVigencia) {
        if (textoBusqueda.length <= 0) {
            return null;
        }

        return $http.post("facturacion/aspecto-typeahead.action", {
            model : {
                tpsrId : entiId,
                textoBusqueda : textoBusqueda,
                fechaVigencia : fechaVigencia
            }
        }).then(function(res) {
            return res.data.aspcList;
        });
    };
}

function AscrDetailController($http, $routeParams, pageTitleService) {
    var vm = this;

    vm.remove = remove;

    function remove() {
        if (confirm("Are you sure?")) {
            $http.post("facturacion/ascr-remove.action", {
                model : vm.ascr
            }).success(function(data) {
                window.history.back();
            });
        }
    }

    $http.post("facturacion/ascr-detail.action", {
        model : {
            id : $routeParams.ascrId
        },
        fechaVigencia : $routeParams.fechaVigencia
    }).success(function(data) {
        vm.ascr = data.model;
        vm.fechaVigencia = data.fechaVigencia;
    });

    pageTitleService.setTitle("ascr", "page_detail");
}

function AscrEditController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.accion = $routeParams.accion;
    vm.save = save;
    vm.cancel = cancel;

    function save() {
        $http.post("facturacion/ascr-save.action", {
            model : vm.ascr,
            accion : vm.accion
        }).success(
                function(data) {
                    vm.accion == 'edit' ? setTimeout(function() {
                        window.history.back();
                    }, 0) : $location.path(
                            "/facturacion/ascr/detail/" + data.model.id + "/" + data.model.ascv.fini)
                            .replace();
                });
    }

    function cancel() {
        window.history.back();
    }

    $http.post("facturacion/ascr-edit.action", {
        model : {
            aspcId : $routeParams.aspcId,
            id : $routeParams.ascrId
        },
        fechaVigencia : $routeParams.fechaVigencia,
        accion : vm.accion
    }).success(function(data) {
        vm.ascr = data.model;
        vm.crgoList = data.crgoList;
    });

    pageTitleService.setTitle("ascr", "page_" + vm.accion);
}
