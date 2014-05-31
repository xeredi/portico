var maestro = angular.module('maestro', [ 'ngRoute' ]);

maestro.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/maestro/prmts/:entiId/:page', {
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
		controller : 'prmtCtrl'
	}).when('/maestro/prmt/:itemId', {
		templateUrl : 'partials/maestro/prmt-detalle.html',
		controller : 'prmtCtrl'
	});
} ]);

maestro.controller('prmtsCtrl', function($http, $scope, $routeParams, $modal) {
	$scope.loadData = function() {
		var url = "maestro/prmt-listado-json.action?itemCriterio.entiId="
				+ $routeParams.entiId + "&page=" + $routeParams.page;

		// alert($routeParams.page);

		$http.get(url).success(function(data) {
			// console.log(data);
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
				entiId : function() {
					return $routeParams.entiId;
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

	$scope.editar = function() {
		alert('editar: ' + $scope.itemIds);
	}

	if ($routeParams.page == null) {
		// alert('inicializar numero de pagina');

		$routeParams.page = 1;
	}

	$scope.page = $routeParams.page;
	$scope.currentPage = $routeParams.page;

	$scope.loadData();
});

maestro.controller('prmtsLupaCtrl', function($http, $scope) {
	$scope.getLabelValues = function(entiId, textoBusqueda) {
		return $http.get(
				'maestro/prmt-lupa.action?itemLupaCriterio.entiId=' + entiId
						+ "&itemLupaCriterio.textoBusqueda=" + textoBusqueda
						+ "&itemLupaCriterio.fechaVigencia=11/12/2014").then(
				function(res) {
					// console.log(res.data);

					var labelValues = [];

					angular.forEach(res.data.itemList, function(item) {
						labelValues.push(item.label);
					});

					return labelValues;
				});
	};
});

maestro.controller('prmtsFiltroCtrl', function($http, $scope, $modalInstance,
		entiId, itemCriterio) {
	$scope.itemCriterio = itemCriterio;

	var url = "maestro/prmt-filtro-json.action?itemCriterio.entiId=" + entiId;

	$http.get(url).success(function(data) {
		// console.log(data);
		$scope.enti = data.enti;
		$scope.limits = data.limits;
		$scope.labelValuesMap = data.labelValuesMap;
	});

	$scope.ok = function() {
		$modalInstance.close();
	};

	$scope.cancel = function() {
		$modalInstance.dismiss('cancel');
	};
});

maestro.controller('prmtCtrl',
		function($http, $scope, $routeParams, $location) {
			$scope.crear = function(entiId) {
				if (entiId) {
					$location.path('/maestro/prmt/crear/' + entiId);

					alert('alta');

					var url = "maestro/prmt-crear-json.action?item.entiId="
							+ entiId;

					$http.get(url).success(function(data) {
						// console.log(data);
						$scope.enti = data.enti;
						$scope.item = data.item;
						$scope.p18nMap = data.p18nMap;
						$scope.availableLanguages = data.availableLanguages;
						$scope.labelValuesMap = data.labelValuesMap;
					});
				}
			};

			$scope.borrar = function(itemId) {
				alert('borrar: ' + itemId);
			};

			$scope.imprimir = function(itemId) {
				if (itemId) {
					var url = "maestro/prmt-imprimir.action?item.id=" + itemId;

					$http({
						method : 'GET',
						url : "maestro/prmt-imprimir.action?item.id=" + itemId
					});
				}
			};

			if ($routeParams.itemId && $scope.enti == null) {
				var url = "maestro/prmt-detalle-json.action?item.id="
						+ $routeParams.itemId;

				$http.get(url).success(function(data) { // console.log(data);
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

maestro.controller('prmtCrearCtrl', function($http, $scope, $routeParams) {
	if ($routeParams.entiId) {
		var url = "maestro/prmt-crear-json.action?item.entiId="
				+ $routeParams.entiId;

		$http.get(url).success(function(data) {
			// console.log(data);
			$scope.accion = data.accion;
			$scope.enti = data.enti;
			$scope.item = data.item;
			$scope.p18nMap = data.p18nMap;
			$scope.availableLanguages = data.availableLanguages;
			$scope.labelValuesMap = data.labelValuesMap;
		});
	}
});

maestro.controller('prmtEditarCtrl', function($http, $scope, $routeParams) {
	if ($routeParams.itemId) {
		var url = "maestro/prmt-editar-json.action?item.id="
				+ $routeParams.itemId;

		$http.get(url).success(function(data) {
			// console.log(data);
			$scope.accion = data.accion;
			$scope.enti = data.enti;
			$scope.item = data.item;
			$scope.p18nMap = data.p18nMap;
			$scope.availableLanguages = data.availableLanguages;
			$scope.labelValuesMap = data.labelValuesMap;
		});
	}
});

maestro.controller('prmtDuplicarCtrl', function($http, $scope, $routeParams) {
	if ($routeParams.itemId) {
		var url = "maestro/prmt-duplicar-json.action?item.id="
				+ $routeParams.itemId;

		$http.get(url).success(function(data) {
			// console.log(data);
			$scope.accion = data.accion;
			$scope.enti = data.enti;
			$scope.item = data.item;
			$scope.p18nMap = data.p18nMap;
			$scope.availableLanguages = data.availableLanguages;
			$scope.labelValuesMap = data.labelValuesMap;
		});
	}
});

maestro.controller('prmtGuardarCtrl', function($scope) {
	$scope.submit = function() {
		console.log($scope.accion);
		console.log($scope.item);
		console.log($scope.p18nMap);
	};
});
