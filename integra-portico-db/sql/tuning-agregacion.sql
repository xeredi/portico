
		SELECT
			estd_subp_pk
			, (SELECT prmt_parametro FROM tbl_parametro_prmt
				WHERE prmt_pk = estd_subp_pk) AS estd_subp
			, BUQUE
			, (SELECT prmt_parametro FROM tbl_parametro_prmt
				WHERE prmt_pk = BUQUE) AS BUQUE_prmt
			, TIPO_OP_BL
			, (SELECT prmt_parametro FROM tbl_parametro_prmt
				WHERE prmt_pk = TIPO_OP_BL) AS TIPO_OP_BL_prmt
			, UNLOCODE
			, (SELECT prmt_parametro FROM tbl_parametro_prmt
				WHERE prmt_pk = UNLOCODE) AS UNLOCODE_prmt
			, UNLOCODE_2
			, (SELECT prmt_parametro FROM tbl_parametro_prmt
				WHERE prmt_pk = UNLOCODE_2) AS UNLOCODE_2_prmt
			, UNLOCODE_3
			, (SELECT prmt_parametro FROM tbl_parametro_prmt
				WHERE prmt_pk = UNLOCODE_3) AS UNLOCODE_3_prmt
			, UNLOCODE_4
			, (SELECT prmt_parametro FROM tbl_parametro_prmt
				WHERE prmt_pk = UNLOCODE_4) AS UNLOCODE_4_prmt
			, ALIN
			, (SELECT prmt_parametro FROM tbl_parametro_prmt
				WHERE prmt_pk = ALIN) AS ALIN_prmt
			, TIPO_NAV
			, (SELECT prmt_parametro FROM tbl_parametro_prmt
				WHERE prmt_pk = TIPO_NAV) AS TIPO_NAV_prmt
			, TIPO_TRANSPORTE
			, ORGA_2
			, (SELECT prmt_parametro FROM tbl_parametro_prmt
				WHERE prmt_pk = ORGA_2) AS ORGA_2_prmt
			, SERV_TRAF
			, (SELECT prmt_parametro FROM tbl_parametro_prmt
				WHERE prmt_pk = SERV_TRAF) AS SERV_TRAF_prmt
			, MERCANCIA
			, (SELECT prmt_parametro FROM tbl_parametro_prmt
				WHERE prmt_pk = MERCANCIA) AS MERCANCIA_prmt
			, UNIDAD_CARGA
			, (SELECT prmt_parametro FROM tbl_parametro_prmt
				WHERE prmt_pk = UNIDAD_CARGA) AS UNIDAD_CARGA_prmt
			, BOOLEANO_01
			, INST_ESP
			, (SELECT prmt_parametro FROM tbl_parametro_prmt
				WHERE prmt_pk = INST_ESP) AS INST_ESP_prmt
			, ACUERDO
			, (SELECT prmt_parametro FROM tbl_parametro_prmt
				WHERE prmt_pk = ACUERDO) AS ACUERDO_prmt
			, TERMINAL
			, (SELECT prmt_parametro FROM tbl_parametro_prmt
				WHERE prmt_pk = TERMINAL) AS TERMINAL_prmt
			, TIPO_EQUI
			, (SELECT prmt_parametro FROM tbl_parametro_prmt
				WHERE prmt_pk = TIPO_EQUI) AS TIPO_EQUI_prmt
			, SUM(COALESCE(DECIMAL_01, 0)) / 1000 AS DECIMAL_01, SUM(COALESCE(ENTERO_01, 0)) AS ENTERO_01, SUM(COALESCE(DECIMAL_02, 0) * COALESCE(ENTERO_01, 0)) AS DECIMAL_02
		FROM (
			SELECT sql.*
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
					SELECT ssdt_prmt_pk
					FROM
						tbl_subservicio_dato_ssdt
					WHERE
						ssdt_tpdt_pk = portico.getTipoDato('ORGA')
						AND ssdt_ssrv_pk = (
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
				, (
					SELECT ssdt_prmt_pk
					FROM tbl_subservicio_dato_ssdt
					WHERE ssdt_ssrv_pk = part_pk
						AND ssdt_tpdt_pk = portico.getTipoDato('INST_ESP')
				) AS INST_ESP
				, (
					SELECT ssdt_prmt_pk
					FROM tbl_subservicio_dato_ssdt
					WHERE ssdt_ssrv_pk = part_pk
						AND ssdt_tpdt_pk = portico.getTipoDato('ORGA')
				) AS ORGA
				, (
					SELECT ssdt_prmt_pk
					FROM tbl_subservicio_dato_ssdt
					WHERE ssdt_ssrv_pk = part_pk
						AND ssdt_tpdt_pk = portico.getTipoDato('ACUERDO')
				) AS ACUERDO
				, (
					SELECT ssdt_prmt_pk
					FROM tbl_subservicio_dato_ssdt
					WHERE ssdt_ssrv_pk = part_pk
						AND ssdt_tpdt_pk = portico.getTipoDato('TERMINAL')
				) AS TERMINAL
				, (
					CASE ssrv_tpss_pk
						WHEN portico.getEntidad('EQUIPAMIENTO') THEN (
							SELECT ssdt_prmt_pk
							FROM tbl_subservicio_dato_ssdt
							WHERE
								ssdt_ssrv_pk = ssrv_pk
								AND ssdt_tpdt_pk = portico.getTipoDato('TIPO_EQUI')
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
												AND prdt_tpdt_pk = portico.getTipoDato('BOOLEANO_01')
												AND prdt_nentero = 1
										)
								)
						)
					END
				) AS TIPO_EQUI
				, (
					CASE ssrv_tpss_pk
						WHEN portico.getEntidad('PARTIDA') THEN (
							SELECT ssdt_nentero
							FROM tbl_subservicio_dato_ssdt
							WHERE
								ssdt_ssrv_pk = ssrv_pk
								AND ssdt_tpdt_pk = portico.getTipoDato('ENTERO_04')
						)
						WHEN portico.getEntidad('EQUIPAMIENTO') THEN (
							SELECT ssdt_nentero
							FROM tbl_subservicio_dato_ssdt
							WHERE
								ssdt_ssrv_pk = ssrv_pk
								AND ssdt_tpdt_pk = portico.getTipoDato('ENTERO_02')
						)
					END
				) AS DECIMAL_01
				, (
					CASE ssrv_tpss_pk
						WHEN portico.getEntidad('PARTIDA')
						THEN (
							SELECT ssdt_nentero
							FROM tbl_subservicio_dato_ssdt
							WHERE
								ssdt_ssrv_pk = ssrv_pk
								AND ssdt_tpdt_pk = portico.getTipoDato('ENTERO_03')
						)
						WHEN portico.getEntidad('EQUIPAMIENTO')
						THEN (
							CASE
								WHEN EXISTS (
									SELECT 1
									FROM tbl_subservicio_dato_ssdt
									WHERE
										ssdt_ssrv_pk = ssrv_pk
										AND ssdt_tpdt_pk = portico.getTipoDato('CADENA_02')
										AND ssdt_cadena = '4'
								)
								THEN (
									SELECT ssdt_nentero
									FROM tbl_subservicio_dato_ssdt
									WHERE
										ssdt_ssrv_pk = ssrv_pk
										AND ssdt_tpdt_pk = portico.getTipoDato('ENTERO_01')
								)
								ELSE 1
							END
						)
					END
				) AS ENTERO_01
				, (
					CASE ssrv_tpss_pk
						WHEN portico.getEntidad('EQUIPAMIENTO')
						THEN (
							SELECT prdt_ndecimal
							FROM tbl_parametro_dato_prdt
							WHERE
								prdt_tpdt_pk = portico.getTipoDato('DECIMAL_01')
								AND EXISTS (
									SELECT 1
									FROM tbl_parametro_version_prvr
									WHERE
										prvr_pk = prdt_prvr_pk
										AND srvc_fref BETWEEN prvr_fini AND COALESCE(prvr_ffin, srvc_fref)
										AND EXISTS (
											SELECT 1
											FROM tbl_subservicio_dato_ssdt
											WHERE
												ssdt_ssrv_pk = ssrv_pk
												AND ssdt_tpdt_pk = portico.getTipoDato('UNIDAD_CARGA')
												AND ssdt_prmt_pk = prvr_prmt_pk
										)
								)
						)
					END
				) AS DECIMAL_02
			FROM (
				WITH manifiestos AS (
					SELECT srvc_pk, srvc_subp_pk, srvc_fref
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
							SELECT srdt_prmt_pk
							FROM tbl_servicio_dato_srdt
							WHERE
								srdt_tpdt_pk = portico.getTipoDato('BUQUE')
								AND srdt_srvc_pk = (
									SELECT srdt_srvc_dep_pk
									FROM tbl_servicio_dato_srdt
									WHERE
										srdt_tpdt_pk = portico.getTipoDato('ESCALA')
										AND srdt_srvc_pk = srvc_pk
								)
						) AS BUQUE
					FROM tbl_servicio_srvc
					WHERE
						srvc_tpsr_pk = portico.getEntidad('MANIFIESTO')
						AND srvc_fref >= #{fini}
						AND srvc_fref < #{ffin}
						AND srvc_subp_pk IN
    ]]>
		<foreach collection="subpIds" item="item" open="(" close=")"
			separator=",">#{item}
		</foreach>
    <![CDATA[
				)
				SELECT ssrv_pk, ssrv_tpss_pk, srvc_pk, srvc_subp_pk, srvc_fref, estd_subp_pk, BUQUE
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
						CASE ssrv_tpss_pk
							WHEN portico.getEntidad('EQUIPAMIENTO') THEN (
								SELECT MIN(paeq_part.ssss_ssrvp_pk)
								FROM
									tbl_subserv_subserv_ssss equi_paeq
									INNER JOIN tbl_subserv_subserv_ssss paeq_part ON
										equi_paeq.ssss_ssrvh_pk = paeq_part.ssss_ssrvh_pk
								WHERE
									EXISTS (
										SELECT 1
										FROM tbl_subservicio_ssrv
										WHERE
											ssrv_tpss_pk = portico.getEntidad('PARTIDA')
											AND ssrv_pk = paeq_part.ssss_ssrvp_pk
									)
									AND equi_paeq.ssss_ssrvp_pk = ssrv_pk
							)
							ELSE ssrv_pk
						END
					) AS part_pk
				FROM
					tbl_subservicio_ssrv
					INNER JOIN manifiestos ON
						srvc_pk = ssrv_srvc_pk
				WHERE
						ssrv_estado = 'R'

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
			) sql
		) sql
		GROUP BY
			estd_subp_pk, BUQUE, TIPO_OP_BL, UNLOCODE, UNLOCODE_2, UNLOCODE_3, UNLOCODE_4, ALIN, TIPO_NAV, TIPO_TRANSPORTE, ORGA_2, SERV_TRAF, MERCANCIA
			, UNIDAD_CARGA, BOOLEANO_01, INST_ESP, ACUERDO, TERMINAL, TIPO_EQUI
