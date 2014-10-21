DELETE FROM tbl_parametro_dato_prdt;
-- DELETE FROM tbl_parametro_i18n_p18n;
DELETE FROM tbl_parametro_version_prvr;
DELETE FROM tbl_parametro_prmt;
DELETE FROM tbl_i18n_i18n;

-- Rellenar dependencias de parametros
SELECT prdt_prvr_pk , prdt_tpdt_pk , prdt_nentero , prdt_ndecimal , prdt_fecha , prdt_cadena , prdt_prmt_pk , prmt_parametro , prvr_pk
	, (
		CASE
			WHEN tppr_es_i18n = 1
			THEN (
				SELECT p18n_texto
				FROM tbl_parametro_i18n_p18n
				WHERE p18n_prvr_pk = prvr_pk
					AND p18n_idioma = 'es_ES'
			)
			WHEN tppr_tpdt_nombre_pk IS NOT NULL
			THEN (
				SELECT prdt_cadena
				FROM tbl_parametro_dato_prdt
				WHERE prdt_prvr_pk = prvr_pk
					AND prdt_tpdt_pk = tppr_tpdt_nombre_pk
			)
		END
	) as prmt_texto
FROM (
	SELECT prdt_prvr_pk , prdt_tpdt_pk , prdt_nentero , prdt_ndecimal , prdt_fecha , prdt_cadena , prdt_prmt_pk , prmt_parametro , tppr_es_i18n, tppr_tpdt_nombre_pk
		, (
			SELECT prvr_pk
			FROM tbl_parametro_version_prvr
			WHERE
				prvr_prmt_pk = prdt_prmt_pk
				AND NOW() BETWEEN prvr_fini AND COALESCE(prvr_ffin, NOW())
		) AS prvr_pk
	FROM tbl_parametro_dato_prdt prdt
		LEFT JOIN tbl_parametro_prmt ON
			prmt_pk = prdt_prmt_pk
		LEFT JOIN tbl_tipo_parametro_tppr ON
			tppr_pk = prmt_tppr_pk
	WHERE
		EXISTS (
			SELECT 1
			FROM tbl_parametro_version_prvr
			WHERE prvr_pk = prdt_prvr_pk
				AND EXISTS (
					SELECT 1
					FROM tbl_parametro_prmt
					WHERE prmt_pk = prvr_prmt_pk
						AND prmt_tppr_pk = 20005
				)
		)
) sql
;