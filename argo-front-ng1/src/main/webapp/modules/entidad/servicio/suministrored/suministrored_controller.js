(function() {
	'use strict';

	angular.module("argo.servicio.suministrored.controller",
			[ "argo.servicio.suministrored.service" ])

	.config(suministrored_config)

	.controller("SuministroRedEditController", SuministroRedEditController)

	;

	/* @ngInject */
	function suministrored_config($routeProvider) {
		$routeProvider

				.when(
						"/servicio/suministrored/generar-edit",
						{
							templateUrl : "modules/entidad/servicio/suministrored/generar-edit.html",
							controller : "SuministroRedEditController as vm"
						})

		;
	}

	/* @ngInject */
	function SuministroRedEditController($routeParams, pageTitleService,
			SuministroRedService) {
		var vm = this;

		vm.save = save;
		vm.cancel = cancel;

		function save() {
			SuministroRedService.save("create", vm.model).then(
					function(data) {
						SuministroRedService.redirectAfterSave("create",
								'/proceso/proceso/grid');
					});
		}

		function cancel() {
			window.history.back();
		}

		SuministroRedService.edit("create", {}).then(function(data) {
			vm.model = data.model;
		});

		pageTitleService.setTitle("sred", "page_edit");
	}
})();