-- // 0 0 2 Facturacion Funciones
-- Migration SQL that makes the change goes here.

create or replace FUNCTION acumuladoTeus(consignatario VARCHAR, fini VARCHAR, ffin DATE) RETURN integer IS
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








create or replace FUNCTION acumuladoToneladas(consignatario VARCHAR, fini VARCHAR, ffin DATE) RETURN integer IS
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

    RETURN COALESCE(resultValue, 0);
END;
\

CREATE OR REPLACE SYNONYM portico.acumuladoToneladas FOR acumuladoToneladas\

GRANT EXECUTE ON acumuladoToneladas TO portico\












create or replace FUNCTION valorServicio(tipoServTraf VARCHAR, servTraf VARCHAR, srvcId INTEGER) RETURN VARCHAR IS
	resultValue VARCHAR(100);
BEGIN
	SELECT (
	    SELECT spdt_cadena
	    FROM tbl_subparametro_dato_spdt
	    WHERE
	        spdt_tpdt_pk = portico.getTipoDato('CADENA_01')
	        AND spdt_spvr_pk = (
	            SELECT spvr_pk FROM tbl_subparametro_version_spvr
	            WHERE
	                spvr_fini <= srvc_fref
	                AND (spvr_ffin IS NULL OR spvr_ffin > srvc_fref)
	                AND spvr_sprm_pk = (
	                    SELECT sprm_pk FROM tbl_subparametro_sprm
	                    WHERE
	                        sprm_tpsp_pk = portico.getEntidad('TIPO_SERV_TIPO_TRAF')
	                        AND sprm_prmt_dep_pk = (
	                            SELECT prmt_pk FROM tbl_parametro_prmt
	                            WHERE
	                                prmt_tppr_pk = portico.getEntidad('SERVICIO_TRAFICO')
	                                AND prmt_parametro = servTraf
	                                AND srvc_subp_pk = prmt_prto_pk
	                                AND EXISTS (
	                                    SELECT 1 FROM tbl_parametro_version_prvr
	                                    WHERE prvr_prmt_pk = prmt_pk
	                                        AND prvr_fini <= srvc_fref
	                                        AND (prvr_ffin IS NULL OR prvr_ffin > srvc_fref)
	                                )
	                        )
	                        AND sprm_prmt_pk = (
	                            SELECT prmt_pk FROM tbl_parametro_prmt
	                            WHERE
	                                prmt_tppr_pk = portico.getEntidad('TIPO_SERVICIO_TRAFICO')
	                                AND prmt_parametro = tipoServTraf
	                                AND EXISTS (
	                                    SELECT 1 FROM tbl_parametro_version_prvr
	                                    WHERE prvr_prmt_pk = prmt_pk
	                                        AND prvr_fini <= srvc_fref
	                                        AND (prvr_ffin IS NULL OR prvr_ffin > srvc_fref)
	                                )
	                        )
	                )
	        )
	) INTO resultValue
	FROM tbl_servicio_srvc
	WHERE srvc_pk = srvcId
    ;

    RETURN COALESCE(resultValue, 'N');
END;
\

CREATE OR REPLACE SYNONYM portico.valorServicio FOR valorServicio\

GRANT EXECUTE ON valorServicio TO portico\










CREATE OR REPLACE FUNCTION generaBOEscala(srvcId INTEGER) RETURN INTEGER IS
	resultValue INTEGER;
