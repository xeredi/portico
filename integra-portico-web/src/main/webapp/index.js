var app = angular.module('integraApp', [ 'ngRoute', 'integraControllers' ]);

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
	}).when('/acceso', {
		templateUrl : 'partials/usro-acceso.html'/*
													 * , controller :
													 * 'PhoneListCtrl'
													 */
	}).otherwise({
		redirectTo : '/acceso'
	});
} ]);