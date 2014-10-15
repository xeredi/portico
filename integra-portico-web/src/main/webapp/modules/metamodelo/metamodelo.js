var metamodelo = angular.module("metamodelo", [ "ngRoute" ]);

// -------------------- TIPO DE DATO ------------------
// -------------------- TIPO DE DATO ------------------
// -------------------- TIPO DE DATO ------------------

metamodelo.config([ "$routeProvider", function($routeProvider) {
    $routeProvider

    .when("/metamodelo/tpdt/grid", {
        title : 'tpdt_grid',
        templateUrl : "modules/metamodelo/tpdt-grid.html",
        controller : "tpdtGridController",
        reloadOnSearch : false
    })

    .when("/metamodelo/tpdt/create", {
        title : 'tpdt_create',
        templateUrl : "modules/metamodelo/tpdt-edit.html",
        controller : "tpdtCreateController"
    })

    .when("/metamodelo/tpdt/detail/:tpdtId", {
        title : 'tpdt_detail',
        templateUrl : "modules/metamodelo/tpdt-detail.html",
        controller : "tpdtDetailController"
    })

    .when("/metamodelo/tpdt/edit/:tpdtId", {
        title : 'tpdt_edit',
        templateUrl : "modules/metamodelo/tpdt-edit.html",
        controller : "tpdtEditController"
    })

    .when("/metamodelo/cdrf/detail/:cdrfId", {
        title : 'cdrf_detail',
        templateUrl : "modules/metamodelo/cdrf-detail.html",
        controller : "cdrfDetailController"
    })

    .when("/metamodelo/cdrf/edit/:cdrfId", {
        title : 'cdrf_edit',
        templateUrl : "modules/metamodelo/cdrf-edit.html",
        controller : "cdrfEditController"
    })

    .when("/metamodelo/cdrf/create/:tpdtId", {
        title : 'cdrf_create',
        templateUrl : "modules/metamodelo/cdrf-edit.html",
        controller : "cdrfCreateController"
    })
} ]);

