angular.module("facturacion_controller", [])

.config(config)

// -------------------- Inicio Facturacion ------------------
.controller("FacturacionIndexController", FacturacionIndexController)

// -------------------- Parametrizacion ------------------
.controller("CargoGridController", CargoGridController)

.controller("CargoDetailController", CargoDetailController)

.controller("CargoEditController", CargoEditController)

.controller("CargoTypeaheadController", CargoTypeaheadController)

.controller("ReglaDetailController", ReglaDetailController)

.controller("ReglaEditController", ReglaEditController)

.controller("ReglaTypeaheadController", ReglaTypeaheadController)

.controller("ReglaIncompatibleDetailController",
		ReglaIncompatibleDetailController)

.controller("ReglaIncompatibleEditController", ReglaIncompatibleEditController)

.controller("AspectoGridController", AspectoGridController)

.controller("AspectoDetailController", AspectoDetailController)

.controller("AspectoEditController", AspectoEditController)

.controller("AspectoTypeaheadController", AspectoTypeaheadController)

.controller("AspectoCargoDetailController", AspectoCargoDetailController)

.controller("AspectoCargoEditController", AspectoCargoEditController)

.controller("FacturaSerieGridController", FacturaSerieGridController)

.controller("FacturaSerieDetailController", FacturaSerieDetailController)

.controller("FacturaSerieEditController", FacturaSerieEditController)

// -------------------- Gestion ------------------
.controller("ValoracionGridController", ValoracionGridController)

.controller("ValoracionDetailController", ValoracionDetailController)

.controller("ValoracionLineaDetailController", ValoracionLineaDetailController)

.controller("ValoracionDetalleDetailController",
		ValoracionDetalleDetailController)

;

