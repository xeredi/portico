angular.module("maestro_controller", [])

.config(config)

.controller("MaestroIndexController", MaestroIndexController)

.controller("ParametroGridController", ParametroGridController)

.controller("ParametroDetailController", ParametroDetailController)

.controller("ParametroEditController", ParametroEditController)

.controller("SubparametroDetailController", SubparametroDetailController)

.controller("SubparametroEditController", SubparametroEditController)

;

function config($stateProvider) {
	$stateProvider

	.state("maestro-index", {
		url : "/maestro",
		templateUrl : "modules/entidad/maestro/maestro-index.html",
		controller : "MaestroIndexController as vm"
	})

	.state("parametro-grid", {
		url : "/maestro/parametro/grid/:entiId?page&searchCriteria&limit",
		templateUrl : "modules/entidad/maestro/parametro-grid.html",
		controller : "ParametroGridController as vm",
		reloadOnSearch : false
	})

	.state("parametro-detail", {
		url : "/maestro/parametro/detail/:entiId/:id?fref&tab",
		templateUrl : "modules/entidad/maestro/parametro-detail.html",
		controller : "ParametroDetailController as vm",
		reloadOnSearch : false
	})

	.state("parametro-create", {
		url : "/maestro/parametro/create/:entiId?fref",
		templateUrl : "modules/entidad/maestro/parametro-edit.html",
		controller : "ParametroEditController as vm",
		data : {
			accion : 'create'
		}
	})

	.state("parametro-edit", {
		url : "/maestro/parametro/edit/:entiId/:id?fref",
		templateUrl : "modules/entidad/maestro/parametro-edit.html",
		controller : "ParametroEditController as vm",
		data : {
			accion : 'edit'
		}
	})

	.state("parametro-duplicate", {
		url : "/maestro/parametro/duplicate/:entiId/:id?fref",
		templateUrl : "modules/entidad/maestro/parametro-edit.html",
		controller : "ParametroEditController as vm",
		data : {
			accion : 'duplicate'
		}
	})

	.state("subparametro-detail", {
		url : "/maestro/subparametro/detail/:entiId/:id?fref",
		templateUrl : "modules/entidad/maestro/subparametro-detail.html",
		controller : "SubparametroDetailController as vm",
	})

	.state("subparametro-create", {
		url : "/maestro/subparametro/create/:entiId/:prmtId?fref",
		templateUrl : "modules/entidad/maestro/subparametro-edit.html",
		controller : "SubparametroEditController as vm",
		data : {
			accion : 'create'
		}
	})

	.state("subparametro-edit", {
		url : "/maestro/subparametro/edit/:entiId/:prmtId/:id?fref",
		templateUrl : "modules/entidad/maestro/subparametro-edit.html",
		controller : "SubparametroEditController as vm",
		data : {
			accion : 'edit'
		}
	})

	.state("subparametro-duplicate", {
		url : "/maestro/subparametro/duplicate/:entiId/:prmtId/:id?fref",
		templateUrl : "modules/entidad/maestro/subparametro-edit.html",
		controller : "SubparametroEditController as vm",
		data : {
			accion : 'duplicate'
		}
	})

	;
}

function MaestroIndexController($translate, pageTitleService, MaestroService) {
	var vm = this;

	MaestroService.index().then(function(data) {
		vm.tpprList = data.resultList.map(function(tppr) {
			$translate('enti_' + tppr.value).then(function(translation) {
				tppr.label = translation.toUpperCase();
			});

			return tppr;
		});
	});

	pageTitleService.setTitle("prmtList", "page_home");
}

function ParametroGridController($state, $stateParams, $modal,
		pageTitleService, ParametroService) {
	var vm = this;

	vm.filter = filter;
	vm.resetFilter = resetFilter;
	vm.search = search;
	vm.pageChanged = pageChanged;
	vm.xlsExport = xlsExport;

	function filter() {
		ParametroService.filter(vm.searchCriteria).then(function(data) {
			vm.labelValuesMap = data.labelValuesMap;
			vm.limits = data.limits;
			vm.prtoList = data.prtoList;
		});
	}

	function resetFilter() {
		vm.searchCriteria = {};
	}

	function search(page) {
		vm.searchCriteria.entiId = $stateParams.entiId;
		vm.limit = $stateParams.limit;

		ParametroService.listPage(vm.searchCriteria, page, vm.limit).then(
				function(data) {
					vm.page = data.resultList.page;
					vm.limit = data.resultList.limit;
					vm.itemList = data.resultList;

					vm.enti = data.enti;
					vm.searchCriteria = data.model;
				});
	}

	function pageChanged() {
		search(vm.page);
	}

	function xlsExport() {
		ParametroService.xlsExport(vm.searchCriteria, 'prmt_'
				+ vm.searchCriteria.entiId);
	}

	vm.searchCriteria = $stateParams.searchCriteria ? angular
			.fromJson($stateParams.searchCriteria) : {};

	search($stateParams.page ? $stateParams.page : 1);

	pageTitleService.setTitleEnti($stateParams.entiId, "page_grid");
}

