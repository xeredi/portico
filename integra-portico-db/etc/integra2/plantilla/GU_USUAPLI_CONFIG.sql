SET DEFINE OFF;
Insert into GU_USUAPLI_CONFIG
   (IDUSU, IDINFORME, ORDEN, CAMPOS)
 Values
   ('prueba', 'instalacion', 'NOMBRE ASC', 'CODINS,nombre,codapsct,CODPUE,despue,AGUA,ELECTRICIDAD');
Insert into GU_USUAPLI_CONFIG
   (IDUSU, IDINFORME, ORDEN, CAMPOS)
 Values
   ('prueba', 'equipamientoCabecera_popup', 'MATRICULA DESC', 'codtramo,nombrecompleto,desctipequip,desctiptamequip,tara,matricula,descestequip,unidadesvacios,numbultos,desesttucaoppe,desctipoconoc,codpai1,codpue1,codpai3,codpue3');
Insert into GU_USUAPLI_CONFIG
   (IDUSU, IDINFORME, ORDEN, CAMPOS)
 Values
   ('prueba', 'declaracionesmanifiestos', 'NUMDECLARACION DESC', 'numdeclaracion,ANYO,nombre,tipodeclaracion,nombrecompleto,numdoc,FECDECLARACION');
Insert into GU_USUAPLI_CONFIG
   (IDUSU, IDINFORME, ORDEN, CAMPOS)
 Values
   ('prueba', 'tramo', 'NUMDECLARACION DESC, CODTRAMO ASC', 'numdeclaracion,nombre,tipodeclaracion,nombrecompleto,numdoc,codtramo,numescala,buque,imo,paisant,puertoant,paissig,puertosig,codmuelle,indregsimplif,regsimplif,TIPCONCT2,DESC215');
Insert into GU_USUAPLI_CONFIG
   (IDUSU, IDINFORME, ORDEN, CAMPOS)
 Values
   ('prueba', 'escala', 'ETA DESC', 'NUMESCALA,CONSIGNATARIO,DESPUE,NOMBRE,GT,ESTADO,ETA,ETD,FECINIREAL,FECFINREAL');
Insert into GU_USUAPLI_CONFIG
   (IDUSU, IDINFORME, ORDEN, CAMPOS)
 Values
   ('prueba', 'lqborrador', 'PUERTO DESC,CODBORRADOR DESC', 'idaspectotarifa,idaspectosubtarifa,idaspectoextension,nombrecompleto,descestado,puerto,anyo,FECLIQ,codborrador,tipo,impnet,impimpuesto,imptot,codlote');
Insert into GU_USUAPLI_CONFIG
   (IDUSU, IDINFORME, ORDEN, CAMPOS)
 Values
   ('prueba', 'esttipomerc43', 'CODIGO ASC', 'CODIGO,DESCRIPCION');
Insert into GU_USUAPLI_CONFIG
   (IDUSU, IDINFORME, ORDEN, CAMPOS)
 Values
   ('prueba', 'diversogenerico', 'CODIGO ASC', 'codigo,fecinicio,fecfin,sujetopasivo,baremo,valorbaremo,unidades1,unidades2,BAREMOLIN2,VALORBAREMOLIN2,UNIDADES1LIN2,UNIDADES2LIN2');
Insert into GU_USUAPLI_CONFIG
   (IDUSU, IDINFORME, ORDEN, CAMPOS)
 Values
   ('prueba', 'mrutacontador', 'DESPUE ASC,CODIGO ASC', 'despue,CODIGO,descripcion,ZONA');
Insert into GU_USUAPLI_CONFIG
   (IDUSU, IDINFORME, ORDEN, CAMPOS)
 Values
   ('prueba', 'lqcoefservicio', 'SERVICIO ASC,FECINIVIG DESC', 'CODCOEFICIENTE,servicio,descripcion,valor,fecinivig,fecfinvig,codtiposervicio');
