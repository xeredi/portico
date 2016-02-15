TRUNCATE TABLE tbl_estadistica_dato_esdt;
DELETE FROM tbl_estadistica_estd;
DELETE FROM tbl_cuadro_mes_cdms;
DELETE FROM tbl_periodo_proceso_pepr;


DELETE FROM tbl_estadistica_dato_esdt
WHERE 
    esdt_estd_pk IN (
        SELECT estd_pk FROM tbl_estadistica_estd
        WHERE estd_pepr_pk = 8097001
    )
    AND esdt_tpdt_pk IS NOT NULL
;

SELECT COUNT(1)
FROM tbl_estadistica_dato_esdt
WHERE 
    EXISTS (
        SELECT 1
        FROM tbl_estadistica_estd
        WHERE estd_pk = esdt_estd_pk
            AND estd_pepr_pk = 8097001 /*11310001, 8097001 */
    )
;

SELECT COUNT(1)
FROM tbl_estadistica_dato_esdt
WHERE 
    esdt_estd_pk = ANY (
        SELECT estd_pk
        FROM tbl_estadistica_estd
        WHERE estd_pepr_pk = 8097001
    )
;

SELECT COUNT(1)
FROM tbl_estadistica_estd
WHERE estd_pepr_pk = 8097001
;

SELECT *
FROM 
    tbl_estadistica_estd
    INNER JOIN tbl_estadistica_dato_esdt ON
        esdt_estd_pk = estd_pk
WHERE 
    estd_pepr_pk = 8097001
;

SELECT *
FROM 
    tbl_estadistica_estd
WHERE 
    estd_pepr_pk = 8097001
;


DELETE FROM (
    SELECT esdt.*
    FROM 
        tbl_estadistica_estd estd
        INNER JOIN tbl_estadistica_dato_esdt esdt ON
            estd_pk = esdt_estd_pk
    WHERE 
        estd_pepr_pk = 8097001
        AND EXISTS (
            SELECT 1
            FROM tbl_tipo_estadistica_tpes
            WHERE
                tpes_pk = estd_tpes_pk
        )
) sql
;



INSERT INTO tbl_cuadro_mes_cdms( 
    cdms_pepr_pk, cdms_prto_pk, cdms_cocu, cdms_orden, cdms_opet, cdms_navt_pk, cdms_pais_pk, cdms_cantidad 
) 
;


SELECT COUNT(1)
FROM TBL_ESTADISTICA_ESTD;
SELECT COUNT(1)
FROM TBL_ESTADISTICA_DATO_ESDT;

SELECT pepr_pk, prto_pk
    , COALESCE((
            SELECT 
                SUM(
                    (
                        SELECT esdt_ndecimal
                        FROM tbl_estadistica_dato_esdt
                        WHERE 
                            esdt_estd_pk = estd_pk
                            AND esdt_tpdt_pk = 41040 
                    )
                )
            FROM tbl_estadistica_estd
            WHERE 
                estd_pepr_pk = pepr_pk 
                AND estd_subp_pk = prto_pk 
                AND estd_tpes_pk = 23005
                AND EXISTS (
                    SELECT 1 FROM tbl_estadistica_dato_esdt
                    WHERE
                        estd_pk = esdt_estd_pk
                        AND esdt_tpdt_pk = portico.getTipoDato('TIPO_OP_BL')
                        AND esdt_cadena LIKE 'DT'
                )
                AND EXISTS (
                  SELECT 1 FROM tbl_estadistica_dato_esdt
                    WHERE
                        estd_pk = esdt_estd_pk
                        AND esdt_tpdt_pk = portico.getTipoDato('TIPO_NAV')
                        AND EXISTS (
                            SELECT 1 FROM tbl_parametro_prmt
                            WHERE prmt_pk = esdt_prmt_pk
                                AND prmt_tppr_pk = portico.getEntidad('TIPO_NAVEGACION')
                                AND prmt_parametro LIKE 'C%'
                                AND (prmt_prto_pk IS NULL OR prmt_prto_pk = prto_pk)
                        )
                )
                AND EXISTS (
                  SELECT 1 FROM tbl_estadistica_dato_esdt
                    WHERE
                        estd_pk = esdt_estd_pk
                        AND esdt_tpdt_pk = portico.getTipoDato('INST_ESP')
                        AND EXISTS (
                            SELECT 1 FROM tbl_parametro_prmt
                            WHERE prmt_pk = esdt_prmt_pk
                                AND prmt_tppr_pk = portico.getEntidad('INSTALACION_ESPECIAL')
                                AND prmt_parametro LIKE '**************N'
                                AND (prmt_prto_pk IS NULL OR prmt_prto_pk = prto_pk)
                        )
                )
                AND EXISTS (
                  SELECT 1 FROM tbl_estadistica_dato_esdt
                    WHERE
                        estd_pk = esdt_estd_pk
                        AND esdt_tpdt_pk = portico.getTipoDato('UNIDAD_CARGA')
                        AND EXISTS (
                            SELECT 1 FROM tbl_parametro_version_prvr
                            WHERE prvr_prmt_pk = esdt_prmt_pk
                              AND prvr_fini <= pepr_freferencia AND (prvr_ffin IS NULL OR prvr_ffin > pepr_freferencia)
                              AND EXISTS (
                                SELECT 1 FROM tbl_parametro_dato_prdt
                                WHERE prdt_prvr_pk = prvr_pk
                                  AND prdt_tpdt_pk = portico.getTipoDato('TIPO_MERC_EST')
                                  AND EXISTS (
                                    SELECT 1 FROM tbl_parametro_prmt
                                    WHERE prmt_pk = prdt_prmt_pk
                                        AND prmt_tppr_pk = portico.getEntidad('TIPO_MERCANCIA_EST')
                                        AND prmt_parametro LIKE 'SG'
                                        AND (prmt_prto_pk IS NULL OR prmt_prto_pk = prto_pk)
                                  )
                              )
                        )
                )
    ), 0) AS value
