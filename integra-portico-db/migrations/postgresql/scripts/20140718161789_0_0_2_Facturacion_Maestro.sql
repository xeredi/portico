-- // 0 0 2 Facturacion Maestro
-- Migration SQL that makes the change goes here.

INSERT INTO portico.tbl_cargo_crgo (crgo_pk, crgo_codigo, crgo_es_principal, crgo_tpsr_pk, crgo_tipo, crgo_descripcion) VALUES (60000, 'B5', 1, 21001, 'B', 'TASA DE PESCA FRESCA')
/
	INSERT INTO portico.tbl_cargo_version_crgv (crgv_pk, crgv_crgo_pk, crgv_fini, crgv_ffin) VALUES (62000, 60000, '2013-01-01', NULL);
	/
	INSERT INTO portico.tbl_regla_rgla (rgla_pk, rgla_crgo_pk, rgla_enti_pk, rgla_tipo, rgla_codigo) VALUES (63000, 60000, 22001, 'T', 'B5-10-0000');
	/
INSERT INTO portico.tbl_cargo_crgo (crgo_pk, crgo_codigo, crgo_es_principal, crgo_tpsr_pk, crgo_tipo, crgo_descripcion) VALUES (60001, 'B2', 1, 21002, 'B', 'TASA AL PASAJE')
/
	INSERT INTO portico.tbl_cargo_version_crgv (crgv_pk, crgv_crgo_pk, crgv_fini, crgv_ffin) VALUES (62001, 60001, '2013-01-01', NULL);
	/
	INSERT INTO portico.tbl_regla_rgla (rgla_pk, rgla_crgo_pk, rgla_enti_pk, rgla_tipo, rgla_codigo) VALUES (63001, 60001, 22004, 'T', 'B2-10-0000');
	/
INSERT INTO portico.tbl_cargo_crgo (crgo_pk, crgo_codigo, crgo_es_principal, crgo_tpsr_pk, crgo_tipo, crgo_descripcion) VALUES (60002, 'B3', 1, 21002, 'B', 'TASA A LA MERCANCIA')
/
	INSERT INTO portico.tbl_cargo_version_crgv (crgv_pk, crgv_crgo_pk, crgv_fini, crgv_ffin) VALUES (62002, 60002, '2013-01-01', NULL);
	/
	INSERT INTO portico.tbl_regla_rgla (rgla_pk, rgla_crgo_pk, rgla_enti_pk, rgla_tipo, rgla_codigo) VALUES (63002, 60002, 22004, 'T', 'B3-10-0000');
	/
	INSERT INTO portico.tbl_regla_rgla (rgla_pk, rgla_crgo_pk, rgla_enti_pk, rgla_tipo, rgla_codigo) VALUES (63003, 60002, 22005, 'T', 'B3-20-0000');
	/
INSERT INTO portico.tbl_cargo_crgo (crgo_pk, crgo_codigo, crgo_es_principal, crgo_tpsr_pk, crgo_tipo, crgo_descripcion) VALUES (60003, 'B1', 1, 21003, 'B', 'TASA AL BUQUE')
/
	INSERT INTO portico.tbl_cargo_version_crgv (crgv_pk, crgv_crgo_pk, crgv_fini, crgv_ffin) VALUES (62003, 60003, '2013-01-01', NULL);
	/
	INSERT INTO portico.tbl_regla_rgla (rgla_pk, rgla_crgo_pk, rgla_enti_pk, rgla_tipo, rgla_codigo) VALUES (63004, 60003, 22011, 'T', 'B1-10-0000');
	/
	INSERT INTO portico.tbl_regla_rgla (rgla_pk, rgla_crgo_pk, rgla_enti_pk, rgla_tipo, rgla_codigo) VALUES (63005, 60003, 22011, 'T', 'B1-20-0000');
	/
INSERT INTO portico.tbl_cargo_crgo (crgo_pk, crgo_codigo, crgo_es_principal, crgo_tpsr_pk, crgo_tipo, crgo_descripcion) VALUES (60004, 'B0', 0, 21003, 'B', 'TASA AL BUQUE 2')
/
	INSERT INTO portico.tbl_cargo_version_crgv (crgv_pk, crgv_crgo_pk, crgv_fini, crgv_ffin) VALUES (62004, 60004, '2013-01-01', NULL);
	/
	INSERT INTO portico.tbl_regla_rgla (rgla_pk, rgla_crgo_pk, rgla_enti_pk, rgla_tipo, rgla_codigo) VALUES (63006, 60004, 21003, 'T', 'B0-10-0000');
	/
INSERT INTO portico.tbl_cargo_crgo (crgo_pk, crgo_codigo, crgo_es_principal, crgo_tpsr_pk, crgo_tipo, crgo_descripcion) VALUES (60005, 'TR', 1, 21003, 'T', 'TARIFA DE RESIDUOS')
/
	INSERT INTO portico.tbl_cargo_version_crgv (crgv_pk, crgv_crgo_pk, crgv_fini, crgv_ffin) VALUES (62005, 60005, '2013-01-01', NULL);
	/
	INSERT INTO portico.tbl_regla_rgla (rgla_pk, rgla_crgo_pk, rgla_enti_pk, rgla_tipo, rgla_codigo) VALUES (63007, 60005, 21003, 'T', 'TR-10-0000');
	/
