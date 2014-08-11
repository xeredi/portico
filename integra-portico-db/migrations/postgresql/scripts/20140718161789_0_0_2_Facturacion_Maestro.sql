-- // 0 0 2 Facturacion Maestro
-- Migration SQL that makes the change goes here.
INSERT INTO portico.tbl_cargo_crgo (crgo_pk, crgo_codigo, crgo_codigo_norm, crgo_es_principal, crgo_es_temporal, crgo_tpsr_pk, crgo_tipo, crgo_descripcion)
	VALUES (60000, 'B5', NULL, 1, 0, 21001, 'B', 'TASA DE PESCA FRESCA')
\
	INSERT INTO portico.tbl_cargo_version_crgv (crgv_pk, crgv_crgo_pk, crgv_fini, crgv_ffin) VALUES (62000, 60000, '2013-01-01', NULL);
	\
	INSERT INTO portico.tbl_regla_rgla (rgla_pk, rgla_crgo_pk, rgla_enti_pk, rgla_tipo, rgla_codigo) VALUES (63000, 60000, 22001, 'T', 'B5-10-0000');
	\
INSERT INTO portico.tbl_cargo_crgo (crgo_pk, crgo_codigo, crgo_codigo_norm, crgo_es_principal, crgo_es_temporal, crgo_tpsr_pk, crgo_tipo, crgo_descripcion)
	VALUES (60001, 'B2', 'B2', 1, 0, 21002, 'B', 'TASA AL PASAJE')
