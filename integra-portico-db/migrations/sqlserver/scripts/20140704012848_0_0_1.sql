-- // 0.0.1
-- Migration SQL that makes the change goes here.

-- tbl_conf_clave_cncl
CREATE TABLE tbl_conf_clave_cncl
(
	cncl_pk BIGINT NOT NULL
	, cncl_clave VARCHAR(80) NOT NULL
	, cncl_tipo_valor VARCHAR(2) NOT NULL
	, cncl_valor_defecto VARCHAR(200) NOT NULL

	, CONSTRAINT pk_cncl PRIMARY KEY (cncl_pk)
	, CONSTRAINT uq_cncl UNIQUE (cncl_clave)
)
/

exec sp_AddExtendedProperty 'Description', 'Claves de Parametros de Configuracion'
	, 'SCHEMA', 'dbo', 'TABLE', 'tbl_conf_clave_cncl'
exec sp_AddExtendedProperty 'Description', 'Identificador de clave'
	, 'SCHEMA', 'dbo', 'TABLE', 'tbl_conf_clave_cncl', 'COLUMN', 'cncl_pk'
exec sp_AddExtendedProperty 'Description', 'Tipo de Valor del parametro (Fecha, numero, ...)'
	, 'SCHEMA', 'dbo', 'TABLE', 'tbl_conf_clave_cncl', 'COLUMN', 'cncl_tipo_valor'
exec sp_AddExtendedProperty 'Description', 'Clave del parametro'
	, 'SCHEMA', 'dbo', 'TABLE', 'tbl_conf_clave_cncl', 'COLUMN', 'cncl_clave'
exec sp_AddExtendedProperty 'Description', 'Valor por defecto del parametro'
	, 'SCHEMA', 'dbo', 'TABLE', 'tbl_conf_clave_cncl', 'COLUMN', 'cncl_valor_defecto'
/



-- tbl_conf_clave_i18n_cnci
CREATE TABLE tbl_conf_clave_i18n_cnci
(
	cnci_pk BIGINT NOT NULL
	, cnci_clave VARCHAR(80) NOT NULL
	, cnci_valor_defecto VARCHAR(200) NOT NULL

	, CONSTRAINT pk_cnci PRIMARY KEY (cnci_pk)
	, CONSTRAINT uq_cnci UNIQUE (cnci_clave)
)
/



-- tbl_configuracion_idioma_cnid
CREATE TABLE tbl_configuracion_idioma_cnid
(
	cnid_pk BIGINT NOT NULL
	, cnid_codigo VARCHAR(5) NOT NULL
	, cnid_descripcion VARCHAR(100)

	, CONSTRAINT pk_cnid PRIMARY KEY (cnid_pk)
	, CONSTRAINT uq_cnid UNIQUE (cnid_codigo)
)
/



-- tbl_configuracion_entorno_cnen
CREATE TABLE tbl_configuracion_entorno_cnen
(
	cnen_pk BIGINT NOT NULL
	, cnen_codigo VARCHAR(8) NOT NULL
	, cnen_nombre VARCHAR(50) NOT NULL

	, CONSTRAINT pk_cnen PRIMARY KEY (cnen_pk)
	, CONSTRAINT uq_cnen UNIQUE (cnen_codigo)
)
/



-- tbl_configuracion_valor_cnvl
CREATE TABLE tbl_configuracion_valor_cnvl
(
	cnvl_cnen_pk BIGINT NOT NULL
	, cnvl_cncl_pk BIGINT NOT NULL
	, cnvl_valor VARCHAR(200) NOT NULL

	, CONSTRAINT pk_cnvl PRIMARY KEY (cnvl_cnen_pk, cnvl_cncl_pk)
	, CONSTRAINT fk_cnvl_cnen_pk FOREIGN KEY (cnvl_cnen_pk)
		REFERENCES tbl_configuracion_entorno_cnen (cnen_pk)
	, CONSTRAINT fk_cnvl_cncl_pk FOREIGN KEY (cnvl_cncl_pk)
		REFERENCES tbl_conf_clave_cncl (cncl_pk)
)
/



-- tbl_conf_valor_i18n_cnvi
CREATE TABLE tbl_conf_valor_i18n_cnvi
(
	cnvi_cnid_pk BIGINT NOT NULL
	, cnvi_cnci_pk BIGINT NOT NULL
	, cnvi_valor VARCHAR(200) NOT NULL

	, CONSTRAINT pk_cnvi PRIMARY KEY (cnvi_cnid_pk, cnvi_cnci_pk)
	, CONSTRAINT fk_cnvi_cnid_pk FOREIGN KEY (cnvi_cnid_pk)
		REFERENCES tbl_configuracion_idioma_cnid (cnid_pk)
	, CONSTRAINT fk_cnvi_cnci_pk FOREIGN KEY (cnvi_cnci_pk)
		REFERENCES tbl_conf_clave_i18n_cnci (cnci_pk)
)
/



