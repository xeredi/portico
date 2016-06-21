SET DEFINE OFF;
Insert into GLOBAL_FILTRO
   (IDFILTRO, IDINFORME, LABELFILTRO, WHEREFILTRO, INFFILTRO, PORDEFECTO)
 Values
   (55, 'lqaspecto', 'filtro.aspultimavigencia', 'ULTIMA=''1''', 'Aspectos vigentes', 
    'S');
Insert into GLOBAL_FILTRO
   (IDFILTRO, IDINFORME, LABELFILTRO, WHEREFILTRO, INFFILTRO, PORDEFECTO)
 Values
   (1, 'escala', 'filtroescala.anyoactual', 'ANYO=extract (year from sysdate)', 'Escalas del año actual', 
    'S');
Insert into GLOBAL_FILTRO
   (IDFILTRO, IDINFORME, LABELFILTRO, WHEREFILTRO, INFFILTRO, PORDEFECTO)
 Values
   (29, 'cliente', 'filtrocliente.activos', '(INDBAJA=''0'' OR INDBAJA IS NULL)', 'Clientes Activos', 
    'S');
Insert into GLOBAL_FILTRO
   (IDFILTRO, IDINFORME, LABELFILTRO, WHEREFILTRO, INFFILTRO, PORDEFECTO)
 Values
   (35, 'operaciondueglobal', 'filtrooperaciondueglobal.anyoactual', 'ANYO=extract (year from sysdate)', 'Operaciones del año actual', 
    'S');
Insert into GLOBAL_FILTRO
   (IDFILTRO, IDINFORME, LABELFILTRO, WHEREFILTRO, INFFILTRO, PORDEFECTO)
 Values
   (5, 'servmaritbuque', 'filtroservmarit.asociadosactualmente', '(TRUNC(SYSDATE) BETWEEN FECINICIO AND FECFIN)', 'buques asociados a dia de hoy', 
    'N');
Insert into GLOBAL_FILTRO
   (IDFILTRO, IDINFORME, LABELFILTRO, WHEREFILTRO, INFFILTRO, PORDEFECTO)
 Values
   (6, 'shengen', 'filtroshengen.asociadosactualmente', '(TRUNC(SYSDATE) BETWEEN FECINICIO AND FECFIN)', 'paises asociados a dia de hoy', 
    'S');
Insert into GLOBAL_FILTRO
   (IDFILTRO, IDINFORME, LABELFILTRO, WHEREFILTRO, INFFILTRO, PORDEFECTO)
 Values
   (8, 'tmcd', 'filtrotmcd.asociadosactualmente', '(TRUNC(SYSDATE) BETWEEN FECINICIO AND FECFIN)', 'paises asociados a dia de hoy', 
    'S');
Insert into GLOBAL_FILTRO
   (IDFILTRO, IDINFORME, LABELFILTRO, WHEREFILTRO, INFFILTRO, PORDEFECTO)
 Values
   (30, 'equipamientoGlobal', 'filtroequipamientoglobal.anyoactual', 'ANYO=extract (year from sysdate)', 'Equipamientos del año actual', 
    'S');
Insert into GLOBAL_FILTRO
   (IDFILTRO, IDINFORME, LABELFILTRO, WHEREFILTRO, INFFILTRO, PORDEFECTO)
 Values
   (31, 'partidaGlobal', 'filtropartidaglobal.anyoactual', 'ANYO=extract (year from sysdate)', 'Partidas del año actual', 
    'S');
Insert into GLOBAL_FILTRO
   (IDFILTRO, IDINFORME, LABELFILTRO, WHEREFILTRO, INFFILTRO, PORDEFECTO)
 Values
   (33, 'operacionglobal', 'filtrooperacionglobal.anyoactual', 'ANYO=extract (year from sysdate)', 'Operaciones del año actual', 
    'S');
Insert into GLOBAL_FILTRO
   (IDFILTRO, IDINFORME, LABELFILTRO, WHEREFILTRO, INFFILTRO, PORDEFECTO)
 Values
   (36, 'escalatrafint', 'filtroescala.anyoactual', 'ANYO=extract (year from sysdate)', 'Escalas del año actual', 
    'S');
Insert into GLOBAL_FILTRO
   (IDFILTRO, IDINFORME, LABELFILTRO, WHEREFILTRO, INFFILTRO, PORDEFECTO)
 Values
   (37, 'estadiatrafintglobal', 'filtroestadia.anyoactual', 'ANYO=extract (year from sysdate)', 'Estadias año actual', 
    'S');
