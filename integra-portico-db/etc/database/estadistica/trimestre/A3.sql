SELECT c0, c1, c2, c3, c4, sum(c5), sum(c6), sum(c7), sum(c8)
FROM (
SELECT 
    'A3' AS c0
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
        SELECT esdt_ndecimal
        FROM tbl_estadistica_dato_esdt
        WHERE esdt_estd_pk = estd_pk
            AND esdt_tpdt_pk = portico.getTipoDato('DECIMAL_01')
    ) AS c5
    , (
        SELECT esdt_nentero
        FROM tbl_estadistica_dato_esdt
        WHERE esdt_estd_pk = estd_pk
            AND esdt_tpdt_pk = portico.getTipoDato('ENTERO_01')
    ) AS c6
    , (
        SELECT esdt_nentero
        FROM tbl_estadistica_dato_esdt
        WHERE esdt_estd_pk = estd_pk
            AND esdt_tpdt_pk = portico.getTipoDato('ENTERO_02')
    ) AS c7
    , (
        SELECT esdt_nentero
        FROM tbl_estadistica_dato_esdt
        WHERE esdt_estd_pk = estd_pk
            AND esdt_tpdt_pk = portico.getTipoDato('ENTERO_03')
    ) AS c8
FROM tbl_estadistica_estd
WHERE
    estd_tpes_pk = portico.getentidad('MOVIMIENTO_MERCANCIA_EEE')
    AND estd_pepr_pk = ANY (
        SELECT pepr_pk FROM tbl_periodo_proceso_pepr 
        WHERE pepr_anio = 2015
    )
) SQL
GROUP BY c0, c1, c2, c3, c4
ORDER BY c0, c1, c2, c3, c4
;








