INSTALACION
-----------

Uso de Maven para instalar la aplicación. Ejecutar:

- Compilación:
	$ mvn [-P unPerfil] compile

	Compila los fuentes de la aplicación de cada uno de los módulos de la aplicación

- Creación del desplegable
	$ mvn [-P unPerfil] install

	Genera el desplegable de la aplicación J2EE (archivo war) en la carpeta 'argo-web/target/[unPerfil]'

- Creación de la documentación
	$ mvn [-P unPerfil] site site:deploy
