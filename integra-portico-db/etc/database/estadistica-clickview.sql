TRUNCATE TABLE tbl_estadistica_dato_esdt;
DELETE FROM tbl_estadistica_estd;
DELETE FROM tbl_cuadro_mes_cdms;
DELETE FROM tbl_periodo_proceso_pepr;

SELECT * FROM TBL_PARAMETRO_VERSION_PRVR;

DROP TABLE tbl_c1;

CREATE TABLE tbl_c1 AS 
SELECT estd_pepr_pk, estd_subp_pk
    , (SELECT esdt_prmt_pk FROM tbl_estadistica_dato_esdt
        WHERE esdt_estd_pk = estd_pk
            AND esdt_tpdt_pk = portico.getTipoDato('UNIDAD_CARGA')) AS d1
    , (SELECT esdt_ndecimal FROM tbl_estadistica_dato_esdt
        WHERE esdt_estd_pk = estd_pk
            AND esdt_tpdt_pk = portico.getTipoDato('DECIMAL_01')) AS a1
    , (SELECT esdt_ndecimal FROM tbl_estadistica_dato_esdt
        WHERE esdt_estd_pk = estd_pk
            AND esdt_tpdt_pk = portico.getTipoDato('ENTERO_01')) AS a2
    , (SELECT esdt_ndecimal FROM tbl_estadistica_dato_esdt
        WHERE esdt_estd_pk = estd_pk
            AND esdt_tpdt_pk = portico.getTipoDato('DECIMAL_02')) AS a3
FROM tbl_estadistica_estd
WHERE estd_tpes_pk = portico.getEntidad('MOVIMIENTO_MERCANCIA')
;

CREATE INDEX ix_c1_estd_pepr_pk ON tbl_c1(estd_pepr_pk);

SELECT COUNT(1) FROM tbl_c1;

SELECT * FROM tbl_c1;

SELECT estd_subp_pk, d1, SUM(a1), SUM(a2), SUM(a3)
FROM tbl_c1
WHERE 
    EXISTS (
        SELECT 1
        FROM tbl_periodo_proceso_pepr
        WHERE 
            pepr_pk = estd_pepr_pk
            AND pepr_mes = 3 
            AND pepr_anio = 2015
    )
GROUP BY estd_subp_pk, d1
ORDER BY estd_subp_pk, d1
;

SELECT sprt_pk, prmt_pk AS d1
    , (
        SELECT SUM(esdt_ndecimal)
        FROM tbl_estadistica_dato_esdt
        WHERE esdt_tpdt_pk = portico.getTipoDato('DECIMAL_01')
            AND EXISTS (
                SELECT 1 FROM tbl_estadistica_estd
                WHERE estd_pk = esdt_estd_pk
                    AND estd_tpes_pk = portico.getEntidad('MOVIMIENTO_MERCANCIA')
                    AND EXISTS (
                        SELECT 1 FROM tbl_periodo_proceso_pepr
                        WHERE pepr_pk = estd_pepr_pk
                            AND pepr_autp_pk = sprt_pk
                            AND pepr_anio = 2015
                            AND pepr_mes = 3
                    )
            )
    )
FROM 
    tbl_superpuerto_sprt
    , tbl_parametro_prmt
WHERE 
    prmt_tppr_pk = portico.getEntidad('UNIDAD_CARGA')
;


SELECT estd_subp_pk, d1, SUM(a1)
FROM (
    SELECT estd_subp_pk
        , (
            SELECT esdt_prmt_pk
            FROM tbl_estadistica_dato_esdt
            WHERE esdt_estd_pk = estd_pk
                AND esdt_tpdt_pk = portico.getTipoDato('UNIDAD_CARGA')
        ) AS d1
        , (
            SELECT esdt_ndecimal
            FROM tbl_estadistica_dato_esdt
            WHERE esdt_estd_pk = estd_pk
                AND esdt_tpdt_pk = portico.getTipoDato('DECIMAL_01')
        ) AS a1
    FROM tbl_estadistica_estd
    WHERE 
        EXISTS (
            SELECT 1 FROM tbl_periodo_proceso_pepr
            WHERE pepr_pk = estd_pepr_pk
                AND pepr_anio = 2015
                AND pepr_mes = 3
                AND pepr_autp_pk = 
        )
        AND estd_tpes_pk = portico.getEntidad('MOVIMIENTO_MERCANCIA')
) sql
GROUP BY estd_subp_pk, d1
;


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
    AND pepr_mes = 2
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
/*
*/
) sql
GROUP BY estd_subp_pk, d1
ORDER BY estd_subp_pk, d1
;



