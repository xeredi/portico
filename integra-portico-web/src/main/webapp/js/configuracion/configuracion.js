var configuracion = angular.module('configuracion', [ 'ngRoute' ]);

configuracion.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/configuracion/cnens', {
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
	});
} ]);

configuracion.controller('cnensCtrl', function($http, $scope) {
	// alert('Llamar al servidor');
	$http.get("configuracion/cnen-listado-json.action").success(function(data) {
		// console.log(data);
		$scope.cnens = data.cnens;
	});
});

configuracion.controller('cnenCtrl', function($http, $scope, $routeParams) {
	if ($routeParams.cnenId) {
		var url = "configuracion/cnen-detalle-json.action?cnen.id="
				+ $routeParams.cnenId;

		$http.get(url).success(function(data) {
			// console.log(data);
			$scope.cnen = data.cnen;
		});
	}
});
