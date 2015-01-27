SELECT srvc_pepr_pk, srvc_tpsr_pk, COUNT(1)
FROM tbl_servicio_srvc 
WHERE srvc_pepr_pk IS NOT NULL
GROUP BY srvc_pepr_pk, srvc_tpsr_pk
ORDER BY srvc_pepr_pk, srvc_tpsr_pk
;


-- Primera partida de un equipamiento
SELECT *
FROM 
	tbl_subservicio_ssrv
WHERE
	ssrv_tpss_pk = portico.getEntidad('EQUIPAMIENTO')
LIMIT 1000
;



-- Movimiento de Mercancias
SELECT ssrv_pk, ssrv_tpss_pk, srvc_pk, srvc_subp_pk, srvc_fref, estd_subp_pk, bl_pk, BUQUE
	, (
		SELECT ssdt_prmt_pk
		FROM tbl_subservicio_dato_ssdt
		WHERE ssdt_ssrv_pk = bl_pk
			AND ssdt_tpdt_pk = portico.getTipoDato('TIPO_OP_BL')
	) AS TIPO_OP_BL
	, (
		SELECT ssdt_prmt_pk
		FROM tbl_subservicio_dato_ssdt
		WHERE ssdt_ssrv_pk = bl_pk
			AND ssdt_tpdt_pk = portico.getTipoDato('UNLOCODE_2')
	) AS UNLOCODE
	, (
		SELECT ssdt_prmt_pk
		FROM tbl_subservicio_dato_ssdt
		WHERE ssdt_ssrv_pk = bl_pk
			AND ssdt_tpdt_pk = portico.getTipoDato('UNLOCODE_3')
	) AS UNLOCODE_2
	, (
		SELECT ssdt_prmt_pk
		FROM tbl_subservicio_dato_ssdt
		WHERE ssdt_ssrv_pk = bl_pk
			AND ssdt_tpdt_pk = portico.getTipoDato('UNLOCODE')
	) AS UNLOCODE_3
	, (
		SELECT ssdt_prmt_pk
		FROM tbl_subservicio_dato_ssdt
		WHERE ssdt_ssrv_pk = bl_pk
			AND ssdt_tpdt_pk = portico.getTipoDato('UNLOCODE_4')
	) AS UNLOCODE_4
	, (
		SELECT ssdt_prmt_pk
		FROM tbl_subservicio_dato_ssdt
		WHERE ssdt_ssrv_pk = bl_pk
			AND ssdt_tpdt_pk = portico.getTipoDato('ALIN')
	) AS ALIN
	, (
		SELECT ssdt_prmt_pk
		FROM tbl_subservicio_dato_ssdt
		WHERE ssdt_ssrv_pk = bl_pk
			AND ssdt_tpdt_pk = portico.getTipoDato('TIPO_NAV')
	) AS TIPO_NAV
	, (
		SELECT ssdt_cadena
		FROM tbl_subservicio_dato_ssdt
		WHERE ssdt_ssrv_pk = bl_pk
			AND ssdt_tpdt_pk = portico.getTipoDato('TIPO_TRANSPORTE')
	) AS TIPO_TRANSPORTE
	, (
		SELECT 
			ssrv_pk
		FROM 
			tbl_subservicio_ssrv
		WHERE 
			ssrv_srvc_pk = srvc_pk
			AND ssrv_tpss_pk = portico.getEntidad('MANIFIESTO_CONSIGNATARIO')
			AND EXISTS (
				SELECT 1
				FROM tbl_subserv_subserv_ssss
				WHERE
					ssss_ssrvp_pk = ssrv_pk
					AND ssss_ssrvh_pk = bl_pk
			)
	) AS ORGA_2
	, (
		SELECT ssdt_prmt_pk
		FROM tbl_subservicio_dato_ssdt
		WHERE ssdt_ssrv_pk = bl_pk
			AND ssdt_tpdt_pk = portico.getTipoDato('SERV_TRAF')
	) AS SERV_TRAF
	, (
		CASE ssrv_tpss_pk
			WHEN portico.getEntidad('PARTIDA') THEN (
				SELECT ssdt_prmt_pk
				FROM tbl_subservicio_dato_ssdt
				WHERE
					ssdt_ssrv_pk = ssrv_pk
					AND ssdt_tpdt_pk = portico.getTipoDato('MERCANCIA')
			)
			WHEN portico.getEntidad('EQUIPAMIENTO') THEN (
				SELECT prdt_prmt_pk
				FROM 
					tbl_parametro_dato_prdt
				WHERE
					prdt_tpdt_pk = portico.getTipoDato('MERCANCIA')
					AND EXISTS (
						SELECT 1
						FROM tbl_parametro_version_prvr
						WHERE 
							prvr_pk = prdt_prvr_pk
							AND srvc_fref BETWEEN prvr_fini AND COALESCE(prvr_ffin, srvc_fref)
							AND prvr_prmt_pk = (
								SELECT ssdt_prmt_pk
								FROM tbl_subservicio_dato_ssdt
								WHERE
									ssdt_ssrv_pk = ssrv_pk
									AND ssdt_tpdt_pk = portico.getTipoDato('UNIDAD_CARGA')
							)
					)
			)
		END 
	) AS MERCANCIA
	, (
		SELECT ssdt_prmt_pk
		FROM tbl_subservicio_dato_ssdt
		WHERE ssdt_ssrv_pk = ssrv_pk
			AND ssdt_tpdt_pk = portico.getTipoDato('UNIDAD_CARGA')
	) AS UNIDAD_CARGA
	, (
		CASE ssrv_tpss_pk
			WHEN portico.getEntidad('PARTIDA') THEN (
				SELECT ssdt_nentero
				FROM tbl_subservicio_dato_ssdt
				WHERE
					ssdt_ssrv_pk = ssrv_pk
					AND ssdt_tpdt_pk = portico.getTipoDato('BOOLEANO_02')
			)
			WHEN portico.getEntidad('EQUIPAMIENTO') THEN (
				SELECT ssdt_nentero
				FROM tbl_subservicio_dato_ssdt
				WHERE
					ssdt_ssrv_pk = ssrv_pk
					AND ssdt_tpdt_pk = portico.getTipoDato('BOOLEANO_01')
			)
		END 
	) AS BOOLEANO_01
