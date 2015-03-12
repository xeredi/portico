-- // 0 0 2 Facturacion Vistas
-- Migration SQL that makes the change goes here.
CREATE VIEW portico.vw_regla_inc_rgin AS
	SELECT *
	FROM
		portico.tbl_regla_inc_rgin
		INNER JOIN portico.tbl_regla_inc_version_rgiv ON
			rgiv_rgin_pk = rgin_pk
		INNER JOIN portico.tbl_regla_rgla ON
			rgla_pk = rgin_rgla2_pk
		INNER JOIN portico.tbl_regla_version_rglv ON
			rglv_rgla_pk = rgin_rgla2_pk
		INNER JOIN portico.tbl_entidad_enti ON
			enti_pk = rglv_enti_pk
\

GRANT SELECT ON portico.vw_regla_inc_rgin TO portico
\



CREATE VIEW portico.vw_factura_lin_fctl AS
	SELECT *
		, (
			SELECT SUM(fctd_importe_base)
			FROM portico.tbl_factura_det_fctd
			WHERE fctd_fctl_pk = fctl_pk
		) AS fctl_importe_base
		, (
			SELECT SUM(fctd_importe)
			FROM portico.tbl_factura_det_fctd
			WHERE fctd_fctl_pk = fctl_pk
		) AS fctl_importe
	FROM portico.tbl_factura_lin_fctl
		INNER JOIN portico.tbl_regla_rgla ON
			rgla_pk = fctl_rgla_pk
		INNER JOIN portico.tbl_regla_version_rglv ON
			rglv_rgla_pk = fctl_rgla_pk
			AND EXISTS (
				SELECT 1
				FROM portico.tbl_factura_srv_fcts
				WHERE
					fcts_pk = fctl_fcts_pk
					AND fcts_fref BETWEEN rglv_fini AND COALESCE(rglv_ffin, fcts_fref)
			)
		INNER JOIN portico.tbl_parametro_prmt ON
			prmt_pk = fctl_impuesto_prmt_pk
		INNER JOIN portico.tbl_parametro_version_prvr ON
			prvr_prmt_pk = fctl_impuesto_prmt_pk
			AND EXISTS (
				SELECT 1
				FROM portico.tbl_factura_srv_fcts
				WHERE
					fcts_pk = fctl_fcts_pk
					AND fcts_fref BETWEEN prvr_fini AND COALESCE(prvr_ffin, fcts_fref)
			)
		LEFT JOIN portico.tbl_subservicio_ssrv ON
			ssrv_pk = fctl_ssrv_pk
\

GRANT SELECT ON portico.vw_factura_lin_fctl TO portico
\



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

DROP VIEW IF EXISTS portico.vw_regla_inc_rgin\
DROP VIEW IF EXISTS portico.vw_factura_det_fctd\
DROP VIEW IF EXISTS portico.vw_factura_lin_fctl\
