SET DEFINE OFF;
Insert into DP_TIPOINCIDENCIA
   (CODIGO, DESCRIPCION, USRALTA, USRMODIF, FECALTA, FECMODIF)
 Values
   (2, 'Segregación de la concesión', 'prueba', 'prueba', TO_DATE('04/20/2015 08:43:40', 'MM/DD/YYYY HH24:MI:SS'), 
    TO_DATE('11/11/2015 12:56:11', 'MM/DD/YYYY HH24:MI:SS'));
Insert into DP_TIPOINCIDENCIA
   (CODIGO, DESCRIPCION, USRALTA, USRMODIF, FECALTA, FECMODIF)
 Values
   (1, 'Tipo interno', 'prueba', 'prueba', TO_DATE('04/16/2015 13:10:30', 'MM/DD/YYYY HH24:MI:SS'), 
    TO_DATE('04/16/2015 13:10:30', 'MM/DD/YYYY HH24:MI:SS'));
COMMIT;
