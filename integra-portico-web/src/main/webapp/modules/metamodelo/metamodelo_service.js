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

    TipoDatoService.$inject = [ '$http', '$q', 'CrudService' ];

    function TipoDatoService($http, $q, CrudService) {
        return CrudService.create("metamodelo/tipo-dato");
    }

    CodigoReferenciaService.$inject = [ '$http', '$q', 'CrudService' ];

    function CodigoReferenciaService($http, $q, CrudService) {
        return CrudService.create("metamodelo/codigo-referencia");
    }

    AccionEntidadService.$inject = [ '$http', '$q', 'CrudService' ];

    function AccionEntidadService($http, $q, CrudService) {
        return CrudService.create("metamodelo/accion-entidad");
    }

    EntidadAccionService.$inject = [ '$http', '$q', 'CrudService' ];

    function EntidadAccionService($http, $q, CrudService) {
        return CrudService.create("metamodelo/entidad-accion");
    }

    EntidadAccionGridService.$inject = [ '$http', '$q', 'CrudService' ];

    function EntidadAccionGridService($http, $q, CrudService) {
        return CrudService.create("metamodelo/entidad-accion-grid");
    }

    EntidadEntidadService.$inject = [ '$http', '$q', 'CrudService' ];

    function EntidadEntidadService($http, $q, CrudService) {
        return CrudService.create("metamodelo/entidad-entidad");
    }

    EntidadGrupoDatoService.$inject = [ '$http', '$q', 'CrudService' ];

    function EntidadGrupoDatoService($http, $q, CrudService) {
        return CrudService.create("metamodelo/entidad-grupo-dato");
    }

    EntidadTipoDatoService.$inject = [ '$http', '$q', 'CrudService' ];

    function EntidadTipoDatoService($http, $q, CrudService) {
        return CrudService.create("metamodelo/entidad-tipo-dato");
    }

    TramiteService.$inject = [ '$http', '$q', 'CrudService' ];

    function TramiteService($http, $q, CrudService) {
        return CrudService.create("metamodelo/tramite");
    }

    AccionTramiteService.$inject = [ '$http', '$q', 'CrudService' ];

    function AccionTramiteService($http, $q, CrudService) {
        return CrudService.create("metamodelo/accion-tramite");
    }

    TramiteTipoDatoService.$inject = [ '$http', '$q', 'CrudService' ];

    function TramiteTipoDatoService($http, $q, CrudService) {
        return CrudService.create("metamodelo/tramite-tipo-dato");
    }

    TipoParametroService.$inject = [ '$http', '$q', 'CrudService' ];

    function TipoParametroService($http, $q, CrudService) {
        return CrudService.create("metamodelo/tipo-parametro");
    }

    TipoSubparametroService.$inject = [ '$http', '$q', 'CrudService' ];

    function TipoSubparametroService($http, $q, CrudService) {
        return CrudService.create("metamodelo/tipo-subparametro");
    }

    TipoServicioService.$inject = [ '$http', '$q', 'CrudService' ];

    function TipoServicioService($http, $q, CrudService) {
        return CrudService.create("metamodelo/tipo-servicio");
    }

    TipoSubservicioService.$inject = [ '$http', '$q', 'CrudService' ];

    function TipoSubservicioService($http, $q, CrudService) {
        return CrudService.create("metamodelo/tipo-subservicio");
    }

    TipoEstadisticaService.$inject = [ '$http', '$q', 'CrudService' ];

    function TipoEstadisticaService($http, $q, CrudService) {
        return CrudService.create("metamodelo/tipo-estadistica");
    }

    CampoAgregacionService.$inject = [ '$http', '$q', 'CrudService' ];

    function CampoAgregacionService($http, $q, CrudService) {
        return CrudService.create("metamodelo/campo-agregacion");
    }
})();