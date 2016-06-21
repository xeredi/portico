SET DEFINE OFF;
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL)
 Values
   (393, 71000, 70000, 'menu.gestiondirecta', '#');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (151, 70100, 71000, 'menu.autbase', 'autbase.do?metodo=obtenerListado&inicio=si''', 
    'VIS_G5EXPGESTDIRECTA');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (301, 100300, 100000, 'menu.t8sumininstfija', 't8sumininstfija.do?metodo=obtenerListado&inicio=si', 
    'VIS_SUMINSTFIJA');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (107, 40500, 40000, 'menu.t2excursionistas', 't2excursionista.do?metodo=obtenerListado&inicio=si', 
    'VIS_T2EXCURSIONISTA');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (108, 100200, 100000, 'menu.t3sumintrafint', 't3sumintrafint.do?metodo=obtenerListado&inicio=si', 
    'VIS_T3SUMINTRAFINT');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (29, 130119, 130000, 'menu.serviciomaritimo', 'serviciomaritimo.do?metodo=obtenerListado&inicio=si', 
    'VIS_SERVMARITIM');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (230, 120303, 120300, 'menu.lqfactura', 'lqfactura.do?metodo=obtenerListado&inicio=si', 
    'VIS_LQFACTURA');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL)
 Values
   (244, 120600, 120000, 'menu.valorador', '#');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL)
 Values
   (248, 10400, 10000, 'menu.estadistica', '#');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (249, 10410, 10400, 'menu.paramestadistica', 'paramestadistica.do?metodo=obtenerListado&inicio=si', 
    'VIS_PARAMESTADISTICA');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (250, 10420, 10400, 'menu.estparamfptipobulto', 'estparamfptipobulto.do?metodo=obtenerListado&inicio=si', 
    'VIS_PARAMESTADISTICA');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (278, 120500, 120000, 'menu.lqcambioservvalorado', 'lqcambioservvalorado.do?metodo=obtenerListado&inicio=si', 
    'VIS_LQPERIODOANULADO');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL)
 Values
   (80, 120200, 120000, 'menu.borradorconfiguracion', '#');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (82, 130121, 130000, 'menu.subtipoactiv', 'subtipoactiv.do?metodo=obtenerListado&inicio=si', 
    'VIS_SUBTIPOACTIV');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL)
 Values
   (186, 80300, 80000, 'menu.tablasmaestras', '#');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (69, 130127, 130000, 'menu.tipobuque', 'tipobuque.do?metodo=obtenerListado&inicio=si', 
    'VIS_TIPO_BUQUE');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (45, 130124, 130000, 'menu.tmcd', 'tmcd.do?metodo=obtenerListado&inicio=si', 
    'VIS_PAIS');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (120, 30600, 30000, 'menu.operaciondueglobal', 'operaciondueglobal.do?metodo=obtenerListado&inicio=si', 
    'VIS_OPEPORTUARIA');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (126, 40300, 40000, 'menu.busquedatramos', 'tramo.do?metodo=generarPantallaBusqueda', 
    'VIS_TC_G3TRAMOS');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (33, 130123, 130000, 'menu.shengen', 'shengen.do?metodo=obtenerListado&inicio=si', 
    'VIS_SHENGEN');
Insert into MENU
   (INDICE, NODO, DESCRIPCION_C, URL, ICONO)
 Values
   (34, 120000, 'menu.facturacion', '#', 'fa fa-eur');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL)
 Values
   (35, 120100, 120000, 'menu.borradores', '#');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (36, 130108, 130000, 'menu.festivos', 'festivo.do?metodo=obtenerListado&inicio=si', 
    'VIS_FESTIVO');
