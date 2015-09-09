angular.module("servicio", [])

.config(config)

// ----------------- MENU PRINCIPAL --------------------------
.controller("ServicioController", ServicioController)

// ----------- SERVICIOS ------------------
.controller("SrscGridController", SrscGridController)

.controller("SrscDetailController", SrscDetailController)

.controller("SrscEditController", SrscEditController)

.controller("SrvcGridController", SrvcGridController)

.controller("SrvcDetailController", SrvcDetailController)

.controller("SrvcEditController", SrvcEditController)

.controller("SrvcLupaController", SrvcLupaController)

.controller("ManiTotalesController", ManiTotalesController)

.controller("SbupGenerarController", SbupGenerarController)

.controller("SamdGenerarController", SamdGenerarController)

// ----------- SUBSERVICIOS ------------------
.controller("SsrvGridController", SsrvGridController)

.controller("SsrvDetailController", SsrvDetailController)

.controller("SsrvEditController", SsrvEditController)

.controller("SsrvLupaController", SsrvLupaController)

.controller("MablTotalesController", MablTotalesController)

;

function config($routeProvider) {
    $routeProvider

    .when("/servicio/srsc/grid", {
        templateUrl : "modules/entidad/servicio/srsc-grid.html",
        controller : "SrscGridController as vm",
        reloadOnSearch : false
    })

    .when("/servicio/srsc/detail/:prtoId/:tpsrId/:anno", {
        templateUrl : "modules/entidad/servicio/srsc-detail.html",
        controller : "SrscDetailController as vm",
        reloadOnSearch : false
    })

    .when("/servicio/srsc/edit/:accion/:prtoId?/:tpsrId?/:anno?", {
        templateUrl : "modules/entidad/servicio/srsc-edit.html",
        controller : "SrscEditController as vm"
    })

    .when("/servicio", {
        title : 'servicio_main',
        templateUrl : "modules/entidad/servicio/servicio.html",
        controller : "ServicioController as vm"
    })

    .when("/servicio/srvc/grid/:entiId", {
        templateUrl : "modules/entidad/servicio/srvc-grid.html",
        controller : "SrvcGridController as vm",
        reloadOnSearch : false
    })

    .when("/servicio/srvc/detail/:entiId/:srvcId", {
        templateUrl : "modules/entidad/servicio/srvc-detail.html",
        controller : "SrvcDetailController as vm",
        reloadOnSearch : false
    })

    .when("/servicio/srvc/edit/:accion/:entiId/:srvcId?", {
        templateUrl : "modules/entidad/servicio/srvc-edit.html",
        controller : "SrvcEditController as vm"
    })

    .when("/servicio/srvc/maniTotales/:entiId/:srvcId", {
        templateUrl : "modules/entidad/servicio/manifiesto/mani-totales.html",
        controller : "ManiTotalesController as vm"
    })

    .when("/servicio/srvc/amarredep/generar/prepare", {
        templateUrl : "modules/entidad/servicio/amarredep/generar-prepare.html",
        controller : "SamdGenerarController as vm"
    })

    .when("/servicio/srvc/buquepesca/generar/prepare", {
        templateUrl : "modules/entidad/servicio/buquepesca/generar-prepare.html",
        controller : "SbupGenerarController as vm"
    })

    .when("/servicio/ssrv/grid/:entiId", {
        templateUrl : "modules/entidad/servicio/ssrv-grid.html",
        controller : "SsrvGridController as vm",
        reloadOnSearch : false
    })

    .when("/servicio/ssrv/detail/:entiId/:ssrvId", {
        templateUrl : "modules/entidad/servicio/ssrv-detail.html",
        controller : "SsrvDetailController as vm",
        reloadOnSearch : false
    })

    .when("/servicio/ssrv/edit/:accion/:entiId/:srvcId?/:ssrvId?", {
        templateUrl : "modules/entidad/servicio/ssrv-edit.html",
        controller : "SsrvEditController as vm"
    })

    .when("/servicio/ssrv/mablTotales/:entiId/:srvcId/:ssrvId", {
        templateUrl : "modules/entidad/servicio/manifiesto/mani-totales.html",
        controller : "MablTotalesController as vm"
    })

    ;
}

