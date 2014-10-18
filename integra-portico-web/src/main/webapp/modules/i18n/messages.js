var module = angular.module("i18n", [ "pascalprecht.translate" ]);

module.config(function($translateProvider) {
    $translateProvider.translations('es', {
        app_nombre : 'PORTICO',
        home : 'Inicio',

        errors : "Errores",
        fmt_true : "Si",
        fmt_false : "No",
        fmt_1 : "Si",
        fmt_0 : "No",
        fmt_integer : "#,###,###,##0",
        fmt_date : "dd/MM/yyyy",
        fmt_calendar_date : "yyyy-MM-dd",
        fmt_datetime : "dd/MM/yyyy HH:mm",

        ProcesoModulo_E : "Estad\u00edstica",
        ProcesoModulo_S : "Servicio",

        ProcesoTipo_EST_CARGA : "Carga de Estad\u00edsticas",
        ProcesoTipo_PES_CARGA : "Carga de Pesca",
        ProcesoTipo_MAN_CARGA : "Carga EDI de Manifiestos",
        ProcesoTipo_ESC_CARGA : "Carga EDI de Escalas",

        ProcesoEstado_C : "En Cola",
        ProcesoEstado_E : "En Ejecuci\u00f3n",
        ProcesoEstado_F : "Finalizado",

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
        boton_valorar : "Valorar",
        boton_valoraciones : "Valoraciones",
        boton_recargar : "Recargar",

        menu_gestion : "Gesti\u00f3n",
        menu_administracion : "Administraci\u00f3n",
        menu_configuracion : "Configuraci\u00f3n",
        menu_tpsrs : "Servicios",
        menu_peprs : "Estad\u00edsticas",
        menu_tpprs : "Maestros",
        menu_prbts : "Procesos",
        menu_fctrmain : "Facturaci\u00f3n",
        menu_metamodelo : "Metamodelo",
        menu_metamodelo_tpsrs : "Tipos de Servicio",
        menu_metamodelo_tpess : "Tipos de Estad\u00edstica",
        menu_metamodelo_tpprs : "Tipos de Maestro",
        menu_metamodelo_tpdts : "Tipos de Dato",
        menu_metamodelo_reload : 'Recargar Metamodelo',
        menu_confs : "Configuraci\u00f3n",
        menu_vlrcs : "Valoraciones",
        menu_fctrs : "Facturas",
        menu_crgos : "Cargos",
        menu_aspcs : "Aspectos",

        filter_title : "FILTRO",
        limit : "M\u00e1x. Resultados",
        pagination_results : "{{count}} Resultado(s)",

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
        srvc_tpsr : "T. Servicio",
        srvc_fini : "F. Inicio",
        srvc_ffin : "F. Fin",
        srvc_fref : "F. Referencia",
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

        pepr_grid : "Per\u00edodo de Proceso - Listado",
        pepr_detail : "Per\u00edodo de Proceso - Detalle",

        pepr_autp : 'Aut. P.',
        pepr_anio : 'A\u00f1o',
        pepr_mes : 'Mes',
        pepr_cdmsGenerado : 'Cuad. Mensual Generado?',
        pepr_cdms : "CUADRO MENSUAL",

        cdms_detail : "Cuadro Mensual - Detalle",
        cdms_numero : "N\u00ba",
        cdms_tm : "Tm",
        cdms_teus : "TEUS",
        cdms_ca : "Con carga",
        cdms_va : "Vac\u00edos",
        cdms_embarcado : "Embarcado",
        cdms_desembarcado : "Desembarcado",
        cdms_transito : "Tr\u00e1nsito",
        cdms_transbordo : "Transbordo",
        cdms_GL : "GRANELES LIQUIDOS",
        cdms_GLPETR : "CRUDOS DE PETROLEO",
        cdms_GLGASN : "GAS NATURAL",
        cdms_GLPREF : "PRODUCTOS PETROLIFEROS REFINADOS",
        cdms_GLOTRO : "OTROS GRANELES LIQUIDOS",
        cdms_GS : "GRANELES SOLIDOS",
        cdms_GSIESP : "POR INSTALACION ESPECIAL",
        cdms_GSNIES : "SIN INSTALACION ESPECIAL",
        cdms_MG : "MERCANCIA GENERAL",
        cdms_PASAJE : "N\u00ba PASAJEROS (EXCLUIDO T. BAHIA)",
        cdms_PASCRU : "N\u00ba PASAJEROS DE CRUCERO",
        cdms_VET2 : "N\u00ba VEHICULOS (Turismos en r\u00e9g. pasaje, Autom\u00f3viles y Autobuses)",
        cdms_CTEUS : "TEUS (con carga y vac\u00edos)",
        cdms_RR : "TRAFICO RO-RO",
        cdms_RRC : "EN CONTENEDORES",
        cdms_RRO : "EN OTROS MEDIOS",
        cdms_AV : "AVITUALLAMIENTO",
        cdms_AVPPET : "PROD. PETROLIFEROS",
        cdms_AVOTRO : "OTROS",
        cdms_TRALOC : "TRAFICO LOCAL",
        cdms_PESCAF : "PESCA FRESCA",

        estd_grid : "Dato Estad\u00edstico - Listado",
        estd_detail : "Dato Estad\u00edstico - Detalle",

        estd_pepr : 'Per\u00edodo de Proceso',
        estd_subp : 'Puerto',

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
        vlrc_crgo : "Cargo",

        vlrl_detail : "L\u00ednea de Valoraci\u00f3n - Detalle",
        vlrl_create : "L\u00ednea de Valoraci\u00f3n - Alta",
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
        vlrd_create : "Detalle de Valoraci\u00f3n - Alta",
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

        ascr_crgo : "Cargo",
        ascr_fini : "F. Inicio",
        ascr_ffin : "F. Fin",

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
        enti_maxGrid : "Grid M\u00e1x. (filas)",

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

        prbt_grid : "Proceso Batch - Listado",
        prbt_detail : "Proceso Batch - Detalle",
        prbt_modulo : "M\u00f3dulo",
        prbt_tipo : "Tipo",
        prbt_estado : "Estado",
        prbt_falta : "Fec. Alta",
        prbt_finicio : "Fec. Inicio",
        prbt_ffin : "Fec. Fin",
        prbt_duracion : "Duraci\u00f3n (ms)",
        prbt_erroresCnt : "Errores (n\u00ba)",
        prbt_alertasCnt : "Alertas (n\u00ba)",
        prbt_mensajesCnt : "Mensajes (n\u00ba)",

        prpm_nombre : "Nombre",
        prpm_valor : "Valor",

        prmn_nivel : "Nivel",
        prmn_codigo : "C\u00f3digo",
        prmn_mensaje : "Mensaje",

        mani_totales : "Totales Manifiesto",
        mabl_totales : "Totales BL",
        mani_resumen_mercancias : "Mercanc\u00edas",
        mani_resumen_pasajeros : "Pasajeros",
        mani_resumen_numBlsMercancia : "N\u00ba BLs",
        mani_resumen_numBlsPasajeros : "N\u00ba BLs",
        mani_resumen_numContenedores20 : "Contenedores 20",
        mani_resumen_numContenedores20Llenos : "Llenos",
        mani_resumen_numContenedores20Vacios : "Vac\u00edos",
        mani_resumen_numContenedores40 : "Contenedores 40",
        mani_resumen_numContenedores40Llenos : "Llenos",
        mani_resumen_numContenedores40Vacios : "Vac\u00edos",
        mani_resumen_numEquipamientos : "Equipamientos",
        mani_resumen_numEquipamientosLlenos : "Llenos",
        mani_resumen_numEquipamientosVacios : "Vac\u00edos",
        mani_resumen_numPartidasMercancia : "N\u00ba Partidas",
        mani_resumen_pesoPartidasMercancia : "Peso Total (Kg)",
        mani_resumen_numPartidasPasajeros : "N\u00ba Partidas",
        mani_resumen_numPasajeros : "N\u00ba Pasajeros",
        mani_resumen_numCruceristas : "N\u00ba Cruceristas",
        mani_resumen_numVehiculos : "N\u00ba Veh\u00edculos",
    });

    $translateProvider.preferredLanguage("es");
});