BEGIN
    WITH sql AS (
        SELECT srvc_pk, srvc_anno, srvc_tpsr_pk
            , (
                SELECT srdt_prmt_pk
                FROM tbl_servicio_dato_srdt
                WHERE
                    srdt_srvc_pk = srvc_pk
                    AND srdt_tpdt_pk = portico.getTipoDato('BUQUE')
            ) AS buque
            , (
                SELECT COUNT(1)
                FROM tbl_valoracion_vlrc
                WHERE
                    vlrc_srvc_pk = srvc_pk
                    AND EXISTS (
                        SELECT 1
                        FROM tbl_valoracion_lin_vlrl
                        WHERE
                            vlrl_vlrc_pk = vlrc_pk
                            AND EXISTS (
                                SELECT 1
                                FROM tbl_regla_rgla
                                WHERE rgla_pk = vlrl_rgla_pk
                                    AND EXISTS (
                                        SELECT 1
                                        FROM tbl_cargo_crgo
                                        WHERE crgo_pk = rgla_crgo_pk
                                            AND crgo_tpsr_pk = srvc_tpsr_pk
                                            AND crgo_codigo = 'B0'
    /*
    */
                                    )
                            )
                    )
            ) AS b0Valorada
        FROM tbl_servicio_srvc
        WHERE
            srvc_tpsr_pk = portico.getEntidad('ESCALA')
            AND srvc_pk = srvcId
    )
    SELECT (
        CASE
            WHEN b0Valorada > 0
            THEN 0
            ELSE
                CASE
                    WHEN
                        (
                          SELECT COUNT(1)
                          FROM tbl_servicio_srvc srvc
                          WHERE
                              srvc.srvc_tpsr_pk = sql.srvc_tpsr_pk
                              AND srvc.srvc_anno = sql.srvc_anno
                              AND EXISTS (
                                  SELECT 1
                                  FROM tbl_servicio_dato_srdt
                                  WHERE
                                      srdt_srvc_pk = srvc.srvc_pk
                                      AND srdt_tpdt_pk = portico.getTipoDato('BUQUE')
                                      AND srdt_prmt_pk = sql.buque
                              )
                              AND EXISTS (
                                  SELECT 1
                                  FROM tbl_valoracion_vlrc
                                  WHERE
                                      vlrc_srvc_pk = srvc.srvc_pk
                                      AND EXISTS (
                                          SELECT 1
                                          FROM tbl_valoracion_lin_vlrl
                                          WHERE
                                              vlrl_vlrc_pk = vlrc_pk
                                              AND EXISTS (
                                                  SELECT 1
                                                  FROM tbl_regla_rgla
                                                  WHERE rgla_pk = vlrl_rgla_pk
                                                      AND EXISTS (
                                                          SELECT 1
                                                          FROM tbl_cargo_crgo
                                                          WHERE crgo_pk = rgla_crgo_pk
                                                              AND crgo_tpsr_pk = srvc_tpsr_pk
                                                              AND crgo_codigo = 'B0'
                                                      )
                                              )
                                      )
                              )

                      ) > 2
                  THEN 0
                  ELSE 1
              END
        END
    ) INTO resultValue
    FROM sql
    ;

    RETURN COALESCE(resultValue, 0);
END;
\

CREATE OR REPLACE SYNONYM portico.generaBOEscala FOR generaBOEscala\

GRANT EXECUTE ON generaBOEscala TO portico\









CREATE OR REPLACE FUNCTION unidadesGtsEscala(srvcId INTEGER) RETURN INTEGER IS
	resultValue INTEGER;
BEGIN
	WITH sql AS (
	    SELECT (
	        SELECT
	            COALESCE(
	                (
	                    SELECT prdt_nentero
	                    FROM tbl_parametro_dato_prdt
	                    WHERE prdt_prvr_pk = prvr_pk
	                        AND prdt_tpdt_pk = portico.getTipoDato('ENTERO_02')
	                )
	                , (
	                    SELECT prdt_nentero
	                    FROM tbl_parametro_dato_prdt
	                    WHERE prdt_prvr_pk = prvr_pk
	                        AND prdt_tpdt_pk = portico.getTipoDato('ENTERO_01')
	                )
	            )
	        FROM tbl_parametro_version_prvr
	        WHERE
	            prvr_prmt_pk = (
	                SELECT srdt_prmt_pk
	                FROM tbl_servicio_dato_srdt
	                WHERE
	                    srdt_tpdt_pk = portico.getTipoDato('BUQUE')
	                    AND srdt_srvc_pk = srvc_pk
	            )
	            AND prvr_fini <= srvc_fref
	            AND (prvr_ffin IS NULL OR prvr_ffin > srvc_fref)
	    ) AS unidades
	    FROM tbl_servicio_srvc
	    WHERE
	        srvc_tpsr_pk = portico.getEntidad('ESCALA')
	        AND srvc_pk = srvcId
	)
	SELECT
	    (
	        CASE
	            WHEN unidades < 100
	            THEN 100
	            ELSE unidades
	        END
	    ) INTO resultValue
	FROM sql
    ;

    RETURN COALESCE(resultValue, 0);
END;
\

CREATE OR REPLACE SYNONYM portico.unidadesGtsEscala FOR unidadesGtsEscala\

GRANT EXECUTE ON unidadesGtsEscala TO portico\






