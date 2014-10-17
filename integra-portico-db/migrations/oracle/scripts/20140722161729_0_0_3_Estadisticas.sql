-- // 0 0 2 Facturacion
-- Migration SQL that makes the change goes here.



-- tbl_estadistica_trim_estr
CREATE TABLE tbl_estadistica_trim_estr
(
	estr_pk NUMBER(19) NOT NULL
	, estr_autp_pk NUMBER(19) NOT NULL
	, estr_anio INT NOT NULL
	, estr_trimestre INT NOT NULL
	, estr_fref TIMESTAMP NOT NULL
	, estr_falta TIMESTAMP NOT NULL

	, CONSTRAINT pk_estr PRIMARY KEY (estr_pk)
	, CONSTRAINT uq_estr UNIQUE (estr_autp_pk, estr_anio, estr_trimestre)

	, CONSTRAINT fk_estr_autp_pk FOREIGN KEY (estr_autp_pk)
		REFERENCES tbl_parametro_prmt (prmt_pk)
)
\

CREATE OR REPLACE SYNONYM portico.tbl_estadistica_trim_estr FOR porticoadm.tbl_estadistica_trim_estr\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_estadistica_trim_estr TO portico\

COMMENT ON TABLE tbl_estadistica_trim_estr IS 'Estadistica trimestral de una AP'\
COMMENT ON COLUMN tbl_estadistica_trim_estr.estr_pk IS 'Identificador de Estadistica Trimestral'\
COMMENT ON COLUMN tbl_estadistica_trim_estr.estr_autp_pk IS 'Identificador de A. P.'\
COMMENT ON COLUMN tbl_estadistica_trim_estr.estr_anio IS 'Anio de los datos de origen'\
COMMENT ON COLUMN tbl_estadistica_trim_estr.estr_trimestre IS 'Trimestre de los datos de origen'\
COMMENT ON COLUMN tbl_estadistica_trim_estr.estr_fref IS 'Fecha de Referencia utilizada para obtener los datos de los maestros asociados'\
COMMENT ON COLUMN tbl_estadistica_trim_estr.estr_falta IS 'Fecha de alta de la Estadistica Trimestral'\



-- tbl_cuadro_trim_cdtr
CREATE TABLE tbl_cuadro_trim_cdtr
(
	cdtr_pk 		NUMBER(19) 				CONSTRAINT nn_cdtr_pk 			NOT NULL
	, cdtr_estr_pk 	NUMBER(19) 				CONSTRAINT nn_cdtr_estr_pk 	NOT NULL
	, cdtr_cocu_pk 	NUMBER(19) 				CONSTRAINT nn_cdtr_cocu_pk 	NOT NULL
	, cdtr_opet_pk 	NUMBER(19) 				CONSTRAINT nn_cdtr_opet_pk 	NOT NULL
	, cdtr_cantidad DOUBLE PRECISION 	CONSTRAINT nn_cdtr_cantidad 	NOT NULL

	, CONSTRAINT pk_cdtr PRIMARY KEY (cdtr_pk)
	, CONSTRAINT uq_cdtr UNIQUE (cdtr_estr_pk, cdtr_cocu_pk, cdtr_opet_pk)

	, CONSTRAINT fk_cdtr_estr_pk FOREIGN KEY (cdtr_estr_pk)
		REFERENCES tbl_estadistica_trim_estr (estr_pk)
	, CONSTRAINT fk_cdtr_cocu_pk FOREIGN KEY (cdtr_cocu_pk)
		REFERENCES tbl_parametro_prmt (prmt_pk)
	, CONSTRAINT fk_cdtr_opet_pk FOREIGN KEY (cdtr_opet_pk)
		REFERENCES tbl_parametro_prmt (prmt_pk)
)
\

CREATE OR REPLACE SYNONYM portico.tbl_cuadro_trim_cdtr FOR porticoadm.tbl_cuadro_trim_cdtr\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_cuadro_trim_cdtr TO portico\

COMMENT ON TABLE tbl_cuadro_trim_cdtr IS 'Datos del Cuadro trimestral de la Estadistica de una AP'\
COMMENT ON COLUMN tbl_cuadro_trim_cdtr.cdtr_pk IS 'Identificador de Dato del Cuadro trimestral'\
COMMENT ON COLUMN tbl_cuadro_trim_cdtr.cdtr_estr_pk IS 'Identificador de Estadistica Trimestral a la que pertenece el dato del cuadro'\
COMMENT ON COLUMN tbl_cuadro_trim_cdtr.cdtr_cocu_pk IS 'Identificador de Concepto de Cuadro trimestral'\
COMMENT ON COLUMN tbl_cuadro_trim_cdtr.cdtr_opet_pk IS 'Identificador de Tipo de Operacion'\
COMMENT ON COLUMN tbl_cuadro_trim_cdtr.cdtr_cantidad IS 'Valor de Dato del Cuadro trimestral'\










-- //@UNDO
-- SQL to undo the change goes here.

DROP TABLE tbl_cuadro_trim_cdtr\
DROP TABLE tbl_estadistica_trim_estr\
