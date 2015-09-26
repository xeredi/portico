angular.module("seguridad_controller", [ "seguridad_service" ])

.config(config)

.controller("AccionGridController", AccionGridController)

.controller("AccionDetailController", AccionDetailController)

.controller("AccionEditController", AccionEditController)

.controller("GrupoGridController", GrupoGridController)

.controller("GrupoDetailController", GrupoDetailController)

.controller("GrupoEditController", GrupoEditController)

.controller("UsuarioGridController", UsuarioGridController)

.controller("UsuarioDetailController", UsuarioDetailController)

.controller("UsuarioEditController", UsuarioEditController)

.controller("UsuarioAccesoController", UsuarioAccesoController)

.controller("UsuarioSalirController", UsuarioSalirController)

;

function config($stateProvider) {
	$stateProvider

	.state("accion-grid", {
		url : "/seguridad/accion/grid?page&searchCriteria&limit",
		templateUrl : "modules/seguridad/accion-grid.html",
		controller : "AccionGridController as vm",
		reloadOnSearch : false
	})

	.state("accion-detail", {
		url : "/seguridad/accion/detail/:id",
		templateUrl : "modules/seguridad/accion-detail.html",
		controller : "AccionDetailController as vm",
	})

	.state("accion-create", {
		url : "/seguridad/accion/create",
		templateUrl : "modules/seguridad/accion-edit.html",
		controller : "AccionEditController as vm",
		data : {
			accion : 'create'
		}
	})

	.state("accion-edit", {
		url : "/seguridad/accion/edit/:id",
		templateUrl : "modules/seguridad/accion-edit.html",
		controller : "AccionEditController as vm",
		data : {
			accion : 'edit'
		}
	})

	.state("grupo-grid", {
		url : "/seguridad/grupo/grid?page&searchCriteria&limit",
		templateUrl : "modules/seguridad/grupo-grid.html",
		controller : "GrupoGridController as vm",
		reloadOnSearch : false
	})

	.state("grupo-detail", {
		url : "/seguridad/grupo/detail/:id",
		templateUrl : "modules/seguridad/grupo-detail.html",
		controller : "GrupoDetailController as vm",
	})

	.state("grupo-create", {
		url : "/seguridad/grupo/create",
		templateUrl : "modules/seguridad/grupo-edit.html",
		controller : "GrupoEditController as vm",
		data : {
			accion : 'create'
		}
	})

	.state("grupo-edit", {
		url : "/seguridad/grupo/edit/:id",
		templateUrl : "modules/seguridad/grupo-edit.html",
		controller : "GrupoEditController as vm",
		data : {
			accion : 'edit'
		}
	})

	.state("usuario-grid", {
		url : "/seguridad/usuario/grid?page&searchCriteria&limit",
		templateUrl : "modules/seguridad/usuario-grid.html",
		controller : "UsuarioGridController as vm",
		reloadOnSearch : false
	})

	.state("usuario-detail", {
		url : "/seguridad/usuario/detail/:id",
		templateUrl : "modules/seguridad/usuario-detail.html",
		controller : "UsuarioDetailController as vm",
	})

	.state("usuario-create", {
		url : "/seguridad/usuario/create",
		templateUrl : "modules/seguridad/usuario-edit.html",
		controller : "UsuarioEditController as vm",
		data : {
			accion : 'create'
		}
	})

	.state("usuario-edit", {
		url : "/seguridad/usuario/edit/:id",
		templateUrl : "modules/seguridad/usuario-edit.html",
		controller : "UsuarioEditController as vm",
		data : {
			accion : 'edit'
		}
	})

	.state("usuario-acceso", {
		url : "/seguridad/usuario/acceso",
		templateUrl : "modules/seguridad/usuario-acceso.html",
		controller : "UsuarioAccesoController as vm",
	})

	.state("usuario-salir", {
		url : "/seguridad/usuario/salir",
		controller : "UsuarioSalirController as vm",
	})

	;
}

