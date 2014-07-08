-- // 0 0 1 Funciones
-- Migration SQL that makes the change goes here.



CREATE FUNCTION getEntidad(entiCodigo varchar) RETURNS integer IMMUTABLE AS $$
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
$$ LANGUAGE plpgsql
/

GRANT EXECUTE ON FUNCTION getEntidad(varchar) TO portico
/

COMMENT ON FUNCTION getEntidad(varchar) IS 'A partir de un codigo de entidad, se localiza su identificador asociado'
/



CREATE FUNCTION getTipoDato(tpdtCodigo varchar) RETURNS integer IMMUTABLE AS $$
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
$$ LANGUAGE plpgsql
/

GRANT EXECUTE ON FUNCTION getTipoDato(varchar) TO portico
/

COMMENT ON FUNCTION getTipoDato(varchar) IS 'A partir de un codigo de tipo de dato, se localiza su identificador asociado'
/



CREATE FUNCTION getSysDatetime() RETURNS TIMESTAMP IMMUTABLE AS $$
    BEGIN
         RETURN NOW();
    END;
$$ LANGUAGE plpgsql
/

GRANT EXECUTE ON FUNCTION getSysDatetime() TO portico
/

COMMENT ON FUNCTION getSysDatetime() IS 'Obtencion de la Fecha-Hora del Sistema'
/


-- //@UNDO
-- SQL to undo the change goes here.

DROP FUNCTION getTipoDato(varchar)
/

DROP FUNCTION getEntidad(varchar)
/

DROP FUNCTION getSysDatetime()
/