-- tbl_ig
CREATE TABLE tbl_ig
(
	ig_nombre VARCHAR(30) NOT NULL
	, ig_inicio BIGINT NOT NULL
	, ig_fin BIGINT
	, ig_incremento BIGINT NOT NULL
	, ig_cache BIGINT NOT NULL
	, ig_ultimo BIGINT NOT NULL

	, CONSTRAINT pk_ig PRIMARY KEY (ig_nombre)
)
/



-- tbl_usuario_usro
CREATE TABLE tbl_usuario_usro
(
	usro_pk BIGINT NOT NULL
	, usro_login VARCHAR(50) NOT NULL
	, usro_contrasenia VARCHAR(50) NOT NULL
	, usro_nombre VARCHAR(50) NOT NULL

	, CONSTRAINT pk_usro PRIMARY KEY (usro_pk)
	, CONSTRAINT uq_usro UNIQUE (usro_login)
)
/



-- tbl_grupo_grpo
CREATE TABLE tbl_grupo_grpo
(
	grpo_pk BIGINT NOT NULL
	, grpo_nombre VARCHAR(50) NOT NULL

	, CONSTRAINT pk_grpo PRIMARY KEY (grpo_pk)
	, CONSTRAINT uq_grpo UNIQUE (grpo_nombre)
)
/



-- tbl_usuario_grupo_usgr
CREATE TABLE tbl_usuario_grupo_usgr
(
	usgr_usro_pk BIGINT NOT NULL
	, usgr_grpo_pk BIGINT NOT NULL

	, CONSTRAINT pk_usgr PRIMARY KEY (usgr_usro_pk, usgr_grpo_pk)
	, CONSTRAINT fk_usgr_usro_pk FOREIGN KEY (usgr_usro_pk)
		REFERENCES tbl_usuario_usro (usro_pk)
	, CONSTRAINT fk_usgr_grpo_pk FOREIGN KEY (usgr_grpo_pk)
		REFERENCES tbl_grupo_grpo (grpo_pk)
)
/



-- tbl_entidad_enti
CREATE TABLE tbl_entidad_enti
(
	enti_pk BIGINT NOT NULL
	, enti_codigo VARCHAR(50) NOT NULL
	, enti_tipo char(1) NOT NULL
	, enti_cmd_alta int NOT NULL
	, enti_cmd_baja int NOT NULL
	, enti_cmd_edicion int NOT NULL
	, enti_cmd_duplicado int NOT NULL
	, enti_nombre VARCHAR(50) NOT NULL

	, CONSTRAINT pk_enti PRIMARY KEY (enti_pk)
	, CONSTRAINT uq_enti_codigo UNIQUE (enti_codigo)
	, CONSTRAINT uq_enti_nombre UNIQUE (enti_nombre)
)
/



-- tbl_entidad_entidad_enen
CREATE TABLE tbl_entidad_entidad_enen
(
	enen_entip_pk BIGINT NOT NULL
	, enen_entih_pk BIGINT NOT NULL
	, enen_orden int NOT NULL

	, CONSTRAINT pk_enen PRIMARY KEY (enen_entip_pk, enen_entih_pk)
	, CONSTRAINT fk_enen_entip_pk FOREIGN KEY (enen_entip_pk)
		REFERENCES tbl_entidad_enti (enti_pk)
	, CONSTRAINT fk_enen_entih_pk FOREIGN KEY (enen_entih_pk)
		REFERENCES tbl_entidad_enti (enti_pk)
)
/



-- tbl_tipo_dato_tpdt
CREATE TABLE tbl_tipo_dato_tpdt
(
	tpdt_pk BIGINT NOT NULL
	, tpdt_codigo VARCHAR(50) NOT NULL
	, tpdt_nombre VARCHAR(50) NOT NULL
	, tpdt_tipo_html VARCHAR(2) NOT NULL
	, tpdt_tipo_elemento VARCHAR(2) NOT NULL
	, tpdt_enti_pk BIGINT

	, CONSTRAINT pk_tpdt PRIMARY KEY (tpdt_pk)
	, CONSTRAINT uq_tpdt UNIQUE (tpdt_codigo)
	, CONSTRAINT fk_tpdt_enti_pk FOREIGN KEY (tpdt_enti_pk)
		REFERENCES tbl_entidad_enti (enti_pk)
)
/



-- tbl_codigo_referencia_cdrf
CREATE TABLE tbl_codigo_referencia_cdrf
(
	cdrf_tpdt_pk BIGINT NOT NULL
	, cdrf_valor VARCHAR(10) NOT NULL
	, cdrf_orden int NOT NULL

	, CONSTRAINT pk_cdrf PRIMARY KEY (cdrf_tpdt_pk, cdrf_valor)
	, CONSTRAINT fk_cdrf_tpdt_pk FOREIGN KEY (cdrf_tpdt_pk)
		REFERENCES tbl_tipo_dato_tpdt (tpdt_pk)
)
/



