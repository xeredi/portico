-- // 0 0 5.sql
-- Migration SQL that makes the change goes here.


-- Columna de limite de filas visibles en un grid
ALTER TABLE tbl_entidad_enti ADD enti_max_grid INT DEFAULT 0 NOT NULL\

UPDATE tbl_entidad_enti SET enti_max_grid = CASE
	WHEN enti_tipo = 'P' THEN 10000
	WHEN enti_tipo = 'B' THEN 100
	WHEN enti_tipo = 'T' THEN 10000
	WHEN enti_tipo = 'S' THEN 50000
	WHEN enti_tipo = 'E' THEN 10000
END\


-- Tabla Unica para i18n
CREATE TABLE tbl_i18n_i18n (
	i18n_pref VARCHAR2(4) NOT NULL
	, i18n_ext_pk NUMBER(19) NOT NULL
	, i18n_lang VARCHAR2(5) NOT NULL
	, i18n_text VARCHAR2(255) NOT NULL

	, CONSTRAINT pk_i18n PRIMARY KEY (i18n_pref, i18n_ext_pk, i18n_lang)
)\

CREATE OR REPLACE SYNONYM portico.tbl_i18n_i18n FOR porticoadm.tbl_i18n_i18n\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_i18n_i18n TO portico\

INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_ext_pk, i18n_lang, i18n_text)
SELECT 'prvr', p18n_prvr_pk, p18n_idioma, p18n_texto
FROM tbl_parametro_i18n_p18n\

INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_ext_pk, i18n_lang, i18n_text)
SELECT 'cdrf', cdri_cdrf_pk, cdri_idioma, cdri_texto
FROM tbl_codigo_ref_i18n_cdri\

UPDATE tbl_i18n_i18n SET i18n_lang = 'es' WHERE i18n_lang = 'es_ES'\


-- Configuracion
CREATE TABLE tbl_configuration_conf (
	conf_key VARCHAR2(250) NOT NULL
	, conf_value_type VARCHAR2(20) NOT NULL
	, conf_default_value VARCHAR2(250) NOT NULL
	, conf_value VARCHAR2(250)

	, CONSTRAINT pk_conf PRIMARY KEY (conf_key)
)\

CREATE OR REPLACE SYNONYM portico.tbl_configuration_conf FOR tbl_configuration_conf\

GRANT SELECT, UPDATE ON tbl_configuration_conf TO portico\

INSERT INTO tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'language.default', 'String', 'es')\
INSERT INTO tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'language.available', 'StringList', 'es, ca, en')\
INSERT INTO tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'parametrizacion.app.mode', 'Boolean', 'true')\
INSERT INTO tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'estadistica.files.home', 'String', '${files.home}/estadistica')\
INSERT INTO tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'estadistica.files.oppe.home', 'String', '${estadistica.files.home}/oppe')\
INSERT INTO tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'estadistica.files.oppe.procesado.home', 'String', '${estadistica.files.oppe.home}/procesado')\
INSERT INTO tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'estadistica.files.oppe.erroneo.home', 'String', '${estadistica.files.oppe.home}/erroneo')\
INSERT INTO tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'servicio.files.home', 'String', '${files.home}/servicio')\
INSERT INTO tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'pesca.files.home', 'String', '${servicio.files.home}/pesca')\
INSERT INTO tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'pesca.files.entrada.home', 'String', '${pesca.files.home}/entrada')\
INSERT INTO tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'pesca.files.procesado.home', 'String', '${pesca.files.home}/procesado')\
INSERT INTO tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'pesca.files.erroneo.home', 'String', '${pesca.files.home}/erroneo')\
INSERT INTO tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'manifiesto.files.home', 'String', '${servicio.files.home}/manifiesto')\
INSERT INTO tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'manifiesto.files.entrada.home', 'String', '${manifiesto.files.home}/entrada')\
INSERT INTO tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'manifiesto.files.procesado.home', 'String', '${manifiesto.files.home}/procesado')\
INSERT INTO tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'manifiesto.files.erroneo.home', 'String', '${manifiesto.files.home}/erroneo')\
INSERT INTO tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'escala.files.home', 'String', '${servicio.files.home}/escala')\
INSERT INTO tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'escala.files.entrada.home', 'String', '${escala.files.home}/entrada')\
INSERT INTO tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'escala.files.procesado.home', 'String', '${escala.files.home}/procesado')\
INSERT INTO tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'escala.files.erroneo.home', 'String', '${escala.files.home}/erroneo')\
INSERT INTO tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'files.home', 'String', '/proyectos/deploy/files/portico')\
INSERT INTO tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'filter.limit', 'Long', '5')\


