angular.module("servicio", [])

.config(config)

// ----------------- MENU PRINCIPAL --------------------------
.controller("servicioController", servicioController)

// ----------- SERVICIOS ------------------
.controller("srvcGridController", srvcGridController)

.controller("srvcDetailController", srvcDetailController)

.controller("srvcCreateController", srvcCreateController)

.controller("srvcEditController", srvcEditController)

.controller("srvcDuplicateController", srvcDuplicateController)

.controller('srvcLupaCtrl', srvcLupaCtrl)

.controller("maniTotalesController", maniTotalesController)

// ----------- SUBSERVICIOS ------------------
.controller("ssrvGridController", ssrvGridController)

.controller("ssrvDetailController", ssrvDetailController)

.controller("ssrvCreateController", ssrvCreateController)

.controller("ssrvEditController", ssrvEditController)

.controller("ssrvDuplicateController", ssrvDuplicateController)

.controller('ssrvLupaCtrl', ssrvLupaCtrl)

.controller("mablTotalesController", mablTotalesController)

.controller("atraAutorizarController", atraAutorizarController)

.controller("atraAnularController", atraAnularController)

.controller("atraIniciarController", atraIniciarController)

.controller("atraFinalizarController", atraFinalizarController)

.controller("atraDenegarController", atraDenegarController)

;

function config($routeProvider) {
    $routeProvider

    .when("/servicio", {
        title : 'servicio_main',
        templateUrl : "modules/entidad/servicio/servicio.html",
        controller : "servicioController",
        controllerAs : "vm"
    })

    .when("/servicio/srvc/grid/:entiId", {
        templateUrl : "modules/entidad/servicio/srvc-grid.html",
        controller : "srvcGridController",
        controllerAs : "vm",
        reloadOnSearch : false
    })

    .when("/servicio/srvc/create/:entiId", {
        templateUrl : "modules/entidad/servicio/srvc-edit.html",
        controller : "srvcCreateController",
        controllerAs : "vm"
    })

    .when("/servicio/srvc/detail/:entiId/:srvcId", {
        templateUrl : "modules/entidad/servicio/srvc-detail.html",
        controller : "srvcDetailController",
        controllerAs : "vm",
        reloadOnSearch : false
    })

    .when("/servicio/srvc/edit/:entiId/:srvcId", {
        templateUrl : "modules/entidad/servicio/srvc-edit.html",
        controller : "srvcEditController",
        controllerAs : "vm"
    })

    .when("/servicio/srvc/duplicate/:entiId/:srvcId", {
        templateUrl : "modules/entidad/servicio/srvc-edit.html",
        controller : "srvcDuplicateController",
        controllerAs : "vm"
    })

    .when("/servicio/srvc/maniTotales/:srvcId", {
        templateUrl : "modules/entidad/servicio/manifiesto/mani-totales.html",
        controller : "maniTotalesController",
        controllerAs : "vm"
    })

    .when("/servicio/ssrv/grid/:entiId", {
        templateUrl : "modules/entidad/servicio/ssrv-grid.html",
        controller : "ssrvGridController",
        controllerAs : "vm",
        reloadOnSearch : false
    })

    .when("/servicio/ssrv/create/:entiId/:srvcId", {
        templateUrl : "modules/entidad/servicio/ssrv-edit.html",
        controller : "ssrvCreateController",
        controllerAs : "vm"
    })

    .when("/servicio/ssrv/create/:entiId", {
        templateUrl : "modules/entidad/servicio/ssrv-edit.html",
        controller : "ssrvCreateController",
        controllerAs : "vm"
    })

    .when("/servicio/ssrv/detail/:entiId/:ssrvId", {
        templateUrl : "modules/entidad/servicio/ssrv-detail.html",
        controller : "ssrvDetailController",
        controllerAs : "vm",
        reloadOnSearch : false
    })

    .when("/servicio/ssrv/edit/:entiId/:ssrvId", {
        templateUrl : "modules/entidad/servicio/ssrv-edit.html",
        controller : "ssrvEditController",
        controllerAs : "vm"
    })

    .when("/servicio/ssrv/duplicate/:entiId/:ssrvId", {
        templateUrl : "modules/entidad/servicio/ssrv-edit.html",
        controller : "ssrvDuplicateController",
        controllerAs : "vm"
    })

    .when("/servicio/ssrv/mablTotales/:srvcId/:ssrvId", {
        templateUrl : "modules/entidad/servicio/manifiesto/mabl-totales.html",
        controller : "mablTotalesController",
        controllerAs : "vm"
    })

    .when("/servicio/ssrv/atraDenegar/:srvcId/:ssrvId", {
        templateUrl : "modules/entidad/servicio/escala/atra-denegar.html",
        controller : "atraDenegarController",
        controllerAs : "vm"
    })

    .when("/servicio/ssrv/atraAutorizar/:srvcId/:ssrvId", {
        templateUrl : "modules/entidad/servicio/escala/atra-autorizar.html",
        controller : "atraAutorizarController",
        controllerAs : "vm"
    })

    .when("/servicio/ssrv/atraAnular/:srvcId/:ssrvId", {
        templateUrl : "modules/entidad/servicio/escala/atra-anular.html",
        controller : "atraAnularController",
        controllerAs : "vm"
    })

    .when("/servicio/ssrv/atraIniciar/:srvcId/:ssrvId", {
        templateUrl : "modules/entidad/servicio/escala/atra-iniciar.html",
        controller : "atraIniciarController",
        controllerAs : "vm"
    })

    .when("/servicio/ssrv/atraFinalizar/:srvcId/:ssrvId", {
        templateUrl : "modules/entidad/servicio/escala/atra-finalizar.html",
        controller : "atraFinalizarController",
        controllerAs : "vm"
    })

    .when("/servicio/ssrv/atraCambiarMuelle/:srvcId/:ssrvId", {
        templateUrl : "modules/entidad/servicio/escala/atra-cambiarMuelle.html",
        controller : "atraCambiarMuelleController",
        controllerAs : "vm"
    })

    .when("/servicio/ssrv/atraAutorizarFPrevio/:srvcId/:ssrvId", {
        templateUrl : "modules/entidad/servicio/escala/atra-autorizarFPrevio.html",
        controller : "atraAutorizarFPrevioController",
        controllerAs : "vm"
    })

    ;
}

