SELECT *
FROM tbl_valoracion_vlrc
;


SELECT * FROM tbl_factura_fctr
;

SELECT 
    vlrc_aspc_pk AS fctr_aspc_pk
    , vlrc_pagador_prmt_pk AS fctr_pagador_prmt_pk
    , NULL AS fctr_fcsr_pk
    , NULL AS fctr_numero
    , SYSDATE AS fctr_fref
    , SYSDATE AS fctr_falta
    , NULL AS fctr_fini
    , NULL AS fctr_ffin
    , NULL AS fctr_estado
    , vlrc_es_suj_pasivo AS fctr_es_suj_pasivo
    , vlrc_info1 AS fctr_info1
    , vlrc_info2 AS fctr_info2
    , vlrc_info3 AS fctr_info3
    , vlrc_info4 AS fctr_info4
    , vlrc_info5 AS fctr_info5
    , vlrc_info6 AS fctr_info6
    , NULL AS fctr_anulada_pk
    
    , vlrc_pk, vlrc_srvc_pk, vlrc_aspc_pk, vlrc_pagador_prmt_pk, vlrc_fctr_pk, vlrc_fref, vlrc_fliq
    , vlrc_falta, vlrc_fini, vlrc_ffin, vlrc_es_suj_pasivo, vlrc_cod_exen
    , vlrc_info1, vlrc_info2, vlrc_info3, vlrc_info4, vlrc_info5
FROM tbl_valoracion_vlrc
ORDER BY vlrc_fref
;



SELECT COUNT(1) FROM tbl_valoracion_det_vlrd;

SELECT count(1) FROM (SELECT 1 FROM tbl_valoracion_det_vlrd WHERE ROWNUM <= 1000 + 1) sql;

tbl_valoracion_det_vlrd;