FROM (
	SELECT ssrv_pk, ssrv_tpss_pk, srvc_pk, srvc_subp_pk, srvc_fref
		, (
			SELECT prdt_prmt_pk
			FROM tbl_parametro_dato_prdt
			WHERE
				prdt_tpdt_pk = portico.getTipoDato('AUT_PORT')
				AND prdt_prvr_pk = ANY (
					SELECT prvr_pk
					FROM tbl_parametro_version_prvr
					WHERE
						srvc_fref BETWEEN prvr_fini AND COALESCE(prvr_ffin, srvc_fref)
						AND prvr_prmt_pk = srvc_subp_pk
				)
		) AS estd_subp_pk
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
		, (
			SELECT srdt_prmt_pk
			FROM tbl_servicio_dato_srdt
			WHERE
				srdt_tpdt_pk = portico.getTipoDato('BUQUE')
				AND srdt_srvc_pk = (
					SELECT srdt_srvc_dep_pk
					FROM tbl_servicio_dato_srdt
					WHERE
						srdt_srvc_pk = srvc_pk
						AND srdt_tpdt_pk = portico.getTipoDato('ESCALA')
				)
		) AS BUQUE
	FROM 
		tbl_subservicio_ssrv
		INNER JOIN tbl_servicio_srvc ON
			srvc_pk = ssrv_srvc_pk
	WHERE 
		ssrv_estado = 'R'

		AND (
			srvc_fref >= '2013-05-01'
			AND srvc_fref < '2013-06-01'
		)
		
		AND (
			(
				ssrv_tpss_pk = portico.getEntidad('PARTIDA')
				AND EXISTS (
					SELECT 1
					FROM tbl_subservicio_dato_ssdt
					WHERE ssdt_ssrv_pk = ssrv_pk
						AND ssdt_tpdt_pk = portico.getTipoDato('BOOLEANO_01')
						AND ssdt_nentero = 0
				)
			)
			OR (
				ssrv_tpss_pk = portico.getEntidad('EQUIPAMIENTO')
				AND EXISTS (
					SELECT 1
					FROM tbl_subservicio_dato_ssdt
					WHERE ssdt_ssrv_pk = ssrv_pk
						AND ssdt_tpdt_pk = portico.getTipoDato('UNIDAD_CARGA')
						AND EXISTS (
							SELECT 1
							FROM tbl_parametro_version_prvr
							WHERE 
								prvr_prmt_pk = ssdt_prmt_pk
								AND srvc_fref BETWEEN prvr_fini AND COALESCE(prvr_ffin, srvc_fref)
								AND EXISTS (
									SELECT 1 
									FROM tbl_parametro_dato_prdt
									WHERE 
										prdt_prvr_pk = prvr_pk
										AND prdt_tpdt_pk = portico.getTipoDato('MERCANCIA')
										AND prdt_prmt_pk IS NOT NULL
								)
						)
				)
			)
		)

		AND srvc_tpsr_pk = portico.getEntidad('MANIFIESTO')


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
) sql
;


