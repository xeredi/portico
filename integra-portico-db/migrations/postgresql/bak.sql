/*
CREATE TABLE tbl_modulo_mdlo
(
	-- Identificador de modulo
	mdlo_pk bigint NOT NULL,
	-- Nombre de modulo
	mdlo_nombre bigint NOT NULL UNIQUE,
	PRIMARY KEY (mdlo_pk)
) WITHOUT OIDS
/


CREATE TABLE tbl_grupo_modulo_grmd
(
	-- Identificador de Grupo de usuarios
	grmd_grpo_pk bigint NOT NULL,
	-- Identificador de modulo
	grmd_mdlo_pk bigint NOT NULL,
	-- Indicador de si el modulo es visible para el grupo
	grmd_es_visible int NOT NULL,
	-- Indicador de si el grupo tiene permiso de acceso a las acciones de edicion del modulo
	grmd_es_editable int NOT NULL,
	PRIMARY KEY (grmd_grpo_pk)
) WITHOUT OIDS
/


CREATE TABLE tbl_accion_accn
(
	-- Identificador de accion
	accn_pk bigint NOT NULL,
	-- Identificador de modulo
	accn_mdlo_pk bigint NOT NULL,
	-- Ruta de la accion
	accn_path varchar(100) NOT NULL UNIQUE,
	-- Indicador de si la accion es o no de edicion
	accn_es_edicion int NOT NULL,
	PRIMARY KEY (accn_pk)
) WITHOUT OIDS
/


CREATE TABLE tbl_cargo_crgo
(
	-- Identificador de Cargo
	crgo_pk bigint NOT NULL,
	-- Identificador de Entidad
	crgo_tpsr_pk bigint NOT NULL,
	-- Código de Cargo
	crgo_codigo varchar(5) NOT NULL UNIQUE,
	-- Código de cargo normalizado (utilizado para operaciones internas)
	crgo_codigo_nrm varchar(5),
	PRIMARY KEY (crgo_pk)
) WITHOUT OIDS
/


CREATE TABLE tbl_cargo_entidad_cren
(
	-- Identificador de entidad asociada a un cargo
	crgo_pk bigint NOT NULL,
	-- Identificador de Cargo
	cren_crgo_pk bigint NOT NULL,
	PRIMARY KEY (crgo_pk)
) WITHOUT OIDS
/


CREATE TABLE tbl_valoracion_iva_vliv
(
	vliv_vlrc_pk bigint NOT NULL,
	-- Identificador de parametro
	vliv_ivat_pk bigint NOT NULL,
	vliv_importe double precision NOT NULL,
	vliv_iva double precision NOT NULL,
	PRIMARY KEY (vliv_vlrc_pk, vliv_ivat_pk)
) WITHOUT OIDS
/


CREATE TABLE tbl_valoracion_linea_vlln
(
	vlln_pk bigint NOT NULL,
	vlln_vlrc_pk bigint NOT NULL,
	vlln_padre_pk bigint NOT NULL,
	vllin_prcd_pk bigint NOT NULL,
	-- Identificador de parametro
	vllin_ivat_pk bigint NOT NULL,
	-- Numero de linea dentro de una valoracion
	vllin_numero int NOT NULL,
	vlin_importe double precision NOT NULL,
	-- Valor precio/% bonificacion/coeficiente
	vlin_valor double precision NOT NULL,
	PRIMARY KEY (vlln_pk)
) WITHOUT OIDS
/


CREATE TABLE tbl_valoracion_proceso_vlpr
(
	vlpr_pk bigint NOT NULL,
	vlpr_padre_pk bigint NOT NULL,
	-- Identificador de proceso
	vlpr_prbt_pk bigint NOT NULL,
	-- Identificador de servicio
	vlpr_srvc_pk bigint NOT NULL,
	-- Identificador de Subservicio
	vlpr_ssrv_pk bigint,
	vlpr_prcd_pk bigint NOT NULL,
	-- Identificador de parametro
	vlpr_ivat_pk bigint NOT NULL,
	-- Identificador de parametro
	vlpr_orga_pk bigint NOT NULL,
	vlpr_cod_exen char(1) NOT NULL,
	vlpr_suj_pasivo int NOT NULL,
	PRIMARY KEY (vlpr_pk)
) WITHOUT OIDS
/


CREATE TABLE tbl_procedimiento_prcd
(
	prcd_pk bigint NOT NULL,
	-- Identificador de Cargo
	prcd_crgo_pk bigint NOT NULL,
	-- Identificador de Entidad
	prcd_enti_pk bigint NOT NULL,
	prcd_codigo varchar(8) NOT NULL UNIQUE,
	prcd_tipo char(1) NOT NULL,
	PRIMARY KEY (prcd_pk)
) WITHOUT OIDS
/


CREATE TABLE tbl_aspecto_aspc
(
	aspc_pk bigint NOT NULL,
	aspc_codigo varchar(8) NOT NULL UNIQUE,
	PRIMARY KEY (aspc_pk)
) WITHOUT OIDS
/


CREATE TABLE tbl_valoracion_vlrc
(
	vlrc_pk bigint NOT NULL,
	-- Identificador de servicio
	vlrc_srvc_pk bigint NOT NULL,
	-- Identificador de parametro
	vlrc_orga_pk bigint NOT NULL,
	vlrc_aspc_pk bigint NOT NULL,
	-- Identificador de proceso
	vlrc_prbt_pk bigint NOT NULL,
	vlrc_freferencia timestamp NOT NULL,
	vlrc_falta timestamp NOT NULL,
	vlrc_finicio timestamp NOT NULL,
	vlrc_ffin timestamp NOT NULL,
	vlrc_importe double precision NOT NULL,
	vlrc_iva double precision NOT NULL,
	vlrc_suj_pas int NOT NULL,
	vlrc_info1 varchar(100),
	vlrc_info2 varchar(100),
	vlrc_info3 varchar(100),
	vlrc_info4 varchar(100),
	vlrc_info5 varchar(100),
	vlrc_observ varchar(200),
	PRIMARY KEY (vlrc_pk)
) WITHOUT OIDS
/


CREATE TABLE tbl_valoracion_detalle_vldt
(
	vldt_pk bigint NOT NULL,
	vldt_padre_pk bigint NOT NULL,
	vldt_vlln_pk bigint NOT NULL,
	-- Identificador de Subservicio
	vldt_ssrv_pk bigint,
	vldt_importe double precision NOT NULL,
	PRIMARY KEY (vldt_pk)
) WITHOUT OIDS
/


CREATE TABLE tbl_cargo_composicion_crcm
(
	-- Identificador de Cargo
	crcm_crgo_padre_pk bigint NOT NULL,
	-- Identificador de Cargo
	crcm_crgo_hijo_pk bigint NOT NULL,
	PRIMARY KEY (crcm_crgo_padre_pk, crcm_crgo_hijo_pk)
) WITHOUT OIDS
/


CREATE TABLE tbl_aspecto_cargo_ascr
(
	ascr_aspc_pk bigint NOT NULL,
	-- Identificador de Cargo
	ascr_crgo_pk bigint NOT NULL,
	PRIMARY KEY (ascr_aspc_pk, ascr_crgo_pk)
) WITHOUT OIDS
/


CREATE TABLE tbl_servicio_cargo_srcr
(
	-- Identificador de servicio
	srcr_srvc_pk bigint NOT NULL,
	-- Identificador de Cargo
	srcr_crgo_pk bigint NOT NULL,
	-- Identificador de Subservicio
	srcr_ssrv_pk bigint,
	srcr_fini timestamp NOT NULL,
	srcr_ffin timestamp NOT NULL,
	srcr_vlrc_pk bigint NOT NULL
) WITHOUT OIDS
/








CREATE INDEX ix_prmn_prbt ON tbl_proceso_mensaje_prmn (prmn_prbt_pk)
/
-- Indice de los parametros por tipo de parametro
CREATE INDEX ix_prmt_tppr_pk ON tbl_parametro_prmt (prmt_tppr_pk)
/
CREATE INDEX ix_tpss_tpsr_pk ON tbl_tipo_subservicio_tpss (tpss_tpsr_pk)
/
CREATE INDEX ix_pepr_tpes ON tbl_estadistica_estd (estd_pepr_pk, estd_tpes_pk)
/
CREATE INDEX ix_prvr_prmt_pk ON tbl_parametro_version_prvr (prvr_prmt_pk)
/
CREATE INDEX ix_srvc_tpsr ON tbl_servicio_srvc (srvc_tpsr_pk)
/
CREATE INDEX ix_enen_entih_pk ON tbl_entidad_entidad_enen (enen_entih_pk)
/
CREATE INDEX IX_ssss_ssrvh_pk ON tbl_subservicio_subservicio_ssss (ssss_ssrvh_pk)
/
CREATE INDEX ix_esdt_prmt_pk ON tbl_estadistica_dato_esdt (esdt_prmt_pk)
/
CREATE INDEX ix_ssdt_prmt_pk ON tbl_subservicio_dato_ssdt (ssdt_prmt_pk)
/
CREATE INDEX ix_ssdt_cadena ON tbl_subservicio_dato_ssdt (ssdt_cadena)
/
CREATE INDEX ix_srdt_prmt_pk ON tbl_servicio_dato_srdt (srdt_prmt_pk)
/
CREATE INDEX ix_srdt_cadena ON tbl_servicio_dato_srdt (srdt_cadena)
/
CREATE INDEX ix_prdt_prmt_pk ON tbl_parametro_dato_prdt (prdt_prmt_pk)
/
CREATE INDEX ix_prdt_cadena ON tbl_parametro_dato_prdt (prdt_cadena)
/
CREATE INDEX ix_spvr_sprm_pk ON tbl_subparametro_version_spvr (spvr_sprm_pk)
/
CREATE INDEX ix_vlpr_prbt_pk ON tbl_valoracion_proceso_vlpr (vlpr_prbt_pk)
/
CREATE INDEX ix_ssrv_srvc_pk ON tbl_subservicio_ssrv (ssrv_srvc_pk)
/
CREATE INDEX ix_ssrv_tpss_pk ON tbl_subservicio_ssrv (ssrv_tpss_pk)
/
*/
