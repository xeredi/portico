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

// ----------- CARGO ------------------
// ----------- CARGO ------------------
// ----------- CARGO ------------------

facturacion.config([ "$routeProvider", function($routeProvider) {
    $routeProvider

    .when("/facturacion/crgo", {
        templateUrl : "modules/facturacion/crgo-filter.html",
        controller : "crgoFilterController"
    })

    .when("/facturacion/crgo/grid", {
        templateUrl : "modules/facturacion/crgo-grid.html",
        controller : "crgoGridController"
    })

    .when("/facturacion/crgo/detail/:crgoId/:fechaVigencia", {
        templateUrl : "modules/facturacion/crgo-detail.html",
        controller : "crgoDetailController"
    })

    .when("/facturacion/crgv/detail/:crgvId", {
        templateUrl : "modules/facturacion/crgo-detail.html",
        controller : "crgvDetailController"
    })

    .when("/facturacion/crgv/edit/:crgvId", {
        templateUrl : "modules/facturacion/crgo-edit.html",
        controller : "crgvEditController"
    })

    .when("/facturacion/crgo/create", {
        templateUrl : "modules/facturacion/crgo-edit.html",
        controller : "crgoCreateController"
    })
} ]);

facturacion.controller("crgoFilterController", function($scope, $http, $location) {
    var url = "facturacion/crgo-filter.action";

    $http.get(url).success(function(data) {
        $scope.crgoCriterio = data.crgoCriterio;
    });

    var urlEntiList = "metamodelo/enti-lv-list.action?entiCriterio.tipo=T";

    $http.get(urlEntiList).success(function(data) {
        $scope.entiList = data.lvList;
    });

    $scope.submit = function() {
        $location.path("/facturacion/crgo/grid").search({
            crgoCriterio : $scope.crgoCriterio,
            page : $scope.page
        });
    }

    $scope.page = 1;
    $scope.limit = 20;
});

facturacion.controller("crgoGridController", function($scope, $http, $location, $route, $routeParams) {
    $scope.vlrcCriterio = $routeParams.crgoCriterio;
    $scope.page = $routeParams.page;

    var url = "facturacion/crgo-list.action";

    $http.get(url, {
        crgoCriterio : $scope.crgoCriterio,
        limit : $scope.limit,
        page : $scope.page
    }).success(function(data) {
        $scope.crgoList = data.crgoList;
    });
});

facturacion.controller("crgoDetailController", function($scope, $http, $location, $route, $routeParams) {
    $scope.fechaVigencia = $routeParams.fechaVigencia;

    var url = "facturacion/crgo-detail.action?crgo.id=" + $routeParams.crgoId + "&fechaVigencia="
            + $routeParams.fechaVigencia;

    $http.get(url).success(function(data) {
        $scope.crgo = data.crgo;
    });

    var urlRglaList = "facturacion/rgla-list.action?rglaCriterio.crgoId=" + $routeParams.crgoId
            + "&rglaCriterio.fechaVigencia=" + $routeParams.fechaVigencia;

    $http.get(urlRglaList).success(function(data) {
        $scope.rglaList = data.rglaList;
    });
});

facturacion.controller("crgvDetailController", function($scope, $http, $location, $route, $routeParams) {
    var url = "facturacion/crgo-detail.action?crgo.crgv.id=" + $routeParams.crgvId;

    $http.get(url).success(function(data) {
        $scope.crgo = data.crgo;
    });

    var urlRglaList = "facturacion/rgla-list.action?rglaCriterio.crgvId=" + $routeParams.crgvId;

    $http.get(urlRglaList).success(function(data) {
        $scope.rglaList = data.rglaList;
    });
});

facturacion.controller("crgvEditController", function($scope, $http, $location, $route, $routeParams) {
    var url = "facturacion/crgo-edit.action?crgo.crgv.id=" + $routeParams.crgvId;

    $http.get(url).success(function(data) {
        $scope.crgo = data.crgo;
        $scope.tipos = data.tipos;
        $scope.accion = data.accion;
    });
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
});

// ----------- REGLA ------------------
// ----------- REGLA ------------------
// ----------- REGLA ------------------

facturacion.config([ "$routeProvider", function($routeProvider) {
    $routeProvider

    .when("/facturacion/rgla/detail/:rglaId/:fechaVigencia", {
        templateUrl : "modules/facturacion/rgla-detail.html",
        controller : "rglaDetailController"
    })

    .when("/facturacion/rglv/detail/:rglvId", {
        templateUrl : "modules/facturacion/rgla-detail.html",
        controller : "rglvDetailController"
    })

    .when("/facturacion/rglv/edit/:rglvId", {
        templateUrl : "modules/facturacion/rgla-edit.html",
        controller : "rglvEditController"
    })

    .when("/facturacion/rgla/create", {
        templateUrl : "modules/facturacion/rgla-edit.html",
        controller : "crgoCreateController"
    })
} ]);

