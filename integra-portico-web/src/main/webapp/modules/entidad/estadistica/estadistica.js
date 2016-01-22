angular.module("estadistica", [])

.config(config)

.controller("PeprGridController", PeprGridController)

.controller("PeprDetailController", PeprDetailController)

.controller("PeprEditController", PeprEditController)

.controller("CdmsDetailController", CdmsDetailController)

.controller("EstdGridController", EstdGridController)

.controller("EstdDetailController", EstdDetailController);

function config($routeProvider) {
    $routeProvider

    .when("/estadistica/pepr/grid", {
        templateUrl : "modules/entidad/estadistica/pepr-grid.html",
        controller : "PeprGridController as vm",
        reloadOnSearch : false
    })

    .when("/estadistica/pepr/detail/:peprId", {
        templateUrl : "modules/entidad/estadistica/pepr-detail.html",
        controller : "PeprDetailController as vm"
    })

    .when("/estadistica/pepr/edit/:accion", {
        templateUrl : "modules/entidad/estadistica/pepr-edit.html",
        controller : "PeprEditController as vm"
    })

    .when("/estadistica/cdms/detail/:peprId", {
        templateUrl : "modules/entidad/estadistica/cdms-detail.html",
        controller : "CdmsDetailController as vm"
    })

    .when("/estadistica/estd/grid/:entiId/:peprId/:autpId", {
        templateUrl : "modules/entidad/estadistica/estd-grid.html",
        controller : "EstdGridController as vm",
        reloadOnSearch : false
    })

    .when("/estadistica/estd/detail/:entiId/:itemId", {
        templateUrl : "modules/entidad/estadistica/estd-detail.html",
        controller : "EstdDetailController as vm"
    });
}

function PeprGridController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.search = search;
    vm.pageChanged = pageChanged;
    vm.filter = filter;

    initialize();

    function initialize() {
        vm.peprCriterio = $routeParams.peprCriterio ? angular
                .fromJson($routeParams.peprCriterio) : {};

        search($routeParams.page ? $routeParams.page : 1);

        pageTitleService.setTitle("pepr", "page_grid");
    }

    function search(page) {
        $http.post("estadistica/periodo-proceso-list.action", {
            model : vm.peprCriterio,
            page : page,
            limit : vm.peprCriterio.limit
        }).success(function(data) {
            vm.peprList = data.resultList;
            vm.page = data.resultList.page;

            $location.search({
                page : vm.page,
                peprCriterio : JSON.stringify(vm.peprCriterio)
            }).replace();
        });
    }

    function pageChanged() {
        search(vm.page);
    }

    function filter(size) {
        $http.post("estadistica/periodo-proceso-filter.action", {
            model : vm.peprCriterio
        }).success(function(data) {
            vm.sprtList = data.sprtList;
            vm.limits = data.limits;
        });
    }
}

function PeprDetailController($http, $routeParams, pageTitleService) {
    var vm = this;

    vm.remove = remove;
    vm.oppeExport = oppeExport;

    initialize();

    function initialize() {
        $http.post("estadistica/periodo-proceso-detail.action", {
            model : {
                id : $routeParams.peprId
            }
        }).success(function(data) {
            vm.pepr = data.model;
            vm.tpesList = data.tpesList;
        });

        pageTitleService.setTitle("pepr", "page_detail");
    }

    function oppeExport() {
        $http.post('estadistica/periodo-proceso-zip-export.action', {
            model : vm.pepr
        }, {
            responseType : 'arraybuffer'
        }).success(function(data) {
            var file = new Blob([ data ], {
                type : 'application/zip'
            });

            setTimeout(function() {
                saveAs(file, vm.pepr.filename + '.zip');
            }, 0);
        });
    }

    function remove() {
        if (confirm("Are you sure?")) {
            $http.post("estadistica/periodo-proceso-remove.action", {
                model : vm.pepr
            }).success(function(data) {
                window.history.back();
            });
        }
    }
}

function PeprEditController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    initialize();

    function initialize() {
        vm.accion = $routeParams.accion;

        $http.post("estadistica/periodo-proceso-edit.action", {
            accion : vm.accion
        }).success(function(data) {
            vm.pepr = data.model;
            vm.sprtList = data.sprtList;
        });

        pageTitleService.setTitle("pepr", "page_" + vm.accion);
    }

    function save() {
        $http.post("estadistica/periodo-proceso-save.action", {
            model : vm.pepr,
            file : vm.file,
            sobreescribir : vm.sobreescribir,
            accion : vm.accion
        }).success(function(data) {
            $location.path("/proceso/prbt/grid").replace();
        });
    }

    function cancel() {
        window.history.back();
    }
}

function CdmsDetailController($http, $routeParams, pageTitleService) {
    var vm = this;

    initialize();

    function initialize() {
        $http.post("estadistica/cuadro-mes-detail.action", {
            pepr : {
                id : $routeParams.peprId
            }
        }).success(function(data) {
            vm.pepr = data.pepr;
            vm.cdmsMap = data.cdmsMap;
        });

        pageTitleService.setTitle("cdms", "page_detail");
    }
}

function EstdGridController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.search = search;
    vm.pageChanged = pageChanged;
    vm.filter = filter;
    vm.xlsExport = xlsExport;

    initialize();

    function initialize() {
        vm.itemCriterio = $routeParams.itemCriterio ? angular
                .fromJson($routeParams.itemCriterio) : {};
        vm.itemCriterio.entiId = $routeParams.entiId;
        vm.itemCriterio.pepr = {};
        vm.itemCriterio.pepr.id = $routeParams.peprId;
        vm.itemCriterio.pepr.sprtId = $routeParams.autpId;

        search($routeParams.page ? $routeParams.page : 1);

        pageTitleService.setTitleEnti($routeParams.entiId, "page_grid");
    }

    function search(page) {
        $http.post("estadistica/estadistica-list.action", {
            model : vm.itemCriterio,
            page : page,
            limit : vm.itemCriterio.limit
        }).success(function(data) {
            vm.enti = data.enti;
            vm.page = data.resultList.page;
            vm.itemList = data.resultList;
            vm.itemCriterio = data.model;

            $location.search({
                page : vm.page,
                itemCriterio : JSON.stringify(vm.itemCriterio)
            }).replace();
        });
    }

    function pageChanged() {
        search(vm.page);
    }

    function xlsExport() {
        $http.post('estadistica/estadistica-xls-export.action', {
            criterio : vm.itemCriterio
        }, {
            responseType : 'arraybuffer'
        }).success(function(data) {
            var file = new Blob([ data ], {
                type : 'application/xls'
            });

            setTimeout(function() {
                saveAs(file, 'estd_' + vm.itemCriterio.entiId + '.xls');
            }, 0);
        });
    }

    function filter(size) {
        $http.post("estadistica/estadistica-filter.action", {
            model : vm.itemCriterio
        }).success(function(data) {
            vm.labelValuesMap = data.labelValuesMap;
            vm.prtoList = data.prtoList;
            vm.limits = data.limits;
            vm.fechaVigencia = data.fechaVigencia;
        });
    }
}

function EstdDetailController($http, $routeParams, pageTitleService) {
    var vm = this;

    initialize();

    function initialize() {
        $http.post("estadistica/estadistica-detail.action", {
            model : {
                id : $routeParams.itemId,
                entiId : $routeParams.entiId
            }
        }).success(function(data) {
            vm.item = data.model;
            vm.enti = data.enti;
            vm.fechaVigencia = data.model.fref;
        });

        pageTitleService.setTitleEnti($routeParams.entiId, "page_detail");
    }
}