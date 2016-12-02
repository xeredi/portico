-- // 0 0 1 Funciones
-- Migration SQL that makes the change goes here.



CREATE OR REPLACE FUNCTION getEntidad(entiCodigo varchar) RETURN integer RESULT_CACHE IS
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



CREATE OR REPLACE FUNCTION getTipoDato(tpdtCodigo varchar) RETURN integer RESULT_CACHE IS
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



CREATE OR REPLACE Function getSysDatetime RETURN TIMESTAMP IS
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



CREATE OR REPLACE FUNCTION daysBetween(fdesde DATE, fhasta DATE)
   RETURN DOUBLE PRECISION
IS
BEGIN
   RETURN fhasta - fdesde;
END;
\

CREATE OR REPLACE SYNONYM portico.daysBetween FOR daysBetween\

GRANT EXECUTE ON daysBetween TO portico\





CREATE OR REPLACE PROCEDURE eraseEnti(entiId NUMBER) IS
BEGIN

	DELETE FROM tbl_tramite_tipo_dato_trtd
	WHERE EXISTS (
		SELECT 1 FROM tbl_tramite_trmt
		WHERE trmt_pk = trtd_trmt_pk
			AND trmt_enti_pk = entiId
	)
	;

	DELETE FROM tbl_i18n_i18n
	WHERE i18n_pref = 'trmt'
	    AND EXISTS (
	        SELECT 1 FROM tbl_tramite_trmt
	        WHERE trmt_pk = i18n_ext_pk
	            AND trmt_enti_pk = entiId
	    )
	;

	FOR item IN (
		SELECT fncd_pk FROM tbl_funcionalidad_fncd
		WHERE EXISTS (
			SELECT 1 FROM tbl_accion_entidad_acen
			WHERE acen_pk = fncd_pk
				AND acen_enti_pk = entiId
		)
	)
	LOOP
		DELETE FROM tbl_funcionalidad_grupo_fngr WHERE fngr_fncd_pk = item.fncd_pk;
		DELETE FROM tbl_accion_entidad_acen WHERE acen_pk = item.fncd_pk;
		DELETE FROM tbl_funcionalidad_fncd WHERE fncd_pk = item.fncd_pk;
	END LOOP;

	FOR item IN (
		SELECT fncd_pk FROM tbl_funcionalidad_fncd
		WHERE EXISTS (
			SELECT 1 FROM tbl_accion_especial_aces
			WHERE aces_pk = fncd_pk
				AND aces_enti_pk = entiId
		)
	)
	LOOP
		DELETE FROM tbl_funcionalidad_grupo_fngr WHERE fngr_fncd_pk = item.fncd_pk;
		DELETE FROM tbl_accion_especial_aces WHERE aces_pk = item.fncd_pk;
		DELETE FROM tbl_funcionalidad_fncd WHERE fncd_pk = item.fncd_pk;
	END LOOP;

	FOR item IN (
		SELECT fncd_pk FROM tbl_funcionalidad_fncd
		WHERE EXISTS (
			SELECT 1 FROM tbl_tramite_trmt
			WHERE trmt_pk = fncd_pk
				AND trmt_enti_pk = entiId
		)
	)
	LOOP
		DELETE FROM tbl_funcionalidad_grupo_fngr WHERE fngr_fncd_pk = item.fncd_pk;
		DELETE FROM tbl_tramite_trmt WHERE trmt_pk = item.fncd_pk;
		DELETE FROM tbl_funcionalidad_fncd WHERE fncd_pk = item.fncd_pk;
	END LOOP;

	DELETE FROM tbl_entidad_entidad_enen
	WHERE enen_entih_pk = entiId
	;
	DELETE FROM tbl_entidad_entidad_enen
	WHERE enen_entip_pk = entiId
	;

	DELETE FROM tbl_i18n_i18n
	WHERE i18n_pref = 'entd'
	    AND EXISTS (
	        SELECT 1 FROM tbl_entidad_tipo_dato_entd
	        WHERE entd_pk = i18n_ext_pk
	            AND entd_enti_pk = entiId
	    )
	;
	DELETE FROM tbl_entidad_tipo_dato_entd WHERE entd_enti_pk = entiId
	;

	DELETE FROM tbl_i18n_i18n
	WHERE i18n_pref = 'engd'
	    AND EXISTS (
	        SELECT 1 FROM tbl_entidad_grupo_dato_engd
	        WHERE engd_pk = i18n_ext_pk
	            AND engd_enti_pk = entiId
	    )
	;
	DELETE FROM tbl_entidad_grupo_dato_engd WHERE engd_enti_pk = entiId
	;

	DELETE FROM tbl_i18n_i18n
	WHERE i18n_pref = 'tpdt'
	    AND EXISTS (
	        SELECT 1 FROM tbl_tipo_dato_tpdt
	        WHERE tpdt_pk = i18n_ext_pk
	            AND tpdt_enti_pk = entiId
	    )
	;
	DELETE FROM tbl_tipo_dato_tpdt WHERE tpdt_enti_pk = entiId
	;

	DELETE FROM tbl_i18n_i18n
	WHERE i18n_pref = 'enti'
	    AND EXISTS (
	        SELECT 1 FROM tbl_entidad_enti
	        WHERE enti_pk = i18n_ext_pk
	            AND enti_pk = entiId
	    )
	;

	DELETE FROM tbl_entidad_enti WHERE enti_pk = entiId
	;