Insert into MENU
   (INDICE, NODO, DESCRIPCION_C, URL, ICONO)
 Values
   (57, 80000, 'menu.ocupsupbuque', '#', 'fa fa-th');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (76, 130126, 130000, 'menu.tipoactividad', 'tipoactivestadia.do?metodo=obtenerListado&inicio=si', 
    'VIS_TIPOACTIV');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (84, 130111, 130000, 'menu.navieras', 'naviera.do?metodo=obtenerListado&inicio=si', 
    'VIS_NAVIERA');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (114, 30500, 30000, 'menu.busquedaestadia', 'estadiaglobal.do?metodo=generarPantallaBusqueda', 
    'VIS_DESACTIVADA');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (103, 80302, 80300, 'menu.zonaocup', 'zonaocup.do?metodo=obtenerListado&inicio=si', 
    'VIS_ZONAOCUP');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (119, 130130, 130000, 'menu.tipoelemrodante', 'tipoelemrodante.do?metodo=obtenerListado&inicio=si', 
    'VIS_TIPOELEMRODANTE');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (122, 130129, 130000, 'menu.tipobuqueoppe', 'tipobuqueoppe.do?metodo=obtenerListado&inicio=si', 
    'VIS_TIPO_BUQUE');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (124, 130131, 130000, 'menu.tipotrafico', 'tipotrafico.do?metodo=obtenerListado&inicio=si', 
    'VIS_TIPOTRAFICO');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (159, 130112, 130000, 'menu.noray', 'noray.do?metodo=obtenerListado&inicio=si', 
    'VIS_MNORAY');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (225, 120903, 120900, 'menu.lqaspecto', 'lqaspecto.do?metodo=obtenerListado&inicio=si', 
    'VIS_LQASPECTO');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (236, 40803, 40800, 'menu.estgruponaturaleza', 'estgruponaturaleza.do?metodo=obtenerListado&inicio=si', 
    'VIS_ESTGRUPONAT');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (237, 40807, 40800, 'menu.estsubgruponaturaleza', 'estsubgruponaturaleza.do?metodo=obtenerListado&inicio=si', 
    'VIS_ESTSUBGRUPONAT');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (224, 120906, 120900, 'menu.mbonificacion', 'mbonificacion.do?metodo=obtenerListado&inicio=si', 
    'VIS_MBONIFICACION');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (238, 40804, 40800, 'menu.esttipomerc43', 'esttipomerc43.do?metodo=obtenerListado&inicio=si', 
    'VIS_ESTTIPOMERC43');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (241, 130132, 130000, 'menu.tipousuario', 'tipousuario.do?metodo=obtenerListado&inicio=si', 
    'VIS_TIPOUSUARIO');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (260, 120700, 120000, 'menu.lqperiodoanulado', 'lqperiodoanuladoglobal.do?metodo=obtenerListado&inicio=si', 
    'VIS_LQPERIODOANULADO');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (50, 120908, 120900, 'menu.cuantiasbasicas', 'lqcuantiabasica.do?metodo=obtenerListado&inicio=si', 
    'VIS_LQCUANTIABASICA');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (52, 120905, 120900, 'menu.coefservicio', 'lqcoefservicio.do?metodo=obtenerListado&inicio=si', 
    'VIS_COEFSERVICIO');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (62, 120103, 120100, 'filtro.tasabuque', 'lqborrador_filtro.do?metodo=obtenerListado&inicio=si&PARAMSFILTROFIJO=IDASPECTOTARIFA IN (''B1'')', 
    'VIS_DESACTIVADA');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (63, 120105, 120100, 'filtro.tasamercancia', 'lqborrador_filtro.do?metodo=obtenerListado&inicio=si&PARAMSFILTROFIJO=IDASPECTOTARIFA IN (''B3'')', 
    'VIS_DESACTIVADA');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (64, 120104, 120100, 'filtro.tasapesaje', 'lqborrador_filtro.do?metodo=obtenerListado&inicio=si&PARAMSFILTROFIJO=IDASPECTOTARIFA IN (''B2'')', 
    'VIS_DESACTIVADA');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (65, 120108, 120100, 'filtro.tasaocupacion', 'lqborrador_filtro.do?metodo=obtenerListado&inicio=si&PARAMSFILTROFIJO=IDASPECTOTARIFA IN (''B6'')', 
    'VIS_DESACTIVADA');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (66, 120102, 120100, 'filtro.tasamaritima', 'lqborrador_filtro.do?metodo=obtenerListado&inicio=si&PARAMSFILTROFIJO=IDASPECTOTARIFA IN (''B0'')', 
    'VIS_DESACTIVADA');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (71, 30400, 30000, 'menu.estadias', 'estadiaglobal.do?metodo=obtenerListado&inicio=si', 
    'VIS_ESTADIA');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (74, 40810, 40800, 'menu.tipotama\F1oequip', 'tipotamequip.do?metodo=obtenerListado&inicio=si', 
    'VIS_TIPOTAMEQUIP');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (86, 130105, 130000, 'menu.buquescertglobal', 'buquecertglobal.do?metodo=obtenerListado&inicio=si', 
    'VIS_BUQUE');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (87, 40809, 40800, 'menu.g3tipoequip', 'g3tipoequip.do?metodo=obtenerListado&inicio=si', 
    'VIS_TIPOEQUIP');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (88, 40808, 40800, 'menu.g3tipobulto', 'g3tipobulto.do?metodo=obtenerListado&inicio=si', 
    'VIS_TIPOBULTO');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (112, 30300, 30000, 'menu.busquedaescalas', 'escala.do?metodo=generarPantallaBusqueda', 
    'VIS_DESACTIVADA');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (164, 120107, 120100, 'filtro.tasaembdeportiva', 'lqborrador_filtro.do?metodo=obtenerListado&inicio=si&PARAMSFILTROFIJO=IDASPECTOTARIFA IN (''B5'')', 
    'VIS_DESACTIVADA');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (245, 120603, 120600, 'menu.lqparamequipt3', 'lqparamequipt3.do?metodo=obtenerListado&inicio=si', 
    'VIS_COEFSERVICIO');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL)
 Values
   (227, 120300, 120000, 'menu.facturacion_sn', '#');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (228, 120302, 120300, 'menu.lqfacturalote', 'lqfacturalote.do?metodo=obtenerListado&inicio=si', 
    'VIS_LQFACTURALOTE');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (240, 120606, 120600, 'menu.paramvalorador', 'paramvalorador.do?metodo=obtenerListado&inicio=si', 
    'VIS_PARAMVAL');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (247, 120605, 120600, 'menu.lqparamvehict3', 'lqparamvehict3.do?metodo=obtenerListado&inicio=si', 
    'VIS_COEFSERVICIO');
