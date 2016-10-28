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

    /* @ngInject */
    function AccionBaseService($http, $q, CrudService) {
        return CrudService.create("metamodelo/accion-base");
    }

    /* @ngInject */
    function AccionEspecialService($http, $q, CrudService) {
        return CrudService.create("metamodelo/accion-especial");
    }
})();