function SrscGridController($http, $location, $routeParams, $modal, pageTitleService) {
    var vm = this;

    vm.search = search;
    vm.pageChanged = pageChanged;
    vm.filter = filter;

    initialize();

    function initialize() {
        vm.srscCriterio = $routeParams.srscCriterio ? angular.fromJson($routeParams.srscCriterio) : {};

        search($routeParams.page ? $routeParams.page : 1);
        pageTitleService.setTitle("srsc", "page_grid");
    }

    function search(page) {
        $http.post("servicio/servicio-secuencia-list.action", {
            model : vm.srscCriterio,
            page : page
        }).success(function(data) {
            vm.page = data.resultList.page;
            vm.srscList = data.resultList;

            $location.search({
                page : vm.page,
                srscCriterio : JSON.stringify(vm.srscCriterio)
            }).replace();
        });
    }

    function pageChanged() {
        search(vm.page);
    }

    function filter(size) {
        $http.post("servicio/servicio-secuencia-filter.action", {
            model : vm.srscCriterio
        }).success(function(data) {
            vm.tpsrList = data.tpsrList;
            vm.prtoList = data.prtoList;
        });
    }
}

function SrscDetailController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.remove = remove;

    initialize();

    function initialize() {
        vm.path = $location.path();

        $http.post("servicio/servicio-secuencia-detail.action", {
            model : {
                prto : {
                    id : $routeParams.prtoId
                },
                tpsr : {
                    id : $routeParams.tpsrId
                },
                anno : $routeParams.anno
            }
        }).success(function(data) {
            vm.srsc = data.model;
        });

        pageTitleService.setTitle("srsc", "page_detail");
    }

    function remove() {
        if (confirm("Are you sure?")) {
            $http.post("servicio/servicio-secuencia-remove.action", {
                model : vm.srsc
            }).success(function(data) {
                window.history.back();
            });
        }
    }
}

function SrscEditController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    initialize();

    function initialize() {
        vm.accion = $routeParams.accion;

        $http.post("servicio/servicio-secuencia-edit.action", {
            model : {
                prto : {
                    id : $routeParams.prtoId
                },
                tpsr : {
                    id : $routeParams.tpsrId
                },
                anno : $routeParams.anno
            },
            accion : vm.accion
        }).success(function(data) {
            vm.srsc = data.model;
            vm.prtoList = data.prtoList;
            vm.tpsrList = data.tpsrList;
        });

        pageTitleService.setTitle("srsc", "page_" + vm.accion);
    }

    function save() {
        $http.post("servicio/servicio-secuencia-save.action", {
            model : vm.srsc,
            accion : vm.accion
        }).success(
                function(data) {
                    vm.accion == 'edit' ? setTimeout(function() {
                        window.history.back();
                    }, 0) : $location.path(
                            "/servicio/srsc/detail/" + data.model.prto.id + "/" + data.model.tpsr.id + "/"
                                    + data.model.anno).replace();
                });
    }

    function cancel() {
        window.history.back();
    }
}

function ServicioController($http, pageTitleService) {
    var vm = this;

    initialize();

    function initialize() {
        $http.post("servicio/index.action").success(function(data) {
            vm.tpsrList = data.resultList;
            vm.tpssMap = data.tpssMap;
        });

        pageTitleService.setTitle("srvcList", "page_home");
    }
}

function SrvcGridController($http, $location, $routeParams, $modal, pageTitleService) {
    var vm = this;

    vm.search = search;
    vm.pageChanged = pageChanged;
    vm.filter = filter;
    vm.xlsExport = xlsExport;
    vm.srvcAction = srvcAction;

    initialize();

    function initialize() {
        vm.itemCriterio = $routeParams.itemCriterio ? angular.fromJson($routeParams.itemCriterio) : {};
        vm.itemCriterio.entiId = $routeParams.entiId;

        search($routeParams.page ? $routeParams.page : 1);
        pageTitleService.setTitleEnti($routeParams.entiId, "page_grid");
    }

    function search(page) {
        $http.post("servicio/servicio-list.action", {
            model : vm.itemCriterio,
            page : page,
            limit : vm.itemCriterio.limit
        }).success(function(data) {
            vm.enti = data.enti;
            vm.page = data.resultList.page;
            vm.itemList = data.resultList;
            vm.itemCriterio = data.model;

            $location.search({
                page : vm.page,
                itemCriterio : JSON.stringify(vm.itemCriterio)
            }).replace();
        });
    }

    function pageChanged() {
        search(vm.page);
    }

    function xlsExport() {
        $http.post('servicio/servicio-xls-export.action', {
            criterio : vm.itemCriterio
        }, {
            responseType : 'arraybuffer'
        }).success(function(data) {
            var file = new Blob([ data ], {
                type : 'application/xls'
            });

            setTimeout(function() {
                saveAs(file, 'srvc_' + vm.itemCriterio.entiId + '.xls');
            }, 0);
        });
    }

    function filter(size) {
        $http.post("servicio/servicio-filter.action", {
            model : vm.itemCriterio
        }).success(function(data) {
            vm.labelValuesMap = data.labelValuesMap;
            vm.prtoList = data.prtoList;
            vm.limits = data.limits;
            vm.fechaVigencia = data.fechaVigencia;
        });
    }

    function srvcAction(accName) {
        switch (accName) {
        // ----------- BUQUES DE PESCA ------------------
        // ----------- BUQUES DE PESCA ------------------
        case "sbup-generar":
            $location.path("/servicio/srvc/buquepesca/generar/prepare");

            break;
        // ----------- AMARRES DEPORTIVOS ------------------
        // ----------- AMARRES DEPORTIVOS ------------------
        case "samd-generar":
            $location.path("/servicio/srvc/amarredep/generar/prepare");

            break;
        default:
            alert(accName);

            break;
        }
    }
}

