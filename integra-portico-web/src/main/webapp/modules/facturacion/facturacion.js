angular.module("facturacion", [ "ngRoute", "util" ])

.config(config)

// ----------------- MENU PRINCIPAL --------------------------
.controller("facturacionController", facturacionController)

// ----------- VALORADOR ------------------
.controller("vldrPrepareController", vldrPrepareController)

// ----------- VALORACION ------------------
.controller("vlrcGridController", vlrcGridController)

.controller("vlrcFilterController", vlrcFilterController)

.controller("vlrlCreateController", vlrlCreateController)

.controller("vlrcDetailController", vlrcDetailController)

.controller("vlrlDetailController", vlrlDetailController)

.controller("vlrlEditController", vlrlEditController)

.controller("vlrdDetailController", vlrdDetailController)

// ----------- CARGO y REGLA------------------
.controller("crgoGridController", crgoGridController)

.controller("crgoCreateController", crgoCreateController)

.controller("crgoDetailController", crgoDetailController)

.controller("crgoEditController", crgoEditController)

.controller("rglaDetailController", rglaDetailController)

.controller("rglaEditController", rglaEditController)

.controller("rglaCreateController", rglaCreateController)

.controller("rginDetailController", rginDetailController)

.controller("rginEditController", rginEditController)

.controller("rginCreateController", rginCreateController)

// ----------- ASPECTO y ASPECTO CARGO ------------------
.controller("aspcGridController", aspcGridController)

.controller("aspcCreateController", aspcCreateController)

.controller("aspcDetailController", aspcDetailController)

.controller("aspcEditController", aspcEditController)

.controller("aspcDuplicateController", aspcDuplicateController)

.controller("ascrCreateController", ascrCreateController)

.controller("ascrDetailController", ascrDetailController)

.controller("ascrEditController", ascrEditController);