\
	INSERT INTO portico.tbl_cargo_version_crgv (crgv_pk, crgv_crgo_pk, crgv_fini, crgv_ffin) VALUES (62001, 60001, '2013-01-01', NULL);
	\
	INSERT INTO portico.tbl_regla_rgla (rgla_pk, rgla_crgo_pk, rgla_enti_pk, rgla_tipo, rgla_codigo) VALUES (63001, 60001, 22004, 'T', 'B2-10-0000');
	\
		INSERT INTO portico.tbl_regla_version_rglv (
			rglv_pk, rglv_rgla_pk, rglv_fini, rglv_ffin, rglv_orden, rglv_importe_base, rglv_condicion, rglv_formula
			, rglv_path_impuesto, rglv_path_pagador, rglv_path_es_suj_pasivo, rglv_path_cod_exen
			, rglv_path_info1, rglv_path_info2, rglv_path_info3, rglv_path_info4, rglv_path_info5, rglv_path_info6
			, rglv_etiq_info1, rglv_etiq_info2, rglv_etiq_info3, rglv_etiq_info4, rglv_etiq_info5, rglv_etiq_info6
			, rglv_path_cuant1, rglv_path_cuant2, rglv_path_cuant3, rglv_path_cuant4, rglv_path_cuant5, rglv_path_cuant6
			, rglv_etiq_cuant1, rglv_etiq_cuant2, rglv_etiq_cuant3, rglv_etiq_cuant4, rglv_etiq_cuant5, rglv_etiq_cuant6
		) VALUES (
			64000, 63001, '2013-01-01', NULL, 1, 2.95, 'true', '2.95 * dato(ENTERO_04) / 1000.0'
			, 'padre(BL).dato(TIPO_IVA)', 'padre(BL).padre(MANIFIESTO_CONSIGNATARIO).dato(ORGA)', 'padre(BL).dato(BOOLEANO_01)', 'padre(BL).dato(COD_EXEN)'
			, 'dato(MERCANCIA)', 'dato(ENTERO_04)', NULL, NULL, NULL, NULL
			, 'Mercancia', 'Peso', NULL, NULL, NULL, NULL
			, NULL, NULL, NULL, NULL, NULL, NULL
			, NULL, NULL, NULL, NULL, NULL, NULL
		)
		\
	INSERT INTO portico.tbl_regla_rgla (rgla_pk, rgla_crgo_pk, rgla_enti_pk, rgla_tipo, rgla_codigo) VALUES (63002, 60001, 22004, 'C', 'B2-C001');
	\
		INSERT INTO portico.tbl_regla_version_rglv (
			rglv_pk, rglv_rgla_pk, rglv_fini, rglv_ffin, rglv_orden, rglv_importe_base, rglv_condicion, rglv_formula
			, rglv_path_impuesto, rglv_path_pagador, rglv_path_es_suj_pasivo, rglv_path_cod_exen
			, rglv_path_info1, rglv_path_info2, rglv_path_info3, rglv_path_info4, rglv_path_info5, rglv_path_info6
			, rglv_etiq_info1, rglv_etiq_info2, rglv_etiq_info3, rglv_etiq_info4, rglv_etiq_info5, rglv_etiq_info6
			, rglv_path_cuant1, rglv_path_cuant2, rglv_path_cuant3, rglv_path_cuant4, rglv_path_cuant5, rglv_path_cuant6
			, rglv_etiq_cuant1, rglv_etiq_cuant2, rglv_etiq_cuant3, rglv_etiq_cuant4, rglv_etiq_cuant5, rglv_etiq_cuant6
		) VALUES (
			64001, 63002, '2013-01-01', NULL, 11, NULL, 'true', '0.5'
			, NULL, NULL, NULL, NULL
			, NULL, NULL, NULL, NULL, NULL, NULL
			, NULL, NULL, NULL, NULL, NULL, NULL
			, NULL, NULL, NULL, NULL, NULL, NULL
			, NULL, NULL, NULL, NULL, NULL, NULL
		)
		\
	INSERT INTO portico.tbl_regla_rgla (rgla_pk, rgla_crgo_pk, rgla_enti_pk, rgla_tipo, rgla_codigo) VALUES (63003, 60001, 22004, 'C', 'B2-C002');
	\
		INSERT INTO portico.tbl_regla_version_rglv (
			rglv_pk, rglv_rgla_pk, rglv_fini, rglv_ffin, rglv_orden, rglv_importe_base, rglv_condicion, rglv_formula
			, rglv_path_impuesto, rglv_path_pagador, rglv_path_es_suj_pasivo, rglv_path_cod_exen
			, rglv_path_info1, rglv_path_info2, rglv_path_info3, rglv_path_info4, rglv_path_info5, rglv_path_info6
			, rglv_etiq_info1, rglv_etiq_info2, rglv_etiq_info3, rglv_etiq_info4, rglv_etiq_info5, rglv_etiq_info6
			, rglv_path_cuant1, rglv_path_cuant2, rglv_path_cuant3, rglv_path_cuant4, rglv_path_cuant5, rglv_path_cuant6
			, rglv_etiq_cuant1, rglv_etiq_cuant2, rglv_etiq_cuant3, rglv_etiq_cuant4, rglv_etiq_cuant5, rglv_etiq_cuant6
		) VALUES (
			64002, 63003, '2013-01-01', NULL, 12, NULL, 'true', '1.5'
			, NULL, NULL, NULL, NULL
			, NULL, NULL, NULL, NULL, NULL, NULL
			, NULL, NULL, NULL, NULL, NULL, NULL
			, NULL, NULL, NULL, NULL, NULL, NULL
			, NULL, NULL, NULL, NULL, NULL, NULL
		)
		\
INSERT INTO portico.tbl_cargo_crgo (crgo_pk, crgo_codigo, crgo_codigo_norm, crgo_es_principal, crgo_es_temporal, crgo_tpsr_pk, crgo_tipo, crgo_descripcion)
	VALUES (60002, 'B3', 'B3', 1, 0, 21002, 'B', 'TASA A LA MERCANCIA')
\
	INSERT INTO portico.tbl_cargo_version_crgv (crgv_pk, crgv_crgo_pk, crgv_fini, crgv_ffin) VALUES (62002, 60002, '2013-01-01', NULL);
	\
	INSERT INTO portico.tbl_regla_rgla (rgla_pk, rgla_crgo_pk, rgla_enti_pk, rgla_tipo, rgla_codigo) VALUES (63100, 60002, 22004, 'T', 'B3-10-0000');
	\
	INSERT INTO portico.tbl_regla_rgla (rgla_pk, rgla_crgo_pk, rgla_enti_pk, rgla_tipo, rgla_codigo) VALUES (63101, 60002, 22005, 'T', 'B3-20-0000');
	\
