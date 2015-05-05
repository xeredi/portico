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
	, accn_codigo VARCHAR2(100) NOT NULL
	, accn_nombre VARCHAR2(100) NOT NULL

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



CREATE TABLE tbl_tramite_trmt (
	trmt_pk NUMBER(19) NOT NULL
	, trmt_enti_pk NUMBER(19) NOT NULL
	, trmt_estado_orig CHAR(1) NOT NULL
	, trmt_estado_dest CHAR(1) NOT NULL

	, CONSTRAINT pk_trmt PRIMARY KEY (trmt_pk)
	, CONSTRAINT uq_trmt UNIQUE (trmt_enti_pk, trmt_estado_orig, trmt_estado_dest)

	, CONSTRAINT fk_trmt_enti_pk FOREIGN KEY (trmt_enti_pk)
		REFERENCES tbl_entidad_enti (enti_pk)
)\

CREATE OR REPLACE SYNONYM portico.tbl_tramite_trmt FOR tbl_tramite_trmt\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_tramite_trmt TO portico\


CREATE TABLE tbl_tramite_tipo_dato_trtd (
	trtd_trmt_pk NUMBER(19) NOT NULL
	, trtd_tpdt_pk NUMBER(19) NOT NULL
	, trtd_obligatorio INTEGER NOT NULL

	, CONSTRAINT pk_trtd PRIMARY KEY (trtd_trmt_pk, trtd_tpdt_pk)

	, CONSTRAINT fk_trtd_trmt_pk FOREIGN KEY (trtd_trmt_pk)
		REFERENCES tbl_tramite_trmt (trmt_pk)
)\

CREATE OR REPLACE SYNONYM portico.tbl_tramite_tipo_dato_trtd FOR tbl_tramite_tipo_dato_trtd\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_tramite_tipo_dato_trtd TO portico\



CREATE TABLE tbl_servicio_tramite_srtr (
	srtr_pk NUMBER(19) NOT NULL
	, srtr_srvc_pk NUMBER(19) NOT NULL
	, srtr_trmt_pk NUMBER(19) NOT NULL
	, srtr_falta TIMESTAMP NOT NULL

	, CONSTRAINT pk_srtr PRIMARY KEY (srtr_pk)

	, CONSTRAINT fk_srtr_srvc_pk FOREIGN KEY (srtr_srvc_pk)
		REFERENCES tbl_servicio_srvc (srvc_pk)
	, CONSTRAINT fk_srtr_trmt_pk FOREIGN KEY (srtr_trmt_pk)
		REFERENCES tbl_tramite_trmt (trmt_pk)
)\

CREATE OR REPLACE SYNONYM portico.tbl_servicio_tramite_srtr FOR tbl_servicio_tramite_srtr\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_servicio_tramite_srtr TO portico\


CREATE TABLE tbl_subservicio_tramite_sstr (
	sstr_pk NUMBER(19) NOT NULL
	, sstr_ssrv_pk NUMBER(19) NOT NULL
	, sstr_trmt_pk NUMBER(19) NOT NULL
	, sstr_falta TIMESTAMP NOT NULL

	, CONSTRAINT pk_sstr PRIMARY KEY (sstr_pk)

	, CONSTRAINT fk_sstr_ssrv_pk FOREIGN KEY (sstr_ssrv_pk)
		REFERENCES tbl_subservicio_ssrv (ssrv_pk)
	, CONSTRAINT fk_sstr_trmt_pk FOREIGN KEY (sstr_trmt_pk)
		REFERENCES tbl_tramite_trmt (trmt_pk)
)\

CREATE OR REPLACE SYNONYM portico.tbl_subservicio_tramite_sstr FOR tbl_subservicio_tramite_sstr\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_subservicio_tramite_sstr TO portico\


