-- // Bootstrap.sql

-- This is the only SQL script file that is NOT
-- a valid migration and will not be run or tracked
-- in the changelog.  There is no @UNDO section.

-- // Do I need this file?

-- New projects likely won't need this file.
-- Existing projects will likely need this file.
-- It's unlikely that this bootstrap should be run
-- in the production environment.

-- // Purpose

-- The purpose of this file is to provide a facility
-- to initialize the database to a state before MyBatis
-- SQL migrations were applied.  If you already have
-- a database in production, then you probably have
-- a script that you run on your developer machine
-- to initialize the database.  That script can now
-- be put in this bootstrap file (but does not have
-- to be if you are comfortable with your current process.

-- // Running

-- The bootstrap SQL is run with the "migrate bootstrap"
-- command.  It must be run manually, it's never run as
-- part of the regular migration process and will never
-- be undone. Variables (e.g. ${variable}) are still
-- parsed in the bootstrap SQL.

-- After the boostrap SQL has been run, you can then
-- use the migrations and the changelog for all future
-- database change management.

CREATE USER porticoadm IDENTIFIED BY portico;
CREATE USER portico IDENTIFIED BY portico;

GRANT
	RESOURCE
	, CREATE SESSION
	, CREATE TABLE
	, CREATE VIEW
	, CREATE MATERIALIZED VIEW
	, CREATE ANY SYNONYM
	, INSERT ANY TABLE
	, SELECT ANY TABLE
	, UPDATE ANY TABLE
	, DELETE ANY TABLE
  , UNLIMITED TABLESPACE
TO porticoadm WITH ADMIN OPTION;

GRANT
    CONNECT
  , UNLIMITED TABLESPACE
TO portico;

-- DROP USER portico CASCADE;
-- DROP USER porticoadm CASCADE;

-- TRUNCATE TABLE tbl_valoracion_det_vlrd;
-- DELETE FROM tbl_valoracion_lin_vlrl;
-- DELETE FROM tbl_valoracion_vlrc;

-- TRUNCATE TABLE tbl_cuadro_mes_cdms;
-- TRUNCATE TABLE tbl_estadistica_dato_esdt;
-- DELETE FROM tbl_estadistica_estd;
-- DELETE FROM tbl_periodo_proceso_pepr;

-- TRUNCATE TABLE tbl_subservicio_dato_ssdt;
-- TRUNCATE TABLE tbl_subserv_subserv_ssss;
-- DELETE FROM tbl_subservicio_ssrv;
-- TRUNCATE TABLE tbl_servicio_dato_srdt;
-- DELETE FROM tbl_servicio_actor_srac;
-- DELETE FROM tbl_servicio_srvc;

-- TRUNCATE TABLE tbl_subparametro_dato_spdt;
-- DELETE FROM tbl_subparametro_version_spvr;
-- DELETE FROM tbl_subparametro_sprm;
-- TRUNCATE TABLE tbl_parametro_dato_prdt;
-- DELETE FROM tbl_parametro_version_prvr;
-- DELETE FROM tbl_parametro_prmt;
-- DELETE FROM tbl_i18n_i18n WHERE i18n_pref = 'prvr';

