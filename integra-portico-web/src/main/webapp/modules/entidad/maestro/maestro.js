angular.module("maestro", [ "ngRoute", "util" ])

.config(config)

.factory('tpprService', tpprService)

.factory('prmtService', prmtService)

.factory('sprmService', sprmService)

// ----------------- MENU PRINCIPAL --------------------------
.controller("maestroController", maestroController)

// ----------- PARAMETROS ------------------
.controller("prmtGridController", prmtGridController)

.controller("prmtFilterController", prmtFilterController)

.controller("prmtDetailController", prmtDetailController)

.controller("prmtCreateController", prmtCreateController)

.controller("prmtEditController", prmtEditController)

.controller("prmtDuplicateController", prmtDuplicateController)

.controller('prmtsLupaCtrl', prmtsLupaCtrl)

// ----------- SUBPARAMETROS ------------------
.controller("sprmDetailController", sprmDetailController)

.controller("sprmCreateController", sprmCreateController)

.controller("sprmEditController", sprmEditController)

.controller("sprmDuplicateController", sprmDuplicateController);

function config($routeProvider) {
    $routeProvider

    .when("/maestro", {
        title : 'maestro_main',
        templateUrl : "modules/entidad/maestro/maestro.html",
        controller : "maestroController",
        controllerAs : 'vm'
    })

    .when("/maestro/prmt/grid/:entiId", {
        templateUrl : "modules/entidad/maestro/prmt-grid.html",
        controller : "prmtGridController",
        controllerAs : 'vm',
        reloadOnSearch : false
    })

    .when("/maestro/prmt/grid/:entiId/:page", {
        templateUrl : "modules/entidad/maestro/prmt-grid.html",
        controller : "prmtGridController",
        controllerAs : 'vm',
        reloadOnSearch : false
    })

    .when("/maestro/prmt/create/:entiId", {
        templateUrl : "modules/entidad/maestro/prmt-edit.html",
        controller : "prmtCreateController",
        controllerAs : 'vm'
    })

    .when("/maestro/prmt/detail/:entiId/:itemId/:fechaVigencia", {
        templateUrl : "modules/entidad/maestro/prmt-detail.html",
        controller : "prmtDetailController",
        controllerAs : 'vm',
        reloadOnSearch : false
    })

    .when("/maestro/prmt/detail/:entiId/:itemId", {
        templateUrl : "modules/entidad/maestro/prmt-detail.html",
        controller : "prmtDetailController",
        controllerAs : 'vm',
        reloadOnSearch : false
    })

    .when("/maestro/prmt/edit/:entiId/:itemId/:fechaVigencia", {
        templateUrl : "modules/entidad/maestro/prmt-edit.html",
        controller : "prmtEditController",
        controllerAs : 'vm'
    })

    .when("/maestro/prmt/duplicate/:entiId/:itemId/:fechaVigencia", {
        templateUrl : "modules/entidad/maestro/prmt-edit.html",
        controller : "prmtDuplicateController",
        controllerAs : 'vm',
        reloadOnSearch : false
    })

    .when("/maestro/sprm/create/:entiId/:prmtId/:fechaVigencia", {
        templateUrl : "modules/entidad/maestro/sprm-edit.html",
        controller : "sprmCreateController",
        controllerAs : 'vm'
    })

    .when("/maestro/sprm/edit/:entiId/:itemId/:fechaVigencia", {
        templateUrl : "modules/entidad/maestro/sprm-edit.html",
        controller : "sprmEditController",
        controllerAs : 'vm'
    })

    .when("/maestro/sprm/duplicate/:entiId/:itemId/:fechaVigencia", {
        templateUrl : "modules/entidad/maestro/sprm-edit.html",
        controller : "sprmDuplicateController",
        controllerAs : 'vm'
    })

    .when("/maestro/sprm/detail/:entiId/:itemId/:fechaVigencia", {
        templateUrl : "modules/entidad/maestro/sprm-detail.html",
        controller : "sprmDetailController",
        controllerAs : 'vm'
    })
}

