SET DEFINE OFF;
Insert into DP_TIPORANGOUNIDADES
   (CODIGO, DESCRIPCION)
 Values
   ('0', 'Valor unidad constante, sin rangos');
Insert into DP_TIPORANGOUNIDADES
   (CODIGO, DESCRIPCION)
 Values
   ('1', 'Valor unidad var�a a medida que se superan rangos');
Insert into DP_TIPORANGOUNIDADES
   (CODIGO, DESCRIPCION)
 Values
   ('2', 'Valor unidad var�a seg�n el rango en que se encuentre tr�fico movido final');
COMMIT;
