-- // 0_0_1 Load Entidad TipoDato
-- Migration SQL that makes the change goes here.

-- Secuencias
INSERT INTO portico.tbl_ig(ig_nombre, ig_inicio, ig_fin, ig_incremento, ig_cache, ig_ultimo)
VALUES ('sq_integra', 1000000, NULL, 1, 1000, 1000000)\

-- Tipos de Dato - Simples
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (41000, 'CB', 'BO', NULL , 'BOOLEANO_01')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (41001, 'CB', 'BO', NULL , 'BOOLEANO_02')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (41002, 'CB', 'BO', NULL , 'BOOLEANO_03')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (41003, 'CB', 'BO', NULL , 'BOOLEANO_04')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (41004, 'CB', 'BO', NULL , 'BOOLEANO_05')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (41005, 'CB', 'BO', NULL , 'BOOLEANO_06')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (41006, 'CB', 'BO', NULL , 'BOOLEANO_07')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (41007, 'CB', 'BO', NULL , 'BOOLEANO_08')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (41008, 'CB', 'BO', NULL , 'BOOLEANO_09')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (41009, 'CB', 'BO', NULL , 'BOOLEANO_10')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (41010, 'CB', 'BO', NULL , 'BOOLEANO_11')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (41011, 'CB', 'BO', NULL , 'BOOLEANO_12')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (41012, 'CB', 'BO', NULL , 'BOOLEANO_13')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (41013, 'CB', 'BO', NULL , 'BOOLEANO_14')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (41014, 'CB', 'BO', NULL , 'BOOLEANO_15')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (41015, 'CB', 'BO', NULL , 'BOOLEANO_16')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (41016, 'CB', 'BO', NULL , 'BOOLEANO_17')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (41017, 'CB', 'BO', NULL , 'BOOLEANO_18')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (41018, 'CB', 'BO', NULL , 'BOOLEANO_19')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (41019, 'CB', 'BO', NULL , 'BOOLEANO_20')\

INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 41000, 'Booleano 01')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 41001, 'Booleano 02')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 41002, 'Booleano 03')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 41003, 'Booleano 04')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 41004, 'Booleano 05')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 41005, 'Booleano 06')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 41006, 'Booleano 07')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 41007, 'Booleano 08')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 41008, 'Booleano 09')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 41009, 'Booleano 10')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 41010, 'Booleano 11')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 41011, 'Booleano 12')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 41012, 'Booleano 13')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 41013, 'Booleano 14')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 41014, 'Booleano 15')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 41015, 'Booleano 16')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 41016, 'Booleano 17')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 41017, 'Booleano 18')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 41018, 'Booleano 19')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 41019, 'Booleano 20')\

INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (41020,  'T', 'TX', NULL , 'CADENA_01')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (41021,  'T', 'TX', NULL , 'CADENA_02')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (41022,  'T', 'TX', NULL , 'CADENA_03')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (41023,  'T', 'TX', NULL , 'CADENA_04')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (41024,  'T', 'TX', NULL , 'CADENA_05')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (41025,  'T', 'TX', NULL , 'CADENA_06')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (41026,  'T', 'TX', NULL , 'CADENA_07')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (41027,  'T', 'TX', NULL , 'CADENA_08')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (41028,  'T', 'TX', NULL , 'CADENA_09')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (41029,  'T', 'TX', NULL , 'CADENA_10')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (41030,  'T', 'TX', NULL , 'CADENA_11')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (41031,  'T', 'TX', NULL , 'CADENA_12')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (41032,  'T', 'TX', NULL , 'CADENA_13')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (41033,  'T', 'TX', NULL , 'CADENA_14')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (41034,  'T', 'TX', NULL , 'CADENA_15')\

INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 41020, 'Cadena 01')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 41021, 'Cadena 02')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 41022, 'Cadena 03')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 41023, 'Cadena 04')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 41024, 'Cadena 05')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 41025, 'Cadena 06')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 41026, 'Cadena 07')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 41027, 'Cadena 08')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 41028, 'Cadena 09')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 41029, 'Cadena 10')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 41030, 'Cadena 11')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 41031, 'Cadena 12')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 41032, 'Cadena 13')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 41033, 'Cadena 14')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 41034, 'Cadena 15')\

INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (41040,  'T', 'ND', NULL , 'DECIMAL_01')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (41041,  'T', 'ND', NULL , 'DECIMAL_02')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (41042,  'T', 'ND', NULL , 'DECIMAL_03')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (41043,  'T', 'ND', NULL , 'DECIMAL_04')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (41044,  'T', 'ND', NULL , 'DECIMAL_05')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (41045,  'T', 'ND', NULL , 'DECIMAL_06')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (41046,  'T', 'ND', NULL , 'DECIMAL_07')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (41047,  'T', 'ND', NULL , 'DECIMAL_08')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (41048,  'T', 'ND', NULL , 'DECIMAL_09')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (41049,  'T', 'ND', NULL , 'DECIMAL_10')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (41050,  'T', 'ND', NULL , 'DECIMAL_11')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (41051,  'T', 'ND', NULL , 'DECIMAL_12')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (41052,  'T', 'ND', NULL , 'DECIMAL_13')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (41053,  'T', 'ND', NULL , 'DECIMAL_14')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (41054,  'T', 'ND', NULL , 'DECIMAL_15')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (41055,  'T', 'ND', NULL , 'DECIMAL_16')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (41056,  'T', 'ND', NULL , 'DECIMAL_17')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (41057,  'T', 'ND', NULL , 'DECIMAL_18')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (41058,  'T', 'ND', NULL , 'DECIMAL_19')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (41059,  'T', 'ND', NULL , 'DECIMAL_20')\

INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 41040, 'Decimal 01')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 41041, 'Decimal 02')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 41042, 'Decimal 03')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 41043, 'Decimal 04')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 41044, 'Decimal 05')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 41045, 'Decimal 06')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 41046, 'Decimal 07')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 41047, 'Decimal 08')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 41048, 'Decimal 09')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 41049, 'Decimal 10')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 41050, 'Decimal 11')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 41051, 'Decimal 12')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 41052, 'Decimal 13')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 41053, 'Decimal 14')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 41054, 'Decimal 15')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 41055, 'Decimal 16')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 41056, 'Decimal 17')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 41057, 'Decimal 18')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 41058, 'Decimal 19')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 41059, 'Decimal 20')\

INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (41060,  'T', 'NE', NULL , 'ENTERO_01')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (41061,  'T', 'NE', NULL , 'ENTERO_02')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (41062,  'T', 'NE', NULL , 'ENTERO_03')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (41063,  'T', 'NE', NULL , 'ENTERO_04')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (41064,  'T', 'NE', NULL , 'ENTERO_05')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (41065,  'T', 'NE', NULL , 'ENTERO_06')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (41066,  'T', 'NE', NULL , 'ENTERO_07')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (41067,  'T', 'NE', NULL , 'ENTERO_08')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (41068,  'T', 'NE', NULL , 'ENTERO_09')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (41069,  'T', 'NE', NULL , 'ENTERO_10')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (41070,  'T', 'NE', NULL , 'ENTERO_11')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (41071,  'T', 'NE', NULL , 'ENTERO_12')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (41072,  'T', 'NE', NULL , 'ENTERO_13')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (41073,  'T', 'NE', NULL , 'ENTERO_14')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (41074,  'T', 'NE', NULL , 'ENTERO_15')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (41075,  'T', 'NE', NULL , 'ENTERO_16')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (41076,  'T', 'NE', NULL , 'ENTERO_17')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (41077,  'T', 'NE', NULL , 'ENTERO_18')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (41078,  'T', 'NE', NULL , 'ENTERO_19')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (41079,  'T', 'NE', NULL , 'ENTERO_20')\

INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 41060, 'Entero 01')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 41061, 'Entero 02')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 41062, 'Entero 03')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 41063, 'Entero 04')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 41064, 'Entero 05')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 41065, 'Entero 06')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 41066, 'Entero 07')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 41067, 'Entero 08')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 41068, 'Entero 09')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 41069, 'Entero 10')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 41070, 'Entero 11')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 41071, 'Entero 12')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 41072, 'Entero 13')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 41073, 'Entero 14')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 41074, 'Entero 15')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 41075, 'Entero 16')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 41076, 'Entero 17')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 41077, 'Entero 18')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 41078, 'Entero 19')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 41079, 'Entero 20')\

INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (41080, 'TA', 'TX', NULL , 'TEXTO_01')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (41081, 'TA', 'TX', NULL , 'TEXTO_02')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (41082, 'TA', 'TX', NULL , 'TEXTO_03')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (41083, 'TA', 'TX', NULL , 'TEXTO_04')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (41084, 'TA', 'TX', NULL , 'TEXTO_05')\

INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 41080, 'Texto 01')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 41081, 'Texto 02')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 41082, 'Texto 03')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 41083, 'Texto 04')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 41084, 'Texto 05')\

INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (41100,  'D', 'FE', NULL , 'FECHA_01')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (41101,  'D', 'FE', NULL , 'FECHA_02')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (41102,  'D', 'FE', NULL , 'FECHA_03')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (41103,  'D', 'FE', NULL , 'FECHA_04')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (41104,  'D', 'FE', NULL , 'FECHA_05')\

INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 41100, 'Fecha 01')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 41101, 'Fecha 02')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 41102, 'Fecha 03')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 41103, 'Fecha 04')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 41104, 'Fecha 05')\

INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (41120, 'DT', 'FH', NULL , 'FECHAHORA_01')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (41121, 'DT', 'FH', NULL , 'FECHAHORA_02')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (41122, 'DT', 'FH', NULL , 'FECHAHORA_03')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (41123, 'DT', 'FH', NULL , 'FECHAHORA_04')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (41124, 'DT', 'FH', NULL , 'FECHAHORA_05')\

INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 41120, 'Fecha-Hora 01')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 41121, 'Fecha-Hora 02')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 41122, 'Fecha-Hora 03')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 41123, 'Fecha-Hora 04')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 41124, 'Fecha-Hora 05')\



