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


-- Tasas de un aspecto
SELECT * 
FROM tbl_aspecto_aspc  
	JOIN tbl_aspecto_cargo_ascr ON
		ascr_aspc_pk = aspc_pk
	JOIN tbl_cargo_crgo ON
		crgo_pk = ascr_crgo_pk
;


SELECT * 
FROM tbl_tipo_servicio_tpsr 
	JOIN tbl_entidad_enti ON
		enti_pk = tpsr_pk
;

SELECT * 
FROM tbl_tipo_subservicio_tpss  
	JOIN tbl_entidad_enti ON
		enti_pk = tpss_pk
;