function tpprService($http) {
    return {
        getEntiList : getEntiList
    };

    function getEntiList() {
        return $http.get('maestro/tppr-list.action').then(getTpprListComplete);

        function getTpprListComplete(response) {
            return response.data.tpprList;
        }
    }
}

function prmtService($http) {
    return {
        search : search,
        filter : filter,
        detail : detail
    };

    function search(entiId, itemCriterio, page, limit) {
        return $http.post("maestro/prmt-list.action?enti.id=" + entiId, {
            itemCriterio : itemCriterio,
            page : page,
            limit : itemCriterio.limit
        }).then(searchComplete);

        function searchComplete(response) {
            return response.data;
        }
    }

    function filter(entiId) {
        return $http.get("maestro/prmt-filter.action?enti.id=" + entiId).then(searchComplete);

        function searchComplete(response) {
            return response.data;
        }
    }

    function detail(itemId, fechaVigencia) {
        return $http.get("maestro/prmt-detail.action?item.id=" + itemId + "&item.fref=" + fechaVigencia).then(
                searchComplete);

        function searchComplete(response) {
            return response.data;
        }
    }
}

function sprmService($http) {
    return {
        search : search
    };

    function search(subentiId, prmtId, page, fechaVigencia) {
        return $http.get(
                "maestro/sprm-list.action?itemCriterio.entiId=" + subentiId + "&page=" + page
                        + "&itemCriterio.prmt.id=" + prmtId + "&itemCriterio.fechaVigencia=" + fechaVigencia).then(
                searchComplete);

        function searchComplete(response) {
            return response.data;
        }
    }
}

function maestroController(tpprService) {
    var vm = this;

    tpprService.getEntiList().then(function(data) {
        vm.tpprList = data;
    });
}

function prmtGridController($location, $routeParams, $modal, prmtService, pageTitleService) {
    var vm = this;

    vm.pageChanged = pageChanged;
    vm.filter = filter;

    vm.itemCriterio = $routeParams.itemCriterio ? angular.fromJson($routeParams.itemCriterio) : {};
    vm.page = $routeParams.page ? $routeParams.page : 1;

    function search() {
        vm.loading = true;

        prmtService.search($routeParams.entiId, vm.itemCriterio, vm.page, 20).then(function(data) {
            vm.actionErors = data.actionErors;
            vm.itemList = data.itemList;
            vm.enti = data.enti;

            if (data.actionErrors.length == 0) {
                // alert("Replace");

                $location.search({
                    page : vm.page,
                    itemCriterio : JSON.stringify(data.itemCriterio)
                }).replace();

                vm.loading = false;
            }
        });
        /*
         * $http.post("maestro/prmt-list.action", { entiId :
         * itemCriterio.entiId, itemCriterio : itemCriterio, page : page, limit :
         * itemCriterio.limit }).success(function(data) { vm.actionErrors =
         * data.actionErrors;
         *
         * if (data.actionErrors.length == 0) { vm.page = data.itemList.page;
         * vm.itemList = data.itemList; vm.itemCriterio = data.itemCriterio;
         *
         * var map = {};
         *
         * map["page"] = data.itemList.page; map["itemCriterio"] =
         * JSON.stringify(data.itemCriterio);
         *
         * $location.search(map).replace(); }
         *
         * vm.loading = false; });
         */
    }

    function pageChanged() {
        search();
    }

    function filter(size) {
        var modalInstance = $modal.open({
            templateUrl : 'prmt-filter-content.html',
            controller : 'prmtFilterController',
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
            console.log("prmtGridController: " + JSON.stringify(itemCriterio));

            vm.itemCriterio = itemCriterio;
            vm.page = 1;

            search();
        });
    }

    search();
    pageTitleService.setTitle($routeParams.entiId, "page_item_grid");
}

