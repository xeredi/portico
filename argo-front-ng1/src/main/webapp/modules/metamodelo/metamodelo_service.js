(function() {
    'use strict';

    angular.module("metamodelo_service", [ "crud_service" ])

    .factory("TipoDatoService", TipoDatoService)

    .factory("CodigoReferenciaService", CodigoReferenciaService)

    .factory("AccionEntidadService", AccionEntidadService)

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

    .factory("AccionBaseService", AccionBaseService)

    .factory("AccionEspecialService", AccionEspecialService)

    .factory("ModuloService", ModuloService)

    ;

    /* @ngInject */
    function TipoDatoService($http, $q, CrudService) {
        return CrudService.create("metamodelo/tipo-dato", "tpdt");
    }

    /* @ngInject */
    function CodigoReferenciaService($http, $q, CrudService) {
        return CrudService.create("metamodelo/codigo-referencia", "cdrf");
    }

    /* @ngInject */
    function AccionEntidadService($http, $q, CrudService) {
        return CrudService.create("metamodelo/accion-entidad", "acen");
    }

    /* @ngInject */
    function EntidadEntidadService($http, $q, CrudService) {
        return CrudService.create("metamodelo/entidad-entidad", "enen");
    }

    /* @ngInject */
    function EntidadGrupoDatoService($http, $q, CrudService) {
        return CrudService.create("metamodelo/entidad-grupo-dato", "engd");
    }

    /* @ngInject */
    function EntidadTipoDatoService($http, $q, CrudService) {
        return CrudService.create("metamodelo/entidad-tipo-dato", "entd");
    }

    /* @ngInject */
    function TramiteService($http, $q, CrudService) {
        return CrudService.create("metamodelo/tramite", "trmt");
    }

    /* @ngInject */
    function TramiteTipoDatoService($http, $q, CrudService) {
        return CrudService.create("metamodelo/tramite-tipo-dato", "trtd");
    }

    /* @ngInject */
    function TipoParametroService($http, $q, CrudService) {
        return CrudService.create("metamodelo/tipo-parametro", "tppr");
    }

    /* @ngInject */
    function TipoSubparametroService($http, $q, CrudService) {
        return CrudService.create("metamodelo/tipo-subparametro", "tpsp");
    }

    /* @ngInject */
    function TipoServicioService($http, $q, CrudService) {
        return CrudService.create("metamodelo/tipo-servicio", "tpsr");
    }

    /* @ngInject */
    function TipoSubservicioService($http, $q, CrudService) {
        return CrudService.create("metamodelo/tipo-subservicio", "tpss");
    }

    /* @ngInject */
    function TipoEstadisticaService($http, $q, CrudService) {
        return CrudService.create("metamodelo/tipo-estadistica", "tpes");
    }

    /* @ngInject */
    function CampoAgregacionService($http, $q, CrudService) {
        return CrudService.create("metamodelo/campo-agregacion", "cmag");
    }

    /* @ngInject */
    function AccionBaseService($http, $q, CrudService) {
        return CrudService.create("metamodelo/accion-base", "acbs");
    }

    /* @ngInject */
    function AccionEspecialService($http, $q, CrudService) {
        return CrudService.create("metamodelo/accion-especial", "aces");
    }

    /* @ngInject */
    function ModuloService($http, $q, CrudService) {
        return CrudService.create("metamodelo/modulo", "mdlo");
    }
})();