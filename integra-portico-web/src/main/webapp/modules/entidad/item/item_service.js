(function() {
    'use strict';

    angular.module("item_service", [ "crud_service" ])

    .factory("ItemTramiteService", ItemTramiteService)

    ;

    ItemTramiteService.$inject = [ '$http', '$q', 'CrudService' ];

    function ItemTramiteService($http, $q, CrudService) {
        return CrudService.create("item/item-tramite");
    }
})();