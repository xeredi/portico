var module = angular.module("facturacion", [ "ngRoute" ]);

// ----------------- MENU PRINCIPAL --------------------------
// ----------------- MENU PRINCIPAL --------------------------
// ----------------- MENU PRINCIPAL --------------------------

module.config([ "$routeProvider", function($routeProvider) {
    $routeProvider

    .when("/facturacion", {
        templateUrl : "modules/facturacion/facturacion.html",
        controller : "facturacionController"
    })
} ]);

module.controller("facturacionController", function($scope, $http, $location) {
});

// ----------- VALORACION ------------------
// ----------- VALORACION ------------------
// ----------- VALORACION ------------------

module.config([ "$routeProvider", function($routeProvider) {
    $routeProvider

    .when("/facturacion/vlrc/grid", {
        title : 'vlrc_grid',
        templateUrl : "modules/facturacion/vlrc-grid.html",
        controller : "vlrcGridController",
        reloadOnSearch : false
    })

    .when("/facturacion/vlrc/detail/:vlrcId", {
        title : 'vlrc_detail',
        templateUrl : "modules/facturacion/vlrc-detail.html",
        controller : "vlrcDetailController"
    })

    .when("/facturacion/vlrc/edit/:vlrcId", {
        title : 'vlrc_edit',
        templateUrl : "modules/facturacion/vlrc-edit.html",
        controller : "vlrcEditController"
    })

    .when("/facturacion/vlrl/create/:vlrcId", {
        title : 'vlrl_create',
        templateUrl : "modules/facturacion/vlrl-edit.html",
        controller : "vlrlCreateController"
    })

    .when("/facturacion/vlrl/detail/:vlrlId", {
        title : 'vlrl_detail',
        templateUrl : "modules/facturacion/vlrl-detail.html",
        controller : "vlrlDetailController"
    })

    .when("/facturacion/vlrl/edit/:vlrlId", {
        title : 'vlrl_edit',
        templateUrl : "modules/facturacion/vlrl-edit.html",
        controller : "vlrlEditController"
    })

    .when("/facturacion/vlrd/detail/:vlrdId", {
        title : 'vlrd_detail',
        templateUrl : "modules/facturacion/vlrd-detail.html",
        controller : "vlrdDetailController"
    })

    .when("/facturacion/vlrd/edit/:vlrdId", {
        title : 'vlrd_edit',
        templateUrl : "modules/facturacion/vlrd-edit.html",
        controller : "vlrdEditController"
    })
} ]);

module.controller("vlrcGridController", function($scope, $http, $location, $route, $routeParams) {
    $scope.showFilter = false;
    $scope.vlrcCriterio = {};

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

                var map = {};

                if (data.vlrcCriterio.pagador) {
                    map["vlrcCriterio.pagador.id"] = data.vlrcCriterio.pagador.id;
                }
                if (data.vlrcCriterio.aspcId) {
                    map["vlrcCriterio.aspcId"] = data.vlrcCriterio.aspcId;
                }
                if (data.vlrcCriterio.srvcId) {
                    map["vlrcCriterio.srvcId"] = data.vlrcCriterio.srvcId;
                }

                map["page"] = data.vlrcList.page;

                $location.search(map).replace();

                $scope.showFilter = false;
            }
        });
    }

    $scope.pageChanged = function() {
        search($scope.vlrcCriterio, $scope.page, $scope.limit);
    }

    $scope.filter = function() {
        $scope.showFilter = true;
    }

    $scope.search = function() {
        search($scope.vlrcCriterio, 1, $scope.limit);
    }

    $scope.cancelSearch = function() {
        $scope.showFilter = false;
    }

    search($scope.vlrcCriterio, $routeParams.page ? $routeParams.page : 1, $scope.limit);
});

module.controller("vlrlCreateController", function($scope, $http, $location, $route, $routeParams) {
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
});