CREATE OR REPLACE FUNCTION unidadesGtsAtraque(ssrvId INTEGER) RETURN DOUBLE PRECISION IS
	resultValue DOUBLE PRECISION;
BEGIN
    WITH sql AS (
    SELECT
        (
            SELECT
                COALESCE(
                    (
                        SELECT prdt_nentero
                        FROM tbl_parametro_dato_prdt
                        WHERE prdt_prvr_pk = prvr_pk
                            AND prdt_tpdt_pk = portico.getTipoDato('ENTERO_02')
                    )
                    , (
                        SELECT prdt_nentero
                        FROM tbl_parametro_dato_prdt
                        WHERE prdt_prvr_pk = prvr_pk
                            AND prdt_tpdt_pk = portico.getTipoDato('ENTERO_01')
                    )
                )
            FROM tbl_parametro_version_prvr
            WHERE
                prvr_prmt_pk = (
                    SELECT srdt_prmt_pk
                    FROM tbl_servicio_dato_srdt
                    WHERE
                        srdt_tpdt_pk = portico.getTipoDato('BUQUE')
                        AND srdt_srvc_pk = ssrv_srvc_pk
                )
                AND EXISTS (
                    SELECT 1 FROM tbl_servicio_srvc
                    WHERE srvc_pk = ssrv_srvc_pk
                        AND prvr_fini <= srvc_fref
                        AND (prvr_ffin IS NULL OR prvr_ffin > srvc_fref)
                )
        ) AS unidadesGTs
        , (
            SELECT ssdt_cadena
            FROM tbl_subservicio_dato_ssdt
            WHERE
                ssdt_tpdt_pk = portico.getTipoDato('TIPO_ESTAN_ATR')
                AND ssdt_ssrv_pk = ssrv_pk
        ) AS tipoEstancia
    FROM tbl_subservicio_ssrv
    WHERE ssrv_tpss_pk = portico.getEntidad('ATRAQUE')
        AND ssrv_pk = ssrvId
    )
    SELECT (
        CASE tipoEstancia
            WHEN 'C' THEN
                CASE WHEN unidadesGTs < 100 THEN 1
                ELSE ROUND(unidadesGTs/100, 2) END
            WHEN 'L' THEN
                CASE WHEN unidadesGTs < 50 THEN 0.50
                ELSE ROUND(unidadesGTs/100, 2) END
        END
    ) INTO resultValue
    FROM sql
    ;

    RETURN COALESCE(resultValue, 0);
END;
\

CREATE OR REPLACE SYNONYM portico.unidadesGtsAtraque FOR unidadesGtsAtraque\

GRANT EXECUTE ON unidadesGtsAtraque TO portico\







CREATE OR REPLACE FUNCTION fechaUltimaTR(srvcId INTEGER) RETURN TIMESTAMP IS
	resultValue TIMESTAMP;
BEGIN
    SELECT MAX(vlrl_ffin) INTO resultValue
    FROM tbl_valoracion_lin_vlrl
    WHERE
        EXISTS (
            SELECT 1 FROM tbl_valoracion_vlrc
            WHERE vlrc_pk = vlrl_vlrc_pk
                AND vlrc_srvc_pk = ANY (
                    SELECT srvc_pk
                    FROM tbl_servicio_srvc
                    WHERE
                        srvc_tpsr_pk = portico.getEntidad('ESCALA')
                        AND srvc_subp_pk = (
                            SELECT srvc_subp_pk
                            FROM tbl_servicio_srvc
                            WHERE
                                srvc_tpsr_pk = portico.getEntidad('ESCALA')
                                AND srvc_pk = srvcId
                        )
                        AND EXISTS (
                            SELECT 1 FROM tbl_servicio_dato_srdt
                            WHERE srdt_srvc_pk = srvc_pk
                                AND srdt_tpdt_pk = portico.getTipoDato('BUQUE')
                                AND srdt_prmt_pk = (
                                    SELECT srdt_prmt_pk
                                    FROM tbl_servicio_dato_srdt
                                    WHERE srdt_tpdt_pk = portico.getTipoDato('BUQUE')
                                        AND srdt_srvc_pk = srvcId
                                )
                        )
                )
        )
        AND EXISTS (
            SELECT 1
            FROM tbl_regla_rgla
            WHERE rgla_pk = vlrl_rgla_pk
                AND EXISTS (
                    SELECT 1 FROM tbl_cargo_crgo
                    WHERE crgo_pk = rgla_crgo_pk
                        AND crgo_codigo = 'TR'
                )
        )
    ;

    RETURN resultValue;