;


WITH ucList AS (
	SELECT prmt_pk, prvr_fini, prvr_ffin, prdt_prmt_pk
	FROM tbl_parametro_prmt
		INNER JOIN tbl_parametro_version_prvr ON
			prvr_prmt_pk = prmt_pk
		INNER JOIN tbl_parametro_dato_prdt ON
			prdt_prvr_pk = prvr_pk
	WHERE
		prmt_tppr_pk = portico.getEntidad('UNIDAD_CARGA')
		AND prdt_tpdt_pk = portico.getTipoDato('MERCANCIA')
)
SELECT *
FROM
	tbl_subservicio_ssrv
WHERE
	(
		(
			ssrv_tpss_pk = portico.getEntidad('PARTIDA')
			AND EXISTS (
				SELECT 1
				FROM tbl_subservicio_dato_ssdt
				WHERE ssdt_ssrv_pk = ssrv_pk
					AND ssdt_tpdt_pk = portico.getTipoDato('BOOLEANO_01')
					AND ssdt_nentero = 0
			)
		) OR (
			ssrv_tpss_pk = portico.getEntidad('EQUIPAMIENTO')
			AND EXISTS (
				SELECT 1
				FROM tbl_subservicio_dato_ssdt
				WHERE ssdt_ssrv_pk = ssrv_pk
					AND ssdt_tpdt_pk = portico.getTipoDato('UNIDAD_CARGA')
					AND EXISTS (
						SELECT 1
						FROM ucList
						WHERE prmt_pk = ssdt_prmt_pk
							AND prdt_prmt_pk IS NOT NULL
					)
			)
		)
	)
	AND ssrv_estado = 'R'
	AND EXISTS (
		SELECT 1
		FROM tbl_subservicio_dato_ssdt
		WHERE ssdt_ssrv_pk = ssrv_pk
			AND ssdt_tpdt_pk = portico.getTipoDato('COD_EXEN')
			AND ssdt_cadena IN ('0', '2')
	)
	AND ssrv_pk = ANY (
		SELECT ssss_ssrvh_pk
		FROM tbl_subserv_subserv_ssss
		WHERE ssss_ssrvp_pk = ANY (
			SELECT ssrv_pk
			FROM tbl_subservicio_ssrv ssrv
			WHERE
				ssrv_tpss_pk = portico.getEntidad('BL')
				AND EXISTS (
					SELECT 1
					FROM tbl_servicio_srvc
					WHERE
						srvc_pk = ssrv_srvc_pk
						AND srvc_tpsr_pk = portico.getEntidad('MANIFIESTO')
						AND srvc_fref >= '01-01-2013'
						AND srvc_fref < '01-06-2013'
				)
				AND EXISTS (
					SELECT 1
					FROM tbl_subservicio_dato_ssdt
					WHERE ssdt_ssrv_pk = ssrv_pk
						AND ssdt_tpdt_pk = portico.getTipoDato('TIPO_OP_BL')
						AND ssdt_prmt_pk <> (
							SELECT prmt_pk
							FROM tbl_parametro_prmt
							WHERE prmt_tppr_pk = portico.getEntidad('TIPO_OPERACION_BL')
								AND prmt_parametro = 'TE'
						)
				)
		)
	)
