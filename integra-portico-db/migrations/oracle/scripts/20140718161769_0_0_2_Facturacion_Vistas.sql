-- // 0 0 2 Facturacion Vistas
-- Migration SQL that makes the change goes here.
CREATE VIEW vw_regla_inc_rgin AS
	SELECT *
	FROM
		tbl_regla_inc_rgin
		INNER JOIN tbl_regla_inc_version_rgiv ON
			rgiv_rgin_pk = rgin_pk
		INNER JOIN tbl_regla_rgla ON
			rgla_pk = rgin_rgla2_pk
		INNER JOIN tbl_regla_version_rglv ON
			rglv_rgla_pk = rgin_rgla2_pk
		INNER JOIN tbl_entidad_enti ON
			enti_pk = rglv_enti_pk
\

CREATE OR REPLACE SYNONYM portico.vw_regla_inc_rgin FOR vw_regla_inc_rgin\

GRANT SELECT ON vw_regla_inc_rgin TO portico\



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

DROP VIEW vw_regla_inc_rgin\
DROP VIEW vw_factura_det_fctd\
