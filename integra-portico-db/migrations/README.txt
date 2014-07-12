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
	Usuario porticoadm
		Creador de las tablas/indices/funciones en el esquema porticoadm
		Da permisos de CRUD/execute al usuario portico
		Crea sinonimos en el esquema portico
	Usuario portico
		- Usuario de las tablas/indices/funciones (sinonimos) del esquema portico

SqlServer
	Usuario porticoadm
		- crea las tablas/indices/funciones en el esquema portico
		- Da permisos de CRUD/execute al usuario portico
	Usuario portico
		- Usuario de las tablas/indices/funciones del esquema portico

PostgreSQL
	Usuario porticoadm
		- crea las tablas/indices/funciones en el esquema portico
		- Da permisos de CRUD/execute al usuario portico
	Usuario portico
		- Usuario de las tablas/indices/funciones del esquema portico


Permisos de los usuarios
------------------------

Oracle
	Usuario porticoadm
		- Create table
		- Create any synonym (para crear sinonimos en el esquema portico)
		- Insert/Delete any table (para insertar filas en tablas de el esquema portico)
		- Dar permisos al usuario portico
	Usuario portico
		- CRUD tablas
		- Execute funciones

SqlServer
	Usuario porticoadm
		- Create table
		- Dar permisos al usuario portico
		- Insert
	Usuario portico
		- CRUD tablas
		- Execute funciones

PostgreSQL
	Usuario porticoadm
		- Create table
		- Dar permisos al usuario portico
	Usuario portico
		- CRUD tablas
		- Execute funciones


SQL Server
----------

Jdbc (Driver MS vs jTds). Carga Maestros:
	- MS: ???
	-jTds: 13m 09s

Migracion de Maestros
---------------------

SQL Server		13m 09s
Oracle			12m 40s
PostgreSQL		14m 12s
