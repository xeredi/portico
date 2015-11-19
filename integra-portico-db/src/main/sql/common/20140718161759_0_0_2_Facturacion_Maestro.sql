-- // 0 0 2 Facturacion Maestro
-- Migration SQL that makes the change goes here.
INSERT INTO tbl_cargo_crgo (crgo_pk, crgo_codigo, crgo_tpsr_pk) VALUES (60000, 'B5', 21001)\
INSERT INTO tbl_cargo_crgo (crgo_pk, crgo_codigo, crgo_tpsr_pk) VALUES (60001, 'B2', 21002)\
INSERT INTO tbl_cargo_crgo (crgo_pk, crgo_codigo, crgo_tpsr_pk) VALUES (60002, 'B3', 21002)\
INSERT INTO tbl_cargo_crgo (crgo_pk, crgo_codigo, crgo_tpsr_pk) VALUES (60003, 'B1', 21003)\
INSERT INTO tbl_cargo_crgo (crgo_pk, crgo_codigo, crgo_tpsr_pk) VALUES (60004, 'B0', 21003)\
INSERT INTO tbl_cargo_crgo (crgo_pk, crgo_codigo, crgo_tpsr_pk) VALUES (60005, 'TR', 21003)\

INSERT INTO tbl_cargo_version_crgv (crgv_pk, crgv_crgo_pk, crgv_fini, crgv_ffin, crgv_codigo_norm, crgv_es_principal, crgv_es_temporal, crgv_tipo)
	VALUES (62000, 60000, TO_DATE('2013-01-01', 'yyyy-mm-dd'), NULL, NULL, 1, 0, 'B')\
INSERT INTO tbl_cargo_version_crgv (crgv_pk, crgv_crgo_pk, crgv_fini, crgv_ffin, crgv_codigo_norm, crgv_es_principal, crgv_es_temporal, crgv_tipo)
	VALUES (62001, 60001, TO_DATE('2013-01-01', 'yyyy-mm-dd'), NULL, 'B2', 1, 0, 'B')\
INSERT INTO tbl_cargo_version_crgv (crgv_pk, crgv_crgo_pk, crgv_fini, crgv_ffin, crgv_codigo_norm, crgv_es_principal, crgv_es_temporal, crgv_tipo)
	VALUES (62002, 60002, TO_DATE('2013-01-01', 'yyyy-mm-dd'), NULL, 'B3', 1, 0, 'B')\
INSERT INTO tbl_cargo_version_crgv (crgv_pk, crgv_crgo_pk, crgv_fini, crgv_ffin, crgv_codigo_norm, crgv_es_principal, crgv_es_temporal, crgv_tipo)
	VALUES (62003, 60003, TO_DATE('2013-01-01', 'yyyy-mm-dd'), NULL, NULL, 1, 1, 'B')\
INSERT INTO tbl_cargo_version_crgv (crgv_pk, crgv_crgo_pk, crgv_fini, crgv_ffin, crgv_codigo_norm, crgv_es_principal, crgv_es_temporal, crgv_tipo)
	VALUES (62004, 60004, TO_DATE('2013-01-01', 'yyyy-mm-dd'), NULL, 'B0', 0, 0, 'B')\
INSERT INTO tbl_cargo_version_crgv (crgv_pk, crgv_crgo_pk, crgv_fini, crgv_ffin, crgv_codigo_norm, crgv_es_principal, crgv_es_temporal, crgv_tipo)
	VALUES (62005, 60005, TO_DATE('2013-01-01', 'yyyy-mm-dd'), NULL, 'TR', 1, 0, 'T')\

INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('crgv', 'es', 62000, 'TASA DE PESCA FRESCA')\
INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('crgv', 'es', 62001, 'TASA AL PASAJE')\
INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('crgv', 'es', 62002, 'TASA A LA MERCANCIA')\
INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('crgv', 'es', 62003, 'TASA AL BUQUE')\
INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('crgv', 'es', 62004, 'TASA AL BUQUE 2')\
INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('crgv', 'es', 62005, 'TARIFA DE RESIDUOS')\

INSERT INTO tbl_cargo_dep_crdp (crdp_pk, crdp_crgop_pk, crdp_crgoh_pk) VALUES (65000, 60003, 60004)\

INSERT INTO tbl_cargo_dep_version_crdv (crdv_pk, crdv_crdp_pk, crdv_fini, crdv_ffin) VALUES (66000, 65000, TO_DATE('2013-01-01', 'yyyy-mm-dd'), NULL)\

INSERT INTO tbl_regla_rgla (rgla_pk, rgla_crgo_pk, rgla_enti_pk, rgla_tipo, rgla_codigo) VALUES (
	63000, 60000, 22001, 'T', 'B5-10-0000')\