module.controller("vlrcDetailController", function($scope, $http, $location, $route, $routeParams) {
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

module.controller("vlrlDetailController", function($scope, $http, $location, $route, $routeParams) {
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
});

module.controller("vlrlEditController", function($scope, $http, $location, $route, $routeParams) {
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
});

module.controller("vlrdDetailController", function($scope, $http, $location, $route, $routeParams) {
    var url = "facturacion/vlrd-detail.action?vlrd.id=" + $routeParams.vlrdId;

    $http.get(url).success(function(data) {
        $scope.vlrd = data.vlrd;
    });
});

// ----------- CARGO y REGLA------------------
// ----------- CARGO y REGLA------------------
// ----------- CARGO y REGLA------------------

module.config([ "$routeProvider", function($routeProvider) {
    $routeProvider

    .when("/facturacion/crgo/grid", {
        title : 'crgo_grid',
        templateUrl : "modules/facturacion/crgo-grid.html",
        controller : "crgoGridController",
        reloadOnSearch : false
    })

    .when("/facturacion/crgo/detail/:crgoId/:fechaVigencia", {
        title : 'crgo_detail',
        templateUrl : "modules/facturacion/crgo-detail.html",
        controller : "crgoDetailController"
    })

    .when("/facturacion/crgo/detail/:crgvId", {
        title : 'crgo_detail',
        templateUrl : "modules/facturacion/crgo-detail.html",
        controller : "crgoDetailController"
    })

    .when("/facturacion/crgo/edit/:crgvId", {
        title : 'crgo_edit',
        templateUrl : "modules/facturacion/crgo-edit.html",
        controller : "crgoEditController"
    })

    .when("/facturacion/crgo/create", {
        title : 'crgo_create',
        templateUrl : "modules/facturacion/crgo-edit.html",
        controller : "crgoCreateController"
    })

    .when("/facturacion/rgla/detail/:rglaId/:fechaVigencia", {
        title : 'rgla_detail',
        templateUrl : "modules/facturacion/rgla-detail.html",
        controller : "rglaDetailController"
    })

    .when("/facturacion/rgla/detail/:rglvId", {
        title : 'rgla_detail',
        templateUrl : "modules/facturacion/rgla-detail.html",
        controller : "rglaDetailController"
    })

    .when("/facturacion/rgla/edit/:rglvId", {
        title : 'rgla_edit',
        templateUrl : "modules/facturacion/rgla-edit.html",
        controller : "rglaEditController"
    })

    .when("/facturacion/rgla/create/:crgvId", {
        title : 'rgla_create',
        templateUrl : "modules/facturacion/rgla-edit.html",
        controller : "rglaCreateController"
    })

    .when("/facturacion/rgin/detail/:rgivId", {
        title : 'rgin_detail',
        templateUrl : "modules/facturacion/rgin-detail.html",
        controller : "rginDetailController"
    })

    .when("/facturacion/rgin/detail/:rginId/:fechaVigencia", {
        title : 'rgin_detail',
        templateUrl : "modules/facturacion/rgin-detail.html",
        controller : "rginDetailController"
    })

    .when("/facturacion/rgin/edit/:rgivId", {
        title : 'rgin_edit',
        templateUrl : "modules/facturacion/rgin-edit.html",
        controller : "rginEditController"
    })

    .when("/facturacion/rgin/create/:crgoId/:rglaId", {
        title : 'rgin_create',
        templateUrl : "modules/facturacion/rgin-edit.html",
        controller : "rginCreateController"
    })
} ]);

module.controller("crgoGridController", function($scope, $http, $location, $route, $routeParams) {
    $scope.showFilter = false;
    $scope.crgoCriterio = {};

    function search(crgoCriterio, page, limit) {
        var url = "facturacion/crgo-list.action";

        $http.post(url, {
            crgoCriterio : crgoCriterio,
            page : page,
            limit : limit
        }).success(function(data) {
            $scope.actionErrors = data.actionErrors;

            if (data.actionErrors.length == 0) {
                $scope.page = data.crgoList.page;
                $scope.crgoList = data.crgoList;
                $scope.crgoCriterio = data.crgoCriterio;

                var map = {};

                map["page"] = data.crgoList.page;

                $location.search(map).replace();

                $scope.showFilter = false;
            }
        });
    }

    $scope.pageChanged = function() {
        search($scope.crgoCriterio, $scope.page, $scope.limit);
    }

    $scope.filter = function() {
        $scope.showFilter = true;

        var urlEntiList = "metamodelo/enti-lv-list.action?entiCriterio.tipo=T";

        $http.get(urlEntiList).success(function(data) {
            $scope.entiList = data.lvList;
        });
    }

    $scope.search = function() {
        search($scope.crgoCriterio, 1, $scope.limit);
    }

    $scope.cancelSearch = function() {
        $scope.showFilter = false;
    }

    search($scope.crgoCriterio, $routeParams.page ? $routeParams.page : 1, $scope.limit);
});

module.controller("crgoCreateController", function($scope, $http, $location, $route, $routeParams) {
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
});

module.controller("crgoDetailController", function($scope, $http, $location, $route, $routeParams) {
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
});

module.controller("crgoEditController", function($scope, $http, $location, $route, $routeParams) {
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
});

module.controller("rglaDetailController", function($scope, $http, $location, $route, $routeParams) {
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
});

module.controller("rglaEditController", function($scope, $http, $location, $route, $routeParams) {
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
});

module.controller("rglaCreateController", function($scope, $http, $location, $route, $routeParams) {
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
});

module.controller("rginDetailController", function($scope, $http, $location, $route, $routeParams) {
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
});

module.controller("rginEditController", function($scope, $http, $location, $route, $routeParams) {
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
});

module.controller("rginCreateController", function($scope, $http, $location, $route, $routeParams) {
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
});

// ----------- ASPECTO y ASPECTO CARGO ------------------
// ----------- ASPECTO y ASPECTO CARGO ------------------
// ----------- ASPECTO y ASPECTO CARGO ------------------

module.config([ "$routeProvider", function($routeProvider) {
    $routeProvider

    .when("/facturacion/aspc/grid", {
        title : 'aspc_grid',
        templateUrl : "modules/facturacion/aspc-grid.html",
        controller : "aspcGridController",
        reloadOnSearch : false
    })

    .when("/facturacion/aspc/create", {
        title : 'aspc_create',
        templateUrl : "modules/facturacion/aspc-edit.html",
        controller : "aspcCreateController"
    })

    .when("/facturacion/aspc/detail/:aspvId", {
        title : 'aspc_detail',
        templateUrl : "modules/facturacion/aspc-detail.html",
        controller : "aspcDetailController"
    })

    .when("/facturacion/aspc/edit/:aspvId", {
        title : 'aspc_edit',
        templateUrl : "modules/facturacion/aspc-edit.html",
        controller : "aspcEditController"
    })

    .when("/facturacion/aspc/duplicate/:aspvId", {
        title : 'aspc_duplicate',
        templateUrl : "modules/facturacion/aspc-edit.html",
        controller : "aspcDuplicateController"
    })

    .when("/facturacion/aspc/detail/:aspcId/:fechaVigencia", {
        title : 'aspc_detail',
        templateUrl : "modules/facturacion/aspc-detail.html",
        controller : "aspcDetailController"
    })

    .when("/facturacion/ascr/create/:aspcId/:fechaVigencia", {
        title : 'ascr_create',
        templateUrl : "modules/facturacion/ascr-edit.html",
        controller : "ascrCreateController"
    })

    .when("/facturacion/ascr/detail/:ascrId/:fechaVigencia", {
        title : 'ascr_detail',
        templateUrl : "modules/facturacion/ascr-detail.html",
        controller : "ascrDetailController"
    })

    .when("/facturacion/ascr/edit/:ascvId", {
        title : 'ascr_edit',
        templateUrl : "modules/facturacion/ascr-edit.html",
        controller : "ascrEditController"
    })
} ]);

module.controller("aspcGridController", function($scope, $http, $location, $route, $routeParams) {
    $scope.showFilter = false;
    $scope.aspcCriterio = {};

    function search(aspcCriterio, page, limit) {
        var url = "facturacion/aspc-list.action";

        $http.post(url, {
            aspcCriterio : aspcCriterio,
            page : page,
            limit : limit
        }).success(function(data) {
            $scope.actionErrors = data.actionErrors;

            if (data.actionErrors.length == 0) {
                $scope.page = data.aspcList.page;
                $scope.aspcList = data.aspcList;
                $scope.aspcCriterio = data.aspcCriterio;

                var map = {};

                map["page"] = data.aspcList.page;

                $location.search(map).replace();

                $scope.showFilter = false;
            }
        });
    }

    $scope.pageChanged = function() {
        search($scope.aspcCriterio, $scope.page, $scope.limit);
    }

    $scope.filter = function() {
        $scope.showFilter = true;

        var urlEntiList = "metamodelo/enti-lv-list.action?entiCriterio.tipo=T";

        $http.get(urlEntiList).success(function(data) {
            $scope.entiList = data.lvList;
        });
    }

    $scope.search = function() {
        search($scope.aspcCriterio, 1, $scope.limit);
    }

    $scope.cancelSearch = function() {
        $scope.showFilter = false;
    }

    search($scope.aspcCriterio, $routeParams.page ? $routeParams.page : 1, $scope.limit);
});

module.controller("aspcCreateController", function($scope, $http, $location, $route, $routeParams) {
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
            $scope.actionErrors = data.actionErrors;

            if (data.actionErrors.length == 0) {
                $location.path("/facturacion/aspc/detail/" + data.aspc.aspv.id).replace();
            }
        });
    }

    $scope.cancel = function() {
        window.history.back();
    }
});