-- tbl_entidad_accion_enac
CREATE TABLE tbl_entidad_accion_enac
(
	enac_enti_pk BIGINT NOT NULL
	, enac_path VARCHAR(30) NOT NULL
	, enac_etiqueta VARCHAR(30) NOT NULL
	, enac_orden int NOT NULL

	, CONSTRAINT pk_enac PRIMARY KEY (enac_enti_pk, enac_path)
	, CONSTRAINT fk_enac_enti_pk FOREIGN KEY (enac_enti_pk)
		REFERENCES tbl_entidad_enti (enti_pk)
)
/



-- tbl_entidad_grupo_dato_engd
CREATE TABLE tbl_entidad_grupo_dato_engd
(
	engd_enti_pk BIGINT NOT NULL
	, engd_orden int NOT NULL
	, engd_etiqueta VARCHAR(30) NOT NULL

	, CONSTRAINT pk_engd PRIMARY KEY (engd_enti_pk, engd_orden)
	, CONSTRAINT fk_engd_enti_pk FOREIGN KEY (engd_enti_pk)
		REFERENCES tbl_entidad_enti (enti_pk)
)
/



-- tbl_entidad_tipo_dato_entd
CREATE TABLE tbl_entidad_tipo_dato_entd
(
	entd_enti_pk BIGINT NOT NULL
	, entd_tpdt_pk BIGINT NOT NULL
	, entd_grupo int NOT NULL
	, entd_fila int NOT NULL
	, entd_orden int NOT NULL
	, entd_span int NOT NULL
	, entd_obligatorio int NOT NULL
	, entd_gridable int NOT NULL
	, entd_filtrable int NOT NULL
	, entd_valor_defecto VARCHAR(30)
	, entd_etiqueta VARCHAR(100) NOT NULL

	, CONSTRAINT pk_entd PRIMARY KEY (entd_enti_pk, entd_tpdt_pk)
	, CONSTRAINT uq_entd_etiqueta UNIQUE (entd_enti_pk, entd_grupo, entd_etiqueta)
	, CONSTRAINT fk_entd_enti_pk FOREIGN KEY (entd_enti_pk)
		REFERENCES tbl_entidad_enti (enti_pk)
	, CONSTRAINT fk_entd_tpdt_pk FOREIGN KEY (entd_tpdt_pk)
		REFERENCES tbl_tipo_dato_tpdt (tpdt_pk)
)
/



-- tbl_tipo_parametro_tppr
CREATE TABLE tbl_tipo_parametro_tppr
(
	tppr_pk BIGINT NOT NULL
	, tppr_es_i18n int NOT NULL
	, tppr_es_tmp_exp int NOT NULL
	, tppr_tpdt_pk BIGINT

	, CONSTRAINT pk_tppr PRIMARY KEY (tppr_pk)
	, CONSTRAINT fk_tppr_enti_pk FOREIGN KEY (tppr_pk)
		REFERENCES tbl_entidad_enti (enti_pk)
	, CONSTRAINT fk_tppr_tpdt_pk FOREIGN KEY (tppr_tpdt_pk)
		REFERENCES tbl_tipo_dato_tpdt (tpdt_pk)
)
/



-- tbl_parametro_prmt
CREATE TABLE tbl_parametro_prmt
(
	prmt_pk BIGINT NOT NULL
	, prmt_tppr_pk BIGINT NOT NULL
	, prmt_parametro VARCHAR(30) NOT NULL

	, CONSTRAINT pk_prmt PRIMARY KEY (prmt_pk)
	, CONSTRAINT uq_prmt UNIQUE (prmt_tppr_pk, prmt_parametro)
	, CONSTRAINT fk_prmt_tppr_pk FOREIGN KEY (prmt_tppr_pk)
		REFERENCES tbl_tipo_parametro_tppr (tppr_pk)
)
/



-- tbl_parametro_version_prvr
CREATE TABLE tbl_parametro_version_prvr
(
	prvr_pk BIGINT NOT NULL
	, prvr_prmt_pk BIGINT NOT NULL
	, prvr_fini DATETIME2 NOT NULL
	, prvr_ffin DATETIME2

	, CONSTRAINT pk_prvr PRIMARY KEY (prvr_pk)
	, CONSTRAINT fk_prvr_prmt_pk FOREIGN KEY (prvr_prmt_pk)
		REFERENCES tbl_parametro_prmt (prmt_pk)
)
/