INSERT INTO tbl_regla_rgla (rgla_pk, rgla_crgo_pk, rgla_enti_pk, rgla_tipo, rgla_codigo) VALUES (
	63001, 60001, 22004, 'T', 'B2-10-0000')\
INSERT INTO tbl_regla_rgla (rgla_pk, rgla_crgo_pk, rgla_enti_pk, rgla_tipo, rgla_codigo) VALUES (
	63002, 60001, 22004, 'C', 'B2-C001')\
INSERT INTO tbl_regla_rgla (rgla_pk, rgla_crgo_pk, rgla_enti_pk, rgla_tipo, rgla_codigo) VALUES (
	63003, 60001, 22004, 'C', 'B2-C002')\
INSERT INTO tbl_regla_rgla (rgla_pk, rgla_crgo_pk, rgla_enti_pk, rgla_tipo, rgla_codigo) VALUES (
	63004, 60001, 22004, 'C', 'B2-C003')\
INSERT INTO tbl_regla_rgla (rgla_pk, rgla_crgo_pk, rgla_enti_pk, rgla_tipo, rgla_codigo) VALUES (
	63005, 60001, 22004, 'C', 'B2-C004')\
INSERT INTO tbl_regla_rgla (rgla_pk, rgla_crgo_pk, rgla_enti_pk, rgla_tipo, rgla_codigo) VALUES (
	63100, 60002, 22004, 'T', 'B3-10-0000')\
INSERT INTO tbl_regla_rgla (rgla_pk, rgla_crgo_pk, rgla_enti_pk, rgla_tipo, rgla_codigo) VALUES (
	63101, 60002, 22004, 'T', 'B3-20-0000')\
INSERT INTO tbl_regla_rgla (rgla_pk, rgla_crgo_pk, rgla_enti_pk, rgla_tipo, rgla_codigo) VALUES (
	63200, 60003, 22011, 'T', 'B1-10-0000')\
INSERT INTO tbl_regla_rgla (rgla_pk, rgla_crgo_pk, rgla_enti_pk, rgla_tipo, rgla_codigo) VALUES (
	63201, 60003, 22011, 'T', 'B1-20-0000')\
INSERT INTO tbl_regla_rgla (rgla_pk, rgla_crgo_pk, rgla_enti_pk, rgla_tipo, rgla_codigo) VALUES (
	63202, 60003, 22011, 'C', 'B1-C001')\
INSERT INTO tbl_regla_rgla (rgla_pk, rgla_crgo_pk, rgla_enti_pk, rgla_tipo, rgla_codigo) VALUES (
	63300, 60004, 21003, 'T', 'B0-10-0000')\
INSERT INTO tbl_regla_rgla (rgla_pk, rgla_crgo_pk, rgla_enti_pk, rgla_tipo, rgla_codigo) VALUES (
	63320, 60004, 21003, 'C', 'B0-C001')\
INSERT INTO tbl_regla_rgla (rgla_pk, rgla_crgo_pk, rgla_enti_pk, rgla_tipo, rgla_codigo) VALUES (
	63400, 60005, 21003, 'T', 'TR-10-0000')\

