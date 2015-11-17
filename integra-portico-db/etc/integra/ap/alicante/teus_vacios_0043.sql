
  CREATE OR REPLACE VIEW "INTEGRA"."TEUS_VACIOS_0043" (
    "SMAN_ID", "SMAN_SUBP_ID", "SMAN_SUBP_CODIGO", "SMAN_ANNO", "SMAN_NUMERO", "SMAN_FECHA", "PAGADOR_SUBP_ID", "PAGADOR_SUBP_CODIGO", "PAGADOR_ID", "PAGADOR_COD"
    , "PAGADOR_NOMBRE", "MABL_ID", "MABL_TIPO", "MABL_ORDEN", "EQUITEUS", "EQUIUNIDADES") AS
  SELECT
      MANI.MANI_ID AS sman_id
      , SMAN.SERV_SUBP_ID AS sman_subp_id
      , SUBPSMAN.SUBP_CODIGO AS sman_subp_codigo
      , SMAN.SERV_ANNO AS sman_anno
      , SMAN.SERV_NUMERO AS sman_numero
      , MANI.MANI_FECHA_REFERENCIA AS sman_fecha
      , MACO_CONSIGNATARIO_SUBP_ID AS pagador_subp_id
      , SUBPMACO.SUBP_CODIGO AS pagador_subp_codigo
      , MACO_CONSIGNATARIO_ID AS pagador_id
      , ORGAMACO.ORGA_COD AS pagador_cod
      , ORGAMACO.ORGA_NOMBRE AS pagador_nombre
      , MABL.MABL_ID AS mabl_id
      , MABL.MABL_TIPO AS mabl_tipo
      , MABL.MABL_ORDEN AS mabl_orden
      , COALESCE( SUM( UNIC_TEUS * ( CASE when EQUI_NUMERO_VACIOS is null or EQUI_NUMERO_VACIOS = 0 then 1 else EQUI_NUMERO_VACIOS END ) ), 0) AS equiTeus
      , SUM( CASE WHEN EQUI_NUMERO_VACIOS IS NULL OR EQUI_NUMERO_VACIOS = 0 THEN 1 ELSE EQUI_NUMERO_VACIOS END ) AS equiUnidades
  FROM IMAN_BL_MABL MABL
      JOIN IMAN_MANIFIESTO_MANI MANI ON MANI_ID = MABL_MANI_ID
      JOIN ICOM_SERVICIO_SERV SMAN ON SERV_ID = MABL_MANI_ID
      JOIN IGEN_SUBPUERTO_SUBP SUBPSMAN ON SUBP_ID = SMAN.SERV_SUBP_ID
      LEFT JOIN IESC_ESCALA_ESCA ESCA ON MANI_ESCALA_ID = ESCA_ID
      LEFT JOIN IESC_ACUERDO_ACUE ACUESMAN ON ACUESMAN.ACUE_ID = MANI_ACUERDO_ID
      LEFT JOIN IGEN_ALINEACION_ALIN ALINSMAN ON ALIN_ID = MANI_ALINEACION_ID
      LEFT JOIN ICOM_ORGANIZACION_ORGA ORGAESTISMAN ON ORGAESTISMAN.ORGA_ID = MANI_ESTIBADOR_ID
      LEFT JOIN IGEN_SUBPUERTO_SUBP SUBPESTISMAN ON SUBPESTISMAN.SUBP_ID = MANI_ESTIBADOR_SUBP_ID
      JOIN ICOM_ORGANIZACION_ORGA ORGACONSSMAN ON ORGACONSSMAN.ORGA_ID = MANI_CONSIGNATARIO_ID
      JOIN IGEN_SUBPUERTO_SUBP SUBPCONSSMAN ON SUBPCONSSMAN.SUBP_ID = MANI_CONSIGNATARIO_SUBP_ID
      LEFT JOIN IMAN_TERMINAL_TERM TERMSMAN ON TERMSMAN.TERM_ID = MANI_TERMINAL_ID
      LEFT JOIN IESC_TRAFICO_TRAF TRAFSMAN ON TRAFSMAN.TRAF_ID = MANI_SERVICIO_ID
      JOIN IMAN_TIPOOPERACION_TOBL TOBLMABL ON TOBLMABL.TOBL_ID = MABL_TIPO_OPERACION_ID
      LEFT JOIN IGEN_UNLOCODE_UNLO UNLOORIGENMABL ON UNLOORIGENMABL.UNLO_ID = MABL_ORIGEN_UNLO_ID
      LEFT JOIN IGEN_UNLOCODE_UNLO UNLOCARGAMABL ON UNLOCARGAMABL.UNLO_ID = MABL_CARGA_UNLO_ID
      LEFT JOIN IGEN_UNLOCODE_UNLO UNLODESCARGAMABL ON UNLODESCARGAMABL.UNLO_ID = MABL_DESCARGA_UNLO_ID
      LEFT JOIN igen_unlocode_unlo unloDestinoMabl ON unloDestinoMabl.unlo_id = mabl_destino_unlo_id
      LEFT JOIN IGEN_UNLOCODE_UNLO UNLOTRANSBORDOMABL ON UNLOTRANSBORDOMABL.UNLO_ID = MABL_TRANSBORDO_UNLO_ID
      LEFT JOIN IMAN_MODOTRANSPEDI_TEDI TEDIMABL ON TEDIMABL.TEDI_ID = MABL_MODO_TRANSP_EDI_ID
      LEFT JOIN IMAN_INSTESPECIAL_IESP IESPMABL ON IESPMABL.IESP_ID = MABL_INST_ESPECIAL_ID
      JOIN IGEN_ALINEACION_ALIN ALINMABL ON ALINMABL.ALIN_ID = MABL_ALINEACION_ID
      JOIN IMAN_CONSIGNATARIO_MACO MACOMABL ON MACOMABL.MACO_ID = MABL_CONSIGNATARIO_ID
      LEFT JOIN ICOM_ORGANIZACION_ORGA ORGACLIEMABL ON ORGACLIEMABL.ORGA_ID = MABL_CLIENTE_ID
      LEFT JOIN IGEN_SUBPUERTO_SUBP SUBPCLIEMABL ON SUBPCLIEMABL.SUBP_ID = MABL_CLIENTE_SUBP_ID
      JOIN IGEN_NAVEGACIONTIPO_NAVT NAVTMABL ON NAVTMABL.NAVT_ID = MABL_TIPO_NAVEGACION_ID
      LEFT JOIN IMAN_TERMINAL_TERM TERMMABL ON TERMMABL.TERM_ID = MABL_TERMINAL_ID
      LEFT JOIN IESC_ACUERDO_ACUE ACUEMABL ON ACUEMABL.ACUE_ID = MABL_ACUERDO_ID
      LEFT JOIN IESC_TRAFICO_TRAF TRAFMABL ON TRAFMABL.TRAF_ID = MABL_SERVICIO_ID
      LEFT JOIN ICOM_ORGANIZACION_ORGA ORGAESTIMABL ON ORGAESTIMABL.ORGA_ID = MABL_ESTIBADOR_ID
      LEFT JOIN IGEN_SUBPUERTO_SUBP SUBPESTIMABL ON SUBPESTIMABL.SUBP_ID = MABL_ESTIBADOR_SUBP_ID
      LEFT JOIN ICOM_ORGANIZACION_ORGA ORGAMACO ON ORGAMACO.ORGA_ID = MACO_CONSIGNATARIO_ID
      LEFT JOIN IGEN_SUBPUERTO_SUBP SUBPMACO ON SUBPMACO.SUBP_ID = MACO_CONSIGNATARIO_SUBP_ID
      JOIN IMAN_EQUIPAMIENTO_EQUI EQUI ON EQUI_MABL_ID = MABL_ID 
          AND EQUI_ES_ACTIVO = 1
      JOIN IMAN_TIPOEQUIPAMIENTO_TEQU TEQU ON TEQU_ID = EQUI_TIPO_ID
      JOIN IMAN_UNIDADCARGA_UNIC UNIC ON UNIC.UNIC_ID = EQUI_UNIDAD_CARGA_ID
      JOIN iman_unidadcargatemp_unic unicTmp ON unicTmp.unic_id = equi_unidad_carga_id 
          AND unicTmp.unic_fecha_creacion <= equi_fecha_modificacion 
          AND ( unicTmp.unic_fecha_fin IS NULL OR unicTmp.unic_fecha_fin > equi_fecha_modificacion )
  WHERE 
      MABL_ES_ACTIVO = 1
      AND serv_fecha_baja IS NULL
      AND (
          MANI_SERVICIO_ID IS NULL OR EXISTS (
              SELECT 1 FROM iesc_serviciotiposervicio_stst JOIN iesc_serviciotipo_sett ON sett_id = stst_sett_id
              WHERE stst_traf_id = mani_servicio_id
                  AND STST_FECHA_INICIO_ADHESION <= MANI_FECHA_REFERENCIA
                  AND (
                    STST_FECHA_FIN_ADHESION IS NULL OR STST_FECHA_FIN_ADHESION > MANI_FECHA_REFERENCIA
                  )
          )
      )
      AND EXISTS (
          SELECT 1 FROM IFAC_TASATARIFASERVICIO_TTSE
          WHERE TTSE_SERV_ID = SERV_ID
              AND TTSE_SUBSERVICIO = EQUI_ID
              AND TTSE_ESTADO IN ( 'V', 'T' )
      )
      AND equi.equi_lleno_vacio = '4'
      AND unic.unic_codigo LIKE '3%'
      AND maco_consignatario_id = '14'
      AND Equi.equi_estado LIKE 'R'
