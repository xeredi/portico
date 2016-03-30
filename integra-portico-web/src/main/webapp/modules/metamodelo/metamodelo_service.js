(function() {
    'use strict';

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

    .factory("AccionTramiteService", AccionTramiteService)

    .factory("TramiteTipoDatoService", TramiteTipoDatoService)

    .factory("TipoParametroService", TipoParametroService)

    .factory("TipoSubparametroService", TipoSubparametroService)

    .factory("TipoServicioService", TipoServicioService)

    .factory("TipoSubservicioService", TipoSubservicioService)

    .factory("TipoEstadisticaService", TipoEstadisticaService)

    .factory("CampoAgregacionService", CampoAgregacionService)

    ;

    /* @ngInject */
    function TipoDatoService($http, $q, CrudService) {
        return CrudService.create("metamodelo/tipo-dato");
    }

    /* @ngInject */
    function CodigoReferenciaService($http, $q, CrudService) {
        return CrudService.create("metamodelo/codigo-referencia");
    }

    /* @ngInject */
    function AccionEntidadService($http, $q, CrudService) {
        return CrudService.create("metamodelo/accion-entidad");
    }

    /* @ngInject */
    function EntidadAccionService($http, $q, CrudService) {
        return CrudService.create("metamodelo/entidad-accion");
    }

    /* @ngInject */
    function EntidadAccionGridService($http, $q, CrudService) {
        return CrudService.create("metamodelo/entidad-accion-grid");
    }

    /* @ngInject */
    function EntidadEntidadService($http, $q, CrudService) {
        return CrudService.create("metamodelo/entidad-entidad");
    }

    /* @ngInject */
    function EntidadGrupoDatoService($http, $q, CrudService) {
        return CrudService.create("metamodelo/entidad-grupo-dato");
    }

    /* @ngInject */
    function EntidadTipoDatoService($http, $q, CrudService) {
        return CrudService.create("metamodelo/entidad-tipo-dato");
    }

    /* @ngInject */
    function TramiteService($http, $q, CrudService) {
        return CrudService.create("metamodelo/tramite");
    }

    /* @ngInject */
    function AccionTramiteService($http, $q, CrudService) {
        return CrudService.create("metamodelo/accion-tramite");
    }

    /* @ngInject */
    function TramiteTipoDatoService($http, $q, CrudService) {
        return CrudService.create("metamodelo/tramite-tipo-dato");
    }

    /* @ngInject */
    function TipoParametroService($http, $q, CrudService) {
        return CrudService.create("metamodelo/tipo-parametro");
    }

    /* @ngInject */
    function TipoSubparametroService($http, $q, CrudService) {
        return CrudService.create("metamodelo/tipo-subparametro");
    }

    /* @ngInject */
    function TipoServicioService($http, $q, CrudService) {
        return CrudService.create("metamodelo/tipo-servicio");
    }

    /* @ngInject */
    function TipoSubservicioService($http, $q, CrudService) {
        return CrudService.create("metamodelo/tipo-subservicio");
    }

    /* @ngInject */
    function TipoEstadisticaService($http, $q, CrudService) {
        return CrudService.create("metamodelo/tipo-estadistica");
    }

    /* @ngInject */
    function CampoAgregacionService($http, $q, CrudService) {
        return CrudService.create("metamodelo/campo-agregacion");
    }
})();