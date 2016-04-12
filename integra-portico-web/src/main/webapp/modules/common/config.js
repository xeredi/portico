(function() {
    'use strict';

    angular.module(
            "config",
            [ "ngRoute", "pasvaz.bindonce", "mgcrea.ngStrap", "mgcrea.ngStrap.aside", "ui.bootstrap.tpls",
                    "ui.bootstrap.tabs", "ui.bootstrap.pagination", "ui.bootstrap.dropdown",
                    "ui.bootstrap.typeahead", "pascalprecht.translate", "angularSpinner",
                    "uiGmapgoogle-maps", "ngFileUpload", "LocalStorageModule", "i18n",
                    "administracion_controller", "metamodelo_controller", "facturacion_controller",
                    "item_controller", "maestro_controller", "servicio_controller", "estadistica_controller",
                    "proceso_controller", "seguridad_controller" ])

    .config(routeProvider_config)

    .config(uiGmapGoogleMapApiProvider_config)

    .config(datepickerProvider_config)

    .config(timepickerProvider_config)

    .config(tooltipProvider_config)

    .config(modalProvider_config)

    .config(tabProvider_config)

    .config(translateProvider_config)

    .config(localStorageServiceProvider_config)

    .config(httpProvider_config)

    .run(run)

    .factory('httpInterceptor', httpInterceptor)

    .factory('pageTitleService', pageTitleService)

    .factory('credentialService', credentialService)

    .controller("MainController", MainController)

    .controller("HomeController", HomeController)

    ;

    /* @ngInject */
    function routeProvider_config($routeProvider) {
        $routeProvider

        .when("/", {
            templateUrl : "modules/home.html",
            controller : "HomeController as vm",
            reloadOnSearch : false
        })

        ;
    }

    /* @ngInject */
    function uiGmapGoogleMapApiProvider_config(uiGmapGoogleMapApiProvider) {
        uiGmapGoogleMapApiProvider.configure({
            key : 'AIzaSyBkTsBBx0pgO-i66oeAKasc9fswUDfFH-M',
            v : '3.20',
        // libraries : 'weather,geometry,visualization'
        });
    }

    /* @ngInject */
    function datepickerProvider_config($datepickerProvider) {
        angular.extend($datepickerProvider.defaults, {
            dateFormat : 'dd/MM/yyyy',
            startWeek : 1,
            placement : 'bottom-left',
            container : 'body',
            autoclose : true,
            timezone : 'UTC'
        });
    }

    /* @ngInject */
    function timepickerProvider_config($timepickerProvider) {
        angular.extend($timepickerProvider.defaults, {
            timeFormat : 'HH:mm',
            length : 1,
            minuteStep : 1,
            timezone : 'UTC'
        });
    }

    /* @ngInject */
    function tooltipProvider_config($tooltipProvider) {
        angular.extend($tooltipProvider.defaults, {
            container : 'body'
        });
    }

    /* @ngInject */
    function modalProvider_config($modalProvider) {
        angular.extend($modalProvider.defaults, {
            html : true
        });
    }

    /* @ngInject */
    function tabProvider_config($tabProvider) {
        angular.extend($tabProvider.defaults, {
            animation : 'am-flip-x',
            navClass : 'nav-pills'
        });
    }

    /* @ngInject */
    function translateProvider_config($translateProvider) {
        $translateProvider.useSanitizeValueStrategy('escape');
    }

    /* @ngInject */
    function localStorageServiceProvider_config(localStorageServiceProvider) {
        localStorageServiceProvider.setPrefix('argo');
    }

    /* @ngInject */
    function httpProvider_config($httpProvider) {
        // initialize get if not there
        if (!$httpProvider.defaults.headers.get) {
            $httpProvider.defaults.headers.get = {};
        }
        // disable IE ajax request caching
        $httpProvider.defaults.headers.get['Cache-Control'] = 'no-cache';
        $httpProvider.defaults.headers.get['Pragma'] = 'no-cache';

        $httpProvider.interceptors.push('httpInterceptor');
    }

    /* @ngInject */
    function run($rootScope) {
        $rootScope.default_language = "es";
        $rootScope.available_languages = [ "es", "ca", "en" ];
        $rootScope.dateFormat = "dd/MM/yyyy";
        $rootScope.datetimeFormat = "dd/MM/yyyy HH:mm";
    }

    /* @ngInject */
    function MainController(credentialService) {
        var vm = this;

        vm.hasAccnPath = hasAccnPath;
        vm.hasAcenPath = hasAcenPath;

        function hasAccnPath(path) {
            return credentialService.hasAccnPath(path);
        }

        function hasAcenPath(entiId, path) {
            return credentialService.hasAcenPath(entiId, path);
        }
    }

    /* @ngInject */
    function HomeController($http, pageTitleService) {
        $http.post("index.action").success(function(data) {
        });

        pageTitleService.setTitle("page_home", "page_home");
    }

    /* @ngInject */
    function httpInterceptor($q, $rootScope, $injector, $location, usSpinnerService) {
        var activeRequests = 0;
        var startTimeMs;

        return {
            request : request,
            response : response,
            responseError : responseError
        };

        function request(req) {
            if (activeRequests == 0) {
                startTimeMs = (new Date()).getMilliseconds();
            }

            activeRequests++;
            usSpinnerService.spin("spinner");

            return req;
        }

        function response(res) {
            activeRequests--;

            if (activeRequests <= 0) {
                usSpinnerService.stop("spinner");

                activeRequests = 0;

                $rootScope.requestTimeMs = (new Date()).getMilliseconds() - startTimeMs;
            }

            $rootScope.actionErrors = null;

            if (res.data) {
                if (res.data.responseCode) {
                    switch (res.data.responseCode) {
                    case "login":
                        $location.path("/seguridad/usuario/acceso");

                        return $q.reject(res);

                        break;
                    default:
                        break;
                    }
                }

                if (res.data.accionesUsuario) {
                    $rootScope.accionesUsuario = res.data.accionesUsuario;
                }

                if (res.data.actionErrors && res.data.actionErrors.length > 0) {
                    $rootScope.actionErrors = res.data.actionErrors;

                    return $q.reject(res.data.actionErrors);
                }
            }

            return res;
        }

        function responseError(res) {
            activeRequests--;

            if (activeRequests <= 0) {
                usSpinnerService.stop("spinner");
            }

            return res;
        }
    }

    /* @ngInject */
    function credentialService(localStorageService) {
        return {
            hasAccnPath : hasAccnPath,
            hasAcenPath : hasAcenPath
        };

        function hasAccnPath(path) {
            var accnPaths = localStorageService.get("accnPaths");

            if (accnPaths) {
                return accnPaths.indexOf(path) >= 0;
            }

            return false;
        }

        function hasAcenPath(entiId, path) {
            var acenPaths = localStorageService.get("acenPaths");

            if (acenPaths) {
                var acenPathsEnti = acenPaths[entiId];

                if (acenPathsEnti) {
                    return acenPathsEnti.indexOf(path) >= 0;
                }
            }

            return false;
        }
    }

    /* @ngInject */
    function pageTitleService($rootScope, $translate) {
        return {
            setTitleEnti : setTitleEnti,
            setTitle : setTitle
        };

        function setTitle(prefix, title) {
            $translate([ prefix, title ]).then(function(translations) {
                $rootScope.title = translations[prefix] + ": " + translations[title];
            });
        }

        function setTitleEnti(entiId, title) {
            $translate([ 'enti_' + entiId, title ]).then(function(translations) {
                $rootScope.title = translations['enti_' + entiId] + ": " + translations[title];
            });
        }
    }
})();