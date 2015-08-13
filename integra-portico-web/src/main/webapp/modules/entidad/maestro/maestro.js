angular.module("maestro", [])

.config(config)

// ----------------- MENU PRINCIPAL --------------------------
.controller("MaestroController", MaestroController)

// ----------- PARAMETROS ------------------
.controller("PrmtGridController", PrmtGridController)

.controller("PrmtDetailController", PrmtDetailController)

.controller("PrmtEditController", PrmtEditController)

.controller('PrmtLupaController', PrmtLupaController)

.controller("PrmtGisController", PrmtGisController)

// ----------- SUBPARAMETROS ------------------
.controller("SprmDetailController", SprmDetailController)

.controller("SprmEditController", SprmEditController)

;

function config($routeProvider) {
	$routeProvider

			.when("/maestro", {
				templateUrl : "modules/entidad/maestro/maestro.html",
				controller : "MaestroController",
				controllerAs : 'vm'
			})

			.when("/maestro/prmt/grid/:entiId/:page?", {
				templateUrl : "modules/entidad/maestro/prmt-grid.html",
				controller : "PrmtGridController",
				controllerAs : 'vm',
				reloadOnSearch : false
			})

			.when("/maestro/prmt/detail/:entiId/:itemId/:fechaVigencia?", {
				templateUrl : "modules/entidad/maestro/prmt-detail.html",
				controller : "PrmtDetailController",
				controllerAs : 'vm',
				reloadOnSearch : false
			})

			.when(
					"/maestro/prmt/edit/:accion/:entiId/:fechaVigencia?/:itemId?",
					{
						templateUrl : "modules/entidad/maestro/prmt-edit.html",
						controller : "PrmtEditController",
						controllerAs : 'vm'
					})

			.when("/maestro/prmt/gis", {
				templateUrl : "modules/entidad/maestro/prmt-gis.html",
				controller : "PrmtGisController",
				controllerAs : 'vm'
			})

			.when("/maestro/sprm/detail/:entiId/:itemId/:fechaVigencia?", {
				templateUrl : "modules/entidad/maestro/sprm-detail.html",
				controller : "SprmDetailController",
				controllerAs : 'vm'
			})

			.when(
					"/maestro/sprm/edit/:accion/:entiId/:prmtId/:fechaVigencia?/:itemId?",
					{
						templateUrl : "modules/entidad/maestro/sprm-edit.html",
						controller : "SprmEditController",
						controllerAs : 'vm'
					})

	;
}

function MaestroController($http, $translate, pageTitleService) {
	var vm = this;

	initialize();

	function initialize() {
		$http.post('maestro/index.action').success(function(data) {
			vm.tpprList = data.resultList.map(function(tppr) {
				$translate('enti_' + tppr.value).then(function(translation) {
					tppr.label = translation.toUpperCase();
				});

				return tppr;
			});
		});

		pageTitleService.setTitle("prmtList", "page_home");
	}
}

function PrmtGridController($location, $routeParams, $http, $modal,
		pageTitleService) {
	var vm = this;

	vm.search = search;
	vm.pageChanged = pageChanged;
	vm.filter = filter;
	vm.xlsExport = xlsExport;
	vm.gis = gis;
	vm.prmtAction = prmtAction;

	initialize();

	function initialize() {
		vm.itemCriterio = $routeParams.itemCriterio ? angular
				.fromJson($routeParams.itemCriterio) : {};
		vm.itemCriterio.entiId = $routeParams.entiId;

		search($routeParams.page ? $routeParams.page : 1, true);
		pageTitleService.setTitleEnti($routeParams.entiId, "page_grid");
	}

	function search(page, firstLoad) {
		$http.post("maestro/parametro-list.action", {
			model : vm.itemCriterio,
			page : page,
			limit : vm.itemCriterio.limit
		}).success(function(data) {
			if (firstLoad) {
				vm.enti = data.enti;
				vm.itemCriterio = data.model;
			}

			vm.page = data.resultList.page;
			vm.itemList = data.resultList;

			$location.search({
				page : vm.page,
				itemCriterio : JSON.stringify(vm.itemCriterio)
			}).replace();
		});
	}

	function pageChanged() {
		search(vm.page, false);
	}

	function xlsExport() {
		$http.post('maestro/parametro-xls-export.action', {
			criterio : vm.itemCriterio
		}, {
			responseType : 'arraybuffer'
		}).success(function(data) {
			var file = new Blob([ data ], {
				type : 'application/xls'
			});

			setTimeout(function() {
				saveAs(file, 'prmt_' + vm.itemCriterio.entiId + '.xls');
			}, 0);
		});
	}

	function filter(size) {
		$http.post("maestro/parametro-filter.action", {
			model : vm.itemCriterio
		}).success(function(data) {
			vm.labelValuesMap = data.labelValuesMap;
			vm.limits = data.limits;
			vm.prtoList = data.prtoList;
		});
	}

	function gis() {
		$location.path("/maestro/prmt/gis").search({
			itemCriterio : JSON.stringify(vm.itemCriterio)
		});
	}

	function prmtAction(accName) {
		switch (accName) {
		// ----------- EMB. DEP. AUT. ------------------
		// ----------- EMB. DEP. AUT. ------------------
		// ----------- EMB. DEP. AUT. ------------------

		case "amad-recalc-estado":
			$http.post("maestro/embdeportivas/amad-recalc-estado.action")
					.success(function(data) {
						search($routeParams.page ? $routeParams.page : 1);
					});

			break;
		default:
			alert(accName);

			break;
		}
	}
}

