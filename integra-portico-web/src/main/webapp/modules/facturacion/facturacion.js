var facturacion = angular.module("facturacion", [ "ngRoute" ]);

// ----------------- MENU PRINCIPAL --------------------------
// ----------------- MENU PRINCIPAL --------------------------
// ----------------- MENU PRINCIPAL --------------------------

facturacion.config([ "$routeProvider", function($routeProvider) {
    $routeProvider

    .when("/facturacion", {
        templateUrl : "modules/facturacion/facturacion.html",
        controller : "facturacionController"
    })
} ]);

facturacion.controller("facturacionController", function($scope, $http, $location) {
});

// ----------- VALORACION ------------------
// ----------- VALORACION ------------------
// ----------- VALORACION ------------------

facturacion.config([ "$routeProvider", function($routeProvider) {
    $routeProvider

    .when("/facturacion/vlrc", {
        templateUrl : "modules/facturacion/vlrc-filter.html",
        controller : "vlrcFilterController"
    })

    .when("/facturacion/vlrc/grid", {
        templateUrl : "modules/facturacion/vlrc-grid.html",
        controller : "vlrcGridController"
    })

    .when("/facturacion/vlrc/detail/:vlrcId", {
        templateUrl : "modules/facturacion/vlrc-detail.html",
        controller : "vlrcDetailController"
    })

    .when("/facturacion/vlrc/edit/:vlrcId", {
        templateUrl : "modules/facturacion/vlrc-edit.html",
        controller : "vlrcEditController"
    })

    .when("/facturacion/vlrl/detail/:vlrlId", {
        templateUrl : "modules/facturacion/vlrl-detail.html",
        controller : "vlrlDetailController"
    })

    .when("/facturacion/vlrl/edit/:vlrlId", {
        templateUrl : "modules/facturacion/vlrl-edit.html",
        controller : "vlrlEditController"
    })

    .when("/facturacion/vlrd/detail/:vlrdId", {
        templateUrl : "modules/facturacion/vlrd-detail.html",
        controller : "vlrdDetailController"
    })

    .when("/facturacion/vlrd/edit/:vlrdId", {
        templateUrl : "modules/facturacion/vlrd-edit.html",
        controller : "vlrdEditController"
    })
} ]);

facturacion.controller("vlrcFilterController", function($scope, $http, $location) {
    $scope.submit = function() {
        $location.path("/facturacion/vlrc/grid").search({
            vlrcCriterio : {},
            page : $scope.page
        });
    }

    $scope.page = 1;
    $scope.limit = 20;
});

facturacion.controller("vlrcGridController", function($scope, $http, $location, $route, $routeParams) {
    $scope.vlrcCriterio = $routeParams.vlrcCriterio;
    $scope.page = $routeParams.page;

    var url = "facturacion/vlrc-list.action";

    $http.get(url, {
        vlrcCriterio : $scope.vlrcCriterio,
        limit : $scope.limit,
        page : $scope.page
    }).success(function(data) {
        $scope.vlrcList = data.vlrcList;
    });
});

facturacion.controller("vlrcDetailController", function($scope, $http, $location, $route, $routeParams) {
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
});

facturacion.controller("vlrlDetailController", function($scope, $http, $location, $route, $routeParams) {
    var url = "facturacion/vlrl-detail.action?vlrl.id=" + $routeParams.vlrlId;

    $http.get(url).success(function(data) {
        $scope.vlrl = data.vlrl;
    });

    var urlVlrdList = "facturacion/vlrd-list.action?vlrdCriterio.vlrl.id=" + $routeParams.vlrlId;

    $http.get(urlVlrdList).success(function(data) {
        $scope.vlrdList = data.vlrdList;
    });
});

facturacion.controller("vlrdDetailController", function($scope, $http, $location, $route, $routeParams) {
    var url = "facturacion/vlrd-detail.action?vlrd.id=" + $routeParams.vlrdId;

    $http.get(url).success(function(data) {
        $scope.vlrd = data.vlrd;
    });
});

