-- // 0 0 2 Facturacion
-- Migration SQL that makes the change goes here.

-- tbl_cargo_crgo
CREATE TABLE portico.tbl_cargo_crgo
(
	crgo_pk BIGINT NOT NULL
	, crgo_codigo VARCHAR(10) NOT NULL
	, crgo_modulo_pk BIGINT NOT NULL

	, CONSTRAINT pk_crgo PRIMARY KEY (crgo_pk)
	, CONSTRAINT uq_crgo UNIQUE (crgo_codigo)

	, CONSTRAINT fk_crgo_modulo_pk FOREIGN KEY (crgo_modulo_pk)
		REFERENCES portico.tbl_parametro_prmt (prmt_pk)
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
COMMENT ON COLUMN portico.tbl_cargo_crgo.crgo_modulo_pk IS 'Identificador de Modulo al que pertenece la Tasa-Tarifa'
/



-- tbl_procedimiento_prcd
CREATE TABLE portico.tbl_procedimiento_prcd
(
	prcd_pk BIGINT NOT NULL
	, prcd_codigo VARCHAR(20) NOT NULL
	, prcd_crgo_pk BIGINT NOT NULL

	, CONSTRAINT pk_prcd PRIMARY KEY (prcd_pk)
	, CONSTRAINT uq_prcd UNIQUE (prcd_codigo)

	, CONSTRAINT fk_prcd_crgo_pk FOREIGN KEY (prcd_crgo_pk)
		REFERENCES portico.tbl_cargo_crgo (crgo_pk)
)
/

GRANT SELECT, INSERT, UPDATE, DELETE ON portico.tbl_procedimiento_prcd TO portico
/



-- tbl_aspecto_aspc
CREATE TABLE portico.tbl_aspecto_aspc
(
	aspc_pk BIGINT NOT NULL
	, aspc_codigo VARCHAR(10) NOT NULL
	, aspc_modulo_pk BIGINT NOT NULL

	, CONSTRAINT pk_aspc PRIMARY KEY (aspc_pk)
	, CONSTRAINT uq_aspc UNIQUE (aspc_codigo)

	, CONSTRAINT fk_aspc_modulo_pk FOREIGN KEY (aspc_modulo_pk)
		REFERENCES portico.tbl_parametro_prmt (prmt_pk)
)
/

GRANT SELECT, INSERT, UPDATE, DELETE ON portico.tbl_aspecto_aspc TO portico
/



-- tbl_aspecto_cargo_ascr
CREATE TABLE portico.tbl_aspecto_cargo_ascr
(
	ascr_aspc_pk BIGINT NOT NULL
	, ascr_crgo_pk BIGINT NOT NULL

	, CONSTRAINT pk_ascr PRIMARY KEY (ascr_aspc_pk, ascr_crgo_pk)

	, CONSTRAINT fk_ascr_aspc_pk FOREIGN KEY (ascr_aspc_pk)
		REFERENCES portico.tbl_aspecto_aspc (aspc_pk)
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
	, vlrc_pagador_pk BIGINT NOT NULL
	, vlrc_fref TIMESTAMP NOT NULL
	, vlrc_falta TIMESTAMP NOT NULL
	, vlrc_fini TIMESTAMP
	, vlrc_ffin TIMESTAMP
	, vlrc_importe DOUBLE PRECISION NOT NULL
	, vlrc_iva DOUBLE PRECISION NOT NULL
	, vlrc_info1 VARCHAR(100)
	, vlrc_info2 VARCHAR(100)
	, vlrc_info3 VARCHAR(100)
	, vlrc_info4 VARCHAR(100)
	, vlrc_info5 VARCHAR(100)

	, CONSTRAINT pk_vlrc PRIMARY KEY (vlrc_pk)

	, CONSTRAINT fk_vlrc_srvc_pk FOREIGN KEY (vlrc_srvc_pk)
		REFERENCES portico.tbl_servicio_srvc (srvc_pk)
	, CONSTRAINT fk_vlrc_crgo_pk FOREIGN KEY (vlrc_crgo_pk)
		REFERENCES portico.tbl_cargo_crgo (crgo_pk)
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
	, vlri_iva DOUBLE PRECISION NOT NULL

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
	, vlrl_prcd_pk BIGINT NOT NULL
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

	, vlrl_info1 VARCHAR(100)
	, vlrl_info2 VARCHAR(100)
	, vlrl_info3 VARCHAR(100)
	, vlrl_info4 VARCHAR(100)
	, vlrl_info5 VARCHAR(100)

	, CONSTRAINT pk_vlrl PRIMARY KEY (vlrl_pk)

	, CONSTRAINT fk_vlrl_vlrc_pk FOREIGN KEY (vlrl_vlrc_pk)
		REFERENCES portico.tbl_valoracion_vlrc (vlrc_pk)
	, CONSTRAINT fk_vlrl_prcd_pk FOREIGN KEY (vlrl_prcd_pk)
		REFERENCES portico.tbl_procedimiento_prcd (prcd_pk)
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
	, vlrd_prcd_pk BIGINT NOT NULL
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

	, vlrd_info1 VARCHAR(100)
	, vlrd_info2 VARCHAR(100)
	, vlrd_info3 VARCHAR(100)
	, vlrd_info4 VARCHAR(100)
	, vlrd_info5 VARCHAR(100)

	, CONSTRAINT pk_vlrd PRIMARY KEY (vlrd_pk)

	, CONSTRAINT fk_vlrd_vlrc_pk FOREIGN KEY (vlrd_vlrc_pk)
		REFERENCES portico.tbl_valoracion_vlrc (vlrc_pk)
	, CONSTRAINT fk_vlrd_vlrl_pk FOREIGN KEY (vlrd_vlrl_pk)
		REFERENCES portico.tbl_valoracion_lin_vlrl (vlrl_pk)
	, CONSTRAINT fk_vlrd_prcd_pk FOREIGN KEY (vlrd_prcd_pk)
		REFERENCES portico.tbl_procedimiento_prcd (prcd_pk)
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






-- //@UNDO
-- SQL to undo the change goes here.

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
DROP TABLE portico.tbl_aspecto_aspc
/
DROP TABLE portico.tbl_procedimiento_prcd
/
DROP TABLE portico.tbl_cargo_crgo
/
