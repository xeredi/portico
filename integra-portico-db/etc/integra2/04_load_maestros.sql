select * from dp_expediente;

SELECT * from M_PUERTO_LOCAL;
SELECT * from M_USUARIO;
SELECT * from CEN_EMPRESA;
SELECT * from CEN_CONSEJO;
SELECT * from M_muelle;

delete from T8_SUMINBUQUE;
delete from estadia;
delete from LQ_BORRADORLINEACOEF;
delete from LQ_BORRADORLINEA;
delete from LQ_FACTURA_HECHO_IMPONIBLE;
delete from LQ_BORRADOR;
delete from LQ_FACTURA;
delete from G3_TRAMO;
delete from G3_CABECERA;
delete from ESCALA_FTBUQUE;
delete from escala;

delete from M_BUQUEBONIF;
delete from M_BUQUEVERSION;
DELETE FROM tipo_buque;
delete from TIPO_BUQUEOPPE;
delete from CONTADOR_BUQUE;
delete from B4_TIPOMANIFIESTO;
delete from m_buque;
delete from m_naviera;
delete from M_MUELLE;
delete FROM M_TERMINAL;

DELETE FROM CEN_EMPRESA;
DELETE FROM CEN_CONSEJO;
DELETE from M_USUARIO_PUERTO;
delete from DP_EXPEDIENTE;
delete from T8_SUMINGENERICO;
delete from G5_MARINA_COEF;
delete from G5_MARINA;
delete from B4_BUQUEPESQUERO;
delete from EDI_BUZON;
DELETE from M_USUARIO;
DELETE from M_PUERTO_LOCAL;

/* ==================== M_PUERTO_LOCAL ====================== */
INSERT INTO M_PUERTO_LOCAL(codpue, nombre, codpailocode, codpuelocode, codap, recaduanero)
select subp_codigo AS codpue
    , (select subp_nombre from IGEN_SUBPUERTOi18n_SUBP i18n where i18n.subp_id = subp.subp_id AND i18n.subp_idioma = 'es_ES') AS nombre
    , (SELECT pais_iso FROM IGEN_pais_pais WHERE pais_id = (SELECT unlo_pais_id FROM IGEN_UNLOCODE_UNLO WHERE unlo_id = subp_unlo_id)) AS codpailocode
    , (SELECT unlo_codigo FROM IGEN_UNLOCODE_UNLO WHERE unlo_id = subp_unlo_id) AS codpuelocode
    , SUBP_AUTP_ID AS codap
    , RADU_CODIGO AS recaduanero
from IGEN_SUBPUERTO_SUBP subp
    LEFT JOIN Igen_autoridad_port_autp ON
        autp_id = subp_autp_id
    LEFT JOIN IMAN_RECINTOADUANERO_RADU ON
        radu_unlocode_id = subp_unlo_id
;


-- Precargado:

-- TIPO_DOCUMENTO
-- GU_IDIOMA


-- orga_tipo_doc_fiscal
-- CIF - 1 - CIF
-- NIE - 
-- PAS - 3 - Pasaporte
---NIF - 2 - NIF
-- OTR - 4 - Otros
/* ==================== M_USUARIO ====================== */
INSERT INTO M_USUARIO (CODUSUARIO, NOMBRE, APELLIDOS, NOMBRECOMPLETO, CODTIPODOCUMENTO, NUMDOC, PAGINAWEB, usralta, usrmodif, fecalta, fecmodif
    , LETRANIF, CODAPSCT, INDBAJA, FECBAJA, CODTIPUSU, NACIONALIDAD, IDIOMA, DIRTIPOVIA, DIRNOMVIA, DIRNUMPORTAL, DIRESCALERA, DIRPISO, DIRPUERTA, DIRPAIS
    , DIRPROVINCIA, DIRMUNICIPIO, DIRCODPOSTAL, OBSERVACIONES, INDCONTADO, INDNOTIFELECTRONICA, CODTIPONOTIF, CODTIPOCOBRO, IDAPLICANTERIOR, INDAPREMIO, INDFACTURAEFACE)
