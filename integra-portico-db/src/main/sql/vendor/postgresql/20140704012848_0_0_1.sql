-- // 0.0.1
-- Migration SQL that makes the change goes here.




-- tbl_archivo_arch
CREATE TABLE tbl_archivo_arch (
	arch_pk BIGINT NOT NULL
	, arch_sentido CHAR(1) NOT NULL
	, arch_nombre VARCHAR(100) NOT NULL
	, arch_tamanio INT NOT NULL
	, arch_falta TIMESTAMP NOT NULL
	, arch_archivo BYTEA NOT NULL

	, CONSTRAINT pk_arch PRIMARY KEY (arch_pk)
)
\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_archivo_arch TO portico\


-- Tabla Unica para i18n
CREATE TABLE tbl_i18n_i18n (
	i18n_pref VARCHAR(4) NOT NULL
	, i18n_ext_pk BIGINT NOT NULL
	, i18n_lang VARCHAR(5) NOT NULL
	, i18n_text VARCHAR(350) NOT NULL

	, CONSTRAINT pk_i18n PRIMARY KEY (i18n_pref, i18n_ext_pk, i18n_lang)
)\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_i18n_i18n TO portico\



-- tbl_ig
CREATE TABLE tbl_ig (
	ig_nombre VARCHAR(30) NOT NULL
	, ig_inicio BIGINT NOT NULL
	, ig_fin BIGINT
	, ig_incremento BIGINT NOT NULL
	, ig_cache BIGINT NOT NULL
	, ig_ultimo BIGINT NOT NULL

	, CONSTRAINT pk_ig PRIMARY KEY (ig_nombre)
)\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_ig TO portico\

COMMENT ON TABLE tbl_ig IS 'Generadores de Secuencias de las Tablas de la Aplicacion'\
COMMENT ON COLUMN tbl_ig.ig_nombre IS 'Nombre del generador de identificadores'\
COMMENT ON COLUMN tbl_ig.ig_inicio IS 'Numero de inicio de la secuencia'\
COMMENT ON COLUMN tbl_ig.ig_fin IS 'Numero de fin de la secuencia'\
COMMENT ON COLUMN tbl_ig.ig_incremento IS 'Incremento de la secuencia'\
COMMENT ON COLUMN tbl_ig.ig_cache IS 'Numero de elementos reservados cada vez que se pide valor a la secuencia'\
COMMENT ON COLUMN tbl_ig.ig_ultimo IS 'Ultimo Valor generado para la secuencia'\




-- tbl_superpuerto_sprt
CREATE TABLE tbl_superpuerto_sprt (
	sprt_pk BIGINT NOT NULL
	, sprt_codigo VARCHAR(10) NOT NULL

	, CONSTRAINT pk_sprt PRIMARY KEY (sprt_pk)

	, CONSTRAINT uk_sprt UNIQUE (sprt_codigo)
)\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_superpuerto_sprt TO portico\




-- tbl_puerto_prto
CREATE TABLE tbl_puerto_prto (
	prto_pk BIGINT NOT NULL
	, prto_sprt_pk BIGINT NOT NULL
	, prto_codigo VARCHAR(10) NOT NULL
	, prto_codigo_corto VARCHAR(10) NOT NULL
	, prto_codigo_edi VARCHAR(10)
	, prto_rec_aduanero VARCHAR(10)
	, prto_unlocode CHAR(5) NOT NULL

	, CONSTRAINT pk_prto PRIMARY KEY (prto_pk)

	, CONSTRAINT uk_prto_codigo UNIQUE (prto_codigo)
	, CONSTRAINT uk_prto_codigo_corto UNIQUE (prto_sprt_pk, prto_codigo_corto)
	, CONSTRAINT uk_prto_codigo_edi UNIQUE (prto_sprt_pk, prto_codigo_edi)
	, CONSTRAINT uk_prto_rec_aduanero UNIQUE (prto_sprt_pk, prto_rec_aduanero)
	, CONSTRAINT uk_prto_unlocode UNIQUE (prto_sprt_pk, prto_unlocode)

	, CONSTRAINT fk_prto_sprt_pk FOREIGN KEY (prto_sprt_pk)
		REFERENCES tbl_superpuerto_sprt (sprt_pk)
)\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_puerto_prto TO portico\





-- tbl_usuario_usro
CREATE TABLE tbl_usuario_usro (
	usro_pk BIGINT NOT NULL
	, usro_login VARCHAR(50) NOT NULL
	, usro_contrasenia VARCHAR(50) NOT NULL
	, usro_nombre VARCHAR(50) NOT NULL
	, usro_sprt_pk BIGINT
	, usro_prto_pk BIGINT

	, CONSTRAINT pk_usro PRIMARY KEY (usro_pk)
	, CONSTRAINT uq_usro UNIQUE (usro_login)

	, CONSTRAINT fk_usro_sprt_pk FOREIGN KEY (usro_sprt_pk)
		REFERENCES tbl_superpuerto_sprt (sprt_pk)
	, CONSTRAINT fk_usro_prto_pk FOREIGN KEY (usro_prto_pk)
		REFERENCES tbl_puerto_prto (prto_pk)
)\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_usuario_usro TO portico\

COMMENT ON TABLE tbl_usuario_usro IS 'Usuarios'\
COMMENT ON COLUMN tbl_usuario_usro.usro_pk IS 'Identificador de usuario'\
COMMENT ON COLUMN tbl_usuario_usro.usro_login IS 'Login'\
COMMENT ON COLUMN tbl_usuario_usro.usro_contrasenia IS 'Contrasenia'\
COMMENT ON COLUMN tbl_usuario_usro.usro_nombre IS 'Nombre Completo'\



-- tbl_grupo_grpo
CREATE TABLE tbl_grupo_grpo (
	grpo_pk BIGINT NOT NULL
	, grpo_nombre VARCHAR(50) NOT NULL

	, CONSTRAINT pk_grpo PRIMARY KEY (grpo_pk)
	, CONSTRAINT uq_grpo UNIQUE (grpo_nombre)
)\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_grupo_grpo TO portico\

COMMENT ON TABLE tbl_grupo_grpo IS 'Grupos de usuarios'\
COMMENT ON COLUMN tbl_grupo_grpo.grpo_pk IS 'Identificador de grupo'\
COMMENT ON COLUMN tbl_grupo_grpo.grpo_nombre IS 'Nombre de grupo'\



-- tbl_usuario_grupo_usgr
CREATE TABLE tbl_usuario_grupo_usgr (
	usgr_usro_pk BIGINT NOT NULL
	, usgr_grpo_pk BIGINT NOT NULL

	, CONSTRAINT pk_usgr PRIMARY KEY (usgr_usro_pk, usgr_grpo_pk)

	, CONSTRAINT fk_usgr_usro_pk FOREIGN KEY (usgr_usro_pk)
		REFERENCES tbl_usuario_usro (usro_pk)
	, CONSTRAINT fk_usgr_grpo_pk FOREIGN KEY (usgr_grpo_pk)
		REFERENCES tbl_grupo_grpo (grpo_pk)
)\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_usuario_grupo_usgr TO portico\

COMMENT ON TABLE tbl_usuario_grupo_usgr IS 'Asociaciones de usuarios a grupos'\
COMMENT ON COLUMN tbl_usuario_grupo_usgr.usgr_usro_pk IS 'Identificador de usuario'\
COMMENT ON COLUMN tbl_usuario_grupo_usgr.usgr_grpo_pk IS 'Identificador de grupo de usuarios'\



-- tbl_entidad_enti
CREATE TABLE tbl_entidad_enti (
	enti_pk BIGINT NOT NULL
	, enti_codigo VARCHAR(50) NOT NULL
	, enti_tipo char(1) NOT NULL
	, enti_cmd_alta int NOT NULL
	, enti_cmd_baja int NOT NULL
	, enti_cmd_edicion int NOT NULL
	, enti_cmd_duplicado int NOT NULL
	, enti_gis int DEFAULT 0 NOT NULL
	, enti_puerto int DEFAULT 0 NOT NULL
	, enti_max_grid int DEFAULT 0 NOT NULL
	, enti_classpath VARCHAR(100)

	, CONSTRAINT pk_enti PRIMARY KEY (enti_pk)
	, CONSTRAINT uq_enti_codigo UNIQUE (enti_codigo)
)\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_entidad_enti TO portico\

COMMENT ON TABLE tbl_entidad_enti IS 'Entidades de la aplicacion'\
COMMENT ON COLUMN tbl_entidad_enti.enti_pk IS 'Identificador de Entidad'\
COMMENT ON COLUMN tbl_entidad_enti.enti_codigo IS 'Codigo Unico'\
COMMENT ON COLUMN tbl_entidad_enti.enti_tipo IS 'Tipo de Entidad: P (Parametrico) - T (Tipo de Servicio) - S (Tipo de Subservicio)'\
COMMENT ON COLUMN tbl_entidad_enti.enti_cmd_alta IS 'Comando de alta Habilitado?'\
COMMENT ON COLUMN tbl_entidad_enti.enti_cmd_baja IS 'Comando de baja Habilitado?'\
COMMENT ON COLUMN tbl_entidad_enti.enti_cmd_edicion IS 'Comando de edicion Habilitado?'\
COMMENT ON COLUMN tbl_entidad_enti.enti_cmd_duplicado IS 'Comando de duplicado Habilitado?'\
COMMENT ON COLUMN tbl_entidad_enti.enti_gis IS 'Entidad Gisable?'\
COMMENT ON COLUMN tbl_entidad_enti.enti_puerto IS 'Entidad Asociada a Puerto?'\



-- tbl_entidad_entidad_enen
CREATE TABLE tbl_entidad_entidad_enen (
	enen_entip_pk BIGINT NOT NULL
	, enen_entih_pk BIGINT NOT NULL
	, enen_orden int NOT NULL

	, CONSTRAINT pk_enen PRIMARY KEY (enen_entip_pk, enen_entih_pk)

	, CONSTRAINT fk_enen_entip_pk FOREIGN KEY (enen_entip_pk)
		REFERENCES tbl_entidad_enti (enti_pk)
	, CONSTRAINT fk_enen_entih_pk FOREIGN KEY (enen_entih_pk)
		REFERENCES tbl_entidad_enti (enti_pk)
)\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_entidad_entidad_enen TO portico\

COMMENT ON TABLE tbl_entidad_entidad_enen IS 'Relacion de Dependencia entre Entidades de la aplicacion'\
COMMENT ON COLUMN tbl_entidad_entidad_enen.enen_entip_pk IS 'Identificador de Entidad Padre'\
COMMENT ON COLUMN tbl_entidad_entidad_enen.enen_entih_pk IS 'Identificador de Entidad Hija'\
COMMENT ON COLUMN tbl_entidad_entidad_enen.enen_orden IS 'Orden de Entidad Hija con Respecto a la entidad Padre'\





-- tbl_tipo_dato_tpdt
CREATE TABLE tbl_tipo_dato_tpdt (
	tpdt_pk BIGINT NOT NULL
	, tpdt_codigo VARCHAR(50) NOT NULL
	, tpdt_tipo_html VARCHAR(2) NOT NULL
	, tpdt_tipo_elemento VARCHAR(2) NOT NULL
	, tpdt_enti_pk BIGINT

	, CONSTRAINT pk_tpdt PRIMARY KEY (tpdt_pk)
	, CONSTRAINT uq_tpdt UNIQUE (tpdt_codigo)

	, CONSTRAINT fk_tpdt_enti_pk FOREIGN KEY (tpdt_enti_pk)
		REFERENCES tbl_entidad_enti (enti_pk)
)\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_tipo_dato_tpdt TO portico\

COMMENT ON TABLE tbl_tipo_dato_tpdt IS 'Tipos de dato de la aplicacion'\
COMMENT ON COLUMN tbl_tipo_dato_tpdt.tpdt_pk IS 'Identificador de Tipo de Dato'\
COMMENT ON COLUMN tbl_tipo_dato_tpdt.tpdt_codigo IS 'Codigo de Tipo de Dato'\
COMMENT ON COLUMN tbl_tipo_dato_tpdt.tpdt_tipo_html IS 'Tipo Html con el que se representa el Tipo de Dato'\
COMMENT ON COLUMN tbl_tipo_dato_tpdt.tpdt_tipo_elemento IS 'Tipo de elemento que almacena el tipo de dato. Puede tomar los valores: L (Long), D (Double), S (String), T (Date), B (Boolean), P (Parametro)'\
COMMENT ON COLUMN tbl_tipo_dato_tpdt.tpdt_enti_pk IS 'Entidad asociada al tipo de dato'\



-- tbl_codigo_ref_cdrf
CREATE TABLE tbl_codigo_ref_cdrf (
	cdrf_pk BIGINT NOT NULL
	, cdrf_tpdt_pk BIGINT NOT NULL
	, cdrf_valor VARCHAR(10) NOT NULL
	, cdrf_orden int NOT NULL

	, CONSTRAINT pk_cdrf PRIMARY KEY (cdrf_pk)
	, CONSTRAINT uq_cdrf UNIQUE (cdrf_tpdt_pk, cdrf_valor)

	, CONSTRAINT fk_cdrf_tpdt_pk FOREIGN KEY (cdrf_tpdt_pk)
		REFERENCES tbl_tipo_dato_tpdt (tpdt_pk)
)\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_codigo_ref_cdrf TO portico\

