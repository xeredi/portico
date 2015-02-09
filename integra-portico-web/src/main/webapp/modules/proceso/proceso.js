angular.module("proceso", [ "ngRoute", "util" ])

.config(config)

.controller("prbtGridController", prbtGridController)

.controller("prbtDetailController", prbtDetailController)

;

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

    vm.search = search;
    vm.pageChanged = pageChanged;
    vm.filter = filter;

    vm.prbtCriterio = $routeParams.prbtCriterio ? angular.fromJson($routeParams.prbtCriterio) : {};
    vm.page = $routeParams.page ? $routeParams.page : 1;

    function search(page) {
        $http.post("proceso/prbt-list.action", {
            prbtCriterio : vm.prbtCriterio,
            page : page,
            limit : vm.limit
        }).success(function(data) {
            vm.prbtList = data.prbtList;
            vm.page = data.prbtList.page;

            $location.search({
                page : vm.page,
                prbtCriterio : JSON.stringify(vm.prbtCriterio)
            }).replace();
        });
    }

    function pageChanged() {
        search(vm.page);
    }

    function filter(size) {
        $http.post("proceso/prbt-filter.action").success(function(data) {
            vm.procesoTipos = data.procesoTipos;
            vm.procesoModulos = data.procesoModulos;
            vm.procesoEstados = data.procesoEstados;
        });
    }

    search($routeParams.page ? $routeParams.page : 1);
    pageTitleService.setTitle("prbt", "page_grid");
}

function prbtDetailController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.cancel = cancel;

    function cancel() {
        $http.post("proceso/prbt-cancel.action", {
            prbt : {
                id : vm.prbt.id
            }
        }).success(function(data) {
            window.history.back();
        });
    }

    $http.post("proceso/prbt-detail.action", {
        prbt : {
            id : $routeParams.prbtId
        }
    }).success(function(data) {
        vm.prbt = data.prbt;
        vm.prarEntradaList = data.prarEntradaList;
        vm.prarSalidaList = data.prarSalidaList;
        vm.pritEntradaList = data.pritEntradaList;
        vm.pritSalidaList = data.pritSalidaList;
        vm.prpmMap = data.prpmMap;

        $http.post("proceso/prmn-list.action", {
            prbtId : $routeParams.prbtId
        }).success(function(data) {
            vm.prmnList = data.prmnList;
        });
    });

    pageTitleService.setTitle("prbt", "page_detail");
}
