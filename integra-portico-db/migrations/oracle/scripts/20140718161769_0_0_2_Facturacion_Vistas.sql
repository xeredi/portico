-- // 0 0 2 Facturacion Vistas
-- Migration SQL that makes the change goes here.
CREATE VIEW vw_factura_det_fctd AS
	select *
	FROM
		tbl_factura_det_fctd
		LEFT JOIN tbl_subservicio_ssrv ON
			ssrv_pk = fctd_ssrv_pk
\

CREATE OR REPLACE SYNONYM portico.vw_factura_det_fctd FOR vw_factura_det_fctd\

GRANT SELECT ON vw_factura_det_fctd TO portico\





-- //@UNDO
-- SQL to undo the change goes here.

DROP VIEW vw_factura_det_fctd\
