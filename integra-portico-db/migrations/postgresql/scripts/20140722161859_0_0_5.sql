-- // 0 0 5.sql
-- Migration SQL that makes the change goes here.


-- Columna de limite de filas visibles en un grid
ALTER TABLE portico.tbl_entidad_enti ADD enti_max_grid INT DEFAULT 0 NOT NULL\

UPDATE portico.tbl_entidad_enti SET enti_max_grid = CASE
	WHEN enti_tipo = 'P' THEN 10000
	WHEN enti_tipo = 'B' THEN 100
	WHEN enti_tipo = 'T' THEN 10000
	WHEN enti_tipo = 'S' THEN 50000
	WHEN enti_tipo = 'E' THEN 10000
END\


-- Tabla Unica para i18n
CREATE TABLE portico.tbl_i18n_i18n (
	i18n_pref VARCHAR(4) NOT NULL
	, i18n_ext_pk BIGINT NOT NULL
	, i18n_lang VARCHAR(5) NOT NULL
	, i18n_text VARCHAR(255) NOT NULL

	, CONSTRAINT pk_i18n PRIMARY KEY (i18n_pref, i18n_ext_pk, i18n_lang)
)\

GRANT SELECT, INSERT, UPDATE, DELETE ON portico.tbl_i18n_i18n TO portico\

INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_ext_pk, i18n_lang, i18n_text)
SELECT 'prvr', p18n_prvr_pk, p18n_idioma, p18n_texto
FROM portico.tbl_parametro_i18n_p18n\

INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_ext_pk, i18n_lang, i18n_text)
SELECT 'cdrf', cdri_cdrf_pk, cdri_idioma, cdri_texto
FROM portico.tbl_codigo_ref_i18n_cdri\

UPDATE portico.tbl_i18n_i18n SET i18n_lang = 'es' WHERE i18n_lang = 'es_ES'\


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
	'language.default', 'String', 'es')\
INSERT INTO portico.tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'language.available', 'StringList', 'es, ca, en')\
INSERT INTO portico.tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'parametrizacion.app.mode', 'Boolean', 'true')\
INSERT INTO portico.tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'estadistica.files.home', 'String', '${files.home}/estadistica')\
INSERT INTO portico.tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'estadistica.files.oppe.home', 'String', '${estadistica.files.home}/oppe')\
INSERT INTO portico.tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'estadistica.files.oppe.procesado.home', 'String', '${estadistica.files.oppe.home}/procesado')\
INSERT INTO portico.tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'estadistica.files.oppe.erroneo.home', 'String', '${estadistica.files.oppe.home}/erroneo')\
INSERT INTO portico.tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'servicio.files.home', 'String', '${files.home}/servicio')\
INSERT INTO portico.tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'pesca.files.home', 'String', '${servicio.files.home}/pesca')\
INSERT INTO portico.tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'pesca.files.entrada.home', 'String', '${pesca.files.home}/entrada')\
INSERT INTO portico.tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'pesca.files.procesado.home', 'String', '${pesca.files.home}/procesado')\
INSERT INTO portico.tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'pesca.files.erroneo.home', 'String', '${pesca.files.home}/erroneo')\
INSERT INTO portico.tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'manifiesto.files.home', 'String', '${servicio.files.home}/manifiesto')\
INSERT INTO portico.tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'manifiesto.files.entrada.home', 'String', '${manifiesto.files.home}/entrada')\
INSERT INTO portico.tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'manifiesto.files.procesado.home', 'String', '${manifiesto.files.home}/procesado')\
INSERT INTO portico.tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'manifiesto.files.erroneo.home', 'String', '${manifiesto.files.home}/erroneo')\
INSERT INTO portico.tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'escala.files.home', 'String', '${servicio.files.home}/escala')\
INSERT INTO portico.tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'escala.files.entrada.home', 'String', '${escala.files.home}/entrada')\
INSERT INTO portico.tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'escala.files.procesado.home', 'String', '${escala.files.home}/procesado')\
INSERT INTO portico.tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'escala.files.erroneo.home', 'String', '${escala.files.home}/erroneo')\
INSERT INTO portico.tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'files.home', 'String', '/proyectos/deploy/files/portico')\
INSERT INTO portico.tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'filter.limit', 'Long', '5')\


