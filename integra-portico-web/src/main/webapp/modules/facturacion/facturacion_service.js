(function() {
    'use strict';

    angular.module("facturacion_service", [ "crud_service" ])

    .factory("FacturacionService", FacturacionService)

    .factory("CargoService", CargoService)

    .factory("ReglaService", ReglaService)

    .factory("ReglaIncompatibleService", ReglaIncompatibleService)

    .factory("AspectoService", AspectoService)

    .factory("AspectoCargoService", AspectoCargoService)

    .factory("FacturaSerieService", FacturaSerieService)

    .factory("ValoracionService", ValoracionService)

    .factory("ValoracionLineaService", ValoracionLineaService)

    .factory("ValoracionDetalleService", ValoracionDetalleService)

    .factory("FacturaService", FacturaService)

    .factory("FacturaAnulacionService", FacturaAnulacionService)

    .factory("FacturaRectificacionService", FacturaRectificacionService)

    .factory("ValoradorService", ValoradorService)

    .factory("FacturadorService", FacturadorService)

    ;

    /* @ngInject */
    function FacturacionService($http, $q, CrudService) {
        return CrudService.create("facturacion/facturacion");
    }

    /* @ngInject */
    function CargoService($http, $q, CrudService) {
        return CrudService.create("facturacion/cargo");
    }

    /* @ngInject */
    function ReglaService($http, $q, CrudService) {
        return CrudService.create("facturacion/regla");
    }

    /* @ngInject */
    function ReglaIncompatibleService($http, $q, CrudService) {
        return CrudService.create("facturacion/regla-incompatible");
    }

    /* @ngInject */
    function AspectoService($http, $q, CrudService) {
        return CrudService.create("facturacion/aspecto");
    }

    /* @ngInject */
    function AspectoCargoService($http, $q, CrudService) {
        return CrudService.create("facturacion/aspecto-cargo");
    }

    /* @ngInject */
    function FacturaSerieService($http, $q, CrudService) {
        return CrudService.create("facturacion/factura-serie");
    }

    /* @ngInject */
    function ValoracionService($http, $q, CrudService) {
        return CrudService.create("facturacion/valoracion");
    }

    /* @ngInject */
    function ValoracionLineaService($http, $q, CrudService) {
        return CrudService.create("facturacion/valoracion-linea");
    }

    /* @ngInject */
    function ValoracionDetalleService($http, $q, CrudService) {
        return CrudService.create("facturacion/valoracion-detalle");
    }

    /* @ngInject */
    function FacturaService($http, $q, CrudService) {
        return CrudService.create("facturacion/factura");
    }

    /* @ngInject */
    function FacturaAnulacionService($http, $q, CrudService) {
        return CrudService.create("facturacion/factura-anulacion");
    }

    /* @ngInject */
    function FacturaRectificacionService($http, $q, CrudService) {
        return CrudService.create("facturacion/factura-rectificacion");
    }

    /* @ngInject */
    function ValoradorService($http, $q, CrudService) {
        return CrudService.create("facturacion/valorador");
    }

    /* @ngInject */
    function FacturadorService($http, $q, CrudService) {
        return CrudService.create("facturacion/facturador");
    }
})();