-- tbl_parametro_dato_prdt
CREATE TABLE tbl_parametro_dato_prdt
(
	prdt_prvr_pk BIGINT NOT NULL
	, prdt_tpdt_pk BIGINT NOT NULL
	, prdt_nentero BIGINT
	, prdt_ndecimal DOUBLE PRECISION
	, prdt_fecha DATETIME2
	, prdt_prmt_pk BIGINT
	, prdt_cadena VARCHAR(350)

	, CONSTRAINT pk_prdt PRIMARY KEY (prdt_prvr_pk, prdt_tpdt_pk)
	, CONSTRAINT fk_prdt_prvr_pk FOREIGN KEY (prdt_prvr_pk)
		REFERENCES tbl_parametro_version_prvr (prvr_pk)
	, CONSTRAINT fk_prdt_tpdt_pk FOREIGN KEY (prdt_tpdt_pk)
		REFERENCES tbl_tipo_dato_tpdt (tpdt_pk)
	, CONSTRAINT fk_prdt_prmt_pk FOREIGN KEY (prdt_prmt_pk)
		REFERENCES tbl_parametro_prmt (prmt_pk)
)
/



-- tbl_parametro_i18n_p18n
CREATE TABLE tbl_parametro_i18n_p18n
(
	p18n_prvr_pk BIGINT NOT NULL
	, p18n_idioma VARCHAR(5) NOT NULL
	, p18n_texto VARCHAR(350) NOT NULL

	, CONSTRAINT p18n_pk PRIMARY KEY (p18n_prvr_pk, p18n_idioma)
	, CONSTRAINT fk_p18n_prvr_pk FOREIGN KEY (p18n_prvr_pk)
		REFERENCES tbl_parametro_version_prvr (prvr_pk)
)
/



-- tbl_tipo_subparametro_tpsp
CREATE TABLE tbl_tipo_subparametro_tpsp
(
	tpsp_pk BIGINT NOT NULL
	, tpsp_tppr_pk BIGINT NOT NULL
	, tpsp_tppr_dep_pk BIGINT NOT NULL
	, tpsp_es_i18n int NOT NULL
	, tpsp_es_tmp_exp int NOT NULL

	, CONSTRAINT pk_tpsp PRIMARY KEY (tpsp_pk)
	, CONSTRAINT uq_tpsp UNIQUE (tpsp_tppr_pk, tpsp_tppr_dep_pk)
	, CONSTRAINT fk_tpsp_enti_pk FOREIGN KEY (tpsp_pk)
		REFERENCES tbl_entidad_enti (enti_pk)
	, CONSTRAINT fk_tpsp_tppr_pk FOREIGN KEY (tpsp_tppr_pk)
		REFERENCES tbl_tipo_parametro_tppr (tppr_pk)
	, CONSTRAINT fk_tpsp_tppr_dep_pk FOREIGN KEY (tpsp_tppr_dep_pk)
		REFERENCES tbl_tipo_parametro_tppr (tppr_pk)
)
/



-- tbl_subparametro_sprm
CREATE TABLE tbl_subparametro_sprm
(
	sprm_pk BIGINT NOT NULL
	, sprm_tpsp_pk BIGINT NOT NULL
	, sprm_prmt_pk BIGINT NOT NULL
	, sprm_prmt_dep_pk BIGINT NOT NULL

	, CONSTRAINT pk_sprm PRIMARY KEY (sprm_pk)
	, CONSTRAINT uq_sprm UNIQUE (sprm_prmt_pk, sprm_prmt_dep_pk)
	, CONSTRAINT fk_sprm_tpsp_pk FOREIGN KEY (sprm_tpsp_pk)
		REFERENCES tbl_tipo_subparametro_tpsp (tpsp_pk)
	, CONSTRAINT fk_sprm_prmt_pk FOREIGN KEY (sprm_prmt_pk)
		REFERENCES tbl_parametro_prmt (prmt_pk)
	, CONSTRAINT fk_sprm_prmt_dep_pk FOREIGN KEY (sprm_prmt_dep_pk)
		REFERENCES tbl_parametro_prmt (prmt_pk)
)
/



-- tbl_subparametro_version_spvr
CREATE TABLE tbl_subparametro_version_spvr
(
	spvr_pk BIGINT NOT NULL
	, spvr_sprm_pk BIGINT NOT NULL
	, spvr_fini DATETIME2 NOT NULL
	, spvr_ffin DATETIME2

	, CONSTRAINT pk_spvr PRIMARY KEY (spvr_pk)
	, CONSTRAINT fk_spvr_sprm_pk FOREIGN KEY (spvr_sprm_pk)
		REFERENCES tbl_subparametro_sprm (sprm_pk)
)
/



-- tbl_subparametro_dato_spdt
CREATE TABLE tbl_subparametro_dato_spdt
(
	spdt_spvr_pk BIGINT NOT NULL
	, spdt_tpdt_pk BIGINT NOT NULL
	, spdt_nentero BIGINT
	, spdt_ndecimal DOUBLE PRECISION
	, spdt_fecha DATETIME2
	, spdt_prmt_pk BIGINT
	, spdt_cadena VARCHAR(350)

	, CONSTRAINT pk_spdt PRIMARY KEY (spdt_spvr_pk, spdt_tpdt_pk)
	, CONSTRAINT fk_spdt_spvr_pk FOREIGN KEY (spdt_spvr_pk)
		REFERENCES tbl_subparametro_version_spvr (spvr_pk)
	, CONSTRAINT fk_spdt_tpdt_pk FOREIGN KEY (spdt_tpdt_pk)
		REFERENCES tbl_tipo_dato_tpdt (tpdt_pk)
	, CONSTRAINT fk_spdt_prmt_pk FOREIGN KEY (spdt_prmt_pk)
		REFERENCES tbl_parametro_prmt (prmt_pk)
)
/



