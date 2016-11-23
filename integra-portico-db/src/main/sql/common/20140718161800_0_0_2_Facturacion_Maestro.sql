-- // 0 0 2 Facturacion Maestro
-- Migration SQL that makes the change goes here.


-- crgo y crgv - 100000
-- rgla y rglv - 120000
-- aspc y aspv - 140000
-- ascr y ascv - 160000


INSERT INTO tbl_cargo_crgo (crgo_pk,crgo_codigo,crgo_tpsr_pk) VALUES ('100000','B3','21002')\
	INSERT INTO tbl_cargo_version_crgv (crgv_pk,crgv_crgo_pk,crgv_fini,crgv_ffin,crgv_codigo_norm,crgv_es_principal,crgv_es_temporal,crgv_tipo)
	VALUES ('100001','100000',TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,'B3','1','0','B')\
    	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('crgv', 'es', 100001, 'TASA A LA MERCANCIA')\

	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES ('120000','100000','B3_001','22004','T')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES ('120001','120000',TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,1,2.95,'padre(BL).dato(TIPO_BL) = ''M''
		AND padre(BL).dato(BOOLEANO_02) = 0','2.95 * dato(ENTERO_04) / 1000','padre(BL).dato(TIPO_IVA)','padre(BL).padre(MANIFIESTO_CONSIGNATARIO).dato(ORGA)','padre(BL).dato(BOOLEANO_01)','padre(BL).dato(COD_EXEN)'
		,'padre(BL).dato(TIPO_BL)',null,null,null,null,null,'Tipo BL',null,null,null,null,null,'dato(ENTERO_04) / 1000',null,null,null,null,null,'Peso (Tm)',null,null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 120001, 'RDL 2/2011 Tasa Mercancï¿œa - Art.217')\

	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES ('120002','100000','B3_002','22005','T')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES (120003,120002,TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,2,2.95,'(
		    padre(BL).dato(TIPO_BL) = ''M''
		    AND padre(BL).dato(BOOLEANO_02) = 0
		)
		OR padre(BL).dato(TIPO_BL) = ''V''','2.95 * DECODE(dato(ENTERO_01), NULL, 1, 0, 1, dato(ENTERO_01))','padre(BL).dato(TIPO_IVA)','padre(BL).padre(MANIFIESTO_CONSIGNATARIO).dato(ORGA)','padre(BL).dato(BOOLEANO_01)','padre(BL).dato(COD_EXEN)'
		,'padre(BL).dato(TIPO_BL)','padre(BL).dato(TIPO_OP_BL)','padre(BL).dato(TIPO_TRANSPORTE)','dato(UNIDAD_CARGA)','dato(CADENA_02)',null,'Tipo BL','Tipo Op. BL','Tipo Transp.','U.C.','Ind. Lleno-Vacio',null,'DECODE(dato(ENTERO_01), NULL, 1, 0, 1, dato(ENTERO_01))',null,null,null,null,null,'Nº U.C.',null,null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 120003, 'RDL 2/2011 Tasa MercancÃ­a - Art.217')\

	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES (120004,100000,'B3_003',22004,'T')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES (120005,120004,TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,3,2.95,'padre(BL).dato(TIPO_BL) = ''M''
		AND padre(BL).dato(BOOLEANO_02) = 1
		AND dato(MERCANCIA).dato(BOOLEANO_01) = 1
		AND dato(UNIDAD_CARGA).dato(MERCANCIA) IS NULL','2.95 * dato(ENTERO_01)','padre(BL).dato(TIPO_IVA)','padre(BL).padre(MANIFIESTO_CONSIGNATARIO).dato(ORGA)','padre(BL).dato(BOOLEANO_01)','padre(BL).dato(COD_EXEN)','padre(BL).dato(TIPO_BL)',null,null,null,null,null,'Tipo BL',null,null,null,null,null,'dato(ENTERO_01)',null,null,null,null,null,'Nï¿œ Bultos',null,null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 120005, 'RDL 2/2011 Tasa MercancÃ­a - Art.217')\

	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES (120006,100000,'B3_004',22005,'T')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES (120007,120006,TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,4,2.95,'padre(BL).dato(TIPO_BL) = ''M''
		AND padre(BL).dato(BOOLEANO_02) = 1','2.95 * DECODE(dato(ENTERO_01), NULL, 1, 0, 1, dato(ENTERO_01))','padre(BL).dato(TIPO_IVA)','padre(BL).padre(MANIFIESTO_CONSIGNATARIO).dato(ORGA)','padre(BL).dato(BOOLEANO_01)','padre(BL).dato(COD_EXEN)','padre(BL).dato(TIPO_BL)','padre(BL).dato(TIPO_OP_BL)','padre(BL).dato(TIPO_TRANSPORTE)','dato(UNIDAD_CARGA)','dato(CADENA_02)',null,'Tipo BL','Tipo Op. BL','Tipo Transp.','U.C.','Ind. Lleno-Vacï¿œo',null,'DECODE(dato(ENTERO_01), NULL, 1, 0, 1, dato(ENTERO_01))',null,null,null,null,null,'Nï¿œ U.C.',null,null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 120007, 'RDL 2/2011 Tasa MercancÃ­a - Art.217')\

	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES (120008,100000,'B3_006',22005,'T')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES (120009,120008,TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,6,2.95,'padre(BL).dato(TIPO_BL) = ''M''
		AND padre(BL).dato(BOOLEANO_02) = 0
		AND dato(UNIDAD_CARGA) NOT IN (''31'', ''P3'', ''M-'', ''P1'', ''P2'', ''TA'', ''32'', ''33'', ''34'', ''P4'', ''M+'', ''P4'', ''TR'')','2.95 * dato(ENTERO_02) / 1000','padre(BL).dato(TIPO_IVA)','padre(BL).padre(MANIFIESTO_CONSIGNATARIO).dato(ORGA)','padre(BL).dato(BOOLEANO_01)','padre(BL).dato(COD_EXEN)','padre(BL).dato(TIPO_BL)','padre(BL).dato(TIPO_OP_BL)','padre(BL).dato(TIPO_TRANSPORTE)','dato(UNIDAD_CARGA)','dato(CADENA_02)',null,'Tipo BL','Tipo Op. BL','Tipo Transp.','U.C.','Ind. Lleno-Vacï¿œo',null,'dato(ENTERO_02) / 1000',null,null,null,null,null,'Tara (Tm)',null,null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 120009, 'RDL 2/2011 Tasa MercancÃ­a - Art.217')\


	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES ('120010','100000','B3_C01','22004','C')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES ('120011','120010',TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,'1',1.25,'1 = 1','1.25',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 120011, 'Art.166')\

	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES ('120012','100000','B3_C02','22005','C')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES ('120013','120012',TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,'2',1.25,'1 = 1','1.25',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 120013, 'Art.166')\

	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES ('120014','100000','B3_C03','22005','C')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES ('120015','120014',TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,'3',10,'dato(UNIDAD_CARGA) IN (''31'', ''P3'', ''M-'', ''P1'')
		AND (
		    padre(BL).dato(TIPO_OP_BL) IN (''E'', ''D'',''TE'',''TD'',''AA'',''CA'',''ET'',''DT'')
		    OR (
			padre(BL).dato(TIPO_OP_BL) = ''DT''
			AND padre(BL).dato(TIPO_TRANSPORTE) = ''MA''
		    )
		)
		AND dato(CADENA_02) IN (''7'', ''8'')','10',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 120015, 'Art.214.a.1.a/214.b/214.c/214.d/214.e')\

	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES ('120016','100000','B3_C04','22005','C')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES ('120017','120016',TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,'4','15','dato(UNIDAD_CARGA) IN (''32'', ''33'', ''34'', ''P4'', ''P2'', ''M+'')
		AND (
		    padre(BL).dato(TIPO_OP_BL) IN (''E'', ''D'',''TE'',''TD'',''AA'',''CA'',''ET'',''DT'')
		    OR (
			padre(BL).dato(TIPO_OP_BL) = ''DT''
			AND padre(BL).dato(TIPO_TRANSPORTE) = ''MA''
		    )
		)
		AND dato(CADENA_02) IN (''7'', ''8'')','15',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 120017, 'Art.214.a.1.b/214.b/214.c/214.d/214.e')\

	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES ('120018','100000','B3_C05','22005','C')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES (120019,120018,TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,'5','25','dato(UNIDAD_CARGA) IN (''TA'')
		AND (
		    padre(BL).dato(TIPO_OP_BL) IN (''E'', ''D'',''TE'',''TD'',''AA'',''CA'',''ET'',''DT'')
		    OR (
			padre(BL).dato(TIPO_OP_BL) = ''DT''
			AND padre(BL).dato(TIPO_TRANSPORTE) = ''MA''
		    )
		)
		AND dato(CADENA_02) IN (''7'', ''8'')','25',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 120019, 'Art.214.a.1.c/214.b/214.c/214.d/214.e')\

	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES ('120020','100000','B3_C06','22004','C')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES ('120021','120020',TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,'6',0.5,'(
		    padre(BL).dato(TIPO_OP_BL) IN (''E'', ''D'',''TE'',''TD'',''AA'',''CA'',''ET'',''DT'')
		    OR (
			padre(BL).dato(TIPO_OP_BL) = ''DT''
			AND padre(BL).dato(TIPO_TRANSPORTE) = ''MA''
		    )
		)
		AND dato(MERCANCIA) IN (''8702A'', ''8702B'', ''8703C'', ''8703D'')','0.5',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 120021, 'Art.214.a.1.d/214.b/214.c/214.d/214.e')\

	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES ('120022','100000','B3_C07','22004','C')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES ('120023','120022',TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,'7','2','(
		    padre(BL).dato(TERMINAL).dato(BOOLEANO_01) IS NULL
		    OR padre(BL).dato(TERMINAL).dato(BOOLEANO_01) = 0
		)
		AND (
		    padre(BL).dato(TIPO_OP_BL) IN (''E'', ''D'',''TE'',''TD'',''AA'',''CA'',''ET'',''DT'')
		    OR (
			padre(BL).dato(TIPO_OP_BL) = ''DT''
			AND padre(BL).dato(TIPO_TRANSPORTE) = ''MA''
		    )
		)
		AND dato(MERCANCIA) IN (''8703A'',''8703B'')','2',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 120023, 'Art.214.a.1.e/214.b/214.c/214.d/214.e')\

	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES ('120024','100000','B3_C08','22005','C')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES ('120025','120024',TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,'8',0.9,'dato(UNIDAD_CARGA) IN (''31'', ''P3'', ''M-'', ''P1'', ''P2'')
		AND (
		    padre(BL).dato(TIPO_OP_BL) IN (''E'', ''D'',''TE'',''TD'',''AA'',''CA'',''ET'',''DT'')
		    OR (
			padre(BL).dato(TIPO_OP_BL) = ''DT''
			AND padre(BL).dato(TIPO_TRANSPORTE) = ''MA''
		    )
		)
		AND (
		    dato(CADENA_02) = ''4''
		    OR padre(BL).dato(BOOLEANO_02) = 0
		)','0.90',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 120025, 'Art.214.a.2.2.a/214.b/214.c/214.d/214.e')\

	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES ('120026','100000','B3_C09','22005','C')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES ('120027','120026',TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,'9',1.8,'dato(UNIDAD_CARGA) IN (''32'', ''33'', ''34'', ''P4'', ''M+'', ''P4'')
		AND (
		    padre(BL).dato(TIPO_OP_BL) IN (''E'', ''D'',''TE'',''TD'',''AA'',''CA'',''ET'',''DT'')
		    OR (
			padre(BL).dato(TIPO_OP_BL) = ''DT''
			AND padre(BL).dato(TIPO_TRANSPORTE) = ''MA''
		    )
		)
		AND (
		    dato(CADENA_02) = ''4''
		    OR padre(BL).dato(BOOLEANO_02) = 0
		)','1.80',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 120027, 'Art.214.a.2.2.b/214.b/214.c/214.d/214.e')\

	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES ('120028','100000','B3_C10','22005','C')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES ('120029','120028',TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,'10',0.6,'dato(UNIDAD_CARGA) = ''TR''
		AND (
		    padre(BL).dato(TIPO_OP_BL) IN (''E'', ''D'',''TE'',''TD'',''AA'',''CA'',''ET'',''DT'')
		    OR (
			padre(BL).dato(TIPO_OP_BL) = ''DT''
			AND padre(BL).dato(TIPO_TRANSPORTE) = ''MA''
		    )
		)
		AND (
		    dato(CADENA_02) = ''4''
		    OR padre(BL).dato(BOOLEANO_02) = 0
		)','0.60',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 120029, 'Art.214.a.2.2.c/214.b/214.c/214.d/214.e')\

	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES ('120030','100000','B3_C11','22005','C')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES ('120031','120030',TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,'11',2.9,'dato(UNIDAD_CARGA) = ''TA''
		AND (
		    padre(BL).dato(TIPO_OP_BL) IN (''E'', ''D'',''TE'',''TD'',''AA'',''CA'',''ET'',''DT'')
		    OR (
			padre(BL).dato(TIPO_OP_BL) = ''DT''
			AND padre(BL).dato(TIPO_TRANSPORTE) = ''MA''
		    )
		)
		AND (
		    dato(CADENA_02) = ''4''
		    OR padre(BL).dato(BOOLEANO_02) = 0
		)','2.90',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 120031, 'Art.214.a.2.2.d/214.b/214.c/214.d/214.e')\

	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES ('120032','100000','B3_C12','22005','C')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES ('120033','120032',TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,'12',0.5,'dato(UNIDAD_CARGA) NOT IN (''31'', ''P3'', ''M-'', ''P1'', ''P2'', ''TA'', ''32'', ''33'', ''34'', ''P4'', ''M+'', ''P4'', ''TR'')
		AND (
		    padre(BL).dato(TIPO_OP_BL) IN (''E'', ''D'',''TE'',''TD'',''AA'',''CA'',''ET'',''DT'')
		    OR (
			padre(BL).dato(TIPO_OP_BL) = ''DT''
			AND padre(BL).dato(TIPO_TRANSPORTE) = ''MA''
		    )
		)
		AND (
		    dato(CADENA_02) = ''4''
		    OR padre(BL).dato(BOOLEANO_02) = 1
		)','0.50',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 120033, 'Art.214.a.2.2.e/214.b/214.c/214.d/214.e')\

	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES ('120034','100000','B3_C13','22004','C')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES ('120035','120034',TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,'13',0.16,'(
		    padre(BL).dato(TIPO_OP_BL) IN (''E'', ''D'',''TE'',''TD'',''AA'',''CA'',''ET'',''DT'')
		    OR (
			padre(BL).dato(TIPO_OP_BL) = ''DT''
			AND padre(BL).dato(TIPO_TRANSPORTE) = ''MA''
		    )
		)
		AND dato(MERCANCIA).dato(GRUPO_ARAN) = ''1''','0.16',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 120035, 'Art.214.a.2.1.G1/214.b/214.c/214.d/214.e')\

	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES ('120036','100000','B3_C14','22004','C')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES ('120037','120036',TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,'14',0.27,'(
		    padre(BL).dato(TIPO_OP_BL) IN (''E'', ''D'',''TE'',''TD'',''AA'',''CA'',''ET'',''DT'')
		    OR (
			padre(BL).dato(TIPO_OP_BL) = ''DT''
			AND padre(BL).dato(TIPO_TRANSPORTE) = ''MA''
		    )
		)
		AND dato(MERCANCIA).dato(GRUPO_ARAN) = ''2''','0.27',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 120037, 'Art.214.a.2.1.G2/214.b/214.c/214.d/214.e')\

	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES ('120038','100000','B3_C15','22004','C')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES ('120039','120038',TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,'15',0.43,'(
		    padre(BL).dato(TIPO_OP_BL) IN (''E'', ''D'',''TE'',''TD'',''AA'',''CA'',''ET'',''DT'')
		    OR (
			padre(BL).dato(TIPO_OP_BL) = ''DT''
			AND padre(BL).dato(TIPO_TRANSPORTE) = ''MA''
		    )
		)
		AND dato(MERCANCIA).dato(GRUPO_ARAN) = ''3''','0.43',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 120039, 'Art.214.a.2.1.G3/214.b/214.c/214.d/214.e')\

	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES ('120040','100000','B3_C16','22004','C')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES ('120041','120040',TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,'16',0.72,'(
		    padre(BL).dato(TIPO_OP_BL) IN (''E'', ''D'',''TE'',''TD'',''AA'',''CA'',''ET'',''DT'')
		    OR (
			padre(BL).dato(TIPO_OP_BL) = ''DT''
			AND padre(BL).dato(TIPO_TRANSPORTE) = ''MA''
		    )
		)
		AND dato(MERCANCIA).dato(GRUPO_ARAN) = ''4''','0.72',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 120041, 'Art.214.a.2.1.G4/214.b/214.c/214.d/214.e')\

	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES ('120042','100000','B3_C17','22004','C')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES ('120043','120042',TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,'17','1','(
		    padre(BL).dato(TIPO_OP_BL) IN (''E'', ''D'',''TE'',''TD'',''AA'',''CA'',''ET'',''DT'')
		    OR (
			padre(BL).dato(TIPO_OP_BL) = ''DT''
			AND padre(BL).dato(TIPO_TRANSPORTE) = ''MA''
		    )
		)
		AND dato(MERCANCIA).dato(GRUPO_ARAN) = ''5''','1',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 120043, 'Art.214.a.2.1.G5/214.b/214.c/214.d/214.e')\

	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES ('120044','100000','B3_B01','22005','D')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES ('120045','120044',TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,'1','100','padre(BL).dato(TIPO_OP_BL) = ''ET''
		AND padre(BL).dato(TIPO_TRANSPORTE) = ''MA''','100',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 120045, 'Art.214.b')\

	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES ('120046','100000','B3_B02','22004','D')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES ('120047','120046',TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,'2','100','padre(BL).dato(TIPO_OP_BL) = ''ET''
		AND padre(BL).dato(TIPO_TRANSPORTE) = ''MA''','100',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 120047, 'Art.214.a')\

	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES ('120048','100000','B3_B03','22005','D')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES ('120049','120048',TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,3,'100','padre(BL).dato(TIPO_OP_BL) = ''DT''
		AND padre(BL).dato(TIPO_TRANSPORTE) = ''MA''
		AND padre(BL).dato(TIPO_NAV) = ''CI''','100',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 120049, 'Art.214.b')\

	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES ('120050','100000','B3_B04','22004','D')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES ('120051','120050',TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,4,'100','padre(BL).dato(TIPO_OP_BL) = ''DT''
		AND padre(BL).dato(TIPO_TRANSPORTE) = ''MA''
		AND padre(BL).dato(TIPO_NAV) = ''CI''','100',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 120051, 'Art.214.b')\

	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES ('120052','100000','B3_B05','22004','D')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES ('120053','120052',TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,'5','50','padre(BL).dato(TIPO_OP_BL) IN (''TE'', ''TD'')
		AND servicio.dato(BOOLEANO_04) = 0','50',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 120053, 'Art.214.c.1')\

	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES ('120054','100000','B3_B06','22005','D')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES ('120055','120054',TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,6,'50','padre(BL).dato(TIPO_OP_BL) IN (''TE'', ''TD'')
		AND servicio.dato(BOOLEANO_04) = 0','50',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 120055, 'Art.214.c.1')\

	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES ('120056','100000','B3_B07','22004','D')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES ('120057','120056',TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,'7','30','padre(BL).dato(TIPO_OP_BL) IN (''TE'', ''TD'')
		AND servicio.dato(BOOLEANO_04) = 1','30',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 120057, 'Art.214.c.2')\

	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES ('120058','100000','B3_B08','22005','D')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES ('120059','120058',TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,'8','30','padre(BL).dato(TIPO_OP_BL) IN (''TE'', ''TD'')
		AND servicio.dato(BOOLEANO_04) = 1','30',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 120059, 'Art.214.c.2')\

	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES ('120060','100000','B3_B09','22004','D')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES ('120061','120060',TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,'9','100','padre(BL).dato(TIPO_OP_BL) IN (''D'', ''DT'')
		AND padre(BL).dato(TIPO_NAV) = ''I''','100',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 120061, 'Art.214.d')\

	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES ('120062','100000','B3_B10','22005','D')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES ('120063','120062',TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,10,'100','padre(BL).dato(TIPO_OP_BL) IN (''D'', ''DT'')
		AND padre(BL).dato(TIPO_NAV) = ''I''','100',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 120063, 'Art.214.d')\

	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES ('120064','100000','B3_B11','22004','D')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES ('120065','120064',TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,'11','50','padre(BL).dato(TIPO_OP_BL) IN (''CA'', ''AA'')','50',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 120065, 'Art.214.e')\

	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES ('120066','100000','B3_B12','22005','D')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES ('120067','120066',TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,12,'50','padre(BL).dato(TIPO_OP_BL) IN (''CA'', ''AA'')','50',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 120067, 'Art.214.e')\

	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES ('120068','100000','B3_B13','22004','D')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES ('120069','120068',TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,'13','50','padre(BL).dato(TERMINAL).dato(BOOLEANO_01) = 1
		AND padre(BL).dato(ALIN).dato(BOOLEANO_01) = 1
		AND padre(BL).dato(TIPO_OP_BL) IN (''E'', ''D'')','50',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 120069, 'Art.215.a.1')\

	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES ('120070','100000','B3_B14','22005','D')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES ('120071','120070',TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,'14','50','padre(BL).dato(TERMINAL).dato(BOOLEANO_01) = 1
		AND padre(BL).dato(ALIN).dato(BOOLEANO_01) = 1
		AND padre(BL).dato(TIPO_OP_BL) IN (''E'', ''D'')','50',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 120071, 'Art.215.a.1')\

	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES ('120072','100000','B3_B15','22004','D')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES ('120073','120072',TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,'15','75','padre(BL).dato(TERMINAL).dato(BOOLEANO_01) = 1
		AND padre(BL).dato(ALIN).dato(BOOLEANO_01) = 1
		AND padre(BL).dato(TIPO_OP_BL) IN (''DT'', ''ET'')
		AND padre(BL).dato(TIPO_TRANSPORTE) = ''MA''','75',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 120073, 'Art.215.a.2')\

	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES ('120074','100000','B3_B16','22005','D')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES ('120075','120074',TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,16,'75','padre(BL).dato(TERMINAL).dato(BOOLEANO_01) = 1
		AND padre(BL).dato(ALIN).dato(BOOLEANO_01) = 1
		AND padre(BL).dato(TIPO_OP_BL) IN (''DT'', ''ET'')
		AND padre(BL).dato(TIPO_TRANSPORTE) = ''MA''','75',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 120075, 'Art.215.a.2')\

	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES ('120076','100000','B3_B17','22004','D')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES ('120077','120076',TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,'17','20','padre(BL).dato(TERMINAL).dato(BOOLEANO_01) = 1
		AND padre(BL).dato(ALIN).dato(BOOLEANO_01) = 1
		AND padre(BL).dato(TIPO_OP_BL) IN (''TD'', ''TE'')','20',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 120077, 'Art.215.a.3')\

	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES ('120078','100000','B3_B18','22005','D')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES ('120079','120078',TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,18,'20','padre(BL).dato(TERMINAL).dato(BOOLEANO_01) = 1
		AND padre(BL).dato(ALIN).dato(BOOLEANO_01) = 1
		AND padre(BL).dato(TIPO_OP_BL) IN (''TD'', ''TE'')','20',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 120079, 'Art.215.a.3')\

	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES ('120080','100000','B3_B19','22004','D')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES ('120081','120080',TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,'19','50','padre(BL).dato(TERMINAL).dato(BOOLEANO_01) = 1
		AND padre(BL).dato(ALIN).dato(BOOLEANO_01) = 1
		AND padre(BL).dato(TIPO_OP_BL) IN (''E'', ''ET'')
		AND padre(BL).dato(TIPO_NAV) = ''I''','50',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 120081, 'Art.215.a.4')\

	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES ('120082','100000','B3_B20','22005','D')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES ('120083','120082',TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,20,'50','padre(BL).dato(TERMINAL).dato(BOOLEANO_01) = 1
		AND padre(BL).dato(ALIN).dato(BOOLEANO_01) = 1
		AND padre(BL).dato(TIPO_OP_BL) IN (''E'', ''ET'')
		AND padre(BL).dato(TIPO_NAV) = ''I''','50',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 120083, 'Art.215.a.4')\

	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES ('120084','100000','B3_B21','22004','D')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES ('120085','120084',TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,'21','20','padre(BL).dato(TERMINAL).dato(BOOLEANO_01) = 1
		AND padre(BL).dato(ALIN).dato(BOOLEANO_01) = 0','20',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 120085, 'Art.215.b')\

	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES ('120086','100000','B3_B22','22005','D')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES ('120087','120086',TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,'22','20','padre(BL).dato(TERMINAL).dato(BOOLEANO_01) = 1
		AND padre(BL).dato(ALIN).dato(BOOLEANO_01) = 0','20',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 120087, 'Art.215.b')\

	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES ('120088','100000','B3_B23','22004','D')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES ('120089','120088',TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,'23','60','padre(BL).dato(TERMINAL).dato(BOOLEANO_01) = 1
		AND padre(BL).dato(TIPO_OP_BL) IN (''AA'',''CA'')','60',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 120089, 'Art.215.c')\

	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES ('120090','100000','B3_B24','22005','D')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES ('120091','120090',TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,'24','60','padre(BL).dato(TERMINAL).dato(BOOLEANO_01) = 1
		AND padre(BL).dato(TIPO_OP_BL) IN (''AA'',''CA'')','60',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 120091, 'Art.215.c')\

	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES ('120092','100000','B3_B25','22004','D')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES ('120093','120092',TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,'25','75','padre(BL).dato(TIPO_OP_BL) IN (''ET'',''DT'')
		AND padre(BL).dato(TIPO_TRANSPORTE) = ''MA''','75',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 120093, 'Art.216.a')\

	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES ('120094','100000','B3_B26','22005','D')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES ('120095','120094',TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,'26','75','padre(BL).dato(TIPO_OP_BL) IN (''ET'',''DT'')
		AND padre(BL).dato(TIPO_TRANSPORTE) = ''MA''','75',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 120095, 'Art.216.a')\

	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES ('120096','100000','B3_B27','22004','D')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES ('120097','120096',TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,'27','20','padre(BL).dato(TIPO_OP_BL) IN (''E'',''D'')
		AND valorServicio(''TM'', padre(BL).dato(SERV_TRAF), servicio.atributo(PK)) = ''S''
		AND valorServicio(''RE'', padre(BL).dato(SERV_TRAF), servicio.atributo(PK)) = ''S''
		AND padre(BL).dato(UNLOCODE_5) IS NULL
		AND (
		    dato(BOOLEANO_02) IS NULL
		    OR dato(BOOLEANO_02) = 0
		)','20',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 120097, 'Art.216.b')\

	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES ('120098','100000','B3_B28','22005','D')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES ('120099','120098',TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,'28','20','padre(BL).dato(TIPO_OP_BL) IN (''E'',''D'')
		AND valorServicio(''TM'', padre(BL).dato(SERV_TRAF), servicio.atributo(PK)) = ''S''
		AND valorServicio(''RE'', padre(BL).dato(SERV_TRAF), servicio.atributo(PK)) = ''S''
		AND padre(BL).dato(UNLOCODE_5) IS NULL
		AND (
		    dato(BOOLEANO_01) IS NULL
		    OR dato(BOOLEANO_01) = 0
		)','20',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 120099, 'Art.216.b')\

	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES ('120100','100000','B3_B29','22004','D')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES ('120101','120100',TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,'29','40','padre(BL).dato(TIPO_OP_BL) IN (''E'',''D'')
		AND valorServicio(''TM'', padre(BL).dato(SERV_TRAF), servicio.atributo(PK)) = ''S''
		AND valorServicio(''RE'', padre(BL).dato(SERV_TRAF), servicio.atributo(PK)) = ''S''
		AND padre(BL).dato(UNLOCODE_5) IS NULL
		AND dato(BOOLEANO_02) = 1','40',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 120101, 'Art.216.b')\

	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES ('120102','100000','B3_B30','22005','D')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES ('120103','120102',TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,'30','40','padre(BL).dato(TIPO_OP_BL) IN (''E'',''D'')
		AND valorServicio(''TM'', padre(BL).dato(SERV_TRAF), servicio.atributo(PK)) = ''S''
		AND valorServicio(''RE'', padre(BL).dato(SERV_TRAF), servicio.atributo(PK)) = ''S''
		AND padre(BL).dato(UNLOCODE_5) IS NULL
		AND dato(BOOLEANO_01) = 1','40',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 120103, 'Art.216.b')\

	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES ('120104','100000','B3_B31','22004','D')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES ('120105','120104',TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,'31','80','padre(BL).dato(TIPO_OP_BL) IN (''E'',''D'')
		AND valorServicio(''II'', padre(BL).dato(SERV_TRAF), servicio.atributo(PK)) = ''S''','80',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 120105, 'Art.216.c')\

	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES ('120106','100000','B3_B32','22005','D')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES ('120107','120106',TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,'32','80','padre(BL).dato(TIPO_OP_BL) IN (''E'',''D'')
		AND valorServicio(''II'', padre(BL).dato(SERV_TRAF), servicio.atributo(PK)) = ''S''','80',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 120107, 'Art.216.c')\

	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES ('120108','100000','B3_B33','22004','D')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES ('120109','120108',TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,'33','25','padre(BL).dato(TIPO_OP_BL) IN (''E'',''D'')
		AND padre(BL).dato(TIPO_TRANSPORTE) = ''FE''','25',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 120109, 'Art.216.d')\

	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES ('120110','100000','B3_B34','22005','D')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES ('120111','120110',TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,'34','25','padre(BL).dato(TIPO_OP_BL) IN (''E'',''D'')
		AND padre(BL).dato(TIPO_TRANSPORTE) = ''FE''','25',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 120111, 'Art.216.d')\

	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES ('120112','100000','B3_B40','22004','D')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES ('120113','120112',TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,'40','40','padre(BL).dato(TIPO_OP_BL) IN (''E'',''D'')
		AND padre(BL).dato(TIPO_NAV) <> ''CI''
		AND valorServicio(''UP'', padre(BL).dato(SERV_TRAF), servicio.atributo(PK)) = ''S''','40',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 120113, 'Art.245.5')\

	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES ('120114','100000','B3_B41','22005','D')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES ('120115','120114',TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,'41','40','padre(BL).dato(TIPO_OP_BL) IN (''E'',''D'')
		AND padre(BL).dato(TIPO_NAV) <> ''CI''
		AND valorServicio(''UP'', padre(BL).dato(SERV_TRAF), servicio.atributo(PK)) = ''S''','40',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 120115, 'Art.245.5')\

	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES ('120116','100000','B3_B42','22004','D')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES ('120117','120116',TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,'42','40','padre(BL).dato(TIPO_OP_BL) IN (''E'',''D'',''ET'',''DT'')
		AND dato(TERMINAL) = ''P012''','40',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 120117, 'Art.245.4')\

	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES ('120118','100000','B3_B43','22005','D')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES ('120119','120118',TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,'43','40','padre(BL).dato(TIPO_OP_BL) IN (''E'',''D'',''ET'',''DT'')
		AND padre(BL).dato(TERMINAL) = ''P012''','40',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 120119, 'Art.245.4')\

	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES ('120120','100000','B3_B44','22004','D')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES ('120121','120120',TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,'44','35','dato(MERCANCIA) IN (''4801'',''4802'',''4804'',''4805'')
		AND dato(UNIDAD_CARGA) LIKE ''9%''','35',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 120121, 'Art.245.3')\

	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES ('120122','100000','B3_B48','22005','D')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES ('120123','120122',TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,'48','20','valorServicio(''RE'', padre(BL).dato(SERV_TRAF), servicio.atributo(PK)) = ''S''
		dato(CADENA_02) = ''4''
		AND servicio.dato(ESCALA).dato(BUQUE).dato(TIPO_BUQUE) = ''C''
		AND dato(UNIDAD_CARGA) LIKE ''3%''','20',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 120123, 'Art.245.3')\

	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES ('1519034','100000','B3_B83','22005','D')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES ('1519035','1519034',TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,'83','10','valorServicio(''RE'', padre(BL).dato(SERV_TRAF), servicio.atributo(PK)) = ''S''
		AND acumuladoTeus(
			   padre(BL).padre(MANIFIESTO_CONSIGNATARIO).dato(ORGA)
			   , CONCAT(''0101'', servicio.atributo(ANNO))
			   , servicio.atributo(FREF)
		       ) BETWEEN 1001 AND 20000
		AND dato(CADENA_02) IN (''7'', ''8'')
		AND dato(UNIDAD_CARGA) LIKE ''3%''','10',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 1519035, 'Art.245.3')\

	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES ('1519032','100000','B3_B84','22005','D')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES ('1519033','1519032',TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,'84','20','valorServicio(''RE'', padre(BL).dato(SERV_TRAF), servicio.atributo(PK)) = ''S''
		AND acumuladoTeus(
			   padre(BL).padre(MANIFIESTO_CONSIGNATARIO).dato(ORGA)
			   , CONCAT(''0101'', servicio.atributo(ANNO))
			   , servicio.atributo(FREF)
		       ) BETWEEN 20001 AND 50000
		AND dato(CADENA_02) IN (''7'', ''8'')
		AND dato(UNIDAD_CARGA) LIKE ''3%''','20',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 1519033, 'Art.245.3')\

	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES ('1519030','100000','B3_B85','22005','D')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES ('1519031','1519030',TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,'85','30','valorServicio(''RE'', padre(BL).dato(SERV_TRAF), servicio.atributo(PK)) = ''S''
		AND acumuladoTeus(
			   padre(BL).padre(MANIFIESTO_CONSIGNATARIO).dato(ORGA)
			   , CONCAT(''0101'', servicio.atributo(ANNO))
			   , servicio.atributo(FREF)
		       ) > 50000
		AND dato(CADENA_02) IN (''7'', ''8'')
		AND dato(UNIDAD_CARGA) LIKE ''3%''','30',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 1519031, 'Art.245.3')\

	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES ('1645004','100000','B3_B86','22004','D')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES ('1645005','1645004',TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,'86','10','dato(UNIDAD_CARGA) LIKE ''3%''
		AND valorServicio(''RE'', padre(BL).dato(SERV_TRAF), servicio.atributo(PK)) = ''S''
		AND acumuladoTeus(
			   padre(BL).padre(MANIFIESTO_CONSIGNATARIO).dato(ORGA)
			   , CONCAT(''0101'', servicio.atributo(ANNO))
			   , servicio.atributo(FREF)
		       ) BETWEEN 1001 AND 20000
		AND dato(BOOLEANO_02) = 0','10',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 1645005, 'Art.245.3')\

	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES ('1645006','100000','B3_B87','22004','D')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES ('1645007','1645006',TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,'87','20','dato(UNIDAD_CARGA) LIKE ''3%''
		AND valorServicio(''RE'', padre(BL).dato(SERV_TRAF), servicio.atributo(PK)) = ''S''
		AND acumuladoTeus(
			   padre(BL).padre(MANIFIESTO_CONSIGNATARIO).dato(ORGA)
			   , CONCAT(''0101'', servicio.atributo(ANNO))
			   , servicio.atributo(FREF)
		       ) BETWEEN 20001 AND 50000
		AND dato(BOOLEANO_02) = 0','20',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 1645007, 'Art.245.3')\

	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES ('1645008','100000','B3_B88','22004','D')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES ('1645009','1645008',TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,'88','30','dato(UNIDAD_CARGA) LIKE ''3%''
		AND valorServicio(''RE'', padre(BL).dato(SERV_TRAF), servicio.atributo(PK)) = ''S''
		AND acumuladoTeus(
			   padre(BL).padre(MANIFIESTO_CONSIGNATARIO).dato(ORGA)
			   , CONCAT(''0101'', servicio.atributo(ANNO))
			   , servicio.atributo(FREF)
		       ) > 50000
		AND dato(BOOLEANO_02) = 0','30',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 1645009, 'Art.245.3')\




INSERT INTO tbl_cargo_crgo (crgo_pk,crgo_codigo,crgo_tpsr_pk) VALUES ('100200','B2','21002')\
	INSERT INTO tbl_cargo_version_crgv (crgv_pk,crgv_crgo_pk,crgv_fini,crgv_ffin,crgv_codigo_norm,crgv_es_principal,crgv_es_temporal,crgv_tipo) VALUES ('62001','100200',TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,'B2','1','0','B')\
    	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('crgv', 'es', 62001, 'TASA AL PASAJE')\

	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES ('1645051','100200','B2_001','22004','T')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES ('1645052','1645051',TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,'1',3.23,'(padre(BL).dato(TIPO_BL) = ''P'' )
		AND dato(MERCANCIA) NOT IN (''0001D'', ''0001C'', ''0002C'')','3.23 * dato(ENTERO_03)','padre(BL).dato(TIPO_IVA)','padre(BL).padre(MANIFIESTO_CONSIGNATARIO).dato(ORGA)','padre(BL).dato(BOOLEANO_01)','padre(BL).dato(COD_EXEN)','padre(BL).dato(TIPO_BL)','dato(MERCANCIA)',null,null,null,null,'Tipo BL','Mercancï¿œa',null,null,null,null,'dato(ENTERO_03)',null,null,null,null,null,'Nï¿œ Pasajeros',null,null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 1645052, 'RDL 2/2011 Tasa Pasaje - Art.208')\

	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES ('1645053','100200','B2_002','22004','T')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES ('1645054','1645053',TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,'2',3.23,'(padre(BL).dato(TIPO_BL) = ''P'')
		AND dato(MERCANCIA) IN (''0001C'',''0002C'')','3.23 * dato(ENTERO_03) * COALESCE(servicio.dato(ENTERO_02), 1)','padre(BL).dato(TIPO_IVA)','padre(BL).padre(MANIFIESTO_CONSIGNATARIO).dato(ORGA)','padre(BL).dato(BOOLEANO_01)','padre(BL).dato(COD_EXEN)','padre(BL).dato(TIPO_BL)','dato(MERCANCIA)','servicio.dato(ENTERO_02)',null,null,null,'Tipo BL','Mercancia','Dï¿œas en Puerto',null,null,null,'dato(ENTERO_03)',null,null,null,null,null,'Nï¿œ Pasajeros',null,null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 1645054, 'RDL 2/2011 Tasa Pasaje - Art.208.a.1.4/5')\

	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES ('1645055','100200','B2_003','22004','T')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES ('1645056','1645055',TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,'3','0','padre(BL).dato(TIPO_BL) = ''P''
		AND dato(MERCANCIA) = ''0001D''','0','padre(BL).dato(TIPO_IVA)','padre(BL).padre(MANIFIESTO_CONSIGNATARIO).dato(ORGA)','padre(BL).dato(BOOLEANO_01)','padre(BL).dato(COD_EXEN)','padre(BL).dato(TIPO_BL)','dato(MERCANCIA)',null,null,null,null,'Tipo BL','Mercancï¿œa',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 1645056, 'RDL 2/2011 Tasa Pasaje - Art.208 - Conductores')\

	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES ('1645061','100200','B2_C01','22004','C')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES ('1645062','1645061',TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,'1',1.1,'1 = 1',1.1,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 1645062, 'Art.166')\

	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES ('1645105','100200','B2_C02','22004','C')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES ('1645106','1645105',TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,'2',0.75,'(
		    (
			padre(BL).dato(TIPO_OP_BL) = ''E''
			AND padre(BL).dato(UNLOCODE_3).dato(PAIS).dato(BOOLEANO_02) = 1
		    )
		    OR (
			padre(BL).dato(TIPO_OP_BL) = ''D''
			AND padre(BL).dato(UNLOCODE_2).dato(PAIS).dato(BOOLEANO_02) = 1
		    )
		)
		AND dato(MERCANCIA) = ''0001''
		AND padre(BL).dato(TIPO_NAV) <> ''I''','0.75',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 1645106, 'Art.208.a.1.1')\

	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES ('1645084','100200','B2_C03','22004','C')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES ('1645085','1645084',TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,'3','1','(
		    (
			padre(BL).dato(TIPO_OP_BL) = ''E''
			AND padre(BL).dato(UNLOCODE_3).dato(PAIS).dato(BOOLEANO_02) = 0
		    ) OR (
			padre(BL).dato(TIPO_OP_BL) = ''D''
			AND padre(BL).dato(UNLOCODE_2).dato(PAIS).dato(BOOLEANO_02) = 0
		    )
		)
		AND dato(MERCANCIA) = ''0001''
		AND padre(BL).dato(TIPO_NAV) <> ''I''','1',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 1645085, 'Art.208.a.1.2')\

	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES ('1645103','100200','B2_C04','22004','C')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES ('1645104','1645103',TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,'4',1.2,'padre(BL).dato(TIPO_OP_BL) IN (''E'', ''D'')
		AND dato(MERCANCIA) = ''0001X''
		AND padre(BL).dato(TIPO_NAV) <> ''I''','1.20',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 1645104, 'Art.208.a.1.3')\

	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES ('1645101','100200','B2_C05','22004','C')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES ('1645102','1645101',TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,'5',0.75,'padre(BL).dato(TIPO_OP_BL) IN (''E'', ''D'')
		AND dato(MERCANCIA) = ''0001X''
		AND padre(BL).dato(TIPO_NAV) <> ''I''
		AND servicio.dato(ENTERO_02) > 1','0.75',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 1645102, 'Art.208.a.1.4')\

	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES ('1645082','100200','B2_C06','22004','C')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES ('1645083','1645082',TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,'6',0.75,'padre(BL).dato(TIPO_OP_BL) IN (''ET'', ''DT'')
		AND dato(MERCANCIA) = ''0001C''
		AND padre(BL).dato(TIPO_NAV) <> ''I''','0.75',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 1645083, 'Art.208.a.1.5')\

	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES ('1645080','100200','B2_C07','22004','C')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES ('1645081','1645080',TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,'7',1.3,'padre(BL).dato(TIPO_OP_BL) IN (''E'', ''D'')
		AND dato(MERCANCIA) = ''0004''
		AND padre(BL).dato(TIPO_NAV) <> ''I''','1.30',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 1645081, 'Art.208.a.1.6')\

	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES ('1645099','100200','B2_C08','22004','C')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES ('1645100','1645099',TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,'8',2.9,'padre(BL).dato(TIPO_OP_BL) IN (''E'', ''D'')
		AND dato(MERCANCIA) = ''0005''
		AND padre(BL).dato(TIPO_NAV) <> ''I''','2.90',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 1645100, 'Art.208.a.1.7')\

	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES ('1645097','100200','B2_C09','22004','C')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES ('1645098','1645097',TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,'9',5.8,'padre(BL).dato(TIPO_OP_BL) IN (''E'', ''D'')
		AND dato(MERCANCIA) = ''0005L''
		AND padre(BL).dato(TIPO_NAV) <> ''I''','5.80',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 1645098, 'Art.208.a.1.8')\

	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES ('1645078','100200','B2_C10','22004','C')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES ('1645079','1645078',TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,'10',15.6,'padre(BL).dato(TIPO_OP_BL) IN (''E'', ''D'')
		AND dato(MERCANCIA) = ''0007''
		AND padre(BL).dato(TIPO_NAV) <> ''I''','15.60',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 1645079, 'Art.208.a.1.9')\

	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES ('1645091','100200','B2_C11','22004','C')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES ('1645092','1645091',TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,'11',0.02,'padre(BL).dato(ALIN).dato(BOOLEANO_01) = 0
		AND padre(BL).dato(TIPO_OP_BL) IN (''E'', ''D'')
		AND dato(MERCANCIA) IN (''0001'',''0002'')
		AND padre(BL).dato(TIPO_NAV) = ''I''
		AND servicio.dato(ESCALA).dato(SERV_TRAF) NOT IN (''C22'',''C04'')','0.02',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 1645092, 'Art.208.a.2.1')\

	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES ('1645095','100200','B2_C12','22004','C')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES ('1645096','1645095',TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,'12',0.4,'padre(BL).dato(ALIN).dato(BOOLEANO_01) = 0
		AND padre(BL).dato(TIPO_OP_BL) IN (''E'', ''D'')
		AND dato(MERCANCIA) = ''0004''
		AND padre(BL).dato(TIPO_NAV) = ''I''','0.40',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 1645096, 'Art.208.a.2.2')\

	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES ('1645076','100200','B2_C13','22004','C')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES ('1645077','1645076',TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,'13',0.9,'padre(BL).dato(ALIN).dato(BOOLEANO_01) = 0
		AND padre(BL).dato(TIPO_OP_BL) IN (''E'', ''D'')
		AND dato(MERCANCIA) = ''0005''
		AND padre(BL).dato(TIPO_NAV) = ''I''','0.90',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 1645077, 'Art.208.a.2.3')\

	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES ('1645074','100200','B2_C14','22004','C')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES ('1645075','1645074',TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,'14',1.8,'padre(BL).dato(ALIN).dato(BOOLEANO_01) = 0
		AND padre(BL).dato(TIPO_OP_BL) IN (''E'', ''D'')
		AND dato(MERCANCIA) = ''0005L''
		AND padre(BL).dato(TIPO_NAV) = ''I''','1.80',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 1645075, 'Art.208.a.2.4')\

	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES ('1645067','100200','B2_C15','22004','C')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES ('1645068','1645067',TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,'15','3','padre(BL).dato(ALIN).dato(BOOLEANO_01) = 0
		AND padre(BL).dato(TIPO_OP_BL) IN (''E'', ''D'')
		AND dato(MERCANCIA) = ''0007''
		AND padre(BL).dato(TIPO_NAV) = ''I''','3',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 1645068, 'Art.208.a.2.5')\

	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES ('1645093','100200','B2_C16','22004','C')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES ('1645094','1645093',TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,'16',0.2,'padre(BL).dato(ALIN).dato(BOOLEANO_01) = 0
		AND padre(BL).dato(TIPO_OP_BL) IN (''E'', ''D'')
		AND servicio.dato(ESCALA).dato(SERV_TRAF) = ''C22''','0.20',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 1645094, 'Art.208.a.3.1')\

	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES ('1645072','100200','B2_C17','22004','C')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES ('1645073','1645072',TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,'17',0.04,'padre(BL).dato(ALIN).dato(BOOLEANO_01) = 0
		AND padre(BL).dato(TIPO_OP_BL) IN (''E'', ''D'')
		AND servicio.dato(ESCALA).dato(SERV_TRAF) = ''C04''','0.04',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 1645073, 'Art.208.a.3.2')\

	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES ('1645069','100200','B2_C18','22004','C')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES ('1645070','1645069',TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,'18',0.5,'padre(BL).dato(TERMINAL).dato(BOOLEANO_01) = 1
		AND padre(BL).dato(ALIN).dato(BOOLEANO_01) = 1
		AND  padre(BL).dato(TIPO_NAV) <> ''I''
		AND (
			(
				(
					(
						padre(BL).dato(TIPO_OP_BL) = ''E''
						AND padre(BL).dato(UNLOCODE_3).dato(PAIS).dato(BOOLEANO_02) = 1
					) OR (
						padre(BL).dato(TIPO_OP_BL) = ''D''
						AND padre(BL).dato(UNLOCODE_2).dato(PAIS).dato(BOOLEANO_02) = 1
					)
				)
				AND dato(MERCANCIA) IN (''0001'')
			) OR (
				(
					(
						padre(BL).dato(TIPO_OP_BL) = ''E''
						AND padre(BL).dato(UNLOCODE_3).dato(PAIS).dato(BOOLEANO_02) = 0
					) OR (
						padre(BL).dato(TIPO_OP_BL) = ''D''
						AND padre(BL).dato(UNLOCODE_2).dato(PAIS).dato(BOOLEANO_02) = 0
					)
				)
				AND dato(MERCANCIA) IN (''0001'')
			) OR (
				padre(BL).dato(TIPO_OP_BL) IN (''E'', ''D'')
				AND dato(MERCANCIA) IN (''0001X'', ''0001C'', ''0004'', ''0005'', ''0005L'', ''0007'')
			) OR (
				dato(MERCANCIA) IN (''0001C'')
			)
		)','0.5',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 1645070, 'Art.208.b')\

	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES ('1645063','100200','B2_C34','22004','C')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES ('1645064','1645063',TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,'34',0.75,'padre(BL).dato(TERMINAL).dato(BOOLEANO_01) = 1
		AND padre(BL).dato(ALIN).dato(BOOLEANO_01) = 0
		AND padre(BL).dato(TIPO_NAV) <> ''I''
		AND (
		    (
			padre(BL).dato(TIPO_OP_BL) IN (''E'', ''D'')
			AND dato(MERCANCIA) IN (''0001'',''0002'')
			AND (
				(
				    padre(BL).dato(UNLOCODE_2).dato(PAIS).dato(BOOLEANO_02) = 1
				    AND padre(BL).dato(UNLOCODE_3).dato(PAIS).dato(BOOLEANO_02) = 1
				) OR (
				    padre(BL).dato(UNLOCODE_2).dato(PAIS).dato(BOOLEANO_02) = 0
				    AND padre(BL).dato(UNLOCODE_3).dato(PAIS).dato(BOOLEANO_02) = 0
				)
			)
		    )
		    OR (
			padre(BL).dato(TIPO_OP_BL) IN (''E'', ''D'')
			AND dato(MERCANCIA) IN (''0001'',''0002'', ''0001X'',''0002X'', ''0001C'',''0002C'', ''0004'', ''0005'', ''0005L'', ''0007'')
		    ) OR (
			dato(MERCANCIA) IN (''0001C'',''0002C'')
		    )
		)','0.75',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 1645064, 'Art.208.c')\

	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES ('1645086','100200','B2_C50','22004','C')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES ('1645087','1645086',TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,'50',0.8,'(
		    (
			padre(BL).dato(ALIN).dato(BOOLEANO_01) = 0
			AND padre(BL).dato(TIPO_NAV) <> ''I''
			AND (
			    dato(MERCANCIA) = ''0001C''
			    OR (
				padre(BL).dato(TIPO_OP_BL) IN (''E'', ''D'')
				AND (
				    dato(MERCANCIA) IN (''0001X'', ''0001C'', ''0004'', ''0005'', ''0005L'', ''0007'')
				    OR (
				        dato(MERCANCIA) = ''0001''
				        AND (
				            (
				                padre(BL).dato(UNLOCODE_2).dato(PAIS).dato(BOOLEANO_02) = 1
				                AND padre(BL).dato(UNLOCODE_3).dato(PAIS).dato(BOOLEANO_02) = 1
				            )
				            OR (
				                padre(BL).dato(UNLOCODE_2).dato(PAIS).dato(BOOLEANO_02) = 0
				                AND padre(BL).dato(UNLOCODE_3).dato(PAIS).dato(BOOLEANO_02) = 0
				            )
				        )
				    )
				)
			    )
			)
		    )
		    OR (
			padre(BL).dato(TERMINAL).dato(BOOLEANO_01) = 1
			AND padre(BL).dato(ALIN).dato(BOOLEANO_01) = 1
		    )
		    OR (
			padre(BL).dato(TERMINAL).dato(BOOLEANO_01) = 1
		    )
		)
		AND valorServicio(''RE'', padre(BL).dato(SERV_TRAF), servicio.atributo(PK)) = ''S''','0.80',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 1645087, 'Art.208.d')\

	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES ('1645089','100200','B2_C91','22004','C')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES ('1645090','1645089',TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,'91',0.2,'padre(BL).dato(TIPO_NAV) <> ''I''
		AND padre(BL).dato(ALIN).dato(BOOLEANO_01) = 0
		AND (
		    dato(MERCANCIA) IN (''0001C'',''0002C'')
		    OR (
			padre(BL).dato(TIPO_OP_BL) IN (''E'', ''D'')
			AND (
			    dato(MERCANCIA) IN (''0001X'',''0002X'',''0001C'',''0002C'',''0004'',''0005'',''0005L'',''0007'')
			    OR (
				dato(MERCANCIA) IN (''0001'',''0002'')
				AND (
				    (
				        padre(BL).dato(UNLOCODE_2).dato(PAIS).dato(BOOLEANO_02) = 1
				        AND padre(BL).dato(UNLOCODE_3).dato(PAIS).dato(BOOLEANO_02) = 1
				    )
				    OR (
				        padre(BL).dato(UNLOCODE_2).dato(PAIS).dato(BOOLEANO_02) = 0
				        AND padre(BL).dato(UNLOCODE_3).dato(PAIS).dato(BOOLEANO_02) = 0
				    )
				)
			    )
			)
		    )
		)
		AND valorServicio(''II'', padre(BL).dato(SERV_TRAF), servicio.atributo(PK)) = ''S''',0.2,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 1645090, 'Art.208.e')\

	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES ('1645112','100200','B2_B01','22004','D')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES ('1645113','1645112',TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,'1','40','dato(MERCANCIA) IN (''0001C'',''0001X'')','40',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 1645113, 'Art.245.3')\

	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES ('1645107','100200','B2_B02','22004','D')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES ('1645108','1645107',TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,'2','30','servicio.dato(DESC_ADIC) = ''0002''','30',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 1645108, 'Art.209')\















-- ====================== ESCALAS =========================
INSERT INTO tbl_cargo_crgo (crgo_pk,crgo_codigo,crgo_tpsr_pk) VALUES (100400,'B1',21003)\
	INSERT INTO tbl_cargo_version_crgv (crgv_pk,crgv_crgo_pk,crgv_fini,crgv_ffin,crgv_codigo_norm,crgv_es_principal,crgv_es_temporal,crgv_tipo)
	VALUES (100401,100400,TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,'B1',1,1,'B')\
    	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('crgv', 'es', 100401, 'TASA AL BUQUE')\

	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES (120400,100400,'B1_001',22011,'T')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES (120401,120400,TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,1,1.43,'dato(TIPO_ESTAN_ATR) = ''C''
AND (
	(
		valorServicio(''TM'', servicio.dato(SERV_TRAF), servicio.atributo(PK)) <> ''S''
		AND servicio.dato(BUQUE).dato(TIPO_BUQUE) NOT LIKE ''R%''
	)
	OR (
		dato(TIPO_ACT) IN (''DS'', ''VA'')
		AND esPrimerAtraque(atributo(PK)) = 1
	)
	OR servicio.dato(BUQUE).dato(TIPO_BUQUE) = ''UC''
)','1.43 * unidadesGtsAtraque(atributo(PK)) * periodosFacturablesAtraque(atributo(PK))','servicio.dato(TIPO_IVA)','dato(ORGA_2)','dato(BOOLEANO_01)','dato(COD_EXEN)'
		,'dato(TIPO_ESTAN_ATR)',null,null,null,null,null,'Tipo Estancia',null,null,null,null,null
		,'unidadesGtsAtraque(atributo(PK))','periodosFacturablesAtraque(atributo(PK))',null,null,null,null,'Unidades','Periodos',null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 120401, 'Cuantía básica B para estancias Cortas')\

	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES (120402,100400,'B1_002',22011,'T')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES (120403,120402,TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,2,1.2,'dato(TIPO_ESTAN_ATR) = ''C''
AND (
	(
		valorServicio(''TM'', servicio.dato(SERV_TRAF), servicio.atributo(PK)) = ''S''
		AND (
			dato(TIPO_ACT) NOT IN (''DS'', ''VA'')
			OR esPrimerAtraque(atributo(PK)) = 0
		)
		AND (
			servicio.dato(BUQUE).dato(TIPO_BUQUE) <> ''UC''
		)
	)
	OR servicio.dato(BUQUE).dato(TIPO_BUQUE) LIKE ''R%''
)', '1.2 * unidadesGtsAtraque(atributo(PK)) * periodosFacturablesAtraque(atributo(PK))','servicio.dato(TIPO_IVA)','dato(ORGA_2)','dato(BOOLEANO_01)','dato(COD_EXEN)'
		,'dato(TIPO_ESTAN_ATR)',null,null,null,null,null,'Tipo Estancia',null,null,null,null,null
		,'unidadesGtsAtraque(atributo(PK))','periodosFacturablesAtraque(atributo(PK))',null,null,null,null,'Unidades','Periodos',null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 120403, 'Cuantía básica S para estancias Cortas')\

	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES (120404,100400,'B1_003',22011,'T')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES (120405,120404,TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,3,1.43,'dato(TIPO_ESTAN_ATR) = ''L'''
		, '1.43 * unidadesGtsAtraque(atributo(PK)) * periodosFacturablesAtraque(atributo(PK))','servicio.dato(TIPO_IVA)','dato(ORGA_2)','dato(BOOLEANO_01)','dato(COD_EXEN)'
		,'dato(TIPO_ESTAN_ATR)',null,null,null,null,null,'Tipo Estancia',null,null,null,null,null
		,'unidadesGtsAtraque(atributo(PK))','periodosFacturablesAtraque(atributo(PK))',null,null,null,null,'Unidades','Periodos',null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 120405, 'Cuantía básica B para estancias Largas')\




	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES (120406,100400,'B1_C01',22011,'C')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES (120407,120406,TO_DATE('2013-01-01', 'yyyy-mm-dd'),null, 1, 1.2, '1 = 1', '1.2', null, null, null, null, null, null, null, null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 120407, 'Coef. Corrector de la A.P.')\

	INSERT INTO tbl_regla_rgla (rgla_pk,rgla_crgo_pk,rgla_codigo,rgla_enti_pk,rgla_tipo) VALUES (120408,100400,'B1_C02',22011,'C')\
		INSERT INTO tbl_regla_version_rglv (
			rglv_pk,rglv_rgla_pk,rglv_fini,rglv_ffin,rglv_orden,rglv_valor_base,rglv_condicion,rglv_formula,rglv_path_impuesto,rglv_path_pagador,rglv_path_es_suj_pasivo,rglv_path_cod_exen
			,rglv_path_info1,rglv_path_info2,rglv_path_info3,rglv_path_info4,rglv_path_info5,rglv_path_info6,rglv_etiq_info1,rglv_etiq_info2,rglv_etiq_info3,rglv_etiq_info4,rglv_etiq_info5,rglv_etiq_info6
			,rglv_path_cuant1,rglv_path_cuant2,rglv_path_cuant3,rglv_path_cuant4,rglv_path_cuant5,rglv_path_cuant6,rglv_etiq_cuant1,rglv_etiq_cuant2,rglv_etiq_cuant3,rglv_etiq_cuant4,rglv_etiq_cuant5,rglv_etiq_cuant6)
		VALUES (120409,120408,TO_DATE('2013-01-01', 'yyyy-mm-dd'),null, 2, 1,'dato(ALIN).dato(BOOLEANO_01) <> 1 AND dato(TIPO_ATR) = ''C''','1',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null)\
		INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('rglv', 'es', 120409, 'No Concesión - Atracados Costado')\
















INSERT INTO tbl_aspecto_aspc (aspc_pk,aspc_codigo,aspc_tpsr_pk) VALUES (140000, 'B2', 21002)\
	INSERT INTO tbl_aspecto_version_aspv (
		aspv_pk,aspv_aspc_pk,aspv_fini,aspv_ffin,aspv_prioridad
		,aspv_cpath_info1,aspv_cpath_info2,aspv_cpath_info3,aspv_cpath_info4,aspv_cpath_info5,aspv_cpath_info6
		,aspv_cetiq_info1,aspv_cetiq_info2,aspv_cetiq_info3,aspv_cetiq_info4,aspv_cetiq_info5,aspv_cetiq_info6
		,aspv_cgrp_info1,aspv_cgrp_info2,aspv_cgrp_info3,aspv_cgrp_info4,aspv_cgrp_info5,aspv_cgrp_info6
		,aspv_lsum_cuant1,aspv_lsum_cuant2,aspv_lsum_cuant3,aspv_lsum_cuant4,aspv_lsum_cuant5,aspv_lsum_cuant6
		,aspv_lgrp_info1,aspv_lgrp_info2,aspv_lgrp_info3,aspv_lgrp_info4,aspv_lgrp_info5,aspv_lgrp_info6)
	VALUES ('140001','140000',TO_DATE('2013-01-01', 'yyyy-mm-dd'),null,'1'
		,'dato(ORGA_2)','dato(ALIN)','dato(ACUERDO)',null,null,null,'Consignatario','Alineaciï¿œn','Acuerdo',null,null,null,'1','1','1',null,null,null,'1','1','1','1','1','1','1','1','1','1','1','1')\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('aspv', 'es', 140001, 'TASA AL PASAJE')\
	INSERT INTO tbl_aspecto_cargo_ascr (ascr_pk,ascr_aspc_pk,ascr_crgo_pk) VALUES ('66001','140000','100200')\
		INSERT INTO tbl_aspecto_cargo_version_ascv (ascv_pk,ascv_ascr_pk,ascv_fini,ascv_ffin) VALUES ('67001','66001',TO_DATE('2013-01-01', 'yyyy-mm-dd'),null)\

INSERT INTO tbl_aspecto_aspc (aspc_pk,aspc_codigo,aspc_tpsr_pk) VALUES (140002, 'B3', 21002)\
	INSERT INTO tbl_aspecto_version_aspv (
		aspv_pk,aspv_aspc_pk,aspv_fini,aspv_ffin,aspv_prioridad
		,aspv_cpath_info1,aspv_cpath_info2,aspv_cpath_info3,aspv_cpath_info4,aspv_cpath_info5,aspv_cpath_info6
		,aspv_cetiq_info1,aspv_cetiq_info2,aspv_cetiq_info3,aspv_cetiq_info4,aspv_cetiq_info5,aspv_cetiq_info6
		,aspv_cgrp_info1,aspv_cgrp_info2,aspv_cgrp_info3,aspv_cgrp_info4,aspv_cgrp_info5,aspv_cgrp_info6
		,aspv_lsum_cuant1,aspv_lsum_cuant2,aspv_lsum_cuant3,aspv_lsum_cuant4,aspv_lsum_cuant5,aspv_lsum_cuant6
		,aspv_lgrp_info1,aspv_lgrp_info2,aspv_lgrp_info3,aspv_lgrp_info4,aspv_lgrp_info5,aspv_lgrp_info6)
	VALUES (140003, 140002,TO_DATE('2013-01-01', 'yyyy-mm-dd'),null, 2
		,'dato(ORGA_2)','dato(ALIN)','dato(ACUERDO)',null,null,null
		,'Consignatario','Alineaciï¿œn','Acuerdo',null,null,null
		, 1, 1, 1, null, null, null
		, 1, 1, 1, 1, 1, 1
		, 1, 1, 1, 1, 1, 1)\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('aspv', 'es', 140003, 'TASA A LA MERCANCIA')\
	INSERT INTO tbl_aspecto_cargo_ascr (ascr_pk,ascr_aspc_pk,ascr_crgo_pk) VALUES (66002, 140002, 100200)\
	INSERT INTO tbl_aspecto_cargo_ascr (ascr_pk,ascr_aspc_pk,ascr_crgo_pk) VALUES (1075003, 140002, 100000)\
		INSERT INTO tbl_aspecto_cargo_version_ascv (ascv_pk,ascv_ascr_pk,ascv_fini,ascv_ffin) VALUES (1075004, 1075003, TO_DATE('2013-01-01', 'yyyy-mm-dd'),null)\

INSERT INTO tbl_aspecto_aspc (aspc_pk,aspc_codigo,aspc_tpsr_pk) VALUES (140004, 'B1', 21003)\
	INSERT INTO tbl_aspecto_version_aspv (
		aspv_pk,aspv_aspc_pk,aspv_fini,aspv_ffin,aspv_prioridad
		,aspv_cpath_info1,aspv_cpath_info2,aspv_cpath_info3,aspv_cpath_info4,aspv_cpath_info5,aspv_cpath_info6
		,aspv_cetiq_info1,aspv_cetiq_info2,aspv_cetiq_info3,aspv_cetiq_info4,aspv_cetiq_info5,aspv_cetiq_info6
		,aspv_cgrp_info1,aspv_cgrp_info2,aspv_cgrp_info3,aspv_cgrp_info4,aspv_cgrp_info5,aspv_cgrp_info6
		,aspv_lsum_cuant1,aspv_lsum_cuant2,aspv_lsum_cuant3,aspv_lsum_cuant4,aspv_lsum_cuant5,aspv_lsum_cuant6
		,aspv_lgrp_info1,aspv_lgrp_info2,aspv_lgrp_info3,aspv_lgrp_info4,aspv_lgrp_info5,aspv_lgrp_info6)
	VALUES (140005, 140004,TO_DATE('2013-01-01', 'yyyy-mm-dd'),null, 2
		,'dato(BUQUE)','dato(ORGA_3)','dato(TIPO_ESTAN_ESC)',null,null,null
		,'Buque','Consignatario','Tipo Estancia',null,null,null
		, 1, 1, 1, null, null, null
		, 0, 0, 0, 0, 0, 0
		, 0, 0, 0, 0, 0, 0)\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_lang, i18n_ext_pk, i18n_text) VALUES ('aspv', 'es', 140005, 'TASA AL BUQUE')\
	INSERT INTO tbl_aspecto_cargo_ascr (ascr_pk,ascr_aspc_pk,ascr_crgo_pk) VALUES (160400, 140004, 100400)\
		INSERT INTO tbl_aspecto_cargo_version_ascv (ascv_pk,ascv_ascr_pk,ascv_fini,ascv_ffin) VALUES (160401, 160400, TO_DATE('2013-01-01', 'yyyy-mm-dd'),null)\








-- //@UNDO
-- SQL to undo the change goes here.


BEGIN
	-- Aspectos
	eraseAspc(140000);
	eraseAspc(140002);
	eraseAspc(140004);

	-- Cargos
	eraseCrgo(100000);
	eraseCrgo(100200);
	eraseCrgo(100400);
END;
\