function prmtFilterController($modalInstance, enti, itemCriterio, prmtService) {
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

    prmtService.filter(vm.enti.id).then(function(data) {
        vm.actionErors = data.actionErors;

        if (data.actionErrors.length == 0) {
            vm.labelValuesMap = data.labelValuesMap;
            vm.limits = data.limits;
        }
    });
}

function prmtDetailController($http, $location, $routeParams, prmtService, sprmService, pageTitleService) {
    var vm = this;

    vm.pageChanged = pageChanged;
    vm.tabSelected = tabSelected;
    vm.remove = remove;
    vm.print = print;

    // var path = $location.path();
    // var tabSelected = $routeParams.tabSelected;
    // var itemId = $routeParams.itemId;
    // var entiId = $routeParams.entiId;
    // var fechaVigencia = $routeParams.fechaVigencia;
    // var pageMap = $routeParams.pageMap ?
    // angular.fromJson($routeParams.pageMap) : {};

    vm.pageMap = {};

    prmtService.detail($routeParams.itemId, $routeParams.fechaVigencia).then(
            function(data) {
                vm.actionErors = data.actionErors;

                if (data.actionErrors.length == 0) {
                    vm.enti = data.enti;
                    vm.item = data.item;
                    vm.availableLanguages = data.availableLanguages;
                    vm.i18nMap = data.i18nMap;
                    vm.itemHijosMap = {};
                    vm.entiHijasMap = {};

                    if (vm.enti.entiHijasList) {
                        for (i = 0; i < vm.enti.entiHijasList.length; i++) {
                            sprmService.search(vm.enti.entiHijasList[i], vm.item.id, 1, $routeParams.fechaVigencia)
                                    .then(function(data) {
                                        vm.actionErors = data.actionErors;

                                        if (data.actionErrors.length == 0) {
                                            vm.entiHijasMap[data.enti.id] = data.enti;
                                            vm.itemHijosMap[data.enti.id] = data.itemList;
                                        }
                                    });
                        }
                    }
                }
            });

    // function findItem() {
    // $http.get("metamodelo/tppr-proxy-detail.action?includeDependencies=true&enti.id="
    // + entiId).success(
    // function(data) {
    // vm.enti = data.enti;
    // vm.subentiList = data.subentiList;
    // vm.availableLanguages = data.availableLanguages;
    //
    // if (tabSelected) {
    // vm.subentiList[tabSelected].active = true;
    // }
    //
    // $http.get("maestro/prmt-detail.action?item.id=" + itemId + "&item.fref="
    // + fechaVigencia).success(
    // function(data) {
    // vm.item = data.item;
    // vm.i18nMap = data.i18nMap;
    // vm.fechaVigencia = data.fechaVigencia;
    // });
    //
    // vm.itemHijosMap = {};
    //
    // for (i = 0; i < vm.subentiList.length; i++) {
    // var subenti = vm.subentiList[i];
    //
    // findSublist(subenti.id, pageMap[subenti.id] ? pageMap[subenti.id] : 1);
    // }
    // });
    // }

    // function findSublist(subentiId, page) {
    // var url = "maestro/sprm-list.action?itemCriterio.entiId=" + subentiId +
    // "&page=" + page
    // + "&itemCriterio.prmt.id=" + itemId + "&itemCriterio.fechaVigencia=" +
    // fechaVigencia;
    //
    // $http.get(url).success(function(data) {
    // vm.actionErrors = data.actionErrors;
    //
    // if (data.actionErrors.length == 0) {
    // vm.itemHijosMap[data.itemCriterio.entiId] = data.itemList;
    // vm.pageMap[data.itemCriterio.entiId] = data.itemList.page;
    // vm.search("pageMap", JSON.stringify(vm.pageMap)).replace();
    // }
    // });
    // }

    function pageChanged(subentiId) {
        // findSublist(subentiId, vm.pageMap[subentiId]);
    }

    function tabSelected(tabNo) {
        // if (path == $location.path()) {
        // $location.search("tabSelected", tabNo).replace();
        // }
    }

    function remove() {
        if (confirm("Are you sure?")) {
            var url = "maestro/prmt-remove.action?item.prvr.id=" + vm.item.prvr.id;

            $http.get(url).success(function(data) {
                vm.actionErrors = data.actionErrors;

                if (data.actionErrors.length == 0) {
                    window.history.back();
                }
            });
        }
    }

    function print() {
        $http.get('maestro/prmt-print.action?item.id=' + vm.item.id, null, {
            responseType : 'arraybuffer'
        }).success(function(data) {
            var file = new Blob([ data ], {
                type : 'application/pdf'
            });
            var fileURL = URL.createObjectURL(file);
            window.open(fileURL);
        });
    }

    // findItem();

    pageTitleService.setTitle($routeParams.entiId, "page_item_detail");
}

