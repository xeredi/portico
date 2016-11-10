-- // 0 0 2 Facturacion Funciones
-- Migration SQL that makes the change goes here.

create or replace FUNCTION acumuladoTeus(consignatario VARCHAR, fini VARCHAR, ffin DATE) RETURN integer RESULT_CACHE IS
	resultValue integer;
BEGIN
SELECT
    COALESCE(SUM(
        COALESCE(unidades, 0) * COALESCE((
            SELECT prdt_ndecimal FROM tbl_parametro_dato_prdt
            WHERE prdt_tpdt_pk = portico.getTipoDato('DECIMAL_01')
                AND prdt_prvr_pk = (
                    SELECT prvr_pk FROM tbl_parametro_version_prvr
                    WHERE prvr_prmt_pk = unic_prmt_pk
                        AND srvc_fref BETWEEN prvr_fini AND COALESCE(prvr_ffin, srvc_fref)
                )
        ), 0)
    ), 0) INTO resultValue
--    , SUM(unidades) AS unidades
FROM (
SELECT
    (
        SELECT srvc_fref
        FROM tbl_servicio_srvc
        WHERE srvc_pk = ssrv_srvc_pk
    ) AS srvc_fref
    , (
      SELECT
          CASE
            WHEN ssdt_nentero IS NULL OR ssdt_nentero = 0
            THEN 1
            ELSE ssdt_nentero
          END
      FROM tbl_subservicio_dato_ssdt
      WHERE ssdt_ssrv_pk = ssrv_pk
          AND ssdt_tpdt_pk = portico.getTipoDato('ENTERO_01')
    ) AS unidades
    , (
        SELECT ssdt_prmt_pk
        FROM tbl_subservicio_dato_ssdt
        WHERE ssdt_ssrv_pk = ssrv_pk
            AND ssdt_tpdt_pk = portico.getTipoDato('UNIDAD_CARGA')
    ) AS unic_prmt_pk
FROM
    tbl_subservicio_ssrv
WHERE
    ssrv_tpss_pk = portico.getEntidad('EQUIPAMIENTO')

    AND EXISTS (
        SELECT 1
        FROM tbl_subservicio_dato_ssdt
        WHERE ssdt_ssrv_pk = ssrv_pk
            AND ssdt_tpdt_pk = portico.getTipoDato('UNIDAD_CARGA')
            AND EXISTS (
                SELECT 1
                FROM tbl_parametro_prmt
                WHERE
                    prmt_pk = ssdt_prmt_pk
                    AND prmt_parametro LIKE '3%'
            )
    )

    AND EXISTS (
        SELECT 1
        FROM tbl_subservicio_dato_ssdt
        WHERE ssdt_ssrv_pk = ssrv_pk
            AND ssdt_tpdt_pk = portico.getTipoDato('CADENA_02')
            AND ssdt_cadena IN ('4', '7', '8')
    )

    AND EXISTS (
        SELECT 1 FROM tbl_subserv_subserv_ssss
        WHERE ssss_ssrvh_pk = ssrv_pk
            AND EXISTS (
                SELECT 1 FROM tbl_subservicio_ssrv
                WHERE ssrv_pk = ssss_ssrvp_pk
                    AND ssrv_tpss_pk = portico.getEntidad('BL')
                    AND EXISTS (
                        SELECT 1 FROM tbl_subserv_subserv_ssss
                        WHERE ssss_ssrvh_pk = ssrv_pk
                            AND EXISTS (
                                SELECT 1 FROM tbl_subservicio_ssrv
                                WHERE ssrv_pk = ssss_ssrvp_pk
                                    AND ssrv_tpss_pk = portico.getEntidad('MANIFIESTO_CONSIGNATARIO')
                                    AND EXISTS (
                                        SELECT 1
                                        FROM tbl_subservicio_dato_ssdt
                                        WHERE ssdt_ssrv_pk = ssrv_pk
                                            AND ssdt_tpdt_pk = portico.getTipoDato('ORGA')
                                            AND EXISTS (
                                                SELECT 1 FROM tbl_parametro_prmt
                                                WHERE prmt_pk = ssdt_prmt_pk
                                                    AND prmt_parametro = consignatario
                                                                                   )
                                    )
                            )
                    )
            )
    )

    AND EXISTS (
        SELECT 1
        FROM tbl_servicio_srvc
        WHERE
            srvc_pk = ssrv_srvc_pk
            AND srvc_tpsr_pk = portico.getEntidad('MANIFIESTO')
            AND srvc_fref >= TO_DATE(fini, 'DDMMYYYY')
            AND srvc_fref < ffin
            AND EXISTS (
                SELECT 1
                FROM tbl_valoracion_vlrc
                WHERE vlrc_srvc_pk = srvc_pk
            )
    )

    AND EXISTS (
        SELECT 1
        FROM tbl_valoracion_det_vlrd
        WHERE vlrd_ssrv_pk = ssrv_pk
    )
) sql
;
RETURN resultValue;
END;
\

