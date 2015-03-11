SELECT 
    spdt_spvr_pk, spdt_tpdt_pk, spdt_nentero, spdt_ndecimal, spdt_fecha, spdt_prmt_pk, spdt_cadena
    
    , prmt_tppr_pk, prmt_parametro
FROM 
    tbl_subparametro_dato_spdt
    LEFT JOIN tbl_parametro_prmt ON
        prmt_pk = spdt_prmt_pk
    LEFT JOIN tbl_tipo_parametro_tppr ON
        tppr_pk = prmt_tppr_pk
;


SELECT *
FROM 
    tbl_parametro_prmt
    INNER JOIN tbl_parametro_version_prvr ON
        prvr_prmt_pk = prmt_pk
WHERE 
    prmt_tppr_pk = 20049
ORDER BY prmt_tppr_pk, prmt_parametro
;

SELECT COUNT(1)
FROM 
    tbl_parametro_prmt
    INNER JOIN tbl_parametro_version_prvr ON
        prvr_prmt_pk = prmt_pk
WHERE 
    prmt_tppr_pk = 20005
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