INSERT INTO tbl_regla_version_rglv (
	rglv_pk, rglv_rgla_pk, rglv_fini, rglv_ffin, rglv_orden, rglv_valor_base, rglv_condicion, rglv_formula
	, rglv_path_impuesto, rglv_path_pagador, rglv_path_es_suj_pasivo, rglv_path_cod_exen
	, rglv_path_info1, rglv_path_info2, rglv_path_info3, rglv_path_info4, rglv_path_info5, rglv_path_info6
	, rglv_etiq_info1, rglv_etiq_info2, rglv_etiq_info3, rglv_etiq_info4, rglv_etiq_info5, rglv_etiq_info6
	, rglv_path_cuant1, rglv_path_cuant2, rglv_path_cuant3, rglv_path_cuant4, rglv_path_cuant5, rglv_path_cuant6
	, rglv_etiq_cuant1, rglv_etiq_cuant2, rglv_etiq_cuant3, rglv_etiq_cuant4, rglv_etiq_cuant5, rglv_etiq_cuant6
) VALUES (
	64000, 63001, TO_DATE('2013-01-01', 'yyyy-mm-dd'), NULL, 1, 2.95, '1 = 1', '2.95 * dato(ENTERO_04) / 1000.0'
	, 'padre(BL).dato(TIPO_IVA)', 'padre(BL).padre(MANIFIESTO_CONSIGNATARIO).dato(ORGA)', 'padre(BL).dato(BOOLEANO_01)', 'padre(BL).dato(COD_EXEN)'
	, 'dato(MERCANCIA)', 'dato(ENTERO_04)', NULL, NULL, NULL, NULL
	, 'Mercancía', 'Peso', NULL, NULL, NULL, NULL
	, NULL, NULL, NULL, NULL, NULL, NULL
	, NULL, NULL, NULL, NULL, NULL, NULL
)\
INSERT INTO tbl_regla_version_rglv (
	rglv_pk, rglv_rgla_pk, rglv_fini, rglv_ffin, rglv_orden, rglv_valor_base, rglv_condicion, rglv_formula
	, rglv_path_impuesto, rglv_path_pagador, rglv_path_es_suj_pasivo, rglv_path_cod_exen
	, rglv_path_info1, rglv_path_info2, rglv_path_info3, rglv_path_info4, rglv_path_info5, rglv_path_info6
	, rglv_etiq_info1, rglv_etiq_info2, rglv_etiq_info3, rglv_etiq_info4, rglv_etiq_info5, rglv_etiq_info6
	, rglv_path_cuant1, rglv_path_cuant2, rglv_path_cuant3, rglv_path_cuant4, rglv_path_cuant5, rglv_path_cuant6
	, rglv_etiq_cuant1, rglv_etiq_cuant2, rglv_etiq_cuant3, rglv_etiq_cuant4, rglv_etiq_cuant5, rglv_etiq_cuant6
) VALUES (
	64001, 63002, TO_DATE('2013-01-01', 'yyyy-mm-dd'), NULL, 11, 0.5, '1 = 1', '0.5'
	, NULL, NULL, NULL, NULL
	, NULL, NULL, NULL, NULL, NULL, NULL
	, NULL, NULL, NULL, NULL, NULL, NULL
	, NULL, NULL, NULL, NULL, NULL, NULL
	, NULL, NULL, NULL, NULL, NULL, NULL
)\
INSERT INTO tbl_regla_version_rglv (
	rglv_pk, rglv_rgla_pk, rglv_fini, rglv_ffin, rglv_orden, rglv_valor_base, rglv_condicion, rglv_formula
	, rglv_path_impuesto, rglv_path_pagador, rglv_path_es_suj_pasivo, rglv_path_cod_exen
	, rglv_path_info1, rglv_path_info2, rglv_path_info3, rglv_path_info4, rglv_path_info5, rglv_path_info6
	, rglv_etiq_info1, rglv_etiq_info2, rglv_etiq_info3, rglv_etiq_info4, rglv_etiq_info5, rglv_etiq_info6
	, rglv_path_cuant1, rglv_path_cuant2, rglv_path_cuant3, rglv_path_cuant4, rglv_path_cuant5, rglv_path_cuant6
	, rglv_etiq_cuant1, rglv_etiq_cuant2, rglv_etiq_cuant3, rglv_etiq_cuant4, rglv_etiq_cuant5, rglv_etiq_cuant6
) VALUES (
	64002, 63003, TO_DATE('2013-01-01', 'yyyy-mm-dd'), NULL, 12, 1.5, '1 = 1', '1.5'
	, NULL, NULL, NULL, NULL
	, NULL, NULL, NULL, NULL, NULL, NULL
	, NULL, NULL, NULL, NULL, NULL, NULL
	, NULL, NULL, NULL, NULL, NULL, NULL
	, NULL, NULL, NULL, NULL, NULL, NULL
)\
INSERT INTO tbl_regla_version_rglv (
	rglv_pk, rglv_rgla_pk, rglv_fini, rglv_ffin, rglv_orden, rglv_valor_base, rglv_condicion, rglv_formula
	, rglv_path_impuesto, rglv_path_pagador, rglv_path_es_suj_pasivo, rglv_path_cod_exen
	, rglv_path_info1, rglv_path_info2, rglv_path_info3, rglv_path_info4, rglv_path_info5, rglv_path_info6
	, rglv_etiq_info1, rglv_etiq_info2, rglv_etiq_info3, rglv_etiq_info4, rglv_etiq_info5, rglv_etiq_info6
	, rglv_path_cuant1, rglv_path_cuant2, rglv_path_cuant3, rglv_path_cuant4, rglv_path_cuant5, rglv_path_cuant6
	, rglv_etiq_cuant1, rglv_etiq_cuant2, rglv_etiq_cuant3, rglv_etiq_cuant4, rglv_etiq_cuant5, rglv_etiq_cuant6
) VALUES (
	64003, 63004, TO_DATE('2013-01-01', 'yyyy-mm-dd'), NULL, 13, 1.2, '1 = 1', '1.2'
	, NULL, NULL, NULL, NULL
	, NULL, NULL, NULL, NULL, NULL, NULL
	, NULL, NULL, NULL, NULL, NULL, NULL
	, NULL, NULL, NULL, NULL, NULL, NULL
	, NULL, NULL, NULL, NULL, NULL, NULL
)\
INSERT INTO tbl_regla_version_rglv (
	rglv_pk, rglv_rgla_pk, rglv_fini, rglv_ffin, rglv_orden, rglv_valor_base, rglv_condicion, rglv_formula
	, rglv_path_impuesto, rglv_path_pagador, rglv_path_es_suj_pasivo, rglv_path_cod_exen
	, rglv_path_info1, rglv_path_info2, rglv_path_info3, rglv_path_info4, rglv_path_info5, rglv_path_info6
	, rglv_etiq_info1, rglv_etiq_info2, rglv_etiq_info3, rglv_etiq_info4, rglv_etiq_info5, rglv_etiq_info6
	, rglv_path_cuant1, rglv_path_cuant2, rglv_path_cuant3, rglv_path_cuant4, rglv_path_cuant5, rglv_path_cuant6
	, rglv_etiq_cuant1, rglv_etiq_cuant2, rglv_etiq_cuant3, rglv_etiq_cuant4, rglv_etiq_cuant5, rglv_etiq_cuant6
) VALUES (
	64004, 63005, TO_DATE('2013-01-01', 'yyyy-mm-dd'), NULL, 14, 0.8, '1 = 1', '0.8'
	, NULL, NULL, NULL, NULL
	, NULL, NULL, NULL, NULL, NULL, NULL
	, NULL, NULL, NULL, NULL, NULL, NULL
	, NULL, NULL, NULL, NULL, NULL, NULL
	, NULL, NULL, NULL, NULL, NULL, NULL
)\
INSERT INTO tbl_regla_version_rglv (
	rglv_pk, rglv_rgla_pk, rglv_fini, rglv_ffin, rglv_orden, rglv_valor_base, rglv_condicion, rglv_formula
	, rglv_path_impuesto, rglv_path_pagador, rglv_path_es_suj_pasivo, rglv_path_cod_exen
	, rglv_path_info1, rglv_path_info2, rglv_path_info3, rglv_path_info4, rglv_path_info5, rglv_path_info6
	, rglv_etiq_info1, rglv_etiq_info2, rglv_etiq_info3, rglv_etiq_info4, rglv_etiq_info5, rglv_etiq_info6
	, rglv_path_cuant1, rglv_path_cuant2, rglv_path_cuant3, rglv_path_cuant4, rglv_path_cuant5, rglv_path_cuant6
	, rglv_etiq_cuant1, rglv_etiq_cuant2, rglv_etiq_cuant3, rglv_etiq_cuant4, rglv_etiq_cuant5, rglv_etiq_cuant6
) VALUES (
	64200, 63200, TO_DATE('2013-01-01', 'yyyy-mm-dd'), NULL, 1, 1.3, 'dato(TIPO_ESTAN_ATR_3) = ????', '1.3 * atraqueUdsGt()'
	, 'servicio.dato(TIPO_IVA)', 'dato(ORGA_2)', 'dato(BOOLEANO_01)', 'dato(COD_EXEN)'
	, NULL, NULL, NULL, NULL, NULL, NULL
	, NULL, NULL, NULL, NULL, NULL, NULL
	, NULL, NULL, NULL, NULL, NULL, NULL
	, NULL, NULL, NULL, NULL, NULL, NULL
)\
INSERT INTO tbl_regla_version_rglv (
	rglv_pk, rglv_rgla_pk, rglv_fini, rglv_ffin, rglv_orden, rglv_valor_base, rglv_condicion, rglv_formula
	, rglv_path_impuesto, rglv_path_pagador, rglv_path_es_suj_pasivo, rglv_path_cod_exen
	, rglv_path_info1, rglv_path_info2, rglv_path_info3, rglv_path_info4, rglv_path_info5, rglv_path_info6
	, rglv_etiq_info1, rglv_etiq_info2, rglv_etiq_info3, rglv_etiq_info4, rglv_etiq_info5, rglv_etiq_info6
	, rglv_path_cuant1, rglv_path_cuant2, rglv_path_cuant3, rglv_path_cuant4, rglv_path_cuant5, rglv_path_cuant6
	, rglv_etiq_cuant1, rglv_etiq_cuant2, rglv_etiq_cuant3, rglv_etiq_cuant4, rglv_etiq_cuant5, rglv_etiq_cuant6
) VALUES (
	64202, 63202, TO_DATE('2013-01-01', 'yyyy-mm-dd'), NULL, 1, 1, '1 = 1', '1'
	, NULL, NULL, NULL, NULL
	, NULL, NULL, NULL, NULL, NULL, NULL
	, NULL, NULL, NULL, NULL, NULL, NULL
	, NULL, NULL, NULL, NULL, NULL, NULL
	, NULL, NULL, NULL, NULL, NULL, NULL
)\
INSERT INTO tbl_regla_version_rglv (
	rglv_pk, rglv_rgla_pk, rglv_fini, rglv_ffin, rglv_orden, rglv_valor_base, rglv_condicion, rglv_formula
	, rglv_path_impuesto, rglv_path_pagador, rglv_path_es_suj_pasivo, rglv_path_cod_exen
	, rglv_path_info1, rglv_path_info2, rglv_path_info3, rglv_path_info4, rglv_path_info5, rglv_path_info6
	, rglv_etiq_info1, rglv_etiq_info2, rglv_etiq_info3, rglv_etiq_info4, rglv_etiq_info5, rglv_etiq_info6
	, rglv_path_cuant1, rglv_path_cuant2, rglv_path_cuant3, rglv_path_cuant4, rglv_path_cuant5, rglv_path_cuant6
	, rglv_etiq_cuant1, rglv_etiq_cuant2, rglv_etiq_cuant3, rglv_etiq_cuant4, rglv_etiq_cuant5, rglv_etiq_cuant6
) VALUES (
	64300, 63300, TO_DATE('2013-01-01', 'yyyy-mm-dd'), NULL, 1, 2.95, '1 = 1', '2.95 * dato(ENTERO_04) / 1000.0'
	, 'dato(TIPO_IVA)', 'dato(ORGA_3)', 'dato(BOOLEANO_01)', 'dato(COD_EXEN)'
	, 'dato(BUQUE)', NULL, NULL, NULL, NULL, NULL
	, 'Buque', NULL, NULL, NULL, NULL, NULL
	, NULL, NULL, NULL, NULL, NULL, NULL
	, NULL, NULL, NULL, NULL, NULL, NULL
)\
INSERT INTO tbl_regla_version_rglv (
	rglv_pk, rglv_rgla_pk, rglv_fini, rglv_ffin, rglv_orden, rglv_valor_base, rglv_condicion, rglv_formula
	, rglv_path_impuesto, rglv_path_pagador, rglv_path_es_suj_pasivo, rglv_path_cod_exen
	, rglv_path_info1, rglv_path_info2, rglv_path_info3, rglv_path_info4, rglv_path_info5, rglv_path_info6
	, rglv_etiq_info1, rglv_etiq_info2, rglv_etiq_info3, rglv_etiq_info4, rglv_etiq_info5, rglv_etiq_info6
	, rglv_path_cuant1, rglv_path_cuant2, rglv_path_cuant3, rglv_path_cuant4, rglv_path_cuant5, rglv_path_cuant6
	, rglv_etiq_cuant1, rglv_etiq_cuant2, rglv_etiq_cuant3, rglv_etiq_cuant4, rglv_etiq_cuant5, rglv_etiq_cuant6
) VALUES (
	64320, 63320, TO_DATE('2013-01-01', 'yyyy-mm-dd'), NULL, 1, 1, '1 = 1', '1'
	, NULL, NULL, NULL, NULL
	, NULL, NULL, NULL, NULL, NULL, NULL
	, NULL, NULL, NULL, NULL, NULL, NULL
	, NULL, NULL, NULL, NULL, NULL, NULL
	, NULL, NULL, NULL, NULL, NULL, NULL
)\
INSERT INTO tbl_regla_version_rglv (
	rglv_pk, rglv_rgla_pk, rglv_fini, rglv_ffin, rglv_orden, rglv_valor_base, rglv_condicion, rglv_formula
	, rglv_path_impuesto, rglv_path_pagador, rglv_path_es_suj_pasivo, rglv_path_cod_exen
	, rglv_path_info1, rglv_path_info2, rglv_path_info3, rglv_path_info4, rglv_path_info5, rglv_path_info6
	, rglv_etiq_info1, rglv_etiq_info2, rglv_etiq_info3, rglv_etiq_info4, rglv_etiq_info5, rglv_etiq_info6
	, rglv_path_cuant1, rglv_path_cuant2, rglv_path_cuant3, rglv_path_cuant4, rglv_path_cuant5, rglv_path_cuant6
	, rglv_etiq_cuant1, rglv_etiq_cuant2, rglv_etiq_cuant3, rglv_etiq_cuant4, rglv_etiq_cuant5, rglv_etiq_cuant6
) VALUES (
	64400, 63400, TO_DATE('2013-01-01', 'yyyy-mm-dd'), NULL, 1, 2.95, '1 = 1', '2.95 * dato(ENTERO_04) / 1000.0'
	, 'dato(TIPO_IVA)', 'dato(ORGA_3)', 'dato(BOOLEANO_01)', 'dato(COD_EXEN)'
	, 'dato(BUQUE)', NULL, NULL, NULL, NULL, NULL
	, 'Buque', NULL, NULL, NULL, NULL, NULL
	, NULL, NULL, NULL, NULL, NULL, NULL
	, NULL, NULL, NULL, NULL, NULL, NULL
)\

