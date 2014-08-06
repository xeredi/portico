-- // 0 0 2 Facturacion Funciones
-- Migration SQL that makes the change goes here.


CREATE FUNCTION portico.escalaEsAvituallamiento(itemId INTEGER, fref TIMESTAMP with time zone) RETURNS BOOLEAN AS $$
DECLARE
	id integer;
BEGIN
	id := (
		SELECT 1
		FROM tbl_servicio_srvc
		WHERE 
			srvc_tpsr_pk = portico.getEntidad('ESCALA')
			-- Que haya algun atraque con alguna de las actividades:
			AND EXISTS (
				SELECT 1
				FROM tbl_subservicio_ssrv
				WHERE 
					ssrv_srvc_pk = srvc_pk
					AND ssrv_tpss_pk = portico.getEntidad('ATRAQUE')
					AND EXISTS (
						SELECT 1 
						FROM tbl_subservicio_dato_ssdt
						WHERE 
							ssdt_ssrv_pk = ssrv_pk
							AND ssdt_tpdt_pk = portico.getTipoDato('TIPO_ACT_3')
							AND ssdt_prmt_pk = ANY (
								SELECT prmt_pk
								FROM tbl_parametro_prmt
								WHERE 
									prmt_tppr_pk = portico.getEntidad('TIPO_ACTIVIDAD')
									AND prmt_parametro IN ('AR','AB','AF','AT','FE','AP','RF','RT','RA')
							)
					)
			)
			-- Que no haya ningun atraque con actividades distintas a:
			AND NOT EXISTS (
				SELECT 1
				FROM tbl_subservicio_ssrv
				WHERE 
					ssrv_srvc_pk = srvc_pk
					AND ssrv_tpss_pk = portico.getEntidad('ATRAQUE')
					AND EXISTS (
						SELECT 1 
						FROM tbl_subservicio_dato_ssdt
						WHERE 
							ssdt_ssrv_pk = ssrv_pk
							AND ssdt_tpdt_pk = portico.getTipoDato('TIPO_ACT_3')
							AND ssdt_prmt_pk = ANY (
								SELECT prmt_pk
								FROM tbl_parametro_prmt
								WHERE 
									prmt_tppr_pk = portico.getEntidad('TIPO_ACTIVIDAD')
									AND prmt_parametro NOT IN ('AR','AB','AF','AT','FE','AP','RF','RT','RA','FE')
							)
					)
			)
			-- Que no haya ningun atraque con alineacion en zona portuaria <> 'I'
			AND NOT EXISTS (
				SELECT 1
				FROM tbl_subservicio_ssrv
				WHERE 
					ssrv_srvc_pk = srvc_pk
					AND ssrv_tpss_pk = portico.getEntidad('ATRAQUE')
					AND EXISTS (
						SELECT 1 
						FROM tbl_subservicio_dato_ssdt
						WHERE 
							ssdt_ssrv_pk = ssrv_pk
							AND ssdt_tpdt_pk = portico.getTipoDato('ALIN_3')
							AND EXISTS (
								SELECT 1
								FROM tbl_parametro_prmt
								WHERE prmt_pk = ssdt_prmt_pk
									AND EXISTS (
										SELECT 1
										FROM tbl_parametro_version_prvr
										WHERE 
											prvr_prmt_pk = prmt_pk
											AND fref BETWEEN prvr_fini AND COALESCE(prvr_ffin, fref)
											AND EXISTS (
												SELECT 1
												FROM tbl_parametro_dato_prdt
												WHERE 
													prdt_prvr_pk = prvr_pk
													AND prdt_tpdt_pk = portico.getTipoDato('BOOLEANO_04')
													AND prdt_nentero <> 0 -- TODO Cambiar por CR
											)
									)
							)
					)
			)
			-- Estancia Corta de la escala
			AND EXISTS (
				SELECT 1
				FROM tbl_servicio_dato_srdt
				WHERE 
					srdt_srvc_pk = srvc_pk
					AND srdt_tpdt_pk = portico.getTipoDato('TIPO_ESTAN_ESC')
					AND srdt_cadena = 'C'
			)
			AND (srvc_fini + interval '48 hours') >= srvc_ffin
			AND srvc_pk = itemId
	);

	IF id IS NULL
	THEN
		RETURN false;
	ELSE
		RETURN true;
	END IF;
END;
$$ LANGUAGE plpgsql
/

GRANT EXECUTE ON FUNCTION portico.escalaEsAvituallamiento(INTEGER, TIMESTAMP with time zone) TO portico
/