FROM 
    tbl_puerto_prto
    INNER JOIN tbl_periodo_proceso_pepr ON
        pepr_autp_pk = prto_sprt_pk
WHERE
    pepr_pk = 8097001 
;







SELECT pepr_pk, prto_pk , 'GLPETR', 8, 'E' 
    , (SELECT prmt_pk FROM tbl_parametro_prmt WHERE prmt_tppr_pk = portico.getEntidad('TIPO_NAVEGACION') AND prmt_parametro = 'C') AS navt_pk 
    , (SELECT prmt_pk FROM tbl_parametro_prmt WHERE prmt_tppr_pk = portico.getEntidad('PAIS') AND prmt_parametro = 'ZZ') AS pais_pk 
    , COALESCE(
        ( 
            SELECT SUM(COALESCE(esdt_ndecimal, 0)) 
            FROM tbl_estadistica_dato_esdt INNER JOIN tbl_estadistica_estd ON 
                estd_pk = esdt_estd_pk 
            WHERE estd_pepr_pk = pepr_pk 
                AND estd_tpes_pk = 23005 
                AND estd_subp_pk = prto_pk 
                AND esdt_tpdt_pk = 41040 
                
                AND EXISTS (
                    SELECT 1 FROM tbl_estadistica_dato_esdt
                    WHERE
                        estd_pk = esdt_estd_pk
                        AND esdt_tpdt_pk = portico.getTipoDato('TIPO_OP_BL')
                        AND esdt_cadena LIKE 'DT'
                )
                AND EXISTS (
                  SELECT 1 FROM tbl_estadistica_dato_esdt
                    WHERE
                        estd_pk = esdt_estd_pk
                        AND esdt_tpdt_pk = portico.getTipoDato('TIPO_NAV')
                        AND EXISTS (
                            SELECT 1 FROM tbl_parametro_prmt
                            WHERE prmt_pk = esdt_prmt_pk
                                AND prmt_tppr_pk = portico.getEntidad('TIPO_NAVEGACION')
                                AND prmt_parametro LIKE 'C%'
                                AND (prmt_prto_pk IS NULL OR prmt_prto_pk = prto_pk)
                        )
                )
                AND EXISTS (
                  SELECT 1 FROM tbl_estadistica_dato_esdt
                    WHERE
                        estd_pk = esdt_estd_pk
                        AND esdt_tpdt_pk = portico.getTipoDato('INST_ESP')
                        AND EXISTS (
                            SELECT 1 FROM tbl_parametro_prmt
                            WHERE prmt_pk = esdt_prmt_pk
                                AND prmt_tppr_pk = portico.getEntidad('INSTALACION_ESPECIAL')
                                AND prmt_parametro LIKE '**************N'
                                AND (prmt_prto_pk IS NULL OR prmt_prto_pk = prto_pk)
                        )
                )
                AND EXISTS (
                  SELECT 1 FROM tbl_estadistica_dato_esdt
                    WHERE
                        estd_pk = esdt_estd_pk
                        AND esdt_tpdt_pk = portico.getTipoDato('UNIDAD_CARGA')
                        AND EXISTS (
                            SELECT 1 FROM tbl_parametro_version_prvr
                            WHERE prvr_prmt_pk = esdt_prmt_pk
                              AND prvr_fini <= pepr_freferencia AND (prvr_ffin IS NULL OR prvr_ffin > pepr_freferencia)
                              AND EXISTS (
                                SELECT 1 FROM tbl_parametro_dato_prdt
                                WHERE prdt_prvr_pk = prvr_pk
                                  AND prdt_tpdt_pk = portico.getTipoDato('TIPO_MERC_EST')
                                  AND EXISTS (
                                    SELECT 1 FROM tbl_parametro_prmt
                                    WHERE prmt_pk = prdt_prmt_pk
                                        AND prmt_tppr_pk = portico.getEntidad('TIPO_MERCANCIA_EST')
                                        AND prmt_parametro LIKE 'SG'
                                        AND (prmt_prto_pk IS NULL OR prmt_prto_pk = prto_pk)
                                  )
                              )
                        )
                )
/*                
*/
        )
        , 0
    ) AS value 
FROM tbl_periodo_proceso_pepr 
    INNER JOIN tbl_puerto_prto ON 
        prto_sprt_pk = pepr_autp_pk 
WHERE pepr_pk = 8097001 
;