SELECT 
    (select trid_new_id from tbl_traduccion_ids_trid where trid_table_name = 'ICOM_ORGANIZACION_ORGA' AND trid_old_id = orga_id) as id
    , null AS NOMBRE, null AS APELLIDOS, orga_nombre AS NOMBRECOMPLETO
    , (CASE orga_tipo_doc_fiscal
        WHEN 'CIF' THEN 1
        WHEN 'NIF' THEN 2
        WHEN 'Pasaporte' THEN 3
        ELSE 4
        END) AS CODTIPODOCUMENTO
    , (CASE orga_tipo_doc_fiscal
        WHEN 'CIF' THEN CONCAT(ORGA_DOC_FISCAL_PREFIJO, ORGA_DOC_FISCAL)
        WHEN 'NIF' THEN ORGA_DOC_FISCAL
        ELSE ORGA_DOC_FISCAL
        END) AS NUMDOC
    , DIRC_PAGINA_WEB AS PAGINAWEB, null, null, sysdate, null
    , (CASE orga_tipo_doc_fiscal
        WHEN 'NIF' THEN ORGA_DOC_FISCAL_suFIJO
        ELSE null
        END) AS LETRANIF
    , null as CODAPSCT, 0 AS INDBAJA, null AS FECBAJA, null AS CODTIPUSU, null AS NACIONALIDAD, 'ES' AS IDIOMA
    , (SELECT TVIA_NOMBRE FROM icom_tipoviai18n_tvia WHERE tvia_id = dirc_tvia_id AND tvia_idioma = 'es_ES') AS DIRTIPOVIA
    , DIRC_DIRECCION as DIRNOMVIA, DIRC_PORTAL as DIRNUMPORTAL, DIRC_ESCALERA as DIRESCALERA, DIRC_PISO as DIRPISO, DIRC_PUERTA as DIRPUERTA
    , (SELECT PAIS_NOMBRE FROM IGEN_PAISi18n_PAIS WHERE PAIS_id = dirc_PAIS_id AND PAIS_idioma = 'es_ES') AS DIRPAIS
    , (SELECT PROV_NOMBRE FROM IGEN_PROVINCIAi18n_PROV WHERE PROV_id = (SELECT muni_prov_id FROM igen_municipio_muni WHERE muni_id = dirc_MUNI_id) 
        AND PROV_idioma = 'es_ES') AS DIRPROVINCIA
    , COALESCE((SELECT MUNI_NOMBRE FROM IGEN_MUNICIPIOi18n_MUNI WHERE MUNI_id = dirc_MUNI_id AND MUNI_idioma = 'es_ES'), DIRC_OTRA_LOCALIDAD) AS DIRMUNICIPIO
    , DIRC_COD_POSTAL as DIRCODPOSTAL, dirc_comentarios as OBSERVACIONES, null AS INDCONTADO, ORGA_ES_FACTURA_E AS INDNOTIFELECTRONICA
    , NULL AS CODTIPONOTIF, NULL AS CODTIPOCOBRO, NULL AS IDAPLICANTERIOR, NULL AS INDAPREMIO, NULL AS INDFACTURAEFACE
FROM ICOM_ORGANIZACION_ORGA
    LEFT JOIN ICOM_DIRECCION_CONT_DIRC ON DIRC_ID_ORGANIZACION = orga_id
;

INSERT INTO M_USUARIO_PUERTO (CODUSUARIO, CODPUE, FECALTA, FECMODIF, USRALTA, USRMODIF)
SELECT codusuario, codpue, sysdate, null, null, null
FROM m_usuario, M_PUERTO_LOCAL
;


