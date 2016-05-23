DELETE from B4_MANIFIESTO;
DELETE from B4_BUQUEPESQUERO;

update IPES_ZONAPESCA_ZOPE set zope_codigo = '**' where zope_codigo = '****';
update B4_ZONAPESCA set codigo = '**' where codigo = '***';

insert into B4_BUQUEPESQUERO (
    CODIGO, NOMBRE, CODTIPOBUQUE, CODZONAPESCA, CODARTEPESCA, CODCONSIGNATARIO, CODARMADOR, LISTA, MATRICULA, FOLIO, IDBUQUEMERCANTE, GT, ESLORA, MANGA
    , CALADO, BANDERA, CODCENSO, INDBASE, INDNACIONAL, INDB0MANUAL, FECULTLIQB0, INDBAJA, FECBAJA, OBSERVACIONES, GUIDSRV, USRALTA, USRMODIF, FECALTA, FECMODIF
    , IDBUQUEAPLICANTERIOR, CONSIGAPLICANTERIOR, ARMADORAPLICANTERIOR, CODPERMEX, IDSUJPASIVO2, IDSUJPASIVO3, CODMMA
)
SELECT
    (select trid_new_id from tbl_traduccion_ids_trid where trid_table_name = 'IPES_BUQUE_BUPE' AND trid_old_id = bupe.bupe_id) as CODIGO
    , bupe_nombre as NOMBRE
    , (select btpe_codigo from IPES_BUQUETIPO_BTPE where btpe_id = BUPE_TIPO_BUQUE_ID) as CODTIPOBUQUE
    , (select zope_codigo from IPES_ZONAPESCA_ZOPE where zope_id = BUPE_zona_pesca_ID) as CODZONAPESCA
    , (select arpe_codigo from IPES_artepesca_arpe where arpe_id = BUPE_arte_pesca_ID) as CODARTEPESCA
    , (select trid_new_id from tbl_traduccion_ids_trid where trid_table_name = 'ICOM_ORGANIZACION_ORGA' AND trid_old_id = bupet.BUPE_ORGA_ID_CONSIGNATARIO) as CODCONSIGNATARIO
    , (select trid_new_id from tbl_traduccion_ids_trid where trid_table_name = 'ICOM_ORGANIZACION_ORGA' AND trid_old_id = bupet.BUPE_ORGA_ID_ARMADOR) as CODARMADOR
    , bupe_lista as LISTA, bupe_matricula as MATRICULA, bupe_folio as FOLIO
    , (select trid_new_id from tbl_traduccion_ids_trid where trid_table_name = 'IESC_BUQUE_BUQU' AND trid_old_id = bupet.BUPE_BUQUE_ID) as IDBUQUEMERCANTE
    , bupe_gt as GT, bupe_eslora as ESLORA, bupe_manga as MANGA, bupe_calado_maximo as CALADO
    , (select PAIS_ISO from IGEN_PAIS_PAIS where PAIS_ID = bupet.BUPE_bandera) as BANDERA
    , bupe_censo as CODCENSO
    , null as INDBASE
    , null as INDNACIONAL
    , null as INDB0MANUAL, null as FECULTLIQB0
    , null as INDBAJA, null as FECBAJA, null as OBSERVACIONES, null as GUIDSRV, null as USRALTA, null as USRMODIF, sysdate as FECALTA, null as FECMODIF
    , null as IDBUQUEAPLICANTERIOR, null as CONSIGAPLICANTERIOR, null as ARMADORAPLICANTERIOR, null as CODPERMEX, null as IDSUJPASIVO2, null as IDSUJPASIVO3, null as CODMMA
FROM 
    IPES_BUQUE_BUPE bupe
    INNER JOIN IPES_BUQUEtemp_BUPE bupet ON
        bupet.bupe_id = bupe.bupe_id
where
    bupe_fecha_creacion <= sysdate
    and (bupe_fecha_fin is null or bupe_fecha_fin > sysdate)
;

