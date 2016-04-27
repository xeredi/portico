
SELECT 
    port
    , (SELECT prto_codigo FROM tbl_puerto_prto WHERE prto_pk = port) AS port_prmt
    , puerto_carga_descarga AS UNLOCODE
    , (SELECT prmt_parametro FROM tbl_parametro_prmt WHERE prmt_pk = puerto_carga_descarga) AS UNLOCODE_prmt
    , mercancia AS MERCANCIA
    , (SELECT prmt_parametro FROM tbl_parametro_prmt WHERE prmt_pk = mercancia) AS MERCANCIA_prmt
    , unidad_carga AS UNIDAD_CARGA
    , (SELECT prmt_parametro FROM tbl_parametro_prmt WHERE prmt_pk = unidad_carga) AS UNIDAD_CARGA_prmt
    , grupo_nst AS GRUPO_NST
    , (SELECT prmt_parametro FROM tbl_parametro_prmt WHERE prmt_pk = grupo_nst) AS GRUPO_NST_prmt
    , reg_tbuque_eee AS REG_TBUQUE_EEE
    , (SELECT prmt_parametro FROM tbl_parametro_prmt WHERE prmt_pk = reg_tbuque_eee) AS REG_TBUQUE_EEE_prmt
    , direccion AS DIREC_MERC
    , roro AS BOOLEANO_01
    
    , SUM(toneladas) AS DECIMAL_01
    , SUM(pax) AS ENTERO_01
    , SUM(pax_crucero) AS ENTERO_02
    , SUM(pax_if) AS ENTERO_03
    , SUM(uc_llenas) AS ENTERO_04
    , SUM(uc_vacias) AS ENTERO_05