END;
\





CREATE OR REPLACE PROCEDURE eraseTpsp(entiId NUMBER) IS
BEGIN
	DELETE FROM tbl_subparametro_dato_spdt
	WHERE
	    EXISTS (
	        SELECT 1 FROM tbl_subparametro_version_spvr
	        WHERE spvr_pk = spdt_spvr_pk
	            AND EXISTS (
	                SELECT 1 FROM tbl_subparametro_sprm
	                WHERE sprm_pk = spvr_sprm_pk
	                    AND sprm_tpsp_pk = entiId
	            )
	    )
	;

	DELETE FROM tbl_subparametro_version_spvr
	WHERE
	    EXISTS (
	        SELECT 1 FROM tbl_subparametro_sprm
	        WHERE sprm_pk = spvr_sprm_pk
	            AND sprm_tpsp_pk = entiId
	    )
	;

	DELETE FROM tbl_subparametro_sprm
	WHERE sprm_tpsp_pk = entiId
	;

	DELETE FROM tbl_tipo_subparametro_tpsp WHERE tpsp_pk = entiId
	;

	eraseEnti(entiId);
END;
\



CREATE OR REPLACE PROCEDURE eraseTppr(entiId NUMBER) IS
BEGIN
	DELETE FROM tbl_item_trmt_dato_ittd
	WHERE
		EXISTS (
			SELECT 1 FROM tbl_item_tramite_ittr
			WHERE
				ittr_pk = ittd_ittr_pk
				AND EXISTS (
					SELECT 1 FROM tbl_parametro_prmt
					WHERE prmt_pk = ittr_item_pk
						AND prmt_tppr_pk = entiId
				)
		)
	;
	DELETE FROM tbl_parametro_trmt_prtr
	WHERE
		EXISTS (
			SELECT 1 FROM tbl_parametro_prmt
			WHERE prmt_pk = prtr_prmt_pk
				AND prmt_tppr_pk = entiId
		)
	;
	DELETE FROM tbl_item_tramite_ittr
	WHERE
		EXISTS (
			SELECT 1 FROM tbl_parametro_prmt
			WHERE prmt_pk = ittr_item_pk
				AND prmt_tppr_pk = entiId
		)
	;

	DELETE FROM tbl_i18n_i18n
	WHERE i18n_pref = 'prvr'
	    AND EXISTS (
	        SELECT 1 FROM tbl_parametro_version_prvr
	        WHERE prvr_pk = i18n_ext_pk
	            AND EXISTS (
	                SELECT 1 FROM tbl_parametro_prmt
	                WHERE
	                    prmt_pk = prvr_prmt_pk
	                    AND prmt_tppr_pk = entiId
	            )
	    )
	;

	DELETE FROM tbl_parametro_version_prvr
	WHERE
	    EXISTS (
	        SELECT 1 FROM tbl_parametro_prmt
	        WHERE
	            prmt_pk = prvr_prmt_pk
	            AND prmt_tppr_pk = entiId
	    )
	;

    DELETE FROM tbl_parametro_prmt
    WHERE prmt_tppr_pk = entiId
	;

	DELETE FROM tbl_tipo_parametro_tppr WHERE tppr_pk = entiId
	;

	eraseEnti(entiId);