INSERT INTO tbl_regla_inc_rgin (rgin_pk, rgin_rgla1_pk, rgin_rgla2_pk) VALUES (66001, 63003, 63004)\
INSERT INTO tbl_regla_inc_rgin (rgin_pk, rgin_rgla1_pk, rgin_rgla2_pk) VALUES (66002, 63004, 63003)\

INSERT INTO tbl_regla_inc_version_rgiv (rgiv_pk, rgiv_rgin_pk, rgiv_fini, rgiv_ffin) VALUES (67001, 66001, TO_DATE('2013-01-01', 'yyyy-mm-dd'), NULL)\
INSERT INTO tbl_regla_inc_version_rgiv (rgiv_pk, rgiv_rgin_pk, rgiv_fini, rgiv_ffin) VALUES (67002, 66002, TO_DATE('2013-01-01', 'yyyy-mm-dd'), NULL)\

INSERT INTO tbl_aspecto_aspc (aspc_pk, aspc_codigo, aspc_tpsr_pk) VALUES (61000, 'B5', 21001)\
INSERT INTO tbl_aspecto_aspc (aspc_pk, aspc_codigo, aspc_tpsr_pk) VALUES (61001, 'B2', 21002)\
INSERT INTO tbl_aspecto_aspc (aspc_pk, aspc_codigo, aspc_tpsr_pk) VALUES (61002, 'B3', 21002)\
INSERT INTO tbl_aspecto_aspc (aspc_pk, aspc_codigo, aspc_tpsr_pk) VALUES (61003, 'B1', 21003)\
INSERT INTO tbl_aspecto_aspc (aspc_pk, aspc_codigo, aspc_tpsr_pk) VALUES (61004, 'TR', 21003)\