INSERT INTO CEN_CONSEJO(IDCONSEJO, ANYOCONSEJO, numconsejo, fecconsejo, observaciones, usralta, usrmodif, fecalta, fecmodif)
SELECT (select trid_new_id from tbl_traduccion_ids_trid where trid_table_name = 'ICEN_CONSEJO_COAD' AND trid_old_id = coad_id) as id
    , COAD_ANYO, coad_numero, coad_fecha, coad_observaciones, null, null, SYSDATE, null
from ICEN_CONSEJO_COAD
;

INSERT INTO CEN_EMPRESA(
    CODEMPRESA, NOMBRECOMPLETO, CODTIPODOCUMENTO, NUMDOC, usralta, usrmodif, fecalta, fecmodif
    , LETRANIF, INDBAJA, FECBAJA, CODTIPUSU, OBSERVACIONES, CENSADA, CODCLIENTE
)
SELECT (select trid_new_id from tbl_traduccion_ids_trid where trid_table_name = 'ICEN_EMPRESACENSADA_EMCE' AND trid_old_id = emce_id) as CODEMPRESA
    , emce_nombre as NOMBRECOMPLETO
    , (CASE emce_tipo_doc_fiscal
        WHEN 'CIF' THEN 1
        WHEN 'NIF' THEN 2
        WHEN 'Pasaporte' THEN 3
        ELSE 4
        END) AS CODTIPODOCUMENTO
    , CONCAT(
          CONCAT(
            COALESCE(emce_doc_fiscal_prefijo, ''), emce_doc_fiscal
          )
          , COALESCE(emce_doc_fiscal_sufijo, '')
      ) as NUMDOC
    , NULL AS usralta
    , NULL AS usrmodif
    , NULL AS fecalta
    , NULL AS fecmodif
    , emce_doc_fiscal_sufijo as LETRANIF
    , 0 as INDBAJA
    , null as FECBAJA
    , null as CODTIPUSU
    , null as OBSERVACIONES
    , null as CENSADA
    , null as CODCLIENTE
from ICEN_EMPRESACENSADA_EMCE
;




insert into m_terminal (CODTERMINAL, CODPUE, DESCRIPCION, IDUSUARIO, FECALTA, FECMODIF, USRALTA, USRMODIF, OBSERVACIONES, CODTIPOCONCB3, CODTIPOCONCB2)
SELECT 
    term_codigo as CODTERMINAL, 'A' as  CODPUE
    , COALESCE((SELECT i18n.term_nombre from IMAN_TERMNINALi18n_TERM i18n 
        where 
            i18n.term_id = maes.term_id AND i18n.term_idioma = 'es_ES' 
            AND i18n.term_fecha_creacion < SYSDATE AND (i18n.term_fecha_fin IS NULL OR i18n.term_fecha_fin > SYSDATE)
    ), 'SIN DESCRIPCION') as DESCRIPCION
    , null as idusuario, sysdate as fecalta, null as fecmodif, null as usralta, null as usrmodif
    , (SELECT i18n.term_descripcion from IMAN_TERMNINALi18n_TERM i18n 
        where 
            i18n.term_id = maes.term_id AND i18n.term_idioma = 'es_ES' 
            AND i18n.term_fecha_creacion < SYSDATE AND (i18n.term_fecha_fin IS NULL OR i18n.term_fecha_fin > SYSDATE)
    ) as observaciones
    , (
        case temp.TERM_ES_CONCESION
            WHEN 1 then '1' else '0'
        end 
    ) as CODTIPOCONCB3
    , (
        case temp.TERM_ES_CONCESION
            WHEN 1 then '02' else '01'
        end 
    ) as CODTIPOCONCB2
FROM 
    IMAN_TERMINAL_TERM maes
    INNER JOIN IMAN_TERMINALTEMP_TERM temp ON temp.term_id = maes.term_id
;


/* --------------------------- m_muelle ------------------------------- */
/* --------------------------- m_muelle ------------------------------- */
/* --------------------------- m_muelle ------------------------------- */
select * from m_muelle;