-- Manifiesto
INSERT INTO tbl_tramite_trmt (trmt_pk, trmt_enti_pk, trmt_estado_orig, trmt_estado_dest) VALUES (46000, 21002, 'S', 'B')\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_ext_pk, i18n_lang, i18n_text) VALUES ('trmt', 46000, 'es', 'Bloquear')\
INSERT INTO tbl_tramite_trmt (trmt_pk, trmt_enti_pk, trmt_estado_orig, trmt_estado_dest) VALUES (46001, 21002, 'I', 'B')\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_ext_pk, i18n_lang, i18n_text) VALUES ('trmt', 46001, 'es', 'Bloquear')\
INSERT INTO tbl_tramite_trmt (trmt_pk, trmt_enti_pk, trmt_estado_orig, trmt_estado_dest) VALUES (46002, 21002, 'C', 'B')\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_ext_pk, i18n_lang, i18n_text) VALUES ('trmt', 46002, 'es', 'Bloquear')\

INSERT INTO tbl_tramite_trmt (trmt_pk, trmt_enti_pk, trmt_estado_orig, trmt_estado_dest) VALUES (46010, 21002, 'I', 'C')\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_ext_pk, i18n_lang, i18n_text) VALUES ('trmt', 46010, 'es', 'Completar')\

INSERT INTO tbl_tramite_trmt (trmt_pk, trmt_enti_pk, trmt_estado_orig, trmt_estado_dest) VALUES (46020, 21002, 'C', 'I')\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_ext_pk, i18n_lang, i18n_text) VALUES ('trmt', 46020, 'es', 'Iniciar')\
INSERT INTO tbl_tramite_trmt (trmt_pk, trmt_enti_pk, trmt_estado_orig, trmt_estado_dest) VALUES (46021, 21002, 'B', 'I')\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_ext_pk, i18n_lang, i18n_text) VALUES ('trmt', 46021, 'es', 'Iniciar')\

INSERT INTO tbl_tramite_trmt (trmt_pk, trmt_enti_pk, trmt_estado_orig, trmt_estado_dest) VALUES (46030, 21002, 'I', 'A')\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_ext_pk, i18n_lang, i18n_text) VALUES ('trmt', 46030, 'es', 'Anular')\
INSERT INTO tbl_tramite_trmt (trmt_pk, trmt_enti_pk, trmt_estado_orig, trmt_estado_dest) VALUES (46031, 21002, 'S', 'A')\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_ext_pk, i18n_lang, i18n_text) VALUES ('trmt', 46031, 'es', 'Anular')\
INSERT INTO tbl_tramite_trmt (trmt_pk, trmt_enti_pk, trmt_estado_orig, trmt_estado_dest) VALUES (46032, 21002, 'C', 'A')\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_ext_pk, i18n_lang, i18n_text) VALUES ('trmt', 46032, 'es', 'Anular')\

-- BL
INSERT INTO tbl_tramite_trmt (trmt_pk, trmt_enti_pk, trmt_estado_orig, trmt_estado_dest) VALUES (46040, 22003, 'S', 'B')\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_ext_pk, i18n_lang, i18n_text) VALUES ('trmt', 46040, 'es', 'Bloquear')\
INSERT INTO tbl_tramite_trmt (trmt_pk, trmt_enti_pk, trmt_estado_orig, trmt_estado_dest) VALUES (46041, 22003, 'I', 'B')\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_ext_pk, i18n_lang, i18n_text) VALUES ('trmt', 46041, 'es', 'Bloquear')\
INSERT INTO tbl_tramite_trmt (trmt_pk, trmt_enti_pk, trmt_estado_orig, trmt_estado_dest) VALUES (46042, 22003, 'C', 'B')\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_ext_pk, i18n_lang, i18n_text) VALUES ('trmt', 46042, 'es', 'Bloquear')\

INSERT INTO tbl_tramite_trmt (trmt_pk, trmt_enti_pk, trmt_estado_orig, trmt_estado_dest) VALUES (46050, 22003, 'I', 'C')\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_ext_pk, i18n_lang, i18n_text) VALUES ('trmt', 46050, 'es', 'Completar')\