END;
\

CREATE OR REPLACE SYNONYM portico.fechaUltimaTR FOR fechaUltimaTR\

GRANT EXECUTE ON fechaUltimaTR TO portico\







CREATE OR REPLACE FUNCTION esPrimerAtraque(ssrvId INTEGER) RETURN INTEGER IS
	resultValue INTEGER;
BEGIN
    SELECT
        (
            CASE
                WHEN
                    EXISTS (
                        SELECT 1 FROM tbl_subservicio_ssrv ssrvAux
                        WHERE
                            ssrvAux.ssrv_srvc_pk = ssrv.ssrv_srvc_pk
                            AND ssrvAux.ssrv_tpss_pk = ssrv.ssrv_tpss_pk
                            AND ssrvAux.ssrv_estado IN ('I', 'F')
                            AND ssrvAux.ssrv_numero < ssrv.ssrv_numero
                    )
                THEN 0
                ELSE 1
            END
        ) INTO resultValue
    FROM
        tbl_subservicio_ssrv ssrv
    WHERE
        ssrv_tpss_pk = portico.getEntidad('ATRAQUE')
        AND ssrv_estado IN ('I', 'F')
        AND ssrv_pk = ssrvId
    ;

    RETURN COALESCE(resultValue, 0);
END;
\

CREATE OR REPLACE SYNONYM portico.esPrimerAtraque FOR esPrimerAtraque\

GRANT EXECUTE ON esPrimerAtraque TO portico\





CREATE OR REPLACE FUNCTION periodosFacturablesAtraque(ssrvId INTEGER) RETURN INTEGER IS
	resultValue INTEGER;
BEGIN
    WITH sql AS (
        SELECT ssrv_estado, ssrv_fini, ssrv_ffin
            , GREATEST(ssrv_fini, COALESCE((SELECT MAX(vlrl_ffin) FROM tbl_valoracion_lin_vlrl WHERE vlrl_ssrv_pk = ssrv_pk), ssrv_fini)) AS ssrv_fini_liq
            , LEAST(COALESCE(ssrv_ffin, SYSDATE), SYSDATE) AS ssrv_ffin_liq
            , LEAST(COALESCE(ssrv_ffin, SYSDATE), SYSDATE)
              - GREATEST(ssrv_fini, COALESCE((SELECT MAX(vlrl_ffin) FROM tbl_valoracion_lin_vlrl WHERE vlrl_ssrv_pk = ssrv_pk), ssrv_fini)) AS ssrv_intervalo_liq
            , (SELECT ssdt_cadena FROM tbl_subservicio_dato_ssdt
                WHERE ssdt_ssrv_pk = ssrv_pk AND ssdt_tpdt_pk = portico.getTipoDato('TIPO_ESTAN_ATR')) AS ssrv_tipo_estancia
        FROM
            tbl_subservicio_ssrv ssrv
        WHERE
            ssrv_tpss_pk = portico.getEntidad('ATRAQUE')
            AND ssrv_estado IN ('I', 'F')
            AND EXISTS (
                SELECT 1 FROM tbl_subservicio_dato_ssdt
                WHERE ssdt_ssrv_pk = ssrv_pk
                    AND ssdt_tpdt_pk = portico.getTipoDato('COD_EXEN')
                    AND ssdt_cadena IN ('0', '1')
            )
            AND ssrv_pk = ssrvId
    )
    SELECT
        (CASE ssrv_tipo_estancia
            WHEN 'L'
            THEN EXTRACT(DAY FROM ssrv_intervalo_liq) + LEAST(EXTRACT(HOUR FROM ssrv_intervalo_liq), 1)
            ELSE
                EXTRACT(DAY FROM ssrv_intervalo_liq) * 15
                + LEAST(
                    EXTRACT(HOUR FROM ssrv_intervalo_liq)
                    + LEAST(EXTRACT(MINUTE FROM ssrv_intervalo_liq), 1)
                , 15)
         END) INTO resultValue
    FROM sql
    ;

    RETURN COALESCE(resultValue, 0);
END;
\

CREATE OR REPLACE SYNONYM portico.periodosFacturablesAtraque FOR periodosFacturablesAtraque\

