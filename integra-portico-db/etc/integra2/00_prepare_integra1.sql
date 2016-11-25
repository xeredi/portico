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

-- Generacion de grants al usuario 'integra2'
select 'GRANT SELECT ON '|| table_name|| ' TO &int2schema' || ';' AS sql
from user_tables order by table_name;

/*
DECLARE
	CURSOR c IS SELECT table_name FROM user_tables;
	cmd VARCHAR2(200);
BEGIN
	FOR t IN c LOOP
		cmd := 'GRANT SELECT ON '|| t.table_name|| ' TO integra2';
		EXECUTE IMMEDIATE cmd;
	END LOOP;
END;
*/






-- Borrado de la tabla de traduccion de ids
DROP TABLE tbl_traduccion_ids_trid;

-- Borrado de la secuencia
DROP SEQUENCE seq_migracion;

-- Quitar permisos de select al usuario 'integra2'
select 'REVOKE SELECT ON '|| table_name|| ' FROM &int2schema;' AS sql
from user_tables order by table_name;

















