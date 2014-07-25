-- // 0 0 2 Facturacion
-- Migration SQL that makes the change goes here.

-- tbl_cargo_crgo
CREATE TABLE portico.tbl_cargo_crgo
(
	crgo_pk BIGINT NOT NULL
	, crgo_codigo VARCHAR(15) NOT NULL
	, crgo_codigo_norm VARCHAR(15)
	, crgo_es_principal INT NOT NULL
	, crgo_es_temporal INT NOT NULL
	, crgo_tpsr_pk BIGINT NOT NULL
	, crgo_tipo VARCHAR(1) NOT NULL
	, crgo_descripcion VARCHAR(200) NOT NULL

	, CONSTRAINT pk_crgo PRIMARY KEY (crgo_pk)
	, CONSTRAINT uq_crgo UNIQUE (crgo_tpsr_pk, crgo_codigo)

	, CONSTRAINT fk_crgo_tpsr_pk FOREIGN KEY (crgo_tpsr_pk)
		REFERENCES portico.tbl_tipo_servicio_tpsr (tpsr_pk)
)
/

GRANT SELECT, INSERT, UPDATE, DELETE ON portico.tbl_cargo_crgo TO portico
/

COMMENT ON TABLE portico.tbl_cargo_crgo IS 'Maestro de Tasas-Tarifas'
/
COMMENT ON COLUMN portico.tbl_cargo_crgo.crgo_pk IS 'Identificador de Tasa-Tarifa'
/
COMMENT ON COLUMN portico.tbl_cargo_crgo.crgo_codigo IS 'Codigo de Tasa-Tarifa'
/
COMMENT ON COLUMN portico.tbl_cargo_crgo.crgo_tpsr_pk IS 'Identificador de Modulo al que pertenece la Tasa-Tarifa'
/



-- tbl_cargo_version_crgv
CREATE TABLE portico.tbl_cargo_version_crgv
(
	crgv_pk BIGINT NOT NULL
	, crgv_crgo_pk BIGINT NOT NULL
	, crgv_fini TIMESTAMP NOT NULL
	, crgv_ffin TIMESTAMP

	, CONSTRAINT pk_crgv PRIMARY KEY (crgv_pk)

	, CONSTRAINT fk_crgv_crgo_pk FOREIGN KEY (crgv_crgo_pk)
		REFERENCES portico.tbl_cargo_crgo (crgo_pk)
)
/

GRANT SELECT, INSERT, UPDATE, DELETE ON portico.tbl_cargo_version_crgv TO portico
/



-- tbl_cargo_dep_crdp
CREATE TABLE portico.tbl_cargo_dep_crdp
(
	crdp_pk BIGINT NOT NULL
	, crdp_crgop_pk BIGINT NOT NULL
	, crdp_crgoh_pk BIGINT NOT NULL

	, CONSTRAINT pk_crdp PRIMARY KEY (crdp_pk)
	, CONSTRAINT uq_crdp UNIQUE (crdp_crgop_pk, crdp_crgoh_pk)

	, CONSTRAINT fk_crdp_crgop_pk FOREIGN KEY (crdp_crgop_pk)
		REFERENCES portico.tbl_cargo_crgo (crgo_pk)
	, CONSTRAINT fk_crdp_crgoh_pk FOREIGN KEY (crdp_crgoh_pk)
		REFERENCES portico.tbl_cargo_crgo (crgo_pk)
)
/

GRANT SELECT, INSERT, UPDATE, DELETE ON portico.tbl_cargo_dep_crdp TO portico
/



-- tbl_cargo_dep_version_crdv
CREATE TABLE portico.tbl_cargo_dep_version_crdv
(
	crdv_pk BIGINT NOT NULL
	, crdv_crdp_pk BIGINT NOT NULL
	, crdv_fini TIMESTAMP NOT NULL
	, crdv_ffin TIMESTAMP

	, CONSTRAINT pk_crdv PRIMARY KEY (crdv_pk)

	, CONSTRAINT fk_crdv_crdp_pk FOREIGN KEY (crdv_crdp_pk)
		REFERENCES portico.tbl_cargo_dep_crdp (crdp_pk)
)
/

GRANT SELECT, INSERT, UPDATE, DELETE ON portico.tbl_cargo_dep_version_crdv TO portico
/



-- tbl_regla_rgla
CREATE TABLE portico.tbl_regla_rgla
(
	rgla_pk BIGINT NOT NULL
	, rgla_codigo VARCHAR(20) NOT NULL
	, rgla_crgo_pk BIGINT NOT NULL
	, rgla_enti_pk BIGINT NOT NULL
	, rgla_tipo VARCHAR(1) NOT NULL

	, CONSTRAINT pk_rgla PRIMARY KEY (rgla_pk)
	, CONSTRAINT uq_rgla UNIQUE (rgla_codigo)

	, CONSTRAINT fk_rgla_crgo_pk FOREIGN KEY (rgla_crgo_pk)
		REFERENCES portico.tbl_cargo_crgo (crgo_pk)
	, CONSTRAINT fk_rgla_enti_pk FOREIGN KEY (rgla_enti_pk)
		REFERENCES portico.tbl_entidad_enti (enti_pk)
)
/