INSERT INTO tbl_aspecto_version_aspv (aspv_pk, aspv_aspc_pk, aspv_fini, aspv_ffin, aspv_prioridad
	, aspv_cpath_info1, aspv_cpath_info2, aspv_cpath_info3, aspv_cpath_info4, aspv_cpath_info5, aspv_cpath_info6
	, aspv_cetiq_info1, aspv_cetiq_info2, aspv_cetiq_info3, aspv_cetiq_info4, aspv_cetiq_info5, aspv_cetiq_info6
	, aspv_cgrp_info1, aspv_cgrp_info2, aspv_cgrp_info3, aspv_cgrp_info4, aspv_cgrp_info5, aspv_cgrp_info6
	, aspv_lsum_cuant1, aspv_lsum_cuant2, aspv_lsum_cuant3, aspv_lsum_cuant4, aspv_lsum_cuant5, aspv_lsum_cuant6
	, aspv_lgrp_info1, aspv_lgrp_info2, aspv_lgrp_info3, aspv_lgrp_info4, aspv_lgrp_info5, aspv_lgrp_info6
) VALUES (65000, 61000, TO_DATE('2013-01-01', 'yyyy-mm-dd'), NULL, 1
	, NULL, NULL, NULL, NULL, NULL, NULL
	, NULL, NULL, NULL, NULL, NULL, NULL
	, NULL, NULL, NULL, NULL, NULL, NULL
	, NULL, NULL, NULL, NULL, NULL, NULL
	, NULL, NULL, NULL, NULL, NULL, NULL
)\
INSERT INTO tbl_aspecto_version_aspv (aspv_pk, aspv_aspc_pk, aspv_fini, aspv_ffin, aspv_prioridad
	, aspv_cpath_info1, aspv_cpath_info2, aspv_cpath_info3, aspv_cpath_info4, aspv_cpath_info5, aspv_cpath_info6
	, aspv_cetiq_info1, aspv_cetiq_info2, aspv_cetiq_info3, aspv_cetiq_info4, aspv_cetiq_info5, aspv_cetiq_info6
	, aspv_cgrp_info1, aspv_cgrp_info2, aspv_cgrp_info3, aspv_cgrp_info4, aspv_cgrp_info5, aspv_cgrp_info6
	, aspv_lsum_cuant1, aspv_lsum_cuant2, aspv_lsum_cuant3, aspv_lsum_cuant4, aspv_lsum_cuant5, aspv_lsum_cuant6
	, aspv_lgrp_info1, aspv_lgrp_info2, aspv_lgrp_info3, aspv_lgrp_info4, aspv_lgrp_info5, aspv_lgrp_info6
) VALUES (65001, 61001, TO_DATE('2013-01-01', 'yyyy-mm-dd'), NULL, 1
	, 'dato(ORGA_2)', 'dato(ALIN)', 'dato(ACUERDO)', NULL, NULL, NULL
	, 'Consignatario', 'Alineación', 'Acuerdo', NULL, NULL, NULL
	, NULL, NULL, NULL, NULL, NULL, NULL
	, NULL, NULL, NULL, NULL, NULL, NULL
	, 1, NULL, NULL, NULL, NULL, NULL
)\
INSERT INTO tbl_aspecto_version_aspv (aspv_pk, aspv_aspc_pk, aspv_fini, aspv_ffin, aspv_prioridad
	, aspv_cpath_info1, aspv_cpath_info2, aspv_cpath_info3, aspv_cpath_info4, aspv_cpath_info5, aspv_cpath_info6
	, aspv_cetiq_info1, aspv_cetiq_info2, aspv_cetiq_info3, aspv_cetiq_info4, aspv_cetiq_info5, aspv_cetiq_info6
	, aspv_cgrp_info1, aspv_cgrp_info2, aspv_cgrp_info3, aspv_cgrp_info4, aspv_cgrp_info5, aspv_cgrp_info6
	, aspv_lsum_cuant1, aspv_lsum_cuant2, aspv_lsum_cuant3, aspv_lsum_cuant4, aspv_lsum_cuant5, aspv_lsum_cuant6
	, aspv_lgrp_info1, aspv_lgrp_info2, aspv_lgrp_info3, aspv_lgrp_info4, aspv_lgrp_info5, aspv_lgrp_info6
) VALUES (65002, 61002, TO_DATE('2013-01-01', 'yyyy-mm-dd'), NULL, 2
	, 'dato(ORGA_2)', 'dato(ALIN)', 'dato(ACUERDO)', NULL, NULL, NULL
	, 'Consignatario', 'Alineación', 'Acuerdo', NULL, NULL, NULL
	, NULL, NULL, NULL, NULL, NULL, NULL
	, NULL, NULL, NULL, NULL, NULL, NULL
	, 1, NULL, NULL, NULL, NULL, NULL
)\
INSERT INTO tbl_aspecto_version_aspv (aspv_pk, aspv_aspc_pk, aspv_fini, aspv_ffin, aspv_prioridad
	, aspv_cpath_info1, aspv_cpath_info2, aspv_cpath_info3, aspv_cpath_info4, aspv_cpath_info5, aspv_cpath_info6
	, aspv_cetiq_info1, aspv_cetiq_info2, aspv_cetiq_info3, aspv_cetiq_info4, aspv_cetiq_info5, aspv_cetiq_info6
	, aspv_cgrp_info1, aspv_cgrp_info2, aspv_cgrp_info3, aspv_cgrp_info4, aspv_cgrp_info5, aspv_cgrp_info6
	, aspv_lsum_cuant1, aspv_lsum_cuant2, aspv_lsum_cuant3, aspv_lsum_cuant4, aspv_lsum_cuant5, aspv_lsum_cuant6
	, aspv_lgrp_info1, aspv_lgrp_info2, aspv_lgrp_info3, aspv_lgrp_info4, aspv_lgrp_info5, aspv_lgrp_info6
) VALUES (65003, 61003, TO_DATE('2013-01-01', 'yyyy-mm-dd'), NULL, 1
	, NULL, NULL, NULL, NULL, NULL, NULL
	, NULL, NULL, NULL, NULL, NULL, NULL
	, NULL, NULL, NULL, NULL, NULL, NULL
	, NULL, NULL, NULL, NULL, NULL, NULL
	, NULL, NULL, NULL, NULL, NULL, NULL
)\
INSERT INTO tbl_aspecto_version_aspv (aspv_pk, aspv_aspc_pk, aspv_fini, aspv_ffin, aspv_prioridad
	, aspv_cpath_info1, aspv_cpath_info2, aspv_cpath_info3, aspv_cpath_info4, aspv_cpath_info5, aspv_cpath_info6
	, aspv_cetiq_info1, aspv_cetiq_info2, aspv_cetiq_info3, aspv_cetiq_info4, aspv_cetiq_info5, aspv_cetiq_info6
	, aspv_cgrp_info1, aspv_cgrp_info2, aspv_cgrp_info3, aspv_cgrp_info4, aspv_cgrp_info5, aspv_cgrp_info6
	, aspv_lsum_cuant1, aspv_lsum_cuant2, aspv_lsum_cuant3, aspv_lsum_cuant4, aspv_lsum_cuant5, aspv_lsum_cuant6
	, aspv_lgrp_info1, aspv_lgrp_info2, aspv_lgrp_info3, aspv_lgrp_info4, aspv_lgrp_info5, aspv_lgrp_info6
) VALUES (65004, 61004, TO_DATE('2013-01-01', 'yyyy-mm-dd'), NULL, 2
	, NULL, NULL, NULL, NULL, NULL, NULL
	, NULL, NULL, NULL, NULL, NULL, NULL
	, NULL, NULL, NULL, NULL, NULL, NULL
	, NULL, NULL, NULL, NULL, NULL, NULL
	, NULL, NULL, NULL, NULL, NULL, NULL
)\

INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('aspv', 'es', 65000, 'ASPECTO DE PESCA FRESCA')\
INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('aspv', 'es', 65001, 'ASPECTO DE PASAJE')\
INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('aspv', 'es', 65002, 'ASPECTO DE MERCANCIA')\
INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('aspv', 'es', 65003, 'ASPECTO DE BUQUE')\
INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('aspv', 'es', 65004, 'ASPECTO DE RESIDUOS')\

INSERT INTO tbl_aspecto_cargo_ascr (ascr_pk, ascr_aspc_pk, ascr_crgo_pk) VALUES (66001, 61001, 60001)\
INSERT INTO tbl_aspecto_cargo_ascr (ascr_pk, ascr_aspc_pk, ascr_crgo_pk) VALUES (66002, 61002, 60001)\
INSERT INTO tbl_aspecto_cargo_ascr (ascr_pk, ascr_aspc_pk, ascr_crgo_pk) VALUES (66003, 61003, 60003)\
INSERT INTO tbl_aspecto_cargo_ascr (ascr_pk, ascr_aspc_pk, ascr_crgo_pk) VALUES (66004, 61003, 60004)\
INSERT INTO tbl_aspecto_cargo_ascr (ascr_pk, ascr_aspc_pk, ascr_crgo_pk) VALUES (66005, 61004, 60005)\

