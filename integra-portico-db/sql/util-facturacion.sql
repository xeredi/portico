SELECT 
	vlrt_prbt_pk, vlrt_srvc_pk, vlrt_ssrv_pk, vlrt_crgo_pk, vlrt_rgla_pk, vlrt_impuesto_pk, vlrt_pagador_pk
	, vlrt_orden, vlrt_importe_base, vlrt_importe, vlrt_es_suj_pasivo, vlrt_cod_exen
        , vlrt_fref, vlrt_fliq, vlrt_fini, vlrt_ffin
	, vlrt_cuant1, vlrt_cuant2, vlrt_cuant3, vlrt_cuant4, vlrt_cuant5, vlrt_cuant6
	, vlrt_info1, vlrt_info2, vlrt_info3, vlrt_info4, vlrt_info5, vlrt_info6
FROM portico.tbl_valoracion_tmp_vlrt
;

SELECT *
FROM portico.tbl_proceso_batch_prbt
;

DELETE
FROM portico.tbl_valoracion_tmp_vlrt
;



SELECT















SELECT * 
FROM tbl_servicio_srvc 
	JOIN tbl_entidad_enti ON
		enti_pk = srvc_tpsr_pk;

-- 1192001, 1192002, 1192003
-- Contar tipos de servicio
SELECT COUNT(DISTINCT srvc_tpsr_pk)
FROM tbl_servicio_srvc 
WHERE srvc_pk IN (1192001, 1192002, 1192003);


-- Tasas propuestas para un servicio
SELECT *
FROM tbl_cargo_crgo
WHERE 
	EXISTS (
		SELECT 1
		FROM tbl_servicio_srvc
		WHERE srvc_tpsr_pk = crgo_tpsr_pk
			AND srvc_pk = 1192001
	)
	AND NOT EXISTS (
		SELECT 1
		FROM tbl_cargo_composicion_crcm
		WHERE crcm_crgo_hijo_pk = crgo_pk
	)
;

-- Tasas a Valorar
SELECT * 
FROM
	tbl_cargo_crgo
WHERE crgo_pk IN (1004)
	OR EXISTS (
		SELECT 1
		FROM tbl_cargo_composicion_crcm
		WHERE crcm_crgo_hijo_pk = crgo_pk
			AND crcm_crgo_padre_pk IN (1004)
	)
;

-- Procedimientos de una tasa
SELECT * 
FROM tbl_procedimiento_prcd 
WHERE 
	prcd_crgo_pk IN (1004)
;









-- Valorar manifiesto
select ssrv_srvc_pk, count(1)
from 
	portico.tbl_subservicio_ssrv
group by ssrv_srvc_pk
;



select ssrv_tpss_pk, enti_nombre, count(1)
from 
	portico.tbl_subservicio_ssrv
	join portico.tbl_entidad_enti on
		enti_pk = ssrv_tpss_pk
where ssrv_srvc_pk = 1192567
group by ssrv_tpss_pk, enti_nombre
;

select * 
from 
	portico.tbl_servicio_srvc
	join portico.tbl_entidad_enti on
		enti_pk = srvc_tpsr_pk
where srvc_pk = 1192567
;


-- Tipo de IVA
SELECT *
FROM portico.tbl_parametro_prmt
WHERE 
	EXISTS (
		SELECT 1 
		FROM portico.tbl_subservicio_dato_ssdt
		WHERE 
			ssdt_prmt_pk = prmt_pk
			and ssdt_tpdt_pk = getTipoDato('TIPO_IVA')
			AND EXISTS (
				SELECT 1
				FROM portico.tbl_subservicio_ssrv
				WHERE 
					ssrv_pk = ssdt_ssrv_pk
					AND ssrv_tpss_pk = getEntidad('BL')
			)
			AND EXISTS (
				SELECT 1
				FROM portico.tbl_subserv_subserv_ssss
				WHERE 
					ssss_ssrvp_pk = ssdt_ssrv_pk
					AND ssss_ssrvh_pk = 1198329
			)
	)
;

