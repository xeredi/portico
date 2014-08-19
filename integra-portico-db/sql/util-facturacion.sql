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
		WHERE
			srvc_tpsr_pk = crgo_tpsr_pk
			AND EXISTS (
				SELECT 1 
				FROM tbl_tipo_servicio_tpsr
				WHERE tpsr_pk = srvc_tpsr_pk
					AND (
						(
							tpsr_es_temporal = 0
							AND EXISTS (
								SELECT 1
								FROM tbl_cargo_version_crgv
								WHERE crgv_crgo_pk = crgo_pk
									AND srvc_fref BETWEEN crgv_fini AND COALESCE(crgv_ffin, NOW())
							)
						)
						OR 
						(
							tpsr_es_temporal = 1
							AND EXISTS (
								SELECT 1
								FROM tbl_cargo_version_crgv
								WHERE crgv_crgo_pk = crgo_pk
									AND (
										srvc_fini BETWEEN crgv_fini AND COALESCE(crgv_ffin, NOW())
										OR COALESCE(srvc_ffin, NOW()) BETWEEN crgv_fini AND COALESCE(crgv_ffin, NOW())
									)
							)
						)
					)
			)
			AND srvc_pk = 1259571
	)
	AND crgo_es_principal = 1
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
--where ssrv_srvc_pk = 1192567
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

select ssrv_srvc_pk, count(1)
from 
	portico.tbl_subservicio_ssrv
group by ssrv_srvc_pk
;








SELECT * FROM tbl_cargo_crgo;
SELECT * FROM tbl_regla_rgla;

SELECT * FROM tbl_servicio_cargo_srcr;
SELECT * FROM tbl_valoracion_tmp_vlrt;
SELECT * FROM vw_valoracion_vlrc;
SELECT * FROM vw_valoracion_lin_vlrl ORDER BY vlrl_pk;
SELECT * FROM vw_valoracion_det_vlrd;
SELECT * FROM vw_valoracion_cargo_vlrg;
SELECT * FROM tbl_valoracion_vlrc;
SELECT * FROM tbl_valoracion_cargo_vlrg;
SELECT * FROM tbl_valoracion_imp_vlri;
SELECT * FROM tbl_valoracion_lin_vlrl;
SELECT * FROM tbl_valoracion_det_vlrd;
SELECT * FROM tbl_valoracion_tmp_vlrt;
SELECT * FROM tbl_factura_fctr;
SELECT * FROM tbl_factura_cargo_fctc;
SELECT * FROM tbl_factura_srv_fcts;
SELECT * FROM tbl_factura_imp_fcti;
SELECT * FROM tbl_factura_lin_fctl;
SELECT * FROM tbl_factura_det_fctd;
SELECT * FROM VW_factura_fctr;


-- Vistas facturacion
SELECT *
FROM tbl_factura_imp_fcti
	join tbl_parametro_prmt ON
		prmt_pk = fcti_impuesto_prmt_pk
	JOIN tbl_parametro_version_prvr ON
		prvr_prmt_pk = fcti_impuesto_prmt_pk
		AND EXISTS (
			SELECT 1
			FROM portico.tbl_factura_fctr
			WHERE 
				fctr_pk = fcti_fctr_pk
				AND fctr_fref BETWEEN prvr_fini AND COALESCE(prvr_ffin, fctr_fref)
		)
;


CREATE VIEW portico.vw_factura_cargo_fctc AS
	SELECT * 
	FROM 
		portico.tbl_factura_cargo_fctc
		INNER JOIN portico.tbl_cargo_crgo ON
			crgo_pk = fctc_crgo_pk
		INNER JOIN portico.tbl_cargo_version_crgv ON
			crgv_crgo_pk = fctc_crgo_pk
			AND EXISTS (
				SELECT 1
				FROM portico.tbl_factura_fctr
				WHERE 
					fctr_pk = fctc_fctr_pk
					AND fctr_fref BETWEEN crgv_fini AND COALESCE(crgv_ffin, fctr_fref)
			)
\

GRANT SELECT ON portico.vw_factura_cargo_fctc TO portico
\

SELECT * FROM vw_factura_cargo_fctc;

