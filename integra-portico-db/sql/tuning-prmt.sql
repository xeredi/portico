
-- Tuning
SELECT COUNT(1)
FROM
	tbl_parametro_prmt
WHERE
	prmt_tppr_pk = 20010
	AND EXISTS (
		SELECT 1
		FROM tbl_parametro_version_prvr
		WHERE
			prvr_prmt_pk = prmt_pk
			AND NOW() BETWEEN prvr_fini AND coalesce(prvr_ffin, NOW())
	)
;


SELECT *
	, (
		CASE
			WHEN tppr_es_i18n = 1
			THEN (
				SELECT i18n_text
				FROM tbl_i18n_i18n
				WHERE i18n_pref = 'prvr'
					AND i18n_ext_pk = prvr_pk
					AND i18n_lang = 'es'
			)
			WHEN tppr_tpdt_pk IS NOT NULL
			THEN (
				SELECT prdt_cadena
				FROM tbl_parametro_dato_prdt
				WHERE prdt_prvr_pk = prvr_pk
					AND prdt_tpdt_pk = tppr_tpdt_pk
			)
		END
	) AS p18n_texto
FROM (
	SELECT *
		, NULL AS rownumVar
	FROM
		tbl_parametro_prmt
		INNER JOIN tbl_parametro_version_prvr ON
			prvr_prmt_pk = prmt_pk
	WHERE
		prmt_tppr_pk = 20010
		AND NOW() BETWEEN prvr_fini AND coalesce(prvr_ffin, NOW())
	ORDER BY prmt_tppr_pk, prmt_parametro
	OFFSET 40 ROWS FETCH NEXT 20 ROWS ONLY
) sql
	INNER JOIN tbl_tipo_parametro_tppr ON
		tppr_pk = prmt_tppr_pk
;


SELECT *
	, (
		CASE
			WHEN tppr_es_i18n = 1 THEN (
				SELECT i18n_text
				FROM tbl_i18n_i18n
				WHERE i18n_pref = 'prvr'
					AND i18n_ext_pk = ANY (
						SELECT prvr_pk
						FROM tbl_parametro_version_prvr
						WHERE prvr_prmt_pk = prdt_prmtDep_pk
							AND NOW() BETWEEN prvr_fini AND COALESCE(prvr_ffin, NOW())
					)
					AND i18n_lang = 'es'
			)
			WHEN tppr_tpdt_pk IS NOT NULL THEN (
				SELECT prdt_cadena
				FROM tbl_parametro_dato_prdt
				WHERE
					prdt_prvr_pk = ANY (
						SELECT prvr_pk
						FROM tbl_parametro_version_prvr
						WHERE prvr_prmt_pk = prdt_prmtDep_pk
							AND NOW() BETWEEN prvr_fini AND COALESCE(prvr_ffin, NOW())
					)
					AND prdt_tpdt_pk = tppr_tpdt_pk
			)
/*
*/
		END
	) AS p18n_texto
FROM (
	SELECT prdt_prvr_pk, prdt_tpdt_pk, prdt_nentero, prdt_ndecimal, prdt_fecha, prdt_prmt_pk AS prdt_prmtDep_pk, prdt_cadena
	FROM tbl_parametro_dato_prdt
	WHERE
		EXISTS (
			SELECT 1
			FROM tbl_parametro_version_prvr
			WHERE
				prvr_pk = prdt_prvr_pk
				AND prvr_pk IN (1047855, 1074225, 1047853, 1074227, 1096659, 1047851, 1074229, 1047849, 1074231, 1072155, 1085661, 1059109, 1047865, 1059111, 1047863, 1059113, 1047861, 1047859, 1067949, 1047857)
		)
		AND EXISTS (
			SELECT 1 FROM tbl_entidad_tipo_dato_entd WHERE entd_tpdt_pk = prdt_tpdt_pk AND entd_enti_pk = 20010 AND entd_gridable = 1
		)
) sql
	LEFT JOIN tbl_parametro_prmt ON
		prmt_pk = prdt_prmtDep_pk
	LEFT JOIN tbl_tipo_parametro_tppr ON
		tppr_pk = prmt_tppr_pk
;