INSERT INTO tbl_aspecto_cargo_version_ascv (ascv_pk, ascv_ascr_pk, ascv_fini, ascv_ffin) VALUES (67001, 66001, TO_DATE('2013-01-01', 'yyyy-mm-dd'), NULL)\
INSERT INTO tbl_aspecto_cargo_version_ascv (ascv_pk, ascv_ascr_pk, ascv_fini, ascv_ffin) VALUES (67002, 66002, TO_DATE('2013-01-01', 'yyyy-mm-dd'), NULL)\
INSERT INTO tbl_aspecto_cargo_version_ascv (ascv_pk, ascv_ascr_pk, ascv_fini, ascv_ffin) VALUES (67003, 66003, TO_DATE('2013-01-01', 'yyyy-mm-dd'), NULL)\
INSERT INTO tbl_aspecto_cargo_version_ascv (ascv_pk, ascv_ascr_pk, ascv_fini, ascv_ffin) VALUES (67004, 66004, TO_DATE('2013-01-01', 'yyyy-mm-dd'), NULL)\
INSERT INTO tbl_aspecto_cargo_version_ascv (ascv_pk, ascv_ascr_pk, ascv_fini, ascv_ffin) VALUES (67005, 66005, TO_DATE('2013-01-01', 'yyyy-mm-dd'), NULL)\




