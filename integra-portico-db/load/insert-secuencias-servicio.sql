-- Secuencias de Servicios - postgres
INSERT INTO portico.tbl_servicio_secuencia_srsc (srsc_tpsr_pk, srsc_subp_pk, srsc_anno, srsc_ultimo_numero)
SELECT tpsr_pk, prmt_pk, UNNEST(ARRAY['2015', '2014', '2013', '2012', '2011', '2010', '2009']), 0
FROM portico.tbl_parametro_prmt, portico.tbl_tipo_servicio_tpsr
WHERE prmt_tppr_pk = 20063
;



-- Secuencias de Servicios - oracle
INSERT INTO portico.tbl_servicio_secuencia_srsc (srsc_tpsr_pk, srsc_subp_pk, srsc_anno, srsc_ultimo_numero)
SELECT tpsr_pk, prmt_pk, anio, 0
FROM
	portico.tbl_parametro_prmt
	, portico.tbl_tipo_servicio_tpsr
	, (
		Select (Rownum + 2006) anio
		From
			dual
		Connect By Rownum <= 10
	)
WHERE prmt_tppr_pk = 20063
;
