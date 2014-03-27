var appControllers = angular.module('integraControllers', []);

appControllers.controller('tpprsCtrl', function($http, $scope) {
	// alert('Llamar al servidor');
	$http.get("maestro/tppr-listado-json.action").success(function(data) {
		// console.log(data);
		$scope.tpprs = data.tpprs;
	});
});

// Configuracion
appControllers.controller('cnensCtrl', function($http, $scope) {
	// alert('Llamar al servidor');
	$http.get("configuracion/cnen-listado-json.action").success(function(data) {
		// console.log(data);
		$scope.cnens = data.cnens;
	});
});

appControllers.controller('cnenCtrl', function($http, $scope, $routeParams) {
	var url = "configuracion/cnen-detalle-json.action?cnen.id="
			+ $routeParams.cnenId;

	$http.get(url).success(function(data) {
		// console.log(data);
		$scope.cnen = data.cnen;
	});
});
