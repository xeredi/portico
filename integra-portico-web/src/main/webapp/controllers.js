var appControllers = angular.module('integraControllers', []);

appControllers.controller('tpprsCtrl', function($http) {
	// alert('Llamar al servidor');
	var app = this;

	$http.get("maestro/tppr-listado-json.action").success(function(data) {
		// console.log(data);
		app.tpprs = data.tpprs;
	});
});

// Configuracion
appControllers.controller('cnensCtrl', function($http) {
	// alert('Llamar al servidor');
	var app = this;

	$http.get("configuracion/cnen-listado-json.action").success(function(data) {
		// console.log(data);
		app.cnens = data.cnens;
	});
});

appControllers.controller('cnenCtrl', [
		'$http',
		'$scope',
		'$routeParams',
		function($http, $scope, $routeParams) {
			alert('cnen');

			var app = this;
			var url = "configuracion/cnen-detalle-json.action?cnen.id="
					+ $routeParams.cnen.id;
			alert(url);

			$http.get(url).success(function(data) {
				// console.log(data);
				app.cnen = data.cnen;
			});
		} ]);
