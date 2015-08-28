INSERT INTO tbl_parametro_dato_prdt (
	prdt_prvr_pk, prdt_tpdt_pk, prdt_nentero, prdt_ndecimal, prdt_fecha, prdt_prmt_pk, prdt_cadena)
SELECT prvr_pk AS prdt_prvr_pk
    , 45150 AS prdt_tpdt_pk
    , NULL AS prdt_nentero
    , NULL AS prdt_ndecimal
    , NULL AS prdt_fecha
    , (SELECT prmt_pk FROM tbl_parametro_prmt
        WHERE prmt_tppr_pk = portico.getEntidad('SUBPUERTO')
            AND prmt_parametro LIKE 'P'
    ) AS prdt_prmt_pk
    , NULL AS prdt_cadena
FROM tbl_parametro_version_prvr
WHERE
    EXISTS (
        SELECT 1 FROM tbl_parametro_prmt
        WHERE prmt_pk = prvr_prmt_pk
            AND prmt_tppr_pk = portico.getEntidad('BUQUE_PESCA')
    )
;