-- Tipos de Dato - Codigos de Referencia
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43000, 'S', 'CR', NULL , 'COD_EXEN')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43000, 'Código de Exención')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (50000, portico.getTipoDato('COD_EXEN'), '0', 1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (50001, portico.getTipoDato('COD_EXEN'), '1', 2)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (50002, portico.getTipoDato('COD_EXEN'), '2', 3)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (50003, portico.getTipoDato('COD_EXEN'), '3', 4)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (50004, portico.getTipoDato('COD_EXEN'), '4', 5)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43005, 'S', 'CR', NULL , 'INDIC_VENTA')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43005, 'Indicador de Venta (Pesca)')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (50050, portico.getTipoDato('INDIC_VENTA'), 'P', 1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (50051, portico.getTipoDato('INDIC_VENTA'), 'S', 2)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43010, 'T', 'CR', NULL , 'TIPO_GARANTIA')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43010, 'Tipo de Garantía')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (50100, portico.getTipoDato('TIPO_GARANTIA'), 'PRV', 1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (50101, portico.getTipoDato('TIPO_GARANTIA'), 'POB', 2)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (50102, portico.getTipoDato('TIPO_GARANTIA'), 'PEX', 3)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (50103, portico.getTipoDato('TIPO_GARANTIA'), 'DOB', 4)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (50104, portico.getTipoDato('TIPO_GARANTIA'), 'DEX', 5)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (50105, portico.getTipoDato('TIPO_GARANTIA'), 'OTR', 6)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (50106, portico.getTipoDato('TIPO_GARANTIA'), 'SUS', 7)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43015, 'T', 'CR', NULL , 'CLASE_GARANTIA')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43015, 'Clase de Garantía')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (50150, portico.getTipoDato('CLASE_GARANTIA'), 'A', 1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (50151, portico.getTipoDato('CLASE_GARANTIA'), 'C', 2)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (50152, portico.getTipoDato('CLASE_GARANTIA'), 'D', 3)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (50153, portico.getTipoDato('CLASE_GARANTIA'), 'F', 4)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (50154, portico.getTipoDato('CLASE_GARANTIA'), 'V', 5)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43020, 'T', 'CR', NULL , 'ANEXO_MARPOL')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43020, 'Anexo Marpol')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (50200, portico.getTipoDato('ANEXO_MARPOL'), 'I', 1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (50201, portico.getTipoDato('ANEXO_MARPOL'), 'II', 2)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (50202, portico.getTipoDato('ANEXO_MARPOL'), 'III', 3)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (50203, portico.getTipoDato('ANEXO_MARPOL'), 'IV', 4)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (50204, portico.getTipoDato('ANEXO_MARPOL'), 'V', 5)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (50205, portico.getTipoDato('ANEXO_MARPOL'), 'VI', 6)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43025, 'T', 'CR', NULL , 'PRESENT_TIPO_RES')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43025, 'Presentación de Tipo de Residuo')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (50250, portico.getTipoDato('PRESENT_TIPO_RES'), 'S', 1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (50251, portico.getTipoDato('PRESENT_TIPO_RES'), 'L', 2)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43030, 'S', 'CR', NULL , 'IDIOMA_APLICACION')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43030, 'Idioma de la Aplicación')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (50300, portico.getTipoDato('IDIOMA_APLICACION'), 'es_ES', 1)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43035, 'S', 'CR', NULL , 'TIPO_DOCUMENTO')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43035, 'Tipo de Documento')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (50350, portico.getTipoDato('TIPO_DOCUMENTO'), 'CIF', 1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (50351, portico.getTipoDato('TIPO_DOCUMENTO'), 'NIF', 2)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (50352, portico.getTipoDato('TIPO_DOCUMENTO'), 'PAS', 3)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (50353, portico.getTipoDato('TIPO_DOCUMENTO'), 'NIE', 4)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (50354, portico.getTipoDato('TIPO_DOCUMENTO'), 'OTR', 5)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43040, 'S', 'CR', NULL , 'TIPO_BASE_ORGA')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43040, 'Tipo Base de Organización')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (50400, portico.getTipoDato('TIPO_BASE_ORGA'), 'ADUANA',  1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (50401, portico.getTipoDato('TIPO_BASE_ORGA'), 'APORTU',  2)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (50402, portico.getTipoDato('TIPO_BASE_ORGA'), 'ARMADO',  3)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (50403, portico.getTipoDato('TIPO_BASE_ORGA'), 'CONCES',  4)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (50404, portico.getTipoDato('TIPO_BASE_ORGA'), 'COFRAD',  5)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (50405, portico.getTipoDato('TIPO_BASE_ORGA'), 'CONSIG',  6)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (50406, portico.getTipoDato('TIPO_BASE_ORGA'), 'NINGUN',  7)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (50407, portico.getTipoDato('TIPO_BASE_ORGA'), 'PATDEP',  8)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (50408, portico.getTipoDato('TIPO_BASE_ORGA'), 'PATPES',  9)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (50409, portico.getTipoDato('TIPO_BASE_ORGA'), 'TALLER', 10)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (50410, portico.getTipoDato('TIPO_BASE_ORGA'), 'TRANSE', 11)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (50411, portico.getTipoDato('TIPO_BASE_ORGA'), 'TRANSI', 12)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43045, 'S', 'CR', NULL , 'TIPO_RED')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43045, 'Tipo de Red')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (50450, portico.getTipoDato('TIPO_RED'), 'E',  1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (50451, portico.getTipoDato('TIPO_RED'), 'A',  2)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (50452, portico.getTipoDato('TIPO_RED'), 'G',  3)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (50453, portico.getTipoDato('TIPO_RED'), 'O',  4)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43050, 'S', 'CR', NULL , 'SUBTIPO_RED')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43050, 'Subtipo de Red')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (50500, portico.getTipoDato('SUBTIPO_RED'), 'TB',  1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (50501, portico.getTipoDato('SUBTIPO_RED'), 'TA',  2)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (50502, portico.getTipoDato('SUBTIPO_RED'), 'TM',  3)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (50503, portico.getTipoDato('SUBTIPO_RED'), 'AP',  4)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (50504, portico.getTipoDato('SUBTIPO_RED'), 'AR',  5)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43055, 'S', 'CR', NULL , 'ESTADO_PRED')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43055, 'Estado de Punto de Red')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (50550, portico.getTipoDato('ESTADO_PRED'), 'D',  1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (50551, portico.getTipoDato('ESTADO_PRED'), 'N',  2)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43060, 'S', 'CR', NULL , 'UNID_MED_SBT')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43060, 'Unidad de Medida SBT Buque')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (50600, portico.getTipoDato('UNID_MED_SBT'), 'GT',  1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (50601, portico.getTipoDato('UNID_MED_SBT'), 'M3',  2)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43065, 'S', 'CR', NULL , 'ESTADO_MAN_PESC')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43065, 'Estado de Manifiesto de Pesca')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (50650, portico.getTipoDato('ESTADO_MAN_PESC'), 'R',  1)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43070, 'S', 'CR', NULL , 'ESTADO_MAN_MERC')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43070, 'Estado de Manifiesto de Mercancía')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (50700, portico.getTipoDato('ESTADO_MAN_MERC'), 'A',  1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (50701, portico.getTipoDato('ESTADO_MAN_MERC'), 'B',  2)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (50702, portico.getTipoDato('ESTADO_MAN_MERC'), 'C',  3)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (50703, portico.getTipoDato('ESTADO_MAN_MERC'), 'I',  4)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (50704, portico.getTipoDato('ESTADO_MAN_MERC'), 'S',  5)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43075, 'S', 'CR', NULL , 'ESTADO_PART')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43075, 'Estado de Partida')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (50750, portico.getTipoDato('ESTADO_PART'), 'A',  1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (50751, portico.getTipoDato('ESTADO_PART'), 'B',  2)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (50752, portico.getTipoDato('ESTADO_PART'), 'R',  3)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43080, 'S', 'CR', NULL , 'ESTADO_EQUI')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43080, 'Estado de Equipamiento')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (50800, portico.getTipoDato('ESTADO_EQUI'), 'A',  1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (50801, portico.getTipoDato('ESTADO_EQUI'), 'B',  2)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (50802, portico.getTipoDato('ESTADO_EQUI'), 'R',  3)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43085, 'S', 'CR', NULL , 'ESTADO_BL')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43085, 'Estado de BL')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (50850, portico.getTipoDato('ESTADO_BL'), 'A',  1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (50851, portico.getTipoDato('ESTADO_BL'), 'B',  2)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (50852, portico.getTipoDato('ESTADO_BL'), 'C',  3)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (50853, portico.getTipoDato('ESTADO_BL'), 'I',  4)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (50854, portico.getTipoDato('ESTADO_BL'), 'S',  5)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43090, 'S', 'CR', NULL , 'DEST_PART_PESCA')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43090, 'Destino de Partida de Pesca')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (50900, portico.getTipoDato('DEST_PART_PESCA'), 'H',  1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (50901, portico.getTipoDato('DEST_PART_PESCA'), 'I',  2)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43100, 'S', 'CR', NULL , 'TIPO_MANIF')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43100, 'Tipo de Manifiesto')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (50950, portico.getTipoDato('TIPO_MANIF'), 'M',  1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (50951, portico.getTipoDato('TIPO_MANIF'), 'P',  2)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43105, 'S', 'CR', NULL , 'TIPO_MANIF_EDI')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43105, 'Tipo de Manifiesto EDI')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (51000, portico.getTipoDato('TIPO_MANIF_EDI'), 'DE',  1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (51001, portico.getTipoDato('TIPO_MANIF_EDI'), 'SC',  2)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (51002, portico.getTipoDato('TIPO_MANIF_EDI'), 'SD',  3)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (51003, portico.getTipoDato('TIPO_MANIF_EDI'), 'CL',  4)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (51004, portico.getTipoDato('TIPO_MANIF_EDI'), 'DL',  5)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (51005, portico.getTipoDato('TIPO_MANIF_EDI'), 'CA',  6)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43110, 'S', 'CR', NULL , 'TIPO_OPER_MANIF')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43110, 'Tipo de Operación de Manifiesto')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (51050, portico.getTipoDato('TIPO_OPER_MANIF'), 'C',  1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (51051, portico.getTipoDato('TIPO_OPER_MANIF'), 'D',  2)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (51052, portico.getTipoDato('TIPO_OPER_MANIF'), 'T',  3)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43115, 'S', 'CR', NULL , 'TIPO_ESTAN_ESC')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43115, 'Tipo de Estancia de Escala')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (51100, portico.getTipoDato('TIPO_ESTAN_ESC'), 'C',  1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (51101, portico.getTipoDato('TIPO_ESTAN_ESC'), 'L',  2)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (51102, portico.getTipoDato('TIPO_ESTAN_ESC'), 'M',  3)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43120, 'S', 'CR', NULL , 'TIPO_ESTAN_ATR')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43120, 'Tipo de Estancia de Atraque')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (51150, portico.getTipoDato('TIPO_ESTAN_ATR'), 'C',  1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (51151, portico.getTipoDato('TIPO_ESTAN_ATR'), 'L',  2)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43125, 'S', 'CR', NULL , 'TIPO_TRANSPORTE')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43125, 'Tipo de Transporte')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (51300, portico.getTipoDato('TIPO_TRANSPORTE'), 'ZZ',  1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (51301, portico.getTipoDato('TIPO_TRANSPORTE'), 'AE',  2)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (51302, portico.getTipoDato('TIPO_TRANSPORTE'), 'CA',  3)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (51303, portico.getTipoDato('TIPO_TRANSPORTE'), 'FE',  4)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (51304, portico.getTipoDato('TIPO_TRANSPORTE'), 'MA',  5)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (51305, portico.getTipoDato('TIPO_TRANSPORTE'), 'OL',  6)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (51306, portico.getTipoDato('TIPO_TRANSPORTE'), 'OT',  7)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (51307, portico.getTipoDato('TIPO_TRANSPORTE'), 'ST',  8)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (51308, portico.getTipoDato('TIPO_TRANSPORTE'), 'TU',  9)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43130, 'S', 'CR', NULL , 'DIREC_MERC')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43130, 'Dirección de la Mercancía')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (51350, portico.getTipoDato('DIREC_MERC'), 'E',  1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (51351, portico.getTipoDato('DIREC_MERC'), 'S',  2)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43135, 'S', 'CR', NULL , 'TIPO_BL')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43135, 'Tipo de BL')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (51400, portico.getTipoDato('TIPO_BL'), 'P',  1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (51401, portico.getTipoDato('TIPO_BL'), 'M',  2)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (51402, portico.getTipoDato('TIPO_BL'), 'V',  3)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43140, 'S', 'CR', NULL , 'ACC_PET_AMARRE')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43140, 'Acción de Petición de Amarre')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (51450, portico.getTipoDato('ACC_PET_AMARRE'), 'AB',  1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (51451, portico.getTipoDato('ACC_PET_AMARRE'), 'AS',  2)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (51452, portico.getTipoDato('ACC_PET_AMARRE'), 'BA',  3)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (51453, portico.getTipoDato('ACC_PET_AMARRE'), 'BN',  4)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (51454, portico.getTipoDato('ACC_PET_AMARRE'), 'CE',  5)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (51455, portico.getTipoDato('ACC_PET_AMARRE'), 'CT',  6)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (51456, portico.getTipoDato('ACC_PET_AMARRE'), 'DE',  7)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (51457, portico.getTipoDato('ACC_PET_AMARRE'), 'DN',  8)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (51458, portico.getTipoDato('ACC_PET_AMARRE'), 'FD',  9)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (51459, portico.getTipoDato('ACC_PET_AMARRE'), 'LC', 10)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (51460, portico.getTipoDato('ACC_PET_AMARRE'), 'LP', 11)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (51461, portico.getTipoDato('ACC_PET_AMARRE'), 'OT', 12)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (51462, portico.getTipoDato('ACC_PET_AMARRE'), 'RE', 13)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (51463, portico.getTipoDato('ACC_PET_AMARRE'), 'RN', 14)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (51464, portico.getTipoDato('ACC_PET_AMARRE'), 'VA', 15)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (51465, portico.getTipoDato('ACC_PET_AMARRE'), 'VI', 16)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43145, 'S', 'CR', NULL , 'CERTIF_EDI')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43145, 'Certificados EDI')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (51500, portico.getTipoDato('CERTIF_EDI'), 'ZGS',  1)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43150, 'S', 'CR', NULL , 'COND_TANQUE')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43150, 'Condición de Tanque')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (51550, portico.getTipoDato('COND_TANQUE'), 'I',  1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (51551, portico.getTipoDato('COND_TANQUE'), 'L',  2)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (51552, portico.getTipoDato('COND_TANQUE'), 'V',  3)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43155, 'S', 'CR', NULL , 'CONT_BUQUE')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43155, 'Contador de Buque')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (51600, portico.getTipoDato('CONT_BUQUE'), 'ES',  1)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43160, 'S', 'CR', NULL , 'CONT_ESCALA')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43160, 'Contador de Escala')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (51650, portico.getTipoDato('CONT_ESCALA'), 'ES',  1)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43165, 'S', 'CR', NULL , 'CONT_TRAFICO')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43165, 'Contador de Servicio de Tráfico')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (51700, portico.getTipoDato('CONT_TRAFICO'), 'ES',  1)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43170, 'S', 'CR', NULL , 'CONVENIO_EDI')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43170, 'Convenio EDI')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (51750, portico.getTipoDato('CONVENIO_EDI'), 'ZCC',  1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (51751, portico.getTipoDato('CONVENIO_EDI'), 'ZGA',  2)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43175, 'S', 'CR', NULL , 'CREACION')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43175, 'Creación')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (51800, portico.getTipoDato('CREACION'), 'A',  1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (51801, portico.getTipoDato('CREACION'), 'M',  2)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43180, 'S', 'CR', NULL , 'ENT_AGREG')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43180, 'Entidad de Agregación')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (51850, portico.getTipoDato('ENT_AGREG'), 'Buque',  1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (51851, portico.getTipoDato('ENT_AGREG'), 'Escala',  2)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (51852, portico.getTipoDato('ENT_AGREG'), 'Mercancia',  3)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (51853, portico.getTipoDato('ENT_AGREG'), 'Pesca',  4)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (51854, portico.getTipoDato('ENT_AGREG'), 'Superficie',  5)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43185, 'S', 'CR', NULL , 'EQUIP_LL_VC')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43185, 'Equipamiento Lleno-Vacío')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (51900, portico.getTipoDato('EQUIP_LL_VC'), 'Z',  1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (51901, portico.getTipoDato('EQUIP_LL_VC'), '4',  2)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (51902, portico.getTipoDato('EQUIP_LL_VC'), '7',  3)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (51903, portico.getTipoDato('EQUIP_LL_VC'), '8',  4)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43190, 'S', 'CR', NULL , 'ESTADO_EMB_DEP')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43190, 'Estado de Embarcación Autónomica')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (51950, portico.getTipoDato('ESTADO_EMB_DEP'), 'A',  1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (51951, portico.getTipoDato('ESTADO_EMB_DEP'), 'F',  2)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (51952, portico.getTipoDato('ESTADO_EMB_DEP'), 'V',  3)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43195, 'S', 'CR', NULL , 'ESTADO_AMA_DEP')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43195, 'Estado de Amarre Deportivo')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (52000, portico.getTipoDato('ESTADO_AMA_DEP'), 'B',  1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (52001, portico.getTipoDato('ESTADO_AMA_DEP'), 'D',  2)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (52002, portico.getTipoDato('ESTADO_AMA_DEP'), 'L',  3)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (52003, portico.getTipoDato('ESTADO_AMA_DEP'), 'O',  4)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (52004, portico.getTipoDato('ESTADO_AMA_DEP'), 'R',  5)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (52005, portico.getTipoDato('ESTADO_AMA_DEP'), 'T',  6)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43200, 'S', 'CR', NULL , 'ESTADO_ASIG_AMA')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43200, 'Estado de Asignacion Amarre')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (52050, 43200, 'A',  1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (52051, 43200, 'B',  2)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (52052, 43200, 'F',  3)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (52053, 43200, 'P',  4)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (52054, 43200, 'R',  5)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43205, 'S', 'CR', NULL , 'ESTADO_BIEN_HIST')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43205, 'Estado de Bien Histórico')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (52100, 43205, 'AE',  1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (52101, 43205, 'AS',  2)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (52102, 43205, 'FU',  3)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (52103, 43205, 'LI',  4)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (52104, 43205, 'OB',  5)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43210, 'S', 'CR', NULL , 'ESTADO_EXP_CONS')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43210, 'Estado de Expediente Consejo')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (52150, 43210, 'D',  1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (52151, 43210, 'P',  2)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (52152, 43210, 'R',  3)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43215, 'S', 'CR', NULL , 'ESTADO_FACT')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43215, 'Estado de Factura')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (52200, 43215, 'NO',  1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (52201, 43215, 'AN',  2)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (52202, 43215, 'RN',  3)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (52203, 43215, 'RP',  4)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43220, 'S', 'CR', NULL , 'ESTADO_PET_AMA')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43220, 'Estado de Petición de Amarre')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (52250, 43220, 'A',  1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (52251, 43220, 'B',  2)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (52252, 43220, 'D',  3)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (52253, 43220, 'R',  4)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (52254, 43220, 'S',  5)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (52255, 43220, 'V',  6)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43225, 'S', 'CR', NULL , 'ESTADO_PROC_FACT')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43225, 'Estado de Proceso de Facturación')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (52300, 43225, 'C',  1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (52301, 43225, 'E',  2)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (52302, 43225, 'F',  3)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (52303, 43225, 'I',  4)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43230, 'S', 'CR', NULL , 'ESTADO_AMA')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43230, 'Estado de Amarre')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (52350, 43230, 'F',  1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (52351, 43230, 'S',  2)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43235, 'S', 'CR', NULL , 'ESTADO_ATR')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43235, 'Estado de Atraque')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (52400, 43235, 'A',  1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (52401, 43235, 'C',  2)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (52402, 43235, 'D',  3)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (52403, 43235, 'F',  4)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (52404, 43235, 'I',  5)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (52405, 43235, 'S',  6)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43240, 'S', 'CR', NULL , 'ESTADO_BAS_EXP')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43240, 'Estado Básico de Expediente')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (52450, 43240, 'EX',  1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (52451, 43240, 'FE',  2)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (52452, 43240, 'FT',  3)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (52453, 43240, 'OB',  4)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (52454, 43240, 'OT',  5)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (52455, 43240, 'TR',  6)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43245, 'S', 'CR', NULL , 'ESTADO_CM')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43245, 'Estado de Capitanía Marítima Escala')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (52500, 43245, 'A',  1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (52501, 43245, 'D',  1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (52502, 43245, 'S',  1)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43250, 'S', 'CR', NULL , 'ESTADO_CONT_SUM')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43250, 'Estado de Contador de Suministro')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (52550, 43250, 'A',  1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (52551, 43250, 'D',  2)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43255, 'S', 'CR', NULL , 'ESTADO_SER_DIV')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43255, 'Estado de Servicio Diverso')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (52600, 43255, 'C',  1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (52601, 43255, 'F',  2)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (52602, 43255, 'I',  3)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (52603, 43255, 'S',  4)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43260, 'S', 'CR', NULL , 'ESTADO_SER_EMBAUT')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43260, 'Estado de Servicio de Embarcación Autonómica')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (52650, 43260, 'A',  1)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43265, 'S', 'CR', NULL , 'ESTADO_ESCALA')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43265, 'Estado de Escala')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (52700, 43265, 'A',  1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (52701, 43265, 'C',  2)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (52702, 43265, 'D',  3)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (52703, 43265, 'F',  4)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (52704, 43265, 'I',  5)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (52705, 43265, 'S',  6)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43270, 'S', 'CR', NULL , 'ESTADO_INCID')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43270, 'Estado de Incidencia')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (52750, 43270, 'AB',  1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (52751, 43270, 'CE',  2)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43275, 'S', 'CR', NULL , 'ESTADO_PRAC')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43275, 'Estado de Practicaje')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (52800, 43275, 'F',  1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (52801, 43275, 'S',  2)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43280, 'S', 'CR', NULL , 'ESTADO_REM')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43280, 'Estado de Remolque')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (52850, 43280, 'F',  1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (52851, 43280, 'S',  2)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43285, 'S', 'CR', NULL , 'ESTADO_SER_MUL')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43285, 'Estado de Servicio Múltiple')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (52900, 43285, 'A_ESC',  1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (52901, 43285, 'A_MAN',  2)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (52902, 43285, 'A_SUB',  3)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (52903, 43285, 'A_SUP',  4)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (52904, 43285, 'B_MAN',  5)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (52905, 43285, 'C_DIV',  6)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (52906, 43285, 'C_ESC',  7)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (52907, 43285, 'C_MAN',  8)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (52908, 43285, 'C_SUB',  9)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (52909, 43285, 'C_SUP',  10)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (52910, 43285, 'D_ESC',  11)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (52911, 43285, 'D_SUB',  12)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (52912, 43285, 'D_SUP',  13)\
	-- FIXME FALTAN
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43290, 'S', 'CR', NULL , 'ESTADO_SUP')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43290, 'Estado de Superficie')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (52950, 43290, 'A',  1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (52951, 43290, 'C',  2)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (52952, 43290, 'D',  3)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (52953, 43290, 'F',  4)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (52954, 43290, 'I',  5)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (52955, 43290, 'S',  6)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43295, 'S', 'CR', NULL , 'ESTADO_SUM')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43295, 'Estado de Suministro')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53000, 43295, 'A',  1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53001, 43295, 'C',  2)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53002, 43295, 'D',  3)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53003, 43295, 'F',  4)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53004, 43295, 'I',  5)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53005, 43295, 'S',  6)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43300, 'S', 'CR', NULL , 'ESTADO_TASA_SERV')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43300, 'Estado de Tasa de Servicio')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53050, 43300, 'E',  1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53051, 43300, 'L',  2)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53052, 43300, 'N',  3)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53053, 43300, 'P',  4)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53054, 43300, 'T',  5)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53055, 43300, 'V',  6)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53056, 43300, 'X',  7)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43305, 'S', 'CR', NULL , 'ESTADO_VALOR')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43305, 'Estado de Valoración')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53100, 43305, 'A',  1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53101, 43305, 'B',  2)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43310, 'S', 'CR', NULL , 'ZONA')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43310, 'Zona')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53150, 43310, 'I',  1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53151, 43310, 'II',  2)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43315, 'S', 'CR', NULL , 'UNID_MED_BERMAN')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43315, 'Unidad de Medida Berman')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53200, 43315, 'KGM',  1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53201, 43315, 'MTQ',  2)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53202, 43315, 'MTR',  3)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53203, 43315, 'NPT',  4)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53204, 43315, 'TNE',  5)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43320, 'S', 'CR', NULL , 'UNID_PLAZO_EXP')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43320, 'Unidad de Plazo de Expediente')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53250, 43320, 'D',  1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53251, 43320, 'M',  2)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53252, 43320, 'A',  3)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43325, 'S', 'CR', NULL , 'UNID_MED_SUP')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43325, 'Unidad de Medida de Superficie')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53300, 43325, 'm1',  1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53301, 43325, 'm2',  2)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43330, 'S', 'CR', NULL , 'TRANS_SIMPL')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43330, 'Tránsito Simplificado')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53350, 43330, 'ZS1',  1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53351, 43330, 'ZS2',  2)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53352, 43330, 'ZS4',  3)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43335, 'S', 'CR', NULL , 'TIPO_VEHIC')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43335, 'Tipo de Vehículo')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53400, 43335, 'AU',  1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53401, 43335, 'CA',  2)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53402, 43335, 'FU',  3)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53403, 43335, 'MN',  4)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53404, 43335, 'MO',  5)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53405, 43335, 'RE',  6)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53406, 43335, 'SM',  7)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53407, 43335, 'TT',  8)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43340, 'S', 'CR', NULL , 'TIPO_VAL_SUP')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43340, 'Tipo de Valoración de Superficie')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53450, 43340, 'C',  1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53451, 43340, 'R',  2)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43345, 'S', 'CR', NULL , 'TIPO_UNIDAD')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43345, 'Tipo de Unidad')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53500, 43345, 'EM2',  1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53501, 43345, 'EUR',  2)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53502, 43345, 'GTS',  3)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53503, 43345, 'LTR',  4)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53504, 43345, 'MAN',  5)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53505, 43345, 'MIN',  6)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53506, 43345, 'MPH',  7)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53507, 43345, 'PAX',  8)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53508, 43345, 'PCE',  9)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53509, 43345, 'REC',  10)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53510, 43345, 'SRV',  11)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53511, 43345, 'TBJ',  12)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53512, 43345, 'TEU',  13)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53513, 43345, 'TNE',  14)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53514, 43345, 'TNR',  15)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53515, 43345, 'TPH',  16)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53516, 43345, 'VPN',  17)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43350, 'S', 'CR', NULL , 'TIPO_TASATARIFA')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43350, 'Tipo de Tasa-Tarifa')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53550, 43350, 'T',  1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53551, 43350, 'B',  2)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43355, 'S', 'CR', NULL , 'TIPO_SERV_DOC')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43355, 'Tipo de Servicio de Documento')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53600, 43355, 'ESC',  1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53601, 43355, 'INC',  2)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53602, 43355, 'MAN',  3)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53603, 43355, 'N_A',  4)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43360, 'S', 'CR', NULL , 'TIPO_SERV')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43360, 'Tipo de Servicio')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53650, 43360, 'AMA',  1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53651, 43360, 'CEN',  2)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53652, 43360, 'DOC',  3)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53653, 43360, 'DOM',  4)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53654, 43360, 'EAU',  5)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53655, 43360, 'EMA',  6)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53656, 43360, 'EMB',  7)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53657, 43360, 'ESC',  8)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53658, 43360, 'EST',  9)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53659, 43360, 'FAC',  10)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53660, 43360, 'FAP',  11)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53661, 43360, 'GEN',  12)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53662, 43360, 'INC',  13)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53663, 43360, 'MAN',  14)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53664, 43360, 'MAS',  15)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53665, 43360, 'PES',  16)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53666, 43360, 'PRA',  17)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53667, 43360, 'REM',  18)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53668, 43360, 'SEG',  19)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53669, 43360, 'SER',  20)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53670, 43360, 'SIM',  21)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53671, 43360, 'SUB',  22)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53672, 43360, 'SUM',  23)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53673, 43360, 'SUP',  24)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43365, 'S', 'CR', NULL , 'TIPO_RED_SUM')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43365, 'Tipo de Red de Suministro')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53700, 43365, 'A',  1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53701, 43365, 'E',  2)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53702, 43365, 'G',  3)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53703, 43365, 'O',  4)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43370, 'S', 'CR', NULL , 'TIPO_PROP')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43370, 'Tipo de Propulsión')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53800, 43370, '001',  1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53801, 43370, '002',  2)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53802, 43370, '003',  3)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53803, 43370, '004',  4)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53804, 43370, '005',  5)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53805, 43370, '006',  6)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53806, 43370, '007',  7)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53807, 43370, '008',  8)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53808, 43370, '009',  9)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53809, 43370, '010',  10)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43375, 'S', 'CR', NULL , 'TIPO_PREST')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43375, 'Tipo de Prestador')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53850, 43375, 'AMARRA',  1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53851, 43375, 'NINGUN',  2)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53852, 43375, 'PRACTI',  3)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53853, 43375, 'REMOLC',  4)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43380, 'S', 'CR', NULL , 'TIPO_ORGA')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43380, 'Tipo de Organización')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53900, 43380, 'ADUANA',  1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53901, 43380, 'APORTU',  2)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53902, 43380, 'ARMADO',  3)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53903, 43380, 'COFRAD',  4)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53904, 43380, 'CONCES',  5)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53905, 43380, 'CONSIG',  6)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53906, 43380, 'ESTIBA',  7)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53907, 43380, 'NINGUN',  8)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53908, 43380, 'PATDEP',  9)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53909, 43380, 'PATPES',  10)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53910, 43380, 'TALLER',  11)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53911, 43380, 'TRANSE',  12)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53912, 43380, 'TRANSI',  13)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43385, 'S', 'CR', NULL , 'TIPO_LIST')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43385, 'Tipo de Listado')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53950, 43385, 'G',  1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (53951, 43385, 'D',  2)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43390, 'S', 'CR', NULL , 'TIPO_DEST')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43390, 'Tipo de Destino')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54000, 43390, 'ZAH',  1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54001, 43390, 'ZEM',  2)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54002, 43390, 'ZPE',  3)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43395, 'S', 'CR', NULL , 'TIPO_DATO')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43395, 'Tipo de Dato')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54050, 43395, 'CAD',  1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54051, 43395, 'FEC',  2)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54052, 43395, 'NUM',  3)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43400, 'S', 'CR', NULL , 'TIPO_DATO_SER_DIV')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43400, 'Tipo de Dato de Servicio Diverso')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54100, 43400, 'B',  1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54101, 43400, 'C',  2)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54102, 43400, 'F',  3)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54103, 43400, 'M',  4)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54104, 43400, 'N',  5)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54105, 43400, 'U',  6)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43405, 'S', 'CR', NULL , 'TIPO_ASOC_DOC')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43405, 'Tipo de Asociación de Documento')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54150, 43405, 'I',  1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54151, 43405, 'S',  2)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43410, 'S', 'CR', NULL , 'TIPO_ANTIINC')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43410, 'Tipo de Antiincendios')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54200, 43410, '001',  1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54201, 43410, '002',  2)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54202, 43410, '003',  3)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54203, 43410, '004',  4)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54204, 43410, '005',  5)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54205, 43410, '006',  6)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43415, 'S', 'CR', NULL , 'TIPO_PROP_BIENHIST')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43415, 'Tipo de Propietario de Bien Histórico')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54250, 43415, 'CC',  1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54251, 43415, 'PA',  2)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54252, 43415, 'PU',  3)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43420, 'S', 'CR', NULL , 'TIPO_PROC_EDI')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43420, 'Tipo de Proceso EDI')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54300, 43420, 'E',  1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54301, 43420, 'R',  2)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43425, 'S', 'CR', NULL , 'TIPO_PROCESO')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43425, 'Tipo de Proceso')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54350, 43425, 'A',  1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54351, 43425, 'B',  2)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54352, 43425, 'F',  3)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54353, 43425, 'P',  4)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54354, 43425, 'R',  5)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54355, 43425, 'V',  6)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43430, 'S', 'CR', NULL , 'TIPO_PROCED')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43430, 'Tipo de Procedimiento')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54400, 43430, 'T',  1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54401, 43430, 'C',  2)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54402, 43430, 'D',  3)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43435, 'S', 'CR', NULL , 'TIPO_PET_AMA')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43435, 'Tipo de Petición de Amarre')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54450, 43435, 'CA',  1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54451, 43435, 'CE',  2)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54452, 43435, 'CT',  3)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54453, 43435, 'NA',  4)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43440, 'S', 'CR', NULL , 'TIPO_GEN_EXP')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43440, 'Tipo General de Expediente')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54500, 43440, 'AUT',  1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54501, 43440, 'CON',  2)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54502, 43440, 'OTR',  3)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43445, 'S', 'CR', NULL , 'TIPO_FIC_MENS_EDI')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43445, 'Tipo de Fichero de Mensaje EDI')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54550, 43445, 'A',  1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54551, 43445, 'B',  2)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54552, 43445, 'C',  3)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54553, 43445, 'D',  4)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54554, 43445, 'E',  5)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54555, 43445, 'I',  6)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54556, 43445, 'P',  7)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54557, 43445, 'R',  8)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54558, 43445, 'S',  9)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54559, 43445, 'V',  10)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54560, 43445, 'ALT_EST',  11)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54561, 43445, 'GEN_EST',  12)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54562, 43445, 'GEN_EEE',  13)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43450, 'S', 'CR', NULL , 'TIPO_ERR_EDI')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43450, 'Tipo de Error EDI')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54600, 43450, 'E0',  1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54601, 43450, 'W1',  2)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54602, 43450, 'W2',  3)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43455, 'S', 'CR', NULL , 'TIPO_DATO_EXPL')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43455, 'Tipo de Dato de Explotación')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54650, 43455, 'DT',  1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54651, 43455, 'RC',  2)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54652, 43455, 'RE',  3)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54653, 43455, 'TR',  4)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54654, 43455, 'VN',  5)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43460, 'S', 'CR', NULL , 'TIPO_ACTUAL_IPC')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43460, 'Tipo de Actualización de IPC')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54700, 43460, 'BA',  1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54701, 43460, 'CA',  2)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54702, 43460, 'MA',  3)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54703, 43460, 'ZP',  4)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43465, 'S', 'CR', NULL , 'TIPO_ACT_EST')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43465, 'Tipo de Actividad Est.')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54750, 43465, 'CO',  1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54751, 43465, 'DE',  2)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54752, 43465, 'SI',  3)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43470, 'S', 'CR', NULL , 'TASATARIFA_NORM')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43470, 'Tasa-Tarifa Normalizada')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54800, portico.getTipoDato('TASATARIFA_NORM'), 'T0',  1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54801, portico.getTipoDato('TASATARIFA_NORM'), 'T1',  2)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54802, portico.getTipoDato('TASATARIFA_NORM'), 'T2',  3)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54803, portico.getTipoDato('TASATARIFA_NORM'), 'T3',  4)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54804, portico.getTipoDato('TASATARIFA_NORM'), 'T4',  5)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54805, portico.getTipoDato('TASATARIFA_NORM'), 'T5',  6)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54806, portico.getTipoDato('TASATARIFA_NORM'), 'T6',  7)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54807, portico.getTipoDato('TASATARIFA_NORM'), 'T7',  8)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54808, portico.getTipoDato('TASATARIFA_NORM'), 'T8',  9)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54809, portico.getTipoDato('TASATARIFA_NORM'), 'T9',  10)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54810, portico.getTipoDato('TASATARIFA_NORM'), 'TA',  11)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54811, portico.getTipoDato('TASATARIFA_NORM'), 'TO',  12)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54812, portico.getTipoDato('TASATARIFA_NORM'), 'TR',  13)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54813, portico.getTipoDato('TASATARIFA_NORM'), 'OT',  14)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43475, 'S', 'CR', NULL , 'SIT_EMB')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43475, 'Situación de Embarque')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54850, portico.getTipoDato('SIT_EMB'), 'P',  1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54851, portico.getTipoDato('SIT_EMB'), 'R',  2)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54852, portico.getTipoDato('SIT_EMB'), 'T',  3)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43480, 'S', 'CR', NULL , 'SIT_ADU')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43480, 'Situación Aduanera')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54900, portico.getTipoDato('SIT_ADU'), 'ZC',  1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54901, portico.getTipoDato('SIT_ADU'), 'ZE',  2)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54902, portico.getTipoDato('SIT_ADU'), 'ZF',  3)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54903, portico.getTipoDato('SIT_ADU'), 'ZLF',  4)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54904, portico.getTipoDato('SIT_ADU'), 'ZN',  5)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54905, portico.getTipoDato('SIT_ADU'), 'ZTD',  6)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54906, portico.getTipoDato('SIT_ADU'), 'ZTF',  7)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54907, portico.getTipoDato('SIT_ADU'), 'ZTL',  8)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54908, portico.getTipoDato('SIT_ADU'), 'ZT1',  9)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54909, portico.getTipoDato('SIT_ADU'), 'ZT2',  10)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54910, portico.getTipoDato('SIT_ADU'), 'ZX',  11)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54911, portico.getTipoDato('SIT_ADU'), 'ZZ1',  12)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54912, portico.getTipoDato('SIT_ADU'), 'Z1',  13)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43485, 'S', 'CR', NULL , 'SENT_RES_TRAMITE')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43485, 'Sentido de Resolución de Trámite')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54950, portico.getTipoDato('SENT_RES_TRAMITE'), 'N',  1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54951, portico.getTipoDato('SENT_RES_TRAMITE'), 'P',  2)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (54952, portico.getTipoDato('SENT_RES_TRAMITE'), 'S',  3)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43490, 'S', 'CR', NULL , 'RES_PROC_EDI')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43490, 'Resultado de Proceso EDI')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55000, portico.getTipoDato('RES_PROC_EDI'), 'A',  1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55001, portico.getTipoDato('RES_PROC_EDI'), 'G',  2)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55002, portico.getTipoDato('RES_PROC_EDI'), 'R',  3)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55003, portico.getTipoDato('RES_PROC_EDI'), 'T',  4)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43495, 'S', 'CR', NULL , 'FUNC_MENS_EDI')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43495, 'Función de Mensaje EDI')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55050, portico.getTipoDato('FUNC_MENS_EDI'), 'ALPES',  1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55051, portico.getTipoDato('FUNC_MENS_EDI'), 'ALPTR',  2)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55052, portico.getTipoDato('FUNC_MENS_EDI'), 'ALSUP',  3)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55053, portico.getTipoDato('FUNC_MENS_EDI'), 'ALT_ATR_13',  4)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55054, portico.getTipoDato('FUNC_MENS_EDI'), 'ALT_BAS',  5)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55055, portico.getTipoDato('FUNC_MENS_EDI'), 'ALT_ESC_47',  6)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55056, portico.getTipoDato('FUNC_MENS_EDI'), 'ALT_MAN_47',  7)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55057, portico.getTipoDato('FUNC_MENS_EDI'), 'ALT_PAR_2',  8)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55058, portico.getTipoDato('FUNC_MENS_EDI'), 'AUT_ATR_51',  9)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55059, portico.getTipoDato('FUNC_MENS_EDI'), 'AUT_ESC_51',  10)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55060, portico.getTipoDato('FUNC_MENS_EDI'), 'BER_ATA',  11)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55061, portico.getTipoDato('FUNC_MENS_EDI'), 'BER_ATD',  12)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55062, portico.getTipoDato('FUNC_MENS_EDI'), 'BOR_BL_40',  13)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55063, portico.getTipoDato('FUNC_MENS_EDI'), 'BOR_MAN_13',  14)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55064, portico.getTipoDato('FUNC_MENS_EDI'), 'BOR_PAR_3',  15)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55065, portico.getTipoDato('FUNC_MENS_EDI'), 'CAN_ATR_40',  16)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55066, portico.getTipoDato('FUNC_MENS_EDI'), 'CAN_ESC_1',  17)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55067, portico.getTipoDato('FUNC_MENS_EDI'), 'CAN_MAN_1',  18)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55068, portico.getTipoDato('FUNC_MENS_EDI'), 'DEN_ATR_27',  19)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55069, portico.getTipoDato('FUNC_MENS_EDI'), 'DEN_ESC_27',  20)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55070, portico.getTipoDato('FUNC_MENS_EDI'), 'MOD_ATR_21',  21)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55071, portico.getTipoDato('FUNC_MENS_EDI'), 'MOD_BL_4',  22)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55072, portico.getTipoDato('FUNC_MENS_EDI'), 'MOD_ESC_33',  23)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55073, portico.getTipoDato('FUNC_MENS_EDI'), 'MOD_MAN_33',  24)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55074, portico.getTipoDato('FUNC_MENS_EDI'), 'MOD_ETA_54',  25)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55075, portico.getTipoDato('FUNC_MENS_EDI'), 'MOD_PAR_36',  26)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55076, portico.getTipoDato('FUNC_MENS_EDI'), 'NOT_PRA_99',  27)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55077, portico.getTipoDato('FUNC_MENS_EDI'), 'NUM_ESC_30',  28)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55078, portico.getTipoDato('FUNC_MENS_EDI'), 'UNKNOWN',  29)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43515, 'S', 'CR', NULL , 'COND_TANQUE_LASTRE')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43515, 'Condición Tanque Lastre')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55100, portico.getTipoDato('COND_TANQUE_LASTRE'), 'L',  1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55101, portico.getTipoDato('COND_TANQUE_LASTRE'), 'V',  2)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55102, portico.getTipoDato('COND_TANQUE_LASTRE'), 'I',  3)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43520, 'S', 'CR', NULL , 'COND_TANQUE_CARGA')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43520, 'Condición Tanque Carga')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55150, portico.getTipoDato('COND_TANQUE_CARGA'), 'L',  1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55151, portico.getTipoDato('COND_TANQUE_CARGA'), 'V',  2)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55152, portico.getTipoDato('COND_TANQUE_CARGA'), 'I',  3)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43525, 'S', 'CR', NULL , 'TIPO_ACT_EDI')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43525, 'Tipo de Actividad EDI')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55200, portico.getTipoDato('TIPO_ACT_EDI'), 'ZOP',  1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55201, portico.getTipoDato('TIPO_ACT_EDI'), 'ZAB',  2)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55202, portico.getTipoDato('TIPO_ACT_EDI'), 'ZAO',  3)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55203, portico.getTipoDato('TIPO_ACT_EDI'), 'ZAR',  4)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55204, portico.getTipoDato('TIPO_ACT_EDI'), 'ZCT',  5)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55205, portico.getTipoDato('TIPO_ACT_EDI'), 'ZTI',  6)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55206, portico.getTipoDato('TIPO_ACT_EDI'), 'ZVO',  7)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55207, portico.getTipoDato('TIPO_ACT_EDI'), 'ZAF',  8)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55208, portico.getTipoDato('TIPO_ACT_EDI'), 'ZIN',  9)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55209, portico.getTipoDato('TIPO_ACT_EDI'), 'ZIP',  10)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55210, portico.getTipoDato('TIPO_ACT_EDI'), 'ZBO',  11)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55211, portico.getTipoDato('TIPO_ACT_EDI'), 'ZCO',  12)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55212, portico.getTipoDato('TIPO_ACT_EDI'), 'ZCA',  13)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55213, portico.getTipoDato('TIPO_ACT_EDI'), 'ZRA',  14)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55214, portico.getTipoDato('TIPO_ACT_EDI'), 'ZRF',  15)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55215, portico.getTipoDato('TIPO_ACT_EDI'), 'ZRT',  16)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55216, portico.getTipoDato('TIPO_ACT_EDI'), 'ZDE',  17)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55217, portico.getTipoDato('TIPO_ACT_EDI'), 'ZDA',  18)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55218, portico.getTipoDato('TIPO_ACT_EDI'), 'ZTA',  19)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55219, portico.getTipoDato('TIPO_ACT_EDI'), 'ZTF',  20)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55220, portico.getTipoDato('TIPO_ACT_EDI'), 'ZAP',  21)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55221, portico.getTipoDato('TIPO_ACT_EDI'), 'ZDR',  22)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55222, portico.getTipoDato('TIPO_ACT_EDI'), 'ZPB',  23)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55223, portico.getTipoDato('TIPO_ACT_EDI'), 'ZCL',  24)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55224, portico.getTipoDato('TIPO_ACT_EDI'), 'ZDJ',  25)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55225, portico.getTipoDato('TIPO_ACT_EDI'), 'ZMR',  26)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55226, portico.getTipoDato('TIPO_ACT_EDI'), 'ZPR',  27)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55227, portico.getTipoDato('TIPO_ACT_EDI'), 'ZRE',  28)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55228, portico.getTipoDato('TIPO_ACT_EDI'), 'ZVA',  29)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55229, portico.getTipoDato('TIPO_ACT_EDI'), 'ZDS',  30)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55230, portico.getTipoDato('TIPO_ACT_EDI'), 'ZPV',  31)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55231, portico.getTipoDato('TIPO_ACT_EDI'), 'ZOT',  32)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55232, portico.getTipoDato('TIPO_ACT_EDI'), 'ZSV',  33)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43540, 'S', 'CR', NULL , 'TIPO_HORA')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43540, 'Tipo de Hora')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55350, portico.getTipoDato('TIPO_HORA'), 'E',  1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55351, portico.getTipoDato('TIPO_HORA'), 'F',  2)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55352, portico.getTipoDato('TIPO_HORA'), 'N',  3)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43545, 'S', 'CR', NULL , 'ESTADO_CONT')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43545, 'Estado Contador')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55400, portico.getTipoDato('ESTADO_CONT'), 'A',  1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55401, portico.getTipoDato('ESTADO_CONT'), 'D',  2)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43550, 'S', 'CR', NULL , 'ESTADO_AMAD')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43550, 'Estado Amarre Dep.')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55450, portico.getTipoDato('ESTADO_AMAD'), 'L',  1)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55451, portico.getTipoDato('ESTADO_AMAD'), 'R',  2)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55452, portico.getTipoDato('ESTADO_AMAD'), 'T',  3)\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55453, portico.getTipoDato('ESTADO_AMAD'), 'B',  4)\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43555, 'S', 'CR', NULL, 'TIPO_OP_BL')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43555, 'Tipo de Operación BL')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55500, portico.getTipoDato('TIPO_OP_BL'), 'AC',  1)\
		INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('cdrf', 'es', 55500, 'REC. ADUAN. > 5%')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55501, portico.getTipoDato('TIPO_OP_BL'), 'AS',  2)\
		INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('cdrf', 'es', 55501, 'REC. ADUAN. < 5%')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55502, portico.getTipoDato('TIPO_OP_BL'), 'AV',  3)\
		INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('cdrf', 'es', 55502, 'AVITUALLAMIENTO')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55503, portico.getTipoDato('TIPO_OP_BL'), 'CA',  4)\
		INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('cdrf', 'es', 55503, 'CTRL. ADUANERO TERR.')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55504, portico.getTipoDato('TIPO_OP_BL'), 'D',  5)\
		INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('cdrf', 'es', 55504, 'DESEMBARQUE')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55505, portico.getTipoDato('TIPO_OP_BL'), 'DT',  6)\
		INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('cdrf', 'es', 55505, 'DESEMB. EN TRANSITO')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55506, portico.getTipoDato('TIPO_OP_BL'), 'E',  7)\
		INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('cdrf', 'es', 55506, 'EMBARQUE')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55507, portico.getTipoDato('TIPO_OP_BL'), 'ET',  8)\
		INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('cdrf', 'es', 55507, 'EMBARQUE EN TRANSITO')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55508, portico.getTipoDato('TIPO_OP_BL'), 'T',  9)\
		INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('cdrf', 'es', 55508, 'TRANSBORDO')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55509, portico.getTipoDato('TIPO_OP_BL'), 'TD',  10)\
		INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('cdrf', 'es', 55509, 'TRANSBORDO DESCARGA')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55510, portico.getTipoDato('TIPO_OP_BL'), 'TE',  11)\
		INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('cdrf', 'es', 55510, 'TRANSBORDO EMBARQUE')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (43560, 'S', 'CR', NULL, 'CONC_CUAD_MES')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 43560, 'Concepto Cuadro Mensual')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55550, portico.getTipoDato('CONC_CUAD_MES'), 'BUQGT',  1)\
		INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('cdrf', 'es', 55550, 'Buques mercantes entrados  (GT)')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55551, portico.getTipoDato('CONC_CUAD_MES'), 'MCONV',  2)\
		INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('cdrf', 'es', 55551, 'Mercancía Convencional')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55552, portico.getTipoDato('CONC_CUAD_MES'), 'AVOTRO',  3)\
		INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('cdrf', 'es', 55552, 'Avituallamiento. Otros')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55553, portico.getTipoDato('CONC_CUAD_MES'), 'AVPPET',  4)\
		INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('cdrf', 'es', 55553, 'Avituallamiento. Productos Petrolíferos')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55554, portico.getTipoDato('CONC_CUAD_MES'), 'PESCAF',  5)\
		INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('cdrf', 'es', 55554, 'Pesca Fresca')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55555, portico.getTipoDato('CONC_CUAD_MES'), 'TRALOC',  6)\
		INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('cdrf', 'es', 55555, 'Tráfico Local')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55556, portico.getTipoDato('CONC_CUAD_MES'), 'RRTONO',  7)\
		INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('cdrf', 'es', 55556, 'Ro Ro en otros medios (tons)')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55557, portico.getTipoDato('CONC_CUAD_MES'), 'RRTONC',  8)\
		INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('cdrf', 'es', 55557, 'Ro Ro en contenedores (tons)')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55558, portico.getTipoDato('CONC_CUAD_MES'), 'RRTEUS',  9)\
		INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('cdrf', 'es', 55558, 'Ro Ro en contenedores (teus)')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55559, portico.getTipoDato('CONC_CUAD_MES'), 'CTEUS',  10)\
		INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('cdrf', 'es', 55559, 'Teus (nº)')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55560, portico.getTipoDato('CONC_CUAD_MES'), 'CTONVA',  11)\
		INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('cdrf', 'es', 55560, 'Contenedores de 20¿ o mayores vacíos (tons)')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55561, portico.getTipoDato('CONC_CUAD_MES'), 'CNUMVA',  12)\
		INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('cdrf', 'es', 55561, 'Contenedores de 20¿ o mayores vacíos (nº)')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55562, portico.getTipoDato('CONC_CUAD_MES'), 'CTONCA',  13)\
		INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('cdrf', 'es', 55562, 'Contenedores de 20¿ o mayores llenos (tons)')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55563, portico.getTipoDato('CONC_CUAD_MES'), 'CNUMCA',  14)\
		INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('cdrf', 'es', 55563, 'Contenedores de 20¿ o mayores llenos (nº)')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55564, portico.getTipoDato('CONC_CUAD_MES'), 'VET2',  15)\
		INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('cdrf', 'es', 55564, 'Vehículos en régimen de pasaje, automóviles y autobuses')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55565, portico.getTipoDato('CONC_CUAD_MES'), 'PASCRU',  16)\
		INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('cdrf', 'es', 55565, 'Pasajeros de Crucero')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55566, portico.getTipoDato('CONC_CUAD_MES'), 'PASAJE',  17)\
		INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('cdrf', 'es', 55566, 'Pasajeros (excluído T. Bahía)')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55567, portico.getTipoDato('CONC_CUAD_MES'), 'MG',  18)\
		INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('cdrf', 'es', 55567, 'Mercancía General')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55568, portico.getTipoDato('CONC_CUAD_MES'), 'GSNIES',  19)\
		INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('cdrf', 'es', 55568, 'Graneles Sólidos sin Instalación Especial')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55569, portico.getTipoDato('CONC_CUAD_MES'), 'GSIESP',  20)\
		INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('cdrf', 'es', 55569, 'Graneles Sólidos por Instalación Especial')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55570, portico.getTipoDato('CONC_CUAD_MES'), 'GLOTRO',  20)\
		INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('cdrf', 'es', 55570, 'Graneles Líquidos. Otros')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55571, portico.getTipoDato('CONC_CUAD_MES'), 'GLPREF',  20)\
		INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('cdrf', 'es', 55571, 'Graneles Líquidos. Productos Refinados')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55572, portico.getTipoDato('CONC_CUAD_MES'), 'GLGASN',  20)\
		INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('cdrf', 'es', 55572, 'Graneles Líquidos. Crudo de Petróleo')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55573, portico.getTipoDato('CONC_CUAD_MES'), 'GLPETR',  20)\
		INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('cdrf', 'es', 55573, 'Graneles Líquidos. Crudo de Petróleo')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55574, portico.getTipoDato('CONC_CUAD_MES'), 'CRUBUQ',  20)\
		INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('cdrf', 'es', 55574, 'Cruceros (nº)')\
	INSERT INTO portico.tbl_codigo_ref_cdrf (cdrf_pk, cdrf_tpdt_pk, cdrf_valor, cdrf_orden) VALUES (55575, portico.getTipoDato('CONC_CUAD_MES'), 'BUQUNI',  20)\
		INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('cdrf', 'es', 55575, 'Buques mercantes entrados (nº)')\


