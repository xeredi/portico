-- // 0 0 2 Facturacion Vistas
-- Migration SQL that makes the change goes here.



CREATE VIEW portico.vw_valoracion_vlrc
AS
	SELECT * 
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
	FROM portico.tbl_valoracion_vlrc
\

GRANT SELECT ON portico.vw_valoracion_vlrc TO portico
\



CREATE VIEW portico.vw_valoracion_lin_vlrl
AS
	SELECT * 
		, (
			SELECT SUM(vlrd_importe)
			FROM portico.tbl_valoracion_det_vlrd
			WHERE vlrd_vlrl_pk = vlrl_pk
		) AS vlrl_importe
	FROM portico.tbl_valoracion_lin_vlrl
\

GRANT SELECT ON portico.vw_valoracion_lin_vlrl TO portico
\









-- //@UNDO
-- SQL to undo the change goes here.


DROP VIEW portico.vw_valoracion_lin_vlrl
\
DROP VIEW portico.vw_valoracion_vlrc
\