function PrmtDetailController($http, $location, $routeParams, pageTitleService) {
	var vm = this;

	vm.gis = gis;
	vm.pageChanged = pageChanged;
	vm.tabSelected = tabSelected;
	vm.remove = remove;
	vm.print = print;

	initialize();

	function initialize() {
		vm.path = $location.path();
		vm.pageMap = {};

		vm.tabActive = {};

		if ($routeParams.tab) {
			vm.tabActive[$routeParams.tab] = true;
		}

		vm.fechaVigencia = $routeParams.fechaVigencia ? $routeParams.fechaVigencia
				: new Date();

		$http.post("maestro/parametro-detail.action", {
			model : {
				id : $routeParams.itemId,
				entiId : $routeParams.entiId
			},
			fechaVigencia : vm.fechaVigencia
		}).success(function(data) {
			vm.item = data.model;
			vm.enti = data.enti;
			vm.i18nMap = data.i18nMap;

			if (data.model.prto) {
				vm.prtoId = data.model.prto.id;
			}

			vm.itemHijosMap = {};
			vm.entiHijasMap = {};

			if (data.enti && vm.enti.entiHijasList) {
				for (i = 0; i < vm.enti.entiHijasList.length; i++) {
					$http.post("maestro/subparametro-list.action", {
						model : {
							prmt : {
								id : vm.item.id
							},
							entiId : vm.enti.entiHijasList[i],
							fechaVigencia : vm.fechaVigencia
						}
					}).success(function(data) {
						vm.entiHijasMap[data.enti.enti.id] = data.enti;
						vm.itemHijosMap[data.enti.enti.id] = data.resultList;
					});
				}
			}
		});

		pageTitleService.setTitleEnti($routeParams.entiId, "page_detail");
	}

	function gis() {
		$location.path("/maestro/prmt/gis").search({
			itemCriterio : {
				id : $routeParams.itemId,
				entiId : $routeParams.entiId,
				fechaVigencia : $routeParams.fechaVigencia
			}
		});
	}

	function pageChanged(subentiId) {
	}

	function tabSelected(tabNo) {
		if (vm.path == $location.path()) {
			$location.search("tab", tabNo).replace();
		}
	}

	function remove() {
		if (confirm("Are you sure?")) {
			$http.post("maestro/parametro-remove.action", {
				model : vm.item
			}).success(function(data) {
				window.history.back();
			});
		}
	}

	function print() {
		$http.post('maestro/parametro-pdf-export.action', {
			model : vm.item,
			fechaVigencia : vm.fechaVigencia
		}, {
			responseType : 'arraybuffer'
		}).success(
				function(data) {
					var file = new Blob([ data ], {
						type : 'application/pdf'
					});

					setTimeout(function() {
						saveAs(file, 'prmt_' + vm.item.entiId + '_'
								+ vm.item.id + '.pdf');
					}, 0);
				});
	}
}

function PrmtEditController($http, $location, $routeParams, pageTitleService) {
	var vm = this;

	vm.save = save;
	vm.cancel = cancel;

	initialize();

	function initialize() {
		vm.accion = $routeParams.accion;
		vm.fechaVigencia = $routeParams.fechaVigencia ? $routeParams.fechaVigencia
				: new Date();

		$http.post("maestro/parametro-edit.action", {
			model : {
				id : $routeParams.itemId,
				entiId : $routeParams.entiId
			},
			accion : vm.accion,
			fechaVigencia : vm.fechaVigencia
		}).success(function(data) {
			vm.item = data.model;
			vm.enti = data.enti;
			vm.i18nMap = data.i18nMap;
			vm.labelValuesMap = data.labelValuesMap;
			vm.prtoList = data.prtoList;

			if (data.model.prto) {
				vm.prtoId = data.model.prto.id;
			}
		});

		pageTitleService.setTitleEnti($routeParams.entiId, "page_" + vm.accion);
	}

	function save() {
		$http.post("maestro/parametro-save.action", {
			model : vm.item,
			i18nMap : vm.i18nMap,
			accion : vm.accion
		}).success(
				function(data) {
					vm.accion == 'edit' ? setTimeout(function() {
						window.history.back();
					}, 0) : $location.path(
							"/maestro/prmt/detail/" + data.model.entiId + "/"
									+ data.model.id + "/"
									+ data.model.version.fini).replace();
				});
	}

	function cancel() {
		window.history.back();
	}
}

