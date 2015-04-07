-- // 20150320160000_0_0_6_Gis_AP.sql
-- Migration SQL that makes the change goes here.


ALTER TABLE portico.tbl_entidad_enti ADD enti_gis INT DEFAULT 0 NOT NULL\
ALTER TABLE portico.tbl_entidad_enti ADD enti_puerto INT DEFAULT 0 NOT NULL\

CREATE TABLE portico.tbl_superpuerto_sprt (
	sprt_pk BIGINT NOT NULL
	, sprt_codigo VARCHAR(10) NOT NULL

	, CONSTRAINT pk_sprt PRIMARY KEY (sprt_pk)

	, CONSTRAINT uk_sprt UNIQUE (sprt_codigo)
)\

GRANT SELECT ON portico.tbl_superpuerto_sprt TO portico\

INSERT INTO portico.tbl_superpuerto_sprt (sprt_pk, sprt_codigo) VALUES (36100, '0')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_ext_pk, i18n_lang, i18n_text) VALUES ('sprt', 36100, 'es', 'Autp Genérica')\
INSERT INTO portico.tbl_superpuerto_sprt (sprt_pk, sprt_codigo) VALUES (36101, '*')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_ext_pk, i18n_lang, i18n_text) VALUES ('sprt', 36101, 'es', 'Autp Genérica 2')\

INSERT INTO portico.tbl_superpuerto_sprt (sprt_pk, sprt_codigo) VALUES (36000, '80')\
	INSERT INTO portico.tbl_i18n_i18n (i18n_pref, i18n_ext_pk, i18n_lang, i18n_text) VALUES ('sprt', 36000, 'es', 'Baleares')\

CREATE TABLE portico.tbl_puerto_prto (
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
		REFERENCES portico.tbl_superpuerto_sprt (sprt_pk)
)\

GRANT SELECT ON portico.tbl_puerto_prto TO portico\

INSERT INTO tbl_puerto_prto (prto_pk, prto_sprt_pk, prto_codigo, prto_codigo_corto, prto_codigo_edi, prto_rec_aduanero, prto_unlocode)
VALUES (37100, 36100, '0', '0', NULL, NULL, 'ES***')\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_ext_pk, i18n_lang, i18n_text) VALUES ('prto', 37100, 'es', 'Puerto Genérico')\
INSERT INTO tbl_puerto_prto (prto_pk, prto_sprt_pk, prto_codigo, prto_codigo_corto, prto_codigo_edi, prto_rec_aduanero, prto_unlocode)
VALUES (37101, 36101, '*', '*', NULL, NULL, 'ES***')\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_ext_pk, i18n_lang, i18n_text) VALUES ('prto', 37101, 'es', 'Puerto Genérico 2')\

INSERT INTO tbl_puerto_prto (prto_pk, prto_sprt_pk, prto_codigo, prto_codigo_corto, prto_codigo_edi, prto_rec_aduanero, prto_unlocode)
VALUES (37000, 36000, '81', 'P', '1', '0711', 'ESPMI')\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_ext_pk, i18n_lang, i18n_text) VALUES ('prto', 37000, 'es', 'Palma')\
INSERT INTO tbl_puerto_prto (prto_pk, prto_sprt_pk, prto_codigo, prto_codigo_corto, prto_codigo_edi, prto_rec_aduanero, prto_unlocode)
VALUES (37001, 36000, '82', 'A', '2', '0717', 'ESALD')\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_ext_pk, i18n_lang, i18n_text) VALUES ('prto', 37001, 'es', 'Alcudia')\
INSERT INTO tbl_puerto_prto (prto_pk, prto_sprt_pk, prto_codigo, prto_codigo_corto, prto_codigo_edi, prto_rec_aduanero, prto_unlocode)
VALUES (37002, 36000, '83', 'I', '3', '0721', 'ESIBZ')\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_ext_pk, i18n_lang, i18n_text) VALUES ('prto', 37002, 'es', 'Ibiza')\
INSERT INTO tbl_puerto_prto (prto_pk, prto_sprt_pk, prto_codigo, prto_codigo_corto, prto_codigo_edi, prto_rec_aduanero, prto_unlocode)
VALUES (37003, 36000, '84', 'F', '4', '0725', 'ESFNI')\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_ext_pk, i18n_lang, i18n_text) VALUES ('prto', 37003, 'es', 'Formentera')\
INSERT INTO tbl_puerto_prto (prto_pk, prto_sprt_pk, prto_codigo, prto_codigo_corto, prto_codigo_edi, prto_rec_aduanero, prto_unlocode)
VALUES (37004, 36000, '85', 'M', '5', NULL, 'ESMAH')\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_ext_pk, i18n_lang, i18n_text) VALUES ('prto', 37004, 'es', 'La Savina')\

