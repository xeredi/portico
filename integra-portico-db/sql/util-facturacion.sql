﻿SELECT * 
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