Insert into GLOBAL_FILTRO
   (IDFILTRO, IDINFORME, LABELFILTRO, WHEREFILTRO, INFFILTRO, PORDEFECTO)
 Values
   (38, 'borradorlineasglobal', 'filtrolineasbor.anyoactual', 'ANYO=extract (year from sysdate)', 'Líneas borrador año actual', 
    'S');
Insert into GLOBAL_FILTRO
   (IDFILTRO, IDINFORME, LABELFILTRO, WHEREFILTRO, INFFILTRO, PORDEFECTO)
 Values
   (39, 'escalaAvisoocupcrucero', 'filtroAvisocrucero.pendiente', 'INDCERRADO=''0''', 'Avisos ocupación cruceros sin cerrar', 
    'S');
Insert into GLOBAL_FILTRO
   (IDFILTRO, IDINFORME, LABELFILTRO, WHEREFILTRO, INFFILTRO, PORDEFECTO)
 Values
   (63, 'lqcambioservvalorado', 'filtrolqcambioservvalorado.notramitados', 'INDTRAMITADO=''0''', 'Modificaciones de periodos valorados no tramitados', 
    'S');
Insert into GLOBAL_FILTRO
   (IDFILTRO, IDINFORME, LABELFILTRO, WHEREFILTRO, INFFILTRO, PORDEFECTO)
 Values
   (41, 'mencoarri', 'filtroMencoarri.activos', 'INDBAJA=''0''', 'Activos', 
    'S');
Insert into GLOBAL_FILTRO
   (IDFILTRO, IDINFORME, LABELFILTRO, WHEREFILTRO, INFFILTRO, PORDEFECTO)
 Values
   (44, 'marinaatraque', 'filtromarinaatraque.2anyoantes', 'extract (year from FECINICIO) in (extract (year from sysdate)-1,extract (year from sysdate)-2)', 'Atraques de 2 años anterioes', 
    'N');
Insert into GLOBAL_FILTRO
   (IDFILTRO, IDINFORME, LABELFILTRO, WHEREFILTRO, INFFILTRO, PORDEFECTO)
 Values
   (45, 'novedadrodante', 'filtronovedadrodante.activas', 'INDBAJA=''0''', 'Novedades rodantes activas', 
    'S');
Insert into GLOBAL_FILTRO
   (IDFILTRO, IDINFORME, LABELFILTRO, WHEREFILTRO, INFFILTRO, PORDEFECTO)
 Values
   (9, 'lqcuantiabasica', 'filtrolqcuantiabasica.vigentesactualmente', '((TRUNC(SYSDATE) BETWEEN FECINIVIG AND FECFINVIG) OR (TRUNC(SYSDATE)>= FECINIVIG AND FECFINVIG IS NULL))', 'cuantías vigentes a dia de hoy', 
    'S');
Insert into GLOBAL_FILTRO
   (IDFILTRO, IDINFORME, LABELFILTRO, WHEREFILTRO, INFFILTRO, PORDEFECTO)
 Values
   (12, 'lqcoefservicio', 'filtrolqcoefservicio.vigentesactualmente', '((TRUNC(SYSDATE) BETWEEN FECINIVIG AND FECFINVIG) OR (TRUNC(SYSDATE)>= FECINIVIG AND FECFINVIG IS NULL))', 'coeficientes servicios vigentes a dia de hoy', 
    'S');
Insert into GLOBAL_FILTRO
   (IDFILTRO, IDINFORME, LABELFILTRO, WHEREFILTRO, INFFILTRO, PORDEFECTO)
 Values
   (26, 'estadiaglobal', 'filtroestadia.anyoactual', 'ANYO=extract (year from sysdate)', 'Estadias año actual', 
    'S');
Insert into GLOBAL_FILTRO
   (IDFILTRO, IDINFORME, LABELFILTRO, WHEREFILTRO, INFFILTRO, PORDEFECTO)
 Values
   (42, 'marinaatraque', 'filtromarinaatraque.anyoactual', 'extract (year from FECINICIO)=extract (year from sysdate)', 'Atraques del año actual', 
    'N');
Insert into GLOBAL_FILTRO
   (IDFILTRO, IDINFORME, LABELFILTRO, WHEREFILTRO, INFFILTRO, PORDEFECTO)
 Values
   (27, 'buquecertglobal', 'filtrobuquecertglobal.vigentesactualmente', '((TRUNC(SYSDATE) BETWEEN FECINICIO AND FECFIN) OR (TRUNC(SYSDATE)>= FECINICIO AND FECFIN IS NULL))', 'certificados vigentes a dia de hoy', 
    'N');