function servicioController($http, pageTitleService) {
    var vm = this;

    $http.post("servicio/tpsr-list.action").success(function(data) {
        vm.tpsrList = data.tpsrList;
        vm.tpssMap = data.tpssMap;
    });

    pageTitleService.setTitle("srvcList", "page_home");
}

function srvcGridController($http, $location, $routeParams, $modal, pageTitleService) {
    var vm = this;

    vm.search = search;
    vm.pageChanged = pageChanged;
    vm.filter = filter;
    vm.xlsExport = xlsExport;

    vm.itemCriterio = $routeParams.itemCriterio ? angular.fromJson($routeParams.itemCriterio) : {};
    vm.itemCriterio.entiId = $routeParams.entiId;

    function search(page) {
        $http.post("servicio/srvc-list.action", {
            itemCriterio : vm.itemCriterio,
            page : page,
            limit : vm.itemCriterio.limit
        }).success(function(data) {
            vm.enti = data.enti;
            vm.page = data.itemList.page;
            vm.itemList = data.itemList;
            vm.itemCriterio = data.itemCriterio;

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
        $http.post('servicio/srvc-xls-export.action', {
            itemCriterio : vm.itemCriterio
        }, {
            responseType : 'arraybuffer'
        }).success(function(data) {
            var file = new Blob([ data ], {
                type : 'application/xls'
            });

            setTimeout(function() {
                saveAs(file, vm.enti.id + '.xls');
            }, 0);
        });
    }

    function filter(size) {
        $http.post("servicio/srvc-filter.action", {
            itemCriterio : vm.itemCriterio
        }).success(function(data) {
            vm.labelValuesMap = data.labelValuesMap;
            vm.subpList = data.subpList;
            vm.limits = data.limits;
            vm.fechaVigencia = data.fechaVigencia;
        });
    }

    search($routeParams.page ? $routeParams.page : 1);
    pageTitleService.setTitleEnti($routeParams.entiId, "page_grid");
}

function srvcDetailController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.pageChanged = pageChanged;
    vm.tabSelected = tabSelected;
    vm.remove = remove;
    vm.download = download;
    vm.srvcAction = srvcAction;

    vm.path = $location.path();
    var pageMap = $routeParams.pageMap ? angular.fromJson($routeParams.pageMap) : {};

    vm.pageMap = {};

    function findSublist(subentiId, page) {
        $http.post("servicio/ssrv-list.action", {
            itemCriterio : {
                entiId : subentiId,
                srvc : {
                    id : $routeParams.srvcId
                }
            },
            page : page
        }).success(function(data) {
            vm.entiHijasMap[data.itemCriterio.entiId] = data.enti;
            vm.itemHijosMap[data.itemCriterio.entiId] = data.itemList;
            vm.pageMap[data.itemCriterio.entiId] = data.itemList.page;

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
            $http.post("servicio/srvc-remove.action", {
                item : {
                    id : vm.item.id
                }
            }).success(function(data) {
                window.history.back();
            });
        }
    }

    function download(archId, archNombre) {
        $http.post('servicio/srar-download.action', {
            srar : {
                srvcId : vm.item.id,
                archId : archId
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
        // ----------- MANIFIESTO ------------------
        // ----------- MANIFIESTO ------------------
        // ----------- MANIFIESTO ------------------

        case "mani-bloquear":
            $http.post("servicio/manifiesto/mani-bloquear.action", {
                item : {
                    id : vm.item.id
                }
            }).success(function(data) {
                vm.item = data.item;
            });

            break;
        case "mani-completar":
            $http.post("servicio/manifiesto/mani-completar.action", {
                item : {
                    id : vm.item.id
                }
            }).success(function(data) {
                vm.item = data.item;
            });

            break;
        case "mani-iniciar":
            $http.post("servicio/manifiesto/mani-iniciar.action", {
                item : {
                    id : vm.item.id
                }
            }).success(function(data) {
                vm.item = data.item;
            });

            break;
        case "mani-anular":
            $http.post("servicio/manifiesto/mani-anular.action", {
                item : {
                    id : vm.item.id
                }
            }).success(function(data) {
                vm.item = data.item;
            });

            break;
        case "mani-totales":
            $location.path("/servicio/srvc/maniTotales/" + vm.item.id);

            break;
        default:
            alert(accName);

            break;
        }
    }

    vm.tabActive = {};

    if ($routeParams.tab) {
        vm.tabActive[$routeParams.tab] = true;
    }

    $http.post("servicio/srvc-detail.action", {
        item : {
            id : $routeParams.srvcId,
            entiId : $routeParams.entiId
        }
    }).success(function(data) {
        vm.enti = data.enti;
        vm.item = data.item;
        vm.fechaVigencia = data.fechaVigencia;
        vm.arinList = data.arinList;

        vm.entiHijasMap = {};
        vm.itemHijosMap = {};

        for (i = 0; i < vm.enti.entiHijasList.length; i++) {
            var subentiId = vm.enti.entiHijasList[i];

            findSublist(subentiId, pageMap[subentiId] ? pageMap[subentiId] : 1);
        }
    });

    pageTitleService.setTitleEnti($routeParams.entiId, "page_detail");
}

function srvcCreateController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        $http.post("servicio/srvc-save.action", {
            item : vm.item,
            accion : vm.accion
        }).success(function(data) {
            $location.path("/servicio/srvc/detail/" + data.item.entiId + "/" + data.item.id).replace();
        });
    }

    function cancel() {
        window.history.back();
    }

    $http.post("servicio/srvc-create.action", {
        item : {
            entiId : $routeParams.entiId
        }
    }).success(function(data) {
        vm.enti = data.enti;
        vm.accion = data.accion;
        vm.fechaVigencia = data.fechaVigencia;
        vm.item = data.item;
        vm.labelValuesMap = data.labelValuesMap;
        vm.subpList = data.subpList;
    });

    pageTitleService.setTitleEnti($routeParams.entiId, "page_create");
}

function srvcEditController($http, $routeParams, pageTitleService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        $http.post("servicio/srvc-save.action", {
            item : vm.item,
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

    $http.post("servicio/srvc-edit.action", {
        item : {
            id : $routeParams.srvcId,
            entiId : $routeParams.entiId
        }
    }).success(function(data) {
        vm.enti = data.enti;
        vm.accion = data.accion;
        vm.fechaVigencia = data.fechaVigencia;
        vm.item = data.item;
        vm.labelValuesMap = data.labelValuesMap;
    });

    pageTitleService.setTitleEnti($routeParams.entiId, "page_edit");
}

function srvcDuplicateController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        $http.post("servicio/srvc-save.action", {
            item : vm.item,
            accion : vm.accion
        }).success(function(data) {
            $location.path("/servicio/srvc/detail/" + data.item.entiId + "/" + data.item.id).replace();
        });
    }

    function cancel() {
        window.history.back();
    }

    $http.post("servicio/srvc-duplicate.action", {
        item : {
            id : $routeParams.srvcId,
            entiId : $routeParams.entiId
        }
    }).success(function(data) {
        vm.enti = data.enti;
        vm.accion = data.accion;
        vm.fechaVigencia = data.fechaVigencia;
        vm.item = data.item;
        vm.labelValuesMap = data.labelValuesMap;
        vm.subpList = data.subpList;
    });

    pageTitleService.setTitleEnti($routeParams.entiId, "page_duplicate");
}

function srvcLupaCtrl($http, $scope) {
    $scope.getLabelValues = function(entiId, textoBusqueda) {
        if (textoBusqueda.length <= 0) {
            return null;
        }

        return $http.post('servicio/srvc-lupa.action', {
            itemLupaCriterio : {
                entiId : entiId,
                textoBusqueda : textoBusqueda,
                fechaVigencia : '2014-11-11T00:00:00'
            }
        }).then(function(res) {
            return res.data.itemList;
        });
    };
}

function maniTotalesController($scope, $http, $location, $routeParams) {
    $http.post("servicio/manifiesto/mani-totales.action", {
        item : {
            id : $routeParams.srvcId
        }
    }).success(function(data) {
        $scope.item = data.item;
        $scope.resumen = data.resumen;
    });
}

function ssrvGridController($http, $location, $routeParams, $modal, pageTitleService) {
    var vm = this;

    vm.search = search;
    vm.pageChanged = pageChanged;
    vm.filter = filter;
    vm.xlsExport = xlsExport;

    vm.itemCriterio = $routeParams.itemCriterio ? angular.fromJson($routeParams.itemCriterio) : {};
    vm.itemCriterio.entiId = $routeParams.entiId;

    function search(page) {
        $http.post("servicio/ssrv-list.action", {
            itemCriterio : vm.itemCriterio,
            page : page,
            limit : vm.itemCriterio.limit
        }).success(function(data) {
            vm.page = data.itemList.page;
            vm.enti = data.enti;
            vm.itemList = data.itemList;
            vm.itemCriterio = data.itemCriterio;

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
        $http.post('servicio/ssrv-xls-export.action', {
            itemCriterio : vm.itemCriterio
        }, {
            responseType : 'arraybuffer'
        }).success(function(data) {
            var file = new Blob([ data ], {
                type : 'application/xls'
            });

            setTimeout(function() {
                saveAs(file, vm.enti.id + '.xls');
            }, 0);
        });
    }

    function filter(size) {
        $http.post("servicio/ssrv-filter.action", {
            itemCriterio : vm.itemCriterio
        }).success(function(data) {
            vm.labelValuesMap = data.labelValuesMap;
            vm.limits = data.limits;
            vm.fechaVigencia = data.fechaVigencia;
        });
    }

    search($routeParams.page ? $routeParams.page : 1);

    pageTitleService.setTitleEnti($routeParams.entiId, "page_grid");
}

function ssrvDetailController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.pageChanged = pageChanged;
    vm.tabSelected = tabSelected;
    vm.remove = remove;
    vm.ssrvAction = ssrvAction;

    vm.path = $location.path();
    vm.pageMap = $routeParams.pageMap ? angular.fromJson($routeParams.pageMap) : {};

    vm.pageMap = {};

    function findSublist(subentiId, page) {
        $http.post("servicio/ssrv-list.action", {
            itemCriterio : {
                entiId : subentiId,
                padreId : $routeParams.ssrvId
            },
            page : page
        }).success(function(data) {
            vm.entiHijasMap[data.itemCriterio.entiId] = data.enti;
            vm.itemHijosMap[data.itemCriterio.entiId] = data.itemList;
            vm.pageMap[data.itemCriterio.entiId] = data.itemList.page;

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
            $http.post("servicio/ssrv-remove.action", {
                item : {
                    id : $scope.item.id
                }
            }).success(function(data) {
                window.history.back();
            });
        }
    }

    function ssrvAction(accName) {
        switch (accName) {
        // ----------- BL ------------------
        // ----------- BL ------------------
        // ----------- BL ------------------

        case "mabl-bloquear":
            $http.post("servicio/manifiesto/mabl-bloquear.action", {
                item : {
                    id : vm.item.id
                }
            }).success(function(data) {
                vm.item = data.item;
            });

            break;
        case "mabl-completar":
            $http.post("servicio/manifiesto/mabl-completar.action", {
                item : {
                    id : vm.item.id
                }
            }).success(function(data) {
                vm.item = data.item;
            });

            break;
        case "mabl-iniciar":
            $http.post("servicio/manifiesto/mabl-iniciar.action", {
                item : {
                    id : vm.item.id
                }
            }).success(function(data) {
                vm.item = data.item;
            });

            break;
        case "mabl-anular":
            $http.post("servicio/manifiesto/mabl-anular.action", {
                item : {
                    id : vm.item.id
                }
            }).success(function(data) {
                vm.item = data.item;
            });

            break;
        case "mabl-totales":
            $location.path("/servicio/ssrv/mablTotales/" + vm.item.srvc.id + "/" + vm.item.id);

            break;

        // ----------- EQUIPAMIENTO ------------------
        // ----------- EQUIPAMIENTO ------------------
        // ----------- EQUIPAMIENTO ------------------

        case "equi-bloquear":
            $http.post("servicio/manifiesto/equi-bloquear.action", {
                item : {
                    id : vm.item.id
                }
            }).success(function(data) {
                vm.item = data.item;
            });

            break;
        case "equi-iniciar":
            $http.post("servicio/manifiesto/equi-iniciar.action", {
                item : {
                    id : vm.item.id
                }
            }).success(function(data) {
                vm.item = data.item;
            });

            break;
        case "equi-anular":
            $http.post("servicio/manifiesto/equi-anular.action", {
                item : {
                    id : vm.item.id
                }
            }).success(function(data) {
                vm.item = data.item;
            });

            break;

        // ----------- PARTIDA ------------------
        // ----------- PARTIDA ------------------
        // ----------- PARTIDA ------------------
        case "part-bloquear":
            $http.post("servicio/manifiesto/part-bloquear.action", {
                item : {
                    id : vm.item.id
                }
            }).success(function(data) {
                vm.item = data.item;
            });

            break;
        case "part-iniciar":
            $http.post("servicio/manifiesto/part-iniciar.action", {
                item : {
                    id : vm.item.id
                }
            }).success(function(data) {
                vm.item = data.item;
            });

            break;
        case "part-anular":
            $http.post("servicio/manifiesto/part-anular.action", {
                item : {
                    id : vm.item.id
                }
            }).success(function(data) {
                vm.item = data.item;
            });

            break;

        case "atra-denegar":
            $location.path("/servicio/ssrv/atraDenegar/" + vm.item.srvc.id + "/" + vm.item.id);

            break;
        case "atra-autorizar":
            $location.path("/servicio/ssrv/atraAutorizar/" + vm.item.srvc.id + "/" + vm.item.id);

            break;
        case "atra-anular":
            $location.path("/servicio/ssrv/atraAnular/" + vm.item.srvc.id + "/" + vm.item.id);

            break;
        case "atra-iniciar":
            $location.path("/servicio/ssrv/atraIniciar/" + vm.item.srvc.id + "/" + vm.item.id);

            break;
        case "atra-finalizar":
            $location.path("/servicio/ssrv/atraFinalizar/" + vm.item.srvc.id + "/" + vm.item.id);

            break;
        case "atra-cambiar-muelle":
            $location.path("/servicio/ssrv/atraCambiarMuelle/" + vm.item.srvc.id + "/" + vm.item.id);

            break;
        case "atra-autorizar-fprevio":
            $location.path("/servicio/ssrv/atraAutorizarFPrevio/" + vm.item.srvc.id + "/" + vm.item.id);

            break;

        default:
            alert(accName);

            break;
        }
    }

    vm.tabActive = {};

    if ($routeParams.tab) {
        vm.tabActive[$routeParams.tab] = true;
    }

    $http.post("servicio/ssrv-detail.action", {
        item : {
            id : $routeParams.ssrvId,
            entiId : $routeParams.entiId
        }
    }).success(function(data) {
        vm.enti = data.enti;
        vm.fechaVigencia = data.fechaVigencia;
        vm.item = data.item;
        vm.itemPadresMap = data.itemPadresMap;

        vm.itemHijosMap = {};
        vm.entiHijasMap = {};

        if (data.enti.entiHijasList) {
            for (i = 0; i < data.enti.entiHijasList.length; i++) {
                findSublist(data.enti.entiHijasList[i], 1);
            }
        }
    });

    pageTitleService.setTitleEnti($routeParams.entiId, "page_detail");
}

function ssrvCreateController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        $http.post("servicio/ssrv-save.action", {
            item : vm.item,
            accion : vm.accion
        }).success(function(data) {
            $location.path("/servicio/ssrv/detail/" + data.item.id).replace();
        });
    }

    function cancel() {
        window.history.back();
    }

    $http.post("servicio/ssrv-create.action", {
        item : {
            entiId : $routeParams.entiId,
            srvc : {
                id : $routeParams.srvcId
            }
        }
    }).success(function(data) {
        vm.enti = data.enti;
        vm.superentiList = data.superentiList;
        vm.fechaVigencia = data.fechaVigencia;
        vm.item = data.item;
        vm.labelValuesMap = data.labelValuesMap;
        vm.accion = data.accion;
    });

    pageTitleService.setTitleEnti($routeParams.entiId, "page_create");
}

function ssrvEditController($http, $routeParams, pageTitleService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        $http.post("servicio/ssrv-save.action", {
            item : vm.item,
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

    $http.post("servicio/ssrv-edit.action", {
        item : {
            id : $routeParams.ssrvId,
            entiId : $routeParams.entiId
        }
    }).success(function(data) {
        vm.enti = data.enti;
        vm.fechaVigencia = data.fechaVigencia;
        vm.item = data.item;
        vm.itemPadresMap = data.itemPadresMap;
        vm.labelValuesMap = data.labelValuesMap;
        vm.accion = data.accion;
    });

    pageTitleService.setTitleEnti($routeParams.entiId, "page_edit");
}

function ssrvDuplicateController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        $http.post("servicio/ssrv-save.action", {
            item : vm.item,
            accion : vm.accion
        }).success(function(data) {
            $location.path("/servicio/ssrv/detail/" + data.item.entiId + "/" + data.item.id).replace();
        });
    }

    function cancel() {
        window.history.back();
    }

    $http.post("servicio/ssrv-duplicate.action", {
        item : {
            id : $routeParams.ssrvId,
            entiId : $routeParams.entiId
        }
    }).success(function(data) {
        vm.enti = data.enti;
        vm.fechaVigencia = data.fechaVigencia;
        vm.item = data.item;
        vm.labelValuesMap = data.labelValuesMap;
        vm.accion = data.accion;
    });

    pageTitleService.setTitleEnti($routeParams.entiId, "page_duplicate");
}

function ssrvLupaCtrl($http, $scope) {
    $scope.getLabelValues = function(entiId, srvcId, numero) {
        return $http.post("servicio/ssrv-lupa.action", {
            itemLupaCriterio : {
                entiId : entiId,
                srvcId : srvcId,
                numero : numero,
                fechaVigencia : "11/12/2014"
            }
        }).then(function(res) {
            return res.data.itemList;
        });
    };
}

function mablTotalesController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    $http.post("servicio/manifiesto/mabl-totales.action", {
        item : {
            id : $routeParams.ssrvId,
            srvc : {
                id : $routeParams.srvcId
            }
        }
    }).success(function(data) {
        vm.item = data.item;
        vm.resumen = data.resumen;
    });

    pageTitleService.setTitleEnti($routeParams.entiId, "page_verificarTotales");
}

function atraDenegarController($http, $routeParams, pageTitleService) {
    var vm = this;

    $http.post("servicio/escala/atra-denegar.action", {
        item : {
            id : $routeParams.ssrvId,
            srvc : {
                id : $routeParams.srvcId
            }
        }
    }).success(function(data) {
        vm.item = data.item;
        vm.enti = data.enti;

        pageTitleService.setTitleEnti(vm.enti.id, "page_atraDenegar");
    });
}

function atraAutorizarController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    $http.post("servicio/escala/atra-autorizar.action", {
        item : {
            id : $routeParams.ssrvId,
            srvc : {
                id : $routeParams.srvcId
            }
        }
    }).success(function(data) {
        vm.item = data.item;
        vm.enti = data.enti;

        pageTitleService.setTitleEnti(vm.enti.id, "page_atraAutorizar");
    });
}

