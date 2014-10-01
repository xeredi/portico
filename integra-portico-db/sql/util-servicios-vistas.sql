SELECT * FROM vw_servicio_srvc;
SELECT * FROM vw_subservicio_ssrv;
SELECT * 
FROM vw_servicio_dato_srdt
WHERE srdt_srvc_pk = 1819001
;







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
							AND srdt_fref BETWEEN prvr_fini AND COALESCE(prvr_ffin, srdt_fref)
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
							prvr_prmt_pk = srdt_prmt_pk
							AND srdt_fref BETWEEN prvr_fini AND COALESCE(prvr_ffin, srdt_fref)
					)
					AND prdt_tpdt_pk = tppr_tpdt_pk
			)
		END
	) AS p18n_texto
FROM vw_estadistica_dato_esdt
WHERE srdt_srvc_pk = 1819001
;