INSERT INTO tbl_tramite_trmt (trmt_pk, trmt_enti_pk, trmt_estado_orig, trmt_estado_dest) VALUES (46060, 22003, 'C', 'I')\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_ext_pk, i18n_lang, i18n_text) VALUES ('trmt', 46060, 'es', 'Iniciar')\
INSERT INTO tbl_tramite_trmt (trmt_pk, trmt_enti_pk, trmt_estado_orig, trmt_estado_dest) VALUES (46061, 22003, 'B', 'I')\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_ext_pk, i18n_lang, i18n_text) VALUES ('trmt', 46061, 'es', 'Iniciar')\

INSERT INTO tbl_tramite_trmt (trmt_pk, trmt_enti_pk, trmt_estado_orig, trmt_estado_dest) VALUES (46070, 22003, 'I', 'A')\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_ext_pk, i18n_lang, i18n_text) VALUES ('trmt', 46070, 'es', 'Anular')\
INSERT INTO tbl_tramite_trmt (trmt_pk, trmt_enti_pk, trmt_estado_orig, trmt_estado_dest) VALUES (46071, 22003, 'S', 'A')\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_ext_pk, i18n_lang, i18n_text) VALUES ('trmt', 46071, 'es', 'Anular')\
INSERT INTO tbl_tramite_trmt (trmt_pk, trmt_enti_pk, trmt_estado_orig, trmt_estado_dest) VALUES (46072, 22003, 'C', 'A')\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_ext_pk, i18n_lang, i18n_text) VALUES ('trmt', 46072, 'es', 'Anular')\

-- Partida
INSERT INTO tbl_tramite_trmt (trmt_pk, trmt_enti_pk, trmt_estado_orig, trmt_estado_dest) VALUES (46080, 22004, 'R', 'B')\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_ext_pk, i18n_lang, i18n_text) VALUES ('trmt', 46080, 'es', 'Bloquear')\

INSERT INTO tbl_tramite_trmt (trmt_pk, trmt_enti_pk, trmt_estado_orig, trmt_estado_dest) VALUES (46090, 22004, 'B', 'R')\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_ext_pk, i18n_lang, i18n_text) VALUES ('trmt', 46090, 'es', 'Iniciar')\

INSERT INTO tbl_tramite_trmt (trmt_pk, trmt_enti_pk, trmt_estado_orig, trmt_estado_dest) VALUES (46100, 22004, 'R', 'A')\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_ext_pk, i18n_lang, i18n_text) VALUES ('trmt', 46100, 'es', 'Anular')\

-- Equipamiento
INSERT INTO tbl_tramite_trmt (trmt_pk, trmt_enti_pk, trmt_estado_orig, trmt_estado_dest) VALUES (46110, 22005, 'R', 'B')\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_ext_pk, i18n_lang, i18n_text) VALUES ('trmt', 46110, 'es', 'Bloquear')\

INSERT INTO tbl_tramite_trmt (trmt_pk, trmt_enti_pk, trmt_estado_orig, trmt_estado_dest) VALUES (46120, 22005, 'B', 'R')\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_ext_pk, i18n_lang, i18n_text) VALUES ('trmt', 46120, 'es', 'Iniciar')\

INSERT INTO tbl_tramite_trmt (trmt_pk, trmt_enti_pk, trmt_estado_orig, trmt_estado_dest) VALUES (46130, 22005, 'R', 'A')\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_ext_pk, i18n_lang, i18n_text) VALUES ('trmt', 46130, 'es', 'Anular')\

