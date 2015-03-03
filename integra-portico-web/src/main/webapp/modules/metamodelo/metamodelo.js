angular.module("metamodelo", [])

.config(config)

// -------------------- TIPO DE DATO ------------------
.controller("TpdtGridController", TpdtGridController)

.controller("TpdtCreateController", TpdtCreateController)

.controller("TpdtDetailController", TpdtDetailController)

.controller("TpdtEditController", TpdtEditController)

.controller("CdrfCreateController", CdrfCreateController)

.controller("CdrfDetailController", CdrfDetailController)

.controller("CdrfEditController", CdrfEditController)

// -------------------- MAESTRO ------------------
.controller("TpprGridController", TpprGridController)

.controller("TpprDetailController", TpprDetailController)

.controller("TpprEditController", TpprEditController)

.controller("TpprCreateController", TpprCreateController)

.controller("TpspDetailController", TpspDetailController)

.controller("TpspEditController", TpspEditController)

.controller("TpspCreateController", TpspCreateController)

// -------------------- TIPO DE SERVICIO ------------------
.controller("TpsrGridController", TpsrGridController)

.controller("TpsrDetailController", TpsrDetailController)

.controller("TpsrEditController", TpsrEditController)

.controller("TpsrCreateController", TpsrCreateController)

.controller("TpssDetailController", TpssDetailController)

.controller("TpssEditController", TpssEditController)

.controller("TpssCreateController", TpssCreateController)

// -------------------- ESTADISTICA ------------------
.controller("TpesGridController", TpesGridController)

.controller("TpesDetailController", TpesDetailController)

.controller("TpesEditController", TpesEditController)

.controller("TpesCreateController", TpesCreateController)

.controller("CmagCreateController", CmagCreateController)

.controller("CmagDetailController", CmagDetailController)

.controller("CmagEditController", CmagEditController)

// ------------------- GRUPO DE DATO DE ENTIDAD --------------------
.controller("EngdDetailController", EngdDetailController)

.controller("EngdEditController", EngdEditController)

.controller("EngdCreateController", EngdCreateController)

// ------------------- DATO DE ENTIDAD --------------------
.controller("EntdEditController", EntdEditController)

.controller("EntdEditController", EntdEditController)

.controller("EntdCreateController", EntdCreateController)

// ------------------- ACCION DE ENTIDAD --------------------
.controller("EnacDetailController", EnacDetailController)

.controller("EnacEditController", EnacEditController)

.controller("EnacCreateController", EnacCreateController)

// ------------------- ACCION DE GRID DE ENTIDAD --------------------
.controller("EnagDetailController", EnagDetailController)

.controller("EnagEditController", EnagEditController)

.controller("EnagCreateController", EnagCreateController)

// ------------------- DEPENDENCIA ENTRE ENTIDADES --------------------
.controller("EnenCreateController", EnenCreateController);

