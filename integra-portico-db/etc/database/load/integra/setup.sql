CREATE USER integra IDENTIFIED BY integra;

GRANT CONNECT, RESOURCE, CREATE VIEW TO integra;

CREATE TABLESPACE "INTG-GENERAL" DATAFILE 'C:/home/xeredi/database/oradata/orcl/INTG01.DBF' SIZE 500M;
CREATE TABLESPACE "INTG-GENERALIND" DATAFILE 'C:/home/xeredi/database/oradata/orcl/GENI01.DBF' SIZE 500M;
CREATE TABLESPACE "INTG-MAESTROS" DATAFILE 'C:/home/xeredi/database/oradata/orcl/MAES01.DBF' SIZE 500M;