-- Mensajes i18n
CREATE TABLE portico.tbl_message_bundle_msbl (
	msbl_key VARCHAR(100) NOT NULL
	, msbl_bundle VARCHAR(30) NOT NULL

	, CONSTRAINT pk_msbl PRIMARY KEY (msbl_key, msbl_bundle)
)\

GRANT SELECT, INSERT, UPDATE ON portico.tbl_message_bundle_msbl TO portico\

CREATE TABLE portico.tbl_message_i18n_m18n (
	m18n_key VARCHAR(100) NOT NULL
	, m18n_language VARCHAR(5) NOT NULL
	, m18n_value VARCHAR(250) NOT NULL

	, CONSTRAINT pk_m18n PRIMARY KEY (m18n_key, m18n_language)
)\

GRANT SELECT, INSERT, UPDATE ON portico.tbl_message_i18n_m18n TO portico\

INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'format_date', 'dd/MM/yyyy')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('format_date', 'web')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('format_date', 'app')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'format_datetime', 'dd/MM/yyyy HH:mm')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('format_datetime', 'web')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('format_datetime', 'app')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'format_true', 'Si')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('format_true', 'web')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('format_true', 'app')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'format_false', 'No')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('format_false', 'web')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('format_false', 'app')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'format_1', 'Si')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('format_1', 'web')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('format_1', 'app')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'format_0', 'No')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('format_0', 'web')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('format_0', 'app')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'btn_buscar', 'Buscar')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('btn_buscar', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'btn_volver', 'Volver')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('btn_volver', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'btn_aceptar', 'Aceptar')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('btn_aceptar', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'btn_cancelar', 'Cancelar')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('btn_cancelar', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'btn_crear', 'Nuevo')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('btn_crear', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'btn_editar', 'Editar')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('btn_editar', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'btn_guardar', 'Guardar')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('btn_guardar', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'btn_borrar', 'Borrar')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('btn_borrar', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'btn_duplicar', 'Duplicar')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('btn_duplicar', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'btn_filtrar', 'Filtro')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('btn_filtrar', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'btn_exportar', 'Exportar')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('btn_exportar', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'btn_imprimir', 'Imprimir')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('btn_imprimir', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'btn_recargar', 'Recargar')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('btn_recargar', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'btn_valorar', 'Valorar')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('btn_valorar', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enti', 'Entidad')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('enti', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'entiList', 'Entidades')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('entiList', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enti_codigo', 'Código')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('enti_codigo', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enti_tipo', 'Tipo')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('enti_tipo', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enti_nombre', 'Nombre')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('enti_nombre', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enti_cmdAlta', 'Alta?')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('enti_cmdAlta', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enti_cmdBaja', 'Baja?')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('enti_cmdBaja', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enti_cmdEdicion', 'Edición?')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('enti_cmdEdicion', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enti_cmdDuplicado', 'Duplicado?')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('enti_cmdDuplicado', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enti_maxGrid', 'Grid Máx (filas)')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('enti_maxGrid', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enti_engdList', 'Grupos de Datos')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('enti_engdList', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enti_entdList', 'Datos')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('enti_entdList', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enti_entdGridList', 'Datos del Grid')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('enti_entdGridList', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enti_entiPadresList', 'Entidades Padre')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('enti_entiPadresList', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enti_entiHijasList', 'Entidades Hija')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('enti_entiHijasList', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enti_enacList', 'Acciones')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('enti_enacList', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enac', 'Acción Asociada a Entidad')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('enac', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enacList', 'Acciónes Asociadas a Entidad')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('enacList', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enac_enti', 'Entidad')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('enac_enti', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enac_path', 'Ruta (URL)')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('enac_path', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enac_etiqueta', 'Etiqueta')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('enac_etiqueta', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enac_orden', 'Orden')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('enac_orden', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enen', 'Dependencia entre Entidades')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('enen', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enenList', 'Dependencias entre Entidades')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('enenList', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enen_entiPadre', 'Entidad Padre')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('enen_entiPadre', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enen_entiHija', 'Entidad Hija')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('enen_entiHija', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enen_orden', 'Orden')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('enen_orden', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'engd', 'Grupo de Datos')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('engd', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'engdList', 'Grupos de Datos')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('engdList', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'engd_enti', 'Entidad')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('engd_enti', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'engd_numero', 'Nº')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('engd_numero', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'engd_etiqueta', 'Etiqueta')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('engd_etiqueta', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'entd', 'Dato de Entidad')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('entd', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'entdList', 'Datos de Entidad')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('entdList', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'entd_enti', 'Entidad')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('entd_enti', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'entd_tpdt', 'Tipo de Dato')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('entd_tpdt', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'entd_grupo', 'Grupo')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('entd_grupo', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'entd_fila', 'Fila')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('entd_fila', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'entd_orden', 'Orden')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('entd_orden', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'entd_span', 'Span')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('entd_span', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'entd_obligatorio', 'Obligatorio')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('entd_obligatorio', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'entd_gridable', 'Grid?')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('entd_gridable', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'entd_filtrable', 'Filtrable?')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('entd_filtrable', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'entd_valorDefecto', 'V. Defecto')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('entd_valorDefecto', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'entd_etiqueta', 'Etiqueta')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('entd_etiqueta', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'EntidadTipo_P', 'Maestro')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('EntidadTipo_P', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'EntidadTipo_B', 'Maestro Dependiente')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('EntidadTipo_B', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'EntidadTipo_T', 'Tipo de Servicio')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('EntidadTipo_T', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'EntidadTipo_S', 'Tipo de Subservicio')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('EntidadTipo_S', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'EntidadTipo_E', 'Tipo de Estadística')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('EntidadTipo_E', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'tppr', 'Maestro')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('tppr', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'tpprList', 'Maestros')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('tpprList', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'tppr_i18n', 'I18n?')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('tppr_i18n', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'tppr_tempExp', 'Temporal?')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('tppr_tempExp', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'tppr_tpdtNombre', 'T. Dato Nombre')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('tppr_tpdtNombre', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'tpsp', 'Maestro Dependiente')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('tpsp', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'tpspList', 'Maestros Dependiente')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('tpspList', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'tpsp_tppr', 'Maestro')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('tpsp_tppr', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'tpsp_tpprAsociado', 'Maestro Asociado')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('tpsp_tpprAsociado', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'tpsp_i18n', 'I18n?')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('tpsp_i18n', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'tpsp_tempExp', 'Temporal?')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('tpsp_tempExp', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'tpsr', 'Tipo de Servicio')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('tpsr', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'tpsrList', 'Tipos de Servicio')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('tpsrList', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'tpsr_temporal', 'Temporal?')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('tpsr_temporal', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'tpsr_facturable', 'Facturable?')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('tpsr_facturable', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'tpsr_tpdtEstado', 'T. Dato Estado')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('tpsr_tpdtEstado', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'tpss', 'Tipo de Subservicio')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('tpss', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'tpssList', 'Tipos de Subservicio')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('tpssList', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'tpss_tpsr', 'Tipo de Servicio')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('tpss_tpsr', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'tpss_temporal', 'Temporal?')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('tpss_temporal', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'tpss_facturable', 'Facturable?')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('tpss_facturable', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'tpss_tpdtEstado', 'T. Dato Estado')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('tpss_tpdtEstado', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'tpdt', 'Tipo de Dato')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('tpdt', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'tpdtList', 'Tipos de Dato')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('tpdtList', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'tpdt_codigo', 'Código')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('tpdt_codigo', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'tpdt_nombre', 'Nombre')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('tpdt_nombre', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'tpdt_tpht', 'Tipo HTML')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('tpdt_tpht', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'tpdt_enti', 'Entidad')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('tpdt_enti', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'tpdt_tpel', 'Tipo de Elemento')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('tpdt_tpel', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'tpdt_cdrfList', 'Códigos de Referencia')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('tpdt_cdrfList', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'HtmlTipo_T', 'Textfield')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('HtmlTipo_T', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'HtmlTipo_S', 'Select')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('HtmlTipo_S', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'HtmlTipo_CB', 'Checkbox')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('HtmlTipo_CB', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'HtmlTipo_D', 'Date')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('HtmlTipo_D', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'HtmlTipo_DT', 'Datetime')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('HtmlTipo_DT', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'HtmlTipo_F', 'Filtro')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('HtmlTipo_F', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'HtmlTipo_TA', 'Textarea')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('HtmlTipo_TA', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ElementoTipo_ND', 'Nº Decimal')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('ElementoTipo_ND', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ElementoTipo_NE', 'Nº Entero')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('ElementoTipo_NE', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ElementoTipo_TX', 'Texto')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('ElementoTipo_TX', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ElementoTipo_FE', 'Fecha')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('ElementoTipo_FE', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ElementoTipo_FH', 'Fecha/Hora')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('ElementoTipo_FH', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ElementoTipo_PR', 'Maestro')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('ElementoTipo_PR', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ElementoTipo_BO', 'Booleano')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('ElementoTipo_BO', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ElementoTipo_CR', 'Cód. Referencia')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('ElementoTipo_CR', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ElementoTipo_SR', 'Servicio')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('ElementoTipo_SR', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'cdrf', 'Código de Referencia')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('cdrf', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'cdrfList', 'Códigos de Referencia')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('cdrfList', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'cdrf_tpdt', 'T. Dato')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('cdrf_tpdt', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'cdrf_valor', 'Valor')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('cdrf_valor', 'web')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'cdrf_orden', 'Orden')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('cdrf_orden', 'web')\

INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'i18n_text', 'Texto')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('i18n_text', 'web')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('i18n_text', 'app')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'prmt_parametro', 'Código')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('prmt_parametro', 'web')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('prmt_parametro', 'app')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'prmt_fini', 'F. Inicio')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('prmt_fini', 'web')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('prmt_fini', 'app')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'prmt_ffin', 'F. Fin')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('prmt_ffin', 'web')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('prmt_ffin', 'app')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'srvc_tpsr', 'T. Servicio')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('srvc_tpsr', 'web')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('srvc_tpsr', 'app')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'srvc_subp', 'Subpuerto')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('srvc_subp', 'web')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('srvc_subp', 'app')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'srvc_anno', 'Año')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('srvc_anno', 'web')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('srvc_anno', 'app')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'srvc_numero', 'Nº')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('srvc_numero', 'web')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('srvc_numero', 'app')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'srvc_fini', 'F. Inicio')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('srvc_fini', 'web')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('srvc_fini', 'app')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'srvc_ffin', 'F. Fin')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('srvc_ffin', 'web')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('srvc_ffin', 'app')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'srvc_falta', 'F. Alta')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('srvc_falta', 'web')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('srvc_falta', 'app')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'srvc_fref', 'F. Referencia')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('srvc_fref', 'web')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('srvc_fref', 'app')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'srvc_estado', 'Estado')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('srvc_estado', 'web')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('srvc_estado', 'app')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ssrv_tpss', 'T. Subservicio')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('ssrv_tpss', 'web')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('ssrv_tpss', 'app')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ssrv_srvc', 'Servicio')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('ssrv_srvc', 'web')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('ssrv_srvc', 'app')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ssrv_estado', 'Estado')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('ssrv_estado', 'web')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('ssrv_estado', 'app')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ssrv_numero', 'Nº')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('ssrv_numero', 'web')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('ssrv_numero', 'app')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ssrv_fini', 'F. Inicio')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('ssrv_fini', 'web')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('ssrv_fini', 'app')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ssrv_ffin', 'F. Fin')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('ssrv_ffin', 'web')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('ssrv_ffin', 'app')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'estd_tpes', 'Informe')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('estd_tpes', 'web')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('estd_tpes', 'app')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'estd_pepr', 'P. Proceso.')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('estd_pepr', 'web')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('estd_pepr', 'app')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'estd_subp', 'Subpuerto')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('estd_subp', 'web')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('estd_subp', 'app')\

INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'E00000', 'E00000 - Error no controlado: {0}')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('E00000', 'app')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'E00001', 'E00001 - Campo Obligatorio: {0}')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('E00001', 'app')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'E00002', 'E00002 - Campo Obligatorio: Descripción para el idioma {0}')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('E00002', 'app')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'E00003', 'E00003 - Campo Obligatorio: F. Inicio')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('E00003', 'app')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'E00004', 'E00004 - Campo Obligatorio: Código')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('E00004', 'app')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'E00005', 'E00005 - {0} duplicado/a')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('E00005', 'app')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'E00006', 'E00006 - Error de período de Vigencia. F. Fin ha de ser posterior a F.Fin')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('E00006', 'app')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'E00007', 'E00007 - Parámetro con Identificador {0} no encontrado')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('E00007', 'app')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'E00008', 'E00008 - {0} con identificador {1} no encontrado/a')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('E00008', 'app')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'E00009', 'E00009 - Otro elemento se solapa con el período de vigencia')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('E00009', 'app')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'E00010', 'E00010 - Servicio en estado {0} inválido para ejecutar la acción')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('E00010', 'app')\
INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'E00011', 'E00011 - Subservicio en estado {0} inválido para ejecutar la acción')\
	INSERT INTO portico.tbl_message_bundle_msbl (msbl_key, msbl_bundle) VALUES ('E00011', 'app')\


