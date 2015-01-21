-- AGREGACION PESCA
SELECT srvc_subp_pk, tipoCaptura, SUM(kilos), SUM(precio)
	, tipoOperacion, especie, arte, zona, vendedor
FROM (
	SELECT 
		srvc_tpsr_pk, srvc_subp_pk, srvc_anno, srvc_fref, srvc_estado, ssrv_tpss_pk, ssrv_estado
		, (
			SELECT prdt_prmt_pk
			FROM tbl_parametro_dato_prdt
			WHERE 
				prdt_tpdt_pk = portico.getTipoDato('TIPO_CAPTURA_PESCA')
				AND prdt_prvr_pk = ANY (
					SELECT prvr_pk
					FROM tbl_parametro_version_prvr
					WHERE 
						srvc_fref BETWEEN prvr_fini AND COALESCE(prvr_ffin, NOW())
						AND prvr_prmt_pk = ANY (
							SELECT ssdt_prmt_pk
							FROM tbl_subservicio_dato_ssdt
							WHERE 
								ssdt_ssrv_pk = ssrv_pk
								AND ssdt_tpdt_pk = portico.getTipoDato('ESPECIE_PESCA')
						)
				)
		) AS tipoCaptura
		, (
			SELECT ssdt_ndecimal
			FROM tbl_subservicio_dato_ssdt
			WHERE 
				ssdt_ssrv_pk = ssrv_pk
				AND ssdt_tpdt_pk = portico.getTipoDato('DECIMAL_02')
		) AS kilos
		, (
			SELECT ssdt_ndecimal
			FROM tbl_subservicio_dato_ssdt
			WHERE 
				ssdt_ssrv_pk = ssrv_pk
				AND ssdt_tpdt_pk = portico.getTipoDato('DECIMAL_03')
		) AS precio
		, (
			SELECT srdt_prmt_pk
			FROM tbl_servicio_dato_srdt
			WHERE 
				srdt_srvc_pk = srvc_pk
				AND srdt_tpdt_pk = portico.getTipoDato('TIPO_OP_PESCA')
		) AS tipoOperacion
		, (
			SELECT ssdt_prmt_pk
			FROM tbl_subservicio_dato_ssdt
			WHERE 
				ssdt_ssrv_pk = ssrv_pk
				AND ssdt_tpdt_pk = portico.getTipoDato('ESPECIE_PESCA')
		) AS especie
		, (
			SELECT srdt_prmt_pk
			FROM tbl_servicio_dato_srdt
			WHERE 
				srdt_srvc_pk = srvc_pk
				AND srdt_tpdt_pk = portico.getTipoDato('ARTE_PESCA')
		) AS arte
		, (
			SELECT srdt_prmt_pk
			FROM tbl_servicio_dato_srdt
			WHERE 
				srdt_srvc_pk = srvc_pk
				AND srdt_tpdt_pk = portico.getTipoDato('ZONA_PESCA')
		) AS zona
		, (
			SELECT srdt_prmt_pk
			FROM tbl_servicio_dato_srdt
			WHERE 
				srdt_srvc_pk = srvc_pk
				AND srdt_tpdt_pk = portico.getTipoDato('ORGA')
		) AS vendedor
	FROM 
		tbl_servicio_srvc
		INNER JOIN tbl_subservicio_ssrv ON 
			ssrv_srvc_pk = srvc_pk
	WHERE 
		srvc_tpsr_pk = portico.getEntidad('MANIFIESTO_PESCA')
		AND ssrv_tpss_pk = portico.getEntidad('PARTIDA_PESCA')
		AND (
			EXISTS (
				SELECT 1
				FROM tbl_servicio_dato_srdt
				WHERE 
					srdt_tpdt_pk = portico.getTipoDato('COD_EXEN')
					AND srdt_cadena = '0'
					AND srdt_srvc_pk = srvc_pk
			)
			OR EXISTS (
				SELECT 1
				FROM tbl_servicio_dato_srdt
				WHERE 
					srdt_tpdt_pk = portico.getTipoDato('COD_EXEN')
					AND srdt_cadena = '2'
					AND srdt_srvc_pk = srvc_pk
			)
		)
		AND (
			srvc_fref >= '2013-05-01'
			AND srvc_fref < '2013-06-01'
		)
) sql
GROUP BY 
	srvc_subp_pk, tipoCaptura
	, tipoOperacion, especie, arte, zona, vendedor
