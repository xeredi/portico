angular.module("maestro", [])

.config(config)

.factory('sprmService', sprmService)

// ----------------- MENU PRINCIPAL --------------------------
.controller("MaestroController", MaestroController)

// ----------- PARAMETROS ------------------
.controller("PrmtGridController", PrmtGridController)

.controller("PrmtDetailController", PrmtDetailController)

.controller("PrmtCreateController", PrmtCreateController)

.controller("PrmtEditController", PrmtEditController)

.controller("PrmtDuplicateController", PrmtDuplicateController)

.controller('PrmtsLupaController', PrmtsLupaController)

// ----------- SUBPARAMETROS ------------------
.controller("SprmDetailController", SprmDetailController)

.controller("SprmCreateController", SprmCreateController)

.controller("SprmEditController", SprmEditController)

.controller("SprmDuplicateController", SprmDuplicateController);

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

	.when("/maestro/prmt/create/:entiId", {
		templateUrl : "modules/entidad/maestro/prmt-edit.html",
		controller : "PrmtCreateController",
		controllerAs : 'vm'
	})

	.when("/maestro/prmt/detail/:entiId/:itemId/:fechaVigencia?", {
		templateUrl : "modules/entidad/maestro/prmt-detail.html",
		controller : "PrmtDetailController",
		controllerAs : 'vm',
		reloadOnSearch : false
	})

	.when("/maestro/prmt/edit/:entiId/:itemId/:fechaVigencia?", {
		templateUrl : "modules/entidad/maestro/prmt-edit.html",
		controller : "PrmtEditController",
		controllerAs : 'vm'
	})

	.when("/maestro/prmt/duplicate/:entiId/:itemId/:fechaVigencia?", {
		templateUrl : "modules/entidad/maestro/prmt-edit.html",
		controller : "PrmtDuplicateController",
		controllerAs : 'vm',
		reloadOnSearch : false
	})

	.when("/maestro/sprm/detail/:entiId/:itemId/:fechaVigencia?", {
		templateUrl : "modules/entidad/maestro/sprm-detail.html",
		controller : "SprmDetailController",
		controllerAs : 'vm'
	})

	.when("/maestro/sprm/create/:entiId/:prmtId/:fechaVigencia?", {
		templateUrl : "modules/entidad/maestro/sprm-edit.html",
		controller : "SprmCreateController",
		controllerAs : 'vm'
	})

	.when("/maestro/sprm/edit/:entiId/:itemId/:fechaVigencia?", {
		templateUrl : "modules/entidad/maestro/sprm-edit.html",
		controller : "SprmEditController",
		controllerAs : 'vm'
	})

	.when("/maestro/sprm/duplicate/:entiId/:itemId/:fechaVigencia?", {
		templateUrl : "modules/entidad/maestro/sprm-edit.html",
		controller : "SprmDuplicateController",
		controllerAs : 'vm'
	})

	;
}

function sprmService($http) {
	return {
		search : search
	};

	function search(subentiId, prmtId, page, fechaVigencia) {
		return $http.post("maestro/sprm-list.action", {
			page : page,
			itemCriterio : {
				prmt : {
					id : prmtId
				},
				entiId : subentiId,
				fechaVigencia : fechaVigencia
			}
		}).then(searchComplete);

		function searchComplete(response) {
			return response.data;
		}
	}
}

function MaestroController($http, $translate, pageTitleService) {
	var vm = this;

	$http.post('maestro/tppr-list.action').success(function(data) {
		vm.tpprList = data.tpprList.map(function(tppr) {
			$translate('enti_' + tppr.value).then(function(translation) {
				tppr.label = translation.toUpperCase();
			});

			return tppr;
		});
	});

	pageTitleService.setTitle("prmtList", "page_home");
}

