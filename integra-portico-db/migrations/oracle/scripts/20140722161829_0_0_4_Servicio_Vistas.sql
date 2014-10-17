-- // 0 0 4 Servicio Vistas.sql
-- Migration SQL that makes the change goes here.



CREATE VIEW vw_servicio_srvc AS
	SELECT *
	FROM
		tbl_servicio_srvc
		INNER JOIN tbl_parametro_prmt ON
			prmt_pk = srvc_subp_pk
\

CREATE OR REPLACE SYNONYM portico.vw_servicio_srvc FOR porticoadm.vw_servicio_srvc\

GRANT SELECT ON vw_servicio_srvc TO portico\



CREATE VIEW vw_subservicio_ssrv AS
	SELECT *
	FROM
		tbl_subservicio_ssrv
		INNER JOIN tbl_servicio_srvc ON
			srvc_pk = ssrv_srvc_pk
\

CREATE OR REPLACE SYNONYM portico.vw_subservicio_ssrv FOR porticoadm.vw_subservicio_ssrv\

GRANT SELECT ON vw_subservicio_ssrv TO portico\



CREATE VIEW vw_servicio_dato_srdt AS
	SELECT srdt.*, prmt.*, tppr.*, srvc.*
		, (
			SELECT srvc_fref
			FROM tbl_servicio_srvc
			WHERE srvc_pk = srdt_srvc_pk
		) AS srdt_fref
	FROM
		tbl_servicio_dato_srdt srdt
		LEFT JOIN tbl_parametro_prmt prmt ON
			prmt_pk = srdt_prmt_pk
		LEFT JOIN tbl_tipo_parametro_tppr tppr ON
			tppr_pk = prmt_tppr_pk
		LEFT JOIN tbl_servicio_srvc srvc ON
			srvc_pk = srdt_srvc_dep_pk
\

CREATE OR REPLACE SYNONYM portico.vw_servicio_dato_srdt FOR porticoadm.vw_servicio_dato_srdt\

GRANT SELECT ON vw_servicio_dato_srdt TO portico\



CREATE VIEW vw_subservicio_dato_ssdt AS
	SELECT ssdt.*, prmt.*, tppr.*
		, (
			SELECT srvc_fref
			FROM tbl_servicio_srvc
			WHERE srvc_pk = ANY (
				SELECT ssrv_srvc_pk
				FROM portico.tbl_subservicio_ssrv
				WHERE ssrv_pk = ssdt_ssrv_pk
			)
		) AS ssdt_fref
	FROM
		tbl_subservicio_dato_ssdt ssdt
		LEFT JOIN tbl_parametro_prmt prmt ON
			prmt_pk = ssdt_prmt_pk
		LEFT JOIN tbl_tipo_parametro_tppr tppr ON
			tppr_pk = prmt_tppr_pk
\

CREATE OR REPLACE SYNONYM portico.vw_subservicio_dato_ssdt FOR porticoadm.vw_subservicio_dato_ssdt\

GRANT SELECT ON vw_subservicio_dato_ssdt TO portico\













-- //@UNDO
-- SQL to undo the change goes here.

DROP VIEW vw_servicio_srvc\
DROP VIEW vw_subservicio_ssrv\
DROP VIEW vw_servicio_dato_srdt\
DROP VIEW vw_subservicio_dato_ssdt\
