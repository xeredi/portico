-- Secuencias de Servicios
INSERT INTO tbl_servicio_secuencia_srsc (srsc_tpsr_pk, srsc_subp_pk, srsc_anno, srsc_ultimo_numero)
SELECT tpsr_pk, prmt_pk, UNNEST(ARRAY['2015', '2014', '2013', '2012', '2011', '2010', '2009']), 0
FROM tbl_parametro_prmt, tbl_tipo_servicio_tpsr
WHERE prmt_tppr_pk = 20063
;



