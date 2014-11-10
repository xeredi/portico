-- // 0 0 2 Facturacion Vistas
-- Migration SQL that makes the change goes here.




CREATE VIEW portico.vw_cargo_crgo AS
	SELECT *
	FROM
		portico.tbl_cargo_crgo
		INNER JOIN portico.tbl_cargo_version_crgv ON
			crgv_crgo_pk = crgo_pk
		INNER JOIN portico.tbl_entidad_enti ON
			enti_pk = crgo_tpsr_pk
\

GRANT SELECT ON portico.vw_cargo_crgo TO portico
\



CREATE VIEW portico.vw_regla_rgla AS
	SELECT *
	FROM
		portico.tbl_regla_rgla
		INNER JOIN portico.tbl_regla_version_rglv ON
			rglv_rgla_pk = rgla_pk
		INNER JOIN portico.tbl_cargo_crgo ON
			crgo_pk = rgla_crgo_pk
		INNER JOIN portico.tbl_entidad_enti ON
			enti_pk = rglv_enti_pk
\

GRANT SELECT ON portico.vw_regla_rgla TO portico
\



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



CREATE VIEW portico.vw_aspecto_aspc AS
	SELECT *
	FROM
		portico.tbl_aspecto_aspc
		JOIN portico.tbl_aspecto_version_aspv ON
			aspv_aspc_pk = aspc_pk
		JOIN portico.tbl_entidad_enti ON
			enti_pk = aspc_tpsr_pk
\

GRANT SELECT ON portico.vw_aspecto_aspc TO portico
\



CREATE VIEW portico.vw_aspecto_cargo_ascr AS
	SELECT *
	FROM
		portico.tbl_aspecto_cargo_ascr
		INNER JOIN portico.tbl_aspecto_cargo_version_ascv ON
			ascv_ascr_pk = ascr_pk
		INNER JOIN portico.tbl_cargo_crgo ON
			crgo_pk = ascr_crgo_pk
		INNER JOIN portico.tbl_cargo_version_crgv ON
			crgv_crgo_pk = ascr_crgo_pk
\

GRANT SELECT ON portico.vw_aspecto_cargo_ascr TO portico
\



CREATE VIEW portico.vw_valoracion_vlrc AS
	SELECT *
		, (
			SELECT prvr_pk
			FROM portico.tbl_parametro_version_prvr
			WHERE prvr_prmt_pk = vlrc_pagador_prmt_pk
				AND vlrc_fref BETWEEN prvr_fini AND COALESCE(prvr_ffin, vlrc_fref)
		) AS prvr_pk
		, (
			SELECT SUM(vlri_importe)
			FROM portico.tbl_valoracion_imp_vlri
			WHERE vlri_vlrc_pk = vlrc_pk
		) AS vlrc_importe
		, (
			SELECT SUM(vlri_impuesto)
			FROM portico.tbl_valoracion_imp_vlri
			WHERE vlri_vlrc_pk = vlrc_pk
		) AS vlrc_impuesto
	FROM
		portico.tbl_valoracion_vlrc
		INNER JOIN portico.tbl_servicio_srvc ON
			srvc_pk = vlrc_srvc_pk
		INNER JOIN portico.tbl_parametro_prmt ON
			prmt_pk = vlrc_pagador_prmt_pk
		INNER JOIN portico.tbl_aspecto_aspc ON
			aspc_pk = vlrc_aspc_pk
		INNER JOIN portico.tbl_aspecto_version_aspv ON
			aspv_aspc_pk = aspc_pk
			AND vlrc_fref BETWEEN aspv_fini AND COALESCE(aspv_ffin, vlrc_fref)
		INNER JOIN portico.tbl_entidad_enti ON
			enti_pk = srvc_tpsr_pk
\

GRANT SELECT ON portico.vw_valoracion_vlrc TO portico
\