CREATE OR REPLACE SYNONYM portico.acumuladoTeus FOR acumuladoTeus\

GRANT EXECUTE ON acumuladoTeus TO portico\








create or replace FUNCTION acumuladoToneladas(consignatario VARCHAR, fini VARCHAR, ffin DATE) RETURN integer RESULT_CACHE IS
	resultValue integer;
BEGIN
    SELECT SUM(ssdt_nentero) / 1000 INTO resultValue
    FROM tbl_subservicio_dato_ssdt
    WHERE
        ssdt_tpdt_pk = portico.getTipoDato('ENTERO_04')
        AND EXISTS (
            SELECT 1
            FROM tbl_subserv_subserv_ssss ssssBlPart
            WHERE
                ssssBlPart.ssss_ssrvh_pk = ssdt_ssrv_pk
                AND EXISTS (
                    SELECT 1 FROM tbl_subservicio_ssrv
                    WHERE ssrv_pk = ssssBlPart.ssss_ssrvh_pk
                        AND ssrv_tpss_pk = portico.getEntidad('PARTIDA')
                )
                AND EXISTS (
                    SELECT 1
                    FROM tbl_subserv_subserv_ssss ssssMacoBl
                    WHERE
                        ssssMacoBl.ssss_ssrvh_pk = ssssBlPart.ssss_ssrvp_pk
                        AND EXISTS (
                            SELECT 1
                            FROM tbl_subservicio_ssrv
                            WHERE
                                ssrv_pk = ssss_ssrvp_pk
                                AND ssrv_tpss_pk = portico.getEntidad('MANIFIESTO_CONSIGNATARIO')

                                AND EXISTS (
                                    SELECT 1 FROM tbl_subservicio_dato_ssdt
                                    WHERE ssdt_ssrv_pk = ssrv_pk
                                        AND ssdt_tpdt_pk = portico.getTipoDato('ORGA')
                                        AND ssdt_prmt_pk = (
                                        	SELECT prmt_pk FROM tbl_parametro_prmt
                                        	WHERE prmt_tppr_pk = portico.getEntidad('ORGANIZACION')
                                        		AND prmt_parametro = consignatario
                                        )
                                )

                                AND EXISTS (
                                    SELECT 1 FROM tbl_servicio_srvc
                                    WHERE
                                        srvc_pk = ssrv_srvc_pk
                                        AND srvc_fref >= TO_DATE(fini, 'DDMMYYYY')
                                        AND srvc_fref < ffin
                                        AND srvc_tpsr_pk = portico.getEntidad('MANIFIESTO')
                                )
                        )
                )
        )
    ;

    RETURN resultValue;
END;
\

CREATE OR REPLACE SYNONYM portico.acumuladoToneladas FOR acumuladoToneladas\

GRANT EXECUTE ON acumuladoToneladas TO portico\












create or replace FUNCTION valorServicio(tipoServTraf VARCHAR, blId INTEGER) RETURN VARCHAR RESULT_CACHE IS
	resultValue VARCHAR(100);
BEGIN
SELECT spdt_cadena INTO resultValue
FROM tbl_subparametro_dato_spdt
WHERE
    spdt_tpdt_pk = portico.getTipoDato('CADENA_01')
    AND spdt_spvr_pk = (
        SELECT spvr_pk
        FROM tbl_subparametro_version_spvr
        WHERE
            spvr_sprm_pk = (
                SELECT sprm_pk
                FROM tbl_subparametro_sprm
                WHERE
                    sprm_tpsp_pk = portico.getEntidad('TIPO_SERV_TIPO_TRAF')
                    AND sprm_prmt_pk = (
                        SELECT prmt_pk FROM tbl_parametro_prmt
                        WHERE prmt_tppr_pk = portico.getEntidad('TIPO_SERVICIO_TRAFICO')
                            AND prmt_parametro = tipoServTraf
                    )
                    AND sprm_prmt_dep_pk = (
                        SELECT ssdt_prmt_pk FROM tbl_subservicio_dato_ssdt
                        WHERE ssdt_tpdt_pk = portico.getTipoDato('SERV_TRAF')
                            AND ssdt_ssrv_pk = blId
                    )
            )
            AND EXISTS (
                SELECT 1
                FROM tbl_servicio_srvc
                WHERE
                    srvc_pk = (
                        SELECT ssrv_srvc_pk
                        FROM tbl_subservicio_ssrv
                        WHERE ssrv_pk = blId
                    )
                    AND srvc_fref BETWEEN spvr_fini AND COALESCE(spvr_ffin, srvc_fref)
            )
    );

    RETURN resultValue;
END;
\

CREATE OR REPLACE SYNONYM portico.valorServicio FOR valorServicio\

GRANT EXECUTE ON valorServicio TO portico\






-- //@UNDO
-- SQL to undo the change goes here.


DROP FUNCTION valorServicio\
DROP FUNCTION acumuladoToneladas\
DROP FUNCTION acumuladoTeus\
