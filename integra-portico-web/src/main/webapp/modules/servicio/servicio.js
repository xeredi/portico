angular.module('servicio', [ 'ui.router' ])

.config(

        function($stateProvider, $urlRouterProvider) {
            $stateProvider

            .state('srvcs', {
                abstract : true,
                url : '/servicio/srvcs',
                templateUrl : 'modules/servicio/srvcs.html'/*,
                resolve : {
                    itemList : {}
                },
                controller : function($scope, $state, itemList) {
                    $scope.enti = {};
                    $scope.itemList = itemList;
                    $scope.itemCriterio = {};
                }*/
            })

            .state(
                    'srvcs.list',
                    {
                        url : '/:entiId/:page',
                        templateUrl : 'modules/servicio/srvc-listado.html',

                        controller : function($http, $scope, $stateParams) {
                            $scope.loadData = function() {
                                var url = "servicio/srvc-listado.action?itemCriterio.entiId=" + $stateParams.entiId
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
            /*
             * .state('srvcs.detail', { url : '/:itemId', views : { '' : {
             * templateUrl : 'app/contacts/contacts.detail.html', controller : [
             * '$scope', '$stateParams', 'utils', function($scope, $stateParams,
             * utils) { $scope.contact = utils.findById($scope.contacts,
             * $stateParams.contactId); } ] }, 'hint@' : { template : 'This is
             * contacts.detail populating the "hint" ui-view' }, 'menuTip' : {
             * templateProvider : function($stateParams) { return '<hr><small
             * class="muted">Contact ID: ' + $stateParams.contactId + '</small>'; } } } })
             *
             * .state('contacts.detail.item', { url : '/item/:itemId', views : { '' : {
             * templateUrl : 'app/contacts/contacts.detail.item.html',
             * controller : function($scope, $stateParams, $state, utils) {
             * $scope.item = utils.findById($scope.contact.items,
             * $stateParams.itemId);
             *
             * $scope.edit = function() { $state.go('.edit', $stateParams); }; } },
             * 'hint@' : { template : ' This is contacts.detail.item overriding
             * the "hint" ui-view' } } })
             *
             * .state('contacts.detail.item.edit', { views : {
             * '@contacts.detail' : { templateUrl :
             * 'app/contacts/contacts.detail.item.edit.html', controller :
             * function($scope, $stateParams, $state, utils) { $scope.item =
             * utils.findById($scope.contact.items, $stateParams.itemId);
             * $scope.done = function() { $state.go('^', $stateParams); }; } } } })
             */
        })
/*
.controller(
        'srvcsCtrl',
        function($http, $scope, $routeParams) {
            $scope.loadData = function() {
                var url = "servicio/srvc-listado-json.action?itemCriterio.entiId=" + $routeParams.entiId + "&page="
                        + $routeParams.page;

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
        })

.controller('srvcCtrl', function($http, $scope, $routeParams) {
    if ($routeParams.itemId) {
        var url = "servicio/srvc-detalle-json.action?item.id=" + $routeParams.itemId;

        $http.get(url).success(function(data) {
            // console.log(data);
            $scope.enti = data.enti;
            $scope.item = data.item;
            $scope.entiHijasList = data.entiHijasList;
            $scope.itemHijosMap = data.itemHijosMap;
        });
    }
})

.controller('srvcTabsCtrl', function($scope) {
    $scope.navType = 'pills';
})

.controller(
        'ssrvsCtrl',
        function($http, $scope, $routeParams) {
            $scope.loadData = function() {
                var url = "servicio/ssrv-listado-json.action?itemCriterio.entiId=" + $routeParams.entiId + "&page="
                        + $routeParams.page;

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
        })

.controller('ssrvCtrl', function($http, $scope, $routeParams) {
    if ($routeParams.itemId) {
        var url = "servicio/ssrv-detalle-json.action?item.id=" + $routeParams.itemId;

        $http.get(url).success(function(data) {
            // console.log(data);
            $scope.enti = data.enti;
            $scope.item = data.item;
            $scope.entiHijasList = data.entiHijasList;
            $scope.itemHijosMap = data.itemHijosMap;
        });
    }
})

.controller('ssrvTabsCtrl', function($scope) {
    $scope.navType = 'pills';
})
*/
;
