-- // 0 0 1 Funciones
-- Migration SQL that makes the change goes here.



CREATE FUNCTION portico.getSysDatetime() RETURNS DATETIME2 AS
BEGIN
     RETURN SYSDATETIME();
END
/



CREATE FUNCTION portico.getEntidad(@entiCodigo varchar(30)) RETURNS integer AS
BEGIN
	DECLARE @id AS integer;
	DECLARE @err_message nvarchar(255)

	SELECT @id = enti_pk FROM portico.tbl_entidad_enti WHERE enti_codigo = @entiCodigo;

	IF @@rowcount = 0
	BEGIN
		SET @err_message = 'Entidad NO encontrada -->' + @entiCodigo;

		-- RAISERROR (@err_message, 11, 1);
		RETURN -1;
	END;

	RETURN @id;
END
/



CREATE FUNCTION portico.getTipoDato(@tpdtCodigo varchar(30)) RETURNS integer AS
BEGIN
	DECLARE @id AS integer;
	DECLARE @err_message nvarchar(255)

	SELECT @id = tpdt_pk FROM portico.tbl_tipo_dato_tpdt WHERE tpdt_codigo = @tpdtCodigo;

	IF @@rowcount = 0
	BEGIN
		SET @err_message = 'Tipo de Dato NO encontrado -->' + @tpdtCodigo;

		-- RAISERROR (@err_message, 11, 1);
		RETURN -1;
	END;

	RETURN @id;
END
/


-- //@UNDO
-- SQL to undo the change goes here.

DROP FUNCTION portico.getTipoDato
/

DROP FUNCTION portico.getEntidad
/

DROP FUNCTION portico.getSysDatetime
/

