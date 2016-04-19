SELECT 
  'A3' AS report
  , 2015 AS year
  , 0 AS quarter
  , (SELECT prto_unlocode FROM tbl_puerto_prto WHERE prto_pk = estd_subp_pk) AS port
  , d0
  , (SELECT prmt_parametro FROM tbl_parametro_prmt WHERE prmt_pk = d1) AS d1
  , (SELECT prmt_parametro FROM tbl_parametro_prmt WHERE prmt_pk = d2) AS d2
  , (SELECT prmt_parametro FROM tbl_parametro_prmt WHERE prmt_pk = d3) AS d3
  , d4
FROM (
SELECT 
    estd_subp_pk, d0, d1, d2, d3, SUM(d4) AS d4
FROM c_mm_eee 
WHERE 
    EXISTS (
        SELECT 1 FROM tbl_periodo_proceso_pepr
        WHERE pepr_pk = estd_pepr_pk
            AND pepr_anio = 2015
    )
GROUP BY estd_subp_pk, d0, d1, d2, d3
)
ORDER BY report, year, quarter, port, d1, d0, d2, d3
;

SELECT * FROM c_mm_eee;

DROP TABLE c_mm_eee;

CREATE TABLE c_mm_eee AS
    SELECT estd_pepr_pk, estd_subp_pk
        , (SELECT pepr_freferencia FROM tbl_periodo_proceso_pepr WHERE pepr_pk = estd_pepr_pk) AS estd_fref
        
        , (SELECT esdt_cadena FROM tbl_estadistica_dato_esdt 
            WHERE esdt_estd_pk = estd_pk AND esdt_tpdt_pk = portico.gettipodato('DIREC_MERC')) AS d0
        , (SELECT esdt_prmt_pk FROM tbl_estadistica_dato_esdt 
            WHERE esdt_estd_pk = estd_pk AND esdt_tpdt_pk = portico.getTipoDato('UNLOCODE')) AS d1
        , (SELECT esdt_prmt_pk FROM tbl_estadistica_dato_esdt 
            WHERE esdt_estd_pk = estd_pk AND esdt_tpdt_pk = portico.getTipoDato('UNIDAD_CARGA')) AS d2
        , (SELECT esdt_prmt_pk FROM tbl_estadistica_dato_esdt 
            WHERE esdt_estd_pk = estd_pk AND esdt_tpdt_pk = portico.gettipodato('GRUPO_NST')) AS d3
        , (SELECT esdt_ndecimal FROM tbl_estadistica_dato_esdt 
            WHERE esdt_estd_pk = estd_pk AND esdt_tpdt_pk = portico.gettipodato('DECIMAL_01')) AS d4
    FROM tbl_estadistica_estd
    WHERE estd_tpes_pk = portico.getentidad('MOVIMIENTO_MERCANCIA_EEE')
;


SELECT c0, c1, c2, c3, c4, c5, c6, c7, c8, sum(c9)
FROM (
SELECT 
    'B1' AS c0
    , pepr_anio AS c1
    , 0 AS c2
    , (SELECT prto_unlocode FROM tbl_puerto_prto WHERE prto_pk = estd_subp_pk) AS c3
    , (
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
    ) AS c4
    , (
        SELECT prmt_parametro FROM tbl_parametro_prmt
        WHERE 
            prmt_pk = (
                SELECT esdt_prmt_pk
                FROM tbl_estadistica_dato_esdt
                WHERE esdt_estd_pk = estd_pk
                    AND esdt_tpdt_pk = portico.getTipoDato('UNLOCODE')
            )
    ) AS c5
    , (
        SELECT prmt_parametro FROM tbl_parametro_prmt
        WHERE 
            prmt_pk = (
                SELECT prdt_prmt_pk 
                FROM tbl_parametro_dato_prdt
                WHERE
                    prdt_tpdt_pk = portico.gettipodato('ZONA_COST_EEE')
                    AND prdt_prvr_pk = (
                        SELECT prvr_pk FROM tbl_parametro_version_prvr
                        WHERE prvr_fini <= pepr_freferencia
                            AND (prvr_ffin IS NULL OR prvr_ffin > pepr_freferencia)
                            AND prvr_prmt_pk = (
                                SELECT esdt_prmt_pk
                                FROM tbl_estadistica_dato_esdt
                                WHERE esdt_estd_pk = estd_pk
                                    AND esdt_tpdt_pk = portico.getTipoDato('UNLOCODE')
                            )
                    )
                
            )
    ) AS c6
    , (
        SELECT prdt_cadena FROM tbl_parametro_dato_prdt
        WHERE prdt_tpdt_pk = portico.gettipodato('CADENA_01')
            AND prdt_prvr_pk = (
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
            )
    ) AS c7
    , (
        SELECT prmt_parametro FROM tbl_parametro_prmt
        WHERE 
            prmt_pk = (
                SELECT esdt_prmt_pk
                FROM tbl_estadistica_dato_esdt
                WHERE esdt_estd_pk = estd_pk
                    AND esdt_tpdt_pk = portico.getTipoDato('GRUPO_NST')
            )
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
    AND pepr_mes = 1
) SQL
GROUP BY c0, c1, c2, c3, c4, c5, c6, c7, c8
ORDER BY c0, c1, c2, c3, c4, c5, c6, c7, c8
;








