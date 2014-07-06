















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


CREATE TABLE tbl_configuracion_valor_idioma_cnvi
(
	cnvi_cnid_pk bigint NOT NULL,
	cnvi_cnci_pk bigint NOT NULL,
	cnvi_valor varchar(200) NOT NULL,
	PRIMARY KEY (cnvi_cnid_pk, cnvi_cnci_pk)
) WITHOUT OIDS
/


CREATE TABLE tbl_configuracion_idioma_cnid
(
	cnid_pk bigint NOT NULL,
	cnid_codigo varchar(5) NOT NULL UNIQUE,
	cnid_descripcion varchar(100),
	PRIMARY KEY (cnid_pk)
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




ALTER TABLE tbl_grupo_modulo_grmd
	ADD FOREIGN KEY (grmd_grpo_pk)
	REFERENCES tbl_grupo_grpo (grpo_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_usuario_grupo_usgr
	ADD FOREIGN KEY (usgr_grpo_pk)
	REFERENCES tbl_grupo_grpo (grpo_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_grupo_modulo_grmd
	ADD FOREIGN KEY (grmd_mdlo_pk)
	REFERENCES tbl_modulo_mdlo (mdlo_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_accion_accn
	ADD FOREIGN KEY (accn_mdlo_pk)
	REFERENCES tbl_modulo_mdlo (mdlo_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_usuario_grupo_usgr
	ADD FOREIGN KEY (usgr_usro_pk)
	REFERENCES tbl_usuario_usro (usro_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_proceso_parametro_prpm
	ADD FOREIGN KEY (prpm_prbt_pk)
	REFERENCES tbl_proceso_batch_prbt (prbt_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_proceso_mensaje_prmn
	ADD FOREIGN KEY (prmn_prbt_pk)
	REFERENCES tbl_proceso_batch_prbt (prbt_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_valoracion_proceso_vlpr
	ADD FOREIGN KEY (vlpr_prbt_pk)
	REFERENCES tbl_proceso_batch_prbt (prbt_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_valoracion_vlrc
	ADD FOREIGN KEY (vlrc_prbt_pk)
	REFERENCES tbl_proceso_batch_prbt (prbt_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_proceso_archivo_prar
	ADD FOREIGN KEY (prar_prbt_pk)
	REFERENCES tbl_proceso_batch_prbt (prbt_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_proceso_item_prit
	ADD FOREIGN KEY (prit_prbt_pk)
	REFERENCES tbl_proceso_batch_prbt (prbt_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_cuadro_mes_cdms
	ADD FOREIGN KEY (cdms_navt_pk)
	REFERENCES tbl_parametro_prmt (prmt_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_cuadro_mes_cdms
	ADD FOREIGN KEY (cdms_opet_pk)
	REFERENCES tbl_parametro_prmt (prmt_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_cuadro_mes_cdms
	ADD FOREIGN KEY (cdms_pais_pk)
	REFERENCES tbl_parametro_prmt (prmt_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_parametro_dato_prdt
	ADD FOREIGN KEY (prdt_prmt_pk)
	REFERENCES tbl_parametro_prmt (prmt_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_estadistica_estd
	ADD FOREIGN KEY (estd_autp_pk)
	REFERENCES tbl_parametro_prmt (prmt_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_valoracion_linea_vlln
	ADD FOREIGN KEY (vllin_ivat_pk)
	REFERENCES tbl_parametro_prmt (prmt_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_valoracion_vlrc
	ADD FOREIGN KEY (vlrc_orga_pk)
	REFERENCES tbl_parametro_prmt (prmt_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_subparametro_dato_spdt
	ADD FOREIGN KEY (spdt_prmt_pk)
	REFERENCES tbl_parametro_prmt (prmt_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_valoracion_proceso_vlpr
	ADD FOREIGN KEY (vlpr_ivat_pk)
	REFERENCES tbl_parametro_prmt (prmt_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_servicio_dato_srdt
	ADD FOREIGN KEY (srdt_prmt_pk)
	REFERENCES tbl_parametro_prmt (prmt_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_periodo_proceso_pepr
	ADD FOREIGN KEY (pepr_autp_pk)
	REFERENCES tbl_parametro_prmt (prmt_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_servicio_srvc
	ADD FOREIGN KEY (srvc_subp_pk)
	REFERENCES tbl_parametro_prmt (prmt_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_estadistica_dato_esdt
	ADD FOREIGN KEY (esdt_prmt_pk)
	REFERENCES tbl_parametro_prmt (prmt_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_subservicio_dato_ssdt
	ADD FOREIGN KEY (ssdt_prmt_pk)
	REFERENCES tbl_parametro_prmt (prmt_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_servicio_secuencia_srsc
	ADD FOREIGN KEY (srsc_subp_pk)
	REFERENCES tbl_parametro_prmt (prmt_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_valoracion_iva_vliv
	ADD FOREIGN KEY (vliv_ivat_pk)
	REFERENCES tbl_parametro_prmt (prmt_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_valoracion_proceso_vlpr
	ADD FOREIGN KEY (vlpr_orga_pk)
	REFERENCES tbl_parametro_prmt (prmt_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_cuadro_mes_cdms
	ADD FOREIGN KEY (cdms_cocu_pk)
	REFERENCES tbl_parametro_prmt (prmt_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_parametro_version_prvr
	ADD FOREIGN KEY (prvr_prmt_pk)
	REFERENCES tbl_parametro_prmt (prmt_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_subparametro_sprm
	ADD FOREIGN KEY (sprm_prmt_dep_pk)
	REFERENCES tbl_parametro_prmt (prmt_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_subparametro_sprm
	ADD FOREIGN KEY (sprm_prmt_pk)
	REFERENCES tbl_parametro_prmt (prmt_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_configuracion_valor_cnvl
	ADD FOREIGN KEY (cnvl_cncl_pk)
	REFERENCES tbl_configuracion_clave_cncl (cncl_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_configuracion_valor_idioma_cnvi
	ADD FOREIGN KEY (cnvi_cnci_pk)
	REFERENCES tbl_configuracion_clave_idioma_cnci (cnci_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_configuracion_valor_idioma_cnvi
	ADD FOREIGN KEY (cnvi_cnid_pk)
	REFERENCES tbl_configuracion_idioma_cnid (cnid_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_configuracion_entorno_cnen
	ADD FOREIGN KEY (cnen_cnid_pk)
	REFERENCES tbl_configuracion_idioma_cnid (cnid_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_configuracion_valor_cnvl
	ADD FOREIGN KEY (cnvl_cnen_pk)
	REFERENCES tbl_configuracion_entorno_cnen (cnen_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_estadistica_dato_esdt
	ADD FOREIGN KEY (esdt_tpdt_pk)
	REFERENCES tbl_tipo_dato_tpdt (tpdt_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_tipo_parametro_tppr
	ADD FOREIGN KEY (tppr_tpdt_nombre_pk)
	REFERENCES tbl_tipo_dato_tpdt (tpdt_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_parametro_dato_prdt
	ADD FOREIGN KEY (prdt_tpdt_pk)
	REFERENCES tbl_tipo_dato_tpdt (tpdt_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_servicio_dato_srdt
	ADD FOREIGN KEY (srdt_tpdt_pk)
	REFERENCES tbl_tipo_dato_tpdt (tpdt_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_subparametro_dato_spdt
	ADD FOREIGN KEY (spdt_tpdt_pk)
	REFERENCES tbl_tipo_dato_tpdt (tpdt_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_tipo_subservicio_tpss
	ADD FOREIGN KEY (tpss_tpdt_estado_pk)
	REFERENCES tbl_tipo_dato_tpdt (tpdt_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_subservicio_dato_ssdt
	ADD FOREIGN KEY (ssdt_tpdt_pk)
	REFERENCES tbl_tipo_dato_tpdt (tpdt_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_tipo_servicio_tpsr
	ADD FOREIGN KEY (tpsr_tpdt_estado_pk)
	REFERENCES tbl_tipo_dato_tpdt (tpdt_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_entidad_tipo_dato_entd
	ADD FOREIGN KEY (entd_tpdt_pk)
	REFERENCES tbl_tipo_dato_tpdt (tpdt_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_codigo_referencia_cdrf
	ADD FOREIGN KEY (cdrf_tpdt_pk)
	REFERENCES tbl_tipo_dato_tpdt (tpdt_pk)
	ON UPDATE RESTRICT
	ON DELETE CASCADE

/


ALTER TABLE tbl_aspecto_cargo_ascr
	ADD FOREIGN KEY (ascr_crgo_pk)
	REFERENCES tbl_cargo_crgo (crgo_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_procedimiento_prcd
	ADD FOREIGN KEY (prcd_crgo_pk)
	REFERENCES tbl_cargo_crgo (crgo_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_servicio_cargo_srcr
	ADD FOREIGN KEY (srcr_crgo_pk)
	REFERENCES tbl_cargo_crgo (crgo_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_cargo_composicion_crcm
	ADD FOREIGN KEY (crcm_crgo_padre_pk)
	REFERENCES tbl_cargo_crgo (crgo_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_cargo_composicion_crcm
	ADD FOREIGN KEY (crcm_crgo_hijo_pk)
	REFERENCES tbl_cargo_crgo (crgo_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_cargo_entidad_cren
	ADD FOREIGN KEY (cren_crgo_pk)
	REFERENCES tbl_cargo_crgo (crgo_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_subservicio_ssrv
	ADD FOREIGN KEY (ssrv_tpss_pk)
	REFERENCES tbl_tipo_subservicio_tpss (tpss_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_entidad_accion_enac
	ADD FOREIGN KEY (enac_enti_pk)
	REFERENCES tbl_entidad_enti (enti_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_tipo_dato_tpdt
	ADD FOREIGN KEY (tpdt_enti_pk)
	REFERENCES tbl_entidad_enti (enti_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_entidad_entidad_enen
	ADD FOREIGN KEY (enen_entip_pk)
	REFERENCES tbl_entidad_enti (enti_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_tipo_subservicio_tpss
	ADD FOREIGN KEY (tpss_pk)
	REFERENCES tbl_entidad_enti (enti_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_entidad_grupo_dato_engd
	ADD FOREIGN KEY (engd_enti_pk)
	REFERENCES tbl_entidad_enti (enti_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_tipo_parametro_tppr
	ADD FOREIGN KEY (tppr_pk)
	REFERENCES tbl_entidad_enti (enti_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_entidad_entidad_enen
	ADD FOREIGN KEY (enen_entih_pk)
	REFERENCES tbl_entidad_enti (enti_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_entidad_tipo_dato_entd
	ADD FOREIGN KEY (entd_enti_pk)
	REFERENCES tbl_entidad_enti (enti_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_procedimiento_prcd
	ADD FOREIGN KEY (prcd_enti_pk)
	REFERENCES tbl_entidad_enti (enti_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_tipo_servicio_tpsr
	ADD FOREIGN KEY (tpsr_pk)
	REFERENCES tbl_entidad_enti (enti_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_tipo_subparametro_tpsp
	ADD FOREIGN KEY (tpsp_pk)
	REFERENCES tbl_entidad_enti (enti_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_tipo_estadistica_tpes
	ADD FOREIGN KEY (tpes_pk)
	REFERENCES tbl_entidad_enti (enti_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_estadistica_estd
	ADD FOREIGN KEY (estd_pepr_pk)
	REFERENCES tbl_periodo_proceso_pepr (pepr_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_cuadro_mes_cdms
	ADD FOREIGN KEY (cdms_pepr_pk)
	REFERENCES tbl_periodo_proceso_pepr (pepr_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_estadistica_dato_esdt
	ADD FOREIGN KEY (esdt_estd_pk)
	REFERENCES tbl_estadistica_estd (estd_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_estadistica_estd
	ADD FOREIGN KEY (estd_tpes_pk)
	REFERENCES tbl_tipo_estadistica_tpes (tpes_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_tipo_subparametro_tpsp
	ADD FOREIGN KEY (tpsp_tppr_pk)
	REFERENCES tbl_tipo_parametro_tppr (tppr_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_parametro_prmt
	ADD FOREIGN KEY (prmt_tppr_pk)
	REFERENCES tbl_tipo_parametro_tppr (tppr_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_tipo_subparametro_tpsp
	ADD FOREIGN KEY (tpsp_tppr_dep_pk)
	REFERENCES tbl_tipo_parametro_tppr (tppr_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_subparametro_version_spvr
	ADD FOREIGN KEY (spvr_sprm_pk)
	REFERENCES tbl_subparametro_sprm (sprm_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_subparametro_sprm
	ADD FOREIGN KEY (sprm_tpsp_pk)
	REFERENCES tbl_tipo_subparametro_tpsp (tpsp_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_parametro_i18n_p18n
	ADD FOREIGN KEY (p18n_prvr_pk)
	REFERENCES tbl_parametro_version_prvr (prvr_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_parametro_dato_prdt
	ADD FOREIGN KEY (prdt_prvr_pk)
	REFERENCES tbl_parametro_version_prvr (prvr_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_subservicio_ssrv
	ADD FOREIGN KEY (ssrv_srvc_pk)
	REFERENCES tbl_servicio_srvc (srvc_pk)
	ON UPDATE RESTRICT
	ON DELETE CASCADE

/


ALTER TABLE tbl_servicio_dato_srdt
	ADD FOREIGN KEY (srdt_srvc_pk)
	REFERENCES tbl_servicio_srvc (srvc_pk)
	ON UPDATE RESTRICT
	ON DELETE CASCADE

/


ALTER TABLE tbl_valoracion_proceso_vlpr
	ADD FOREIGN KEY (vlpr_srvc_pk)
	REFERENCES tbl_servicio_srvc (srvc_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_servicio_dato_srdt
	ADD FOREIGN KEY (srdt_srvc_dep_pk)
	REFERENCES tbl_servicio_srvc (srvc_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_valoracion_vlrc
	ADD FOREIGN KEY (vlrc_srvc_pk)
	REFERENCES tbl_servicio_srvc (srvc_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_servicio_cargo_srcr
	ADD FOREIGN KEY (srcr_srvc_pk)
	REFERENCES tbl_servicio_srvc (srvc_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_subparametro_dato_spdt
	ADD FOREIGN KEY (spdt_spvr_pk)
	REFERENCES tbl_subparametro_version_spvr (spvr_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_valoracion_detalle_vldt
	ADD FOREIGN KEY (vldt_vlln_pk)
	REFERENCES tbl_valoracion_linea_vlln (vlln_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_valoracion_linea_vlln
	ADD FOREIGN KEY (vlln_padre_pk)
	REFERENCES tbl_valoracion_linea_vlln (vlln_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_valoracion_proceso_vlpr
	ADD FOREIGN KEY (vlpr_padre_pk)
	REFERENCES tbl_valoracion_proceso_vlpr (vlpr_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_valoracion_proceso_vlpr
	ADD FOREIGN KEY (vlpr_prcd_pk)
	REFERENCES tbl_procedimiento_prcd (prcd_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_valoracion_linea_vlln
	ADD FOREIGN KEY (vllin_prcd_pk)
	REFERENCES tbl_procedimiento_prcd (prcd_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_aspecto_cargo_ascr
	ADD FOREIGN KEY (ascr_aspc_pk)
	REFERENCES tbl_aspecto_aspc (aspc_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_valoracion_vlrc
	ADD FOREIGN KEY (vlrc_aspc_pk)
	REFERENCES tbl_aspecto_aspc (aspc_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_servicio_cargo_srcr
	ADD FOREIGN KEY (srcr_vlrc_pk)
	REFERENCES tbl_valoracion_vlrc (vlrc_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_valoracion_linea_vlln
	ADD FOREIGN KEY (vlln_vlrc_pk)
	REFERENCES tbl_valoracion_vlrc (vlrc_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_valoracion_iva_vliv
	ADD FOREIGN KEY (vliv_vlrc_pk)
	REFERENCES tbl_valoracion_vlrc (vlrc_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_valoracion_detalle_vldt
	ADD FOREIGN KEY (vldt_padre_pk)
	REFERENCES tbl_valoracion_detalle_vldt (vldt_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_valoracion_detalle_vldt
	ADD FOREIGN KEY (vldt_ssrv_pk)
	REFERENCES tbl_subservicio_ssrv (ssrv_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_subservicio_dato_ssdt
	ADD FOREIGN KEY (ssdt_ssrv_pk)
	REFERENCES tbl_subservicio_ssrv (ssrv_pk)
	ON UPDATE RESTRICT
	ON DELETE CASCADE

/


ALTER TABLE tbl_subservicio_subservicio_ssss
	ADD FOREIGN KEY (ssss_ssrvp_pk)
	REFERENCES tbl_subservicio_ssrv (ssrv_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_valoracion_proceso_vlpr
	ADD FOREIGN KEY (vlpr_ssrv_pk)
	REFERENCES tbl_subservicio_ssrv (ssrv_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_subservicio_subservicio_ssss
	ADD FOREIGN KEY (ssss_ssrvh_pk)
	REFERENCES tbl_subservicio_ssrv (ssrv_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_servicio_cargo_srcr
	ADD FOREIGN KEY (srcr_ssrv_pk)
	REFERENCES tbl_subservicio_ssrv (ssrv_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_servicio_secuencia_srsc
	ADD FOREIGN KEY (srsc_tpsr_pk)
	REFERENCES tbl_tipo_servicio_tpsr (tpsr_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_tipo_subservicio_tpss
	ADD FOREIGN KEY (tpss_tpsr_pk)
	REFERENCES tbl_tipo_servicio_tpsr (tpsr_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_servicio_srvc
	ADD FOREIGN KEY (srvc_tpsr_pk)
	REFERENCES tbl_tipo_servicio_tpsr (tpsr_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

/


ALTER TABLE tbl_cargo_crgo
	ADD FOREIGN KEY (crgo_tpsr_pk)
	REFERENCES tbl_tipo_servicio_tpsr (tpsr_pk)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT

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
