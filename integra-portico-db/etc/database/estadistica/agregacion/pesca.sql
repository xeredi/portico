        SELECT *
        FROM tbl_subservicio_ssrv
            INNER JOIN tbl_servicio_srvc ON
                srvc_pk = ssrv_srvc_pk
        WHERE
            ssrv_tpss_pk = portico.getentidad('PARTIDA_PESCA')

            AND EXISTS (
                SELECT 1 FROM tbl_servicio_dato_srdt
                WHERE srdt_srvc_pk = srvc_pk
                    AND srdt_tpdt_pk = portico.gettipodato('COD_EXEN')
                    AND srdt_cadena IN ('0', '2')
            )
            
            AND srvc_fref >= to_date('01012015', 'DDMMYYYY')
            AND srvc_fref  < to_date('01062015', 'DDMMYYYY')
;