-- Borrado de laas tablas de configuracion y configuracion de idioma
DROP TABLE portico.tbl_conf_valor_i18n_cnvi\
DROP TABLE portico.tbl_configuracion_valor_cnvl\
DROP TABLE portico.tbl_configuracion_entorno_cnen\
DROP TABLE portico.tbl_configuracion_idioma_cnid\
DROP TABLE portico.tbl_conf_clave_i18n_cnci\
DROP TABLE portico.tbl_conf_clave_cncl\


-- Borrado de las tablas de i18n de parametro y codigo de referencia
DROP TABLE portico.tbl_parametro_i18n_p18n\
DROP TABLE portico.tbl_codigo_ref_i18n_cdri\


















-- //@UNDO
-- SQL to undo the change goes here.

-- Borrado de las tablas de i18n de parametro y codigo de referencia
CREATE TABLE portico.tbl_parametro_i18n_p18n (
	p18n_prvr_pk BIGINT NOT NULL
	, p18n_idioma VARCHAR(5) NOT NULL
	, p18n_texto VARCHAR(350) NOT NULL

	, CONSTRAINT pk_p18n PRIMARY KEY (p18n_prvr_pk, p18n_idioma)

	, CONSTRAINT fk_p18n_prvr_pk FOREIGN KEY (p18n_prvr_pk)
		REFERENCES portico.tbl_parametro_version_prvr (prvr_pk)
)\

