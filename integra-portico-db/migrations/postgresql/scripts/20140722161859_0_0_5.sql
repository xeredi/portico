-- // 0 0 5.sql
-- Migration SQL that makes the change goes here.


-- Columna de limite de filas visibles en un grid
ALTER TABLE portico.tbl_entidad_enti ADD enti_max_grid INT DEFAULT 0 NOT NULL;

UPDATE portico.tbl_entidad_enti SET enti_max_grid = CASE
	WHEN enti_tipo = 'P' THEN 10000
	WHEN enti_tipo = 'B' THEN 100
	WHEN enti_tipo = 'T' THEN 10000
	WHEN enti_tipo = 'S' THEN 50000
	WHEN enti_tipo = 'E' THEN 10000
END;




















-- //@UNDO
-- SQL to undo the change goes here.

-- Columna de limite de filas visibles en un grid
ALTER TABLE portico.tbl_entidad_enti DROP COLUMN enti_max_grid;