GROUP BY MANI.MANI_ID, SMAN.SERV_SUBP_ID, SUBPSMAN.SUBP_CODIGO, SMAN.SERV_ANNO, SMAN.SERV_NUMERO, MANI.MANI_FECHA_REFERENCIA , MACO_CONSIGNATARIO_SUBP_ID
    , SUBPMACO.SUBP_CODIGO , MACO_CONSIGNATARIO_ID , ORGAMACO.ORGA_COD , ORGAMACO.ORGA_NOMBRE , mabl.mabl_id, mabl.mabl_tipo, mabl.mabl_orden
;


SELECT SUM(EQUITEUS) FROM TEUS_VACIOS_0043
;
SELECT SUM(EQUITEUS) FROM TEUS_VACIOS_0043_5
;




CREATE OR REPLACE VIEW TEUS_VACIOS_0043_5 (
    SMAN_ID, SMAN_SUBP_ID, SMAN_SUBP_CODIGO, SMAN_ANNO, SMAN_NUMERO, SMAN_FECHA, PAGADOR_SUBP_ID, PAGADOR_SUBP_CODIGO, PAGADOR_ID, PAGADOR_COD
    , PAGADOR_NOMBRE, MABL_ID, MABL_TIPO, MABL_ORDEN, EQUITEUS, EQUIUNIDADES
) AS 
SELECT 
    mabl_mani_id AS sman_id
    , (SELECT serv_subp_id FROM icom_servicio_serv WHERE serv_id = MABL_mani_ID) AS sman_subp_id 
    , (SELECT subp_codigo FROM igen_subpuerto_subp WHERE subp_id = (SELECT serv_subp_id FROM icom_servicio_serv WHERE serv_id = MABL_mani_ID)) AS sman_subp_codigo
    , (SELECT serv_anno FROM icom_servicio_serv WHERE serv_id = MABL_mani_ID) AS sman_anno
    , (SELECT serv_numero FROM icom_servicio_serv WHERE serv_id = MABL_mani_ID) AS sman_numero
    , (SELECT mani_fecha_referencia FROM iman_manifiesto_mani WHERE mani_id = MABL_mani_ID) AS sman_fecha
    , (SELECT MACO_CONSIGNATARIO_SUBP_ID FROM iman_consignatario_maco WHERE maco_id = MABL_CONSIGNATARIO_ID AND maco_mani_id = mabl_mani_id) AS pagador_SUBP_ID
    , (SELECT subp_codigo FROM igen_subpuerto_subp WHERE subp_id = (SELECT MACO_CONSIGNATARIO_SUBP_ID FROM iman_consignatario_maco WHERE maco_id = MABL_CONSIGNATARIO_ID)) AS pagador_subp_codigo
    , (SELECT MACO_CONSIGNATARIO_ID FROM iman_consignatario_maco WHERE maco_id = MABL_CONSIGNATARIO_ID) AS pagador_ID
    , (SELECT orga_cod FROM icom_organizacion_orga WHERE orga_id = (SELECT MACO_CONSIGNATARIO_ID FROM iman_consignatario_maco WHERE maco_id = MABL_CONSIGNATARIO_ID)) AS pagador_cod
    , (SELECT orga_nombre FROM icom_organizacion_orga WHERE orga_id = (SELECT MACO_CONSIGNATARIO_ID FROM iman_consignatario_maco WHERE maco_id = MABL_CONSIGNATARIO_ID)) AS pagador_nombre

    , mabl_id
    , mabl_tipo
    , mabl_orden

    , SUM (
        CASE 
            when EQUI_NUMERO_VACIOS is null or EQUI_NUMERO_VACIOS = 0 
            then 1 
            else EQUI_NUMERO_VACIOS 
        END
        *
        (
            SELECT unic_teus FROM iman_unidadcargatemp_unic
            WHERE unic_id = equi_unidad_carga_id
                AND unic_fecha_creacion <= equi_fecha_modificacion 
                AND ( unic_fecha_fin IS NULL OR unic_fecha_fin > equi_fecha_modificacion ) 
        ) 
    ) AS equiTeus 
    , SUM(
        CASE 
            WHEN EQUI_NUMERO_VACIOS IS NULL OR EQUI_NUMERO_VACIOS = 0 
            THEN 1 
            ELSE EQUI_NUMERO_VACIOS 
        END 
    ) AS equiUnidades
