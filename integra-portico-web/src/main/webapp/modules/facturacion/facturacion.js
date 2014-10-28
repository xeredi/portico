angular.module("facturacion", [ "ngRoute", "util" ])

.config(config)

// ----------------- MENU PRINCIPAL --------------------------
.controller("facturacionController", facturacionController)

// ----------- VALORACION ------------------
.controller("vlrcGridController", vlrcGridController)

.controller("vlrlCreateController", vlrlCreateController)

.controller("vlrcDetailController", vlrcDetailController)

.controller("vlrlDetailController", vlrlDetailController)

.controller("vlrlEditController", vlrlEditController)

.controller("vlrdDetailController", vlrdDetailController)

// ----------- CARGO y REGLA------------------
.controller("crgoGridController", crgoGridController)

.controller("crgoFilterController", crgoFilterController)

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

.controller('aspcFilterController', aspcFilterController)

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

    .when("/facturacion/crgo/detail/:crgoId/:fechaVigencia", {
        templateUrl : "modules/facturacion/crgo-detail.html",
        controller : "crgoDetailController",
        controllerAs : "vm"
    })

    .when("/facturacion/crgo/detail/:crgvId", {
        templateUrl : "modules/facturacion/crgo-detail.html",
        controller : "crgoDetailController",
        controllerAs : "vm"
    })

    .when("/facturacion/crgo/edit/:crgvId", {
        templateUrl : "modules/facturacion/crgo-edit.html",
        controller : "crgoEditController",
        controllerAs : "vm"
    })

    .when("/facturacion/crgo/create", {
        templateUrl : "modules/facturacion/crgo-edit.html",
        controller : "crgoCreateController",
        controllerAs : "vm"
    })

    .when("/facturacion/rgla/detail/:rglaId/:fechaVigencia", {
        templateUrl : "modules/facturacion/rgla-detail.html",
        controller : "rglaDetailController",
        controllerAs : "vm"
    })

    .when("/facturacion/rgla/detail/:rglvId", {
        templateUrl : "modules/facturacion/rgla-detail.html",
        controller : "rglaDetailController",
        controllerAs : "vm"
    })

    .when("/facturacion/rgla/edit/:rglvId", {
        templateUrl : "modules/facturacion/rgla-edit.html",
        controller : "rglaEditController",
        controllerAs : "vm"
    })

    .when("/facturacion/rgla/create/:crgvId", {
        templateUrl : "modules/facturacion/rgla-edit.html",
        controller : "rglaCreateController",
        controllerAs : "vm"
    })

    .when("/facturacion/rgin/detail/:rgivId", {
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

    .when("/facturacion/rgin/create/:crgoId/:rglaId", {
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

    .when("/facturacion/aspc/edit/:aspvId", {
        templateUrl : "modules/facturacion/aspc-edit.html",
        controller : "aspcEditController",
        controllerAs : "vm"
    })

    .when("/facturacion/aspc/duplicate/:aspvId", {
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

    .when("/facturacion/ascr/edit/:ascvId", {
        templateUrl : "modules/facturacion/ascr-edit.html",
        controller : "ascrEditController",
        controllerAs : "vm"
    })
}

function facturacionController(pageTitleService) {
    pageTitleService.setTitle("facturacion", "page_home");
}

function vlrcGridController($scope, $http, $location, $routeParams, pageTitleService) {
    $scope.showFilter = false;

    $scope.pageChanged = function() {
        search($scope.vlrcCriterio, $scope.page, $scope.limit);
    }

    $scope.tpsrChanged = function() {
        if ($scope.vlrcCriterio.srvc) {
            $scope.vlrcCriterio.srvc = null;
        }
        if ($scope.vlrcCriterio.aspcId) {
            $scope.vlrcCriterio.aspcId = null;
        }
        if ($scope.vlrcCriterio.crgoId) {
            $scope.vlrcCriterio.crgoId = null;
        }

        if ($scope.vlrcCriterio.tpsrId) {
            var url = "facturacion/vlrc-reload-filter.action?vlrcCriterio.tpsrId=" + $scope.vlrcCriterio.tpsrId;

            $http.get(url).success(function(data) {
                $scope.actionErrors = data.actionErrors;

                if (data.actionErrors.length == 0) {
                    $scope.crgoList = data.crgoList;
                    $scope.aspcList = data.aspcList;
                }
            });
        }
    }

    $scope.filter = function() {
        var url = "facturacion/vlrc-filter.action";

        $http.get(url).success(function(data) {
            $scope.actionErrors = data.actionErrors;

            if (data.actionErrors.length == 0) {
                $scope.tpsrList = data.tpsrList;
                $scope.limits = data.limits;
            }
        });

        $scope.showFilter = true;
    }

    $scope.search = function() {
        search($scope.vlrcCriterio, 1, $scope.limit);
    }

    $scope.cancelSearch = function() {
        $scope.showFilter = false;
    }

    function search(vlrcCriterio, page, limit) {
        var url = "facturacion/vlrc-list.action";

        $http.post(url, {
            vlrcCriterio : vlrcCriterio,
            page : page,
            limit : limit
        }).success(function(data) {
            $scope.actionErrors = data.actionErrors;

            if (data.actionErrors.length == 0) {
                $scope.page = data.vlrcList.page;
                $scope.vlrcList = data.vlrcList;
                $scope.vlrcCriterio = data.vlrcCriterio;
                $scope.limit = data.limit;

                var map = {};

                map["page"] = data.vlrcList.page;
                map["vlrcCriterio"] = data.vlrcCriterio;

                $location.search(map).replace();

                $scope.showFilter = false;
            }
        });
    }

    search($scope.vlrcCriterio, $routeParams.page ? $routeParams.page : 1, $scope.limit);

    pageTitleService.setTitle("vlrc", "page_grid");
}

function vlrlCreateController($scope, $http, $location, $routeParams, pageTitleService) {
    var url = "facturacion/vlrl-create.action?vlrl.vlrcId=" + $routeParams.vlrcId;

    $http.get(url).success(function(data) {
        $scope.vlrl = data.vlrl;
        $scope.accion = data.accion;
    });

    $scope.save = function() {
        var url = "facturacion/vlrl-save.action";

        $http.post(url, {
            vlrl : $scope.vlrl,
            accion : $scope.accion
        }).success(function(data) {
            $scope.actionErrors = data.actionErrors;

            if (data.actionErrors.length == 0) {
                $location.path("/facturacion/vlrl/detail/" + data.vlrl.id).replace();
            }
        });
    }

    $scope.cancel = function() {
        window.history.back();
    }

    pageTitleService.setTitle("vlrc", "page_create");
}

function vlrcDetailController($scope, $http, $location, $routeParams, pageTitleService) {
    var url = "facturacion/vlrc-detail.action?vlrc.id=" + $routeParams.vlrcId;

    $http.get(url).success(function(data) {
        $scope.vlrc = data.vlrc;
        $scope.vlrgList = data.vlrgList;
        $scope.vlriList = data.vlriList;
    });

    var urlVlrlList = "facturacion/vlrl-list.action?vlrlCriterio.vlrc.id=" + $routeParams.vlrcId;

    $http.get(urlVlrlList).success(function(data) {
        $scope.vlrlList = data.vlrlList;
    });

    pageTitleService.setTitle("vlrc", "page_detail");
}

function vlrlDetailController($scope, $http, $location, $routeParams, pageTitleService) {
    var url = "facturacion/vlrl-detail.action?vlrl.id=" + $routeParams.vlrlId;

    $http.get(url).success(function(data) {
        $scope.vlrl = data.vlrl;
    });

    var urlVlrdList = "facturacion/vlrd-list.action?vlrdCriterio.vlrl.id=" + $routeParams.vlrlId;

    $http.get(urlVlrdList).success(function(data) {
        $scope.vlrdList = data.vlrdList;
    });

    $scope.remove = function() {
        if (confirm("Are you sure?")) {
            var url = "facturacion/vlrl-remove.action?vlrl.id=" + $scope.vlrl.id;

            $http.get(url).success(function(data) {
                $scope.actionErrors = data.actionErrors;

                if (data.actionErrors.length == 0) {
                    window.history.back();
                }
            });
        }
    }

    pageTitleService.setTitle("vlrl", "page_detail");
}

function vlrlEditController($scope, $http, $location, $routeParams, pageTitleService) {
    var url = "facturacion/vlrl-edit.action?vlrl.id=" + $routeParams.vlrlId;

    $http.get(url).success(function(data) {
        $scope.vlrl = data.vlrl;
        $scope.accion = data.accion;
    });

    $scope.save = function() {
        var url = "facturacion/vlrl-save.action";

        $http.post(url, {
            vlrl : $scope.vlrl,
            accion : $scope.accion
        }).success(function(data) {
            $scope.actionErrors = data.actionErrors;

            if (data.actionErrors.length == 0) {
                setTimeout(function() {
                    window.history.back();
                }, 0);
            }
        });
    }

    $scope.cancel = function() {
        window.history.back();
    }

    pageTitleService.setTitle("vlrl", "page_edit");
}

function vlrdDetailController($scope, $http, $location, $routeParams, pageTitleService) {
    var url = "facturacion/vlrd-detail.action?vlrd.id=" + $routeParams.vlrdId;

    $http.get(url).success(function(data) {
        $scope.vlrd = data.vlrd;
    });

    pageTitleService.setTitle("vlrl", "page_edit");
}

function crgoGridController($http, $location, $routeParams, $modal, pageTitleService) {
    var vm = this;

    vm.pageChanged = pageChanged;
    vm.filter = filter;

    vm.crgoCriterio = {};

    function search(crgoCriterio, page, limit) {
        $http.post("facturacion/crgo-list.action", {
            crgoCriterio : crgoCriterio,
            page : page,
            limit : limit
        }).success(function(data) {
            vm.actionErrors = data.actionErrors;

            if (data.actionErrors.length == 0) {
                vm.page = data.crgoList.page;
                vm.crgoList = data.crgoList;
                vm.crgoCriterio = data.crgoCriterio;

                var map = {};

                map["page"] = data.crgoList.page;

                $location.search(map).replace();
            }
        });
    }

    function pageChanged() {
        search($scope.crgoCriterio, $scope.page, $scope.limit);
    }

    function filter(size) {
        var modalInstance = $modal.open({
            templateUrl : 'modules/facturacion/crgo-filter-content.html',
            controller : 'crgoFilterController',
            controllerAs : 'vm',
            size : size,
            resolve : {
                crgoCriterio : function() {
                    return vm.crgoCriterio;
                }
            }
        });

        modalInstance.result.then(function(crgoCriterio) {
            vm.crgoCriterio = crgoCriterio;

            search(vm.crgoCriterio, 1, vm.limit);
        });
    }

    search(vm.crgoCriterio, $routeParams.page ? $routeParams.page : 1, vm.limit);

    pageTitleService.setTitle("crgo", "page_grid");
}

function crgoFilterController($http, $modalInstance, crgoCriterio, pageTitleService) {
    var vm = this;

    vm.ok = ok;
    vm.cancel = cancel;

    function ok() {
        $modalInstance.close(vm.crgoCriterio);
    }

    function cancel() {
        $modalInstance.dismiss('cancel');
    }

    vm.crgoCriterio = crgoCriterio;

    $http.get("metamodelo/enti-lv-list.action?entiCriterio.tipo=T").success(function(data) {
        vm.entiList = data.lvList;
    });
}

function crgoDetailController($scope, $http, $location, $routeParams, pageTitleService) {
    var url = "facturacion/crgo-detail.action";

    if ($routeParams.fechaVigencia) {
        $scope.fechaVigencia = $routeParams.fechaVigencia;
        url += "?crgo.id=" + $routeParams.crgoId + "&fechaVigencia=" + $routeParams.fechaVigencia;
    } else {
        url += "?crgo.crgv.id=" + $routeParams.crgvId;
    }

    $http.get(url).success(function(data) {
        $scope.crgo = data.crgo;
        $scope.rglaList = data.rglaList;
        $scope.fechaVigencia = data.fechaVigencia;
    });

    $scope.remove = function() {
        if (confirm("Are you sure?")) {
            var url = "facturacion/crgo-remove.action?crgo.crgv.id=" + $scope.crgo.crgv.id;

            $http.get(url).success(function(data) {
                $scope.actionErrors = data.actionErrors;

                if (data.actionErrors.length == 0) {
                    window.history.back();
                }
            });
        }
    }

    pageTitleService.setTitle("crgo", "page_detail");
}

function crgoCreateController($scope, $http, $location, $routeParams, pageTitleService) {
    var url = "facturacion/crgo-create.action";

    $http.get(url).success(function(data) {
        $scope.crgo = data.crgo;
        $scope.tipos = data.tipos;
        $scope.accion = data.accion;
    });

    var urlEntiList = "metamodelo/enti-lv-list.action?entiCriterio.tipo=T";

    $http.get(urlEntiList).success(function(data) {
        $scope.entiList = data.lvList;
    });

    $scope.save = function() {
        var url = "facturacion/crgo-save.action";

        $http.post(url, {
            crgo : $scope.crgo,
            accion : $scope.accion
        }).success(function(data) {
            $scope.actionErrors = data.actionErrors;

            if (data.actionErrors.length == 0) {
                $location.path("/facturacion/crgo/detail/" + data.crgo.crgv.id).replace();
            }
        });
    }

    $scope.cancel = function() {
        window.history.back();
    }

    pageTitleService.setTitle("crgo", "page_create");
}

function crgoEditController($scope, $http, $location, $routeParams, pageTitleService) {
    var url = "facturacion/crgo-edit.action?crgo.crgv.id=" + $routeParams.crgvId;

    $http.get(url).success(function(data) {
        $scope.crgo = data.crgo;
        $scope.tipos = data.tipos;
        $scope.accion = data.accion;
    });

    $scope.save = function() {
        var url = "facturacion/crgo-save.action";

        $http.post(url, {
            crgo : $scope.crgo,
            accion : $scope.accion
        }).success(function(data) {
            $scope.actionErrors = data.actionErrors;

            if (data.actionErrors.length == 0) {
                setTimeout(function() {
                    window.history.back();
                }, 0);
            }
        });
    }

    $scope.cancel = function() {
        window.history.back();
    }

    pageTitleService.setTitle("crgo", "page_edit");
}

function rglaDetailController($scope, $http, $location, $routeParams, pageTitleService) {
    var url = "facturacion/rgla-detail.action";

    if ($routeParams.fechaVigencia) {
        $scope.fechaVigencia = $routeParams.fechaVigencia;
        url += "?rgla.id=" + $routeParams.rglaId + "&fechaVigencia=" + $routeParams.fechaVigencia;
    } else {
        url += "?rgla.rglv.id=" + $routeParams.rglvId;
    }

    $http.get(url).success(function(data) {
        $scope.rgla = data.rgla;
        $scope.rginList = data.rginList;
        $scope.fechaVigencia = data.fechaVigencia;
    });

    $scope.remove = function() {
        if (confirm("Are you sure?")) {
            var url = "facturacion/rgla-remove.action?rgla.rglv.id=" + $scope.rgla.rglv.id;

            $http.get(url).success(function(data) {
                $scope.actionErrors = data.actionErrors;

                if (data.actionErrors.length == 0) {
                    window.history.back();
                }
            });
        }
    }

    pageTitleService.setTitle("rgla", "page_detail");
}

function rglaEditController($scope, $http, $location, $routeParams, pageTitleService) {
    var url = "facturacion/rgla-edit.action?rgla.rglv.id=" + $routeParams.rglvId;

    $http.get(url).success(function(data) {
        $scope.rgla = data.rgla;
        $scope.tipos = data.tipos;
        $scope.entiFacturableList = data.entiFacturableList;
        $scope.accion = data.accion;
    });

    $scope.save = function() {
        var url = "facturacion/rgla-save.action";

        $http.post(url, {
            rgla : $scope.rgla,
            accion : $scope.accion
        }).success(function(data) {
            $scope.actionErrors = data.actionErrors;

            if (data.actionErrors.length == 0) {
                setTimeout(function() {
                    window.history.back();
                }, 0);
            }
        });
    }

    $scope.cancel = function() {
        window.history.back();
    }

    pageTitleService.setTitle("rgla", "page_edit");
}

function rglaCreateController($scope, $http, $location, $routeParams, pageTitleService) {
    var url = "facturacion/rgla-create.action?rgla.crgo.crgv.id=" + $routeParams.crgvId;

    $http.get(url).success(function(data) {
        $scope.rgla = data.rgla;
        $scope.tipos = data.tipos;
        $scope.entiFacturableList = data.entiFacturableList;
        $scope.accion = data.accion;
    });

    $scope.save = function() {
        var url = "facturacion/rgla-save.action";

        $http.post(url, {
            rgla : $scope.rgla,
            accion : $scope.accion
        }).success(function(data) {
            $scope.actionErrors = data.actionErrors;

            if (data.actionErrors.length == 0) {
                $location.path("/facturacion/rgla/detail/" + data.rgla.rglv.id).replace();
            }
        });
    }

    $scope.cancel = function() {
        window.history.back();
    }

    pageTitleService.setTitle("rgla", "page_create");
}

function rginDetailController($scope, $http, $location, $routeParams, pageTitleService) {
    var url = "facturacion/rgin-detail.action";

    if ($routeParams.fechaVigencia) {
        url += "?rgin.id=" + $routeParams.rginId + "&fechaVigencia=" + $routeParams.fechaVigencia;
    } else {
        url += "?rgin.rgiv.id=" + $routeParams.rgivId;
    }

    $http.get(url).success(function(data) {
        $scope.rgin = data.rgin;
        $scope.fechaVigencia = data.fechaVigencia;
    });

    $scope.remove = function() {
        if (confirm("Are you sure?")) {
            var url = "facturacion/rgin-remove.action?rgin.rgiv.id=" + $scope.rgin.rgiv.id;

            $http.get(url).success(function(data) {
                $scope.actionErrors = data.actionErrors;

                if (data.actionErrors.length == 0) {
                    window.history.back();
                }
            });
        }
    }

    pageTitleService.setTitle("rgin", "page_detail");
}

function rginEditController($scope, $http, $location, $routeParams, pageTitleService) {
    var url = "facturacion/rgin-edit.action?rgin.rgiv.id=" + $routeParams.rgivId;

    $http.get(url).success(function(data) {
        $scope.rgin = data.rgin;
        $scope.accion = data.accion;
    });

    $scope.save = function() {
        var url = "facturacion/rgin-save.action";

        $http.post(url, {
            rgin : $scope.rgin,
            accion : $scope.accion
        }).success(function(data) {
            $scope.actionErrors = data.actionErrors;

            if (data.actionErrors.length == 0) {
                setTimeout(function() {
                    window.history.back();
                }, 0);
            }
        });
    }

    $scope.cancel = function() {
        window.history.back();
    }

    pageTitleService.setTitle("rgin", "page_edit");
}

function rginCreateController($scope, $http, $location, $routeParams, pageTitleService) {
    var url = "facturacion/rgin-create.action?rgin.rgla1Id=" + $routeParams.rglaId + "&rgin.rgla2.crgo.id="
            + $routeParams.crgoId;

    $http.get(url).success(function(data) {
        $scope.rgin = data.rgin;
        $scope.accion = data.accion;
        $scope.rgla2List = data.rgla2List;
    });

    $scope.save = function() {
        var url = "facturacion/rgin-save.action";

        $http.post(url, {
            rgin : $scope.rgin,
            accion : $scope.accion
        }).success(function(data) {
            $scope.actionErrors = data.actionErrors;

            if (data.actionErrors.length == 0) {
                $location.path("/facturacion/rgin/detail/" + data.rgin.rgiv.id).replace();
            }
        });
    }

    $scope.cancel = function() {
        window.history.back();
    }

    pageTitleService.setTitle("rgin", "page_create");
}

function aspcGridController($http, $location, $routeParams, $modal, pageTitleService) {
    var vm = this;

    vm.pageChanged = pageChanged;
    vm.filter = filter;

    vm.aspcCriterio = {};

    function search(aspcCriterio, page, limit) {
        $http.post("facturacion/aspc-list.action", {
            aspcCriterio : aspcCriterio,
            page : page,
            limit : limit
        }).success(function(data) {
            vm.actionErrors = data.actionErrors;

            if (data.actionErrors.length == 0) {
                vm.page = data.aspcList.page;
                vm.aspcList = data.aspcList;
                vm.aspcCriterio = data.aspcCriterio;

                var map = {};

                map["page"] = data.aspcList.page;

                $location.search(map).replace();
            }
        });
    }

    function pageChanged() {
        search(vm.aspcCriterio, vm.page, vm.limit);
    }

    function filter(size) {
        var modalInstance = $modal.open({
            templateUrl : 'modules/facturacion/aspc-filter-content.html',
            controller : 'aspcFilterController',
            controllerAs : 'vm',
            size : size,
            resolve : {
                aspcCriterio : function() {
                    return vm.aspcCriterio;
                }
            }
        });

        modalInstance.result.then(function(aspcCriterio) {
            vm.aspcCriterio = aspcCriterio;

            search(vm.aspcCriterio, 1, vm.limit);
        });
    }

    search(vm.aspcCriterio, $routeParams.page ? $routeParams.page : 1, vm.limit);

    pageTitleService.setTitle("aspc", "page_grid");
}

function aspcFilterController($http, $modalInstance, aspcCriterio, pageTitleService) {
    var vm = this;

    vm.ok = ok;
    vm.cancel = cancel;

    function ok() {
        $modalInstance.close(vm.aspcCriterio);
    }

    function cancel() {
        $modalInstance.dismiss('cancel');
    }

    vm.aspcCriterio = aspcCriterio;

    $http.get("metamodelo/enti-lv-list.action?entiCriterio.tipo=T").success(function(data) {
        vm.entiList = data.lvList;
    });
}

function aspcDetailController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.remove = remove;

    function remove() {
        if (confirm("Are you sure?")) {
            $http.get("facturacion/aspc-remove.action?aspc.aspv.id=" + vm.aspc.aspv.id).success(function(data) {
                vm.actionErrors = data.actionErrors;

                if (data.actionErrors.length == 0) {
                    window.history.back();
                }
            });
        }
    }

    $http.get(
            "facturacion/aspc-detail.action?aspc.id=" + $routeParams.aspcId + "&fechaVigencia="
                    + $routeParams.fechaVigencia).success(function(data) {
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
            vm.actionErrors = data.actionErrors;

            if (data.actionErrors.length == 0) {
                $location.path("/facturacion/aspc/detail/" + data.aspc.aspv.id).replace();
            }
        });
    }

    function cancel() {
        window.history.back();
    }

    $http.get("facturacion/aspc-create.action").success(function(data) {
        vm.aspc = data.aspc;
        vm.accion = data.accion;
    });

    $http.get("metamodelo/enti-lv-list.action?entiCriterio.tipo=T").success(function(data) {
        vm.entiTpsrList = data.lvList;
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
            vm.actionErrors = data.actionErrors;

            if (data.actionErrors.length == 0) {
                setTimeout(function() {
                    window.history.back();
                }, 0);
            }
        });
    }

    function cancel() {
        window.history.back();
    }

    $http.get("facturacion/aspc-edit.action?aspc.aspv.id=" + $routeParams.aspvId).success(function(data) {
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
            vm.actionErrors = data.actionErrors;

            if (data.actionErrors.length == 0) {
                $location.path("/facturacion/aspc/detail/" + data.aspc.aspv.id).replace();
            }
        });
    }

    function cancel() {
        window.history.back();
    }

    $http.get("facturacion/aspc-duplicate.action?aspc.aspv.id=" + $routeParams.aspvId).success(function(data) {
        vm.aspc = data.aspc;
        vm.i18nMap = data.i18nMap;
        vm.accion = data.accion;
    });

    pageTitleService.setTitle("aspc", "page_duplicate");
}

function ascrCreateController($scope, $http, $location, $routeParams, pageTitleService) {
    var url = "facturacion/ascr-create.action?ascr.aspcId=" + $routeParams.aspcId + "&fechaVigencia="
            + $routeParams.fechaVigencia;

    $http.get(url).success(function(data) {
        $scope.ascr = data.ascr;
        $scope.crgoList = data.crgoList;
        $scope.accion = data.accion;
    });

    $scope.save = function() {
        var url = "facturacion/ascr-save.action";

        $http.post(url, {
            ascr : $scope.ascr,
            accion : $scope.accion
        }).success(function(data) {
            $scope.actionErrors = data.actionErrors;

            if (data.actionErrors.length == 0) {
                $location.path("/facturacion/ascr/detail/" + data.ascr.id + "/" + data.ascr.ascv.fini).replace();
            }
        });
    }

    $scope.cancel = function() {
        window.history.back();
    }

    pageTitleService.setTitle("ascr", "page_create");
}

function ascrDetailController($scope, $http, $routeParams, pageTitleService) {
    $scope.fechaVigencia = $routeParams.fechaVigencia;

    var url = "facturacion/ascr-detail.action?ascr.id=" + $routeParams.ascrId + "&fechaVigencia="
            + $routeParams.fechaVigencia;

    $http.get(url).success(function(data) {
        $scope.ascr = data.ascr;
        $scope.fechaVigencia = data.fechaVigencia;
    });

    $scope.remove = function() {
        if (confirm("Are you sure?")) {
            var url = "facturacion/ascr-remove.action?ascr.ascv.id=" + $scope.ascr.ascv.id;

            $http.get(url).success(function(data) {
                $scope.actionErrors = data.actionErrors;

                if (data.actionErrors.length == 0) {
                    window.history.back();
                }
            });
        }
    }

    pageTitleService.setTitle("ascr", "page_detail");
}

function ascrEditController($scope, $http, $routeParams, pageTitleService) {
    var url = "facturacion/ascr-edit.action?ascr.ascv.id=" + $routeParams.ascvId;

    $http.get(url).success(function(data) {
        $scope.ascr = data.ascr;
        $scope.accion = data.accion;
    });

    $scope.save = function() {
        var url = "facturacion/ascr-save.action";

        $http.post(url, {
            ascr : $scope.ascr,
            accion : $scope.accion
        }).success(function(data) {
            $scope.actionErrors = data.actionErrors;

            if (data.actionErrors.length == 0) {
                setTimeout(function() {
                    window.history.back();
                }, 0);
            }
        });
    }

    $scope.cancel = function() {
        window.history.back();
    }

    pageTitleService.setTitle("ascr", "page_edit");
}