-- tbl_tipo_servicio_tpsr
CREATE TABLE tbl_tipo_servicio_tpsr
(
	tpsr_pk BIGINT NOT NULL
	, tpsr_es_temporal int NOT NULL
	, tpsr_es_facturable int NOT NULL
	, tpsr_tpdt_estado_pk BIGINT

	, CONSTRAINT pk_tpsr PRIMARY KEY (tpsr_pk)
	, CONSTRAINT fk_tpsr_enti_pk FOREIGN KEY (tpsr_pk)
		REFERENCES tbl_entidad_enti (enti_pk)
	, CONSTRAINT fk_tpsr_tpdt_estado_pk FOREIGN KEY (tpsr_tpdt_estado_pk)
		REFERENCES tbl_tipo_dato_tpdt (tpdt_pk)
)
/



-- tbl_tipo_subservicio_tpss
CREATE TABLE tbl_tipo_subservicio_tpss
(
	tpss_pk BIGINT NOT NULL
	, tpss_tpsr_pk BIGINT NOT NULL
	, tpss_es_temporal int NOT NULL
	, tpss_es_facturable int NOT NULL
	, tpss_tpdt_estado_pk BIGINT

	, CONSTRAINT pk_tpss PRIMARY KEY (tpss_pk)
	, CONSTRAINT fk_tpss_enti_pk FOREIGN KEY (tpss_pk)
		REFERENCES tbl_entidad_enti (enti_pk)
	, CONSTRAINT fk_tpss_tpsr_pk FOREIGN KEY (tpss_tpsr_pk)
		REFERENCES tbl_tipo_servicio_tpsr (tpsr_pk)
	, CONSTRAINT fk_tpss_tpdt_estado_pk FOREIGN KEY (tpss_tpdt_estado_pk)
		REFERENCES tbl_tipo_dato_tpdt (tpdt_pk)
)
/



-- tbl_servicio_secuencia_srsc
CREATE TABLE tbl_servicio_secuencia_srsc
(
	srsc_tpsr_pk BIGINT NOT NULL
	, srsc_subp_pk BIGINT NOT NULL
	, srsc_anno VARCHAR(4) NOT NULL
	, srsc_ultimo_numero int NOT NULL

	, CONSTRAINT pk_srsc PRIMARY KEY (srsc_tpsr_pk, srsc_subp_pk, srsc_anno)
	, CONSTRAINT fk_srsc_tpsr_pk FOREIGN KEY (srsc_tpsr_pk)
		REFERENCES tbl_tipo_servicio_tpsr (tpsr_pk)
	, CONSTRAINT fk_srsc_subp_pk FOREIGN KEY (srsc_subp_pk)
		REFERENCES tbl_parametro_prmt (prmt_pk)
)
/



-- tbl_servicio_srvc
CREATE TABLE tbl_servicio_srvc
(
	srvc_pk BIGINT NOT NULL
	, srvc_tpsr_pk BIGINT NOT NULL
	, srvc_subp_pk BIGINT NOT NULL
	, srvc_anno VARCHAR(4) NOT NULL
	, srvc_numero VARCHAR(5) NOT NULL
	, srvc_falta DATETIME2 NOT NULL
	, srvc_fref DATETIME2 NOT NULL
	, srvc_fini DATETIME2
	, srvc_ffin DATETIME2
	, srvc_estado char(1)

	, CONSTRAINT pk_srvc PRIMARY KEY (srvc_pk)
	, CONSTRAINT fk_srvc_tpsr_pk FOREIGN KEY (srvc_tpsr_pk)
		REFERENCES tbl_tipo_servicio_tpsr (tpsr_pk)
	, CONSTRAINT fk_srvc_subp_pk FOREIGN KEY (srvc_subp_pk)
		REFERENCES tbl_parametro_prmt (prmt_pk)
)
/

CREATE INDEX ix_srvc_tpsr_pk ON tbl_servicio_srvc (srvc_tpsr_pk)
/