-- Mensajes i18n
CREATE TABLE tbl_message_i18n_m18n (
	m18n_bundle VARCHAR2(30) NOT NULL
	, m18n_language VARCHAR2(5) NOT NULL
	, m18n_key VARCHAR2(100) NOT NULL
	, m18n_value VARCHAR2(250) NOT NULL

	, CONSTRAINT pk_m18n PRIMARY KEY (m18n_bundle, m18n_language, m18n_key)
)\

CREATE OR REPLACE SYNONYM portico.tbl_message_i18n_m18n FOR tbl_message_i18n_m18n\

GRANT SELECT, INSERT, UPDATE ON tbl_message_i18n_m18n TO portico\

INSERT INTO tbl_message_i18n_m18n(m18n_bundle, m18n_language, m18n_key, m18n_value) VALUES ('web', 'es', 'format_date', 'dd/MM/yyyy')\
INSERT INTO tbl_message_i18n_m18n(m18n_bundle, m18n_language, m18n_key, m18n_value) VALUES ('web', 'es', 'format_datetime', 'dd/MM/yyyy HH:mm')\
INSERT INTO tbl_message_i18n_m18n(m18n_bundle, m18n_language, m18n_key, m18n_value) VALUES ('web', 'es', 'format_true', 'Si')\
INSERT INTO tbl_message_i18n_m18n(m18n_bundle, m18n_language, m18n_key, m18n_value) VALUES ('web', 'es', 'format_false', 'No')\
INSERT INTO tbl_message_i18n_m18n(m18n_bundle, m18n_language, m18n_key, m18n_value) VALUES ('web', 'es', 'format_1', 'Si')\
INSERT INTO tbl_message_i18n_m18n(m18n_bundle, m18n_language, m18n_key, m18n_value) VALUES ('web', 'es', 'format_0', 'No')\
INSERT INTO tbl_message_i18n_m18n(m18n_bundle, m18n_language, m18n_key, m18n_value) VALUES ('web', 'es', 'btn_buscar', 'Buscar')\
INSERT INTO tbl_message_i18n_m18n(m18n_bundle, m18n_language, m18n_key, m18n_value) VALUES ('web', 'es', 'btn_volver', 'Volver')\
INSERT INTO tbl_message_i18n_m18n(m18n_bundle, m18n_language, m18n_key, m18n_value) VALUES ('web', 'es', 'btn_aceptar', 'Aceptar')\
INSERT INTO tbl_message_i18n_m18n(m18n_bundle, m18n_language, m18n_key, m18n_value) VALUES ('web', 'es', 'btn_cancelar', 'Cancelar')\
INSERT INTO tbl_message_i18n_m18n(m18n_bundle, m18n_language, m18n_key, m18n_value) VALUES ('web', 'es', 'btn_crear', 'Nuevo')\
INSERT INTO tbl_message_i18n_m18n(m18n_bundle, m18n_language, m18n_key, m18n_value) VALUES ('web', 'es', 'btn_editar', 'Editar')\
INSERT INTO tbl_message_i18n_m18n(m18n_bundle, m18n_language, m18n_key, m18n_value) VALUES ('web', 'es', 'btn_guardar', 'Guardar')\
INSERT INTO tbl_message_i18n_m18n(m18n_bundle, m18n_language, m18n_key, m18n_value) VALUES ('web', 'es', 'btn_borrar', 'Borrar')\
INSERT INTO tbl_message_i18n_m18n(m18n_bundle, m18n_language, m18n_key, m18n_value) VALUES ('web', 'es', 'btn_duplicar', 'Duplicar')\
INSERT INTO tbl_message_i18n_m18n(m18n_bundle, m18n_language, m18n_key, m18n_value) VALUES ('web', 'es', 'btn_filtrar', 'Filtro')\
INSERT INTO tbl_message_i18n_m18n(m18n_bundle, m18n_language, m18n_key, m18n_value) VALUES ('web', 'es', 'btn_exportar', 'Exportar')\
INSERT INTO tbl_message_i18n_m18n(m18n_bundle, m18n_language, m18n_key, m18n_value) VALUES ('web', 'es', 'btn_imprimir', 'Imprimir')\
INSERT INTO tbl_message_i18n_m18n(m18n_bundle, m18n_language, m18n_key, m18n_value) VALUES ('web', 'es', 'btn_recargar', 'Recargar')\
INSERT INTO tbl_message_i18n_m18n(m18n_bundle, m18n_language, m18n_key, m18n_value) VALUES ('web', 'es', 'btn_valorar', 'Valorar')\