-- Atraque 22011
INSERT INTO tbl_tramite_trmt (trmt_pk, trmt_enti_pk, trmt_estado_orig, trmt_estado_dest) VALUES (46140, 22011, 'S', 'C')\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_ext_pk, i18n_lang, i18n_text) VALUES ('trmt', 46140, 'es', 'Autorizar')\
	INSERT INTO tbl_tramite_tipo_dato_trtd (trtd_trmt_pk, trtd_tpdt_pk, trtd_obligatorio) VALUES (46140, 41040, 1)\
	INSERT INTO tbl_tramite_tipo_dato_trtd (trtd_trmt_pk, trtd_tpdt_pk, trtd_obligatorio) VALUES (46140, 41041, 1)\
	INSERT INTO tbl_tramite_tipo_dato_trtd (trtd_trmt_pk, trtd_tpdt_pk, trtd_obligatorio) VALUES (46140, 45180, 1)\
	INSERT INTO tbl_tramite_tipo_dato_trtd (trtd_trmt_pk, trtd_tpdt_pk, trtd_obligatorio) VALUES (46140, 45380, 1)\
	INSERT INTO tbl_tramite_tipo_dato_trtd (trtd_trmt_pk, trtd_tpdt_pk, trtd_obligatorio) VALUES (46140, 43120, 1)\
	INSERT INTO tbl_tramite_tipo_dato_trtd (trtd_trmt_pk, trtd_tpdt_pk, trtd_obligatorio) VALUES (46140, 41042, 1)\
	INSERT INTO tbl_tramite_tipo_dato_trtd (trtd_trmt_pk, trtd_tpdt_pk, trtd_obligatorio) VALUES (46140, 41043, 1)\
	INSERT INTO tbl_tramite_tipo_dato_trtd (trtd_trmt_pk, trtd_tpdt_pk, trtd_obligatorio) VALUES (46140, 45000, 1)\
	INSERT INTO tbl_tramite_tipo_dato_trtd (trtd_trmt_pk, trtd_tpdt_pk, trtd_obligatorio) VALUES (46140, 41100, 1)\
	INSERT INTO tbl_tramite_tipo_dato_trtd (trtd_trmt_pk, trtd_tpdt_pk, trtd_obligatorio) VALUES (46140, 41080, 0)\
INSERT INTO tbl_tramite_trmt (trmt_pk, trmt_enti_pk, trmt_estado_orig, trmt_estado_dest) VALUES (46141, 22011, 'D', 'C')\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_ext_pk, i18n_lang, i18n_text) VALUES ('trmt', 46141, 'es', 'Autorizar')\
	INSERT INTO tbl_tramite_tipo_dato_trtd (trtd_trmt_pk, trtd_tpdt_pk, trtd_obligatorio) VALUES (46141, 41040, 1)\
	INSERT INTO tbl_tramite_tipo_dato_trtd (trtd_trmt_pk, trtd_tpdt_pk, trtd_obligatorio) VALUES (46141, 41041, 1)\
	INSERT INTO tbl_tramite_tipo_dato_trtd (trtd_trmt_pk, trtd_tpdt_pk, trtd_obligatorio) VALUES (46141, 45180, 1)\
	INSERT INTO tbl_tramite_tipo_dato_trtd (trtd_trmt_pk, trtd_tpdt_pk, trtd_obligatorio) VALUES (46141, 45380, 1)\
	INSERT INTO tbl_tramite_tipo_dato_trtd (trtd_trmt_pk, trtd_tpdt_pk, trtd_obligatorio) VALUES (46141, 43120, 1)\
	INSERT INTO tbl_tramite_tipo_dato_trtd (trtd_trmt_pk, trtd_tpdt_pk, trtd_obligatorio) VALUES (46141, 41042, 1)\
	INSERT INTO tbl_tramite_tipo_dato_trtd (trtd_trmt_pk, trtd_tpdt_pk, trtd_obligatorio) VALUES (46141, 41043, 1)\
	INSERT INTO tbl_tramite_tipo_dato_trtd (trtd_trmt_pk, trtd_tpdt_pk, trtd_obligatorio) VALUES (46141, 45000, 1)\
	INSERT INTO tbl_tramite_tipo_dato_trtd (trtd_trmt_pk, trtd_tpdt_pk, trtd_obligatorio) VALUES (46141, 41100, 1)\
	INSERT INTO tbl_tramite_tipo_dato_trtd (trtd_trmt_pk, trtd_tpdt_pk, trtd_obligatorio) VALUES (46141, 41080, 0)\

INSERT INTO tbl_tramite_trmt (trmt_pk, trmt_enti_pk, trmt_estado_orig, trmt_estado_dest) VALUES (46150, 22011, 'S', 'D')\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_ext_pk, i18n_lang, i18n_text) VALUES ('trmt', 46150, 'es', 'Denegar')\
	INSERT INTO tbl_tramite_tipo_dato_trtd (trtd_trmt_pk, trtd_tpdt_pk, trtd_obligatorio) VALUES (46150, 41080, 0)\
