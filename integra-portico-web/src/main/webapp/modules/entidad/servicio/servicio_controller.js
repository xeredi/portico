angular.module("servicio_controller", [])

.config(config)

.controller("ServicioSecuenciaGridController", ServicioSecuenciaGridController)

.controller("ServicioSecuenciaDetailController",
		ServicioSecuenciaDetailController)

.controller("ServicioSecuenciaEditController", ServicioSecuenciaEditController)

;

function config($stateProvider) {
	$stateProvider

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

	;
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