Insert into GU_USUAPLI_CONFIG
   (IDUSU, IDINFORME, ORDEN, CAMPOS)
 Values
   ('prueba', 'b4manifiesto', 'CODPUE ASC,ANYO ASC,CODMANIF ASC', 'anyo,codmanif,referencia,fecmanifiesto,cifsujpasivo,sujpasivo,importemanif,numkgmanif,liqb4,exentoliqb4,BUQUEPESQUERO');
Insert into GU_USUAPLI_CONFIG
   (IDUSU, IDINFORME, ORDEN, CAMPOS)
 Values
   ('prueba', 'conEquipamientoTramo_popup', 'NUMORDEN DESC', 'codequip,NUMORDEN,desctipequip,desctiptamequip,tara,matricula,codpai1,codpue1,codpai3,codpue3,matrepetida');
Insert into GU_USUAPLI_CONFIG
   (IDUSU, IDINFORME, ORDEN, CAMPOS)
 Values
   ('prueba', 'dpcanonocupacionglobal', 'CODPUEEXP ASC,CODEXP ASC,CODCANON ASC', 'expediente,objeto,nombrecompleto,numm2,zona,fecinicio,fecfin,desctipoocup,desctipoactiv,EXENTOVTLA,EXENTOVALORIN,EXENTODEPREC');
Insert into GU_USUAPLI_CONFIG
   (IDUSU, IDINFORME, ORDEN, CAMPOS)
 Values
   ('prueba', 'lqborrador_filtro', 'PUERTO DESC,CODBORRADOR DESC', 'ANYO,puerto,FECLIQ,codborrador,tipo,impnet,impimpuesto,imptot,idaspectotarifa,idaspectosubtarifa,idaspectoextension');
Insert into GU_USUAPLI_CONFIG
   (IDUSU, IDINFORME, ORDEN, CAMPOS)
 Values
   ('prueba', 'estparamfptuca', 'TUCA ASC,FECINIVIG DESC', 'tuca,descformapresent,fecinivig,fecfinvig,CODTUCA,FORMAPRESENT');
Insert into GU_USUAPLI_CONFIG
   (IDUSU, IDINFORME, ORDEN, CAMPOS)
 Values
   ('prueba', 'dpcanonocupacion', 'CODPUEEXP ASC,CODEXP ASC,CODCANON ASC', 'numm2,bienpublico,zona,fecinicio,fecfin,desctipoocup,desctipoactiv,EXENTOVTLA,EXENTODEPREC,EXENTOVALORIN');
Insert into GU_USUAPLI_CONFIG
   (IDUSU, IDINFORME, ORDEN, CAMPOS)
 Values
   ('prueba', 'muelle', 'DESCRIPCION ASC', 'codigo,descripcion,codpue,despue,CONCESIONADO,TIPCONCT2,CONCT3');
Insert into GU_USUAPLI_CONFIG
   (IDUSU, IDINFORME, ORDEN, CAMPOS)
 Values
   ('prueba', 't8suminbuque', 'CODIGO DESC', 'despue,anyo,codigo,numescala,fecinicio,fecfin,sujetopasivo,tiposuministro,consumo,exentoliq,liquidado');
Insert into GU_USUAPLI_CONFIG
   (IDUSU, IDINFORME, ORDEN, CAMPOS)
 Values
   ('prueba', 't2excursionista', 'CODPUE ASC,ANYO ASC,CODSER ASC', 'puerto,numescala,buque,imo,fecinicio,fecfin,numviajes,numexcursionistas,idusuario,nombrecompleto,EXENTOLIQ,liquidado');
Insert into GU_USUAPLI_CONFIG
   (IDUSU, IDINFORME, ORDEN, CAMPOS)
 Values
   ('prueba', 'g5transito', 'CODPUE ASC, ANYO ASC, CODSER ASC', 'nompue,codser,fecinicio,fecfin,nomtitular,nif,nombreemb,esloraemb,mangaemb,codmuelle,ZONA2');
Insert into GU_USUAPLI_CONFIG
   (IDUSU, IDINFORME, ORDEN, CAMPOS)
 Values
   ('prueba', 'buque', 'CODIGO ASC', 'codigo,imo,nombre,gt,armador,TIPOBUQUE');
