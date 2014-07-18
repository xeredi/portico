var servicio = angular.module('servicio', [ 'ui-route' ]);
/*
servicio.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/servicio/srvcs/:entiId', {
		templateUrl : 'modules/servicio/srvc-listado.html',
		controller : 'srvcsCtrl'
	}).when('/servicio/srvc/:itemId', {
		templateUrl : 'modules/servicio/srvc-detalle.html',
		controller : 'srvcCtrl'
	}).when('/servicio/ssrvs/:entiId', {
		templateUrl : 'modules/servicio/ssrv-listado.html',
		controller : 'ssrvsCtrl'
	}).when('/servicio/ssrv/:itemId', {
		templateUrl : 'modules/servicio/ssrv-detalle.html',
		controller : 'ssrvCtrl'
	});
} ]);
*/

servicio.config(function($stateProvider, $urlRouterProvider) {
$stateProvider

.state(
        'prmts',
        {
            url : '/maestro/prmts/:entiId/:page',
            templateUrl : 'modules/maestro/prmt-listado.html',
            controller : function($http, $scope, $stateParams) {
                alert('Listado');

                $scope.loadData = function() {
                    var url = "maestro/prmt-listado-json.action?itemCriterio.entiId=" + $stateParams.entiId
                            + "&page=" + $stateParams.page;

                    $http.get(url).success(function(data) {
                        // console.log(data);
                        $scope.enti = data.enti;
                        $scope.itemList = data.itemList;
                        $scope.itemCriterio = data.itemCriterio;
                    });
                };

                $scope.pageChanged = function() {
                    $stateParams.page = $scope.currentPage;

                    $scope.loadData();
                };

                $scope.loadData();
            }
        })
});







servicio.controller('srvcsCtrl', function($http, $scope, $routeParams) {
	$scope.loadData = function() {
		var url = "servicio/srvc-listado-json.action?itemCriterio.entiId="
				+ $routeParams.entiId + "&page=" + $routeParams.page;

		$http.get(url).success(function(data) {
			console.log(data);
			$scope.enti = data.enti;
			$scope.itemList = data.itemList;
		});
	};

	$scope.pageChanged = function() {
		$routeParams.page = $scope.currentPage;
		$scope.loadData();
	};

	if ($scope.currentPage == null) {
		$routeParams.page = 1;
	}

	$scope.currentPage = 1;
	$scope.loadData();
});

servicio.controller('srvcCtrl', function($http, $scope, $routeParams) {
	if ($routeParams.itemId) {
		var url = "servicio/srvc-detalle-json.action?item.id="
				+ $routeParams.itemId;

		$http.get(url).success(function(data) {
			// console.log(data);
			$scope.enti = data.enti;
			$scope.item = data.item;
			$scope.entiHijasList = data.entiHijasList;
			$scope.itemHijosMap = data.itemHijosMap;
		});
	}
});

servicio.controller('srvcTabsCtrl', function($scope) {
	$scope.navType = 'pills';
});

servicio.controller('ssrvsCtrl', function($http, $scope, $routeParams) {
	$scope.loadData = function() {
		var url = "servicio/ssrv-listado-json.action?itemCriterio.entiId="
				+ $routeParams.entiId + "&page=" + $routeParams.page;

		$http.get(url).success(function(data) {
			console.log(data);
			$scope.enti = data.enti;
			$scope.itemList = data.itemList;
		});
	};

	$scope.pageChanged = function() {
		$routeParams.page = $scope.currentPage;
		$scope.loadData();
	};

	if ($scope.currentPage == null) {
		$routeParams.page = 1;
	}

	$scope.currentPage = 1;
	$scope.loadData();
});

servicio.controller('ssrvCtrl', function($http, $scope, $routeParams) {
	if ($routeParams.itemId) {
		var url = "servicio/ssrv-detalle-json.action?item.id="
				+ $routeParams.itemId;

		$http.get(url).success(function(data) {
			// console.log(data);
			$scope.enti = data.enti;
			$scope.item = data.item;
			$scope.entiHijasList = data.entiHijasList;
			$scope.itemHijosMap = data.itemHijosMap;
		});
	}
});

servicio.controller('ssrvTabsCtrl', function($scope) {
	$scope.navType = 'pills';
});

