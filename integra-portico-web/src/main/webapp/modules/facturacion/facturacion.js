angular.module("facturacion", [])

.config(config)

// ----------- VALORADOR ------------------
.controller("VldrEditController", VldrEditController)

// ----------- FACTURADOR ------------------
.controller("FcdrEditController", FcdrEditController)

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

;

function config($routeProvider) {
    $routeProvider

    .when("/facturacion/vldr/edit/:entiId/:srvcId", {
        templateUrl : "modules/facturacion/vldr-edit.html",
        controller : "VldrEditController as vm",
        reloadOnSearch : false
    })

    .when("/facturacion/fcdr/edit/:vlrcId", {
        templateUrl : "modules/facturacion/fcdr-edit.html",
        controller : "FcdrEditController as vm",
        reloadOnSearch : false
    })

    .when("/facturacion/fctr/grid", {
        templateUrl : "modules/facturacion/fctr-grid.html",
        controller : "FctrGridController as vm",
        reloadOnSearch : false
    })

    .when("/facturacion/fctr/detail/:fctrId", {
        templateUrl : "modules/facturacion/fctr-detail.html",
        controller : "FctrDetailController as vm",
        reloadOnSearch : false
    })

    .when("/facturacion/fctl/detail/:fctlId", {
        templateUrl : "modules/facturacion/fctl-detail.html",
        controller : "FctlDetailController as vm",
        reloadOnSearch : false
    })

    .when("/facturacion/vlrc/grid", {
        templateUrl : "modules/facturacion/vlrc-grid.html",
        controller : "VlrcGridController as vm",
        reloadOnSearch : false
    })

    .when("/facturacion/vlrc/detail/:vlrcId", {
        templateUrl : "modules/facturacion/vlrc-detail.html",
        controller : "VlrcDetailController as vm",
        reloadOnSearch : false
    })

    .when("/facturacion/vlrc/edit/:accion/:vlrcId?", {
        templateUrl : "modules/facturacion/vlrc-edit.html",
        controller : "VlrcEditController as vm"
    })

    .when("/facturacion/vlrl/detail/:vlrcId/:vlrlId", {
        templateUrl : "modules/facturacion/vlrl-detail.html",
        controller : "VlrlDetailController as vm",
        reloadOnSearch : false
    })

    .when("/facturacion/vlrl/edit/:accion/:vlrcId/:vlrlId?", {
        templateUrl : "modules/facturacion/vlrl-edit.html",
        controller : "VlrlEditController as vm"
    })

    .when("/facturacion/vlrldep/edit/create/:vlrcId/:vlrlId", {
        templateUrl : "modules/facturacion/vlrl-edit.html",
        controller : "VlrlDepEditController as vm"
    })

    .when("/facturacion/vlrd/detail/:vlrcId/:vlrlId/:vlrdId", {
        templateUrl : "modules/facturacion/vlrd-detail.html",
        controller : "VlrdDetailController as vm"
    })

    .when("/facturacion/vlrd/edit/:accion/:vlrcId/:vlrlId/:vlrdId?", {
        templateUrl : "modules/facturacion/vlrd-edit.html",
        controller : "VlrdEditController as vm"
    })

    ;
}

function VldrEditController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.valorar = valorar;
    vm.cancel = cancel;

    initialize();

    function initialize() {
        $http.post("facturacion/valorador-edit.action", {
            srvc : {
                id : $routeParams.srvcId,
                entiId : $routeParams.entiId
            }
        }).success(function(data) {
            vm.srvc = data.srvc;
            vm.fliq = data.fliq;
            vm.crgoList = data.crgoList;
        });

        pageTitleService.setTitle("vldr", "page_edit");
    }

    function valorar() {
        $http.post("facturacion/valorador-save.action", {
            fliq : vm.fliq,
            srvc : vm.srvc
        }).success(function(data) {
            $location.path("/proceso/prbt/grid").replace();
        });
    }

    function cancel() {
        window.history.back();
    }
}

