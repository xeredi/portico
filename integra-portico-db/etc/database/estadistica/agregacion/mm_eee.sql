
SELECT 
    port, puerto_carga_descarga, reg_tbuque_eee, direccion, mercancia, grupo_nst, unidad_carga, roro
    , SUM(toneladas) AS toneladas, SUM(unidades) AS unidades, SUM(teus) AS teus
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
                THEN (
                    SELECT ssdt_nentero
                    FROM tbl_subservicio_dato_ssdt
                    WHERE 
                        ssdt_tpdt_pk = portico.gettipodato('ENTERO_03')
                        AND ssdt_ssrv_pk = ssrv_pk
                )
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
                THEN (
                    SELECT ssdt_nentero
                    FROM tbl_subservicio_dato_ssdt
                    WHERE 
                        ssdt_tpdt_pk = portico.gettipodato('ENTERO_01') 
                        AND ssdt_ssrv_pk = ssrv_pk
                )
            ELSE 1
            END 
        ) AS unidades
        , (
            CASE 
                WHEN ssrv_tpss_pk = portico.getentidad('PARTIDA') 
                THEN 0
                WHEN 
                    ssrv_tpss_pk = portico.getentidad('EQUIPAMIENTO') 
                THEN (
                    SELECT prdt_ndecimal
                    FROM tbl_parametro_dato_prdt
                    WHERE 
                        prdt_tpdt_pk = portico.gettipodato('DECIMAL_01') 
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
        ) AS teus
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
                            AND EXISTS (
                                SELECT 1 FROM tbl_subservicio_dato_ssdt
                                WHERE ssdt_ssrv_pk = ssrv_pk
                                    AND ssdt_tpdt_pk = portico.gettipodato('TIPO_OP_BL')
                                    AND ssdt_cadena <> 'TE'
                            )
                            AND EXISTS (
                                SELECT 1 FROM tbl_subservicio_dato_ssdt
                                WHERE ssdt_ssrv_pk = ssrv_pk
                                    AND ssdt_tpdt_pk = portico.gettipodato('TIPO_NAV')
                                    AND EXISTS (
                                        SELECT 1
                                        FROM tbl_parametro_prmt
                                        WHERE
                                            prmt_pk = ssdt_prmt_pk
                                            AND prmt_parametro <> 'I'
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
                                    AND EXISTS (
                                        SELECT 1 FROM tbl_parametro_dato_prdt
                                        WHERE 
                                            prdt_prvr_pk = prvr_pk
                                            AND prdt_tpdt_pk = portico.gettipodato('MERCANCIA')
                                            AND prdt_prmt_pk IS NOT NULL
                                    )
                            )
                    )
                )
            )
            
            AND EXISTS (
                SELECT 1 FROM tbl_servicio_dato_srdt
                WHERE 
                    srdt_tpdt_pk = portico.gettipodato('ESCALA')
                    AND srdt_srvc_dep_pk IS NOT NULL
                    AND srdt_srvc_pk = srvc_pk
                    
            )
            
            AND srvc_fref >= to_date('01012015', 'DDMMYYYY')
            AND srvc_fref  < to_date('01022015', 'DDMMYYYY')
    ) SQL
) SQL
GROUP BY
    port, puerto_carga_descarga, reg_tbuque_eee, direccion, mercancia, grupo_nst, unidad_carga, roro
;
