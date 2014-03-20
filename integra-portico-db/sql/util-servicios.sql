-- Borrado de servicios
DELETE FROM tbl_subservicio_subservicio_ssss;
-- DELETE FROM tbl_servicio_secuencia_srsc;
TRUNCATE TABLE tbl_subservicio_dato_ssdt;
DELETE FROM tbl_subservicio_ssrv;
TRUNCATE TABLE tbl_servicio_dato_srdt;
DELETE FROM tbl_servicio_srvc;

-- Resumen de servicios/subservicios
SELECT COUNT(1), ssrv_tpss_pk, enti_nombre
from tbl_subservicio_ssrv
	JOIN tbl_entidad_enti ON
		enti_pk = ssrv_tpss_pk
--WHERE ssrv_srvc_pk = 1841452
GROUP BY ssrv_tpss_pk, enti_nombre
ORDER BY enti_nombre
;

SELECT COUNT(1), srvc_tpsr_pk, enti_nombre
from tbl_servicio_srvc
	JOIN tbl_entidad_enti ON
		enti_pk = srvc_tpsr_pk
GROUP BY srvc_tpsr_pk, enti_nombre
ORDER BY enti_nombre
;
