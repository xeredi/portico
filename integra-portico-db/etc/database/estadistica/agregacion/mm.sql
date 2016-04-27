
SELECT 
    port
    , (SELECT prto_codigo FROM tbl_puerto_prto WHERE prto_pk = port) AS port_prmt
    , tipo_op_bl AS tipo_op_bl
    , puerto_carga AS UNLOCODE
    , (SELECT prmt_parametro FROM tbl_parametro_prmt WHERE prmt_pk = puerto_carga) AS UNLOCODE_prmt
    , puerto_descarga AS UNLOCODE_2
    , (SELECT prmt_parametro FROM tbl_parametro_prmt WHERE prmt_pk = puerto_descarga) AS UNLOCODE_2_prmt
    , alin AS ALIN
    , (SELECT prmt_parametro FROM tbl_parametro_prmt WHERE prmt_pk = alin) AS ALIN_prmt
    , puerto_origen AS UNLOCODE_3
    , (SELECT prmt_parametro FROM tbl_parametro_prmt WHERE prmt_pk = puerto_origen) AS UNLOCODE_3_prmt
    , puerto_destino AS UNLOCODE_4
    , (SELECT prmt_parametro FROM tbl_parametro_prmt WHERE prmt_pk = puerto_destino) AS UNLOCODE_4_prmt
    , mercancia AS MERCANCIA
    , (SELECT prmt_parametro FROM tbl_parametro_prmt WHERE prmt_pk = mercancia) AS MERCANCIA_prmt
    , tipo_nav AS TIPO_NAV
    , (SELECT prmt_parametro FROM tbl_parametro_prmt WHERE prmt_pk = tipo_nav) AS TIPO_NAV_prmt
    , unidad_carga AS UNIDAD_CARGA
    , (SELECT prmt_parametro FROM tbl_parametro_prmt WHERE prmt_pk = unidad_carga) AS UNIDAD_CARGA_prmt
    , inst_esp AS INST_ESP
    , (SELECT prmt_parametro FROM tbl_parametro_prmt WHERE prmt_pk = inst_esp) AS INST_ESP_prmt
    , tipo_transporte AS TIPO_TRANSPORTE
    , roro AS BOOLEANO_01

    , SUM(toneladas) AS DECIMAL_01
    , SUM(unidades) AS ENTERO_01
    , SUM(teus) AS DECIMAL_02

    , estibador AS ORGA
    , (SELECT prmt_parametro FROM tbl_parametro_prmt WHERE prmt_pk = estibador) AS ORGA_prmt
    , consignatario AS ORGA_2
    , (SELECT prmt_parametro FROM tbl_parametro_prmt WHERE prmt_pk = consignatario) AS ORGA_2_prmt
    , buque AS BUQUE
    , (SELECT prmt_parametro FROM tbl_parametro_prmt WHERE prmt_pk = buque) AS BUQUE_prmt
    , serv_traf AS SERV_TRAF
    , (SELECT prmt_parametro FROM tbl_parametro_prmt WHERE prmt_pk = serv_traf) AS SERV_TRAF_prmt
    , acuerdo AS ACUERDO
    , (SELECT prmt_parametro FROM tbl_parametro_prmt WHERE prmt_pk = acuerdo) AS ACUERDO_prmt
    , terminal AS TERMINAL
    , (SELECT prmt_parametro FROM tbl_parametro_prmt WHERE prmt_pk = terminal) AS TERMINAL_prmt
    , tipo_equi AS CADENA_01
