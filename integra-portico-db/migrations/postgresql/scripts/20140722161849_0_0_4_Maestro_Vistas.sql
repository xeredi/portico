-- // 0 0 4 Maestro Vistas.sql
-- Migration SQL that makes the change goes here.


CREATE VIEW portico.vw_subparametro_sprm AS
	SELECT *
	FROM portico.tbl_subparametro_sprm
		INNER JOIN portico.tbl_subparametro_version_spvr ON
			spvr_sprm_pk = sprm_pk
		INNER JOIN portico.tbl_parametro_prmt ON
			prmt_pk = sprm_prmt_dep_pk
		INNER JOIN portico.tbl_tipo_parametro_tppr ON
			tppr_pk = prmt_tppr_pk
\

GRANT SELECT ON portico.vw_subparametro_sprm TO portico
\



CREATE VIEW portico.vw_subparametro_dato_spdt AS
	SELECT *
	FROM
		portico.tbl_subparametro_dato_spdt
		LEFT JOIN portico.tbl_parametro_prmt ON
			prmt_pk = spdt_prmt_pk
		LEFT JOIN portico.tbl_tipo_parametro_tppr ON
			tppr_pk = prmt_tppr_pk
\

GRANT SELECT ON portico.vw_subparametro_dato_spdt TO portico\
















-- //@UNDO
-- SQL to undo the change goes here.

DROP VIEW portico.vw_subparametro_dato_spdt\
DROP VIEW portico.vw_subparametro_sprm\