FROM (
    SELECT ssrv_pk, port, bl_pk 
        , (
            CASE
                WHEN EXISTS (
                    SELECT 1
                    FROM tbl_subservicio_dato_ssdt
                    WHERE 
                        ssdt_ssrv_pk = bl_pk
                        AND ssdt_tpdt_pk = portico.gettipodato('TIPO_OP_BL')
                        AND ssdt_cadena LIKE 'E%'
                )
                THEN (
                    SELECT ssdt_prmt_pk
                    FROM tbl_subservicio_dato_ssdt
                    WHERE 
                        ssdt_ssrv_pk = bl_pk
                        AND ssdt_tpdt_pk = portico.gettipodato('UNLOCODE_3')
                )
                ELSE (
                    SELECT ssdt_prmt_pk
                    FROM tbl_subservicio_dato_ssdt
                    WHERE 
                        ssdt_ssrv_pk = bl_pk
                        AND ssdt_tpdt_pk = portico.gettipodato('UNLOCODE_2')
                )
            END
        ) AS puerto_carga_descarga
        , (
            SELECT prdt_prmt_pk
            FROM tbl_parametro_dato_prdt
            WHERE 
                prdt_tpdt_pk = portico.gettipodato('REG_TBUQUE_EEE')
                AND prdt_prvr_pk = (
                    SELECT prvr_pk
                    FROM tbl_parametro_version_prvr
                    WHERE
                        prvr_fini <= srvc_fref
                        AND (prvr_ffin IS NULL OR prvr_ffin > srvc_fref)
                        AND prvr_prmt_pk = (
                            SELECT prdt_prmt_pk
                            FROM tbl_parametro_dato_prdt
                            WHERE 
                                prdt_tpdt_pk = portico.gettipodato('REG_TBUQUE')
                                AND prdt_prvr_pk = (
                                    SELECT prvr_pk
                                    FROM tbl_parametro_version_prvr
                                    WHERE
                                        prvr_fini <= srvc_fref
                                        AND (prvr_ffin IS NULL OR prvr_ffin > srvc_fref)
                                        AND prvr_prmt_pk = (
                                            SELECT srdt_prmt_pk
                                            FROM tbl_servicio_dato_srdt
                                            WHERE srdt_tpdt_pk = portico.gettipodato('BUQUE')
                                                AND srdt_srvc_pk = esca_pk
                                        )
                                )
                        )
                )
        ) AS reg_tbuque_eee
        , (
            CASE
                WHEN EXISTS (
                    SELECT 1
                    FROM tbl_subservicio_dato_ssdt
                    WHERE 
                        ssdt_ssrv_pk = bl_pk
                        AND ssdt_tpdt_pk = portico.gettipodato('TIPO_OP_BL')
                        AND ssdt_cadena LIKE 'E%'
                )
                THEN 'S'
                ELSE 'E'
            END
        ) AS direccion
        , (
            SELECT ssdt_prmt_pk
            FROM tbl_subservicio_dato_ssdt
            WHERE 
                ssdt_tpdt_pk = portico.gettipodato('UNIDAD_CARGA')
                AND ssdt_ssrv_pk = ssrv_pk
        ) AS unidad_carga
        , (
            CASE ssrv_tpss_pk
                WHEN portico.getentidad('PARTIDA') THEN (
                    SELECT ssdt_prmt_pk
                    FROM tbl_subservicio_dato_ssdt
                    WHERE 
                        ssdt_tpdt_pk = portico.gettipodato('MERCANCIA')
                        AND ssdt_ssrv_pk = ssrv_pk
                )
                WHEN portico.getentidad('EQUIPAMIENTO') THEN (
                    SELECT prdt_prmt_pk
                    FROM tbl_parametro_dato_prdt
                    WHERE
                        prdt_tpdt_pk = portico.gettipodato('MERCANCIA')
                        AND prdt_prvr_pk = (
                            SELECT prvr_pk
                            FROM tbl_parametro_version_prvr
                            WHERE
                                prvr_fini <= srvc_fref
                                AND (prvr_ffin IS NULL OR prvr_ffin > srvc_fref)
                                AND prvr_prmt_pk = (
                                    SELECT ssdt_prmt_pk
                                    FROM tbl_subservicio_dato_ssdt
                                    WHERE 
                                        ssdt_tpdt_pk = portico.gettipodato('UNIDAD_CARGA')
                                        AND ssdt_ssrv_pk = ssrv_pk
                                )
                        )
                )
            END 
        ) AS mercancia
        , (
            CASE ssrv_tpss_pk
                WHEN portico.getentidad('PARTIDA') THEN (
                    SELECT prdt_prmt_pk
                    FROM tbl_parametro_dato_prdt
                    WHERE 
                        prdt_tpdt_pk = portico.gettipodato('GRUPO_NST')
                        AND prdt_prvr_pk = (
                            SELECT prvr_pk
                            FROM tbl_parametro_version_prvr
                            WHERE
                                prvr_fini <= srvc_fref
                                AND (prvr_ffin IS NULL OR prvr_ffin > srvc_fref)
                                AND prvr_prmt_pk = (
                                    SELECT ssdt_prmt_pk
                                    FROM tbl_subservicio_dato_ssdt
                                    WHERE 
                                        ssdt_tpdt_pk = portico.gettipodato('MERCANCIA')
                                        AND ssdt_ssrv_pk = ssrv_pk
                                )
                        )
                )
                WHEN portico.getentidad('EQUIPAMIENTO') THEN (
                    SELECT prdt_prmt_pk
                    FROM tbl_parametro_dato_prdt
                    WHERE 
                        prdt_tpdt_pk = portico.gettipodato('GRUPO_NST')
                        AND prdt_prvr_pk = (
                            SELECT prvr_pk
                            FROM tbl_parametro_version_prvr
                            WHERE
                                prvr_fini <= srvc_fref
                                AND (prvr_ffin IS NULL OR prvr_ffin > srvc_fref)
                                AND prvr_prmt_pk = (
                                    SELECT prdt_prmt_pk
                                    FROM tbl_parametro_dato_prdt
                                    WHERE
                                        prdt_tpdt_pk = portico.gettipodato('MERCANCIA')
                                        AND prdt_prvr_pk = (
                                            SELECT prvr_pk
                                            FROM tbl_parametro_version_prvr
                                            WHERE
                                                prvr_fini <= srvc_fref
                                                AND (prvr_ffin IS NULL OR prvr_ffin > srvc_fref)
                                                AND prvr_prmt_pk = (
                                                    SELECT ssdt_prmt_pk
                                                    FROM tbl_subservicio_dato_ssdt
                                                    WHERE 
                                                        ssdt_tpdt_pk = portico.gettipodato('UNIDAD_CARGA')
                                                        AND ssdt_ssrv_pk = ssrv_pk
                                                )
                                        )
                                )
                        )
                )
            END 
        ) AS grupo_nst
        , (
            CASE ssrv_tpss_pk
                WHEN portico.getentidad('PARTIDA') THEN (
                    SELECT ssdt_nentero
                    FROM tbl_subservicio_dato_ssdt
                    WHERE 
                        ssdt_tpdt_pk = portico.gettipodato('BOOLEANO_02')
                        AND ssdt_ssrv_pk = ssrv_pk
                )
                WHEN portico.getentidad('EQUIPAMIENTO') THEN (
                    SELECT ssdt_nentero
                    FROM tbl_subservicio_dato_ssdt
                    WHERE 
                        ssdt_tpdt_pk = portico.gettipodato('BOOLEANO_01')
                        AND ssdt_ssrv_pk = ssrv_pk
                )
            END 
        ) AS roro
    
        , (
            CASE ssrv_tpss_pk
                WHEN portico.getentidad('PARTIDA') THEN (
                    SELECT ssdt_nentero / 1000
                    FROM tbl_subservicio_dato_ssdt
                    WHERE 
                        ssdt_tpdt_pk = portico.gettipodato('ENTERO_04')
                        AND ssdt_ssrv_pk = ssrv_pk
                )
                WHEN portico.getentidad('EQUIPAMIENTO') THEN (
                    SELECT ssdt_nentero / 1000
                    FROM tbl_subservicio_dato_ssdt
                    WHERE 
                        ssdt_tpdt_pk = portico.gettipodato('ENTERO_02') 
                        AND ssdt_ssrv_pk = ssrv_pk
                )
            END 
        ) AS toneladas
        , (
            CASE 
                WHEN ssrv_tpss_pk = portico.getentidad('PARTIDA') 
                THEN 0
                WHEN 
                    ssrv_tpss_pk = portico.getentidad('EQUIPAMIENTO') 
                    AND EXISTS (
                        SELECT 1
                        FROM tbl_subservicio_dato_ssdt
                        WHERE 
                            ssdt_tpdt_pk = portico.gettipodato('CADENA_02') 
                            AND ssdt_cadena = '4'
                            AND ssdt_ssrv_pk = ssrv_pk
                    )
                THEN 0
                ELSE 1
            END 
        ) AS uc_llenas
        , (
            CASE 
                WHEN ssrv_tpss_pk = portico.getentidad('EQUIPAMIENTO') 
                THEN (
                    SELECT ssdt_nentero
                    FROM tbl_subservicio_dato_ssdt
                    WHERE 
                        ssdt_tpdt_pk = portico.gettipodato('ENTERO_01') 
                        AND ssdt_ssrv_pk = ssrv_pk
                )
                ELSE 0
            END 
        ) AS uc_vacias
        , (
            CASE 
                WHEN ssrv_tpss_pk = portico.getentidad('PARTIDA')
                      AND EXISTS (
                          SELECT 1 
                          FROM tbl_subservicio_dato_ssdt
                          WHERE
                              ssdt_tpdt_pk = portico.getTipoDato('MERCANCIA')
                              AND ssdt_ssrv_pk = ssrv_pk
                              AND EXISTS (
                                  SELECT 1 FROM tbl_parametro_prmt
                                  WHERE prmt_pk = ssdt_prmt_pk
                                      AND (
                                          prmt_parametro LIKE '0001%'
                                          OR prmt_parametro LIKE '0002%'
                                      )
                              )
                      )
                THEN (
                    SELECT ssdt_nentero
                    FROM tbl_subservicio_dato_ssdt
                    WHERE
                        ssdt_tpdt_pk = portico.getTipoDato('ENTERO_03')
                        AND ssdt_ssrv_pk = ssrv_pk
                )
                ELSE 0
            END 
        ) AS pax
        , (
            CASE 
                WHEN ssrv_tpss_pk = portico.getentidad('PARTIDA')
                      AND EXISTS (
                          SELECT 1 
                          FROM tbl_subservicio_dato_ssdt
                          WHERE
                              ssdt_tpdt_pk = portico.getTipoDato('MERCANCIA')
                              AND ssdt_ssrv_pk = ssrv_pk
                              AND EXISTS (
                                  SELECT 1 FROM tbl_parametro_prmt
                                  WHERE prmt_pk = ssdt_prmt_pk
                                      AND (
                                          prmt_parametro LIKE '0001C'
                                          OR prmt_parametro LIKE '0002C'
                                      )
                              )
                      )
                THEN (
                    SELECT ssdt_nentero
                    FROM tbl_subservicio_dato_ssdt
                    WHERE
                        ssdt_tpdt_pk = portico.getTipoDato('ENTERO_03')
                        AND ssdt_ssrv_pk = ssrv_pk
                )
                ELSE 0
            END 
        ) AS pax_crucero
        , (
            CASE 
                WHEN ssrv_tpss_pk = portico.getentidad('PARTIDA')
                      AND EXISTS (
                          SELECT 1 
                          FROM tbl_subservicio_dato_ssdt
                          WHERE
                              ssdt_tpdt_pk = portico.getTipoDato('MERCANCIA')
                              AND ssdt_ssrv_pk = ssrv_pk
                              AND EXISTS (
                                  SELECT 1 FROM tbl_parametro_prmt
                                  WHERE prmt_pk = ssdt_prmt_pk
                                      AND (
                                          prmt_parametro LIKE '0001X'
                                          OR prmt_parametro LIKE '0002X'
                                      )
                              )
                      )
                THEN (
                    SELECT ssdt_nentero
                    FROM tbl_subservicio_dato_ssdt
                    WHERE
                        ssdt_tpdt_pk = portico.getTipoDato('ENTERO_03')
                        AND ssdt_ssrv_pk = ssrv_pk
                )
                ELSE 0
            END 
        ) AS pax_if
    FROM (
        SELECT 
            ssrv_pk
            , ssrv_tpss_pk
            , srvc_subp_pk AS port
            , srvc_fref
            , (
                SELECT ssss_ssrvp_pk
                FROM tbl_subserv_subserv_ssss
                WHERE ssss_ssrvh_pk = ssrv_pk
            ) AS bl_pk
            , (
                SELECT ssss_ssrvp_pk
                FROM tbl_subserv_subserv_ssss 
                WHERE 
                    ssss_ssrvh_pk = (
                        SELECT ssss_ssrvp_pk
                        FROM tbl_subserv_subserv_ssss 
                        WHERE ssss_ssrvh_pk = ssrv_pk
                    )
            ) AS maco_pk
            , (
                SELECT srdt_srvc_dep_pk
                FROM tbl_servicio_dato_srdt
                WHERE 
                    srdt_tpdt_pk = portico.gettipodato('ESCALA')
                    AND srdt_srvc_pk = srvc_pk
            ) AS esca_pk
        FROM tbl_subservicio_ssrv
            INNER JOIN tbl_servicio_srvc ON
                srvc_pk = ssrv_srvc_pk
        WHERE
            ssrv_estado = 'R'
            
            AND EXISTS (
                SELECT 1 FROM tbl_subservicio_dato_ssdt
                WHERE ssdt_ssrv_pk = ssrv_pk
                    AND ssdt_tpdt_pk = portico.gettipodato('COD_EXEN')
                    AND ssdt_cadena IN ('0', '2')
            )
            
            AND EXISTS (
                SELECT 1
                FROM tbl_subserv_subserv_ssss
                WHERE ssss_ssrvh_pk = ssrv_pk
                    AND EXISTS (
                        SELECT 1
                        FROM tbl_subservicio_ssrv
                        WHERE ssrv_pk = ssss_ssrvp_pk
                            AND ssrv_tpss_pk = portico.getentidad('BL')
                            AND NOT EXISTS (
                                SELECT 1 FROM tbl_subservicio_dato_ssdt
                                WHERE ssdt_ssrv_pk = ssrv_pk
                                    AND ssdt_tpdt_pk = portico.gettipodato('TIPO_OP_BL')
                                    AND ssdt_cadena = 'TE'
                            )
                            AND NOT EXISTS (
                                SELECT 1 FROM tbl_subservicio_dato_ssdt
                                WHERE ssdt_ssrv_pk = ssrv_pk
                                    AND ssdt_tpdt_pk = portico.gettipodato('TIPO_NAV')
                                    AND EXISTS (
                                        SELECT 1
                                        FROM tbl_parametro_prmt
                                        WHERE
                                            prmt_tppr_pk = portico.getEntidad('TIPO_NAVEGACION')
                                            AND prmt_parametro = 'I'
                                            AND prmt_pk = ssdt_prmt_pk
                                    )
                            )
                    )
            )
        
            AND (
                (
                    ssrv_tpss_pk = portico.getentidad('PARTIDA')
                    AND EXISTS (
                        SELECT 1 FROM tbl_subservicio_dato_ssdt
                        WHERE ssdt_ssrv_pk = ssrv_pk
                            AND ssdt_tpdt_pk = portico.gettipodato('BOOLEANO_01')
                            AND ssdt_nentero = 0
                    )
                )
                OR 
                (
                    ssrv_tpss_pk = portico.getentidad('EQUIPAMIENTO')
                    
                    AND EXISTS (
                        SELECT 1 FROM tbl_subservicio_dato_ssdt
                        WHERE ssdt_ssrv_pk = ssrv_pk
                            AND ssdt_tpdt_pk = portico.gettipodato('UNIDAD_CARGA')
                            AND EXISTS (
                                SELECT 1 FROM tbl_parametro_version_prvr
                                WHERE 
                                    prvr_prmt_pk = ssdt_prmt_pk
                                    AND prvr_fini <= srvc_fref
                                    AND (prvr_ffin IS NULL OR prvr_ffin > srvc_fref)
                                    AND NOT EXISTS (
                                        SELECT 1 FROM tbl_parametro_dato_prdt
                                        WHERE 
                                            prdt_prvr_pk = prvr_pk
                                            AND prdt_tpdt_pk = portico.gettipodato('MERCANCIA')
                                            AND prdt_prmt_pk IS NULL
                                    )
                            )
                    )
                )
            )
            
            AND NOT EXISTS (
                SELECT 1 FROM tbl_servicio_dato_srdt
                WHERE 
                    srdt_tpdt_pk = portico.gettipodato('ESCALA')
                    AND srdt_srvc_dep_pk IS NULL
                    AND srdt_srvc_pk = srvc_pk
            )
            
            AND srvc_fref >= to_date('01032015', 'DDMMYYYY')
            AND srvc_fref  < to_date('01042015', 'DDMMYYYY')
    ) SQL
) SQL
GROUP BY
    port, puerto_carga_descarga, reg_tbuque_eee, direccion, mercancia, grupo_nst, unidad_carga, roro
;