INSERT INTO portico.tbl_cargo_crgo (crgo_pk, crgo_codigo, crgo_codigo_norm, crgo_es_principal, crgo_es_temporal, crgo_tpsr_pk, crgo_tipo, crgo_descripcion)
	VALUES (60003, 'B1', NULL, 1, 1, 21003, 'B', 'TASA AL BUQUE')
\
	INSERT INTO portico.tbl_cargo_version_crgv (crgv_pk, crgv_crgo_pk, crgv_fini, crgv_ffin) VALUES (62003, 60003, '2013-01-01', NULL);
	\
	INSERT INTO portico.tbl_regla_rgla (rgla_pk, rgla_crgo_pk, rgla_enti_pk, rgla_tipo, rgla_codigo) VALUES (63200, 60003, 22011, 'T', 'B1-10-0000');
	\
		INSERT INTO portico.tbl_regla_version_rglv (
			rglv_pk, rglv_rgla_pk, rglv_fini, rglv_ffin, rglv_orden, rglv_importe_base, rglv_condicion, rglv_formula
			, rglv_path_impuesto, rglv_path_pagador, rglv_path_es_suj_pasivo, rglv_path_cod_exen
			, rglv_path_info1, rglv_path_info2, rglv_path_info3, rglv_path_info4, rglv_path_info5, rglv_path_info6
			, rglv_etiq_info1, rglv_etiq_info2, rglv_etiq_info3, rglv_etiq_info4, rglv_etiq_info5, rglv_etiq_info6
			, rglv_path_cuant1, rglv_path_cuant2, rglv_path_cuant3, rglv_path_cuant4, rglv_path_cuant5, rglv_path_cuant6
			, rglv_etiq_cuant1, rglv_etiq_cuant2, rglv_etiq_cuant3, rglv_etiq_cuant4, rglv_etiq_cuant5, rglv_etiq_cuant6
		) VALUES (
			64200, 63200, '2013-01-01', NULL, 1, 2.95, 'true', '2.95 * dato(ENTERO_04) / 1000.0'
			, 'servicio.dato(TIPO_IVA)', 'dato(ORGA_2)', 'dato(BOOLEANO_01)', 'dato(COD_EXEN)'
			, NULL, NULL, NULL, NULL, NULL, NULL
			, NULL, NULL, NULL, NULL, NULL, NULL
			, NULL, NULL, NULL, NULL, NULL, NULL
			, NULL, NULL, NULL, NULL, NULL, NULL
		)
		\
	INSERT INTO portico.tbl_regla_rgla (rgla_pk, rgla_crgo_pk, rgla_enti_pk, rgla_tipo, rgla_codigo) VALUES (63201, 60003, 22011, 'T', 'B1-20-0000');
	\
	INSERT INTO portico.tbl_regla_rgla (rgla_pk, rgla_crgo_pk, rgla_enti_pk, rgla_tipo, rgla_codigo) VALUES (63202, 60003, 22011, 'C', 'B1-C001');
	\
		INSERT INTO portico.tbl_regla_version_rglv (
			rglv_pk, rglv_rgla_pk, rglv_fini, rglv_ffin, rglv_orden, rglv_importe_base, rglv_condicion, rglv_formula
			, rglv_path_impuesto, rglv_path_pagador, rglv_path_es_suj_pasivo, rglv_path_cod_exen
			, rglv_path_info1, rglv_path_info2, rglv_path_info3, rglv_path_info4, rglv_path_info5, rglv_path_info6
			, rglv_etiq_info1, rglv_etiq_info2, rglv_etiq_info3, rglv_etiq_info4, rglv_etiq_info5, rglv_etiq_info6
			, rglv_path_cuant1, rglv_path_cuant2, rglv_path_cuant3, rglv_path_cuant4, rglv_path_cuant5, rglv_path_cuant6
			, rglv_etiq_cuant1, rglv_etiq_cuant2, rglv_etiq_cuant3, rglv_etiq_cuant4, rglv_etiq_cuant5, rglv_etiq_cuant6
		) VALUES (
			64202, 63202, '2013-01-01', NULL, 1, NULL, 'true', '1'
			, NULL, NULL, NULL, NULL
			, NULL, NULL, NULL, NULL, NULL, NULL
			, NULL, NULL, NULL, NULL, NULL, NULL
			, NULL, NULL, NULL, NULL, NULL, NULL
			, NULL, NULL, NULL, NULL, NULL, NULL
		)
		\