-- Hacer que maestros puedan ser dependientes de tbl_puerto_prto
UPDATE portico.tbl_entidad_enti SET enti_puerto = 1 WHERE enti_pk = 20109\ -- ALINEACION
UPDATE portico.tbl_entidad_enti SET enti_puerto = 1 WHERE enti_pk = 20118\ -- AMARRE_DEP
UPDATE portico.tbl_entidad_enti SET enti_puerto = 1 WHERE enti_pk = 20113\ -- CONTADOR
UPDATE portico.tbl_entidad_enti SET enti_puerto = 1 WHERE enti_pk = 20101\ -- INSTALACION_DEP
UPDATE portico.tbl_entidad_enti SET enti_puerto = 1 WHERE enti_pk = 20100\ -- INSTALACION_DEP_AUT
UPDATE portico.tbl_entidad_enti SET enti_puerto = 1 WHERE enti_pk = 20061\ -- INSTALACION_ESPECIAL
UPDATE portico.tbl_entidad_enti SET enti_puerto = 1 WHERE enti_pk = 20091\ -- MUELLE
UPDATE portico.tbl_entidad_enti SET enti_puerto = 1 WHERE enti_pk = 20114\ -- PUNTO_RED
UPDATE portico.tbl_entidad_enti SET enti_puerto = 1 WHERE enti_pk = 20110\ -- REDES
UPDATE portico.tbl_entidad_enti SET enti_puerto = 1 WHERE enti_pk = 20086\ -- SERVICIO_TRAFICO
UPDATE portico.tbl_entidad_enti SET enti_puerto = 1 WHERE enti_pk = 20078\ -- SUPRABIEN
UPDATE portico.tbl_entidad_enti SET enti_puerto = 1 WHERE enti_pk = 20055\ -- TERMINAL
UPDATE portico.tbl_entidad_enti SET enti_puerto = 1 WHERE enti_pk = 20111\ -- ZONA_DEPOSITO
UPDATE portico.tbl_entidad_enti SET enti_puerto = 1 WHERE enti_pk = 20072\ -- ZONA_PORTUARIA

-- Hacer que subpuerto de maestros apunten a tbl_puerto_prto
ALTER TABLE portico.tbl_parametro_prmt ADD prmt_prto_pk BIGINT\

ALTER TABLE portico.tbl_parametro_prmt ADD CONSTRAINT fk_prmt_prto_pk FOREIGN KEY (prmt_prto_pk)
	REFERENCES portico.tbl_puerto_prto (prto_pk)\

ALTER TABLE portico.tbl_parametro_prmt DROP CONSTRAINT uq_prmt\

UPDATE portico.tbl_parametro_prmt SET
    prmt_prto_pk = (
        SELECT prto_pk
        FROM portico.tbl_puerto_prto
        WHERE prto_codigo_corto = SUBSTR(prmt_parametro, 1, 1)
        LIMIT 1
    )
    , prmt_parametro = SUBSTR(prmt_parametro, 2)
WHERE
    prmt_tppr_pk = ANY (
        SELECT enti_pk
        FROM portico.tbl_entidad_enti
        WHERE enti_puerto = 1
    )
\

ALTER TABLE portico.tbl_parametro_prmt ADD CONSTRAINT uk_prmt UNIQUE (prmt_tppr_pk, prmt_parametro, prmt_prto_pk)\


-- Hacer que subpuerto de servicios apunten a tbl_puerto_prto
ALTER TABLE portico.tbl_servicio_srvc DROP CONSTRAINT fk_srvc_subp_pk\

UPDATE portico.tbl_servicio_srvc SET
	srvc_subp_pk = (
		SELECT prto_pk
		FROM portico.tbl_puerto_prto
		WHERE
			prto_codigo_corto = (
				SELECT prmt_parametro
				FROM portico.tbl_parametro_prmt
				WHERE prmt_pk = srvc_subp_pk
			)
	)
\

