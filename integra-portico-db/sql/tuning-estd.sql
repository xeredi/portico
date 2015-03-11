-- Tuning

SELECT COUNT(1)
FROM tbl_estadistica_estd
WHERE
	estd_tpes_pk = 23005
	AND EXISTS (
		SELECT 1
		FROM tbl_periodo_proceso_pepr
		WHERE
			pepr_pk = estd_pepr_pk
			AND pepr_autp_pk = 1030308
			AND pepr_pk = 4498001
	)
;



SELECT
	estd_pk, estd_pepr_pk, estd_tpes_pk, estd_subp_pk
	, pepr_pk, pepr_autp_pk, pepr_anio, pepr_mes
	, (
		SELECT prmt_parametro
		FROM tbl_parametro_prmt
		WHERE
			prmt_pk = estd_subp_pk
	) AS estd_subp
	, (
		SELECT prmt_parametro
		FROM tbl_parametro_prmt
		WHERE
			prmt_pk = pepr_autp_pk
	) AS pepr_autp
	, (
		SELECT i18n_text
		FROM tbl_i18n_i18n
		WHERE
			i18n_pref = 'prvr'
			AND i18n_ext_pk = (
				SELECT prvr_pk
				FROM tbl_parametro_version_prvr
				WHERE
					prvr_prmt_pk = estd_subp_pk
					AND pepr_freferencia BETWEEN prvr_fini AND COALESCE(prvr_ffin, pepr_freferencia)
			)
			AND i18n_lang = 'es'
	) AS p18n_texto
FROM (
	SELECT
		estd_pk, estd_pepr_pk, estd_tpes_pk, estd_subp_pk
		, pepr_pk, pepr_autp_pk, pepr_anio, pepr_mes, pepr_freferencia
		, NULL AS rownumVar
	FROM
		tbl_estadistica_estd
		INNER JOIN tbl_periodo_proceso_pepr ON
			pepr_pk = estd_pepr_pk
	WHERE
		estd_tpes_pk = 23005
		AND pepr_pk = 4498001
		AND pepr_autp_pk = 1030308
		AND estd_pk = 4498178
	ORDER BY estd_tpes_pk, estd_pk
	-- OFFSET 60 ROWS FETCH NEXT 20 ROWS ONLY
) sql
;






SELECT
	esdt_estd_pk, esdt_tpdt_pk, esdt_nentero, esdt_ndecimal, esdt_prmt_pk, esdt_cadena
	, prmt_parametro
	, (
		CASE
			WHEN tppr_es_i18n = 1
			THEN (
				SELECT i18n_text
				FROM tbl_i18n_i18n
				WHERE
					i18n_pref = 'prvr'
					AND i18n_ext_pk = (
						SELECT prvr_pk
						FROM tbl_parametro_version_prvr
						WHERE
							prvr_prmt_pk = esdt_prmt_pk
							AND pepr_freferencia BETWEEN prvr_fini AND COALESCE(prvr_ffin, pepr_freferencia)
					)
					AND i18n_lang = 'es'
			)
			WHEN tppr_tpdt_pk IS NOT NULL
			THEN (
				SELECT prdt_cadena
				FROM tbl_parametro_dato_prdt
				WHERE
					prdt_prvr_pk = ANY (
						SELECT prvr_pk
						FROM tbl_parametro_version_prvr
						WHERE
							prvr_prmt_pk = esdt_prmt_pk
							AND pepr_freferencia BETWEEN prvr_fini AND COALESCE(prvr_ffin, pepr_freferencia)
					)
					AND esdt_tpdt_pk = tppr_tpdt_pk
			)
		END
	) AS p18n_texto
FROM
	tbl_estadistica_dato_esdt
	INNER JOIN tbl_estadistica_estd ON
		estd_pk = esdt_estd_pk
	INNER JOIN tbl_periodo_proceso_pepr ON
		pepr_pk = estd_pepr_pk
	LEFT JOIN tbl_parametro_prmt ON
		prmt_pk = esdt_prmt_pk
	LEFT JOIN tbl_tipo_parametro_tppr ON
		tppr_pk = prmt_tppr_pk
WHERE
	estd_pk IN (4498244, 4498245, 4498246, 4498247, 4498240, 4498241, 4498242, 4498243, 4498252, 4498253, 4498254, 4498255, 4498248, 4498249, 4498250, 4498251, 4498256, 4498257, 4498238, 4498239)
	AND esdt_tpdt_pk = ANY (
		SELECT entd_tpdt_pk FROM tbl_entidad_tipo_dato_entd WHERE entd_enti_pk = 23005 AND entd_gridable = 1
	)
;