function config($routeProvider) {
    $routeProvider

    .when("/facturacion", {
        templateUrl : "modules/facturacion/facturacion.html",
        controller : "facturacionController",
        controllerAs : "vm"
    })

    .when("/facturacion/vldr/prepare/:srvcId", {
        templateUrl : "modules/facturacion/vldr-prepare.html",
        controller : "vldrPrepareController",
        controllerAs : "vm",
        reloadOnSearch : false
    })

    .when("/facturacion/vlrc/grid", {
        templateUrl : "modules/facturacion/vlrc-grid.html",
        controller : "vlrcGridController",
        controllerAs : "vm",
        reloadOnSearch : false
    })

    .when("/facturacion/vlrc/detail/:vlrcId", {
        templateUrl : "modules/facturacion/vlrc-detail.html",
        controller : "vlrcDetailController",
        controllerAs : "vm"
    })

    .when("/facturacion/vlrc/edit/:vlrcId", {
        templateUrl : "modules/facturacion/vlrc-edit.html",
        controller : "vlrcEditController",
        controllerAs : "vm"
    })

    .when("/facturacion/vlrl/create/:vlrcId", {
        templateUrl : "modules/facturacion/vlrl-edit.html",
        controller : "vlrlCreateController",
        controllerAs : "vm"
    })

    .when("/facturacion/vlrl/detail/:vlrlId", {
        templateUrl : "modules/facturacion/vlrl-detail.html",
        controller : "vlrlDetailController",
        controllerAs : "vm"
    })

    .when("/facturacion/vlrl/edit/:vlrlId", {
        templateUrl : "modules/facturacion/vlrl-edit.html",
        controller : "vlrlEditController",
        controllerAs : "vm"
    })

    .when("/facturacion/vlrd/detail/:vlrdId", {
        templateUrl : "modules/facturacion/vlrd-detail.html",
        controller : "vlrdDetailController",
        controllerAs : "vm"
    })

    .when("/facturacion/vlrd/edit/:vlrdId", {
        templateUrl : "modules/facturacion/vlrd-edit.html",
        controller : "vlrdEditController",
        controllerAs : "vm"
    })

    .when("/facturacion/crgo/grid", {
        templateUrl : "modules/facturacion/crgo-grid.html",
        controller : "crgoGridController",
        controllerAs : "vm",
        reloadOnSearch : false
    })

    .when("/facturacion/crgo/detail/:crgoId", {
        templateUrl : "modules/facturacion/crgo-detail.html",
        controller : "crgoDetailController",
        controllerAs : "vm"
    })

    .when("/facturacion/crgo/detail/:crgoId/:fechaVigencia", {
        templateUrl : "modules/facturacion/crgo-detail.html",
        controller : "crgoDetailController",
        controllerAs : "vm"
    })

    .when("/facturacion/crgo/edit/:crgoId", {
        templateUrl : "modules/facturacion/crgo-edit.html",
        controller : "crgoEditController",
        controllerAs : "vm"
    })

    .when("/facturacion/crgo/edit/:crgoId/:fechaVigencia", {
        templateUrl : "modules/facturacion/crgo-edit.html",
        controller : "crgoEditController",
        controllerAs : "vm"
    })

    .when("/facturacion/crgo/create", {
        templateUrl : "modules/facturacion/crgo-edit.html",
        controller : "crgoCreateController",
        controllerAs : "vm"
    })

    .when("/facturacion/rgla/detail/:rglaId", {
        templateUrl : "modules/facturacion/rgla-detail.html",
        controller : "rglaDetailController",
        controllerAs : "vm"
    })

    .when("/facturacion/rgla/detail/:rglaId/:fechaVigencia", {
        templateUrl : "modules/facturacion/rgla-detail.html",
        controller : "rglaDetailController",
        controllerAs : "vm"
    })

    .when("/facturacion/rgla/edit/:rglaId", {
        templateUrl : "modules/facturacion/rgla-edit.html",
        controller : "rglaEditController",
        controllerAs : "vm"
    })

    .when("/facturacion/rgla/edit/:rglaId/:fechaVigencia", {
        templateUrl : "modules/facturacion/rgla-edit.html",
        controller : "rglaEditController",
        controllerAs : "vm"
    })

    .when("/facturacion/rgla/create/:crgoId", {
        templateUrl : "modules/facturacion/rgla-edit.html",
        controller : "rglaCreateController",
        controllerAs : "vm"
    })

    .when("/facturacion/rgla/create/:crgoId/:fechaVigencia", {
        templateUrl : "modules/facturacion/rgla-edit.html",
        controller : "rglaCreateController",
        controllerAs : "vm"
    })

    .when("/facturacion/rgin/detail/:rginId", {
        templateUrl : "modules/facturacion/rgin-detail.html",
        controller : "rginDetailController",
        controllerAs : "vm"
    })

    .when("/facturacion/rgin/detail/:rginId/:fechaVigencia", {
        templateUrl : "modules/facturacion/rgin-detail.html",
        controller : "rginDetailController",
        controllerAs : "vm"
    })

    .when("/facturacion/rgin/edit/:rgivId", {
        templateUrl : "modules/facturacion/rgin-edit.html",
        controller : "rginEditController",
        controllerAs : "vm"
    })

    .when("/facturacion/rgin/create/:crgoId/:rgla1Id", {
        templateUrl : "modules/facturacion/rgin-edit.html",
        controller : "rginCreateController",
        controllerAs : "vm"
    })

    .when("/facturacion/aspc/grid", {
        templateUrl : "modules/facturacion/aspc-grid.html",
        controller : "aspcGridController",
        controllerAs : "vm",
        reloadOnSearch : false
    })

    .when("/facturacion/aspc/create", {
        templateUrl : "modules/facturacion/aspc-edit.html",
        controller : "aspcCreateController",
        controllerAs : "vm"
    })

    .when("/facturacion/aspc/detail/:aspcId", {
        templateUrl : "modules/facturacion/aspc-detail.html",
        controller : "aspcDetailController",
        controllerAs : "vm"
    })

    .when("/facturacion/aspc/detail/:aspcId/:fechaVigencia", {
        templateUrl : "modules/facturacion/aspc-detail.html",
        controller : "aspcDetailController",
        controllerAs : "vm"
    })

    .when("/facturacion/aspc/edit/:aspcId", {
        templateUrl : "modules/facturacion/aspc-edit.html",
        controller : "aspcEditController",
        controllerAs : "vm"
    })

    .when("/facturacion/aspc/edit/:aspcId/:fechaVigencia", {
        templateUrl : "modules/facturacion/aspc-edit.html",
        controller : "aspcEditController",
        controllerAs : "vm"
    })

    .when("/facturacion/aspc/duplicate/:aspcId", {
        templateUrl : "modules/facturacion/aspc-edit.html",
        controller : "aspcDuplicateController",
        controllerAs : "vm"
    })

    .when("/facturacion/aspc/duplicate/:aspcId/:fechaVigencia", {
        templateUrl : "modules/facturacion/aspc-edit.html",
        controller : "aspcDuplicateController",
        controllerAs : "vm"
    })

    .when("/facturacion/ascr/create/:aspcId/:fechaVigencia", {
        templateUrl : "modules/facturacion/ascr-edit.html",
        controller : "ascrCreateController",
        controllerAs : "vm"
    })

    .when("/facturacion/ascr/detail/:ascrId/:fechaVigencia", {
        templateUrl : "modules/facturacion/ascr-detail.html",
        controller : "ascrDetailController",
        controllerAs : "vm"
    })

    .when("/facturacion/ascr/edit/:ascrId", {
        templateUrl : "modules/facturacion/ascr-edit.html",
        controller : "ascrEditController",
        controllerAs : "vm"
    })

    .when("/facturacion/ascr/edit/:ascrId/:fechaVigencia", {
        templateUrl : "modules/facturacion/ascr-edit.html",
        controller : "ascrEditController",
        controllerAs : "vm"
    });
}

