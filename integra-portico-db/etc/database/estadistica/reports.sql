SELECT cdms_pepr_pk, cdms_prto_pk, cdms_cocu, cdms_orden, cdms_opet, cdms_navt_pk, cdms_pais_pk, cdms_cantidad
    , (SELECT prto_codigo FROM tbl_puerto_prto WHERE prto_pk = cdms_prto_pk) AS cdms_prto
    , (SELECT prmt_parametro FROM tbl_parametro_prmt WHERE prmt_pk = cdms_navt_pk) AS cdms_navt
    , (SELECT prmt_parametro FROM tbl_parametro_prmt WHERE prmt_pk = cdms_pais_pk) AS cdms_pais
FROM 
    tbl_cuadro_mes_cdms
;









WITH sql AS (
SELECT pepr_autp_pk, pepr_anio, pepr_mes
    , (
        SELECT 
            SUM (
                (
                SELECT esdt_ndecimal
                FROM tbl_estadistica_dato_esdt
                WHERE
                    esdt_tpdt_pk = portico.getTipoDato('DECIMAL_01')
                    AND esdt_estd_pk = estd_pk
                )
            )
        FROM tbl_estadistica_estd
        WHERE 
            estd_tpes_pk = portico.getEntidad('MOVIMIENTO_MERCANCIA')
            AND estd_pepr_pk = pepr_pk
            AND EXISTS (
                SELECT 1 FROM tbl_estadistica_dato_esdt
                WHERE esdt_estd_pk = estd_pk
                    AND esdt_tpdt_pk = portico.getTipoDato('TIPO_OP_BL')
                    AND esdt_cadena IN ('D', 'DT', 'E', 'E', 'T', 'TD', 'TE')
            )
            AND EXISTS (
                SELECT 1 FROM tbl_estadistica_dato_esdt
                WHERE esdt_estd_pk = estd_pk
                    AND esdt_tpdt_pk = portico.getTipoDato('UNIDAD_CARGA')
                    AND esdt_prmt_pk = ANY (
                        SELECT prmt_pk FROM tbl_parametro_prmt
                        WHERE 
                            prmt_tppr_pk = portico.getEntidad('UNIDAD_CARGA')
                            AND prmt_parametro IN ('21', '22', '23', '29')
                    )
            )
            AND EXISTS (
                SELECT 1 FROM tbl_estadistica_dato_esdt
                WHERE esdt_estd_pk = estd_pk
                    AND esdt_tpdt_pk = portico.getTipoDato('TIPO_NAV')
                    AND esdt_prmt_pk = ANY (
                        SELECT prmt_pk FROM tbl_parametro_prmt
                        WHERE 
                            prmt_tppr_pk = portico.getEntidad('TIPO_NAVEGACION')
                            AND prmt_parametro IN ('C', 'CI', 'E', 'EC')
                    )
            )
    ) AS c1
FROM tbl_periodo_proceso_pepr
WHERE 
    pepr_anio IN (2015, 2016)
    AND pepr_mes <= 12
)
SELECT sprt_codigo
    , (SELECT SUM(c1) FROM sql WHERE sprt_pk = sql.pepr_autp_pk AND sql.pepr_anio = 2016 AND sql.pepr_mes = 12) AS c1
    , (SELECT SUM(c1) FROM sql WHERE sprt_pk = sql.pepr_autp_pk AND sql.pepr_anio = 2016 AND sql.pepr_mes <= 12) AS c2
    , (SELECT SUM(c1) FROM sql WHERE sprt_pk = sql.pepr_autp_pk AND sql.pepr_anio = 2015 AND sql.pepr_mes = 12) AS c3
    , (SELECT SUM(c1) FROM sql WHERE sprt_pk = sql.pepr_autp_pk AND sql.pepr_anio = 2015 AND sql.pepr_mes <= 12) AS c4
    , (SELECT SUM(c1) FROM sql WHERE sprt_pk = sql.pepr_autp_pk AND sql.pepr_anio = 2016 AND sql.pepr_mes <= 12) * 100
      / (SELECT SUM(c1) FROM sql WHERE sprt_pk = sql.pepr_autp_pk AND sql.pepr_anio = 2015 AND sql.pepr_mes <= 12) - 100 AS c5
FROM tbl_superpuerto_sprt
-- WHERE sprt_codigo = '60'
;










