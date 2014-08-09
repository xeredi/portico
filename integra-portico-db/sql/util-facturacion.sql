SELECT * 
FROM tbl_servicio_srvc 
	JOIN tbl_entidad_enti ON
		enti_pk = srvc_tpsr_pk;

-- 1192001, 1192002, 1192003
-- Contar tipos de servicio
SELECT COUNT(DISTINCT srvc_tpsr_pk)
FROM tbl_servicio_srvc 
WHERE srvc_pk IN (1192001, 1192002, 1192003);


-- Tasas propuestas para un servicio
SELECT *
FROM tbl_cargo_crgo
WHERE 
	EXISTS (
		SELECT 1
		FROM tbl_servicio_srvc
		WHERE srvc_tpsr_pk = crgo_tpsr_pk
			AND srvc_pk = 1192001
	)
	AND NOT EXISTS (
		SELECT 1
		FROM tbl_cargo_composicion_crcm
		WHERE crcm_crgo_hijo_pk = crgo_pk
	)
;

-- Tasas a Valorar
SELECT * 
FROM
	tbl_cargo_crgo
WHERE crgo_pk IN (1004)
	OR EXISTS (
		SELECT 1
		FROM tbl_cargo_composicion_crcm
		WHERE crcm_crgo_hijo_pk = crgo_pk
			AND crcm_crgo_padre_pk IN (1004)
	)
;

-- Procedimientos de una tasa
SELECT * 
FROM tbl_procedimiento_prcd 
WHERE 
	prcd_crgo_pk IN (1004)
;









-- Valorar manifiesto
select prmt_tppr_pk, enti_nombre, count(1)
from 
	tbl_parametro_prmt
	join tbl_entidad_enti on
		enti_pk = prmt_tppr_pk
group by prmt_tppr_pk, enti_nombre
order by enti_nombre
;

select srvc_tpsr_pk, enti_nombre, count(1)
from 
	tbl_servicio_srvc
	join tbl_entidad_enti on
		enti_pk = srvc_tpsr_pk
group by srvc_tpsr_pk, enti_nombre
;

select ssrv_tpss_pk, enti_nombre, count(1)
from 
	tbl_subservicio_ssrv
	join tbl_entidad_enti on
		enti_pk = ssrv_tpss_pk
where ssrv_srvc_pk = 1192567
group by ssrv_tpss_pk, enti_nombre
;

select * 
from 
	portico.tbl_servicio_srvc
	join portico.tbl_entidad_enti on
		enti_pk = srvc_tpsr_pk
where srvc_pk = 1192567
;



SELECT *
FROM
	portico.tbl_entidad_tipo_dato_entd
	JOIN portico.tbl_tipo_dato_tpdt ON
		tpdt_pk = entd_tpdt_pk
WHERE 
	entd_enti_pk = portico.getEntidad('TIPO_IVA')
--	AND entd_tpdt_pk = portico.getTipoDato('BOOLEANO_02')
;







SELECT * FROM tbl_entidad_enti
ORDER BY enti_codigo
;

SELECT * 
FROM 
	tbl_entidad_tipo_dato_entd
	JOIN tbl_tipo_dato_tpdt ON
		tpdt_pk = entd_tpdt_pk
WHERE entd_enti_pk = 20014
;

SELECT * FROM portico.tbl_tipo_dato_tpdt
order by tpdt_codigo
;




--0		FACT/EST	Facturable y Estadística
--1		FACT/NO EST	Facturable y No Estadística
--2		NO FACT/EST	No Facturable y Si Estadística
--3		NO FACT/NO EST	No Facturable y No Estadística
--4		SIN REVISAR	Sin revisar

SELECT * FROM tbl_proceso_batch_prbt;

SELECT * FROM tbl_valoracion_tmp_vlrt;
SELECT * FROM vw_valoracion_vlrc;
SELECT * FROM vw_valoracion_lin_vlrl;
SELECT * FROM tbl_valoracion_vlrc;
SELECT * FROM tbl_valoracion_cargo_vlrg;
SELECT * FROM tbl_valoracion_imp_vlri;
SELECT * FROM tbl_valoracion_lin_vlrl;
SELECT * FROM tbl_valoracion_det_vlrd;

SELECT * FROM tbl_cargo_crgo;
SELECT * FROM tbl_regla_rgla;



SELECT * FROM tbl_parametro_prmt
WHERE prmt_pk = 1007029;


DELETE FROM tbl_valoracion_tmp_vlrt;
DELETE FROM tbl_valoracion_det_vlrd;
DELETE FROM tbl_valoracion_lin_vlrl;
DELETE FROM tbl_valoracion_imp_vlri;
DELETE FROM tbl_valoracion_cargo_vlrg;
DELETE FROM tbl_valoracion_vlrc;

select ssrv_srvc_pk, count(1)
from 
	portico.tbl_subservicio_ssrv
group by ssrv_srvc_pk
;

SELECT *
FROM tbl_servicio_srvc
WHERE
	srvc_tpsr_pk = portico.getEntidad('ESCALA')
	and SRVC_ESTADO in ('I', 'F')
;

