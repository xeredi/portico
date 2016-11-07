(function() {
    'use strict';

    angular.module("seguridad_controller", [ "seguridad_service" ])

    .config(seguridad_config)

    .controller("GrupoGridController", GrupoGridController)

    .controller("GrupoDetailController", GrupoDetailController)

    .controller("GrupoEditController", GrupoEditController)

    .controller("UsuarioGridController", UsuarioGridController)

    .controller("UsuarioDetailController", UsuarioDetailController)

    .controller("UsuarioEditController", UsuarioEditController)

    .controller("UsuarioAccesoController", UsuarioAccesoController)

    .controller("UsuarioSalirController", UsuarioSalirController)

    ;

    /* @ngInject */
    function seguridad_config($routeProvider) {
        $routeProvider

        .when("/seguridad/grupo/grid", {
            templateUrl : "modules/seguridad/grupo-grid.html",
            controller : "GrupoGridController as vm",
            reloadOnSearch : false
        })

        .when("/seguridad/grupo/detail/:id", {
            templateUrl : "modules/seguridad/grupo-detail.html",
            controller : "GrupoDetailController as vm",
            reloadOnSearch : false
        })

        .when("/seguridad/grupo/edit/:accion/:id?", {
            templateUrl : "modules/seguridad/grupo-edit.html",
            controller : "GrupoEditController as vm",
            reloadOnSearch : false
        })

        .when("/seguridad/usuario/grid", {
            templateUrl : "modules/seguridad/usuario-grid.html",
            controller : "UsuarioGridController as vm",
            reloadOnSearch : false
        })

        .when("/seguridad/usuario/detail/:id", {
            templateUrl : "modules/seguridad/usuario-detail.html",
            controller : "UsuarioDetailController as vm"
        })

        .when("/seguridad/usuario/edit/:accion/:id?", {
            templateUrl : "modules/seguridad/usuario-edit.html",
            controller : "UsuarioEditController as vm"
        })

        .when("/seguridad/usuario/acceso", {
            templateUrl : "modules/seguridad/usuario-acceso.html",
            controller : "UsuarioAccesoController as vm"
        })

        .when("/seguridad/usuario/salir", {
            templateUrl : "modules/seguridad/usuario-acceso.html",
            controller : "UsuarioSalirController as vm"
        })

        ;
    }

    /* @ngInject */
    function GrupoGridController($routeParams, pageTitleService, GrupoService) {
        var vm = this;

        vm.filter = filter;
        vm.resetFilter = resetFilter;
        vm.search = search;
        vm.pageChanged = pageChanged;

        function filter() {
            GrupoService.filter(vm.searchCriteria).then(function(data) {
            });
        }

        function resetFilter() {
            vm.searchCriteria = {};
        }

        function search(page) {
            GrupoService.listPage(vm.searchCriteria, page, vm.limit).then(function(data) {
                vm.page = data.resultList.page;
                vm.limit = data.resultList.limit;
                vm.resultList = data.resultList;
            });
        }

        function pageChanged() {
            search(vm.page);
        }

        vm.searchCriteria = $routeParams.searchCriteria ? angular.fromJson($routeParams.searchCriteria) : {};
        vm.limit = $routeParams.limit;

        search($routeParams.page ? $routeParams.page : 1);

        pageTitleService.setTitle("grpo", "page_grid");
    }

    /* @ngInject */
    function GrupoDetailController($routeParams, pageTitleService, GrupoService) {
        var vm = this;

        vm.remove = remove;
        vm.tabSelected = tabSelected;

        function remove() {
            GrupoService.remove(vm.model).then(function(data) {
                window.history.back();
            });
        }

        function tabSelected(tabNo) {
            GrupoService.tabSelected(tabNo);
        }

        vm.tab = $routeParams.tab ? $routeParams.tab : "mdloList";

        vm.search = {
            id : $routeParams.id
        };

        GrupoService.detail(vm.search).then(function(data) {
            vm.model = data.model;

            vm.mdloList = data.mdloList;
            vm.prefixList = data.prefixList;
            vm.acbsMap = data.acbsMap;
            vm.entiList = data.entiList;
            vm.acenMap = data.acenMap;
            vm.acesMap = data.acesMap;
            vm.trmtMap = data.trmtMap;
        });

        pageTitleService.setTitle("grpo", "page_detail");
    }

    /* @ngInject */
    function GrupoEditController($routeParams, pageTitleService, GrupoService) {
        var vm = this;

        vm.tabSelected = tabSelected;
        vm.save = save;
        vm.cancel = cancel;
        vm.updateFncdIds = updateFncdIds;

        function tabSelected(tabNo) {
            GrupoService.tabSelected(tabNo);
        }

        function save() {
            GrupoService.save(vm.accion, vm.model).then(function(data) {
                GrupoService.redirectAfterSave(vm.accion, '/seguridad/grupo/detail', [ data.model.id ]);
            });
        }

        function cancel() {
            window.history.back();
        }

        function updateFncdIds($event, fncdId) {
            $event.target.checked ? vm.model.fncdIds.push(fncdId) : vm.model.fncdIds.splice(vm.model.fncdIds
                    .indexOf(fncdId), 1);
        }

        vm.tab = $routeParams.tab ? $routeParams.tab : "mdloList";

        vm.accion = $routeParams.accion;
        vm.search = {
            id : $routeParams.id
        };

        GrupoService.edit(vm.accion, vm.search).then(function(data) {
            vm.model = data.model;

            vm.mdloList = data.mdloList;
            vm.prefixList = data.prefixList;
            vm.acbsMap = data.acbsMap;
            vm.entiList = data.entiList;
            vm.acenMap = data.acenMap;
            vm.acesMap = data.acesMap;
            vm.trmtMap = data.trmtMap;
        });

        pageTitleService.setTitle("grpo", "page_" + vm.accion);
    }

    /* @ngInject */
    function UsuarioGridController($routeParams, pageTitleService, UsuarioService) {
        var vm = this;

        vm.filter = filter;
        vm.resetFilter = resetFilter;
        vm.search = search;
        vm.pageChanged = pageChanged;

        function filter() {
            UsuarioService.filter(vm.searchCriteria).then(function(data) {
                vm.sprtList = data.sprtList;
                vm.prtoList = data.prtoList;
                vm.grpoList = data.grpoList;
            });
        }

        function resetFilter() {
            vm.searchCriteria = {};
        }

        function search(page) {
            UsuarioService.listPage(vm.searchCriteria, page, vm.limit).then(function(data) {
                vm.page = data.resultList.page;
                vm.limit = data.resultList.limit;
                vm.resultList = data.resultList;
            });
        }

        function pageChanged() {
            search(vm.page);
        }

        vm.searchCriteria = $routeParams.searchCriteria ? angular.fromJson($routeParams.searchCriteria) : {};
        vm.limit = $routeParams.limit;

        search($routeParams.page ? $routeParams.page : 1);

        pageTitleService.setTitle("usro", "page_grid");
    }

    /* @ngInject */
    function UsuarioDetailController($routeParams, pageTitleService, UsuarioService) {
        var vm = this;

        vm.remove = remove;

        function remove() {
            UsuarioService.remove(vm.model).then(function(data) {
                window.history.back();
            });
        }

        vm.search = {
            id : $routeParams.id
        };

        UsuarioService.detail(vm.search).then(function(data) {
            vm.model = data.model;

            vm.grpoList = data.grpoList;
        });

        pageTitleService.setTitle("usro", "page_detail");
    }

    /* @ngInject */
    function UsuarioEditController($routeParams, pageTitleService, UsuarioService) {
        var vm = this;

        vm.save = save;
        vm.cancel = cancel;
        vm.updateGrupos = updateGrupos;

        function save() {
            UsuarioService.save(vm.accion, vm.model).then(function(data) {
                UsuarioService.redirectAfterSave(vm.accion, '/seguridad/usuario/detail', [ data.model.id ]);
            });
        }

        function cancel() {
            window.history.back();
        }

        function updateGrupos($event, grpoId) {
            $event.target.checked ? vm.model.grpoIds.push(grpoId) : vm.model.grpoIds.splice(vm.model.grpoIds
                    .indexOf(grpoId), 1);
        }

        vm.accion = $routeParams.accion;
        vm.search = {
            id : $routeParams.id
        };

        UsuarioService.edit(vm.accion, vm.search).then(function(data) {
            vm.model = data.model;
            vm.grpoList = data.grpoList;

            vm.sprtList = data.sprtList;
            vm.prtoList = data.prtoList;
        });

        pageTitleService.setTitle("usro", "page_" + vm.accion);
    }

    /* @ngInject */
    function UsuarioAccesoController($location, localStorageService, pageTitleService, UsuarioService) {
        var vm = this;

        vm.acceso = acceso;

        function acceso() {
            UsuarioService.acceso(vm.model).then(function(data) {
                localStorageService.set("mdloSet", data.resultadoLogin.mdloSet);
                localStorageService.set("acbsPaths", data.resultadoLogin.acbsPaths);
                localStorageService.set("fncdIds", data.resultadoLogin.fncdIds);
                localStorageService.set("acenMap", data.resultadoLogin.acenMap);

                $location.path("/");
            });
        }

        pageTitleService.setTitle("usro", "page_acceso");
    }

    /* @ngInject */
    function UsuarioSalirController($location, localStorageService, UsuarioService) {
        UsuarioService.salir().then(function(data) {
            localStorageService.remove("mdloSet");
            localStorageService.remove("acbsPaths");
            localStorageService.remove("fncdIds");
            localStorageService.remove("acenMap");

            $location.path("/seguridad/usuario/acceso");
        });
    }
})();