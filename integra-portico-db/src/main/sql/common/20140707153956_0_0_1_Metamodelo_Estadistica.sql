-- // 0 0 1 Metamodelo Estadistica
-- Migration SQL that makes the change goes here.

-- engd
INSERT INTO tbl_entidad_grupo_dato_engd (engd_pk, engd_enti_pk, engd_orden) VALUES (32000, 23000, 1)\
INSERT INTO tbl_entidad_grupo_dato_engd (engd_pk, engd_enti_pk, engd_orden) VALUES (32001, 23001, 1)\
INSERT INTO tbl_entidad_grupo_dato_engd (engd_pk, engd_enti_pk, engd_orden) VALUES (32002, 23002, 1)\
INSERT INTO tbl_entidad_grupo_dato_engd (engd_pk, engd_enti_pk, engd_orden) VALUES (32003, 23003, 1)\
INSERT INTO tbl_entidad_grupo_dato_engd (engd_pk, engd_enti_pk, engd_orden) VALUES (32004, 23004, 1)\
INSERT INTO tbl_entidad_grupo_dato_engd (engd_pk, engd_enti_pk, engd_orden) VALUES (32005, 23005, 1)\
INSERT INTO tbl_entidad_grupo_dato_engd (engd_pk, engd_enti_pk, engd_orden) VALUES (32006, 23006, 1)\
INSERT INTO tbl_entidad_grupo_dato_engd (engd_pk, engd_enti_pk, engd_orden) VALUES (32007, 23007, 1)\

-- i18n (engd)
INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('engd', 'es', 32000, 'General')\
INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('engd', 'es', 32001, 'General')\
INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('engd', 'es', 32002, 'General')\
INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('engd', 'es', 32003, 'General')\
INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('engd', 'es', 32004, 'General')\
INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('engd', 'es', 32005, 'General')\
INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('engd', 'es', 32006, 'General')\
INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('engd', 'es', 32007, 'General')\

-- Actividad Pesquera
INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (33000, 23000, 45095, 1, 1, 1, 4, 1, 1, 1, NULL)\
INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (33001, 23000, 41060, 1, 1, 2, 2, 1, 1, 1, NULL)\
INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (33002, 23000, 41040, 1, 1, 3, 2, 1, 1, 1, NULL)\
INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (33003, 23000, 45070, 1, 2, 1, 4, 0, 1, 1, NULL)\
INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (33004, 23000, 45215, 1, 2, 2, 4, 0, 1, 1, NULL)\
INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (33005, 23000, 45110, 1, 2, 3, 4, 0, 1, 1, NULL)\
INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (33006, 23000, 45065, 1, 3, 1, 4, 0, 1, 1, NULL)\
INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (33007, 23000, 45035, 1, 3, 2, 4, 0, 1, 1, NULL)\

INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 33000, 'T. Captura')\
INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 33001, 'Kilos')\
INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 33002, 'Precio')\
INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 33003, 'T. Oper.')\
INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 33004, 'Especie')\
INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 33005, 'Arte')\
INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 33006, 'Zona')\
INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 33007, 'Vendedor')\

-- Agregacion de Escala
INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (33020, 23001, 45000, 1, 1, 1, 4, 1, 1, 1, NULL)\
INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (33021, 23001, 45230, 1, 1, 2, 4, 1, 1, 1, NULL)\
INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (33022, 23001, 45030, 1, 1, 3, 4, 1, 1, 1, NULL)\
INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (33023, 23001, 45235, 1, 2, 1, 4, 1, 1, 1, NULL)\
INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (33024, 23001, 45236, 1, 2, 2, 4, 1, 1, 1, NULL)\
INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (33025, 23001, 45005, 1, 2, 3, 4, 1, 1, 1, NULL)\
INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (33026, 23001, 41060, 1, 2, 3, 2, 1, 1, 1, NULL)\
INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (33027, 23001, 41061, 1, 2, 4, 2, 1, 1, 1, NULL)\
INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (33028, 23001, 45010, 1, 3, 1, 4, 0, 1, 1, NULL)\
INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (33029, 23001, 43115, 1, 3, 2, 4, 0, 1, 1, NULL)\
INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (33030, 23001, 45240, 1, 3, 3, 4, 0, 1, 1, NULL)\
INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (33031, 23001, 45245, 1, 4, 1, 4, 0, 1, 1, NULL)\
INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (33032, 23001, 45035, 1, 4, 2, 4, 0, 1, 1, NULL)\

INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 33020, 'T. Activ.')\
INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 33021, 'T. Buque GT')\
INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 33022, 'T. Buque')\
INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 33023, 'T. Nav. Entrada')\
INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 33024, 'T. Nav. Salida')\
INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 33025, 'País')\
INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 33026, 'Nº. Escalas')\
INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 33027, 'Nº. GTs')\
INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 33028, 'Buque')\
INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 33029, 'T. Estancia')\
INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 33030, 'Serv. Tráfico')\
INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 33031, 'Acuerdo')\
INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 33032, 'Consignatario')\

