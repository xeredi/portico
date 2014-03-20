/**
 * A partir de un código de entidad, se localiza su identificador asociado
 */
CREATE OR REPLACE FUNCTION getEntidad(entiCodigo varchar) RETURNS integer IMMUTABLE AS $$
DECLARE
	id integer;
BEGIN
	id := (SELECT enti_pk FROM tbl_entidad_enti WHERE enti_codigo = entiCodigo);

	IF id IS NULL
	THEN
		RAISE EXCEPTION 'Entidad NO encontrada --> %', entiCodigo;
	END IF;

	return id;
END;
$$ LANGUAGE plpgsql;

/**
 * A partir de un codigo de tipo de dato, se localiza su identificador asociado
 */
CREATE OR REPLACE FUNCTION getTipoDato(tpdtCodigo varchar) RETURNS integer IMMUTABLE AS $$
DECLARE
	id integer;
BEGIN
	id := (SELECT tpdt_pk FROM tbl_tipo_dato_tpdt WHERE tpdt_codigo = tpdtCodigo);

	IF id IS NULL
	THEN
		RAISE EXCEPTION 'Tipo de Dato NO encontrado --> %', tpdtCodigo;
	END IF;

	return id;
END;
$$ LANGUAGE plpgsql;

-- SELECT getEntidad('ACUERDO');
-- SELECT getEntidad('kaka');
-- SELECT getTipoDato('ACUERDO');
-- SELECT getTipoDato('kaka');