CREATE VIEW portico.vw_valoracion_lin_vlrl AS
	SELECT *
		, (SELECT prvr_pk
			FROM portico.tbl_parametro_version_prvr
			WHERE prvr_prmt_pk = vlrl_impuesto_prmt_pk
				AND EXISTS (
					SELECT 1
					FROM portico.tbl_valoracion_vlrc
					WHERE vlrc_pk = vlrl_vlrc_pk
						AND vlrc_fref BETWEEN prvr_fini AND COALESCE(prvr_ffin, vlrc_fref)
				)
		) AS vlrl_impuesto_prvr_pk
		, (
			SELECT SUM(vlrd_importe_base)
			FROM portico.tbl_valoracion_det_vlrd
			WHERE vlrd_vlrl_pk = vlrl_pk
		) AS vlrl_importe_base
		, (
			SELECT SUM(vlrd_importe)
			FROM portico.tbl_valoracion_det_vlrd
			WHERE vlrd_vlrl_pk = vlrl_pk
		) AS vlrl_importe
		, (
			SELECT vlrc_fref
			FROM portico.tbl_valoracion_vlrc
			WHERE vlrc_pk = vlrl_vlrc_pk
		) AS vlrl_fref
	FROM
		portico.tbl_valoracion_lin_vlrl
		INNER JOIN portico.tbl_parametro_prmt ON
			prmt_pk = vlrl_impuesto_prmt_pk
		INNER JOIN portico.tbl_regla_rgla ON
			rgla_pk = vlrl_rgla_pk
		INNER JOIN portico.tbl_regla_version_rglv ON
			rglv_rgla_pk = vlrl_rgla_pk
			AND EXISTS (
				SELECT 1
				FROM portico.tbl_valoracion_vlrc
				WHERE vlrc_pk = vlrl_vlrc_pk
					AND vlrc_fref BETWEEN rglv_fini AND COALESCE(rglv_ffin, vlrc_fref)
			)
		INNER JOIN portico.tbl_entidad_enti ON
			enti_pk = rglv_enti_pk
		LEFT JOIN portico.tbl_subservicio_ssrv ON
			ssrv_pk = vlrl_ssrv_pk
\

GRANT SELECT ON portico.vw_valoracion_lin_vlrl TO portico
\



CREATE VIEW portico.vw_valoracion_det_vlrd AS
	SELECT *
		, (
			SELECT vlrc_fref
			FROM portico.tbl_valoracion_vlrc
			WHERE vlrc_pk = vlrd_vlrc_pk
		) AS vlrd_fref
	FROM portico.tbl_valoracion_det_vlrd
		LEFT JOIN portico.tbl_subservicio_ssrv ON
			ssrv_pk = vlrd_ssrv_pk
\

GRANT SELECT ON portico.vw_valoracion_det_vlrd TO portico
\



CREATE VIEW portico.vw_valoracion_cargo_vlrg AS
	SELECT *
	FROM portico.tbl_valoracion_cargo_vlrg
		INNER JOIN portico.tbl_cargo_crgo ON
			crgo_pk = vlrg_crgo_pk
		INNER JOIN portico.tbl_cargo_version_crgv ON
			crgv_crgo_pk = vlrg_crgo_pk
			AND EXISTS (
				SELECT 1
				FROM portico.tbl_valoracion_vlrc
				WHERE
					vlrc_pk = vlrg_vlrc_pk
					AND vlrc_fref BETWEEN crgv_fini AND COALESCE(crgv_ffin, vlrc_fref)
			)
\

GRANT SELECT ON portico.vw_valoracion_cargo_vlrg TO portico
\



CREATE VIEW portico.vw_valoracion_imp_vlri AS
	SELECT *
	FROM portico.tbl_valoracion_imp_vlri
		INNER JOIN portico.tbl_parametro_prmt ON
			prmt_pk = vlri_impuesto_prmt_pk
		JOIN portico.tbl_parametro_version_prvr ON
			prvr_prmt_pk = vlri_impuesto_prmt_pk
			AND EXISTS (
				SELECT 1
				FROM portico.tbl_valoracion_vlrc
				WHERE
					vlrc_pk = vlri_vlrc_pk
					AND vlrc_fref BETWEEN prvr_fini AND COALESCE(prvr_ffin, vlrc_fref)
			)
\

GRANT SELECT ON portico.vw_valoracion_imp_vlri TO portico
\



