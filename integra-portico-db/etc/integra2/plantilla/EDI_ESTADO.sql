SET DEFINE OFF;
Insert into EDI_ESTADO
   (IDESTADO, DESESTADO, USRALTA, FECALTA)
 Values
   (4, 'Pendiente Generar', 'SISTEMA', TO_DATE('09/01/2014 00:00:00', 'MM/DD/YYYY HH24:MI:SS'));
Insert into EDI_ESTADO
   (IDESTADO, DESESTADO, USRALTA, FECALTA)
 Values
   (5, 'Generado', 'SISTEMA', TO_DATE('09/01/2014 00:00:00', 'MM/DD/YYYY HH24:MI:SS'));
Insert into EDI_ESTADO
   (IDESTADO, DESESTADO, USRALTA, FECALTA)
 Values
   (6, 'Enviado', 'SISTEMA', TO_DATE('09/01/2014 00:00:00', 'MM/DD/YYYY HH24:MI:SS'));
Insert into EDI_ESTADO
   (IDESTADO, DESESTADO, USRALTA, FECALTA)
 Values
   (7, 'Error Envio', 'SISTEMA', TO_DATE('09/01/2014 00:00:00', 'MM/DD/YYYY HH24:MI:SS'));
Insert into EDI_ESTADO
   (IDESTADO, DESESTADO, USRALTA, FECALTA)
 Values
   (9, 'Paolo', 'SISTEMA', TO_DATE('01/01/2015 00:00:00', 'MM/DD/YYYY HH24:MI:SS'));
Insert into EDI_ESTADO
   (IDESTADO, DESESTADO, USRALTA, FECALTA)
 Values
   (1, 'Pendiente de Procesar', 'SISTEMA', TO_DATE('09/01/2014 00:00:00', 'MM/DD/YYYY HH24:MI:SS'));
Insert into EDI_ESTADO
   (IDESTADO, DESESTADO, USRALTA, FECALTA)
 Values
   (2, 'Aceptado', 'SISTEMA', TO_DATE('09/01/2014 00:00:00', 'MM/DD/YYYY HH24:MI:SS'));
Insert into EDI_ESTADO
   (IDESTADO, DESESTADO, USRALTA, FECALTA)
 Values
   (3, 'Con Errores', 'prueba', TO_DATE('09/01/2014 00:00:00', 'MM/DD/YYYY HH24:MI:SS'));
Insert into EDI_ESTADO
   (IDESTADO, DESESTADO, USRALTA, FECALTA)
 Values
   (0, 'Error Interno Circuito', 'SISTEMA', TO_DATE('07/01/2015 00:00:00', 'MM/DD/YYYY HH24:MI:SS'));
COMMIT;