insert into m_muelle (
    CODIGO, CODPUE, DESCRIPCION, CALADO, OBSERVACIONES, FECALTA, FECMODIF, USRALTA, USRMODIF, LONGITUD, ANCHO
    , NORAYINI, NORAYFIN, INDDIQUESECO, CODTERMINAL, CODZONAAGUA, CODTIPCONCESION, INDRAMPA, INDFONDEO
    , CODMUELLEIZQUIERDA, CODMUELLEDERECHA, DIRECNORAYS, CODTERMINAL2, CODTERMINAL3, CODTERMINAL4, ESTINDINSTALESPECIAL
    , INDCOARRI, INDCONCT3, CODCENTROCOSTE, CODZONAMUELLE, CODTIPCONCT2, CODEDI, CODPUEAPAC, INDNOOPEAIS
)
select alin.alin_codigo AS CODIGO
    , COALESCE((SELECT subp_codigo FROM igen_subpuerto_subp WHERE subp_id = muelt.muel_subp_id), 'A') AS CODPUE
    , COALESCE((SELECT i18n.muel_nombre from iesc_muelleI18N_muel i18n 
        where 
            i18n.muel_id = muel.muel_id AND i18n.muel_idioma = 'es_ES' 
            AND i18n.muel_fecha_creacion < SYSDATE AND (i18n.muel_fecha_fin IS NULL OR i18n.muel_fecha_fin > SYSDATE)
    ), 'SIN DESCRIPCION') as DESCRIPCION
    , NULL AS calado
    , (SELECT i18n.muel_descripcion from iesc_muelleI18N_muel i18n 
        where 
            i18n.muel_id = muel.muel_id AND i18n.muel_idioma = 'es_ES' 
            AND i18n.muel_fecha_creacion < SYSDATE AND (i18n.muel_fecha_fin IS NULL OR i18n.muel_fecha_fin > SYSDATE)
    ) as observaciones
    , sysdate as fecalta, null as FECMODIF, null as USRALTA, null as USRMODIF
    , alin_longitud as longitud, alin_anchura as ancho
    , alin_noray_inicial as norayini, alin_noray_final as norayfin, null as inddiqueseco
    , (SELECT term_codigo FROM iman_terminal_term WHERE term_id = alin_term_id) as codterminal
    , COALESCE(ALIN_zona_puerto, 0) + 1 as CODZONAAGUA
    , (
        case
            WHEN ALIN_ES_EN_CONCESION is null or ALIN_ES_EN_CONCESION = 0 then '01'
            WHEN ALIN_ES_EN_CONCESION = 1 AND ALIN_ES_AGUAS_EN_COCESION = 1 then '02'
            ELSE '03'
        END
    ) as CODTIPCONCESION
    , null as INDRAMPA, null as INDfondeo, null as CODMUELLEIZQUIERDA, null as CODMUELLEDERECHA, null as DIRECNORAYS
    , null as codterminal2, null as codterminal3, null as codterminal4
    , (
        case
            when alin_iesp_id IS NULL then '0'
            else '1'
        end
    ) as ESTINDINSTALESPECIAL
    , null as INDCOARRI, null as INDCONCT3, null as CODCENTROCOSTE, null as CODZONAMUELLE
    , null as CODTIPCONCT2, null as CODEDI, null as CODPUEAPAC, null as INDNOOPEAIS
from 
    igen_alineacion_alin alin
    left join igen_alineaciontemp_alin alint ON alint.alin_id = alin.alin_id AND alint.alin_es_activo = 1
    left join iesc_muelle_muel muel ON muel.muel_id = alint.alin_muel_id
    left join iesc_muelletemp_muel muelt ON muelt.muel_id = muel.muel_id AND muelt.muel_es_activo = 1
order by alin.alin_codigo
;

/* --------------------------- m_naviera ------------------------------- */
/* --------------------------- m_naviera ------------------------------- */
/* --------------------------- m_naviera ------------------------------- */
select * from m_naviera;

