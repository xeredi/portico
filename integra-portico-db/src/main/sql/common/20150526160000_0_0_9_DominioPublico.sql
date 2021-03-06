-- // 20150526160000_0_0_9_DominioPublico.sql
-- Migration SQL that makes the change goes here.

-- DOMINIO PUBLICO
INSERT INTO tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado
	, enti_max_grid, enti_gis, enti_puerto, enti_codigo) VALUES (20132, 'P', 1, 1, 1, 1, 10000, 0, 0, 'TIPO_ACTIVIDAD_DP')\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20132, 'Tipo de Actividad D. P.')\
	INSERT INTO tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp) VALUES (20132, 1, 0)\
INSERT INTO tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado
	, enti_max_grid, enti_gis, enti_puerto, enti_codigo) VALUES (20133, 'P', 1, 1, 1, 1, 10000, 0, 0, 'TIPO_SUPERFICIE_DP_2')\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20133, 'Tipo de Superficie D. P. 2')\
	INSERT INTO tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp) VALUES (20133, 1, 0)\
INSERT INTO tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado
	, enti_max_grid, enti_gis, enti_puerto, enti_codigo) VALUES (20124, 'P', 1, 1, 1, 1, 10000, 1, 1, 'BIEN_DP_2')\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20124, 'Bien D. P. 2')\
	INSERT INTO tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp) VALUES (20124, 1, 0)\
INSERT INTO tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado
	, enti_max_grid, enti_gis, enti_puerto, enti_codigo) VALUES (20125, 'P', 1, 1, 1, 1, 10000, 0, 1, 'EXPEDIENTE_DP')\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20125, 'Expediente D. P.')\
	INSERT INTO tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp) VALUES (20125, 0, 0)\
INSERT INTO tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado
	, enti_max_grid, enti_gis, enti_puerto, enti_codigo) VALUES (20126, 'P', 1, 1, 1, 1, 10000, 0, 0, 'TIPO_EXPEDIENTE_DP')\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 20126, 'Tipo Expediente D. P.')\
	INSERT INTO tbl_tipo_parametro_tppr(tppr_pk, tppr_es_i18n, tppr_es_tmp_exp) VALUES (20126, 1, 0)\

INSERT INTO tbl_entidad_grupo_dato_engd (engd_pk, engd_enti_pk, engd_orden) VALUES (28095, 20132, 1)\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('engd', 'es', 28095, 'General')\
INSERT INTO tbl_entidad_grupo_dato_engd (engd_pk, engd_enti_pk, engd_orden) VALUES (28096, 20133, 1)\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('engd', 'es', 28096, 'General')\
INSERT INTO tbl_entidad_grupo_dato_engd (engd_pk, engd_enti_pk, engd_orden) VALUES (28097, 20124, 1)\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('engd', 'es', 28097, 'General')\
INSERT INTO tbl_entidad_grupo_dato_engd (engd_pk, engd_enti_pk, engd_orden) VALUES (28098, 20125, 1)\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('engd', 'es', 28098, 'General')\
INSERT INTO tbl_entidad_grupo_dato_engd (engd_pk, engd_enti_pk, engd_orden) VALUES (28099, 20126, 1)\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('engd', 'es', 28099, 'General')\

INSERT INTO tbl_tipo_dato_tpdt (tpdt_pk, tpdt_tipo_html, tpdt_tipo_elemento, tpdt_enti_pk, tpdt_codigo) VALUES (45580, 'S', 'PR', 20126, 'TIPO_EXPEDIENTE_DP_2')\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('tpdt', 'es', 45580, 'Tipo de Expediente D.P. 2')\

-- tpsp
INSERT INTO tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado
	, enti_codigo) VALUES (24021, 'B', 1, 1, 1, 1, 'SUPERFICIE_BIEN_DP_2')\
INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 24021, 'Superficie de Bien 2')\
INSERT INTO tbl_tipo_subparametro_tpsp(tpsp_pk, tpsp_tppr_pk, tpsp_tppr_dep_pk, tpsp_es_i18n, tpsp_es_tmp_exp) VALUES (24021, 20124, 20133, 0, 1)\
	INSERT INTO tbl_entidad_entidad_enen (enen_entip_pk, enen_entih_pk, enen_orden) VALUES (20124, 24021, 1)\

INSERT INTO tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado
	, enti_codigo) VALUES (24022, 'B', 1, 1, 1, 1, 'BIEN_EXPEDIENTE_DP')\
INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 24022, 'Bien de Expediente')\
INSERT INTO tbl_tipo_subparametro_tpsp(tpsp_pk, tpsp_tppr_pk, tpsp_tppr_dep_pk, tpsp_es_i18n, tpsp_es_tmp_exp) VALUES (24022, 20125, 20124, 0, 1)\
	INSERT INTO tbl_entidad_entidad_enen (enen_entip_pk, enen_entih_pk, enen_orden) VALUES (20125, 24022, 1)\

INSERT INTO tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado
	, enti_codigo) VALUES (24023, 'B', 1, 1, 1, 1, 'DATOEXP_EXPEDIENTE_DP')\
INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 24023, 'Dato de Explotacion de Expediente')\
INSERT INTO tbl_tipo_subparametro_tpsp(tpsp_pk, tpsp_tppr_pk, tpsp_tppr_dep_pk, tpsp_es_i18n, tpsp_es_tmp_exp) VALUES (24023, 20125, 20132, 0, 1)\
	INSERT INTO tbl_entidad_entidad_enen (enen_entip_pk, enen_entih_pk, enen_orden) VALUES (20125, 24023, 2)\

INSERT INTO tbl_entidad_grupo_dato_engd (engd_pk, engd_enti_pk, engd_orden) VALUES (28500, 24021, 1)\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('engd', 'es', 28500, 'General')\
INSERT INTO tbl_entidad_grupo_dato_engd (engd_pk, engd_enti_pk, engd_orden) VALUES (28501, 24022, 1)\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('engd', 'es', 28501, 'General')\
INSERT INTO tbl_entidad_grupo_dato_engd (engd_pk, engd_enti_pk, engd_orden) VALUES (28502, 24023, 1)\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('engd', 'es', 28502, 'General')\

-- TIPO_ACTIVIDAD_DP
INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (30520, 20132, 41040, 1, 1, 1, 2, 1, 1, 0, NULL)\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 30520, '% Gravamen')\

-- TIPO_SUPERFICIE_DP
INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (30530, 20133, 41040, 1, 1, 1, 2, 1, 1, 0, NULL)\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 30530, '% Gravamen')\

-- BIEN_DP
INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (30540, 20124, 41040, 1, 1, 1, 2, 1, 1, 0, NULL)\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 30540, 'Valor (euros)')\
INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (30541, 20124, 41060, 1, 1, 2, 2, 1, 1, 0, NULL)\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 30541, 'Plazo Amort. (años)')\

-- EXPEDIENTE_DP
INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (30550, 20125, 45480, 1, 1, 1, 3, 1, 1, 1, NULL)\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 30550, 'T. Expediente')\
INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (30551, 20125, 45035, 1, 1, 2, 3, 1, 1, 1, NULL)\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 30551, 'Cliente')\
INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (30552, 20125, 41060, 1, 1, 3, 2, 1, 1, 1, NULL)\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 30552, 'Periodicidad (meses)')\

-- SUPERFICIE_BIEN_DP
INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (32000, 24021, 41040, 1, 1, 1, 2, 1, 1, 0, NULL)\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 32000, 'Superficie')\
INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (32001, 24021, 41041, 1, 1, 2, 2, 1, 1, 0, NULL)\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 32001, 'Valor (euros)')\

-- DATOEXP_EXPEDIENTE_DP
INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (32050, 24023, 41040, 1, 1, 1, 2, 1, 1, 0, NULL)\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 32050, 'Importe')\


