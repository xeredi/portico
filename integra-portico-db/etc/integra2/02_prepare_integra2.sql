-- Creacion del dblink
create database link dblinkIntegra
connect to INTEGRA identified by INTEGRA
 using 'localhost:1521/orcl.localdomain';
 -- using 'praim4:1521/INTDES';



-- Creacion de sinonimos
select 'CREATE SYNONYM ' || table_name || ' FOR ' || table_name || '@dblinkIntegra;' AS sql
from user_tables@dblinkIntegra order by table_name;


-- Borrado de sinonimos
select 'DROP SYNONYM ' || table_name || ';' AS sql
from user_tables@dblinkIntegra order by table_name;
























-- DROP database link dblinkIntegra;



