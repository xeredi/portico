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
	'language_default', 'String', 'es')\
INSERT INTO tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'language_available', 'StringList', 'es, ca, en')\
INSERT INTO tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'parametrizacion_app_mode', 'Boolean', 'true')\
INSERT INTO tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'estadistica_files_home', 'String', '${files_home}/estadistica')\
INSERT INTO tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'estadistica_files_oppe_home', 'String', '${estadistica_files_home}/oppe')\
INSERT INTO tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'estadistica_files_oppe_entrada_home', 'String', '${estadistica_files_oppe_home}/entrada')\
INSERT INTO tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'estadistica_files_oppe_procesado_home', 'String', '${estadistica_files_oppe_home}/procesado')\
INSERT INTO tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'estadistica_files_oppe_erroneo_home', 'String', '${estadistica_files_oppe_home}/erroneo')\
INSERT INTO tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'servicio_files_home', 'String', '${files_home}/servicio')\
INSERT INTO tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'pesca_files_home', 'String', '${servicio_files_home}/pesca')\
INSERT INTO tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'pesca_files_entrada_home', 'String', '${pesca_files_home}/entrada')\
INSERT INTO tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'pesca_files_procesado_home', 'String', '${pesca_files_home}/procesado')\
INSERT INTO tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'pesca_files_erroneo_home', 'String', '${pesca_files_home}/erroneo')\
INSERT INTO tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'manifiesto_files_home', 'String', '${servicio_files_home}/manifiesto')\
INSERT INTO tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'manifiesto_files_entrada_home', 'String', '${manifiesto_files_home}/entrada')\
INSERT INTO tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'manifiesto_files_procesado_home', 'String', '${manifiesto_files_home}/procesado')\
INSERT INTO tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'manifiesto_files_erroneo_home', 'String', '${manifiesto_files_home}/erroneo')\
INSERT INTO tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'escala_files_home', 'String', '${servicio_files_home}/escala')\
INSERT INTO tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'escala_files_entrada_home', 'String', '${escala_files_home}/entrada')\
INSERT INTO tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'escala_files_procesado_home', 'String', '${escala_files_home}/procesado')\
INSERT INTO tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'escala_files_erroneo_home', 'String', '${escala_files_home}/erroneo')\
INSERT INTO tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'files_home', 'String', '/proyectos/deploy/files/portico')\
INSERT INTO tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'filter_limit', 'Long', '5')\
INSERT INTO tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'webapp_install_path', 'String', '/proyectos/team/git/portico/integra-portico-web/src/main/webapp')\
INSERT INTO tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'db_migration_dataSource_driver', 'String', 'oracle.jdbc.OracleDriver')\
INSERT INTO tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'db_migration_dataSource_url', 'String', 'jdbc:oracle:thin:@localhost:1521:orcl')\
INSERT INTO tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'db_migration_dataSource_username', 'String', 'integra')\
INSERT INTO tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'db_migration_dataSource_password', 'String', 'integra')\


-- Mensajes i18n
CREATE TABLE tbl_message_i18n_m18n (
	m18n_key VARCHAR2(100) NOT NULL
	, m18n_language VARCHAR2(5) NOT NULL
	, m18n_internal INT NOT NULL
	, m18n_value VARCHAR2(250) NOT NULL

	, CONSTRAINT pk_m18n PRIMARY KEY (m18n_key, m18n_language)
)\

CREATE OR REPLACE SYNONYM portico.tbl_message_i18n_m18n FOR tbl_message_i18n_m18n\

GRANT SELECT, INSERT, UPDATE ON tbl_message_i18n_m18n TO portico\



INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'app_nombre', 'Pórtico')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'menu', 'Menú')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'errorList', 'Errores')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'filtro', 'Filtro')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('en', 0, 'filtro', 'Filter')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'filtro_limit', 'Máx. Resultados')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'grid_count', '{{count}} Resultado(s)')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'format_date', 'dd/MM/yyyy')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'format_datetime', 'dd/MM/yyyy HH:mm')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'format_true', 'Si')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'format_false', 'No')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'format_1', 'Si')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'format_0', 'No')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'btn_buscar', 'Buscar')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'btn_volver', 'Volver')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'btn_aceptar', 'Aceptar')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'btn_cancelar', 'Cancelar')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'btn_crear', 'Nuevo')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'btn_editar', 'Editar')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'btn_guardar', 'Guardar')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'btn_borrar', 'Borrar')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'btn_duplicar', 'Duplicar')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'btn_filtrar', 'Filtro')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'btn_exportar', 'Exportar')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'btn_imprimir', 'Imprimir')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'btn_recargar', 'Recargar')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'btn_valorar', 'Valorar')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'sec_facturacion', 'Facturación')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'sec_administracion', 'Administración')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'sec_metamodelo', 'Metamodelo')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'sec_configuracion', 'Configuración')\

INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'enti', 'Entidad')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'entiList', 'Entidades')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'enti_codigo', 'Código')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'enti_tipo', 'Tipo')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'enti_nombre', 'Nombre')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'enti_cmdAlta', 'Alta?')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'enti_cmdBaja', 'Baja?')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'enti_cmdEdicion', 'Edición?')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'enti_cmdDuplicado', 'Duplicado?')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'enti_maxGrid', 'Grid Máx (filas)')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'enti_engdList', 'Grupos de Datos')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'enti_entdList', 'Datos')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'enti_entdGridList', 'Datos del Grid')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'enti_entiPadresList', 'Entidades Padre')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'enti_entiHijasList', 'Entidades Hija')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'enti_enacList', 'Acciones')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'enti_i18n', 'I18n?')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'enti_tempExp', 'Temporal?')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'enti_tpdt', 'T. Dato')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'enti_tppr', 'Maestro')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'enti_tpprAsociado', 'Maestro Asociado')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'enti_temporal', 'Temporal?')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'enti_facturable', 'Facturable?')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'enti_tpdtEstado', 'T. Dato Estado')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'enti_tpsr', 'Tipo de Servicio')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'tppr', 'Maestro')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'tpprList', 'Maestros')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'tpsp', 'Maestro Dependiente')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'tpspList', 'Maestros Dependiente')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'tpsr', 'Tipo de Servicio')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'tpsrList', 'Tipos de Servicio')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'tpss', 'Tipo de Subservicio')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'tpssList', 'Tipos de Subservicio')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'tpes', 'Tipo de Estadística')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'tpesList', 'Tipos de Estadística')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'enac', 'Acción Asociada a Entidad')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'enacList', 'Acciónes Asociadas a Entidad')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'enac_enti', 'Entidad')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'enac_path', 'Ruta (URL)')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'enac_etiqueta', 'Etiqueta')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'enac_orden', 'Orden')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'enen', 'Dependencia entre Entidades')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'enenList', 'Dependencias entre Entidades')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'enen_entiPadre', 'Entidad Padre')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'enen_entiHija', 'Entidad Hija')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'enen_orden', 'Orden')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'engd', 'Grupo de Datos')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'engdList', 'Grupos de Datos')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'engd_enti', 'Entidad')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'engd_numero', 'Nº')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'engd_etiqueta', 'Etiqueta')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'entd', 'Dato de Entidad')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'entdList', 'Datos de Entidad')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'entd_enti', 'Entidad')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'entd_tpdt', 'Tipo de Dato')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'entd_grupo', 'Grupo')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'entd_fila', 'Fila')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'entd_orden', 'Orden')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'entd_span', 'Span')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'entd_spanLg', 'Span (Lg)')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'entd_obligatorio', 'Obligatorio')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'entd_gridable', 'Grid?')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'entd_filtrable', 'Filtrable?')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'entd_valorDefecto', 'V. Defecto')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'entd_etiqueta', 'Etiqueta')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'EntidadTipo_P', 'Maestro')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'EntidadTipo_B', 'Maestro Dependiente')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'EntidadTipo_T', 'Tipo de Servicio')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'EntidadTipo_S', 'Tipo de Subservicio')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'EntidadTipo_E', 'Tipo de Estadística')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'tpdt', 'Tipo de Dato')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'tpdtList', 'Tipos de Dato')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'tpdt_codigo', 'Código')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'tpdt_nombre', 'Nombre')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'tpdt_tpht', 'Tipo HTML')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'tpdt_enti', 'Entidad')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'tpdt_tpel', 'Tipo de Elemento')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'tpdt_cdrfList', 'Códigos de Referencia')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'HtmlTipo_T', 'T - Textfield')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'HtmlTipo_S', 'S - Select')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'HtmlTipo_CB', 'CB - Checkbox')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'HtmlTipo_D', 'D - Date')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'HtmlTipo_DT', 'DT - Datetime')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'HtmlTipo_F', 'F - Filtro')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'HtmlTipo_TA', 'TA - Textarea')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'ElementoTipo_ND', 'ND - Nº Decimal')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'ElementoTipo_NE', 'NE - Nº Entero')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'ElementoTipo_TX', 'TX - Texto')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'ElementoTipo_FE', 'FE - Fecha')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'ElementoTipo_FH', 'FH - Fecha/Hora')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'ElementoTipo_PR', 'PR - Maestro')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'ElementoTipo_BO', 'BO - Booleano')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'ElementoTipo_CR', 'CR - Cód. Referencia')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'ElementoTipo_SR', 'SR - Servicio')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'cdrf', 'Código de Referencia')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'cdrfList', 'Códigos de Referencia')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'cdrf_tpdt', 'T. Dato')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'cdrf_valor', 'Valor')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'cdrf_orden', 'Orden')\

INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'page_grid', 'Listado')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'page_detail', 'Detalle')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'page_create', 'Nuevo')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'page_duplicate', 'Duplicado')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'page_edit', 'Edición')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'i18n_text', 'Nombre')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'i18n_text_lang', 'Nombre {{lang}}')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'prmt', 'Maestro')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'prmtList', 'Maestro')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'prmt_parametro', 'Código')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'prmt_fini', 'F. Inicio')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'prmt_ffin', 'F. Fin')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'prmt_fvigencia', 'F. Vigencia')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'sprm_fini', 'F. Inicio')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'sprm_ffin', 'F. Fin')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'srvc', 'Servicio')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'srvcList', 'Servicios')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'srvc_tpsr', 'T. Servicio')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'srvc_subp', 'Subpuerto')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'srvc_anno', 'Año')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'srvc_numero', 'Nº')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'srvc_fini', 'F. Inicio')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'srvc_ffin', 'F. Fin')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'srvc_falta', 'F. Alta')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'srvc_fref', 'F. Referencia')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'srvc_estado', 'Estado')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'ssrv_tpss', 'T. Subservicio')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'ssrv_srvc', 'Servicio')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'ssrv_estado', 'Estado')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'ssrv_numero', 'Nº')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'ssrv_fini', 'F. Inicio')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'ssrv_ffin', 'F. Fin')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'pepr', 'Período de Proceso')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'peprList', 'Períodos de Proceso')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'pepr_autp', 'Aut. Portuaria')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'pepr_anio', 'Aut. Año')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'pepr_mes', 'Mes')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'cdms', 'Cuadro Mensual')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'estd', 'Estadistica')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'estdList', 'Estadisticas')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'estd_tpes', 'Informe')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'estd_pepr', 'P. Proceso.')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'estd_subp', 'Subpuerto')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'prbt', 'Proceso')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'prbtList', 'Procesos')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'prbt_modulo', 'Módulo')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'prbt_tipo', 'Tipo')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'prbt_estado', 'Estado')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'prbt_falta', 'F. Alta')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'prbt_fini', 'F. Inicio')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'prbt_ffin', 'F. Fin')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'prbt_duracion', 'Duración (mseg.)')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'prbt_erroresCnt', 'Nº Errores')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'prbt_alertasCnt', 'Nº Alertas')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'prbt_mensajesCnt', 'Nº Mensajes')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'prmnList', 'Mensajes')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'prmn_nivel', 'Nivel')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'prmn_codigo', 'Código')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'prmn_mensaje', 'Mensaje')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'prpmList', 'Parámetros')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'prpm_nombre', 'Nombre')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'prpm_valor', 'Valor')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'aspc', 'Aspecto')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'aspcList', 'Aspectos')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'aspc_cList', 'Elementos de Cabecera')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'aspc_lcList', 'Elementos Cuantitativos de Línea')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'aspc_liList', 'Elementos Informativos de Línea')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'aspc_ascrList', 'Cargos Asociados al Aspecto')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'aspc_codigo', 'Código')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'aspc_descripcion', 'Descripción')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'aspc_tpsr', 'T. Servicio')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'aspc_fini', 'F. Inicio')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'aspc_ffin', 'F. Fin')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'aspc_prioridad', 'Prioridad')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'aspc_cetiqInfo', 'Etiq. Elem. Informativo Cabecera')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'aspc_cetiqInfo1', 'Etiq. Elem. Informativo Cabecera 1')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'aspc_cetiqInfo2', 'Etiq. Elem. Informativo Cabecera 2')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'aspc_cetiqInfo3', 'Etiq. Elem. Informativo Cabecera 3')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'aspc_cetiqInfo4', 'Etiq. Elem. Informativo Cabecera 4')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'aspc_cetiqInfo5', 'Etiq. Elem. Informativo Cabecera 5')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'aspc_cetiqInfo6', 'Etiq. Elem. Informativo Cabecera 6')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'aspc_cpathInfo', 'Ruta Elem. Informativo Cabecera')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'aspc_cpathInfo1', 'Ruta Elem. Informativo Cabecera 1')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'aspc_cpathInfo2', 'Ruta Elem. Informativo Cabecera 2')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'aspc_cpathInfo3', 'Ruta Elem. Informativo Cabecera 3')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'aspc_cpathInfo4', 'Ruta Elem. Informativo Cabecera 4')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'aspc_cpathInfo5', 'Ruta Elem. Informativo Cabecera 5')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'aspc_cpathInfo6', 'Ruta Elem. Informativo Cabecera 6')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'aspc_cgrpInfo', 'Agrupar Elem. Informativo Cabecera?')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'aspc_cgrpInfo1', 'Agrupar Elem. Informativo Cabecera 1?')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'aspc_cgrpInfo2', 'Agrupar Elem. Informativo Cabecera 2?')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'aspc_cgrpInfo3', 'Agrupar Elem. Informativo Cabecera 3?')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'aspc_cgrpInfo4', 'Agrupar Elem. Informativo Cabecera 4?')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'aspc_cgrpInfo5', 'Agrupar Elem. Informativo Cabecera 5?')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'aspc_cgrpInfo6', 'Agrupar Elem. Informativo Cabecera 6?')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'aspc_lsumCuant', 'Sumarizar Elem. Cuantitativo Línea?')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'aspc_lsumCuant1', 'Sumarizar Elem. Cuantitativo Línea 1?')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'aspc_lsumCuant2', 'Sumarizar Elem. Cuantitativo Línea 2?')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'aspc_lsumCuant3', 'Sumarizar Elem. Cuantitativo Línea 3?')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'aspc_lsumCuant4', 'Sumarizar Elem. Cuantitativo Línea 4?')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'aspc_lsumCuant5', 'Sumarizar Elem. Cuantitativo Línea 5?')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'aspc_lsumCuant6', 'Sumarizar Elem. Cuantitativo Línea 6?')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'aspc_lgrpInfo', 'Agrupar Elem. Informativo Línea?')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'aspc_lgrpInfo1', 'Agrupar Elem. Informativo Línea 1?')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'aspc_lgrpInfo2', 'Agrupar Elem. Informativo Línea 2?')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'aspc_lgrpInfo3', 'Agrupar Elem. Informativo Línea 3?')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'aspc_lgrpInfo4', 'Agrupar Elem. Informativo Línea 4?')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'aspc_lgrpInfo5', 'Agrupar Elem. Informativo Línea 5?')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'aspc_lgrpInfo6', 'Agrupar Elem. Informativo Línea 6?')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'ascr', 'Cargo de Aspecto')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'ascr_crgo', 'Cargo')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'ascr_fini', 'F. Inicio')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'ascr_ffin', 'F. Fin')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'crgo', 'Cargo')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'crgoList', 'Cargos')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'crgo_codigo', 'Código')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'crgo_descripcion', 'Descripción')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'crgo_fini', 'F. Inicio')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'crgo_ffin', 'F. Fin')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'crgo_codigoNormalizado', 'Cód. Normalizado')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'crgo_tipo', 'Tipo')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'crgo_tpsr', 'T. Servicio')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'crgo_principal', 'Principal?')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'crgo_temporal', 'Temporal?')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'rgla', 'Regla')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'rglaList', 'Reglas')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'rgla_codigo', 'Código')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'rgla_tipo', 'Tipo')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'rgla_enti', 'Entidad')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'rgla_fini', 'F. Inicio')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'rgla_ffin', 'F. Fin')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'rgla_orden', 'Orden')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'rgla_condicion', 'Condición')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'rgla_formula', 'Fórmula')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'rgla_importeBase', 'Importe Base')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'rgla_pathImpuesto', 'Ruta Impuesto')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'rgla_pathPagador', 'Ruta Pagador')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'rgla_pathEsSujPasivo', 'Ruta Es Sujeto Pasivo')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'rgla_pathCodExen', 'Ruta Cód. Exención')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'rgla_etiqInfo', 'Etiq. Elem. Informativo')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'rgla_etiqInfo1', 'Etiq. Elem. Informativo 1')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'rgla_etiqInfo2', 'Etiq. Elem. Informativo 2')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'rgla_etiqInfo3', 'Etiq. Elem. Informativo 3')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'rgla_etiqInfo4', 'Etiq. Elem. Informativo 4')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'rgla_etiqInfo5', 'Etiq. Elem. Informativo 5')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'rgla_etiqInfo6', 'Etiq. Elem. Informativo 6')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'rgla_pathInfo', 'Ruta Elem. Informativo')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'rgla_pathInfo1', 'Ruta Elem. Informativo 1')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'rgla_pathInfo2', 'Ruta Elem. Informativo 2')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'rgla_pathInfo3', 'Ruta Elem. Informativo 3')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'rgla_pathInfo4', 'Ruta Elem. Informativo 4')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'rgla_pathInfo5', 'Ruta Elem. Informativo 5')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'rgla_pathInfo6', 'Ruta Elem. Informativo 6')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'rgla_etiqCuant', ' Etiq. Elem. Cuantitativo')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'rgla_etiqCuant1', ' Etiq. Elem. Cuantitativo 1')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'rgla_etiqCuant2', ' Etiq. Elem. Cuantitativo 2')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'rgla_etiqCuant3', ' Etiq. Elem. Cuantitativo 3')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'rgla_etiqCuant4', ' Etiq. Elem. Cuantitativo 4')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'rgla_etiqCuant5', ' Etiq. Elem. Cuantitativo 5')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'rgla_etiqCuant6', ' Etiq. Elem. Cuantitativo 6')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'rgla_pathCuant', 'Ruta Elem. Cuantitativo')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'rgla_pathCuant1', 'Ruta Elem. Cuantitativo 1')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'rgla_pathCuant2', 'Ruta Elem. Cuantitativo 2')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'rgla_pathCuant3', 'Ruta Elem. Cuantitativo 3')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'rgla_pathCuant4', 'Ruta Elem. Cuantitativo 4')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'rgla_pathCuant5', 'Ruta Elem. Cuantitativo 5')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'rgla_pathCuant6', 'Ruta Elem. Cuantitativo 6')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'rgin', 'Incompatibilidad entre Reglas')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'rginList', 'Incompatibilidades entre Reglas')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'rgin_fini', 'F. Inicio')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'rgin_ffin', 'F. Fin')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'rgin_rgla2', 'Regla Incompatible')\

INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'vlrc', 'Valoración')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'vlrcList', 'Valoraciones')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'vlrc_id', 'ID')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'vlrc_srvc', 'Servicio')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'vlrc_aspc', 'Aspecto')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'vlrc_pagador', 'Pagador')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'vlrc_importe', 'Importe')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'vlrc_impuesto', 'Impuesto')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'vlrc_fliq', 'F. Liquidación')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'vlrc_fini', 'F. Inicio')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'vlrc_ffin', 'F. Fin')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'vlrc_sujPasivo', 'Suj. Pasivo?')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'vlrc_codExencion', 'Cód. Exención')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'fctr', 'Factura')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'fctrList', 'Facturas')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'conf', 'Parámetro de Configuración')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'confList', 'Parámetros de Configuración')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'conf_key', 'Parámetro')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'conf_valueType', 'Tipo')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'conf_value', 'Valor')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'conf_defaultValue', 'Valor Defecto')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'm18nList', 'Mensajes i18n')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'm18n', 'Mensaje i18n')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'm18n_key', 'Clave')\

INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 1, 'E00000', 'E00000 - Error no controlado: {0}')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 1, 'E00001', 'E00001 - Campo Obligatorio: {0}')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 1, 'E00002', 'E00002 - Campo Obligatorio: Descripción para el idioma {0}')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 1, 'E00003', 'E00003 - Campo Obligatorio: F. Inicio')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 1, 'E00004', 'E00004 - Campo Obligatorio: Código')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 1, 'E00005', 'E00005 - {0} duplicado/a')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 1, 'E00006', 'E00006 - Error de período de Vigencia. F. Fin ha de ser posterior a F.Fin')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 1, 'E00007', 'E00007 - Parámetro con Identificador {0} no encontrado')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 1, 'E00008', 'E00008 - {0} con identificador {1} no encontrado/a')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 1, 'E00009', 'E00009 - Otro elemento se solapa con el período de vigencia')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 1, 'E00010', 'E00010 - Servicio en estado {0} inválido para ejecutar la acción')\
INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 1, 'E00011', 'E00011 - Subservicio en estado {0} inválido para ejecutar la acción')\


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
DROP TABLE tbl_message_i18n_m18n\


-- Configuracion
DROP TABLE tbl_configuration_conf\


-- Tabla Unica para i18n
DROP TABLE tbl_i18n_i18n\


-- Columna de limite de filas visibles en un grid
ALTER TABLE tbl_entidad_enti DROP COLUMN enti_max_grid\