INSERT INTO m_naviera (CODIGO, NOMBRE, CIF, IDCLIENTE, OBSERVACIONES, USRALTA, USRMODIF, FECALTA, FECMODIF, IMOREGOWNER, CODNAVIERAPORTEL)
select 
    (select trid_new_id from tbl_traduccion_ids_trid where trid_table_name = 'IESC_NAVIERA_NAVI' AND trid_old_id = navi_id) as CODIGO
    , navi_descripcion as NOMBRE, null as CIF, null as IDCLIENTE, null as OBSERVACIONES
    , null as USRALTA, null as USRMODIF, sysdate as FECALTA, null as FECMODIF, null as IMOREGOWNER
    , navi_codigo as CODNAVIERAPORTEL
from iesc_naviera_navi
;





/* --------------------------- m_buque ------------------------------- */
/* --------------------------- m_buque ------------------------------- */
/* --------------------------- m_buque ------------------------------- */
select * from m_buque;

INSERT INTO M_BUQUE (CODBUQUE, NOMBRE, CODIMO, FECALTA, FECMODIF, USRALTA, USRMODIF, IDAPLICANTERIOR, INDPDTEREV)
SELECT 
    (select trid_new_id from tbl_traduccion_ids_trid where trid_table_name = 'IESC_BUQUE_BUQU' AND trid_old_id = buqu_buque_id) as CODBUQUE
    , (SELECT BUQU_NOMBRE_BUQUE FROM iesc_buquetemp_buqu buqut WHERE buqu.buqu_buque_id = buqut.buqu_buque_id
        AND buqut.buqu_es_activo = 1
    ) AS NOMBRE
    , buqu_codigo_imo AS CODIMO, SYSDATE AS FECALTA, NULL AS FECMODIF, NULL AS USRALTA, NULL AS USRMODIF, BUQU_MMSI AS IDAPLICANTERIOR, '0' AS INDPDTEREV
FROM iesc_buque_buqu buqu
;

select * from TIPO_BUQUEOPPE;

INSERT INTO TIPO_BUQUEOPPE (
    CODIGO
    , DESCRIPCION
)
SELECT 
    BUQT_CODIGO AS CODIGO
    , COALESCE(BUQT_NOMBRE, 'SIN DESCRIPCION!!') AS DESCRIPCION
FROM 
    IEST_BUQUETIPOEST_BUQT BUQT
    LEFT JOIN IEST_BUQUETIPOEEEI18N_BUQT I18N ON
        I18N.BUQT_ID = BUQT.BUQT_ID
        AND i18n.buqt_es_activo = 1
        AND i18n.buqt_idioma = 'es_ES'
;

insert into tipo_buque (
    CODTIPOBUQUE
    , DESCRIPCION
    , FECALTA
    , FECMODIF
    , USRALTA
    , USRMODIF
    , CODTIPOOPPE
    , TIPTRAFICO
    , ESTCODTIPBUQCOM
    , INDAPLICCONT008
    , INDGUERRA
)
SELECT
    BUQT_CODIGO AS CODTIPOBUQUE
    , COALESCE(BUQT_NOMBRE, 'SIN DESCRIPCION!!!') AS DESCRIPCION
    , SYSDATE AS FECALTA
    , NULL AS FECMODIF
    , NULL AS USRALTA
    , NULL AS USRMODIF
    , COALESCE(
        (SELECT BUQT_CODIGO FROM IEST_BUQUETIPOEST_BUQT BUQTE WHERE BUQTE.BUQT_ID = BUQT.BUQT_ID), '**'
    ) AS CODTIPOOPPE
    , NULL AS TIPTRAFICO
    , NULL AS ESTCODTIPBUQCOM
    , NULL AS INDAPLICCONT008
    , NULL AS INDGUERRA
FROM IGEN_BUQUETIPO_BUQT BUQT
    LEFT JOIN IGEN_BUQUETIPOI18N_BUQT I18N ON
        I18N.BUQT_ID = BUQT.BUQT_ID
        AND i18n.buqt_es_activo = 1
        AND i18n.buqt_idioma = 'es_ES'
