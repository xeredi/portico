-- Secuencias de Servicios - postgres
INSERT INTO portico.tbl_servicio_secuencia_srsc (srsc_tpsr_pk, srsc_subp_pk, srsc_anno, srsc_ultimo_numero)
SELECT tpsr_pk, prto_pk, UNNEST(ARRAY['2017', '2016', '2015', '2014', '2013', '2012', '2011', '2010', '2009']), 0
FROM portico.tbl_puerto_prto, portico.tbl_tipo_servicio_tpsr
;



-- Secuencias de Servicios - oracle
INSERT INTO portico.tbl_servicio_secuencia_srsc (srsc_tpsr_pk, srsc_subp_pk, srsc_anno, srsc_ultimo_numero)
SELECT tpsr_pk, prto_pk, anio, 0
FROM
	portico.tbl_puerto_prto
	, portico.tbl_tipo_servicio_tpsr
	, (
		Select (Rownum + 2006) anio
		From
			dual
		Connect By Rownum <= 12
	)
;
