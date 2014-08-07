
SELECT * FROM tbl_entidad_enti
ORDER BY enti_codigo;

SELECT * 
FROM tbl_servicio_cargo_srcr
;

SELECT * 
FROM tbl_cargo_crgo
;



-- Vista de situacion
SELECT * 
FROM 
	tbl_servicio_srvc
	JOIN tbl_cargo_crgo ON
		crgo_tpsr_pk = srvc_tpsr_pk
	JOIN tbl_cargo_version_crgv ON
		crgv_crgo_pk = crgo_pk
		AND srvc_fref BETWEEN crgv_fini AND COALESCE(crgv_ffin, srvc_fref)
;




-- GENERAR B0 ESCALA

-- 1 vez por servicio maximo
-- 3 veces por año y buque
WITH sql AS (
	SELECT srvc_pk, srvc_tpsr_pk, srvc_subp_pk
		, (
			SELECT srdt_prmt_pk
			FROM tbl_servicio_dato_srdt
			WHERE srdt_srvc_pk = srvc_pk
				AND srdt_tpdt_pk = portico.getTipoDato('BUQUE')
		) AS buque
		, (
			SELECT COUNT(1)
			FROM tbl_servicio_cargo_srcr
			WHERE srcr_srvc_pk = srvc_pk
				AND (
					srcr_vlrc_pk IS NOT NULL
					OR srcr_fctr_pk IS NOT NULL
				)
				AND srcr_crgo_pk = ANY (
					SELECT crgo_pk
					FROM tbl_cargo_crgo
					WHERE 
						crgo_tpsr_pk = srvc_tpsr_pk
						AND crgo_codigo_norm = 'BO'
				)
		) AS bo_liquidada
		, (
			SELECT COUNT(1)
			FROM tbl_servicio_srvc srvc2
			WHERE 
				srvc2.srvc_tpsr_pk = srvc.srvc_tpsr_pk
				AND srvc2.srvc_subp_pk = srvc.srvc_subp_pk
				AND srvc2.srvc_anno = srvc.srvc_anno
				AND EXISTS (
					SELECT srdt_prmt_pk
					FROM tbl_servicio_dato_srdt
					WHERE srdt_srvc_pk = srvc2.srvc_pk
						AND srdt_tpdt_pk = portico.getTipoDato('BUQUE')
						and srdt_prmt_pk = any(
							SELECT srdt_prmt_pk
							FROM tbl_servicio_dato_srdt
							WHERE srdt_srvc_pk = srvc.srvc_pk
								AND srdt_tpdt_pk = portico.getTipoDato('BUQUE')
						)
				)
				AND EXISTS (
					SELECT 1
					FROM tbl_servicio_cargo_srcr
					WHERE srcr_srvc_pk = srvc2.srvc_pk
						AND (
							srcr_vlrc_pk IS NOT NULL
							OR srcr_fctr_pk IS NOT NULL
						)
						AND srcr_crgo_pk = ANY (
							SELECT crgo_pk
							FROM tbl_cargo_crgo
							WHERE 
								crgo_tpsr_pk = srvc_tpsr_pk
								AND crgo_codigo_norm = 'BO'
						)
				)
		) AS bo_buque_anio_subp
	FROM tbl_servicio_srvc srvc
	WHERE 
		srvc_tpsr_pk = portico.getEntidad('ESCALA')
		AND srvc_pk = 1192001
)
SELECT *
FROM sql
WHERE 
	bo_liquidada = 0
	AND bo_buque_anio_subp < 3
;


-- EscalaEsAvituallamiento()
SELECT portico.escalaEsAvituallamiento(1593169, NOW());

-- EscalaValorContador(TipoContador)
SELECT portico.escalaValorContador(1593079, NOW(), 'ES');

-- EscalaEsBuqueCertificado(TipoCertificado)
SELECT portico.escalaEsBuqueCertificado(1593174, NOW(), '245');

-- EscalaEsBuqueBaseEnPuerto()
SELECT portico.escalaEsBuqueBaseEnPuerto(1229010, NOW());

-- escalaNumeroPuertosBuque
SELECT portico.escalaNumeroPuertosBuque(1229010, NOW());








SELECT *
FROM tbl_entidad_enti
ORDER BY enti_codigo
;

select *
from tbl_parametro_prmt
WHERE prmt_tppr_pk = portico.getEntidad('TIPO_CERTIFICADO')
;

SELECT *
FROM 
	tbl_entidad_tipo_dato_entd
	JOIN tbl_entidad_enti ON
		enti_pk = entd_enti_pk
	JOIN tbl_tipo_dato_tpdt ON
		tpdt_pk = entd_tpdt_pk
WHERE entd_enti_pk = portico.getEntidad('ESCALA')		
order by entd_grupo, entd_fila, entd_orden
;

SELECT *
FROM tbl_servicio_srvc
WHERE 
	srvc_tpsr_pk = portico.getEntidad('ESCALA')
	AND NOW() BETWEEN srvc_fini AND COALESCE(srvc_ffin, NOW())
	AND EXISTS (
		SELECT 1
		FROM tbl_servicio_dato_srdt 
		WHERE srdt_srvc_pk = srvc_pk
			AND srdt_tpdt_pk = portico.getTipoDato('AMARRE_DEP')
	)
;