COMMENT ON TABLE tbl_codigo_ref_cdrf IS 'Tipos de dato de la aplicacion'\
COMMENT ON COLUMN tbl_codigo_ref_cdrf.cdrf_tpdt_pk IS 'Identificador de Tipo de Dato'\
COMMENT ON COLUMN tbl_codigo_ref_cdrf.cdrf_valor IS 'Valor del Codigo de Referencia'\
COMMENT ON COLUMN tbl_codigo_ref_cdrf.cdrf_orden IS 'Orden de Visualiazacion del Codigo de Referencia dentro de un Tipo de Dato'\



-- tbl_entidad_accion_enac
CREATE TABLE tbl_entidad_accion_enac (
	enac_pk BIGINT NOT NULL
	, enac_enti_pk BIGINT NOT NULL
	, enac_path VARCHAR(30) NOT NULL
	, enac_orden int NOT NULL

	, CONSTRAINT pk_enac PRIMARY KEY (enac_pk)
	, CONSTRAINT uq_enac UNIQUE (enac_enti_pk, enac_path)

	, CONSTRAINT fk_enac_enti_pk FOREIGN KEY (enac_enti_pk)
		REFERENCES tbl_entidad_enti (enti_pk)
)\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_entidad_accion_enac TO portico\

COMMENT ON TABLE tbl_entidad_accion_enac IS 'Acciones asociadas a entidades'\
COMMENT ON COLUMN tbl_entidad_accion_enac.enac_enti_pk IS 'Identificador de Entidad'\
COMMENT ON COLUMN tbl_entidad_accion_enac.enac_path IS 'Path para construir la URL de la accion'\
COMMENT ON COLUMN tbl_entidad_accion_enac.enac_enti_pk IS 'Orden de aparacion de la accion dentro de las acciones de una entidad'\



-- tbl_entidad_grupo_dato_engd
CREATE TABLE tbl_entidad_grupo_dato_engd (
	engd_pk BIGINT NOT NULL
	, engd_enti_pk BIGINT NOT NULL
	, engd_orden int NOT NULL

	, CONSTRAINT pk_engd PRIMARY KEY (engd_pk)
	, CONSTRAINT uq_engd UNIQUE (engd_enti_pk, engd_orden)

	, CONSTRAINT fk_engd_enti_pk FOREIGN KEY (engd_enti_pk)
		REFERENCES tbl_entidad_enti (enti_pk)
)\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_entidad_grupo_dato_engd TO portico\

COMMENT ON TABLE tbl_entidad_grupo_dato_engd IS 'Grupos de datos en los que se organizan las entidades'\
COMMENT ON COLUMN tbl_entidad_grupo_dato_engd.engd_enti_pk IS 'Identificador de Entidad'\
COMMENT ON COLUMN tbl_entidad_grupo_dato_engd.engd_orden IS 'Orden del grupo de datos dentro de la entidad'\



-- tbl_entidad_tipo_dato_entd
CREATE TABLE tbl_entidad_tipo_dato_entd (
	entd_pk BIGINT NOT NULL
	, entd_enti_pk BIGINT NOT NULL
	, entd_tpdt_pk BIGINT NOT NULL
	, entd_grupo int NOT NULL
	, entd_fila int NOT NULL
	, entd_orden int NOT NULL
	, entd_span int NOT NULL
	, entd_obligatorio int NOT NULL
	, entd_gridable int NOT NULL
	, entd_filtrable int NOT NULL
	, entd_valor_defecto VARCHAR(30)

	, CONSTRAINT pk_entd PRIMARY KEY (entd_pk)
	, CONSTRAINT uq_entd UNIQUE (entd_enti_pk, entd_tpdt_pk)

	, CONSTRAINT fk_entd_enti_pk FOREIGN KEY (entd_enti_pk)
		REFERENCES tbl_entidad_enti (enti_pk)
	, CONSTRAINT fk_entd_tpdt_pk FOREIGN KEY (entd_tpdt_pk)
		REFERENCES tbl_tipo_dato_tpdt (tpdt_pk)
)\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_entidad_tipo_dato_entd TO portico\

COMMENT ON TABLE tbl_entidad_tipo_dato_entd IS 'Tipos de datos de los que se componen las entidades'\
COMMENT ON COLUMN tbl_entidad_tipo_dato_entd.entd_enti_pk IS 'Identificador de Entidad'\
COMMENT ON COLUMN tbl_entidad_tipo_dato_entd.entd_tpdt_pk IS 'Identificador de Tipo de Dato'\
COMMENT ON COLUMN tbl_entidad_tipo_dato_entd.entd_grupo IS 'Numero de grupo al que pertenece el tipo de dato dentro de la entidad'\
COMMENT ON COLUMN tbl_entidad_tipo_dato_entd.entd_fila IS 'Numero de Fila en el que aparece el tipo de Dato'\
COMMENT ON COLUMN tbl_entidad_tipo_dato_entd.entd_orden IS 'Orden del tipo de Dato dentro de una fila'\
COMMENT ON COLUMN tbl_entidad_tipo_dato_entd.entd_span IS 'Ancho del tipo de dato'\
COMMENT ON COLUMN tbl_entidad_tipo_dato_entd.entd_obligatorio IS 'Indicador de si el tipo de dato debe tener valor asociado'\
COMMENT ON COLUMN tbl_entidad_tipo_dato_entd.entd_gridable IS 'Indicador de si el tipo de dato va a ser visible en los grids de datos de la Entidad'\
COMMENT ON COLUMN tbl_entidad_tipo_dato_entd.entd_filtrable IS 'Indicador de si el tipo de dato va a ser visible en los filtros de busqueda de la Entidad'\
COMMENT ON COLUMN tbl_entidad_tipo_dato_entd.entd_valor_defecto IS 'Valor por defecto del tipo de dato'\



-- tbl_tipo_parametro_tppr
CREATE TABLE tbl_tipo_parametro_tppr (
	tppr_pk BIGINT NOT NULL
	, tppr_es_i18n int NOT NULL
	, tppr_es_tmp_exp int NOT NULL
	, tppr_tpdt_pk BIGINT

	, CONSTRAINT pk_tppr PRIMARY KEY (tppr_pk)

	, CONSTRAINT fk_tppr_enti_pk FOREIGN KEY (tppr_pk)
		REFERENCES tbl_entidad_enti (enti_pk)
	, CONSTRAINT fk_tppr_tpdt_pk FOREIGN KEY (tppr_tpdt_pk)
		REFERENCES tbl_tipo_dato_tpdt (tpdt_pk)
)\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_tipo_parametro_tppr TO portico\

COMMENT ON TABLE tbl_tipo_parametro_tppr IS 'Tipos de Parametro de la aplicacion (Definicion de Maestros)'\
COMMENT ON COLUMN tbl_tipo_parametro_tppr.tppr_pk IS 'Identificador de Tipo de Parametro'\
COMMENT ON COLUMN tbl_tipo_parametro_tppr.tppr_es_i18n IS 'Indicador de si el parametro tiene descripciones internacionalizables'\
COMMENT ON COLUMN tbl_tipo_parametro_tppr.tppr_es_tmp_exp IS 'Indicador de si el parametro tiene temporalidad explicita'\
COMMENT ON COLUMN tbl_tipo_parametro_tppr.tppr_tpdt_pk IS 'Identificador de tipo de dato que almacena la descripcion del parametro (utilizado en maestros sin i18n)'\



-- tbl_parametro_prmt
CREATE TABLE tbl_parametro_prmt (
	prmt_pk BIGINT NOT NULL
	, prmt_tppr_pk BIGINT NOT NULL
	, prmt_parametro VARCHAR(30) NOT NULL
	, prmt_prto_pk BIGINT

	, CONSTRAINT pk_prmt PRIMARY KEY (prmt_pk)
	, CONSTRAINT uq_prmt UNIQUE (prmt_tppr_pk, prmt_parametro, prmt_prto_pk)

	, CONSTRAINT fk_prmt_tppr_pk FOREIGN KEY (prmt_tppr_pk)
		REFERENCES tbl_tipo_parametro_tppr (tppr_pk)
	, CONSTRAINT fk_prmt_prto_pk FOREIGN KEY (prmt_prto_pk)
		REFERENCES tbl_puerto_prto (prto_pk)
)\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_parametro_prmt TO portico\

COMMENT ON TABLE tbl_parametro_prmt IS 'Parametros de la aplicacion (Datos de Maestros)'\
COMMENT ON COLUMN tbl_parametro_prmt.prmt_pk IS 'Identificador de Parametro'\
COMMENT ON COLUMN tbl_parametro_prmt.prmt_tppr_pk IS 'Identificador de Tipo de Parametro al que pertenece el parametro'\
COMMENT ON COLUMN tbl_parametro_prmt.prmt_parametro IS 'Valor de Parametro'\
COMMENT ON COLUMN tbl_parametro_prmt.prmt_prto_pk IS 'Identificador de Puerto'\



-- tbl_parametro_version_prvr
CREATE TABLE tbl_parametro_version_prvr (
	prvr_pk BIGINT NOT NULL
	, prvr_prmt_pk BIGINT NOT NULL
	, prvr_fini TIMESTAMP NOT NULL
	, prvr_ffin TIMESTAMP
	, prvr_lat DOUBLE PRECISION
	, prvr_lon DOUBLE PRECISION

	, CONSTRAINT pk_prvr PRIMARY KEY (prvr_pk)

	, CONSTRAINT fk_prvr_prmt_pk FOREIGN KEY (prvr_prmt_pk)
		REFERENCES tbl_parametro_prmt (prmt_pk)
)\

CREATE INDEX ix_prvr_prmt_pk ON tbl_parametro_version_prvr(prvr_prmt_pk)\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_parametro_version_prvr TO portico\

COMMENT ON TABLE tbl_parametro_version_prvr IS 'Versiones de Parametros de la aplicacion (Temporalidad de Datos de Maestros)'\
COMMENT ON COLUMN tbl_parametro_version_prvr.prvr_pk IS 'Identificador de Version de Parametro'\
COMMENT ON COLUMN tbl_parametro_version_prvr.prvr_fini IS 'Fecha de inicio de vigencia de la Version'\
COMMENT ON COLUMN tbl_parametro_version_prvr.prvr_ffin IS 'Fecha de fin de vigencia de la Version'\



-- tbl_parametro_dato_prdt
CREATE TABLE tbl_parametro_dato_prdt (
	prdt_prvr_pk BIGINT NOT NULL
	, prdt_tpdt_pk BIGINT NOT NULL
	, prdt_nentero BIGINT
	, prdt_ndecimal DOUBLE PRECISION
	, prdt_fecha TIMESTAMP
	, prdt_prmt_pk BIGINT
	, prdt_cadena VARCHAR(350)

	, CONSTRAINT pk_prdt PRIMARY KEY (prdt_prvr_pk, prdt_tpdt_pk)

	, CONSTRAINT fk_prdt_prvr_pk FOREIGN KEY (prdt_prvr_pk)
		REFERENCES tbl_parametro_version_prvr (prvr_pk)
	, CONSTRAINT fk_prdt_tpdt_pk FOREIGN KEY (prdt_tpdt_pk)
		REFERENCES tbl_tipo_dato_tpdt (tpdt_pk)
	, CONSTRAINT fk_prdt_prmt_pk FOREIGN KEY (prdt_prmt_pk)
		REFERENCES tbl_parametro_prmt (prmt_pk)
)\

CREATE INDEX ix_prdt_prmt_pk ON tbl_parametro_dato_prdt (prdt_prmt_pk, prdt_tpdt_pk, prdt_prvr_pk)\
CREATE INDEX ix_prdt_cadena ON tbl_parametro_dato_prdt (prdt_cadena, prdt_tpdt_pk, prdt_prvr_pk)\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_parametro_dato_prdt TO portico\

COMMENT ON TABLE tbl_parametro_dato_prdt IS 'Datos Asociados a las Versiones de Parametros de la aplicacion (Datos de Maestros)'\
COMMENT ON COLUMN tbl_parametro_dato_prdt.prdt_prvr_pk IS 'Identificador de Version de Parametro'\
COMMENT ON COLUMN tbl_parametro_dato_prdt.prdt_tpdt_pk IS 'Identificador de Tipo de Dato'\
COMMENT ON COLUMN tbl_parametro_dato_prdt.prdt_nentero IS 'Valor de dato de Tipo Cantidad Entera'\
COMMENT ON COLUMN tbl_parametro_dato_prdt.prdt_ndecimal IS 'Valor de dato de Tipo Cantidad Decimal'\
COMMENT ON COLUMN tbl_parametro_dato_prdt.prdt_fecha IS 'Valor de dato de Tipo Fecha'\
COMMENT ON COLUMN tbl_parametro_dato_prdt.prdt_prmt_pk IS 'Valor de dato de Tipo Maestro'\
COMMENT ON COLUMN tbl_parametro_dato_prdt.prdt_cadena IS 'Valor de dato de Tipo Texto'\



-- tbl_tipo_subparametro_tpsp
CREATE TABLE tbl_tipo_subparametro_tpsp (
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
)\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_tipo_subparametro_tpsp TO portico\