-- Agregacion de Superficie
INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (33040, 23002, 45260, 1, 1, 1, 4, 1, 1, 1, NULL)\
INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (33041, 23002, 45265, 1, 1, 2, 4, 1, 1, 1, NULL)\
INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (33042, 23002, 45115, 1, 1, 3, 4, 0, 1, 1, NULL)\
INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (33043, 23002, 45270, 1, 2, 1, 4, 0, 1, 1, NULL)\
INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (33044, 23002, 45035, 1, 2, 2, 4, 0, 1, 1, NULL)\
INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (33045, 23002, 41000, 1, 2, 3, 2, 0, 1, 1, NULL)\
INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (33046, 23002, 41060, 1, 2, 4, 2, 1, 1, 0, NULL)\

INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 33040, 'Zona Depósito')\
INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 33041, 'Unidad de Superficie')\
INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 33042, 'Tipo de Mercancia')\
INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 33043, 'T. Op. Superficie')\
INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 33044, 'Cliente')\
INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 33045, 'Ro-Ro')\
INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 33046, 'Unidades')\

-- Avituallamiento
INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (33060, 23003, 45275, 1, 1, 1, 4, 1, 1, 1, NULL)\
INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (33061, 23003, 41060, 1, 1, 2, 2, 1, 1, 1, NULL)\

INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 33060, 'T. Suministro')\
INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 33061, 'Toneladas')\

-- Buque Fondeo atraque
INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (33070, 23004, 45380, 1, 1, 1, 4, 1, 1, 1, NULL)\
INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (33071, 23004, 45035, 1, 1, 2, 4, 0, 1, 1, NULL)\
INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (33072, 23004, 45010, 1, 1, 3, 4, 0, 1, 1, NULL)\
INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (33073, 23004, 45240, 1, 2, 1, 4, 0, 1, 1, NULL)\
INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (33074, 23004, 45180, 1, 2, 2, 4, 0, 1, 1, NULL)\
INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (33075, 23004, 41060, 1, 3, 1, 2, 1, 1, 0, NULL)\
INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (33076, 23004, 41061, 1, 3, 2, 2, 1, 1, 0, NULL)\
INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (33077, 23004, 41062, 1, 3, 3, 2, 1, 1, 0, NULL)\
INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (33078, 23004, 41063, 1, 3, 4, 2, 1, 1, 0, NULL)\
INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (33079, 23004, 41064, 1, 3, 5, 2, 1, 1, 0, NULL)\

INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 33070, 'T. Atraque')\
INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 33071, 'Consignatario')\
INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 33072, 'Buque')\
INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 33073, 'Tráfico')\
INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 33074, 'Alineación')\
INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 33075, 'Nº Buques')\
INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 33076, 'Esloras')\
INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 33077, 'Esloras-Días')\
INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 33078, 'GTs')\
INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 33079, 'GTs-Días')\

-- Movimiento Mercancia
INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (33090, 23005, 43555, 1, 1, 1, 4, 1, 1, 1, NULL)\
INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (33091, 23005, 45055, 1, 1, 2, 4, 1, 1, 1, NULL)\
INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (33092, 23005, 45056, 1, 1, 3, 4, 1, 1, 1, NULL)\
INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (33093, 23005, 45180, 1, 2, 1, 4, 1, 1, 1, NULL)\
INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (33094, 23005, 45057, 1, 2, 2, 4, 1, 1, 1, NULL)\
INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (33095, 23005, 45058, 1, 2, 3, 4, 1, 1, 1, NULL)\
INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (33096, 23005, 45290, 1, 3, 1, 4, 1, 1, 1, NULL)\
INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (33097, 23005, 45235, 1, 3, 2, 4, 1, 1, 1, NULL)\
INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (33098, 23005, 45145, 1, 3, 3, 4, 1, 1, 1, NULL)\
INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (33099, 23005, 45300, 1, 4, 1, 4, 0, 1, 1, NULL)\
INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (33100, 23005, 43125, 1, 4, 2, 4, 1, 1, 1, NULL)\
INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (33101, 23005, 41000, 1, 4, 3, 2, 1, 1, 1, NULL)\
INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (33102, 23005, 41040, 1, 5, 1, 2, 1, 1, 1, NULL)\
INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (33103, 23005, 41060, 1, 5, 2, 2, 1, 1, 1, NULL)\
INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (33104, 23005, 41041, 1, 5, 3, 2, 1, 1, 1, NULL)\
INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (33105, 23005, 45035, 1, 6, 1, 4, 0, 1, 1, NULL)\
INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (33106, 23005, 45036, 1, 6, 2, 4, 0, 1, 1, NULL)\
INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (33107, 23005, 45010, 1, 6, 3, 4, 0, 1, 1, NULL)\
INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (33108, 23005, 45240, 1, 7, 1, 4, 0, 1, 1, NULL)\
INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (33109, 23005, 45245, 1, 7, 2, 4, 0, 1, 1, NULL)\
INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (33110, 23005, 45305, 1, 7, 3, 4, 0, 1, 1, NULL)\
INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (33111, 23005, 41020, 1, 8, 1, 4, 0, 1, 1, NULL)\

INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 33090, 'T. Operación BL')\
INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 33091, 'Puerto Carga')\
INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 33092, 'Puerto Descarga')\
INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 33093, 'Alineación')\
INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 33094, 'Origen')\
INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 33095, 'Destino')\
INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 33096, 'Mercancía')\
INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 33097, 'T. Navegación')\
INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 33098, 'U. Carga')\
INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 33099, 'Inst. Especial')\
INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 33100, 'T. Transporte')\
INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 33101, 'Ro-Ro')\
INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 33102, 'Toneladas')\
INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 33103, 'Unidades')\
INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 33104, 'TEUS')\
INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 33105, 'Estibador')\
INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 33106, 'Consignatario')\
INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 33107, 'Buque')\
INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 33108, 'Tráfico')\
INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 33109, 'Acuerdo')\
INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 33110, 'Terminal')\
INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 33111, 'T. Equipamiento')\

-- Movimiento de Mercancia EEE
INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (33120, 23006, 45055, 1, 1, 1, 4, 1, 1, 1, NULL)\
INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (33121, 23006, 45290, 1, 1, 2, 4, 1, 1, 1, NULL)\
INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (33122, 23006, 45145, 1, 1, 3, 4, 1, 1, 1, NULL)\
INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (33123, 23006, 45140, 1, 2, 1, 4, 1, 1, 1, NULL)\
INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (33124, 23006, 45170, 1, 2, 2, 4, 1, 1, 1, NULL)\
INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (33125, 23006, 43130, 1, 2, 3, 4, 1, 1, 1, NULL)\
INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (33126, 23006, 41000, 1, 3, 1, 2, 1, 1, 1, NULL)\
INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (33127, 23006, 41040, 1, 4, 1, 2, 1, 1, 1, NULL)\
INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (33128, 23006, 41060, 1, 4, 2, 2, 1, 1, 1, NULL)\
INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (33129, 23006, 41061, 1, 4, 3, 2, 1, 1, 1, NULL)\
INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (33130, 23006, 41062, 1, 4, 4, 2, 1, 1, 1, NULL)\
INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (33131, 23006, 41063, 1, 4, 5, 2, 1, 1, 1, NULL)\
INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (33132, 23006, 41064, 1, 4, 6, 2, 1, 1, 1, NULL)\

INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 33120, 'Puerto Carga-Descarga')\
INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 33121, 'Mercancía')\
INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 33122, 'U.C.')\
INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 33123, 'G. NST')\
INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 33124, 'Reg. T. Buque EEE')\
INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 33125, 'Dir. Mercancía')\
INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 33126, 'Ro-Ro')\
INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 33127, 'Toneladas')\
INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 33128, 'PAX')\
INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 33129, 'PAX Crucero')\
INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 33130, 'PAX I-F')\
INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 33131, 'U.C. Llenas')\
INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 33132, 'U.C. Vacias')\

-- Movimiento Tipo Buque EEE
INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (33140, 23007, 45020, 1, 1, 1, 4, 1, 1, 1, NULL)\
INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (33141, 23007, 45445, 1, 1, 2, 4, 1, 1, 1, NULL)\
INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (33142, 23007, 41060, 1, 1, 3, 2, 1, 1, 1, NULL)\
INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (33143, 23007, 41061, 1, 1, 4, 2, 1, 1, 1, NULL)\

INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 33140, 'T. Buque EEE')\
INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 33141, 'T. Buque GT EEE')\
INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 33142, 'No. Buques')\
INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 33143, 'No. GTs')\




