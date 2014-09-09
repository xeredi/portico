SELECT * FROM tbl_periodo_proceso_pepr
;

SELECT *
FROM tbl_estadistica_estd
;

SELECT *
FROM
	tbl_estadistica_estd
	JOIN tbl_periodo_proceso_pepr ON
		pepr_pk = estd_pepr_pk
WHERE
	estd_tpes_pk = 23000
	AND estd_pepr_pk = 2446054
;

SELECT
    estd_autp, TIPO_BUQUE_EEE

    , SUM(ENTERO_01) AS ENTERO_01
    , SUM(ENTERO_02) AS ENTERO_02
FROM (
	SELECT
		(
			SELECT prmt_parametro
			FROM tbl_parametro_prmt
			WHERE prmt_pk = estd_autp_pk
		) AS estd_autp
		, (
			SELECT prmt_parametro
			FROM tbl_parametro_prmt
			WHERE
				EXISTS (
					SELECT 1
					FROM tbl_estadistica_dato_esdt
					WHERE esdt_estd_pk = estd_pk
						AND esdt_prmt_pk = prmt_pk
						AND esdt_tpdt_pk = getTipoDato('TIPO_BUQUE_EEE')
				)
		) AS TIPO_BUQUE_EEE

		, (
			SELECT esdt_nentero
			FROM tbl_estadistica_dato_esdt
			WHERE esdt_estd_pk = estd_pk
				AND esdt_tpdt_pk = getTipoDato('ENTERO_01')
		) AS ENTERO_01
		, (
			SELECT esdt_nentero
			FROM tbl_estadistica_dato_esdt
			WHERE esdt_estd_pk = estd_pk
				AND esdt_tpdt_pk = getTipoDato('ENTERO_02')
		) AS ENTERO_02
	FROM
		tbl_estadistica_estd
		JOIN tbl_periodo_proceso_pepr ON
			pepr_pk = estd_pepr_pk
	WHERE
		estd_tpes_pk = getEntidad('MOVIMIENTO_TIPO_BUQUE_EEE')
--		AND estd_pepr_pk = 2020207
) sql
GROUP BY estd_autp, TIPO_BUQUE_EEE
;
