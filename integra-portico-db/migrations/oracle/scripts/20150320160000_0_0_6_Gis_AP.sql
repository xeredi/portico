-- // 20150320160000_0_0_6_Gis_AP.sql
-- Migration SQL that makes the change goes here.


ALTER TABLE tbl_entidad_enti ADD enti_gis INT DEFAULT 0 NOT NULL\
ALTER TABLE tbl_entidad_enti ADD enti_puerto INT DEFAULT 0 NOT NULL\

ALTER TABLE tbl_parametro_version_prvr ADD prvr_lat DOUBLE PRECISION\
ALTER TABLE tbl_parametro_version_prvr ADD prvr_lon DOUBLE PRECISION\

CREATE TABLE tbl_superpuerto_sprt (
	sprt_pk NUMBER(19) NOT NULL
	, sprt_codigo VARCHAR2(10) NOT NULL

	, CONSTRAINT pk_sprt PRIMARY KEY (sprt_pk)

	, CONSTRAINT uk_sprt UNIQUE (sprt_codigo)
)\

CREATE OR REPLACE SYNONYM portico.tbl_superpuerto_sprt FOR tbl_superpuerto_sprt\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_superpuerto_sprt TO portico\

INSERT INTO tbl_superpuerto_sprt (sprt_pk, sprt_codigo) VALUES (36100, '0')\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_ext_pk, i18n_lang, i18n_text) VALUES ('sprt', 36100, 'es', 'Autp Genérica')\
INSERT INTO tbl_superpuerto_sprt (sprt_pk, sprt_codigo) VALUES (36101, '*')\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_ext_pk, i18n_lang, i18n_text) VALUES ('sprt', 36101, 'es', 'Autp Genérica 2')\

INSERT INTO tbl_superpuerto_sprt (sprt_pk, sprt_codigo) VALUES (36000, '80')\
	INSERT INTO tbl_i18n_i18n (i18n_pref, i18n_ext_pk, i18n_lang, i18n_text) VALUES ('sprt', 36000, 'es', 'Baleares')\

