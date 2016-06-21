SET DEFINE OFF;
Insert into PARAM_DOCUMENTOS
   (CODIGO, DESCRIPCION, VALOR)
 Values
   ('ALMACENAMIENTO', 'Para indicar si almacenamos el fichero en Sistema Ficheros o Gestor Documental. Para Sistema ficheros grabar 1. Para Gestor Documental grabar 2.', '1');
Insert into PARAM_DOCUMENTOS
   (CODIGO, DESCRIPCION, VALOR)
 Values
   ('RUTAFICHEROS', 'Si funcionamos con sistema de ficheros, indicar� la ruta de ficheros (remota o local) donde se almacenar� el documento', '/log/doc/');
Insert into PARAM_DOCUMENTOS
   (CODIGO, DESCRIPCION, VALOR)
 Values
   ('TAMMAXIMOFICHERO', 'Tama�o m�ximo en bytes, del fichero a almacenar', '10000000');
Insert into PARAM_DOCUMENTOS
   (CODIGO, DESCRIPCION, VALOR)
 Values
   ('ALFRESCO_URL', 'Url servidor Alfresco', 'http://benin.prodevelop.es:8080');
Insert into PARAM_DOCUMENTOS
   (CODIGO, DESCRIPCION, VALOR)
 Values
   ('ALFRESCO_USU', 'Usuario Alfresco', 'pcellini');
Insert into PARAM_DOCUMENTOS
   (CODIGO, DESCRIPCION, VALOR)
 Values
   ('ALFRESCO_PWD', 'Contrase�a Alfresco', 'pcellini');
Insert into PARAM_DOCUMENTOS
   (CODIGO, DESCRIPCION, VALOR)
 Values
   ('ALFRESCO_SITIO', 'Repository Alfresco (''posidonia-management'')', 'posidonia-management');
Insert into PARAM_DOCUMENTOS
   (CODIGO, DESCRIPCION, VALOR)
 Values
   ('ALFRESCO_ENDPOINT', 'End Point del servicio Web de Alfresco', 'http://benin.prodevelop.es:8080/PosidoniaManagementWS/services/AlfrescoUtilsImpl');
COMMIT;
