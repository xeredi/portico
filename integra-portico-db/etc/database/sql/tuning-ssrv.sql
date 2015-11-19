
-- Tuning
SELECT COUNT(1)
FROM tbl_subservicio_ssrv
WHERE ssrv_tpss_pk = 22004
;

SELECT COUNT(1)
FROM (
	SELECT 1
	FROM
		tbl_subservicio_ssrv
	WHERE ssrv_tpss_pk = 22004
	FETCH NEXT 100000 ROWS ONLY
) sql
;

SELECT
	ssrv_pk, ssrv_tpss_pk, ssrv_numero, ssrv_fini, ssrv_ffin, ssrv_estado, srvc_fref , srvc_pk, srvc_anno, srvc_numero
	, (SELECT prmt_parametro FROM tbl_parametro_prmt WHERE prmt_pk = srvc_subp_pk) AS srvc_subp
FROM (
	SELECT ssrv.*
		, NULL AS rownumVar
	FROM tbl_subservicio_ssrv ssrv
	WHERE ssrv_tpss_pk = 22004
	ORDER BY ssrv_srvc_pk, ssrv_numero
	OFFSET 40 ROWS FETCH NEXT 20 ROWS ONLY
) sql
	INNER JOIN tbl_servicio_srvc ON
		srvc_pk = ssrv_srvc_pk
;

SELECT *
FROM (
	SELECT *
	FROM tbl_subservicio_ssrv
	WHERE ssrv_tpss_pk = 22004
	FETCH NEXT 50000 ROWS ONLY
) sql
	INNER JOIN tbl_servicio_srvc ON
		srvc_pk = ssrv_srvc_pk
ORDER BY ssrv_srvc_pk, ssrv_numero
OFFSET 40 ROWS FETCH NEXT 20 ROWS ONLY
;

SELECT ssdt_ssrv_pk, ssdt_tpdt_pk, ssdt_nentero, ssdt_ndecimal, ssdt_fecha, ssdt_cadena , prmt_pk, prmt_parametro
	, ( CASE
		WHEN tppr_es_i18n = 1 THEN ( SELECT i18n_text FROM tbl_i18n_i18n WHERE i18n_pref = 'prvr' AND i18n_ext_pk = ( SELECT prvr_pk FROM tbl_parametro_version_prvr WHERE prvr_prmt_pk = ssdt_prmt_pk AND srvc_fref BETWEEN prvr_fini AND COALESCE(prvr_ffin, srvc_fref) ) AND i18n_lang = 'es' )
		WHEN tppr_tpdt_pk IS NOT NULL THEN ( SELECT prdt_cadena FROM tbl_parametro_dato_prdt WHERE prdt_prvr_pk = ( SELECT prvr_pk FROM tbl_parametro_version_prvr WHERE prvr_prmt_pk = ssdt_prmt_pk AND srvc_fref BETWEEN prvr_fini AND COALESCE(prvr_ffin, srvc_fref) ) AND prdt_tpdt_pk = tppr_tpdt_pk )
	END ) AS p18n_texto
FROM (
	SELECT *
	FROM
		tbl_subservicio_dato_ssdt
	WHERE
		EXISTS (
			SELECT 1
			FROM tbl_subservicio_ssrv
			WHERE ssrv_pk = ssdt_ssrv_pk
				AND ssrv_tpss_pk = 22003
				AND EXISTS ( SELECT 1 FROM tbl_subservicio_dato_ssdt WHERE ssdt_ssrv_pk = ssrv_pk AND ssdt_tpdt_pk = 45056 AND ssdt_prmt_pk = 1029314 )
				AND EXISTS ( SELECT 1 FROM tbl_subservicio_dato_ssdt WHERE ssdt_ssrv_pk = ssrv_pk AND ssdt_tpdt_pk = 45059 AND ssdt_prmt_pk = 1029314 )
				AND EXISTS ( SELECT 1 FROM tbl_subservicio_dato_ssdt WHERE ssdt_ssrv_pk = ssrv_pk AND ssdt_tpdt_pk = 45036 AND ssdt_prmt_pk = 1086700 )
				AND EXISTS ( SELECT 1 FROM tbl_subservicio_dato_ssdt WHERE ssdt_ssrv_pk = ssrv_pk AND ssdt_tpdt_pk = 45040 AND ssdt_prmt_pk = 1007050 )
		)
) sql
	INNER JOIN tbl_subservicio_ssrv ON ssrv_pk = ssdt_ssrv_pk
	INNER JOIN tbl_servicio_srvc ON srvc_pk = ssrv_srvc_pk
	LEFT JOIN tbl_parametro_prmt ON prmt_pk = ssdt_prmt_pk
	LEFT JOIN tbl_tipo_parametro_tppr ON tppr_pk = prmt_tppr_pk
;





