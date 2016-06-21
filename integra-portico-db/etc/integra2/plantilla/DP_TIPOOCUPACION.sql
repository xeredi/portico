SET DEFINE OFF;
Insert into DP_TIPOOCUPACION
   (CODIGO, DESCRIPCION, INDVT, INDLA, INDIN, INDDP, BAJA)
 Values
   (1, '175.a) Ocupación terrenos', '1', '0', '0', 
    '0', '0');
Insert into DP_TIPOOCUPACION
   (CODIGO, DESCRIPCION, INDVT, INDLA, INDIN, INDDP, BAJA)
 Values
   (2, '175.b) Ocupación aguas del puerto', '0', '1', '0', 
    '0', '0');
Insert into DP_TIPOOCUPACION
   (CODIGO, DESCRIPCION, INDVT, INDLA, INDIN, INDDP, BAJA)
 Values
   (3, '175.c) Ocupación obras e instalaciones', '1', '0', '1', 
    '1', '0');
Insert into DP_TIPOOCUPACION
   (CODIGO, DESCRIPCION, INDVT, INDLA, INDIN, INDDP, BAJA)
 Values
   (4, '175.d) Uso consuntivo', '0', '0', '0', 
    '0', '1');
Insert into DP_TIPOOCUPACION
   (CODIGO, DESCRIPCION, INDVT, INDLA, INDIN, INDDP, BAJA)
 Values
   (5, 'Aparcamiento', '1', '0', '0', 
    '0', '1');
COMMIT;