function ParametroDetailController($stateParams, pageTitleService,
		ParametroService, SubparametroService) {
	var vm = this;

	vm.remove = remove;
	vm.pdfExport = pdfExport;
	vm.tabSelected = tabSelected;

	function remove() {
		ParametroService.remove(vm.item).then(function(data) {
			window.history.back();
		});
	}

	function pdfExport() {
		ParametroService.pdfExport(vm.item, 'prmt_' + vm.item.entiId + '_'
				+ vm.item.id);
	}

	function tabSelected(tabNo) {
		ParametroService.tabSelected(tabNo);
	}

	vm.tabActive = {};

	if ($stateParams.tab) {
		vm.tabActive[$stateParams.tab] = true;
	}

	vm.item = {
		id : $stateParams.id,
		entiId : $stateParams.entiId,
		fref : $stateParams.fref ? $stateParams.fref : new Date()
	};

	ParametroService
			.detail(vm.item)
			.then(
					function(data) {
						vm.item = data.model;
						vm.i18nMap = data.i18nMap;

						if (data.model.prto) {
							vm.prtoId = data.model.prto.id;
						}

						vm.enti = data.enti;

						vm.itemHijosMap = {};
						vm.entiHijasMap = {};

						if (data.enti && vm.enti.entiHijasList) {
							for (i = 0; i < vm.enti.entiHijasList.length; i++) {
								var sprmSearchCriteria = {
									prmt : {
										id : vm.item.id
									},
									entiId : vm.enti.entiHijasList[i],
									fechaVigencia : vm.item.fref
								};

								SubparametroService
										.listPage(sprmSearchCriteria)
										.then(
												function(data) {
													vm.entiHijasMap[data.enti.enti.id] = data.enti;
													vm.itemHijosMap[data.enti.enti.id] = data.resultList;
												});
							}
						}
					});

	pageTitleService.setTitleEnti($stateParams.entiId, "page_detail");
}

function ParametroEditController($state, $stateParams, pageTitleService,
		ParametroService) {
	var vm = this;

	vm.save = save;
	vm.cancel = cancel;

	function save() {
		ParametroService.saveI18n(vm.accion, vm.item, vm.i18nMap).then(
				function(data) {
					ParametroService.redirectAfterSave(vm.accion, data.model,
							"parametro-detail");
				});
	}

	function cancel() {
		window.history.back();
	}

	vm.accion = $state.current.data.accion;
	vm.item = {
		id : $stateParams.id,
		entiId : $stateParams.entiId,
		fref : $stateParams.fref ? $stateParams.fref : new Date()
	};

	ParametroService.edit(vm.accion, vm.item).then(function(data) {
		vm.item = data.model;
		vm.i18nMap = data.i18nMap;
		vm.enti = data.enti;

		if (data.model.prto) {
			vm.prtoId = data.model.prto.id;
		}

		vm.labelValuesMap = data.labelValuesMap;
		vm.prtoList = data.prtoList;
	});

	pageTitleService.setTitleEnti($stateParams.entiId, "page_" + vm.accion);
}

function SubparametroDetailController($stateParams, pageTitleService,
		SubparametroService) {
	var vm = this;

	vm.remove = remove;

	function remove() {
		SubparametroService.remove(vm.item).then(function(data) {
			window.history.back();
		});
	}

	vm.item = {
		id : $stateParams.id,
		entiId : $stateParams.entiId,
		fref : $stateParams.fref ? $stateParams.fref : new Date()
	};

	SubparametroService.detail(vm.item).then(function(data) {
		vm.item = data.model;
		vm.enti = data.enti;

		vm.prtoId = data.prtoId;
	});

	pageTitleService.setTitleEnti($stateParams.entiId, "page_detail");
}

function SubparametroEditController($state, $stateParams, pageTitleService,
		SubparametroService) {
	var vm = this;

	vm.save = save;
	vm.cancel = cancel;

	function save() {
		SubparametroService.save(vm.accion, vm.item).then(
				function(data) {
					SubparametroService.redirectAfterSave(vm.accion,
							data.model, "subparametro-detail");
				});
	}

	function cancel() {
		window.history.back();
	}

	vm.accion = $state.current.data.accion;
	vm.item = {
		id : $stateParams.id,
		prmtId : $stateParams.prmtId,
		entiId : $stateParams.entiId,
		fref : $stateParams.fref
	};

	SubparametroService.edit(vm.accion, vm.item).then(function(data) {
		vm.item = data.model;
		vm.enti = data.enti;

		vm.prtoId = data.model.prtoId;

		vm.labelValuesMap = data.labelValuesMap;
		vm.prtoList = data.prtoList;
	});

	pageTitleService.setTitleEnti($stateParams.entiId, "page_" + vm.accion);
}
