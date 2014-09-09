var metamodelo = angular.module("metamodelo", [ "ngRoute" ]);

// -------------------- TIPO DE DATO ------------------
// -------------------- TIPO DE DATO ------------------
// -------------------- TIPO DE DATO ------------------

metamodelo.config([ "$routeProvider", function($routeProvider) {
    $routeProvider

    .when("/metamodelo/tpdt/grid", {
        templateUrl : "modules/metamodelo/tpdt-grid.html",
        controller : "tpdtGridController"
    })

    .when("/metamodelo/tpdt/grid/:page", {
        templateUrl : "modules/metamodelo/tpdt-grid.html",
        controller : "tpdtGridController"
    })

    .when("/metamodelo/tpdt/filter", {
        templateUrl : "modules/metamodelo/tpdt-filter.html",
        controller : "tpdtFilterController"
    })

    .when("/metamodelo/tpdt/create", {
        templateUrl : "modules/metamodelo/tpdt-edit.html",
        controller : "tpdtCreateController"
    })

    .when("/metamodelo/tpdt/detail/:tpdtId", {
        templateUrl : "modules/metamodelo/tpdt-detail.html",
        controller : "tpdtDetailController"
    })

    .when("/metamodelo/tpdt/edit/:tpdtId", {
        templateUrl : "modules/metamodelo/tpdt-edit.html",
        controller : "tpdtEditController"
    })

    .when("/metamodelo/cdrf/detail/:tpdtId/:valor", {
        templateUrl : "modules/metamodelo/cdrf-detail.html",
        controller : "cdrfDetailController"
    })

    .when("/metamodelo/cdrf/edit/:tpdtId/:valor", {
        templateUrl : "modules/metamodelo/cdrf-edit.html",
        controller : "cdrfEditController"
    })

    .when("/metamodelo/cdrf/create/:tpdtId", {
        templateUrl : "modules/metamodelo/cdrf-edit.html",
        controller : "cdrfCreateController"
    })
} ]);

metamodelo.controller("tpdtGridController", function($scope, $http, $location, $route, $routeParams) {
    loaded = false;

    $scope.page = $routeParams.page ? $routeParams.page : 1;
    $scope.limit = 20;
    $scope.tpdtCriterio = $routeParams.tpdtCriterio;

    var url = "metamodelo/tpdt-list.action";

    $http.post(url, {
        tpdtCriterio : $scope.tpdtCriterio,
        page : $scope.page
    }).success(function(data) {
        $scope.tpdtList = data.tpdtList;
        $scope.page = data.page;
        $scope.currentPage = data.page;
        $scope.limit = data.tpdtList.limit;
        loaded = true;
    });

    $scope.filter = function() {
        $location.path("/metamodelo/tpdt/filter").replace();
    }

    $scope.create = function() {
        $location.path("/metamodelo/tpdt/create");
    }

    $scope.DoCtrlPagingAct = function(text, page) {
        console.log(text, page);
    };

    $scope.pageChanged = function() {
        if (loaded) {
            $location.path("/metamodelo/tpdt/grid/" + $scope.currentPage).replace();
        }
    }
});

metamodelo.controller("tpdtFilterController", function($scope, $http, $location) {
    $scope.search = function() {
        $location.path("/metamodelo/tpdt/grid").search({
            tpdtCriterio : {
                codigo : $scope.tpdtCriterio.codigo,
                nombre : $scope.tpdtCriterio.nombre
            },
            page : $scope.page
        }).replace();
    }

    $scope.cancel = function() {
        $location.path("/metamodelo/tpdt/grid").replace();
    }
});