function config($routeProvider) {
	$routeProvider

	.when("/metamodelo/tpdt/grid", {
		templateUrl : "modules/metamodelo/tpdt-grid.html",
		controller : "TpdtGridController",
		controllerAs : 'vm',
		reloadOnSearch : false
	})

	.when("/metamodelo/tpdt/create", {
		templateUrl : "modules/metamodelo/tpdt-edit.html",
		controller : "TpdtCreateController",
		controllerAs : 'vm'
	})

	.when("/metamodelo/tpdt/detail/:tpdtId", {
		templateUrl : "modules/metamodelo/tpdt-detail.html",
		controller : "TpdtDetailController",
		controllerAs : 'vm'
	})

	.when("/metamodelo/tpdt/edit/:tpdtId", {
		templateUrl : "modules/metamodelo/tpdt-edit.html",
		controller : "TpdtEditController",
		controllerAs : 'vm'
	})

	.when("/metamodelo/cdrf/detail/:cdrfId", {
		templateUrl : "modules/metamodelo/cdrf-detail.html",
		controller : "CdrfDetailController",
		controllerAs : 'vm'
	})

	.when("/metamodelo/cdrf/edit/:cdrfId", {
		templateUrl : "modules/metamodelo/cdrf-edit.html",
		controller : "CdrfEditController",
		controllerAs : 'vm'
	})

	.when("/metamodelo/cdrf/create/:tpdtId", {
		templateUrl : "modules/metamodelo/cdrf-edit.html",
		controller : "CdrfCreateController",
		controllerAs : 'vm'
	})

	.when("/metamodelo/tppr/grid", {
		templateUrl : "modules/metamodelo/tppr-grid.html",
		controller : "TpprGridController",
		controllerAs : 'vm',
		reloadOnSearch : false
	})

	.when("/metamodelo/tppr/detail/:entiId", {
		templateUrl : "modules/metamodelo/tppr-detail.html",
		controller : "TpprDetailController",
		controllerAs : 'vm'
	})

	.when("/metamodelo/tppr/edit/:entiId", {
		templateUrl : "modules/metamodelo/tppr-edit.html",
		controller : "TpprEditController",
		controllerAs : 'vm'
	})

	.when("/metamodelo/tppr/create", {
		templateUrl : "modules/metamodelo/tppr-edit.html",
		controller : "TpprCreateController",
		controllerAs : 'vm'
	})

	.when("/metamodelo/tpsp/detail/:entiId", {
		templateUrl : "modules/metamodelo/tpsp-detail.html",
		controller : "TpspDetailController",
		controllerAs : 'vm'
	})

	.when("/metamodelo/tpsp/edit/:entiId", {
		templateUrl : "modules/metamodelo/tpsp-edit.html",
		controller : "TpspEditController",
		controllerAs : 'vm'
	})

	.when("/metamodelo/tpsp/create/:tpprId", {
		templateUrl : "modules/metamodelo/tpsp-edit.html",
		controller : "TpspCreateController",
		controllerAs : 'vm'
	})

	.when("/metamodelo/tpsr/grid", {
		templateUrl : "modules/metamodelo/tpsr-grid.html",
		controller : "TpsrGridController",
		controllerAs : 'vm',
		reloadOnSearch : false
	})

	.when("/metamodelo/tpsr/detail/:entiId", {
		templateUrl : "modules/metamodelo/tpsr-detail.html",
		controller : "TpsrDetailController",
		controllerAs : 'vm'
	})

	.when("/metamodelo/tpsr/edit/:entiId", {
		templateUrl : "modules/metamodelo/tpsr-edit.html",
		controller : "TpsrEditController",
		controllerAs : 'vm'
	})

	.when("/metamodelo/tpsr/create", {
		templateUrl : "modules/metamodelo/tpsr-edit.html",
		controller : "TpsrCreateController",
		controllerAs : 'vm'
	})

	.when("/metamodelo/tpss/detail/:entiId", {
		templateUrl : "modules/metamodelo/tpss-detail.html",
		controller : "TpssDetailController",
		controllerAs : 'vm'
	})

	.when("/metamodelo/tpss/edit/:entiId", {
		templateUrl : "modules/metamodelo/tpss-edit.html",
		controller : "TpssEditController",
		controllerAs : 'vm'
	})

	.when("/metamodelo/tpss/create/:tpsrId", {
		templateUrl : "modules/metamodelo/tpss-edit.html",
		controller : "TpssCreateController",
		controllerAs : 'vm'
	})

	.when("/metamodelo/tpes/grid", {
		templateUrl : "modules/metamodelo/tpes-grid.html",
		controller : "TpesGridController",
		controllerAs : 'vm',
		reloadOnSearch : false
	})

	.when("/metamodelo/tpes/detail/:entiId", {
		templateUrl : "modules/metamodelo/tpes-detail.html",
		controller : "TpesDetailController",
		controllerAs : 'vm'
	})

	.when("/metamodelo/tpes/edit/:entiId", {
		templateUrl : "modules/metamodelo/tpes-edit.html",
		controller : "TpesEditController",
		controllerAs : 'vm'
	})

	.when("/metamodelo/tpes/create", {
		templateUrl : "modules/metamodelo/tpes-edit.html",
		controller : "TpesCreateController",
		controllerAs : 'vm'
	})

	.when("/metamodelo/cmag/detail/:tpesId/:entdId", {
		templateUrl : "modules/metamodelo/cmag-detail.html",
		controller : "CmagDetailController",
		controllerAs : 'vm'
	})

	.when("/metamodelo/cmag/edit/:tpesId/:entdId", {
		templateUrl : "modules/metamodelo/cmag-edit.html",
		controller : "CmagEditController",
		controllerAs : 'vm'
	})

	.when("/metamodelo/cmag/create/:tpesId", {
		templateUrl : "modules/metamodelo/cmag-edit.html",
		controller : "CmagCreateController",
		controllerAs : 'vm'
	})

	.when("/metamodelo/entd/detail/:entiId/:tpdtId", {
		templateUrl : "modules/metamodelo/entd-detail.html",
		controller : "EntdEditController",
		controllerAs : 'vm'
	})

	.when("/metamodelo/entd/edit/:entiId/:tpdtId", {
		templateUrl : "modules/metamodelo/entd-edit.html",
		controller : "EntdEditController",
		controllerAs : 'vm'
	})

	.when("/metamodelo/entd/create/:entiId", {
		templateUrl : "modules/metamodelo/entd-edit.html",
		controller : "EntdCreateController",
		controllerAs : 'vm'
	})

	.when("/metamodelo/engd/detail/:engdId", {
		templateUrl : "modules/metamodelo/engd-detail.html",
		controller : "EngdDetailController",
		controllerAs : 'vm'
	})

	.when("/metamodelo/engd/edit/:engdId", {
		templateUrl : "modules/metamodelo/engd-edit.html",
		controller : "EngdEditController",
		controllerAs : 'vm'
	})

	.when("/metamodelo/engd/create/:entiId", {
		templateUrl : "modules/metamodelo/engd-edit.html",
		controller : "EngdCreateController",
		controllerAs : 'vm'
	})

	.when("/metamodelo/enac/detail/:id", {
		templateUrl : "modules/metamodelo/enac-detail.html",
		controller : "EnacDetailController",
		controllerAs : 'vm'
	})

	.when("/metamodelo/enac/edit/:id", {
		templateUrl : "modules/metamodelo/enac-edit.html",
		controller : "EnacEditController",
		controllerAs : 'vm'
	})

	.when("/metamodelo/enac/create/:entiId", {
		templateUrl : "modules/metamodelo/enac-edit.html",
		controller : "EnacCreateController",
		controllerAs : 'vm'
	})

	.when("/metamodelo/enag/detail/:id", {
		templateUrl : "modules/metamodelo/enag-detail.html",
		controller : "EnagDetailController",
		controllerAs : 'vm'
	})

	.when("/metamodelo/enag/edit/:id", {
		templateUrl : "modules/metamodelo/enag-edit.html",
		controller : "EnagEditController",
		controllerAs : 'vm'
	})

	.when("/metamodelo/enag/create/:entiId", {
		templateUrl : "modules/metamodelo/enag-edit.html",
		controller : "EnagCreateController",
		controllerAs : 'vm'
	})

	.when("/metamodelo/enen/create/:entipId", {
		templateUrl : "modules/metamodelo/enen-edit.html",
		controller : "EnenCreateController",
		controllerAs : 'vm'
	});
}

