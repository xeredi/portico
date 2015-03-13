-- // 0 0 2 Facturacion
-- Migration SQL that makes the change goes here.

-- tbl_cargo_crgo
CREATE TABLE tbl_cargo_crgo (
	crgo_pk NUMBER(19) NOT NULL
	, crgo_codigo VARCHAR2(15) NOT NULL
	, crgo_tpsr_pk NUMBER(19) NOT NULL

	, CONSTRAINT pk_crgo PRIMARY KEY (crgo_pk)
	, CONSTRAINT uq_crgo UNIQUE (crgo_tpsr_pk, crgo_codigo)

	, CONSTRAINT fk_crgo_tpsr_pk FOREIGN KEY (crgo_tpsr_pk)
		REFERENCES tbl_tipo_servicio_tpsr (tpsr_pk)
)\

CREATE OR REPLACE SYNONYM portico.tbl_cargo_crgo FOR porticoadm.tbl_cargo_crgo\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_cargo_crgo TO portico\

COMMENT ON TABLE tbl_cargo_crgo IS 'Maestro de Tasas-Tarifas'\
COMMENT ON COLUMN tbl_cargo_crgo.crgo_pk IS 'Identificador de Tasa-Tarifa'\
COMMENT ON COLUMN tbl_cargo_crgo.crgo_codigo IS 'Codigo de Tasa-Tarifa'\
COMMENT ON COLUMN tbl_cargo_crgo.crgo_tpsr_pk IS 'Identificador de Modulo al que pertenece la Tasa-Tarifa'\



-- tbl_cargo_version_crgv
CREATE TABLE tbl_cargo_version_crgv (
	crgv_pk NUMBER(19) NOT NULL
	, crgv_crgo_pk NUMBER(19) NOT NULL
	, crgv_fini TIMESTAMP NOT NULL
	, crgv_ffin TIMESTAMP
	, crgv_codigo_norm VARCHAR2(15)
	, crgv_es_principal INT NOT NULL
	, crgv_es_temporal INT NOT NULL
	, crgv_tipo VARCHAR2(1) NOT NULL

	, CONSTRAINT pk_crgv PRIMARY KEY (crgv_pk)

	, CONSTRAINT fk_crgv_crgo_pk FOREIGN KEY (crgv_crgo_pk)
		REFERENCES tbl_cargo_crgo (crgo_pk)
)\

CREATE OR REPLACE SYNONYM portico.tbl_cargo_version_crgv FOR porticoadm.tbl_cargo_version_crgv\

CREATE INDEX ix_crgv_crgo_pk ON tbl_cargo_version_crgv (crgv_crgo_pk)\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_cargo_version_crgv TO portico\



-- tbl_cargo_dep_crdp
CREATE TABLE tbl_cargo_dep_crdp (
	crdp_pk NUMBER(19) NOT NULL
	, crdp_crgop_pk NUMBER(19) NOT NULL
	, crdp_crgoh_pk NUMBER(19) NOT NULL

	, CONSTRAINT pk_crdp PRIMARY KEY (crdp_pk)
	, CONSTRAINT uq_crdp UNIQUE (crdp_crgop_pk, crdp_crgoh_pk)

	, CONSTRAINT fk_crdp_crgop_pk FOREIGN KEY (crdp_crgop_pk)
		REFERENCES tbl_cargo_crgo (crgo_pk)
	, CONSTRAINT fk_crdp_crgoh_pk FOREIGN KEY (crdp_crgoh_pk)
		REFERENCES tbl_cargo_crgo (crgo_pk)
)\

CREATE OR REPLACE SYNONYM portico.tbl_cargo_dep_crdp FOR porticoadm.tbl_cargo_dep_crdp\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_cargo_dep_crdp TO portico\



-- tbl_cargo_dep_version_crdv
CREATE TABLE tbl_cargo_dep_version_crdv (
	crdv_pk NUMBER(19) NOT NULL
	, crdv_crdp_pk NUMBER(19) NOT NULL
	, crdv_fini TIMESTAMP NOT NULL
	, crdv_ffin TIMESTAMP

	, CONSTRAINT pk_crdv PRIMARY KEY (crdv_pk)

	, CONSTRAINT fk_crdv_crdp_pk FOREIGN KEY (crdv_crdp_pk)
		REFERENCES tbl_cargo_dep_crdp (crdp_pk)
)\

CREATE OR REPLACE SYNONYM portico.tbl_cargo_dep_version_crdv FOR porticoadm.tbl_cargo_dep_version_crdv\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_cargo_dep_version_crdv TO portico\



-- tbl_regla_rgla
CREATE TABLE tbl_regla_rgla (
	rgla_pk NUMBER(19) NOT NULL
	, rgla_crgo_pk NUMBER(19) NOT NULL
	, rgla_codigo VARCHAR2(20) NOT NULL
	, rgla_enti_pk NUMBER(19) NOT NULL
	, rgla_tipo VARCHAR2(1) NOT NULL

	, CONSTRAINT pk_rgla PRIMARY KEY (rgla_pk)
	, CONSTRAINT uq_rgla UNIQUE (rgla_crgo_pk, rgla_codigo)

	, CONSTRAINT fk_rgla_crgo_pk FOREIGN KEY (rgla_crgo_pk)
		REFERENCES tbl_cargo_crgo (crgo_pk)
	, CONSTRAINT fk_rgla_enti_pk FOREIGN KEY (rgla_enti_pk)
		REFERENCES tbl_entidad_enti (enti_pk)
)\