-- Series de factura
INSERT INTO tbl_factura_serie_fcsr (fcsr_pk, fcsr_serie, fcsr_anio, fcsr_numero_ultimo) VALUES (68000, 'A', 2013, 0)\
INSERT INTO tbl_factura_serie_fcsr (fcsr_pk, fcsr_serie, fcsr_anio, fcsr_numero_ultimo) VALUES (68001, 'A', 2014, 0)\
INSERT INTO tbl_factura_serie_fcsr (fcsr_pk, fcsr_serie, fcsr_anio, fcsr_numero_ultimo) VALUES (68002, 'B', 2013, 0)\
INSERT INTO tbl_factura_serie_fcsr (fcsr_pk, fcsr_serie, fcsr_anio, fcsr_numero_ultimo) VALUES (68003, 'B', 2014, 0)\








-- //@UNDO
-- SQL to undo the change goes here.

DELETE FROM tbl_factura_serie_fcsr
WHERE fcsr_pk IN (
	68000
	, 68001
	, 68002
	, 68003
)\

BEGIN
	-- Aspectos
	eraseAspc(61000);
	eraseAspc(61001);
	eraseAspc(61002);
	eraseAspc(61003);
	eraseAspc(61004);

	-- Cargos
	eraseCrgo(60000);
	eraseCrgo(60001);
	eraseCrgo(60002);
	eraseCrgo(60003);
	eraseCrgo(60004);
	eraseCrgo(60005);
END;
\