function facturacionController(pageTitleService) {
    pageTitleService.setTitle("sec_facturacion", "page_home");
}

function vldrPrepareController($http, $location, $routeParams, $modal, pageTitleService) {
    var vm = this;

    pageTitleService.setTitle("vldr", "page_prepare");
}

function vlrcGridController($http, $location, $routeParams, $modal, pageTitleService) {
    var vm = this;

    vm.pageChanged = pageChanged;
    vm.filter = filter;

    vm.vlrcCriterio = $routeParams.vlrcCriterio ? angular.fromJson($routeParams.vlrcCriterio) : {};

    if ($routeParams.srvcId) {
        vm.vlrcCriterio.srvc = {
            id : $routeParams.srvcId
        };
    }

    function search(vlrcCriterio, page, limit) {
        $http.post("facturacion/vlrc-list.action", {
            vlrcCriterio : vlrcCriterio,
            page : page,
            limit : limit
        }).success(function(data) {
            vm.page = data.vlrcList.page;
            vm.vlrcList = data.vlrcList;
            vm.vlrcCriterio = data.vlrcCriterio;

            var map = {};

            map.page = data.vlrcList.page;
            map.vlrcCriterio = JSON.stringify(data.vlrcCriterio);

            $location.search(map).replace();
        });
    }

    function pageChanged() {
        search($scope.vlrcCriterio, $scope.page, $scope.limit);
    }

    function filter(size) {
        var modalInstance = $modal.open({
            templateUrl : 'modules/facturacion/vlrc-filter-content.html',
            controller : 'vlrcFilterController',
            controllerAs : 'vm',
            size : size,
            resolve : {
                vlrcCriterio : function() {
                    return vm.vlrcCriterio;
                }
            }
        });

        modalInstance.result.then(function(vlrcCriterio) {
            vm.vlrcCriterio = vlrcCriterio;

            search(vm.vlrcCriterio, 1, vm.limit);
        });
    }

    search(vm.vlrcCriterio, $routeParams.page ? $routeParams.page : 1, vm.limit);

    pageTitleService.setTitle("vlrc", "page_grid");
}

function vlrcFilterController($http, $modalInstance, vlrcCriterio, pageTitleService) {
    var vm = this;

    vm.ok = ok;
    vm.cancel = cancel;
    vm.tpsrChanged = tpsrChanged;

    function ok() {
        $modalInstance.close(vm.vlrcCriterio);
    }

    function cancel() {
        $modalInstance.dismiss('cancel');
    }

    function tpsrChanged(tpsrId) {
        $http.post("facturacion/vlrc-reload-filter.action", {
            vlrcCriterio : {
                tpsrId : tpsrId
            }
        }).success(function(data) {
            vm.crgoList = data.crgoList;
            vm.aspcList = data.aspcList;
        });
    }

    vm.vlrcCriterio = vlrcCriterio;

    $http.post("facturacion/vlrc-filter.action").success(function(data) {
        vm.tpsrList = data.tpsrList;
    });
}