Insert into MENU
   (INDICE, NODO, DESCRIPCION_C, URL, ICONO)
 Values
   (1, 10000, 'menu.admin', '#', 'fa fa-group');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (2, 10100, 10000, 'menu.usuarios', 'usuario.do?metodo=obtenerListado&inicio=si', 
    'M_USUARIOS');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (3, 10200, 10000, 'menu.perfiles', 'perfil.do?metodo=obtenerListado&inicio=si', 
    'M_PERFILES');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (4, 10300, 10000, 'menu.funcionalidades', 'funcionalidad.do?metodo=obtenerListado&inicio=si', 
    'M_FUNC');
Insert into MENU
   (INDICE, NODO, DESCRIPCION_C, URL, ICONO)
 Values
   (5, 130000, 'menu.tablasmaestras', '#', 'fa fa-table');
Insert into MENU
   (INDICE, NODO, DESCRIPCION_C, URL, ICONO)
 Values
   (25, 30000, 'menu.escalas', '#', 'fa fa-anchor');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (8, 130110, 130000, 'menu.muelles', 'muelle.do?metodo=obtenerListado&inicio=si', 
    'VIS_MUELLE');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (75, 120914, 120900, 'menu.textosbor', 'textos_bor.do?metodo=obtenerListado&inicio=si', 
    'VIS_LQ_TEXTOSBOR');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (9, 130113, 130000, 'menu.paises', 'pais.do?metodo=obtenerListado&inicio=si', 
    'VIS_PAIS');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (161, 120106, 120100, 'filtro.tasapesca', 'lqborrador_filtro.do?metodo=obtenerListado&inicio=si&PARAMSFILTROFIJO=IDASPECTOTARIFA IN (''B4'')', 
    'VIS_DESACTIVADA');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (13, 130106, 130000, 'menu.clientes', 'cliente.do?metodo=obtenerListado&inicio=si', 
    'VIS_CLIENTE');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (14, 130117, 130000, 'menu.puertos', 'puerto.do?metodo=obtenerListado&inicio=si', 
    'VIS_PUERTO');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (16, 40100, 40000, 'menu.declaracionesmanifiestos', 'declaracionesmanifiestos.do?metodo=obtenerListado&inicio=si', 
    'VIS_TC_G3CABECERAS');