COMMENT ON FUNCTION portico.escalaEsAvituallamiento(INTEGER, TIMESTAMP with time zone) IS 'Indicar si la escala pasada como argumento es o no de avituallamiento'
/








CREATE FUNCTION portico.escalaValorContador(itemId INTEGER, fref TIMESTAMP with time zone, tipoContador VARCHAR) RETURNS INTEGER AS $$
DECLARE
	id integer;
BEGIN
	id := (
		SELECT ssdt_nentero
		FROM tbl_subservicio_dato_ssdt
		WHERE 
			ssdt_tpdt_pk = portico.getTipoDato('ENTERO_01')
			AND EXISTS (
				SELECT 1
				FROM
					tbl_subservicio_ssrv
				WHERE
					ssrv_pk = ssdt_ssrv_pk
					AND ssrv_tpss_pk = portico.getEntidad('ESCALA_CONTADOR')
					AND EXISTS (
						SELECT 1
						FROM tbl_servicio_srvc
						WHERE 
							srvc_tpsr_pk = portico.getEntidad('ESCALA')
							and srvc_pk = ssrv_srvc_pk
							AND srvc_pk = itemId
					)
					AND EXISTS (
						SELECT 1
						FROM tbl_subservicio_dato_ssdt
						WHERE 
							ssdt_ssrv_pk = ssrv_pk
							AND ssdt_tpdt_pk = portico.getTipoDato('CONT_ESCALA')
							AND ssdt_cadena = tipoContador
					)
			)
	);

	IF id IS NULL
	THEN
		RETURN 0;
	ELSE
		RETURN id;
	END IF;
END;
$$ LANGUAGE plpgsql
/

GRANT EXECUTE ON FUNCTION portico.escalaValorContador(INTEGER, TIMESTAMP with time zone, VARCHAR) TO portico
/

COMMENT ON FUNCTION portico.escalaValorContador(INTEGER, TIMESTAMP with time zone, VARCHAR) IS 'Devolver el valor de un contador de una escala. Si no encuentra contador, devuelve 0'
/







CREATE FUNCTION portico.escalaEsBuqueCertificado(itemId INTEGER, fref TIMESTAMP with time zone, tipoCertificado VARCHAR) RETURNS BOOLEAN AS $$
DECLARE
	id integer;
BEGIN
	id := (
		SELECT 1
		FROM tbl_servicio_srvc
		WHERE 
			srvc_tpsr_pk = portico.getEntidad('ESCALA')
			AND EXISTS (
				SELECT 1
				FROM tbl_servicio_dato_srdt
				WHERE srdt_srvc_pk = srvc_pk
					AND srdt_tpdt_pk = portico.getTipoDato('BUQUE')
					AND EXISTS (
						SELECT 1
						FROM tbl_subparametro_sprm
						WHERE 
							sprm_tpsp_pk = portico.getEntidad('BUQUE_CERTIFICADO')
							AND sprm_prmt_pk = srdt_prmt_pk
							AND EXISTS (
								select 1
								from tbl_parametro_prmt
								WHERE 
									prmt_tppr_pk = portico.getEntidad('TIPO_CERTIFICADO')
									AND prmt_pk = sprm_prmt_dep_pk
									AND prmt_parametro = tipoCertificado
							)
							AND EXISTS (
								SELECT 1
								FROM tbl_subparametro_version_spvr
								WHERE 
									spvr_sprm_pk = sprm_pk
									AND fref BETWEEN spvr_fini AND COALESCE(spvr_ffin, fref)
							)
					)
			)
			AND srvc_pk = itemId
	);

	IF id IS NULL
	THEN
		RETURN false;
	ELSE
		RETURN true;
	END IF;
END;
$$ LANGUAGE plpgsql
/

GRANT EXECUTE ON FUNCTION portico.escalaEsBuqueCertificado(INTEGER, TIMESTAMP with time zone, VARCHAR) TO portico
/

COMMENT ON FUNCTION portico.escalaEsBuqueCertificado(INTEGER, TIMESTAMP with time zone, VARCHAR) IS 'Indicar si el buque de la escala pasada como argumento tiene un certificado vigente para la fecha fref'
/














-- //@UNDO
-- SQL to undo the change goes here.

DROP FUNCTION portico.escalaEsBuqueCertificado(INTEGER, TIMESTAMP with time zone, VARCHAR)
/
DROP FUNCTION portico.escalaValorContador(INTEGER, TIMESTAMP with time zone, VARCHAR)
/
DROP FUNCTION portico.escalaEsAvituallamiento(INTEGER, TIMESTAMP with time zone)
/