function vlrlCreateController($scope, $http, $location, $routeParams, pageTitleService) {
    $http.post("facturacion/vlrl-create.action", {
        vlrl : {
            vlrcId : $routeParams.vlrcId
        }
    }).success(function(data) {
        $scope.vlrl = data.vlrl;
        $scope.accion = data.accion;
    });

    $scope.save = function() {
        $http.post("facturacion/vlrl-save.action", {
            vlrl : $scope.vlrl,
            accion : $scope.accion
        }).success(function(data) {
            $location.path("/facturacion/vlrl/detail/" + data.vlrl.id).replace();
        });
    };

    $scope.cancel = function() {
        window.history.back();
    };

    pageTitleService.setTitle("vlrc", "page_create");
}

function vlrcDetailController($scope, $http, $location, $routeParams, pageTitleService) {
    $http.post("facturacion/vlrc-detail.action", {
        vlrc : {
            id : $routeParams.vlrcId
        }
    }).success(function(data) {
        $scope.vlrc = data.vlrc;
        $scope.vlrgList = data.vlrgList;
        $scope.vlriList = data.vlriList;
    });

    $http.post("facturacion/vlrl-list.action", {
        vlrlCriterio : {
            vlrc : {
                id : $routeParams.vlrcId
            }
        }
    }).success(function(data) {
        $scope.vlrlList = data.vlrlList;
    });

    pageTitleService.setTitle("vlrc", "page_detail");
}

function vlrlDetailController($scope, $http, $location, $routeParams, pageTitleService) {
    $http.post("facturacion/vlrl-detail.action", {
        vlrl : {
            id : $routeParams.vlrlId
        }
    }).success(function(data) {
        $scope.vlrl = data.vlrl;
    });

    $http.post("facturacion/vlrd-list.action", {
        vlrdCriterio : {
            vlrl : {
                id : $routeParams.vlrlId
            }
        }
    }).success(function(data) {
        $scope.vlrdList = data.vlrdList;
    });

    $scope.remove = function() {
        if (confirm("Are you sure?")) {
            $http.post("facturacion/vlrl-remove.action", {
                vlrl : {
                    id : $scope.vlrl.id
                }
            }).success(function(data) {
                window.history.back();
            });
        }
    };

    pageTitleService.setTitle("vlrl", "page_detail");
}

function vlrlEditController($scope, $http, $location, $routeParams, pageTitleService) {
    $http.post("facturacion/vlrl-edit.action", {
        vlrl : {
            id : $routeParams.vlrlId
        }
    }).success(function(data) {
        $scope.vlrl = data.vlrl;
        $scope.accion = data.accion;
    });

    $scope.save = function() {
        $http.post("facturacion/vlrl-save.action", {
            vlrl : $scope.vlrl,
            accion : $scope.accion
        }).success(function(data) {
            setTimeout(function() {
                window.history.back();
            }, 0);
        });
    };

    $scope.cancel = function() {
        window.history.back();
    };

    pageTitleService.setTitle("vlrl", "page_edit");
}

function vlrdDetailController($scope, $http, $location, $routeParams, pageTitleService) {
    $http.post("facturacion/vlrd-detail.action", {
        vlrd : {
            id : $routeParams.vlrdId
        }
    }).success(function(data) {
        $scope.vlrd = data.vlrd;
    });

    pageTitleService.setTitle("vlrl", "page_edit");
}