-- tbl_servicio_dato_srdt
CREATE TABLE tbl_servicio_dato_srdt
(
	srdt_srvc_pk BIGINT NOT NULL
	, srdt_tpdt_pk BIGINT NOT NULL
	, srdt_nentero BIGINT
	, srdt_ndecimal DOUBLE PRECISION
	, srdt_fecha DATETIME2
	, srdt_prmt_pk BIGINT
	, srdt_srvc_dep_pk BIGINT
	, srdt_cadena VARCHAR(350)

	, CONSTRAINT pk_srdt PRIMARY KEY (srdt_srvc_pk, srdt_tpdt_pk)
	, CONSTRAINT fk_srdt_srvc_pk FOREIGN KEY (srdt_srvc_pk)
		REFERENCES tbl_servicio_srvc (srvc_pk)
	, CONSTRAINT fk_srdt_tpdt_pk FOREIGN KEY (srdt_tpdt_pk)
		REFERENCES tbl_tipo_dato_tpdt (tpdt_pk)
	, CONSTRAINT fk_srdt_prmt_pk FOREIGN KEY (srdt_prmt_pk)
		REFERENCES tbl_parametro_prmt (prmt_pk)
	, CONSTRAINT fk_srdt_srvc_dep_pk FOREIGN KEY (srdt_srvc_dep_pk)
		REFERENCES tbl_servicio_srvc (srvc_pk)
)
/



-- tbl_subservicio_ssrv
CREATE TABLE tbl_subservicio_ssrv
(
	ssrv_pk BIGINT NOT NULL
	, ssrv_srvc_pk BIGINT NOT NULL
	, ssrv_tpss_pk BIGINT NOT NULL
	, ssrv_numero int NOT NULL
	, ssrv_fini DATETIME2
	, ssrv_ffin DATETIME2
	, ssrv_estado char(1)

	, CONSTRAINT pk_ssrv PRIMARY KEY (ssrv_pk)
	, CONSTRAINT fk_ssrv_srvc_pk FOREIGN KEY (ssrv_srvc_pk)
		REFERENCES tbl_servicio_srvc (srvc_pk)
	, CONSTRAINT fk_ssrv_tpss_pk FOREIGN KEY (ssrv_tpss_pk)
		REFERENCES tbl_tipo_subservicio_tpss (tpss_pk)
)
/

CREATE INDEX ix_ssrv_srvc_pk ON tbl_subservicio_ssrv (ssrv_srvc_pk)
/
CREATE INDEX ix_ssrv_tpss_pk ON tbl_subservicio_ssrv (ssrv_tpss_pk)
/



-- tbl_subservicio_dato_ssdt
CREATE TABLE tbl_subservicio_dato_ssdt
(
	ssdt_ssrv_pk BIGINT NOT NULL
	, ssdt_tpdt_pk BIGINT NOT NULL
	, ssdt_nentero BIGINT
	, ssdt_ndecimal DOUBLE PRECISION
	, ssdt_fecha DATETIME2
	, ssdt_prmt_pk BIGINT
	, ssdt_cadena VARCHAR(350)

	, CONSTRAINT pk_ssdt PRIMARY KEY (ssdt_ssrv_pk, ssdt_tpdt_pk)
	, CONSTRAINT fk_ssdt_ssrv_pk FOREIGN KEY (ssdt_ssrv_pk)
		REFERENCES tbl_subservicio_ssrv (ssrv_pk)
	, CONSTRAINT fk_ssdt_tpdt_pk FOREIGN KEY (ssdt_tpdt_pk)
		REFERENCES tbl_tipo_dato_tpdt (tpdt_pk)
	, CONSTRAINT fk_ssdt_prmt_pk FOREIGN KEY (ssdt_prmt_pk)
		REFERENCES tbl_parametro_prmt (prmt_pk)
)
/



-- tbl_subserv_subserv_ssss
CREATE TABLE tbl_subserv_subserv_ssss
(
	ssss_ssrvp_pk BIGINT NOT NULL
	, ssss_ssrvh_pk BIGINT NOT NULL

	, CONSTRAINT pk_ssss PRIMARY KEY (ssss_ssrvp_pk, ssss_ssrvh_pk)
	, CONSTRAINT fk_ssss_ssrvp_pk FOREIGN KEY (ssss_ssrvp_pk)
		REFERENCES tbl_subservicio_ssrv (ssrv_pk)
	, CONSTRAINT fk_ssss_ssrvh_pk FOREIGN KEY (ssss_ssrvh_pk)
		REFERENCES tbl_subservicio_ssrv (ssrv_pk)
)
/



-- tbl_tipo_estadistica_tpes
CREATE TABLE tbl_tipo_estadistica_tpes
(
	tpes_pk BIGINT NOT NULL

	, CONSTRAINT pk_tpes PRIMARY KEY (tpes_pk)
	, CONSTRAINT fk_tpes_enti_pk FOREIGN KEY (tpes_pk)
		REFERENCES tbl_entidad_enti (enti_pk)
)
/



-- tbl_periodo_proceso_pepr
CREATE TABLE tbl_periodo_proceso_pepr
(
	pepr_pk BIGINT NOT NULL
	, pepr_autp_pk BIGINT NOT NULL
	, pepr_anio int NOT NULL
	, pepr_mes int NOT NULL
	, pepr_trimestre int NOT NULL
	, pepr_freferencia DATETIME2 NOT NULL
	, pepr_falta DATETIME2 NOT NULL

	, CONSTRAINT pk_pepr PRIMARY KEY (pepr_pk)
	, CONSTRAINT uq_pepr UNIQUE (pepr_autp_pk, pepr_anio, pepr_mes)
	, CONSTRAINT fk_pepr_autp_pk FOREIGN KEY (pepr_autp_pk)
		REFERENCES tbl_parametro_prmt (prmt_pk)
)
/



