angular.module("item_controller", [])

.config(config)

.controller("ItemTramiteDetailController", ItemTramiteDetailController)

.controller("ItemTramiteEditController", ItemTramiteEditController)

;

function config($stateProvider) {
	$stateProvider

	.state("item-tramite-detail", {
		url : "/item/item-tramite/detail/:id",
		templateUrl : "modules/entidad/item/item-tramite-detail.html",
		controller : "ItemTramiteDetailController as vm",
	})

	.state("item-tramite-create", {
		url : "/item/item-tramite/create/:itemId/:trmtId",
		templateUrl : "modules/entidad/item/item-tramite-edit.html",
		controller : "ItemTramiteEditController as vm",
		data : {
			accion : 'create'
		}
	})

	;
}

function ItemTramiteDetailController($stateParams, pageTitleService,
		ItemTramiteService) {
	var vm = this;

	vm.remove = remove;

	function remove() {
		ItemTramiteService.remove(vm.model).then(function(data) {
			window.history.back();
		});
	}

	vm.model = {
		id : $stateParams.id
	};

	ItemTramiteService.detail(vm.model).then(function(data) {
		vm.model = data.model;
		vm.item = data.item;
		vm.enti = data.enti;
		vm.trmt = data.trmt;
		vm.temporal = data.temporal;
		vm.tpdtEstadoId = data.tpdtEstadoId;
	});

	pageTitleService.setTitle("trmt", "page_detail");
}

function ItemTramiteEditController($state, $stateParams, pageTitleService,
		ItemTramiteService) {
	var vm = this;

	vm.save = save;
	vm.cancel = cancel;

	function save() {
		ItemTramiteService.save(vm.accion, vm.model).then(
				function(data) {
					ItemTramiteService.redirectAfterSave(vm.accion, data.model,
							"item-tramite-detail");
				});
	}

	function cancel() {
		window.history.back();
	}

	vm.accion = $state.current.data.accion;
	vm.model = {
		itemId : $stateParams.itemId,
		trmt : {
			id : $stateParams.trmtId
		}
	}

	ItemTramiteService.edit(vm.accion, vm.model).then(function(data) {
		vm.model = data.model;
		vm.item = data.item;
		vm.enti = data.enti;
		vm.trmt = data.trmt;
		vm.prtoId = data.prtoId;
		vm.fechaVigencia = data.fechaVigencia;

		vm.labelValuesMap = data.labelValuesMap;
	});

	pageTitleService.setTitle("trmt", "page_" + vm.accion);
}
