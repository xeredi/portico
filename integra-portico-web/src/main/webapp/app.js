var app = angular.module("integraApp", [ "ui.bootstrap", "pascalprecht.translate", "ngRoute", "util", "i18n",
        'cdrf_i18n', "metamodelo", "facturacion", "maestro", "servicio", "estadistica", "proceso"/*
                                                                                                     * 'configuracion',
                                                                                                     */]);

app.config([ "$routeProvider", function($routeProvider) {
    $routeProvider

    .when("/", {
        title : 'home',
        templateUrl : "modules/home.html",
    })
} ]);

app.config([ '$httpProvider', function($httpProvider) {
    // initialize get if not there
    if (!$httpProvider.defaults.headers.get) {
        $httpProvider.defaults.headers.get = {};
    }
    // disable IE ajax request caching
    $httpProvider.defaults.headers.get['Cache-Control'] = 'no-cache';
    $httpProvider.defaults.headers.get['Pragma'] = 'no-cache';
} ]);

app.run([ '$location', '$rootScope', function($location, $rootScope) {
    $rootScope.$on('$routeChangeSuccess', function(event, current, previous) {
        $rootScope.title = current.$$route.title;
    });
} ]);
