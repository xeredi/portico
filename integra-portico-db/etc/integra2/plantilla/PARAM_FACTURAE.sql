SET DEFINE OFF;
Insert into PARAM_FACTURAE
   (CODIGO, DESCRIPCION, VALOR)
 Values
   ('XMLFILEPATH', 'Ruta de almacenamiento del XML FACTURA-E', '/opt/procesos-BATCH/facturae');
Insert into PARAM_FACTURAE
   (CODIGO, DESCRIPCION, VALOR)
 Values
   ('MAILSUBJECT', 'Titulo del correo electr�nico', 'Facturae');
Insert into PARAM_FACTURAE
   (CODIGO, DESCRIPCION, VALOR)
 Values
   ('MAILBODY', 'Cuerpo del correo electr�nico', 'Adjunto el XML firmado de la factura...');
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
   ('SCHEMAVERSION', 'Versi�n del XML FACTURA-E', '3.2');
Insert into PARAM_FACTURAE
   (CODIGO, DESCRIPCION, VALOR)
 Values
   ('PERSONTYPECODE', 'C�digo tipo de persona J (Jur�dica) | F (F�sica)', 'J');
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
   ('APDIRECCION', 'Direcci�n Autoridad Portuaria', 'Pla�a Joan de Vila-rasa n�14-5');
Insert into PARAM_FACTURAE
   (CODIGO, DESCRIPCION, VALOR)
 Values
   ('APCP', 'C�digo Postal Autoridad Portuaria', '46001');
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
   ('APCODIGOPAIS', 'C�digo Pa�s Autoridad Portuaria', 'ESP');
Insert into PARAM_FACTURAE
   (CODIGO, DESCRIPCION, VALOR)
 Values
   ('ATTACHMENT', 'Factura Integrados', 'Factura Integrados');
COMMIT;