Insert into GLOBAL_FILTRO
   (IDFILTRO, IDINFORME, LABELFILTRO, WHEREFILTRO, INFFILTRO, PORDEFECTO)
 Values
   (28, 'buquecert', 'filtrobuquecert.vigentesactualmente', '((TRUNC(SYSDATE) BETWEEN FECINICIO AND FECFIN) OR (TRUNC(SYSDATE)>= FECINICIO AND FECFIN IS NULL))', 'certificados vigentes a dia de hoy', 
    'N');
Insert into GLOBAL_FILTRO
   (IDFILTRO, IDINFORME, LABELFILTRO, WHEREFILTRO, INFFILTRO, PORDEFECTO)
 Values
   (47, 'dpexpcontadoragua', 'filtrodpexpcontadoragua.sincontador', '(CODPUECONTADOR IS NULL AND CODCONTADOR IS NULL)', 'Expedientes sin contador asociado', 
    'N');
Insert into GLOBAL_FILTRO
   (IDFILTRO, IDINFORME, LABELFILTRO, WHEREFILTRO, INFFILTRO, PORDEFECTO)
 Values
   (11, 'servmaritnav', 'filtroservmarit.asociadosactualmente', '(TRUNC(SYSDATE) BETWEEN FECINICIO AND FECFIN)', 'Navieras asociadas a dia de hoy', 
    'S');
Insert into GLOBAL_FILTRO
   (IDFILTRO, IDINFORME, LABELFILTRO, WHEREFILTRO, INFFILTRO, PORDEFECTO)
 Values
   (2, 'declaracionesmanifiestos', 'filtrodeclaracionesmanifiestos.anyoactual', 'ANYO=extract (year from sysdate)', 'Declaraciones/Manifiestos del año actual', 
    'S');
Insert into GLOBAL_FILTRO
   (IDFILTRO, IDINFORME, LABELFILTRO, WHEREFILTRO, INFFILTRO, PORDEFECTO)
 Values
   (4, 'escalaContrastebuque', 'filtroContrastebuque.pendientetramitar', 'CODESTADO=''PV''', 'Contraste de buques pendientes de tratar', 
    'S');
Insert into GLOBAL_FILTRO
   (IDFILTRO, IDINFORME, LABELFILTRO, WHEREFILTRO, INFFILTRO, PORDEFECTO)
 Values
   (3, 'tramo', 'filtrotramo.anyoactual', 'ANYO=extract (year from sysdate)', 'Tramos del año actual', 
    'S');
Insert into GLOBAL_FILTRO
   (IDFILTRO, IDINFORME, LABELFILTRO, WHEREFILTRO, INFFILTRO, PORDEFECTO)
 Values
   (7, 'servmaritpuerto', 'filtroservmarit.asociadosactualmente', '(TRUNC(SYSDATE) BETWEEN FECINICIO AND FECFIN)', 'puertos asociados a dia de hoy', 
    'N');
Insert into GLOBAL_FILTRO
   (IDFILTRO, IDINFORME, LABELFILTRO, WHEREFILTRO, INFFILTRO, PORDEFECTO)
 Values
   (10, 'lqcoefpuerto', 'filtrolqcoefpuerto.vigentesactualmente', '((TRUNC(SYSDATE) BETWEEN FECINIVIG AND FECFINVIG) OR (TRUNC(SYSDATE)>= FECINIVIG AND FECFINVIG IS NULL))', 'coeficientes puertos vigentes a dia de hoy', 
    'S');
Insert into GLOBAL_FILTRO
   (IDFILTRO, IDINFORME, LABELFILTRO, WHEREFILTRO, INFFILTRO, PORDEFECTO)
 Values
   (13, 'escala', 'filtroescala.liquidablesT1', '(CODESTADO IN(''IN'',''FI'',''LD'') AND INDLIQT1=''0'')', 'Escalas liquidables T1', 
    'N');
Insert into GLOBAL_FILTRO
   (IDFILTRO, IDINFORME, LABELFILTRO, WHEREFILTRO, INFFILTRO, PORDEFECTO)
 Values
   (14, 'escala', 'filtroescala.liquidablesT0', '(CODESTADO IN(''IN'',''FI'',''LD'') AND INDLIQT0=''0'' AND INDEXENTOT0=''0'')', 'Escalas liquidables T0', 
    'N');
Insert into GLOBAL_FILTRO
   (IDFILTRO, IDINFORME, LABELFILTRO, WHEREFILTRO, INFFILTRO, PORDEFECTO)
 Values
   (15, 'escala', 'filtroescala.liquidablesT7', '(CODESTADO IN(''IN'',''FI'',''LD'') AND INDLIQT7=''0'' AND INDNOLIQUIDABLE=''0'')', 'Escalas liquidables T7', 
    'N');
