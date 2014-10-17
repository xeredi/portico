-- // 0 0 4 Estadistica Vistas.sql
-- Migration SQL that makes the change goes here.


CREATE VIEW vw_estadistica_estd AS
	SELECT *
	FROM
		tbl_estadistica_estd
		INNER JOIN tbl_periodo_proceso_pepr ON
			pepr_pk = estd_pepr_pk
		INNER JOIN tbl_parametro_prmt ON
			prmt_pk = estd_subp_pk
\

CREATE OR REPLACE SYNONYM portico.vw_estadistica_estd FOR porticoadm.vw_estadistica_estd\

GRANT SELECT ON vw_estadistica_estd TO portico\



CREATE VIEW vw_estadistica_dato_esdt AS
	SELECT esdt.*, prmt.*, tppr.*
		, (
			SELECT pepr_freferencia
			FROM tbl_periodo_proceso_pepr
			WHERE pepr_pk = ANY (
				SELECT estd_pepr_pk
				FROM tbl_estadistica_estd
				WHERE estd_pk = esdt_estd_pk
			)
		) AS esdt_fref
	FROM
		tbl_estadistica_dato_esdt esdt
		LEFT JOIN tbl_parametro_prmt prmt ON
			prmt_pk = esdt_prmt_pk
		LEFT JOIN tbl_tipo_parametro_tppr tppr ON
			tppr_pk = prmt_tppr_pk
\

CREATE OR REPLACE SYNONYM portico.vw_estadistica_dato_esdt FOR porticoadm.vw_estadistica_dato_esdt\

GRANT SELECT ON vw_estadistica_dato_esdt TO portico\













-- //@UNDO
-- SQL to undo the change goes here.

DROP VIEW vw_estadistica_estd\
DROP VIEW vw_estadistica_dato_esdt\
