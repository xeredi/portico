var metamodelo = angular.module("metamodelo", [ "ngRoute" ]);

metamodelo.config([ "$routeProvider", function($routeProvider) {
    $routeProvider

    .when("/metamodelo/tpprs", {
        templateUrl : "modules/metamodelo/tppr-filter.html",
        controller : "tpprsFilterController"
    })

    .when("/metamodelo/tpprs/grid", {
        templateUrl : "modules/metamodelo/tppr-grid.html",
        controller : "tpprsGridController"
    })

    .when("/metamodelo/tpprs/detail/:entiId", {
        templateUrl : "modules/metamodelo/tppr-detail.html",
        controller : "tpprsDetailController"
    })

    .when("/metamodelo/tpprs/edit/:entiId", {
        templateUrl : "modules/metamodelo/tppr-edit.html",
        controller : "tpprsEditController"
    })

    .when("/metamodelo/tpprs/create", {
        templateUrl : "modules/metamodelo/tppr-edit.html",
        controller : "tpprsCreateController"
    })

    // ----------------- TIPO DE SERVICIO -----------------

    .when("/metamodelo/tpsrs", {
        templateUrl : "modules/metamodelo/tpsr-filter.html",
        controller : "tpsrsFilterController"
    })

    .when("/metamodelo/tpsrs/grid", {
        templateUrl : "modules/metamodelo/tpsr-grid.html",
        controller : "tpsrsGridController"
    })

    .when("/metamodelo/tpsrs/detail/:entiId", {
        templateUrl : "modules/metamodelo/tpsr-detail.html",
        controller : "tpsrsDetailController"
    })

    .when("/metamodelo/tpsrs/edit/:entiId", {
        templateUrl : "modules/metamodelo/tpsr-edit.html",
        controller : "tpsrsEditController"
    })

    .when("/metamodelo/tpsrs/create", {
        templateUrl : "modules/metamodelo/tpsr-edit.html",
        controller : "tpsrsCreateController"
    })

    .when("/metamodelo/tpsss/detail/:entiId", {
        templateUrl : "modules/metamodelo/tpss-detail.html",
        controller : "tpsssDetailController"
    })

    .when("/metamodelo/tpsss/edit/:entiId", {
        templateUrl : "modules/metamodelo/tpss-edit.html",
        controller : "tpsssEditController"
    })

    .when("/metamodelo/tpsss/create/:tpsrId", {
        templateUrl : "modules/metamodelo/tpss-edit.html",
        controller : "tpsssCreateController"
    })

    // ----------------- TIPO DE ESTADISTICA -----------------

    .when("/metamodelo/tpess", {
        templateUrl : "modules/metamodelo/tpes-filter.html",
        controller : "tpessFilterController"
    })

    .when("/metamodelo/tpess/grid", {
        templateUrl : "modules/metamodelo/tpes-grid.html",
        controller : "tpessGridController"
    })

    .when("/metamodelo/tpess/detail/:entiId", {
        templateUrl : "modules/metamodelo/tpes-detail.html",
        controller : "tpessDetailController"
    })

    .when("/metamodelo/tpess/edit/:entiId", {
        templateUrl : "modules/metamodelo/tpes-edit.html",
        controller : "tpessEditController"
    })

    .when("/metamodelo/tpess/create", {
        templateUrl : "modules/metamodelo/tpes-edit.html",
        controller : "tpessCreateController"
    })

    // ------------------ DATO DE ENTIDAD -----------------

    .when("/metamodelo/entd/detail/:entiId/:tpdtId", {
        templateUrl : "modules/metamodelo/entd-detail.html",
        controller : "entdDetailController"
    })

    .when("/metamodelo/entd/edit/:entiId/:tpdtId", {
        templateUrl : "modules/metamodelo/entd-edit.html",
        controller : "entdEditController"
    })

    .when("/metamodelo/entd/create/:entiId", {
        templateUrl : "modules/metamodelo/entd-edit.html",
        controller : "entdCreateController"
    })

    .otherwise({
        redirectTo : "/phones"
    });
} ])