COMMENT ON TABLE tbl_tipo_subparametro_tpsp IS 'Tipos de Subparametro de la aplicacion (Definicion de Maestros dependientes de otros maestros)'\
COMMENT ON COLUMN tbl_tipo_subparametro_tpsp.tpsp_pk IS 'Identificador de Tipo de Subparametro'\
COMMENT ON COLUMN tbl_tipo_subparametro_tpsp.tpsp_tppr_pk IS 'Identificador de Tipo de Parametro Padre'\
COMMENT ON COLUMN tbl_tipo_subparametro_tpsp.tpsp_tppr_dep_pk IS 'Identificador de Tipo de Parametro Asociado'\
COMMENT ON COLUMN tbl_tipo_subparametro_tpsp.tpsp_es_i18n IS 'Indicador de si el tipo de Subparametro tiene internacionalizacion'\
COMMENT ON COLUMN tbl_tipo_subparametro_tpsp.tpsp_es_tmp_exp IS 'Indicador de si el tipo de Subparametro tiene temporalidad explicita'\



-- tbl_subparametro_sprm
CREATE TABLE tbl_subparametro_sprm (
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
)\

CREATE INDEX ix_sprm_prmt_dep_pk ON tbl_subparametro_sprm (sprm_prmt_dep_pk, sprm_tpsp_pk)\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_subparametro_sprm TO portico\

COMMENT ON TABLE tbl_subparametro_sprm IS 'Subparametros de la aplicacion (Datos de Maestros dependientes de otros maestros)'\
COMMENT ON COLUMN tbl_subparametro_sprm.sprm_pk IS 'Identificador de Subparametro'\
COMMENT ON COLUMN tbl_subparametro_sprm.sprm_tpsp_pk IS 'Identificador de Tipo de Subparametro'\
COMMENT ON COLUMN tbl_subparametro_sprm.sprm_prmt_pk IS 'Identificador de Parametro padre'\
COMMENT ON COLUMN tbl_subparametro_sprm.sprm_prmt_dep_pk IS 'Identificador de Parametro Asociado'\



-- tbl_subparametro_version_spvr
CREATE TABLE tbl_subparametro_version_spvr (
	spvr_pk BIGINT NOT NULL
	, spvr_sprm_pk BIGINT NOT NULL
	, spvr_fini TIMESTAMP NOT NULL
	, spvr_ffin TIMESTAMP

	, CONSTRAINT pk_spvr PRIMARY KEY (spvr_pk)

	, CONSTRAINT fk_spvr_sprm_pk FOREIGN KEY (spvr_sprm_pk)
		REFERENCES tbl_subparametro_sprm (sprm_pk)
)\

CREATE INDEX ix_spvr_sprm_pk ON tbl_subparametro_version_spvr (spvr_sprm_pk)\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_subparametro_version_spvr TO portico\

COMMENT ON TABLE tbl_subparametro_version_spvr IS 'Versiones de subparametros de la aplicacion (Temporalidad de Datos de Maestros dependientes de otros maestros)'\
COMMENT ON COLUMN tbl_subparametro_version_spvr.spvr_pk IS 'Identificador de Version de Subparametro'\
COMMENT ON COLUMN tbl_subparametro_version_spvr.spvr_fini IS 'Fecha de inicio de vigencia de Version de Subparametro'\
COMMENT ON COLUMN tbl_subparametro_version_spvr.spvr_ffin IS 'Fecha de fin de vigencia de Version de Subparametro'\



-- tbl_subparametro_dato_spdt
CREATE TABLE tbl_subparametro_dato_spdt (
	spdt_spvr_pk BIGINT NOT NULL
	, spdt_tpdt_pk BIGINT NOT NULL
	, spdt_nentero BIGINT
	, spdt_ndecimal DOUBLE PRECISION
	, spdt_fecha TIMESTAMP
	, spdt_prmt_pk BIGINT
	, spdt_cadena VARCHAR(350)

	, CONSTRAINT pk_spdt PRIMARY KEY (spdt_spvr_pk, spdt_tpdt_pk)

	, CONSTRAINT fk_spdt_spvr_pk FOREIGN KEY (spdt_spvr_pk)
		REFERENCES tbl_subparametro_version_spvr (spvr_pk)
	, CONSTRAINT fk_spdt_tpdt_pk FOREIGN KEY (spdt_tpdt_pk)
		REFERENCES tbl_tipo_dato_tpdt (tpdt_pk)
	, CONSTRAINT fk_spdt_prmt_pk FOREIGN KEY (spdt_prmt_pk)
		REFERENCES tbl_parametro_prmt (prmt_pk)
)\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_subparametro_dato_spdt TO portico\

COMMENT ON TABLE tbl_subparametro_dato_spdt IS 'Datos Asociados a las Versiones de Subparametros de la aplicacion (Datos de Maestros Dependientes)'\
COMMENT ON COLUMN tbl_subparametro_dato_spdt.spdt_spvr_pk IS 'Identificador de Version de Subparametro'\
COMMENT ON COLUMN tbl_subparametro_dato_spdt.spdt_tpdt_pk IS 'Identificador de Tipo de Dato'\
COMMENT ON COLUMN tbl_subparametro_dato_spdt.spdt_nentero IS 'Valor de dato de Tipo Cantidad Entera'\
COMMENT ON COLUMN tbl_subparametro_dato_spdt.spdt_ndecimal IS 'Valor de dato de Tipo Cantidad Decimal'\
COMMENT ON COLUMN tbl_subparametro_dato_spdt.spdt_nentero IS 'Valor de dato de Tipo Fecha'\
COMMENT ON COLUMN tbl_subparametro_dato_spdt.spdt_prmt_pk IS 'Valor de dato de Tipo Maestro'\
COMMENT ON COLUMN tbl_subparametro_dato_spdt.spdt_cadena IS 'Valor de dato de Tipo Texto'\



-- tbl_tipo_servicio_tpsr
CREATE TABLE tbl_tipo_servicio_tpsr (
	tpsr_pk BIGINT NOT NULL
	, tpsr_es_temporal int NOT NULL
	, tpsr_es_facturable int NOT NULL
	, tpsr_es_exencionable INT NOT NULL
	, tpsr_tpdt_estado_pk BIGINT
	, tpsr_estados_vlrc VARCHAR(30)
	, tpsr_estado_def VARCHAR(5)

	, CONSTRAINT pk_tpsr PRIMARY KEY (tpsr_pk)

	, CONSTRAINT fk_tpsr_enti_pk FOREIGN KEY (tpsr_pk)
		REFERENCES tbl_entidad_enti (enti_pk)
	, CONSTRAINT fk_tpsr_tpdt_estado_pk FOREIGN KEY (tpsr_tpdt_estado_pk)
		REFERENCES tbl_tipo_dato_tpdt (tpdt_pk)
)\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_tipo_servicio_tpsr TO portico\

COMMENT ON TABLE tbl_tipo_servicio_tpsr IS 'Tipos de Servicio de la aplicacion'\
COMMENT ON COLUMN tbl_tipo_servicio_tpsr.tpsr_pk IS 'Identificador de Tipo de Servicio'\
COMMENT ON COLUMN tbl_tipo_servicio_tpsr.tpsr_es_temporal IS 'Indicador de si el tipo de servicio tiene temporalidad'\
COMMENT ON COLUMN tbl_tipo_servicio_tpsr.tpsr_es_facturable IS 'Indicador de si el tipo de servicio es facturable'\
COMMENT ON COLUMN tbl_tipo_servicio_tpsr.tpsr_tpdt_estado_pk IS 'Tipo de dato que añmacena los estados por los que pueden pasar los servicios de este tipo de servicio'\
COMMENT ON COLUMN tbl_tipo_servicio_tpsr.tpsr_estados_vlrc IS 'Lista de estados en los que un servicio es Valorable (separados por comas)'\
COMMENT ON COLUMN tbl_tipo_servicio_tpsr.tpsr_estado_def IS 'Estado por defecto'\



-- tbl_tipo_subservicio_tpss
CREATE TABLE tbl_tipo_subservicio_tpss (
	tpss_pk BIGINT NOT NULL
	, tpss_tpsr_pk BIGINT NOT NULL
	, tpss_es_temporal int NOT NULL
	, tpss_es_facturable int NOT NULL
	, tpss_es_exencionable int NOT NULL
	, tpss_tpdt_estado_pk BIGINT
	, tpss_estados_vlrc VARCHAR(30)
	, tpss_estado_def VARCHAR(5)

	, CONSTRAINT pk_tpss PRIMARY KEY (tpss_pk)

	, CONSTRAINT fk_tpss_enti_pk FOREIGN KEY (tpss_pk)
		REFERENCES tbl_entidad_enti (enti_pk)
	, CONSTRAINT fk_tpss_tpsr_pk FOREIGN KEY (tpss_tpsr_pk)
		REFERENCES tbl_tipo_servicio_tpsr (tpsr_pk)
	, CONSTRAINT fk_tpss_tpdt_estado_pk FOREIGN KEY (tpss_tpdt_estado_pk)
		REFERENCES tbl_tipo_dato_tpdt (tpdt_pk)
)\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_tipo_subservicio_tpss TO portico\

COMMENT ON TABLE tbl_tipo_subservicio_tpss IS 'Tipos de Subservicio de la aplicacion'\
COMMENT ON COLUMN tbl_tipo_subservicio_tpss.tpss_pk IS 'Identificador de Tipo de Subservicio'\
COMMENT ON COLUMN tbl_tipo_subservicio_tpss.tpss_tpsr_pk IS 'Identificador de Tipo de Servicio al que pertenece el tipo de subservicio'\
COMMENT ON COLUMN tbl_tipo_subservicio_tpss.tpss_es_temporal IS 'Indicador de si el tipo de subservicio tiene temporalidad'\
COMMENT ON COLUMN tbl_tipo_subservicio_tpss.tpss_es_facturable IS 'Indicador de si el tipo de subservicio es facturable'\
COMMENT ON COLUMN tbl_tipo_subservicio_tpss.tpss_tpdt_estado_pk IS 'Tipo de dato que añmacena los estados por los que pueden pasar los subservicios de este tipo de subservicio'\
COMMENT ON COLUMN tbl_tipo_subservicio_tpss.tpss_estados_vlrc IS 'Lista de estados en los que un subservicio es Valorable (separados por comas)'\
COMMENT ON COLUMN tbl_tipo_subservicio_tpss.tpss_estado_def IS 'Estado por defecto'\



-- tbl_servicio_secuencia_srsc
CREATE TABLE tbl_servicio_secuencia_srsc (
	srsc_tpsr_pk BIGINT NOT NULL
	, srsc_subp_pk BIGINT NOT NULL
	, srsc_anno VARCHAR(4) NOT NULL
	, srsc_ultimo_numero int NOT NULL

	, CONSTRAINT pk_srsc PRIMARY KEY (srsc_tpsr_pk, srsc_subp_pk, srsc_anno)

	, CONSTRAINT fk_srsc_tpsr_pk FOREIGN KEY (srsc_tpsr_pk)
		REFERENCES tbl_tipo_servicio_tpsr (tpsr_pk)
	, CONSTRAINT fk_srsc_subp_pk FOREIGN KEY (srsc_subp_pk)
		REFERENCES tbl_puerto_prto (prto_pk)
)\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_servicio_secuencia_srsc TO portico\

COMMENT ON TABLE tbl_servicio_secuencia_srsc IS 'Numeros de Secuencia de Servicios'\
COMMENT ON COLUMN tbl_servicio_secuencia_srsc.srsc_tpsr_pk IS 'Identificador de Tipo de Servicio'\
COMMENT ON COLUMN tbl_servicio_secuencia_srsc.srsc_subp_pk IS 'Identificador de Subpuerto'\
COMMENT ON COLUMN tbl_servicio_secuencia_srsc.srsc_anno IS 'Anio'\
COMMENT ON COLUMN tbl_servicio_secuencia_srsc.srsc_ultimo_numero IS 'Ultimo numero de servicio generado para un tipo de servicio, subpuerto y anio'\



-- tbl_servicio_srvc
CREATE TABLE tbl_servicio_srvc
(
	srvc_pk BIGINT NOT NULL
	, srvc_tpsr_pk BIGINT NOT NULL
	, srvc_subp_pk BIGINT NOT NULL
	, srvc_anno VARCHAR(4) NOT NULL
	, srvc_numero VARCHAR(5) NOT NULL
	, srvc_falta TIMESTAMP NOT NULL
	, srvc_fref TIMESTAMP NOT NULL
	, srvc_fini TIMESTAMP
	, srvc_ffin TIMESTAMP
	, srvc_estado char(1)
	, srvc_pepr_pk BIGINT

	, CONSTRAINT pk_srvc PRIMARY KEY (srvc_pk)

	, CONSTRAINT fk_srvc_tpsr_pk FOREIGN KEY (srvc_tpsr_pk)
		REFERENCES tbl_tipo_servicio_tpsr (tpsr_pk)
	, CONSTRAINT fk_srvc_subp_pk FOREIGN KEY (srvc_subp_pk)
		REFERENCES tbl_puerto_prto (prto_pk)
)\

CREATE INDEX ix_srvc_tpsr_pk ON tbl_servicio_srvc (srvc_tpsr_pk)\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_servicio_srvc TO portico\