--		INSERT INTO portico.tbl_regla_version_rglv (rglv_pk, rglv_rgla_pk, rglv_fini, rglv_ffin, rglv_condicion, rglv_formula, rglv_path_impuesto, rglv_path_pagador, rglv_path_es_suj_pasivo, rglv_path_cod_exen
--			, rglv_path_info1, rglv_etiq_info1, rglv_path_info2, rglv_etiq_info2, rglv_path_info3, rglv_etiq_info3, rglv_path_info4, rglv_etiq_info4, rglv_path_info5, rglv_etiq_info5, rglv_path_info6, rglv_etiq_info6
--			, rglv_path_cuant1, rglv_etiq_cuant1, rglv_path_cuant2, rglv_etiq_cuant2, rglv_path_cuant3, rglv_etiq_cuant3, rglv_path_cuant4, rglv_etiq_cuant4, rglv_path_cuant5, rglv_etiq_cuant5, rglv_path_cuant6, rglv_etiq_cuant6
--		) VALUES (
--		)
--		/



INSERT INTO portico.tbl_cargo_dep_crdp (crdp_crgop_pk, crdp_crgoh_pk) VALUES (60003, 60004)
/



INSERT INTO portico.tbl_aspecto_aspc (aspc_pk, aspc_codigo, aspc_tpsr_pk, aspc_descripcion) VALUES (61000, 'B5', 21001, 'ASPECTO DE PESCA FRESCA')
/
--	INSERT INTO portico.tbl_aspecto_cargo_ascr (ascr_aspc_pk, ascr_crgo_pk) VALUES (61000, 60000)
--	/
INSERT INTO portico.tbl_aspecto_aspc (aspc_pk, aspc_codigo, aspc_tpsr_pk, aspc_descripcion) VALUES (61001, 'B2', 21002, 'ASPECTO DE PASAJE')
/
--	INSERT INTO portico.tbl_aspecto_cargo_ascr (ascr_aspc_pk, ascr_crgo_pk) VALUES (61001, 60001)
--	/
INSERT INTO portico.tbl_aspecto_aspc (aspc_pk, aspc_codigo, aspc_tpsr_pk, aspc_descripcion) VALUES (61002, 'B3', 21002, 'ASPECTO DE MERCANCIA')
/
--	INSERT INTO portico.tbl_aspecto_cargo_ascr (ascr_aspc_pk, ascr_crgo_pk) VALUES (61002, 60002)
--	/
INSERT INTO portico.tbl_aspecto_aspc (aspc_pk, aspc_codigo, aspc_tpsr_pk, aspc_descripcion) VALUES (61003, 'B1', 21003, 'ASPECTO DE BUQUE')
/
--	INSERT INTO portico.tbl_aspecto_cargo_ascr (ascr_aspc_pk, ascr_crgo_pk) VALUES (61003, 60003)
--	/
--	INSERT INTO portico.tbl_aspecto_cargo_ascr (ascr_aspc_pk, ascr_crgo_pk) VALUES (61003, 60004)
--	/
INSERT INTO portico.tbl_aspecto_aspc (aspc_pk, aspc_codigo, aspc_tpsr_pk, aspc_descripcion) VALUES (61004, 'TR', 21002, 'ASPECTO DE RESIDUOS')
/
--	INSERT INTO portico.tbl_aspecto_cargo_ascr (ascr_aspc_pk, ascr_crgo_pk) VALUES (61004, 60005)
--	/












-- //@UNDO
-- SQL to undo the change goes here.

--DELETE FROM portico.tbl_aspecto_cargo_ascr WHERE ascr_aspc_pk IN (
--	  61000
--	, 61001
--	, 61002
--	, 61003
--	, 61004
--)
--/

DELETE FROM portico.tbl_aspecto_aspc WHERE aspc_pk IN (
	  61000
	, 61001
	, 61002
	, 61003
	, 61004
)
/

DELETE FROM portico.tbl_regla_rgla WHERE rgla_crgo_pk IN (
	  60000
	, 60001
	, 60002
	, 60003
	, 60004
	, 60005
)
/

DELETE FROM portico.tbl_cargo_dep_crdp WHERE crdp_crgop_pk IN (
	  60000
	, 60001
	, 60002
	, 60003
	, 60004
	, 60005
)
/

DELETE FROM portico.tbl_cargo_version_crgv WHERE crgv_crgo_pk IN (
	  60000
	, 60001
	, 60002
	, 60003
	, 60004
	, 60005
)
/

DELETE FROM portico.tbl_cargo_crgo WHERE crgo_pk IN (
	  60000
	, 60001
	, 60002
	, 60003
	, 60004
	, 60005
)
/