INSERT INTO tbl_message_i18n_m18n(m18n_bundle, m18n_language, m18n_key, m18n_value) VALUES ('app', 'es', 'format_date', 'dd/MM/yyyy')\
INSERT INTO tbl_message_i18n_m18n(m18n_bundle, m18n_language, m18n_key, m18n_value) VALUES ('app', 'es', 'format_datetime', 'dd/MM/yyyy HH:mm')\
INSERT INTO tbl_message_i18n_m18n(m18n_bundle, m18n_language, m18n_key, m18n_value) VALUES ('app', 'es', 'format_true', 'Si')\
INSERT INTO tbl_message_i18n_m18n(m18n_bundle, m18n_language, m18n_key, m18n_value) VALUES ('app', 'es', 'format_false', 'No')\
INSERT INTO tbl_message_i18n_m18n(m18n_bundle, m18n_language, m18n_key, m18n_value) VALUES ('app', 'es', 'format_1', 'Si')\
INSERT INTO tbl_message_i18n_m18n(m18n_bundle, m18n_language, m18n_key, m18n_value) VALUES ('app', 'es', 'format_0', 'No')\
INSERT INTO tbl_message_i18n_m18n(m18n_bundle, m18n_language, m18n_key, m18n_value) VALUES ('app', 'es', 'E00000', 'E00000 - Error no controlado: {0}')\
INSERT INTO tbl_message_i18n_m18n(m18n_bundle, m18n_language, m18n_key, m18n_value) VALUES ('app', 'es', 'E00001', 'E00001 - Campo Obligatorio: {0}')\
INSERT INTO tbl_message_i18n_m18n(m18n_bundle, m18n_language, m18n_key, m18n_value) VALUES ('app', 'es', 'E00002', 'E00002 - Campo Obligatorio: Descripción para el idioma {0}')\
INSERT INTO tbl_message_i18n_m18n(m18n_bundle, m18n_language, m18n_key, m18n_value) VALUES ('app', 'es', 'E00003', 'E00003 - Campo Obligatorio: F. Inicio')\
INSERT INTO tbl_message_i18n_m18n(m18n_bundle, m18n_language, m18n_key, m18n_value) VALUES ('app', 'es', 'E00004', 'E00004 - Campo Obligatorio: Código')\
INSERT INTO tbl_message_i18n_m18n(m18n_bundle, m18n_language, m18n_key, m18n_value) VALUES ('app', 'es', 'E00005', 'E00005 - {0} duplicado/a')\
INSERT INTO tbl_message_i18n_m18n(m18n_bundle, m18n_language, m18n_key, m18n_value) VALUES ('app', 'es', 'E00006', 'E00006 - Error de período de Vigencia. F. Fin ha de ser posterior a F.Fin')\
INSERT INTO tbl_message_i18n_m18n(m18n_bundle, m18n_language, m18n_key, m18n_value) VALUES ('app', 'es', 'E00007', 'E00007 - Parámetro con Identificador {0} no encontrado')\
INSERT INTO tbl_message_i18n_m18n(m18n_bundle, m18n_language, m18n_key, m18n_value) VALUES ('app', 'es', 'E00008', 'E00008 - {0} con identificador {1} no encontrado/a')\
INSERT INTO tbl_message_i18n_m18n(m18n_bundle, m18n_language, m18n_key, m18n_value) VALUES ('app', 'es', 'E00009', 'E00009 - Otro elemento se solapa con el período de vigencia')\
INSERT INTO tbl_message_i18n_m18n(m18n_bundle, m18n_language, m18n_key, m18n_value) VALUES ('app', 'es', 'E00010', 'E00010 - Servicio en estado {0} inválido para ejecutar la acción')\
INSERT INTO tbl_message_i18n_m18n(m18n_bundle, m18n_language, m18n_key, m18n_value) VALUES ('app', 'es', 'E00011', 'E00011 - Subservicio en estado {0} inválido para ejecutar la acción')\
INSERT INTO tbl_message_i18n_m18n(m18n_bundle, m18n_language, m18n_key, m18n_value) VALUES ('app', 'es', 'i18n_text', 'Texto')\
INSERT INTO tbl_message_i18n_m18n(m18n_bundle, m18n_language, m18n_key, m18n_value) VALUES ('app', 'es', 'prmt_parametro', 'Código')\
INSERT INTO tbl_message_i18n_m18n(m18n_bundle, m18n_language, m18n_key, m18n_value) VALUES ('app', 'es', 'prmt_fini', 'F. Inicio')\
INSERT INTO tbl_message_i18n_m18n(m18n_bundle, m18n_language, m18n_key, m18n_value) VALUES ('app', 'es', 'prmt_ffin', 'F. Fin')\
INSERT INTO tbl_message_i18n_m18n(m18n_bundle, m18n_language, m18n_key, m18n_value) VALUES ('app', 'es', 'srvc_tpsr', 'T. Servicio')\
INSERT INTO tbl_message_i18n_m18n(m18n_bundle, m18n_language, m18n_key, m18n_value) VALUES ('app', 'es', 'srvc_subp', 'Subpuerto')\
INSERT INTO tbl_message_i18n_m18n(m18n_bundle, m18n_language, m18n_key, m18n_value) VALUES ('app', 'es', 'srvc_anno', 'Año')\
INSERT INTO tbl_message_i18n_m18n(m18n_bundle, m18n_language, m18n_key, m18n_value) VALUES ('app', 'es', 'srvc_numero', 'Nº')\
INSERT INTO tbl_message_i18n_m18n(m18n_bundle, m18n_language, m18n_key, m18n_value) VALUES ('app', 'es', 'srvc_fini', 'F. Inicio')\
INSERT INTO tbl_message_i18n_m18n(m18n_bundle, m18n_language, m18n_key, m18n_value) VALUES ('app', 'es', 'srvc_ffin', 'F. Fin')\
INSERT INTO tbl_message_i18n_m18n(m18n_bundle, m18n_language, m18n_key, m18n_value) VALUES ('app', 'es', 'srvc_falta', 'F. Alta')\
INSERT INTO tbl_message_i18n_m18n(m18n_bundle, m18n_language, m18n_key, m18n_value) VALUES ('app', 'es', 'srvc_fref', 'F. Referencia')\
INSERT INTO tbl_message_i18n_m18n(m18n_bundle, m18n_language, m18n_key, m18n_value) VALUES ('app', 'es', 'srvc_estado', 'Estado')\
INSERT INTO tbl_message_i18n_m18n(m18n_bundle, m18n_language, m18n_key, m18n_value) VALUES ('app', 'es', 'ssrv_tpss', 'T. Subservicio')\
INSERT INTO tbl_message_i18n_m18n(m18n_bundle, m18n_language, m18n_key, m18n_value) VALUES ('app', 'es', 'ssrv_srvc', 'Servicio')\
INSERT INTO tbl_message_i18n_m18n(m18n_bundle, m18n_language, m18n_key, m18n_value) VALUES ('app', 'es', 'ssrv_estado', 'Estado')\
INSERT INTO tbl_message_i18n_m18n(m18n_bundle, m18n_language, m18n_key, m18n_value) VALUES ('app', 'es', 'ssrv_numero', 'Nº')\
INSERT INTO tbl_message_i18n_m18n(m18n_bundle, m18n_language, m18n_key, m18n_value) VALUES ('app', 'es', 'ssrv_fini', 'F. Inicio')\
INSERT INTO tbl_message_i18n_m18n(m18n_bundle, m18n_language, m18n_key, m18n_value) VALUES ('app', 'es', 'ssrv_ffin', 'F. Fin')\
INSERT INTO tbl_message_i18n_m18n(m18n_bundle, m18n_language, m18n_key, m18n_value) VALUES ('app', 'es', 'estd_tpes', 'Informe')\
INSERT INTO tbl_message_i18n_m18n(m18n_bundle, m18n_language, m18n_key, m18n_value) VALUES ('app', 'es', 'estd_pepr', 'P. Proceso.')\
INSERT INTO tbl_message_i18n_m18n(m18n_bundle, m18n_language, m18n_key, m18n_value) VALUES ('app', 'es', 'estd_subp', 'Subpuerto')\


