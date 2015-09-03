-- // 20150526160000_0_0_9_DominioPublico.sql
-- Migration SQL that makes the change goes here.

-- DOMINIO PUBLICO
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado
	, enti_max_grid, enti_gis, enti_puerto, enti_codigo) VALUES (20122, 'P', 1, 1, 1, 1, 10000, 0, 0, 'TIPO_ACTIVIDAD_DP')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20122, 'Tipo de Actividad D. P.')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp) VALUES (20122, 1, 0)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado
	, enti_max_grid, enti_gis, enti_puerto, enti_codigo) VALUES (20123, 'P', 1, 1, 1, 1, 10000, 0, 0, 'TIPO_SUPERFICIE_DP')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20123, 'Tipo de Superficie D. P.')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp) VALUES (20123, 1, 0)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado
	, enti_max_grid, enti_gis, enti_puerto, enti_codigo) VALUES (20124, 'P', 1, 1, 1, 1, 10000, 1, 1, 'BIEN_DP')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20124, 'Bien D. P.')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp) VALUES (20124, 1, 0)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado
	, enti_max_grid, enti_gis, enti_puerto, enti_codigo) VALUES (20125, 'P', 1, 1, 1, 1, 10000, 0, 1, 'EXPEDIENTE_DP')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20125, 'Expediente D. P.')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp) VALUES (20125, 0, 0)\
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado
	, enti_max_grid, enti_gis, enti_puerto, enti_codigo) VALUES (20126, 'P', 1, 1, 1, 1, 10000, 0, 0, 'TIPO_EXPEDIENTE_DP')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20126, 'Tipo Expediente D. P.')\
	INSERT INTO portico.tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp) VALUES (20126, 1, 0)\

INSERT INTO portico.tbl_entidad_grupo_dato_engd (engd_pk, engd_enti_pk, engd_orden) VALUES (28084, 20122, 1)\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('engd', 'es', 28084, 'General')\
INSERT INTO portico.tbl_entidad_grupo_dato_engd (engd_pk, engd_enti_pk, engd_orden) VALUES (28085, 20123, 1)\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('engd', 'es', 28085, 'General')\
INSERT INTO portico.tbl_entidad_grupo_dato_engd (engd_pk, engd_enti_pk, engd_orden) VALUES (28086, 20124, 1)\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('engd', 'es', 28086, 'General')\
INSERT INTO portico.tbl_entidad_grupo_dato_engd (engd_pk, engd_enti_pk, engd_orden) VALUES (28087, 20125, 1)\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('engd', 'es', 28087, 'General')\
INSERT INTO portico.tbl_entidad_grupo_dato_engd (engd_pk, engd_enti_pk, engd_orden) VALUES (28088, 20126, 1)\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('engd', 'es', 28088, 'General')\

INSERT INTO portico.tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45480, 'S', 'PR', 20126, 'TIPO_EXPEDIENTE_DP')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45480, 'Tipo de Expediente D.P.')\

-- tpsp
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado
	, enti_codigo) VALUES (24021, 'B', 1, 1, 1, 1, 'SUPERFICIE_BIEN_DP')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 24021, 'Superficie de Bien')\
INSERT INTO portico.tbl_tipo_subparametro_tpsp(tpsp_pk, tpsp_tppr_pk, tpsp_tppr_dep_pk, tpsp_es_i18n, tpsp_es_tmp_exp) VALUES (24021, 20124, 20123, 0, 1)\
	INSERT INTO portico.tbl_entidad_entidad_enen (enen_entip_pk, enen_entih_pk, enen_orden) VALUES (20124, 24021, 1)\

INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado
	, enti_codigo) VALUES (24022, 'B', 1, 1, 1, 1, 'BIEN_EXPEDIENTE_DP')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 24022, 'Bien de Expediente')\
