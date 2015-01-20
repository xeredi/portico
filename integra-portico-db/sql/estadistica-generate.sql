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
					FROM tbl_parametro_prmt
					WHERE 
						prmt_tppr_pk = portico.getEntidad('TIPO_SUMINISTRO')
						AND EXISTS (
							SELECT 1
							FROM tbl_parametro_version_prvr
							WHERE 
								prvr_prmt_pk = prmt_pk
								AND srvc_fref BETWEEN prvr_fini AND COALESCE(prvr_ffin, NOW())
								AND EXISTS (
									SELECT 1
									FROM tbl_parametro_dato_prdt
									WHERE prdt_prvr_pk = prvr_pk
										AND prdt_tpdt_pk = portico.getTipoDato('BOOLEANO_01')
										AND prdt_nentero = 1
								)
						)
				)
		)
) sql
GROUP BY srvc_subp_pk, tipoSum
;





-- AGREGACION DE ESCALAS
-- Los buques de guerra BG no se cogen
-- OJO Coger actividad del primer atraque
SELECT srvc_subp_pk, tipoActividad, tipoBuqueGT, tipoBuque, tipoNavEnt, tipoNavSal, paisBuque, COUNT(1) AS numEscalas, SUM(gt)
	, buque, tipoEstancia, servicioTrafico, acuerdo, consignatario
FROM (
	SELECT srvc_tpsr_pk, srvc_subp_pk, srvc_anno, srvc_fref, srvc_estado
		, srdt_prmt_pk AS buque
		, (
			SELECT ssdt_prmt_pk
			FROM tbl_subservicio_dato_ssdt
			WHERE 
				ssdt_ssrv_pk = ssrv_pk
				AND ssdt_tpdt_pk = portico.getTipoDato('TIPO_ACT')
		) AS tipoActividad
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
						AND prvr_prmt_pk = srdt_prmt_pk
				)
		) AS tipoBuque
		, (
			SELECT prmt_pk
			FROM tbl_parametro_prmt
			WHERE 
				prmt_tppr_pk = portico.getEntidad('TIPO_BUQUE_GT')
				AND EXISTS (
					SELECT 1
					FROM tbl_parametro_version_prvr
					WHERE
						prvr_prmt_pk = prmt_pk
						AND srvc_fref BETWEEN prvr_fini AND COALESCE(prvr_ffin, NOW())
						AND EXISTS (
							SELECT 1
							FROM tbl_parametro_dato_prdt
							WHERE prdt_tpdt_pk = portico.getTipoDato('ENTERO_01')
								AND prdt_prvr_pk = prvr_pk
								AND prdt_nentero = (
									SELECT MIN(prdt_nentero)
									FROM tbl_parametro_dato_prdt
									WHERE
										prdt_tpdt_pk = portico.getTipoDato('ENTERO_01')
										AND prdt_prvr_pk = ANY (
											SELECT prvr_pk
											FROM tbl_parametro_version_prvr
											WHERE srvc_fref BETWEEN prvr_fini AND COALESCE(prvr_ffin, NOW())
												AND prvr_prmt_pk = ANY (
													SELECT prmt_pk
													FROM tbl_parametro_prmt
													WHERE 
														prmt_tppr_pk = portico.getEntidad('TIPO_BUQUE_GT')
												)
										) 
										AND prdt_nentero >= (
											SELECT prdt_nentero
											FROM tbl_parametro_dato_prdt
											WHERE 
												prdt_tpdt_pk = portico.getTipoDato('ENTERO_01')
												AND prdt_prvr_pk = ANY (
													SELECT prvr_pk
													FROM tbl_parametro_version_prvr
													WHERE 
														srvc_fref BETWEEN prvr_fini AND COALESCE(prvr_ffin, NOW())
														AND prvr_prmt_pk = srdt_prmt_pk
												)
										)
								)
						)
				)
		) AS tipoBuqueGT
		, (
			SELECT srdt_prmt_pk
			FROM tbl_servicio_dato_srdt
			WHERE srdt_srvc_pk = srvc_pk
				AND srdt_tpdt_pk = portico.getTipoDato('TIPO_NAV')
		) AS tipoNavEnt
		, (
			SELECT srdt_prmt_pk
			FROM tbl_servicio_dato_srdt
			WHERE srdt_srvc_pk = srvc_pk
				AND srdt_tpdt_pk = portico.getTipoDato('TIPO_NAV_2')
		) AS tipoNavSal
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
						AND prvr_prmt_pk = srdt_prmt_pk
				)
		) AS paisBuque
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
		) AS servicioTrafico
		, (
			SELECT srdt_prmt_pk
			FROM tbl_servicio_dato_srdt
			WHERE srdt_srvc_pk = srvc_pk
				AND srdt_tpdt_pk = portico.getTipoDato('ACUERDO')
		) AS acuerdo
		, (
			SELECT srdt_prmt_pk
			FROM tbl_servicio_dato_srdt
			WHERE srdt_srvc_pk = srvc_pk
				AND srdt_tpdt_pk = portico.getTipoDato('ORGA_3')
		) AS consignatario
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
						AND prvr_prmt_pk = srdt_prmt_pk
				)
		) AS gt
	FROM 
		tbl_servicio_srvc
		INNER JOIN tbl_subservicio_ssrv ON 
			ssrv_srvc_pk = srvc_pk
		INNER JOIN tbl_servicio_dato_srdt ON
			srdt_srvc_pk = srvc_pk
			AND srdt_tpdt_pk = portico.getTipoDato('BUQUE')
	WHERE 
		srvc_tpsr_pk = portico.getEntidad('ESCALA')
		AND ssrv_tpss_pk = portico.getEntidad('ATRAQUE')
) sql
GROUP BY 
	srvc_subp_pk, tipoActividad, tipoBuqueGT, tipoBuque, tipoNavEnt, tipoNavSal, paisBuque
	, buque, tipoEstancia, servicioTrafico, acuerdo, consignatario
;