Insert into GLOBAL_FILTRO
   (IDFILTRO, IDINFORME, LABELFILTRO, WHEREFILTRO, INFFILTRO, PORDEFECTO)
 Values
   (46, 'alertaaeborrador', 'filtroalertaaeborrador.pendientes', 'ESTADO=''PE''', 'Alertas pendientes', 
    'S');
Insert into GLOBAL_FILTRO
   (IDFILTRO, IDINFORME, LABELFILTRO, WHEREFILTRO, INFFILTRO, PORDEFECTO)
 Values
   (59, 'estparamfptipobulto', 'filtroestparamfptipobulto.vigentesactualmente', '((TRUNC(SYSDATE) BETWEEN FECINIVIG AND FECFINVIG) OR (TRUNC(SYSDATE)>= FECINIVIG AND FECFINVIG IS NULL))', 'Vigentes a dia de hoy', 
    'S');
Insert into GLOBAL_FILTRO
   (IDFILTRO, IDINFORME, LABELFILTRO, WHEREFILTRO, INFFILTRO, PORDEFECTO)
 Values
   (48, 'mbonificacion', 'filtrombonificacion.vigentes', '((TRUNC(SYSDATE) BETWEEN FECINIVIG AND FECFINVIG) OR (TRUNC(SYSDATE)>= FECINIVIG AND FECFINVIG IS NULL))', 'Bonificaciones vigentes a dia de hoy', 
    'S');
Insert into GLOBAL_FILTRO
   (IDFILTRO, IDINFORME, LABELFILTRO, WHEREFILTRO, INFFILTRO, PORDEFECTO)
 Values
   (49, 'textos_bor', 'filtrolqtextosbor.vigentesactualmente', '((TRUNC(SYSDATE) BETWEEN FECINIVIG AND FECFINVIG) OR (TRUNC(SYSDATE)>= FECINIVIG AND FECFINVIG IS NULL))', 'Textos borrador vigentes a dia de hoy', 
    'S');
Insert into GLOBAL_FILTRO
   (IDFILTRO, IDINFORME, LABELFILTRO, WHEREFILTRO, INFFILTRO, PORDEFECTO)
 Values
   (51, 'lqborrador', 'filtro.anyoactual', 'EXTRACT (YEAR FROM SYSDATE)=ANYOEST', 'Borradores del año actual', 
    'S');
Insert into GLOBAL_FILTRO
   (IDFILTRO, IDINFORME, LABELFILTRO, WHEREFILTRO, INFFILTRO, PORDEFECTO)
 Values
   (52, 'lqborrador', 'filtro.anyoactualyanterior', '(ANYOEST BETWEEN (EXTRACT (YEAR FROM SYSDATE)-1) AND EXTRACT (YEAR FROM SYSDATE))', 'Borradores del año actual y anterior', 
    'N');
Insert into GLOBAL_FILTRO
   (IDFILTRO, IDINFORME, LABELFILTRO, WHEREFILTRO, INFFILTRO, PORDEFECTO)
 Values
   (56, 'lqparamequipt3', 'filtrolqparamequipt3.vigentesactualmente', '((TRUNC(SYSDATE) BETWEEN FECINIVIG AND FECFINVIG) OR (TRUNC(SYSDATE)>= FECINIVIG AND FECFINVIG IS NULL))', 'Vigentes a dia de hoy', 
    'S');
Insert into GLOBAL_FILTRO
   (IDFILTRO, IDINFORME, LABELFILTRO, WHEREFILTRO, INFFILTRO, PORDEFECTO)
 Values
   (57, 'lqparamcodaran2453', 'filtrolqparamcodaran2453.vigentesactualmente', '((TRUNC(SYSDATE) BETWEEN FECINIVIG AND FECFINVIG) OR (TRUNC(SYSDATE)>= FECINIVIG AND FECFINVIG IS NULL))', 'Vigentes a dia de hoy', 
    'S');
Insert into GLOBAL_FILTRO
   (IDFILTRO, IDINFORME, LABELFILTRO, WHEREFILTRO, INFFILTRO, PORDEFECTO)
 Values
   (58, 'lqparamvehict3', 'filtrolqparamvehict3.vigentesactualmente', '((TRUNC(SYSDATE) BETWEEN FECINIVIG AND FECFINVIG) OR (TRUNC(SYSDATE)>= FECINIVIG AND FECFINVIG IS NULL))', 'Vigentes a dia de hoy', 
    'S');
