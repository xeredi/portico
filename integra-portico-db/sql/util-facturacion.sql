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
	entd_enti_pk = portico.getEntidad('ESCALA')
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

SELECT * FROM tbl_tipo_dato_tpdt
order by tpdt_codigo;









SELECT * FROM portico.tbl_subservicio_dato_ssdt
WHERE ssdt_ssrv_pk = 1195604
	AND ssdt_tpdt_pk = portico.getTipoDato('COD_EXEN')
;

SELECT * FROM portico.tbl_tipo_dato_tpdt
order by tpdt_codigo
;



SELECT vlrt_srvc_pk, vlrt_pagador_pk, vlrt_es_suj_pasivo, vlrt_cod_exen, vlrt_fref, vlrt_fliq, vlrt_crgo_pk, rglv_orden, ssrv_numero, vlrt_rgla_padre_pk, vlrt_rgla_pk, vlrt_ssrv_pk
FROM (
	SELECT vlrt.*
		, rgla.*
		, rglv.*
		, ssrv.*
		,  CASE
			WHEN rgla_tipo = 'T'
			THEN 1
			WHEN rgla_tipo = 'C'
			THEN 2
			WHEN rgla_tipo = 'D'
			THEN 3
		END AS tipo_regla_prec
	FROM 
		tbl_valoracion_tmp_vlrt vlrt
		INNER JOIN tbl_regla_rgla rgla ON
			rgla_pk = vlrt_rgla_pk
		INNER JOIN tbl_regla_version_rglv rglv ON
			rglv_rgla_pk = vlrt_rgla_pk
			AND vlrt_fini BETWEEN rglv_fini AND COALESCE(rglv_ffin, vlrt_fini)
		LEFT JOIN tbl_subservicio_ssrv ssrv ON
			ssrv_pk = vlrt_ssrv_pk
) sql
ORDER BY vlrt_prbt_pk, vlrt_srvc_pk, vlrt_pagador_pk, vlrt_es_suj_pasivo, vlrt_cod_exen, ssrv_tpss_pk, ssrv_numero, vlrt_crgo_pk, rglv_orden, tipo_regla_prec
;

SELECT *
FROM 
	tbl_valoracion_tmp_vlrt vlrt
;

SELECT DISTINCT vlrt_pagador_pk, vlrt_crgo_pk
FROM tbl_valoracion_tmp_vlrt;


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


SELECT 
	aspc_pk, aspc_codigo, aspc_tpsr_pk, aspc_descripcion
	, aspv_pk, aspv_fini, aspv_ffin
	, aspv_cpath_info1, aspv_cetiq_info1, aspv_cpath_info2, aspv_cetiq_info2, aspv_cpath_info3, aspv_cetiq_info3
	, aspv_cpath_info4, aspv_cetiq_info4, aspv_cpath_info5, aspv_cetiq_info5, aspv_cpath_info6, aspv_cetiq_info6
	, aspv_lsum_cuant1, aspv_lsum_cuant2, aspv_lsum_cuant3, aspv_lsum_cuant4, aspv_lsum_cuant5, aspv_lsum_cuant6
	, aspv_lgrp_cuant1, aspv_lgrp_cuant2, aspv_lgrp_cuant3, aspv_lgrp_cuant4, aspv_lgrp_cuant5, aspv_lgrp_cuant6
	, aspv_lgrp_info1, aspv_lgrp_info2, aspv_lgrp_info3, aspv_lgrp_info4, aspv_lgrp_info5, aspv_lgrp_info6
from tbl_aspecto_aspc
	JOIN tbl_aspecto_version_aspv ON
		aspv_aspc_pk = aspc_pk
		AND NOW() BETWEEN aspv_fini AND COALESCE(aspv_ffin, NOW())
WHERE 
	EXISTS (
		SELECT 1 
		FROM tbl_servicio_srvc
		WHERE srvc_tpsr_pk = aspc_tpsr_pk
			AND srvc_pk = 1209891
	)
;



        SELECT
            vlrt_srvc_pk AS vlrc_srvc_pk
            , vlrt_pagador_pk AS vlrc_pagador_pk
            , vlrt_es_suj_pasivo AS vlrc_es_suj_pasivo
            , vlrt_cod_exen AS vlrc_cod_exen

            , vlrt_rgla_pk AS vlrl_rgla_pk

            , vlrt_info1 AS vlrl_info1
            , vlrt_info2 AS vlrl_info2
            , vlrt_info3 AS vlrl_info3
            , vlrt_info4 AS vlrl_info4
            , vlrt_info5 AS vlrl_info5
            , vlrt_info6 AS vlrl_info6

            , vlrt_ssrv_pk AS vlrd_ssrv_pk

            , vlrt_cuant1 AS vlrd_cuant1
            , vlrt_cuant2 AS vlrd_cuant2
            , vlrt_cuant3 AS vlrd_cuant3
            , vlrt_cuant4 AS vlrd_cuant4
            , vlrt_cuant5 AS vlrd_cuant5
            , vlrt_cuant6 AS vlrd_cuant6

            , (
                CASE
                    WHEN rgla_tipo = 'T' THEN 1
                    WHEN rgla_tipo = 'C' THEN 2
                    ELSE 3
                END
            ) AS regla_tipo_orden
        FROM
            tbl_valoracion_tmp_vlrt vlrt
            INNER JOIN tbl_regla_rgla rgla ON
                rgla_pk = vlrt_rgla_pk
            LEFT JOIN tbl_subservicio_ssrv ssrv ON
                ssrv_pk = vlrt_ssrv_pk
WHERE 
	EXISTS (
		SELECT 1 
		FROM tbl_aspecto_cargo_ascr
		WHERE 
			ascr_crgo_pk = vlrt_crgo_pk
			AND ascr_aspv_pk = 65001
	)
ORDER BY vlrt_prbt_pk, vlrt_srvc_pk, vlrt_pagador_pk, vlrt_es_suj_pasivo, vlrt_cod_exen
	, ssrv_tpss_pk, vlrt_info1, regla_tipo_orden
;