function AccionGridController($state, $stateParams, $modal, pageTitleService,
		AccionService) {
	var vm = this;

	vm.filter = filter;
	vm.resetFilter = resetFilter;
	vm.search = search;
	vm.pageChanged = pageChanged;

	function filter() {
		AccionService.filter(vm.searchCriteria).then(function(data) {
			vm.prefixList = data.prefixList;
			vm.grpoList = data.grpoList;
		});
	}

	function resetFilter() {
		vm.searchCriteria = {};
	}

	function search(page) {
		AccionService.listPage(vm.searchCriteria, page, vm.limit).then(
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

	pageTitleService.setTitle("accn", "page_grid");
}

function AccionDetailController($stateParams, pageTitleService, AccionService) {
	var vm = this;

	vm.remove = remove;

	function remove() {
		AccionService.remove(vm.model).then(function(data) {
			window.history.back();
		});
	}

	vm.model = {
		id : $stateParams.id
	};

	AccionService.detail(vm.model).then(function(data) {
		vm.model = data.model;

		vm.grpoList = data.grpoList;
	});

	pageTitleService.setTitle("accn", "page_detail");
}

function AccionEditController($state, $stateParams, pageTitleService,
		AccionService) {
	var vm = this;

	vm.save = save;
	vm.cancel = cancel;
	vm.updateGrupos = updateGrupos;

	function save() {
		AccionService.save(vm.accion, vm.model).then(
				function(data) {
					AccionService.redirectAfterSave(vm.accion, data.model,
							"accion-detail");
				});
	}

	function cancel() {
		window.history.back();
	}

	function updateGrupos($event, grpoId) {
		$event.target.checked ? vm.model.grpoIds.push(grpoId)
				: vm.model.grpoIds.splice(vm.model.grpoIds.indexOf(grpoId), 1);
	}

	vm.accion = $state.current.data.accion;
	vm.model = {
		id : $stateParams.id
	}

	AccionService.edit(vm.accion, vm.model).then(function(data) {
		vm.model = data.model;

		vm.prefixList = data.prefixList;
		vm.grpoList = data.grpoList;
	});

	pageTitleService.setTitle("accn", "page_" + vm.accion);
}

function GrupoGridController($state, $stateParams, $modal, pageTitleService,
		GrupoService) {
	var vm = this;

	vm.filter = filter;
	vm.resetFilter = resetFilter;
	vm.search = search;
	vm.pageChanged = pageChanged;

	function filter() {
		GrupoService.filter(vm.searchCriteria).then(function(data) {
		});
	}

	function resetFilter() {
		vm.searchCriteria = {};
	}

	function search(page) {
		GrupoService.listPage(vm.searchCriteria, page, vm.limit).then(
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

	pageTitleService.setTitle("grpo", "page_grid");
}

function GrupoDetailController($stateParams, pageTitleService, GrupoService) {
	var vm = this;

	vm.remove = remove;

	function remove() {
		GrupoService.remove(vm.model).then(function(data) {
			window.history.back();
		});
	}

	vm.model = {
		id : $stateParams.id
	};

	GrupoService.detail(vm.model).then(function(data) {
		vm.model = data.model;

		vm.prefixList = data.prefixList;
		vm.accnMap = data.accnMap;
		vm.entiList = data.entiList;
		vm.acenMap = data.acenMap;
	});

	pageTitleService.setTitle("grpo", "page_detail");
}

function GrupoEditController($state, $stateParams, pageTitleService,
		GrupoService) {
	var vm = this;

	vm.save = save;
	vm.cancel = cancel;
	vm.updateAcciones = updateAcciones;
	vm.updateAccionesEntidad = updateAccionesEntidad;

	function save() {
		GrupoService.save(vm.accion, vm.model).then(
				function(data) {
					GrupoService.redirectAfterSave(vm.accion, data.model,
							"grupo-detail");
				});
	}

	function cancel() {
		window.history.back();
	}

	function updateAcciones($event, accnId) {
		$event.target.checked ? vm.model.accnIds.push(accnId)
				: vm.model.accnIds.splice(vm.model.accnIds.indexOf(accnId), 1);
	}

	function updateAccionesEntidad($event, acenId) {
		$event.target.checked ? vm.model.acenIds.push(acenId)
				: vm.model.acenIds.splice(vm.model.acenIds.indexOf(acenId), 1);
	}

	vm.accion = $state.current.data.accion;
	vm.model = {
		id : $stateParams.id
	}

	GrupoService.edit(vm.accion, vm.model).then(function(data) {
		vm.model = data.model;

		vm.prefixList = data.prefixList;
		vm.accnMap = data.accnMap;
		vm.entiList = data.entiList;
		vm.acenMap = data.acenMap;
	});

	pageTitleService.setTitle("grpo", "page_" + vm.accion);
}

function UsuarioGridController($state, $stateParams, $modal, pageTitleService,
		UsuarioService) {
	var vm = this;

	vm.filter = filter;
	vm.resetFilter = resetFilter;
	vm.search = search;
	vm.pageChanged = pageChanged;

	function filter() {
		UsuarioService.filter(vm.searchCriteria).then(function(data) {
			vm.sprtList = data.sprtList;
			vm.prtoList = data.prtoList;
		});
	}

	function resetFilter() {
		vm.searchCriteria = {};
	}

	function search(page) {
		UsuarioService.listPage(vm.searchCriteria, page, vm.limit).then(
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

	pageTitleService.setTitle("usro", "page_grid");
}

function UsuarioDetailController($stateParams, pageTitleService, UsuarioService) {
	var vm = this;

	vm.remove = remove;

	function remove() {
		UsuarioService.remove(vm.model).then(function(data) {
			window.history.back();
		});
	}

	vm.model = {
		id : $stateParams.id
	};

	UsuarioService.detail(vm.model).then(function(data) {
		vm.model = data.model;

		vm.grpoList = data.grpoList;
	});

	pageTitleService.setTitle("usro", "page_detail");
}

function UsuarioEditController($state, $stateParams, pageTitleService,
		UsuarioService) {
	var vm = this;

	vm.save = save;
	vm.cancel = cancel;
	vm.updateGrupos = updateGrupos;

	function save() {
		UsuarioService.save(vm.accion, vm.model).then(
				function(data) {
					UsuarioService.redirectAfterSave(vm.accion, data.model,
							"usuario-detail");
				});
	}

	function cancel() {
		window.history.back();
	}

	function updateGrupos($event, grpoId) {
		$event.target.checked ? vm.model.grpoIds.push(grpoId)
				: vm.model.grpoIds.splice(vm.model.grpoIds.indexOf(grpoId), 1);
	}

	vm.accion = $state.current.data.accion;
	vm.model = {
		id : $stateParams.id
	}

	UsuarioService.edit(vm.accion, vm.model).then(function(data) {
		vm.model = data.model;
		vm.grpoList = data.grpoList;

		vm.sprtList = data.sprtList;
		vm.prtoList = data.prtoList;
	});

	pageTitleService.setTitle("usro", "page_" + vm.accion);
}

function UsuarioAccesoController($state, localStorageService, pageTitleService,
		UsuarioService) {
	var vm = this;

	vm.acceso = acceso;

	function acceso() {
		UsuarioService.acceso(vm.model).then(
				function(data) {
					localStorageService.set("accnPaths",
							data.resultadoLogin.accnPaths);

					$state.go("home");
				});
	}

	pageTitleService.setTitle("usro", "page_acceso");
}

function UsuarioSalirController($state, UsuarioService) {
	UsuarioService.salir().then(function(data) {
		$state.go("home");
	});
}