GRANT SELECT, INSERT, UPDATE, DELETE ON portico.tbl_parametro_i18n_p18n TO portico\

COMMENT ON TABLE portico.tbl_parametro_i18n_p18n IS 'Textos internacionalizados Asociados a las Versiones de Parametros de la aplicacion (Textos i18n de Maestros)'\
COMMENT ON COLUMN portico.tbl_parametro_i18n_p18n.p18n_prvr_pk IS 'Identificador de Version de Parametro'\
COMMENT ON COLUMN portico.tbl_parametro_i18n_p18n.p18n_idioma IS 'Idioma del texto'\
COMMENT ON COLUMN portico.tbl_parametro_i18n_p18n.p18n_texto IS 'Texto'\

CREATE TABLE portico.tbl_codigo_ref_i18n_cdri (
	cdri_cdrf_pk BIGINT NOT NULL
	, cdri_idioma VARCHAR(5) NOT NULL
	, cdri_texto VARCHAR(100) NOT NULL

	, CONSTRAINT pk_cdri PRIMARY KEY (cdri_cdrf_pk, cdri_idioma)

	, CONSTRAINT fk_cdri_cdrf_pk FOREIGN KEY (cdri_cdrf_pk)
		REFERENCES portico.tbl_codigo_ref_cdrf (cdrf_pk)
)\

GRANT SELECT, INSERT, UPDATE, DELETE ON portico.tbl_codigo_ref_i18n_cdri TO portico\

INSERT INTO portico.tbl_parametro_i18n_p18n (p18n_prvr_pk, p18n_idioma, p18n_texto)
SELECT i18n_ext_pk, i18n_lang, i18n_text
FROM portico.tbl_i18n_i18n
WHERE i18n_pref = 'prvr'\