CREATE TABLE tbl_puerto_prto (
	prto_pk NUMBER(19) NOT NULL
	, prto_sprt_pk NUMBER(19) NOT NULL
	, prto_codigo VARCHAR2(10) NOT NULL
	, prto_codigo_corto VARCHAR2(10) NOT NULL
	, prto_codigo_edi VARCHAR2(10)
	, prto_rec_aduanero VARCHAR2(10)
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

CREATE OR REPLACE SYNONYM portico.tbl_puerto_prto FOR tbl_puerto_prto\

GRANT SELECT, INSERT, UPDATE, DELETE ON tbl_puerto_prto TO portico\

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
UPDATE tbl_entidad_enti SET enti_puerto = 1 WHERE enti_pk = 20109\ -- ALINEACION
UPDATE tbl_entidad_enti SET enti_puerto = 1 WHERE enti_pk = 20118\ -- AMARRE_DEP
UPDATE tbl_entidad_enti SET enti_puerto = 1 WHERE enti_pk = 20113\ -- CONTADOR
UPDATE tbl_entidad_enti SET enti_puerto = 1 WHERE enti_pk = 20101\ -- INSTALACION_DEP
UPDATE tbl_entidad_enti SET enti_puerto = 1 WHERE enti_pk = 20100\ -- INSTALACION_DEP_AUT
UPDATE tbl_entidad_enti SET enti_puerto = 1 WHERE enti_pk = 20061\ -- INSTALACION_ESPECIAL
UPDATE tbl_entidad_enti SET enti_puerto = 1 WHERE enti_pk = 20091\ -- MUELLE
UPDATE tbl_entidad_enti SET enti_puerto = 1 WHERE enti_pk = 20114\ -- PUNTO_RED
UPDATE tbl_entidad_enti SET enti_puerto = 1 WHERE enti_pk = 20110\ -- REDES
UPDATE tbl_entidad_enti SET enti_puerto = 1 WHERE enti_pk = 20086\ -- SERVICIO_TRAFICO
UPDATE tbl_entidad_enti SET enti_puerto = 1 WHERE enti_pk = 20078\ -- SUPRABIEN
UPDATE tbl_entidad_enti SET enti_puerto = 1 WHERE enti_pk = 20055\ -- TERMINAL
UPDATE tbl_entidad_enti SET enti_puerto = 1 WHERE enti_pk = 20111\ -- ZONA_DEPOSITO
UPDATE tbl_entidad_enti SET enti_puerto = 1 WHERE enti_pk = 20072\ -- ZONA_PORTUARIA

-- Hacer que subpuerto de maestros apunten a tbl_puerto_prto
ALTER TABLE tbl_parametro_prmt ADD prmt_prto_pk NUMBER(19)\

ALTER TABLE tbl_parametro_prmt ADD CONSTRAINT fk_prmt_prto_pk FOREIGN KEY (prmt_prto_pk)
	REFERENCES tbl_puerto_prto (prto_pk)\

ALTER TABLE tbl_parametro_prmt DROP CONSTRAINT uq_prmt\

UPDATE tbl_parametro_prmt SET
    prmt_prto_pk = (
        SELECT prto_pk
        FROM tbl_puerto_prto
        WHERE prto_codigo_corto = SUBSTR(prmt_parametro, 1, 1)
            AND rownum <= 1
    )
    , prmt_parametro = SUBSTR(prmt_parametro, 2)
WHERE
    prmt_tppr_pk = ANY (
        SELECT enti_pk
        FROM tbl_entidad_enti
        WHERE enti_puerto = 1
    )
\

ALTER TABLE tbl_parametro_prmt ADD CONSTRAINT uk_prmt UNIQUE (prmt_tppr_pk, prmt_parametro, prmt_prto_pk)\


-- Hacer que subpuerto de servicios apunten a tbl_puerto_prto
ALTER TABLE tbl_servicio_srvc DROP CONSTRAINT fk_srvc_subp_pk\

UPDATE tbl_servicio_srvc SET
	srvc_subp_pk = (
		SELECT prto_pk
		FROM tbl_puerto_prto
		WHERE
			prto_codigo_corto = (
				SELECT prmt_parametro
				FROM tbl_parametro_prmt
				WHERE prmt_pk = srvc_subp_pk
			)
	)
\

ALTER TABLE tbl_servicio_srvc ADD CONSTRAINT fk_srvc_subp_pk FOREIGN KEY (srvc_subp_pk)
	REFERENCES tbl_puerto_prto (prto_pk)\

ALTER TABLE tbl_servicio_secuencia_srsc DROP CONSTRAINT fk_srsc_subp_pk\

UPDATE tbl_servicio_secuencia_srsc SET
	srsc_subp_pk = (
		SELECT prto_pk
		FROM tbl_puerto_prto
		WHERE
			prto_codigo_corto = (
				SELECT prmt_parametro
				FROM tbl_parametro_prmt
				WHERE prmt_pk = srsc_subp_pk
			)
	)
\

ALTER TABLE tbl_servicio_secuencia_srsc ADD CONSTRAINT fk_srsc_subp_pk FOREIGN KEY (srsc_subp_pk)
	REFERENCES tbl_puerto_prto (prto_pk)\

-- Hacer que subpuerto de estadisticas apunten a tbl_puerto_prto
ALTER TABLE tbl_periodo_proceso_pepr DROP CONSTRAINT fk_pepr_autp_pk\

UPDATE tbl_periodo_proceso_pepr SET
	pepr_autp_pk = (
		SELECT sprt_pk
		FROM tbl_superpuerto_sprt
		WHERE
			sprt_codigo = (
				SELECT prmt_parametro
				FROM tbl_parametro_prmt
				WHERE prmt_pk = pepr_autp_pk
			)
	)
\

ALTER TABLE tbl_periodo_proceso_pepr ADD CONSTRAINT fk_pepr_autp_pk FOREIGN KEY (pepr_autp_pk)
	REFERENCES tbl_superpuerto_sprt (sprt_pk)\

ALTER TABLE tbl_estadistica_estd DROP CONSTRAINT fk_estd_subp_pk\

UPDATE tbl_estadistica_estd SET
	estd_subp_pk = (
		SELECT prto_pk
		FROM tbl_puerto_prto
		WHERE
			prto_codigo = (
				SELECT prmt_parametro
				FROM tbl_parametro_prmt
				WHERE prmt_pk = estd_subp_pk
			)
	)
\

ALTER TABLE tbl_estadistica_estd ADD CONSTRAINT fk_estd_subp_pk FOREIGN KEY (estd_subp_pk)
	REFERENCES tbl_puerto_prto (prto_pk)\




-- //@UNDO
-- SQL to undo the change goes here.

-- Hacer que maestros no sean dependientes de tbl_puerto_prto
UPDATE tbl_parametro_prmt SET
    prmt_parametro =
    	CONCAT(
    		COALESCE(
				(
			        SELECT prto_codigo_corto
			        FROM tbl_puerto_prto
			        WHERE prto_pk = prmt_prto_pk
			    )
			    , ''
    		)
    		, prmt_parametro
    	)
WHERE
    prmt_tppr_pk = ANY (
        SELECT enti_pk
        FROM tbl_entidad_enti
        WHERE enti_puerto = 1
    )
\

ALTER TABLE tbl_parametro_prmt DROP CONSTRAINT uk_prmt\

ALTER TABLE tbl_parametro_prmt ADD CONSTRAINT uq_prmt UNIQUE (prmt_tppr_pk, prmt_parametro)\

ALTER TABLE tbl_parametro_prmt DROP COLUMN prmt_prto_pk\

-- Hacer que subpuerto de estadisticas apunten a tbl_parametro_prmt
ALTER TABLE tbl_periodo_proceso_pepr DROP CONSTRAINT fk_pepr_autp_pk\

UPDATE tbl_periodo_proceso_pepr SET
	pepr_autp_pk = (
		SELECT prmt_pk
		FROM tbl_parametro_prmt
		WHERE
			prmt_tppr_pk = portico.getEntidad('AUTORIDAD_PORTUARIA')
			AND prmt_parametro = (
				SELECT sprt_codigo
				FROM tbl_superpuerto_sprt
				WHERE
					sprt_pk = pepr_autp_pk
			)
	)
\

ALTER TABLE tbl_periodo_proceso_pepr ADD CONSTRAINT fk_pepr_autp_pk FOREIGN KEY (pepr_autp_pk)
	REFERENCES tbl_parametro_prmt (prmt_pk)\

ALTER TABLE tbl_estadistica_estd DROP CONSTRAINT fk_estd_subp_pk\

UPDATE tbl_estadistica_estd SET
	estd_subp_pk = (
		SELECT prmt_pk
		FROM tbl_parametro_prmt
		WHERE
			prmt_tppr_pk = portico.getEntidad('AUTORIDAD_PORTUARIA')
			AND prmt_parametro = (
				SELECT prto_codigo
				FROM tbl_puerto_prto
				WHERE
					prto_pk = estd_subp_pk
			)
	)
\

ALTER TABLE tbl_estadistica_estd ADD CONSTRAINT fk_estd_subp_pk FOREIGN KEY (estd_subp_pk)
	REFERENCES tbl_parametro_prmt (prmt_pk)\

-- Hacer que subpuerto de servicios apunten a tbl_parametro_prmt
ALTER TABLE tbl_servicio_srvc DROP CONSTRAINT fk_srvc_subp_pk\

UPDATE tbl_servicio_srvc SET
	srvc_subp_pk = (
		SELECT prmt_pk
		FROM tbl_parametro_prmt
		WHERE
			prmt_tppr_pk = portico.getEntidad('SUBPUERTO')
			AND prmt_parametro = (
				SELECT prto_codigo_corto
				FROM tbl_puerto_prto
				WHERE
					prto_pk = srvc_subp_pk
			)
	)
\

ALTER TABLE tbl_servicio_srvc ADD CONSTRAINT fk_srvc_subp_pk FOREIGN KEY (srvc_subp_pk)
	REFERENCES tbl_parametro_prmt (prmt_pk)\

ALTER TABLE tbl_servicio_secuencia_srsc DROP CONSTRAINT fk_srsc_subp_pk\

UPDATE tbl_servicio_secuencia_srsc SET
	srsc_subp_pk = (
		SELECT prmt_pk
		FROM tbl_parametro_prmt
		WHERE
			prmt_tppr_pk = portico.getEntidad('SUBPUERTO')
			AND prmt_parametro = (
				SELECT prto_codigo_corto
				FROM tbl_puerto_prto
				WHERE
					prto_pk = srsc_subp_pk
			)
	)
\

ALTER TABLE tbl_servicio_secuencia_srsc ADD CONSTRAINT fk_srsc_subp_pk FOREIGN KEY (srsc_subp_pk)
	REFERENCES tbl_parametro_prmt (prmt_pk)\


-- Borrado de tablas de puerto y superpuerto
DROP TABLE tbl_puerto_prto\
DROP TABLE tbl_superpuerto_sprt\

DELETE FROM tbl_i18n_i18n WHERE i18n_pref = 'prto'\
DELETE FROM tbl_i18n_i18n WHERE i18n_pref = 'sprt'\

ALTER TABLE tbl_parametro_version_prvr DROP COLUMN prvr_lat\
ALTER TABLE tbl_parametro_version_prvr DROP COLUMN prvr_lon\

ALTER TABLE tbl_entidad_enti DROP COLUMN enti_gis\
ALTER TABLE tbl_entidad_enti DROP COLUMN enti_puerto\