INSERT INTO portico.tbl_cargo_crgo (crgo_pk, crgo_codigo, crgo_codigo_norm, crgo_es_principal, crgo_es_temporal, crgo_tpsr_pk, crgo_tipo, crgo_descripcion)
	VALUES (60004, 'B0', 'B0', 0, 0, 21003, 'B', 'TASA AL BUQUE 2')
\
	INSERT INTO portico.tbl_cargo_version_crgv (crgv_pk, crgv_crgo_pk, crgv_fini, crgv_ffin) VALUES (62004, 60004, '2013-01-01', NULL);
	\
	INSERT INTO portico.tbl_regla_rgla (rgla_pk, rgla_crgo_pk, rgla_enti_pk, rgla_tipo, rgla_codigo) VALUES (63300, 60004, 21003, 'T', 'B0-10-0000');
	\
		INSERT INTO portico.tbl_regla_version_rglv (
			rglv_pk, rglv_rgla_pk, rglv_fini, rglv_ffin, rglv_orden, rglv_importe_base, rglv_condicion, rglv_formula
			, rglv_path_impuesto, rglv_path_pagador, rglv_path_es_suj_pasivo, rglv_path_cod_exen
			, rglv_path_info1, rglv_path_info2, rglv_path_info3, rglv_path_info4, rglv_path_info5, rglv_path_info6
			, rglv_etiq_info1, rglv_etiq_info2, rglv_etiq_info3, rglv_etiq_info4, rglv_etiq_info5, rglv_etiq_info6
			, rglv_path_cuant1, rglv_path_cuant2, rglv_path_cuant3, rglv_path_cuant4, rglv_path_cuant5, rglv_path_cuant6
			, rglv_etiq_cuant1, rglv_etiq_cuant2, rglv_etiq_cuant3, rglv_etiq_cuant4, rglv_etiq_cuant5, rglv_etiq_cuant6
		) VALUES (
			64300, 63300, '2013-01-01', NULL, 1, 2.95, 'true', '2.95 * dato(ENTERO_04) / 1000.0'
			, 'dato(TIPO_IVA)', 'dato(ORGA_3)', 'dato(BOOLEANO_01)', 'dato(COD_EXEN)'
			, 'dato(BUQUE)', NULL, NULL, NULL, NULL, NULL
			, 'Buque', NULL, NULL, NULL, NULL, NULL
			, NULL, NULL, NULL, NULL, NULL, NULL
			, NULL, NULL, NULL, NULL, NULL, NULL
		)
		\
	INSERT INTO portico.tbl_regla_rgla (rgla_pk, rgla_crgo_pk, rgla_enti_pk, rgla_tipo, rgla_codigo) VALUES (63320, 60004, 21003, 'C', 'B0-C001');
	\
		INSERT INTO portico.tbl_regla_version_rglv (
			rglv_pk, rglv_rgla_pk, rglv_fini, rglv_ffin, rglv_orden, rglv_importe_base, rglv_condicion, rglv_formula
			, rglv_path_impuesto, rglv_path_pagador, rglv_path_es_suj_pasivo, rglv_path_cod_exen
			, rglv_path_info1, rglv_path_info2, rglv_path_info3, rglv_path_info4, rglv_path_info5, rglv_path_info6
			, rglv_etiq_info1, rglv_etiq_info2, rglv_etiq_info3, rglv_etiq_info4, rglv_etiq_info5, rglv_etiq_info6
			, rglv_path_cuant1, rglv_path_cuant2, rglv_path_cuant3, rglv_path_cuant4, rglv_path_cuant5, rglv_path_cuant6
			, rglv_etiq_cuant1, rglv_etiq_cuant2, rglv_etiq_cuant3, rglv_etiq_cuant4, rglv_etiq_cuant5, rglv_etiq_cuant6
		) VALUES (
			64320, 63320, '2013-01-01', NULL, 1, NULL, 'true', '1'
			, NULL, NULL, NULL, NULL
			, NULL, NULL, NULL, NULL, NULL, NULL
			, NULL, NULL, NULL, NULL, NULL, NULL
			, NULL, NULL, NULL, NULL, NULL, NULL
			, NULL, NULL, NULL, NULL, NULL, NULL
		)
		\