function TpdtGridController($http, $location, $routeParams, $modal,
		pageTitleService) {
	var vm = this;

	vm.search = search;
	vm.pageChanged = pageChanged;
	vm.filter = filter;

	vm.tpdtCriterio = $routeParams.tpdtCriterio ? angular
			.fromJson($routeParams.tpdtCriterio) : {};
	vm.page = $routeParams.page ? $routeParams.page : 1;

	function search(page) {
		$http.post("metamodelo/tpdt-list.action", {
			tpdtCriterio : vm.tpdtCriterio,
			page : page,
			limit : vm.limit
		}).success(function(data) {
			vm.tpdtList = data.tpdtList;
			vm.page = data.tpdtList.page;

			$location.search({
				page : vm.page,
				tpdtCriterio : JSON.stringify(vm.tpdtCriterio)
			}).replace();
		});
	}

	function pageChanged() {
		search(vm.page);
	}

	function filter(size) {
		$http.post("metamodelo/tpdt-filter.action").success(function(data) {
			vm.tphtList = data.tphtList;
			vm.tpelList = data.tpelList;
		});
	}

	search($routeParams.page ? $routeParams.page : 1);
	pageTitleService.setTitle("tpdt", "page_grid");
}

function TpdtCreateController($http, $location, $routeParams, pageTitleService) {
	var vm = this;

	vm.save = save;
	vm.cancel = cancel;

	function save() {
		$http.post("metamodelo/tpdt-save.action", {
			tpdt : vm.tpdt,
			i18nMap : vm.i18nMap,
			accion : vm.accion
		}).success(
				function(data) {
					$location.path("/metamodelo/tpdt/detail/" + data.tpdt.id)
							.replace();
				});
	}

	function cancel() {
		window.history.back();
	}

	$http.post("metamodelo/tpdt-create.action").success(function(data) {
		vm.tpdt = data.tpdt;
		vm.accion = data.accion;
		vm.tphtList = data.tphtList;
		vm.tpelList = data.tpelList;

		vm.entiTpprList = data.tpprList;
		vm.entiTpsrList = data.tpsrList;
	});

	pageTitleService.setTitle("tpdt", "page_create");
}

function TpdtDetailController($http, $routeParams, pageTitleService) {
	var vm = this;

	vm.remove = remove;

	function remove() {
		if (confirm("Are you sure?")) {
			$http.post("metamodelo/tpdt-remove.action", {
				tpdt : vm.tpdt
			}).success(function(data) {
				window.history.back();
			});
		}
	}

	$http.post("metamodelo/tpdt-detail.action", {
		tpdt : {
			id : $routeParams.tpdtId
		}
	}).success(function(data) {
		vm.tpdt = data.tpdt;
		vm.i18nMap = data.i18nMap;
		vm.cdrfList = data.cdrfList;
	});

	pageTitleService.setTitle("tpdt", "page_detail");
}

