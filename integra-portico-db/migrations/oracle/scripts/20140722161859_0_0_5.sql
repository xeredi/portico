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

CREATE OR REPLACE SYNONYM portico.tbl_i18n_i18n FOR tbl_i18n_i18n\

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
INSERT INTO tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'webapp.install.path', 'String', '/proyectos/team/git/portico/integra-portico-web/src/main/webapp')\


-- Mensajes i18n
CREATE TABLE tbl_message_bundle_msbl (
	msbl_key VARCHAR2(100) NOT NULL
	, msbl_bundle VARCHAR2(30) NOT NULL

	, CONSTRAINT pk_msbl PRIMARY KEY (msbl_key, msbl_bundle)
)\

CREATE OR REPLACE SYNONYM portico.tbl_message_bundle_msbl FOR tbl_message_bundle_msbl\

GRANT SELECT, INSERT, UPDATE ON tbl_message_bundle_msbl TO portico\

CREATE TABLE tbl_message_i18n_m18n (
	m18n_key VARCHAR2(100) NOT NULL
	, m18n_language VARCHAR2(5) NOT NULL
	, m18n_value VARCHAR2(250) NOT NULL

	, CONSTRAINT pk_m18n PRIMARY KEY (m18n_key, m18n_language)
)\

CREATE OR REPLACE SYNONYM portico.tbl_message_i18n_m18n FOR tbl_message_i18n_m18n\

GRANT SELECT, INSERT, UPDATE ON tbl_message_i18n_m18n TO portico\



INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'filtro', 'Filtro')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('filtro', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'filtro_limit', 'Máx. Resultados')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('filtro_limit', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'grid_count', '{{count}} Resultado(s)')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('grid_count', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'format_date', 'dd/MM/yyyy')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('format_date', 'web')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('format_date', 'app')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'format_datetime', 'dd/MM/yyyy HH:mm')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('format_datetime', 'web')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('format_datetime', 'app')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'format_true', 'Si')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('format_true', 'web')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('format_true', 'app')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'format_false', 'No')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('format_false', 'web')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('format_false', 'app')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'format_1', 'Si')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('format_1', 'web')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('format_1', 'app')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'format_0', 'No')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('format_0', 'web')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('format_0', 'app')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'btn_buscar', 'Buscar')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('btn_buscar', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'btn_volver', 'Volver')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('btn_volver', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'btn_aceptar', 'Aceptar')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('btn_aceptar', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'btn_cancelar', 'Cancelar')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('btn_cancelar', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'btn_crear', 'Nuevo')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('btn_crear', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'btn_editar', 'Editar')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('btn_editar', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'btn_guardar', 'Guardar')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('btn_guardar', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'btn_borrar', 'Borrar')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('btn_borrar', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'btn_duplicar', 'Duplicar')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('btn_duplicar', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'btn_filtrar', 'Filtro')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('btn_filtrar', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'btn_exportar', 'Exportar')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('btn_exportar', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'btn_imprimir', 'Imprimir')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('btn_imprimir', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'btn_recargar', 'Recargar')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('btn_recargar', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'btn_valorar', 'Valorar')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('btn_valorar', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enti', 'Entidad')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('enti', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'entiList', 'Entidades')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('entiList', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enti_codigo', 'Código')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('enti_codigo', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enti_tipo', 'Tipo')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('enti_tipo', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enti_nombre', 'Nombre')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('enti_nombre', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enti_cmdAlta', 'Alta?')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('enti_cmdAlta', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enti_cmdBaja', 'Baja?')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('enti_cmdBaja', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enti_cmdEdicion', 'Edición?')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('enti_cmdEdicion', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enti_cmdDuplicado', 'Duplicado?')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('enti_cmdDuplicado', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enti_maxGrid', 'Grid Máx (filas)')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('enti_maxGrid', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enti_engdList', 'Grupos de Datos')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('enti_engdList', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enti_entdList', 'Datos')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('enti_entdList', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enti_entdGridList', 'Datos del Grid')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('enti_entdGridList', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enti_entiPadresList', 'Entidades Padre')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('enti_entiPadresList', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enti_entiHijasList', 'Entidades Hija')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('enti_entiHijasList', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enti_enacList', 'Acciones')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('enti_enacList', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enti_i18n', 'I18n?')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('enti_i18n', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enti_tempExp', 'Temporal?')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('enti_tempExp', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enti_tpdt', 'T. Dato')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('enti_tpdt', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enti_tppr', 'Maestro')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('enti_tppr', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enti_tpprAsociado', 'Maestro Asociado')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('enti_tpprAsociado', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enti_temporal', 'Temporal?')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('enti_temporal', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enti_facturable', 'Facturable?')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('enti_facturable', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enti_tpdtEstado', 'T. Dato Estado')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('enti_tpdtEstado', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enti_tpsr', 'Tipo de Servicio')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('enti_tpsr', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'tppr', 'Maestro')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('tppr', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'tpprList', 'Maestros')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('tpprList', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'tpsp', 'Maestro Dependiente')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('tpsp', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'tpspList', 'Maestros Dependiente')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('tpspList', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'tpsr', 'Tipo de Servicio')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('tpsr', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'tpsrList', 'Tipos de Servicio')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('tpsrList', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'tpss', 'Tipo de Subservicio')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('tpss', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'tpssList', 'Tipos de Subservicio')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('tpssList', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'tpes', 'Tipo de Estadística')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('tpes', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'tpesList', 'Tipos de Estadística')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('tpesList', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enac', 'Acción Asociada a Entidad')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('enac', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enacList', 'Acciónes Asociadas a Entidad')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('enacList', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enac_enti', 'Entidad')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('enac_enti', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enac_path', 'Ruta (URL)')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('enac_path', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enac_etiqueta', 'Etiqueta')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('enac_etiqueta', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enac_orden', 'Orden')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('enac_orden', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enen', 'Dependencia entre Entidades')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('enen', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enenList', 'Dependencias entre Entidades')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('enenList', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enen_entiPadre', 'Entidad Padre')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('enen_entiPadre', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enen_entiHija', 'Entidad Hija')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('enen_entiHija', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enen_orden', 'Orden')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('enen_orden', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'engd', 'Grupo de Datos')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('engd', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'engdList', 'Grupos de Datos')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('engdList', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'engd_enti', 'Entidad')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('engd_enti', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'engd_numero', 'Nº')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('engd_numero', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'engd_etiqueta', 'Etiqueta')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('engd_etiqueta', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'entd', 'Dato de Entidad')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('entd', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'entdList', 'Datos de Entidad')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('entdList', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'entd_enti', 'Entidad')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('entd_enti', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'entd_tpdt', 'Tipo de Dato')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('entd_tpdt', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'entd_grupo', 'Grupo')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('entd_grupo', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'entd_fila', 'Fila')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('entd_fila', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'entd_orden', 'Orden')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('entd_orden', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'entd_span', 'Span')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('entd_span', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'entd_spanLg', 'Span (Lg)')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('entd_spanLg', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'entd_obligatorio', 'Obligatorio')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('entd_obligatorio', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'entd_gridable', 'Grid?')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('entd_gridable', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'entd_filtrable', 'Filtrable?')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('entd_filtrable', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'entd_valorDefecto', 'V. Defecto')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('entd_valorDefecto', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'entd_etiqueta', 'Etiqueta')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('entd_etiqueta', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'EntidadTipo_P', 'Maestro')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('EntidadTipo_P', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'EntidadTipo_B', 'Maestro Dependiente')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('EntidadTipo_B', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'EntidadTipo_T', 'Tipo de Servicio')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('EntidadTipo_T', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'EntidadTipo_S', 'Tipo de Subservicio')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('EntidadTipo_S', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'EntidadTipo_E', 'Tipo de Estadística')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('EntidadTipo_E', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'tpdt', 'Tipo de Dato')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('tpdt', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'tpdtList', 'Tipos de Dato')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('tpdtList', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'tpdt_codigo', 'Código')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('tpdt_codigo', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'tpdt_nombre', 'Nombre')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('tpdt_nombre', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'tpdt_tpht', 'Tipo HTML')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('tpdt_tpht', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'tpdt_enti', 'Entidad')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('tpdt_enti', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'tpdt_tpel', 'Tipo de Elemento')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('tpdt_tpel', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'tpdt_cdrfList', 'Códigos de Referencia')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('tpdt_cdrfList', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'HtmlTipo_T', 'Textfield')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('HtmlTipo_T', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'HtmlTipo_S', 'Select')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('HtmlTipo_S', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'HtmlTipo_CB', 'Checkbox')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('HtmlTipo_CB', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'HtmlTipo_D', 'Date')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('HtmlTipo_D', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'HtmlTipo_DT', 'Datetime')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('HtmlTipo_DT', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'HtmlTipo_F', 'Filtro')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('HtmlTipo_F', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'HtmlTipo_TA', 'Textarea')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('HtmlTipo_TA', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ElementoTipo_ND', 'Nº Decimal')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('ElementoTipo_ND', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ElementoTipo_NE', 'Nº Entero')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('ElementoTipo_NE', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ElementoTipo_TX', 'Texto')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('ElementoTipo_TX', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ElementoTipo_FE', 'Fecha')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('ElementoTipo_FE', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ElementoTipo_FH', 'Fecha/Hora')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('ElementoTipo_FH', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ElementoTipo_PR', 'Maestro')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('ElementoTipo_PR', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ElementoTipo_BO', 'Booleano')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('ElementoTipo_BO', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ElementoTipo_CR', 'Cód. Referencia')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('ElementoTipo_CR', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ElementoTipo_SR', 'Servicio')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('ElementoTipo_SR', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'cdrf', 'Código de Referencia')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('cdrf', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'cdrfList', 'Códigos de Referencia')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('cdrfList', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'cdrf_tpdt', 'T. Dato')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('cdrf_tpdt', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'cdrf_valor', 'Valor')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('cdrf_valor', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'cdrf_orden', 'Orden')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('cdrf_orden', 'web')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'i18n_text', 'Texto')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('i18n_text', 'web')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('i18n_text', 'app')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'prmt', 'Maestro')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('prmt', 'web')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('prmt', 'app')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'prmtList', 'Maestro')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('prmtList', 'web')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('prmtList', 'app')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'prmt_parametro', 'Código')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('prmt_parametro', 'web')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('prmt_parametro', 'app')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'prmt_fini', 'F. Inicio')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('prmt_fini', 'web')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('prmt_fini', 'app')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'prmt_ffin', 'F. Fin')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('prmt_ffin', 'web')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('prmt_ffin', 'app')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'srvc', 'Servicio')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('srvc', 'web')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('srvc', 'app')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'srvcList', 'Servicios')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('srvcList', 'web')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('srvcList', 'app')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'srvc_tpsr', 'T. Servicio')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('srvc_tpsr', 'web')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('srvc_tpsr', 'app')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'srvc_subp', 'Subpuerto')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('srvc_subp', 'web')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('srvc_subp', 'app')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'srvc_anno', 'Año')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('srvc_anno', 'web')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('srvc_anno', 'app')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'srvc_numero', 'Nº')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('srvc_numero', 'web')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('srvc_numero', 'app')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'srvc_fini', 'F. Inicio')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('srvc_fini', 'web')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('srvc_fini', 'app')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'srvc_ffin', 'F. Fin')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('srvc_ffin', 'web')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('srvc_ffin', 'app')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'srvc_falta', 'F. Alta')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('srvc_falta', 'web')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('srvc_falta', 'app')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'srvc_fref', 'F. Referencia')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('srvc_fref', 'web')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('srvc_fref', 'app')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'srvc_estado', 'Estado')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('srvc_estado', 'web')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('srvc_estado', 'app')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ssrv_tpss', 'T. Subservicio')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('ssrv_tpss', 'web')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('ssrv_tpss', 'app')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ssrv_srvc', 'Servicio')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('ssrv_srvc', 'web')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('ssrv_srvc', 'app')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ssrv_estado', 'Estado')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('ssrv_estado', 'web')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('ssrv_estado', 'app')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ssrv_numero', 'Nº')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('ssrv_numero', 'web')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('ssrv_numero', 'app')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ssrv_fini', 'F. Inicio')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('ssrv_fini', 'web')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('ssrv_fini', 'app')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ssrv_ffin', 'F. Fin')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('ssrv_ffin', 'web')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('ssrv_ffin', 'app')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'estd', 'Estadistica')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('estd', 'web')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('estd', 'app')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'estdList', 'Estadisticas')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('estdList', 'web')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('estdList', 'app')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'estd_tpes', 'Informe')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('estd_tpes', 'web')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('estd_tpes', 'app')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'estd_pepr', 'P. Proceso.')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('estd_pepr', 'web')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('estd_pepr', 'app')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'estd_subp', 'Subpuerto')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('estd_subp', 'web')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('estd_subp', 'app')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'prbt', 'Proceso')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('prbt', 'web')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('prbt', 'app')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'prbtList', 'Procesos')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('prbtList', 'web')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('prbtList', 'app')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc', 'Aspecto')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('aspc', 'web')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('aspc', 'app')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspcList', 'Aspectos')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('aspcList', 'web')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('aspcList', 'app')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_cList', 'Elementos de Cabecera')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('aspc_cList', 'web')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('aspc_cList', 'app')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_lcList', 'Elementos Cuantitativos de Línea')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('aspc_lcList', 'web')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('aspc_lcList', 'app')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_liList', 'Elementos Informativos de Línea')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('aspc_liList', 'web')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('aspc_liList', 'app')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_ascrList', 'Cargos Asociados al Aspecto')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('aspc_ascrList', 'web')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('aspc_ascrList', 'app')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_codigo', 'Código')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('aspc_codigo', 'web')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('aspc_codigo', 'app')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_descripcion', 'Descripción')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('aspc_descripcion', 'web')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('aspc_descripcion', 'app')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_tpsr', 'T. Servicio')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('aspc_tpsr', 'web')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('aspc_tpsr', 'app')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_fini', 'F. Inicio')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('aspc_fini', 'web')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('aspc_fini', 'app')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_ffin', 'F. Fin')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('aspc_ffin', 'web')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('aspc_ffin', 'app')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_prioridad', 'Prioridad')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('aspc_prioridad', 'web')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('aspc_prioridad', 'app')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_cetiqInfo', 'Etiq. Elem. Informativo Cabecera')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('aspc_cetiqInfo', 'web')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('aspc_cetiqInfo', 'app')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_cpathInfo', 'Ruta Elem. Informativo Cabecera')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('aspc_cpathInfo', 'web')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('aspc_cpathInfo', 'app')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_cgrpInfo', 'Agrupar Elem. Informativo Cabecera?')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('aspc_cgrpInfo', 'web')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('aspc_cgrpInfo', 'app')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_lsumCuant', 'Sumarizar Elem. Cuantitativo Línea?')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('aspc_lsumCuant', 'web')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('aspc_lsumCuant', 'app')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_lgrpInfo', 'Agrupar Elem. Informativo Línea?')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('aspc_lgrpInfo', 'web')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('aspc_lgrpInfo', 'app')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'E00000', 'E00000 - Error no controlado: {0}')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('E00000', 'app')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'E00001', 'E00001 - Campo Obligatorio: {0}')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('E00001', 'app')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'E00002', 'E00002 - Campo Obligatorio: Descripción para el idioma {0}')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('E00002', 'app')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'E00003', 'E00003 - Campo Obligatorio: F. Inicio')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('E00003', 'app')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'E00004', 'E00004 - Campo Obligatorio: Código')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('E00004', 'app')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'E00005', 'E00005 - {0} duplicado/a')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('E00005', 'app')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'E00006', 'E00006 - Error de período de Vigencia. F. Fin ha de ser posterior a F.Fin')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('E00006', 'app')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'E00007', 'E00007 - Parámetro con Identificador {0} no encontrado')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('E00007', 'app')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'E00008', 'E00008 - {0} con identificador {1} no encontrado/a')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('E00008', 'app')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'E00009', 'E00009 - Otro elemento se solapa con el período de vigencia')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('E00009', 'app')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'E00010', 'E00010 - Servicio en estado {0} inválido para ejecutar la acción')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('E00010', 'app')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'E00011', 'E00011 - Subservicio en estado {0} inválido para ejecutar la acción')\
	INSERT INTO tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('E00011', 'app')\


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

