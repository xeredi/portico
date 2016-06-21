SET DEFINE OFF;
Insert into PARAM_FACTURACION
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('CALCULO_CUENTA_A_FACTURAR', '1', 'Calcular y actualizar la cuenta contable de la línea a facturar');
Insert into PARAM_FACTURACION
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('VALIDA_LOTE_POS_Y_NEG', '0', 'AL FACTURAR UN LOTE VALIDAR QUE NO EXISTEN BORRADORES POSITIVOS Y NEGATIVOS');
Insert into PARAM_FACTURACION
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('CONF_MILLIS_REFRESH_ESTADO', '2000', 'tiempo de espera ante que ajax compruebe el cambio de porcentaje de un proceso de fact.');
Insert into PARAM_FACTURACION
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('CONF_PF_POR_DEF_SIMULACION', '|checked|||', 'conf. por defecto proceso fact simulado (batch|sim0|sim1|sim2|sim3) cada valor checked o vacío');
Insert into PARAM_FACTURACION
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('MULTI_LOTEFACT_EN_CONSTRUCCION', '1', 'Habilitar la posibilidad de crear más de un lote en construcción');
Insert into PARAM_FACTURACION
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('DESDE_FACT_DIRECTAMENTE_BORR', '1', 'Al cargar el tcon de Hechos Imponibles con una sola fila saltar al Mant. del Borrador');
Insert into PARAM_FACTURACION
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('FACTURAR_BORRADORES_IMP_CERO', '0', 'Crear las facturas para los borradores con importe total = 0');
Insert into PARAM_FACTURACION
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('FILTRO_ENCODING_REQUEST_IN', 'iso-8859-15', 'Encoding en entrada de la request');
Insert into PARAM_FACTURACION
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('SEMAFORO_FACTURACION', 'A', 'Semaforo de facturación');
Insert into PARAM_FACTURACION
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('AÑADIR_REVERSO_A_PDF_BORRADOR', '0', 'Añadir el reverso al pdf del borrador');
Insert into PARAM_FACTURACION
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('AÑADIR_REVERSO_A_PDF_FACTURA', '1', 'Añadir el reverso al pdf de la factura');
Insert into PARAM_FACTURACION
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('VIS_PREVIEW_PDF_ASP', '1', 'mostrar botón preview pdf en mantenimiento aspecto');
Insert into PARAM_FACTURACION
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('VIS_PLANTILLA_PDF_ASP', '1', 'mostrar botón Plantilla pdf en mantenimiento aspecto');
Insert into PARAM_FACTURACION
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('PROC_FACT_VALIDAR_NIF_CLIENTE', '0', 'Validar el nif/cif del cliente de un borrador en el proceso de facturación (esFacturable)');
Insert into PARAM_FACTURACION
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('VIS_GENERALES_ASP_CONF', '1', 'mostrar en pantalla configuración aspecto el bloque ''Generales''');
Insert into PARAM_FACTURACION
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('SEMAFORO_NOTIFICACION', 'A', 'SEMAFORO_NOTIFICACION');
Insert into PARAM_FACTURACION
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('ENCODING_TYPE_PDF_', 'N.A.', 'Encoding pdf (''N.A.'' si No se debe Aplicar)');
Insert into PARAM_FACTURACION
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('FILTRO_ENCODING_REQUEST_OUT_', 'N.A.', 'Encoding en salida de la request (''N.A.'' si No se debe Aplicar)');
Insert into PARAM_FACTURACION
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('FILTRO_ENCODING_RESPONSE_OUT_', 'N.A.', 'Encoding en salida de la response (''N.A.'' si No se debe Aplicar)');
Insert into PARAM_FACTURACION
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('FILTRO_ENCODING_RESPONSE_IN_', 'N.A.', 'Encoding en entrada de la response (''N.A.'' si No se debe Aplicar)');
Insert into PARAM_FACTURACION
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('FILTRO_ENCODING_FORMULARIO_', 'N.A.', 'Encoding formulario (''N.A.'' si No se debe Aplicar)');
Insert into PARAM_FACTURACION
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('SPECIAL_EURO_COD_CONVERSION1_', 'N.A.', 'código para conversion simbolo EURO (''N.A.'' si No se debe Aplicar)');
Insert into PARAM_FACTURACION
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('SPECIAL_EURO_COD_CONVERSION2_', 'N.A.', 'código para conversion simbolo EURO (''N.A.'' si No se debe Aplicar)');
Insert into PARAM_FACTURACION
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('ENCODING_RESULTSET_', 'N.A.', 'xxxx (''N.A.'' si No se debe Aplicar)');
Insert into PARAM_FACTURACION
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('PROCESO_FACT_PATH_ALHAMBRA2', 'D:\tmp\alhambra', 'Path destino fichero xml alhambra para entorno desarrollo');
Insert into PARAM_FACTURACION
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('PROCESO_FACT_PATH_SEDE_ELECTR2', 'D:\tmp\sede', 'Path destino fichero xml sede electrónica para entorno desarrollo');
Insert into PARAM_FACTURACION
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('PROCESO_FACT_PATH_ALHAMBRA', '/log/alhambra', 'Path destino fichero xml alhambra');
Insert into PARAM_FACTURACION
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('PROCESO_FACT_PATH_SEDE_ELECTRO', '/log/sede', 'Path destino fichero xml sede electrónica');
Insert into PARAM_FACTURACION
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('VALIDAR_CUENTA_CONTABLE', '0', 'Validar cuenta contable de usuario en el proceso de facturación');
Insert into PARAM_FACTURACION
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('SINCRONIZAR_NAVISION', '1', ' Indica si se registrará la sincronización de datos para integración con Navision');
Insert into PARAM_FACTURACION
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('SINCRONIZAR_NAVISION_PKANUL', '0', 'sinc. de datos de la FACTURA para int con Navision a modificar la fk a la factura de anulación');
Insert into PARAM_FACTURACION
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('SINCRONIZAR_NAVISION_PKNOTIF', '0', 'sinc. de datos de la FACTURA para int. con Navision a modificar la fk a la notificación');
Insert into PARAM_FACTURACION
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('PDFVALORADAS_IMPORTE_BORRADOR', '0', 'Obtener los importes para el pdf de valoradas del borrador. Por defecto se obtiene de factura');
Insert into PARAM_FACTURACION
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('IMAGEN_FIRMA_1_POR_DEFECTO', 'firmaDirector.png', 'Imagen por defecto para la firma 1 del pdf factura, si N.A. se usará el val. definido en Mes.res.');
Insert into PARAM_FACTURACION
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('ETIQUETA_FIRMA_1_POR_DEFECTO', 'Insertar Nombre Director', 'Etiqueta por defecto para la firma 1 del pdf factura, si N.A. se usará el val. definido en Mes.res.');
Insert into PARAM_FACTURACION
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('AÑADIR_PDF_NOTIF_ELECTR_A_COL', '0', 'Añadir el pdf de notificaciones Electrónicas al pdf colectivo de generadas');
Insert into PARAM_FACTURACION
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('PROCESO_NOTIF_SERIES_EXCLUIR', 'N.A.', 'Series de facturas a excluir en el proceso de notificación');
Insert into PARAM_FACTURACION
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('PROCESO_FACT_SERIES_EXCLUIR', 'N.A.', 'Series de facturas a excluir del PDF en el proceso de facturación');
Insert into PARAM_FACTURACION
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('PROCESO_NOTIF_INCLUIR_ANULADAS', '0', 'Incluir las facturas anuladas en el proceso de notificación');
Insert into PARAM_FACTURACION
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('PROCESO_FACTURACION_MODO_BATCH', '0', 'el Proceso de facturación se ejecuta en un bacth externo a la aplicación');
Insert into PARAM_FACTURACION
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('FECHA_MAX_FACTURACION_AÑO_ANT', '31/12', 'Fecha (día/mes año actual) máxima para permitir la facturación por el año anterior');
Insert into PARAM_FACTURACION
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('FECHA_LIMITE_FACTURACION', '31/12/2016', 'Fecha limite de facturacion');
Insert into PARAM_FACTURACION
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('LIMITES_AGRUP_FACT_NOTIF_TIPO', 'N.A.', 'max facturas en una notificación por tipo. formato: tipo1|max1@tipo2|max2@... (''N.A.'' si No se debe)');
Insert into PARAM_FACTURACION
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('TRASPASO_SEDE_FACTURAE_FIRMADO', '0', 'Se debe firmar el facturae a starpasar a Sede');
Insert into PARAM_FACTURACION
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('AÑADIR_REVERSO_A_PDF_NOTIF', '0', 'Añadir el reverso al pdf de la notificación');
Insert into PARAM_FACTURACION
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('OCULTAR_IMP_REL_NOTMEDIO_NO_EL', '0', 'Ocultar la col. ''Importe'' en el pdf de ''LISTADO NOTIFICACIONES POR TIPO'' para las notif. no Electrón');
Insert into PARAM_FACTURACION
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('PUERTOAPAC_DESDE_SDIVERSO', '0', 'Puerto apac se rellenará desde s.diverso (1 Se aplica; 0 No se aplica)');
Insert into PARAM_FACTURACION
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('APLICA_2453_SERV_MARITIMO', '1', 'Aplicar Bonificaciones 2453 si lleva asociado Servicio Maritimo (1 Se aplica; 0 no se aplica)');
Insert into PARAM_FACTURACION
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('APLICA_B3_GENERICA', '0', 'Aplicar B3-00-0000 (1 Se aplica; 0 No se aplica)');
Insert into PARAM_FACTURACION
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('APLICA_2453_NIVEL_TRAMO', '0', 'Aplicar Bonificaciones 2453  a Nivel de Tramo obtenidas de la tabla LQ_PARAMCODARAN2453 (1 Se aplica');
COMMIT;