Insert into GU_USUAPLI_CONFIG
   (IDUSU, IDINFORME, ORDEN, CAMPOS)
 Values
   ('prueba', 'serviciomaritimo', 'CODSERVICIO DESC', 'codservicio,nombre,RORO,INDREGULAR,INDTMCD');
Insert into GU_USUAPLI_CONFIG
   (IDUSU, IDINFORME, ORDEN, CAMPOS)
 Values
   ('prueba', 't8sumininstfija', 'DESPUE ASC,CODIGO DESC', 'despue,codigo,bienpublico,contador,fecconexion,fecdesconexion,CODBP');
Insert into GU_USUAPLI_CONFIG
   (IDUSU, IDINFORME, ORDEN, CAMPOS)
 Values
   ('prueba', 'buquecertglobal', 'CODINTERNO DESC', 'buque,imo,tipocert,FECINICIO,FECFIN');
Insert into GU_USUAPLI_CONFIG
   (IDUSU, IDINFORME, ORDEN, CAMPOS)
 Values
   ('prueba', 'tramConocimiento_popup', 'NUMORDEN ASC', 'numorden,desctipoconoc,codpai1,codpue1,codpai3,codpue3,desctiptransporte,codpai2,codpue2,codpai4,codpue4,CODTIPTRANSPORTE');
Insert into GU_USUAPLI_CONFIG
   (IDUSU, IDINFORME, ORDEN, CAMPOS)
 Values
   ('prueba', 'lqfactura', 'FECFACTURA DESC,CODPUEFACTURA ASC,NUMFACTURA DESC', 'nompuefactura,codserfactura,anyofactura,numfactura,fecfactura,codestfactura,nomcliente,nif,imptotal,numnotif,TASASTARIFAS');
Insert into GU_USUAPLI_CONFIG
   (IDUSU, IDINFORME, ORDEN, CAMPOS)
 Values
   ('prueba', 'lqborradorlqfacturalote_popup', 'PUERTO DESC,CODBORRADOR DESC', 'puerto,codborrador,NOMBRECOMPLETO,tipo,impnet,impimpuesto,imptot,idaspectotarifa,idaspectosubtarifa,idaspectoextension');
Insert into GU_USUAPLI_CONFIG
   (IDUSU, IDINFORME, ORDEN, CAMPOS)
 Values
   ('prueba', 'estadiatrafintglobal', 'NUMESCALA DESC, CODESTADIA DESC', 'despue,numescala,codestadia,nombrecompleto,gt,nombrebuque,imo,fecatraquereal,fecdesatraquereal,fatrqreal,codmuelleinireal,estado,EXENTAT1,EXENTAT7,LIQT1,LIQT7');
Insert into GU_USUAPLI_CONFIG
   (IDUSU, IDINFORME, ORDEN, CAMPOS)
 Values
   ('prueba', 'pesca', 'CODSERVICIO ASC', 'CODSERVICIO,desctipooperacion,desctipogravamen,fecoperacion,nombrecompleto,totalkgcrust,totalkgmolusc,totalkgpeces,totalkgmamif,totalkg');
Insert into GU_USUAPLI_CONFIG
   (IDUSU, IDINFORME, ORDEN, CAMPOS)
 Values
   ('prueba', 'practicajeestadia', 'CODSER ASC', 'codser,NOMPRACTICO1,TIPOMANIOBRA1,FECINI1,FECFIN1');
Insert into GU_USUAPLI_CONFIG
   (IDUSU, IDINFORME, ORDEN, CAMPOS)
 Values
   ('prueba', 'ocupsuprodante', 'CODPUE ASC, ANYO ASC, CODSER ASC', 'anyo,codser,NOMBRECOMPLETO,fecini,fecfin,tiporodante,unidades,numdias,liquidado,IDCLIENTE');
