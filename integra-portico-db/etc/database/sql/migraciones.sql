ALTER TABLE TBL_ENTIDAD_GRUPO_DATO_ENGD ADD engd_pk NUMBER(19);
UPDATE TBL_ENTIDAD_GRUPO_DATO_ENGD SET engd_pk = ENGD_ENTI_PK * 10 + ENGD_ORDEN;
ALTER TABLE TBL_ENTIDAD_GRUPO_DATO_ENGD drop constraint pk_engd;
ALTER table TBL_ENTIDAD_GRUPO_DATO_ENGD add CONSTRAINT pk_engd PRIMARY KEY  (engd_pk);
INSERT INTO TBL_I18N_I18N (I18N_PREF, I18N_LANG, I18N_EXT_PK, I18N_TEXT)
SELECT 'engd', 'es', engd_pk, engd_etiqueta
FROM TBL_ENTIDAD_GRUPO_DATO_ENGD
;
ALTER TABLE TBL_ENTIDAD_GRUPO_DATO_ENGD DROP COLUMN engd_etiqueta;


-- BACK
ALTER TABLE TBL_ENTIDAD_GRUPO_DATO_ENGD ADD engd_etiqueta VARCHAR2(255);

update TBL_ENTIDAD_GRUPO_DATO_ENGD set
  ENGD_ETIQUETA = (
		SELECT i18n_text
		FROM tbl_i18n_i18n
		WHERE i18n_ext_pk = engd_pk AND i18n_pref = 'engd' AND i18n_lang = 'es'
	)
;


DELETE FROM tbl_i18n_i18n
WHERE i18n_pref = 'engd'
	AND I18N_lang = 'es';

ALTER TABLE TBL_ENTIDAD_GRUPO_DATO_ENGD drop constraint pk_engd;
ALTER table TBL_ENTIDAD_GRUPO_DATO_ENGD add CONSTRAINT pk_engd PRIMARY KEY  (ENGD_ENTI_PK, ENGD_ORDEN);
ALTER TABLE TBL_ENTIDAD_GRUPO_DATO_ENGD DROP COLUMN engd_pk;