;



-- AVITUALLAMIENTO
-- Lecturas de Consumo con tipo de suministro = Avituallamiento
-- TODO Falta la parte de partidas
SELECT srvc_subp_pk, tipoSum, SUM(consumo)
FROM (
	WITH avituallamientos AS (
		SELECT prmt_pk, prvr_fini, prvr_ffin
		FROM 
			tbl_parametro_prmt
			INNER JOIN tbl_parametro_version_prvr ON
				prvr_prmt_pk = prmt_pk
		WHERE 
			prmt_tppr_pk = portico.getEntidad('TIPO_SUMINISTRO')
			AND EXISTS (
				SELECT 1 
				FROM tbl_parametro_dato_prdt
				WHERE prdt_prvr_pk = prvr_pk 
					AND prdt_tpdt_pk = portico.getTipoDato('BOOLEANO_01')
					AND prdt_nentero = 1
			)
	)
	SELECT srvc_tpsr_pk, srvc_subp_pk, srvc_anno, srvc_fref, srvc_estado, ssrv_tpss_pk, ssrv_estado
		, (
			SELECT srdt_prmt_pk
			FROM tbl_servicio_dato_srdt
			WHERE srdt_srvc_pk = srvc_pk
				AND srdt_tpdt_pk = portico.getTipoDato('TIPO_SUM')
		) AS tipoSum
		, (
			SELECT ssdt_ndecimal
			FROM tbl_subservicio_dato_ssdt
			WHERE 
				ssdt_ssrv_pk = ssrv_pk
				AND ssdt_tpdt_pk = portico.getTipoDato('DECIMAL_03')
		) AS consumo
	FROM 
		tbl_servicio_srvc
		INNER JOIN tbl_subservicio_ssrv ON 
			ssrv_srvc_pk = srvc_pk
	WHERE 
		srvc_tpsr_pk = portico.getEntidad('SUMINISTRO_CONSUMO')
		AND ssrv_tpss_pk = portico.getEntidad('SUMINISTRO_CONSUMO_LECTURA')
		AND EXISTS (
			SELECT 1
			FROM tbl_servicio_dato_srdt
			WHERE srdt_srvc_pk = srvc_pk
				AND srdt_tpdt_pk = portico.getTipoDato('TIPO_SUM')
				AND srdt_prmt_pk = ANY (
					SELECT prmt_pk
					FROM avituallamientos
					WHERE srvc_fref BETWEEN prvr_fini AND COALESCE(prvr_ffin, NOW())
				)
		)
		AND (
			EXISTS (
				SELECT 1
				FROM tbl_servicio_dato_srdt
				WHERE 
					srdt_tpdt_pk = portico.getTipoDato('COD_EXEN')
					AND srdt_cadena = '0'
					AND srdt_srvc_pk = srvc_pk
			)
			OR EXISTS (
				SELECT 1
				FROM tbl_servicio_dato_srdt
				WHERE 
					srdt_tpdt_pk = portico.getTipoDato('COD_EXEN')
					AND srdt_cadena = '2'
					AND srdt_srvc_pk = srvc_pk
			)
		)
		AND (
			srvc_fref >= '2013-05-01'
			AND srvc_fref < '2013-06-01'
		)
) sql
GROUP BY srvc_subp_pk, tipoSum
;





-- AGREGACION DE ESCALAS
-- Los buques de guerra BG no se cogen????
SELECT 
	srvc_subp_pk, tipoActividad_pk, tipoBuqueGT_pk, tipoBuque_pk, tipoNavEnt_pk, tipoNavSal_pk, paisBuque_pk, COUNT(1) AS numEscalas, SUM(gt)
	, buque_pk, tipoEstancia, servicioTrafico_pk, acuerdo_pk, consignatario_pk
