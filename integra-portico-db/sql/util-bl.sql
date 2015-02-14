WITH 
	ssrvs AS (
		SELECT ssrv_pk, ssrv_srvc_pk, srvc_subp_pk, srvc_fref
			, (
				SELECT ssrv_pk
				FROM tbl_subservicio_ssrv ssrvMaco
				WHERE ssrv_srvc_pk = srvc_pk
					AND ssrv_tpss_pk = portico.getEntidad('MANIFIESTO_CONSIGNATARIO')
					AND ssrv_pk = ANY (
						SELECT ssss_ssrvp_pk
						FROM tbl_subserv_subserv_ssss
						WHERE ssss_ssrvh_pk = ssrvBL.ssrv_pk
					)
			) AS maco_pk
		FROM tbl_subservicio_ssrv ssrvBL
			INNER JOIN tbl_servicio_srvc ON
				srvc_pk = ssrv_srvc_pk
		WHERE
			ssrv_tpss_pk = portico.getEntidad('BL')
			AND ssrv_srvc_pk = 4484013
	)
	, bls AS (
		SELECT 
			ssrv_pk, ssrv_srvc_pk, srvc_fref
			, (
				SELECT prmt_pk 
				FROM tbl_parametro_prmt
				WHERE prmt_tppr_pk = portico.getEntidad('TIPO_IVA')
					and prmt_parametro = 'G'
			) AS IVA_GENERAL
			, (
				SELECT prmt_pk 
				FROM tbl_parametro_prmt
				WHERE prmt_tppr_pk = portico.getEntidad('TIPO_IVA')
					and prmt_parametro = 'X'
			) AS IVA_EXENTO
			, (
				SELECT ssdt_cadena
				FROM tbl_subservicio_dato_ssdt
				WHERE ssdt_ssrv_pk = ssrv_pk 
					AND ssdt_tpdt_pk = portico.getTipoDato('TIPO_BL')
			) AS TIPO_BL
			, (
				SELECT srdt_prmt_pk
				FROM tbl_servicio_dato_srdt
				WHERE 
					srdt_srvc_pk = ssrv_srvc_pk
					AND srdt_tpdt_pk = portico.getTipoDato('ORGA_2')
			) AS CONSIGNATARIO_MAN
			, (
				SELECT ssdt_prmt_pk
				FROM tbl_subservicio_dato_ssdt
				WHERE ssdt_ssrv_pk = ssrv_pk 
					AND ssdt_tpdt_pk = portico.getTipoDato('ORGA')
			) AS CLIENTE_ADICIONAL
			, (
				SELECT ssdt_prmt_pk
				FROM tbl_subservicio_dato_ssdt
				WHERE 
					ssdt_tpdt_pk = portico.getTipoDato('ORGA')
					AND ssrv_pk = maco_pk
			) AS CONSIGNATARIO_MERC
			, (
				SELECT srdt_nentero
				FROM tbl_servicio_dato_srdt
				WHERE 
					srdt_tpdt_pk = portico.getTipoDato('BOOLEANO_02')
					AND srdt_srvc_pk = ANY (
						SELECT srdt_srvc_pk
						FROM tbl_servicio_dato_srdt
						WHERE 
							srdt_srvc_pk = ssrv_srvc_pk
							AND srdt_tpdt_pk = portico.getTipoDato('ESCALA')
					)
			) AS NAV_INT
			, (
				SELECT srdt_cadena
				FROM tbl_servicio_dato_srdt
				WHERE 
					srdt_srvc_pk = ssrv_srvc_pk
					AND srdt_tpdt_pk = portico.getTipoDato('TIPO_OPER_MANIF')
			) AS TIPO_OPER_MANIF
			, (
				SELECT prdt_nentero
				FROM tbl_parametro_dato_prdt
				WHERE 
					prdt_tpdt_pk = portico.getTipoDato('BOOLEANO_01')
					AND prdt_prvr_pk = ANY (
						SELECT prvr_pk
						FROM tbl_parametro_version_prvr
						WHERE
							srvc_fref BETWEEN prvr_fini AND COALESCE(prvr_ffin, srvc_fref)
							AND prvr_prmt_pk = ANY (
								SELECT prdt_prmt_pk
								FROM tbl_parametro_dato_prdt
								WHERE 
									prdt_tpdt_pk = portico.getTipoDato('PAIS')
									AND prdt_prvr_pk = ANY (
										SELECT prvr_pk
										FROM tbl_parametro_version_prvr
										WHERE
											srvc_fref BETWEEN prvr_fini AND COALESCE(prvr_ffin, srvc_fref)
											AND prvr_prmt_pk = ANY (
												SELECT ssdt_prmt_pk
												FROM tbl_subservicio_dato_ssdt
												WHERE ssdt_ssrv_pk = ssrv_pk 
													AND ssdt_tpdt_pk = portico.getTipoDato('UNLOCODE')
											)
									)
							)
					)
			) AS ORIGEN_UE
			, (
				SELECT prdt_nentero
				FROM tbl_parametro_dato_prdt
				WHERE 
					prdt_tpdt_pk = portico.getTipoDato('BOOLEANO_01')
					AND prdt_prvr_pk = ANY (
						SELECT prvr_pk
						FROM tbl_parametro_version_prvr
						WHERE
							srvc_fref BETWEEN prvr_fini AND COALESCE(prvr_ffin, srvc_fref)
							AND prvr_prmt_pk = ANY (
								SELECT prdt_prmt_pk
								FROM tbl_parametro_dato_prdt
								WHERE 
									prdt_tpdt_pk = portico.getTipoDato('PAIS')
									AND prdt_prvr_pk = ANY (
										SELECT prvr_pk
										FROM tbl_parametro_version_prvr
										WHERE
											srvc_fref BETWEEN prvr_fini AND COALESCE(prvr_ffin, srvc_fref)
											AND prvr_prmt_pk = ANY (
												SELECT ssdt_prmt_pk
												FROM tbl_subservicio_dato_ssdt
												WHERE ssdt_ssrv_pk = ssrv_pk 
													AND ssdt_tpdt_pk = portico.getTipoDato('UNLOCODE_4')
											)
									)
							)
					)
			) AS DESTINO_UE
			, (
				SELECT prdt_prmt_pk
				FROM tbl_parametro_dato_prdt
				WHERE
					prdt_tpdt_pk = portico.getTipoDato('TIPO_IVA')
					AND prdt_prvr_pk = ANY (
						SELECT prvr_pk
						FROM tbl_parametro_version_prvr
						WHERE
							srvc_fref BETWEEN prvr_fini AND COALESCE(prvr_ffin, srvc_fref)
							AND prvr_prmt_pk = srvc_subp_pk
					)
			) TIPO_IVA_SUBP
			, (
				SELECT prdt_prmt_pk
				FROM tbl_parametro_dato_prdt
				WHERE
					prdt_tpdt_pk = portico.getTipoDato('TIPO_IVA')
					AND prdt_prvr_pk = ANY (
						SELECT prvr_pk
						FROM tbl_parametro_version_prvr
						WHERE
							srvc_fref BETWEEN prvr_fini AND COALESCE(prvr_ffin, srvc_fref)
							AND prvr_prmt_pk = ANY (
								SELECT ssdt_prmt_pk
								FROM tbl_subservicio_dato_ssdt
								WHERE ssdt_ssrv_pk = ssrv_pk 
									AND ssdt_tpdt_pk = portico.getTipoDato('TERMINAL')
							)
					)
			) TIPO_IVA_TERMINAL
			, (
				SELECT 1
				FROM tbl_subservicio_dato_ssdt
				WHERE
					ssdt_tpdt_pk = portico.getTipoDato('TIPO_DEST')
					AND ssdt_ssrv_pk = ssrv_pk
					AND ssdt_cadena = 'ZPE'
			) ES_AVIT
			, (
				SELECT prdt_nentero
				FROM
					tbl_parametro_dato_prdt
				WHERE
					prdt_tpdt_pk = portico.getTipoDato('BOOLEANO_02')
					AND prdt_prvr_pk = ANY (
						SELECT prvr_pk
						FROM tbl_parametro_version_prvr
						WHERE
							srvc_fref BETWEEN prvr_fini AND COALESCE(prvr_ffin, srvc_fref)
							AND prvr_prmt_pk = ANY (
								SELECT ssdt_prmt_pk
								FROM tbl_subservicio_dato_ssdt
								WHERE
									ssdt_tpdt_pk = portico.getTipoDato('UNLOCODE_2')
									AND ssdt_ssrv_pk = ssrv_pk
							)
					)
			) ES_CANCEUMEL_CARGA
			, (
				SELECT prdt_nentero
				FROM
					tbl_parametro_dato_prdt
				WHERE
					prdt_tpdt_pk = portico.getTipoDato('BOOLEANO_02')
					AND prdt_prvr_pk = ANY (
						SELECT prvr_pk
						FROM tbl_parametro_version_prvr
						WHERE
							srvc_fref BETWEEN prvr_fini AND COALESCE(prvr_ffin, srvc_fref)
							AND prvr_prmt_pk = ANY (
								SELECT ssdt_prmt_pk
								FROM tbl_subservicio_dato_ssdt
								WHERE
									ssdt_tpdt_pk = portico.getTipoDato('UNLOCODE_3')
									AND ssdt_ssrv_pk = ssrv_pk
							)
					)
			) ES_CANCEUMEL_DESCARGA
			, (
				SELECT prdt_prmt_pk
				FROM tbl_parametro_dato_prdt
				WHERE
					prdt_tpdt_pk = portico.getTipoDato('TIPO_IVA')
					AND prdt_prvr_pk = ANY (
						SELECT prvr_pk
						FROM tbl_parametro_version_prvr
						WHERE
							srvc_fref BETWEEN prvr_fini AND COALESCE(prvr_ffin, srvc_fref)
							AND prvr_prmt_pk = ANY (
								SELECT ssdt_prmt_pk
								FROM tbl_subservicio_dato_ssdt
								WHERE ssdt_ssrv_pk = ssrv_pk 
									AND ssdt_tpdt_pk = portico.getTipoDato('TIPO_NAV')
							)
					)
			) TIPO_IVA_TIPONAV
		FROM ssrvs
	)