INSERT INTO portico.tbl_cargo_crgo (crgo_pk, crgo_codigo, crgo_codigo_norm, crgo_es_principal, crgo_es_temporal, crgo_tpsr_pk, crgo_tipo, crgo_descripcion)
	VALUES (60005, 'TR', 'TR', 1, 0, 21003, 'T', 'TARIFA DE RESIDUOS')
\
	INSERT INTO portico.tbl_cargo_version_crgv (crgv_pk, crgv_crgo_pk, crgv_fini, crgv_ffin) VALUES (62005, 60005, '2013-01-01', NULL);
	\
	INSERT INTO portico.tbl_regla_rgla (rgla_pk, rgla_crgo_pk, rgla_enti_pk, rgla_tipo, rgla_codigo) VALUES (63400, 60005, 21003, 'T', 'TR-10-0000');
	\
		INSERT INTO portico.tbl_regla_version_rglv (
			rglv_pk, rglv_rgla_pk, rglv_fini, rglv_ffin, rglv_orden, rglv_importe_base, rglv_condicion, rglv_formula
			, rglv_path_impuesto, rglv_path_pagador, rglv_path_es_suj_pasivo, rglv_path_cod_exen
			, rglv_path_info1, rglv_path_info2, rglv_path_info3, rglv_path_info4, rglv_path_info5, rglv_path_info6
			, rglv_etiq_info1, rglv_etiq_info2, rglv_etiq_info3, rglv_etiq_info4, rglv_etiq_info5, rglv_etiq_info6
			, rglv_path_cuant1, rglv_path_cuant2, rglv_path_cuant3, rglv_path_cuant4, rglv_path_cuant5, rglv_path_cuant6
			, rglv_etiq_cuant1, rglv_etiq_cuant2, rglv_etiq_cuant3, rglv_etiq_cuant4, rglv_etiq_cuant5, rglv_etiq_cuant6
		) VALUES (
			64400, 63400, '2013-01-01', NULL, 1, 2.95, 'true', '2.95 * dato(ENTERO_04) / 1000.0'
			, 'dato(TIPO_IVA)', 'dato(ORGA_3)', 'dato(BOOLEANO_01)', 'dato(COD_EXEN)'
			, 'dato(BUQUE)', NULL, NULL, NULL, NULL, NULL
			, 'Buque', NULL, NULL, NULL, NULL, NULL
			, NULL, NULL, NULL, NULL, NULL, NULL
			, NULL, NULL, NULL, NULL, NULL, NULL
		)
		\



INSERT INTO portico.tbl_cargo_dep_crdp (crdp_pk, crdp_crgop_pk, crdp_crgoh_pk) VALUES (65000, 60003, 60004)
\
	INSERT INTO portico.tbl_cargo_dep_version_crdv (crdv_pk, crdv_crdp_pk, crdv_fini, crdv_ffin) VALUES (66000, 65000, '2013-01-01', NULL)
	\



