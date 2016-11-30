-- // 20161129160000_0_1_0_SuministroRed.sql
-- Migration SQL that makes the change goes here.

	-- SERVICIO DE SUMINISTRO DE RED
INSERT INTO tbl_entidad_enti(enti_pk, enti_tipo, enti_cmd_alta, enti_cmd_baja, enti_cmd_edicion, enti_cmd_duplicado
	, enti_max_grid, enti_gis, enti_puerto, enti_codigo) VALUES (21030, 'T', 1, 1, 1, 1, 10000, 0, 0, 'SUMINISTRO_RED')\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('enti', 'es', 21030, 'SUMINISTRO DE RED')\
	INSERT INTO tbl_tipo_servicio_tpsr(tpsr_pk, tpsr_es_temporal, tpsr_es_facturable, tpsr_es_exencionable
		, tpsr_tpdt_estado_pk, tpsr_estados_vlrc, tpsr_estado_def) VALUES (21030, 1, 1, 1, NULL, 'F', 'F')\

	INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (58000 + (21030 - 21000) * 20 + 0)\
	INSERT INTO tbl_accion_entidad_acen(acen_pk, acen_enti_pk, acen_aebs_pk) VALUES (
		58000 + (21030 - 21000) * 20 + 0, 21030, (SELECT aebs_pk FROM tbl_accion_entidad_base_aebs WHERE aebs_prefix = 'item' AND aebs_codigo = 'list'))\

	INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (58000 + (21030 - 21000) * 20 + 1)\
	INSERT INTO tbl_accion_entidad_acen(acen_pk, acen_enti_pk, acen_aebs_pk) VALUES (
		58000 + (21030 - 21000) * 20 + 1, 21030, (SELECT aebs_pk FROM tbl_accion_entidad_base_aebs WHERE aebs_prefix = 'item' AND aebs_codigo = 'detail'))\

	INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (58000 + (21030 - 21000) * 20 + 2)\
	INSERT INTO tbl_accion_entidad_acen(acen_pk, acen_enti_pk, acen_aebs_pk) VALUES (
		58000 + (21030 - 21000) * 20 + 2, 21030, (SELECT aebs_pk FROM tbl_accion_entidad_base_aebs WHERE aebs_prefix = 'item' AND aebs_codigo = 'create'))\

	INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (58000 + (21030 - 21000) * 20 + 3)\
	INSERT INTO tbl_accion_entidad_acen(acen_pk, acen_enti_pk, acen_aebs_pk) VALUES (
		58000 + (21030 - 21000) * 20 + 3, 21030, (SELECT aebs_pk FROM tbl_accion_entidad_base_aebs WHERE aebs_prefix = 'item' AND aebs_codigo = 'edit'))\

	INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (58000 + (21030 - 21000) * 20 + 4)\
	INSERT INTO tbl_accion_entidad_acen(acen_pk, acen_enti_pk, acen_aebs_pk) VALUES (
		58000 + (21030 - 21000) * 20 + 4, 21030, (SELECT aebs_pk FROM tbl_accion_entidad_base_aebs WHERE aebs_prefix = 'item' AND aebs_codigo = 'remove'))\

	INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (58000 + (21030 - 21000) * 20 + 5)\
	INSERT INTO tbl_accion_entidad_acen(acen_pk, acen_enti_pk, acen_aebs_pk) VALUES (
		58000 + (21030 - 21000) * 20 + 5, 21030, (SELECT aebs_pk FROM tbl_accion_entidad_base_aebs WHERE aebs_prefix = 'item' AND aebs_codigo = 'duplicate'))\

	INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (58000 + (21030 - 21000) * 20 + 6)\
	INSERT INTO tbl_accion_entidad_acen(acen_pk, acen_enti_pk, acen_aebs_pk) VALUES (
		58000 + (21030 - 21000) * 20 + 6, 21030, (SELECT aebs_pk FROM tbl_accion_entidad_base_aebs WHERE aebs_prefix = 'item' AND aebs_codigo = 'ittrList'))\

	INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (58000 + (21030 - 21000) * 20 + 7)\
	INSERT INTO tbl_accion_entidad_acen(acen_pk, acen_enti_pk, acen_aebs_pk) VALUES (
		58000 + (21030 - 21000) * 20 + 7, 21030, (SELECT aebs_pk FROM tbl_accion_entidad_base_aebs WHERE aebs_prefix = 'item' AND aebs_codigo = 'ittrDetail'))\

	INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (58000 + (21030 - 21000) * 20 + 8)\
	INSERT INTO tbl_accion_entidad_acen(acen_pk, acen_enti_pk, acen_aebs_pk) VALUES (
		58000 + (21030 - 21000) * 20 + 8, 21030, (SELECT aebs_pk FROM tbl_accion_entidad_base_aebs WHERE aebs_prefix = 'item' AND aebs_codigo = 'depList'))\

	INSERT INTO tbl_entidad_grupo_dato_engd (engd_pk, engd_enti_pk, engd_orden) VALUES (30070, 21030, 1)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('engd', 'es', 30070, 'General')\

	INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
	VALUES (31600, 21030, 45405, 1, 1, 1,  3, 1, 1, 1, NULL)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 31600, 'Pto. Red')\
	INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
	VALUES (31601, 21030, 45035, 1, 1, 2,  3, 1, 1, 1, NULL)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 31601, 'Cliente')\
	INSERT INTO tbl_entidad_tipo_dato_entd (entd_pk, entd_enti_pk, entd_tpdt_pk, entd_grupo, entd_fila, entd_orden, entd_span, entd_obligatorio, entd_gridable, entd_filtrable, entd_valor_defecto)
	VALUES (31602, 21030, 41040, 1, 1, 3,  2, 1, 1, 0, NULL)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('entd', 'es', 31602, 'Consumo')\



-- //@UNDO
-- SQL to undo the change goes here.

BEGIN
	-- SERVICIO DE SUMINISTRO DE RED
	eraseTpsr(21030);
END;
\