GRANT SELECT, INSERT, UPDATE, DELETE ON portico.tbl_regla_rgla TO portico
/



-- tbl_regla_version_rglv
CREATE TABLE portico.tbl_regla_version_rglv
(
	rglv_pk BIGINT NOT NULL
	, rglv_rgla_pk BIGINT NOT NULL
	, rglv_fini TIMESTAMP NOT NULL
	, rglv_ffin TIMESTAMP
	, rglv_condicion VARCHAR(2000) NOT NULL
	, rglv_formula VARCHAR(2000) NOT NULL

	, rglv_path_impuesto VARCHAR(250) NOT NULL
	, rglv_path_pagador VARCHAR(250) NOT NULL
	, rglv_path_es_suj_pasivo VARCHAR(250) NOT NULL
	, rglv_path_cod_exen VARCHAR(250) NOT NULL

	, rglv_path_info1 VARCHAR(250)
	, rglv_etiq_info1 VARCHAR(50)
	, rglv_path_info2 VARCHAR(250)
	, rglv_etiq_info2 VARCHAR(50)
	, rglv_path_info3 VARCHAR(250)
	, rglv_etiq_info3 VARCHAR(50)
	, rglv_path_info4 VARCHAR(250)
	, rglv_etiq_info4 VARCHAR(50)
	, rglv_path_info5 VARCHAR(250)
	, rglv_etiq_info5 VARCHAR(50)
	, rglv_path_info6 VARCHAR(250)
	, rglv_etiq_info6 VARCHAR(50)

	, rglv_path_cuant1 VARCHAR(250)
	, rglv_etiq_cuant1 VARCHAR(50)
	, rglv_path_cuant2 VARCHAR(250)
	, rglv_etiq_cuant2 VARCHAR(50)
	, rglv_path_cuant3 VARCHAR(250)
	, rglv_etiq_cuant3 VARCHAR(50)
	, rglv_path_cuant4 VARCHAR(250)
	, rglv_etiq_cuant4 VARCHAR(50)
	, rglv_path_cuant5 VARCHAR(250)
	, rglv_etiq_cuant5 VARCHAR(50)
	, rglv_path_cuant6 VARCHAR(250)
	, rglv_etiq_cuant6 VARCHAR(50)

	, CONSTRAINT pk_rglv PRIMARY KEY (rglv_pk)

	, CONSTRAINT fk_rglv_rgla_pk FOREIGN KEY (rglv_rgla_pk)
		REFERENCES portico.tbl_regla_rgla (rgla_pk)
)
/

GRANT SELECT, INSERT, UPDATE, DELETE ON portico.tbl_regla_version_rglv TO portico
/



-- tbl_regla_inc_rgin
CREATE TABLE portico.tbl_regla_inc_rgin
(
	rgin_rgla1_pk BIGINT NOT NULL
	, rgin_rgla2_pk BIGINT NOT NULL

	, CONSTRAINT pk_rgin PRIMARY KEY (rgin_rgla1_pk, rgin_rgla2_pk)

	, CONSTRAINT fk_rgin_rgla1_pk FOREIGN KEY (rgin_rgla1_pk)
		REFERENCES portico.tbl_regla_rgla (rgla_pk)
	, CONSTRAINT fk_rgin_rgla2_pk FOREIGN KEY (rgin_rgla2_pk)
		REFERENCES portico.tbl_regla_rgla (rgla_pk)
)
/

GRANT SELECT, INSERT, UPDATE, DELETE ON portico.tbl_regla_inc_rgin TO portico
/



-- tbl_aspecto_aspc
CREATE TABLE portico.tbl_aspecto_aspc
(
	aspc_pk BIGINT NOT NULL
	, aspc_codigo VARCHAR(10) NOT NULL
	, aspc_tpsr_pk BIGINT NOT NULL
	, aspc_descripcion VARCHAR(200) NOT NULL

	, CONSTRAINT pk_aspc PRIMARY KEY (aspc_pk)
	, CONSTRAINT uq_aspc UNIQUE (aspc_codigo)

	, CONSTRAINT fk_aspc_tpsr_pk FOREIGN KEY (aspc_tpsr_pk)
		REFERENCES portico.tbl_tipo_servicio_tpsr (tpsr_pk)
)
/

GRANT SELECT, INSERT, UPDATE, DELETE ON portico.tbl_aspecto_aspc TO portico
/