function crgoGridController($http, $location, $routeParams, $modal, pageTitleService) {
    var vm = this;

    vm.search = search;
    vm.pageChanged = pageChanged;
    vm.filter = filter;

    vm.crgoCriterio = $routeParams.crgoCriterio ? angular.fromJson($routeParams.crgoCriterio) : {};
    vm.page = $routeParams.page ? $routeParams.page : 1;

    function search(page) {
        $http.post("facturacion/crgo-list.action", {
            crgoCriterio : vm.crgoCriterio,
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
        $http.post("metamodelo/enti-lv-list.action", {
            entiCriterio : {
                tipo : "T"
            }
        }).success(function(data) {
            vm.entiList = data.lvList;
        });
    }

    search($routeParams.page ? $routeParams.page : 1);
    pageTitleService.setTitle("crgo", "page_grid");
}

function crgoDetailController($http, $routeParams, pageTitleService) {
    var vm = this;

    vm.remove = remove;

    function remove() {
        if (confirm("Are you sure?")) {
            $http.post("facturacion/crgo-remove.action", {
                crgo : {
                    crgv : {
                        id : vm.crgo.crgv.id
                    }
                }
            }).success(function(data) {
                window.history.back();
            });
        }
    }

    $http.post("facturacion/crgo-detail.action", {
        crgo : {
            id : $routeParams.crgoId
        },
        fechaVigencia : $routeParams.fechaVigencia
    }).success(function(data) {
        vm.crgo = data.crgo;
        vm.i18nMap = data.i18nMap;
        vm.rglaList = data.rglaList;
        vm.fechaVigencia = data.fechaVigencia;
    });

    pageTitleService.setTitle("crgo", "page_detail");
}

function crgoCreateController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        $http.post("facturacion/crgo-save.action", {
            crgo : vm.crgo,
            i18nMap : vm.i18nMap,
            accion : vm.accion
        }).success(function(data) {
            $location.path("/facturacion/crgo/detail/" + data.crgo.crgv.id).replace();
        });
    }

    function cancel() {
        window.history.back();
    }

    $http.post("facturacion/crgo-create.action").success(function(data) {
        vm.crgo = data.crgo;
        vm.tipos = data.tipos;
        vm.accion = data.accion;
        vm.entiList = data.tpsrList;
    });

    pageTitleService.setTitle("crgo", "page_create");
}