CREATE OR REPLACE SYNONYM portico.tbl_regla_rgla FOR porticoadm.tbl_regla_rgla\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_regla_rgla TO portico\



-- tbl_regla_version_rglv
CREATE TABLE tbl_regla_version_rglv (
	rglv_pk NUMBER(19) NOT NULL
	, rglv_rgla_pk NUMBER(19) NOT NULL
	, rglv_fini TIMESTAMP NOT NULL
	, rglv_ffin TIMESTAMP
	, rglv_orden INT NOT NULL
	, rglv_importe_base NUMERIC(10, 4)
	, rglv_condicion VARCHAR2(2000) NOT NULL
	, rglv_formula VARCHAR2(2000) NOT NULL

	, rglv_path_impuesto VARCHAR2(250)
	, rglv_path_pagador VARCHAR2(250)
	, rglv_path_es_suj_pasivo VARCHAR2(250)
	, rglv_path_cod_exen VARCHAR2(250)

	, rglv_path_info1 VARCHAR2(250)
	, rglv_path_info2 VARCHAR2(250)
	, rglv_path_info3 VARCHAR2(250)
	, rglv_path_info4 VARCHAR2(250)
	, rglv_path_info5 VARCHAR2(250)
	, rglv_path_info6 VARCHAR2(250)

	, rglv_etiq_info1 VARCHAR2(50)
	, rglv_etiq_info2 VARCHAR2(50)
	, rglv_etiq_info3 VARCHAR2(50)
	, rglv_etiq_info4 VARCHAR2(50)
	, rglv_etiq_info5 VARCHAR2(50)
	, rglv_etiq_info6 VARCHAR2(50)

	, rglv_path_cuant1 VARCHAR2(250)
	, rglv_path_cuant2 VARCHAR2(250)
	, rglv_path_cuant3 VARCHAR2(250)
	, rglv_path_cuant4 VARCHAR2(250)
	, rglv_path_cuant5 VARCHAR2(250)
	, rglv_path_cuant6 VARCHAR2(250)

	, rglv_etiq_cuant1 VARCHAR2(50)
	, rglv_etiq_cuant2 VARCHAR2(50)
	, rglv_etiq_cuant3 VARCHAR2(50)
	, rglv_etiq_cuant4 VARCHAR2(50)
	, rglv_etiq_cuant5 VARCHAR2(50)
	, rglv_etiq_cuant6 VARCHAR2(50)

	, CONSTRAINT pk_rglv PRIMARY KEY (rglv_pk)

	, CONSTRAINT fk_rglv_rgla_pk FOREIGN KEY (rglv_rgla_pk)
		REFERENCES tbl_regla_rgla (rgla_pk)
)\

CREATE OR REPLACE SYNONYM portico.tbl_regla_version_rglv FOR porticoadm.tbl_regla_version_rglv\

CREATE INDEX ix_rglv_rgla_pk ON tbl_regla_version_rglv (rglv_rgla_pk)\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_regla_version_rglv TO portico\



-- tbl_regla_inc_rgin
CREATE TABLE tbl_regla_inc_rgin (
	rgin_pk NUMBER(19) NOT NULL
	, rgin_rgla1_pk NUMBER(19) NOT NULL
	, rgin_rgla2_pk NUMBER(19) NOT NULL

	, CONSTRAINT pk_rgin PRIMARY KEY (rgin_pk)
	, CONSTRAINT uq_rgin UNIQUE (rgin_rgla1_pk, rgin_rgla2_pk)

	, CONSTRAINT fk_rgin_rgla1_pk FOREIGN KEY (rgin_rgla1_pk)
		REFERENCES tbl_regla_rgla (rgla_pk)
	, CONSTRAINT fk_rgin_rgla2_pk FOREIGN KEY (rgin_rgla2_pk)
		REFERENCES tbl_regla_rgla (rgla_pk)
)\

CREATE OR REPLACE SYNONYM portico.tbl_regla_inc_rgin FOR porticoadm.tbl_regla_inc_rgin\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_regla_inc_rgin TO portico\



-- tbl_regla_inc_version_rgiv
CREATE TABLE tbl_regla_inc_version_rgiv (
	rgiv_pk NUMBER(19) NOT NULL
	, rgiv_rgin_pk NUMBER(19) NOT NULL
	, rgiv_fini TIMESTAMP NOT NULL
	, rgiv_ffin TIMESTAMP

	, CONSTRAINT pk_rgiv PRIMARY KEY (rgiv_pk)

	, CONSTRAINT fk_rgiv_rgin_pk FOREIGN KEY (rgiv_rgin_pk)
		REFERENCES tbl_regla_inc_rgin (rgin_pk)
)\

CREATE OR REPLACE SYNONYM portico.tbl_regla_inc_version_rgiv FOR porticoadm.tbl_regla_inc_version_rgiv\

