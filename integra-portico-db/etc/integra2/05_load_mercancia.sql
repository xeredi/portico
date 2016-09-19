
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
SELECT 
    (select subp_codigo from IGEN_subpuerto_subp where subp_ID = serv_subp_id) AS CODPUE
    , serv_anno AS ANYO, serv_numero AS CODSER
    , serv_numero as NUMDECLARACION /* ojo */
    , MANI_TIPO_OPERACION as TIPODECLARACION
    , MANI_NUMERO_VIAJE as NUMVIAJE
    , (select BUQU_NOMBRE_BUQUE from IESC_BUQUETEMP_BUQU where buqu_es_activo = 1 and buqu_buque_id = esca_buque_id and BUQU_FECHA_CREACION <= MANI_FECHA_REFERENCIA and (buqu_fecha_fin is null or buqu_fecha_fin > MANI_FECHA_REFERENCIA)) as NOMBUQUE
    , (select BUQU_codigo_imo from IESC_BUQUE_BUQU where buqu_buque_id = esca_buque_id) as IDENTBUQUE
    , (select pais_iso from igen_pais_pais where pais_id = (
        select BUQU_BANDERA_PAIS_ID from IESC_BUQUETEMP_BUQU where buqu_es_activo = 1 and buqu_buque_id = esca_buque_id and BUQU_FECHA_CREACION <= MANI_FECHA_REFERENCIA and (buqu_fecha_fin is null or buqu_fecha_fin > MANI_FECHA_REFERENCIA))
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
    , 0 as INDBAJA, null as FECBAJA, sysdate as FECALTA, null as FECMODIF, null as USRALTA, null as USRMODIF
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
    , (SELECT subp_codigo FROM igen_subpuerto_subp WHERE subp_id = (SELECT serv_subp_id from icom_servicio_serv where serv_id = esca_id)) AS CODPUEESCALA
    , (SELECT serv_anno from icom_servicio_serv where serv_id = esca_id) AS ANYOESCALA
    , (SELECT serv_numero from icom_servicio_serv where serv_id = esca_id) AS CODESCALA
FROM icom_servicio_serv serv
    INNER JOIN iman_manifiesto_mani mani ON
        mani_id = serv_id
    left join iesc_escala_esca on
        esca_id = mani_escala_id
where serv_fecha_baja is null
    and serv_numero > '00001' 
-- order by codpue, anyo, codser
;



INSERT INTO G3_TRAMO (
    CODPUE
    , ANYO
    , CODSER
    , CODTRAMO
    , IDCONSIGNATARIO
    , CODESTADO
    , FECALTA
    , FECMODIF
    , USRALTA
    , USRMODIF
    , GUIDSRV
    , INDLIQT2
    , INDLIQT3
    , IDSUJPASIVO
    , INDNOLIQUIDABLE
    , INDCONOCPASAJ
    , INDCONOCMERCVAC
    , INDNOLIQMATRICREPET
    , INDMATRICREPET
    , INDREGSIMPLIF
    , IDSUJPASIVOT2
    , INDT2IMPORTECERO
    , INDT3IMPORTECERO
    , INDCONTRASTECOARRI
    , INDCONTRASTENDPPART
    , INDCONTRASTENDPEQUIP
    , INDNOLIQT2NOCT
    , INDNOLIQT3NOCT
    , INDT2PTEREVIMPCERO
    , INDT3PTEREVIMPCERO
    , INDT2REVIMPCERO
    , INDT3REVIMPCERO
    , INDDISCREP
    , ESTINDEXENTA
    , INDMANUAL
    , NUMTRAMOSIME
    , NUMVERSION
    , INDULTIMAVERSION
    , MODOVERSION
    , TIPOREVISION
    , OBSERVACIONES
    , NUMRESOLUCION
    , FACTRECTIF
    , FECREGSALIDA
    , DOCSUSTRECT
    , NUMVIAJE
    , NOMBUQUE
    , IDENTBUQUE
    , CODPAIBUQUE
    , FECENTSAL
    , CODMUELLE
    , IDESTIBADOR
    , CODPAIANTERIOR
    , CODPUEANTERIOR
    , CODPAISIGUIENTE
    , CODPUESIGUIENTE
    , INDSERREGULAR
    , NUMSERVICIO
    , CODTIPOTRANSITO
    , CODTIPOMOVMERC
    , CODTERMINAL
    , INDTERMDESCONOCIDA
    , ESTINDTERMCONCT3
    , INDCOEFRORO
    , INDPDTECONTCOARRI
    , INDDISCREPCOARRI
    , CODPUEESC
    , ANYOESC
    , CODESC
    , CODESTADIA
    , INDEXENTOT2
    , INDEXENTOT3
    , JUSTIFEXENTOT2
    , JUSTIFEXENTOT3
    , CODTIPOIVAT2
    , CODTIPOIVAT3
    , IND215
    , IND2453
    , CODBON2453
    , PORC2453
    , CODPROCESOCARGA
    , NIFCSGMERCANCIA
    , CARDIFTRAMO
    , CODTIPCONCT2
    , OBSERVACIONESFACT
    , TOTALKGGRUPO1
    , TOTALKGGRUPO2
    , TOTALKGGRUPO3
    , TOTALKGGRUPO4
    , TOTALKGGRUPO5
    , TOTALVEHREGMERC
    , TOTAL0001
    , TOTAL0001C
    , TOTAL0001X
    , TOTAL0001D
    , TOTAL0004
    , TOTAL0005
    , TOTAL0005L
    , TOTAL0006
    , TOTAL0007
    , TOTAL0008
    , TOTALCN20LLENO
    , TOTALCN40LLENO
    , TOTALCN20VACIO
    , TOTALCN40VACIO
    , TOTALOTRPEQLLENO
    , TOTALOTRPEQVACIO
    , INDMIGRACION
    , TRAMUECODMUELLE
    , TRAMUECODTRAMO
    , REVISADO
)
SELECT 
    (select subp_codigo from IGEN_subpuerto_subp where subp_ID = serv_subp_id) AS CODPUE
    , serv_anno AS ANYO
    , serv_numero AS CODSER
    , (select trid_new_id from tbl_traduccion_ids_trid where trid_table_name = 'IMAN_CONSIGNATARIO_MACO' AND trid_old_id = MACO_ID) as CODTRAMO
    , (select trid_new_id from tbl_traduccion_ids_trid where trid_table_name = 'ICOM_ORGANIZACION_ORGA' AND trid_old_id = MANI_CONSIGNATARIO_ID) as IDCONSIGNATARIO
    , 'FI' AS CODESTADO /* ojo */
    , SYSDATE AS FECALTA
    , NULL AS FECMODIF
    , 'prueba1' AS USRALTA
    , NULL AS USRMODIF
    , NULL AS GUIDSRV
    , NULL AS INDLIQT2
    , NULL AS INDLIQT3
    , NULL AS IDSUJPASIVO
    , NULL AS INDNOLIQUIDABLE
    , NULL AS INDCONOCPASAJ
    , NULL AS INDCONOCMERCVAC
    , NULL AS INDNOLIQMATRICREPET
    , NULL AS INDMATRICREPET
    , MANI_ES_REGIMEN_SIMPLE AS INDREGSIMPLIF
    , NULL AS IDSUJPASIVOT2
    , NULL AS INDT2IMPORTECERO
    , NULL AS INDT3IMPORTECERO
    , NULL AS INDCONTRASTECOARRI
    , NULL AS INDCONTRASTENDPPART
    , NULL AS INDCONTRASTENDPEQUIP
    , NULL AS INDNOLIQT2NOCT
    , NULL AS INDNOLIQT3NOCT
    , NULL AS INDT2PTEREVIMPCERO
    , NULL AS INDT3PTEREVIMPCERO
    , NULL AS INDT2REVIMPCERO
    , NULL AS INDT3REVIMPCERO
    , NULL AS INDDISCREP
    , NULL AS ESTINDEXENTA
    , NULL AS INDMANUAL
    , NULL AS NUMTRAMOSIME
    , NULL AS NUMVERSION
    , NULL AS INDULTIMAVERSION
    , NULL AS MODOVERSION
    , NULL AS TIPOREVISION
    , NULL AS OBSERVACIONES
    , NULL AS NUMRESOLUCION
    , NULL AS FACTRECTIF
    , NULL AS FECREGSALIDA
    , NULL AS DOCSUSTRECT
    , NULL AS NUMVIAJE
    , buqut.buqu_nombre_buque AS NOMBUQUE
    , buqu.buqu_codigo_imo AS IDENTBUQUE
    , (select pais_iso from IGEN_PAIS_PAIS where pais_id = buqut.buqu_bandera_pais_id) as CODPAIBUQUE
    , NULL AS FECENTSAL
    , (select alin_codigo FROM igen_alineacion_alin WHERE alin_id = mani_alineacion_id) AS CODMUELLE
    , NULL AS IDESTIBADOR
    , (select pais_iso from igen_pais_pais where pais_id = ESCA_PAIS_ID_ANTERIOR) as CODPAIANTERIOR
    , (select unlo_codigo from igen_unlocode_unlo where unlo_id = ESCA_loco_ID_ANTERIOR) as CODPUEANTERIOR
    , (select pais_iso from igen_pais_pais where pais_id = ESCA_PAIS_ID_siguiente) as CODPAIsiguiente
    , (select unlo_codigo from igen_unlocode_unlo where unlo_id = ESCA_loco_ID_siguiente) as CODPUEsiguiente
    , NULL AS INDSERREGULAR
    , NULL AS NUMSERVICIO
    , NULL AS CODTIPOTRANSITO
    , NULL AS CODTIPOMOVMERC
    , (select term_codigo from iman_terminal_term where term_id = mani_terminal_id) AS CODTERMINAL
    , NULL AS INDTERMDESCONOCIDA
    , NULL AS ESTINDTERMCONCT3
    , NULL AS INDCOEFRORO
    , NULL AS INDPDTECONTCOARRI
    , NULL AS INDDISCREPCOARRI
    , (SELECT subp_codigo FROM igen_subpuerto_subp WHERE subp_id = (SELECT serv_subp_id from icom_servicio_serv where serv_id = esca_id)) AS CODPUEESC
    , (SELECT serv_anno from icom_servicio_serv where serv_id = esca_id) AS ANYOESC
    , (SELECT serv_numero from icom_servicio_serv where serv_id = esca_id) AS CODESC
    , NULL AS CODESTADIA
    , NULL AS INDEXENTOT2
    , NULL AS INDEXENTOT3
    , NULL AS JUSTIFEXENTOT2
    , NULL AS JUSTIFEXENTOT3
    , NULL AS CODTIPOIVAT2
    , NULL AS CODTIPOIVAT3
    , NULL AS IND215
    , NULL AS IND2453
    , NULL AS CODBON2453
    , NULL AS PORC2453
    , NULL AS CODPROCESOCARGA
    , NULL AS NIFCSGMERCANCIA
    , NULL AS CARDIFTRAMO
    , NULL AS CODTIPCONCT2
    , NULL AS OBSERVACIONESFACT
    , NULL AS TOTALKGGRUPO1
    , NULL AS TOTALKGGRUPO2
    , NULL AS TOTALKGGRUPO3
    , NULL AS TOTALKGGRUPO4
    , NULL AS TOTALKGGRUPO5
    , NULL AS TOTALVEHREGMERC
    , NULL AS TOTAL0001
    , NULL AS TOTAL0001C
    , NULL AS TOTAL0001X
    , NULL AS TOTAL0001D
    , NULL AS TOTAL0004
    , NULL AS TOTAL0005
    , NULL AS TOTAL0005L
    , NULL AS TOTAL0006
    , NULL AS TOTAL0007
    , NULL AS TOTAL0008
    , NULL AS TOTALCN20LLENO
    , NULL AS TOTALCN40LLENO
    , NULL AS TOTALCN20VACIO
    , NULL AS TOTALCN40VACIO
    , NULL AS TOTALOTRPEQLLENO
    , NULL AS TOTALOTRPEQVACIO
    , NULL AS INDMIGRACION
    , NULL AS TRAMUECODMUELLE
    , NULL AS TRAMUECODTRAMO
    , NULL AS REVISADO
FROM icom_servicio_serv serv
    INNER JOIN iman_manifiesto_mani mani ON
        mani_id = serv_id
    INNER JOIN IMAN_CONSIGNATARIO_MACO ON 
        maco_mani_id = serv_id
    left join iesc_escala_esca on
        esca_id = mani_escala_id
    left join iesc_buque_buqu buqu on 
        esca_buque_id = buqu.BUQU_BUQUE_ID 
    left join IESC_BUQUETEMP_BUQU buqut on 
        esca_buque_id = buqut.BUQU_BUQUE_ID
        and ESCA_FECHA_ENTRADA >= buqut.BUQU_FECHA_CREACION
        and (buqut.BUQU_FECHA_fin is null or buqut.BUQU_FECHA_fin > ESCA_FECHA_ENTRADA)
        and buqut.buqu_es_activo = 1
where serv_fecha_baja is null
    and serv_numero > '00001' 
;

INSERT INTO G3_CONOCIMIENTO (
    CODPUE
    ,  ANYO
    ,  CODSER
    ,  CODTRAMO
    ,  NUMORDEN
    ,  TIPOCONOC
    ,  CONOCEMBARQUE
    ,  CODPAI1
    ,  CODPUE1
    ,  CODPAI2
    ,  CODPUE2
    ,  CODPAI3
    ,  CODPUE3
    ,  CODPAI4
    ,  CODPUE4
    ,  CODTIPTRANSPORTE
    ,  SERVMERCANCIA
    ,  INDAH
    ,  INDEM
    ,  INDPE
    ,  INDBAJA
    ,  FECBAJA
    ,  FECALTA
    ,  FECMODIF
    ,  USRALTA
    ,  USRMODIF
    ,  CODTIPOTERORIGEN
    ,  CODTIPOTERDESTINO
    ,  ESTCODTIPOPE
    ,  ESTCODTIPNAV
    ,  ESTCODTIPTER
    ,  ESTINDNACIONAL
    ,  ESTCODTIPOSCHENGEN
    ,  ESTCODPAI
    ,  ESTCODPUE
    ,  INDNOAPLICSITAD
    ,  ESTCODTIPOPEROPPE
    ,  ESTCODTIPNAVOPPE
    ,  ESTINDTRANSITO
    ,  OBSERVACIONES
    ,  ESTCODTIPTERORIG
    ,  ESTCODTIPTERDEST
    ,  ESTCODTIPTER2
    ,  ESTCODTIPTER4
    ,  NUMDECMANASOCIADO
    ,  IMOBUQUE
    ,  CODCOMERCIAL
    ,  CODMUELLE
    ,  DESCEDILOCODE1
    ,  DESCEDILOCODE2
    ,  DESCEDILOCODE3
    ,  DESCEDILOCODE4
)
/*
;
select * from (
*/
SELECT 
    (select subp_codigo from IGEN_subpuerto_subp where subp_ID = serv_subp_id) AS CODPUE
    , serv_anno AS ANYO
    , serv_numero AS CODSER
    , (select trid_new_id from tbl_traduccion_ids_trid where trid_table_name = 'IMAN_CONSIGNATARIO_MACO' AND trid_old_id = MACO_ID) as CODTRAMO
    , MABL_ORDEN AS NUMORDEN
    , (CASE MABL_TIPO WHEN 'M' THEN 'M' WHEN 'P' THEN 'P' WHEN 'V' THEN 'T' END) AS TIPOCONOC
    , NULL AS CONOCEMBARQUE
    /* ojo */
    , (select pais_iso from igen_pais_pais where pais_id = (SELECT unlo_pais_id from igen_unlocode_unlo WHERE unlo_id = MABL_ORIGEN_UNLO_ID)) as CODPAI1
    , (select unlo_codigo from igen_unlocode_unlo where unlo_id = MABL_ORIGEN_UNLO_ID) as CODPUE1
    , (select pais_iso from igen_pais_pais where pais_id = (SELECT unlo_pais_id from igen_unlocode_unlo WHERE unlo_id = MABL_CARGA_UNLO_ID)) as CODPAI2
    , (select unlo_codigo from igen_unlocode_unlo where unlo_id = MABL_CARGA_UNLO_ID) as CODPUE2
    , (select pais_iso from igen_pais_pais where pais_id = (SELECT unlo_pais_id from igen_unlocode_unlo WHERE unlo_id = MABL_DESCARGA_UNLO_ID)) as CODPAI3
    , (select unlo_codigo from igen_unlocode_unlo where unlo_id = MABL_DESCARGA_UNLO_ID) as CODPUE3
    , (select pais_iso from igen_pais_pais where pais_id = (SELECT unlo_pais_id from igen_unlocode_unlo WHERE unlo_id = MABL_DESTINO_UNLO_ID)) as CODPAI4
    , (select unlo_codigo from igen_unlocode_unlo where unlo_id = MABL_DESTINO_UNLO_ID) as CODPUE4
    , (select tedi_codigo from IMAN_MODOTRANSPEDI_TEDI where tedi_id = MABL_MODO_TRANSP_EDI_ID) AS CODTIPTRANSPORTE
    , NULL AS SERVMERCANCIA
    , NULL AS INDAH
    , NULL AS INDEM
    , NULL AS INDPE
    , 0 AS INDBAJA
    , NULL AS FECBAJA
    , SYSDATE AS FECALTA
    , NULL AS FECMODIF
    , 'prueba1' AS USRALTA
    , NULL AS USRMODIF
    , NULL AS CODTIPOTERORIGEN
    , NULL AS CODTIPOTERDESTINO
    , NULL AS ESTCODTIPOPE
    , NULL AS ESTCODTIPNAV
    , NULL AS ESTCODTIPTER
    , NULL AS ESTINDNACIONAL
    , NULL AS ESTCODTIPOSCHENGEN
    , NULL AS ESTCODPAI
    , NULL AS ESTCODPUE
    , NULL AS INDNOAPLICSITAD
    , NULL AS ESTCODTIPOPEROPPE
    , (case (select navt_codigo from IGEN_NAVEGACIONTIPO_NAVT where navt_id = MABL_TIPO_NAVEGACION_ID)
        WHEN '**' THEN NULL
        ELSE (select navt_codigo from IGEN_NAVEGACIONTIPO_NAVT where navt_id = MABL_TIPO_NAVEGACION_ID)
    end) AS ESTCODTIPNAVOPPE
    , NULL AS ESTINDTRANSITO
    , NULL AS OBSERVACIONES
    , NULL AS ESTCODTIPTERORIG
    , NULL AS ESTCODTIPTERDEST
    , NULL AS ESTCODTIPTER2
    , NULL AS ESTCODTIPTER4
    , NULL AS NUMDECMANASOCIADO
    , NULL AS IMOBUQUE
    , NULL AS CODCOMERCIAL
    , NULL AS CODMUELLE
    , NULL AS DESCEDILOCODE1
    , NULL AS DESCEDILOCODE2
    , NULL AS DESCEDILOCODE3
    , NULL AS DESCEDILOCODE4
FROM icom_servicio_serv serv
    INNER JOIN iman_manifiesto_mani mani ON
        mani_id = serv_id
    INNER JOIN iman_bl_mabl ON
        mabl_mani_id = serv_id
    INNER JOIN IMAN_CONSIGNATARIO_MACO ON 
        maco_mani_id = serv_id
        AND mabl_consignatario_id = maco_id
where serv_fecha_baja is null
    and serv_numero > '00001' 
    and mabl_es_activo = 1 
/*
) sql
where 
    not exists (
        select 1 from m_puerto
        where 
            codpais = codpai4
            AND codpue = codpue4
    )
*/
;


/* correccion de numeros de partida duplicados */
select * 
from iman_partida_part part
where 
    exists (
        select 1 from iman_partida_part part2
        where 
            part2.part_mabl_id = part.part_mabl_id
            and part2.part_orden = part.part_orden
            and part2.part_es_activo = 1
            and part2.part_id <> part.part_id
    )
    and part.part_es_activo = 1
    AND EXISTS (
        SELECT 1 FROM IMAN_BL_MABL WHERE MABL_ID = PART_MABL_ID AND MABL_ES_ACTIVO = 1
    )
;

update iman_partida_part part set
    part.part_orden = 
        part.part_orden
        + 10000 * (
            SELECT COUNT(1) FROM iman_partida_part part2 
            where 
                part2.part_es_activo = 1
                AND part2.part_mabl_id = part.part_mabl_id 
                AND part2.part_orden = part.part_orden
                AND part2.part_id > part.part_id
        )
where 
    exists (
        select 1 from iman_partida_part part2
        where 
            part2.part_mabl_id = part.part_mabl_id
            and part2.part_orden = part.part_orden
            and part2.part_es_activo = 1
            and part2.part_id <> part.part_id
    )
    and part.part_es_activo = 1
    AND EXISTS (
        SELECT 1 FROM IMAN_BL_MABL WHERE MABL_ID = PART_MABL_ID AND MABL_ES_ACTIVO = 1
    )
;








INSERT INTO G3_PARTIDA (
    CODPUE
    , ANYO
    , CODSER
    , CODTRAMO
    , NUMORDEN
    , TIPOCONOC
    , NUMPARTIDA
    , NUMBULTOS
    , CODTIPBULTO
    , CODARAN
    , MARCAS
    , CODMARCAVEH
    , PESO
    , VOLUMEN
    , SITADUANERA
    , INDBAJA
    , FECBAJA
    , CODMUELLE
    , IDESTIBADOR
    , CODTERMINAL
    , NUMDECLARACIONPREVISTA
    , CODCOMERCIAL
    , DESCMERCANCIA
    , FECALTA
    , FECMODIF
    , USRALTA
    , USRMODIF
    , ESTINDPASSERVMARITIMO
    , ESTCODFORMAPRESENT
    , ESTCODVEHREGMERC
    , ESTINDINSTALESPECIAL
    , ESTINDTIENEEQUIP
    , ESTCODTIPEQMEM
    , ESTCODTIPOCN
    , ESTCODEQUIP
    , ESTMATRICEQUIP
    , ESTNUMEQUIPS
    , ESTTIPOTRANSOPPE
    , ESTTUCAOPPE
    , OBSERVACIONES
    , NUMBULTOSDEC
    , CODTIPOREGIMEN
    , CODTIPOVEHREGSIMPLIF
    , CODRECEPTORMERCANCIA
    , VERCODARAN
    , CODMARCAS
    , INDENS
    , MMPPONU
    , MMPPCLASE
    , MMPPPAGINA
    , MMPPENMIENDA
    , INDINSTALESPECIAL
    , CODCLASIFADICIONAL
    , INDB2NOAPLIC2453
)
/*
select CODPUE, ANYO, CODSER, CODTRAMO, NUMORDEN, TIPOCONOC, NUMPARTIDA, count(1)
from (
*/
SELECT
    (select subp_codigo from IGEN_subpuerto_subp where subp_ID = serv_subp_id) AS CODPUE
    , serv_anno AS ANYO
    , serv_numero AS CODSER
    , (select trid_new_id from tbl_traduccion_ids_trid where trid_table_name = 'IMAN_CONSIGNATARIO_MACO' AND trid_old_id = MACO_ID) as CODTRAMO
    , MABL_ORDEN AS NUMORDEN
    , (CASE MABL_TIPO WHEN 'M' THEN 'M' WHEN 'P' THEN 'P' WHEN 'V' THEN 'T' END) AS TIPOCONOC

    , part_orden AS  NUMPARTIDA
    , PART_NUMERO_BULTOS AS  NUMBULTOS
    , (select tbul_codigo from IMAN_TIPOBULTO_TBUL where tbul_id = PART_TIPO_BULTO_ID) AS  CODTIPBULTO
    , (SELECT merc_codigo FROM IMAN_MERCANCIA_MERC WHERE merc_id = PART_MERCANCIA_ID) AS  CODARAN
    , NULL AS  MARCAS
    , (select vmar_codigo from IMAN_MARCAVEHICULO_VMAR where vmar_id = PART_MARCA_VEHICULO_ID) AS  CODMARCAVEH
    , PART_PESO AS  PESO
    , PART_VOLUMEN AS  VOLUMEN
    , NULL AS  SITADUANERA /*ojo*/
    , 0 AS  INDBAJA
    , NULL AS  FECBAJA
    , NULL AS  CODMUELLE
    , NULL AS  IDESTIBADOR
    , NULL AS  CODTERMINAL
    , NULL AS  NUMDECLARACIONPREVISTA
    , NULL AS  CODCOMERCIAL
    , NULL AS  DESCMERCANCIA
    , SYSDATE AS  FECALTA
    , NULL AS  FECMODIF
    , NULL AS  USRALTA
    , NULL AS  USRMODIF
    , NULL AS  ESTINDPASSERVMARITIMO
    , NULL AS  ESTCODFORMAPRESENT
    , NULL AS  ESTCODVEHREGMERC
    , NULL AS  ESTINDINSTALESPECIAL
    , NULL AS  ESTINDTIENEEQUIP
    , NULL AS  ESTCODTIPEQMEM
    , NULL AS  ESTCODTIPOCN
    , NULL AS  ESTCODEQUIP
    , NULL AS  ESTMATRICEQUIP
    , NULL AS  ESTNUMEQUIPS
    , NULL AS  ESTTIPOTRANSOPPE
    , NULL AS  ESTTUCAOPPE
    , PART_OBSERVACIONES AS  OBSERVACIONES
    , NULL AS  NUMBULTOSDEC
    , NULL AS  CODTIPOREGIMEN
    , NULL AS  CODTIPOVEHREGSIMPLIF
    , NULL AS  CODRECEPTORMERCANCIA
    , NULL AS  VERCODARAN
    , NULL AS  CODMARCAS
    , NULL AS  INDENS
    , NULL AS  MMPPONU
    , NULL AS  MMPPCLASE
    , NULL AS  MMPPPAGINA
    , NULL AS  MMPPENMIENDA
    , (CASE PART_INST_ESPEC_ESP_ID WHEN NULL THEN 0 ELSE 1 END) AS  INDINSTALESPECIAL
    , NULL AS  CODCLASIFADICIONAL
    , NULL AS  INDB2NOAPLIC2453
FROM iman_partida_part
    INNER JOIN iman_bl_mabl ON
        mabl_id = part_mabl_id
    INNER JOIN icom_servicio_serv serv ON
        serv_id = mabl_mani_id
    INNER JOIN iman_manifiesto_mani mani ON
        mani_id = serv_id
    INNER JOIN IMAN_CONSIGNATARIO_MACO ON 
        maco_mani_id = serv_id
        AND mabl_consignatario_id = maco_id
where serv_fecha_baja is null
    and serv_numero > '00001' 
    and part_es_activo = 1 
    and mabl_es_activo = 1 
/*
) sql
group by CODPUE, ANYO, CODSER, CODTRAMO, NUMORDEN, TIPOCONOC, NUMPARTIDA
having count(1) > 1
order by CODPUE, ANYO, CODSER, CODTRAMO, NUMORDEN, TIPOCONOC
*/
;





SELECT * FROM EST_TIPO_TERRITORIO;


SELECT * FROM EST_TIPO_OPECONOC	;

CA	Carga                               E, ET
DE	Descarga                            D, DT
TR	Tránsito marítimo
TB	Transbordo                          
TT	Tránsito terrestre

SELECT tobl_codigo, tobl_nombre FROM IMAN_TIPOOPERACION_TOBL maes INNER JOIN IMAN_TIPOOPERACIONI18N_TOBL i18n on i18n.tobl_id = maes.tobl_id ;

**	OPERACION GENERICA
AC	REC. ADUAN. > 5%
AS	REC. ADUAN. < 5%
AV	AVITUALLAMIENTO
CA	CTRL. ADUANERO TERR.
D	DESEMBARQUE
DT	DESEMB. EN TRANSITO
E	EMBARQUE
ET	EMBARQUE EN TRANSITO
T	TRANSBORDO
TD	TRANSBORDO DESCARGA
TE	TRANSBORDO EMBARQUE

select * from EST_TIPO_NAVEGACION;
select * from IGEN_NAVEGACIONTIPO_NAVT;

select * from G3_partida;
select * from G3_CONOCIMIENTO;
select * from G3_tramo;
select * from G3_CABECERA;

delete from G3_partida WHERE CODSER > 1;
delete from G3_CONOCIMIENTO WHERE CODSER > 1;
delete from G3_TRAMO WHERE CODSER > 1;
delete from G3_CABECERA WHERE CODSER > 1;


select * from 
G3_TIPOBULTO;


select tbul_codigo, tbul_nombre
from iman_tipobulto_tbul maes
    LEFT JOIN iman_tipobultoi18n_tbul i18n on i18n.tbul_id = maes.tbul_id
where not exists (select 1 from G3_TIPOBULTO where codigo = maes.tbul_codigo)
    and i18n.tbul_es_activo = 1
    order by tbul_codigo;