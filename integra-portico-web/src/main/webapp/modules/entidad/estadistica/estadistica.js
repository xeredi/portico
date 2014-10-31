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
    });
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
            vm.page = data.peprList.page;
            vm.peprList = data.peprList;

            var map = {};

            map.page = data.peprList.page;

            $location.search(map).replace();
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
        vm.autpList = data.autpList;
        vm.limits = data.limits;
    });
}

function peprDetailController($http, $routeParams, pageTitleService) {
    var vm = this;

    vm.remove = remove;

    function remove() {
        if (confirm("Are you sure?")) {
            var url = "estadistica/pepr-remove.action?pepr.id=" + vm.pepr.id;

            $http.get(url).success(function(data) {
                window.history.back();
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

function estdGridController($http, $location, $routeParams, $modal, pageTitleService) {
    var vm = this;

    vm.pageChanged = pageChanged;
    vm.filter = filter;

    vm.itemCriterio = $routeParams.itemCriterio ? angular.fromJson($routeParams.itemCriterio) : {};
    vm.itemCriterio.entiId = $routeParams.entiId;
    vm.itemCriterio.pepr = {};
    vm.itemCriterio.pepr.id = $routeParams.peprId;
    vm.itemCriterio.pepr.autpId = $routeParams.autpId;

    function search(itemCriterio, page) {
        $http.post("estadistica/estd-list.action", {
            itemCriterio : itemCriterio,
            page : page,
            limit : itemCriterio.limit
        }).success(function(data) {
            vm.enti = data.enti;
            vm.page = data.itemList.page;
            vm.itemList = data.itemList;
            vm.itemCriterio = data.itemCriterio;

            var map = {};

            map.page = data.itemList.page;
            map.itemCriterio = JSON.stringify(data.itemCriterio);

            $location.search(map).replace();
        });
    }

    function pageChanged() {
        search(vm.itemCriterio, vm.page);
    }

    function filter(size) {
        var modalInstance = $modal.open({
            templateUrl : 'modules/entidad/estadistica/estd-filter-content.html',
            controller : 'estdFilterController',
            controllerAs : 'vm',
            size : size,
            resolve : {
                itemCriterio : function() {
                    return vm.itemCriterio;
                },
                enti : function() {
                    return vm.enti;
                }
            }
        });

        modalInstance.result.then(function(itemCriterio) {
            vm.itemCriterio = itemCriterio;

            search(vm.itemCriterio, 1);
        });
    }

    search(vm.itemCriterio, $routeParams.page ? $routeParams.page : 1);

    pageTitleService.setTitleEnti($routeParams.entiId, "page_grid");
}

function estdFilterController($http, $modalInstance, enti, itemCriterio) {
    var vm = this;

    vm.ok = ok;
    vm.cancel = cancel;

    vm.itemCriterio = itemCriterio;
    vm.enti = enti;

    function ok() {
        $modalInstance.close(vm.itemCriterio);
    }

    function cancel() {
        $modalInstance.dismiss('cancel');
    }

    $http.get(
            "estadistica/estd-filter.action?itemCriterio.entiId=" + itemCriterio.entiId + "&itemCriterio.pepr.id="
                    + itemCriterio.pepr.id + "&itemCriterio.pepr.autpId=" + itemCriterio.pepr.autpId).success(
            function(data) {
                vm.labelValuesMap = data.labelValuesMap;
                vm.subpList = data.subpList;
                vm.limits = data.limits;
                vm.fechaVigencia = data.fechaVigencia;
            });
}

function estdDetailController($http, $routeParams, pageTitleService) {
    var vm = this;

    $http.get("estadistica/estd-detail.action?item.id=" + $routeParams.itemId).success(function(data) {
        vm.enti = data.enti;
        vm.item = data.item;
        vm.fechaVigencia = data.fechaVigencia;
    });

    pageTitleService.setTitleEnti($routeParams.entiId, "page_detail");
}