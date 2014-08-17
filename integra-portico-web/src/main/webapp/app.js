var app = angular.module('integraApp', [ 'ui.bootstrap', 'ui.router', 'ngRoute', 'ui.bootstrap.datetimepicker',
        'pascalprecht.translate', 'configuracion', 'maestro', 'servicio', 'proceso', 'metamodelo' ]);

app.config(function($translateProvider) {
    $translateProvider.translations('es', {
        app_nombre : 'PORTICO',

        fmt_true : 'Si',
        fmt_false : 'No',
        fmt_integer : '#,###,###,##0',
        fmt_date : 'dd/MM/yyyy',
        fmt_datetime : 'dd/MM/yyyy HH:mm',

        boton_aceptar : 'Aceptar',
        boton_cancelar : 'Cancelar',
        boton_alta : 'Nuevo',
        boton_crear : 'Nuevo',
        boton_borrar : 'Borrar',
        boton_duplicar : 'Duplicar',
        boton_exportar : 'Exportar',
        boton_guardar : 'Guardar',
        boton_modificar : 'Editar',
        boton_editar : 'Editar',
        boton_volver : 'Volver',
        boton_filtro : 'Filtro',
        boton_imprimir : 'Imprimir',

        menu_tpsrs : 'Servicios',
        menu_peprs : 'Estadisticas',
        menu_tpprs : 'Maestros',
        menu_prbts : 'Procesos',
        menu_metamodelo_tpsrs : 'Tipos de Servicio',
        menu_metamodelo_tpess : 'Tipos de Estadistica',
        menu_metamodelo_tpprs : 'Tipos de Maestro',
        menu_metamodelo_tpdts : 'Tipos de Dato',
        menu_confs : 'Configuracion',

        modal_filtro : 'Filtro',
        limit : 'Max. Resultados',

        prmt_codigo : 'Codigo',
        prmt_finicio : 'F. Inicio',
        prmt_ffin : 'F. Fin',
        prmt_i18n_texto : 'Descripcion',
        prmtCriterio_parametro : 'Parametro',
        prmtCriterio_fechaVigencia : 'Fec. Vigencia',

        sprm_finicio : 'F. Inicio',
        sprm_ffin : 'F. Fin',

        cnen_codigo : 'Codigo',
        cnen_nombre : 'Nombre',

        srvc_servicio : 'Servicio',
        srvc_finicio : 'F. Inicio',
        srvc_ffin : 'F. Fin',
        srvc_freferencia : 'F. Referencia',
        srvc_estado : 'Estado',
        srvc_subp_id : 'Subpuerto',
        srvc_anno : 'A\u00f1o',
        srvc_numero : 'N\u00famero',

        ssrv_srvc : 'Servicio',
        ssrv_finicio : 'F. Inicio',
        ssrv_ffin : 'F. Fin',
        ssrv_numero : 'N\u00famero',
        ssrv_estado : 'Estado',
    });

    $translateProvider.preferredLanguage('es');
});

app.config(function($stateProvider, $urlRouterProvider) {
    $urlRouterProvider.when('/c?id', '/contacts/:id').when('/user/:id', '/contacts/:id').otherwise('/');

    $stateProvider.state("home", {
        url : "/",
        templateUrl : 'modules/home.html'
    })

    .state('tpsrs', {
        url : '/servicio/tpsrs',
        templateUrl : 'modules/servicio/tpsr-listado.html',
        controller : function($http, $scope) {
            $http.get("servicio/tpsr-listado-json.action").success(function(data) {
                // console.log(data);
                $scope.tpsrList = data.tpsrList;
                $scope.tpssMap = data.tpssMap;
            });
        }
    })

    .state('tpprs', {
        url : '/maestro/tpprs',
        templateUrl : 'modules/maestro/tppr-listado.html',
        controller : function($http, $scope) {
            $http.get("maestro/tppr-listado-json.action").success(function(data) {
                // console.log(data);
                $scope.tpprList = data.tpprList;
            });
        }
    })

    .state('peprs', {
        url : '/estadistica/peprs',
        templateUrl : 'modules/estadistica/pepr-listado.html',
        controller : function($http, $scope) {
            $http.get("estadistica/pepr-listado-json.action").success(function(data) {
                // console.log(data);
                $scope.peprList = data.peprList;
            });
        }
    })

    .state('prbts', {
        url : '/proceso/prbts',
        templateUrl : 'modules/proceso/prbt-listado.html',
        controller : function($http, $scope) {
            $http.get("proceso/prbt-listado-json.action").success(function(data) {
                // console.log(data);
                $scope.prbtList = data.prbtList;
            });
        }
    })

    .state('tpdts', {
        url : '/metamodelo/tpdts',
        templateUrl : 'modules/metamodelo/tpdt-listado.html',
        controller : function($http, $scope) {
            $http.get("metamodelo/tpdt-listado-json.action").success(function(data) {
                // console.log(data);
                $scope.tpdtList = data.tpdtList;
            });
        }
    })
});

/*
 * app.config([ '$routeProvider', function($routeProvider) {
 * $routeProvider.when('/servicio/tpsrs', { templateUrl :
 * 'modules/servicio/tpsr-listado.html', controller : 'tpsrsCtrl'
 * }).when('/estadistica/peprs', { templateUrl :
 * 'modules/estadistica/pepr-listado.html', controller : 'tpprsCtrl'
 * }).when('/maestro/tpprs', { templateUrl :
 * 'modules/maestro/tppr-listado.html', controller : 'tpprsCtrl'
 * }).when('/proceso/prbts', { templateUrl :
 * 'modules/proceso/prbt-listado.html', controller : 'ProcesoListController'
 * }).when('/metamodelo/tpprs', { templateUrl :
 * 'modules/metamodelo/tppr-listado.html', controller : 'tpprsCtrl'
 * }).when('/metamodelo/tpsrs', { templateUrl :
 * 'modules/metamodelo/tpsr-listado.html', controller : 'tpsrsCtrl'
 * }).when('/metamodelo/tpess', { templateUrl :
 * 'modules/metamodelo/tpes-listado.html', controller : 'tpprsCtrl'
 * }).when('/metamodelo/tpdts', { templateUrl :
 * 'modules/metamodelo/tpdt-listado.html', controller : 'tpprsCtrl'
 * }).when('/configuracion/confs', { templateUrl :
 * 'modules/configuracion/conf-listado.html', controller : 'tpprsCtrl'
 * }).when('/acceso', { templateUrl : 'modules/usro-acceso.html', controller :
 * 'tpprsCtrl' }); } ]);
 */