-- tbl_aspecto_version_aspv
CREATE TABLE portico.tbl_aspecto_version_aspv
(
	aspv_pk BIGINT NOT NULL
	, aspv_aspc_pk BIGINT NOT NULL
	, aspv_fini TIMESTAMP NOT NULL
	, aspv_ffin TIMESTAMP

	, aspv_cpath_info1 VARCHAR(250)
	, aspv_cetiq_info1 VARCHAR(50)
	, aspv_cpath_info2 VARCHAR(250)
	, aspv_cetiq_info2 VARCHAR(50)
	, aspv_cpath_info3 VARCHAR(250)
	, aspv_cetiq_info3 VARCHAR(50)
	, aspv_cpath_info4 VARCHAR(250)
	, aspv_cetiq_info4 VARCHAR(50)
	, aspv_cpath_info5 VARCHAR(250)
	, aspv_cetiq_info5 VARCHAR(50)
	, aspv_cpath_info6 VARCHAR(250)
	, aspv_cetiq_info6 VARCHAR(50)

	, aspv_lpath_info1 VARCHAR(250)
	, aspv_letiq_info1 VARCHAR(50)
	, aspv_lpath_info2 VARCHAR(250)
	, aspv_letiq_info2 VARCHAR(50)
	, aspv_lpath_info3 VARCHAR(250)
	, aspv_letiq_info3 VARCHAR(50)
	, aspv_lpath_info4 VARCHAR(250)
	, aspv_letiq_info4 VARCHAR(50)
	, aspv_lpath_info5 VARCHAR(250)
	, aspv_letiq_info5 VARCHAR(50)
	, aspv_lpath_info6 VARCHAR(250)
	, aspv_letiq_info6 VARCHAR(50)

	, aspv_lpath_cuant1 VARCHAR(250)
	, aspv_letiq_cuant1 VARCHAR(50)
	, aspv_lsum_cuant1 INT
	, aspv_lpath_cuant2 VARCHAR(250)
	, aspv_letiq_cuant2 VARCHAR(50)
	, aspv_lsum_cuant2 INT
	, aspv_lpath_cuant3 VARCHAR(250)
	, aspv_letiq_cuant3 VARCHAR(50)
	, aspv_lsum_cuant3 INT
	, aspv_lpath_cuant4 VARCHAR(250)
	, aspv_letiq_cuant4 VARCHAR(50)
	, aspv_lsum_cuant4 INT
	, aspv_lpath_cuant5 VARCHAR(250)
	, aspv_letiq_cuant5 VARCHAR(50)
	, aspv_lsum_cuant5 INT
	, aspv_lpath_cuant6 VARCHAR(250)
	, aspv_letiq_cuant6 VARCHAR(50)
	, aspv_lsum_cuant6 INT

	, CONSTRAINT pk_aspv PRIMARY KEY (aspv_pk)

	, CONSTRAINT fk_aspv_aspc_pk FOREIGN KEY (aspv_aspc_pk)
		REFERENCES portico.tbl_aspecto_aspc (aspc_pk)
)
/

GRANT SELECT, INSERT, UPDATE, DELETE ON portico.tbl_aspecto_version_aspv TO portico
/



-- tbl_aspecto_cargo_ascr
CREATE TABLE portico.tbl_aspecto_cargo_ascr
(
	ascr_aspv_pk BIGINT NOT NULL
	, ascr_crgo_pk BIGINT NOT NULL

	, CONSTRAINT pk_ascr PRIMARY KEY (ascr_aspv_pk, ascr_crgo_pk)

	, CONSTRAINT fk_ascr_aspv_pk FOREIGN KEY (ascr_aspv_pk)
		REFERENCES portico.tbl_aspecto_version_aspv (aspv_pk)
	, CONSTRAINT fk_ascr_crgo_pk FOREIGN KEY (ascr_crgo_pk)
		REFERENCES portico.tbl_cargo_crgo (crgo_pk)
)
/

GRANT SELECT, INSERT, UPDATE, DELETE ON portico.tbl_aspecto_cargo_ascr TO portico
/



