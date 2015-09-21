angular.module("item_service", [ "crud_service" ])

.factory("ItemTramiteService", ItemTramiteService)

;

function ItemTramiteService($http, $q, CrudService) {
	return CrudService.create("item/item-tramite");
}
