angular.module("servicio_controller", [])

.config(config)

.controller("ValoradorEditController", ValoradorEditController)

.controller("ServicioSecuenciaGridController", ServicioSecuenciaGridController)

.controller("ServicioSecuenciaDetailController",
		ServicioSecuenciaDetailController)

.controller("ServicioSecuenciaEditController", ServicioSecuenciaEditController)

.controller("ServicioIndexController", ServicioIndexController)

.controller("ServicioGridController", ServicioGridController)

.controller("ServicioDetailController", ServicioDetailController)

.controller("ServicioEditController", ServicioEditController)

.controller("SubservicioGridController", SubservicioGridController)

.controller("SubservicioDetailController", SubservicioDetailController)

.controller("SubservicioEditController", SubservicioEditController)

;

function config($stateProvider) {
	$stateProvider

			.state("valorador-create", {
				url : "/servicio/valorador/create/:entiId/:id",
				templateUrl : "modules/entidad/servicio/valorador-edit.html",
				controller : "ValoradorEditController as vm",
				data : {
					accion : 'create'
				}
			})

			.state(
					"servicio-secuencia-grid",
					{
						url : "/servicio/servicio-secuencia/grid?page&searchCriteria&limit",
						templateUrl : "modules/entidad/servicio/servicio-secuencia-grid.html",
						controller : "ServicioSecuenciaGridController as vm",
						reloadOnSearch : false
					})

			.state(
					"servicio-secuencia-detail",
					{
						url : "/servicio/servicio-secuencia/detail/:tpsrId/:prtoId/:anno",
						templateUrl : "modules/entidad/servicio/servicio-secuencia-detail.html",
						controller : "ServicioSecuenciaDetailController as vm",
					})

			.state(
					"servicio-secuencia-create",
					{
						url : "/servicio/servicio-secuencia/create",
						templateUrl : "modules/entidad/servicio/servicio-secuencia-edit.html",
						controller : "ServicioSecuenciaEditController as vm",
						data : {
							accion : 'create'
						}
					})

			.state(
					"servicio-secuencia-edit",
					{
						url : "/servicio/servicio-secuencia/edit/:tpsrId/:prtoId/:anno",
						templateUrl : "modules/entidad/servicio/servicio-secuencia-edit.html",
						controller : "ServicioSecuenciaEditController as vm",
						data : {
							accion : 'edit'
						}
					})

			.state("servicio-index", {
				url : "/servicio",
				templateUrl : "modules/entidad/servicio/servicio-index.html",
				controller : "ServicioIndexController as vm"
			})

			.state(
					"servicio-grid",
					{
						url : "/servicio/servicio/grid/:entiId?page&searchCriteria&limit",
						templateUrl : "modules/entidad/servicio/servicio-grid.html",
						controller : "ServicioGridController as vm",
						reloadOnSearch : false
					})

			.state("servicio-detail", {
				url : "/servicio/servicio/detail/:entiId/:id?tab&pageMap",
				templateUrl : "modules/entidad/servicio/servicio-detail.html",
				controller : "ServicioDetailController as vm",
			})

			.state("servicio-create", {
				url : "/servicio/servicio/create/:entiId",
				templateUrl : "modules/entidad/servicio/servicio-edit.html",
				controller : "ServicioEditController as vm",
				data : {
					accion : 'create'
				}
			})

			.state("servicio-edit", {
				url : "/servicio/servicio/edit/:entiId/:id",
				templateUrl : "modules/entidad/servicio/servicio-edit.html",
				controller : "ServicioEditController as vm",
				data : {
					accion : 'edit'
				}
			})

			.state("servicio-duplicate", {
				url : "/servicio/servicio/duplicate/:entiId/:id",
				templateUrl : "modules/entidad/servicio/servicio-edit.html",
				controller : "ServicioEditController as vm",
				data : {
					accion : 'duplicate'
				}
			})

			.state(
					"subservicio-grid",
					{
						url : "/servicio/subservicio/grid/:entiId?page&searchCriteria&limit",
						templateUrl : "modules/entidad/servicio/subservicio-grid.html",
						controller : "SubservicioGridController as vm",
						reloadOnSearch : false
					})

			.state(
					"subservicio-detail",
					{
						url : "/servicio/subservicio/detail/:entiId/:id?tab&pageMap",
						templateUrl : "modules/entidad/servicio/subservicio-detail.html",
						controller : "SubservicioDetailController as vm",
					})

			.state("subservicio-create", {
				url : "/servicio/subservicio/create/:entiId?srvcId",
				templateUrl : "modules/entidad/servicio/servicio-edit.html",
				controller : "SubservicioEditController as vm",
				data : {
					accion : 'create'
				}
			})

			.state("subservicio-edit", {
				url : "/servicio/subservicio/edit/:entiId/:id",
				templateUrl : "modules/entidad/subservicio/servicio-edit.html",
				controller : "SubservicioEditController as vm",
				data : {
					accion : 'edit'
				}
			})

			.state("subservicio-duplicate", {
				url : "/servicio/subservicio/duplicate/:entiId/:id",
				templateUrl : "modules/entidad/subservicio/servicio-edit.html",
				controller : "SubservicioEditController as vm",
				data : {
					accion : 'duplicate'
				}
			})

	;
}

