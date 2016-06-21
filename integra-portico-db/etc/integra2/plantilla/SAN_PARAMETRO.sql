SET DEFINE OFF;
Insert into SAN_PARAMETRO
   (CODPARAMETRO, VALOR, COMENTARIO)
 Values
   ('BOLETIN_NUMDIASDTO', '20', 'N� dias de plazo para pagar con descuento a partir de la fecha del bolet�n');
Insert into SAN_PARAMETRO
   (CODPARAMETRO, VALOR, COMENTARIO)
 Values
   ('INIEXP_NUMDIASDTO', '15', 'N� dias de plazo para pagar con descuento o para presentar alegaciones a partir de la fecha de inicio de expediente');
Insert into SAN_PARAMETRO
   (CODPARAMETRO, VALOR, COMENTARIO)
 Values
   ('PRORES_NUMDIASALEG', '20', 'N� dias de plazo para presentar alegaciones a partir de la fecha de inicio de expediente');
Insert into SAN_PARAMETRO
   (CODPARAMETRO, VALOR, COMENTARIO)
 Values
   ('REDUCCIONPRONTOPAGO', '50', '% de descuento a aplicar cuando pagan antes de la fecha l�mite');
Insert into SAN_PARAMETRO
   (CODPARAMETRO, VALOR, COMENTARIO)
 Values
   ('PUBINI_NUMDIAS', '60', 'N� dias de plazo para la publicaci�n de la resoluci�n');
Insert into SAN_PARAMETRO
   (CODPARAMETRO, VALOR, COMENTARIO)
 Values
   ('PUBRES_NUMDIAS', '60', 'N� dias de plazo para el env�o a apremio');
COMMIT;