INSERT INTO tbl_tramite_trmt (trmt_pk, trmt_enti_pk, trmt_estado_orig, trmt_estado_dest) VALUES (46151, 22011, 'C', 'D')\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_ext_pk, i18n_lang, i18n_text) VALUES ('trmt', 46151, 'es', 'Denegar')\
	INSERT INTO tbl_tramite_tipo_dato_trtd (trtd_trmt_pk, trtd_tpdt_pk, trtd_obligatorio) VALUES (46151, 41080, 0)\

INSERT INTO tbl_tramite_trmt (trmt_pk, trmt_enti_pk, trmt_estado_orig, trmt_estado_dest) VALUES (46160, 22011, 'S', 'A')\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_ext_pk, i18n_lang, i18n_text) VALUES ('trmt', 46160, 'es', 'Anular')\
INSERT INTO tbl_tramite_trmt (trmt_pk, trmt_enti_pk, trmt_estado_orig, trmt_estado_dest) VALUES (46161, 22011, 'C', 'A')\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_ext_pk, i18n_lang, i18n_text) VALUES ('trmt', 46161, 'es', 'Anular')\

INSERT INTO tbl_tramite_trmt (trmt_pk, trmt_enti_pk, trmt_estado_orig, trmt_estado_dest) VALUES (46170, 22011, 'C', 'I')\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_ext_pk, i18n_lang, i18n_text) VALUES ('trmt', 46170, 'es', 'Iniciar')\

INSERT INTO tbl_tramite_trmt (trmt_pk, trmt_enti_pk, trmt_estado_orig, trmt_estado_dest) VALUES (46180, 22011, 'I', 'F')\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_ext_pk, i18n_lang, i18n_text) VALUES ('trmt', 46180, 'es', 'Finalizar')\

INSERT INTO tbl_tramite_trmt (trmt_pk, trmt_enti_pk, trmt_estado_orig, trmt_estado_dest) VALUES (46190, 22011, 'C', 'S')\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_ext_pk, i18n_lang, i18n_text) VALUES ('trmt', 46190, 'es', 'Des. Estado')\
INSERT INTO tbl_tramite_trmt (trmt_pk, trmt_enti_pk, trmt_estado_orig, trmt_estado_dest) VALUES (46191, 22011, 'I', 'C')\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_ext_pk, i18n_lang, i18n_text) VALUES ('trmt', 46191, 'es', 'Des. Estado')\
INSERT INTO tbl_tramite_trmt (trmt_pk, trmt_enti_pk, trmt_estado_orig, trmt_estado_dest) VALUES (46192, 22011, 'F', 'I')\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_ext_pk, i18n_lang, i18n_text) VALUES ('trmt', 46192, 'es', 'Des. Estado')\
INSERT INTO tbl_tramite_trmt (trmt_pk, trmt_enti_pk, trmt_estado_orig, trmt_estado_dest) VALUES (46193, 22011, 'D', 'S')\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_ext_pk, i18n_lang, i18n_text) VALUES ('trmt', 46193, 'es', 'Des. Estado')\
INSERT INTO tbl_tramite_trmt (trmt_pk, trmt_enti_pk, trmt_estado_orig, trmt_estado_dest) VALUES (46194, 22011, 'A', 'S')\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_ext_pk, i18n_lang, i18n_text) VALUES ('trmt', 46194, 'es', 'Des. Estado')\




-- //@UNDO
-- SQL to undo the change goes here.

DELETE FROM tbl_i18n_i18n WHERE i18n_pref = 'trmt'\

DROP TABLE tbl_subservicio_tramite_sstr\
DROP TABLE tbl_servicio_tramite_srtr\
DROP TABLE tbl_tramite_tipo_dato_trtd\
DROP TABLE tbl_tramite_trmt\
DROP TABLE tbl_grupo_accion_grac\
DROP TABLE tbl_accion_accn\



ALTER TABLE tbl_usuario_usro DROP COLUMN usro_prto_pk\
ALTER TABLE tbl_usuario_usro DROP COLUMN usro_sprt_pk\