;

SELECT *
FROM tbl_subservicio_ssrv ssrv
WHERE
	ssrv_tpss_pk = portico.getEntidad('BL')
	AND EXISTS (
		SELECT 1
		FROM tbl_servicio_srvc
		WHERE
			srvc_pk = ssrv_srvc_pk
			AND srvc_tpsr_pk = portico.getEntidad('MANIFIESTO')
			AND srvc_fref >= '01-01-2013'
			AND srvc_fref < '01-05-2013'
	)
	AND EXISTS (
		SELECT 1
		FROM tbl_subservicio_dato_ssdt
		WHERE ssdt_ssrv_pk = ssrv_pk
			AND ssdt_tpdt_pk = portico.getTipoDato('TIPO_OP_BL')
			AND ssdt_prmt_pk <> (
				SELECT prmt_pk
				FROM tbl_parametro_prmt
				WHERE prmt_tppr_pk = portico.getEntidad('TIPO_OPERACION_BL')
					AND prmt_parametro = 'TE'
			)
	)
;


SELECT *
FROM tbl_subservicio_ssrv ssrv
WHERE
	ssrv_tpss_pk IN (portico.getEntidad('PARTIDA'), portico.getEntidad('EQUIPAMIENTO'))
	AND EXISTS (
		SELECT 1
		FROM tbl_servicio_srvc
		WHERE
			srvc_pk = ssrv_srvc_pk
			AND srvc_tpsr_pk = portico.getEntidad('MANIFIESTO')
			AND srvc_fref >= '01-01-2013'
			AND srvc_fref < '01-06-2013'
	)
	AND EXISTS (
		SELECT 1
		FROM tbl_subserv_subserv_ssss
		WHERE
			ssss_ssrvh_pk = ssrv.ssrv_pk
/*
			AND EXISTS (
				SELECT 1
				FROM tbl_subservicio_ssrv ssrvBl
				WHERE ssrvBl.ssrv_tpss_pk = portico.getEntidad('BL')
					AND ssrvBl.ssrv_pk = ssss_ssrvp_pk

					AND EXISTS (
						SELECT 1
						FROM tbl_subservicio_dato_ssdt
						WHERE ssdt_ssrv_pk = ssrvBl.ssrv_pk
							AND ssdt_tpdt_pk = portico.getTipoDato('TIPO_OP_BL')
							AND ssdt_prmt_pk <> (
								SELECT prmt_pk FROM tbl_parametro_prmt
								WHERE prmt_tppr_pk = portico.getEntidad('TIPO_OPERACION_BL')
									AND prmt_parametro = 'TE'
							)
					)
			)
*/
	)
;