INSERT INTO portico.tbl_aspecto_aspc (aspc_pk, aspc_codigo, aspc_tpsr_pk, aspc_descripcion) VALUES (61000, 'B5', 21001, 'ASPECTO DE PESCA FRESCA')
\
	INSERT INTO portico.tbl_aspecto_version_aspv (aspv_pk, aspv_aspc_pk, aspv_fini, aspv_ffin, aspv_prioridad
		, aspv_cpath_info1, aspv_cpath_info2, aspv_cpath_info3, aspv_cpath_info4, aspv_cpath_info5, aspv_cpath_info6
		, aspv_cetiq_info1, aspv_cetiq_info2, aspv_cetiq_info3, aspv_cetiq_info4, aspv_cetiq_info5, aspv_cetiq_info6
		, aspv_cgrp_info1, aspv_cgrp_info2, aspv_cgrp_info3, aspv_cgrp_info4, aspv_cgrp_info5, aspv_cgrp_info6
		, aspv_lsum_cuant1, aspv_lsum_cuant2, aspv_lsum_cuant3, aspv_lsum_cuant4, aspv_lsum_cuant5, aspv_lsum_cuant6
		, aspv_lgrp_info1, aspv_lgrp_info2, aspv_lgrp_info3, aspv_lgrp_info4, aspv_lgrp_info5, aspv_lgrp_info6
	) VALUES (65000, 61000, '2013-01-01', NULL, 1
		, NULL, NULL, NULL, NULL, NULL, NULL
		, NULL, NULL, NULL, NULL, NULL, NULL
		, NULL, NULL, NULL, NULL, NULL, NULL
		, NULL, NULL, NULL, NULL, NULL, NULL
		, NULL, NULL, NULL, NULL, NULL, NULL
	)
	\
INSERT INTO portico.tbl_aspecto_aspc (aspc_pk, aspc_codigo, aspc_tpsr_pk, aspc_descripcion) VALUES (61001, 'B2', 21002, 'ASPECTO DE PASAJE')
\
	INSERT INTO portico.tbl_aspecto_version_aspv (aspv_pk, aspv_aspc_pk, aspv_fini, aspv_ffin, aspv_prioridad
		, aspv_cpath_info1, aspv_cpath_info2, aspv_cpath_info3, aspv_cpath_info4, aspv_cpath_info5, aspv_cpath_info6
		, aspv_cetiq_info1, aspv_cetiq_info2, aspv_cetiq_info3, aspv_cetiq_info4, aspv_cetiq_info5, aspv_cetiq_info6
		, aspv_cgrp_info1, aspv_cgrp_info2, aspv_cgrp_info3, aspv_cgrp_info4, aspv_cgrp_info5, aspv_cgrp_info6
		, aspv_lsum_cuant1, aspv_lsum_cuant2, aspv_lsum_cuant3, aspv_lsum_cuant4, aspv_lsum_cuant5, aspv_lsum_cuant6
		, aspv_lgrp_info1, aspv_lgrp_info2, aspv_lgrp_info3, aspv_lgrp_info4, aspv_lgrp_info5, aspv_lgrp_info6
	) VALUES (65001, 61001, '2013-01-01', NULL, 1
		, 'dato(ORGA_2)', 'dato(ALIN)', 'dato(ACUERDO)', NULL, NULL, NULL
		, 'Consignatario', 'Alineacion', 'Acuerdo', NULL, NULL, NULL
		, NULL, NULL, NULL, NULL, NULL, NULL
		, NULL, NULL, NULL, NULL, NULL, NULL
		, 1, NULL, NULL, NULL, NULL, NULL
	)
	\
		INSERT INTO portico.tbl_aspecto_cargo_ascr (ascr_aspv_pk, ascr_crgo_pk) VALUES (65001, 60001)
		\
