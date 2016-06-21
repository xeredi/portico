SET DEFINE OFF;
Insert into TCON_CONFIG
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('AGRUPARACCIONES', '1', 'Indica si se agrupan las acciones. Valores 1 � 0');
Insert into TCON_CONFIG
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('BOTONPDF', '0', 'Indica si se muestra el bot�n de exportar a pdf en los tcon');
Insert into TCON_CONFIG
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('TIPOFILTRO', 'NUEVO', 'Indica si se muestra la pantalla de filtro nueva');
Insert into TCON_CONFIG
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('TIPOBUSQUEDARAPIDA', 'ELEGIDAS', 'Indica si se usan TODOS o solo las ELEGIDAS para la b�squeda r�pida');
Insert into TCON_CONFIG
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('NUM_MAX_ROWS_TCON', '20', 'Indica el n�mero de registros por p�gina que se muestran en el tcon');
Insert into TCON_CONFIG
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('NUM_MAX_ROWS_EXCEL', '100000', 'Indica el n�mero de registros m�ximo que se pueden exportar a excel');
Insert into TCON_CONFIG
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('NUM_MAX_ROWS_PDF', '100000', 'Indica el n�mero de registros m�ximo que se pueden exportar a pdf');
Insert into TCON_CONFIG
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('BOTONTOTALIZAR', '0', 'Indica si se muestra el bot�n de totalizar una columna en los tcon');
COMMIT;
