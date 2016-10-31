(function() {
    'use strict';

    angular.module("metamodelo_controller", [ "metamodelo_service" ])

    .config(metamodelo_config)

    // -------------------- TIPO DE DATO ------------------
    .controller("TipoDatoGridController", TipoDatoGridController)

    .controller("TipoDatoDetailController", TipoDatoDetailController)

    .controller("TipoDatoEditController", TipoDatoEditController)

    .controller("CodigoReferenciaDetailController", CodigoReferenciaDetailController)

    .controller("CodigoReferenciaEditController", CodigoReferenciaEditController)

    // -------------------- MAESTRO ------------------
    .controller("TipoParametroGridController", TipoParametroGridController)

    .controller("TipoParametroDetailController", TipoParametroDetailController)

    .controller("TipoParametroEditController", TipoParametroEditController)

    .controller("TipoSubparametroDetailController", TipoSubparametroDetailController)

    .controller("TipoSubparametroEditController", TipoSubparametroEditController)

    // -------------------- TIPO DE SERVICIO ------------------
    .controller("TipoServicioGridController", TipoServicioGridController)

    .controller("TipoServicioDetailController", TipoServicioDetailController)

    .controller("TipoServicioEditController", TipoServicioEditController)

    .controller("TipoSubservicioDetailController", TipoSubservicioDetailController)

    .controller("TipoSubservicioEditController", TipoSubservicioEditController)

    // -------------------- ESTADISTICA ------------------
    .controller("TipoEstadisticaGridController", TipoEstadisticaGridController)

    .controller("TipoEstadisticaDetailController", TipoEstadisticaDetailController)

    .controller("TipoEstadisticaEditController", TipoEstadisticaEditController)

    .controller("CampoAgregacionDetailController", CampoAgregacionDetailController)

    .controller("CampoAgregacionEditController", CampoAgregacionEditController)

    // ------------------- GRUPO DE DATO DE ENTIDAD --------------------
    .controller("EntidadGrupoDatoDetailController", EntidadGrupoDatoDetailController)

    .controller("EntidadGrupoDatoEditController", EntidadGrupoDatoEditController)

    // ------------------- DATO DE ENTIDAD --------------------
    .controller("EntidadTipoDatoDetailController", EntidadTipoDatoDetailController)

    .controller("EntidadTipoDatoEditController", EntidadTipoDatoEditController)

    // ------------------- TRAMITE --------------------
    .controller("TramiteDetailController", TramiteDetailController)

    .controller("TramiteEditController", TramiteEditController)

    .controller("TramiteTipoDatoDetailController", TramiteTipoDatoDetailController)

    .controller("TramiteTipoDatoEditController", TramiteTipoDatoEditController)

    // ------------------- ACCION DE ENTIDAD --------------------
    .controller("AccionEntidadDetailController", AccionEntidadDetailController)

    .controller("AccionEntidadEditController", AccionEntidadEditController)

    // ------------------- DEPENDENCIA ENTRE ENTIDADES --------------------
    .controller("EntidadEntidadEditController", EntidadEntidadEditController)

    // -------------------- ACCION BASE ------------------
    .controller("AccionBaseGridController", AccionBaseGridController)

    .controller("AccionBaseDetailController", AccionBaseDetailController)

    .controller("AccionBaseEditController", AccionBaseEditController)

    // -------------------- ACCION ESPECIAL ------------------
    .controller("AccionEspecialDetailController", AccionEspecialDetailController)

    .controller("AccionEspecialEditController", AccionEspecialEditController)

    // -------------------- MODULO ------------------
    .controller("ModuloGridController", ModuloGridController)

    .controller("ModuloDetailController", ModuloDetailController)

    .controller("ModuloEditController", ModuloEditController)

    ;

    /* @ngInject */
    function metamodelo_config($routeProvider) {
        $routeProvider

        .when("/metamodelo/tipo-dato/grid", {
            templateUrl : "modules/metamodelo/tipo-dato-grid.html",
            controller : "TipoDatoGridController as vm",
            reloadOnSearch : false
        })

        .when("/metamodelo/tipo-dato/detail/:id", {
            templateUrl : "modules/metamodelo/tipo-dato-detail.html",
            controller : "TipoDatoDetailController as vm",
        })

        .when("/metamodelo/tipo-dato/edit/:accion/:id?", {
            templateUrl : "modules/metamodelo/tipo-dato-edit.html",
            controller : "TipoDatoEditController as vm",
        })

        .when("/metamodelo/codigo-referencia/detail/:id", {
            templateUrl : "modules/metamodelo/codigo-referencia-detail.html",
            controller : "CodigoReferenciaDetailController as vm",
        })

        .when("/metamodelo/codigo-referencia/edit/:accion/:tpdtId/:id?", {
            templateUrl : "modules/metamodelo/codigo-referencia-edit.html",
            controller : "CodigoReferenciaEditController as vm",
        })

        .when("/metamodelo/tipo-parametro/grid", {
            templateUrl : "modules/metamodelo/tipo-parametro-grid.html",
            controller : "TipoParametroGridController as vm",
            reloadOnSearch : false
        })

        .when("/metamodelo/tipo-parametro/detail/:id", {
            templateUrl : "modules/metamodelo/tipo-parametro-detail.html",
            controller : "TipoParametroDetailController as vm",
            reloadOnSearch : false
        })

        .when("/metamodelo/tipo-parametro/edit/:accion/:id?", {
            templateUrl : "modules/metamodelo/tipo-parametro-edit.html",
            controller : "TipoParametroEditController as vm",
        })

        .when("/metamodelo/tipo-subparametro/detail/:id", {
            templateUrl : "modules/metamodelo/tipo-subparametro-detail.html",
            controller : "TipoSubparametroDetailController as vm",
            reloadOnSearch : false
        })

        .when("/metamodelo/tipo-subparametro/edit/:accion/:tpprId/:id?", {
            templateUrl : "modules/metamodelo/tipo-subparametro-edit.html",
            controller : "TipoSubparametroEditController as vm",
        })

        .when("/metamodelo/tipo-servicio/grid", {
            templateUrl : "modules/metamodelo/tipo-servicio-grid.html",
            controller : "TipoServicioGridController as vm",
            reloadOnSearch : false
        })

        .when("/metamodelo/tipo-servicio/detail/:id", {
            templateUrl : "modules/metamodelo/tipo-servicio-detail.html",
            controller : "TipoServicioDetailController as vm",
            reloadOnSearch : false
        })

        .when("/metamodelo/tipo-servicio/edit/:accion/:id?", {
            templateUrl : "modules/metamodelo/tipo-servicio-edit.html",
            controller : "TipoServicioEditController as vm",
        })

        .when("/metamodelo/tipo-subservicio/detail/:id", {
            templateUrl : "modules/metamodelo/tipo-subservicio-detail.html",
            controller : "TipoSubservicioDetailController as vm",
            reloadOnSearch : false
        })

        .when("/metamodelo/tipo-subservicio/edit/:accion/:tpsrId/:id?", {
            templateUrl : "modules/metamodelo/tipo-subservicio-edit.html",
            controller : "TipoSubservicioEditController as vm",
        })

        .when("/metamodelo/tipo-estadistica/grid", {
            templateUrl : "modules/metamodelo/tipo-estadistica-grid.html",
            controller : "TipoEstadisticaGridController as vm",
            reloadOnSearch : false
        })

        .when("/metamodelo/tipo-estadistica/detail/:id", {
            templateUrl : "modules/metamodelo/tipo-estadistica-detail.html",
            controller : "TipoEstadisticaDetailController as vm",
            reloadOnSearch : false
        })

        .when("/metamodelo/tipo-estadistica/edit/:accion/:id?", {
            templateUrl : "modules/metamodelo/tipo-estadistica-edit.html",
            controller : "TipoEstadisticaEditController as vm",
        })

        .when("/metamodelo/campo-agregacion/detail/:tpesId/:entdId", {
            templateUrl : "modules/metamodelo/campo-agregacion-detail.html",
            controller : "CampoAgregacionDetailController as vm",
        })

        .when("/metamodelo/campo-agregacion/edit/:accion/:tpesId/:entdId?", {
            templateUrl : "modules/metamodelo/campo-agregacion-edit.html",
            controller : "CampoAgregacionEditController as vm",
        })

        .when("/metamodelo/entidad-grupo-dato/detail/:id", {
            templateUrl : "modules/metamodelo/entidad-grupo-dato-detail.html",
            controller : "EntidadGrupoDatoDetailController as vm",
        })

        .when("/metamodelo/entidad-grupo-dato/edit/:accion/:entiId/:id?", {
            templateUrl : "modules/metamodelo/entidad-grupo-dato-edit.html",
            controller : "EntidadGrupoDatoEditController as vm",
        })

        .when("/metamodelo/entidad-tipo-dato/detail/:id", {
            templateUrl : "modules/metamodelo/entidad-tipo-dato-detail.html",
            controller : "EntidadTipoDatoDetailController as vm",
        })

        .when("/metamodelo/entidad-tipo-dato/edit/:accion/:entiId/:id?", {
            templateUrl : "modules/metamodelo/entidad-tipo-dato-edit.html",
            controller : "EntidadTipoDatoEditController as vm",
        })

        .when("/metamodelo/tramite/detail/:id", {
            templateUrl : "modules/metamodelo/tramite-detail.html",
            controller : "TramiteDetailController as vm",
        })

        .when("/metamodelo/tramite/edit/:accion/:entiId/:id?", {
            templateUrl : "modules/metamodelo/tramite-edit.html",
            controller : "TramiteEditController as vm",
        })

        .when("/metamodelo/tramite-tipo-dato/detail/:trmtId/:tpdtId", {
            templateUrl : "modules/metamodelo/tramite-tipo-dato-detail.html",
            controller : "TramiteTipoDatoDetailController as vm",
        })

        .when("/metamodelo/tramite-tipo-dato/edit/:accion/:trmtId/:tpdtId?", {
            templateUrl : "modules/metamodelo/tramite-tipo-dato-edit.html",
            controller : "TramiteTipoDatoEditController as vm",
        })

        .when("/metamodelo/accion-entidad/detail/:id", {
            templateUrl : "modules/metamodelo/accion-entidad-detail.html",
            controller : "AccionEntidadDetailController as vm",
        })

        .when("/metamodelo/accion-entidad/edit/:accion/:entiId/:id?", {
            templateUrl : "modules/metamodelo/accion-entidad-edit.html",
            controller : "AccionEntidadEditController as vm",
        })

        .when("/metamodelo/entidad-entidad/edit/:accion/:entiPadreId/:entiHijaId?", {
            templateUrl : "modules/metamodelo/entidad-entidad-edit.html",
            controller : "EntidadEntidadEditController as vm",
        })

        .when("/metamodelo/accion-base/grid", {
            templateUrl : "modules/metamodelo/accion-base-grid.html",
            controller : "AccionBaseGridController as vm",
            reloadOnSearch : false
        })

        .when("/metamodelo/accion-base/detail/:id", {
            templateUrl : "modules/metamodelo/accion-base-detail.html",
            controller : "AccionBaseDetailController as vm",
        })

        .when("/metamodelo/accion-base/edit/:accion/:id?", {
            templateUrl : "modules/metamodelo/accion-base-edit.html",
            controller : "AccionBaseEditController as vm",
        })

        .when("/metamodelo/accion-especial/detail/:id", {
            templateUrl : "modules/metamodelo/accion-especial-detail.html",
            controller : "AccionEspecialDetailController as vm",
        })

        .when("/metamodelo/accion-especial/edit/:accion/:entiId/:id?", {
            templateUrl : "modules/metamodelo/accion-especial-edit.html",
            controller : "AccionEspecialEditController as vm",
        })

        .when("/metamodelo/modulo/grid", {
            templateUrl : "modules/metamodelo/modulo-grid.html",
            controller : "ModuloGridController as vm",
            reloadOnSearch : false
        })

        .when("/metamodelo/modulo/detail/:id", {
            templateUrl : "modules/metamodelo/modulo-detail.html",
            controller : "ModuloDetailController as vm",
        })

        .when("/metamodelo/modulo/edit/:accion/:id?", {
            templateUrl : "modules/metamodelo/modulo-edit.html",
            controller : "ModuloEditController as vm",
        })

        ;
    }

    /* @ngInject */
    function TipoDatoGridController($routeParams, pageTitleService, TipoDatoService) {
        var vm = this;

        vm.filter = filter;
        vm.resetFilter = resetFilter;
        vm.search = search;
        vm.pageChanged = pageChanged;

        function filter() {
            TipoDatoService.filter(vm.searchCriteria).then(function(data) {
                vm.tphtList = data.tphtList;
                vm.tpelList = data.tpelList;
            });
        }

        function resetFilter() {
            vm.searchCriteria = {};
        }

        function search(page) {
            TipoDatoService.listPage(vm.searchCriteria, page, vm.limit).then(function(data) {
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

        pageTitleService.setTitle("tpdt", "page_grid");
    }

    /* @ngInject */
    function TipoDatoDetailController($routeParams, pageTitleService, TipoDatoService) {
        var vm = this;

        vm.remove = remove;

        function remove() {
            TipoDatoService.remove(vm.model).then(function(data) {
                window.history.back();
            });
        }

        vm.search = {
            id : $routeParams.id
        };

        TipoDatoService.detail(vm.search).then(function(data) {
            vm.model = data.model;
            vm.i18nMap = data.i18nMap;
        });

        pageTitleService.setTitle("tpdt", "page_detail");
    }

    /* @ngInject */
    function TipoDatoEditController($routeParams, pageTitleService, TipoDatoService) {
        var vm = this;

        vm.save = save;
        vm.cancel = cancel;

        function save() {
            TipoDatoService.saveI18n(vm.accion, vm.model, vm.i18nMap).then(
                    function(data) {
                        TipoDatoService.redirectAfterSave(vm.accion, '/metamodelo/tipo-dato/detail',
                                [ data.model.id ]);
                    });
        }

        function cancel() {
            window.history.back();
        }

        vm.accion = $routeParams.accion;
        vm.search = {
            id : $routeParams.id
        };

        TipoDatoService.edit(vm.accion, vm.search).then(function(data) {
            vm.model = data.model;
            vm.i18nMap = data.i18nMap;

            vm.tphtList = data.tphtList;
            vm.tpelList = data.tpelList;
            vm.entiTpprList = data.tpprList;
            vm.entiTpsrList = data.tpsrList;
        });

        pageTitleService.setTitle("tpdt", "page_" + vm.accion);
    }

    /* @ngInject */
    function CodigoReferenciaDetailController($routeParams, pageTitleService, CodigoReferenciaService) {
        var vm = this;

        vm.remove = remove;

        function remove() {
            CodigoReferenciaService.remove(vm.model).then(function(data) {
                window.history.back();
            });
        }

        vm.search = {
            id : $routeParams.id
        };

        CodigoReferenciaService.detail(vm.search).then(function(data) {
            vm.model = data.model;
            vm.i18nMap = data.i18nMap;
        });

        pageTitleService.setTitle("cdrf", "page_detail");
    }

    /* @ngInject */
    function CodigoReferenciaEditController($routeParams, pageTitleService, CodigoReferenciaService) {
        var vm = this;

        vm.save = save;
        vm.cancel = cancel;

        function save() {
            CodigoReferenciaService.saveI18n(vm.accion, vm.model, vm.i18nMap).then(
                    function(data) {
                        CodigoReferenciaService.redirectAfterSave(vm.accion,
                                '/metamodelo/codigo-referencia/detail', [ data.model.id ]);
                    });
        }

        function cancel() {
            window.history.back();
        }

        vm.accion = $routeParams.accion;
        vm.search = {
            tpdtId : $routeParams.tpdtId,
            id : $routeParams.id
        };

        CodigoReferenciaService.edit(vm.accion, vm.search).then(function(data) {
            vm.model = data.model;
            vm.i18nMap = data.i18nMap;
        });

        pageTitleService.setTitle("cdrf", "page_" + vm.accion);
    }

    /* @ngInject */
    function TipoParametroGridController($routeParams, pageTitleService, TipoParametroService) {
        var vm = this;

        vm.filter = filter;
        vm.resetFilter = resetFilter;
        vm.search = search;
        vm.pageChanged = pageChanged;

        function filter() {
            TipoParametroService.filter(vm.searchCriteria).then(function(data) {
            });
        }

        function resetFilter() {
            vm.searchCriteria = {};
        }

        function search(page) {
            TipoParametroService.listPage(vm.searchCriteria, page, vm.limit).then(function(data) {
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

        pageTitleService.setTitle("tppr", "page_grid");
    }

    /* @ngInject */
    function TipoParametroDetailController($routeParams, pageTitleService, TipoParametroService) {
        var vm = this;

        vm.remove = remove;
        vm.tabSelected = tabSelected;

        function remove() {
            TipoParametroService.remove(vm.model).then(function(data) {
                window.history.back();
            });
        }

        function tabSelected(tabNo) {
            TipoParametroService.tabSelected(tabNo);
        }

        vm.tabActive = {};

        if ($routeParams.tab) {
            vm.tabActive[$routeParams.tab] = true;
        }

        vm.search = {
            id : $routeParams.id
        };

        TipoParametroService.detail(vm.search).then(function(data) {
            vm.model = data.model;
            vm.i18nMap = data.i18nMap;
            vm.subentiList = data.subentiList;
            vm.entdList = data.entdList;
            vm.engdList = data.engdList;
            vm.acenList = data.acenList;
            vm.acesList = data.acesList;
        });

        pageTitleService.setTitle("tppr", "page_detail");
    }

    /* @ngInject */
    function TipoParametroEditController($routeParams, pageTitleService, TipoParametroService) {
        var vm = this;

        vm.save = save;
        vm.cancel = cancel;

        function save() {
            TipoParametroService.saveI18n(vm.accion, vm.model, vm.i18nMap).then(
                    function(data) {
                        TipoParametroService.redirectAfterSave(vm.accion,
                                '/metamodelo/tipo-parametro/detail', [ data.model.id ]);
                    });
        }

        function cancel() {
            window.history.back();
        }

        vm.accion = $routeParams.accion;
        vm.search = {
            id : $routeParams.id
        };

        TipoParametroService.edit(vm.accion, vm.search).then(function(data) {
            vm.model = data.model;
            vm.i18nMap = data.i18nMap;

            vm.tpdtNombreList = data.tpdtNombreList;
        });

        pageTitleService.setTitle("tppr", "page_" + vm.accion);
    }

    /* @ngInject */
    function TipoSubparametroDetailController($routeParams, pageTitleService, TipoSubparametroService) {
        var vm = this;

        vm.remove = remove;
        vm.tabSelected = tabSelected;

        function remove() {
            TipoSubparametroService.remove(vm.model).then(function(data) {
                window.history.back();
            });
        }

        function tabSelected(tabNo) {
            TipoSubparametroService.tabSelected(tabNo);
        }

        vm.tabActive = {};

        if ($routeParams.tab) {
            vm.tabActive[$routeParams.tab] = true;
        }

        vm.search = {
            id : $routeParams.id
        };

        TipoSubparametroService.detail(vm.search).then(function(data) {
            vm.model = data.model;
            vm.i18nMap = data.i18nMap;
            vm.entdList = data.entdList;
            vm.engdList = data.engdList;
            vm.acenList = data.acenList;
            vm.acesList = data.acesList;
        });

        pageTitleService.setTitle("tpsp", "page_detail");
    }

    /* @ngInject */
    function TipoSubparametroEditController($routeParams, pageTitleService, TipoSubparametroService) {
        var vm = this;

        vm.save = save;
        vm.cancel = cancel;

        function save() {
            TipoSubparametroService.saveI18n(vm.accion, vm.model, vm.i18nMap).then(
                    function(data) {
                        TipoSubparametroService.redirectAfterSave(vm.accion,
                                '/metamodelo/tipo-subparametro/detail', [ data.model.id ]);
                    });
        }

        function cancel() {
            window.history.back();
        }

        vm.accion = $routeParams.accion;
        vm.search = {
            tpprId : $routeParams.tpprId,
            id : $routeParams.id
        };

        TipoSubparametroService.edit(vm.accion, vm.search).then(function(data) {
            vm.model = data.model;
            vm.i18nMap = data.i18nMap;

            vm.tpprList = data.tpprList;
        });

        pageTitleService.setTitle("tpsp", "page_" + vm.accion);
    }

    /* @ngInject */
    function TipoServicioGridController($routeParams, pageTitleService, TipoServicioService) {
        var vm = this;

        vm.filter = filter;
        vm.resetFilter = resetFilter;
        vm.search = search;
        vm.pageChanged = pageChanged;

        function filter() {
            TipoServicioService.filter(vm.searchCriteria).then(function(data) {
            });
        }

        function resetFilter() {
            vm.searchCriteria = {};
        }

        function search(page) {
            TipoServicioService.listPage(vm.searchCriteria, page, vm.limit).then(function(data) {
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

        pageTitleService.setTitle("tpsr", "page_grid");
    }

    /* @ngInject */
    function TipoServicioDetailController($routeParams, pageTitleService, TipoServicioService) {
        var vm = this;

        vm.remove = remove;
        vm.tabSelected = tabSelected;

        function remove() {
            TipoServicioService.remove(vm.model).then(function(data) {
                window.history.back();
            });
        }

        function tabSelected(tabNo) {
            TipoServicioService.tabSelected(tabNo);
        }

        vm.tabActive = {};

        if ($routeParams.tab) {
            vm.tabActive[$routeParams.tab] = true;
        }

        vm.search = {
            id : $routeParams.id
        };

        TipoServicioService.detail(vm.search).then(function(data) {
            vm.model = data.model;
            vm.i18nMap = data.i18nMap;
            vm.subentiList = data.subentiList;
            vm.entiHijasList = data.entiHijasList;
            vm.entdList = data.entdList;
            vm.engdList = data.engdList;
            vm.trmtList = data.trmtList;
            vm.acenList = data.acenList;
            vm.acesList = data.acesList;
        });

        pageTitleService.setTitle("tpsr", "page_detail");
    }

    /* @ngInject */
    function TipoServicioEditController($routeParams, pageTitleService, TipoServicioService) {
        var vm = this;

        vm.save = save;
        vm.cancel = cancel;

        function save() {
            TipoServicioService.saveI18n(vm.accion, vm.model, vm.i18nMap).then(
                    function(data) {
                        TipoServicioService.redirectAfterSave(vm.accion, '/metamodelo/tipo-servicio/detail',
                                [ data.model.id ]);
                    });
        }

        function cancel() {
            window.history.back();
        }

        vm.accion = $routeParams.accion;
        vm.search = {
            id : $routeParams.id
        };

        TipoServicioService.edit(vm.accion, vm.search).then(function(data) {
            vm.model = data.model;
            vm.i18nMap = data.i18nMap;

            vm.tpdtEstadoList = data.tpdtEstadoList;
        });

        pageTitleService.setTitle("tpsr", "page_" + vm.accion);
    }

    /* @ngInject */
    function TipoSubservicioDetailController($routeParams, pageTitleService, TipoSubservicioService) {
        var vm = this;

        vm.remove = remove;
        vm.tabSelected = tabSelected;

        function remove() {
            TipoSubservicioService.remove(vm.model).then(function(data) {
                window.history.back();
            });
        }

        function tabSelected(tabNo) {
            TipoSubservicioService.tabSelected(tabNo);
        }

        vm.tabActive = {};

        if ($routeParams.tab) {
            vm.tabActive[$routeParams.tab] = true;
        }

        vm.search = {
            id : $routeParams.id
        };

        TipoSubservicioService.detail(vm.search).then(function(data) {
            vm.model = data.model;
            vm.i18nMap = data.i18nMap;
            vm.entiHijasList = data.entiHijasList;
            vm.entiPadresList = data.entiPadresList;
            vm.entdList = data.entdList;
            vm.engdList = data.engdList;
            vm.trmtList = data.trmtList;
            vm.acenList = data.acenList;
            vm.acesList = data.acesList;
        });

        pageTitleService.setTitle("tpss", "page_detail");
    }

    /* @ngInject */
    function TipoSubservicioEditController($routeParams, pageTitleService, TipoSubservicioService) {
        var vm = this;

        vm.save = save;
        vm.cancel = cancel;

        function save() {
            TipoSubservicioService.saveI18n(vm.accion, vm.model, vm.i18nMap).then(
                    function(data) {
                        TipoSubservicioService.redirectAfterSave(vm.accion,
                                '/metamodelo/tipo-subservicio/detail', [ data.model.id ]);
                    });
        }

        function cancel() {
            window.history.back();
        }

        vm.accion = $routeParams.accion;
        vm.search = {
            tpsrId : $routeParams.tpsrId,
            id : $routeParams.id
        };

        TipoSubservicioService.edit(vm.accion, vm.search).then(function(data) {
            vm.model = data.model;
            vm.i18nMap = data.i18nMap;

            vm.tpdtEstadoList = data.tpdtEstadoList;
        });

        pageTitleService.setTitle("tpss", "page_" + vm.accion);
    }

    /* @ngInject */
    function TipoEstadisticaGridController($routeParams, pageTitleService, TipoEstadisticaService) {
        var vm = this;

        vm.filter = filter;
        vm.resetFilter = resetFilter;
        vm.search = search;
        vm.pageChanged = pageChanged;

        function filter() {
            TipoEstadisticaService.filter(vm.searchCriteria).then(function(data) {
            });
        }

        function resetFilter() {
            vm.searchCriteria = {};
        }

        function search(page) {
            TipoEstadisticaService.listPage(vm.searchCriteria, page, vm.limit).then(function(data) {
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

        pageTitleService.setTitle("tpes", "page_grid");
    }

    /* @ngInject */
    function TipoEstadisticaDetailController($routeParams, pageTitleService, TipoEstadisticaService) {
        var vm = this;

        vm.remove = remove;
        vm.tabSelected = tabSelected;

        function remove() {
            TipoEstadisticaService.remove(vm.model).then(function(data) {
                window.history.back();
            });
        }

        function tabSelected(tabNo) {
            TipoEstadisticaService.tabSelected(tabNo);
        }

        vm.tabActive = {};

        if ($routeParams.tab) {
            vm.tabActive[$routeParams.tab] = true;
        }

        vm.search = {
            id : $routeParams.id
        };

        TipoEstadisticaService.detail(vm.search).then(function(data) {
            vm.model = data.model;
            vm.i18nMap = data.i18nMap;
            vm.cmagList = data.cmagList;
            vm.subentiList = data.subentiList;
            vm.entdList = data.entdList;
            vm.engdList = data.engdList;
            vm.acenList = data.acenList;
            vm.acesList = data.acesList;
        });

        pageTitleService.setTitle("tpes", "page_detail");
    }

    /* @ngInject */
    function TipoEstadisticaEditController($routeParams, pageTitleService, TipoEstadisticaService) {
        var vm = this;

        vm.save = save;
        vm.cancel = cancel;

        function save() {
            TipoEstadisticaService.saveI18n(vm.accion, vm.model, vm.i18nMap).then(
                    function(data) {
                        TipoEstadisticaService.redirectAfterSave(vm.accion,
                                '/metamodelo/tipo-estadistica/detail', [ data.model.id ]);
                    });
        }

        function cancel() {
            window.history.back();
        }

        vm.accion = $routeParams.accion;
        vm.search = {
            id : $routeParams.id
        };

        TipoEstadisticaService.edit(vm.accion, vm.search).then(function(data) {
            vm.model = data.model;
            vm.i18nMap = data.i18nMap;
        });

        pageTitleService.setTitle("tpes", "page_" + vm.accion);
    }

    /* @ngInject */
    function CampoAgregacionDetailController($routeParams, pageTitleService, CampoAgregacionService) {
        var vm = this;

        vm.remove = remove;

        function remove() {
            CampoAgregacionService.remove(vm.model).then(function(data) {
                window.history.back();
            });
        }

        vm.search = {
            tpesId : $routeParams.tpesId,
            entd : {
                id : $routeParams.entdId
            }
        };

        CampoAgregacionService.detail(vm.search).then(function(data) {
            vm.model = data.model;
        });

        pageTitleService.setTitle("cmag", "page_detail");
    }

    /* @ngInject */
    function CampoAgregacionEditController($routeParams, pageTitleService, CampoAgregacionService) {
        var vm = this;

        vm.save = save;
        vm.cancel = cancel;

        function save() {
            CampoAgregacionService.save(vm.accion, vm.model).then(
                    function(data) {
                        CampoAgregacionService.redirectAfterSave(vm.accion,
                                '/metamodelo/campo-agregacion/detail', [ data.model.tpesId,
                                        data.model.entd.id ]);
                    });
        }

        function cancel() {
            window.history.back();
        }

        vm.accion = $routeParams.accion;
        vm.search = {
            tpesId : $routeParams.tpesId,
            entd : {
                id : $routeParams.entdId
            }
        };

        CampoAgregacionService.edit(vm.accion, vm.search).then(function(data) {
            vm.model = data.model;
        });

        pageTitleService.setTitle("cmag", "page_" + vm.accion);
    }

    /* @ngInject */
    function EntidadTipoDatoDetailController($routeParams, pageTitleService, EntidadTipoDatoService) {
        var vm = this;

        vm.remove = remove;

        function remove() {
            EntidadTipoDatoService.remove(vm.model).then(function(data) {
                window.history.back();
            });
        }

        vm.search = {
            id : $routeParams.id
        };

        EntidadTipoDatoService.detail(vm.search).then(function(data) {
            vm.model = data.model;
            vm.i18nMap = data.i18nMap;
        });

        pageTitleService.setTitle("entd", "page_detail");
    }

    /* @ngInject */
    function EntidadTipoDatoEditController($routeParams, pageTitleService, EntidadTipoDatoService) {
        var vm = this;

        vm.save = save;
        vm.cancel = cancel;

        function save() {
            EntidadTipoDatoService.saveI18n(vm.accion, vm.model, vm.i18nMap).then(
                    function(data) {
                        EntidadTipoDatoService.redirectAfterSave(vm.accion,
                                '/metamodelo/entidad-tipo-dato/detail', [ data.model.id ]);
                    });
        }

        function cancel() {
            window.history.back();
        }

        vm.accion = $routeParams.accion;
        vm.search = {
            entiId : $routeParams.entiId,
            id : $routeParams.id
        };

        EntidadTipoDatoService.edit(vm.accion, vm.search).then(function(data) {
            vm.model = data.model;
            vm.i18nMap = data.i18nMap;

            vm.tpdtList = data.tpdtList;
            vm.engdList = data.engdList;
        });

        pageTitleService.setTitle("entd", "page_" + vm.accion);
    }

    /* @ngInject */
    function EntidadGrupoDatoDetailController($routeParams, pageTitleService, EntidadGrupoDatoService) {
        var vm = this;

        vm.remove = remove;

        function remove() {
            EntidadGrupoDatoService.remove(vm.model).then(function(data) {
                window.history.back();
            });
        }

        vm.search = {
            id : $routeParams.id
        };

        EntidadGrupoDatoService.detail(vm.search).then(function(data) {
            vm.model = data.model;
            vm.i18nMap = data.i18nMap;
        });

        pageTitleService.setTitle("engd", "page_detail");
    }

    /* @ngInject */
    function EntidadGrupoDatoEditController($routeParams, pageTitleService, EntidadGrupoDatoService) {
        var vm = this;

        vm.save = save;
        vm.cancel = cancel;

        function save() {
            EntidadGrupoDatoService.saveI18n(vm.accion, vm.model, vm.i18nMap).then(
                    function(data) {
                        EntidadGrupoDatoService.redirectAfterSave(vm.accion,
                                '/metamodelo/entidad-grupo-dato/detail', [ data.model.id ]);
                    });
        }

        function cancel() {
            window.history.back();
        }

        vm.accion = $routeParams.accion;
        vm.search = {
            entiId : $routeParams.entiId,
            id : $routeParams.id
        };

        EntidadGrupoDatoService.edit(vm.accion, vm.search).then(function(data) {
            vm.model = data.model;
            vm.i18nMap = data.i18nMap;
        });

        pageTitleService.setTitle("engd", "page_" + vm.accion);
    }

    /* @ngInject */
    function TramiteDetailController($routeParams, pageTitleService, TramiteService) {
        var vm = this;

        vm.remove = remove;

        function remove() {
            TramiteService.remove(vm.model).then(function(data) {
                window.history.back();
            });
        }

        vm.search = {
            id : $routeParams.id
        };

        TramiteService.detail(vm.search).then(function(data) {
            vm.model = data.model;
            vm.i18nMap = data.i18nMap;

            vm.enti = data.enti;
            vm.trtdList = data.trtdList;
            vm.actrList = data.actrList;
        });

        pageTitleService.setTitle("trmt", "page_detail");
    }

    /* @ngInject */
    function TramiteEditController($routeParams, pageTitleService, TramiteService) {
        var vm = this;

        vm.save = save;
        vm.cancel = cancel;

        function save() {
            TramiteService.saveI18n(vm.accion, vm.model, vm.i18nMap).then(function(data) {
                TramiteService.redirectAfterSave(vm.accion, '/metamodelo/tramite/detail', [ data.model.id ]);
            });
        }

        function cancel() {
            window.history.back();
        }

        vm.accion = $routeParams.accion;
        vm.search = {
            entiId : $routeParams.entiId,
            id : $routeParams.id
        };

        TramiteService.edit(vm.accion, vm.search).then(function(data) {
            vm.model = data.model;
            vm.i18nMap = data.i18nMap;

            vm.tpdtEstado = data.tpdtEstado;
        });

        pageTitleService.setTitle("trmt", "page_" + vm.accion);
    }

    /* @ngInject */
    function TramiteTipoDatoDetailController($routeParams, pageTitleService, TramiteTipoDatoService) {
        var vm = this;

        vm.remove = remove;

        function remove() {
            TramiteTipoDatoService.remove(vm.model).then(function(data) {
                window.history.back();
            });
        }

        vm.search = {
            trmtId : $routeParams.trmtId,
            entd : {
                tpdt : {
                    id : $routeParams.tpdtId
                }
            }
        };

        TramiteTipoDatoService.detail(vm.search).then(function(data) {
            vm.model = data.model;
        });

        pageTitleService.setTitle("trtd", "page_detail");
    }

    /* @ngInject */
    function TramiteTipoDatoEditController($routeParams, pageTitleService, TramiteTipoDatoService) {
        var vm = this;

        vm.save = save;
        vm.cancel = cancel;

        function save() {
            TramiteTipoDatoService.save(vm.accion, vm.model).then(
                    function(data) {
                        TramiteTipoDatoService.redirectAfterSave(vm.accion,
                                '/metamodelo/tramite-tipo-dato/detail', [ data.model.trmtId,
                                        data.model.entd.tpdt.id ]);
                    });
        }

        function cancel() {
            window.history.back();
        }

        vm.accion = $routeParams.accion;
        vm.search = {
            trmtId : $routeParams.trmtId,
            entd : {
                tpdt : {
                    id : $routeParams.tpdtId
                }
            }
        };

        TramiteTipoDatoService.edit(vm.accion, vm.search).then(function(data) {
            vm.model = data.model;

            vm.entdList = data.entdList;
        });

        pageTitleService.setTitle("trtd", "page_" + vm.accion);
    }

    /* @ngInject */
    function AccionEntidadDetailController($routeParams, pageTitleService, AccionEntidadService) {
        var vm = this;

        vm.remove = remove;

        function remove() {
            AccionEntidadService.remove(vm.model).then(function(data) {
                window.history.back();
            });
        }

        vm.search = {
            id : $routeParams.id
        };

        AccionEntidadService.detail(vm.search).then(function(data) {
            vm.model = data.model;
        });

        pageTitleService.setTitle("acen", "page_detail");
    }

    /* @ngInject */
    function AccionEntidadEditController($routeParams, pageTitleService, AccionEntidadService) {
        var vm = this;

        vm.save = save;
        vm.cancel = cancel;
        vm.updateGrupos = updateGrupos;

        function save() {
            AccionEntidadService.save(vm.accion, vm.model).then(
                    function(data) {
                        AccionEntidadService.redirectAfterSave(vm.accion,
                                '/metamodelo/accion-entidad/detail', [ data.model.id ]);
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
            id : $routeParams.id,
            entiId : $routeParams.entiId
        };

        AccionEntidadService.edit(vm.accion, vm.search).then(function(data) {
            vm.model = data.model;

            vm.aebsList = data.aebsList;
        });

        pageTitleService.setTitle("acen", "page_" + vm.accion);
    }

    /* @ngInject */
    function EntidadEntidadEditController($routeParams, pageTitleService, EntidadEntidadService) {
        var vm = this;

        vm.save = save;
        vm.cancel = cancel;

        function save() {
            EntidadEntidadService.saveI18n(vm.accion, vm.model, vm.i18nMap).then(
                    function(data) {
                        EntidadEntidadService.redirectAfterSave(vm.accion,
                                '/metamodelo/entidad-entidad/detail', [ data.model.entiPadreId,
                                        data.model.entiHijaId ]);
                    });
        }

        function cancel() {
            window.history.back();
        }

        vm.accion = $routeParams.accion;
        vm.model = {
            entiPadreId : $routeParams.entiPadreId,
            entiHija : {
                id : $routeParams.entiHijaId
            }
        };

        EntidadEntidadService.edit(vm.accion, vm.model).then(function(data) {
            vm.model = data.model;
            vm.i18nMap = data.i18nMap;

            vm.entiList = data.tpssList;
        });

        pageTitleService.setTitle("enen", "page_" + vm.accion);
    }

    /* @ngInject */
    function AccionBaseGridController($routeParams, pageTitleService, AccionBaseService) {
        var vm = this;

        vm.filter = filter;
        vm.resetFilter = resetFilter;
        vm.search = search;
        vm.pageChanged = pageChanged;

        function filter() {
            AccionBaseService.filter(vm.searchCriteria).then(function(data) {
                vm.acprList = data.acprList;
                vm.accoList = data.accoList;
            });
        }

        function resetFilter() {
            vm.searchCriteria = {};
        }

        function search(page) {
            AccionBaseService.listPage(vm.searchCriteria, page, vm.limit).then(function(data) {
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

        pageTitleService.setTitle("acbs", "page_grid");
    }

    /* @ngInject */
    function AccionBaseDetailController($routeParams, pageTitleService, AccionBaseService) {
        var vm = this;

        vm.remove = remove;

        function remove() {
            AccionBaseService.remove(vm.model).then(function(data) {
                window.history.back();
            });
        }

        vm.search = {
            id : $routeParams.id
        };

        AccionBaseService.detail(vm.search).then(function(data) {
            vm.model = data.model;
        });

        pageTitleService.setTitle("acbs", "page_detail");
    }

    /* @ngInject */
    function AccionBaseEditController($routeParams, pageTitleService, AccionBaseService) {
        var vm = this;

        vm.save = save;
        vm.cancel = cancel;

        function save() {
            AccionBaseService.save(vm.accion, vm.model).then(
                    function(data) {
                        AccionBaseService.redirectAfterSave(vm.accion, '/metamodelo/accion-base/detail',
                                [ data.model.id ]);
                    });
        }

        function cancel() {
            window.history.back();
        }

        vm.accion = $routeParams.accion;
        vm.search = {
            id : $routeParams.id
        };

        AccionBaseService.edit(vm.accion, vm.search).then(function(data) {
            vm.model = data.model;

            vm.acprList = data.acprList;
            vm.accoList = data.accoList;
        });

        pageTitleService.setTitle("acbs", "page_" + vm.accion);
    }

    /* @ngInject */
    function AccionEspecialDetailController($routeParams, pageTitleService, AccionEspecialService) {
        var vm = this;

        vm.remove = remove;

        function remove() {
            AccionEspecialService.remove(vm.model).then(function(data) {
                window.history.back();
            });
        }

        vm.search = {
            id : $routeParams.id
        };

        AccionEspecialService.detail(vm.search).then(function(data) {
            vm.model = data.model;
            vm.i18nMap = data.i18nMap;
        });

        pageTitleService.setTitle("aces", "page_detail");
    }

    /* @ngInject */
    function AccionEspecialEditController($routeParams, pageTitleService, AccionEspecialService) {
        var vm = this;

        vm.save = save;
        vm.cancel = cancel;

        function save() {
            AccionEspecialService.saveI18n(vm.accion, vm.model, vm.i18nMap).then(
                    function(data) {
                        AccionEspecialService.redirectAfterSave(vm.accion,
                                '/metamodelo/accion-especial/detail', [ data.model.id ]);
                    });
        }

        function cancel() {
            window.history.back();
        }

        vm.accion = $routeParams.accion;
        vm.search = {
            id : $routeParams.id,
            entiId : $routeParams.entiId
        };

        AccionEspecialService.edit(vm.accion, vm.search).then(function(data) {
            vm.model = data.model;
            vm.i18nMap = data.i18nMap;
        });

        pageTitleService.setTitle("aces", "page_" + vm.accion);
    }

    /* @ngInject */
    function ModuloGridController($routeParams, pageTitleService, ModuloService) {
        var vm = this;

        vm.filter = filter;
        vm.resetFilter = resetFilter;
        vm.search = search;
        vm.pageChanged = pageChanged;

        function filter() {
            ModuloService.filter(vm.searchCriteria).then(function(data) {
            });
        }

        function resetFilter() {
            vm.searchCriteria = {};
        }

        function search(page) {
            ModuloService.listPage(vm.searchCriteria, page, vm.limit).then(function(data) {
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

        pageTitleService.setTitle("mdlo", "page_grid");
    }

    /* @ngInject */
    function ModuloDetailController($routeParams, pageTitleService, ModuloService) {
        var vm = this;

        vm.remove = remove;

        function remove() {
            ModuloService.remove(vm.model).then(function(data) {
                window.history.back();
            });
        }

        vm.search = {
            id : $routeParams.id
        };

        ModuloService.detail(vm.search).then(function(data) {
            vm.model = data.model;
        });

        pageTitleService.setTitle("mdlo", "page_detail");
    }

    /* @ngInject */
    function ModuloEditController($routeParams, pageTitleService, ModuloService) {
        var vm = this;

        vm.save = save;
        vm.cancel = cancel;

        function save() {
            ModuloService.save(vm.accion, vm.model).then(function(data) {
                ModuloService.redirectAfterSave(vm.accion, '/metamodelo/modulo/detail', [ data.model.id ]);
            });
        }

        function cancel() {
            window.history.back();
        }

        vm.accion = $routeParams.accion;
        vm.search = {
            id : $routeParams.id
        };

        ModuloService.edit(vm.accion, vm.search).then(function(data) {
            vm.model = data.model;
        });

        pageTitleService.setTitle("mdlo", "page_" + vm.accion);
    }

})();