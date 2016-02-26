TRUNCATE TABLE tbl_estadistica_dato_esdt;
DELETE FROM tbl_estadistica_estd;
DELETE FROM tbl_cuadro_mes_cdms;
DELETE FROM tbl_periodo_proceso_pepr;

SELECT * FROM TBL_PARAMETRO_VERSION_PRVR;

DROP TABLE tbl_c1;

CREATE TABLE tbl_c1 AS 
SELECT estd_pepr_pk, estd_subp_pk
    , (
        SELECT pepr_freferencia FROM tbl_periodo_proceso_pepr
        WHERE pepr_pk = estd_pepr_pk
    ) AS pepr_fref
    , (SELECT esdt_cadena FROM tbl_estadistica_dato_esdt
        WHERE esdt_estd_pk = estd_pk
            AND esdt_tpdt_pk = portico.getTipoDato('TIPO_OP_BL')) AS d1
    , (SELECT esdt_prmt_pk FROM tbl_estadistica_dato_esdt
        WHERE esdt_estd_pk = estd_pk
            AND esdt_tpdt_pk = portico.getTipoDato('UNLOCODE')) AS d2
    , (SELECT esdt_prmt_pk FROM tbl_estadistica_dato_esdt
        WHERE esdt_estd_pk = estd_pk
            AND esdt_tpdt_pk = portico.getTipoDato('UNLOCODE_2')) AS d3
    , (SELECT esdt_prmt_pk FROM tbl_estadistica_dato_esdt
        WHERE esdt_estd_pk = estd_pk
            AND esdt_tpdt_pk = portico.gettipodato('ALIN')) AS d4
    , (SELECT esdt_prmt_pk FROM tbl_estadistica_dato_esdt
        WHERE esdt_estd_pk = estd_pk
            AND esdt_tpdt_pk = portico.gettipodato('UNLOCODE_3')) AS d5
    , (SELECT esdt_prmt_pk FROM tbl_estadistica_dato_esdt
        WHERE esdt_estd_pk = estd_pk
            AND esdt_tpdt_pk = portico.gettipodato('UNLOCODE_4')) AS d6
    , (SELECT esdt_prmt_pk FROM tbl_estadistica_dato_esdt
        WHERE esdt_estd_pk = estd_pk
            AND esdt_tpdt_pk = portico.getTipoDato('MERCANCIA')) AS d7
    , (SELECT esdt_prmt_pk FROM tbl_estadistica_dato_esdt
        WHERE esdt_estd_pk = estd_pk
            AND esdt_tpdt_pk = portico.gettipodato('TIPO_NAV')) AS d8
    , (SELECT esdt_prmt_pk FROM tbl_estadistica_dato_esdt
        WHERE esdt_estd_pk = estd_pk
            AND esdt_tpdt_pk = portico.gettipodato('UNIDAD_CARGA')) AS d9
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

CREATE INDEX ix_c1_estd_pepr_pk ON tbl_c1(estd_pepr_pk, estd_subp_pk);

SELECT COUNT(1) FROM tbl_c1;

SELECT * FROM tbl_c1;

SELECT estd_subp_pk
    , d1
    , d2
    , sum(a1), sum(a2), sum(a3)
    , (SELECT prmt_parametro FROM tbl_parametro_prmt WHERE prmt_pk = d2) AS d2_parametro
FROM tbl_c1
WHERE 
    EXISTS (
        SELECT 1
        FROM tbl_periodo_proceso_pepr
        WHERE 
            1 = 1
            AND EXISTS (
                SELECT 1 FROM tbl_superpuerto_sprt
                WHERE sprt_pk = pepr_autp_pk
                    AND sprt_codigo = '63'
            )
/*
*/
            AND pepr_pk = estd_pepr_pk
--            AND pepr_mes = 3 
            AND pepr_anio = 2015
    )
    AND d1 LIKE 'DT'
    AND EXISTS (
        SELECT 1
        FROM tbl_parametro_prmt
        WHERE prmt_pk = d2
            AND prmt_parametro LIKE 'ES%'
    )
GROUP BY estd_subp_pk, d1, d2
ORDER BY estd_subp_pk, d1, d2
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


