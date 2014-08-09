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
select prmt_tppr_pk, enti_nombre, count(1)
from 
	tbl_parametro_prmt
	join tbl_entidad_enti on
		enti_pk = prmt_tppr_pk
group by prmt_tppr_pk, enti_nombre
order by enti_nombre
;

select srvc_tpsr_pk, enti_nombre, count(1)
from 
	tbl_servicio_srvc
	join tbl_entidad_enti on
		enti_pk = srvc_tpsr_pk
group by srvc_tpsr_pk, enti_nombre
;

select ssrv_tpss_pk, enti_nombre, count(1)
from 
	tbl_subservicio_ssrv
	join tbl_entidad_enti on
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
	entd_enti_pk = portico.getEntidad('TIPO_IVA')
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




--0		FACT/EST	Facturable y Estadística
--1		FACT/NO EST	Facturable y No Estadística
--2		NO FACT/EST	No Facturable y Si Estadística
--3		NO FACT/NO EST	No Facturable y No Estadística
--4		SIN REVISAR	Sin revisar

SELECT * FROM tbl_proceso_batch_prbt;

SELECT * FROM tbl_valoracion_tmp_vlrt;
SELECT * FROM tbl_valoracion_vlrc;
SELECT * FROM tbl_valoracion_cargo_vlrg;
SELECT * FROM tbl_valoracion_imp_vlri;
SELECT * FROM tbl_valoracion_lin_vlrl;
SELECT * FROM tbl_valoracion_det_vlrd;

SELECT * FROM tbl_cargo_crgo;
SELECT * FROM tbl_regla_rgla;



SELECT * FROM tbl_parametro_prmt
WHERE prmt_pk = 1007029;


DELETE FROM tbl_valoracion_tmp_vlrt;
DELETE FROM tbl_valoracion_det_vlrd;
DELETE FROM tbl_valoracion_lin_vlrl;
DELETE FROM tbl_valoracion_imp_vlri;
DELETE FROM tbl_valoracion_cargo_vlrg;
DELETE FROM tbl_valoracion_vlrc;

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


SELECT * FROM tbl_subservicio_ssrv WHERE ssrv_srvc_pk = 1209891;














SELECT 
	vlrt_prbt_pk
        , srvc_pk AS vlrt_srvc_pk
        , NULL AS vlrt_ssrv_pk
        , rgla_crgo_pk AS vlrt_crgo_pk
        , rgla_pk AS vlrt_rgla_pk
        , vlrt_rgla_pk AS vlrt_rgla_padre_pk
        , NULL AS vlrt_orden
        , importe_base AS vlrt_importe_base
        , (
		CASE
			WHEN rgla_tipo = 'C'
			THEN importe_base * (valor_base - 1)
			WHEN rgla_tipo = 'B'
			THEN importe_base * (- valor_base) / 100
			ELSE 0
		END
        ) AS vlrt_importe
        , valor_base AS vlrt_valor_base
        , importe_inc AS vlrt_importe_inc

        , vlrt_cuant1, vlrt_cuant2, vlrt_cuant3, vlrt_cuant4, vlrt_cuant5, vlrt_cuant6
        , vlrt_info1, vlrt_info2, vlrt_info3, vlrt_info4, vlrt_info5, vlrt_info6
        , vlrt_impuesto_pk, vlrt_es_suj_pasivo, vlrt_pagador_pk, vlrt_cod_exen
FROM (
	SELECT *
		, COALESCE(
			(
				SELECT SUM(vlrt_importe)
				FROM tbl_valoracion_tmp_vlrt
				WHERE 
					vlrt_prbt_pk = 1237001
					AND vlrt_srvc_pk = srvc_pk
					AND vlrt_crgo_pk = rgla_crgo_pk
					AND NOT EXISTS (
						SELECT 1
						FROM tbl_regla_inc_rgin
						WHERE 
							rgin_rgla1_pk = vlrt_rgla_pk
							AND rgin_rgla2_pk = rgla_pk
					)
			)
			, 0) AS importe_base
		, COALESCE(
			(
				SELECT SUM(vlrt_importe)
				FROM tbl_valoracion_tmp_vlrt
				WHERE 
					vlrt_prbt_pk = 1237001
					AND vlrt_srvc_pk = srvc_pk
					AND vlrt_crgo_pk = rgla_crgo_pk
					AND EXISTS (
						SELECT 1
						FROM tbl_regla_inc_rgin
						WHERE 
							rgin_rgla1_pk = vlrt_rgla_pk
							AND rgin_rgla2_pk = rgla_pk
					)
			)
			, 0) AS importe_inc
		, 0.5 AS valor_base
	FROM tbl_servicio_srvc item
		JOIN tbl_regla_rgla ON
			rgla_enti_pk = srvc_tpsr_pk
			AND rgla_pk = 63001
		JOIN tbl_valoracion_tmp_vlrt ON
			vlrt_srvc_pk = srvc_pk
			AND vlrt_prbt_pk = 1237001
	                AND vlrt_crgo_pk = rgla_crgo_pk
			AND vlrt_rgla_pk = ANY (
			    SELECT rgla_pk
			    FROM tbl_regla_rgla
			    WHERE rgla_crgo_pk = vlrt_crgo_pk
				AND rgla_tipo = 'T'
			)
	WHERE 
		srvc_pk = 1229570
) item
;




