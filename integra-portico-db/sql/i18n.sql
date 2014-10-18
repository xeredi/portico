
SELECT prmt.*
    , (SELECT i18n_text FROM TBL_I18N_I18N
      WHERE TBL_I18N_I18N.I18N_PREF = 'prvr'
        AND TBL_I18N_I18N.I18N_EXT_PK = prvr_pk
        AND TBL_I18N_I18N.I18N_LANG = 'ca_ES'
    ) AS p18n_texto
FROM vw_PARAMETRO_PRMT prmt
WHERE PRMT_TPPR_PK = 20049;

INSERT INTO TBL_I18N_I18N (I18N_PREF, I18N_EXT_PK, I18N_LANG, I18N_TEXT)
SELECT I18N_PREF, I18N_EXT_PK, 'ca_ES', i18n.I18N_TEXT
FROM TBL_I18N_I18N i18n
WHERE
    i18n.I18N_LANG = 'es_ES'
    AND not EXISTS (
        SELECT 1
        FROM TBL_I18N_I18N i18nAUX
        WHERE i18nAUX.I18N_PREF = i18n.I18N_PREF
            AND i18nAUX.I18N_EXT_PK = i18n.I18N_EXT_PK
            AND i18nAUX.I18N_LANG = 'ca_ES'
    )
;