INSERT INTO portico.tbl_codigo_ref_i18n_cdri (cdri_cdrf_pk, cdri_idioma, cdri_texto)
SELECT i18n_ext_pk, i18n_lang, i18n_text
FROM portico.tbl_i18n_i18n
WHERE i18n_pref = 'cdrf'\


-- Borrado de laas tablas de configuracion y configuracion de idioma
CREATE TABLE portico.tbl_conf_clave_cncl (
	cncl_pk BIGINT NOT NULL
	, cncl_clave VARCHAR(80) NOT NULL
	, cncl_tipo_valor VARCHAR(2) NOT NULL
	, cncl_valor_defecto VARCHAR(200) NOT NULL

	, CONSTRAINT pk_cncl PRIMARY KEY (cncl_pk)
	, CONSTRAINT uq_cncl UNIQUE (cncl_clave)
)\

GRANT SELECT, INSERT, UPDATE, DELETE ON portico.tbl_conf_clave_cncl TO portico\

COMMENT ON TABLE portico.tbl_conf_clave_cncl IS 'Claves de Parametros de Configuracion'\
COMMENT ON COLUMN portico.tbl_conf_clave_cncl.cncl_pk IS 'Identificador de clave'\
COMMENT ON COLUMN portico.tbl_conf_clave_cncl.cncl_tipo_valor IS 'Tipo de Valor del parametro (Fecha, numero, ...)'\
COMMENT ON COLUMN portico.tbl_conf_clave_cncl.cncl_clave IS 'Clave del parametro'\
COMMENT ON COLUMN portico.tbl_conf_clave_cncl.cncl_valor_defecto IS 'Valor por defecto del parametro'\

CREATE TABLE portico.tbl_conf_clave_i18n_cnci (
	cnci_pk BIGINT NOT NULL
	, cnci_clave VARCHAR(80) NOT NULL
	, cnci_valor_defecto VARCHAR(200) NOT NULL

	, CONSTRAINT pk_cnci PRIMARY KEY (cnci_pk)
	, CONSTRAINT uq_cnci UNIQUE (cnci_clave)
)\

GRANT SELECT, INSERT, UPDATE, DELETE ON portico.tbl_conf_clave_i18n_cnci TO portico\

COMMENT ON TABLE portico.tbl_conf_clave_i18n_cnci IS 'Claves de Configuracion de idioma'\
COMMENT ON COLUMN portico.tbl_conf_clave_i18n_cnci.cnci_pk IS 'Identificador de clave de idioma'\
COMMENT ON COLUMN portico.tbl_conf_clave_i18n_cnci.cnci_clave IS 'Identificador de clave'\
COMMENT ON COLUMN portico.tbl_conf_clave_i18n_cnci.cnci_valor_defecto IS 'Valor por Defecto'\

CREATE TABLE portico.tbl_configuracion_idioma_cnid (
	cnid_pk BIGINT NOT NULL
	, cnid_codigo VARCHAR(5) NOT NULL
	, cnid_descripcion VARCHAR(100)

	, CONSTRAINT pk_cnid PRIMARY KEY (cnid_pk)
	, CONSTRAINT uq_cnid UNIQUE (cnid_codigo)
)\

GRANT SELECT, INSERT, UPDATE, DELETE ON portico.tbl_configuracion_idioma_cnid TO portico\

COMMENT ON TABLE portico.tbl_configuracion_idioma_cnid IS 'Configuraciones de idioma'\
COMMENT ON COLUMN portico.tbl_configuracion_idioma_cnid.cnid_pk IS 'Identificador de configuracion de idioma'\
COMMENT ON COLUMN portico.tbl_configuracion_idioma_cnid.cnid_codigo IS 'Codigo de configuracion de idioma'\
COMMENT ON COLUMN portico.tbl_configuracion_idioma_cnid.cnid_descripcion IS 'Descripcion de configuracion de idioma'\

CREATE TABLE portico.tbl_configuracion_entorno_cnen (
	cnen_pk BIGINT NOT NULL
	, cnen_codigo VARCHAR(8) NOT NULL
	, cnen_nombre VARCHAR(50) NOT NULL

	, CONSTRAINT pk_cnen PRIMARY KEY (cnen_pk)
	, CONSTRAINT uq_cnen UNIQUE (cnen_codigo)
)\