Insert into GLOBAL_FILTRO
   (IDFILTRO, IDINFORME, LABELFILTRO, WHEREFILTRO, INFFILTRO, PORDEFECTO)
 Values
   (50, 'mpaisue', 'filtropaisue.asociadosactualmente', '(TRUNC(SYSDATE) BETWEEN FECINICIO AND FECFIN)', 'países unión europea asociados a dia de hoy', 
    'S');
Insert into GLOBAL_FILTRO
   (IDFILTRO, IDINFORME, LABELFILTRO, WHEREFILTRO, INFFILTRO, PORDEFECTO)
 Values
   (53, 'lqborrador_filtro', 'filtro.anyoactualyanterior', '(ANYOEST BETWEEN (EXTRACT (YEAR FROM SYSDATE)-1) AND EXTRACT (YEAR FROM SYSDATE))', 'Borradores del año actual y anterior', 
    'N');
Insert into GLOBAL_FILTRO
   (IDFILTRO, IDINFORME, LABELFILTRO, WHEREFILTRO, INFFILTRO, PORDEFECTO)
 Values
   (54, 'lqborrador_filtro', 'filtro.anyoactual', 'EXTRACT (YEAR FROM SYSDATE)=ANYOEST', 'Borradores del año actual', 
    'S');
Insert into GLOBAL_FILTRO
   (IDFILTRO, IDINFORME, LABELFILTRO, WHEREFILTRO, INFFILTRO, PORDEFECTO)
 Values
   (60, 'estparamtucaeqnocn', 'filtroestparamtucaeqnocn.vigentesactualmente', '((TRUNC(SYSDATE) BETWEEN FECINIVIG AND FECFINVIG) OR (TRUNC(SYSDATE)>= FECINIVIG AND FECFINVIG IS NULL))', 'Vigentes a dia de hoy', 
    'S');
Insert into GLOBAL_FILTRO
   (IDFILTRO, IDINFORME, LABELFILTRO, WHEREFILTRO, INFFILTRO, PORDEFECTO)
 Values
   (64, 'lqcambioservvaloradoocupacion', 'filtrolqcambioservvalorado.notramitados', 'INDTRAMITADO=''0''', 'Modificaciones de periodos valorados no tramitados', 
    'S');
Insert into GLOBAL_FILTRO
   (IDFILTRO, IDINFORME, LABELFILTRO, WHEREFILTRO, INFFILTRO, PORDEFECTO)
 Values
   (71, 'estparamutieq', 'filtroestparamutieq.vigentesactualmente', '((TRUNC(SYSDATE) BETWEEN FECINIVIG AND FECFINVIG) OR (TRUNC(SYSDATE)>= FECINIVIG AND FECFINVIG IS NULL))', 'Vigentes a dia de hoy', 
    'S');
Insert into GLOBAL_FILTRO
   (IDFILTRO, IDINFORME, LABELFILTRO, WHEREFILTRO, INFFILTRO, PORDEFECTO)
 Values
   (67, 'mbuquebonif', 'filtrombuquebonif.vigentesactualmente', '((TRUNC(SYSDATE) BETWEEN FECINICIO AND FECFIN) OR (TRUNC(SYSDATE)>= FECINICIO AND FECFIN IS NULL))', 'bonificaciones vigentes a dia de hoy', 
    'N');
Insert into GLOBAL_FILTRO
   (IDFILTRO, IDINFORME, LABELFILTRO, WHEREFILTRO, INFFILTRO, PORDEFECTO)
 Values
   (68, 'mbuquebonifglobal', 'filtrombuquebonifglobal.vigentesactualmente', '((TRUNC(SYSDATE) BETWEEN FECINICIO AND FECFIN) OR (TRUNC(SYSDATE)>= FECINICIO AND FECFIN IS NULL))', 'bonificaciones vigentes a dia de hoy', 
    'N');
Insert into GLOBAL_FILTRO
   (IDFILTRO, IDINFORME, LABELFILTRO, WHEREFILTRO, INFFILTRO, PORDEFECTO)
 Values
   (69, 'mmuellebonif', 'filtrommuellebonif.vigentesactualmente', '((TRUNC(SYSDATE) BETWEEN FECINICIO AND FECFIN) OR (TRUNC(SYSDATE)>= FECINICIO AND FECFIN IS NULL))', 'bonificaciones vigentes a dia de hoy', 
    'N');
Insert into GLOBAL_FILTRO
   (IDFILTRO, IDINFORME, LABELFILTRO, WHEREFILTRO, INFFILTRO, PORDEFECTO)
 Values
   (70, 'mmuellebonifglobal', 'filtrommuellebonifglobal.vigentesactualmente', '((TRUNC(SYSDATE) BETWEEN FECINICIO AND FECFIN) OR (TRUNC(SYSDATE)>= FECINICIO AND FECFIN IS NULL))', 'bonificaciones vigentes a dia de hoy', 
    'N');
