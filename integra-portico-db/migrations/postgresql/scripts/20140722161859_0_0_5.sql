-- // 0 0 5.sql
-- Migration SQL that makes the change goes here.


-- Columna de limite de filas visibles en un grid
ALTER TABLE portico.tbl_entidad_enti ADD enti_max_grid INT NOT NULL DEFAULT 0\

UPDATE portico.tbl_entidad_enti SET enti_max_grid = CASE
	WHEN enti_tipo = 'P' THEN 10000
	WHEN enti_tipo = 'B' THEN 100
	WHEN enti_tipo = 'T' THEN 10000
	WHEN enti_tipo = 'S' THEN 50000
	WHEN enti_tipo = 'E' THEN 10000
END\

-- Ruta a clase de negocio de la entidad
ALTER TABLE portico.tbl_entidad_enti ADD enti_classpath VARCHAR(50)\




-- Configuracion
CREATE TABLE portico.tbl_configuration_conf (
	conf_key VARCHAR(250) NOT NULL
	, conf_value_type VARCHAR(20) NOT NULL
	, conf_default_value VARCHAR(250) NOT NULL
	, conf_value VARCHAR(250)

	, CONSTRAINT pk_conf PRIMARY KEY (conf_key)
)\

GRANT SELECT, UPDATE ON portico.tbl_configuration_conf TO portico\

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
	'webapp_install_path', 'String', '/home/xeredi/git/portico/integra-portico-web/src/main/webapp')\
INSERT INTO portico.tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'db_migration_dataSource_driver', 'String', 'oracle.jdbc.OracleDriver')\
INSERT INTO portico.tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'db_migration_dataSource_url', 'String', 'jdbc:oracle:thin:@localhost:1521:orcl')\
INSERT INTO portico.tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'db_migration_dataSource_username', 'String', 'integra')\
INSERT INTO portico.tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'db_migration_dataSource_password', 'String', 'integra')\


-- Mensajes i18n
CREATE TABLE portico.tbl_message_i18n_m18n (
	m18n_key VARCHAR(100) NOT NULL
	, m18n_language VARCHAR(5) NOT NULL
	, m18n_internal INT NOT NULL
	, m18n_value VARCHAR(250) NOT NULL

	, CONSTRAINT pk_m18n PRIMARY KEY (m18n_key, m18n_language)
)\

GRANT SELECT, INSERT, UPDATE ON portico.tbl_message_i18n_m18n TO portico\



INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'app_nombre', 'Pórtico')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'menu', 'Menú')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'errorList', 'Errores')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'filtro', 'Filtro')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('en', 0, 'filtro', 'Filter')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'filtro_limit', 'Máx. Resultados')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'grid_count', '{{count}} Resultado(s)')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'format_date', 'dd/MM/yyyy')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'format_datetime', 'dd/MM/yyyy HH:mm')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'format_true', 'Si')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'format_false', 'No')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'format_1', 'Si')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'format_0', 'No')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'btn_buscar', 'Buscar')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'btn_volver', 'Volver')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'btn_aceptar', 'Aceptar')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'btn_cancelar', 'Cancelar')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'btn_crear', 'Nuevo')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'btn_editar', 'Editar')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'btn_guardar', 'Guardar')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'btn_borrar', 'Borrar')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'btn_duplicar', 'Duplicar')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'btn_filtrar', 'Filtro')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'btn_exportar', 'Exportar')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'btn_imprimir', 'Imprimir')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'btn_recargar', 'Recargar')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'btn_valorar', 'Valorar')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'btn_cargar', 'Cargar')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'btn_start', 'Iniciar')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'btn_pause', 'Pausar')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'btn_shutdown', 'Apagado Inmediato')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'btn_shutdownClean', 'Apagado')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'sec_facturacion', 'Facturación')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'sec_administracion', 'Administración')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'sec_metamodelo', 'Metamodelo')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'sec_configuracion', 'Configuración')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'sec_job', 'Procesos Batch')\

INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'enti', 'Entidad')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'entiList', 'Entidades')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'enti_codigo', 'Código')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'enti_tipo', 'Tipo')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'enti_nombre', 'Nombre')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'enti_cmdAlta', 'Alta?')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'enti_cmdBaja', 'Baja?')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'enti_cmdEdicion', 'Edición?')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'enti_cmdDuplicado', 'Duplicado?')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'enti_maxGrid', 'Grid Máx (filas)')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'enti_engdList', 'Grupos de Datos')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'enti_entdList', 'Datos')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'enti_entdGridList', 'Datos del Grid')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'enti_entiPadresList', 'Entidades Padre')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'enti_entiHijasList', 'Entidades Hija')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'enti_enacList', 'Acciones')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'enti_i18n', 'I18n?')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'enti_tempExp', 'Temporal?')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'enti_tpdt', 'T. Dato')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'enti_tppr', 'Maestro')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'enti_tpprAsociado', 'Maestro Asociado')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'enti_temporal', 'Temporal?')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'enti_facturable', 'Facturable?')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'enti_exencionable', 'Exencionable?')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'enti_tpdtEstado', 'T. Dato Estado')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'enti_tpdtNombre', 'T. Dato Nombre')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'enti_tpsr', 'Tipo de Servicio')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'enti_classpath', 'Classpath')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'tppr', 'Maestro')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'tpprList', 'Maestros')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'tpsp', 'Maestro Dependiente')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'tpspList', 'Maestros Dependiente')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'tpsr', 'Tipo de Servicio')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'tpsrList', 'Tipos de Servicio')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'tpss', 'Tipo de Subservicio')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'tpssList', 'Tipos de Subservicio')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'tpes', 'Tipo de Estadística')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'tpesList', 'Tipos de Estadística')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'cmag', 'Campo de Agregacion')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'cmagList', 'Campos de Agregacion')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'cmag_entd', 'Dato')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'cmag_nombre', 'Nombre')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'cmag_agregar', 'Agregar?')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'enac', 'Acción Asociada a Entidad')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'enacList', 'Acciónes Asociadas a Entidad')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'enac_enti', 'Entidad')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'enac_path', 'Ruta (URL)')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'enac_etiqueta', 'Etiqueta')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'enac_orden', 'Orden')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'enen', 'Dependencia entre Entidades')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'enenList', 'Dependencias entre Entidades')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'enen_entiPadre', 'Entidad Padre')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'enen_entiHija', 'Entidad Hija')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'enen_orden', 'Orden')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'engd', 'Grupo de Datos')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'engdList', 'Grupos de Datos')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'engd_enti', 'Entidad')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'engd_numero', 'Nº')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'engd_etiqueta', 'Etiqueta')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'entd', 'Dato de Entidad')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'entdList', 'Datos de Entidad')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'entd_enti', 'Entidad')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'entd_tpdt', 'Tipo de Dato')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'entd_grupo', 'Grupo')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'entd_fila', 'Fila')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'entd_orden', 'Orden')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'entd_span', 'Span')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'entd_spanLg', 'Span (Lg)')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'entd_obligatorio', 'Obligatorio')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'entd_gridable', 'Grid?')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'entd_filtrable', 'Filtrable?')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'entd_valorDefecto', 'V. Defecto')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'entd_etiqueta', 'Etiqueta')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'EntidadTipo_P', 'Maestro')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'EntidadTipo_B', 'Maestro Dependiente')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'EntidadTipo_T', 'Tipo de Servicio')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'EntidadTipo_S', 'Tipo de Subservicio')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'EntidadTipo_E', 'Tipo de Estadística')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'tpdt', 'Tipo de Dato')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'tpdtList', 'Tipos de Dato')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'tpdt_codigo', 'Código')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'tpdt_nombre', 'Nombre')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'tpdt_tpht', 'Tipo HTML')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'tpdt_enti', 'Entidad')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'tpdt_tpel', 'Tipo de Elemento')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'tpdt_cdrfList', 'Códigos de Referencia')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'HtmlTipo_T', 'T - Textfield')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'HtmlTipo_S', 'S - Select')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'HtmlTipo_CB', 'CB - Checkbox')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'HtmlTipo_D', 'D - Date')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'HtmlTipo_DT', 'DT - Datetime')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'HtmlTipo_F', 'F - Filtro')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'HtmlTipo_TA', 'TA - Textarea')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'ElementoTipo_ND', 'ND - Nº Decimal')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'ElementoTipo_NE', 'NE - Nº Entero')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'ElementoTipo_TX', 'TX - Texto')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'ElementoTipo_FE', 'FE - Fecha')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'ElementoTipo_FH', 'FH - Fecha/Hora')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'ElementoTipo_PR', 'PR - Maestro')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'ElementoTipo_BO', 'BO - Booleano')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'ElementoTipo_CR', 'CR - Cód. Referencia')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'ElementoTipo_SR', 'SR - Servicio')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'cdrf', 'Código de Referencia')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'cdrfList', 'Códigos de Referencia')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'cdrf_tpdt', 'T. Dato')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'cdrf_valor', 'Valor')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'cdrf_orden', 'Orden')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'cdrf_texto', 'Texto')\

INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'page_home', 'Inicio')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'page_grid', 'Listado')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'page_detail', 'Detalle')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'page_create', 'Nuevo')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'page_duplicate', 'Duplicado')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'page_edit', 'Edición')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'i18n_text', 'Nombre')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'i18n_text_lang', 'Nombre {{lang}}')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'prmt', 'Maestro')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'prmtList', 'Maestro')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'prmt_parametro', 'Código')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'prmt_fini', 'F. Inicio')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'prmt_ffin', 'F. Fin')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'prmt_fvigencia', 'F. Vigencia')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'sprm', 'Maestro Dependiente')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'sprm_fini', 'F. Inicio')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'sprm_ffin', 'F. Fin')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'srvc', 'Servicio')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'srvcList', 'Servicios')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'srvc_tpsr', 'T. Servicio')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'srvc_subp', 'Subpuerto')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'srvc_anno', 'Año')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'srvc_numero', 'Nº')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'srvc_fini', 'F. Inicio')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'srvc_ffin', 'F. Fin')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'srvc_falta', 'F. Alta')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'srvc_fref', 'F. Referencia')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'srvc_estado', 'Estado')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'ssrv', 'Subservicio')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'ssrv_tpss', 'T. Subservicio')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'ssrv_srvc', 'Servicio')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'ssrv_estado', 'Estado')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'ssrv_numero', 'Nº')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'ssrv_fini', 'F. Inicio')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'ssrv_ffin', 'F. Fin')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'pepr', 'Período de Proceso')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'peprList', 'Períodos de Proceso')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'pepr_autp', 'Aut. Portuaria')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'pepr_anio', 'Aut. Año')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'pepr_mes', 'Mes')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'pepr_file', 'Archivo')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'pepr_sobreescribir', 'Sobreescribir?')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'cdms', 'Cuadro Mensual')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'estd', 'Estadistica')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'estdList', 'Estadisticas')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'estd_tpes', 'Informe')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'estd_pepr', 'P. Proceso.')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'estd_subp', 'Subpuerto')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'prbt', 'Proceso')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'prbtList', 'Procesos')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'prbt_modulo', 'Módulo')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'prbt_tipo', 'Tipo')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'prbt_estado', 'Estado')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'prbt_falta', 'F. Alta')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'prbt_fini', 'F. Inicio')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'prbt_ffin', 'F. Fin')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'prbt_duracion', 'Duración (mseg.)')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'prbt_erroresCnt', 'Nº Errores')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'prbt_alertasCnt', 'Nº Alertas')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'prbt_mensajesCnt', 'Nº Mensajes')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'prmnList', 'Mensajes')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'prmn_nivel', 'Nivel')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'prmn_codigo', 'Código')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'prmn_mensaje', 'Mensaje')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'prpmList', 'Parámetros')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'prpm_nombre', 'Nombre')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'prpm_valor', 'Valor')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'prarList', 'Ficheros')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'prarEntList', 'Ficheros Ent.')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'prarSalList', 'Ficheros Sal.')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'prar_nombre', 'Nombre')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'pritList', 'Elementos')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'pritEntList', 'Elementos Ent.')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'pritSalList', 'Elementos Sal.')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'prit_nombre', 'Nombre')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'prit_tipo', 'Tipo')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'prit_enti', 'Entidad')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'ItemTipo_srvc', 'Servicio')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'ItemTipo_ssrv', 'Subservicio')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'ItemTipo_vlrc', 'Valoración')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'ItemTipo_fctr', 'Factura')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'ItemTipo_pepr', 'Período de Proceso')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'arch', 'Archivo')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'archList', 'Archivos')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'arch_nombre', 'Nombre')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'arch_falta', 'F. Alta')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'arch_tamanio', 'Tamaño (bytes)')\

INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'aspc', 'Aspecto')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'aspcList', 'Aspectos')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'aspc_cList', 'Elementos de Cabecera')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'aspc_lcList', 'Elementos Cuantitativos de Línea')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'aspc_liList', 'Elementos Informativos de Línea')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'aspc_ascrList', 'Cargos Asociados al Aspecto')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'aspc_codigo', 'Código')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'aspc_descripcion', 'Descripción')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'aspc_tpsr', 'T. Servicio')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'aspc_fini', 'F. Inicio')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'aspc_ffin', 'F. Fin')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'aspc_prioridad', 'Prioridad')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'aspc_cetiqInfo', 'Etiq. Elem. Informativo Cabecera')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'aspc_cetiqInfo1', 'Etiq. Elem. Informativo Cabecera 1')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'aspc_cetiqInfo2', 'Etiq. Elem. Informativo Cabecera 2')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'aspc_cetiqInfo3', 'Etiq. Elem. Informativo Cabecera 3')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'aspc_cetiqInfo4', 'Etiq. Elem. Informativo Cabecera 4')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'aspc_cetiqInfo5', 'Etiq. Elem. Informativo Cabecera 5')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'aspc_cetiqInfo6', 'Etiq. Elem. Informativo Cabecera 6')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'aspc_cpathInfo', 'Ruta Elem. Informativo Cabecera')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'aspc_cpathInfo1', 'Ruta Elem. Informativo Cabecera 1')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'aspc_cpathInfo2', 'Ruta Elem. Informativo Cabecera 2')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'aspc_cpathInfo3', 'Ruta Elem. Informativo Cabecera 3')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'aspc_cpathInfo4', 'Ruta Elem. Informativo Cabecera 4')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'aspc_cpathInfo5', 'Ruta Elem. Informativo Cabecera 5')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'aspc_cpathInfo6', 'Ruta Elem. Informativo Cabecera 6')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'aspc_cgrpInfo', 'Agrupar Elem. Informativo Cabecera?')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'aspc_cgrpInfo1', 'Agrupar Elem. Informativo Cabecera 1?')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'aspc_cgrpInfo2', 'Agrupar Elem. Informativo Cabecera 2?')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'aspc_cgrpInfo3', 'Agrupar Elem. Informativo Cabecera 3?')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'aspc_cgrpInfo4', 'Agrupar Elem. Informativo Cabecera 4?')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'aspc_cgrpInfo5', 'Agrupar Elem. Informativo Cabecera 5?')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'aspc_cgrpInfo6', 'Agrupar Elem. Informativo Cabecera 6?')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'aspc_lsumCuant', 'Sumarizar Elem. Cuantitativo Línea?')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'aspc_lsumCuant1', 'Sumarizar Elem. Cuantitativo Línea 1?')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'aspc_lsumCuant2', 'Sumarizar Elem. Cuantitativo Línea 2?')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'aspc_lsumCuant3', 'Sumarizar Elem. Cuantitativo Línea 3?')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'aspc_lsumCuant4', 'Sumarizar Elem. Cuantitativo Línea 4?')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'aspc_lsumCuant5', 'Sumarizar Elem. Cuantitativo Línea 5?')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'aspc_lsumCuant6', 'Sumarizar Elem. Cuantitativo Línea 6?')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'aspc_lgrpInfo', 'Agrupar Elem. Informativo Línea?')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'aspc_lgrpInfo1', 'Agrupar Elem. Informativo Línea 1?')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'aspc_lgrpInfo2', 'Agrupar Elem. Informativo Línea 2?')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'aspc_lgrpInfo3', 'Agrupar Elem. Informativo Línea 3?')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'aspc_lgrpInfo4', 'Agrupar Elem. Informativo Línea 4?')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'aspc_lgrpInfo5', 'Agrupar Elem. Informativo Línea 5?')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'aspc_lgrpInfo6', 'Agrupar Elem. Informativo Línea 6?')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'aspc_fechaVigencia', 'F. Vigencia')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'ascr', 'Cargo de Aspecto')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'ascr_crgo', 'Cargo')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'ascr_fini', 'F. Inicio')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'ascr_ffin', 'F. Fin')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'crgo', 'Cargo')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'crgoList', 'Cargos')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'crgo_codigo', 'Código')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'crgo_descripcion', 'Descripción')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'crgo_fini', 'F. Inicio')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'crgo_ffin', 'F. Fin')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'crgo_codigoNormalizado', 'Cód. Normalizado')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'crgo_tipo', 'Tipo')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'crgo_tpsr', 'T. Servicio')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'crgo_principal', 'Principal?')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'crgo_temporal', 'Temporal?')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'crgo_fechaVigencia', 'F. Vigencia')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'rgla', 'Regla')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'rglaList', 'Reglas')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'rgla_codigo', 'Código')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'rgla_crgo', 'Cargo')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'rgla_tipo', 'Tipo')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'rgla_enti', 'Entidad')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'rgla_fini', 'F. Inicio')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'rgla_ffin', 'F. Fin')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'rgla_orden', 'Orden')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'rgla_condicion', 'Condición')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'rgla_formula', 'Fórmula')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'rgla_importeBase', 'Importe Base')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'rgla_pathImpuesto', 'Ruta Impuesto')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'rgla_pathPagador', 'Ruta Pagador')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'rgla_pathEsSujPasivo', 'Ruta Es Sujeto Pasivo')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'rgla_pathCodExen', 'Ruta Cód. Exención')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'rgla_etiqInfo', 'Etiq. Elem. Informativo')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'rgla_etiqInfo1', 'Etiq. Elem. Informativo 1')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'rgla_etiqInfo2', 'Etiq. Elem. Informativo 2')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'rgla_etiqInfo3', 'Etiq. Elem. Informativo 3')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'rgla_etiqInfo4', 'Etiq. Elem. Informativo 4')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'rgla_etiqInfo5', 'Etiq. Elem. Informativo 5')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'rgla_etiqInfo6', 'Etiq. Elem. Informativo 6')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'rgla_pathInfo', 'Ruta Elem. Informativo')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'rgla_pathInfo1', 'Ruta Elem. Informativo 1')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'rgla_pathInfo2', 'Ruta Elem. Informativo 2')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'rgla_pathInfo3', 'Ruta Elem. Informativo 3')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'rgla_pathInfo4', 'Ruta Elem. Informativo 4')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'rgla_pathInfo5', 'Ruta Elem. Informativo 5')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'rgla_pathInfo6', 'Ruta Elem. Informativo 6')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'rgla_etiqCuant', ' Etiq. Elem. Cuantitativo')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'rgla_etiqCuant1', ' Etiq. Elem. Cuantitativo 1')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'rgla_etiqCuant2', ' Etiq. Elem. Cuantitativo 2')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'rgla_etiqCuant3', ' Etiq. Elem. Cuantitativo 3')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'rgla_etiqCuant4', ' Etiq. Elem. Cuantitativo 4')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'rgla_etiqCuant5', ' Etiq. Elem. Cuantitativo 5')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'rgla_etiqCuant6', ' Etiq. Elem. Cuantitativo 6')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'rgla_pathCuant', 'Ruta Elem. Cuantitativo')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'rgla_pathCuant1', 'Ruta Elem. Cuantitativo 1')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'rgla_pathCuant2', 'Ruta Elem. Cuantitativo 2')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'rgla_pathCuant3', 'Ruta Elem. Cuantitativo 3')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'rgla_pathCuant4', 'Ruta Elem. Cuantitativo 4')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'rgla_pathCuant5', 'Ruta Elem. Cuantitativo 5')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'rgla_pathCuant6', 'Ruta Elem. Cuantitativo 6')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'rgin', 'Incompatibilidad entre Reglas')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'rginList', 'Incompatibilidades entre Reglas')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'rgin_fini', 'F. Inicio')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'rgin_ffin', 'F. Fin')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'rgin_rgla2', 'Regla Incompatible')\

INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'vlrc', 'Valoración')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'vlrcList', 'Valoraciones')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'vlrc_id', 'ID')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'vlrc_srvc', 'Servicio')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'vlrc_aspc', 'Aspecto')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'vlrc_pagador', 'Pagador')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'vlrc_importe', 'Importe')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'vlrc_impuesto', 'Impuesto')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'vlrc_fliq', 'F. Liquidación')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'vlrc_fini', 'F. Inicio')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'vlrc_ffin', 'F. Fin')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'vlrc_sujPasivo', 'Suj. Pasivo?')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'vlrc_codExencion', 'Cód. Exención')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'vlrl', 'Linea de Valoración')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'vlrd', 'Detalle de Valoración')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'fctr', 'Factura')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'fctrList', 'Facturas')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'conf', 'Parámetro de Configuración')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'confList', 'Parámetros de Configuración')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'conf_key', 'Parámetro')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'conf_valueType', 'Tipo')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'conf_value', 'Valor')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'conf_defaultValue', 'Valor Defecto')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'm18nList', 'Mensajes i18n')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'm18n', 'Mensaje i18n')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'm18n_key', 'Clave')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'schr', 'Planificador de Procesos')\

INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 1, 'E00000', 'E00000 - Error no controlado: {0}')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 1, 'E00001', 'E00001 - Campo Obligatorio: {0}')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 1, 'E00002', 'E00002 - Campo Obligatorio: Descripción para el idioma {0}')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 1, 'E00005', 'E00005 - {0} duplicado/a')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 1, 'E00006', 'E00006 - Error de período de Vigencia. Fecha Fin ha de ser posterior a Fecha Inicio')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 1, 'E00008', 'E00008 - {0} con identificador {1} no encontrado/a')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 1, 'E00009', 'E00009 - {0} solapado/a con el período de vigencia')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 1, 'E00011', 'E00011 - Subservicio en estado {0} inválido para ejecutar la acción')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 1, 'E00012', 'E00012 - {0} solo admite los valores {1}')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 1, 'E00013', 'E00013 - Operación no Permitida: {0}')\

INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'cdms_numero', 'Nº')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'cdms_tm', 'Tm')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'cdms_teus', 'TEUS')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'cdms_ca', 'Con Carga')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'cdms_va', 'Vacíos')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'cdms_embarcado', 'Embarcado')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'cdms_desembarcado', 'Desembarcado')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'cdms_transito', 'Tránsito')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'cdms_transbordo', 'Transbordo')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'cdms_GL', 'GRANELES LIQUIDOS')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'cdms_GLPETR', 'CRUDOS DE PETROLEO')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'cdms_GLGASN', 'GAS NATURAL')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'cdms_GLPREF', 'PRODUCTOS PETROLIFEROS REFINADOS')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'cdms_GLOTRO', 'OTROS GRANELES LIQUIDOS')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'cdms_GS', 'GRANELES SOLIDOS')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'cdms_GSIESP', 'POR INSTALACION ESPECIAL')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'cdms_GSNIES', 'SIN INSTALACION ESPECIAL')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'cdms_MG', 'MERCANCIA GENERAL')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'cdms_PASAJE', 'Nº PASAJEROS (EXCLUIDO T. BAHIA)')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'cdms_PASCRU', 'Nº PASAJEROS DE CRUCERO')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'cdms_VET2', 'Nº VEHICULOS (Turismos en rég. pasaje, Automóviles y Autobuses)')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'cdms_CTEUS', 'TEUS (con carga y vacíos)')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'cdms_RR', 'TRAFICO RO-RO')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'cdms_RRC', 'EN CONTENEDORES')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'cdms_RRO', 'EN OTROS MEDIOS')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'cdms_AV', 'AVITUALLAMIENTO')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'cdms_AVPPET', 'PROD. PETROLIFEROS')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'cdms_AVOTRO', 'OTROS')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'cdms_TRALOC', 'TRAFICO LOCAL')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'cdms_PESCAF', 'PESCA FRESCA')\

INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'MensajeNivel_I', 'I - Información')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'MensajeNivel_W', 'W - Alerta')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'MensajeNivel_E', 'E - Error')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'ProcesoEstado_C', 'C - En Cola')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'ProcesoEstado_E', 'E - En Ejecución')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'ProcesoEstado_F', 'F - Finalizado')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'ProcesoModulo_S', 'S - Servicios')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'ProcesoModulo_E', 'E - Estadísticas')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'CargoTipo_T', 'T - Tarifa')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'CargoTipo_B', 'B - Tasa')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'ReglaTipo_T', 'T - Precio')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'ReglaTipo_C', 'C - Coeficiente')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'ReglaTipo_D', 'D - Bonificación')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'ConfigurationValueType_String', 'Texto')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'ConfigurationValueType_Boolean', 'Lógico')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'ConfigurationValueType_Double', 'Nº Decimal')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'ConfigurationValueType_Long', 'Nº Entero')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'ConfigurationValueType_Date', 'Fecha')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'ConfigurationValueType_DateTime', 'Fecha/Hora')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 0, 'ConfigurationValueType_StringList', 'Lista de Textos')\

INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 1, 'mani_completar', 'Completar Manifiesto')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 1, 'mani_bloquear', 'Bloquear Manifiesto')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 1, 'mani_iniciar', 'Iniciar Manifiesto')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 1, 'mani_anular', 'Anular Manifiesto')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 1, 'mani_resumen', 'Resumen Manifiesto')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 1, 'mabl_completar', 'Completar BL')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 1, 'mabl_bloquear', 'Bloquear BL')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 1, 'mabl_iniciar', 'Iniciar BL')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 1, 'mabl_anular', 'Anular BL')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 1, 'mabl_resumen', 'Resumen BL')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 1, 'part_bloquear', 'Bloquear Partida')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 1, 'part_iniciar', 'Iniciar Partida')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 1, 'part_anular', 'Anular Partida')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 1, 'equi_bloquear', 'Bloquear Equipamiento')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 1, 'equi_iniciar', 'Iniciar Equipamiento')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 1, 'equi_anular', 'Anular Equipamiento')\

INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 1, 'atra_denegar', 'Denegar Atraque')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 1, 'atra_autorizar', 'Autorizar Atraque')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 1, 'atra_anular', 'Anular Atraque')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 1, 'atra_iniciar', 'Iniciar Atraque')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 1, 'atra_finalizar', 'Finalizar Atraque')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 1, 'atra_cambiarMuelle', 'Cambiar Muelle Atraque')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_internal, m18n_key, m18n_value) VALUES ('es', 1, 'atra_autorizarFPrevio', 'Autorizar Fondeo Previo Atraque')\




-- Campos de Agregacion de estadisticas
CREATE TABLE portico.tbl_campo_agregacion_cmag (
	cmag_tpes_pk BIGINT NOT NULL
	, cmag_entd_pk BIGINT NOT NULL
	, cmag_agregar INT NOT NULL
	, cmag_nombre VARCHAR(250)

	, CONSTRAINT pk_cmag PRIMARY KEY (cmag_tpes_pk, cmag_entd_pk)

	, CONSTRAINT fk_cmag_tpes_pk FOREIGN KEY (cmag_tpes_pk)
		REFERENCES portico.tbl_tipo_estadistica_tpes (tpes_pk)
	, CONSTRAINT fk_cmag_entd_pk FOREIGN KEY (cmag_entd_pk)
		REFERENCES portico.tbl_entidad_tipo_dato_entd (entd_pk)
)\

GRANT SELECT, UPDATE ON portico.tbl_campo_agregacion_cmag TO portico\

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


ALTER TABLE portico.tbl_servicio_srvc
	ADD COLUMN srvc_pepr_pk BIGINT\


-- Guardar archivos en la BD
CREATE TABLE portico.tbl_archivo_arch (
	arch_pk BIGINT NOT NULL
	, arch_sentido CHAR(1) NOT NULL
	, arch_nombre VARCHAR(100) NOT NULL
	, arch_tamanio INT NOT NULL
	, arch_falta TIMESTAMP NOT NULL
	, arch_archivo BYTEA NOT NULL

	, CONSTRAINT pk_arch PRIMARY KEY (arch_pk)
)
\

