-- // 0.0.1
-- Migration SQL that makes the change goes here.


-- tbl_conf_clave_cncl
CREATE TABLE portico.tbl_conf_clave_cncl
(
	cncl_pk BIGINT NOT NULL
	, cncl_clave VARCHAR(80) NOT NULL
	, cncl_tipo_valor VARCHAR(2) NOT NULL
	, cncl_valor_defecto VARCHAR(200) NOT NULL

	, CONSTRAINT pk_cncl PRIMARY KEY (cncl_pk)
	, CONSTRAINT uq_cncl UNIQUE (cncl_clave)
)
/


GRANT SELECT, INSERT, UPDATE, DELETE ON portico.tbl_conf_clave_cncl TO portico
/

COMMENT ON TABLE portico.tbl_conf_clave_cncl IS 'Claves de Parametros de Configuracion'
/
COMMENT ON COLUMN portico.tbl_conf_clave_cncl.cncl_pk IS 'Identificador de clave'
/
COMMENT ON COLUMN portico.tbl_conf_clave_cncl.cncl_tipo_valor IS 'Tipo de Valor del parametro (Fecha, numero, ...)'
/
COMMENT ON COLUMN portico.tbl_conf_clave_cncl.cncl_clave IS 'Clave del parametro'
/
COMMENT ON COLUMN portico.tbl_conf_clave_cncl.cncl_valor_defecto IS 'Valor por defecto del parametro'
/



-- tbl_conf_clave_i18n_cnci
CREATE TABLE portico.tbl_conf_clave_i18n_cnci
(
	cnci_pk BIGINT NOT NULL
	, cnci_clave VARCHAR(80) NOT NULL
	, cnci_valor_defecto VARCHAR(200) NOT NULL

	, CONSTRAINT pk_cnci PRIMARY KEY (cnci_pk)
	, CONSTRAINT uq_cnci UNIQUE (cnci_clave)
)
/

GRANT SELECT, INSERT, UPDATE, DELETE ON portico.tbl_conf_clave_i18n_cnci TO portico
/

COMMENT ON TABLE portico.tbl_conf_clave_i18n_cnci IS 'Claves de Configuracion de idioma'
/
COMMENT ON COLUMN portico.tbl_conf_clave_i18n_cnci.cnci_pk IS 'Identificador de clave de idioma'
/
COMMENT ON COLUMN portico.tbl_conf_clave_i18n_cnci.cnci_clave IS 'Identificador de clave'
/
COMMENT ON COLUMN portico.tbl_conf_clave_i18n_cnci.cnci_valor_defecto IS 'Valor por Defecto'
/



-- tbl_configuracion_idioma_cnid
CREATE TABLE portico.tbl_configuracion_idioma_cnid
(
	cnid_pk BIGINT NOT NULL
	, cnid_codigo VARCHAR(5) NOT NULL
	, cnid_descripcion VARCHAR(100)

	, CONSTRAINT pk_cnid PRIMARY KEY (cnid_pk)
	, CONSTRAINT uq_cnid UNIQUE (cnid_codigo)
)
/

GRANT SELECT, INSERT, UPDATE, DELETE ON portico.tbl_configuracion_idioma_cnid TO portico
/

COMMENT ON TABLE portico.tbl_configuracion_idioma_cnid IS 'Configuraciones de idioma'
/
COMMENT ON COLUMN portico.tbl_configuracion_idioma_cnid.cnid_pk IS 'Identificador de configuracion de idioma'
/
COMMENT ON COLUMN portico.tbl_configuracion_idioma_cnid.cnid_codigo IS 'Codigo de configuracion de idioma'
/
COMMENT ON COLUMN portico.tbl_configuracion_idioma_cnid.cnid_descripcion IS 'Descripcion de configuracion de idioma'
/



-- tbl_configuracion_entorno_cnen
CREATE TABLE portico.tbl_configuracion_entorno_cnen
(
	cnen_pk BIGINT NOT NULL
	, cnen_codigo VARCHAR(8) NOT NULL
	, cnen_nombre VARCHAR(50) NOT NULL

	, CONSTRAINT pk_cnen PRIMARY KEY (cnen_pk)
	, CONSTRAINT uq_cnen UNIQUE (cnen_codigo)
)
/

GRANT SELECT, INSERT, UPDATE, DELETE ON portico.tbl_configuracion_entorno_cnen TO portico
/

COMMENT ON TABLE portico.tbl_configuracion_entorno_cnen IS 'Entornos de Configuracion'
/
COMMENT ON COLUMN portico.tbl_configuracion_entorno_cnen.cnen_pk IS 'Identificador de entorno'
/
COMMENT ON COLUMN portico.tbl_configuracion_entorno_cnen.cnen_codigo IS 'Codigo de entorno'
/
COMMENT ON COLUMN portico.tbl_configuracion_entorno_cnen.cnen_nombre IS 'Nombre de entorno'
/



-- tbl_configuracion_valor_cnvl
CREATE TABLE portico.tbl_configuracion_valor_cnvl
(
	cnvl_cnen_pk BIGINT NOT NULL
	, cnvl_cncl_pk BIGINT NOT NULL
	, cnvl_valor VARCHAR(200) NOT NULL

	, CONSTRAINT pk_cnvl PRIMARY KEY (cnvl_cnen_pk, cnvl_cncl_pk)

	, CONSTRAINT fk_cnvl_cnen_pk FOREIGN KEY (cnvl_cnen_pk)
		REFERENCES portico.tbl_configuracion_entorno_cnen (cnen_pk)
	, CONSTRAINT fk_cnvl_cncl_pk FOREIGN KEY (cnvl_cncl_pk)
		REFERENCES portico.tbl_conf_clave_cncl (cncl_pk)
)
/

GRANT SELECT, INSERT, UPDATE, DELETE ON portico.tbl_configuracion_valor_cnvl TO portico
/

COMMENT ON TABLE portico.tbl_configuracion_valor_cnvl IS 'Valores de parametros de configuracion'
/
COMMENT ON COLUMN portico.tbl_configuracion_valor_cnvl.cnvl_cnen_pk IS 'Identificador de entorno'
/
COMMENT ON COLUMN portico.tbl_configuracion_valor_cnvl.cnvl_cncl_pk IS 'Identificador de clave'
/
COMMENT ON COLUMN portico.tbl_configuracion_valor_cnvl.cnvl_valor IS 'Valor de parametro'
/



-- tbl_conf_valor_i18n_cnvi
CREATE TABLE portico.tbl_conf_valor_i18n_cnvi
(
	cnvi_cnid_pk BIGINT NOT NULL
	, cnvi_cnci_pk BIGINT NOT NULL
	, cnvi_valor VARCHAR(200) NOT NULL

	, CONSTRAINT pk_cnvi PRIMARY KEY (cnvi_cnid_pk, cnvi_cnci_pk)

	, CONSTRAINT fk_cnvi_cnid_pk FOREIGN KEY (cnvi_cnid_pk)
		REFERENCES portico.tbl_configuracion_idioma_cnid (cnid_pk)
	, CONSTRAINT fk_cnvi_cnci_pk FOREIGN KEY (cnvi_cnci_pk)
		REFERENCES portico.tbl_conf_clave_i18n_cnci (cnci_pk)
)
/

GRANT SELECT, INSERT, UPDATE, DELETE ON portico.tbl_conf_valor_i18n_cnvi TO portico
/

COMMENT ON TABLE portico.tbl_conf_valor_i18n_cnvi IS 'Valores de parametros de configuracion de idioma'
/
COMMENT ON COLUMN portico.tbl_conf_valor_i18n_cnvi.cnvi_cnid_pk IS 'Identificador de Configuracion de Idioma'
/
COMMENT ON COLUMN portico.tbl_conf_valor_i18n_cnvi.cnvi_cnci_pk IS 'Identificador de Parametro de Configuracion de Idioma'
/
COMMENT ON COLUMN portico.tbl_conf_valor_i18n_cnvi.cnvi_valor IS 'Valor de Parametro'
/



-- tbl_ig
CREATE TABLE portico.tbl_ig
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

GRANT SELECT, INSERT, UPDATE, DELETE ON portico.tbl_ig TO portico
/

COMMENT ON TABLE portico.tbl_ig IS 'Generadores de Secuencias de las Tablas de la Aplicacion'
/
COMMENT ON COLUMN portico.tbl_ig.ig_nombre IS 'Nombre del generador de identificadores'
/
COMMENT ON COLUMN portico.tbl_ig.ig_inicio IS 'Numero de inicio de la secuencia'
/
COMMENT ON COLUMN portico.tbl_ig.ig_fin IS 'Numero de fin de la secuencia'
/
COMMENT ON COLUMN portico.tbl_ig.ig_incremento IS 'Incremento de la secuencia'
/
COMMENT ON COLUMN portico.tbl_ig.ig_cache IS 'Numero de elementos reservados cada vez que se pide valor a la secuencia'
/
COMMENT ON COLUMN portico.tbl_ig.ig_ultimo IS 'Ultimo Valor generado para la secuencia'
/



-- tbl_usuario_usro
CREATE TABLE portico.tbl_usuario_usro
(
	usro_pk BIGINT NOT NULL
	, usro_login VARCHAR(50) NOT NULL
	, usro_contrasenia VARCHAR(50) NOT NULL
	, usro_nombre VARCHAR(50) NOT NULL

	, CONSTRAINT pk_usro PRIMARY KEY (usro_pk)
	, CONSTRAINT uq_usro UNIQUE (usro_login)
)
/

GRANT SELECT, INSERT, UPDATE, DELETE ON portico.tbl_usuario_usro TO portico
/

COMMENT ON TABLE portico.tbl_usuario_usro IS 'Usuarios'
/
COMMENT ON COLUMN portico.tbl_usuario_usro.usro_pk IS 'Identificador de usuario'
/
COMMENT ON COLUMN portico.tbl_usuario_usro.usro_login IS 'Login'
/
COMMENT ON COLUMN portico.tbl_usuario_usro.usro_contrasenia IS 'Contrasenia'
/
COMMENT ON COLUMN portico.tbl_usuario_usro.usro_nombre IS 'Nombre Completo'
/