Insert into MENU
   (INDICE, NODO, DESCRIPCION_C, URL, ICONO)
 Values
   (17, 40000, 'menu.mercancias', '#', 'fa fa-cubes');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (18, 30100, 30000, 'menu.escalas', 'escala.do?metodo=obtenerListado&inicio=si', 
    'VIS_ESCALA');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (19, 130104, 130000, 'menu.buques', 'buque.do?metodo=obtenerListado&inicio=si', 
    'VIS_BUQUE');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (20, 40200, 40000, 'menu.tramos', 'tramo.do?metodo=obtenerListado&inicio=si&PARAMSFILTROFIJO=(1=1)', 
    'VIS_TC_G3TRAMOS');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (23, 40802, 40800, 'menu.codarancelarios', 'mercancia.do?metodo=obtenerListado&inicio=si', 
    'VIS_TC_MERCANCIA');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (51, 120909, 120900, 'menu.coefpuerto', 'lqcoefpuerto.do?metodo=obtenerListado&inicio=si', 
    'VIS_LQCOEFPUERTO');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (58, 120101, 120100, 'filtro.todos', 'lqborrador.do?metodo=obtenerListado&inicio=si', 
    'VIS_BORRADOR');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (59, 120111, 120100, 'filtro.tasa80', 'lqborrador_filtro.do?metodo=obtenerListado&inicio=si&PARAMSFILTROFIJO=IDASPECTOTARIFA IN (''TR'')', 
    'VIS_BORRADOR');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (83, 120800, 120000, 'menu.procesoliquid', 'procesoliquid.do?metodo=obtenerListado&inicio=si', 
    'VIS_PROCLIQ');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (128, 80100, 80000, 'menu.ocupsupbuquebuq', 'ocupsupbuque.do?metodo=obtenerListado&inicio=si&PARAMSFILTROFIJO=(1=1)', 
    'VIS_OCUSUP');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL)
 Values
   (222, 120900, 120000, 'menu.tablasmaestras', '#');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (223, 120913, 120900, 'menu.lqtarifa', 'lqtarifa.do?metodo=obtenerListado&inicio=si', 
    'VIS_LQTARIFA');
Insert into MENU
   (INDICE, NODO, DESCRIPCION_C, URL, ICONO)
 Values
   (157, 60000, 'menu.pesca', '#', 'fish-icon');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (229, 120911, 120900, 'menu.lqfacturaserie', 'lqfacturaserie.do?metodo=obtenerListado&inicio=si', 
    'VIS_LQFACTURASERIE');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (231, 130125, 130000, 'menu.mpaisue', 'mpaisue.do?metodo=obtenerListado&inicio=si', 
    'VIS_PAIS');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (232, 120907, 120900, 'menu.lqcentrocoste', 'lqcentrocoste.do?metodo=obtenerListado&inicio=si', 
    'VIS_LQCENTROCOSTE');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (251, 10440, 10400, 'menu.estparamtucaeqnocn', 'estparamtucaeqnocn.do?metodo=obtenerListado&inicio=si', 
    'VIS_PARAMESTADISTICA');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (338, 40806, 40800, 'menu.g3marcavehiculo', 'g3marcavehiculo.do?metodo=obtenerListado&inicio=si', 
    'VIS_G3MARCAVEHICULO');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (348, 30700, 30000, 'menu.escalaplanif', 'escalaplanif.do?metodo=obtenerListado&inicio=si', 
    'VIS_PLANIFESCALA');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (370, 120050, 120000, 'menu.lqbonificacion', 'lqbonificacion.do?metodo=obtenerListado&inicio=si', 
    'VIS_BORRADOR');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (372, 40700, 40000, 'menu.equipamientoGlobal', 'equipamientoGlobal.do?metodo=obtenerListado&inicio=si', 
    'VIS_DESACTIVADA');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (381, 51000, 50000, 'menu.dpproyecto', 'dpproyectoglobal.do?metodo=obtenerListado&inicio=si', 
    'VIS_PROYECTODP');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (310, 60216, 60200, 'menu.b4tipoventa', 'b4tipoventa.do?metodo=obtenerListado&inicio=si', 
    'VIS_TIPOVENPESCA');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (311, 60214, 60200, 'menu.b4tipooperacion', 'b4tipooperacion.do?metodo=obtenerListado&inicio=si', 
    'VIS_TIPOOPPESCA');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (81, 30900, 30000, 'menu.marpol', 'marpol.do?metodo=obtenerListado&inicio=si', 
    'VIS_MARPOLESC');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (290, 120904, 120900, 'menu.lqbaremoap', 'lqbaremoap.do?metodo=obtenerListado&inicio=si', 
    'VIS_COEFSERVICIO');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (286, 20100, 20000, 'menu.edimensaje', 'edimensaje.do?metodo=obtenerListado&inicio=si', 
    'VIS_EDIMENSAJE');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (291, 130128, 130000, 'menu.tipobuqueedi', 'tipobuqueedi.do?metodo=obtenerListado&inicio=si', 
    'VIS_TIPOBUQUEEDI');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (296, 60209, 60200, 'menu.b4tipocaptura', 'b4tipocaptura.do?metodo=obtenerListado&inicio=si', 
    'VIS_TIPOCAPTPESCA');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (299, 130133, 130000, 'menu.mzonamuelle', 'mzonamuelle.do?metodo=obtenerListado&inicio=si', 
    'VIS_ZONAMUELLE');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (300, 60204, 60200, 'menu.b4especie', 'b4especie.do?metodo=obtenerListado&inicio=si', 
    'VIS_G4ESPECIE');
