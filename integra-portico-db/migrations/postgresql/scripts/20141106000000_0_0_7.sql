-- // 0 0 7.sql
-- Migration SQL that makes the change goes here.



-- i18n de tipos de datos de entidades
ALTER TABLE portico.tbl_entidad_tipo_dato_entd ADD entd_pk BIGINT\

UPDATE portico.tbl_entidad_tipo_dato_entd SET entd_pk = entd_enti_pk * 100000 + entd_tpdt_pk\

ALTER TABLE portico.tbl_entidad_tipo_dato_entd drop constraint pk_entd\

ALTER table portico.tbl_entidad_tipo_dato_entd add CONSTRAINT pk_entd PRIMARY KEY  (entd_pk)\

INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text)
SELECT 'entd', 'es', entd_pk, entd_etiqueta
FROM portico.tbl_entidad_tipo_dato_entd\

ALTER TABLE portico.tbl_entidad_tipo_dato_entd DROP COLUMN entd_etiqueta CASCADE\


















-- //@UNDO
-- SQL to undo the change goes here.

-- i18n de tipos de datos de entidades
ALTER TABLE portico.tbl_entidad_tipo_dato_entd ADD entd_etiqueta VARCHAR(255)\

UPDATE portico.tbl_entidad_tipo_dato_entd SET
 	entd_etiqueta = (
		SELECT i18n_text
		FROM portico.tbl_i18n_i18n
		WHERE i18n_ext_pk = entd_pk AND i18n_pref = 'entd' AND i18n_lang = 'es'
	)\

DELETE FROM portico.tbl_i18n_i18n
WHERE i18n_pref = 'entd'
	AND I18N_lang = 'es'\

ALTER TABLE portico.tbl_entidad_tipo_dato_entd DROP CONSTRAINT pk_entd\
ALTER TABLE portico.tbl_entidad_tipo_dato_entd ADD CONSTRAINT pk_entd PRIMARY KEY (entd_enti_pk, entd_tpdt_pk)\
ALTER TABLE portico.tbl_entidad_tipo_dato_entd DROP COLUMN entd_pk\