;

insert into m_buqueversion (
    CODBUQUE, VERSION, FECINIVIG, FECFINVIG, CODTIPOBUQUE, BANDERA, CALLSIGN, CODARMADOR, CODPAIREGISTRO, CODPUEREGISTRO, SOCCLASIFICACION, CIAASEGURADORA
    , CLUBPI, FECCONSTRUCCION, CALMAXIMO, GT, TPM, TRB, ESLORATOTAL, MANGA, PUNTAL, ALTURAARBOLADURA, POTENCIA, VELCRUCERO, VELMAXIMA, INDDOBLECASCO
    , SBTVOLUMEN, SBTUNIDADES
    , RAMPA1SITUACION, RAMPA1ALCANCE, RAMPA1ANCHURA, RAMPA2SITUACION, RAMPA2ALCANCE, RAMPA2ANCHURA, RAMPA3SITUACION, RAMPA3ALCANCE, RAMPA3ANCHURA, RAMPA4SITUACION, RAMPA4ALCANCE, RAMPA4ANCHURA
    , NUMHELICES, SITUACIONHELICES, LASTRESUCIO, TANFANGOS, TANAGUASOLEOSAS, AGUASSUCIAS, BASURAS, INDCERTARQ, FECEMICERTARQ, LIBROREGISTRO, INDINSPMOU, CODPAIINSPMOU
    , CODPUEINSPMOU, FECINSPMOU, NUMDEFINSPMOU, CODPAIMATRICULA, CODPUEMATRICULA, FECMATRICULA, MATRICULA, INDCERTIGS, FECVIGCERTIGS, NUMREGCERTIGS, CODMMSI, OBSERVACIONES
    , FECALTA, FECMODIF, USRALTA, USRMODIF, INDCERTMATRICULA, CODLLOYDS, CODTIPOPRESTACION, CODPUEBASE, IDNAVIERA, INDAPLIC195, INDTERCEROSPAISES, INDNOOPEAIS, INDGNL, INDIBIZASAV)