-- Codigo de Referencia - i18n
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text)
SELECT 'cdrf', 'es', cdrf_pk, cdrf_valor
FROM portico.tbl_codigo_ref_cdrf
WHERE NOT EXISTS (
	SELECT 1
	FROM portico.tbl_i18n_i18n
	WHERE i18n_ext_pk = cdrf_pk
		AND i18n_pref = 'cdrf'
		AND i18n_lang = 'es'
)\




-- Entidades - Tipos de parametro
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20001, 'P', 1, 1, 1, 1, 'TIPO_ACTIVIDAD')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20001, 'Tipo de Actividad')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('TIPO_ACTIVIDAD'), 1, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20002, 'P', 1, 1, 1, 1, 'TIPO_ACTIVIDAD_EDI')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20002, 'Tipo de Actividad EDI')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('TIPO_ACTIVIDAD_EDI'), 1, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20003, 'P', 1, 1, 1, 1, 'ACUERDO')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20003, 'Acuerdo')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('ACUERDO'), 1, 1, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20004, 'P', 1, 1, 1, 1, 'PAIS')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20004, 'País')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('PAIS'), 1, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20005, 'P', 1, 1, 1, 1, 'BUQUE')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20005, 'Buque')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('BUQUE'), 0, 0, 41020)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20006, 'P', 1, 1, 1, 1, 'AREA_MUNDIAL')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20006, 'Area Mundial')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('AREA_MUNDIAL'), 1, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20007, 'P', 1, 1, 1, 1, 'TIPO_BUQUE_EEE')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20007, 'Tipo de Buque EEE')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('TIPO_BUQUE_EEE'), 1, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20008, 'P', 1, 1, 1, 1, 'TIPO_BUQUE_EST')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20008, 'Tipo de Buque Est')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('TIPO_BUQUE_EST'), 1, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20009, 'P', 1, 1, 1, 1, 'TIPO_BUQUE')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20009, 'Tipo de Buque')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('TIPO_BUQUE'), 1, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20010, 'P', 1, 1, 1, 1, 'ORGANIZACION')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20010, 'Organización')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('ORGANIZACION'), 0, 0, 41020)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20011, 'P', 1, 1, 1, 1, 'TIPO_IVA')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20011, 'Tipo de IVA')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('TIPO_IVA'), 1, 1, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20012, 'P', 1, 1, 1, 1, 'AREA_GEOGRAFICA')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20012, 'Area Geográfica')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('AREA_GEOGRAFICA'), 1, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20013, 'P', 1, 1, 1, 1, 'ZONA_COSTERA_EEE')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20013, 'Zona Costera EEE')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('ZONA_COSTERA_EEE'), 1, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20014, 'P', 1, 1, 1, 1, 'UNLOCODE')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20014, 'Unlocode')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('UNLOCODE'), 1, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20015, 'P', 1, 1, 1, 1, 'TIPO_ALINEACION')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20015, 'Tipo de Alineación')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('TIPO_ALINEACION'), 1, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20016, 'P', 1, 1, 1, 1, 'TIPO_MEDIO_AMARRE')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20016, 'Tipo de Medio de Amarre')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('TIPO_MEDIO_AMARRE'), 1, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20017, 'P', 1, 1, 1, 1, 'TIPO_MOVIMIENTO_AMARRE')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20017, 'Tipo de Movimiento de Amarre')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('TIPO_MOVIMIENTO_AMARRE'), 1, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20018, 'P', 1, 1, 1, 1, 'TIPO_VIA')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20018, 'Tipo de Vía')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('TIPO_VIA'), 1, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20019, 'P', 1, 1, 1, 1, 'TIPO_USUARIO')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20019, 'Tipo de Usuario')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('TIPO_USUARIO'), 1, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20020, 'P', 1, 1, 1, 1, 'TIPO_SUPERFICIE')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20020, 'Tipo de Superficie')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('TIPO_SUPERFICIE'), 1, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20021, 'P', 1, 1, 1, 1, 'GRUPO_ZONA')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20021, 'Grupo Zona')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('GRUPO_ZONA'), 1, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20022, 'P', 1, 1, 1, 1, 'UNIDAD_SUPERFICIE')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20022, 'Unidad de Superficie')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('UNIDAD_SUPERFICIE'), 1, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20023, 'P', 1, 1, 1, 1, 'TIPO_OPERACION_SUPERFICIE')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20023, 'Tipo de Operación de Superficie')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('TIPO_OPERACION_SUPERFICIE'), 1, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20024, 'P', 1, 1, 1, 1, 'TIPO_SUMINISTRO')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20024, 'Tipo de Suministro')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('TIPO_SUMINISTRO'), 1, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20025, 'P', 1, 1, 1, 1, 'TIPO_GASTO')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20025, 'Tipo de Gasto')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('TIPO_GASTO'), 1, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20026, 'P', 1, 1, 1, 1, 'TIPO_CONTADOR')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20026, 'Tipo de Contador')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('TIPO_CONTADOR'), 1, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20027, 'P', 1, 1, 1, 1, 'TIPO_MEDIO_REMOLQUE')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20027, 'Tipo de Medio de Remolque')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('TIPO_MEDIO_REMOLQUE'), 1, 1, NULL)\
-- TODO - Ver Tipos de Datos
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20028, 'P', 1, 1, 1, 1, 'TIPO_MOVIMIENTO_REMOLQUE')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20028, 'Tipo de Movimiento de Remolque')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('TIPO_MOVIMIENTO_REMOLQUE'), 1, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20029, 'P', 1, 1, 1, 1, 'TIPO_MANIOBRA_REMOLQUE')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20029, 'Tipo de Maniobra de Remolque')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('TIPO_MANIOBRA_REMOLQUE'), 1, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20030, 'P', 1, 1, 1, 1, 'ZONA_PESCA')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20030, 'Zona de Pesca')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('ZONA_PESCA'), 1, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20031, 'P', 1, 1, 1, 1, 'PRESENTACION_PESCA')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20031, 'Presentación de Pesca')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('PRESENTACION_PESCA'), 1, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20032, 'P', 1, 1, 1, 1, 'TIPO_OPERACION_PESCA')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20032, 'Tipo de Operación de Pesca')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('TIPO_OPERACION_PESCA'), 1, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20033, 'P', 1, 1, 1, 1, 'TIPO_MANIFIESTO_PESCA')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20033, 'Tipo de Manifiesto de Pesca')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('TIPO_MANIFIESTO_PESCA'), 1, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20034, 'P', 1, 1, 1, 1, 'SUBTIPO_MANIFIESTO_PESCA')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20034, 'Subtipo de Manifiesto de Pesca')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('SUBTIPO_MANIFIESTO_PESCA'), 1, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20035, 'P', 1, 1, 1, 1, 'GRUPO_FAMILIA_ESPECIE_PESCA')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20035, 'Grupo de Familia de Especies de Pesca')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('GRUPO_FAMILIA_ESPECIE_PESCA'), 1, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20036, 'P', 1, 1, 1, 1, 'FAMILIA_ESPECIE_PESCA')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20036, 'Familia de Especies de Pesca')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('FAMILIA_ESPECIE_PESCA'), 1, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20037, 'P', 1, 1, 1, 1, 'TIPO_CAPTURA_PESCA')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20037, 'Tipo de Captura de Pesca')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('TIPO_CAPTURA_PESCA'), 1, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20038, 'P', 1, 1, 1, 1, 'ESPECIE_PESCA')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20038, 'Especie de Pesca')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('ESPECIE_PESCA'), 1, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20039, 'P', 1, 1, 1, 1, 'TIPO_BUQUE_PESCA')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20039, 'Tipo de Buque de Pesca')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('TIPO_BUQUE_PESCA'), 1, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20040, 'P', 1, 1, 1, 1, 'BUQUE_PESCA')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20040, 'Buque de Pesca')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('BUQUE_PESCA'), 0, 0, 41020)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20041, 'P', 1, 1, 1, 1, 'ARTE_PESCA')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20041, 'Arte de Pesca')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('ARTE_PESCA'), 1, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20042, 'P', 1, 1, 1, 1, 'TIPO_MERCANCIA_EST')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20042, 'Tipo de Mercancía Est')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('TIPO_MERCANCIA_EST'), 1, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20043, 'P', 1, 1, 1, 1, 'GRUPO_NATURALEZA')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20043, 'Grupo de Naturaleza de Mercancía')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('GRUPO_NATURALEZA'), 1, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20044, 'P', 1, 1, 1, 1, 'NATURALEZA')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20044, 'Naturaleza de Mercancía')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('NATURALEZA'), 1, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20045, 'P', 1, 1, 1, 1, 'GRUPO_ARANCELARIO')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20045, 'Grupo Arancelario')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('GRUPO_ARANCELARIO'), 1, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20046, 'P', 1, 1, 1, 1, 'SUBGRUPO_MERCANCIA_EST')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20046, 'Subgrupo Mercancía Est')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('SUBGRUPO_MERCANCIA_EST'), 1, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20047, 'P', 1, 1, 1, 1, 'GRUPO_NST')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20047, 'Grupo NST-2000')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('GRUPO_NST'), 1, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20048, 'P', 1, 1, 1, 1, 'UNIDAD_CARGA')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20048, 'Unidad de Carga')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('UNIDAD_CARGA'), 1, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20049, 'P', 1, 1, 1, 1, 'MERCANCIA')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20049, 'Mercancía')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('MERCANCIA'), 1, 1, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20051, 'P', 1, 1, 1, 1, 'TIPO_EQUIPAMIENTO')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20051, 'Tipo de Equipamiento')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('TIPO_EQUIPAMIENTO'), 1, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20052, 'P', 1, 1, 1, 1, 'TIPO_DOCUMENTO_AEAT')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20052, 'Tipo de Documento AEAT')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('TIPO_DOCUMENTO_AEAT'), 1, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20053, 'P', 1, 1, 1, 1, 'TIPO_BULTO')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20053, 'Tipo de Bulto')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('TIPO_BULTO'), 1, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20054, 'P', 1, 1, 1, 1, 'RECINTO_ADUANERO')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20054, 'Recinto Aduanero')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('RECINTO_ADUANERO'), 1, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20055, 'P', 1, 1, 1, 1, 'TERMINAL')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20055, 'Terminal')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('TERMINAL'), 1, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20056, 'P', 1, 1, 1, 1, 'RECEPTOR_MERCANCIA')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20056, 'Receptor de Mercancía')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('RECEPTOR_MERCANCIA'), 0, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20057, 'P', 1, 1, 1, 1, 'MODO_TRANSPORTE_EDI')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20057, 'Modo de Transporte EDI de Mercancía')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('MODO_TRANSPORTE_EDI'), 1, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20058, 'P', 1, 1, 1, 1, 'MERCANCIAS_PELIGROSAS')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20058, 'Mercancías Peligrosas')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('MERCANCIAS_PELIGROSAS'), 1, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20059, 'P', 1, 1, 1, 1, 'MARCA_VEHICULO')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20059, 'Marca de Vehículo')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('MARCA_VEHICULO'), 0, 0, 41020)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20060, 'P', 1, 1, 1, 1, 'INSTRUCCION_MARCAJE')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20060, 'Instrucción de Marcaje')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('INSTRUCCION_MARCAJE'), 1, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20061, 'P', 1, 1, 1, 1, 'INSTALACION_ESPECIAL')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20061, 'Instalación Especial')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('INSTALACION_ESPECIAL'), 1, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20062, 'P', 1, 1, 1, 1, 'PROVINCIA')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20062, 'Provincia')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('PROVINCIA'), 1, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20063, 'P', 1, 1, 1, 1, 'SUBPUERTO')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20063, 'Subpuerto')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('SUBPUERTO'), 1, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20064, 'P', 1, 1, 1, 1, 'TIPO_OPERACION_MERCANCIA')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20064, 'Tipo de Operación de Mercancía')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('TIPO_OPERACION_MERCANCIA'), 1, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20065, 'P', 1, 1, 1, 1, 'TIPO_NAVEGACION')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20065, 'Tipo de Navegación')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('TIPO_NAVEGACION'), 1, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20066, 'P', 1, 1, 1, 1, 'TIPO_EXENCION')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20066, 'Tipo de Exención')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('TIPO_EXENCION'), 1, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20067, 'P', 1, 1, 1, 1, 'TIPO_ERROR_EDI')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20067, 'Tipo de Error EDI')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('TIPO_ERROR_EDI'), 1, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20068, 'P', 1, 1, 1, 1, 'DESCUENTO_ADICIONAL')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20068, 'Descuento Adicional')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('DESCUENTO_ADICIONAL'), 1, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20069, 'P', 1, 1, 1, 1, 'TIPO_CANON')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20069, 'Tipo de Canon')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('TIPO_CANON'), 1, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20070, 'P', 1, 1, 1, 1, 'BONIFICACION_FP')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20070, 'Bonificación de FP')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('BONIFICACION_FP'), 1, 1, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20071, 'P', 1, 1, 1, 1, 'BAREMO_FP')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20071, 'Baremo de FP')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('BAREMO_FP'), 1, 1, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20072, 'P', 1, 1, 1, 1, 'ZONA_PORTUARIA')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20072, 'Zona Portuaria')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('ZONA_PORTUARIA'), 1, 1, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20073, 'P', 1, 1, 1, 1, 'TIPO_SUPERFICIE_BIEN')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20073, 'Tipo de Superficie de Bien')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('TIPO_SUPERFICIE_BIEN'), 1, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20074, 'P', 1, 1, 1, 1, 'TIPO_EXPEDIENTE')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20074, 'Tipo de Expediente')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('TIPO_EXPEDIENTE'), 1, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20075, 'P', 1, 1, 1, 1, 'TIPO_BIEN_CONCESIONAL')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20075, 'Tipo de Bien Concesional')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('TIPO_BIEN_CONCESIONAL'), 1, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20076, 'P', 1, 1, 1, 1, 'TIPO_ACT_GRAL_CONCESIONAL')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20076, 'Tipo de Actividad General Concesional')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('TIPO_ACT_GRAL_CONCESIONAL'), 1, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20077, 'P', 1, 1, 1, 1, 'TIPO_ACTIVIDAD_CONCESIONAL')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20077, 'Tipo de Actividad Concesional')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('TIPO_ACTIVIDAD_CONCESIONAL'), 1, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20078, 'P', 1, 1, 1, 1, 'SUPRABIEN')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20078, 'Suprabien')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('SUPRABIEN'), 0, 1, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20079, 'P', 1, 1, 1, 1, 'GARANTIA_EXPEDIENTE')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20079, 'Garantía de Expediente')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('GARANTIA_EXPEDIENTE'), 0, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20080, 'P', 1, 1, 1, 1, 'FASE_EXPEDIENTE')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20080, 'Fase de Expediente')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('FASE_EXPEDIENTE'), 0, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20081, 'P', 1, 1, 1, 1, 'ESTADO_EXPEDIENTE')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20081, 'Estado de Expediente')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('ESTADO_EXPEDIENTE'), 1, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20082, 'P', 1, 1, 1, 1, 'REGISTRO_TIPO_BUQUE_EEE')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20082, 'Registro de Tipo de Buque EEE')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('REGISTRO_TIPO_BUQUE_EEE'), 0, 0, 41020)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20083, 'P', 1, 1, 1, 1, 'REGISTRO_TIPO_BUQUE')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20083, 'Registro de Tipo de Buque')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('REGISTRO_TIPO_BUQUE'), 0, 0, 41020)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20084, 'P', 1, 1, 1, 1, 'CONCEPTO_CUADRO_EST')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20084, 'Concepto de Cuadro Estadístico')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('CONCEPTO_CUADRO_EST'), 1, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20085, 'P', 1, 1, 1, 1, 'TIPO_BUQUE_GT')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20085, 'Tipo de Buque GT')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('TIPO_BUQUE_GT'), 1, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20086, 'P', 1, 1, 1, 1, 'SERVICIO_TRAFICO')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20086, 'Servicio de Tráfico')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('SERVICIO_TRAFICO'), 1, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20087, 'P', 1, 1, 1, 1, 'TIPO_SERVICIO_TRAFICO')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20087, 'Tipo de Servicio de Tráfico')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('TIPO_SERVICIO_TRAFICO'), 1, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20088, 'P', 1, 1, 1, 1, 'TIPO_RESIDUO')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20088, 'Tipo de Residuo')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('TIPO_RESIDUO'), 1, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20089, 'P', 1, 1, 1, 1, 'SUBTIPO_RESIDUO')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20089, 'Subtipo de Residuo')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('SUBTIPO_RESIDUO'), 1, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20090, 'P', 1, 1, 1, 1, 'NAVIERA')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20090, 'Naviera')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('NAVIERA'), 0, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20091, 'P', 1, 1, 1, 1, 'MUELLE')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20091, 'Muelle')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('MUELLE'), 1, 0, NULL)\
-- TODO ver datos asociados
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20093, 'P', 1, 1, 1, 1, 'CONVENIO')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20093, 'Convenio')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('CONVENIO'), 1, 1, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20094, 'P', 1, 1, 1, 1, 'TIPO_CERTIFICADO')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20094, 'Tipo de Certificado')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('TIPO_CERTIFICADO'), 1, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20095, 'P', 1, 1, 1, 1, 'TIPO_BUQUE_EDI')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20095, 'Tipo de Buque EDI')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('TIPO_BUQUE_EDI'), 1, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20096, 'P', 1, 1, 1, 1, 'TIPO_ATRAQUE')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20096, 'Tipo de Atraque')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('TIPO_ATRAQUE'), 1, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20097, 'P', 1, 1, 1, 1, 'TIPO_EMBARCACION')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20097, 'Tipo de Embarcación')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('TIPO_EMBARCACION'), 1, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20098, 'P', 1, 1, 1, 1, 'TIPO_AMARRE')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20098, 'Tipo de Amarre')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('TIPO_AMARRE'), 1, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20099, 'P', 1, 1, 1, 1, 'SERVICIO_DEPORTIVO')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20099, 'Servicio Deportivo')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('SERVICIO_DEPORTIVO'), 1, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20100, 'P', 1, 1, 1, 1, 'INSTALACION_DEP_AUT')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20100, 'Instalación Deportiva Autónomica')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('INSTALACION_DEP_AUT'), 1, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20101, 'P', 1, 1, 1, 1, 'INSTALACION_DEP')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20101, 'Instalación Deportiva')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('INSTALACION_DEP'), 1, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20102, 'P', 1, 1, 1, 1, 'MODULO')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20102, 'Módulo')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('MODULO'), 1, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20103, 'P', 1, 1, 1, 1, 'TIPO_DOCUMENTO')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20103, 'Tipo de Documento')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('TIPO_DOCUMENTO'), 1, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20104, 'P', 1, 1, 1, 1, 'MODULO_BATCH')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20104, 'Módulo Batch')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('MODULO_BATCH'), 1, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20105, 'P', 1, 1, 1, 1, 'TIPO_PRESTADOR_SERVICIO')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20105, 'Tipo de Prestador de Servicio')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('TIPO_PRESTADOR_SERVICIO'), 1, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20106, 'P', 1, 1, 1, 1, 'TIPO_ORGANIZACION')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20106, 'Tipo de Organización')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('TIPO_ORGANIZACION'), 1, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20107, 'P', 1, 1, 1, 1, 'AUTORIDAD_PORTUARIA')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20107, 'Autoridad Portuaria')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('AUTORIDAD_PORTUARIA'), 1, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20108, 'P', 1, 1, 1, 1, 'COMPRADOR_PESCA')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20108, 'Comprador de Pesca')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('COMPRADOR_PESCA'), 0, 0, 41020)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20109, 'P', 1, 1, 1, 1, 'ALINEACION')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20109, 'Alineación')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('ALINEACION'), 1, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20110, 'P', 1, 1, 1, 1, 'REDES')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20110, 'Redes')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('REDES'), 0, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20111, 'P', 1, 1, 1, 1, 'ZONA_DEPOSITO')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20111, 'Zona de Depósito')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('ZONA_DEPOSITO'), 1, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20112, 'P', 1, 1, 1, 1, 'TIPO_MERCANCIA')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20112, 'Tipo de Mercancía')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('TIPO_MERCANCIA'), 1, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20113, 'P', 1, 1, 1, 1, 'CONTADOR')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20113, 'Contador')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('CONTADOR'), 0, 1, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20114, 'P', 1, 1, 1, 1, 'PUNTO_RED')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20114, 'Punto de Red (Maestro)')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('PUNTO_RED'), 0, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20115, 'P', 1, 1, 1, 1, 'TIPO_ATRAQUE_EDI')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20115, 'Tipo de Atraque EDI')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('TIPO_ATRAQUE_EDI'), 1, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20116, 'P', 1, 1, 1, 1, 'MUNICIPIO')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20116, 'Municipio')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('MUNICIPIO'), 1, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20117, 'P', 1, 1, 1, 1, 'TIPO_BUQUE_GT_EEE')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20117, 'Tipo de Buque GT EEE')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('TIPO_BUQUE_GT_EEE'), 0, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20118, 'P', 1, 1, 1, 1, 'AMARRE_DEP')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20118, 'Amarre Deportivo')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('AMARRE_DEP'), 0, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20119, 'P', 1, 1, 1, 1, 'TIPO_LECTURA')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20119, 'Tipo de Lectura (Pto Red)')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('TIPO_LECTURA'), 0, 0, NULL)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20120, 'P', 1, 1, 1, 1, 'EMBARCACION_DEP')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20120, 'Embarcación Dep.')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('EMBARCACION_DEP'), 0, 0, 41021)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (20121, 'P', 1, 1, 1, 1, 'EMBARCACION_DEP_AUT')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20121, 'Embarcación Dep. Aut.')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp, tppr_tpdt_pk) VALUES (portico.getEntidad('EMBARCACION_DEP_AUT'), 0, 0, 41021)\





