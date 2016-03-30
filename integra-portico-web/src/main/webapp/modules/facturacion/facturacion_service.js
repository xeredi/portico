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

    FacturacionService.$inject = [ '$http', '$q', 'CrudService' ];

    function FacturacionService($http, $q, CrudService) {
        return CrudService.create("facturacion/facturacion");
    }

    CargoService.$inject = [ '$http', '$q', 'CrudService' ];

    function CargoService($http, $q, CrudService) {
        return CrudService.create("facturacion/cargo");
    }

    ReglaService.$inject = [ '$http', '$q', 'CrudService' ];

    function ReglaService($http, $q, CrudService) {
        return CrudService.create("facturacion/regla");
    }

    ReglaIncompatibleService.$inject = [ '$http', '$q', 'CrudService' ];

    function ReglaIncompatibleService($http, $q, CrudService) {
        return CrudService.create("facturacion/regla-incompatible");
    }

    AspectoService.$inject = [ '$http', '$q', 'CrudService' ];

    function AspectoService($http, $q, CrudService) {
        return CrudService.create("facturacion/aspecto");
    }

    AspectoCargoService.$inject = [ '$http', '$q', 'CrudService' ];

    function AspectoCargoService($http, $q, CrudService) {
        return CrudService.create("facturacion/aspecto-cargo");
    }

    FacturaSerieService.$inject = [ '$http', '$q', 'CrudService' ];

    function FacturaSerieService($http, $q, CrudService) {
        return CrudService.create("facturacion/factura-serie");
    }

    ValoracionService.$inject = [ '$http', '$q', 'CrudService' ];

    function ValoracionService($http, $q, CrudService) {
        return CrudService.create("facturacion/valoracion");
    }

    ValoracionLineaService.$inject = [ '$http', '$q', 'CrudService' ];

    function ValoracionLineaService($http, $q, CrudService) {
        return CrudService.create("facturacion/valoracion-linea");
    }

    ValoracionDetalleService.$inject = [ '$http', '$q', 'CrudService' ];

    function ValoracionDetalleService($http, $q, CrudService) {
        return CrudService.create("facturacion/valoracion-detalle");
    }

    FacturaService.$inject = [ '$http', '$q', 'CrudService' ];

    function FacturaService($http, $q, CrudService) {
        return CrudService.create("facturacion/factura");
    }

    FacturaAnulacionService.$inject = [ '$http', '$q', 'CrudService' ];

    function FacturaAnulacionService($http, $q, CrudService) {
        return CrudService.create("facturacion/factura-anulacion");
    }

    FacturaRectificacionService.$inject = [ '$http', '$q', 'CrudService' ];

    function FacturaRectificacionService($http, $q, CrudService) {
        return CrudService.create("facturacion/factura-rectificacion");
    }

    ValoradorService.$inject = [ '$http', '$q', 'CrudService' ];

    function ValoradorService($http, $q, CrudService) {
        return CrudService.create("facturacion/valorador");
    }

    FacturadorService.$inject = [ '$http', '$q', 'CrudService' ];

    function FacturadorService($http, $q, CrudService) {
        return CrudService.create("facturacion/facturador");
    }
})();