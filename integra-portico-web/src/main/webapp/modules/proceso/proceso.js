(function() {
    var app = angular.module("proceso", []);

    app.config([ '$routeProvider', function($routeProvider) {
        $routeProvider.when('/proceso/prbt/:id', {
            templateUrl : 'modules/proceso/prbt-detalle.html',
            controller : 'ProcesoDetailController'
        });
    } ]);

    app.controller('ProcesoListController', function($scope, $http, $route, $routeParams, $modal) {
        $scope.loadData = function() {
            if ($scope.prbtCriteria == undefined) {
                $scope.prbtCriteria = {};
            }

            var url = 'proceso/prbt-listado-json.action';

            $http.post(url, {
                prbtCriteria : $scope.prbtCriteria
            }).success(function(response) {
                $scope.prbtList = response.prbtList;
            });
        }

        $scope.filter = function() {
            console.log('Filter');

            var modalInstance = $modal.open({
                templateUrl : 'modules/catalog/prbt-filter.html',
                controller : 'ModalInstanceCtrl',
                resolve : {
                    prbtCriteria : function() {
                        return $scope.prbtCriteria;
                    }
                }
            });

            modalInstance.result.then(function(prbtCriteria) {
                $scope.prbtCriteria = prbtCriteria;
                $scope.loadData();
            }, function() {
                console.log('Modal dismissed at: ' + new Date());
            });
        };

        $scope.loadData();
    });

    app.controller('ModalInstanceCtrl', function($scope, $modalInstance, prbtCriteria) {
        console.log('Modal Instance: ' + prbtCriteria);

        $scope.prbtCriteria = prbtCriteria;

        $scope.ok = function() {
            $modalInstance.close($scope.prbtCriteria);
        }

        $scope.cancel = function() {
            $modalInstance.dismiss('cancel');
        }
    });

    app.controller('ProcesoDetailController', function($scope, $http, $route, $routeParams) {
        var url = 'proceso/prbt-detalle-json.action?prbt.id=' + $routeParams.id;

        $http.get(url).success(function(response) {
            $scope.prbt = response.prbt;
        });
    });

    /*
    app.controller('TrademarkInsertController', function($scope, $http, $route, $routeParams, $location) {
        $scope.save = function() {
            $http.post('catalog/trademark-insert.action', {
                trdm : $scope.trdm,
                vndrId : $routeParams.vndrId
            }).success(function(data) {
                var url = '/trademark-detail/' + data.vndrId + '/' + data.trdm.id;

                $location.path(url);
            });
        };
    });

    app.controller('TrademarkUpdateController', function($scope, $http, $route, $routeParams) {
        $scope.save = function() {
            $http.post('catalog/trademark-update.action', {
                trdm : $scope.trdm,
                vndrId : $routeParams.vndrId
            }).success(function(data) {
                var url = '/trademark-detail/' + data.vndrId + '/' + data.trdm.id;

                $location.path(url);
            });
        };

        var url = 'catalog/trademark-detail.action?vndrId=' + $routeParams.vndrId + "&trdm.id=" + $routeParams.id;

        $http.get(url).success(function(response) {
            $scope.trdm = response.trdm;
        });
    });
*/
})();
