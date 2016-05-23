-- Creacion de la secuencia
CREATE SEQUENCE seq_migracion;

-- Creacion de la tabla de traduccion de ids
CREATE TABLE tbl_traduccion_ids_trid (
	trid_table_name VARCHAR2(100) NOT NULL
	, trid_old_id NUMBER(19) NOT NULL
	, trid_new_id NUMBER(19) NOT NULL

	, CONSTRAINT pk_trid PRIMARY KEY (trid_table_name, trid_old_id)
);


-- Generacion de traduccion de ids
select 'INSERT INTO tbl_traduccion_ids_trid (trid_old_id, trid_new_id, trid_table_name) SELECT XXXXX_id, seq_migracion.nextval, ''' || table_name || ''' FROM ' || table_name || ';' AS sql
from user_tables order by table_name;




-- Borrado de la tabla de traduccion de ids
DROP TABLE tbl_traduccion_ids_trid;

-- Borrado de la secuencia
DROP SEQUENCE seq_migracion;





