Insert into GLOBAL_FILTRO
   (IDFILTRO, IDINFORME, LABELFILTRO, WHEREFILTRO, INFFILTRO, PORDEFECTO)
 Values
   (74, 'estparamfptuca', 'filtroestparamfptuca.vigentesactualmente', '((TRUNC(SYSDATE) BETWEEN FECINIVIG AND FECFINVIG) OR (TRUNC(SYSDATE)>= FECINIVIG AND FECFINVIG IS NULL))', 'Vigentes a dia de hoy', 
    'S');
Insert into GLOBAL_FILTRO
   (IDFILTRO, IDINFORME, LABELFILTRO, WHEREFILTRO, INFFILTRO, PORDEFECTO)
 Values
   (65, 'mercancia', 'filtromercancia.vigentesactualmente', '((TRUNC(SYSDATE) BETWEEN FECINIVIG AND FECFINVIG) OR (TRUNC(SYSDATE)>= FECINIVIG AND FECFINVIG IS NULL))', 'Códigos arancelarios vigentes a día de hoy', 
    'S');
Insert into GLOBAL_FILTRO
   (IDFILTRO, IDINFORME, LABELFILTRO, WHEREFILTRO, INFFILTRO, PORDEFECTO)
 Values
   (66, 'lqbaremoap', 'filtrolqbaremoap.vigentesactualmente', '((TRUNC(SYSDATE) BETWEEN FECINIVIG AND FECFINVIG) OR (TRUNC(SYSDATE)>= FECINIVIG AND FECFINVIG IS NULL))', 'baremos vigentes a dia de hoy', 
    'S');
Insert into GLOBAL_FILTRO
   (IDFILTRO, IDINFORME, LABELFILTRO, WHEREFILTRO, INFFILTRO, PORDEFECTO)
 Values
   (61, 'sanparte', 'filtrosanparte.anyoactual', 'ANYO=extract (year from sysdate)', 'Partes del año actual', 
    'S');
Insert into GLOBAL_FILTRO
   (IDFILTRO, IDINFORME, LABELFILTRO, WHEREFILTRO, INFFILTRO, PORDEFECTO)
 Values
   (62, 'sanexpediente', 'filtrosanexpediente.anyoactual', 'ANYO=extract (year from sysdate)', 'Expedientes del año actual', 
    'S');
Insert into GLOBAL_FILTRO
   (IDFILTRO, IDINFORME, LABELFILTRO, WHEREFILTRO, INFFILTRO, PORDEFECTO)
 Values
   (72, 'tipobuquebonif', 'filtrotipobuquebonif.vigentesactualmente', '((TRUNC(SYSDATE) BETWEEN FECINICIO AND FECFIN) OR (TRUNC(SYSDATE)>= FECINICIO AND FECFIN IS NULL))', 'bonificaciones vigentes a dia de hoy', 
    'N');
Insert into GLOBAL_FILTRO
   (IDFILTRO, IDINFORME, LABELFILTRO, WHEREFILTRO, INFFILTRO, PORDEFECTO)
 Values
   (73, 'tipobuquebonifglobal', 'filtrombuquebonifglobal.vigentesactualmente', '((TRUNC(SYSDATE) BETWEEN FECINICIO AND FECFIN) OR (TRUNC(SYSDATE)>= FECINICIO AND FECFIN IS NULL))', 'bonificaciones vigentes a dia de hoy', 
    'N');
Insert into GLOBAL_FILTRO
   (IDFILTRO, IDINFORME, LABELFILTRO, WHEREFILTRO, INFFILTRO, PORDEFECTO)
 Values
   (83, 'cenempresa', 'filtroempresa.sinfiltro', '1=1', 'Filtro para las empresas censadas', 
    'S');
Insert into GLOBAL_FILTRO
   (IDFILTRO, IDINFORME, LABELFILTRO, WHEREFILTRO, INFFILTRO, PORDEFECTO)
 Values
   (86, 'tramo', 'filtrotramo.liquidablesT2', '(INDEXENTOT2=''0'' AND INDLIQT2=''0'')', 'liquidables B2', 
    'N');
Insert into GLOBAL_FILTRO
   (IDFILTRO, IDINFORME, LABELFILTRO, WHEREFILTRO, INFFILTRO, PORDEFECTO)
 Values
   (87, 'tramo', 'filtrotramo.liquidablesT3', '(INDEXENTOT3=''0'' AND INDLIQT3=''0'')', 'liquidables B3', 
    'N');
