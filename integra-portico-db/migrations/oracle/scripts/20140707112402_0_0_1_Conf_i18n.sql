-- // 0 0 5.sql
-- Migration SQL that makes the change goes here.


-- AP y Puertos
INSERT INTO tbl_superpuerto_sprt (sprt_pk, sprt_codigo) VALUES (36100, '0')\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_ext_pk, i18n_lang, i18n_text) VALUES ('sprt', 36100, 'es', 'Autp Genérica')\
INSERT INTO tbl_superpuerto_sprt (sprt_pk, sprt_codigo) VALUES (36101, '*')\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_ext_pk, i18n_lang, i18n_text) VALUES ('sprt', 36101, 'es', 'Autp Genérica 2')\

INSERT INTO tbl_superpuerto_sprt (sprt_pk, sprt_codigo) VALUES (36000, '80')\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_ext_pk, i18n_lang, i18n_text) VALUES ('sprt', 36000, 'es', 'Baleares')\

-- Usuarios
INSERT INTO tbl_usuario_usro (usro_pk, usro_login, usro_contrasenia, usro_nombre, usro_sprt_pk, usro_prto_pk) VALUES (
	1000, 'admin', 'admin', 'Administrador', NULL, NULL)\


INSERT INTO tbl_puerto_prto (prto_pk, prto_sprt_pk, prto_codigo, prto_codigo_corto, prto_codigo_edi, prto_rec_aduanero, prto_unlocode)
VALUES (37100, 36100, '0', '0', NULL, NULL, 'ES***')\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_ext_pk, i18n_lang, i18n_text) VALUES ('prto', 37100, 'es', 'Puerto Genérico')\
INSERT INTO tbl_puerto_prto (prto_pk, prto_sprt_pk, prto_codigo, prto_codigo_corto, prto_codigo_edi, prto_rec_aduanero, prto_unlocode)
VALUES (37101, 36101, '*', '*', NULL, NULL, 'ES***')\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_ext_pk, i18n_lang, i18n_text) VALUES ('prto', 37101, 'es', 'Puerto Genérico 2')\

INSERT INTO tbl_puerto_prto (prto_pk, prto_sprt_pk, prto_codigo, prto_codigo_corto, prto_codigo_edi, prto_rec_aduanero, prto_unlocode)
VALUES (37000, 36000, '81', 'P', '1', '0711', 'ESPMI')\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_ext_pk, i18n_lang, i18n_text) VALUES ('prto', 37000, 'es', 'Palma')\
INSERT INTO tbl_puerto_prto (prto_pk, prto_sprt_pk, prto_codigo, prto_codigo_corto, prto_codigo_edi, prto_rec_aduanero, prto_unlocode)
VALUES (37001, 36000, '82', 'A', '2', '0717', 'ESALD')\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_ext_pk, i18n_lang, i18n_text) VALUES ('prto', 37001, 'es', 'Alcudia')\
INSERT INTO tbl_puerto_prto (prto_pk, prto_sprt_pk, prto_codigo, prto_codigo_corto, prto_codigo_edi, prto_rec_aduanero, prto_unlocode)
VALUES (37002, 36000, '83', 'I', '3', '0721', 'ESIBZ')\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_ext_pk, i18n_lang, i18n_text) VALUES ('prto', 37002, 'es', 'Ibiza')\
INSERT INTO tbl_puerto_prto (prto_pk, prto_sprt_pk, prto_codigo, prto_codigo_corto, prto_codigo_edi, prto_rec_aduanero, prto_unlocode)
VALUES (37003, 36000, '84', 'F', '4', '0725', 'ESFNI')\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_ext_pk, i18n_lang, i18n_text) VALUES ('prto', 37003, 'es', 'Formentera')\
INSERT INTO tbl_puerto_prto (prto_pk, prto_sprt_pk, prto_codigo, prto_codigo_corto, prto_codigo_edi, prto_rec_aduanero, prto_unlocode)
VALUES (37004, 36000, '85', 'M', '5', NULL, 'ESMAH')\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_ext_pk, i18n_lang, i18n_text) VALUES ('prto', 37004, 'es', 'La Savina')\


-- Configuracion
INSERT INTO portico.tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'language_default', 'String', 'es')\
INSERT INTO portico.tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'language_available', 'StringList', 'es, ca, en')\
INSERT INTO portico.tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'date_format', 'String', 'dd/MM/yyyy')\
INSERT INTO portico.tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'datetime_format', 'String', 'dd/MM/yyyy HH:mm')\
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
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'btn_acceso')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'btn_acceso', 'Acceso')\
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

INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fini')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fini', 'F. Inicio')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'ffin')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ffin', 'F. Fin')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fref')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fref', 'F. Referencia')\

INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'usro')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'usro', 'Usuario')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'usroList')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'usroList', 'Usuarios')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'usro_login')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'usro_login', 'Login')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'usro_contrasenia')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'usro_contrasenia', 'Contraseña')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'usro_nombre')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'usro_nombre', 'Nombre')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'grpo')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'grpo', 'Grupo')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'grpoList')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'grpoList', 'Grupos')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'grpo_nombre')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'grpo_nombre', 'Nombre')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'accn')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'accn', 'Acción')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'accnList')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'accnList', 'Acciones')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'accn_codigo')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'accn_codigo', 'Código')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'accn_nombre')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'accn_nombre', 'Nombre')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'grac')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'grac', 'Acción de Grupo')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'usgr')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'usgr', 'Grupo de Usuarios')\

INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'sprt')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'sprt', 'A. Portuaria')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'sprtList')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'sprtList', 'A. Portuarias')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'sprt_codigo')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'sprt_codigo', 'Código')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'sprt_nombre')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'sprt_nombre', 'Nombre')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'prto')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'prto', 'Puerto')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'prtoList')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'prtoList', 'Puertos')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'prto_codigo')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'prto_codigo', 'Código')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'prto_nombre')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'prto_nombre', 'Nombre')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'prto_codigoCorto')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'prto_codigoCorto', 'Cód. Corto')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'prto_codigoEdi')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'prto_codigoEdi', 'Cód. EDI')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'prto_recAduanero')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'prto_recAduanero', 'R. Aduanero')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'prto_unlocode')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'prto_unlocode', 'UNlocode')\

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
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'enti_entiPadresList')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enti_entiPadresList', 'Entidades Padre')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'enti_entiHijasList')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enti_entiHijasList', 'Entidades Hija')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'enti_i18n')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enti_i18n', 'I18n?')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'enti_tempExp')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enti_tempExp', 'Temporal?')\
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
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'enti_estado_def')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enti_estado_def', 'Estado Def.')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'enti_estados_vlrc')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enti_estados_vlrc', 'Estados Fact.')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'enti_tpdtNombre')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enti_tpdtNombre', 'T. Dato Nombre')\
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
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'cmag_nombre')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'cmag_nombre', 'Nombre')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'cmag_agregar')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'cmag_agregar', 'Agregar?')\

INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'trmt')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'trmt', 'Trámite')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'trmtList')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'trmtList', 'Trámites')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'trmt_estado_orig')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'trmt_estado_orig', 'Estado Or.')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'trmt_estado_dest')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'trmt_estado_dest', 'Estado Dt.')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'trmt_etiqueta')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'trmt_etiqueta', 'Texto')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'trtdList')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'trtdList', 'Datos del Trámite')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'trtd_obligatorio')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'trtd_obligatorio', 'Obligatorio?')\

INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'enac')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enac', 'Acción Asociada a Entidad')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'enacList')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enacList', 'Acciones Asociadas a Entidad')\
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
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'engd_numero')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'engd_numero', 'Nº')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'engd_etiqueta')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'engd_etiqueta', 'Etiqueta')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'entd')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'entd', 'Dato de Entidad')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'entdList')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'entdList', 'Datos de Entidad')\
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
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'tpdt_tpel')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'tpdt_tpel', 'Tipo de Elemento')\
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
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'cdrf_valor')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'cdrf_valor', 'Valor')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'cdrf_orden')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'cdrf_orden', 'Orden')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'cdrf_texto')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'cdrf_texto', 'Texto')\

INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'page_acceso')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'page_acceso', 'Acceso')\
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
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'prmt_lat')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'prmt_lat', 'Latitud')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'prmt_lon')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'prmt_lon', 'Longitud')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'sprm')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'sprm', 'Maestro Dependiente')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'srsc')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'srsc', 'Secuencia de Servicio')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'srscList')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'srscList', 'Secuencias de Servicio')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'srsc_anno')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'srsc_anno', 'Año')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'srsc_ultimo_numero')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'srsc_ultimo_numero', 'Último Nº')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'srvc')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'srvc', 'Servicio')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'srvcList')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'srvcList', 'Servicios')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'srvc_anno')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'srvc_anno', 'Año')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'srvc_numero')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'srvc_numero', 'Nº')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'srvc_falta')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'srvc_falta', 'F. Alta')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'srvc_estado')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'srvc_estado', 'Estado')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'ssrv')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ssrv', 'Subservicio')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'ssrv_estado')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ssrv_estado', 'Estado')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'ssrv_numero')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ssrv_numero', 'Nº')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'pepr')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'pepr', 'Período de proceso')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'peprList')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'peprList', 'Períodos de proceso')\
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
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'crgo')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'crgo', 'Cargo')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'crgoList')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'crgoList', 'Cargos')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'crgo_codigo')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'crgo_codigo', 'Código')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'crgo_descripcion')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'crgo_descripcion', 'Descripción')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'crgo_codigoNormalizado')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'crgo_codigoNormalizado', 'Cód. Normalizado')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'crgo_tipo')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'crgo_tipo', 'Tipo')\
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
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'rgla_tipo')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'rgla_tipo', 'Tipo')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'rgla_orden')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'rgla_orden', 'Orden')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'rgla_condicion')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'rgla_condicion', 'Condición')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'rgla_formula')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'rgla_formula', 'Fórmula')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'rgla_valorBase')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'rgla_valorBase', 'Valor Base')\
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
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'rgin_rgla2')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'rgin_rgla2', 'Regla Incompatible')\

INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrc')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrc', 'Valoración')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrcList')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrcList', 'Valoraciones')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrc_id')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrc_id', 'ID')\
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
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrc_sujPasivo')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrc_sujPasivo', 'Suj. Pasivo?')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrc_codExencion')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrc_codExencion', 'Cód. Exención')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrgList')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrgList', 'Cargos')\
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
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrl_importeBase')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrl_importeBase', 'Imp. Base')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrl_importe')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrl_importe', 'Importe')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrl_impuesto')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrl_impuesto', 'Impuesto')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrl_vlrdCount')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrl_vlrdCount', 'Nº Detalles')\
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
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'FacturaEstado_NO')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'FacturaEstado_NO', 'Normal')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'FacturaEstado_AN')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'FacturaEstado_AN', 'Anulada')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'FacturaEstado_RP')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'FacturaEstado_RP', 'Rec. Positiva')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'FacturaEstado_RN')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'FacturaEstado_RN', 'Rec. Negativa')\
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
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fctr_estado')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fctr_estado', 'Estado')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fctr_sujPasivo')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fctr_sujPasivo', 'Suj. Pasivo?')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fctr_info1')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fctr_info1', 'Info. 1')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fctr_info2')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fctr_info2', 'Info. 2')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fctr_info3')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fctr_info3', 'Info. 3')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fctr_info4')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fctr_info4', 'Info. 4')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fctr_info5')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fctr_info5', 'Info. 5')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fctr_info6')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fctr_info6', 'Info. 6')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fctr_importe')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fctr_importe', 'Importe')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fctr_impuesto')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fctr_impuesto', 'Impuesto')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fctr_pagador')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fctr_pagador', 'Pagador')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fctr_falta')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fctr_falta', 'F. Alta')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fctsList')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fctsList', 'Servicios')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fcts_codExencion')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fcts_codExencion', 'Cód. Exención')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fctgList')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fctgList', 'Cargos')\
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
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fctl_importeBase')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fctl_importeBase', 'Imp. Base')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fctl_importe')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fctl_importe', 'Importe')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fctl_fctdCount')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fctl_fctdCount', 'Nº Detalles')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fctl_impuesto')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fctl_impuesto', 'Impuesto')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fctl_info1')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fctl_info1', 'Info. 1')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fctl_info2')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fctl_info2', 'Info. 2')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fctl_info3')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fctl_info3', 'Info. 3')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fctl_info4')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fctl_info4', 'Info. 4')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fctl_info5')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fctl_info5', 'Info. 5')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fctl_info6')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fctl_info6', 'Info. 6')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fctl_cuant1')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fctl_cuant1', 'Cuant. 1')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fctl_cuant2')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fctl_cuant2', 'Cuant. 2')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fctl_cuant3')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fctl_cuant3', 'Cuant. 3')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fctl_cuant4')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fctl_cuant4', 'Cuant. 4')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fctl_cuant5')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fctl_cuant5', 'Cuant. 5')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fctl_cuant6')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fctl_cuant6', 'Cuant. 6')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fctd')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fctd', 'Detalle de Factura')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fctdList')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fctdList', 'Detalles de Factura')\
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
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (1, 'E00014')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'E00014', 'E00014 - Contraseña Incorrecta')\
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

INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (1, 'mani_resumen')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'mani_resumen', 'Resumen Manifiesto')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (1, 'mabl_resumen')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'mabl_resumen', 'Resumen BL')\

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

INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (1, 'atra_cambiarMuelle')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'atra_cambiarMuelle', 'Cambiar Muelle Atraque')\
INSERT INTO portico.tbl_message_mesg (mesg_internal, mesg_key) VALUES (1, 'atra_autorizarFPrevio')\
	INSERT INTO portico.tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'atra_autorizarFPrevio', 'Autorizar Fondeo Previo Atraque')\







-- //@UNDO
-- SQL to undo the change goes here.

-- Mensajes i18n
DELETE FROM tbl_message_i18n_m18n\
DELETE FROM tbl_message_mesg\

-- Configuracion
DELETE FROM tbl_configuration_conf\

-- Usuarios
DELETE FROM tbl_usuario_usro\

-- AP y Puertos
DELETE FROM tbl_i18n_i18n WHERE i18n_pref = 'prto'\
DELETE FROM tbl_i18n_i18n WHERE i18n_pref = 'sprt'\
DELETE FROM tbl_puerto_prto\
DELETE FROM tbl_superpuerto_sprt\