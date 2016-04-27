SELECT 
    port
    , (SELECT prto_codigo FROM tbl_puerto_prto WHERE prto_pk = port) AS port_prmt
    , TIPO_BUQUE_EEE
    , (SELECT prmt_parametro FROM tbl_parametro_prmt WHERE prmt_pk = TIPO_BUQUE_EEE) AS TIPO_BUQUE_EEE_prmt
    , TIPO_BUQUE_GT_EEE
    , (SELECT prmt_parametro FROM tbl_parametro_prmt WHERE prmt_pk = TIPO_BUQUE_GT_EEE) AS TIPO_BUQUE_GT_EEE_prmt
    , COUNT(1) AS ENTERO_01
    , SUM(gt) AS ENTERO_02
FROM (
SELECT srvc_subp_pk AS port
    , (
        SELECT prdt_prmt_pk
        FROM tbl_parametro_dato_prdt
        WHERE
            prdt_tpdt_pk = portico.getTipoDato('TIPO_BUQUE_EEE')
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
                            prdt_tpdt_pk = portico.getTipoDato('TIPO_BUQUE_EST')
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
                                            prdt_tpdt_pk = portico.getTipoDato('TIPO_BUQUE')
                                            AND prdt_prvr_pk = (
                                                SELECT prvr_pk
                                                FROM tbl_parametro_version_prvr
                                                WHERE
                                                    prvr_fini <= srvc_fref
                                                    AND (prvr_ffin IS NULL OR prvr_ffin > srvc_fref)
                                                    AND prvr_prmt_pk = (
                                                        SELECT srdt_prmt_pk
                                                        FROM 
                                                            tbl_servicio_dato_srdt
                                                        WHERE
                                                            srdt_tpdt_pk = portico.getTipoDato('BUQUE')
                                                            AND srdt_srvc_pk = srvc_pk
                                                    )
                                            )
                                            
                                    )
                            
                            )
                        
                    )
            )
    ) AS TIPO_BUQUE_EEE
    , (
        SELECT prdt_nentero
        FROM tbl_parametro_dato_prdt
        WHERE
            prdt_tpdt_pk = portico.getTipoDato('ENTERO_01')
            AND prdt_prvr_pk = (
                SELECT prvr_pk
                FROM tbl_parametro_version_prvr
                WHERE
                    prvr_fini <= srvc_fref
                    AND (prvr_ffin IS NULL OR prvr_ffin > srvc_fref)
                    AND prvr_prmt_pk = (
                        SELECT srdt_prmt_pk
                        FROM 
                            tbl_servicio_dato_srdt
                        WHERE
                            srdt_tpdt_pk = portico.getTipoDato('BUQUE')
                            AND srdt_srvc_pk = srvc_pk
                    )
            )
    ) AS gt
    
    , (
        SELECT prmt_pk
        FROM tbl_parametro_prmt
        WHERE 
            prmt_tppr_pk = portico.getEntidad('TIPO_BUQUE_GT_EEE')
            AND EXISTS (
                SELECT 1
                FROM tbl_parametro_version_prvr
                WHERE 
                    prvr_prmt_pk = prmt_pk
                    AND prvr_fini <= srvc_fref
                    AND (prvr_ffin IS NULL OR prvr_ffin > srvc_fref)
                    AND EXISTS (
                        SELECT 1
                        FROM 
                            tbl_parametro_dato_prdt
                        WHERE 
                            prdt_prvr_pk = prvr_pk
                            AND prdt_tpdt_pk = portico.getTipoDato('ENTERO_01')
                            AND prdt_nentero = (
                                SELECT MAX(prdt_nentero)
                                FROM 
                                    tbl_parametro_dato_prdt
                                WHERE 
                                    prdt_tpdt_pk = portico.getTipoDato('ENTERO_01')
                                    AND EXISTS (
                                        SELECT 1
                                        FROM tbl_parametro_version_prvr
                                        WHERE 
                                            prvr_pk = prdt_prvr_pk
                                            AND prvr_fini <= srvc_fref
                                            AND (prvr_ffin IS NULL OR prvr_ffin > srvc_fref)
                                            AND  EXISTS (
                                                SELECT 1
                                                FROM tbl_parametro_prmt
                                                WHERE 
                                                    prmt_pk = prvr_prmt_pk
                                                    AND prmt_tppr_pk = portico.getEntidad('TIPO_BUQUE_GT_EEE')
                                            )
                                    )
                                    
                                    AND prdt_nentero < (
                                        SELECT prdt_nentero
                                        FROM tbl_parametro_dato_prdt
                                        WHERE
                                            prdt_tpdt_pk = portico.getTipoDato('ENTERO_01')
                                            AND prdt_prvr_pk = (
                                                SELECT prvr_pk
                                                FROM tbl_parametro_version_prvr
                                                WHERE
                                                    prvr_fini <= srvc_fref
                                                    AND (prvr_ffin IS NULL OR prvr_ffin > srvc_fref)
                                                    AND prvr_prmt_pk = (
                                                        SELECT srdt_prmt_pk
                                                        FROM 
                                                            tbl_servicio_dato_srdt
                                                        WHERE
                                                            srdt_tpdt_pk = portico.getTipoDato('BUQUE')
                                                            AND srdt_srvc_pk = srvc_pk
                                                    )
                                            )
                                    )
        
        
                            
                            )
                    )
            )
    ) AS TIPO_BUQUE_GT_EEE
FROM 
    tbl_servicio_srvc
WHERE
    srvc_tpsr_pk = portico.getEntidad('ESCALA')
    AND srvc_ffin >= to_date('01022015', 'DDMMYYYY')
    AND srvc_ffin < to_date('01032015', 'DDMMYYYY')

    AND EXISTS (
        SELECT 1 FROM tbl_servicio_dato_srdt
        WHERE srdt_srvc_pk = srvc_pk
            AND srdt_tpdt_pk = portico.gettipodato('COD_EXEN')
            AND srdt_cadena IN ('0', '2')
    )
) sql
GROUP BY 
    port
    , TIPO_BUQUE_EEE
    , TIPO_BUQUE_GT_EEE
--ORDER BY TIPO_BUQUE_EEE_prmt, TIPO_BUQUE_GT_EEE_prmt
;    