Insert into GLOBAL_FILTRO
   (IDFILTRO, IDINFORME, LABELFILTRO, WHEREFILTRO, INFFILTRO, PORDEFECTO)
 Values
   (91, 'diversogenerico', 'filtrodiversogenerico.liquidables', '(INDEXENTOLIQ=''0'' AND INDLIQUIDADO=''0'')', 'liquidables', 
    'N');
Insert into GLOBAL_FILTRO
   (IDFILTRO, IDINFORME, LABELFILTRO, WHEREFILTRO, INFFILTRO, PORDEFECTO)
 Values
   (92, 't2excursionista', 'filtrot2excursionista.liquidables', '(INDEXENTOLIQ=''0'' AND INDLIQ=''0'')', 'liquidables', 
    'N');
Insert into GLOBAL_FILTRO
   (IDFILTRO, IDINFORME, LABELFILTRO, WHEREFILTRO, INFFILTRO, PORDEFECTO)
 Values
   (93, 'g5transito', 'filtrog5transito.liquidablesB0', '(INDEXENTOB0=''0'' AND INDLIQUIDADOB0=''0'')', 'liquidables B0', 
    'N');
Insert into GLOBAL_FILTRO
   (IDFILTRO, IDINFORME, LABELFILTRO, WHEREFILTRO, INFFILTRO, PORDEFECTO)
 Values
   (94, 'g5transito', 'filtrog5transito.liquidablesB5', '(INDEXENTOB5=''0'' AND INDLIQUIDADOB5=''0'')', 'liquidables B5', 
    'N');
Insert into GLOBAL_FILTRO
   (IDFILTRO, IDINFORME, LABELFILTRO, WHEREFILTRO, INFFILTRO, PORDEFECTO)
 Values
   (95, 't3sumintrafint', 'filtrot3sumintrafint.liquidables', '(INDEXENTOLIQ=''0'' AND INDLIQ=''0'')', 'liquidables', 
    'N');
Insert into GLOBAL_FILTRO
   (IDFILTRO, IDINFORME, LABELFILTRO, WHEREFILTRO, INFFILTRO, PORDEFECTO)
 Values
   (96, 'ocupsuprodante', 'filtroocupsuprodante.liquidables', '(INDEXENTOliq=''0'' AND INDLIQUIDADO=''0'')', 'liquidables', 
    'N');
Insert into GLOBAL_FILTRO
   (IDFILTRO, IDINFORME, LABELFILTRO, WHEREFILTRO, INFFILTRO, PORDEFECTO)
 Values
   (98, 'clientepuerto', 'filtroclientepuerto.activos', '(INDBAJA=''0'' OR INDBAJA IS NULL)', 'Clientes Activos', 
    'S');
Insert into GLOBAL_FILTRO
   (IDFILTRO, IDINFORME, LABELFILTRO, WHEREFILTRO, INFFILTRO, PORDEFECTO)
 Values
   (99, 'lqbonificacion', 'filtrolqbonificacion.anyoactual', '(EXTRACT(YEAR FROM FECINISER)=EXTRACT (YEAR FROM SYSDATE))', 'Bonificaciones año actual', 
    'S');
Insert into GLOBAL_FILTRO
   (IDFILTRO, IDINFORME, LABELFILTRO, WHEREFILTRO, INFFILTRO, PORDEFECTO)
 Values
   (100, 'tmservicio', 'filtrotmservicio.liquidablesT8', '(INDEXENTOLIQ=''0'' AND INDLIQUIDADO=''0'')', 'liquidables T8', 
    'N');
Insert into GLOBAL_FILTRO
   (IDFILTRO, IDINFORME, LABELFILTRO, WHEREFILTRO, INFFILTRO, PORDEFECTO)
 Values
   (75, 'dpcanonactiv', 'filtrodpcanonactiv.vigentesactualmente', '(TRUNC(SYSDATE) BETWEEN FECINICIO AND FECFIN)', 'Vigentes a dia de hoy', 
    'N');
Insert into GLOBAL_FILTRO
   (IDFILTRO, IDINFORME, LABELFILTRO, WHEREFILTRO, INFFILTRO, PORDEFECTO)
 Values
   (76, 'dpcanonactivglobal', 'filtrodpcanonactiv.vigentesactualmente', '(TRUNC(SYSDATE) BETWEEN FECINICIO AND FECFIN)', 'Vigentes a dia de hoy', 
    'N');
Insert into GLOBAL_FILTRO
   (IDFILTRO, IDINFORME, LABELFILTRO, WHEREFILTRO, INFFILTRO, PORDEFECTO)
 Values
   (77, 'dpcanonocupacion', 'filtrodpcanonocupacion.vigentesactualmente', '(TRUNC(SYSDATE) BETWEEN FECINICIO AND FECFIN)', 'Vigentes a dia de hoy', 
    'N');
