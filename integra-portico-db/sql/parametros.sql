SELECT COUNT(1) FROM tbl_parametro_dato_prdt;
SELECT COUNT(1) FROM tbl_parametro_i18n_p18n p18n;
SELECT COUNT(1) FROM tbl_parametro_version_prvr prvr;
SELECT COUNT(1) FROM tbl_parametro_prmt prmt;

-- Tipos de dato sin entidad asociada
SELECT * FROM tbl_tipo_dato_tpdt;
SELECT * FROM tbl_entidad_tipo_dato_entd;

SELECT *
FROM tbl_tipo_dato_tpdt
WHERE NOT EXISTS (
	SELECT 1
	FROM tbl_entidad_tipo_dato_entd
	WHERE entd_tpdt_pk = tpdt_pk
)
ORDER BY tpdt_pk
;


-- Busqueda de parametros en map codigo-id
SELECT prmt_parametro AS KEY, PRMT_PK AS value
FROM tbl_parametro_prmt
WHERE prmt_tppr_pk = 20049
	AND prmt_parametro in ('8608', '8605', '8604', '8603')
	and exists (
		select 1 from tbl_parametro_version_prvr
		WHERE prvr_prmt_pk = prmt_pk
			AND NOW() BETWEEN prvr_fini AND COALESCE(prvr_ffin, NOW())
	)
LIMIT 100
;


-- Tipos de parametro sin datos asociados
SELECT *
FROM
	tbl_tipo_parametro_tppr tppr
	JOIN  tbl_entidad_enti enti ON
		enti.enti_pk = tppr.tppr_pk
WHERE
	NOT EXISTS (
		SELECT 1
		FROM tbl_entidad_tipo_dato_entd entd
		WHERE entd.entd_enti_pk = tppr.tppr_pk
	)
ORDER BY enti.enti_nombre
;

-- Tipos de parametro sin maestros asociados
				SELECT *
				FROM tbl_tipo_dato_tpdt tpdt;

SELECT *
FROM
	tbl_tipo_parametro_tppr tppr
	JOIN  tbl_entidad_enti enti ON
		enti.enti_pk = tppr.tppr_pk
WHERE
	EXISTS (
		SELECT 1
		FROM tbl_entidad_tipo_dato_entd entd
		WHERE entd.entd_enti_pk = tppr.tppr_pk
			AND NOT EXISTS (
				SELECT 1
				FROM tbl_tipo_dato_tpdt tpdt
				WHERE
					tpdt.tpdt_pk = entd.entd_tpdt_pk
					AND tpdt.tpdt_tppr_pk IS NOT NULL
			)
	)
ORDER BY enti.enti_nombre
;



-- Entidades de Tipo Maestro
SELECT *
FROM
	tbl_tipo_parametro_tppr tppr
	JOIN tbl_entidad_enti enti ON
		enti.enti_pk = tppr.tppr_pk
order by enti_nombre
;

-- Parametros de un tipo
SELECT * FROM tbl_parametro_prmt prmt;

SELECT *
FROM
	tbl_parametro_prmt prmt
	JOIN tbl_parametro_version_prvr prvr ON
		prvr.prvr_prmt_pk = prmt.prmt_pk
WHERE
	prmt.prmt_tppr_pk = 20049
;

-- Datos de parametros
SELECT *
FROM
	tbl_parametro_prmt prmt
	JOIN tbl_parametro_version_prvr prvr ON
		prvr.prvr_prmt_pk = prmt.prmt_pk
WHERE 1=1
/*
	AND EXISTS (
		SELECT 1
		FROM tbl_parametro_dato_prdt prdt
		WHERE prdt.prdt_prvr_pk = prvr.prvr_pk
			AND prdt.prdt_tpdt_pk = 40045
			AND prdt.prdt_prmt_pk = 1000001512
	)
*/
	AND EXISTS (
		SELECT 1
		FROM tbl_parametro_dato_prdt prdt
		WHERE prdt.prdt_prvr_pk = prvr.prvr_pk
			AND prdt.prdt_tpdt_pk = 40043
			AND prdt.prdt_prmt_pk = 1000000218
	)
	AND prmt.prmt_tppr_pk = 20049
;

SELECT * FROM tbl_parametro_dato_prdt prdt;

SELECT *
FROM
	tbl_parametro_dato_prdt prdt
WHERE EXISTS (
	SELECT 1
	FROM
		tbl_parametro_prmt prmt
		JOIN tbl_parametro_version_prvr prvr ON
			prvr.prvr_prmt_pk = prmt.prmt_pk
	WHERE
		prvr.prvr_pk = prdt.prdt_prvr_pk
		AND prmt.prmt_tppr_pk = 20049
)
;

-- Veriones de un parametro
SELECT * FROM tbl_parametro_prmt prmt;
SELECT * FROM tbl_parametro_version_prvr prvr;

