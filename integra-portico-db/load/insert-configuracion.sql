DELETE FROM tbl_configuracion_valor_idioma_cnvi;
DELETE FROM tbl_configuracion_valor_cnvl;
DELETE FROM tbl_configuracion_clave_idioma_cnci;
DELETE FROM tbl_configuracion_clave_cncl;
DELETE FROM tbl_configuracion_entorno_cnen;
DELETE FROM tbl_configuracion_idioma_cnid;

-- SELECT * FROM tbl_configuracion_idioma_cnid;
INSERT INTO tbl_configuracion_idioma_cnid (cnid_pk, cnid_codigo, cnid_descripcion) VALUES (30000, 'es_ES', 'Español (España)');
INSERT INTO tbl_configuracion_idioma_cnid (cnid_pk, cnid_codigo, cnid_descripcion) VALUES (30001, 'ca_ES', 'Catalan');

-- SELECT * FROM tbl_configuracion_entorno_cnen;
INSERT INTO tbl_configuracion_entorno_cnen (cnen_pk, cnen_cnid_pk, cnen_codigo, cnen_nombre) VALUES (31000, 30000, 'PC', 'PC de Casa');
INSERT INTO tbl_configuracion_entorno_cnen (cnen_pk, cnen_cnid_pk, cnen_codigo, cnen_nombre) VALUES (31001, 30000, 'PRTTL', 'Portatil de Casa');
INSERT INTO tbl_configuracion_entorno_cnen (cnen_pk, cnen_cnid_pk, cnen_codigo, cnen_nombre) VALUES (31002, 30000, 'PRTL', 'PC de Portel');

-- SELECT * FROM tbl_configuracion_clave_cncl ;
INSERT INTO tbl_configuracion_clave_cncl (cncl_pk, cncl_clave, cncl_tipo_valor, cncl_valor_defecto) VALUES (32000, 'test', 'TX', 'Valor de test por defecto');
INSERT INTO tbl_configuracion_clave_cncl (cncl_pk, cncl_clave, cncl_tipo_valor, cncl_valor_defecto) VALUES (32001, 'testBoolean', 'BO', 'true');
INSERT INTO tbl_configuracion_clave_cncl (cncl_pk, cncl_clave, cncl_tipo_valor, cncl_valor_defecto) VALUES (32002, 'testLong', 'NE', '1000');
INSERT INTO tbl_configuracion_clave_cncl (cncl_pk, cncl_clave, cncl_tipo_valor, cncl_valor_defecto) VALUES (32003, 'testDouble', 'ND', '1000.5');

-- SELECT * FROM tbl_configuracion_clave_idioma_cnci ;
INSERT INTO tbl_configuracion_clave_idioma_cnci (cnci_pk, cnci_clave, cnci_valor_defecto) VALUES (40000, 'test', 'Valor de idioma test por defecto');

-- SELECT * FROM tbl_configuracion_valor_cnvl;
INSERT INTO tbl_configuracion_valor_cnvl (cnvl_cnen_pk, cnvl_cncl_pk, cnvl_valor) VALUES (31000, 32000, 'Valor de test Para el PC de casa');

-- SELECT * FROM tbl_configuracion_valor_idioma_cnvi;
INSERT INTO tbl_configuracion_valor_idioma_cnvi (cnvi_cnid_pk, cnvi_cnci_pk, cnvi_valor) VALUES (30000, 40000, 'Valor de idioma de test para es_ES');


