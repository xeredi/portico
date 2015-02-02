angular.module(
        "integraApp",
        [ "ui.bootstrap", "mgcrea.ngStrap.datepicker", "mgcrea.ngStrap.timepicker", "mgcrea.ngStrap.tooltip",
                "pascalprecht.translate", "angularSpinner", "ngRoute", "util", "i18n", "administracion", "metamodelo",
                "facturacion", "maestro", "servicio", "estadistica", "proceso" ])

.config([ "$routeProvider", function($routeProvider) {
    $routeProvider

    .when("/", {
        title : 'home',
        templateUrl : "modules/home.html",
    })
} ])

.config(function($datepickerProvider) {
    angular.extend($datepickerProvider.defaults, {
        dateFormat : 'dd/MM/yyyy',
        startWeek : 1,
        container : 'body',
        autoclose : true
    })
})

.config(function($timepickerProvider) {
    angular.extend($timepickerProvider.defaults, {
        timeFormat : 'HH:mm',
        length : 1,
        minuteStep : 1
    })
})

.config(function($tooltipProvider) {
    angular.extend($tooltipProvider.defaults, {
        container : 'body'
    })
})

.config([ '$httpProvider', function($httpProvider) {
    var activeRequests = 0;

    // initialize get if not there
    if (!$httpProvider.defaults.headers.get) {
        $httpProvider.defaults.headers.get = {};
    }
    // disable IE ajax request caching
    $httpProvider.defaults.headers.get['Cache-Control'] = 'no-cache';
    $httpProvider.defaults.headers.get['Pragma'] = 'no-cache';

    $httpProvider.interceptors.push(function($q, $rootScope, usSpinnerService) {
        return {
            'request' : function(request) {
                activeRequests++;
                usSpinnerService.spin("spinner");

                return request;
            },
            'response' : function(response) {
                activeRequests--;

                if (activeRequests <= 0) {
                    usSpinnerService.stop("spinner");
                }

                $rootScope.actionErrors = null;

                if (response.data && response.data.actionErrors && response.data.actionErrors.length > 0) {
                    $rootScope.actionErrors = response.data.actionErrors;

                    return $q.reject(response.data.actionErrors);
                }

                return response;
            },
            'responseError' : function(responseError) {
                activeRequests--;

                if (activeRequests <= 0) {
                    usSpinnerService.stop("spinner");
                }

                return responseError;
            }
        };
    });
} ])

.run([ '$location', '$rootScope', function($location, $rootScope) {
    $rootScope.default_language = "es";
    $rootScope.available_languages = [ "es", "ca", "en" ];
} ]);