COMMENT ON TABLE tbl_servicio_srvc IS 'Servicios de la aplicacion'\
COMMENT ON COLUMN tbl_servicio_srvc.srvc_pk IS 'Identificador de Servicio'\
COMMENT ON COLUMN tbl_servicio_srvc.srvc_tpsr_pk IS 'Identificador de Tipo de Servicio'\
COMMENT ON COLUMN tbl_servicio_srvc.srvc_subp_pk IS 'Identificador de Subpuerto del Servicio'\
COMMENT ON COLUMN tbl_servicio_srvc.srvc_anno IS 'Año'\
COMMENT ON COLUMN tbl_servicio_srvc.srvc_numero IS 'Numero'\
COMMENT ON COLUMN tbl_servicio_srvc.srvc_falta IS 'Fecha de alta en el sistema'\
COMMENT ON COLUMN tbl_servicio_srvc.srvc_fref IS 'Fecha de referencia. Utilizada para recuperar los datos temporales asociados al servicio'\
COMMENT ON COLUMN tbl_servicio_srvc.srvc_fini IS 'Fecha de inicio de prestacion del servicio'\
COMMENT ON COLUMN tbl_servicio_srvc.srvc_ffin IS 'Fecha de fin de prestacion del servicio'\
COMMENT ON COLUMN tbl_servicio_srvc.srvc_estado IS 'Estado en el que se encuentra el servicio'\



-- tbl_servicio_dato_srdt
CREATE TABLE tbl_servicio_dato_srdt (
	srdt_srvc_pk BIGINT NOT NULL
	, srdt_tpdt_pk BIGINT NOT NULL
	, srdt_nentero BIGINT
	, srdt_ndecimal DOUBLE PRECISION
	, srdt_fecha TIMESTAMP
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
)\

CREATE INDEX ix_srdt_prmt_pk ON tbl_servicio_dato_srdt (srdt_prmt_pk, srdt_tpdt_pk, srdt_srvc_pk)\
CREATE INDEX ix_srdt_cadena ON tbl_servicio_dato_srdt (srdt_cadena, srdt_tpdt_pk, srdt_srvc_pk)\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_servicio_dato_srdt TO portico\

COMMENT ON TABLE tbl_servicio_dato_srdt IS 'Datos asociados a servicios'\
COMMENT ON COLUMN tbl_servicio_dato_srdt.srdt_srvc_pk IS 'Identificador de Servicio'\
COMMENT ON COLUMN tbl_servicio_dato_srdt.srdt_tpdt_pk IS 'Identificador de Tipo de Dato'\
COMMENT ON COLUMN tbl_servicio_dato_srdt.srdt_nentero IS 'Valor de dato de tipo cantidad entera'\
COMMENT ON COLUMN tbl_servicio_dato_srdt.srdt_ndecimal IS 'Valor de dato de tipo cantidad decimal'\
COMMENT ON COLUMN tbl_servicio_dato_srdt.srdt_fecha IS 'Valor de dato de tipo Fecha'\
COMMENT ON COLUMN tbl_servicio_dato_srdt.srdt_prmt_pk IS 'Valor de dato de tipo Maestro'\
COMMENT ON COLUMN tbl_servicio_dato_srdt.srdt_srvc_dep_pk IS 'Valor de dato de Servicio'\
COMMENT ON COLUMN tbl_servicio_dato_srdt.srdt_cadena IS 'Valor de dato de tipo Texto'\



-- tbl_subservicio_ssrv
CREATE TABLE tbl_subservicio_ssrv (
	ssrv_pk BIGINT NOT NULL
	, ssrv_srvc_pk BIGINT NOT NULL
	, ssrv_tpss_pk BIGINT NOT NULL
	, ssrv_numero int NOT NULL
	, ssrv_fini TIMESTAMP
	, ssrv_ffin TIMESTAMP
	, ssrv_estado char(1)

	, CONSTRAINT pk_ssrv PRIMARY KEY (ssrv_pk)

	, CONSTRAINT fk_ssrv_srvc_pk FOREIGN KEY (ssrv_srvc_pk)
		REFERENCES tbl_servicio_srvc (srvc_pk)
	, CONSTRAINT fk_ssrv_tpss_pk FOREIGN KEY (ssrv_tpss_pk)
		REFERENCES tbl_tipo_subservicio_tpss (tpss_pk)
)\

CREATE INDEX ix_ssrv_srvc_pk ON tbl_subservicio_ssrv (ssrv_srvc_pk)\
CREATE INDEX ix_ssrv_tpss_pk ON tbl_subservicio_ssrv (ssrv_tpss_pk)\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_subservicio_ssrv TO portico\

COMMENT ON TABLE tbl_subservicio_ssrv IS 'Subservicios de la aplicacion'\
COMMENT ON COLUMN tbl_subservicio_ssrv.ssrv_pk IS 'Identificador de Subservicio'\
COMMENT ON COLUMN tbl_subservicio_ssrv.ssrv_srvc_pk IS 'Identificador de Servicio'\
COMMENT ON COLUMN tbl_subservicio_ssrv.ssrv_tpss_pk IS 'Identificador de Tipo de Subservicio'\
COMMENT ON COLUMN tbl_subservicio_ssrv.ssrv_numero IS 'Numero de Subservicio'\
COMMENT ON COLUMN tbl_subservicio_ssrv.ssrv_fini IS 'Fecha de inicio de prestacion del subservicio'\
COMMENT ON COLUMN tbl_subservicio_ssrv.ssrv_ffin IS 'Fecha de fin de prestacion del subservicio'\
COMMENT ON COLUMN tbl_subservicio_ssrv.ssrv_estado IS 'Estado en el que se encuentra el subservicio'\



-- tbl_subservicio_dato_ssdt
CREATE TABLE tbl_subservicio_dato_ssdt (
	ssdt_ssrv_pk BIGINT NOT NULL
	, ssdt_tpdt_pk BIGINT NOT NULL
	, ssdt_nentero BIGINT
	, ssdt_ndecimal DOUBLE PRECISION
	, ssdt_fecha TIMESTAMP
	, ssdt_prmt_pk BIGINT
	, ssdt_cadena VARCHAR(350)

	, CONSTRAINT pk_ssdt PRIMARY KEY (ssdt_ssrv_pk, ssdt_tpdt_pk)

	, CONSTRAINT fk_ssdt_ssrv_pk FOREIGN KEY (ssdt_ssrv_pk)
		REFERENCES tbl_subservicio_ssrv (ssrv_pk)
	, CONSTRAINT fk_ssdt_tpdt_pk FOREIGN KEY (ssdt_tpdt_pk)
		REFERENCES tbl_tipo_dato_tpdt (tpdt_pk)
	, CONSTRAINT fk_ssdt_prmt_pk FOREIGN KEY (ssdt_prmt_pk)
		REFERENCES tbl_parametro_prmt (prmt_pk)
)\

CREATE INDEX ix_ssdt_prmt_pk ON tbl_subservicio_dato_ssdt (ssdt_prmt_pk, ssdt_tpdt_pk, ssdt_ssrv_pk)\
CREATE INDEX ix_ssdt_cadena ON tbl_subservicio_dato_ssdt (ssdt_cadena, ssdt_tpdt_pk, ssdt_ssrv_pk)\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_subservicio_dato_ssdt TO portico\

COMMENT ON TABLE tbl_subservicio_dato_ssdt IS 'Subservicios de la aplicacion'\
COMMENT ON COLUMN tbl_subservicio_dato_ssdt.ssdt_ssrv_pk IS 'Identificador de Subservicio'\
COMMENT ON COLUMN tbl_subservicio_dato_ssdt.ssdt_tpdt_pk IS 'Identificador de Tipo de Dato'\
COMMENT ON COLUMN tbl_subservicio_dato_ssdt.ssdt_nentero IS 'Valor de dato de tipo cantidad entera'\
COMMENT ON COLUMN tbl_subservicio_dato_ssdt.ssdt_ndecimal IS 'Valor de dato de tipo cantidad decimal'\
COMMENT ON COLUMN tbl_subservicio_dato_ssdt.ssdt_fecha IS 'Valor de dato de tipo fecha'\
COMMENT ON COLUMN tbl_subservicio_dato_ssdt.ssdt_prmt_pk IS 'Valor de dato de tipo maestro'\
COMMENT ON COLUMN tbl_subservicio_dato_ssdt.ssdt_cadena IS 'Valor de dato de tipo texto'\



-- tbl_subserv_subserv_ssss
CREATE TABLE tbl_subserv_subserv_ssss (
	ssss_ssrvp_pk BIGINT NOT NULL
	, ssss_ssrvh_pk BIGINT NOT NULL

	, CONSTRAINT pk_ssss PRIMARY KEY (ssss_ssrvp_pk, ssss_ssrvh_pk)

	, CONSTRAINT fk_ssss_ssrvp_pk FOREIGN KEY (ssss_ssrvp_pk)
		REFERENCES tbl_subservicio_ssrv (ssrv_pk)
	, CONSTRAINT fk_ssss_ssrvh_pk FOREIGN KEY (ssss_ssrvh_pk)
		REFERENCES tbl_subservicio_ssrv (ssrv_pk)
)\

CREATE INDEX ix_ssss_ssrvh_pk ON tbl_subserv_subserv_ssss (ssss_ssrvh_pk)\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_subserv_subserv_ssss TO portico\

COMMENT ON TABLE tbl_subserv_subserv_ssss IS 'Subservicios de la aplicacion'\
COMMENT ON COLUMN tbl_subserv_subserv_ssss.ssss_ssrvp_pk IS 'Identificador de Subservicio Padre'\
COMMENT ON COLUMN tbl_subserv_subserv_ssss.ssss_ssrvh_pk IS 'Identificador de Subservicio Hijo'\



-- tbl_tipo_estadistica_tpes
CREATE TABLE tbl_tipo_estadistica_tpes (
	tpes_pk BIGINT NOT NULL

	, CONSTRAINT pk_tpes PRIMARY KEY (tpes_pk)

	, CONSTRAINT fk_tpes_enti_pk FOREIGN KEY (tpes_pk)
		REFERENCES tbl_entidad_enti (enti_pk)
)\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_tipo_estadistica_tpes TO portico\

COMMENT ON TABLE tbl_tipo_estadistica_tpes IS 'Tipos de Estadisticas de la aplicacion'\
COMMENT ON COLUMN tbl_tipo_estadistica_tpes.tpes_pk IS 'Identificador de Tipo de Estadistica'\



-- tbl_periodo_proceso_pepr
CREATE TABLE tbl_periodo_proceso_pepr (
	pepr_pk BIGINT NOT NULL
	, pepr_autp_pk BIGINT NOT NULL
	, pepr_anio int NOT NULL
	, pepr_mes int NOT NULL
	, pepr_trimestre int NOT NULL
	, pepr_freferencia TIMESTAMP NOT NULL
	, pepr_falta TIMESTAMP NOT NULL
	, pepr_arch_pk BIGINT

	, CONSTRAINT pk_pepr PRIMARY KEY (pepr_pk)
	, CONSTRAINT uq_pepr UNIQUE (pepr_autp_pk, pepr_anio, pepr_mes)

	, CONSTRAINT fk_pepr_autp_pk FOREIGN KEY (pepr_autp_pk)
		REFERENCES tbl_superpuerto_sprt (sprt_pk)
	, CONSTRAINT fk_pepr_arch_pk FOREIGN KEY (pepr_arch_pk)
		REFERENCES tbl_archivo_arch (arch_pk)
)\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_periodo_proceso_pepr TO portico\

COMMENT ON TABLE tbl_periodo_proceso_pepr IS 'Periodos de Proceso de Estadisticas'\
COMMENT ON COLUMN tbl_periodo_proceso_pepr.pepr_pk IS 'Identificador de Periodo de Proceso'\
COMMENT ON COLUMN tbl_periodo_proceso_pepr.pepr_autp_pk IS 'Identificador de Autoridad Portuaria'\
COMMENT ON COLUMN tbl_periodo_proceso_pepr.pepr_anio IS 'Año de Periodo de Proceso'\
COMMENT ON COLUMN tbl_periodo_proceso_pepr.pepr_mes IS 'Mes de Periodo de Proceso'\
COMMENT ON COLUMN tbl_periodo_proceso_pepr.pepr_trimestre IS 'Trimestre de Periodo de Proceso'\
COMMENT ON COLUMN tbl_periodo_proceso_pepr.pepr_freferencia IS 'Fecha de referencia. Utilizada para recuperar los datos temporales asociados al periodo de proceso'\
COMMENT ON COLUMN tbl_periodo_proceso_pepr.pepr_falta IS 'Fecha de alta del periodo de proceso'\



-- tbl_estadistica_estd
CREATE TABLE tbl_estadistica_estd (
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
		REFERENCES tbl_puerto_prto (prto_pk)
)\

CREATE INDEX ix_estd_pepr_pk ON tbl_estadistica_estd (estd_tpes_pk, estd_pepr_pk)\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_estadistica_estd TO portico\

COMMENT ON TABLE tbl_estadistica_estd IS 'Estadisticas'\
COMMENT ON COLUMN tbl_estadistica_estd.estd_pk IS 'Identificador de Estadistica'\
COMMENT ON COLUMN tbl_estadistica_estd.estd_pepr_pk IS 'Identificador de Periodo de Proceso'\
COMMENT ON COLUMN tbl_estadistica_estd.estd_tpes_pk IS 'Identificador de Tipo de Estadistica'\
COMMENT ON COLUMN tbl_estadistica_estd.estd_subp_pk IS 'Identificador de Subpuerto'\



