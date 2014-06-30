-- Cargos
INSERT INTO tbl_cargo_crgo (crgo_pk, crgo_tpsr_pk, crgo_codigo, crgo_codigo_nrm) VALUES (1000, 21002, 'T2', 'T2');
INSERT INTO tbl_cargo_crgo (crgo_pk, crgo_tpsr_pk, crgo_codigo, crgo_codigo_nrm) VALUES (1001, 21002, 'T3', 'T3');
INSERT INTO tbl_cargo_crgo (crgo_pk, crgo_tpsr_pk, crgo_codigo, crgo_codigo_nrm) VALUES (1002, 21003, 'B1', 'B1');
INSERT INTO tbl_cargo_crgo (crgo_pk, crgo_tpsr_pk, crgo_codigo, crgo_codigo_nrm) VALUES (1003, 21003, 'B0', 'B0');
INSERT INTO tbl_cargo_crgo (crgo_pk, crgo_tpsr_pk, crgo_codigo, crgo_codigo_nrm) VALUES (1004, 21003, 'TR', 'TR');

INSERT INTO tbl_cargo_composicion_crcm (crcm_crgo_padre_pk, crcm_crgo_hijo_pk) VALUES (1002, 1003);

-- Procedimientos
INSERT INTO tbl_procedimiento_prcd (prcd_pk, prcd_crgo_pk, prcd_enti_pk, prcd_codigo, prcd_tipo) VALUES (2000, 1000, 22004, 'T2_00_00', 'T');
INSERT INTO tbl_procedimiento_prcd (prcd_pk, prcd_crgo_pk, prcd_enti_pk, prcd_codigo, prcd_tipo) VALUES (2001, 1000, 22004, 'T2_00_10', 'T');
INSERT INTO tbl_procedimiento_prcd (prcd_pk, prcd_crgo_pk, prcd_enti_pk, prcd_codigo, prcd_tipo) VALUES (2002, 1000, 22005, 'T2_10_00', 'T');
INSERT INTO tbl_procedimiento_prcd (prcd_pk, prcd_crgo_pk, prcd_enti_pk, prcd_codigo, prcd_tipo) VALUES (2003, 1000, 22005, 'T2_10_10', 'T');
INSERT INTO tbl_procedimiento_prcd (prcd_pk, prcd_crgo_pk, prcd_enti_pk, prcd_codigo, prcd_tipo) VALUES (2004, 1001, 22004, 'T3_00_00', 'T');
INSERT INTO tbl_procedimiento_prcd (prcd_pk, prcd_crgo_pk, prcd_enti_pk, prcd_codigo, prcd_tipo) VALUES (2005, 1001, 22004, 'T3_00_10', 'T');
INSERT INTO tbl_procedimiento_prcd (prcd_pk, prcd_crgo_pk, prcd_enti_pk, prcd_codigo, prcd_tipo) VALUES (2006, 1001, 22005, 'T3_10_00', 'T');
INSERT INTO tbl_procedimiento_prcd (prcd_pk, prcd_crgo_pk, prcd_enti_pk, prcd_codigo, prcd_tipo) VALUES (2007, 1001, 22005, 'T3_10_10', 'T');
INSERT INTO tbl_procedimiento_prcd (prcd_pk, prcd_crgo_pk, prcd_enti_pk, prcd_codigo, prcd_tipo) VALUES (2008, 1002, 22011, 'B1_10_00', 'T');
INSERT INTO tbl_procedimiento_prcd (prcd_pk, prcd_crgo_pk, prcd_enti_pk, prcd_codigo, prcd_tipo) VALUES (2009, 1002, 22011, 'B1_20_00', 'T');
INSERT INTO tbl_procedimiento_prcd (prcd_pk, prcd_crgo_pk, prcd_enti_pk, prcd_codigo, prcd_tipo) VALUES (2010, 1003, 21003, 'B0_10_00', 'T');
INSERT INTO tbl_procedimiento_prcd (prcd_pk, prcd_crgo_pk, prcd_enti_pk, prcd_codigo, prcd_tipo) VALUES (2011, 1003, 21003, 'B0_20_00', 'T');
INSERT INTO tbl_procedimiento_prcd (prcd_pk, prcd_crgo_pk, prcd_enti_pk, prcd_codigo, prcd_tipo) VALUES (2012, 1004, 21003, 'TR_10_00', 'T');
INSERT INTO tbl_procedimiento_prcd (prcd_pk, prcd_crgo_pk, prcd_enti_pk, prcd_codigo, prcd_tipo) VALUES (2013, 1004, 21003, 'TR_20_00', 'T');

-- Aspectos
INSERT INTO tbl_aspecto_aspc (aspc_pk, aspc_codigo) VALUES (3000, 'MAN_T2');
INSERT INTO tbl_aspecto_aspc (aspc_pk, aspc_codigo) VALUES (3001, 'MAN_T3');
INSERT INTO tbl_aspecto_aspc (aspc_pk, aspc_codigo) VALUES (3002, 'ESC_B1');
INSERT INTO tbl_aspecto_aspc (aspc_pk, aspc_codigo) VALUES (3003, 'ESC_TR');

INSERT INTO tbl_aspecto_cargo_ascr (ascr_aspc_pk, ascr_crgo_pk) VALUES (3000, 1000);
INSERT INTO tbl_aspecto_cargo_ascr (ascr_aspc_pk, ascr_crgo_pk) VALUES (3001, 1001);
INSERT INTO tbl_aspecto_cargo_ascr (ascr_aspc_pk, ascr_crgo_pk) VALUES (3002, 1002);
INSERT INTO tbl_aspecto_cargo_ascr (ascr_aspc_pk, ascr_crgo_pk) VALUES (3002, 1003);
INSERT INTO tbl_aspecto_cargo_ascr (ascr_aspc_pk, ascr_crgo_pk) VALUES (3003, 1004);




SELECT * 
FROM tbl_aspecto_aspc  
	JOIN tbl_aspecto_cargo_ascr ON
		ascr_aspc_pk = aspc_pk
	JOIN tbl_cargo_crgo ON
		crgo_pk = ascr_crgo_pk
;


SELECT * 
FROM tbl_tipo_servicio_tpsr 
	JOIN tbl_entidad_enti ON
		enti_pk = tpsr_pk
;

SELECT * 
FROM tbl_tipo_subservicio_tpss  
	JOIN tbl_entidad_enti ON
		enti_pk = tpss_pk
;
