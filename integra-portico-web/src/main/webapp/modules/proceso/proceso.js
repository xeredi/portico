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
        controllerAs : 'vm',
        reloadOnSearch : false

    });
}

function PrbtGridController($http, $location, $routeParams, $modal, pageTitleService) {
    var vm = this;

    vm.search = search;
    vm.pageChanged = pageChanged;
    vm.filter = filter;
    vm.xlsExport = xlsExport;

    vm.prbtCriterio = $routeParams.prbtCriterio ? angular.fromJson($routeParams.prbtCriterio) : {};

    function search(page) {
        $http.post("proceso/proceso-list.action", {
            model : vm.prbtCriterio,
            page : page,
            limit : vm.limit
        }).success(function(data) {
            vm.prbtList = data.resultList;
            vm.page = data.resultList.page;

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
        $http.post("proceso/proceso-filter.action", {
            model : vm.prbtCriterio
        }).success(function(data) {
            vm.procesoTipos = data.procesoTipos;
            vm.procesoModulos = data.procesoModulos;
            vm.procesoEstados = data.procesoEstados;
        });
    }

    function xlsExport() {
        $http.post('proceso/proceso-xls-export.action', {
            criterio : vm.prbtCriterio
        }, {
            responseType : 'arraybuffer'
        }).success(function(data) {
            var file = new Blob([ data ], {
                type : 'application/xls'
            });

            setTimeout(function() {
                saveAs(file, 'prbt.xls');
            }, 0);
        });
    }

    search($routeParams.page ? $routeParams.page : 1);
    pageTitleService.setTitle("prbt", "page_grid");
}

function PrbtDetailController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.cancel = cancel;
    vm.download = download;
    vm.pageChanged = pageChanged;

    function cancel() {
        $http.post("proceso/proceso-cancelar.action", {
            model : vm.prbt
        }).success(function(data) {
            window.history.back();
        });
    }

    function download(archId, archNombre) {
        $http.post('proceso/proceso-archivo-zip-export.action', {
            model : {
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

    function pageChanged() {
        search(vm.page);
    }

    function search(page) {
        $http.post("proceso/proceso-mensaje-list.action", {
            model : {
                prbtId : $routeParams.prbtId
            },
            page : page
        }).success(function(data) {
            vm.prmnList = data.resultList;
            vm.page = data.resultList.page;

            $location.search({
                page : vm.page
            }).replace();
        });
    }

    $http.post("proceso/proceso-detail.action", {
        model : {
            id : $routeParams.prbtId
        }
    }).success(function(data) {
        vm.prbt = data.model;
        vm.arinEntradaList = data.arinEntradaList;
        vm.arinSalidaList = data.arinSalidaList;
        vm.pritEntradaList = data.pritEntradaList;
        vm.pritSalidaList = data.pritSalidaList;
        vm.prpmMap = data.prpmMap;

        search($routeParams.page ? $routeParams.page : 1);
    });

    pageTitleService.setTitle("prbt", "page_detail");
}