-- tbl_grupo_grpo
CREATE TABLE portico.tbl_grupo_grpo
(
	grpo_pk BIGINT NOT NULL
	, grpo_nombre VARCHAR(50) NOT NULL

	, CONSTRAINT pk_grpo PRIMARY KEY (grpo_pk)
	, CONSTRAINT uq_grpo UNIQUE (grpo_nombre)
)
/

GRANT SELECT, INSERT, UPDATE, DELETE ON portico.tbl_grupo_grpo TO portico
/

COMMENT ON TABLE portico.tbl_grupo_grpo IS 'Grupos de usuarios'
/
COMMENT ON COLUMN portico.tbl_grupo_grpo.grpo_pk IS 'Identificador de grupo'
/
COMMENT ON COLUMN portico.tbl_grupo_grpo.grpo_nombre IS 'Nombre de grupo'
/



-- tbl_usuario_grupo_usgr
CREATE TABLE portico.tbl_usuario_grupo_usgr
(
	usgr_usro_pk BIGINT NOT NULL
	, usgr_grpo_pk BIGINT NOT NULL

	, CONSTRAINT pk_usgr PRIMARY KEY (usgr_usro_pk, usgr_grpo_pk)

	, CONSTRAINT fk_usgr_usro_pk FOREIGN KEY (usgr_usro_pk)
		REFERENCES portico.tbl_usuario_usro (usro_pk)
	, CONSTRAINT fk_usgr_grpo_pk FOREIGN KEY (usgr_grpo_pk)
		REFERENCES portico.tbl_grupo_grpo (grpo_pk)
)
/

GRANT SELECT, INSERT, UPDATE, DELETE ON portico.tbl_usuario_grupo_usgr TO portico
/

COMMENT ON TABLE portico.tbl_usuario_grupo_usgr IS 'Asociaciones de usuarios a grupos'
/
COMMENT ON COLUMN portico.tbl_usuario_grupo_usgr.usgr_usro_pk IS 'Identificador de usuario'
/
COMMENT ON COLUMN portico.tbl_usuario_grupo_usgr.usgr_grpo_pk IS 'Identificador de grupo de usuarios'
/



-- tbl_entidad_enti
CREATE TABLE portico.tbl_entidad_enti
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

GRANT SELECT, INSERT, UPDATE, DELETE ON portico.tbl_entidad_enti TO portico
/

COMMENT ON TABLE portico.tbl_entidad_enti IS 'Entidades de la aplicacion'
/
COMMENT ON COLUMN portico.tbl_entidad_enti.enti_pk IS 'Identificador de Entidad'
/
COMMENT ON COLUMN portico.tbl_entidad_enti.enti_codigo IS 'Codigo Unico'
/
COMMENT ON COLUMN portico.tbl_entidad_enti.enti_tipo IS 'Tipo de Entidad: P (Parametrico) - T (Tipo de Servicio) - S (Tipo de Subservicio)'
/
COMMENT ON COLUMN portico.tbl_entidad_enti.enti_cmd_alta IS 'Comando de alta Habilitado?'
/
COMMENT ON COLUMN portico.tbl_entidad_enti.enti_cmd_baja IS 'Comando de baja Habilitado?'
/
COMMENT ON COLUMN portico.tbl_entidad_enti.enti_cmd_edicion IS 'Comando de edicion Habilitado?'
/
COMMENT ON COLUMN portico.tbl_entidad_enti.enti_cmd_duplicado IS 'Comando de duplicado Habilitado?'
/
COMMENT ON COLUMN portico.tbl_entidad_enti.enti_nombre IS 'Nombre de Entidad'
/



-- tbl_entidad_entidad_enen
CREATE TABLE portico.tbl_entidad_entidad_enen
(
	enen_entip_pk BIGINT NOT NULL
	, enen_entih_pk BIGINT NOT NULL
	, enen_orden int NOT NULL

	, CONSTRAINT pk_enen PRIMARY KEY (enen_entip_pk, enen_entih_pk)

	, CONSTRAINT fk_enen_entip_pk FOREIGN KEY (enen_entip_pk)
		REFERENCES portico.tbl_entidad_enti (enti_pk)
	, CONSTRAINT fk_enen_entih_pk FOREIGN KEY (enen_entih_pk)
		REFERENCES portico.tbl_entidad_enti (enti_pk)
)
/

GRANT SELECT, INSERT, UPDATE, DELETE ON portico.tbl_entidad_entidad_enen TO portico
/

COMMENT ON TABLE portico.tbl_entidad_entidad_enen IS 'Relacion de Dependencia entre Entidades de la aplicacion'
/
COMMENT ON COLUMN portico.tbl_entidad_entidad_enen.enen_entip_pk IS 'Identificador de Entidad Padre'
/
COMMENT ON COLUMN portico.tbl_entidad_entidad_enen.enen_entih_pk IS 'Identificador de Entidad Hija'
/
COMMENT ON COLUMN portico.tbl_entidad_entidad_enen.enen_orden IS 'Orden de Entidad Hija con Respecto a la entidad Padre'
/





-- tbl_tipo_dato_tpdt
CREATE TABLE portico.tbl_tipo_dato_tpdt
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
		REFERENCES portico.tbl_entidad_enti (enti_pk)
)
/

GRANT SELECT, INSERT, UPDATE, DELETE ON portico.tbl_tipo_dato_tpdt TO portico
/

COMMENT ON TABLE portico.tbl_tipo_dato_tpdt IS 'Tipos de dato de la aplicacion'
/
COMMENT ON COLUMN portico.tbl_tipo_dato_tpdt.tpdt_pk IS 'Identificador de Tipo de Dato'
/
COMMENT ON COLUMN portico.tbl_tipo_dato_tpdt.tpdt_codigo IS 'Codigo de Tipo de Dato'
/
COMMENT ON COLUMN portico.tbl_tipo_dato_tpdt.tpdt_nombre IS 'Nombre de Tipo de Dato'
/
COMMENT ON COLUMN portico.tbl_tipo_dato_tpdt.tpdt_tipo_html IS 'Tipo Html con el que se representa el Tipo de Dato'
/
COMMENT ON COLUMN portico.tbl_tipo_dato_tpdt.tpdt_tipo_elemento IS 'Tipo de elemento que almacena el tipo de dato. Puede tomar los valores: L (Long), D (Double), S (String), T (Date), B (Boolean), P (Parametro)'
/
COMMENT ON COLUMN portico.tbl_tipo_dato_tpdt.tpdt_enti_pk IS 'Entidad asociada al tipo de dato'
/



-- tbl_codigo_referencia_cdrf
CREATE TABLE portico.tbl_codigo_referencia_cdrf
(
	cdrf_tpdt_pk BIGINT NOT NULL
	, cdrf_valor VARCHAR(10) NOT NULL
	, cdrf_orden int NOT NULL

	, CONSTRAINT pk_cdrf PRIMARY KEY (cdrf_tpdt_pk, cdrf_valor)

	, CONSTRAINT fk_cdrf_tpdt_pk FOREIGN KEY (cdrf_tpdt_pk)
		REFERENCES portico.tbl_tipo_dato_tpdt (tpdt_pk)
)
/

GRANT SELECT, INSERT, UPDATE, DELETE ON portico.tbl_codigo_referencia_cdrf TO portico
/

COMMENT ON TABLE portico.tbl_codigo_referencia_cdrf IS 'Tipos de dato de la aplicacion'
/
COMMENT ON COLUMN portico.tbl_codigo_referencia_cdrf.cdrf_tpdt_pk IS 'Identificador de Tipo de Dato'
/
COMMENT ON COLUMN portico.tbl_codigo_referencia_cdrf.cdrf_valor IS 'Valor del Codigo de Referencia'
/
COMMENT ON COLUMN portico.tbl_codigo_referencia_cdrf.cdrf_orden IS 'Orden de Visualiazacion del Codigo de Referencia dentro de un Tipo de Dato'
/



-- tbl_entidad_accion_enac
CREATE TABLE portico.tbl_entidad_accion_enac
(
	enac_enti_pk BIGINT NOT NULL
	, enac_path VARCHAR(30) NOT NULL
	, enac_etiqueta VARCHAR(30) NOT NULL
	, enac_orden int NOT NULL

	, CONSTRAINT pk_enac PRIMARY KEY (enac_enti_pk, enac_path)

	, CONSTRAINT fk_enac_enti_pk FOREIGN KEY (enac_enti_pk)
		REFERENCES portico.tbl_entidad_enti (enti_pk)
)
/

GRANT SELECT, INSERT, UPDATE, DELETE ON portico.tbl_entidad_accion_enac TO portico
/

COMMENT ON TABLE portico.tbl_entidad_accion_enac IS 'Acciones asociadas a entidades'
/
COMMENT ON COLUMN portico.tbl_entidad_accion_enac.enac_enti_pk IS 'Identificador de Entidad'
/
COMMENT ON COLUMN portico.tbl_entidad_accion_enac.enac_path IS 'Path para construir la URL de la accion'
/
COMMENT ON COLUMN portico.tbl_entidad_accion_enac.enac_etiqueta IS 'Etiqueta de visualizacion de la accion en Web'
/
COMMENT ON COLUMN portico.tbl_entidad_accion_enac.enac_enti_pk IS 'Orden de aparacion de la accion dentro de las acciones de una entidad'
/



-- tbl_entidad_grupo_dato_engd
CREATE TABLE portico.tbl_entidad_grupo_dato_engd
(
	engd_enti_pk BIGINT NOT NULL
	, engd_orden int NOT NULL
	, engd_etiqueta VARCHAR(30) NOT NULL

	, CONSTRAINT pk_engd PRIMARY KEY (engd_enti_pk, engd_orden)

	, CONSTRAINT fk_engd_enti_pk FOREIGN KEY (engd_enti_pk)
		REFERENCES portico.tbl_entidad_enti (enti_pk)
)
/