-- Borrado de laas tablas de configuracion y configuracion de idioma
DROP TABLE tbl_conf_valor_i18n_cnvi\
DROP TABLE tbl_configuracion_valor_cnvl\
DROP TABLE tbl_configuracion_entorno_cnen\
DROP TABLE tbl_configuracion_idioma_cnid\
DROP TABLE tbl_conf_clave_i18n_cnci\
DROP TABLE tbl_conf_clave_cncl\


-- Borrado de las tablas de i18n de parametro y codigo de referencia
DROP TABLE tbl_parametro_i18n_p18n\
DROP TABLE tbl_codigo_ref_i18n_cdri\


















-- //@UNDO
-- SQL to undo the change goes here.

-- Borrado de las tablas de i18n de parametro y codigo de referencia
CREATE TABLE tbl_parametro_i18n_p18n (
	p18n_prvr_pk NUMBER(19) NOT NULL
	, p18n_idioma VARCHAR2(5) NOT NULL
	, p18n_texto VARCHAR2(350) NOT NULL

	, CONSTRAINT pk_p18n PRIMARY KEY (p18n_prvr_pk, p18n_idioma)

	, CONSTRAINT fk_p18n_prvr_pk FOREIGN KEY (p18n_prvr_pk)
		REFERENCES tbl_parametro_version_prvr (prvr_pk)
)\