// ----------- CARGO y REGLA------------------
// ----------- CARGO y REGLA------------------
// ----------- CARGO y REGLA------------------

facturacion.config([ "$routeProvider", function($routeProvider) {
    $routeProvider

    .when("/facturacion/crgo/grid", {
        templateUrl : "modules/facturacion/crgo-grid.html",
        controller : "crgoGridController"
    })

    .when("/facturacion/crgo/grid/:page", {
        templateUrl : "modules/facturacion/crgo-grid.html",
        controller : "crgoGridController"
    })

    .when("/facturacion/crgo/detail/:crgoId/:fechaVigencia", {
        templateUrl : "modules/facturacion/crgo-detail.html",
        controller : "crgoDetailController"
    })

    .when("/facturacion/crgo/detail/:crgvId", {
        templateUrl : "modules/facturacion/crgo-detail.html",
        controller : "crgoDetailController"
    })

    .when("/facturacion/crgo/edit/:crgvId", {
        templateUrl : "modules/facturacion/crgo-edit.html",
        controller : "crgoEditController"
    })

    .when("/facturacion/crgo/create", {
        templateUrl : "modules/facturacion/crgo-edit.html",
        controller : "crgoCreateController"
    })

    .when("/facturacion/rgla/detail/:rglaId/:fechaVigencia", {
        templateUrl : "modules/facturacion/rgla-detail.html",
        controller : "rglaDetailController"
    })

    .when("/facturacion/rgla/detail/:rglvId", {
        templateUrl : "modules/facturacion/rgla-detail.html",
        controller : "rglaDetailController"
    })

    .when("/facturacion/rgla/edit/:rglvId", {
        templateUrl : "modules/facturacion/rgla-edit.html",
        controller : "rglaEditController"
    })

    .when("/facturacion/rgla/create/:crgvId", {
        templateUrl : "modules/facturacion/rgla-edit.html",
        controller : "rglaCreateController"
    })

    .when("/facturacion/rgin/detail/:rgivId", {
        templateUrl : "modules/facturacion/rgin-detail.html",
        controller : "rginDetailController"
    })

    .when("/facturacion/rgin/edit/:rgivId", {
        templateUrl : "modules/facturacion/rgin-edit.html",
        controller : "rginEditController"
    })

    .when("/facturacion/rgin/create/:crgoId/:rglaId", {
        templateUrl : "modules/facturacion/rgin-edit.html",
        controller : "rginCreateController"
    })
} ]);

facturacion.controller("crgoGridController", function($scope, $http, $location, $route, $routeParams) {
    loaded = false;

    $scope.showFilter = false;
    $scope.page = $routeParams.page ? $routeParams.page : 1;
    $scope.limit = 20;
    $scope.crgoCriterio = $routeParams.crgoCriterio;

    var url = "facturacion/crgo-list.action";

    $http.get(url, {
        crgoCriterio : $scope.crgoCriterio,
        limit : $scope.limit,
        page : $scope.page
    }).success(function(data) {
        $scope.crgoList = data.crgoList;
        $scope.page = data.page;
        $scope.currentPage = data.page;
        $scope.limit = data.crgoList.limit;
        loaded = true;
    });

    $scope.pageChanged = function() {
        if (loaded) {
            $location.path("/facturacion/crgo/grid/" + $scope.currentPage).replace();
        }
    }

    $scope.filter = function() {
        $scope.showFilter = true;

        var urlEntiList = "metamodelo/enti-lv-list.action?entiCriterio.tipo=T";

        $http.get(urlEntiList).success(function(data) {
            $scope.entiList = data.lvList;
        });
    }

    $scope.search = function() {
        $location.path("/facturacion/crgo/grid").search({
            crgoCriterio : {},
            page : 1
        }).replace();
    }

    $scope.cancelSearch = function() {
        $scope.showFilter = false;
    }
});

