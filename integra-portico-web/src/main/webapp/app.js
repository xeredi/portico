var app = angular.module('integraApp', [ 'ui.bootstrap', 'ui.router', 'ui.bootstrap.datetimepicker',
        'pascalprecht.translate', 'ngRoute', 'metamodelo', 'facturacion'/*
                                                                         * 'configuracion',
                                                                         * 'maestro',
                                                                         * 'servicio',
                                                                         * 'proceso',
                                                                         *
                                                                         */]);

app.config(function($translateProvider) {
    $translateProvider.translations('es', {
        app_nombre : 'PORTICO',

        errors : 'Errores',
        fmt_true : 'Si',
        fmt_false : 'No',
        fmt_integer : '#,###,###,##0',
        fmt_date : 'dd/MM/yyyy',
        fmt_datetime : 'dd/MM/yyyy HH:mm',

        TipoElemento_BO : "Booleano",
        TipoElemento_CR : "Cod. Referencia",
        TipoElemento_FE : "Fecha",
        TipoElemento_FH : "Fecha/Hora",
        TipoElemento_ND : "N\u00famero Decimal",
        TipoElemento_NE : "N\u00famero Entero",
        TipoElemento_PR : "Maestro",
        TipoElemento_SR : "Servicio",
        TipoElemento_TX : "Texto",

        TipoEntidad_P : "Maestro",
        TipoEntidad_B : "Submaestro",
        TipoEntidad_T : "Tipo de Servicio",
        TipoEntidad_S : "Tipo de Subservicio",
        TipoEntidad_E : "Tipo de Estad\u00edstica",

        TipoHtml_T : "Textfield",
        TipoHtml_S : "Select",
        TipoHtml_CB : "Checkbox",
        TipoHtml_D : "Date",
        TipoHtml_DT : "Datetime",
        TipoHtml_F : "Filtro (Lupa)",
        TipoHtml_TA : "Textarea",

        CargoTipo_B : "Tasa",
        CargoTipo_T : "Tarifa",

        boton_buscar : 'Buscar',
        boton_aceptar : 'Aceptar',
        boton_cancelar : 'Cancelar',
        boton_alta : 'Nuevo',
        boton_crear : 'Nuevo',
        boton_borrar : 'Borrar',
        boton_duplicar : 'Duplicar',
        boton_exportar : 'Exportar',
        boton_guardar : 'Guardar',
        boton_modificar : 'Editar',
        boton_editar : 'Editar',
        boton_volver : 'Volver',
        boton_filtro : 'Filtro',
        boton_imprimir : 'Imprimir',

        menu_tpsrs : 'Servicios',
        menu_peprs : 'Estadisticas',
        menu_tpprs : 'Maestros',
        menu_prbts : 'Procesos',
        menu_fctrmain : 'Facturaci\u00f3n',
        menu_metamodelo_tpsrs : 'Tipos de Servicio',
        menu_metamodelo_tpess : 'Tipos de Estadistica',
        menu_metamodelo_tpprs : 'Tipos de Maestro',
        menu_metamodelo_tpdts : 'Tipos de Dato',
        menu_confs : 'Configuracion',
        menu_vlrcs : 'Valoraciones',
        menu_fctrs : 'Facturas',
        menu_crgos : 'Cargos',
        menu_aspcs : 'Aspectos',

        modal_filtro : 'Filtro',
        limit : 'Max. Resultados',

        prmt_codigo : 'Codigo',
        prmt_finicio : 'F. Inicio',
        prmt_ffin : 'F. Fin',
        prmt_i18n_texto : 'Descripcion',
        prmtCriterio_parametro : 'Parametro',
        prmtCriterio_fechaVigencia : 'Fec. Vigencia',

        sprm_finicio : 'F. Inicio',
        sprm_ffin : 'F. Fin',

        cnen_codigo : 'Codigo',
        cnen_nombre : 'Nombre',

        srvc_servicio : 'Servicio',
        srvc_finicio : 'F. Inicio',
        srvc_ffin : 'F. Fin',
        srvc_freferencia : 'F. Referencia',
        srvc_estado : 'Estado',
        srvc_subp_id : 'Subpuerto',
        srvc_anno : 'A\u00f1o',
        srvc_numero : 'N\u00famero',

        ssrv_srvc : 'Servicio',
        ssrv_finicio : 'F. Inicio',
        ssrv_ffin : 'F. Fin',
        ssrv_numero : 'N\u00famero',
        ssrv_estado : 'Estado',

        vlrc : 'Valoraci\u00f3n',
        vlrcs : 'Valoraciones',
        vlrc_id : 'Id',
        vlrc_srvc : 'Servicio',
        vlrc_aspc : 'Aspecto',
        vlrc_pagador : 'Pagador',
        vlrc_importe : 'Importe',
        vlrc_impuesto : 'IVA',
        vlrc_falta : 'F. Alta',
        vlrc_fliq : 'F. Liquidacion',
        vlrc_fini : 'F. Inicio',
        vlrc_ffin : 'F. Fin',
        vlrc_sujPasivo : 'Es Suj. Pasivo?',
        vlrc_codExencion : 'C\u00f3d. Exenci\u00f3n',
        vlrc_info1 : 'Elem. Info1',
        vlrc_info2 : 'Elem. Info2',
        vlrc_info3 : 'Elem. Info3',
        vlrc_info4 : 'Elem. Info4',
        vlrc_info5 : 'Elem. Info5',
        vlrc_info6 : 'Elem. Info6',
        vlrc_vlri_impuesto : 'Tipo de IVA',
        vlrc_vlri_porcentaje : '%',
        vlrc_vlri_importe_base : 'Importe Base',
        vlrc_vlri_importe_impuesto : 'Importe IVA',

        vlrl : 'Linea de Valoraci\u00f3n',
        vlrls : 'Lineas de Valoraci\u00f3n',
        vlrl_rgla : 'Regla',
        vlrl_rgla_tipo : 'Tipo',
        vlrl_importeBase : 'Imp. Base',
        vlrl_importe : 'Importe',
        vlrl_impuesto : 'IVA',
        vlrl_fini : 'F. Inicio',
        vlrl_ffin : 'F. Fin',
        vlrl_ssrv : 'Subservicio',

        vlrd : 'Detalle de Valoraci\u00f3n',
        vlrds : 'Detalles de Valoraci\u00f3n',
        vlrd_valorBase : 'Valor Base',
        vlrd_importeBase : 'Imp. Base',
        vlrd_importe : 'Importe',
        vlrd_fini : 'F. Inicio',
        vlrd_ffin : 'F. Fin',
        vlrd_ssrv : 'Subservicio',

        aspc_codigo : 'C\u00f3digo',
        aspc_descripcion : 'Descripci\u00f3n',
        aspc_tpsr : 'Tipo de Servicio',
        aspc_aspv_fini : 'F. Inicio',
        aspc_aspv_ffin : 'F. Fin',
        aspc_aspv_prioridad : 'Prioridad',
        aspc_aspv_cetiqInfo : 'Etiq. Elem. Cabecera',
        aspc_aspv_cpathInfo : 'Ruta Elem. Cabecera',
        aspc_aspv_cgrpInfo : 'Elem. de Agrupaci\u00f3n?',

        crgo_codigo : 'C\u00f3digo',
        crgo_descripcion : 'Descripci\u00f3n',
        crgo_codigoNormalizado : 'C\u00f3d. Normalizado',
        crgo_tipo : 'Tipo',
        crgo_tpsr : 'Tipo Servicio',
        crgo_principal : 'Principal?',
        crgo_temporal : 'Temporal?',
        crgo_crgv_fini : 'F. Inicio',
        crgo_crgv_ffin : 'F. Fin',
        crgo_fechaVigencia : 'F. Vigencia',

        rgla_codigo : 'C\u00f3digo',
        rgla_tipo : 'Tipo',
        rgla_enti : 'Entidad',
        rgla_crgo : 'Cargo',
        rgla_rglv_fini : 'F. Inicio',
        rgla_rglv_ffin : 'F. Fin',
        rgla_rglv_orden : 'Orden',
        rgla_rglv_importeBase : 'Importe Base',
        rgla_rglv_formula : 'F\u00f3rmula',
        rgla_rglv_condicion : 'Condici\u00f3n',
        rgla_rglv_pathImpuesto : 'Ruta Impuesto',
        rgla_rglv_pathPagador : 'Ruta Pagador',
        rgla_rglv_pathEsSujPasivo : 'Ruta Es Suj. Pasivo',
        rgla_rglv_pathCodExen : 'Ruta C\u00f3d. Exenci\u00f3n',

        rgin_rgiv_fini : 'F. Inicio Incomp.',
        rgin_rgiv_ffin : 'F. Fin Incomp.',

        tppr_filter_title : 'Maestros - Filtro',
        tppr_grid_title : 'Maestros - Listado',
        tppr_detail_title : 'Maestro - Detalle',
        tppr_edit_title : 'Maestro - Edicion',
        tppr_create_title : 'Maestro - Alta',
        tppr_codigo : 'C\u00f3digo',
        tppr_nombre : 'Nombre',

        tpsr_codigo : 'C\u00f3digo',
        tpsr_nombre : 'Nombre',

        tpes_codigo : 'C\u00f3digo',
        tpes_nombre : 'Nombre',

        tpdt_codigo : 'C\u00f3digo',
        tpdt_nombre : 'Nombre',
        tpdt_tipoElemento : 'T. Elem.',
        tpdt_tpht : 'T. HTML',
        tpdt_enti : 'Entidad',

        cdrf_valor : 'Valor',
        cdrf_orden : 'Orden',

        enti_codigo : 'C\u00f3d.',
        enti_nombre : 'Nombre',
        enti_tipo : 'Tipo',
        enti_cmd_alta : 'Alta?',
        enti_cmd_baja : 'Baja?',
        enti_cmd_edicion : 'Edici\u00f3n?',
        enti_cmd_duplicado : 'Dupl.?',
        enti_i18n : 'i18n?',
        enti_tempExp : 'Tmp. Expl.?',
        enti_tpprAsociado : 'Entidad Asociada',
        enti_tpsr : 'T. Servicio',
        enti_temporal : 'Temporal?',
        enti_facturable : 'Facturable?',
        enti_tpdt_estado : 'T. Dato Estado',
        enti_tpdt_nombre : 'T. Dato Nombre',

        entd_grupo : 'Grupo',
        entd_fila : 'Fila',
        entd_orden : 'Orden',
        entd_span : 'Span',
        entd_spanLg : 'Span Lg',
        entd_etiqueta : 'Etiq.',
        entd_obligatorio : 'Oblig.?',
        entd_gridable : 'Grid?',
        entd_filtrable : 'Filtrable?',
        entd_tpdt_nombre : 'T. Dato',
        entd_tpdt_tipoElemento : 'T. Elem.',
        entd_tpdt_tpht : 'T. HTML',
        entd_tpdt_enti : 'Entidad',

        enen_entih : "Entidad Hija",
        enen_orden : "Orden",

    });

    $translateProvider.preferredLanguage('es');
});
/*
 * app.config(function($stateProvider, $urlRouterProvider) {
 * $urlRouterProvider.when('/c?id', '/contacts/:id').when('/user/:id',
 * '/contacts/:id')//.otherwise('/') ;
 *
 * $stateProvider.state("home", { url : "/", templateUrl : 'modules/home.html' })
 *
 * .state('tpsrs', { url : '/servicio/tpsrs', templateUrl :
 * 'modules/servicio/tpsr-listado.html', controller : function($http, $scope) {
 * $http.get("servicio/tpsr-listado-json.action").success(function(data) { //
 * console.log(data); $scope.tpsrList = data.tpsrList; $scope.tpssMap =
 * data.tpssMap; }); } })
 *
 * .state('tpprs', { url : '/maestro/tpprs', templateUrl :
 * 'modules/maestro/tppr-listado.html', controller : function($http, $scope) {
 * $http.get("maestro/tppr-listado-json.action").success(function(data) { //
 * console.log(data); $scope.tpprList = data.tpprList; }); } })
 *
 * .state('peprs', { url : '/estadistica/peprs', templateUrl :
 * 'modules/estadistica/pepr-listado.html', controller : function($http, $scope) {
 * $http.get("estadistica/pepr-listado-json.action").success(function(data) { //
 * console.log(data); $scope.peprList = data.peprList; }); } })
 *
 * .state('prbts', { url : '/proceso/prbts', templateUrl :
 * 'modules/proceso/prbt-listado.html', controller : function($http, $scope) {
 * $http.get("proceso/prbt-listado-json.action").success(function(data) { //
 * console.log(data); $scope.prbtList = data.prbtList; }); } })
 *
 * .state('fctrmain', { url : '/facturacion/main', templateUrl :
 * 'modules/facturacion/facturacion.html' }) })
 */;