SELECT *
FROM
	tbl_parametro_prmt prmt
	JOIN tbl_parametro_version_prvr prvr ON
		prvr.prvr_prmt_pk = prmt.prmt_pk
ORDER BY prmt.prmt_pk, prvr.prvr_fini;

SELECT prmt_pk
FROM
	tbl_parametro_prmt prmt
WHERE
	prmt_tppr_pk IN (20004)
	AND prmt_parametro = 'DE'
	AND EXISTS (
		SELECT 1
		FROM tbl_parametro_version_prvr prvr
		WHERE
			prvr.prvr_prmt_pk = prmt.prmt_pk
			AND NOW() BETWEEN prvr.prvr_fini AND COALESCE(prvr.prvr_ffin, NOW())
	)
;

-- LabelValues
SELECT
	prmt_tppr_pk
	, prmt_pk AS value
	, CASE
		WHEN tppr_es_i18n = 1 THEN
			prmt_parametro || ' - ' || p18n_texto
		ELSE prmt_parametro
	END AS label
FROM
	tbl_parametro_prmt
	INNER JOIN tbl_parametro_version_prvr ON
		prvr_prmt_pk = prmt_pk
	INNER JOIN tbl_tipo_parametro_tppr ON
		tppr_pk = prmt_tppr_pk
	LEFT JOIN tbl_parametro_i18n_p18n ON
		p18n_prvr_pk = prvr_pk
		AND p18n_idioma = 'es_ES'
ORDER BY
	prmt_tppr_pk, label
;

-- Datos de un parametro
SELECT *
FROM
	tbl_parametro_dato_prdt prdt
	INNER JOIN tbl_parametro_version_prvr prvr ON
		prvr.prvr_pk = prdt.prdt_prvr_pk
ORDER BY
	prvr.prvr_prmt_pk, prvr.prvr_pk, prdt.prdt_tpdt_pk
;


-- Parametro y sus datos
SELECT * FROM tbl_tipo_parametro_tppr;
SELECT * FROM tbl_parametro_prmt;
SELECT * FROM tbl_parametro_version_prvr;
SELECT * FROM tbl_parametro_dato_prdt;
SELECT * FROM tbl_parametro_i18n_p18n;

SELECT *
FROM
	tbl_parametro_prmt prmt
	INNER JOIN tbl_parametro_version_prvr prvr ON
		prvr.prvr_prmt_pk = prmt.prmt_pk
		AND NOW() BETWEEN prvr.prvr_fini AND COALESCE(prvr.prvr_ffin, NOW())
	LEFT JOIN tbl_parametro_i18n_p18n p18n ON
		p18n.p18n_prvr_pk = prvr.prvr_pk
		AND p18n.p18n_idioma = 'es_ES'
	LEFT JOIN tbl_parametro_dato_prdt prdt ON
		prdt.prdt_prvr_pk = prvr.prvr_pk
WHERE
	1=1
	AND prmt.prmt_tppr_pk <> 20014
ORDER BY prmt.prmt_tppr_pk, prmt.prmt_parametro, prvr.prvr_pk
;


    SELECT
        prdt.prdt_prvr_pk, prdt.prdt_nentero, prdt.prdt_ndecimal, prdt.prdt_fecha
        , prdt.prdt_cadena, prdt.prdt_tpdt_pk, prdt.prdt_prmt_pk
        , prmtDato.prmt_parametro
    FROM tbl_parametro_dato_prdt prdt
        INNER JOIN tbl_parametro_version_prvr prvr ON
            prvr.prvr_pk = prdt.prdt_prvr_pk
        INNER JOIN tbl_parametro_prmt prmt ON
            prmt.prmt_pk = prvr.prvr_prmt_pk
        LEFT JOIN tbl_parametro_prmt prmtDato ON
            prmtDato.prmt_pk = prdt.prdt_prmt_pk
    WHERE prvr_pk = 1000000867
    ORDER BY prdt.prdt_prvr_pk
;


SELECT COALESCE(MAX(tppr_pk), 20000) + 1 as tppr_pk FROM tbl_tipo_parametro_tppr;


SELECT * FROM tbl_tipo_parametro_tipo_dato_tptd tptd;
SELECT * FROM tbl_tipo_dato_tpdt tpdt;
SELECT * FROM tbl_tipo_html_tpht tpht;
SELECT * FROM tbl_tipo_parametro_tppr tppr;
SELECT * FROM tbl_parametro_prmt prmt;
SELECT * FROM tbl_parametro_version_prvr prvr;

SELECT *
FROM
	tbl_tipo_parametro_tipo_dato_tptd tptd
	INNER JOIN tbl_tipo_dato_tpdt tpdt ON
		tpdt.tpdt_pk = tptd.tptd_tpdt_pk
	INNER JOIN tbl_tipo_html_tpht tpht ON
		tpht.tpht_pk = tpdt.tpdt_tpht_pk
	LEFT JOIN tbl_tipo_parametro_tppr tppr ON
		tppr.tppr_pk = tpdt.tpdt_tppr_pk