GRANT SELECT, INSERT, UPDATE, DELETE ON portico.tbl_entidad_grupo_dato_engd TO portico
/

COMMENT ON TABLE portico.tbl_entidad_grupo_dato_engd IS 'Grupos de datos en los que se organizan las entidades'
/
COMMENT ON COLUMN portico.tbl_entidad_grupo_dato_engd.engd_enti_pk IS 'Identificador de Entidad'
/
COMMENT ON COLUMN portico.tbl_entidad_grupo_dato_engd.engd_orden IS 'Orden del grupo de datos dentro de la entidad'
/
COMMENT ON COLUMN portico.tbl_entidad_grupo_dato_engd.engd_etiqueta IS 'Etiqueta del grupo de datos'
/



-- tbl_entidad_tipo_dato_entd
CREATE TABLE portico.tbl_entidad_tipo_dato_entd
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
		REFERENCES portico.tbl_entidad_enti (enti_pk)
	, CONSTRAINT fk_entd_tpdt_pk FOREIGN KEY (entd_tpdt_pk)
		REFERENCES portico.tbl_tipo_dato_tpdt (tpdt_pk)
)
/

GRANT SELECT, INSERT, UPDATE, DELETE ON portico.tbl_entidad_tipo_dato_entd TO portico
/

COMMENT ON TABLE portico.tbl_entidad_tipo_dato_entd IS 'Tipos de datos de los que se componen las entidades'
/
COMMENT ON COLUMN portico.tbl_entidad_tipo_dato_entd.entd_enti_pk IS 'Identificador de Entidad'
/
COMMENT ON COLUMN portico.tbl_entidad_tipo_dato_entd.entd_tpdt_pk IS 'Identificador de Tipo de Dato'
/
COMMENT ON COLUMN portico.tbl_entidad_tipo_dato_entd.entd_grupo IS 'Numero de grupo al que pertenece el tipo de dato dentro de la entidad'
/
COMMENT ON COLUMN portico.tbl_entidad_tipo_dato_entd.entd_fila IS 'Numero de Fila en el que aparece el tipo de Dato'
/
COMMENT ON COLUMN portico.tbl_entidad_tipo_dato_entd.entd_orden IS 'Orden del tipo de Dato dentro de una fila'
/
COMMENT ON COLUMN portico.tbl_entidad_tipo_dato_entd.entd_span IS 'Ancho del tipo de dato'
/
COMMENT ON COLUMN portico.tbl_entidad_tipo_dato_entd.entd_obligatorio IS 'Indicador de si el tipo de dato debe tener valor asociado'
/
COMMENT ON COLUMN portico.tbl_entidad_tipo_dato_entd.entd_gridable IS 'Indicador de si el tipo de dato va a ser visible en los grids de datos de la Entidad'
/
COMMENT ON COLUMN portico.tbl_entidad_tipo_dato_entd.entd_filtrable IS 'Indicador de si el tipo de dato va a ser visible en los filtros de busqueda de la Entidad'
/
COMMENT ON COLUMN portico.tbl_entidad_tipo_dato_entd.entd_valor_defecto IS 'Valor por defecto del tipo de dato'
/
COMMENT ON COLUMN portico.tbl_entidad_tipo_dato_entd.entd_etiqueta IS 'Etiqueta de visualizacion'
/



-- tbl_tipo_parametro_tppr
CREATE TABLE portico.tbl_tipo_parametro_tppr
(
	tppr_pk BIGINT NOT NULL
	, tppr_es_i18n int NOT NULL
	, tppr_es_tmp_exp int NOT NULL
	, tppr_tpdt_pk BIGINT

	, CONSTRAINT pk_tppr PRIMARY KEY (tppr_pk)

	, CONSTRAINT fk_tppr_enti_pk FOREIGN KEY (tppr_pk)
		REFERENCES portico.tbl_entidad_enti (enti_pk)
	, CONSTRAINT fk_tppr_tpdt_pk FOREIGN KEY (tppr_tpdt_pk)
		REFERENCES portico.tbl_tipo_dato_tpdt (tpdt_pk)
)
/

GRANT SELECT, INSERT, UPDATE, DELETE ON portico.tbl_tipo_parametro_tppr TO portico
/

COMMENT ON TABLE portico.tbl_tipo_parametro_tppr IS 'Tipos de Parametro de la aplicacion (Definicion de Maestros)'
/
COMMENT ON COLUMN portico.tbl_tipo_parametro_tppr.tppr_pk IS 'Identificador de Tipo de Parametro'
/
COMMENT ON COLUMN portico.tbl_tipo_parametro_tppr.tppr_es_i18n IS 'Indicador de si el parametro tiene descripciones internacionalizables'
/
COMMENT ON COLUMN portico.tbl_tipo_parametro_tppr.tppr_es_tmp_exp IS 'Indicador de si el parametro tiene temporalidad explicita'
/
COMMENT ON COLUMN portico.tbl_tipo_parametro_tppr.tppr_tpdt_pk IS 'Identificador de tipo de dato que almacena la descripcion del parametro (utilizado en maestros sin i18n)'
/



-- tbl_parametro_prmt
CREATE TABLE portico.tbl_parametro_prmt
(
	prmt_pk BIGINT NOT NULL
	, prmt_tppr_pk BIGINT NOT NULL
	, prmt_parametro VARCHAR(30) NOT NULL

	, CONSTRAINT pk_prmt PRIMARY KEY (prmt_pk)
	, CONSTRAINT uq_prmt UNIQUE (prmt_tppr_pk, prmt_parametro)

	, CONSTRAINT fk_prmt_tppr_pk FOREIGN KEY (prmt_tppr_pk)
		REFERENCES portico.tbl_tipo_parametro_tppr (tppr_pk)
)
/

GRANT SELECT, INSERT, UPDATE, DELETE ON portico.tbl_parametro_prmt TO portico
/

COMMENT ON TABLE portico.tbl_parametro_prmt IS 'Parametros de la aplicacion (Datos de Maestros)'
/
COMMENT ON COLUMN portico.tbl_parametro_prmt.prmt_pk IS 'Identificador de Parametro'
/
COMMENT ON COLUMN portico.tbl_parametro_prmt.prmt_tppr_pk IS 'Identificador de Tipo de Parametro al que pertenece el parametro'
/
COMMENT ON COLUMN portico.tbl_parametro_prmt.prmt_parametro IS 'Valor de Parametro'
/



-- tbl_parametro_version_prvr
CREATE TABLE portico.tbl_parametro_version_prvr
(
	prvr_pk BIGINT NOT NULL
	, prvr_prmt_pk BIGINT NOT NULL
	, prvr_fini timestamp NOT NULL
	, prvr_ffin timestamp

	, CONSTRAINT pk_prvr PRIMARY KEY (prvr_pk)

	, CONSTRAINT fk_prvr_prmt_pk FOREIGN KEY (prvr_prmt_pk)
		REFERENCES portico.tbl_parametro_prmt (prmt_pk)
)
/

CREATE INDEX ix_prvr_prmt_pk ON portico.tbl_parametro_version_prvr(prvr_prmt_pk)
/

GRANT SELECT, INSERT, UPDATE, DELETE ON portico.tbl_parametro_version_prvr TO portico
/

COMMENT ON TABLE portico.tbl_parametro_version_prvr IS 'Versiones de Parametros de la aplicacion (Temporalidad de Datos de Maestros)'
/
COMMENT ON COLUMN portico.tbl_parametro_version_prvr.prvr_pk IS 'Identificador de Version de Parametro'
/
COMMENT ON COLUMN portico.tbl_parametro_version_prvr.prvr_fini IS 'Fecha de inicio de vigencia de la Version'
/
COMMENT ON COLUMN portico.tbl_parametro_version_prvr.prvr_ffin IS 'Fecha de fin de vigencia de la Version'
/



-- tbl_parametro_dato_prdt
CREATE TABLE portico.tbl_parametro_dato_prdt
(
	prdt_prvr_pk BIGINT NOT NULL
	, prdt_tpdt_pk BIGINT NOT NULL
	, prdt_nentero BIGINT
	, prdt_ndecimal DOUBLE PRECISION
	, prdt_fecha timestamp
	, prdt_prmt_pk BIGINT
	, prdt_cadena VARCHAR(350)

	, CONSTRAINT pk_prdt PRIMARY KEY (prdt_prvr_pk, prdt_tpdt_pk)

	, CONSTRAINT fk_prdt_prvr_pk FOREIGN KEY (prdt_prvr_pk)
		REFERENCES portico.tbl_parametro_version_prvr (prvr_pk)
	, CONSTRAINT fk_prdt_tpdt_pk FOREIGN KEY (prdt_tpdt_pk)
		REFERENCES portico.tbl_tipo_dato_tpdt (tpdt_pk)
	, CONSTRAINT fk_prdt_prmt_pk FOREIGN KEY (prdt_prmt_pk)
		REFERENCES portico.tbl_parametro_prmt (prmt_pk)
)
/

CREATE INDEX ix_prdt_prmt_pk ON portico.tbl_parametro_dato_prdt (prdt_prmt_pk)
/
CREATE INDEX ix_prdt_cadena ON portico.tbl_parametro_dato_prdt (prdt_tpdt_pk, prdt_cadena)
/

GRANT SELECT, INSERT, UPDATE, DELETE ON portico.tbl_parametro_dato_prdt TO portico
/