function PrmtLupaController($http, $scope) {
	$scope.getLabelValues = function(entiId, textoBusqueda, prtoId,
			fechaVigencia) {
		if (textoBusqueda.length <= 0) {
			return null;
		}

		textoBusqueda += "%";

		return $http.post("maestro/parametro-typeahead.action", {
			model : {
				entiId : entiId,
				textoBusqueda : textoBusqueda,
				fechaVigencia : fechaVigencia,
				prto : {
					id : prtoId
				}
			}
		}).then(function(res) {
			return res.data.resultList;
		});
	};

	$scope.getLabelValuesSprm = function(entiId, textoBusqueda, fechaVigencia,
			prtoId) {
		if (textoBusqueda.length <= 0) {
			return null;
		}

		textoBusqueda += "%";

		return $http.post("maestro/parametro-typeahead-sprm.action", {
			model : {
				tpsp : {
					id : entiId
				},
				textoBusqueda : textoBusqueda,
				fechaVigencia : fechaVigencia,
				prtoId : prtoId
			}
		}).then(function(res) {
			return res.data.resultList;
		});
	};
}

function PrmtGisController($http, $location, $routeParams, pageTitleService,
		uiGmapGoogleMapApi) {
	var vm = this;

	vm.closeClick = closeClick;
	vm.onClick = onClick;

	initialize();

	function initialize() {
		vm.itemCriterio = $routeParams.itemCriterio ? angular
				.fromJson($routeParams.itemCriterio) : {};

		$http.post("maestro/parametro-gis.action", {
			criterio : vm.itemCriterio
		}).success(
				function(data) {
					vm.itemMap = data.itemMap;
					vm.entiMap = data.entiMap;
					vm.map = data.map;

					uiGmapGoogleMapApi.then(function(maps) {
					});

					$location.search("itemCriterio",
							JSON.stringify(vm.itemCriterio)).replace();
				});

		pageTitleService.setTitleEnti($routeParams.entiId, "page_gis");
	}

	function onClick(marker) {
		vm.map.markerList
				.map(function(marker) {
					marker.windowOptions.visible = false;
					marker.options.icon = "http://maps.google.com/mapfiles/ms/icons/red-dot.png";
				});

		marker.windowOptions.visible = true;
		marker.options.icon = "http://maps.google.com/mapfiles/ms/icons/green-dot.png";
	}

	function closeClick(marker) {
		marker.windowOptions.visible = false;
		marker.options.icon = "http://maps.google.com/mapfiles/ms/icons/red-dot.png";
	}
}

function SprmDetailController($http, $routeParams, pageTitleService) {
	var vm = this;

	vm.remove = remove;

	initialize();

	function initialize() {
		$http.post("maestro/subparametro-detail.action", {
			model : {
				id : $routeParams.itemId,
				entiId : $routeParams.entiId
			},
			fechaVigencia : $routeParams.fechaVigencia
		}).success(function(data) {
			vm.enti = data.enti;
			vm.fechaVigencia = data.fechaVigencia;
			vm.prtoId = data.prtoId;
			vm.item = data.model;
		});

		pageTitleService.setTitleEnti($routeParams.entiId, "page_detail");
	}

	function remove() {
		if (confirm("Are you sure?")) {
			$http.post("maestro/subparametro-remove.action", {
				model : vm.item
			}).success(function(data) {
				window.history.back();
			});
		}
	}
}

function SprmEditController($http, $location, $routeParams, pageTitleService) {
	var vm = this;

	vm.save = save;
	vm.cancel = cancel;

	initialize();

	function initialize() {
		vm.accion = $routeParams.accion;

		$http.post("maestro/subparametro-edit.action", {
			model : {
				entiId : $routeParams.entiId,
				prmtId : $routeParams.prmtId,
				id : $routeParams.itemId
			},
			accion : vm.accion,
			fechaVigencia : $routeParams.fechaVigencia
		}).success(function(data) {
			vm.enti = data.enti;
			vm.fechaVigencia = data.fechaVigencia;
			vm.prtoId = data.model.prtoId;
			vm.item = data.model;
			vm.labelValuesMap = data.labelValuesMap;
			vm.prtoList = data.prtoList;
		});

		pageTitleService.setTitleEnti($routeParams.entiId, "page_" + vm.accion);
	}

	function save() {
		$http.post("maestro/subparametro-save.action", {
			model : vm.item,
			accion : vm.accion
		}).success(
				function(data) {
					vm.accion == 'edit' ? setTimeout(function() {
						window.history.back();
					}, 0) : $location.path(
							"/maestro/sprm/detail/" + data.model.entiId + "/"
									+ data.model.id + "/"
									+ data.model.version.fini).replace();
				});
	}

	function cancel() {
		window.history.back();
	}
}
