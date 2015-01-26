SELECT srvc_pepr_pk, srvc_tpsr_pk, COUNT(1)
FROM tbl_servicio_srvc 
WHERE srvc_pepr_pk IS NOT NULL
GROUP BY srvc_pepr_pk, srvc_tpsr_pk
ORDER BY srvc_pepr_pk, srvc_tpsr_pk
;




-- Movimiento de Mercancias
SELECT ssrv_pk, ssrv_tpss_pk, srvc_pk, srvc_subp_pk, srvc_fref
	, (
		SELECT ssss_ssrvp_pk
		FROM tbl_subserv_subserv_ssss
		WHERE ssss_ssrvh_pk = ssrv_pk
			AND EXISTS (
				SELECT 1
				FROM tbl_subservicio_ssrv
				WHERE 
					ssrv_srvc_pk = srvc_pk
					AND ssrv_tpss_pk = portico.getEntidad('BL')
			)

	) AS bl_pk
FROM 
	tbl_subservicio_ssrv
	INNER JOIN tbl_servicio_srvc ON
		srvc_pk = ssrv_srvc_pk
WHERE 
	ssrv_tpss_pk IN (portico.getEntidad('PARTIDA'), portico.getEntidad('EQUIPAMIENTO'))
	AND srvc_tpsr_pk = portico.getEntidad('MANIFIESTO')

	AND ssrv_estado = 'R'

	AND (
		srvc_fref >= '2013-05-01'
		AND srvc_fref < '2013-06-01'
	)

	AND EXISTS (
		SELECT 1
		FROM tbl_subservicio_dato_ssdt
		WHERE 
			ssdt_tpdt_pk = portico.getTipoDato('COD_EXEN')
			AND (
				ssdt_cadena = '0'
				OR ssdt_cadena = '2'
			)
			AND ssdt_ssrv_pk = ssrv_pk
	)

	AND NOT EXISTS (
		SELECT 1
		FROM tbl_subserv_subserv_ssss
		WHERE ssss_ssrvh_pk = ssrv_pk
			AND EXISTS (
				SELECT 1
				FROM tbl_subservicio_dato_ssdt
				WHERE 
					ssdt_tpdt_pk = portico.getTipoDato('TIPO_OP_BL')
					AND ssdt_prmt_pk = (
						SELECT prmt_pk
						FROM tbl_parametro_prmt
						WHERE prmt_tppr_pk = portico.getEntidad('TIPO_OPERACION_BL')
							AND prmt_parametro = 'TE'
					)
					AND ssdt_ssrv_pk = ssss_ssrvp_pk
			)
	)
LIMIT 20000
;

SELECT srvc_pk, srvc_subp_pk, srvc_fref, ssrv_pk
FROM 
	tbl_servicio_srvc
	INNER JOIN tbl_subservicio_ssrv ON
		ssrv_srvc_pk = srvc_pk
WHERE
	srvc_tpsr_pk = portico.getEntidad('MANIFIESTO')
	AND ssrv_tpss_pk = portico.getEntidad('PARTIDA')
	AND (
		srvc_fref >= '2013-05-01'
		AND srvc_fref < '2013-06-01'
	)
	AND (
		EXISTS (
			SELECT 1
			FROM tbl_subservicio_dato_ssdt
			WHERE 
				ssdt_tpdt_pk = portico.getTipoDato('COD_EXEN')
				AND ssdt_cadena = '0'
				AND ssdt_ssrv_pk = ssrv_pk
		)
		OR EXISTS (
			SELECT 1
			FROM tbl_subservicio_dato_ssdt
			WHERE 
				ssdt_tpdt_pk = portico.getTipoDato('COD_EXEN')
				AND ssdt_cadena = '2'
				AND ssdt_ssrv_pk = ssrv_pk
		)
	)

	AND ssrv_estado = 'R'

	AND EXISTS (
		SELECT 1
		FROM tbl_subserv_subserv_ssss
		WHERE ssss_ssrvh_pk = ssrv_pk
			AND EXISTS (
				SELECT 1
				FROM tbl_subservicio_dato_ssdt
				WHERE 
					ssdt_tpdt_pk = portico.getTipoDato('TIPO_OP_BL')
					AND ssdt_prmt_pk <> (
						SELECT prmt_pk
						FROM tbl_parametro_prmt
						WHERE prmt_tppr_pk = portico.getEntidad('TIPO_OPERACION_BL')
							AND prmt_parametro = 'TE'
					)
					AND ssdt_ssrv_pk = ssss_ssrvp_pk
			)
	)
LIMIT 20000
;