metamodelo.controller("tpdtCreateController", function($scope, $http, $location, $route, $routeParams) {
    var url = "metamodelo/tpdt-create.action";

    $http.get(url).success(function(data) {
        $scope.tpdt = data.tpdt;
        $scope.accion = data.accion;
        $scope.tphts = data.tphts;
        $scope.tiposElemento = data.tiposElemento;
    });

    var urlEntiTpprList = "metamodelo/enti-lv-list.action?entiCriterio.tipo=P";

    $http.get(urlEntiTpprList).success(function(data) {
        $scope.entiTpprList = data.lvList;
    });

    var urlEntiTpsrList = "metamodelo/enti-lv-list.action?entiCriterio.tipo=T";

    $http.get(urlEntiTpsrList).success(function(data) {
        $scope.entiTpsrList = data.lvList;
    });

    $scope.save = function() {
        var url = "metamodelo/tpdt-save.action";

        $http.post(url, {
            tpdt : $scope.tpdt,
            accion : $scope.accion
        }).success(function(data) {
            if (data.actionErrors.length == 0) {
                $location.path("/metamodelo/tpdt/detail/" + data.tpdt.id).replace();
            } else {
                $scope.actionErrors = data.actionErrors;
            }
        });
    }

    $scope.cancel = function() {
        window.history.back();
    }
});

metamodelo.controller("tpdtDetailController", function($scope, $http, $location, $route, $routeParams) {
    var url = "metamodelo/tpdt-detail.action?tpdt.id=" + $routeParams.tpdtId;

    $http.get(url).success(function(data) {
        $scope.tpdt = data.tpdt;
    });

    $scope.edit = function() {
        $location.path("/metamodelo/tpdt/edit/" + $scope.tpdt.id).replace();
    }

    $scope.cdrfCreate = function() {
        $location.path("/metamodelo/cdrf/create/" + $scope.tpdt.id);
    }
});

metamodelo.controller("tpdtEditController", function($scope, $http, $location, $route, $routeParams) {
    var url = "metamodelo/tpdt-edit.action?tpdt.id=" + $routeParams.tpdtId;

    $http.get(url).success(function(data) {
        $scope.tpdt = data.tpdt;
        $scope.accion = data.accion;
        $scope.tphts = data.tphts;
        $scope.tiposElemento = data.tiposElemento;
    });

    var urlEntiTpprList = "metamodelo/enti-lv-list.action?entiCriterio.tipo=P";

    $http.get(urlEntiTpprList).success(function(data) {
        $scope.entiTpprList = data.lvList;
    });

    var urlEntiTpsrList = "metamodelo/enti-lv-list.action?entiCriterio.tipo=T";

    $http.get(urlEntiTpsrList).success(function(data) {
        $scope.entiTpsrList = data.lvList;
    });

    $scope.save = function() {
        var url = "metamodelo/tpdt-save.action";

        $http.post(url, {
            tpdt : $scope.tpdt,
            accion : $scope.accion
        }).success(function(data) {
            if (data.actionErrors.length == 0) {
                $location.path("/metamodelo/tpdt/detail/" + data.tpdt.id).replace();
            } else {
                $scope.actionErrors = data.actionErrors;
            }
        });
    }

    $scope.cancel = function() {
        $location.path("/metamodelo/tpdt/detail/" + $scope.tpdt.id).replace();
    }
});

metamodelo.controller("cdrfCreateController", function($scope, $http, $location, $route, $routeParams) {
    var url = "metamodelo/cdrf-create.action?cdrf.tpdtId=" + $routeParams.tpdtId;

    $http.get(url).success(function(data) {
        $scope.cdrf = data.cdrf;
        $scope.accion = data.accion;
    });

    $scope.save = function() {
        var url = "metamodelo/cdrf-save.action";

        $http.post(url, {
            cdrf : $scope.cdrf,
            accion : $scope.accion
        }).success(function(data) {
            if (data.actionErrors.length == 0) {
                $location.path("/metamodelo/cdrf/detail/" + data.cdrf.tpdtId + "/" + data.cdrf.valor).replace();
            } else {
                $scope.actionErrors = data.actionErrors;
            }
        });
    }

    $scope.cancel = function() {
        window.history.back();
    }
});

metamodelo.controller("cdrfDetailController", function($scope, $http, $location, $route, $routeParams) {
    var url = "metamodelo/cdrf-detail.action?cdrf.tpdtId=" + $routeParams.tpdtId + "&cdrf.valor=" + $routeParams.valor;

    $http.get(url).success(function(data) {
        $scope.cdrf = data.cdrf;
    });

    $scope.edit = function() {
        $location.path("/metamodelo/cdrf/edit/" + $scope.cdrf.tpdtId + "/" + $scope.cdrf.valor).replace();
    }
});