GRANT EXECUTE ON periodosFacturablesAtraque TO portico\




CREATE OR REPLACE FUNCTION esAvituallamientoEscala(srvcId INTEGER) RETURN INTEGER IS
	resultValue INTEGER;
BEGIN
    SELECT (
        CASE
            WHEN
                EXISTS (
                    SELECT 1 FROM tbl_subservicio_ssrv
                    WHERE
                        ssrv_srvc_pk = srvc_pk
                        AND ssrv_tpss_pk = portico.getEntidad('ATRAQUE')
                        AND EXISTS (
                            SELECT 1
                            FROM tbl_subservicio_dato_ssdt
                            WHERE ssdt_ssrv_pk = ssrv_pk
                                AND ssdt_tpdt_pk = portico.getTipoDato('TIPO_ACT')
                                AND ssdt_prmt_pk = ANY (
                                    SELECT prmt_pk FROM tbl_parametro_prmt
                                    WHERE prmt_tppr_pk = portico.getEntidad('TIPO_ACTIVIDAD')
                                        AND prmt_parametro = ANY ('AR','AB','AF','AT', 'AP','RF','RT','RA')
                                )
                        )
                )
                AND NOT EXISTS (
                    SELECT 1 FROM tbl_subservicio_ssrv
                    WHERE
                        ssrv_srvc_pk = srvc_pk
                        AND ssrv_tpss_pk = portico.getEntidad('ATRAQUE')
                        AND EXISTS (
                            SELECT 1
                            FROM tbl_subservicio_dato_ssdt
                            WHERE ssdt_ssrv_pk = ssrv_pk
                                AND ssdt_tpdt_pk = portico.getTipoDato('TIPO_ACT')
                                AND ssdt_prmt_pk <> ALL (
                                    SELECT prmt_pk FROM tbl_parametro_prmt
                                    WHERE prmt_tppr_pk = portico.getEntidad('TIPO_ACTIVIDAD')
                                        AND prmt_parametro = ANY ('AR','AB','AF','AT', 'AP','RF','RT','RA','FE')
                                )
                        )
                )
                AND NOT EXISTS (
                    SELECT 1 FROM tbl_subservicio_ssrv
                    WHERE ssrv_srvc_pk = srvc_pk
                        AND EXISTS (
                            SELECT 1 FROM tbl_subservicio_dato_ssdt
                            WHERE ssdt_ssrv_pk = ssrv_pk
                                AND ssdt_tpdt_pk = portico.getTipoDato('ALIN')
                                AND ssdt_prmt_pk = ANY (
                                    SELECT prmt_pk FROM tbl_parametro_prmt
                                    WHERE prmt_tppr_pk = portico.getEntidad('ALINEACION')
                                        AND EXISTS (
                                            SELECT 1 FROM tbl_parametro_version_prvr
                                            WHERE prvr_prmt_pk = prmt_pk
                                                AND prvr_fini <= SYSDATE
                                                AND (prvr_ffin IS NULL OR prvr_ffin > SYSDATE)
                                                AND EXISTS (
                                                    SELECT 1 FROM tbl_parametro_dato_prdt
                                                    WHERE prdt_prvr_pk = prvr_pk
                                                        AND prdt_tpdt_pk = portico.getTipoDato('BOOLEANO_04')
                                                        AND prdt_nentero = 1
                                                )
                                        )
                                )
                        )
                )
                AND EXISTS (
                    SELECT 1 FROM tbl_servicio_dato_srdt
                    WHERE srdt_srvc_pk = srvc_pk
                        AND srdt_tpdt_pk = portico.getTipoDato('TIPO_ESTAN_ESC')
                        AND srdt_cadena = 'C'
                )
                AND srvc_fini + 2 <= srvc_ffin
            THEN 1
            ELSE 0
        END
    ) INTO resultValue
    FROM tbl_servicio_srvc
    WHERE srvc_tpsr_pk = portico.getEntidad('ESCALA')
        AND srvc_pk = srvcId
    ;

    RETURN COALESCE(resultValue, 0);
END;
\

CREATE OR REPLACE SYNONYM portico.esAvituallamientoEscala FOR esAvituallamientoEscala\

GRANT EXECUTE ON esAvituallamientoEscala TO portico\









