angular.module("metamodelo_service", [ "crud_service" ])

.factory("TipoDatoService", TipoDatoService)

.factory("CodigoReferenciaService", CodigoReferenciaService)

.factory("AccionEntidadService", AccionEntidadService)

.factory("EntidadAccionService", EntidadAccionService)

.factory("EntidadAccionGridService", EntidadAccionGridService)

.factory("EntidadEntidadService", EntidadEntidadService)

.factory("EntidadGrupoDatoService", EntidadGrupoDatoService)

.factory("EntidadTipoDatoService", EntidadTipoDatoService)

.factory("TramiteService", TramiteService)

.factory("TramiteTipoDatoService", TramiteTipoDatoService)

.factory("TipoParametroService", TipoParametroService)

.factory("TipoSubparametroService", TipoSubparametroService)

.factory("TipoServicioService", TipoServicioService)

.factory("TipoSubservicioService", TipoSubservicioService)

.factory("TipoEstadisticaService", TipoEstadisticaService)

.factory("CampoAgregacionService", CampoAgregacionService)

;

function TipoDatoService($http, $q, CrudService) {
    return CrudService.create("metamodelo/tipo-dato");
}

function CodigoReferenciaService($http, $q, CrudService) {
    return CrudService.create("metamodelo/codigo-referencia");
}

function AccionEntidadService($http, $q, CrudService) {
    return CrudService.create("metamodelo/accion-entidad");
}

function EntidadAccionService($http, $q, CrudService) {
    return CrudService.create("metamodelo/entidad-accion");
}

function EntidadAccionGridService($http, $q, CrudService) {
    return CrudService.create("metamodelo/entidad-accion-grid");
}

function EntidadEntidadService($http, $q, CrudService) {
    return CrudService.create("metamodelo/entidad-entidad");
}

function EntidadGrupoDatoService($http, $q, CrudService) {
    return CrudService.create("metamodelo/entidad-grupo-dato");
}

function EntidadTipoDatoService($http, $q, CrudService) {
    return CrudService.create("metamodelo/entidad-tipo-dato");
}

function TramiteService($http, $q, CrudService) {
    return CrudService.create("metamodelo/tramite");
}

function TramiteTipoDatoService($http, $q, CrudService) {
    return CrudService.create("metamodelo/tramite-tipo-dato");
}

function TipoParametroService($http, $q, CrudService) {
    return CrudService.create("metamodelo/tipo-parametro");
}

function TipoSubparametroService($http, $q, CrudService) {
    return CrudService.create("metamodelo/tipo-subparametro");
}

function TipoServicioService($http, $q, CrudService) {
    return CrudService.create("metamodelo/tipo-servicio");
}

function TipoSubservicioService($http, $q, CrudService) {
    return CrudService.create("metamodelo/tipo-subservicio");
}

function TipoEstadisticaService($http, $q, CrudService) {
    return CrudService.create("metamodelo/tipo-estadistica");
}

function CampoAgregacionService($http, $q, CrudService) {
    return CrudService.create("metamodelo/campo-agregacion");
}
