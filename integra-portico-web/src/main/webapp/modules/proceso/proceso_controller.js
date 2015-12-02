angular.module("proceso_controller", [ "proceso_service" ])

.config(config)

.controller("ProcesoGridController", ProcesoGridController)

.controller("ProcesoDetailController", ProcesoDetailController)

;

function config($stateProvider) {
	$stateProvider

	.state("proceso-grid", {
		url : "/proceso/proceso/grid?page&searchCriteria&limit",
		templateUrl : "modules/proceso/proceso-grid.html",
		controller : "ProcesoGridController as vm",
		reloadOnSearch : false
	})

	.state("proceso-detail", {
		url : "/proceso/proceso/detail/:id",
		templateUrl : "modules/proceso/proceso-detail.html",
		controller : "ProcesoDetailController as vm",
	})

	;
}

function ProcesoGridController($state, $stateParams, $modal, pageTitleService,
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

	vm.searchCriteria = $stateParams.searchCriteria ? angular
			.fromJson($stateParams.searchCriteria) : {};
	vm.limit = $stateParams.limit;

	search($stateParams.page ? $stateParams.page : 1);

	pageTitleService.setTitle("prbt", "page_grid");
}

function ProcesoDetailController($stateParams, pageTitleService,
		ProcesoService, ProcesoMensajeService) {
	var vm = this;

	vm.remove = remove;
	vm.download = download;
	vm.pageChanged = pageChanged;

	function remove() {
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
			prbtId : $stateParams.prbtId
		}, page).then(function(data) {
			vm.prmnList = data.resultList;
			vm.page = data.resultList.page;

			// FIXME pageChanged
		});
	}

	vm.model = {
		id : $stateParams.id
	};

	ProcesoService.detail(vm.model).then(function(data) {
		vm.model = data.model;

		vm.arinEntradaList = data.arinEntradaList;
		vm.arinSalidaList = data.arinSalidaList;
		vm.pritEntradaList = data.pritEntradaList;
		vm.pritSalidaList = data.pritSalidaList;
		vm.prpmMap = data.prpmMap;

		search($stateParams.page ? $stateParams.page : 1);
	});

	pageTitleService.setTitle("prbt", "page_detail");
}

function PrbtDetailController($http, $location, $routeParams, pageTitleService) {
	var vm = this;

	vm.cancel = cancel;
	vm.download = download;
	vm.pageChanged = pageChanged;

	initialize();

	function initialize() {
		$http.post("proceso/proceso-detail.action", {
			model : {
				id : $routeParams.prbtId
			}
		}).success(function(data) {
			vm.prbt = data.model;
			vm.arinEntradaList = data.arinEntradaList;
			vm.arinSalidaList = data.arinSalidaList;
			vm.pritEntradaList = data.pritEntradaList;
			vm.pritSalidaList = data.pritSalidaList;
			vm.prpmMap = data.prpmMap;

			search($routeParams.page ? $routeParams.page : 1);
		});

		pageTitleService.setTitle("prbt", "page_detail");
	}

	function cancel() {
		$http.post("proceso/proceso-cancelar.action", {
			model : vm.prbt
		}).success(function(data) {
			window.history.back();
		});
	}

	function download(archId, archNombre) {
		$http.post('proceso/proceso-archivo-zip-export.action', {
			model : {
				prbtId : vm.prbt.id,
				archId : archId
			}
		}, {
			responseType : 'arraybuffer'
		}).success(function(data) {
			var file = new Blob([ data ]);

			setTimeout(function() {
				saveAs(file, archNombre);
			}, 0);
		});
	}

	function pageChanged() {
		search(vm.page);
	}

	function search(page) {
		$http.post("proceso/proceso-mensaje-list.action", {
			model : {
				prbtId : $routeParams.prbtId
			},
			page : page
		}).success(function(data) {
			vm.prmnList = data.resultList;
			vm.page = data.resultList.page;

			$location.search({
				page : vm.page
			}).replace();
		});
	}
}
