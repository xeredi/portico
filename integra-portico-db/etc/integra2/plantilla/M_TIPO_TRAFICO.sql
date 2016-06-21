SET DEFINE OFF;
Insert into M_TIPO_TRAFICO
   (CODIGO, DESCRIPCION, CODTIPFORMAPRESENT, INDRORO, CODTIPFORMAPRESENTFAC)
 Values
   ('02', 'Carga rodada', 'MG', '1', 'MG');
Insert into M_TIPO_TRAFICO
   (CODIGO, DESCRIPCION, CODTIPFORMAPRESENT, INDRORO, CODTIPFORMAPRESENTFAC)
 Values
   ('03', 'Contenedores', 'MG', '0', 'MG');
Insert into M_TIPO_TRAFICO
   (CODIGO, DESCRIPCION, CODTIPFORMAPRESENT, INDRORO, CODTIPFORMAPRESENTFAC)
 Values
   ('04', 'Contenedores y carga rodada', 'MG', '0', 'MG');
Insert into M_TIPO_TRAFICO
   (CODIGO, DESCRIPCION, CODTIPFORMAPRESENT, INDRORO, CODTIPFORMAPRESENTFAC)
 Values
   ('05', 'Graneles l�quidos', 'GL', '0', 'GL');
Insert into M_TIPO_TRAFICO
   (CODIGO, DESCRIPCION, CODTIPFORMAPRESENT, INDRORO, CODTIPFORMAPRESENTFAC)
 Values
   ('06', 'Graneles s�lidos', 'GS', '0', 'GS');
Insert into M_TIPO_TRAFICO
   (CODIGO, DESCRIPCION, CODTIPFORMAPRESENT, INDRORO, CODTIPFORMAPRESENTFAC)
 Values
   ('07', 'Hortofrut�colas', 'MG', '0', 'MG');
Insert into M_TIPO_TRAFICO
   (CODIGO, DESCRIPCION, CODTIPFORMAPRESENT, INDRORO, CODTIPFORMAPRESENTFAC)
 Values
   ('08', 'Pasaje en r�gimen cruceros', 'MG', '0', 'MG');
Insert into M_TIPO_TRAFICO
   (CODIGO, DESCRIPCION, CODTIPFORMAPRESENT, INDRORO, CODTIPFORMAPRESENTFAC)
 Values
   ('09', 'Pasaje en r�gimen transporte', 'MG', '0', 'MG');
Insert into M_TIPO_TRAFICO
   (CODIGO, DESCRIPCION, CODTIPFORMAPRESENT, INDRORO, CODTIPFORMAPRESENTFAC)
 Values
   ('10', 'Pasaje en r�gimen tranporte y carga rodada', 'MG', '1', 'MG');
Insert into M_TIPO_TRAFICO
   (CODIGO, DESCRIPCION, CODTIPFORMAPRESENT, INDRORO, CODTIPFORMAPRESENTFAC)
 Values
   ('11', 'Petr�leo', 'GL', '0', 'GL');
Insert into M_TIPO_TRAFICO
   (CODIGO, DESCRIPCION, CODTIPFORMAPRESENT, INDRORO, CODTIPFORMAPRESENTFAC)
 Values
   ('99', 'Otros', 'MG', '0', 'MG');
Insert into M_TIPO_TRAFICO
   (CODIGO, DESCRIPCION, CODTIPFORMAPRESENT, INDRORO, CODTIPFORMAPRESENTFAC)
 Values
   ('17', 'Avituallamiento exclusivo de combustible', 'GL', '0', 'GL');
Insert into M_TIPO_TRAFICO
   (CODIGO, DESCRIPCION, CODTIPFORMAPRESENT, INDRORO, CODTIPFORMAPRESENTFAC, OBSERVACIONES)
 Values
   ('24', 'Buques incativos, incluso pesqueros y artefactos flotantes', 
    'MG', '0', 'OT', '7�. Buques incativos, incluso pesqueros y artefactos flotantes 4,67');
Insert into M_TIPO_TRAFICO
   (CODIGO, DESCRIPCION, CODTIPFORMAPRESENT, INDRORO, CODTIPFORMAPRESENTFAC)
 Values
   ('01', 'Contenedores en tr�nsito mar�timo internacional', 'MG', '0', 'OT');
Insert into M_TIPO_TRAFICO
   (CODIGO, DESCRIPCION, CODTIPFORMAPRESENT, INDRORO, CODTIPFORMAPRESENTFAC)
 Values
   ('12', 'Interinsular', 'MG', '0', 'MG');
Insert into M_TIPO_TRAFICO
   (CODIGO, DESCRIPCION, CODTIPFORMAPRESENT, INDRORO, CODTIPFORMAPRESENTFAC)
 Values
   ('13', 'Carga Convencional', 'MG', '0', 'MG');
Insert into M_TIPO_TRAFICO
   (CODIGO, DESCRIPCION, CODTIPFORMAPRESENT, INDRORO, CODTIPFORMAPRESENTFAC, OBSERVACIONES)
 Values
   ('19', 'Gabarra de suministro de combustibles', 
    'GL', '0', 'OT', 'SPABUNKER');
COMMIT;
