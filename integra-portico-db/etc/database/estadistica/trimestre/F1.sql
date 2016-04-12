SELECT c0, c1, c2, c3, c4, c5, c6, sum(c7), sum(c8)
FROM (
SELECT 
    'F2' AS c0
    , pepr_anio AS c1
    , pepr_trimestre AS c2
    , (SELECT prto_unlocode FROM tbl_puerto_prto WHERE prto_pk = estd_subp_pk) AS c3
    , 1 AS c4
    , (
        SELECT prmt_parametro FROM tbl_parametro_prmt
        WHERE 
            prmt_pk = (
                SELECT esdt_prmt_pk
                FROM tbl_estadistica_dato_esdt
                WHERE esdt_estd_pk = estd_pk
                    AND esdt_tpdt_pk = portico.getTipoDato('TIPO_BUQUE_EEE')
            )
    ) AS c5
    , (
        SELECT prmt_parametro FROM tbl_parametro_prmt
        WHERE 
            prmt_pk = (
                SELECT esdt_prmt_pk
                FROM tbl_estadistica_dato_esdt
                WHERE esdt_estd_pk = estd_pk
                    AND esdt_tpdt_pk = portico.getTipoDato('TIPO_BUQUE_GT_EEE')
            )
    ) AS c6
    , (
        SELECT esdt_nentero
        FROM tbl_estadistica_dato_esdt
        WHERE esdt_estd_pk = estd_pk
            AND esdt_tpdt_pk = portico.getTipoDato('ENTERO_01')
    ) AS c7
    , (
        SELECT esdt_nentero
        FROM tbl_estadistica_dato_esdt
        WHERE esdt_estd_pk = estd_pk
            AND esdt_tpdt_pk = portico.getTipoDato('ENTERO_02')
    ) AS c8
FROM tbl_estadistica_estd
    INNER JOIN tbl_periodo_proceso_pepr ON
        pepr_pk = estd_pepr_pk
WHERE
    estd_tpes_pk = portico.getentidad('MOVIMIENTO_TIPO_BUQUE_EEE')
    AND pepr_anio = 2015
    AND pepr_trimestre = 1
) SQL
GROUP BY c0, c1, c2, c3, c4, c5, c6
ORDER BY c0, c1, c2, c3, c4, c5, c6
;