-- tbl_valoracion_vlrc
CREATE TABLE portico.tbl_valoracion_vlrc
(
	vlrc_pk BIGINT NOT NULL
	, vlrc_srvc_pk BIGINT NOT NULL
	, vlrc_crgo_pk BIGINT NOT NULL
	, vlrc_aspc_pk BIGINT NOT NULL
	, vlrc_pagador_pk BIGINT NOT NULL
	, vlrc_fref TIMESTAMP NOT NULL
	, vlrc_falta TIMESTAMP NOT NULL
	, vlrc_fini TIMESTAMP
	, vlrc_ffin TIMESTAMP
	, vlrc_importe DOUBLE PRECISION NOT NULL
	, vlrc_iva DOUBLE PRECISION NOT NULL
	, vlrc_es_suj_pasivo INT NOT NULL
	, vlrc_cod_exen CHAR(1) NOT NULL

	, vlrc_info1 VARCHAR(100)
	, vlrc_info2 VARCHAR(100)
	, vlrc_info3 VARCHAR(100)
	, vlrc_info4 VARCHAR(100)
	, vlrc_info5 VARCHAR(100)
	, vlrc_info6 VARCHAR(100)

	, CONSTRAINT pk_vlrc PRIMARY KEY (vlrc_pk)

	, CONSTRAINT fk_vlrc_srvc_pk FOREIGN KEY (vlrc_srvc_pk)
		REFERENCES portico.tbl_servicio_srvc (srvc_pk)
	, CONSTRAINT fk_vlrc_crgo_pk FOREIGN KEY (vlrc_crgo_pk)
		REFERENCES portico.tbl_cargo_crgo (crgo_pk)
	, CONSTRAINT fk_vlrc_aspc_pk FOREIGN KEY (vlrc_aspc_pk)
		REFERENCES portico.tbl_aspecto_aspc (aspc_pk)
	, CONSTRAINT fk_vlrc_pagador_pk FOREIGN KEY (vlrc_pagador_pk)
		REFERENCES portico.tbl_parametro_prmt (prmt_pk)
)
/

CREATE INDEX ix_vlrc_srvc_pk ON portico.tbl_valoracion_vlrc (vlrc_srvc_pk)
/
CREATE INDEX ix_vlrc_crgo_pk ON portico.tbl_valoracion_vlrc (vlrc_crgo_pk)
/
CREATE INDEX ix_vlrc_pagador_pk ON portico.tbl_valoracion_vlrc (vlrc_pagador_pk)
/

GRANT SELECT, INSERT, UPDATE, DELETE ON portico.tbl_valoracion_vlrc TO portico
/



-- tbl_valoracion_imp_vlri
CREATE TABLE portico.tbl_valoracion_imp_vlri
(
	vlri_vlrc_pk BIGINT NOT NULL
	, vlri_impuesto_pk BIGINT NOT NULL
	, vlri_importe DOUBLE PRECISION NOT NULL
	, vlri_impuesto DOUBLE PRECISION NOT NULL

	, CONSTRAINT pk_vlri PRIMARY KEY (vlri_vlrc_pk, vlri_impuesto_pk)

	, CONSTRAINT fk_vlri_vlrc_pk FOREIGN KEY (vlri_vlrc_pk)
		REFERENCES portico.tbl_valoracion_vlrc (vlrc_pk)
	, CONSTRAINT fk_vlri_impuesto_pk FOREIGN KEY (vlri_impuesto_pk)
		REFERENCES portico.tbl_parametro_prmt (prmt_pk)
)
/

GRANT SELECT, INSERT, UPDATE, DELETE ON portico.tbl_valoracion_imp_vlri TO portico
/



-- tbl_valoracion_lin_vlrl
CREATE TABLE portico.tbl_valoracion_lin_vlrl
(
	vlrl_pk BIGINT NOT NULL
	, vlrl_vlrc_pk BIGINT NOT NULL
	, vlrl_rgla_pk BIGINT NOT NULL
	, vlrl_orden INT NOT NULL
	, vlrl_importe_base DOUBLE PRECISION NOT NULL
	, vlrl_importe DOUBLE PRECISION NOT NULL
	, vlrl_impuesto_pk BIGINT NOT NULL
	, vlrl_ssrv_pk BIGINT

	, vlrl_cuant1 DOUBLE PRECISION
	, vlrl_cuant2 DOUBLE PRECISION
	, vlrl_cuant3 DOUBLE PRECISION
	, vlrl_cuant4 DOUBLE PRECISION
	, vlrl_cuant5 DOUBLE PRECISION
	, vlrl_cuant6 DOUBLE PRECISION

	, vlrl_info1 VARCHAR(100)
	, vlrl_info2 VARCHAR(100)
	, vlrl_info3 VARCHAR(100)
	, vlrl_info4 VARCHAR(100)
	, vlrl_info5 VARCHAR(100)
	, vlrl_info6 VARCHAR(100)

	, CONSTRAINT pk_vlrl PRIMARY KEY (vlrl_pk)

	, CONSTRAINT fk_vlrl_vlrc_pk FOREIGN KEY (vlrl_vlrc_pk)
		REFERENCES portico.tbl_valoracion_vlrc (vlrc_pk)
	, CONSTRAINT fk_vlrl_rgla_pk FOREIGN KEY (vlrl_rgla_pk)
		REFERENCES portico.tbl_regla_rgla (rgla_pk)
	, CONSTRAINT fk_vlrl_impuesto_pk FOREIGN KEY (vlrl_impuesto_pk)
		REFERENCES portico.tbl_parametro_prmt (prmt_pk)
	, CONSTRAINT fk_vlrl_ssrv_pk FOREIGN KEY (vlrl_ssrv_pk)
		REFERENCES portico.tbl_subservicio_ssrv (ssrv_pk)
)
/