metamodelo.controller("tpdtGridController", function($scope, $http, $location, $route, $routeParams) {
    $scope.showFilter = false;
    $scope.tpdtCriterio = {};

    function search(tpdtCriterio, page, limit) {
        var url = "metamodelo/tpdt-list.action";

        $http.post(url, {
            tpdtCriterio : tpdtCriterio,
            page : page,
            limit : limit
        }).success(function(data) {
            $scope.actionErrors = data.actionErrors;

            if (data.actionErrors.length == 0) {
                $scope.page = data.tpdtList.page;
                $scope.tpdtList = data.tpdtList;

                var map = {};

                map["page"] = data.tpdtList.page;

                $location.search(map).replace();

                $scope.showFilter = false;
            }
        });
    }

    $scope.pageChanged = function() {
        search($scope.tpdtCriterio, $scope.page, $scope.limit);
    }

    $scope.filter = function() {
        $scope.showFilter = true;
    }

    $scope.search = function() {
        search($scope.tpdtCriterio, 1, $scope.limit);
    }

    $scope.cancelSearch = function() {
        $scope.showFilter = false;
    }

    search($scope.tpdtCriterio, $routeParams.page ? $routeParams.page : 1, $scope.limit);
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
            $scope.actionErrors = data.actionErrors;

            if (data.actionErrors.length == 0) {
                $location.path("/metamodelo/tpdt/detail/" + data.tpdt.id).replace();
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

    $scope.remove = function() {
        bootbox.confirm("Are you sure?", function(result) {
            if (result) {
                var url = "metamodelo/tpdt-remove.action?tpdt.id=" + $scope.tpdt.id;

                $http.get(url).success(function(data) {
                    $scope.actionErrors = data.actionErrors;

                    if (data.actionErrors.length == 0) {
                        window.history.back();
                    }
                });
            }
        });
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
});

metamodelo.controller("cdrfCreateController", function($scope, $http, $location, $route, $routeParams) {
    var url = "metamodelo/cdrf-create.action?cdrf.tpdtId=" + $routeParams.tpdtId;

    $http.get(url).success(function(data) {
        $scope.cdrf = data.cdrf;
        $scope.cdriMap = data.cdriMap;
        $scope.availableLanguages = data.availableLanguages;
        $scope.accion = data.accion;
    });

    $scope.save = function() {
        var url = "metamodelo/cdrf-save.action";

        $http.post(url, {
            cdrf : $scope.cdrf,
            cdriMap : $scope.cdriMap,
            accion : $scope.accion
        }).success(function(data) {
            $scope.actionErrors = data.actionErrors;

            if (data.actionErrors.length == 0) {
                $location.path("/metamodelo/cdrf/detail/" + data.cdrf.id).replace();
            }
        });
    }

    $scope.cancel = function() {
        window.history.back();
    }
});

metamodelo.controller("cdrfDetailController", function($scope, $http, $location, $route, $routeParams) {
    var url = "metamodelo/cdrf-detail.action?cdrf.id=" + $routeParams.cdrfId;

    $http.get(url).success(function(data) {
        $scope.cdrf = data.cdrf;
        $scope.cdriMap = data.cdriMap;
        $scope.availableLanguages = data.availableLanguages;
    });

    $scope.remove = function() {
        if (confirm("Are you sure?")) {
            var url = "metamodelo/cdrf-remove.action?cdrf.id=" + $scope.cdrf.id;

            $http.get(url).success(function(data) {
                $scope.actionErrors = data.actionErrors;

                if (data.actionErrors.length == 0) {
                    window.history.back();
                }
            });
        }
    }
});

metamodelo.controller("cdrfEditController", function($scope, $http, $location, $route, $routeParams) {
    var url = "metamodelo/cdrf-edit.action?cdrf.id=" + $routeParams.cdrfId;

    $http.get(url).success(function(data) {
        $scope.cdrf = data.cdrf;
        $scope.cdriMap = data.cdriMap;
        $scope.availableLanguages = data.availableLanguages;
        $scope.accion = data.accion;
    });

    $scope.save = function(form) {
        var url = "metamodelo/cdrf-save.action";

        $http.post(url, {
            cdrf : $scope.cdrf,
            cdriMap : $scope.cdriMap,
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
});

// -------------------- MAESTRO ------------------
// -------------------- MAESTRO ------------------
// -------------------- MAESTRO ------------------

metamodelo.config([ "$routeProvider", function($routeProvider) {
    $routeProvider

    .when("/metamodelo/tppr/grid", {
        title : 'tppr_grid',
        templateUrl : "modules/metamodelo/tppr-grid.html",
        controller : "tpprGridController",
        reloadOnSearch : false
    })

    .when("/metamodelo/tppr/detail/:entiId", {
        title : 'tppr_detail',
        templateUrl : "modules/metamodelo/tppr-detail.html",
        controller : "tpprDetailController"
    })

    .when("/metamodelo/tppr/edit/:entiId", {
        title : 'tppr_edit',
        templateUrl : "modules/metamodelo/tppr-edit.html",
        controller : "tpprEditController"
    })

    .when("/metamodelo/tppr/create", {
        title : 'tppr_create',
        templateUrl : "modules/metamodelo/tppr-edit.html",
        controller : "tpprCreateController"
    })

    .when("/metamodelo/tpsp/detail/:entiId", {
        title : 'tpsp_detail',
        templateUrl : "modules/metamodelo/tpsp-detail.html",
        controller : "tpspDetailController"
    })

    .when("/metamodelo/tpsp/edit/:entiId", {
        title : 'tpsp_edit',
        templateUrl : "modules/metamodelo/tpsp-edit.html",
        controller : "tpspEditController"
    })

    .when("/metamodelo/tpsp/create/:tpprId", {
        title : 'tpsp_create',
        templateUrl : "modules/metamodelo/tpsp-edit.html",
        controller : "tpspCreateController"
    })
} ]);

metamodelo.controller("tpprGridController", function($scope, $http, $location, $route, $routeParams) {
    $scope.showFilter = false;
    $scope.entiCriterio = {};

    function search(entiCriterio, page, limit) {
        var url = "metamodelo/tppr-list.action";

        $http.post(url, {
            entiCriterio : entiCriterio,
            page : page,
            limit : limit
        }).success(function(data) {
            $scope.actionErrors = data.actionErrors;

            if (data.actionErrors.length == 0) {
                $scope.page = data.entiList.page;
                $scope.entiList = data.entiList;

                var map = {};

                map["page"] = data.entiList.page;

                $location.search(map).replace();

                $scope.showFilter = false;
            }
        });
    }

    $scope.pageChanged = function() {
        search($scope.entiCriterio, $scope.page, $scope.limit);
    }

    $scope.filter = function() {
        $scope.showFilter = true;
    }

    $scope.search = function() {
        search($scope.entiCriterio, 1, $scope.limit);
    }

    $scope.cancelSearch = function() {
        $scope.showFilter = false;
    }

    search($scope.entiCriterio, $routeParams.page ? $routeParams.page : 1, $scope.limit);
});

metamodelo.controller("tpprDetailController", function($scope, $http, $location, $route, $routeParams) {
    var url = "metamodelo/tppr-detail.action?enti.id=" + $routeParams.entiId;

    $http.get(url).success(function(data) {
        $scope.enti = data.enti;
        $scope.subentiList = data.subentiList;
    });

    $scope.remove = function() {
        bootbox.confirm("Are you sure?", function(result) {
            if (result) {
                var url = "metamodelo/tppr-remove.action?enti.id=" + $scope.enti.id;

                $http.get(url).success(function(data) {
                    $scope.actionErrors = data.actionErrors;

                    if (data.actionErrors.length == 0) {
                        window.history.back();
                    }
                });
            }
        });
    }
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

    $scope.save = function() {
        var url = "metamodelo/tppr-save.action";

        $http.post(url, {
            enti : $scope.enti,
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

    $scope.save = function() {
        var url = "metamodelo/tppr-save.action";

        $http.post(url, {
            enti : $scope.enti,
            accion : $scope.accion
        }).success(function(data) {
            $scope.actionErrors = data.actionErrors;

            if (data.actionErrors.length == 0) {
                $location.path("/metamodelo/tppr/detail/" + data.enti.id).replace();
            }
        });
    }

    $scope.cancel = function() {
        setTimeout(function() {
            window.history.back();
        }, 0);
    }
});

metamodelo.controller("tpspDetailController", function($scope, $http, $location, $route, $routeParams) {
    var url = "metamodelo/tpsp-detail.action?enti.id=" + $routeParams.entiId;

    $http.get(url).success(function(data) {
        $scope.enti = data.enti;
    });

    $scope.remove = function() {
        bootbox.confirm("Are you sure?", function(result) {
            if (result) {
                var url = "metamodelo/tpsp-remove.action?enti.id=" + $scope.enti.id;

                $http.get(url).success(function(data) {
                    $scope.actionErrors = data.actionErrors;

                    if (data.actionErrors.length == 0) {
                        window.history.back();
                    }
                });
            }
        });
    }
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

    $scope.save = function() {
        var url = "metamodelo/tpsp-save.action";

        $http.post(url, {
            enti : $scope.enti,
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

    $scope.save = function() {
        var url = "metamodelo/tpsp-save.action";

        $http.post(url, {
            enti : $scope.enti,
            accion : $scope.accion
        }).success(function(data) {
            $scope.actionErrors = data.actionErrors;

            if (data.actionErrors.length == 0) {
                $location.path("/metamodelo/tpsp/detail/" + data.enti.id).replace();
            }
        });
    }

    $scope.cancel = function() {
        window.history.back();
    }
});

// -------------------- TIPO DE SERVICIO ------------------
// -------------------- TIPO DE SERVICIO ------------------
// -------------------- TIPO DE SERVICIO ------------------

metamodelo.config([ "$routeProvider", function($routeProvider) {
    $routeProvider

    .when("/metamodelo/tpsr/grid", {
        title : 'tpsr_grid',
        templateUrl : "modules/metamodelo/tpsr-grid.html",
        controller : "tpsrGridController",
        reloadOnSearch : false
    })

    .when("/metamodelo/tpsr/detail/:entiId", {
        title : 'tpsr_detail',
        templateUrl : "modules/metamodelo/tpsr-detail.html",
        controller : "tpsrDetailController"
    })

    .when("/metamodelo/tpsr/edit/:entiId", {
        title : 'tpsr_edit',
        templateUrl : "modules/metamodelo/tpsr-edit.html",
        controller : "tpsrEditController"
    })

    .when("/metamodelo/tpsr/create", {
        title : 'tpsr_create',
        templateUrl : "modules/metamodelo/tpsr-edit.html",
        controller : "tpsrCreateController"
    })

    .when("/metamodelo/tpss/detail/:entiId", {
        title : 'tpss_detail',
        templateUrl : "modules/metamodelo/tpss-detail.html",
        controller : "tpssDetailController"
    })

    .when("/metamodelo/tpss/edit/:entiId", {
        title : 'tpss_edit',
        templateUrl : "modules/metamodelo/tpss-edit.html",
        controller : "tpssEditController"
    })

    .when("/metamodelo/tpss/create/:tpsrId", {
        title : 'tpss_create',
        templateUrl : "modules/metamodelo/tpss-edit.html",
        controller : "tpssCreateController"
    })
} ]);

metamodelo.controller("tpsrGridController", function($scope, $http, $location, $route, $routeParams) {
    $scope.showFilter = false;
    $scope.entiCriterio = {};

    function search(entiCriterio, page, limit) {
        var url = "metamodelo/tpsr-list.action";

        $http.post(url, {
            entiCriterio : entiCriterio,
            page : page,
            limit : limit
        }).success(function(data) {
            $scope.actionErrors = data.actionErrors;

            if (data.actionErrors.length == 0) {
                $scope.page = data.entiList.page;
                $scope.entiList = data.entiList;

                var map = {};

                map["page"] = data.entiList.page;

                $location.search(map).replace();

                $scope.showFilter = false;
            }
        });
    }

    $scope.pageChanged = function() {
        search($scope.entiCriterio, $scope.page, $scope.limit);
    }

    $scope.filter = function() {
        $scope.showFilter = true;
    }

    $scope.search = function() {
        search($scope.entiCriterio, 1, $scope.limit);
    }

    $scope.cancelSearch = function() {
        $scope.showFilter = false;
    }

    search($scope.entiCriterio, $routeParams.page ? $routeParams.page : 1, $scope.limit);
});

metamodelo.controller("tpsrDetailController", function($scope, $http, $location, $route, $routeParams) {
    var url = "metamodelo/tpsr-detail.action?enti.id=" + $routeParams.entiId;

    $http.get(url).success(function(data) {
        $scope.enti = data.enti;
        $scope.subentiList = data.subentiList;
        $scope.entiHijasList = data.entiHijasList;
    });

    $scope.remove = function() {
        bootbox.confirm("Are you sure?", function(result) {
            if (result) {
                var url = "metamodelo/tpsr-remove.action?enti.id=" + $scope.enti.id;

                $http.get(url).success(function(data) {
                    $scope.actionErrors = data.actionErrors;

                    if (data.actionErrors.length == 0) {
                        window.history.back();
                    }
                });
            }
        });
    }
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

    $scope.save = function() {
        var url = "metamodelo/tpsr-save.action";

        $http.post(url, {
            enti : $scope.enti,
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

    $scope.save = function() {
        var url = "metamodelo/tpsr-save.action";

        $http.post(url, {
            enti : $scope.enti,
            accion : $scope.accion
        }).success(function(data) {
            $scope.actionErrors = data.actionErrors;

            if (data.actionErrors.length == 0) {
                $location.path("/metamodelo/tpsr/detail/" + data.enti.id).replace();
            }
        });
    }

    $scope.cancel = function() {
        window.history.back();
    }
});

metamodelo.controller("tpssDetailController", function($scope, $http, $location, $route, $routeParams) {
    var url = "metamodelo/tpss-detail.action?enti.id=" + $routeParams.entiId;

    $http.get(url).success(function(data) {
        $scope.enti = data.enti;
        $scope.entiHijasList = data.entiHijasList;
        $scope.entiPadresList = data.entiPadresList;
    });

    $scope.remove = function() {
        bootbox.confirm("Are you sure?", function(result) {
            if (result) {
                var url = "metamodelo/tpss-remove.action?enti.id=" + $scope.enti.id;

                $http.get(url).success(function(data) {
                    $scope.actionErrors = data.actionErrors;

                    if (data.actionErrors.length == 0) {
                        window.history.back();
                    }
                });
            }
        });
    }
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

    $scope.save = function() {
        var url = "metamodelo/tpss-save.action";

        $http.post(url, {
            enti : $scope.enti,
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
});

metamodelo.controller("tpssCreateController", function($scope, $http, $location, $route, $routeParams) {
    var url = "metamodelo/tpss-create.action?enti.tpsrId=" + $routeParams.tpsrId;

    $http.get(url).success(function(data) {
        $scope.enti = data.enti;
        $scope.accion = data.accion;
    });

    var urlTpdtEstado = "metamodelo/tpdt-lv-list.action?tpdtCriterio.tipoElemento=CR";

    $http.get(urlTpdtEstado).success(function(data) {
        $scope.tpdtEstadoList = data.lvList;
    });

    $scope.save = function() {
        var url = "metamodelo/tpss-save.action";

        $http.post(url, {
            enti : $scope.enti,
            accion : $scope.accion
        }).success(function(data) {
            $scope.actionErrors = data.actionErrors;

            if (data.actionErrors.length == 0) {
                $location.path("/metamodelo/tpss/detail/" + data.enti.id).replace();
            }
        });
    }

    $scope.cancel = function() {
        window.history.back();
    }
});

// -------------------- ESTADISTICA ------------------
// -------------------- ESTADISTICA ------------------
// -------------------- ESTADISTICA ------------------

metamodelo.config([ "$routeProvider", function($routeProvider) {
    $routeProvider

    .when("/metamodelo/tpes/grid", {
        title : 'tpes_grid',
        templateUrl : "modules/metamodelo/tpes-grid.html",
        controller : "tpesGridController",
        reloadOnSearch : false
    })

    .when("/metamodelo/tpes/detail/:entiId", {
        title : 'tpes_detail',
        templateUrl : "modules/metamodelo/tpes-detail.html",
        controller : "tpesDetailController"
    })

    .when("/metamodelo/tpes/edit/:entiId", {
        title : 'tpes_edit',
        templateUrl : "modules/metamodelo/tpes-edit.html",
        controller : "tpesEditController"
    })

    .when("/metamodelo/tpes/create", {
        title : 'tpes_create',
        templateUrl : "modules/metamodelo/tpes-edit.html",
        controller : "tpesCreateController"
    })
} ]);

metamodelo.controller("tpesGridController", function($scope, $http, $location, $route, $routeParams) {
    $scope.showFilter = false;
    $scope.entiCriterio = {};

    function search(entiCriterio, page, limit) {
        var url = "metamodelo/tpes-list.action";

        $http.post(url, {
            entiCriterio : entiCriterio,
            page : page,
            limit : limit
        }).success(function(data) {
            $scope.actionErrors = data.actionErrors;

            if (data.actionErrors.length == 0) {
                $scope.page = data.entiList.page;
                $scope.entiList = data.entiList;

                var map = {};

                map["page"] = data.entiList.page;

                $location.search(map).replace();

                $scope.showFilter = false;
            }
        });
    }

    $scope.pageChanged = function() {
        search($scope.entiCriterio, $scope.page, $scope.limit);
    }

    $scope.filter = function() {
        $scope.showFilter = true;
    }

    $scope.search = function() {
        search($scope.entiCriterio, 1, $scope.limit);
    }

    $scope.cancelSearch = function() {
        $scope.showFilter = false;
    }

    search($scope.entiCriterio, $routeParams.page ? $routeParams.page : 1, $scope.limit);
});

metamodelo.controller("tpesDetailController", function($scope, $http, $location, $route, $routeParams) {
    var url = "metamodelo/tpes-detail.action?enti.id=" + $routeParams.entiId;

    $http.get(url).success(function(data) {
        $scope.enti = data.enti;
        $scope.subentiList = data.subentiList;
    });

    $scope.remove = function() {
        bootbox.confirm("Are you sure?", function(result) {
            if (result) {
                var url = "metamodelo/tpes-remove.action?enti.id=" + $scope.enti.id;

                $http.get(url).success(function(data) {
                    $scope.actionErrors = data.actionErrors;

                    if (data.actionErrors.length == 0) {
                        window.history.back();
                    }
                });
            }
        });
    }
});

metamodelo.controller("tpesEditController", function($scope, $http, $location, $route, $routeParams) {
    var url = "metamodelo/tpes-edit.action?enti.id=" + $routeParams.entiId;

    $http.get(url).success(function(data) {
        $scope.enti = data.enti;
        $scope.accion = data.accion;
    });

    $scope.save = function() {
        var url = "metamodelo/tpes-save.action";

        $http.post(url, {
            enti : $scope.enti,
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
});

metamodelo.controller("tpesCreateController", function($scope, $http, $location, $route, $routeParams) {
    var url = "metamodelo/tpes-create.action";

    $http.get(url).success(function(data) {
        $scope.enti = data.enti;
        $scope.accion = data.accion;
    });

    $scope.save = function() {
        var url = "metamodelo/tpes-save.action";

        $http.post(url, {
            enti : $scope.enti,
            accion : $scope.accion
        }).success(function(data) {
            $scope.actionErrors = data.actionErrors;

            if (data.actionErrors.length == 0) {
                $location.path("/metamodelo/tpes/detail/" + data.enti.id).replace();
            }
        });
    }

    $scope.cancel = function() {
        window.history.back();
    }
});

// ------------------- DATO DE ENTIDAD --------------------
// ------------------- DATO DE ENTIDAD --------------------
// ------------------- DATO DE ENTIDAD --------------------

metamodelo.config([ "$routeProvider", function($routeProvider) {
    $routeProvider

    .when("/metamodelo/entd/detail/:entiId/:tpdtId", {
        title : 'entd_detail',
        templateUrl : "modules/metamodelo/entd-detail.html",
        controller : "entdDetailController"
    })

    .when("/metamodelo/entd/edit/:entiId/:tpdtId", {
        title : 'entd_edit',
        templateUrl : "modules/metamodelo/entd-edit.html",
        controller : "entdEditController"
    })

    .when("/metamodelo/entd/create/:entiId", {
        title : 'entd_create',
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

    $scope.remove = function() {
        bootbox.confirm("Are you sure?", function(result) {
            if (result) {
                var url = "metamodelo/entd-remove.action?entd.entiId=" + $scope.entd.entiId + "&entd.tpdt.id="
                        + $scope.entd.tpdt.id;

                $http.get(url).success(function(data) {
                    $scope.actionErrors = data.actionErrors;

                    if (data.actionErrors.length == 0) {
                        window.history.back();
                    }
                });
            }
        });
    }
});

metamodelo.controller("entdEditController",
        function($scope, $http, $routeParams) {
            var url = "metamodelo/entd-edit.action?entd.entiId=" + $routeParams.entiId + "&entd.tpdt.id="
                    + $routeParams.tpdtId;

            $http.get(url).success(function(data) {
                $scope.entd = data.entd;
                $scope.accion = data.accion;
                $scope.tpdtList = data.tpdtList;
                $scope.engdList = data.engdList;
            });

            $scope.save = function() {
                var url = "metamodelo/entd-save.action";

                $http.post(url, {
                    entd : $scope.entd,
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
        });

metamodelo.controller("entdCreateController", function($scope, $http, $location, $route, $routeParams) {
    var url = "metamodelo/entd-create.action?entd.entiId=" + $routeParams.entiId;

    $http.get(url).success(function(data) {
        $scope.entd = data.entd;
        $scope.tpdtList = data.tpdtList;
        $scope.engdList = data.engdList;
        $scope.accion = data.accion;
    });

    $scope.save = function() {
        var url = "metamodelo/entd-save.action";

        $http.post(url, {
            entd : $scope.entd,
            accion : $scope.accion
        }).success(function(data) {
            $scope.actionErrors = data.actionErrors;

            if (data.actionErrors.length == 0) {
                $location.path("/metamodelo/entd/detail/" + data.entd.entiId + "/" + data.entd.tpdt.id).replace();
            }
        });
    }

    $scope.cancel = function() {
        window.history.back();
    }
});

// ------------------- ACCION DE ENTIDAD --------------------
// ------------------- ACCION DE ENTIDAD --------------------
// ------------------- ACCION DE ENTIDAD --------------------

metamodelo.config([ "$routeProvider", function($routeProvider) {
    $routeProvider

    .when("/metamodelo/enac/detail/:entiId/:path", {
        title : 'enac_detail',
        templateUrl : "modules/metamodelo/enac-detail.html",
        controller : "enacDetailController"
    })

    .when("/metamodelo/enac/edit/:entiId/:path", {
        title : 'enac_edit',
        templateUrl : "modules/metamodelo/enac-edit.html",
        controller : "enacEditController"
    })

    .when("/metamodelo/enac/create/:entiId", {
        title : 'enac_create',
        templateUrl : "modules/metamodelo/enac-edit.html",
        controller : "enacCreateController"
    })
} ]);

metamodelo.controller("enacDetailController", function($scope, $http, $location, $route, $routeParams) {
    var url = "metamodelo/enac-detail.action?enac.entiId=" + $routeParams.entiId + "&enac.path=" + $routeParams.path;

    $http.get(url).success(function(data) {
        $scope.enac = data.enac;
    });

    $scope.remove = function() {
        bootbox.confirm("Are you sure?", function(result) {
            if (result) {
                var url = "metamodelo/enac-remove.action?enac.entiId=" + $scope.enac.entiId + "&enac.path="
                        + $scope.enac.path;

                $http.get(url).success(function(data) {
                    $scope.actionErrors = data.actionErrors;

                    if (data.actionErrors.length == 0) {
                        window.history.back();
                    }
                });
            }
        });
    }
});

metamodelo.controller("enacEditController", function($scope, $http, $location, $route, $routeParams) {
    var url = "metamodelo/enac-edit.action?enac.entiId=" + $routeParams.entiId + "&enac.path=" + $routeParams.path;

    $http.get(url).success(function(data) {
        $scope.enac = data.enac;
        $scope.accion = data.accion;
    });

    $scope.save = function() {
        var url = "metamodelo/enac-save.action";

        $http.post(url, {
            enac : $scope.enac,
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
});

metamodelo.controller("enacCreateController", function($scope, $http, $location, $route, $routeParams) {
    var url = "metamodelo/enac-create.action?enac.entiId=" + $routeParams.entiId;

    $http.get(url).success(function(data) {
        $scope.enac = data.enac;
        $scope.accion = data.accion;
    });

    $scope.save = function() {
        var url = "metamodelo/enac-save.action";

        $http.post(url, {
            enac : $scope.enac,
            accion : $scope.accion
        }).success(function(data) {
            $scope.actionErrors = data.actionErrors;

            if (data.actionErrors.length == 0) {
                $location.path("/metamodelo/enac/detail/" + data.enac.entiId + "/" + data.enac.path).replace();
            }
        });
    }

    $scope.cancel = function() {
        window.history.back();
    }
});

// ------------------- DEPENDENCIA ENTRE ENTIDADES --------------------
// ------------------- DEPENDENCIA ENTRE ENTIDADES --------------------
// ------------------- DEPENDENCIA ENTRE ENTIDADES --------------------

metamodelo.config([ "$routeProvider", function($routeProvider) {
    $routeProvider

    .when("/metamodelo/enen/create/:entipId", {
        title : 'enen_create',
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
