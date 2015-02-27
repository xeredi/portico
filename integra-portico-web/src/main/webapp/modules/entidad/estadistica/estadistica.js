angular.module("estadistica", [])

.config(config)

.controller("peprGridController", peprGridController)

.controller("peprDetailController", peprDetailController)

.controller("peprPrepareLoadController", peprPrepareLoadController)

.controller("peprCreateController", peprCreateController)

.controller("cdmsDetailController", cdmsDetailController)

.controller("estdGridController", estdGridController)

.controller("estdDetailController", estdDetailController);

function config($routeProvider) {
	$routeProvider

	.when("/estadistica/pepr/grid", {
		templateUrl : "modules/entidad/estadistica/pepr-grid.html",
		controller : "peprGridController",
		controllerAs : "vm",
		reloadOnSearch : false
	})

	.when("/estadistica/pepr/detail/:peprId", {
		templateUrl : "modules/entidad/estadistica/pepr-detail.html",
		controller : "peprDetailController",
		controllerAs : "vm"
	})

	.when("/estadistica/pepr/prepareLoad", {
		templateUrl : "modules/entidad/estadistica/pepr-prepare-load.html",
		controller : "peprPrepareLoadController",
		controllerAs : "vm"
	})

	.when("/estadistica/pepr/create", {
		templateUrl : "modules/entidad/estadistica/pepr-create.html",
		controller : "peprCreateController",
		controllerAs : "vm"
	})

	.when("/estadistica/cdms/detail/:peprId", {
		templateUrl : "modules/entidad/estadistica/cdms-detail.html",
		controller : "cdmsDetailController",
		controllerAs : "vm"
	})

	.when("/estadistica/estd/grid/:entiId/:peprId/:autpId", {
		templateUrl : "modules/entidad/estadistica/estd-grid.html",
		controller : "estdGridController",
		controllerAs : "vm",
		reloadOnSearch : false
	})

	.when("/estadistica/estd/detail/:entiId/:itemId", {
		templateUrl : "modules/entidad/estadistica/estd-detail.html",
		controller : "estdDetailController",
		controllerAs : "vm"
	});
}

function peprGridController($http, $location, $routeParams, $modal,
		pageTitleService) {
	var vm = this;

	vm.search = search;
	vm.pageChanged = pageChanged;
	vm.filter = filter;

	vm.peprCriterio = $routeParams.peprCriterio ? angular
			.fromJson($routeParams.peprCriterio) : {};

	function search(page) {
		$http.post("estadistica/pepr-list.action", {
			peprCriterio : vm.peprCriterio,
			page : page,
			limit : vm.peprCriterio.limit
		}).success(function(data) {
			vm.page = data.peprList.page;
			vm.peprList = data.peprList;

			$location.search({
				page : vm.page,
				peprCriterio : JSON.stringify(vm.peprCriterio)
			}).replace();
		});
	}

	function pageChanged() {
		search(vm.page);
	}

	function filter(size) {
		$http.post("estadistica/pepr-filter.action").success(function(data) {
			vm.autpList = data.autpList;
			vm.limits = data.limits;
		});
	}

	search($routeParams.page ? $routeParams.page : 1);

	pageTitleService.setTitle("pepr", "page_grid");
}

function peprDetailController($http, $routeParams, pageTitleService) {
	var vm = this;

	vm.remove = remove;
	vm.oppeExport = oppeExport;

	function oppeExport() {
		$http.post('estadistica/pepr-export.action', {
			pepr : vm.pepr
		}, {
			responseType : 'arraybuffer'
		}).success(function(data) {
			var file = new Blob([ data ], {
				type : 'application/zip'
			});

			setTimeout(function() {
				saveAs(file, vm.pepr.filename + '.zip');
			}, 0);
		});
	}

	function remove() {
		if (confirm("Are you sure?")) {
			$http.post("estadistica/pepr-remove.action", {
				pepr : {
					id : vm.pepr.id
				}
			}).success(function(data) {
				window.history.back();
			});
		}
	}

	$http.post("estadistica/pepr-detail.action", {
		pepr : {
			id : $routeParams.peprId
		}
	}).success(function(data) {
		vm.pepr = data.pepr;
		vm.tpesList = data.tpesList;
	});

	pageTitleService.setTitle("pepr", "page_detail");
}

function peprPrepareLoadController($http, $location, $upload, pageTitleService) {
	var vm = this;

	vm.load = load;
	vm.cancel = cancel;

	function load() {
		$http.post("estadistica/pepr-cargar.action", {
			pepr : vm.pepr,
			file : vm.file,
			sobreescribir : vm.sobreescribir
		}).success(function(data) {
			$location.path("/proceso/prbt/grid").replace();
		});

	}

	function cancel() {
		window.history.back();
	}

	$http.post("estadistica/pepr-preparar-carga.action").success(
			function(data) {
				vm.autpList = data.autpList;
			});

	pageTitleService.setTitle("pepr", "page_pepr_load");
}

function peprCreateController($http, $location, pageTitleService) {
	var vm = this;

	vm.create = create;
	vm.cancel = cancel;

	function create() {
		$http.post("estadistica/pepr-creacion.action", {
			pepr : vm.pepr,
			sobreescribir : vm.sobreescribir
		}).success(function(data) {
			$location.path("/proceso/prbt/grid").replace();
		});

	}

	function cancel() {
		window.history.back();
	}

	$http.post("estadistica/pepr-preparar-creacion.action").success(
			function(data) {
				vm.autpList = data.autpList;
			});

	pageTitleService.setTitle("pepr", "page_pepr_create");
}

function cdmsDetailController($http, $routeParams, pageTitleService) {
	var vm = this;

	$http.post("estadistica/cdms-detail.action", {
		pepr : {
			id : $routeParams.peprId
		}
	}).success(function(data) {
		vm.pepr = data.pepr;
		vm.cdmsMap = data.cdmsMap;
	});

	pageTitleService.setTitle("cdms", "page_detail");
}

function estdGridController($http, $location, $routeParams, $modal,
		pageTitleService) {
	var vm = this;

	vm.search = search;
	vm.pageChanged = pageChanged;
	vm.filter = filter;
	vm.xlsExport = xlsExport;

	vm.itemCriterio = $routeParams.itemCriterio ? angular
			.fromJson($routeParams.itemCriterio) : {};
	vm.itemCriterio.entiId = $routeParams.entiId;
	vm.itemCriterio.pepr = {};
	vm.itemCriterio.pepr.id = $routeParams.peprId;
	vm.itemCriterio.pepr.autpId = $routeParams.autpId;

	function search(page) {
		$http.post("estadistica/estd-list.action", {
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
		$http.post('estadistica/estd-xls-export.action', {
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
		$http.post("estadistica/estd-filter.action", {
			itemCriterio : vm.itemCriterio
		}).success(function(data) {
			vm.labelValuesMap = data.labelValuesMap;
			vm.subpList = data.subpList;
			vm.limits = data.limits;
			vm.fechaVigencia = data.fechaVigencia;
		});
	}

	search($routeParams.page ? $routeParams.page : 1);

	pageTitleService.setTitleEnti($routeParams.entiId, "page_grid");
}

function estdDetailController($http, $routeParams, pageTitleService) {
	var vm = this;

	$http.post("estadistica/estd-detail.action", {
		item : {
			id : $routeParams.itemId
		}
	}).success(function(data) {
		vm.enti = data.enti;
		vm.item = data.item;
		vm.fechaVigencia = data.fechaVigencia;
	});

	pageTitleService.setTitleEnti($routeParams.entiId, "page_detail");
}