INSERT INTO portico.tbl_tipo_subparametro_tpsp(tpsp_pk, tpsp_tppr_pk, tpsp_tppr_dep_pk, tpsp_es_i18n, tpsp_es_tmp_exp) VALUES (24022, 20125, 20124, 0, 1)\
	INSERT INTO portico.tbl_entidad_entidad_enen (enen_entip_pk, enen_entih_pk, enen_orden) VALUES (20125, 24022, 1)\

INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado
	, enti_codigo) VALUES (24023, 'B', 1, 1, 1, 1, 'DATOEXP_EXPEDIENTE_DP')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 24023, 'Dato de Explotacion de Expediente')\
INSERT INTO portico.tbl_tipo_subparametro_tpsp(tpsp_pk, tpsp_tppr_pk, tpsp_tppr_dep_pk, tpsp_es_i18n, tpsp_es_tmp_exp) VALUES (24023, 20125, 20122, 0, 1)\
	INSERT INTO portico.tbl_entidad_entidad_enen (enen_entip_pk, enen_entih_pk, enen_orden) VALUES (20125, 24023, 2)\

INSERT INTO portico.tbl_entidad_grupo_dato_engd (engd_pk, engd_enti_pk, engd_orden) VALUES (28500, 24021, 1)\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('engd', 'es', 28500, 'General')\
INSERT INTO portico.tbl_entidad_grupo_dato_engd (engd_pk, engd_enti_pk, engd_orden) VALUES (28501, 24022, 1)\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('engd', 'es', 28501, 'General')\
INSERT INTO portico.tbl_entidad_grupo_dato_engd (engd_pk, engd_enti_pk, engd_orden) VALUES (28502, 24023, 1)\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('engd', 'es', 28502, 'General')\

-- TIPO_ACTIVIDAD_DP
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (30020, 20122, 41040, 1, 1, 1, 2, 1, 1, 0, NULL)\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 30020, '% Gravamen')\

-- TIPO_SUPERFICIE_DP
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (30030, 20123, 41040, 1, 1, 1, 2, 1, 1, 0, NULL)\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 30030, '% Gravamen')\

-- BIEN_DP
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (30040, 20124, 41040, 1, 1, 1, 2, 1, 1, 0, NULL)\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 30040, 'Valor (euros)')\
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (30041, 20124, 41060, 1, 1, 2, 2, 1, 1, 0, NULL)\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 30041, 'Plazo Amort. (años)')\

-- EXPEDIENTE_DP
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (30050, 20125, 45480, 1, 1, 1, 3, 1, 1, 1, NULL)\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 30050, 'T. Expediente')\
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (30051, 20125, 45035, 1, 1, 2, 3, 1, 1, 1, NULL)\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 30051, 'Cliente')\
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (30052, 20125, 41060, 1, 1, 3, 2, 1, 1, 1, NULL)\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 30052, 'Periodicidad (meses)')\

-- SUPERFICIE_BIEN_DP
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (32000, 24021, 41040, 1, 1, 1, 2, 1, 1, 0, NULL)\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 32000, 'Superficie')\
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (32001, 24021, 41041, 1, 1, 2, 2, 1, 1, 0, NULL)\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 32001, 'Valor (euros)')\

-- DATOEXP_EXPEDIENTE_DP
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (32050, 24023, 41040, 1, 1, 1, 2, 1, 1, 0, NULL)\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 32050, 'Importe')\


-- SERVICIO DE BUQUE DE PESCA
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado
	, enti_max_grid, enti_gis, enti_puerto, enti_codigo) VALUES (21020, 'T', 1, 1, 1, 1, 10000, 0, 0, 'BUQUE_PESCA_SRV')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 21020, 'Servicio de Buque de Pesca')\
	INSERT INTO portico.tbl_tipo_servicio_tpsr(tpsr_pk, tpsr_es_temporal, tpsr_es_facturable, tpsr_es_exencionable, tpsr_tpdt_estado_pk) VALUES (21020, 1, 1, 0, NULL)\
	INSERT INTO portico.tbl_entidad_accgrid_enag(enag_pk, enag_enti_pk, enag_orden, enag_path) VALUES (28001, 21020, 1, 'sbup-generar')\
		INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enag', 'es', 28001, 'Generar Servicios')\

