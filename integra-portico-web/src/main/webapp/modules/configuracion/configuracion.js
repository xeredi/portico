var configuracion = angular.module('configuracion', [ 'ngRoute' ]);

configuracion.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/configuracion/cnens', {
		templateUrl : 'modules/configuracion/cnen-listado.html',
		controller : 'cnensCtrl'
	}).when('/configuracion/cnens/:cnenId', {
		templateUrl : 'modules/configuracion/cnen-detalle.html',
		controller : 'cnenCtrl'
	}).when('/configuracion/cnen/:action/', {
		templateUrl : 'modules/configuracion/cnen-edicion.html',
		controller : 'cnenCtrl'
	}).when('/configuracion/cnen/:action/:cnenId', {
		templateUrl : 'modules/configuracion/cnen-edicion.html',
		controller : 'cnenCtrl'
	}).when('/configuracion/cnids', {
		templateUrl : 'modules/configuracion/cnid-listado.html'/*
																 * , controller :
																 * 'PhoneListCtrl'
																 */
	}).when('/configuracion/cncls', {
		templateUrl : 'modules/configuracion/cncl-listado.html'/*
																 * , controller :
																 * 'PhoneListCtrl'
																 */
	}).when('/configuracion/cncis', {
		templateUrl : 'modules/configuracion/cnci-listado.html'/*
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
