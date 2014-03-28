var app = angular.module('integraApp', [ 'ngRoute', 'integraControllers',
		'pascalprecht.translate' ]);

app.config(function($translateProvider) {
	$translateProvider.translations('es', {
		app_nombre : 'PORTICO',

		fmt_date : 'dd/MM/yyyy',
		fmt_datetime : 'dd/MM/yyyy HH:mm',

		boton_alta : 'Nuevo',
		boton_borrar : 'Borrar',
		boton_duplicar : 'Duplicar',
		boton_exportar : 'Exportar',
		boton_guardar : 'Guardar',
		boton_modificar : 'Editar',
		boton_volver : 'Volver',

		menu_tpsrs : 'Servicios',
		menu_peprs : 'Estadisticas',
		menu_tpprs : 'Maestros',
		menu_prbts : 'Procesos',
		menu_metamodelo_tpsrs : 'Tipos de Servicio',
		menu_metamodelo_tpess : 'Tipos de Estadistica',
		menu_metamodelo_tpprs : 'Tipos de Maestro',
		menu_metamodelo_tpdts : 'Tipos de Dato',
		menu_confs : 'Configuracion',

		prmt_codigo : 'Codigo',
		prmt_finicio : 'F. Inicio',
		prmt_ffin : 'F. Fin',
		prmt_i18n_texto : 'Descripcion',

		cnen_codigo : 'Codigo',
		cnen_nombre : 'Nombre',
	});

	$translateProvider.preferredLanguage('es');
});

app.config([ '$routeProvider', function($routeProvider) {
	// alert('URL');

	$routeProvider.when('/servicio/tpsrs', {
		templateUrl : 'partials/servicio/tpsr-listado.html'/*
															 * , controller :
															 * 'PhoneListCtrl'
															 */
	}).when('/estadistica/peprs', {
		templateUrl : 'partials/estadistica/pepr-listado.html'/*
																 * , controller :
																 * 'PhoneListCtrl'
																 */
	}).when('/maestro/tpprs', {
		templateUrl : 'partials/maestro/tppr-listado.html',
		controller : 'tpprsCtrl'
	}).when('/maestro/prmts/:entiId', {
		templateUrl : 'partials/maestro/prmt-listado.html',
		controller : 'prmtsCtrl'
	}).when('/proceso/prbts', {
		templateUrl : 'partials/proceso/prbt-listado.html'/*
															 * , controller :
															 * 'PhoneListCtrl'
															 */
	}).when('/metamodelo/tpprs', {
		templateUrl : 'partials/metamodelo/tppr-listado.html'/*
																 * , controller :
																 * 'PhoneListCtrl'
																 */
	}).when('/metamodelo/tpsrs', {
		templateUrl : 'partials/metamodelo/tpsr-listado.html'/*
																 * , controller :
																 * 'PhoneListCtrl'
																 */
	}).when('/metamodelo/tpess', {
		templateUrl : 'partials/metamodelo/tpes-listado.html'/*
																 * , controller :
																 * 'PhoneListCtrl'
																 */
	}).when('/metamodelo/tpdts', {
		templateUrl : 'partials/metamodelo/tpdt-listado.html'/*
																 * , controller :
																 * 'PhoneListCtrl'
																 */
	}).when('/configuracion/confs', {
		templateUrl : 'partials/configuracion/conf-listado.html'/*
																 * , controller :
																 * 'PhoneListCtrl'
																 */
	}).when('/configuracion/cnens', {
		templateUrl : 'partials/configuracion/cnen-listado.html',
		controller : 'cnensCtrl'
	}).when('/configuracion/cnens/:cnenId', {
		templateUrl : 'partials/configuracion/cnen-detalle.html',
		controller : 'cnenCtrl'
	}).when('/configuracion/cnen/:action/', {
		templateUrl : 'partials/configuracion/cnen-edicion.html',
		controller : 'cnenCtrl'
	}).when('/configuracion/cnen/:action/:cnenId', {
		templateUrl : 'partials/configuracion/cnen-edicion.html',
		controller : 'cnenCtrl'
	}).when('/configuracion/cnids', {
		templateUrl : 'partials/configuracion/cnid-listado.html'/*
																 * , controller :
																 * 'PhoneListCtrl'
																 */
	}).when('/configuracion/cncls', {
		templateUrl : 'partials/configuracion/cncl-listado.html'/*
																 * , controller :
																 * 'PhoneListCtrl'
																 */
	}).when('/configuracion/cncis', {
		templateUrl : 'partials/configuracion/cnci-listado.html'/*
																 * , controller :
																 * 'PhoneListCtrl'
																 */
	}).when('/acceso', {
		templateUrl : 'partials/usro-acceso.html'/*
													 * , controller :
													 * 'PhoneListCtrl'
													 */
	}).otherwise({
		redirectTo : '/acceso'
	});
} ]);