CREATE INDEX ix_rgiv_rgin_pk ON tbl_regla_inc_version_rgiv (rgiv_rgin_pk)\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_regla_inc_version_rgiv TO portico\



-- tbl_aspecto_aspc
CREATE TABLE tbl_aspecto_aspc (
	aspc_pk NUMBER(19) NOT NULL
	, aspc_codigo VARCHAR2(10) NOT NULL
	, aspc_tpsr_pk NUMBER(19) NOT NULL

	, CONSTRAINT pk_aspc PRIMARY KEY (aspc_pk)
	, CONSTRAINT uq_aspc UNIQUE (aspc_tpsr_pk, aspc_codigo)

	, CONSTRAINT fk_aspc_tpsr_pk FOREIGN KEY (aspc_tpsr_pk)
		REFERENCES tbl_tipo_servicio_tpsr (tpsr_pk)
)\

CREATE OR REPLACE SYNONYM portico.tbl_aspecto_aspc FOR porticoadm.tbl_aspecto_aspc\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_aspecto_aspc TO portico\



-- tbl_aspecto_version_aspv
CREATE TABLE tbl_aspecto_version_aspv (
	aspv_pk NUMBER(19) NOT NULL
	, aspv_aspc_pk NUMBER(19) NOT NULL
	, aspv_fini TIMESTAMP NOT NULL
	, aspv_ffin TIMESTAMP
	, aspv_prioridad INT NOT NULL

	, aspv_cpath_info1 VARCHAR2(250)
	, aspv_cpath_info2 VARCHAR2(250)
	, aspv_cpath_info3 VARCHAR2(250)
	, aspv_cpath_info4 VARCHAR2(250)
	, aspv_cpath_info5 VARCHAR2(250)
	, aspv_cpath_info6 VARCHAR2(250)

	, aspv_cetiq_info1 VARCHAR2(50)
	, aspv_cetiq_info2 VARCHAR2(50)
	, aspv_cetiq_info3 VARCHAR2(50)
	, aspv_cetiq_info4 VARCHAR2(50)
	, aspv_cetiq_info5 VARCHAR2(50)
	, aspv_cetiq_info6 VARCHAR2(50)

	, aspv_cgrp_info1 INT
	, aspv_cgrp_info2 INT
	, aspv_cgrp_info3 INT
	, aspv_cgrp_info4 INT
	, aspv_cgrp_info5 INT
	, aspv_cgrp_info6 INT

	, aspv_lsum_cuant1 INT
	, aspv_lsum_cuant2 INT
	, aspv_lsum_cuant3 INT
	, aspv_lsum_cuant4 INT
	, aspv_lsum_cuant5 INT
	, aspv_lsum_cuant6 INT

	, aspv_lgrp_info1 INT
	, aspv_lgrp_info2 INT
	, aspv_lgrp_info3 INT
	, aspv_lgrp_info4 INT
	, aspv_lgrp_info5 INT
	, aspv_lgrp_info6 INT

	, CONSTRAINT pk_aspv PRIMARY KEY (aspv_pk)

	, CONSTRAINT fk_aspv_aspc_pk FOREIGN KEY (aspv_aspc_pk)
		REFERENCES tbl_aspecto_aspc (aspc_pk)
)\

CREATE OR REPLACE SYNONYM portico.tbl_aspecto_version_aspv FOR porticoadm.tbl_aspecto_version_aspv\

CREATE INDEX ix_aspv_aspc_pk ON tbl_aspecto_version_aspv (aspv_aspc_pk)\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_aspecto_version_aspv TO portico\



-- tbl_aspecto_cargo_ascr
CREATE TABLE tbl_aspecto_cargo_ascr (
	ascr_pk NUMBER(19) NOT NULL
	, ascr_aspc_pk NUMBER(19) NOT NULL
	, ascr_crgo_pk NUMBER(19) NOT NULL

	, CONSTRAINT pk_ascr PRIMARY KEY (ascr_pk)
	, CONSTRAINT uq_ascr UNIQUE (ascr_aspc_pk, ascr_crgo_pk)

	, CONSTRAINT fk_ascr_aspc_pk FOREIGN KEY (ascr_aspc_pk)
		REFERENCES tbl_aspecto_aspc (aspc_pk)
	, CONSTRAINT fk_ascr_crgo_pk FOREIGN KEY (ascr_crgo_pk)
		REFERENCES tbl_cargo_crgo (crgo_pk)
)\

CREATE OR REPLACE SYNONYM portico.tbl_aspecto_cargo_ascr FOR porticoadm.tbl_aspecto_cargo_ascr\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_aspecto_cargo_ascr TO portico\



CREATE TABLE tbl_aspecto_cargo_version_ascv (
	ascv_pk NUMBER(19) NOT NULL
	, ascv_ascr_pk NUMBER(19) NOT NULL
	, ascv_fini TIMESTAMP NOT NULL
	, ascv_ffin TIMESTAMP

	, CONSTRAINT pk_ascv PRIMARY KEY (ascv_pk)

	, CONSTRAINT fk_ascv_ascr_pk FOREIGN KEY (ascv_ascr_pk)
		REFERENCES tbl_aspecto_cargo_ascr (ascr_pk)
)\

