SET DEFINE OFF;
Insert into GU_SUBSISTEMA
   (CODSUB, DESSUB, BAJA)
 Values
   ('DIV', 'Servicios diversos', '0');
Insert into GU_SUBSISTEMA
   (CODSUB, DESSUB, BAJA)
 Values
   ('CON', 'Suministros', '0');
Insert into GU_SUBSISTEMA
   (CODSUB, DESSUB, BAJA)
 Values
   ('FAC', 'Facturación', '0');
Insert into GU_SUBSISTEMA
   (CODSUB, DESSUB, BAJA)
 Values
   ('OCU', 'Ocupación superficie zona tránsito-almacenamiento', '0');
Insert into GU_SUBSISTEMA
   (CODSUB, DESSUB, BAJA)
 Values
   ('EDR', 'EDR', '0');
Insert into GU_SUBSISTEMA
   (CODSUB, DESSUB, BAJA)
 Values
   ('PES', 'Pesca', '0');
Insert into GU_SUBSISTEMA
   (CODSUB, DESSUB, BAJA)
 Values
   ('ADM', 'Administracion', '0');
Insert into GU_SUBSISTEMA
   (CODSUB, DESSUB, BAJA)
 Values
   ('MAE', 'Tablas Maestras', '0');
Insert into GU_SUBSISTEMA
   (CODSUB, DESSUB, BAJA)
 Values
   ('DP', 'Dominio Publico', '0');
Insert into GU_SUBSISTEMA
   (CODSUB, DESSUB, BAJA)
 Values
   ('ESC', 'Escalas', '0');
Insert into GU_SUBSISTEMA
   (CODSUB, DESSUB, BAJA)
 Values
   ('MER', 'Mercancías', '0');
Insert into GU_SUBSISTEMA
   (CODSUB, DESSUB, BAJA)
 Values
   ('HGE', 'Herramientas Generales', '0');
Insert into GU_SUBSISTEMA
   (CODSUB, DESSUB, BAJA)
 Values
   ('EDI', 'Gestión Edi', '0');
Insert into GU_SUBSISTEMA
   (CODSUB, DESSUB, BAJA, FECBAJA)
 Values
   ('SAN', 'Sanciones', '1', TO_DATE('10/15/2014 14:58:05', 'MM/DD/YYYY HH24:MI:SS'));
Insert into GU_SUBSISTEMA
   (CODSUB, DESSUB, BAJA, FECBAJA)
 Values
   ('NOT', 'Notificación', '1', TO_DATE('03/05/2015 12:30:05', 'MM/DD/YYYY HH24:MI:SS'));
Insert into GU_SUBSISTEMA
   (CODSUB, DESSUB, BAJA, FECBAJA)
 Values
   ('CEN', 'Censo', '1', TO_DATE('03/05/2015 15:52:26', 'MM/DD/YYYY HH24:MI:SS'));
Insert into GU_SUBSISTEMA
   (CODSUB, DESSUB, BAJA)
 Values
   ('AUD', 'Gestión Trazabilidad', '0');
Insert into GU_SUBSISTEMA
   (CODSUB, DESSUB, BAJA)
 Values
   ('GDO', 'Gestor Documental', '0');
Insert into GU_SUBSISTEMA
   (CODSUB, DESSUB, BAJA, FECBAJA)
 Values
   ('GIS', 'Gestión GIS', '1', TO_DATE('12/15/2015 00:00:00', 'MM/DD/YYYY HH24:MI:SS'));
Insert into GU_SUBSISTEMA
   (CODSUB, DESSUB, BAJA)
 Values
   ('GEN', 'General en toda la aplicación', '0');
Insert into GU_SUBSISTEMA
   (CODSUB, DESSUB, BAJA)
 Values
   ('MAQ', 'Servicios Maquinaria', '0');
COMMIT;