COMMENT ON TABLE portico.tbl_parametro_dato_prdt IS 'Datos Asociados a las Versiones de Parametros de la aplicacion (Datos de Maestros)'
/
COMMENT ON COLUMN portico.tbl_parametro_dato_prdt.prdt_prvr_pk IS 'Identificador de Version de Parametro'
/
COMMENT ON COLUMN portico.tbl_parametro_dato_prdt.prdt_tpdt_pk IS 'Identificador de Tipo de Dato'
/
COMMENT ON COLUMN portico.tbl_parametro_dato_prdt.prdt_nentero IS 'Valor de dato de Tipo Cantidad Entera'
/
COMMENT ON COLUMN portico.tbl_parametro_dato_prdt.prdt_ndecimal IS 'Valor de dato de Tipo Cantidad Decimal'
/
COMMENT ON COLUMN portico.tbl_parametro_dato_prdt.prdt_fecha IS 'Valor de dato de Tipo Fecha'
/
COMMENT ON COLUMN portico.tbl_parametro_dato_prdt.prdt_prmt_pk IS 'Valor de dato de Tipo Maestro'
/
COMMENT ON COLUMN portico.tbl_parametro_dato_prdt.prdt_cadena IS 'Valor de dato de Tipo Texto'
/



-- tbl_parametro_i18n_p18n
CREATE TABLE portico.tbl_parametro_i18n_p18n
(
	p18n_prvr_pk BIGINT NOT NULL
	, p18n_idioma VARCHAR(5) NOT NULL
	, p18n_texto VARCHAR(350) NOT NULL

	, CONSTRAINT pk_p18n PRIMARY KEY (p18n_prvr_pk, p18n_idioma)

	, CONSTRAINT fk_p18n_prvr_pk FOREIGN KEY (p18n_prvr_pk)
		REFERENCES portico.tbl_parametro_version_prvr (prvr_pk)
)
/

GRANT SELECT, INSERT, UPDATE, DELETE ON portico.tbl_parametro_i18n_p18n TO portico
/

COMMENT ON TABLE portico.tbl_parametro_i18n_p18n IS 'Textos internacionalizados Asociados a las Versiones de Parametros de la aplicacion (Textos i18n de Maestros)'
/
COMMENT ON COLUMN portico.tbl_parametro_i18n_p18n.p18n_prvr_pk IS 'Identificador de Version de Parametro'
/
COMMENT ON COLUMN portico.tbl_parametro_i18n_p18n.p18n_idioma IS 'Idioma del texto'
/
COMMENT ON COLUMN portico.tbl_parametro_i18n_p18n.p18n_texto IS 'Texto'
/



-- tbl_tipo_subparametro_tpsp
CREATE TABLE portico.tbl_tipo_subparametro_tpsp
(
	tpsp_pk BIGINT NOT NULL
	, tpsp_tppr_pk BIGINT NOT NULL
	, tpsp_tppr_dep_pk BIGINT NOT NULL
	, tpsp_es_i18n int NOT NULL
	, tpsp_es_tmp_exp int NOT NULL

	, CONSTRAINT pk_tpsp PRIMARY KEY (tpsp_pk)
	, CONSTRAINT uq_tpsp UNIQUE (tpsp_tppr_pk, tpsp_tppr_dep_pk)

	, CONSTRAINT fk_tpsp_enti_pk FOREIGN KEY (tpsp_pk)
		REFERENCES portico.tbl_entidad_enti (enti_pk)
	, CONSTRAINT fk_tpsp_tppr_pk FOREIGN KEY (tpsp_tppr_pk)
		REFERENCES portico.tbl_tipo_parametro_tppr (tppr_pk)
	, CONSTRAINT fk_tpsp_tppr_dep_pk FOREIGN KEY (tpsp_tppr_dep_pk)
		REFERENCES portico.tbl_tipo_parametro_tppr (tppr_pk)
)
/

GRANT SELECT, INSERT, UPDATE, DELETE ON portico.tbl_tipo_subparametro_tpsp TO portico
/

COMMENT ON TABLE portico.tbl_tipo_subparametro_tpsp IS 'Tipos de Subparametro de la aplicacion (Definicion de Maestros dependientes de otros maestros)'
/
COMMENT ON COLUMN portico.tbl_tipo_subparametro_tpsp.tpsp_pk IS 'Identificador de Tipo de Subparametro'
/
COMMENT ON COLUMN portico.tbl_tipo_subparametro_tpsp.tpsp_tppr_pk IS 'Identificador de Tipo de Parametro Padre'
/
COMMENT ON COLUMN portico.tbl_tipo_subparametro_tpsp.tpsp_tppr_dep_pk IS 'Identificador de Tipo de Parametro Asociado'
/
COMMENT ON COLUMN portico.tbl_tipo_subparametro_tpsp.tpsp_es_i18n IS 'Indicador de si el tipo de Subparametro tiene internacionalizacion'
/
COMMENT ON COLUMN portico.tbl_tipo_subparametro_tpsp.tpsp_es_tmp_exp IS 'Indicador de si el tipo de Subparametro tiene temporalidad explicita'
/



-- tbl_subparametro_sprm
CREATE TABLE portico.tbl_subparametro_sprm
(
	sprm_pk BIGINT NOT NULL
	, sprm_tpsp_pk BIGINT NOT NULL
	, sprm_prmt_pk BIGINT NOT NULL
	, sprm_prmt_dep_pk BIGINT NOT NULL

	, CONSTRAINT pk_sprm PRIMARY KEY (sprm_pk)
	, CONSTRAINT uq_sprm UNIQUE (sprm_prmt_pk, sprm_prmt_dep_pk)

	, CONSTRAINT fk_sprm_tpsp_pk FOREIGN KEY (sprm_tpsp_pk)
		REFERENCES portico.tbl_tipo_subparametro_tpsp (tpsp_pk)
	, CONSTRAINT fk_sprm_prmt_pk FOREIGN KEY (sprm_prmt_pk)
		REFERENCES portico.tbl_parametro_prmt (prmt_pk)
	, CONSTRAINT fk_sprm_prmt_dep_pk FOREIGN KEY (sprm_prmt_dep_pk)
		REFERENCES portico.tbl_parametro_prmt (prmt_pk)
)
/

CREATE INDEX ix_sprm_prmt_dep_pk ON portico.tbl_subparametro_sprm (sprm_prmt_dep_pk)
/

GRANT SELECT, INSERT, UPDATE, DELETE ON portico.tbl_subparametro_sprm TO portico
/

COMMENT ON TABLE portico.tbl_subparametro_sprm IS 'Subparametros de la aplicacion (Datos de Maestros dependientes de otros maestros)'
/
COMMENT ON COLUMN portico.tbl_subparametro_sprm.sprm_pk IS 'Identificador de Subparametro'
/
COMMENT ON COLUMN portico.tbl_subparametro_sprm.sprm_tpsp_pk IS 'Identificador de Tipo de Subparametro'
/
COMMENT ON COLUMN portico.tbl_subparametro_sprm.sprm_prmt_pk IS 'Identificador de Parametro padre'
/
COMMENT ON COLUMN portico.tbl_subparametro_sprm.sprm_prmt_dep_pk IS 'Identificador de Parametro Asociado'
/



-- tbl_subparametro_version_spvr
CREATE TABLE portico.tbl_subparametro_version_spvr
(
	spvr_pk BIGINT NOT NULL
	, spvr_sprm_pk BIGINT NOT NULL
	, spvr_fini timestamp NOT NULL
	, spvr_ffin timestamp

	, CONSTRAINT pk_spvr PRIMARY KEY (spvr_pk)

	, CONSTRAINT fk_spvr_sprm_pk FOREIGN KEY (spvr_sprm_pk)
		REFERENCES portico.tbl_subparametro_sprm (sprm_pk)
)
/

CREATE INDEX ix_spvr_sprm_pk ON portico.tbl_subparametro_version_spvr (spvr_sprm_pk)
/

GRANT SELECT, INSERT, UPDATE, DELETE ON portico.tbl_subparametro_version_spvr TO portico
/

COMMENT ON TABLE portico.tbl_subparametro_version_spvr IS 'Versiones de subparametros de la aplicacion (Temporalidad de Datos de Maestros dependientes de otros maestros)'
/
COMMENT ON COLUMN portico.tbl_subparametro_version_spvr.spvr_pk IS 'Identificador de Version de Subparametro'
/
COMMENT ON COLUMN portico.tbl_subparametro_version_spvr.spvr_fini IS 'Fecha de inicio de vigencia de Version de Subparametro'
/
COMMENT ON COLUMN portico.tbl_subparametro_version_spvr.spvr_ffin IS 'Fecha de fin de vigencia de Version de Subparametro'
/



-- tbl_subparametro_dato_spdt
CREATE TABLE portico.tbl_subparametro_dato_spdt
(
	spdt_spvr_pk BIGINT NOT NULL
	, spdt_tpdt_pk BIGINT NOT NULL
	, spdt_nentero BIGINT
	, spdt_ndecimal DOUBLE PRECISION
	, spdt_fecha timestamp
	, spdt_prmt_pk BIGINT
	, spdt_cadena VARCHAR(350)

	, CONSTRAINT pk_spdt PRIMARY KEY (spdt_spvr_pk, spdt_tpdt_pk)

	, CONSTRAINT fk_spdt_spvr_pk FOREIGN KEY (spdt_spvr_pk)
		REFERENCES portico.tbl_subparametro_version_spvr (spvr_pk)
	, CONSTRAINT fk_spdt_tpdt_pk FOREIGN KEY (spdt_tpdt_pk)
		REFERENCES portico.tbl_tipo_dato_tpdt (tpdt_pk)
	, CONSTRAINT fk_spdt_prmt_pk FOREIGN KEY (spdt_prmt_pk)
		REFERENCES portico.tbl_parametro_prmt (prmt_pk)
)
/

CREATE INDEX ix_spdt_prmt_pk ON portico.tbl_subparametro_dato_spdt (spdt_prmt_pk)
/
CREATE INDEX ix_spdt_cadena ON portico.tbl_subparametro_dato_spdt (spdt_tpdt_pk, spdt_cadena)
/

GRANT SELECT, INSERT, UPDATE, DELETE ON portico.tbl_subparametro_dato_spdt TO portico
/