Insert into MENU
   (INDICE, NODO, DESCRIPCION_C, URL, ICONO)
 Values
   (302, 110000, 'menu.diverso', '#', 'fa fa-coffee');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (303, 10500, 10000, 'menu.getipodocumentoasoc', 'getipodocumentoasoc.do?metodo=obtenerListado&inicio=si', 
    'VIS_TIPODOC');
Insert into MENU
   (INDICE, NODO, DESCRIPCION_C, URL, ICONO)
 Values
   (189, 100000, 'menu.contadoragua', '#', 'fa fa-chain');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL)
 Values
   (190, 100400, 100000, 'menu.tablasmaestras', '#');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (15, 100411, 100400, 'menu.contadores', 'contador.do?metodo=obtenerListado&inicio=si', 
    'VIS_CONTADOR');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (193, 100431, 100400, 'menu.contadorlecturaperiodo', 'contadorlecturaperiodo.do?metodo=generarPantallaBusqueda&inicio=si', 
    'VIS_LEC_CONTADOR');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (191, 100441, 100400, 'menu.tomacontador', 'mtomacontador.do?metodo=obtenerListado&inicio=si', 
    'VIS_TOMACONTADOR');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (192, 100451, 100400, 'menu.rutacontador', 'mrutacontador.do?metodo=obtenerListado&inicio=si', 
    'VIS_RUTACONTADOR');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (197, 100461, 100400, 'menu.zonacontagua', 'mzonacontagua.do?metodo=obtenerListado&inicio=si', 
    'VIS_ZONACONTAGUA');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (304, 100100, 100000, 'menu.t8suminbuque', 't8suminbuque.do?metodo=obtenerListado&inicio=si&PARAMSFILTROFIJO=(1=1)', 
    'VIS_SUMINBUQUE');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (331, 10430, 10400, 'menu.estparamfptuca', 'estparamfptuca.do?metodo=obtenerListado&inicio=si', 
    'VIS_PARAMESTADISTICA');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (288, 20301, 20300, 'menu.edibuzon', 'edibuzon.do?metodo=obtenerListado&inicio=si', 
    'VIS_EDIBUZON');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL)
 Values
   (287, 20300, 20000, 'menu.tablasmaestras', '#');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (289, 20302, 20300, 'menu.edicircuito', 'edicircuito.do?metodo=obtenerListado&inicio=si', 
    'VIS_EDICIRCUITO');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL)
 Values
   (292, 60200, 60000, 'menu.tablasmaestras', '#');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (293, 60201, 60200, 'menu.b4artepesca', 'b4artepesca.do?metodo=obtenerListado&inicio=si', 
    'VIS_ARTEPESCA');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (198, 100421, 100400, 'menu.contadormasivo', 'contador_lectura_masivo.do?metodo=generarPantallaPuertoFecha', 
    'MTO_LEC_CONTADOR');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (315, 60202, 60200, 'menu.b4buquepesquero', 'b4buquepesquero.do?metodo=obtenerListado&inicio=si', 
    'VIS_BUQUEPESQ');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (322, 60100, 60000, 'menu.b4manifiesto', 'b4manifiesto.do?metodo=obtenerListado&inicio=si', 
    'VIS_G4PESCA');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (329, 120604, 120600, 'menu.estparamutieq', 'estparamutieq.do?metodo=obtenerListado&inicio=si', 
    'VIS_COEFSERVICIO');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL)
 Values
   (279, 30800, 30000, 'menu.serviciosbasicos', '#');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (281, 30802, 30800, 'menu.practicaje', 'practicaje.do?metodo=obtenerListado&inicio=si', 
    'VIS_BASICOESC');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (282, 30803, 30800, 'menu.remolcador', 'remolcador.do?metodo=obtenerListado&inicio=si', 
    'VIS_BASICOESC');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (283, 130116, 130000, 'menu.practicos', 'practico.do?metodo=obtenerListado&inicio=si', 
    'VIS_PRACTICO');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (284, 130118, 130000, 'menu.mremolcador', 'mremolcador.do?metodo=obtenerListado&inicio=si', 
    'VIS_REMOLCADOR');