ALTER TABLE portico.tbl_servicio_srvc ADD CONSTRAINT fk_srvc_subp_pk FOREIGN KEY (srvc_subp_pk)
	REFERENCES portico.tbl_puerto_prto (prto_pk)\

-- Hacer que subpuerto de estadisticas apunten a tbl_puerto_prto
ALTER TABLE portico.tbl_estadistica_estd DROP CONSTRAINT fk_estd_subp_pk\

UPDATE portico.tbl_estadistica_estd SET
	estd_subp_pk = (
		SELECT prto_pk
		FROM portico.tbl_puerto_prto
		WHERE
			prto_codigo = (
				SELECT prmt_parametro
				FROM portico.tbl_parametro_prmt
				WHERE prmt_pk = estd_subp_pk
			)
	)
\

ALTER TABLE portico.tbl_estadistica_estd ADD CONSTRAINT fk_estd_subp_pk FOREIGN KEY (estd_subp_pk)
	REFERENCES portico.tbl_puerto_prto (prto_pk)\




-- //@UNDO
-- SQL to undo the change goes here.

-- Hacer que maestros no sean dependientes de tbl_puerto_prto
UPDATE portico.tbl_parametro_prmt SET
    prmt_parametro =
    	CONCAT(
    		COALESCE(
				(
			        SELECT prto_codigo_corto
			        FROM portico.tbl_puerto_prto
			        WHERE prto_pk = prmt_prto_pk
			    )
			    , ''
    		)
    		, prmt_parametro
    	)
WHERE
    prmt_tppr_pk = ANY (
        SELECT enti_pk
        FROM portico.tbl_entidad_enti
        WHERE enti_puerto = 1
    )
\

ALTER TABLE portico.tbl_parametro_prmt DROP CONSTRAINT uk_prmt\

ALTER TABLE portico.tbl_parametro_prmt ADD CONSTRAINT uq_prmt UNIQUE (prmt_tppr_pk, prmt_parametro)\

ALTER TABLE portico.tbl_parametro_prmt DROP COLUMN prmt_prto_pk\

-- Hacer que subpuerto de estadisticas apunten a tbl_parametro_prmt
ALTER TABLE portico.tbl_estadistica_estd DROP CONSTRAINT fk_estd_subp_pk\

UPDATE portico.tbl_estadistica_estd SET
	estd_subp_pk = (
		SELECT prmt_pk
		FROM portico.tbl_parametro_prmt
		WHERE
			prmt_tppr_pk = portico.getEntidad('AUTORIDAD_PORTUARIA')
			AND prmt_parametro = (
				SELECT prto_codigo
				FROM portico.tbl_puerto_prto
				WHERE
					prto_pk = estd_subp_pk
			)
	)
\

ALTER TABLE portico.tbl_estadistica_estd ADD CONSTRAINT fk_estd_subp_pk FOREIGN KEY (estd_subp_pk)
	REFERENCES portico.tbl_parametro_prmt (prmt_pk)\

-- Hacer que subpuerto de servicios apunten a tbl_parametro_prmt
ALTER TABLE portico.tbl_servicio_srvc DROP CONSTRAINT fk_srvc_subp_pk\

UPDATE portico.tbl_servicio_srvc SET
	srvc_subp_pk = (
		SELECT prmt_pk
		FROM portico.tbl_parametro_prmt
		WHERE
			prmt_tppr_pk = portico.getEntidad('SUBPUERTO')
			AND prmt_parametro = (
				SELECT prto_codigo_corto
				FROM portico.tbl_puerto_prto
				WHERE
					prto_pk = srvc_subp_pk
			)
	)
\

ALTER TABLE portico.tbl_servicio_srvc ADD CONSTRAINT fk_srvc_subp_pk FOREIGN KEY (srvc_subp_pk)
	REFERENCES portico.tbl_parametro_prmt (prmt_pk)\

DROP TABLE portico.tbl_puerto_prto\
DROP TABLE portico.tbl_superpuerto_sprt\

DELETE FROM portico.tbl_i18n_i18n WHERE i18n_pref = 'prto'\
DELETE FROM portico.tbl_i18n_i18n WHERE i18n_pref = 'sprt'\

ALTER TABLE portico.tbl_entidad_enti DROP COLUMN enti_gis\
ALTER TABLE portico.tbl_entidad_enti DROP COLUMN enti_puerto\