-- Entidades - Subtipos de parametro

-- Buque
-- Trafico
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (24000, 'B', 1, 1, 1, 1, 'BUQUE_TRAFICO')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 24000, 'Servicio de Buque')\
INSERT INTO portico.tbl_tipo_subparametro_tpsp(tpsp_pk, tpsp_tppr_pk, tpsp_tppr_dep_pk, tpsp_es_i18n, tpsp_es_tmp_exp) VALUES (24000, 20005, 20086, 0, 1)\
	INSERT INTO portico.tbl_entidad_entidad_enen (enen_entip_pk, enen_entih_pk, enen_orden) VALUES (20005, 24000, 1)\
-- Subtipo de Residuo
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (24001, 'B', 1, 1, 1, 1, 'BUQUE_CAPACIDAD')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 24001, 'Capacidad de Buque')\
INSERT INTO portico.tbl_tipo_subparametro_tpsp(tpsp_pk, tpsp_tppr_pk, tpsp_tppr_dep_pk, tpsp_es_i18n, tpsp_es_tmp_exp) VALUES (24001, 20005, 20089, 0, 1)\
	INSERT INTO portico.tbl_entidad_entidad_enen (enen_entip_pk, enen_entih_pk, enen_orden) VALUES (20005, 24001, 2)\