function prmtCreateController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        var url = "maestro/prmt-save.action";

        $http.post(url, {
            item : vm.item,
            i18nMap : vm.i18nMap,
            accion : vm.accion
        }).success(
                function(data) {
                    vm.actionErrors = data.actionErrors;

                    if (data.actionErrors.length == 0) {
                        $location.path(
                                "/maestro/prmt/detail/" + data.item.entiId + "/" + data.item.id + "/"
                                        + data.item.prvr.fini).replace();
                    }
                });
    }

    function cancel() {
        window.history.back();
    }

    $http.get("maestro/prmt-create.action?item.entiId=" + $routeParams.entiId).success(function(data) {
        vm.enti = data.enti;
        vm.availableLanguages = data.availableLanguages;
        vm.item = data.item;
        vm.i18nMap = data.i18nMap;
        vm.labelValuesMap = data.labelValuesMap;
        vm.accion = data.accion;
    });

    pageTitleService.setTitle($routeParams.entiId, "page_item_create");
}

function prmtEditController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        var url = "maestro/prmt-save.action";

        $http.post(url, {
            item : vm.item,
            i18nMap : vm.i18nMap,
            accion : vm.accion
        }).success(function(data) {
            $scope.actionErrors = data.actionErrors;

            if (data.actionErrors.length == 0) {
                setTimeout(function() {
                    window.history.back();
                }, 0);
            }
        });
    }

    function cancel() {
        window.history.back();
    }

    $http.get("maestro/prmt-edit.action?item.id=" + $routeParams.itemId + "&item.fref=" + $routeParams.fechaVigencia)
            .success(function(data) {
                vm.enti = data.enti;
                vm.availableLanguages = data.availableLanguages;
                vm.item = data.item;
                vm.i18nMap = data.i18nMap;
                vm.labelValuesMap = data.labelValuesMap;
                vm.accion = data.accion;
            });

    pageTitleService.setTitle($routeParams.entiId, "page_item_edit");
}

function prmtDuplicateController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        var url = "maestro/prmt-save.action";

        $http.post(url, {
            item : vm.item,
            i18nMap : vm.i18nMap,
            accion : vm.accion
        }).success(
                function(data) {
                    vm.actionErrors = data.actionErrors;

                    if (data.actionErrors.length == 0) {
                        $location.path(
                                "/maestro/prmt/detail/" + data.item.entiId + "/" + data.item.id + "/"
                                        + data.item.prvr.fini).replace();
                    }
                });
    }

    function cancel() {
        window.history.back();
    }

    $http
            .get(
                    "maestro/prmt-duplicate.action?item.id=" + $routeParams.itemId + "&item.fref="
                            + $routeParams.fechaVigencia).success(function(data) {
                vm.enti = data.enti;
                vm.availableLanguages = data.availableLanguages;
                vm.item = data.item;
                vm.i18nMap = data.i18nMap;
                vm.labelValuesMap = data.labelValuesMap;
                vm.accion = data.accion;
            });

    pageTitleService.setTitle($routeParams.entiId, "page_item_duplicate");
}