END;
\




CREATE OR REPLACE PROCEDURE eraseTpss(entiId NUMBER) IS
BEGIN
	DELETE FROM tbl_item_trmt_dato_ittd
	WHERE
		EXISTS (
			SELECT 1 FROM tbl_item_tramite_ittr
			WHERE
				ittr_pk = ittd_ittr_pk
				AND EXISTS (
					SELECT 1 FROM tbl_subservicio_ssrv
					WHERE ssrv_pk = ittr_item_pk
						AND ssrv_tpss_pk = entiId
				)
		)
	;
	DELETE FROM tbl_subservicio_trmt_sstr
	WHERE
		EXISTS (
			SELECT 1 FROM tbl_subservicio_ssrv
			WHERE ssrv_pk = sstr_ssrv_pk
				AND ssrv_tpss_pk = entiId
		)
	;
	DELETE FROM tbl_item_tramite_ittr
	WHERE
		EXISTS (
			SELECT 1 FROM tbl_subservicio_ssrv
			WHERE ssrv_pk = ittr_item_pk
				AND ssrv_tpss_pk = entiId
		)
	;

	DELETE FROM tbl_subserv_subserv_ssss
	WHERE
    	EXISTS (
        	SELECT 1
        	FROM tbl_subservicio_ssrv
        	WHERE ssrv_pk = ssss_ssrvh_pk
            	AND ssrv_tpss_pk = entiId
    	)
	;
	DELETE FROM tbl_subserv_subserv_ssss
	WHERE
		EXISTS (
	    	SELECT 1
			FROM tbl_subservicio_ssrv
			WHERE ssrv_pk = ssss_ssrvp_pk
				AND ssrv_tpss_pk = entiId
		)
	;

	DELETE FROM tbl_subservicio_dato_ssdt
	WHERE
	    EXISTS (
          SELECT 1 FROM tbl_subservicio_ssrv
          WHERE ssrv_pk = ssdt_ssrv_pk
              AND ssrv_tpss_pk = entiId
	    )
	;

	DELETE FROM tbl_subservicio_ssrv
	WHERE ssrv_tpss_pk = entiId
	;

	DELETE FROM tbl_tipo_subservicio_tpss WHERE tpss_pk = entiId
	;

	eraseEnti(entiId);
END;
\




CREATE OR REPLACE PROCEDURE eraseTpsr(entiId NUMBER) IS
BEGIN
	DELETE FROM tbl_item_trmt_dato_ittd
	WHERE
		EXISTS (
			SELECT 1 FROM tbl_item_tramite_ittr
			WHERE
				ittr_pk = ittd_ittr_pk
				AND EXISTS (
					SELECT 1 FROM tbl_servicio_srvc
					WHERE srvc_pk = ittr_item_pk
						AND srvc_tpsr_pk = entiId
				)
		)
	;
	DELETE FROM tbl_servicio_trmt_srtr
	WHERE
		EXISTS (
			SELECT 1 FROM tbl_servicio_srvc
			WHERE srvc_pk = srtr_srvc_pk
				AND srvc_tpsr_pk = entiId
		)
	;
	DELETE FROM tbl_item_tramite_ittr
	WHERE
		EXISTS (
			SELECT 1 FROM tbl_servicio_srvc
			WHERE srvc_pk = ittr_item_pk
				AND srvc_tpsr_pk = entiId
		)
	;

	DELETE FROM tbl_servicio_dato_srdt
	WHERE
	    EXISTS (
          SELECT 1 FROM tbl_servicio_srvc
          WHERE srvc_pk = srdt_srvc_pk
              AND srvc_tpsr_pk = entiId
	    )
	;

	DELETE FROM tbl_servicio_actor_srac
	WHERE
	    EXISTS (
          SELECT 1 FROM tbl_servicio_srvc
          WHERE srvc_pk = srac_srvc_pk
              AND srvc_tpsr_pk = entiId
	    )
	;

	DELETE FROM tbl_servicio_srvc
	WHERE srvc_tpsr_pk = entiId
	;

	DELETE FROM tbl_servicio_secuencia_srsc
	WHERE srsc_tpsr_pk = entiId
	;

	DELETE FROM tbl_tipo_servicio_tpsr WHERE tpsr_pk = entiId
	;

	eraseEnti(entiId);
