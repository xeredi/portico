-- // 0 0 2 Facturacion Vistas
-- Migration SQL that makes the change goes here.



CREATE VIEW portico.vw_valoracion_vlrc AS
	SELECT * 
		, (
			SELECT prmt_parametro
			FROM portico.tbl_parametro_prmt
			WHERE prmt_pk = vlrc_pagador_prmt_pk
		) AS vlrc_pagador_prmt_parametro
		, (
			SELECT prvr_pk
			FROM portico.tbl_parametro_version_prvr
			WHERE prvr_prmt_pk = vlrc_pagador_prmt_pk
				AND vlrc_fref BETWEEN prvr_fini AND COALESCE(prvr_ffin, vlrc_fref)
		) AS vlrc_pagador_prvr_pk
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
		, (SELECT prmt_parametro 
			FROM portico.tbl_parametro_prmt
			WHERE prmt_pk = vlrl_impuesto_prmt_pk) AS vlrl_impuesto_prmt_parametro
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
			SELECT SUM(vlrd_importe)
			FROM portico.tbl_valoracion_det_vlrd
			WHERE vlrd_vlrl_pk = vlrl_pk
		) AS vlrl_importe
	FROM 
		portico.tbl_valoracion_lin_vlrl
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
		LEFT JOIN portico.tbl_subservicio_ssrv ON
			ssrv_pk = vlrl_ssrv_pk
\

GRANT SELECT ON portico.vw_valoracion_lin_vlrl TO portico
\



CREATE VIEW portico.vw_valoracion_det_vlrd AS
	SELECT * 
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









-- //@UNDO
-- SQL to undo the change goes here.

DROP VIEW portico.vw_valoracion_cargo_vlrg
\
DROP VIEW portico.vw_valoracion_det_vlrd
\
DROP VIEW portico.vw_valoracion_lin_vlrl
\
DROP VIEW portico.vw_valoracion_vlrc
\
