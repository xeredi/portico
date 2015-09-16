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

.factory("FacturaLineaService", FacturaLineaService)

.factory("FacturaDetalleService", FacturaDetalleService)

.factory("ValoradorService", ValoradorService)

.factory("FacturadorService", FacturadorService)

;

function FacturacionService($http, $q, CrudService) {
    return CrudService.create("facturacion/facturacion");
}

function CargoService($http, $q, CrudService) {
    return CrudService.create("facturacion/cargo");
}

function ReglaService($http, $q, CrudService) {
    return CrudService.create("facturacion/regla");
}

function ReglaIncompatibleService($http, $q, CrudService) {
    return CrudService.create("facturacion/regla-incompatible");
}

function AspectoService($http, $q, CrudService) {
    return CrudService.create("facturacion/aspecto");
}

function AspectoCargoService($http, $q, CrudService) {
    return CrudService.create("facturacion/aspecto-cargo");
}

function FacturaSerieService($http, $q, CrudService) {
    return CrudService.create("facturacion/factura-serie");
}

function ValoracionService($http, $q, CrudService) {
    return CrudService.create("facturacion/valoracion");
}

function ValoracionLineaService($http, $q, CrudService) {
    return CrudService.create("facturacion/valoracion-linea");
}

function ValoracionDetalleService($http, $q, CrudService) {
    return CrudService.create("facturacion/valoracion-detalle");
}

function FacturaService($http, $q, CrudService) {
    return CrudService.create("facturacion/factura");
}

function FacturaLineaService($http, $q, CrudService) {
    return CrudService.create("facturacion/factura-linea");
}

function FacturaDetalleService($http, $q, CrudService) {
    return CrudService.create("facturacion/factura-detalle");
}

function ValoradorService($http, $q, CrudService) {
    return CrudService.create("facturacion/valorador");
}

function FacturadorService($http, $q, CrudService) {
    return CrudService.create("facturacion/facturador");
}