END;
\




CREATE OR REPLACE PROCEDURE eraseTpes(entiId NUMBER) IS
BEGIN
	DELETE FROM tbl_estadistica_dato_esdt
	WHERE
	    EXISTS (
          SELECT 1 FROM tbl_estadistica_estd
          WHERE estd_pk = esdt_estd_pk
              AND estd_tpes_pk = entiId
	    )
	;

	DELETE FROM tbl_estadistica_estd
	WHERE estd_tpes_pk = entiId
	;

	DELETE FROM tbl_campo_agregacion_cmag WHERE cmag_tpes_pk = entiId
	;

	DELETE FROM tbl_tipo_estadistica_tpes WHERE tpes_pk = entiId
	;

	eraseEnti(entiId);
END;
\




CREATE OR REPLACE PROCEDURE eraseTpdt(tpdtId NUMBER) IS
BEGIN
	DELETE FROM tbl_i18n_i18n
	WHERE i18n_pref = 'cdrf'
	    AND EXISTS (
	        SELECT 1 FROM tbl_codigo_ref_cdrf
	        WHERE cdrf_pk = i18n_ext_pk
	            AND cdrf_tpdt_pk = tpdtId
	    )
	;
	DELETE FROM tbl_codigo_ref_cdrf
	WHERE
	    cdrf_tpdt_pk = tpdtId
	;

	DELETE FROM tbl_i18n_i18n
	WHERE i18n_pref = 'tpdt'
	    AND i18n_ext_pk = tpdtId
	;
	DELETE FROM tbl_tipo_dato_tpdt WHERE tpdt_pk = tpdtId
	;
END;
\

