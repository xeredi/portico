select pais_iso, unlo_codigo 
from 
    igen_unlocode_unlo
    inner join igen_pais_pais on pais_id = unlo_pais_id
where 
    not exists (
        select 1 from M_PUERTO 
        where codpais = pais_iso and codpue = unlo_codigo
    )
    and pais_es_activo = 1
    and unlo_es_activo = 1
order by pais_iso, unlo_codigo 
;

delete from G3_CABECERA;
select * from G3_CABECERA;
select * from M_PUERTO 
where codpais = 'ES'
order by codpais, codpue;

select * from G3_TIPOMOVMERC;
select * from TIPO_BUQUE order by codtipobuque;
select * from iman_manifiesto_mani;

select * from iesc_trafico_traf traf inner join iesc_traficoi18n_traf i18n on i18n.traf_id = traf.traf_id;

INSERT INTO G3_CABECERA (
    CODPUE, ANYO, CODSER, NUMDECLARACION, TIPODECLARACION, NUMVIAJE, NOMBUQUE, IDENTBUQUE, CODPAIBUQUE, IDCONSIGNATARIO, FECENTSAL, CODMUELLE
    , IDESTIBADOR, CODPAIANTERIOR, CODPUEANTERIOR, CODPAISIGUIENTE, CODPUESIGUIENTE, INDSERREGULAR, NUMSERVICIO, INDREGSIMPLIF, CODTIPOTRANSITO
    , CODTIPOMOVMERC, FECDECLARACION, NUMESCALA, INDBAJA, FECBAJA, FECALTA, FECMODIF, USRALTA, USRMODIF, GUIDSRV, CODTIPOBUQUE, CODTERMINAL
    , TIPTRAFICO, TIPTRAFICOSUGERIDO, CODSERVMARIT, INDRECIBCOARRI, INDTERMDESCONOCIDA, INDRECIBNDP, FECINIREALESCALA, ESTINDEXENTA, ESTPAIOPPEEME
    , ESTDIGPAIOPPEEME, ESTIMOESCALA, INDMANUAL, INDSINTRAMOS, CODPROCESOCARGA, CODPUEESCALA, ANYOESCALA, CODESCALA)
;
SELECT 
    (select subp_codigo from IGEN_subpuerto_subp where subp_ID = serv_subp_id) AS CODPUE
    , serv_anno AS ANYO, serv_numero AS CODSER, serv_NUMERO as NUMDECLARACION, MANI_TIPO_OPERACION as TIPODECLARACION
    , MANI_NUMERO_VIAJE as NUMVIAJE
    , (select BUQU_NOMBRE_BUQUE from IESC_BUQUETEMP_BUQU where buqu_buque_id = esca_buque_id and BUQU_FECHA_CREACION <= MANI_FECHA_REFERENCIA and (buqu_fecha_fin is null or buqu_fecha_fin > MANI_FECHA_REFERENCIA)) as NOMBUQUE
    , (select BUQU_codigo_imo from IESC_BUQUE_BUQU where buqu_buque_id = esca_buque_id) as IDENTBUQUE
    , (select pais_iso from igen_pais_pais where pais_id = (
        select BUQU_BANDERA_PAIS_ID from IESC_BUQUETEMP_BUQU where buqu_buque_id = esca_buque_id and BUQU_FECHA_CREACION <= MANI_FECHA_REFERENCIA and (buqu_fecha_fin is null or buqu_fecha_fin > MANI_FECHA_REFERENCIA))
      ) as CODPAIBUQUE
    , (select trid_new_id from tbl_traduccion_ids_trid where trid_table_name = 'ICOM_ORGANIZACION_ORGA' AND trid_old_id = MANI_CONSIGNATARIO_ID) as IDCONSIGNATARIO
    , MANI_FECHA_REFERENCIA as FECENTSAL
    , (SELECT alin_codigo FROM IGEN_ALINEACION_ALIN WHERE ALIN_id = MAni_ALINEACION_ID) AS CODMUELLE
    , (select trid_new_id from tbl_traduccion_ids_trid where trid_table_name = 'ICOM_ORGANIZACION_ORGA' AND trid_old_id = MANI_estibador_ID) as IDESTIBADOR
    , (select pais_iso from igen_pais_pais where pais_id = ESCA_PAIS_ID_ANTERIOR) as CODPAIANTERIOR
    , (select unlo_codigo from igen_unlocode_unlo where unlo_id = ESCA_loco_ID_ANTERIOR) as CODPUEANTERIOR
    , (select pais_iso from igen_pais_pais where pais_id = ESCA_PAIS_ID_siguiente) as CODPAIsiguiente
    , (select unlo_codigo from igen_unlocode_unlo where unlo_id = ESCA_loco_ID_siguiente) as CODPUEsiguiente
    , MANI_ES_SERV_REGULAR_AUT as INDSERREGULAR, null as NUMSERVICIO, MANI_ES_REGIMEN_SIMPLE as INDREGSIMPLIF
    , MANI_TRANSITO_COM_SIM as CODTIPOTRANSITO
    , (case MANI_TIPO_OPERACION when 'C' then '1' when 'D' then '2' end) as CODTIPOMOVMERC, MANI_FECHA_referencia as FECDECLARACION
    , (SELECT serv_numero from icom_servicio_serv where serv_id = esca_id) AS NUMESCALA
    , null as INDBAJA, null as FECBAJA, sysdate as FECALTA, null as FECMODIF, null as USRALTA, null as USRMODIF
    , null as GUIDSRV
    , /*(select buqt_codigo from IGEN_BUQUETIPO_BUQT where BUQT_id = (
        select BUQU_BUQT_ID from IESC_BUQUETEMP_BUQU where buqu_buque_id = esca_buque_id and BUQU_FECHA_CREACION <= MANI_FECHA_REFERENCIA and (buqu_fecha_fin is null or buqu_fecha_fin > MANI_FECHA_REFERENCIA))
      )*/ null as CODTIPOBUQUE
    , (select term_codigo from iman_terminal_term where term_id = mani_terminal_ID) as CODTERMINAL
    , /*(select traf_codigo from iesc_trafico_traf where traf_id = mani_servicio_ID)*/ null as TIPTRAFICO
    , null as TIPTRAFICOSUGERIDO, null as CODSERVMARIT, null as INDRECIBCOARRI, null as INDTERMDESCONOCIDA, null as INDRECIBNDP
    , ESCA_FECHA_INICIO as FECINIREALESCALA
    , (case MAni_CODIGO_EXENCION when 0 then '0' when 1 then '0' else '1' end) AS ESTINDEXENTA
    , null as ESTPAIOPPEEME, null as ESTDIGPAIOPPEEME, null as ESTIMOESCALA
    , (case when MANI_ES_VIA_EDI = 1 then '0' else '1' end) AS INDMANUAL
    , (case when MANI_NUMERO_TRAMOS is null then '1' else '0' end) AS INDSINTRAMOS

    , null as CODPROCESOCARGA
    , null as CODPUEESCALA, null as ANYOESCALA, null as CODESCALA
FROM icom_servicio_serv serv
    INNER JOIN iman_manifiesto_mani mani ON
        mani_id = serv_id
    left join iesc_escala_esca on
        esca_id = mani_escala_id
order by codtipobuque
;