COMMENT ON TABLE portico.tbl_subparametro_dato_spdt IS 'Datos Asociados a las Versiones de Subparametros de la aplicacion (Datos de Maestros Dependientes)'
/
COMMENT ON COLUMN portico.tbl_subparametro_dato_spdt.spdt_spvr_pk IS 'Identificador de Version de Subparametro'
/
COMMENT ON COLUMN portico.tbl_subparametro_dato_spdt.spdt_tpdt_pk IS 'Identificador de Tipo de Dato'
/
COMMENT ON COLUMN portico.tbl_subparametro_dato_spdt.spdt_nentero IS 'Valor de dato de Tipo Cantidad Entera'
/
COMMENT ON COLUMN portico.tbl_subparametro_dato_spdt.spdt_ndecimal IS 'Valor de dato de Tipo Cantidad Decimal'
/
COMMENT ON COLUMN portico.tbl_subparametro_dato_spdt.spdt_nentero IS 'Valor de dato de Tipo Fecha'
/
COMMENT ON COLUMN portico.tbl_subparametro_dato_spdt.spdt_prmt_pk IS 'Valor de dato de Tipo Maestro'
/
COMMENT ON COLUMN portico.tbl_subparametro_dato_spdt.spdt_cadena IS 'Valor de dato de Tipo Texto'
/



-- tbl_tipo_servicio_tpsr
CREATE TABLE portico.tbl_tipo_servicio_tpsr
(
	tpsr_pk BIGINT NOT NULL
	, tpsr_es_temporal int NOT NULL
	, tpsr_es_facturable int NOT NULL
	, tpsr_tpdt_estado_pk BIGINT

	, CONSTRAINT pk_tpsr PRIMARY KEY (tpsr_pk)

	, CONSTRAINT fk_tpsr_enti_pk FOREIGN KEY (tpsr_pk)
		REFERENCES portico.tbl_entidad_enti (enti_pk)
	, CONSTRAINT fk_tpsr_tpdt_estado_pk FOREIGN KEY (tpsr_tpdt_estado_pk)
		REFERENCES portico.tbl_tipo_dato_tpdt (tpdt_pk)
)
/

GRANT SELECT, INSERT, UPDATE, DELETE ON portico.tbl_tipo_servicio_tpsr TO portico
/

COMMENT ON TABLE portico.tbl_tipo_servicio_tpsr IS 'Tipos de Servicio de la aplicacion'
/
COMMENT ON COLUMN portico.tbl_tipo_servicio_tpsr.tpsr_pk IS 'Identificador de Tipo de Servicio'
/
COMMENT ON COLUMN portico.tbl_tipo_servicio_tpsr.tpsr_es_temporal IS 'Indicador de si el tipo de servicio tiene temporalidad'
/
COMMENT ON COLUMN portico.tbl_tipo_servicio_tpsr.tpsr_es_facturable IS 'Indicador de si el tipo de servicio es facturable'
/
COMMENT ON COLUMN portico.tbl_tipo_servicio_tpsr.tpsr_tpdt_estado_pk IS 'Tipo de dato que añmacena los estados por los que pueden pasar los servicios de este tipo de servicio'
/



-- tbl_tipo_subservicio_tpss
CREATE TABLE portico.tbl_tipo_subservicio_tpss
(
	tpss_pk BIGINT NOT NULL
	, tpss_tpsr_pk BIGINT NOT NULL
	, tpss_es_temporal int NOT NULL
	, tpss_es_facturable int NOT NULL
	, tpss_tpdt_estado_pk BIGINT

	, CONSTRAINT pk_tpss PRIMARY KEY (tpss_pk)

	, CONSTRAINT fk_tpss_enti_pk FOREIGN KEY (tpss_pk)
		REFERENCES portico.tbl_entidad_enti (enti_pk)
	, CONSTRAINT fk_tpss_tpsr_pk FOREIGN KEY (tpss_tpsr_pk)
		REFERENCES portico.tbl_tipo_servicio_tpsr (tpsr_pk)
	, CONSTRAINT fk_tpss_tpdt_estado_pk FOREIGN KEY (tpss_tpdt_estado_pk)
		REFERENCES portico.tbl_tipo_dato_tpdt (tpdt_pk)
)
/

GRANT SELECT, INSERT, UPDATE, DELETE ON portico.tbl_tipo_subservicio_tpss TO portico
/

COMMENT ON TABLE portico.tbl_tipo_subservicio_tpss IS 'Tipos de Subservicio de la aplicacion'
/
COMMENT ON COLUMN portico.tbl_tipo_subservicio_tpss.tpss_pk IS 'Identificador de Tipo de Subservicio'
/
COMMENT ON COLUMN portico.tbl_tipo_subservicio_tpss.tpss_tpsr_pk IS 'Identificador de Tipo de Servicio al que pertenece el tipo de subservicio'
/
COMMENT ON COLUMN portico.tbl_tipo_subservicio_tpss.tpss_es_temporal IS 'Indicador de si el tipo de subservicio tiene temporalidad'
/
COMMENT ON COLUMN portico.tbl_tipo_subservicio_tpss.tpss_es_facturable IS 'Indicador de si el tipo de subservicio es facturable'
/
COMMENT ON COLUMN portico.tbl_tipo_subservicio_tpss.tpss_tpdt_estado_pk IS 'Tipo de dato que añmacena los estados por los que pueden pasar los subservicios de este tipo de subservicio'
/



-- tbl_servicio_secuencia_srsc
CREATE TABLE portico.tbl_servicio_secuencia_srsc
(
	srsc_tpsr_pk BIGINT NOT NULL
	, srsc_subp_pk BIGINT NOT NULL
	, srsc_anno VARCHAR(4) NOT NULL
	, srsc_ultimo_numero int NOT NULL

	, CONSTRAINT pk_srsc PRIMARY KEY (srsc_tpsr_pk, srsc_subp_pk, srsc_anno)

	, CONSTRAINT fk_srsc_tpsr_pk FOREIGN KEY (srsc_tpsr_pk)
		REFERENCES portico.tbl_tipo_servicio_tpsr (tpsr_pk)
	, CONSTRAINT fk_srsc_subp_pk FOREIGN KEY (srsc_subp_pk)
		REFERENCES portico.tbl_parametro_prmt (prmt_pk)
)
/

GRANT SELECT, INSERT, UPDATE, DELETE ON portico.tbl_servicio_secuencia_srsc TO portico
/

COMMENT ON TABLE portico.tbl_servicio_secuencia_srsc IS 'Numeros de Secuencia de Servicios'
/
COMMENT ON COLUMN portico.tbl_servicio_secuencia_srsc.srsc_tpsr_pk IS 'Identificador de Tipo de Servicio'
/
COMMENT ON COLUMN portico.tbl_servicio_secuencia_srsc.srsc_subp_pk IS 'Identificador de Subpuerto'
/
COMMENT ON COLUMN portico.tbl_servicio_secuencia_srsc.srsc_anno IS 'Anio'
/
COMMENT ON COLUMN portico.tbl_servicio_secuencia_srsc.srsc_ultimo_numero IS 'Ultimo numero de servicio generado para un tipo de servicio, subpuerto y anio'
/



-- tbl_servicio_srvc
CREATE TABLE portico.tbl_servicio_srvc
(
	srvc_pk BIGINT NOT NULL
	, srvc_tpsr_pk BIGINT NOT NULL
	, srvc_subp_pk BIGINT NOT NULL
	, srvc_anno VARCHAR(4) NOT NULL
	, srvc_numero VARCHAR(5) NOT NULL
	, srvc_falta timestamp NOT NULL
	, srvc_fref timestamp NOT NULL
	, srvc_fini timestamp
	, srvc_ffin timestamp
	, srvc_estado char(1)

	, CONSTRAINT pk_srvc PRIMARY KEY (srvc_pk)

	, CONSTRAINT fk_srvc_tpsr_pk FOREIGN KEY (srvc_tpsr_pk)
		REFERENCES portico.tbl_tipo_servicio_tpsr (tpsr_pk)
	, CONSTRAINT fk_srvc_subp_pk FOREIGN KEY (srvc_subp_pk)
		REFERENCES portico.tbl_parametro_prmt (prmt_pk)
)
/

CREATE INDEX ix_srvc_tpsr_pk ON portico.tbl_servicio_srvc (srvc_tpsr_pk)
/

GRANT SELECT, INSERT, UPDATE, DELETE ON portico.tbl_servicio_srvc TO portico
/

COMMENT ON TABLE portico.tbl_servicio_srvc IS 'Servicios de la aplicacion'
/
COMMENT ON COLUMN portico.tbl_servicio_srvc.srvc_pk IS 'Identificador de Servicio'
/
COMMENT ON COLUMN portico.tbl_servicio_srvc.srvc_tpsr_pk IS 'Identificador de Tipo de Servicio'
/
COMMENT ON COLUMN portico.tbl_servicio_srvc.srvc_subp_pk IS 'Identificador de Subpuerto del Servicio'
/
COMMENT ON COLUMN portico.tbl_servicio_srvc.srvc_anno IS 'Año'
/
COMMENT ON COLUMN portico.tbl_servicio_srvc.srvc_numero IS 'Numero'
/
COMMENT ON COLUMN portico.tbl_servicio_srvc.srvc_falta IS 'Fecha de alta en el sistema'
/
COMMENT ON COLUMN portico.tbl_servicio_srvc.srvc_fref IS 'Fecha de referencia. Utilizada para recuperar los datos temporales asociados al servicio'
/
COMMENT ON COLUMN portico.tbl_servicio_srvc.srvc_fini IS 'Fecha de inicio de prestacion del servicio'
/
COMMENT ON COLUMN portico.tbl_servicio_srvc.srvc_ffin IS 'Fecha de fin de prestacion del servicio'
/
COMMENT ON COLUMN portico.tbl_servicio_srvc.srvc_estado IS 'Estado en el que se encuentra el servicio'
/



