-- // 0 0 6.sql
-- Migration SQL that makes the change goes here.

-- i18n de entidades
INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text)
SELECT 'enti', 'es', enti_pk, enti_nombre
FROM tbl_entidad_enti\

ALTER TABLE tbl_entidad_enti DROP COLUMN enti_nombre\


-- i18n de tipos de dato
INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text)
SELECT 'tpdt', 'es', tpdt_pk, tpdt_nombre
FROM tbl_tipo_dato_tpdt\

ALTER TABLE tbl_tipo_dato_tpdt DROP COLUMN tpdt_nombre\



















-- //@UNDO
-- SQL to undo the change goes here.

-- i18n de entidades
ALTER TABLE tbl_entidad_enti ADD enti_nombre VARCHAR2(255)\

UPDATE tbl_entidad_enti SET
	enti_nombre = (
		SELECT i18n_text
		FROM tbl_i18n_i18n
		WHERE i18n_ext_pk = enti_pk AND i18n_pref = 'enti'
	)\

DELETE FROM tbl_i18n_i18n
WHERE i18n_pref = 'enti'
	AND I18N_lang = 'es'\

-- i18n de tipos de dato
ALTER TABLE tbl_tipo_dato_tpdt ADD tpdt_nombre VARCHAR2(255)\

UPDATE tbl_tipo_dato_tpdt SET
	tpdt_nombre = (
		SELECT i18n_text
		FROM tbl_i18n_i18n
		WHERE i18n_ext_pk = tpdt_pk AND i18n_pref = 'tpdt'
	)\

DELETE FROM tbl_i18n_i18n
WHERE i18n_pref = 'tpdt'
  AND I18N_lang = 'es'\