-- Suj_pasivo
SELECT *
FROM portico.tbl_subservicio_dato_ssdt
WHERE 
	ssdt_tpdt_pk = getTipoDato('BOOLEANO_01')
	AND EXISTS (
		SELECT 1
		FROM portico.tbl_subservicio_ssrv
		WHERE 
			ssrv_pk = ssdt_ssrv_pk
			AND ssrv_tpss_pk = getEntidad('BL')
	)
	AND EXISTS (
		SELECT 1
		FROM portico.tbl_subserv_subserv_ssss
		WHERE 
			ssss_ssrvp_pk = ssdt_ssrv_pk
			AND ssss_ssrvh_pk = 1198329
	)
;

-- Pagador Principal
select *
FROM
	portico.tbl_subservicio_dato_ssdt
WHERE 
	ssdt_tpdt_pk = portico.getTipoDato('ORGA')
	AND EXISTS (
		SELECT 1
		FROM 
			portico.tbl_subservicio_ssrv
		WHERE
			ssrv_pk = ssdt_ssrv_pk
			AND ssrv_tpss_pk = portico.getEntidad('MANIFIESTO_CONSIGNATARIO')
			AND EXISTS (
				SELECT 1
				FROM portico.tbl_subserv_subserv_ssss
				WHERE 
					ssss_ssrvp_pk = ssrv_pk
					AND EXISTS (
						SELECT 1
						FROM 
							portico.tbl_subservicio_ssrv
						WHERE 
							ssrv_pk = ssss_ssrvh_pk
							AND ssrv_tpss_pk = portico.getEntidad('BL')
							AND EXISTS (
								SELECT 1
								FROM portico.tbl_subserv_subserv_ssss
								WHERE 
									ssss_ssrvp_pk = ssrv_pk
									AND ssss_ssrvh_pk = 1198329
							)
					)
			)
	)
;


-- Reg. Simplificado
SELECT * 
FROM portico.tbl_tipo_dato_tpdt
ORDER BY tpdt_codigo;
;

SELECT * 
FROM portico.tbl_entidad_enti
ORDER BY enti_codigo;
;

SELECT *
FROM
	portico.tbl_entidad_tipo_dato_entd
	JOIN portico.tbl_tipo_dato_tpdt ON
		tpdt_pk = entd_tpdt_pk
WHERE 
	entd_enti_pk = portico.getEntidad('UNIDAD_CARGA')
--	AND entd_tpdt_pk = portico.getTipoDato('BOOLEANO_02')
;

-- esTransporte
SELECT *
FROM
	portico.tbl_parametro_dato_prdt
WHERE
	prdt_tpdt_pk = portico.getTipoDato('BOOLEANO_01')
	AND EXISTS (
		SELECT 1
		FROM portico.tbl_parametro_version_prvr
		WHERE
			prvr_pk = prdt_prvr_pk
			AND NOW() BETWEEN prvr_fini AND COALESCE(prvr_ffin, NOW())
			AND EXISTS (
				SELECT 1
				FROM portico.tbl_subservicio_dato_ssdt
				WHERE 
					ssdt_prmt_pk = prvr_prmt_pk
					AND ssdt_tpdt_pk = portico.getTipoDato('MERCANCIA')
					AND ssdt_ssrv_pk = 1198158
			)
	)
;

-- mercancia de la uc
SELECT *
FROM
	portico.tbl_parametro_dato_prdt
WHERE
	prdt_tpdt_pk = portico.getTipoDato('MERCANCIA')
	AND EXISTS (
		SELECT 1
		FROM portico.tbl_parametro_version_prvr
		WHERE
			prvr_pk = prdt_prvr_pk
			AND NOW() BETWEEN prvr_fini AND COALESCE(prvr_ffin, NOW())
			AND EXISTS (
				SELECT 1
				FROM portico.tbl_subservicio_dato_ssdt
				WHERE 
					ssdt_prmt_pk = prvr_prmt_pk 
					AND ssdt_tpdt_pk = portico.getTipoDato('UNIDAD_CARGA')
--					AND ssdt_ssrv_pk = 1198158
			)
	)
;




SELECT *
FROM portico.tbl_subservicio_dato_ssdt
WHERE 
	ssdt_tpdt_pk = getTipoDato('BOOLEANO_02')
	AND EXISTS (
		SELECT 1
		FROM portico.tbl_subservicio_ssrv
		WHERE 
			ssrv_pk = ssdt_ssrv_pk
			AND ssrv_tpss_pk = getEntidad('BL')
	)
	AND EXISTS (
		SELECT 1
		FROM portico.tbl_subserv_subserv_ssss
		WHERE 
			ssss_ssrvp_pk = ssdt_ssrv_pk
			AND ssss_ssrvh_pk = 1198329
	)
