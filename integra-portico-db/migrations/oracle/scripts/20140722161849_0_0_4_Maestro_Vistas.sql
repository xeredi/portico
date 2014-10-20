-- // 0 0 4 Maestro Vistas.sql
-- Migration SQL that makes the change goes here.


CREATE VIEW vw_parametro_prmt AS
	SELECT *
	FROM
		tbl_parametro_prmt
		INNER JOIN tbl_parametro_version_prvr ON
			prvr_prmt_pk = prmt_pk
		INNER JOIN tbl_tipo_parametro_tppr ON
			tppr_pk = prmt_tppr_pk
\

CREATE OR REPLACE SYNONYM portico.vw_parametro_prmt FOR porticoadm.vw_parametro_prmt\

GRANT SELECT ON vw_parametro_prmt TO portico\



CREATE VIEW vw_parametro_dato_prdt AS
	SELECT *
	FROM
		tbl_parametro_dato_prdt
		LEFT JOIN tbl_parametro_prmt ON
			prdt_prmt_pk = prmt_pk
		LEFT JOIN tbl_tipo_parametro_tppr ON
			tppr_pk = prmt_tppr_pk
\

CREATE OR REPLACE SYNONYM portico.vw_parametro_dato_prdt FOR porticoadm.vw_parametro_dato_prdt\

GRANT SELECT ON vw_parametro_dato_prdt TO portico\



CREATE VIEW vw_subparametro_sprm AS
	SELECT *
	FROM tbl_subparametro_sprm
		INNER JOIN tbl_subparametro_version_spvr ON
			spvr_sprm_pk = sprm_pk
		INNER JOIN tbl_parametro_prmt ON
			prmt_pk = sprm_prmt_dep_pk
		INNER JOIN tbl_tipo_parametro_tppr ON
			tppr_pk = prmt_tppr_pk
\

CREATE OR REPLACE SYNONYM portico.vw_subparametro_sprm FOR porticoadm.vw_subparametro_sprm\

GRANT SELECT ON vw_subparametro_sprm TO portico\



CREATE VIEW vw_subparametro_dato_spdt AS
	SELECT *
	FROM
		tbl_subparametro_dato_spdt
		LEFT JOIN tbl_parametro_prmt ON
			prmt_pk = spdt_prmt_pk
		LEFT JOIN tbl_tipo_parametro_tppr ON
			tppr_pk = prmt_tppr_pk
\

CREATE OR REPLACE SYNONYM portico.vw_subparametro_dato_spdt FOR porticoadm.vw_subparametro_dato_spdt\

GRANT SELECT ON vw_subparametro_dato_spdt TO portico\





















-- //@UNDO
-- SQL to undo the change goes here.

DROP VIEW vw_subparametro_dato_spdt\
DROP VIEW vw_subparametro_sprm\
DROP VIEW vw_parametro_prmt\
DROP VIEW vw_parametro_dato_prdt\