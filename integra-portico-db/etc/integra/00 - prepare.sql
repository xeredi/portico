DELETE FROM tbl_subparametro_dato_spdt;
DELETE FROM tbl_subparametro_version_spvr;
DELETE FROM tbl_subparametro_sprm;

DELETE FROM tbl_i18n_i18n
WHERE
    i18n_pref = 'prvr'
    AND EXISTS (
        SELECT 1
        FROM tbl_parametro_version_prvr
        WHERE prvr_pk = i18n_ext_pk
    )
;
DELETE FROM tbl_parametro_dato_prdt;
DELETE FROM tbl_parametro_version_prvr;
DELETE FROM tbl_parametro_prmt;

