-- // 20150415160000_0_0_7_Seguridad.sql
-- Migration SQL that makes the change goes here.


ALTER TABLE tbl_usuario_usro ADD usro_sprt_pk NUMBER(19) NULL\
ALTER TABLE tbl_usuario_usro ADD CONSTRAINT fk_usro_sprt_pk FOREIGN KEY (usro_sprt_pk)
	REFERENCES tbl_superpuerto_sprt (sprt_pk)\

ALTER TABLE tbl_usuario_usro ADD usro_prto_pk NUMBER(19) NULL\
ALTER TABLE tbl_usuario_usro ADD CONSTRAINT fk_usro_prto_pk FOREIGN KEY (usro_prto_pk)
	REFERENCES tbl_puerto_prto (prto_pk)\

CREATE TABLE tbl_accion_accn (
	accn_pk NUMBER(19) NOT NULL
	, accn_codigo VARCHAR2(50) NOT NULL
	, accn_nombre VARCHAR2(50) NOT NULL

	, CONSTRAINT pk_accn PRIMARY KEY (accn_pk)

	, CONSTRAINT uk_accn UNIQUE (accn_codigo)
)\

CREATE OR REPLACE SYNONYM portico.tbl_accion_accn FOR tbl_accion_accn\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_accion_accn TO portico\



CREATE TABLE tbl_grupo_accion_grac (
	grac_grpo_pk NUMBER(19) NOT NULL
	, grac_accn_pk NUMBER(19) NOT NULL

	, CONSTRAINT pk_grac PRIMARY KEY (grac_grpo_pk, grac_accn_pk)

	, CONSTRAINT fk_grac_grpo_pk FOREIGN KEY (grac_grpo_pk)
		REFERENCES tbl_grupo_grpo (grpo_pk)
		ON DELETE CASCADE
	, CONSTRAINT fk_grac_accn_pk FOREIGN KEY (grac_accn_pk)
		REFERENCES tbl_accion_accn (accn_pk)
		ON DELETE CASCADE
)\

CREATE OR REPLACE SYNONYM portico.tbl_grupo_accion_grac FOR tbl_grupo_accion_grac\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_grupo_accion_grac TO portico\




-- //@UNDO
-- SQL to undo the change goes here.

DROP TABLE tbl_grupo_accion_grac\
DROP TABLE tbl_accion_accn\

ALTER TABLE tbl_usuario_usro DROP COLUMN usro_prto_pk\
ALTER TABLE tbl_usuario_usro DROP COLUMN usro_sprt_pk\