-- tbl_servicio_dato_srdt
CREATE TABLE portico.tbl_servicio_dato_srdt
(
	srdt_srvc_pk BIGINT NOT NULL
	, srdt_tpdt_pk BIGINT NOT NULL
	, srdt_nentero BIGINT
	, srdt_ndecimal DOUBLE PRECISION
	, srdt_fecha timestamp
	, srdt_prmt_pk BIGINT
	, srdt_srvc_dep_pk BIGINT
	, srdt_cadena VARCHAR(350)

	, CONSTRAINT pk_srdt PRIMARY KEY (srdt_srvc_pk, srdt_tpdt_pk)

	, CONSTRAINT fk_srdt_srvc_pk FOREIGN KEY (srdt_srvc_pk)
		REFERENCES portico.tbl_servicio_srvc (srvc_pk)
	, CONSTRAINT fk_srdt_tpdt_pk FOREIGN KEY (srdt_tpdt_pk)
		REFERENCES portico.tbl_tipo_dato_tpdt (tpdt_pk)
	, CONSTRAINT fk_srdt_prmt_pk FOREIGN KEY (srdt_prmt_pk)
		REFERENCES portico.tbl_parametro_prmt (prmt_pk)
	, CONSTRAINT fk_srdt_srvc_dep_pk FOREIGN KEY (srdt_srvc_dep_pk)
		REFERENCES portico.tbl_servicio_srvc (srvc_pk)
)
/

CREATE INDEX ix_srdt_prmt_pk ON portico.tbl_servicio_dato_srdt (srdt_prmt_pk)
/
CREATE INDEX ix_srdt_cadena ON portico.tbl_servicio_dato_srdt (srdt_tpdt_pk, srdt_cadena)
/

GRANT SELECT, INSERT, UPDATE, DELETE ON portico.tbl_servicio_dato_srdt TO portico
/

COMMENT ON TABLE portico.tbl_servicio_dato_srdt IS 'Datos asociados a servicios'
/
COMMENT ON COLUMN portico.tbl_servicio_dato_srdt.srdt_srvc_pk IS 'Identificador de Servicio'
/
COMMENT ON COLUMN portico.tbl_servicio_dato_srdt.srdt_tpdt_pk IS 'Identificador de Tipo de Dato'
/
COMMENT ON COLUMN portico.tbl_servicio_dato_srdt.srdt_nentero IS 'Valor de dato de tipo cantidad entera'
/
COMMENT ON COLUMN portico.tbl_servicio_dato_srdt.srdt_ndecimal IS 'Valor de dato de tipo cantidad decimal'
/
COMMENT ON COLUMN portico.tbl_servicio_dato_srdt.srdt_fecha IS 'Valor de dato de tipo Fecha'
/
COMMENT ON COLUMN portico.tbl_servicio_dato_srdt.srdt_prmt_pk IS 'Valor de dato de tipo Maestro'
/
COMMENT ON COLUMN portico.tbl_servicio_dato_srdt.srdt_srvc_dep_pk IS 'Valor de dato de Servicio'
/
COMMENT ON COLUMN portico.tbl_servicio_dato_srdt.srdt_cadena IS 'Valor de dato de tipo Texto'
/



-- tbl_subservicio_ssrv
CREATE TABLE portico.tbl_subservicio_ssrv
(
	ssrv_pk BIGINT NOT NULL
	, ssrv_srvc_pk BIGINT NOT NULL
	, ssrv_tpss_pk BIGINT NOT NULL
	, ssrv_numero int NOT NULL
	, ssrv_fini timestamp
	, ssrv_ffin timestamp
	, ssrv_estado char(1)

	, CONSTRAINT pk_ssrv PRIMARY KEY (ssrv_pk)

	, CONSTRAINT fk_ssrv_srvc_pk FOREIGN KEY (ssrv_srvc_pk)
		REFERENCES portico.tbl_servicio_srvc (srvc_pk)
	, CONSTRAINT fk_ssrv_tpss_pk FOREIGN KEY (ssrv_tpss_pk)
		REFERENCES portico.tbl_tipo_subservicio_tpss (tpss_pk)
)
/

CREATE INDEX ix_ssrv_srvc_pk ON portico.tbl_subservicio_ssrv (ssrv_srvc_pk)
/
CREATE INDEX ix_ssrv_tpss_pk ON portico.tbl_subservicio_ssrv (ssrv_tpss_pk)
/

GRANT SELECT, INSERT, UPDATE, DELETE ON portico.tbl_subservicio_ssrv TO portico
/

COMMENT ON TABLE portico.tbl_subservicio_ssrv IS 'Subservicios de la aplicacion'
/
COMMENT ON COLUMN portico.tbl_subservicio_ssrv.ssrv_pk IS 'Identificador de Subservicio'
/
COMMENT ON COLUMN portico.tbl_subservicio_ssrv.ssrv_srvc_pk IS 'Identificador de Servicio'
/
COMMENT ON COLUMN portico.tbl_subservicio_ssrv.ssrv_tpss_pk IS 'Identificador de Tipo de Subservicio'
/
COMMENT ON COLUMN portico.tbl_subservicio_ssrv.ssrv_numero IS 'Numero de Subservicio'
/
COMMENT ON COLUMN portico.tbl_subservicio_ssrv.ssrv_fini IS 'Fecha de inicio de prestacion del subservicio'
/
COMMENT ON COLUMN portico.tbl_subservicio_ssrv.ssrv_ffin IS 'Fecha de fin de prestacion del subservicio'
/
COMMENT ON COLUMN portico.tbl_subservicio_ssrv.ssrv_estado IS 'Estado en el que se encuentra el subservicio'
/



-- tbl_subservicio_dato_ssdt
CREATE TABLE portico.tbl_subservicio_dato_ssdt
(
	ssdt_ssrv_pk BIGINT NOT NULL
	, ssdt_tpdt_pk BIGINT NOT NULL
	, ssdt_nentero BIGINT
	, ssdt_ndecimal DOUBLE PRECISION
	, ssdt_fecha timestamp
	, ssdt_prmt_pk BIGINT
	, ssdt_cadena VARCHAR(350)

	, CONSTRAINT pk_ssdt PRIMARY KEY (ssdt_ssrv_pk, ssdt_tpdt_pk)

	, CONSTRAINT fk_ssdt_ssrv_pk FOREIGN KEY (ssdt_ssrv_pk)
		REFERENCES portico.tbl_subservicio_ssrv (ssrv_pk)
	, CONSTRAINT fk_ssdt_tpdt_pk FOREIGN KEY (ssdt_tpdt_pk)
		REFERENCES portico.tbl_tipo_dato_tpdt (tpdt_pk)
	, CONSTRAINT fk_ssdt_prmt_pk FOREIGN KEY (ssdt_prmt_pk)
		REFERENCES portico.tbl_parametro_prmt (prmt_pk)
)
/

CREATE INDEX ix_ssdt_prmt_pk ON portico.tbl_subservicio_dato_ssdt (ssdt_prmt_pk)
/
CREATE INDEX ix_ssdt_cadena ON portico.tbl_subservicio_dato_ssdt (ssdt_tpdt_pk, ssdt_cadena)
/

GRANT SELECT, INSERT, UPDATE, DELETE ON portico.tbl_subservicio_dato_ssdt TO portico
/

COMMENT ON TABLE portico.tbl_subservicio_dato_ssdt IS 'Subservicios de la aplicacion'
/
COMMENT ON COLUMN portico.tbl_subservicio_dato_ssdt.ssdt_ssrv_pk IS 'Identificador de Subservicio'
/
COMMENT ON COLUMN portico.tbl_subservicio_dato_ssdt.ssdt_tpdt_pk IS 'Identificador de Tipo de Dato'
/
COMMENT ON COLUMN portico.tbl_subservicio_dato_ssdt.ssdt_nentero IS 'Valor de dato de tipo cantidad entera'
/
COMMENT ON COLUMN portico.tbl_subservicio_dato_ssdt.ssdt_ndecimal IS 'Valor de dato de tipo cantidad decimal'
/
COMMENT ON COLUMN portico.tbl_subservicio_dato_ssdt.ssdt_fecha IS 'Valor de dato de tipo fecha'
/
COMMENT ON COLUMN portico.tbl_subservicio_dato_ssdt.ssdt_prmt_pk IS 'Valor de dato de tipo maestro'
/
COMMENT ON COLUMN portico.tbl_subservicio_dato_ssdt.ssdt_cadena IS 'Valor de dato de tipo texto'
/



-- tbl_subserv_subserv_ssss
CREATE TABLE portico.tbl_subserv_subserv_ssss
(
	ssss_ssrvp_pk BIGINT NOT NULL
	, ssss_ssrvh_pk BIGINT NOT NULL

	, CONSTRAINT pk_ssss PRIMARY KEY (ssss_ssrvp_pk, ssss_ssrvh_pk)

	, CONSTRAINT fk_ssss_ssrvp_pk FOREIGN KEY (ssss_ssrvp_pk)
		REFERENCES portico.tbl_subservicio_ssrv (ssrv_pk)
	, CONSTRAINT fk_ssss_ssrvh_pk FOREIGN KEY (ssss_ssrvh_pk)
		REFERENCES portico.tbl_subservicio_ssrv (ssrv_pk)
)
/

CREATE INDEX ix_ssss_ssrvh_pk ON portico.tbl_subserv_subserv_ssss (ssss_ssrvh_pk)
/

GRANT SELECT, INSERT, UPDATE, DELETE ON portico.tbl_subserv_subserv_ssss TO portico
/

COMMENT ON TABLE portico.tbl_subserv_subserv_ssss IS 'Subservicios de la aplicacion'
/
COMMENT ON COLUMN portico.tbl_subserv_subserv_ssss.ssss_ssrvp_pk IS 'Identificador de Subservicio Padre'
/
COMMENT ON COLUMN portico.tbl_subserv_subserv_ssss.ssss_ssrvh_pk IS 'Identificador de Subservicio Hijo'
/



-- tbl_tipo_estadistica_tpes
CREATE TABLE portico.tbl_tipo_estadistica_tpes
(
	tpes_pk BIGINT NOT NULL

	, CONSTRAINT pk_tpes PRIMARY KEY (tpes_pk)

	, CONSTRAINT fk_tpes_enti_pk FOREIGN KEY (tpes_pk)
		REFERENCES portico.tbl_entidad_enti (enti_pk)
)
/