function config($stateProvider) {
	$stateProvider

	// -------------------- Inicio Facturacion ------------------
	.state("facturacion-index", {
		url : "/facturacion/facturacion/index",
		templateUrl : "modules/facturacion/facturacion-index.html",
		controller : "FacturacionIndexController as vm",
		reloadOnSearch : false
	})

	// -------------------- Parametrizacion ------------------
	.state("cargo-grid", {
		url : "/facturacion/cargo/grid?page&searchCriteria&limit",
		templateUrl : "modules/facturacion/cargo-grid.html",
		controller : "CargoGridController as vm",
		reloadOnSearch : false
	})

	.state("cargo-detail", {
		url : "/facturacion/cargo/detail/:id?fref",
		templateUrl : "modules/facturacion/cargo-detail.html",
		controller : "CargoDetailController as vm",
	})

	.state("cargo-create", {
		url : "/facturacion/cargo/create",
		templateUrl : "modules/facturacion/cargo-edit.html",
		controller : "CargoEditController as vm",
		data : {
			accion : 'create'
		}
	})

	.state("cargo-edit", {
		url : "/facturacion/cargo/edit/:id?fref",
		templateUrl : "modules/facturacion/cargo-edit.html",
		controller : "CargoEditController as vm",
		data : {
			accion : 'edit'
		}
	})

	.state("regla-detail", {
		url : "/facturacion/regla/detail/:id?fref",
		templateUrl : "modules/facturacion/regla-detail.html",
		controller : "ReglaDetailController as vm",
	})

	.state("regla-create", {
		url : "/facturacion/regla/create/:crgoId?fref",
		templateUrl : "modules/facturacion/regla-edit.html",
		controller : "ReglaEditController as vm",
		data : {
			accion : 'create'
		}
	})

	.state("regla-edit", {
		url : "/facturacion/regla/edit/:id?fref",
		templateUrl : "modules/facturacion/regla-edit.html",
		controller : "ReglaEditController as vm",
		data : {
			accion : 'edit'
		}
	})

	.state("regla-incompatible-detail", {
		url : "/facturacion/regla-incompatible/detail/:id?fref",
		templateUrl : "modules/facturacion/regla-incompatible-detail.html",
		controller : "ReglaIncompatibleDetailController as vm",
	})

	.state("regla-incompatible-create", {
		url : "/facturacion/regla-incompatible/create/:rgla1Id?fref",
		templateUrl : "modules/facturacion/regla-incompatible-edit.html",
		controller : "ReglaIncompatibleEditController as vm",
		data : {
			accion : 'create'
		}
	})

	.state("regla-incompatible-edit", {
		url : "/facturacion/regla-incompatible/edit/:id?fref",
		templateUrl : "modules/facturacion/regla-incompatible-edit.html",
		controller : "ReglaIncompatibleEditController as vm",
		data : {
			accion : 'edit'
		}
	})

	.state("aspecto-grid", {
		url : "/facturacion/aspecto/grid?page&searchCriteria&limit",
		templateUrl : "modules/facturacion/aspecto-grid.html",
		controller : "AspectoGridController as vm",
		reloadOnSearch : false
	})

	.state("aspecto-detail", {
		url : "/facturacion/aspecto/detail/:id?fref",
		templateUrl : "modules/facturacion/aspecto-detail.html",
		controller : "AspectoDetailController as vm",
	})

	.state("aspecto-create", {
		url : "/facturacion/aspecto/create?fref",
		templateUrl : "modules/facturacion/aspecto-edit.html",
		controller : "AspectoEditController as vm",
		data : {
			accion : 'create'
		}
	})

	.state("aspecto-edit", {
		url : "/facturacion/aspecto/edit/:id?fref",
		templateUrl : "modules/facturacion/aspecto-edit.html",
		controller : "AspectoEditController as vm",
		data : {
			accion : 'edit'
		}
	})

	.state("aspecto-duplicate", {
		url : "/facturacion/aspecto/duplicate/:id?fref",
		templateUrl : "modules/facturacion/aspecto-edit.html",
		controller : "AspectoEditController as vm",
		data : {
			accion : 'duplicate'
		}
	})

	.state("aspecto-cargo-detail", {
		url : "/facturacion/aspecto-cargo/detail/:id?fref",
		templateUrl : "modules/facturacion/aspecto-cargo-detail.html",
		controller : "AspectoCargoDetailController as vm",
	})

	.state("aspecto-cargo-create", {
		url : "/facturacion/aspecto-cargo/create/:aspcId?fref",
		templateUrl : "modules/facturacion/aspecto-cargo-edit.html",
		controller : "AspectoCargoEditController as vm",
		data : {
			accion : 'create'
		}
	})

	.state("aspecto-cargo-edit", {
		url : "/facturacion/aspecto-cargo/edit/:id?fref",
		templateUrl : "modules/facturacion/aspecto-cargo-edit.html",
		controller : "AspectoCargoEditController as vm",
		data : {
			accion : 'edit'
		}
	})

	.state("factura-serie-grid", {
		url : "/facturacion/factura-serie/grid?page&searchCriteria&limit",
		templateUrl : "modules/facturacion/factura-serie-grid.html",
		controller : "FacturaSerieGridController as vm",
		reloadOnSearch : false
	})

	.state("factura-serie-detail", {
		url : "/facturacion/factura-serie/detail/:id?fref",
		templateUrl : "modules/facturacion/factura-serie-detail.html",
		controller : "FacturaSerieDetailController as vm",
	})

	.state("factura-serie-create", {
		url : "/facturacion/factura-serie/create",
		templateUrl : "modules/facturacion/factura-serie-edit.html",
		controller : "FacturaSerieEditController as vm",
		data : {
			accion : 'create'
		}
	})

	.state("factura-serie-edit", {
		url : "/facturacion/factura-serie/edit/:id",
		templateUrl : "modules/facturacion/factura-serie-edit.html",
		controller : "FacturaSerieEditController as vm",
		data : {
			accion : 'edit'
		}
	})

	// -------------------- Gestion ------------------
	.state("valoracion-grid", {
		url : "/facturacion/valoracion/grid?page&searchCriteria&limit",
		templateUrl : "modules/facturacion/valoracion-grid.html",
		controller : "ValoracionGridController as vm",
		reloadOnSearch : false
	})

	.state("valoracion-detail", {
		url : "/facturacion/valoracion/detail/:id?tab&pageMap",
		templateUrl : "modules/facturacion/valoracion-detail.html",
		controller : "ValoracionDetailController as vm",
		reloadOnSearch : false
	})

	.state("valoracion-linea-detail", {
		url : "/facturacion/valoracion-linea/detail/:vlrcId/:id?tab&pageMap",
		templateUrl : "modules/facturacion/valoracion-linea-detail.html",
		controller : "ValoracionLineaDetailController as vm",
		reloadOnSearch : false
	})

	.state("valoracion-detalle-detail", {
		url : "/facturacion/valoracion-detalle/detail/:vlrcId/:vlrlId/:id",
		templateUrl : "modules/facturacion/valoracion-detalle-detail.html",
		controller : "ValoracionDetalleDetailController as vm"
	})

	;
}

