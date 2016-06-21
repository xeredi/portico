SET DEFINE OFF;
Insert into PARAM_EDI
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('LLAMADA_EDI_AUTATRAQUE', '1', 'Parámetro para que se llame o no al método que genera el mensaje EDI para el consignatario al autorizar un atraque EDI. Si vale 0 no se llama al método. Si vale 1, sí se llama al método');
Insert into PARAM_EDI
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('LLAMADA_EDI_DENATRAQUE', '1', 'Parámetro para que se llame o no al método que genera el mensaje EDI para el consignatario al denegar un atraque EDI. Si vale 0 no se llama al método. Si vale 1, sí se llama al método');
Insert into PARAM_EDI
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('LLAMADA_EDI_INIESC_ATA', '1', 'Parámetro para que se llame o no al método que genera el mensaje EDI al inicio escala ATA. Si vale 0 no se llama al método. Si vale 1, sí se llama al método');
Insert into PARAM_EDI
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('LLAMADA_EDI_INIESC_PRAC', '1', 'Parámetro para que se llame o no al método que genera el mensaje EDI al inicio escala – activación prácticos. Si vale 0 no se llama al método. Si vale 1, sí se llama al método');
Insert into PARAM_EDI
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('LLAMADA_EDI_FINESC_ATD', '1', 'Parámetro para que se llame o no al método que genera el mensaje EDI al finalizar escala ATD. Si vale 0 no se llama al método. Si vale 1, sí se llama al método');
Insert into PARAM_EDI
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('EDI_ENVIO_MENSAJES_END_POINT', 'http://comoros.prodevelop.es:18080/integradosedi-ws/services/MensajeEdi', 'end-point ws estación Edi envio mensajes');
Insert into PARAM_EDI
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('ESCALA_MODO_DESARROLLO_ACTIVO', '0', 'desarrollo!!!!!!!!!!!');
Insert into PARAM_EDI
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('ESCALA_MODO_DESARROLLO_ACTIVO_NUMESC', '0', 'desarrollo');
Insert into PARAM_EDI
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('ESCALA_SUBPROCESOS_A_EJECUTAR', '1111111110', 'Mascara para habilitar los subprocesos del circuito de trafico de buques.');
Insert into PARAM_EDI
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('CODMUELLE_IFCSUM_N_DIG_ELIM_IZ', '2', 'numero de dígitos a la izquierza por eliminar para el muelle (últimos dígitos)');
Insert into PARAM_EDI
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('CODMUELLE_IFCSUM_CAR_ELIM_DE', '@', 'Símbolo por eliminar a la derecha del código del muelle (separados por | en caso de más opciones de caracteres a eliminar)');
Insert into PARAM_EDI
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('NUM_CARACTERES_STR_NUM_ESCALA', '5', 'Max número de digitos de una escala (sirve para rellenar el núm. escala con ceros a la izquierda');
Insert into PARAM_EDI
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('CODMUELLE_ESCALA_CAR_ELIM_DE', '@', 'Símbolo por eliminar a la derecha del código del muelle (separados por | en caso de más opciones de caracteres a eliminar)');
Insert into PARAM_EDI
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('GESTIONAR_PART_EQUIPS_LL_VA_6', '1', 'Cuando se procesa un mensaje de alta, si viene un equipamiento con estado lleno vacío=6, ignoralo ');
Insert into PARAM_EDI
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('WS_CARGAEDI_NOMB_FICHERO_OBLIG', '1', 'Ws carga mensaje edi: el nombre fichero es obligatorio');
Insert into PARAM_EDI
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('ERROR_SI_NO_SE_GENERA_PDF_FACT', '1', 'Si hay un error en generar el pdf de la factura (proceso facturar), parar el proceso');
Insert into PARAM_EDI
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('CODMUELLE_ESCALA_N_DIG_ELIM_IZ', '0', 'numero de dígitos a la izquierza por eliminar para el muelle (últimos dígitos)');
Insert into PARAM_EDI
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('PUERTOCARGAIFCSUM', 'M', 'Puerto de Carga de los fichero ifcsum');
Insert into PARAM_EDI
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('BATCHT4', '0', 'Indica si se ejecuta la tarea proceso IFCSUM');
Insert into PARAM_EDI
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('EDI_CODUSUARIO_AUTORIDAD_PORT', '0', 'Usuario EDI de la Autoridad Portuaria');
Insert into PARAM_EDI
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('EDI_CODUSUARIO_PORTEL', '31', 'Usuario EDI de la Autoridad Portuaria');
Insert into PARAM_EDI
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('CLAVE_WS_CARGAR_MENSAJE', 'YA VEREMOS', 'El comsumidor del servicio web deberá de esta clave encriptada en Base 64');
Insert into PARAM_EDI
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('IFCSUM_REDONDEO_PESOPARTIDA', '2', 'REDONDEAR A: SI >0 numero digitos indicados, SI <0 no hace nada');
Insert into PARAM_EDI
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('IFCSUM_EQUIP_LLENO_SN_MATR_ERR', '1', 'Ifcsum: es error si viene un equipamiento lleno sin matricula');
Insert into PARAM_EDI
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('IFCSUM_REDONDEO_VOLUMEN', '2', 'REDONDEAR A: SI >0 numero digitos indicados, SI <0 no hace nada');
Insert into PARAM_EDI
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('FILTRAR_CN_SI_DECLARA_CV', '1', 'Si declara un CV (existe el segmento CV), hay más segmentos CN, filtrar el CN con el mismo NIF del CV');
Insert into PARAM_EDI
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('RECHAZAR_LOCODE_SIN_PUERTO', '0', 'Rechazar locode si viene sin código del puerto (solo pais de 2 letras)');
Insert into PARAM_EDI
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('CREAR_AUTOMATIC_PUERTO_DESCON', '1', 'Crear automáticamente el registo en M_Puerto con pais  y puerto desconocido si no existe.');
Insert into PARAM_EDI
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('REPROCESAR_MENSAJES_PEND_CAB', '1', 'Cuando se procesa un mensaje de alta cabecera correctamente, se deben reprocesar los mensajes relacionados ya procesados (con errores) ');
Insert into PARAM_EDI
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('IFCSUM_F13_ACEPTAR_SOLO_CV', '1', 'En caso de función 13 (borrado tramo) y recibir solo un CV (sin CN) usar como declarante (CN) el CV ');
Insert into PARAM_EDI
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('ESCALA_CODTIPOBUQUE_DEFECTO', '**', 'Indica el tipo de buque por defecto que se asigna si el buque de la ficha técnica no está en el maestro');
Insert into PARAM_EDI
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('ESCALA_ATRAQUE_REEMPLAZO_SI_MISMO', '1', 'En caso de reemplado atraque y numestanciareemplazo nulo, usar numestancia (reemplazo del mismo atraque)');
Insert into PARAM_EDI
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('ESCALA_PROCESO_2_HABILITAR_NOTIFICACIONES', '1', 'Generar notificaciones para el circuito de Solicitud de alte de escala');
Insert into PARAM_EDI
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('CODMUELLE_ESCALA_COMPROBAR_NORAYS', '1', 'Comprobar si en el código del muelle se incluyen los norays inicial y final');
Insert into PARAM_EDI
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('BERMAN_BATCH_INTERVALO_ALERTA', '10', 'Máximo intervalo para no lanzar alertas de problemas procesos batch berman');
Insert into PARAM_EDI
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('IFCSUM_BATCH_INTERVALO_ALERTA', '1', 'Máximo intervalo para no lanzar alertas de problemas procesos batch ifcsum');
Insert into PARAM_EDI
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('EDI_CODUSUARIO_PUERTOESTADO', '-', 'Usuario PUERTOS DEL ESTADO ');
Insert into PARAM_EDI
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('ESCALA_NO_ENVIAR_APERAK_BAJA_ESCALA', '1', 'Si el berman es una función de baja de escala, no se enviará aperak de respuesta (si valor =1)');
Insert into PARAM_EDI
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('ESCALA_TIPO_NOTIFICACION_1_ACTIVO', '1', 'Tipo de notificacion (Alta automática de Buque) para escala: 0 no activo, 1 activo por proceso, 2 activo cumulado');
Insert into PARAM_EDI
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('ESCALA_TIPO_NOTIFICACION_2_ACTIVO', '1', 'Tipo de notificacion (Información de la carga) para escala: 0 no activo, 1 activo por proceso, 2 activo cumulado');
Insert into PARAM_EDI
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('ESCALA_TIPO_NOTIFICACION_3_ACTIVO', '1', 'Tipo de notificacion (Resultado de la carga) para escala: 0 no activo, 1 activo por proceso, 2 activo cumulado');
Insert into PARAM_EDI
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('ESCALA_TIPO_NOTIFICACION_4_ACTIVO', '1', 'Tipo de notificacion (Alta puerto desconicido) para escala: 0 no activo, 1 activo por proceso, 2 activo cumulado');
Insert into PARAM_EDI
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('ESCALA_TIPO_NOTIFICACION_5_ACTIVO', '1', 'Tipo de notificacion (Puerto con indicador <es puerto> a false) para escala: 0 no activo, 1 activo por proceso, 2 activo cumulado');
Insert into PARAM_EDI
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('IFCSUM_TIPO_NOTIFICACION_3_ACTIVO', '2', 'Tipo de notificacion (Resultado de la carga) para ifcsum: 0 no activo, 1 activo por proceso, 2 activo cumulado');
Insert into PARAM_EDI
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('CODTIPOPER_ESCALA_ELIM_ULT_DIG', '1', 'Eliminar último digito del código operación edi');
Insert into PARAM_EDI
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('IFCSUM_CODTERMINAL_USO_TERMINAL', '1', 'Ifcsum: Validar el campo codTerminal de la cabecera contra M_terminal ');
Insert into PARAM_EDI
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('IFCSUM_ACEPTAR_ESTIBADOR_MUELLE_NOMAESTRO', '1', 'Aceptar el mensaje si el estibador declara un muelle que no existe en el maestro, se usará el muelle del primer atraque');
Insert into PARAM_EDI
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('IFCSUM_REFERENCIA.TE_USO_TERMINAL', '1', 'Ifcsum: Validar el campo referencia (terminal) de la partida contra M_Terminal ');
Insert into PARAM_EDI
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('AUDITORIA_ACTIVA_CAMBIOS_ESCALA_EDI', '2', 'Auditoria cambios EDI Escala. 0=deshabilitada, 1=habilitada interna, 2=habilitada proceso publicador eventos');
Insert into PARAM_EDI
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('IFCSUM_ACEPTAR_ESTIBADOR_SIN_MUELLE', '1', 'Aceptar el mensaje si el estibador no declara el muelle, se usará el muelle del primer atraque');
Insert into PARAM_EDI
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('IFCSUM_ACEPTAR_CONOCIMIENTO_MUELLE_NOMAESTRO', '1', 'Aceptar el mensaje si en el conocimiento se declara un muelle que no existe en el maestro, se usará el muelle del primer atraque');
Insert into PARAM_EDI
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('ESCALA_REDONDEO_ESLORATOTAL', '2', 'REDONDEAR A: SI >0 numero digitos indicados, SI <0 no hace nada');
Insert into PARAM_EDI
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('ESCALA_REDONDEO_MANGA', '2', 'REDONDEAR A: SI >0 numero digitos indicados, SI <0 no hace nada');
Insert into PARAM_EDI
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('ESCALA_REDONDEO_CALMAXIMO', '2', 'REDONDEAR A: SI >0 numero digitos indicados, SI <0 no hace nada');
Insert into PARAM_EDI
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('ESCALA_REDONDEO_PUNTAL', '2', 'REDONDEAR A: SI >0 numero digitos indicados, SI <0 no hace nada');
Insert into PARAM_EDI
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('ESCALA_REDONDEO_GT', '3', 'REDONDEAR A: SI >0 numero digitos indicados, SI <0 no hace nada');
Insert into PARAM_EDI
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('ESCALA_REDONDEO_TPM', '3', 'REDONDEAR A: SI >0 numero digitos indicados, SI <0 no hace nada');
Insert into PARAM_EDI
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('ESCALA_REDONDEO_ALTURAARBOLADURA', '2', 'REDONDEAR A: SI >0 numero digitos indicados, SI <0 no hace nada');
Insert into PARAM_EDI
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('ESCALA_REDONDEO_POTENCIA', '2', 'REDONDEAR A: SI >0 numero digitos indicados, SI <0 no hace nada');
Insert into PARAM_EDI
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('ESCALA_REDONDEO_VELMAXIMA', '2', 'REDONDEAR A: SI >0 numero digitos indicados, SI <0 no hace nada');
Insert into PARAM_EDI
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('ESCALA_REDONDEO_VELCRUCERO', '2', 'REDONDEAR A: SI >0 numero digitos indicados, SI <0 no hace nada');
Insert into PARAM_EDI
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('ESCALA_REDONDEO_SBTVOLUMEN', '3', 'REDONDEAR A: SI >0 numero digitos indicados, SI <0 no hace nada');
Insert into PARAM_EDI
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('ESCALA_REDONDEO_LASTRESUCIO', '3', 'REDONDEAR A: SI >0 numero digitos indicados, SI <0 no hace nada');
Insert into PARAM_EDI
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('ESCALA_REDONDEO_TANFANGOS', '3', 'REDONDEAR A: SI >0 numero digitos indicados, SI <0 no hace nada');
Insert into PARAM_EDI
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('ESCALA_REDONDEO_TANAGUASOLEOSAS', '3', 'REDONDEAR A: SI >0 numero digitos indicados, SI <0 no hace nada');
Insert into PARAM_EDI
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('ESCALA_REDONDEO_AGUASSUCIAS', '3', 'REDONDEAR A: SI >0 numero digitos indicados, SI <0 no hace nada');
Insert into PARAM_EDI
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('ESCALA_REDONDEO_BASURAS', '3', 'REDONDEAR A: SI >0 numero digitos indicados, SI <0 no hace nada');
Insert into PARAM_EDI
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('ESCALA_REDONDEO_RAMPA1ALCANCE', '2', 'REDONDEAR A: SI >0 numero digitos indicados, SI <0 no hace nada');
Insert into PARAM_EDI
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('ESCALA_REDONDEO_RAMPA2ALCANCE', '2', 'REDONDEAR A: SI >0 numero digitos indicados, SI <0 no hace nada');
Insert into PARAM_EDI
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('ESCALA_REDONDEO_RAMPA3ALCANCE', '2', 'REDONDEAR A: SI >0 numero digitos indicados, SI <0 no hace nada');
Insert into PARAM_EDI
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('ESCALA_REDONDEO_RAMPA4ALCANCE', '2', 'REDONDEAR A: SI >0 numero digitos indicados, SI <0 no hace nada');
Insert into PARAM_EDI
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('ESCALA_REDONDEO_RAMPA1ANCHURA', '2', 'REDONDEAR A: SI >0 numero digitos indicados, SI <0 no hace nada');
Insert into PARAM_EDI
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('ESCALA_REDONDEO_RAMPA2ANCHURA', '2', 'REDONDEAR A: SI >0 numero digitos indicados, SI <0 no hace nada');
Insert into PARAM_EDI
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('ESCALA_REDONDEO_RAMPA3ANCHURA', '2', 'REDONDEAR A: SI >0 numero digitos indicados, SI <0 no hace nada');
Insert into PARAM_EDI
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('ESCALA_REDONDEO_RAMPA4ANCHURA', '2', 'REDONDEAR A: SI >0 numero digitos indicados, SI <0 no hace nada');
Insert into PARAM_EDI
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('IFCSUM_BATCH_NUM_MAX_MENSAJE_A_PROCESAR', '10', 'num mens.');
Insert into PARAM_EDI
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('IFCSUM_PROCESO_9_HABILITAR_NOTIFICACIONES', '1', 'desarrollo');
Insert into PARAM_EDI
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('WS_CARGAR_MENSAJE_FILTRO_ENTRADA', '1,7,3,2', 'Filtro mensajes edi entrada aceptados: N.A. (sin filtro). formato: TM1|TD1|F1,TM2|TD2|F2,...,TMn|TDn|Fn; TMi=Tipo mensaje i, TDi(opcional)=Tipo Documento, Fi(opcional)=Funcion.');
Insert into PARAM_EDI
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('ESCALA_REVAUTMODIFEDI', '1', 'Marcar el check de pendiente de revisión autorización de la escalasi hay cambios');
Insert into PARAM_EDI
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('ESCALA_REENVIAR_SOLICITUD_A_PUERTO_ESTADO', '0', 'Reenvio Berman a Puerto del Estado');
Insert into PARAM_EDI
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('BBB', '0', 'eliminar');
Insert into PARAM_EDI
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('GENERAR_MENSAJE_AVISO_DE_PRACTICAJE', '0', 'Generar mensajes Cusrp2');
Insert into PARAM_EDI
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('ESCENARIO_INTEGRACION_VUN', '1', 'Escenario integración Ventanilla Única Nacional, condiciona el envío de unos mensajes');
COMMIT;
