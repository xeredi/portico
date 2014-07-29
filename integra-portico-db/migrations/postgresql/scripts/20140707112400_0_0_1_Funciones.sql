-- // 0 0 1 Funciones
-- Migration SQL that makes the change goes here.



CREATE FUNCTION portico.getEntidad(entiCodigo varchar) RETURNS integer IMMUTABLE AS $$
DECLARE
	id integer;
BEGIN
	id := (SELECT enti_pk FROM portico.tbl_entidad_enti WHERE enti_codigo = entiCodigo);

	IF id IS NULL
	THEN
		RAISE EXCEPTION 'Entidad NO encontrada --> %', entiCodigo;
	END IF;

	return id;
END;
$$ LANGUAGE plpgsql
/

GRANT EXECUTE ON FUNCTION portico.getEntidad(varchar) TO portico
/

COMMENT ON FUNCTION portico.getEntidad(varchar) IS 'A partir de un codigo de entidad, se localiza su identificador asociado'
/



CREATE FUNCTION portico.getTipoDato(tpdtCodigo varchar) RETURNS integer IMMUTABLE AS $$
DECLARE
	id integer;
BEGIN
	id := (SELECT tpdt_pk FROM portico.tbl_tipo_dato_tpdt WHERE tpdt_codigo = tpdtCodigo);

	IF id IS NULL
	THEN
		RAISE EXCEPTION 'Tipo de Dato NO encontrado --> %', tpdtCodigo;
	END IF;

	return id;
END;
$$ LANGUAGE plpgsql
/

GRANT EXECUTE ON FUNCTION portico.getTipoDato(varchar) TO portico
/

COMMENT ON FUNCTION portico.getTipoDato(varchar) IS 'A partir de un codigo de tipo de dato, se localiza su identificador asociado'
/



CREATE FUNCTION portico.getSysDatetime() RETURNS TIMESTAMP IMMUTABLE AS $$
BEGIN
     RETURN NOW();
END;
$$ LANGUAGE plpgsql
/

GRANT EXECUTE ON FUNCTION portico.getSysDatetime() TO portico
/

COMMENT ON FUNCTION portico.getSysDatetime() IS 'Obtencion de la Fecha-Hora del Sistema'
/


CREATE FUNCTION portico.concat(vc1 varchar, vc2 varchar) RETURNS varchar IMMUTABLE AS $$
BEGIN
     RETURN vc1 || vc2;
END;
$$ LANGUAGE plpgsql
/

GRANT EXECUTE ON FUNCTION portico.concat(varchar, varchar) TO portico
/

COMMENT ON FUNCTION portico.concat(varchar, varchar) IS 'Concatenacion de Elementos'
/


-- //@UNDO
-- SQL to undo the change goes here.

DROP FUNCTION portico.concat(varchar, varchar)
/

DROP FUNCTION portico.getSysDatetime()
/

DROP FUNCTION portico.getTipoDato(varchar)
/

DROP FUNCTION portico.getEntidad(varchar)
/


