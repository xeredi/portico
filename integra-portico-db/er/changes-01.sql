ALTER TABLE tbl_entidad_tipo_dato_entd ADD COLUMN entd_valor_defecto VARCHAR(30);
ALTER TABLE tbl_entidad_enti ADD COLUMN enti_duplicable INTEGER not null default 0;