GRANT SELECT, INSERT, UPDATE, DELETE ON portico.tbl_tipo_estadistica_tpes TO portico
/

COMMENT ON TABLE portico.tbl_tipo_estadistica_tpes IS 'Tipos de Estadisticas de la aplicacion'
/
COMMENT ON COLUMN portico.tbl_tipo_estadistica_tpes.tpes_pk IS 'Identificador de Tipo de Estadistica'
/



-- tbl_periodo_proceso_pepr
CREATE TABLE portico.tbl_periodo_proceso_pepr
(
	pepr_pk BIGINT NOT NULL
	, pepr_autp_pk BIGINT NOT NULL
	, pepr_anio int NOT NULL
	, pepr_mes int NOT NULL
	, pepr_trimestre int NOT NULL
	, pepr_freferencia timestamp NOT NULL
	, pepr_falta timestamp NOT NULL

	, CONSTRAINT pk_pepr PRIMARY KEY (pepr_pk)
	, CONSTRAINT uq_pepr UNIQUE (pepr_autp_pk, pepr_anio, pepr_mes)

	, CONSTRAINT fk_pepr_autp_pk FOREIGN KEY (pepr_autp_pk)
		REFERENCES portico.tbl_parametro_prmt (prmt_pk)
)
/

GRANT SELECT, INSERT, UPDATE, DELETE ON portico.tbl_periodo_proceso_pepr TO portico
/

COMMENT ON TABLE portico.tbl_periodo_proceso_pepr IS 'Periodos de Proceso de Estadisticas'
/
COMMENT ON COLUMN portico.tbl_periodo_proceso_pepr.pepr_pk IS 'Identificador de Periodo de Proceso'
/
COMMENT ON COLUMN portico.tbl_periodo_proceso_pepr.pepr_autp_pk IS 'Identificador de Autoridad Portuaria'
/
COMMENT ON COLUMN portico.tbl_periodo_proceso_pepr.pepr_anio IS 'Año de Periodo de Proceso'
/
COMMENT ON COLUMN portico.tbl_periodo_proceso_pepr.pepr_mes IS 'Mes de Periodo de Proceso'
/
COMMENT ON COLUMN portico.tbl_periodo_proceso_pepr.pepr_trimestre IS 'Trimestre de Periodo de Proceso'
/
COMMENT ON COLUMN portico.tbl_periodo_proceso_pepr.pepr_freferencia IS 'Fecha de referencia. Utilizada para recuperar los datos temporales asociados al periodo de proceso'
/
COMMENT ON COLUMN portico.tbl_periodo_proceso_pepr.pepr_falta IS 'Fecha de alta del periodo de proceso'
/



-- tbl_estadistica_estd
CREATE TABLE portico.tbl_estadistica_estd
(
	estd_pk BIGINT NOT NULL
	, estd_pepr_pk BIGINT NOT NULL
	, estd_tpes_pk BIGINT NOT NULL
	, estd_subp_pk BIGINT NOT NULL

	, CONSTRAINT pk_estd PRIMARY KEY (estd_pk)

	, CONSTRAINT fk_estd_pepr_pk FOREIGN KEY (estd_pepr_pk)
		REFERENCES portico.tbl_periodo_proceso_pepr (pepr_pk)
	, CONSTRAINT fk_estd_tpes_pk FOREIGN KEY (estd_tpes_pk)
		REFERENCES portico.tbl_tipo_estadistica_tpes (tpes_pk)
	, CONSTRAINT fk_estd_subp_pk FOREIGN KEY (estd_subp_pk)
		REFERENCES portico.tbl_parametro_prmt (prmt_pk)
)
/

CREATE INDEX ix_estd_pepr_pk ON portico.tbl_estadistica_estd (estd_tpes_pk, estd_pepr_pk)
/

GRANT SELECT, INSERT, UPDATE, DELETE ON portico.tbl_estadistica_estd TO portico
/

COMMENT ON TABLE portico.tbl_estadistica_estd IS 'Estadisticas'
/
COMMENT ON COLUMN portico.tbl_estadistica_estd.estd_pk IS 'Identificador de Estadistica'
/
COMMENT ON COLUMN portico.tbl_estadistica_estd.estd_pepr_pk IS 'Identificador de Periodo de Proceso'
/
COMMENT ON COLUMN portico.tbl_estadistica_estd.estd_tpes_pk IS 'Identificador de Tipo de Estadistica'
/
COMMENT ON COLUMN portico.tbl_estadistica_estd.estd_subp_pk IS 'Identificador de Subpuerto'
/



-- tbl_estadistica_dato_esdt
CREATE TABLE portico.tbl_estadistica_dato_esdt
(
	esdt_estd_pk BIGINT NOT NULL
	, esdt_tpdt_pk BIGINT NOT NULL
	, esdt_nentero BIGINT
	, esdt_ndecimal DOUBLE PRECISION
	, esdt_prmt_pk BIGINT
	, esdt_cadena VARCHAR(30)

	, CONSTRAINT pk_esdt PRIMARY KEY (esdt_estd_pk, esdt_tpdt_pk)

	, CONSTRAINT fk_esdt_estd_pk FOREIGN KEY (esdt_estd_pk)
		REFERENCES portico.tbl_estadistica_estd (estd_pk)
	, CONSTRAINT fk_esdt_tpdt_pk FOREIGN KEY (esdt_tpdt_pk)
		REFERENCES portico.tbl_tipo_dato_tpdt (tpdt_pk)
	, CONSTRAINT fk_esdt_prmt_pk FOREIGN KEY (esdt_prmt_pk)
		REFERENCES portico.tbl_parametro_prmt (prmt_pk)
)
/

CREATE INDEX ix_esdt_prmt_pk ON portico.tbl_estadistica_dato_esdt (esdt_prmt_pk)
/
CREATE INDEX ix_esdt_cadena ON portico.tbl_estadistica_dato_esdt (esdt_tpdt_pk, esdt_cadena)
/

GRANT SELECT, INSERT, UPDATE, DELETE ON portico.tbl_estadistica_dato_esdt TO portico
/

COMMENT ON TABLE portico.tbl_estadistica_dato_esdt IS 'Datos asociados a Estadisticas'
/
COMMENT ON COLUMN portico.tbl_estadistica_dato_esdt.esdt_estd_pk IS 'Identificador de Estadistica'
/
COMMENT ON COLUMN portico.tbl_estadistica_dato_esdt.esdt_tpdt_pk IS 'Identificador de Tipo de Dato'
/
COMMENT ON COLUMN portico.tbl_estadistica_dato_esdt.esdt_nentero IS 'Valor de dato de Tipo Cantidad Entera'
/
COMMENT ON COLUMN portico.tbl_estadistica_dato_esdt.esdt_ndecimal IS 'Valor de dato de Tipo Cantidad Decimal'
/
COMMENT ON COLUMN portico.tbl_estadistica_dato_esdt.esdt_prmt_pk IS 'Valor de dato de Tipo Maestro'
/
COMMENT ON COLUMN portico.tbl_estadistica_dato_esdt.esdt_cadena IS 'Valor de dato de Tipo Texto'
/



-- tbl_cuadro_mes_cdms
CREATE TABLE portico.tbl_cuadro_mes_cdms
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
		REFERENCES portico.tbl_periodo_proceso_pepr (pepr_pk)
	, CONSTRAINT fk_cdms_cocu_pk FOREIGN KEY (cdms_cocu_pk)
		REFERENCES portico.tbl_parametro_prmt (prmt_pk)
	, CONSTRAINT fk_cdms_opet_pk FOREIGN KEY (cdms_opet_pk)
		REFERENCES portico.tbl_parametro_prmt (prmt_pk)
	, CONSTRAINT fk_cdms_navt_pk FOREIGN KEY (cdms_navt_pk)
		REFERENCES portico.tbl_parametro_prmt (prmt_pk)
	, CONSTRAINT fk_cdms_pais_pk FOREIGN KEY (cdms_pais_pk)
		REFERENCES portico.tbl_parametro_prmt (prmt_pk)
)
/

GRANT SELECT, INSERT, UPDATE, DELETE ON portico.tbl_cuadro_mes_cdms TO portico
/

COMMENT ON TABLE portico.tbl_cuadro_mes_cdms IS 'Cuadros mensuales de Estadisticas'
/
COMMENT ON COLUMN portico.tbl_cuadro_mes_cdms.cdms_pk IS 'Identificador de Cuadro mensual'
/
COMMENT ON COLUMN portico.tbl_cuadro_mes_cdms.cdms_pepr_pk IS 'Identificador de Periodo de Proceso'
/
COMMENT ON COLUMN portico.tbl_cuadro_mes_cdms.cdms_cocu_pk IS 'Identificador de Concepto de Cuadro mensual'
/
COMMENT ON COLUMN portico.tbl_cuadro_mes_cdms.cdms_opet_pk IS 'Identificador de Tipo de Operacion de BL'
/
COMMENT ON COLUMN portico.tbl_cuadro_mes_cdms.cdms_navt_pk IS 'Identificador de Tipo de Navegacion'
/
COMMENT ON COLUMN portico.tbl_cuadro_mes_cdms.cdms_pais_pk IS 'Identificador de Pais'
/
COMMENT ON COLUMN portico.tbl_cuadro_mes_cdms.cdms_cantidad IS 'Cantidad'
/



-- tbl_proceso_batch_prbt
CREATE TABLE portico.tbl_proceso_batch_prbt
(
	prbt_pk BIGINT NOT NULL
	, prbt_modulo char(1) NOT NULL
	, prbt_tipo VARCHAR(20) NOT NULL
	, prbt_estado char(1) NOT NULL
	, prbt_falta timestamp NOT NULL
	, prbt_finicio timestamp
	, prbt_ffin timestamp

	, CONSTRAINT pk_prbt PRIMARY KEY (prbt_pk)
)
/

GRANT SELECT, INSERT, UPDATE, DELETE ON portico.tbl_proceso_batch_prbt TO portico
/