FROM (	
	WITH buqueTipoGT AS (
		SELECT prmt_pk, prvr_fini, prvr_ffin
			, (
				SELECT prdt_nentero 
				FROM tbl_parametro_dato_prdt
				WHERE prdt_prvr_pk = prvr_pk 
					AND prdt_tpdt_pk = portico.getTipoDato('ENTERO_01')
			) AS limiteSup
		FROM 
			tbl_parametro_prmt
			INNER JOIN tbl_parametro_version_prvr ON
				prvr_prmt_pk = prmt_pk
		WHERE 
			prmt_tppr_pk = portico.getEntidad('TIPO_BUQUE_GT')
	)
	SELECT 
		srvc_subp_pk, buque_pk
		, (
			SELECT ssdt_prmt_pk
			FROM tbl_subservicio_dato_ssdt
			WHERE 
				ssdt_ssrv_pk = atraque_pk
				AND ssdt_tpdt_pk = portico.getTipoDato('TIPO_ACT')
		) AS tipoActividad_pk
		, (
			SELECT prdt_prmt_pk
			FROM tbl_parametro_dato_prdt
			WHERE 
				prdt_tpdt_pk = portico.getTipoDato('TIPO_BUQUE')
				AND prdt_prvr_pk = ANY (
					SELECT prvr_pk
					FROM tbl_parametro_version_prvr
					WHERE 
						srvc_fref BETWEEN prvr_fini AND COALESCE(prvr_ffin, NOW())
						AND prvr_prmt_pk = buque_pk
				)
		) AS tipoBuque_pk
		, (
			SELECT prmt_pk
			FROM buqueTipoGT
			WHERE 
				srvc_fref BETWEEN prvr_fini AND COALESCE(prvr_ffin, NOW())
				AND limiteSup = (
					SELECT MIN(limiteSup)
					FROM buqueTipoGT
					WHERE 
						srvc_fref BETWEEN prvr_fini AND COALESCE(prvr_ffin, NOW())
						AND limiteSup >= (
							SELECT prdt_nentero
							FROM tbl_parametro_dato_prdt
							WHERE 
								prdt_tpdt_pk = portico.getTipoDato('ENTERO_01')
								AND prdt_prvr_pk = ANY (
									SELECT prvr_pk
									FROM tbl_parametro_version_prvr
									WHERE 
										srvc_fref BETWEEN prvr_fini AND COALESCE(prvr_ffin, NOW())
										AND prvr_prmt_pk = buque_pk
								)
						)
						
				) 
		) AS tipoBuqueGT_pk
		, (
			SELECT srdt_prmt_pk
			FROM tbl_servicio_dato_srdt
			WHERE srdt_srvc_pk = srvc_pk
				AND srdt_tpdt_pk = portico.getTipoDato('TIPO_NAV')
		) AS tipoNavEnt_pk
		, (
			SELECT srdt_prmt_pk
			FROM tbl_servicio_dato_srdt
			WHERE srdt_srvc_pk = srvc_pk
				AND srdt_tpdt_pk = portico.getTipoDato('TIPO_NAV_2')
		) AS tipoNavSal_pk
		, (
			SELECT prdt_prmt_pk
			FROM tbl_parametro_dato_prdt
			WHERE 
				prdt_tpdt_pk = portico.getTipoDato('PAIS')
				AND prdt_prvr_pk = ANY (
					SELECT prvr_pk
					FROM tbl_parametro_version_prvr
					WHERE 
						srvc_fref BETWEEN prvr_fini AND COALESCE(prvr_ffin, NOW())
						AND prvr_prmt_pk = buque_pk
				)
		) AS paisBuque_pk
		, (
			SELECT srdt_cadena
			FROM tbl_servicio_dato_srdt
			WHERE srdt_srvc_pk = srvc_pk
				AND srdt_tpdt_pk = portico.getTipoDato('TIPO_ESTAN_ESC')
		) AS tipoEstancia
		, (
			SELECT srdt_prmt_pk
			FROM tbl_servicio_dato_srdt
			WHERE srdt_srvc_pk = srvc_pk
				AND srdt_tpdt_pk = portico.getTipoDato('SERV_TRAF')
		) AS servicioTrafico_pk
		, (
			SELECT srdt_prmt_pk
			FROM tbl_servicio_dato_srdt
			WHERE srdt_srvc_pk = srvc_pk
				AND srdt_tpdt_pk = portico.getTipoDato('ACUERDO')
		) AS acuerdo_pk
		, (
			SELECT ssdt_prmt_pk
			FROM tbl_subservicio_dato_ssdt
			WHERE ssdt_ssrv_pk = atraque_pk
				AND ssdt_tpdt_pk = portico.getTipoDato('ORGA_2')
		) AS consignatario_pk
		, (
			SELECT prdt_nentero
			FROM tbl_parametro_dato_prdt
			WHERE 
				prdt_tpdt_pk = portico.getTipoDato('ENTERO_01')
				AND prdt_prvr_pk = ANY (
					SELECT prvr_pk
					FROM tbl_parametro_version_prvr
					WHERE 
						srvc_fref BETWEEN prvr_fini AND COALESCE(prvr_ffin, NOW())
						AND prvr_prmt_pk = buque_pk
				)
		) AS gt
	FROM (
		SELECT 
			srvc_pk, srvc_subp_pk, srvc_fref, srvc_fini, srvc_ffin
			, (
				SELECT srdt_prmt_pk
				FROM 
					tbl_servicio_dato_srdt
				WHERE
					srdt_srvc_pk = srvc_pk
					AND srdt_tpdt_pk = portico.getTipoDato('BUQUE') 
			) AS buque_pk
			, (
				SELECT MIN(ssrv_pk)
				FROM tbl_subservicio_ssrv
				WHERE 
					ssrv_tpss_pk = portico.getEntidad('ATRAQUE')
					AND ssrv_estado = 'F'
					AND ssrv_srvc_pk = srvc_pk
					AND EXISTS (
						SELECT 1 
						FROM tbl_subservicio_dato_ssdt
						WHERE ssdt_ssrv_pk = ssrv_pk
							AND ssdt_tpdt_pk = portico.getTipoDato('TIPO_ATR')
							AND ssdt_prmt_pk <> (
								SELECT prmt_pk
								FROM 
									tbl_parametro_prmt
								WHERE 
									prmt_tppr_pk = portico.getEntidad('TIPO_ATRAQUE')
									AND prmt_parametro = 'F'
							)
					)
					AND ssrv_fini = (
						SELECT MIN(ssrv_fini)
						FROM tbl_subservicio_ssrv
						WHERE 
							ssrv_tpss_pk = portico.getEntidad('ATRAQUE')
							AND ssrv_estado = 'F'
							AND ssrv_srvc_pk = srvc_pk
							AND EXISTS (
								SELECT 1 
								FROM tbl_subservicio_dato_ssdt
								WHERE ssdt_ssrv_pk = ssrv_pk
									AND ssdt_tpdt_pk = portico.getTipoDato('TIPO_ATR')
									AND ssdt_prmt_pk <> (
										SELECT prmt_pk
										FROM 
											tbl_parametro_prmt
										WHERE 
											prmt_tppr_pk = portico.getEntidad('TIPO_ATRAQUE')
											AND prmt_parametro = 'F'
									)
							)
					)
			) AS atraque_pk
		FROM 
			tbl_servicio_srvc
		WHERE 
			srvc_tpsr_pk = portico.getEntidad('ESCALA')
			AND EXISTS (
				SELECT 1
				FROM tbl_subservicio_ssrv
				WHERE 
					ssrv_srvc_pk = srvc_pk
					AND ssrv_tpss_pk = portico.getEntidad('ATRAQUE')
					AND ssrv_estado = 'F'
					AND EXISTS (
						SELECT 1 
						FROM tbl_subservicio_dato_ssdt
						WHERE ssdt_ssrv_pk = ssrv_pk
							AND ssdt_tpdt_pk = portico.getTipoDato('TIPO_ATR')
							AND ssdt_prmt_pk <> (
								SELECT prmt_pk
								FROM 
									tbl_parametro_prmt
								WHERE 
									prmt_tppr_pk = portico.getEntidad('TIPO_ATRAQUE')
									AND prmt_parametro = 'F'
							)
					)
			)
			AND (
				EXISTS (
					SELECT 1
					FROM tbl_servicio_dato_srdt
					WHERE 
						srdt_tpdt_pk = portico.getTipoDato('COD_EXEN')
						AND srdt_cadena = '0'
						AND srdt_srvc_pk = srvc_pk
				)
				OR EXISTS (
					SELECT 1
					FROM tbl_servicio_dato_srdt
					WHERE 
						srdt_tpdt_pk = portico.getTipoDato('COD_EXEN')
						AND srdt_cadena = '2'
						AND srdt_srvc_pk = srvc_pk
				)
			)
			AND (
				srvc_ffin >= '2013-05-01'
				AND srvc_ffin < '2014-06-01'
			)
	) sql
) sql
GROUP BY 
	srvc_subp_pk, tipoActividad_pk, tipoBuqueGT_pk, tipoBuque_pk, tipoNavEnt_pk, tipoNavSal_pk, paisBuque_pk
	, buque_pk, tipoEstancia, servicioTrafico_pk, acuerdo_pk, consignatario_pk