CREATE INDEX ix_vlrl_vlrc_pk ON portico.tbl_valoracion_lin_vlrl (vlrl_vlrc_pk)
/

GRANT SELECT, INSERT, UPDATE, DELETE ON portico.tbl_valoracion_lin_vlrl TO portico
/



-- tbl_valoracion_det_vlrd
CREATE TABLE portico.tbl_valoracion_det_vlrd
(
	vlrd_pk BIGINT NOT NULL
	, vlrd_vlrc_pk BIGINT NOT NULL
	, vlrd_vlrl_pk BIGINT NOT NULL
	, vlrd_rgla_pk BIGINT NOT NULL
	, vlrd_orden INT NOT NULL
	, vlrd_importe_base DOUBLE PRECISION NOT NULL
	, vlrd_importe DOUBLE PRECISION NOT NULL
	, vlrd_impuesto_pk BIGINT NOT NULL
	, vlrd_ssrv_pk BIGINT

	, vlrd_cuant1 DOUBLE PRECISION
	, vlrd_cuant2 DOUBLE PRECISION
	, vlrd_cuant3 DOUBLE PRECISION
	, vlrd_cuant4 DOUBLE PRECISION
	, vlrd_cuant5 DOUBLE PRECISION
	, vlrd_cuant6 DOUBLE PRECISION

	, vlrd_info1 VARCHAR(100)
	, vlrd_info2 VARCHAR(100)
	, vlrd_info3 VARCHAR(100)
	, vlrd_info4 VARCHAR(100)
	, vlrd_info5 VARCHAR(100)
	, vlrd_info6 VARCHAR(100)

	, CONSTRAINT pk_vlrd PRIMARY KEY (vlrd_pk)

	, CONSTRAINT fk_vlrd_vlrc_pk FOREIGN KEY (vlrd_vlrc_pk)
		REFERENCES portico.tbl_valoracion_vlrc (vlrc_pk)
	, CONSTRAINT fk_vlrd_vlrl_pk FOREIGN KEY (vlrd_vlrl_pk)
		REFERENCES portico.tbl_valoracion_lin_vlrl (vlrl_pk)
	, CONSTRAINT fk_vlrd_rgla_pk FOREIGN KEY (vlrd_rgla_pk)
		REFERENCES portico.tbl_regla_rgla (rgla_pk)
	, CONSTRAINT fk_vlrd_impuesto_pk FOREIGN KEY (vlrd_impuesto_pk)
		REFERENCES portico.tbl_parametro_prmt (prmt_pk)
	, CONSTRAINT fk_vlrd_ssrv_pk FOREIGN KEY (vlrd_ssrv_pk)
		REFERENCES portico.tbl_subservicio_ssrv (ssrv_pk)
)
/

CREATE INDEX ix_vlrd_vlrc_pk ON portico.tbl_valoracion_det_vlrd (vlrd_vlrc_pk)
/
CREATE INDEX ix_vlrd_vlrl_pk ON portico.tbl_valoracion_det_vlrd (vlrd_vlrl_pk)
/
CREATE INDEX ix_vlrd_ssrv_pk ON portico.tbl_valoracion_det_vlrd (vlrd_ssrv_pk)
/

GRANT SELECT, INSERT, UPDATE, DELETE ON portico.tbl_valoracion_det_vlrd TO portico
/



-- tbl_valoracion_tmp_vlrt
CREATE TABLE portico.tbl_valoracion_tmp_vlrt
(
	vlrt_prbt_pk BIGINT NOT NULL
	, vlrt_srvc_pk BIGINT NOT NULL
	, vlrt_ssrv_pk BIGINT
	, vlrt_crgo_pk BIGINT NOT NULL
	, vlrt_rgla_pk BIGINT NOT NULL
	, vlrt_impuesto_pk BIGINT NOT NULL
	, vlrt_pagador_pk BIGINT NOT NULL
	, vlrt_orden INT NOT NULL
	, vlrt_importe_base DOUBLE PRECISION NOT NULL
	, vlrt_importe DOUBLE PRECISION NOT NULL
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

	, vlrt_info1 VARCHAR(100)
	, vlrt_info2 VARCHAR(100)
	, vlrt_info3 VARCHAR(100)
	, vlrt_info4 VARCHAR(100)
	, vlrt_info5 VARCHAR(100)
	, vlrt_info6 VARCHAR(100)

	, CONSTRAINT fk_vlrt_prbt_pk FOREIGN KEY (vlrt_prbt_pk)
		REFERENCES portico.tbl_proceso_batch_prbt (prbt_pk)
	, CONSTRAINT fk_vlrt_srvc_pk FOREIGN KEY (vlrt_srvc_pk)
		REFERENCES portico.tbl_servicio_srvc (srvc_pk)
	, CONSTRAINT fk_vlrt_ssrv_pk FOREIGN KEY (vlrt_ssrv_pk)
		REFERENCES portico.tbl_subservicio_ssrv (ssrv_pk)
	, CONSTRAINT fk_vlrt_crgo_pk FOREIGN KEY (vlrt_crgo_pk)
		REFERENCES portico.tbl_cargo_crgo (crgo_pk)
	, CONSTRAINT fk_vlrt_rgla_pk FOREIGN KEY (vlrt_rgla_pk)
		REFERENCES portico.tbl_regla_rgla (rgla_pk)
	, CONSTRAINT fk_vlrt_impuesto_pk FOREIGN KEY (vlrt_impuesto_pk)
		REFERENCES portico.tbl_parametro_prmt (prmt_pk)
	, CONSTRAINT fk_vlrt_pagador_pk FOREIGN KEY (vlrt_pagador_pk)
		REFERENCES portico.tbl_parametro_prmt (prmt_pk)
)
/