COMMENT ON TABLE portico.tbl_proceso_batch_prbt IS 'Ejecuciones de Procesos Batch de la Aplicacion'
/
COMMENT ON COLUMN portico.tbl_proceso_batch_prbt.prbt_pk IS 'Identificador de proceso'
/
COMMENT ON COLUMN portico.tbl_proceso_batch_prbt.prbt_modulo IS 'Modulo al que pertenece el proceso: S (Servicio), E (Estadistica), F (Facturacion)'
/
COMMENT ON COLUMN portico.tbl_proceso_batch_prbt.prbt_tipo IS 'Tipo de Proceso'
/
COMMENT ON COLUMN portico.tbl_proceso_batch_prbt.prbt_estado IS 'Estado en el que se encuentra el proceso: C (En cola), E (En ejecucion), F (Finalizado)'
/
COMMENT ON COLUMN portico.tbl_proceso_batch_prbt.prbt_falta IS 'Fecha del alta del proceso en el sistema'
/
COMMENT ON COLUMN portico.tbl_proceso_batch_prbt.prbt_finicio IS 'Fecha de inicio de la ejecucion del proceso'
/
COMMENT ON COLUMN portico.tbl_proceso_batch_prbt.prbt_ffin IS 'Fecha de fin de la ejecucion del proceso'
/



-- tbl_proceso_parametro_prpm
CREATE TABLE portico.tbl_proceso_parametro_prpm
(
	prpm_prbt_pk BIGINT NOT NULL
	, prpm_nombre VARCHAR(50) NOT NULL
	, prpm_valor VARCHAR(300) NOT NULL

	, CONSTRAINT pk_prpm PRIMARY KEY (prpm_prbt_pk, prpm_nombre)

	, CONSTRAINT fk_prpm_prbt_pk FOREIGN KEY (prpm_prbt_pk)
		REFERENCES portico.tbl_proceso_batch_prbt (prbt_pk)
)
/

GRANT SELECT, INSERT, UPDATE, DELETE ON portico.tbl_proceso_parametro_prpm TO portico
/

COMMENT ON TABLE portico.tbl_proceso_parametro_prpm IS 'Parametros de Ejecuciones de Procesos Batch'
/
COMMENT ON COLUMN portico.tbl_proceso_parametro_prpm.prpm_prbt_pk IS 'Identificador de proceso'
/
COMMENT ON COLUMN portico.tbl_proceso_parametro_prpm.prpm_nombre IS 'Nombre del parametro'
/
COMMENT ON COLUMN portico.tbl_proceso_parametro_prpm.prpm_valor IS 'Valor del parametro'
/



-- tbl_proceso_archivo_prar
CREATE TABLE portico.tbl_proceso_archivo_prar
(
	prar_prbt_pk BIGINT NOT NULL
	, prar_nombre VARCHAR(50) NOT NULL
	, prar_sentido char(1) NOT NULL

	, CONSTRAINT pk_prar PRIMARY KEY (prar_prbt_pk, prar_sentido, prar_nombre)

	, CONSTRAINT fk_prar_prbt_pk FOREIGN KEY (prar_prbt_pk)
		REFERENCES portico.tbl_proceso_batch_prbt (prbt_pk)
)
/

GRANT SELECT, INSERT, UPDATE, DELETE ON portico.tbl_proceso_archivo_prar TO portico
/

COMMENT ON TABLE portico.tbl_proceso_archivo_prar IS 'Ficheros tratados (leidos-generados) en las Ejecuciones de Procesos Batch'
/
COMMENT ON COLUMN portico.tbl_proceso_archivo_prar.prar_prbt_pk IS 'Identificador de proceso al que pertenece el archivo'
/
COMMENT ON COLUMN portico.tbl_proceso_archivo_prar.prar_nombre IS 'Nombre del archivo'
/
COMMENT ON COLUMN portico.tbl_proceso_archivo_prar.prar_sentido IS 'Sentido de Archivo: E (Entrada), S (Salida)'
/



-- tbl_proceso_item_prit
CREATE TABLE portico.tbl_proceso_item_prit
(
	prit_prbt_pk BIGINT NOT NULL
	, prit_item_pk BIGINT NOT NULL
	, prit_sentido char(1) NOT NULL

	, CONSTRAINT pk_prit PRIMARY KEY (prit_prbt_pk, prit_sentido, prit_item_pk)

	, CONSTRAINT fk_prit_prbt_pk FOREIGN KEY (prit_prbt_pk)
		REFERENCES portico.tbl_proceso_batch_prbt (prbt_pk)
)
/

GRANT SELECT, INSERT, UPDATE, DELETE ON portico.tbl_proceso_item_prit TO portico
/

COMMENT ON TABLE portico.tbl_proceso_item_prit IS 'Items tratados (leidos-generados) en las Ejecuciones de Procesos Batch. Un item puede ser un servicio, valoracion, factura...'
/
COMMENT ON COLUMN portico.tbl_proceso_item_prit.prit_prbt_pk IS 'Identificador de proceso al que pertenece el item'
/
COMMENT ON COLUMN portico.tbl_proceso_item_prit.prit_item_pk IS 'Identificador de item (Puede ser un Servicio, Periodo de Proceso, ...)'
/
COMMENT ON COLUMN portico.tbl_proceso_item_prit.prit_sentido IS 'Indicador de Tipo de Item: E (Entrada), S (Salida)'
/



-- tbl_proceso_mensaje_prmn
CREATE TABLE portico.tbl_proceso_mensaje_prmn
(
	prmn_prbt_pk BIGINT NOT NULL
	, prmn_nivel char(1) NOT NULL
	, prmn_codigo VARCHAR(5) NOT NULL
	, prmn_mensaje VARCHAR(300)

	, CONSTRAINT fk_prmn_prbt_pk FOREIGN KEY (prmn_prbt_pk)
		REFERENCES portico.tbl_proceso_batch_prbt (prbt_pk)
)
/

CREATE INDEX ix_prmn_prbt_pk ON portico.tbl_proceso_mensaje_prmn (prmn_prbt_pk)
/

GRANT SELECT, INSERT, UPDATE, DELETE ON portico.tbl_proceso_mensaje_prmn TO portico
/

COMMENT ON TABLE portico.tbl_proceso_mensaje_prmn IS 'Mensajes generados (info-warning-error) en las Ejecuciones de Procesos Batch.'
/
COMMENT ON COLUMN portico.tbl_proceso_mensaje_prmn.prmn_prbt_pk IS 'Identificador de proceso al que pertenece el mensaje'
/
COMMENT ON COLUMN portico.tbl_proceso_mensaje_prmn.prmn_nivel IS 'Nivel del mensaje generado por el proceso: I (Info), W (Warning), E (Error)'
/
COMMENT ON COLUMN portico.tbl_proceso_mensaje_prmn.prmn_codigo IS 'Codigo de Mensaje'
/
COMMENT ON COLUMN portico.tbl_proceso_mensaje_prmn.prmn_mensaje IS 'Texto del mensaje'
/











































-- //@UNDO
-- SQL to undo the change goes here.

DROP TABLE portico.tbl_proceso_mensaje_prmn
/
DROP TABLE portico.tbl_proceso_item_prit
/
DROP TABLE portico.tbl_proceso_archivo_prar
/
DROP TABLE portico.tbl_proceso_parametro_prpm
/
DROP TABLE portico.tbl_proceso_batch_prbt
/
DROP TABLE portico.tbl_cuadro_mes_cdms
/
DROP TABLE portico.tbl_estadistica_dato_esdt
/
DROP TABLE portico.tbl_estadistica_estd
/
DROP TABLE portico.tbl_periodo_proceso_pepr
/
DROP TABLE portico.tbl_tipo_estadistica_tpes
/
DROP TABLE portico.tbl_servicio_secuencia_srsc
/
DROP TABLE portico.tbl_subserv_subserv_ssss
/
DROP TABLE portico.tbl_subservicio_dato_ssdt
/
DROP TABLE portico.tbl_subservicio_ssrv
/
DROP TABLE portico.tbl_servicio_dato_srdt
/
DROP TABLE portico.tbl_servicio_srvc
/
DROP TABLE portico.tbl_tipo_subservicio_tpss
/
DROP TABLE portico.tbl_tipo_servicio_tpsr
/
DROP TABLE portico.tbl_subparametro_dato_spdt
/
DROP TABLE portico.tbl_subparametro_version_spvr
/
DROP TABLE portico.tbl_subparametro_sprm
/
DROP TABLE portico.tbl_tipo_subparametro_tpsp
/
DROP TABLE portico.tbl_parametro_i18n_p18n
/
DROP TABLE portico.tbl_parametro_dato_prdt
/
DROP TABLE portico.tbl_parametro_version_prvr
/
DROP TABLE portico.tbl_parametro_prmt
/
DROP TABLE portico.tbl_tipo_parametro_tppr
/
DROP TABLE portico.tbl_entidad_tipo_dato_entd
/
DROP TABLE portico.tbl_entidad_grupo_dato_engd
/
DROP TABLE portico.tbl_entidad_accion_enac
/
DROP TABLE portico.tbl_codigo_referencia_cdrf
/
DROP TABLE portico.tbl_tipo_dato_tpdt
/
DROP TABLE portico.tbl_entidad_entidad_enen
/
DROP TABLE portico.tbl_entidad_enti
/
DROP TABLE portico.tbl_usuario_grupo_usgr
/
DROP TABLE portico.tbl_grupo_grpo
/
DROP TABLE portico.tbl_usuario_usro
/
DROP TABLE portico.tbl_ig
/
DROP TABLE portico.tbl_conf_valor_i18n_cnvi
/
DROP TABLE portico.tbl_configuracion_valor_cnvl
/
DROP TABLE portico.tbl_configuracion_entorno_cnen
/
DROP TABLE portico.tbl_configuracion_idioma_cnid
/
DROP TABLE portico.tbl_conf_clave_i18n_cnci
/
DROP TABLE portico.tbl_conf_clave_cncl
/