SELECT *
FROM tbl_servicio_srvc
WHERE
	srvc_tpsr_pk = portico.getEntidad('MANIFIESTO')
;

SELECT *
FROM tbl_subservicio_ssrv
WHERE
	EXISTS (
		SELECT 1
		FROM tbl_servicio_srvc
		WHERE
			srvc_pk = ssrv_srvc_pk
			AND srvc_tpsr_pk = portico.getEntidad('ESCALA')
			and SRVC_ESTADO in ('I', 'F')
	)
;


SELECT * FROM tbl_subservicio_ssrv WHERE ssrv_srvc_pk = 1209891;







    SELECT
        #{prbt.id} AS vlrt_prbt_pk
        , srvc_pk AS vlrt_srvc_pk
        , ssrv_pk AS vlrt_ssrv_pk
        , rgla_crgo_pk AS vlrt_crgo_pk
        , rgla_pk AS vlrt_rgla_pk
        , rgla_pk AS vlrt_rgla_padre_pk
        , ssrv_numero AS vlrt_orden
        , (SELECT rglv_importe_base FROM tbl_regla_version_rglv WHERE rglv_pk = #{rgla.rglv.id}) AS vlrt_valor_base
        , 0 AS vlrt_importe_base
        , (${rgla.rglv.formulaSql}) AS vlrt_importe
/*
    ]]>

    <if test="rgla.rglv.pathCuant1Sql != null">
        , (${rgla.rglv.pathCuant1Sql}) AS vlrt_cuant1
    </if>
    <if test="rgla.rglv.pathCuant2Sql != null">
        , (${rgla.rglv.pathCuant2Sql}) AS vlrt_cuant2
    </if>
    <if test="rgla.rglv.pathCuant3Sql != null">
        , (${rgla.rglv.pathCuant3Sql}) AS vlrt_cuant3
    </if>
    <if test="rgla.rglv.pathCuant4Sql != null">
        , (${rgla.rglv.pathCuant4Sql}) AS vlrt_cuant4
    </if>
    <if test="rgla.rglv.pathCuant5Sql != null">
        , (${rgla.rglv.pathCuant5Sql}) AS vlrt_cuant5
    </if>
    <if test="rgla.rglv.pathCuant6Sql != null">
        , (${rgla.rglv.pathCuant6Sql}) AS vlrt_cuant6
    </if>

    <if test="rgla.rglv.pathInfo1Sql != null">
        , (${rgla.rglv.pathInfo1Sql}) AS vlrt_info1
    </if>
    <if test="rgla.rglv.pathInfo2Sql != null">
        , (${rgla.rglv.pathInfo2Sql}) AS vlrt_info2
    </if>
    <if test="rgla.rglv.pathInfo3Sql != null">
        , (${rgla.rglv.pathInfo3Sql}) AS vlrt_info3
    </if>
    <if test="rgla.rglv.pathInfo4Sql != null">
        , (${rgla.rglv.pathInfo4Sql}) AS vlrt_info4
    </if>
    <if test="rgla.rglv.pathInfo5Sql != null">
        , (${rgla.rglv.pathInfo5Sql}) AS vlrt_info5
    </if>
    <if test="rgla.rglv.pathInfo6Sql != null">
        , (${rgla.rglv.pathInfo6Sql}) AS vlrt_info6
    </if>

    <if test="rgla.rglv.pathImpuestoSql != null">
        , (${rgla.rglv.pathImpuestoSql}) AS vlrt_impuesto_pk
    </if>
    <if test="rgla.rglv.pathEsSujPasivoSql != null">
        , (${rgla.rglv.pathEsSujPasivoSql}) AS vlrt_es_suj_pasivo
    </if>
    <if test="rgla.rglv.pathPagadorSql != null">
        , (${rgla.rglv.pathPagadorSql}) AS vlrt_pagador_pk
    </if>
    <if test="rgla.rglv.pathCodExenSql != null">
        , (${rgla.rglv.pathCodExenSql}) AS vlrt_cod_exen
    </if>

    <![CDATA[
*/
    FROM (
        SELECT item.*, rgla.*, srvc.*, srvc_fref AS fref
        FROM
            portico.tbl_subservicio_ssrv item
            JOIN portico.tbl_servicio_srvc srvc ON
                srvc_pk = ssrv_srvc_pk
            JOIN portico.tbl_tipo_subservicio_tpss tpss ON
                tpss_pk = ssrv_tpss_pk
            JOIN portico.tbl_tipo_servicio_tpsr tpsr ON
                tpsr_pk = srvc_tpsr_pk
            JOIN portico.tbl_regla_rgla rgla ON
                rgla_enti_pk = ssrv_tpss_pk
                AND rgla_pk = #{rgla.id}
        WHERE
            tpsr_es_facturable = 1
            AND tpss_es_facturable = 1
            AND (
                tpss_tpdt_estado_pk IS NULL
                OR (
                    (
                        tpss_pk = portico.getEntidad('PARTIDA')
                        AND ssrv_estado = 'R'
                        AND (
                            -- Regimen simplificado
                            EXISTS (
                                SELECT 1
                                FROM portico.tbl_subservicio_dato_ssdt
                                WHERE

                                    EXISTS (
                                        SELECT 1
                                        FROM portico.tbl_subservicio_ssrv
                                        WHERE
                                            ssrv_pk = ssdt_ssrv_pk
                                            AND ssrv_tpss_pk = portico.getEntidad('BL')
                                    )
                                    AND EXISTS (
                                        SELECT 1
                                        FROM portico.tbl_subserv_subserv_ssss
                                        WHERE
                                            ssss_ssrvp_pk = ssdt_ssrv_pk
                                            AND ssss_ssrvh_pk = item.ssrv_pk
                                    )
                                    AND (
                                        (ssdt_tpdt_pk = portico.getTipoDato('BOOLEANO_02') AND ssdt_nentero = 0)
                                        or (ssdt_tpdt_pk = portico.getTipoDato('TIPO_BL') AND ssdt_cadena = 'P')
                                    )
                            )
                            or (
                                EXISTS (
                                    SELECT 1
                                    FROM
                                        portico.tbl_parametro_dato_prdt
                                    WHERE
                                        prdt_tpdt_pk = portico.getTipoDato('BOOLEANO_01')
                                        AND EXISTS (
                                            SELECT 1
                                            FROM portico.tbl_parametro_version_prvr
                                            WHERE
                                                prvr_pk = prdt_prvr_pk
                                                AND srvc_fref BETWEEN prvr_fini AND COALESCE(prvr_ffin, srvc_fref)
                                                AND EXISTS (
                                                    SELECT 1
                                                    FROM portico.tbl_subservicio_dato_ssdt
                                                    WHERE
                                                        ssdt_prmt_pk = prvr_prmt_pk
                                                        AND ssdt_tpdt_pk = portico.getTipoDato('MERCANCIA')
                                                        AND ssdt_ssrv_pk = item.ssrv_pk
                                                )
                                        )
                                        AND prdt_nentero = 1
                                        -- TODO Falta ver que la mercancia de la unidad de carga sea nula
                                )
                            )
                        )
                    )

                    OR (tpss_pk = portico.getEntidad('EQUIPAMIENTO') AND ssrv_estado = 'R')

                    OR (tpss_pk = portico.getEntidad('PARTIDA_PESCA') AND ssrv_estado = 'R')

                    OR (tpss_pk = portico.getEntidad('ATRAQUE') AND ssrv_estado IN ('I', 'F'))
                )
            )
            AND (
                tpss_es_exencionable = 0
                OR EXISTS (
                    SELECT 1
                    FROM portico.tbl_subservicio_dato_ssdt
                    WHERE ssdt_ssrv_pk = ssrv_pk
                        AND ssdt_tpdt_pk = portico.getTipoDato('COD_EXEN')
                        AND ssdt_cadena IN ('0', '1')
                )
            )
            AND (
                tpsr_es_exencionable = 0
                OR EXISTS (
                    SELECT 1
                    FROM portico.tbl_servicio_dato_srdt
                    WHERE srdt_srvc_pk = srvc_pk
                        AND srdt_tpdt_pk = portico.getTipoDato('COD_EXEN')
                        AND srdt_cadena IN ('0', '1')
                )
            )
/*
    ]]>
    <if test="rgla.rglv.condicionSql != null">
    <![CDATA[
            AND (${rgla.rglv.condicionSql})
    ]]>
    </if>
    <![CDATA[
*/
            AND (
                (
                    rgla_tipo = 'T'
                    AND NOT EXISTS (
                        SELECT 1
                        FROM portico.tbl_servicio_cargo_srcr
                        WHERE
                            srcr_srvc_pk = srvc_pk
                            AND srcr_ssrv_pk = ssrv_pk
                            AND srcr_crgo_pk = rgla_crgo_pk
                            AND (srcr_vlrc_pk IS NOT NULL OR srcr_fctr_pk IS NOT NULL)
                    )
                    -- TODO Ojo lo de temporalidad
                )
                OR (
                    rgla_tipo IN ('C', 'D')
                    AND EXISTS (
                        SELECT 1
                        FROM
                            portico.tbl_valoracion_tmp_vlrt
                        WHERE
                            vlrt_prbt_pk = #{prbt.id}
                            AND vlrt_srvc_pk = srvc_pk
                            AND vlrt_ssrv_pk = ssrv_pk
                            AND vlrt_crgo_pk = rgla_crgo_pk
                            AND vlrt_rgla_pk = ANY(
                                SELECT rgla_pk
                                FROM portico.tbl_regla_rgla
                                WHERE
                                    rgla_crgo_pk = vlrt_crgo_pk
                                    AND rgla_tipo = 'T'
                            )
                    )
                )
            )

            AND ssrv_srvc_pk = #{srvc.id}
    ) item
    ORDER BY ssrv_srvc_pk, ssrv_tpss_pk, ssrv_numero
;







SELECT *
FROM tbl_subservicio_ssrv item
	JOIN tbl_regla_rgla ON
                rgla_enti_pk = ssrv_tpss_pk
                AND rgla_pk = 63001
WHERE 
	ssrv_srvc_pk = 1229570
	
;