// ----------------- CONTROLLERS --------------------------
// ----------------- CONTROLLERS --------------------------
// ----------------- CONTROLLERS --------------------------

// -------------------- MAESTRO ------------------

metamodelo.controller("tpprsFilterController", function($scope, $http, $location) {
    $scope.submit = function(form) {
        $location.path("/metamodelo/tpprs/grid").search({
            entiCriterio : {
                codigo : $scope.entiCriterio.codigo,
                nombre : $scope.entiCriterio.nombre
            },
            page : $scope.page
        });
    }

    $scope.page = 1;
    $scope.limit = 20;
    $scope.pageTitle = 'tppr_filter_title';
})

metamodelo.controller("tpprsGridController", function($scope, $http, $location, $route, $routeParams) {
    $scope.entiCriterio = $routeParams.entiCriterio;
    $scope.page = $routeParams.page;

    var url = "metamodelo/tppr-listado.action";

    $http.post(url, {
        entiCriterio : $scope.entiCriterio,
        limit : $scope.limit,
        page : $scope.page
    }).success(function(data) {
        $scope.entiList = data.entiList;
    });
});

metamodelo.controller("tpprsDetailController", function($scope, $http, $location, $route, $routeParams) {
    var url = "metamodelo/tppr-detalle.action?enti.id=" + $routeParams.entiId;

    $http.get(url).success(function(data) {
        $scope.enti = data.enti;
        $scope.subentiList = data.subentiList;
    });
});

metamodelo.controller("tpprsEditController", function($scope, $http, $location, $route, $routeParams) {
    var url = "metamodelo/tppr-modificar.action?enti.id=" + $routeParams.entiId;

    $http.get(url).success(function(data) {
        $scope.enti = data.enti;
        $scope.accion = data.accion;
    });

    $scope.submit = function(form) {
        var url = "metamodelo/tppr-guardar.action";

        $http.post(url, {
            enti : $scope.enti,
            accion : $scope.accion
        }).success(function(data) {
            if (data.actionErrors.length == 0) {
                $location.path("/metamodelo/tpprs/detail/" + data.enti.id);
            } else {
                $scope.actionErrors = data.actionErrors;
            }
        });
    }
});

metamodelo.controller("tpprsCreateController", function($scope, $http, $location, $route, $routeParams) {
    var url = "metamodelo/tppr-alta.action";

    $http.get(url).success(function(data) {
        $scope.enti = data.enti;
        $scope.accion = data.accion;
    });

    $scope.submit = function(form) {
        var url = "metamodelo/tppr-guardar.action";

        $http.post(url, {
            enti : $scope.enti,
            accion : $scope.accion
        }).success(function(data) {
            if (data.actionErrors.length == 0) {
                $location.path("/metamodelo/tpprs/detail/" + data.enti.id);
            } else {
                $scope.actionErrors = data.actionErrors;
            }
        });
    }
});

// -------------------- TIPO DE SERVICIO ------------------

metamodelo.controller("tpsrsFilterController", function($scope, $http, $location) {
    $scope.submit = function(form) {
        console.log("tpsrsFilterController Submit");
        console.log($scope.entiCriterio);
        console.log(JSON.stringify($scope.entiCriterio));
        console.log($scope.page);

        $location.path("/metamodelo/tpsrs/grid").search({
            entiCriterio : {
                codigo : $scope.entiCriterio.codigo,
                nombre : $scope.entiCriterio.nombre
            },
            page : $scope.page
        });
    }

    $scope.page = 1;
    $scope.limit = 20;
});

metamodelo.controller("tpsrsGridController", function($scope, $http, $location, $route, $routeParams) {
    $scope.entiCriterio = $routeParams.entiCriterio;
    $scope.page = $routeParams.page;

    console.log($scope.entiCriterio);

    var url = "metamodelo/tpsr-listado.action";

    $http.post(url, {
        entiCriterio : $scope.entiCriterio,
        limit : $scope.limit,
        page : $scope.page
    }).success(function(data) {
        $scope.entiList = data.entiList;
    });
});