-- SERVICIO DE BUQUE DE PESCA
INSERT INTO tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado
	, enti_max_grid, enti_gis, enti_puerto, enti_codigo) VALUES (21020, 'T', 1, 1, 1, 1, 10000, 0, 0, 'BUQUE_PESCA_SRV')\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 21020, 'Servicio de Buque de Pesca')\
	INSERT INTO tbl_tipo_servicio_tpsr(tpsr_pk, tpsr_es_temporal, tpsr_es_facturable, tpsr_es_exencionable
		, tpsr_tpdt_estado_pk, tpsr_estados_vlrc, tpsr_estado_def) VALUES (21020, 1, 1, 0, NULL, NULL, NULL)\
--	INSERT INTO tbl_entidad_accgrid_enag(enag_pk, enag_enti_pk, enag_orden, enag_path) VALUES (28001, 21020, 1, 'sbup-generar')\
--		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enag', 'es', 28001, 'Generar Servicios')\

INSERT INTO tbl_entidad_grupo_dato_engd (engd_pk, engd_enti_pk, engd_orden) VALUES (30050, 21020, 1)\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('engd', 'es', 30050, 'General')\

INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (31550, 21020, 45105, 1, 1, 1,  4, 1, 1, 1, NULL)\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 31550, 'Buque')\
INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (31551, 21020, 45040, 1, 1, 2,  3, 1, 1, 1, NULL)\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 31551, 'T. IVA')\
INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (31552, 21020, 41080, 1, 2, 1,  12, 0, 0, 0, NULL)\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 31552, 'Observaciones')\

-- AÑADIR EMBARCACION DEPORTIVA AL AMARRE
INSERT INTO tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado
	, enti_codigo) VALUES (24017, 'B', 1, 1, 1, 1, 'AMARRE_EMB_DEP')\
INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 24017, 'Embarcación')\
INSERT INTO tbl_tipo_subparametro_tpsp(tpsp_pk, tpsp_tppr_pk, tpsp_tppr_dep_pk, tpsp_es_i18n, tpsp_es_tmp_exp) VALUES (24017, 20118, 20120, 0, 1)\
	INSERT INTO tbl_entidad_entidad_enen (enen_entip_pk, enen_entih_pk, enen_orden) VALUES (20118, 24017, 3)\


-- SERVICIO DE AMARRE DEPORTIVO
INSERT INTO tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado
	, enti_max_grid, enti_gis, enti_puerto, enti_codigo) VALUES (21021, 'T', 1, 1, 1, 1, 10000, 0, 0, 'AMARRE_DEP_SRV')\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 21021, 'Servicio de Amarre Dep.')\
	INSERT INTO tbl_tipo_servicio_tpsr(tpsr_pk, tpsr_es_temporal, tpsr_es_facturable, tpsr_es_exencionable
		, tpsr_tpdt_estado_pk, tpsr_estados_vlrc, tpsr_estado_def) VALUES (21021, 1, 1, 0, NULL, NULL, NULL)\
--	INSERT INTO tbl_entidad_accgrid_enag(enag_pk, enag_enti_pk, enag_orden, enag_path) VALUES (28002, 21021, 1, 'samd-generar')\
--		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enag', 'es', 28002, 'Generar Servicios')\

INSERT INTO tbl_entidad_grupo_dato_engd (engd_pk, engd_enti_pk, engd_orden) VALUES (30060, 21021, 1)\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('engd', 'es', 30060, 'General')\

INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (31570, 21021, 45450, 1, 1, 1,  4, 1, 1, 1, NULL)\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 31570, 'Amarre')\
INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (31571, 21021, 45470, 1, 1, 2,  3, 1, 1, 1, NULL)\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 31571, 'Embarcación')\
INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (31572, 21021, 41080, 1, 2, 1,  12, 0, 0, 0, NULL)\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 31572, 'Observaciones')\
INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
VALUES (31573, 21021, 45040, 1, 1, 3,  3, 1, 1, 1, NULL)\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 31573, 'T. IVA')\


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
	eraseTppr(20133);
	eraseTppr(20132);
END;
\
