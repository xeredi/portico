-- // 0 0 4 Estadistica Vistas.sql
-- Migration SQL that makes the change goes here.


CREATE VIEW portico.vw_estadistica_estd AS
	SELECT *
	FROM
		portico.tbl_estadistica_estd
		INNER JOIN portico.tbl_periodo_proceso_pepr ON
			pepr_pk = estd_pepr_pk
		INNER JOIN portico.tbl_parametro_prmt ON
			prmt_pk = estd_subp_pk
\

GRANT SELECT ON portico.vw_estadistica_estd TO portico
\



CREATE VIEW portico.vw_estadistica_dato_esdt AS
	SELECT *
		, (
			SELECT pepr_freferencia
			FROM portico.tbl_periodo_proceso_pepr
			WHERE pepr_pk = ANY (
				SELECT estd_pepr_pk
				FROM portico.tbl_estadistica_estd
				WHERE estd_pk = esdt_estd_pk
			)
		) AS esdt_fref
	FROM
		portico.tbl_estadistica_dato_esdt
		LEFT JOIN portico.tbl_parametro_prmt ON
			prmt_pk = esdt_prmt_pk
		LEFT JOIN portico.tbl_tipo_parametro_tppr ON
			tppr_pk = prmt_tppr_pk
\

GRANT SELECT ON portico.vw_estadistica_dato_esdt TO portico
\













-- //@UNDO
-- SQL to undo the change goes here.

DROP VIEW portico.vw_estadistica_estd\
DROP VIEW portico.vw_estadistica_dato_esdt\