DELETE FROM tbl_servicio_cargo_srcr;
DELETE FROM tbl_valoracion_tmp_vlrt;
DELETE FROM tbl_valoracion_det_vlrd;
DELETE FROM tbl_valoracion_lin_vlrl;
DELETE FROM tbl_valoracion_imp_vlri;
DELETE FROM tbl_valoracion_cargo_vlrg;
DELETE FROM tbl_valoracion_vlrc;

DELETE FROM tbl_factura_det_fctd;
DELETE FROM tbl_factura_lin_fctl;
DELETE FROM tbl_factura_imp_fcti;
DELETE FROM tbl_factura_srv_fcts;
DELETE FROM tbl_factura_cargo_fctc;
DELETE FROM tbl_factura_fctr;




SELECT *
FROM 
	tbl_factura_srv_fcts
	INNER JOIN tbl_factura_lin_fctl ON
		fctl_fcts_pk = fcts_pk
	INNER JOIN tbl_factura_det_fctd ON
		fctd_fctl_pk = fctl_pk
WHERE fcts_fctr_pk = 1
;


-- Facturar
-- Facturar
-- Facturar
-- Facturar

-- Comprobar que todos los cargos de las valoraciones encajan en el aspecto.
SELECT COUNT(1)
FROM tbl_valoracion_cargo_vlrg
WHERE 
	NOT EXISTS (
		SELECT 1
		FROM tbl_aspecto_cargo_ascr
		WHERE 
			ascr_crgo_pk = vlrg_crgo_pk
			AND EXISTS (
				SELECT 1
				FROM tbl_aspecto_version_aspv
				WHERE 
					aspv_pk = ascr_aspv_pk
					AND NOW() BETWEEN aspv_fini AND COALESCE(aspv_ffin, NOW())
					AND aspv_aspc_pk = 61001
			)
	)
;


SELECT * 
FROM 
	tbl_aspecto_aspc
	INNER JOIN tbl_aspecto_version_aspv ON
		aspv_aspc_pk = aspc_pk
		AND NOW() BETWEEN aspv_fini AND COALESCE(aspv_ffin, NOW())
;


SELECT *
FROM 
	tbl_valoracion_vlrc
	INNER JOIN tbl_valoracion_lin_vlrl ON
		vlrl_vlrc_pk = vlrc_pk
	INNER JOIN tbl_valoracion_det_vlrd ON
		vlrd_vlrl_pk = vlrl_pk
		AND vlrd_vlrc_pk = vlrc_pk
-- WHERE vlrc_pk = 1859167
ORDER BY vlrc_pagador_pk, vlrc_pk, vlrl_pk, vlrd_pk
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




-- Situacion de un servicio
SELECT *
FROM tbl_regla_rgla
	INNER JOIN tbl_regla_version_rglv ON
		rglv_rgla_pk = rgla_pk
	INNER JOIN tbl_entidad_enti ON
		enti_pk = rgla_enti_pk
WHERE rgla_tipo = 'T'
;


SELECT *
	, (
		CASE 
			WHEN
				crgo_es_temporal = 0
			THEN 
				'Cargo no Temporal'
			ELSE 
				'Cargo Temporal'
		END
	) AS estado
FROM 
	tbl_servicio_srvc
	INNER JOIN tbl_tipo_servicio_tpsr ON
		tpsr_pk = srvc_tpsr_pk
	INNER JOIN tbl_cargo_crgo ON
		crgo_tpsr_pk = tpsr_pk
		AND crgo_es_principal = 1
		AND EXISTS (
			SELECT 1 
			FROM tbl_cargo_version_crgv
			WHERE crgv_crgo_pk = crgo_pk
				AND (
					(
						tpsr_es_temporal = 0
						AND srvc_fref BETWEEN crgv_fini AND COALESCE(crgv_ffin, srvc_fref)
					)
					OR
					(
						tpsr_es_temporal = 1
						AND (
							srvc_fini BETWEEN crgv_fini AND COALESCE(crgv_ffin, srvc_fini)
							OR COALESCE(srvc_ffin, NOW()) BETWEEN crgv_fini AND COALESCE(crgv_ffin, COALESCE(srvc_ffin, NOW()))
						)
					)
				)
		)
WHERE 
	srvc_pk = 1259571
;






