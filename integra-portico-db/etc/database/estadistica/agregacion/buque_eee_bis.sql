SELECT prmt_pk
FROM tbl_parametro_prmt
WHERE 
    prmt_tppr_pk = portico.getEntidad('TIPO_BUQUE_GT_EEE')
    AND EXISTS (
        SELECT 1
        FROM tbl_parametro_version_prvr
        WHERE 
            prvr_prmt_pk = prmt_pk
            AND prvr_fini <= SYSDATE
            AND (prvr_ffin IS NULL OR prvr_ffin > SYSDATE)
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
                                    AND prvr_fini <= SYSDATE
                                    AND (prvr_ffin IS NULL OR prvr_ffin > SYSDATE)
                                    AND  EXISTS (
                                        SELECT 1
                                        FROM tbl_parametro_prmt
                                        WHERE 
                                            prmt_pk = prvr_prmt_pk
                                            AND prmt_tppr_pk = portico.getEntidad('TIPO_BUQUE_GT_EEE')
                                    )
                            )


                    
                    )
            )
    )
    
;    




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
            AND prvr_fini <= SYSDATE
            AND (prvr_ffin IS NULL OR prvr_ffin > SYSDATE)
            AND  EXISTS (
                SELECT 1
                FROM tbl_parametro_prmt
                WHERE 
                    prmt_pk = prvr_prmt_pk
                    AND prmt_tppr_pk = portico.getEntidad('TIPO_BUQUE_GT_EEE')
            )
    )
;


