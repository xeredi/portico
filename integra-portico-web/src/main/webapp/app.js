angular
		.module(
				"integraApp",
				[ "ngRoute", "mgcrea.ngStrap", "mgcrea.ngStrap.aside",
						"ui.bootstrap.tpls", "ui.bootstrap.tabs",
						"ui.bootstrap.pagination", "ui.bootstrap.dropdown",
						"ui.bootstrap.typeahead", "pascalprecht.translate",
						"angularSpinner", "uiGmapgoogle-maps",
						"i18n", "administracion",
						"metamodelo", "facturacion", "maestro", "servicio",
						"estadistica", "proceso", "seguridad" ])

		.config([ "$routeProvider", function($routeProvider) {
			$routeProvider

			.when("/", {
				templateUrl : "modules/home.html",
				controller : "HomeController",
				controllerAs : "vm"
			});
		} ])

		.config(function(uiGmapGoogleMapApiProvider) {
			uiGmapGoogleMapApiProvider.configure({
				key : 'AIzaSyBkTsBBx0pgO-i66oeAKasc9fswUDfFH-M',
				v : '3.17',
			// libraries : 'weather,geometry,visualization'
			});
		})

		.config(function($datepickerProvider) {
			angular.extend($datepickerProvider.defaults, {
				dateFormat : 'dd/MM/yyyy',
				/*
				 * modelDateFormat : "yyyy-MM-ddTHH:mm:ss", dateType : "date",
				 */
				startWeek : 1,
				placement : 'bottom-left',
				container : 'body',
				autoclose : true
			});
		})

		.config(function($timepickerProvider) {
			angular.extend($timepickerProvider.defaults, {
				timeFormat : 'HH:mm',
				timeType : "date",
				length : 1,
				minuteStep : 1
			});
		})

		.config(function($tooltipProvider) {
			angular.extend($tooltipProvider.defaults, {
				container : 'body'
			});
		})
		/*
		 * .config(function($typeaheadProvider) {
		 * angular.extend($typeaheadProvider.defaults, { trigger : 'focus',
		 * minLength : 1, limit : 5, delay : { show : 250, hide : 100 } }); })
		 * .config(function($tabProvider) {
		 * angular.extend($tabProvider.defaults, { navClass : 'nav-pills' }); })
		 */

		.config(function($modalProvider) {
			angular.extend($modalProvider.defaults, {
				html : true
			});
		})

		.config(function($tabProvider) {
			angular.extend($tabProvider.defaults, {
				animation : 'am-flip-x',
				navClass : 'nav-pills'
			});
		})

		.config(
				[
						'$httpProvider',
						function($httpProvider) {
							var activeRequests = 0;

							// initialize get if not there
							if (!$httpProvider.defaults.headers.get) {
								$httpProvider.defaults.headers.get = {};
							}
							// disable IE ajax request caching
							$httpProvider.defaults.headers.get['Cache-Control'] = 'no-cache';
							$httpProvider.defaults.headers.get['Pragma'] = 'no-cache';

							$httpProvider.interceptors
									.push(function($q, $rootScope, $location,
											usSpinnerService) {
										return {
											'request' : function(request) {
												activeRequests++;
												usSpinnerService
														.spin("spinner");

												return request;
											},
											'response' : function(response) {
												activeRequests--;

												if (activeRequests <= 0) {
													usSpinnerService
															.stop("spinner");
												}

												$rootScope.actionErrors = null;

												if (response.data) {
													if (response.data.responseCode) {
														switch (response.data.responseCode) {
														case "login":
															$location
																	.path("/seguridad/usro/acceso");
															return $q
																	.reject(response);

															break;
														default:
															break;
														}
													}

													if (response.data.actionErrors
															&& response.data.actionErrors.length > 0) {
														$rootScope.actionErrors = response.data.actionErrors;

														return $q
																.reject(response.data.actionErrors);
													}
												}

												return response;
											},
											'responseError' : function(
													responseError) {
												activeRequests--;

												if (activeRequests <= 0) {
													usSpinnerService
															.stop("spinner");
												}

												return responseError;
											}
										};
									});
						} ])

		.run([ '$location', '$rootScope', function($location, $rootScope) {
			$rootScope.default_language = "es";
			$rootScope.available_languages = [ "es", "ca", "en" ];
		} ])

		.factory('pageTitleService', pageTitleService)

		.controller("HomeController", HomeController)

;

function HomeController($http, pageTitleService) {
	$http.post("index.action").success(function(data) {
	});

	pageTitleService.setTitle("page_home", "page_home");
}

function pageTitleService($rootScope, $translate) {
	return {
		setTitleEnti : setTitleEnti,
		setTitle : setTitle
	};

	function setTitle(prefix, title) {
		$translate([ prefix, title ]).then(
				function(translations) {
					$rootScope.title = translations[prefix] + ": "
							+ translations[title];
				});
	}

	function setTitleEnti(entiId, title) {
		$translate([ 'enti_' + entiId, title ]).then(
				function(translations) {
					$rootScope.title = translations['enti_' + entiId] + ": "
							+ translations[title];
				});
	}
}