Insert into MENU
   (INDICE, NODO, DESCRIPCION_C, URL, ICONO)
 Values
   (285, 20000, 'menu.edi', '#', 'fa fa-envelope-square');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (323, 120113, 120100, 'filtro.tarifasuministro', 'lqborrador_filtro.do?metodo=obtenerListado&inicio=si&PARAMSFILTROFIJO=IDASPECTOTARIFA IN (''T8'')', 
    'VIS_BORRADOR');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (324, 120114, 120100, 'filtro.restotasastarifas', 'lqborrador_filtro.do?metodo=obtenerListado&inicio=si&PARAMSFILTROFIJO=(IDASPECTOTARIFA NOT IN (''B0'',''B1'',''B2'',''B3'',''B4'',''B5'',''B6'',''TR'',''T7'',''T8'',''CA'') OR (IDASPECTOTARIFA = ''CA'' AND IDASPECTOSUBTARIFA NOT IN(''30'',''40'',''50'',''60'',''80'',''90'')))', 
    'VIS_BORRADOR');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (325, 120915, 120900, 'menu.lqfacturamotivoanulacion', 'lqfacturamotivoanulacion.do?metodo=obtenerListado&inicio=si', 
    'VIS_LQFACTURA');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (24, 130122, 130000, 'menu.terminales', 'terminal.do?metodo=obtenerListado&inicio=si', 
    'VIS_TC_TERMINAL');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (344, 130114, 130000, 'menu.provincias', 'provincia.do?metodo=obtenerListado&inicio=si', 
    'VIS_PROV');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (345, 130115, 130000, 'menu.poblaciones', 'poblacion.do?metodo=obtenerListado&inicio=si', 
    'VIS_POB');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (347, 120607, 120600, 'menu.lqtemporada', 'lqtemporada.do?metodo=obtenerListado&inicio=si', 
    'VIS_TEMPORADA');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (349, 130120, 130000, 'menu.serviciomaritbuqueglobal', 'servmaritbuqueglobal.do?metodo=obtenerListado&inicio=si', 
    'VIS_SERVMARITIM');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (366, 30501, 30000, 'menu.logtramitatraque', 'logtramitatraque.do?metodo=obtenerListado&inicio=si', 
    'VIS_DESACTIVADA');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (350, 20200, 20000, 'menu.gecontrolcambio', 'gecontrolcambio.do?metodo=obtenerListado&inicio=si', 
    'VIS_GECONTROLCAMBIO');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (365, 10150, 10000, 'menu.usuarioperfil', 'usuarioperfil.do?metodo=obtenerListado&inicio=si', 
    'M_USUARIOS');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (367, 110100, 110000, 'menu.diversogenerico', 'diversogenerico.do?metodo=obtenerListado&inicio=si&PARAMSFILTROFIJO=(1=1)', 
    'VIS_SERVDIVERSO');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (368, 110200, 110000, 'menu.diversoperiodico', 'diversoperiodico.do?metodo=obtenerListado&inicio=si', 
    'VIS_SERVDIVERSOPER');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (369, 30502, 30000, 'menu.eventosais', 'eventosais.do?metodo=obtenerListado&inicio=si', 
    'VIS_DESACTIVADA');