WITH sql AS (
SELECT pepr_autp_pk, pepr_anio, pepr_mes
    , (
        SELECT 
            SUM (
                (
                SELECT esdt_ndecimal
                FROM tbl_estadistica_dato_esdt
                WHERE
                    esdt_tpdt_pk = portico.getTipoDato('DECIMAL_01')
                    AND esdt_estd_pk = estd_pk
                )
            )
        FROM tbl_estadistica_estd
        WHERE 
            estd_tpes_pk = portico.getEntidad('MOVIMIENTO_MERCANCIA')
            AND estd_pepr_pk = pepr_pk
            AND EXISTS (
                SELECT 1 FROM tbl_estadistica_dato_esdt
                WHERE esdt_estd_pk = estd_pk
                    AND esdt_tpdt_pk = portico.getTipoDato('TIPO_OP_BL')
                    AND esdt_cadena IN ('D', 'DT', 'E', 'E', 'T', 'TD', 'TE')
            )
            AND EXISTS (
                SELECT 1 FROM tbl_estadistica_dato_esdt
                WHERE esdt_estd_pk = estd_pk
                    AND esdt_tpdt_pk = portico.getTipoDato('UNIDAD_CARGA')
                    AND esdt_prmt_pk = ANY (
                        SELECT prmt_pk FROM tbl_parametro_prmt
                        WHERE 
                            prmt_tppr_pk = portico.getEntidad('UNIDAD_CARGA')
                            AND prmt_parametro IN ('11', '12', '13', '19')
                    )
            )
            AND EXISTS (
                SELECT 1 FROM tbl_estadistica_dato_esdt
                WHERE esdt_estd_pk = estd_pk
                    AND esdt_tpdt_pk = portico.getTipoDato('TIPO_NAV')
                    AND esdt_prmt_pk = ANY (
                        SELECT prmt_pk FROM tbl_parametro_prmt
                        WHERE 
                            prmt_tppr_pk = portico.getEntidad('TIPO_NAVEGACION')
                            AND prmt_parametro IN ('C', 'CI', 'E', 'EC')
                    )
            )
    ) AS c1
FROM tbl_periodo_proceso_pepr
WHERE 
    pepr_anio IN (2015, 2016)
    AND pepr_mes <= 12
)
SELECT sprt_codigo
    , (SELECT SUM(c1) FROM sql WHERE sprt_pk = sql.pepr_autp_pk AND sql.pepr_anio = 2016 AND sql.pepr_mes = 12) AS c1
    , (SELECT SUM(c1) FROM sql WHERE sprt_pk = sql.pepr_autp_pk AND sql.pepr_anio = 2016 AND sql.pepr_mes <= 12) AS c2
    , (SELECT SUM(c1) FROM sql WHERE sprt_pk = sql.pepr_autp_pk AND sql.pepr_anio = 2015 AND sql.pepr_mes = 12) AS c3
    , (SELECT SUM(c1) FROM sql WHERE sprt_pk = sql.pepr_autp_pk AND sql.pepr_anio = 2015 AND sql.pepr_mes <= 12) AS c4
    , (SELECT SUM(c1) FROM sql WHERE sprt_pk = sql.pepr_autp_pk AND sql.pepr_anio = 2016 AND sql.pepr_mes <= 12) * 100
      / (SELECT SUM(c1) FROM sql WHERE sprt_pk = sql.pepr_autp_pk AND sql.pepr_anio = 2015 AND sql.pepr_mes <= 12) - 100 AS c5
FROM tbl_superpuerto_sprt
-- WHERE sprt_codigo = '60'
;



