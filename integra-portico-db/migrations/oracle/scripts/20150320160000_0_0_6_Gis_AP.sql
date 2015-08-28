-- // 20150320160000_0_0_6_Gis_AP.sql
-- Migration SQL that makes the change goes here.
INSERT INTO tbl_superpuerto_sprt (sprt_pk, sprt_codigo) VALUES (36100, '0')\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_ext_pk, i18n_lang, i18n_text) VALUES ('sprt', 36100, 'es', 'Autp Genérica')\
INSERT INTO tbl_superpuerto_sprt (sprt_pk, sprt_codigo) VALUES (36101, '*')\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_ext_pk, i18n_lang, i18n_text) VALUES ('sprt', 36101, 'es', 'Autp Genérica 2')\

INSERT INTO tbl_superpuerto_sprt (sprt_pk, sprt_codigo) VALUES (36000, '80')\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_ext_pk, i18n_lang, i18n_text) VALUES ('sprt', 36000, 'es', 'Baleares')\



INSERT INTO tbl_puerto_prto (prto_pk, prto_sprt_pk, prto_codigo, prto_codigo_corto, prto_codigo_edi, prto_rec_aduanero, prto_unlocode)
VALUES (37100, 36100, '0', '0', NULL, NULL, 'ES***')\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_ext_pk, i18n_lang, i18n_text) VALUES ('prto', 37100, 'es', 'Puerto Genérico')\
INSERT INTO tbl_puerto_prto (prto_pk, prto_sprt_pk, prto_codigo, prto_codigo_corto, prto_codigo_edi, prto_rec_aduanero, prto_unlocode)
VALUES (37101, 36101, '*', '*', NULL, NULL, 'ES***')\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_ext_pk, i18n_lang, i18n_text) VALUES ('prto', 37101, 'es', 'Puerto Genérico 2')\

INSERT INTO tbl_puerto_prto (prto_pk, prto_sprt_pk, prto_codigo, prto_codigo_corto, prto_codigo_edi, prto_rec_aduanero, prto_unlocode)
VALUES (37000, 36000, '81', 'P', '1', '0711', 'ESPMI')\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_ext_pk, i18n_lang, i18n_text) VALUES ('prto', 37000, 'es', 'Palma')\
INSERT INTO tbl_puerto_prto (prto_pk, prto_sprt_pk, prto_codigo, prto_codigo_corto, prto_codigo_edi, prto_rec_aduanero, prto_unlocode)
VALUES (37001, 36000, '82', 'A', '2', '0717', 'ESALD')\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_ext_pk, i18n_lang, i18n_text) VALUES ('prto', 37001, 'es', 'Alcudia')\
INSERT INTO tbl_puerto_prto (prto_pk, prto_sprt_pk, prto_codigo, prto_codigo_corto, prto_codigo_edi, prto_rec_aduanero, prto_unlocode)
VALUES (37002, 36000, '83', 'I', '3', '0721', 'ESIBZ')\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_ext_pk, i18n_lang, i18n_text) VALUES ('prto', 37002, 'es', 'Ibiza')\
INSERT INTO tbl_puerto_prto (prto_pk, prto_sprt_pk, prto_codigo, prto_codigo_corto, prto_codigo_edi, prto_rec_aduanero, prto_unlocode)
VALUES (37003, 36000, '84', 'F', '4', '0725', 'ESFNI')\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_ext_pk, i18n_lang, i18n_text) VALUES ('prto', 37003, 'es', 'Formentera')\
INSERT INTO tbl_puerto_prto (prto_pk, prto_sprt_pk, prto_codigo, prto_codigo_corto, prto_codigo_edi, prto_rec_aduanero, prto_unlocode)
VALUES (37004, 36000, '85', 'M', '5', NULL, 'ESMAH')\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_ext_pk, i18n_lang, i18n_text) VALUES ('prto', 37004, 'es', 'La Savina')\

-- Hacer que maestros puedan ser dependientes de tbl_puerto_prto
UPDATE tbl_entidad_enti SET enti_puerto = 1 WHERE enti_pk = 20109\ -- ALINEACION
UPDATE tbl_entidad_enti SET enti_puerto = 1 WHERE enti_pk = 20118\ -- AMARRE_DEP
UPDATE tbl_entidad_enti SET enti_puerto = 1 WHERE enti_pk = 20113\ -- CONTADOR
UPDATE tbl_entidad_enti SET enti_puerto = 1 WHERE enti_pk = 20101\ -- INSTALACION_DEP
UPDATE tbl_entidad_enti SET enti_puerto = 1 WHERE enti_pk = 20100\ -- INSTALACION_DEP_AUT
UPDATE tbl_entidad_enti SET enti_puerto = 1 WHERE enti_pk = 20061\ -- INSTALACION_ESPECIAL
UPDATE tbl_entidad_enti SET enti_puerto = 1 WHERE enti_pk = 20091\ -- MUELLE
UPDATE tbl_entidad_enti SET enti_puerto = 1 WHERE enti_pk = 20114\ -- PUNTO_RED
UPDATE tbl_entidad_enti SET enti_puerto = 1 WHERE enti_pk = 20110\ -- REDES
UPDATE tbl_entidad_enti SET enti_puerto = 1 WHERE enti_pk = 20086\ -- SERVICIO_TRAFICO
UPDATE tbl_entidad_enti SET enti_puerto = 1 WHERE enti_pk = 20078\ -- SUPRABIEN
UPDATE tbl_entidad_enti SET enti_puerto = 1 WHERE enti_pk = 20055\ -- TERMINAL
UPDATE tbl_entidad_enti SET enti_puerto = 1 WHERE enti_pk = 20111\ -- ZONA_DEPOSITO
UPDATE tbl_entidad_enti SET enti_puerto = 1 WHERE enti_pk = 20072\ -- ZONA_PORTUARIA







-- //@UNDO
-- SQL to undo the change goes here.


-- Borrado de tablas de puerto y superpuerto
DELETE FROM tbl_i18n_i18n WHERE i18n_pref = 'prto'\
DELETE FROM tbl_i18n_i18n WHERE i18n_pref = 'sprt'\
