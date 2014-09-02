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

    .otherwise({
        redirectTo : "/phones"
    });
} ])

// ----------------- CONTROLLERS --------------------------
// ----------------- CONTROLLERS --------------------------
// ----------------- CONTROLLERS --------------------------

// -------------------- MAESTRO ------------------

metamodelo.controller("tpprsFilterController", function($scope, $http, $location) {
    console.log("tpprsFilterController");

    $scope.submit = function(form) {
        console.log("tpprsFilterController Submit");
        console.log($scope.entiCriterio);
        console.log(JSON.stringify($scope.entiCriterio));
        console.log($scope.page);

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
})

metamodelo.controller("tpprsGridController", function($scope, $http, $location, $route, $routeParams) {
    console.log("tpprsGridController");
    console.log($routeParams.entiCriterio);

    $scope.entiCriterio = $routeParams.entiCriterio;
    $scope.page = $routeParams.page;

    console.log($scope.entiCriterio);

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
    console.log("tpprsDetailController");
    console.log($routeParams.entiId);

    var url = "metamodelo/tppr-detalle.action?enti.id=" + $routeParams.entiId;

    $http.get(url).success(function(data) {
        $scope.enti = data.enti;
        $scope.subentiList = data.subentiList;
    });
});

metamodelo.controller("tpprsEditController", function($scope, $http, $location, $route, $routeParams) {
    console.log("tpprsEditController");
    console.log($routeParams.entiId);

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
    console.log("tpprsCreateController");

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
    console.log("tpsrsFilterController");

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
    console.log("tpsrsGridController");
    console.log($routeParams.entiCriterio);

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
    console.log("tpsrsDetailController");
    console.log($routeParams.entiId);

    var url = "metamodelo/tpsr-detalle.action?enti.id=" + $routeParams.entiId;

    $http.get(url).success(function(data) {
        $scope.enti = data.enti;
        $scope.subentiList = data.subentiList;
    });
});

metamodelo.controller("tpsrsEditController", function($scope, $http, $location, $route, $routeParams) {
    console.log("tpsrsEditController");
    console.log($routeParams.entiId);

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
    console.log("tpsrsCreateController");

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

// -------------------- ESTADISTICA ------------------

metamodelo.controller("tpessFilterController", function($scope, $http, $location) {
    console.log("tpessFilterController");

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
    console.log("tpessGridController");
    console.log($routeParams.entiCriterio);

    $scope.entiCriterio = $routeParams.entiCriterio;
    $scope.page = $routeParams.page;

    console.log($scope.entiCriterio);

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
    console.log("tpessDetailController");
    console.log($routeParams.entiId);

    var url = "metamodelo/tpes-detalle.action?enti.id=" + $routeParams.entiId;

    $http.get(url).success(function(data) {
        $scope.enti = data.enti;
        $scope.subentiList = data.subentiList;
    });
});

metamodelo.controller("tpessEditController", function($scope, $http, $location, $route, $routeParams) {
    console.log("tpessEditController");
    console.log($routeParams.entiId);

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
    console.log("tpessCreateController");

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
    console.log("entdDetailController");
    console.log($routeParams.entiId);
    console.log($routeParams.tpdtId);

    var url = "metamodelo/entd-detalle.action?entd.entiId=" + $routeParams.entiId + "&entd.tpdt.id="
            + $routeParams.tpdtId;

    $http.get(url).success(function(data) {
        $scope.entd = data.entd;
    });
});

metamodelo.controller("entdEditController", function($scope, $http, $location, $route, $routeParams) {
    console.log("entdEditController");
    console.log($routeParams.entiId);
    console.log($routeParams.tpdtId);

    var url = "metamodelo/entd-editar.action?entd.entiId=" + $routeParams.entiId + "&entd.tpdt.id="
            + $routeParams.tpdtId;

    $http.get(url).success(function(data) {
        $scope.entd = data.entd;
    });

    var urlTpdt = "metamodelo/tpdt-lv-list.action";

    $http.get(urlTpdt).success(function(data) {
        $scope.tpdtList = data.lvList;
    });
});
