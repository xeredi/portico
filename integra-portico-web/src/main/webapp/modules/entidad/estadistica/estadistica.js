angular.module("estadistica", [ "ngRoute", "util" ])

.config(config)

.controller("peprGridController", peprGridController)

.controller("peprFilterController", peprFilterController)

.controller("peprDetailController", peprDetailController)

.controller("cdmsDetailController", cdmsDetailController)

.controller("estdGridController", estdGridController)

.controller("estdFilterController", estdFilterController)

.controller("estdDetailController", estdDetailController);

function config($routeProvider) {
    $routeProvider

    .when("/estadistica/pepr/grid", {
        templateUrl : "modules/entidad/estadistica/pepr-grid.html",
        controller : "peprGridController",
        controllerAs : "vm",
        reloadOnSearch : false
    })

    .when("/estadistica/pepr/detail/:peprId", {
        templateUrl : "modules/entidad/estadistica/pepr-detail.html",
        controller : "peprDetailController",
        controllerAs : "vm"
    })

    .when("/estadistica/cdms/detail/:peprId", {
        templateUrl : "modules/entidad/estadistica/cdms-detail.html",
        controller : "cdmsDetailController",
        controllerAs : "vm"
    })

    .when("/estadistica/estd/grid/:entiId/:peprId/:autpId", {
        templateUrl : "modules/entidad/estadistica/estd-grid.html",
        controller : "estdGridController",
        controllerAs : "vm",
        reloadOnSearch : false
    })

    .when("/estadistica/estd/detail/:entiId/:itemId", {
        templateUrl : "modules/entidad/estadistica/estd-detail.html",
        controller : "estdDetailController",
        controllerAs : "vm"
    })
}

function peprGridController($http, $location, $routeParams, $modal, pageTitleService) {
    var vm = this;

    vm.pageChanged = pageChanged;
    vm.filter = filter;

    vm.peprCriterio = {};

    function search(peprCriterio, page, limit) {
        $http.post("estadistica/pepr-list.action", {
            peprCriterio : peprCriterio,
            page : page,
            limit : limit
        }).success(function(data) {
            vm.actionErrors = data.actionErrors;

            if (data.actionErrors.length == 0) {
                vm.page = data.peprList.page;
                vm.peprList = data.peprList;

                var map = {};

                map["page"] = data.peprList.page;

                $location.search(map).replace();
            }
        });
    }

    function pageChanged() {
        search(vm.peprCriterio, vm.page, vm.limit);
    }

    function filter(size) {
        var modalInstance = $modal.open({
            templateUrl : 'modules/entidad/estadistica/pepr-filter-content.html',
            controller : 'peprFilterController',
            controllerAs : 'vm',
            size : size,
            resolve : {
                peprCriterio : function() {
                    return vm.peprCriterio;
                }
            }
        });

        modalInstance.result.then(function(peprCriterio) {
            vm.peprCriterio = peprCriterio;
            vm.page = 1;

            search(vm.peprCriterio, 1, vm.limit);
        });
    }

    search(vm.peprCriterio, $routeParams.page ? $routeParams.page : 1, vm.limit);

    pageTitleService.setTitle("pepr", "page_grid");
}

function peprFilterController($modalInstance, $http, peprCriterio) {
    var vm = this;

    vm.ok = ok;
    vm.cancel = cancel;

    vm.peprCriterio = peprCriterio;

    function ok() {
        $modalInstance.close(vm.peprCriterio);
    }

    function cancel() {
        $modalInstance.dismiss('cancel');
    }

    $http.get("estadistica/pepr-filter.action").success(function(data) {
        vm.actionErrors = data.actionErrors;

        if (data.actionErrors.length == 0) {
            vm.autpList = data.autpList;
            vm.limits = data.limits;
        }
    });
}

function peprDetailController($http, $routeParams, pageTitleService) {
    var vm = this;

    vm.remove = remove;

    function remove() {
        if (confirm("Are you sure?")) {
            var url = "estadistica/pepr-remove.action?pepr.id=" + vm.pepr.id;

            $http.get(url).success(function(data) {
                vm.actionErrors = data.actionErrors;

                if (data.actionErrors.length == 0) {
                    window.history.back();
                }
            });
        }
    }

    $http.get("estadistica/pepr-detail.action?pepr.id=" + $routeParams.peprId).success(function(data) {
        vm.pepr = data.pepr;
        vm.tpesList = data.tpesList;
    });

    pageTitleService.setTitle("pepr", "page_detail");
}

function cdmsDetailController($http, $routeParams, pageTitleService) {
    var vm = this;

    $http.get("estadistica/cdms-detail.action?pepr.id=" + $routeParams.peprId).success(function(data) {
        vm.pepr = data.pepr;
        vm.cdmsMap = data.cdmsMap;
    });

    pageTitleService.setTitle("cdms", "page_detail");
}

function estdGridController($scope, $http, $location, $routeParams, $modal, pageTitleService) {
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
}

function estdFilterController($scope, $http, $modalInstance, enti, itemCriterio) {
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
}

function estdDetailController($scope, $http, $location, $routeParams, pageTitleService) {
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
}