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


SELECT srvc.*, ssrv.*, tpss.*
FROM 
	portico.tbl_subservicio_ssrv ssrv
	JOIN portico.tbl_servicio_srvc srvc ON
		srvc_pk = ssrv_srvc_pk
	JOIN portico.tbl_tipo_subservicio_tpss tpss ON
		tpss_pk = ssrv_tpss_pk
WHERE
	ssrv_tpss_pk = 22004
	AND tpss_es_facturable = 1
	AND (
		tpss_tpdt_estado_pk IS NULL
		OR (
			(tpss_pk = portico.getEntidad('PARTIDA') AND ssrv_estado = 'R')
			OR (tpss_pk = portico.getEntidad('EQUIPAMIENTO') AND ssrv_estado = 'R')
		)
	)
	AND (
		tpss_es_exencionable = 0
		OR EXISTS (
			SELECT 1
			FROM portico.tbl_subservicio_dato_ssdt
			WHERE ssdt_ssrv_pk = ssrv_pk
				AND ssdt_tpdt_pk = portico.getTipoDato('COD_EXEN')
		)
	)
	AND ssrv_srvc_pk = 1192567
;


SELECT * FROM portico.tbl_subservicio_dato_ssdt
WHERE ssdt_ssrv_pk = 1195604
	AND ssdt_tpdt_pk = portico.getTipoDato('COD_EXEN')
;

SELECT * FROM portico.tbl_tipo_dato_tpdt
order by tpdt_codigo
;

