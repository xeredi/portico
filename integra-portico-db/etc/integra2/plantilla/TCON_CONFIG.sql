SET DEFINE OFF;
Insert into TCON_CONFIG
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('AGRUPARACCIONES', '1', 'Indica si se agrupan las acciones. Valores 1 ó 0');
Insert into TCON_CONFIG
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('BOTONPDF', '0', 'Indica si se muestra el botón de exportar a pdf en los tcon');
Insert into TCON_CONFIG
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('TIPOFILTRO', 'NUEVO', 'Indica si se muestra la pantalla de filtro nueva');
Insert into TCON_CONFIG
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('TIPOBUSQUEDARAPIDA', 'ELEGIDAS', 'Indica si se usan TODOS o solo las ELEGIDAS para la búsqueda rápida');
Insert into TCON_CONFIG
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('NUM_MAX_ROWS_TCON', '20', 'Indica el número de registros por página que se muestran en el tcon');
Insert into TCON_CONFIG
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('NUM_MAX_ROWS_EXCEL', '100000', 'Indica el número de registros máximo que se pueden exportar a excel');
Insert into TCON_CONFIG
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('NUM_MAX_ROWS_PDF', '100000', 'Indica el número de registros máximo que se pueden exportar a pdf');
Insert into TCON_CONFIG
   (CODIGO, VALOR, COMENTARIO)
 Values
   ('BOTONTOTALIZAR', '0', 'Indica si se muestra el botón de totalizar una columna en los tcon');
COMMIT;
