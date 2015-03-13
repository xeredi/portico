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

-- Ruta a clase de negocio de la entidad
ALTER TABLE tbl_entidad_enti ADD enti_classpath VARCHAR2(50)\




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

INSERT INTO portico.tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'language_default', 'String', 'es')\
INSERT INTO portico.tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'language_available', 'StringList', 'es, ca, en')\
INSERT INTO portico.tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'parametrizacion_app_mode', 'Boolean', 'true')\
INSERT INTO portico.tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'estadistica_files_home', 'String', '${files_home}/estadistica')\
INSERT INTO portico.tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'estadistica_files_oppe_home', 'String', '${estadistica_files_home}/oppe')\
INSERT INTO portico.tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'estadistica_files_oppe_entrada_home', 'String', '${estadistica_files_oppe_home}/entrada')\
INSERT INTO portico.tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'estadistica_files_oppe_procesado_home', 'String', '${estadistica_files_oppe_home}/procesado')\
INSERT INTO portico.tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'estadistica_files_oppe_erroneo_home', 'String', '${estadistica_files_oppe_home}/erroneo')\
INSERT INTO portico.tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'servicio_files_home', 'String', '${files_home}/servicio')\
INSERT INTO portico.tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'pesca_files_home', 'String', '${servicio_files_home}/pesca')\
INSERT INTO portico.tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'pesca_files_entrada_home', 'String', '${pesca_files_home}/entrada')\
INSERT INTO portico.tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'pesca_files_procesado_home', 'String', '${pesca_files_home}/procesado')\
INSERT INTO portico.tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'pesca_files_erroneo_home', 'String', '${pesca_files_home}/erroneo')\
INSERT INTO portico.tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'manifiesto_files_home', 'String', '${servicio_files_home}/manifiesto')\
INSERT INTO portico.tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'manifiesto_files_entrada_home', 'String', '${manifiesto_files_home}/entrada')\
INSERT INTO portico.tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'manifiesto_files_procesado_home', 'String', '${manifiesto_files_home}/procesado')\
INSERT INTO portico.tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'manifiesto_files_erroneo_home', 'String', '${manifiesto_files_home}/erroneo')\
INSERT INTO portico.tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'escala_files_home', 'String', '${servicio_files_home}/escala')\
INSERT INTO portico.tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'escala_files_entrada_home', 'String', '${escala_files_home}/entrada')\
INSERT INTO portico.tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'escala_files_procesado_home', 'String', '${escala_files_home}/procesado')\
INSERT INTO portico.tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'escala_files_erroneo_home', 'String', '${escala_files_home}/erroneo')\
INSERT INTO portico.tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'files_home', 'String', '/home/xeredi/proyectos/files/portico')\
INSERT INTO portico.tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'filter_limit', 'Long', '5')\
INSERT INTO portico.tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'webapp_install_path', 'String', '/home/xeredi/proyectos/team/git/portico/integra-portico-web/src/main/webapp')\
INSERT INTO portico.tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'db_migration_dataSource_driver', 'String', 'oracle.jdbc.OracleDriver')\
INSERT INTO portico.tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'db_migration_dataSource_url', 'String', 'jdbc:oracle:thin:@localhost:1521:orcl')\
INSERT INTO portico.tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'db_migration_dataSource_username', 'String', 'integra')\
INSERT INTO portico.tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'db_migration_dataSource_password', 'String', 'integra')\


-- Mensajes i18n
CREATE TABLE tbl_message_mesg (
	mesg_key VARCHAR2(100) NOT NULL
	, mesg_internal INT NOT NULL

	, CONSTRAINT pk_mesg PRIMARY KEY (mesg_key)
)\

CREATE OR REPLACE SYNONYM portico.tbl_message_mesg FOR tbl_message_mesg\

GRANT SELECT ON tbl_message_mesg TO portico\

CREATE TABLE tbl_message_i18n_m18n (
	m18n_key VARCHAR2(100) NOT NULL
	, m18n_language VARCHAR2(5) NOT NULL
	, m18n_value VARCHAR2(250) NOT NULL

	, CONSTRAINT pk_m18n PRIMARY KEY (m18n_key, m18n_language)

	, CONSTRAINT fk_m18n_mesg_key FOREIGN KEY (m18n_key)
		REFERENCES tbl_message_mesg (mesg_key)
)\

CREATE OR REPLACE SYNONYM portico.tbl_message_i18n_m18n FOR tbl_message_i18n_m18n\

GRANT SELECT, INSERT, DELETE ON tbl_message_i18n_m18n TO portico\



INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'app_nombre')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'app_nombre', 'Argo')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'menu')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'menu', 'Menu')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'errorList')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'errorList', 'Errores')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'filtro')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'filtro', 'Filtro')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('en', 'filtro', 'Filter')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'filtro_limit')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'filtro_limit', 'Máx. Resultados')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'grid_count')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'grid_count', '{{count}} Resultado(s)')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'format_date')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'format_date', 'dd/MM/yyyy')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'format_datetime')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'format_datetime', 'dd/MM/yyyy HH:mm')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'format_true')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'format_true', 'Si')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'format_false')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'format_false', 'No')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'format_1')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'format_1', 'Si')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'format_0')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'format_0', 'No')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'btn_buscar')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'btn_buscar', 'Buscar')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'btn_volver')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'btn_volver', 'Volver')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'btn_aceptar')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'btn_aceptar', 'Aceptar')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'btn_cancelar')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'btn_cancelar', 'Cancelar')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'btn_crear')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'btn_crear', 'Nuevo')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'btn_editar')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'btn_editar', 'Editar')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'btn_guardar')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'btn_guardar', 'Guardar')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'btn_borrar')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'btn_borrar', 'Borrar')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'btn_duplicar')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'btn_duplicar', 'Duplicar')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'btn_filtrar')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'btn_filtrar', 'Filtro')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'btn_exportar')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'btn_exportar', 'Exportar')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'btn_imprimir')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'btn_imprimir', 'Imprimir')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'btn_recargar')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'btn_recargar', 'Recargar')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'btn_valorar')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'btn_valorar', 'Valorar')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'btn_valoraciones')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'btn_valoraciones', 'Valoraciones')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'btn_facturar')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'btn_facturar', 'Facturar')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'btn_facturas')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'btn_facturas', 'Facturas')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'btn_cargar')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'btn_cargar', 'Cargar')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'btn_start')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'btn_start', 'Iniciar')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'btn_pause')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'btn_pause', 'Pausar')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'btn_shutdown')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'btn_shutdown', 'Apagado Inmediato')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'btn_shutdownClean')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'btn_shutdownClean', 'Apagado')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'sec_facturacion')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'sec_facturacion', 'Facturación')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'sec_administracion')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'sec_administracion', 'Administración')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'sec_metamodelo')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'sec_metamodelo', 'Metamodelo')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'sec_configuracion')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'sec_configuracion', 'Configuración')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'sec_job')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'sec_job', 'Procesos Batch')\

INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'enti')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enti', 'Entidad')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'entiList')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'entiList', 'Entidades')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'enti_codigo')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enti_codigo', 'Código')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'enti_tipo')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enti_tipo', 'Tipo')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'enti_nombre')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enti_nombre', 'Nombre')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'enti_cmdAlta')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enti_cmdAlta', 'Alta?')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'enti_cmdBaja')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enti_cmdBaja', 'Baja?')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'enti_cmdEdicion')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enti_cmdEdicion', 'Edición?')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'enti_cmdDuplicado')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enti_cmdDuplicado', 'Duplicado?')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'enti_maxGrid')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enti_maxGrid', 'Grid Máx (filas)')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'enti_engdList')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enti_engdList', 'Grupos de Datos')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'enti_entdList')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enti_entdList', 'Datos')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'enti_entdGridList')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enti_entdGridList', 'Datos del Grid')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'enti_entiPadresList')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enti_entiPadresList', 'Entidades Padre')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'enti_entiHijasList')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enti_entiHijasList', 'Entidades Hija')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'enti_enacList')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enti_enacList', 'Acciones')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'enti_enagList')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enti_enagList', 'Acciones Asociadas al Grid')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'enti_i18n')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enti_i18n', 'I18n?')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'enti_tempExp')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enti_tempExp', 'Temporal?')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'enti_tpdt')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enti_tpdt', 'T. Dato')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'enti_tppr')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enti_tppr', 'Maestro')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'enti_tpprAsociado')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enti_tpprAsociado', 'Maestro Asociado')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'enti_temporal')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enti_temporal', 'Temporal?')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'enti_facturable')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enti_facturable', 'Facturable?')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'enti_exencionable')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enti_exencionable', 'Exencionable?')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'enti_tpdtEstado')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enti_tpdtEstado', 'T. Dato Estado')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'enti_tpdtNombre')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enti_tpdtNombre', 'T. Dato Nombre')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'enti_tpsr')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enti_tpsr', 'Tipo de Servicio')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'enti_classpath')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enti_classpath', 'Classpath')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'tppr')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'tppr', 'Maestro')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'tpprList')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'tpprList', 'Maestros')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'tpsp')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'tpsp', 'Maestro Dependiente')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'tpspList')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'tpspList', 'Maestros Dependientes')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'tpsr')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'tpsr', 'Tipo de Servicio')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'tpsrList')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'tpsrList', 'Tipos de Servicio')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'tpss')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'tpss', 'Tipo de Subservicio')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'tpssList')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'tpssList', 'Tipos de Subservicio')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'tpes')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'tpes', 'Tipo de Estadística')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'tpesList')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'tpesList', 'Tipos de Estadística')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'cmag')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'cmag', 'Campo de Agregación')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'cmagList')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'cmagList', 'Campos de Agregación')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'cmag_entd')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'cmag_entd', 'Dato')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'cmag_nombre')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'cmag_nombre', 'Nombre')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'cmag_agregar')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'cmag_agregar', 'Agregar?')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'enac')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enac', 'Acción Asociada a Entidad')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'enacList')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enacList', 'Acciones Asociadas a Entidad')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'enac_enti')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enac_enti', 'Entidad')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'enac_path')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enac_path', 'Path')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'enac_etiqueta')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enac_etiqueta', 'Etiqueta')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'enac_orden')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enac_orden', 'Orden')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'enag')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enag', 'Acción Asociada al grid de la Entidad')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'enagList')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enagList', 'Acciónes Asociadas al grid de la Entidad')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'enag_enti')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enag_enti', 'Entidad')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'enag_path')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enag_path', 'Ruta (URL)')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'enag_etiqueta')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enag_etiqueta', 'Etiqueta')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'enag_orden')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enag_orden', 'Orden')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'enen')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enen', 'Dependencia entre Entidades')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'enenList')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enenList', 'Dependencias entre Entidades')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'enen_entiPadre')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enen_entiPadre', 'Entidad Padre')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'enen_entiHija')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enen_entiHija', 'Entidad Hija')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'enen_orden')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enen_orden', 'Orden')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'engd')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'engd', 'Grupo de Datos')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'engdList')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'engdList', 'Grupos de Datos')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'engd_enti')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'engd_enti', 'Entidad')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'engd_numero')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'engd_numero', 'Nº')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'engd_etiqueta')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'engd_etiqueta', 'Etiqueta')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'entd')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'entd', 'Dato de Entidad')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'entdList')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'entdList', 'Datos de Entidad')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'entd_enti')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'entd_enti', 'Entidad')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'entd_tpdt')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'entd_tpdt', 'Tipo de Dato')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'entd_grupo')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'entd_grupo', 'Grupo')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'entd_fila')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'entd_fila', 'Fila')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'entd_orden')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'entd_orden', 'Orden')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'entd_span')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'entd_span', 'Span')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'entd_spanLg')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'entd_spanLg', 'Span (Lg)')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'entd_obligatorio')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'entd_obligatorio', 'Obligatorio?')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'entd_gridable')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'entd_gridable', 'Gridable?')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'entd_filtrable')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'entd_filtrable', 'Filtrable?')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'entd_valorDefecto')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'entd_valorDefecto', 'V. Defecto')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'entd_etiqueta')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'entd_etiqueta', 'Etiqueta')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'EntidadTipo_P')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'EntidadTipo_P', 'Maestro')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'EntidadTipo_B')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'EntidadTipo_B', 'Maestro Dependiente')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'EntidadTipo_T')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'EntidadTipo_T', 'Tipo de Servicio')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'EntidadTipo_S')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'EntidadTipo_S', 'Tipo de Subservicio')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'EntidadTipo_E')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'EntidadTipo_E', 'Tipo de Estadística')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'tpdt')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'tpdt', 'Tipo de Dato')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'tpdtList')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'tpdtList', 'Tipos de Dato')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'tpdt_codigo')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'tpdt_codigo', 'Código')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'tpdt_nombre')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'tpdt_nombre', 'Nombre')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'tpdt_tpht')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'tpdt_tpht', 'Tipo HTML')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'tpdt_enti')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'tpdt_enti', 'Entidad')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'tpdt_tpel')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'tpdt_tpel', 'Tipo de Elemento')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'tpdt_cdrfList')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'tpdt_cdrfList', 'Códigos de Referencia')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'HtmlTipo_T')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'HtmlTipo_T', 'T - Textfield')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'HtmlTipo_S')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'HtmlTipo_S', 'S - Select')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'HtmlTipo_CB')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'HtmlTipo_CB', 'CB - Checkbox')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'HtmlTipo_D')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'HtmlTipo_D', 'D - Date')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'HtmlTipo_DT')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'HtmlTipo_DT', 'DT - Datetime')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'HtmlTipo_F')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'HtmlTipo_F', 'F - Filtro')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'HtmlTipo_TA')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'HtmlTipo_TA', 'TA - Textarea')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'ElementoTipo_ND')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ElementoTipo_ND', 'Nº Decimal')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'ElementoTipo_NE')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ElementoTipo_NE', 'Nº Entero')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'ElementoTipo_TX')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ElementoTipo_TX', 'Texto')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'ElementoTipo_FE')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ElementoTipo_FE', 'Fecha')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'ElementoTipo_FH')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ElementoTipo_FH', 'Fecha/Hora')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'ElementoTipo_PR')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ElementoTipo_PR', 'Maestro')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'ElementoTipo_BO')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ElementoTipo_BO', 'Booleano')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'ElementoTipo_CR')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ElementoTipo_CR', 'Cód. Referencia')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'ElementoTipo_SR')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ElementoTipo_SR', 'Servicio')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'cdrf')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'cdrf', 'Código de Referencia')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'cdrfList')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'cdrfList', 'Códigos de Referencia')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'cdrf_tpdt')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'cdrf_tpdt', 'Tipo de Dato')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'cdrf_valor')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'cdrf_valor', 'Valor')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'cdrf_orden')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'cdrf_orden', 'Orden')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'cdrf_texto')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'cdrf_texto', 'Texto')\

INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'page_home')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'page_home', 'Inicio')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'page_grid')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'page_grid', 'Listado')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'page_detail')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'page_detail', 'Detalle')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'page_create')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'page_create', 'Nuevo')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'page_duplicate')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'page_duplicate', 'Duplicado')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'page_edit')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'page_edit', 'Edición')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'i18n_text')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'i18n_text', 'Nombre')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'i18n_text_lang')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'i18n_text_lang', 'Nombre {{lang}}')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'prmt')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'prmt', 'Maestro')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'prmtList')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'prmtList', 'Maestros')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'prmt_parametro')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'prmt_parametro', 'Código')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'prmt_fini')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'prmt_fini', 'F. Inicio')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'prmt_ffin')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'prmt_ffin', 'F. Fin')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'prmt_fvigencia')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'prmt_fvigencia', 'F. Vigencia')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'sprm')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'sprm', 'Maestro Dependiente')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'sprm_fini')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'sprm_fini', 'F. Inicio')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'sprm_ffin')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'sprm_ffin', 'F. Fin')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'srvc')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'srvc', 'Servicio')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'srvcList')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'srvcList', 'Servicios')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'srvc_tpsr')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'srvc_tpsr', 'T. Servicio')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'srvc_subp')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'srvc_subp', 'Subpuerto')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'srvc_anno')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'srvc_anno', 'Año')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'srvc_numero')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'srvc_numero', 'Nº')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'srvc_fini')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'srvc_fini', 'F. Inicio')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'srvc_ffin')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'srvc_ffin', 'F. Fin')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'srvc_falta')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'srvc_falta', 'F. Alta')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'srvc_fref')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'srvc_fref', 'F. Referencia')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'srvc_estado')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'srvc_estado', 'Estado')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'ssrv')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ssrv', 'Subservicio')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'ssrv_tpss')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ssrv_tpss', 'T. Subservicio')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'ssrv_srvc')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ssrv_srvc', 'Servicio')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'ssrv_estado')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ssrv_estado', 'Estado')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'ssrv_numero')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ssrv_numero', 'Nº')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'ssrv_fini')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ssrv_fini', 'F. Inicio')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'ssrv_ffin')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ssrv_ffin', 'F. Fin')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'pepr')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'pepr', 'Período de proceso')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'peprList')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'peprList', 'Períodos de proceso')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'pepr_autp')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'pepr_autp', 'Aut. Portuaria')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'pepr_anio')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'pepr_anio', 'Año')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'pepr_mes')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'pepr_mes', 'Mes')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'pepr_file')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'pepr_file', 'Archivo')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'pepr_falta')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'pepr_falta', 'F. Alta')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'pepr_sobreescribir')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'pepr_sobreescribir', 'Sobreescribir?')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'pepr_cdmsGenerado')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'pepr_cdmsGenerado', 'C. Mensual?')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'cdms')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'cdms', 'Cuadro Mensual')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'estd')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'estd', 'Estadística')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'estdList')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'estdList', 'Estadísticas')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'estd_tpes')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'estd_tpes', 'Informe')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'estd_pepr')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'estd_pepr', 'P. Proceso')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'estd_subp')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'estd_subp', 'Subpuerto')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'prbt')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'prbt', 'Proceso')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'prbtList')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'prbtList', 'Procesos')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'prbt_modulo')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'prbt_modulo', 'Módulo')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'prbt_tipo')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'prbt_tipo', 'Tipo')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'prbt_estado')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'prbt_estado', 'Estado')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'prbt_falta')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'prbt_falta', 'F. Alta')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'prbt_fini')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'prbt_fini', 'F. Inicio')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'prbt_ffin')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'prbt_ffin', 'F. Fin')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'prbt_duracion')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'prbt_duracion', 'Duración (mseg)')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'prbt_erroresCnt')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'prbt_erroresCnt', 'Nº Errores')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'prbt_alertasCnt')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'prbt_alertasCnt', 'Nº Alertas')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'prbt_mensajesCnt')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'prbt_mensajesCnt', 'Nº Mensajes')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'prmnList')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'prmnList', 'Mensajes')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'prmn_nivel')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'prmn_nivel', 'Nivel')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'prmn_codigo')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'prmn_codigo', 'Código')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'prmn_mensaje')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'prmn_mensaje', 'Mensaje')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'prpmList')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'prpmList', 'Parámetros')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'prpm_nombre')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'prpm_nombre', 'Nombre')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'prpm_valor')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'prpm_valor', 'Valor')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'prarList')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'prarList', 'Ficheros')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'prarEntList')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'prarEntList', 'Ficheros Ent.')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'prarSalList')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'prarSalList', 'Ficheros Sal.')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'prar_nombre')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'prar_nombre', 'Nombre')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'pritList')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'pritList', 'Elementos')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'pritEntList')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'pritEntList', 'Elementos Ent.')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'pritSalList')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'pritSalList', 'Elementos Sal.')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'prit_nombre')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'prit_nombre', 'Nombre')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'prit_tipo')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'prit_tipo', 'Tipo')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'prit_enti')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'prit_enti', 'Entidad')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'ItemTipo_srvc')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ItemTipo_srvc', 'Servicio')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'ItemTipo_ssrv')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ItemTipo_ssrv', 'Subservicio')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'ItemTipo_vlrc')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ItemTipo_vlrc', 'Valoración')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'ItemTipo_fctr')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ItemTipo_fctr', 'Factura')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'ItemTipo_pepr')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ItemTipo_pepr', 'Período de Proceso')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'arch')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'arch', 'Archivo')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'archList')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'archList', 'Archivos')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'arch_nombre')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'arch_nombre', 'Nombre')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'arch_falta')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'arch_falta', 'F. Alta')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'arch_tamanio')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'arch_tamanio', 'Tamaño (bytes)')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'aspc')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc', 'Aspecto')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'aspcList')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspcList', 'Aspectos')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'aspc_cList')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_cList', 'Elementos de Cabecera')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'aspc_lcList')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_lcList', 'Elementos Cuantitativos de Línea')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'aspc_liList')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_liList', 'Elementos Informativos de Línea')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'aspc_ascrList')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_ascrList', 'Cargos Asociados al Aspecto')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'aspc_codigo')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_codigo', 'Código')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'aspc_descripcion')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_descripcion', 'Descripción')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'aspc_tpsr')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_tpsr', 'T. Servicio')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'aspc_fini')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_fini', 'F. Inicio')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'aspc_ffin')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_ffin', 'F. Fin')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'aspc_prioridad')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_prioridad', 'Prioridad')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'aspc_cetiqInfo')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_cetiqInfo', 'Elemento Informativo Cabecera')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'aspc_cetiqInfo1')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_cetiqInfo1', 'Elemento Informativo Cabecera 1')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'aspc_cetiqInfo2')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_cetiqInfo2', 'Elemento Informativo Cabecera 2')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'aspc_cetiqInfo3')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_cetiqInfo3', 'Elemento Informativo Cabecera 3')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'aspc_cetiqInfo4')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_cetiqInfo4', 'Elemento Informativo Cabecera 4')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'aspc_cetiqInfo5')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_cetiqInfo5', 'Elemento Informativo Cabecera 5')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'aspc_cetiqInfo6')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_cetiqInfo6', 'Elemento Informativo Cabecera 6')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'aspc_cpathInfo')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_cpathInfo', 'Ruta Elem. Informativo Cabecera')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'aspc_cpathInfo1')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_cpathInfo1', 'Ruta Elem. Informativo Cabecera 1')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'aspc_cpathInfo2')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_cpathInfo2', 'Ruta Elem. Informativo Cabecera 2')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'aspc_cpathInfo3')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_cpathInfo3', 'Ruta Elem. Informativo Cabecera 3')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'aspc_cpathInfo4')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_cpathInfo4', 'Ruta Elem. Informativo Cabecera 4')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'aspc_cpathInfo5')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_cpathInfo5', 'Ruta Elem. Informativo Cabecera 5')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'aspc_cpathInfo6')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_cpathInfo6', 'Ruta Elem. Informativo Cabecera 6')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'aspc_cgrpInfo')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_cgrpInfo', 'Agrupar Elem. Informativo Cabecera?')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'aspc_cgrpInfo1')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_cgrpInfo1', 'Agrupar Elem. Informativo Cabecera 1?')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'aspc_cgrpInfo2')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_cgrpInfo2', 'Agrupar Elem. Informativo Cabecera 2?')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'aspc_cgrpInfo3')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_cgrpInfo3', 'Agrupar Elem. Informativo Cabecera 3?')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'aspc_cgrpInfo4')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_cgrpInfo4', 'Agrupar Elem. Informativo Cabecera 4?')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'aspc_cgrpInfo5')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_cgrpInfo5', 'Agrupar Elem. Informativo Cabecera 5?')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'aspc_cgrpInfo6')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_cgrpInfo6', 'Agrupar Elem. Informativo Cabecera 6?')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'aspc_lsumCuant')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_lsumCuant', 'Sumarizar Elem. Cuantitativo Línea?')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'aspc_lsumCuant1')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_lsumCuant1', 'Sumarizar Elem. Cuantitativo Línea 1?')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'aspc_lsumCuant2')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_lsumCuant2', 'Sumarizar Elem. Cuantitativo Línea 2?')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'aspc_lsumCuant3')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_lsumCuant3', 'Sumarizar Elem. Cuantitativo Línea 3?')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'aspc_lsumCuant4')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_lsumCuant4', 'Sumarizar Elem. Cuantitativo Línea 4?')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'aspc_lsumCuant5')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_lsumCuant5', 'Sumarizar Elem. Cuantitativo Línea 5?')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'aspc_lsumCuant6')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_lsumCuant6', 'Sumarizar Elem. Cuantitativo Línea 6?')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'aspc_lgrpInfo')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_lgrpInfo', 'Agrupar Elem. Informativo Línea?')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'aspc_lgrpInfo1')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_lgrpInfo1', 'Agrupar Elem. Informativo Línea 1?')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'aspc_lgrpInfo2')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_lgrpInfo2', 'Agrupar Elem. Informativo Línea 2?')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'aspc_lgrpInfo3')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_lgrpInfo3', 'Agrupar Elem. Informativo Línea 3?')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'aspc_lgrpInfo4')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_lgrpInfo4', 'Agrupar Elem. Informativo Línea 4?')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'aspc_lgrpInfo5')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_lgrpInfo5', 'Agrupar Elem. Informativo Línea 5?')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'aspc_lgrpInfo6')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_lgrpInfo6', 'Agrupar Elem. Informativo Línea 6?')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'aspc_fechaVigencia')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_fechaVigencia', 'F. Vigencia')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'ascr')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ascr', 'Cargo de Aspecto')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'ascr_crgo')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ascr_crgo', 'Cargo')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'ascr_fini')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ascr_fini', 'F. Inicio')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'ascr_ffin')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ascr_ffin', 'F. Fin')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'crgo')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'crgo', 'Cargo')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'crgoList')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'crgoList', 'Cargos')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'crgo_codigo')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'crgo_codigo', 'Código')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'crgo_descripcion')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'crgo_descripcion', 'Descripción')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'crgo_fini')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'crgo_fini', 'F. Inicio')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'crgo_ffin')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'crgo_ffin', 'F. Fin')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'crgo_codigoNormalizado')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'crgo_codigoNormalizado', 'Cód. Normalizado')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'crgo_tipo')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'crgo_tipo', 'Tipo')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'crgo_tpsr')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'crgo_tpsr', 'T. Servicio')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'crgo_principal')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'crgo_principal', 'Principal?')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'crgo_temporal')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'crgo_temporal', 'Temporal?')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'crgo_fechaVigencia')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'crgo_fechaVigencia', 'F. Vigencia')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'rgla')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'rgla', 'Regla')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'rglaList')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'rglaList', 'Reglas')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'rgla_codigo')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'rgla_codigo', 'Código')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'rgla_crgo')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'rgla_crgo', 'Cargo')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'rgla_tipo')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'rgla_tipo', 'Tipo')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'rgla_enti')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'rgla_enti', 'Entidad')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'rgla_fini')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'rgla_fini', 'F. Inicio')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'rgla_ffin')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'rgla_ffin', 'F. Fin')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'rgla_orden')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'rgla_orden', 'Orden')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'rgla_condicion')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'rgla_condicion', 'Condición')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'rgla_formula')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'rgla_formula', 'Fórmula')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'rgla_importeBase')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'rgla_importeBase', 'Importe Base')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'rgla_pathImpuesto')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'rgla_pathImpuesto', 'Ruta Impuesto')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'rgla_pathPagador')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'rgla_pathPagador', 'Ruta Pagador')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'rgla_pathEsSujPasivo')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'rgla_pathEsSujPasivo', 'Ruta Es Sujeto Pasivo')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'rgla_pathCodExen')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'rgla_pathCodExen', 'Ruta Cód. Exención')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'rgla_etiqInfo')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'rgla_etiqInfo', 'Etiq. Elem. Informativo')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'rgla_etiqInfo1')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'rgla_etiqInfo1', 'Etiq. Elem. Informativo 1')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'rgla_etiqInfo2')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'rgla_etiqInfo2', 'Etiq. Elem. Informativo 2')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'rgla_etiqInfo3')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'rgla_etiqInfo3', 'Etiq. Elem. Informativo 3')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'rgla_etiqInfo4')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'rgla_etiqInfo4', 'Etiq. Elem. Informativo 4')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'rgla_etiqInfo5')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'rgla_etiqInfo5', 'Etiq. Elem. Informativo 5')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'rgla_etiqInfo6')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'rgla_etiqInfo6', 'Etiq. Elem. Informativo 6')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'rgla_pathInfo')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'rgla_pathInfo', 'Ruta Elem. Informativo')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'rgla_pathInfo1')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'rgla_pathInfo1', 'Ruta Elem. Informativo 1')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'rgla_pathInfo2')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'rgla_pathInfo2', 'Ruta Elem. Informativo 2')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'rgla_pathInfo3')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'rgla_pathInfo3', 'Ruta Elem. Informativo 3')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'rgla_pathInfo4')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'rgla_pathInfo4', 'Ruta Elem. Informativo 4')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'rgla_pathInfo5')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'rgla_pathInfo5', 'Ruta Elem. Informativo 5')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'rgla_pathInfo6')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'rgla_pathInfo6', 'Ruta Elem. Informativo 6')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'rgla_etiqCuant')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'rgla_etiqCuant', 'Etiq. Elem. Cuantitativo')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'rgla_etiqCuant1')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'rgla_etiqCuant1', 'Etiq. Elem. Cuantitativo 1')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'rgla_etiqCuant2')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'rgla_etiqCuant2', 'Etiq. Elem. Cuantitativo 2')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'rgla_etiqCuant3')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'rgla_etiqCuant3', 'Etiq. Elem. Cuantitativo 3')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'rgla_etiqCuant4')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'rgla_etiqCuant4', 'Etiq. Elem. Cuantitativo 4')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'rgla_etiqCuant5')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'rgla_etiqCuant5', 'Etiq. Elem. Cuantitativo 5')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'rgla_etiqCuant6')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'rgla_etiqCuant6', 'Etiq. Elem. Cuantitativo 6')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'rgla_pathCuant')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'rgla_pathCuant', 'Ruta Elem. Cuantitativo')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'rgla_pathCuant1')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'rgla_pathCuant1', 'Ruta Elem. Cuantitativo 1')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'rgla_pathCuant2')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'rgla_pathCuant2', 'Ruta Elem. Cuantitativo 2')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'rgla_pathCuant3')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'rgla_pathCuant3', 'Ruta Elem. Cuantitativo 3')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'rgla_pathCuant4')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'rgla_pathCuant4', 'Ruta Elem. Cuantitativo 4')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'rgla_pathCuant5')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'rgla_pathCuant5', 'Ruta Elem. Cuantitativo 5')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'rgla_pathCuant6')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'rgla_pathCuant6', 'Ruta Elem. Cuantitativo 6')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'rgin')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'rgin', 'Incompatibilidad entre Reglas')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'rginList')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'rginList', 'Incompatibilidades entre Reglas')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'rgin_fini')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'rgin_fini', 'F. Inicio')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'rgin_ffin')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'rgin_ffin', 'F. Fin')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'rgin_rgla2')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'rgin_rgla2', 'Regla Incompatible')\

INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrc')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrc', 'Valoración')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrcList')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrcList', 'Valoraciones')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrc_id')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrc_id', 'ID')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrc_srvc')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrc_srvc', 'Servicio')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrc_aspc')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrc_aspc', 'Aspecto')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrc_pagador')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrc_pagador', 'Pagador')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrc_importe')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrc_importe', 'Importe')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrc_impuesto')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrc_impuesto', 'Impuesto')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrc_fliq')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrc_fliq', 'F. Liquidación')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrc_falta')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrc_falta', 'F. Alta')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrc_fini')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrc_fini', 'F. Inicio')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrc_ffin')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrc_ffin', 'F. Fin')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrc_sujPasivo')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrc_sujPasivo', 'Suj. Pasivo?')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrc_codExencion')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrc_codExencion', 'Cód. Exención')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrgList')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrgList', 'Cargos')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrg_crgo')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrg_crgo', 'Cargo')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrg_importe')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrg_importe', 'Importe')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlriList')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlriList', 'Impuestos')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlri_impuesto')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlri_impuesto', 'Impuesto')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlri_porcentaje')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlri_porcentaje', '%')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlri_importe_base')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlri_importe_base', 'Imp. Base')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlri_importe_impuesto')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlri_importe_impuesto', 'Importe')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrl')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrl', 'Linea de Valoración')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrlList')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrlList', 'Lineas de Valoración')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrl_rgla')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrl_rgla', 'Regla')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrl_rgla_tipo')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrl_rgla_tipo', 'Tipo')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrl_importeBase')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrl_importeBase', 'Imp. Base')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrl_importe')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrl_importe', 'Importe')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrl_impuesto')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrl_impuesto', 'Impuesto')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrl_fini')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrl_fini', 'F. Inicio')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrl_ffin')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrl_ffin', 'F. Fin')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrl_info1')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrl_info1', 'Info. 1')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrl_info2')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrl_info2', 'Info. 2')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrl_info3')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrl_info3', 'Info. 3')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrl_info4')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrl_info4', 'Info. 4')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrl_info5')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrl_info5', 'Info. 5')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrl_info6')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrl_info6', 'Info. 6')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrl_cuant1')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrl_cuant1', 'Cuant. 1')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrl_cuant2')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrl_cuant2', 'Cuant. 2')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrl_cuant3')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrl_cuant3', 'Cuant. 3')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrl_cuant4')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrl_cuant4', 'Cuant. 4')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrl_cuant5')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrl_cuant5', 'Cuant. 5')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrl_cuant6')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrl_cuant6', 'Cuant. 6')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrd')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrd', 'Detalle de Valoración')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrdList')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrdList', 'Detalles de Valoración')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrd_valorBase')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrd_valorBase', 'Valor Base')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrd_importeBase')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrd_importeBase', 'Imp. Base')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrd_importe')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrd_importe', 'Importe')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrd_ssrv')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrd_ssrv', 'Subservicio')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrd_fini')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrd_fini', 'F. Inicio')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrd_ffin')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrd_ffin', 'F. Fin')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrd_info1')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrd_info1', 'Info. 1')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrd_info2')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrd_info2', 'Info. 2')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrd_info3')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrd_info3', 'Info. 3')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrd_info4')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrd_info4', 'Info. 4')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrd_info5')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrd_info5', 'Info. 5')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrd_info6')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrd_info6', 'Info. 6')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrd_cuant1')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrd_cuant1', 'Cuant. 1')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrd_cuant2')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrd_cuant2', 'Cuant. 2')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrd_cuant3')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrd_cuant3', 'Cuant. 3')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrd_cuant4')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrd_cuant4', 'Cuant. 4')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrd_cuant5')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrd_cuant5', 'Cuant. 5')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrd_cuant6')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrd_cuant6', 'Cuant. 6')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fcsr')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fcsr', 'Serie de Factura')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fcsrList')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fcsrList', 'Series de Factura')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fcsr_serie')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fcsr_serie', 'Serie')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fcsr_anio')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fcsr_anio', 'Año')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fcsr_numeroUltimo')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fcsr_numeroUltimo', 'Último Nº')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fctr')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fctr', 'Factura')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fctrList')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fctrList', 'Facturas')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fctr_ffac')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fctr_ffac', 'F. Facturación')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fctr_aspc')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fctr_aspc', 'Aspecto')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fctr_importe')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fctr_importe', 'Importe')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fctr_impuesto')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fctr_impuesto', 'Impuesto')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fctr_pagador')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fctr_pagador', 'Pagador')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fctr_falta')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fctr_falta', 'F. Alta')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fctr_fini')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fctr_fini', 'F. Inicio')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fctr_ffin')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fctr_ffin', 'F. Fin')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fctsList')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fctsList', 'Servicios')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fcts_srvc')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fcts_srvc', 'Servicio')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fcts_fref')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fcts_fref', 'F. Referencia')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fcts_fini')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fcts_fini', 'F. Inicio')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fcts_ffin')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fcts_ffin', 'F. Fin')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fcts_codExencion')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fcts_codExencion', 'Cód. Exención')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fctgList')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fctgList', 'Cargos')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fctg_crgo')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fctg_crgo', 'Cargo')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fctg_importe')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fctg_importe', 'Importe')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fctiList')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fctiList', 'Impuestos')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fcti_impuesto')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fcti_impuesto', 'Impuesto')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fcti_porcentaje')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fcti_porcentaje', '%')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fcti_importe_base')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fcti_importe_base', 'Importe Base')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fcti_importe_impuesto')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fcti_importe_impuesto', 'Importe Impuesto')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fctl')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fctl', 'Línea de Factura')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fctlList')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fctlList', 'Líneas de Factura')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'conf')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'conf', 'Parámetro de Configuración')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'confList')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'confList', 'Parámetros de Configuración')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'conf_key')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'conf_key', 'Parámetro')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'conf_valueType')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'conf_valueType', 'Tipo')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'conf_value')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'conf_value', 'Valor')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'conf_defaultValue')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'conf_defaultValue', 'Valor Defecto')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'm18n')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'm18n', 'Mensaje i18n')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'm18nList')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'm18nList', 'Mensajes i18n')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'm18n_key')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'm18n_key', 'Clave')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'schr')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'schr', 'Planificador de Procesos')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (1, 'E00000')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'E00000', 'E00000 - Error no controlado: {0}')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (1, 'E00001')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'E00001', 'E00001 - Campo Obligatorio: {0}')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (1, 'E00002')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'E00002', 'E00002 - Campo Obligatorio: Descripción para el idioma {0}')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (1, 'E00005')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'E00005', 'E00005 - {0} duplicado/a')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (1, 'E00006')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'E00006', 'E00006 - Error de período de Vigencia. Fecha Fin ha de ser posterior a Fecha Inicio')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (1, 'E00008')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'E00008', 'E00008 - {0} con identificador {1} no encontrado/a')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (1, 'E00009')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'E00009', 'E00009 - {0} solapado/a con el período de vigencia')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (1, 'E00011')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'E00011', 'E00011 - Subservicio en estado {0} inválido para ejecutar la acción')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (1, 'E00012')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'E00012', 'E00012 - {0} solo admite los valores {1}')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (1, 'E00013')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'E00013', 'E00013 - Operación no Permitida: {0}')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'cdms_numero')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'cdms_numero', 'Nº')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'cdms_tm')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'cdms_tm', 'Tm')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'cdms_teus')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'cdms_teus', 'TEUS')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'cdms_ca')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'cdms_ca', 'Con Carga')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'cdms_va')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'cdms_va', 'Vacíos')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'cdms_embarcado')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'cdms_embarcado', 'Embarcado')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'cdms_desembarcado')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'cdms_desembarcado', 'Desembarcado')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'cdms_transito')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'cdms_transito', 'Tránsito')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'cdms_transbordo')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'cdms_transbordo', 'Transbordo')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'cdms_GL')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'cdms_GL', 'GRANELES LIQUIDOS')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'cdms_GLPETR')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'cdms_GLPETR', 'CRUDOS DE PETROLEO')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'cdms_GLGASN')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'cdms_GLGASN', 'GAS NATURAL')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'cdms_GLPREF')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'cdms_GLPREF', 'PRODUCTOS PETROLIFEROS REFINADOS')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'cdms_GLOTRO')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'cdms_GLOTRO', 'OTROS GRANELES LIQUIDOS')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'cdms_GS')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'cdms_GS', 'GRANELES SOLIDOS')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'cdms_GSIESP')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'cdms_GSIESP', 'POR INSTALACION ESPECIAL')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'cdms_GSNIES')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'cdms_GSNIES', 'SIN INSTALACION ESPECIAL')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'cdms_MG')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'cdms_MG', 'MERCANCIA GENERAL')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'cdms_PASAJE')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'cdms_PASAJE', 'Nº PASAJEROS (EXCLUIDO T. BAHIA)')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'cdms_PASCRU')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'cdms_PASCRU', 'Nº PASAJEROS DE CRUCERO')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'cdms_VET2')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'cdms_VET2', 'Nº VEHICULOS (Turismos en rég. pasaje, Automóviles y Autobuses)')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'cdms_CTEUS')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'cdms_CTEUS', 'TEUS (con carga y vacíos)')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'cdms_RR')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'cdms_RR', 'TRAFICO RO-RO')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'cdms_RRC')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'cdms_RRC', 'EN CONTENEDORES')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'cdms_RRO')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'cdms_RRO', 'EN OTROS MEDIOS')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'cdms_AV')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'cdms_AV', 'AVITUALLAMIENTO')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'cdms_AVPPET')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'cdms_AVPPET', 'PROD. PETROLIFEROS')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'cdms_AVOTRO')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'cdms_AVOTRO', 'OTROS')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'cdms_TRALOC')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'cdms_TRALOC', 'TRAFICO LOCAL')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'cdms_PESCAF')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'cdms_PESCAF', 'PESCA FRESCA')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'MensajeNivel_I')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'MensajeNivel_I', 'I - Información')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'MensajeNivel_W')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'MensajeNivel_W', 'W - Alerta')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'MensajeNivel_E')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'MensajeNivel_E', 'E - Error')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'ProcesoEstado_C')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ProcesoEstado_C', 'C - En Cola')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'ProcesoEstado_E')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ProcesoEstado_E', 'E - En Ejecución')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'ProcesoEstado_F')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ProcesoEstado_F', 'F - Finalizado')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'ProcesoModulo_S')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ProcesoModulo_S', 'S - Servicios')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'ProcesoModulo_E')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ProcesoModulo_E', 'E - Estadísticas')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'ProcesoModulo_F')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ProcesoModulo_F', 'F - Facturación')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'ProcesoTipo_ESC_CARGA')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ProcesoTipo_ESC_CARGA', 'Carga de Escala')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'ProcesoTipo_PES_CARGA')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ProcesoTipo_PES_CARGA', 'Carga de Manifiesto de Pesca')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'ProcesoTipo_MAN_CARGA')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ProcesoTipo_MAN_CARGA', 'Carga de Manifiesto de Mescancía')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'ProcesoTipo_EST_CARGA')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ProcesoTipo_EST_CARGA', 'Carga de Período de Proceso')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'ProcesoTipo_EST_CREACION')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ProcesoTipo_EST_CREACION', 'Creación de Período de Proceso')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'ProcesoTipo_VALORADOR')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ProcesoTipo_VALORADOR', 'Valorador')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'ProcesoTipo_FACTURADOR')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ProcesoTipo_FACTURADOR', 'Facturador')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'CargoTipo_T')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'CargoTipo_T', 'T - Tarifa')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'CargoTipo_B')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'CargoTipo_B', 'B - Tasa')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'ReglaTipo_T')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ReglaTipo_T', 'T - Precio')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'ReglaTipo_C')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ReglaTipo_C', 'C - Coeficiente')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'ReglaTipo_D')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ReglaTipo_D', 'D - Bonificación')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'ConfigurationValueType_String')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ConfigurationValueType_String', 'Texto')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'ConfigurationValueType_Boolean')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ConfigurationValueType_Boolean', 'Lógico')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'ConfigurationValueType_Double')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ConfigurationValueType_Double', 'Nº Decimal')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'ConfigurationValueType_Long')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ConfigurationValueType_Long', 'Nº Entero')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'ConfigurationValueType_Date')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ConfigurationValueType_Date', 'Fecha')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'ConfigurationValueType_DateTime')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ConfigurationValueType_DateTime', 'Fecha/Hora')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'ConfigurationValueType_StringList')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ConfigurationValueType_StringList', 'Lista de Textos')\

INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (1, 'mani_completar')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'mani_completar', 'Completar Manifiesto')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (1, 'mani_bloquear')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'mani_bloquear', 'Bloquear Manifiesto')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (1, 'mani_iniciar')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'mani_iniciar', 'Iniciar Manifiesto')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (1, 'mani_anular')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'mani_anular', 'Anular Manifiesto')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (1, 'mani_resumen')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'mani_resumen', 'Resumen Manifiesto')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (1, 'mabl_completar')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'mabl_completar', 'Completar BL')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (1, 'mabl_bloquear')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'mabl_bloquear', 'Bloquear BL')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (1, 'mabl_iniciar')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'mabl_iniciar', 'Iniciar BL')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (1, 'mabl_anular')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'mabl_anular', 'Anular BL')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (1, 'mabl_resumen')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'mabl_resumen', 'Resumen BL')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (1, 'part_bloquear')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'part_bloquear', 'Bloquear Partida')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (1, 'part_iniciar')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'part_iniciar', 'Iniciar Partida')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (1, 'part_anular')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'part_anular', 'Anular Partida')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (1, 'equi_bloquear')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'equi_bloquear', 'Bloquear Equipamiento')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (1, 'equi_iniciar')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'equi_iniciar', 'Iniciar Equipamiento')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (1, 'equi_anular')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'equi_anular', 'Anular Equipamiento')\

INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'page_verificarTotales')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'page_verificarTotales', 'Verificar Totales')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'mani_resumen_mercancias')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'mani_resumen_mercancias', 'Mercancías')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'mani_resumen_pasajeros')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'mani_resumen_pasajeros', 'Pasajeros')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'mani_resumen_numBlsMercancia')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'mani_resumen_numBlsMercancia', 'Nº BLs')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'mani_resumen_numBlsPasajeros')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'mani_resumen_numBlsPasajeros', 'Nº BLs')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'mani_resumen_numContenedores20')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'mani_resumen_numContenedores20', 'Contenedores 20')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'mani_resumen_numContenedores20Llenos')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'mani_resumen_numContenedores20Llenos', 'Llenos')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'mani_resumen_numContenedores20Vacios')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'mani_resumen_numContenedores20Vacios', 'Vacíos')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'mani_resumen_numContenedores40')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'mani_resumen_numContenedores40', 'Contenedores 40')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'mani_resumen_numContenedores40Llenos')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'mani_resumen_numContenedores40Llenos', 'Llenos')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'mani_resumen_numContenedores40Vacios')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'mani_resumen_numContenedores40Vacios', 'Vacíos')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'mani_resumen_numEquipamientos')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'mani_resumen_numEquipamientos', 'Equipamientos')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'mani_resumen_numEquipamientosLlenos')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'mani_resumen_numEquipamientosLlenos', 'Llenos')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'mani_resumen_numEquipamientosVacios')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'mani_resumen_numEquipamientosVacios', 'Vacíos')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'mani_resumen_numPartidasMercancia')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'mani_resumen_numPartidasMercancia', 'Nº Partidas')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'mani_resumen_pesoPartidasMercancia')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'mani_resumen_pesoPartidasMercancia', 'Peso Total (Kg)')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'mani_resumen_numPartidasPasajeros')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'mani_resumen_numPartidasPasajeros', 'Nº Partidas')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'mani_resumen_numPasajeros')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'mani_resumen_numPasajeros', 'Nº Pasajeros')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'mani_resumen_numCruceristas')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'mani_resumen_numCruceristas', 'Nº Cruceristas')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'mani_resumen_numVehiculos')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'mani_resumen_numVehiculos', 'Nº Vehículos')\

INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (1, 'atra_denegar')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'atra_denegar', 'Denegar Atraque')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (1, 'atra_autorizar')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'atra_autorizar', 'Autorizar Atraque')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (1, 'atra_anular')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'atra_anular', 'Anular Atraque')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (1, 'atra_iniciar')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'atra_iniciar', 'Iniciar Atraque')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (1, 'atra_finalizar')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'atra_finalizar', 'Finalizar Atraque')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (1, 'atra_cambiarMuelle')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'atra_cambiarMuelle', 'Cambiar Muelle Atraque')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (1, 'atra_autorizarFPrevio')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'atra_autorizarFPrevio', 'Autorizar Fondeo Previo Atraque')\



-- Campos de Agregacion de estadisticas
CREATE TABLE tbl_campo_agregacion_cmag (
	cmag_tpes_pk NUMBER(19) NOT NULL
	, cmag_entd_pk NUMBER(19) NOT NULL
	, cmag_agregar INT NOT NULL
	, cmag_nombre VARCHAR2(250)

	, CONSTRAINT pk_cmag PRIMARY KEY (cmag_tpes_pk, cmag_entd_pk)

	, CONSTRAINT fk_cmag_tpes_pk FOREIGN KEY (cmag_tpes_pk)
		REFERENCES tbl_tipo_estadistica_tpes (tpes_pk)
	, CONSTRAINT fk_cmag_entd_pk FOREIGN KEY (cmag_entd_pk)
		REFERENCES tbl_entidad_tipo_dato_entd (entd_pk)
)\

CREATE OR REPLACE SYNONYM portico.tbl_campo_agregacion_cmag FOR tbl_campo_agregacion_cmag\

GRANT SELECT, UPDATE ON tbl_campo_agregacion_cmag TO portico\

INSERT INTO portico.tbl_campo_agregacion_cmag (cmag_tpes_pk, cmag_entd_pk, cmag_agregar, cmag_nombre) VALUES (23000, 33003, 1, 'tipoOperacion')\
INSERT INTO portico.tbl_campo_agregacion_cmag (cmag_tpes_pk, cmag_entd_pk, cmag_agregar, cmag_nombre) VALUES (23000, 33006, 1, 'zonaPesca')\
INSERT INTO portico.tbl_campo_agregacion_cmag (cmag_tpes_pk, cmag_entd_pk, cmag_agregar, cmag_nombre) VALUES (23000, 33005, 1, 'artePesca')\
INSERT INTO portico.tbl_campo_agregacion_cmag (cmag_tpes_pk, cmag_entd_pk, cmag_agregar, cmag_nombre) VALUES (23000, 33007, 1, 'vendedor')\
INSERT INTO portico.tbl_campo_agregacion_cmag (cmag_tpes_pk, cmag_entd_pk, cmag_agregar, cmag_nombre) VALUES (23000, 33004, 1, 'especie')\

INSERT INTO portico.tbl_campo_agregacion_cmag (cmag_tpes_pk, cmag_entd_pk, cmag_agregar, cmag_nombre) VALUES (23001, 33028, 1, 'buque')\
INSERT INTO portico.tbl_campo_agregacion_cmag (cmag_tpes_pk, cmag_entd_pk, cmag_agregar, cmag_nombre) VALUES (23001, 33029, 1, 'tipoEstancia')\
INSERT INTO portico.tbl_campo_agregacion_cmag (cmag_tpes_pk, cmag_entd_pk, cmag_agregar, cmag_nombre) VALUES (23001, 33030, 1, 'servicio')\
INSERT INTO portico.tbl_campo_agregacion_cmag (cmag_tpes_pk, cmag_entd_pk, cmag_agregar, cmag_nombre) VALUES (23001, 33031, 1, 'acuerdo')\
INSERT INTO portico.tbl_campo_agregacion_cmag (cmag_tpes_pk, cmag_entd_pk, cmag_agregar, cmag_nombre) VALUES (23001, 33032, 1, 'consignatario')\

INSERT INTO portico.tbl_campo_agregacion_cmag (cmag_tpes_pk, cmag_entd_pk, cmag_agregar, cmag_nombre) VALUES (23002, 33042, 1, 'tipoMercancia')\
INSERT INTO portico.tbl_campo_agregacion_cmag (cmag_tpes_pk, cmag_entd_pk, cmag_agregar, cmag_nombre) VALUES (23002, 33043, 1, 'tipoOperacion')\
INSERT INTO portico.tbl_campo_agregacion_cmag (cmag_tpes_pk, cmag_entd_pk, cmag_agregar, cmag_nombre) VALUES (23002, 33044, 1, 'cliente')\
INSERT INTO portico.tbl_campo_agregacion_cmag (cmag_tpes_pk, cmag_entd_pk, cmag_agregar, cmag_nombre) VALUES (23002, 33045, 1, 'roro')\

INSERT INTO portico.tbl_campo_agregacion_cmag (cmag_tpes_pk, cmag_entd_pk, cmag_agregar, cmag_nombre) VALUES (23004, 33071, 1, 'consignatario')\
INSERT INTO portico.tbl_campo_agregacion_cmag (cmag_tpes_pk, cmag_entd_pk, cmag_agregar, cmag_nombre) VALUES (23004, 33072, 1, 'buque')\
INSERT INTO portico.tbl_campo_agregacion_cmag (cmag_tpes_pk, cmag_entd_pk, cmag_agregar, cmag_nombre) VALUES (23004, 33073, 1, 'servicio')\
INSERT INTO portico.tbl_campo_agregacion_cmag (cmag_tpes_pk, cmag_entd_pk, cmag_agregar, cmag_nombre) VALUES (23004, 33074, 1, 'alineacion')\

