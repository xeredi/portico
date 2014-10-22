angular.module("estadistica", [ "ngRoute" ])

.config([ "$routeProvider", function($routeProvider) {
    $routeProvider

    .when("/estadistica/pepr/grid", {
        title : 'peprList',
        templateUrl : "modules/entidad/estadistica/pepr-grid.html",
        controller : "peprGridController",
        reloadOnSearch : false
    })

    .when("/estadistica/pepr/detail/:peprId", {
        title : 'pepr',
        templateUrl : "modules/entidad/estadistica/pepr-detail.html",
        controller : "peprDetailController"
    })

    .when("/estadistica/cdms/detail/:peprId", {
        title : 'cdms',
        templateUrl : "modules/entidad/estadistica/cdms-detail.html",
        controller : "cdmsDetailController"
    })

    .when("/estadistica/estd/grid/:entiId/:peprId/:autpId", {
        title : 'estdList',
        templateUrl : "modules/entidad/estadistica/estd-grid.html",
        controller : "estdGridController",
        reloadOnSearch : false
    })

    .when("/estadistica/estd/detail/:entiId/:itemId", {
        title : 'estd',
        templateUrl : "modules/entidad/estadistica/estd-detail.html",
        controller : "estdDetailController"
    })
} ])

.controller("peprGridController", function($scope, $http, $location, $route, $routeParams) {
    $scope.showFilter = false;
    $scope.peprCriterio = {};

    function search(peprCriterio, page, limit) {
        var url = "estadistica/pepr-list.action";

        $http.post(url, {
            peprCriterio : peprCriterio,
            page : page,
            limit : limit
        }).success(function(data) {
            $scope.actionErrors = data.actionErrors;

            if (data.actionErrors.length == 0) {
                $scope.page = data.peprList.page;
                $scope.peprList = data.peprList;

                var map = {};

                map["page"] = data.peprList.page;

                $location.search(map).replace();

                $scope.showFilter = false;
            }
        });
    }

    $scope.pageChanged = function() {
        search($scope.peprCriterio, $scope.page, $scope.limit);
    }

    $scope.filter = function() {
        var url = "estadistica/pepr-filter.action";

        $http.get(url).success(function(data) {
            $scope.actionErrors = data.actionErrors;

            if (data.actionErrors.length == 0) {
                $scope.autpList = data.autpList;
                $scope.limits = data.limits;
            }
        });

        $scope.showFilter = true;
    }

    $scope.search = function() {
        search($scope.peprCriterio, 1, $scope.limit);
    }

    $scope.cancelSearch = function() {
        $scope.showFilter = false;
    }

    search($scope.peprCriterio, $routeParams.page ? $routeParams.page : 1, $scope.limit);
})

.controller("peprDetailController", function($scope, $http, $location, $route, $routeParams) {
    var url = "estadistica/pepr-detail.action";

    url += "?pepr.id=" + $routeParams.peprId;

    $http.get(url).success(function(data) {
        $scope.pepr = data.pepr;
        $scope.tpesList = data.tpesList;
    });

    $scope.remove = function() {
        if (confirm("Are you sure?")) {
            var url = "estadistica/pepr-remove.action?pepr.id=" + $scope.pepr.id;

            $http.get(url).success(function(data) {
                $scope.actionErrors = data.actionErrors;

                if (data.actionErrors.length == 0) {
                    window.history.back();
                }
            });
        }
    }
})

.controller("cdmsDetailController", function($scope, $http, $location, $route, $routeParams) {
    var url = "estadistica/cdms-detail.action";

    url += "?pepr.id=" + $routeParams.peprId;

    $http.get(url).success(function(data) {
        $scope.pepr = data.pepr;
        $scope.cdmsMap = data.cdmsMap;
    });
})

.controller("estdGridController", function($scope, $http, $location, $routeParams, $modal) {
    $scope.itemCriterio = $routeParams.itemCriterio ? angular.fromJson($routeParams.itemCriterio) : {};
    $scope.itemCriterio.entiId = $routeParams.entiId;
    $scope.itemCriterio.pepr = {};
    $scope.itemCriterio.pepr.id = $routeParams.peprId;
    $scope.itemCriterio.pepr.autpId = $routeParams.autpId;

    function search(itemCriterio, page) {
        $scope.loading = true;

        $http.post("estadistica/estd-list.action", {
            itemCriterio : itemCriterio,
            page : page,
            limit : itemCriterio.limit
        }).success(function(data) {
            $scope.actionErrors = data.actionErrors;

            if (data.actionErrors.length == 0) {
                $scope.page = data.itemList.page;
                $scope.itemList = data.itemList;
                $scope.itemCriterio = data.itemCriterio;

                var map = {};

                map["page"] = data.itemList.page;
                map["itemCriterio"] = JSON.stringify(data.itemCriterio);

                $location.search(map).replace();
            }

            $scope.loading = false;
        });
    }

    $scope.pageChanged = function() {
        search($scope.itemCriterio, $scope.page);
    }

    $scope.filter = function(size) {
        var modalInstance = $modal.open({
            templateUrl : 'estd-filter-content.html',
            controller : 'estdFilterController',
            size : size,
            resolve : {
                itemCriterio : function() {
                    return $scope.itemCriterio;
                },
                enti : function() {
                    return $scope.enti;
                }
            }
        });

        modalInstance.result.then(function(itemCriterio) {
            console.log("estdGridController: " + JSON.stringify(itemCriterio));

            $scope.itemCriterio = itemCriterio;

            search($scope.itemCriterio, 1);
        });
    }

    $scope.search = function() {
        search($scope.itemCriterio, 1);
    }

    function findEnti() {
        var url = "metamodelo/tpes-proxy-detail.action?enti.id=" + $routeParams.entiId;

        $http.get(url).success(function(data) {
            $scope.enti = data.enti;
        });
    }

    findEnti();
    search($scope.itemCriterio, $routeParams.page ? $routeParams.page : 1);
})

.controller("estdFilterController", function($scope, $http, $modalInstance, enti, itemCriterio) {
    console.log("estdFilterController: " + JSON.stringify(itemCriterio));

    $scope.itemCriterio = itemCriterio;
    $scope.enti = enti;

    $scope.ok = function() {
        $modalInstance.close($scope.itemCriterio);
    };

    $scope.cancel = function() {
        $modalInstance.dismiss('cancel');
    };

    $http.get(
            "estadistica/estd-filter.action?itemCriterio.entiId=" + itemCriterio.entiId + "&itemCriterio.pepr.id="
                    + itemCriterio.pepr.id + "&itemCriterio.pepr.autpId=" + itemCriterio.pepr.autpId).success(
            function(data) {
                $scope.actionErrors = data.actionErrors;

                if (data.actionErrors.length == 0) {
                    $scope.labelValuesMap = data.labelValuesMap;
                    $scope.subpList = data.subpList;
                    $scope.limits = data.limits;
                    $scope.fechaVigencia = data.fechaVigencia;
                }
            });
})

.controller("estdDetailController", function($scope, $http, $location, $route, $routeParams) {
    function findEnti() {
        var url = "metamodelo/tpes-proxy-detail.action?enti.id=" + $routeParams.entiId;

        $http.get(url).success(function(data) {
            $scope.enti = data.enti;
        });
    }

    function findItem() {
        var url = "estadistica/estd-detail.action?item.id=" + $routeParams.itemId;

        $http.get(url).success(function(data) {
            $scope.item = data.item;
            $scope.fechaVigencia = data.fechaVigencia;
        });
    }

    findEnti();
    findItem();
});
