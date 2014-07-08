-- // 0 0 1 Funciones
-- Migration SQL that makes the change goes here.



CREATE FUNCTION getEntidad(entiCodigo varchar) RETURN integer IS
	id integer;
BEGIN
	SELECT enti_pk INTO id FROM tbl_entidad_enti WHERE enti_codigo = entiCodigo;

	DBMS_OUTPUT.PUT_LINE(id);

	IF id IS NULL
	THEN
		id := -1;

		raise_application_error(-1, 'Entidad NO encontrada --> ' || entiCodigo);
	END IF;

	return id;
END;
/

CREATE OR REPLACE SYNONYM portico.getEntidad FOR porticoadm.getEntidad
/

GRANT EXECUTE ON getEntidad TO portico
/



CREATE FUNCTION getTipoDato(tpdtCodigo varchar) RETURN integer IS
	id integer;
BEGIN
	SELECT tpdt_pk INTO id FROM tbl_tipo_dato_tpdt WHERE tpdt_codigo = tpdtCodigo;

	DBMS_OUTPUT.PUT_LINE(id);

	IF id IS NULL
	THEN
		id := -1;

		raise_application_error(-1, 'Tipo de Dato NO encontrado --> ' || tpdtCodigo);
	END IF;

	return id;
END;
/

CREATE OR REPLACE SYNONYM portico.getTipoDato FOR porticoadm.getTipoDato
/

GRANT EXECUTE ON getTipoDato TO portico
/



CREATE Function getSysDatetime RETURN TIMESTAMP IS
BEGIN
	RETURN SYSTIMESTAMP;
END;
/

CREATE OR REPLACE SYNONYM portico.getSysDatetime FOR porticoadm.getSysDatetime
/

GRANT EXECUTE ON getSysDatetime TO portico
/


-- //@UNDO
-- SQL to undo the change goes here.

DROP FUNCTION getTipoDato
/

DROP FUNCTION getEntidad
/

DROP FUNCTION getSysDatetime
/

