SET DEFINE OFF;
Insert into G3_SITEMBARQUE
   (CODIGO, DESCRIPCION)
 Values
   ('T', 'Se ha embarcado la totalidad de la mercancía, bultos y equipamiento comprendidos en el documento de despacho');
Insert into G3_SITEMBARQUE
   (CODIGO, DESCRIPCION)
 Values
   ('P', 'Se ha embarcado parte de la mercancía, bultos y equipamiento comprendidos en el documento de despacho');
Insert into G3_SITEMBARQUE
   (CODIGO, DESCRIPCION)
 Values
   ('R', 'Se ha embarcado el resto de un embarque parcial anterior');
COMMIT;