// -------------------- Inicio Facturacion ------------------
function FacturacionIndexController($state, $stateParams, $modal,
		pageTitleService, FacturacionService) {
	var vm = this;

	FacturacionService.index().then(function(data) {
	});

	pageTitleService.setTitle("sec_facturacion", "page_home");
}

// -------------------- Parametrizacion ------------------
function CargoGridController($state, $stateParams, $modal, pageTitleService,
		CargoService) {
	var vm = this;

	vm.filter = filter;
	vm.resetFilter = resetFilter;
	vm.search = search;
	vm.pageChanged = pageChanged;

	function filter() {
		CargoService.filter(vm.searchCriteria).then(function(data) {
			vm.tpsrList = data.tpsrList;
		});
	}

	function resetFilter() {
		vm.searchCriteria = {};
	}

	function search(page) {
		CargoService.listPage(vm.searchCriteria, page, vm.limit).then(
				function(data) {
					vm.page = data.resultList.page;
					vm.limit = data.resultList.limit;
					vm.resultList = data.resultList;
				});
	}

	function pageChanged() {
		search(vm.page);
	}

	vm.searchCriteria = $stateParams.searchCriteria ? angular
			.fromJson($stateParams.searchCriteria) : {};
	vm.limit = $stateParams.limit;

	search($stateParams.page ? $stateParams.page : 1);

	pageTitleService.setTitle("crgo", "page_grid");
}

function CargoDetailController($stateParams, pageTitleService, CargoService) {
	var vm = this;

	vm.remove = remove;

	function remove() {
		CargoService.remove(vm.model).then(function(data) {
			window.history.back();
		});
	}

	vm.model = {
		id : $stateParams.id,
		fref : $stateParams.fref
	};

	CargoService.detail(vm.model).then(function(data) {
		vm.model = data.model;
		vm.i18nMap = data.i18nMap;

		vm.rglaList = data.rglaList;
	});

	pageTitleService.setTitle("crgo", "page_detail");
}

function CargoEditController($state, $stateParams, pageTitleService,
		CargoService) {
	var vm = this;

	vm.save = save;
	vm.cancel = cancel;

	function save() {
		CargoService.saveI18n(vm.accion, vm.model, vm.i18nMap).then(
				function(data) {
					CargoService.redirectAfterSave(vm.accion, data.model,
							"cargo-detail");
				});
	}

	function cancel() {
		window.history.back();
	}

	vm.accion = $state.current.data.accion;
	vm.model = {
		id : $stateParams.id,
		fref : $stateParams.fref
	}

	CargoService.edit(vm.accion, vm.model).then(function(data) {
		vm.model = data.model;
		vm.i18nMap = data.i18nMap;

		vm.tipos = data.tipos;
		vm.tpsrList = data.tpsrList;
	});

	pageTitleService.setTitle("crgo", "page_" + vm.accion);
}

function CargoTypeaheadController($scope, CargoService) {
	var ta = this;

	ta.searchTpsr = searchTpsr;
	ta.searchAspc = searchAspc;
	ta.searchVlrc = searchVlrc;

	function searchTpsr(entiId, textoBusqueda, fechaVigencia) {
		if (textoBusqueda.length <= 0) {
			return null;
		}

		return CargoService.typeahead({
			tpsrId : entiId,
			textoBusqueda : textoBusqueda,
			fechaVigencia : fechaVigencia
		}).then(function(data) {
			return data.resultList;
		});
	}
	;

	function searchAspc(aspcId, textoBusqueda, fechaVigencia) {
		if (textoBusqueda.length <= 0) {
			return null;
		}

		return CargoService.typeahead({
			aspcId : aspcId,
			textoBusqueda : textoBusqueda,
			fechaVigencia : fechaVigencia
		}).then(function(data) {
			return data.resultList;
		});
	}
	;

	function searchVlrc(vlrcId, textoBusqueda) {
		if (textoBusqueda.length <= 0) {
			return null;
		}

		return CargoService.typeahead({
			vlrcId : vlrcId,
			textoBusqueda : textoBusqueda
		}).then(function(data) {
			return data.resultList;
		});
	}
	;
}

