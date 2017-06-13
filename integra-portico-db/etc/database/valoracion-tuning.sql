SELECT COUNT(1) FROM tbl_subservicio_ssrv WHERE ssrv_tpss_pk = ? AND EXISTS ( SELECT 1 FROM tbl_subservicio_dato_ssdt WHERE ssdt_ssrv_pk = ssrv_pk AND ssdt_tpdt_pk = ? AND ssdt_prmt_pk = ? ) AND EXISTS ( SELECT 1 FROM tbl_subservicio_dato_ssdt WHERE ssdt_ssrv_pk = ssrv_pk AND ssdt_tpdt_pk = ? AND ssdt_prmt_pk = ? ) 
;

SELECT COUNT(1) 
FROM tbl_subservicio_ssrv 
WHERE 
  1=1
  AND ssrv_tpss_pk = 22004 
  AND EXISTS ( SELECT 1 FROM tbl_subservicio_dato_ssdt WHERE ssdt_ssrv_pk = ssrv_pk AND ssdt_tpdt_pk = 45290 AND ssdt_prmt_pk = 1030870 ) 
  AND EXISTS ( SELECT 1 FROM tbl_subservicio_dato_ssdt WHERE ssdt_ssrv_pk = ssrv_pk AND ssdt_tpdt_pk = 45345 AND ssdt_prmt_pk = 1000743 ) 
;


SELECT vlrc_pk, vlrc_fref , prmt_pk AS vlri_pk , prmt_parametro AS vlri_parametro , prmt_tppr_pk AS vlri_tppr_pk , prvr_pk AS vlri_prvr_pk , vlri_porcentaje , SUM(vlri_importe_base) AS vlri_importe_base , SUM(vlri_importe_base) * vlri_porcentaje / 100 AS vlri_importe_impuesto , ( SELECT i18n_text FROM tbl_i18n_i18n WHERE i18n_pref = 'prvr' AND i18n_lang = ? AND i18n_ext_pk = prvr_pk ) AS vlri_descripcion FROM ( SELECT vlrc_pk, vlrc_fref , prmt_pk, prmt_parametro, prmt_tppr_pk , prvr_pk , ( SELECT prdt_ndecimal FROM tbl_parametro_dato_prdt WHERE prdt_tpdt_pk = portico.getTipoDato('DECIMAL_01') AND prdt_prvr_pk = prvr_pk ) AS vlri_porcentaje , ( SELECT SUM(vlrd_importe) FROM tbl_valoracion_det_vlrd WHERE vlrd_vlrl_pk = vlrl.vlrl_pk ) AS vlri_importe_base FROM tbl_valoracion_vlrc INNER JOIN tbl_valoracion_lin_vlrl vlrl ON vlrl.vlrl_vlrc_pk = vlrc_pk INNER JOIN tbl_valoracion_lin_vlrl vlrlPadre ON vlrlPadre.vlrl_pk = vlrl.vlrl_padre_pk INNER JOIN tbl_parametro_prmt ON prmt_pk = vlrlPadre.vlrl_impuesto_prmt_pk LEFT JOIN tbl_parametro_version_prvr ON prvr_prmt_pk = vlrlPadre.vlrl_impuesto_prmt_pk AND vlrc_fref BETWEEN prvr_fini AND COALESCE(prvr_ffin, vlrc_fref) WHERE vlrc_pk = ? ) GROUP BY vlrc_pk, vlrc_fref , prmt_pk, prmt_parametro, prmt_tppr_pk , prvr_pk, vlri_porcentaje 
;

SELECT vlrc_pk, vlrc_fref , prmt_pk AS vlri_pk , prmt_parametro AS vlri_parametro , prmt_tppr_pk AS vlri_tppr_pk , prvr_pk AS vlri_prvr_pk , vlri_porcentaje 
    , SUM(vlri_importe_base) AS vlri_importe_base 
    , SUM(vlri_importe_base) * vlri_porcentaje / 100 AS vlri_importe_impuesto 
    , ( SELECT i18n_text FROM tbl_i18n_i18n WHERE i18n_pref = 'prvr' AND i18n_lang = 'es' AND i18n_ext_pk = prvr_pk ) AS vlri_descripcion 
