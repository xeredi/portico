-- // 0 0 1 Funciones
-- Migration SQL that makes the change goes here.



CREATE FUNCTION getEntidad(entiCodigo varchar) RETURN integer IS
	id integer;
BEGIN
	SELECT enti_pk INTO id FROM tbl_entidad_enti WHERE enti_codigo = entiCodigo;

	RETURN id;
EXCEPTION
   WHEN NO_DATA_FOUND THEN
  		RAISE_APPLICATION_ERROR(-20000, 'Entidad NO encontrada --> ' || entiCodigo);
END;\

CREATE OR REPLACE SYNONYM portico.getEntidad FOR porticoadm.getEntidad\

GRANT EXECUTE ON getEntidad TO portico\



CREATE FUNCTION getTipoDato(tpdtCodigo varchar) RETURN integer IS
	id integer;
BEGIN
	SELECT tpdt_pk INTO id FROM tbl_tipo_dato_tpdt WHERE tpdt_codigo = tpdtCodigo;

	RETURN id;
EXCEPTION
   WHEN NO_DATA_FOUND THEN
  		RAISE_APPLICATION_ERROR(-20000, 'Tipo de Dato NO encontrado --> ' || tpdtCodigo);
END;\

CREATE OR REPLACE SYNONYM portico.getTipoDato FOR porticoadm.getTipoDato\

GRANT EXECUTE ON getTipoDato TO portico\



CREATE Function getSysDatetime RETURN TIMESTAMP IS
BEGIN
	RETURN SYSTIMESTAMP;
END;\

CREATE OR REPLACE SYNONYM portico.getSysDatetime FOR porticoadm.getSysDatetime\

GRANT EXECUTE ON getSysDatetime TO portico\



create or replace FUNCTION concatenate(vc1 varchar, vc2 varchar) RETURN varchar IS
BEGIN
	RETURN vc1 || vc2;
END;\

CREATE OR REPLACE SYNONYM portico.concatenate FOR concatenate\

GRANT EXECUTE ON concatenate TO portico\




-- //@UNDO
-- SQL to undo the change goes here.

DROP FUNCTION concatenate\
DROP FUNCTION getTipoDato\
DROP FUNCTION getEntidad\
DROP FUNCTION getSysDatetime\

