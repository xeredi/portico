SET DEFINE OFF;
Insert into SAN_PARAMETRO
   (CODPARAMETRO, VALOR, COMENTARIO)
 Values
   ('BOLETIN_NUMDIASDTO', '20', 'Nº dias de plazo para pagar con descuento a partir de la fecha del boletín');
Insert into SAN_PARAMETRO
   (CODPARAMETRO, VALOR, COMENTARIO)
 Values
   ('INIEXP_NUMDIASDTO', '15', 'Nº dias de plazo para pagar con descuento o para presentar alegaciones a partir de la fecha de inicio de expediente');
Insert into SAN_PARAMETRO
   (CODPARAMETRO, VALOR, COMENTARIO)
 Values
   ('PRORES_NUMDIASALEG', '20', 'Nº dias de plazo para presentar alegaciones a partir de la fecha de inicio de expediente');
Insert into SAN_PARAMETRO
   (CODPARAMETRO, VALOR, COMENTARIO)
 Values
   ('REDUCCIONPRONTOPAGO', '50', '% de descuento a aplicar cuando pagan antes de la fecha límite');
Insert into SAN_PARAMETRO
   (CODPARAMETRO, VALOR, COMENTARIO)
 Values
   ('PUBINI_NUMDIAS', '60', 'Nº dias de plazo para la publicación de la resolución');
Insert into SAN_PARAMETRO
   (CODPARAMETRO, VALOR, COMENTARIO)
 Values
   ('PUBRES_NUMDIAS', '60', 'Nº dias de plazo para el envío a apremio');
COMMIT;
