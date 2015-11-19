-- Iniciar Servicio
SELECT srvc.*
	, CASE
		WHEN EXISTS (
			SELECT 1
			FROM tbl_subservicio_ssrv
			WHERE ssrv_srvc_pk = srvc_pk
				AND ssrv_tpss_pk = 22003
		)
		THEN 'I'
		ELSE 'S'
	END AS estado
FROM tbl_servicio_srvc srvc
WHERE
	1=1
--	AND srvc_pk = 1000075164
	AND srvc_tpsr_pk = 21002
	AND srvc_estado IN ('C', 'B')
;

-- Iniciar Subservicio
SELECT ssrv.*
FROM tbl_subservicio_ssrv ssrv
WHERE
	1=1
	AND (
		(ssrv_tpss_pk = 22003 and ssrv_estado IN ('C', 'B'))
		OR (ssrv_tpss_pk = 22004 and ssrv_estado IN ('B'))
		OR (ssrv_tpss_pk = 22005 and ssrv_estado IN ('B'))
	)
	AND EXISTS (
		SELECT 1
		FROM tbl_subservicio_subservicio_ssss
		WHERE
			ssss_ssrvh_pk = ssrv_pk
			AND ssss_ssrvh_pk = 1000075237
	)
	and ssrv_srvc_pk = 1000075164
--	AND ssrv_pk = 1000075237
;

SELECT *
from tbl_tipo_subservicio_tpss
	JOIN tbl_entidad_enti ON
		enti_pk = tpss_pk
;






-- Recaulcular acuerdo BL

-- Propagar CodExen Partida
-- Se propaga al Bl y Manifiesto
SELECT ssdtPart
FROM tbl_subservicio_dato_ssdt ssdtPart
WHERE
	ssdtPart.ssdt_ssrv_pk = 1000406543
	AND ssdtPart.ssdt_tpdt_pk = 43000
;