insert into B4_MANIFIESTO (
    CODPUE, ANYO, CODMANIF, FECMANIFIESTO, CODTIPOOPERACION, CODTIPOVENTA, CODTIPOIVA, CODTIPOMANIFIESTO, CODSUBTIPOMANIFIESTO, REFERENCIA
    , IDSUJPASIVO, CODBUQUEPESQUERO, CODMUELLE, IMPORTEMANIF, NUMKGMANIF, CODZONAPESCA, CODARTEPESCA, CODTIPODOC1, NUMDOC1, CODTIPODOC2, NUMDOC2
    , CODTIPODOC3, NUMDOC3, INDVIAFICHERO, NOMFICHERO, INDGENERAB0, INDLIQB4, INDEXENTOLIQB4, MOTEXENTOLIQB4, ESTINDEXENTA, OBSERVACIONES
    , GUIDSRV, USRALTA, USRMODIF, FECALTA, FECMODIF, INDRETIRADA, NUMDOCRETIRADA, NUMKGRETIRADA, FECDESCARGAORIGEN, PUERTOORIGEN, ORDEN, CODVENDEDOR
    , MATRICFICHERO, ARMADORFICHERO, VENDEDORFICHERO, TIPOPEFICHERO, FECCARGAFICHERO, FECDOCRETIRADA, NUEVOARMADORFICHERO
)
SELECT
    (select subp_codigo from IGEN_subpuerto_subp where subp_ID = serv_subp_id) AS CODPUE
    , serv_anno AS ANYO, serv_numero AS CODMANIF, MAPE_FECHA_REFERENCIA AS FECMANIFIESTO
    , (SELECT topp_codigo FROM IPES_OPERACIONTIPO_TOPP WHERE topp_id = MAPE_TIPO_OPERACION_ID) AS CODTIPOOPERACION
    , (case MAPE_ORDEN_VENTA when 'P' then 1 else 2 end) AS CODTIPOVENTA
    , (SELECT ivat_codigo FROM ifac_ivatipo_ivat WHERE ivat_id = MAPE_TIPO_IVA_ID) AS CODTIPOIVA
    , (SELECT MPTI_codigo FROM IPES_MANIFIESTOTIPO_MPTI WHERE MPTI_id = MAPE_TIPO_MANIFIESTO_ID) AS CODTIPOMANIFIESTO
    , (SELECT MPST_codigo FROM IPES_MANIFIESTOSTIPO_MPST WHERE MPST_id = MAPE_subTIPO_MANIFIESTO_ID) AS CODSUBTIPOMANIFIESTO
    , MAPE_REFERENCIA AS REFERENCIA, MAPE_ES_SUJ_PAS_SUSTIT AS IDSUJPASIVO
    , (select trid_new_id from tbl_traduccion_ids_trid where trid_table_name = 'IPES_BUQUE_BUPE' AND trid_old_id = MAPE_BUQUE_ID) as CODBUQUEPESQUERO
    , (SELECT alin_codigo FROM IGEN_ALINEACION_ALIN WHERE ALIN_id = MAPE_ALINEACION_ID) AS CODMUELLE
    , MAPE_IMPORTE_TOTAL AS IMPORTEMANIF, MAPE_PESO_TOTAL AS NUMKGMANIF
    , (SELECT zope_codigo FROM IPES_ZONAPESCA_ZOPE WHERE zope_id = MAPE_ZONA_PESCA_ID) AS CODZONAPESCA
    , (SELECT arpe_codigo FROM IPES_artePESCA_arpe WHERE arpe_id = MAPE_arte_PESCA_ID) AS CODARTEPESCA
    , NULL AS CODTIPODOC1, NULL AS NUMDOC1
    , NULL AS CODTIPODOC2, NULL AS NUMDOC2
    , NULL AS CODTIPODOC3, NULL AS NUMDOC3
    , (case when MAPE_NOMBRE_FICHERO is null then '0' else '1' end) AS INDVIAFICHERO
    , MAPE_NOMBRE_FICHERO AS NOMFICHERO
    , NULL AS INDGENERAB0
    , NULL AS INDLIQB4
    , (case MAPE_CODIGO_EXENCION when 0 then '0' when 2 then '0' else '1' end) AS INDEXENTOLIQB4
    , NULL AS MOTEXENTOLIQB4
    , (case MAPE_CODIGO_EXENCION when 0 then '0' when 1 then '0' else '1' end) AS ESTINDEXENTA
    , MAPE_OBSERV AS OBSERVACIONES, NULL AS GUIDSRV, NULL AS USRALTA, NULL AS USRMODIF
    , SYSDATE AS FECALTA, NULL AS FECMODIF
    , NULL AS INDRETIRADA, NULL AS NUMDOCRETIRADA, NULL AS NUMKGRETIRADA, NULL AS FECDESCARGAORIGEN, NULL AS PUERTOORIGEN, NULL AS ORDEN
    , (select trid_new_id from tbl_traduccion_ids_trid where trid_table_name = 'ICOM_ORGANIZACION_ORGA' AND trid_old_id = MAPE_ORGA_ID_VENDEDOR) as CODVENDEDOR
    , NULL AS MATRICFICHERO, NULL AS ARMADORFICHERO, NULL AS VENDEDORFICHERO, NULL AS TIPOPEFICHERO, NULL AS FECCARGAFICHERO, NULL AS FECDOCRETIRADA, NULL AS NUEVOARMADORFICHERO
FROM 
    ipes_manifiesto_mape mape
    inner join icom_servicio_serv serv on serv_id = mape_id
;




select * from B4_TIPOVENTA;
SELECT * FROM B4_MANIFIESTO;

SELECT * 
FROM 
    ipes_manifiesto_mape
    inner join icom_servicio_serv on serv_id = mape_id
;
