var maestro = angular.module('maestro', [ 'ngRoute' ]);

maestro.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/maestro/prmts/:entiId', {
		templateUrl : 'partials/maestro/prmt-listado.html',
		controller : 'prmtsCtrl'
	}).when('/maestro/prmts/exportar/:entiId', {
		controller : 'prmtsExportCtrl'
	}).when('/maestro/prmt/crear/:entiId', {
		templateUrl : 'partials/maestro/prmt-edicion.html',
		controller : 'prmtCrearCtrl'
	}).when('/maestro/prmt/editar/:itemId', {
		templateUrl : 'partials/maestro/prmt-edicion.html',
		controller : 'prmtEditarCtrl'
	}).when('/maestro/prmt/duplicar/:itemId', {
		templateUrl : 'partials/maestro/prmt-edicion.html',
		controller : 'prmtDuplicarCtrl'
	}).when('/maestro/prmt/imprimir/:itemId', {
		controller : 'prmtImprimirCtrl'
	}).when('/maestro/prmt/:itemId', {
		templateUrl : 'partials/maestro/prmt-detalle.html',
		controller : 'prmtCtrl'
	});
} ]);

maestro.controller('prmtsCtrl', function($http, $scope, $routeParams, $modal) {
	$scope.loadData = function() {
		var url = "maestro/prmt-listado-json.action?itemCriterio.entiId="
				+ $routeParams.entiId + "&page=" + $routeParams.page;

		$http.get(url).success(function(data) {
			console.log(data);
			$scope.enti = data.enti;
			$scope.itemList = data.itemList;
			$scope.itemCriterio = data.itemCriterio;
		});
	};

	$scope.pageChanged = function() {
		$routeParams.page = $scope.currentPage;
		$scope.loadData();
	};

	$scope.openFiltro = function(size) {
		var modalInstance = $modal.open({
			templateUrl : 'partials/maestro/prmt-filtro.html',
			controller : 'prmtsFiltroCtrl',
			size : size,
			resolve : {
				enti : function() {
					return $scope.enti;
				},
				itemCriterio : function() {
					return $scope.itemCriterio;
				}
			}
		});

		modalInstance.result.then(function() {
		}, function() {
		});
	};

	if ($scope.currentPage == null) {
		$routeParams.page = 1;
	}

	$scope.currentPage = 1;
	$scope.loadData();
});

maestro.controller('prmtsFiltroCtrl', function($scope, $modalInstance) {
	$scope.ok = function() {
		$modalInstance.close();
	};

	$scope.cancel = function() {
		$modalInstance.dismiss('cancel');
	};
});

maestro.controller('prmtCtrl', function($http, $scope, $routeParams) {
	if ($routeParams.itemId) {
		var url = "maestro/prmt-detalle-json.action?item.id="
				+ $routeParams.itemId;

		$http.get(url).success(function(data) {
			// console.log(data);
			$scope.enti = data.enti;
			$scope.item = data.item;
			$scope.p18nMap = data.p18nMap;
			$scope.entiHijasList = data.entiHijasList;
			$scope.itemHijosMap = data.itemHijosMap;
			$scope.availableLanguages = data.availableLanguages;
		});
	}
});

maestro.controller('prmtCrearCtrl', function($http, $scope, $routeParams) {
	if ($routeParams.entiId) {
		var url = "maestro/prmt-alta-json.action?item.entiId="
				+ $routeParams.entiId;

		$http.get(url).success(function(data) {
			// console.log(data);
			$scope.enti = data.enti;
			$scope.item = data.item;
			$scope.p18nMap = data.p18nMap;
			$scope.entiHijasList = data.entiHijasList;
			$scope.itemHijosMap = data.itemHijosMap;
			$scope.availableLanguages = data.availableLanguages;
		});
	}
});

maestro.controller('prmtEditarCtrl', function($http, $scope, $routeParams) {
	if ($routeParams.itemId) {
		var url = "maestro/prmt-edicion-json.action?item.id="
				+ $routeParams.itemId;

		$http.get(url).success(function(data) {
			// console.log(data);
			$scope.enti = data.enti;
			$scope.item = data.item;
			$scope.p18nMap = data.p18nMap;
			$scope.entiHijasList = data.entiHijasList;
			$scope.itemHijosMap = data.itemHijosMap;
			$scope.availableLanguages = data.availableLanguages;
		});
	}
});

maestro.controller('prmtDuplicarCtrl', function($http, $scope, $routeParams) {
	if ($routeParams.itemId) {
		var url = "maestro/prmt-duplicar-json.action?item.id="
				+ $routeParams.itemId;

		$http.get(url).success(function(data) {
			// console.log(data);
			$scope.enti = data.enti;
			$scope.item = data.item;
			$scope.p18nMap = data.p18nMap;
			$scope.entiHijasList = data.entiHijasList;
			$scope.itemHijosMap = data.itemHijosMap;
			$scope.availableLanguages = data.availableLanguages;
		});
	}
});

maestro.controller('prmtTabsCtrl', function($scope) {
	$scope.navType = 'pills';
});