Insert into GU_USUAPLI_CONFIG
   (IDUSU, IDINFORME, ORDEN, CAMPOS)
 Values
   ('prueba', 'edimensaje', 'IDMENSAJE DESC', 'idmensaje,fecregistro,fecmensaje,destipomensaje,tipodocumento,numfuncion,nombreusuario,numrefmensaje,escala,deserror,desestado');
Insert into GU_USUAPLI_CONFIG
   (IDUSU, IDINFORME, ORDEN, CAMPOS)
 Values
   ('prueba', 'lqfacturalote', 'CODPUELOTE ASC,CODLOTE DESC', 'codlote,observaciones,fecfactura,feciniproceso,fecfinproceso,desestlote,impbase,impiva,imptotal,numborradores,numfacturas,INDBLOQUEADO');
Insert into GU_USUAPLI_CONFIG
   (IDUSU, IDINFORME, ORDEN, CAMPOS)
 Values
   ('prueba', 'b4tipooperacion', 'CODIGO ASC', 'codigo,nombre,codbaremob4,tipoventa,EXENTOB4,GENERAB0');
Insert into GU_USUAPLI_CONFIG
   (IDUSU, IDINFORME, ORDEN, CAMPOS)
 Values
   ('prueba', 'lqfacturalotelqborrador_popup', 'PUERTO DESC,CODBORRADOR DESC', 'puerto,codborrador,tipo,NOMBRECOMPLETO,impnet,impimpuesto,imptot,idaspectotarifa,idaspectosubtarifa,idaspectoextension');
Insert into GU_USUAPLI_CONFIG
   (IDUSU, IDINFORME, ORDEN, CAMPOS)
 Values
   ('prueba', 'contador', 'NUMCON DESC', 'despue,numcon,descripcion,descmovilfijo,tiposuministro,FECULTLIQ,VALORULTIMALECTURA,AGUASALADA');
Insert into GU_USUAPLI_CONFIG
   (IDUSU, IDINFORME, ORDEN, CAMPOS)
 Values
   ('prueba', 'dpexpediente', 'CODIGO DESC', 'expediente,objeto,nombrecompleto,fecotorgamiento,fecnotificacion,fecvencimiento,fecultliqocup,FECULTLIQACTIV,descestado,fecextincion,codigo');
Insert into GU_USUAPLI_CONFIG
   (IDUSU, IDINFORME, ORDEN, CAMPOS)
 Values
   ('prueba', 'estparamfptipobulto', 'TIPOBULTO ASC,FECINIVIG DESC', 'codtipobulto,tipobulto,descformapresent,fecinivig,fecfinvig');
Insert into GU_USUAPLI_CONFIG
   (IDUSU, IDINFORME, CAMPOS)
 Values
   ('prueba', 'edibuzon', 'IDBUZON,USUARIO,CIRCUITO,BUZON');
Insert into GU_USUAPLI_CONFIG
   (IDUSU, IDINFORME, ORDEN, CAMPOS)
 Values
   ('prueba', 'estadiaglobal', 'NUMESCALA DESC, CODESTADIA DESC', 'despue,codestadia,numescala,DESESTADO,nombrecompleto,gt,nombrebuque,imo,eslora,indliqt1,indexentat1,codpaidestinodec,codpuedestinodec,paidestinodec,puedestinodec');
Insert into GU_USUAPLI_CONFIG
   (IDUSU, IDINFORME, ORDEN, CAMPOS)
 Values
   ('prueba', 'marina', 'CODEXP ASC', 'CODEXP,DESCRIPCION,nombreconcesionario,fecinicio,fecultliqt0,fecultliqt5');
Insert into GU_USUAPLI_CONFIG
   (IDUSU, IDINFORME, ORDEN, CAMPOS)
 Values
   ('prueba', 'conPartida_popup', 'NUMPARTIDA ASC', 'numpartida,codaran,descmercancia,codgrupo,peso,CODTIPTRANSPORTE,DESCTIPTRANSPORTE,TIPOCONOC,DESCTIPOCONOC,CODPAI1,ANYO,CODPUE1,CODPAI3,CODPUE3,ESTTUCAOPPE,DESESTTUCAOPPE');