CREATE OR REPLACE FUNCTION esBaseEnPuertoEscala(srvcId INTEGER) RETURN INTEGER IS
	resultValue INTEGER;
BEGIN
    SELECT (
        SELECT
            spdt_nentero
        FROM tbl_subparametro_dato_spdt
        WHERE
            spdt_tpdt_pk = portico.getTipoDato('BOOLEANO_01')
            AND spdt_spvr_pk = (
                SELECT spvr_pk
                FROM tbl_subparametro_version_spvr
                WHERE
                    spvr_fini <= SYSDATE
                    AND (spvr_ffin IS NULL OR spvr_ffin > SYSDATE)
                    AND spvr_sprm_pk = (
                        SELECT sprm_pk
                        FROM tbl_subparametro_sprm
                        WHERE sprm_tpsp_pk = portico.getEntidad('BUQUE_SUBPUERTO')
                            AND sprm_prmt_pk = (
                                SELECT srdt_prmt_pk
                                FROM tbl_servicio_dato_srdt
                                WHERE srdt_tpdt_pk = portico.getTipoDato('BUQUE')
                                    AND srdt_srvc_pk = srvc_pk
                            )
                            AND sprm_prmt_dep_pk = (
                                SELECT prmt_pk
                                FROM tbl_parametro_prmt
                                WHERE
                                    prmt_tppr_pk = portico.getEntidad('SUBPUERTO')
                                    AND prmt_parametro = (
                                        SELECT prto_codigo_corto
                                        FROM tbl_puerto_prto
                                        WHERE prto_pk = srvc_subp_pk
                                    )
                            )
                    )
            )
      ) INTO resultValue
      FROM tbl_servicio_srvc
      WHERE
          srvc_tpsr_pk = portico.getEntidad('ESCALA')
          AND srvc_pk = srvcId
    ;

    RETURN COALESCE(resultValue, 0);
END;
\

CREATE OR REPLACE SYNONYM portico.esBaseEnPuertoEscala FOR esBaseEnPuertoEscala\

GRANT EXECUTE ON esBaseEnPuertoEscala TO portico\







CREATE OR REPLACE FUNCTION contadorEscala2(srvcId INTEGER, tipoContador VARCHAR2) RETURN INTEGER IS
	resultValue INTEGER;
BEGIN
	SELECT
	    (
	        SELECT ssdt_nentero
	        FROM tbl_subservicio_dato_ssdt
	        WHERE
	            ssdt_tpdt_pk = portico.getTipoDato('ENTERO_01')
	            AND ssdt_ssrv_pk = (
	                SELECT ssrv_pk
	                FROM tbl_subservicio_ssrv
	                WHERE ssrv_tpss_pk = portico.getEntidad('ESCALA_CONTADOR')
	                    AND EXISTS (
	                        SELECT 1 FROM tbl_subservicio_dato_ssdt
	                        WHERE
	                            ssdt_ssrv_pk = ssrv_pk
	                            AND ssdt_tpdt_pk = portico.getTipoDato('CONT_ESCALA')
	                            AND ssdt_cadena = tipoContador
	                    )
	                    AND ssrv_srvc_pk = srvc_pk
	            )
	    ) INTO resultValue
	FROM tbl_servicio_srvc
	WHERE
	    srvc_tpsr_pk = portico.getEntidad('ESCALA')
	    AND srvc_pk = srvcId
    ;

    RETURN COALESCE(resultValue, 0);
END;
\

CREATE OR REPLACE SYNONYM portico.contadorEscala2 FOR contadorEscala\

GRANT EXECUTE ON contadorEscala2 TO portico\







CREATE OR REPLACE FUNCTION contadorEscala(srvcId INTEGER, tipoContador VARCHAR2) RETURN INTEGER IS
	resultValue INTEGER;