function crgoEditController($http, $routeParams, pageTitleService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        $http.post("facturacion/crgo-save.action", {
            crgo : vm.crgo,
            i18nMap : vm.i18nMap,
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

    $http.post("facturacion/crgo-edit.action", {
        crgo : {
            id : $routeParams.crgoId
        },
        fechaVigencia : $routeParams.fechaVigencia
    }).success(function(data) {
        vm.crgo = data.crgo;
        vm.i18nMap = data.i18nMap;
        vm.tipos = data.tipos;
        vm.accion = data.accion;
    });

    pageTitleService.setTitle("crgo", "page_edit");
}

function rglaDetailController($http, $routeParams, pageTitleService) {
    var vm = this;

    vm.remove = remove;

    function remove() {
        if (confirm("Are you sure?")) {
            $http.post("facturacion/rgla-remove.action", {
                rgla : {
                    rglv : {
                        id : vm.rgla.rglv.id
                    }
                }
            }).success(function(data) {
                window.history.back();
            });
        }
    }

    $http.post("facturacion/rgla-detail.action", {
        rgla : {
            id : $routeParams.rglaId
        },
        fechaVigencia : $routeParams.fechaVigencia
    }).success(function(data) {
        vm.rgla = data.rgla;
        vm.rginList = data.rginList;
        vm.fechaVigencia = data.fechaVigencia;
    });

    pageTitleService.setTitle("rgla", "page_detail");
}

function rglaEditController($http, $routeParams, pageTitleService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        $http.post("facturacion/rgla-save.action", {
            rgla : vm.rgla,
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

    $http.post("facturacion/rgla-edit.action", {
        rgla : {
            id : $routeParams.rglaId
        },
        fechaVigencia : $routeParams.fechaVigencia
    }).success(function(data) {
        vm.rgla = data.rgla;
        vm.tipos = data.tipos;
        vm.entiFacturableList = data.entiFacturableList;
        vm.accion = data.accion;
    });

    pageTitleService.setTitle("rgla", "page_edit");
}

function rglaCreateController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        $http.post("facturacion/rgla-save.action", {
            rgla : vm.rgla,
            accion : vm.accion
        }).success(function(data) {
            $location.path("/facturacion/rgla/detail/" + data.rgla.id + "/" + data.rgla.rglv.fini).replace();
        });
    }

    function cancel() {
        window.history.back();
    }

    $http.post("facturacion/rgla-create.action", {
        rgla : {
            crgo : {
                id : $routeParams.crgoId
            },
            fechaVigencia : $routeParams.fechaVigencia
        }
    }).success(function(data) {
        vm.rgla = data.rgla;
        vm.tipos = data.tipos;
        vm.entiFacturableList = data.entiFacturableList;
        vm.accion = data.accion;
    });

    pageTitleService.setTitle("rgla", "page_create");
}

function rginDetailController($http, $routeParams, pageTitleService) {
    var vm = this;

    vm.remove = remove;

    function remove() {
        if (confirm("Are you sure?")) {
            $http.post("facturacion/rgin-remove.action", {
                rgin : {
                    rgiv : {
                        id : vm.rgin.rgiv.id
                    }
                }
            }).success(function(data) {
                window.history.back();
            });
        }
    }

    $http.post("facturacion/rgin-detail.action", {
        rgin : {
            id : $routeParams.rginId
        },
        fechaVigencia : $routeParams.fechaVigencia
    }).success(function(data) {
        vm.rgin = data.rgin;
        vm.fechaVigencia = data.fechaVigencia;
    });

    pageTitleService.setTitle("rgin", "page_detail");
}

function rginEditController($http, $routeParams, pageTitleService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        $http.post("facturacion/rgin-save.action", {
            rgin : vm.rgin,
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

    $http.post("facturacion/rgin-edit.action", {
        rgin : {
            rgiv : {
                id : $routeParams.rgivId
            }
        }
    }).success(function(data) {
        vm.rgin = data.rgin;
        vm.accion = data.accion;
    });

    pageTitleService.setTitle("rgin", "page_edit");
}

function rginCreateController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        $http.post("facturacion/rgin-save.action", {
            rgin : vm.rgin,
            accion : vm.accion
        }).success(function(data) {
            $location.path("/facturacion/rgin/detail/" + data.rgin.id).replace();
        });
    }

    function cancel() {
        window.history.back();
    }

    $http.post("facturacion/rgin-create.action", {
        rgin : {
            rgla1Id : $routeParams.rgla1Id
        },
        crgoId : $routeParams.crgoId
    }).success(function(data) {
        vm.rgin = data.rgin;
        vm.accion = data.accion;
        vm.rgla2List = data.rgla2List;
    });

    pageTitleService.setTitle("rgin", "page_create");
}

function aspcGridController($http, $location, $routeParams, $modal, pageTitleService) {
    var vm = this;

    vm.search = search;
    vm.pageChanged = pageChanged;
    vm.filter = filter;

    vm.aspcCriterio = $routeParams.aspcCriterio ? angular.fromJson($routeParams.aspcCriterio) : {};
    vm.page = $routeParams.page ? $routeParams.page : 1;

    function search(page) {
        $http.post("facturacion/aspc-list.action", {
            aspcCriterio : vm.aspcCriterio,
            page : page,
            limit : vm.limit
        }).success(function(data) {
            vm.aspcList = data.aspcList;
            vm.page = data.aspcList.page;

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
        $http.post("metamodelo/enti-lv-list.action", {
            entiCriterio : {
                tipo : "T"
            }
        }).success(function(data) {
            vm.entiList = data.lvList;
        });
    }

    search($routeParams.page ? $routeParams.page : 1);
    pageTitleService.setTitle("aspc", "page_grid");
}

function aspcDetailController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.remove = remove;

    function remove() {
        if (confirm("Are you sure?")) {
            $http.post("facturacion/aspc-remove.action", {
                aspc : {
                    aspv : {
                        id : vm.aspc.aspv.id
                    }
                }
            }).success(function(data) {
                window.history.back();
            });
        }
    }

    $http.post("facturacion/aspc-detail.action", {
        aspc : {
            id : $routeParams.aspcId
        },
        fechaVigencia : $routeParams.fechaVigencia
    }).success(function(data) {
        vm.urlInclude = 'modules/facturacion/aspc-detail.html';
        vm.aspc = data.aspc;
        vm.i18nMap = data.i18nMap;
        vm.ascrList = data.ascrList;
        vm.fechaVigencia = data.fechaVigencia;
    });

    pageTitleService.setTitle("aspc", "page_detail");
}

function aspcCreateController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        $http.post("facturacion/aspc-save.action", {
            aspc : vm.aspc,
            i18nMap : vm.i18nMap,
            accion : vm.accion
        }).success(function(data) {
            $location.path("/facturacion/aspc/detail/" + data.aspc.id + "/" + data.aspc.aspv.fini).replace();
        });
    }

    function cancel() {
        window.history.back();
    }

    $http.post("facturacion/aspc-create.action").success(function(data) {
        vm.aspc = data.aspc;
        vm.accion = data.accion;
        vm.entiTpsrList = data.entiList;
    });

    pageTitleService.setTitle("aspc", "page_create");
}

function aspcEditController($http, $routeParams, pageTitleService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        $http.post("facturacion/aspc-save.action", {
            aspc : vm.aspc,
            i18nMap : vm.i18nMap,
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

    $http.post("facturacion/aspc-edit.action", {
        aspc : {
            id : $routeParams.aspcId
        },
        fechaVigencia : $routeParams.fechaVigencia
    }).success(function(data) {
        vm.aspc = data.aspc;
        vm.i18nMap = data.i18nMap;
        vm.accion = data.accion;
    });

    pageTitleService.setTitle("aspc", "page_edit");
}

function aspcDuplicateController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        $http.post("facturacion/aspc-save.action", {
            aspc : vm.aspc,
            i18nMap : vm.i18nMap,
            accion : vm.accion
        }).success(function(data) {
            $location.path("/facturacion/aspc/detail/" + data.aspc.id + "/" + data.aspc.aspv.fini).replace();
        });
    }

    function cancel() {
        window.history.back();
    }

    $http.post("facturacion/aspc-duplicate.action", {
        aspc : {
            id : $routeParams.aspcId
        },
        fechaVigencia : $routeParams.fechaVigencia
    }).success(function(data) {
        vm.aspc = data.aspc;
        vm.i18nMap = data.i18nMap;
        vm.accion = data.accion;
    });

    pageTitleService.setTitle("aspc", "page_duplicate");
}

function ascrDetailController($http, $routeParams, pageTitleService) {
    var vm = this;

    vm.remove = remove;

    function remove() {
        if (confirm("Are you sure?")) {
            $http.post("facturacion/ascr-remove.action", {
                ascr : {
                    ascv : {
                        id : vm.ascr.ascv.id
                    }
                }
            }).success(function(data) {
                window.history.back();
            });
        }
    }

    $http.post("facturacion/ascr-detail.action", {
        ascr : {
            id : $routeParams.ascrId
        },
        fechaVigencia : $routeParams.fechaVigencia
    }).success(function(data) {
        vm.ascr = data.ascr;
        vm.fechaVigencia = data.fechaVigencia;
    });

    pageTitleService.setTitle("ascr", "page_detail");
}

function ascrCreateController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        $http.post("facturacion/ascr-save.action", {
            ascr : vm.ascr,
            accion : vm.accion
        }).success(function(data) {
            $location.path("/facturacion/ascr/detail/" + data.ascr.id + "/" + data.ascr.ascv.fini).replace();
        });
    }

    function cancel() {
        window.history.back();
    }

    $http.post("facturacion/ascr-create.action", {
        ascr : {
            aspcId : $routeParams.aspcId
        },
        fechaVigencia : $routeParams.fechaVigencia
    }).success(function(data) {
        vm.ascr = data.ascr;
        vm.crgoList = data.crgoList;
        vm.accion = data.accion;
    });

    pageTitleService.setTitle("ascr", "page_create");
}

function ascrEditController($http, $routeParams, pageTitleService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        $http.post("facturacion/ascr-save.action", {
            ascr : vm.ascr,
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

    $http.post("facturacion/ascr-edit.action", {
        ascr : {
            id : $routeParams.ascrId
        },
        fechaVigencia : $routeParams.fechaVigencia
    }).success(function(data) {
        vm.ascr = data.ascr;
        vm.accion = data.accion;
    });

    pageTitleService.setTitle("ascr", "page_edit");
}