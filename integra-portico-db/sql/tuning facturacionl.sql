
SELECT 
    vlrc_pk, vlrc_fref
    , rgla_crgo_pk
    , (
        SELECT crgo_codigo
        FROM tbl_cargo_crgo
        WHERE crgo_pk = rgla_crgo_pk
    ) AS crgo_codigo
    , SUM(vlrd_importe)
    , (
        SELECT i18n_text
        FROM tbl_i18n_i18n
        WHERE 
            i18n_pref = 'crgv'
            AND i18n_lang = 'es'
            AND i18n_ext_pk = (
                SELECT crgv_pk
                FROM 
                    tbl_cargo_version_crgv
                WHERE 
                    crgv_crgo_pk = rgla_crgo_pk
                    AND vlrc_fref BETWEEN crgv_fini AND COALESCE(crgv_ffin, vlrc_fref)
            )
    ) AS crgv_descripcion
FROM 
    tbl_valoracion_vlrc
    INNER JOIN tbl_valoracion_lin_vlrl ON
        vlrl_vlrc_pk = vlrc_pk
    INNER JOIN tbl_valoracion_det_vlrd ON
        vlrd_vlrl_pk = vlrl_pk
    INNER JOIN tbl_regla_rgla ON
        rgla_pk = vlrl_rgla_pk
-- WHERE vlrc_pk = 3093046
GROUP BY vlrc_pk, vlrc_fref, rgla_crgo_pk
;  

SELECT 
  vlrg_vlrc_pk, vlrg_crgo_pk

  , crgo_codigo

  , vlrc_fref AS vlrg_fref
  
  , (
      SELECT SUM(vlrd_importe)
      FROM tbl_valoracion_det_vlrd
      WHERE vlrd_vlrl_pk = ANY(
          SELECT vlrl_pk
          FROM tbl_valoracion_lin_vlrl
          WHERE vlrl_vlrc_pk = vlrg_vlrc_pk
            AND vlrl_rgla_pk = ANY(
              SELECT rgla_pk
              FROM tbl_regla_rgla
              WHERE rgla_crgo_pk = vlrg_crgo_pk
            )
      )
  ) AS vlrg_importe
FROM tbl_valoracion_cargo_vlrg
  INNER JOIN tbl_valoracion_vlrc vlrc ON
      vlrc_pk = vlrg_vlrc_pk
  INNER JOIN tbl_cargo_crgo ON
      crgo_pk = vlrg_crgo_pk
  INNER JOIN tbl_cargo_version_crgv crgv ON
      crgv_crgo_pk = vlrg_crgo_pk
      AND vlrc_fref BETWEEN crgv_fini AND COALESCE(crgv_ffin, vlrc_fref)
;

SELECT
  vlrl_pk, vlrl_padre_pk, vlrl_vlrc_pk, vlrl_rgla_pk, vlrl_impuesto_prmt_pk, vlrl_ssrv_pk, vlrl_fini, vlrl_ffin
  , vlrl_cuant1, vlrl_cuant2, vlrl_cuant3, vlrl_cuant4, vlrl_cuant5, vlrl_cuant6
  , vlrl_info1, vlrl_info2, vlrl_info3, vlrl_info4, vlrl_info5, vlrl_info6

  , rgla_crgo_pk, rgla_codigo

  , rglv_enti_pk, rglv_tipo, rglv_orden, rglv_importe_base
  , rglv_etiq_info1, rglv_etiq_info2, rglv_etiq_info3, rglv_etiq_info4, rglv_etiq_info5, rglv_etiq_info6
  , rglv_etiq_cuant1, rglv_etiq_cuant2, rglv_etiq_cuant3, rglv_etiq_cuant4, rglv_etiq_cuant5, rglv_etiq_cuant6
  
  , crgo_codigo
  
  , vlrc_fref AS vlrl_fref
  , (SELECT prmt_parametro FROM tbl_parametro_prmt WHERE prmt_pk = vlrl_impuesto_prmt_pk) AS vlrl_impuesto
  , (SELECT ssrv_numero FROM tbl_subservicio_ssrv WHERE ssrv_pk = vlrl_ssrv_pk) AS vlrl_ssrv_numero
  , (SELECT COUNT(1) FROM tbl_valoracion_det_vlrd WHERE vlrd_vlrl_pk = vlrl_pk) AS vlrl_vlrd_cnt
  , (SELECT SUM(vlrd_importe_base) FROM tbl_valoracion_det_vlrd WHERE vlrd_vlrl_pk = vlrl_pk) AS vlrl_importe_base
  , (SELECT SUM(vlrd_importe) FROM tbl_valoracion_det_vlrd WHERE vlrd_vlrl_pk = vlrl_pk) AS vlrl_importe
FROM tbl_valoracion_lin_vlrl vlrl
  INNER JOIN tbl_valoracion_vlrc vlrc ON
      vlrc_pk = vlrl_vlrc_pk
  INNER JOIN tbl_regla_rgla rgla ON
      rgla_pk = vlrl_rgla_pk
  INNER JOIN tbl_regla_version_rglv rglv ON
      rglv_rgla_pk = vlrl_rgla_pk
      AND vlrc_fref BETWEEN rglv_fini AND COALESCE(rglv_ffin, vlrc_fref)
  INNER JOIN tbl_cargo_crgo crgo ON
      crgo_pk = rgla_crgo_pk
;
