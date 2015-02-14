angular.module(
        "integraApp",
        [ "ngRoute", "ui.bootstrap.tpls", "ui.bootstrap.tabs", "ui.bootstrap.pagination", "ui.bootstrap.dropdown",
                "mgcrea.ngStrap", "pascalprecht.translate", "angularSpinner", "util", "i18n", "administracion",
                "metamodelo", "facturacion", "maestro", "servicio", "estadistica", "proceso" ])

.config([ "$routeProvider", function($routeProvider) {
    $routeProvider

    .when("/", {
        title : 'home',
        templateUrl : "modules/home.html"
    });
} ])

.config(function($datepickerProvider) {
    angular.extend($datepickerProvider.defaults, {
        dateFormat : 'dd/MM/yyyy',
        modelDateFormat : "yyyy-MM-ddTHH:mm:ss",
        dateType : "string",
        startWeek : 1,
        container : 'body',
        autoclose : true
    });
})

.config(function($timepickerProvider) {
    angular.extend($timepickerProvider.defaults, {
        timeFormat : 'HH:mm',
        length : 1,
        minuteStep : 1
    });
})

.config(function($tooltipProvider) {
    angular.extend($tooltipProvider.defaults, {
        container : 'body'
    });
})

.config(function($typeaheadProvider) {
    angular.extend($typeaheadProvider.defaults, {
        trigger : 'focus',
        minLength : 1,
        limit : 5,
        delay : {
            show : 250,
            hide : 100
        }
    });
})

.config(function($tabProvider) {
    angular.extend($tabProvider.defaults, {
        navClass : 'nav-pills'
    });
})

.config(function($modalProvider) {
    angular.extend($modalProvider.defaults, {
        html : true
    });
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