GRANT SELECT, INSERT, UPDATE, DELETE ON portico.tbl_configuracion_entorno_cnen TO portico\

COMMENT ON TABLE portico.tbl_configuracion_entorno_cnen IS 'Entornos de Configuracion'\
COMMENT ON COLUMN portico.tbl_configuracion_entorno_cnen.cnen_pk IS 'Identificador de entorno'\
COMMENT ON COLUMN portico.tbl_configuracion_entorno_cnen.cnen_codigo IS 'Codigo de entorno'\
COMMENT ON COLUMN portico.tbl_configuracion_entorno_cnen.cnen_nombre IS 'Nombre de entorno'\

CREATE TABLE portico.tbl_configuracion_valor_cnvl (
	cnvl_cnen_pk BIGINT NOT NULL
	, cnvl_cncl_pk BIGINT NOT NULL
	, cnvl_valor VARCHAR(200) NOT NULL

	, CONSTRAINT pk_cnvl PRIMARY KEY (cnvl_cnen_pk, cnvl_cncl_pk)

	, CONSTRAINT fk_cnvl_cnen_pk FOREIGN KEY (cnvl_cnen_pk)
		REFERENCES portico.tbl_configuracion_entorno_cnen (cnen_pk)
	, CONSTRAINT fk_cnvl_cncl_pk FOREIGN KEY (cnvl_cncl_pk)
		REFERENCES portico.tbl_conf_clave_cncl (cncl_pk)
)\

GRANT SELECT, INSERT, UPDATE, DELETE ON portico.tbl_configuracion_valor_cnvl TO portico\

COMMENT ON TABLE portico.tbl_configuracion_valor_cnvl IS 'Valores de parametros de configuracion'\
COMMENT ON COLUMN portico.tbl_configuracion_valor_cnvl.cnvl_cnen_pk IS 'Identificador de entorno'\
COMMENT ON COLUMN portico.tbl_configuracion_valor_cnvl.cnvl_cncl_pk IS 'Identificador de clave'\
COMMENT ON COLUMN portico.tbl_configuracion_valor_cnvl.cnvl_valor IS 'Valor de parametro'\

CREATE TABLE portico.tbl_conf_valor_i18n_cnvi (
	cnvi_cnid_pk BIGINT NOT NULL
	, cnvi_cnci_pk BIGINT NOT NULL
	, cnvi_valor VARCHAR(200) NOT NULL

	, CONSTRAINT pk_cnvi PRIMARY KEY (cnvi_cnid_pk, cnvi_cnci_pk)

	, CONSTRAINT fk_cnvi_cnid_pk FOREIGN KEY (cnvi_cnid_pk)
		REFERENCES portico.tbl_configuracion_idioma_cnid (cnid_pk)
	, CONSTRAINT fk_cnvi_cnci_pk FOREIGN KEY (cnvi_cnci_pk)
		REFERENCES portico.tbl_conf_clave_i18n_cnci (cnci_pk)
)\

GRANT SELECT, INSERT, UPDATE, DELETE ON portico.tbl_conf_valor_i18n_cnvi TO portico\

COMMENT ON TABLE portico.tbl_conf_valor_i18n_cnvi IS 'Valores de parametros de configuracion de idioma'\
COMMENT ON COLUMN portico.tbl_conf_valor_i18n_cnvi.cnvi_cnid_pk IS 'Identificador de Configuracion de Idioma'\
COMMENT ON COLUMN portico.tbl_conf_valor_i18n_cnvi.cnvi_cnci_pk IS 'Identificador de Parametro de Configuracion de Idioma'\
COMMENT ON COLUMN portico.tbl_conf_valor_i18n_cnvi.cnvi_valor IS 'Valor de Parametro'\

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
DROP TABLE portico.tbl_message_bundle_msbl\
DROP TABLE portico.tbl_message_i18n_m18n\


-- Configuracion
DROP TABLE portico.tbl_configuration_conf\


-- Tabla Unica para i18n
DROP TABLE portico.tbl_i18n_i18n\


-- Columna de limite de filas visibles en un grid
ALTER TABLE portico.tbl_entidad_enti DROP COLUMN enti_max_grid\
