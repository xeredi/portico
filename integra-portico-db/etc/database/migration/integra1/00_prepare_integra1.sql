-- Creacion de la tabla de traduccion de ids
CREATE TABLE tbl_traduccion_ids_trid (
	trid_table_name VARCHAR2(100) NOT NULL
	, trid_old_id NUMBER(19) NOT NULL
	, trid_new_id NUMBER(19) NOT NULL

	, CONSTRAINT pk_trid PRIMARY KEY (trid_table_name, trid_old_id)
);


-- Borrado de la tabla de traduccion de ids
-- DROP TABLE tbl_traduccion_ids_trid;
