CREATE INDEX ix_vlrt_prbt_pk ON portico.tbl_valoracion_tmp_vlrt (vlrt_prbt_pk)
/

GRANT SELECT, INSERT, UPDATE, DELETE ON portico.tbl_valoracion_tmp_vlrt TO portico
/



-- tbl_factura_fctr
CREATE TABLE portico.tbl_factura_fctr
(
	fctr_pk BIGINT NOT NULL
	, fctr_crgo_pk BIGINT NOT NULL
	, fctr_aspc_pk BIGINT NOT NULL
	, fctr_pagador_pk BIGINT NOT NULL
	, fctr_fref TIMESTAMP NOT NULL
	, fctr_falta TIMESTAMP NOT NULL
	, fctr_fini TIMESTAMP
	, fctr_ffin TIMESTAMP
	, fctr_importe DOUBLE PRECISION NOT NULL
	, fctr_iva DOUBLE PRECISION NOT NULL
	, fctr_info1 VARCHAR(100)
	, fctr_info2 VARCHAR(100)
	, fctr_info3 VARCHAR(100)
	, fctr_info4 VARCHAR(100)
	, fctr_info5 VARCHAR(100)
	, fctr_info6 VARCHAR(100)

	, CONSTRAINT pk_fctr PRIMARY KEY (fctr_pk)

	, CONSTRAINT fk_fctr_crgo_pk FOREIGN KEY (fctr_crgo_pk)
		REFERENCES portico.tbl_cargo_crgo (crgo_pk)
	, CONSTRAINT fk_fctr_aspc_pk FOREIGN KEY (fctr_aspc_pk)
		REFERENCES portico.tbl_aspecto_aspc (aspc_pk)
	, CONSTRAINT fk_fctr_pagador_pk FOREIGN KEY (fctr_pagador_pk)
		REFERENCES portico.tbl_parametro_prmt (prmt_pk)
)
/

CREATE INDEX ix_fctr_crgo_pk ON portico.tbl_factura_fctr (fctr_crgo_pk)
/
CREATE INDEX ix_fctr_pagador_pk ON portico.tbl_factura_fctr (fctr_pagador_pk)
/

GRANT SELECT, INSERT, UPDATE, DELETE ON portico.tbl_factura_fctr TO portico
/



-- tbl_factura_servicio_fcsr
CREATE TABLE portico.tbl_factura_servicio_fcsr
(
	fcsr_fctr_pk BIGINT NOT NULL
	, fcsr_srvc_pk BIGINT NOT NULL

	, CONSTRAINT pk_fcsr PRIMARY KEY (fcsr_fctr_pk, fcsr_srvc_pk)

	, CONSTRAINT fk_fcsr_fctr_pk FOREIGN KEY (fcsr_fctr_pk)
		REFERENCES portico.tbl_factura_fctr (fctr_pk)
	, CONSTRAINT fk_fcsr_srvc_pk FOREIGN KEY (fcsr_srvc_pk)
		REFERENCES portico.tbl_servicio_srvc (srvc_pk)
)
/

CREATE INDEX ix_fcsr_srvc_pk ON portico.tbl_factura_servicio_fcsr (fcsr_srvc_pk)
/

GRANT SELECT, INSERT, UPDATE, DELETE ON portico.tbl_factura_servicio_fcsr TO portico
/