Insert into MENU
   (INDICE, NODO, DESCRIPCION_C, URL, ICONO)
 Values
   (261, 50000, 'menu.dominiopublico', '#', 'fa fa-university');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (262, 50100, 50000, 'menu.dpexpediente', 'dpexpediente.do?metodo=obtenerListado&inicio=si', 
    'VIS_EXPDP');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (263, 50200, 50000, 'menu.asisliqdp', 'dpexpediente.do?metodo=generarPantallaBusqueda&inicio=si', 
    'ASIS_LIQDP');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (264, 50300, 50000, 'filtro.dpexpedientevencido', 'dpexpediente_filtro.do?metodo=obtenerListadoFiltro&inicio=si', 
    'VIS_DESACTIVADA');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (265, 50400, 50000, 'menu.dpcanonocupacion', 'dpcanonocupacionglobal.do?metodo=obtenerListado&inicio=si', 
    'VIS_DPCANONOCUPACION');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (266, 50500, 50000, 'menu.dpcanonactiv', 'dpcanonactivglobal.do?metodo=obtenerListado&inicio=si', 
    'VIS_DPCANONACTIV');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (267, 50700, 50000, 'menu.dpcifranegocio', 'dpcifranegocioglobal.do?metodo=obtenerListado&inicio=si', 
    'VIS_DPCIFRANEGOCIO');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (373, 50600, 50000, 'menu.dpexpedienterevactiv', 'dpexpedienterevactivglobal.do?metodo=obtenerListado&inicio=si', 
    'VIS_DESACTIVADA');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL)
 Values
   (270, 52000, 50000, 'menu.tablasmaestras', '#');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (306, 52020, 52000, 'menu.bienpublico', 'dpbienpublico.do?metodo=obtenerListado&inicio=si', 
    'VIS_BIENPUBLICO');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (271, 52030, 52000, 'menu.instalacion', 'dppinstalacion.do?metodo=obtenerListado&inicio=si', 
    'VIS_INSTALACION');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (273, 52040, 52000, 'menu.dpmotivampperliq', 'dpmotivampperliq.do?metodo=obtenerListado&inicio=si', 
    'VIS_DPMOTIVAMPPERLIQ');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (272, 52060, 52000, 'menu.dpmotivextincion', 'dpmotivextincion.do?metodo=obtenerListado&inicio=si', 
    'VIS_DPMOTIVEXTINCION');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (307, 52070, 52000, 'menu.dptasacion', 'dptasacionglobal.do?metodo=obtenerListado&inicio=si', 
    'VIS_TASACINST');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (305, 52090, 52000, 'menu.tipobienpublico', 'dptipobienpublico.do?metodo=obtenerListado&inicio=si', 
    'VIS_TIPOBIENPUBLICO');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (275, 52110, 52000, 'menu.dpunidadmax', 'dpunidadmax.do?metodo=obtenerListado&inicio=si', 
    'VIS_DPUNIDADMAX');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (276, 52120, 52000, 'menu.dptipouso', 'dptipouso.do?metodo=obtenerListado&inicio=si', 
    'VIS_DPTIPOUSO');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (277, 52130, 52000, 'menu.zonavalor', 'dppzonavalor.do?metodo=obtenerListado&inicio=si', 
    'VIS_ZONAVALOR');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (354, 52100, 52000, 'menu.tiposincidencia', 'dptipoincidencia.do?metodo=obtenerListado&inicio=si', 
    'VIS_TIPOINCIDENCIADP');
