-- // 0 0 6.sql
-- Migration SQL that makes the change goes here.

-- i18n de entidades
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text)
SELECT 'enti', 'es', enti_pk, enti_nombre
FROM portico.tbl_entidad_enti\

ALTER TABLE portico.tbl_entidad_enti DROP COLUMN enti_nombre CASCADE\


-- i18n de tipos de dato
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text)
SELECT 'tpdt', 'es', tpdt_pk, tpdt_nombre
FROM portico.tbl_tipo_dato_tpdt\

ALTER TABLE portico.tbl_tipo_dato_tpdt DROP COLUMN tpdt_nombre CASCADE\


-- i18n de aspectos
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text)
SELECT 'aspv', 'es', aspv_pk, aspv_descripcion
FROM portico.tbl_aspecto_version_aspv\

ALTER TABLE portico.tbl_aspecto_version_aspv DROP COLUMN aspv_descripcion CASCADE\


-- i18n de cargos
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text)
SELECT 'crgv', 'es', crgv_pk, crgv_descripcion
FROM portico.tbl_cargo_version_crgv\

ALTER TABLE portico.tbl_cargo_version_crgv DROP COLUMN crgv_descripcion CASCADE\


-- i18n de grupos de datos de entidades
ALTER TABLE portico.tbl_entidad_grupo_dato_engd ADD engd_pk BIGINT\

UPDATE portico.tbl_entidad_grupo_dato_engd SET engd_pk = engd_enti_pk * 10 + engd_orden\

ALTER TABLE portico.tbl_entidad_grupo_dato_engd drop constraint pk_engd\

ALTER table portico.tbl_entidad_grupo_dato_engd add CONSTRAINT pk_engd PRIMARY KEY  (engd_pk)\

INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text)
SELECT 'engd', 'es', engd_pk, engd_etiqueta
FROM portico.tbl_entidad_grupo_dato_engd\

ALTER TABLE portico.tbl_entidad_grupo_dato_engd DROP COLUMN engd_etiqueta CASCADE\



















-- //@UNDO
-- SQL to undo the change goes here.



-- i18n de grupos de datos de entidades
ALTER TABLE portico.tbl_entidad_grupo_dato_engd ADD engd_etiqueta VARCHAR(255)\

UPDATE portico.tbl_entidad_grupo_dato_engd SET
 	engd_etiqueta = (
		SELECT i18n_text
		FROM portico.tbl_i18n_i18n
		WHERE i18n_ext_pk = engd_pk AND i18n_pref = 'engd' AND i18n_lang = 'es'
	)\

DELETE FROM portico.tbl_i18n_i18n
WHERE i18n_pref = 'engd'
	AND I18N_lang = 'es'\

ALTER TABLE portico.tbl_entidad_grupo_dato_engd DROP CONSTRAINT pk_engd\
ALTER TABLE portico.tbl_entidad_grupo_dato_engd ADD CONSTRAINT pk_engd PRIMARY KEY (engd_enti_pk, engd_orden)\
ALTER TABLE portico.tbl_entidad_grupo_dato_engd DROP COLUMN engd_pk\


-- i18n de cargos
ALTER TABLE portico.tbl_cargo_version_crgv ADD crgv_descripcion VARCHAR(255)\

UPDATE portico.tbl_cargo_version_crgv SET
	crgv_descripcion = (
		SELECT i18n_text
		FROM portico.tbl_i18n_i18n
		WHERE i18n_ext_pk = crgv_pk AND i18n_pref = 'crgv'
	)\

DELETE FROM portico.tbl_i18n_i18n
WHERE i18n_pref = 'crgv'
	AND I18N_lang = 'es'\


-- i18n de aspectos
ALTER TABLE portico.tbl_aspecto_version_aspv ADD aspv_descripcion VARCHAR(255)\

UPDATE portico.tbl_aspecto_version_aspv SET
	aspv_descripcion = (
		SELECT i18n_text
		FROM portico.tbl_i18n_i18n
		WHERE i18n_ext_pk = aspv_pk AND i18n_pref = 'aspv' AND i18n_lang = 'es'
	)\

DELETE FROM portico.tbl_i18n_i18n
WHERE i18n_pref = 'aspv'
	AND I18N_lang = 'es'\


-- i18n de entidades
ALTER TABLE portico.tbl_entidad_enti ADD enti_nombre VARCHAR(255)\

UPDATE portico.tbl_entidad_enti SET
	enti_nombre = (
		SELECT i18n_text
		FROM portico.tbl_i18n_i18n
		WHERE i18n_ext_pk = enti_pk AND i18n_pref = 'enti' AND i18n_lang = 'es'
	)\

DELETE FROM portico.tbl_i18n_i18n
WHERE i18n_pref = 'enti'
	AND I18N_lang = 'es'\

-- i18n de tipos de dato
ALTER TABLE portico.tbl_tipo_dato_tpdt ADD tpdt_nombre VARCHAR(255)\

UPDATE portico.tbl_tipo_dato_tpdt SET
	tpdt_nombre = (
		SELECT i18n_text
		FROM portico.tbl_i18n_i18n
		WHERE i18n_ext_pk = tpdt_pk AND i18n_pref = 'tpdt' AND i18n_lang = 'es'
	)\

DELETE FROM portico.tbl_i18n_i18n
WHERE i18n_pref = 'tpdt'
  AND I18N_lang = 'es'\