function ReglaDetailController($stateParams, pageTitleService, ReglaService) {
	var vm = this;

	vm.remove = remove;

	function remove() {
		ReglaService.remove(vm.model).then(function(data) {
			window.history.back();
		});
	}

	vm.model = {
		id : $stateParams.id,
		fref : $stateParams.fref
	};

	ReglaService.detail(vm.model).then(function(data) {
		vm.model = data.model;

		vm.rginList = data.rginList;
	});

	pageTitleService.setTitle("rgla", "page_detail");
}

function ReglaEditController($state, $stateParams, pageTitleService,
		ReglaService) {
	var vm = this;

	vm.save = save;
	vm.cancel = cancel;

	function save() {
		ReglaService.save(vm.accion, vm.model).then(
				function(data) {
					ReglaService.redirectAfterSave(vm.accion, data.model,
							"regla-detail");
				});
	}

	function cancel() {
		window.history.back();
	}

	vm.accion = $state.current.data.accion;
	vm.model = {
		crgo : {
			id : $stateParams.crgoId
		},
		id : $stateParams.id,
		fref : $stateParams.fref
	}

	ReglaService.edit(vm.accion, vm.model).then(function(data) {
		vm.model = data.model;

		vm.tipos = data.tipos;
		vm.entiFacturableList = data.entiFacturableList;
	});

	pageTitleService.setTitle("rgla", "page_" + vm.accion);
}

function ReglaTypeaheadController($scope, ReglaService) {
	var ta = this;

	ta.searchCrgo = searchCrgo;
	ta.searchVlrc = searchVlrc;

	function searchCrgo(crgoId, textoBusqueda, fechaVigencia) {
		if (textoBusqueda.length <= 0) {
			return null;
		}

		return CargoService.typeahead({
			crgoId : crgoId,
			textoBusqueda : textoBusqueda,
			fechaVigencia : fechaVigencia
		}).then(function(data) {
			return data.resultList;
		});
	}

	function searchVlrc(vlrcId, crgoId, textoBusqueda) {
		if (textoBusqueda.length <= 0) {
			return null;
		}

		return ReglaService.typeahead({
			vlrcId : vlrcId,
			crgoId : crgoId,
			textoBusqueda : textoBusqueda
		}).then(function(data) {
			return data.resultList;
		});
	}
}

function ReglaIncompatibleDetailController($stateParams, pageTitleService,
		ReglaIncompatibleService) {
	var vm = this;

	vm.remove = remove;

	function remove() {
		ReglaIncompatibleService.remove(vm.model).then(function(data) {
			window.history.back();
		});
	}

	vm.model = {
		id : $stateParams.id,
		fref : $stateParams.fref
	};

	ReglaIncompatibleService.detail(vm.model).then(function(data) {
		vm.model = data.model;
	});

	pageTitleService.setTitle("rgin", "page_detail");
}

function ReglaIncompatibleEditController($state, $stateParams,
		pageTitleService, ReglaIncompatibleService) {
	var vm = this;

	vm.save = save;
	vm.cancel = cancel;

	function save() {
		ReglaIncompatibleService.save(vm.accion, vm.model).then(
				function(data) {
					ReglaIncompatibleService.redirectAfterSave(vm.accion,
							data.model, "regla-incompatible-detail");
				});
	}

	function cancel() {
		window.history.back();
	}

	vm.accion = $state.current.data.accion;
	vm.model = {
		rgla1Id : $stateParams.rgla1Id,
		id : $stateParams.id,
		fref : $stateParams.fref
	}

	ReglaIncompatibleService.edit(vm.accion, vm.model).then(function(data) {
		vm.model = data.model;

		vm.rgla2List = data.rgla2List;
	});

	pageTitleService.setTitle("rgin", "page_" + vm.accion);
}