;

SELECT * FROM tbl_entidad_enti
ORDER BY enti_codigo
;

SELECT * 
FROM 
	tbl_entidad_tipo_dato_entd
	JOIN tbl_tipo_dato_tpdt ON
		tpdt_pk = entd_tpdt_pk
WHERE entd_enti_pk = 20014
;

SELECT * FROM tbl_tipo_dato_tpdt
order by tpdt_codigo;


SELECT srvc.*, ssrv.*, tpss.*, tpsr.*, rgla.*
	, (
		SELECT prmt_pk
		FROM portico.tbl_parametro_prmt
		WHERE 
			EXISTS (
				SELECT 1 
				FROM portico.tbl_subservicio_dato_ssdt
				WHERE 
					ssdt_prmt_pk = prmt_pk
					and ssdt_tpdt_pk = portico.getTipoDato('TIPO_IVA')
					AND EXISTS (
						SELECT 1
						FROM portico.tbl_subservicio_ssrv
						WHERE 
							ssrv_pk = ssdt_ssrv_pk
							AND ssrv_tpss_pk = portico.getEntidad('BL')
					)
					AND EXISTS (
						SELECT 1
						FROM portico.tbl_subserv_subserv_ssss
						WHERE 
							ssss_ssrvp_pk = ssdt_ssrv_pk
							AND ssss_ssrvh_pk = ssrv.ssrv_pk
					)
			)
	) AS ivat_pk
	, (
		SELECT ssdt_nentero
		FROM portico.tbl_subservicio_dato_ssdt
		WHERE 
			ssdt_tpdt_pk = portico.getTipoDato('BOOLEANO_01')
			AND EXISTS (
				SELECT 1
				FROM portico.tbl_subservicio_ssrv
				WHERE 
					ssrv_pk = ssdt_ssrv_pk
					AND ssrv_tpss_pk = portico.getEntidad('BL')
			)
			AND EXISTS (
				SELECT 1
				FROM portico.tbl_subserv_subserv_ssss
				WHERE 
					ssss_ssrvp_pk = ssdt_ssrv_pk
					AND ssss_ssrvh_pk = ssrv.ssrv_pk
			)
	) AS esSujPas
	, (
		select ssdt_prmt_pk
		FROM
			portico.tbl_subservicio_dato_ssdt
		WHERE 
			ssdt_tpdt_pk = portico.getTipoDato('ORGA')
			AND EXISTS (
				SELECT 1
				FROM 
					portico.tbl_subservicio_ssrv
				WHERE
					ssrv_pk = ssdt_ssrv_pk
					AND ssrv_tpss_pk = portico.getEntidad('MANIFIESTO_CONSIGNATARIO')
					AND EXISTS (
						SELECT 1
						FROM portico.tbl_subserv_subserv_ssss
						WHERE 
							ssss_ssrvp_pk = ssrv_pk
							AND EXISTS (
								SELECT 1
								FROM 
									portico.tbl_subservicio_ssrv
								WHERE 
									ssrv_pk = ssss_ssrvh_pk
									AND ssrv_tpss_pk = portico.getEntidad('BL')
									AND EXISTS (
										SELECT 1
										FROM portico.tbl_subserv_subserv_ssss
										WHERE 
											ssss_ssrvp_pk = ssrv_pk
											AND ssss_ssrvh_pk = ssrv.ssrv_pk
									)
							)
					)
			)
	) AS pagador_pk
	, (
		SELECT ssdt_cadena
		FROM portico.tbl_subservicio_dato_ssdt
		WHERE ssdt_ssrv_pk = ssrv.ssrv_pk
			AND ssdt_tpdt_pk = portico.getTipoDato('COD_EXEN')
	) AS cod_exen
FROM 
	portico.tbl_subservicio_ssrv ssrv
	JOIN portico.tbl_servicio_srvc srvc ON
		srvc_pk = ssrv_srvc_pk
	JOIN portico.tbl_tipo_subservicio_tpss tpss ON
		tpss_pk = ssrv_tpss_pk
	JOIN portico.tbl_tipo_servicio_tpsr tpsr ON
		tpsr_pk = srvc_tpsr_pk
	JOIN portico.tbl_regla_rgla rgla ON
		rgla_enti_pk = ssrv_tpss_pk
		AND rgla_pk = 63001