INSERT INTO portico.tbl_aspecto_aspc (aspc_pk, aspc_codigo, aspc_tpsr_pk, aspc_descripcion) VALUES (61002, 'B3', 21002, 'ASPECTO DE MERCANCIA')
\
	INSERT INTO portico.tbl_aspecto_version_aspv (aspv_pk, aspv_aspc_pk, aspv_fini, aspv_ffin, aspv_prioridad
		, aspv_cpath_info1, aspv_cpath_info2, aspv_cpath_info3, aspv_cpath_info4, aspv_cpath_info5, aspv_cpath_info6
		, aspv_cetiq_info1, aspv_cetiq_info2, aspv_cetiq_info3, aspv_cetiq_info4, aspv_cetiq_info5, aspv_cetiq_info6
		, aspv_cgrp_info1, aspv_cgrp_info2, aspv_cgrp_info3, aspv_cgrp_info4, aspv_cgrp_info5, aspv_cgrp_info6
		, aspv_lsum_cuant1, aspv_lsum_cuant2, aspv_lsum_cuant3, aspv_lsum_cuant4, aspv_lsum_cuant5, aspv_lsum_cuant6
		, aspv_lgrp_info1, aspv_lgrp_info2, aspv_lgrp_info3, aspv_lgrp_info4, aspv_lgrp_info5, aspv_lgrp_info6
	) VALUES (65002, 61002, '2013-01-01', NULL, 2
		, 'dato(ORGA_2)', 'dato(ALIN)', 'dato(ACUERDO)', NULL, NULL, NULL
		, 'Consignatario', 'Alineacion', 'Acuerdo', NULL, NULL, NULL
		, NULL, NULL, NULL, NULL, NULL, NULL
		, NULL, NULL, NULL, NULL, NULL, NULL
		, 1, NULL, NULL, NULL, NULL, NULL
	)
	\
		INSERT INTO portico.tbl_aspecto_cargo_ascr (ascr_aspv_pk, ascr_crgo_pk) VALUES (65002, 60002)
		\
INSERT INTO portico.tbl_aspecto_aspc (aspc_pk, aspc_codigo, aspc_tpsr_pk, aspc_descripcion) VALUES (61003, 'B1', 21003, 'ASPECTO DE BUQUE')
\
	INSERT INTO portico.tbl_aspecto_version_aspv (aspv_pk, aspv_aspc_pk, aspv_fini, aspv_ffin, aspv_prioridad
		, aspv_cpath_info1, aspv_cpath_info2, aspv_cpath_info3, aspv_cpath_info4, aspv_cpath_info5, aspv_cpath_info6
		, aspv_cetiq_info1, aspv_cetiq_info2, aspv_cetiq_info3, aspv_cetiq_info4, aspv_cetiq_info5, aspv_cetiq_info6
		, aspv_cgrp_info1, aspv_cgrp_info2, aspv_cgrp_info3, aspv_cgrp_info4, aspv_cgrp_info5, aspv_cgrp_info6
		, aspv_lsum_cuant1, aspv_lsum_cuant2, aspv_lsum_cuant3, aspv_lsum_cuant4, aspv_lsum_cuant5, aspv_lsum_cuant6
		, aspv_lgrp_info1, aspv_lgrp_info2, aspv_lgrp_info3, aspv_lgrp_info4, aspv_lgrp_info5, aspv_lgrp_info6
	) VALUES (65003, 61003, '2013-01-01', NULL, 1 
		, NULL, NULL, NULL, NULL, NULL, NULL
		, NULL, NULL, NULL, NULL, NULL, NULL
		, NULL, NULL, NULL, NULL, NULL, NULL
		, NULL, NULL, NULL, NULL, NULL, NULL
		, NULL, NULL, NULL, NULL, NULL, NULL
	)
	\
		INSERT INTO portico.tbl_aspecto_cargo_ascr (ascr_aspv_pk, ascr_crgo_pk) VALUES (65003, 60003)
		\
		INSERT INTO portico.tbl_aspecto_cargo_ascr (ascr_aspv_pk, ascr_crgo_pk) VALUES (65003, 60004)
		\