UPDATE tbl_subservicio_dato_ssdt SET
	ssdt_prmt_pk = (
		CASE
			WHEN TIPO_BL = 'P'
			THEN
				CASE
					WHEN TIPO_IVA_TIPONAV IS NOT NULL
					THEN TIPO_IVA_TIPONAV
					WHEN NAV_INT = 1
					THEN IVA_EXENTO
					WHEN ES_CANCEUMEL_CARGA = 1 OR ES_CANCEUMEL_DESCARGA = 1
					THEN IVA_EXENTO
					ELSE IVA_GENERAL
				END
			ELSE
				CASE
					WHEN NAV_INT = 1 AND CONSIGNATARIO_MAN = COALESCE(CLIENTE_ADICIONAL, CONSIGNATARIO_MERC)
					THEN IVA_EXENTO
					WHEN (TIPO_OPER_MANIF = 'C' AND DESTINO_UE = 0) OR (TIPO_OPER_MANIF = 'D' AND ORIGEN_UE = 0)
					THEN IVA_EXENTO
					WHEN NAV_INT = 1 AND ES_AVIT = 1
					THEN IVA_EXENTO
					WHEN ES_CANCEUMEL_CARGA = 1 OR ES_CANCEUMEL_DESCARGA = 1
					THEN IVA_EXENTO
					WHEN TIPO_IVA_SUBP IS NOT NULL
					THEN TIPO_IVA_SUBP
					WHEN TIPO_IVA_TERMINAL IS NOT NULL
					THEN TIPO_IVA_TERMINAL
					WHEN CONSIGNATARIO_MAN <> COALESCE(CLIENTE_ADICIONAL, CONSIGNATARIO_MERC)
					THEN IVA_GENERAL
					ELSE IVA_GENERAL
				END
		END 
	)
FROM 
	bls 
WHERE 
	ssdt_ssrv_pk = bls.ssrv_pk
	AND ssdt_tpdt_pk = portico.getTipoDato('TIPO_IVA')
;


SELECT ssrv_pk, ssrv_srvc_pk, srvc_fref
	, (
		SELECT ssrv_pk
		FROM tbl_subservicio_ssrv ssrvMaco
		WHERE ssrv_srvc_pk = srvc_pk
			AND ssrv_tpss_pk = portico.getEntidad('MANIFIESTO_CONSIGNATARIO')
			AND ssrv_pk = ANY (
				SELECT ssss_ssrvp_pk
				FROM tbl_subserv_subserv_ssss
				WHERE ssss_ssrvh_pk = ssrvBL.ssrv_pk
			)
	) AS maco_pk
FROM tbl_subservicio_ssrv ssrvBL
	INNER JOIN tbl_servicio_srvc ON
		srvc_pk = ssrv_srvc_pk
WHERE
	ssrv_tpss_pk = portico.getEntidad('BL')
	AND ssrv_srvc_pk = 4203330
;
	