DROP INDEX ID_TASATARIFASERVICIO_SERV
;
CREATE INDEX ID_TASATARIFASERVICIO_SERV ON IFAC_TASATARIFASERVICIO_TTSE(ttse_serv_id)
;
CREATE INDEX ID_TASATARIFASERVICIO_SERV ON IFAC_TASATARIFASERVICIO_TTSE(ttse_serv_id, ttse_subservicio)
;

DROP INDEX ID_CONSIGNATARIO_MANI
;
CREATE INDEX ID_CONSIGNATARIO_MANI ON IMAN_CONSIGNATARIO_MACO(MACO_MANI_ID)
;
CREATE INDEX ID_CONSIGNATARIO_MANI ON IMAN_CONSIGNATARIO_MACO(MACO_MANI_ID, MACO_CONSIGNATARIO_ID)
;



SELECT SUM(EQUITEUS) 
FROM TEUS_VACIOS_0043
;

SELECT SUM(EQUITEUS) 
FROM TEUS_LLENOS_0043
;

SELECT SUM(EQUITEUS) 
FROM TEUS_VACIOS_0043_5
;

SELECT SUM(EQUITEUS) 
FROM TEUS_LLENOS_0043_5
;

SELECT (
    (
        SELECT SUM(EQUITEUS) 
        FROM TEUS_VACIOS_0043
    )
    +
    (
        SELECT SUM(EQUITEUS) 
        FROM TEUS_LLENOS_0043
    ) 
) FROM dual
;

SELECT SUM(EQUITEUS) 
FROM TEUS_0043_5
;
SELECT SUM(EQUITEUS) 
FROM TEUS_0043_M
;

SELECT *
FROM TEUS_0043_5
WHERE mabl_id = 14766
;
SELECT *
FROM TEUS_0043_M
WHERE mabl_id = 14766
;

SELECT * FROM iman_equipamiento_equi 
WHERE equi_mabl_id = 14766
;






DROP VIEW TEUS_0043_5;
CREATE OR REPLACE VIEW TEUS_0043_5 (
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
    AND equi_lleno_vacio IN ('4', '7', '8') 
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


CREATE MATERIALIZED VIEW TEUS_0043_M AS 
SELECT 
    mabl_mani_id AS sman_id
    , serv_subp_id AS sman_subp_id 
    , subp_codigo AS sman_subp_codigo
    , serv_anno AS sman_anno
    , serv_numero AS sman_numero
    , mani_fecha_referencia AS sman_fecha
    , MACO_CONSIGNATARIO_SUBP_ID AS pagador_SUBP_ID
    , subp_codigo AS pagador_subp_codigo
    , MACO_CONSIGNATARIO_ID AS pagador_ID
    , orga_cod  AS pagador_cod
    , orga_nombre AS pagador_nombre

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
    INNER JOIN iman_consignatario_maco ON 
        maco_id = mabl_consignatario_id
        AND maco_mani_id = mabl_mani_id
    INNER JOIN icom_organizacion_orga ON
        orga_id = maco_consignatario_id
    INNER JOIN igen_subpuerto_subp ON
        subp_id = MACO_CONSIGNATARIO_SUBP_ID
    INNER JOIN icom_servicio_serv ON
        serv_id = mabl_mani_ID
    INNER JOIN iman_manifiesto_mani ON
        mani_id = mabl_mani_ID
WHERE 
    1=1
    AND unic_codigo LIKE '3%'
    AND equi_es_activo = 1
    AND equi_estado = 'R'
    AND equi_lleno_vacio IN ('4', '7', '8') 
    AND mabl_es_activo = 1
    AND orga_cod = '0043'
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
    AND serv_fecha_baja IS NULL
GROUP BY 
    mabl_mani_id
    , mabl_id
    , mabl_tipo
    , mabl_orden
    
    , MABL_CONSIGNATARIO_ID
    , MACO_CONSIGNATARIO_SUBP_ID
    , MACO_CONSIGNATARIO_ID
    
    , orga_cod
    , orga_nombre
    
    , subp_codigo
    
    , serv_subp_id, serv_anno, serv_numero
    
    , mani_fecha_referencia
;



ALTER MATERIALIZED VIEW TEUS_0043_M REFRESH COMPLETE ON DEMAND
START WITH sysdate NEXT sysdate+to_dsinterval('0 12:00:00')
;




















DROP INDEX ID_EQUIPAMIENTO_UNIC;
CREATE INDEX ID_EQUIPAMIENTO_UNIC ON iman_equipamiento_equi (equi_unidad_carga_id);

SELECT COUNT(*)
FROM iman_bl_mabl
WHERE 
    EXISTS (
        SELECT 1 FROM iman_consignatario_maco
        WHERE maco_id = mabl_consignatario_id
            AND maco_mani_id = mabl_mani_id
            AND EXISTS (
                SELECT 1
                FROM icom_organizacion_orga
                WHERE orga_id = maco_consignatario_id
                    AND orga_cod = '0043'
            )
    )
;