function TpdtEditController($http, $routeParams, pageTitleService) {
	var vm = this;

	vm.save = save;
	vm.cancel = cancel;

	function save() {
		$http.post("metamodelo/tpdt-save.action", {
			tpdt : vm.tpdt,
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

	$http.post("metamodelo/tpdt-edit.action", {
		tpdt : {
			id : $routeParams.tpdtId
		}
	}).success(function(data) {
		vm.tpdt = data.tpdt;
		vm.i18nMap = data.i18nMap;
		vm.accion = data.accion;
		vm.tphtList = data.tphtList;
		vm.tpelList = data.tpelList;

		vm.entiTpprList = data.tpprList;
		vm.entiTpsrList = data.tpsrList;
	});

	pageTitleService.setTitle("tpdt", "page_edit");
}

function CdrfCreateController($http, $location, $routeParams, pageTitleService) {
	var vm = this;

	vm.save = save;
	vm.cancel = cancel;

	function save() {
		$http.post("metamodelo/cdrf-save.action", {
			cdrf : vm.cdrf,
			i18nMap : vm.i18nMap,
			accion : vm.accion
		}).success(
				function(data) {
					$location.path("/metamodelo/cdrf/detail/" + data.cdrf.id)
							.replace();
				});
	}

	function cancel() {
		window.history.back();
	}

	$http.post("metamodelo/cdrf-create.action", {
		cdrf : {
			tpdtId : $routeParams.tpdtId
		}
	}).success(function(data) {
		vm.cdrf = data.cdrf;
		vm.i18nMap = data.i18nMap;
		vm.accion = data.accion;
	});

	pageTitleService.setTitle("cdrf", "page_create");
}

function CdrfDetailController($http, $location, $routeParams, pageTitleService) {
	var vm = this;

	vm.remove = remove;

	function remove() {
		if (confirm("Are you sure?")) {
			$http.post("metamodelo/cdrf-remove.action", {
				cdrf : vm.cdrf
			}).success(function(data) {
				window.history.back();
			});
		}
	}

	$http.post("metamodelo/cdrf-detail.action", {
		cdrf : {
			id : $routeParams.cdrfId
		}
	}).success(function(data) {
		vm.cdrf = data.cdrf;
		vm.i18nMap = data.i18nMap;
	});

	pageTitleService.setTitle("cdrf", "page_detail");
}

function CdrfEditController($http, $routeParams, pageTitleService) {
	var vm = this;

	vm.save = save;
	vm.cancel = cancel;

	function save() {
		$http.post("metamodelo/cdrf-save.action", {
			cdrf : vm.cdrf,
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

	$http.post("metamodelo/cdrf-edit.action", {
		cdrf : {
			id : $routeParams.cdrfId
		}
	}).success(function(data) {
		vm.cdrf = data.cdrf;
		vm.i18nMap = data.i18nMap;
		vm.accion = data.accion;
	});

	pageTitleService.setTitle("cdrf", "page_edit");
}

function TpprGridController($http, $location, $routeParams, $modal,
		pageTitleService) {
	var vm = this;

	vm.search = search;
	vm.pageChanged = pageChanged;
	vm.filter = filter;

	vm.entiCriterio = $routeParams.entiCriterio ? angular
			.fromJson($routeParams.entiCriterio) : {};
	vm.page = $routeParams.page ? $routeParams.page : 1;

	function search(page) {
		$http.post("metamodelo/tppr-list.action", {
			entiCriterio : vm.entiCriterio,
			page : page,
			limit : vm.limit
		}).success(function(data) {
			vm.entiList = data.entiList;
			vm.page = data.entiList.page;

			$location.search({
				page : vm.page,
				entiCriterio : JSON.stringify(vm.entiCriterio)
			}).replace();
		});
	}

	function pageChanged() {
		search(vm.page);
	}

	function filter(size) {
	}

	search($routeParams.page ? $routeParams.page : 1);
	pageTitleService.setTitle("tppr", "page_grid");
}

function TpprDetailController($http, $location, $routeParams, pageTitleService) {
	var vm = this;

	vm.remove = remove;

	function remove() {
		if (confirm("Are you sure?")) {
			$http.post("metamodelo/tppr-remove.action", {
				enti : {
					id : vm.enti.id
				}
			}).success(function(data) {
				window.history.back();
			});
		}
	}

	$http.post("metamodelo/tppr-detail.action", {
		enti : {
			id : $routeParams.entiId
		}
	}).success(function(data) {
		vm.enti = data.enti;
		vm.subentiList = data.subentiList;
		vm.i18nMap = data.i18nMap;
	});

	pageTitleService.setTitle("tppr", "page_detail");
}

function TpprEditController($http, $routeParams, pageTitleService) {
	var vm = this;

	vm.save = save;
	vm.cancel = cancel;

	function save() {
		$http.post("metamodelo/tppr-save.action", {
			enti : vm.enti,
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

	$http.post("metamodelo/tppr-edit.action", {
		enti : {
			id : $routeParams.entiId
		}
	}).success(function(data) {
		vm.enti = data.enti;
		vm.accion = data.accion;
		vm.i18nMap = data.i18nMap;

		$http.post("metamodelo/tpdt-lv-list.action", {
			tpdtCriterio : {
				tipoElemento : "TX",
				entiRefId : $routeParams.entiId
			}
		}).success(function(data) {
			vm.tpdtNombreList = data.lvList;
		});
	});

	pageTitleService.setTitle("tppr", "page_edit");
}

function TpprCreateController($http, $location, $routeParams, pageTitleService) {
	var vm = this;

	vm.save = save;
	vm.cancel = cancel;

	function save() {
		$http.post("metamodelo/tppr-save.action", {
			enti : vm.enti,
			i18nMap : vm.i18nMap,
			accion : vm.accion
		}).success(
				function(data) {
					$location.path("/metamodelo/tppr/detail/" + data.enti.id)
							.replace();
				});
	}

	function cancel() {
		setTimeout(function() {
			window.history.back();
		}, 0);
	}

	$http.post("metamodelo/tppr-create.action").success(function(data) {
		vm.enti = data.enti;
		vm.accion = data.accion;
	});

	$http.post("metamodelo/tpdt-lv-list.action", {
		tpdtCriterio : {
			tipoElemento : "TX",
			entiRefId : $routeParams.entiId
		}
	}).success(function(data) {
		vm.tpdtNombreList = data.lvList;
	});

	pageTitleService.setTitle("tppr", "page_create");
}

function TpspDetailController($http, $routeParams, pageTitleService) {
	var vm = this;

	vm.remove = remove;

	function remove() {
		if (confirm("Are you sure?")) {
			$http.post("metamodelo/tpsp-remove.action", {
				enti : {
					id : vm.enti.id
				}
			}).success(function(data) {
				window.history.back();
			});
		}
	}

	$http.post("metamodelo/tpsp-detail.action", {
		enti : {
			id : $routeParams.entiId
		}
	}).success(function(data) {
		vm.enti = data.enti;
		vm.i18nMap = data.i18nMap;
	});

	pageTitleService.setTitle("tpsp", "page_detail");
}

function TpspEditController($http, $routeParams, pageTitleService) {
	var vm = this;

	vm.save = save;
	vm.cancel = cancel;

	function save() {
		$http.post("metamodelo/tpsp-save.action", {
			enti : vm.enti,
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

	$http.post("metamodelo/tpsp-edit.action", {
		enti : {
			id : $routeParams.entiId
		}
	}).success(function(data) {
		vm.enti = data.enti;
		vm.i18nMap = data.i18nMap;
		vm.accion = data.accion;
		vm.entiList = data.tpprList;
	});

	pageTitleService.setTitle("tpsp", "page_edit");
}

function TpspCreateController($http, $location, $routeParams, pageTitleService) {
	var vm = this;

	vm.save = save;
	vm.cancel = cancel;

	function save() {
		$http.post("metamodelo/tpsp-save.action", {
			enti : vm.enti,
			i18nMap : vm.i18nMap,
			accion : vm.accion
		}).success(
				function(data) {
					$location.path("/metamodelo/tpsp/detail/" + data.enti.id)
							.replace();
				});
	}

	function cancel() {
		window.history.back();
	}

	$http.post("metamodelo/tpsp-create.action", {
		enti : {
			tpprId : $routeParams.tpprId
		}
	}).success(function(data) {
		vm.enti = data.enti;
		vm.accion = data.accion;
		vm.entiList = data.tpprList;
	});

	pageTitleService.setTitle("tpsp", "page_create");
}

function TpsrGridController($http, $location, $routeParams, $modal,
		pageTitleService) {
	var vm = this;

	vm.search = search;
	vm.pageChanged = pageChanged;
	vm.filter = filter;

	vm.entiCriterio = $routeParams.entiCriterio ? angular
			.fromJson($routeParams.entiCriterio) : {};
	vm.page = $routeParams.page ? $routeParams.page : 1;

	function search(page) {
		$http.post("metamodelo/tpsr-list.action", {
			entiCriterio : vm.entiCriterio,
			page : page,
			limit : vm.limit
		}).success(function(data) {
			vm.entiList = data.entiList;
			vm.page = data.entiList.page;

			$location.search({
				page : vm.page,
				entiCriterio : JSON.stringify(vm.entiCriterio)
			}).replace();
		});
	}

	function pageChanged() {
		search(vm.page);
	}

	function filter(size) {
	}

	search($routeParams.page ? $routeParams.page : 1);
	pageTitleService.setTitle("tpsr", "page_grid");
}

function TpsrDetailController($http, $routeParams, pageTitleService) {
	var vm = this;

	vm.remove = remove;

	function remove() {
		if (confirm("Are you sure?")) {
			$http.post("metamodelo/tpsr-remove.action", {
				enti : {
					id : vm.enti.id
				}
			}).success(function(data) {
				window.history.back();
			});
		}
	}

	$http.post("metamodelo/tpsr-detail.action", {
		enti : {
			id : $routeParams.entiId
		}
	}).success(function(data) {
		vm.enti = data.enti;
		vm.i18nMap = data.i18nMap;
		vm.subentiList = data.subentiList;
		vm.entiHijasList = data.entiHijasList;
	});

	pageTitleService.setTitle("tpsr", "page_detail");
}

function TpsrEditController($http, $routeParams, pageTitleService) {
	var vm = this;

	vm.save = save;
	vm.cancel = cancel;

	function save() {
		$http.post("metamodelo/tpsr-save.action", {
			enti : vm.enti,
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

	$http.post("metamodelo/tpsr-edit.action", {
		enti : {
			id : $routeParams.entiId
		}
	}).success(function(data) {
		vm.enti = data.enti;
		vm.i18nMap = data.i18nMap;
		vm.accion = data.accion;
	});

	$http.post("metamodelo/tpdt-lv-list.action", {
		tpdtCriterio : {
			tipoElemento : "CR"
		}
	}).success(function(data) {
		vm.tpdtEstadoList = data.lvList;
	});

	pageTitleService.setTitle("tpsr", "page_edit");
}

function TpsrCreateController($http, $location, $routeParams, pageTitleService) {
	var vm = this;

	vm.save = save;
	vm.cancel = cancel;

	function save() {
		$http.post("metamodelo/tpsr-save.action", {
			enti : vm.enti,
			i18nMap : vm.i18nMap,
			accion : vm.accion
		}).success(
				function(data) {
					$location.path("/metamodelo/tpsr/detail/" + data.enti.id)
							.replace();
				});
	}

	function cancel() {
		window.history.back();
	}

	$http.post("metamodelo/tpsr-create.action").success(function(data) {
		vm.enti = data.enti;
		vm.accion = data.accion;
	});

	$http.post("metamodelo/tpdt-lv-list.action", {
		tpdtCriterio : {
			tipoElemento : "CR"
		}
	}).success(function(data) {
		vm.tpdtEstadoList = data.lvList;
	});

	pageTitleService.setTitle("tpsr", "page_create");
}

function TpssDetailController($http, $routeParams, pageTitleService) {
	var vm = this;

	vm.remove = remove;

	function remove() {
		if (confirm("Are you sure?")) {
			$http.post("metamodelo/tpss-remove.action", {
				enti : {
					id : vm.enti.id
				}
			}).success(function(data) {
				window.history.back();
			});
		}
	}

	$http.post("metamodelo/tpss-detail.action", {
		enti : {
			id : $routeParams.entiId
		}
	}).success(function(data) {
		vm.enti = data.enti;
		vm.i18nMap = data.i18nMap;
		vm.entiHijasList = data.entiHijasList;
		vm.entiPadresList = data.entiPadresList;
	});

	pageTitleService.setTitle("tpss", "page_detail");
}

function TpssEditController($http, $routeParams, pageTitleService) {
	var vm = this;

	vm.save = save;
	vm.cancel = cancel;

	function save() {
		$http.post("metamodelo/tpss-save.action", {
			enti : vm.enti,
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

	$http.post("metamodelo/tpss-edit.action", {
		enti : {
			id : $routeParams.entiId
		}
	}).success(function(data) {
		vm.enti = data.enti;
		vm.i18nMap = data.i18nMap;
		vm.accion = data.accion;
	});

	$http.post("metamodelo/tpdt-lv-list.action", {
		tpdtCriterio : {
			tipoElemento : "CR"
		}
	}).success(function(data) {
		vm.tpdtEstadoList = data.lvList;
	});

	pageTitleService.setTitle("tpss", "page_edit");
}

function TpssCreateController($http, $location, $routeParams, pageTitleService) {
	var vm = this;

	vm.save = save;
	vm.cancel = cancel;

	function save() {
		$http.post("metamodelo/tpss-save.action", {
			enti : vm.enti,
			i18nMap : vm.i18nMap,
			accion : vm.accion
		}).success(
				function(data) {
					$location.path("/metamodelo/tpss/detail/" + data.enti.id)
							.replace();
				});
	}

	function cancel() {
		window.history.back();
	}

	$http.post("metamodelo/tpss-create.action", {
		enti : {
			tpsrId : $routeParams.tpsrId
		}
	}).success(function(data) {
		vm.enti = data.enti;
		vm.accion = data.accion;
	});

	$http.post("metamodelo/tpdt-lv-list.action", {
		tpdtCriterio : {
			tipoElemento : "CR"
		}
	}).success(function(data) {
		vm.tpdtEstadoList = data.lvList;
	});

	pageTitleService.setTitle("tpss", "page_create");
}

function TpesGridController($http, $location, $routeParams, $modal,
		pageTitleService) {
	var vm = this;

	vm.search = search;
	vm.pageChanged = pageChanged;
	vm.filter = filter;

	vm.entiCriterio = $routeParams.entiCriterio ? angular
			.fromJson($routeParams.entiCriterio) : {};
	vm.page = $routeParams.page ? $routeParams.page : 1;

	function search(page) {
		$http.post("metamodelo/tpes-list.action", {
			entiCriterio : vm.entiCriterio,
			page : page,
			limit : vm.limit
		}).success(function(data) {
			vm.entiList = data.entiList;
			vm.page = data.entiList.page;

			$location.search({
				page : vm.page,
				entiCriterio : JSON.stringify(vm.entiCriterio)
			}).replace();
		});
	}

	function pageChanged() {
		search(vm.page);
	}

	function filter(size) {
	}

	search($routeParams.page ? $routeParams.page : 1);
	pageTitleService.setTitle("tpes", "page_grid");
}

function TpesDetailController($http, $routeParams, pageTitleService) {
	var vm = this;

	vm.remove = remove;

	function remove() {
		if (confirm("Are you sure?")) {
			$http.post("metamodelo/tpes-remove.action", {
				enti : {
					id : vm.enti.id
				}
			}).success(function(data) {
				window.history.back();
			});
		}
	}

	$http.post("metamodelo/tpes-detail.action", {
		enti : {
			id : $routeParams.entiId
		}
	}).success(function(data) {
		vm.enti = data.enti;
		vm.i18nMap = data.i18nMap;
		vm.subentiList = data.subentiList;
	});

	pageTitleService.setTitle("tpes", "page_detail");
}

function TpesEditController($http, $routeParams, pageTitleService) {
	var vm = this;

	vm.save = save;
	vm.cancel = cancel;

	function save() {
		$http.post("metamodelo/tpes-save.action", {
			enti : vm.enti,
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

	$http.post("metamodelo/tpes-edit.action", {
		enti : {
			id : $routeParams.entiId
		}
	}).success(function(data) {
		vm.enti = data.enti;
		vm.i18nMap = data.i18nMap;
		vm.accion = data.accion;
	});

	pageTitleService.setTitle("tpes", "page_edit");
}

function TpesCreateController($http, $location, $routeParams, pageTitleService) {
	var vm = this;

	vm.save = save;
	vm.cancel = cancel;

	function save() {
		$http.post("metamodelo/tpes-save.action", {
			enti : vm.enti,
			i18nMap : vm.i18nMap,
			accion : vm.accion
		}).success(
				function(data) {
					$location.path("/metamodelo/tpes/detail/" + data.enti.id)
							.replace();
				});
	}

	function cancel() {
		window.history.back();
	}

	$http.post("metamodelo/tpes-create.action").success(function(data) {
		vm.enti = data.enti;
		vm.accion = data.accion;
	});

	pageTitleService.setTitle("tpes", "page_create");
}

function CmagCreateController($http, $location, $routeParams, pageTitleService) {
	var vm = this;

	vm.save = save;
	vm.cancel = cancel;

	function save() {
		$http.post("metamodelo/cmag-save.action", {
			cmag : vm.cmag,
			accion : vm.accion
		}).success(
				function(data) {
					$location.path(
							"/metamodelo/cmag/detail/" + data.cmag.tpesId + "/"
									+ data.cmag.entd.id).replace();
				});
	}

	function cancel() {
		window.history.back();
	}

	$http.post("metamodelo/cmag-create.action", {
		cmag : {
			tpesId : $routeParams.tpesId
		}
	}).success(function(data) {
		vm.cmag = data.cmag;
		vm.accion = data.accion;
	});

	pageTitleService.setTitle("cmag", "page_create");
}

function CmagDetailController($http, $location, $routeParams, pageTitleService) {
	var vm = this;

	vm.remove = remove;

	function remove() {
		if (confirm("Are you sure?")) {
			$http.post("metamodelo/cmag-remove.action", {
				cmag : vm.cmag
			}).success(function(data) {
				window.history.back();
			});
		}
	}

	$http.post("metamodelo/cmag-detail.action", {
		cmag : {
			tpesId : $routeParams.tpesId,
			entd : {
				id : $routeParams.entdId
			}
		}
	}).success(function(data) {
		vm.cmag = data.cmag;
	});

	pageTitleService.setTitle("cmag", "page_detail");
}

function CmagEditController($http, $routeParams, pageTitleService) {
	var vm = this;

	vm.save = save;
	vm.cancel = cancel;

	function save() {
		$http.post("metamodelo/cmag-save.action", {
			cmag : vm.cmag,
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

	$http.post("metamodelo/cmag-edit.action?cmag.tpesId=", {
		cmag : {
			tpesId : $routeParams.tpesId,
			entd : {
				id : $routeParams.entdId
			}
		}
	}).success(function(data) {
		vm.cmag = data.cmag;
		vm.accion = data.accion;
	});

	pageTitleService.setTitle("cmag", "page_edit");
}

function EntdEditController($http, $routeParams, pageTitleService) {
	var vm = this;

	vm.remove = remove;

	function remove() {
		if (confirm("Are you sure?")) {
			$http.post("metamodelo/entd-remove.action", {
				entd : {
					id : vm.entd.id
				}
			}).success(function(data) {
				window.history.back();
			});
		}
	}

	$http.post("metamodelo/entd-detail.action", {
		entd : {
			entiId : $routeParams.entiId,
			tpdt : {
				id : $routeParams.tpdtId
			}
		}
	}).success(function(data) {
		vm.entd = data.entd;
		vm.i18nMap = data.i18nMap;
	});

	pageTitleService.setTitle("entd", "page_detail");
}

function EntdEditController($http, $routeParams, pageTitleService) {
	var vm = this;

	vm.save = save;
	vm.cancel = cancel;

	function save() {
		$http.post("metamodelo/entd-save.action", {
			entd : vm.entd,
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

	$http.post("metamodelo/entd-edit.action", {
		entd : {
			entiId : $routeParams.entiId,
			tpdt : {
				id : $routeParams.tpdtId
			}
		}
	}).success(function(data) {
		vm.entd = data.entd;
		vm.i18nMap = data.i18nMap;
		vm.accion = data.accion;
		vm.tpdtList = data.tpdtList;
		vm.engdList = data.engdList;
	});

	pageTitleService.setTitle("entd", "page_edit");
}

function EntdCreateController($http, $location, $routeParams, pageTitleService) {
	var vm = this;

	vm.save = save;
	vm.cancel = cancel;

	function save() {
		$http.post("metamodelo/entd-save.action", {
			entd : vm.entd,
			i18nMap : vm.i18nMap,
			accion : vm.accion
		}).success(
				function(data) {
					$location.path(
							"/metamodelo/entd/detail/" + data.entd.entiId + "/"
									+ data.entd.tpdt.id).replace();
				});
	}

	function cancel() {
		window.history.back();
	}

	$http.post("metamodelo/entd-create.action", {
		entd : {
			entiId : $routeParams.entiId
		}
	}).success(function(data) {
		vm.entd = data.entd;
		vm.tpdtList = data.tpdtList;
		vm.engdList = data.engdList;
		vm.accion = data.accion;
	});

	pageTitleService.setTitle("entd", "page_create");
}

function EngdDetailController($http, $location, $routeParams, pageTitleService) {
	var vm = this;

	vm.remove = remove;

	function remove() {
		if (confirm("Are you sure?")) {
			$http.post("metamodelo/engd-remove.action", {
				engd : {
					id : vm.engd.id
				}
			}).success(function(data) {
				window.history.back();
			});
		}
	}

	$http.post("metamodelo/engd-detail.action", {
		engd : {
			id : $routeParams.engdId
		}
	}).success(function(data) {
		vm.engd = data.engd;
		vm.i18nMap = data.i18nMap;
	});

	pageTitleService.setTitle("engd", "page_detail");
}

function EngdEditController($http, $routeParams, pageTitleService) {
	var vm = this;

	vm.save = save;
	vm.cancel = cancel;

	function save() {
		$http.post("metamodelo/engd-save.action", {
			engd : vm.engd,
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

	$http.post("metamodelo/engd-edit.action", {
		engd : {
			id : $routeParams.engdId
		}
	}).success(function(data) {
		vm.engd = data.engd;
		vm.i18nMap = data.i18nMap;
		vm.accion = data.accion;
	});

	pageTitleService.setTitle("engd", "page_edit");
}

function EngdCreateController($http, $location, $routeParams, pageTitleService) {
	var vm = this;

	vm.save = save;
	vm.cancel = cancel;

	function save() {
		$http.post("metamodelo/engd-save.action", {
			engd : vm.engd,
			i18nMap : vm.i18nMap,
			accion : vm.accion
		}).success(
				function(data) {
					$location.path("/metamodelo/engd/detail/" + data.engd.id)
							.replace();
				});
	}

	function cancel() {
		window.history.back();
	}

	$http.post("metamodelo/engd-create.action", {
		engd : {
			entiId : $routeParams.entiId
		}
	}).success(function(data) {
		vm.engd = data.engd;
		vm.accion = data.accion;
	});

	pageTitleService.setTitle("engd", "page_create");
}

function EnacDetailController($http, $location, $routeParams, pageTitleService) {
	var vm = this;

	vm.remove = remove;

	function remove() {
		if (confirm("Are you sure?")) {
			$http.post("metamodelo/enac-remove.action", {
				enac : {
					id : vm.enac.id
				}
			}).success(function(data) {
				window.history.back();
			});
		}
	}

	$http.post("metamodelo/enac-detail.action", {
		enac : {
			id : $routeParams.id
		}
	}).success(function(data) {
		vm.enac = data.enac;
		vm.i18nMap = data.i18nMap;
	});

	pageTitleService.setTitle("enac", "page_detail");
}

function EnacEditController($http, $routeParams, pageTitleService) {
	var vm = this;

	vm.save = save;
	vm.cancel = cancel;

	function save() {
		$http.post("metamodelo/enac-save.action", {
			enac : vm.enac,
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

	$http.post("metamodelo/enac-edit.action", {
		enac : {
			id : $routeParams.id
		}
	}).success(function(data) {
		vm.enac = data.enac;
		vm.i18nMap = data.i18nMap;
		vm.accion = data.accion;
	});

	pageTitleService.setTitle("enac", "page_edit");
}

function EnacCreateController($http, $location, $routeParams, pageTitleService) {
	var vm = this;

	vm.save = save;
	vm.cancel = cancel;

	function save() {
		$http.post("metamodelo/enac-save.action", {
			enac : vm.enac,
			i18nMap : vm.i18nMap,
			accion : vm.accion
		}).success(
				function(data) {
					$location.path("/metamodelo/enac/detail/" + data.enac.id)
							.replace();
				});
	}

	function cancel() {
		window.history.back();
	}

	$http.post("metamodelo/enac-create.action", {
		enac : {
			entiId : $routeParams.entiId
		}
	}).success(function(data) {
		vm.enac = data.enac;
		vm.accion = data.accion;
	});

	pageTitleService.setTitle("enac", "page_create");
}

function EnagDetailController($http, $location, $routeParams, pageTitleService) {
	var vm = this;

	vm.remove = remove;

	function remove() {
		if (confirm("Are you sure?")) {
			$http.post("metamodelo/enag-remove.action", {
				enag : {
					id : vm.enag.id
				}
			}).success(function(data) {
				window.history.back();
			});
		}
	}

	$http.post("metamodelo/enag-detail.action", {
		enag : {
			id : $routeParams.id
		}
	}).success(function(data) {
		vm.enag = data.enag;
		vm.i18nMap = data.i18nMap;
	});

	pageTitleService.setTitle("enag", "page_detail");
}

function EnagEditController($http, $routeParams, pageTitleService) {
	var vm = this;

	vm.save = save;
	vm.cancel = cancel;

	function save() {
		$http.post("metamodelo/enag-save.action", {
			enag : vm.enag,
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

	$http.post("metamodelo/enag-edit.action", {
		enag : {
			id : $routeParams.id
		}
	}).success(function(data) {
		vm.enag = data.enag;
		vm.i18nMap = data.i18nMap;
		vm.accion = data.accion;
	});

	pageTitleService.setTitle("enag", "page_edit");
}

function EnagCreateController($http, $location, $routeParams, pageTitleService) {
	var vm = this;

	vm.save = save;
	vm.cancel = cancel;

	function save() {
		$http.post("metamodelo/enag-save.action", {
			enag : vm.enag,
			i18nMap : vm.i18nMap,
			accion : vm.accion
		}).success(
				function(data) {
					$location.path("/metamodelo/enag/detail/" + data.enag.id)
							.replace();
				});
	}

	function cancel() {
		window.history.back();
	}

	$http.post("metamodelo/enag-create.action", {
		enag : {
			entiId : $routeParams.entiId
		}
	}).success(function(data) {
		vm.enag = data.enag;
		vm.accion = data.accion;
	});

	pageTitleService.setTitle("enag", "page_create");
}

function EnenCreateController($http, $routeParams, pageTitleService) {
	var vm = this;

	vm.save = save;
	vm.cancel = cancel;

	function save() {
		$http.post("metamodelo/enen-save.action", {
			enac : vm.enen,
			accion : vm.accion
		}).success(
				function(data) {
					$location.path("/metamodelo/enac/detail/" + data.enac.id)
							.replace();
				});
	}

	function cancel() {
		window.history.back();
	}

	$http.post("metamodelo/enen-create.action", {
		enen : {
			entiPadreId : $routeParams.entipId
		}
	}).success(function(data) {
		vm.enen = data.enen;
		vm.entiList = data.tpssList;
	});

	pageTitleService.setTitle("enen", "page_create");
}