CREATE OR REPLACE SYNONYM portico.tbl_aspecto_cargo_version_ascv FOR porticoadm.tbl_aspecto_cargo_version_ascv\

CREATE INDEX ix_ascv_ascr_pk ON tbl_aspecto_cargo_version_ascv (ascv_ascr_pk)\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_aspecto_cargo_version_ascv TO portico\



-- tbl_factura_serie_fcsr
CREATE TABLE tbl_factura_serie_fcsr (
	fcsr_pk NUMBER(19) NOT NULL
	, fcsr_serie CHAR(1) NOT NULL
	, fcsr_anio INT NOT NULL
	, fcsr_numero_ultimo INT NOT NULL

	, CONSTRAINT pk_fcsr PRIMARY KEY (fcsr_pk)
	, CONSTRAINT uq_fcsr UNIQUE (fcsr_serie, fcsr_anio)
)\

CREATE OR REPLACE SYNONYM portico.tbl_factura_serie_fcsr FOR porticoadm.tbl_factura_serie_fcsr\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_factura_serie_fcsr TO portico\



-- tbl_valoracion_vlrc
CREATE TABLE tbl_valoracion_vlrc (
	vlrc_pk NUMBER(19) NOT NULL
	, vlrc_srvc_pk NUMBER(19) NOT NULL
	, vlrc_aspc_pk NUMBER(19) NOT NULL
	, vlrc_pagador_prmt_pk NUMBER(19) NOT NULL
	, vlrc_fref TIMESTAMP NOT NULL
	, vlrc_fliq TIMESTAMP NOT NULL
	, vlrc_falta TIMESTAMP NOT NULL
	, vlrc_fini TIMESTAMP
	, vlrc_ffin TIMESTAMP
	, vlrc_es_suj_pasivo INT NOT NULL
	, vlrc_cod_exen CHAR(1) NOT NULL

	, vlrc_info1 VARCHAR2(100)
	, vlrc_info2 VARCHAR2(100)
	, vlrc_info3 VARCHAR2(100)
	, vlrc_info4 VARCHAR2(100)
	, vlrc_info5 VARCHAR2(100)
	, vlrc_info6 VARCHAR2(100)

	, CONSTRAINT pk_vlrc PRIMARY KEY (vlrc_pk)

	, CONSTRAINT fk_vlrc_srvc_pk FOREIGN KEY (vlrc_srvc_pk)
		REFERENCES tbl_servicio_srvc (srvc_pk)
	, CONSTRAINT fk_vlrc_aspc_pk FOREIGN KEY (vlrc_aspc_pk)
		REFERENCES tbl_aspecto_aspc (aspc_pk)
	, CONSTRAINT fk_vlrc_pagador_prmt_pk FOREIGN KEY (vlrc_pagador_prmt_pk)
		REFERENCES tbl_parametro_prmt (prmt_pk)
)\

CREATE OR REPLACE SYNONYM portico.tbl_valoracion_vlrc FOR porticoadm.tbl_valoracion_vlrc\

CREATE INDEX ix_vlrc_srvc_pk ON tbl_valoracion_vlrc (vlrc_srvc_pk)\
CREATE INDEX ix_vlrc_pagador_prmt_pk ON tbl_valoracion_vlrc (vlrc_pagador_prmt_pk)\
CREATE INDEX ix_vlrc_aspc_pk ON tbl_valoracion_vlrc (vlrc_aspc_pk)\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_valoracion_vlrc TO portico\



-- tbl_valoracion_lin_vlrl
CREATE TABLE tbl_valoracion_lin_vlrl (
	vlrl_pk NUMBER(19) NOT NULL
	, vlrl_padre_pk NUMBER(19) NOT NULL
	, vlrl_vlrc_pk NUMBER(19) NOT NULL
	, vlrl_rgla_pk NUMBER(19) NOT NULL
	, vlrl_impuesto_prmt_pk NUMBER(19) NOT NULL
	, vlrl_ssrv_pk NUMBER(19)
	, vlrl_fini TIMESTAMP
	, vlrl_ffin TIMESTAMP

	, vlrl_cuant1 DOUBLE PRECISION
	, vlrl_cuant2 DOUBLE PRECISION
	, vlrl_cuant3 DOUBLE PRECISION
	, vlrl_cuant4 DOUBLE PRECISION
	, vlrl_cuant5 DOUBLE PRECISION
	, vlrl_cuant6 DOUBLE PRECISION

	, vlrl_info1 VARCHAR2(100)
	, vlrl_info2 VARCHAR2(100)
	, vlrl_info3 VARCHAR2(100)
	, vlrl_info4 VARCHAR2(100)
	, vlrl_info5 VARCHAR2(100)
	, vlrl_info6 VARCHAR2(100)

	, CONSTRAINT pk_vlrl PRIMARY KEY (vlrl_pk)

	, CONSTRAINT fk_vlrl_vlrc_pk FOREIGN KEY (vlrl_vlrc_pk)
		REFERENCES tbl_valoracion_vlrc (vlrc_pk)
	, CONSTRAINT fk_vlrl_padre_pk FOREIGN KEY (vlrl_padre_pk)
		REFERENCES tbl_valoracion_lin_vlrl (vlrl_pk)
	, CONSTRAINT fk_vlrl_rgla_pk FOREIGN KEY (vlrl_rgla_pk)
		REFERENCES tbl_regla_rgla (rgla_pk)
	, CONSTRAINT fk_vlrl_impuesto_prmt_pk FOREIGN KEY (vlrl_impuesto_prmt_pk)
		REFERENCES tbl_parametro_prmt (prmt_pk)
	, CONSTRAINT fk_vlrl_ssrv_pk FOREIGN KEY (vlrl_ssrv_pk)
		REFERENCES tbl_subservicio_ssrv (ssrv_pk)
)\