Insert into GU_USUAPLI_CONFIG
   (IDUSU, IDINFORME, ORDEN, CAMPOS)
 Values
   ('prueba', 't8sumingenerico', 'DESPUE ASC,FECINICIO DESC', 'despue,fecinicio,fecfin,sujetopasivo,tiposuministro,contador,consumo,EXENTOLIQ,MOTEXENTOLIQ');
Insert into GU_USUAPLI_CONFIG
   (IDUSU, IDINFORME, ORDEN, CAMPOS)
 Values
   ('prueba', 'marinaatraque', 'FECINICIO ASC, NOMBREEMB ASC', 'desctipopropulsion,eslora,manga,fecinicio,fecfin,exentot0,exentob5,nombreemb,matriculaemb,justifexentot0,justifexentob5,NOMFICHERO,PTOBASE');
Insert into GU_USUAPLI_CONFIG
   (IDUSU, IDINFORME, ORDEN, CAMPOS)
 Values
   ('prueba', 'b4buquepesquero', 'CODIGO ASC', 'codigo,nombre,tipobuque,consignatario,cifconsignatario,lista,matricula,folio,base,nacional,b0manual,FECULTLIQB0');
Insert into GU_USUAPLI_CONFIG
   (IDUSU, IDINFORME, ORDEN, CAMPOS)
 Values
   ('prueba', 'dpbienpublico', 'CODPUE ASC,CODIGO ASC', 'despue,codigo,descripcion,porcusoinst,instalacion,tipobien,fecinivig,fecfinvig,TOTALM2,USOINSTALACION');
Insert into GU_USUAPLI_CONFIG
   (IDUSU, IDINFORME, ORDEN, CAMPOS)
 Values
   ('prueba', 't3sumintrafint', 'CODPUE ASC,ANYO ASC,CODSER ASC', 'puerto,numescala,fecinicio,fecfin,numkgtotal,idusuario,cif,nombrecompleto,codapsct,LIQUIDADO,EXENTOLIQ');
Insert into GU_USUAPLI_CONFIG
   (IDUSU, IDINFORME, ORDEN, CAMPOS)
 Values
   ('prueba', 'lqfacturamotivoanulacion', 'CODMOTANULACION ASC', 'CODMOTANULACION,DESMOTANULACION');
Insert into GU_USUAPLI_CONFIG
   (IDUSU, IDINFORME, ORDEN, CAMPOS)
 Values
   ('prueba', 'paramvalorador', 'CODIGO DESC', 'CODIGO,valoradorasociado,nombreregla,valor,descripcionregla');
Insert into GU_USUAPLI_CONFIG
   (IDUSU, IDINFORME, ORDEN, CAMPOS)
 Values
   ('prueba', 'conPartidaTramo_popup', 'NUMPARTIDA ASC', 'numpartida,codaran,descmercancia,peso,codpai1,codpue1,codpai3,codpue3,numbultosdec,esttucaoppe,desesttucaoppe,CODPAI2,CODPUE2,CODPAI4,CODPUE4');
Insert into GU_USUAPLI_CONFIG
   (IDUSU, IDINFORME, ORDEN, CAMPOS)
 Values
   ('prueba', 'tipobuquebonif', 'CODIGO DESC', 'bonificacion,fecinicio,fecfin,PORCENTAJEBONIFICACION,CODBONIFICACION');
Insert into GU_USUAPLI_CONFIG
   (IDUSU, IDINFORME, ORDEN, CAMPOS)
 Values
   ('prueba', 'notificacion', 'CODPUENOTIF ASC,ANYONOTIF DESC,NUMNOTIF DESC', 'anyonotif,DESTIPNOTIF,NOMUSUARIO,numnotif,codusuario,imptotal,secpronotif');
Insert into GU_USUAPLI_CONFIG
   (IDUSU, IDINFORME, ORDEN, CAMPOS)
 Values
   ('prueba', 'ocupsupbuque', 'ANYO DESC', 'nompue,anyo,codser,numescala,codestadia,fecini,fecfin,finalizado,FECULTLIQ');
COMMIT;
