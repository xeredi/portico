INSERT INTO portico.tbl_parametro_prmt(prmt_pk, prmt_tppr_pk, prmt_parametro) VALUES (
	(SELECT MAX(prmt_pk) FROM portico.tbl_parametro_prmt) + 1
	, portico.getEntidad('TIPO_ATRAQUE_EDI')
	, 'AXM'
);

INSERT INTO portico.tbl_parametro_version_prvr(prvr_pk, prvr_prmt_pk, prvr_fini, prvr_ffin) VALUES (
	(SELECT MAX(prvr_pk) FROM portico.tbl_parametro_version_prvr) + 1
	, (SELECT MAX(prmt_pk) FROM portico.tbl_parametro_prmt)
	, '2000-01-01'
	, null
);
