SET DEFINE OFF;
Insert into PARAM_FACTURAE
   (CODIGO, DESCRIPCION, VALOR)
 Values
   ('XMLFILEPATH', 'Ruta de almacenamiento del XML FACTURA-E', '/opt/procesos-BATCH/facturae');
Insert into PARAM_FACTURAE
   (CODIGO, DESCRIPCION, VALOR)
 Values
   ('MAILSUBJECT', 'Titulo del correo electrónico', 'Facturae');
Insert into PARAM_FACTURAE
   (CODIGO, DESCRIPCION, VALOR)
 Values
   ('MAILBODY', 'Cuerpo del correo electrónico', 'Adjunto el XML firmado de la factura...');
Insert into PARAM_FACTURAE
   (CODIGO, DESCRIPCION, VALOR)
 Values
   ('APERAKFILEPATH', 'Ruta de almacenamiento del APERAK de FACTURA-E', '/opt/procesos-BATCH/facturae/aperak');
Insert into PARAM_FACTURAE
   (CODIGO, DESCRIPCION, VALOR)
 Values
   ('FILEHEADER', 'Cabecera del XML FACTURA-E', '<?xml version="1.0" encoding="UTF-8"?><fe:Facturaexmlns:ds="http://www.w3.org/2000/09/xmldsig#"xmlns:fe="http://www.facturae.es/Facturae/2009/v3.2/Facturae">');
Insert into PARAM_FACTURAE
   (CODIGO, DESCRIPCION, VALOR)
 Values
   ('SCHEMAVERSION', 'Versión del XML FACTURA-E', '3.2');
Insert into PARAM_FACTURAE
   (CODIGO, DESCRIPCION, VALOR)
 Values
   ('PERSONTYPECODE', 'Código tipo de persona J (Jurídica) | F (Física)', 'J');
Insert into PARAM_FACTURAE
   (CODIGO, DESCRIPCION, VALOR)
 Values
   ('APCIF', 'CIF Autoridad Portuaria', 'Inserte el CIF');
Insert into PARAM_FACTURAE
   (CODIGO, DESCRIPCION, VALOR)
 Values
   ('APNOMBRE', 'Nombre Autoridad Portuaria', 'Autoridad Portuaria de Prodevelop');
Insert into PARAM_FACTURAE
   (CODIGO, DESCRIPCION, VALOR)
 Values
   ('APDIRECCION', 'Dirección Autoridad Portuaria', 'Plaça Joan de Vila-rasa nº14-5');
Insert into PARAM_FACTURAE
   (CODIGO, DESCRIPCION, VALOR)
 Values
   ('APCP', 'Código Postal Autoridad Portuaria', '46001');
Insert into PARAM_FACTURAE
   (CODIGO, DESCRIPCION, VALOR)
 Values
   ('APCIUDAD', 'Ciudad Autoridad Portuaria', 'Valencia');
Insert into PARAM_FACTURAE
   (CODIGO, DESCRIPCION, VALOR)
 Values
   ('APPROVINCIA', 'Provincia Autoridad Portuaria', 'Valencia');
Insert into PARAM_FACTURAE
   (CODIGO, DESCRIPCION, VALOR)
 Values
   ('APCODIGOPAIS', 'Código País Autoridad Portuaria', 'ESP');
Insert into PARAM_FACTURAE
   (CODIGO, DESCRIPCION, VALOR)
 Values
   ('ATTACHMENT', 'Factura Integrados', 'Factura Integrados');
COMMIT;
