SET DEFINE OFF;
Insert into PARAMETRO
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('MAILFACTURAE', 'fpablo@prodevelop.es;mjlabuiga@prodevelop.es', 'Correo electrónico destino (FACTURAE)');
Insert into PARAMETRO
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('HORAOCUPACIONSUPERFICIE', '06:00', 'Indica la hora que se sugiere por defecto en el alta de ocupación de superficie');
Insert into PARAMETRO
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('ASOCTIPTRAFICO_G3CABECERA', '0', 'Indica si se asocia tipo de tráfico en las declaraciones/manifiestos');
Insert into PARAMETRO
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('SUGFECATRAQUE', '1', 'Indica si se sugieren fechas de inicio y fin de atraque en estadías manuales. 1 se sugieren.0 vacío');
Insert into PARAMETRO
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('APLICAUTCAPITANIA', '0', 'Indica si se necesita autorización de capitania para las escalas');
Insert into PARAMETRO
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('FORMAATRAQUEBERMAN', '0', 'Indica la forma de atraque en el alta de escalas BERMAN. Valor 0 para todos o 1 para los reales');
Insert into PARAMETRO
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('COMPROBARNORAYMUELLE', '0', 'Indica si comprueba que el noray asociado a un muelle esté en el maestro');
Insert into PARAMETRO
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('ENVIOMAIL', '0', 'Indicador de si se envían mails o no. Valdrá 0 ó 1');
Insert into PARAMETRO
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('MAILHOST', 'smtp.gmail.com', 'Dirección IP del servidor SMTP');
Insert into PARAMETRO
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('MAILUSER', 'prodemailresweb@gmail.com', 'Usuario con el que conectamos al servidor SMTP, en caso de que necesite autentificación');
Insert into PARAMETRO
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('MAILPASSWORD', 'Antojit0@33', 'Password asociado al usuario anterior');
Insert into PARAMETRO
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('MAILFROM', 'NotificacionesArista@prodevelop.es', 'Dirección desde la cual enviamos todos los mails');
Insert into PARAMETRO
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('MAILDEBUG', '1', 'Activar/desactivar modo ''debug''. Si vale 1 estará activo');
Insert into PARAMETRO
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('MAILAUTH', '1', 'Para indicar si el servidor requiere o no autenticación. Vale 1 si requiere de autenticación');
Insert into PARAMETRO
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('MAILTRANSPORTPROTOCOL', 'smtps', 'Protocolo a usar. Valdrá smtp o smtps');
Insert into PARAMETRO
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('MAILTRANSPORTPORT', '465', 'Puerto smtp o smtps');
Insert into PARAMETRO
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('MARGENVENCIMIENTODP', '30', 'Indica los días de margen en listado de vencimiento autorizaciones');
Insert into PARAMETRO
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('MAILFACTURACION', 'fpablo@prodevelop.es;mjlabuiga@prodevelop.es', 'Correo electrónico de facturación');
Insert into PARAMETRO
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('URL_LOGIN', 'ldap://130.0.2.88:389', 'URL del Active directory');
Insert into PARAMETRO
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('DOMINIO_LOGIN', '@prode_domi.es', 'Dominio del usuario en el Active directory');
Insert into PARAMETRO
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('NUMESCALAUNICO', '1', 'Indicador de si se permite insertar escala no el numero repetido. Valdrá 0 ó 1');
Insert into PARAMETRO
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('MARGENBATCHT7', '7', 'Indica los días de margen en liquidaciones batch T7');
Insert into PARAMETRO
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('COMPROBARLIQUIDACIONTRAMO', '1', 'Indica si se valida que el tramo esté liquidado para realizar modificaciones de mercancía');
Insert into PARAMETRO
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('COMPROBARLIQUIDACIONESCALA', '1', 'Indica si se valida que la escala esté liquidada para realizar modificaciones de datos');
Insert into PARAMETRO
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('VERSIONADOTRAMOS', '0', 'Indicador de si se versionan los tramos');
Insert into PARAMETRO
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('VERSIONADOESCALAS', '0', 'Indicador de si se versionan las escalas');
Insert into PARAMETRO
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('COMPROBARFFECHAFINESTADIA', '0', 'Indica si se comprueba que la fecha de fin de la estadía sea posterior a hoy');
Insert into PARAMETRO
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('FINALIZARAUTBASE', '1', 'Indica si se finalizan automáticamente las autorizaciones base');
Insert into PARAMETRO
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('LOGIN', '1', 'Indicador de si usamos autenticación');
Insert into PARAMETRO
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('ACTUALIZARESTADIADESDEPESCA', '0', 'Indicador de si se actualizan datos de estadía desde operaciones de descarga de pesca');
Insert into PARAMETRO
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('ENTORNO', 'PRUEBAS', 'Valores: PRODUCCION/PRUEBAS');
Insert into PARAMETRO
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('LOGOPUERTO', 'logo-puerto.png', 'Icono del puerto para el login');
Insert into PARAMETRO
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('CHECKFONDEOMUELLE', '1', 'Indicador de si se permite modificar el check de fondeo del muelle');
Insert into PARAMETRO
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('MAILINFRAESTRUCTURAS', 'fpablo@prodevelop.es;mjlabuiga@prodevelop.es', 'Correo electrónico de infraestructuras');
Insert into PARAMETRO
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('ANYOACUMCLIENTEBONIF', '2015', 'Año para el cual se necesita el acumulado de la bonificación 245.3 por cliente');
Insert into PARAMETRO
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('BATCHT1', '0', 'Indica si se ejecuta la tarea periódica de liquidación T1');
Insert into PARAMETRO
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('MARGENVENCICONTAGUADP', '7', 'Indica los días de margen para avisar del vencimiento de contadores de agua de DP');
Insert into PARAMETRO
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('BATCHCONTAGUADP', '0', 'Indica si se ejecuta la tarea periódica de aviso de vencimiento de contadores de agua DP');
Insert into PARAMETRO
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('BATCHT0', '0', 'Indica si se ejecuta la tarea periódica de liquidación T0');
Insert into PARAMETRO
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('BATCHT2', '0', 'Indica si se ejecuta la tarea periódica de liquidación T2');
Insert into PARAMETRO
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('BATCHT3', '0', 'Indica si se ejecuta la tarea periódica de liquidación T3');
Insert into PARAMETRO
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('BATCHT7', '0', 'Indica si se ejecuta la tarea periódica de liquidación T7');
Insert into PARAMETRO
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('FECHAINICIOLIQUIDACIONES', '01/01/2013', 'Fecha apartir de la que se empieza a generar borradores');
Insert into PARAMETRO
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('ANYOBORRADOR', 'FECLIQ', 'Campo a partir del que se genera el anyo del borrador');
Insert into PARAMETRO
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('FECHASERIE', 'FECLIQ', 'Campo a partir del que se obtiene la serie al insertar el borrador');
Insert into PARAMETRO
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('FECHAIVA', 'FECLIQ', 'Campo a partir del que se obtienen los ivas al insertar el borrador');
Insert into PARAMETRO
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('ULTIMOESTADOESCALA', 'FI', 'Indica el estado final de la escala a partir del cual se puede liquidar la B1 y TR');
Insert into PARAMETRO
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('DISTRIBUCION', 'M', 'Indica la distribución de la aplicación para cada puerto');
Insert into PARAMETRO
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('NORAYMUELLEOBLIGATORIO', '0', 'Indica si obliga a introducir los noray asociado a un muelle no fondeo. Valor 0 o 1');
Insert into PARAMETRO
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('MOSTRAR_VERSION_SVN', '1', 'Mostrar versión SVN');
Insert into PARAMETRO
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('REPITECODIGOEXPDP', '1', 'Indica de si se alerta de que el expediente ya existe. Valdrá 0, se dará error, ó 1, se podrá grabar');
Insert into PARAMETRO
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('MTOCLIENTEPOSIDONIA', '1', 'Indica si el mantenimiento de clientes es propio. 0 lo hace el ERP. 1 lo hace Posidonia');
Insert into PARAMETRO
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('AUTATRLOCODENOPUERTO', '0', 'Cuando se autoriza un atraque, parametrizar si mira que el puerto anterior y siguiente de la escala sean LOCODEs con puerto. Si vale 0 no lo mira. Si vale 1 sí lo mira');
Insert into PARAMETRO
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('FECHAINIVIGBUQUE', '01/01/2000', 'Indica la fecha por defecto al crear la primera vigencia del buque');
Insert into PARAMETRO
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('NUM_CARACTERES_STR_NUM_ESCALA', '5', 'Max número de digitos de una escala (sirve para rellenar el núm. escala con ceros a la izquierda)');
Insert into PARAMETRO
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('COMPROBARREVISAUTESCALA', '0', 'Indica si comprueba que la escala no esté pendiente de revisión autorización para iniciar el atraque. Valor 0 no se valida. Valor 1 se comprueba');
Insert into PARAMETRO
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('URLPESQUEROSMMA', 'http://www.magrama.gob.es/es/pesca/temas/la-pesca-en-espana/censo-de-la-flota-pesquera/censo.asp', 'Url del censo de pesqueros en el ministario de medio ambiente');
Insert into PARAMETRO
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('BACTH_PUBLISH_RABBIT_CONEX', '130.0.0.57:ipoms:aisipoms', 'Datos conexion publisher rabbit (HOST:USERNAME:PASSWORD)');
Insert into PARAMETRO
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('HABILITAR_SUBSCRIBER_RABBIT_BD', '1', 'Habilitar subscriber a rabit');
Insert into PARAMETRO
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('DECIMALESPORCINSTBIENPUBLICO', '6', 'Número decimales en el porcentaje de uso de instalacion del bien público');
Insert into PARAMETRO
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('DECIMALESPRECIOZONAVALOR', '2', 'Número decimales en la actualización de precio de zonas valor terreno');
Insert into PARAMETRO
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('CLIENTE_NO_PERMITIR_DUP_DOC', '1', 'No permitir insertar un cliente si el n. documento ya está asociado a otro cliente.');
Insert into PARAMETRO
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('CLIENTE_CHECKRANGO_MARCADO_PD', '1', 'Marcar por defecto el check rango en la pantalla de alta cliente');
Insert into PARAMETRO
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('CLIENTE_NO_DEJAR_ELIMINAR_FIS', '1', 'No dejar eliminar físicamente (botón eliminar) un cliente');
Insert into PARAMETRO
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('GIS_VER_SELECCIONADO_DP', '0', 'Activar-Desactivar acción GIS_VER_SELECCIONADO desde el TCON de Dominio Público. 1 = activa');
Insert into PARAMETRO
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('GIS_VER_TODOS_DP', '0', 'Activar-Desactivar acción GIS_VER_TODOS desde el TCON de Dominio Público. 1 = activa');
Insert into PARAMETRO
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('GIS_VER_SELECCIONADO_OCUP', '0', 'Activar-Desactivar acción GIS_VER_SELECCIONADO desde el TCON de Ocup Sup Buque. 1 = activa');
Insert into PARAMETRO
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('GIS_VER_TODOS_OCUP', '0', 'Activar-Desactivar acción GIS_VER_TODOS desde el TCON de Ocup Sup Buque. 1 = activa');
Insert into PARAMETRO
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('gis_funcs_dpexpediente', 'GIS_MANA_MOD_DP,GIS_MANA_LYR_CONCESIONES,GIS_MANA_LYR_AUTORIZACIONES,GIS_MANA_TOOL_CHANGEVISGROUP,GIS_MANA_TOOL_ZOOMFEATURESLYRS,GIS_MANA_TOOL_LINKFILEDP,MTO_DP_CONCESIONES_GEOM,MTO_DP_AUTORIZACIONES_GEOM,GIS_MANA_TOOL_FINDER', 'Funcionalidades internas del GIS de Dominio Público');
Insert into PARAMETRO
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('view_func_dpexpediente', 'VIS_GIS_DP', 'Funcionalidad visualización para el GIS de Dominio Público');
Insert into PARAMETRO
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('edit_func_dpexpediente', 'MTO_GIS_DP', 'Funcionalidad edición para el GIS de Dominio Público');
Insert into PARAMETRO
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('view_mode_dpexpediente', 'mana_dp_view', 'Modo visualización para el GIS de Dominio Público');
Insert into PARAMETRO
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('edit_mode_dpexpediente', 'mana_dp_edit', 'Modo edición para el GIS de Dominio Público');
Insert into PARAMETRO
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('gis_funcs_ocupsupbuque', 'GIS_MOD_OCUPACIONES,GIS_LYR_OCUPACIONES,GIS_LYR_OCUP_ZONAS,GIS_TOOL_CHANGEVISGROUP,GIS_TOOL_FINDER,GIS_TOOL_ZOOMFEATURESLYRS', 'Funcionalidades internas del GIS de Ocupación de Superficie');
Insert into PARAMETRO
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('view_func_ocupsupbuque', 'VIS_GIS_OCUP', 'Funcionalidad visualización para el GIS de Ocupación de Superficie');
Insert into PARAMETRO
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('view_mode_ocupsupbuque', 'mana_ocup_view', 'Modo visualización para el GIS de Ocupación de Superficie');
Insert into PARAMETRO
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('gis_filter_layers_dpexpediente', 'concesiones01,autorizaciones01', 'Identificador de las distintas capas del filtro para el GIS de Dominio Público');
Insert into PARAMETRO
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('gis_filter_layers_ocupsupbuque', 'ocupaciones01', 'Identificador de las distintas capas del filtro para el GIS de Ocupación de Superficie');
Insert into PARAMETRO
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('ESTILOGRAFICO', '0', 'Indica el estilo gráfico a aplicar. Valor 0 para el original');
Insert into PARAMETRO
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('COMPROBARPUERTOAUTESTADIA', '1', 'Indica si se comprueba si puerto anterior o siguiente de la escala vale XX XXX al autorizar atraque. Si vale 0 sí dejaremos. Si vale 1 no dejaremos');
Insert into PARAMETRO
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('PORTAUT', '80', 'Código de la autoridad portuaria. Lo usamos desde OperationsWS');
COMMIT;
