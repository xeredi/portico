SET DEFINE OFF;
Insert into EST_GRUPO_NATURALEZA
   (CODIGO, DESCRIPCION)
 Values
   ('1', 'Energético');
Insert into EST_GRUPO_NATURALEZA
   (CODIGO, DESCRIPCION, USRMODIF, FECMODIF)
 Values
   ('4', 'Abonos', 'prueba', TO_DATE('05/15/2014 14:46:54', 'MM/DD/YYYY HH24:MI:SS'));
Insert into EST_GRUPO_NATURALEZA
   (CODIGO, DESCRIPCION)
 Values
   ('5', 'Químicos');
Insert into EST_GRUPO_NATURALEZA
   (CODIGO, DESCRIPCION)
 Values
   ('6', 'Material de construcción');
Insert into EST_GRUPO_NATURALEZA
   (CODIGO, DESCRIPCION)
 Values
   ('7', 'Agro-ganadero y alimentario');
Insert into EST_GRUPO_NATURALEZA
   (CODIGO, DESCRIPCION)
 Values
   ('8', 'Otras mercancías');
Insert into EST_GRUPO_NATURALEZA
   (CODIGO, DESCRIPCION, USRMODIF, FECMODIF)
 Values
   ('9', 'Vehículos y elementos de transporte', 'prueba', TO_DATE('05/13/2014 15:48:44', 'MM/DD/YYYY HH24:MI:SS'));
Insert into EST_GRUPO_NATURALEZA
   (CODIGO, DESCRIPCION)
 Values
   ('10', 'Siderometalúrgico');
Insert into EST_GRUPO_NATURALEZA
   (CODIGO, DESCRIPCION)
 Values
   ('11', 'Minerales no metálicos');
COMMIT;