function AspectoGridController($state, $stateParams, $modal, pageTitleService,
		AspectoService) {
	var vm = this;

	vm.filter = filter;
	vm.resetFilter = resetFilter;
	vm.search = search;
	vm.pageChanged = pageChanged;

	function filter() {
		AspectoService.filter(vm.searchCriteria).then(function(data) {
			vm.tpsrList = data.tpsrList;
		});
	}

	function resetFilter() {
		vm.searchCriteria = {};
	}

	function search(page) {
		AspectoService.listPage(vm.searchCriteria, page, vm.limit).then(
				function(data) {
					vm.page = data.resultList.page;
					vm.limit = data.resultList.limit;
					vm.resultList = data.resultList;
				});
	}

	function pageChanged() {
		search(vm.page);
	}

	vm.searchCriteria = $stateParams.searchCriteria ? angular
			.fromJson($stateParams.searchCriteria) : {};
	vm.limit = $stateParams.limit;

	search($stateParams.page ? $stateParams.page : 1);

	pageTitleService.setTitle("aspc", "page_grid");
}

function AspectoDetailController($stateParams, pageTitleService, AspectoService) {
	var vm = this;

	vm.remove = remove;

	function remove() {
		AspectoService.remove(vm.model).then(function(data) {
			window.history.back();
		});
	}

	vm.model = {
		id : $stateParams.id,
		fref : $stateParams.fref
	};

	AspectoService.detail(vm.model).then(function(data) {
		vm.model = data.model;
		vm.i18nMap = data.i18nMap;

		vm.ascrList = data.ascrList;
	});

	pageTitleService.setTitle("aspc", "page_detail");
}

function AspectoEditController($state, $stateParams, pageTitleService,
		AspectoService) {
	var vm = this;

	vm.save = save;
	vm.cancel = cancel;

	function save() {
		AspectoService.saveI18n(vm.accion, vm.model, vm.i18nMap).then(
				function(data) {
					AspectoService.redirectAfterSave(vm.accion, data.model,
							"aspecto-detail");
				});
	}

	function cancel() {
		window.history.back();
	}

	vm.accion = $state.current.data.accion;
	vm.model = {
		id : $stateParams.id,
		fref : $stateParams.fref
	}

	AspectoService.edit(vm.accion, vm.model).then(function(data) {
		vm.model = data.model;
		vm.i18nMap = data.i18nMap;

		vm.tpsrList = data.tpsrList;
	});

	pageTitleService.setTitle("aspc", "page_" + vm.accion);
}

function AspectoTypeaheadController($scope, AspectoService) {
	var ta = this;

	ta.search = search;

	function search(entiId, textoBusqueda, fechaVigencia) {
		if (textoBusqueda.length <= 0) {
			return null;
		}

		return AspectoService.typeahead({
			tpsrId : entiId,
			textoBusqueda : textoBusqueda,
			fechaVigencia : fechaVigencia
		}).then(function(data) {
			return data.resultList;
		});
	}
}

function AspectoCargoDetailController($stateParams, pageTitleService,
		AspectoCargoService) {
	var vm = this;

	vm.remove = remove;

	function remove() {
		AspectoCargoService.remove(vm.model).then(function(data) {
			window.history.back();
		});
	}

	vm.model = {
		id : $stateParams.id,
		fref : $stateParams.fref
	};

	AspectoCargoService.detail(vm.model).then(function(data) {
		vm.model = data.model;
	});

	pageTitleService.setTitle("ascr", "page_detail");
}

function AspectoCargoEditController($state, $stateParams, pageTitleService,
		AspectoCargoService) {
	var vm = this;

	vm.save = save;
	vm.cancel = cancel;

	function save() {
		AspectoCargoService.saveI18n(vm.accion, vm.model, vm.i18nMap).then(
				function(data) {
					AspectoCargoService.redirectAfterSave(vm.accion,
							data.model, "aspecto-cargo-detail");
				});
	}

	function cancel() {
		window.history.back();
	}

	vm.accion = $state.current.data.accion;
	vm.model = {
		aspcId : $stateParams.aspcId,
		id : $stateParams.id,
		fref : $stateParams.fref
	}

	AspectoCargoService.edit(vm.accion, vm.model).then(function(data) {
		vm.model = data.model;

		vm.crgoList = data.crgoList;
	});

	pageTitleService.setTitle("ascr", "page_" + vm.accion);
}