function ValoradorEditController($state, $stateParams, pageTitleService,
		ValoradorService) {
	var vm = this;

	vm.save = save;
	vm.cancel = cancel;

	function save() {
		ValoradorService.save(vm.accion, vm.model).then(
				function(data) {
					ValoradorService.redirectAfterSave(vm.accion,
							data.model.prbt, "proceso-batch-detail");
				});
	}

	function cancel() {
		window.history.back();
	}

	vm.accion = $state.current.data.accion;
	vm.model = {
		srvc : {
			entiId : $stateParams.entiId,
			id : $stateParams.id
		}
	}

	ValoradorService.edit(vm.accion, vm.model).then(function(data) {
		vm.model = data.model;
		vm.srvc = data.srvc;
		vm.fliq = data.fliq;
		vm.crgoList = data.crgoList;

		vm.crgoList = data.crgoList;
	});

	pageTitleService.setTitle("vldr", "page_" + vm.accion);
}

function ServicioSecuenciaGridController($state, $stateParams, $modal,
		pageTitleService, ServicioSecuenciaService) {
	var vm = this;

	vm.filter = filter;
	vm.resetFilter = resetFilter;
	vm.search = search;
	vm.pageChanged = pageChanged;

	function filter() {
		ServicioSecuenciaService.filter(vm.searchCriteria).then(function(data) {
			vm.tpsrList = data.tpsrList;
			vm.prtoList = data.prtoList;
		});
	}

	function resetFilter() {
		vm.searchCriteria = {};
	}

	function search(page) {
		ServicioSecuenciaService.listPage(vm.searchCriteria, page, vm.limit)
				.then(function(data) {
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

	pageTitleService.setTitle("srsc", "page_grid");
}

function ServicioSecuenciaDetailController($stateParams, pageTitleService,
		ServicioSecuenciaService) {
	var vm = this;

	vm.remove = remove;

	function remove() {
		ServicioSecuenciaService.remove(vm.model).then(function(data) {
			window.history.back();
		});
	}

	vm.model = {
		prto : {
			id : $stateParams.prtoId
		},
		tpsr : {
			id : $stateParams.tpsrId
		},
		anno : $stateParams.anno
	}

	ServicioSecuenciaService.detail(vm.model).then(function(data) {
		vm.model = data.model;
	});

	pageTitleService.setTitle("srsc", "page_detail");
}

function ServicioSecuenciaEditController($state, $stateParams,
		pageTitleService, ServicioSecuenciaService) {
	var vm = this;

	vm.save = save;
	vm.cancel = cancel;

	function save() {
		ServicioSecuenciaService.save(vm.accion, vm.model).then(function(data) {
			ServicioSecuenciaService.redirectAfterSave(vm.accion, {
				tpsrId : data.model.tpsr.id,
				prtoId : data.model.prto.id,
				anno : data.model.anno
			}, "servicio-secuencia-detail");
		});
	}

	function cancel() {
		window.history.back();
	}

	vm.accion = $state.current.data.accion;
	vm.model = {
		prto : {
			id : $stateParams.prtoId
		},
		tpsr : {
			id : $stateParams.tpsrId
		},
		anno : $stateParams.anno
	}

	ServicioSecuenciaService.edit(vm.accion, vm.model).then(function(data) {
		vm.model = data.model;

		vm.prtoList = data.prtoList;
		vm.tpsrList = data.tpsrList;
	});

	pageTitleService.setTitle("srsc", "page_" + vm.accion);
}

// SERVICIO
function ServicioIndexController($translate, pageTitleService, ServicioService) {
	var vm = this;

	ServicioService.index().then(function(data) {
		vm.tpsrList = data.resultList;
		vm.tpssMap = data.tpssMap;
	});

	pageTitleService.setTitle("srvcList", "page_home");
}

function ServicioGridController($state, $stateParams, $modal, pageTitleService,
		ServicioService) {
	var vm = this;

	vm.filter = filter;
	vm.resetFilter = resetFilter;
	vm.search = search;
	vm.pageChanged = pageChanged;
	vm.xlsExport = xlsExport;

	function filter() {
		ServicioService.filter(vm.searchCriteria).then(function(data) {
			vm.labelValuesMap = data.labelValuesMap;
			vm.prtoList = data.prtoList;
			vm.limits = data.limits;
			vm.fechaVigencia = data.fechaVigencia;
		});
	}

	function resetFilter() {
		vm.searchCriteria = {};
	}

	function search(page) {
		ServicioService.listPage(vm.searchCriteria, page, vm.limit).then(
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
		ServicioService.xlsExport(vm.searchCriteria, 'srvc_'
				+ vm.searchCriteria.entiId);
	}

	vm.searchCriteria = $stateParams.searchCriteria ? angular
			.fromJson($stateParams.searchCriteria) : {};
	vm.searchCriteria.entiId = $stateParams.entiId;
	vm.limit = $stateParams.limit;

	search($stateParams.page ? $stateParams.page : 1);

	pageTitleService.setTitleEnti($stateParams.entiId, "page_grid");
}

function ServicioDetailController($state, $stateParams, $modal,
		pageTitleService, ServicioService, SubservicioService) {
	var vm = this;

	vm.remove = remove;
	vm.pdfExport = pdfExport;
	vm.tabSelected = tabSelected;
	vm.pageChanged = pageChanged;

	function remove() {
		ServicioService.remove(vm.item).then(function(data) {
			window.history.back();
		});
	}

	function pdfExport() {
		ServicioService.pdfExport(vm.item, 'srvc_' + vm.item.entiId + '_'
				+ vm.item.id);
	}

	function tabSelected(tabNo) {
		ServicioService.tabSelected(tabNo);
	}

	function pageChanged(subentiId) {
		findSublist(subentiId, vm.pageMap[subentiId]);
	}

	function findSublist(subentiId, page) {
		var ssrvSearchCriteria = {
			srvc : {
				id : vm.item.id
			},
			entiId : subentiId
		};

		SubservicioService.listPage(ssrvSearchCriteria, page, vm.limit).then(
				function(data) {
					vm.entiHijasMap[data.enti.enti.id] = data.enti;
					vm.itemHijosMap[data.enti.enti.id] = data.resultList;
					vm.pageMap[data.enti.enti.id] = data.resultList.page;

					ServicioService.pageMapChanged(vm.pageMap);
				});
	}

	vm.tabActive = {};

	if ($stateParams.tab) {
		vm.tabActive[$stateParams.tab] = true;
	}

	vm.pageMap = $stateParams.pageMap ? angular.fromJson($stateParams.pageMap)
			: {};

	vm.item = {
		id : $stateParams.id,
		entiId : $stateParams.entiId
	};

	ServicioService.detail(vm.item).then(
			function(data) {
				vm.item = data.model;
				vm.enti = data.enti;

				vm.itemHijosMap = {};
				vm.entiHijasMap = {};

				if (data.enti && vm.enti.entiHijasList) {
					for (i = 0; i < vm.enti.entiHijasList.length; i++) {
						findSublist(vm.enti.entiHijasList[i],
								vm.pageMap[vm.enti.entiHijasList[i]]);
					}
				}
			});

	pageTitleService.setTitleEnti($stateParams.entiId, "page_detail");
}

function ServicioEditController($state, $stateParams, $modal, pageTitleService,
		ServicioService) {
	var vm = this;

	vm.save = save;
	vm.cancel = cancel;

	function save() {
		ServicioService.save(vm.accion, vm.item).then(
				function(data) {
					ServicioService.redirectAfterSave(vm.accion, data.model,
							"servicio-detail");
				});
	}

	function cancel() {
		window.history.back();
	}

	vm.accion = $state.current.data.accion;
	vm.item = {
		id : $stateParams.id,
		entiId : $stateParams.entiId
	};

	ServicioService.edit(vm.accion, vm.item).then(function(data) {
		vm.item = data.model;
		vm.enti = data.enti;

		vm.fechaVigencia = data.fechaVigencia;

		if (data.model.prto) {
			vm.prtoId = data.model.prto.id;
		}

		vm.labelValuesMap = data.labelValuesMap;
		vm.prtoList = data.prtoList;
	});

	pageTitleService.setTitleEnti($stateParams.entiId, "page_" + vm.accion);
}

function SubservicioGridController($state, $stateParams, $modal,
		pageTitleService, SubservicioService) {
	var vm = this;

	vm.filter = filter;
	vm.resetFilter = resetFilter;
	vm.search = search;
	vm.pageChanged = pageChanged;
	vm.xlsExport = xlsExport;

	function filter() {
		SubservicioService.filter(vm.searchCriteria).then(function(data) {
			vm.labelValuesMap = data.labelValuesMap;
			vm.prtoList = data.prtoList;
			vm.limits = data.limits;
			vm.fechaVigencia = data.fechaVigencia;
		});
	}

	function resetFilter() {
		vm.searchCriteria = {};
	}

	function search(page) {
		SubservicioService.listPage(vm.searchCriteria, page, vm.limit).then(
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
		SubservicioService.xlsExport(vm.searchCriteria, 'ssrv_'
				+ vm.searchCriteria.entiId);
	}

	vm.searchCriteria = $stateParams.searchCriteria ? angular
			.fromJson($stateParams.searchCriteria) : {};
	vm.searchCriteria.entiId = $stateParams.entiId;
	vm.limit = $stateParams.limit;

	search($stateParams.page ? $stateParams.page : 1);

	pageTitleService.setTitleEnti($stateParams.entiId, "page_grid");
}

function SubservicioDetailController($state, $stateParams, $modal,
		pageTitleService, SubservicioService) {
	var vm = this;

	vm.remove = remove;
	vm.tabSelected = tabSelected;
	vm.pageChanged = pageChanged;

	function remove() {
		SubservicioService.remove(vm.item).then(function(data) {
			window.history.back();
		});
	}

	function tabSelected(tabNo) {
		SubservicioService.tabSelected(tabNo);
	}

	function pageChanged(subentiId) {
		findSublist(subentiId, vm.pageMap[subentiId]);
	}

	function findSublist(subentiId, page) {
		var ssrvSearchCriteria = {
			entiId : subentiId,
			padreId : vm.item.id
		};

		SubservicioService.listPage(ssrvSearchCriteria, page, vm.limit).then(
				function(data) {
					vm.entiHijasMap[data.enti.enti.id] = data.enti;
					vm.itemHijosMap[data.enti.enti.id] = data.resultList;
					vm.pageMap[data.enti.enti.id] = data.resultList.page;

					SubservicioService.pageMapChanged(vm.pageMap);
				});
	}

	vm.tabActive = {};

	if ($stateParams.tab) {
		vm.tabActive[$stateParams.tab] = true;
	}

	vm.pageMap = $stateParams.pageMap ? angular.fromJson($stateParams.pageMap)
			: {};

	vm.item = {
		id : $stateParams.id,
		entiId : $stateParams.entiId
	};

	SubservicioService.detail(vm.item).then(
			function(data) {
				vm.enti = data.enti;
				vm.item = data.model;
				vm.itemPadresMap = data.itemPadresMap;
				vm.ittrList = data.ittrList;

				vm.itemHijosMap = {};
				vm.entiHijasMap = {};

				if (data.enti && vm.enti.entiHijasList) {
					for (i = 0; i < vm.enti.entiHijasList.length; i++) {
						findSublist(vm.enti.entiHijasList[i],
								vm.pageMap[vm.enti.entiHijasList[i]]);
					}
				}
			});

	pageTitleService.setTitleEnti($stateParams.entiId, "page_detail");
}

function SubservicioEditController($state, $stateParams, $modal,
		pageTitleService, SubservicioService) {
}
