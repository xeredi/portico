SET DEFINE OFF;
Insert into GU_USUAPLI_FILTRO
   (IDFILTRO, IDUSR, IDINFORME, IDUSUFILTRO, WHEFILTRO, WHEESP)
 Values
   (18, 'prueba', 'tramo', 'servicio 95', 'LOWER(TRIM(anyo)) = 2015 AND  translate(LOWER(TRIM(numescala)),''��������������'',''AEIOUEOaeioueo'') like  translate(''%00003%'',''��������������'',''AEIOUEOaeioueo'') AND  translate(LOWER(TRIM(tipodeclaracion)),''��������������'',''AEIOUEOaeioueo'') like  translate(''%d%'',''��������������'',''AEIOUEOaeioueo'')', 
    'A�o = 2015 Y N� Escala Contenga 00003 Y Tipo manifiesto Contenga D');
Insert into GU_USUAPLI_FILTRO
   (IDFILTRO, IDUSR, IDINFORME, IDUSUFILTRO, WHEFILTRO, WHEESP)
 Values
   (2, 'prueba', 'lqborrador', 'Pendiente facturar 2013', 'LOWER(TRIM(anyo)) = 2013 AND  translate(LOWER(TRIM(descestado)),''��������������'',''AEIOUEOaeioueo'') like  translate(''%ini%'',''��������������'',''AEIOUEOaeioueo'')', 
    'A�o = 2013 Y Estado Contenga Ini');
Insert into GU_USUAPLI_FILTRO
   (IDFILTRO, IDUSR, IDINFORME, IDUSUFILTRO, WHEFILTRO, WHEESP)
 Values
   (1, 'prueba', 'lqborrador', 'Pendiente facturar 2014', 'LOWER(TRIM(anyo)) = 2014 AND  translate(LOWER(TRIM(descestado)),''��������������'',''AEIOUEOaeioueo'') like  translate(''%ini%'',''��������������'',''AEIOUEOaeioueo'')', 
    'A�o = 2014 Y Estado Contenga Ini');
Insert into GU_USUAPLI_FILTRO
   (IDFILTRO, IDUSR, IDINFORME, IDUSUFILTRO, WHEFILTRO, WHEESP)
 Values
   (12, 'prueba', 'edimensaje', 'APERAKS ACEPTACi�N', 'LOWER(TRIM(idtipomensaje)) = 2 AND  translate(LOWER(TRIM(tipodocumento)),''��������������'',''AEIOUEOaeioueo'') like  translate(''%962%'',''��������������'',''AEIOUEOaeioueo'') AND  translate(LOWER(TRIM(numfuncion)),''��������������'',''AEIOUEOaeioueo'') like  translate(''%30%'',''��������������'',''AEIOUEOaeioueo'')', 
    'Id tipo Mensaje = 2 Y Tipo Documento Contenga 962 Y Funci�n Contenga 30');
Insert into GU_USUAPLI_FILTRO
   (IDFILTRO, IDUSR, IDINFORME, IDUSUFILTRO, WHEFILTRO, WHEESP)
 Values
   (6, 'prueba', 'cliente', 'Filtro Jorge', '(INDBAJA=''0'' OR INDBAJA IS NULL) AND LOWER(TRIM(codusuario)) = 4216', 
    'Clientes Activos Y C�digo interno = 4216');
Insert into GU_USUAPLI_FILTRO
   (IDFILTRO, IDUSR, IDINFORME, IDUSUFILTRO, WHEFILTRO, WHEESP)
 Values
   (9, 'prueba', 'edimensaje', 'Altas de Berman', 'LOWER(TRIM(idtipomensaje)) = 1 AND  translate(LOWER(TRIM(numfuncion)),''��������������'',''AEIOUEOaeioueo'') like  translate(''%47%'',''��������������'',''AEIOUEOaeioueo'')', 
    'Id tipo Mensaje = 1 Y Funci�n Contenga 47');
Insert into GU_USUAPLI_FILTRO
   (IDFILTRO, IDUSR, IDINFORME, IDUSUFILTRO, WHEFILTRO, WHEESP)
 Values
   (5, 'prueba', 'edimensaje', '>28/01/2015 y con error', 'TRUNC(FECREGISTRO)  >= TO_DATE(''28/01/2015 '', ''DD/MM/YYYY'') AND  translate(LOWER(TRIM(desestado)),''��������������'',''AEIOUEOaeioueo'') like  translate(''%error%'',''��������������'',''AEIOUEOaeioueo'')', 
    'Fecha Registro >= 28/01/2015 Y Estado Contenga Error');
