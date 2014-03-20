ALTER TABLE tbl_entidad_tipo_dato_entd ADD COLUMN entd_grupo INT NOT NULL DEFAULT 1;

ALTER TABLE tbl_tipo_subservicio_tpss ADD COLUMN tpss_es_temporal INT NOT NULL DEFAULT 0;
ALTER TABLE tbl_tipo_subservicio_tpss ADD COLUMN tpss_es_facturable INT NOT NULL DEFAULT 0;
