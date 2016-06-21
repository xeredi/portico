SET DEFINE OFF;
Insert into TIPO_CONTRASTEBUQUE
   (CODTIPCONTRASTE, DESCRIPCION)
 Values
   ('011', 'No declarado código PORTEL naviera');
Insert into TIPO_CONTRASTEBUQUE
   (CODTIPCONTRASTE, DESCRIPCION)
 Values
   ('001', 'No existe el buque en APSCT');
Insert into TIPO_CONTRASTEBUQUE
   (CODTIPCONTRASTE, DESCRIPCION)
 Values
   ('002', 'No coincide el GT declarado con el del maestro APSCT');
Insert into TIPO_CONTRASTEBUQUE
   (CODTIPCONTRASTE, DESCRIPCION)
 Values
   ('003', 'Buque asociado a servicio maritimo sin declarar');
Insert into TIPO_CONTRASTEBUQUE
   (CODTIPCONTRASTE, DESCRIPCION)
 Values
   ('004', 'Puertos no asociados al servicio maritimo declarado');
Insert into TIPO_CONTRASTEBUQUE
   (CODTIPCONTRASTE, DESCRIPCION)
 Values
   ('005', 'Escala no internacional pero puertos canarios');
Insert into TIPO_CONTRASTEBUQUE
   (CODTIPCONTRASTE, DESCRIPCION)
 Values
   ('006', 'Buque no asociado al servicio maritimo declarado');
Insert into TIPO_CONTRASTEBUQUE
   (CODTIPCONTRASTE, DESCRIPCION)
 Values
   ('007', 'La naviera del buque no asociada al servicio maritimo');
Insert into TIPO_CONTRASTEBUQUE
   (CODTIPCONTRASTE, DESCRIPCION)
 Values
   ('009', 'Pendiente asignación tipo tráfico');
Insert into TIPO_CONTRASTEBUQUE
   (CODTIPCONTRASTE, DESCRIPCION)
 Values
   ('010', 'Código PORTEL no existe en maestro APSCT');
Insert into TIPO_CONTRASTEBUQUE
   (CODTIPCONTRASTE, DESCRIPCION)
 Values
   ('008', 'No coincide el tipo de buque declarado con el del maestro APSCT');
COMMIT;