function prmtsLupaCtrl($http, $scope) {
    $scope.getLabelValues = function(entiId, textoBusqueda, fechaVigencia) {
        return $http.get(
                'maestro/prmt-lupa.action?itemLupaCriterio.entiId=' + entiId + "&itemLupaCriterio.textoBusqueda="
                        + textoBusqueda + "&itemLupaCriterio.fechaVigencia=" + fechaVigencia).then(function(res) {
            return res.data.itemList;
        });
    };
}

function sprmDetailController($http, $routeParams, pageTitleService) {
    var vm = this;

    vm.remove = remove;

    function remove() {
        if (confirm("Are you sure?")) {
            var url = "maestro/sprm-remove.action?item.spvr.id=" + vm.item.spvr.id;

            $http.get(url).success(function(data) {
                vm.actionErrors = data.actionErrors;

                if (data.actionErrors.length == 0) {
                    window.history.back();
                }
            });
        }
    }

    $http.get("maestro/sprm-detail.action?item.id=" + $routeParams.itemId + "&item.fref=" + $routeParams.fechaVigencia)
            .success(function(data) {
                vm.enti = data.enti;
                vm.item = data.item;
            });

    pageTitleService.setTitle($routeParams.entiId, "page_item_detail");
}

function sprmCreateController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        var url = "maestro/sprm-save.action";

        $http.post(url, {
            item : vm.item,
            accion : vm.accion
        }).success(
                function(data) {
                    vm.actionErrors = data.actionErrors;

                    if (data.actionErrors.length == 0) {
                        $location.path(
                                "/maestro/sprm/detail/" + data.item.entiId + "/" + data.item.id + "/"
                                        + data.item.spvr.fini).replace();
                    }
                });
    }

    function cancel() {
        window.history.back();
    }

    $http.get(
            "maestro/sprm-create.action?item.entiId=" + $routeParams.entiId + "&item.prmtId=" + $routeParams.prmtId
                    + "&item.fref=" + $routeParams.fechaVigencia).success(function(data) {
        vm.enti = data.enti;
        vm.item = data.item;
        vm.labelValuesMap = data.labelValuesMap;
        vm.accion = data.accion;
    });

    pageTitleService.setTitle($routeParams.entiId, "page_item_create");
}

function sprmEditController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        var url = "maestro/sprm-save.action";

        $http.post(url, {
            item : vm.item,
            accion : vm.accion
        }).success(function(data) {
            $scope.actionErrors = data.actionErrors;

            if (data.actionErrors.length == 0) {
                setTimeout(function() {
                    window.history.back();
                }, 0);
            }
        });
    }

    function cancel() {
        window.history.back();
    }

    $http.get("maestro/sprm-edit.action?item.id=" + $routeParams.itemId + "&item.fref=" + $routeParams.fechaVigencia)
            .success(function(data) {
                vm.enti = data.enti;
                vm.item = data.item;
                vm.labelValuesMap = data.labelValuesMap;
                vm.accion = data.accion;
            });

    pageTitleService.setTitle($routeParams.entiId, "page_item_edit");
}

function sprmDuplicateController($http, $location, $routeParams, pageTitleService) {
    var vm = this;

    vm.save = save;
    vm.cancel = cancel;

    function save() {
        var url = "maestro/sprm-save.action";

        $http.post(url, {
            item : vm.item,
            accion : vm.accion
        }).success(
                function(data) {
                    vm.actionErrors = data.actionErrors;

                    if (data.actionErrors.length == 0) {
                        $location.path(
                                "/maestro/sprm/detail/" + data.item.entiId + "/" + data.item.id + "/"
                                        + data.item.spvr.fini).replace();
                    }
                });
    }

    function cancel() {
        window.history.back();
    }

    $http
            .get(
                    "maestro/sprm-duplicate.action?item.id=" + $routeParams.itemId + "&item.fref="
                            + $routeParams.fechaVigencia).success(function(data) {
                vm.enti = data.enti;
                vm.item = data.item;
                vm.labelValuesMap = data.labelValuesMap;
                vm.accion = data.accion;
            });

    pageTitleService.setTitle($routeParams.entiId, "page_item_duplicate");
}
