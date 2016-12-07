(function() {
	'use strict';

	angular.module("argo.servicio.suministrored.service",
			[ "argo.common.crud.service" ])

	.factory("SuministroRedService", SuministroRedService)

	;

	/* @ngInject */
	function SuministroRedService($http, $q, CrudService) {
		return CrudService.create("servicio/suministrored/generar", "aces");
	}
})();