-- Certificado
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (24002, 'B', 1, 1, 1, 1, 'BUQUE_CERTIFICADO')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 24002, 'Certificado de Buque')\
INSERT INTO portico.tbl_tipo_subparametro_tpsp(tpsp_pk, tpsp_tppr_pk, tpsp_tppr_dep_pk, tpsp_es_i18n, tpsp_es_tmp_exp) VALUES (24002, 20005, 20094, 0, 1)\
	INSERT INTO portico.tbl_entidad_entidad_enen (enen_entip_pk, enen_entih_pk, enen_orden) VALUES (20005, 24002, 3)\
-- Subpuerto
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (24003, 'B', 1, 1, 1, 1, 'BUQUE_SUBPUERTO')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 24003, 'Subpuerto de Buque')\
INSERT INTO portico.tbl_tipo_subparametro_tpsp(tpsp_pk, tpsp_tppr_pk, tpsp_tppr_dep_pk, tpsp_es_i18n, tpsp_es_tmp_exp) VALUES (24003, 20005, 20063, 0, 0)\
	INSERT INTO portico.tbl_entidad_entidad_enen (enen_entip_pk, enen_entih_pk, enen_orden) VALUES (20005, 24003, 4)\
-- Convenio
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (24004, 'B', 1, 1, 1, 1, 'BUQUE_CONVENIO')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 24004, 'Convenio de Buque')\
INSERT INTO portico.tbl_tipo_subparametro_tpsp(tpsp_pk, tpsp_tppr_pk, tpsp_tppr_dep_pk, tpsp_es_i18n, tpsp_es_tmp_exp) VALUES (24004, 20005, 20093, 0, 1)\
	INSERT INTO portico.tbl_entidad_entidad_enen (enen_entip_pk, enen_entih_pk, enen_orden) VALUES (20005, 24004, 5)\
-- TODO Contador Buque

-- Organizacion
-- Subpuerto
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (24010, 'B', 1, 1, 1, 1, 'ORGANIZACION_SUBPUERTO')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 24010, 'Subpuerto de Organización')\
INSERT INTO portico.tbl_tipo_subparametro_tpsp(tpsp_pk, tpsp_tppr_pk, tpsp_tppr_dep_pk, tpsp_es_i18n, tpsp_es_tmp_exp) VALUES (24010, 20010, 20063, 0, 0)\
	INSERT INTO portico.tbl_entidad_entidad_enen (enen_entip_pk, enen_entih_pk, enen_orden) VALUES (20010, 24010, 1)\
-- Tipo
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (24011, 'B', 1, 1, 1, 1, 'ORGANIZACION_TIPO')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 24011, 'Tipos de Organización')\
INSERT INTO portico.tbl_tipo_subparametro_tpsp(tpsp_pk, tpsp_tppr_pk, tpsp_tppr_dep_pk, tpsp_es_i18n, tpsp_es_tmp_exp) VALUES (24011, 20010, 20106, 0, 0)\
	INSERT INTO portico.tbl_entidad_entidad_enen (enen_entip_pk, enen_entih_pk, enen_orden) VALUES (20010, 24011, 2)\

-- Punto de Red
-- Cliente
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (24012, 'B', 1, 1, 1, 1, 'PUNTO_RED_ORGANIZACION')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 24012, 'Cliente de Pto de Red')\
INSERT INTO portico.tbl_tipo_subparametro_tpsp(tpsp_pk, tpsp_tppr_pk, tpsp_tppr_dep_pk, tpsp_es_i18n, tpsp_es_tmp_exp) VALUES (24012, 20114, 20010, 0, 1)\
	INSERT INTO portico.tbl_entidad_entidad_enen (enen_entip_pk, enen_entih_pk, enen_orden) VALUES (20114, 24012, 1)\
-- Gasto
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (24013, 'B', 1, 1, 1, 1, 'PUNTO_RED_TIPO_GASTO')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 24013, 'Tipo de Gasto de Pto de Red')\
INSERT INTO portico.tbl_tipo_subparametro_tpsp(tpsp_pk, tpsp_tppr_pk, tpsp_tppr_dep_pk, tpsp_es_i18n, tpsp_es_tmp_exp) VALUES (24013, 20114, 20025, 0, 1)\
	INSERT INTO portico.tbl_entidad_entidad_enen (enen_entip_pk, enen_entih_pk, enen_orden) VALUES (20114, 24013, 2)\
-- Lectura
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (24014, 'B', 1, 1, 1, 1, 'PUNTO_RED_TIPO_LECTURA')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 24014, 'Tipo de Lectura de Pto de Red')\
INSERT INTO portico.tbl_tipo_subparametro_tpsp(tpsp_pk, tpsp_tppr_pk, tpsp_tppr_dep_pk, tpsp_es_i18n, tpsp_es_tmp_exp) VALUES (24014, 20114, 20119, 0, 1)\
	INSERT INTO portico.tbl_entidad_entidad_enen (enen_entip_pk, enen_entih_pk, enen_orden) VALUES (20114, 24014, 3)\

-- Amarre
-- Servicio Deportivo
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (24015, 'B', 1, 1, 1, 1, 'AMARRE_SERVICIO_DEPORTIVO')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 24015, 'Servicio Deportivo de Amarre')\
INSERT INTO portico.tbl_tipo_subparametro_tpsp(tpsp_pk, tpsp_tppr_pk, tpsp_tppr_dep_pk, tpsp_es_i18n, tpsp_es_tmp_exp) VALUES (24015, 20118, 20099, 0, 0)\
	INSERT INTO portico.tbl_entidad_entidad_enen (enen_entip_pk, enen_entih_pk, enen_orden) VALUES (20118, 24015, 1)\
-- Punto de Red
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (24016, 'B', 1, 1, 1, 1, 'AMARRE_PUNTO_RED')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 24016, 'Punto de Red de Amarre')\
INSERT INTO portico.tbl_tipo_subparametro_tpsp(tpsp_pk, tpsp_tppr_pk, tpsp_tppr_dep_pk, tpsp_es_i18n, tpsp_es_tmp_exp) VALUES (24016, 20118, 20114, 0, 0)\
	INSERT INTO portico.tbl_entidad_entidad_enen (enen_entip_pk, enen_entih_pk, enen_orden) VALUES (20118, 24016, 2)\



-- Entidades - Tipos de Servicio y sus subservicios

