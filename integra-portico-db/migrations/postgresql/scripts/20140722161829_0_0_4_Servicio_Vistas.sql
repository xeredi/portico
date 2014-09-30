-- // 0 0 4 Servicio Vistas.sql
-- Migration SQL that makes the change goes here.



CREATE VIEW portico.vw_servicio_srvc AS
	SELECT *
	FROM
		portico.tbl_servicio_srvc
		INNER JOIN portico.tbl_parametro_prmt ON
			prmt_pk = srvc_subp_pk
;

GRANT SELECT ON portico.vw_servicio_srvc TO portico
;



CREATE VIEW portico.vw_subservicio_ssrv AS
	SELECT *
	FROM
		portico.tbl_subservicio_ssrv
		INNER JOIN portico.tbl_servicio_srvc ON
			srvc_pk = ssrv_srvc_pk
;

GRANT SELECT ON portico.vw_subservicio_ssrv TO portico
;



CREATE VIEW portico.vw_servicio_dato_srdt AS
	SELECT *
		, (
			SELECT srvc_fref
			FROM portico.tbl_servicio_srvc
			WHERE srvc_pk = srdt_srvc_pk
		) AS srdt_fref
	FROM
		portico.tbl_servicio_dato_srdt
		LEFT JOIN portico.tbl_parametro_prmt ON
			prmt_pk = srdt_prmt_pk
		LEFT JOIN portico.tbl_tipo_parametro_tppr ON
			tppr_pk = prmt_tppr_pk
		LEFT JOIN portico.tbl_servicio_srvc ON
			srvc_pk = srdt_srvc_dep_pk
;

GRANT SELECT ON portico.vw_servicio_dato_srdt TO portico
;



CREATE VIEW portico.vw_subservicio_dato_ssdt AS
	SELECT *
		, (
			SELECT srvc_fref
			FROM portico.tbl_servicio_srvc
			WHERE srvc_pk = ANY (
				SELECT ssrv_srvc_pk
				FROM portico.tbl_subservicio_ssrv
				WHERE ssrv_pk = ssdt_ssrv_pk
			)
		) AS ssdt_fref
	FROM
		portico.tbl_subservicio_dato_ssdt
		LEFT JOIN portico.tbl_parametro_prmt ON
			prmt_pk = ssdt_prmt_pk
		LEFT JOIN portico.tbl_tipo_parametro_tppr ON
			tppr_pk = prmt_tppr_pk
;

GRANT SELECT ON portico.vw_subservicio_dato_ssdt TO portico
;













-- //@UNDO
-- SQL to undo the change goes here.

DROP VIEW portico.vw_servicio_srvc;
DROP VIEW portico.vw_subservicio_ssrv;
DROP VIEW portico.vw_servicio_dato_srdt;
DROP VIEW portico.vw_subservicio_dato_ssdt;