FROM ( 
    SELECT vlrc_pk, vlrc_fref , prmt_pk, prmt_parametro, prmt_tppr_pk , prvr_pk 
        , ( SELECT prdt_ndecimal FROM tbl_parametro_dato_prdt WHERE prdt_tpdt_pk = portico.getTipoDato('DECIMAL_01') AND prdt_prvr_pk = prvr_pk ) AS vlri_porcentaje 
        , ( SELECT SUM(vlrd_importe) FROM tbl_valoracion_det_vlrd WHERE vlrd_vlrl_pk = vlrl.vlrl_pk ) AS vlri_importe_base 
    FROM tbl_valoracion_vlrc 
        INNER JOIN tbl_valoracion_lin_vlrl vlrl ON vlrl.vlrl_vlrc_pk = vlrc_pk 
        INNER JOIN tbl_valoracion_lin_vlrl vlrlPadre ON vlrlPadre.vlrl_pk = vlrl.vlrl_padre_pk 
        INNER JOIN tbl_parametro_prmt ON prmt_pk = vlrlPadre.vlrl_impuesto_prmt_pk 
        LEFT JOIN tbl_parametro_version_prvr ON prvr_prmt_pk = vlrlPadre.vlrl_impuesto_prmt_pk AND vlrc_fref BETWEEN prvr_fini AND COALESCE(prvr_ffin, vlrc_fref) 
--    WHERE vlrc_pk = 1947755 
) 
GROUP BY vlrc_pk, vlrc_fref , prmt_pk, prmt_parametro, prmt_tppr_pk , prvr_pk, vlri_porcentaje 
;

SELECT vlrc_pk, vlrc_fref, vlri_pk, vlri_prvr_pk
    , (
        SELECT prmt_parametro
        FROM tbl_parametro_prmt
        WHERE 
            prmt_pk = vlri_pk
    ) AS vlri_parametro
    , (
        SELECT prmt_tppr_pk
        FROM tbl_parametro_prmt
        WHERE 
            prmt_pk = vlri_pk
    ) AS vlri_tppr_pk
    , ( 
        SELECT prdt_ndecimal 
        FROM tbl_parametro_dato_prdt 
        WHERE 
            prdt_tpdt_pk = getTipoDato('DECIMAL_01') 
            AND prdt_prvr_pk = vlri_prvr_pk 
    ) AS vlri_porcentaje 
    , SUM(vlri_importe_base) AS vlri_importe_base
    , SUM(vlri_importe_base) * (
        SELECT prdt_ndecimal 
        FROM tbl_parametro_dato_prdt 
        WHERE 
            prdt_tpdt_pk = getTipoDato('DECIMAL_01') 
            AND prdt_prvr_pk = vlri_prvr_pk 
    ) / 100 AS vlri_importe_impuesto
    , ( SELECT i18n_text FROM tbl_i18n_i18n WHERE i18n_pref = 'prvr' AND i18n_lang = 'es' AND i18n_ext_pk = vlri_prvr_pk ) AS vlri_descripcion 
FROM (
    SELECT 
        vlrd_vlrc_pk AS vlrc_pk
        , vlrc_fref
        , (
            SELECT vlrl_impuesto_prmt_pk
            FROM tbl_valoracion_lin_vlrl
            WHERE
                vlrl_pk = (
                    SELECT vlrl_padre_pk
                    FROM tbl_valoracion_lin_vlrl
                    WHERE vlrl_pk = vlrd_vlrl_pk
                )
        ) AS vlri_pk
        , (
            SELECT prvr_pk
            FROM tbl_parametro_version_prvr
            WHERE 
                prvr_prmt_pk = (
                    SELECT vlrl_impuesto_prmt_pk
                    FROM tbl_valoracion_lin_vlrl
                    WHERE
                        vlrl_pk = (
                            SELECT vlrl_padre_pk
                            FROM tbl_valoracion_lin_vlrl
                            WHERE vlrl_pk = vlrd_vlrl_pk
                        )
                )
                AND prvr_fini <= vlrc_fref
                AND (prvr_ffin IS NULL OR prvr_ffin > vlrc_fref)
        ) AS vlri_prvr_pk
        , vlrd_importe AS vlri_importe_base
    FROM tbl_valoracion_det_vlrd
        INNER JOIN tbl_valoracion_vlrc ON
            vlrc_pk = vlrd_vlrc_pk
/*
    WHERE 
        vlrd_vlrc_pk = 1947755
*/
) sql
GROUP BY vlrc_pk, vlrc_fref, vlri_pk, vlri_prvr_pk
;

SELECT * 
FROM tbl_valoracion_lin_vlrl;

	==> Parameters: es(String), 1947755(Long)  