CREATE OR REPLACE PROCEDURE eraseCrgo(crgoId NUMBER) IS
BEGIN
	DELETE FROM tbl_regla_inc_version_rgiv
	WHERE EXISTS (
		SELECT 1 FROM tbl_regla_inc_rgin
		WHERE rgin_pk = rgiv_rgin_pk
			AND EXISTS (
				SELECT 1 FROM tbl_regla_rgla
				WHERE rgla_pk = rgin_rgla1_pk
					AND rgla_crgo_pk = crgoId
			)
	)
	;
	DELETE FROM tbl_regla_inc_rgin
	WHERE
		EXISTS (
			SELECT 1 FROM tbl_regla_rgla
			WHERE rgla_pk = rgin_rgla1_pk
				AND rgla_crgo_pk = crgoId
		)
	;
	DELETE FROM tbl_regla_inc_version_rgiv
	WHERE EXISTS (
		SELECT 1 FROM tbl_regla_inc_rgin
		WHERE rgin_pk = rgiv_rgin_pk
			AND EXISTS (
				SELECT 1 FROM tbl_regla_rgla
				WHERE rgla_pk = rgin_rgla2_pk
					AND rgla_crgo_pk = crgoId
			)
	)
	;
	DELETE FROM tbl_regla_inc_rgin
	WHERE
		EXISTS (
			SELECT 1 FROM tbl_regla_rgla
			WHERE rgla_pk = rgin_rgla2_pk
				AND rgla_crgo_pk = crgoId
		)
	;

  DELETE FROM tbl_i18n_i18n
  WHERE
      i18n_pref = 'rglv'
      AND EXISTS (
          SELECT 1 FROM tbl_regla_version_rglv
          WHERE rglv_pk = i18n_ext_pk
              AND EXISTS (
                  SELECT 1 FROM tbl_regla_rgla
                  WHERE rgla_pk = rglv_rgla_pk
                    AND rgla_crgo_pk = crgoId
              )
      )
  ;
	DELETE FROM tbl_regla_version_rglv
	WHERE EXISTS (
		SELECT 1 FROM tbl_regla_rgla
		WHERE rgla_pk = rglv_rgla_pk
			AND rgla_crgo_pk = crgoId
	)
	;
	DELETE FROM tbl_regla_rgla
	WHERE rgla_crgo_pk = crgoId
	;

	DELETE FROM tbl_cargo_dep_version_crdv
	WHERE EXISTS (
		SELECT 1 FROM tbl_cargo_dep_crdp
		WHERE crdp_pk = crdv_crdp_pk
			AND crdp_crgoh_pk = crgoId
	)
	;
	DELETE FROM tbl_cargo_dep_crdp
	WHERE crdp_crgoh_pk = crgoId
	;
	DELETE FROM tbl_cargo_dep_version_crdv
	WHERE EXISTS (
		SELECT 1 FROM tbl_cargo_dep_crdp
		WHERE crdp_pk = crdv_crdp_pk
			AND crdp_crgop_pk = crgoId
	)
	;
	DELETE FROM tbl_cargo_dep_crdp
	WHERE crdp_crgop_pk = crgoId
	;

	DELETE FROM tbl_i18n_i18n
	WHERE i18n_pref = 'crgv'
		AND EXISTS (
			SELECT 1 FROM tbl_cargo_version_crgv
			WHERE
				crgv_pk = i18n_ext_pk
				AND crgv_crgo_pk = crgoId
		)
	;
	DELETE FROM tbl_cargo_version_crgv
	WHERE crgv_crgo_pk = crgoId
	;
	DELETE FROM tbl_cargo_crgo
	WHERE crgo_pk = crgoId
	;

END;
\




CREATE OR REPLACE PROCEDURE eraseAspc(aspcId NUMBER) IS
BEGIN
	DELETE FROM tbl_aspecto_cargo_version_ascv
	WHERE EXISTS (
		SELECT 1 FROM tbl_aspecto_cargo_ascr
		WHERE ascr_pk = ascv_ascr_pk
			AND ascr_aspc_pk = aspcId
	)
	;
	DELETE FROM tbl_aspecto_cargo_ascr
	WHERE ascr_aspc_pk = aspcId
	;

	DELETE FROM tbl_i18n_i18n
	WHERE i18n_pref = 'aspv'
		AND EXISTS (
			SELECT 1 FROM tbl_aspecto_version_aspv
			WHERE
				aspv_pk = i18n_ext_pk
				AND aspv_aspc_pk = aspcId
		)
	;
	DELETE FROM tbl_aspecto_version_aspv
	WHERE EXISTS (
		SELECT 1 FROM tbl_aspecto_aspc
		WHERE aspc_pk = aspv_aspc_pk
			AND aspc_pk = aspcId
	)
	;
	DELETE FROM tbl_aspecto_aspc
	WHERE aspc_pk = aspcId
	;
END;
\



-- //@UNDO
-- SQL to undo the change goes here.

DROP PROCEDURE eraseAspc\
DROP PROCEDURE eraseCrgo\
DROP PROCEDURE eraseTpdt\
DROP PROCEDURE eraseTpes\
DROP PROCEDURE eraseTpsr\
DROP PROCEDURE eraseTpss\
DROP PROCEDURE eraseTppr\
DROP PROCEDURE eraseTpsp\
DROP PROCEDURE eraseEnti\
DROP FUNCTION daysBetween\
DROP FUNCTION concatenate\
DROP FUNCTION getTipoDato\
DROP FUNCTION getEntidad\
DROP FUNCTION getSysDatetime\