CREATE OR REPLACE SYNONYM portico.tbl_valoracion_lin_vlrl FOR porticoadm.tbl_valoracion_lin_vlrl\

CREATE INDEX ix_vlrl_vlrc_pk ON tbl_valoracion_lin_vlrl (vlrl_vlrc_pk)\
CREATE INDEX ix_vlrl_padre_pk ON tbl_valoracion_lin_vlrl (vlrl_padre_pk)\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_valoracion_lin_vlrl TO portico\



-- tbl_valoracion_det_vlrd
CREATE TABLE tbl_valoracion_det_vlrd (
	vlrd_pk NUMBER(19) NOT NULL
	, vlrd_vlrc_pk NUMBER(19) NOT NULL
	, vlrd_vlrl_pk NUMBER(19) NOT NULL
	, vlrd_valor_base NUMERIC(10, 4) NOT NULL
	, vlrd_importe_base NUMERIC(10, 2) NOT NULL
	, vlrd_importe NUMERIC(10, 2) NOT NULL
	, vlrd_ssrv_pk NUMBER(19)
	, vlrd_fini TIMESTAMP
	, vlrd_ffin TIMESTAMP

	, vlrd_cuant1 DOUBLE PRECISION
	, vlrd_cuant2 DOUBLE PRECISION
	, vlrd_cuant3 DOUBLE PRECISION
	, vlrd_cuant4 DOUBLE PRECISION
	, vlrd_cuant5 DOUBLE PRECISION
	, vlrd_cuant6 DOUBLE PRECISION

	, vlrd_info1 VARCHAR2(100)
	, vlrd_info2 VARCHAR2(100)
	, vlrd_info3 VARCHAR2(100)
	, vlrd_info4 VARCHAR2(100)
	, vlrd_info5 VARCHAR2(100)
	, vlrd_info6 VARCHAR2(100)

	, CONSTRAINT pk_vlrd PRIMARY KEY (vlrd_pk)

	, CONSTRAINT fk_vlrd_vlrc_pk FOREIGN KEY (vlrd_vlrc_pk)
		REFERENCES tbl_valoracion_vlrc (vlrc_pk)
	, CONSTRAINT fk_vlrd_vlrl_pk FOREIGN KEY (vlrd_vlrl_pk)
		REFERENCES tbl_valoracion_lin_vlrl (vlrl_pk)
	, CONSTRAINT fk_vlrd_ssrv_pk FOREIGN KEY (vlrd_ssrv_pk)
		REFERENCES tbl_subservicio_ssrv (ssrv_pk)
)\

CREATE OR REPLACE SYNONYM portico.tbl_valoracion_det_vlrd FOR porticoadm.tbl_valoracion_det_vlrd\

CREATE INDEX ix_vlrd_vlrc_pk ON tbl_valoracion_det_vlrd (vlrd_vlrc_pk)\
CREATE INDEX ix_vlrd_vlrl_pk ON tbl_valoracion_det_vlrd (vlrd_vlrl_pk)\
CREATE INDEX ix_vlrd_ssrv_pk ON tbl_valoracion_det_vlrd (vlrd_ssrv_pk)\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_valoracion_det_vlrd TO portico\



