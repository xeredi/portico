angular.module("proceso", [ "ngRoute", "util" ])

.config(config)

.controller("prbtGridController", prbtGridController)

.controller("prbtFilterController", prbtFilterController)

.controller("prbtDetailController", prbtDetailController);

function config($routeProvider) {
    $routeProvider

    .when("/proceso/prbt/grid", {
        templateUrl : "modules/proceso/prbt-grid.html",
        controller : "prbtGridController",
        controllerAs : 'vm',
        reloadOnSearch : false
    })

    .when("/proceso/prbt/detail/:prbtId", {
        templateUrl : "modules/proceso/prbt-detail.html",
        controller : "prbtDetailController",
        controllerAs : 'vm'
    });
}

function prbtGridController($http, $location, $routeParams, $modal, pageTitleService) {
    var vm = this;

    vm.pageChanged = pageChanged;
    vm.filter = filter;

    vm.prbtCriterio = {};

    function search(prbtCriterio, page, limit) {
        var url = "proceso/prbt-list.action";

        vm.limit = limit;

        $http.post(url, {
            prbtCriterio : prbtCriterio,
            page : page,
            limit : limit
        }).success(function(data) {
            vm.page = data.prbtList.page;
            vm.prbtList = data.prbtList;
            vm.prbtCriterio = data.prbtCriterio;

            var map = {};

            map.page = data.prbtList.page;

            $location.search(map).replace();
        });
    }

    function pageChanged() {
        search(vm.prbtCriterio, vm.page, vm.limit);
    }

    function filter(size) {
        var modalInstance = $modal.open({
            templateUrl : 'modules/proceso/prbt-filter-content.html',
            controller : 'prbtFilterController',
            controllerAs : 'vm',
            size : size,
            resolve : {
                prbtCriterio : function() {
                    return vm.prbtCriterio;
                }
            }
        });

        modalInstance.result.then(function(prbtCriterio) {
            vm.prbtCriterio = prbtCriterio;
            vm.page = 1;

            search(vm.prbtCriterio, 1, vm.limit);
        });
    }

    search(vm.prbtCriterio, $routeParams.page ? $routeParams.page : 1, vm.limit);

    pageTitleService.setTitle("prbt", "page_grid");
}

function prbtFilterController($modalInstance, $http, prbtCriterio) {
    var vm = this;

    vm.ok = ok;
    vm.cancel = cancel;

    vm.prbtCriterio = prbtCriterio;

    function ok() {
        $modalInstance.close(vm.prbtCriterio);
    }

    function cancel() {
        $modalInstance.dismiss('cancel');
    }

    $http.get("proceso/prbt-filter.action").success(function(data) {
        vm.procesoTipos = data.procesoTipos;
        vm.procesoModulos = data.procesoModulos;
        vm.procesoEstados = data.procesoEstados;
    });
}

function prbtDetailController($http, $routeParams, pageTitleService) {
    var vm = this;

    $http.get("proceso/prbt-detail.action?prbt.id=" + $routeParams.prbtId).success(function(data) {
        vm.prbt = data.prbt;
    });

    $http.get("proceso/prmn-list.action?prbtId=" + $routeParams.prbtId).success(function(data) {
        vm.prmnList = data.prmnList;
    });

    pageTitleService.setTitle("prbt", "page_detail");
}