SELECT sprt_codigo AS c0
    , (
        SELECT 
            SUM (
                (
                SELECT esdt_ndecimal
                FROM tbl_estadistica_dato_esdt
                WHERE
                    esdt_tpdt_pk = portico.getTipoDato('DECIMAL_01')
                    AND esdt_estd_pk = estd_pk
                )
            )
        FROM tbl_estadistica_estd
        WHERE 
            estd_tpes_pk = portico.getEntidad('MOVIMIENTO_MERCANCIA')
            AND EXISTS (
                SELECT 1 FROM tbl_periodo_proceso_pepr
                WHERE pepr_pk = estd_pepr_pk
                    AND pepr_anio = 2016
                    AND pepr_mes = 2
                    AND pepr_autp_pk = sprt_pk
            )
            AND EXISTS (
                SELECT 1 FROM tbl_estadistica_dato_esdt
                WHERE esdt_estd_pk = estd_pk
                    AND esdt_tpdt_pk = portico.getTipoDato('TIPO_OP_BL')
                    AND esdt_cadena IN ('D', 'DT', 'E', 'E', 'T', 'TD', 'TE')
            )
            AND EXISTS (
                SELECT 1 FROM tbl_estadistica_dato_esdt
                WHERE esdt_estd_pk = estd_pk
                    AND esdt_tpdt_pk = portico.getTipoDato('UNIDAD_CARGA')
                    AND EXISTS (
                        SELECT 1 FROM tbl_parametro_prmt
                        WHERE 
                            prmt_pk = esdt_prmt_pk
                            AND prmt_tppr_pk = portico.getEntidad('UNIDAD_CARGA')
                            AND prmt_parametro IN ('11', '12', '13', '19')
                    )
            )
            AND EXISTS (
                SELECT 1 FROM tbl_estadistica_dato_esdt
                WHERE esdt_estd_pk = estd_pk
                    AND esdt_tpdt_pk = portico.getTipoDato('TIPO_NAV')
                    AND EXISTS (
                        SELECT 1 FROM tbl_parametro_prmt
                        WHERE 
                            prmt_pk = esdt_prmt_pk
                            AND prmt_tppr_pk = portico.getEntidad('TIPO_NAVEGACION')
                            AND prmt_parametro IN ('C', 'CI', 'E', 'EC')
                    )
            )
    ) AS c1
    , (
        SELECT 
            SUM (
                (
                SELECT esdt_ndecimal
                FROM tbl_estadistica_dato_esdt
                WHERE
                    esdt_tpdt_pk = portico.getTipoDato('DECIMAL_01')
                    AND esdt_estd_pk = estd_pk
                )
            )
        FROM tbl_estadistica_estd
        WHERE 
            estd_tpes_pk = portico.getEntidad('MOVIMIENTO_MERCANCIA')
            AND EXISTS (
                SELECT 1 FROM tbl_periodo_proceso_pepr
                WHERE pepr_pk = estd_pepr_pk
                    AND pepr_anio = 2016
                    AND pepr_mes <= 2
                    AND pepr_autp_pk = sprt_pk
            )
            AND EXISTS (
                SELECT 1 FROM tbl_estadistica_dato_esdt
                WHERE esdt_estd_pk = estd_pk
                    AND esdt_tpdt_pk = portico.getTipoDato('TIPO_OP_BL')
                    AND esdt_cadena IN ('D', 'DT', 'E', 'E', 'T', 'TD', 'TE')
            )
            AND EXISTS (
                SELECT 1 FROM tbl_estadistica_dato_esdt
                WHERE esdt_estd_pk = estd_pk
                    AND esdt_tpdt_pk = portico.getTipoDato('UNIDAD_CARGA')
                    AND EXISTS (
                        SELECT 1 FROM tbl_parametro_prmt
                        WHERE 
                            prmt_pk = esdt_prmt_pk
                            AND prmt_tppr_pk = portico.getEntidad('UNIDAD_CARGA')
                            AND prmt_parametro IN ('11', '12', '13', '19')
                    )
            )
            AND EXISTS (
                SELECT 1 FROM tbl_estadistica_dato_esdt
                WHERE esdt_estd_pk = estd_pk
                    AND esdt_tpdt_pk = portico.getTipoDato('TIPO_NAV')
                    AND EXISTS (
                        SELECT 1 FROM tbl_parametro_prmt
                        WHERE 
                            prmt_pk = esdt_prmt_pk
                            AND prmt_tppr_pk = portico.getEntidad('TIPO_NAVEGACION')
                            AND prmt_parametro IN ('C', 'CI', 'E', 'EC')
                    )
            )
    ) AS c2
    , (
        SELECT 
            SUM (
                (
                SELECT esdt_ndecimal
                FROM tbl_estadistica_dato_esdt
                WHERE
                    esdt_tpdt_pk = portico.getTipoDato('DECIMAL_01')
                    AND esdt_estd_pk = estd_pk
                )
            )
        FROM tbl_estadistica_estd
        WHERE 
            estd_tpes_pk = portico.getEntidad('MOVIMIENTO_MERCANCIA')
            AND EXISTS (
                SELECT 1 FROM tbl_periodo_proceso_pepr
                WHERE pepr_pk = estd_pepr_pk
                    AND pepr_anio = 2015
                    AND pepr_mes = 2
                    AND pepr_autp_pk = sprt_pk
            )
            AND EXISTS (
                SELECT 1 FROM tbl_estadistica_dato_esdt
                WHERE esdt_estd_pk = estd_pk
                    AND esdt_tpdt_pk = portico.getTipoDato('TIPO_OP_BL')
                    AND esdt_cadena IN ('D', 'DT', 'E', 'E', 'T', 'TD', 'TE')
            )
            AND EXISTS (
                SELECT 1 FROM tbl_estadistica_dato_esdt
                WHERE esdt_estd_pk = estd_pk
                    AND esdt_tpdt_pk = portico.getTipoDato('UNIDAD_CARGA')
                    AND EXISTS (
                        SELECT 1 FROM tbl_parametro_prmt
                        WHERE 
                            prmt_pk = esdt_prmt_pk
                            AND prmt_tppr_pk = portico.getEntidad('UNIDAD_CARGA')
                            AND prmt_parametro IN ('11', '12', '13', '19')
                    )
            )
            AND EXISTS (
                SELECT 1 FROM tbl_estadistica_dato_esdt
                WHERE esdt_estd_pk = estd_pk
                    AND esdt_tpdt_pk = portico.getTipoDato('TIPO_NAV')
                    AND EXISTS (
                        SELECT 1 FROM tbl_parametro_prmt
                        WHERE 
                            prmt_pk = esdt_prmt_pk
                            AND prmt_tppr_pk = portico.getEntidad('TIPO_NAVEGACION')
                            AND prmt_parametro IN ('C', 'CI', 'E', 'EC')
                    )
            )
    ) AS c3
    , (
        SELECT 
            SUM (
                (
                SELECT esdt_ndecimal
                FROM tbl_estadistica_dato_esdt
                WHERE
                    esdt_tpdt_pk = portico.getTipoDato('DECIMAL_01')
                    AND esdt_estd_pk = estd_pk
                )
            )
        FROM tbl_estadistica_estd
        WHERE 
            estd_tpes_pk = portico.getEntidad('MOVIMIENTO_MERCANCIA')
            AND EXISTS (
                SELECT 1 FROM tbl_periodo_proceso_pepr
                WHERE pepr_pk = estd_pepr_pk
                    AND pepr_anio = 2015
                    AND pepr_mes <= 2
                    AND pepr_autp_pk = sprt_pk
            )
            AND EXISTS (
                SELECT 1 FROM tbl_estadistica_dato_esdt
                WHERE esdt_estd_pk = estd_pk
                    AND esdt_tpdt_pk = portico.getTipoDato('TIPO_OP_BL')
                    AND esdt_cadena IN ('D', 'DT', 'E', 'E', 'T', 'TD', 'TE')
            )
            AND EXISTS (
                SELECT 1 FROM tbl_estadistica_dato_esdt
                WHERE esdt_estd_pk = estd_pk
                    AND esdt_tpdt_pk = portico.getTipoDato('UNIDAD_CARGA')
                    AND EXISTS (
                        SELECT 1 FROM tbl_parametro_prmt
                        WHERE 
                            prmt_pk = esdt_prmt_pk
                            AND prmt_tppr_pk = portico.getEntidad('UNIDAD_CARGA')
                            AND prmt_parametro IN ('11', '12', '13', '19')
                    )
            )
            AND EXISTS (
                SELECT 1 FROM tbl_estadistica_dato_esdt
                WHERE esdt_estd_pk = estd_pk
                    AND esdt_tpdt_pk = portico.getTipoDato('TIPO_NAV')
                    AND EXISTS (
                        SELECT 1 FROM tbl_parametro_prmt
                        WHERE 
                            prmt_pk = esdt_prmt_pk
                            AND prmt_tppr_pk = portico.getEntidad('TIPO_NAVEGACION')
                            AND prmt_parametro IN ('C', 'CI', 'E', 'EC')
                    )
            )
    ) AS c4
FROM tbl_superpuerto_sprt
--WHERE sprt_codigo = '60'
;