;







-- Mov Tipo Buque EEE
-- Los buques de guerra BG no se cogen????
SELECT 
	srvc_subp_pk, tipoBuqueEEE_pk, tipoBuqueGTEEE_pk, COUNT(1) AS numEscalas, SUM(gt)
FROM (	
	WITH buqueTipoGTEEE AS (
		SELECT prmt_pk, prvr_fini, prvr_ffin
			, (
				SELECT prdt_nentero 
				FROM tbl_parametro_dato_prdt
				WHERE prdt_prvr_pk = prvr_pk 
					AND prdt_tpdt_pk = portico.getTipoDato('ENTERO_01')
			) AS limiteInf
		FROM 
			tbl_parametro_prmt
			INNER JOIN tbl_parametro_version_prvr ON
				prvr_prmt_pk = prmt_pk
		WHERE 
			prmt_tppr_pk = portico.getEntidad('TIPO_BUQUE_GT_EEE')
	)
	SELECT 
		srvc_subp_pk, buque_pk
		, (
			SELECT prdt_prmt_pk
			FROM tbl_parametro_dato_prdt
			WHERE 
				prdt_tpdt_pk = portico.getTipoDato('TIPO_BUQUE_EEE')
				AND prdt_prvr_pk = ANY (
					SELECT prvr_pk
					FROM tbl_parametro_version_prvr
					WHERE 
						srvc_fref BETWEEN prvr_fini AND COALESCE(prvr_ffin, NOW())
						AND prvr_prmt_pk = (
							SELECT prdt_prmt_pk
							FROM tbl_parametro_dato_prdt
							WHERE 
								prdt_tpdt_pk = portico.getTipoDato('TIPO_BUQUE_EST')
								AND prdt_prvr_pk = ANY (
									SELECT prvr_pk
									FROM tbl_parametro_version_prvr
									WHERE 
										srvc_fref BETWEEN prvr_fini AND COALESCE(prvr_ffin, NOW())
										AND prvr_prmt_pk = (
											SELECT prdt_prmt_pk
											FROM tbl_parametro_dato_prdt
											WHERE 
												prdt_tpdt_pk = portico.getTipoDato('TIPO_BUQUE')
												AND prdt_prvr_pk = ANY (
													SELECT prvr_pk
													FROM tbl_parametro_version_prvr
													WHERE 
														srvc_fref BETWEEN prvr_fini AND COALESCE(prvr_ffin, NOW())
														AND prvr_prmt_pk = buque_pk
												)
										)
								)
						)
				)
		) AS tipoBuqueEEE_pk
		, (
			SELECT prmt_pk
			FROM buqueTipoGTEEE
			WHERE 
				srvc_fref BETWEEN prvr_fini AND COALESCE(prvr_ffin, NOW())
				AND limiteInf = (
					SELECT MAX(limiteInf)
					FROM buqueTipoGTEEE
					WHERE 
						srvc_fref BETWEEN prvr_fini AND COALESCE(prvr_ffin, NOW())
						AND limiteInf <= (
							SELECT prdt_nentero
							FROM tbl_parametro_dato_prdt
							WHERE 
								prdt_tpdt_pk = portico.getTipoDato('ENTERO_01')
								AND prdt_prvr_pk = ANY (
									SELECT prvr_pk
									FROM tbl_parametro_version_prvr
									WHERE 
										srvc_fref BETWEEN prvr_fini AND COALESCE(prvr_ffin, NOW())
										AND prvr_prmt_pk = buque_pk
								)
						)
						
				) 
		) AS tipoBuqueGTEEE_pk
		, (
			SELECT prdt_nentero
			FROM tbl_parametro_dato_prdt
			WHERE 
				prdt_tpdt_pk = portico.getTipoDato('ENTERO_01')
				AND prdt_prvr_pk = ANY (
					SELECT prvr_pk
					FROM tbl_parametro_version_prvr
					WHERE 
						srvc_fref BETWEEN prvr_fini AND COALESCE(prvr_ffin, NOW())
						AND prvr_prmt_pk = buque_pk
				)
		) AS gt
	FROM (
		SELECT 
			srvc_pk, srvc_subp_pk, srvc_fref, srvc_fini, srvc_ffin
			, (
				SELECT srdt_prmt_pk
				FROM 
					tbl_servicio_dato_srdt
				WHERE
					srdt_srvc_pk = srvc_pk
					AND srdt_tpdt_pk = portico.getTipoDato('BUQUE') 
			) AS buque_pk
		FROM 
			tbl_servicio_srvc
		WHERE 
			srvc_tpsr_pk = portico.getEntidad('ESCALA')
			AND EXISTS (
				SELECT 1
				FROM tbl_subservicio_ssrv
				WHERE 
					ssrv_srvc_pk = srvc_pk
					AND ssrv_tpss_pk = portico.getEntidad('ATRAQUE')
					AND ssrv_estado = 'F'
					AND EXISTS (
						SELECT 1 
						FROM tbl_subservicio_dato_ssdt
						WHERE ssdt_ssrv_pk = ssrv_pk
							AND ssdt_tpdt_pk = portico.getTipoDato('TIPO_ATR')
							AND ssdt_prmt_pk <> (
								SELECT prmt_pk
								FROM 
									tbl_parametro_prmt
								WHERE 
									prmt_tppr_pk = portico.getEntidad('TIPO_ATRAQUE')
									AND prmt_parametro = 'F'
							)
					)
			)
			AND (
				EXISTS (
					SELECT 1
					FROM tbl_servicio_dato_srdt
					WHERE 
						srdt_tpdt_pk = portico.getTipoDato('COD_EXEN')
						AND srdt_cadena = '0'
						AND srdt_srvc_pk = srvc_pk
				)
				OR EXISTS (
					SELECT 1
					FROM tbl_servicio_dato_srdt
					WHERE 
						srdt_tpdt_pk = portico.getTipoDato('COD_EXEN')
						AND srdt_cadena = '2'
						AND srdt_srvc_pk = srvc_pk
				)
			)
			AND (
				srvc_ffin >= '2013-05-01'
				AND srvc_ffin < '2014-06-01'
			)
	) sql
) sql
GROUP BY 
	srvc_subp_pk, tipoBuqueEEE_pk, tipoBuqueGTEEE_pk