function FacturaSerieGridController($state, $stateParams, $modal,
		pageTitleService, FacturaSerieService) {
	var vm = this;

	vm.filter = filter;
	vm.resetFilter = resetFilter;
	vm.search = search;
	vm.pageChanged = pageChanged;

	function filter() {
		FacturaSerieService.filter(vm.searchCriteria).then(function(data) {
			vm.fcsrList = data.tpsrList;
		});
	}

	function resetFilter() {
		vm.searchCriteria = {};
	}

	function search(page) {
		FacturaSerieService.listPage(vm.searchCriteria, page, vm.limit).then(
				function(data) {
					vm.page = data.resultList.page;
					vm.limit = data.resultList.limit;
					vm.resultList = data.resultList;
				});
	}

	function pageChanged() {
		search(vm.page);
	}

	vm.searchCriteria = $stateParams.searchCriteria ? angular
			.fromJson($stateParams.searchCriteria) : {};
	vm.limit = $stateParams.limit;

	search($stateParams.page ? $stateParams.page : 1);

	pageTitleService.setTitle("fcsr", "page_grid");
}

function FacturaSerieDetailController($stateParams, pageTitleService,
		FacturaSerieService) {
	var vm = this;

	vm.remove = remove;

	function remove() {
		FacturaSerieService.remove(vm.model).then(function(data) {
			window.history.back();
		});
	}

	vm.model = {
		id : $stateParams.id,
		fref : $stateParams.fref
	};

	FacturaSerieService.detail(vm.model).then(function(data) {
		vm.model = data.model;
	});

	pageTitleService.setTitle("fcsr", "page_detail");
}

function FacturaSerieEditController($state, $stateParams, pageTitleService,
		FacturaSerieService) {
	var vm = this;

	vm.save = save;
	vm.cancel = cancel;

	function save() {
		FacturaSerieService.save(vm.accion, vm.model).then(
				function(data) {
					FacturaSerieService.redirectAfterSave(vm.accion,
							data.model, "factura-serie-detail");
				});
	}

	function cancel() {
		window.history.back();
	}

	vm.accion = $state.current.data.accion;
	vm.model = {
		id : $stateParams.id,
		fref : $stateParams.fref
	}

	FacturaSerieService.edit(vm.accion, vm.model).then(function(data) {
		vm.model = data.model;
	});

	pageTitleService.setTitle("fcsr", "page_" + vm.accion);
}

// -------------------- Gestion ------------------
function ValoracionGridController($state, $stateParams, $modal,
		pageTitleService, ValoracionService) {
	var vm = this;

	vm.filter = filter;
	vm.resetFilter = resetFilter;
	vm.search = search;
	vm.pageChanged = pageChanged;

	function filter() {
		ValoracionService.filter(vm.searchCriteria).then(function(data) {
			vm.tpsrList = data.tpsrList;
		});
	}

	function resetFilter() {
		vm.searchCriteria = {};
	}

	function search(page) {
		ValoracionService.listPage(vm.searchCriteria, page, vm.limit).then(
				function(data) {
					vm.page = data.resultList.page;
					vm.limit = data.resultList.limit;
					vm.resultList = data.resultList;

					vm.tpdtCodExencion = data.tpdtCodExencion;
				});
	}

	function pageChanged() {
		search(vm.page);
	}

	vm.searchCriteria = $stateParams.searchCriteria ? angular
			.fromJson($stateParams.searchCriteria) : {};
	vm.limit = $stateParams.limit;

	search($stateParams.page ? $stateParams.page : 1);

	pageTitleService.setTitle("vlrc", "page_grid");
}