CREATE OR REPLACE SYNONYM portico.tbl_parametro_i18n_p18n FOR tbl_parametro_i18n_p18n\

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

CREATE OR REPLACE SYNONYM portico.tbl_codigo_ref_i18n_cdri FOR tbl_codigo_ref_i18n_cdri\

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

CREATE OR REPLACE SYNONYM portico.tbl_conf_clave_cncl FOR tbl_conf_clave_cncl\

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

CREATE OR REPLACE SYNONYM portico.tbl_conf_clave_i18n_cnci FOR tbl_conf_clave_i18n_cnci\

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

CREATE OR REPLACE SYNONYM portico.tbl_configuracion_idioma_cnid FOR tbl_configuracion_idioma_cnid\

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

CREATE OR REPLACE SYNONYM portico.tbl_configuracion_entorno_cnen FOR tbl_configuracion_entorno_cnen\

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

CREATE OR REPLACE SYNONYM portico.tbl_configuracion_valor_cnvl FOR tbl_configuracion_valor_cnvl\

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

CREATE OR REPLACE SYNONYM portico.tbl_conf_valor_i18n_cnvi FOR tbl_conf_valor_i18n_cnvi\

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
DROP TABLE tbl_message_bundle_msbl\
DROP TABLE tbl_message_i18n_m18n\


-- Configuracion
DROP TABLE tbl_configuration_conf\


-- Tabla Unica para i18n
DROP TABLE tbl_i18n_i18n\


-- Columna de limite de filas visibles en un grid
ALTER TABLE tbl_entidad_enti DROP COLUMN enti_max_grid\