CREATE OR REPLACE SYNONYM portico.tbl_parametro_i18n_p18n FOR porticoadm.tbl_parametro_i18n_p18n\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_parametro_i18n_p18n TO portico\

COMMENT ON TABLE tbl_parametro_i18n_p18n IS 'Textos internacionalizados Asociados a las Versiones de Parametros de la aplicacion (Textos i18n de Maestros)'\
COMMENT ON COLUMN tbl_parametro_i18n_p18n.p18n_prvr_pk IS 'Identificador de Version de Parametro'\
COMMENT ON COLUMN tbl_parametro_i18n_p18n.p18n_idioma IS 'Idioma del texto'\
COMMENT ON COLUMN tbl_parametro_i18n_p18n.p18n_texto IS 'Texto'\

CREATE TABLE tbl_codigo_ref_i18n_cdri (
	cdri_cdrf_pk NUMBER(19) NOT NULL
	, cdri_idioma VARCHAR2(5) NOT NULL
	, cdri_texto VARCHAR2(100) NOT NULL

	, CONSTRAINT pk_cdri PRIMARY KEY (cdri_cdrf_pk, cdri_idioma)

	, CONSTRAINT fk_cdri_cdrf_pk FOREIGN KEY (cdri_cdrf_pk)
		REFERENCES tbl_codigo_ref_cdrf (cdrf_pk)
)\

