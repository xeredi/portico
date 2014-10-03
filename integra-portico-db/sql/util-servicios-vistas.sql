SELECT * FROM vw_servicio_srvc;
SELECT * FROM vw_subservicio_ssrv;
SELECT * 
FROM vw_servicio_dato_srdt
WHERE srdt_srvc_pk = 1819001
;


SELECT * 
FROM 
	tbl_estadistica_estd
	INNER JOIN tbl_periodo_proceso_pepr ON
		pepr_pk = estd_pepr_pk
	INNER JOIN tbl_parametro_prmt ON
		prmt_pk = estd_subp_pk
	LEFT JOIN tbl_parametro_version_prvr ON
		prvr_prmt_pk = prmt_pk
		AND pepr_freferencia BETWEEN prvr_fini AND COALESCE(prvr_ffin, pepr_freferencia)
LIMIT 100;




SELECT * 
	, (
		CASE 
			WHEN tppr_es_i18n = 1
			THEN (
				SELECT p18n_texto
				FROM tbl_parametro_i18n_p18n
				WHERE 
					p18n_prvr_pk = ANY (
						SELECT prvr_pk
						FROM tbl_parametro_version_prvr
						WHERE 
							prvr_prmt_pk = esdt_prmt_pk
							AND esdt_fref BETWEEN prvr_fini AND COALESCE(prvr_ffin, esdt_fref)
					)
					AND p18n_idioma = 'es_ES'
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
							AND esdt_fref BETWEEN prvr_fini AND COALESCE(prvr_ffin, esdt_fref)
					)
					AND esdt_tpdt_pk = tppr_tpdt_pk
			)
		END
	) AS p18n_texto
FROM vw_estadistica_dato_esdt
WHERE esdt_estd_pk = 1919026
;



