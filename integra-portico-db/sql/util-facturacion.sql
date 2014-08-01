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



SELECT *
FROM
	portico.tbl_entidad_tipo_dato_entd
	JOIN portico.tbl_tipo_dato_tpdt ON
		tpdt_pk = entd_tpdt_pk
WHERE 
	entd_enti_pk = portico.getEntidad('MANIFIESTO')
--	AND entd_tpdt_pk = portico.getTipoDato('BOOLEANO_02')
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

SELECT * FROM portico.tbl_tipo_dato_tpdt
order by tpdt_codigo
;



DELETE FROM portico.tbl_valoracion_tmp_vlrt;

--0		FACT/EST	Facturable y Estadística
--1		FACT/NO EST	Facturable y No Estadística
--2		NO FACT/EST	No Facturable y Si Estadística
--3		NO FACT/NO EST	No Facturable y No Estadística
--4		SIN REVISAR	Sin revisar

SELECT * FROM portico.tbl_proceso_batch_prbt;

select ssrv_srvc_pk, count(1)
from 
	portico.tbl_subservicio_ssrv
group by ssrv_srvc_pk
;

SELECT *
FROM tbl_servicio_srvc
WHERE
	srvc_tpsr_pk = portico.getEntidad('ESCALA')
	and SRVC_ESTADO in ('I', 'F')
;

SELECT *
FROM tbl_servicio_srvc
WHERE
	srvc_tpsr_pk = portico.getEntidad('MANIFIESTO')
;

SELECT *
FROM tbl_subservicio_ssrv
WHERE
	EXISTS (
		SELECT 1
		FROM tbl_servicio_srvc
		WHERE
			srvc_pk = ssrv_srvc_pk
			AND srvc_tpsr_pk = portico.getEntidad('ESCALA')
			and SRVC_ESTADO in ('I', 'F')
	)
;