function SrvcDetailController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.pageChanged = pageChanged;
    vm.tabSelected = tabSelected;
    vm.remove = remove;
    vm.download = download;
    vm.srvcAction = srvcAction;

    initialize();

    function initialize() {
        vm.path = $location.path();
        vm.pageMap = {};
        vm.tabActive = {};

        if ($routeParams.tab) {
            vm.tabActive[$routeParams.tab] = true;
        }

        var pageMap = $routeParams.pageMap ? angular.fromJson($routeParams.pageMap) : {};

        $http.post("servicio/servicio-detail.action", {
            model : {
                id : $routeParams.srvcId,
                entiId : $routeParams.entiId
            }
        }).success(function(data) {
            vm.enti = data.enti;
            vm.item = data.model;
            vm.prtoId = data.model.prto.id;
            vm.fechaVigencia = data.fechaVigencia;
            vm.arinList = data.arinList;
            vm.ittrList = data.ittrList;

            vm.entiHijasMap = {};
            vm.itemHijosMap = {};

            angular.forEach(vm.enti.entiHijasList, function(value, key) {
                findSublist(value, pageMap[value] ? pageMap[value] : 1);
            });
        });

        pageTitleService.setTitleEnti($routeParams.entiId, "page_detail");
    }

    function findSublist(subentiId, page) {
        $http.post("servicio/subservicio-list.action", {
            model : {
                entiId : subentiId,
                srvc : {
                    id : $routeParams.srvcId
                }
            },
            page : page
        }).success(function(data) {
            if (!vm.entiHijasMap[data.model.entiId]) {
                vm.entiHijasMap[data.model.entiId] = data.enti;
            }
            vm.itemHijosMap[data.model.entiId] = data.resultList;
            vm.pageMap[data.model.entiId] = data.resultList.page;

            $location.search("pageMap", JSON.stringify(vm.pageMap)).replace();
        });
    }

    function pageChanged(subentiId) {
        findSublist(subentiId, vm.pageMap[subentiId]);
    }

    function tabSelected(tabNo) {
        if (vm.path == $location.path()) {
            $location.search("tab", tabNo).replace();
        }
    }

    function remove() {
        if (confirm("Are you sure?")) {
            $http.post("servicio/servicio-remove.action", {
                model : vm.item
            }).success(function(data) {
                window.history.back();
            });
        }
    }

    function download(archId, archNombre) {
        $http.post('servicio/servicio-archivo-download.action', {
            model : {
                id : archId
            }
        }, {
            responseType : 'arraybuffer'
        }).success(function(data) {
            var file = new Blob([ data ]);

            setTimeout(function() {
                saveAs(file, archNombre);
            }, 0);
        });
    }

    function srvcAction(accName) {
        switch (accName) {
        case "mani-totales":
            $location.path("/servicio/srvc/maniTotales/" + vm.item.entiId + "/" + vm.item.id);

            break;
        default:
            alert(accName);

            break;
        }
    }
}

function SrvcEditController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    initialize();

    function initialize() {
        vm.accion = $routeParams.accion;

        $http.post("servicio/servicio-edit.action", {
            model : {
                id : $routeParams.srvcId,
                entiId : $routeParams.entiId
            },
            accion : vm.accion
        }).success(function(data) {
            vm.enti = data.enti;
            vm.fechaVigencia = data.fechaVigencia;
            vm.item = data.model;
            vm.labelValuesMap = data.labelValuesMap;
            vm.prtoList = data.prtoList;

            if (data.model.prto) {
                vm.prtoId = data.model.prto.id;
            }
        });

        pageTitleService.setTitleEnti($routeParams.entiId, "page_" + vm.accion);
    }

    function save() {
        $http.post("servicio/servicio-save.action", {
            model : vm.item,
            accion : vm.accion
        }).success(
                function(data) {
                    vm.accion == 'edit' ? setTimeout(function() {
                        window.history.back();
                    }, 0) : $location
                            .path("/servicio/srvc/detail/" + data.model.entiId + "/" + data.model.id)
                            .replace();
                });
    }

    function cancel() {
        window.history.back();
    }
}

