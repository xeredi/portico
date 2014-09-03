var metamodelo = angular.module("metamodelo", [ "ngRoute" ]);

metamodelo.config([ "$routeProvider", function($routeProvider) {
    $routeProvider

    // ----------- MAESTRO ------------------

    .when("/metamodelo/tppr", {
        templateUrl : "modules/metamodelo/tppr-filter.html",
        controller : "tpprFilterController"
    })

    .when("/metamodelo/tppr/grid", {
        templateUrl : "modules/metamodelo/tppr-grid.html",
        controller : "tpprGridController"
    })

    .when("/metamodelo/tppr/detail/:entiId", {
        templateUrl : "modules/metamodelo/tppr-detail.html",
        controller : "tpprDetailController"
    })

    .when("/metamodelo/tppr/edit/:entiId", {
        templateUrl : "modules/metamodelo/tppr-edit.html",
        controller : "tpprEditController"
    })

    .when("/metamodelo/tppr/create", {
        templateUrl : "modules/metamodelo/tppr-edit.html",
        controller : "tpprCreateController"
    })

    .when("/metamodelo/tpsp/detail/:entiId", {
        templateUrl : "modules/metamodelo/tpsp-detail.html",
        controller : "tpspDetailController"
    })

    .when("/metamodelo/tpsp/edit/:entiId", {
        templateUrl : "modules/metamodelo/tpsp-edit.html",
        controller : "tpspEditController"
    })

    .when("/metamodelo/tpsp/create/:tpprId", {
        templateUrl : "modules/metamodelo/tpsp-edit.html",
        controller : "tpspCreateController"
    })

    // ----------------- TIPO DE SERVICIO -----------------

    .when("/metamodelo/tpsr", {
        templateUrl : "modules/metamodelo/tpsr-filter.html",
        controller : "tpsrFilterController"
    })

    .when("/metamodelo/tpsr/grid", {
        templateUrl : "modules/metamodelo/tpsr-grid.html",
        controller : "tpsrGridController"
    })

    .when("/metamodelo/tpsr/detail/:entiId", {
        templateUrl : "modules/metamodelo/tpsr-detail.html",
        controller : "tpsrDetailController"
    })

    .when("/metamodelo/tpsr/edit/:entiId", {
        templateUrl : "modules/metamodelo/tpsr-edit.html",
        controller : "tpsrEditController"
    })

    .when("/metamodelo/tpsr/create", {
        templateUrl : "modules/metamodelo/tpsr-edit.html",
        controller : "tpsrCreateController"
    })

    .when("/metamodelo/tpss/detail/:entiId", {
        templateUrl : "modules/metamodelo/tpss-detail.html",
        controller : "tpssDetailController"
    })

    .when("/metamodelo/tpss/edit/:entiId", {
        templateUrl : "modules/metamodelo/tpss-edit.html",
        controller : "tpssEditController"
    })

    .when("/metamodelo/tpss/create/:tpsrId", {
        templateUrl : "modules/metamodelo/tpss-edit.html",
        controller : "tpssCreateController"
    })

    // ----------------- TIPO DE ESTADISTICA -----------------

    .when("/metamodelo/tpes", {
        templateUrl : "modules/metamodelo/tpes-filter.html",
        controller : "tpesFilterController"
    })

    .when("/metamodelo/tpes/grid", {
        templateUrl : "modules/metamodelo/tpes-grid.html",
        controller : "tpesGridController"
    })

    .when("/metamodelo/tpes/detail/:entiId", {
        templateUrl : "modules/metamodelo/tpes-detail.html",
        controller : "tpesDetailController"
    })

    .when("/metamodelo/tpes/edit/:entiId", {
        templateUrl : "modules/metamodelo/tpes-edit.html",
        controller : "tpesEditController"
    })

    .when("/metamodelo/tpes/create", {
        templateUrl : "modules/metamodelo/tpes-edit.html",
        controller : "tpesCreateController"
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

    // ------------------ DEPENDENCIA ENTRE ENTIDADES -----------------

    .when("/metamodelo/enen/create/:entipId", {
        templateUrl : "modules/metamodelo/enen-edit.html",
        controller : "enenCreateController"
    })

    .otherwise({
        redirectTo : "/phones"
    });
} ])

// ----------------- CONTROLLERS --------------------------
// ----------------- CONTROLLERS --------------------------
// ----------------- CONTROLLERS --------------------------

// -------------------- MAESTRO ------------------

metamodelo.controller("tpprFilterController", function($scope, $http, $location) {
    $scope.submit = function(form) {
        $location.path("/metamodelo/tppr/grid").search({
            entiCriterio : {
                codigo : $scope.entiCriterio.codigo,
                nombre : $scope.entiCriterio.nombre
            },
            page : $scope.page
        });
    }

    $scope.page = 1;
    $scope.limit = 20;
})

metamodelo.controller("tpprGridController", function($scope, $http, $location, $route, $routeParams) {
    $scope.entiCriterio = $routeParams.entiCriterio;
    $scope.page = $routeParams.page;

    var url = "metamodelo/tppr-list.action";

    $http.post(url, {
        entiCriterio : $scope.entiCriterio,
        limit : $scope.limit,
        page : $scope.page
    }).success(function(data) {
        $scope.entiList = data.entiList;
    });
});

metamodelo.controller("tpprDetailController", function($scope, $http, $location, $route, $routeParams) {
    var url = "metamodelo/tppr-detail.action?enti.id=" + $routeParams.entiId;

    $http.get(url).success(function(data) {
        $scope.enti = data.enti;
        $scope.subentiList = data.subentiList;
    });
});

metamodelo.controller("tpprEditController", function($scope, $http, $location, $route, $routeParams) {
    var url = "metamodelo/tppr-edit.action?enti.id=" + $routeParams.entiId;

    $http.get(url).success(function(data) {
        $scope.enti = data.enti;
        $scope.accion = data.accion;
    });

    $scope.submit = function(form) {
        var url = "metamodelo/tppr-save.action";

        $http.post(url, {
            enti : $scope.enti,
            accion : $scope.accion
        }).success(function(data) {
            if (data.actionErrors.length == 0) {
                $location.path("/metamodelo/tppr/detail/" + data.enti.id);
            } else {
                $scope.actionErrors = data.actionErrors;
            }
        });
    }
});

metamodelo.controller("tpprCreateController", function($scope, $http, $location, $route, $routeParams) {
    var url = "metamodelo/tppr-create.action";

    $http.get(url).success(function(data) {
        $scope.enti = data.enti;
        $scope.accion = data.accion;
    });

    $scope.submit = function(form) {
        var url = "metamodelo/tppr-save.action";

        $http.post(url, {
            enti : $scope.enti,
            accion : $scope.accion
        }).success(function(data) {
            if (data.actionErrors.length == 0) {
                $location.path("/metamodelo/tppr/detail/" + data.enti.id);
            } else {
                $scope.actionErrors = data.actionErrors;
            }
        });
    }
});

// -------------------- TIPO DE SERVICIO ------------------

metamodelo.controller("tpsrFilterController", function($scope, $http, $location) {
    $scope.submit = function(form) {
        $location.path("/metamodelo/tpsr/grid").search({
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

metamodelo.controller("tpsrGridController", function($scope, $http, $location, $route, $routeParams) {
    $scope.entiCriterio = $routeParams.entiCriterio;
    $scope.page = $routeParams.page;

    console.log($scope.entiCriterio);

    var url = "metamodelo/tpsr-list.action";

    $http.post(url, {
        entiCriterio : $scope.entiCriterio,
        limit : $scope.limit,
        page : $scope.page
    }).success(function(data) {
        $scope.entiList = data.entiList;
    });
});

metamodelo.controller("tpsrDetailController", function($scope, $http, $location, $route, $routeParams) {
    var url = "metamodelo/tpsr-detail.action?enti.id=" + $routeParams.entiId;

    $http.get(url).success(function(data) {
        $scope.enti = data.enti;
        $scope.subentiList = data.subentiList;
        $scope.entiHijasList = data.entiHijasList;
    });
});

metamodelo.controller("tpsrEditController", function($scope, $http, $location, $route, $routeParams) {
    var url = "metamodelo/tpsr-edit.action?enti.id=" + $routeParams.entiId;

    $http.get(url).success(function(data) {
        $scope.enti = data.enti;
        $scope.accion = data.accion;
    });

    $scope.submit = function(form) {
        var url = "metamodelo/tpsr-save.action";

        $http.post(url, {
            enti : $scope.enti,
            accion : $scope.accion
        }).success(function(data) {
            if (data.actionErrors.length == 0) {
                $location.path("/metamodelo/tpsr/detail/" + data.enti.id);
            } else {
                $scope.actionErrors = data.actionErrors;
            }
        });
    }
});

metamodelo.controller("tpsrCreateController", function($scope, $http, $location, $route, $routeParams) {
    var url = "metamodelo/tpsr-create.action";

    $http.get(url).success(function(data) {
        $scope.enti = data.enti;
        $scope.accion = data.accion;
    });

    $scope.submit = function(form) {
        var url = "metamodelo/tpsr-save.action";

        $http.post(url, {
            enti : $scope.enti,
            accion : $scope.accion
        }).success(function(data) {
            if (data.actionErrors.length == 0) {
                $location.path("/metamodelo/tpsr/detail/" + data.enti.id);
            } else {
                $scope.actionErrors = data.actionErrors;
            }
        });
    }
});

metamodelo.controller("tpssDetailController", function($scope, $http, $location, $route, $routeParams) {
    var url = "metamodelo/tpss-detail.action?enti.id=" + $routeParams.entiId;

    $http.get(url).success(function(data) {
        $scope.enti = data.enti;
        $scope.entiHijasList = data.entiHijasList;
        $scope.entiPadresList = data.entiPadresList;
    });
});

metamodelo.controller("tpssEditController", function($scope, $http, $location, $route, $routeParams) {
    var url = "metamodelo/tpss-edit.action?enti.id=" + $routeParams.entiId;

    $http.get(url).success(function(data) {
        $scope.enti = data.enti;
        $scope.accion = data.accion;
    });

    $scope.submit = function(form) {
        var url = "metamodelo/tpss-save.action";

        $http.post(url, {
            enti : $scope.enti,
            accion : $scope.accion
        }).success(function(data) {
            if (data.actionErrors.length == 0) {
                $location.path("/metamodelo/tpss/detail/" + data.enti.id);
            } else {
                $scope.actionErrors = data.actionErrors;
            }
        });
    }
});

metamodelo.controller("tpssCreateController", function($scope, $http, $location, $route, $routeParams) {
    var url = "metamodelo/tpss-create.action?enti.tpsr.id=" + $routeParams.tpsrId;

    $http.get(url).success(function(data) {
        $scope.enti = data.enti;
        $scope.accion = data.accion;
    });

    $scope.submit = function(form) {
        var url = "metamodelo/tpss-save.action";

        $http.post(url, {
            enti : $scope.enti,
            accion : $scope.accion
        }).success(function(data) {
            if (data.actionErrors.length == 0) {
                $location.path("/metamodelo/tpss/detail/" + data.enti.id);
            } else {
                $scope.actionErrors = data.actionErrors;
            }
        });
    }
});

// -------------------- ESTADISTICA ------------------

metamodelo.controller("tpesFilterController", function($scope, $http, $location) {
    $scope.submit = function(form) {
        console.log("tpesFilterController Submit");

        $location.path("/metamodelo/tpes/grid").search({
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

metamodelo.controller("tpesGridController", function($scope, $http, $location, $route, $routeParams) {
    $scope.entiCriterio = $routeParams.entiCriterio;
    $scope.page = $routeParams.page;

    var url = "metamodelo/tpes-list.action";

    $http.post(url, {
        entiCriterio : $scope.entiCriterio,
        limit : $scope.limit,
        page : $scope.page
    }).success(function(data) {
        $scope.entiList = data.entiList;
    });
});

metamodelo.controller("tpesDetailController", function($scope, $http, $location, $route, $routeParams) {
    var url = "metamodelo/tpes-detail.action?enti.id=" + $routeParams.entiId;

    $http.get(url).success(function(data) {
        $scope.enti = data.enti;
        $scope.subentiList = data.subentiList;
    });
});

metamodelo.controller("tpesEditController", function($scope, $http, $location, $route, $routeParams) {
    var url = "metamodelo/tpes-edit.action?enti.id=" + $routeParams.entiId;

    $http.get(url).success(function(data) {
        $scope.enti = data.enti;
        $scope.accion = data.accion;
    });

    $scope.submit = function(form) {
        var url = "metamodelo/tpes-save.action";

        $http.post(url, {
            enti : $scope.enti,
            accion : $scope.accion
        }).success(function(data) {
            if (data.actionErrors.length == 0) {
                $location.path("/metamodelo/tpes/detail/" + data.enti.id);
            } else {
                $scope.actionErrors = data.actionErrors;
            }
        });
    }
});

metamodelo.controller("tpesCreateController", function($scope, $http, $location, $route, $routeParams) {
    var url = "metamodelo/tpes-alta.action";

    $http.get(url).success(function(data) {
        $scope.enti = data.enti;
        $scope.accion = data.accion;
    });

    $scope.submit = function(form) {
        var url = "metamodelo/tpes-save.action";

        $http.post(url, {
            enti : $scope.enti,
            accion : $scope.accion
        }).success(function(data) {
            if (data.actionErrors.length == 0) {
                $location.path("/metamodelo/tpes/detail/" + data.enti.id);
            } else {
                $scope.actionErrors = data.actionErrors;
            }
        });
    }
});

// ------------------- DATO DE ENTIDAD --------------------

metamodelo.controller("entdDetailController", function($scope, $http, $location, $route, $routeParams) {
    var url = "metamodelo/entd-detail.action?entd.entiId=" + $routeParams.entiId + "&entd.tpdt.id="
            + $routeParams.tpdtId;

    $http.get(url).success(function(data) {
        $scope.entd = data.entd;
    });
});

metamodelo.controller("entdEditController", function($scope, $http, $location, $route, $routeParams) {
    var url = "metamodelo/entd-edit.action?entd.entiId=" + $routeParams.entiId + "&entd.tpdt.id="
            + $routeParams.tpdtId;

    $http.get(url).success(function(data) {
        $scope.entd = data.entd;
        $scope.accion = data.accion;
    });
});

metamodelo.controller("entdCreateController", function($scope, $http, $location, $route, $routeParams) {
    var url = "metamodelo/entd-create.action?entd.entiId=" + $routeParams.entiId;

    $http.get(url).success(function(data) {
        $scope.entd = data.entd;
        $scope.accion = data.accion;
    });

    var urlTpdt = "metamodelo/tpdt-lv-list.action";

    $http.get(urlTpdt).success(function(data) {
        $scope.tpdtList = data.lvList;
    });
});

//------------------- DEPENDENCIA ENTRE ENTIDADES --------------------

metamodelo.controller("enenCreateController", function($scope, $http, $location, $route, $routeParams) {
    var url = "metamodelo/enen-create.action?enen.entipId=" + $routeParams.entipId;

    $http.get(url).success(function(data) {
        $scope.entd = data.enen;
    });
});