-- Manifiestos de Pesca
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (21001, 'T', 1, 1, 1, 1, 'MANIFIESTO_PESCA')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 21001, 'Manifiesto de Pesca')\
INSERT INTO portico.tbl_tipo_servicio_tpsr(tpsr_pk, tpsr_es_temporal, tpsr_es_facturable, tpsr_es_exencionable, tpsr_tpdt_estado_pk) VALUES (21001, 0, 1, 1, 43065)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (22001, 'S', 1, 1, 1, 1, 'PARTIDA_PESCA')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 22001, 'Partida de Pesca')\
INSERT INTO portico.tbl_tipo_subservicio_tpss(tpss_pk, tpss_tpsr_pk, tpss_es_temporal, tpss_es_facturable, tpss_es_exencionable, tpss_tpdt_estado_pk) VALUES (22001, 21001, 0, 0, 1, NULL)\
	INSERT INTO portico.tbl_entidad_entidad_enen (enen_entip_pk, enen_entih_pk, enen_orden) VALUES (21001, 22001, 1)\

-- Manifiesto de Mercancia
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (21002, 'T', 1, 1, 1, 1, 'MANIFIESTO')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 21002, 'Manifiesto de Mercancía')\
INSERT INTO portico.tbl_tipo_servicio_tpsr(tpsr_pk, tpsr_es_temporal, tpsr_es_facturable, tpsr_es_exencionable, tpsr_tpdt_estado_pk) VALUES (21002, 0, 1, 1, portico.getTipoDato('ESTADO_MAN_MERC'))\
	INSERT INTO portico.tbl_entidad_accion_enac(enac_pk, enac_enti_pk, enac_orden, enac_path) VALUES (27004, 21002, 1, 'mani-totales')\
		INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enac', 'es', 27004, 'Verif. Totales')\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (22002, 'S', 1, 1, 1, 1, 'MANIFIESTO_CONSIGNATARIO')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 22002, 'Consignatario de Manifiesto')\
INSERT INTO portico.tbl_tipo_subservicio_tpss(tpss_pk, tpss_tpsr_pk, tpss_es_temporal, tpss_es_facturable, tpss_es_exencionable, tpss_tpdt_estado_pk) VALUES (22002, 21002, 0, 0, 1, null)\
	INSERT INTO portico.tbl_entidad_entidad_enen (enen_entip_pk, enen_entih_pk, enen_orden) VALUES (21002, 22002, 1)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (22003, 'S', 1, 1, 1, 1, 'BL')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 22003, 'BL')\
INSERT INTO portico.tbl_tipo_subservicio_tpss(tpss_pk, tpss_tpsr_pk, tpss_es_temporal, tpss_es_facturable, tpss_es_exencionable, tpss_tpdt_estado_pk) VALUES (22003, 21002, 0, 0, 1, portico.getTipoDato('ESTADO_BL'))\
	INSERT INTO portico.tbl_entidad_entidad_enen (enen_entip_pk, enen_entih_pk, enen_orden) VALUES (21002, 22003, 2)\
	INSERT INTO portico.tbl_entidad_entidad_enen (enen_entip_pk, enen_entih_pk, enen_orden) VALUES (22002, 22003, 1)\
	INSERT INTO portico.tbl_entidad_accion_enac(enac_pk, enac_enti_pk, enac_orden, enac_path) VALUES (27054, 22003, 1, 'mabl-totales')\
		INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enac', 'es', 27054, 'Verif. Totales')\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (22004, 'S', 1, 1, 1, 1, 'PARTIDA')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 22004, 'Partida')\
INSERT INTO portico.tbl_tipo_subservicio_tpss(tpss_pk, tpss_tpsr_pk, tpss_es_temporal, tpss_es_facturable, tpss_es_exencionable, tpss_tpdt_estado_pk) VALUES (22004, 21002, 0, 1, 1, portico.getTipoDato('ESTADO_PART'))\
	INSERT INTO portico.tbl_entidad_entidad_enen (enen_entip_pk, enen_entih_pk, enen_orden) VALUES (22003, 22004, 1)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (22005, 'S', 1, 1, 1, 1, 'EQUIPAMIENTO')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 22005, 'Equipamiento')\
INSERT INTO portico.tbl_tipo_subservicio_tpss(tpss_pk, tpss_tpsr_pk, tpss_es_temporal, tpss_es_facturable, tpss_es_exencionable, tpss_tpdt_estado_pk) VALUES (22005, 21002, 0, 1, 1, portico.getTipoDato('ESTADO_EQUI'))\
	INSERT INTO portico.tbl_entidad_entidad_enen (enen_entip_pk, enen_entih_pk, enen_orden) VALUES (22003, 22005, 2)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (22006, 'S', 1, 1, 1, 1, 'PARTIDA_EQUIPAMIENTO')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 22006, 'Partida-Equipamiento')\
INSERT INTO portico.tbl_tipo_subservicio_tpss(tpss_pk, tpss_tpsr_pk, tpss_es_temporal, tpss_es_facturable, tpss_es_exencionable, tpss_tpdt_estado_pk) VALUES (22006, 21002, 0, 0, 1, NULL)\
	INSERT INTO portico.tbl_entidad_entidad_enen (enen_entip_pk, enen_entih_pk, enen_orden) VALUES (22004, 22006, 1)\
	INSERT INTO portico.tbl_entidad_entidad_enen (enen_entip_pk, enen_entih_pk, enen_orden) VALUES (22005, 22006, 1)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (22007, 'S', 1, 1, 1, 1, 'PARTIDA_DOCUMENTO')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 22007, 'Documento de la Partida')\
INSERT INTO portico.tbl_tipo_subservicio_tpss(tpss_pk, tpss_tpsr_pk, tpss_es_temporal, tpss_es_facturable, tpss_es_exencionable, tpss_tpdt_estado_pk) VALUES (22007, 21002, 0, 0, 1, NULL)\
-- TODO Tiene Estado
	INSERT INTO portico.tbl_entidad_entidad_enen (enen_entip_pk, enen_entih_pk, enen_orden) VALUES (22004, 22007, 2)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (22008, 'S', 1, 1, 1, 1, 'PARTIDA_IM')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 22008, 'Instrucción de Marcaje de la Partida')\
INSERT INTO portico.tbl_tipo_subservicio_tpss(tpss_pk, tpss_tpsr_pk, tpss_es_temporal, tpss_es_facturable, tpss_es_exencionable, tpss_tpdt_estado_pk) VALUES (22008, 21002, 0, 0, 1, NULL)\
	INSERT INTO portico.tbl_entidad_entidad_enen (enen_entip_pk, enen_entih_pk, enen_orden) VALUES (22004, 22008, 3)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (22009, 'S', 1, 1, 1, 1, 'PARTIDA_MMPP')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 22009, 'MM.PP. de la Partida')\
INSERT INTO portico.tbl_tipo_subservicio_tpss(tpss_pk, tpss_tpsr_pk, tpss_es_temporal, tpss_es_facturable, tpss_es_exencionable, tpss_tpdt_estado_pk) VALUES (22009, 21002, 0, 0, 1, NULL)\
	INSERT INTO portico.tbl_entidad_entidad_enen (enen_entip_pk, enen_entih_pk, enen_orden) VALUES (22004, 22009, 4)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (22010, 'S', 1, 1, 1, 1, 'PRECINTO_EQUIPAMIENTO')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 22010, 'Precinto de Equipamiento')\
INSERT INTO portico.tbl_tipo_subservicio_tpss(tpss_pk, tpss_tpsr_pk, tpss_es_temporal, tpss_es_facturable, tpss_es_exencionable, tpss_tpdt_estado_pk) VALUES (22010, 21002, 0, 0, 1, NULL)\
	INSERT INTO portico.tbl_entidad_entidad_enen (enen_entip_pk, enen_entih_pk, enen_orden) VALUES (22005, 22010, 2)\

-- Escala
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (21003, 'T', 1, 1, 1, 1, 'ESCALA')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 21003, 'Escala')\
INSERT INTO portico.tbl_tipo_servicio_tpsr(tpsr_pk, tpsr_es_temporal, tpsr_es_facturable, tpsr_es_exencionable, tpsr_tpdt_estado_pk) VALUES (21003, 1, 1, 1, 43265)\
	INSERT INTO portico.tbl_entidad_accion_enac(enac_pk, enac_enti_pk, enac_orden, enac_path) VALUES (27250, 21003, 1, 'esca-notificar')\
		INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enac', 'es', 27250, 'Not. Practico')\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (22011, 'S', 1, 1, 1, 1, 'ATRAQUE')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 22011, 'Atraque')\
INSERT INTO portico.tbl_tipo_subservicio_tpss(tpss_pk, tpss_tpsr_pk, tpss_es_temporal, tpss_es_facturable, tpss_es_exencionable, tpss_tpdt_estado_pk) VALUES (22011, 21003, 1, 1, 1, 43235)\
	INSERT INTO portico.tbl_entidad_entidad_enen (enen_entip_pk, enen_entih_pk, enen_orden) VALUES (21003, 22011, 1)\
	INSERT INTO portico.tbl_entidad_accion_enac(enac_pk, enac_enti_pk, enac_orden, enac_path) VALUES (27205, 22011, 6, 'atra-cambiar-muelle')\
		INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enac', 'es', 27205, 'C. Muelle')\
	INSERT INTO portico.tbl_entidad_accion_enac(enac_pk, enac_enti_pk, enac_orden, enac_path) VALUES (27206, 22011, 7, 'atra-autorizar-fprevio')\
		INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enac', 'es', 27206, 'Aut. F. Previo')\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (22015, 'S', 0, 0, 0, 0, 'ESCALA_CONTADOR')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 22015, 'Contador de Escala')\
INSERT INTO portico.tbl_tipo_subservicio_tpss(tpss_pk, tpss_tpsr_pk, tpss_es_temporal, tpss_es_facturable, tpss_es_exencionable, tpss_tpdt_estado_pk) VALUES (22015, 21003, 0, 0, 1, NULL)\
	INSERT INTO portico.tbl_entidad_entidad_enen (enen_entip_pk, enen_entih_pk, enen_orden) VALUES (21003, 22015, 2)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (22016, 'S', 1, 1, 1, 1, 'ESCALA_RESIDUO')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 22016, 'Residuo de Escala')\
INSERT INTO portico.tbl_tipo_subservicio_tpss(tpss_pk, tpss_tpsr_pk, tpss_es_temporal, tpss_es_facturable, tpss_es_exencionable, tpss_tpdt_estado_pk) VALUES (22016, 21003, 0, 0, 1, NULL)\
	INSERT INTO portico.tbl_entidad_entidad_enen (enen_entip_pk, enen_entih_pk, enen_orden) VALUES (21003, 22016, 3)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (22012, 'S', 1, 1, 1, 1, 'OPERACION_ATRAQUE')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 22012, 'Operación de Atraque')\
INSERT INTO portico.tbl_tipo_subservicio_tpss(tpss_pk, tpss_tpsr_pk, tpss_es_temporal, tpss_es_facturable, tpss_es_exencionable, tpss_tpdt_estado_pk) VALUES (22012, 21003, 1, 1, 1, NULL)\
	INSERT INTO portico.tbl_entidad_entidad_enen (enen_entip_pk, enen_entih_pk, enen_orden) VALUES (22011, 22012, 1)\

-- Embarcacion Dep. Aut.
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (21004, 'T', 1, 1, 1, 1, 'SERV_EMBARCACION_DEP_AUT')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 21004, 'Embarcación Deportiva Autonómica')\
INSERT INTO portico.tbl_tipo_servicio_tpsr(tpsr_pk, tpsr_es_temporal, tpsr_es_facturable, tpsr_es_exencionable, tpsr_tpdt_estado_pk) VALUES (21004, 0, 1, 1, NULL)\

-- Suministro a Buque
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (21005, 'T', 1, 1, 1, 1, 'SUMINISTRO_CONSUMO')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 21005, 'Suministro a Buque')\
INSERT INTO portico.tbl_tipo_servicio_tpsr(tpsr_pk, tpsr_es_temporal, tpsr_es_facturable, tpsr_es_exencionable, tpsr_tpdt_estado_pk) VALUES (21005, 1, 1, 1, 43295)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (22013, 'S', 1, 1, 1, 1, 'SUMINISTRO_CONSUMO_GASTO')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 22013, 'Gasto de Consumo')\
INSERT INTO portico.tbl_tipo_subservicio_tpss(tpss_pk, tpss_tpsr_pk, tpss_es_temporal, tpss_es_facturable, tpss_es_exencionable, tpss_tpdt_estado_pk) VALUES (22013, 21005, 1, 1, 1, NULL)\
	INSERT INTO portico.tbl_entidad_entidad_enen (enen_entip_pk, enen_entih_pk, enen_orden) VALUES (21005, 22013, 1)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (22014, 'S', 1, 1, 1, 1, 'SUMINISTRO_CONSUMO_LECTURA')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 22014, 'Lectura de Consumo')\
INSERT INTO portico.tbl_tipo_subservicio_tpss(tpss_pk, tpss_tpsr_pk, tpss_es_temporal, tpss_es_facturable, tpss_es_exencionable, tpss_tpdt_estado_pk) VALUES (22014, 21005, 1, 1, 1, NULL)\
	INSERT INTO portico.tbl_entidad_entidad_enen (enen_entip_pk, enen_entih_pk, enen_orden) VALUES (21005, 22014, 2)\

-- Ocupacion de Superficie
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (21007, 'T', 1, 1, 1, 1, 'OCUPACION_SUPERFICIE')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 21007, 'Ocupación de Superficie')\
INSERT INTO portico.tbl_tipo_servicio_tpsr(tpsr_pk, tpsr_es_temporal, tpsr_es_facturable, tpsr_es_exencionable, tpsr_tpdt_estado_pk) VALUES (21007, 1, 1, 1, 43290)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (22018, 'S', 1, 1, 1, 1, 'OCUPACION_SUPERFICIE_LINEA')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 22018, 'Linea de Ocupación de Superficie')\
INSERT INTO portico.tbl_tipo_subservicio_tpss(tpss_pk, tpss_tpsr_pk, tpss_es_temporal, tpss_es_facturable, tpss_es_exencionable, tpss_tpdt_estado_pk) VALUES (22018, 21007, 1, 1, 1, NULL)\
	INSERT INTO portico.tbl_entidad_entidad_enen (enen_entip_pk, enen_entih_pk, enen_orden) VALUES (21007, 22018, 1)\

-- Amarres
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (21008, 'T', 1, 1, 1, 1, 'AMARRE')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 21008, 'Amarre')\
INSERT INTO portico.tbl_tipo_servicio_tpsr(tpsr_pk, tpsr_es_temporal, tpsr_es_facturable, tpsr_es_exencionable, tpsr_tpdt_estado_pk) VALUES (21008, 1, 0, 1, 43230)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (22019, 'S', 1, 1, 1, 1, 'AMARRE_MEDIO')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 22019, 'Medio de Amarre')\
INSERT INTO portico.tbl_tipo_subservicio_tpss(tpss_pk, tpss_tpsr_pk, tpss_es_temporal, tpss_es_facturable, tpss_es_exencionable, tpss_tpdt_estado_pk) VALUES (22019, 21008, 0, 0, 1, NULL)\
	INSERT INTO portico.tbl_entidad_entidad_enen (enen_entip_pk, enen_entih_pk, enen_orden) VALUES (21008, 22019, 1)\

-- Practicajes
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (21009, 'T', 1, 1, 1, 1, 'PRACTICAJE')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 21009, 'Practicaje')\
INSERT INTO portico.tbl_tipo_servicio_tpsr(tpsr_pk, tpsr_es_temporal, tpsr_es_facturable, tpsr_es_exencionable, tpsr_tpdt_estado_pk) VALUES (21009, 1, 0, 1, 43275)\

-- Asignacion Amarre
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (21010, 'T', 1, 1, 1, 1, 'ASIGNACION_AMARRE')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 21010, 'Asignación de Amarre')\
INSERT INTO portico.tbl_tipo_servicio_tpsr(tpsr_pk, tpsr_es_temporal, tpsr_es_facturable, tpsr_es_exencionable, tpsr_tpdt_estado_pk) VALUES (21010, 1, 1, 1, 43200)\














-- Entidades - Estadistica
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (23000, 'E', 0, 0, 0, 0, 'ACTIVIDAD_PESQUERA')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 23000, 'Actividad Pesquera')\
	INSERT INTO portico.tbl_tipo_estadistica_tpes(tpes_pk) VALUES (23000)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (23001, 'E', 0, 0, 0, 0, 'AGREGACION_ESCALA')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 23001, 'Agregación de Escala')\
	INSERT INTO portico.tbl_tipo_estadistica_tpes(tpes_pk) VALUES (23001)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (23002, 'E', 0, 0, 0, 0, 'AGREGACION_SUPERFICIE')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 23002, 'Agregación de Superficie')\
	INSERT INTO portico.tbl_tipo_estadistica_tpes(tpes_pk) VALUES (23002)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (23003, 'E', 0, 0, 0, 0, 'AVITUALLAMIENTO')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 23003, 'Avituallamiento')\
	INSERT INTO portico.tbl_tipo_estadistica_tpes(tpes_pk) VALUES (23003)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (23004, 'E', 0, 0, 0, 0, 'BUQUE_FONDEADO_ATRACADO')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 23004, 'Buque Fondeo atraque')\
	INSERT INTO portico.tbl_tipo_estadistica_tpes(tpes_pk) VALUES (23004)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (23005, 'E', 0, 0, 0, 0, 'MOVIMIENTO_MERCANCIA')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 23005, 'Movimiento de Mercancía')\
	INSERT INTO portico.tbl_tipo_estadistica_tpes(tpes_pk) VALUES (23005)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (23006, 'E', 0, 0, 0, 0, 'MOVIMIENTO_MERCANCIA_EEE')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 23006, 'Movimiento de Mercancía EEE')\
	INSERT INTO portico.tbl_tipo_estadistica_tpes(tpes_pk) VALUES (23006)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado, enti_codigo) VALUES (23007, 'E', 0, 0, 0, 0, 'MOVIMIENTO_TIPO_BUQUE_EEE')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 23007, 'Movimiento de Tipo Buque EEE')\
	INSERT INTO portico.tbl_tipo_estadistica_tpes(tpes_pk) VALUES (23007)\






-- Tipos de dato - Tipos de Servicio
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (47000, 'F', 'SR', 21002, 'MANIFIESTO')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 47000, 'Manifiesto')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (47001, 'F', 'SR', 21003, 'ESCALA')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 47001, 'Escala')\

