SET DEFINE OFF;
Insert into LQ_ESCALA_COEFENTRADA
   (CODIGO, FECINIVIG, RANGOINI, RANGOFIN, VALOR, VALOREGULAR)
 Values
   (1, TO_DATE('01/01/2010 00:00:00', 'MM/DD/YYYY HH24:MI:SS'), 1, 12, 
    1, 0.95);
Insert into LQ_ESCALA_COEFENTRADA
   (CODIGO, FECINIVIG, RANGOINI, RANGOFIN, VALOR, VALOREGULAR)
 Values
   (2, TO_DATE('01/01/2010 00:00:00', 'MM/DD/YYYY HH24:MI:SS'), 13, 26, 
    0.95, 0.9);
Insert into LQ_ESCALA_COEFENTRADA
   (CODIGO, FECINIVIG, RANGOINI, RANGOFIN, VALOR, VALOREGULAR)
 Values
   (3, TO_DATE('01/01/2010 00:00:00', 'MM/DD/YYYY HH24:MI:SS'), 27, 52, 
    0.85, 0.8);
Insert into LQ_ESCALA_COEFENTRADA
   (CODIGO, FECINIVIG, RANGOINI, RANGOFIN, VALOR, VALOREGULAR)
 Values
   (4, TO_DATE('01/01/2010 00:00:00', 'MM/DD/YYYY HH24:MI:SS'), 53, 104, 
    0.75, 0.7);
Insert into LQ_ESCALA_COEFENTRADA
   (CODIGO, FECINIVIG, RANGOINI, RANGOFIN, VALOR, VALOREGULAR)
 Values
   (5, TO_DATE('01/01/2010 00:00:00', 'MM/DD/YYYY HH24:MI:SS'), 105, 156, 
    0.65, 0.6);
Insert into LQ_ESCALA_COEFENTRADA
   (CODIGO, FECINIVIG, RANGOINI, RANGOFIN, VALOR, VALOREGULAR)
 Values
   (6, TO_DATE('01/01/2010 00:00:00', 'MM/DD/YYYY HH24:MI:SS'), 157, 312, 
    0.55, 0.5);
Insert into LQ_ESCALA_COEFENTRADA
   (CODIGO, FECINIVIG, RANGOINI, RANGOFIN, VALOR, VALOREGULAR)
 Values
   (7, TO_DATE('01/01/2010 00:00:00', 'MM/DD/YYYY HH24:MI:SS'), 313, 365, 
    0.45, 0.4);
Insert into LQ_ESCALA_COEFENTRADA
   (CODIGO, FECINIVIG, RANGOINI, VALOR, VALOREGULAR)
 Values
   (8, TO_DATE('01/01/2010 00:00:00', 'MM/DD/YYYY HH24:MI:SS'), 366, 0.35, 0.3);
COMMIT;