-- tbl_estadistica_dato_esdt
CREATE TABLE tbl_estadistica_dato_esdt (
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
)\

CREATE INDEX ix_esdt_prmt_pk ON tbl_estadistica_dato_esdt (esdt_prmt_pk, esdt_tpdt_pk, esdt_estd_pk)\
CREATE INDEX ix_esdt_cadena ON tbl_estadistica_dato_esdt (esdt_cadena, esdt_tpdt_pk, esdt_estd_pk)\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_estadistica_dato_esdt TO portico\

COMMENT ON TABLE tbl_estadistica_dato_esdt IS 'Datos asociados a Estadisticas'\
COMMENT ON COLUMN tbl_estadistica_dato_esdt.esdt_estd_pk IS 'Identificador de Estadistica'\
COMMENT ON COLUMN tbl_estadistica_dato_esdt.esdt_tpdt_pk IS 'Identificador de Tipo de Dato'\
COMMENT ON COLUMN tbl_estadistica_dato_esdt.esdt_nentero IS 'Valor de dato de Tipo Cantidad Entera'\
COMMENT ON COLUMN tbl_estadistica_dato_esdt.esdt_ndecimal IS 'Valor de dato de Tipo Cantidad Decimal'\
COMMENT ON COLUMN tbl_estadistica_dato_esdt.esdt_prmt_pk IS 'Valor de dato de Tipo Maestro'\
COMMENT ON COLUMN tbl_estadistica_dato_esdt.esdt_cadena IS 'Valor de dato de Tipo Texto'\



-- tbl_cuadro_mes_cdms
CREATE TABLE tbl_cuadro_mes_cdms (
	cdms_pepr_pk BIGINT NOT NULL
	, cdms_prto_pk BIGINT NOT NULL
	, cdms_cocu VARCHAR(10) NOT NULL
	, cdms_orden INT NOT NULL
	, cdms_opet VARCHAR(2)
	, cdms_navt_pk BIGINT NOT NULL
	, cdms_pais_pk BIGINT NOT NULL
	, cdms_cantidad DOUBLE PRECISION NOT NULL

	, CONSTRAINT pk_cdms PRIMARY KEY (cdms_pepr_pk, cdms_prto_pk, cdms_cocu, cdms_opet, cdms_navt_pk, cdms_pais_pk)

	, CONSTRAINT fk_cdms_pepr_pk FOREIGN KEY (cdms_pepr_pk)
		REFERENCES tbl_periodo_proceso_pepr (pepr_pk)
	, CONSTRAINT fk_cdms_prto_pk FOREIGN KEY (cdms_prto_pk)
		REFERENCES tbl_puerto_prto (prto_pk)
	, CONSTRAINT fk_cdms_navt_pk FOREIGN KEY (cdms_navt_pk)
		REFERENCES tbl_parametro_prmt (prmt_pk)
	, CONSTRAINT fk_cdms_pais_pk FOREIGN KEY (cdms_pais_pk)
		REFERENCES tbl_parametro_prmt (prmt_pk)
)\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_cuadro_mes_cdms TO portico\

COMMENT ON TABLE tbl_cuadro_mes_cdms IS 'Cuadros mensuales de Estadisticas'\
COMMENT ON COLUMN tbl_cuadro_mes_cdms.cdms_pepr_pk IS 'Identificador de Periodo de Proceso'\
COMMENT ON COLUMN tbl_cuadro_mes_cdms.cdms_prto_pk IS 'Identificador de Puerto'\
COMMENT ON COLUMN tbl_cuadro_mes_cdms.cdms_cocu IS 'Identificador de Concepto de Cuadro mensual'\
COMMENT ON COLUMN tbl_cuadro_mes_cdms.cdms_opet IS 'Identificador de Tipo de Operacion de BL'\
COMMENT ON COLUMN tbl_cuadro_mes_cdms.cdms_navt_pk IS 'Identificador de Tipo de Navegacion'\
COMMENT ON COLUMN tbl_cuadro_mes_cdms.cdms_pais_pk IS 'Identificador de Pais'\
COMMENT ON COLUMN tbl_cuadro_mes_cdms.cdms_cantidad IS 'Cantidad'\



-- tbl_proceso_batch_prbt
CREATE TABLE tbl_proceso_batch_prbt (
	prbt_pk BIGINT NOT NULL
	, prbt_modulo char(1) NOT NULL
	, prbt_tipo VARCHAR(20) NOT NULL
	, prbt_estado char(1) NOT NULL
	, prbt_falta TIMESTAMP NOT NULL
	, prbt_finicio TIMESTAMP
	, prbt_ffin TIMESTAMP

	, CONSTRAINT pk_prbt PRIMARY KEY (prbt_pk)
)\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_proceso_batch_prbt TO portico\

COMMENT ON TABLE tbl_proceso_batch_prbt IS 'Ejecuciones de Procesos Batch de la Aplicacion'\
COMMENT ON COLUMN tbl_proceso_batch_prbt.prbt_pk IS 'Identificador de proceso'\
COMMENT ON COLUMN tbl_proceso_batch_prbt.prbt_modulo IS 'Modulo al que pertenece el proceso: S (Servicio), E (Estadistica), F (Facturacion)'\
COMMENT ON COLUMN tbl_proceso_batch_prbt.prbt_tipo IS 'Tipo de Proceso'\
COMMENT ON COLUMN tbl_proceso_batch_prbt.prbt_estado IS 'Estado en el que se encuentra el proceso: C (En cola), E (En ejecucion), F (Finalizado)'\
COMMENT ON COLUMN tbl_proceso_batch_prbt.prbt_falta IS 'Fecha del alta del proceso en el sistema'\
COMMENT ON COLUMN tbl_proceso_batch_prbt.prbt_finicio IS 'Fecha de inicio de la ejecucion del proceso'\
COMMENT ON COLUMN tbl_proceso_batch_prbt.prbt_ffin IS 'Fecha de fin de la ejecucion del proceso'\



-- tbl_proceso_parametro_prpm
CREATE TABLE tbl_proceso_parametro_prpm (
	prpm_prbt_pk BIGINT NOT NULL
	, prpm_nombre VARCHAR(50) NOT NULL
	, prpm_valor VARCHAR(300) NOT NULL

	, CONSTRAINT pk_prpm PRIMARY KEY (prpm_prbt_pk, prpm_nombre)

	, CONSTRAINT fk_prpm_prbt_pk FOREIGN KEY (prpm_prbt_pk)
		REFERENCES tbl_proceso_batch_prbt (prbt_pk)
)\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_proceso_parametro_prpm TO portico\

COMMENT ON TABLE tbl_proceso_parametro_prpm IS 'Parametros de Ejecuciones de Procesos Batch'\
COMMENT ON COLUMN tbl_proceso_parametro_prpm.prpm_prbt_pk IS 'Identificador de proceso'\
COMMENT ON COLUMN tbl_proceso_parametro_prpm.prpm_nombre IS 'Nombre del parametro'\
COMMENT ON COLUMN tbl_proceso_parametro_prpm.prpm_valor IS 'Valor del parametro'\



-- tbl_proceso_item_prit
CREATE TABLE tbl_proceso_item_prit (
	prit_prbt_pk BIGINT NOT NULL
	, prit_item_pk BIGINT NOT NULL
	, prit_sentido char(1) NOT NULL
	, prit_tipo VARCHAR(4) NOT NULL

	, CONSTRAINT pk_prit PRIMARY KEY (prit_prbt_pk, prit_sentido, prit_item_pk)

	, CONSTRAINT fk_prit_prbt_pk FOREIGN KEY (prit_prbt_pk)
		REFERENCES tbl_proceso_batch_prbt (prbt_pk)
)\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_proceso_item_prit TO portico\

COMMENT ON TABLE tbl_proceso_item_prit IS 'Items tratados (leidos-generados) en las Ejecuciones de Procesos Batch. Un item puede ser un servicio, valoracion, factura...'\
COMMENT ON COLUMN tbl_proceso_item_prit.prit_prbt_pk IS 'Identificador de proceso al que pertenece el item'\
COMMENT ON COLUMN tbl_proceso_item_prit.prit_item_pk IS 'Identificador de item (Puede ser un Servicio, Periodo de Proceso, ...)'\
COMMENT ON COLUMN tbl_proceso_item_prit.prit_sentido IS 'Indicador de Tipo de Item: E (Entrada), S (Salida)'\



-- tbl_proceso_mensaje_prmn
CREATE TABLE tbl_proceso_mensaje_prmn (
	prmn_prbt_pk BIGINT NOT NULL
	, prmn_nivel char(1) NOT NULL
	, prmn_codigo VARCHAR(5) NOT NULL
	, prmn_mensaje VARCHAR(4000)

	, CONSTRAINT fk_prmn_prbt_pk FOREIGN KEY (prmn_prbt_pk)
		REFERENCES tbl_proceso_batch_prbt (prbt_pk)
)\

CREATE INDEX ix_prmn_prbt_pk ON tbl_proceso_mensaje_prmn (prmn_prbt_pk)\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_proceso_mensaje_prmn TO portico\

COMMENT ON TABLE tbl_proceso_mensaje_prmn IS 'Mensajes generados (info-warning-error) en las Ejecuciones de Procesos Batch.'\
COMMENT ON COLUMN tbl_proceso_mensaje_prmn.prmn_prbt_pk IS 'Identificador de proceso al que pertenece el mensaje'\
COMMENT ON COLUMN tbl_proceso_mensaje_prmn.prmn_nivel IS 'Nivel del mensaje generado por el proceso: I (Info), W (Warning), E (Error)'\
COMMENT ON COLUMN tbl_proceso_mensaje_prmn.prmn_codigo IS 'Codigo de Mensaje'\
COMMENT ON COLUMN tbl_proceso_mensaje_prmn.prmn_mensaje IS 'Texto del mensaje'\







-- tbl_cargo_crgo
CREATE TABLE tbl_cargo_crgo (
	crgo_pk BIGINT NOT NULL
	, crgo_codigo VARCHAR(15) NOT NULL
	, crgo_tpsr_pk BIGINT NOT NULL

	, CONSTRAINT pk_crgo PRIMARY KEY (crgo_pk)
	, CONSTRAINT uq_crgo UNIQUE (crgo_tpsr_pk, crgo_codigo)

	, CONSTRAINT fk_crgo_tpsr_pk FOREIGN KEY (crgo_tpsr_pk)
		REFERENCES tbl_tipo_servicio_tpsr (tpsr_pk)
)\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_cargo_crgo TO portico\

COMMENT ON TABLE tbl_cargo_crgo IS 'Maestro de Tasas-Tarifas'\
COMMENT ON COLUMN tbl_cargo_crgo.crgo_pk IS 'Identificador de Tasa-Tarifa'\
COMMENT ON COLUMN tbl_cargo_crgo.crgo_codigo IS 'Codigo de Tasa-Tarifa'\
COMMENT ON COLUMN tbl_cargo_crgo.crgo_tpsr_pk IS 'Identificador de Modulo al que pertenece la Tasa-Tarifa'\



-- tbl_cargo_version_crgv
CREATE TABLE tbl_cargo_version_crgv (
	crgv_pk BIGINT NOT NULL
	, crgv_crgo_pk BIGINT NOT NULL
	, crgv_fini TIMESTAMP NOT NULL
	, crgv_ffin TIMESTAMP
	, crgv_codigo_norm VARCHAR(15)
	, crgv_es_principal INT NOT NULL
	, crgv_es_temporal INT NOT NULL
	, crgv_tipo VARCHAR(1) NOT NULL

	, CONSTRAINT pk_crgv PRIMARY KEY (crgv_pk)

	, CONSTRAINT fk_crgv_crgo_pk FOREIGN KEY (crgv_crgo_pk)
		REFERENCES tbl_cargo_crgo (crgo_pk)
)\

CREATE INDEX ix_crgv_crgo_pk ON tbl_cargo_version_crgv (crgv_crgo_pk)\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_cargo_version_crgv TO portico\



-- tbl_cargo_dep_crdp
CREATE TABLE tbl_cargo_dep_crdp (
	crdp_pk BIGINT NOT NULL
	, crdp_crgop_pk BIGINT NOT NULL
	, crdp_crgoh_pk BIGINT NOT NULL

	, CONSTRAINT pk_crdp PRIMARY KEY (crdp_pk)
	, CONSTRAINT uq_crdp UNIQUE (crdp_crgop_pk, crdp_crgoh_pk)

	, CONSTRAINT fk_crdp_crgop_pk FOREIGN KEY (crdp_crgop_pk)
		REFERENCES tbl_cargo_crgo (crgo_pk)
	, CONSTRAINT fk_crdp_crgoh_pk FOREIGN KEY (crdp_crgoh_pk)
		REFERENCES tbl_cargo_crgo (crgo_pk)
)\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_cargo_dep_crdp TO portico\