-- Tipos de dato - Parametros
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45000, 'S', 'PR', 20001, 'TIPO_ACT')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45000, 'Tipo de Actividad')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45005, 'F', 'PR', 20004, 'PAIS')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45005, 'País')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45006, 'F', 'PR', 20004, 'PAIS_2')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45006, 'País 2')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45010, 'F', 'PR', 20005, 'BUQUE')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45010, 'Buque')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45015, 'S', 'PR', 20006, 'AREA_MUNDIAL')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45015, 'Area Mundial')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45020, 'S', 'PR', 20007, 'TIPO_BUQUE_EEE')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45020, 'Tipo de Buque EEE')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45025, 'S', 'PR', 20008, 'TIPO_BUQUE_EST')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45025, 'Tipo de Buque Est')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45030, 'S', 'PR', 20009, 'TIPO_BUQUE')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45030, 'Tipo de Buque')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45031, 'S', 'PR', 20009, 'TIPO_BUQUE_2')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45031, 'Tipo de Buque 2')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45035, 'F', 'PR', 20010, 'ORGA')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45035, 'Organización')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45036, 'F', 'PR', 20010, 'ORGA_2')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45036, 'Organización 2')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45037, 'F', 'PR', 20010, 'ORGA_3')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45037, 'Organización 3')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45040, 'S', 'PR', 20011, 'TIPO_IVA')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45040, 'Tipo de IVA')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45045, 'S', 'PR', 20012, 'AREA_GEOG')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45045, 'Area Geográfica')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45050, 'F', 'PR', 20013, 'ZONA_COST_EEE')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45050, 'Zona Costera EEE')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45055, 'F', 'PR', 20014, 'UNLOCODE')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45055, 'Unlocode')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45056, 'F', 'PR', 20014, 'UNLOCODE_2')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45056, 'Unlocode 2')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45057, 'F', 'PR', 20014, 'UNLOCODE_3')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45057, 'Unlocode 3')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45058, 'F', 'PR', 20014, 'UNLOCODE_4')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45058, 'Unlocode 4')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45059, 'F', 'PR', 20014, 'UNLOCODE_5')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45059, 'Unlocode 5')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45060, 'S', 'PR', 20015, 'TIPO_ALIN')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45060, 'Tipo de Alineación')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45065, 'S', 'PR', 20030, 'ZONA_PESCA')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45065, 'Zona de Pesca')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45070, 'S', 'PR', 20032, 'TIPO_OP_PESCA')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45070, 'Tipo de Operación de Pesca')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45075, 'S', 'PR', 20033, 'TIPO_MAN_PESCA')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45075, 'Tipo de Manifiesto de Pesca')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45080, 'S', 'PR', 20034, 'SUBT_MAN_PESCA')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45080, 'Subtipo de Manifiesto de Pesca')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45085, 'S', 'PR', 20035, 'GRUPO_FAM_PESCA')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45085, 'Grupo de Familia de Especie de Pesca')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45090, 'S', 'PR', 20036, 'FAM_PESCA')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45090, 'Familia de Especie de Pesca')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45095, 'S', 'PR', 20037, 'TIPO_CAPTURA_PESCA')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45095, 'Tipo de Captura de Pesca')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45100, 'S', 'PR', 20039, 'TIPO_BUQUE_PESCA')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45100, 'Tipo de Buque de Pesca')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45105, 'F', 'PR', 20040, 'BUQUE_PESCA')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45105, 'Buque de Pesca')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45110, 'S', 'PR', 20041, 'ARTE_PESCA')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45110, 'Arte de Pesca')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45115, 'S', 'PR', 20042, 'TIPO_MERC_EST')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45115, 'Tipo de Mercancía Est')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45120, 'S', 'PR', 20043, 'GRUPO_NAT_MERC')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45120, 'Grupo de Naturaleza de Mercancía')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45125, 'S', 'PR', 20044, 'NAT_MERC')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45125, 'Naturaleza de Mercancía')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45130, 'S', 'PR', 20045, 'GRUPO_ARAN')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45130, 'Grupo Arancelario')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45135, 'S', 'PR', 20046, 'SUBG_MERC')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45135, 'Subgrupo Mercancía')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45140, 'S', 'PR', 20047, 'GRUPO_NST')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45140, 'Grupo NST')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45145, 'S', 'PR', 20048, 'UNIDAD_CARGA')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45145, 'Unidad de Carga')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45150, 'S', 'PR', 20063, 'SUBPUERTO')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45150, 'Subpuerto')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45155, 'S', 'PR', 20066, 'TIPO_EXENCION')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45155, 'Tipo de Exención')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45160, 'S', 'PR', 20075, 'TIPO_BIEN_CONC')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45160, 'Tipo de Bien Concesional')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45165, 'S', 'PR', 20076, 'TIPO_ACT_GRAL_CONC')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45165, 'Tipo de Actividad General Concesional')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45170, 'F', 'PR', 20082, 'REG_TBUQUE_EEE')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45170, 'Registro de Tipo de Buque EEE')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45175, 'F', 'PR', 20083, 'REG_TBUQUE')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45175, 'Registro de Tipo de Buque')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45180, 'F', 'PR', 20109, 'ALIN')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45180, 'Alineación')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45185, 'S', 'PR', 20088, 'TIPO_RESIDUO')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45185, 'Tipo de Residuo')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45190, 'F', 'PR', 20091, 'MUELLE')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45190, 'Muelle')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45195, 'S', 'PR', 20097, 'TIPO_EMB')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45195, 'Tipo de Embarcación')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45200, 'S', 'PR', 20098, 'TIPO_AMA')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45200, 'Tipo de Amarre')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45205, 'S', 'PR', 20102, 'MODULO')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45205, 'Módulo')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45210, 'S', 'PR', 20107, 'AUT_PORT')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45210, 'Autoridad Portuaria')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45215, 'S', 'PR', 20038, 'ESPECIE_PESCA')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45215, 'Especie de Pesca')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45220, 'F', 'PR', 20108, 'COMPRADOR_PESCA')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45220, 'Comprador de Pesca')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45225, 'S', 'PR', 20031, 'PRESENT_PESCA')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45225, 'Presentación de Pesca')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45230, 'S', 'PR', 20085, 'TIPO_BUQUE_GT')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45230, 'Tipo de Buque GT')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45235, 'S', 'PR', 20065, 'TIPO_NAV')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45235, 'Tipo de Navegación')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45236, 'S', 'PR', 20065, 'TIPO_NAV_2')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45236, 'Tipo de Navegación 2')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45240, 'F', 'PR', 20086, 'SERV_TRAF')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45240, 'Servicio de Tráfico')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45245, 'S', 'PR', 20003, 'ACUERDO')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45245, 'Acuerdo')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45250, 'S', 'PR', 20020, 'TIPO_SUP')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45250, 'Tipo de Superficie')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45255, 'S', 'PR', 20021, 'GRUPO_ZONA')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45255, 'Grupo Zona')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45260, 'S', 'PR', 20111, 'ZONA_DEP')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45260, 'Zona de Depósito')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45265, 'S', 'PR', 20022, 'UNID_SUP')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45265, 'Unidad de Superficie')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45270, 'S', 'PR', 20023, 'TIPO_OP_SUP')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45270, 'Tipo de Operación de Superficie')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45275, 'S', 'PR', 20024, 'TIPO_SUM')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45275, 'Tipo de Suministro')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45290, 'F', 'PR', 20049, 'MERCANCIA')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45290, 'Mercancía')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45300, 'S', 'PR', 20061, 'INST_ESP')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45300, 'Inst. Especial')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45305, 'S', 'PR', 20055, 'TERMINAL')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45305, 'Terminal')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45310, 'S', 'PR', 20052, 'TIPO_DOC_AEAT')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45310, 'Tipo de Documento AEAT')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45315, 'S', 'PR', 20060, 'INST_MARC')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45315, 'Instrucción de Marcaje')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45320, 'F', 'PR', 20058, 'MERC_PELIG')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45320, 'Mercancías Peligrosas')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45325, 'F', 'PR', 20051, 'TIPO_EQUI')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45325, 'Tipo de Equipamiento')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45330, 'S', 'PR', 20059, 'MARCA_VEHIC')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45330, 'Marca de Vehículo')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45335, 'S', 'PR', 20056, 'RECEPTOR')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45335, 'Receptor')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45345, 'F', 'PR', 20053, 'TIPO_BULTO')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45345, 'Tipo de Bulto')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45350, 'S', 'PR', 20057, 'MODO_TRANS_EDI')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45350, 'Modo de transporte EDI')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45360, 'S', 'PR', 20068, 'DESC_ADIC')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45360, 'Descuento Adicional')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45365, 'S', 'PR', 20054, 'REC_ADU')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45365, 'Recinto Aduanero')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45370, 'S', 'PR', 20064, 'TIPO_OP_MERC')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45370, 'Tipo de Operación de Mercancía')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45380, 'S', 'PR', 20096, 'TIPO_ATR')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45380, 'Tipo de Atraque')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45385, 'S', 'PR', 20112, 'TIPO_MERC')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45385, 'Tipo de Mercancía')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45390, 'S', 'PR', 20025, 'TIPO_GASTO_SUM')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45390, 'Tipo de Gasto (Sum)')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45395, 'S', 'PR', 20113, 'CONTADOR_SUM')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45395, 'Contador (Sum)')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45400, 'S', 'PR', 20026, 'TIPO_CONT')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45400, 'Tipo de Contador')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45405, 'S', 'PR', 20114, 'PUNTO_RED')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45405, 'Punto de Red (Maestro)')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45410, 'S', 'PR', 20115, 'TIPO_ATR_EDI')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45410, 'Tipo de Atraque EDI')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45415, 'S', 'PR', 20017, 'TIPO_MOV_AMA')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45415, 'Tipo de Movimiento de Amarre')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45420, 'S', 'PR', 20016, 'TIPO_MED_AMA')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45420, 'Tipo de Medio de Amarre')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45425, 'S', 'PR', 20027, 'TIPO_MANIOBRA_PRAC')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45425, 'Tipo de Maniobra de Practicaje')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45430, 'S', 'PR', 20062, 'PROVINCIA')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45430, 'Provincia')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45435, 'F', 'PR', 20116, 'MUNICIPIO')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45435, 'Municipio')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45440, 'S', 'PR', 20089, 'SUBT_RES')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45440, 'Subtipo de Residuo')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45445, 'S', 'PR', 20117, 'TIPO_BUQUE_GT_EEE')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45445, 'Tipo de Buque GT EEE')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45450, 'F', 'PR', 20118, 'AMARRE_DEP')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45450, 'Amarre Dep.')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45451, 'F', 'PR', 20118, 'AMARRE_DEP_2')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45451, 'Amarre Dep. 2')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45455, 'F', 'PR', 20101, 'INSTALACION_DEP')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45455, 'Instalación Dep.')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45460, 'S', 'PR', 20110, 'REDES')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45460, 'Red')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45465, 'F', 'PR', 20100, 'INSTALACION_DEP_AUT')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45465, 'Instalación Dep. Aut.')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45470, 'F', 'PR', 20120, 'EMBARCACION_DEP')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45470, 'Embarcación Dep.')\
INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45475, 'F', 'PR', 20121, 'EMBARCACION_DEP_AUT')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45475, 'Embarcación Dep. Aut.')\













-- //@UNDO
-- SQL to undo the change goes here.

TRUNCATE TABLE tbl_proceso_archivo_prar\
TRUNCATE TABLE tbl_proceso_item_prit\
TRUNCATE TABLE tbl_proceso_mensaje_prmn\
TRUNCATE TABLE tbl_proceso_parametro_prpm\
DELETE FROM portico.tbl_proceso_batch_prbt\



-- Tipos de dato - Tipos de Servicio
DELETE FROM portico.tbl_i18n_i18n
WHERE i18n_pref = 'tpdt' AND i18n_lang = 'es' AND EXISTS (
	SELECT 1 FROM portico.tbl_tipo_dato_tpdt
	WHERE tpdt_pk = i18n_ext_pk AND tpdt_pk IN (
		47000
		, 47001
	)
)\
DELETE FROM portico.tbl_tipo_dato_tpdt
WHERE tpdt_pk IN (
	47000
	, 47001
)\

-- Tipos de dato - Parametros
DELETE FROM portico.tbl_i18n_i18n
WHERE i18n_pref = 'tpdt' AND i18n_lang = 'es' AND EXISTS (
	SELECT 1 FROM portico.tbl_tipo_dato_tpdt
	WHERE tpdt_pk = i18n_ext_pk AND tpdt_pk IN (
		45000
		, 45005
		, 45006
		, 45010
		, 45015
		, 45020
		, 45025
		, 45030
		, 45031
		, 45035
		, 45036
		, 45037
		, 45040
		, 45045
		, 45050
		, 45055
		, 45056
		, 45057
		, 45058
		, 45059
		, 45060
		, 45065
		, 45070
		, 45075
		, 45080
		, 45085
		, 45090
		, 45095
		, 45100
		, 45105
		, 45110
		, 45115
		, 45120
		, 45125
		, 45130
		, 45135
		, 45140
		, 45145
		, 45150
		, 45155
		, 45160
		, 45165
		, 45170
		, 45175
		, 45180
		, 45185
		, 45190
		, 45195
		, 45200
		, 45205
		, 45210
		, 45215
		, 45220
		, 45225
		, 45230
		, 45235
		, 45236
		, 45240
		, 45245
		, 45250
		, 45255
		, 45260
		, 45265
		, 45270
		, 45275
		, 45290
		, 45300
		, 45305
		, 45310
		, 45315
		, 45320
		, 45325
		, 45330
		, 45335
		, 45345
		, 45350
		, 45360
		, 45365
		, 45370
		, 45380
		, 45385
		, 45390
		, 45395
		, 45400
		, 45405
		, 45410
		, 45415
		, 45420
		, 45425
		, 45430
		, 45435
		, 45440
		, 45445
		, 45450
		, 45451
		, 45455
		, 45460
		, 45465
		, 45470
		, 45475
	)
)\
DELETE FROM portico.tbl_tipo_dato_tpdt
WHERE tpdt_pk IN (
	45000
	, 45005
	, 45006
	, 45010
	, 45015
	, 45020
	, 45025
	, 45030
	, 45031
	, 45035
	, 45036
	, 45037
	, 45040
	, 45045
	, 45050
	, 45055
	, 45056
	, 45057
	, 45058
	, 45059
	, 45060
	, 45065
	, 45070
	, 45075
	, 45080
	, 45085
	, 45090
	, 45095
	, 45100
	, 45105
	, 45110
	, 45115
	, 45120
	, 45125
	, 45130
	, 45135
	, 45140
	, 45145
	, 45150
	, 45155
	, 45160
	, 45165
	, 45170
	, 45175
	, 45180
	, 45185
	, 45190
	, 45195
	, 45200
	, 45205
	, 45210
	, 45215
	, 45220
	, 45225
	, 45230
	, 45235
	, 45236
	, 45240
	, 45245
	, 45250
	, 45255
	, 45260
	, 45265
	, 45270
	, 45275
	, 45290
	, 45300
	, 45305
	, 45310
	, 45315
	, 45320
	, 45325
	, 45330
	, 45335
	, 45345
	, 45350
	, 45360
	, 45365
	, 45370
	, 45380
	, 45385
	, 45390
	, 45395
	, 45400
	, 45405
	, 45410
	, 45415
	, 45420
	, 45425
	, 45430
	, 45435
	, 45440
	, 45445
	, 45450
	, 45451
	, 45455
	, 45460
	, 45465
	, 45470
	, 45475
)\









-- Entidades - Estadistica
DELETE FROM portico.tbl_i18n_i18n
WHERE i18n_pref = 'enti' AND i18n_lang = 'es' AND EXISTS (
	SELECT 1 FROM portico.tbl_entidad_enti
	WHERE enti_pk = i18n_ext_pk AND enti_pk IN (
		23000
		, 23001
		, 23002
		, 23003
		, 23004
		, 23005
		, 23006
		, 23007
	)
)\
DELETE FROM portico.tbl_tipo_estadistica_tpes
WHERE tpes_pk IN (
	23000
	, 23001
	, 23002
	, 23003
	, 23004
	, 23005
	, 23006
	, 23007
)\
DELETE FROM portico.tbl_entidad_enti
WHERE enti_pk IN (
	23000
	, 23001
	, 23002
	, 23003
	, 23004
	, 23005
	, 23006
	, 23007
)\






-- Entidades - Tipos de Servicio y sus subservicios
DELETE FROM portico.tbl_entidad_entidad_enen
WHERE enen_entih_pk IN (
	21001
	, 22001
	, 21002
	, 22002
	, 22003
	, 22004
	, 22005
	, 22006
	, 22007
	, 22008
	, 22009
	, 22010
	, 21003
	, 22011
	, 22015
	, 22016
	, 22012
	, 21004
	, 21005
	, 22013
	, 22014
	, 21007
	, 22018
	, 21008
	, 22019
	, 21009
	, 21010
)\

DELETE FROM portico.tbl_i18n_i18n
WHERE i18n_pref = 'enac' AND i18n_lang = 'es' AND EXISTS (
	SELECT 1 FROM portico.tbl_entidad_accion_enac
	WHERE enac_pk = i18n_ext_pk AND enac_enti_pk IN (
		21001
		, 22001
		, 21002
		, 22002
		, 22003
		, 22004
		, 22005
		, 22006
		, 22007
		, 22008
		, 22009
		, 22010
		, 21003
		, 22011
		, 22015
		, 22016
		, 22012
		, 21004
		, 21005
		, 22013
		, 22014
		, 21007
		, 22018
		, 21008
		, 22019
		, 21009
		, 21010
	)
)\
DELETE FROM portico.tbl_entidad_accion_enac
WHERE enac_enti_pk IN (
	21001
	, 22001
	, 21002
	, 22002
	, 22003
	, 22004
	, 22005
	, 22006
	, 22007
	, 22008
	, 22009
	, 22010
	, 21003
	, 22011
	, 22015
	, 22016
	, 22012
	, 21004
	, 21005
	, 22013
	, 22014
	, 21007
	, 22018
	, 21008
	, 22019
	, 21009
	, 21010
)\

DELETE FROM portico.tbl_tipo_subservicio_tpss
WHERE tpss_pk IN (
	21001
	, 22001
	, 21002
	, 22002
	, 22003
	, 22004
	, 22005
	, 22006
	, 22007
	, 22008
	, 22009
	, 22010
	, 21003
	, 22011
	, 22015
	, 22016
	, 22012
	, 21004
	, 21005
	, 22013
	, 22014
	, 21007
	, 22018
	, 21008
	, 22019
	, 21009
	, 21010
)\

DELETE FROM portico.tbl_tipo_servicio_tpsr
WHERE tpsr_pk IN (
	21001
	, 22001
	, 21002
	, 22002
	, 22003
	, 22004
	, 22005
	, 22006
	, 22007
	, 22008
	, 22009
	, 22010
	, 21003
	, 22011
	, 22015
	, 22016
	, 22012
	, 21004
	, 21005
	, 22013
	, 22014
	, 21007
	, 22018
	, 21008
	, 22019
	, 21009
	, 21010
)\