Insert into MENU
   (INDICE, NODO, DESCRIPCION_C, URL, ICONO)
 Values
   (148, 70000, 'menu.embdeportivas', '#', 'sportboat-icon');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL)
 Values
   (149, 72000, 70000, 'menu.gestionindirecta', '#');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (150, 72100, 72000, 'menu.marina', 'marina.do?metodo=obtenerListado&inicio=si', 
    'VIS_G5MARINA');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (166, 72200, 72000, 'menu.g5procesocarga', 'g5procesocarga.do?metodo=obtenerListado&inicio=si', 
    'VIS_G5MARINA');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (375, 40805, 40800, 'menu.minstalespecial', 'minstalespecial.do?metodo=obtenerListado&inicio=si', 
    'VIS_INSTESP');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL)
 Values
   (376, 40800, 40000, 'menu.tablasmaestras', '#');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (377, 50800, 50000, 'menu.dpfianza', 'dpfianzaglobal.do?metodo=obtenerListado&inicio=si', 
    'VIS_FIANZADP');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (332, 100300, 100000, 'menu.t8sumingenerico', 't8sumingenerico.do?metodo=obtenerListado&inicio=si', 
    'VIS_SUMINGENERICO');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (371, 40600, 40000, 'menu.partidaGlobal', 'partidaGlobal.do?metodo=obtenerListado&inicio=si', 
    'VIS_DESACTIVADA');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (339, 120601, 120600, 'menu.lqparamcodarant2', 'lqparamcodarant2.do?metodo=obtenerListado&inicio=si', 
    'VIS_COEFSERVICIO');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (340, 130107, 130000, 'menu.clientesporpuerto', 'clientepuerto.do?metodo=generarPantallaUsuarioPorpuerto', 
    'VIS_DESACTIVADA');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (346, 120304, 120300, 'menu.colafacturacion', 'lqfacturacioncola.do?metodo=obtenerListado&inicio=si', 
    'VIS_LQFACTURACIONCOL');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (351, 30200, 30000, 'menu.escalacontrolsolapada', 'escalacontrolsolapada.do?metodo=generarPantallaFechaControl', 
    'VIS_DESACTIVADA');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (356, 60300, 60000, 'menu.b4procesocarga', 'g4procesocarga.do?metodo=obtenerListado&inicio=si', 
    'VIS_G4PESCA');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (380, 52010, 52000, 'menu.dpbanco', 'dpbanco.do?metodo=obtenerListado&inicio=si', 
    'VIS_BANCODP');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (379, 50900, 50000, 'menu.dphipoteca', 'dphipotecaglobal.do?metodo=obtenerListado&inicio=si', 
    'VIS_HIPOTECADP');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (343, 10450, 10400, 'menu.estcodaranveh', 'estcodaranveh.do?metodo=obtenerListado&inicio=si', 
    'VIS_PARAMESTADISTICA');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (382, 52080, 52000, 'menu.dptipoactivprincipal', 'dptipoactivprincipal.do?metodo=obtenerListado&inicio=si', 
    'VIS_TIPOACTIVPRINC');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (388, 130109, 130000, 'menu.mdomicilio', 'mdomicilioglobal.do?metodo=obtenerListado&inicio=si', 
    'VIS_CLIENTE');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL)
 Values
   (390, 73000, 70000, 'menu.tablasmaestras', '#');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (391, 73100, 73000, 'menu.instalacion', 'b5minstalacion.do?metodo=obtenerListado&inicio=si', 
    'VIS_B5MINSTALACION');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (392, 73200, 73000, 'menu.puestoamarre', 'b5mamarreversion.do?metodo=obtenerListado&inicio=si', 
    'VIS_B5MAMARRE');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (147, 70200, 71000, 'menu.g5transito', 'g5transito.do?metodo=obtenerListado&inicio=si', 
    'VIS_TRANSITO');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (152, 1610, 73000, 'menu.embarcacion', 'embarcacion.do?metodo=obtenerListado&inicio=si', 
    'VIS_MEMBARCACION');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (153, 1611, 73000, 'menu.membarcacioncert', 'membarcacioncertglobal.do?metodo=obtenerListado&inicio=si', 
    'VIS_MEMBARCACION');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (154, 1612, 73000, 'menu.instalacion', 'instalacion.do?metodo=obtenerListado&inicio=si', 
    'VIS_MINSTALACION');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (155, 1613, 73000, 'menu.pantalan', 'pantalan.do?metodo=obtenerListado&inicio=si', 
    'VIS_MPANTALAN');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (156, 1614, 73000, 'menu.amarre', 'amarre.do?metodo=obtenerListado&inicio=si', 
    'VIS_MAMARRE');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (158, 1615, 73000, 'menu.g5motivextincion', 'g5motivextincion.do?metodo=obtenerListado&inicio=si', 
    'VIS_G5MOTIVEXTINCION');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (246, 120602, 120600, 'menu.lqparamcodaran2453', 'lqparamcodaran2453.do?metodo=obtenerListado&inicio=si', 
    'VIS_COEFSERVICIO');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (89, 40811, 130000, 'menu.dpbanco', 'banco.do?metodo=obtenerListadoc&inicio=si', 
    'VIS_BANCO');
Insert into MENU
   (INDICE, NODO, DESCRIPCION_C, URL)
 Values
   (394, 90000, 'menu.sermaquinaria', '#');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (395, 90100, 90000, 'menu.sgcmaquinaria', 'sgcmaquinaria.do?metodo=obtenerListado&inicio=si', 
    'VIS_SGC_MAQUINARIA');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL)
 Values
   (396, 90900, 90000, 'menu.tablasmaestras', '#');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (397, 90901, 90900, 'menu.mmaquinaria', 'mmaquinaria.do?metodo=obtenerListado&inicio=si', 
    'VIS_MMAQUINARIA');
Insert into MENU
   (INDICE, NODO, NODO_PADRE, DESCRIPCION_C, URL, CODFUNCIONALIDAD)
 Values
   (90, 40812, 130000, 'menu.sucursales', 'sucursal.do?metodo=obtenerListado&inicio=si', 
    'VIS_SUCURSAL');
COMMIT;
