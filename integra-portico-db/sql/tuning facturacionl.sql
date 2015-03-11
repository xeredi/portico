        SELECT ssrv_pk, ssrv_srvc_pk, ssrv_numero, ssrv_tpss_pk 
            , row_number() over (ORDER BY ssrv_srvc_pk, ssrv_numero) rownumVar 
        FROM 
            tbl_subservicio_ssrv ssrv 
        WHERE ssrv_tpss_pk = 22003 
        ORDER BY ssrv_srvc_pk, ssrv_numero
;

SELECT ssrv_pk, ssrv_tpss_pk, ssrv_numero, ssrv_fini, ssrv_ffin, ssrv_estado, srvc_fref , srvc_pk, srvc_anno, srvc_numero 
    , (SELECT prmt_parametro FROM tbl_parametro_prmt WHERE prmt_pk = srvc_subp_pk) AS srvc_subp 
FROM ( 
    SELECT * 
    FROM ( 
        SELECT ssrv.* 
            , row_number() over (ORDER BY ssrv_srvc_pk, ssrv_numero) rownumVar 
        FROM tbl_subservicio_ssrv ssrv 
        WHERE ssrv_tpss_pk = 22003 
        ORDER BY ssrv_srvc_pk, ssrv_numero
    ) sql 
    WHERE rownumVar > 20 AND rownumVar <= (20 + 20 ) 
) sql 
    INNER JOIN tbl_servicio_srvc ON 
        srvc_pk = ssrv_srvc_pk
;



SELECT 
    rgla_pk, rgla_crgo_pk, rgla_codigo
    
    , rglv_pk, rglv_fini, rglv_ffin, rglv_enti_pk, rglv_tipo, rglv_orden
    , rglv_importe_base, rglv_condicion, rglv_formula, rglv_path_impuesto
    , rglv_path_pagador, rglv_path_es_suj_pasivo, rglv_path_cod_exen
    , rglv_path_info1, rglv_path_info2, rglv_path_info3, rglv_path_info4, rglv_path_info5, rglv_path_info6
    , rglv_etiq_info1, rglv_etiq_info2, rglv_etiq_info3, rglv_etiq_info4, rglv_etiq_info5, rglv_etiq_info6
    , rglv_path_cuant1, rglv_path_cuant2, rglv_path_cuant3, rglv_path_cuant4, rglv_path_cuant5, rglv_path_cuant6
    , rglv_etiq_cuant1, rglv_etiq_cuant2, rglv_etiq_cuant3, rglv_etiq_cuant4, rglv_etiq_cuant5, rglv_etiq_cuant6

    , (
        SELECT crgo_codigo FROM tbl_cargo_crgo WHERE crgo_pk = rgla_crgo_pk
    ) AS crgo_codigo
    , (
        SELECT enti_tipo FROM tbl_entidad_enti WHERE enti_pk = rglv_enti_pk
    ) AS enti_tipo
FROM
    tbl_regla_rgla
    INNER JOIN tbl_regla_version_rglv ON
        rglv_rgla_pk = rgla_pk
;


WITH tipoIva AS (
    SELECT
        prvr_prmt_pk, prvr_fini, prvr_ffin
        , (SELECT prdt_ndecimal FROM tbl_parametro_dato_prdt
            WHERE prdt_prvr_pk = prvr_pk AND prdt_tpdt_pk = portico.getTipoDato('DECIMAL_01')) AS prdt_ndecimal
    FROM
        tbl_parametro_version_prvr
    WHERE
        prvr_prmt_pk = ANY (
            SELECT prmt_pk
            FROM tbl_parametro_prmt
            WHERE prmt_tppr_pk = portico.getEntidad('TIPO_IVA')
        )
)
SELECT 
    vlrl_vlrc_pk, vlrl_impuesto_prmt_pk
    , vlrl_fref
    , prdt_ndecimal
    , SUM(vlrl_importe) AS vlri_importe_base
    , SUM(
        vlrl_importe * prdt_ndecimal
    ) / 100 AS vlri_importe
FROM (
    SELECT 
        vlrl_vlrc_pk, vlrl_impuesto_prmt_pk
        , (
            SELECT vlrc_fref
            FROM tbl_valoracion_vlrc
            WHERE vlrc_pk = vlrl_vlrc_pk
        ) AS vlrl_fref
        , (
            SELECT SUM(vlrd_importe) FROM tbl_valoracion_det_vlrd 
            WHERE vlrd_vlrl_pk = vlrl_pk
        ) AS vlrl_importe
    FROM 
        tbl_valoracion_lin_vlrl
) sql
    INNER JOIN tipoIva ON
        prvr_prmt_pk = vlrl_impuesto_prmt_pk
        AND vlrl_fref BETWEEN prvr_fini AND COALESCE(prvr_ffin, vlrl_fref)
GROUP BY vlrl_vlrc_pk, vlrl_fref, vlrl_impuesto_prmt_pk, prdt_ndecimal
;




		SELECT
		    vlrc_pk, vlrc_fref, prvr_pk, vlrl_impuesto_prmt_pk, vlrl_impuesto_porcentaje, vlri_importe
		    , vlrl_impuesto_porcentaje * vlri_importe / 100 AS vlri_importe_impuesto
		    , prmt_parametro AS vlrl_impuesto_prmt
		    , prmt_tppr_pk AS vlrl_impuesto_tppr_pk
		    , (
		        SELECT i18n_text
		        FROM tbl_i18n_i18n
		        WHERE
		            i18n_pref = 'prvr'
		            AND i18n_lang = 'es'
		            AND i18n_ext_pk = prvr_pk
		    ) AS vlrl_impuesto_descripcion
		FROM (
		    SELECT
		        vlrc_pk, vlrc_fref, vlrl_impuesto_prmt_pk, prvr_pk, SUM(vlrd_importe) AS vlri_importe
		        , (
		            SELECT prdt_ndecimal
		            FROM tbl_parametro_dato_prdt
		            WHERE
		                prdt_prvr_pk = prvr_pk
		                AND prdt_tpdt_pk = portico.getTipoDato('DECIMAL_01')
		        ) AS vlrl_impuesto_porcentaje
		    FROM
		        tbl_valoracion_vlrc
		        INNER JOIN tbl_valoracion_lin_vlrl ON
		            vlrl_vlrc_pk = vlrc_pk
		        INNER JOIN tbl_valoracion_det_vlrd ON
		            vlrd_vlrl_pk = vlrl_pk
		        LEFT JOIN tbl_parametro_version_prvr ON
		            prvr_prmt_pk = vlrl_impuesto_prmt_pk
		            AND vlrc_fref BETWEEN prvr_fini AND COALESCE(prvr_ffin, vlrc_fref)
		    GROUP BY vlrc_pk, prvr_pk, vlrc_fref, vlrl_impuesto_prmt_pk
		) sql
			INNER JOIN tbl_parametro_prmt ON
		        prmt_pk = vlrl_impuesto_prmt_pk
;