SELECT * FROM (
    SELECT 
        (select trid_new_id from tbl_traduccion_ids_trid where trid_table_name = 'IESC_BUQUE_BUQU' AND trid_old_id = buqu_buque_id) as CODBUQUE
        , BUQU_TIEMPO_CREACION AS VERSION
        , BUQU_FECHA_CREACION AS FECINIVIG
        , BUQU_FECHA_FIN AS FECFINVIG
        , (select buqt_codigo FROM IGEN_BUQUETIPO_BUQT WHERE buqt_id = BUQU_BUQT_ID) AS CODTIPOBUQUE
        , (select pais_iso from IGEN_PAIS_PAIS where pais_id = buqu_bandera_pais_id) as BANDERA
        , buqu_callsign as CALLSIGN
        , (select trid_new_id from tbl_traduccion_ids_trid where trid_table_name = 'ICOM_ORGANIZACION_ORGA' AND trid_old_id = buqu_armador_orga_id) as CODARMADOR
        , (select pais_iso from IGEN_PAIS_PAIS where pais_id = BUQU_REGISTRO_PAIS_ID) as CODPAIREGISTRO
        , null as CODPUEREGISTRO, BUQU_SOCIEDAD_CLASIFICACION as SOCCLASIFICACION, BUQU_ASEGURADORA as CIAASEGURADORA
        , BUQU_CLUB_P_I as CLUBPI, BUQU_FECHA_CONSTRUCCION as FECCONSTRUCCION, BUQU_CALADO_MAXIMO as CALMAXIMO, buqu_gt as gt, null as tpm, BUQU_TONELADAS_REGISTRADAS as trb
        , BUQU_ESLORA as esloratotal, BUQU_manga as manga, BUQU_altura_puntal as puntal, BUQU_altura_arboladura as alturaarboladura, buqu_potencia as potencia
        , buqu_velocidad_crucero as velcrucero, buqu_velocidad_maxima as velmaxima, BUQU_ES_DOBLE_CASCO as INDDOBLECASCO, BUQU_VOLUMEN_SBT as SBTVOLUMEN, BUQU_UNIDAD_MEDIDA_SBT as SBTUNIDADES
        , null as RAMPA1SITUACION, null as RAMPA1ALCANCE, null as RAMPA1ANCHURA, null as RAMPA2SITUACION, null as RAMPA2ALCANCE, null as RAMPA2ANCHURA
        , null as RAMPA3SITUACION, null as RAMPA3ALCANCE, null as RAMPA3ANCHURA, null as RAMPA4SITUACION, null as RAMPA4ALCANCE, null as RAMPA4ANCHURA
        , coalesce(BUQU_NUMERO_HELICES_PROA, 0) + coalesce(BUQU_NUMERO_HELICES_Popa, 0) as NUMHELICES
        , null as SITUACIONHELICES, null as LASTRESUCIO, null as TANFANGOS, null as TANAGUASOLEOSAS, null as AGUASSUCIAS, null as BASURAS
        , (case
            when BUQU_FECHA_CERTIFICADO_GT is null then '0'
            else '1'
        end) as INDCERTARQ
        , BUQU_FECHA_CERTIFICADO_GT as FECEMICERTARQ, BUQU_LIBRO_REGISTRO as LIBROREGISTRO, BUQU_ES_MOU_PSC_REQUERIDO as INDINSPMOU
        , (select pais_iso from IGEN_PAIS_PAIS where pais_id = BUQU_MOU_PSC_PAIS_ID) as CODPAIINSPMOU
        , (select unlo_codigo from IGEN_unlocode_unlo where unlo_id = BUQU_MOU_PSC_unlo_ID) as CODPUEINSPMOU
        , BUQU_FECHA_MOU_PSC_INSPECCION as FECINSPMOU, BUQU_MOU_PSC_PENDIENTE as NUMDEFINSPMOU
        , null as CODPAIMATRICULA, null as CODPUEMATRICULA, null as FECMATRICULA, null as MATRICULA
        , null as INDCERTIGS, null as FECVIGCERTIGS, null as NUMREGCERTIGS
        , (SELECT buqu_mmsi from iesc_buque_buqu buqu where buqu.buqu_buque_id = buqut.buqu_buque_id) as CODMMSI
        , buqu_observaciones as OBSERVACIONES
        , SYSDATE AS FECALTA, NULL AS FECMODIF, NULL AS USRALTA, NULL AS USRMODIF
        , null as INDCERTMATRICULA, null as CODLLOYDS, null as CODTIPOPRESTACION, null as CODPUEBASE
        , (select trid_new_id from tbl_traduccion_ids_trid where trid_table_name = 'IESC_NAVIERA_NAVI' AND trid_old_id = BUQU_NAVI_ID) as IDNAVIERA
        , null as INDAPLIC195, null as INDTERCEROSPAISES, null as INDNOOPEAIS, null as INDGNL, null as INDIBIZASAV
    FROM iesc_buquetemp_buqu buqut
) SQL
WHERE CODBUQUE IS NOT NULL
;