function FcdrEditController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.facturar = facturar;
    vm.cancel = cancel;

    initialize();

    function initialize() {
        $http.post("facturacion/facturador-edit.action", {
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

        pageTitleService.setTitle("fcdr", "page_edit");
    }

    function facturar() {
        $http.post("facturacion/facturador-save.action", {
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
}

function FctrGridController($http, $location, $routeParams, $modal, pageTitleService) {
    var vm = this;

    vm.pageChanged = pageChanged;
    vm.filter = filter;
    vm.search = search;

    initialize();

    function initialize() {
        vm.fctrCriterio = $routeParams.fctrCriterio ? angular.fromJson($routeParams.fctrCriterio) : {};

        search($routeParams.page ? $routeParams.page : 1);
        pageTitleService.setTitle("fctr", "page_grid");
    }

    function search(page) {
        $http.post("facturacion/factura-list.action", {
            model : vm.fctrCriterio,
            page : page,
            limit : vm.limit
        }).success(function(data) {
            vm.page = data.resultList.page;
            vm.fctrList = data.resultList;
            vm.fctrCriterio = data.model;

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
        $http.post("facturacion/factura-filter.action", {
            model : vm.fctrCriterio
        }).success(function(data) {
            // vm.tpsrList = data.tpsrList;
        });
    }
}

function FctrDetailController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.pageChanged = pageChanged;
    vm.tabSelected = tabSelected;
    vm.print = print;

    initialize();

    function initialize() {
        vm.tab = $routeParams.tab ? $routeParams.tab : null;
        vm.path = $location.path();

        $http.post("facturacion/factura-detail.action", {
            model : {
                id : $routeParams.fctrId
            }
        }).success(function(data) {
            vm.fctr = data.model;
            vm.fctsList = data.fctsList;
            vm.fctgList = data.fctgList;
            vm.fctiList = data.fctiList;
            vm.aspc = data.aspc;

            findFctlList($routeParams.page ? $routeParams.page : 1);
        });

        pageTitleService.setTitle("fctr", "page_detail");
    }

    function findFctlList(page) {
        $http.post("facturacion/factura-linea-list.action", {
            model : {
                fctr : {
                    id : $routeParams.fctrId
                }
            },
            page : page
        }).success(function(data) {
            vm.fctlList = data.resultList;
            vm.page = data.resultList.page;

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
}

function FctlDetailController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.pageChanged = pageChanged;
    vm.tabSelected = tabSelected;

    initialize();

    function initialize() {
        vm.tab = $routeParams.tab ? $routeParams.tab : null;
        vm.path = $location.path();

        $http.post("facturacion/factura-linea-detail.action", {
            model : {
                id : $routeParams.fctlId
            }
        }).success(function(data) {
            vm.fctl = data.model;

            findFctdList($routeParams.page ? $routeParams.page : 1);
        });

        pageTitleService.setTitle("fctl", "page_detail");
    }

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
}

function VlrcGridController($http, $location, $routeParams, $modal, pageTitleService) {
    var vm = this;

    vm.pageChanged = pageChanged;
    vm.filter = filter;
    vm.search = search;
    vm.tpsrChanged = tpsrChanged;

    initialize();

    function initialize() {
        vm.vlrcCriterio = $routeParams.vlrcCriterio ? angular.fromJson($routeParams.vlrcCriterio) : {};

        if ($routeParams.srvcId) {
            vm.vlrcCriterio.srvc = {
                id : $routeParams.srvcId
            };
        }

        search($routeParams.page ? $routeParams.page : 1);
        pageTitleService.setTitle("vlrc", "page_grid");
    }

    function search(page) {
        $http.post("facturacion/valoracion-list.action", {
            model : vm.vlrcCriterio,
            page : page,
            limit : vm.limit
        }).success(function(data) {
            vm.page = data.resultList.page;
            vm.vlrcList = data.resultList;
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
        $http.post("facturacion/valoracion-filter.action", {
            model : vm.vlrcCriterio
        }).success(function(data) {
            vm.tpsrList = data.tpsrList;
        });
    }

    function tpsrChanged(tpsrId) {
        vm.vlrc.srvc = null;
        vm.vlrc.aspc = null;
    }
}

function VlrcDetailController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.pageChanged = pageChanged;
    vm.tabSelected = tabSelected;
    vm.remove = remove;
    vm.print = print;

    initialize();

    function initialize() {
        vm.tab = $routeParams.tab ? $routeParams.tab : "vlrc";
        vm.path = $location.path();

        $http.post("facturacion/valoracion-detail.action", {
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

    function findVlrlList(page) {
        $http.post("facturacion/valoracion-linea-list.action", {
            model : {
                vlrc : {
                    id : $routeParams.vlrcId
                }
            },
            page : page
        }).success(function(data) {
            vm.vlrlList = data.resultList;
            vm.page = data.resultList.page;

            $location.search("page", vm.page).replace();
        });
    }

    function pageChanged() {
        findVlrlList(vm.page);
    }

    function tabSelected() {
        if (vm.path == $location.path()) {
            $location.search("tab", vm.tab).replace();
        }
    }

    function remove() {
        if (confirm("Are you sure?")) {
            $http.post("facturacion/valoracion-remove.action", {
                model : vm.vlrc
            }).success(function(data) {
                window.history.back();
            });
        }
    }

    function print() {
        $http.post('facturacion/valoracion-pdf-export.action', {
            model : vm.vlrc
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
}

function VlrcEditController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    initialize();

    function initialize() {
        vm.accion = $routeParams.accion;

        $http.post("facturacion/valoracion-edit.action", {
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

    function save() {
        $http.post("facturacion/valoracion-save.action", {
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
}

function VlrlDetailController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.pageChanged = pageChanged;
    vm.tabSelected = tabSelected;
    vm.remove = remove;

    initialize();

    function initialize() {
        vm.tab = $routeParams.tab ? $routeParams.tab : "vlrl";
        vm.path = $location.path();

        $http.post("facturacion/valoracion-linea-detail.action", {
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

    function findVlrdList(page) {
        $http.post("facturacion/valoracion-detalle-list.action", {
            model : {
                vlrl : {
                    id : $routeParams.vlrlId
                }
            },
            page : page
        }).success(function(data) {
            vm.vlrdList = data.resultList;
            vm.page = data.resultList.page;

            $location.search("page", vm.page).replace();
        });
    }

    function pageChanged() {
        findVlrdList(vm.page);
    }

    function tabSelected() {
        if (vm.path == $location.path()) {
            $location.search("tab", vm.tab).replace();
        }
    }

    function remove() {
        if (confirm("Are you sure?")) {
            $http.post("facturacion/valoracion-linea-remove.action", {
                model : vm.vlrl
            }).success(function(data) {
                window.history.back();
            });
        }
    }
}

function VlrlEditController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    initialize();

    function initialize() {
        vm.accion = $routeParams.accion;

        $http.post("facturacion/valoracion-linea-edit.action", {
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

    function save() {
        $http.post("facturacion/valoracion-linea-save.action", {
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
}

function VlrlDepEditController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    initialize();

    function initialize() {
        vm.accion = $routeParams.accion;

        $http.post("facturacion/valoracion-linea-edit.action", {
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

    function save() {
        $http.post("facturacion/valoracion-linea-save.action", {
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
}

function VlrdDetailController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    initialize();

    function initialize() {
        vm.tab = "vlrd";

        $http.post("facturacion/valoracion-detalle-detail.action", {
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
}

function VlrdEditController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    initialize();

    function initialize() {
        vm.accion = $routeParams.accion;

        $http.post("facturacion/valoracion-detalle-edit.action", {
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

    function save() {
        $http.post("facturacion/valoracion-detalle-save.action", {
            model : vm.vlrd,
            vlrl : vm.vlrl,
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
}