-- tbl_estadistica_estd
CREATE TABLE tbl_estadistica_estd
(
	estd_pk BIGINT NOT NULL
	, estd_pepr_pk BIGINT NOT NULL
	, estd_tpes_pk BIGINT NOT NULL
	, estd_subp_pk BIGINT NOT NULL

	, CONSTRAINT pk_estd PRIMARY KEY (estd_pk)
	, CONSTRAINT fk_estd_pepr_pk FOREIGN KEY (estd_pepr_pk)
		REFERENCES tbl_periodo_proceso_pepr (pepr_pk)
	, CONSTRAINT fk_estd_tpes_pk FOREIGN KEY (estd_tpes_pk)
		REFERENCES tbl_tipo_estadistica_tpes (tpes_pk)
	, CONSTRAINT fk_estd_subp_pk FOREIGN KEY (estd_subp_pk)
		REFERENCES tbl_parametro_prmt (prmt_pk)
)
/



-- tbl_estadistica_dato_esdt
CREATE TABLE tbl_estadistica_dato_esdt
(
	esdt_estd_pk BIGINT NOT NULL
	, esdt_tpdt_pk BIGINT NOT NULL
	, esdt_nentero BIGINT
	, esdt_ndecimal DOUBLE PRECISION
	, esdt_prmt_pk BIGINT
	, esdt_cadena VARCHAR(30)

	, CONSTRAINT pk_esdt PRIMARY KEY (esdt_estd_pk, esdt_tpdt_pk)
	, CONSTRAINT fk_esdt_estd_pk FOREIGN KEY (esdt_estd_pk)
		REFERENCES tbl_estadistica_estd (estd_pk)
	, CONSTRAINT fk_esdt_tpdt_pk FOREIGN KEY (esdt_tpdt_pk)
		REFERENCES tbl_tipo_dato_tpdt (tpdt_pk)
	, CONSTRAINT fk_esdt_prmt_pk FOREIGN KEY (esdt_prmt_pk)
		REFERENCES tbl_parametro_prmt (prmt_pk)
)
/



-- tbl_cuadro_mes_cdms
CREATE TABLE tbl_cuadro_mes_cdms
(
	cdms_pk BIGINT NOT NULL
	, cdms_pepr_pk BIGINT NOT NULL
	, cdms_cocu_pk BIGINT NOT NULL
	, cdms_opet_pk BIGINT NOT NULL
	, cdms_navt_pk BIGINT NOT NULL
	, cdms_pais_pk BIGINT NOT NULL
	, cdms_cantidad DOUBLE PRECISION NOT NULL

	, CONSTRAINT pk_cdms PRIMARY KEY (cdms_pk)
	, CONSTRAINT uq_cdms UNIQUE (cdms_pepr_pk, cdms_cocu_pk, cdms_opet_pk, cdms_navt_pk, cdms_pais_pk)
	, CONSTRAINT fk_cdms_pepr_pk FOREIGN KEY (cdms_pepr_pk)
		REFERENCES tbl_periodo_proceso_pepr (pepr_pk)
	, CONSTRAINT fk_cdms_cocu_pk FOREIGN KEY (cdms_cocu_pk)
		REFERENCES tbl_parametro_prmt (prmt_pk)
	, CONSTRAINT fk_cdms_opet_pk FOREIGN KEY (cdms_opet_pk)
		REFERENCES tbl_parametro_prmt (prmt_pk)
	, CONSTRAINT fk_cdms_navt_pk FOREIGN KEY (cdms_navt_pk)
		REFERENCES tbl_parametro_prmt (prmt_pk)
	, CONSTRAINT fk_cdms_pais_pk FOREIGN KEY (cdms_pais_pk)
		REFERENCES tbl_parametro_prmt (prmt_pk)
)
/



-- tbl_proceso_batch_prbt
CREATE TABLE tbl_proceso_batch_prbt
(
	prbt_pk BIGINT NOT NULL
	, prbt_modulo char(1) NOT NULL
	, prbt_tipo VARCHAR(20) NOT NULL
	, prbt_estado char(1) NOT NULL
	, prbt_falta DATETIME2 NOT NULL
	, prbt_finicio DATETIME2
	, prbt_ffin DATETIME2

	, CONSTRAINT pk_prbt PRIMARY KEY (prbt_pk)
)
/