-- tbl_valoracion_tmp_vlrt
CREATE TABLE tbl_valoracion_tmp_vlrt (
	vlrt_pk NUMBER(19) NOT NULL
	, vlrt_padre_pk NUMBER(19) NOT NULL
	, vlrt_prbt_pk NUMBER(19) NOT NULL
	, vlrt_srvc_pk NUMBER(19) NOT NULL
	, vlrt_ssrv_pk NUMBER(19)
	, vlrt_crgo_pk NUMBER(19) NOT NULL
	, vlrt_rgla_pk NUMBER(19) NOT NULL
	, vlrt_rgla_tipo CHAR(1) NOT NULL
	, vlrt_impuesto_prmt_pk NUMBER(19) NOT NULL
	, vlrt_pagador_prmt_pk NUMBER(19) NOT NULL
	, vlrt_valor_base NUMERIC(10, 4) NOT NULL
	, vlrt_orden INT
	, vlrt_importe_base NUMERIC(10, 2) NOT NULL
	, vlrt_importe NUMERIC(10, 2) NOT NULL
	, vlrt_es_suj_pasivo INT NOT NULL
	, vlrt_cod_exen CHAR(1) NOT NULL
	, vlrt_fref TIMESTAMP NOT NULL
	, vlrt_fliq TIMESTAMP NOT NULL
	, vlrt_fini TIMESTAMP
	, vlrt_ffin TIMESTAMP

	, vlrt_cuant1 DOUBLE PRECISION
	, vlrt_cuant2 DOUBLE PRECISION
	, vlrt_cuant3 DOUBLE PRECISION
	, vlrt_cuant4 DOUBLE PRECISION
	, vlrt_cuant5 DOUBLE PRECISION
	, vlrt_cuant6 DOUBLE PRECISION

	, vlrt_info1 VARCHAR2(100)
	, vlrt_info2 VARCHAR2(100)
	, vlrt_info3 VARCHAR2(100)
	, vlrt_info4 VARCHAR2(100)
	, vlrt_info5 VARCHAR2(100)
	, vlrt_info6 VARCHAR2(100)

	, CONSTRAINT pk_vlrt PRIMARY KEY (vlrt_pk)

	, CONSTRAINT fk_vlrt_padre_pk FOREIGN KEY (vlrt_padre_pk)
		REFERENCES tbl_valoracion_tmp_vlrt (vlrt_pk)
	, CONSTRAINT fk_vlrt_prbt_pk FOREIGN KEY (vlrt_prbt_pk)
		REFERENCES tbl_proceso_batch_prbt (prbt_pk)
	, CONSTRAINT fk_vlrt_srvc_pk FOREIGN KEY (vlrt_srvc_pk)
		REFERENCES tbl_servicio_srvc (srvc_pk)
	, CONSTRAINT fk_vlrt_ssrv_pk FOREIGN KEY (vlrt_ssrv_pk)
		REFERENCES tbl_subservicio_ssrv (ssrv_pk)
	, CONSTRAINT fk_vlrt_crgo_pk FOREIGN KEY (vlrt_crgo_pk)
		REFERENCES tbl_cargo_crgo (crgo_pk)
	, CONSTRAINT fk_vlrt_rgla_pk FOREIGN KEY (vlrt_rgla_pk)
		REFERENCES tbl_regla_rgla (rgla_pk)
	, CONSTRAINT fk_vlrt_impuesto_prmt_pk FOREIGN KEY (vlrt_impuesto_prmt_pk)
		REFERENCES tbl_parametro_prmt (prmt_pk)
	, CONSTRAINT fk_vlrt_pagador_prmt_pk FOREIGN KEY (vlrt_pagador_prmt_pk)
		REFERENCES tbl_parametro_prmt (prmt_pk)
)\

CREATE OR REPLACE SYNONYM portico.tbl_valoracion_tmp_vlrt FOR porticoadm.tbl_valoracion_tmp_vlrt\

CREATE INDEX ix_vlrt ON tbl_valoracion_tmp_vlrt (
	vlrt_prbt_pk, vlrt_srvc_pk, vlrt_ssrv_pk, vlrt_crgo_pk, vlrt_rgla_tipo)\
CREATE INDEX ix_vlrt_padre_pk ON tbl_valoracion_tmp_vlrt (vlrt_padre_pk)\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_valoracion_tmp_vlrt TO portico\



-- tbl_factura_fctr
CREATE TABLE tbl_factura_fctr (
	fctr_pk NUMBER(19) NOT NULL
	, fctr_aspc_pk NUMBER(19) NOT NULL
	, fctr_pagador_prmt_pk NUMBER(19) NOT NULL
	, fctr_fcsr_pk NUMBER(19) NOT NULL
	, fctr_numero INT NOT NULL
	, fctr_fref TIMESTAMP NOT NULL
	, fctr_falta TIMESTAMP NOT NULL
	, fctr_fini TIMESTAMP
	, fctr_ffin TIMESTAMP
	, fctr_estado CHAR(2) NOT NULL
	, fctr_es_suj_pasivo INT NOT NULL
	, fctr_info1 VARCHAR2(100)
	, fctr_info2 VARCHAR2(100)
	, fctr_info3 VARCHAR2(100)
	, fctr_info4 VARCHAR2(100)
	, fctr_info5 VARCHAR2(100)
	, fctr_info6 VARCHAR2(100)

	, CONSTRAINT pk_fctr PRIMARY KEY (fctr_pk)

	, CONSTRAINT fk_fctr_aspc_pk FOREIGN KEY (fctr_aspc_pk)
		REFERENCES tbl_aspecto_aspc (aspc_pk)
	, CONSTRAINT fk_fctr_pagador_prmt_pk FOREIGN KEY (fctr_pagador_prmt_pk)
		REFERENCES tbl_parametro_prmt (prmt_pk)
	, CONSTRAINT fk_fctr_fcsr_pk FOREIGN KEY (fctr_fcsr_pk)
		REFERENCES tbl_factura_serie_fcsr (fcsr_pk)
)\

CREATE OR REPLACE SYNONYM portico.tbl_factura_fctr FOR porticoadm.tbl_factura_fctr\

CREATE INDEX ix_fctr_aspc_pk ON tbl_factura_fctr (fctr_aspc_pk)\
CREATE INDEX ix_fctr_pagador_prmt_pk ON tbl_factura_fctr (fctr_pagador_prmt_pk)\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_factura_fctr TO portico\