;






-- Buques fondeados atracados
SELECT 
	srvc_subp_pk, tipoatrreal_pk, consignatario_pk, buque_pk, servicio_pk, alineacion_pk
	, SUM(gt), SUM(gt * diasatr), SUM(eslora), SUM(eslora * diasatr)
	, COUNT(1)
FROM (
	SELECT srvc_subp_pk, tipoatrreal_pk, consignatario_pk, buque_pk, servicio_pk, alineacion_pk, diasatr
		, (
			SELECT prdt_nentero
			FROM tbl_parametro_dato_prdt
			WHERE
				prdt_tpdt_pk = portico.getTipoDato('ENTERO_01')
				AND prdt_prvr_pk = (
					SELECT prvr_pk
					FROM tbl_parametro_version_prvr
					WHERE prvr_prmt_pk = buque_pk
						AND srvc_fref BETWEEN prvr_fini AND COALESCE(prvr_ffin, NOW())
				)
		) AS gt
		, (
			SELECT prdt_ndecimal
			FROM tbl_parametro_dato_prdt
			WHERE
				prdt_tpdt_pk = portico.getTipoDato('DECIMAL_03')
				AND prdt_prvr_pk = (
					SELECT prvr_pk
					FROM tbl_parametro_version_prvr
					WHERE prvr_prmt_pk = buque_pk
						AND srvc_fref BETWEEN prvr_fini AND COALESCE(prvr_ffin, NOW())
				)
		) AS eslora
	FROM (
		WITH actividadesEst AS (
			SELECT prmt_pk, prvr_fini, prvr_ffin
			FROM 
				tbl_parametro_prmt
				INNER JOIN tbl_parametro_version_prvr ON
					prvr_prmt_pk = prmt_pk
			WHERE 
				prmt_tppr_pk = portico.getEntidad('TIPO_ACTIVIDAD')
				AND EXISTS (
					SELECT 1 
					FROM tbl_parametro_dato_prdt
					WHERE prdt_prvr_pk = prvr_pk
						AND prdt_tpdt_pk = portico.getTipoDato('TIPO_ACT_EST')
						AND prdt_cadena = 'SI'
				)
		)
		SELECT 
			srvc_pk, srvc_subp_pk, srvc_fref
			, ssrv_pk, ssrv_fini, ssrv_ffin
			, (
				SELECT ssdt_prmt_pk
				FROM 
					tbl_subservicio_dato_ssdt
				WHERE
					ssdt_ssrv_pk = ssrv_pk
					AND ssdt_tpdt_pk = portico.getTipoDato('TIPO_ATR_3') 
			) AS tipoAtrReal_pk
			, (
				SELECT ssdt_prmt_pk
				FROM 
					tbl_subservicio_dato_ssdt
				WHERE
					ssdt_ssrv_pk = ssrv_pk
					AND ssdt_tpdt_pk = portico.getTipoDato('ORGA_2') 
			) AS consignatario_pk
			, (
				SELECT srdt_prmt_pk
				FROM 
					tbl_servicio_dato_srdt
				WHERE
					srdt_srvc_pk = srvc_pk
					AND srdt_tpdt_pk = portico.getTipoDato('BUQUE') 
			) AS buque_pk
			, (
				SELECT srdt_prmt_pk
				FROM 
					tbl_servicio_dato_srdt
				WHERE
					srdt_srvc_pk = srvc_pk
					AND srdt_tpdt_pk = portico.getTipoDato('SERV_TRAF') 
			) AS servicio_pk
			, (
				SELECT ssdt_prmt_pk
				FROM 
					tbl_subservicio_dato_ssdt
				WHERE
					ssdt_ssrv_pk = ssrv_pk
					AND ssdt_tpdt_pk = portico.getTipoDato('ALIN_3') 
			) AS alineacion_pk
			, EXTRACT(epoch FROM (ssrv_ffin - ssrv_fini))/86400::int AS diasAtr
		FROM 
			tbl_servicio_srvc
			INNER JOIN tbl_subservicio_ssrv ON
				srvc_pk = ssrv_srvc_pk
		WHERE 
			srvc_tpsr_pk = portico.getEntidad('ESCALA')
			AND ssrv_tpss_pk = portico.getEntidad('ATRAQUE')
			AND (
				EXISTS (
					SELECT 1
					FROM tbl_servicio_dato_srdt
					WHERE 
						srdt_tpdt_pk = portico.getTipoDato('COD_EXEN')
						AND srdt_cadena = '0'
						AND srdt_srvc_pk = srvc_pk
				)
				OR EXISTS (
					SELECT 1
					FROM tbl_servicio_dato_srdt
					WHERE 
						srdt_tpdt_pk = portico.getTipoDato('COD_EXEN')
						AND srdt_cadena = '2'
						AND srdt_srvc_pk = srvc_pk
				)
			)
			AND (
				srvc_ffin >= '2013-05-01'
				AND srvc_ffin < '2014-06-01'
			)

			AND EXISTS (
				SELECT 1
				FROM 
					tbl_parametro_dato_prdt
				WHERE 
					prdt_tpdt_pk = portico.getTipoDato('TIPO_BUQUE')
					AND prdt_prvr_pk = (
						SELECT prvr_pk
						FROM tbl_parametro_version_prvr
						WHERE
							srvc_fref BETWEEN prvr_fini AND COALESCE(prvr_ffin, NOW())
							AND prvr_prmt_pk = (
								SELECT srdt_prmt_pk
								FROM tbl_servicio_dato_srdt
								WHERE 
									srdt_srvc_pk = srvc_pk
									AND srdt_tpdt_pk = portico.getTipoDato('BUQUE')
							)
					)
					AND prdt_prmt_pk NOT IN (
						SELECT prmt_pk
						FROM tbl_parametro_prmt
						WHERE prmt_tppr_pk = portico.getEntidad('TIPO_BUQUE')
							AND (
								prmt_parametro LIKE 'P%'
								OR prmt_parametro LIKE 'O%'
								OR prmt_parametro LIKE 'BG'
							)
					)
			
			)

			AND ssrv_estado = 'F'

			AND EXISTS (
				SELECT 1
				FROM tbl_subservicio_dato_ssdt
				WHERE ssdt_ssrv_pk = ssrv_pk
					AND ssdt_tpdt_pk = portico.getTipoDato('TIPO_ACT_3')
					AND ssdt_prmt_pk = ANY (
						SELECT prmt_pk
						FROM actividadesEst
						WHERE srvc_fref BETWEEN prvr_fini AND COALESCE(prvr_ffin, NOW())
					)
			)
	) sql
) sql
GROUP BY 
	srvc_subp_pk, tipoatrreal_pk, consignatario_pk, buque_pk, servicio_pk, alineacion_pk
;








-- Movimiento de Mercancias
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
		AND srvc_fref < '2014-06-01'
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