function PrmtGridController($location, $routeParams, $http, $modal,
		pageTitleService) {
	var vm = this;

	vm.search = search;
	vm.pageChanged = pageChanged;
	vm.filter = filter;
	vm.xlsExport = xlsExport;
	vm.prmtAction = prmtAction;

	vm.itemCriterio = $routeParams.itemCriterio ? angular
			.fromJson($routeParams.itemCriterio) : {};
	vm.itemCriterio.entiId = $routeParams.entiId;

	function search(page) {
		$http.post("maestro/prmt-list.action", {
			itemCriterio : vm.itemCriterio,
			page : page,
			limit : vm.itemCriterio.limit
		}).success(function(data) {
			vm.enti = data.enti;
			vm.page = data.itemList.page;
			vm.itemList = data.itemList;
			vm.itemCriterio = data.itemCriterio;

			$location.search({
				page : vm.page,
				itemCriterio : JSON.stringify(vm.itemCriterio)
			}).replace();
		});
	}

	function pageChanged() {
		search(vm.page);
	}

	function xlsExport() {
		$http.post('maestro/prmt-xls-export.action', {
			itemCriterio : vm.itemCriterio
		}, {
			responseType : 'arraybuffer'
		}).success(function(data) {
			var file = new Blob([ data ], {
				type : 'application/xls'
			});

			setTimeout(function() {
				saveAs(file, vm.enti.id + '.xls');
			}, 0);
		});
	}

	function filter(size) {
		$http.post("maestro/prmt-filter.action", {
			itemCriterio : vm.itemCriterio
		}).success(function(data) {
			vm.labelValuesMap = data.labelValuesMap;
			vm.limits = data.limits;
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

	search($routeParams.page ? $routeParams.page : 1);
	pageTitleService.setTitleEnti($routeParams.entiId, "page_grid");
}

function PrmtDetailController($http, $location, $routeParams, sprmService,
		pageTitleService) {
	var vm = this;

	vm.pageChanged = pageChanged;
	vm.tabSelected = tabSelected;
	vm.remove = remove;
	vm.print = print;

	function pageChanged(subentiId) {
	}

	function tabSelected(tabNo) {
		if (vm.path == $location.path()) {
			$location.search("tab", tabNo).replace();
		}
	}

	function remove() {
		if (confirm("Are you sure?")) {
			$http.post("maestro/prmt-remove.action", {
				item : {
					prvr : {
						id : vm.item.prvr.id
					},
					entiId : $routeParams.entiId
				}
			}).success(function(data) {
				window.history.back();
			});
		}
	}

	function print() {
		$http.post('maestro/prmt-print.action', {
			item : vm.item
		}, {
			responseType : 'arraybuffer'
		}).success(function(data) {
			var file = new Blob([ data ], {
				type : 'application/pdf'
			});

			setTimeout(function() {
				saveAs(file, vm.enti.id + '.pdf');
			}, 0);
		});
	}

	vm.path = $location.path();
	vm.pageMap = {};

	vm.tabActive = {};

	if ($routeParams.tab) {
		vm.tabActive[$routeParams.tab] = true;
	}

	$http
			.post("maestro/prmt-detail.action", {
				item : {
					id : $routeParams.itemId,
					entiId : $routeParams.entiId
				},
				fechaVigencia : $routeParams.fechaVigencia
			})
			.success(
					function(data) {
						if (data.enti) {
							vm.enti = data.enti;
							vm.fechaVigencia = data.fechaVigencia;
							vm.item = data.item;
							vm.i18nMap = data.i18nMap;
							vm.itemHijosMap = {};
							vm.entiHijasMap = {};

							if (vm.enti.entiHijasList) {
								for (i = 0; i < vm.enti.entiHijasList.length; i++) {
									sprmService
											.search(vm.enti.entiHijasList[i],
													vm.item.id, 1,
													$routeParams.fechaVigencia)
											.then(
													function(data) {
														vm.entiHijasMap[data.enti.id] = data.enti;
														vm.itemHijosMap[data.enti.id] = data.itemList;
													});
								}
							}
						}
					});

	pageTitleService.setTitleEnti($routeParams.entiId, "page_detail");
}

function PrmtCreateController($http, $location, $routeParams, pageTitleService) {
	var vm = this;

	vm.save = save;
	vm.cancel = cancel;

	function save() {
		$http.post("maestro/prmt-save.action", {
			item : vm.item,
			i18nMap : vm.i18nMap,
			accion : vm.accion
		}).success(
				function(data) {
					$location.path(
							"/maestro/prmt/detail/" + data.item.entiId + "/"
									+ data.item.id + "/" + data.item.prvr.fini)
							.replace();
				});
	}

	function cancel() {
		window.history.back();
	}

	$http.post("maestro/prmt-create.action", {
		item : {
			entiId : $routeParams.entiId
		}
	}).success(function(data) {
		vm.enti = data.enti;
		vm.fechaVigencia = data.fechaVigencia;
		vm.item = data.item;
		vm.i18nMap = data.i18nMap;
		vm.labelValuesMap = data.labelValuesMap;
		vm.accion = data.accion;
	});

	pageTitleService.setTitleEnti($routeParams.entiId, "page_create");
}

function PrmtEditController($http, $location, $routeParams, pageTitleService) {
	var vm = this;

	vm.save = save;
	vm.cancel = cancel;

	function save() {
		var url = "maestro/prmt-save.action";

		$http.post(url, {
			item : vm.item,
			i18nMap : vm.i18nMap,
			accion : vm.accion
		}).success(function(data) {
			setTimeout(function() {
				window.history.back();
			}, 0);
		});
	}

	function cancel() {
		window.history.back();
	}

	$http.post("maestro/prmt-edit.action", {
		item : {
			id : $routeParams.itemId,
			entiId : $routeParams.entiId
		},
		fechaVigencia : $routeParams.fechaVigencia
	}).success(function(data) {
		vm.enti = data.enti;
		vm.fechaVigencia = data.fechaVigencia;
		vm.item = data.item;
		vm.i18nMap = data.i18nMap;
		vm.labelValuesMap = data.labelValuesMap;
		vm.accion = data.accion;
	});

	pageTitleService.setTitleEnti($routeParams.entiId, "page_edit");
}

function PrmtDuplicateController($http, $location, $routeParams,
		pageTitleService) {
	var vm = this;

	vm.save = save;
	vm.cancel = cancel;

	function save() {
		$http.post("maestro/prmt-save.action", {
			item : vm.item,
			i18nMap : vm.i18nMap,
			accion : vm.accion
		}).success(
				function(data) {
					$location.path(
							"/maestro/prmt/detail/" + data.item.entiId + "/"
									+ data.item.id + "/" + data.item.prvr.fini)
							.replace();
				});
	}

	function cancel() {
		window.history.back();
	}

	$http.post("maestro/prmt-duplicate.action", {
		item : {
			id : $routeParams.itemId,
			entiId : $routeParams.entiId
		},
		fechaVigencia : $routeParams.fechaVigencia
	}).success(function(data) {
		vm.enti = data.enti;
		vm.fechaVigencia = data.fechaVigencia;
		vm.item = data.item;
		vm.i18nMap = data.i18nMap;
		vm.labelValuesMap = data.labelValuesMap;
		vm.accion = data.accion;
	});

	pageTitleService.setTitleEnti($routeParams.entiId, "page_duplicate");
}

function PrmtsLupaController($http, $scope) {
	$scope.getLabelValues = function(entiId, textoBusqueda, fechaVigencia) {
		if (textoBusqueda.length <= 0) {
			return null;
		}

		return $http.post("maestro/prmt-lupa.action", {
			itemLupaCriterio : {
				entiId : entiId,
				textoBusqueda : textoBusqueda,
				fechaVigencia : fechaVigencia
			}
		}).then(function(res) {
			return res.data.itemList;
		});
	};
}

function SprmDetailController($http, $routeParams, pageTitleService) {
	var vm = this;

	vm.remove = remove;

	function remove() {
		if (confirm("Are you sure?")) {
			$http.post("maestro/sprm-remove.action", {
				item : {
					spvr : {
						id : vm.item.spvr.id
					}
				}
			}).success(function(data) {
				window.history.back();
			});
		}
	}

	$http.post("maestro/sprm-detail.action", {
		item : {
			id : $routeParams.itemId
		},
		fechaVigencia : $routeParams.fechaVigencia
	}).success(function(data) {
		vm.enti = data.enti;
		vm.fechaVigencia = data.fechaVigencia;
		vm.item = data.item;
	});

	pageTitleService.setTitleEnti($routeParams.entiId, "page_detail");
}

function SprmCreateController($http, $location, $routeParams, pageTitleService) {
	var vm = this;

	vm.save = save;
	vm.cancel = cancel;

	function save() {
		var url = "maestro/sprm-save.action";

		$http.post(url, {
			item : vm.item,
			accion : vm.accion
		}).success(
				function(data) {
					$location.path(
							"/maestro/sprm/detail/" + data.item.entiId + "/"
									+ data.item.id + "/" + data.item.spvr.fini)
							.replace();
				});
	}

	function cancel() {
		window.history.back();
	}

	$http.post("maestro/sprm-create.action", {
		item : {
			entiId : $routeParams.entiId,
			prmtId : $routeParams.prmtId
		},
		fechaVigencia : $routeParams.fechaVigencia
	}).success(function(data) {
		vm.enti = data.enti;
		vm.fechaVigencia = data.fechaVigencia;
		vm.item = data.item;
		vm.labelValuesMap = data.labelValuesMap;
		vm.accion = data.accion;
	});

	pageTitleService.setTitleEnti($routeParams.entiId, "page_create");
}

function SprmEditController($http, $location, $routeParams, pageTitleService) {
	var vm = this;

	vm.save = save;
	vm.cancel = cancel;

	function save() {
		var url = "maestro/sprm-save.action";

		$http.post(url, {
			item : vm.item,
			accion : vm.accion
		}).success(function(data) {
			setTimeout(function() {
				window.history.back();
			}, 0);
		});
	}

	function cancel() {
		window.history.back();
	}

	$http.post("maestro/sprm-edit.action", {
		item : {
			id : $routeParams.itemId
		},
		fechaVigencia : $routeParams.fechaVigencia
	}).success(function(data) {
		vm.enti = data.enti;
		vm.fechaVigencia = data.fechaVigencia;
		vm.item = data.item;
		vm.labelValuesMap = data.labelValuesMap;
		vm.accion = data.accion;
	});

	pageTitleService.setTitleEnti($routeParams.entiId, "page_edit");
}

function SprmDuplicateController($http, $location, $routeParams,
		pageTitleService) {
	var vm = this;

	vm.save = save;
	vm.cancel = cancel;

	function save() {
		$http.post("maestro/sprm-save.action", {
			item : vm.item,
			accion : vm.accion
		}).success(
				function(data) {
					$location.path(
							"/maestro/sprm/detail/" + data.item.entiId + "/"
									+ data.item.id + "/" + data.item.spvr.fini)
							.replace();
				});
	}

	function cancel() {
		window.history.back();
	}

	$http.post("maestro/sprm-duplicate.action", {
		item : {
			id : $routeParams.itemId
		},
		fechaVigencia : $routeParams.fechaVigencia
	}).success(function(data) {
		vm.enti = data.enti;
		vm.fechaVigencia = data.fechaVigencia;
		vm.item = data.item;
		vm.labelValuesMap = data.labelValuesMap;
		vm.accion = data.accion;
	});

	pageTitleService.setTitleEnti($routeParams.entiId, "page_duplicate");
}
