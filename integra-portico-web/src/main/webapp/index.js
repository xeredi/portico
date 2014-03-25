var integraApp = angular.module('integraApp', [ 'ngRoute' ]);

integraApp.config([ '$routeProvider', function($routeProvider) {
	// alert('URL');
	
	$routeProvider
	.when('/servicio/tpsrs', {
		templateUrl : 'partials/servicio/tpsr-listado.html'/*,
		controller : 'PhoneListCtrl'*/
	})
	.when('/estadistica/peprs', {
		templateUrl : 'partials/estadistica/pepr-listado.html'/*,
		controller : 'PhoneListCtrl'*/
	})
	.when('/acceso', {
		templateUrl : 'partials/usro-acceso.html'/*,
		controller : 'PhoneListCtrl'*/
	})
	/*
	.otherwise({
		redirectTo : '/acceso'
	})
	*/;
} ]);