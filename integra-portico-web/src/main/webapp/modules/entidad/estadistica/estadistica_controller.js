angular.module("estadistica_controller", [])

.config(config)

// -------------------- PERIODO DE PROCESO ------------------
.controller("PeriodoProcesoGridController", PeriodoProcesoGridController)

.controller("PeriodoProcesoDetailController", PeriodoProcesoDetailController)

.controller("PeriodoProcesoEditController", PeriodoProcesoEditController)

function config($stateProvider) {
	$stateProvider

			.state(
					"periodo-proceso-grid",
					{
						url : "/estadistica/periodo-proceso/grid?page&searchCriteria&limit",
						templateUrl : "modules/entidad/estadistica/periodo-proceso-grid.html",
						controller : "PeriodoProcesoGridController as vm",
						reloadOnSearch : false
					})

			.state(
					"periodo-proceso-detail",
					{
						url : "/estadistica/periodo-proceso/detail/:id",
						templateUrl : "modules/entidad/estadistica/periodo-proceso-detail.html",
						controller : "PeriodoProcesoDetailController as vm",
					})

			.state(
					"periodo-proceso-create",
					{
						url : "/estadistica/periodo-proceso/create",
						templateUrl : "modules/entidad/estadistica/periodo-proceso-edit.html",
						controller : "PeriodoProcesoEditController as vm",
						data : {
							accion : 'create'
						}
					})

			.state(
					"periodo-proceso-load",
					{
						url : "/estadistica/periodo-proceso/load",
						templateUrl : "modules/entidad/estadistica/periodo-proceso-edit.html",
						controller : "PeriodoProcesoEditController as vm",
						data : {
							accion : 'load'
						}
					})

	;
}

function PeriodoProcesoGridController($state, $stateParams, $modal,
		pageTitleService, PeriodoProcesoService) {
	var vm = this;

	vm.filter = filter;
	vm.resetFilter = resetFilter;
	vm.search = search;
	vm.pageChanged = pageChanged;

	function filter() {
		PeriodoProcesoService.filter(vm.searchCriteria).then(function(data) {
			vm.tphtList = data.tphtList;
			vm.tpelList = data.tpelList;
		});
	}

	function resetFilter() {
		vm.searchCriteria = {};
	}

	function search(page) {
		PeriodoProcesoService.listPage(vm.searchCriteria, page, vm.limit).then(
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

	pageTitleService.setTitle("pepr", "page_grid");
}

function PeriodoProcesoDetailController($stateParams, pageTitleService,
		PeriodoProcesoService) {
	var vm = this;

	vm.remove = remove;

	function remove() {
		PeriodoProcesoService.remove(vm.model).then(function(data) {
			window.history.back();
		});
	}

	vm.model = {
		id : $stateParams.id
	};

	PeriodoProcesoService.detail(vm.model).then(function(data) {
		vm.model = data.model;
	});

	pageTitleService.setTitle("pepr", "page_detail");
}

function PeriodoProcesoEditController($state, $stateParams, pageTitleService,
		PeriodoProcesoService) {
	var vm = this;

	vm.save = save;
	vm.cancel = cancel;

	function save() {
		PeriodoProcesoService.save(vm.accion, vm.model).then(
				function(data) {
					PeriodoProcesoService.redirectAfterSave(vm.accion,
							data.model, "periodo-proceso-detail");
				});
	}

	function cancel() {
		window.history.back();
	}

	vm.accion = $state.current.data.accion;
	vm.model = {
		id : $stateParams.id
	}

	PeriodoProcesoService.edit(vm.accion, vm.model).then(function(data) {
		vm.model = data.model;

		vm.tphtList = data.tphtList;
		vm.tpelList = data.tpelList;
		vm.entiTpprList = data.tpprList;
		vm.entiTpsrList = data.tpsrList;
	});

	pageTitleService.setTitle("pepr", "page_" + vm.accion);
}