INSERT INTO portico.tbl_entidad_grupo_dato_engd (engd_pk, engd_enti_pk, engd_orden) VALUES (30050, 21020, 1)\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('engd', 'es', 30050, 'General')\

INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (31550, 21020, 45105, 1, 1, 1,  4, 1, 1, 1, NULL)\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 31550, 'Buque')\
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (31551, 21020, 45040, 1, 1, 2,  3, 1, 1, 1, NULL)\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 31551, 'T. IVA')\
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (31552, 21020, 41080, 1, 2, 1,  12, 0, 0, 0, NULL)\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 31552, 'Observaciones')\

-- AÑADIR EMBARCACION DEPORTIVA AL AMARRE
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado
	, enti_codigo) VALUES (24017, 'B', 1, 1, 1, 1, 'AMARRE_EMB_DEP')\
INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 24017, 'Embarcación')\
INSERT INTO portico.tbl_tipo_subparametro_tpsp(tpsp_pk, tpsp_tppr_pk, tpsp_tppr_dep_pk, tpsp_es_i18n, tpsp_es_tmp_exp) VALUES (24017, 20118, 20120, 0, 1)\
	INSERT INTO portico.tbl_entidad_entidad_enen (enen_entip_pk, enen_entih_pk, enen_orden) VALUES (20118, 24017, 3)\


-- SERVICIO DE AMARRE DEPORTIVO
INSERT INTO portico.tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado
	, enti_max_grid, enti_gis, enti_puerto, enti_codigo) VALUES (21021, 'T', 1, 1, 1, 1, 10000, 0, 0, 'AMARRE_DEP_SRV')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 21021, 'Servicio de Amarre Dep.')\
	INSERT INTO portico.tbl_tipo_servicio_tpsr(tpsr_pk, tpsr_es_temporal, tpsr_es_facturable, tpsr_es_exencionable, tpsr_tpdt_estado_pk) VALUES (21021, 1, 1, 0, NULL)\
	INSERT INTO portico.tbl_entidad_accgrid_enag(enag_pk, enag_enti_pk, enag_orden, enag_path) VALUES (28002, 21021, 1, 'samd-generar')\
		INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enag', 'es', 28002, 'Generar Servicios')\

INSERT INTO portico.tbl_entidad_grupo_dato_engd (engd_pk, engd_enti_pk, engd_orden) VALUES (30060, 21021, 1)\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('engd', 'es', 30060, 'General')\

INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (31570, 21021, 45450, 1, 1, 1,  4, 1, 1, 1, NULL)\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 31570, 'Amarre')\
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (31571, 21021, 45470, 1, 1, 2,  3, 1, 1, 1, NULL)\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 31571, 'Embarcación')\
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (31572, 21021, 41080, 1, 2, 1,  12, 0, 0, 0, NULL)\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 31572, 'Observaciones')\
INSERT INTO portico.tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (31573, 21021, 45040, 1, 1, 3,  3, 1, 1, 1, NULL)\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 31573, 'T. IVA')\


-- //@UNDO
-- SQL to undo the change goes here.

BEGIN
	-- SERVICIO DE AMARRE DEPORTIVO
	eraseTpsr(21021);
	-- AÑADIR EMBARCACION DEPORTIVA AL AMARRE
	eraseTpsp(24017);
	-- SERVICIO DE BUQUE DE PESCA
	eraseTpsr(21020);

	-- DOMINIO PUBLICO
	eraseTpsp(24023);
	eraseTpsp(24022);
	eraseTpsp(24021);

	eraseTppr(20125);
	eraseTppr(20126);
	eraseTppr(20124);
	eraseTppr(20123);
	eraseTppr(20122);
END;
\