;


-- Codigos de Referencia
SELECT * FROM tbl_codigo_referencia_cdrf cdrf;






























SELECT *
FROM tbl_parametro_dato_prdt prdt
WHERE prdt.prdt_prmt_pk IS NOT NULL
LIMIT 1000
;

SELECT *
FROM tbl_parametro_version_prvr prvr
WHERE prvr_pk = 1000498157
LIMIT 1000
;

SELECT *
FROM tbl_parametro_i18n_p18n p18n
WHERE p18n.p18n_prvr_pk = 1000498157
LIMIT 1000
;

SELECT
	prdt.prdt_prvr_pk
	, prdt.prdt_tpdt_pk
	, prdt.prdt_nentero
	, prdt.prdt_ndecimal
	, prdt.prdt_fecha
	, prdt.prdt_cadena
	, prdt.prdt_prmt_pk

	, prmt.prmt_parametro
	, prmt.prmt_tppr_pk
	, 'es_ES' AS p18n_idioma
	, (
		SELECT p18n.p18n_texto
		FROM tbl_parametro_i18n_p18n p18n
		WHERE
			EXISTS (
				SELECT 1
				FROM tbl_parametro_version_prvr prvr
				WHERE prvr.prvr_pk = p18n.p18n_prvr_pk
					AND prvr.prvr_prmt_pk = prdt.prdt_prmt_pk
					AND NOW() BETWEEN prvr.prvr_fini AND COALESCE(prvr.prvr_ffin, NOW())
			)
			AND p18n.p18n_idioma = 'es_ES'
	) AS p18n_texto
FROM
	tbl_parametro_dato_prdt prdt
	LEFT JOIN tbl_parametro_prmt prmt ON
		    prmt.prmt_pk = prdt.prdt_prmt_pk
WHERE
	EXISTS (
		SELECT 1
		FROM tbl_parametro_version_prvr prvr
		WHERE
			prvr.prvr_pk = prdt.prdt_prvr_pk
--			AND prvr.prvr_prmt_pk = 1000498156
			AND NOW() BETWEEN prvr.prvr_fini AND COALESCE(prvr.prvr_ffin, NOW())
	)
ORDER BY prdt.prdt_prvr_pk, prdt.prdt_tpdt_pk
--LIMIT 1000
;



SELECT COUNT(1)
FROM tbl_parametro_prmt prmt
	JOIN tbl_parametro_version_prvr prvr ON
		prvr.prvr_prmt_pk = prmt.prmt_pk
	LEFT JOIN tbl_parametro_i18n_p18n p18n ON
		p18n.p18n_prvr_pk = prvr.prvr_pk
WHERE
	prmt.prmt_tppr_pk IN (20010)
	AND EXISTS (
		SELECT 1 FROM tbl_tipo_parametro_tppr tppr
		WHERE tppr.tppr_pk = prmt.prmt_tppr_pk
			AND ( tppr.tppr_es_i18n = 0 OR p18n.p18n_idioma = 'es_ES' )
	)
	AND NOW() BETWEEN prvr.prvr_fini AND coalesce(prvr.prvr_ffin, NOW())
;



SELECT COUNT(1)
FROM tbl_parametro_prmt prmt
WHERE
	prmt.prmt_tppr_pk IN (20010)
	AND EXISTS (
		SELECT 1 FROM tbl_parametro_version_prvr prvr
		WHERE prvr.prvr_prmt_pk = prmt.prmt_pk
			AND NOW() BETWEEN prvr.prvr_fini AND coalesce(prvr.prvr_ffin, NOW())
	)
;


SELECT
	prmt.prmt_pk, prmt.prmt_tppr_pk, prmt.prmt_parametro , prvr.prvr_pk, prvr.prvr_fini, prvr.prvr_ffin , p18n.p18n_idioma, p18n.p18n_texto
FROM tbl_parametro_prmt prmt JOIN
	tbl_parametro_version_prvr prvr ON
		prvr.prvr_prmt_pk = prmt.prmt_pk
	LEFT JOIN tbl_parametro_i18n_p18n p18n ON
		p18n.p18n_prvr_pk = prvr.prvr_pk
WHERE prmt.prmt_tppr_pk IN (20010)
	AND EXISTS (
		SELECT 1 FROM tbl_tipo_parametro_tppr tppr
		WHERE tppr.tppr_pk = prmt.prmt_tppr_pk
			AND ( tppr.tppr_es_i18n = 0 OR p18n.p18n_idioma = 'es_ES' )
	)
	AND NOW() BETWEEN prvr.prvr_fini AND coalesce(prvr.prvr_ffin, NOW())
ORDER BY prmt.prmt_tppr_pk, prmt.prmt_parametro
LIMIT 350
;