-- tbl_factura_srv_fcts
CREATE TABLE tbl_factura_srv_fcts (
	fcts_pk NUMBER(19) NOT NULL
	, fcts_fctr_pk NUMBER(19) NOT NULL
	, fcts_srvc_pk NUMBER(19) NOT NULL
	, fcts_aspc_pk NUMBER(19) NOT NULL
	, fcts_cod_exen CHAR(1) NOT NULL
	, fcts_fref TIMESTAMP NOT NULL
	, fcts_fini TIMESTAMP
	, fcts_ffin TIMESTAMP

	, CONSTRAINT pk_fcts PRIMARY KEY (fcts_pk)

	, CONSTRAINT fk_fcts_fctr_pk FOREIGN KEY (fcts_fctr_pk)
		REFERENCES tbl_factura_fctr (fctr_pk)
	, CONSTRAINT fk_fcts_srvc_pk FOREIGN KEY (fcts_srvc_pk)
		REFERENCES tbl_servicio_srvc (srvc_pk)
	, CONSTRAINT fk_fcts_aspc_pk FOREIGN KEY (fcts_aspc_pk)
		REFERENCES tbl_aspecto_aspc (aspc_pk)
)\

CREATE OR REPLACE SYNONYM portico.tbl_factura_srv_fcts FOR porticoadm.tbl_factura_srv_fcts\

CREATE INDEX ix_fcts_fctr_pk ON tbl_factura_srv_fcts (fcts_fctr_pk)\
CREATE INDEX ix_fcts_srvc_pk ON tbl_factura_srv_fcts (fcts_srvc_pk)\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_factura_srv_fcts TO portico\



-- tbl_factura_lin_fctl
CREATE TABLE tbl_factura_lin_fctl (
	fctl_pk NUMBER(19) NOT NULL
	, fctl_padre_pk NUMBER(19) NOT NULL
	, fctl_fctr_pk NUMBER(19) NOT NULL
	, fctl_fcts_pk NUMBER(19) NOT NULL
	, fctl_rgla_pk NUMBER(19) NOT NULL
	, fctl_impuesto_prmt_pk NUMBER(19) NOT NULL
	, fctl_ssrv_pk NUMBER(19)
	, fctl_fini TIMESTAMP
	, fctl_ffin TIMESTAMP

	, fctl_cuant1 DOUBLE PRECISION
	, fctl_cuant2 DOUBLE PRECISION
	, fctl_cuant3 DOUBLE PRECISION
	, fctl_cuant4 DOUBLE PRECISION
	, fctl_cuant5 DOUBLE PRECISION
	, fctl_cuant6 DOUBLE PRECISION

	, fctl_info1 VARCHAR2(100)
	, fctl_info2 VARCHAR2(100)
	, fctl_info3 VARCHAR2(100)
	, fctl_info4 VARCHAR2(100)
	, fctl_info5 VARCHAR2(100)
	, fctl_info6 VARCHAR2(100)

	, CONSTRAINT pk_fctl PRIMARY KEY (fctl_pk)

	, CONSTRAINT fk_fctl_padre_pk FOREIGN KEY (fctl_padre_pk)
		REFERENCES tbl_factura_lin_fctl (fctl_pk)
	, CONSTRAINT fk_fctl_fctr_pk FOREIGN KEY (fctl_fctr_pk)
		REFERENCES tbl_factura_fctr (fctr_pk)
	, CONSTRAINT fk_fctl_fcts_pk FOREIGN KEY (fctl_fcts_pk)
		REFERENCES tbl_factura_srv_fcts (fcts_pk)
	, CONSTRAINT fk_fctl_rgla_pk FOREIGN KEY (fctl_rgla_pk)
		REFERENCES tbl_regla_rgla (rgla_pk)
	, CONSTRAINT fk_fctl_impuesto_prmt_pk FOREIGN KEY (fctl_impuesto_prmt_pk)
		REFERENCES tbl_parametro_prmt (prmt_pk)
	, CONSTRAINT fk_fctl_ssrv_pk FOREIGN KEY (fctl_ssrv_pk)
		REFERENCES tbl_subservicio_ssrv (ssrv_pk)
)\

CREATE OR REPLACE SYNONYM portico.tbl_factura_lin_fctl FOR porticoadm.tbl_factura_lin_fctl\

CREATE INDEX ix_fctl_padre_pk ON tbl_factura_lin_fctl (fctl_padre_pk)\
CREATE INDEX ix_fctl_fctr_pk ON tbl_factura_lin_fctl (fctl_fctr_pk)\
CREATE INDEX ix_fctl_fcts_pk ON tbl_factura_lin_fctl (fctl_fcts_pk)\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_factura_lin_fctl TO portico\



