angular.module("proceso_controller", [ "proceso_service" ])

.config(config)

.controller("ProcesoGridController", ProcesoGridController)

.controller("ProcesoDetailController", ProcesoDetailController)

;

function config($routeProvider) {
	$routeProvider

	.when("/proceso/proceso/grid", {
		templateUrl : "modules/proceso/proceso-grid.html",
		controller : "ProcesoGridController as vm",
		reloadOnSearch : false
	})

	.when("/proceso/proceso/detail/:id", {
		url : "/proceso/proceso/detail/:id",
		templateUrl : "modules/proceso/proceso-detail.html",
		controller : "ProcesoDetailController as vm",
	})

	;
}

function ProcesoGridController($route, $routeParams, $modal, pageTitleService,
		ProcesoService) {
	var vm = this;

	vm.filter = filter;
	vm.resetFilter = resetFilter;
	vm.search = search;
	vm.pageChanged = pageChanged;
	vm.xlsExport = xlsExport;

	function filter() {
		ProcesoService.filter(vm.searchCriteria).then(function(data) {
			vm.procesoTipos = data.procesoTipos;
			vm.procesoModulos = data.procesoModulos;
			vm.procesoEstados = data.procesoEstados;
		});
	}

	function resetFilter() {
		vm.searchCriteria = {};
	}

	function search(page) {
		ProcesoService.listPage(vm.searchCriteria, page, vm.limit).then(
				function(data) {
					vm.page = data.resultList.page;
					vm.limit = data.resultList.limit;
					vm.resultList = data.resultList;
				});
	}

	function pageChanged() {
		search(vm.page);
	}

	function xlsExport() {
		ProcesoService.xlsExport(vm.searchCriteria, 'prbt');
	}

	vm.searchCriteria = $routeParams.searchCriteria ? angular
			.fromJson($routeParams.searchCriteria) : {};
	vm.limit = $routeParams.limit;

	search($routeParams.page ? $routeParams.page : 1);

	pageTitleService.setTitle("prbt", "page_grid");
}

function ProcesoDetailController($routeParams, pageTitleService,
		ProcesoService, ProcesoMensajeService) {
	var vm = this;

	vm.cancel = cancel;
	vm.download = download;
	vm.pageChanged = pageChanged;

	function cancel() {
		ProcesoService.remove(vm.model).then(function(data) {
			window.history.back();
		});
	}

	function download(archId, archNombre) {
		ProcesoService.fileExport({
			prbtId : vm.prbt.id,
			archId : archId
		}, archNombre);
	}

	function pageChanged() {
		search(vm.page);
	}

	function search(page) {
		ProcesoMensajeService.listPage({
			prbtId : vm.model.id
		}, page).then(function(data) {
			vm.prmnList = data.resultList;
			vm.page = data.resultList.page;

			// FIXME pageChanged
		});
	}

	vm.search = {
		id : $routeParams.id
	};

	ProcesoService.detail(vm.search).then(function(data) {
		vm.model = data.model;

		vm.arinEntradaList = data.arinEntradaList;
		vm.arinSalidaList = data.arinSalidaList;
		vm.pritEntradaList = data.pritEntradaList;
		vm.pritSalidaList = data.pritSalidaList;
		vm.prpmMap = data.prpmMap;

		search($routeParams.page ? $routeParams.page : 1);
	});

	pageTitleService.setTitle("prbt", "page_detail");
}