function SrvcLupaController($http, $scope) {
    $scope.search = function(entiId, textoBusqueda) {
        if (textoBusqueda.length <= 0) {
            return null;
        }

        return $http.post('servicio/servicio-typeahead.action', {
            model : {
                entiId : entiId,
                textoBusqueda : textoBusqueda,
                fechaVigencia : '2014-11-11T00:00:00'
            }
        }).then(function(res) {
            return res.data.resultList;
        });
    };
}

function ManiTotalesController($http, $routeParams, pageTitleService) {
    var vm = this;

    initialize();

    function initialize() {
        $http.post("servicio/manifiesto/manifiesto-total-detail.action", {
            model : {
                id : $routeParams.srvcId
            }
        }).success(function(data) {
            vm.item = data.model;
            vm.resumen = data.resumen;
        });

        pageTitleService.setTitleEnti($routeParams.entiId, "page_verificarTotales");
    }
}

function SamdGenerarController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.execute = execute;

    initialize();

    function initialize() {
        vm.itemCriterio = {};

        $http.post("servicio/amarredep/generar-prepare.action", {}).success(function(data) {
        });

        pageTitleService.setTitleEnti($routeParams.entiId, "page_generar");
    }

    function execute() {
        $http.post("servicio/amarredep/generar-execute.action", {
            model : vm.itemCriterio
        }).success(function(data) {
            $location.path("/proceso/prbt/grid").replace();
        });
    }
}

function SbupGenerarController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.execute = execute;

    initialize();

    function initialize() {
        vm.itemCriterio = {};

        $http.post("servicio/buquepesca/generar-prepare.action", {}).success(function(data) {
        });

        pageTitleService.setTitleEnti($routeParams.entiId, "page_generar");
    }

    function execute() {
        $http.post("servicio/buquepesca/generar-execute.action", {
            model : vm.itemCriterio
        }).success(function(data) {
            $location.path("/proceso/prbt/grid").replace();
        });
    }
}

function SsrvGridController($http, $location, $routeParams, $modal, pageTitleService) {
    var vm = this;

    vm.search = search;
    vm.pageChanged = pageChanged;
    vm.filter = filter;
    vm.xlsExport = xlsExport;

    initialize();

    function initialize() {
        vm.itemCriterio = $routeParams.itemCriterio ? angular.fromJson($routeParams.itemCriterio) : {};
        vm.itemCriterio.entiId = $routeParams.entiId;

        search($routeParams.page ? $routeParams.page : 1);

        pageTitleService.setTitleEnti($routeParams.entiId, "page_grid");
    }

    function search(page) {
        $http.post("servicio/subservicio-list.action", {
            model : vm.itemCriterio,
            page : page,
            limit : vm.itemCriterio.limit
        }).success(function(data) {
            vm.page = data.resultList.page;
            vm.enti = data.enti;
            vm.itemList = data.resultList;
            vm.itemCriterio = data.model;

            $location.search({
                page : vm.page,
                itemCriterio : JSON.stringify(vm.itemCriterio)
            }).replace();
        });
    }

    function pageChanged() {
        search(vm.page);
    }

    function xlsExport() {
        $http.post('servicio/subservicio-xls-export.action', {
            criterio : vm.itemCriterio
        }, {
            responseType : 'arraybuffer'
        }).success(function(data) {
            var file = new Blob([ data ], {
                type : 'application/xls'
            });

            setTimeout(function() {
                saveAs(file, 'ssrv_' + vm.itemCriterio.entiId + '.xls');
            }, 0);
        });
    }

    function filter(size) {
        $http.post("servicio/subservicio-filter.action", {
            model : vm.itemCriterio
        }).success(function(data) {
            vm.labelValuesMap = data.labelValuesMap;
            vm.limits = data.limits;
            vm.fechaVigencia = data.fechaVigencia;
        });
    }
}