CREATE OR REPLACE SYNONYM portico.tbl_codigo_ref_i18n_cdri FOR porticoadm.tbl_codigo_ref_i18n_cdri\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_codigo_ref_i18n_cdri TO portico\

INSERT INTO portico.tbl_parametro_i18n_p18n (p18n_prvr_pk, p18n_idioma, p18n_texto)
SELECT i18n_ext_pk, i18n_lang, i18n_text
FROM portico.tbl_i18n_i18n
WHERE i18n_pref = 'prvr'\

INSERT INTO portico.tbl_codigo_ref_i18n_cdri (cdri_cdrf_pk, cdri_idioma, cdri_texto)
SELECT i18n_ext_pk, i18n_lang, i18n_text
FROM portico.tbl_i18n_i18n
WHERE i18n_pref = 'cdrf'\


-- Borrado de laas tablas de configuracion y configuracion de idioma
CREATE TABLE tbl_conf_clave_cncl (
	cncl_pk NUMBER(19) NOT NULL
	, cncl_clave VARCHAR2(80) NOT NULL
	, cncl_tipo_valor VARCHAR2(2) NOT NULL
	, cncl_valor_defecto VARCHAR2(200) NOT NULL

	, CONSTRAINT pk_cncl PRIMARY KEY (cncl_pk)
	, CONSTRAINT uq_cncl UNIQUE (cncl_clave)
)\

CREATE OR REPLACE SYNONYM portico.tbl_conf_clave_cncl FOR porticoadm.tbl_conf_clave_cncl\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_conf_clave_cncl TO portico\

COMMENT ON TABLE tbl_conf_clave_cncl IS 'Claves de Parametros de Configuracion'\
COMMENT ON COLUMN tbl_conf_clave_cncl.cncl_pk IS 'Identificador de clave'\
COMMENT ON COLUMN tbl_conf_clave_cncl.cncl_tipo_valor IS 'Tipo de Valor del parametro (Fecha, numero, ...)'\
COMMENT ON COLUMN tbl_conf_clave_cncl.cncl_clave IS 'Clave del parametro'\
COMMENT ON COLUMN tbl_conf_clave_cncl.cncl_valor_defecto IS 'Valor por defecto del parametro'\

CREATE TABLE tbl_conf_clave_i18n_cnci (
	cnci_pk NUMBER(19) NOT NULL
	, cnci_clave VARCHAR2(80) NOT NULL
	, cnci_valor_defecto VARCHAR2(200) NOT NULL

	, CONSTRAINT pk_cnci PRIMARY KEY (cnci_pk)
	, CONSTRAINT uq_cnci UNIQUE (cnci_clave)
)\

CREATE OR REPLACE SYNONYM portico.tbl_conf_clave_i18n_cnci FOR porticoadm.tbl_conf_clave_i18n_cnci\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_conf_clave_i18n_cnci TO portico\

COMMENT ON TABLE tbl_conf_clave_i18n_cnci IS 'Claves de Configuracion de idioma'\
COMMENT ON COLUMN tbl_conf_clave_i18n_cnci.cnci_pk IS 'Identificador de clave de idioma'\
COMMENT ON COLUMN tbl_conf_clave_i18n_cnci.cnci_clave IS 'Identificador de clave'\
COMMENT ON COLUMN tbl_conf_clave_i18n_cnci.cnci_valor_defecto IS 'Valor por Defecto'\

CREATE TABLE tbl_configuracion_idioma_cnid (
	cnid_pk NUMBER(19) NOT NULL
	, cnid_codigo VARCHAR2(5) NOT NULL
	, cnid_descripcion VARCHAR2(100)

	, CONSTRAINT pk_cnid PRIMARY KEY (cnid_pk)
	, CONSTRAINT uq_cnid UNIQUE (cnid_codigo)
)\

