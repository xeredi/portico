var facturacion = angular.module("facturacion", [ "ngRoute" ]);

facturacion.config([ "$routeProvider", function($routeProvider) {
    $routeProvider

    .when("/facturacion", {
        templateUrl : "modules/facturacion/facturacion.html",
        controller : "facturacionController"
    })

    // ----------- VALORACION ------------------

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

    // ----------- CARGO ------------------

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

    // ----------- REGLA ------------------

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

// ----------------- CONTROLLERS --------------------------
// ----------------- CONTROLLERS --------------------------
// ----------------- CONTROLLERS --------------------------

facturacion.controller("facturacionController", function($scope, $http, $location) {
});

// ----------- VALORACION ------------------

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