DELETE FROM portico.tbl_i18n_i18n
WHERE i18n_pref = 'enti' AND i18n_lang = 'es' AND EXISTS (
	SELECT 1 FROM portico.tbl_entidad_enti
	WHERE enti_pk = i18n_ext_pk AND enti_pk IN (
		21001
		, 22001
		, 21002
		, 22002
		, 22003
		, 22004
		, 22005
		, 22006
		, 22007
		, 22008
		, 22009
		, 22010
		, 21003
		, 22011
		, 22015
		, 22016
		, 22012
		, 21004
		, 21005
		, 22013
		, 22014
		, 21007
		, 22018
		, 21008
		, 22019
		, 21009
		, 21010
	)
)\
DELETE FROM portico.tbl_entidad_enti
WHERE enti_pk IN (
	21001
	, 22001
	, 21002
	, 22002
	, 22003
	, 22004
	, 22005
	, 22006
	, 22007
	, 22008
	, 22009
	, 22010
	, 21003
	, 22011
	, 22015
	, 22016
	, 22012
	, 21004
	, 21005
	, 22013
	, 22014
	, 21007
	, 22018
	, 21008
	, 22019
	, 21009
	, 21010
)\






-- Entidades - Subtipos de parametro
DELETE FROM portico.tbl_entidad_entidad_enen
WHERE enen_entih_pk IN (
24000
	, 24001
	, 24002
	, 24003
	, 24004
	, 24010
	, 24011
	, 24012
	, 24013
	, 24014
	, 24015
	, 24016
)\

DELETE FROM portico.tbl_tipo_subparametro_tpsp
WHERE tpsp_pk IN (
24000
	, 24001
	, 24002
	, 24003
	, 24004
	, 24010
	, 24011
	, 24012
	, 24013
	, 24014
	, 24015
	, 24016
)\

DELETE FROM portico.tbl_i18n_i18n
WHERE i18n_pref = 'enti' AND i18n_lang = 'es' AND EXISTS (
	SELECT 1 FROM portico.tbl_entidad_enti
	WHERE enti_pk = i18n_ext_pk AND enti_pk IN (
		24000
		, 24001
		, 24002
		, 24003
		, 24004
		, 24010
		, 24011
		, 24012
		, 24013
		, 24014
		, 24015
		, 24016
	)
)\
DELETE FROM portico.tbl_entidad_enti
WHERE enti_pk IN (
	24000
	, 24001
	, 24002
	, 24003
	, 24004
	, 24010
	, 24011
	, 24012
	, 24013
	, 24014
	, 24015
	, 24016
)\




-- Entidades - Tipos de parametro
DELETE FROM portico.tbl_tipo_parametro_tppr
WHERE tppr_pk IN (
	20001
	, 20002
	, 20003
	, 20004
	, 20005
	, 20006
	, 20007
	, 20008
	, 20009
	, 20010
	, 20011
	, 20012
	, 20013
	, 20014
	, 20015
	, 20016
	, 20017
	, 20018
	, 20019
	, 20020
	, 20021
	, 20022
	, 20023
	, 20024
	, 20025
	, 20026
	, 20027
	, 20028
	, 20029
	, 20030
	, 20031
	, 20032
	, 20033
	, 20034
	, 20035
	, 20036
	, 20037
	, 20038
	, 20039
	, 20040
	, 20041
	, 20042
	, 20043
	, 20044
	, 20045
	, 20046
	, 20047
	, 20048
	, 20049
	, 20051
	, 20052
	, 20053
	, 20054
	, 20055
	, 20056
	, 20057
	, 20058
	, 20059
	, 20060
	, 20061
	, 20062
	, 20063
	, 20064
	, 20065
	, 20066
	, 20067
	, 20068
	, 20069
	, 20070
	, 20071
	, 20072
	, 20073
	, 20074
	, 20075
	, 20076
	, 20077
	, 20078
	, 20079
	, 20080
	, 20081
	, 20082
	, 20083
	, 20084
	, 20085
	, 20086
	, 20087
	, 20088
	, 20089
	, 20090
	, 20091
	, 20093
	, 20094
	, 20095
	, 20096
	, 20097
	, 20098
	, 20099
	, 20100
	, 20101
	, 20102
	, 20103
	, 20104
	, 20105
	, 20106
	, 20107
	, 20108
	, 20109
	, 20110
	, 20111
	, 20112
	, 20113
	, 20114
	, 20115
	, 20116
	, 20117
	, 20118
	, 20119
	, 20120
	, 20121
)\

DELETE FROM portico.tbl_i18n_i18n
WHERE i18n_pref = 'enti' AND i18n_lang = 'es' AND EXISTS (
	SELECT 1 FROM portico.tbl_entidad_enti
	WHERE enti_pk = i18n_ext_pk AND enti_pk IN (
		20001
		, 20002
		, 20003
		, 20004
		, 20005
		, 20006
		, 20007
		, 20008
		, 20009
		, 20010
		, 20011
		, 20012
		, 20013
		, 20014
		, 20015
		, 20016
		, 20017
		, 20018
		, 20019
		, 20020
		, 20021
		, 20022
		, 20023
		, 20024
		, 20025
		, 20026
		, 20027
		, 20028
		, 20029
		, 20030
		, 20031
		, 20032
		, 20033
		, 20034
		, 20035
		, 20036
		, 20037
		, 20038
		, 20039
		, 20040
		, 20041
		, 20042
		, 20043
		, 20044
		, 20045
		, 20046
		, 20047
		, 20048
		, 20049
		, 20051
		, 20052
		, 20053
		, 20054
		, 20055
		, 20056
		, 20057
		, 20058
		, 20059
		, 20060
		, 20061
		, 20062
		, 20063
		, 20064
		, 20065
		, 20066
		, 20067
		, 20068
		, 20069
		, 20070
		, 20071
		, 20072
		, 20073
		, 20074
		, 20075
		, 20076
		, 20077
		, 20078
		, 20079
		, 20080
		, 20081
		, 20082
		, 20083
		, 20084
		, 20085
		, 20086
		, 20087
		, 20088
		, 20089
		, 20090
		, 20091
		, 20093
		, 20094
		, 20095
		, 20096
		, 20097
		, 20098
		, 20099
		, 20100
		, 20101
		, 20102
		, 20103
		, 20104
		, 20105
		, 20106
		, 20107
		, 20108
		, 20109
		, 20110
		, 20111
		, 20112
		, 20113
		, 20114
		, 20115
		, 20116
		, 20117
		, 20118
		, 20119
		, 20120
		, 20121
	)
)\
DELETE FROM portico.tbl_entidad_enti
WHERE enti_pk IN (
	20001
	, 20002
	, 20003
	, 20004
	, 20005
	, 20006
	, 20007
	, 20008
	, 20009
	, 20010
	, 20011
	, 20012
	, 20013
	, 20014
	, 20015
	, 20016
	, 20017
	, 20018
	, 20019
	, 20020
	, 20021
	, 20022
	, 20023
	, 20024
	, 20025
	, 20026
	, 20027
	, 20028
	, 20029
	, 20030
	, 20031
	, 20032
	, 20033
	, 20034
	, 20035
	, 20036
	, 20037
	, 20038
	, 20039
	, 20040
	, 20041
	, 20042
	, 20043
	, 20044
	, 20045
	, 20046
	, 20047
	, 20048
	, 20049
	, 20051
	, 20052
	, 20053
	, 20054
	, 20055
	, 20056
	, 20057
	, 20058
	, 20059
	, 20060
	, 20061
	, 20062
	, 20063
	, 20064
	, 20065
	, 20066
	, 20067
	, 20068
	, 20069
	, 20070
	, 20071
	, 20072
	, 20073
	, 20074
	, 20075
	, 20076
	, 20077
	, 20078
	, 20079
	, 20080
	, 20081
	, 20082
	, 20083
	, 20084
	, 20085
	, 20086
	, 20087
	, 20088
	, 20089
	, 20090
	, 20091
	, 20093
	, 20094
	, 20095
	, 20096
	, 20097
	, 20098
	, 20099
	, 20100
	, 20101
	, 20102
	, 20103
	, 20104
	, 20105
	, 20106
	, 20107
	, 20108
	, 20109
	, 20110
	, 20111
	, 20112
	, 20113
	, 20114
	, 20115
	, 20116
	, 20117
	, 20118
	, 20119
	, 20120
	, 20121
)\




-- Tipos de Dato - Codigos de Referencia
DELETE FROM portico.tbl_i18n_i18n
WHERE i18n_pref = 'cdrf' AND i18n_lang = 'es' AND EXISTS (
	SELECT 1 FROM portico.tbl_codigo_ref_cdrf
	WHERE i18n_ext_pk = cdrf_pk AND cdrf_tpdt_pk IN (
		43000
		, 43005
		, 43010
		, 43015
		, 43020
		, 43025
		, 43030
		, 43035
		, 43040
		, 43045
		, 43050
		, 43055
		, 43060
		, 43065
		, 43070
		, 43075
		, 43080
		, 43085
		, 43090
		, 43100
		, 43105
		, 43110
		, 43115
		, 43120
		, 43125
		, 43130
		, 43135
		, 43140
		, 43145
		, 43150
		, 43155
		, 43160
		, 43165
		, 43170
		, 43175
		, 43180
		, 43185
		, 43190
		, 43195
		, 43200
		, 43205
		, 43210
		, 43215
		, 43220
		, 43225
		, 43230
		, 43235
		, 43240
		, 43245
		, 43250
		, 43255
		, 43260
		, 43265
		, 43270
		, 43275
		, 43280
		, 43285
		, 43290
		, 43295
		, 43300
		, 43305
		, 43310
		, 43315
		, 43320
		, 43325
		, 43330
		, 43335
		, 43340
		, 43345
		, 43350
		, 43355
		, 43360
		, 43365
		, 43370
		, 43375
		, 43380
		, 43385
		, 43390
		, 43395
		, 43400
		, 43405
		, 43410
		, 43415
		, 43420
		, 43425
		, 43430
		, 43435
		, 43440
		, 43445
		, 43450
		, 43455
		, 43460
		, 43465
		, 43470
		, 43475
		, 43480
		, 43485
		, 43490
		, 43495
		, 43515
		, 43520
		, 43525
		, 43540
		, 43545
		, 43550
		, 43555
	)
)\

DELETE FROM portico.tbl_codigo_ref_cdrf
WHERE cdrf_tpdt_pk IN (
	43000
	, 43005
	, 43010
	, 43015
	, 43020
	, 43025
	, 43030
	, 43035
	, 43040
	, 43045
	, 43050
	, 43055
	, 43060
	, 43065
	, 43070
	, 43075
	, 43080
	, 43085
	, 43090
	, 43100
	, 43105
	, 43110
	, 43115
	, 43120
	, 43125
	, 43130
	, 43135
	, 43140
	, 43145
	, 43150
	, 43155
	, 43160
	, 43165
	, 43170
	, 43175
	, 43180
	, 43185
	, 43190
	, 43195
	, 43200
	, 43205
	, 43210
	, 43215
	, 43220
	, 43225
	, 43230
	, 43235
	, 43240
	, 43245
	, 43250
	, 43255
	, 43260
	, 43265
	, 43270
	, 43275
	, 43280
	, 43285
	, 43290
	, 43295
	, 43300
	, 43305
	, 43310
	, 43315
	, 43320
	, 43325
	, 43330
	, 43335
	, 43340
	, 43345
	, 43350
	, 43355
	, 43360
	, 43365
	, 43370
	, 43375
	, 43380
	, 43385
	, 43390
	, 43395
	, 43400
	, 43405
	, 43410
	, 43415
	, 43420
	, 43425
	, 43430
	, 43435
	, 43440
	, 43445
	, 43450
	, 43455
	, 43460
	, 43465
	, 43470
	, 43475
	, 43480
	, 43485
	, 43490
	, 43495
	, 43515
	, 43520
	, 43525
	, 43540
	, 43545
	, 43550
	, 43555
)\

DELETE FROM portico.tbl_i18n_i18n
WHERE i18n_pref = 'tpdt' AND i18n_lang = 'es' AND EXISTS (
	SELECT 1 FROM portico.tbl_tipo_dato_tpdt
	WHERE tpdt_pk = i18n_ext_pk AND tpdt_pk IN (
		43000
		, 43005
		, 43010
		, 43015
		, 43020
		, 43025
		, 43030
		, 43035
		, 43040
		, 43045
		, 43050
		, 43055
		, 43060
		, 43065
		, 43070
		, 43075
		, 43080
		, 43085
		, 43090
		, 43100
		, 43105
		, 43110
		, 43115
		, 43120
		, 43125
		, 43130
		, 43135
		, 43140
		, 43145
		, 43150
		, 43155
		, 43160
		, 43165
		, 43170
		, 43175
		, 43180
		, 43185
		, 43190
		, 43195
		, 43200
		, 43205
		, 43210
		, 43215
		, 43220
		, 43225
		, 43230
		, 43235
		, 43240
		, 43245
		, 43250
		, 43255
		, 43260
		, 43265
		, 43270
		, 43275
		, 43280
		, 43285
		, 43290
		, 43295
		, 43300
		, 43305
		, 43310
		, 43315
		, 43320
		, 43325
		, 43330
		, 43335
		, 43340
		, 43345
		, 43350
		, 43355
		, 43360
		, 43365
		, 43370
		, 43375
		, 43380
		, 43385
		, 43390
		, 43395
		, 43400
		, 43405
		, 43410
		, 43415
		, 43420
		, 43425
		, 43430
		, 43435
		, 43440
		, 43445
		, 43450
		, 43455
		, 43460
		, 43465
		, 43470
		, 43475
		, 43480
		, 43485
		, 43490
		, 43495
		, 43515
		, 43520
		, 43525
		, 43540
		, 43545
		, 43550
		, 43555
	)
)\
DELETE FROM portico.tbl_tipo_dato_tpdt
WHERE tpdt_pk IN (
	43000
	, 43005
	, 43010
	, 43015
	, 43020
	, 43025
	, 43030
	, 43035
	, 43040
	, 43045
	, 43050
	, 43055
	, 43060
	, 43065
	, 43070
	, 43075
	, 43080
	, 43085
	, 43090
	, 43100
	, 43105
	, 43110
	, 43115
	, 43120
	, 43125
	, 43130
	, 43135
	, 43140
	, 43145
	, 43150
	, 43155
	, 43160
	, 43165
	, 43170
	, 43175
	, 43180
	, 43185
	, 43190
	, 43195
	, 43200
	, 43205
	, 43210
	, 43215
	, 43220
	, 43225
	, 43230
	, 43235
	, 43240
	, 43245
	, 43250
	, 43255
	, 43260
	, 43265
	, 43270
	, 43275
	, 43280
	, 43285
	, 43290
	, 43295
	, 43300
	, 43305
	, 43310
	, 43315
	, 43320
	, 43325
	, 43330
	, 43335
	, 43340
	, 43345
	, 43350
	, 43355
	, 43360
	, 43365
	, 43370
	, 43375
	, 43380
	, 43385
	, 43390
	, 43395
	, 43400
	, 43405
	, 43410
	, 43415
	, 43420
	, 43425
	, 43430
	, 43435
	, 43440
	, 43445
	, 43450
	, 43455
	, 43460
	, 43465
	, 43470
	, 43475
	, 43480
	, 43485
	, 43490
	, 43495
	, 43515
	, 43520
	, 43525
	, 43540
	, 43545
	, 43550
	, 43555
)\




-- Tipos de Dato - Simples
DELETE FROM portico.tbl_i18n_i18n
WHERE i18n_pref = 'tpdt' AND i18n_lang = 'es' AND EXISTS (
	SELECT 1 FROM portico.tbl_tipo_dato_tpdt
	WHERE tpdt_pk = i18n_ext_pk AND tpdt_pk IN (
		41000
		, 41001
		, 41002
		, 41003
		, 41004
		, 41005
		, 41006
		, 41007
		, 41008
		, 41009
		, 41010
		, 41011
		, 41012
		, 41013
		, 41014
		, 41015
		, 41016
		, 41017
		, 41018
		, 41019

		, 41020
		, 41021
		, 41022
		, 41023
		, 41024
		, 41025
		, 41026
		, 41027
		, 41028
		, 41029
		, 41030
		, 41031
		, 41032
		, 41033
		, 41034

		, 41040
		, 41041
		, 41042
		, 41043
		, 41044
		, 41045
		, 41046
		, 41047
		, 41048
		, 41049
		, 41050
		, 41051
		, 41052
		, 41053
		, 41054
		, 41055
		, 41056
		, 41057
		, 41058
		, 41059

		, 41060
		, 41061
		, 41062
		, 41063
		, 41064
		, 41065
		, 41066
		, 41067
		, 41068
		, 41069
		, 41070
		, 41071
		, 41072
		, 41073
		, 41074
		, 41075
		, 41076
		, 41077
		, 41078
		, 41079

		, 41080
		, 41081
		, 41082
		, 41083
		, 41084

		, 41100
		, 41101
		, 41102
		, 41103
		, 41104

		, 41120
		, 41121
		, 41122
		, 41123
		, 41124
	)
)\
DELETE FROM portico.tbl_tipo_dato_tpdt
WHERE tpdt_pk IN (
	41000
	, 41001
	, 41002
	, 41003
	, 41004
	, 41005
	, 41006
	, 41007
	, 41008
	, 41009
	, 41010
	, 41011
	, 41012
	, 41013
	, 41014
	, 41015
	, 41016
	, 41017
	, 41018
	, 41019

	, 41020
	, 41021
	, 41022
	, 41023
	, 41024
	, 41025
	, 41026
	, 41027
	, 41028
	, 41029
	, 41030
	, 41031
	, 41032
	, 41033
	, 41034

	, 41040
	, 41041
	, 41042
	, 41043
	, 41044
	, 41045
	, 41046
	, 41047
	, 41048
	, 41049
	, 41050
	, 41051
	, 41052
	, 41053
	, 41054
	, 41055
	, 41056
	, 41057
	, 41058
	, 41059

	, 41060
	, 41061
	, 41062
	, 41063
	, 41064
	, 41065
	, 41066
	, 41067
	, 41068
	, 41069
	, 41070
	, 41071
	, 41072
	, 41073
	, 41074
	, 41075
	, 41076
	, 41077
	, 41078
	, 41079

	, 41080
	, 41081
	, 41082
	, 41083
	, 41084

	, 41100
	, 41101
	, 41102
	, 41103
	, 41104

	, 41120
	, 41121
	, 41122
	, 41123
	, 41124
)\

DELETE FROM portico.tbl_ig
WHERE ig_nombre = 'sq_integra'\