CREATE OR REPLACE SYNONYM portico.tbl_configuracion_idioma_cnid FOR porticoadm.tbl_configuracion_idioma_cnid\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_configuracion_idioma_cnid TO portico\

COMMENT ON TABLE tbl_configuracion_idioma_cnid IS 'Configuraciones de idioma'\
COMMENT ON COLUMN tbl_configuracion_idioma_cnid.cnid_pk IS 'Identificador de configuracion de idioma'\
COMMENT ON COLUMN tbl_configuracion_idioma_cnid.cnid_codigo IS 'Codigo de configuracion de idioma'\
COMMENT ON COLUMN tbl_configuracion_idioma_cnid.cnid_descripcion IS 'Descripcion de configuracion de idioma'\

CREATE TABLE tbl_configuracion_entorno_cnen (
	cnen_pk NUMBER(19) NOT NULL
	, cnen_codigo VARCHAR2(8) NOT NULL
	, cnen_nombre VARCHAR2(50) NOT NULL

	, CONSTRAINT pk_cnen PRIMARY KEY (cnen_pk)
	, CONSTRAINT uq_cnen UNIQUE (cnen_codigo)
)\

CREATE OR REPLACE SYNONYM portico.tbl_configuracion_entorno_cnen FOR porticoadm.tbl_configuracion_entorno_cnen\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_configuracion_entorno_cnen TO portico\

COMMENT ON TABLE tbl_configuracion_entorno_cnen IS 'Entornos de Configuracion'\
COMMENT ON COLUMN tbl_configuracion_entorno_cnen.cnen_pk IS 'Identificador de entorno'\
COMMENT ON COLUMN tbl_configuracion_entorno_cnen.cnen_codigo IS 'Codigo de entorno'\
COMMENT ON COLUMN tbl_configuracion_entorno_cnen.cnen_nombre IS 'Nombre de entorno'\

CREATE TABLE tbl_configuracion_valor_cnvl (
	cnvl_cnen_pk NUMBER(19) NOT NULL
	, cnvl_cncl_pk NUMBER(19) NOT NULL
	, cnvl_valor VARCHAR2(200) NOT NULL

	, CONSTRAINT pk_cnvl PRIMARY KEY (cnvl_cnen_pk, cnvl_cncl_pk)

	, CONSTRAINT fk_cnvl_cnen_pk FOREIGN KEY (cnvl_cnen_pk)
		REFERENCES tbl_configuracion_entorno_cnen (cnen_pk)
	, CONSTRAINT fk_cnvl_cncl_pk FOREIGN KEY (cnvl_cncl_pk)
		REFERENCES tbl_conf_clave_cncl (cncl_pk)
)\

CREATE OR REPLACE SYNONYM portico.tbl_configuracion_valor_cnvl FOR porticoadm.tbl_configuracion_valor_cnvl\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_configuracion_valor_cnvl TO portico\

COMMENT ON TABLE tbl_configuracion_valor_cnvl IS 'Valores de parametros de configuracion'\
COMMENT ON COLUMN tbl_configuracion_valor_cnvl.cnvl_cnen_pk IS 'Identificador de entorno'\
COMMENT ON COLUMN tbl_configuracion_valor_cnvl.cnvl_cncl_pk IS 'Identificador de clave'\
COMMENT ON COLUMN tbl_configuracion_valor_cnvl.cnvl_valor IS 'Valor de parametro'\

CREATE TABLE tbl_conf_valor_i18n_cnvi (
	cnvi_cnid_pk NUMBER(19) NOT NULL
	, cnvi_cnci_pk NUMBER(19) NOT NULL
	, cnvi_valor VARCHAR2(200) NOT NULL

	, CONSTRAINT pk_cnvi PRIMARY KEY (cnvi_cnid_pk, cnvi_cnci_pk)

	, CONSTRAINT fk_cnvi_cnid_pk FOREIGN KEY (cnvi_cnid_pk)
		REFERENCES tbl_configuracion_idioma_cnid (cnid_pk)
	, CONSTRAINT fk_cnvi_cnci_pk FOREIGN KEY (cnvi_cnci_pk)
		REFERENCES tbl_conf_clave_i18n_cnci (cnci_pk)
)\

