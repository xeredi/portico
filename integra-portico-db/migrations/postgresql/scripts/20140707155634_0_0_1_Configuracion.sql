-- // 0 0 1 Configuracion
-- Migration SQL that makes the change goes here.

-- SELECT * FROM portico.tbl_configuracion_idioma_cnid
INSERT INTO portico.tbl_configuracion_idioma_cnid (cnid_pk, cnid_codigo, cnid_descripcion) VALUES (30000, 'es_ES', 'Español (España)')\
INSERT INTO portico.tbl_configuracion_idioma_cnid (cnid_pk, cnid_codigo, cnid_descripcion) VALUES (30001, 'ca_ES', 'Catalán')\

-- SELECT * FROM portico.tbl_configuracion_entorno_cnen
INSERT INTO portico.tbl_configuracion_entorno_cnen (cnen_pk, cnen_codigo, cnen_nombre) VALUES (31000, 'PC', 'PC de Casa')\
INSERT INTO portico.tbl_configuracion_entorno_cnen (cnen_pk, cnen_codigo, cnen_nombre) VALUES (31001, 'PRTTL', 'Portátil de Casa')\
INSERT INTO portico.tbl_configuracion_entorno_cnen (cnen_pk, cnen_codigo, cnen_nombre) VALUES (31002, 'PRTL', 'PC de Portel')\

-- SELECT * FROM portico.tbl_conf_clave_cncl
INSERT INTO portico.tbl_conf_clave_cncl (cncl_pk, cncl_clave, cncl_tipo_valor, cncl_valor_defecto) VALUES (32000, 'test', 'TX', 'Valor de test por defecto')\
INSERT INTO portico.tbl_conf_clave_cncl (cncl_pk, cncl_clave, cncl_tipo_valor, cncl_valor_defecto) VALUES (32001, 'testBoolean', 'BO', 'true')\
INSERT INTO portico.tbl_conf_clave_cncl (cncl_pk, cncl_clave, cncl_tipo_valor, cncl_valor_defecto) VALUES (32002, 'testLong', 'NE', '1000')\
INSERT INTO portico.tbl_conf_clave_cncl (cncl_pk, cncl_clave, cncl_tipo_valor, cncl_valor_defecto) VALUES (32003, 'testDouble', 'ND', '1000.5')\

-- SELECT * FROM portico.tbl_conf_clave_i18n_cnci
INSERT INTO portico.tbl_conf_clave_i18n_cnci (cnci_pk, cnci_clave, cnci_valor_defecto) VALUES (40000, 'test', 'Valor de idioma test por defecto')\

-- SELECT * FROM portico.tbl_configuracion_valor_cnvl
INSERT INTO portico.tbl_configuracion_valor_cnvl (cnvl_cnen_pk, cnvl_cncl_pk, cnvl_valor) VALUES (31000, 32000, 'Valor de test Para el PC de casa')\

-- SELECT * FROM portico.tbl_conf_valor_i18n_cnvi
INSERT INTO portico.tbl_conf_valor_i18n_cnvi (cnvi_cnid_pk, cnvi_cnci_pk, cnvi_valor) VALUES (30000, 40000, 'Valor de idioma de test para es_ES')\


-- //@UNDO
-- SQL to undo the change goes here.

DELETE FROM portico.tbl_conf_valor_i18n_cnvi\
DELETE FROM portico.tbl_configuracion_valor_cnvl\
DELETE FROM portico.tbl_conf_clave_i18n_cnci\
DELETE FROM portico.tbl_conf_clave_cncl\
DELETE FROM portico.tbl_configuracion_entorno_cnen\
DELETE FROM portico.tbl_configuracion_idioma_cnid\


