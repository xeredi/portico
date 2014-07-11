Equivalencias de tipos de datos
-------------------------------

postgresql			oracle				sqlserver

BIGINT				NUMBER(19)			BIGINT
VARCHAR				VARCHAR2			VARCHAR
CHAR				CHAR				CHAR
TIMESTAMP			TIMESTAMP			DATETIME2
DOUBLE PRECISION	DOUBLE PRECISION	DOUBLE PRECISION


Esquemas de la BD 'portico'
---------------------------

Oracle
	porticoadm - Creador de las tablas/indices/funciones
		Da permisos de CRUD al usuario portico
		Crea sinonimos en el esquema portico
	portico - Usuario de las tablas/indices/funciones

SqlServer
	portico
		- El usuario porticoadm crea las tablas/indices/funciones
		- El usuario porticoadm Da permisos de CRUD al usuario portico

PostgreSQL
	portico
		- El usuario porticoadm crea las tablas/indices/funciones
		- El usuario porticoadm Da permisos de CRUD al usuario portico