BEGIN
	WITH sql AS (
	    SELECT srvc_pk, srvc_tpsr_pk, srvc_fini, srvc_anno, srvc_subp_pk, srvc_estado
			, (
			      SELECT srdt_prmt_pk
			      FROM tbl_servicio_dato_srdt
			      WHERE srdt_tpdt_pk = portico.getTipoDato('SERV_TRAF')
			          AND srdt_srvc_pk = srvc_pk
	                  AND EXISTS (
	                      SELECT 1 FROM tbl_parametro_version_prvr
	                      WHERE prvr_prmt_pk = srdt_prmt_pk
	                          AND prvr_fini <= srvc_fini
	                          AND (prvr_ffin IS NULL OR prvr_ffin > srvc_fini)
	                          AND EXISTS (
	                              SELECT 1 FROM tbl_parametro_dato_prdt
	                              WHERE prdt_prvr_pk = prvr_pk
	                                  AND prdt_tpdt_pk = portico.getTipoDato('BOOLEANO_01')
	                                  AND prdt_nentero = 1
	                          )
	                  )
			) AS servicio
	    FROM tbl_servicio_srvc
	    WHERE
	        srvc_tpsr_pk = portico.getEntidad('ESCALA')
            AND srvc_estado IN ('I', 'F')
	        AND srvc_pk = srvcId
	)
	SELECT (
	        SELECT
	            COUNT(1)
	        FROM tbl_servicio_srvc srvc
	        WHERE
	            srvc.srvc_tpsr_pk = sql.srvc_tpsr_pk
	            AND srvc.srvc_estado IN ('I', 'F')
	            AND srvc.srvc_fini <= sql.srvc_fini
	            AND srvc.srvc_anno = sql.srvc_anno
	            AND srvc.srvc_subp_pk = sql.srvc_subp_pk
	            AND EXISTS (
                    SELECT 1
                    FROM tbl_servicio_dato_srdt
                    WHERE srdt_tpdt_pk = portico.getTipoDato('SERV_TRAF')
                        AND srdt_srvc_pk = srvc.srvc_pk
                      AND srdt_prmt_pk = sql.servicio
	            )
	    ) INTO resultValue
	FROM sql
    ;

    RETURN COALESCE(resultValue, 0);
END;
\

CREATE OR REPLACE SYNONYM portico.contadorEscala FOR contadorEscala2\

GRANT EXECUTE ON contadorEscala TO portico\






CREATE OR REPLACE FUNCTION tieneConvenioEscala(srvcId INTEGER, convenio VARCHAR2) RETURN INTEGER IS
	resultValue INTEGER;
BEGIN
    SELECT
        (
            CASE
                WHEN EXISTS (
                    SELECT 1
                    FROM tbl_subparametro_version_spvr
                    WHERE
                        spvr_fini <= srvc_fini
                        AND (spvr_ffin IS NULL OR spvr_ffin > srvc_fini)
                        AND spvr_sprm_pk = (
                            SELECT sprm_pk
                            FROM tbl_subparametro_sprm
                            WHERE
                                sprm_tpsp_pk = portico.getEntidad('BUQUE_CONVENIO')
                                AND sprm_prmt_pk = (
                                    SELECT srdt_prmt_pk
                                    FROM tbl_servicio_dato_srdt
                                    WHERE
                                        srdt_tpdt_pk = portico.getTipoDato('BUQUE')
                                        AND srdt_srvc_pk = srvc_pk
                                )
                                AND sprm_prmt_dep_pk = (
                                    SELECT prmt_pk
                                    FROM tbl_parametro_prmt
                                    WHERE
                                        prmt_tppr_pk = portico.getEntidad('CONVENIO')
                                        AND prmt_parametro = convenio
                                )

                        )
                )
                THEN 1
                ELSE 0
            END
        ) INTO resultValue
    FROM tbl_servicio_srvc
    WHERE
        srvc_tpsr_pk = portico.getEntidad('ESCALA')
        AND srvc_pk = srvcId
    ;

    RETURN COALESCE(resultValue, 0);
END;
\

CREATE OR REPLACE SYNONYM portico.tieneConvenioEscala FOR tieneConvenioEscala\

GRANT EXECUTE ON tieneConvenioEscala TO portico\










-- //@UNDO
-- SQL to undo the change goes here.
DROP FUNCTION tieneConvenioEscala\
DROP FUNCTION contadorEscala\
DROP FUNCTION contadorEscala2\
DROP FUNCTION esBaseEnPuertoEscala\
DROP FUNCTION esAvituallamientoEscala\
DROP FUNCTION periodosFacturablesAtraque\
DROP FUNCTION esPrimerAtraque\
DROP FUNCTION fechaUltimaTR\
DROP FUNCTION unidadesGtsAtraque\
DROP FUNCTION unidadesGtsEscala\
DROP FUNCTION generaBOEscala\
DROP FUNCTION valorServicio\
DROP FUNCTION acumuladoToneladas\
DROP FUNCTION acumuladoTeus\