CREATE OR REPLACE SYNONYM portico.tbl_conf_valor_i18n_cnvi FOR porticoadm.tbl_conf_valor_i18n_cnvi\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_conf_valor_i18n_cnvi TO portico\

COMMENT ON TABLE tbl_conf_valor_i18n_cnvi IS 'Valores de parametros de configuracion de idioma'\
COMMENT ON COLUMN tbl_conf_valor_i18n_cnvi.cnvi_cnid_pk IS 'Identificador de Configuracion de Idioma'\
COMMENT ON COLUMN tbl_conf_valor_i18n_cnvi.cnvi_cnci_pk IS 'Identificador de Parametro de Configuracion de Idioma'\
COMMENT ON COLUMN tbl_conf_valor_i18n_cnvi.cnvi_valor IS 'Valor de Parametro'\

INSERT INTO portico.tbl_configuracion_idioma_cnid (cnid_pk, cnid_codigo, cnid_descripcion) VALUES (30000, 'es_ES', 'Español (España)')\
INSERT INTO portico.tbl_configuracion_idioma_cnid (cnid_pk, cnid_codigo, cnid_descripcion) VALUES (30001, 'ca_ES', 'Catalán')\

INSERT INTO portico.tbl_configuracion_entorno_cnen (cnen_pk, cnen_codigo, cnen_nombre) VALUES (31000, 'PC', 'PC de Casa')\
INSERT INTO portico.tbl_configuracion_entorno_cnen (cnen_pk, cnen_codigo, cnen_nombre) VALUES (31001, 'PRTTL', 'Portátil de Casa')\
INSERT INTO portico.tbl_configuracion_entorno_cnen (cnen_pk, cnen_codigo, cnen_nombre) VALUES (31002, 'PRTL', 'PC de Portel')\

INSERT INTO portico.tbl_conf_clave_cncl (cncl_pk, cncl_clave, cncl_tipo_valor, cncl_valor_defecto) VALUES (32000, 'test', 'TX', 'Valor de test por defecto')\
INSERT INTO portico.tbl_conf_clave_cncl (cncl_pk, cncl_clave, cncl_tipo_valor, cncl_valor_defecto) VALUES (32001, 'testBoolean', 'BO', 'true')\
INSERT INTO portico.tbl_conf_clave_cncl (cncl_pk, cncl_clave, cncl_tipo_valor, cncl_valor_defecto) VALUES (32002, 'testLong', 'NE', '1000')\
INSERT INTO portico.tbl_conf_clave_cncl (cncl_pk, cncl_clave, cncl_tipo_valor, cncl_valor_defecto) VALUES (32003, 'testDouble', 'ND', '1000.5')\

INSERT INTO portico.tbl_conf_clave_i18n_cnci (cnci_pk, cnci_clave, cnci_valor_defecto) VALUES (40000, 'test', 'Valor de idioma test por defecto')\

INSERT INTO portico.tbl_configuracion_valor_cnvl (cnvl_cnen_pk, cnvl_cncl_pk, cnvl_valor) VALUES (31000, 32000, 'Valor de test Para el PC de casa')\

INSERT INTO portico.tbl_conf_valor_i18n_cnvi (cnvi_cnid_pk, cnvi_cnci_pk, cnvi_valor) VALUES (30000, 40000, 'Valor de idioma de test para es_ES')\


-- Mensajes i18n
DROP TABLE tbl_message_i18n_m18n\


-- Configuracion
DROP TABLE tbl_configuration_conf\


-- Tabla Unica para i18n
DROP TABLE tbl_i18n_i18n\


-- Columna de limite de filas visibles en un grid
ALTER TABLE tbl_entidad_enti DROP COLUMN enti_max_grid\
