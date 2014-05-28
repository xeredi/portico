var app = angular.module('integraApp', [ 'ui.bootstrap', 'ngRoute',
		'ui.bootstrap.datetimepicker', 'pascalprecht.translate',
		'configuracion', 'maestro', 'servicio' ]);

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
		boton_borrar : 'Borrar',
		boton_duplicar : 'Duplicar',
		boton_exportar : 'Exportar',
		boton_guardar : 'Guardar',
		boton_modificar : 'Editar',
		boton_editar : 'Editar',
		boton_volver : 'Volver',
		boton_filtro : 'Filtro',

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

app.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/servicio/tpsrs', {
		templateUrl : 'partials/servicio/tpsr-listado.html',
		controller : 'tpsrsCtrl'
	}).when('/estadistica/peprs', {
		templateUrl : 'partials/estadistica/pepr-listado.html',
		controller : 'tpprsCtrl'
	}).when('/maestro/tpprs', {
		templateUrl : 'partials/maestro/tppr-listado.html',
		controller : 'tpprsCtrl'
	}).when('/proceso/prbts', {
		templateUrl : 'partials/proceso/prbt-listado.html',
		controller : 'tpprsCtrl'
	}).when('/metamodelo/tpprs', {
		templateUrl : 'partials/metamodelo/tppr-listado.html',
		controller : 'tpprsCtrl'
	}).when('/metamodelo/tpsrs', {
		templateUrl : 'partials/metamodelo/tpsr-listado.html',
		controller : 'tpsrsCtrl'
	}).when('/metamodelo/tpess', {
		templateUrl : 'partials/metamodelo/tpes-listado.html',
		controller : 'tpprsCtrl'
	}).when('/metamodelo/tpdts', {
		templateUrl : 'partials/metamodelo/tpdt-listado.html',
		controller : 'tpprsCtrl'
	}).when('/configuracion/confs', {
		templateUrl : 'partials/configuracion/conf-listado.html',
		controller : 'tpprsCtrl'
	}).when('/acceso', {
		templateUrl : 'partials/usro-acceso.html',
		controller : 'tpprsCtrl'
	});
} ]);

app.controller('tpprsCtrl', function($http, $scope) {
	// alert('Llamar al servidor');
	$http.get("maestro/tppr-listado-json.action").success(function(data) {
		// console.log(data);
		$scope.tpprs = data.tpprs;
	});
});

app.controller('tpsrsCtrl', function($http, $scope) {
	// alert('Llamar al servidor');
	$http.get("servicio/tpsr-listado-json.action").success(function(data) {
		// console.log(data);
		$scope.tpsrs = data.tpsrs;
		$scope.tpssMap = data.tpssMap;
	});
});
