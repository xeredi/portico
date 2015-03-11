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



CREATE VIEW vw_factura_srv_fcts AS
	SELECT fcts.*, aspc.*, aspv.*, srvc.*
		, (
			SELECT prmt_parametro
			FROM tbl_parametro_prmt
			WHERE prmt_pk = srvc_subp_pk
		) AS srvc_subp
	FROM
		tbl_factura_srv_fcts fcts
		INNER JOIN tbl_aspecto_aspc aspc ON
			aspc_pk = fcts_aspc_pk
		INNER JOIN tbl_aspecto_version_aspv aspv ON
			aspv_aspc_pk = fcts_aspc_pk
			AND fcts_fref BETWEEN aspv_fini AND COALESCE(aspv_ffin, fcts_fref)
		INNER JOIN tbl_servicio_srvc srvc ON
			srvc_pk = fcts_srvc_pk
\

CREATE OR REPLACE SYNONYM portico.vw_factura_srv_fcts FOR vw_factura_srv_fcts\

GRANT SELECT ON vw_factura_srv_fcts TO portico\



CREATE VIEW vw_factura_lin_fctl AS
	SELECT fctl.*, rgla.*, rglv.*, prmt.*, prvr.*, ssrv.*
		, (
			SELECT SUM(fctd_importe_base)
			FROM tbl_factura_det_fctd
			WHERE fctd_fctl_pk = fctl_pk
		) AS fctl_importe_base
		, (
			SELECT SUM(fctd_importe)
			FROM tbl_factura_det_fctd
			WHERE fctd_fctl_pk = fctl_pk
		) AS fctl_importe
	FROM tbl_factura_lin_fctl fctl
		INNER JOIN tbl_regla_rgla rgla ON
			rgla_pk = fctl_rgla_pk
		INNER JOIN tbl_regla_version_rglv rglv ON
			rglv_rgla_pk = fctl_rgla_pk
			AND EXISTS (
				SELECT 1
				FROM tbl_factura_srv_fcts
				WHERE
					fcts_pk = fctl_fcts_pk
					AND fcts_fref BETWEEN rglv_fini AND COALESCE(rglv_ffin, fcts_fref)
			)
		INNER JOIN tbl_parametro_prmt prmt ON
			prmt_pk = fctl_impuesto_prmt_pk
		INNER JOIN tbl_parametro_version_prvr prvr ON
			prvr_prmt_pk = fctl_impuesto_prmt_pk
			AND EXISTS (
				SELECT 1
				FROM tbl_factura_srv_fcts
				WHERE
					fcts_pk = fctl_fcts_pk
					AND fcts_fref BETWEEN prvr_fini AND COALESCE(prvr_ffin, fcts_fref)
			)
		LEFT JOIN tbl_subservicio_ssrv ssrv ON
			ssrv_pk = fctl_ssrv_pk
\

CREATE OR REPLACE SYNONYM portico.vw_factura_lin_fctl FOR vw_factura_lin_fctl\

GRANT SELECT ON vw_factura_lin_fctl TO portico\



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
DROP VIEW vw_factura_lin_fctl\
DROP VIEW vw_factura_srv_fcts\
