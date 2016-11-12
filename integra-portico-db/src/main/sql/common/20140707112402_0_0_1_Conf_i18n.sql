-- // 0 0 5.sql
-- Migration SQL that makes the change goes here.


-- AP y Puertos
INSERT INTO tbl_superpuerto_sprt (sprt_pk, sprt_codigo) VALUES (36100, '0')\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_ext_pk, i18n_lang, i18n_text) VALUES ('sprt', 36100, 'es', 'Autp Genérica')\
INSERT INTO tbl_superpuerto_sprt (sprt_pk, sprt_codigo) VALUES (36101, '*')\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_ext_pk, i18n_lang, i18n_text) VALUES ('sprt', 36101, 'es', 'Autp Genérica 2')\
INSERT INTO tbl_superpuerto_sprt (sprt_pk, sprt_codigo) VALUES (36102, '**')\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_ext_pk, i18n_lang, i18n_text) VALUES ('sprt', 36102, 'es', 'Autp Genérica 3')\

INSERT INTO tbl_superpuerto_sprt (sprt_pk, sprt_codigo) VALUES (36000, '80')\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_ext_pk, i18n_lang, i18n_text) VALUES ('sprt', 36000, 'es', 'Baleares')\
INSERT INTO tbl_superpuerto_sprt (sprt_pk, sprt_codigo) VALUES (36001, '60')\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_ext_pk, i18n_lang, i18n_text) VALUES ('sprt', 36001, 'es', 'Alicante')\




-- Acciones base asociadas a entidad
INSERT INTO tbl_accion_entidad_base_aebs (aebs_pk, aebs_prefix, aebs_codigo) VALUES (2120, 'item', 'list')\
INSERT INTO tbl_accion_entidad_base_aebs (aebs_pk, aebs_prefix, aebs_codigo) VALUES (2121, 'item', 'detail')\
INSERT INTO tbl_accion_entidad_base_aebs (aebs_pk, aebs_prefix, aebs_codigo) VALUES (2122, 'item', 'create')\
INSERT INTO tbl_accion_entidad_base_aebs (aebs_pk, aebs_prefix, aebs_codigo) VALUES (2123, 'item', 'edit')\
INSERT INTO tbl_accion_entidad_base_aebs (aebs_pk, aebs_prefix, aebs_codigo) VALUES (2124, 'item', 'remove')\
INSERT INTO tbl_accion_entidad_base_aebs (aebs_pk, aebs_prefix, aebs_codigo) VALUES (2125, 'item', 'duplicate')\
INSERT INTO tbl_accion_entidad_base_aebs (aebs_pk, aebs_prefix, aebs_codigo) VALUES (2126, 'item', 'print')\
INSERT INTO tbl_accion_entidad_base_aebs (aebs_pk, aebs_prefix, aebs_codigo) VALUES (2127, 'item', 'export')\
INSERT INTO tbl_accion_entidad_base_aebs (aebs_pk, aebs_prefix, aebs_codigo) VALUES (2128, 'item', 'index')\
INSERT INTO tbl_accion_entidad_base_aebs (aebs_pk, aebs_prefix, aebs_codigo) VALUES (2129, 'item', 'file_import')\
INSERT INTO tbl_accion_entidad_base_aebs (aebs_pk, aebs_prefix, aebs_codigo) VALUES (2130, 'item', 'ittrList')\
INSERT INTO tbl_accion_entidad_base_aebs (aebs_pk, aebs_prefix, aebs_codigo) VALUES (2131, 'item', 'ittrDetail')\

INSERT INTO tbl_accion_entidad_base_aebs (aebs_pk, aebs_prefix, aebs_codigo) VALUES (2820, 'ittr', 'list')\
INSERT INTO tbl_accion_entidad_base_aebs (aebs_pk, aebs_prefix, aebs_codigo) VALUES (2821, 'ittr', 'detail')\
INSERT INTO tbl_accion_entidad_base_aebs (aebs_pk, aebs_prefix, aebs_codigo) VALUES (2822, 'ittr', 'create')\

-- Acciones base NO asociadas a entidad
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2000)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2000, 'tpdt', 'list')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2001)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2001, 'tpdt', 'detail')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2002)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2002, 'tpdt', 'create')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2003)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2003, 'tpdt', 'edit')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2004)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2004, 'tpdt', 'remove')\

INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2020)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2020, 'tpsr', 'list')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2021)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2021, 'tpsr', 'detail')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2022)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2022, 'tpsr', 'create')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2023)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2023, 'tpsr', 'edit')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2024)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2024, 'tpsr', 'remove')\

INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2040)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2040, 'tpss', 'list')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2041)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2041, 'tpss', 'detail')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2042)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2042, 'tpss', 'create')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2043)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2043, 'tpss', 'edit')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2044)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2044, 'tpss', 'remove')\

INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2060)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2060, 'tppr', 'list')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2061)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2061, 'tppr', 'detail')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2062)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2062, 'tppr', 'create')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2063)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2063, 'tppr', 'edit')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2064)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2064, 'tppr', 'remove')\

INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2080)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2080, 'tpsp', 'list')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2081)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2081, 'tpsp', 'detail')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2082)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2082, 'tpsp', 'create')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2083)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2083, 'tpsp', 'edit')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2084)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2084, 'tpsp', 'remove')\

INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2100)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2100, 'tpes', 'list')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2101)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2101, 'tpes', 'detail')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2102)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2102, 'tpes', 'create')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2103)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2103, 'tpes', 'edit')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2104)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2104, 'tpes', 'remove')\

INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2140)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2140, 'cdrf', 'list')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2141)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2141, 'cdrf', 'detail')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2142)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2142, 'cdrf', 'create')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2143)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2143, 'cdrf', 'edit')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2144)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2144, 'cdrf', 'remove')\

INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2160)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2160, 'usro', 'list')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2161)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2161, 'usro', 'detail')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2162)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2162, 'usro', 'create')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2163)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2163, 'usro', 'edit')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2164)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2164, 'usro', 'remove')\

INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2180)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2180, 'acbs', 'list')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2181)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2181, 'acbs', 'detail')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2182)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2182, 'acbs', 'create')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2183)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2183, 'acbs', 'edit')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2184)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2184, 'acbs', 'remove')\

INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2200)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2200, 'acen', 'list')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2201)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2201, 'acen', 'detail')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2202)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2202, 'acen', 'create')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2203)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2203, 'acen', 'edit')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2204)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2204, 'acen', 'remove')\

INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2220)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2220, 'grpo', 'list')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2221)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2221, 'grpo', 'detail')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2222)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2222, 'grpo', 'create')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2223)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2223, 'grpo', 'edit')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2224)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2224, 'grpo', 'remove')\

INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2240)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2240, 'crgo', 'list')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2241)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2241, 'crgo', 'detail')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2242)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2242, 'crgo', 'create')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2243)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2243, 'crgo', 'edit')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2244)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2244, 'crgo', 'remove')\

INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2260)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2260, 'rgla', 'list')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2261)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2261, 'rgla', 'detail')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2262)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2262, 'rgla', 'create')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2263)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2263, 'rgla', 'edit')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2264)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2264, 'rgla', 'remove')\

INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2280)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2280, 'rgin', 'list')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2281)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2281, 'rgin', 'detail')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2282)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2282, 'rgin', 'create')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2283)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2283, 'rgin', 'edit')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2284)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2284, 'rgin', 'remove')\

INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2300)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2300, 'aspc', 'list')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2301)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2301, 'aspc', 'detail')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2302)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2302, 'aspc', 'create')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2303)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2303, 'aspc', 'edit')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2304)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2304, 'aspc', 'remove')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2305)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2305, 'aspc', 'duplicate')\

INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2320)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2320, 'ascr', 'list')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2321)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2321, 'ascr', 'detail')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2322)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2322, 'ascr', 'create')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2323)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2323, 'ascr', 'edit')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2324)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2324, 'ascr', 'remove')\

INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2340)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2340, 'vlrc', 'list')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2341)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2341, 'vlrc', 'detail')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2342)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2342, 'vlrc', 'create')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2343)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2343, 'vlrc', 'edit')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2344)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2344, 'vlrc', 'remove')\

INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2360)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2360, 'vlrl', 'list')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2361)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2361, 'vlrl', 'detail')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2362)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2362, 'vlrl', 'create')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2363)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2363, 'vlrl', 'edit')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2364)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2364, 'vlrl', 'remove')\

INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2380)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2380, 'vlrd', 'list')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2381)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2381, 'vlrd', 'detail')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2382)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2382, 'vlrd', 'create')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2383)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2383, 'vlrd', 'edit')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2384)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2384, 'vlrd', 'remove')\

INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2400)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2400, 'engd', 'list')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2401)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2401, 'engd', 'detail')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2402)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2402, 'engd', 'create')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2403)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2403, 'engd', 'edit')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2404)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2404, 'engd', 'remove')\

INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2420)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2420, 'entd', 'list')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2421)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2421, 'entd', 'detail')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2422)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2422, 'entd', 'create')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2423)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2423, 'entd', 'edit')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2424)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2424, 'entd', 'remove')\

INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2440)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2440, 'trmt', 'list')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2441)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2441, 'trmt', 'detail')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2442)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2442, 'trmt', 'create')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2443)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2443, 'trmt', 'edit')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2444)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2444, 'trmt', 'remove')\

INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2460)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2460, 'trtd', 'list')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2461)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2461, 'trtd', 'detail')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2462)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2462, 'trtd', 'create')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2463)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2463, 'trtd', 'edit')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2464)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2464, 'trtd', 'remove')\

INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2480)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2480, 'sprt', 'list')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2481)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2481, 'sprt', 'detail')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2482)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2482, 'sprt', 'create')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2483)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2483, 'sprt', 'edit')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2484)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2484, 'sprt', 'remove')\

INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2500)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2500, 'prto', 'list')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2501)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2501, 'prto', 'detail')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2502)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2502, 'prto', 'create')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2503)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2503, 'prto', 'edit')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2504)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2504, 'prto', 'remove')\

INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2520)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2520, 'fcsr', 'list')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2521)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2521, 'fcsr', 'detail')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2522)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2522, 'fcsr', 'create')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2523)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2523, 'fcsr', 'edit')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2524)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2524, 'fcsr', 'remove')\

INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2540)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2540, 'fctr', 'list')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2541)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2541, 'fctr', 'detail')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2543)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2543, 'fctr', 'edit')\

INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2560)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2560, 'fctl', 'list')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2561)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2561, 'fctl', 'detail')\

INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2580)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2580, 'fctd', 'list')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2581)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2581, 'fctd', 'detail')\

INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2600)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2600, 'srsc', 'list')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2601)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2601, 'srsc', 'detail')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2602)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2602, 'srsc', 'create')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2603)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2603, 'srsc', 'edit')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2604)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2604, 'srsc', 'remove')\

INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2620)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2620, 'cmag', 'list')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2621)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2621, 'cmag', 'detail')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2622)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2622, 'cmag', 'create')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2623)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2623, 'cmag', 'edit')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2624)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2624, 'cmag', 'remove')\

INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2640)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2640, 'enen', 'list')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2641)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2641, 'enen', 'detail')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2642)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2642, 'enen', 'create')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2643)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2643, 'enen', 'edit')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2644)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2644, 'enen', 'remove')\

INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2680)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2680, 'pepr', 'list')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2681)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2681, 'pepr', 'detail')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2682)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2682, 'pepr', 'create')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2684)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2684, 'pepr', 'remove')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2690)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2690, 'pepr', 'load')\

INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2700)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2700, 'conf', 'list')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2701)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2701, 'conf', 'detail')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2703)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2703, 'conf', 'edit')\

INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2710)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2710, 'm18n', 'list')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2711)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2711, 'm18n', 'detail')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2713)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2713, 'm18n', 'edit')\

INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2742)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2742, 'vldr', 'create')\

INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2760)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2760, 'prbt', 'list')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2761)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2761, 'prbt', 'detail')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2764)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2764, 'prbt', 'remove')\

INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2780)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2780, 'prmn', 'list')\

INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2792)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2792, 'fcdr', 'create')\

INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2801)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2801, 'cdms', 'detail')\

INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2862)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2862, 'fcan', 'create')\

INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2882)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2882, 'fcrc', 'create')\

INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2900)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2900, 'aces', 'list')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2901)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2901, 'aces', 'detail')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2902)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2902, 'aces', 'create')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2903)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2903, 'aces', 'edit')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2904)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2904, 'aces', 'remove')\

INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2920)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2920, 'mdlo', 'list')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2921)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2921, 'mdlo', 'detail')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2922)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2922, 'mdlo', 'create')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2923)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2923, 'mdlo', 'edit')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (2924)\
	INSERT INTO tbl_accion_base_acbs (acbs_pk, acbs_prefix, acbs_codigo) VALUES (2924, 'mdlo', 'remove')\


-- Modulos (5000)
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (5000)\
	INSERT INTO tbl_modulo_mdlo (mdlo_pk, mdlo_codigo) VALUES (5000, 'administracion')\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_ext_pk, i18n_lang, i18n_text) VALUES ('mdlo', 5000, 'es', 'Administración')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (5001)\
	INSERT INTO tbl_modulo_mdlo (mdlo_pk, mdlo_codigo) VALUES (5001, 'maestros')\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_ext_pk, i18n_lang, i18n_text) VALUES ('mdlo', 5001, 'es', 'Maestros')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (5002)\
	INSERT INTO tbl_modulo_mdlo (mdlo_pk, mdlo_codigo) VALUES (5002, 'servicios')\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_ext_pk, i18n_lang, i18n_text) VALUES ('mdlo', 5002, 'es', 'Servicios')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (5003)\
	INSERT INTO tbl_modulo_mdlo (mdlo_pk, mdlo_codigo) VALUES (5003, 'estadisticas')\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_ext_pk, i18n_lang, i18n_text) VALUES ('mdlo', 5003, 'es', 'Estadísticas')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (5004)\
	INSERT INTO tbl_modulo_mdlo (mdlo_pk, mdlo_codigo) VALUES (5004, 'facturacion')\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_ext_pk, i18n_lang, i18n_text) VALUES ('mdlo', 5004, 'es', 'Facturación')\
INSERT INTO tbl_funcionalidad_fncd (fncd_pk) VALUES (5005)\
	INSERT INTO tbl_modulo_mdlo (mdlo_pk, mdlo_codigo) VALUES (5005, 'procesos')\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_ext_pk, i18n_lang, i18n_text) VALUES ('mdlo', 5005, 'es', 'Procesos')\



-- Grupos
INSERT INTO tbl_grupo_grpo (grpo_pk, grpo_nombre) VALUES (4000, 'Administradores')\
INSERT INTO tbl_funcionalidad_grupo_fngr (fngr_fncd_pk, fngr_grpo_pk)
	SELECT acbs_pk, 4000 FROM tbl_accion_base_acbs
\

-- Usuarios
INSERT INTO tbl_usuario_usro (usro_pk, usro_login, usro_contrasenia, usro_email, usro_nombre, usro_sprt_pk, usro_prto_pk) VALUES (
	1000, 'admin', 'admin', 'xeredi@gmail.com', 'Administrador', NULL, NULL)\
INSERT INTO tbl_usuario_usro (usro_pk, usro_login, usro_contrasenia, usro_email, usro_nombre, usro_sprt_pk, usro_prto_pk) VALUES (
	1001, 'batch', 'batch', 'xeredi@gmail.com', 'Procesos Batch', NULL, NULL)\

INSERT INTO tbl_usuario_grupo_usgr (usgr_usro_pk, usgr_grpo_pk) VALUES (1000, 4000)\


