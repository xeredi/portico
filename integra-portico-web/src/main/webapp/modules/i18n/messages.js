angular.module("i18n", [ "pascalprecht.translate" ])

.config(function($translateProvider) {
    $translateProvider.translations('es', {
        fmt_integer : "#,###,###,##0",

        ProcesoTipo_EST_CARGA : "Carga de Estad\u00edsticas",
        ProcesoTipo_PES_CARGA : "Carga de Pesca",
        ProcesoTipo_MAN_CARGA : "Carga EDI de Manifiestos",
        ProcesoTipo_ESC_CARGA : "Carga EDI de Escalas",

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

        mani_totales : "Totales Manifiesto",
        mabl_totales : "Totales BL",
    });

    $translateProvider.preferredLanguage("es");
});
