rem psql -f sql/insert-maestro.sql -q -h localhost -p 5432 -U usr_portico_adm -d portico -W
psql -f sql/export.sql -q -h localhost -p 5432 -U usr_portico_adm -d portico -W

