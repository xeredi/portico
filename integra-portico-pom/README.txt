REQUISITOS SOFTWARE
-------------------

- Gestor de B.D. (Oracle, DQL Server o PostgreSQL)
- Servidor de aplicaciones JEE/J2EE (Weblogic, JBoss, Tomcat, Jetty)

INSTALACION
-----------

Uso de Maven para instalar la aplicación. Ejecutar:

- Compilación:
	$ mvn [-P unPerfil] compile

	Compila los fuentes de la aplicación de cada uno de los módulos de la aplicación

- Creación del desplegable
	$ mvn [-P unPerfil] install

	Genera el desplegable de la aplicación J2EE (archivo war) en la carpeta 'argo-web/target/[unPerfil]'
	Dicho war ha de ser desplegado en el servidor de aplicaciones.

- Creación de la documentación
	$ mvn [-P unPerfil] site site:deploy

	La documentación se despliega en la carpeta "${user_home}/proyectos/deploy/site/argo"
	Dentro de dicha carpeta, en "argo-pom/index.html" se encuentra la página de inicio de la documentación generada.


MODULOS
-------

- argo-db
	Contiene los scripts de creación de la B.D.

- argo-persistence
	Contiene la capa de persistencia de la aplicación

	En la carpeta target se generan los binarios

- argo-business
	Contiene la capa de negocio de la aplicación

	En la carpeta target se generan los binarios

- argo-jobs
	Contiene la capa de procesos en segundo plano de la aplicación.

	En la carpeta target se generan los binarios

- argo-web
	Contiene la capa de presentación de la aplicación.

	En la carpeta target se generan los binarios

- argo-test
	Contiene los casos de prueba de la aplicación.