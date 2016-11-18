(function() {
    'use strict';

    angular.module("argo.item.service", [ "argo.common.crud.service" ])

    .factory("ItemTramiteService", ItemTramiteService)

    ;

    /* @ngInject */
    function ItemTramiteService($http, $q, CrudService) {
        return CrudService.create("item/item-tramite", "ittr");
    }
})();