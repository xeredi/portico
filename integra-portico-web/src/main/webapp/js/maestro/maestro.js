var maestro = angular.module('maestro', [ 'ngRoute' ]);

maestro.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/maestro/prmts/:entiId', {
		templateUrl : 'partials/maestro/prmt-listado.html',
		controller : 'prmtsCtrl'
	}).when('/maestro/prmt/:itemId', {
		templateUrl : 'partials/maestro/prmt-detalle.html',
		controller : 'prmtCtrl'
	});
} ]);

maestro.controller('prmtsCtrl', function($http, $scope, $routeParams) {
	if ($routeParams.entiId) {
		var url = "maestro/prmt-listado-json.action?itemCriterio.entiId="
				+ $routeParams.entiId;

		$http.get(url).success(function(data) {
			console.log(data);
			$scope.enti = data.enti;
			$scope.itemList = data.itemList;
		});
	}

	$scope.maxSize = 1;
	$scope.pageChanged = function(page) {
		var url = "maestro/prmt-listado-json.action?itemCriterio.entiId="
				+ $routeParams.entiId + "&page=" + page;

		$http.get(url).success(function(data) {
			console.log(data);
			$scope.enti = data.enti;
			$scope.itemList = data.itemList;
		});
	};
});

maestro.controller('prmtCtrl', function($http, $scope, $routeParams) {
	if ($routeParams.itemId) {
		var url = "maestro/prmt-detalle-json.action?item.id="
				+ $routeParams.itemId;

		$http.get(url).success(function(data) {
			console.log(data);
			$scope.enti = data.enti;
			$scope.item = data.item;
			$scope.p18nMap = data.p18nMap;
			$scope.entiHijasList = data.entiHijasList;
			$scope.itemHijosMap = data.itemHijosMap;
		});
	}
});

maestro.controller('prmtTabsCtrl', function($scope) {
	$scope.navType = 'pills';
});