Insert into GU_USUAPLI_FILTRO
   (IDFILTRO, IDUSR, IDINFORME, IDUSUFILTRO, WHEFILTRO, WHEESP)
 Values
   (10, 'prueba', 'edimensaje', 'BERMAN', 'LOWER(TRIM(idtipomensaje)) = 1', 
    'Id tipo Mensaje = 1');
Insert into GU_USUAPLI_FILTRO
   (IDFILTRO, IDUSR, IDINFORME, IDUSUFILTRO, WHEFILTRO, WHEESP)
 Values
   (16, 'prueba', 'edimensaje', 'Mensajes con auditoria', 'LOWER(TRIM(idmensaje)) = 1249 OR LOWER(TRIM(idtipomensaje)) = 8', 
    'Id Mensaje = 1249 O Id tipo Mensaje = 8');
Insert into GU_USUAPLI_FILTRO
   (IDFILTRO, IDUSR, IDINFORME, IDUSUFILTRO, WHEFILTRO, WHEESP)
 Values
   (11, 'prueba', 'edimensaje', 'APERAKS RECHAZO', 'LOWER(TRIM(idtipomensaje)) = 2 AND  translate(LOWER(TRIM(tipodocumento)),''��������������'',''AEIOUEOaeioueo'') like  translate(''%963%'',''��������������'',''AEIOUEOaeioueo'') AND  translate(LOWER(TRIM(numfuncion)),''��������������'',''AEIOUEOaeioueo'') like  translate(''%27%'',''��������������'',''AEIOUEOaeioueo'')', 
    'Id tipo Mensaje = 2 Y Tipo Documento Contenga 963 Y Funci�n Contenga 27');
Insert into GU_USUAPLI_FILTRO
   (IDFILTRO, IDUSR, IDINFORME, IDUSUFILTRO, WHEFILTRO, WHEESP)
 Values
   (7, 'prueba', 'edimensaje', 'Mensajes No revisados', ' translate(LOWER(TRIM(revisado)),''��������������'',''AEIOUEOaeioueo'') =  translate(''no'',''��������������'',''AEIOUEOaeioueo'')', 
    'Revisado = No');
Insert into GU_USUAPLI_FILTRO
   (IDFILTRO, IDUSR, IDINFORME, IDUSUFILTRO, WHEFILTRO, WHEESP)
 Values
   (8, 'prueba', 'edimensaje', 'Mensajes Si revisados', ' translate(LOWER(TRIM(revisado)),''��������������'',''AEIOUEOaeioueo'') =  translate(''si'',''��������������'',''AEIOUEOaeioueo'')', 
    'Revisado = Si');
Insert into GU_USUAPLI_FILTRO
   (IDFILTRO, IDUSR, IDINFORME, IDUSUFILTRO, WHEFILTRO, WHEESP)
 Values
   (15, 'prueba', 'b4buquepesquero', 'B0 Manual No y Base', ' translate(LOWER(TRIM(b0manual)),''��������������'',''AEIOUEOaeioueo'') like  translate(''%n%'',''��������������'',''AEIOUEOaeioueo'') AND  translate(LOWER(TRIM(base)),''��������������'',''AEIOUEOaeioueo'') like  translate(''%si%'',''��������������'',''AEIOUEOaeioueo'')', 
    'Aplica B0 manual Contenga N Y Base Contenga Si');
Insert into GU_USUAPLI_FILTRO
   (IDFILTRO, IDUSR, IDINFORME, IDUSUFILTRO, WHEFILTRO, WHEESP)
 Values
   (19, 'prueba', 'declaracionesmanifiestos', 'sumaria escala 00003 del 2015', 'LOWER(TRIM(codser)) = 54 AND  translate(LOWER(TRIM(tipodeclaracion)),''��������������'',''AEIOUEOaeioueo'') like  translate(''%d%'',''��������������'',''AEIOUEOaeioueo'') AND LOWER(TRIM(anyo)) = 2015', 
    'C�d. Servicio = 54 Y Tipo Manifiesto Contenga D Y A�o = 2015');
COMMIT;