function SsrvDetailController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.pageChanged = pageChanged;
    vm.tabSelected = tabSelected;
    vm.remove = remove;
    vm.ssrvAction = ssrvAction;

    initialize();

    function initialize() {
        vm.path = $location.path();
        vm.pageMap = $routeParams.pageMap ? angular.fromJson($routeParams.pageMap) : {};

        vm.pageMap = {};
        vm.tabActive = {};

        if ($routeParams.tab) {
            vm.tabActive[$routeParams.tab] = true;
        }

        loadData($routeParams.ssrvId, $routeParams.entiId);
        pageTitleService.setTitleEnti($routeParams.entiId, "page_detail");
    }

    function loadData(ssrvId, entiId) {
        $http.post("servicio/subservicio-detail.action", {
            model : {
                id : ssrvId,
                entiId : entiId
            }
        }).success(function(data) {
            vm.enti = data.enti;
            vm.fechaVigencia = data.fechaVigencia;
            vm.item = data.model;
            vm.itemPadresMap = data.itemPadresMap;
            vm.ittrList = data.ittrList;

            vm.itemHijosMap = {};
            vm.entiHijasMap = {};

            angular.forEach(data.enti.entiHijasList, function(value, key) {
                findSublist(value, 1);
            });
        });
    }

    function findSublist(subentiId, page) {
        $http.post("servicio/subservicio-list.action", {
            model : {
                entiId : subentiId,
                padreId : $routeParams.ssrvId
            },
            page : page
        }).success(function(data) {
            vm.entiHijasMap[data.model.entiId] = data.enti;
            vm.itemHijosMap[data.model.entiId] = data.resultList;
            vm.pageMap[data.model.entiId] = data.resultList.page;

            if (data.enti.id == vm.tabSelected) {
                vm.entiHijasMap[data.itemCriterio.entiId].active = true;
            }

            $location.search("pageMap", JSON.stringify(vm.pageMap)).replace();
        });
    }

    function pageChanged(subentiId) {
        findSublist(subentiId, vm.pageMap[subentiId]);
    }

    function tabSelected(tabNo) {
        if (vm.path == $location.path()) {
            $location.search("tab", tabNo).replace();
        }
    }

    function remove() {
        if (confirm("Are you sure?")) {
            $http.post("servicio/subservicio-remove.action", {
                model : vm.item
            }).success(function(data) {
                window.history.back();
            });
        }
    }

    function ssrvAction(accName) {
        switch (accName) {
        case "mabl-totales":
            $location.path("/servicio/ssrv/mablTotales/" + vm.item.entiId + "/" + vm.item.srvc.id + "/"
                    + vm.item.id);

            break;

        default:
            alert(accName);

            break;
        }
    }
}

function SsrvEditController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    initialize();

    function initialize() {
        vm.accion = $routeParams.accion;

        $http.post("servicio/subservicio-edit.action", {
            model : {
                id : $routeParams.ssrvId,
                entiId : $routeParams.entiId,
                srvc : {
                    id : $routeParams.srvcId
                }
            },
            accion : vm.accion
        }).success(function(data) {
            vm.enti = data.enti;
            vm.superentiList = data.superentiList;
            vm.fechaVigencia = data.fechaVigencia;
            vm.item = data.model;
            vm.itemPadresMap = data.itemPadresMap;
            vm.labelValuesMap = data.labelValuesMap;
        });

        pageTitleService.setTitleEnti($routeParams.entiId, "page_" + vm.accion);
    }

    function save() {
        $http.post("servicio/subservicio-save.action", {
            model : vm.item,
            accion : vm.accion
        }).success(function(data) {
            vm.accion == 'edit' ? setTimeout(function() {
                window.history.back();
            }, 0) : $location.path("/servicio/ssrv/detail/" + data.model.id).replace();
        });
    }

    function cancel() {
        window.history.back();
    }
}

function SsrvLupaController($http, $scope) {
    $scope.search = function(entiId, srvcId, numero, fechaVigencia) {
        return $http.post("servicio/subservicio-typeahead.action", {
            model : {
                entiId : entiId,
                srvcId : srvcId,
                textoBusqueda : numero,
                fechaVigencia : fechaVigencia
            }
        }).then(function(res) {
            return res.data.resultList;
        });
    };
}

function MablTotalesController($http, $routeParams, pageTitleService) {
    var vm = this;

    initialize();

    function initialize() {
        $http.post("servicio/manifiesto/bl-total-detail.action", {
            model : {
                id : $routeParams.ssrvId,
                srvc : {
                    id : $routeParams.srvcId
                }
            }
        }).success(function(data) {
            vm.item = data.model;
            vm.resumen = data.resumen;
        });

        pageTitleService.setTitleEnti($routeParams.entiId, "page_verificarTotales");
    }
}