facturacion.controller("crgoCreateController", function($scope, $http, $location, $route, $routeParams) {
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
            if (data.actionErrors.length == 0) {
                $location.path("/facturacion/crgo/detail/" + data.crgo.crgv.id).replace();
            } else {
                $scope.actionErrors = data.actionErrors;
            }
        });
    }

    $scope.cancel = function() {
        window.history.back();
    }
});

facturacion.controller("crgoDetailController", function($scope, $http, $location, $route, $routeParams) {
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
    });

    $scope.edit = function() {
        $location.path("/facturacion/crgo/edit/" + $scope.crgo.crgv.id).replace();
    }

    $scope.remove = function() {
        bootbox.confirm("Are you sure?", function(result) {
            if (result) {
                var url = "facturacion/crgo-remove.action?crgo.crgv.id=" + $scope.crgo.crgv.id;

                $http.get(url).success(function(data) {
                    if (data.actionErrors.length == 0) {
                        window.history.back();
                    } else {
                        $scope.actionErrors = data.actionErrors;
                    }
                });
            }
        });
    }
});

facturacion.controller("crgoEditController", function($scope, $http, $location, $route, $routeParams) {
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
            if (data.actionErrors.length == 0) {
                $location.path("/facturacion/crgo/detail/" + data.crgo.crgv.id).replace();
            } else {
                $scope.actionErrors = data.actionErrors;
            }
        });
    }

    $scope.cancel = function() {
        $location.path("/facturacion/crgo/detail/" + $scope.crgo.crgv.id).replace();
    }
});

facturacion.controller("rglaDetailController", function($scope, $http, $location, $route, $routeParams) {
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
    });

    $scope.edit = function() {
        $location.path("/facturacion/rgla/edit/" + $scope.rgla.rglv.id).replace();
    }

    $scope.remove = function() {
        bootbox.confirm("Are you sure?", function(result) {
            if (result) {
                var url = "facturacion/rgla-remove.action?rgla.rglv.id=" + $scope.rgla.rglv.id;

                $http.get(url).success(function(data) {
                    if (data.actionErrors.length == 0) {
                        window.history.back();
                    } else {
                        $scope.actionErrors = data.actionErrors;
                    }
                });
            }
        });
    }
});

facturacion.controller("rglaEditController", function($scope, $http, $location, $route, $routeParams) {
    var url = "facturacion/rgla-edit.action?rgla.rglv.id=" + $routeParams.rglvId;

    $http.get(url).success(function(data) {
        $scope.rgla = data.rgla;
        $scope.accion = data.accion;
    });

    $scope.save = function() {
        var url = "facturacion/rgla-save.action";

        $http.post(url, {
            rgla : $scope.rgla,
            accion : $scope.accion
        }).success(function(data) {
            if (data.actionErrors.length == 0) {
                $location.path("/facturacion/rgla/detail/" + data.rgla.rglv.id).replace();
            } else {
                $scope.actionErrors = data.actionErrors;
            }
        });
    }

    $scope.cancel = function() {
        $location.path("/facturacion/rgla/detail/" + $scope.rgla.rglv.id).replace();
    }
});

facturacion.controller("rglaCreateController", function($scope, $http, $location, $route, $routeParams) {
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
            if (data.actionErrors.length == 0) {
                $location.path("/facturacion/rgla/detail/" + data.rgla.rglv.id).replace();
            } else {
                $scope.actionErrors = data.actionErrors;
            }
        });
    }

    $scope.cancel = function() {
        window.history.back();
    }
});