module.controller("aspcDetailController", function($scope, $http, $location, $route, $routeParams) {
    var url = "facturacion/aspc-detail.action";

    if ($routeParams.fechaVigencia) {
        $scope.fechaVigencia = $routeParams.fechaVigencia;
        url += "?aspc.id=" + $routeParams.aspcId + "&fechaVigencia=" + $routeParams.fechaVigencia;
    } else {
        url += "?aspc.aspv.id=" + $routeParams.aspvId;
    }

    $http.get(url).success(function(data) {
        $scope.urlInclude = 'modules/facturacion/aspc-detail.html';
        $scope.aspc = data.aspc;
        $scope.ascrList = data.ascrList;
        $scope.fechaVigencia = data.fechaVigencia;
    });

    $scope.remove = function() {
        if (confirm("Are you sure?")) {
            var url = "facturacion/aspc-remove.action?aspc.aspv.id=" + $scope.aspc.aspv.id;

            $http.get(url).success(function(data) {
                $scope.actionErrors = data.actionErrors;

                if (data.actionErrors.length == 0) {
                    window.history.back();
                }
            });
        }
    }
});

module.controller("aspcEditController", function($scope, $http, $location, $route, $routeParams) {
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

module.controller("aspcDuplicateController", function($scope, $http, $location, $route, $routeParams) {
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
            $scope.actionErrors = data.actionErrors;

            if (data.actionErrors.length == 0) {
                $location.path("/facturacion/aspc/detail/" + data.aspc.aspv.id).replace();
            }
        });
    }

    $scope.cancel = function() {
        window.history.back();
    }
});

module.controller("ascrCreateController", function($scope, $http, $location, $routeParams) {
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
});

module.controller("ascrDetailController", function($scope, $http, $routeParams) {
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
});

module.controller("ascrEditController", function($scope, $http, $routeParams) {
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
});