facturacion.controller("rglaDetailController", function($scope, $http, $location, $route, $routeParams) {
    $scope.fechaVigencia = $routeParams.fechaVigencia;

    var url = "facturacion/rgla-detail.action?rgla.id=" + $routeParams.rglaId + "&fechaVigencia="
            + $routeParams.fechaVigencia;

    $http.get(url).success(function(data) {
        $scope.rgla = data.rgla;
    });

    var urlRginList = "facturacion/rgin-list.action?rginCriterio.rgla1Id=" + $routeParams.rglaId
            + "&rginCriterio.fechaVigencia=" + $routeParams.fechaVigencia;

    $http.get(urlRginList).success(function(data) {
        $scope.rginList = data.rginList;
    });
});

facturacion.controller("rglvDetailController", function($scope, $http, $location, $route, $routeParams) {
    var url = "facturacion/rgla-detail.action?rgla.rglv.id=" + $routeParams.rglvId;

    $http.get(url).success(function(data) {
        $scope.rgla = data.rgla;
    });
});

facturacion.controller("rglvEditController", function($scope, $http, $location, $route, $routeParams) {
    var url = "facturacion/rgla-edit.action?rgla.rglv.id=" + $routeParams.rglvId;

    $http.get(url).success(function(data) {
        $scope.rgla = data.rgla;
        $scope.accion = data.accion;
    });
});

facturacion.controller("rglaCreateController", function($scope, $http, $location, $route, $routeParams) {
    var url = "facturacion/rgla-create.action";

    $http.get(url).success(function(data) {
        $scope.rgla = data.rgla;
        $scope.accion = data.accion;
    });
});

// ----------- ASPECTO ------------------
// ----------- ASPECTO ------------------
// ----------- ASPECTO ------------------

facturacion.config([ "$routeProvider", function($routeProvider) {
    $routeProvider

    .when("/facturacion/aspc/filter", {
        templateUrl : "modules/facturacion/aspc-filter.html",
        controller : "aspcFilterController"
    })

    .when("/facturacion/aspc/list", {
        templateUrl : "modules/facturacion/aspc-grid.html",
        controller : "aspcListController"
    })

    .when("/facturacion/aspc/create", {
        templateUrl : "modules/facturacion/aspc-edit.html",
        controller : "aspcCreateController"
    })

    .when("/facturacion/aspv/detail/:aspvId", {
        templateUrl : "modules/facturacion/aspc.html",
        controller : "aspcDetailController"
    })

    .when("/facturacion/aspv/edit/:aspvId", {
        templateUrl : "modules/facturacion/aspc-edit.html",
        controller : "aspcEditController"
    })

    .when("/facturacion/aspv/duplicate/:aspvId", {
        templateUrl : "modules/facturacion/aspc-edit.html",
        controller : "aspcDuplicateController"
    })

    .when("/facturacion/aspc/detail/:aspcId/:fechaVigencia", {
        templateUrl : "modules/facturacion/aspc.html",
        controller : "aspcDetailController"
    })
} ]);

facturacion.controller("aspcFilterController", function($scope, $http, $location, $route, $routeParams) {
    $scope.aspcCriterio = {};
    $scope.limit = 20;
    $scope.page = 1;

    var urlEntiList = "metamodelo/enti-lv-list.action?entiCriterio.tipo=T";

    $http.get(urlEntiList).success(function(data) {
        $scope.entiList = data.lvList;
    });

    $scope.list = function() {
        $location.path("/facturacion/aspc/list").replace();
    }
});

facturacion.controller("aspcListController", function($scope, $http, $location, $route, $routeParams) {
    var url = "facturacion/aspc-list.action";

    $http.get(url, {
        aspcCriterio : $scope.aspcCriterio,
        limit : $scope.limit,
        page : $scope.page
    }).success(function(data) {
        $scope.aspcList = data.aspcList;
        $routeParams.aspcCriterio = $scope.aspcCriterio;
    });

    $scope.filter = function() {
        console.log('routeParams: ' + JSON.stringify($routeParams));
        console.log('aspcCriterio: ' + $scope.aspcCriterio);

        $scope.urlInclude = 'modules/facturacion/aspc-filter.html';
    }

    $scope.create = function() {
        $location.path("/facturacion/aspc/create");
    }
});

facturacion.controller("aspcCreateController", function($scope, $http, $location, $route, $routeParams) {
    var url = "facturacion/aspc-create.action";

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
                $location.path("/facturacion/aspv/detail/" + $scope.aspc.aspv.id).replace();
            } else {
                $scope.actionErrors = data.actionErrors;
            }
        });
    }

    $scope.cancelSave = function() {
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
        $location.path("/facturacion/aspv/edit/" + $scope.aspc.aspv.id).replace();
    }

    $scope.duplicate = function() {
        $location.path("/facturacion/aspv/duplicate/" + $scope.aspc.aspv.id);
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
                $location.path("/facturacion/aspv/detail/" + $scope.aspc.aspv.id).replace();
            } else {
                $scope.actionErrors = data.actionErrors;
            }
        });
    }

    $scope.cancelSave = function() {
        $location.path("/facturacion/aspv/detail/" + $scope.aspc.aspv.id).replace();
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
                $location.path("/facturacion/aspv/detail/" + $scope.aspc.aspv.id).replace();
            } else {
                $scope.actionErrors = data.actionErrors;
            }
        });
    }

    $scope.cancelSave = function() {
        window.history.back();
    }
});