INSERT INTO tbl_puerto_prto (prto_pk, prto_sprt_pk, prto_codigo, prto_codigo_corto, prto_codigo_edi, prto_rec_aduanero, prto_unlocode)
VALUES (37100, 36100, '0', '0', NULL, NULL, 'ES***')\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_ext_pk, i18n_lang, i18n_text) VALUES ('prto', 37100, 'es', 'Puerto Genérico')\
INSERT INTO tbl_puerto_prto (prto_pk, prto_sprt_pk, prto_codigo, prto_codigo_corto, prto_codigo_edi, prto_rec_aduanero, prto_unlocode)
VALUES (37101, 36001, '*', '*', NULL, NULL, 'ES***')\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_ext_pk, i18n_lang, i18n_text) VALUES ('prto', 37101, 'es', 'Puerto Genérico 2')\
INSERT INTO tbl_puerto_prto (prto_pk, prto_sprt_pk, prto_codigo, prto_codigo_corto, prto_codigo_edi, prto_rec_aduanero, prto_unlocode)
VALUES (37102, 36102, '**', '**', NULL, NULL, 'ES***')\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_ext_pk, i18n_lang, i18n_text) VALUES ('prto', 37102, 'es', 'Puerto Genérico 2')\

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
VALUES (37004, 36000, '85', 'M', '5', '0727', 'ESMAH')\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_ext_pk, i18n_lang, i18n_text) VALUES ('prto', 37004, 'es', 'La Savina')\
INSERT INTO tbl_puerto_prto (prto_pk, prto_sprt_pk, prto_codigo, prto_codigo_corto, prto_codigo_edi, prto_rec_aduanero, prto_unlocode)
VALUES (37010, 36001, '60', 'A', '6', '0777', 'ESALC')\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_ext_pk, i18n_lang, i18n_text) VALUES ('prto', 37010, 'es', 'Alicante')\
INSERT INTO tbl_puerto_prto (prto_pk, prto_sprt_pk, prto_codigo, prto_codigo_corto, prto_codigo_edi, prto_rec_aduanero, prto_unlocode)
VALUES (37011, 36001, '62', 'T', '7', '0888', 'ESAL2')\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_ext_pk, i18n_lang, i18n_text) VALUES ('prto', 37011, 'es', 'Alicante 2')\
INSERT INTO tbl_puerto_prto (prto_pk, prto_sprt_pk, prto_codigo, prto_codigo_corto, prto_codigo_edi, prto_rec_aduanero, prto_unlocode)
VALUES (37012, 36001, '65', 'E', '8', '0999', 'ESAL3')\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_ext_pk, i18n_lang, i18n_text) VALUES ('prto', 37012, 'es', 'Alicante 3')\
INSERT INTO tbl_puerto_prto (prto_pk, prto_sprt_pk, prto_codigo, prto_codigo_corto, prto_codigo_edi, prto_rec_aduanero, prto_unlocode)
VALUES (37013, 36001, '66', 'G', '9', '0998', 'ESAL4')\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_ext_pk, i18n_lang, i18n_text) VALUES ('prto', 37013, 'es', 'Alicante 4')\


-- Configuracion
INSERT INTO tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'language_default', 'String', 'es')\
INSERT INTO tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'language_available', 'StringList', 'es, ca, en')\
INSERT INTO tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'date_format', 'String', 'dd/MM/yyyy')\
INSERT INTO tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'datetime_format', 'String', 'dd/MM/yyyy HH:mm')\
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
	'files_home', 'String', '/home/xeredi/proyectos/files/portico')\
INSERT INTO tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'filter_limit', 'Long', '5')\
INSERT INTO tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'webapp_install_path', 'String', '/home/xeredi/git/portico/argo-front-ng1/src/main/webapp')\
INSERT INTO tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'db_migration_dataSource_driver', 'String', 'oracle.jdbc.OracleDriver')\
INSERT INTO tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'db_migration_dataSource_url', 'String', 'jdbc:oracle:thin:@localhost:1521:orcl')\
INSERT INTO tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'db_migration_dataSource_username', 'String', 'integra')\
INSERT INTO tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'db_migration_dataSource_password', 'String', 'integra')\

INSERT INTO tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'email_user', 'String', 'xeredi')\
INSERT INTO tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'email_password', 'String', 'changeme')\
INSERT INTO tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'email_host', 'String', 'smtp.googlemail.com')\
INSERT INTO tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'email_port', 'String', '465')\
INSERT INTO tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'email_ssl', 'String', 'true')\
INSERT INTO tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'email_account', 'String', 'xeredi@gmail.com')\

INSERT INTO tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'user_batch', 'String', 'batch')\
INSERT INTO tbl_configuration_conf (conf_key, conf_value_type, conf_default_value) VALUES (
	'audit_enabled', 'Boolean', 'false')\





-- Mensajes i18n
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'app_nombre')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'app_nombre', 'Argo')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'menu')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'menu', 'Menu')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'errorList')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'errorList', 'Errores')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'filtro')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'filtro', 'Filtro')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('en', 'filtro', 'Filter')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'filtro_limit')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'filtro_limit', 'Máx. Resultados')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'grid_count')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'grid_count', '{{count}} Resultado(s)')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'format_date')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'format_date', 'dd/MM/yyyy')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'format_datetime')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'format_datetime', 'dd/MM/yyyy HH:mm')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'format_true')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'format_true', 'Si')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'format_false')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'format_false', 'No')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'format_1')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'format_1', 'Si')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'format_0')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'format_0', 'No')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'btn_acceso')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'btn_acceso', 'Acceso')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'btn_buscar')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'btn_buscar', 'Buscar')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'btn_volver')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'btn_volver', 'Volver')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'btn_aceptar')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'btn_aceptar', 'Aceptar')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'btn_cancelar')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'btn_cancelar', 'Cancelar')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'btn_crear')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'btn_crear', 'Nuevo')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'btn_editar')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'btn_editar', 'Editar')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'btn_guardar')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'btn_guardar', 'Guardar')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'btn_borrar')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'btn_borrar', 'Borrar')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'btn_duplicar')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'btn_duplicar', 'Duplicar')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'btn_filtrar')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'btn_filtrar', 'Filtro')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'btn_exportar')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'btn_exportar', 'Exportar')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'btn_imprimir')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'btn_imprimir', 'Imprimir')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'btn_recargar')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'btn_recargar', 'Recargar')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'btn_valorar')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'btn_valorar', 'Valorar')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'btn_valoraciones')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'btn_valoraciones', 'Valoraciones')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'btn_facturar')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'btn_facturar', 'Facturar')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'btn_facturas')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'btn_facturas', 'Facturas')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'btn_cargar')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'btn_cargar', 'Cargar')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'btn_start')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'btn_start', 'Iniciar')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'btn_pause')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'btn_pause', 'Pausar')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'btn_shutdown')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'btn_shutdown', 'Apagado Inmediato')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'btn_shutdownClean')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'btn_shutdownClean', 'Apagado')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'sec_facturacion')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'sec_facturacion', 'Facturación')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'sec_administracion')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'sec_administracion', 'Administración')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'sec_metamodelo')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'sec_metamodelo', 'Metamodelo')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'sec_configuracion')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'sec_configuracion', 'Configuración')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'sec_job')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'sec_job', 'Procesos Batch')\

INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fini')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fini', 'F. Inicio')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'ffin')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ffin', 'F. Fin')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fref')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fref', 'F. Referencia')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fliq')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fliq', 'F. Liquidación')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'ffac')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ffac', 'F. Facturación')\

INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'usro')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'usro', 'Usuario')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'usroList')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'usroList', 'Usuarios')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'usro_login')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'usro_login', 'Login')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'usro_contrasenia')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'usro_contrasenia', 'Contraseña')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'usro_email')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'usro_email', 'Email')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'usro_nombre')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'usro_nombre', 'Nombre')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'grpo')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'grpo', 'Grupo')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'grpoList')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'grpoList', 'Grupos')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'grpo_nombre')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'grpo_nombre', 'Nombre')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'accn')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'accn', 'Acción')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'accnList')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'accnList', 'Acciones')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'accn_codigo')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'accn_codigo', 'Código')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'accn_prefix')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'accn_prefix', 'Prefijo')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'accn_core')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'accn_core', 'Core?')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'accn_multiple')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'accn_multiple', 'Múltiple?')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'acen')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'acen', 'Acción de Entidad')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'acenList')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'acenList', 'Acciones de Entidad')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'grac')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'grac', 'Acción de Grupo')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'usgr')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'usgr', 'Grupo de Usuarios')\

INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'sprt')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'sprt', 'A. Portuaria')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'sprtList')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'sprtList', 'A. Portuarias')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'sprt_codigo')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'sprt_codigo', 'Código')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'sprt_nombre')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'sprt_nombre', 'Nombre')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'prto')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'prto', 'Puerto')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'prtoList')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'prtoList', 'Puertos')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'prto_codigo')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'prto_codigo', 'Código')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'prto_nombre')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'prto_nombre', 'Nombre')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'prto_codigoCorto')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'prto_codigoCorto', 'Cód. Corto')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'prto_codigoEdi')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'prto_codigoEdi', 'Cód. EDI')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'prto_recAduanero')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'prto_recAduanero', 'R. Aduanero')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'prto_unlocode')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'prto_unlocode', 'UNlocode')\

INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'enti')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enti', 'Entidad')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'entiList')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'entiList', 'Entidades')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'enti_codigo')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enti_codigo', 'Código')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'enti_tipo')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enti_tipo', 'Tipo')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'enti_nombre')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enti_nombre', 'Nombre')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'enti_cmdAlta')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enti_cmdAlta', 'Alta?')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'enti_cmdBaja')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enti_cmdBaja', 'Baja?')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'enti_cmdEdicion')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enti_cmdEdicion', 'Edición?')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'enti_cmdDuplicado')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enti_cmdDuplicado', 'Duplicado?')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'enti_maxGrid')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enti_maxGrid', 'Grid Máx (filas)')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'enti_entiPadresList')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enti_entiPadresList', 'Entidades Padre')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'enti_entiHijasList')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enti_entiHijasList', 'Entidades Hija')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'enti_i18n')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enti_i18n', 'I18n?')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'enti_tempExp')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enti_tempExp', 'Temporal?')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'enti_tpprAsociado')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enti_tpprAsociado', 'Maestro Asociado')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'enti_temporal')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enti_temporal', 'Temporal?')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'enti_facturable')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enti_facturable', 'Facturable?')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'enti_exencionable')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enti_exencionable', 'Exencionable?')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'enti_tpdtEstado')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enti_tpdtEstado', 'T. Dato Estado')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'enti_estado_def')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enti_estado_def', 'Estado Def.')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'enti_estados_vlrc')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enti_estados_vlrc', 'Estados Fact.')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'enti_tpdtNombre')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enti_tpdtNombre', 'T. Dato Nombre')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'enti_classpath')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enti_classpath', 'Classpath')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'tppr')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'tppr', 'Maestro')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'tpprList')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'tpprList', 'Maestros')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'tpsp')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'tpsp', 'Maestro Dependiente')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'tpspList')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'tpspList', 'Maestros Dependientes')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'tpsr')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'tpsr', 'Tipo de Servicio')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'tpsrList')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'tpsrList', 'Tipos de Servicio')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'tpss')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'tpss', 'Tipo de Subservicio')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'tpssList')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'tpssList', 'Tipos de Subservicio')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'tpes')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'tpes', 'Tipo de Estadística')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'tpesList')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'tpesList', 'Tipos de Estadística')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'cmag')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'cmag', 'Campo de Agregación')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'cmagList')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'cmagList', 'Campos de Agregación')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'cmag_nombre')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'cmag_nombre', 'Nombre')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'cmag_agregar')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'cmag_agregar', 'Agregar?')\

INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'trmt')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'trmt', 'Trámite')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'trmtList')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'trmtList', 'Trámites')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'trmt_estado_orig')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'trmt_estado_orig', 'Estado Or.')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'trmt_estado_dest')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'trmt_estado_dest', 'Estado Dt.')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'trmt_etiqueta')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'trmt_etiqueta', 'Texto')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'trtd')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'trtd', 'Dato de Trámite')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'trtdList')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'trtdList', 'Datos del Trámite')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'trtd_obligatorio')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'trtd_obligatorio', 'Obligatorio?')\

INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'enac')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enac', 'Acción Asociada a Entidad')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'enacList')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enacList', 'Acciones Asociadas a Entidad')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'enac_path')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enac_path', 'Path')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'enac_etiqueta')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enac_etiqueta', 'Etiqueta')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'enac_orden')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enac_orden', 'Orden')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'enag')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enag', 'Acción Asociada al grid de la Entidad')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'enagList')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enagList', 'Acciónes Asociadas al grid de la Entidad')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'enag_path')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enag_path', 'Ruta (URL)')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'enag_etiqueta')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enag_etiqueta', 'Etiqueta')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'enag_orden')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enag_orden', 'Orden')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'enen')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enen', 'Dependencia entre Entidades')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'enenList')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enenList', 'Dependencias entre Entidades')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'enen_entiPadre')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enen_entiPadre', 'Entidad Padre')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'enen_entiHija')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enen_entiHija', 'Entidad Hija')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'enen_orden')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'enen_orden', 'Orden')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'engd')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'engd', 'Grupo de Datos')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'engdList')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'engdList', 'Grupos de Datos')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'engd_numero')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'engd_numero', 'Nº')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'engd_etiqueta')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'engd_etiqueta', 'Etiqueta')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'entd')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'entd', 'Dato de Entidad')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'entdList')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'entdList', 'Datos de Entidad')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'entd_grupo')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'entd_grupo', 'Grupo')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'entd_fila')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'entd_fila', 'Fila')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'entd_orden')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'entd_orden', 'Orden')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'entd_span')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'entd_span', 'Span')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'entd_spanLg')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'entd_spanLg', 'Span (Lg)')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'entd_obligatorio')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'entd_obligatorio', 'Obligatorio?')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'entd_gridable')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'entd_gridable', 'Gridable?')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'entd_filtrable')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'entd_filtrable', 'Filtrable?')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'entd_valorDefecto')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'entd_valorDefecto', 'V. Defecto')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'entd_etiqueta')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'entd_etiqueta', 'Etiqueta')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'entd_validacion')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'entd_validacion', 'Validación')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'EntidadTipo_P')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'EntidadTipo_P', 'Maestro')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'EntidadTipo_B')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'EntidadTipo_B', 'Maestro Dependiente')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'EntidadTipo_T')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'EntidadTipo_T', 'Tipo de Servicio')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'EntidadTipo_S')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'EntidadTipo_S', 'Tipo de Subservicio')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'EntidadTipo_E')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'EntidadTipo_E', 'Tipo de Estadística')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'tpdt')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'tpdt', 'Tipo de Dato')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'tpdtList')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'tpdtList', 'Tipos de Dato')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'tpdt_codigo')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'tpdt_codigo', 'Código')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'tpdt_nombre')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'tpdt_nombre', 'Nombre')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'tpdt_tpht')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'tpdt_tpht', 'Tipo HTML')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'tpdt_tpel')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'tpdt_tpel', 'Tipo de Elemento')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'HtmlTipo_T')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'HtmlTipo_T', 'T - Textfield')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'HtmlTipo_S')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'HtmlTipo_S', 'S - Select')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'HtmlTipo_CB')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'HtmlTipo_CB', 'CB - Checkbox')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'HtmlTipo_D')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'HtmlTipo_D', 'D - Date')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'HtmlTipo_DT')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'HtmlTipo_DT', 'DT - Datetime')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'HtmlTipo_F')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'HtmlTipo_F', 'F - Filtro')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'HtmlTipo_TA')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'HtmlTipo_TA', 'TA - Textarea')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'ElementoTipo_ND')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ElementoTipo_ND', 'Nº Decimal')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'ElementoTipo_NE')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ElementoTipo_NE', 'Nº Entero')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'ElementoTipo_TX')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ElementoTipo_TX', 'Texto')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'ElementoTipo_FE')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ElementoTipo_FE', 'Fecha')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'ElementoTipo_FH')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ElementoTipo_FH', 'Fecha/Hora')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'ElementoTipo_PR')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ElementoTipo_PR', 'Maestro')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'ElementoTipo_BO')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ElementoTipo_BO', 'Booleano')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'ElementoTipo_CR')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ElementoTipo_CR', 'Cód. Referencia')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'ElementoTipo_SR')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ElementoTipo_SR', 'Servicio')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'cdrf')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'cdrf', 'Código de Referencia')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'cdrfList')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'cdrfList', 'Códigos de Referencia')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'cdrf_valor')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'cdrf_valor', 'Valor')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'cdrf_orden')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'cdrf_orden', 'Orden')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'cdrf_texto')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'cdrf_texto', 'Texto')\

INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'page_acceso')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'page_acceso', 'Acceso')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'page_home')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'page_home', 'Inicio')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'page_grid')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'page_grid', 'Listado')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'page_detail')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'page_detail', 'Detalle')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'page_create')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'page_create', 'Nuevo')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'page_duplicate')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'page_duplicate', 'Duplicado')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'page_edit')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'page_edit', 'Edición')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'i18n_text')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'i18n_text', 'Nombre')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'i18n_text_lang')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'i18n_text_lang', 'Nombre {{lang}}')\

INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'item')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'item', 'Item de Entidad')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'prmt')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'prmt', 'Maestro')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'prmtList')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'prmtList', 'Maestros')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'prmt_parametro')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'prmt_parametro', 'Código')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'prmt_lat')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'prmt_lat', 'Latitud')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'prmt_lon')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'prmt_lon', 'Longitud')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'sprm')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'sprm', 'Maestro Dependiente')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'srsc')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'srsc', 'Secuencia de Servicio')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'srscList')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'srscList', 'Secuencias de Servicio')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'srsc_anno')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'srsc_anno', 'Año')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'srsc_ultimo_numero')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'srsc_ultimo_numero', 'Último Nº')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'srvc')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'srvc', 'Servicio')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'srvcList')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'srvcList', 'Servicios')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'srvc_anno')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'srvc_anno', 'Año')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'srvc_numero')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'srvc_numero', 'Nº')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'srvc_falta')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'srvc_falta', 'F. Alta')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'srvc_estado')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'srvc_estado', 'Estado')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'ssrv')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ssrv', 'Subservicio')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'ssrv_estado')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ssrv_estado', 'Estado')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'ssrv_numero')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ssrv_numero', 'Nº')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'pepr')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'pepr', 'Período de proceso')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'peprList')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'peprList', 'Períodos de proceso')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'pepr_anio')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'pepr_anio', 'Año')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'pepr_mes')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'pepr_mes', 'Mes')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'pepr_file')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'pepr_file', 'Archivo')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'pepr_falta')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'pepr_falta', 'F. Alta')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'pepr_sobreescribir')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'pepr_sobreescribir', 'Sobreescribir?')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'pepr_cdmsGenerado')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'pepr_cdmsGenerado', 'C. Mensual?')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'cdms')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'cdms', 'Cuadro Mensual')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'estd')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'estd', 'Estadística')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'estdList')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'estdList', 'Estadísticas')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'prbt')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'prbt', 'Proceso')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'prbtList')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'prbtList', 'Procesos')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'prbt_modulo')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'prbt_modulo', 'Módulo')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'prbt_tipo')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'prbt_tipo', 'Tipo')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'prbt_estado')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'prbt_estado', 'Estado')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'prbt_falta')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'prbt_falta', 'F. Alta')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'prbt_duracion')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'prbt_duracion', 'Duración (mseg)')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'prbt_erroresCnt')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'prbt_erroresCnt', 'Nº Errores')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'prbt_alertasCnt')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'prbt_alertasCnt', 'Nº Alertas')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'prbt_mensajesCnt')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'prbt_mensajesCnt', 'Nº Mensajes')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'prbt_cancelar')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'prbt_cancelar', 'Cancelar')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'prmn')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'prmn', 'Mensaje de Proceso')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'prmnList')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'prmnList', 'Mensajes')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'prmn_nivel')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'prmn_nivel', 'Nivel')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'prmn_codigo')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'prmn_codigo', 'Código')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'prmn_mensaje')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'prmn_mensaje', 'Mensaje')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'prit')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'prit', 'Item de Proceso')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'prpmList')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'prpmList', 'Parámetros')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'prpm_nombre')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'prpm_nombre', 'Nombre')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'prpm_valor')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'prpm_valor', 'Valor')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'prarList')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'prarList', 'Ficheros')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'prarEntList')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'prarEntList', 'Ficheros Ent.')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'prarSalList')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'prarSalList', 'Ficheros Sal.')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'prar_nombre')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'prar_nombre', 'Nombre')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'pritList')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'pritList', 'Elementos')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'pritEntList')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'pritEntList', 'Elementos Ent.')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'pritSalList')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'pritSalList', 'Elementos Sal.')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'prit_nombre')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'prit_nombre', 'Nombre')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'prit_tipo')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'prit_tipo', 'Tipo')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'prit_enti')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'prit_enti', 'Entidad')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'ItemTipo_srvc')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ItemTipo_srvc', 'Servicio')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'ItemTipo_ssrv')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ItemTipo_ssrv', 'Subservicio')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'ItemTipo_vlrc')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ItemTipo_vlrc', 'Valoración')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'ItemTipo_fctr')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ItemTipo_fctr', 'Factura')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'ItemTipo_pepr')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ItemTipo_pepr', 'Período de Proceso')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'arch')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'arch', 'Archivo')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'archList')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'archList', 'Archivos')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'arch_nombre')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'arch_nombre', 'Nombre')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'arch_falta')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'arch_falta', 'F. Alta')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'arch_tamanio')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'arch_tamanio', 'Tamaño (bytes)')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'aspc')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc', 'Aspecto')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'aspcList')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspcList', 'Aspectos')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'aspc_cList')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_cList', 'Elementos de Cabecera')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'aspc_lcList')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_lcList', 'Elementos Cuantitativos de Línea')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'aspc_liList')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_liList', 'Elementos Informativos de Línea')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'aspc_ascrList')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_ascrList', 'Cargos Asociados al Aspecto')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'aspc_codigo')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_codigo', 'Código')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'aspc_descripcion')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_descripcion', 'Descripción')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'aspc_prioridad')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_prioridad', 'Prioridad')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'aspc_cetiqInfo')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_cetiqInfo', 'Elemento Informativo Cabecera')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'aspc_cetiqInfo1')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_cetiqInfo1', 'Elemento Informativo Cabecera 1')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'aspc_cetiqInfo2')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_cetiqInfo2', 'Elemento Informativo Cabecera 2')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'aspc_cetiqInfo3')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_cetiqInfo3', 'Elemento Informativo Cabecera 3')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'aspc_cetiqInfo4')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_cetiqInfo4', 'Elemento Informativo Cabecera 4')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'aspc_cetiqInfo5')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_cetiqInfo5', 'Elemento Informativo Cabecera 5')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'aspc_cetiqInfo6')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_cetiqInfo6', 'Elemento Informativo Cabecera 6')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'aspc_cpathInfo')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_cpathInfo', 'Ruta Elem. Informativo Cabecera')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'aspc_cpathInfo1')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_cpathInfo1', 'Ruta Elem. Informativo Cabecera 1')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'aspc_cpathInfo2')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_cpathInfo2', 'Ruta Elem. Informativo Cabecera 2')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'aspc_cpathInfo3')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_cpathInfo3', 'Ruta Elem. Informativo Cabecera 3')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'aspc_cpathInfo4')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_cpathInfo4', 'Ruta Elem. Informativo Cabecera 4')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'aspc_cpathInfo5')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_cpathInfo5', 'Ruta Elem. Informativo Cabecera 5')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'aspc_cpathInfo6')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_cpathInfo6', 'Ruta Elem. Informativo Cabecera 6')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'aspc_cgrpInfo')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_cgrpInfo', 'Agrupar Elem. Informativo Cabecera?')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'aspc_cgrpInfo1')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_cgrpInfo1', 'Agrupar Elem. Informativo Cabecera 1?')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'aspc_cgrpInfo2')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_cgrpInfo2', 'Agrupar Elem. Informativo Cabecera 2?')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'aspc_cgrpInfo3')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_cgrpInfo3', 'Agrupar Elem. Informativo Cabecera 3?')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'aspc_cgrpInfo4')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_cgrpInfo4', 'Agrupar Elem. Informativo Cabecera 4?')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'aspc_cgrpInfo5')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_cgrpInfo5', 'Agrupar Elem. Informativo Cabecera 5?')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'aspc_cgrpInfo6')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_cgrpInfo6', 'Agrupar Elem. Informativo Cabecera 6?')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'aspc_lsumCuant')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_lsumCuant', 'Sumarizar Elem. Cuantitativo Línea?')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'aspc_lsumCuant1')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_lsumCuant1', 'Sumarizar Elem. Cuantitativo Línea 1?')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'aspc_lsumCuant2')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_lsumCuant2', 'Sumarizar Elem. Cuantitativo Línea 2?')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'aspc_lsumCuant3')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_lsumCuant3', 'Sumarizar Elem. Cuantitativo Línea 3?')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'aspc_lsumCuant4')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_lsumCuant4', 'Sumarizar Elem. Cuantitativo Línea 4?')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'aspc_lsumCuant5')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_lsumCuant5', 'Sumarizar Elem. Cuantitativo Línea 5?')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'aspc_lsumCuant6')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_lsumCuant6', 'Sumarizar Elem. Cuantitativo Línea 6?')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'aspc_lgrpInfo')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_lgrpInfo', 'Agrupar Elem. Informativo Línea?')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'aspc_lgrpInfo1')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_lgrpInfo1', 'Agrupar Elem. Informativo Línea 1?')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'aspc_lgrpInfo2')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_lgrpInfo2', 'Agrupar Elem. Informativo Línea 2?')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'aspc_lgrpInfo3')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_lgrpInfo3', 'Agrupar Elem. Informativo Línea 3?')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'aspc_lgrpInfo4')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_lgrpInfo4', 'Agrupar Elem. Informativo Línea 4?')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'aspc_lgrpInfo5')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_lgrpInfo5', 'Agrupar Elem. Informativo Línea 5?')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'aspc_lgrpInfo6')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_lgrpInfo6', 'Agrupar Elem. Informativo Línea 6?')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'aspc_fechaVigencia')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aspc_fechaVigencia', 'F. Vigencia')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'ascr')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ascr', 'Cargo de Aspecto')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'crgo')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'crgo', 'Cargo')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'crgoList')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'crgoList', 'Cargos')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'crgo_codigo')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'crgo_codigo', 'Código')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'crgo_descripcion')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'crgo_descripcion', 'Descripción')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'crgo_codigoNormalizado')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'crgo_codigoNormalizado', 'Cód. Normalizado')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'crgo_tipo')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'crgo_tipo', 'Tipo')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'crgo_principal')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'crgo_principal', 'Principal?')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'crgo_temporal')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'crgo_temporal', 'Temporal?')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'crgo_fechaVigencia')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'crgo_fechaVigencia', 'F. Vigencia')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'rgla')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'rgla', 'Regla')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'rglaList')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'rglaList', 'Reglas')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'rgla_codigo')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'rgla_codigo', 'Código')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'rgla_tipo')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'rgla_tipo', 'Tipo')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'rgla_orden')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'rgla_orden', 'Orden')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'rgla_condicion')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'rgla_condicion', 'Condición')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'rgla_formula')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'rgla_formula', 'Fórmula')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'rgla_valorBase')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'rgla_valorBase', 'Valor Base')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'rgla_pathImpuesto')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'rgla_pathImpuesto', 'Ruta Impuesto')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'rgla_pathPagador')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'rgla_pathPagador', 'Ruta Pagador')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'rgla_pathEsSujPasivo')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'rgla_pathEsSujPasivo', 'Ruta Es Sujeto Pasivo')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'rgla_pathCodExen')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'rgla_pathCodExen', 'Ruta Cód. Exención')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'rgla_etiqInfo')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'rgla_etiqInfo', 'Etiq. Elem. Informativo')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'rgla_etiqInfo1')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'rgla_etiqInfo1', 'Etiq. Elem. Informativo 1')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'rgla_etiqInfo2')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'rgla_etiqInfo2', 'Etiq. Elem. Informativo 2')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'rgla_etiqInfo3')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'rgla_etiqInfo3', 'Etiq. Elem. Informativo 3')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'rgla_etiqInfo4')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'rgla_etiqInfo4', 'Etiq. Elem. Informativo 4')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'rgla_etiqInfo5')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'rgla_etiqInfo5', 'Etiq. Elem. Informativo 5')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'rgla_etiqInfo6')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'rgla_etiqInfo6', 'Etiq. Elem. Informativo 6')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'rgla_pathInfo')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'rgla_pathInfo', 'Ruta Elem. Informativo')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'rgla_pathInfo1')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'rgla_pathInfo1', 'Ruta Elem. Informativo 1')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'rgla_pathInfo2')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'rgla_pathInfo2', 'Ruta Elem. Informativo 2')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'rgla_pathInfo3')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'rgla_pathInfo3', 'Ruta Elem. Informativo 3')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'rgla_pathInfo4')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'rgla_pathInfo4', 'Ruta Elem. Informativo 4')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'rgla_pathInfo5')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'rgla_pathInfo5', 'Ruta Elem. Informativo 5')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'rgla_pathInfo6')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'rgla_pathInfo6', 'Ruta Elem. Informativo 6')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'rgla_etiqCuant')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'rgla_etiqCuant', 'Etiq. Elem. Cuantitativo')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'rgla_etiqCuant1')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'rgla_etiqCuant1', 'Etiq. Elem. Cuantitativo 1')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'rgla_etiqCuant2')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'rgla_etiqCuant2', 'Etiq. Elem. Cuantitativo 2')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'rgla_etiqCuant3')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'rgla_etiqCuant3', 'Etiq. Elem. Cuantitativo 3')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'rgla_etiqCuant4')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'rgla_etiqCuant4', 'Etiq. Elem. Cuantitativo 4')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'rgla_etiqCuant5')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'rgla_etiqCuant5', 'Etiq. Elem. Cuantitativo 5')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'rgla_etiqCuant6')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'rgla_etiqCuant6', 'Etiq. Elem. Cuantitativo 6')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'rgla_pathCuant')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'rgla_pathCuant', 'Ruta Elem. Cuantitativo')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'rgla_pathCuant1')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'rgla_pathCuant1', 'Ruta Elem. Cuantitativo 1')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'rgla_pathCuant2')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'rgla_pathCuant2', 'Ruta Elem. Cuantitativo 2')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'rgla_pathCuant3')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'rgla_pathCuant3', 'Ruta Elem. Cuantitativo 3')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'rgla_pathCuant4')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'rgla_pathCuant4', 'Ruta Elem. Cuantitativo 4')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'rgla_pathCuant5')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'rgla_pathCuant5', 'Ruta Elem. Cuantitativo 5')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'rgla_pathCuant6')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'rgla_pathCuant6', 'Ruta Elem. Cuantitativo 6')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'rgin')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'rgin', 'Incompatibilidad entre Reglas')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'rginList')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'rginList', 'Incompatibilidades entre Reglas')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'rgin_rgla2')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'rgin_rgla2', 'Regla Incompatible')\

INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrc')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrc', 'Valoración')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrcList')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrcList', 'Valoraciones')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrc_id')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrc_id', 'ID')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrc_pagador')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrc_pagador', 'Pagador')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrc_importe')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrc_importe', 'Importe')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrc_impuesto')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrc_impuesto', 'Impuesto')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrc_fliq')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrc_fliq', 'F. Liquidación')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrc_falta')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrc_falta', 'F. Alta')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrc_sujPasivo')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrc_sujPasivo', 'Suj. Pasivo?')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrc_codExencion')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrc_codExencion', 'Cód. Exención')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrgList')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrgList', 'Cargos')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrg_importe')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrg_importe', 'Importe')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlriList')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlriList', 'Impuestos')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlri_impuesto')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlri_impuesto', 'Impuesto')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlri_porcentaje')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlri_porcentaje', '%')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlri_importe_base')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlri_importe_base', 'Imp. Base')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlri_importe_impuesto')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlri_importe_impuesto', 'Importe')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrl')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrl', 'Linea de Valoración')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrlList')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrlList', 'Lineas de Valoración')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrl_importeBase')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrl_importeBase', 'Imp. Base')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrl_importe')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrl_importe', 'Importe')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrl_impuesto')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrl_impuesto', 'Impuesto')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrl_vlrdCount')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrl_vlrdCount', 'Nº Detalles')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrl_subtotal')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrl_subtotal', 'Subtotal')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrl_info1')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrl_info1', 'Info. 1')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrl_info2')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrl_info2', 'Info. 2')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrl_info3')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrl_info3', 'Info. 3')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrl_info4')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrl_info4', 'Info. 4')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrl_info5')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrl_info5', 'Info. 5')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrl_info6')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrl_info6', 'Info. 6')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrl_cuant1')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrl_cuant1', 'Cuant. 1')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrl_cuant2')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrl_cuant2', 'Cuant. 2')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrl_cuant3')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrl_cuant3', 'Cuant. 3')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrl_cuant4')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrl_cuant4', 'Cuant. 4')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrl_cuant5')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrl_cuant5', 'Cuant. 5')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrl_cuant6')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrl_cuant6', 'Cuant. 6')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrd')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrd', 'Detalle de Valoración')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrdList')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrdList', 'Detalles de Valoración')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrd_valorBase')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrd_valorBase', 'Valor Base')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrd_importeBase')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrd_importeBase', 'Imp. Base')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrd_importe')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrd_importe', 'Importe')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrd_info1')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrd_info1', 'Info. 1')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrd_info2')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrd_info2', 'Info. 2')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrd_info3')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrd_info3', 'Info. 3')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrd_info4')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrd_info4', 'Info. 4')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrd_info5')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrd_info5', 'Info. 5')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrd_info6')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrd_info6', 'Info. 6')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrd_cuant1')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrd_cuant1', 'Cuant. 1')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrd_cuant2')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrd_cuant2', 'Cuant. 2')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrd_cuant3')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrd_cuant3', 'Cuant. 3')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrd_cuant4')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrd_cuant4', 'Cuant. 4')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrd_cuant5')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrd_cuant5', 'Cuant. 5')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vlrd_cuant6')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vlrd_cuant6', 'Cuant. 6')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'FacturaEstado_NO')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'FacturaEstado_NO', 'Normal')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'FacturaEstado_AN')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'FacturaEstado_AN', 'Anulada')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'FacturaEstado_RP')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'FacturaEstado_RP', 'Rec. Positiva')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'FacturaEstado_RN')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'FacturaEstado_RN', 'Rec. Negativa')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fcsr')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fcsr', 'Serie de Factura')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fcsrList')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fcsrList', 'Series de Factura')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fcsr_serie')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fcsr_serie', 'Serie')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fcsr_anio')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fcsr_anio', 'Año')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fcsr_numeroUltimo')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fcsr_numeroUltimo', 'Último Nº')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fctr')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fctr', 'Factura')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fctrList')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fctrList', 'Facturas')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fctr_ffac')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fctr_ffac', 'F. Facturación')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fctr_estado')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fctr_estado', 'Estado')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fctr_sujPasivo')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fctr_sujPasivo', 'Suj. Pasivo?')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fctr_info1')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fctr_info1', 'Info. 1')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fctr_info2')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fctr_info2', 'Info. 2')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fctr_info3')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fctr_info3', 'Info. 3')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fctr_info4')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fctr_info4', 'Info. 4')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fctr_info5')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fctr_info5', 'Info. 5')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fctr_info6')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fctr_info6', 'Info. 6')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fctr_importe')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fctr_importe', 'Importe')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fctr_impuesto')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fctr_impuesto', 'Impuesto')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fctr_pagador')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fctr_pagador', 'Pagador')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fctr_falta')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fctr_falta', 'F. Alta')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fctsList')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fctsList', 'Servicios')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fcts_codExencion')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fcts_codExencion', 'Cód. Exención')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fctgList')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fctgList', 'Cargos')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fctg_importe')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fctg_importe', 'Importe')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fctiList')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fctiList', 'Impuestos')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fcti_impuesto')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fcti_impuesto', 'Impuesto')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fcti_porcentaje')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fcti_porcentaje', '%')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fcti_importe_base')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fcti_importe_base', 'Importe Base')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fcti_importe_impuesto')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fcti_importe_impuesto', 'Importe Impuesto')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fctl')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fctl', 'Línea de Factura')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fctlList')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fctlList', 'Líneas de Factura')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fctl_importeBase')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fctl_importeBase', 'Imp. Base')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fctl_importe')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fctl_importe', 'Importe')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fctl_fctdCount')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fctl_fctdCount', 'Nº Detalles')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fctl_impuesto')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fctl_impuesto', 'Impuesto')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fctl_info1')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fctl_info1', 'Info. 1')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fctl_info2')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fctl_info2', 'Info. 2')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fctl_info3')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fctl_info3', 'Info. 3')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fctl_info4')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fctl_info4', 'Info. 4')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fctl_info5')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fctl_info5', 'Info. 5')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fctl_info6')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fctl_info6', 'Info. 6')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fctl_cuant1')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fctl_cuant1', 'Cuant. 1')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fctl_cuant2')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fctl_cuant2', 'Cuant. 2')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fctl_cuant3')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fctl_cuant3', 'Cuant. 3')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fctl_cuant4')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fctl_cuant4', 'Cuant. 4')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fctl_cuant5')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fctl_cuant5', 'Cuant. 5')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fctl_cuant6')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fctl_cuant6', 'Cuant. 6')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fctd')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fctd', 'Detalle de Factura')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fctdList')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fctdList', 'Detalles de Factura')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'conf')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'conf', 'Parámetro de Configuración')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'confList')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'confList', 'Parámetros de Configuración')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'conf_key')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'conf_key', 'Parámetro')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'conf_valueType')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'conf_valueType', 'Tipo')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'conf_value')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'conf_value', 'Valor')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'conf_defaultValue')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'conf_defaultValue', 'Valor Defecto')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'm18n')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'm18n', 'Mensaje i18n')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'm18nList')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'm18nList', 'Mensajes i18n')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'm18n_key')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'm18n_key', 'Clave')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'schr')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'schr', 'Planificador de Procesos')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (1, 'E00000')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'E00000', 'E00000 - Error no controlado: {0}')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (1, 'E00001')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'E00001', 'E00001 - Campo Obligatorio: {0}')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (1, 'E00002')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'E00002', 'E00002 - Campo Obligatorio: Descripción para el idioma {0}')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (1, 'E00005')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'E00005', 'E00005 - {0} duplicado/a')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (1, 'E00006')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'E00006', 'E00006 - Error de período de Vigencia. Fecha Fin ha de ser posterior a Fecha Inicio')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (1, 'E00008')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'E00008', 'E00008 - {0} con identificador {1} no encontrado/a')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (1, 'E00009')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'E00009', 'E00009 - {0} solapado/a con el período de vigencia')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (1, 'E00011')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'E00011', 'E00011 - Subservicio en estado {0} inválido para ejecutar la acción')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (1, 'E00012')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'E00012', 'E00012 - {0} solo admite los valores {1}')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (1, 'E00013')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'E00013', 'E00013 - Operación no Permitida: {0}')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (1, 'E00014')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'E00014', 'E00014 - Contraseña Incorrecta')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (1, 'E00015')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'E00015', 'E00015 - Privilegios insuficientes ({0}:{1})')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'cdms_numero')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'cdms_numero', 'Nº')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'cdms_tm')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'cdms_tm', 'Tm')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'cdms_teus')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'cdms_teus', 'TEUS')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'cdms_ca')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'cdms_ca', 'Con Carga')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'cdms_va')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'cdms_va', 'Vacíos')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'cdms_embarcado')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'cdms_embarcado', 'Embarcado')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'cdms_desembarcado')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'cdms_desembarcado', 'Desembarcado')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'cdms_transito')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'cdms_transito', 'Tránsito')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'cdms_transbordo')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'cdms_transbordo', 'Transbordo')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'cdms_GL')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'cdms_GL', 'GRANELES LIQUIDOS')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'cdms_GLPETR')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'cdms_GLPETR', 'CRUDOS DE PETROLEO')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'cdms_GLGASN')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'cdms_GLGASN', 'GAS NATURAL')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'cdms_GLPREF')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'cdms_GLPREF', 'PRODUCTOS PETROLIFEROS REFINADOS')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'cdms_GLOTRO')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'cdms_GLOTRO', 'OTROS GRANELES LIQUIDOS')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'cdms_GS')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'cdms_GS', 'GRANELES SOLIDOS')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'cdms_GSIESP')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'cdms_GSIESP', 'POR INSTALACION ESPECIAL')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'cdms_GSNIES')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'cdms_GSNIES', 'SIN INSTALACION ESPECIAL')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'cdms_MG')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'cdms_MG', 'MERCANCIA GENERAL')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'cdms_PASAJE')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'cdms_PASAJE', 'Nº PASAJEROS (EXCLUIDO T. BAHIA)')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'cdms_PASCRU')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'cdms_PASCRU', 'Nº PASAJEROS DE CRUCERO')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'cdms_VET2')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'cdms_VET2', 'Nº VEHICULOS (Turismos en rég. pasaje, Automóviles y Autobuses)')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'cdms_CTEUS')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'cdms_CTEUS', 'TEUS (con carga y vacíos)')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'cdms_RR')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'cdms_RR', 'TRAFICO RO-RO')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'cdms_RRC')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'cdms_RRC', 'EN CONTENEDORES')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'cdms_RRO')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'cdms_RRO', 'EN OTROS MEDIOS')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'cdms_AV')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'cdms_AV', 'AVITUALLAMIENTO')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'cdms_AVPPET')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'cdms_AVPPET', 'PROD. PETROLIFEROS')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'cdms_AVOTRO')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'cdms_AVOTRO', 'OTROS')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'cdms_TRALOC')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'cdms_TRALOC', 'TRAFICO LOCAL')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'cdms_PESCAF')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'cdms_PESCAF', 'PESCA FRESCA')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'MensajeNivel_I')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'MensajeNivel_I', 'I - Información')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'MensajeNivel_W')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'MensajeNivel_W', 'W - Alerta')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'MensajeNivel_E')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'MensajeNivel_E', 'E - Error')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'ProcesoEstado_C')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ProcesoEstado_C', 'C - En Cola')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'ProcesoEstado_E')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ProcesoEstado_E', 'E - En Ejecución')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'ProcesoEstado_F')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ProcesoEstado_F', 'F - Finalizado')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'ProcesoModulo_S')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ProcesoModulo_S', 'S - Servicios')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'ProcesoModulo_E')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ProcesoModulo_E', 'E - Estadísticas')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'ProcesoModulo_F')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ProcesoModulo_F', 'F - Facturación')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'ProcesoTipo_ESC_CARGA')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ProcesoTipo_ESC_CARGA', 'Carga de Escala')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'ProcesoTipo_PES_CARGA')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ProcesoTipo_PES_CARGA', 'Carga de Manifiesto de Pesca')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'ProcesoTipo_MAN_CARGA')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ProcesoTipo_MAN_CARGA', 'Carga de Manifiesto de Mescancía')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'ProcesoTipo_EST_CARGA')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ProcesoTipo_EST_CARGA', 'Carga de Período de Proceso')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'ProcesoTipo_EST_CREACION')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ProcesoTipo_EST_CREACION', 'Creación de Período de Proceso')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'ProcesoTipo_VALORADOR')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ProcesoTipo_VALORADOR', 'Valorador')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'ProcesoTipo_FACTURADOR')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ProcesoTipo_FACTURADOR', 'Facturador')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'CargoTipo_T')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'CargoTipo_T', 'T - Tarifa')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'CargoTipo_B')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'CargoTipo_B', 'B - Tasa')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'ReglaTipo_T')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ReglaTipo_T', 'T - Precio')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'ReglaTipo_C')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ReglaTipo_C', 'C - Coeficiente')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'ReglaTipo_D')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ReglaTipo_D', 'D - Bonificación')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'ConfigurationValueType_String')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ConfigurationValueType_String', 'Texto')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'ConfigurationValueType_Boolean')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ConfigurationValueType_Boolean', 'Lógico')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'ConfigurationValueType_Double')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ConfigurationValueType_Double', 'Nº Decimal')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'ConfigurationValueType_Long')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ConfigurationValueType_Long', 'Nº Entero')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'ConfigurationValueType_Date')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ConfigurationValueType_Date', 'Fecha')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'ConfigurationValueType_DateTime')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ConfigurationValueType_DateTime', 'Fecha/Hora')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'ConfigurationValueType_StringList')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'ConfigurationValueType_StringList', 'Lista de Textos')\

INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (1, 'mani_resumen')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'mani_resumen', 'Resumen Manifiesto')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (1, 'mabl_resumen')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'mabl_resumen', 'Resumen BL')\

INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'page_verificarTotales')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'page_verificarTotales', 'Verificar Totales')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'mani_resumen_mercancias')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'mani_resumen_mercancias', 'Mercancías')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'mani_resumen_pasajeros')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'mani_resumen_pasajeros', 'Pasajeros')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'mani_resumen_numBlsMercancia')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'mani_resumen_numBlsMercancia', 'Nº BLs')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'mani_resumen_numBlsPasajeros')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'mani_resumen_numBlsPasajeros', 'Nº BLs')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'mani_resumen_numContenedores20')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'mani_resumen_numContenedores20', 'Contenedores 20')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'mani_resumen_numContenedores20Llenos')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'mani_resumen_numContenedores20Llenos', 'Llenos')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'mani_resumen_numContenedores20Vacios')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'mani_resumen_numContenedores20Vacios', 'Vacíos')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'mani_resumen_numContenedores40')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'mani_resumen_numContenedores40', 'Contenedores 40')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'mani_resumen_numContenedores40Llenos')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'mani_resumen_numContenedores40Llenos', 'Llenos')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'mani_resumen_numContenedores40Vacios')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'mani_resumen_numContenedores40Vacios', 'Vacíos')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'mani_resumen_numEquipamientos')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'mani_resumen_numEquipamientos', 'Equipamientos')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'mani_resumen_numEquipamientosLlenos')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'mani_resumen_numEquipamientosLlenos', 'Llenos')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'mani_resumen_numEquipamientosVacios')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'mani_resumen_numEquipamientosVacios', 'Vacíos')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'mani_resumen_numPartidasMercancia')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'mani_resumen_numPartidasMercancia', 'Nº Partidas')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'mani_resumen_pesoPartidasMercancia')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'mani_resumen_pesoPartidasMercancia', 'Peso Total (Kg)')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'mani_resumen_numPartidasPasajeros')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'mani_resumen_numPartidasPasajeros', 'Nº Partidas')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'mani_resumen_numPasajeros')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'mani_resumen_numPasajeros', 'Nº Pasajeros')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'mani_resumen_numCruceristas')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'mani_resumen_numCruceristas', 'Nº Cruceristas')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'mani_resumen_numVehiculos')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'mani_resumen_numVehiculos', 'Nº Vehículos')\

INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (1, 'atra_cambiarMuelle')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'atra_cambiarMuelle', 'Cambiar Muelle Atraque')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (1, 'atra_autorizarFPrevio')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'atra_autorizarFPrevio', 'Autorizar Fondeo Previo Atraque')\

INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'vldr')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'vldr', 'Valorador')\

INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fcdr')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fcdr', 'Facturador')\

INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fcan')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fcan', 'Anulación')\

INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fcrc')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fcrc', 'Rectificación')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fcrc_duplicar')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fcrc_duplicar', 'Duplicar Datos?')\

INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'aces')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aces', 'Acción Especial')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'acesList')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'acesList', 'Acciones Especiales')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'aces_orden')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aces_orden', 'Orden')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'aces_path')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'aces_path', 'Path')\

INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fncd')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fncd', 'Funcionalidad')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'fncdList')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'fncdList', 'Funcionalidades')\

INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'acbs')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'acbs', 'Acción Base')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'acbsList')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'acbsList', 'Acciones Base')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'acbs_codigo')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'acbs_codigo', 'Código')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'acbs_prefix')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'acbs_prefix', 'Prefijo')\

INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'mdlo')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'mdlo', 'Módulo')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'mdloList')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'mdloList', 'Módulos')\
INSERT INTO tbl_message_mesg (mesg_internal, mesg_key) VALUES (0, 'mdlo_codigo')\
	INSERT INTO tbl_message_i18n_m18n (m18n_language, m18n_key, m18n_value) VALUES ('es', 'mdlo_codigo', 'Código')\





-- //@UNDO
-- SQL to undo the change goes here.

-- Mensajes i18n
DELETE FROM tbl_message_i18n_m18n\
DELETE FROM tbl_message_mesg\

-- Configuracion
DELETE FROM tbl_configuration_conf\

-- Usuarios
DELETE FROM tbl_usuario_grupo_usgr\
DELETE FROM tbl_usuario_usro\

-- Grupos
DELETE FROM tbl_funcionalidad_grupo_fngr\
DELETE FROM tbl_grupo_grpo\

-- Acciones Base
DELETE FROM tbl_funcionalidad_fncd\
DELETE FROM tbl_accion_entidad_base_aebs\


-- AP y Puertos
DELETE FROM tbl_i18n_i18n WHERE i18n_pref = 'prto'\
DELETE FROM tbl_i18n_i18n WHERE i18n_pref = 'sprt'\
DELETE FROM tbl_puerto_prto\
DELETE FROM tbl_superpuerto_sprt\