-- tbl_factura_imp_fcti
CREATE TABLE portico.tbl_factura_imp_fcti
(
	fcti_fctr_pk BIGINT NOT NULL
	, fcti_impuesto_pk BIGINT NOT NULL
	, fcti_importe DOUBLE PRECISION NOT NULL
	, fcti_impuesto DOUBLE PRECISION NOT NULL

	, CONSTRAINT pk_fcti PRIMARY KEY (fcti_fctr_pk, fcti_impuesto_pk)

	, CONSTRAINT fk_fcti_fctr_pk FOREIGN KEY (fcti_fctr_pk)
		REFERENCES portico.tbl_factura_fctr (fctr_pk)
	, CONSTRAINT fk_fcti_impuesto_pk FOREIGN KEY (fcti_impuesto_pk)
		REFERENCES portico.tbl_parametro_prmt (prmt_pk)
)
/

GRANT SELECT, INSERT, UPDATE, DELETE ON portico.tbl_factura_imp_fcti TO portico
/



-- tbl_factura_lin_fctl
CREATE TABLE portico.tbl_factura_lin_fctl
(
	fctl_pk BIGINT NOT NULL
	, fctl_fctr_pk BIGINT NOT NULL
	, fctl_rgla_pk BIGINT NOT NULL
	, fctl_orden INT NOT NULL
	, fctl_importe_base DOUBLE PRECISION NOT NULL
	, fctl_importe DOUBLE PRECISION NOT NULL
	, fctl_impuesto_pk BIGINT NOT NULL
	, fctl_srvc_pk BIGINT NOT NULL
	, fctl_ssrv_pk BIGINT

	, fctl_cuant1 DOUBLE PRECISION
	, fctl_cuant2 DOUBLE PRECISION
	, fctl_cuant3 DOUBLE PRECISION
	, fctl_cuant4 DOUBLE PRECISION
	, fctl_cuant5 DOUBLE PRECISION
	, fctl_cuant6 DOUBLE PRECISION

	, fctl_info1 VARCHAR(100)
	, fctl_info2 VARCHAR(100)
	, fctl_info3 VARCHAR(100)
	, fctl_info4 VARCHAR(100)
	, fctl_info5 VARCHAR(100)
	, fctl_info6 VARCHAR(100)

	, CONSTRAINT pk_fctl PRIMARY KEY (fctl_pk)

	, CONSTRAINT fk_fctl_fctr_pk FOREIGN KEY (fctl_fctr_pk)
		REFERENCES portico.tbl_factura_fctr (fctr_pk)
	, CONSTRAINT fk_fctl_rgla_pk FOREIGN KEY (fctl_rgla_pk)
		REFERENCES portico.tbl_regla_rgla (rgla_pk)
	, CONSTRAINT fk_fctl_impuesto_pk FOREIGN KEY (fctl_impuesto_pk)
		REFERENCES portico.tbl_parametro_prmt (prmt_pk)
	, CONSTRAINT fk_fctl_srvc_pk FOREIGN KEY (fctl_srvc_pk)
		REFERENCES portico.tbl_servicio_srvc (srvc_pk)
	, CONSTRAINT fk_fctl_ssrv_pk FOREIGN KEY (fctl_ssrv_pk)
		REFERENCES portico.tbl_subservicio_ssrv (ssrv_pk)
)
/

CREATE INDEX ix_fctl_fctr_pk ON portico.tbl_factura_lin_fctl (fctl_fctr_pk)
/

GRANT SELECT, INSERT, UPDATE, DELETE ON portico.tbl_factura_lin_fctl TO portico
/



-- tbl_factura_det_fctd
CREATE TABLE portico.tbl_factura_det_fctd
(
	fctd_pk BIGINT NOT NULL
	, fctd_fctr_pk BIGINT NOT NULL
	, fctd_fctl_pk BIGINT NOT NULL
	, fctd_rgla_pk BIGINT NOT NULL
	, fctd_orden INT NOT NULL
	, fctd_importe_base DOUBLE PRECISION NOT NULL
	, fctd_importe DOUBLE PRECISION NOT NULL
	, fctd_impuesto_pk BIGINT NOT NULL
	, fctd_srvc_pk BIGINT NOT NULL
	, fctd_ssrv_pk BIGINT

	, fctd_cuant1 DOUBLE PRECISION
	, fctd_cuant2 DOUBLE PRECISION
	, fctd_cuant3 DOUBLE PRECISION
	, fctd_cuant4 DOUBLE PRECISION
	, fctd_cuant5 DOUBLE PRECISION
	, fctd_cuant6 DOUBLE PRECISION

	, fctd_info1 VARCHAR(100)
	, fctd_info2 VARCHAR(100)
	, fctd_info3 VARCHAR(100)
	, fctd_info4 VARCHAR(100)
	, fctd_info5 VARCHAR(100)
	, fctd_info6 VARCHAR(100)

	, CONSTRAINT pk_fctd PRIMARY KEY (fctd_pk)

	, CONSTRAINT fk_fctd_fctr_pk FOREIGN KEY (fctd_fctr_pk)
		REFERENCES portico.tbl_factura_fctr (fctr_pk)
	, CONSTRAINT fk_fctd_fctl_pk FOREIGN KEY (fctd_fctl_pk)
		REFERENCES portico.tbl_factura_lin_fctl (fctl_pk)
	, CONSTRAINT fk_fctd_rgla_pk FOREIGN KEY (fctd_rgla_pk)
		REFERENCES portico.tbl_regla_rgla (rgla_pk)
	, CONSTRAINT fk_fctd_impuesto_pk FOREIGN KEY (fctd_impuesto_pk)
		REFERENCES portico.tbl_parametro_prmt (prmt_pk)
	, CONSTRAINT fk_fctd_srvc_pk FOREIGN KEY (fctd_srvc_pk)
		REFERENCES portico.tbl_servicio_srvc (srvc_pk)
	, CONSTRAINT fk_fctd_ssrv_pk FOREIGN KEY (fctd_ssrv_pk)
		REFERENCES portico.tbl_subservicio_ssrv (ssrv_pk)
)
/