Insert into GLOBAL_FILTRO
   (IDFILTRO, IDINFORME, LABELFILTRO, WHEREFILTRO, INFFILTRO, PORDEFECTO)
 Values
   (78, 'dpcanonocupacionglobal', 'filtrodpcanonocupacion.vigentesactualmente', '(TRUNC(SYSDATE) BETWEEN FECINICIO AND FECFIN)', 'Vigentes a dia de hoy', 
    'N');
Insert into GLOBAL_FILTRO
   (IDFILTRO, IDINFORME, LABELFILTRO, WHEREFILTRO, INFFILTRO, PORDEFECTO)
 Values
   (79, 'dpcifranegocio', 'filtrodpcifranegocio.vigentesactualmente', '(TRUNC(SYSDATE) BETWEEN FECINICIO AND FECFIN)', 'Vigentes a dia de hoy', 
    'N');
Insert into GLOBAL_FILTRO
   (IDFILTRO, IDINFORME, LABELFILTRO, WHEREFILTRO, INFFILTRO, PORDEFECTO)
 Values
   (80, 'dpcifranegocioglobal', 'filtrodpcifranegocio.vigentesactualmente', '(TRUNC(SYSDATE) BETWEEN FECINICIO AND FECFIN)', 'Vigentes a dia de hoy', 
    'N');
Insert into GLOBAL_FILTRO
   (IDFILTRO, IDINFORME, LABELFILTRO, WHEREFILTRO, INFFILTRO, PORDEFECTO)
 Values
   (84, 'cenexpediente', 'filtroexpediente.activos', 'INDBAJA=''0''', 'Filtro para los expedientes activos', 
    'S');
Insert into GLOBAL_FILTRO
   (IDFILTRO, IDINFORME, LABELFILTRO, WHEREFILTRO, INFFILTRO, PORDEFECTO)
 Values
   (85, 'cenexpediente', 'filtroexpediente.sinfiltro', '1=1', 'Ningún filtro', 
    'N');
Insert into GLOBAL_FILTRO
   (IDFILTRO, IDINFORME, LABELFILTRO, WHEREFILTRO, INFFILTRO, PORDEFECTO)
 Values
   (97, 'estadiaglobal', 'filtroestadia.atraqueshoymanyana', '(FECREF BETWEEN TRUNC(SYSDATE) AND TRUNC(SYSDATE) +1)', 'Atraques de hoy y mañana', 
    'N');
Insert into GLOBAL_FILTRO
   (IDFILTRO, IDINFORME, LABELFILTRO, WHEREFILTRO, INFFILTRO, PORDEFECTO)
 Values
   (81, 'lqparamcodarant2', 'filtrolqparamcodarant2.vigentesactualmente', '((TRUNC(SYSDATE) BETWEEN FECINIVIG AND FECFINVIG) OR (TRUNC(SYSDATE)>= FECINIVIG AND FECFINVIG IS NULL))', 'Vigentes a dia de hoy', 
    'S');
Insert into GLOBAL_FILTRO
   (IDFILTRO, IDINFORME, LABELFILTRO, WHEREFILTRO, INFFILTRO, PORDEFECTO)
 Values
   (82, 'cenempresa', 'filtroempresa.censada', 'CENSADA=''1''', 'Filtro para las empresas censadas', 
    'N');
Insert into GLOBAL_FILTRO
   (IDFILTRO, IDINFORME, LABELFILTRO, WHEREFILTRO, INFFILTRO, PORDEFECTO)
 Values
   (88, 'b4manifiesto', 'filtrob4manifiesto.liquidablesT4', '(INDEXENTOLIQB4=''0'' AND INDLIQB4=''0'')', 'liquidables B4', 
    'N');
Insert into GLOBAL_FILTRO
   (IDFILTRO, IDINFORME, LABELFILTRO, WHEREFILTRO, INFFILTRO, PORDEFECTO)
 Values
   (89, 't8suminbuque', 'filtrot8suminbuque.liquidablesT8', '(INDEXENTOLIQ=''0'' AND INDLIQUIDADO=''0'')', 'liquidables T8', 
    'N');
Insert into GLOBAL_FILTRO
   (IDFILTRO, IDINFORME, LABELFILTRO, WHEREFILTRO, INFFILTRO, PORDEFECTO)
 Values
   (90, 't8sumingenerico', 'filtrot8sumingenerico.liquidablesT8', '(INDEXENTOLIQ=''0'' AND INDLIQUIDADO=''0'')', 'liquidables T8', 
    'N');
COMMIT;