function ValoracionDetailController($stateParams, pageTitleService,
		ValoracionService, ValoracionLineaService) {
	var vm = this;

	vm.pageChanged = pageChanged;
	vm.tabSelected = tabSelected;
	vm.remove = remove;
	vm.print = print;

	function remove() {
		ValoracionService.remove(vm.model).then(function(data) {
			window.history.back();
		});
	}

	function pageChanged() {
		findVlrlList(vm.page);
	}

	function tabSelected(tabNo) {
		ValoracionService.tabSelected(tabNo);
	}

	function print() {
		ValoracionService.pdfExport(vm.model, 'vlrc_' + vm.model.id);
	}

	function findVlrlList(page) {
		var searchCriteria = {
			vlrc : {
				id : vm.model.id
			}
		};

		ValoracionLineaService.listPage(searchCriteria, page, vm.limit).then(
				function(data) {
					vm.vlrlList = data.resultList;
					vm.pageMap['vlrlList'] = data.resultList.page;

					ValoracionService.pageMapChanged(vm.pageMap);
				});
	}

	vm.tabActive = {};

	if ($stateParams.tab) {
		vm.tabActive[$stateParams.tab] = true;
	}

	vm.pageMap = $stateParams.pageMap ? angular.fromJson($stateParams.pageMap)
			: {};

	vm.model = {
		id : $stateParams.id
	};

	ValoracionService.detail(vm.model).then(function(data) {
		vm.model = data.model;

		vm.aspc = data.aspc;
		vm.tpdtCodExencion = data.tpdtCodExencion;

		vm.vlrgList = data.vlrgList;
		vm.vlriList = data.vlriList;

		findVlrlList(vm.pageMap['vlrlList']);
	});

	pageTitleService.setTitle("vlrc", "page_detail");
}

function ValoracionLineaDetailController($stateParams, pageTitleService,
		ValoracionLineaService, ValoracionDetalleService) {
	var vm = this;

	vm.pageChanged = pageChanged;
	vm.tabSelected = tabSelected;
	vm.remove = remove;

	function remove() {
		ValoracionLineaService.remove(vm.model).then(function(data) {
			window.history.back();
		});
	}

	function pageChanged() {
		findVlrdList(vm.page);
	}

	function tabSelected(tabNo) {
		ValoracionLineaService.tabSelected(tabNo);
	}

	function findVlrdList(page) {
		var searchCriteria = {
			vlrl : {
				id : vm.model.id
			}
		};

		ValoracionDetalleService.listPage(searchCriteria, page, vm.limit).then(
				function(data) {
					vm.vlrdList = data.resultList;
					vm.pageMap['vlrdList'] = data.resultList.page;

					ValoracionLineaService.pageMapChanged(vm.pageMap);
				});
	}

	vm.tabActive = {};

	if ($stateParams.tab) {
		vm.tabActive[$stateParams.tab] = true;
	}

	vm.pageMap = $stateParams.pageMap ? angular.fromJson($stateParams.pageMap)
			: {};

	vm.model = {
		id : $stateParams.id,
		vlrcId : $stateParams.vlrcId
	};

	ValoracionLineaService.detail(vm.model).then(function(data) {
		vm.model = data.model;

		vm.aspc = data.aspc;
		vm.vlrlPadre = data.vlrlPadre;
		vm.vlrlHijosList = data.vlrlHijosList;

		findVlrdList(vm.pageMap['vlrlList']);
	});

	pageTitleService.setTitle("vlrl", "page_detail");
}

function ValoracionDetalleDetailController($stateParams, pageTitleService,
		ValoracionDetalleService) {
	var vm = this;

	vm.remove = remove;

	function remove() {
		ValoracionDetalleService.remove(vm.model).then(function(data) {
			window.history.back();
		});
	}

	vm.model = {
		id : $stateParams.id,
		vlrlId : $stateParams.vlrlId,
		vlrcId : $stateParams.vlrcId
	};

	ValoracionDetalleService.detail(vm.model).then(function(data) {
		vm.model = data.model;

		vm.aspc = data.aspc;
		vm.vlrl = data.vlrl;
		vm.vlrlPadre = data.vlrlPadre;
		vm.vlrdHijosList = data.vlrdHijosList;
	});

	pageTitleService.setTitle("vlrd", "page_detail");
}
