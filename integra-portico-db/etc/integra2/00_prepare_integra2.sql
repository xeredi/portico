-- Creacion del dblink
create database link dblinkIntegra
connect to integra identified by integra
using '192.168.1.101:1521/orcl';


-- Creacion de sinonimos
select 'CREATE SYNONYM ' || table_name || ' FOR ' || table_name || '@dblinkIntegra;' AS sql
from user_tables@dblinkIntegra order by table_name;

-- Borrado de sinonimos
select 'DROP SYNONYM ' || table_name || ';' AS sql
from user_tables@dblinkIntegra order by table_name;



