-- tbl_factura_det_fctd
CREATE TABLE tbl_factura_det_fctd (
	fctd_pk NUMBER(19) NOT NULL
	, fctd_fctr_pk NUMBER(19) NOT NULL
	, fctd_fctl_pk NUMBER(19) NOT NULL
	, fctd_importe_base NUMERIC(10, 2) NOT NULL
	, fctd_importe NUMERIC(10, 2) NOT NULL
	, fctd_ssrv_pk NUMBER(19)
	, fctd_fini TIMESTAMP
	, fctd_ffin TIMESTAMP

	, fctd_cuant1 DOUBLE PRECISION
	, fctd_cuant2 DOUBLE PRECISION
	, fctd_cuant3 DOUBLE PRECISION
	, fctd_cuant4 DOUBLE PRECISION
	, fctd_cuant5 DOUBLE PRECISION
	, fctd_cuant6 DOUBLE PRECISION

	, fctd_info1 VARCHAR2(100)
	, fctd_info2 VARCHAR2(100)
	, fctd_info3 VARCHAR2(100)
	, fctd_info4 VARCHAR2(100)
	, fctd_info5 VARCHAR2(100)
	, fctd_info6 VARCHAR2(100)

	, CONSTRAINT pk_fctd PRIMARY KEY (fctd_pk)

	, CONSTRAINT fk_fctd_fctr_pk FOREIGN KEY (fctd_fctr_pk)
		REFERENCES tbl_factura_fctr (fctr_pk)
	, CONSTRAINT fk_fctd_fctl_pk FOREIGN KEY (fctd_fctl_pk)
		REFERENCES tbl_factura_lin_fctl (fctl_pk)
	, CONSTRAINT fk_fctd_ssrv_pk FOREIGN KEY (fctd_ssrv_pk)
		REFERENCES tbl_subservicio_ssrv (ssrv_pk)
)\

CREATE OR REPLACE SYNONYM portico.tbl_factura_det_fctd FOR porticoadm.tbl_factura_det_fctd\

CREATE INDEX ix_fctd_fctr_pk ON tbl_factura_det_fctd (fctd_fctr_pk)\
CREATE INDEX ix_fctd_fctl_pk ON tbl_factura_det_fctd (fctd_fctl_pk)\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_factura_det_fctd TO portico\



-- tbl_servicio_cargo_srcr
CREATE TABLE tbl_servicio_cargo_srcr (
	srcr_srvc_pk NUMBER(19) NOT NULL
	, srcr_ssrv_pk NUMBER(19)
	, srcr_crgo_pk NUMBER(19) NOT NULL
	, srcr_fini TIMESTAMP
	, srcr_ffin TIMESTAMP
	, srcr_vlrc_pk NUMBER(19)
	, srcr_fctr_pk NUMBER(19)

	, CONSTRAINT fk_srcr_srvc_pk FOREIGN KEY (srcr_srvc_pk)
		REFERENCES tbl_servicio_srvc (srvc_pk)
	, CONSTRAINT fk_srcr_ssrv_pk FOREIGN KEY (srcr_ssrv_pk)
		REFERENCES tbl_subservicio_ssrv (ssrv_pk)
	, CONSTRAINT fk_srcr_crgo_pk FOREIGN KEY (srcr_crgo_pk)
		REFERENCES tbl_cargo_crgo (crgo_pk)
	, CONSTRAINT fk_srcr_vlrc_pk FOREIGN KEY (srcr_vlrc_pk)
		REFERENCES tbl_valoracion_vlrc (vlrc_pk)
	, CONSTRAINT fk_srcr_fctr_pk FOREIGN KEY (srcr_fctr_pk)
		REFERENCES tbl_factura_fctr (fctr_pk)
)\

CREATE OR REPLACE SYNONYM portico.tbl_servicio_cargo_srcr FOR porticoadm.tbl_servicio_cargo_srcr\

CREATE INDEX ix_srcr_srvc_pk ON tbl_servicio_cargo_srcr (srcr_srvc_pk)\
CREATE INDEX ix_srcr_vlrc_pk ON tbl_servicio_cargo_srcr (srcr_vlrc_pk)\
CREATE INDEX ix_srcr_fctr_pk ON tbl_servicio_cargo_srcr (srcr_fctr_pk)\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_servicio_cargo_srcr TO portico\













-- //@UNDO
-- SQL to undo the change goes here.

DROP TABLE tbl_servicio_cargo_srcr\
DROP TABLE tbl_factura_det_fctd\
DROP TABLE tbl_factura_lin_fctl\
DROP TABLE tbl_factura_srv_fcts\
DROP TABLE tbl_factura_fctr\
DROP TABLE tbl_valoracion_tmp_vlrt\
DROP TABLE tbl_valoracion_det_vlrd\
DROP TABLE tbl_valoracion_lin_vlrl\
DROP TABLE tbl_valoracion_vlrc\
DROP TABLE tbl_factura_serie_fcsr\
DROP TABLE tbl_aspecto_cargo_version_ascv\
DROP TABLE tbl_aspecto_cargo_ascr\
DROP TABLE tbl_aspecto_version_aspv\
DROP TABLE tbl_aspecto_aspc\
DROP TABLE tbl_regla_inc_version_rgiv\
DROP TABLE tbl_regla_inc_rgin\
DROP TABLE tbl_regla_version_rglv\
DROP TABLE tbl_regla_rgla\
DROP TABLE tbl_cargo_dep_version_crdv\
DROP TABLE tbl_cargo_dep_crdp\
DROP TABLE tbl_cargo_version_crgv\
DROP TABLE tbl_cargo_crgo\