-- tbl_cargo_dep_version_crdv
CREATE TABLE tbl_cargo_dep_version_crdv (
	crdv_pk BIGINT NOT NULL
	, crdv_crdp_pk BIGINT NOT NULL
	, crdv_fini TIMESTAMP NOT NULL
	, crdv_ffin TIMESTAMP

	, CONSTRAINT pk_crdv PRIMARY KEY (crdv_pk)

	, CONSTRAINT fk_crdv_crdp_pk FOREIGN KEY (crdv_crdp_pk)
		REFERENCES tbl_cargo_dep_crdp (crdp_pk)
)\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_cargo_dep_version_crdv TO portico\



-- tbl_regla_rgla
CREATE TABLE tbl_regla_rgla (
	rgla_pk BIGINT NOT NULL
	, rgla_crgo_pk BIGINT NOT NULL
	, rgla_codigo VARCHAR(20) NOT NULL
	, rgla_enti_pk BIGINT NOT NULL
	, rgla_tipo VARCHAR(1) NOT NULL

	, CONSTRAINT pk_rgla PRIMARY KEY (rgla_pk)
	, CONSTRAINT uq_rgla UNIQUE (rgla_crgo_pk, rgla_codigo)

	, CONSTRAINT fk_rgla_crgo_pk FOREIGN KEY (rgla_crgo_pk)
		REFERENCES tbl_cargo_crgo (crgo_pk)
	, CONSTRAINT fk_rgla_enti_pk FOREIGN KEY (rgla_enti_pk)
		REFERENCES tbl_entidad_enti (enti_pk)
)\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_regla_rgla TO portico\



-- tbl_regla_version_rglv
CREATE TABLE tbl_regla_version_rglv (
	rglv_pk BIGINT NOT NULL
	, rglv_rgla_pk BIGINT NOT NULL
	, rglv_fini TIMESTAMP NOT NULL
	, rglv_ffin TIMESTAMP
	, rglv_orden INT NOT NULL
	, rglv_valor_base NUMERIC(10, 4) NOT NULL
	, rglv_condicion VARCHAR(2000) NOT NULL
	, rglv_formula VARCHAR(2000) NOT NULL

	, rglv_path_impuesto VARCHAR(250)
	, rglv_path_pagador VARCHAR(250)
	, rglv_path_es_suj_pasivo VARCHAR(250)
	, rglv_path_cod_exen VARCHAR(250)

	, rglv_path_info1 VARCHAR(250)
	, rglv_path_info2 VARCHAR(250)
	, rglv_path_info3 VARCHAR(250)
	, rglv_path_info4 VARCHAR(250)
	, rglv_path_info5 VARCHAR(250)
	, rglv_path_info6 VARCHAR(250)

	, rglv_etiq_info1 VARCHAR(50)
	, rglv_etiq_info2 VARCHAR(50)
	, rglv_etiq_info3 VARCHAR(50)
	, rglv_etiq_info4 VARCHAR(50)
	, rglv_etiq_info5 VARCHAR(50)
	, rglv_etiq_info6 VARCHAR(50)

	, rglv_path_cuant1 VARCHAR(250)
	, rglv_path_cuant2 VARCHAR(250)
	, rglv_path_cuant3 VARCHAR(250)
	, rglv_path_cuant4 VARCHAR(250)
	, rglv_path_cuant5 VARCHAR(250)
	, rglv_path_cuant6 VARCHAR(250)

	, rglv_etiq_cuant1 VARCHAR(50)
	, rglv_etiq_cuant2 VARCHAR(50)
	, rglv_etiq_cuant3 VARCHAR(50)
	, rglv_etiq_cuant4 VARCHAR(50)
	, rglv_etiq_cuant5 VARCHAR(50)
	, rglv_etiq_cuant6 VARCHAR(50)

	, CONSTRAINT pk_rglv PRIMARY KEY (rglv_pk)

	, CONSTRAINT fk_rglv_rgla_pk FOREIGN KEY (rglv_rgla_pk)
		REFERENCES tbl_regla_rgla (rgla_pk)
)\

CREATE INDEX ix_rglv_rgla_pk ON tbl_regla_version_rglv (rglv_rgla_pk)\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_regla_version_rglv TO portico\



-- tbl_regla_inc_rgin
CREATE TABLE tbl_regla_inc_rgin (
	rgin_pk BIGINT NOT NULL
	, rgin_rgla1_pk BIGINT NOT NULL
	, rgin_rgla2_pk BIGINT NOT NULL

	, CONSTRAINT pk_rgin PRIMARY KEY (rgin_pk)
	, CONSTRAINT uq_rgin UNIQUE (rgin_rgla1_pk, rgin_rgla2_pk)

	, CONSTRAINT fk_rgin_rgla1_pk FOREIGN KEY (rgin_rgla1_pk)
		REFERENCES tbl_regla_rgla (rgla_pk)
	, CONSTRAINT fk_rgin_rgla2_pk FOREIGN KEY (rgin_rgla2_pk)
		REFERENCES tbl_regla_rgla (rgla_pk)
)\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_regla_inc_rgin TO portico\



-- tbl_regla_inc_version_rgiv
CREATE TABLE tbl_regla_inc_version_rgiv (
	rgiv_pk BIGINT NOT NULL
	, rgiv_rgin_pk BIGINT NOT NULL
	, rgiv_fini TIMESTAMP NOT NULL
	, rgiv_ffin TIMESTAMP

	, CONSTRAINT pk_rgiv PRIMARY KEY (rgiv_pk)

	, CONSTRAINT fk_rgiv_rgin_pk FOREIGN KEY (rgiv_rgin_pk)
		REFERENCES tbl_regla_inc_rgin (rgin_pk)
)\

CREATE INDEX ix_rgiv_rgin_pk ON tbl_regla_inc_version_rgiv (rgiv_rgin_pk)\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_regla_inc_version_rgiv TO portico\



-- tbl_aspecto_aspc
CREATE TABLE tbl_aspecto_aspc (
	aspc_pk BIGINT NOT NULL
	, aspc_codigo VARCHAR(10) NOT NULL
	, aspc_tpsr_pk BIGINT NOT NULL

	, CONSTRAINT pk_aspc PRIMARY KEY (aspc_pk)
	, CONSTRAINT uq_aspc UNIQUE (aspc_tpsr_pk, aspc_codigo)

	, CONSTRAINT fk_aspc_tpsr_pk FOREIGN KEY (aspc_tpsr_pk)
		REFERENCES tbl_tipo_servicio_tpsr (tpsr_pk)
)\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_aspecto_aspc TO portico\