metamodelo.controller("cdrfEditController", function($scope, $http, $location, $route, $routeParams) {
    var url = "metamodelo/cdrf-edit.action?cdrf.tpdtId=" + $routeParams.tpdtId + "&cdrf.valor=" + $routeParams.valor;

    $http.get(url).success(function(data) {
        $scope.cdrf = data.cdrf;
        $scope.accion = data.accion;
    });

    $scope.save = function(form) {
        var url = "metamodelo/cdrf-save.action";

        $http.post(url, {
            cdrf : $scope.cdrf,
            accion : $scope.accion
        }).success(function(data) {
            if (data.actionErrors.length == 0) {
                $location.path("/metamodelo/cdrf/detail/" + data.cdrf.tpdtId + "/" + data.cdrf.valor).replace();
            } else {
                $scope.actionErrors = data.actionErrors;
            }
        });
    }

    $scope.cancel = function() {
        $location.path("/metamodelo/cdrf/detail/" + $scope.cdrf.tpdtId + "/" + $scope.cdrf.valor).replace();
    }
});

// -------------------- MAESTRO ------------------
// -------------------- MAESTRO ------------------
// -------------------- MAESTRO ------------------

metamodelo.config([ "$routeProvider", function($routeProvider) {
    $routeProvider

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
} ]);

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

    var urlTpdtNombreList = "metamodelo/tpdt-lv-list.action?tpdtCriterio.tipoElemento=TX&tpdtCriterio.entiRefId="
            + $routeParams.entiId;

    $http.get(urlTpdtNombreList).success(function(data) {
        $scope.tpdtNombreList = data.lvList;
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

    var urlTpdtNombreList = "metamodelo/tpdt-lv-list.action?tpdtCriterio.tipoElemento=TX&tpdtCriterio.entiRefId="
            + $routeParams.entiId;

    $http.get(urlTpdtNombreList).success(function(data) {
        $scope.tpdtNombreList = data.lvList;
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

// -------------------- SUBMAESTRO ------------------
// -------------------- SUBMAESTRO ------------------
// -------------------- SUBMAESTRO ------------------

metamodelo.config([ "$routeProvider", function($routeProvider) {
    $routeProvider

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
} ]);

metamodelo.controller("tpspDetailController", function($scope, $http, $location, $route, $routeParams) {
    var url = "metamodelo/tpsp-detail.action?enti.id=" + $routeParams.entiId;

    $http.get(url).success(function(data) {
        $scope.enti = data.enti;
    });
});

metamodelo.controller("tpspEditController", function($scope, $http, $location, $route, $routeParams) {
    var url = "metamodelo/tpsp-edit.action?enti.id=" + $routeParams.entiId;

    $http.get(url).success(function(data) {
        $scope.enti = data.enti;
        $scope.accion = data.accion;
    });

    var urlEntiList = "metamodelo/enti-lv-list.action?entiCriterio.tipo=P";

    $http.get(urlEntiList).success(function(data) {
        $scope.entiList = data.lvList;
    });

    $scope.submit = function(form) {
        var url = "metamodelo/tpsp-save.action";

        $http.post(url, {
            enti : $scope.enti,
            accion : $scope.accion
        }).success(function(data) {
            if (data.actionErrors.length == 0) {
                $location.path("/metamodelo/tpsp/detail/" + data.enti.id);
            } else {
                $scope.actionErrors = data.actionErrors;
            }
        });
    }
});

metamodelo.controller("tpspCreateController", function($scope, $http, $location, $route, $routeParams) {
    var url = "metamodelo/tpsp-create.action?enti.tpprId=" + $routeParams.tpprId;

    $http.get(url).success(function(data) {
        $scope.enti = data.enti;
        $scope.accion = data.accion;
    });

    var urlEntiList = "metamodelo/enti-lv-list.action?entiCriterio.tipo=P";

    $http.get(urlEntiList).success(function(data) {
        $scope.entiList = data.lvList;
    });

    $scope.submit = function(form) {
        var url = "metamodelo/tpsp-save.action";

        $http.post(url, {
            enti : $scope.enti,
            accion : $scope.accion
        }).success(function(data) {
            if (data.actionErrors.length == 0) {
                $location.path("/metamodelo/tpsp/detail/" + data.enti.id);
            } else {
                $scope.actionErrors = data.actionErrors;
            }
        });
    }
});

// -------------------- TIPO DE SERVICIO ------------------
// -------------------- TIPO DE SERVICIO ------------------
// -------------------- TIPO DE SERVICIO ------------------

metamodelo.config([ "$routeProvider", function($routeProvider) {
    $routeProvider

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
} ]);

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

    var urlTpdtEstado = "metamodelo/tpdt-lv-list.action?tpdtCriterio.tipoElemento=CR";

    $http.get(urlTpdtEstado).success(function(data) {
        $scope.tpdtEstadoList = data.lvList;
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

    var urlTpdtEstado = "metamodelo/tpdt-lv-list.action?tpdtCriterio.tipoElemento=CR";

    $http.get(urlTpdtEstado).success(function(data) {
        $scope.tpdtEstadoList = data.lvList;
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

// -------------------- SUBSERVICIO ------------------
// -------------------- SUBSERVICIO ------------------
// -------------------- SUBSERVICIO ------------------

metamodelo.config([ "$routeProvider", function($routeProvider) {
    $routeProvider

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
} ]);

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

    var urlTpdtEstado = "metamodelo/tpdt-lv-list.action?tpdtCriterio.tipoElemento=CR";

    $http.get(urlTpdtEstado).success(function(data) {
        $scope.tpdtEstadoList = data.lvList;
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

    var urlTpdtEstado = "metamodelo/tpdt-lv-list.action?tpdtCriterio.tipoElemento=CR";

    $http.get(urlTpdtEstado).success(function(data) {
        $scope.tpdtEstadoList = data.lvList;
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
// -------------------- ESTADISTICA ------------------
// -------------------- ESTADISTICA ------------------

metamodelo.config([ "$routeProvider", function($routeProvider) {
    $routeProvider

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
} ]);

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
    var url = "metamodelo/tpes-create.action";

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
// ------------------- DATO DE ENTIDAD --------------------
// ------------------- DATO DE ENTIDAD --------------------

metamodelo.config([ "$routeProvider", function($routeProvider) {
    $routeProvider

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
} ]);

metamodelo.controller("entdDetailController", function($scope, $http, $location, $route, $routeParams) {
    var url = "metamodelo/entd-detail.action?entd.entiId=" + $routeParams.entiId + "&entd.tpdt.id="
            + $routeParams.tpdtId;

    $http.get(url).success(function(data) {
        $scope.entd = data.entd;
    });
});

metamodelo.controller("entdEditController",
        function($scope, $http, $location, $route, $routeParams) {
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

// ------------------- DEPENDENCIA ENTRE ENTIDADES --------------------
// ------------------- DEPENDENCIA ENTRE ENTIDADES --------------------
// ------------------- DEPENDENCIA ENTRE ENTIDADES --------------------

metamodelo.config([ "$routeProvider", function($routeProvider) {
    $routeProvider

    .when("/metamodelo/enen/create/:entipId", {
        templateUrl : "modules/metamodelo/enen-edit.html",
        controller : "enenCreateController"
    });

} ]);

metamodelo.controller("enenCreateController", function($scope, $http, $location, $route, $routeParams) {
    var url = "metamodelo/enen-create.action?enen.entiPadreId=" + $routeParams.entipId;

    $http.get(url).success(function(data) {
        $scope.enen = data.enen;
    });

    var urlEnti = "metamodelo/enti-lv-list.action?entiCriterio.tipo=S";

    $http.get(urlEnti).success(function(data) {
        $scope.entiList = data.lvList;
    });
});
