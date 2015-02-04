SELECT *
FROM tbl_subservicio_ssrv
WHERE ssrv_srvc_pk = 4401553;


-- Recalcular manifiesto pesca
SELECT *
	, COALESCE(
		(
			SELECT SUM(COALESCE(ssdt_ndecimal, 0))
			FROM tbl_subservicio_dato_ssdt
			WHERE
				EXISTS (
					SELECT 1
					FROM tbl_subservicio_ssrv
					WHERE 
						ssrv_pk = ssdt_ssrv_pk
						AND ssrv_srvc_pk = srdt_srvc_pk 
						AND ssrv_tpss_pk = portico.getEntidad('PARTIDA_PESCA')
				)
				AND ssdt_tpdt_pk = portico.getTipoDato('DECIMAL_04')
		)
	, 0)
FROM 
	tbl_servicio_dato_srdt
WHERE
	EXISTS (
		SELECT 1
		FROM tbl_servicio_srvc
		WHERE 
			srvc_pk = srdt_srvc_pk
			AND srvc_tpsr_pk = portico.getEntidad('MANIFIESTO_PESCA')
	)
	AND srdt_tpdt_pk = portico.getTipoDato('DECIMAL_02')
	AND srdt_srvc_pk = 1231635
;

-- Recalcular partida de pesca
SELECT *
FROM 
	tbl_subservicio_dato_ssdt
WHERE 
	EXISTS (
		SELECT 1
		FROM 
			tbl_subservicio_ssrv
		WHERE 
			ssrv_pk = ssdt_ssrv_pk
			AND ssrv_tpss_pk = portico.getEntidad('PARTIDA_PESCA')
	)
	AND ssdt_ssrv_pk = 1231670
;


-- Recalcular Estado BL

SELECT *
	, COALESCE (
		(
			WITH 
				hijosBL AS (
					SELECT DISTINCT ssrv_estado
					FROM tbl_subservicio_ssrv ssrvHijoBl
					WHERE 
						ssrvHijoBl.ssrv_tpss_pk IN (portico.getEntidad('PARTIDA'), portico.getEntidad('EQUIPAMIENTO'))
						AND EXISTS (
							SELECT 1 
							FROM tbl_subserv_subserv_ssss
							WHERE ssss_ssrvh_pk = ssrvHijoBl.ssrv_pk
								AND ssss_ssrvp_pk = ssrvBl.ssrv_pk
						)
				)
			SELECT 
				CASE 
					WHEN NOT EXISTS (
						SELECT ssrv_estado FROM hijosBL
					)
					THEN 'S'

					WHEN 'B' = ANY (SELECT ssrv_estado FROM hijosBL) 
					THEN 'B'

					WHEN 'A' = ALL (SELECT ssrv_estado FROM hijosBL) 
					THEN 'A'

					ELSE 'I'
				END
			FROM hijosBL
		)
		, 'S'
	) AS nuevoEstado
FROM tbl_subservicio_ssrv ssrvBl
WHERE
	ssrv_tpss_pk = portico.getEntidad('BL')
--	AND ssrv_srvc_pk = 1231814
--	AND ssrv_pk = 1232111
	AND ssrv_estado IS NOT NULL
LIMIT 10000
;

SELECT *
	, (

	)
FROM tbl_subservicio_ssrv
WHERE 
	ssrv_tpss_pk = portico.getEntidad('BL')
	AND ssrv_srvc_pk = 4433329
;

WITH 
	hijosBL AS (
		SELECT DISTINCT ssrv_estado
		FROM tbl_subservicio_ssrv 
		WHERE 
			ssrv_tpss_pk IN (portico.getEntidad('PARTIDA'), portico.getEntidad('EQUIPAMIENTO'))
			AND EXISTS (
				SELECT 1 
				FROM tbl_subserv_subserv_ssss
				WHERE ssss_ssrvh_pk = ssrv_pk
					AND ssss_ssrvp_pk = 4435847
			)
	)
SELECT 
	CASE 
		WHEN NOT EXISTS (
			SELECT ssrv_estado FROM hijosBL
		)
		THEN 'S'

		WHEN 'B' = ANY (SELECT ssrv_estado FROM hijosBL) 
		THEN 'B'

		WHEN 'A' = ALL (SELECT ssrv_estado FROM hijosBL) 
		THEN 'A'

		ELSE 'R'
	END
FROM hijosBL;

	
	