-- tbl_proceso_parametro_prpm
CREATE TABLE tbl_proceso_parametro_prpm
(
	prpm_prbt_pk BIGINT NOT NULL
	, prpm_nombre VARCHAR(50) NOT NULL
	, prpm_valor VARCHAR(300) NOT NULL

	, CONSTRAINT pk_prpm PRIMARY KEY (prpm_prbt_pk, prpm_nombre)
	, CONSTRAINT fk_prpm_prbt_pk FOREIGN KEY (prpm_prbt_pk)
		REFERENCES tbl_proceso_batch_prbt (prbt_pk)
)
/



-- tbl_proceso_archivo_prar
CREATE TABLE tbl_proceso_archivo_prar
(
	prar_prbt_pk BIGINT NOT NULL
	, prar_nombre VARCHAR(50) NOT NULL
	, prar_sentido char(1) NOT NULL

	, CONSTRAINT pk_prar PRIMARY KEY (prar_prbt_pk, prar_sentido, prar_nombre)
	, CONSTRAINT fk_prar_prbt_pk FOREIGN KEY (prar_prbt_pk)
		REFERENCES tbl_proceso_batch_prbt (prbt_pk)
)
/



-- tbl_proceso_item_prit
CREATE TABLE tbl_proceso_item_prit
(
	prit_prbt_pk BIGINT NOT NULL
	, prit_item_pk BIGINT NOT NULL
	, prit_sentido char(1) NOT NULL

	, CONSTRAINT pk_prit PRIMARY KEY (prit_prbt_pk, prit_sentido, prit_item_pk)
	, CONSTRAINT fk_prit_prbt_pk FOREIGN KEY (prit_prbt_pk)
		REFERENCES tbl_proceso_batch_prbt (prbt_pk)
)
/



-- tbl_proceso_mensaje_prmn
CREATE TABLE tbl_proceso_mensaje_prmn
(
	prmn_prbt_pk BIGINT NOT NULL
	, prmn_nivel char(1) NOT NULL
	, prmn_codigo VARCHAR(5) NOT NULL
	, prmn_mensaje VARCHAR(300)

	, CONSTRAINT fk_prmn_prbt_pk FOREIGN KEY (prmn_prbt_pk)
		REFERENCES tbl_proceso_batch_prbt (prbt_pk)
)
/

CREATE INDEX ix_prmn_prbt_pk ON tbl_proceso_mensaje_prmn (prmn_prbt_pk)
/











































-- //@UNDO
-- SQL to undo the change goes here.

DROP TABLE tbl_proceso_mensaje_prmn
/
DROP TABLE tbl_proceso_item_prit
/
DROP TABLE tbl_proceso_archivo_prar
/
DROP TABLE tbl_proceso_parametro_prpm
/
DROP TABLE tbl_proceso_batch_prbt
/
DROP TABLE tbl_cuadro_mes_cdms
/
DROP TABLE tbl_estadistica_dato_esdt
/
DROP TABLE tbl_estadistica_estd
/
DROP TABLE tbl_periodo_proceso_pepr
/
DROP TABLE tbl_tipo_estadistica_tpes
/
DROP TABLE tbl_servicio_secuencia_srsc
/
DROP TABLE tbl_subserv_subserv_ssss
/
DROP TABLE tbl_subservicio_dato_ssdt
/
DROP TABLE tbl_subservicio_ssrv
/
DROP TABLE tbl_servicio_dato_srdt
/
DROP TABLE tbl_servicio_srvc
/
DROP TABLE tbl_tipo_subservicio_tpss
/
DROP TABLE tbl_tipo_servicio_tpsr
/
DROP TABLE tbl_subparametro_dato_spdt
/
DROP TABLE tbl_subparametro_version_spvr
/
DROP TABLE tbl_subparametro_sprm
/
DROP TABLE tbl_tipo_subparametro_tpsp
/
DROP TABLE tbl_parametro_i18n_p18n
/
DROP TABLE tbl_parametro_dato_prdt
/
DROP TABLE tbl_parametro_version_prvr
/
DROP TABLE tbl_parametro_prmt
/
DROP TABLE tbl_tipo_parametro_tppr
/
DROP TABLE tbl_entidad_tipo_dato_entd
/
DROP TABLE tbl_entidad_grupo_dato_engd
/
DROP TABLE tbl_entidad_accion_enac
/
DROP TABLE tbl_codigo_referencia_cdrf
/
DROP TABLE tbl_tipo_dato_tpdt
/
DROP TABLE tbl_entidad_entidad_enen
/
DROP TABLE tbl_entidad_enti
/
DROP TABLE tbl_usuario_grupo_usgr
/
DROP TABLE tbl_grupo_grpo
/
DROP TABLE tbl_usuario_usro
/
DROP TABLE tbl_ig
/
DROP TABLE tbl_conf_valor_i18n_cnvi
/
DROP TABLE tbl_configuracion_valor_cnvl
/
DROP TABLE tbl_configuracion_entorno_cnen
/
DROP TABLE tbl_configuracion_idioma_cnid
/
DROP TABLE tbl_conf_clave_i18n_cnci
/
DROP TABLE tbl_conf_clave_cncl
/
