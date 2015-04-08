angular.module("proceso", [])

.config(config)

.controller("PrbtGridController", PrbtGridController)

.controller("PrbtDetailController", PrbtDetailController)

;

function config($routeProvider) {
    $routeProvider

    .when("/proceso/prbt/grid", {
        templateUrl : "modules/proceso/prbt-grid.html",
        controller : "PrbtGridController",
        controllerAs : 'vm',
        reloadOnSearch : false
    })

    .when("/proceso/prbt/detail/:prbtId", {
        templateUrl : "modules/proceso/prbt-detail.html",
        controller : "PrbtDetailController",
        controllerAs : 'vm'
    });
}

function PrbtGridController($http, $location, $routeParams, $modal, pageTitleService) {
    var vm = this;

    vm.search = search;
    vm.pageChanged = pageChanged;
    vm.filter = filter;

    vm.prbtCriterio = $routeParams.prbtCriterio ? angular.fromJson($routeParams.prbtCriterio) : {};

    function search(page) {
        $http.post("proceso/prbt-list.action", {
            model : vm.prbtCriterio,
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

function PrbtDetailController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.cancel = cancel;
    vm.download = download;

    function cancel() {
        $http.post("proceso/prbt-cancel.action", {
            prbt : {
                id : vm.prbt.id
            }
        }).success(function(data) {
            window.history.back();
        });
    }

    function download(archId, archNombre) {
        $http.post('proceso/prar-download.action', {
            prar : {
                prbtId : vm.prbt.id,
                archId : archId
            }
        }, {
            responseType : 'arraybuffer'
        }).success(function(data) {
            var file = new Blob([ data ]);

            setTimeout(function() {
                saveAs(file, archNombre);
            }, 0);
        });
    }

    $http.post("proceso/prbt-detail.action", {
        prbt : {
            id : $routeParams.prbtId
        }
    }).success(function(data) {
        vm.prbt = data.prbt;
        vm.arinEntradaList = data.arinEntradaList;
        vm.arinSalidaList = data.arinSalidaList;
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
