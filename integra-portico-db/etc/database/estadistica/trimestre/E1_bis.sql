SELECT     'C1' AS c0
    , 2015 AS c1
    , 3 AS c2
, c3, c4, c5, c6, c7, c8, sum(c9)
FROM (
SELECT 
    estd_subp_pk AS c3
/*
    , (SELECT prto_unlocode FROM tbl_puerto_prto WHERE prto_pk = estd_subp_pk) AS c3
*/
    , (
            SELECT esdt_cadena
            FROM tbl_estadistica_dato_esdt
            WHERE esdt_estd_pk = estd_pk
                AND esdt_tpdt_pk = portico.gettipodato('DIREC_MERC')
/*
        CASE (
            SELECT esdt_cadena
            FROM tbl_estadistica_dato_esdt
            WHERE esdt_estd_pk = estd_pk
                AND esdt_tpdt_pk = portico.getTipoDato('DIREC_MERC')
        )
            WHEN 'E' THEN 1
            WHEN 'S' THEN 2
            ELSE NULL
        END
*/
    ) AS c4
    , (
/*
        SELECT prmt_parametro FROM tbl_parametro_prmt
        WHERE 
            prmt_pk = (
*/
                SELECT esdt_prmt_pk
                FROM tbl_estadistica_dato_esdt
                WHERE esdt_estd_pk = estd_pk
                    AND esdt_tpdt_pk = portico.gettipodato('UNLOCODE')
/*
            )
*/
    ) AS c5
    , (
/*    
        SELECT prmt_parametro FROM tbl_parametro_prmt
        WHERE 
            prmt_pk = (
                SELECT prdt_prmt_pk 
                FROM tbl_parametro_dato_prdt
                WHERE
                    prdt_tpdt_pk = portico.gettipodato('ZONA_COST_EEE')
                    AND prdt_prvr_pk = (
*/
                        SELECT prvr_pk FROM tbl_parametro_version_prvr
                        WHERE prvr_fini <= pepr_freferencia
                            AND (prvr_ffin IS NULL OR prvr_ffin > pepr_freferencia)
                            AND prvr_prmt_pk = (
                                SELECT esdt_prmt_pk
                                FROM tbl_estadistica_dato_esdt
                                WHERE esdt_estd_pk = estd_pk
                                    AND esdt_tpdt_pk = portico.getTipoDato('UNLOCODE')
                            )
/*
                    )
            )
*/
    ) AS c6
    , (
/*
        SELECT prdt_cadena FROM tbl_parametro_dato_prdt
        WHERE prdt_tpdt_pk = portico.gettipodato('CADENA_01')
            AND prdt_prvr_pk = (
*/
                SELECT prvr_pk FROM tbl_parametro_version_prvr
                WHERE
                    prvr_fini <= pepr_freferencia
                    AND (prvr_ffin IS NULL OR prvr_ffin > pepr_freferencia)
                    AND prvr_prmt_pk = (
                        SELECT esdt_prmt_pk
                        FROM tbl_estadistica_dato_esdt
                        WHERE esdt_estd_pk = estd_pk
                            AND esdt_tpdt_pk = portico.getTipoDato('UNIDAD_CARGA')
                    )

/*
            )
*/
    ) AS c7
    , (
/*
        SELECT prmt_parametro FROM tbl_parametro_prmt
        WHERE 
            prmt_pk = (
*/
                SELECT esdt_prmt_pk
                FROM tbl_estadistica_dato_esdt
                WHERE esdt_estd_pk = estd_pk
                    AND esdt_tpdt_pk = portico.gettipodato('REG_TBUQUE_EEE')
/*
            )
*/
    ) AS c8
    , (
        SELECT esdt_ndecimal
        FROM tbl_estadistica_dato_esdt
        WHERE esdt_estd_pk = estd_pk
            AND esdt_tpdt_pk = portico.getTipoDato('DECIMAL_01')
    ) AS c9
FROM tbl_estadistica_estd
    INNER JOIN tbl_periodo_proceso_pepr ON
        pepr_pk = estd_pepr_pk
WHERE
    estd_tpes_pk = portico.getentidad('MOVIMIENTO_MERCANCIA_EEE')
    AND pepr_anio = 2015
    AND pepr_trimestre = 3
) SQL
GROUP BY c0, c1, c2, c3, c4, c5, c6, c7, c8
ORDER BY c0, c1, c2, c3, c4, c5, c6, c7, c8
;