WHERE
	tpsr_es_facturable = 1
	AND tpss_es_facturable = 1
	AND (
		tpss_tpdt_estado_pk IS NULL
		OR (
			(
				tpss_pk = portico.getEntidad('PARTIDA') 
				AND ssrv_estado = 'R'
				AND (
					-- Regimen simplificado
					EXISTS (
						SELECT 1
						FROM portico.tbl_subservicio_dato_ssdt
						WHERE 
							
							EXISTS (
								SELECT 1
								FROM portico.tbl_subservicio_ssrv
								WHERE 
									ssrv_pk = ssdt_ssrv_pk
									AND ssrv_tpss_pk = portico.getEntidad('BL')
							)
							AND EXISTS (
								SELECT 1
								FROM portico.tbl_subserv_subserv_ssss
								WHERE 
									ssss_ssrvp_pk = ssdt_ssrv_pk
									AND ssss_ssrvh_pk = ssrv.ssrv_pk
							)
							AND (
								(ssdt_tpdt_pk = portico.getTipoDato('BOOLEANO_02') AND ssdt_nentero = 0)
								or (ssdt_tpdt_pk = portico.getTipoDato('TIPO_BL') AND ssdt_cadena = 'P')
							)
					)
					or (
						EXISTS (
							SELECT 1
							FROM
								portico.tbl_parametro_dato_prdt
							WHERE
								prdt_tpdt_pk = portico.getTipoDato('BOOLEANO_01')
								AND EXISTS (
									SELECT 1
									FROM portico.tbl_parametro_version_prvr
									WHERE
										prvr_pk = prdt_prvr_pk
										AND srvc_fref BETWEEN prvr_fini AND COALESCE(prvr_ffin, srvc_fref)
										AND EXISTS (
											SELECT 1
											FROM portico.tbl_subservicio_dato_ssdt
											WHERE 
												ssdt_prmt_pk = prvr_prmt_pk
												AND ssdt_tpdt_pk = portico.getTipoDato('MERCANCIA')
												AND ssdt_ssrv_pk = ssrv.ssrv_pk
										)
								)
								AND prdt_nentero = 1
								-- TODO Falta ver que la mercancia de la unidad de carga sea nula
						)
					)
				)
			)
			
			OR (tpss_pk = portico.getEntidad('EQUIPAMIENTO') AND ssrv_estado = 'R')

			OR (tpss_pk = portico.getEntidad('PARTIDA_PESCA') AND ssrv_estado = 'R')

			OR (tpss_pk = portico.getEntidad('ATRAQUE') AND ssrv_estado IN ('I', 'F'))
		)
	)
	AND (
		tpss_es_exencionable = 0
		OR EXISTS (
			SELECT 1
			FROM portico.tbl_subservicio_dato_ssdt
			WHERE ssdt_ssrv_pk = ssrv_pk
				AND ssdt_tpdt_pk = portico.getTipoDato('COD_EXEN')
				AND ssdt_cadena IN ('0', '1')
		)
	)
	AND (
		tpsr_es_exencionable = 0
		OR EXISTS (
			SELECT 1
			FROM portico.tbl_servicio_dato_srdt
			WHERE srdt_srvc_pk = srvc_pk
				AND srdt_tpdt_pk = portico.getTipoDato('COD_EXEN')
				AND srdt_cadena IN ('0', '1')
		)
	)

	-- TODO Condicion

	-- TODO Que no este valorado/facturado

	AND (
		(
			rgla_tipo = 'T'
			AND NOT EXISTS (
				SELECT 1
				FROM portico.tbl_servicio_cargo_srcr
				WHERE
					srcr_srvc_pk = srvc_pk
					AND srcr_ssrv_pk = ssrv_pk
					AND srcr_crgo_pk = rgla_crgo_pk
					AND (srcr_vlrc_pk IS NOT NULL OR srcr_fctr_pk IS NOT NULL)
			)
			-- TODO Ojo lo de temporalidad
		)
		OR (
			rgla_tipo IN ('C', 'D')
			AND EXISTS (
				SELECT 1
				FROM 
					portico.tbl_valoracion_tmp_vlrt
				WHERE 
					vlrt_prbt_pk = 1 -- TODO
					AND vlrt_srvc_pk = srvc_pk
					AND vlrt_ssrv_pk = ssrv_pk
					AND vlrt_crgo_pk = rgla_crgo_pk
					AND vlrt_rgla_pk = ANY(
						SELECT rgla_pk
						FROM portico.tbl_regla_rgla
						WHERE 
							rgla_crgo_pk = vlrt_crgo_pk
							AND rgla_tipo = 'T'
					)
			)
		)
	)

	AND ssrv_srvc_pk = 1192567