metamodelo.controller("tpsrsDetailController", function($scope, $http, $location, $route, $routeParams) {
    var url = "metamodelo/tpsr-detalle.action?enti.id=" + $routeParams.entiId;

    $http.get(url).success(function(data) {
        $scope.enti = data.enti;
        $scope.subentiList = data.subentiList;
    });
});

metamodelo.controller("tpsrsEditController", function($scope, $http, $location, $route, $routeParams) {
    var url = "metamodelo/tpsr-modificar.action?enti.id=" + $routeParams.entiId;

    $http.get(url).success(function(data) {
        $scope.enti = data.enti;
        $scope.accion = data.accion;
    });

    $scope.submit = function(form) {
        var url = "metamodelo/tpsr-guardar.action";

        $http.post(url, {
            enti : $scope.enti,
            accion : $scope.accion
        }).success(function(data) {
            if (data.actionErrors.length == 0) {
                $location.path("/metamodelo/tpsrs/detail/" + data.enti.id);
            } else {
                $scope.actionErrors = data.actionErrors;
            }
        });
    }
});

metamodelo.controller("tpsrsCreateController", function($scope, $http, $location, $route, $routeParams) {
    var url = "metamodelo/tpsr-alta.action";

    $http.get(url).success(function(data) {
        $scope.enti = data.enti;
        $scope.accion = data.accion;
    });

    $scope.submit = function(form) {
        var url = "metamodelo/tpsr-guardar.action";

        $http.post(url, {
            enti : $scope.enti,
            accion : $scope.accion
        }).success(function(data) {
            if (data.actionErrors.length == 0) {
                $location.path("/metamodelo/tpsrs/detail/" + data.enti.id);
            } else {
                $scope.actionErrors = data.actionErrors;
            }
        });
    }
});

metamodelo.controller("tpsssDetailController", function($scope, $http, $location, $route, $routeParams) {
    var url = "metamodelo/tpss-detalle.action?enti.id=" + $routeParams.entiId;

    $http.get(url).success(function(data) {
        $scope.enti = data.enti;
        $scope.entiHijasList = data.entiHijasList;
        $scope.entiPadresList = data.entiPadresList;
    });
});

metamodelo.controller("tpsssEditController", function($scope, $http, $location, $route, $routeParams) {
    var url = "metamodelo/tpss-modificar.action?enti.id=" + $routeParams.entiId;

    $http.get(url).success(function(data) {
        $scope.enti = data.enti;
        $scope.accion = data.accion;
    });

    $scope.submit = function(form) {
        var url = "metamodelo/tpss-guardar.action";

        $http.post(url, {
            enti : $scope.enti,
            accion : $scope.accion
        }).success(function(data) {
            if (data.actionErrors.length == 0) {
                $location.path("/metamodelo/tpsss/detail/" + data.enti.id);
            } else {
                $scope.actionErrors = data.actionErrors;
            }
        });
    }
});

metamodelo.controller("tpsssCreateController", function($scope, $http, $location, $route, $routeParams) {
    var url = "metamodelo/tpss-alta.action?enti.tpsr.id=" + $routeParams.tpsrId;

    $http.get(url).success(function(data) {
        $scope.enti = data.enti;
        $scope.accion = data.accion;
    });

    $scope.submit = function(form) {
        var url = "metamodelo/tpss-guardar.action";

        $http.post(url, {
            enti : $scope.enti,
            accion : $scope.accion
        }).success(function(data) {
            if (data.actionErrors.length == 0) {
                $location.path("/metamodelo/tpsss/detail/" + data.enti.id);
            } else {
                $scope.actionErrors = data.actionErrors;
            }
        });
    }
});

// -------------------- ESTADISTICA ------------------