INSERT INTO portico.tbl_aspecto_aspc (aspc_pk, aspc_codigo, aspc_tpsr_pk, aspc_descripcion) VALUES (61004, 'TR', 21003, 'ASPECTO DE RESIDUOS')
\
	INSERT INTO portico.tbl_aspecto_version_aspv (aspv_pk, aspv_aspc_pk, aspv_fini, aspv_ffin, aspv_prioridad
		, aspv_cpath_info1, aspv_cpath_info2, aspv_cpath_info3, aspv_cpath_info4, aspv_cpath_info5, aspv_cpath_info6
		, aspv_cetiq_info1, aspv_cetiq_info2, aspv_cetiq_info3, aspv_cetiq_info4, aspv_cetiq_info5, aspv_cetiq_info6
		, aspv_cgrp_info1, aspv_cgrp_info2, aspv_cgrp_info3, aspv_cgrp_info4, aspv_cgrp_info5, aspv_cgrp_info6
		, aspv_lsum_cuant1, aspv_lsum_cuant2, aspv_lsum_cuant3, aspv_lsum_cuant4, aspv_lsum_cuant5, aspv_lsum_cuant6
		, aspv_lgrp_info1, aspv_lgrp_info2, aspv_lgrp_info3, aspv_lgrp_info4, aspv_lgrp_info5, aspv_lgrp_info6
	) VALUES (65004, 61004, '2013-01-01', NULL, 2
		, NULL, NULL, NULL, NULL, NULL, NULL
		, NULL, NULL, NULL, NULL, NULL, NULL
		, NULL, NULL, NULL, NULL, NULL, NULL
		, NULL, NULL, NULL, NULL, NULL, NULL
		, NULL, NULL, NULL, NULL, NULL, NULL
	)
	\
		INSERT INTO portico.tbl_aspecto_cargo_ascr (ascr_aspv_pk, ascr_crgo_pk) VALUES (65004, 60005)
		\












-- //@UNDO
-- SQL to undo the change goes here.

DELETE FROM portico.tbl_valoracion_tmp_vlrt
\
DELETE FROM portico.tbl_valoracion_det_vlrd
\
DELETE FROM portico.tbl_valoracion_lin_vlrl
\
DELETE FROM portico.tbl_valoracion_cargo_vlrg
\
DELETE FROM portico.tbl_valoracion_imp_vlri
\
DELETE FROM portico.tbl_valoracion_vlrc
\

DELETE FROM portico.tbl_aspecto_cargo_ascr
WHERE EXISTS (
		SELECT 1
		FROM portico.tbl_aspecto_version_aspv 
		WHERE aspv_pk = ascr_aspv_pk
			AND EXISTS (
				SELECT 1 FROM portico.tbl_aspecto_aspc 
				WHERE 
					aspc_pk = aspv_aspc_pk
					AND aspc_pk IN (
						  61000
						, 61001
						, 61002
						, 61003
						, 61004
					)
			)
)
\

DELETE FROM portico.tbl_aspecto_version_aspv WHERE EXISTS (
	SELECT 1 FROM portico.tbl_aspecto_aspc 
	WHERE 
		aspc_pk = aspv_aspc_pk
		AND aspc_pk IN (
			  61000
			, 61001
			, 61002
			, 61003
			, 61004
		)
)
\

DELETE FROM portico.tbl_aspecto_aspc WHERE aspc_pk IN (
	  61000
	, 61001
	, 61002
	, 61003
	, 61004
)
\

DELETE FROM portico.tbl_regla_version_rglv WHERE EXISTS (
	SELECT 1
	FROM portico.tbl_regla_rgla
	WHERE
		rgla_pk = rglv_rgla_pk
		AND rgla_crgo_pk IN (
			  60000
			, 60001
			, 60002
			, 60003
			, 60004
			, 60005
		)
)
\

DELETE FROM portico.tbl_regla_rgla WHERE rgla_crgo_pk IN (
	  60000
	, 60001
	, 60002
	, 60003
	, 60004
	, 60005
)
\

DELETE FROM portico.tbl_cargo_dep_version_crdv
WHERE EXISTS (
	SELECT 1
	FROM
		portico.tbl_cargo_dep_crdp
	WHERE
		crdp_pk = crdv_crdp_pk
		AND crdp_crgop_pk IN (
			  60000
			, 60001
			, 60002
			, 60003
			, 60004
			, 60005
		)
)
\

DELETE FROM portico.tbl_cargo_dep_crdp WHERE crdp_crgop_pk IN (
	  60000
	, 60001
	, 60002
	, 60003
	, 60004
	, 60005
)
\

DELETE FROM portico.tbl_cargo_version_crgv WHERE crgv_crgo_pk IN (
	  60000
	, 60001
	, 60002
	, 60003
	, 60004
	, 60005
)
\

DELETE FROM portico.tbl_cargo_crgo WHERE crgo_pk IN (
	  60000
	, 60001
	, 60002
	, 60003
	, 60004
	, 60005
)
\
