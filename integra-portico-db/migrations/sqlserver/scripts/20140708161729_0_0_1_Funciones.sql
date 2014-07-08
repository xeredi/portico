-- // 0 0 1 Funciones
-- Migration SQL that makes the change goes here.

CREATE FUNCTION getEntidad(@entiCodigo varchar) RETURNS integer AS
BEGIN
	DECLARE @id AS integer;

	id = (SELECT enti_pk FROM tbl_entidad_enti WHERE enti_codigo = @entiCodigo);

	IF id IS NULL
	THEN
		RAISE EXCEPTION 'Entidad NO encontrada --> %', @entiCodigo;
	END IF;

	return @id;
END
/

GRANT EXECUTE ON FUNCTION getEntidad(varchar) TO portico
/



CREATE FUNCTION getTipoDato(@tpdtCodigo varchar) RETURNS integer AS
BEGIN
	DECLARE id AS integer;

	id = (SELECT tpdt_pk FROM tbl_tipo_dato_tpdt WHERE @tpdt_codigo = @tpdtCodigo);

	IF id IS NULL
	THEN
		RAISE EXCEPTION 'Tipo de Dato NO encontrado --> %', @tpdtCodigo;
	END IF;

	return @id;
END
/

GRANT EXECUTE ON FUNCTION getTipoDato(varchar) TO portico
/



CREATE FUNCTION getSysDatetime() RETURNS TIMESTAMP AS
BEGIN
     RETURN SYSDATETIME();
END
/

GRANT EXECUTE ON FUNCTION getSysDatetime() TO portico
/


-- //@UNDO
-- SQL to undo the change goes here.

DROP FUNCTION getTipoDato(varchar)
/

DROP FUNCTION getEntidad(varchar)
/

DROP FUNCTION getSysDatetime()
/