ORDER BY ssrv_srvc_pk, ssrv_numero
;




SELECT 
	item.ssrv_pk AS item_pk
	, item.fref AS item_fref
	, item.*
	, (
		SELECT srvc_pk
		FROM tbl_servicio_srvc
		WHERE srvc_pk = item.ssrv_srvc_pk
	) AS srvc
	, (
		SELECT ssss_ssrvp_pk
		FROM tbl_subserv_subserv_ssss
		WHERE 
			EXISTS (
				SELECT 1
				FROM tbl_subservicio_ssrv
				WHERE 
					ssrv_pk = ssss_ssrvp_pk
					AND ssrv_tpss_pk = portico.getEntidad('BL')
			)
			AND ssss_ssrvh_pk = item.ssrv_pk
	) AS padre
	, (
		SELECT ssdt_prmt_pk
		FROM tbl_subservicio_dato_ssdt
		WHERE ssdt_tpdt_pk = portico.getTipoDato('UNLOCODE')
			AND ssdt_ssrv_pk = ANY (
				SELECT ssss_ssrvp_pk
				FROM tbl_subserv_subserv_ssss
				WHERE 
					EXISTS (
						SELECT 1
						FROM tbl_subservicio_ssrv
						WHERE 
							ssrv_pk = ssss_ssrvp_pk
							AND ssrv_tpss_pk = portico.getEntidad('BL')
					)
					AND ssss_ssrvh_pk = item.ssrv_pk
			)
	) AS dato_padre
	, (
		SELECT prdt_prmt_pk
		FROM tbl_parametro_dato_prdt
		WHERE prdt_tpdt_pk = portico.getTipoDato('PAIS')
			AND prdt_prvr_pk = ANY (
				SELECT prvr_pk
				FROM tbl_parametro_version_prvr
					WHERE item.fref BETWEEN prvr_fini AND COALESCE(prvr_ffin, item.fref)
						AND prvr_prmt_pk = ANY (
							SELECT ssdt_prmt_pk
							FROM tbl_subservicio_dato_ssdt
							WHERE ssdt_tpdt_pk = portico.getTipoDato('UNLOCODE')
								AND ssdt_ssrv_pk = ANY (
									SELECT ssss_ssrvp_pk
									FROM tbl_subserv_subserv_ssss
									WHERE 
										EXISTS (
											SELECT 1
											FROM tbl_subservicio_ssrv
											WHERE 
												ssrv_pk = ssss_ssrvp_pk
												AND ssrv_tpss_pk = portico.getEntidad('BL')
										)
										AND ssss_ssrvh_pk = item.ssrv_pk
								)
						) 
			)
	) AS dato_dato_padre
FROM (
	SELECT ssrv.*
		, (
			SELECT srvc_fref
			FROM tbl_servicio_srvc
			WHERE srvc_pk = ssrv_srvc_pk
		) AS fref
	FROM tbl_subservicio_ssrv ssrv
	WHERE ssrv.ssrv_srvc_pk = 1192567
		AND ssrv.ssrv_tpss_pk = portico.getEntidad('PARTIDA')
) item
ORDER BY ssrv_srvc_pk, ssrv_tpss_pk, ssrv_numero
;




SELECT * FROM portico.tbl_subservicio_dato_ssdt
WHERE ssdt_ssrv_pk = 1195604
	AND ssdt_tpdt_pk = portico.getTipoDato('COD_EXEN')
;

SELECT * FROM portico.tbl_tipo_dato_tpdt
order by tpdt_codigo
;

--0		FACT/EST	Facturable y Estadística
--1		FACT/NO EST	Facturable y No Estadística
--2		NO FACT/EST	No Facturable y Si Estadística
--3		NO FACT/NO EST	No Facturable y No Estadística
--4		SIN REVISAR	Sin revisar

;