facturacion.controller("rginDetailController", function($scope, $http, $location, $route, $routeParams) {
    var url = "facturacion/rgin-detail.action?rgin.rgiv.id=" + $routeParams.rgivId;

    $http.get(url).success(function(data) {
        $scope.rgin = data.rgin;
    });

    $scope.edit = function() {
        $location.path("/facturacion/rgin/edit/" + $scope.rgin.rgiv.id).replace();
    }

    $scope.remove = function() {
        bootbox.confirm("Are you sure?", function(result) {
            if (result) {
                var url = "facturacion/rgin-remove.action?rgin.rgiv.id=" + $scope.rgin.rgiv.id;

                $http.get(url).success(function(data) {
                    if (data.actionErrors.length == 0) {
                        window.history.back();
                    } else {
                        $scope.actionErrors = data.actionErrors;
                    }
                });
            }
        });
    }
});

facturacion.controller("rginEditController", function($scope, $http, $location, $route, $routeParams) {
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
            if (data.actionErrors.length == 0) {
                $location.path("/facturacion/rgin/detail/" + data.rgin.rgiv.id).replace();
            } else {
                $scope.actionErrors = data.actionErrors;
            }
        });
    }

    $scope.cancel = function() {
        $location.path("/facturacion/rgin/detail/" + $scope.rgin.rgiv.id).replace();
    }
});

facturacion.controller("rginCreateController", function($scope, $http, $location, $route, $routeParams) {
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
            if (data.actionErrors.length == 0) {
                $location.path("/facturacion/rgin/detail/" + data.rgin.rgiv.id).replace();
            } else {
                $scope.actionErrors = data.actionErrors;
            }
        });
    }

    $scope.cancel = function() {
        window.history.back();
    }
});

// ----------- ASPECTO ------------------
// ----------- ASPECTO ------------------
// ----------- ASPECTO ------------------

facturacion.config([ "$routeProvider", function($routeProvider) {
    $routeProvider

    .when("/facturacion/aspc/grid", {
        templateUrl : "modules/facturacion/aspc-grid.html",
        controller : "aspcGridController"
    })

    .when("/facturacion/aspc/grid/:page", {
        templateUrl : "modules/facturacion/aspc-grid.html",
        controller : "aspcGridController"
    })

    .when("/facturacion/aspc/create", {
        templateUrl : "modules/facturacion/aspc-edit.html",
        controller : "aspcCreateController"
    })

    .when("/facturacion/aspc/detail/:aspvId", {
        templateUrl : "modules/facturacion/aspc-detail.html",
        controller : "aspcDetailController"
    })

    .when("/facturacion/aspc/edit/:aspvId", {
        templateUrl : "modules/facturacion/aspc-edit.html",
        controller : "aspcEditController"
    })

    .when("/facturacion/aspc/duplicate/:aspvId", {
        templateUrl : "modules/facturacion/aspc-edit.html",
        controller : "aspcDuplicateController"
    })

    .when("/facturacion/aspc/detail/:aspcId/:fechaVigencia", {
        templateUrl : "modules/facturacion/aspc-detail.html",
        controller : "aspcDetailController"
    })
} ]);

facturacion.controller("aspcGridController", function($scope, $http, $location, $route, $routeParams) {
    loaded = false;

    $scope.showFilter = false;
    $scope.page = $routeParams.page ? $routeParams.page : 1;
    $scope.limit = 20;
    $scope.aspcCriterio = $routeParams.aspcCriterio;

    var url = "facturacion/aspc-list.action";

    $http.get(url, {
        aspcCriterio : $scope.aspcCriterio,
        limit : $scope.limit,
        page : $scope.page
    }).success(function(data) {
        $scope.aspcList = data.aspcList;
        $scope.page = data.page;
        $scope.currentPage = data.page;
        $scope.limit = data.aspcList.limit;
        loaded = true;
    });

    $scope.pageChanged = function() {
        if (loaded) {
            $location.path("/metamodelo/aspc/grid/" + $scope.currentPage).replace();
        }
    }

    $scope.filter = function() {
        $scope.showFilter = true;

        var urlEntiList = "metamodelo/enti-lv-list.action?entiCriterio.tipo=T";

        $http.get(urlEntiList).success(function(data) {
            $scope.entiList = data.lvList;
        });
    }

    $scope.search = function() {
        $location.path("/metamodelo/aspc/grid").search({
            aspcCriterio : {},
            page : 1
        }).replace();
    }

    $scope.cancelSearch = function() {
        $scope.showFilter = false;
    }
});

