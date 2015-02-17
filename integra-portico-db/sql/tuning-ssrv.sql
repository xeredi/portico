DEBUG 2015-02-16 05:22:42,506 [org.apache.ibatis.logging.jdbc.BaseJdbcLogger.debug(BaseJdbcLogger.java:139)]
	==>  Preparing: SELECT COUNT(1) FROM vw_subservicio_ssrv WHERE ssrv_tpss_pk = ? 
DEBUG 2015-02-16 05:22:42,506 [org.apache.ibatis.logging.jdbc.BaseJdbcLogger.debug(BaseJdbcLogger.java:139)]
	==> Parameters: 22004(Long)
DEBUG 2015-02-16 05:22:43,137 [org.apache.ibatis.logging.jdbc.BaseJdbcLogger.debug(BaseJdbcLogger.java:139)]
	<==      Total: 1
DEBUG 2015-02-16 05:22:43,137 [org.apache.ibatis.logging.jdbc.BaseJdbcLogger.debug(BaseJdbcLogger.java:139)]
	==>  Preparing: SELECT ssrv_pk, ssrv_tpss_pk, ssrv_numero, ssrv_fini, ssrv_ffin, ssrv_estado, srvc_fref , srvc_pk, srvc_anno, srvc_numero , (SELECT prmt_parametro FROM tbl_parametro_prmt WHERE prmt_pk = srvc_subp_pk) AS srvc_subp , NULL AS rownumVar FROM vw_subservicio_ssrv ssrv WHERE ssrv_tpss_pk = ? ORDER BY ssrv_srvc_pk, ssrv_numero OFFSET 40 ROWS FETCH NEXT 20 ROWS ONLY 
DEBUG 2015-02-16 05:22:43,138 [org.apache.ibatis.logging.jdbc.BaseJdbcLogger.debug(BaseJdbcLogger.java:139)]
	==> Parameters: 22004(Long)
DEBUG 2015-02-16 05:22:48,332 [org.apache.ibatis.logging.jdbc.BaseJdbcLogger.debug(BaseJdbcLogger.java:139)]
	<==      Total: 20
DEBUG 2015-02-16 05:22:48,333 [org.apache.ibatis.logging.jdbc.BaseJdbcLogger.debug(BaseJdbcLogger.java:139)]
	==>  Preparing: SELECT ssdt_ssrv_pk, ssdt_tpdt_pk, ssdt_nentero, ssdt_ndecimal, ssdt_fecha, ssdt_cadena , prmt_pk, prmt_parametro , ( CASE WHEN tppr_es_i18n = 1 THEN ( SELECT i18n_text FROM tbl_i18n_i18n WHERE i18n_pref = 'prvr' AND i18n_ext_pk = ( SELECT prvr_pk FROM tbl_parametro_version_prvr WHERE prvr_prmt_pk = ssdt_prmt_pk AND ssdt_fref BETWEEN prvr_fini AND COALESCE(prvr_ffin, ssdt_fref) ) AND i18n_lang = ? ) WHEN tppr_tpdt_pk IS NOT NULL THEN ( SELECT prdt_cadena FROM tbl_parametro_dato_prdt WHERE prdt_prvr_pk = ( SELECT prvr_pk FROM tbl_parametro_version_prvr WHERE prvr_prmt_pk = ssdt_prmt_pk AND ssdt_fref BETWEEN prvr_fini AND COALESCE(prvr_ffin, ssdt_fref) ) AND prdt_tpdt_pk = tppr_tpdt_pk ) END ) AS p18n_texto FROM vw_subservicio_dato_ssdt ssdt WHERE ssdt_ssrv_pk IN (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) AND EXISTS ( SELECT 1 FROM tbl_entidad_tipo_dato_entd WHERE entd_tpdt_pk = ssdt_tpdt_pk AND entd_enti_pk = ? AND entd_gridable = 1 ) 
DEBUG 2015-02-16 05:22:48,334 [org.apache.ibatis.logging.jdbc.BaseJdbcLogger.debug(BaseJdbcLogger.java:139)]
	==> Parameters: es(String), 1234066(Long), 1234067(Long), 1234064(Long), 1234065(Long), 1233978(Long), 1233979(Long), 1233976(Long), 1233977(Long), 1233982(Long), 1233983(Long), 1233980(Long), 1233981(Long), 1234058(Long), 1234059(Long), 1234056(Long), 1234057(Long), 1234062(Long), 1234063(Long), 1234060(Long), 1234061(Long), 22004(Long)
DEBUG 2015-02-16 05:22:48,394 [org.apache.ibatis.logging.jdbc.BaseJdbcLogger.debug(BaseJdbcLogger.java:139)]
	<==      Total: 340


-- Actual
SELECT COUNT(1) FROM vw_subservicio_ssrv WHERE ssrv_tpss_pk = 22004
;

SELECT 
	ssrv_pk, ssrv_tpss_pk, ssrv_numero, ssrv_fini, ssrv_ffin, ssrv_estado, srvc_fref , srvc_pk, srvc_anno, srvc_numero 
	, (SELECT prmt_parametro FROM tbl_parametro_prmt WHERE prmt_pk = srvc_subp_pk) AS srvc_subp 
	, NULL AS rownumVar 
FROM 
	vw_subservicio_ssrv ssrv 
WHERE ssrv_tpss_pk = 22004 
ORDER BY ssrv_srvc_pk, ssrv_numero 
OFFSET 40 ROWS FETCH NEXT 20 ROWS ONLY 
;

SELECT 
	ssdt_ssrv_pk, ssdt_tpdt_pk, ssdt_nentero, ssdt_ndecimal, ssdt_fecha, ssdt_cadena , prmt_pk, prmt_parametro 
	, ( 
		CASE 
			WHEN tppr_es_i18n = 1 
			THEN ( 
				SELECT i18n_text 
				FROM tbl_i18n_i18n 
				WHERE i18n_pref = 'prvr' 
					AND i18n_ext_pk = ( 
						SELECT prvr_pk 
						FROM tbl_parametro_version_prvr 
						WHERE prvr_prmt_pk = ssdt_prmt_pk AND ssdt_fref BETWEEN prvr_fini AND COALESCE(prvr_ffin, ssdt_fref) 
					) 
					AND i18n_lang = 'es' 
			) 
			WHEN tppr_tpdt_pk IS NOT NULL 
			THEN ( 
				SELECT prdt_cadena 
				FROM tbl_parametro_dato_prdt 
				WHERE 
					prdt_prvr_pk = ( 
						SELECT prvr_pk 
						FROM tbl_parametro_version_prvr 
						WHERE prvr_prmt_pk = ssdt_prmt_pk 
							AND ssdt_fref BETWEEN prvr_fini AND COALESCE(prvr_ffin, ssdt_fref) 
					) 
					AND prdt_tpdt_pk = tppr_tpdt_pk 
			) 
		END 
	) AS p18n_texto 
FROM 
	vw_subservicio_dato_ssdt ssdt 
WHERE 
	ssdt_ssrv_pk IN (1234066, 1234067, 1234064, 1234065, 1233978, 1233979, 1233976, 1233977, 1233982, 1233983, 1233980, 1233981, 1234058, 1234059, 1234056, 1234057, 1234062, 1234063, 1234060, 1234061) 
	AND EXISTS ( SELECT 1 FROM tbl_entidad_tipo_dato_entd WHERE entd_tpdt_pk = ssdt_tpdt_pk AND entd_enti_pk = 22004 AND entd_gridable = 1 ) 
;







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
	SELECT *
		, NULL AS rownumVar 
	FROM tbl_subservicio_ssrv
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