FROM (
    SELECT ssrv_pk, port, bl_pk 
        , (SELECT ssdt_cadena FROM tbl_subservicio_dato_ssdt
            WHERE ssdt_ssrv_pk = bl_pk AND ssdt_tpdt_pk = portico.gettipodato('TIPO_OP_BL')
        ) AS tipo_op_bl
        , (SELECT ssdt_prmt_pk FROM tbl_subservicio_dato_ssdt
            WHERE ssdt_ssrv_pk = bl_pk AND ssdt_tpdt_pk = portico.gettipodato('UNLOCODE_2')
        ) AS puerto_carga
        , (SELECT ssdt_prmt_pk FROM tbl_subservicio_dato_ssdt
            WHERE ssdt_ssrv_pk = bl_pk AND ssdt_tpdt_pk = portico.gettipodato('UNLOCODE_3')
        ) AS puerto_descarga
        , (SELECT ssdt_prmt_pk FROM tbl_subservicio_dato_ssdt
            WHERE ssdt_ssrv_pk = bl_pk AND ssdt_tpdt_pk = portico.gettipodato('UNLOCODE')
        ) AS puerto_origen
        , (SELECT ssdt_prmt_pk FROM tbl_subservicio_dato_ssdt
            WHERE ssdt_ssrv_pk = bl_pk AND ssdt_tpdt_pk = portico.gettipodato('UNLOCODE_4')
        ) AS puerto_destino
        , (SELECT ssdt_prmt_pk FROM tbl_subservicio_dato_ssdt
            WHERE ssdt_ssrv_pk = bl_pk AND ssdt_tpdt_pk = portico.gettipodato('ALIN')
        ) AS alin
        , (SELECT ssdt_prmt_pk FROM tbl_subservicio_dato_ssdt
            WHERE ssdt_ssrv_pk = bl_pk AND ssdt_tpdt_pk = portico.gettipodato('TIPO_NAV')
        ) AS tipo_nav
        , (SELECT ssdt_prmt_pk FROM tbl_subservicio_dato_ssdt
            WHERE ssdt_ssrv_pk = bl_pk AND ssdt_tpdt_pk = portico.gettipodato('SERV_TRAF')
        ) AS serv_traf
        , (SELECT ssdt_prmt_pk FROM tbl_subservicio_dato_ssdt
            WHERE ssdt_tpdt_pk = portico.gettipodato('INST_ESP') AND ssdt_ssrv_pk = bl_pk
        ) AS inst_esp
        , (SELECT ssdt_prmt_pk FROM tbl_subservicio_dato_ssdt
            WHERE ssdt_tpdt_pk = portico.gettipodato('ORGA_2') AND ssdt_ssrv_pk = bl_pk
        ) AS estibador
        , (SELECT ssdt_prmt_pk FROM tbl_subservicio_dato_ssdt
            WHERE ssdt_tpdt_pk = portico.gettipodato('ACUERDO') AND ssdt_ssrv_pk = bl_pk
        ) AS acuerdo
        , (SELECT ssdt_prmt_pk FROM tbl_subservicio_dato_ssdt
            WHERE ssdt_tpdt_pk = portico.gettipodato('TERMINAL') AND ssdt_ssrv_pk = bl_pk
        ) AS terminal
        , (SELECT ssdt_cadena FROM tbl_subservicio_dato_ssdt
            WHERE ssdt_ssrv_pk = bl_pk AND ssdt_tpdt_pk = portico.gettipodato('TIPO_TRANSPORTE')
        ) AS tipo_transporte
        , (SELECT ssdt_prmt_pk FROM tbl_subservicio_dato_ssdt
            WHERE ssdt_tpdt_pk = portico.gettipodato('ORGA') AND ssdt_ssrv_pk = maco_pk
        ) AS consignatario
        , (SELECT srdt_prmt_pk FROM tbl_servicio_dato_srdt
            WHERE srdt_tpdt_pk = portico.gettipodato('BUQUE') AND srdt_srvc_pk = esca_pk
        ) AS buque
        , (SELECT ssdt_prmt_pk FROM tbl_subservicio_dato_ssdt
            WHERE ssdt_tpdt_pk = portico.gettipodato('UNIDAD_CARGA') AND ssdt_ssrv_pk = ssrv_pk
        ) AS unidad_carga
        , (
            CASE ssrv_tpss_pk
                WHEN portico.getentidad('PARTIDA') 
                THEN (
                    SELECT ssdt_prmt_pk FROM tbl_subservicio_dato_ssdt
                    WHERE 
                        ssdt_tpdt_pk = portico.gettipodato('MERCANCIA') AND ssdt_ssrv_pk = ssrv_pk
                )
                WHEN portico.getentidad('EQUIPAMIENTO') 
                THEN (
                    SELECT prdt_prmt_pk FROM tbl_parametro_dato_prdt
                    WHERE
                        prdt_tpdt_pk = portico.gettipodato('MERCANCIA')
                        AND prdt_prvr_pk = (
                            SELECT prvr_pk FROM tbl_parametro_version_prvr
                            WHERE
                                prvr_fini <= srvc_fref
                                AND (prvr_ffin IS NULL OR prvr_ffin > srvc_fref)
                                AND prvr_prmt_pk = (
                                    SELECT ssdt_prmt_pk FROM tbl_subservicio_dato_ssdt
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
                WHEN portico.getentidad('PARTIDA') 
                THEN (
                    SELECT ssdt_nentero FROM tbl_subservicio_dato_ssdt
                    WHERE ssdt_tpdt_pk = portico.gettipodato('BOOLEANO_02') AND ssdt_ssrv_pk = ssrv_pk
                )
                WHEN portico.getentidad('EQUIPAMIENTO') THEN (
                    SELECT ssdt_nentero FROM tbl_subservicio_dato_ssdt
                    WHERE ssdt_tpdt_pk = portico.gettipodato('BOOLEANO_01') AND ssdt_ssrv_pk = ssrv_pk
                )
            END 
        ) AS roro
        , (
            CASE 
                WHEN 
                    ssrv_tpss_pk = portico.getentidad('EQUIPAMIENTO') 
                    AND EXISTS (
                        SELECT 1 FROM tbl_subservicio_dato_ssdt
                        WHERE 
                            ssdt_tpdt_pk = portico.gettipodato('BOOLEANO_01')
                            AND ssdt_nentero = 1
                            AND ssdt_ssrv_pk = ssrv_pk
                    )
                THEN (
                    SELECT ssdt_prmt_pk FROM tbl_subservicio_dato_ssdt
                    WHERE ssdt_tpdt_pk = portico.gettipodato('TIPO_EQUI') AND ssdt_ssrv_pk = ssrv_pk
                )
            END 
        ) AS tipo_equi
    
        , (
            CASE ssrv_tpss_pk
                WHEN portico.getentidad('PARTIDA') 
                THEN (
                    SELECT ssdt_nentero / 1000 FROM tbl_subservicio_dato_ssdt
                    WHERE ssdt_tpdt_pk = portico.gettipodato('ENTERO_04') AND ssdt_ssrv_pk = ssrv_pk
                )
                WHEN portico.getentidad('EQUIPAMIENTO') THEN (
                    SELECT ssdt_nentero / 1000 FROM tbl_subservicio_dato_ssdt
                    WHERE ssdt_tpdt_pk = portico.gettipodato('ENTERO_02') AND ssdt_ssrv_pk = ssrv_pk
                )
            END 
        ) AS toneladas
        , (
            CASE 
                WHEN ssrv_tpss_pk = portico.getentidad('PARTIDA') 
                THEN (
                    SELECT ssdt_nentero FROM tbl_subservicio_dato_ssdt
                    WHERE ssdt_tpdt_pk = portico.gettipodato('ENTERO_03') AND ssdt_ssrv_pk = ssrv_pk
                )
                WHEN 
                    ssrv_tpss_pk = portico.getentidad('EQUIPAMIENTO') 
                    AND EXISTS (
                        SELECT 1 FROM tbl_subservicio_dato_ssdt
                        WHERE 
                            ssdt_tpdt_pk = portico.gettipodato('CADENA_02') 
                            AND ssdt_cadena = '4'
                            AND ssdt_ssrv_pk = ssrv_pk
                    )
                THEN (
                    SELECT ssdt_nentero FROM tbl_subservicio_dato_ssdt
                    WHERE ssdt_tpdt_pk = portico.gettipodato('ENTERO_01') AND ssdt_ssrv_pk = ssrv_pk
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
                    SELECT prdt_ndecimal FROM tbl_parametro_dato_prdt
                    WHERE 
                        prdt_tpdt_pk = portico.gettipodato('DECIMAL_01') 
                        AND prdt_prvr_pk = (
                            SELECT prvr_pk FROM tbl_parametro_version_prvr
                            WHERE 
                                prvr_fini <= srvc_fref
                                AND (prvr_ffin IS NULL OR prvr_ffin > srvc_fref)
                                AND prvr_prmt_pk = (
                                    SELECT ssdt_prmt_pk FROM tbl_subservicio_dato_ssdt
                                    WHERE ssdt_tpdt_pk = portico.gettipodato('UNIDAD_CARGA') AND ssdt_ssrv_pk = ssrv_pk
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
            , (SELECT ssss_ssrvp_pk FROM tbl_subserv_subserv_ssss
                WHERE ssss_ssrvh_pk = ssrv_pk
            ) AS bl_pk
            , (
                SELECT ssss_ssrvp_pk
                FROM tbl_subserv_subserv_ssss 
                WHERE 
                    ssss_ssrvh_pk = (
                        SELECT ssss_ssrvp_pk FROM tbl_subserv_subserv_ssss 
                        WHERE ssss_ssrvh_pk = ssrv_pk
                    )
            ) AS maco_pk
            , (
                SELECT srdt_srvc_dep_pk FROM tbl_servicio_dato_srdt
                WHERE srdt_tpdt_pk = portico.gettipodato('ESCALA') AND srdt_srvc_pk = srvc_pk
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
            
            AND srvc_fref >= to_date('01022015', 'DDMMYYYY')
            AND srvc_fref  < to_date('01032015', 'DDMMYYYY')
            
            AND EXISTS (
                SELECT 1 FROM tbl_puerto_prto
                WHERE prto_pk = srvc_subp_pk
                    AND prto_sprt_pk = 36000
            )
    ) SQL
) SQL
GROUP BY
    port, tipo_op_bl, puerto_carga, puerto_descarga, puerto_origen, puerto_destino
    , alin, tipo_nav, serv_traf, inst_esp, estibador, acuerdo, terminal, tipo_transporte
    , consignatario, buque, unidad_carga, mercancia, roro, tipo_equi
;




SELECT *
FROM 
    tbl_servicio_srvc
WHERE
    srvc_tpsr_pk = portico.getEntidad('MANIFIESTO')           
    
    AND srvc_fref >= to_date('01022015', 'DDMMYYYY')
    AND srvc_fref  < to_date('01032015', 'DDMMYYYY')
            
    AND EXISTS (
        SELECT 1 FROM tbl_puerto_prto
        WHERE prto_pk = srvc_subp_pk
        AND prto_sprt_pk = 36000
    )

    AND EXISTS (
        SELECT 1 FROM tbl_subservicio_ssrv
        WHERE 
            ssrv_srvc_pk = srvc_pk
            AND ssrv_estado = 'R'
  
            AND EXISTS (
                SELECT 1 FROM tbl_subservicio_dato_ssdt
                WHERE ssdt_ssrv_pk = ssrv_pk
                    AND ssdt_tpdt_pk = portico.gettipodato('COD_EXEN')
                    AND ssdt_cadena IN ('0', '2')
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

            AND EXISTS (
                SELECT 1 FROM tbl_subserv_subserv_ssss
                WHERE ssss_ssrvh_pk = ssrv_pk
                    AND EXISTS (
                        SELECT 1 FROM tbl_subservicio_ssrv
                        WHERE ssrv_tpss_pk = portico.getEntidad('BL')
                            AND ssrv_pk = ssss_ssrvp_pk
                    )
                    AND NOT EXISTS (
                        SELECT 1 FROM tbl_subservicio_dato_ssdt
                        WHERE ssdt_ssrv_pk = ssrv_pk
                            AND ssdt_tpdt_pk = portico.gettipodato('TIPO_OP_BL')
                            AND ssdt_cadena = 'TE'
                    )
            )
    )
;