FROM 
    iman_equipamiento_equi
    INNER JOIN iman_bl_mabl ON
        mabl_id = equi_mabl_id
    INNER JOIN iman_unidadcarga_unic ON
        unic_id = equi_unidad_carga_id
WHERE 
    1=1
    AND unic_codigo LIKE '3%'
    AND equi_es_activo = 1
    AND equi_estado = 'R'
    AND equi_lleno_vacio IN ('4') 
    AND mabl_es_activo = 1
    AND EXISTS (
        SELECT 1 
        FROM iman_consignatario_maco
        WHERE 
            maco_mani_id = mabl_mani_id
            AND maco_id = mabl_consignatario_id
            AND EXISTS (
                SELECT 1
                FROM icom_organizacion_orga
                WHERE orga_id = maco_consignatario_id
                    AND orga_cod = '0043'
            )
    )
    AND EXISTS (
        SELECT 1
        FROM IFAC_TASATARIFASERVICIO_TTSE
        where
            ttse_serv_id = mabl_mani_id
            AND ttse_subservicio = equi_id
            AND ttse_estado in ('V', 'T')
    )
    AND EXISTS (
        SELECT 1
        FROM iman_manifiesto_mani
        WHERE mani_id = mabl_mani_id
            AND (
                MANI_SERVICIO_ID IS NULL
                OR EXISTS (
                    SELECT 1
                    FROM iesc_serviciotiposervicio_stst
                    WHERE stst_traf_id = mani_servicio_id
                        AND STST_FECHA_INICIO_ADHESION <= MANI_FECHA_REFERENCIA 
                        AND (STST_FECHA_FIN_ADHESION IS NULL OR STST_FECHA_FIN_ADHESION > MANI_FECHA_REFERENCIA) 
                )
            )
    )
    AND EXISTS (
        SELECT 1
        FROM icom_servicio_serv
        WHERE 
            serv_id = mabl_mani_id
            AND serv_fecha_baja IS NULL
    )
GROUP BY 
    mabl_mani_id
    , mabl_id
    , mabl_tipo
    , mabl_orden
    
    , MABL_CONSIGNATARIO_ID
;