facturacion.controller("aspcCreateController", function($scope, $http, $location, $route, $routeParams) {
    var url = "facturacion/aspc-create.action";

    $http.get(url).success(function(data) {
        $scope.aspc = data.aspc;
        $scope.accion = data.accion;
    });

    var urlEntiTpsrList = "metamodelo/enti-lv-list.action?entiCriterio.tipo=T";

    $http.get(urlEntiTpsrList).success(function(data) {
        $scope.entiTpsrList = data.lvList;
    });

    $scope.save = function() {
        var url = "facturacion/aspc-save.action";

        $http.post(url, {
            aspc : $scope.aspc,
            accion : $scope.accion
        }).success(function(data) {
            if (data.actionErrors.length == 0) {
                $location.path("/facturacion/aspc/detail/" + data.aspc.aspv.id).replace();
            } else {
                $scope.actionErrors = data.actionErrors;
            }
        });
    }

    $scope.cancel = function() {
        window.history.back();
    }
});

facturacion.controller("aspcDetailController", function($scope, $http, $location, $route, $routeParams) {
    var url = "facturacion/aspc-detail.action?aspc.aspv.id=" + $routeParams.aspvId;

    $http.get(url).success(function(data) {
        $scope.urlInclude = 'modules/facturacion/aspc-detail.html';
        $scope.aspc = data.aspc;
    });

    $scope.edit = function() {
        $location.path("/facturacion/aspc/edit/" + $scope.aspc.aspv.id).replace();
    }

    $scope.remove = function() {
        bootbox.confirm("Are you sure?", function(result) {
            if (result) {
                var url = "facturacion/aspc-remove.action?aspc.aspv.id=" + $scope.aspc.aspv.id;

                $http.get(url).success(function(data) {
                    if (data.actionErrors.length == 0) {
                        window.history.back();
                    } else {
                        $scope.actionErrors = data.actionErrors;
                    }
                });
            }
        });
    }
});

facturacion.controller("aspcEditController", function($scope, $http, $location, $route, $routeParams) {
    var url = "facturacion/aspc-edit.action?aspc.aspv.id=" + $routeParams.aspvId;

    $http.get(url).success(function(data) {
        $scope.aspc = data.aspc;
        $scope.accion = data.accion;
    });

    $scope.save = function() {
        var url = "facturacion/aspc-save.action";

        $http.post(url, {
            aspc : $scope.aspc,
            accion : $scope.accion
        }).success(function(data) {
            if (data.actionErrors.length == 0) {
                $location.path("/facturacion/aspc/detail/" + data.aspc.aspv.id).replace();
            } else {
                $scope.actionErrors = data.actionErrors;
            }
        });
    }

    $scope.cancel = function() {
        $location.path("/facturacion/aspc/detail/" + $scope.aspc.aspv.id).replace();
    }
});

facturacion.controller("aspcDuplicateController", function($scope, $http, $location, $route, $routeParams) {
    var url = "facturacion/aspc-duplicate.action?aspc.aspv.id=" + $routeParams.aspvId;

    $http.get(url).success(function(data) {
        $scope.aspc = data.aspc;
        $scope.accion = data.accion;
    });

    $scope.save = function() {
        var url = "facturacion/aspc-save.action";

        $http.post(url, {
            aspc : $scope.aspc,
            accion : $scope.accion
        }).success(function(data) {
            if (data.actionErrors.length == 0) {
                $location.path("/facturacion/aspc/detail/" + data.aspc.aspv.id).replace();
            } else {
                $scope.actionErrors = data.actionErrors;
            }
        });
    }

    $scope.cancel = function() {
        window.history.back();
    }
});