-- tbl_aspecto_version_aspv
CREATE TABLE tbl_aspecto_version_aspv (
	aspv_pk BIGINT NOT NULL
	, aspv_aspc_pk BIGINT NOT NULL
	, aspv_fini TIMESTAMP NOT NULL
	, aspv_ffin TIMESTAMP
	, aspv_prioridad INT NOT NULL

	, aspv_cpath_info1 VARCHAR(250)
	, aspv_cpath_info2 VARCHAR(250)
	, aspv_cpath_info3 VARCHAR(250)
	, aspv_cpath_info4 VARCHAR(250)
	, aspv_cpath_info5 VARCHAR(250)
	, aspv_cpath_info6 VARCHAR(250)

	, aspv_cetiq_info1 VARCHAR(50)
	, aspv_cetiq_info2 VARCHAR(50)
	, aspv_cetiq_info3 VARCHAR(50)
	, aspv_cetiq_info4 VARCHAR(50)
	, aspv_cetiq_info5 VARCHAR(50)
	, aspv_cetiq_info6 VARCHAR(50)

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

CREATE INDEX ix_aspv_aspc_pk ON tbl_aspecto_version_aspv (aspv_aspc_pk)\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_aspecto_version_aspv TO portico\



-- tbl_aspecto_cargo_ascr
CREATE TABLE tbl_aspecto_cargo_ascr (
	ascr_pk BIGINT NOT NULL
	, ascr_aspc_pk BIGINT NOT NULL
	, ascr_crgo_pk BIGINT NOT NULL

	, CONSTRAINT pk_ascr PRIMARY KEY (ascr_pk)
	, CONSTRAINT uq_ascr UNIQUE (ascr_aspc_pk, ascr_crgo_pk)

	, CONSTRAINT fk_ascr_aspc_pk FOREIGN KEY (ascr_aspc_pk)
		REFERENCES tbl_aspecto_aspc (aspc_pk)
	, CONSTRAINT fk_ascr_crgo_pk FOREIGN KEY (ascr_crgo_pk)
		REFERENCES tbl_cargo_crgo (crgo_pk)
)\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_aspecto_cargo_ascr TO portico\



CREATE TABLE tbl_aspecto_cargo_version_ascv (
	ascv_pk BIGINT NOT NULL
	, ascv_ascr_pk BIGINT NOT NULL
	, ascv_fini TIMESTAMP NOT NULL
	, ascv_ffin TIMESTAMP

	, CONSTRAINT pk_ascv PRIMARY KEY (ascv_pk)

	, CONSTRAINT fk_ascv_ascr_pk FOREIGN KEY (ascv_ascr_pk)
		REFERENCES tbl_aspecto_cargo_ascr (ascr_pk)
)\

CREATE INDEX ix_ascv_ascr_pk ON tbl_aspecto_cargo_version_ascv (ascv_ascr_pk)\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_aspecto_cargo_version_ascv TO portico\



-- tbl_factura_serie_fcsr
CREATE TABLE tbl_factura_serie_fcsr (
	fcsr_pk BIGINT NOT NULL
	, fcsr_serie CHAR(1) NOT NULL
	, fcsr_anio INT NOT NULL
	, fcsr_numero_ultimo INT NOT NULL

	, CONSTRAINT pk_fcsr PRIMARY KEY (fcsr_pk)
	, CONSTRAINT uq_fcsr UNIQUE (fcsr_serie, fcsr_anio)
)\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_factura_serie_fcsr TO portico\



-- tbl_valoracion_vlrc
CREATE TABLE tbl_valoracion_vlrc (
	vlrc_pk BIGINT NOT NULL
	, vlrc_srvc_pk BIGINT NOT NULL
	, vlrc_aspc_pk BIGINT NOT NULL
	, vlrc_pagador_prmt_pk BIGINT NOT NULL
	, vlrc_fref TIMESTAMP NOT NULL
	, vlrc_fliq TIMESTAMP NOT NULL
	, vlrc_falta TIMESTAMP NOT NULL
	, vlrc_fini TIMESTAMP
	, vlrc_ffin TIMESTAMP
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
		REFERENCES tbl_servicio_srvc (srvc_pk)
	, CONSTRAINT fk_vlrc_aspc_pk FOREIGN KEY (vlrc_aspc_pk)
		REFERENCES tbl_aspecto_aspc (aspc_pk)
	, CONSTRAINT fk_vlrc_pagador_prmt_pk FOREIGN KEY (vlrc_pagador_prmt_pk)
		REFERENCES tbl_parametro_prmt (prmt_pk)
)\

CREATE INDEX ix_vlrc_srvc_pk ON tbl_valoracion_vlrc (vlrc_srvc_pk)\
CREATE INDEX ix_vlrc_pagador_prmt_pk ON tbl_valoracion_vlrc (vlrc_pagador_prmt_pk)\
CREATE INDEX ix_vlrc_aspc_pk ON tbl_valoracion_vlrc (vlrc_aspc_pk)\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_valoracion_vlrc TO portico\



-- tbl_valoracion_lin_vlrl
CREATE TABLE tbl_valoracion_lin_vlrl (
	vlrl_pk BIGINT NOT NULL
	, vlrl_padre_pk BIGINT NOT NULL
	, vlrl_vlrc_pk BIGINT NOT NULL
	, vlrl_rgla_pk BIGINT NOT NULL
	, vlrl_impuesto_prmt_pk BIGINT
	, vlrl_ssrv_pk BIGINT
	, vlrl_fini TIMESTAMP
	, vlrl_ffin TIMESTAMP

	, vlrl_info1 VARCHAR(100)
	, vlrl_info2 VARCHAR(100)
	, vlrl_info3 VARCHAR(100)
	, vlrl_info4 VARCHAR(100)
	, vlrl_info5 VARCHAR(100)
	, vlrl_info6 VARCHAR(100)

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

CREATE INDEX ix_vlrl_vlrc_pk ON tbl_valoracion_lin_vlrl (vlrl_vlrc_pk)\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_valoracion_lin_vlrl TO portico\



-- tbl_valoracion_det_vlrd
CREATE TABLE tbl_valoracion_det_vlrd (
	vlrd_pk BIGINT NOT NULL
	, vlrd_vlrc_pk BIGINT NOT NULL
	, vlrd_padre_pk BIGINT NOT NULL
	, vlrd_vlrl_pk BIGINT NOT NULL
	, vlrd_valor_base NUMERIC(10, 4) NOT NULL
	, vlrd_importe_base NUMERIC(10, 2) NOT NULL
	, vlrd_importe NUMERIC(10, 2) NOT NULL
	, vlrd_ssrv_pk BIGINT
	, vlrd_fini TIMESTAMP
	, vlrd_ffin TIMESTAMP

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

	, CONSTRAINT fk_vlrd_padre_pk FOREIGN KEY (vlrd_padre_pk)
		REFERENCES tbl_valoracion_det_vlrd (vlrd_pk)
	, CONSTRAINT fk_vlrd_vlrc_pk FOREIGN KEY (vlrd_vlrc_pk)
		REFERENCES tbl_valoracion_vlrc (vlrc_pk)
	, CONSTRAINT fk_vlrd_vlrl_pk FOREIGN KEY (vlrd_vlrl_pk)
		REFERENCES tbl_valoracion_lin_vlrl (vlrl_pk)
	, CONSTRAINT fk_vlrd_ssrv_pk FOREIGN KEY (vlrd_ssrv_pk)
		REFERENCES tbl_subservicio_ssrv (ssrv_pk)
)\

CREATE INDEX ix_vlrd_vlrc_pk ON tbl_valoracion_det_vlrd (vlrd_vlrc_pk)\
CREATE INDEX ix_vlrd_vlrl_pk ON tbl_valoracion_det_vlrd (vlrd_vlrl_pk)\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_valoracion_det_vlrd TO portico\



-- tbl_valoracion_tmp_vlrt
CREATE TABLE tbl_valoracion_tmp_vlrt (
	vlrt_pk BIGINT NOT NULL
	, vlrt_padre_pk BIGINT NOT NULL
	, vlrt_prbt_pk BIGINT NOT NULL
	, vlrt_srvc_pk BIGINT NOT NULL
	, vlrt_ssrv_pk BIGINT
	, vlrt_crgo_pk BIGINT NOT NULL
	, vlrt_rgla_pk BIGINT NOT NULL
	, vlrt_rgla_tipo CHAR(1) NOT NULL
	, vlrt_impuesto_prmt_pk BIGINT NOT NULL
	, vlrt_pagador_prmt_pk BIGINT NOT NULL
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

	, vlrt_info1 VARCHAR(100)
	, vlrt_info2 VARCHAR(100)
	, vlrt_info3 VARCHAR(100)
	, vlrt_info4 VARCHAR(100)
	, vlrt_info5 VARCHAR(100)
	, vlrt_info6 VARCHAR(100)

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

CREATE INDEX ix_vlrt ON tbl_valoracion_tmp_vlrt (
	vlrt_prbt_pk, vlrt_srvc_pk, vlrt_ssrv_pk, vlrt_crgo_pk, vlrt_rgla_tipo)\
CREATE INDEX ix_vlrt_padre_pk ON tbl_valoracion_tmp_vlrt (vlrt_padre_pk)\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_valoracion_tmp_vlrt TO portico\



-- tbl_factura_fctr
CREATE TABLE tbl_factura_fctr (
	fctr_pk BIGINT NOT NULL
	, fctr_aspc_pk BIGINT NOT NULL
	, fctr_pagador_prmt_pk BIGINT NOT NULL
	, fctr_fcsr_pk BIGINT NOT NULL
	, fctr_numero INT NOT NULL
	, fctr_fref TIMESTAMP NOT NULL
	, fctr_falta TIMESTAMP NOT NULL
	, fctr_fini TIMESTAMP
	, fctr_ffin TIMESTAMP
	, fctr_estado CHAR(2) NOT NULL
	, fctr_es_suj_pasivo INT NOT NULL
	, fctr_info1 VARCHAR(100)
	, fctr_info2 VARCHAR(100)
	, fctr_info3 VARCHAR(100)
	, fctr_info4 VARCHAR(100)
	, fctr_info5 VARCHAR(100)
	, fctr_info6 VARCHAR(100)

	, CONSTRAINT pk_fctr PRIMARY KEY (fctr_pk)

	, CONSTRAINT fk_fctr_aspc_pk FOREIGN KEY (fctr_aspc_pk)
		REFERENCES tbl_aspecto_aspc (aspc_pk)
	, CONSTRAINT fk_fctr_pagador_prmt_pk FOREIGN KEY (fctr_pagador_prmt_pk)
		REFERENCES tbl_parametro_prmt (prmt_pk)
	, CONSTRAINT fk_fctr_fcsr_pk FOREIGN KEY (fctr_fcsr_pk)
		REFERENCES tbl_factura_serie_fcsr (fcsr_pk)
)\

CREATE INDEX ix_fctr_aspc_pk ON tbl_factura_fctr (fctr_aspc_pk)\
CREATE INDEX ix_fctr_pagador_prmt_pk ON tbl_factura_fctr (fctr_pagador_prmt_pk)\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_factura_fctr TO portico\



-- tbl_factura_srv_fcts
CREATE TABLE tbl_factura_srv_fcts (
	fcts_pk BIGINT NOT NULL
	, fcts_fctr_pk BIGINT NOT NULL
	, fcts_srvc_pk BIGINT NOT NULL
	, fcts_aspc_pk BIGINT NOT NULL
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

CREATE INDEX ix_fcts_fctr_pk ON tbl_factura_srv_fcts (fcts_fctr_pk)\
CREATE INDEX ix_fcts_srvc_pk ON tbl_factura_srv_fcts (fcts_srvc_pk)\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_factura_srv_fcts TO portico\



-- tbl_factura_lin_fctl
CREATE TABLE tbl_factura_lin_fctl (
	fctl_pk BIGINT NOT NULL
	, fctl_padre_pk BIGINT NOT NULL
	, fctl_fctr_pk BIGINT NOT NULL
	, fctl_fcts_pk BIGINT NOT NULL
	, fctl_rgla_pk BIGINT NOT NULL
	, fctl_impuesto_prmt_pk BIGINT NOT NULL
	, fctl_ssrv_pk BIGINT
	, fctl_fini TIMESTAMP
	, fctl_ffin TIMESTAMP

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

CREATE INDEX ix_fctl_padre_pk ON tbl_factura_lin_fctl (fctl_padre_pk)\
CREATE INDEX ix_fctl_fctr_pk ON tbl_factura_lin_fctl (fctl_fctr_pk)\
CREATE INDEX ix_fctl_fcts_pk ON tbl_factura_lin_fctl (fctl_fcts_pk)\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_factura_lin_fctl TO portico\



-- tbl_factura_det_fctd
CREATE TABLE tbl_factura_det_fctd (
	fctd_pk BIGINT NOT NULL
	, fctd_fctr_pk BIGINT NOT NULL
	, fctd_fctl_pk BIGINT NOT NULL
	, fctd_importe_base NUMERIC(10, 2) NOT NULL
	, fctd_importe NUMERIC(10, 2) NOT NULL
	, fctd_ssrv_pk BIGINT
	, fctd_fini TIMESTAMP
	, fctd_ffin TIMESTAMP

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
		REFERENCES tbl_factura_fctr (fctr_pk)
	, CONSTRAINT fk_fctd_fctl_pk FOREIGN KEY (fctd_fctl_pk)
		REFERENCES tbl_factura_lin_fctl (fctl_pk)
	, CONSTRAINT fk_fctd_ssrv_pk FOREIGN KEY (fctd_ssrv_pk)
		REFERENCES tbl_subservicio_ssrv (ssrv_pk)
)\

CREATE INDEX ix_fctd_fctr_pk ON tbl_factura_det_fctd (fctd_fctr_pk)\
CREATE INDEX ix_fctd_fctl_pk ON tbl_factura_det_fctd (fctd_fctl_pk)\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_factura_det_fctd TO portico\



-- tbl_servicio_cargo_srcr
CREATE TABLE tbl_servicio_cargo_srcr (
	srcr_srvc_pk BIGINT NOT NULL
	, srcr_ssrv_pk BIGINT
	, srcr_crgo_pk BIGINT NOT NULL
	, srcr_fini TIMESTAMP
	, srcr_ffin TIMESTAMP
	, srcr_vlrc_pk BIGINT
	, srcr_fctr_pk BIGINT

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

CREATE INDEX ix_srcr_srvc_pk ON tbl_servicio_cargo_srcr (srcr_srvc_pk)\
CREATE INDEX ix_srcr_vlrc_pk ON tbl_servicio_cargo_srcr (srcr_vlrc_pk)\
CREATE INDEX ix_srcr_fctr_pk ON tbl_servicio_cargo_srcr (srcr_fctr_pk)\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_servicio_cargo_srcr TO portico\




-- tbl_estadistica_trim_estr
CREATE TABLE tbl_estadistica_trim_estr
(
	estr_pk BIGINT NOT NULL
	, estr_autp_pk BIGINT NOT NULL
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
	cdtr_pk 		BIGINT 				CONSTRAINT nn_cdtr_pk 			NOT NULL
	, cdtr_estr_pk 	BIGINT 				CONSTRAINT nn_cdtr_estr_pk 	NOT NULL
	, cdtr_cocu_pk 	BIGINT 				CONSTRAINT nn_cdtr_cocu_pk 	NOT NULL
	, cdtr_opet_pk 	BIGINT 				CONSTRAINT nn_cdtr_opet_pk 	NOT NULL
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

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_cuadro_trim_cdtr TO portico\

COMMENT ON TABLE tbl_cuadro_trim_cdtr IS 'Datos del Cuadro trimestral de la Estadistica de una AP'\
COMMENT ON COLUMN tbl_cuadro_trim_cdtr.cdtr_pk IS 'Identificador de Dato del Cuadro trimestral'\
COMMENT ON COLUMN tbl_cuadro_trim_cdtr.cdtr_estr_pk IS 'Identificador de Estadistica Trimestral a la que pertenece el dato del cuadro'\
COMMENT ON COLUMN tbl_cuadro_trim_cdtr.cdtr_cocu_pk IS 'Identificador de Concepto de Cuadro trimestral'\
COMMENT ON COLUMN tbl_cuadro_trim_cdtr.cdtr_opet_pk IS 'Identificador de Tipo de Operacion'\
COMMENT ON COLUMN tbl_cuadro_trim_cdtr.cdtr_cantidad IS 'Valor de Dato del Cuadro trimestral'\



-- tbl_configuration_conf
CREATE TABLE tbl_configuration_conf (
	conf_key VARCHAR(250) NOT NULL
	, conf_value_type VARCHAR(20) NOT NULL
	, conf_default_value VARCHAR(250) NOT NULL
	, conf_value VARCHAR(250)

	, CONSTRAINT pk_conf PRIMARY KEY (conf_key)
)\

GRANT SELECT, UPDATE ON tbl_configuration_conf TO portico\



-- tbl_message_mesg
CREATE TABLE tbl_message_mesg (
	mesg_key VARCHAR(100) NOT NULL
	, mesg_internal INT NOT NULL

	, CONSTRAINT pk_mesg PRIMARY KEY (mesg_key)
)\

GRANT SELECT ON tbl_message_mesg TO portico\

-- tbl_message_i18n_m18n
CREATE TABLE tbl_message_i18n_m18n (
	m18n_key VARCHAR(100) NOT NULL
	, m18n_language VARCHAR(5) NOT NULL
	, m18n_value VARCHAR(250) NOT NULL

	, CONSTRAINT pk_m18n PRIMARY KEY (m18n_key, m18n_language)

	, CONSTRAINT fk_m18n_mesg_key FOREIGN KEY (m18n_key)
		REFERENCES tbl_message_mesg (mesg_key)
)\

GRANT SELECT, INSERT, DELETE ON tbl_message_i18n_m18n TO portico\




-- tbl_campo_agregacion_cmag
CREATE TABLE tbl_campo_agregacion_cmag (
	cmag_tpes_pk BIGINT NOT NULL
	, cmag_entd_pk BIGINT NOT NULL
	, cmag_agregar INT NOT NULL
	, cmag_nombre VARCHAR(250)

	, CONSTRAINT pk_cmag PRIMARY KEY (cmag_tpes_pk, cmag_entd_pk)

	, CONSTRAINT fk_cmag_tpes_pk FOREIGN KEY (cmag_tpes_pk)
		REFERENCES tbl_tipo_estadistica_tpes (tpes_pk)
	, CONSTRAINT fk_cmag_entd_pk FOREIGN KEY (cmag_entd_pk)
		REFERENCES tbl_entidad_tipo_dato_entd (entd_pk)
)\

GRANT SELECT, UPDATE ON tbl_campo_agregacion_cmag TO portico\




-- tbl_proceso_archivo_prar
CREATE TABLE tbl_proceso_archivo_prar (
	prar_prbt_pk BIGINT NOT NULL
	, prar_arch_pk BIGINT NOT NULL

	, CONSTRAINT pk_prar PRIMARY KEY (prar_prbt_pk, prar_arch_pk)

	, CONSTRAINT fk_prar_prbt_pk FOREIGN KEY (prar_prbt_pk)
		REFERENCES tbl_proceso_batch_prbt (prbt_pk)
	, CONSTRAINT fk_prar_arch_pk FOREIGN KEY (prar_arch_pk)
		REFERENCES tbl_archivo_arch (arch_pk)
)
\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_proceso_archivo_prar TO portico\

-- tbl_servicio_archivo_srar
CREATE TABLE tbl_servicio_archivo_srar (
	srar_srvc_pk BIGINT NOT NULL
	, srar_arch_pk BIGINT NOT NULL

	, CONSTRAINT pk_srar PRIMARY KEY (srar_srvc_pk, srar_arch_pk)

	, CONSTRAINT fk_srar_srvc_pk FOREIGN KEY (srar_srvc_pk)
		REFERENCES tbl_servicio_srvc (srvc_pk)
	, CONSTRAINT fk_srar_arch_pk FOREIGN KEY (srar_arch_pk)
		REFERENCES tbl_archivo_arch (arch_pk)
)
\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_servicio_archivo_srar TO portico\









-- tbl_entidad_accgrid_enag
CREATE TABLE tbl_entidad_accgrid_enag (
	enag_pk BIGINT NOT NULL
	, enag_enti_pk BIGINT NOT NULL
	, enag_path VARCHAR(30) NOT NULL
	, enag_orden INT NOT NULL

	, CONSTRAINT pk_enag PRIMARY KEY (enag_pk)

	, CONSTRAINT uq_enag UNIQUE (enag_enti_pk, enag_path)

	, CONSTRAINT fk_enag_enti_pk FOREIGN KEY (enag_enti_pk)
		REFERENCES tbl_entidad_enti (enti_pk)
)
\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_entidad_accgrid_enag TO portico\





-- tbl_accion_accn
CREATE TABLE tbl_accion_accn (
	accn_pk BIGINT NOT NULL
	, accn_prefix VARCHAR(4) NOT NULL
	, accn_codigo VARCHAR(100) NOT NULL
	, accn_core INT NOT NULL
	, accn_multiple INT NOT NULL

	, CONSTRAINT pk_accn PRIMARY KEY (accn_pk)

	, CONSTRAINT uk_accn UNIQUE (accn_prefix, accn_codigo)
)\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_accion_accn TO portico\


-- tbl_accion_entidad_acen
CREATE TABLE tbl_accion_entidad_acen (
	acen_pk BIGINT NOT NULL
	, acen_accn_pk BIGINT NOT NULL
	, acen_enti_pk BIGINT NOT NULL

	, CONSTRAINT pk_acen PRIMARY KEY (acen_pk)

	, CONSTRAINT uk_acen UNIQUE (acen_accn_pk, acen_enti_pk)

	, CONSTRAINT fk_acen_accn_pk FOREIGN KEY (acen_accn_pk)
		REFERENCES tbl_accion_accn (accn_pk)
	, CONSTRAINT fk_acen_enti_pk FOREIGN KEY (acen_enti_pk)
		REFERENCES tbl_entidad_enti (enti_pk)
)\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_accion_entidad_acen TO portico\


-- tbl_grupo_accion_grac
CREATE TABLE tbl_grupo_accion_grac (
	grac_grpo_pk BIGINT NOT NULL
	, grac_accn_pk BIGINT NOT NULL

	, CONSTRAINT pk_grac PRIMARY KEY (grac_grpo_pk, grac_accn_pk)

	, CONSTRAINT fk_grac_grpo_pk FOREIGN KEY (grac_grpo_pk)
		REFERENCES tbl_grupo_grpo (grpo_pk)
		ON DELETE CASCADE
	, CONSTRAINT fk_grac_accn_pk FOREIGN KEY (grac_accn_pk)
		REFERENCES tbl_accion_accn (accn_pk)
		ON DELETE CASCADE
)\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_grupo_accion_grac TO portico\


-- tbl_grupo_accion_entidad_grae
CREATE TABLE tbl_grupo_accion_entidad_grae (
	grae_grpo_pk BIGINT NOT NULL
	, grae_acen_pk BIGINT NOT NULL

	, CONSTRAINT pk_grae PRIMARY KEY (grae_grpo_pk, grae_acen_pk)

	, CONSTRAINT fk_grae_grpo_pk FOREIGN KEY (grae_grpo_pk)
		REFERENCES tbl_grupo_grpo (grpo_pk)
		ON DELETE CASCADE
	, CONSTRAINT fk_grae_acen_pk FOREIGN KEY (grae_acen_pk)
		REFERENCES tbl_accion_entidad_acen (acen_pk)
		ON DELETE CASCADE
)\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_grupo_accion_entidad_grae TO portico\


-- tbl_tramite_trmt
CREATE TABLE tbl_tramite_trmt (
	trmt_pk BIGINT NOT NULL
	, trmt_enti_pk BIGINT NOT NULL
	, trmt_estado_orig CHAR(1) NOT NULL
	, trmt_estado_dest CHAR(1) NOT NULL

	, CONSTRAINT pk_trmt PRIMARY KEY (trmt_pk)
	, CONSTRAINT uq_trmt UNIQUE (trmt_enti_pk, trmt_estado_orig, trmt_estado_dest)

	, CONSTRAINT fk_trmt_enti_pk FOREIGN KEY (trmt_enti_pk)
		REFERENCES tbl_entidad_enti (enti_pk)
)\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_tramite_trmt TO portico\


-- tbl_tramite_tipo_dato_trtd
CREATE TABLE tbl_tramite_tipo_dato_trtd (
	trtd_trmt_pk BIGINT NOT NULL
	, trtd_tpdt_pk BIGINT NOT NULL
	, trtd_obligatorio INTEGER NOT NULL

	, CONSTRAINT pk_trtd PRIMARY KEY (trtd_trmt_pk, trtd_tpdt_pk)

	, CONSTRAINT fk_trtd_trmt_pk FOREIGN KEY (trtd_trmt_pk)
		REFERENCES tbl_tramite_trmt (trmt_pk)
)\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_tramite_tipo_dato_trtd TO portico\


-- tbl_item_tramite_ittr
CREATE TABLE tbl_item_tramite_ittr (
	ittr_pk BIGINT NOT NULL
	, ittr_item_pk BIGINT NOT NULL
	, ittr_trmt_pk BIGINT NOT NULL
	, ittr_falta TIMESTAMP NOT NULL
	, ittr_o_item_fini TIMESTAMP
	, ittr_o_item_ffin TIMESTAMP
	, ittr_d_item_fini TIMESTAMP
	, ittr_d_item_ffin TIMESTAMP

	, CONSTRAINT pk_ittr PRIMARY KEY (ittr_pk)

	, CONSTRAINT fk_ittr_trmt_pk FOREIGN KEY (ittr_trmt_pk)
		REFERENCES tbl_tramite_trmt (trmt_pk)
)\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_item_tramite_ittr TO portico\


-- tbl_item_trmt_dato_ittd
CREATE TABLE tbl_item_trmt_dato_ittd (
	ittd_ittr_pk BIGINT NOT NULL
	, ittd_tpdt_pk BIGINT NOT NULL
	, ittd_o_nentero BIGINT
	, ittd_o_ndecimal BIGINT
	, ittd_o_fecha TIMESTAMP
	, ittd_o_prmt_pk BIGINT
	, ittd_o_srvc_pk BIGINT
	, ittd_o_cadena VARCHAR(350)
	, ittd_d_nentero BIGINT
	, ittd_d_ndecimal BIGINT
	, ittd_d_fecha TIMESTAMP
	, ittd_d_prmt_pk BIGINT
	, ittd_d_srvc_pk BIGINT
	, ittd_d_cadena VARCHAR(350)

	, CONSTRAINT pk_ittd PRIMARY KEY (ittd_ittr_pk, ittd_tpdt_pk)

	, CONSTRAINT fk_ittd_ittr_pk FOREIGN KEY (ittd_ittr_pk)
		REFERENCES tbl_item_tramite_ittr (ittr_pk)
	, CONSTRAINT fk_ittd_tpdt_pk FOREIGN KEY (ittd_tpdt_pk)
		REFERENCES tbl_tipo_dato_tpdt (tpdt_pk)
	, CONSTRAINT fk_ittd_o_prmt_pk FOREIGN KEY (ittd_o_prmt_pk)
		REFERENCES tbl_parametro_prmt (prmt_pk)
	, CONSTRAINT fk_ittd_d_prmt_pk FOREIGN KEY (ittd_d_prmt_pk)
		REFERENCES tbl_parametro_prmt (prmt_pk)
	, CONSTRAINT fk_ittd_o_srvc_pk FOREIGN KEY (ittd_o_srvc_pk)
		REFERENCES tbl_servicio_srvc (srvc_pk)
	, CONSTRAINT fk_ittd_d_srvc_pk FOREIGN KEY (ittd_d_srvc_pk)
		REFERENCES tbl_servicio_srvc (srvc_pk)
)\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_item_trmt_dato_ittd TO portico\


-- tbl_parametro_trmt_prtr
CREATE TABLE tbl_parametro_trmt_prtr (
	prtr_pk BIGINT NOT NULL
	, prtr_prmt_pk BIGINT NOT NULL

	, CONSTRAINT pk_prtr PRIMARY KEY (prtr_pk)

	, CONSTRAINT fk_prtr_ittr_pk FOREIGN KEY (prtr_pk)
		REFERENCES tbl_item_tramite_ittr (ittr_pk)
	, CONSTRAINT fk_prtr_prmt_pk FOREIGN KEY (prtr_prmt_pk)
		REFERENCES tbl_parametro_prmt (prmt_pk)
)\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_parametro_trmt_prtr TO portico\


-- tbl_servicio_trmt_srtr
CREATE TABLE tbl_servicio_trmt_srtr (
	srtr_pk BIGINT NOT NULL
	, srtr_srvc_pk BIGINT NOT NULL

	, CONSTRAINT pk_srtr PRIMARY KEY (srtr_pk)

	, CONSTRAINT fk_srtr_ittr_pk FOREIGN KEY (srtr_pk)
		REFERENCES tbl_item_tramite_ittr (ittr_pk)
	, CONSTRAINT fk_srtr_srvc_pk FOREIGN KEY (srtr_srvc_pk)
		REFERENCES tbl_servicio_srvc (srvc_pk)
)\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_servicio_trmt_srtr TO portico\


-- tbl_subservicio_trmt_sstr
CREATE TABLE tbl_subservicio_trmt_sstr (
	sstr_pk BIGINT NOT NULL
	, sstr_ssrv_pk BIGINT NOT NULL

	, CONSTRAINT pk_sstr PRIMARY KEY (sstr_pk)

	, CONSTRAINT fk_sstr_ittr_pk FOREIGN KEY (sstr_pk)
		REFERENCES tbl_item_tramite_ittr (ittr_pk)
	, CONSTRAINT fk_sstr_ssrv_pk FOREIGN KEY (sstr_ssrv_pk)
		REFERENCES tbl_subservicio_ssrv (ssrv_pk)
)\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_subservicio_trmt_sstr TO portico\








-- //@UNDO
-- SQL to undo the change goes here.
DROP TABLE tbl_subservicio_trmt_sstr\
DROP TABLE tbl_servicio_trmt_srtr\
DROP TABLE tbl_parametro_trmt_prtr\
DROP TABLE tbl_item_trmt_dato_ittd\
DROP TABLE tbl_item_tramite_ittr\
DROP TABLE tbl_tramite_tipo_dato_trtd\
DROP TABLE tbl_tramite_trmt\
DROP TABLE tbl_grupo_accion_entidad_grae\
DROP TABLE tbl_grupo_accion_grac\
DROP TABLE tbl_accion_entidad_acen\
DROP TABLE tbl_accion_accn\
DROP TABLE tbl_entidad_accgrid_enag\
DROP TABLE tbl_servicio_archivo_srar\
DROP TABLE tbl_proceso_archivo_prar\
DROP TABLE tbl_campo_agregacion_cmag\
DROP TABLE tbl_message_i18n_m18n\
DROP TABLE tbl_message_mesg\
DROP TABLE tbl_configuration_conf\
DROP TABLE tbl_cuadro_trim_cdtr\
DROP TABLE tbl_estadistica_trim_estr\
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
DROP TABLE tbl_proceso_mensaje_prmn\
DROP TABLE tbl_proceso_item_prit\
DROP TABLE tbl_proceso_parametro_prpm\
DROP TABLE tbl_proceso_batch_prbt\
DROP TABLE tbl_cuadro_mes_cdms\
DROP TABLE tbl_estadistica_dato_esdt\
DROP TABLE tbl_estadistica_estd\
DROP TABLE tbl_periodo_proceso_pepr\
DROP TABLE tbl_tipo_estadistica_tpes\
DROP TABLE tbl_servicio_secuencia_srsc\
DROP TABLE tbl_subserv_subserv_ssss\
DROP TABLE tbl_subservicio_dato_ssdt\
DROP TABLE tbl_subservicio_ssrv\
DROP TABLE tbl_servicio_dato_srdt\
DROP TABLE tbl_servicio_srvc\
DROP TABLE tbl_tipo_subservicio_tpss\
DROP TABLE tbl_tipo_servicio_tpsr\
DROP TABLE tbl_subparametro_dato_spdt\
DROP TABLE tbl_subparametro_version_spvr\
DROP TABLE tbl_subparametro_sprm\
DROP TABLE tbl_tipo_subparametro_tpsp\
DROP TABLE tbl_parametro_dato_prdt\
DROP TABLE tbl_parametro_version_prvr\
DROP TABLE tbl_parametro_prmt\
DROP TABLE tbl_tipo_parametro_tppr\
DROP TABLE tbl_entidad_tipo_dato_entd\
DROP TABLE tbl_entidad_grupo_dato_engd\
DROP TABLE tbl_entidad_accion_enac\
DROP TABLE tbl_codigo_ref_cdrf\
DROP TABLE tbl_tipo_dato_tpdt\
DROP TABLE tbl_entidad_entidad_enen\
DROP TABLE tbl_entidad_enti\
DROP TABLE tbl_usuario_grupo_usgr\
DROP TABLE tbl_grupo_grpo\
DROP TABLE tbl_usuario_usro\
DROP TABLE tbl_puerto_prto\
DROP TABLE tbl_superpuerto_sprt\
DROP TABLE tbl_ig\
DROP TABLE tbl_i18n_i18n\
DROP TABLE tbl_archivo_arch\
