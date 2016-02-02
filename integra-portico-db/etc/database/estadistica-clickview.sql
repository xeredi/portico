
SELECT * FROM TBL_PARAMETRO_VERSION_PRVR;

SELECT estd_subp_pk, d1, SUM(a1) AS a1
FROM (
SELECT 
    estd_subp_pk
    , (
        SELECT prdt_prmt_pk
        FROM tbl_parametro_dato_prdt
        WHERE 
            prdt_tpdt_pk = portico.getTipoDato('GRUPO_ARAN')
            AND prdt_prvr_pk = (
                SELECT prvr_pk
                FROM tbl_parametro_version_prvr
                WHERE 
                    prvr_fini <= pepr_freferencia
                    AND (prvr_ffin IS NULL OR prvr_ffin > pepr_freferencia)
                    AND prvr_prmt_pk = (
                        SELECT esdt_prmt_pk
                        FROM tbl_estadistica_dato_esdt
                        WHERE esdt_estd_pk = estd_pk
                            AND esdt_tpdt_pk = portico.getTipoDato('MERCANCIA')
                    )
            )
    ) AS d1
    , (
        SELECT esdt_prmt_pk
        FROM tbl_estadistica_dato_esdt
        WHERE esdt_estd_pk = estd_pk
            AND esdt_tpdt_pk = portico.getTipoDato('UNLOCODE_4')
    ) AS d2
    , (
        SELECT esdt_prmt_pk
        FROM tbl_estadistica_dato_esdt
        WHERE esdt_estd_pk = estd_pk
            AND esdt_tpdt_pk = portico.getTipoDato('MERCANCIA')
    ) AS d3
    , (
        SELECT COALESCE(esdt_ndecimal, 0)
        FROM tbl_estadistica_dato_esdt
        WHERE esdt_estd_pk = estd_pk
            AND esdt_tpdt_pk = portico.getTipoDato('DECIMAL_01')
    ) AS a1
FROM tbl_estadistica_estd
    INNER JOIN tbl_periodo_proceso_pepr ON
        pepr_pk = estd_pepr_pk
WHERE 
    estd_tpes_pk = 23005
    AND pepr_trimestre = 2
/*
    AND EXISTS (
        SELECT 1 FROM tbl_estadistica_dato_esdt
        WHERE esdt_estd_pk = estd_pk
            AND esdt_tpdt_pk = portico.getTipoDato('UNLOCODE_3')
            AND EXISTS (
                SELECT 1 FROM tbl_parametro_prmt
                WHERE 
                    prmt_pk = esdt_prmt_pk 
                    AND prmt_tppr_pk = portico.getEntidad('UNLOCODE')
                    AND prmt_parametro LIKE 'ESBCN'
            )
    )
*/
) sql
GROUP BY estd_subp_pk, d1
ORDER BY estd_subp_pk, d1
;






SELECT acen_pk, acen_enti_pk, acen_accn_pk , accn_prefix, accn_codigo, accn_core, accn_multiple 
FROM tbl_accion_entidad_acen 
    INNER JOIN tbl_accion_accn ON 
        accn_pk = acen_accn_pk 
WHERE 
    acen_pk = ANY (
        SELECT grae_acen_pk FROM tbl_grupo_accion_entidad_grae 
        WHERE 
            grae_grpo_pk = ANY(
                SELECT usgr_grpo_pk FROM tbl_usuario_grupo_usgr 
                WHERE usgr_usro_pk = 1000 
            )            
    )
ORDER BY acen_enti_pk, accn_prefix, accn_codigo 
;