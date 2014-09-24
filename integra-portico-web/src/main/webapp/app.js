var app = angular.module("integraApp", [ "ui.bootstrap", "pascalprecht.translate", "ngRoute", "util", "metamodelo",
        "facturacion", "maestro", "servicio"/*
                                             * 'configuracion', 'proceso',
                                             *
                                             */]);

app.config([ "$routeProvider", function($routeProvider) {
    $routeProvider

    .when("/", {
        title : 'home',
        templateUrl : "modules/home.html",
    })
} ]);

app.run([ '$location', '$rootScope', function($location, $rootScope) {
    $rootScope.$on('$routeChangeSuccess', function(event, current, previous) {
        $rootScope.title = current.$$route.title;
    });
} ]);

app.config(function($translateProvider) {
    $translateProvider.translations('es', {
        app_nombre : 'PORTICO',
        home : 'Inicio',

        errors : "Errores",
        fmt_true : "Si",
        fmt_false : "No",
        fmt_integer : "#,###,###,##0",
        fmt_date : "dd/MM/yyyy",
        fmt_calendar_date : "yyyy-MM-dd",
        fmt_datetime : "dd/MM/yyyy HH:mm",

        TipoElemento_BO : "Booleano",
        TipoElemento_CR : "C\u00f3d. Referencia",
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

        ReglaTipo_T : "Precio",
        ReglaTipo_C : "Coeficiente",
        ReglaTipo_D : "Bonificaci\u00f3n",

        boton_buscar : "Buscar",
        boton_aceptar : "Aceptar",
        boton_cancelar : "Cancelar",
        boton_alta : "Nuevo",
        boton_crear : "Nuevo",
        boton_borrar : "Borrar",
        boton_duplicar : "Duplicar",
        boton_exportar : "Exportar",
        boton_guardar : "Guardar",
        boton_modificar : "Editar",
        boton_editar : "Editar",
        boton_volver : "Volver",
        boton_filtro : "Filtro",
        boton_imprimir : "Imprimir",

        menu_tpsrs : "Servicios",
        menu_peprs : "Estad\u00edsticas",
        menu_tpprs : "Maestros",
        menu_prbts : "Procesos",
        menu_fctrmain : "Facturaci\u00f3n",
        menu_metamodelo_tpsrs : "Tipos de Servicio",
        menu_metamodelo_tpess : "Tipos de Estad\u00edstica",
        menu_metamodelo_tpprs : "Tipos de Maestro",
        menu_metamodelo_tpdts : "Tipos de Dato",
        menu_confs : "Configuraci\u00f3n",
        menu_vlrcs : "Valoraciones",
        menu_fctrs : "Facturas",
        menu_crgos : "Cargos",
        menu_aspcs : "Aspectos",

        modal_filtro : "Filtro",
        limit : "M\u00e1x. Resultados",

        maestro_main : "Maestros - Inicio",

        prmt_grid : "Maestro - Listado",
        prmt_detail : "Maestro - Detalle",
        prmt_duplicate : "Maestro - Duplicado",
        prmt_create : "Maestro - Nuevo",
        prmt_edit : "Maestro - Edici\u00f3n",

        prmt_parametro : "C\u00f3digo",
        prmt_fini : "F. Inicio",
        prmt_ffin : "F. Fin",
        prmt_i18n_texto : "Descripci\u00f3n",
        prmt_fechaVigencia : "Fec. Vigencia",

        sprm_detail : "Submaestro - Detalle",
        sprm_duplicate : "Submaestro - Duplicado",
        sprm_create : "Submaestro - Nuevo",
        sprm_edit : "Submaestro - Edici\u00f3n",

        sprm_fini : "F. Inicio",
        sprm_ffin : "F. Fin",

        cnen_codigo : "C\u00f3digo",
        cnen_nombre : "Nombre",

        servicio_main : "Servicios - Inicio",

        srvc_grid : "Servicio - Listado",
        srvc_detail : "Servicio - Detalle",
        srvc_edit : "Servicio - Edici\u00f3n",
        srvc_create : "Servicio - Alta",
        srvc_duplicate : "Servicio - Duplicado",

        srvc_servicio : "Servicio",
        srvc_fini : "F. Inicio",
        srvc_ffin : "F. Fin",
        srvc_freferencia : "F. Referencia",
        srvc_estado : "Estado",
        srvc_subp : "Subpuerto",
        srvc_anno : "A\u00f1o",
        srvc_numero : "N\u00famero",

        ssrv_grid : "Subservicio - Listado",
        ssrv_detail : "Subservicio - Detalle",
        ssrv_edit : "Subservicio - Edici\u00f3n",
        ssrv_create : "Subservicio - Alta",
        ssrv_duplicate : "Subservicio - Duplicado",

        ssrv_srvc : "Servicio",
        ssrv_fini : "F. Inicio",
        ssrv_ffin : "F. Fin",
        ssrv_numero : "N\u00famero",
        ssrv_estado : "Estado",

        vlrc_grid : "Valoraci\u00f3n - Listado",
        vlrc_detail : "Valoraci\u00f3n - Detalle",
        vlrc_edit : "Valoraci\u00f3n - Edici\u00f3n",

        vlrc : "Valoraci\u00f3n",
        vlrcs : "Valoraciones",
        vlrc_id : "Id",
        vlrc_srvc : "Servicio",
        vlrc_aspc : "Aspecto",
        vlrc_pagador : "Pagador",
        vlrc_importe : "Importe",
        vlrc_impuesto : "IVA",
        vlrc_falta : "F. Alta",
        vlrc_fliq : "F. Liquidaci\u00f3n",
        vlrc_fini : "F. Inicio",
        vlrc_ffin : "F. Fin",
        vlrc_sujPasivo : "Es Suj. Pasivo?",
        vlrc_codExencion : "C\u00f3d. Exenci\u00f3n",
        vlrc_info1 : "Elem. Info1",
        vlrc_info2 : "Elem. Info2",
        vlrc_info3 : "Elem. Info3",
        vlrc_info4 : "Elem. Info4",
        vlrc_info5 : "Elem. Info5",
        vlrc_info6 : "Elem. Info6",
        vlrc_vlri_impuesto : "Tipo de IVA",
        vlrc_vlri_porcentaje : "%",
        vlrc_vlri_importe_base : "Importe Base",
        vlrc_vlri_importe_impuesto : "Importe IVA",

        vlrl_detail : "L\u00ednea de Valoraci\u00f3n - Detalle",
        vlrl_edit : "L\u00ednea de Valoraci\u00f3n - Edici\u00f3n",

        vlrl : "Linea de Valoraci\u00f3n",
        vlrls : "Lineas de Valoraci\u00f3n",
        vlrl_rgla : "Regla",
        vlrl_rgla_tipo : "Tipo",
        vlrl_importeBase : "Imp. Base",
        vlrl_importe : "Importe",
        vlrl_impuesto : "IVA",
        vlrl_fini : "F. Inicio",
        vlrl_ffin : "F. Fin",
        vlrl_ssrv : "Subservicio",

        vlrd_detail : "Detalle de Valoraci\u00f3n - Detalle",
        vlrd_edit : "Detalle de Valoraci\u00f3n - Edici\u00f3n",

        vlrd : "Detalle de Valoraci\u00f3n",
        vlrds : "Detalles de Valoraci\u00f3n",
        vlrd_valorBase : "Valor Base",
        vlrd_importeBase : "Imp. Base",
        vlrd_importe : "Importe",
        vlrd_fini : "F. Inicio",
        vlrd_ffin : "F. Fin",
        vlrd_ssrv : "Subservicio",

        aspc_grid : "Aspecto - Listado",
        aspc_detail : "Aspecto - Detalle",
        aspc_create : "Aspecto - Nuevo",
        aspc_edit : "Aspecto - Edici\u00f3n",
        aspc_duplicate : "Aspecto - Duplicado",

        aspc_codigo : "C\u00f3digo",
        aspc_descripcion : "Descripci\u00f3n",
        aspc_tpsr : "Tipo de Servicio",
        aspc_fini : "F. Inicio",
        aspc_ffin : "F. Fin",
        aspc_prioridad : "Prioridad",
        aspc_cetiqInfo : "Etiq. Elem. Cabecera",
        aspc_cpathInfo : "Ruta Elem. Cabecera",
        aspc_cgrpInfo : "Elem. de Agrupaci\u00f3n?",
        aspc_lsumCuant : "Elem. Sumarizable?",
        aspc_lgrpInfo : "Elem. de Agrupaci\u00f3n?",

        crgo_grid : "Cargo - Listado",
        crgo_detail : "Cargo - Detalle",
        crgo_create : "Cargo - Nuevo",
        crgo_edit : "Cargo - Edici\u00f3n",

        crgo_codigo : "C\u00f3digo",
        crgo_descripcion : "Descripci\u00f3n",
        crgo_codigoNormalizado : "C\u00f3d. Normalizado",
        crgo_tipo : "Tipo",
        crgo_tpsr : "Tipo Servicio",
        crgo_principal : "Principal?",
        crgo_temporal : "Temporal?",
        crgo_fini : "F. Inicio",
        crgo_ffin : "F. Fin",
        crgo_fechaVigencia : "F. Vigencia",

        rgla_detail : "Regla - Detalle",
        rgla_create : "Regla - Nuevo",
        rgla_edit : "Regla - Edici\u00f3n",

        rgla_codigo : "C\u00f3digo",
        rgla_tipo : "Tipo",
        rgla_enti : "Entidad",
        rgla_crgo : "Cargo",
        rgla_fini : "F. Inicio",
        rgla_ffin : "F. Fin",
        rgla_orden : "Orden",
        rgla_importeBase : "Importe Base",
        rgla_formula : "F\u00f3rmula",
        rgla_condicion : "Condici\u00f3n",
        rgla_pathImpuesto : "Ruta Impuesto",
        rgla_pathPagador : "Ruta Pagador",
        rgla_pathEsSujPasivo : "Ruta Es Suj. Pasivo",
        rgla_pathCodExen : "Ruta C\u00f3d. Exenci\u00f3n",
        rgla_etiqInfo : "Etiq. Elem. Informativo",
        rgla_pathInfo : "Ruta Elem. Informativo",
        rgla_etiqCuant : "Etiq. Elem. Cuantitativo",
        rgla_pathCuant : "Ruta Elem. Cuantitativo",

        rgin_detail : "Incompatibilidad - Detalle",
        rgin_create : "Incompatibilidad - Nuevo",
        rgin_edit : "Incompatibilidad - Edici\u00f3n",

        rgin_rgla2 : "Regla Incompatible",
        rgin_fini : "F. Inicio",
        rgin_ffin : "F. Fin",

        tppr_grid : "Tipo de Maestro - Listado",
        tppr_detail : "Tipo de Maestro - Detalle",
        tppr_create : "Tipo de Maestro - Nuevo",
        tppr_edit : "Tipo de Maestro - Edici\u00f3n",

        tppr_codigo : "C\u00f3digo",
        tppr_nombre : "Nombre",

        tpsr_grid : "Tipo de Servicio - Listado",
        tpsr_detail : "Tipo de Servicio - Detalle",
        tpsr_create : "Tipo de Servicio - Nuevo",
        tpsr_edit : "Tipo de Servicio - Edici\u00f3n",

        tpsr_codigo : "C\u00f3digo",
        tpsr_nombre : "Nombre",

        tpss_detail : "Tipo de Subservicio - Detalle",
        tpss_create : "Tipo de Subservicio - Nuevo",
        tpss_edit : "Tipo de Subservicio - Edici\u00f3n",

        tpes_grid : "Tipo de Estad\u00edstica - Listado",
        tpes_detail : "Tipo de Estad\u00edstica - Detalle",
        tpes_create : "Tipo de Estad\u00edstica - Nuevo",
        tpes_edit : "Tipo de Estad\u00edstica - Edici\u00f3n",

        tpes_codigo : "C\u00f3digo",
        tpes_nombre : "Nombre",

        tpdt_grid : "Tipo de Dato - Listado",
        tpdt_detail : "Tipo de Dato - Detalle",
        tpdt_create : "Tipo de Dato - Nuevo",
        tpdt_edit : "Tipo de Dato - Edici\u00f3n",

        tpdt_codigo : "C\u00f3digo",
        tpdt_nombre : "Nombre",
        tpdt_tipoElemento : "T. Elem.",
        tpdt_tpht : "T. HTML",
        tpdt_enti : "Entidad",

        cdrf_detail : "C\u00f3digo de Referencia - Detalle",
        cdrf_create : "C\u00f3digo de Referencia - Nuevo",
        cdrf_edit : "C\u00f3digo de Referencia - Edici\u00f3n",

        cdrf_valor : "Valor",
        cdrf_orden : "Orden",

        enti_codigo : "C\u00f3d.",
        enti_nombre : "Nombre",
        enti_tipo : "Tipo",
        enti_cmd_alta : "Alta?",
        enti_cmd_baja : "Baja?",
        enti_cmd_edicion : "Edici\u00f3n?",
        enti_cmd_duplicado : "Dupl.?",
        enti_i18n : "i18n?",
        enti_tempExp : "Tmp. Expl.?",
        enti_tpprAsociado : "Entidad Asociada",
        enti_tpsr : "T. Servicio",
        enti_temporal : "Temporal?",
        enti_facturable : "Facturable?",
        enti_tpdt_estado : "T. Dato Estado",
        enti_tpdt_nombre : "T. Dato Nombre",

        entd_detail : "Dato de Entidad - Detalle",
        entd_create : "Dato de Entidad - Nuevo",
        entd_edit : "Dato de Entidad - Edici\u00f3n",

        entd_grupo : "Grupo",
        entd_fila : "Fila",
        entd_orden : "Orden",
        entd_span : "Span",
        entd_spanLg : "Span Lg",
        entd_etiqueta : "Etiq.",
        entd_obligatorio : "Oblig.?",
        entd_gridable : "Grid?",
        entd_filtrable : "Filtrable?",
        entd_tpdt_nombre : "T. Dato",
        entd_tpdt_tipoElemento : "T. Elem.",
        entd_tpdt_tpht : "T. HTML",
        entd_tpdt_enti : "Entidad",

        enac_detail : "Acci\u00f3n de Entidad - Detalle",
        enac_create : "Acci\u00f3n de Entidad - Nuevo",
        enac_edit : "Acci\u00f3n de Entidad - Edici\u00f3n",

        enac_path : "Path",
        enac_etiqueta : "Etiqueta",
        enac_orden : "Orden",

        enen_detail : "Dependencia de Entidad - Detalle",
        enen_create : "Dependencia de Entidad - Nuevo",
        enen_edit : "Dependencia de Entidad - Edici\u00f3n",

        enen_entih : "Entidad Hija",
        enen_orden : "Orden",
    });

    $translateProvider.preferredLanguage("es");
});