function atraAnularController($http, $routeParams, pageTitleService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        alert('save');
    }

    function cancel() {
        window.history.back();
    }

    $http.post("servicio/escala/atra-anular.action", {
        item : {
            id : $routeParams.ssrvId,
            srvc : {
                id : $routeParams.srvcId
            }
        }
    }).success(function(data) {
        vm.item = data.item;
        vm.enti = data.enti;

        pageTitleService.setTitleEnti(vm.enti.id, "page_atraAnular");
    });
}

function atraIniciarController($http, $routeParams, pageTitleService) {
    var vm = this;

    $http.post("servicio/escala/atra-iniciar.action", {
        item : {
            id : $routeParams.ssrvId,
            srvc : {
                id : $routeParams.srvcId
            }
        }
    }).success(function(data) {
        vm.item = data.item;
        vm.enti = data.enti;

        pageTitleService.setTitleEnti(vm.enti.id, "page_atraIniciar");
    });
}

function atraFinalizarController($http, $routeParams, pageTitleService) {
    var vm = this;

    $http.post("servicio/escala/atra-finalizar.action", {
        item : {
            id : $routeParams.ssrvId,
            srvc : {
                id : $routeParams.srvcId
            }
        }
    }).success(function(data) {
        vm.item = data.item;
        vm.enti = data.enti;

        pageTitleService.setTitleEnti(vm.enti.id, "page_atraFinalizar");
    });
}

function atraCambiarMuelleController($scope, $http, $location, $routeParams, pageTitleService) {
    var vm = this;

    $http.post("servicio/escala/atra-cambiarMuelle.action", {
        item : {
            id : $routeParams.ssrvId,
            srvc : {
                id : $routeParams.srvcId
            }
        }
    }).success(function(data) {
        vm.item = data.item;
        vm.enti = data.enti;

        pageTitleService.setTitleEnti(vm.enti.id, "page_atraCambiarMuelle");
    });
}

function atraAutorizarFPrevioController($scope, $http, $location, $routeParams, pageTitleService) {
    var vm = this;

    $http.post("servicio/escala/atra-autorizarFPrevio.action", {
        item : {
            id : $routeParams.ssrvId,
            srvc : {
                id : $routeParams.srvcId
            }
        }
    }).success(function(data) {
        vm.item = data.item;
        vm.enti = data.enti;

        pageTitleService.setTitleEnti(vm.enti.id, "page_atraAutorizarFPrevio");
    });
}
