SELECT * 
	, (
		SELECT p18n_texto
		FROM tbl_parametro_i18n_p18n
		WHERE p18n_prvr_pk = prvr_pk
			AND p18n_idioma = 'es_ES'
	)
FROM tbl_servicio_srvc
	INNER JOIN tbl_parametro_prmt ON
		prmt_pk = srvc_subp_pk
	LEFT JOIN tbl_parametro_version_prvr ON
		prvr_prmt_pk = srvc_subp_pk
		AND srvc_fref BETWEEN prvr_fini AND COALESCE(prvr_ffin, srvc_fref)
;



SELECT *
	, (
		SELECT prmt_parametro
		FROM tbl_parametro_prmt
		WHERE prmt_pk = srvc_subp_pk
	)
FROM 
	tbl_subservicio_ssrv
	JOIN tbl_servicio_srvc ON
		srvc_pk = ssrv_srvc_pk
;


SELECT *
	, (
		CASE 
			WHEN tppr_es_i18n = 1
			THEN (
				SELECT p18n_texto
				FROM tbl_parametro_i18n_p18n
				WHERE p18n_prvr_pk = prvr_pk
					AND p18n_idioma = 'es_ES'
			)
			WHEN tppr_tpdt_pk IS NOT NULL
			THEN (
				SELECT prdt_cadena
				FROM tbl_parametro_dato_prdt
				WHERE prdt_prvr_pk = prvr_pk
					AND prdt_tpdt_pk = tppr_tpdt_pk
			)
		END
	)
FROM 
	tbl_servicio_dato_srdt
	INNER JOIN tbl_servicio_srvc ON
		srvc_pk = srdt_srvc_pk
	LEFT JOIN tbl_parametro_prmt ON
		prmt_pk = srdt_prmt_pk
	LEFT JOIN tbl_parametro_version_prvr ON
		prvr_prmt_pk = srdt_prmt_pk
		AND srvc_fref BETWEEN prvr_fini AND COALESCE(prvr_ffin, srvc_fref)
	LEFT JOIN tbl_tipo_parametro_tppr ON
		tppr_pk = prmt_tppr_pk
WHERE srdt_srvc_pk = 1259366
;


SELECT ssss_ssrvp_pk, ssss_ssrvh_pk
FROM tbl_subserv_subserv_ssss
WHERE 
	EXISTS (
		SELECT 1 
		FROM tbl_subservicio_ssrv
		WHERE ssrv_pk = ssss_ssrvp_pk
			AND ssrv_srvc_pk = 1259570
	)
;


SELECT * FROM tbl_