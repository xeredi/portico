-- // 0 0 2 Facturacion Vistas
-- Migration SQL that makes the change goes here.
CREATE VIEW portico.vw_factura_det_fctd AS
	select *
	FROM
		portico.tbl_factura_det_fctd
		LEFT JOIN portico.tbl_subservicio_ssrv ON
			ssrv_pk = fctd_ssrv_pk
\

GRANT SELECT ON portico.vw_factura_det_fctd TO portico
\





-- //@UNDO
-- SQL to undo the change goes here.
DROP VIEW IF EXISTS portico.vw_factura_det_fctd\