metamodelo.controller("tpessFilterController", function($scope, $http, $location) {
    $scope.submit = function(form) {
        console.log("tpessFilterController Submit");

        $location.path("/metamodelo/tpess/grid").search({
            entiCriterio : {
                codigo : $scope.entiCriterio.codigo,
                nombre : $scope.entiCriterio.nombre
            },
            page : $scope.page
        });
    }

    $scope.page = 1;
    $scope.limit = 20;
});

metamodelo.controller("tpessGridController", function($scope, $http, $location, $route, $routeParams) {
    $scope.entiCriterio = $routeParams.entiCriterio;
    $scope.page = $routeParams.page;

    var url = "metamodelo/tpes-listado.action";

    $http.post(url, {
        entiCriterio : $scope.entiCriterio,
        limit : $scope.limit,
        page : $scope.page
    }).success(function(data) {
        $scope.entiList = data.entiList;
    });
});

metamodelo.controller("tpessDetailController", function($scope, $http, $location, $route, $routeParams) {
    var url = "metamodelo/tpes-detalle.action?enti.id=" + $routeParams.entiId;

    $http.get(url).success(function(data) {
        $scope.enti = data.enti;
        $scope.subentiList = data.subentiList;
    });
});

metamodelo.controller("tpessEditController", function($scope, $http, $location, $route, $routeParams) {
    var url = "metamodelo/tpes-modificar.action?enti.id=" + $routeParams.entiId;

    $http.get(url).success(function(data) {
        $scope.enti = data.enti;
        $scope.accion = data.accion;
    });

    $scope.submit = function(form) {
        var url = "metamodelo/tpes-guardar.action";

        $http.post(url, {
            enti : $scope.enti,
            accion : $scope.accion
        }).success(function(data) {
            if (data.actionErrors.length == 0) {
                $location.path("/metamodelo/tpess/detail/" + data.enti.id);
            } else {
                $scope.actionErrors = data.actionErrors;
            }
        });
    }
});

metamodelo.controller("tpessCreateController", function($scope, $http, $location, $route, $routeParams) {
    var url = "metamodelo/tpes-alta.action";

    $http.get(url).success(function(data) {
        $scope.enti = data.enti;
        $scope.accion = data.accion;
    });

    $scope.submit = function(form) {
        var url = "metamodelo/tpes-guardar.action";

        $http.post(url, {
            enti : $scope.enti,
            accion : $scope.accion
        }).success(function(data) {
            if (data.actionErrors.length == 0) {
                $location.path("/metamodelo/tpess/detail/" + data.enti.id);
            } else {
                $scope.actionErrors = data.actionErrors;
            }
        });
    }
});

// ------------------- DATO DE ENTIDAD --------------------

metamodelo.controller("entdDetailController", function($scope, $http, $location, $route, $routeParams) {
    var url = "metamodelo/entd-detalle.action?entd.entiId=" + $routeParams.entiId + "&entd.tpdt.id="
            + $routeParams.tpdtId;

    $http.get(url).success(function(data) {
        $scope.entd = data.entd;
    });
});

metamodelo.controller("entdEditController", function($scope, $http, $location, $route, $routeParams) {
    var url = "metamodelo/entd-modificar.action?entd.entiId=" + $routeParams.entiId + "&entd.tpdt.id="
            + $routeParams.tpdtId;

    $http.get(url).success(function(data) {
        $scope.entd = data.entd;
        $scope.accion = data.accion;
    });
});

metamodelo.controller("entdCreateController", function($scope, $http, $location, $route, $routeParams) {
    var url = "metamodelo/entd-alta.action?entd.entiId=" + $routeParams.entiId;

    $http.get(url).success(function(data) {
        $scope.entd = data.entd;
        $scope.accion = data.accion;
    });

    var urlTpdt = "metamodelo/tpdt-lv-list.action";

    $http.get(urlTpdt).success(function(data) {
        $scope.tpdtList = data.lvList;
    });
});