-- Campos de Agregacion de estadisticas
INSERT INTO tbl_campo_agregacion_cmag (cmag_tpes_pk, cmag_entd_pk, cmag_agregar, cmag_nombre) VALUES (23000, 33003, 1, 'tipoOperacion')\
INSERT INTO tbl_campo_agregacion_cmag (cmag_tpes_pk, cmag_entd_pk, cmag_agregar, cmag_nombre) VALUES (23000, 33006, 1, 'zonaPesca')\
INSERT INTO tbl_campo_agregacion_cmag (cmag_tpes_pk, cmag_entd_pk, cmag_agregar, cmag_nombre) VALUES (23000, 33005, 1, 'artePesca')\
INSERT INTO tbl_campo_agregacion_cmag (cmag_tpes_pk, cmag_entd_pk, cmag_agregar, cmag_nombre) VALUES (23000, 33007, 1, 'vendedor')\
INSERT INTO tbl_campo_agregacion_cmag (cmag_tpes_pk, cmag_entd_pk, cmag_agregar, cmag_nombre) VALUES (23000, 33004, 1, 'especie')\

INSERT INTO tbl_campo_agregacion_cmag (cmag_tpes_pk, cmag_entd_pk, cmag_agregar, cmag_nombre) VALUES (23001, 33028, 1, 'buque')\
INSERT INTO tbl_campo_agregacion_cmag (cmag_tpes_pk, cmag_entd_pk, cmag_agregar, cmag_nombre) VALUES (23001, 33029, 1, 'tipoEstancia')\
INSERT INTO tbl_campo_agregacion_cmag (cmag_tpes_pk, cmag_entd_pk, cmag_agregar, cmag_nombre) VALUES (23001, 33030, 1, 'servicio')\
INSERT INTO tbl_campo_agregacion_cmag (cmag_tpes_pk, cmag_entd_pk, cmag_agregar, cmag_nombre) VALUES (23001, 33031, 1, 'acuerdo')\
INSERT INTO tbl_campo_agregacion_cmag (cmag_tpes_pk, cmag_entd_pk, cmag_agregar, cmag_nombre) VALUES (23001, 33032, 1, 'consignatario')\

INSERT INTO tbl_campo_agregacion_cmag (cmag_tpes_pk, cmag_entd_pk, cmag_agregar, cmag_nombre) VALUES (23002, 33042, 1, 'tipoMercancia')\
INSERT INTO tbl_campo_agregacion_cmag (cmag_tpes_pk, cmag_entd_pk, cmag_agregar, cmag_nombre) VALUES (23002, 33043, 1, 'tipoOperacion')\
INSERT INTO tbl_campo_agregacion_cmag (cmag_tpes_pk, cmag_entd_pk, cmag_agregar, cmag_nombre) VALUES (23002, 33044, 1, 'cliente')\
INSERT INTO tbl_campo_agregacion_cmag (cmag_tpes_pk, cmag_entd_pk, cmag_agregar, cmag_nombre) VALUES (23002, 33045, 1, 'roro')\

INSERT INTO tbl_campo_agregacion_cmag (cmag_tpes_pk, cmag_entd_pk, cmag_agregar, cmag_nombre) VALUES (23004, 33071, 1, 'consignatario')\
INSERT INTO tbl_campo_agregacion_cmag (cmag_tpes_pk, cmag_entd_pk, cmag_agregar, cmag_nombre) VALUES (23004, 33072, 1, 'buque')\
INSERT INTO tbl_campo_agregacion_cmag (cmag_tpes_pk, cmag_entd_pk, cmag_agregar, cmag_nombre) VALUES (23004, 33073, 1, 'servicio')\
INSERT INTO tbl_campo_agregacion_cmag (cmag_tpes_pk, cmag_entd_pk, cmag_agregar, cmag_nombre) VALUES (23004, 33074, 1, 'alineacion')\

INSERT INTO tbl_campo_agregacion_cmag (cmag_tpes_pk, cmag_entd_pk, cmag_agregar, cmag_nombre) VALUES (23005, 33106, 1, 'consignatario')\
INSERT INTO tbl_campo_agregacion_cmag (cmag_tpes_pk, cmag_entd_pk, cmag_agregar, cmag_nombre) VALUES (23005, 33107, 1, 'buque')\
INSERT INTO tbl_campo_agregacion_cmag (cmag_tpes_pk, cmag_entd_pk, cmag_agregar, cmag_nombre) VALUES (23005, 33108, 1, 'servicio')\
INSERT INTO tbl_campo_agregacion_cmag (cmag_tpes_pk, cmag_entd_pk, cmag_agregar, cmag_nombre) VALUES (23005, 33105, 1, 'estibador')\
INSERT INTO tbl_campo_agregacion_cmag (cmag_tpes_pk, cmag_entd_pk, cmag_agregar, cmag_nombre) VALUES (23005, 33109, 1, 'acuerdo')\
INSERT INTO tbl_campo_agregacion_cmag (cmag_tpes_pk, cmag_entd_pk, cmag_agregar, cmag_nombre) VALUES (23005, 33110, 1, 'terminal')\
INSERT INTO tbl_campo_agregacion_cmag (cmag_tpes_pk, cmag_entd_pk, cmag_agregar, cmag_nombre) VALUES (23005, 33111, 1, 'tipoEquipamiento')\


-- //@UNDO
-- SQL to undo the change goes here.
