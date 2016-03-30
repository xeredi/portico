(function() {
    'use strict';

    angular.module("item_service", [ "crud_service" ])

    .factory("ItemTramiteService", ItemTramiteService)

    ;

    /* @ngInject */
    function ItemTramiteService($http, $q, CrudService) {
        return CrudService.create("item/item-tramite");
    }
})();