CREATE VIEW portico.vw_factura_fctr AS
	SELECT *
		, (
			SELECT prvr_pk
			FROM portico.tbl_parametro_version_prvr
			WHERE prvr_prmt_pk = fctr_pagador_prmt_pk
				AND fctr_fref BETWEEN prvr_fini AND COALESCE(prvr_ffin, fctr_fref)
		) AS prvr_pk
		, (
			SELECT SUM(fcti_importe)
			FROM portico.tbl_factura_imp_fcti
			WHERE fcti_fctr_pk = fctr_pk
		) AS fctr_importe
		, (
			SELECT SUM(fcti_impuesto)
			FROM portico.tbl_factura_imp_fcti
			WHERE fcti_fctr_pk = fctr_pk
		) AS fctr_impuesto
	FROM
		portico.tbl_factura_fctr
		INNER JOIN portico.tbl_parametro_prmt ON
			prmt_pk = fctr_pagador_prmt_pk
		INNER JOIN portico.tbl_aspecto_aspc on
			aspc_pk = fctr_aspc_pk
		INNER JOIN portico.tbl_aspecto_version_aspv on
			aspv_aspc_pk = fctr_aspc_pk
			AND fctr_fref BETWEEN aspv_fini AND COALESCE(aspv_ffin, fctr_fref)
		INNER JOIN portico.tbl_factura_serie_fcsr on
			fcsr_pk = fctr_fcsr_pk
\

GRANT SELECT ON portico.vw_factura_fctr TO portico
\



CREATE VIEW portico.vw_factura_cargo_fctc AS
	SELECT *
	FROM
		portico.tbl_factura_cargo_fctc
		INNER JOIN portico.tbl_cargo_crgo ON
			crgo_pk = fctc_crgo_pk
		INNER JOIN portico.tbl_cargo_version_crgv ON
			crgv_crgo_pk = fctc_crgo_pk
			AND EXISTS (
				SELECT 1
				FROM portico.tbl_factura_fctr
				WHERE
					fctr_pk = fctc_fctr_pk
					AND fctr_fref BETWEEN crgv_fini AND COALESCE(crgv_ffin, fctr_fref)
			)
\

GRANT SELECT ON portico.vw_factura_cargo_fctc TO portico
\



CREATE VIEW portico.vw_factura_imp_fcti AS
	SELECT *
	FROM portico.tbl_factura_imp_fcti
		JOIN portico.tbl_parametro_prmt ON
			prmt_pk = fcti_impuesto_prmt_pk
		JOIN portico.tbl_parametro_version_prvr ON
			prvr_prmt_pk = fcti_impuesto_prmt_pk
			AND EXISTS (
				SELECT 1
				FROM portico.tbl_factura_fctr
				WHERE
					fctr_pk = fcti_fctr_pk
					AND fctr_fref BETWEEN prvr_fini AND COALESCE(prvr_ffin, fctr_fref)
			)
\

GRANT SELECT ON portico.vw_factura_imp_fcti TO portico
\



CREATE VIEW portico.vw_factura_srv_fcts AS
	SELECT *
		, (
			SELECT prmt_parametro
			FROM portico.tbl_parametro_prmt
			WHERE prmt_pk = srvc_subp_pk
		) AS srvc_subp
	FROM
		portico.tbl_factura_srv_fcts
		INNER JOIN portico.tbl_aspecto_aspc ON
			aspc_pk = fcts_aspc_pk
		INNER JOIN portico.tbl_aspecto_version_aspv ON
			aspv_aspc_pk = fcts_aspc_pk
			AND fcts_fref BETWEEN aspv_fini AND COALESCE(aspv_ffin, fcts_fref)
		INNER JOIN portico.tbl_servicio_srvc ON
			srvc_pk = fcts_srvc_pk
\

GRANT SELECT ON portico.vw_factura_srv_fcts TO portico
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

DROP VIEW IF EXISTS portico.vw_aspecto_cargo_ascr\
DROP VIEW IF EXISTS portico.vw_aspecto_aspc\
DROP VIEW IF EXISTS portico.vw_cargo_crgo\
DROP VIEW IF EXISTS portico.vw_regla_rgla\
DROP VIEW IF EXISTS portico.vw_regla_inc_rgin\
DROP VIEW IF EXISTS portico.vw_factura_det_fctd\
DROP VIEW IF EXISTS portico.vw_factura_lin_fctl\
DROP VIEW IF EXISTS portico.vw_factura_srv_fcts\
DROP VIEW IF EXISTS portico.vw_factura_imp_fcti\
DROP VIEW IF EXISTS portico.vw_factura_cargo_fctc\
DROP VIEW IF EXISTS portico.vw_factura_fctr\
DROP VIEW IF EXISTS portico.vw_valoracion_imp_vlri\
DROP VIEW IF EXISTS portico.vw_valoracion_cargo_vlrg\
DROP VIEW IF EXISTS portico.vw_valoracion_det_vlrd\
DROP VIEW IF EXISTS portico.vw_valoracion_lin_vlrl\
DROP VIEW IF EXISTS portico.vw_valoracion_vlrc\