INSERT INTO portico.tbl_campo_agregacion_cmag (cmag_tpes_pk, cmag_entd_pk, cmag_agregar, cmag_nombre) VALUES (23005, 33106, 1, 'consignatario')\
INSERT INTO portico.tbl_campo_agregacion_cmag (cmag_tpes_pk, cmag_entd_pk, cmag_agregar, cmag_nombre) VALUES (23005, 33107, 1, 'buque')\
INSERT INTO portico.tbl_campo_agregacion_cmag (cmag_tpes_pk, cmag_entd_pk, cmag_agregar, cmag_nombre) VALUES (23005, 33108, 1, 'servicio')\
INSERT INTO portico.tbl_campo_agregacion_cmag (cmag_tpes_pk, cmag_entd_pk, cmag_agregar, cmag_nombre) VALUES (23005, 33105, 1, 'estibador')\
INSERT INTO portico.tbl_campo_agregacion_cmag (cmag_tpes_pk, cmag_entd_pk, cmag_agregar, cmag_nombre) VALUES (23005, 33109, 1, 'acuerdo')\
INSERT INTO portico.tbl_campo_agregacion_cmag (cmag_tpes_pk, cmag_entd_pk, cmag_agregar, cmag_nombre) VALUES (23005, 33110, 1, 'terminal')\
INSERT INTO portico.tbl_campo_agregacion_cmag (cmag_tpes_pk, cmag_entd_pk, cmag_agregar, cmag_nombre) VALUES (23005, 33111, 1, 'tipoEquipamiento')\


ALTER TABLE tbl_servicio_srvc
	ADD srvc_pepr_pk NUMBER(19)\


-- Guardar archivos en la BD
CREATE TABLE tbl_archivo_arch (
	arch_pk NUMBER(19) NOT NULL
	, arch_sentido CHAR(1) NOT NULL
	, arch_nombre VARCHAR2(100) NOT NULL
	, arch_tamanio INT NOT NULL
	, arch_falta TIMESTAMP NOT NULL
	, arch_archivo BLOB NOT NULL

	, CONSTRAINT pk_arch PRIMARY KEY (arch_pk)
)
\

CREATE OR REPLACE SYNONYM portico.tbl_archivo_arch FOR tbl_archivo_arch\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_archivo_arch TO portico\

DROP TABLE tbl_proceso_archivo_prar\

CREATE TABLE tbl_proceso_archivo_prar (
	prar_prbt_pk NUMBER(19) NOT NULL
	, prar_arch_pk NUMBER(19) NOT NULL

	, CONSTRAINT pk_prar PRIMARY KEY (prar_prbt_pk, prar_arch_pk)

	, CONSTRAINT fk_prar_prbt_pk FOREIGN KEY (prar_prbt_pk)
		REFERENCES tbl_proceso_batch_prbt (prbt_pk)
	, CONSTRAINT fk_prar_arch_pk FOREIGN KEY (prar_arch_pk)
		REFERENCES tbl_archivo_arch (arch_pk)
)
\

CREATE OR REPLACE SYNONYM portico.tbl_proceso_archivo_prar FOR tbl_proceso_archivo_prar\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_proceso_archivo_prar TO portico\

CREATE TABLE tbl_servicio_archivo_srar (
	srar_srvc_pk NUMBER(19) NOT NULL
	, srar_arch_pk NUMBER(19) NOT NULL

	, CONSTRAINT pk_srar PRIMARY KEY (srar_srvc_pk, srar_arch_pk)

	, CONSTRAINT fk_srar_srvc_pk FOREIGN KEY (srar_srvc_pk)
		REFERENCES tbl_servicio_srvc (srvc_pk)
	, CONSTRAINT fk_srar_arch_pk FOREIGN KEY (srar_arch_pk)
		REFERENCES tbl_archivo_arch (arch_pk)
)
\

CREATE OR REPLACE SYNONYM portico.tbl_servicio_archivo_srar FOR tbl_servicio_archivo_srar\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_servicio_archivo_srar TO portico\


ALTER TABLE tbl_proceso_item_prit ADD prit_tipo VARCHAR2(4)\

ALTER TABLE tbl_periodo_proceso_pepr ADD pepr_arch_pk NUMBER(19)\
ALTER TABLE tbl_periodo_proceso_pepr ADD CONSTRAINT fk_pepr_arch_pk FOREIGN KEY (pepr_arch_pk)
	REFERENCES tbl_archivo_arch (arch_pk)\

-- Acciones de entidad a nivel de GRID
CREATE TABLE tbl_entidad_accgrid_enag (
	enag_pk NUMBER(19) NOT NULL
	, enag_enti_pk NUMBER(19) NOT NULL
	, enag_path VARCHAR2(30) NOT NULL
	, enag_orden INT NOT NULL

	, CONSTRAINT pk_enag PRIMARY KEY (enag_pk)

	, CONSTRAINT uq_enag UNIQUE (enag_enti_pk, enag_path)

	, CONSTRAINT fk_enag_enti_pk FOREIGN KEY (enag_enti_pk)
		REFERENCES tbl_entidad_enti (enti_pk)
)
\

CREATE OR REPLACE SYNONYM portico.tbl_entidad_accgrid_enag FOR tbl_entidad_accgrid_enag\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_entidad_accgrid_enag TO portico\

INSERT INTO portico.tbl_entidad_accgrid_enag (enag_pk, enag_enti_pk, enag_path, enag_orden) VALUES (28000, 20118, 'amad-recalc-estado', 1)\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enag', 'es', 28000, 'Recalc. Estados')\

-- //@UNDO
-- SQL to undo the change goes here.

-- Acciones de entidad a nivel de GRID
DELETE FROM tbl_i18n_i18n WHERE i18n_ext_pk=28000 AND i18n_pref='enag'\

DROP TABLE tbl_entidad_accgrid_enag\

-- Guardar archivos en la BD
ALTER TABLE tbl_periodo_proceso_pepr DROP COLUMN pepr_arch_pk\

ALTER TABLE tbl_proceso_item_prit DROP COLUMN prit_tipo\

DROP TABLE tbl_servicio_archivo_srar\
DROP TABLE tbl_proceso_archivo_prar\
DROP TABLE tbl_archivo_arch\

CREATE TABLE tbl_proceso_archivo_prar
(
	prar_prbt_pk NUMBER(19) NOT NULL
	, prar_nombre VARCHAR2(50) NOT NULL
	, prar_sentido char(1) NOT NULL

	, CONSTRAINT pk_prar PRIMARY KEY (prar_prbt_pk, prar_sentido, prar_nombre)

	, CONSTRAINT fk_prar_prbt_pk FOREIGN KEY (prar_prbt_pk)
		REFERENCES tbl_proceso_batch_prbt (prbt_pk)
)
\

CREATE OR REPLACE SYNONYM portico.tbl_proceso_archivo_prar FOR tbl_proceso_archivo_prar\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_proceso_archivo_prar TO portico\

COMMENT ON TABLE tbl_proceso_archivo_prar IS 'Ficheros tratados (leidos-generados) en las Ejecuciones de Procesos Batch'\
COMMENT ON COLUMN tbl_proceso_archivo_prar.prar_prbt_pk IS 'Identificador de proceso al que pertenece el archivo'\
COMMENT ON COLUMN tbl_proceso_archivo_prar.prar_nombre IS 'Nombre del archivo'\
COMMENT ON COLUMN tbl_proceso_archivo_prar.prar_sentido IS 'Sentido de Archivo: E (Entrada), S (Salida)'\


-- Campos de agregacion de estadisticas
ALTER TABLE tbl_servicio_srvc
	DROP COLUMN srvc_pepr_pk\

DROP TABLE tbl_campo_agregacion_cmag\

-- Mensajes i18n
DROP TABLE tbl_message_i18n_m18n\
DROP TABLE tbl_message_mesg\


-- Configuracion
DROP TABLE tbl_configuration_conf\

-- Ruta a clase de negocio de la entidad
ALTER TABLE tbl_entidad_enti DROP COLUMN enti_classpath\

-- Columna de limite de filas visibles en un grid
ALTER TABLE tbl_entidad_enti DROP COLUMN enti_max_grid\
