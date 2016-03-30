(function() {
    'use strict';

    angular.module(
            "config",
            [ "ngRoute", "mgcrea.ngStrap", "mgcrea.ngStrap.aside", "ui.bootstrap.tpls", "ui.bootstrap.tabs",
                    "ui.bootstrap.pagination", "ui.bootstrap.dropdown", "ui.bootstrap.typeahead",
                    "pascalprecht.translate", "angularSpinner", "uiGmapgoogle-maps", "ngFileUpload",
                    "LocalStorageModule", "i18n", "administracion_controller", "metamodelo_controller",
                    "facturacion_controller", "item_controller", "maestro_controller", "servicio_controller",
                    "estadistica_controller", "proceso_controller", "seguridad_controller" ])

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

    .factory('pageTitleService', pageTitleService)

    .factory('credentialService', credentialService)

    .controller("MainController", MainController)

    .controller("HomeController", HomeController)

    ;

    routeProvider_config.$inject = [ '$routeProvider' ];

    function routeProvider_config($routeProvider) {
        $routeProvider

        .when("/", {
            templateUrl : "modules/home.html",
            controller : "HomeController as vm",
            reloadOnSearch : false
        })

        ;
    }

    uiGmapGoogleMapApiProvider_config.$inject = [ 'uiGmapGoogleMapApiProvider' ];

    function uiGmapGoogleMapApiProvider_config(uiGmapGoogleMapApiProvider) {
        uiGmapGoogleMapApiProvider.configure({
            key : 'AIzaSyBkTsBBx0pgO-i66oeAKasc9fswUDfFH-M',
            v : '3.20',
        // libraries : 'weather,geometry,visualization'
        });
    }

    datepickerProvider_config.$inject = [ '$datepickerProvider' ];

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

    timepickerProvider_config.$inject = [ '$timepickerProvider' ];

    function timepickerProvider_config($timepickerProvider) {
        angular.extend($timepickerProvider.defaults, {
            timeFormat : 'HH:mm',
            length : 1,
            minuteStep : 1,
            timezone : 'UTC'
        });
    }

    tooltipProvider_config.$inject = [ '$tooltipProvider' ];

    function tooltipProvider_config($tooltipProvider) {
        angular.extend($tooltipProvider.defaults, {
            container : 'body'
        });
    }

    modalProvider_config.$inject = [ '$modalProvider' ];

    function modalProvider_config($modalProvider) {
        angular.extend($modalProvider.defaults, {
            html : true
        });
    }

    tabProvider_config.$inject = [ '$tabProvider' ];

    function tabProvider_config($tabProvider) {
        angular.extend($tabProvider.defaults, {
            animation : 'am-flip-x',
            navClass : 'nav-pills'
        });
    }

    translateProvider_config.$inject = [ '$translateProvider' ];

    function translateProvider_config($translateProvider) {
        $translateProvider.useSanitizeValueStrategy('escape');
    }

    localStorageServiceProvider_config.$inject = [ 'localStorageServiceProvider' ];

    function localStorageServiceProvider_config(localStorageServiceProvider) {
        localStorageServiceProvider.setPrefix('argo');
    }

    httpProvider_config.$inject = [ '$httpProvider' ];

    function httpProvider_config($httpProvider) {
        var activeRequests = 0;
        var startTimeMs;

        // initialize get if not there
        if (!$httpProvider.defaults.headers.get) {
            $httpProvider.defaults.headers.get = {};
        }
        // disable IE ajax request caching
        $httpProvider.defaults.headers.get['Cache-Control'] = 'no-cache';
        $httpProvider.defaults.headers.get['Pragma'] = 'no-cache';

        $httpProvider.interceptors.push(function($q, $rootScope, $injector, $location, usSpinnerService) {
            return {
                'request' : function(request) {
                    if (activeRequests == 0) {
                        startTimeMs = (new Date()).getMilliseconds();
                    }

                    activeRequests++;
                    usSpinnerService.spin("spinner");

                    return request;
                },
                'response' : function(response) {
                    activeRequests--;

                    if (activeRequests <= 0) {
                        usSpinnerService.stop("spinner");

                        activeRequests = 0;

                        $rootScope.requestTimeMs = (new Date()).getMilliseconds() - startTimeMs;
                    }

                    $rootScope.actionErrors = null;

                    if (response.data) {
                        if (response.data.responseCode) {
                            switch (response.data.responseCode) {
                            case "login":
                                $location.path("/seguridad/usuario/acceso");

                                return $q.reject(response);

                                break;
                            default:
                                break;
                            }
                        }

                        if (response.data.accionesUsuario) {
                            $rootScope.accionesUsuario = response.data.accionesUsuario;
                        }

                        if (response.data.actionErrors && response.data.actionErrors.length > 0) {
                            $rootScope.actionErrors = response.data.actionErrors;

                            return $q.reject(response.data.actionErrors);
                        }
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
    }

    run.$inject = [ '$rootScope' ];

    function run($rootScope) {
        $rootScope.default_language = "es";
        $rootScope.available_languages = [ "es", "ca", "en" ];
        $rootScope.dateFormat = "dd/MM/yyyy";
        $rootScope.datetimeFormat = "dd/MM/yyyy HH:mm";
    }

    MainController.$inject = [ 'credentialService' ];

    function MainController(credentialService) {
        // console.log("MainController");
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

    HomeController.$inject = [ '$http', 'pageTitleService' ];

    function HomeController($http, pageTitleService) {
        $http.post("index.action").success(function(data) {
        });

        pageTitleService.setTitle("page_home", "page_home");
    }

    pageTitleService.$inject = [ 'localStorageService' ];

    function credentialService(localStorageService) {
        return {
            hasAccnPath : hasAccnPath,
            hasAcenPath : hasAcenPath
        };

        function hasAccnPath(path) {
            var value = localStorageService.get("accnPaths")
                    && localStorageService.get("accnPaths").indexOf(path) >= 0;

            return value;
        }

        function hasAcenPath(entiId, path) {
            var value = localStorageService.get("acenPaths") && localStorageService.get("acenPaths")[entiId]
                    && localStorageService.get("acenPaths")[entiId].indexOf(path) >= 0;

            return value;
        }
    }

    pageTitleService.$inject = [ '$rootScope', '$translate' ];

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