CREATE INDEX ix_fctd_fctr_pk ON portico.tbl_factura_det_fctd (fctd_fctr_pk)
/
CREATE INDEX ix_fctd_fctl_pk ON portico.tbl_factura_det_fctd (fctd_fctl_pk)
/

GRANT SELECT, INSERT, UPDATE, DELETE ON portico.tbl_factura_det_fctd TO portico
/



-- tbl_servicio_cargo_srcr
CREATE TABLE portico.tbl_servicio_cargo_srcr
(
	srcr_srvc_pk BIGINT NOT NULL
	, srcr_ssrv_pk BIGINT
	, srcr_crgo_pk BIGINT NOT NULL
	, srcr_fini TIMESTAMP NOT NULL
	, srcr_ffin TIMESTAMP NOT NULL
	, srcr_vlrc_pk BIGINT
	, srcr_fctr_pk BIGINT

	, CONSTRAINT fk_srcr_srvc_pk FOREIGN KEY (srcr_srvc_pk)
		REFERENCES portico.tbl_servicio_srvc (srvc_pk)
	, CONSTRAINT fk_srcr_ssrv_pk FOREIGN KEY (srcr_ssrv_pk)
		REFERENCES portico.tbl_subservicio_ssrv (ssrv_pk)
	, CONSTRAINT fk_srcr_crgo_pk FOREIGN KEY (srcr_crgo_pk)
		REFERENCES portico.tbl_cargo_crgo (crgo_pk)
	, CONSTRAINT fk_srcr_vlrc_pk FOREIGN KEY (srcr_vlrc_pk)
		REFERENCES portico.tbl_valoracion_vlrc (vlrc_pk)
	, CONSTRAINT fk_srcr_fctr_pk FOREIGN KEY (srcr_fctr_pk)
		REFERENCES portico.tbl_factura_fctr (fctr_pk)
)
/

CREATE INDEX ix_srcr_srvc_pk ON portico.tbl_servicio_cargo_srcr (srcr_srvc_pk)
/
CREATE INDEX ix_srcr_vlrc_pk ON portico.tbl_servicio_cargo_srcr (srcr_vlrc_pk)
/
CREATE INDEX ix_srcr_fctr_pk ON portico.tbl_servicio_cargo_srcr (srcr_fctr_pk)
/

GRANT SELECT, INSERT, UPDATE, DELETE ON portico.tbl_servicio_cargo_srcr TO portico
/













-- //@UNDO
-- SQL to undo the change goes here.

DROP TABLE portico.tbl_servicio_cargo_srcr
/
DROP TABLE portico.tbl_factura_det_fctd
/
DROP TABLE portico.tbl_factura_lin_fctl
/
DROP TABLE portico.tbl_factura_imp_fcti
/
DROP TABLE portico.tbl_factura_servicio_fcsr
/
DROP TABLE portico.tbl_factura_fctr
/
DROP TABLE portico.tbl_valoracion_tmp_vlrt
/
DROP TABLE portico.tbl_valoracion_det_vlrd
/
DROP TABLE portico.tbl_valoracion_lin_vlrl
/
DROP TABLE portico.tbl_valoracion_imp_vlri
/
DROP TABLE portico.tbl_valoracion_vlrc
/
DROP TABLE portico.tbl_aspecto_cargo_ascr
/
DROP TABLE portico.tbl_aspecto_version_aspv
/
DROP TABLE portico.tbl_aspecto_aspc
/
DROP TABLE portico.tbl_regla_inc_rgin
/
DROP TABLE portico.tbl_regla_version_rglv
/
DROP TABLE portico.tbl_regla_rgla
/
DROP TABLE portico.tbl_cargo_dep_version_crdv
/
DROP TABLE portico.tbl_cargo_dep_crdp
/
DROP TABLE portico.tbl_cargo_version_crgv
/
DROP TABLE portico.tbl_cargo_crgo
/
