SET DEFINE OFF;
Insert into DP_ESTADOEXPEDIENTE
   (CODIGO, DESCRIPCION)
 Values
   ('OT', 'Previo a explotación');
Insert into DP_ESTADOEXPEDIENTE
   (CODIGO, DESCRIPCION)
 Values
   ('FI', 'Finalizado');
Insert into DP_ESTADOEXPEDIENTE
   (CODIGO, DESCRIPCION)
 Values
   ('NO', 'En explotación');
Insert into DP_ESTADOEXPEDIENTE
   (CODIGO, DESCRIPCION)
 Values
   ('EX', 'Extinguido anticipadamente');
COMMIT;