GRANT SELECT, INSERT, UPDATE, DELETE ON portico.tbl_archivo_arch TO portico\

DROP TABLE portico.tbl_proceso_archivo_prar\

CREATE TABLE portico.tbl_proceso_archivo_prar (
	prar_prbt_pk BIGINT NOT NULL
	, prar_arch_pk BIGINT NOT NULL

	, CONSTRAINT pk_prar PRIMARY KEY (prar_prbt_pk, prar_arch_pk)

	, CONSTRAINT fk_prar_prbt_pk FOREIGN KEY (prar_prbt_pk)
		REFERENCES portico.tbl_proceso_batch_prbt (prbt_pk)
	, CONSTRAINT fk_prar_arch_pk FOREIGN KEY (prar_arch_pk)
		REFERENCES portico.tbl_archivo_arch (arch_pk)
)
\

GRANT SELECT, INSERT, UPDATE, DELETE ON portico.tbl_proceso_archivo_prar TO portico\

CREATE TABLE portico.tbl_servicio_archivo_srar (
	srar_srvc_pk BIGINT NOT NULL
	, srar_arch_pk BIGINT NOT NULL

	, CONSTRAINT pk_srar PRIMARY KEY (srar_srvc_pk, srar_arch_pk)

	, CONSTRAINT fk_srar_srvc_pk FOREIGN KEY (srar_srvc_pk)
		REFERENCES portico.tbl_servicio_srvc (srvc_pk)
	, CONSTRAINT fk_srar_arch_pk FOREIGN KEY (srar_arch_pk)
		REFERENCES portico.tbl_archivo_arch (arch_pk)
)
\

GRANT SELECT, INSERT, UPDATE, DELETE ON portico.tbl_servicio_archivo_srar TO portico\


ALTER TABLE portico.tbl_proceso_item_prit ADD COLUMN prit_tipo VARCHAR(4)\


-- //@UNDO
-- SQL to undo the change goes here.


-- Guardar archivos en la BD
ALTER TABLE portico.tbl_proceso_item_prit DROP COLUMN prit_tipo\

DROP TABLE portico.tbl_servicio_archivo_srar\
DROP TABLE portico.tbl_proceso_archivo_prar\
DROP TABLE portico.tbl_archivo_arch\

CREATE TABLE portico.tbl_proceso_archivo_prar
(
	prar_prbt_pk BIGINT NOT NULL
	, prar_nombre VARCHAR(50) NOT NULL
	, prar_sentido char(1) NOT NULL

	, CONSTRAINT pk_prar PRIMARY KEY (prar_prbt_pk, prar_sentido, prar_nombre)

	, CONSTRAINT fk_prar_prbt_pk FOREIGN KEY (prar_prbt_pk)
		REFERENCES portico.tbl_proceso_batch_prbt (prbt_pk)
)
\

GRANT SELECT, INSERT, UPDATE, DELETE ON portico.tbl_proceso_archivo_prar TO portico\

COMMENT ON TABLE portico.tbl_proceso_archivo_prar IS 'Ficheros tratados (leidos-generados) en las Ejecuciones de Procesos Batch'\
COMMENT ON COLUMN portico.tbl_proceso_archivo_prar.prar_prbt_pk IS 'Identificador de proceso al que pertenece el archivo'\
COMMENT ON COLUMN portico.tbl_proceso_archivo_prar.prar_nombre IS 'Nombre del archivo'\
COMMENT ON COLUMN portico.tbl_proceso_archivo_prar.prar_sentido IS 'Sentido de Archivo: E (Entrada), S (Salida)'\


-- Campos de agregacion de estadisticas
ALTER TABLE portico.tbl_servicio_srvc
	DROP COLUMN srvc_pepr_pk\

DROP TABLE portico.tbl_campo_agregacion_cmag\

-- Mensajes i18n
DROP TABLE portico.tbl_message_i18n_m18n\


-- Configuracion
DROP TABLE portico.tbl_configuration_conf\

-- Ruta a clase de negocio de la entidad
ALTER TABLE portico.tbl_entidad_enti DROP COLUMN enti_classpath\

-- Columna de limite de filas visibles en un grid
ALTER TABLE portico.tbl_entidad_enti DROP COLUMN enti_max_grid\
