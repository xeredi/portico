-- // 0 0 4 Maestro Vistas.sql
-- Migration SQL that makes the change goes here.


CREATE VIEW portico.vw_parametro_prmt AS
	SELECT *
	FROM
		portico.tbl_parametro_prmt
		INNER JOIN portico.tbl_parametro_version_prvr ON
			prvr_prmt_pk = prmt_pk
		INNER JOIN portico.tbl_tipo_parametro_tppr ON
			tppr_pk = prmt_tppr_pk
;

GRANT SELECT ON portico.vw_parametro_prmt TO portico
;



CREATE VIEW portico.vw_parametro_dato_prdt AS
	SELECT *
	FROM
		portico.tbl_parametro_dato_prdt
		LEFT JOIN portico.tbl_parametro_prmt ON
			prdt_prmt_pk = prmt_pk
		LEFT JOIN portico.tbl_tipo_parametro_tppr ON
			tppr_pk = prmt_tppr_pk
;

GRANT SELECT ON portico.vw_parametro_dato_prdt TO portico
;



CREATE VIEW portico.vw_subparametro_sprm AS
	SELECT *
	FROM portico.tbl_subparametro_sprm
		INNER JOIN portico.tbl_subparametro_version_spvr ON
			spvr_sprm_pk = sprm_pk
		INNER JOIN portico.tbl_parametro_prmt ON
			prmt_pk = sprm_prmt_dep_pk
		INNER JOIN portico.tbl_tipo_parametro_tppr ON
			tppr_pk = prmt_tppr_pk
;

GRANT SELECT ON portico.vw_subparametro_sprm TO portico
;



CREATE VIEW portico.vw_subparametro_dato_spdt AS
	SELECT *
	FROM
		portico.tbl_subparametro_dato_spdt
		LEFT JOIN portico.tbl_parametro_prmt ON
			prmt_pk = spdt_prmt_pk
		LEFT JOIN portico.tbl_tipo_parametro_tppr ON
			tppr_pk = prmt_tppr_pk
;

GRANT SELECT ON portico.vw_subparametro_dato_spdt TO portico;
















-- //@UNDO
-- SQL to undo the change goes here.

DROP VIEW portico.vw_subparametro_dato_spdt;
DROP VIEW portico.vw_subparametro_sprm;
DROP VIEW portico.vw_parametro_prmt;
DROP VIEW portico.vw_parametro_dato_prdt;
