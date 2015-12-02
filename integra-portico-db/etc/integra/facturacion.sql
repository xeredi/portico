SELECT
    tata_id, tata_codigo, tata_codigo_sub, tata_codigo_extension, tata_codigo_modulo
    , tthi_fecha_ini_vigencia, tthi_fecha_fin_vigencia, tthi_descripcion, tthi_es_obligatoria
    , tthi_es_activo, tthi_es_maestra, tthi_es_multiple, tthi_es_afecta_estadisticas
    , tthi_codigo_normalizado
FROM 
    IFAC_TASATARIFA_TATA tata
    left join IFAC_TATAHISTORICO_TTHI tthi on 
        tthi_tata_id = tata_id
WHERE tata_es_activo = 1
;


select 
    proc_tata_id
    , (
        SELECT tata_codigo FROM ifac_tasatarifa_tata WHERE tata_id = proc_tata_id 
    ) AS tata_codigo
    , proc_entidad_id
    , (
        SELECT ente_nombre FROM icon_entidad_ente WHERE ente_id = proc_entidad_id 
    ) AS entidad_codigo
    , proc_id, proc_codigo, proc_tipo, proc_fecha_inicio, proc_fecha_fin, proc_etiqueta, proc_descripcion, proc_precio_base
    , proc_porcentaje, proc_condicion, proc_formula, proc_ruta_tipo_iva, proc_ruta_pagador, proc_ruta_pagador_altern
    , proc_ruta_es_sujeto_pasivo, proc_ruta_codigo_exencion, proc_coeficiente, proc_codigo_modulo, proc_prioridad
    , proc_ivat_id
    , (SELECT ivat_codigo FROM ifac_ivatipo_ivat WHERE ivat_id = proc_ivat_id) AS ivat_codigo
    , proc_es_sujeto_pasivo
from 
    IFAC_PROCEDIMIENTO_PROC proc
WHERE 
    proc_es_activo = 1
ORDER BY proc_entidad_id, proc_tata_id, proc_tipo
;