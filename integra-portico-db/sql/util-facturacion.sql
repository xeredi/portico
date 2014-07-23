-- Cargos a valorar de un servicio (las que salen por pantalla)
SELECT *
FROM portico.tbl_cargo_crgo
	JOIN portico.tbl_cargo_version_crgv ON
		crgv_crgo_pk = crgo_pk
		AND NOW() BETWEEN crgv_fini AND COALESCE(crgv_ffin, NOW())
WHERE crgo_es_principal = 1
	AND crgo_tpsr_pk = 21003
;

-- Cargos a valorar de un servicio (las que NO salen por pantalla)
SELECT *
FROM portico.tbl_cargo_crgo
	JOIN portico.tbl_cargo_version_crgv ON
		crgv_crgo_pk = crgo_pk
		AND NOW() BETWEEN crgv_fini AND COALESCE(crgv_ffin, NOW())
WHERE 
	EXISTS (
		SELECT 1 
		FROM portico.tbl_cargo_dep_crdp
		WHERE crdp_crgoh_pk = crgo_pk
			AND crdp_crgop_pk IN (60003, 60005)
	)
;

-- Reglas de un cargo
SELECT * 
FROM portico.tbl_regla_rgla
;

SELECT * 
FROM portico.tbl_regla_version_rglv
;




















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
where ssrv_srvc_pk = 1194876
group by ssrv_tpss_pk, enti_nombre
;

select * 
from 
	portico.tbl_servicio_srvc
	join portico.tbl_entidad_enti on
		enti_pk = srvc_tpsr_pk
where srvc_pk = 1194876
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






SELECT srvc.*, ssrv.*, tpss.*, tpsr.*
	, (
		SELECT prmt_pk
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
							AND ssss_ssrvh_pk = ssrv.ssrv_pk
					)
			)
	) AS ivat_pk
	, (
		SELECT ssdt_nentero
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
WHERE
	ssrv_tpss_pk = 22004
	AND tpsr_es_facturable = 1
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
									AND ssrv_tpss_pk = getEntidad('BL')
							)
							AND EXISTS (
								SELECT 1
								FROM portico.tbl_subserv_subserv_ssss
								WHERE 
									ssss_ssrvp_pk = ssdt_ssrv_pk
									AND ssss_ssrvh_pk = ssrv.ssrv_pk
							)
							AND (
								(ssdt_tpdt_pk = getTipoDato('BOOLEANO_02') AND ssdt_nentero = 0)
								or (ssdt_tpdt_pk = getTipoDato('TIPO_BL') AND ssdt_cadena = 'P')
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

	AND ssrv_srvc_pk = 1194876

ORDER BY ssrv_srvc_pk, ssrv_numero
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
