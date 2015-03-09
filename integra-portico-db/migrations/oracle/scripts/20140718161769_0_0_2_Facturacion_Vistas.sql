-- // 0 0 2 Facturacion Vistas
-- Migration SQL that makes the change goes here.




CREATE VIEW vw_cargo_crgo AS
	SELECT *
	FROM
		tbl_cargo_crgo
		INNER JOIN tbl_cargo_version_crgv ON
			crgv_crgo_pk = crgo_pk
		INNER JOIN tbl_entidad_enti ON
			enti_pk = crgo_tpsr_pk
\

CREATE OR REPLACE SYNONYM portico.vw_cargo_crgo FOR vw_cargo_crgo\

GRANT SELECT ON vw_cargo_crgo TO portico\



CREATE VIEW vw_regla_rgla AS
	SELECT *
	FROM
		tbl_regla_rgla
		INNER JOIN tbl_regla_version_rglv ON
			rglv_rgla_pk = rgla_pk
		INNER JOIN tbl_cargo_crgo ON
			crgo_pk = rgla_crgo_pk
		INNER JOIN tbl_entidad_enti ON
			enti_pk = rglv_enti_pk
\

CREATE OR REPLACE SYNONYM portico.vw_regla_rgla FOR vw_regla_rgla\

GRANT SELECT ON vw_regla_rgla TO portico\



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



CREATE VIEW vw_aspecto_aspc AS
	SELECT *
	FROM
		tbl_aspecto_aspc
		JOIN tbl_aspecto_version_aspv ON
			aspv_aspc_pk = aspc_pk
		JOIN tbl_entidad_enti ON
			enti_pk = aspc_tpsr_pk
\

CREATE OR REPLACE SYNONYM portico.vw_aspecto_aspc FOR vw_aspecto_aspc\

GRANT SELECT ON vw_aspecto_aspc TO portico\



CREATE VIEW vw_aspecto_cargo_ascr AS
	SELECT *
	FROM
		tbl_aspecto_cargo_ascr
		INNER JOIN tbl_aspecto_cargo_version_ascv ON
			ascv_ascr_pk = ascr_pk
		INNER JOIN tbl_cargo_crgo ON
			crgo_pk = ascr_crgo_pk
		INNER JOIN tbl_cargo_version_crgv ON
			crgv_crgo_pk = ascr_crgo_pk
\

CREATE OR REPLACE SYNONYM portico.vw_aspecto_cargo_ascr FOR vw_aspecto_cargo_ascr\

GRANT SELECT ON vw_aspecto_cargo_ascr TO portico\



CREATE VIEW vw_valoracion_det_vlrd AS
	SELECT vlrd.*, ssrv.*
		, (
			SELECT vlrc_fref
			FROM tbl_valoracion_vlrc
			WHERE vlrc_pk = vlrd_vlrc_pk
		) AS vlrd_fref
	FROM tbl_valoracion_det_vlrd vlrd
		LEFT JOIN tbl_subservicio_ssrv ssrv ON
			ssrv_pk = vlrd_ssrv_pk
\

CREATE OR REPLACE SYNONYM portico.vw_valoracion_det_vlrd FOR vw_valoracion_det_vlrd\

GRANT SELECT ON vw_valoracion_det_vlrd TO portico\





CREATE VIEW vw_factura_fctr AS
	SELECT fctr.*, prmt.*, aspc.*, aspv.*, fcsr.*
		, (
			SELECT prvr_pk
			FROM tbl_parametro_version_prvr
			WHERE prvr_prmt_pk = fctr_pagador_prmt_pk
				AND fctr_fref BETWEEN prvr_fini AND COALESCE(prvr_ffin, fctr_fref)
		) AS prvr_pk
		, (
			SELECT SUM(fcti_importe)
			FROM tbl_factura_imp_fcti
			WHERE fcti_fctr_pk = fctr_pk
		) AS fctr_importe
		, (
			SELECT SUM(fcti_impuesto)
			FROM tbl_factura_imp_fcti
			WHERE fcti_fctr_pk = fctr_pk
		) AS fctr_impuesto
	FROM
		tbl_factura_fctr fctr
		INNER JOIN tbl_parametro_prmt prmt ON
			prmt_pk = fctr_pagador_prmt_pk
		INNER JOIN tbl_aspecto_aspc aspc on
			aspc_pk = fctr_aspc_pk
		INNER JOIN tbl_aspecto_version_aspv aspv on
			aspv_aspc_pk = fctr_aspc_pk
			AND fctr_fref BETWEEN aspv_fini AND COALESCE(aspv_ffin, fctr_fref)
		INNER JOIN tbl_factura_serie_fcsr fcsr on
			fcsr_pk = fctr_fcsr_pk
\

CREATE OR REPLACE SYNONYM portico.vw_factura_fctr FOR vw_factura_fctr\

GRANT SELECT ON vw_factura_fctr TO portico\



CREATE VIEW vw_factura_cargo_fctc AS
	SELECT *
	FROM
		tbl_factura_cargo_fctc
		INNER JOIN tbl_cargo_crgo ON
			crgo_pk = fctc_crgo_pk
		INNER JOIN tbl_cargo_version_crgv ON
			crgv_crgo_pk = fctc_crgo_pk
			AND EXISTS (
				SELECT 1
				FROM tbl_factura_fctr
				WHERE
					fctr_pk = fctc_fctr_pk
					AND fctr_fref BETWEEN crgv_fini AND COALESCE(crgv_ffin, fctr_fref)
			)
\

CREATE OR REPLACE SYNONYM portico.vw_factura_cargo_fctc FOR vw_factura_cargo_fctc\

GRANT SELECT ON vw_factura_cargo_fctc TO portico\



CREATE VIEW vw_factura_imp_fcti AS
	SELECT *
	FROM tbl_factura_imp_fcti
		JOIN tbl_parametro_prmt ON
			prmt_pk = fcti_impuesto_prmt_pk
		JOIN tbl_parametro_version_prvr ON
			prvr_prmt_pk = fcti_impuesto_prmt_pk
			AND EXISTS (
				SELECT 1
				FROM tbl_factura_fctr
				WHERE
					fctr_pk = fcti_fctr_pk
					AND fctr_fref BETWEEN prvr_fini AND COALESCE(prvr_ffin, fctr_fref)
			)
\

CREATE OR REPLACE SYNONYM portico.vw_factura_imp_fcti FOR vw_factura_imp_fcti\

GRANT SELECT ON vw_factura_imp_fcti TO portico\



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

DROP VIEW vw_aspecto_cargo_ascr\
DROP VIEW vw_aspecto_aspc\
DROP VIEW vw_cargo_crgo\
DROP VIEW vw_regla_rgla\
DROP VIEW vw_regla_inc_rgin\
DROP VIEW vw_factura_det_fctd\
DROP VIEW vw_factura_lin_fctl\
DROP VIEW vw_factura_srv_fcts\
DROP VIEW vw_factura_imp_fcti\
DROP VIEW vw_factura_cargo_fctc\
DROP VIEW vw_factura_fctr\
DROP VIEW vw_valoracion_det_vlrd\
