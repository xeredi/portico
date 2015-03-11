
-- Tuning
SELECT COUNT(1)
FROM tbl_servicio_srvc
WHERE
	srvc_tpsr_pk = 21002
	AND EXISTS ( SELECT 1 FROM tbl_servicio_dato_srdt WHERE srdt_srvc_pk = srvc_pk AND srdt_tpdt_pk = 45365 AND srdt_prmt_pk = 1030322 )
	AND EXISTS ( SELECT 1 FROM tbl_servicio_dato_srdt WHERE srdt_srvc_pk = srvc_pk AND srdt_tpdt_pk = 45180 AND srdt_prmt_pk = 1047650 )
;

SELECT srvc_pk, srvc_tpsr_pk, srvc_anno, srvc_numero, srvc_falta, srvc_fref, srvc_fini, srvc_ffin, srvc_estado, srvc_subp_pk
	, (SELECT prmt_parametro FROM tbl_parametro_prmt WHERE prmt_pk = srvc_subp_pk) AS srvc_subp
	, NULL AS rownumVar
FROM tbl_servicio_srvc srvc
WHERE
	srvc_tpsr_pk = 21002
	AND EXISTS ( SELECT 1 FROM tbl_servicio_dato_srdt WHERE srdt_srvc_pk = srvc_pk AND srdt_tpdt_pk = 45365 AND srdt_prmt_pk = 1030322 )
	AND EXISTS ( SELECT 1 FROM tbl_servicio_dato_srdt WHERE srdt_srvc_pk = srvc_pk AND srdt_tpdt_pk = 45180 AND srdt_prmt_pk = 1047650 )
ORDER BY srvc_pk
OFFSET 60 ROWS FETCH NEXT 20 ROWS ONLY
;


SELECT
	srdt_srvc_pk, srdt_tpdt_pk, srdt_nentero, srdt_ndecimal, srdt_fecha, srdt_prmt_pk, srdt_srvc_dep_pk, srdt_cadena
	, srvc.srvc_fref AS srdt_fref
	, prmt_parametro
	, srvcDep.srvc_anno, srvcDep.srvc_numero
	, ( SELECT prmt_parametro FROM tbl_parametro_prmt WHERE prmt_pk = srvcDep.srvc_subp_pk ) AS srvc_subp
	, (
		CASE
			WHEN tppr_es_i18n = 1
			THEN (
				SELECT i18n_text FROM tbl_i18n_i18n WHERE i18n_pref = 'prvr'
					AND i18n_ext_pk = (
						SELECT prvr_pk FROM tbl_parametro_version_prvr
						WHERE
							prvr_prmt_pk = srdt_prmt_pk
							AND srvc.srvc_fref BETWEEN prvr_fini AND COALESCE(prvr_ffin, srvc.srvc_fref)
					)
					AND i18n_lang = 'es'
			)
			WHEN tppr_tpdt_pk IS NOT NULL
			THEN (
				SELECT prdt_cadena FROM tbl_parametro_dato_prdt
				WHERE
					prdt_prvr_pk = ANY (
						SELECT prvr_pk FROM tbl_parametro_version_prvr
						WHERE
							prvr_prmt_pk = srdt_prmt_pk
							AND srvc.srvc_fref BETWEEN prvr_fini AND COALESCE(prvr_ffin, srvc.srvc_fref)
					)
					AND prdt_tpdt_pk = tppr_tpdt_pk
			)
		END
	) AS p18n_texto
FROM
	tbl_servicio_dato_srdt
	INNER JOIN tbl_servicio_srvc srvc ON
		srvc.srvc_pk = srdt_srvc_pk
	LEFT JOIN tbl_parametro_prmt ON
		prmt_pk = srdt_prmt_pk
	LEFT JOIN tbl_tipo_parametro_tppr ON
		tppr_pk = prmt_tppr_pk
	LEFT JOIN tbl_servicio_srvc srvcDep ON
		srvcDep.srvc_pk = srdt_srvc_dep_pk
WHERE
	EXISTS (
		SELECT 1
		FROM tbl_servicio_srvc
		WHERE
			srvc_pk = srdt_srvc_pk
			AND srvc_pk IN (4188415, 4188414, 4188413, 4188432, 4188431, 4188430, 4188429, 4188428, 4188427, 4188426, 4188425, 4188424, 4188423, 4188422, 4188421, 4188420, 4188419, 4188418, 4188417, 4188416)
	)
	AND EXISTS ( SELECT 1 FROM tbl_entidad_tipo_dato_entd WHERE entd_tpdt_pk = srdt_tpdt_pk AND entd_enti_pk = 21002 AND entd_gridable = 1 )
;