/*
DELETE FROM ALERTA_AEBORRADOR
; DELETE FROM B4_MANIFIESTO
; DELETE FROM B5_M_INSTALACION
; DELETE FROM CEN_DOMICILIO
; DELETE FROM CEN_EMPLEADO
; DELETE FROM CEN_EXPEDIENTE
; DELETE FROM CONTADOR_BUQUE
; DELETE FROM CONTADOR_SERVMARIT
; DELETE FROM DIVERSO_GENERICO
; DELETE FROM DIVERSO_PERIODICO
; DELETE FROM DP_BIENPUBLICO
; DELETE FROM DP_CANONACTIV
; DELETE FROM DP_CANONACTIV_HISTUNIDAD
; DELETE FROM DP_CANONOCUPACION
; DELETE FROM DP_CIFRANEGOCIO
; DELETE FROM DP_EXPEDIENTE
; DELETE FROM DP_USOCONSUNTIVO
; DELETE FROM DPP_INSTALACION
; DELETE FROM DPP_ZONAVALOR
; DELETE FROM ESCALA
; DELETE FROM ESCALA_PLANIF
; DELETE FROM EXPAGUA_NODP
; DELETE FROM G0_PESCALITORAL
; DELETE FROM G3_CABECERA
; DELETE FROM G3_NDPCAB
; DELETE FROM G4_PESCA
; DELETE FROM G5_EXPGESTDIRECTA
; DELETE FROM G5_MARINA
; DELETE FROM G5_TRANSITO
; DELETE FROM GE_NOTIFICACION
; DELETE FROM GE_NOTIFICACION_LISTADISTRIB
; DELETE FROM GU_USUAPLI_PUERTO
; DELETE FROM LOGAE
; DELETE FROM LOGCONTMERC
; DELETE FROM LOGDP
; DELETE FROM LOGMENSAJERIA
; DELETE FROM LOGRODANTE
; DELETE FROM LQ_BAREMOAP
; DELETE FROM LQ_BORRADOR
; DELETE FROM LQ_BORRADORLINEA
; DELETE FROM LQ_FACTURA
; DELETE FROM LQ_FACTURA_LOTE
; DELETE FROM LQ_NOTIFICACION
; DELETE FROM LQ_NOTIFICACION_PROCESO
; DELETE FROM LQ_REGLALIQNOCTURNA
; DELETE FROM LQ_TARIFA_SERIE
; DELETE FROM M_AMARRE
; DELETE FROM M_BONIFICACION
; DELETE FROM M_BUQUE_FEC_ULT_LIQ_TR_SIGMA
; DELETE FROM M_BUQUECERT
; DELETE FROM M_BUQUEVERSION
; DELETE FROM M_CONTADOR
; DELETE FROM M_DOMICILIO
; DELETE FROM M_FESTIVO
; DELETE FROM M_FESTIVO_SERVBAS
; DELETE FROM M_GRUA
; DELETE FROM M_INSTALACION
; DELETE FROM M_MUELLE
; DELETE FROM M_NORAY
; DELETE FROM M_PANTALAN
; DELETE FROM M_PASARELA
; DELETE FROM M_RUTACONTADOR
; DELETE FROM M_SERVICIOMARITIMO
; DELETE FROM M_TERMINAL
; DELETE FROM M_TOMACONTADOR
; DELETE FROM M_USU_CONTAC_PUERTO
; DELETE FROM M_USUARIO_PUERTO
; DELETE FROM M_ZONACONTAGUA
; DELETE FROM M_ZONAMUELLE
; DELETE FROM M_ZONAOCUP
; DELETE FROM MALLAAGUA
; DELETE FROM MEN_COARRI
; DELETE FROM NOVEDAD_RODANTE
; DELETE FROM OCUPSUP_RODANTE
; DELETE FROM OPER_PARAM_INTEGRATION
; DELETE FROM PARAM_INTEGRATION
; DELETE FROM PARAM_SUJPASB4_PUERTO
; DELETE FROM SAN_EXPEDIENTE
; DELETE FROM SAN_PARTE
; DELETE FROM T0_EMBDEPBASENOAP
; DELETE FROM T2_EXCURSIONISTA
; DELETE FROM T8_SUMINBUQUE
; DELETE FROM T8_SUMINGENERICO
; DELETE FROM T8_SUMININSTFIJA
; DELETE FROM T8_TIPOSUMINAGUA
; DELETE FROM T8_TIPOSUMINELEC
; DELETE FROM T8_TIPOSUMINOTROS
; DELETE FROM TM_SERVICIO 
;
*/